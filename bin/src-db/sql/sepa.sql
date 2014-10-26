/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): 2012-04-12 M.Hinrichs created
***************************************************************************************************************************************************
Part of SEPA-Export (remittance)
*****************************************************/
-- \..\sepa.sql

-- Verbindung Tabelle zu Triggerfunktion loeschen (Trigger-Objekt bleibt erhalten)
SELECT zsse_droptrigger('zsfi_sepa_export_data_trg', 'zsfi_sepa_export_data');
SELECT zsse_droptrigger('zsfi_sepa_export_dataline_01_trg', 'zsfi_sepa_export_dataline');
SELECT zsse_droptrigger('zsfi_sepa_export_dataline_02_trg', 'zsfi_sepa_export_dataline');

CREATE OR REPLACE FUNCTION public.zsfi_sepa_export_data_trg ()
RETURNS trigger AS
$BODY$
DECLARE
  v_glStatus   CHARACTER VARYING;
  v_bic        CHARACTER VARYING;
  v_GrpHdr_Nm  CHARACTER VARYING;
BEGIN
  IF AD_isTriggerEnabled() = 'N' THEN
    IF TG_OP = 'DELETE' THEN  RETURN OLD; ELSE RETURN NEW; END IF;
  END IF;
  
  IF (TG_OP = 'INSERT') THEN
    delete from zsfi_sepa_export_dataline;
    delete from zsfi_sepa_export_data;
    SELECT cln.name
    INTO v_GrpHdr_Nm
    FROM ad_client cln, ad_org org
    WHERE 1=1
     AND cln.ad_client_id = org.ad_client_id
     AND cln.ad_client_id = new.ad_client_id;

    NEW.GrpHdr_Nm      := v_GrpHdr_Nm;
    NEW.grphdr_credttm:=REPLACE((SELECT to_char(now(), 'YYYY-MM-DD#HH24:MI:SS')),'#','T');
--  NEW.GrpHdr_NbOfTxs := 0;   -- DEFAULT=0
--  NEW.GrpHdr_CtrlSum := 0;   -- DEFAULT=0
  END IF;
  /*
  IF (TG_OP = 'UPDATE') OR (TG_OP = 'INSERT') THEN
    SELECT glstatus INTO v_glStatus FROM zsfi_sepa_export_data WHERE zsfi_sepa_export_data_id = NEW.zsfi_sepa_export_data_id;
    IF (TG_OP = 'UPDATE') THEN
       -- Cancelling Lines with a process is allowed on Posted Lines
       IF (NEW.glstatus = 'CA' AND OLD.glstatus = 'PO') THEN
          v_glStatus = 'OP';
       END IF;
    END IF;
  END IF;
  IF (TG_OP = 'DELETE') THEN
     SELECT glstatus INTO v_glStatus FROM zsfi_sepa_export_data WHERE zsfi_sepa_export_data_id = old.zsfi_sepa_export_data_id;
  END IF;
  */
  IF v_glStatus <> 'OP' then
      RAISE EXCEPTION '%', '@zsfi_NotOpenMacct@' ; -- ??
      RETURN OLD;
  END IF;
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;
  END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE COST 100;

CREATE TRIGGER zsfi_sepa_export_data_trg
  BEFORE INSERT OR UPDATE OR DELETE
  ON public.zsfi_sepa_export_data FOR EACH ROW
  EXECUTE PROCEDURE public.zsfi_sepa_export_data_trg();


CREATE OR REPLACE FUNCTION public.zsfi_sepa_export_dataline_01_trg ()
RETURNS trigger AS
$BODY$
DECLARE
  v_glStatus             CHARACTER VARYING;

  v_PmtInf_Dbtr_Nm       CHARACTER VARYING;
  v_PmtInf_DbtrAcct_IBAN CHARACTER VARYING;
  v_PmtInf_DbtrAgt_BIC   CHARACTER VARYING;

  v_NbOfTxs              NUMERIC;
  v_CtrlSum              NUMERIC;

  v_CdtrAgt_BIC          CHARACTER VARYING;
  v_Cdtr_Nm              CHARACTER VARYING;
  v_CdtrAcct_IBAN        CHARACTER VARYING;
  v_count numeric;
BEGIN
  IF AD_isTriggerEnabled() = 'N' THEN
    IF TG_OP = 'DELETE' THEN  RETURN OLD; ELSE RETURN NEW; END IF;
  END IF;

  IF (TG_OP = 'INSERT') THEN
   -- Daten fuer Auftraggeber ermitteln
   SELECT
     -- cln.ad_client_id,
     replace(org.name,'&','&amp;') AS Dbtr_Nm, bacc.iban AS DbtrAcct_IBAN, c_bank.swiftcode AS DbtrAgt_BIC
    INTO  v_PmtInf_Dbtr_Nm,   v_PmtInf_DbtrAcct_IBAN,            v_PmtInf_DbtrAgt_BIC
    FROM  ad_org org, c_bank, c_bankaccount bacc
    WHERE bacc.c_bank_id = c_bank.c_bank_id
     AND bacc.c_bankaccount_id = new.c_bankaccount_id   -- 'SEPA_C_BANKACCOUNT_ID_0000000000'
     AND org.ad_org_id = new.ad_org_id;           -- 'C726FEC915A54A0995C568555DA5BB3C'

    IF isEmpty(v_PmtInf_Dbtr_Nm) THEN
      RAISE EXCEPTION '%', 'Name fuer Auftraggeber (' || (select name from c_bank,c_bankaccount where c_bank.c_bank_id=c_bankaccount.c_bank_id limit 1) || ') nicht gefunden.';
    END IF;
    IF isEmpty(v_PmtInf_DbtrAcct_IBAN) THEN
      RAISE EXCEPTION '%', 'IBAN fuer Auftraggeber (' ||  v_PmtInf_Dbtr_Nm||', Bank: '|| (select name from c_bank,c_bankaccount where c_bank.c_bank_id=c_bankaccount.c_bank_id limit 1) || ') nicht gefunden.';
    END IF;
    IF isEmpty(v_PmtInf_DbtrAgt_BIC) THEN
      RAISE EXCEPTION '%', 'BIC fuer Auftraggeber (' ||  v_PmtInf_Dbtr_Nm||', Bank: '|| (select name from c_bank,c_bankaccount where c_bank.c_bank_id=c_bankaccount.c_bank_id limit 1)  || ') nicht gefunden.';
    END IF;

    -- Daten fuer Ueberweisungs-Empfaenger ermitteln
    SELECT
   -- bpacc.c_bp_bankaccount_id, bp.c_bpartner_id,
       bpacc.swiftcode,   replace(bp.name,'&','&amp;'),      bpacc.iban
    INTO v_CdtrAgt_BIC, v_Cdtr_Nm, v_CdtrAcct_IBAN
    FROM c_bp_bankaccount bpacc, c_bpartner bp
    WHERE 1=1
     AND bpacc.c_bpartner_id = bp.c_bpartner_id
     AND bpacc.c_bp_bankaccount_id = new.c_bp_bankaccount_id;  -- 'SEPA_c_bp_bankaccount_id_0000002';

    IF isEmpty(new.c_bp_bankaccount_id) THEN
      RAISE EXCEPTION '%', 'Keine Bankverbindung fuer Ueberweisungs-Empfaenger vorhanden.';
    END IF;
    IF isEmpty(v_CdtrAgt_BIC) THEN
      RAISE EXCEPTION '%', 'BIC fuer Ueberweisungs-Empfaenger ' || COALESCE(v_Cdtr_Nm, 'Ueberweisungs-Empfaenger') || ' nicht gefunden.';
    END IF;
    IF isEmpty(v_Cdtr_Nm) THEN
      RAISE EXCEPTION '%', 'Name fuer Ueberweisungs-Empfaenger ' || COALESCE(v_Cdtr_Nm, 'Ueberweisungs-Empfaenger') || ' nicht gefunden.';
    END IF;
    IF isEmpty(v_CdtrAcct_IBAN) THEN
      RAISE EXCEPTION '%', 'IBAN-Konto fuer Ueberweisungs-Empfaenger ' || COALESCE(v_Cdtr_Nm, 'Ueberweisungs-Empfaenger') || ' nicht gefunden.';
    END IF;

    NEW.PmtInf_Dbtr_Nm       := v_PmtInf_Dbtr_Nm;
    NEW.PmtInf_DbtrAcct_IBAN := v_PmtInf_DbtrAcct_IBAN;
    NEW.PmtInf_DbtrAgt_BIC   := v_PmtInf_DbtrAgt_BIC;
    NEW.CdtrAgt_BIC          := v_CdtrAgt_BIC;
    NEW.Cdtr_Nm              := v_Cdtr_Nm;
    NEW.CdtrAcct_IBAN        := v_CdtrAcct_IBAN;

  END IF;

  /*
  IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
    SELECT glstatus INTO v_glStatus FROM zsfi_sepa_export_dataline WHERE zsfi_sepa_export_dataline_id = NEW.zsfi_sepa_export_dataline_id;
    IF (TG_OP = 'UPDATE') THEN
       -- Cancelling Lines with a process is allowed on Posted Lines
       IF (NEW.glstatus = 'CA' AND OLD.glstatus = 'PO') THEN
          v_glStatus = 'OP';
       END IF;
    END IF;
  END IF;
  */
  IF (TG_OP = 'DELETE') THEN
     SELECT glstatus INTO v_glStatus FROM zsfi_sepa_export_dataline WHERE zsfi_sepa_export_dataline_id = old.zsfi_sepa_export_dataline_id;
  END IF;
  IF v_glStatus <> 'OP' then
      RAISE EXCEPTION '%', '@zsfi_NotOpenMacct@' ; -- ??
      RETURN OLD;
  END IF;
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;
  END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE COST 100;

CREATE TRIGGER zsfi_sepa_export_dataline_01_trg
  BEFORE INSERT OR UPDATE OR DELETE
  ON public.zsfi_sepa_export_dataline FOR EACH ROW
  EXECUTE PROCEDURE public.zsfi_sepa_export_dataline_01_trg();


CREATE OR REPLACE FUNCTION public.zsfi_sepa_export_dataline_02_trg ()
RETURNS trigger AS
$BODY$
DECLARE
-- SELECT zsse_droptrigger('zsfi_sepa_export_dataline_02_trg', 'zsfi_sepa_export_dataline');
  v_glStatus             CHARACTER VARYING;
  v_export_data_id       CHARACTER VARYING;
  v_NbOfTxs              NUMERIC;
  v_CtrlSum              NUMERIC;
BEGIN
 -- AFTER-TIGGER: Zaehlen und Aufsummieren aller export_dataline in export_data
  IF AD_isTriggerEnabled() = 'N' THEN
    IF TG_OP = 'DELETE' THEN  RETURN OLD; ELSE RETURN NEW; END IF;
  END IF;

  IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
    SELECT glstatus, zsfi_sepa_export_data_id
    INTO v_glStatus, v_export_data_id
    FROM zsfi_sepa_export_data WHERE zsfi_sepa_export_data_id = new.zsfi_sepa_export_data_id;
  END IF;

  IF (TG_OP = 'DELETE') THEN
    SELECT glstatus, zsfi_sepa_export_data_id
    INTO v_glStatus, v_export_data_id
    FROM zsfi_sepa_export_data WHERE zsfi_sepa_export_data_id = old.zsfi_sepa_export_data_id;
  END IF;

  IF (v_glStatus <> 'OP') then
      RAISE EXCEPTION '%', '@zsfi_NotOpenMacct@' ; -- ??
      RETURN OLD;
  END IF;

  SELECT
    COUNT(*) AS NbOfTxs, SUM(amt_instdamt) AS CtrlSum
  INTO v_NbOfTxs, v_CtrlSum
  FROM zsfi_sepa_export_dataline dataline WHERE dataline.zsfi_sepa_export_data_id = v_export_data_id;

  UPDATE zsfi_sepa_export_data
  SET
    GrpHdr_NbOfTxs = v_NbOfTxs,
    GrpHdr_CtrlSum = COALESCE(v_CtrlSum, 0)
  WHERE
    zsfi_sepa_export_data.zsfi_sepa_export_data_id = v_export_data_id;

  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;
  END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE COST 100;

CREATE TRIGGER zsfi_sepa_export_dataline_02_trg
  AFTER INSERT OR UPDATE OR DELETE
  ON public.zsfi_sepa_export_dataline FOR EACH ROW
  EXECUTE PROCEDURE public.zsfi_sepa_export_dataline_02_trg();


CREATE or replace FUNCTION zsfi_sepa_export_remittance (
  p_zsfi_sepa_export_data_id   CHARACTER VARYING             -- 'ZSFI_SEPA_EXPORT_DATA_ID_0000001'
)
RETURNS CHARACTER varying
AS $BODY_$
-- SELECT zsfi_sepa_export_remittance('ZSFI_SEPA_EXPORT_DATA_ID_0000001')      as plresult from dual; -- Stapel-ID fuer Ueberweisung
DECLARE
  v_outputFile     VARCHAR;
  v_outputPath     VARCHAR;
  v_now            TIMESTAMP;      -- Ausfuerungsdatum aus now()
  v_fileDateTime   VARCHAR;        -- Ausfuerungsdatum 'YYYYMMDD_HHMMSS'

  v_MsgId          VARCHAR;        -- generierte Identifikation zur Vermeidung von Doppelverarbeitung bei Kreditinstitut
  v_GrpHdr_CreDtTm VARCHAR;        -- SEPA-Datei Erstellungsdatum
  v_GrpHdr_Nm      VARCHAR;        -- Auftraggeber-Name
  v_DbtrAgt_BIC    VARCHAR;

  i                INTEGER := 0;
  j                INTEGER := 0;
  v_GrpHdr_NbOfTxs INTEGER := 0;
  v_GrpHdr_CtrlSum NUMERIC := 0.00;

  v_cmd            VARCHAR := '';
  v_message        VARCHAR := '';
  v_messArray      VARCHAR[];      -- dyn. erweiterbares Array
  v_anzError       INTEGER := 0;   -- Überschrift für Fehlermeldung = v_messArray[0]

  v_PmtInf         VARCHAR[];
  v_CdtTrfTxInf    VARCHAR[];
BEGIN
  v_messArray[v_anzError] := 'SQL: SELECT zsfi_sepa_export_remittance(' || '''' || p_zsfi_sepa_export_data_id || ''')';

  v_now := now();
  v_GrpHdr_CreDtTm := REPLACE((SELECT to_char(v_now, 'YYYY-MM-DD#HH24:MI:SSZ')),'#','T');  -- StarMoney50 mit ending-'Z'
  v_fileDateTime := (SELECT to_char(v_now, 'YYYYMMDD_HH24MISS'));                      --'YYYYMMDD_HH24MISS'

  TRUNCATE TABLE zsfi_sepa_export_xml;

  -- Kopfdaten <GrpHdr> ermitteln
  SELECT
    GrpHdr_MsgId,   GrpHdr_NbOfTxs,   GrpHdr_CtrlSum, TRIM(SUBSTR(GrpHdr_Nm, 1, 70))
  INTO   v_MsgId, v_GrpHdr_NbOfTxs, v_GrpHdr_CtrlSum,           v_GrpHdr_Nm
  FROM zsfi_sepa_export_data sepadata
  WHERE 1=1
   AND sepadata.zsfi_sepa_export_data_id = p_zsfi_sepa_export_data_id
   AND sepadata.glstatus = 'OP'        -- '/tmp/sepa_export_remittance.xml' noch nicht erstellt
   AND sepadata.documentno IS NULL;    -- Dokument-Nummer noch nicht generiert

  v_outputPath:='/tmp/';
  v_outputFile := 'SEPA_CT_' || 'V27_' || v_fileDateTime || '.xml';

  IF (isempty(v_MsgId)) THEN
    v_message := 'Tabelle ''zsfi_sepa_export_data_v'': Feld ''GrpHdr_MsgId'' fuer Auftraggeber ist leer';
    v_anzError := v_anzError + 1;
    v_messArray[v_anzError] := v_message;
  END IF;
  IF (isempty(v_GrpHdr_CreDtTm)) THEN
    v_message := 'Erstellungsdatum (GrpHdr_CreDtTm) für SEPA-Ueberweisungen konnte nicht generiert werden';
    v_anzError := v_anzError + 1;
    v_messArray[v_anzError] := v_message;
  END IF;
  IF (v_GrpHdr_NbOfTxs = 0) THEN
    v_message := 'Tabelle ''zsfi_sepa_export_dataline'': Keine Datenzeilen (Ueberweisungen) gefunden';
    v_anzError := v_anzError + 1;
    v_messArray[v_anzError] := v_message;
  END IF;
  IF (v_GrpHdr_CtrlSum = 0) THEN
    v_message := 'Tabelle ''zsfi_sepa_export_dataline'': Summe der Ueberweisungen ist 0,00';
    v_anzError := v_anzError + 1;
    v_messArray[v_anzError] := v_message;
  END IF;
--IF (isempty(v_dbtracct_bic)) THEN
--  v_message := 'Tabelle ''zsfi_sepa_export_data_v'': Feld ''BIC'' fuer Auftraggeber ist leer';
--  v_anzError := v_anzError + 1;
--  v_messArray[v_anzError] := v_message;
--END IF;
  IF (isempty(v_GrpHdr_Nm)) THEN
    v_message := 'Tabelle ''zsfi_sepa_export_data_v'': Feld ''Name'' fuer Auftraggeber ist leer';
    v_anzError := v_anzError + 1;
    v_messArray[v_anzError] := v_message;
  END IF;
  IF (isempty(v_fileDateTime)) THEN
    v_message := 'Zeitstempel für SEPA-Ueberweisungen konnte nicht generiert werden ';
    v_anzError := v_anzError + 1;
    v_messArray[v_anzError] := v_message;
  END IF;
  IF (isempty(v_outputFile)) THEN
    v_message := 'Dateiname für SEPA-Ueberweisungen konnte nicht generiert werden';
    v_anzError := v_anzError + 1;
    v_messArray[v_anzError] := v_message;
  END IF;

  -- wenn noch kein Fehler in gefunden
  IF (v_anzError = 0) THEN
    -- Ausgabe CCT Credit Transfer Initiation urn:iso:std:iso:20022:tech:xsd:pain.001.002.03 pain.001.002.03.xsd
    -- 001=ISO
    -- 002=mittleren Nummernblock der Namespaces und Namen der Schemadateien
    -- 03=Credit Transfer Initiation: Ueberweisungen / Gutschriften an Kreditoren
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<?xml version="1.0" encoding="UTF-8"?>');
   --INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Document xmlns="urn:iso:std:iso:20022:tech:xsd:pain.001.003.03" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="urn:iso:std:iso:20022:tech:xsd:pain.001.003.03 pain.001.003.03.xsd">');
   INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Document xmlns="urn:iso:std:iso:20022:tech:xsd:pain.001.003.03">');
-- wg StarMoney50 001.001.02
    --INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Document xsi:schemaLocation="urn:iso:std:iso:20022:tech:xsd:pain.001.003.03 pain.001.003.03.xsd">');
    --INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<pain.001.003.03>');                              -- wg StarMoney50 aktiviert

    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<CstmrCdtTrfInitn>');

   -- 1/3 Credit Transfer Initiation = Group Header
   -- Kenndaten, die für alle Transaktionen innerhalb der SEPA-Nachricht gelten
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<GrpHdr>');

    -- Die <MsgID> in Kombination mit der Kunden-ID oder der Auftraggeber- IBAN kann als Kriterium für die Verhinderung einer
    -- Doppelverarbeitung bei versehentlich doppelt eingereichten Dateien dienen und muss somit für jede neue pain- Nachricht
    -- einen neuen Wert enthalten.
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<MsgId>'   || v_MsgId || '</MsgId>');   -- ZKA 'CCTI/VRNWSW/8c2df6ab9568f240ac9020c'
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<CreDtTm>' || v_GrpHdr_CreDtTm || '</CreDtTm>');  -- YYYY-MM-DDTHH24:MI:SSZ ??
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<NbOfTxs>' || v_GrpHdr_NbOfTxs || '</NbOfTxs>');  -- Anzahl Datenzeilen
    --INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<CtrlSum>' || v_GrpHdr_CtrlSum || '</CtrlSum>');  -- max. zwei Nachkomma-St
    --INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Grpg>GRPD</Grpg>');  -- StarMoney50
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<InitgPty>');                                     -- Auftraggeber
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Nm>'      || v_GrpHdr_Nm || '</Nm>');            -- Empfehlung: nur Name verwendenden
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</InitgPty>');
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</GrpHdr>');

   -- 3/3: Credit Transfer Initiation = Transaction Information 1..n / max:9.999.999
   DECLARE
      CUR_export RECORD;
   BEGIN
      i := 0;
      FOR CUR_export IN (
         SELECT
           d.*,
           PmtInf_PmtInfId,      -- VARCHAR(70) NOT NULL,
           PmtInf_ReqdExctnDt,   -- DATE NOT NULL,
           TRIM(SUBSTR(PmtInf_Dbtr_Nm, 1, 70))       AS PmtInf_Dbtr_Nm,       -- VARCHAR(70) NOT NULL,
           TRIM(SUBSTR(PmtInf_DbtrAcct_IBAN, 1, 34)) AS PmtInf_DbtrAcct_IBAN, -- VARCHAR(34) NOT NULL
           TRIM(SUBSTR(PmtInf_DbtrAgt_BIC, 1, 34))   AS PmtInf_DbtrAgt_BIC,   -- VARCHAR(11) NOT NULL

           TRIM(SUBSTR(PmtId_EndToEndId, 1, 34)) AS PmtId_EndToEndId, -- VARCHAR(34),
           Amt_InstdAmt,         -- NUMERIC(11,2) NOT NULL,
           TRIM(SUBSTR(CdtrAgt_BIC, 1, 11))      AS CdtrAgt_BIC,      -- VARCHAR(11) NOT NULL,
           TRIM(SUBSTR(Cdtr_Nm, 1, 70))          AS Cdtr_Nm,          -- VARCHAR(70) NOT NULL,
           TRIM(SUBSTR(CdtrAcct_IBAN, 1, 34))    AS CdtrAcct_IBAN,    -- VARCHAR(34) NOT NULL,
           TRIM(SUBSTR(RmtInf_Ustrd, 1, 140))    AS RmtInf_Ustrd      -- VARCHAR(140) NOT NULL,

        FROM zsfi_sepa_export_data d, zsfi_sepa_export_dataline dataline
        WHERE 1=1
         AND  d.zsfi_sepa_export_data_id = dataline.zsfi_sepa_export_data_id
         AND  d.zsfi_sepa_export_data_id = p_zsfi_sepa_export_data_id
         AND (dataline.Amt_InstdAmt >= 0.01) AND (dataline.Amt_InstdAmt <= 999999999.99)
   --???      AND  dataline.   = p_abic
        )
   LOOP
        i := i + 1;
        if i=1 then -- Absender-Konto nur 1 mal....
            -- 2/3: Credit Transfer Initiation = Payment Instruction Information 1..n / max:9.999.999
            -- Satz von Angaben (z. B. Auftraggeberkonto, Ausführungstermin), welcher für alle Einzeltransaktionen
            -- gilt. Entspricht einem logischen Sammler innerhalb einer physikalischen Datei.
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<PmtInf>');
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<PmtInfId>' || CUR_export.PmtInf_PmtInfId || '</PmtInfId>'); -- Referenz zur eindeutigen Identifizierung des Sammlers -- CCTI/VRNWSW/9/cf22f9ae9669f2473c078
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<PmtMtd>TRF</PmtMtd>');              -- Zahlungsinstrument, Konstante 'TRF'
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<BtchBookg>true</BtchBookg>');       -- Sammelbuchung='true', Einzelbuchung='false' DB?? wg StarMoney50 deaktiviert
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<NbOfTxs>' || v_GrpHdr_NbOfTxs || '</NbOfTxs>');  -- Anzahl Datenzeilen
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<CtrlSum>' || v_GrpHdr_CtrlSum || '</CtrlSum>');  -- max. zwei Nachkomma-St
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<PmtTpInf>');                        -- wg StarMoney50
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<SvcLvl>');                          -- wg StarMoney50
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Cd>SEPA</Cd>');                     -- wg StarMoney50
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</SvcLvl>');                         -- wg StarMoney50
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</PmtTpInf>');                       -- wg StarMoney50

            -- sofern kein gültger Geschäftstag angegeben wurde, durch das überweisende
            -- Kreditinstitut auf den nächsten Geschäftstag umgesetzt
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<ReqdExctnDt>'|| to_char(CUR_export.PmtInf_ReqdExctnDt, 'YYYY-MM-DD') || '</ReqdExctnDt>'); -- Ausführungstermin

            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Dbtr>'); -- Zahler (Auftraggeber)
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Nm>' ||  CUR_export.PmtInf_Dbtr_Nm || '</Nm>');  -- 'Debtor Name'
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</Dbtr>');

            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<DbtrAcct>');                             -- Konto des Zahlers(Auftraggebers) ??CUR_export.Cdtr_Nm
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Id>');
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<IBAN>' || CUR_export.PmtInf_DbtrAcct_IBAN || '</IBAN>'); --
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</Id>');
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</DbtrAcct>');

            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<DbtrAgt>'); -- Institut des Zahlungspflichtigen
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<FinInstnId>');
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<BIC>' || CUR_export.PmtInf_DbtrAgt_BIC || '</BIC>');
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</FinInstnId>');
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</DbtrAgt>');
            INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<ChrgBr>SLEV</ChrgBr>');   -- ChargeBearer=Entgeltverrechnung, recommended StarMoney50 reaktiviert
         end if;

   -- Empfaenger-Informationen
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<CdtTrfTxInf>');  -- Maximale Anzahl Wiederholungen=9.999.999
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<PmtId>');        -- PaymentIdentificationSEPA
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<EndToEndId>' || CUR_export.PmtId_EndToEndId || '</EndToEndId>'); -- 'OriginatorID1235', 'OriginatorID1234'
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</PmtId>');

      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Amt>');          -- AmountTypeSEPA
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<InstdAmt Ccy="EUR">' || CUR_export.Amt_InstdAmt || '</InstdAmt>'); -- beauftragter Betrag '999.99'
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</Amt>');

      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<CdtrAgt>');  -- BranchAndFinancialInstitutionIdentificationSEPA1
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<FinInstnId>');
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<BIC>' || CUR_export.CdtrAgt_BIC || '</BIC>'); --Business Identifier Code, max 11 Stellen
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</FinInstnId>');
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</CdtrAgt>');

      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Cdtr>'); -- Zahlungsempfaenger
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Nm>' || CUR_export.Cdtr_Nm || '</Nm>'); -- max 70 Stellen
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</Cdtr>');

      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<CdtrAcct>'); -- CashAccountSEPA2
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Id>');
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<IBAN>' || CUR_export.CdtrAcct_IBAN || '</IBAN>'); -- Kreditinstitut des Zahlungsempfängers
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</Id>');
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</CdtrAcct>');

      -- Vermögenswirksame Leistungen : Feldgruppe <Purp><cd></cd></Purp> nicht verwendet, da optional

      -- Verwendungszweck
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<RmtInf>');
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('<Ustrd>' || CUR_export.RmtInf_Ustrd || '</Ustrd>'); -- unstrukturiert
      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</RmtInf>');

      INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</CdtTrfTxInf>');
      
   END LOOP;
   END;
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</PmtInf>');
    --INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</pain.001.003.03>');   -- wg StarMoney50 aktiviert
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</CstmrCdtTrfInitn>');  -- wg StarMoney50 deaktiviert
    INSERT INTO zsfi_sepa_export_xml (daten) VALUES ('</Document>');

    v_cmd := 'COPY (SELECT daten FROM zsfi_sepa_export_xml ORDER BY zsfi_sepa_export_xml_id) TO ' || '''' || v_outputPath||v_outputFile || '''';
    EXECUTE(v_cmd);

    v_message := v_outputFile;
    RAISE NOTICE '%', v_message;
    RETURN v_message;

  END IF; -- (v_anzError = 0)

  -- wenn Fehler gefunden, Exception provozieren für Ausgabe Fehlermeldungen
  IF (v_anzError > 0 ) THEN
    RAISE EXCEPTION '%', 'SEPA-Ueberweisungdatei aufgrund von ' || v_anzError || ' Fehler nicht erstellt.'; -- > Exception-Handling
  ELSE
    v_message := 'SUCCESS - SEPA-Ueberweisungdatei: ' || v_outputFile || ' erstellt ' || ' - ' ||  i || ' Ueberweisung(en) ausgegeben.';
    RAISE NOTICE '%', v_message;
    RETURN v_message;
  END IF;

  EXCEPTION
  WHEN OTHERS THEN
    v_message := '@ERROR=' || SQLERRM;

   -- Fehlermeldungen ausgeben
    j := 0;
    LOOP
      IF (v_messArray[j] IS NOT NULL) THEN
        -- RAISE NOTICE '%', v_messArray[j];
        v_message := v_message || '</br>' || v_messArray[j];
      ELSE
        EXIT;
      END IF;
      j := j + 1;
    END LOOP;
    RAISE NOTICE '%', replace(v_message,'</br>',E'\r\n');
--  v_message := '@ERROR=' || SQLERRM;
    RETURN v_message;

END;
$BODY_$
LANGUAGE 'plpgsql' VOLATILE
COST 100;

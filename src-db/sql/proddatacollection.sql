/* ProdDataCollection.sql */

SELECT zsse_DropView ('pdc_barcode_v');
CREATE VIEW pdc_barcode_v AS
  SELECT bp.value AS barcode, 'EMPLOYEE' AS type, u.ad_user_id AS id, '' AS mess, 'zssm_barcode_entity_employee' AS ad_message_value
  FROM ad_user u, c_bpartner bp
  WHERE 1=1
   AND bp.c_bpartner_id = u.c_bpartner_id
   AND bp.isemployee = 'Y'
 UNION
  SELECT l.value AS barcode, 'LOCATOR' AS type, l.m_locator_id AS id, '' AS mess, 'zssm_barcode_entity_locator' AS ad_message_value
  FROM m_locator l
 UNION
  SELECT p.value AS barcode, 'PRODUCT' AS type, p.m_product_id AS id, '' AS mess, 'zssm_barcode_entity_product' AS ad_message_value
  FROM m_product p
 UNION
  SELECT ws.value AS barcode, 'WORKSTEP' AS type, ws.c_projecttask_id AS id, '' AS mess, 'zssm_barcode_entity_workstep' AS ad_message_value
  FROM c_projecttask ws, c_project pro WHERE ws.c_project_id = pro.c_project_id and pro.projectcategory = 'PRO'
 UNION
  SELECT e.columnname AS barcode, 'CONTROL' AS type, e.ad_element_id AS id, '' AS mess, 'zssm_barcode_entity_control' AS ad_message_value
  FROM ad_element e WHERE e.ad_module_id = '000CDBE191604F5A835A3EC3213719E8' AND description like 'CODE-128-code action%'
 UNION 
  SELECT e.columnname AS barcode, 'CALCULATION' AS type, e.ad_element_id AS id, '' AS mess, 'zssm_barcode_entity_calc' AS ad_message_value
  FROM ad_element e WHERE e.ad_module_id = '000CDBE191604F5A835A3EC3213719E8' AND description='scan calc'
 UNION
  SELECT l.serialnumber AS barcode, 'SERIALNUMBER' AS type, l.snr_masterdata_id AS id, '' AS mess, 'zssm_barcode_entity_serialnumber' AS ad_message_value
  FROM snr_masterdata l
 UNION
  SELECT l.batchnumber AS barcode, 'BATCHNUMBER' AS type, l.snr_batchmasterdata_id AS id, '' AS mess, 'zssm_barcode_entity_batchnumber' AS ad_message_value
  FROM snr_batchmasterdata l;

CREATE OR REPLACE FUNCTION pdc_getDataIdFromScan(p_value VARCHAR)
RETURNS SETOF pdc_barcode_v -- value, type, id, mess, ad_message_value
AS $body$
-- SELECT * FROM pdc_getDataIdFromScan('xxxx');
-- SELECT * FROM pdc_getDataIdFromScan('9783939316800');     -- employee
-- SELECT * FROM pdc_getDataIdFromScan('Elektronik');        -- locator
-- SELECT * FROM pdc_getDataIdFromScan('Elektronik-2');
-- SELECT * FROM pdc_getDataIdFromScan('730192IAIEUF0005');  -- product
-- SELECT * FROM pdc_getDataIdFromScan('9783826604935');     -- workstep
-- SELECT * FROM pdc_getDataIdFromScan('bc cancel');         -- SBC_1_Abbrechen
-- SELECT * FROM pdc_getDataIdFromScan('bc next');           -- SBC_2_Naechster
-- SELECT * FROM pdc_getDataIdFromScan('bc readz');          -- SBC_3_Fertig
DECLARE
  v_message  VARCHAR;
  y INTEGER := 0;
  y_cmd VARCHAR := '';

  v_pdc_barcode_v  pdc_barcode_v%ROWTYPE;
  v_resultSet RECORD;
  v_count INTEGER;

  v_type VARCHAR;
  v_id VARCHAR;
  v_mess VARCHAR;
BEGIN
  BEGIN
    FOR v_resultSet IN
     (SELECT * FROM pdc_barcode_v bc  WHERE bc.barcode = p_value)
    LOOP
      y := y + 1;
      RETURN NEXT v_resultSet;
    END LOOP;
    RAISE NOTICE 'value=% y=%', p_value, y;

    IF (y = 0) THEN
      SELECT * FROM pdc_barcode_v INTO v_pdc_barcode_v LIMIT 1; -- ROWTYPE
      v_pdc_barcode_v.barcode := '';
      v_pdc_barcode_v.type := 'UNKNOWN';
      v_pdc_barcode_v.id := '';
      v_pdc_barcode_v.mess := '@zssm_EmptyResultSet@';
      v_pdc_barcode_v.ad_message_value := '';
      RETURN NEXT v_pdc_barcode_v;
    END IF;
/*
    ELSEIF (y = 1) THEN
      RETURN NEXT v_resultSet;

    ELSEIF (y > 1) THEN
 -- SELECT * FROM pdc_getDataIdFromScan('Elektron%');
      FOR v_resultSet IN
        (SELECT * FROM pdc_barcode_v v WHERE v.barcode LIKE p_value || '%') -- ROWTYPE
      LOOP
        v_resultSet.type := 'UNDEFINED';
        v_resultSet.mess := '@zssm_ResultSetAmbiguous@' || ' : ''' || v_resultSet.type || '''';
        RETURN NEXT v_resultSet;
        EXIT;
      END LOOP;
    END IF;
*/
  END;
EXCEPTION
WHEN OTHERS THEN
  v_message := 'SQL_PROC: pdc_getDataIdFromScan()' || SQLERRM;
  RAISE EXCEPTION '%', v_message;
END;
$body$
LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION pdc_isbatchorserialnumber (
  p_consumption_id varchar
)
RETURNS char AS
$body$
/*
Iteriert durch alle Zeilen der Materialentnahme. 
Stellt fest, ob Serien oder Chargennummer erforderlich. 
Zieht die bereits erfassten seriennummern ab
Wenn ein Produkt mit SNR oder CNR gefunden: RETURN 'Y', sonst 'N'
*/
-- SELECT * FROM pdc_isBatchOrSerialnumber('500A31314EEA4CFAA207B9DA07ECB67F'); -- m_internal_consumption_id
DECLARE
  v_isBatchOrSerial CHAR := 'N';
  v_message VARCHAR;
  v_snr numeric;
  v_qty numeric;
BEGIN
  BEGIN
    
    SELECT sum(micl.movementqty) into v_qty
    FROM m_internal_consumptionline micl , m_product p
    WHERE micl.m_product_id = p.m_product_id
       AND ( (p.isbatchtracking = 'Y') OR (p.isserialtracking = 'Y') )
       AND micl.m_internal_consumption_id = p_consumption_id;
   SELECT sum(coalesce(snr.quantity,0)) into v_snr
   FROM m_internal_consumptionline micl ,snr_internal_consumptionline snr , m_product p
      WHERE snr.m_internal_consumptionline_id=micl.m_internal_consumptionline_id and micl.m_product_id = p.m_product_id
       AND ( (p.isbatchtracking = 'Y') OR (p.isserialtracking = 'Y') )
       AND micl.m_internal_consumption_id = p_consumption_id;
    if (coalesce(v_qty,0)-coalesce(v_snr,0))!=0 THEN 
        v_isBatchOrSerial := 'Y';
    END IF;
    RETURN v_isBatchOrSerial;
  END;
EXCEPTION
WHEN OTHERS THEN
  v_message := 'SQL_PROC: pdc_isBatchOrSerialnumber()' || SQLERRM;
  RAISE EXCEPTION '%', v_message;
END;
$body$
LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION pdc_getSerialOrBatchType(
  p_value VARCHAR,
  p_product_id VARCHAR
 )
RETURNS VARCHAR -- BATCH, SERIAL, NONE
AS $body$
/*
Funktion: pdc_getSerialOrBatchType(value,m_product_id) return varchar
Testen in snr_serialnumbertracking, ob der Eintrag als lotnumber oder serialnumber fuer das produkt vorhanden ist. 
Wenn lotnumber: Return 'BATCH', wenn serialnumber return 'SERIAL', wenn nix return 'NONE'
*/
-- SELECT * FROM pdc_getSerialOrBatchType('324342', 'F2EC9FF85DB34C8A964DFD17B915449E'); -- barcode, m_product_id
DECLARE
  v_SerialOrBatchType VARCHAR := 'NONE';
  v_message VARCHAR;
BEGIN
  BEGIN
    SELECT
    CASE WHEN (NOT isempty(snr.serialnumber)) THEN 'SERIAL'
         WHEN (NOT isempty(snr.lotnumber)) THEN 'BATCH' 
         ELSE 'NONE'
    END AS number
    INTO v_SerialOrBatchType
--      , p.m_product_id, p.value, p.name, p.isserialtracking, p.isbatchtracking, p.upc, snr.lotnumber, snr.serialnumber
--      , snr.*
    FROM snr_serialnumbertracking snr
    WHERE  snr.m_product_id = p_product_id
     AND snr.serialnumber = p_value OR snr.lotnumber = p_value
    LIMIT 1;
    
    RETURN COALESCE(v_SerialOrBatchType, 'NONE');
  END;
EXCEPTION
WHEN OTHERS THEN
  v_message := 'SQL_PROC: pdc_getDataIdFromScan()' || SQLERRM;
  RAISE EXCEPTION '%', v_message;
END;
$body$
LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION pdc_getProductIdFromSerialOrBatchNumber(
  p_value VARCHAR,
  p_consumption_ID VARCHAR
 )
RETURNS VARCHAR -- m_product_id
/*
Funktion: pdc_getProductIdFromSerialOrBatchNumber(value, consumptionID) RETURNS VARCHAR
Als Value kann eine Seriennummer oder eine Chargennummer gescannt worden sein.
Iteration in m_internal_consumptionline zu der o.a. consumptionId.
Abfrage, ob m_product_id snr oder chargennummer hat. 
Abfrage, in m_product ob zu m_product_id isserialtracking='Y' oder isbatchtracking='Y'
Wenn ja:
Pruefen, ob ein Eintrag der Seriennummer oder Chargennummer in snr_serialnumbertracking existiert.
Wenn ja, product_id merken, iteration weiterfuehren
Wenn 1 m_product_id gefunden: RETURN m_product_id.
Wenn >1 gefunden RETURN: NOSINGLEPRODUCT
Wenn 0 gefunden RETURN: UNDEFINED
*/
AS $body$
DECLARE
  y INTEGER := 0;
  v_message  VARCHAR;
  v_ProductIdFromSerialOrBatchNumber VARCHAR := 'UNDEFINED';
  v_resultSet RECORD;
  v_undefined VARCHAR := 'UNDEFINED';
  v_noSingleProduct VARCHAR := 'NOSINGLEPRODUCT';
BEGIN
  BEGIN
    FOR v_resultSet IN (
     SELECT
   --   p.m_product_id, p.value, p.name, p.isserialtracking, p.isbatchtracking, p.upc -- , snr.lotnumber, snr.serialnumber
   -- , micl.m_internal_consumption_id, micl.m_internal_consumptionline_id
       distinct snr.m_product_id
   -- , snr.lotnumber, snr.serialnumber
   -- , micl.*
   
      FROM m_internal_consumptionline micl, m_product p
      , snr_serialnumbertracking snr
      WHERE micl.m_product_id = p.m_product_id
       AND snr.m_product_id = p.m_product_id
       AND ( (p.isbatchtracking = 'Y') OR (p.isserialtracking = 'Y') )      -- m_product
       AND snr.m_product_id = micl.m_product_id
       AND (snr.serialnumber = p_value OR snr.lotnumber = p_value )        -- barcode = '324342'
       AND micl.m_internal_consumption_id = p_consumption_id -- '13030CE3B5AE467BAC62B9419AD82DD3', '500A31314EEA4CFAA207B9DA07ECB67F'
     ) 
    LOOP
      y := y + 1;
      IF (y = 1) THEN 
        v_ProductIdFromSerialOrBatchNumber := v_resultSet.m_product_id;
      END IF;
    END LOOP;
 -- RAISE NOTICE 'value=% y=%', p_value, y;

    IF (y = 0) THEN
   -- SELECT * FROM pdc_getProductIdFromSerialOrBatchNumber('3 24342', '13030CE3B5AE467BAC62B9419AD82DD3');
      RETURN v_undefined; -- type := 'UNKNOWN', mess := '@zssm_EmptyResultSet@'

    ELSEIF (y = 1) THEN
   -- SELECT * FROM pdc_getProductIdFromSerialOrBatchNumber('324342', '13030CE3B5AE467BAC62B9419AD82DD3');
      RETURN v_ProductIdFromSerialOrBatchNumber;

    ELSEIF (y > 1) THEN
      RETURN v_noSingleProduct; -- type := 'UNDEFINED', mess := '@zssm_ResultSetAmbiguous@'
    END IF;

  END;
EXCEPTION
WHEN OTHERS THEN
  v_message := 'SQL_PROC: pdc_getProductIdFromSerialOrBatchNumber()' || SQLERRM;
  RAISE EXCEPTION '%', v_message;
END;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_dropfunction('pdc_snrtodeliver');
CREATE OR REPLACE FUNCTION pdc_snrtodeliver(
  p_consumption_id VARCHAR,
  OUT product_id VARCHAR,
  OUT qty NUMERIC,
  OUT isSerialtracking CHAR(1),
  OUT isBatchtracking CHAR(1),
  OUT lotNumber VARCHAR,
  OUT isCreated CHAR(1),
  OUT locator_id VARCHAR,
  OUT internal_consumptionline_id VARCHAR,
  OUT inoutline_id VARCHAR
 )
RETURNS SETOF record -- prd, qty, isSrlTrk, isBtchTrk, lot, isCrt
AS $body$
/*
Funktion pdc_snrtodeliver(consumption id in) returns setof
produkt,menge,snrErforderlich,ChargenummerErforderlich,AktuelleChargennummer,NeuvergabeProduziert.
Ermittelt die noch zu bearbeitenden Produkte fuer Seriennummern bzw. Chargennummern-Erfassung.

Ermittlung Menge: Menge aus internal_consumptionline abzueglich Mengen aus snr_consumptionline.
Das ergibt die noch zu bearbeitende Menge.

AktuelleChargennummer ist nur bei Produkten mit SNR und Chargennummer gefuellt,
wenn bereits eine Chargennummer erfasst wurde, aber noch Seriennummern zu erfassen sind.
Hierzu den juengsten Datensatz aus snr_internal_consumptionline fuer dieses Produkt heranziehen.
*/
DECLARE
  y INTEGER := 0;
  z INTEGER := 0;
  v_message  VARCHAR;
  v_resultSet RECORD;
BEGIN
  BEGIN
--  RAISE NOTICE 'p_consumption_id=%', p_consumption_id;
    FOR v_resultSet IN
     (
      SELECT 
        icl.m_product_id, icl.movementqty, icl.description, icl.m_locator_id,icl.m_internal_consumptionline_id
      , p.name, p.isserialtracking, p.isbatchtracking
      , COALESCE((SELECT SUM(snricl.quantity) FROM snr_internal_consumptionline snricl WHERE snricl.m_internal_consumptionline_id = icl.m_internal_consumptionline_id),0) AS snricl_quantity
      , CASE WHEN ( (p.isbatchtracking = 'Y') AND (p.isserialtracking = 'Y') ) THEN 'Y'
             ELSE                                                                   'N' END AS tracking
      FROM m_internal_consumptionline icl, m_product p
      WHERE icl.m_product_id = p.m_product_id
       AND (p.isserialtracking = 'Y' OR p.isbatchtracking = 'Y' )
       AND icl.m_internal_consumption_id = p_consumption_id
      UNION
      SELECT 
        icl.m_product_id, icl.movementqty, icl.description, icl.m_locator_id,icl.m_inoutline_id as m_internal_consumptionline_id
      , p.name, p.isserialtracking, p.isbatchtracking
      , COALESCE((SELECT SUM(snricl.quantity) FROM snr_minoutline snricl WHERE snricl.m_inoutline_id = icl.m_inoutline_id),0) AS snricl_quantity
      , CASE WHEN ( (p.isbatchtracking = 'Y') AND (p.isserialtracking = 'Y') ) THEN 'Y'
             ELSE                                                                   'N' END AS tracking
      FROM m_inoutline icl, m_product p
      WHERE icl.m_product_id = p.m_product_id
       AND (p.isserialtracking = 'Y' OR p.isbatchtracking = 'Y' )
       AND icl.m_inout_id = p_consumption_id
     )
    LOOP
      y := y + 1;
   -- RAISE NOTICE '  y=%, icl.movementqty=%, snricl_quantity=%', y, v_resultSet.movementqty, v_resultSet.snricl_quantity;
   -- RAISE NOTICE '  tracking=%', v_resultSet.tracking;

    -- OUT-Parameter-Felder belegen
  -- RAISE NOTICE 'v_resultSet.movementqty=%, v_resultSet.snricl_quantity=%', v_resultSet.movementqty, v_resultSet.snricl_quantity;
    IF ( (v_resultSet.movementqty - v_resultSet.snricl_quantity) <> 0) THEN
      z := z + 1;
      product_id := v_resultSet.m_product_id;
      qty := (v_resultSet.movementqty - v_resultSet.snricl_quantity);
      isSerialtracking := v_resultSet.isSerialtracking;
      isBatchtracking := v_resultSet.isBatchtracking;
      locator_id:=v_resultSet.m_locator_id;
      internal_consumptionline_id:=v_resultSet.m_internal_consumptionline_id;
      lotNumber :=
       (SELECT snrcl4lot.lotnumber
        FROM snr_internal_consumptionline snrcl4lot
        WHERE snrcl4lot.m_internal_consumptionline_id = p_consumption_id -- '9966C9ABD3664D0FA52908CD92990E49' -- '13030CE3B5AE467BAC62B9419AD82DD3'
        ORDER BY snrcl4lot.updated DESC LIMIT 1
        );
      isCreated := COALESCE(
       (SELECT
          CASE WHEN (ic.movementtype = 'P+') THEN 'Y' ELSE 'N' END AS GeneratedByProduction_ŃewProducedMaterial
        FROM m_internal_consumption ic WHERE ic.m_internal_consumption_id = p_consumption_id -- '13030CE3B5AE467BAC62B9419AD82DD3')
       ), 'N');

      RETURN NEXT; -- SETOF prd, qty, isSrlTrk, isBtchTrk, lot, isCrt: record zurueckgeben
     END IF;

    END LOOP;

--  RAISE NOTICE 'finished=%', 'pdc_snrtodeliver()';
--  RAISE NOTICE '% candidates found, % records returned', y, z;
  END;
EXCEPTION
WHEN OTHERS THEN
  v_message := 'SQL_PROC: pdc_snrtodeliver()' || SQLERRM;
  RAISE EXCEPTION '%', v_message;
END;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_dropfunction('pdc_getopenworkstep');
CREATE OR REPLACE FUNCTION pdc_getopenworkstep(
  p_userID VARCHAR
 )
RETURNS VARCHAR -- workstep_id
/*
Funktion: pdc_getopenworkstep(userID in) RETURNS VARCHAR
Ermittelt zu einem User den Workstep, an dem dieser aktuell angemeldet ist.
ERmittlung aus zspm_ptaskfeedbackline fuer die userID, hour_from not null, hour_to=null.
Wenn kein DS gefunden: return '';
*/
AS $body$
-- SELECT * FROM pdc_getopenworkstep('0'); -- p_userID
DECLARE
  v_message VARCHAR;
BEGIN
  BEGIN
    RETURN COALESCE(
     (SELECT fbl.c_projecttask_id
      FROM zspm_ptaskfeedbackline fbl
      WHERE ( ( (fbl.hour_from IS NOT NULL) AND (fbl.hour_to IS NULL) )
      AND fbl.ad_user_id = p_userID))
      , '') LIMIT 1;
  END;
EXCEPTION
WHEN OTHERS THEN
  v_message := 'SQL_PROC: pdc_getopenworkstep('''|| p_userID || ''')' || SQLERRM;
  RAISE EXCEPTION '%', v_message;
END;
$body$
LANGUAGE 'plpgsql';

select zsse_DropFunction ('pdc_settimefeedback');
CREATE OR REPLACE FUNCTION pdc_settimefeedback (
  p_org_id varchar,
  p_workstep_id varchar,
  p_user_id varchar,
  p_timestamp timestamp
)
RETURNS varchar AS
$body$
DECLARE
  y INTEGER := 0;
  v_message  VARCHAR;
  v_zspm_ptaskfeedbackline zspm_ptaskfeedbackline%ROWTYPE;
  v_zssm_workstep_v  zssm_workstep_v%ROWTYPE;
  v_c_project_id     VARCHAR;
  v_gui_mess         VARCHAR;      -- dyn. erweiterbares Array
  v_g                INTEGER := -1;
  v_recordCount      INTEGER;
  v_timestamp timestamp:=now();
BEGIN
  IF (p_org_id IS NULL) THEN
    RETURN ''; -- wg XSQL
  END IF;
  IF (p_timestamp IS NOT NULL) THEN
    v_timestamp := p_timestamp;
  END IF;
-- SELECT pdc_settimefeedback('AE3637495E9E4EBFA7E766FE9B97893A', 'E4169A63B193416F88D91905D4776B55', '3F1FCD828F544C89BDB948EB43575BE3', now()::timestamp); -- 'Zusammenbau PC-System'
-- SELECT pdc_settimefeedback('AE3637495E9E4EBFA7E766FE9B97893A', 'F9211A1C7EA449DA999DFE024C22B7BF', '3F1FCD828F544C89BDB948EB43575BE3', NULL); -- 'Allgemein'
-- SELECT pdc_settimefeedback('AE3637495E9E4EBFA7E766FE9B97893A', 'C2A0D112FE234BB08183087B0B331FF7', '3F1FCD828F544C89BDB948EB43575BE3', NULL); -- 'PRP'

-- get workstep according to productionorder (PRO)
  SELECT pdc_ws.* FROM zssm_workstep_v pdc_ws, zssm_productionorder_v pdc_pro  -- projectCategory = 'PRO' only
  INTO v_zssm_workstep_v  -- ROWTYPE
  WHERE 1=1
   AND pdc_ws.zssm_productionorder_v_id = pdc_pro.zssm_productionorder_v_id
   AND pdc_ws.zssm_workstep_v_id = p_workstep_ID;  -- 'E4169A63B193416F88D91905D4776B55';

 -- restrictions
  IF (v_zssm_workstep_v.zssm_workstep_v_id IS NULL) OR (v_zssm_workstep_v.zssm_productionorder_v_id IS NULL) THEN
    RAISE EXCEPTION '%', '@zssm_WorkstepNotFound@'; -- PRO
  ELSE
    v_c_project_id := v_zssm_workstep_v.zssm_productionorder_v_id; --  zspm_ptaskfeedbackline.c_project_id NOT NULL;
  END IF;

 -- select first record to be updated / by limit
  SELECT * FROM zspm_ptaskfeedbackline fbl INTO v_zspm_ptaskfeedbackline
  WHERE 1=1
   AND fbl.c_projecttask_id = p_workstep_ID
   AND fbl.ad_user_id = p_user_ID
  ORDER BY fbl.hour_to DESC LIMIT 1; -- select record (hour_to IS NULL) first
 --
  v_gui_mess:='NO Data found';
  IF (v_zspm_ptaskfeedbackline.zspm_ptaskfeedbackline_id IS NULL) -- no record found in table zspm_ptaskfeedbackline
  OR   (v_zspm_ptaskfeedbackline.hour_to IS NOT NULL)             -- one record to be finished
   THEN
   -- first timefeedback onto this workstep
    INSERT INTO zspm_ptaskfeedbackline (
     -- (v_zssm_workstep_v.taskbegun = 'Y') : managed by trigger
      zspm_ptaskfeedbackline_id,
      ad_client_id,
      ad_org_id,
      createdby,
      updatedby,
      c_project_id,
      c_projecttask_id,
      ad_user_id,
      workdate,
      hour_from,
      hour_to
    )
    VALUES (
      get_uuid(),
      'C726FEC915A54A0995C568555DA5BB3C', --  ad_client_id VARCHAR(32) NOT NULL,
      p_org_ID,                           --  ad_org_id VARCHAR(32) NOT NULL,
      p_user_id,          --  createdby VARCHAR(32) NOT NULL,
      p_user_id,          --  updatedby VARCHAR(32) NOT NULL,
      v_c_project_id,     -- c_project_id VARCHAR(32) NOT NULL,
      p_workstep_ID,      -- c_projecttask_id VARCHAR(32) NOT NULL,
      p_user_id,          -- ad_user_id VARCHAR(32),
      TRUNC(v_timestamp), -- workdate TIMESTAMP WITHOUT TIME ZONE NOT NULL,
      v_timestamp,        -- hour_from TIMESTAMP WITHOUT TIME ZONE,
      NULL                -- hour_to TIMESTAMP WITHOUT TIME ZONE
  --, isprocessed:='Y'    -- set by trigger zspm_ptaskfeedbackline_trg
    );
    v_g := (v_g + 1);
    v_gui_mess := '@TimeFeedbackAdded@';
 -- RAISE NOTICE '%', v_gui_mess[v_g];
  ELSEIF (     (v_zspm_ptaskfeedbackline.zspm_ptaskfeedbackline_id IS NOT NULL) -- record found for update
           AND (v_zspm_ptaskfeedbackline.hour_from IS NOT NULL)
           AND (v_zspm_ptaskfeedbackline.hour_to   IS NULL) ) THEN
    UPDATE zspm_ptaskfeedbackline fbl SET
      hour_to = v_timestamp,
      updatedby = p_user_id,
      updated = now()
    WHERE 1=1
     AND fbl.ad_user_id = p_user_ID
     AND fbl.hour_to IS NULL
     AND fbl.c_projecttask_id = p_workstep_ID;

    v_g := (v_g + 1);
    v_gui_mess := '@TimeFeedbackFinished@';
  END IF;

-- update timefeedback: this user, other worksteps, not finished
  SELECT COUNT(*) FROM zspm_ptaskfeedbackline fbl
  INTO v_recordCount
  WHERE 1=1
   AND fbl.ad_user_id = p_user_ID
   AND fbl.hour_to IS NULL
   AND fbl.c_projecttask_id <> p_workstep_ID;

  IF (v_recordCount >= 1) THEN
    UPDATE zspm_ptaskfeedbackline fbl SET
      hour_to = v_timestamp,
      updatedby = p_user_id,
      updated = now()
    WHERE 1=1
     AND fbl.ad_user_id = p_user_ID
     AND fbl.hour_to IS NULL
     AND fbl.c_projecttask_id <> p_workstep_ID;

    v_g := (v_g + 1);
    v_gui_mess := '@TimeFeedbackFinished@';
  END IF;
  RETURN v_gui_mess;
EXCEPTION
WHEN OTHERS THEN
  v_message := 'SQL_PROC: pdc_settimefeedback()' || SQLERRM;
  RAISE EXCEPTION '%', v_message;
END;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION pdc_PFeedbackUpperGrid(p_workstepid VARCHAR,p_pconsumptionid VARCHAR,p_dconsumptionid VARCHAR, out wsbomid varchar,out outtype varchar, out issuing_locator_out varchar, out m_product_id_out varchar, out returnquantity numeric)RETURNS SETOF RECORD
AS $body$
DECLARE
  v_cur RECORD;
  v_count INTEGER;
  v_goalqty numeric;
  v_producedqty numeric;
  v_plannedqty numeric;
  v_oneqty numeric;
  v_possibleqty numeric:=0;
  v_consumed numeric;
  v_leftqty numeric;
  v_prec numeric;
  v_product varchar;
  v_intransaction numeric;
  i integer;
  v_issuingloc varchar; 
BEGIN
  select count(*) into v_count from c_projecttask pt where pt.c_projecttask_id=p_workstepid and pt.assembly='Y';
  if v_count=1 then --assembling Workstep.
     select qtyproduced,qty,m_product_id ,issuing_locator into v_producedqty,v_plannedqty,v_product,v_issuingloc from c_projecttask where c_projecttask_id=p_workstepid;
     -- 1st assume all production is possible.
     v_possibleqty:=round(v_plannedqty-v_producedqty);
     -- How many Items can be produced??
     FOR v_cur IN (select zspm_projecttaskbom_id as zspm_projecttaskbom_id,qtyreceived as qtyreceived,quantity as quantity,m_product_id 
                   from zspm_projecttaskbom where c_projecttask_id=p_workstepid)
     LOOP
        select uom.stdprecision into v_prec from zspm_projecttaskbom bom,m_product p,c_uom uom where uom.c_uom_id=p.c_uom_id and p.m_product_id=bom.m_product_id and bom.zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id;
        v_oneqty:=round(v_cur.quantity / (case coalesce(v_plannedqty,1) when 0 then 1 else coalesce(v_plannedqty,1) end) , v_prec);
        v_consumed:=v_oneqty*v_producedqty;
        v_leftqty:=v_cur.qtyreceived-v_consumed;
        v_goalqty:=v_oneqty*(v_possibleqty);
        if (v_goalqty>v_leftqty) then
          FOR i IN 0..v_possibleqty LOOP
            v_goalqty:=v_oneqty*i;
            if v_goalqty>v_leftqty then
              v_possibleqty:=i-1;
              EXIT;
            end if;
          END LOOP;
        end if;
     END LOOP;
     -- Offer Possible Production - minus All scanned Production
     select coalesce(sum(movementqty),0) into v_intransaction from m_internal_consumptionline where m_internal_consumption_id=p_pconsumptionid and m_product_id=v_product;
     if v_possibleqty-v_intransaction>0 then
        wsbomid:=get_uuid();
        outtype:='PROD';
        issuing_locator_out:=v_issuingloc;
        m_product_id_out:=v_product;
        returnquantity:=v_possibleqty-v_intransaction;
        if returnquantity>0 then
                RETURN NEXT;
        end if;
     end if;
    -- Offer Rest Material, That cannot be completely built up to the assembly
    FOR v_cur IN (select max(zspm_projecttaskbom_id) as zspm_projecttaskbom_id,sum(qtyreceived) as qtyreceived,sum(quantity) as quantity,m_product_id,issuing_locator 
                  from zspm_projecttaskbom where c_projecttask_id=p_workstepid group by m_product_id,issuing_locator)
    LOOP
        select uom.stdprecision into v_prec from zspm_projecttaskbom bom,m_product p,c_uom uom where uom.c_uom_id=p.c_uom_id and p.m_product_id=bom.m_product_id and bom.zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id;
        v_oneqty:=round(v_cur.quantity / (case coalesce(v_plannedqty,1) when 0 then 1 else coalesce(v_plannedqty,1) end) , v_prec);
        v_consumed:=v_oneqty*(v_producedqty+v_possibleqty);
        v_leftqty:=v_cur.qtyreceived-v_consumed;
        select coalesce(sum(movementqty),0) into v_intransaction from m_internal_consumptionline where m_internal_consumption_id=p_dconsumptionid and m_product_id=v_cur.m_product_id;
        if (v_leftqty-v_intransaction>0) then
            outtype:='MAT';
            wsbomid:=get_uuid();
            issuing_locator_out:=v_cur.issuing_locator;
            m_product_id_out:=v_cur.m_product_id;
            returnquantity:=v_leftqty-v_intransaction;
            if returnquantity>0 then
                RETURN NEXT;
            end if;
        end if;
    END LOOP;
  else -- not assembing workstep
    -- All Mareial received in Workstep shall leave the workstep.
    FOR v_cur IN (select max(zspm_projecttaskbom_id) as zspm_projecttaskbom_id,sum(qtyreceived) as qtyreceived,sum(quantity) as quantity,m_product_id,issuing_locator 
                  from zspm_projecttaskbom where c_projecttask_id=p_workstepid and qtyreceived>0 group by m_product_id,issuing_locator)
    LOOP
      outtype:='MAT';
      select coalesce(sum(movementqty),0) into v_intransaction from m_internal_consumptionline where m_internal_consumption_id=p_dconsumptionid and m_product_id=v_cur.m_product_id;
      issuing_locator_out:=v_cur.issuing_locator;
      m_product_id_out:=v_cur.m_product_id;
      returnquantity:=v_cur.qtyreceived-v_intransaction;
      if returnquantity>0 then
        RETURN NEXT;
      end if;
    END LOOP;
  end if;
END;
$body$
LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION pdc_bc_btn_cancel() RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_btn_cancel()
  RAISE NOTICE 'pdc_bc_btn_cancel()=''%''', '57C99C3D7CB5459BADEC665F78D3D6BC';
  RETURN '57C99C3D7CB5459BADEC665F78D3D6BC';
END ;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION pdc_bc_btn_finish() RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_btn_finish();
  RAISE NOTICE 'pdc_bc_btn_finish=''%''', '48AE377FD5224514A54E9AE666BE5CC7';
  RETURN '48AE377FD5224514A54E9AE666BE5CC7';
END ;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION pdc_bc_btn_next() RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_btn_next()
  RAISE NOTICE 'pdc_bc_btn_next()=''%''', '8521E358B73444A6A999C55CBCCACC75';
  RETURN '8521E358B73444A6A999C55CBCCACC75';
END ;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION pdc_bc_btn_ready() RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_btn_ready()
  RAISE NOTICE 'pdc_bc_btn_ready()=''%''', 'B28DAF284EA249C48F932C98F211F257';
  RETURN 'B28DAF284EA249C48F932C98F211F257';
END ;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION pdc_bc_btn_splitbatch() RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_btn_splitbatch() = 'D0F216CC7D9D4EA0A7528744BB8D544C';
  -- RAISE NOTICE 'pdc_bc_btn_splitbatch=''%''', 'D0F216CC7D9D4EA0A7528744BB8D544C';
  RETURN 'D0F216CC7D9D4EA0A7528744BB8D544C';
END ;
$body$
LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION pdc_bc_dialog_acknowledgement() RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_dialog_acknowledgement () = '56BA860751594541972B4CFF06CB0FC5'
  RAISE NOTICE 'pdc_bc_dialog_acknowledgement=''%''', '56BA860751594541972B4CFF06CB0FC5';
  RETURN '56BA860751594541972B4CFF06CB0FC5';
END ;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION pdc_bc_dialog_material_consumption () RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_dialog_material_consumption() 
  RAISE NOTICE 'pdc_bc_dialog_material_consumption=''%''', 'ADA36B3EF12E4E50BC40A88E4233C330';
  RETURN 'ADA36B3EF12E4E50BC40A88E4233C330';
END ;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION pdc_bc_dialog_material_return () RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_dialog_material_return ()
  RAISE NOTICE 'pdc_bc_dialog_material_return=''%''', 'EDD4E08D4C324816AE3C1B09155A51A6';
  RETURN 'EDD4E08D4C324816AE3C1B09155A51A6';
END ;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION pdc_bc_dialog_timefeedback () RETURNS VARCHAR AS
$body$
BEGIN
  -- SELECT pdc_bc_dialog_timefeedback()
  RAISE NOTICE 'pdc_bc_dialog_timefeedback=''%''', '872C3C326AB64D1EBABDD49A1E138136';
  RETURN '872C3C326AB64D1EBABDD49A1E138136';
END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_dropview('pdc_workstepbom_v');
CREATE VIEW pdc_workstepbom_v (
  pdc_workstepbom_v_id,
  zspm_projecttaskbom_id,
  zssm_workstep_v_id,
  ad_client_id,
  ad_org_id,
  isactive,
  created,
  createdby,
  updated,
  updatedby,
  m_product_id,line,
  qtyrequired,
  qtyreceived,
  receiving_locator,
  issuing_locator,
  m_locator_id,
  description,
-- actualcosamount,
-- constuctivemeasure,
-- rawmaterial,
-- cutoff,
-- qty_plan,
-- qtyreserved,
-- qtyinrequisition,
-- date_plan,
-- planrequisition,
  qty_available
 )
AS
SELECT
  zspmwsbom.zspm_projecttaskbom_id AS pdc_workstepbom_v_id,
  zspmwsbom.zspm_projecttaskbom_id,
  zspmwsbom.c_projecttask_id AS zssm_workstep_v_id,
  zspmwsbom.ad_client_id,
  zspmwsbom.ad_org_id,
  zspmwsbom.isactive,
  zspmwsbom.created,
  zspmwsbom.createdby,
  zspmwsbom.updated,
  zspmwsbom.updatedby,
  zspmwsbom.m_product_id,
  zspmwsbom.line,
  case when t.qty >0 and t.qtyproduced>0 then zspmwsbom.quantity-zspmwsbom.quantity*(t.qtyproduced/t.qty) else zspmwsbom.quantity end AS qtyrequired,
  case when t.qty >0 and t.qtyproduced>0 then zspmwsbom.qtyreceived-zspmwsbom.quantity*(t.qtyproduced/t.qty) else zspmwsbom.qtyreceived end as qtyreceived, -- set by trigger or function
  zspmwsbom.receiving_locator,
  zspmwsbom.issuing_locator,
  zspmwsbom.m_locator_id,
  zspmwsbom.description,
-- zspmwsbom.actualcosamount,
-- zspmwsbom.constuctivemeasure,
-- zspmwsbom.rawmaterial,
-- zspmwsbom.cutoff,
-- zspmwsbom.qty_plan,
-- zspmwsbom.qtyreserved,
-- zspmwsbom.qtyinrequisition,
-- zspmwsbom.date_plan,
-- zspmwsbom.planrequisition,
  m_bom_qty_onhand(zspmwsbom.m_product_id, NULL, zspmwsbom.receiving_locator) AS qty_available
FROM
  zspm_projecttaskbom zspmwsbom,c_projecttask t where t.c_projecttask_id=zspmwsbom.c_projecttask_id;

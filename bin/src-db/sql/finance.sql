CREATE OR REPLACE FUNCTION c_yearperiods(pinstance_id character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/*************************************************************************
  * The contents of this file are subject to the Compiere Public
  * License 1.1 ("License"); You may not use this file except in
  * compliance with the License. You may obtain a copy of the License in
  * the legal folder of your Openbravo installation.
  * Software distributed under the License is distributed on an
  * "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
  * implied. See the License for the specific language governing rights
  * and limitations under the License.
  * The Original Code is  Compiere  ERP &  Business Solution
  * The Initial Developer of the Original Code is Jorg Janke and ComPiere, Inc.
  * Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke,
  * parts created by ComPiere are Copyright (C) ComPiere, Inc.;
  * All Rights Reserved.
  * Contributor(s): Openbravo SL
  * Contributions are Copyright (C) 2001-2009 Openbravo, S.L.
  *
  * Specifically, this derivative work is based upon the following Compiere
  * file and version.
  *************************************************************************
  * $Id: C_YearPeriods.sql,v 1.2 2002/05/22 02:48:28 jjanke Exp $
  ***
  * Title: Create missing standard periods for Year_ID
  * Description:
  ************************************************************************/
  -- Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    v_Year_ID VARCHAR(32); --OBTG:VARCHAR2--
    --
    v_NextNo VARCHAR(32); --OBTG:VARCHAR2--
    v_MonthNo NUMERIC;
    v_StartDate TIMESTAMP;
    Test NUMERIC;
    v_ResultStr VARCHAR(300) ;
    --  C_Year Variables
    v_Client_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_Calendar_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_Year_Str VARCHAR(20) ;
    v_User_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_year_num NUMERIC;
  BEGIN
    --  Update AD_PInstance
    --  DBMS_OUTPUT.PUT_LINE('Updating PInstance - Processing');
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'Y', NULL, NULL) ;
  BEGIN --BODY
    -- Get Parameters
    v_ResultStr:='ReadingParameters';
    FOR Cur_Parameter IN
      (SELECT i.Record_ID,
        p.ParameterName,
        p.P_String,
        p.P_Number,
        p.P_Date
      FROM AD_PInstance i
      LEFT JOIN AD_PInstance_Para p
        ON i.AD_PInstance_ID=p.AD_PInstance_ID
      WHERE i.AD_PInstance_ID=PInstance_ID
      ORDER BY p.SeqNo
      )
    LOOP
      v_Year_ID:=Cur_Parameter.Record_ID;
    END LOOP; -- Get Parameter
    RAISE NOTICE '%','  Record_ID=' || v_Year_ID ;
    --  Get C_Year Record
    RAISE NOTICE '%','Get Year info' ;
    v_ResultStr:='YearNotFound';
    SELECT AD_Client_ID,
      AD_Org_ID,
      C_Calendar_ID,
      Year,
      UpdatedBy
    INTO v_Client_ID,
      v_Org_ID,
      v_Calendar_ID,
      v_Year_Str,
      v_User_ID
    FROM C_Year
    WHERE C_Year_ID=v_Year_ID;
    -- Check the format
    RAISE NOTICE '%','Checking format' ;
    v_ResultStr:='Year not numeric: '||v_Year_Str;
    BEGIN
    SELECT TO_NUMBER(v_Year_Str) INTO v_year_num FROM DUAL;
     -- Postgres hack
     IF (v_year_num IS NULL OR v_year_num<=0) THEN
      RAISE EXCEPTION '%', '@NotValidNumber@'; --OBTG:-20000--
    END IF;
    EXCEPTION
    WHEN OTHERS THEN
      RAISE EXCEPTION '%', '@NotValidNumber@'; --OBTG:-20000--
    END;
    --  Start Date
    RAISE NOTICE '%','Calculating start date' ;
    v_ResultStr:='Year not numeric: '||v_Year_Str;
    SELECT TO_DATE('1/1/'||v_Year_Str, 'MM/DD/YYYY') INTO v_StartDate FROM DUAL;
    RAISE NOTICE '%','Start: '||v_StartDate ;
    -- Loop to all months and add missing periods
    FOR v_MonthNo IN 1..12
    LOOP
      --  Do we have the month already:1
      --      DBMS_OUTPUT.PUT_LINE('Checking Month No: '||v_MonthNo);
      v_ResultStr:='Checking Month '||v_MonthNo;
      SELECT MAX(PeriodNo)
      INTO Test
      FROM C_Period
      WHERE C_Year_ID=v_Year_ID
        AND PeriodNo=v_MonthNo;
      IF Test IS NULL THEN
        -- get new v_NextNo
        SELECT * INTO  v_NextNo FROM AD_Sequence_Next('C_Period', v_Year_ID) ;
        --          DBMS_OUTPUT.PUT_LINE('Adding Period ID: '||v_NextNo);
        INSERT
        INTO C_Period
          (
            C_Period_ID, AD_Client_ID, AD_Org_ID, IsActive,
            Created, CreatedBy, Updated, UpdatedBy,
            C_Year_ID, PeriodNo, StartDate, PeriodType,enddate,
            Name
          )
          VALUES
          (
            v_NextNo, v_Client_ID, v_Org_ID, 'Y',
            TO_DATE(NOW()), v_User_ID, TO_DATE(NOW()), v_User_ID,
            v_Year_ID, v_MonthNo, TO_DATE(ADD_MONTHS(v_StartDate, v_MonthNo-1)), 'S',TO_DATE(ADD_MONTHS(v_StartDate, v_MonthNo))-1,
                (SELECT SUBSTR(name, 1,3) || '-' || SUBSTR(year,3,2) FROM AD_MONTH, C_YEAR WHERE TO_NUMBER(value)=v_MonthNo AND c_year_id=v_Year_ID)
           );
        RAISE NOTICE '%','Month Added' ;
      END IF;
    END LOOP;
    --  Update AD_PInstance
    ---- <<END_PROCEDURE>>
    --  DBMS_OUTPUT.PUT_LINE('Updating PInstance - Finished');
    PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'N', 1, NULL) ;
    RETURN;
  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  --      DBMS_OUTPUT.PUT_LINE('No Data Found Exception');
  v_ResultStr:= '@ERROR=' || SQLERRM;
  PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
  RETURN;
END ; $_$;


CREATE OR REPLACE FUNCTION c_period_process(p_pinstance_id character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/*************************************************************************
  * The contents of this file are subject to the Compiere Public
  * License 1.1 ("License"); You may not use this file except in
  * compliance with the License. You may obtain a copy of the License in
  * the legal folder of your Openbravo installation.
  * Software distributed under the License is distributed on an
  * "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
  * implied. See the License for the specific language governing rights
  * and limitations under the License.
  * The Original Code is  Compiere  ERP &  Business Solution
  * The Initial Developer of the Original Code is Jorg Janke and ComPiere, Inc.
  * Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke,
  * parts created by ComPiere are Copyright (C) ComPiere, Inc.;
  * All Rights Reserved.
  * Contributor(s): Openbravo SL
  * Contributions are Copyright (C) 2001-2009 Openbravo, S.L.
  *
  * Specifically, this derivative work is based upon the following Compiere
  * file and version.
  *************************************************************************
  * $Id: C_Period_Process.sql,v 1.2 2002/05/22 02:48:28 jjanke Exp $
  ***
  * Title: Opens/Closes all PeriodControl for a C_Period
  * Description:
  ************************************************************************/
  -- Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Record_ID_Log VARCHAR(32); --OBTG:VARCHAR2--
  v_Count NUMERIC:=0;
  -- Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Document RECORD;
  
  -- Parameter Variables
  p_Organization C_PeriodControl_Log.AD_Org_ID%TYPE;
  p_IsRecursive C_PeriodControl_Log.IsRecursive%TYPE;
  p_Calendar C_PeriodControl_Log.C_Calendar_ID%TYPE;
  p_Year C_PeriodControl_Log.C_Year_ID%TYPE;
  p_YearName C_Year.Year%TYPE;
  p_PeriodNO C_PeriodControl_Log.PeriodNO%TYPE;
  p_DocBaseType C_PeriodControl_Log.DocBaseType%TYPE;
  p_PeriodAction C_PeriodControl_Log.PeriodAction%TYPE;
  p_Processing C_PeriodControl_Log.Processing%TYPE;
  v_AD_Client_ID C_PeriodControl_Log.AD_Client_ID%TYPE;
  v_status varchar;
  
BEGIN
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
 
BEGIN
    -- Get Parameters
    SELECT Record_ID
    INTO v_Record_ID_Log
    FROM AD_PInstance
    WHERE AD_PInstance_ID=p_PInstance_ID;
    
    SELECT L.AD_Client_ID, L.AD_Org_ID, L.C_Calendar_ID, L.ISRecursive, L.C_Year_ID, C_Year.Year, L.PeriodNO, L.DocBaseType, L.PeriodAction, L.Processing
    INTO v_AD_Client_ID, p_Organization, p_Calendar, p_IsRecursive, p_Year, p_YearName, p_PeriodNO, p_DocBaseType, p_PeriodAction, p_Processing
    FROM C_PeriodControl_Log L, C_Year
    WHERE L.C_PeriodControl_Log_ID=v_Record_ID_Log AND C_Year.C_Year_Id = L.C_Year_Id;
      
    IF (p_Processing='N') THEN 
      
      UPDATE C_PeriodControl_Log
      SET Processing='Y'
      WHERE C_PeriodControl_Log_ID=v_Record_ID_Log;   
      -- Action: Open if not permanently closed
      IF(p_PeriodAction='O') THEN
              
        IF (p_IsRecursive='N') THEN
          FOR Cur_Document IN
            (SELECT C_PERIODCONTROL_ID
              FROM C_PERIODCONTROL, C_PERIOD 
              WHERE C_PERIODCONTROL.C_PERIOD_ID=C_PERIOD.C_PERIOD_ID 
              AND C_PERIOD.C_Year_ID=p_Year
              AND C_PERIODCONTROL.AD_Org_ID=p_Organization
              AND C_PERIOD.EndDate<=(SELECT EndDate FROM C_PERIOD WHERE C_Period.C_Period_ID=p_PeriodNO)
              AND C_PERIODCONTROL.DocBaseType LIKE COALESCE(p_DocBaseType, '%')
            )
          LOOP
            v_Record_ID:=Cur_Document.C_PERIODCONTROL_ID;
            select PeriodStatus into v_status from C_PeriodControl WHERE C_PeriodControl_ID=v_Record_ID;
            if coalesce(v_status,'x')='P' then
                raise exception '%', '@cannotmodifyclosedperiod@';
            end if;
            UPDATE C_PeriodControl
              SET PeriodStatus='O'
            WHERE C_PeriodControl_ID=v_Record_ID
              AND PeriodStatus<>'P';
          END LOOP;
          
        ELSIF (p_IsRecursive='Y') THEN
          FOR Cur_Document IN
            (SELECT C_PERIODCONTROL_ID
              FROM C_PERIODCONTROL, C_PERIOD 
              WHERE C_PERIODCONTROL.C_PERIOD_ID=C_PERIOD.C_PERIOD_ID 
              AND C_PERIOD.C_Year_ID=p_Year
              AND C_PERIODCONTROL.AD_Org_ID IN (SELECT AD_Org_ID
                                                FROM AD_Org 
                                                WHERE AD_ISORGINCLUDED(ad_org.ad_org_id, p_Organization, ad_org.ad_client_id)<>-1)
              AND C_PERIOD.EndDate<=(SELECT EndDate FROM C_PERIOD WHERE C_Period.C_Period_ID=p_PeriodNO)
              AND C_PERIODCONTROL.DocBaseType LIKE COALESCE(p_DocBaseType, '%')
            )
          LOOP
            v_Record_ID:=Cur_Document.C_PERIODCONTROL_ID;    
            select PeriodStatus into v_status from C_PeriodControl WHERE C_PeriodControl_ID=v_Record_ID;
            if coalesce(v_status,'x')='P' then
                raise exception '%', '@cannotmodifyclosedperiod@';
            end if;
            UPDATE C_PeriodControl
              SET PeriodStatus='O'
            WHERE C_PeriodControl_ID=v_Record_ID
              AND PeriodStatus<>'P';
          END LOOP;
        END IF;
        
        -- Action: Close if not permanently closed
      ELSIF(p_PeriodAction='C') THEN
       
        IF (p_IsRecursive='Y') THEN
         FOR Cur_Document IN
            (SELECT C_PERIODCONTROL_ID
              FROM C_PERIODCONTROL, C_PERIOD 
              WHERE C_PERIODCONTROL.C_PERIOD_ID=C_PERIOD.C_PERIOD_ID 
              AND C_PERIOD.C_Year_ID=p_Year
              AND C_PERIODCONTROL.AD_Org_ID IN (SELECT AD_Org_ID
                                                FROM AD_Org 
                                                WHERE AD_ISORGINCLUDED(ad_org.ad_org_id, p_Organization, ad_org.ad_client_id)<>-1)
              AND C_PERIOD.EndDate<=(SELECT EndDate FROM C_PERIOD WHERE C_Period.C_Period_ID=p_PeriodNO)
              AND C_PERIODCONTROL.DocBaseType LIKE COALESCE(p_DocBaseType, '%')
            )
          LOOP
            v_Record_ID:=Cur_Document.C_PERIODCONTROL_ID;   
            select PeriodStatus into v_status from C_PeriodControl WHERE C_PeriodControl_ID=v_Record_ID;
            if coalesce(v_status,'x')='P' then
                raise exception '%', '@cannotmodifyclosedperiod@';
            end if;
            UPDATE C_PeriodControl
              SET PeriodStatus='C'
            WHERE C_PeriodControl_ID=v_Record_ID
              AND PeriodStatus<>'P';
          END LOOP;
       ELSIF (p_IsRecursive='N') THEN
        FOR Cur_Document IN
            (SELECT C_PERIODCONTROL_ID
              FROM C_PERIODCONTROL, C_PERIOD 
              WHERE C_PERIODCONTROL.C_PERIOD_ID=C_PERIOD.C_PERIOD_ID 
              AND C_PERIOD.C_Year_ID=p_Year
              AND C_PERIODCONTROL.AD_Org_ID=p_Organization
              AND C_PERIOD.EndDate<=(SELECT EndDate FROM C_PERIOD WHERE C_Period.C_Period_ID=p_PeriodNO)
              AND C_PERIODCONTROL.DocBaseType LIKE COALESCE(p_DocBaseType, '%')
            )
          LOOP
            v_Record_ID:=Cur_Document.C_PERIODCONTROL_ID;      
            select PeriodStatus into v_status from C_PeriodControl WHERE C_PeriodControl_ID=v_Record_ID;
            if coalesce(v_status,'x')='P' then
                raise exception '%', '@cannotmodifyclosedperiod@';
            end if;
            UPDATE C_PeriodControl
              SET PeriodStatus='C'
            WHERE C_PeriodControl_ID=v_Record_ID
              AND PeriodStatus<>'P';
          END LOOP;
       
       END IF;
        -- Action: Permanently Close
      ELSIF(p_PeriodAction='P') THEN
       IF (p_IsRecursive='Y') THEN
        FOR Cur_Document IN
            (SELECT C_PERIODCONTROL_ID
              FROM C_PERIODCONTROL, C_PERIOD 
              WHERE C_PERIODCONTROL.C_PERIOD_ID=C_PERIOD.C_PERIOD_ID 
              AND C_PERIOD.C_Year_ID=p_Year
              AND C_PERIODCONTROL.AD_Org_ID IN (SELECT AD_Org_ID
                                                FROM AD_Org 
                                                WHERE AD_ISORGINCLUDED(ad_org.ad_org_id, p_Organization, ad_org.ad_client_id)<>-1)
              AND C_PERIOD.EndDate<=(SELECT EndDate FROM C_PERIOD WHERE C_Period.C_Period_ID=p_PeriodNO)
              AND C_PERIODCONTROL.DocBaseType LIKE COALESCE(p_DocBaseType, '%')
            )
          LOOP
            v_Record_ID:=Cur_Document.C_PERIODCONTROL_ID;
            select PeriodStatus into v_status from C_PeriodControl WHERE C_PeriodControl_ID=v_Record_ID;
            if coalesce(v_status,'x')='P' then
                raise exception '%', '@cannotmodifyclosedperiod@';
            end if;
            UPDATE C_PeriodControl  SET PeriodStatus='P'  WHERE C_PeriodControl_ID=v_Record_ID;
          END LOOP;
       ELSIF (p_IsRecursive='N') THEN
        FOR Cur_Document IN
            (SELECT C_PERIODCONTROL_ID
              FROM C_PERIODCONTROL, C_PERIOD 
              WHERE C_PERIODCONTROL.C_PERIOD_ID=C_PERIOD.C_PERIOD_ID 
              AND C_PERIOD.C_Year_ID=p_Year
              AND C_PERIODCONTROL.AD_Org_ID=p_Organization
              AND C_PERIOD.EndDate<=(SELECT EndDate FROM C_PERIOD WHERE C_Period.C_Period_ID=p_PeriodNO)
              AND C_PERIODCONTROL.DocBaseType LIKE COALESCE(p_DocBaseType, '%')
            )
          LOOP
            v_Record_ID:=Cur_Document.C_PERIODCONTROL_ID;
            select PeriodStatus into v_status from C_PeriodControl WHERE C_PeriodControl_ID=v_Record_ID;
            if coalesce(v_status,'x')='P' then
                raise exception '%', '@cannotmodifyclosedperiod@';
            end if;
            UPDATE C_PeriodControl  SET PeriodStatus='P'  WHERE C_PeriodControl_ID=v_Record_ID;
          END LOOP;
       END IF;
      END IF;
      
      
      ---- <<FINISH_PROCESS>>
      --  Update AD_PInstance
      RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
      -- Update C_PeriodControl_Log
      UPDATE C_PeriodControl_Log
      SET Processing='N', Processed='Y'
      WHERE C_PeriodControl_Log_ID=v_Record_ID_Log;     
      
    ELSE
      RAISE EXCEPTION '%', '@OtherProcessActive@'; --OBTG:-20000--
    END IF;
END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr ;
  IF(p_PInstance_ID IS NOT NULL) THEN
    -- ROLLBACK;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
  ELSE
    RAISE EXCEPTION '%', SQLERRM;
  END IF;
END ; $_$;


--
-- Name: fact_acct_reset(character varying); Type: FUNCTION; Schema: public; Owner: tad
--

CREATE OR REPLACE FUNCTION fact_acct_reset(p_pinstance_id character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/*************************************************************************
  * The contents of this file are subject to the Compiere Public
  * License 1.1 ("License"); You may not use this file except in
  * compliance with the License. You may obtain a copy of the License in
  * the legal folder of your Openbravo installation.
  * Software distributed under the License is distributed on an
  * "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
  * implied. See the License for the specific language governing rights
  * and limitations under the License.
  * The Original Code is  Compiere  ERP &  Business Solution
  * The Initial Developer of the Original Code is Jorg Janke and ComPiere, Inc.
  * Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke,
  * parts created by ComPiere are Copyright (C) ComPiere, Inc.;
   * All Rights Reserved.
  * Contributor(s): Openbravo SL, Stefan Zimmermann (2011)
  * Contributions are Copyright (C) 2001-2008 Openbravo, S.L.
  * Contributions are Copyright (C) 2011 Stefan Zimmermann
  *
  * Specifically, this derivative work is based upon the following Compiere
  * file and version.
  *************************************************************************
  * $Id: Fact_Acct_Reset.sql,v 1.4 2003/01/27 06:22:11 jjanke Exp $
  ***
  * Title: Reset Posting Records
  * Description:
  *   Delete Records in Fact_Acct or
  *   Reset Posted
  *   for AD_Client_ID and AD_Table_ID
  *SZ: BUGFIX : Always RESET Accounting Entrys - Otherwise there is CAOS in the GL !
  *    Be aware of Periods and take Time - Parameters
  *    Nearly REWRITTEN Function
  ************************************************************************/
  -- Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Result NUMERIC:=1; -- 0=failure 1=OK
  v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_AD_User_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_AD_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_TableName VARCHAR(48):=''; --OBTG:VARCHAR2--
  -- Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    -- Parameter Variables
    v_AD_Client_ID VARCHAR(32) ; --OBTG:VARCHAR2--
    v_AD_Table_ID VARCHAR(32) ; --OBTG:VARCHAR2--
     
    v_Updated NUMERIC(10):=0;
    v_Deleted NUMERIC(10):=0;
    v_Cmd VARCHAR(2000):=''; --OBTG:VARCHAR2--
    v_rowcount NUMERIC;


    v_openperiod NUMERIC;
    v_datefrom DATE;
    v_dateto DATE;
    Cur_Fact_Acct RECORD;
    v_factgroup character varying;
 BEGIN
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    -- Get Parameters
    v_ResultStr:='ReadingParameters';

    FOR Cur_Parameter IN
      (SELECT i.Record_ID,
        i.AD_User_ID,
        p.ParameterName,
        p.P_String,
        p.P_Number,
        p.P_Date
      FROM AD_PINSTANCE i
      LEFT JOIN AD_PINSTANCE_PARA p
        ON i.AD_PInstance_ID=p.AD_PInstance_ID
      WHERE i.AD_PInstance_ID=p_PInstance_ID
      ORDER BY p.SeqNo
      )
    LOOP
      v_Record_ID:=Cur_Parameter.Record_ID;
      v_AD_User_ID:=Cur_Parameter.AD_User_ID;
      IF(Cur_Parameter.ParameterName='AD_Client_ID') THEN
        v_AD_Client_ID:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  AD_Client_ID=' || v_AD_Client_ID ;
      ELSIF(Cur_Parameter.ParameterName='AD_Table_ID') THEN
        v_AD_Table_ID:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  AD_Table_ID=' || v_AD_Table_ID ;
      ELSIF(Cur_Parameter.ParameterName='DATEFROM') THEN
        v_datefrom:=Cur_Parameter.P_Date;
        RAISE NOTICE '%','  DATEFROM=' || v_datefrom ;
      ELSIF(Cur_Parameter.ParameterName='DATETO') THEN
        v_dateto:=Cur_Parameter.P_Date;
        RAISE NOTICE '%','  DATETO=' || v_dateto ;
      ELSIF(Cur_Parameter.ParameterName='AD_Org_ID') THEN
        v_AD_Org_ID:=Cur_Parameter.P_String;
        IF (v_AD_Org_ID IS NULL) THEN
          v_AD_Org_ID:='0';
        END IF;
        RAISE NOTICE '%','  AD_ORG_ID=' || v_AD_Org_ID ;
      ELSE
        RAISE NOTICE '%','*** Unknown Parameter=' || Cur_Parameter.ParameterName ;
      END IF;
    END LOOP; -- Get Parameter

    
    -- Get AD_Org_ID from the document header (useful when the process is executed from a document)
    IF (v_AD_Table_ID IS NOT NULL AND v_Record_ID IS NOT NULL AND v_Record_ID!='0') THEN
        SELECT TableName
        INTO v_TableName
        FROM AD_Table
        WHERE AD_Table_ID=v_AD_Table_ID;
        IF (v_Record_ID!='0') THEN
         EXECUTE
          'SELECT AD_Org_ID
          FROM ' ||  v_TableName || '
          WHERE ' || v_TableName || '_ID =''' || v_Record_ID || ''' AND AD_CLIENT_ID =''' || v_AD_Client_ID || ''' '
          INTO v_AD_Org_ID;
        END IF;
    END IF;

    RAISE NOTICE '%','  Record_ID=' || v_Record_ID ;
   -- Fact_Acct_Rest - Finish_Process Extension Point
    RAISE NOTICE '%','AD_Client_ID=' || v_AD_Client_ID || ', AD_Table_ID=' || v_AD_Table_ID || ' ' || v_TableName ;
          -- Update Table
    v_ResultStr:='ResetTable:' || v_TableName;
    --SZ: BUGFIX : Always RESET Accounting Entrys - Otherwise there is CAOS in the GL !
    -- Manual Accounting will not be resetted Automatically
    FOR Cur_Fact_Acct IN (
        SELECT DISTINCT Record_ID,ad_client_id,dateacct,ad_org_id,docbasetype,ad_table_id
        FROM FACT_ACCT
        WHERE case when v_AD_Table_ID  is null then 1=1 else AD_TABLE_ID=v_AD_Table_ID end
        AND   ad_org_id=v_AD_Org_ID
        AND ad_client_id=v_AD_Client_ID
        AND case when v_datefrom is null then 1=1 else dateacct>=v_datefrom end
        AND case when v_dateto is null then 1=1 else dateacct<=v_dateto end 
        AND case when v_Record_ID is null then  1=1 when v_Record_ID='0' then 1=1 else record_id=v_Record_ID end
        AND AD_TABLE_ID!='4AF9D81E51A04F2B987CD91AA9EE99F4'
        ) LOOP
        v_ResultStr:='DeleteFact';
        -- SZ delete only in Opened Periods!!!!!
        select count(*) into v_openperiod from c_periodcontrol_v where ad_client_id=Cur_Fact_Acct.ad_Client_id and ad_org_id=Cur_Fact_Acct.ad_Org_id 
                        and isactive='Y' and periodstatus='O' and docbasetype=Cur_Fact_Acct.docbasetype and startdate<=Cur_Fact_Acct.dateacct and enddate>=Cur_Fact_Acct.dateacct;
        -- Tests If open period exists
        if v_openperiod!=1 then
            v_ResultStr:='@ERROR=@zspr_NoOpenPeriod@';
            RAISE EXCEPTION '%', '@zspr_NoOpenPeriod@' ;
            return;
        end if;
        -- SZ Delete the FACTS
        select TableName into v_TableName FROM AD_Table  WHERE AD_Table_ID=Cur_Fact_Acct.ad_table_id;
        v_Cmd:='UPDATE ' || v_TableName  || ' SET Posted=''N'', Processing=''N'' WHERE AD_Client_ID='''  || v_AD_Client_ID
                || ''' AND (Posted<>''N'' OR Posted IS NULL OR Processing<>''N'' OR Processing IS NULL) AND '   ||
                v_TableName||'_ID = '''||Cur_Fact_Acct.Record_ID||'''';
        -- DBMS_OUTPUT.PUT_LINE('  executing: ' || v_Cmd);
        EXECUTE v_Cmd;
        GET DIAGNOSTICS v_rowcount:=ROW_COUNT;
        v_Updated:=v_Updated + v_rowcount;
        RAISE NOTICE '%','  updated=' || v_rowcount ;
        select FACT_ACCT_GROUP_ID into v_factgroup FROM FACT_ACCT  WHERE AD_TABLE_ID=Cur_Fact_Acct.AD_Table_ID  AND Record_ID=Cur_Fact_Acct.Record_ID;
        -- Delete Fact
        DELETE FROM FACT_ACCT  WHERE FACT_ACCT_GROUP_ID=v_factgroup;
        GET DIAGNOSTICS v_rowcount:=ROW_COUNT;
        v_Deleted:=v_Deleted + v_rowcount;
        RAISE NOTICE '%','  deleted=' || v_rowcount ; 
    END LOOP;
    --
    -- Summary info
    v_Message:='@UnpostedDocuments@ = ' || v_Updated || ', @DeletedEntries@ = ' || v_Deleted;
    --||'OR:'||v_AD_Org_ID||'-Cl:'||v_AD_Client_ID||'R:'||coalesce(v_Record_ID,'NOREC')||'-T:'||coalesce(v_AD_Table_ID,'NOTAB')||v_ResultStr||coalesce(v_datefrom,now()+1000)||coalesce(v_dateto,now()+100);
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', v_Result, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  if v_ResultStr!='@ERROR=@zspr_NoOpenPeriod@' then  
      v_ResultStr:= '@ERROR=' || SQLERRM;
  end if;
  RAISE NOTICE '%',v_ResultStr ;
  -- ROLLBACK;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
  RETURN;
END ; $_$;

ALTER FUNCTION public.fact_acct_reset(p_pinstance_id character varying) OWNER TO tad;


/*****************************************************+
Stefan Zimmermann, 10/2010, stefan@zimmermann-software.de



   Implementation of BWA Reporting
   




*****************************************************/
CREATE OR REPLACE FUNCTION zspr_child_bwap(node character varying) RETURNS setof zspr_bwaprefs
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Allows to implement Self-Joins (Like CONNECT TO in ORACLE)
*****************************************************/
i integer;
temp1 character varying;
temp2 character varying;
retval zspr_bwaprefs%rowtype;
--cur_node RECORD;
weiter character varying:='Y';
BEGIN 
    temp2:='select *  from zspr_bwaprefs where parentpref in ('||chr(39)||node||chr(39)||')';
    WHILE weiter='Y'
    LOOP
        weiter:='N';
        for retval in execute temp2
        loop
         if retval.isparent='Y' then 
             if temp1 is null then
                temp1:=chr(39)||retval.zspr_bwaprefs_id||chr(39);
             else
                temp1:=chr(39)||retval.zspr_bwaprefs_id||chr(39)||','||temp1; 
             end if;
             weiter:='Y';
         end if;
         return next retval;
        end loop;
        temp2:='select *  from zspr_bwaprefs where parentpref in ('||temp1||')';
        temp1:= null;
     end loop;
END;
$_$  LANGUAGE 'plpgsql';
     
alter function public.zspr_child_bwap(node character varying) owner to tad;    

CREATE OR REPLACE FUNCTION zsfi_getbwasum(bwapref_id character varying,date_from timestamp without time zone,date_to timestamp without time zone, v_org character varying,isVJ character varying) RETURNS numeric
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Sub-Fuction for BWA-Report
Gets the Total of a specific BWA (All Accounts defined in it)
Part of Finance
*****************************************************/
v_cur RECORD;
v_sum numeric:=0;
v_sum_faktura numeric;
v_sum_nofaktura numeric;
v_sum_orderamt numeric;
v_runratefaktura numeric;
v_runratenofaktura   numeric;
v_runrateorder numeric;
v_ford numeric;
v_verb numeric;
v_return numeric:=0;
v_adddays numeric;
v_acctmatch character varying;
BEGIN 
      if isVJ='Y' then v_adddays:=365; else v_adddays:=0; end if; 
      for v_cur in (select * from zspr_child_bwap(bwapref_id) union select * from zspr_bwaprefs where zspr_bwaprefs_id =bwapref_id)
      LOOP
        if v_cur.isparent='N' then
           -- Statistical Accounts
           select acctmatch into v_acctmatch  from zspr_bwaprefacct where zspr_bwaprefs_id=v_cur.zspr_bwaprefs_id ;
           if v_acctmatch in ('9150','9151','9152','9157','9158','9159') then
                 -- Orders
                 select sum(c_order.invoicedamt),sum(c_order.totallines - c_order.invoicedamt) ,sum(c_order.totallines) ,
                        sum(c_order.invoicedamt * 365 / (select now()::date - '2011-10-04'::date)),
                        sum((c_order.totallines - c_order.invoicedamt) * 365 / (select now()::date - '2011-10-04'::date)),
                        sum(c_order.totallines * 365 / (select now()::date - '2011-10-04'::date))
                 into v_sum_faktura,v_sum_nofaktura,v_sum_orderamt,v_runratefaktura,v_runratenofaktura,v_runrateorder 
                 from c_order where (c_order.docstatus = 'CO' or c_order.docstatus = 'DR')         
                       and ad_get_docbasetype(c_order.c_doctype_id) = 'SOO' 
                       and c_order.dateordered+v_adddays between date_from and date_to 
                       and c_order.ad_org_id=v_org;
                 if v_acctmatch='9150' then v_sum:=v_sum_faktura; end if;
                 if v_acctmatch='9151' then v_sum:=v_sum_nofaktura; end if;
                 if v_acctmatch='9152' then v_sum:=v_sum_orderamt; end if;
                 if v_acctmatch='9157' then v_sum:=v_runratefaktura; end if;
                 if v_acctmatch='9158' then v_sum:=v_runratenofaktura; end if;
                 if v_acctmatch='9159' then v_sum:=v_runrateorder; end if;
           elsif v_acctmatch='9153' then
                 -- Offers
                 select sum(case c_order.completeordervalue when 0 then c_order.totallines else c_order.completeordervalue end) into v_sum
                 from c_order where   (c_order.docstatus = 'CO' or c_order.docstatus = 'DR') 
                      and ad_get_docbasetype(c_order.c_doctype_id) = 'SALESOFFER' 
                       and c_order.dateordered+v_adddays between date_from and date_to 
                       and c_order.ad_org_id=v_org;
           elsif v_acctmatch='9154' then
                 -- Sales Forecast
                  select sum(mrp_salesforecast.linenetamt) into v_sum
                  from mrp_salesforecast where startdate +v_adddays between date_from and date_to and ad_org_id=v_org;
           elsif v_acctmatch in ('9155','9156') then
                 --   'Forderungen' und Verbindlichkleiten
                  select sum(case dp.isreceipt when 'Y' then dp.amount else 0 end),sum(case dp.isreceipt when 'N' then dp.amount else 0 end) 
                  into v_ford,v_verb
                  from c_debt_payment dp where   dp.isvalid='Y' and
                       c_debt_payment_status(dp.c_settlement_cancel_id, dp.cancel_processed, dp.generate_processed, dp.ispaid, dp.isvalid, dp.c_cashline_id, dp.c_bankstatementline_id) in ('P')
                       and dp.dateplanned + v_adddays between date_from and date_to
                       and dp.ad_org_id=v_org;
                  if v_acctmatch='9155' then v_sum:=v_ford; end if;
                  if v_acctmatch='9156' then v_sum:=v_verb; end if;
           else
                 select summe into v_sum from (
                    select CASE WHEN v_cur.isasset='N' THEN (SUM(fact_acct.AMTACCTDR)-SUM(fact_acct.AMTACCTCR)) 
                                              ELSE (SUM(fact_acct.AMTACCTCR)-SUM(fact_acct.AMTACCTDR)) END as summe
                    from fact_acct,zspr_bwaprefacct bwaprefacct where 
                          CASE when v_org!='0' then fact_acct.ad_org_id=v_org else 1=1 END 
                          and v_cur.isactive='Y'  
                          and bwaprefacct.zspr_bwaprefs_id=v_cur.zspr_bwaprefs_id 
                          and fact_acct.dateacct+v_adddays between CASE when v_cur.sumfrombeginning='Y' then to_date('10.10.1900','dd.mm.yyyy') else date_from END and date_to 
                          and fact_acct.ACCTVALUE like replace(bwaprefacct.acctmatch,'*','%')
                          and case when instr(bwaprefacct.acctmatch,'*')>0 then length(fact_acct.ACCTVALUE)=5 else length(fact_acct.ACCTVALUE)=4 end
                          and fact_acct.c_acctschema_id=(select distinct c_acctschema_id from ad_org_acctschema where CASE when v_org!='0' then ad_org_id=v_org else 1=1 END)
                          and bwaprefacct.c_acctschema_id=fact_acct.c_acctschema_id
                    ) a where 
                        case  when v_cur.allwowonlynegative='Y' then summe<0 else 1=1 END 
                        and case  when v_cur.allwowonlypositive='Y' then summe>0 else 1=1 END;
            end if;
            v_return:=v_return+coalesce(v_sum,0);
          end if;
      END LOOP;
      return coalesce(v_return,0);
END;
$_$  LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION zsfi_getfooterbwasum(bwapref_id character varying,date_from timestamp without time zone,date_to timestamp without time zone, v_org character varying,isVJ character varying) RETURNS numeric
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Sub-Fuction for BWA-Report
Gets the Total of a specific BWA (All Accounts defined in it)
Part of Finance
*****************************************************/

v_issuminfooter character varying;
BEGIN 
      select issuminfooter into v_issuminfooter from zspr_bwaprefs where zspr_bwaprefs_id =bwapref_id;
      if v_issuminfooter='Y' then 
         return zsfi_getbwasum(bwapref_id,date_from,date_to, v_org,isVJ); 
      else 
         return 0; 
      end if; 
END;
$_$  LANGUAGE 'plpgsql';






CREATE OR REPLACE FUNCTION zsfi_getacctsum(bwapref_id character varying,p_acct character varying, date_from timestamp without time zone,date_to timestamp without time zone, v_org character varying,isVJ character varying) RETURNS numeric
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Sub-Fuction for BWA-Report
Gets the Total of a specific Account
Part of Finance
*****************************************************/
v_cur RECORD;
v_sum numeric:=0;
v_return numeric:=0;
v_adddays numeric;
BEGIN 
     
      if isVJ='Y' then v_adddays:=365; else v_adddays:=0; end if; 
      for v_cur in (select * from zspr_bwaprefs where zspr_bwaprefs_id =bwapref_id)
      LOOP
           if p_acct in ('ED3D722029254A178FADAF77FCCFFB4C','ED3D722029254A178FADAA77FCCFFB4C','259C9D8DEF014B378F6F2815FAD5C62E','BD3E518F00814221920C6229F6D22C95','10DDDC12DC8447B79751C7AC6BB89293','AA574CAD350247CE918559B162FC8F3E','89AF947DBC61434DA7D7F3E050839C01','BCEE1A6C65D44DDFB5F792CD9C1F0ABB','71A1A23C9B7A41528BDC66FDF9BF4C43','E2622C721BE44A8AAA7453231152F56B')  then
              v_sum:=zsfi_getbwasum(bwapref_id,date_from,date_to,v_org,isVJ);
           else
                 select summe into v_sum from (
                    select CASE WHEN v_cur.isasset='N' THEN (SUM(fact_acct.AMTACCTDR)-SUM(fact_acct.AMTACCTCR)) 
                                              ELSE (SUM(fact_acct.AMTACCTCR)-SUM(fact_acct.AMTACCTDR)) END as summe
                    from fact_acct where 
                          CASE when v_org!='0' then fact_acct.ad_org_id=v_org else 1=1 END 
                          and fact_acct.account_id= p_acct
                          and v_cur.isactive='Y' 
                          and fact_acct.dateacct+v_adddays between CASE when v_cur.sumfrombeginning='Y' then to_date('10.10.1900','dd.mm.yyyy') else date_from END and date_to 
                    ) a where 
                        case  when v_cur.allwowonlynegative='Y' then summe<0 else 1=1 END and
                        case  when v_cur.allwowonlypositive='Y' then summe>0 else 1=1 END;
            end if;
            v_return:=v_return+coalesce(v_sum,0);
      END LOOP;
      return coalesce(v_return,0);
END;
$_$  LANGUAGE 'plpgsql';

alter function zsfi_getacctsum(bwapref_id character varying,p_acct character varying, date_from timestamp without time zone,date_to timestamp without time zone, v_org character varying,isVJ character varying)  owner to tad;   


CREATE OR REPLACE FUNCTION zspr_get_bwastatus(date_from timestamp without time zone,date_to timestamp without time zone, v_org character varying) RETURNS character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Status: vorläufig: wenn nicht alle periode entgültig geschlossen
*****************************************************/
v_count numeric;
BEGIN 
   select count(*) into v_count from C_PeriodControl_V where case when v_org ='0' or v_org is null then 1=1 else ad_org_id=v_org end and startdate between date_to and date_from and enddate between date_to and date_from  and periodstatus!='P';
   if v_count!=0 then
      return 'Vorläufig';
   else
      return 'Vorläufig';
   end if;
END;
$_$  LANGUAGE 'plpgsql';
     
alter function public.zspr_get_bwastatus(date_from timestamp without time zone,date_to timestamp without time zone, v_org character varying) owner to tad;    

CREATE OR REPLACE FUNCTION public.zsfi_getbalanceattime (
  p_org         VARCHAR,   -- ad_org_id
  p_schema      VARCHAR,   -- c_acctschema
  p_acct        VARCHAR,   -- fact_acct
  p_date_from   TIMESTAMP  -- 'YYYY-MM-DD'
)
RETURNS numeric AS
$body$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): 2012-02-21 MaHinrichs: selection p_org_id, factaccttype, isactive
***************************************************************************************************************************************************
Gets the Total of an account to a specific Time
*****************************************************/
  v_count numeric;
  v_Total numeric;
  v_accounttype VARCHAR(60); -- c_elementvalue.accounttype(60)
BEGIN
  --Saldo für Sachkonto ermitteln
  --A=Asset/Aktiva/Anlagen, E=Expense/Kosten, L=Liability/Passiva/Schulden, O=Owners Equity/Eigenkapital, R=Revenue/Ertrag
  SELECT TRIM(accounttype) INTO v_accounttype FROM c_elementvalue WHERE c_elementvalue_id = p_acct AND accounttype in ('A','L','O', 'E', 'R');
  SELECT sum( (CASE WHEN v_accounttype IN ('A', 'E') THEN f.amtacctcr ELSE f.amtacctdr END) - (CASE WHEN v_accounttype IN ('A', 'E') THEN f.amtacctdr ELSE f.amtacctcr END) )
  INTO v_Total
  FROM fact_acct f
  WHERE
       f.account_id = p_acct
   AND f.dateacct < p_date_from
   AND f.ad_org_id = p_org
   AND f.c_acctschema_id = p_schema
   AND f.factaccttype <> 'R'
   AND f.factaccttype <> 'C'
   AND f.isactive = 'Y';
  RETURN COALESCE(v_Total,0);
END;
$body$
LANGUAGE 'plpgsql' VOLATILE;

CREATE OR REPLACE FUNCTION public.zsfi_GetBalanceAmount (
  p_org         VARCHAR,   -- ad_org_id
  p_schema      VARCHAR,   -- c_acctschema
  p_acct        VARCHAR,   -- fact_acct
  p_date_from   TIMESTAMP, -- 'YYYY-MM-DD'
  p_date_until  TIMESTAMP  -- 'YYYY-MM-DD'
)
RETURNS NUMERIC AS
$body$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): 2012-02-20 MaHinrichs source file created
***************************************************************************************************************************************************
*****************************************************/
  v_accounttype VARCHAR(60); -- c_elementvalue.accounttype(60)
  v_Total NUMERIC := 0;
BEGIN
--A=Asset/Aktiva/Anlagen, E=Expense/Kosten (GuV), L=Liability/Passiva/Schulden, O=Owners Equity/Eigenkapital, R=Revenue/Ertrag (GuV)
  SELECT TRIM(accounttype) INTO v_accounttype FROM c_elementvalue WHERE c_elementvalue_id=p_acct AND accounttype in ('A','L','O', 'E', 'R');
  IF (v_accounttype IS NOT NULL) THEN
    SELECT sum( (CASE WHEN v_accounttype IN ('A', 'E') THEN f.amtacctcr ELSE f.amtacctdr END) - (CASE WHEN v_accounttype IN ('A', 'E') THEN f.amtacctdr ELSE f.amtacctcr END) ) INTO v_Total -- (CASE WHEN a IS NULL THEN '' ELSE   END)
    FROM fact_acct f
    WHERE
         f.account_id = p_acct
     AND f.dateacct BETWEEN p_date_from AND p_date_until
     AND f.ad_org_id = p_org
     AND f.c_acctschema_id = p_schema
     AND f.factaccttype <> 'R'
     AND f.factaccttype <> 'C'
     AND f.isactive = 'Y';
    v_Total := COALESCE(v_Total,0);
    RETURN COALESCE(v_Total,0);
  ELSE
    RETURN (0); -- (M) Saldenvorträge etc.
  END IF;
END;
$body$
LANGUAGE 'plpgsql' VOLATILE;

CREATE OR REPLACE FUNCTION zsfi_insertparentbwas()
  RETURNS character varying AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
  Part of finance
  Purpose: BWA's set correct accounts for Parent/Sums
Update Parent- when Accounts in Child are added

*****************************************************/
v_weiter              character varying;
v_parent              character varying;
v_current             character varying;
v_cur                 RECORD;
BEGIN
  delete from zspr_bwaprefacct where exists(select 0 from zspr_bwaprefs where zspr_bwaprefs.zspr_bwaprefs_id=zspr_bwaprefacct.zspr_bwaprefs_id and zspr_bwaprefs.isparent='Y');
  for v_cur in (select * from zspr_bwaprefs where isparent='N') 
  LOOP 
      if v_cur.parentpref is not null then
          v_current:=v_cur.parentpref;
          v_weiter:='Y';
          WHILE v_weiter='Y'
          LOOP
              -- Insert Parent
              insert into zspr_bwaprefacct(ZSPR_BWAPREFACCT_ID, ZSPR_BWAPREFS_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ACCTMATCH,c_acctschema_id)
                 select get_uuid(),v_current,v_cur.AD_CLIENT_ID, v_cur.AD_ORG_ID, v_cur.ISACTIVE, v_cur.CREATED, v_cur.CREATEDBY, v_cur.UPDATED, v_cur.UPDATEDBY,acctmatch,c_acctschema_id
                 from zspr_bwaprefacct where ZSPR_BWAPREFS_ID=v_cur.ZSPR_BWAPREFS_ID;
              -- More Parents??
              select parentpref into v_parent from zspr_bwaprefs where zspr_bwaprefs_id=v_current;
              if v_parent is not null then
                 v_current:=v_parent; 
              else
                 v_weiter:='N';
              end if;
           END LOOP;
      end if;    
   END LOOP;
RETURN 'OK';
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_insertparentbwas() OWNER TO tad;


/*****************************************************+
Stefan Zimmermann, 10/2010, stefan@zimmermann-software.de



   Implementation of Manual Accounting
   
   Accounting BATCH



*****************************************************/

CREATE OR REPLACE FUNCTION zsfi_macctline_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Financials
Status-Checks for Manual Accounting
*****************************************************/
v_temp              character varying;
v_nogo              character varying:='N';

BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  
  if (TG_OP = 'UPDATE') or (TG_OP = 'INSERT') then 
    select glstatus into v_temp from zsfi_manualacct where zsfi_manualacct_id=new.zsfi_manualacct_id;
    if (TG_OP = 'UPDATE') then
       -- Canelling Lines with a process is allowed on Posted Lines
       if (new.glstatus='CA' and old.glstatus='PO') then
          v_temp='OP';
       end if;
    end if;
  end if;
  if (TG_OP = 'DELETE') then
     select glstatus into v_temp from zsfi_manualacct where zsfi_manualacct_id=old.zsfi_manualacct_id;
  end if;
  if v_temp!='OP' then
      RAISE EXCEPTION '%', '@zsfi_NotOpenMacct@' ;
      return OLD;
  end if; 
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_macctline_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_manualacct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Financials
Hotfix: Status-Checks for Manual Accounting
*****************************************************/
v_temp              character varying;
v_nogo              character varying:='N';

BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF; 
  if (old.glstatus!='OP') then
      RAISE EXCEPTION '%', '@zsfi_NotOpenMacct@' ;
      return OLD;
  end if; 
RETURN OLD;  
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_manualacct_trg() OWNER TO tad;




CREATE OR REPLACE FUNCTION zspr_macct_post(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
  Part of finance
  Purpose: Manual accounting. Post GL/Journal
  *****************************************************/
  -- General CONSTs
  v_acctshema character varying;
  v_period character varying;
  v_glcat character varying;
  v_table_id character varying :='4AF9D81E51A04F2B987CD91AA9EE99F4'; --zsfi_manualacct
  v_currency character varying;
  v_docbasetype character varying := 'GLJ';
  v_postingtype character varying := 'A';
  -- Line- Calculation-Vars
  v_seqno numeric:=0;
  v_taxrate numeric;
  v_taxamt numeric;
  v_netamt numeric;
  v_grossamt numeric;
  v_cramt numeric;
  v_dramt numeric;
  -- Accounts for Tax
  v_taxdebtacct character varying;
  v_taxcredacct character varying;
  -- Actually booked account - with description and value
  v_acct character varying;
  v_acct_val character varying;
  v_acct_desc character varying;
  -- Tax
  v_tax_id character varying := null; 
  -- SOPO: Sales or Purcase: B=Both, S=Sales, P=Purchase
  v_sopotax  character varying;
  v_reversecharge  character varying;
  -- Internal vars
  v_count numeric;
  v_i numeric;
  v_temp character varying;
  v_temp2 character varying;
  -- mgmt Vars
  v_Message character varying;
  v_User character varying;
  -- Header Vars
  v_Record character varying;
  v_Org character varying;
  v_Client character varying;
  v_acctdate DATE;
  v_doc character varying;
  -- Lines
  v_cur_line zsfi_macctline%rowtype;
  -- CheckSums
  v_checksumDR numeric:=0;
  v_checksumCR numeric:=0;
BEGIN
  RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
  v_Message:='PInstanceNotFound';
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL);
  -- Get Parameter
  SELECT i.Record_ID, i.AD_User_ID into v_Record, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
  v_Message:='PInstanceUpdated:'||v_Record;
  -- Load fixed values
  select acctdate, ad_org_id,ad_client_id,documentno into v_acctdate,v_Org,v_Client,v_doc from zsfi_manualacct where zsfi_manualacct_id=v_Record;
  select c_acctschema_id into v_acctshema from ad_org_acctschema where ad_org_id=v_Org and ad_client_id=v_Client;
  select c_currency_id into v_currency from c_acctschema where c_acctschema_id=v_acctshema;  
  select count(*) into v_count from c_periodcontrol_v where ad_client_id=v_Client and ad_org_id=v_Org and isactive='Y' and periodstatus='O' and docbasetype=v_docbasetype and startdate<=v_acctdate and enddate>=v_acctdate;
  -- Tests
  if v_count!=1 then
   RAISE EXCEPTION '%', '@zspr_NoOpenPeriod@' ;
   return;
  end if;
  select c_period_id into v_period from c_periodcontrol_v where ad_client_id=v_Client and ad_org_id=v_Org and isactive='Y' and periodstatus='O' and docbasetype=v_docbasetype and startdate<=v_acctdate and enddate>=v_acctdate;
  select count(*) into v_count from gl_category where ad_client_id=v_Client and ad_org_id in (v_Org,'0') and isactive='Y' and categorytype='M' and isdefault='Y';
  if v_count!=1 then
   RAISE EXCEPTION '%', '@zspr_NoGLCATfound@' ;
   return;
  end if;
  -- Check if there are lines document does
  if (select count(*) from  zsfi_macctline where zsfi_manualacct_id = v_Record)=0 then
          RAISE EXCEPTION '%', '@NoLinesInDoc@';
  END IF; 
  select gl_category_id into v_glcat from gl_category where ad_client_id=v_Client and ad_org_id in (v_Org,'0') and isactive='Y' and categorytype='M' and isdefault='Y';
  -- Load the Lines
  for v_cur_line in (select * from zsfi_macctline where zsfi_manualacct_id=v_Record)
  LOOP
      select count(*) into v_count from c_periodcontrol_v where ad_client_id=v_Client and ad_org_id=v_Org and isactive='Y' and periodstatus='O' and docbasetype=v_docbasetype and startdate<=v_cur_line.acctdate and enddate>=v_cur_line.acctdate;
      -- Tests
      if v_count!=1 then
         RAISE EXCEPTION '%', '@zspr_NoOpenPeriod@' ||' - '||to_char(v_cur_line.acctdate,'dd.mm.yyyy');
         return;
      end if;
      select c_period_id into v_period from c_periodcontrol_v where ad_client_id=v_Client and ad_org_id=v_Org and isactive='Y' and periodstatus='O' and docbasetype=v_docbasetype and startdate<=v_cur_line.acctdate and enddate>=v_cur_line.acctdate;
      v_seqno:=0;
      select count(*) into v_count from c_tax_acct where c_tax_id=v_cur_line.C_Tax_ID and isactive='Y' and c_acctschema_id=v_acctshema;
      if v_count!=1 then
        RAISE EXCEPTION '%', '@zspr_NoTaxACCTfound@' ;
        return;
      end if;  
      if v_cur_line.amt=0 then 
        RAISE EXCEPTION '%', '@zsfi_AmountIsNull@' ;
        return;
      end if;  
      -- Select TAX-Accounts
      select t_credit_acct,t_due_acct into v_temp,v_temp2 from c_tax_acct where c_tax_id=v_cur_line.C_Tax_ID and isactive='Y' and c_acctschema_id=v_acctshema;
      select c_elementvalue.c_elementvalue_id into v_taxdebtacct from c_elementvalue,c_validcombination where c_elementvalue.c_elementvalue_id=c_validcombination.account_id and c_validcombination.c_validcombination_id=v_temp2;
      select c_elementvalue.c_elementvalue_id into v_taxcredacct from c_elementvalue,c_validcombination where c_elementvalue.c_elementvalue_id=c_validcombination.account_id and c_validcombination.c_validcombination_id=v_temp;
      -- calculate TAX
      select rate,sopotype,reversecharge into v_taxrate,v_sopotax,v_reversecharge from c_tax where c_tax_id=v_cur_line.C_Tax_ID;
      if v_taxrate!=0 and v_reversecharge='N' then
         if v_cur_line.isgross='Y' then
            v_netamt:=C_Currency_Round((v_cur_line.amt/(1+(v_taxrate/100))),v_currency,null);
            v_taxamt:=v_cur_line.amt-v_netamt;
            v_grossamt:=v_cur_line.amt;
         else
            v_netamt:=v_cur_line.amt;
            v_taxamt:=C_Currency_Round(v_cur_line.amt*(v_taxrate/100),v_currency,null);
            v_grossamt:=v_netamt+v_taxamt;
         end if;
      else
         if v_reversecharge='Y' and v_taxrate!=0 then 
            v_taxamt:=C_Currency_Round(v_cur_line.amt*(v_taxrate/100),v_currency,null);
         else
            v_taxamt:=0;
         end if;
         v_grossamt:=v_cur_line.amt;
         v_netamt:=v_cur_line.amt;
      end if;
      -- Do the Posting:
      -- If we have taxamt, 3 fact_accts are produced, else 2 lines.
      -- isdr2cr: Normally = 'N' => Books from credit to debit (On acctcr Amount is booked as amtacctcr, On acctdr Amount is booked as  amtacctdr, Tax as debit) (Soll an Haben)
      -- isdr2cr = 'Y' => Books from debit to credit (On acctcr Amount is booked as amtacctdr, On acctdr Amount is booked as  amtacctcr, Tax as credit) (Haben an Soll)
      if v_taxamt!=0 then 
          if v_reversecharge='N' then v_count:=3; else v_count:=4; end if;
      else
          v_count:=2;
      end if;
      FOR v_i IN 1..v_count LOOP
        v_seqno:=v_seqno+10;
        v_tax_id:=null;
        -- first: Source-Account (Contains evtl. tax)
        if v_i=1 then 
            v_acct:=v_cur_line.acctcr; 
            if v_cur_line.isdr2cr='N' then
              v_cramt:=v_grossamt;
              v_dramt:=0;
            else
              v_cramt:=0;
              v_dramt:=v_grossamt;
            end if;
        end if;
        -- next: destination-Account
        if v_i=2 then 
            v_acct:=v_cur_line.acctdr; 
            if v_cur_line.isdr2cr='N' then
              v_dramt:=v_netamt;
              v_cramt:=0;
            else
              v_dramt:=0;
              v_cramt:=v_netamt; 
            end if;
        end if;
        -- last: tax-Accounts
        if v_i>=3 then 
            if v_taxamt!=0 then v_tax_id:=v_cur_line.c_tax_id; else v_tax_id:=null; end if;
            if ((v_cur_line.isdr2cr='N' and v_i=3) or (v_cur_line.isdr2cr='Y' and v_i=4)) then 
              v_acct:=v_taxdebtacct; 
              v_dramt:= v_taxamt;
              v_cramt:=0;
            end if;
            if ((v_cur_line.isdr2cr='Y' and v_i=3) or (v_cur_line.isdr2cr='N' and v_i=4)) then
              v_acct:=v_taxcredacct;  
              v_cramt:= v_taxamt;
              v_dramt:=0;
            end if;
        end if;
        select name,value into v_acct_desc,v_acct_val from c_elementvalue where c_elementvalue_id=v_acct;
        -- Create the Act-Acct
        insert into fact_acct(FACT_ACCT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_ACCTSCHEMA_ID,
                              ACCOUNT_ID, DATETRX, DATEACCT, C_PERIOD_ID, AD_TABLE_ID, RECORD_ID, GL_CATEGORY_ID, C_TAX_ID, POSTINGTYPE,
                              C_CURRENCY_ID, 
                               AMTSOURCECR,  AMTSOURCEDR, AMTACCTCR, AMTACCTDR, 
                              DESCRIPTION, FACT_ACCT_GROUP_ID, SEQNO, DOCBASETYPE,
                              ACCTVALUE, ACCTDESCRIPTION)
                    values(get_UUID(),v_Client,v_Org,'Y',now(),v_User,now(),v_User,v_acctshema,
                            v_acct,now(),v_cur_line.acctdate,v_period,v_table_id, v_cur_line.zsfi_macctline_id,v_glcat, v_tax_id, v_postingtype,
                            v_currency, 
                            v_cramt, v_dramt,v_cramt, v_dramt,
                            substr('J: '||v_doc||' # '||v_cur_line.description,1,255),v_cur_line.zsfi_macctline_id,v_seqno,v_docbasetype,
                            v_acct_val,v_acct_desc);

         v_checksumDR :=   v_checksumDR +  v_dramt;
         v_checksumCR :=   v_checksumCR +  v_cramt;
      END LOOP; 
      -- Debit And Credit - Sums must be equal
      if v_checksumDR!=v_checksumCR then
        RAISE EXCEPTION '%', '@zsfi_ManualAcctNotBalanced@ -  CSDR: '||to_char(v_checksumDR)||':CSCR:'||to_char(v_checksumCR)||':NET:'||to_char(v_netamt)||':TAX:'||to_char(v_taxamt)||':GR:'||to_char(v_grossamt)||'Text:'||v_cur_line.description;
        return;
      end if;  
  -- Lines
  END LOOP;
  -- Finishing-Update  Header and Lines
  --glstatus OP=open, CA=cancelled, PO=posted
  update zsfi_macctline set glstatus='PO',updated=now(),updatedby=v_User where zsfi_manualacct_id=v_Record;
  update zsfi_manualacct set glstatus='PO',updated=now(),updatedby=v_User where zsfi_manualacct_id=v_Record;
  v_Message:='@zsfi_macct_sucess@';
  RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
  RETURN;
EXCEPTION
WHEN OTHERS THEN
    RAISE NOTICE '%',v_Message ;
     v_Message:= '@ERROR=' || SQLERRM;
      RAISE NOTICE '%', v_Message;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_Message);
      RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspr_macct_post(p_pinstance_id character varying) OWNER TO tad;



CREATE OR REPLACE FUNCTION zspr_macct_cancel(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
  Part of finance
  Purpose: Manual accounting, Cancel GL/Journal
  *****************************************************/
  -- mgmt Vars
  v_Message character varying;
  v_User character varying;
  v_Record character varying;
  v_table_id character varying:='4AF9D81E51A04F2B987CD91AA9EE99F4'; -- zsfi_manualacct
  -- Lines
  -- Lines
  v_cur_line zsfi_macctline%rowtype;
BEGIN
  RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
  v_Message:='PInstanceNotFound';
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL);
  -- Get Parameter
  SELECT i.Record_ID, i.AD_User_ID into v_Record, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
  v_Message:='PInstanceUpdated:'||v_Record;
  for v_cur_line in (select * from zsfi_macctline where zsfi_manualacct_id=v_Record and glstatus='PO')
  LOOP
     PERFORM zsfi_generic_cancel(v_cur_line.zsfi_macctline_id, v_table_id,v_User);
  END LOOP;
  --glstatus OP=open, CA=cancelled, PO=posted
  update zsfi_manualacct set glstatus='CA',updated=now(),updatedby=v_User where zsfi_manualacct_id=v_Record;
  update zsfi_macctline set glstatus='CA',updated=now(),updatedby=v_User where zsfi_manualacct_id=v_Record and glstatus='PO';
  v_Message:='@zsfi_macct_CA_sucess@';
  RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
  RETURN;
EXCEPTION
WHEN OTHERS THEN
    RAISE NOTICE '%',v_Message ;
     v_Message:= '@ERROR=' || SQLERRM;
      RAISE NOTICE '%', v_Message;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_Message);
      RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspr_macct_cancel(p_pinstance_id character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zspr_macct_cancelline(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
  Part of finance
  Purpose: Manual accounting, Cancel single Line
  *****************************************************/
  -- mgmt Vars
  v_Message character varying;
  v_User character varying;
  -- Header Vars
  v_Record character varying;
  v_table_id character varying:='4AF9D81E51A04F2B987CD91AA9EE99F4';
  -- Lines
  v_cur_line fact_acct%rowtype;
BEGIN
  RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
  v_Message:='PInstanceNotFound';
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL);
  -- Get Parameter
  SELECT i.Record_ID, i.AD_User_ID into v_Record, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
  v_Message:='PInstanceUpdated:'||v_Record;
  -- Cancel-Run
  PERFORM zsfi_generic_cancel(v_Record, v_table_id,v_User);
  --glstatus OP=open, CA=cancelled, PO=posted
  update zsfi_macctline set glstatus='CA',updated=now(),updatedby=v_User where zsfi_macctline_id=v_Record;
  v_Message:='@zsfi_macct_CAL_sucess@';
  RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
  RETURN;
EXCEPTION
WHEN OTHERS THEN
    RAISE NOTICE '%',v_Message ;
     v_Message:= '@ERROR=' || SQLERRM;
      RAISE NOTICE '%', v_Message;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_Message);
      RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspr_macct_cancelline(p_pinstance_id character varying) OWNER TO tad;



CREATE OR REPLACE FUNCTION zspr_macct_unpost(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
  Part of finance
  Purpose: Manual accounting UNPOST
  *****************************************************/
  -- mgmt Vars
  v_Message character varying;
  v_User character varying;
  v_Record character varying;
  v_table_id character varying:='4AF9D81E51A04F2B987CD91AA9EE99F4';
  -- Header
  v_org  character varying;
  v_client  character varying;
  -- Lines
  v_cur_line zsfi_macctline%rowtype;
BEGIN
  RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
  v_Message:='PInstanceNotFound';
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL);
  -- Get Parameter
  SELECT i.Record_ID, i.AD_User_ID into v_Record, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
  v_Message:='PInstanceUpdated:'||v_Record;
  -- Load values
  select ad_client_id,ad_org_id into v_client, v_Org from zsfi_manualacct where zsfi_manualacct_id=v_Record;
  for v_cur_line in (select * from zsfi_macctline where zsfi_manualacct_id=v_Record)
  LOOP
      -- Delete accounting Lines
      delete from fact_acct where record_id=v_cur_line.zsfi_macctline_id and ad_org_id=v_Org and ad_client_id=v_client and ad_table_id=v_table_id;
  ENd LOOP;
  --glstatus OP=open, CA=cancelled, PO=posted
  update zsfi_manualacct set glstatus='OP',updated=now(),updatedby=v_User where zsfi_manualacct_id=v_Record;
  update zsfi_macctline set glstatus='OP',updated=now(),updatedby=v_User where zsfi_manualacct_id=v_Record;
  v_Message:='@zsfi_macct_UPO_sucess@';
  RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
  RETURN;
EXCEPTION
WHEN OTHERS THEN
    RAISE NOTICE '%',v_Message ;
     v_Message:= '@ERROR=' || SQLERRM;
      RAISE NOTICE '%', v_Message;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_Message);
      RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspr_macct_unpost(p_pinstance_id character varying) OWNER TO tad;





CREATE OR REPLACE FUNCTION zsfi_generic_cancel(v_Record character varying, v_table_id character varying, v_User character varying)
  RETURNS void AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
  Part of finance
  Purpose: Manual accounting - Generic CANCEL
  *****************************************************/
  -- Lines
  v_cur RECORD;
  v_cur_line RECORD;
  -- Internal vars
  v_count numeric;
  -- New Group ID
  v_uid character varying;
BEGIN
    for v_cur in (select distinct fact_acct_group_id from fact_acct where RECORD_ID=v_Record and ad_table_id=v_table_id)
    LOOP
      v_uid:=get_uuid();
      for v_cur_line in (select * from fact_acct where fact_acct_group_id=v_cur.fact_acct_group_id)
      LOOP
        
        select count(*) into v_count from c_periodcontrol_v where ad_client_id=v_cur_line.ad_client_id and ad_org_id=v_cur_line.ad_org_id and isactive='Y' and periodstatus='O' 
                        and docbasetype=v_cur_line.docbasetype and startdate<=v_cur_line.DATEACCT and enddate>=v_cur_line.DATEACCT;
        -- Tests
        if v_count!=1 then
            RAISE EXCEPTION '%', '@zspr_NoOpenPeriod@' ;
            return;
        end if;
        insert into fact_acct(FACT_ACCT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_ACCTSCHEMA_ID,
                                  ACCOUNT_ID, DATETRX, DATEACCT, C_PERIOD_ID, AD_TABLE_ID, RECORD_ID, GL_CATEGORY_ID, C_TAX_ID, POSTINGTYPE,
                                  C_CURRENCY_ID, AMTSOURCEDR, AMTSOURCECR, AMTACCTDR, AMTACCTCR, 
                                  DESCRIPTION, FACT_ACCT_GROUP_ID, SEQNO, DOCBASETYPE,
                                  ACCTVALUE, ACCTDESCRIPTION)
                        values(get_UUID(),v_cur_line.ad_client_id,v_cur_line.ad_org_id,'Y',now(),v_User,now(),v_User,v_cur_line.C_ACCTSCHEMA_ID,
                                v_cur_line.ACCOUNT_ID,now(),v_cur_line.DATEACCT,v_cur_line.C_PERIOD_ID,v_cur_line.AD_TABLE_ID, v_cur_line.RECORD_ID,v_cur_line.GL_CATEGORY_ID, v_cur_line.C_TAX_ID,v_cur_line.POSTINGTYPE ,
                                v_cur_line.C_CURRENCY_ID, v_cur_line.AMTSOURCEDR*(-1), v_cur_line.AMTSOURCECR*(-1),v_cur_line.AMTACCTDR*(-1), v_cur_line.AMTACCTCR*(-1),
                                substr('**CA**  '||v_cur_line.description,1,255),v_uid,v_cur_line.SEQNO,v_cur_line.DOCBASETYPE,
                                v_cur_line.ACCTVALUE, v_cur_line.ACCTDESCRIPTION);
      END LOOP;
    END LOOP;
  RETURN;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION  zsfi_generic_cancel(v_Record character varying, v_table_id character varying,v_User character varying) OWNER TO tad;









/*****************************************************+
Stefan Zimmermann, 10/2010, stefan@zimmermann-software.de



   Implementation of Accounting-Scheme
   
   Chart of ACCOUNTS

   In different Organizations

   1. COA and Validcombination 1:1
*****************************************************/


CREATE OR REPLACE FUNCTION zsfi_elementvalue_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

  v_acctschema    VARCHAR(32); 
  v_count numeric;
    
BEGIN    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;
  -- Insert C_ElementValue Trigger
  --  for Translation
  --  and TreeNode
  IF TG_OP = 'INSERT' THEN
      --  Create Translation Row
      INSERT
      INTO C_ElementValue_Trl
        (
          C_ElementValue_Trl_ID, C_ElementValue_ID, AD_Language, AD_Client_ID,
          AD_Org_ID, IsActive, Created,
          CreatedBy, Updated, UpdatedBy,
          Name, IsTranslated
        )
      SELECT get_uuid(), new.C_ElementValue_ID,
        AD_Language, new.AD_Client_ID, new.AD_Org_ID,
        new.IsActive, new.Created, new.CreatedBy,
        new.Updated, new.UpdatedBy, new.Name,
        'N'
      FROM AD_Language
      WHERE IsActive='Y'
        AND IsSystemLanguage='Y';
   end if;
   IF TG_OP = 'INSERT' or TG_OP = 'UPDATE' THEN
    select C_ACCTSCHEMA_ID into v_acctschema from c_element where c_element_id=new.c_element_id;
    select count(*) into v_count from C_VALIDCOMBINATION where ACCOUNT_ID=new.c_elementvalue_id and C_ACCTSCHEMA_ID=v_acctschema;
    if v_count=0 then
        --Create Combination    
        insert into C_VALIDCOMBINATION (C_VALIDCOMBINATION_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ALIAS, COMBINATION, DESCRIPTION, ISFULLYQUALIFIED, C_ACCTSCHEMA_ID, ACCOUNT_ID)
                    values (get_uuid(),new.AD_CLIENT_ID ,new.AD_ORG_ID ,'Y' ,now() ,new.CREATEDBY ,now() ,new.UPDATEDBY ,new.value ,new.value ,new.name ,'Y' ,v_acctschema ,new.c_elementvalue_id);
    else
        update C_VALIDCOMBINATION set UPDATED=now(),UPDATEDBY=new.UPDATEDBY,ALIAS=new.value,COMBINATION=new.value, DESCRIPTION=new.name where ACCOUNT_ID=new.c_elementvalue_id and C_ACCTSCHEMA_ID=v_acctschema;
    end if;
  END IF;
  
  -- C_ElementValue update trigger
  --  synchronize name,...
  IF TG_OP = 'UPDATE' THEN
     UPDATE Fact_Acct SET AcctValue=new.VALUE,AcctDescription=new.DESCRIPTION WHERE Account_ID=new.C_ElementValue_ID;
  END IF;
  
  IF TG_OP = 'DELETE' THEN
      select C_ACCTSCHEMA_ID into v_acctschema from c_element where c_element_id=old.c_element_id;
      delete from C_VALIDCOMBINATION where ACCOUNT_ID=old.c_elementvalue_id and C_ACCTSCHEMA_ID=v_acctschema;
  END IF;

IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 

END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_elementvalue_trg() OWNER TO tad;















/*****************************************************+
Stefan Zimmermann, 10/2010, stefan@zimmermann-software.de



   Restriction Triggers
   These Triggers guarantee a clean Acct-Scema.
   Rules:
   Only one Acct-Schema for one ORG
   Only one Chart of Accounts for one Acct-Schema
   Only one Set of Accounts/Accounting scheme  for
   Products, Business-Partnbers, Caregories, Assets, Banks, 
   Defaults etc... 
*****************************************************/

CREATE OR REPLACE FUNCTION zsfi_AD_Org_AcctSchema_trg()
RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
   v_count numeric;  
BEGIN    
   select count(*) into v_count from AD_Org_AcctSchema where isactive='Y' and ad_org_id=new.ad_org_id and AD_Org_AcctSchema_id!=new.AD_Org_AcctSchema_id;
   if v_count>0  and new.isactive='Y' then
      RAISE EXCEPTION '%', '@zsfi_OnlyOuneAcctSchema@' ;
   end if;
   RETURN new;
END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
alter FUNCTION zsfi_AD_Org_AcctSchema_trg()   OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_element_trg()
RETURNS trigger AS
$BODY$ DECLARE 
   v_count numeric;  
BEGIN    
   select count(*) into v_count from c_element where isactive='Y' and c_acctschema_id=new.c_acctschema_id and c_element_id!=new.c_element_id;
   if v_count>0 and new.isactive='Y' then
      RAISE EXCEPTION '%', '@zsfi_OnlyOneAcctListOnAcctSchema@' ;
   end if;
   RETURN new;
END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
alter FUNCTION  zsfi_element_trg()  OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_acctschemaelement_trg()
RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
   v_count numeric;  
   v_same character varying;
BEGIN    
   select count(*) into v_count from c_acctschema_element where isactive='Y' and c_acctschema_id=new.c_acctschema_id and c_acctschema_element_id!=new.c_acctschema_element_id;
   if v_count>0 and new.isactive='Y' then
      RAISE EXCEPTION '%', '@zsfi_OnlyOneAcctListOnAcctSchema@';
   end if;
   if coalesce(new.c_element_id,'1')!='1' then
       select c_acctschema_id into v_same from c_element where isactive='Y' and c_element_id=new.c_element_id;
       if v_same!=new.c_acctschema_id then
           RAISE EXCEPTION '%', '@zsfi_elementmustbeSameAcctSchema@';
       end if;
   end if;
   RETURN new;
END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
alter FUNCTION  zsfi_acctschemaelement_trg()  OWNER TO tad;



CREATE OR REPLACE FUNCTION zsfi_custacct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active account on costomer
and Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from c_bp_customer_acct where  c_bpartner_id=new.c_bpartner_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and c_bp_customer_acct_id!=new.c_bp_customer_acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_custacct_trg() OWNER TO tad;



CREATE OR REPLACE FUNCTION zsfi_vendacct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active account on vendor
and Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from c_bp_vendor_acct where c_bpartner_id=new.c_bpartner_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and c_bp_vendor_acct_id!=new.c_bp_vendor_acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_vendacct_trg() OWNER TO tad;



CREATE OR REPLACE FUNCTION zsfi_empacct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active account on employee
and Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from c_bp_employee_acct where  c_bpartner_id=new.c_bpartner_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and c_bp_employee_acct_id!=new.c_bp_employee_acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_empacct_trg() OWNER TO tad;



CREATE OR REPLACE FUNCTION zsfi_BP_GroupAcct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner Groups - Only one active account on 
and Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from c_BP_Group_Acct where  c_bp_group_id=new.c_bp_group_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and c_bp_group_acct_id!=new.c_bp_group_acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_BP_GroupAcct_trg() OWNER TO tad;



CREATE OR REPLACE FUNCTION zsfi_ProductCategoryAcct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active accountset on 
 Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from M_Product_Category_Acct where  M_Product_Category_id=new.M_Product_Category_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and M_Product_Category_Acct_id!=new.M_Product_Category_Acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_ProductCategoryAcct_trg() OWNER TO tad;


CREATE OR REPLACE FUNCTION zsfi_MWarehouseAcct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active accountset on 
 Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from M_Warehouse_Acct where  M_Warehouse_id=new.M_Warehouse_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and M_Warehouse_Acct_id!=new.M_Warehouse_Acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_MWarehouseAcct_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_CBankAccountAcct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active accountset on 
 Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from C_BankAccount_Acct where  C_BankAccount_id=new.C_BankAccount_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and C_BankAccount_Acct_id!=new.C_BankAccount_Acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_CBankAccountAcct_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_CCashBookAcct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active accountset on 
 Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from C_CashBook_Acct where  C_CashBook_id=new.C_CashBook_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and C_CashBook_Acct_id!=new.C_CashBook_Acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_CCashBookAcct_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_CTaxAcct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active accountset on 
 Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from C_Tax_Acct where  C_Tax_id=new.C_Tax_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and C_Tax_Acct_id!=new.C_Tax_Acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_CTaxAcct_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_AAssetAcct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active accountset on 
 Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from A_Asset_Acct where  A_Asset_id=new.A_Asset_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and A_Asset_Acct_id!=new.A_Asset_Acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_AAssetAcct_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_AAssetGroupAcct_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active accountset on 
 Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from A_Asset_Group_Acct where  A_Asset_Group_id=new.A_Asset_Group_id and isactive='Y' 
                                    and c_acctschema_id=new.c_acctschema_id and A_Asset_Group_Acct_id!=new.A_Asset_Group_Acct_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_AAssetGroupAcct_trg() OWNER TO tad;


CREATE OR REPLACE FUNCTION zsfi_CAcctSchemaGL_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Business Partner - Only one active accountset on 
 Accounting-Scheme
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from C_AcctSchema_GL where  C_AcctSchema_id=new.C_AcctSchema_id and isactive='Y' 
                                    and C_AcctSchema_GL_id!=new.C_AcctSchema_GL_id;
  if v_count > 0 and new.isactive='Y' then
      new.isactive='N';
      RAISE EXCEPTION '%', '@zsfi_OnlyOneSetInAS@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_CAcctSchemaGL_trg() OWNER TO tad;

/*****************************************************+
Stefan Zimmermann, 10/2010, stefan@zimmermann-software.de



   Implementation of Accounting-Scheme
   
   RESTRICTION-TRIGGERS END

*****************************************************/














/*****************************************************+
Stefan Zimmermann, 10/2010, stefan@zimmermann-software.de



   Implementation of TAXES
   
  




*****************************************************/

-- Function: c_tax_trg()

-- DROP FUNCTION c_tax_trg();

CREATE OR REPLACE FUNCTION c_tax_trg()
  RETURNS trigger AS
$BODY$ DECLARE 

/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, 02/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************/

/*
 Contributions: Accounts fpr Produkts must be defined.
       All the rubbish tree things removed
*************************************************************************************************************************************************/
    --TYPE RECORD IS REFCURSOR;
  Cur_Defaults RECORD;
  v_count NUMERIC;
  v_AD_Client_ID VARCHAR(32) := new.AD_Client_ID; 
  v_AD_ORG_ID VARCHAR(32) := new.AD_ORG_ID; 
  v_C_Tax_ID VARCHAR(32) := new.C_Tax_ID; 
  v_CreatedBy VARCHAR(32) := new.CreatedBy; 
  v_UpdatedBy VARCHAR(32) := new.UpdatedBy; 
    
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;


IF (TG_OP = 'INSERT') THEN
    -- Tax Account Defaults
    FOR Cur_Defaults IN
      (
      SELECT *
      FROM C_AcctSchema_Default d
      WHERE d.Ad_Client_Id = new.AD_Client_ID
        AND EXISTS
        (
      SELECT 1 
      FROM AD_Org_AcctSchema
      WHERE (AD_IsOrgIncluded(AD_Org_ID, new.AD_ORG_ID, new.AD_Client_ID)<>-1
          OR AD_IsOrgIncluded(new.AD_ORG_ID, AD_Org_ID, new.AD_Client_ID)<>-1)
      AND IsActive = 'Y'
      AND AD_Org_AcctSchema.C_AcctSchema_ID = d.C_AcctSchema_ID
        )
      )
    LOOP
      INSERT
      INTO C_Tax_Acct
        (
          C_Tax_Acct_ID, C_Tax_ID, C_AcctSchema_ID, AD_Client_ID,
          AD_Org_ID, IsActive, Created,
          CreatedBy, Updated, UpdatedBy,
          T_Due_Acct, T_Liability_Acct, T_Credit_Acct,
          T_Receivables_Acct, T_Expense_Acct, t_p_revenue_acct, t_p_expense_acct
        )
        VALUES
        (
          get_uuid(), new.C_Tax_ID, Cur_Defaults.C_AcctSchema_ID, new.AD_Client_ID,
          new.AD_ORG_ID,  'Y', TO_DATE(NOW()),
          new.CreatedBy, TO_DATE(NOW()), new.UpdatedBy,
          Cur_Defaults.T_Due_Acct, Cur_Defaults.T_Liability_Acct, Cur_Defaults.T_Credit_Acct,
          Cur_Defaults.T_Receivables_Acct, Cur_Defaults.T_Expense_Acct,Cur_Defaults.p_revenue_acct,Cur_Defaults.p_Expense_Acct
        );
    END LOOP;
    --  Create Translation Rows   
    
END IF;
  -- Inserting
IF(TG_OP = 'UPDATE') THEN
    UPDATE C_TAX_ACCT SET AD_ORG_ID = new.AD_ORG_ID
    WHERE C_TAX_ID = new.C_TAX_ID;
    
END IF;

  -- Updating
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 

END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION c_tax_trg() OWNER TO tad;

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Given Input: Invoice
             The Product
      Returns: Tax-id
Overloaded: Gets  Location and Org from Invoice and calls zsfi_GetTax(...
*****************************************************/
CREATE OR REPLACE FUNCTION zsfi_GetTax(v_invoiceID in character varying,v_product_id in character varying)
RETURNS CHARACTER VARYING
AS
$BODY$ DECLARE 
 v_org   character varying;
 v_bploc character varying;
BEGIN
  select c_bpartner_location_id,ad_org_id into v_bploc,v_org from c_invoice where c_invoice_id=v_invoiceID;
  return zsfi_GetTax(v_bploc,v_product_id,v_org);
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_GetTax(v_invoiceID character varying,v_product_id character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_GetTax(v_bplocid in character varying, v_product_id in character varying, v_orgid in character varying) RETURNS CHARACTER VARYING
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Given Input: The Business-Partner - Location (SO: ShipTo, PO From Loc)
             The Product, The ORG-Id for Acct-Schema
      Returns: Tax-id
Rules: See below 
*****************************************************/
v_Taxreturn      character varying;
v_pcat            character varying;
BEGIN
    -- Load Product-Category 
    select m_product_category_id into v_pcat from m_product where m_product_id=v_product_id;
    -- Default-Tax, wins if no others defined
    select c_tax_id into v_Taxreturn from AD_Org_AcctSchema where ad_org_id=v_orgid and isactive='Y';
    -- Product-Category ,wins if no tax in product and bp
    select coalesce(c_tax_id,v_Taxreturn) into v_Taxreturn from m_product_category where m_product_category_id=v_pcat;
    -- Product ,wins if no tax in  bp
    select coalesce(c_tax_id,v_Taxreturn) into v_Taxreturn from m_product where m_product_id=v_product_id;
    -- Business-Partner-Location, wins always, if defined
    if v_bplocid is not null then
        select coalesce(c_tax_id,v_Taxreturn) into v_Taxreturn from c_bpartner_location where c_bpartner_location_id=v_bplocid;
    end if;
    RETURN  v_Taxreturn;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_GetTax(v_bplocid character varying, v_product_id character varying, v_orgid character varying) OWNER TO tad;


/*****************************************************+
Stefan Zimmermann, 1/2011, stefan@zimmermann-software.de



   Get the specific Accounts for each purpose
   
  




*****************************************************/
CREATE OR REPLACE FUNCTION zsfi_GetBPAccount(v_acctType in character varying, v_bpartner_id in character varying, v_acctschema_id  in character varying) RETURNS CHARACTER VARYING
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance SELECT ACCOUNTS FOR Business-Partner Booking
Given Input: 
             If In Bpartner-Accounting-Table is defined, we Take That
             If Bpartner-Group  defined, we take that
             Otherwise: We get the Account from Acct-Schema
             PARAMs
             Account-Type: 1= Receivable (Revenue), 2= Liability (Expense). 3= Writeoff, 4= Material Receipts 
             
             The Business Partner, The  Acct-Schema
      Returns: Account
***************************************************************************************************/
v_bpgroup         character varying;
v_retacct         character varying;
v_tempacct        character varying;
BEGIN
    -- Load BPartner-Category 
    select c_bp_group_id into v_bpgroup from c_bpartner where c_bpartner_id=v_bpartner_id;   
    -- Acct-Schema wins, if no other defined
    select case v_acctType when '1' then c_receivable_acct
                          when '2' then v_liability_acct
                          when '3' then writeoff_acct
                          when '4' then notinvoicedreceipts_acct
          end
    into v_retacct from c_acctschema_default where c_acctschema_id=v_acctschema_id and isactive='Y';  
    -- Category-acct, wins if no account defined in BPartner
    select case v_acctType when '1' then c_receivable_acct
                          when '2' then v_liability_acct
                          when '3' then writeoff_acct
                          when '4' then notinvoicedreceipts_acct
          end
          into v_tempacct from c_bp_group_acct where c_bp_group_id=v_bpgroup and isactive='Y' and c_acctschema_id=v_acctschema_id;    
    if v_tempacct is not null then v_retacct:=v_tempacct; end if;
    -- Business-Partner wins, if defined
    if v_acctType='1' then
        select c_receivable_acct 
          into v_tempacct from c_bp_customer_acct where c_bpartner_id= v_bpartner_id and isactive='Y' and c_acctschema_id=v_acctschema_id;    
    elsif v_acctType='2' then
        select v_liability_acct 
          into v_tempacct from c_bp_vendor_acct where c_bpartner_id= v_bpartner_id and isactive='Y' and c_acctschema_id=v_acctschema_id;    
    end if;
    if v_tempacct is not null then v_retacct:=v_tempacct; end if;
    RETURN  v_retacct;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_GetBPAccount(v_acctType in character varying, v_bpartner_id in character varying, v_acctschema_id  in character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zsfi_GetPAccountFromTax(v_acctType in character varying, v_tax_id in character varying, v_org_id  in character varying) RETURNS CHARACTER VARYING
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance SELECT ACCOUNTS FOR PRODUCTS Booking - From TAX Line (Used for GROSS Invoice Booking)

      Returns: Account
***************************************************************************************************/

v_retacct         character varying;
v_acctschema_id varchar;
BEGIN
       select c_acctschema_id into v_acctschema_id from ad_org_acctschema where ad_org_id=v_org_id;
       -- Tax-acct wins, if no other defined
       select case v_acctType when '2' then t_p_expense_acct
                              when '1' then t_p_revenue_acct
              end
       into v_retacct from c_tax_acct where c_tax_id=v_tax_id and isactive='Y' and c_acctschema_id=v_acctschema_id;
    RETURN  v_retacct;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zsfi_GetPExpenseAccountFromInvTaxandFirstProduct(v_InvoiceID in character varying, v_tax_id in character varying, v_org_id  in character varying) RETURNS CHARACTER VARYING
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance SELECT ACCOUNTS FOR PRODUCTS Booking - From TAX Line 

Used ONLY for GROSS Invoice Booking
Only applicable for Purchase Invoices. Sales select account direct from tax.
Selects the First Product Line with the Tax given and selects the Expense Account for it
If none or Accounting-Schema-Default found, the Expense Account is taken from the Tax

      Returns: Account
***************************************************************************************************/

v_retacct         character varying;
v_taxacct varchar;
v_acctschema_id varchar;
v_product varchar;
BEGIN
       select c_acctschema_id into v_acctschema_id from ad_org_acctschema where ad_org_id=v_org_id;
       select m_product_id into v_product from c_invoiceline where c_invoice_id=v_InvoiceID and c_tax_id=v_tax_id order by line limit 1;
       -- The TAX-Account wins, if no Product account defined
       v_taxacct:=zsfi_GetPAccountFromTax('2',v_tax_id,v_org_id);
       -- returns Product account or ACCT-Default-Acct. Cannot find Tax account.
       v_retacct:=zsfi_GetPAccount('2',v_product,v_acctschema_id);
       if v_retacct=(select p_expense_acct from c_acctschema_default where c_acctschema_id=v_acctschema_id and isactive='Y') then
           RETURN  v_taxacct;
       else
           return v_retacct;
       end if;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zsfi_GetPAccount(v_acctType in character varying, v_product_id in character varying, v_acctschema_id  in character varying, v_InvoiceLineid in character varying) RETURNS CHARACTER VARYING
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance SELECT ACCOUNTS FOR PRODUCTS Booking
Given Input: 
             If Invoiceline is defined, we assume, that Tax is defined.
             If Tax defined, account may be selected from Tax (Rules below)
             PARAMs
             Account-Type: 1=Revenue, 2= Expense. Corrospondence to Productinfo.java
             Invoiceline
             (gets the the Business-Partner - Location;SO: ShipTo, PO From Loc from Invoice)
             The Product, The  Acct-Schema
      Returns: Account
***************************************************************************************************/
v_Taxid           character varying;
v_bpTaxid         character varying;
v_pcat            character varying;
v_bpartn_loc_id   character varying;
v_retacct         character varying;
v_tempacct        character varying;
BEGIN
    -- Load Product-Category 
    select m_product_category_id into v_pcat from m_product where m_product_id=v_product_id;
    select c_bpartner_location_id into v_bpartn_loc_id from c_invoice where c_invoice_id=(select c_invoice_id from c_invoiceline where c_invoiceline_id=v_InvoiceLineid);
    select c_tax_id into v_bpTaxid from c_bpartner_location where c_bpartner_location_id=v_bpartn_loc_id;
    select c_tax_id into v_Taxid from c_invoiceline where c_invoiceline_id=v_InvoiceLineid;
    -- If no Tax defined
    If v_Taxid is null then
        return zsfi_GetPAccount(v_acctType, v_product_id, v_acctschema_id);
    end if;
    -- Busuness Partner-Tax wins always
    if v_bpTaxid is not null then
       select case v_acctType when '2' then t_p_expense_acct 
                              when '1' then t_p_revenue_acct
              end
              into v_retacct from c_tax_acct where c_tax_id=v_bpTaxid and isactive='Y' and c_acctschema_id=v_acctschema_id;
    else
       -- Tax-acct wins, if no other defined
       select case v_acctType when '2' then t_p_expense_acct
                              when '1' then t_p_revenue_acct
              end
       into v_retacct from c_tax_acct where c_tax_id=v_Taxid and isactive='Y' and c_acctschema_id=v_acctschema_id;
       -- If TAX Not Defined - Get from ACCT-Schema-Default
       if v_retacct is null then
          select case v_acctType when '2' then p_expense_acct
                                 when '1' then p_revenue_acct
                 end
          into v_retacct from c_acctschema_default where c_acctschema_id=v_acctschema_id and isactive='Y';  
       end if;
       -- Category-acct, wins if no product defined
       select case v_acctType when '2' then p_expense_acct 
                              when '1' then p_revenue_acct 
              end
              into v_tempacct from m_product_category_acct where m_product_category_id=v_pcat and isactive='Y' and c_acctschema_id=v_acctschema_id;    
       if v_tempacct is not null then v_retacct:=v_tempacct; end if;
       -- Product-acct wins, if defined
       select case v_acctType when '2' then p_expense_acct
                              when '1' then p_revenue_acct 
              end
              into v_tempacct from m_product_acct where m_product_id= v_product_id and isactive='Y' and c_acctschema_id=v_acctschema_id;    
       if v_tempacct is not null then v_retacct:=v_tempacct; end if;
    end if;
    RETURN  v_retacct;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_GetPAccount(v_acctType character varying,v_product_id character varying, v_acctschema_id  character varying, v_InvoiceLineid character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zsfi_GetPAccount(v_acctType character varying, v_product_id character varying, v_acctschema_id  character varying) RETURNS CHARACTER VARYING
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance      SELECT ACCOUNTS FOR PRODUCTS Booking
Given Input:  Get from Product, Category or Acc-Schema
             
             PARAMs
             Account-Type: 1=Revenue, 2= Expense. Asset = "3";Cost af Goods Sold = "4"; Price Variance (Purchase) = "5";   Price Variance (Sale) = "6";Trade Discount Revenue = "7";Trade Discount Costs  = "8";
                           Corrospondence to Productinfo.java 
             The Product, The  Acct-Schema
             Rules: 
             1. Product, 2. Category, 3. Acct-Schema-Default
      Returns: Account
***************************************************************************************************/

v_pcat            character varying;
v_retacct         character varying;
v_tempacct        character varying;
BEGIN
    -- Load Product-Category 
    select m_product_category_id into v_pcat from m_product where m_product_id=v_product_id;
    -- Acct-Schema wins, if no other defined
    select case v_acctType   when '1' then p_revenue_acct
                             when '2' then p_expense_acct 
                             when '3' then p_asset_acct
                             when '4' then p_cogs_acct
                             when '5' then p_purchasepricevariance_acct
                             when '6' then p_invoicepricevariance_acct 
                             when '7' then p_tradediscountrec_acct 
                             when '8' then p_tradediscountgrant_acct                         
            end  into v_retacct from c_acctschema_default where c_acctschema_id=v_acctschema_id and isactive='Y';  
    

       -- Category-acct, wins if no product defined
       select case v_acctType   when '1' then p_revenue_acct
                             when '2' then p_expense_acct 
                             when '3' then p_asset_acct
                             when '4' then p_cogs_acct
                             when '5' then p_purchasepricevariance_acct
                             when '6' then p_invoicepricevariance_acct 
                             when '7' then p_tradediscountrec_acct 
                             when '8' then p_tradediscountgrant_acct
                        end into v_tempacct from m_product_category_acct where m_product_category_id=v_pcat and isactive='Y' and c_acctschema_id=v_acctschema_id;    
       if v_tempacct is not null then v_retacct:=v_tempacct; end if;
       -- Product-acct wins, if defined
       select case v_acctType   when '1' then p_revenue_acct
                             when '2' then p_expense_acct 
                             when '3' then p_asset_acct
                             when '4' then p_cogs_acct
                             when '5' then p_purchasepricevariance_acct
                             when '6' then p_invoicepricevariance_acct 
                             when '7' then p_tradediscountrec_acct 
                             when '8' then p_tradediscountgrant_acct
                        end into v_tempacct from m_product_acct where m_product_id= v_product_id and isactive='Y' and c_acctschema_id=v_acctschema_id; 
        if v_tempacct is not null then v_retacct:=v_tempacct; end if;
    RETURN  v_retacct;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_GetPAccount(v_acctType character varying, v_product_id character varying, v_acctschema_id  character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zsfi_GetWDAccount(v_acctType character varying, v_invoice_id character varying, v_acctschema_id  character varying) RETURNS CHARACTER VARYING
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
Given Input: Get Discount or Write-Off Account from Tax or Acct-Schema
             
             PARAMs
             Account-Type: 1=Discount-Granted, 2= Discount-Got = "3"=Writeoff 4=Taxdue(Umsatzsteuer) 5=TaxCredit (Vorsteuer)
                           Corrospondence to Productinfo.java 
             The Tax, The  Acct-Schema
             Rules: 
             1. Tax, 2.  Acct-Schema-Default
      Returns: ValidCombination-ID
***************************************************************************************************/

v_pcat            character varying;
v_retacct         character varying;
v_tempacct        character varying;
v_Tax_id          character varying;
v_count           numeric;
BEGIN 
    -- Load Tax ID 
    select count(distinct c_tax_id) into v_count from c_invoicetax where c_invoice_id=v_invoice_id;
    if v_count=1 then
        select min(c_tax_id) into v_tax_id from c_invoicetax where c_invoice_id=v_invoice_id;
    end if;
    -- Acct-Schema wins, if no other defined
    select case v_acctType   when '1' then ar_discount_acct
                             when '2' then ap_discount_acct
                             when '3' then writeoff_acct     
                             when '4' then t_due_acct 
                             when '5' then t_credit_acct     
            end  into v_retacct from c_acctschema_default where c_acctschema_id=v_acctschema_id and isactive='Y';  
    
    if v_Tax_id is not null then
      -- Tax-acct, wins if defined
      select case v_acctType   when '1' then t_ar_discount_acct
                            when '2' then t_ap_discount_acct 
                            when '3' then t_writeoff_acct
                            when '4' then t_due_acct 
                            when '5' then t_credit_acct    
                        end into v_tempacct from c_tax_acct where c_tax_id=v_tax_id and isactive='Y' and c_acctschema_id=v_acctschema_id;  
      if v_tempacct is not null then v_retacct:=v_tempacct; end if; 
    end if; 
    RETURN  v_retacct;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_GetWDAccount(v_acctType character varying, v_tax_id character varying, v_acctschema_id  character varying)  OWNER TO tad;





/*****************************************************+
Stefan Zimmermann, 1/2011, stefan@zimmermann-software.de



   AUXILLIAR Functions
   
  




*****************************************************/


CREATE OR REPLACE FUNCTION zsfi_GetTaxAmtFromAmt(v_invoice_id character varying, v_amount character varying, v_currency character varying) RETURNS character varying
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
      Get Tax-Part of Discount or Write-Off Amount given as input            
      Returns:Tax-Amount
***************************************************************************************************/
v_Tax_id          character varying;
v_count           numeric;
v_retamt          numeric;
v_taxrate         numeric;
v_inpamount       numeric;
v_reversetax      character varying;
BEGIN
    v_inpamount:=to_number(v_amount);
    -- Load Tax ID 
    select count(distinct c_tax_id) into v_count from c_invoicetax where c_invoice_id=v_invoice_id;
    if v_count=1 then
        select min(c_tax_id) into v_tax_id from c_invoicetax where c_invoice_id=v_invoice_id;
        select rate,reversecharge into v_taxrate,v_reversetax from c_tax where c_tax_id=v_tax_id;
        if v_reversetax='N' and v_taxrate!=0 then
            v_retamt:=v_inpamount-C_Currency_Round((v_inpamount/(1+(v_taxrate/100))),v_currency,null);
        else
            v_retamt:=0;
        end if;
    end if;    
    RETURN  to_char(v_retamt);
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

ALTER FUNCTION zsfi_GetTaxAmtFromAmt(v_invoice_id character varying, v_amount character varying, v_currency character varying)  OWNER TO tad;














/*****************************************************+
Stefan Zimmermann, 01/2011, stefan@zimmermann-software.de



   Implementation of  Accounting Logic
   
   Internal Consumption

   Purpose: Production 
            Doctype MMP (P+/P-) 
       and  Godds consumption (-)
            Doctype MMP (D-) 
   cancel is not Possible-Same than InOut-Invenory 
   must be kept correct.

*****************************************************/

CREATE OR REPLACE FUNCTION zsfi_postinternalconsumption2gl(p_Record_ID character varying, v_User character varying)
  RETURNS void AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
  Part of finance
  Purpose: Manual accounting. Post GL/Journal
  *****************************************************/
  -- General CONSTs
  v_acctshema character varying;
  v_period character varying;
  v_table_id character varying :='800168'; -- m_internal_consumption
  v_ptable_id character varying:='325'; --m_production (is oly a dummy) @TODO: get Posting (p+) otherwise activated. (p-) is triggered through  m_internal_consumption ...  
  v_movetypes character varying;
  v_glcat    character varying :='6DD60A8614B54874B0740C07AC142301';
  v_currency character varying;
  v_docbasetype character varying := 'MMP';
  
  -- Line- Calculation-Vars
  v_amt   numeric;
  v_dramt numeric;
  v_cramt numeric;
  
  -- Actually booked accounts - with description and value
  v_pj_wip_acct character varying;
  v_pj_wip_acct_val character varying;
  v_pj_wip_acct_desc character varying;
  v_w_inventory_acct character varying;
  v_w_inventory_acct_val character varying;
  v_w_inventory_acct_desc character varying;
  v_pj_asset_acct character varying;
  v_pj_asset_acct_val character varying;
  v_pj_asset_acct_desc character varying;
  -- In the FACT
  v_acct character varying;
  v_acct_val  character varying;
  v_acct_desc character varying;
  v_group  character varying;
  -- Internal vars
  v_count numeric;
  v_i numeric;
  v_temp character varying;
  v_temp2 character varying;
  -- mgmt Vars
  v_Message character varying;
  -- Header Vars
  v_Org character varying;
  v_Client character varying;
  v_acctdate DATE;
  v_doc character varying;
  v_movementtype  character varying;
  -- Lines
  v_cur_line RECORD;
  -- CheckSums
  v_checksumDR numeric:=0;
  v_checksumCR numeric:=0;
BEGIN
  -- Load fixed values
  select dateacct, ad_org_id,ad_client_id,documentno,movementtype into v_acctdate,v_Org,v_Client,v_doc,v_movementtype from m_internal_consumption where m_internal_consumption_id=p_Record_ID;
  select c_acctschema_id into v_acctshema from ad_org_acctschema where ad_org_id=v_Org and ad_client_id=v_Client;
  select c_currency_id into v_currency from c_acctschema where c_acctschema_id=v_acctshema;  
  -- Is Accounting activated?
  select count(*) into v_count from c_acctschema_table where C_ACCTSCHEMA_ID=v_acctshema and AD_TABLE_ID=v_table_id and isactive='Y';
  if v_count!=1 then
   return;
  end if;
  -- Is Production + active?
  select count(*) into v_count from c_acctschema_table where C_ACCTSCHEMA_ID=v_acctshema and AD_TABLE_ID=v_ptable_id and isactive='Y';
  if v_count!=1 and v_movementtype='P+' then
     return;
  end if;
  select count(*) into v_count from c_periodcontrol_v where ad_client_id=v_Client and ad_org_id=v_Org and isactive='Y' and periodstatus='O' and docbasetype=v_docbasetype and startdate<=v_acctdate and enddate>=v_acctdate;
  -- Tests
  if v_count!=1 then
   RAISE EXCEPTION '%', '@zspr_NoOpenPeriod@' ;
   return;
  end if;
  select c_period_id into v_period from c_periodcontrol_v where ad_client_id=v_Client and ad_org_id=v_Org and isactive='Y' and periodstatus='O' and docbasetype=v_docbasetype and startdate<=v_acctdate and enddate>=v_acctdate;
  -- Group the Whole Document
  v_group:=get_uuid();
  -- Load the Lines
  for v_cur_line in (select * from m_internal_consumptionline where m_internal_consumption_id=p_Record_ID)
  LOOP
      -- Get Product Price
      select m_get_product_cost(v_cur_line.m_product_id,v_acctdate,null,v_cur_line.ad_org_id)*v_cur_line.movementqty into v_amt;

     /*****************************************************+
        LOGIC
        P-, D- -> pj_wip_acct:CR       ; w_inventory_acct:DR
        P+     -> w_inventory_acct:CR  ; pj_asset_acct:DR

        Note: pj_asset_acct is really not the asset , it is cost-account.
  
     *****************************************************/ 
      -- Select Accounts
      select pj_wip_acct,pj_asset_acct into v_temp,v_temp2 from c_acctschema_default where ad_org_id=v_Org and isactive='Y' and c_acctschema_id=v_acctshema;
      select ev.c_elementvalue_id,ev.name,ev.value into v_pj_wip_acct, v_pj_wip_acct_desc, v_pj_wip_acct_val from c_elementvalue ev,c_validcombination where ev.c_elementvalue_id=c_validcombination.account_id and c_validcombination.c_validcombination_id=v_temp;
      select ev.c_elementvalue_id,ev.name,ev.value into v_pj_asset_acct, v_pj_asset_acct_desc, v_pj_asset_acct_val from c_elementvalue ev,c_validcombination where ev.c_elementvalue_id=c_validcombination.account_id and c_validcombination.c_validcombination_id=v_temp2;
      -- Get Product Asset Account
      select m_product_category_id into v_temp from m_product where m_product_id=v_cur_line.m_product_id;
      select p_asset_acct into v_temp2 from m_product_category_acct where m_product_category_id=v_temp and c_acctschema_id=v_acctshema;
      if v_temp2 is null then
          -- No Product-Account? - Get Warehouse-Asset-Account
          select m_warehouse_id into v_temp from m_locator where m_locator_id=v_cur_line.m_locator_id;
          select w_inventory_acct into v_temp2 from m_warehouse_acct where m_warehouse_id=v_temp and ad_org_id=v_Org and isactive='Y' and c_acctschema_id=v_acctshema;
      end if;
      -- All accounts selected?
      select ev.c_elementvalue_id,ev.name,ev.value into v_w_inventory_acct, v_w_inventory_acct_desc, v_w_inventory_acct_val from c_elementvalue ev,c_validcombination where ev.c_elementvalue_id=c_validcombination.account_id and c_validcombination.c_validcombination_id=v_temp2;      
      if v_pj_wip_acct is null or v_pj_asset_acct is null or v_w_inventory_acct is null then 
        RAISE EXCEPTION '%', '@zsfi_AccountIsNull@' ;
        return;
      end if;  

      if coalesce(v_amt,0)=0 then 
        RAISE EXCEPTION '%', '@zsfi_AmountIsNull@' ;
        return;
      end if;  
      --
      FOR v_i IN 1..2 LOOP
        -- 1:CR-Account
        -- 2:DR-Account
        if v_movementtype in ('D-','P-') then
           if v_i=1 then
              v_acct:=v_pj_wip_acct;
              v_acct_val:=v_pj_wip_acct_val;
              v_acct_desc:=v_pj_wip_acct_desc;
              v_dramt:=0;
              v_cramt:=v_amt;
           else
              v_acct:=v_w_inventory_acct;
              v_acct_val:=v_w_inventory_acct_val;
              v_acct_desc:=v_w_inventory_acct_desc;
              v_dramt:=v_amt;
              v_cramt:=0;
           end if;
        elsif v_movementtypein ('D+','P+') then
           if v_i=1 then
              v_acct:=v_w_inventory_acct;
              v_acct_val:=v_w_inventory_acct_val;
              v_acct_desc:=v_w_inventory_acct_desc;
              v_dramt:=0;
              v_cramt:=v_amt;
           else
              v_acct:=v_pj_asset_acct;
              v_acct_val:=v_pj_asset_acct_val;
              v_acct_desc:=v_pj_asset_acct_desc;
              v_dramt:=v_amt;
              v_cramt:=0;
           end if;
        else
          RAISE EXCEPTION '%', '@zsfi_IllegalMovementType@' ;
          return;
        end if;  
        -- RAISE NOTICE '%','MT:'||coalesce(v_movementtype,'Ä')||',i:'||v_i||',ACT:'||coalesce(v_acct_desc,'Ä')||'Amt:'||coalesce(v_amt,'-1');
        -- Create the FAct-Acct
        insert into fact_acct(FACT_ACCT_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_ACCTSCHEMA_ID,
                              ACCOUNT_ID, DATETRX, DATEACCT, C_PERIOD_ID, AD_TABLE_ID, RECORD_ID, GL_CATEGORY_ID, POSTINGTYPE,
                              C_CURRENCY_ID, 
                               AMTSOURCECR,  AMTSOURCEDR, AMTACCTCR, AMTACCTDR, 
                              DESCRIPTION, FACT_ACCT_GROUP_ID, SEQNO, DOCBASETYPE,
                              ACCTVALUE, ACCTDESCRIPTION)
                    values(get_UUID(),v_Client,v_Org,'Y',now(),v_User,now(),v_User,v_acctshema,
                            v_acct,now(),v_acctdate,v_period,v_table_id, v_cur_line.m_internal_consumptionline_id,v_glcat, 'A',
                            v_currency, 
                            v_cramt, v_dramt,v_cramt, v_dramt,
                            substr('I: '||v_doc||' # '||v_cur_line.description,1,255),v_group,v_i,v_docbasetype,
                            v_acct_val,v_acct_desc);

         v_checksumDR :=   v_checksumDR +  v_dramt;
         v_checksumCR :=   v_checksumCR +  v_cramt;
      END LOOP; 
      -- Debit And Credit - Sums must be equal
      if v_checksumDR!=v_checksumCR then
        RAISE EXCEPTION '%', '@zsfi_ManualAcctNotBalanced@ -  CSDR: '||to_char(v_checksumDR)||':CSCR:'||to_char(v_checksumCR)||':NET:'||to_char(v_netamt)||':TAX:'||to_char(v_taxamt)||':GR:'||to_char(v_grossamt)||'Text:'||v_cur_line.description;
        return;
      end if;  
  -- Lines
  END LOOP;
  -- Finishing-Update  Header and Lines
  --glstatus OP=open, CA=cancelled, PO=posted
  update m_internal_consumption set posted='Y',updated=now(),updatedby=v_User where m_internal_consumption_id=p_Record_ID;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsfi_postinternalconsumption2gl(p_Record_ID character varying, v_User character varying) OWNER TO tad;

/*****************************************************+
Stefan Zimmermann, 1/2011, stefan@zimmermann-software.de



   Implementation of Cash-Discounts
   




*****************************************************/



CREATE OR REPLACE FUNCTION zsfi_getcashdiscount(p_invoice_id character varying, p_amount numeric,p_currency  character varying,p_date character varying) RETURNS numeric
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
      Returns:Chash-Discount Amount
***************************************************************************************************/
v_ptid            character varying;
v_rate            numeric;
v_reversetax      character varying;
v_invdate         timestamp without time zone;
v_bstdate         timestamp without time zone;
BEGIN
    select c_paymentterm_id,dateinvoiced into v_ptid,v_invdate from c_invoice where c_invoice_id=p_invoice_id;
    v_bstdate:=to_timestamp(p_date,'dd-mm-yyyy');
    --,'dd.mm.yyyy-hh24:mi:ss'
    select percentage into v_rate from zsfi_discount where c_paymentterm_id = v_ptid and netdays >= to_number(v_bstdate-v_invdate) order by netdays limit 1;
    RETURN coalesce(C_Currency_Round(p_amount*(v_rate/100),p_currency,null),0);
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

ALTER FUNCTION zsfi_getcashdiscount(p_invoice_id character varying, p_amount numeric,p_currency  character varying,p_date character varying)  OWNER TO tad;




CREATE OR REPLACE FUNCTION zsfi_paymentmonitor(p_settlement_id character varying) returns void
AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Finance
      Reimplementation of the Old Payment Monitor
      Fix Issue 448: Discounts have a cancel_id on creation, bit are still open (Bankstatement not Processed)
***************************************************************************************************/
v_cur             RECORD;


v_rate            numeric;
v_reversetax      character varying;
v_order_id 		  character varying;
v_invdate         timestamp without time zone;
v_bstdate         timestamp without time zone;
BEGIN
    for v_cur in (SELECT DISTINCT(C_DEBT_PAYMENT.C_INVOICE_ID) AS c_invoice_id FROM C_DEBT_PAYMENT WHERE  C_SETTLEMENT_CANCEL_ID= p_settlement_id OR C_SETTLEMENT_GENERATE_ID= p_settlement_id)
    LOOP
      UPDATE C_INVOICE SET  OUTSTANDINGAMT=Q.OUTSTANDINGAMT,TOTALPAID=Q.TOTALPAID,WRITEOFFAMT=Q.WRITEOFFAMT,DISCOUNTAMT=Q.DISCOUNTAMT,ISPAID=Q.ISPAID, transactiondate=now() FROM
                (SELECT SUM(OPENAMT) AS OUTSTANDINGAMT,SUM(PAIDAMT) AS TOTALPAID,SUM(WRITEOFFAMT) AS WRITEOFFAMT, SUM(DISCOUNTAMT) AS DISCOUNTAMT, MAX(ISPAID) AS ISPAID FROM 
                        (SELECT 0 AS OPENAMT,SUM(AMOUNT) AS PAIDAMT,0 AS WRITEOFFAMT, 0 AS DISCOUNTAMT, ' ' AS ISPAID FROM C_DEBT_PAYMENT WHERE CANCEL_PROCESSED='Y' 
                                     AND ISPAID='Y' AND ISVALID='Y' AND C_INVOICE_ID = v_cur.C_INVOICE_ID
                         UNION ALL
                         SELECT SUM(AMOUNT) AS OPENAMT,0  AS PAIDAMT,0 AS WRITEOFFAMT, 0 AS DISCOUNTAMT, ' ' AS ISPAID FROM C_DEBT_PAYMENT WHERE CANCEL_PROCESSED='N'  AND ISVALID='Y'
                                AND  C_INVOICE_ID = v_cur.C_INVOICE_ID and (c_settlement_cancel_id is null or discountamt>0)
                         UNION ALL
                         SELECT 0 AS OPENAMT,0  AS PAIDAMT,SUM(WRITEOFFAMT) AS WRITEOFFAMT, SUM(DISCOUNTAMT) AS DISCOUNTAMT, ' ' AS ISPAID  FROM C_DEBT_PAYMENT WHERE CANCEL_PROCESSED='Y' 
                                 AND ISPAID='N' AND ISVALID='Y' AND C_INVOICE_ID =  v_cur.C_INVOICE_ID
                          UNION ALL
                         SELECT 0 AS OPENAMT,0  AS PAIDAMT,0 AS WRITEOFFAMT, 0 AS DISCOUNTAMT, MIN(CANCEL_PROCESSED) AS ISPAID  FROM C_DEBT_PAYMENT WHERE  C_INVOICE_ID =  v_cur.C_INVOICE_ID
                         ) A
                 ) Q
        WHERE C_INVOICE_ID=v_cur.C_INVOICE_ID;
		select c_order_id into v_order_id from c_invoice where c_invoice.c_invoice_id=v_cur.c_invoice_id;
		update c_order set transactiondate=now() where c_order.c_order_id = v_order_id;
		update c_order set totalpaid = (select coalesce(SUM(c_invoice.totalpaid),0) from c_invoice where c_invoice.c_order_id=v_order_id) where c_order.c_order_id = v_order_id;
    END LOOP;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_DropView ('fact_acct_view');

create or replace view fact_acct_view as
select  fact_acct.fact_acct_id as fact_acct_view_id,
                fact_acct.ad_client_id,
                fact_acct.ad_org_id,
                fact_acct.isactive,
                fact_acct.created,
                fact_acct.createdby,
                fact_acct.updated,
                fact_acct.updatedby,
                fact_acct.c_acctschema_id,
                fact_acct.account_id,
                fact_acct.datetrx,
                fact_acct.dateacct,
                fact_acct.c_period_id,
                fact_acct.ad_table_id,
                fact_acct.record_id,
                fact_acct.line_id,
                fact_acct.gl_category_id,
                fact_acct.c_tax_id,
                fact_acct.m_locator_id,
                fact_acct.postingtype,
                fact_acct.c_currency_id,
                fact_acct.amtsourcedr,
                fact_acct.amtsourcecr,
                fact_acct.amtacctdr,
                fact_acct.amtacctcr,
                fact_acct.c_uom_id,
                fact_acct.qty,
                fact_acct.m_product_id,                 
                fact_acct.c_bpartner_id,
                fact_acct.ad_orgtrx_id,
                fact_acct.c_locfrom_id,
                fact_acct.c_locto_id,
                fact_acct.c_salesregion_id,
                fact_acct.c_project_id,
                fact_acct.c_campaign_id,
                fact_acct.c_activity_id,
                fact_acct.user1_id,
                fact_acct.user2_id,
                fact_acct.description,
                fact_acct.a_asset_id,
                fact_acct.fact_acct_group_id,
                fact_acct.seqno,
                fact_acct.factaccttype,
                fact_acct.docbasetype,
                fact_acct.acctvalue,
                fact_acct.acctdescription,
                fact_acct.record_id2,
                fact_acct.c_withholding_id,             
                fact_acct.c_doctype_id,
                fact_acct.uidnumber
from fact_acct
union -- 9150 - Turnover - Statistical Account
select  '32E74132DF90466C8E35592E480AF523' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                'ED3D722029254A178FADAA77FCCFFB4C'  as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9150' as acctvalue,
                'Faktuirierter Umsatz' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union -- 9151 - Backorder - Statistical Account
select  '2B2F6E2DEC0B4656A7703A6432862402' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                'E2622C721BE44A8AAA7453231152F56B'  as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9151' as acctvalue,
                'Noch nicht fakturierter Umsatz' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union
select  '2D4A8B552A9F497989D109F021EB6174' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                'ED3D722029254A178FADAF77FCCFFB4C'  as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9152' as acctvalue,
                'Aufträge' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union
select  '9FA76AAA35024BF98C231BEBEEF0E4D1' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                 '259C9D8DEF014B378F6F2815FAD5C62E' as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9153' as acctvalue,
                'Angebote' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union
select  '1EDECA899B26455FB51BD83F22C1D819' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                 'BD3E518F00814221920C6229F6D22C95' as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9154' as acctvalue,
                'Verkaufsprognose' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union
select  '2331E238DEE64A0696AB474D39827A19' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                '10DDDC12DC8447B79751C7AC6BB89293' as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9155' as acctvalue,
                'Forderungen' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union
select  'DF5D9801187145CBAA7ED40453043875' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                'AA574CAD350247CE918559B162FC8F3E' as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9156' as acctvalue,
                'Verbindlichkeiten' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union
select  '24D16D935CB749FBA10DBF8195F763BD' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                '89AF947DBC61434DA7D7F3E050839C01' as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9157' as acctvalue,
                'Fakturierter Umsatz Runrate' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union
select  'AC55F0F34BF9409CB6A7467107EC2A38' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                'BCEE1A6C65D44DDFB5F792CD9C1F0ABB' as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9158' as acctvalue,
                'Noch nicht fakturierter Umsatz Runrate' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id
union
select  'EC98C5B9421B44E6B4690E500F0B6693' as fact_acct_view_id,
                ad_org.ad_client_id,
                ad_org.ad_org_id,
                ad_org.isactive,
                ad_org.created,
                ad_org.createdby,
                ad_org.updated,
                ad_org.updatedby,
                ad_org_acctschema.c_acctschema_id,
                '71A1A23C9B7A41528BDC66FDF9BF4C43' as account_id,
                null as datetrx,
                now() as dateacct,
                null as c_period_id,
                null as ad_table_id,
                null as record_id,
                null as line_id,
                null as gl_category_id,
                null as c_tax_id,
                null as m_locator_id,
                null as postingtype,
                null as c_currency_id,
                null as amtsourcedr,
                null as amtsourcecr,
                0 as amtacctdr,
                0 as amtacctcr,
                null as c_uom_id,
                null as qty,
                null as m_product_id,                   
                null as c_bpartner_id,
                null as ad_orgtrx_id,
                null as c_locfrom_id,
                null as c_locto_id,
                null as c_salesregion_id,
                null as c_project_id,
                null as c_campaign_id,
                null as c_activity_id,
                null as user1_id,
                null as user2_id,
                null as description,
                null as a_asset_id,
                null as fact_acct_group_id,
                null as seqno,
                null as factaccttype,
                null as docbasetype,
                '9159' as acctvalue,
                'Auftraege Runrate' as acctdescription,
                null as record_id2,
                null as c_withholding_id,               
                null as c_doctype_id,
                null as uidnumber
from 
        ad_org, ad_org_acctschema
where 
        ad_org.ad_org_id = ad_org_acctschema.ad_org_id;

select zsse_DropView ('c_debt_payment_v');

CREATE OR REPLACE VIEW c_debt_payment_v AS 
 SELECT c_debt_payment.c_debt_payment_id,
	c_debt_payment.ad_client_id,
	c_debt_payment.ad_org_id,
	c_debt_payment.isactive,
	c_debt_payment.created,
	c_debt_payment.createdby,
	c_debt_payment.updated,
	c_debt_payment.updatedby,
	c_debt_payment.isreceipt,
	c_debt_payment.c_settlement_cancel_id,
	c_debt_payment.c_settlement_generate_id,
	c_debt_payment.description,
	c_debt_payment.c_invoice_id,
	c_debt_payment.c_bpartner_id,
	c_debt_payment.c_currency_id,
	c_debt_payment.c_cashline_id,
	c_debt_payment.c_bankaccount_id,
	c_debt_payment.c_cashbook_id,
	c_debt_payment.paymentrule,
	c_debt_payment.ispaid,
	c_debt_payment.dateplanned,
	c_debt_payment.ismanual,
	c_debt_payment.isvalid,
	c_debt_payment.c_bankstatementline_id,
	c_debt_payment.changesettlementcancel,
	c_debt_payment.cancel_processed,
	c_debt_payment.generate_processed,
	c_debt_payment.c_withholding_id,
	c_debt_payment.withholdingamount,
CASE c_debt_payment.isreceipt
    WHEN 'Y'::bpchar THEN c_debt_payment.amount
    ELSE c_debt_payment.amount * (-1)::numeric
END AS amount, 
CASE c_debt_payment.isreceipt
    WHEN 'Y'::bpchar THEN c_debt_payment.writeoffamt
    ELSE c_debt_payment.writeoffamt * (-1)::numeric
END AS writeoffamt, 
CASE c_debt_payment.isreceipt
    WHEN 'Y'::bpchar THEN c_debt_payment.discountamt
    ELSE c_debt_payment.discountamt * (-1)::numeric
END AS discountamt, 
CASE c_debt_payment.isreceipt
    WHEN 'Y'::bpchar THEN 1
    ELSE (-1)
END AS multiplierap, 
CASE
    WHEN c_debt_payment.c_invoice_id IS NOT NULL THEN c_invoice.dateinvoiced
    WHEN c_debt_payment.c_settlement_generate_id IS NOT NULL THEN c_settlement.datetrx
    ELSE to_date(now())
END AS docdate, c_debt_payment.glitemamt, c_debt_payment.c_order_id, c_debt_payment.status,
	c_debt_payment.isapproved
FROM c_debt_payment
LEFT JOIN c_invoice ON c_debt_payment.c_invoice_id::text = c_invoice.c_invoice_id::text
LEFT JOIN c_settlement ON c_debt_payment.c_settlement_generate_id::text = c_settlement.c_settlement_id::text;


CREATE OR REPLACE FUNCTION c_period_trg2() RETURNS trigger
    LANGUAGE plpgsql
    AS $_$ DECLARE 

/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, 02/2012, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************
    */
    v_count numeric;
        
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;

    IF TG_OP = 'DELETE' or TG_OP = 'UPDATE'  THEN 
        select count(*) into v_count from c_periodcontrol where c_period_id=old.c_period_id and periodstatus!='N';
        if v_count>0 then
            raise exception '%', '@cannotdeleteUsedperiods@';
        end if;
    END IF;
    IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 

END; $_$;

select zsse_droptrigger('c_period_trg2','c_period');

CREATE TRIGGER c_period_trg2
  BEFORE INSERT OR UPDATE OR DELETE
  ON c_period
  FOR EACH ROW
  EXECUTE PROCEDURE c_period_trg2();

  
  
  
  
CREATE OR REPLACE FUNCTION zsfi_fact_error_log_trg() RETURNS trigger
    LANGUAGE plpgsql
    AS $_$ DECLARE 
-- RESET of ACCOUNTING-ERRORS
    v_sql varchar;       
BEGIN
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;

    IF TG_OP = 'DELETE' THEN 
        v_sql:='update '||old.tablename||' set posted='||chr(39)||'N'||chr(39)||' where posted='||chr(39)||'E'||chr(39)||' and '||old.tablename||'_id='||chr(39)||old.sourceid||chr(39);
        EXECUTE(v_sql);
    END IF;
    IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END; $_$;

select zsse_droptrigger('zsfi_fact_error_log_trg','zsfi_fact_error_log');

CREATE TRIGGER zsfi_fact_error_log_trg
  BEFORE DELETE
  ON zsfi_fact_error_log
  FOR EACH ROW
  EXECUTE PROCEDURE zsfi_fact_error_log_trg();
  
  
  
  
  
  
/**************************************************************************************************


Foreign Currency Functions


***************************************************************************************************/
  
CREATE OR REPLACE FUNCTION c_currency_rate(p_curfrom_id character varying, p_curto_id character varying, p_convdate timestamp without time zone, p_ratetype character varying, p_client_id character varying, p_org_id character varying) RETURNS numeric
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/*************************************************************************
* The contents of this file are subject to the Compiere Public
* License 1.1 ("License"); You may not use this file except in
* compliance with the License. You may obtain a copy of the License in
* the legal folder of your Openbravo installation.
* Software distributed under the License is distributed on an
* "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
* implied. See the License for the specific language governing rights
* and limitations under the License.
* The Original Code is  Compiere  ERP &  Business Solution
* The Initial Developer of the Original Code is Jorg Janke and ComPiere, Inc.
* Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke,
* parts created by ComPiere are Copyright (C) ComPiere, Inc.;
* All Rights Reserved.
* Contributor(s): Openbravo SL
* Contributions are Copyright (C) 2001-2009 Openbravo, S.L.
*
* Specifically, this derivative work is based upon the following Compiere
* file and version.
*************************************************************************
* $Id: C_Currency_Rate.sql,v 1.5 2003/03/17 20:32:24 jjanke Exp $
***
* Title: Return Conversion Rate
* Description:
*  from CurrencyFrom_ID to CurrencyTo_ID
*  Returns NULL, if rate not found
* Test
*  SELECT C_Currency_Rate(116, 100, null, null) FROM DUAL; => .647169
************************************************************************/
  -- Currency From variables
  v_cf_IsEuro      char(1);
  -- Triangle
  v_CurrencyFrom VARCHAR(32);
  v_CurrencyTo   VARCHAR(32);
  v_CurrencyEuro VARCHAR(32);
  --
  v_ConvDate TIMESTAMP := TO_DATE(NOW());
  v_RateType VARCHAR(60) := 'S';
  v_Rate     NUMERIC;

  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_ClientName VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_OrgName VARCHAR(2000):=''; --OBTG:VARCHAR2--
  CUR_Rate RECORD;
BEGIN
  -- No Conversion
  IF(p_CurFrom_ID = p_CurTo_ID) THEN
    RETURN 1;
  END IF;
   -- Flexible Rates
  v_CurrencyFrom := p_CurFrom_ID;
  v_CurrencyTo := p_CurTo_ID;
  -- Default Parameter
  IF(p_ConvDate IS NOT NULL) THEN
    v_ConvDate := p_ConvDate;
  END IF;
  IF(p_RateType IS NOT NULL) THEN
    v_RateType := p_RateType;
  END IF;
  IF (v_CurrencyFrom IS NULL OR v_CurrencyTo IS NULL OR v_ConvDate IS NULL) THEN
      RETURN NULL;
  end if;
  
  -- Get Rate
  --TYPE RECORD IS REFCURSOR;
    FOR CUR_Rate IN
      (SELECT MultiplyRate
      FROM C_Conversion_Rate
      WHERE C_Currency_ID = v_CurrencyFrom
        AND C_Currency_ID_To = v_CurrencyTo
        AND ConversionRateType = v_RateType
        AND v_ConvDate BETWEEN ValidFrom AND ValidTo
        AND AD_Org_ID IN ('0', p_Org_ID)
        AND IsActive = 'Y'
      ORDER BY AD_Client_ID DESC,
        AD_Org_ID DESC,
        ValidFrom DESC
      )
    LOOP
      v_Rate := CUR_Rate.MultiplyRate;
      EXIT; -- only first
    END LOOP;
  -- Not found - Change from/to and take Kehrwert ....
  IF(v_Rate IS NULL) THEN
    FOR CUR_Rate IN
      (SELECT 1/MultiplyRate as MultiplyRate
      FROM C_Conversion_Rate
      WHERE C_Currency_ID = v_CurrencyTo
        AND C_Currency_ID_To = v_CurrencyFrom
        AND ConversionRateType = v_RateType
        AND v_ConvDate BETWEEN ValidFrom AND ValidTo
        AND AD_Org_ID IN ('0', p_Org_ID)
        AND IsActive = 'Y'
      ORDER BY AD_Client_ID DESC,
        AD_Org_ID DESC,
        ValidFrom DESC
      )
    LOOP
      v_Rate := CUR_Rate.MultiplyRate;
      EXIT; -- only first
    END LOOP;
    if (v_Rate IS NULL) THEN
      v_Message:='@NoConversionRate@' || ' ' || C_CURRENCY_ISOSYM(v_CurrencyFrom) || ' '
        || '@to@' || ' ' || C_CURRENCY_ISOSYM(v_CurrencyTo) || ' ' || '@ForDate@' || ' ''' || TO_CHAR(v_ConvDate)
        || ''', ' || '@Client@' || ' ''' || v_ClientName || ''' ' || '@And@' || ' ' || '@ACCS_AD_ORG_ID_D@' || ' ''' || v_OrgName || '''.';
      RAISE EXCEPTION '%', v_Message; --OBTG:-20000--
    END IF;
  END IF;
  -- Currency From was EMU
  RETURN v_Rate;
EXCEPTION
WHEN OTHERS THEN
  RAISE NOTICE '%',SQLERRM ;
  RAISE EXCEPTION '%', SQLERRM;
END ; $_$;
 
  
  
  
CREATE OR REPLACE FUNCTION c_currency_convert(p_amount numeric, p_curfrom_id character varying, p_curto_id character varying, p_convdate timestamp without time zone, p_ratetype character varying, p_client_id character varying, p_org_id character varying) RETURNS numeric
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/*************************************************************************
* The contents of this file are subject to the Compiere Public
* License 1.1 ("License"); You may not use this file except in
* compliance with the License. You may obtain a copy of the License in
* the legal folder of your Openbravo installation.
* Software distributed under the License is distributed on an
* "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
* implied. See the License for the specific language governing rights
* and limitations under the License.
* The Original Code is  Compiere  ERP &  Business Solution
* The Initial Developer of the Original Code is Jorg Janke and ComPiere, Inc.
* Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke,
* parts created by ComPiere are Copyright (C) ComPiere, Inc.;
* All Rights Reserved.
* Contributor(s): Openbravo SL
* Contributions are Copyright (C) 2001-2009 Openbravo, S.L.
*
* Specifically, this derivative work is based upon the following Compiere
* file and version.
*************************************************************************
* $Id: C_Currency_Convert.sql,v 1.8 2003/03/17 20:32:24 jjanke Exp $
***
* Title: Convert Amount (using IDs)
* Description:
*  from CurrencyFrom_ID to CurrencyTo_ID
*  Returns NULL, if conversion not found
*  Standard Rounding
* Test:
*  SELECT C_Currency_Convert(100,116,100,null,null) FROM DUAL => 64.72
************************************************************************/
  v_Rate NUMERIC;
BEGIN
  -- Return Amount
  IF(p_Amount=0 OR p_CurFrom_ID=p_CurTo_ID) THEN
    RETURN p_Amount;
  END IF;
  -- Return NULL
  IF(p_Amount IS NULL OR p_CurFrom_ID IS NULL OR p_CurTo_ID IS NULL) THEN
    RETURN NULL;
  END IF;
  -- Get Rate
  v_Rate:=C_Currency_Rate(p_CurFrom_ID, p_CurTo_ID, p_ConvDate, p_RateType, p_Client_ID, p_Org_ID) ;
  IF(v_Rate IS NULL) THEN
    RETURN NULL;
  END IF;
  -- Standard Precision
  RETURN C_Currency_Round(p_Amount * v_Rate, p_CurTo_ID, null) ;
EXCEPTION
WHEN OTHERS THEN
  RAISE NOTICE '%',SQLERRM ;
  RAISE EXCEPTION '%', SQLERRM;
END ; $_$;



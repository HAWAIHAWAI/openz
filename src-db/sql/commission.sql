CREATE OR REPLACE FUNCTION c_commission_process (p_pinstance_id varchar) RETURNS void 
LANGUAGE plpgsql AS $body$
 DECLARE
/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Martin Hinrichs, 12/2011, info@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Zimmermann-Software
*
****************************************************************************************************************************************************/
  -- Logistice
   v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
   v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
   v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
   -- Parameter
   --TYPE RECORD IS REFCURSOR;
   Cur_Parameter RECORD;
   -- Parameter Variables
   p_StartDate TIMESTAMP;
   --
   v_AD_Client_ID VARCHAR(32); --OBTG:VARCHAR2--
   v_AD_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
   v_Name VARCHAR(90); --OBTG:VARCHAR2--
   v_Currency VARCHAR(10); --OBTG:VARCHAR2--
   v_FrequencyType VARCHAR(60);
   v_DocBasisType VARCHAR(60);
   v_ListDetails VARCHAR(60);
   v_SalesRep_ID VARCHAR(32); --OBTG:VARCHAR2--
   --
   v_StartDate TIMESTAMP;
   v_EndDate TIMESTAMP;
   v_C_CommissionRun_ID VARCHAR(32); --OBTG:VARCHAR2--
   v_NextNo VARCHAR(32); --OBTG:VARCHAR2--
   v_DocumentNo VARCHAR(40);
  BEGIN
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID;
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL);
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
      WHERE i.AD_PInstance_ID=p_PInstance_ID
      ORDER BY p.SeqNo
      )
    LOOP
      v_Record_ID:=Cur_Parameter.Record_ID;
      IF(Cur_Parameter.ParameterName='StartDate') THEN
        p_StartDate:=Cur_Parameter.P_Date;
        RAISE NOTICE '%','  StartDate=' || p_StartDate;
      ELSE
        RAISE NOTICE '%','*** Unknown Parameter=' || Cur_Parameter.ParameterName;
      END IF;
    END LOOP; -- Get Parameter
    RAISE NOTICE '%','  Record_ID=' || v_Record_ID;
    /**
    * Create Header + Determine TIMESTAMP Range
    */
    v_ResultStr:='ReadingRecord';
    SELECT AD_Client_ID,
      AD_Org_ID,
      Name,
      FrequencyType,
      DocBasisType,
      ListDetails,
      C_BPartner_ID
    INTO v_AD_Client_ID,
      v_AD_Org_ID,
      v_Name,
      v_FrequencyType,
      v_DocBasisType,
      v_ListDetails,
      v_SalesRep_ID
    FROM C_Commission
    WHERE C_Commission_ID=v_Record_ID;
    --
    SELECT ISO_Code
    INTO v_Currency
    FROM C_Currency cur,
      C_Commission com
    WHERE cur.C_Currency_ID=com.C_Currency_ID
      AND com.C_Commission_ID=v_Record_ID;
    --
    v_ResultStr:='CalculatingHeader';
    IF(p_StartDate IS NULL) THEN
      p_StartDate:=TO_DATE(NOW());
    END IF;
    --
    IF(v_FrequencyType='Q') THEN -- Quarter
      v_StartDate:=TRUNC(p_StartDate, 'Q');
      v_EndDate:=TRUNC(v_StartDate+93, 'Q') -1;
    ELSIF(v_FrequencyType='W') THEN -- Weekly
      v_StartDate:=TRUNC(p_StartDate, 'DAY');
      v_EndDate:=TRUNC(v_StartDate+7, 'DAY') -1;
    ELSE -- Month
      v_StartDate:=TRUNC(p_StartDate, 'MM');
      v_EndDate:=TRUNC(v_StartDate+32, 'MM') -1;
    END IF;
    -- Name 01-Jan-2000 - 31-Jan-2001 - USD
    v_Name:=v_Name || ' ' || TO_CHAR(v_StartDate) || ' - ' || TO_CHAR(v_EndDate) || ' - ' || v_Currency;
    SELECT * INTO  v_C_CommissionRun_ID FROM AD_Sequence_Next('C_CommissionRun', v_AD_Client_ID);
    SELECT * INTO  v_DocumentNo FROM AD_Sequence_Doc('DocumentNo_C_CommissionRun', v_AD_Org_ID, 'Y');
    RAISE NOTICE '%','Create: ' || v_DocumentNo || ' - ' || v_Name;
    v_ResultStr:='InsertingHeader';
    INSERT
    INTO C_CommissionRun
      (
        C_CommissionRun_ID, C_Commission_ID, AD_Client_ID, AD_Org_ID,
        IsActive, Created, CreatedBy, Updated,
        UpdatedBy, DocumentNo, Description, StartDate,
        GrandTotal, Processing, Processed
      )
      VALUES
      (
        v_C_CommissionRun_ID, v_Record_ID, v_AD_Client_ID, v_AD_Org_ID,
         'Y', TO_DATE(NOW()), '0', TO_DATE(NOW()),
        '0', v_DocumentNo, v_Name, v_StartDate,
        0, 'N', 'N'
      )
      ;
    --
    v_ResultStr:='Update Record';
    UPDATE C_Commission
      SET DateLastRun=TO_DATE(NOW())
    WHERE C_Commission_ID=v_Record_ID;
    /**
    * Calculate Lines
    */
    DECLARE
      CUR_CLine RECORD;
    TYPE_Ref REFCURSOR;
      v_rc TYPE_REF%TYPE;
      --
      v_Cmd VARCHAR(2000):=''; --OBTG:VARCHAR2--
      v_C_CommissionAmt_ID VARCHAR(32); --OBTG:VARCHAR2--
      --
      v_C_Currency_ID C_CommissionDetail.C_Currency_ID%TYPE;
      v_Amt C_CommissionDetail.ActualAmt%TYPE;
      v_Qty C_CommissionDetail.ActualQty%TYPE;
      v_C_OrderLine_ID VARCHAR(32); --OBTG:VARCHAR2--
      v_C_InvoiceLine_ID VARCHAR(32); --OBTG:VARCHAR2--
      v_Reference C_CommissionDetail.Reference%TYPE;
      v_Info C_CommissionDetail.Info%TYPE;
      --
    BEGIN
      FOR CUR_CLine IN
        (SELECT *  FROM C_CommissionLine  WHERE C_Commission_ID=v_Record_ID AND IsActive='Y')
      LOOP
        v_ResultStr:='InsertingAmt';
        -- For every Commission Line create empty Amt line (updated by Detail)
        SELECT * INTO  v_C_CommissionAmt_ID FROM AD_Sequence_Next('C_CommissionAmt', v_AD_Client_ID);
        INSERT
        INTO C_CommissionAmt
          (
            C_CommissionAmt_ID, C_CommissionRun_ID, C_CommissionLine_ID, AD_Client_ID,
            AD_Org_ID, IsActive, Created, CreatedBy, Updated,
            UpdatedBy, ConvertedAmt, ActualQty, CommissionAmt
          )
          VALUES
          (
            v_C_CommissionAmt_ID, v_C_CommissionRun_ID, CUR_CLine.C_CommissionLine_ID, v_AD_Client_ID,
            v_AD_Org_ID, 'Y', TO_DATE(NOW()), '0',
            TO_DATE(NOW()), '0', 0, 0,
            0
          ); -- Calculation done by Trigger
          
        -- DBMS_OUTPUT.PUT_LINE('- ' || CUR_CLine.Line);
        v_ResultStr:='AssemblingDynSQL';
        -- Receipt Basis
        IF(v_DocBasisType='R') THEN
          v_ResultStr:='To develope';
          /*IF (v_ListDetails = 'Y') THEN
          v_Cmd := 'SELECT h.C_Currency_ID, l.LineNetAmt, l.QtyInvoiced, '
          || 'NULL, l.C_InvoiceLine_ID, p.DocumentNo || ''_'' || h.DocumentNo, COALESCE(prd.Name,l.Description) '
          || 'FROM C_Payment p, C_Invoice h, C_InvoiceLine l LEFT JOIN M_Product prd ON l.M_Product_ID = prd.M_Product_ID '
          || 'WHERE p.C_Invoice_ID = h.C_Invoice_ID'
          || ' AND p.DocStatus IN (''CL'',''CO'')'
          || ' AND h.C_Invoice_ID = l.C_Invoice_ID'
          || ' AND h.AD_Client_ID = '':1'''
          || ' AND h.DateInvoiced >= to_date('':2'')'
          || ' AND h.DateInvoiced < to_date('':3'') +1';
          || ' ';
          ELSE
          v_Cmd := 'SELECT h.C_Currency_ID, SUM(l.LineNetAmt) AS Amt, SUM(l.QtyInvoiced) AS Qty, '
          || 'NULL, NULL, NULL, NULL '
          || 'FROM C_Payment p, C_Invoice h, C_InvoiceLine l '
          || 'WHERE p.C_Invoice_ID = h.C_Invoice_ID'
          || ' AND p.DocStatus IN (''CL'',''CO'')'
          || ' AND h.C_Invoice_ID = l.C_Invoice_ID'
          || ' AND h.AD_Client_ID = '':1'''
          || ' AND h.DateInvoiced >= to_date('':2'')'
          || ' AND h.DateInvoiced < to_date('':3'') +1';
          END IF;*/
          -- Invoice Basis
        ELSIF(v_DocBasisType='I') THEN
          IF(v_ListDetails='Y') THEN
            v_Cmd:='SELECT h.C_Currency_ID, l.LineNetAmt, l.QtyInvoiced, '
            || 'NULL, l.C_InvoiceLine_ID, h.DocumentNo, substr(COALESCE(prd.Name,l.Description),1,60) '
            || 'FROM C_Invoice h, C_InvoiceLine l LEFT JOIN M_Product prd ON l.M_Product_ID = prd.M_Product_ID '
            || 'WHERE h.C_Invoice_ID = l.C_Invoice_ID'
            || ' AND h.DocStatus IN (''CL'',''CO'')'
            || ' AND h.ISSOTRX = ''Y'''
            || ' AND h.AD_Client_ID = '':1'''
            || ' AND h.DateInvoiced >= to_date('':2'')'
            || ' AND h.DateInvoiced < to_date('':3'') +1';
          ELSE
            v_Cmd:='SELECT h.C_Currency_ID, SUM(l.LineNetAmt) AS Amt, SUM(l.QtyInvoiced) AS Qty, '
            || 'NULL, NULL, NULL, NULL '
            || 'FROM C_Invoice h, C_InvoiceLine l '
            || 'WHERE h.C_Invoice_ID = l.C_Invoice_ID'
            || ' AND h.DocStatus IN (''CL'',''CO'')'
            || ' AND h.ISSOTRX = ''Y'''
            || ' AND h.AD_Client_ID = '':1'''
            || ' AND h.DateInvoiced >= to_date('':2'')'
            || ' AND h.DateInvoiced < to_date('':3'') +1';
          END IF;
          -- Order Basis
        ELSE
          IF(v_ListDetails='Y') THEN
            v_Cmd:='SELECT h.C_Currency_ID, l.LineNetAmt, l.QtyOrdered, '
            || 'l.C_OrderLine_ID, NULL, h.DocumentNo, substr(COALESCE(prd.Name,l.Description),1,60) '
            || 'FROM C_Order h, C_OrderLine l LEFT JOIN M_Product prd ON l.M_Product_ID = prd.M_Product_ID '
            || 'WHERE h.C_Order_ID = l.C_Order_ID'
            || ' AND h.DocStatus IN (''CL'',''CO'')'
            || ' AND h.ISSOTRX = ''Y'''
            || ' AND h.AD_Client_ID = '':1'''
            || ' AND h.DateOrdered >= to_date('':2'')'
            || ' AND h.DateOrdered < to_date('':3'') +1';
          ELSE
            v_Cmd:='SELECT h.C_Currency_ID, SUM(l.LineNetAmt) AS Amt, SUM(l.QtyOrdered) AS Qty, '
            || 'NULL, NULL, NULL, NULL '
            || 'FROM C_Order h, C_OrderLine l '
            || 'WHERE h.C_Order_ID = l.C_Order_ID'
            || ' AND h.DocStatus IN (''CL'',''CO'')'
            || ' AND h.ISSOTRX = ''Y'''
            || ' AND h.AD_Client_ID = '':1'''
            || ' AND h.DateOrdered >= to_date('':2'')'
            || ' AND h.DateOrdered < to_date('':3'') +1';
          END IF;
        END IF;
        -- CommissionOrders/Invoices
        IF(CUR_CLine.CommissionOrders='Y') THEN
          v_Cmd:=v_Cmd || ' AND h.SalesRep_ID = (SELECT AD_User_ID FROM AD_User WHERE C_BPartner_ID=''' || v_SalesRep_ID || ''')';
        END IF;
        -- Organization
        IF(CUR_CLine.Org_ID IS NOT NULL) THEN
          v_Cmd:=v_Cmd || ' AND h.AD_Org_ID=''' || CUR_CLine.Org_ID || '''';
        END IF;
        -- BPartner
        IF(CUR_CLine.C_BPartner_ID IS NOT NULL) THEN
          v_Cmd:=v_Cmd || ' AND h.C_BPartner_ID=''' || CUR_CLine.C_BPartner_ID || '''';
        END IF;
        -- BPartner Group
        IF(CUR_CLine.C_BP_Group_ID IS NOT NULL) THEN
          v_Cmd:=v_Cmd || ' AND h.C_BPartner_ID IN'  || '(SELECT C_BPartner_ID FROM C_BPartner WHERE C_BP_Group_ID=''' || CUR_CLine.C_BP_Group_ID || ''')';
        END IF;
        -- Sales Region
        IF(CUR_CLine.C_SalesRegion_ID IS NOT NULL) THEN
          v_Cmd:=v_Cmd || ' AND h.C_BPartner_Location_ID IN '  || '(SELECT C_BPartner_Location_ID FROM C_BPartner_Location WHERE C_SalesRegion_ID=''' || CUR_CLine.C_SalesRegion_ID || ''')';
        END IF;
        -- Product
        IF(CUR_CLine.M_Product_ID IS NOT NULL) THEN
          v_Cmd:=v_Cmd || ' AND l.M_Product_ID=''' || CUR_CLine.M_Product_ID || '''';
        END IF;
        -- Product Category
        IF(CUR_CLine.M_Product_Category_ID IS NOT NULL) THEN
          v_Cmd:=v_Cmd || ' AND l.M_Product_ID IN '  || '(SELECT M_Product_ID FROM M_Product WHERE M_Product_Category_ID=''' || CUR_CLine.M_Product_Category_ID ||''')';
        END IF;
        -- Grouping
        IF(v_ListDetails<>'Y') THEN
          v_Cmd:=v_Cmd || ' GROUP BY h.C_Currency_ID';
        END IF;
        --
        -- DBMS_OUTPUT.PUT_LINE('- ' || CUR_CLine.Line || ' SQL=' || SUBSTR(v_Cmd, 1, 200));
        -- DBMS_OUTPUT.PUT_LINE(SUBSTR(v_Cmd, 200,200));
        -- DBMS_OUTPUT.PUT_LINE(SUBSTR(v_Cmd, 400));
        --
        v_ResultStr:='OpenDynCursor';
        SELECT REPLACE(REPLACE(REPLACE(v_Cmd, ':1', to_char(v_AD_Client_ID)), ':2', to_char(v_StartDate)), ':3', to_char(v_EndDate)) INTO v_Cmd FROM DUAL;
        OPEN  v_rc  FOR EXECUTE  v_Cmd;
        LOOP
          v_ResultStr:='FetchingData';
          FETCH v_rc INTO v_C_Currency_ID,
          v_Amt,
          v_Qty,
          v_C_OrderLine_ID,
          v_C_InvoiceLine_ID,
          v_Reference,
          v_Info;
          EXIT WHEN  NOT FOUND; --OBTG:v_rc--
          --
          v_ResultStr:='InsertingDetail';
          SELECT * INTO  v_NextNo FROM AD_Sequence_Next('C_CommissionDetail', v_AD_Client_ID);
          INSERT
          INTO C_CommissionDetail
            (
              C_CommissionDetail_ID, C_CommissionAmt_ID, AD_Client_ID, AD_Org_ID,
              IsActive, Created, CreatedBy, Updated,
              UpdatedBy, C_Currency_ID, ActualAmt, ConvertedAmt,
              ActualQty,
              C_OrderLine_ID, C_InvoiceLine_ID, Reference, Info
            )
            VALUES
            (
              v_NextNo, v_C_CommissionAmt_ID, v_AD_Client_ID, v_AD_Org_ID,
               'Y', TO_DATE(NOW()), '0', TO_DATE(NOW()),
              '0', v_C_Currency_ID, v_Amt, 0,
              v_Qty, -- Conversion done by Trigger
              v_C_OrderLine_ID, v_C_InvoiceLine_ID, v_Reference, v_Info
            )
            ;
          --
          -- DBMS_OUTPUT.PUT_LINE('  ' || v_Reference || ' - ' || v_Amt || ' - ' || v_Qty);
        END LOOP;
        CLOSE v_rc;
        --
      END LOOP; -- For every Commission Line
    END;
    v_Message:='@CommissionRun@ = ' || v_DocumentNo || ' - ' || v_Name;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message);
    RETURN;
  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr;
  -- ROLLBACK;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_ResultStr);
  RETURN;
END; $body$;

ALTER FUNCTION public.c_commission_process(p_pinstance_id character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION c_commissionrun_process(p_pinstance_id character varying) RETURNS void
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
* Contributor(s): Martin Hinrichs, 2011-12-20, info@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Zimmermann-Software
*
****************************************************************************************************************************************************/
 -- Logistice
  v_ResultStr     VARCHAR(2000) := ''; --OBTG:VARCHAR2--
  v_Message     VARCHAR(2000) := ''; --OBTG:VARCHAR2--
  v_Record_ID      VARCHAR(32); --OBTG:varchar2--
  v_Result      NUMERIC(10) := 1; -- Success
  -- Parameter
  --TYPE RECORD IS REFCURSOR;
  Cur_Parameter RECORD;
  -- Parameter Variables

  CUR_ComRun RECORD;
  --
  v_C_DocType_ID     VARCHAR(32); --OBTG:varchar2--
  v_C_Invoice_ID     VARCHAR(32); --OBTG:varchar2--
  v_NextNo      VARCHAR(32); --OBTG:VARCHAR2--
  v_DocumentNo     VARCHAR(40); --OBTG:VARCHAR2--
  v_SalesRep_ID     VARCHAR(32); --OBTG:varchar2--
  --
  v_C_BPartner_ID     VARCHAR(32); --OBTG:varchar2--
  v_C_BPartner_Location_ID  VARCHAR(32); --OBTG:varchar2--

  v_C_COMMISSION_Orgid      VARCHAR(32);  -- 2011-12-20
  v_AD_PINSTANCE_CreatedBy  VARCHAR(32);  -- 2011-12-20
  v_now                     TIMESTAMP;     -- 2011-12-20

  v_partnername VARCHAR(100); --OBTG:VARCHAR2--
  v_C_PaymentTerm_ID    VARCHAR(32); --OBTG:varchar2--
  v_C_Currency_ID     VARCHAR(32); --OBTG:varchar2--
  v_PaymentRule     VARCHAR(60);
  v_M_PriceList_ID    VARCHAR(32); --OBTG:varchar2--
  v_POReference     VARCHAR(20); --OBTG:varchar2--
  v_Product_ID     VARCHAR(32); --OBTG:varchar2--
  v_Tax_ID      VARCHAR(32); --OBTG:varchar2--
  v_UOM_ID      VARCHAR(32); --OBTG:varchar2--
  v_IsDiscountPrinted    CHAR(1);
  v_CommissionName VARCHAR(60);
  FINISH_PROCESS BOOLEAN := false;
BEGIN
  --  Update AD_PInstance
  RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID;
  v_ResultStr := 'PInstanceNotFound';
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL);
      -- p_pinstance_id varchar, p_ad_user_id varchar, p_isprocessing char, p_result numeric, p_message varchar

  SELECT Updated, updatedBy INTO v_now, v_AD_PINSTANCE_CreatedBy
  FROM ad_pinstance pi
  WHERE pi.AD_PInstance_ID = p_PInstance_ID;

  BEGIN --BODY
    -- Get Parameters
    v_ResultStr := 'ReadingParameters';
    FOR Cur_Parameter IN (
      SELECT
        i.Record_ID, i.UpdatedBy,
        p.ParameterName, p.P_String, p.P_Number, p.P_Date
      FROM AD_PINSTANCE i
        LEFT JOIN AD_PINSTANCE_PARA p ON i.AD_PInstance_ID=p.AD_PInstance_ID
      WHERE i.AD_PInstance_ID=p_PInstance_ID
      ORDER BY p.SeqNo)
    LOOP
      v_Record_ID := Cur_Parameter.Record_ID;
      -- IF (Cur_Parameter.ParameterName = 'xx') THEN
      --  xx := Cur_Parameter.P_String;
      --  DBMS_OUTPUT.PUT_LINE('  xx=' || xx);
      -- ELSE
      --  DBMS_OUTPUT.PUT_LINE('*** Unknown Parameter=' || Cur_Parameter.ParameterName);
      --  END IF;
    END LOOP; -- Get Parameter
    RAISE NOTICE '%','  Record_ID=' || v_Record_ID;

    FOR CUR_ComRun IN (
     SELECT *
     FROM C_COMMISSIONRUN
     WHERE C_CommissionRun_ID = v_Record_ID)
    LOOP

    -- Create Header
    v_ResultStr := 'GetDocTypeInfo';
    v_C_DocType_ID := Ad_Get_DocType(CUR_ComRun.AD_Client_ID,CUR_ComRun.AD_Org_ID, 'API');
    v_C_COMMISSION_Orgid := CUR_ComRun.AD_Org_ID; -- 2011-12-20

    DECLARE Cur_Data RECORD;
      BEGIN
        FOR Cur_Data IN (
          SELECT com.Name, com.C_Currency_ID, com.C_BPartner_ID, pl.C_BPartner_Location_ID,
            PaymentRulePO, PO_PaymentTerm_ID, PO_PriceList_ID,
            POReference, IsDiscountPrinted, p.SalesRep_ID, com.M_Product_ID, C_UOM_ID, p.name as bpartnername
         FROM  C_BPARTNER p, C_COMMISSION com
           LEFT JOIN C_BPARTNER_LOCATION pl ON com.C_BPartner_ID = pl.C_BPartner_ID
           LEFT JOIN M_Product prd ON com.M_Product_ID = prd.M_Product_ID
         WHERE com.C_Commission_ID = CUR_ComRun.C_Commission_ID
           AND com.C_BPartner_ID = p.C_BPartner_ID)
        LOOP
          v_CommissionName:=Cur_Data.Name;
          v_C_Currency_ID:=Cur_Data.C_Currency_ID;
          v_C_BPartner_ID:=Cur_Data.C_BPartner_ID;
          v_C_BPartner_Location_ID:=Cur_Data.C_BPartner_Location_ID;
          v_PaymentRule:=Cur_Data.PaymentRulePO;
          v_C_PaymentTerm_ID:=Cur_Data.PO_PaymentTerm_ID;
          v_M_PriceList_ID:=Cur_Data.PO_PriceList_ID;
          v_POReference:=Cur_Data.POReference;
          v_IsDiscountPrinted:=Cur_Data.IsDiscountPrinted;
          v_SalesRep_ID:=Cur_Data.SalesRep_ID;
          v_Product_ID:=Cur_Data.M_Product_ID;
          v_UOM_ID:=Cur_Data.C_UOM_ID;
          v_partnername:=Cur_Data.bpartnername;
          EXIT;
       END LOOP;
      END;
      --
      IF (v_PaymentRule IS NULL) THEN
       v_PaymentRule := 'P';
      END IF;
      IF (v_IsDiscountPrinted IS NULL) THEN
       v_IsDiscountPrinted := 'N';
      END IF;
      IF (v_Product_ID IS NULL) THEN
         RAISE EXCEPTION '%', '@Commission@ '||v_CommissionName||' @InvoicedProductNotdefined@'; --OBTG:-20000--
      END IF;
      IF (v_C_BPartner_Location_ID IS NULL) THEN
         RAISE EXCEPTION '%', '@ThebusinessPartner@ '||v_partnername||' @ShiptoNotdefined@'; --OBTG:-20000--
      END IF;
      IF (v_C_PaymentTerm_ID IS NULL) THEN
         RAISE EXCEPTION '%', '@ThebusinessPartner@ '||v_partnername||' @PaymenttermNotdefined@'; --OBTG:-20000--
      END IF;
      IF (v_M_PriceList_ID IS NULL) THEN
       RAISE EXCEPTION '%', '@ThebusinessPartner@ '||v_partnername||' @PricelistNotdefined@'; --OBTG:-20000--
      END IF;

      IF (NOT FINISH_PROCESS) THEN
      --
        v_ResultStr := 'GetDocSequenceInfo';
        SELECT * INTO  v_C_Invoice_ID FROM Ad_Sequence_Next('C_Invoice', CUR_ComRun.AD_Client_ID);

        SELECT * INTO  v_DocumentNo FROM Ad_Sequence_Doctype(v_C_DocType_ID, CUR_ComRun.AD_Org_ID, 'Y');
        IF (v_DocumentNo IS NULL) THEN
          SELECT * INTO  v_DocumentNo FROM Ad_Sequence_Doc('DocumentNo_C_Invoice', CUR_ComRun.AD_Org_ID, 'Y');
        END IF;
        IF (v_DocumentNo IS NULL) THEN
         v_DocumentNo := CUR_ComRun.DocumentNo;
        END IF;
        --
        RAISE NOTICE '%','  Invoice_ID=' || v_C_Invoice_ID || ' DocumentNo=' || v_DocumentNo;
        --
        v_ResultStr := 'InsertInvoice ' || v_C_Invoice_ID;
        INSERT INTO C_INVOICE
         (C_Invoice_ID, C_Order_ID,
          AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy,
          IsSOTrx, DocumentNo, DocStatus, DocAction, Processing, Processed,
          C_DocType_ID, C_DocTypeTarget_ID, Description,
          SalesRep_ID,
          DateInvoiced, DatePrinted, IsPrinted, DateAcct, TaxDate,
          C_PaymentTerm_ID, C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID,
          POReference, DateOrdered, IsDiscountPrinted,
          C_Currency_ID, PaymentRule, C_Charge_ID, ChargeAmt,
          TotalLines, GrandTotal,
          M_PriceList_ID, C_Campaign_ID, C_Project_ID, C_Activity_ID)
        VALUES
         (v_C_Invoice_ID, NULL,
         -- CUR_ComRun.AD_Client_ID, CUR_ComRun.AD_Org_ID, 'Y', TO_DATE(NOW()), '0', TO_DATE(NOW()), '0',
         CUR_ComRun.AD_Client_ID, CUR_ComRun.AD_Org_ID, 'Y', v_now, v_AD_PINSTANCE_CreatedBy, TO_DATE(NOW()), '0',
         'N', v_DocumentNo, 'DR', 'CO', 'N', 'N',
         v_C_DocType_ID, v_C_DocType_ID, CUR_ComRun.Description,
         v_SalesRep_ID,
         CUR_ComRun.Updated, NULL, 'N', CUR_ComRun.Updated, CUR_ComRun.Updated, -- DateInvoiced=DateAcct
         v_C_PaymentTerm_ID, v_C_BPartner_ID, v_C_BPartner_Location_ID, NULL,
         v_POReference, CUR_ComRun.Updated, v_IsDiscountPrinted,
         v_C_Currency_ID, v_PaymentRule, NULL, 0,
         0, 0,
         v_M_PriceList_ID, NULL, NULL, NULL);

        -- One line with Total (TODO: Tax, UOM)
        -- v_Tax_ID := C_Gettax (v_Product_ID,CUR_ComRun.Updated,CUR_ComRun.AD_Org_ID,NULL,v_C_BPartner_Location_ID,v_C_BPartner_Location_ID,NULL,'N');
        v_Tax_ID := zsfi_GetTax(v_C_BPartner_Location_ID, v_Product_ID, v_C_COMMISSION_Orgid); -- v_bplocid, v_product_id, v_orgid);

        v_ResultStr := 'InsertLine';
        SELECT * INTO  v_NextNo FROM Ad_Sequence_Next('C_InvoiceLine', CUR_ComRun.AD_Client_ID);
        INSERT INTO C_INVOICELINE
         (C_InvoiceLine_ID,
         AD_Client_ID, AD_Org_ID, IsActive, Created, CreatedBy, Updated, UpdatedBy,
         C_Invoice_ID, C_OrderLine_ID, M_InOutLine_ID,
         Line, Description,
         M_Product_ID, QtyInvoiced, PriceList, PriceActual, PriceLimit, LineNetAmt,
         C_Charge_ID, ChargeAmt, C_UOM_ID, C_Tax_ID
         --MODIFIED BY F.IRIAZABAL
         , QUANTITYORDER, M_PRODUCT_UOM_ID,
         PriceStd, M_Offer_ID)
        VALUES
         (v_NextNo,
         -- CUR_ComRun.AD_Client_ID, CUR_ComRun.AD_Org_ID, 'Y', TO_DATE(NOW()), '0', TO_DATE(NOW()), '0',
         CUR_ComRun.AD_Client_ID, CUR_ComRun.AD_Org_ID, 'Y', TO_DATE(NOW()), v_AD_PINSTANCE_CreatedBy, TO_DATE(NOW()), '0',
         v_C_Invoice_ID, NULL, NULL,
         10, NULL,
         v_Product_ID, 1, CUR_ComRun.GrandTotal, CUR_ComRun.GrandTotal, CUR_ComRun.GrandTotal, CUR_ComRun.GrandTotal,
         NULL, 0, v_UOM_ID, v_Tax_ID
         --MODIFIED BY F.IRIAZABAL
         , NULL, NULL,
         CUR_ComRun.GrandTotal, NULL);

        UPDATE C_CommissionRun
          SET C_Invoice_ID = v_C_Invoice_ID
          WHERE C_CommissionRun_ID = v_Record_ID;

      END IF;--FINISH_PROCESS
      v_Message := '@InvoiceDocumentno@ ' || v_DocumentNo;
    END LOOP;--FINISH_PROCESS


    -- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', v_Result, v_Message);
      RETURN;

  END; --BODY
  EXCEPTION
  WHEN OTHERS THEN
    v_ResultStr:= '@ERROR=' || SQLERRM;
    RAISE NOTICE '%',v_ResultStr;
    -- ROLLBACK;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_ResultStr);

  RETURN;
END; $_$;


CREATE OR REPLACE FUNCTION m_inout_trg2() RETURNS trigger
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************

Gets predefined Textmodules into Shipments

*****************************************************/

    v_count numeric;
    v_orgfrom character varying;
    v_cur RECORD; 
BEGIN
    
 
 IF(TG_OP = 'INSERT') then
     --Take Textmodule either from Org=0 or current organization 
     select count(*) into v_count from  zssi_textmodule where ad_org_id=new.ad_org_id;
     if v_count>0 then v_orgfrom:=new.ad_org_id;  else  v_orgfrom:='0'; end if;
     
     for v_cur in (select * from zssi_textmodule where c_doctype_id=new.c_doctype_id and ad_org_id=v_orgfrom and isactive='Y' order by islower,position)
     LOOP
        -- Get predefined Textmodules into Order
        insert into zssi_minout_textmodule (ZSSI_minout_TEXTMODULE_ID, zssi_textmodule_id,m_inout_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, LINE, ISLOWER, TEXT)
               values (get_uuid(),v_cur.zssi_textmodule_id,new.m_inout_id,new.ad_client_id,new.ad_org_id,new.createdby,new.updatedby,v_cur.position,v_cur.islower,v_cur.text);
     END LOOP;
  end if; --Inserting 
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END ; $_$;


drop trigger m_inout_trg2 on  m_inout;

CREATE TRIGGER m_inout_trg2
  AFTER INSERT
  ON m_inout
  FOR EACH ROW
  EXECUTE PROCEDURE m_inout_trg2();

CREATE OR REPLACE FUNCTION zssi_m_inout_trg()
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
Part of Smartprefs
Calculate Price-Updates COSTs for ITEMS on Purchase (Receipt)
*****************************************************/
v_purchase_price          numeric;
v_receipt_qty             numeric;
v_curr_onhand_qty         numeric;
v_curr_cost               numeric;
v_method                  character varying;
v_order_uom               character varying;
v_order_qty               numeric;
v_uom                     character varying;
v_uom_conversion          numeric;
v_actual_cost             numeric;
v_movementqty             numeric;
v_cur_line                m_inoutline%rowtype;
v_cost_id                 character varying;
v_permanent               character varying;
v_org_currency            character varying;
v_order_currency          character varying;
v_isdefault               character varying:='N';
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  -- Only when really booking the receipt from Vendors or Voiding the receipt
  if ((old.docaction='CO' and new.docaction!='CO') or (new.docstatus='VO' and old.docstatus!='VO')) and new.movementtype in ('V+','V-') and new.c_order_id is not null then
      -- Get Transction -Org and its Currency
      select c_currency_id into v_org_currency from ad_org_acctschema,c_acctschema where ad_org_acctschema.c_acctschema_id=c_acctschema.c_acctschema_id and ad_org_acctschema.ad_org_id=new.ad_org_id;
      -- Loop the Lines
      for v_cur_line in (select * from m_inoutline where m_inout_id=new.m_inout_id)
      LOOP
       -- Only if Processing a Product
       if v_cur_line.m_product_id is not null and v_cur_line.c_orderline_id is not null then
           -- Get Current Values
           select m_costing_id,ispermanent,COSTTYPE,COST into v_cost_id, v_permanent,   v_method, v_curr_cost from m_costing where M_PRODUCT_ID=v_cur_line.m_product_id  and ad_org_id =new.AD_Org_ID and DATETO =
                                                         (select max(DATETO) from m_costing where M_PRODUCT_ID=v_cur_line.m_product_id and ad_org_id =new.AD_Org_ID);
           if v_cost_id is null then
              -- Get default
              select m_costing_id,ispermanent,COSTTYPE,COST into v_cost_id, v_permanent,   v_method, v_curr_cost from m_costing where M_PRODUCT_ID=v_cur_line.m_product_id  and ad_org_id ='0' and DATETO =
                                                         (select max(DATETO) from m_costing where M_PRODUCT_ID=v_cur_line.m_product_id and ad_org_id ='0');
              v_isdefault:='Y';
           end if;
           -- Current onhand Quantities
           select COALESCE(sum(qtyonhand),0) into v_curr_onhand_qty from m_storage_detail where m_product_id=v_cur_line.m_product_id and AD_Client_ID=v_cur_line.AD_Client_ID and AD_Org_ID=v_cur_line.AD_Org_ID;
           -- Purchase Price, (Be aware of secondary Order UOM and Order-Currency
           select priceactual,m_product_uom_id,c_uom_id,quantityorder,c_currency_id into v_purchase_price,v_order_uom,v_uom,v_order_qty,v_order_currency from c_orderline where c_orderline_id=v_cur_line.c_orderline_id;
           if v_order_uom is not null and coalesce(v_order_qty,0)!=0 then
              select multiplyrate into v_uom_conversion from c_uom_conversion,m_product_uom where m_product_uom.c_uom_id=c_uom_conversion.c_uom_id and m_product_uom.m_product_uom_id=v_order_uom and c_uom_conversion.c_uom_to_id=v_uom;
              v_purchase_price:=v_purchase_price/coalesce(v_uom_conversion,1);
           end if; 
           -- Currency-Conversion
           v_purchase_price:= C_Currency_Round(C_Currency_Convert(v_purchase_price, v_order_currency, v_org_currency, new.movementdate, NULL, new.ad_client_id, new.AD_Org_ID), v_org_currency, NULL);      
           -- If Cancelling the Receipt the movementqty is reversed
           if new.processed!='Y' and old.processed='Y' then
               v_movementqty:=v_cur_line.movementqty*(-1);
           ELSE
               v_movementqty:=v_cur_line.movementqty;
           END IF;
            -- Calculation
           if v_method='ST' then
               v_actual_cost:=v_purchase_price;
           ELSE 
              IF v_method='AV' THEN
                  -- v_movementqty was booked before on stock... -minus it
                  v_curr_onhand_qty:=v_curr_onhand_qty-v_movementqty;
                  -- Cost Calculation only Works with Positive Stcks- No minus-qty allowed
                  IF (v_curr_onhand_qty+v_movementqty>=0) and v_curr_onhand_qty>=0 THEN
                     v_actual_cost:=((v_curr_cost*v_curr_onhand_qty)+(v_purchase_price*v_movementqty))/(v_curr_onhand_qty+v_movementqty);
                     --RAISE NOTICE '%','CurCost: '||v_curr_cost||' v_curr_onhand_qty : '||v_curr_onhand_qty||' v_purchase_price: '||v_purchase_price||' v_movementqty: '||v_movementqty||' v_actual_cost: '||v_actual_cost;
                  ELSE
                      v_actual_cost:=0; 
                  END IF;
               END IF;
            END IF;
            IF v_permanent='N' and v_actual_cost!=0 then
               if v_isdefault='N' then
                   update m_costing set DATETO=now() where m_costing_id=v_cost_id;
               end if;
               insert into m_costing (M_COSTING_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY,  M_PRODUCT_ID, DATEFROM, DATETO, ISMANUAL, PRICE,  COSTTYPE,  COST, m_inoutline_id)
                      values(get_uuid(),new.AD_Client_ID, new.AD_Org_ID, now(), new.CREATEDBY, now(), new.UPDATEDBY, v_cur_line.m_product_id,now(),to_date('01.01.9999','dd.mm.yyyy'),'N',v_purchase_price,v_method,v_actual_cost,v_cur_line.m_inoutline_id);
            END IF;
        END IF;
      END LOOP;
  END IF;
RETURN NEW;
EXCEPTION
WHEN NO_DATA_FOUND THEN
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_m_inout_trg() OWNER TO tad;


-- Version 2.6.02.046
CREATE OR REPLACE FUNCTION m_inout_trg_prov() RETURNS trigger
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
* Contributor(s): Stefan Zimmermann, 02/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************/

  v_movementType VARCHAR(60) ;
    
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;

  SELECT(
    CASE isSOTrx
      WHEN 'N'
      THEN 'V+'
      ELSE 'C-'
    END
    )
  INTO v_movementType
  FROM C_DOCTYPE
  WHERE C_DocType_ID=NEW.C_DocType_ID;
  -- On Customer-Returns:
  If NEW.C_DocType_ID='2317023F9771481696461C5EAF9A0915' then
     v_movementType:='C+';
  end if;
  -- Vendor Returns
  If NEW.C_DocType_ID='2E1E735AA91A49F8BC7181D31B09B370' then
   v_movementType:='V-';
  end if;  
  NEW.MOVEMENTTYPE:=v_movementType;
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 

END ; $_$;




--
-- Name: m_inout_post(character varying, character varying); Type: FUNCTION; Schema: public; Owner: tad
--

CREATE OR REPLACE FUNCTION m_inout_post(p_pinstance_id character varying, p_inout_id character varying) RETURNS void
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
  * $Id: M_InOut_Post.sql,v 1.8 2003/09/05 04:58:06 jjanke Exp $
  ***
  * Title: Post M_InOut_ID
  * Description:
  *  Action: COmplete
  *  - Create Transaction
  *    (only stocked products)
  *  - Update Inventory (QtyReserved, QtyOnHand)
  *    (only stocked products)
  *  - Update OrderLine (QtyDelivered)
  * 
  *  Action: Reverse Correction
  *  - Create Header and lines with negative Quantities (and header amounts)
  *  - Post it
  * SZ: Allow Material Returns.Disabled secondary UOM.
  *     2nd UOM is not transacted to Storage.
  *     It is only Used on Orders, Invoices and  in InOut-Transactions
  *     
  ************************************************************************/
  -- Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_User VARCHAR(32); --OBTG:VARCHAR2--
  v_is_included NUMERIC:=0;
  v_DocType_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_available_period NUMERIC:=0;
  v_is_ready AD_Org.IsReady%TYPE;
  v_is_tr_allow AD_OrgType.IsTransactionsAllowed%TYPE;
  v_DateAcct TIMESTAMP;
  v_isacctle AD_OrgType.IsAcctLegalEntity%TYPE;
  v_org_bule_id AD_Org.AD_Org_ID%TYPE;
  -- Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    --
    Cur_InOut RECORD;
    Cur_InOutLine RECORD;
    Cur_Order RECORD;
    v_Cur_Set   RECORD;
    --
    v_Result NUMERIC:=1;
    v_AD_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_AD_Client_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_NextNo VARCHAR(32); --OBTG:VARCHAR2--
    v_Qty NUMERIC;
    v_QtyPO NUMERIC;
    v_QtySO NUMERIC;
    
    v_RDocumentNo VARCHAR(40) ; --OBTG:VARCHAR2--
    v_RInOut_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_IsStocked character varying;
    v_IsSet character varying;
    v_DoctypeReversed_ID VARCHAR(32); --OBTG:VARCHAR2--
    --MODIFIED BY F.IRIAZABAL
    v_QtyOrder NUMERIC;
    v_ProductUOM NUMERIC;
    v_BreakDown VARCHAR(60) ; --OBTG:VARCHAR2--
    v_QtyAux NUMERIC;
    v_Count NUMERIC:=0;
    v_Line VARCHAR(10) ; --OBTG:VARCHAR2--
    FINISH_PROCESS BOOLEAN:=false;
    v_Aux NUMERIC;
    v_QtyCompare NUMERIC;
    v_locator character varying;
    v_uom     character varying;
    v_deliverycomplete varchar;
    v_internalDistribution varchar:='';
  BEGIN
    IF(p_PInstance_ID IS NOT NULL) THEN
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
        FROM AD_PInstance i
        LEFT JOIN AD_PInstance_Para p
          ON i.AD_PInstance_ID=p.AD_PInstance_ID
        WHERE i.AD_PInstance_ID=p_PInstance_ID
        ORDER BY p.SeqNo
        )
      LOOP
        v_Record_ID:=Cur_Parameter.Record_ID;
        v_User:=Cur_Parameter.AD_User_ID;
      END LOOP; -- Get Parameter
      RAISE NOTICE '%','  Record_ID=' || v_Record_ID ;
    ELSE
      RAISE NOTICE '%','--<<M_InOut_Post>>' ;
      v_Record_ID:=p_InOut_ID;
      SELECT count(*)
        INTO v_Count
        FROM M_InOut
        WHERE M_InOut_ID=v_Record_ID;
      IF v_Count=0 THEN
        FINISH_PROCESS:=true;
      END IF;
    END IF;
  BEGIN --BODY
        IF(NOT FINISH_PROCESS) THEN
      SELECT AD_Client_ID, AD_Org_ID, CreatedBy, C_DocType_ID, DateAcct
        INTO v_AD_Client_ID, v_AD_Org_ID, v_User, v_DocType_ID, v_DateAcct
        FROM M_InOut
        WHERE M_InOut_ID=v_Record_ID;
      SELECT count(*)
      INTO v_Count
      FROM AD_CLIENTINFO
      WHERE AD_CLIENT_ID=v_AD_Client_ID
        AND CHECKINOUTORG='Y';
      IF v_Count>0 THEN
        v_ResultStr:='CheckingRestrictions - M_INOUT ORG IS IN C_BPARTNER ORG TREE';
        SELECT count(*)
        INTO v_Count
        FROM M_InOut m,
          C_BPartner bp
        WHERE m.M_InOut_ID=v_Record_ID
          AND m.C_BPARTNER_ID=bp.C_BPARTNER_ID
          AND AD_IsOrgIncluded(m.AD_ORG_ID, bp.AD_ORG_ID, bp.AD_CLIENT_ID)=-1;
        IF v_Count>0 THEN
          RAISE EXCEPTION '%', '@NotCorrectOrgBpartnerInout@' ; --OBTG:-20000--
        END IF;
      END IF;
     -- Check if there are lines document does
     if (select count(*) from  M_INOUTLINE where M_Inout_ID = v_Record_ID)=0 then
          RAISE EXCEPTION '%', '@NoLinesInDoc@';
     END IF; 
     v_ResultStr:='CheckingRestrictions';
     SELECT COUNT(*)
     INTO v_Count
     FROM C_DocType,
          M_InOut M
     WHERE M_Inout_ID = v_Record_ID
       AND C_DocType.DocBaseType IN ('MMR', 'MMS')
      AND C_DocType.IsSOTrx=M.IsSOTrx
      AND AD_ISORGINCLUDED(m.AD_Org_ID,C_DocType.AD_Org_ID, m.AD_Client_ID) <> -1
       AND M.C_DOCTYPE_ID=C_DocType.C_DOCTYPE_ID;
        IF v_Count=0 THEN
          RAISE EXCEPTION '%', '@NotCorrectOrgDoctypeShipment@' ; --OBTG:-20000--
        END IF;
        SELECT COUNT(*), MAX(M.line)
        INTO v_Count, v_line
        FROM M_InOutLine M,
          M_Product P
        WHERE M.M_PRODUCT_ID=P.M_PRODUCT_ID
          AND P.M_ATTRIBUTESET_ID IS NOT NULL
          AND P.M_ATTRIBUTESETINSTANCE_ID IS NULL
          AND COALESCE(M.M_ATTRIBUTESETINSTANCE_ID, '0') = '0'
          AND M.M_INOUT_ID=v_Record_ID;
        IF v_Count<>0 THEN
          RAISE EXCEPTION '%', '@Inline@ '||v_line||' '||'@productWithoutAttributeSet@' ; --OBTG:-20000--
        END IF;
        SELECT COUNT(*), MAX(M.line)
        INTO v_Count, v_Line
        FROM M_InOut I,
          M_InOutLine M,
          M_AttributeSetInstance P
        WHERE I.M_InOut_ID=M.M_InOut_ID
          AND M.M_AttributeSetInstance_ID=P.M_AttributeSetInstance_ID
          AND P.ISLOCKED='Y'
          AND I.ISSOTRX='Y'
          AND I.M_INOUT_ID=v_Record_ID;
        IF v_Count<>0 THEN
          RAISE EXCEPTION '%', '@Inline@'||v_line||' '||'@lockedProduct@' ; --OBTG:-20000--
        END IF;
      -- check inout line instance location
        SELECT COUNT(*), MAX(M.line)
        INTO v_Count, v_Line
        FROM M_InOutLine M,
          M_Product P
        WHERE M.M_InOut_ID=v_Record_ID
          AND M.M_Locator_ID IS NULL
          AND p.m_product_id = m.m_product_id
          AND p.isstocked = 'Y'
          AND p.producttype = 'I';
        IF v_Count <> 0 THEN
          RAISE EXCEPTION '%', '@Inline@'||v_line||' '||'@InoutLineWithoutLocator@' ; --OBTG:-20000--
        END IF;   
      
        -- Process Shipments
  
     -- Set org lines like the header
       UPDATE M_INOUTLINE
        SET AD_ORG_ID = (SELECT AD_ORG_ID FROM M_INOUT WHERE M_INOUT_ID = v_Record_ID)
      WHERE M_INOUT_ID = v_Record_ID;
      
      -- Check the header belongs to a organization where transactions are posible and ready to use
      SELECT AD_Org.IsReady, Ad_OrgType.IsTransactionsAllowed
      INTO v_is_ready, v_is_tr_allow
      FROM M_INOUT, AD_Org, AD_OrgType
      WHERE AD_Org.AD_Org_ID=M_INOUT.AD_Org_ID
      AND AD_Org.AD_OrgType_ID=AD_OrgType.AD_OrgType_ID
      AND M_INOUT.M_INOUT_ID=v_Record_ID;
      IF (v_is_ready='N') THEN
        RAISE EXCEPTION '%', '@OrgHeaderNotReady@'; --OBTG:-20000--
      END IF;
      IF (v_is_tr_allow='N') THEN
        RAISE EXCEPTION '%', '@OrgHeaderNotTransAllowed@'; --OBTG:-20000--
      END IF;
        
      SELECT AD_ORG_CHK_DOCUMENTS('M_INOUT', 'M_INOUTLINE', v_Record_ID, 'M_INOUT_ID', 'M_INOUT_ID') INTO v_is_included FROM dual;
      IF (v_is_included=-1) THEN
        RAISE EXCEPTION '%', '@LinesAndHeaderDifferentLEorBU@'; --OBTG:-20000--
      END IF;
      
      -- Check the period control is opened (only if it is legal entity with accounting)
      -- Gets the BU or LE of the document
      SELECT AD_GET_DOC_LE_BU('M_INOUT', v_Record_ID, 'M_INOUT_ID', 'LE')
      INTO v_org_bule_id
      FROM DUAL;
      
      SELECT AD_OrgType.IsAcctLegalEntity
      INTO v_isacctle
      FROM AD_OrgType, AD_Org
      WHERE AD_Org.AD_OrgType_ID = AD_OrgType.AD_OrgType_ID
      AND AD_Org.AD_Org_ID=v_org_bule_id;
      
      IF (v_isacctle='Y') THEN    
        SELECT C_CHK_OPEN_PERIOD(v_AD_Org_ID, v_DateAcct, NULL, v_DocType_ID) 
        INTO v_available_period
        FROM DUAL;
        
        IF (v_available_period<>1) THEN
          RAISE EXCEPTION '%', '@PeriodNotAvailable@'; --OBTG:-20000--
        END IF;
      END IF;  
  
        FOR Cur_InOut IN
          (SELECT *
          FROM M_INOUT
          WHERE(M_InOut_ID=v_Record_ID
            OR(v_Record_ID IS NULL
            AND DocAction='CO'))
            AND IsActive='Y'  FOR UPDATE
          )
        LOOP
          RAISE NOTICE '%','Shipment_ID=' || Cur_InOut.M_InOut_ID || ', Doc=' || Cur_InOut.DocumentNo || ', Status=' || Cur_InOut.DocStatus || ', Action=' || Cur_InOut.DocAction ;
          v_ResultStr:='HeaderLoop';
/**
* Processing Shipment not processed
*/
    IF(Cur_InOut.Processed='N' AND Cur_InOut.DocStatus='DR' AND Cur_InOut.DocAction='CO') THEN
            -- For all active shipment lines
            v_ResultStr:='HeaderLoop-1';
        SELECT COUNT(*) INTO v_Aux
        FROM M_InOutLine
        WHERE M_InOut_ID = v_Record_ID;
        IF v_Aux=0 THEN
        RAISE EXCEPTION '%', '@ReceiptWithoutLines@'; --OBTG:-20000--
        END IF;
          FOR Cur_InOutLine IN
            (SELECT *
            FROM M_INOUTLINE
            WHERE M_InOut_ID=Cur_InOut.M_InOut_ID
              AND IsActive='Y'  FOR UPDATE
            )
          LOOP
            -- Incomming or Outgoing (+/-) ?
            v_Qty:=Cur_InOutLine.MovementQty;
            --Incoming: Material transaction : movement is + , v_QtySO - (returned)
            IF(SUBSTR(Cur_InOut.MovementType, 2)='-') THEN
              --Outgoing: Material transaction : movement is - , v_QtySO + (delivered)
              v_Qty:=- Cur_InOutLine.MovementQty;
            END IF;
            IF(Cur_InOut.IsSOTrx='N') THEN
              v_QtySO:=0;
              v_QtyPO:= - v_Qty;
            ELSE
              v_QtySO:= - v_Qty;
              v_QtyPO:=0;
            END IF;
            -- Is it a standard stocked product:3
            SELECT isstocked,issetitem  INTO v_IsStocked,v_IsSet
            FROM M_PRODUCT
            WHERE M_Product_ID=Cur_InOutLine.M_Product_ID
              AND ProductType='I';
            -- Create Transaction for stocked product
            IF coalesce(v_IsStocked,'N')='Y' THEN
              v_ResultStr:='CreateTransaction';
              SELECT * INTO  v_NextNo FROM Ad_Sequence_Next('M_Transaction', Cur_InOutLine.AD_Org_ID) ;
              INSERT
              INTO M_TRANSACTION
                (
                  M_Transaction_ID, M_InOutLine_ID, AD_Client_ID, AD_Org_ID,
                  IsActive, Created, CreatedBy, Updated,
                  UpdatedBy, MovementType, M_Locator_ID, M_Product_ID,
                  M_AttributeSetInstance_ID, MovementDate, MovementQty, C_UOM_ID
                )
                VALUES
                (
                  v_NextNo, Cur_InOutLine.M_InOutLine_ID, Cur_InOutLine.AD_Client_ID, Cur_InOutLine.AD_Org_ID,
                   'Y', TO_DATE(NOW()), Cur_InOutLine.UpdatedBy, TO_DATE(NOW()),
                  Cur_InOutLine.UpdatedBy, Cur_InOut.MovementType, Cur_InOutLine.M_Locator_ID, Cur_InOutLine.M_Product_ID,
                  COALESCE(Cur_InOutLine.M_AttributeSetInstance_ID, '0'), Cur_InOut.MovementDate, v_Qty,Cur_InOutLine.C_UOM_ID
                )
                ;
            END IF;
            IF coalesce(v_IsSet,'N')='Y' then
		-- Material Transaction for SET-Items
		for v_Cur_Set in (select * from m_product_bom where m_product_id=Cur_InOutLine.M_Product_ID)
                LOOP
                  v_ResultStr:='CreateSetItemTransaction';
                  -- Select Locator, If Return from Product, if delivery from stock 
                  if SUBSTR(Cur_InOut.MovementType, 2)='-' then
                      select max(m_locator_id) into v_locator from m_product_org where m_product_id=v_Cur_Set.M_Product_ID and ad_org_id=Cur_InOut.ad_org_id;
                     if v_locator is null then
                        select m_locator_id into v_locator from m_product where m_product_id=v_Cur_Set.M_Product_ID;
                     end if;
                  else
                     select m_locator_id into v_locator from m_storage_detail where m_product_id=v_Cur_Set.m_product_id  and 
                                                            m_locator_id in (select m_locator_id from m_locator where M_WAREHOUSE_ID=Cur_InOut.m_warehouse_id) and
                                                            coalesce(QTYONHAND,0)-coalesce(preqtyonhand,0) >= v_Cur_Set.bomqty*v_Qty LIMIT 1;
                  end if;
                  SELECT c_uom_id into v_uom from m_product where m_product_id=v_Cur_Set.M_Product_ID;
                  -- Reservation and Transaction is Done siomultanously on SET-Items
                  PERFORM M_UPDATE_INVENTORY(Cur_InOutLine.AD_CLIENT_ID, Cur_InOutLine.AD_ORG_ID, Cur_InOutLine.UPDATEDBY, v_Cur_Set.m_productbom_id, v_locator, null, v_uom,NULL, NULL, NULL, NULL,v_Cur_Set.bomqty*v_Qty , NULL);
                  -- Do Transaction for each part of BOM
                  SELECT * INTO  v_NextNo FROM Ad_Sequence_Next('M_Transaction', Cur_InOutLine.AD_Org_ID) ;
                  INSERT
                  INTO M_TRANSACTION
                  (
                        M_Transaction_ID, M_InOutLine_ID, AD_Client_ID, AD_Org_ID,
                        IsActive, Created, CreatedBy, Updated,
                        UpdatedBy, MovementType, M_Locator_ID, M_Product_ID,
                        M_AttributeSetInstance_ID, MovementDate, MovementQty, C_UOM_ID
                  )
                  VALUES
                  (
                        v_NextNo, Cur_InOutLine.M_InOutLine_ID, Cur_InOutLine.AD_Client_ID, Cur_InOutLine.AD_Org_ID,
                        'Y', TO_DATE(NOW()), Cur_InOutLine.UpdatedBy, TO_DATE(NOW()),
                        Cur_InOutLine.UpdatedBy, Cur_InOut.MovementType, v_Locator, v_Cur_Set.m_productbom_id,
                        '0', Cur_InOut.MovementDate, v_Qty*v_Cur_Set.bomqty,v_uom
                  );
                END LOOP;
            END IF; -- Set Items
            -- Create Asset
            IF(Cur_InOutLine.M_Product_ID IS NOT NULL AND Cur_InOut.IsSOTrx='Y') THEN
              PERFORM A_ASSET_CREATE(NULL, Cur_InOutLine.M_InOutLine_ID) ;
            END IF;
            v_ResultStr:='UpdateOrderLine';
            IF(Cur_InOutLine.C_OrderLine_ID IS NOT NULL) THEN
              -- Qty Delivered may not be more than qty ordered
              --select QtyDelivered + v_QtySO -qtyordered into v_QtyCompare from C_ORDERLINE WHERE C_OrderLine_ID=Cur_InOutLine.C_OrderLine_ID;
              --if v_QtyCompare>0 then
              --   raise exception '%', '@QtydeliveredNotBiggerThanQtyOrdered@';
              --end if;
              select deliverycomplete into  v_deliverycomplete from c_generateminoutmanual where m_inoutline_id=Cur_InOutLine.M_InOutLine_ID;
              -- stocked product
              IF(Cur_InOutLine.M_Product_ID IS NOT NULL AND coalesce(v_IsStocked,'N')='Y') THEN 
                -- Update OrderLine (if C-, Qty is negative)
                UPDATE C_ORDERLINE
                  SET QtyReserved=QtyReserved  - v_QtySO,
                  deliverycomplete=coalesce(v_deliverycomplete,'N'),
                  QtyDelivered=QtyDelivered + v_QtySO - v_QtyPO
                WHERE C_OrderLine_ID=Cur_InOutLine.C_OrderLine_ID;
                -- Products not stocked
              ELSE
                -- Update OrderLine (if C-, Qty is negative)
                UPDATE C_ORDERLINE
                  SET deliverycomplete=coalesce(v_deliverycomplete,'N'),
                  QtyDelivered=QtyDelivered + v_QtySO - v_QtyPO
                WHERE C_OrderLine_ID=Cur_InOutLine.C_OrderLine_ID;
              END IF;
            END IF;
            -- SZ: Allow Material Returns
            IF(Cur_InOutLine.M_Product_ID IS NOT NULL AND coalesce(v_IsStocked,'N')='Y' AND Cur_InOut.movementtype!='C+') THEN
              SELECT * INTO  v_Result, v_Message FROM M_Check_Stock(Cur_InOutLine.M_Product_ID, v_AD_Client_ID, v_AD_Org_ID) ;
              IF v_Result=0 THEN
                            RAISE EXCEPTION '%', v_Message||' '||'@line@'||' '||Cur_InOutLine.line ; --OBTG:-20000--
              END IF;
            END IF;
          END LOOP; -- For all InOut Lines
          /*******************
          * PO Matching
          ******************/
          IF(Cur_InOut.IsSOTrx='N') THEN
            DECLARE
              Cur_SLines RECORD;
              Cur_ILines RECORD;
              v_Qty NUMERIC;
              v_MatchPO_ID VARCHAR(32) ; --OBTG:VARCHAR2--
              v_MatchInv_ID VARCHAR(32) ; --OBTG:VARCHAR2--
            BEGIN
              v_ResultStr:='MatchPO';
              FOR Cur_SLines IN
                (SELECT sl.AD_Client_ID,
                  sl.AD_Org_ID,
                  ol.C_OrderLine_ID,
                  sl.M_InOutLine_ID,
                  sl.M_Product_ID,
                  sl.M_AttributeSetInstance_ID,
                  sl.MovementQty,
                  ol.QtyOrdered
                FROM M_INOUTLINE sl,
                  C_ORDERLINE ol
                WHERE sl.C_OrderLine_ID=ol.C_OrderLine_ID
                  AND sl.M_Product_ID=ol.M_Product_ID  --    AND   sl.M_AttributeSetInstance_ID=ol.M_AttributeSetInstance_ID
                  AND sl.M_InOut_ID=Cur_InOut.M_InOut_ID
                )
              LOOP
                SELECT * INTO  v_MatchPO_ID FROM Ad_Sequence_Next('M_MatchPO', Cur_SLines.AD_Org_ID) ;
                -- The min qty. Modified by Ismael Ciordia
                v_Qty:=Cur_SLines.MovementQty;
                --IF (ABS(Cur_SLines.MovementQty) > ABS(Cur_SLines.QtyOrdered)) THEN
                -- v_Qty := Cur_SLines.QtyOrdered;
                --END IF;
                v_ResultStr:='InsertMatchPO ' || v_MatchPO_ID;
                INSERT
                INTO M_MATCHPO
                  (
                    M_MatchPO_ID, AD_Client_ID, AD_Org_ID, IsActive,
                    Created, CreatedBy, Updated, UpdatedBy,
                    M_InOutLine_ID, C_OrderLine_ID, M_Product_ID, DateTrx,
                    Qty, Processing, Processed, Posted
                  )
                  VALUES
                  (
                    v_MatchPO_ID, Cur_SLines.AD_Client_ID, Cur_SLines.AD_Org_ID, 'Y',
                    TO_DATE(NOW()), '0', TO_DATE(NOW()), '0',
                    Cur_SLines.M_InOutLine_ID, Cur_SLines.C_OrderLine_ID, Cur_SLines.M_Product_ID, TO_DATE(NOW()),
                    v_Qty, 'N', 'Y', 'N'
                  )
                  ;
              END LOOP;
              v_ResultStr:='MatchInv';
              FOR Cur_ILines IN
                (SELECT sl.AD_Client_ID,
                  sl.AD_Org_ID,
                  il.C_InvoiceLine_ID,
                  sl.M_InOutLine_ID,
                  sl.M_Product_ID,
                  sl.M_AttributeSetInstance_ID,
                  sl.MovementQty,
                  il.QTYINVOICED
                FROM M_INOUTLINE sl,
                  C_INVOICELINE il
                WHERE sl.M_InOutLine_ID=il.M_InOutLine_ID
                  AND sl.M_InOut_ID=Cur_InOut.M_InOut_ID
                )
              LOOP
                SELECT * INTO  v_MatchInv_ID FROM Ad_Sequence_Next('M_MatchInv', Cur_ILines.AD_Org_ID) ;
                -- The min qty. Modified by Ismael Ciordia
                v_Qty:=Cur_ILines.MovementQty;
                --IF (ABS(Cur_ILines.MovementQty) > ABS(Cur_ILines.QtyInvoiced)) THEN
                -- v_Qty := Cur_ILines.QtyInvoiced;
                --END IF;
                v_ResultStr:='InsertMatchPO ' || v_MatchPO_ID;
                INSERT
                INTO M_MATCHINV
                  (
                    M_MATCHINV_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE,
                    CREATED, CREATEDBY, UPDATED, UPDATEDBY,
                    M_INOUTLINE_ID, C_INVOICELINE_ID, M_PRODUCT_ID, DATETRX,
                    QTY, PROCESSING, PROCESSED, POSTED
                  )
                  VALUES
                  (
                    v_MatchInv_ID, Cur_ILines.AD_Client_ID, Cur_ILines.AD_Org_ID, 'Y',
                    TO_DATE(NOW()), '0', TO_DATE(NOW()), '0',
                    Cur_ILines.M_InOutLine_ID, Cur_ILines.C_InvoiceLine_ID, Cur_ILines.M_Product_ID, TO_DATE(NOW()),
                    v_Qty, 'N', 'Y', 'N'
                  )
                  ;
              END LOOP;
            END;
          ELSE
            v_ResultStr:='Check delivery rule for sales orders';
            v_Message:='';
            FOR Cur_Order IN 
              (SELECT c_order.deliveryrule, m_inoutline.line, c_order.c_order_id,
                      c_order.documentno, c_orderline.line as orderline
               FROM M_InOutLine, C_Orderline, C_Order
               WHERE M_Inoutline.c_orderline_id = c_orderline.c_orderline_id
                 AND c_orderline.c_order_id = c_order.c_order_id
                 AND m_inoutline.m_inout_id = cur_inout.m_inout_id
                 AND ((c_order.deliveryrule = 'O'
                      AND EXISTS (SELECT 1 FROM C_OrderLine ol
                                  WHERE ol.C_Order_ID = C_order.c_order_id
                                    and ol.qtyordered > ol.qtydelivered ))
                      OR (c_order.deliveryrule = 'L' 
                          AND c_orderline.qtyordered > c_orderline.qtydelivered))
               ORDER BY c_order.c_order_id, c_orderline.line) 
            LOOP
              --Order lines not completely delivered with delivery rule O or L
              -- SZ fixed Bug 0000209
              --@TODO : Reverse Corrections are not clean catched (used *R* in Description). 
              IF substr(coalesce(Cur_InOut.Description,''),1,6)!= '(*R*: ' THEN
                v_Message := COALESCE(v_Message,'') || '@Shipment@' || ' ' || cur_inout.documentno;
                v_Message := v_Message || ' ' || '@line@' || ' ' || cur_order.line || ': ';
                v_Message := v_Message || '@SalesOrderDocumentno@' || cur_order.documentno;
                IF (cur_order.deliveryrule = 'O') THEN
                  v_Message := v_Message || ' ' || '@notCompleteDeliveryRuleOrder@' || '<br>';
                ELSE
                  v_Message := v_Message || ' ' || '@line@' || ' ' || cur_order.orderline;
                  v_Message := v_Message || ' ' || '@notCompleteDeliveryRuleLine@' || '<br>';
                END IF;
              END IF;
            END LOOP;
            IF (v_Message <> '') THEN
              RAISE EXCEPTION '%', v_message; --OBTG:-20000--
            END IF;
          END IF;
          -- Close Shipment
          v_ResultStr:='CloseShipment';
          UPDATE M_INOUT
            SET Processed='Y',
            DocStatus='CO',
            DocAction='RC',
            Updated=TO_DATE(NOW())
          WHERE M_INOUT.M_INOUT_ID=Cur_InOut.M_INOUT_ID;
          --
          -- Do Automatic Project - Material - Consumption, if Configured
          PERFORM zspm_materialconsumption4project(Cur_InOut.M_INOUT_ID); 
          -- Generate Massage for Internal Distribution of Materail
          if Cur_InOut.movementtype='V+' then
            v_internalDistribution:=ils_getInternalDistributionFromINOUT(Cur_InOut.M_INOUT_ID);
            if v_internalDistribution!='' then
                v_Result:=2;
            end if;
          end if;
          -- Not Processed + Complete --
/**
* Reverse Correction
*/
    ELSIF(Cur_InOut.DocStatus='CO' AND Cur_InOut.DocAction='RC') THEN
          
          --Check that there isn't any line with an invoice if the order's 
          --invoice rule is after delivery
          select count(*), max(line) into v_count, v_line
          from (
          SELECT m_inoutline.m_inoutline_id, m_inoutline.line
          from m_inoutline, c_order, c_orderline, c_invoiceline, m_inout, c_invoice
          where m_inoutline.c_orderline_id = c_orderline.c_orderline_id
            and c_orderline.c_order_id = c_order.c_order_id
            and c_orderline.c_orderline_id = c_invoiceline.c_orderline_id
            and c_invoiceline.m_inoutline_id=m_inoutline.m_inoutline_id
            and m_inoutline.m_inout_id = m_inout.m_inout_id
            and c_invoiceline.c_invoice_id = c_invoice.c_invoice_id
            and m_inout.m_inout_id = Cur_InOut.m_inout_id
            and m_inout.issotrx = 'Y'
            and c_order.invoicerule in ('D', 'O', 'S')
            and c_invoice.processed='Y'
            and c_invoice.docstatus!='VO'
            and case m_inout.movementtype when 'C-' then c_invoice.c_doctype_id not in (select c_doctype_id  FROM C_DOCTYPE  WHERE DocBaseType='ARC') when 'C+' then c_invoice.c_doctype_id  in (select c_doctype_id  FROM C_DOCTYPE  WHERE DocBaseType='ARC') END
          group by m_inoutline.m_inoutline_id, m_inoutline.line
          having sum(c_invoiceline.qtyinvoiced) <> 0
          ) a;
          IF (v_count > 0 ) THEN
            v_Message := '@InoutDocumentno@' || ': ' || Cur_InOut.DocumentNo || ' ' || '@line@' || ': ' || v_line || '. ';
            v_Message := v_Message || '@VoidShipmentInvoiced@';
            RAISE EXCEPTION '%', v_Message; --OBTG:-20000--
          END IF;
          v_ResultStr:='CreateInOut';
          SELECT COALESCE(C_DOCTYPE_REVERSED_ID, C_DOCTYPE_ID)
          INTO v_DoctypeReversed_ID
          FROM C_DOCTYPE
          WHERE C_DOCTYPE_ID=Cur_InOut.C_DocType_ID;
          SELECT * INTO  v_RInOut_ID FROM Ad_Sequence_Next('M_InOut', Cur_InOut.M_InOut_ID) ; -- Get RInOut_ID
          SELECT * INTO  v_RDocumentNo FROM Ad_Sequence_Doctype(v_DoctypeReversed_ID, Cur_InOut.ad_org_ID, 'Y') ; -- Get RDocumentNo
          IF(v_RDocumentNo IS NULL) THEN
            SELECT * INTO  v_RDocumentNo FROM AD_Sequence_Doc('DocumentNo_M_InOut', Cur_InOut.ad_org_ID, 'Y') ;
          END IF;
          -- Indicate that it is invoiced (i.e. not printed on invoices)
          v_ResultStr:='SetInvoiced';
          UPDATE M_INOUTLINE  SET IsInvoiced='Y'  WHERE M_InOut_ID=Cur_InOut.M_InOut_ID;
          --
          RAISE NOTICE '%','Reverse InOut_ID=' || v_RInOut_ID || ' DocumentNo=' || v_RDocumentNo ;
          v_ResultStr:='InsertInOut Reverse ' || v_RInOut_ID;
          INSERT
          INTO M_INOUT
            (
              M_InOut_ID, C_Order_ID, IsSOTrx, AD_Client_ID,
              AD_Org_ID, IsActive, Created, CreatedBy,
              Updated, UpdatedBy, DocumentNo, C_DocType_ID,
              Description, IsPrinted, MovementType, MovementDate,
              DateAcct, C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID,
              M_Warehouse_ID, POReference, DateOrdered, DeliveryRule,
              FreightCostRule, FreightAmt, C_Project_ID, C_Activity_ID,
              C_Campaign_ID, AD_OrgTrx_ID, User1_ID, User2_ID,
              DeliveryViaRule, M_Shipper_ID, C_Charge_ID, ChargeAmt,
              PriorityRule, DocStatus, DocAction, Processing,
              Processed, ISLOGISTIC, salesrep_id
            )
            VALUES
            (
              v_RInOut_ID, Cur_InOut.C_Order_ID, Cur_InOut.IsSOTrx, Cur_InOut.AD_Client_ID,
              Cur_InOut.AD_Org_ID, 'Y', TO_DATE(NOW()), '0',
              TO_DATE(NOW()), '0', v_RDocumentNo, v_DoctypeReversed_ID,
               '(*R*: ' || Cur_InOut.DocumentNo || ') ' || coalesce(Cur_InOut.Description,''), 'N', Cur_InOut.MovementType, Cur_InOut.MovementDate,
              Cur_InOut.DateAcct, Cur_InOut.C_BPartner_ID, Cur_InOut.C_BPartner_Location_ID, Cur_InOut.AD_User_ID,
              Cur_InOut.M_Warehouse_ID, Cur_InOut.POReference, Cur_InOut.DateOrdered, Cur_InOut.DeliveryRule,
              Cur_InOut.FreightCostRule, Cur_InOut.FreightAmt * -1, Cur_InOut.C_Project_ID, Cur_InOut.C_Activity_ID,
              Cur_InOut.C_Campaign_ID, Cur_InOut.AD_OrgTrx_ID, Cur_InOut.User1_ID, Cur_InOut.User2_ID,
              Cur_InOut.DeliveryViaRule, Cur_InOut.M_Shipper_ID, Cur_InOut.C_Charge_ID, Cur_InOut.ChargeAmt * -1,
              Cur_InOut.PriorityRule, 'DR', 'CO', 'N',
               'N', Cur_InOut.islogistic, Cur_InOut.salesrep_id
            )
            ;
          v_ResultStr:='InsertInOutLine';
          FOR Cur_InOutLine IN
            (SELECT *
            FROM M_INOUTLINE
            WHERE M_InOut_ID=Cur_InOut.M_InOut_ID
              AND IsActive='Y'  FOR UPDATE
            )
          LOOP
            -- Create InOut Line
            SELECT * INTO  v_NextNo FROM Ad_Sequence_Next('M_InOutLine', Cur_InOut.M_InOut_ID) ;
            v_ResultStr:='CreateInOutLine';
            INSERT
            INTO M_INOUTLINE
              (
                M_InOutLine_ID, Line, M_InOut_ID, C_OrderLine_ID,
                AD_Client_ID, AD_Org_ID, IsActive, Created,
                CreatedBy, Updated, UpdatedBy, M_Product_ID,
                M_AttributeSetInstance_ID, C_UOM_ID, M_Locator_ID, MovementQty,
                Description, IsInvoiced,  --MODIFIED BY F.IRIAZABAL
                QuantityOrder, M_Product_UOM_ID
              )
              VALUES
              (
                v_NextNo, Cur_InOutLine.Line, v_RInOut_ID, Cur_InOutLine.C_OrderLine_ID,
                Cur_InOut.AD_Client_ID, Cur_InOut.AD_Org_ID, 'Y', TO_DATE(NOW()),
                '0', TO_DATE(NOW()), '0', Cur_InOutLine.M_Product_ID,
                Cur_InOutLine.M_AttributeSetInstance_ID, Cur_InOutLine.C_UOM_ID, Cur_InOutLine.M_Locator_ID, Cur_InOutLine.MovementQty * -1,
                 '*R*: ' || coalesce(Cur_InOutLine.Description,''), Cur_InOutLine.IsInvoiced, --MODIFIED BY F.IRIAZABAL
                Cur_InOutLine.QuantityOrder * -1, Cur_InOutLine.M_PRODUCT_UOM_ID
              )
              ;
             -- If serial Numbers exists: Create lines
             insert into SNR_MINOUTLINE (SNR_MINOUTLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, M_INOUTLINE_ID, QUANTITY, GUARANTEEDAYS, LOTNUMBER, SERIALNUMBER, RFIDNUMBER, GUARANTEEDATE, ISUNAVAILABLE)
             select get_uuid(),AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, v_NextNo,QUANTITY, GUARANTEEDAYS, LOTNUMBER, SERIALNUMBER, RFIDNUMBER, GUARANTEEDATE, ISUNAVAILABLE
                   from SNR_MINOUTLINE where M_INOUTLINE_ID=Cur_InOutLine.M_INOUTLINE_ID;
          END LOOP;
          -- Close Order
          v_ResultStr:='CloseInOut';
          UPDATE M_INOUT
            SET Description=COALESCE(TO_CHAR(Description), '') || ' (*R*=' || v_RDocumentNo || ')',
            Processed='Y',
            DocStatus='VO', -- it IS reversed
            DocAction='--',
            Updated=TO_DATE(NOW()),
            UpdatedBy=v_User
          WHERE M_INOUT.M_INOUT_ID=Cur_InOut.M_INOUT_ID;
          -- REVERSE Automatic Project - Material - Consumption, if Configured
          PERFORM zspm_reversematerialconsumption4project(Cur_InOut.M_INOUT_ID); 
          -- Post Reversal
          v_ResultStr:='PostReversal';
          PERFORM M_INOUT_POST(NULL, v_RInOut_ID) ;
          -- Indicate as Reversal Transaction
          v_ResultStr:='IndicateReversal';
          UPDATE M_INOUT
            SET Updated=TO_DATE(NOW()),
            UpdatedBy=v_User,
            DocStatus='VO' -- the reversal transaction
          WHERE M_InOut_ID=v_RInOut_ID;
        END IF; -- ReverseCorrection
      END LOOP; -- InOut Header
      /**
      * Transaction End
      */
      v_ResultStr:='Fini';
    END IF; --FINISH_PROCESS
    ---- <<FINISH_PROCESS>>
    -- Do Update the Material Plan with new Stock qty's
    PERFORM mrp_inoutplanupdate(null);
    IF(p_PInstance_ID IS NOT NULL) THEN
      --  Update AD_PInstance
      RAISE NOTICE '%','Updating PInstance - Finished ' || coalesce(v_Message,'') ;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', v_result, coalesce(v_Message,'')||v_internalDistribution) ;
    ELSE
      RAISE NOTICE '%','--<<M_InOut_Post finished>>' ;
    END IF;
    RETURN;
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
  RETURN;
END ; $_$;


ALTER FUNCTION public.m_inout_post(p_pinstance_id character varying, p_inout_id character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION m_gettransactionlocator(p_product character varying,p_warehouse character varying,p_issotrx character varying,v_qty numeric )
  RETURNS character varying AS
$BODY$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
***************************************************************************************************************************************************/
v_plocator character varying;
v_locator character varying;
v_doctypeID character varying;
v_count numeric:=0;
v_cur record;
BEGIN
  select p.m_locator_id into v_plocator from m_product p,m_locator l where l.m_locator_id=p.m_locator_id and  l.m_warehouse_id=p_warehouse and p.m_product_id=p_product;
  
  -- Purchase
  if p_issotrx='N' then
   if v_plocator is not null then
      return v_plocator;
   end if;
   for v_cur in (select p.m_locator_id from m_product_org p,m_locator l where l.m_locator_id=p.m_locator_id and  l.m_warehouse_id=p_warehouse and p.m_product_id=p_product)
   LOOP
      return v_cur.m_locator_id;
   END LOOP;
   select m_locator_id into v_plocator from m_locator where isactive='Y' and isdefault='Y' and m_warehouse_id=p_warehouse;
   return v_plocator;
  end if;
  -- Sales
  if p_issotrx='Y' then
    if v_plocator is not null then 
        select m_bom_qty_onhand(p_product,p_warehouse,v_plocator) into v_count;
    end if;
    if v_count>=v_qty then
       return  v_plocator;
    end if;
    for v_cur in (select l.m_locator_id from m_locator l where  l.m_warehouse_id=p_warehouse)
    LOOP
      select m_bom_qty_onhand(p_product,p_warehouse,v_plocator) into v_count;
      if v_count>=v_qty then
          return v_cur.m_locator_id;
      end if;
    END LOOP;
  end if;
  return null;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION c_isorderCompletelyDelivered(p_order_id character varying)
  RETURNS character varying AS
$BODY$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
***************************************************************************************************************************************************/
v_doctype character varying;
v_doctypeID character varying;
v_count numeric;
BEGIN
  select c_doctype_ID into v_doctypeID from c_order where c_order_id=p_order_id;
  select docbasetype into v_doctype from c_doctype where c_doctype_id=v_doctypeID;
  -- Function on all orders and frame contracts.
  if v_doctype not in ('SOO','POO') and v_doctypeID not in ('559A80F2E27742D4B2C476045F5C834F','56913A519BA94EB59DAE5BF9A82F5F7D') then
    return 'N' ;
  end if;
  select count(*) into v_count from c_orderline where c_order_id=p_order_id and qtyordered>qtydelivered and deliverycomplete='N';
  if v_count>0 then
    return 'N' ;
  else
    return 'Y' ;
  end if;  
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION m_isinoutcandidate(p_orderline_id character varying)
  RETURNS character varying AS
$BODY$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.

Delivery:
In Out Candidate is whenever in a locator of the Order Warehouse a sufficient onhand QTY is available

Receipt:
In Out Candidate is whenever a good shipment is expected
***************************************************************************************************************************************************/

v_delrule character varying;
v_orderid character varying;
v_qtyordered numeric;
v_qtydelivered numeric;
v_deliverycomplete character varying;
v_product character varying;
v_issotrx character varying;
v_org character varying;
v_client varchar;
v_allownegativestock varchar;
v_warehouse character varying;
v_count numeric;
v_cur record;
v_sheddate timestamp without time zone; 
v_ptype varchar;
BEGIN
  select coalesce(scheddeliverydate,now()),qtyordered,qtydelivered,deliverycomplete,c_order_id,m_product_id,ad_org_id,ad_client_id 
         into v_sheddate,v_qtyordered,v_qtydelivered,v_deliverycomplete,v_orderid,v_product,v_org,v_client from c_orderline where c_orderline_id=p_orderline_id;
  select deliveryrule,issotrx,m_warehouse_id into v_delrule, v_issotrx, v_warehouse from c_order where c_order_id=v_orderid;
  SELECT allownegativestock  INTO  v_allownegativestock  FROM ad_clientinfo where ad_client_id = v_client;
  -- Delivery of Services?
  select producttype into v_ptype from m_product where m_product_id = v_product;
  --if c_getconfigoption('deliveryofservices',v_org) = 'N' and v_ptype='S' then
  --   return 'N';
  --end if;
  -- Purchase
  if v_issotrx='N' and v_qtyordered>v_qtydelivered and v_deliverycomplete='N' then 
     return 'Y';
  end if;
  -- sales
  -- Prepaid?
  if v_delrule='R' then
	if (((select iscompletelyinvoiced from c_order where c_order_id = v_orderid) = 'N') or
		(((select iscompletelyinvoiced from c_order where c_order_id = v_orderid) = 'Y') and
		(select count(*) from c_invoice i where i.c_order_id=v_orderid and i.ispaid='N' and docstatus = ('CO')) > 0)) then
        return 'N';
     end if;
  end if;
  if  v_issotrx='Y' and v_qtyordered>v_qtydelivered and v_deliverycomplete='N'   and v_sheddate<=now()  then
     -- Availability, Prepaid
     if v_delrule in ('A','R') then
          return 'Y';
     end if;
     -- Complete Line
     if v_delrule = 'L' then
         if (m_bom_qty_onhand(v_product, v_warehouse, null) >= v_qtyordered-v_qtydelivered  or v_allownegativestock='Y') and v_sheddate<=now() then
           return 'Y';
         end if;
     end if;
     -- Complete Order
     if v_delrule = 'O' and v_sheddate<=now() then
         for v_cur in (select qtyordered,qtydelivered from c_orderline where c_order_id=v_orderid) 
         LOOP
           if m_bom_qty_onhand(v_product, v_warehouse, null) < v_cur.qtyordered-v_cur.qtydelivered and v_allownegativestock='N' then
               return 'N';
           end if;
         END LOOP;
         return 'Y';
     end if;
  end if;
  return 'N';
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
--
--
--
--
--
--
--
-- M-Inout Generation View
select zsse_DropView ('m_inout_candidate_v');
create or replace view m_inout_candidate_v as 
select 
	o.ad_client_id, 
	o.ad_org_id, 
	o.c_bpartner_id, 
	o.c_order_id, 
	o.documentno, 
	o.dateordered, 
	o.c_doctype_id, 
        l.c_project_id,
        l.c_projecttask_id,
        l.a_asset_id,
        l.m_product_id,
	o.totallines, 
        o.grandtotal,
        l.qtyordered,
        l.qtydelivered,
        l.datepromised,
        l.line,
        l.description,
        l.qtyordered-l.qtydelivered as qty2deliver,
        l.c_orderline_id,
        o.issotrx,
        o.m_shipper_id,
        bp.name as businesspartner,
        zssi_getprojectorcostcentername(l.c_project_id,l.a_asset_id) as projectname,
        ms.name as shipper_name,
        o.salesrep_id,
        m_bom_qty_onhand(l.m_product_id,o.m_warehouse_id,null) as qtyonhand,
        m_bom_qty_onhand(l.m_product_id,o.m_warehouse_id,null) as qtyavailable,
        m_gettransactionlocator(l.m_product_id,o.m_warehouse_id,o.issotrx,l.qtyordered-l.qtydelivered) as m_locator_id
from 
	c_order o left join m_shipper ms on ms.m_shipper_id=o.m_shipper_id,c_orderline l,c_bpartner bp
where 
	o.c_order_id = l.c_order_id 
        and o.c_bpartner_id=bp.c_bpartner_id
        and m_isinoutcandidate(l.c_orderline_id)='Y'
        and l.directship = 'N'
        and (o.c_doctype_id in ( select c_doctype.c_doctype_id from c_doctype where c_doctype.docbasetype in ('SOO','POO') and (coalesce(c_doctype.docsubtypeso,'A') != all (array['ON', 'OB', 'WR'])))) 
        and o.docstatus = 'CO';



select zsse_DropView ('zssi_openshipment');
create view zssi_openshipment as 
select 
        l.c_orderline_id as zssi_openshipment_id, 
        l.ad_client_id, 
        l.ad_org_id, 
        l.isactive, 
        l.created, 
        l.createdby, 
        l.updated, 
        l.updatedby, 
        o.c_bpartner_id, 
        o.documentno, 
        o.description, 
        o.salesrep_id, 
        o.dateordered, 
        o.datepromised, 
        l.scheddeliverydate ,
        l.m_product_id, 
        l.c_uom_id, 
        l.qtyordered, 
        l.qtyreserved, 
        l.qtydelivered, 
        l.qtyinvoiced, 
        o.c_order_id
from 
        c_order o
join 
        c_orderline l on o.c_order_id = l.c_order_id
where 
        o.docstatus = 'CO' and 
        o.isdelivered = 'N' and 
        (o.c_doctype_id in ( select c_doctype.c_doctype_id from c_doctype where c_doctype.docbasetype in ('SOO','POO') and (coalesce(c_doctype.docsubtypeso,'A') != all (array['ON', 'OB', 'WR'])))) and 
        l.qtyordered <> l.qtydelivered and l.directship = 'N'::bpchar and l.m_product_id is not null and 
        l.deliverycomplete='N' and
        (o.deliveryrule!='R' or ((select count(*) from c_invoice i where i.c_order_id=o.c_order_id and i.ispaid='Y' and docstatus in ('CO','CL') )=1)) and
        not exists (select 0 from m_inoutline ml,m_inout m where m.m_inout_id=ml.m_inout_id and ml.c_orderline_id=l.c_orderline_id and m.processed='N') and
        ((select producttype from m_product where m_product.m_product_id = l.m_product_id ) != 'S' or
        (select c_getconfigoption('deliveryofservices',o.ad_org_id) = 'Y'));



CREATE OR REPLACE FUNCTION m_inventoryline2_trg() RETURNS trigger
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
* Contributor(s): Stefan Zimmermann, 02/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
***************************************************************************************************************************************************/
v_value character varying;
v_name  character varying;
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;

 IF(TG_OP = 'UPDATE')
    THEN  IF NOT((COALESCE(OLD.M_Product_Uom_ID, '0') <> COALESCE(NEW.M_Product_Uom_ID, '0')
    OR COALESCE(OLD.QuantityOrderBook, 0) <> COALESCE(NEW.QuantityOrderBook, 0)))
    THEN  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;
   END IF;
 IF(TG_OP = 'UPDATE' OR TG_OP = 'INSERT') THEN
  -- Get name and Value from Product to get Lines searchable
  select value,name into v_value,v_name from m_product where m_product_id=new.m_product_id;
  new.value=v_value;
  new.name=v_name;
  IF(NEW.M_Product_Uom_ID IS NOT NULL AND NEW.QuantityOrderBook IS NULL) THEN
    NEW.QuantityOrderBook:=0;
  ELSIF(NEW.M_Product_Uom_ID IS NULL AND NEW.QuantityOrderBook IS NOT NULL) THEN
    NEW.QuantityOrderBook:=NULL;
  END IF;
 END IF;
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END; $_$;



--
-- Name: m_inventory_listcreate(character varying); Type: FUNCTION; Schema: public; Owner: tad
--

CREATE OR REPLACE FUNCTION m_inventory_listcreate(pinstance_id character varying) RETURNS void
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
  * $Id: M_Inventory_ListCreate.sql,v 1.6 2003/06/16 14:40:03 jjanke Exp $
  ***
  * Title: Create Price Inventory Count
  * Description:
  * - get info from Storage.QtyOnHand
  * - if line exist, update it
  * SZ: Bugfix: Do not join in Product-Org - avoid duplicate lines
  ************************************************************************/

  --    Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Result NUMERIC:=0; --    failure
  v_InProcess CHAR(1) ;
  v_Done CHAR(1) ;
  v_NoInserted NUMERIC:=0;
  v_NoUpdated NUMERIC:=0;
  --    Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    --    Parameter Variables
    v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_ProductValue VARCHAR(40) ; --OBTG:VARCHAR2--
    v_Locator_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_Product_Category_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_QtyRange VARCHAR(60) ; --OBTG:VARCHAR2--
    v_Regularization VARCHAR(60) ; --OBTG:VARCHAR2--
    v_ABC VARCHAR(60); --OBTG:VARCHAR2--
    --
    v_Warehouse_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_Client_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
    --
    v_NextNo VARCHAR(32); --OBTG:VARCHAR2--
    v_NextLine NUMERIC;
    --    Selection
    Cur_Storage RECORD;
    END_PROCESS BOOLEAN:=false;
  BEGIN
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Processing' ;
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'Y', NULL, NULL) ;
  BEGIN --BODY
    --    Get Parameters
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
      v_Record_ID:=Cur_Parameter.Record_ID;
      IF(Cur_Parameter.ParameterName='QtyRange') THEN
        v_QtyRange:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  QtyRange=' || v_QtyRange ;
      ELSIF(Cur_Parameter.ParameterName='ProductValue') THEN
        v_ProductValue:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  ProductValue=' || v_ProductValue ;
      ELSIF(Cur_Parameter.ParameterName='regularization') THEN
        v_Regularization:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  Regularization=' || v_Regularization ;
      ELSIF(Cur_Parameter.ParameterName='M_Locator_ID') THEN
        v_Locator_ID:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  M_Locator_ID=' || v_Locator_ID ;
      ELSIF(Cur_Parameter.ParameterName='M_Product_Category_ID') THEN
        v_Product_Category_ID:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  M_Product_Category_ID=' || v_Product_Category_ID ;
      ELSIF(Cur_Parameter.ParameterName='ABC') THEN
        v_ABC:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  ABC=' || v_ABC ;
      ELSE
        RAISE NOTICE '%','*** Unknown Parameter=' || Cur_Parameter.ParameterName ;
      END IF;
    END LOOP; --    Get Parameter
    RAISE NOTICE '%','  Record_ID=' || v_Record_ID ;
    v_ResultStr:='ReadingInventory - (Record not saved)';
  BEGIN
    SELECT Processing,
      Processed,
      AD_Client_ID,
      AD_Org_ID,
      M_Warehouse_ID
    INTO v_InProcess,
      v_Done,
      v_Client_ID,
      v_Org_ID,
      v_Warehouse_ID
    FROM M_Inventory
    WHERE M_Inventory_ID=v_Record_ID;
  EXCEPTION
  WHEN OTHERS THEN
    v_Message:='@SaveErrorRowNotFound@';
    END_PROCESS:=true;
  END;
  IF(NOT END_PROCESS) THEN
    IF(v_InProcess='Y') THEN
      v_Message:='@OtherProcessActive@';
      END_PROCESS:=true;
    END IF;
  END IF;--END_PROCESS
  IF(NOT END_PROCESS) THEN
    IF(v_Done='Y') THEN
      v_Message:='@AlreadyPosted@';
      END_PROCESS:=true;
    END IF;
  END IF;--END_PROCESS
  IF(NOT END_PROCESS) THEN
    v_ResultStr:='Setting ProductValue';
    v_ProductValue:=TRIM(v_ProductValue) ;
    IF(LENGTH(v_ProductValue)=0) THEN
      v_ProductValue:=NULL;
    END IF;
    IF(v_ProductValue IS NOT NULL AND SUBSTR(v_ProductValue, LENGTH(v_ProductValue), 1)<>'%') THEN
      v_ProductValue:=v_ProductValue || '%';
    END IF;
    IF(v_ProductValue IS NOT NULL) THEN
      v_ProductValue:=UPPER(v_ProductValue) ;
    END IF;
    --  Create 0 Storage Records
    IF(v_Regularization = 'Y' and v_QtyRange='=' and v_Locator_ID is null) THEN
      v_ResultStr:='Creating 0 values';
      DECLARE
        Cur_Products RECORD;
        storagesCount NUMERIC:=0;
        p_Storage_ID VARCHAR(32); --OBTG:VARCHAR2--
      BEGIN
        FOR Cur_Products IN
          (SELECT M_Product_ID,
            C_UOM_ID
          FROM M_Product p
          WHERE p.AD_Client_ID=v_Client_ID
            AND IsStocked='Y'
            AND producttype='I'
            AND ISACTIVE='Y'
            AND m_locator_id is not null
            AND NOT EXISTS
            (SELECT *
            FROM M_Storage_Detail s
            WHERE p.M_Product_ID=s.M_Product_ID
              AND s.M_Locator_ID=coalesce(v_Locator_ID,p.m_locator_id)
            )
          )
        LOOP
          SELECT * INTO  p_Storage_ID FROM Ad_Sequence_Next('M_Storage_Detail', v_Client_ID) ;
          INSERT
          INTO M_Storage_Detail
            (
              M_STORAGE_DETAIL_ID, M_PRODUCT_ID, M_LOCATOR_ID, M_ATTRIBUTESETINSTANCE_ID,
              C_UOM_ID, M_PRODUCT_UOM_ID, AD_CLIENT_ID, AD_ORG_ID,
              ISACTIVE, CREATED, CREATEDBY, UPDATED,
              UPDATEDBY, QTYONHAND, QTYORDERONHAND, PREQTYONHAND,
              PREQTYORDERONHAND, DATELASTINVENTORY
            )
            VALUES
            (
              p_Storage_ID, Cur_Products.M_Product_ID, coalesce(v_Locator_ID,(select m_locator_id from m_product where m_product_id=Cur_Products.M_Product_ID)), '0',
              Cur_Products.C_UOM_ID, NULL, v_Client_ID, v_Org_ID,
               'Y', TO_DATE(NOW()), '0', TO_DATE(NOW()),
              '0', 0, NULL, 0,
              NULL, NULL
            )
            ;
          storagesCount:=storagesCount + 1;
        END LOOP;
        RAISE NOTICE '%','Created 0 Storage Records = '|| storagesCount ;
      END;
    END IF;
  END IF;--END_PROCESS
  IF(NOT END_PROCESS) THEN
    v_ResultStr:='ReadingInventoryLine';
    SELECT COALESCE(MAX(Line)+10, 10) -- BugFix: [1788358] On Inventory the "create count" may repeat line numbers
    INTO v_NextLine
    FROM M_InventoryLine
    WHERE M_Inventory_ID=v_Record_ID;
    FOR Cur_Storage IN
      (SELECT s.M_Product_ID,
        s.M_Locator_ID,
        COALESCE(s.QtyOnHand, 0) AS QtyOnHand,
        (s.QTYORDERONHAND) AS QtyOnHandOrder,
        s.C_UOM_ID,
        s.M_Product_UOM_ID,
        s.M_AttributeSetInstance_ID
      FROM M_Product p
      INNER JOIN M_Storage_Detail s
        ON(s.M_Product_ID=p.M_Product_ID) --SZ: Bugfix: Do not join in Product-Org - avoid duplicate lines
      WHERE p.AD_Client_ID=v_Client_ID  --    only ..
        AND(v_ProductValue IS NULL
        OR UPPER(p.Value) LIKE v_ProductValue)
        AND(v_Locator_ID IS NULL
        OR s.M_Locator_ID=v_Locator_ID)
        AND(v_Warehouse_ID IS NULL
        OR s.M_Locator_ID IN
        (SELECT M_Locator_ID FROM M_Locator WHERE M_Warehouse_ID=v_Warehouse_ID))
        AND(v_Product_Category_ID IS NULL
        OR p.M_Product_Category_ID=v_Product_Category_ID)
        AND p.ISACTIVE='Y'
        AND NOT EXISTS
        (SELECT *
        FROM M_InventoryLine l
        WHERE l.M_Inventory_ID=v_Record_ID
          AND l.M_Product_ID=s.M_Product_ID
          AND l.M_Locator_ID=s.M_Locator_ID
        )
      ORDER BY s.M_Locator_ID,
        p.Value,
        s.Created
      )
    LOOP
      v_ResultStr:='CheckingInventoryLine';
      RAISE NOTICE '%','  QtyRange=' || v_QtyRange || ', OnHand=' || Cur_Storage.QtyOnHand ;
      --
      IF(v_QtyRange IS NULL --  all
        OR(v_QtyRange='>' AND Cur_Storage.QtyOnHand>0) OR(v_QtyRange='<' AND Cur_Storage.QtyOnHand<0) OR(v_QtyRange='=' AND Cur_Storage.QtyOnHand=0) OR(v_QtyRange='N' AND Cur_Storage.QtyOnHand<>0)) THEN
        --    DO we have this record already:1
        SELECT MAX(QtyBook)
        INTO v_NextNo
        FROM M_InventoryLine
        WHERE M_Inventory_ID=v_Record_ID
          AND M_Product_ID=Cur_Storage.M_Product_ID
          AND M_Locator_ID=Cur_Storage.M_Locator_ID
          AND M_AttributeSetInstance_ID=Cur_Storage.M_AttributeSetInstance_ID
          AND C_UOM_ID=Cur_Storage.C_UOM_ID
          AND M_Product_UOM_ID=Cur_Storage.M_Product_UOM_ID;
        --
        RAISE NOTICE '%','  QtyRange=' || v_QtyRange || ', OnHand=' || Cur_Storage.QtyOnHandOrder || ', v_NextNo=' || v_NextNo ;
        IF(v_NextNo IS NULL) THEN
          v_ResultStr:='InsertLine';
          SELECT * INTO  v_NextNo FROM AD_Sequence_Next('M_InventoryLine', v_Client_ID) ;
          INSERT
          INTO M_InventoryLine
            (
              M_InventoryLine_ID, Line, AD_Client_ID, AD_Org_ID,
              IsActive, Created, CreatedBy, Updated,
              UpdatedBy, M_Inventory_ID, M_Locator_ID, M_ATTRIBUTESETINSTANCE_ID,
              M_Product_ID, QtyBook, QtyCount, C_UOM_ID,
              QUANTITYORDER, QUANTITYORDERBOOK, M_Product_UOM_ID
            )
            VALUES
            (
              v_NextNo, v_NextLine, v_Client_ID, v_Org_ID,
               'Y', TO_DATE(NOW()), '0', TO_DATE(NOW()),
              '0', v_Record_ID, Cur_Storage.M_Locator_ID, Cur_Storage.M_ATTRIBUTESETINSTANCE_ID,
              Cur_Storage.M_Product_ID, Cur_Storage.QtyOnHand,Cur_Storage.QtyOnHand, Cur_Storage.C_UOM_ID,(CASE WHEN Cur_Storage.QtyOnHandOrder IS NULL THEN NULL ELSE Cur_Storage.QtyOnHandOrder END), 
              Cur_Storage.QtyOnHandOrder, Cur_Storage.M_Product_UOM_ID
            )
            ;
          v_NextLine:=v_NextLine + 10;
          v_NoInserted:=v_NoInserted + 1;
        ELSE
          v_ResultStr:='UpdateLine';
          UPDATE M_InventoryLine
            SET QtyBook=Cur_Storage.QtyOnHand,
            QtyCount=Cur_Storage.QtyOnHand,
            C_UOM_ID=Cur_Storage.C_UOM_ID,
            M_AttributeSetInstance_ID=Cur_Storage.M_AttributeSetInstance_ID,
            QUANTITYORDER=Cur_Storage.QtyOnHandOrder,
            QUANTITYORDERBOOK=Cur_Storage.QtyOnHandOrder,
            M_Product_UOM_ID=Cur_Storage.M_Product_UOM_ID,
            Updated=TO_DATE(NOW()),
            UpdatedBy='0'
          WHERE M_Inventory_ID=v_Record_ID
            AND M_Product_ID=Cur_Storage.M_Product_ID
            AND C_UOM_ID=Cur_Storage.C_UOM_ID
            AND M_Product_UOM_ID=Cur_Storage.M_Product_UOM_ID
            AND M_AttributeSetInstance_ID=Cur_Storage.M_AttributeSetInstance_ID
            AND M_Locator_ID=Cur_Storage.M_Locator_ID;
          v_NoUpdated:=v_NoUpdated + 1;
        END IF;
      END IF; --
    END LOOP; --    Cur_Storage
    -- Commented by cromero 19102006 -- COMMIT;
    v_Message:='@Inserted@=' || v_NoInserted || ', @Updated@=' || v_NoUpdated;
    v_Result:=1; --    success
  END IF;--END_PROCESS
  ---- <<END_PROCESS>>
  --  Update AD_PInstance
  RAISE NOTICE '%','Updating PInstance - Finished' ;
  RAISE NOTICE '%',v_Message ;
  PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'N', v_Result, v_Message) ;
  RETURN;
END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr ;
  PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
  RETURN;
END ; $_$;


ALTER FUNCTION public.m_inventory_listcreate(pinstance_id character varying) OWNER TO tad;



-- Version 2.6.00.0032
CREATE OR REPLACE FUNCTION m_update_storage_pending(p_client character varying, p_org character varying, p_user character varying, p_product character varying, p_warehouse character varying, p_attributesetinstance character varying, p_uom character varying, p_product_uom_dummy character varying, p_qtyreserved numeric, p_qtyorderreserved_dummy numeric, p_qtyordered numeric, p_qtyorderordered_dummy numeric) RETURNS void
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
* Contributor(s): Stefan Zimmermann, 02/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
***************************************************************************************************************************************************
BUGFIX: Deactivate Secondary UOM
Deactivate Secondary UOM -  Inventory schould be working ONLY with 1st UOM

*****************************************************/
  v_cuenta NUMERIC;
  v_Storage_ID VARCHAR(32); --OBTG:VARCHAR2--
BEGIN
  SELECT COUNT(*)
  INTO v_cuenta
  FROM M_STORAGE_PENDING
  WHERE M_PRODUCT_ID=p_product
    AND M_WAREHOUSE_ID=p_warehouse
    AND COALESCE(M_ATTRIBUTESETINSTANCE_ID, '0')=COALESCE(p_attributesetinstance, '0')
    AND C_UOM_ID=p_uom;
 
  IF(v_cuenta=0) THEN
    SELECT * INTO  v_Storage_ID FROM Ad_Sequence_Next('M_Storage_Pending', p_client) ;

    INSERT
    INTO M_STORAGE_PENDING
      (
        M_STORAGE_PENDING_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE,
        CREATED, CREATEDBY, UPDATED, UPDATEDBY,
        M_PRODUCT_ID, M_WAREHOUSE_ID, M_ATTRIBUTESETINSTANCE_ID, C_UOM_ID,QTYRESERVED, QTYORDERED
      )
      VALUES
      (
        v_Storage_ID, p_client, p_org, 'Y',
        TO_DATE(NOW()), p_user, TO_DATE(NOW()), p_user,
        p_product, p_warehouse, COALESCE(p_attributesetinstance, '0'), p_uom,COALESCE(p_qtyreserved, 0),COALESCE(p_qtyordered, 0)
      )
      ;
  ELSE
    UPDATE M_STORAGE_PENDING
      SET QTYRESERVED=QTYRESERVED + COALESCE(p_qtyreserved, 0),
      QTYORDERED=QTYORDERED + COALESCE(p_qtyordered, 0),
      AD_CLIENT_ID=p_client,
      AD_ORG_ID=p_org,
      UPDATED=TO_DATE(NOW()),
      UPDATEDBY=p_user
    WHERE M_PRODUCT_ID=p_product
      AND M_WAREHOUSE_ID=p_warehouse
      AND COALESCE(M_ATTRIBUTESETINSTANCE_ID, '0')=COALESCE(p_attributesetinstance, '0')
      AND C_UOM_ID=p_uom;
  END IF;
END ; $_$;


ALTER FUNCTION public.m_update_storage_pending(p_client character varying, p_org character varying, p_user character varying, p_product character varying, p_warehouse character varying, p_attributesetinstance character varying, p_uom character varying, p_product_uom_dummy character varying, p_qtyreserved numeric, p_qtyorderreserved_dummy numeric, p_qtyordered numeric, p_qtyorderordered_dummy numeric) OWNER TO tad;



CREATE OR REPLACE FUNCTION m_update_inventory(p_client character varying, p_org character varying, p_user character varying, p_product character varying, p_locator character varying, p_attributesetinstance character varying, p_uom character varying, p_product_uom_dummy character varying, p_qty numeric, p_qtyorder_dummy numeric, p_datelastinventory timestamp without time zone, p_preqty numeric, p_preqtyorder_dummy numeric) RETURNS void
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
* Contributor(s): Stefan Zimmermann, 02/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
***************************************************************************************************************************************************
BUGFIX: Deactivate Secondary UOM
Deactivate Secondary UOM -  Inventory schould be working ONLY with 1st UOM

*****************************************************/
  v_cuenta NUMERIC;
  v_Storage_ID VARCHAR(32); --OBTG:VARCHAR2--
BEGIN
  -- SZ
  SELECT COUNT(*)
  INTO v_cuenta
  FROM M_STORAGE_DETAIL
  WHERE M_PRODUCT_ID=p_product
    AND M_LOCATOR_ID=p_locator
    AND COALESCE(M_ATTRIBUTESETINSTANCE_ID, '0')=COALESCE(p_attributesetinstance, '0')
    AND C_UOM_ID=p_uom;
 
  IF(v_cuenta=0) THEN
    SELECT * INTO  v_Storage_ID FROM Ad_Sequence_Next('M_Storage_Detail', p_client) ;
    INSERT
    INTO M_STORAGE_DETAIL
      (
        M_Storage_Detail_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE,
        CREATED, CREATEDBY, UPDATED, UPDATEDBY,
        M_PRODUCT_ID, M_LOCATOR_ID, M_ATTRIBUTESETINSTANCE_ID, C_UOM_ID,
        QTYONHAND,
        DATELASTINVENTORY,
        PREQTYONHAND
      )
      VALUES
      (
        v_Storage_ID, p_client, p_org, 'Y',
        TO_DATE(NOW()), p_user, TO_DATE(NOW()), p_user,
        p_product, p_locator, COALESCE(p_attributesetinstance, '0'), p_uom,
        COALESCE(p_qty, 0),
        p_datelastinventory,
        COALESCE(p_preqty, 0)
      )
      ;
  ELSE
    UPDATE M_STORAGE_DETAIL
      SET QTYONHAND=QTYONHAND + COALESCE(p_qty, 0),
      DATELASTINVENTORY=COALESCE(p_datelastinventory, DATELASTINVENTORY),
      PREQTYONHAND=PREQTYONHAND + COALESCE(p_preqty, 0),
      AD_CLIENT_ID=p_client,
      AD_ORG_ID=p_org,
      UPDATED=TO_DATE(NOW()),
      UPDATEDBY=p_user
    WHERE M_PRODUCT_ID=p_product
      AND M_LOCATOR_ID=p_locator
      AND COALESCE(M_ATTRIBUTESETINSTANCE_ID, '0')=COALESCE(p_attributesetinstance, '0')
      AND C_UOM_ID=p_uom;
  END IF;
END ; $_$;


ALTER FUNCTION public.m_update_inventory(p_client character varying, p_org character varying, p_user character varying, p_product character varying, p_locator character varying, p_attributesetinstance character varying, p_uom character varying, p_product_uom_dummy character varying, p_qty numeric, p_qtyorder_dummy numeric, p_datelastinventory timestamp without time zone, p_preqty numeric, p_preqtyorder_dummy numeric)  OWNER TO tad;

CREATE OR REPLACE FUNCTION m_inoutline_trg() RETURNS trigger LANGUAGE plpgsql
AS $_$ DECLARE 
  v_ID          VARCHAR(32); --OBTG:varchar2--
  v_RO    NUMERIC;
  v_movementtype  VARCHAR(2); --OBTG:VARCHAR2--
  v_qty    NUMERIC;
  v_qtyorder   NUMERIC;
  v_qtyold   NUMERIC;
  v_qtyorderold  NUMERIC;
  v_STOCKED   NUMERIC;
  v_UOM_ID    VARCHAR(32); --OBTG:varchar2--
/******************************************************************************
 * The contents of this file are subject to the   Compiere License  Version 1.1
 * ("License"); You may not use this file except in compliance with the License
 * You may obtain a copy of the License at http://www.compiere.org/license.html
 * Software distributed under the License is distributed on an  "AS IS"  basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * The Original Code is                  Compiere  ERP &  Business Solution
 * The Initial Developer of the Original Code is Jorg Janke  and ComPiere, Inc.
 * Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke, parts
 * created by ComPiere are Copyright (C) ComPiere, Inc.;   All Rights Reserved.
 * Contributor(s): Openbravo SL, Stefan Zimmermann
 * Contributions are Copyright (C) 2001-2006 Openbravo S.L.
 * Contributions are Copyright (C) 2011 Stefan Zimmermann
 ******************************************************************************/
     
BEGIN
    
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;

  -- ReadOnly Check
  SELECT  COUNT(*) INTO v_RO  FROM M_InOut WHERE M_InOut_ID=v_ID  AND (Processed='Y' OR Posted='Y');
  IF (v_RO > 0) THEN
    IF (TG_OP = 'INSERT' OR TG_OP = 'DELETE') THEN
            RAISE EXCEPTION '%', 'Document processed/posted'; --OBTG:-20501--
    ELSIF (new.M_Product_ID<>old.M_Product_ID OR new.MovementQty<>old.MovementQty
        OR COALESCE(new.M_AttributeSetInstance_ID, '0') <> COALESCE(old.M_AttributeSetInstance_ID, '0')
        OR COALESCE(new.M_Locator_ID,'-1') <> COALESCE(old.M_Locator_ID,'-1'))
    THEN
            RAISE EXCEPTION '%', 'Document processed/posted'; --OBTG:-20501--
    END IF;
  END IF;-- ReadOnly Check
  -- INSERT Checks and Qtys
  IF (TG_OP = 'INSERT') THEN
    IF (NEW.M_PRODUCT_ID IS NOT NULL) THEN
        SELECT C_UOM_ID INTO v_UOM_ID FROM M_PRODUCT WHERE M_PRODUCT_ID=NEW.M_PRODUCT_ID;
        IF (COALESCE(v_UOM_ID,'0') <> COALESCE(NEW.C_UOM_ID,'0')) THEN
            IF (NEW.C_ORDERLINE_ID IS NOT NULL) THEN
            SELECT C_UOM_ID INTO v_UOM_ID FROM C_ORDERLINE WHERE C_ORDERLINE_ID = NEW.C_ORDERLINE_ID;
            IF (COALESCE(v_UOM_ID,'0') <> COALESCE(NEW.C_UOM_ID,'0')) THEN
                    RAISE EXCEPTION '%', 'Unit of Measure mismatch (product/transaction)'; --OBTG:-20111--
            END IF;
            ELSE
            RAISE EXCEPTION '%', 'Unit of Measure mismatch (product/transaction)'; --OBTG:-20111--
            END IF;
        END IF;
    END IF;

    v_ID := new.M_InOut_ID;

    SELECT MOVEMENTTYPE INTO v_movementtype
        FROM M_INOUT
        WHERE M_INOUT_ID = NEW.M_INOUT_ID;
    IF v_movementtype in ('C-','V-') THEN
        v_qty := -NEW.MOVEMENTQTY;
      v_qtyorder := -NEW.QUANTITYORDER;
    ELSE
        v_qty := NEW.MOVEMENTQTY;
        v_qtyorder := NEW.QUANTITYORDER;
    END IF;
  END IF; -- INSERT Checks
  IF (TG_OP = 'UPDATE') THEN
    IF (COALESCE(OLD.C_UOM_ID, '0') <> COALESCE(NEW.C_UOM_ID, '0')) THEN
        IF (NEW.M_PRODUCT_ID IS NOT NULL) THEN
            SELECT C_UOM_ID INTO v_UOM_ID FROM M_PRODUCT WHERE M_PRODUCT_ID=NEW.M_PRODUCT_ID;
            IF (COALESCE(v_UOM_ID,'0') <> COALESCE(NEW.C_UOM_ID,'0')) THEN
                IF (NEW.C_ORDERLINE_ID IS NOT NULL) THEN
                SELECT C_UOM_ID INTO v_UOM_ID FROM C_ORDERLINE WHERE C_ORDERLINE_ID = NEW.C_ORDERLINE_ID;
                    IF (COALESCE(v_UOM_ID,'0') <> COALESCE(NEW.C_UOM_ID,'0')) THEN
                    RAISE EXCEPTION '%', 'Unit of Measure mismatch (product/transaction)'; --OBTG:-20111--
                    END IF;
                ELSE
                RAISE EXCEPTION '%', 'Unit of Measure mismatch (product/transaction)'; --OBTG:-20111--
                END IF;
            END IF;
        END IF;
    END IF; 
    v_ID := new.M_InOut_ID;

    SELECT MOVEMENTTYPE INTO v_movementtype
        FROM M_INOUT
        WHERE M_INOUT_ID = NEW.M_INOUT_ID;
    IF v_movementtype in ('C-','V-') THEN
        v_qty := -NEW.MOVEMENTQTY;
        v_qtyorder := -NEW.QUANTITYORDER;
    ELSE
        v_qty := NEW.MOVEMENTQTY;
        v_qtyorder := NEW.QUANTITYORDER;
    END IF;
  END IF; -- Update Checks


  IF TG_OP = 'UPDATE' OR TG_OP = 'DELETE' THEN
    v_ID := old.M_InOut_ID;
    SELECT MOVEMENTTYPE INTO v_movementtype
    FROM M_INOUT
    WHERE M_INOUT_ID = OLD.M_INOUT_ID;
    IF v_movementtype in ('C-','V-') THEN
        v_qtyold := OLD.MOVEMENTQTY;
        v_qtyorderold := OLD.QUANTITYORDER;
    ELSE
        v_qtyold := -OLD.MOVEMENTQTY;
        v_qtyorderold := -OLD.QUANTITYORDER;
    END IF;
  END IF; -- Update - Delete - Old Qtys


 -- UPDATING inventory
 IF (TG_OP = 'UPDATE' OR TG_OP = 'DELETE') THEN
  IF (old.M_PRODUCT_ID IS NOT NULL AND OLD.M_LOCATOR_ID IS NOT NULL) THEN
    SELECT COUNT(*) INTO V_STOCKED FROM M_PRODUCT WHERE M_Product_ID=OLD.M_PRODUCT_ID AND IsStocked = 'Y' AND ProductType = 'I';
    IF V_STOCKED > 0  THEN
        PERFORM M_UPDATE_INVENTORY(OLD.AD_CLIENT_ID, OLD.AD_ORG_ID, OLD.UPDATEDBY, OLD.M_PRODUCT_ID, OLD.M_LOCATOR_ID, OLD.M_ATTRIBUTESETINSTANCE_ID, OLD.C_UOM_ID, OLD.M_PRODUCT_UOM_ID, NULL, NULL, NULL, v_qtyold, v_qtyorderold);
    END IF;
  END IF;
 END IF;
 IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
   IF (NEW.M_PRODUCT_ID IS NOT NULL AND NEW.M_LOCATOR_ID IS NOT NULL) THEN
    SELECT COUNT(*) INTO V_STOCKED FROM M_PRODUCT WHERE M_Product_ID=NEW.M_PRODUCT_ID AND IsStocked = 'Y' AND ProductType = 'I';
    IF V_STOCKED > 0 THEN
        PERFORM M_UPDATE_INVENTORY(NEW.AD_CLIENT_ID, NEW.AD_ORG_ID, NEW.UPDATEDBY, NEW.M_PRODUCT_ID, NEW.M_LOCATOR_ID,NEW.M_ATTRIBUTESETINSTANCE_ID, NEW.C_UOM_ID,NEW.M_PRODUCT_UOM_ID, NULL, NULL, NULL, v_qty, v_qtyorder);
    END IF;
   END IF;
 END IF;
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END; $_$;


ALTER FUNCTION public.m_inoutline_trg() OWNER TO tad;


CREATE OR REPLACE FUNCTION m_inout_create(p_pinstance_id character varying, OUT p_inout_id character varying, p_order_id character varying, p_invoice_id character varying, p_forcedelivery character, p_locator_id character varying) RETURNS character varying
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
* Contributor(s): Stefan Zimmermann, 02/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************/

/*
 Contributions: Bugfix,Accounting-Date must be same Acct-Date than Order ACCT-Date
                Ext.: Take Shipment-Assignments from Order, if there
                Don't create Shipments that have only Freight Products
                Removed Warehouse from Orderline-Cursor (Each Order schoud be Created in One Shipment even if it has different Warehouses)
                Disabled secondary UOM in Mat-Transaction
                2nd UOM is not transacted to Storage. - It is only Used on Orders, Invoices and  in InOut-
                Order ID and Invoice ID are OBSOLETE

For Manual Shipments a new Function was Created - This one is tooo chaotic.
*************************************************************************************************************************************************/



/* *************************************************************************
  * $Id: M_InOut_Create.sql,v 1.17 2003/09/05 04:58:06 jjanke Exp $
  ***
  * Title: Create Shipment from Order
  * Description:
  * Order Loop goes though all open orders, where we would need to ship something
  *  if forced or if there is a line to ship
  *   create InOut document header
  *   for all qualifying order lines
  *    check every locator availability and if qty available
  *     create InOut line
  *
  * Order and reservation is updated when posting
  * as there should not be a delay between creating + posting it
  *
  * For each Warehouse create lines (with exception if Direct Ship's),
  * create also lines for non-stocked, ad_hoc products or comments
  * 
  ************************************************************************/
  -- Logistice
  v_result NUMERIC(1):=1;
  v_Message character varying:=''; --OBTG:VARCHAR2--
  result_String character varying:=''; --OBTG:VARCHAR2--
  -- Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    v_allownegativestock CHAR(1);
    v_orderdoc varchar;
    v_NextNo varchar;
   
    v_Record_ID VARCHAR(32):=NULL; --OBTG:VARCHAR2--
    v_Selection VARCHAR(1):='N'; --OBTG:VARCHAR2--
   
    -- Orders to process  - one per warehouse
    Cur_Lines RECORD;
    --
    CREATE_FROM_INVOICE boolean:=false;
    v_DocType_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_DocumentNo VARCHAR(40)='' ; --OBTG:VARCHAR2--
    v_2ndUOMQty NUMERIC;
    v_LocatorQty NUMERIC;
    --
    v_lines NUMERIC:=0;
    v_count NUMERIC:=0;
    Next_Line BOOLEAN:=false;
    FINISH_PROCESS BOOLEAN:=false;
    v_issotrx varchar;
    v_serial varchar;
    v_user varchar;
    v_OrderId varchar:='';
     v_draftexists numeric:=0;
    v_org varchar;
    v_order_delivered_count numeric:=0;
    v_lineid varchar;
    v_isserial boolean:=false;
    v_batch   varchar;
  BEGIN
    -- Process Parameters
    IF(p_PInstance_ID IS NOT NULL) THEN
      --  Chec  k for serial execution
      RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
      SELECT COUNT(*)
      INTO v_count
      FROM AD_PINSTANCE
      WHERE AD_PROCESS_ID IN(SELECT AD_PROCESS_ID FROM AD_PINSTANCE WHERE AD_PInstance_ID=p_PInstance_ID)
        AND IsProcessing='Y'
        AND AD_PInstance_ID<>p_PInstance_ID;
      IF(v_count>0) THEN
        RAISE EXCEPTION '%', '@SerialProcessStillRunning@' ; --OBTG:-20000--
      END IF;
      --  Update AD_PInstance
      RAISE NOTICE '%','M_InOut_Create - Processing ' || p_PInstance_ID ;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
      
      FOR Cur_Parameter IN
        (SELECT i.Record_ID, p.ParameterName, p.P_String, p.P_Number, p.P_Date, 
          p.AD_CLIENT_ID, ci.allownegativestock
        FROM AD_ClientInfo ci, AD_PInstance i LEFT JOIN AD_PInstance_Para p ON i.AD_PInstance_ID=p.AD_PInstance_ID
        WHERE i.AD_PInstance_ID=p_PInstance_ID
          AND p.ad_client_id = ci.ad_client_id
        ORDER BY p.SeqNo) LOOP
        v_allownegativestock := cur_parameter.allownegativestock;
        v_Record_ID:=Cur_Parameter.Record_ID;
      END LOOP; -- Get Parameter
      RAISE NOTICE '%','  v_Record_ID=' || v_Record_ID ;
    ELSIF(p_Invoice_ID IS NOT NULL) THEN
      CREATE_FROM_INVOICE:=true;
      SELECT ad_clientinfo.allownegativestock
      INTO  v_allownegativestock
      FROM ad_clientinfo, c_invoice
      where ad_clientinfo.ad_client_id = c_invoice.ad_client_id
      and c_invoice_id = p_invoice_id;
    ELSE
      v_Record_ID:=p_Order_ID;
      RAISE NOTICE '%','--<<M_InOut_Create>> Order_ID=' || v_Record_ID;
      SELECT ad_clientinfo.allownegativestock
      INTO  v_allownegativestock
       FROM ad_clientinfo, c_order
      where ad_clientinfo.ad_client_id = c_order.ad_client_id
      and c_order_id = v_Record_ID;

    END IF;

    
    BEGIN --BODY

      -- Implementing Manual Shipments 
      select count(*) into v_count from c_generateminoutmanual where m_inoutline_id is null and pinstance_id=p_pinstance_id;
      
      IF(v_count>0) THEN
        /**************************************************************************
        * Reimplemented with Generate shipmentsmanual
        *************************************************************************/
        FOR Cur_lines in (SELECT ol.*,  gm.Qty AS pendingqty, gm.deliverycomplete as pendingdeliverycomplete,
                                 gm.m_locator_id pendinglocator,gm.c_generateminoutmanual_id
                             FROM c_orderline ol, c_generateminoutmanual gm where 
                                  ol.c_orderline_id=gm.c_orderline_id and gm.m_inoutline_id is null and pinstance_id=p_pinstance_id
                             ORDER By gm.c_order_id,ol.line for update)
        LOOP
              -- New shipment
              If v_OrderId!=Cur_lines.c_order_id then
                 -- activate just created Transaction.. 
                 if  v_OrderId!='' then 
                       if v_lines=0 and v_draftexists=0 then -- no lines created.
                          delete from M_INOUT where M_InOut_ID=p_InOut_ID;
                          v_order_delivered_count:=v_order_delivered_count-1;
                       else
                             if (v_issotrx='Y'  and v_draftexists=0 and c_getconfigoption('activateshipmentautomatically',v_org)='Y') or (v_issotrx='N' and c_getconfigoption('activatereceiptautomatically',v_org)='Y') then
                                if v_isserial then
                                   v_Message:='@zssm_MaterialReceivedSerialRegistrationNeccessary@'|| v_Message;
                                else
                                   PERFORM M_INOUT_POST(NULL, p_InOut_ID) ;
                                end if;
                             end if;
                             if v_issotrx='Y' and v_draftexists=0 then
                                 v_Message:=v_Message||'@ShipmentCreated@: ' || zsse_htmlLinkDirectKey('../GoodsMovementcustomer/GoodsMovementcustomer_Relation.html',p_InOut_ID,v_DocumentNo)||'<br />';
                             end if;
                             if v_issotrx='N' and v_draftexists=0 then
                                 v_Message:=v_Message||'@ReceiptCreated@: ' || zsse_htmlLinkDirectKey('../GoodsMovementVendor/GoodsMovementVendor_Relation.html',p_InOut_ID,v_DocumentNo)||'<br />';
                             end if;
                       end if;
                 end if;
                 v_OrderId:=Cur_lines.c_order_id;
                 SELECT C_DocTypeShipment_ID,c_order.issotrx INTO v_DocType_ID,v_issotrx,v_org FROM C_DOCTYPE,c_order  WHERE C_DOCTYPE.C_DocType_ID=c_order.C_DocType_Id and c_order.c_order_id=Cur_lines.c_order_id;
                 SELECT * INTO  v_DocumentNo FROM Ad_Sequence_Doctype(v_DocType_ID, Cur_lines.ad_org_ID, 'Y') ;
                 IF(v_DocumentNo IS NULL) THEN
                    SELECT * INTO  v_DocumentNo FROM Ad_Sequence_Doc('DocumentNo_M_InOut', Cur_lines.ad_org_ID, 'Y') ;
                 END IF;
                 select get_uuid() into p_InOut_ID;
                 select updatedby into v_user from c_generateminoutmanual where c_generateminoutmanual_id=Cur_lines.c_generateminoutmanual_id;
                 -- Check if Draft exist.
                 select count(*) into v_draftexists from   m_inoutline il,m_inout i where il.c_orderline_id =Cur_lines.c_orderline_id and il.m_inout_id=i.m_inout_id and i.docstatus='DR'; 
                 if v_draftexists>0 then
                    select i.m_inout_id,documentno into p_InOut_ID,v_DocumentNo from   m_inoutline il,m_inout i where il.c_orderline_id =Cur_lines.c_orderline_id and il.m_inout_id=i.m_inout_id and i.docstatus='DR'; 
                    if v_issotrx='Y' then     
                              v_Message:=v_Message||'@DraftExistsCannotGenerate@ :' || zsse_htmlLinkDirectKey('../GoodsMovementcustomer/GoodsMovementcustomer_Relation.html',p_InOut_ID,v_DocumentNo)||'<br />';
                    else
                              v_Message:=v_Message||'@DraftExistsCannotGenerate@ :' || zsse_htmlLinkDirectKey('../GoodsMovementVendor/GoodsMovementVendor_Relation.html',p_InOut_ID,v_DocumentNo)||'<br />';
                    end if;
                 else
                       -- Create header
                       INSERT INTO M_INOUT
                          (M_InOut_ID, C_Order_ID, IsSOTrx, AD_Client_ID,
                          AD_Org_ID, CreatedBy, UpdatedBy, DocumentNo, C_DocType_ID,
                          Description, MovementType, MovementDate,
                          DateAcct, C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID,
                          M_Warehouse_ID, POReference, DateOrdered, DeliveryRule,
                          FreightCostRule, FreightAmt, 
                          DeliveryViaRule, M_Shipper_ID, PriorityRule, DocStatus, DocAction, Processing,
                          Processed, SALESREP_ID,
                                      a_asset_id,
                                      c_project_id,
                                      c_projecttask_id,
                          DELIVERY_LOCATION_ID,c_incoterms_id,weight,weight_uom) 
                       select p_InOut_ID,C_Order_ID, IsSOTrx,Cur_lines.AD_Client_ID,Cur_lines.AD_Org_ID,v_user,v_user,
                               v_DocumentNo,v_DocType_ID,Description,
                               case IsSOTrx when 'Y' then 'C-' else 'V+' end as MovementType,now() as MovementDate,
                               DateAcct, C_BPartner_ID, C_BPartner_Location_ID, AD_User_ID,M_Warehouse_ID, POReference, DateOrdered, DeliveryRule,
                               FreightCostRule, FreightAmt, 
                                DeliveryViaRule, M_Shipper_ID, PriorityRule, 'DR', 'CO', 'N',
                               'N', SALESREP_ID, a_asset_id, c_project_id, c_projecttask_id,delivery_location_id,c_incoterms_id,weight,weight_uom
                       from c_order where c_order_id=Cur_lines.c_order_id;
                       v_order_delivered_count:=v_order_delivered_count+1;
                 end if;
                 v_lines:=0;
                end if; -- New schipment
                -- Create a Line
                 select isserialtracking,isbatchtracking into v_serial,v_batch from m_product where m_product_id=Cur_lines.m_product_id;
                -- check availability.
                if v_issotrx='Y' then
                      v_LocatorQty:=m_bom_qty_onhand(Cur_lines.m_product_id, null,Cur_lines.pendinglocator);
                      if v_LocatorQty < Cur_lines.pendingqty and v_allownegativestock='N' and p_ForceDelivery='N' then
                         select documentno into v_orderdoc from c_order where c_order_id=Cur_lines.c_order_id;
                         v_Message:=v_Message|| '@Order@: ' ||v_orderdoc||',  @OrderLine@: ' || Cur_lines.Line || ', @ForProduct@ ' || zssi_getproductname(Cur_lines.m_product_id,'de_DE') || ': @notEnoughStock@<br />';
                         Next_Line:=true;
                      end if;
                end if;
                if Next_Line=false and v_draftexists=0 and Cur_lines.pendingqty!=0 then
                   if Cur_lines.m_product_uom_id is not null then
                      v_2ndUOMQty:=Cur_lines.pendingqty*Cur_lines.quantityorder/Cur_lines.qtyordered;
                   else
                      v_2ndUOMQty:=null;
                   end if;
                   v_lines:=v_lines + 10;
                   select get_uuid() into v_lineid;
                   INSERT INTO M_INOUTLINE
                              (M_InOutLine_ID, Line, M_InOut_ID, C_OrderLine_ID,
                              AD_Client_ID, AD_Org_ID, CreatedBy, UpdatedBy, M_Product_ID,
                              C_UOM_ID, M_Locator_ID, MovementQty, Description,
                              IsInvoiced,QuantityOrder, M_Product_Uom_ID,
                                                          a_asset_id,
                                                          c_project_id,
                                                          c_projecttask_id)
                            VALUES
                              (v_lineid, v_lines, p_InOut_ID, Cur_lines.C_OrderLine_ID,
                              Cur_lines.AD_Client_ID, Cur_lines.AD_Org_ID,  v_user,v_user, Cur_lines.M_Product_ID,
                              Cur_lines.C_UOM_ID, Cur_lines.pendinglocator, Cur_lines.pendingqty, Cur_lines.Description,
                              'N',v_2ndUOMQty,Cur_lines.m_product_uom_id,
                                                          Cur_lines.a_asset_id,
                                                          Cur_lines.c_project_id,
                                                          Cur_lines.c_projecttask_id);
                   update c_generateminoutmanual set m_inoutline_id=v_lineid  where c_generateminoutmanual_id=Cur_lines.c_generateminoutmanual_id;
                   if v_serial='Y'  or v_batch='Y' then
                       v_isserial:=true;
                       if v_issotrx='Y' then     
                            v_Message:=v_Message||zsse_htmlLinkDirectKey('../GoodsMovementcustomer/Lines_Relation.html',v_lineid,'Serial Number Tracking')||'<br />';
                       else
                             v_Message:=v_Message||zsse_htmlLinkDirectKey('../GoodsMovementVendor/Lines_Relation.html',v_lineid,'Serial Number Tracking')||'<br />';
                       end if;
                   end if;
                end if; -- next line 
                -- Only on 0-Lines (No line Created) Set Delivery Complete on Order
                -- For all other Lines Delivery Complete is set only after Activating the In-Out Transaction
                if Cur_lines.pendingqty=0 and Cur_lines.pendingdeliverycomplete='Y' then
                     UPDATE C_ORDERLINE SET deliverycomplete='Y' WHERE C_OrderLine_ID=Cur_lines.C_OrderLine_ID;
                end if;
            Next_Line:=false;             
        END LOOP; --Cur_lines
        if v_lines=0 and v_draftexists=0 then -- no lines created.
             delete from M_INOUT where M_InOut_ID=p_InOut_ID;
             v_order_delivered_count:=v_order_delivered_count-1;
        else
          if (v_issotrx='Y' and v_draftexists=0 and c_getconfigoption('activateshipmentautomatically',v_org)='Y') or (v_issotrx='N' and c_getconfigoption('activatereceiptautomatically',v_org)='Y') then
               if v_isserial=true then
                   v_Message:='@zssm_MaterialReceivedSerialRegistrationNeccessary@'|| v_Message;
               else
                   PERFORM M_INOUT_POST(NULL, p_InOut_ID) ;
               end if;
          end if;
          if v_issotrx='Y' and v_draftexists=0 then
             v_Message:=v_Message||'@ShipmentCreated@: ' || zsse_htmlLinkDirectKey('../GoodsMovementcustomer/GoodsMovementcustomer_Relation.html',p_InOut_ID,v_DocumentNo)||'<br />';
          end if;
          if v_issotrx='N' and v_draftexists=0 then
             v_Message:=v_Message||'@ReceiptCreated@: ' || zsse_htmlLinkDirectKey('../GoodsMovementVendor/GoodsMovementVendor_Relation.html',p_InOut_ID,v_DocumentNo)||'<br />';
          end if;
          v_result :=1;
        END IF;
      END IF; -- count>0
      IF (v_order_delivered_count = 0 and v_draftexists=0) THEN
          v_Message := v_Message||'@ZeroOrdersProcessed@';
          v_result :=1;
      END IF;
      /*************************************************************************/
      ---- <<FINISH_PROCESS>>
      IF(p_PInstance_ID IS NOT NULL) THEN
        --  Update AD_PInstance
      
        RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
        PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', v_result, v_Message) ;
      ELSE
        RAISE NOTICE '%','--<<M_InOut_Create finished>> ' || v_Message;
      END IF;
      --
      RETURN;
    END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_Message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_Message ;
  IF(p_PInstance_ID IS NOT NULL) THEN
    -- ROLLBACK;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_Message) ;
  ELSE
    RAISE EXCEPTION '%', SQLERRM;
  END IF;
  p_InOut_ID:='0'; -- Error Indicator
  RETURN;
END ; $_$;


ALTER FUNCTION public.m_inout_create(p_pinstance_id character varying, OUT p_inout_id character varying, p_order_id character varying, p_invoice_id character varying, p_forcedelivery character, p_locator_id character varying) OWNER TO tad;

-- Function: m_internal_consumption_post(character varying)

-- DROP FUNCTION m_internal_consumption_post(character varying);

CREATE OR REPLACE FUNCTION m_internal_consumption_post(pinstance_id character varying)
  RETURNS void AS
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
* Contributions: Internal Consumption linked to Projects
                 Update BOM of Project-Task if any to indicate that 
                 Material is fetched from stock
**************************************************************************************************************************************************/

  -- Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message2 VARCHAR(2000):='';
  Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Result NUMERIC:=1;
  -- Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    -- Parameter Variables
    v_IsProcessing CHAR(1) ;
    v_IsProcessed VARCHAR(60) ; --OBTG:VARCHAR2--
    v_NoProcessed NUMERIC:=0;
    v_MoveDate TIMESTAMP;
    v_Client_ID VARCHAR(32) ; --OBTG:VARCHAR2--
    v_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_User VARCHAR(32); --OBTG:VARCHAR2--
    v_line NUMERIC;
    v_Count NUMERIC:=0;
    END_PROCESS BOOLEAN:=false;
    V_STOCKED       NUMERIC;
    v_movementtype character varying;
    v_movqty numeric;
    v_resqty numeric;
	v_new_id VARCHAR(32);
	v_product_name character varying;
	v_projecttask_name character varying;
	v_projecttask_name2 character varying;
    v_bom_id varchar;
    v_category varchar;
    Cur_MoveLine RECORD;
        NextNo VARCHAR(32); --OBTG:varchar2--
  BEGIN
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Processing ' || PInstance_ID ;
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'Y', NULL, NULL) ;
  BEGIN --BODY
    -- Get Parameters
    SELECT i.Record_ID, i.AD_User_ID into Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=PInstance_ID;
    if Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || PInstance_ID;
       Record_ID:=PInstance_ID;
       v_User:='0';
    end if;
    RAISE NOTICE '%','  Record_ID=' || Record_ID ;
    -- Check if there are lines document does
     if (select count(*) from  M_Internal_ConsumptionLINE where M_Internal_Consumption_ID = Record_ID)=0 then
          RAISE EXCEPTION '%', '@NoLinesInDoc@';
     END IF; 
    -- Reading Internal_Consumption
    SELECT MovementDate,
      Processing,
      Processed,
      AD_Client_ID,
      AD_Org_ID,
      movementtype
    INTO v_MoveDate,
      v_IsProcessing,
      v_IsProcessed,
      v_Client_ID,
      v_Org_ID,
      v_movementtype
    FROM M_Internal_Consumption
    WHERE M_Internal_Consumption_ID=Record_ID  FOR UPDATE;
    IF(v_IsProcessing='Y') THEN
          RAISE EXCEPTION '%', '@OtherProcessActive@' ; --OBTG:-20000--
    END IF;
    IF(v_IsProcessed='Y') THEN
      RAISE EXCEPTION '%', '@AlreadyPosted@' ; --OBTG:-20000--
    END IF;
    IF(NOT END_PROCESS) THEN
      v_ResultStr:='CheckingRestrictions';
      SELECT COUNT(*), MAX(line)
      INTO v_Count,v_line
      FROM M_Internal_ConsumptionLine M,
        M_Product P
      WHERE M.M_PRODUCT_ID=P.M_PRODUCT_ID
        AND P.M_ATTRIBUTESET_ID IS NOT NULL
        AND P.M_ATTRIBUTESETINSTANCE_ID IS NULL
        AND COALESCE(M.M_ATTRIBUTESETINSTANCE_ID, '0') = '0'
        AND M.M_Internal_Consumption_ID=Record_ID;
      IF v_Count<>0 THEN
       RAISE EXCEPTION '%', '@Inline@ '||v_line||' '||'@productWithoutAttributeSet@' ; --OBTG:-20000--
      END IF;
    END IF;--END_PROCESS
    IF(NOT END_PROCESS) THEN
      -- Start Processing ------------------------------------------------------
      v_ResultStr:='LockingInternal_Consumption';
      UPDATE M_Internal_Consumption
        SET Processing='Y'
      WHERE M_Internal_Consumption_ID=Record_ID;
      -- Commented by cromero 19102006 -- COMMIT;
      /**
      * Accounting first step
      */
        FOR Cur_MoveLine IN
          (SELECT *
          FROM M_Internal_ConsumptionLine
          WHERE M_Internal_Consumption_ID=Record_ID
          ORDER BY Line
          )
        LOOP
          v_ResultStr:='Transaction for line' || Cur_MoveLine.Line;
          -- Check Stocked Product
          SELECT COUNT(*) INTO V_STOCKED  FROM M_PRODUCT  WHERE M_Product_ID=Cur_MoveLine.M_PRODUCT_ID  AND IsStocked='Y'  AND ProductType='I';
		  select name into v_product_name from m_product where m_product.m_product_id=Cur_MoveLine.m_product_id;
		  select name into v_projecttask_name from c_projecttask where c_projecttask.c_projecttask_id=Cur_MoveLine.c_projecttask_id;
          if V_STOCKED>0 then
              -- DO Stock Transaction
              SELECT * INTO  NextNo FROM AD_Sequence_Next('M_Transaction', v_Client_ID);
              v_movqty:= case v_movementtype when 'D-' then -1 else 1 end *  Cur_MoveLine.movementqty;
              INSERT
              INTO M_Transaction
                (
                  M_Transaction_ID, AD_Client_ID, AD_Org_ID, IsActive,
                  Created, CreatedBy, Updated, UpdatedBy,
                  MovementType, M_Locator_ID, M_Product_ID, M_AttributeSetInstance_ID,
                  MovementDate, MovementQty, M_Internal_ConsumptionLine_ID,C_UOM_ID,c_project_id,c_projecttask_id
                )
                VALUES
                (
                  NextNo, Cur_MoveLine.AD_Client_ID, Cur_MoveLine.AD_Org_ID, 'Y',
                  TO_DATE(NOW()), '0', TO_DATE(NOW()), '0',
                  v_movementtype, Cur_MoveLine.M_Locator_ID, Cur_MoveLine.M_Product_ID, COALESCE(Cur_MoveLine.M_AttributeSetInstance_ID, '0'),
                  v_MoveDate, v_movqty, Cur_MoveLine.M_Internal_ConsumptionLine_ID, Cur_MoveLine.C_UOM_ID, Cur_MoveLine.c_project_id,Cur_MoveLine.c_projecttask_id
                );
                -- SZ Update BOM of Project-Task if any to indicate that Material is fetched from stock
		if (Cur_MoveLine.c_projecttask_id is not null) then
		      if v_movementtype='P+' then
		          -- Update Produced Quantity
		          update c_projecttask set qtyproduced=qtyproduced+v_movqty where c_projecttask_id=Cur_MoveLine.c_projecttask_id;
		      end if;
                      select count(*) into v_count from zspm_projecttaskbom where c_projecttask_id=Cur_MoveLine.c_projecttask_id and m_product_id=Cur_MoveLine.m_product_id;
                      if v_count=0 and v_movementtype!='P+' then --insert
                            v_bom_id:=get_uuid();
                            -- Look if this is a mashine, that schould be returned after consumption
                            select count(*) into v_count from snr_internal_consumptionline snl,snr_masterdata snr,ma_machine m where m.snr_masterdata_id=snr.snr_masterdata_id
                                                              and snl.serialnumber=snr.serialnumber and m.ismovedinprojects='Y' and snl.m_internal_consumptionline_id=Cur_MoveLine.M_Internal_ConsumptionLine_ID;
                            --                                 
                            insert into zspm_projecttaskbom (zspm_projecttaskbom_id, c_projecttask_id,  ad_client_id, ad_org_id,createdby,updatedby, m_product_id, quantity, description,
                                    actualcosamount,qtyreceived, date_plan,isreturnafteruse,m_locator_id)
                            values ( v_bom_id, Cur_MoveLine.c_projecttask_id, Cur_MoveLine.ad_client_id,Cur_MoveLine.ad_org_id,v_User, v_User, Cur_MoveLine.m_product_id,
                                    0, Cur_MoveLine.description,(m_get_product_cost(Cur_MoveLine.m_product_id, to_date(now()), null, Cur_MoveLine.ad_org_id) * (v_movqty*-1)),
                                    v_movqty*-1,to_date(now()),case when v_count=1 then 'Y' else 'N' end,Cur_MoveLine.M_Locator_ID);
                      else -- update
                        -- Update existing lines. If we have a line (zspm_projecttaskbom_id is not null) we take that.
                        -- Otherwise:
                        -- Fill up next found line		
                        -- Get the Cost on Project, Update QTYs
                        if Cur_MoveLine.zspm_projecttaskbom_id is null then
                               select zspm_projecttaskbom_id into v_bom_id from zspm_projecttaskbom where c_projecttask_id=Cur_MoveLine.c_projecttask_id  and m_product_id=Cur_MoveLine.m_product_id limit 1;
                        else
                             v_bom_id:=  Cur_MoveLine.zspm_projecttaskbom_id;
                        end if;
                        if v_movementtype!='P+' then
                              update zspm_projecttaskbom set qtyreceived=qtyreceived-v_movqty,
                                     actualcosamount=(m_get_product_cost(Cur_MoveLine.m_product_id,to_date(now()),null,Cur_MoveLine.AD_Org_ID)*(qtyreceived-v_movqty))
                              where zspm_projecttaskbom_id=v_bom_id; 
                        end if;
                      end if; -- update
                      if (v_projecttask_name2!=v_projecttask_name or v_projecttask_name2 is null) then
                               select projectcategory into v_category from c_project p,c_projecttask t where p.c_project_id=t.c_project_id and t.c_projecttask_id=  Cur_MoveLine.c_projecttask_id;
                               if v_category in ('P','S','M') then
                                     v_Message:=v_Message||'@MaterialConsumption4ProjectCompleted@'|| zsse_htmlLinkDirectKeyGridView('../org.openbravo.zsoft.project.Projects/MaterialDisposition0F6DE779327E4790A3A9A11779D0713D_Relation.html',v_bom_id,v_projecttask_name)||'<br />';
                               end if;
                               if v_category in ('PRO') and v_movementtype!='P+' then
                                     v_Message:=v_Message||'@MaterialConsumption4ProductionCompleted@'|| zsse_htmlLinkDirectKeyGridView('../org.openbravo.zsoft.serprod.ProductionOrder/Billofmaterials9D775024A45140F0920B936C14A18527_Relation.html',v_bom_id,v_projecttask_name)||'<br />';
                               end if;
                               if v_category in ('PRO') and v_movementtype='P+' then
                                     v_Message:=v_Message||'@MaterialConsumption4ProductionCompleted@'|| zsse_htmlLinkDirectKey('../org.openbravo.zsoft.serprod.ProductionOrder/WorkSteps035860BB9D4F4D08878CED2F371D7201_Relation.html',Cur_MoveLine.c_projecttask_id,v_projecttask_name)||'<br />';
                               end if;
                       end if;
                  v_projecttask_name2:=v_projecttask_name;
               end if; --projecttask
              -- TO
              SELECT * INTO  v_Result, v_Message2 FROM M_Check_Stock(Cur_MoveLine.M_Product_ID, v_Client_ID, v_Org_ID) ;
              IF v_Result=0 THEN
					v_Message:=v_Message2;
                    RAISE EXCEPTION '%', v_Message||' '||'@line@'||' '||Cur_MoveLine.line ; --OBTG:-20000--
              END IF;
          END IF;
        END LOOP;
    END IF;--END PROCESS
    IF(NOT END_PROCESS) THEN
      -- End Processing --------------------------------------------------------
      ---- <<END_PROCESSING>>
      v_ResultStr:='UnLockingMovement';
      UPDATE M_Internal_Consumption
        SET Processed='Y'
      WHERE M_Internal_Consumption_ID=Record_ID;
      -- Commented by cromero 19102006 -- COMMIT;
    END IF;--END_PROCESS
    ---- <<END_PROCESS>>
    -- SZ: Do the Accounting-Process for internal Consumption
    PERFORM ZSFI_POSTINTERNALCONSUMPTION2GL(Record_ID,v_User);
    -- Do Update the Material Plan with new Stock qty's
    PERFORM mrp_inoutplanupdate(null);
    -- SZ end
    v_ResultStr:='UnLockingMovement';
    UPDATE M_Internal_Consumption
      SET Processing='N'
    WHERE M_Internal_Consumption_ID=Record_ID;
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message;
    PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, v_User, 'N', v_Result, v_Message) ;
    RETURN;
  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr ;
  -- ROLLBACK;
  UPDATE M_Internal_Consumption
    SET Processing='N'
  WHERE M_Internal_Consumption_ID=Record_ID;
  -- Commented by cromero 19102006 -- COMMIT;
  PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION m_internal_consumption_post(character varying) OWNER TO tad;








CREATE OR REPLACE FUNCTION m_inventory_post(pinstance_id character varying) RETURNS void
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
  * $Id: M_Inventory_Post.sql,v 1.4 2003/09/05 04:58:06 jjanke Exp $
  ***
  * Title: Physical Inventory Post
  * Description:
  * - Update Storage with correct QtyOnHand
  * - Generate Transcation
  ************************************************************************/
  -- Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Result NUMERIC:=0; -- failure
  v_User VARCHAR(32); --OBTG:VARCHAR2--
  v_IsProcessing CHAR(1) ;
  v_IsProcessed VARCHAR(60) ; --OBTG:VARCHAR2--
  v_NoProcessed NUMERIC:=0;
  v_is_included NUMERIC:=0;
  v_available_period NUMERIC:=0;
  v_is_ready AD_Org.IsReady%TYPE;
  v_is_tr_allow AD_OrgType.IsTransactionsAllowed%TYPE;
  v_isacctle AD_OrgType.IsAcctLegalEntity%TYPE;
  v_org_bule_id AD_Org.AD_Org_ID%TYPE;
  --Added by PSarobe 13062007
  v_line NUMERIC;
  v_Aux NUMERIC;
  -- Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    Cur_Inventorylines RECORD;
    Cur_Lines RECORD;
    -- Parameter Variables
    v_InvDate TIMESTAMP;
    v_Client_ID VARCHAR(32) ; --OBTG:VARCHAR2--
    v_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_Count NUMERIC:=0;
    PROCESS_ERROR BOOLEAN:=false;
    END_PROCESS BOOLEAN:=false;
    END_PROCESSING BOOLEAN:=false;
    rowcount NUMERIC;
  BEGIN
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Processing' ;
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'Y', NULL, NULL) ;
  BEGIN --BODY
    -- Get Parameters
    v_ResultStr:='ReadingParameters';
    FOR Cur_Parameter IN
      (SELECT i.Record_ID,
        i.AD_User_ID,
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
      v_Record_ID:=Cur_Parameter.Record_ID;
      v_User:=Cur_Parameter.AD_User_ID;
    END LOOP; -- Get Parameter
    RAISE NOTICE '%','  Record_ID=' || v_Record_ID ;
    v_ResultStr:='ReadingInventory';
  BEGIN
    SELECT MovementDate,
      Processing,
      Processed,
      AD_Client_ID,
      AD_Org_ID
    INTO v_InvDate,
      v_IsProcessing,
      v_IsProcessed,
      v_Client_ID,
      v_Org_ID
    FROM M_Inventory
    WHERE M_Inventory_ID=v_Record_ID  FOR UPDATE;
  EXCEPTION
  WHEN OTHERS THEN
    RAISE EXCEPTION '%', '@SaveErrorRowNotFound@' ; --OBTG:-20000--
  END;
  IF(NOT PROCESS_ERROR) THEN
    IF(v_IsProcessing='Y') THEN
      RAISE EXCEPTION '%', '@OtherProcessActive@' ; --OBTG:-20000--
    END IF;
  END IF;--PROCESS_ERROR
  IF(NOT PROCESS_ERROR AND NOT END_PROCESS) THEN
    IF(v_IsProcessed='Y') THEN
      RAISE EXCEPTION '%', '@AlreadyPosted@' ; --OBTG:-20000--
    END IF;
  END IF;--PROCESS_ERROR
  IF(NOT PROCESS_ERROR AND NOT END_PROCESS AND NOT END_PROCESSING) THEN
    v_ResultStr:='CheckingRestrictions';
    SELECT COUNT(*), MAX(M.line)
    INTO v_Count, v_line
    FROM M_InventoryLine M,
      M_Product P
    WHERE M.M_PRODUCT_ID=P.M_PRODUCT_ID
      AND P.M_ATTRIBUTESET_ID IS NOT NULL
      AND P.M_ATTRIBUTESETINSTANCE_ID IS NULL
      AND COALESCE(M.M_ATTRIBUTESETINSTANCE_ID, '0') = '0'
      AND M.M_Inventory_ID=v_Record_ID;
    IF v_Count<>0 THEN
      RAISE EXCEPTION '%', '@Inline@ '||v_line||' '||'@productWithoutAttributeSet@' ; --OBTG:-20000--
    END IF;
  END IF;--PROCESS_ERROR
  IF(NOT PROCESS_ERROR AND NOT END_PROCESS AND NOT END_PROCESSING) THEN
    -- Check for products in multiple lines
        --Added by PSarobe 13062007
        SELECT MAX(count)
        INTO v_Aux
        FROM (
                 SELECT COUNT(*) as count, il.M_Product_ID, COALESCE(il.M_AttributeSetInstance_ID, '0'), COALESCE(il.M_Product_UOM_ID, '0'), il.M_Locator_ID
                 FROM M_Inventoryline il
                 WHERE il.M_INVENTORY_ID = v_Record_ID
                 GROUP BY il.M_Product_ID, COALESCE(il.M_AttributeSetInstance_ID, '0'), COALESCE(il.M_Product_UOM_ID, '0'), il.M_Locator_ID
                 HAVING COUNT(*)>1) A;
        IF v_Aux <>0 THEN
           FOR Cur_Inventorylines IN (SELECT M_Product_ID, COALESCE(M_AttributeSetInstance_ID, '0') AS Atributte, COALESCE(M_Product_UOM_ID, '0') as ProductUOM, M_Locator_ID
                                                                  FROM M_Inventoryline
                                                                  WHERE M_Inventory_Id=v_Record_ID
                                                                  GROUP BY M_Product_ID, COALESCE(M_AttributeSetInstance_ID, '0'), COALESCE(M_Product_UOM_ID, '0'), M_Locator_ID
                                                                  HAVING COUNT(*)>1) LOOP
                                FOR Cur_Lines IN (SELECT line
                                                                  FROM M_Inventoryline
                                                                  WHERE M_PRODUCT_ID = Cur_Inventorylines.M_Product_ID
                                                                  AND COALESCE(M_AttributeSetInstance_ID, '0') = Cur_Inventorylines.Atributte
                                                                  AND COALESCE(M_Product_UOM_ID, '0') = Cur_Inventorylines.ProductUOM
                                                                  AND M_Locator_ID = Cur_Inventorylines.M_Locator_ID
                                                                  AND M_Inventory_Id=v_Record_ID) LOOP

                                v_Message:=v_Message||Cur_Lines.line||', ';

                                END LOOP;
           RAISE EXCEPTION '%', '@Thelines@'||v_Message||' '||'@sameInventorylines@' ; --OBTG:-20000--
           END LOOP;
        END IF;
  END IF;--PROCESS_ERROR
  IF(NOT PROCESS_ERROR AND NOT END_PROCESS AND NOT END_PROCESSING) THEN
    -- Start Processing ------------------------------------------------------
    -- Check the header belongs to a organization where transactions are posible and ready to use
    SELECT AD_Org.IsReady, Ad_OrgType.IsTransactionsAllowed
    INTO v_is_ready, v_is_tr_allow
    FROM M_INVENTORY, AD_Org, AD_OrgType
    WHERE AD_Org.AD_Org_ID=M_INVENTORY.AD_Org_ID
    AND AD_Org.AD_OrgType_ID=AD_OrgType.AD_OrgType_ID
    AND M_INVENTORY.M_INVENTORY_ID=v_Record_ID;
    IF (v_is_ready='N') THEN
      RAISE EXCEPTION '%', '@OrgHeaderNotReady@'; --OBTG:-20000--
    END IF;
    IF (v_is_tr_allow='N') THEN
      RAISE EXCEPTION '%', '@OrgHeaderNotTransAllowed@'; --OBTG:-20000--
    END IF;
    
    SELECT AD_ORG_CHK_DOCUMENTS('M_INVENTORY', 'M_INVENTORYLINE', v_Record_ID, 'M_INVENTORY_ID', 'M_INVENTORY_ID') INTO v_is_included FROM dual;
    IF (v_is_included=-1) THEN
      RAISE EXCEPTION '%', '@LinesAndHeaderDifferentLEorBU@'; --OBTG:-20000--
    END IF;
    
    -- Check the period control is opened (only if it is legal entity with accounting)
    -- Gets the BU or LE of the document
    SELECT AD_GET_DOC_LE_BU('M_INVENTORY', v_Record_ID, 'M_INVENTORY_ID', 'LE')
    INTO v_org_bule_id
    FROM DUAL;
    
    SELECT AD_OrgType.IsAcctLegalEntity
    INTO v_isacctle
    FROM AD_OrgType, AD_Org
    WHERE AD_Org.AD_OrgType_ID = AD_OrgType.AD_OrgType_ID
    AND AD_Org.AD_Org_ID=v_org_bule_id;
    
    IF (v_isacctle='Y') THEN
      SELECT C_CHK_OPEN_PERIOD(v_Org_ID, v_InvDate, 'MMI', NULL) 
      INTO v_available_period
      FROM DUAL;
      
      IF (v_available_period<>1) THEN
        RAISE EXCEPTION '%', '@PeriodNotAvailable@'; --OBTG:-20000--
      END IF;
    END IF;
    

    v_ResultStr:='LockingInventory';
    UPDATE M_Inventory  SET Processing='Y'  WHERE M_Inventory_ID=v_Record_ID;
    -- Commented by cromero 19102006 -- COMMIT;
    /**
    * Create Transaction
    */
    DECLARE
      Cur_InvLine RECORD;
      NextNo VARCHAR(32); --OBTG:VARCHAR2--
    BEGIN --FOR COMMIT
      FOR Cur_InvLine IN
        (SELECT *  FROM M_InventoryLine  WHERE M_Inventory_ID=v_Record_ID  ORDER BY Line)
      LOOP
        SELECT * INTO  NextNo FROM AD_Sequence_Next('M_Transaction', v_Client_ID) ;
        INSERT
        INTO M_Transaction
          (
            M_Transaction_ID, AD_Client_ID, AD_Org_ID, IsActive,
            Created, CreatedBy, Updated, UpdatedBy,
            MovementType, M_Locator_ID, M_Product_ID, M_AttributeSetInstance_ID,
            MovementDate, MovementQty, M_InventoryLine_ID, M_Product_UOM_ID,
            QuantityOrder, C_UOM_ID
          )
          VALUES
          (
            NextNo, Cur_InvLine.AD_Client_ID, Cur_InvLine.AD_Org_ID, 'Y',
            TO_DATE(NOW()), '0', TO_DATE(NOW()), '0',
            'I+', Cur_InvLine.M_Locator_ID, Cur_InvLine.M_Product_ID, COALESCE(Cur_InvLine.M_AttributeSetInstance_ID, '0'),
            v_InvDate, Cur_InvLine.QtyCount-COALESCE(Cur_InvLine.QtyBook, 0), Cur_InvLine.M_InventoryLine_ID, Cur_InvLine.M_Product_UOM_ID,
            Cur_InvLine.QuantityOrder-COALESCE(Cur_InvLine.QuantityOrderBook, 0), Cur_InvLine.C_UOM_ID
          )
          ;
        SELECT * INTO  v_Result, v_Message FROM M_Check_Stock(Cur_InvLine.M_Product_ID, v_Client_ID, v_Org_ID) ;
        IF v_Result=0 THEN
          RAISE EXCEPTION '%', v_Message||' '||'@line@'||' '||Cur_InvLine.line ; --OBTG:-20000--
        END IF;
      END LOOP;
    END; --FOR COMMIT
  END IF;--PROCESS_ERROR
  IF(NOT PROCESS_ERROR AND NOT END_PROCESS AND NOT END_PROCESSING) THEN
    v_Result:=1; -- success
  END IF;--PROCESS_ERROR
  -- End Processing --------------------------------------------------------
  ---- <<END_PROCESSING>>
  IF(NOT PROCESS_ERROR AND NOT END_PROCESS) THEN
    v_ResultStr:='UnLockingInventory';
    UPDATE M_Inventory  SET Processed='Y'  WHERE M_Inventory_ID=v_Record_ID;
    -- Commented by cromero 19102006 -- COMMIT;
  END IF;--
  -- Do Update the Material Plan with new Stock qty's
  PERFORM mrp_inoutplanupdate(null);
  ---- <<END_PROCESS>>
  IF(NOT PROCESS_ERROR) THEN
    v_ResultStr:='UnLockingInventory';
    UPDATE M_Inventory
      SET Processing='N',
      Updated=TO_DATE(NOW()),
      UpdatedBy=v_User
    WHERE M_Inventory_ID=v_Record_ID;
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished' ;
    RAISE NOTICE '%',v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, v_User, 'N', v_Result, v_Message) ;
    RETURN;
  END IF;--PROCESS_ERROR
  ---- <<PROCESS_ERROR>>
  --To be deprecated because now we always use raise_aplication_error. Added by Psarobe 13062007
  v_ResultStr:='UnLockingInventory';
  UPDATE M_Inventory
    SET Processing='N',
    Updated=TO_DATE(NOW()),
    UpdatedBy=v_User
  WHERE M_Inventory_ID=v_Record_ID;
  -- Commented by cromero 19102006 -- COMMIT;
  RAISE NOTICE '%','Updating PInstance - Finished' ;
  RAISE NOTICE '%',v_Message ;
  PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, v_User, 'N', v_Result, v_Message) ;
  RETURN;
  --until here to be deprecated
END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr ;
  --To be fixed or deprecated
  RAISE NOTICE '%',v_Message ;
  --
  -- ROLLBACK;
  --
  UPDATE M_Inventory
    SET Processed='N',
    Processing='N'
  WHERE M_Inventory_ID=v_Record_ID;
  PERFORM AD_UPDATE_PINSTANCE(PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
  RETURN;
END ; $_$;






-- Function: m_bom_qty_onhand(character varying, character varying, character varying)

-- DROP FUNCTION m_bom_qty_onhand(character varying, character varying, character varying);

CREATE OR REPLACE FUNCTION m_bom_qty_onhand(p_product_id character varying, p_warehouse_id character varying, p_locator_id character varying)
  RETURNS numeric AS
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
 Contributions: If There are Production-Reservations
                The reserved quantity must not be available
                Extended Set-Products
******************************************************************************************************************************/
/*
*************************************************************************
* Return quantity on hand for BOM
*/
    v_myWarehouse_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_Quantity NUMERIC:=99999; -- unlimited
    v_IsBOM CHAR(1) ;
    v_IsSet CHAR(1) ;
    v_IsStocked CHAR(1) ;
    v_ProductType VARCHAR(60) ;
    v_ProductQty NUMERIC;
    -- Get BOM Product info
  --TYPE RECORD IS REFCURSOR;
    CUR_BOM RECORD;
    --
  BEGIN
    -- Check Parameters
    v_myWarehouse_ID:=p_Warehouse_ID;
    IF(v_myWarehouse_ID IS NULL and p_locator_id is null) THEN
        RETURN 0;
    END IF;
     -- Get product 
    SELECT IsBOM, ProductType, IsStocked,issetitem
    INTO v_IsBOM, v_ProductType, v_IsStocked,v_IsSet
    FROM M_PRODUCT
    WHERE M_Product_ID=p_Product_ID;
    -- Unlimited capacity if no item
    IF v_ProductType<>'I' OR (v_IsStocked='N' and v_IsSet='N') THEN
      RETURN v_Quantity;
    END IF;
    -- Get qty
    If v_IsSet='Y' then
          -- Calculate Aval. for Set-Items
          for CUR_BOM in (select * from m_product_bom where m_product_id=p_Product_ID)
          LOOP
             v_ProductQty:=m_bom_qty_onhand(CUR_BOM.m_productbom_id,p_warehouse_id,p_locator_id)/CUR_BOM.bomqty;
             if v_ProductQty<v_Quantity then
                v_Quantity:=TRUNC(v_ProductQty);
             end if;
          END LOOP;
          RETURN coalesce(v_Quantity,0);
  
    else
          IF(p_locator_id IS NULL) THEN
            SELECT COALESCE(SUM(QtyOnHand), 0)
                INTO v_ProductQty
                FROM M_STORAGE_DETAIL s where m_locator_id in (select m_locator_id from m_locator where m_warehouse_ID=p_warehouse_ID) and m_product_id=p_product_id;
            RETURN coalesce(v_ProductQty,0);
          else
            SELECT COALESCE(SUM(QtyOnHand), 0)
                INTO v_ProductQty
                FROM M_STORAGE_DETAIL s where m_locator_id = p_locator_id and m_product_id=p_product_id;
            RETURN coalesce(v_ProductQty,0);
          END IF;
    end if;
  RETURN 0;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION m_bom_qty_onhand(character varying, character varying, character varying) OWNER TO tad;




-- Wareneingang annulieren wäre schön:
-- Trigger geändert...

CREATE OR REPLACE FUNCTION m_ioline_chk_restrictions_trg()
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
 Contributions:It schould be possible to undo a material Receipt,When receipt is not posted
******************************************************************************************************************************/
  v_Processed VARCHAR(60) ;
  v_M_INOUT_ID VARCHAR(32) ; 
    
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;


  IF TG_OP = 'INSERT' THEN
    v_M_INOUT_ID:=new.M_INOUT_ID;
  ELSE
    v_M_INOUT_ID:=old.M_INOUT_ID;
  END IF;
  
  SELECT processed  INTO v_Processed FROM M_INOUT WHERE M_INOUT_ID=v_M_INOUT_ID;
  IF TG_OP = 'UPDATE' THEN
    IF(v_Processed='Y' AND ((COALESCE(old.LINE, 0) <> COALESCE(new.LINE, 0))
   OR (COALESCE(old.M_PRODUCT_ID, '0') <> COALESCE(new.M_PRODUCT_ID, '0'))
   OR(COALESCE(old.QUANTITYORDER, 0) <> COALESCE(new.QUANTITYORDER, 0))
   OR(COALESCE(old.M_ATTRIBUTESETINSTANCE_ID, '0') <> COALESCE(new.M_ATTRIBUTESETINSTANCE_ID, '0'))
   OR(COALESCE(old.MOVEMENTQTY, 0) <> COALESCE(new.MOVEMENTQTY, 0))
   OR(COALESCE(old.M_PRODUCT_UOM_ID, '0') <> COALESCE(new.M_PRODUCT_UOM_ID, '0'))
   OR(COALESCE(old.C_ORDERLINE_ID, '0') <> COALESCE(new.C_ORDERLINE_ID, '0'))
   OR(COALESCE(old.M_LOCATOR_ID, '0') <> COALESCE(new.M_LOCATOR_ID, '0'))
   OR(COALESCE(old.AD_ORG_ID, '0') <> COALESCE(new.AD_ORG_ID, '0'))
   OR(COALESCE(old.AD_CLIENT_ID, '0') <> COALESCE(new.AD_CLIENT_ID, '0'))))
  THEN
      RAISE EXCEPTION '%', 'Document processed/posted' ; --OBTG:-20501--
    END IF;
  END IF;
  IF((TG_OP = 'DELETE' OR TG_OP = 'INSERT') AND v_Processed='Y') THEN
    RAISE EXCEPTION '%', 'Document processed/posted' ; --OBTG:-20501--
  END IF;
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 

END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION m_ioline_chk_restrictions_trg() OWNER TO tad;




select zsse_DropView ('zssi_onhanqty');
CREATE  VIEW zssi_onhanqty AS 
SELECT a.m_product_id,
       a.m_warehouse_id,
       a.m_locator_id,
       a.m_attributesetinstance_id,
       a.c_uom_id,
       sum(a.qtyonhand) as qtyonhand,
       sum(a.qtyreserved) as qtyreserved,
       sum(a.qtyincomming) as qtyincomming,
       sum(a.qtyordered) as qtyordered,
       sum(a.qtyinsale) as qtyinsale,
       sum(a.qtyincomming)+sum(a.qtyordered) as qtyinflow,
       sum(a.qtyreserved)+sum(a.qtyinsale) as qtyoutflow,
       a.m_product_id||coalesce(a.m_attributesetinstance_id,'')||coalesce(a.m_locator_id,'')||coalesce(a.m_warehouse_id,'') as zssi_onhanqty_id,
       a.ad_client_id,
       (select ad_org_id from m_warehouse where m_warehouse_ID=a.m_warehouse_id) as ad_org_id,
       'Y'::text as isactive,
       now() as created,
       now() as updated,
       '0'::text as createdby,
       '0'::text as updatedby,
       a.m_product_id||coalesce(a.m_attributesetinstance_id,'')||coalesce(a.m_warehouse_id,'') AS zssi_onhanqty_overview_id,
       b.m_product_category_id
FROM (     
        -- On Hand QTY's
        SELECT sd.m_product_id,
                ml.m_warehouse_id,
                sd.m_locator_id,
                case when sd.m_attributesetinstance_id = '0' then null else sd.m_attributesetinstance_id end as m_attributesetinstance_id,
                sd.c_uom_id,
                sd.qtyonhand,
                0::numeric AS  qtyreserved,
                0::numeric AS  qtyincomming,
                0::numeric AS qtyordered,
                0::numeric AS qtyinsale,
                sd.ad_client_id,
                sd.m_storage_detail_id AS zssi_onhanqty_id
        FROM m_storage_detail sd, m_locator ml
        WHERE ml.m_locator_id = sd.m_locator_id
UNION 
        -- Orders
        SELECT m_storage_pending.m_product_id,
                m_storage_pending.m_warehouse_id,
                NULL::text AS m_locator_id,
                case when m_storage_pending.m_attributesetinstance_id = '0' then null else m_storage_pending.m_attributesetinstance_id end as m_attributesetinstance_id,
                m_storage_pending.c_uom_id,
                0::numeric AS qtyonhand,
                0::numeric AS qtyreserved,
                0::numeric AS qtyincomming,
                case when m_storage_pending.qtyordered>0 then m_storage_pending.qtyordered else 0 end as qtyordered,
                case when m_storage_pending.qtyreserved>0 then m_storage_pending.qtyreserved else 0 end as qtyinsale,
                m_storage_pending.ad_client_id,
                m_storage_pending.m_storage_pending_id AS zssi_onhanqty_id
        FROM m_storage_pending
UNION
        -- In Production
        -- Planned Production
        -- Production-Projects or Production Orders, Must be started, Task not cancelled and not complete, Order have assembly, Production Project has different locator 
        SELECT  pt.m_product_id,
                (select m_warehouse_id from m_locator where m_locator_id= case when p.projectcategory='PRO' then pt.issuing_locator else (select m_locator_id from m_product where m_product_id=pt.m_product_id)  end ) as m_warehouse_id,
                case when p.projectcategory='PRO' then pt.issuing_locator else (select m_locator_id from m_product where m_product_id=pt.m_product_id)  end as m_locator_id,
                null  as m_attributesetinstance_id,
                pr.c_uom_id,
                0::numeric AS qtyonhand,
                0::numeric as qtyreserved,
                pt.qty-pt.qtyproduced as qtyincomming,
                0::numeric AS qtyordered,
                0::numeric AS qtyinsale,
                p.ad_client_id,
                pt.c_projecttask_id AS zssi_onhanqty_id
        FROM c_project p,c_projecttask pt, m_product pr
        WHERE p.c_project_id=pt.c_project_id and pt.m_product_id=pr.m_product_id 
              and p.projectcategory in ('P','PRO') 
              and p.projectstatus='OR' 
              and pt.iscomplete='N' and pt.istaskcancelled='N' 
              and case when p.projectcategory='PRO' then pt.assembly='Y' and pt.issuing_locator is not null else 1=1 end
              and (pt.qty-pt.qtyproduced)>0
              and pr.producttype='I' and pr.isstocked='Y'
UNION
        -- Planned Internal Consumption
        SELECT  bom.m_product_id,
                (select m_warehouse_id from m_locator where m_locator_id= case when p.projectcategory='PRO' then bom.receiving_locator else bom.m_locator_id end) as m_warehouse_id,
                case when p.projectcategory='PRO' then bom.receiving_locator else bom.m_locator_id end as m_locator_id,
                null  as m_attributesetinstance_id,
                pr.c_uom_id,
                0::numeric as qtyonhand,
                bom.quantity-bom.qtyreceived as qtyreserved,
                0::numeric as qtyincomming,
                0::numeric AS qtyordered,
                0::numeric AS qtyinsale,
                p.ad_client_id,
                bom.c_projecttask_id AS zssi_onhanqty_id
        FROM c_project p,c_projecttask pt,zspm_projecttaskbom bom, m_product pr
        WHERE p.c_project_id=pt.c_project_id and pt.c_projecttask_id=bom.c_projecttask_id and bom.m_product_id=pr.m_product_id 
              and p.projectcategory in ('P','PRO','S','M') and p.projectstatus='OR' 
              and pt.iscomplete='N' and pt.istaskcancelled='N'  
              and case when p.projectcategory='PRO' then pt.assembly='Y' and bom.receiving_locator is not null else bom.m_locator_id is not null end
              and pr.producttype='I' and pr.isstocked='Y'
              and (bom.quantity-bom.qtyreceived)>0) A,
 m_product b
WHERE  a.m_product_id=b.m_product_id
       and b.isstocked='Y' and b.producttype='I'
GROUP BY 
       a.m_product_id,
       a.m_warehouse_id,
       a.m_locator_id,
       a.m_attributesetinstance_id,
       a.c_uom_id,
       a.ad_client_id,
       ad_org_id,
       b.m_product_category_id;


select zsse_DropView ('zssi_onhanqty_overview');
CREATE  VIEW zssi_onhanqty_overview AS 
        SELECT m_product_id,
                m_warehouse_id,
                m_attributesetinstance_id,
                c_uom_id,
                m_product_category_id,
                sum(qtyonhand)as qtyonhand,
                sum(qtyreserved) as qtyreserved,
                sum(qtyincomming)as qtyincomming,
                sum(qtyordered) AS qtyordered,
                sum(qtyinsale) AS qtyinsale,
                sum(qtyinflow) as qtyinflow,
                sum(qtyoutflow) as qtyoutflow,
                ad_client_id,
                ad_org_id,
                isactive,
                now() as created,
                now() as updated,
                max(createdby) as createdby,
                max(updatedby) as updatedby,
                m_product_id||coalesce(m_attributesetinstance_id,'')||m_warehouse_id AS zssi_onhanqty_overview_id
        FROM zssi_onhanqty 
group by m_product_id,m_product_category_id,
                m_warehouse_id,
                m_attributesetinstance_id,
                c_uom_id,
                ad_client_id,
                ad_org_id, 
                isactive;

CREATE OR REPLACE FUNCTION M_BOM_Qty_Incomming(p_product_id character varying, p_warehouse_id character varying, p_locator_id character varying)
  RETURNS numeric AS
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
    --
    v_ProductQty numeric:=0;
  BEGIN
    IF(p_locator_id IS NULL and p_warehouse_id is not null) THEN
            SELECT SUM(qtyinflow)
                INTO v_ProductQty
                FROM zssi_onhanqty where m_warehouse_id=p_warehouse_id and m_product_id=p_product_id;
            RETURN coalesce(v_ProductQty,0);
    end if;
    -- This may be only Production (has locator)
    if (p_locator_id IS not NULL) then 
            SELECT SUM(qtyinflow)
                INTO v_ProductQty
                FROM zssi_onhanqty where m_locator_id=p_locator_id and m_product_id=p_product_id;
            RETURN coalesce(v_ProductQty,0);
    END IF;
  RETURN 0;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION M_BOM_Qty_Outgoing(p_product_id character varying, p_warehouse_id character varying, p_locator_id character varying)
  RETURNS numeric AS
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
    --
    v_ProductQty numeric:=0;
  BEGIN
    IF(p_locator_id IS NULL and p_warehouse_id is not null) THEN
            SELECT SUM(qtyoutflow)
                INTO v_ProductQty
                FROM zssi_onhanqty where m_warehouse_id=p_warehouse_id and m_product_id=p_product_id;
            RETURN coalesce(v_ProductQty,0);
    end if;
    -- This may be only Production (has locator)
    if (p_locator_id IS not NULL) then 
            SELECT SUM(qtyoutflow)
                INTO v_ProductQty
                FROM zssi_onhanqty where m_locator_id=p_locator_id and m_product_id=p_product_id;
            RETURN coalesce(v_ProductQty,0);
    END IF;
  RETURN 0;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100; 
  
CREATE OR REPLACE FUNCTION M_BOM_Qty_Available(p_product_id character varying, p_warehouse_id character varying, p_locator_id character varying)
  RETURNS numeric AS
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
    --
    v_ProductQty numeric:=0;
  BEGIN
    IF(p_locator_id IS NULL and p_warehouse_id is not null) THEN
            SELECT SUM(qtyonhand)-SUM(qtyoutflow)
                INTO v_ProductQty
                FROM zssi_onhanqty where m_warehouse_id=p_warehouse_id and m_product_id=p_product_id;
            RETURN coalesce(v_ProductQty,0);
    end if;
    -- This may be only Production (has locator)
    if (p_locator_id IS not NULL) then 
            SELECT SUM(qtyonhand)-SUM(qtyoutflow)
                INTO v_ProductQty
                FROM zssi_onhanqty where m_locator_id=p_locator_id and m_product_id=p_product_id;
            RETURN coalesce(v_ProductQty,0);
    END IF;
  RETURN 0;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100; 

  
  
  
select zsse_dropview('zssi_qtyoverview');
CREATE OR REPLACE VIEW zssi_qtyoverview AS 
SELECT 
        ol.c_orderline_id AS zssi_qtyoverview_id, 
        ol.ad_client_id, 
        ol.ad_org_id, 
        ol.isactive, 
        ol.created, 
        ol.createdby, 
        ol.updated, 
        ol.updatedby, 
        ol.c_order_id, 
        ol.line, 
        ol.m_product_id, 
        ol.description, 
        ol.c_uom_id, 
        ol.qtyordered AS qtyorderordered, 
        ol.qtydelivered, ol.qtyreserved AS qtytodeliver, 
        ol.qtyinvoiced, 
        m_bom_qty_onhand(ol.M_Product_ID,o.m_warehouse_id, NULL) as qtyonhand, 
        M_BOM_Qty_Available(ol.M_Product_ID,o.m_warehouse_id, NULL) AS qtyavailable, 
        M_BOM_Qty_Incomming(ol.M_Product_ID,o.m_warehouse_id, NULL)  AS qtyorderedvendor
FROM 
        c_order o, 
        c_orderline ol
WHERE 
        ol.c_order_id = o.c_order_id;

  
  
  
CREATE or replace FUNCTION zssi_get_nextdeliverydate(p_productid character varying,p_orgid character varying,p_warehouseid character varying) RETURNS timestamp without time zone
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

*****************************************************/
DECLARE
-- Simple Types
v_return  timestamp without time zone;
BEGIN
  select c_orderline.datepromised into v_return from c_orderline,c_order where c_order.c_order_id=c_orderline.c_order_id and c_order.issotrx='N' and c_order.m_warehouse_ID=p_warehouseid
         and c_order.processed='Y' and c_order.docstatus='CO' and c_order.ad_org_id=p_orgid and c_orderline.m_product_id=p_productid order by c_orderline.datepromised limit 1;
  return v_return;
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;

CREATE or replace FUNCTION zssi_get_nextdeliveryqty(p_productid character varying,p_orgid character varying,p_warehouseid character varying) RETURNS numeric
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

*****************************************************/
DECLARE
-- Simple Types
v_return numeric;
BEGIN
  select c_orderline.qtyordered into v_return from c_orderline,c_order where c_order.c_order_id=c_orderline.c_order_id and c_order.issotrx='N' and c_order.m_warehouse_ID=p_warehouseid
         and c_order.processed='Y' and c_order.docstatus='CO' and c_order.ad_org_id=p_orgid and c_orderline.m_product_id=p_productid order by c_orderline.datepromised limit 1;
  return v_return;
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;


CREATE OR REPLACE FUNCTION m_get_pareto_abc(p_warehouse_id character varying, p_org_id character varying, p_client_id character varying, p_percentageactual numeric)
  RETURNS character varying AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Danny A. Heuduk., 02/2012, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************/

  v_orgList VARCHAR(4000) ; --OBTG:VARCHAR2--
  VARaCUM NUMERIC:=0;
  VARaCUMB NUMERIC:=0;
  v_limitA NUMERIC:=80;
  v_limitB NUMERIC:=15;
  varComprobadoA NUMERIC:=0;
  varComprobadoB NUMERIC:=0;
  --TYPE RECORD IS REFCURSOR;
  Cur_Cursor RECORD;
BEGIN
  varAcum :=0;
  varComprobadoA := 0;
  for Cur_Cursor in (
   SELECT
  100*SUM(msd.qtyonhand*M_GET_PRODUCT_COST(MSD.M_PRODUCT_ID,TO_DATE(TO_DATE(NOW())),'AV', p_org_id))/ (select SUM(msd1.qtyonhand*M_GET_PRODUCT_COST(MSD1.M_PRODUCT_ID,TO_DATE(TO_DATE(NOW())),'AV', p_org_id))
                                                       from M_WAREHOUSE MW1
                                                       LEFT JOIN M_LOCATOR ML1 ON ML1.M_WAREHOUSE_ID=MW1.M_WAREHOUSE_ID
                                                       LEFT JOIN M_STORAGE_DETAIL MSD1 ON ML1.M_LOCATOR_ID=MSD1.M_LOCATOR_ID
                                                       WHERE (p_warehouse_ID IS NULL OR MW1.M_WAREHOUSE_ID=p_warehouse_ID)
                                                       AND (p_org_ID IS NULL OR MW1.AD_ORG_ID=p_org_ID)
                                                       AND (p_client_id IS NULL OR MW1.AD_CLIENT_ID=p_client_id) 
                                                       AND MSD1.QTYONHAND>0) as PERCENTAGE
  FROM
   M_WAREHOUSE MW
     LEFT JOIN M_LOCATOR ML ON ML.M_WAREHOUSE_ID=MW.M_WAREHOUSE_ID
     LEFT JOIN M_STORAGE_DETAIL MSD ON ML.M_LOCATOR_ID=MSD.M_LOCATOR_ID
  WHERE (p_warehouse_ID IS NULL OR MW.M_WAREHOUSE_ID=p_warehouse_ID)
     AND (p_org_ID IS NULL OR MW.AD_ORG_ID=p_org_ID)
     AND (p_client_id IS NULL OR MW.AD_CLIENT_ID=p_client_id)
     AND MSD.QTYONHAND>0
     AND M_GET_PRODUCT_COST(MSD.M_PRODUCT_ID,TO_DATE(TO_DATE(NOW())),null, p_org_id) IS NOT NULL
     AND M_GET_PRODUCT_COST(MSD.M_PRODUCT_ID,TO_DATE(TO_DATE(NOW())),null, p_org_id) <> 0
  GROUP BY MSD.M_PRODUCT_ID
  ORDER BY PERCENTAGE DESC) loop
  varAcum := varAcum+Cur_Cursor.percentage;
   if(varComprobadoA=0)then
     if (varAcum>=v_limitA) then
       if (p_percentageactual>=Cur_Cursor.percentage) then
	     return 'A';
       else
         varComprobadoA:=-1;
         varAcumB:=-1*Cur_Cursor.percentage;
       end if;
     end if;
   end if;

  if (varComprobadoA=-1 and varComprobadoB=0) then
  varAcumB:=varAcumB+Cur_Cursor.percentage;
   if (varAcumB>=v_limitB) then
     if (p_percentageactual>=Cur_Cursor.percentage) then return 'B';
	 else varComprobadoB:=-1;
     end if;
   end if;
  end if;

 end loop;
 return 'C';
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION m_get_pareto_abc(character varying, character varying, character varying, numeric) OWNER TO tad;




CREATE OR REPLACE FUNCTION m_matchpo_trg() RETURNS trigger
    LANGUAGE plpgsql
    AS $_$ DECLARE 





  v_QtyOrdered NUMERIC;
  v_QtyOrderOrdered NUMERIC;
  v_Product_UOM     VARCHAR(32); --OBTG:VARCHAR2--
  v_UOM             VARCHAR(32); --OBTG:VARCHAR2--
  v_Attribute       VARCHAR(32); --OBTG:VARCHAR2--
  v_Warehouse       VARCHAR(32); --OBTG:VARCHAR2--
  V_STOCKED         NUMERIC;
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
****************************************************************************************************************************************************/
    
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;


  IF(TG_OP = 'UPDATE' OR TG_OP = 'DELETE') THEN
    IF OLD.M_INOUTLINE_ID IS NOT NULL THEN
      v_QtyOrdered:=old.qty;
      SELECT o.C_UOM_ID,
        o.M_ATTRIBUTESETINSTANCE_ID,
        o.M_PRODUCT_UOM_ID,
        o.M_WAREHOUSE_ID
      INTO v_UOM,
        v_Attribute,
        v_Product_UOM,
        v_Warehouse
      FROM C_ORDERLINE o
      WHERE o.C_ORDERLINE_ID=old.C_ORDERLINE_ID;
      SELECT l.QUANTITYORDER
      INTO v_QtyOrderOrdered
      FROM M_INOUTLINE l
      WHERE l.M_INOUTLINE_ID=old.M_INOUTLINE_ID;
    END IF;
  END IF;
  IF(TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
    IF NEW.M_INOUTLINE_ID IS NOT NULL THEN
      v_QtyOrdered:=-new.qty;
      SELECT o.C_UOM_ID,
        o.M_ATTRIBUTESETINSTANCE_ID,
        o.M_PRODUCT_UOM_ID,
        o.M_WAREHOUSE_ID
      INTO v_UOM,
        v_Attribute,
        v_Product_UOM,
        v_Warehouse
      FROM C_ORDERLINE o
      WHERE o.C_ORDERLINE_ID=new.C_ORDERLINE_ID;
      SELECT -l.QUANTITYORDER
      INTO v_QtyOrderOrdered
      FROM M_INOUTLINE l
      WHERE l.M_INOUTLINE_ID=new.M_INOUTLINE_ID;
    END IF;
  END IF;
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END ; $_$;


CREATE OR REPLACE FUNCTION m_update_pareto_product(p_pinstance_id character varying, p_warehouse_id character varying, p_org_id character varying, p_client_id character varying) RETURNS void
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
****************************************************************************************************************************************************/

  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Result NUMERIC:= 1;
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_exist NUMERIC:=0;
  v_M_Product_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_warehouse_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_org_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_client_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_count_update NUMERIC:= 0;
  v_count_insert NUMERIC:= 0;
  --TYPE RECORD IS REFCURSOR;
  Cur_Cursor RECORD;
  Cur_Parameter RECORD;
  v_AD_Client_ID VARCHAR(32); --OBTG:VARCHAR2--
BEGIN

  IF(p_PInstance_ID IS NOT NULL) THEN
      --  Update AD_PInstance
      RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
      v_ResultStr:='PInstanceNotFound';
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
      -- Get Parameters
      v_ResultStr:='ReadingParameters';
      FOR Cur_Parameter IN (SELECT i.Record_ID, i.AD_User_ID, p.ParameterName, p.P_String, p.P_Number, p.P_Date, i.UpdatedBy
                            FROM AD_PINSTANCE i LEFT JOIN AD_PINSTANCE_PARA p ON i.AD_PInstance_ID=p.AD_PInstance_ID
                            WHERE i.AD_PInstance_ID=p_PInstance_ID
                            ORDER BY p.SeqNo) LOOP
        IF (Cur_Parameter.ParameterName = 'm_warehouse_id') THEN
          v_warehouse_ID := Cur_Parameter.P_String;
          RAISE NOTICE '%','  m_warehouse_id=' || v_warehouse_ID ;
        ELSIF (Cur_Parameter.ParameterName = 'ad_org_id') THEN
          v_org_ID := Cur_Parameter.P_String;
          RAISE NOTICE '%','  ad_org_id=' || v_org_ID ;
        ELSIF (Cur_Parameter.ParameterName = 'ad_client_id') THEN
          v_client_ID := Cur_Parameter.P_String;
          RAISE NOTICE '%','  ad_client_id=' || v_client_ID ;
        END IF;
      END LOOP; --Get Parameter

    ELSE
      RAISE NOTICE '%','--<<M_UPDATE_PARETO_PRODUCT>>' ;
      v_warehouse_ID:=p_warehouse_ID;
      v_org_ID:=p_org_ID;
      v_client_ID := p_client_id;
    END IF;
    BEGIN --BODY

  for Cur_Cursor in (
     SELECT M_GET_PARETO_ABC(v_warehouse_ID, AD_ORG_ID, v_client_ID, PERCENTAGE) AS ISABC,
     AD_ORG_ID, AD_CLIENT_ID, M_PRODUCT_ID
     FROM
     (
     SELECT
      100*SUM(MSD.QTYONHAND)*(M_GET_PRODUCT_COST(MSD.M_PRODUCT_ID,TO_DATE(TO_DATE(NOW())),'AV',MW.ad_org_id)/ (SELECT SUM(msd1.qtyonhand*M_GET_PRODUCT_COST(MSD1.M_PRODUCT_ID,TO_DATE(TO_DATE(NOW())),'AV',MW1.ad_org_id))
                                                           from M_WAREHOUSE MW1
                                                           LEFT JOIN M_LOCATOR ML1 ON ML1.M_WAREHOUSE_ID=MW1.M_WAREHOUSE_ID
                                                           LEFT JOIN M_STORAGE_DETAIL MSD1 ON ML1.M_LOCATOR_ID=MSD1.M_LOCATOR_ID
                                                           WHERE MSD1.QTYONHAND>0
                                                           AND (v_warehouse_ID IS NULL OR MW1.M_WAREHOUSE_ID = v_warehouse_ID)
                                                           AND (v_org_ID IS NULL OR MW1.AD_ORG_ID = v_org_ID)
                                                           AND (v_client_ID IS NULL OR MW1.AD_CLIENT_ID = v_client_ID)
                                                           ) ) as PERCENTAGE,
      MW.AD_ORG_ID,
      MW.AD_CLIENT_ID,
      MSD.M_PRODUCT_ID
     FROM
     M_WAREHOUSE MW
       LEFT JOIN M_LOCATOR ML ON ML.M_WAREHOUSE_ID=MW.M_WAREHOUSE_ID
       LEFT JOIN M_STORAGE_DETAIL MSD ON ML.M_LOCATOR_ID=MSD.M_LOCATOR_ID
     WHERE (v_warehouse_ID IS NULL OR MW.M_WAREHOUSE_ID = v_warehouse_ID)
       AND (v_org_ID IS NULL OR MW.AD_ORG_ID = v_org_ID)
       AND (v_client_ID IS NULL OR MW.AD_CLIENT_ID = v_client_ID)
       AND MSD.QTYONHAND>0
       AND M_GET_PRODUCT_COST(MSD.M_PRODUCT_ID,TO_DATE(TO_DATE(NOW())),'AV',mw.ad_org_id) IS NOT NULL
       AND M_GET_PRODUCT_COST(MSD.M_PRODUCT_ID,TO_DATE(TO_DATE(NOW())),'AV',mw.ad_org_id) <> 0
     GROUP BY MW.AD_ORG_ID, MW.AD_CLIENT_ID, MSD.M_PRODUCT_ID
     ) BBB
     ORDER BY PERCENTAGE DESC) loop

     SELECT COUNT(*)
     INTO v_exist
     FROM M_PRODUCT_ORG
     WHERE M_PRODUCT_ID = Cur_Cursor.M_PRODUCT_ID
     AND AD_ORG_ID = Cur_Cursor.AD_ORG_ID;

     IF (v_exist > 0) THEN
       UPDATE M_PRODUCT_ORG SET
       ABC = Cur_Cursor.ISABC
       WHERE M_PRODUCT_ID = Cur_Cursor.M_PRODUCT_ID
       AND AD_ORG_ID = Cur_Cursor.AD_ORG_ID;
       v_count_update := v_count_update + 1;
     ELSE
       SELECT * INTO  v_M_Product_Org_ID FROM AD_Sequence_Next('M_Product_Org', Cur_Cursor.AD_CLIENT_ID) ;
       INSERT INTO M_PRODUCT_ORG (M_PRODUCT_ORG_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_PRODUCT_ID, ABC) VALUES
       (v_M_Product_Org_ID, Cur_Cursor.AD_CLIENT_ID, Cur_Cursor.AD_ORG_ID, 'Y', TO_DATE(NOW()), '100', TO_DATE(NOW()), '100', Cur_Cursor.M_PRODUCT_ID, Cur_Cursor.ISABC);
       v_count_insert := v_count_insert + 1;
     END IF;

  end loop;
  v_Message:='@Created@=' || v_count_insert || ', @Updated@=' || v_count_update;
---- <<FINISH_PROCESS>>
    IF(p_PInstance_ID IS NOT NULL) THEN
      --  Update AD_PInstance
      RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', v_Result, v_Message) ;
    ELSE
      RAISE NOTICE '%','--<<M_UPDATE_PARETO_PRODUCT finished>>' ;
    END IF;
    RETURN;
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
  RETURN;
END ; $_$;


ALTER FUNCTION public.m_update_pareto_product(p_pinstance_id character varying, p_warehouse_id character varying, p_org_id character varying, p_client_id character varying) OWNER TO tad;

--
-- Name: m_update_pareto_product0(character varying); Type: FUNCTION; Schema: public; Owner: tad
--

CREATE OR REPLACE FUNCTION m_update_pareto_product0(pinstance_id character varying) RETURNS void
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
****************************************************************************************************************************************************/
BEGIN
  PERFORM M_UPDATE_PARETO_PRODUCT(PInstance_ID, NULL, NULL, NULL);
END ; $_$;


CREATE OR REPLACE FUNCTION m_inout_chk_restrictions_trg() RETURNS trigger
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
****************************************************************************************************************************************************/
  v_DateNull TIMESTAMP := TO_DATE('01-01-1900', 'DD-MM-YYYY');
  v_n NUMERIC;
     
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;

  -- Check Duplicate Document Numbers
  IF (TG_OP = 'INSERT' or TG_OP = 'UPDATE') THEN
       select count(*) into v_n from m_inout where documentno=new.documentno and c_doctype_id=new.c_doctype_id and m_inout_id!=new.m_inout_id;
       if v_n>0 then
          RAISE EXCEPTION '%', '@DuplicateDocNo@' ;
       end if;
  END IF;
  IF TG_OP = 'UPDATE' THEN
    IF(old.Processed='Y'
    AND ((COALESCE(old.C_BPartner_ID, '0') <> COALESCE(new.C_BPartner_ID, '0'))
    OR(COALESCE(old.DOCUMENTNO, '.') <> COALESCE(new.DOCUMENTNO, '.'))
    OR(COALESCE(old.C_DOCTYPE_ID, '0') <> COALESCE(new.C_DOCTYPE_ID, '0'))
    OR(COALESCE(old.AD_USER_ID, '0') <> COALESCE(new.AD_USER_ID, '0'))
    OR(COALESCE(old.C_ORDER_ID, '0') <> COALESCE(new.C_ORDER_ID, '0'))
    OR(COALESCE(old.DATEORDERED, v_DateNull) <> COALESCE(new.DATEORDERED, v_DateNull))
    OR(COALESCE(old.MOVEMENTDATE, v_DateNull) <> COALESCE(new.MOVEMENTDATE, v_DateNull))
    OR(COALESCE(OLD.C_BPARTNER_LOCATION_ID, '0') <> COALESCE(NEW.C_BPARTNER_LOCATION_ID, '0'))
    OR(COALESCE(old.PICKDATE, v_DateNull) <> COALESCE(new.PICKDATE, v_DateNull))
    OR(COALESCE(old.SHIPDATE, v_DateNull) <> COALESCE(new.SHIPDATE, v_DateNull))
    OR(COALESCE(old.C_CHARGE_ID, '0') <> COALESCE(new.C_CHARGE_ID, '0'))
    OR(COALESCE(old.CHARGEAMT, 0) <> COALESCE(new.CHARGEAMT, 0))
    OR(COALESCE(old.AD_ORGTRX_ID, '0') <> COALESCE(new.AD_ORGTRX_ID, '0'))
    OR(COALESCE(old.USER1_ID, '0') <> COALESCE(new.USER1_ID, '0'))
    OR(COALESCE(old.M_SHIPPER_ID, '0') <> COALESCE(new.M_SHIPPER_ID, '0'))
    OR(COALESCE(old.SALESREP_ID, '0') <> COALESCE(new.SALESREP_ID, '0'))
    OR(COALESCE(old.M_WAREHOUSE_ID, '0') <> COALESCE(new.M_WAREHOUSE_ID, '0'))
    OR(COALESCE(old.USER2_ID, '0') <> COALESCE(new.USER2_ID, '0'))
    OR(COALESCE(old.DELIVERYRULE, '.') <> COALESCE(new.DELIVERYRULE, '.'))
    OR(COALESCE(old.DELIVERYVIARULE, '.') <> COALESCE(new.DELIVERYVIARULE, '.'))
    OR(COALESCE(old.PRIORITYRULE, '.') <> COALESCE(new.PRIORITYRULE, '.'))
    OR(COALESCE(old.AD_ORG_ID, '0') <> COALESCE(new.AD_ORG_ID, '0'))
    OR(COALESCE(old.AD_CLIENT_ID, '0') <> COALESCE(new.AD_CLIENT_ID, '0')))) THEN
      RAISE EXCEPTION '%', 'Document processed/posted' ; --OBTG:-20501--
    END IF;
    IF(old.Posted='Y' AND ((COALESCE(old.DATEACCT, v_DateNull) <> COALESCE(new.DATEACCT, v_DateNull)) OR (COALESCE(old.MOVEMENTDATE, v_DateNull) <> COALESCE(new.MOVEMENTDATE, v_DateNull)) OR(COALESCE(old.C_CAMPAIGN_ID, '0') <> COALESCE(new.C_CAMPAIGN_ID, '0')) OR(COALESCE(old.C_PROJECT_ID, '0') <> COALESCE(new.C_PROJECT_ID, '0')) OR(COALESCE(old.C_ACTIVITY_ID, '0') <> COALESCE(new.C_ACTIVITY_ID, '0')))) THEN
      RAISE EXCEPTION '%', 'Document processed/posted' ; --OBTG:-20501--
    END IF;
  END IF;
  IF(TG_OP = 'DELETE') THEN
    IF(old.Processed='Y') THEN
      RAISE EXCEPTION '%', 'Document processed/posted' ; --OBTG:-20501--
    END IF;
  END IF;
  IF(TG_OP = 'INSERT') THEN
    IF(NEW.Processed='Y') THEN
      RAISE EXCEPTION '%', 'Document processed/posted' ; --OBTG:-20501--
    END IF;
  END IF;
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 

END; $_$;

select zsse_droptrigger('m_internal_consumptionlinechkrestictions_trg','m_internal_consumptionline');




CREATE OR REPLACE FUNCTION m_internal_consumptionlinechkrestictions_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Trigger for Internal-Consumption
Performs Restriction Check
*****************************************************/
v_movementtype character varying;
v_qtyreceived numeric;
v_bomplan numeric;
v_qtyproduced numeric;
v_qtyplan numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF;
  
  IF TG_OP = 'INSERT' OR TG_OP = 'UPDATE' THEN
    
    select movementtype into v_movementtype from M_Internal_Consumption where M_Internal_Consumption_id=new.M_Internal_Consumption_ID;
    if (new.c_projecttask_id is not null and v_movementtype='D+') then
       select sum(qtyreceived),sum(quantity) into v_qtyreceived,v_bomplan from zspm_projecttaskbom where c_projecttask_id=new.c_projecttask_id and m_product_id=new.m_product_id;
       if (v_qtyreceived is null) then v_qtyreceived=0; end if;
       select qty,qtyproduced into v_qtyplan,v_qtyproduced from c_projecttask where c_projecttask_id=new.c_projecttask_id;
       if v_qtyproduced>0 and v_qtyplan>0 then
        v_qtyreceived:=v_qtyreceived-v_bomplan*(v_qtyproduced/v_qtyplan);
       end if;
       if v_qtyreceived<new.movementqty and c_getconfigoption('bringbackmorematerialthanreceived',new.ad_org_id)='N' then
         RAISE EXCEPTION '%', '@zsmf_cannotbringbackmorethanreceived@' ; 
       end if;
    end if;
    RETURN NEW;
  END IF;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE TRIGGER m_internal_consumptionlinechkrestictions_trg
  BEFORE INSERT OR UPDATE
  ON m_internal_consumptionline
  FOR EACH ROW
  EXECUTE PROCEDURE m_internal_consumptionlinechkrestictions_trg();
 
 

CREATE OR REPLACE FUNCTION m_deleteOldOpenMatrerialMovements (p_pinstance_id  VARCHAR) RETURNS VARCHAR
AS $body$
DECLARE
  Cur_Parameter           RECORD;
  v_message               VARCHAR := '';
  v_Record_ID             VARCHAR;
  v_user_id               VARCHAR;
  v_days                  NUMERIC;
  v_time                  TIMESTAMP;
BEGIN
  BEGIN
    IF(p_PInstance_ID IS NOT NULL) THEN
      PERFORM ad_update_pinstance(p_PInstance_ID, NULL, 'Y', NULL, NULL) ; -- 'Y'=processing
      SELECT pi.Record_ID, pi.ad_User_ID
      INTO v_Record_ID, v_user_id
      FROM ad_pinstance pi WHERE pi.ad_PInstance_ID = p_PInstance_ID;
      IF (v_Record_ID IS NULL) then
         RAISE NOTICE '%','Entry for PInstance not found - Using parameter &1=''' || p_PInstance_ID || ''' instead';
         v_Record_ID := p_PInstance_ID;
         v_user_id     := '0';
         v_days:=0;
      ELSE
        -- Get Parameters
        v_message := 'ReadingParameters';
        FOR Cur_Parameter IN
          (SELECT para.parametername, para.p_string
           FROM AD_PInstance pi, AD_PInstance_Para para
           WHERE 1=1
            AND pi.AD_PInstance_ID = para.AD_PInstance_ID
            AND pi.AD_PInstance_ID = p_PInstance_ID
           ORDER BY para.SeqNo
          )
        LOOP
          IF ( UPPER(Cur_Parameter.parametername) = UPPER('DAYS') ) THEN
            v_days := Cur_Parameter.p_number;
          END IF;
        END LOOP; -- Get Parameter
      END IF;
    END IF;
    if v_days>0 then
        v_time:=now()-v_days;
    else
        v_time:=now();
    end if;
    delete from m_internal_consumptionline l where exists (select 0 from m_internal_consumption c where c.m_internal_consumption_id=l.m_internal_consumption_id and c.processed='N' and c.created < v_time);
    delete from m_internal_consumption c where c.processed='N' and c.created <  v_time;
    delete from m_inoutline l where exists (select 0 from m_inout c where c.m_inout_id=l.m_inout_id and c.docstatus='DR' and c.created < v_time);
    delete from m_inout c where c.docstatus='DR' and c.created <  v_time;
    
    PERFORM ad_update_pinstance(p_PInstance_ID, NULL, 'N', 1, v_Message) ; -- NULL=p_ad_user_id, 'N'=isProcessing, 1=success
    RAISE NOTICE '%','Updating PInstance - finished ';
    v_message:='SUCCESS';
    RETURN v_message;

  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_message := '@ERROR=' || SQLERRM;
  RAISE NOTICE '% %', 'SQL-PROC m_deleteOldOpenMatrerialMovements: ', v_message;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message);
  RETURN v_message;
END;
$body$
LANGUAGE 'plpgsql'
COST 100;

select zsse_droptrigger('m_product_org_trg','m_product_org');

CREATE OR REPLACE FUNCTION m_product_org_trg() RETURNS trigger
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************

Gets predefined Textmodules into Shipments

*****************************************************/

    v_count numeric;
    v_orgfrom character varying;
    v_cur RECORD; 
BEGIN
    
 
 IF(TG_OP = 'INSERT' or TG_OP = 'UPDATE') then
     select count(*) into v_count from  m_product_org where ad_org_id=new.ad_org_id and isvendorreceiptlocator='Y' and m_product_org_id!=new.m_product_org_id
                                                            and m_product_id=new.m_product_id and m_locator_id in 
                                                            (select m_locator_id from m_locator where m_warehouse_id=
                                                                   (select m_warehouse_id from m_locator where m_locator_id=new.m_locator_id));
     if new.isvendorreceiptlocator='Y' then
        if v_count>0 then 
            raise exception '%', '@onlyonevendorlocator@';
        end if;
     else
        if v_count=0 then 
            raise exception '%', '@needonevendorlocator@';
        end if;
     end if;
  end if; --Inserting 
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END ; $_$;




CREATE TRIGGER m_product_org_trg
  BEFORE INSERT OR UPDATE
  ON m_product_org
  FOR EACH ROW
  EXECUTE PROCEDURE m_product_org_trg();


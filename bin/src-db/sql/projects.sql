/* ..\OpenSourceTrunc\src-db\sql\projects.sql */


CREATE OR REPLACE FUNCTION zssi_getNewProjectValue(p_org character varying)
  RETURNS character varying AS
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

Ohne hochdrehen der Sequenz - Default Wert auf der Oberfläche

*****************************************************/
v_return               character varying:='';
BEGIN
  if c_getconfigoption('autoprojectvaluesequence', p_org)='Y' then
     select Ad_Sequence_Doc('Project Value', p_org, 'N') into v_return;
  end if;
  RETURN v_return;
END;
$BODY$ LANGUAGE 'plpgsql' VOLATILE  COST 100;
  
  
  
CREATE OR REPLACE FUNCTION c_project_value_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2013 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

Hochdrehen der Sequenz -Erst bei echtem Abspeichen

*****************************************************/
v_isincremented BOOLEAN:=false;
BEGIN
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF; 
    -- Find a free Project Value if Option Configured and a double value was entered
    IF (TG_OP = 'INSERT' or TG_OP = 'UPDATE') THEN
        IF c_getconfigoption('autoprojectvaluesequence',new.ad_org_id)='Y' and new.ProjectCategory not in ('PRP','PRO') then
            IF (TG_OP = 'INSERT' ) THEN
                select p_documentno into new.value from ad_sequence_doc('Project Value',new.ad_org_id,'N');
            END IF;
            WHILE (select count(*) from c_project where value=new.value and c_project_id!=new.c_project_id)>0 
            LOOP
                select p_documentno into new.value from ad_sequence_doc('Project Value',new.ad_org_id,'Y');
                v_isincremented:=true;
            END LOOP;
            IF (TG_OP = 'INSERT' and v_isincremented=false) THEN
                perform ad_sequence_doc('Project Value',new.ad_org_id,'Y');
            END IF;
        end if;
   END IF;
RETURN NEW;
END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
 
select zsse_droptrigger('c_project_value_trg','c_project');

CREATE TRIGGER c_project_value_trg
  BEFORE INSERT OR UPDATE 
  ON c_project
  FOR EACH ROW
  EXECUTE PROCEDURE c_project_value_trg();





-- Moved MRP View to here to avoid cross script dependencies
select zsse_DropView ('mrp_deliveries_expected');
create view mrp_deliveries_expected as
select mrp_deliveries_expected_id,created,createdby,updated,updatedby,isactive,ad_client_id,ad_org_id,
       c_order_id,line,dateordered,datepromised,datedelivered,m_product_id,qtyordered,qtydelivered,
       c_project_id,c_projectphase_id,c_projecttask_id ,a_asset_id,overdue,description,salesrep_id,scheddeliverydate
from
( 
select c_orderline.c_orderline_id as mrp_deliveries_expected_id,c_orderline.created,c_orderline.createdby,c_orderline.updated,c_orderline.updatedby,c_orderline.isactive,c_orderline.ad_client_id,c_orderline.ad_org_id,
       c_order.c_order_id,line,c_orderline.dateordered,c_orderline.datepromised,c_orderline.datedelivered,c_orderline.m_product_id,c_orderline.qtyordered,sum(coalesce(m_matchpo.qty,0)) as qtydelivered,
       c_orderline.c_project_id,c_orderline.c_projectphase_id,c_orderline.c_projecttask_id ,c_orderline.a_asset_id,c_orderline.description,c_order.salesrep_id,c_orderline.scheddeliverydate,
       case when coalesce(c_orderline.scheddeliverydate,now()+1)<now() then 'Y'::character(1) else 'N'::character(1) end as overdue
from c_order,c_orderline left join m_matchpo on  m_matchpo.c_orderline_id=c_orderline.c_orderline_id and m_matchpo.m_product_id=c_orderline.m_product_id and m_matchpo.c_invoiceline_id is null
     where c_order.c_order_id=c_orderline.c_order_id  and c_order.docstatus='CO' 
           AND ad_get_docbasetype(C_ORDER.c_DocType_ID) ='POO'
           AND c_orderline.deliverycomplete='N'
     group by c_orderline.c_orderline_id ,c_orderline.created,c_orderline.createdby,c_orderline.updated,c_orderline.updatedby,c_orderline.isactive,c_orderline.ad_client_id,c_orderline.ad_org_id,
              c_order.c_order_id,line,c_orderline.dateordered,c_orderline.datepromised,c_orderline.datedelivered,c_orderline.m_product_id,c_orderline.qtyordered, c_order.salesrep_id,c_orderline.description,
              c_orderline.c_project_id,c_orderline.c_projectphase_id,c_orderline.c_projecttask_id ,c_orderline.a_asset_id,c_orderline.scheddeliverydate
) a
where qtyordered!=qtydelivered
order by scheddeliverydate,c_project_id;







CREATE OR REPLACE FUNCTION c_project_won(p_pinstance_id character varying)
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
* Contributions:  Update project_vendor
****************************************************************************************************************************************************/
  --  Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  --  Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    Cur_ProjectProposalLine RECORD;
    --  Parameter Variables
    v_NextNo VARCHAR(32); --OBTG:VARCHAR2--
    v_cProjectId VARCHAR(32); --OBTG:varchar2--
    v_cBPartnerId VARCHAR(32); --OBTG:varchar2--
    v_cBPartnerLocationId VARCHAR(32); --OBTG:varchar2--
    v_User VARCHAR(32); --OBTG:varchar2--
    v_billToId VARCHAR(32); --OBTG:varchar2--
    v_paymentRule VARCHAR(60) ;
    v_cPaymenttermId VARCHAR(32); --OBTG:varchar2--
    v_projectStatus VARCHAR(60) ;
    v_value VARCHAR(40) ; --OBTG:NVARCHAR2--
    v_Accountno VARCHAR(20) ; --OBTG:NVARCHAR2--
    v_ORG VARCHAR(32); --OBTG:varchar2--
    v_Client VARCHAR(32); --OBTG:varchar2--
    v_Pricelist VARCHAR(32); --OBTG:varchar2--
    v_Pricelistvers VARCHAR(32); --OBTG:varchar2--
    --  Copy
  BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
  BEGIN --BODY
    RAISE NOTICE '%','  Record_ID=' || v_Record_ID ;
    --Update project header
    SELECT C_PROJECT.C_Project_ID,
      ProjectStatus,
      VALUE
    INTO v_cProjectId,
      v_projectStatus,
      v_value
    FROM C_PROJECT,
      C_PROJECTPROPOSAL
    WHERE C_PROJECT.C_Project_ID=C_PROJECTPROPOSAL.C_Project_ID
      AND C_PROJECTPROPOSAL.C_ProjectProposal_ID=v_Record_ID;
    IF(v_projectStatus='OP') THEN
      SELECT C_PROJECTPROPOSAL.C_BPartner_ID,
        C_PROJECTPROPOSAL.C_BPartner_Location_ID,
        MAX(C_BPARTNER_LOCATION.C_BPartner_Location_ID),
        C_PROJECTPROPOSAL.PaymentRule,
        C_PROJECTPROPOSAL.C_Paymentterm_ID
      INTO v_cBPartnerId,
        v_cBPartnerLocationId,
        v_billToId,
        v_paymentRule,
        v_cPaymenttermId
      FROM C_PROJECTPROPOSAL,
        C_BPARTNER
      LEFT JOIN C_BPARTNER_LOCATION
        ON C_BPARTNER.C_BPartner_ID=C_BPARTNER_LOCATION.C_BPartner_ID
      WHERE C_PROJECTPROPOSAL.C_BPartner_ID=C_BPARTNER.C_Bpartner_ID
        AND COALESCE(C_BPARTNER_LOCATION.IsBillTo, 'Y')='Y'
        AND C_PROJECTPROPOSAL.C_ProjectProposal_ID=v_Record_ID
      GROUP BY C_PROJECTPROPOSAL.C_BPartner_ID,
        C_PROJECTPROPOSAL.C_BPartner_Location_ID,
        C_PROJECTPROPOSAL.AD_User_ID,
        C_PROJECTPROPOSAL.PaymentRule,
        C_PROJECTPROPOSAL.C_Paymentterm_ID;
      IF(v_cProjectId IS NOT NULL) THEN
        v_ResultStr:='Update header';
        RAISE NOTICE '%',v_ResultStr ;
        DECLARE
          Cur_CBPBancAcct RECORD;
        BEGIN
          FOR Cur_CBPBancAcct IN
            (SELECT MAX(ACCOUNTNO) AS Accountno
            FROM C_BP_BANKACCOUNT
            WHERE C_BPARTNER_ID=v_cBPartnerId
              AND ISACTIVE='Y'
            )
          LOOP
            v_Accountno:=Cur_CBPBancAcct.Accountno;
            EXIT;
          END LOOP;
        END;
        UPDATE C_PROJECT
          SET Updated=TO_DATE(NOW()),
          UpdatedBy='0',
          C_BPartner_ID=v_cBPartnerId,
          C_BPartner_Location_ID=v_cBPartnerLocationId, --Salesrep_ID = v_User,
          BillTo_ID=v_billToId,
          PaymentRule=v_paymentRule,
          C_Paymentterm_ID=v_cPaymenttermId,
          accountno=v_Accountno
        WHERE C_Project_ID=v_cProjectId;
        v_ResultStr:='Updated Project';
        RAISE NOTICE '%',v_ResultStr ;
        -- SZ Update project_vendor
        delete from c_project_vendor where c_project_id=v_cProjectId;
        select ad_client_id,ad_org_id into v_client, v_org from c_project where c_project_id=v_cProjectId;
        select m_get_pricelist_version(m_pricelist_id,to_date(now())),m_pricelist_id into v_Pricelistvers,v_Pricelist  from m_pricelist where ad_client_id=v_client and ad_org_id in ('0',v_org) and isactive='Y' and isdefault='Y';
        v_ResultStr:='Got Pricelist';
        RAISE NOTICE '%',v_ResultStr ;
        insert into c_project_vendor (C_PROJECT_VENDOR_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, C_PROJECT_ID, C_BPARTNER_ID,  M_PRICELIST_VERSION_ID, M_PRICELIST_ID)
                    values(get_uuid(),v_client,v_org,'Y',now(),v_User,now(),v_User,v_cProjectId,v_cBPartnerId,coalesce(v_Pricelistvers,''),coalesce(v_Pricelist,''));
        v_ResultStr:='Inserted Vendor';
        RAISE NOTICE '%',v_ResultStr ;
        --Update, insert or delete project lines
        v_ResultStr:='Update Lines';
        RAISE NOTICE '%',v_ResultStr ;
        DELETE FROM C_PROJECTLINE WHERE C_PROJECTLINE.C_Project_ID=v_cProjectId;
        FOR Cur_ProjectProposalLine IN
          (SELECT C_PROJECTPROPOSALLINE.AD_Client_ID,
            C_PROJECTPROPOSALLINE.AD_Org_ID,
            C_PROJECTPROPOSALLINE.M_Product_ID,
            C_PROJECTPROPOSALLINE.Qty,
            C_PROJECTPROPOSALLINE.Price,
            C_PROJECTPROPOSALLINE.Product_Value,
            C_PROJECTPROPOSALLINE.Product_Name,
            C_PROJECTPROPOSALLINE.Product_Description,
            M_PRODUCT.M_Product_Category_ID,
            C_PROJECTPROPOSALLINE.LineNo
          FROM C_PROJECTPROPOSALLINE,
            M_PRODUCT
          WHERE C_PROJECTPROPOSALLINE.M_Product_ID=M_PRODUCT.M_Product_ID
            AND C_PROJECTPROPOSALLINE.C_ProjectProposal_ID=v_Record_ID
          )
        LOOP
          SELECT * INTO  v_NextNo FROM Ad_Sequence_Next('C_ProjectLine', Cur_ProjectProposalLine.AD_Client_ID) ;
          INSERT
          INTO C_PROJECTLINE
            (
              C_PROJECTLINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE,
              CREATED, CREATEDBY, UPDATED, UPDATEDBY,
              C_PROJECT_ID, LINE, DESCRIPTION, PLANNEDQTY,
              PLANNEDPRICE, PLANNEDAMT, PLANNEDMARGINAMT, COMMITTEDAMT,
              M_PRODUCT_ID, M_PRODUCT_CATEGORY_ID, INVOICEDAMT, INVOICEDQTY,
              COMMITTEDQTY, C_PROJECTISSUE_ID, C_ORDER_ID, C_ORDERPO_ID,
              ISPRINTED, PROCESSED, DOPRICING, PLANNEDPOPRICE,
              PRODUCT_VALUE, C_TAX_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION
            )
            VALUES
            (
              v_NextNo, Cur_ProjectProposalLine.AD_Client_ID, Cur_ProjectProposalLine.AD_Org_ID, 'Y',
              TO_DATE(NOW()), '0', TO_DATE(NOW()), '0',
              v_cProjectId, Cur_ProjectProposalLine.LineNo, '', Cur_ProjectProposalLine.Qty,
              Cur_ProjectProposalLine.Price, Cur_ProjectProposalLine.Qty*Cur_ProjectProposalLine.Price, 0, 0,
              Cur_ProjectProposalLine.M_Product_ID, Cur_ProjectProposalLine.M_Product_Category_ID, 0, 0,
              0, NULL, NULL, NULL,
               'N', 'N', 'N', NULL,
              Cur_ProjectProposalLine.Product_Value, NULL, Cur_ProjectProposalLine.Product_Name, Cur_ProjectProposalLine.Product_Description
            )
            ;
        END LOOP;
        v_Message:='@Project@ ' || v_value || ' @awarded@';
      END IF;
    ELSE
                RAISE EXCEPTION '%', '@Projectclose@'; --OBTG:-20000--
    END IF;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION c_project_won(character varying) OWNER TO tad;




-- Function: c_generatepofromproject(character varying)

-- DROP FUNCTION c_generatepofromproject(character varying);

CREATE OR REPLACE FUNCTION c_generatepofromproject(p_pinstance_id character varying)
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
* Contributions: Patch: TAX redefined, Price-Calculation simplyfied.Checks if the correct Type of Asset is selected for Project
****************************************************************************************************************************************************/
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_User VARCHAR(32); --OBTG:VARCHAR2--
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    v_C_Order_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_C_OrderLine_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_C_DOCTYPE_ID VARCHAR(32); --OBTG:VARCHAR2--
    v_DocumentNo VARCHAR(30) ; --OBTG:NVARCHAR2--
  BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
  BEGIN --BODY
    RAISE NOTICE '%','  Record_ID=' || v_Record_ID ;
    DECLARE
      v_BPartner_Location_ID VARCHAR(32); --OBTG:VARCHAR2--
      v_BillTo_ID VARCHAR(32); --OBTG:VARCHAR2--
      v_Size NUMERIC;
      v_UOM VARCHAR(32); --OBTG:VARCHAR2--
      v_PriceStd NUMERIC;
      v_PriceList NUMERIC;
      v_PriceLimit NUMERIC;
      v_C_Currency_ID VARCHAR(32); --OBTG:VARCHAR2--
      v_PriceActual NUMERIC;
      v_Discount NUMERIC;
      v_Tax_ID VARCHAR(32); --OBTG:VARCHAR2--
      v_M_PriceList_Version_ID VARCHAR(32); --OBTG:VARCHAR2--

    --TYPE RECORD IS REFCURSOR;
      Cur_SO RECORD;
      Cur_SOLINES RECORD;
    BEGIN
      v_ResultStr:='StartLoop';
      FOR Cur_SO IN
        (SELECT P.C_PROJECT_ID,
          P.PROJECTSTATUS,
          V.AD_CLIENT_ID,
          V.AD_ORG_ID,
          V.C_BPARTNER_ID,
          V.C_INCOTERMS_ID,
          V.C_PROJECT_VENDOR_ID,
          V.INCOTERMS_DESCRIPTION,
          V.M_PRICELIST_VERSION_ID,
          V.M_PRICELIST_ID,
          P.C_CAMPAIGN_ID,
          PL.C_CURRENCY_ID,
                  P.C_CURRENCY_ID AS PROJCURRENCY,
          BP.PAYMENTRULEPO AS PAYMENTRULE,
          BP.PO_PAYMENTTERM_ID AS C_PAYMENTTERM_ID,
          P.M_WAREHOUSE_ID,
          P.POREFERENCE,
          P.SALESREP_ID,
          P.CREATETEMPPRICELIST,
          P.DESCRIPTION
        FROM C_PROJECT P,
          C_PROJECT_VENDOR V,
          C_BPARTNER BP,
          M_PRICELIST PL
        WHERE P.C_PROJECT_ID=V.C_PROJECT_ID
          AND V.C_BPARTNER_ID=BP.C_BPARTNER_ID
          AND V.M_PRICELIST_ID=PL.M_PRICELIST_ID
          AND V.ISACTIVE='Y'
          AND V.C_PROJECT_VENDOR_ID=v_Record_ID
        )
      LOOP
        -- Check that we have some restrictions
        v_ResultStr:='CheckRestriction';
        IF(Cur_SO.PROJECTSTATUS IS NULL OR Cur_SO.PROJECTSTATUS<>'OR') THEN
         RAISE EXCEPTION '%', '@Invalidprojectstatus@'||'. '||' @ChangeToOrder@'||'.'; --OBTG:-20000--
        ELSIF Cur_SO.C_BPARTNER_ID IS NULL THEN
          RAISE EXCEPTION '%', '@NoprojectBusinesspartner@'; --OBTG:-20000--
        ELSIF Cur_SO.C_PAYMENTTERM_ID IS NULL THEN
          RAISE EXCEPTION '%', '@ThebusinessPartner@'||' '||' @PaymenttermNotdefined@'||'.'; --OBTG:-20000--
        ELSIF Cur_SO.M_PRICELIST_ID IS NULL THEN
          RAISE EXCEPTION '%', '@ThebusinessPartner@'||' '||' @PricelistNotdefined@'||'.'; --OBTG:-20000--
        ELSIF Cur_SO.C_CURRENCY_ID IS NULL THEN
          RAISE EXCEPTION '%', '@ProjectCurrencyNotFound@'||'.'; --OBTG:-20000--
        ELSIF Cur_SO.M_WAREHOUSE_ID IS NULL THEN
          RAISE EXCEPTION '%', '@ProjectWarehouseNotFound@'||'.'; --OBTG:-20000--
        ELSIF Cur_SO.SALESREP_ID IS NULL THEN
          RAISE EXCEPTION '%', '@ProjectSalesRepNotFound@'||'.'; --OBTG:-20000--
        END IF;

        v_C_DOCTYPE_ID:=Ad_Get_DocType(Cur_SO.AD_Client_ID, Cur_SO.AD_Org_ID, 'POO') ;
        SELECT * INTO  v_DocumentNo FROM AD_Sequence_DocType(v_C_DOCTYPE_ID, Cur_SO.AD_org_ID, 'Y') ;
        IF(v_DocumentNo IS NULL) THEN
          SELECT * INTO  v_DocumentNo FROM AD_Sequence_Doc('DocumentNo_C_Order', Cur_SO.AD_org_ID, 'Y') ;
        END IF;

        -- Get Business Partner Ship Location
        v_BPartner_Location_ID := C_GetBPLocationID(Cur_SO.C_BPartner_ID, 'S') ;
        IF (v_BPartner_Location_ID IS NULL) THEN
          RAISE EXCEPTION '%', '@ThebusinessPartner@'||' '||' @ShiptoNotdefined@'||'.'; --OBTG:-20000--
        END IF;

        -- Get Business Partner Bill Location
        v_Billto_ID := C_GetBPLocationID(Cur_SO.C_BPartner_ID, 'B') ;
        IF (v_Billto_ID IS NULL) THEN
          RAISE EXCEPTION '%', '@ThebusinessPartner@'||' '||' @BillToNotdefined@'||'.'; --OBTG:-20000--
        END IF;

        -- Get next C_Order_ID
        SELECT * INTO  v_C_Order_ID FROM Ad_Sequence_Next('C_Order', Cur_SO.AD_CLIENT_ID) ;
        v_ResultStr:='C_ORDER_ID - ' || v_C_Order_ID;

        INSERT
        INTO C_ORDER
          (
            C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY,
            UPDATEDBY, ISSOTRX, DOCUMENTNO, DOCSTATUS,
            DOCACTION, C_DOCTYPE_ID, C_DOCTYPETARGET_ID, DATEORDERED,
            DATEACCT, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, ISDISCOUNTPRINTED,
            C_CURRENCY_ID, PAYMENTRULE, C_PAYMENTTERM_ID, INVOICERULE,
            DELIVERYRULE, FREIGHTCOSTRULE, DELIVERYVIARULE, PRIORITYRULE,
            TOTALLINES, GRANDTOTAL, M_WAREHOUSE_ID, M_PRICELIST_ID,
            ISTAXINCLUDED, POSTED, PROCESSING, SALESREP_ID,
            BILLTO_ID, POREFERENCE, C_CAMPAIGN_ID, C_BIDPROJECT_ID,
            AD_USER_ID, COPYFROM, C_INCOTERMS_ID, INCOTERMSDESCRIPTION,
            DATEPROMISED, DESCRIPTION
          )
          VALUES
          (
            v_C_Order_ID, Cur_SO.AD_CLIENT_ID, Cur_SO.AD_ORG_ID, v_User,
            v_User, 'N', v_DocumentNo, 'DR',
             'CO', '0', v_C_DOCTYPE_ID, TRUNC(TO_DATE(NOW()), 'DD'),
            TRUNC(TO_DATE(NOW()), 'DD'), Cur_SO.C_BPARTNER_ID, v_BPartner_Location_ID, 'N',
            Cur_SO.C_CURRENCY_ID, COALESCE(Cur_SO.PAYMENTRULE, 'P'), Cur_SO.C_PAYMENTTERM_ID, 'D',
             'A', 'I', 'D', '5',
            0, 0, Cur_SO.M_WAREHOUSE_ID, Cur_SO.M_PRICELIST_ID,
             'N', 'N', 'N', Cur_SO.SALESREP_ID,
            v_BillTo_ID, Cur_SO.POREFERENCE, Cur_SO.C_CAMPAIGN_ID, Cur_SO.C_PROJECT_ID,
            NULL, 'N', Cur_SO.C_INCOTERMS_ID, Cur_SO.INCOTERMS_DESCRIPTION,
            TRUNC(TO_DATE(NOW()), 'DD'), Cur_SO.DESCRIPTION
          )
          ;

        -- Select the price list version that a applies for the price list of the header
        SELECT M_Get_Pricelist_Version(Cur_SO.M_PriceList_ID, TRUNC(TO_DATE(NOW()), 'DD'))
        INTO v_M_PriceList_Version_ID
        FROM DUAL;
        IF (v_M_PriceList_Version_ID IS NULL) THEN
          RAISE EXCEPTION '%', '@PriceListVersionNotFound@'||'.'; --OBTG:-20000--
        ELSE
         -- Select products, quantities, sequence numbers, descriptions and unit prices of the project
            -- In both cases, if no unit price has been defined for a product,
            -- price is taken from the price list of the project.
            -- And if no price is defined in the price list, price is set to 0.
          FOR Cur_SOLINES IN
            (
            SELECT pl.LINE AS SEQNO, pl.PRODUCT_DESCRIPTION AS DESCRIPTION, pl.M_PRODUCT_ID,
              pl.PLANNEDQTY AS QTY, pl.PLANNEDPRICE AS PRICEACTUAL, pl.C_TAX_ID
            FROM C_PROJECTLINE pl, C_PROJECT_VENDOR  pv
            WHERE pv.C_PROJECT_VENDOR_ID = v_Record_ID
              AND pl.C_PROJECT_ID = pv.C_PROJECT_ID
              AND pl.M_Product_ID IS NOT NULL
              AND pl.IsActive = 'Y'
            ORDER BY SEQNO ASC
            )
          LOOP

              v_PriceStd := Cur_SOLINES.PRICEACTUAL;
              v_PriceList := Cur_SOLINES.PRICEACTUAL;
              v_PriceLimit := Cur_SOLINES.PRICEACTUAL;
              v_PriceActual := Cur_SOLINES.PRICEACTUAL;
            
           
                -- Make currency conversion if project header's currency (hence, project lines currency) is different from supplier's price list currency
            IF (Cur_SO.C_CURRENCY_ID != Cur_SO.PROJCURRENCY) THEN
              v_PriceActual := COALESCE(C_Currency_Convert(v_PriceActual, Cur_SO.PROJCURRENCY, Cur_SO.C_CURRENCY_ID, TO_DATE(NOW()), NULL, Cur_SO.AD_CLIENT_ID, Cur_SO.AD_ORG_ID),0);
                  v_PriceStd := COALESCE(C_Currency_Convert(v_PriceStd, Cur_SO.PROJCURRENCY, Cur_SO.C_CURRENCY_ID, TO_DATE(NOW()), NULL, Cur_SO.AD_CLIENT_ID, Cur_SO.AD_ORG_ID),0);
              v_PriceList := COALESCE(C_Currency_Convert(v_PriceList, Cur_SO.PROJCURRENCY, Cur_SO.C_CURRENCY_ID, TO_DATE(NOW()), NULL, Cur_SO.AD_CLIENT_ID, Cur_SO.AD_ORG_ID),0);
              v_PriceLimit := COALESCE(C_Currency_Convert(v_PriceLimit, Cur_SO.PROJCURRENCY, Cur_SO.C_CURRENCY_ID, TO_DATE(NOW()), NULL, Cur_SO.AD_CLIENT_ID, Cur_SO.AD_ORG_ID),0);
                END IF;

                -- Calculating the discount
                IF (v_PriceList = 0) THEN
               v_Discount := 0 ;
            ELSE
              -- Calculate rounded discount
              v_Discount :=ROUND((v_PriceList-v_PriceActual) / v_PriceList*100, 2);
            END IF;

            
            SELECT P.C_UOM_ID
            INTO v_UOM
            FROM M_PRODUCT P
            WHERE P.M_PRODUCT_ID=Cur_SOLINES.M_PRODUCT_ID;
            

            IF (Cur_SOLINES.C_TAX_ID IS NULL) THEN
              v_Tax_ID:= zsfi_GetTax(v_BPartner_Location_ID,Cur_SOLINES.M_PRODUCT_ID, Cur_SO.AD_ORG_ID) ;
            ELSE
              v_Tax_ID:=Cur_SOLINES.C_TAX_ID;
            END IF;

            -- Get next C_OrderLine_ID
            SELECT * INTO  v_C_OrderLine_ID FROM Ad_Sequence_Next('C_OrderLine', Cur_SO.AD_CLIENT_ID) ;
            v_ResultStr:='C_OrderLine_ID - ' || v_C_OrderLine_ID;

            INSERT
            INTO C_ORDERLINE
              (
                DateOrdered, M_Warehouse_ID, QtyOrdered, QtyDelivered,
                QtyReserved, M_Shipper_ID, QtyInvoiced,
                C_Currency_ID, PriceList, DatePromised, DateDelivered,
                DateInvoiced, Created, IsActive, Line,
                C_OrderLine_ID, AD_Client_ID, C_Order_ID, Description,
                M_Product_ID, C_UOM_ID, DirectShip, CreatedBy,
                UpdatedBy, FreightAmt, C_Charge_ID, ChargeAmt,
                Updated, AD_Org_ID, S_ResourceAssignment_ID, C_BPartner_ID,
                PriceActual,
                C_Tax_ID, C_BPartner_Location_ID,
                Discount, PriceLimit, Ref_OrderLine_ID, LineNetAmt,
                M_AttributeSetInstance_ID, IsDescription, PriceStd
              )
              VALUES
              (
                TRUNC(TO_DATE(NOW()), 'DD'), Cur_SO.M_WAREHOUSE_ID, Cur_SOLINES.Qty, 0,
                0, NULL, 0,
                Cur_SO.C_CURRENCY_ID, v_PriceList, TRUNC(TO_DATE(NOW()), 'DD'), NULL,
                NULL, TO_DATE(NOW()), 'Y', Cur_SOLINES.SEQNO,
                v_C_OrderLine_ID, Cur_SO.AD_CLIENT_ID, v_C_Order_ID, Cur_SOLINES.DESCRIPTION,
                Cur_SOLINES.M_PRODUCT_ID, v_UOM, 'N', v_User,
                v_User, 0, NULL, 0,
                TO_DATE(NOW()), Cur_SO.AD_ORG_ID, NULL, Cur_SO.C_BPARTNER_ID,
                v_PriceActual,
                v_Tax_ID, v_BPartner_Location_ID,
                v_Discount, v_PriceLimit, NULL, v_PriceActual * Cur_SOLINES.Qty,
                NULL, 'N', v_PriceStd
              );
         END LOOP;
        END IF;

        IF NOT(v_Message='') THEN
          v_Message:=v_Message || ', ';
        END IF;
        v_Message:=v_Message || v_DocumentNo;
      END LOOP;
      Update C_PROJECT_VENDOR set GenerateOrder='Y' where C_PROJECT_VENDOR_ID = v_Record_ID;
      v_Message:='@DocumentNo@: ' || v_Message;
    END;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N',1, v_Message) ;
    RETURN;
  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr ;
  -- ROLLBACK;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION c_generatepofromproject(character varying) OWNER TO tad;



CREATE OR REPLACE FUNCTION zspm_createTaskSubItems(p_projecttask_id character varying, p_task_id character varying,p_client_id character varying,p_org_id character varying,p_user character varying)
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
Part of Projects
Creates Machine Plan, HR-Plan and indirect cost from project Draft
*****************************************************/
v_count          numeric;
BEGIN
   -- HR Plan
   insert into ZSPM_PTASKHRPLAN(ZSPM_PTASKHRPLAN_ID, AD_CLIENT_ID, AD_ORG_ID, C_PROJECTTASK_ID,CREATEDBY, UPDATEDBY, C_SALARY_CATEGORY_ID, QUANTITY, COSTUOM)
          select get_uuid(),p_client_id,p_org_id,p_projecttask_id,p_user,p_user,C_SALARY_CATEGORY_ID, QUANTITY, COSTUOM from zspm_ctaskhrplan where C_TASK_ID=p_task_id;
   -- Machineplan
   insert into zspm_ptaskmachineplan(ZSPM_PTASKMACHINEPLAN_ID, AD_CLIENT_ID, AD_ORG_ID, C_PROJECTTASK_ID,CREATEDBY,  UPDATEDBY, MA_MACHINE_ID, QUANTITY, COSTUOM)
          select get_uuid(),p_client_id,p_org_id,p_projecttask_id,p_user,p_user,MA_MACHINE_ID, QUANTITY, COSTUOM  from zspm_ctaskmachineplan where C_TASK_ID=p_task_id;
   -- Indirect Cost Plan
   insert into ZSPM_PTASKINDCOSTPLAN(ZSPM_PTASKINDCOSTPLAN_ID, AD_CLIENT_ID, AD_ORG_ID, C_PROJECTTASK_ID,CREATEDBY, UPDATEDBY, MA_INDIRECT_COST_ID)
          select get_uuid(),p_client_id,p_org_id,p_projecttask_id,p_user,p_user,MA_INDIRECT_COST_ID from ZSPM_CTASKINDCOSTPLAN where C_TASK_ID=p_task_id;
   --
   RETURN 'OK';   
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspm_createTaskSubItems(p_projecttask_id character varying, p_task_id character varying,p_client_id character varying,p_org_id character varying,p_user character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION c_project_trg() RETURNS trigger LANGUAGE plpgsql AS $BODY$ 
DECLARE 
    v_cur RECORD;
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;

   IF (TG_OP = 'UPDATE') THEN
     if new.ad_org_id!=old.ad_org_id then
        update c_projecttask set ad_org_id=new.ad_org_id where  c_project_id=new.c_project_id;
        update zspm_projecttaskbom set ad_org_id=new.ad_org_id where  c_projecttask_id in (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id);
        update zspm_projecttaskdep set ad_org_id=new.ad_org_id where  c_projecttask_id in (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id);
        update zspm_ptaskhrplan set ad_org_id=new.ad_org_id where  c_projecttask_id in (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id);
        update zspm_ptaskindcostplan set ad_org_id=new.ad_org_id where  c_projecttask_id in (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id);
        update zspm_ptaskmachineplan set ad_org_id=new.ad_org_id where  c_projecttask_id in (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id);
        update zssm_productionplan_task set ad_org_id=new.ad_org_id where  c_projecttask_id in (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id);
        update zssm_ptasktechdoc set ad_org_id=new.ad_org_id where  c_projecttask_id in (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id);
        update c_projecttaskexpenseplan set ad_org_id=new.ad_org_id where  c_projecttask_id in (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id);
      end if;
      if new.ad_org_id!=old.ad_org_id or new.datefinish!=old.datefinish or new.startdate!=old.startdate or new.isactive!=old.isactive
         or new.projectstatus!=old.projectstatus then
        for v_cur in (select ma_machine_id,null as c_bpartner_id,ad_org_id from zspm_ptaskmachineplan where c_projecttask_id in
                                (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id)
                    union 
                    select null as ma_machine_id,u.c_bpartner_id,h.ad_org_id from ad_user u,zspm_ptaskhrplan h where h.employee_id=u.ad_user_id 
                                and h.c_projecttask_id in
                                (select c_projecttask_id from c_projecttask where c_project_id=new.c_project_id))
        LOOP
                PERFORM zssi_resourceplanaggregareResourceInTime(new.startdate,new.datefinish,v_cur.c_bpartner_id,v_cur.ma_machine_id,v_cur.ad_org_id);
        END LOOP;
      end if;
    END IF;
    IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END; $BODY$;

CREATE OR REPLACE FUNCTION zspm_project_trg()
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
Part of Projects
Checks if the correct Type of Asset is selected for Project
*****************************************************/
v_count          numeric;
v_ismanager        varchar;
v_isworker       varchar;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  
  if new.projectcategory='M' and new.ma_machine_id is null then
      select count(*) into v_count from a_asset where a_asset_id=new.a_asset_id and assettype='RE';
      if not coalesce(v_count,0)=1 then
           RAISE EXCEPTION '%', '@zspm_SelectREAssetforMProject@';
      end if;
  end if;
  if new.projectcategory in ('P','M') and new.a_asset_id is not null then
      RAISE EXCEPTION '%', '@zspm_NoAssetforProject@';
  end if;
  if new.projectcategory in ('S','P') and new.a_asset_id is not null then
      new.ma_machine_id:=null;
  end if;
  if new.startdate is not null then
        select count(*) into v_count from c_projecttask where c_projecttask.c_project_id=new.c_project_id and trunc(coalesce(c_projecttask.startdate,new.startdate))<trunc(new.startdate);
        if v_count>0 then
            RAISE EXCEPTION '%', '@zspm_NoCorrectDates@';
        end if;
  end if;
  if new.datefinish is not null then
        select count(*) into v_count from c_projecttask where c_projecttask.c_project_id=new.c_project_id and trunc(coalesce(c_projecttask.enddate,new.datefinish))>trunc(new.datefinish);
        if v_count>0 then
            RAISE EXCEPTION '%', '@zspm_NoCorrectDates@';
        end if;
  end if;
  if (trunc(coalesce(new.startdate,now()))>trunc(coalesce(new.datefinish,now()))) then
        RAISE EXCEPTION '%', '@zspm_NoCorrectDates@';
  end if;
  -- Workflow
  if c_getconfigoption('projectmangerworkflow',new.ad_org_id)='Y' and new.ProjectCategory not in ('PRP','PRO','B') then 
      IF TG_OP = 'INSERT' then
            select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=new.updatedby;
            if coalesce(v_ismanager,'N')!='Y' and (coalesce(v_isworker,'N')!='Y' or (coalesce(v_isworker,'N')='Y' and new.Responsible_ID!=new.updatedby)) then
                  RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
            end if;
      end if; 
      IF TG_OP = 'UPDATE' then
            select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=new.updatedby;
            if (coalesce(v_ismanager,'N')!='Y' and new.Responsible_ID!=old.Responsible_ID) then
                  RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
            end if;
      end if;  
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;



CREATE OR REPLACE FUNCTION zspm_projecttask_trg ()
RETURNS trigger AS
$body$
 -- BEFORE INSERT, UPDATE, DELETE, ON c_projecttask
 DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011-2012 Stefan Zimmermann All Rights Reserved.
Contributor : 2012 MaHinrichs:
***************************************************************************************************************************************************
Part of Projects
*****************************************************/
v_count          numeric;
v_bomamt         numeric:=0;
v_hramt          numeric;
v_maamt          numeric;
v_expenseamt     NUMERIC;
v_extserviceamt     NUMERIC;
v_indamt         numeric:=0;
v_planamt        numeric;
v_IEmpCost      numeric;
v_IMatCost      numeric;
v_IMachCost      numeric;
v_IVendCost      numeric;
v_projectamt     numeric;
v_cur            RECORD;
v_cdate timestamp without time zone:=now();


cur_projecttaskbom_product RECORD;
cur_product_bom RECORD;
v_product_row m_product%ROWTYPE;

-- v_counted INTEGER;
v_product_id         m_product.m_product_id%TYPE;
v_attributeset_id    m_product.m_attributeset_id%TYPE;
v_isactive CHAR(1);
v_isverified CHAR(1);
v_isbom CHAR(1);
v_discontinued CHAR(1);
v_typeofproduct VARCHAR;
v_setready4production CHAR(1);
v_isstocked varchar;
v_producttype varchar;
v_isproduction boolean;
v_start timestamp;
v_end timestamp;
v_ismanager varchar;
v_isworker varchar;

BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;  END IF;
  IF TG_OP != 'DELETE' then
    -- Workflow
    if c_getconfigoption('projectmangerworkflow',new.ad_org_id)='Y' and (select ProjectCategory from c_project where c_project_id = new.c_project_id) not in ('PRP','PRO','B') then 
        IF TG_OP = 'INSERT' then
                select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=new.updatedby;
                if NOT (coalesce(v_ismanager,'N')='Y' or (coalesce(v_isworker,'N')='Y' and 
                                                      (select responsible_id from c_project where c_project_id=new.c_project_id)=new.updatedby)) then
                    RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
                end if;
        end if; 
    end if;
  else -- delete
     if c_getconfigoption('projectmangerworkflow',old.ad_org_id)='Y' and (select ProjectCategory from c_project where c_project_id = old.c_project_id) not in ('PRP','PRO','B') then 
        select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=old.updatedby;
        if NOT (coalesce(v_ismanager,'N')='Y' or (coalesce(v_isworker,'N')='Y' and 
                                                      (select responsible_id from c_project where c_project_id=old.c_project_id)=old.updatedby)) then
           RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
        end if;
     end if; 
  end if; -- Workflow end
  IF TG_OP != 'DELETE' then
      -- Calculation of Needed Time (For Worksteps only)
      new.timeplanned=new.setuptime + new.timeperpiece*coalesce(new.qty,0);
      

      IF (TG_OP = 'INSERT') THEN
    -- SeqNo
       IF ((new.seqno IS NULL) OR (new.seqNo = 0)) THEN
        new.seqNo := (SELECT (COALESCE(MAX(pt.seqno), 0) + 10)
                      FROM c_projecttask pt
                      WHERE pt.c_project_id = new.c_project_id);
       END IF;
      END IF; -- (TG_OP = 'INSERT')
      /*
      IF (TG_OP = 'UPDATE') THEN
        IF new.ismaterialdisposed = 'Y' AND old.m_product_id <> new.m_product_id THEN
          RAISE EXCEPTION '%', '@zspm_DoNotDeleteTaskBegun@';
        END IF;

      END IF; -- (TG_OP = 'UPDATE')
     */
     -- Test if Production Order or Plan or Workstep?
     SELECT count(*) into v_count      FROM c_project prj    WHERE prj.c_project_id = new.c_project_id AND prj.projectcategory in ('PRO','PRP');
     if v_count>0 or new.c_project_id is null then
        v_isproduction=true;
     else
        v_isproduction:=false;
     end if;
     -- Do the Dates makes sense
     select startdate,datefinish into v_start,v_end from c_project where c_project_id=new.c_project_id;
     if new.startdate is not null and v_start is not null then
        if trunc(new.startdate)<trunc(v_start) then
            RAISE EXCEPTION '%', '@zspm_NoCorrectDates@';
        end if;
     end if;
     if new.enddate is not null and v_end is not null then
        if trunc(new.enddate)>trunc(v_end) then
            RAISE EXCEPTION '%', '@zspm_NoCorrectDates@';
        end if;
     end if;
     if (v_isproduction=false and coalesce(new.startdate,now())>coalesce(new.enddate,now())) then
        RAISE EXCEPTION '%', '@zspm_NoCorrectDates@';
     end if;
      -- Prereq's for a Production-Ready Item
  /*
      SELECT count(*) into v_count
      FROM m_product
      WHERE m_product_id=new.m_product_id
       and m_attributeset_id is null
       and m_product.isactive='Y'
       and m_product.isverified='Y'
       and m_product.isbom='Y'
       and m_product.discontinued='N'
       and m_product.typeofproduct in ('AS','SA','CD')
       and m_product.setready4production='Y';
      if coalesce(v_count,0)!=1 and new.m_product_id is not null then
         RAISE EXCEPTION '%', '@zsmf_InPBOMPNotOK@';
      end if;
  */
      IF (NOT isempty(NEW.m_product_id)) THEN 
        SELECT m_product_id, m_attributeset_id, isactive, isverified, isbom, discontinued, typeofproduct, setready4production,isstocked,producttype
        INTO v_product_id, v_attributeset_id, v_isactive, v_isverified, v_isbom, v_discontinued, v_typeofproduct, v_setready4production,v_isstocked,v_producttype
        FROM m_product
        WHERE m_product_id = NEW.m_product_id;
        IF (NOT isempty(v_product_id)) THEN -- product was found
         -- check required settings
          IF (v_attributeset_id IS NOT NULL) THEN
            RAISE EXCEPTION '@zsmf_InPBOMPNotOK@: %', ' Attribute';
          ELSEIF (v_isactive <> 'Y') THEN
            RAISE EXCEPTION '@zsmf_InPBOMPNotOK@: %', ' Inactiv';
          ELSEIF (v_discontinued <> 'N' or v_isstocked!='Y' or  v_producttype!='I') THEN -- ist Auslaufartikel
            RAISE EXCEPTION '%', '@zsmf_InPBOMPNotOK_discontinued@';
          ELSEIF (v_typeofproduct NOT IN ('AS','SA','CD') and not v_isproduction ) THEN
            RAISE EXCEPTION '%','@zsmf_InPBOMPNotOK@';
          ELSEIF (v_setready4production <> 'Y' and not v_isproduction and c_getconfigoption('projectonlyapprovedproducts',new.ad_org_id) = 'Y') THEN
            RAISE EXCEPTION '@zsmf_InPBOMPNotOK@: %', ' Not approved Product';
          END IF;
        END IF; -- isempty(v_product_id)
      END IF; -- isempty(NEW.m_product_id)
       IF (TG_OP = 'UPDATE') THEN
            -- Prereq's for Serial Number Tracking
            select count(*) into v_count from m_product where m_product_id=new.m_product_id and isserialtracking='Y';
            if coalesce(v_count,0)=1 and new.m_product_id is not null and new.qty!=1 and new.qty!=old.qty and not v_isproduction then
               RAISE EXCEPTION '%', '@zsmf_SerialProductsOnlyOneItem@';
            end if;
            -- For Resource Plan Calculations
            new.olddateto=old.enddate;
            new.olddatefrom=old.startdate;
       end if;
       IF (TG_OP = 'INSERT') THEN
             -- Prereq's for Serial Number Tracking
            select count(*) into v_count from m_product where m_product_id=new.m_product_id and isserialtracking='Y';
            if coalesce(v_count,0)=1 and new.m_product_id is not null and new.qty!=1 and not v_isproduction then
               RAISE EXCEPTION '%', '@zsmf_SerialProductsOnlyOneItem@';
            end if;
       end if;
     
     -- Only Production Orders
/*
     
*/
      IF  new.isactive='Y' THEN
        
        -- HR COST : In case of per Item Costs multiply with items..
        select sum(plannedamt) into v_hramt from zspm_ptaskhrplan where c_projecttask_id=new.c_projecttask_id and isactive='Y';
        -- Machine Cost In case of per Item Costs multiply with items..
        select sum(plannedamt) into v_maamt from zspm_ptaskmachineplan where c_projecttask_id=new.c_projecttask_id and isactive='Y';
        -- Material Costs from Bom
        select sum(plannedamt) into v_bomamt from zspm_projecttaskbom where c_projecttask_id=new.c_projecttask_id  and isactive='Y';
        --Calculate estimation costs of Vendos..
        select sum(plannedamt) into v_expenseamt from C_projecttaskexpenseplan where c_projecttask_id=new.c_projecttask_id  and isactive='Y' and
                                                 coalesce((select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=C_projecttaskexpenseplan.m_product_id),'N') = 'N';
        --Calculate estimation costs of Vendos..(EXTERNAL SERVICES)
        select sum(plannedamt) into v_extserviceamt from C_projecttaskexpenseplan where c_projecttask_id=new.c_projecttask_id  and isactive='Y' and
                                                 coalesce((select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=C_projecttaskexpenseplan.m_product_id),'N') = 'Y';                                         
        -- Sum on Task so far
        v_planamt:=coalesce(v_maamt,0)+coalesce(v_hramt,0)+coalesce(v_bomamt,0)+coalesce(v_expenseamt,0)+coalesce(v_extserviceamt,0);
        -- Indirect Cost (Only %-Costtypes at the moment..)
        for v_cur in (select * from zspm_ptaskindcostplan where c_projecttask_id=new.c_projecttask_id)
        LOOP
           select p_empcost,p_machinecost,p_matcost,p_vendorcost into v_IEmpCost,v_IMachCost,v_IMatCost,v_IVendCost from
                  zsco_get_indirect_cost(v_cur.ma_indirect_cost_id,now(),'P',new.c_projecttask_id,'plan',null);
           v_indamt:= v_indamt + round(coalesce(v_hramt,0)*v_IEmpCost/100,2) + v_IMatCost + 
                                 round(coalesce(v_maamt,0)*v_IMachCost/100,2) + v_IVendCost ;
        END LOOP;

        v_projectamt := (
          SELECT v_indamt + COALESCE(sum(plannedcost),0) + COALESCE(v_planamt,0)
          FROM c_projecttask
          WHERE c_projecttask_id <> new.c_projecttask_id AND c_project_id=new.c_project_id);

        UPDATE c_project SET plannedamt = v_projectamt where c_project_id=new.c_project_id;

        new.plannedcost:=v_planamt+v_indamt;
        new.materialcostplan:= v_bomamt;
        new.indirectcostplan:= v_indamt;
        new.machinecostplan:= v_maamt;
        new.servcostplan:= v_hramt;
        new.expensesplan:=coalesce(v_expenseamt,0);
        new.externalserviceplan:=coalesce(v_extserviceamt,0);
      END IF;
      RETURN NEW;
  -- Deleting
  ELSE
      --if old.taskbegun = 'Y' then
      --   RAISE EXCEPTION '%', '@zspm_DoNotDeleteTaskBegun@';
      --end if;
      -- Update Planned Cost in Project.
      RETURN OLD;
  END IF;
END;
$body$
LANGUAGE 'plpgsql';
select zsse_droptrigger('zspm_projecttask_trg','c_projecttask');

CREATE TRIGGER zspm_projecttask_trg
  BEFORE INSERT OR UPDATE
  ON c_projecttask
  FOR EACH ROW
  EXECUTE PROCEDURE zspm_projecttask_trg();

CREATE OR REPLACE FUNCTION zspm_projecttaskbom_trg ()
RETURNS trigger AS
$body$
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
Part of Projects
CHECKS:
Restriction: BOM only on Production-Projects
             BOM may not be changed, after Task begun
*****************************************************/
v_taskbegun    VARCHAR;
v_outsourcing  VARCHAR;
v_product_id   VARCHAR;
v_qty          NUMERIC;
v_disposed     VARCHAR;
v_project_id   VARCHAR;
v_prjcat       VARCHAR;
BEGIN
 --  AFTER INSERT OR UPDATE OR DELETE ON zspm_projecttaskbom
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;  END IF;

  IF (TG_OP != 'DELETE') THEN
    SELECT pt.c_project_id, pt.taskbegun, pt.outsourcing, pt.m_product_id, pt.qty, pt.ismaterialdisposed
    INTO      v_project_id,    v_taskbegun,  v_outsourcing,  v_product_id,  v_qty, v_disposed
    FROM c_projecttask pt
    WHERE pt.c_projecttask_id = NEW.c_projecttask_id;
--    RAISE NOTICE '%(): v_project_id=%, new.c_projecttask_id=%, v_product_id=%, taskbegun=%, v_outsourcing=%, v_disposed=%',
--                  TG_NAME, v_project_id, new.c_projecttask_id, v_product_id,   v_taskbegun, v_outsourcing,   v_disposed;
    --IF v_outsourcing='Y' THEN
    --  RAISE EXCEPTION '%', '@zspm_NoChangeOutsourcing@';
    --END IF;
   -- if coalesce(v_qty,0)=0 or v_product_id is null  then
   --   RAISE EXCEPTION '%', '@zspm_NoChangeNoProduct@';
   -- end if;


   -- Only undispose-Process is applicable update
   /*
    if TG_OP = 'UPDATE' then
      IF ((old.qtyreceived != 0) OR (old.qtyinrequisition != 0))  THEN
         if new.m_product_id!=old.m_product_id  then
             RAISE EXCEPTION '%', '@zspm_NoChangeMatdisposed@';
         end if;
      end if;
    end if;
    */
    -- Fire Trigger on Projecttask to calculate Plan-Costs
    update c_projecttask set updated=updated where c_projecttask_id=new.c_projecttask_id;

    RETURN NEW;
  ELSE
   -- TG_OP = 'DELETE'
    SELECT
      pt.taskbegun, pt.outsourcing, pt.m_product_id, pt.qty, pt.ismaterialdisposed,
      prj.c_project_id, prj.projectcategory
    INTO
      v_taskbegun,  v_outsourcing,    v_product_id,  v_qty, v_disposed,
      v_project_id,  v_prjcat
    FROM c_projecttask pt
    LEFT JOIN c_project prj ON prj.c_project_id = pt.c_project_id
    WHERE pt.c_projecttask_id = OLD.c_projecttask_id;
--    RAISE NOTICE '%(): ,   c_project_id=%, OLD.c_projecttask_id=%, taskbegun=%, v_outsourcing=%, v_disposed=%, v_prjcat=%',
--                  TG_NAME, v_project_id,   OLD.c_projecttask_id,   v_taskbegun, v_outsourcing,   v_disposed,   v_prjcat;
  -- Stuecklisten können nur geaendert oder erstellt werden, wenn die Aufgabe nicht gestartet ist und es sich um ein Produktions-Projekt handelt.
    IF (NOT isempty(v_project_id)) THEN -- c_project.c_project_id
     -- IF (v_prjcat <> ALL (ARRAY['P', 'PRP', 'PRO'])) THEN -- toDo:
     --   RAISE EXCEPTION '%', '@zspm_NoBOMProjectNotOfTypeProd@' USING HINT = 'P, PRP, PRO';
     -- END IF;
    END IF;
    --IF (v_taskbegun = 'Y') THEN
    --  RAISE EXCEPTION '%', '@zspm_NoChangeMat_taskbegun@';
    --END IF;
    IF (v_outsourcing = 'Y') THEN
      -- RAISE EXCEPTION '%', '@zspm_NoChangeOutsourcing@';
    END IF;
  -- Keine Änderung der Stueckliste moeglich. Material ist bereits geplant oder erhalten
    IF (OLD.qtyreceived <> 0) THEN
      RAISE EXCEPTION '%', '@zspm_NoChangeMatdisposed_qtyreceived@';
    ELSEIF (OLD.qtyinrequisition <> 0) THEN
      RAISE EXCEPTION '%', '@zspm_NoChangeMatdisposed_qtyinrequisition@';
    END IF;
    -- Fire Trigger on Projecttask to calculate Plan-Costs
    UPDATE c_projecttask SET updated=updated WHERE c_projecttask_id = old.c_projecttask_id;
    RETURN OLD;
  END IF;
END;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION zspm_projecttaskdep_trg()
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
Part of Projects
CHECKS:
Restriction: 
             may not be changed, after task begun
             universal use on hr,dep,machine and ind.cost
*****************************************************/
v_started    character varying;
v_outsource character varying;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;  END IF;
  
  IF TG_OP = 'INSERT' then
      -- Fire Trigger on Projecttask to calculate Plan-Costs
      update c_projecttask set updated=updated where c_projecttask_id=new.c_projecttask_id;
      RETURN NEW;
  elsif TG_OP = 'UPDATE'  then
      if new.plannedamt != old.plannedamt then
            -- Fire Trigger on Projecttask to calculate Plan-Costs
            update c_projecttask set updated=updated where c_projecttask_id=new.c_projecttask_id;
      end if;
      RETURN NEW;
  -- Deleting
  ELSE
      -- Fire Trigger on Projecttask to calculate Plan-Costs
      update c_projecttask set updated=updated where c_projecttask_id=old.c_projecttask_id;
      RETURN OLD;
  END IF;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;


  
-- Fires after insert,delete or update on all Tables the have costs on Tasks
-- These Trigger are permanent..
-- zspm_ptaskmachineplan, ..hrplan and ..indcostplan


SELECT zsse_droptrigger('C_projecttaskexpenseplan_trg', 'C_projecttaskexpenseplan');
CREATE TRIGGER C_projecttaskexpenseplan_trg
   AFTER INSERT OR DELETE OR UPDATE 
  ON C_projecttaskexpenseplan FOR EACH ROW
  EXECUTE PROCEDURE zspm_projecttaskdep_trg();
  
CREATE OR REPLACE FUNCTION C_projecttaskexpenseplanrestr_trg()
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
Part of Projects
CHECKS:
Restriction: 
             Resstriction: Only Services may be selected
*****************************************************/
v_type    character varying:='S';
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;  END IF;
  
  IF TG_OP = 'INSERT' or TG_OP = 'UPDATE'  then
      if new.m_product_id is not null then
        select producttype into v_type from m_product where m_product_id= new.m_product_id;
      end if;
      if v_type!='S' then 
        raise exception '%', '@zspm_OnlyServiceProductToPLanSercvice@';
      end if;
      RETURN NEW;
  END IF;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
  
  SELECT zsse_droptrigger('C_projecttaskexpenseplanrestr_trg', 'C_projecttaskexpenseplan');
CREATE TRIGGER C_projecttaskexpenseplanrestr_trg
   BEFORE INSERT OR UPDATE 
  ON C_projecttaskexpenseplan FOR EACH ROW
  EXECUTE PROCEDURE C_projecttaskexpenseplanrestr_trg();
  
  
  
  
CREATE OR REPLACE FUNCTION zspm_beginprojecttask(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, Begins a TASK (Gets Material From Stock)
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message character varying:='';
v_proj    character varying;
v_stat    character varying;
v_count   numeric;
v_cat character varying;
v_datefrom date;
v_dateto date;
v_taskresp    character varying;
v_ismanager   character varying;
v_isworker varchar;
v_Org   character varying;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_org_id into v_Record_ID, v_User,v_Org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    select startdate, enddate, c_project_id into v_datefrom,v_dateto,v_proj from c_projecttask where c_projecttask_id=v_Record_ID;
    select projectcategory into v_cat from c_project where c_project_id=v_proj;
    -- Workflow
    if c_getconfigoption('projectmangerworkflow',v_Org)='Y' and v_cat not in ('PRP','PRO','B','C') then 
      -- Only Task Responsible or Project Manager can do this
      select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=v_User;
      if NOT (coalesce(v_ismanager,'N')='Y' or (coalesce(v_isworker,'N')='Y' and 
                                               (select responsible_id from c_project where c_project_id=v_proj)=v_User)) then
           RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
      end if;
    end if;
    -- Does the Date make sense
    if v_cat in ('CS','S','I','M','P') and not (coalesce(v_datefrom,now())<=coalesce(v_dateto,now())) then
       RAISE EXCEPTION '%', '@zspm_NoCorrectDates@';
    end if;
    -- Is Project started?
    select projectstatus into v_stat from c_project where c_project_id=v_proj;
    if v_stat!='OR' then
       RAISE EXCEPTION '%', '@zspm_DoNotTaskWhenProjectNotReady@';
    end if;
    -- Are all  Tasks, this task is dependent on closed
    if NOT zssm_is_dependendtasks_complete(v_Record_ID) then
       RAISE EXCEPTION '%', '@zspm_DoNotTaskWhenDependsNotReady@';
    end if;
    /*
    select count(*) into v_count from c_projecttask where m_product_id is not null and ismaterialdisposed='N' and c_projecttask_id=v_Record_ID;
    if v_count>0 and v_cat='P' then
       RAISE EXCEPTION '%', '@zspm_DoNotTaskWhenMatNotDisposed@';
    end if;
    */
    --if v_cat='P' then
          -- Get all Material from Inventory
     if c_getconfigoption('projectgetmatontaskstart',v_Org)='Y' then 
          v_Message:=v_Message||zsmf_GetMaterialFromStock(v_Record_ID,v_User);
          if v_Message='' then
             v_Message:='Materialentnahme nicht erforderlich.';
          else
             v_Message:=v_Message||'  erfolgreich erstellt.';
          end if;
    end if;
    update c_projecttask set taskbegun='Y',started=now() where c_projecttask_id=v_Record_ID;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1 , v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspm_beginprojecttask(character varying) OWNER TO tad;







CREATE OR REPLACE FUNCTION zspm_endprojecttask(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, Ends a task
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_Org    character varying;
v_message character varying:='Success';
v_count   numeric;
v_qty     numeric;
v_taskresp    character varying;
v_isoutsource character varying;
v_product     character varying;
v_gotmaterial character varying;
v_proj varchar;
v_cat varchar;
v_ismanager varchar;
v_isworker varchar;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_org_id into v_Record_ID, v_User,v_Org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    select p.c_project_id,p.projectcategory into v_proj, v_cat from c_projecttask pt,c_project p where pt.c_project_id=p.c_project_id and pt.c_projecttask_id=v_Record_ID;
    -- Workflow
    if c_getconfigoption('projectmangerworkflow',v_Org)='Y' and v_cat not in ('PRP','PRO','B','C') then 
      -- Only Task Responsible or Project Manager can do this
      select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=v_User;
      if NOT (coalesce(v_ismanager,'N')='Y' or (coalesce(v_isworker,'N')='Y' and 
                                               (select responsible_id from c_project where c_project_id=v_proj)=v_User)) then
           RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
      end if;
    end if;
    -- If Materaial Planned and in Purchasing, it schould be fetched from store.
    -- Only on Production Projects
    select count(*) into v_count from zspm_projecttaskbom bom,m_product p where p.m_product_id=bom.m_product_id and p.typeofproduct!='UA' and bom.quantity>bom.qtyreceived and bom.quantity>0 and bom.c_projecttask_id=v_Record_ID;
    --
    if v_count>0 and v_cat in ('P','PRO') then
      RAISE EXCEPTION '%', '@zspm_GetMatBeforCloseTask@';
    end if;
    --
    -- If Outsourced Task - The required material schould be fetched from stock (internal consumption)
    /*
    if v_isoutsource='Y' and v_product is not null then
        select count(*) into v_count from m_internal_consumptionline where c_projecttask_id=v_Record_ID and m_product_id=v_product and movementqty*-1>=v_qty;
        if v_count=0 then 
           RAISE EXCEPTION '%', '@zspm_OutsourceGetMatFirst@';
        end if;   
    end if;
    */
    -- Material To Inventory. 
    -- Calculate Cost for Material. --Easy -- Just take Real Costs from Task.
    select zsmf_SendMaterialOnStock(v_Record_ID,v_User) into v_Message;
    -- Set Task END
    update c_projecttask set iscomplete='Y',PERCENTDONE=100 where c_projecttask_id=v_Record_ID;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N',1 , v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspm_endprojecttask(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zspm_beginproject(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, Begins a Project
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message character varying:='Success';
v_type  character varying;
v_org   character varying; 
v_proj varchar;
v_cat varchar;
v_ismanager varchar;
v_isworker varchar;
v_datefrom date;
v_dateto date;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_org_id into v_Record_ID, v_User,v_org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    select p.c_project_id,p.projectcategory into v_proj, v_cat from c_project p where p.c_project_id=v_Record_ID;
    -- Workflow
    if c_getconfigoption('projectmangerworkflow',v_Org)='Y' and v_cat not in ('PRP','PRO','B','C') then 
      -- Only Task Responsible or Project Manager can do this
      select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=v_User;
      if NOT (coalesce(v_ismanager,'N')='Y' or (coalesce(v_isworker,'N')='Y' and 
                                               (select responsible_id from c_project where c_project_id=v_proj)=v_User)) then
           RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
      end if;
    end if;
    select projectcategory, startdate, datefinish into v_cat,v_datefrom,v_dateto from c_project where c_project_id=v_Record_ID;
    if v_cat in ('CS','S','I','M','P') and not (coalesce(v_datefrom,now())<=coalesce(v_dateto,now())) then
       RAISE EXCEPTION '%', '@zspm_NoCorrectDates@';
    end if;
    -- Set Project begun
    update c_project set projectstatus='OR',plannedmarginamt=coalesce(committedamt,0)-coalesce(estimatedamt,0) where c_project_id=v_Record_ID;
    PERFORM mrp_inoutplanupdate(null);
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspm_beginproject(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zspm_endproject(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, Begins a Project
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_proj varchar;
v_cat varchar;
v_ismanager varchar;
v_isworker varchar;
v_message character varying:='Success';
v_currentstatus character varying;
v_count   numeric;
v_org varchar;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_org_id into v_Record_ID, v_User,v_org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    select zspm_updateprojectstatus() into v_message;
    select p.c_project_id,p.projectcategory into v_proj, v_cat from c_project p where p.c_project_id=v_Record_ID;
    -- Workflow
    if c_getconfigoption('projectmangerworkflow',v_Org)='Y' and v_cat not in ('PRP','PRO','B','C') then 
      -- Only Task Responsible or Project Manager can do this
      select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=v_User;
      if NOT (coalesce(v_ismanager,'N')='Y' or (coalesce(v_isworker,'N')='Y' and 
                                               (select responsible_id from c_project where c_project_id=v_proj)=v_User)) then
           RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
      end if;
    end if;
    --BEGIN PRocessing
    select count(*) into v_count  from c_projecttask where c_project_id=v_Record_ID and iscomplete='N' and istaskcancelled='N';
    if v_count>0 then
       RAISE EXCEPTION '%', '@zspm_NoCloseProjectTaskNotComplete@';
    end if;
    select projectstatus into v_currentstatus from c_project where c_project_id=v_Record_ID;
    if v_currentstatus='OC' then 
        -- Reopen Project
        update c_project set projectstatus='OR',processed='N' where c_project_id=v_Record_ID;
    else 
        -- Set Project End (Close)
        update c_project set projectstatus='OC',percentdoneyet=100,processed='Y' where c_project_id=v_Record_ID;
        UPDATE C_PROJECTLINE SET PROCESSED = 'Y' WHERE C_PROJECT_ID = v_Record_ID;
    end if;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspm_endproject(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zspm_copyptaskbom(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): D. Heuduk
***************************************************************************************************************************************************
Part of Projects, Copy the Taskbom into this Projecttask completely
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_ismanager  character varying;
v_message character varying:='Sucess';
v_count   numeric;
v_Org    character varying;
v_Project_ID    character varying;
v_PTask_ID   character varying;
v_cur_BOM RECORD;
Cur_Parameter RECORD;
v_PBOMRT zspm_projecttaskbom%rowtype;
v_projecttask_id VARCHAR;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
  
    SELECT 	i.Record_ID,
		i.AD_User_ID,
		i.ad_org_id into 
		  v_Record_ID,
		  v_User,
		  v_org
    from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    ELSE
        FOR Cur_Parameter IN
          (SELECT para.*
           FROM ad_pinstance pi, ad_pinstance_Para para
           WHERE 1=1
            AND pi.ad_pinstance_ID = para.ad_pinstance_ID
            AND pi.ad_pinstance_ID = p_pinstance_ID
           ORDER BY para.SeqNo
          )
        LOOP        
          IF ( UPPER(Cur_Parameter.parametername) = UPPER('c_projecttask_id') ) THEN
            v_projecttask_id := Cur_Parameter.p_string;
          END IF;
          v_org:=Cur_Parameter.ad_org_id;
        END LOOP; -- Get Parameter
      END IF;
    -- TODO
    -- copy bom
    for v_cur_BOM in (SELECT * FROM zspm_projecttaskbom where c_projecttask_id=v_projecttask_id)
    LOOP
      v_PBOMRT:=v_cur_BOM;
      v_PBOMRT.zspm_projecttaskbom_id:=get_uuid();
      v_PBOMRT.c_projecttask_id:=v_Record_ID;
      v_PBOMRT.actualcosamount:=0;
      v_PBOMRT.qtyreserved:=0;
      v_PBOMRT.qtyinrequisition:=0;
      v_PBOMRT.qtyreceived:=0;
      v_PBOMRT.planrequisition:='N';
      v_PBOMRT.plannedamt:=0;
      select count(*) into v_count from snr_masterdata snr,ma_machine m where m.snr_masterdata_id=snr.snr_masterdata_id
                      and m.ismovedinprojects='Y' and snr.m_product_id=v_cur_BOM.m_product_id;
      if v_count=0 then
        INSERT INTO zspm_projecttaskbom SELECT v_PBOMRT.*; -- ROWTYPE
      end if;
    END LOOP;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;



CREATE OR REPLACE FUNCTION zspm_canceltask(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, UnDispose the complete BOM of the Task in Inventory
                  Cancel Task - Cancel PR, if open
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_proj varchar;
v_cat varchar;
v_ismanager varchar;
v_isworker varchar;
v_message character varying:='Sucess';
v_count   numeric;
v_Org    character varying;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_org_id into v_Record_ID, v_User,v_org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    select p.c_project_id,p.projectcategory into v_proj, v_cat from c_projecttask pt,c_project p where pt.c_project_id=p.c_project_id and pt.c_projecttask_id=v_Record_ID;
    -- Workflow
    if c_getconfigoption('projectmangerworkflow',v_Org)='Y' and v_cat not in ('PRP','PRO','B','C')then 
      -- Only Task Responsible or Project Manager can do this
      select bp.isprojectmanager,bp.isworker into v_ismanager,v_isworker from c_bpartner bp,ad_user ad where ad.c_bpartner_id=bp.c_bpartner_id and ad.ad_user_id=v_User;
      if NOT (coalesce(v_ismanager,'N')='Y' or (coalesce(v_isworker,'N')='Y' and 
                                               (select responsible_id from c_project where c_project_id=v_proj)=v_User)) then
           RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
      end if;
    end if;
    -- TODO
    -- Set Task as not Active -- All other Checks are done through GUI
    update c_projecttask set Istaskcancelled='Y',percentdone=100,schedulestatus='OK' where c_projecttask_id=v_Record_ID;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspm_canceltask(character varying) OWNER TO tad;


CREATE or replace FUNCTION zspm_updateprojectstatus() RETURNS character varying
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
Part of Projects, 
Updates Projects, Tasks with actual 
Costs and Schedule Status
This procedure my be called via quartz by scheduler
or in a direct variant (overloaded)
*****************************************************/
-- Simple Types
v_message character varying;
v_status  character varying;
v_ppstatus  character varying;
v_pstatus  character varying;
v_proj character varying:='';
v_percent numeric;
v_percenttimeyet numeric;

v_invoicecost numeric;
v_invoicerevenue numeric;
v_margin numeric;
v_marginperc numeric;
v_orderedamt numeric;
v_glcost numeric;
v_machinecost numeric;
v_materialcost numeric;
v_workcost numeric;
v_indirectcost numeric;
-- RECORD
v_cur            RECORD;
v_cur2           RECORD;
-- Planned amts
v_machinecostplan numeric;
v_materialcostplan numeric;
v_workcostplan numeric;
v_indirectcostplan numeric;
v_marginplan numeric;
v_marginpercplan numeric;
v_expensesplan numeric;
v_IEmpCost numeric;
v_IMatCost numeric;
v_IMachCost numeric;
v_IVendCost numeric;
v_extservicecost numeric;
v_extservicecostplan numeric;
BEGIN 

    --@TODO : Make Calculation of Scheduling configurabble (Now: 4 Days-Hardcoded)
    -- Not Scheduled Projects (<4 Days)  have always Status 'OK'
    -- Schedulestatus: OK-In Time , CR-Critical, OP-Out of Plan
    for v_cur in (select pt.c_projecttask_id,coalesce(pt.percentdone,10) as percentdone,
                         pt.c_project_id,coalesce(pt.startdate,now()) as startdate,coalesce(pt.enddate,now()) as enddate 
                         from c_projecttask pt,c_project pp 
                         where pt.c_project_id=pp.c_project_id
                         and pp.c_project_id in (select c_project_id from c_project where projectstatus='OR' and projectcategory in ('CS','S','I','M','P'))
                         and pt.iscomplete='N' and pt.Istaskcancelled='N' and pt.outsourcing='N'
                         and pt.enddate is not null and pt.startdate is not null
                         and to_number(pt.enddate-pt.startdate)>4
                         and pt.enddate is not null and pt.startdate is not null
                         and pp.datefinish is not null and pp.startdate is not null
                         order by pp.c_project_id)
    loop
        v_status:='OK';
        BEGIN
            v_percenttimeyet:=100-100/(to_number(v_cur.enddate-v_cur.startdate)/to_number(v_cur.enddate-now()));
        EXCEPTION
            WHEN OTHERS THEN
                v_percenttimeyet:=0;
        END;
        -- Get amounts
        -- New Project?
        if v_cur.c_project_id!=v_proj then
            v_proj:=v_cur.c_project_id;
            -- Calculate Project Status 
            -- Cost: From Actual Costs (Tasks)
            -- Percend-Done from HR-Plan and Task-Percent done..weighted factor...
            -- TODO : UOM is not relevant : should be corrected (We assume the same UOM for all calcs. e.g. hour)
            -- TODO : Eventually calculate Maschine-Plan in weighted factor as well?
            BEGIN
                select sum(coalesce(percentdone,0))/count(c_projecttask_id) into v_percent from c_projecttask where c_project_id=v_proj group by c_project_id;
             EXCEPTION
            WHEN OTHERS THEN
                v_percent:=100;
            END;
            RAISE NOTICE '%','Project:'||v_proj;
            update c_project set PERCENTDONEYET= coalesce(v_percent,0) where c_project_id=v_proj;
            v_pstatus:='OK';
         end if;    

		
        -- Schedule-Status
        -- now is Between planed time period, the Time Period must be at least 2 Days
        if (v_cur.startdate<now() and v_cur.enddate>now()) and to_number(v_cur.enddate-v_cur.startdate)>1 then 
            -- Time-Period > 4 Days: If more than 80% are Done the critical status comes quicker
            if v_percenttimeyet>=80 and to_number(v_cur.enddate-v_cur.startdate)>10 then
              if (v_percenttimeyet-v_cur.percentdone)>=5 then
                  v_status:='CR';
                  if v_pstatus='OK' then v_pstatus:='CR'; end if;
                  if v_ppstatus='OK' then v_ppstatus:='CR'; end if;
              end if;
              if (v_percenttimeyet-v_cur.percentdone)>=10 then
                  v_status:='OP';
                  v_ppstatus:='OP';
                  v_pstatus:='OP';
              END IF;
            else
              if (v_percenttimeyet-v_cur.percentdone)>=15 then
                  v_status:='CR';
                  if v_pstatus='OK' then v_pstatus:='CR'; end if;
                  if v_ppstatus='OK' then v_ppstatus:='CR'; end if;
              end if;
              if (v_percenttimeyet-v_cur.percentdone)>=25 then
                  v_status:='OP';
                  v_ppstatus:='OP';
                  v_pstatus:='OP';
              END IF;
            end if;
        else
           if v_cur.enddate<(now()-1) and v_cur.percentdone<100 then
              v_status:='OP';
              v_ppstatus:='OP';
              v_pstatus:='OP';
           end if;
        end if;
        --   
        update c_projecttask set schedulestatus= case when percentdone>99 then 'OK' else v_status end where c_projecttask_id=v_cur.c_projecttask_id;
        update c_project set schedulestatus=case when percentdoneyet>99 then 'OK' else v_pstatus end  where c_project_id=v_cur.c_project_id;        
    end loop;
    

    --  3 Loops
    -- TASK-COSTS:
    for v_cur in (select pt.c_projecttask_id,pp.projectcategory,pp.projectstatus  from c_projecttask pt,c_project pp 
                         where pt.c_project_id=pp.c_project_id
                         and pp.c_project_id in (select c_project_id from c_project where projectstatus in ('OR','OP') and projectcategory in ('CS','S','I','M','P','PRO')))
    loop
         if v_cur.projectstatus='OR' then
            -- Sales - ORDER-lines on tasks.
            select sum(coalesce(linenetamt,0)) into v_orderedamt
                                    from c_order ,c_orderline
                                    where c_order.c_order_id=c_orderline.c_order_id and c_orderline.c_projecttask_id=v_cur.c_projecttask_id and
                                    c_order.docstatus = 'CO' and
                                    c_order.issotrx='Y'
                                    and ad_get_docbasetype(c_order.c_doctype_id)='SOO';
         else -- Offers
            select sum(coalesce(linenetamt,0)) into v_orderedamt
                                    from c_order ,c_orderline
                                    where c_order.c_order_id=c_orderline.c_order_id and c_orderline.c_projecttask_id=v_cur.c_projecttask_id and
                                    c_order.docstatus = 'CO' and
                                    c_order.issotrx='Y'
                                    and ad_get_docbasetype(c_order.c_doctype_id)='SALESOFFER' and c_isofferrelevant(c_order.c_order_id)='Y';
         end if;
          -- Sales - invoice-lines on tasks (AR Credit Memo's count negative)
         select sum(case when ad_get_docbasetype(c_invoice.c_doctype_id)='ARC' then coalesce(linenetamt,0)*-1 else coalesce(linenetamt,0) end) into v_invoicerevenue
                                from c_invoice ,c_invoiceline
                                where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and c_invoiceline.c_projecttask_id=v_cur.c_projecttask_id and
                                c_invoiceline.c_invoice_id=c_invoice.c_invoice_id and c_invoice.docstatus = 'CO' and
                                c_invoice.issotrx='Y';
         -- Purchase - invoice-lines on tasks (AP Credit Memo's count negative)
         -- Do NOT Count Items that are Stocked.
         -- Without external services
         select sum(case when ad_get_docbasetype(c_invoice.c_doctype_id)='APC' then coalesce(linenetamt,0)*-1 else coalesce(linenetamt,0) end)  into v_invoicecost
                                from c_invoice ,c_invoiceline
                                left join m_product on c_invoiceline.m_product_id=m_product.m_product_id 
                                where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and   c_invoiceline.c_projecttask_id=v_cur.c_projecttask_id and
                                case  coalesce(c_invoiceline.m_product_id,'') when '' then 1=1 else (m_product.producttype='S' or (m_product.producttype='I' and m_product.isstocked='N')) end 
                                and c_invoice.docstatus = 'CO' and
                                c_invoice.issotrx='N' and
                                (select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=c_invoiceline.m_product_id) = 'N';
         -- Purchase - invoice-lines on tasks (AP Credit Memo's count negative)
         -- Do NOT Count Items that are Stocked.
         -- EXTERNAL services
         select sum(case when ad_get_docbasetype(c_invoice.c_doctype_id)='APC' then coalesce(linenetamt,0)*-1 else coalesce(linenetamt,0) end)  into v_extservicecost
                                from c_invoice ,c_invoiceline
                                left join m_product on c_invoiceline.m_product_id=m_product.m_product_id 
                                where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and   c_invoiceline.c_projecttask_id=v_cur.c_projecttask_id and
                                case  coalesce(c_invoiceline.m_product_id,'') when '' then 1=1 else (m_product.producttype='S' or (m_product.producttype='I' and m_product.isstocked='N')) end 
                                and c_invoice.docstatus = 'CO' and
                                c_invoice.issotrx='N' and
                                (select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=c_invoiceline.m_product_id) = 'Y';
         -- G/L Manual Bookings on Tasks
         select coalesce(sum(round(case when ml.isgross='N' or t.rate=0 then ml.amt*case when ml.isdr2cr='Y' then 1 else -1 end else case when ml.isdr2cr='Y' then 1 else -1 end * ml.amt-ml.amt/(1+100/t.rate) end,2)),0)
                                                                                                     into v_glcost from zsfi_macctline ml, zsfi_manualacct mic,c_tax t 
                                                                                                     where  ml.c_projecttask_id=v_cur.c_projecttask_id and
                                                                                                     t.c_tax_id=ml.c_tax_id and
                                                                                                     mic.zsfi_manualacct_id=ml.zsfi_manualacct_id and 
                                                                                                     mic.glstatus='PO'; 
         
         -- Material from Stock through BOM-Processing (Value set by Internal Material Consumptions)
         select sum(coalesce(actualcosamount,0)) into v_materialcost from zspm_projecttaskbom where c_projecttask_id=v_cur.c_projecttask_id;
         -- Work Costs&Machine Costs
         select sum(coalesce(actualcostamount,0)) into v_workcost from zspm_ptaskfeedbackline ptl
                                                   where ptl.c_projecttask_id=v_cur.c_projecttask_id  and
                                                   ptl.ad_user_id is not null;
         select sum(coalesce(actualcostamount,0)) into v_machinecost from zspm_ptaskfeedbackline ptl
                                                   where ptl.c_projecttask_id=v_cur.c_projecttask_id and
                                                   ptl.ma_machine_id is not null;
         -- Indirect Costs
         v_indirectcost:=0;
         if v_machinecost is null then v_machinecost:=0; end if;
         if v_glcost is null then v_glcost:=0; end if;
         if v_workcost is null then v_workcost:=0; end if;
         if v_materialcost is null then v_materialcost:=0; end if;
         if v_invoicecost is null then v_invoicecost:=0; end if;
         if v_invoicerevenue is null then v_invoicerevenue:=0; end if;
         if v_orderedamt is null then v_orderedamt:=0; end if;
         if v_extservicecost is null then v_extservicecost:=0; end if;
         for v_cur2 in (select ma_indirect_cost_id from zspm_ptaskindcostplan where c_projecttask_id=v_cur.c_projecttask_id)
         loop
            --v_indirectcost:=v_indirectcost+(((v_invoicecost+v_workcost+v_machinecost+v_materialcost+v_glcost)*v_cur2.cost)/100);
            select p_empcost,p_machinecost,p_matcost,p_vendorcost into v_IEmpCost ,v_IMachCost,v_IMatCost,v_IVendCost from
                  zsco_get_indirect_cost(v_cur2.ma_indirect_cost_id,now(),'P',v_cur.c_projecttask_id,'fact',null);
                  
             v_indirectcost:=v_indirectcost + round(v_workcost*v_IEmpCost/100,2) + v_IMatCost  +
                                              round(v_machinecost*v_IMachCost/100,2) + v_IVendCost ;
            --update zspm_ptaskindcostplan set actualcostamount=(((coalesce(v_invoicecost,0)+coalesce(v_workcost,0)+coalesce(v_machinecost,0)+coalesce(v_materialcost,0)+coalesce(v_internalconsumptioncost,0))*v_cur2.cost)/100)
            --       where c_projecttask_id=v_cur.c_projecttask_id and ma_indirect_cost_id=v_cur2.ma_indirect_cost_id;
         end loop;
         update c_projecttask set materialcost=v_materialcost,
                                  machinecost=v_machinecost,
                                  expenses=v_invoicecost+v_glcost,
                                  externalservice=v_extservicecost,
                                  servcost=v_workcost,
                                  indirectcost=v_indirectcost,
                                  invoicedamt=v_invoicerevenue,
                                  committedamt=v_orderedamt,
                                  actualcost=v_materialcost+v_machinecost+v_invoicecost+v_glcost+v_workcost+v_indirectcost+v_extservicecost
                                  where c_projecttask_id=v_cur.c_projecttask_id;
     end loop;
   
   
     -- Project-Costs
    for v_cur in (select c_project_id,projectstatus from c_project where projectstatus in ('OR','OP') and projectcategory in ('CS','S','I','M','P','PRO'))
    loop
         if v_cur.projectstatus='OR' then
            -- Sales - ORDER-lines on Project.
            select sum(coalesce(linenetamt,0)) into v_orderedamt
                                    from c_order ,c_orderline
                                    where c_order.c_order_id=c_orderline.c_order_id and c_orderline.c_project_id=v_cur.c_project_id and
                                    c_order.docstatus = 'CO' and
                                    c_order.issotrx='Y'
                                    and ad_get_docbasetype(c_order.c_doctype_id)='SOO';
         else -- Offers
             -- Sales - ORDER-lines on Project.
            select sum(coalesce(linenetamt,0)) into v_orderedamt
                                    from c_order ,c_orderline
                                    where c_order.c_order_id=c_orderline.c_order_id and c_orderline.c_project_id=v_cur.c_project_id and
                                    c_order.docstatus = 'CO' and
                                    c_order.issotrx='Y'
                                    and ad_get_docbasetype(c_order.c_doctype_id)='SALESOFFER' and c_isofferrelevant(c_order.c_order_id)='Y';
         end if;
         -- Sales - invoice-lines on Project (AR Credit Memo's count negative)
         select sum(case when ad_get_docbasetype(c_invoice.c_doctype_id)='ARC' then coalesce(linenetamt,0)*-1 else coalesce(linenetamt,0) end) into v_invoicerevenue
                                from c_invoice ,c_invoiceline
                                where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and c_invoiceline.c_project_id=v_cur.c_project_id and
                                c_invoiceline.c_invoice_id=c_invoice.c_invoice_id and c_invoice.docstatus = 'CO' and
                                c_invoice.issotrx='Y';
         -- Purchase - invoice-lines on Project (AP Credit Memo's count negative)
         -- Do NOT Count Items that are Stocked.
         -- Without external services
         select sum(case when ad_get_docbasetype(c_invoice.c_doctype_id)='APC' then coalesce(linenetamt,0)*-1 else coalesce(linenetamt,0) end)  into v_invoicecost
                                from c_invoice ,c_invoiceline
                                left join m_product on c_invoiceline.m_product_id=m_product.m_product_id 
                                where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and   c_invoiceline.c_project_id=v_cur.c_project_id and
                                case  coalesce(c_invoiceline.m_product_id,'') when '' then 1=1 else (m_product.producttype='S' or (m_product.producttype='I' and m_product.isstocked='N')) end 
                                and c_invoice.docstatus = 'CO' and
                                c_invoice.issotrx='N' and
                                (select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=c_invoiceline.m_product_id) = 'N';
         -- Purchase - invoice-lines on Project (AP Credit Memo's count negative)
         -- Do NOT Count Items that are Stocked.
         -- EXTERNAL services                       
         select sum(case when ad_get_docbasetype(c_invoice.c_doctype_id)='APC' then coalesce(linenetamt,0)*-1 else coalesce(linenetamt,0) end)  into v_extservicecost 
                                from c_invoice ,c_invoiceline
                                left join m_product on c_invoiceline.m_product_id=m_product.m_product_id 
                                where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and   c_invoiceline.c_project_id=v_cur.c_project_id and
                                case  coalesce(c_invoiceline.m_product_id,'') when '' then 1=1 else (m_product.producttype='S' or (m_product.producttype='I' and m_product.isstocked='N')) end 
                                and c_invoice.docstatus = 'CO' and
                                c_invoice.issotrx='N' and
                                (select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=c_invoiceline.m_product_id) = 'Y';                                
         -- G/L Manual Bookings on Project
         select coalesce(sum(round(case when ml.isgross='N' or t.rate=0 then ml.amt*case when ml.isdr2cr='Y' then 1 else -1 end else case when ml.isdr2cr='Y' then 1 else -1 end * ml.amt-ml.amt/(1+100/t.rate) end,2)),0)
                                                                                                     into v_glcost from zsfi_macctline ml, zsfi_manualacct mic,c_tax t 
                                                                                                     where  ml.c_project_id=v_cur.c_project_id and
                                                                                                     t.c_tax_id=ml.c_tax_id and
                                                                                                     mic.zsfi_manualacct_id=ml.zsfi_manualacct_id and 
                                                                                                     mic.glstatus='PO'; 
                                                                                                                                                                 
                                                                                    
        select sum(coalesce(materialcost,0)),sum(coalesce(machinecost,0)),sum(coalesce(indirectcost,0)),sum(coalesce(servcost,0)),
               sum(coalesce(materialcostplan,0)),sum(coalesce(machinecostplan,0)),sum(coalesce(indirectcostplan,0)),sum(coalesce(servcostplan,0)),sum(coalesce(expensesplan,0)),sum(coalesce(externalserviceplan,0))
        into v_materialcost,v_machinecost,v_indirectcost,v_workcost,v_materialcostplan,v_machinecostplan,v_indirectcostplan,v_workcostplan,v_expensesplan,v_extservicecostplan
        from c_projecttask where c_project_id=v_cur.c_project_id and istaskcancelled='N';
       
        if v_machinecost is null then v_machinecost:=0; end if;
        if v_indirectcost is null then v_indirectcost:=0; end if;
        if v_workcost is null then v_workcost:=0; end if;
        if v_materialcost is null then v_materialcost:=0; end if;
       
        if v_invoicecost is null then v_invoicecost:=0; end if;
        if v_extservicecost is null then v_extservicecost:=0; end if;
        if v_invoicerevenue is null then v_invoicerevenue:=0; end if;
        if v_orderedamt is null then v_orderedamt:=0; end if;
        if v_glcost is null then v_glcost:=0; end if;
       
        if v_machinecostplan is null then v_machinecostplan:=0; end if;
        if v_workcostplan is null then v_workcostplan:=0; end if;
        if v_materialcostplan is null then v_materialcostplan:=0; end if;
        if v_indirectcostplan is null then v_indirectcostplan:=0; end if;
        if v_expensesplan is null then v_expensesplan:=0; end if;
        if v_extservicecostplan is null then v_extservicecostplan:=0; end if;
       
        if v_orderedamt=0 then 
            v_marginplan:=0; 
            v_marginpercplan:=0;
        else
            v_marginplan:= v_orderedamt - (v_materialcostplan+v_machinecostplan+v_workcostplan+v_indirectcostplan+v_expensesplan+v_extservicecostplan);
            v_marginpercplan:= (v_marginplan/v_orderedamt) *100;
        end if;
        if v_invoicerevenue=0 then 
            v_margin:=0; 
            v_marginperc:=0;
        else
            v_margin:= v_invoicerevenue - (v_materialcost+v_machinecost+v_invoicecost+v_glcost+v_workcost+v_indirectcost+v_extservicecost);
            v_marginperc:= (v_margin/v_invoicerevenue)*100;
        end if;
      
       
        update c_project set materialcost=v_materialcost,
                                  machinecost=v_machinecost,
                                  expenses=v_invoicecost+v_glcost,
                                  externalservice=v_extservicecost,
                                  servcost=v_workcost,
                                  indirectcost=v_indirectcost,
                                  invoicedamt=v_invoicerevenue,
                                  committedamt=v_orderedamt,
                                  materialcostplan=v_materialcostplan,
                                  machinecostplan=v_machinecostplan,
                                  servcostplan=v_workcostplan,
                                  indirectcostplan=v_indirectcostplan,
                                  actualcostamount=v_materialcost+v_machinecost+v_invoicecost+v_glcost+v_workcost+v_indirectcost+v_extservicecost,
                                  plannedamt = v_materialcostplan+v_machinecostplan+v_workcostplan+v_indirectcostplan+v_expensesplan+v_extservicecostplan,
                                  plannedmarginamt=v_marginplan,
                                  plannedmarginpercent=v_marginpercplan,
                                  marginamt=v_margin,
                                  marginpercent=v_marginperc,
                                  expensesplan=v_expensesplan,
                                  externalserviceplan=v_extservicecostplan
                                  where  c_project_id=v_cur.c_project_id;
     end loop;
    -- Finishing
    v_message:='Update Project Status successfully finished. ';
    return v_message;
END;
$_$  LANGUAGE 'plpgsql';
      


CREATE OR REPLACE FUNCTION zspm_updateprojectstatus(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, 
Updates Projects, Tasks with actual 
Costs and Schedule Status
Direct call variant (overloaded)
*****************************************************/
v_message character varying:='error';
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    -- Call the Proc
    select zspm_updateprojectstatus() into v_message;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;



  
CREATE OR REPLACE FUNCTION zspm_standardFeedbacklineFilter()
  RETURNS timestamp AS
$BODY$ 
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2013 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

Sets the Standard Filter for Task Feedback Line from the TIMEFEEDBACKTHRESHHOLD

C857DA48B0FE48CA9FB12D4CC8C99223 -> Time feedback Window

*/
v_isonlyown varchar;
v_houstosee numeric;
BEGIN
   
     select to_number(value) into v_houstosee from ad_preference where attribute='TIMEFEEDBACKTHRESHHOLD' and ad_window_id='C857DA48B0FE48CA9FB12D4CC8C99223';
     return now()-(coalesce(v_houstosee,480)/24);
   
END ; $BODY$ LANGUAGE 'plpgsql' VOLATILE COST 100;

  



CREATE OR REPLACE FUNCTION zspm_ptaskfeedbackline_trg (
)
RETURNS trigger AS
-- BEFORE INSERT OR UPDATE 
$body$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Projects
CHECKS:
Restriction: 
            Only Responsible Person may take actions as Machine feedback
*****************************************************/
DECLARE 
  v_ismanager   VARCHAR;
  v_count       NUMERIC;
  v_salary_id   VARCHAR;
  v_cost        NUMERIC;
 -- p_cost        NUMERIC;

  v_nightcost       NUMERIC:=0;
  v_overtimecost       NUMERIC:=0;
  v_addfeeId    varchar;
  v_Hours       NUMERIC;
  v_c_projecttask c_projecttask%ROWTYPE;
  v_sp1 numeric:=0;
v_sp2 numeric:=0;
v_tr numeric:=0;
  v_cur record;
  v_bpartner varchar;
  v_nomalhours numeric;
  v_midwork numeric;
  v_nightendhour timestamp;
  v_hourfrom  timestamp;
  v_hourto timestamp;
  v_fridytosatday varchar:='N';
  v_overnight varchar:='N';
BEGIN
 -- INSERT OR UPDATE
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;  END IF;

  SELECT * FROM c_projecttask pt
  INTO v_c_projecttask -- ROWTYPE
  WHERE pt.c_projecttask_id = NEW.c_projecttask_ID;
  
  -- Check Status
  IF (v_c_projecttask.outsourcing <> 'N') THEN
    RAISE EXCEPTION '%', '@zspm_NoTimeFeedbackOnProjecttask_outsourcing@';
  END IF;
  
  if (new.ad_user_id is null and new.ma_machine_id is null) or (new.ad_user_id is not null and new.ma_machine_id is not null) then
     RAISE EXCEPTION '%', '@zspm_SelectUser@';
  end if;
  -- Cost for machines 
  IF  new.ma_machine_id IS NOT NULL THEN
     select max(Cost) into v_cost from MA_Machine_Cost where MA_Machine_id=new.ma_machine_id and validfrom<=new.workdate and costuom=new.costuom;
     if (v_cost is null) then
        RAISE EXCEPTION '%', '@zspm_NotCostApplies@';
     end if;
  ELSE
     -- cost for humans
     -- if not applied, select it from users - cost
     IF (NEW.c_salary_category_id IS NULL) THEN
    --  RAISE NOTICE 'TG_NAME=''%'', new.ad_user_id=%', TG_NAME, new.ad_user_id; 
        SELECT min(C_Salary_Category_id) 
        INTO v_salary_id from c_bpartner 
        WHERE c_bpartner_id = 
                   (select c_bpartner_id from ad_user where ad_user_id=new.ad_user_id) 
        AND isactive='Y';
        IF (v_salary_id IS NOT NULL) THEN
          NEW.c_salary_category_id := v_salary_id; 
        END IF;
     ELSE
        -- Select the applied cost
        v_salary_id := NEW.c_salary_category_id;
     END IF;
     
     if v_salary_id is not null then
           --select max(cost) into v_cost from c_salary_category_cost where  C_Salary_Category_id=v_salary_id and costuom='H' and datefrom<=new.workdate;
        select p_cost, p_specialtime1, p_specialtime2 into v_cost, v_sp1,v_sp2 from zsco_get_salary_cost(v_salary_id,new.workdate,'H');
        
           end if;         
     if (v_salary_id is null) then
        RAISE EXCEPTION '%', '@zspm_NotCostApplies@';
     end if;
           if (v_cost is null) then
        RAISE EXCEPTION '%', '@zspm_NotCostApplies@';
     end if;  
  END IF;
  v_hourfrom:=NEW.hour_from;
  v_hourto:=NEW.hour_to;
  IF (v_hourfrom IS NOT NULL) AND (v_hourto IS NOT NULL) THEN
  -- For date and timestamp values, the number of seconds since 1970-01-01 00:00:00 UTC
    v_Hours := (SELECT ((EXTRACT (EPOCH FROM (v_hourto - v_hourfrom))) / 3600)); -- ::NUMERIC, calculate even leap year
    -- Work around the nicht into the next day....
    if v_Hours < 0 then 
        v_Hours:= (24 + v_Hours);
    end if;
    v_Hours:=v_Hours-coalesce(new.breaktime,0);
    NEW.hours := round(v_Hours, 2); -- 15 min = 0.25 hours
    -- Fist reset all additional fees
    new.issunday:='N';
    new.issaturday:='N';
    new.isholiday:='N';
    new.nighthours:=0;
    new.overtimehours:=0;
    -- Regelarbeitszeit (NUR Personen)
    select c_bpartner_id into v_bpartner from ad_user where ad_user_id=new.ad_user_id;
    select c_getemployeeworktimeNormal(v_bpartner,NEW.workdate) into v_nomalhours;
    -- Additional Fees (Only for Humans...)
    select c_additionalfees_id into v_addfeeId from c_additionalfees where ad_org_id in ('0',new.ad_org_id) and 
           case when new.ma_machine_id IS NOT NULL then 1=0 else 1=1 end and validfrom <=new.workdate and isactive='Y' order by  ad_org_id desc,validfrom desc limit 1; 
    for v_cur in (select  saturday as fee, 'saturday' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees where c_additionalfees_id=v_addfeeId and saturday is not null
                  UNION
                  select  sunday as fee, 'sunday' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees  where c_additionalfees_id=v_addfeeId and sunday is not null
                  UNION
                  select  holiday as fee, 'holiday' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees  where c_additionalfees_id=v_addfeeId and holiday is not null
                  UNION
                  select  night as fee, 'night' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees  where c_additionalfees_id=v_addfeeId and night is not null and nightbegin is not null 
                                                   and nightend is not null
                  UNION
                  select  overtime as fee, 'overtime' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees  where c_additionalfees_id=v_addfeeId and overtime is not null and overtimebegin is not null
                  ORDER BY fee desc)
    LOOP
        -- Night shift Work....
        if v_hourto<v_hourfrom then 
            v_overnight:='Y';
        end if;
        if v_hourfrom<v_cur.nightend then 
            v_hourfrom:=v_hourfrom + INTERVAL '24 hours';
        end if;
        if v_cur.nightend<v_cur.nightbegin then 
            v_cur.nightend:=v_cur.nightend + INTERVAL '24 hours';
        end if;
        if v_hourto<v_hourfrom then 
            v_hourto:=v_hourto + INTERVAL '24 hours';
        end if;
        if v_cur.ident='sunday' and (select dayname from c_workcalender where trunc(workdate)=trunc(new.workdate))='7' then
            new.issunday:='Y';
            v_cost:=round((v_cost*v_cur.fee/100)+v_cost,2);
            -- Includes Monday morning hours :
            -- all the night (and more) ?
            -- Worked to morning
            if v_hourto>=v_cur.nightbegin then 
                if v_hourto>=v_cur.nightend then 
                    new.nighthours:=extract(hour from v_cur.nightend)+extract(minute from v_cur.nightend)/60;
                else
                   -- Worked in next day?
                   if v_overnight='Y' then
                        new.nighthours:= (extract(hour from v_hourto)+extract(minute from v_hourto)/60) ;
                   end if;
                end if;
            end if;
            EXIT;
        elsif v_cur.ident='saturday' and (select dayname from c_workcalender where trunc(workdate)=trunc(new.workdate))='6' then
            new.issaturday:='Y';
            v_cost:=round((v_cost*v_cur.fee/100)+v_cost,2);
            EXIT;
        elsif v_cur.ident='holiday' and ((select isholiday from c_workcalender where trunc(workdate)=trunc(new.workdate))='Y' or (
                                      select isholyday from C_CALENDAREVENT,C_WORKCALENDAREVENT where C_CALENDAREVENT.C_CALENDAREVENT_id=C_WORKCALENDAREVENT.C_CALENDAREVENT_ID  and C_WORKCALENDAREVENT.ad_org_id=new.ad_org_id
                                      and new.workdate between datefrom and  coalesce(dateto,datefrom) order by isholyday desc limit 1)='Y') then
            new.isholiday:='Y';
            v_cost:=round((v_cost*v_cur.fee/100)+v_cost,2);
            EXIT;
        elsif v_cur.ident='night'  then
        --raise exception '%','NIGHT!';
            -- From night to morning - On Friday
            if (select dayname from c_workcalender where trunc(workdate)=trunc(new.workdate))='5' then 
                -- Worked to next morning -> Saturday add. fee
                -- Worked in next day?
                if v_overnight='Y' then
                    v_nightendhour:='0001-01-02 00:00:00 BC'::timestamp;
                    v_fridytosatday:='Y';
                else
                    v_nightendhour:=v_hourto;
                end if;
                -- From night to morning
                if v_hourfrom>v_cur.nightbegin and v_nightendhour>=v_cur.nightend then
                    new.nighthours:=(SELECT ((EXTRACT (EPOCH FROM (v_hourfrom - v_cur.nightend))) / 3600)) *(-1);
                -- all the night (and more)
                elsif v_hourfrom<=v_cur.nightbegin and v_nightendhour>=v_cur.nightend then
                    new.nighthours:=(SELECT ((EXTRACT (EPOCH FROM (v_cur.nightbegin - v_cur.nightend))) / 3600)) *(-1);
                -- within the night 
                elsif v_hourfrom>=v_cur.nightbegin and v_nightendhour<=v_cur.nightend then
                    new.nighthours:=(SELECT ((EXTRACT (EPOCH FROM (v_nightendhour - v_hourfrom))) / 3600));
                -- from evening to night
                else
                    new.nighthours:=(SELECT ((EXTRACT (EPOCH FROM (v_nightendhour - v_cur.nightbegin))) / 3600));
                end if;
            else -- Monday till Do.
                -- From night to morning
                if v_hourfrom>v_cur.nightbegin and v_hourto>=v_cur.nightend then
                    new.nighthours:=(SELECT ((EXTRACT (EPOCH FROM (v_hourfrom - v_cur.nightend))) / 3600)) *(-1);
                -- all the night (and more)
                elsif v_hourfrom<=v_cur.nightbegin and v_hourto>=v_cur.nightend then
                    new.nighthours:=(SELECT ((EXTRACT (EPOCH FROM (v_cur.nightbegin - v_cur.nightend))) / 3600)) *(-1);
                -- within the night 
                elsif v_hourfrom>=v_cur.nightbegin and v_hourto<=v_cur.nightend then
                    new.nighthours:=(SELECT ((EXTRACT (EPOCH FROM (v_hourto - v_hourfrom))) / 3600));
                -- from evening to night
                else
                    new.nighthours:=(SELECT ((EXTRACT (EPOCH FROM (v_hourto - v_cur.nightbegin))) / 3600));
                end if;
            end if;
            if new.nighthours < 0 then new.nighthours:=0; end if;
            -- Breaktime to Nighthours, if possible....
            -- We calculate the half of the worktime. If this is in the night, we assume braktime during nighthours
            if new.nighthours-coalesce(new.breaktime,0) > 0 then
                v_midwork:=(SELECT ((EXTRACT (EPOCH FROM (v_hourto - v_hourfrom))) / (3600*2)));
                if v_hourfrom+ INTERVAL '1 hours' * v_midwork between v_cur.nightbegin and v_cur.nightend then
                    new.nighthours:=new.nighthours-coalesce(new.breaktime,0);
                end if;
            end if;
            v_nightcost:=round((((v_cost*v_cur.fee/100)+v_cost)*new.nighthours),2);
            --EXIT;
        elsif v_cur.ident='overtime' and (v_Hours>v_nomalhours) and v_fridytosatday='N' then
            new.overtimehours:=v_Hours-v_nomalhours-new.nighthours;
            if new.overtimehours <0 then new.overtimehours:=0; end if;
            v_overtimecost:=round((((v_cost*v_cur.fee/100)+v_cost)*new.overtimehours),2);
            EXIT;
        end if;
    END LOOP;
  ELSEIF NEW.dayhours IS NOT NULL THEN
    NEW.hours := to_number(NEW.dayhours)*8;
  ELSEIF TG_OP = 'INSERT' AND (NEW.hour_from IS NOT NULL) AND (NEW.hour_to IS NULL) THEN
  -- calculated when Time Begin was set by PDC
    NEW.hours := 0;
  END IF;
  
  IF (NEW.hours IS NOT NULL) THEN
    v_cost := (v_cost * (NEW.hours-new.nighthours-new.overtimehours)) + v_overtimecost + v_nightcost+(coalesce(new.specialtime,0)*v_sp1)+(coalesce(new.specialtime2,0)*v_sp2)+coalesce(new.triggeramt,0);
  ELSE                                                                                                                                   
    RAISE EXCEPTION '%', '@zspm_NeedToGiveHours4Feedback@';
  END IF;
      
  NEW.actualcostamount := v_cost;
  NEW.isprocessed:='Y';
  
  RETURN NEW;
END;
$body$
LANGUAGE 'plpgsql';



/*****************************************************+
Stefan Zimmermann, 01/2011, stefan@zimmermann-software.de
   Implementation of Project-Feedback WEBSERVICE
*****************************************************/

CREATE OR REPLACE FUNCTION zspm_giveFeedback(p_employeeID character varying, p_workdate character varying,p_projectID character varying, p_PhaseID character varying, p_taskID character varying, p_hour_from character varying, p_hour_to character varying)
  RETURNS character varying AS
$BODY$ 
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
Part of Projects, UnDispose the complete BOM of the Task in Inventory
                  Cancel Task - Cancel PR, if open
Checks
*****************************************************/

v_count       numeric;
v_uid         character varying;
v_wdate       timestamp without time zone;
v_from        timestamp without time zone;
v_to          timestamp without time zone;
v_client      character varying;
v_DocumentNo  character varying;
v_org         character varying;
BEGIN
   v_wdate=to_date(p_workdate,'dd.mm.yyyy');
   v_from=to_timestamp(substr(p_hour_from,12,5),'hh24:mi');
   v_to=to_timestamp(substr(p_hour_to,12,5),'hh24:mi');
   v_uid=get_uuid();
   select ad_client_id,ad_org_id into v_client,v_org from c_project where c_project_id=p_projectID;
   if (v_client is not null and v_org is not null) then
      SELECT * INTO  v_DocumentNo FROM Ad_Sequence_Doc('DocumentNo_zspm_ptaskfeedback', v_org, 'Y') ;
      insert into ZSPM_PTASKFEEDBACK (ZSPM_PTASKFEEDBACK_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY,  UPDATEDBY, DOCUMENTNO, C_PROJECT_ID, C_PROJECTTASK_ID, AD_USER_ID, DESCRIPTION, WORKDATE,ismanual)
              values (v_uid,v_client,v_org,'0','0',v_DocumentNo,p_projectID,p_taskID,p_employeeID,'Generated by External System',v_wdate,'N');
      insert into ZSPM_PTASKFEEDBACKLINE (ZSPM_PTASKFEEDBACKLINE_ID, ZSPM_PTASKFEEDBACK_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, C_PROJECT_ID, C_PROJECTTASK_ID, AD_USER_ID, WORKDATE, HOUR_FROM, HOUR_TO)
              values(get_uuid(),v_uid,v_client,v_org,'0','0',p_projectID,p_taskID,p_employeeID,v_wdate,v_from,v_to);
      PERFORM zspm_processfeedback(v_uid);
      RETURN 'OK: DocumentNo: '||v_DocumentNo;
   else
      RETURN 'ERROR: No Organization';
   END IF; 
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspm_giveFeedback(p_employeeID character varying, p_workdate character varying,p_projectID character varying, p_PhaseID character varying, p_taskID character varying, p_hour_from character varying, p_hour_to character varying) OWNER TO tad;








/*****************************************************+
Stefan Zimmermann, 2011, stefan@zimmermann-software.de



   Generation of Projects from ORDERs





*****************************************************/

CREATE OR REPLACE FUNCTION zspm_generateprojectfromso (p_pinstance_id varchar)
RETURNS VOID AS
$body$ -- projects.sql
 -- SELECT zspm_generateprojectfromso('C2B114D99EC5472F85292A8677F7E325');
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor   2012 MaHinrichs: Ausgabe in Tabelle c_projecttask, update c_oderline.c_projecttask_id mit c_projecttask.c_projecttask_id
***************************************************************************************************************************************************
Part of Projects,
 Cancel Feedback for Project-Task
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_ismanager character varying;
v_isworker varchar;
v_message character varying:='Sucess';
v_count   numeric;
v_uuid    character varying;
v_cur RECORD;
v_cur_ol RECORD;
v_cur_tsk RECORD;
v_name character varying;
v_value  character varying;

 i INTEGER := 0;
 v_org_id VARCHAR;
 v_now TIMESTAMP;
 v_projectcategory VARCHAR := 'S';
 v_guid_task VARCHAR;
 v_end timestamp;
BEGIN
  v_now := to_date(now());
    --  Update AD_PInstance/ Get Parameters
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT pi.Record_ID, pi.AD_User_ID INTO v_Record_ID, v_User
    FROM AD_PINSTANCE pi WHERE pi.AD_PInstance_ID = p_PInstance_ID;
    IF (v_Record_ID IS NULL) then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID; -- 'C2B114D99EC5472F85292A8677F7E325'
       v_User     := '0';
    ELSE
        FOR v_cur IN
        (SELECT pi.Record_ID,
          pi.AD_User_ID,
          p.ParameterName,
          p.P_String,
          p.P_Number,
          p.P_Date
        FROM AD_PINSTANCE pi
        LEFT JOIN AD_PINSTANCE_PARA p
          ON pi.AD_PInstance_ID=p.AD_PInstance_ID
        WHERE pi.AD_PInstance_ID=p_PInstance_ID
        ORDER BY p.SeqNo
        )
      LOOP
        if v_cur.ParameterName='VALUE' then v_value:=v_cur.P_String; end if; -- c_project.value
        if v_cur.ParameterName='NAME' then v_name:=v_cur.P_String; end if;   -- c_project.name
      END LOOP; -- Get Parameter
    END if;
    select ad_org_id into v_org_id from c_order where c_order_id=v_Record_ID;
    IF c_getconfigoption('projectmangerworkflow', v_org_id)='Y' THEN
      -- Only  a Project manager can Do this
      SELECT bp.isprojectmanager,bp.isworker INTO v_ismanager,v_isworker FROM c_bpartner bp,ad_user ad WHERE ad.c_bpartner_id=bp.c_bpartner_id AND ad.ad_user_id=v_User;
      IF COALESCE(v_ismanager,'N')!='Y' and  COALESCE(v_isworker,'N')!='Y' then
            RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
      END IF;
    END IF;

    select get_uuid() into v_uuid;

  -- Projekttyp bestimmen: pruefen, ob Produktionsprojekt moeglich
    IF ((
      SELECT COUNT(*) FROM
      c_order o, c_orderline ol, m_product
      WHERE 1=1
       AND ol.c_order_id = v_Record_ID
       AND ol.c_order_id = o.c_order_id
       AND ol.isactive = 'Y' AND m_product.isactive = 'Y'
       AND ol.m_product_id = m_product.m_product_id
       AND m_product.production = 'Y' -- AND m_product..producttype = 'S'
      -- zspm_projecttask_trg()
       and m_product.m_attributeset_id is null
       and m_product.isactive='Y'
       and m_product.isverified='Y'
       and m_product.isbom='Y'
       and m_product.discontinued='N'
       and m_product.typeofproduct in ('AS','SA','CD') -- 'ST'=Standard, werden nicht kopiert
    ) > 0) THEN
      v_projectcategory := 'P';
    END IF;

    -- Obviously one record, but more efficient code
    for v_cur in (select
                v_uuid as C_PROJECT_ID,AD_CLIENT_ID,AD_ORG_ID,documentno as VALUE,DESCRIPTION,
                ad_user_id,C_BPARTNER_ID, C_BPARTNER_LOCATION_ID,totallines as COMMITTEDAMT,dateordered as DATECONTRACT,scheddeliverydate as DATEFINISH,
                salesrep_id,M_WAREHOUSE_ID, v_projectcategory as PROJECTCATEGORY, 'OP' as PROJECTSTATUS, trunc(now()) as STARTDATE
                          from c_order where c_order_id=v_Record_ID)
    LOOP
           insert into c_project (
                C_PROJECT_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY,
                VALUE, NAME, DESCRIPTION, AD_USER_ID, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID,COMMITTEDAMT, DATECONTRACT, DATEFINISH,
                SALESREP_ID, M_WAREHOUSE_ID, PROJECTCATEGORY,  PROJECTSTATUS,   STARTDATE, c_currency_id,responsible_id)
           values (
                v_cur.C_PROJECT_ID, v_cur.AD_CLIENT_ID, v_cur.AD_ORG_ID, v_user, v_user,
                coalesce(v_value,v_cur.VALUE),coalesce(v_name,'Generated'), v_cur.DESCRIPTION,
                v_cur.AD_USER_ID, v_cur.C_BPARTNER_ID, v_cur.C_BPARTNER_LOCATION_ID, v_cur.COMMITTEDAMT, v_cur.DATECONTRACT, v_cur.DATEFINISH,
                v_cur.SALESREP_ID, v_cur.M_WAREHOUSE_ID, v_cur.PROJECTCATEGORY,  v_cur.PROJECTSTATUS,   v_cur.STARTDATE, zsfi_get_c_currency_id(v_cur.AD_ORG_ID),v_user);
    END LOOP;
    -- Update c_order set Project
    update c_order set c_project_id=v_uuid where c_order_id=v_Record_ID;
    update c_orderline set c_project_id=v_uuid where c_order_id=v_Record_ID;
-- Positionen (nur fuer Produktion) von c_orderline nach c_projecttask kopieren 10.05.2012
    IF (v_projectcategory = 'P' and c_getconfigoption('generatestdtaskfromso',v_org_id)='Y') THEN
      FOR v_cur_ol IN (
        SELECT
          ol.ad_client_id, ol.ad_org_id,
          v_now AS created, v_User AS createdby, v_now AS updated, v_User AS updatedby,ol.scheddeliverydate as DATEFINISH,
          0 AS seqno, pr.name, ol.description, ol.m_product_id, ol.qtyordered,
          v_uuid AS c_project_id, ol.c_orderline_id
       -- pr.production, pr.producttype
        FROM
          c_orderline ol, m_product pr
          WHERE 1=1
           AND ol.m_product_id = pr.m_product_id         -- wg. pr.name
           AND ol.isactive = 'Y' AND pr.isactive = 'Y'
           AND pr.production = 'Y'                       -- AND pr.producttype = 'S'
           AND c_order_id = v_Record_ID                  -- 'C2B114D99EC5472F85292A8677F7E325'
          ORDER BY ol.line, pr.name, pr.created          -- LIMIT 10
          )
      LOOP
        i := i + 10;
        v_guid_task := get_uuid();

        INSERT INTO c_projecttask (
          c_projecttask_id, ad_client_id, ad_org_id,
          created, createdby, updated, updatedby,
          seqno, name, description, m_product_id, qty,
          c_project_id,startdate,enddate
        ) VALUES (
          v_guid_task, 'C726FEC915A54A0995C568555DA5BB3C', v_org_id,
          now(), v_User, now(), v_User,
          i, v_cur_ol.name, COALESCE(v_cur_ol.description, 'Generated'), v_cur_ol.m_product_id, v_cur_ol.qtyordered,
          v_uuid,trunc(now()),v_cur_ol.DATEFINISH
        );
        --RAISE NOTICE '%', TRIM(to_char(i)) || ' Datensaetze in Tabelle C_PROJECTTASK hinzugefuegt';
        UPDATE c_orderline ol SET c_projecttask_id = v_guid_task WHERE ol.c_orderline_id = v_cur_ol.c_orderline_id;
        if i=10 then
            update c_order set c_projecttask_id = v_guid_task WHERE c_order_id=v_Record_ID ;
        end if;
      END LOOP;
      UPDATE c_orderline o SET c_projecttask_id = v_guid_task WHERE o.c_order_id = v_Record_ID   ;
    END IF; -- (v_projectcategory = 'P')
    -- Standard-Projektaufgabe anlegen.
    IF (v_projectcategory = 'S' and c_getconfigoption('generatestdtaskfromso',v_org_id)='Y') THEN
        v_guid_task := get_uuid();
        select scheddeliverydate into v_end from c_order where c_order_id=v_Record_ID   ;
        INSERT INTO c_projecttask (
          c_projecttask_id, ad_client_id, ad_org_id,
          created, createdby, updated, updatedby,
          seqno, name, 
          c_project_id,startdate,enddate
        ) VALUES (
           v_guid_task, 'C726FEC915A54A0995C568555DA5BB3C', v_org_id,
          now(), v_User, now(), v_User,
          10, coalesce(v_value,'Standard'), 
          v_uuid,trunc(now()),v_end
        );
        Update c_order set c_projecttask_id = v_guid_task WHERE c_order_id=v_Record_ID ;
    END IF; -- (v_projectcategory = 'S')
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ;
$body$
LANGUAGE 'plpgsql'
COST 100;
ALTER FUNCTION zspm_generateprojectfromso(character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zsfi_get_c_currency_id (
    p_ad_org_id             CHARACTER VARYING   -- ad_org_id.ad_org_id
  )
RETURNS
  CHARACTER VARYING -- c_currency_id
AS $body_$
-- ..\projects.sql
-- SELECT zsfi_get_c_currency_id('AE3637495E9E4EBFA7E766FE9B97893A') AS zsfi_get_c_currency_id;  -- gueltig
-- SELECT zsfi_get_c_currency_id('AE3637495E9E4EBFA7E766FE9B978930') AS zsfi_get_c_currency_id; -- ungueltig
DECLARE
  v_result               CHARACTER VARYING;
  v_c_currency_id        VARCHAR := '';
BEGIN
/*
  SELECT
    accsch.c_currency_id
  FROM
    c_acctschema accsch, ad_org_acctschema oas, ad_org org
  WHERE 1=1
     AND accsch.c_acctschema_id = oas.c_acctschema_id
     AND org.ad_org_id = oas.ad_org_id
     AND org.ad_client_id = oas.ad_client_id
     AND oas.ad_org_id = 'AE3637495E9E4EBFA7E766FE9B97893A'
*/

  SELECT accsch.c_currency_id
  INTO v_c_currency_id
  FROM c_acctschema accsch
  WHERE  accsch.c_acctschema_id IN
   (
    SELECT oas.c_acctschema_id
    FROM ad_org_acctschema oas, ad_org org
    WHERE 1=1
     AND org.ad_org_id = oas.ad_org_id
     AND org.ad_client_id = oas.ad_client_id
     AND oas.ad_org_id = p_ad_org_id -- 'AE3637495E9E4EBFA7E766FE9B97893A'
   );

  IF (v_c_currency_id IS NOT NULL) THEN
    v_result :=  v_c_currency_id;
  END IF;

  RETURN v_result;
END;
$body_$
LANGUAGE 'plpgsql' VOLATILE
COST 100;


CREATE OR REPLACE FUNCTION zspm_closeprojectfromso(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, 
 Cancel Feedback for Project-Task
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message character varying:='Sucess';
v_count   numeric;
v_projid character varying;
v_ismanager varchar;
v_isworker varchar;
v_org varchar;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    select c_project_id,ad_org_id into v_projid,v_org from c_order where c_order_id=v_Record_ID;
    if c_getconfigoption('projectmangerworkflow',v_org)='Y' then
      -- Only  a Project manager can Do this
      SELECT bp.isprojectmanager,bp.isworker INTO v_ismanager,v_isworker FROM c_bpartner bp,ad_user ad WHERE ad.c_bpartner_id=bp.c_bpartner_id AND ad.ad_user_id=v_User;
      IF NOT (COALESCE(v_ismanager,'N')='Y' or  (COALESCE(v_isworker,'N')='Y' and (select responsible_id from c_project where c_project_id=v_projid)=v_User)) then
            RAISE EXCEPTION '%', '@zspm_OnlyManagerUser@';
      end if; 
    end if; 
    
    -- TODO: All Tasks must be open -> Else don't close
    update c_project set PROJECTSTATUS='OC',updatedby=v_User,updated=now() where c_project_id=v_projid;
    update c_order set closeproject='Y'  where c_order_id=v_Record_ID;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zspm_closeprojectfromso(character varying) OWNER TO tad;

  


/*****************************************************+
Stefan Zimmermann, 2011, stefan@zimmermann-software.de



   Implementing Automatic Internal-Material-Consumption from Projects
   
   Works if PO has Project and if configured





*****************************************************/
select zsse_dropfunction('zspm_materialconsumption4project');

CREATE OR REPLACE FUNCTION zspm_materialconsumption4project(p_M_INOUT_ID character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, 
 @TODO : Implement Project-Tasks
*****************************************************/

v_User    character varying;
v_org    character varying;
v_client character varying;
v_isso character varying;
v_isconf character varying;
v_descr character varying;
v_count   numeric;
BEGIN
    select ad_org_id,updatedby,issotrx,ad_client_id,description into v_org,v_User,v_isso,v_client,v_descr from M_INOUT where M_INOUT_ID=p_M_INOUT_ID;
    select c_getconfigoption('automaterial2project',v_org) into v_isconf;
    --select count(*) into v_count from M_INOUTline,c_orderline where  c_orderline.c_orderline_id=M_INOUTline.c_orderline_id and M_INOUTline.M_INOUT_ID=p_M_INOUT_ID and c_orderline.c_project_id is not null;
    
    
    select count(*) into v_count  
          from m_requisitionline r,m_requisitionorder ro,c_orderline ol,M_INOUTline ml 
          where ro.c_orderline_id=ol.c_orderline_id 
          and r.m_requisitionline_id=ro.m_requisitionline_id
          and ol.c_orderline_id=ml.c_orderline_id
          and ml.M_INOUT_ID=p_M_INOUT_ID;
        --select qtyinrequisition into v_proj_qty from zspm_projecttaskbom where zspm_projecttaskbom_id=v_ptbom;
        -- Only directly reserved material schould be assigned automatically on Project
    
    
    -- Exit when not configured or Sales Transaction or no projectlines, and no Reverse Corrections
    if v_isso='Y' or v_isconf='N' or  v_count=0 or substr(v_descr,1,6)='(*R*: ' then
       return;
    end if;
    PERFORM zspm_DOconsumption4project(p_M_INOUT_ID ,1,v_org,v_User,v_client);
    RETURN;
END ; $BODY$ LANGUAGE 'plpgsql' VOLATILE COST 100;

CREATE OR REPLACE FUNCTION zspm_reversematerialconsumption4project(p_M_INOUT_ID character varying)
  RETURNS void AS
$BODY$ 
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
**************************************************************************************************************************************************

@Deprecated

*****************************************************/

v_User    character varying;
v_org    character varying;
v_client character varying;
v_isso character varying;
v_isconf character varying;
v_count   numeric;
BEGIN
    select ad_org_id,updatedby,issotrx,ad_client_id into v_org,v_User,v_isso,v_client from M_INOUT where M_INOUT_ID=p_M_INOUT_ID;
    select c_getconfigoption('automaterial2project',v_org) into v_isconf;
   -- select count(*) into v_count from M_INOUTline,c_orderline where  c_orderline.c_orderline_id=M_INOUTline.c_orderline_id and M_INOUTline.M_INOUT_ID=p_M_INOUT_ID and c_orderline.c_project_id is not null;
   select count(*) into v_count  
          from m_requisitionline r,m_requisitionorder ro,c_orderline ol,M_INOUTline ml 
          where ro.c_orderline_id=ol.c_orderline_id 
          and r.m_requisitionline_id=ro.m_requisitionline_id
          and ol.c_orderline_id=ml.c_orderline_id
          and ml.M_INOUT_ID=p_M_INOUT_ID;
    -- Exit when not configured or Sales Transaction or no projectlines
    if v_isso='Y' or v_isconf='N' or  v_count=0 then
       return;
    end if;
    -- The Auto Consumtion schould not be reversed - It is a better Process to Leave It as It is and let the user decide what to do
    --PERFORM zspm_DOconsumption4project(p_M_INOUT_ID ,-1,v_org,v_User,v_client);
    RETURN;
END ; $BODY$ LANGUAGE 'plpgsql' VOLATILE COST 100;


CREATE OR REPLACE FUNCTION zspm_DOconsumption4project(p_M_INOUT_ID character varying,p_reverse numeric, p_org character varying,p_user character varying,p_client character varying)
  RETURNS void AS
$BODY$ 
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


*****************************************************/

v_isso character varying;
v_isconf character varying;
v_project    character varying;
v_count   numeric;
v_consumid character varying;
v_cur record;
v_cur2 record;
v_Line numeric:=0;
v_proj  character varying;
v_ptask  character varying;
v_ptbom character varying;
v_proj_qty numeric;
v_lineuuid varchar;
v_result numeric;
v_message  varchar;
v_currentline varchar:='';
v_currentqty numeric:=0;
BEGIN
    v_consumid:=get_uuid();
    --
    /*
    if (select count(distinct c_orderline.C_PROJECT_ID) from M_INOUTline,c_orderline where  c_orderline.c_orderline_id=M_INOUTline.c_orderline_id and M_INOUTline.M_INOUT_ID=p_M_INOUT_ID and c_orderline.c_project_id is not null)=1 then
        select c_orderline.C_PROJECT_ID into v_proj from M_INOUTline,c_orderline where  c_orderline.c_orderline_id=M_INOUTline.c_orderline_id and M_INOUTline.M_INOUT_ID=p_M_INOUT_ID and c_orderline.c_project_id is not null limit 1;
    end if;
    if (select count(distinct c_orderline.C_PROJECTTASK_ID) from M_INOUTline,c_orderline where  c_orderline.c_orderline_id=M_INOUTline.c_orderline_id and M_INOUTline.M_INOUT_ID=p_M_INOUT_ID and c_orderline.c_project_id is not null)=1 then
        select c_orderline.C_PROJECTTASK_ID into v_ptask from M_INOUTline,c_orderline where  c_orderline.c_orderline_id=M_INOUTline.c_orderline_id and M_INOUTline.M_INOUT_ID=p_M_INOUT_ID and c_orderline.c_project_id is not null limit 1;
    end if;
    */
    if (select count(distinct r.C_PROJECT_ID)  from m_requisitionline r,m_requisitionorder ro,c_orderline ol,M_INOUTline ml 
          where ro.c_orderline_id=ol.c_orderline_id 
          and r.m_requisitionline_id=ro.m_requisitionline_id
          and ol.c_orderline_id=ml.c_orderline_id
          and ml.M_INOUT_ID=p_M_INOUT_ID)=1 then
        select r.C_PROJECT_ID into v_proj from m_requisitionline r,m_requisitionorder ro,c_orderline ol,M_INOUTline ml 
          where ro.c_orderline_id=ol.c_orderline_id 
          and r.m_requisitionline_id=ro.m_requisitionline_id
          and ol.c_orderline_id=ml.c_orderline_id
          and ml.M_INOUT_ID=p_M_INOUT_ID limit 1;
    end if;
    if (select count(distinct r.c_projecttask_id) from m_requisitionline r,m_requisitionorder ro,c_orderline ol,M_INOUTline ml 
          where ro.c_orderline_id=ol.c_orderline_id 
          and r.m_requisitionline_id=ro.m_requisitionline_id
          and ol.c_orderline_id=ml.c_orderline_id
          and ml.M_INOUT_ID=p_M_INOUT_ID)=1 then
        select r.C_PROJECTTASK_ID into v_ptask from m_requisitionline r,m_requisitionorder ro,c_orderline ol,M_INOUTline ml 
          where ro.c_orderline_id=ol.c_orderline_id 
          and r.m_requisitionline_id=ro.m_requisitionline_id
          and ol.c_orderline_id=ml.c_orderline_id
          and ml.M_INOUT_ID=p_M_INOUT_ID limit 1;
    end if;
    
    
    
    insert into M_INTERNAL_CONSUMPTION(M_INTERNAL_CONSUMPTION_ID, AD_CLIENT_ID, AD_ORG_ID,  CREATED, CREATEDBY, UPDATED, UPDATEDBY,
                    NAME, DESCRIPTION, MOVEMENTDATE,dateacct,   MOVEMENTTYPE,DOCUMENTNO,c_project_id,c_projecttask_id)
               values(v_consumid,p_client,p_Org,NOW(), p_User, NOW(),p_User,
                      'Projekt','Automatische Zuweisung auf Projekt',now(),now(),'D-',ad_sequence_doc('Production',p_org,'Y'),v_proj,v_ptask);
    
    /*
    for v_cur in (select M_INOUTline.m_locator_id,M_INOUTline.M_Product_ID,M_INOUTline.movementqty,M_INOUTline.c_uom_id,M_INOUTline.M_INOUTline_id,
                         c_orderline.c_project_id,c_orderline.C_PROJECTTASK_ID ,c_orderline.c_orderline_id
                  from M_INOUTline,c_orderline where  c_orderline.c_orderline_id=M_INOUTline.c_orderline_id and M_INOUTline.M_INOUT_ID=p_M_INOUT_ID and c_orderline.c_project_id is not null)
    */
    for v_cur in (select ml.m_locator_id,ml.M_Product_ID,least(r.qty,ml.movementqty) as movementqty,ml.c_uom_id,ml.M_INOUTline_id,ml.movementqty as lineqty,
                   r.c_projecttask_id,r.c_project_id,ro.c_orderline_id 
          from m_requisitionline r,m_requisitionorder ro,c_orderline ol,M_INOUTline ml 
          where ro.c_orderline_id=ol.c_orderline_id 
          and r.m_requisitionline_id=ro.m_requisitionline_id
          and ol.c_orderline_id=ml.c_orderline_id
          and ml.M_INOUT_ID=p_M_INOUT_ID)
    LOOP
        
        -- Already receivet Material
        select sum(qtyreceived) into v_proj_qty from zspm_projecttaskbom ptb,c_projecttask pt where pt.c_projecttask_id=ptb.c_projecttask_ID
                                                and ptb.m_product_id=v_cur.M_Product_ID and ptb.planrequisition='Y'
                                                and pt.c_projecttask_id=v_cur.c_projecttask_id;
        --RAISE exception '%',p_M_INOUT_ID||'__'||v_proj_qty||'______'||v_cur.movementqty||'____'||v_currentqty||'______'||v_cur.lineqty;
        if v_currentqty <= v_cur.lineqty and v_cur.movementqty-coalesce(v_proj_qty,0) > 0 then
            if v_cur.M_INOUTline_id!=v_currentline then
                v_currentline:=v_cur.M_INOUTline_id;
                v_currentqty:=v_cur.movementqty-coalesce(v_proj_qty,0);
            else
                v_currentqty:=v_currentqty+v_cur.movementqty-coalesce(v_proj_qty,0);
            end if;
            --select r.zspm_projecttaskbom_id into v_ptbom from m_requisitionline r,m_requisitionorder o where o.c_orderline_id=v_cur.c_orderline_id and r.m_requisitionline_id=o.m_requisitionline_id and r.zspm_projecttaskbom_id is not null;
        
            -- Only directly reserved material schould be assigned automatically on Project
            --if v_ptbom is not null then
                v_Line:=v_Line+10;
                select get_uuid() into v_lineuuid;
                insert into M_INTERNAL_CONSUMPTIONLINE(M_INTERNAL_CONSUMPTIONLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTION_ID, 
                                                    M_LOCATOR_ID, M_PRODUCT_ID, LINE, MOVEMENTQTY, DESCRIPTION, C_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID,cost2project,zspm_projecttaskbom_id)
                    values (v_lineuuid,p_client,p_Org,NOW(), p_User, NOW(),p_User,v_consumid,
                            v_cur.m_locator_id,v_cur.M_Product_ID,v_Line,v_cur.movementqty-coalesce(v_proj_qty,0)*p_reverse,'Automatische Zuweisung auf Projekt',v_cur.c_uom_id,v_cur.C_PROJECT_ID, v_cur.C_PROJECTTASK_ID,'Y',v_ptbom);
                -- Serial Numbers.
                insert into snr_INTERNAL_CONSUMPTIONLINE(snr_INTERNAL_CONSUMPTIONLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTIONline_ID, quantity,isunavailable,lotnumber,serialnumber)
                    select get_uuid(),AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, v_lineuuid, quantity,isunavailable,lotnumber,serialnumber
                    from snr_minoutline where M_INOUTline_id=v_cur.M_INOUTline_id;
        end if;
    END LOOP;
    -- only keep consumption, if lines exists
    if v_Line=0 then 
        delete from  M_INTERNAL_CONSUMPTION where M_INTERNAL_CONSUMPTION_ID=v_consumid;
    end if;
    if ((select c_getconfigoption('activateinternalconsumptionauto',p_Org))='Y') OR p_reverse=-1 then
         PERFORM m_internal_consumption_post(v_consumid);
         select result,errormsg into v_result, v_message from ad_pinstance where ad_pinstance_id=v_consumid;          
         if v_result!=1 then
            RAISE EXCEPTION '%',v_message ;
         end if;
    end if;
    RETURN;
END ; $BODY$ LANGUAGE 'plpgsql' VOLATILE COST 100;



CREATE OR REPLACE FUNCTION zspm_projectexpenses2invoice(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, 
 Implements direct invoicing of Project expenses
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_ismanager character varying;
v_message character varying:='Success';
v_line   numeric;
v_exline numeric;
v_client character varying;
v_org character varying;
v_projid character varying;
v_bpartner character varying;
v_locid character varying;
v_plistid character varying;
v_uuid character varying;
v_cur RECORD;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;

    select c_project_id,AD_CLIENT_ID, AD_ORG_ID,c_bpartner_id,c_bpartner_location_id,m_pricelist_id into v_projid,v_client,v_org,v_bpartner,v_locid,v_plistid from c_invoice where c_invoice_id=v_Record_ID;
    select max(line) into v_line from c_invoiceline where c_invoice_id=v_Record_ID;
    if v_line is null then v_line:=0; end if;
    v_exline:=v_line;
    for v_cur in (select c_invoiceline_id, isgrossprice, c_tax_id from c_invoiceline,c_invoice where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and c_invoiceline.c_project_id = v_projid and c_invoiceline.reinvoicedby_id is null
                         and c_invoice.issotrx='N' and c_invoice.docstatus='CO' and (c_invoiceline.norecharge='N' or c_invoiceline.norecharge is null))
    LOOP
        select get_uuid() into v_uuid;
        v_line:=v_line+10;
        insert into c_invoiceline(C_INVOICELINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, C_INVOICE_ID,
                                  DESCRIPTION, M_PRODUCT_ID, QTYINVOICED, LINE,
                                  PRICELIST, PRICEACTUAL, PRICELIMIT, PRICESTD,
                                  C_UOM_ID, C_TAX_ID, M_ATTRIBUTESETINSTANCE_ID, QUANTITYORDER, M_PRODUCT_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID)
        select v_uuid,v_client,v_org,v_User,v_User,v_Record_ID,DESCRIPTION, M_PRODUCT_ID, QTYINVOICED, v_line,
                         m_bom_pricelist(M_PRODUCT_ID,v_plistid) as PRICELIST, 
                         m_get_offers_price(to_date(now()),v_bpartner,M_PRODUCT_ID,QTYINVOICED,v_plistid,'Y',priceactual, v_cur.isgrossprice, v_cur.c_tax_id) as PRICEACTUAL,
                         m_bom_pricelimit(M_PRODUCT_ID,v_plistid) as PRICELIMIT, m_bom_pricestd(M_PRODUCT_ID,v_plistid) as PRICESTD, 
                         C_UOM_ID, zsfi_GetTax(v_Record_ID,M_PRODUCT_ID) as C_TAX_ID,
                         M_ATTRIBUTESETINSTANCE_ID, QUANTITYORDER, M_PRODUCT_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID
        from c_invoiceline where c_invoiceline_id=v_cur.c_invoiceline_id;
        update c_invoiceline set reinvoicedby_id=v_uuid where c_invoiceline_id=v_cur.c_invoiceline_id;
    END LOOP;
    for v_cur in (select m_internal_consumptionline_id from m_internal_consumptionline,m_internal_consumption where m_internal_consumptionline.m_internal_consumption_id=m_internal_consumption.m_internal_consumption_id 
                         and m_internal_consumptionline.c_project_id = v_projid and m_internal_consumptionline.reinvoicedby_id is null and m_internal_consumptionline.cost2project='Y'
                         and m_internal_consumption.movementtype='D-' and m_internal_consumption.processed='Y')
    LOOP
        select get_uuid() into v_uuid;
        v_line:=v_line+10;
        insert into c_invoiceline(C_INVOICELINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, C_INVOICE_ID,
                                  DESCRIPTION, M_PRODUCT_ID, QTYINVOICED, LINE,
                                  PRICELIST, PRICEACTUAL, PRICELIMIT, PRICESTD,
                                  C_UOM_ID, C_TAX_ID, M_ATTRIBUTESETINSTANCE_ID, QUANTITYORDER, M_PRODUCT_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID)
        select v_uuid,v_client,v_org,v_User,v_User,v_Record_ID,DESCRIPTION, M_PRODUCT_ID, movementqty, v_line,
                         m_bom_pricelist(M_PRODUCT_ID,v_plistid) as PRICELIST, 
                         m_get_offers_price(to_date(now()),v_bpartner,M_PRODUCT_ID,movementqty,v_plistid) as PRICEACTUAL,
                         m_bom_pricelimit(M_PRODUCT_ID,v_plistid) as PRICELIMIT, m_bom_pricestd(M_PRODUCT_ID,v_plistid) as PRICESTD, 
                         C_UOM_ID, zsfi_GetTax(v_Record_ID,M_PRODUCT_ID) as C_TAX_ID,
                         M_ATTRIBUTESETINSTANCE_ID, QUANTITYORDER, M_PRODUCT_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID
        from m_internal_consumptionline where m_internal_consumptionline_id=v_cur.m_internal_consumptionline_id;

        update m_internal_consumptionline set reinvoicedby_id=v_uuid where m_internal_consumptionline_id=v_cur.m_internal_consumptionline_id;
    END LOOP; 
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    if v_line>0 then
         v_message := to_char(round((v_line-v_exline)/10))||' Neue Positionen erstellt';
    else 
         v_message := 'Keine Positionen gefunden';
    end if;
    RAISE NOTICE '%','Updating PInstance - Finished ';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

 
select zsse_DropView ('zspm_projecttaskbom_view');

CREATE OR REPLACE VIEW zspm_projecttaskbom_view AS 
SELECT	zspm_projecttaskbom.zspm_projecttaskbom_id as zspm_projecttaskbom_view_id,
                zspm_projecttaskbom.c_projecttask_id,
                zspm_projecttaskbom.ad_client_id,
                zspm_projecttaskbom.ad_org_id,
                zspm_projecttaskbom.isactive,
                zspm_projecttaskbom.created,
                zspm_projecttaskbom.createdby,
                zspm_projecttaskbom.updated,
                zspm_projecttaskbom.updatedby,
                zspm_projecttaskbom.m_product_id,
                zspm_projecttaskbom.quantity,
                zspm_projecttaskbom.m_locator_id,
                zspm_projecttaskbom.description,
                zspm_projecttaskbom.actualcosamount,
                zspm_projecttaskbom.constuctivemeasure,
                zspm_projecttaskbom.rawmaterial,
                zspm_projecttaskbom.cutoff,
                zspm_projecttaskbom.qty_plan,
                zspm_projecttaskbom.qtyreserved,
                zspm_projecttaskbom.isreturnafteruse,
                zspm_projecttaskbom.plannedamt,
                zspm_projecttaskbom.line,
                COALESCE((SELECT SUM(qty) FROM m_requisitionline, m_requisition 
                        WHERE m_requisition.docstatus='CO'
                        AND m_requisition.m_requisition_id=m_requisitionline.m_requisition_id
                        AND m_requisitionline.m_product_id=zspm_projecttaskbom.m_product_id
                        AND m_requisitionline.c_projecttask_id=zspm_projecttaskbom.c_projecttask_id		
                        ),0) as qtyinrequisition,
                zspm_projecttaskbom.qtyreceived,
                zspm_projecttaskbom.planrequisition,
                zspm_projecttaskbom.date_plan,
                (SELECT scheddeliverydate FROM mrp_deliveries_expected 
                        WHERE zspm_projecttaskbom.m_product_id = mrp_deliveries_expected.m_product_id
                        AND zspm_projecttaskbom.ad_org_id = mrp_deliveries_expected.ad_org_id
                        ORDER BY mrp_deliveries_expected.scheddeliverydate
                        LIMIT 1) as date_nextreceipt,
                (SELECT qtyordered - qtydelivered FROM mrp_deliveries_expected 
                        WHERE zspm_projecttaskbom.m_product_id = mrp_deliveries_expected.m_product_id
                        AND zspm_projecttaskbom.ad_org_id = mrp_deliveries_expected.ad_org_id
                        ORDER BY mrp_deliveries_expected.scheddeliverydate
                        LIMIT 1) as qty_nextreceipt,
                m_bom_qty_onhand(zspm_projecttaskbom.m_product_id,null,zspm_projecttaskbom.m_locator_id) as qty_instock,
                case when c_project.projectstatus = 'OR' and zspm_projecttaskbom.m_locator_id is not null then
                    M_BOM_Qty_Available(zspm_projecttaskbom.m_product_id,(select m_warehouse_id from m_locator 
                    where m_locator_id=zspm_projecttaskbom.m_locator_id),null)
                    + (zspm_projecttaskbom.quantity-zspm_projecttaskbom.qtyreceived) 
                else
                    M_BOM_Qty_Available(zspm_projecttaskbom.m_product_id,(select m_warehouse_id from m_locator 
                    where m_locator_id=zspm_projecttaskbom.m_locator_id),null) 
                end
                as qty_available,
                COALESCE(m_storage_pending.qtyordered, 0) as qty_ordered,
                (coalesce((SELECT SUM(movementqty) FROM m_internal_consumptionline
                        WHERE m_internal_consumptionline.c_projecttask_id = zspm_projecttaskbom.c_projecttask_id
                        AND m_internal_consumptionline.m_product_id = zspm_projecttaskbom.m_product_id
                        AND m_internal_consumptionline.m_internal_consumption_id IN (SELECT m_internal_consumption_id FROM m_internal_consumption
                                WHERE m_internal_consumption.movementtype = 'D-' and m_internal_consumption.processed='N')),0) - 
                coalesce((SELECT SUM(movementqty) FROM m_internal_consumptionline
                        WHERE m_internal_consumptionline.c_projecttask_id = zspm_projecttaskbom.c_projecttask_id
                        AND m_internal_consumptionline.m_product_id = zspm_projecttaskbom.m_product_id
                        AND m_internal_consumptionline.m_internal_consumption_id IN (SELECT m_internal_consumption_id FROM m_internal_consumption
                                WHERE m_internal_consumption.movementtype = 'D+' and m_internal_consumption.processed='N')),0)) as qty_inconsumption
FROM 	zspm_projecttaskbom
LEFT JOIN c_projecttask 			ON zspm_projecttaskbom.c_projecttask_id = c_projecttask.c_projecttask_id
LEFT JOIN c_project					ON c_projecttask.c_project_id = c_project.c_project_id
LEFT JOIN m_storage_pending 		ON zspm_projecttaskbom.m_product_id = m_storage_pending.m_product_id
                                                                        AND zspm_projecttaskbom.ad_org_id = m_storage_pending.ad_org_id
                                                                        AND c_project.m_warehouse_id = m_storage_pending.m_warehouse_id;

CREATE OR REPLACE RULE zspm_projecttaskbom_view_insert AS
        ON INSERT TO zspm_projecttaskbom_view DO INSTEAD 
        INSERT INTO zspm_projecttaskbom (
                zspm_projecttaskbom_id, 
                c_projecttask_id, 
                ad_client_id, 
                ad_org_id, 
                isactive, 
                created, 
                createdby, 
                updated, 
                updatedby, 
                m_product_id, 
                quantity,
                m_locator_id, 
                description, 
                actualcosamount, 
                constuctivemeasure, 
                rawmaterial, 
                cutoff, 
                qty_plan, 
                planrequisition,
                date_plan,isreturnafteruse,line) 
        VALUES (
                new.zspm_projecttaskbom_view_id, 
                new.c_projecttask_id, 
                new.ad_client_id, 
                new.ad_org_id, 
                new.isactive, 
                new.created, 
                new.createdby, 
                new.updated, 
                new.updatedby, 
                new.m_product_id, 
                new.quantity, 
                new.m_locator_id, 
                new.description, 
                new.actualcosamount, 
                new.constuctivemeasure, 
                new.rawmaterial, 
                new.cutoff, 
                new.qty_plan, 
                new.planrequisition,
                new.date_plan,NEW.isreturnafteruse,new.line);

CREATE OR REPLACE RULE zspm_projecttaskbom_view_update AS
        ON UPDATE TO zspm_projecttaskbom_view DO INSTEAD  
        UPDATE zspm_projecttaskbom SET 
                zspm_projecttaskbom_id = new.zspm_projecttaskbom_view_id, 
                c_projecttask_id = new.c_projecttask_id, 
                ad_client_id = new.ad_client_id, 
                ad_org_id = new.ad_org_id, 
                isactive = new.isactive, 
                created = new.created, 
                createdby = new.createdby, 
                updated = new.updated, 
                updatedby = new.updatedby, 
                m_product_id = new.m_product_id, 
                quantity = new.quantity, 
                m_locator_id = new.m_locator_id, 
                description = new.description, 
                actualcosamount = new.actualcosamount, 
                constuctivemeasure = new.constuctivemeasure, 
                rawmaterial = new.rawmaterial, 
                cutoff = new.cutoff, 
                qty_plan = new.qty_plan, 
                planrequisition = new.planrequisition,
                date_plan=new.date_plan,
                isreturnafteruse=new.isreturnafteruse,
                line=new.line
        WHERE 
                zspm_projecttaskbom.zspm_projecttaskbom_id = new.zspm_projecttaskbom_view_id;

CREATE OR REPLACE RULE zspm_projecttaskbom_view_delete AS
        ON DELETE TO zspm_projecttaskbom_view DO INSTEAD 
        DELETE FROM zspm_projecttaskbom
        WHERE 
                zspm_projecttaskbom.zspm_projecttaskbom_id = old.zspm_projecttaskbom_view_id;
        

        
        
CREATE OR REPLACE FUNCTION zsmf_returnmaterialtostock(p_PInstance_ID character varying)
RETURNS void AS
$BODY$
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
Part of Manufactring

*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_warehouse  character varying;
v_project  character varying;
v_locator  character varying;
v_client   character varying;
v_org      character varying;
v_cur      RECORD;
v_uom      character varying;
v_Message  character varying:='';
v_Result   numeric;
v_Count    numeric;
v_Line     numeric:=0;
v_Uid      character varying;
v_serial   varchar;
v_lineUUId varchar;
v_isserial boolean:=false;
v_DocumentNo varchar;
v_batch   varchar;
v_allorequipment varchar;
v_snrcount numeric;
v_cur2 RECORD;
BEGIN 
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_org_id into v_Record_ID, v_User,v_Org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    IF (v_Record_ID IS NOT NULL) then
        FOR v_cur IN (SELECT pi.Record_ID, p.ParameterName,  p.P_String,     p.P_Number,   p.P_Date   
                      FROM AD_PINSTANCE pi, AD_PINSTANCE_PARA p 
                      WHERE pi.AD_PInstance_ID=p.AD_PInstance_ID and pi.AD_PInstance_ID=p_PInstance_ID
        )
      LOOP
        if v_cur.ParameterName='returnequipmentorall' then v_allorequipment:=v_cur.P_String; end if; -- c_project.value
      END LOOP; -- Get Parameter
    END if;
    if v_Record_ID is null then
    RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
    v_Record_ID:=p_PInstance_ID;
    v_allorequipment:='ALL';
    v_User:='0';
    end if;
    select c_project.m_warehouse_id,c_project.c_project_id,c_project.ad_client_id,c_project.ad_org_id into v_warehouse,v_project,v_client, v_org
        from c_project,c_projecttask 
        where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=v_Record_ID;
    -- Prepare Material Return
    select count(*) into v_Count from zspm_projecttaskbom where c_projecttask_id=v_Record_ID and qtyreceived>0;
    if v_count>0 then
        select get_uuid() into v_uid;
        select ad_sequence_doc('Production',v_org,'Y') into v_DocumentNo;
        insert into M_INTERNAL_CONSUMPTION(M_INTERNAL_CONSUMPTION_ID, AD_CLIENT_ID, AD_ORG_ID,  CREATED, CREATEDBY, UPDATED, UPDATEDBY,
                    NAME, DESCRIPTION, MOVEMENTDATE,dateacct, C_PROJECT_ID, C_PROJECTTASK_ID,  MOVEMENTTYPE,DOCUMENTNO)
               values(v_uid,v_client,v_Org,NOW(), v_User, NOW(),v_User,
                      'Production-Process','Generated by Production->Return Material to Stock',now(),now(),v_project, v_Record_ID,'D+',v_DocumentNo);
    end if;
    -- Select all Received Material and all Assemblys goin into this Task
    for v_cur in (select * from zspm_projecttaskbom where c_projecttask_id=v_Record_ID and qtyreceived>0 and case when v_allorequipment='EQUIPMENT' then isreturnafteruse='Y' else 1=1 end)
    LOOP      
        -- uom
        select c_uom_id,isserialtracking,isbatchtracking,m_locator_id into v_uom,v_serial,v_batch,v_locator from m_product where m_product_id=v_cur.m_product_id;
        v_Line:=v_Line+10;
        select get_uuid() into v_lineUUId;
        if v_cur.m_locator_id is not null then
            v_locator:=v_cur.m_locator_id;
        else
            if v_locator is null then
                 RAISE EXCEPTION '%', 'Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' muß ein Lagerort angegeben werden, um die Rückgabe durchzuführen.';
            end if;
        end if;
        --PERFORM M_UPDATE_INVENTORY(v_cur.ad_client_ID, v_cur.ad_Org_ID, v_User, v_cur.m_product_id, v_cur.m_locator_id, null, v_uom,NULL, NULL, NULL, NULL,v_cur.qtyreceived , NULL) ;
        insert into M_INTERNAL_CONSUMPTIONLINE(M_INTERNAL_CONSUMPTIONLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTION_ID, 
                                                M_LOCATOR_ID, M_PRODUCT_ID, LINE, MOVEMENTQTY, DESCRIPTION, C_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID,zspm_projecttaskbom_id)
               values (v_lineUUId,v_client,v_Org,NOW(), v_User, NOW(),v_User,v_uid,
                        v_locator,v_cur.M_Product_ID,v_Line,v_cur.qtyreceived,'Generated by Production->Return Material to Stock',v_uom,v_project, v_Record_ID,v_cur.zspm_projecttaskbom_id);
        
        -- seruial Number Tracking?
        if v_serial='Y'  or v_batch='Y' then
           v_snrcount:=0;
           -- Give Back machines, if configured...
           for v_cur2 in (select distinct snr.serialnumber  from snr_masterdata snr,ma_machine m,c_projecttask pt,zspm_ptaskmachineplan ptmp 
                                 where m.snr_masterdata_id=snr.snr_masterdata_id and m.ma_machine_id=ptmp.ma_machine_id and ptmp.c_projecttask_ID=pt.c_projecttask_id and snr.c_projecttask_ID=pt.c_projecttask_id
                                       and ptmp.c_projecttask_ID=pt.c_projecttask_id and snr.m_product_id=v_cur.M_Product_ID
                                       and pt.c_projecttask_id=v_Record_ID and not exists (select 0 from snr_INTERNAL_CONSUMPTIONLINE sinml,M_INTERNAL_CONSUMPTIONLINE iml,M_INTERNAL_CONSUMPTION ic where
                                       ic.M_INTERNAL_CONSUMPTION_ID=v_uid and ic.M_INTERNAL_CONSUMPTION_ID=iml.M_INTERNAL_CONSUMPTION_ID and iml.M_INTERNAL_CONSUMPTIONLINE_ID=sinml.M_INTERNAL_CONSUMPTIONLINE_ID and
                                       sinml.serialnumber=snr.serialnumber)
                         )
           LOOP
            v_snrcount:=v_snrcount+1;
            insert into snr_INTERNAL_CONSUMPTIONLINE(snr_internal_consumptionline_id, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTIONLINE_ID,serialnumber)
                    values (get_uuid(),v_client,v_Org,NOW(), v_User, NOW(),v_User,v_lineUUId,v_cur2.serialnumber);
           END LOOP;
           if v_snrcount=0 then
            v_isserial:=true;
            v_message:=v_message||zsse_htmlLinkDirectKey('../InternalMaterialMovements/Lines_Relation.html',v_lineUUId,'Serial Number Tracking')||'<br />';
           end if;
        end if;
    END LOOP;
     -- no lines? - delete
    if v_Line=0 then
       delete from M_INTERNAL_CONSUMPTION where M_INTERNAL_CONSUMPTION_ID=v_uid;
       v_Message:= 'Keine Materialrückgabe möglich/erforderlich.';
    else
        if v_isserial=true then
        v_message:=v_message||'@zssm_MaterialReturnSerialRegistrationNeccessary@';
        else
        if (select c_getconfigoption('activateinternalconsumptionauto',v_Org))='Y' then
                PERFORM m_internal_consumption_post(v_uid);
                select result,errormsg into v_result, v_message from ad_pinstance where ad_pinstance_id=v_uid;          
                if v_result!=1 then
                    RAISE EXCEPTION '%',v_message ;
                end if;
        end if;
        v_message:='@zssm_MaterialReturnToStockSucessfully@'||zsse_htmlLinkDirectKey('../InternalMaterialMovements/InternalMaterialMovements_Relation.html',v_uid,v_DocumentNo);
        end if;
    end if;
    RAISE NOTICE '%','Updating PInstance - Finished ';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_DropView ('zspm_materialmovements_view');
CREATE OR REPLACE VIEW zspm_materialmovements_view AS 
SELECT 
        m_internal_consumptionline.m_internal_consumptionline_id as zspm_materialmovements_view_id,
        m_internal_consumptionline.AD_Client_ID,
        m_internal_consumptionline.AD_Org_ID,
        m_internal_consumptionline.IsActive,
        m_internal_consumptionline.Created,
        m_internal_consumptionline.CreatedBy,
        m_internal_consumptionline.Updated,
        c_projecttask.c_projecttask_id,
        c_projecttask.c_projecttask_id as zssm_workstep_v_id,
        m_internal_consumptionline.c_project_id,
        m_internal_consumptionline.c_project_id as zssm_productionorder_v_id,
        m_internal_consumptionline.m_product_id,
        (case m_internal_consumption.movementtype when 'D+' then m_internal_consumptionline.movementqty * -1 when 'P+' then m_internal_consumptionline.movementqty * -1else m_internal_consumptionline.movementqty end) as movementqty,
        (select sum(zspm_projecttaskbom_view.quantity) from zspm_projecttaskbom_view where zspm_projecttaskbom_view.c_projecttask_id=m_internal_consumptionline.c_projecttask_id and zspm_projecttaskbom_view.m_product_id=m_internal_consumptionline.m_product_id) as quantity,
        m_internal_consumption.movementdate,
        m_internal_consumption.updatedby,
        m_internal_consumption.m_internal_consumption_id,
        m_internal_consumptionline.description,
        m_internal_consumptionline.m_locator_id
        
FROM 
        m_internal_consumptionline
                left join 	c_projecttask on m_internal_consumptionline.c_projecttask_id=c_projecttask.c_projecttask_id
                left join 	m_internal_consumption on m_internal_consumptionline.m_internal_consumption_id=m_internal_consumption.m_internal_consumption_id
        
WHERE 
        m_internal_consumptionline.c_projecttask_id=c_projecttask.c_projecttask_id
GROUP BY 
        zspm_materialmovements_view_id,
        m_internal_consumptionline.AD_Client_ID,
        m_internal_consumptionline.AD_Org_ID,
        m_internal_consumptionline.IsActive,
        m_internal_consumptionline.Created,
        m_internal_consumptionline.CreatedBy,
        m_internal_consumptionline.Updated,
        c_projecttask.c_projecttask_id,
        m_internal_consumptionline.m_product_id,
        m_internal_consumptionline.c_project_id,
        m_internal_consumptionline.movementqty,
        quantity,
        m_internal_consumption.movementdate,
        m_internal_consumption.updatedby,
        m_internal_consumption.m_internal_consumption_id,
        m_internal_consumptionline.description,
        m_internal_consumptionline.m_locator_id,
        m_internal_consumption.movementtype;
        
select zsse_DropView ('zspm_recharge_view');

CREATE OR REPLACE VIEW zspm_recharge_view AS 
-- Lieferantenrechnungsposition
SELECT  il_in.c_invoiceline_id as zspm_recharge_view_id,
                il_in.ad_client_id,
                il_in.ad_org_id,
                il_in.isactive,
                il_in.created,
                il_in.createdby,
                il_in.updated,
                il_in.updatedby,
                il_in.c_invoiceline_id,         -- Lieferantenrechnungsposition
                il_in.c_invoice_id,             -- Lieferantenrechnung
                il_in.c_orderline_id,           -- zugrunde liegende Bestellungsposition
                il_in.m_product_id,             -- Artikel
                il_in.qtyinvoiced,                      -- Menge
                il_in.linenetamt,                       -- Einkaufspreis total
                il_in.c_project_id,             -- Projekt
                il_in.c_projecttask_id,         -- Projektaufgabe
                il_in.reinvoicedby_id,          -- Kundenrechnungsposition
                il_in.description,                      -- Beschreibung
-- Lieferantenrechnung
                i_in.c_order_id,                        -- zugrunde liegende Bestellung
                i_in.dateinvoiced,                      -- Rechungsstellungsdatum
                i_in.c_bpartner_id,                     -- Lieferant
                i_in.totallines,                        -- Nettobetrag
                i_in.grandtotal,                        -- Bruttobetrag
                i_in.totalpaid,                         -- Bezahlter Betrag
                i_in.transactiondate,           -- Bezahldatum
                i_in.ispaid,                            -- vollständig bezahlt
-- Bestellungsposition
                ol_in.dateordered,                      -- Bestelldatum
-- Bestellung
                o_in.salesrep_id,                       -- Besteller
-- Kundenrechnungsposition
                il_out.m_product_id as recharge_product_id,             -- Artikel
                il_out.qtyinvoiced as recharge_qtyinvoiced,             -- Menge
                il_out.linenetamt as recharge_linenetamt,               -- Verkaufspreis total
                il_out.c_invoice_id as recharge_invoice_id,             -- Kundenrechnung
-- Kundenrechnung
                i_out.dateinvoiced as recharge_dateinvoiced,            -- Rechungsstellungsdatum
                i_out.c_bpartner_id as recharge_bpartner_id,            -- Kunde
                i_out.c_order_id as recharge_order_id,                  -- Vertriebsauftrag
-- Funktionalität
                (case when il_in.reinvoicedby_id IS NULL then 'N' when il_in.reinvoicedby_id = '' then 'N' else 'Y' end) as isrecharged,
                il_in.norecharge as norecharge,
                il_in.norechargecomment as norechargecomment
                
                
FROM            c_invoiceline il_in
LEFT JOIN       c_invoice i_in                  ON il_in.c_invoice_id = i_in.c_invoice_id
LEFT JOIN       c_orderline ol_in               ON il_in.c_orderline_id = ol_in.c_orderline_id
LEFT JOIN       c_order o_in                    ON i_in.c_order_id = o_in.c_order_id
LEFT JOIN       c_invoiceline il_out    ON il_in.reinvoicedby_id = il_out.c_invoiceline_id
LEFT JOIN       c_invoice i_out                 ON il_out.c_invoice_id = i_out.c_invoice_id
WHERE
il_in.c_project_id is not null AND 
i_in.issotrx = 'N' AND 
i_in.docstatus = 'CO';

CREATE OR REPLACE RULE zspm_recharge_view_update AS
        ON UPDATE TO zspm_recharge_view DO INSTEAD  
        UPDATE c_invoiceline SET 
                norecharge = new.norecharge,
                norechargecomment = new.norechargecomment
        WHERE 
                c_invoiceline.c_invoiceline_id = new.c_invoiceline_id;


SELECT zsse_droptrigger('zspm_ptaskhrplan_noclosed_trg', 'zspm_ptaskhrplan');
SELECT zsse_droptrigger('zspm_projecttaskdep_noclosed_trg', 'zspm_projecttaskdep');
SELECT zsse_droptrigger('zspm_ptaskmachineplan_noclosed_trg', 'zspm_ptaskmachineplan');
SELECT zsse_droptrigger('zspm_projecttaskbom_noclosed_trg', 'zspm_projecttaskbom');
SELECT zsse_droptrigger('C_projecttaskexpenseplan_noclosed_trg', 'C_projecttaskexpenseplan');

CREATE OR REPLACE FUNCTION c_nochangeonclosedtask_bef_trg() RETURNS trigger
    LANGUAGE plpgsql
    AS $_$ DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
 v_isrec character(1);
 v_isclosed character(1);
 v_pcategory varchar;
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;


  --SEPA-Export is only Possible on outgoing Payments
  IF(TG_OP = 'INSERT') THEN
    select istaskcancelled,iscomplete into v_isrec,v_isclosed from c_projecttask where c_projecttask_id=new.c_projecttask_id;
    if v_isrec='Y' or v_isclosed='Y' then
       raise exception '%','@zspm_nochangeonclosedtask@';
    end if;
  END IF;
  IF(TG_OP = 'UPDATE') THEN
    select t.istaskcancelled,t.iscomplete,p.projectcategory into v_isrec,v_isclosed,v_pcategory from c_projecttask t,c_project p where p.c_project_id=t.c_project_id and c_projecttask_id=new.c_projecttask_id;
    if v_isrec='Y' or v_isclosed='Y'  then 
       raise exception '%','@zspm_nochangeonclosedtask@';
    end if;
  END IF;
  IF(TG_OP = 'DELETE') THEN
     select istaskcancelled,iscomplete into v_isrec,v_isclosed from c_projecttask where c_projecttask_id=old.c_projecttask_id;
    if v_isrec='Y' or v_isclosed='Y' then
       raise exception '%','@zspm_nochangeonclosedtask@';
    end if;
  END IF;
 
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END ; $_$;


-- It is allwed to return unused material (UPDATE) - That is tested in zsmf_projecttaskbom_trg
CREATE TRIGGER zspm_projecttaskbom_noclosed_trg
  BEFORE INSERT  OR DELETE 
  ON zspm_projecttaskbom FOR EACH ROW
  EXECUTE PROCEDURE c_nochangeonclosedtask_bef_trg();

CREATE TRIGGER zspm_ptaskmachineplan_noclosed_trg
  BEFORE INSERT OR UPDATE OR DELETE 
  ON zspm_ptaskmachineplan FOR EACH ROW
  EXECUTE PROCEDURE c_nochangeonclosedtask_bef_trg();

CREATE TRIGGER zspm_ptaskhrplan_noclosed_trg
  BEFORE INSERT OR UPDATE OR DELETE 
  ON zspm_ptaskhrplan FOR EACH ROW
  EXECUTE PROCEDURE c_nochangeonclosedtask_bef_trg();

CREATE TRIGGER zspm_projecttaskdep_noclosed_trg
  BEFORE INSERT OR UPDATE OR DELETE 
  ON zspm_projecttaskdep FOR EACH ROW
  EXECUTE PROCEDURE c_nochangeonclosedtask_bef_trg();

CREATE TRIGGER C_projecttaskexpenseplan_noclosed_trg
   BEFORE INSERT OR DELETE OR UPDATE 
  ON C_projecttaskexpenseplan FOR EACH ROW
  EXECUTE PROCEDURE c_nochangeonclosedtask_bef_trg();


CREATE OR REPLACE FUNCTION zspm_isProductionOrder (p_zssm_productionOrder_v_id VARCHAR)
RETURNS BOOLEAN
AS $body$
DECLARE
BEGIN
  RETURN ((SELECT COUNT(*) FROM zssm_productionOrder_v v WHERE v.zssm_productionOrder_v_id = p_zssm_productionOrder_v_id AND v.projectcategory = ALL (ARRAY['PRO'])) = 1);
END;
$body$
LANGUAGE 'plpgsql';
  
CREATE OR REPLACE FUNCTION zspm_isProductionPlanTask (
  p_projecttask_id VARCHAR
 )
RETURNS BOOLEAN
AS $body$
DECLARE
BEGIN
  RETURN ((SELECT COUNT(*) FROM c_projecttask WHERE c_projecttask_id = p_projecttask_id AND c_project_id IS NULL) = 0);
END;
$body$
LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('zspm_ptaskmachineplan_quantity_trg', 'zspm_ptaskmachineplan');
SELECT zsse_droptrigger('zspm_ptaskhrplan_quantity_trg', 'zspm_ptaskhrplan');

CREATE OR REPLACE FUNCTION zspm_quantitycalc_bef_trg () RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
 v_production numeric;
 v_qty numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;

  IF (TG_OP <> 'DELETE') THEN
  -- ?? IF (zspm_isProductionPlanTask(NEW.c_projecttask_id)) THEN -- to be continued
    --- Only on Production Plans and Worksteps
    select count(*) into v_production from c_projecttask where c_projecttask_id=new.c_projecttask_id and c_project_id is null;
    if v_production=0 then
         select count(*) into v_production 
         from c_projecttask,c_project 
         where 
             c_project.c_project_id=c_projecttask.c_project_id 
         and c_projecttask.c_projecttask_id=new.c_projecttask_id 
         and c_project.projectcategory='PRO';
    end if;
    if v_production=1 then
      select qty into v_qty 
      from c_projecttask 
      where c_projecttask_id=new.c_projecttask_id;
      
      new.quantity=v_qty*new.averageduration/to_number(new.durationunit);
    end if;
  END IF;
  
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


CREATE TRIGGER zspm_ptaskmachineplan_quantity_trg
  BEFORE INSERT OR UPDATE
  ON zspm_ptaskmachineplan FOR EACH ROW
  EXECUTE PROCEDURE zspm_quantitycalc_bef_trg();

CREATE TRIGGER zspm_ptaskhrplan_quantity_trg
  BEFORE INSERT OR UPDATE OR DELETE 
  ON zspm_ptaskhrplan FOR EACH ROW
  EXECUTE PROCEDURE zspm_quantitycalc_bef_trg();





CREATE OR REPLACE FUNCTION zspm_ptaskhrplan_cost_trg () RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
v_addfeeId varchar;
v_addcost numeric:=0;
v_hours numeric:=0;
v_cost numeric:=0;
v_sp1 numeric:=0;
v_sp2 numeric:=0;
v_tr numeric:=0;
v_seq numeric;
 v_cur RECORD;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;

  IF (TG_OP <> 'DELETE') THEN
     select p_cost, p_specialtime1, p_specialtime2 into v_cost, v_sp1, v_sp2 from zsco_get_salary_cost(new.c_salary_category_id,now(),new.Costuom);
     
     --select p_cost, p_specialtime1, p_specialtime2, p_triggeramt from zsco_get_salary_cost(new.c_salary_category_id,now(),new.Costuom);
      -- Additional Fees (Only for Humans...)
    select c_additionalfees_id into v_addfeeId from c_additionalfees where ad_org_id in ('0',new.ad_org_id) 
           and validfrom <=now() order by  ad_org_id desc,validfrom desc limit 1; 
    for v_cur in (select  saturday as fee, 'saturday' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees where c_additionalfees_id=v_addfeeId and saturday is not null
                  UNION
                  select  sunday as fee, 'sunday' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees  where c_additionalfees_id=v_addfeeId and sunday is not null
                  UNION
                  select  holiday as fee, 'holiday' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees  where c_additionalfees_id=v_addfeeId and holiday is not null
                  UNION
                  select  night as fee, 'night' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees  where c_additionalfees_id=v_addfeeId and night is not null and nightbegin is not null 
                                                   and nightend is not null
                  UNION
                  select  overtime as fee, 'overtime' as ident,nightbegin,nightend,overtimebegin from  c_additionalfees  where c_additionalfees_id=v_addfeeId and overtime is not null and overtimebegin is not null
                  ORDER BY fee desc)
    LOOP     
        if v_cur.ident='sunday' and coalesce(new.sunday,0)>0 then
           v_hours:=v_hours+new.sunday;
           v_addcost:= v_addcost + ((v_cost * new.sunday) + ((v_cost * new.sunday) * v_cur.fee) / 100);
        elsif v_cur.ident='saturday' and coalesce(new.saturday,0)>0 then
           v_hours:=v_hours+new.saturday;
           v_addcost:= v_addcost + ((v_cost * new.saturday) + ((v_cost * new.saturday) * v_cur.fee) / 100);
        elsif v_cur.ident='holiday' and coalesce(new.holiday,0)>0 then
           v_hours:=v_hours+new.holiday;
           v_addcost:= v_addcost + ((v_cost * new.holiday) + ((v_cost * new.holiday) * v_cur.fee) / 100);
        elsif v_cur.ident='night' and coalesce(new.nighthours,0)>0 then
            v_hours:=v_hours+new.nighthours;
            v_addcost:= v_addcost + ((v_cost * new.nighthours) + ((v_cost * new.nighthours) * v_cur.fee) / 100);
        elsif v_cur.ident='overtime' and coalesce(new.overtimehours,0)>0 then
            v_hours:=v_hours+new.overtimehours;
            v_addcost:= v_addcost + ((v_cost * new.overtimehours) + ((v_cost * new.overtimehours) * v_cur.fee) / 100);
        end if;
    END LOOP;
    if new.isactive='Y' then
        new.plannedamt:=round(v_cost * (new.quantity - v_hours) + v_addcost,2)+(new.specialtime1*v_sp1)+(new.specialtime2*v_sp2)+new.triggeramt;
    else
        new.plannedamt:=0;
    end if;
  END IF;
  
  IF (TG_OP = 'INSERT') THEN 
    select coalesce(max(seqno),0)+10 into v_seq from zspm_ptaskhrplan where c_projecttask_id=new.c_projecttask_id;
    if new.seqno is null then 
        new.seqno:=v_seq;
    end if;
  END IF;
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zspm_ptaskhrplan_cost_trg', 'zspm_ptaskhrplan');

CREATE TRIGGER zspm_ptaskhrplan_cost_trg
  BEFORE INSERT OR UPDATE
  ON zspm_ptaskhrplan FOR EACH ROW
  EXECUTE PROCEDURE zspm_ptaskhrplan_cost_trg();
  
CREATE OR REPLACE FUNCTION zspm_ptaskmachineplan_cost_trg() RETURNS trigger AS
$body$
 DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/

v_cost numeric:=0;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;

  IF (TG_OP <> 'DELETE') THEN
     v_cost:=zsco_get_machine_cost(new.ma_machine_id,now(),new.Costuom); 
     if new.isactive='Y' then
        new.plannedamt:=v_cost * (new.quantity);
     else
        new.plannedamt:=0;
     end if;
  END IF;
  
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zspm_ptaskmachineplan_cost_trg', 'zspm_ptaskmachineplan');


CREATE TRIGGER zspm_ptaskmachineplan_cost_trg
  BEFORE INSERT OR UPDATE
  ON zspm_ptaskmachineplan FOR EACH ROW
  EXECUTE PROCEDURE  zspm_ptaskmachineplan_cost_trg();
  
  
  
SELECT zsse_droptrigger('zspm_projecttask_postupd_trg', 'c_projecttask');
CREATE OR REPLACE FUNCTION zspm_projecttask_postupd_trg (
)
RETURNS trigger AS
$body$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
DECLARE 
 v_production numeric;
 v_qty numeric;
 v_prec numeric;
 v_oneqty numeric;
 v_count numeric;
 v_isproduction boolean;
 v_cur RECORD;
 v_message VARCHAR;
BEGIN
    
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;

  SELECT count(*) into v_count      FROM c_project prj    WHERE prj.c_project_id = old.c_project_id AND prj.projectcategory in ('PRO','PRP');
  if v_count>0 or new.c_project_id is null then
     v_isproduction=true;
  else
     v_isproduction:=false;
  end if;
   
-- RAISE NOTICE 'new.m_product_id=%: old.projecttask_id=%, old.qty=%, NEW.qty=%', new.m_product_id, old.c_projecttask_id, old.qty, NEW.qty;
  IF (OLD.qty <> NEW.qty) and v_isproduction THEN
    v_prec := (COALESCE((SELECT uom.stdprecision FROM m_product p, c_uom uom WHERE uom.c_uom_id=p.c_uom_id AND p.m_product_id = new.m_product_id), 0));
    NEW.qty := round(NEW.qty, v_prec); 
       
    for v_cur in (select * from zspm_projecttaskbom where c_projecttask_id=new.c_projecttask_id)
    LOOP
      -- Fetch Std Precision from UOM
      v_prec := (COALESCE(
                  (SELECT uom.stdprecision 
                   FROM zspm_projecttaskbom bom,m_product p,c_uom uom where uom.c_uom_id=p.c_uom_id and p.m_product_id=bom.m_product_id and bom.zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id)
                      , 0));
      -- qty for one 
      v_oneqty := ROUND(v_cur.quantity / (case coalesce(OLD.qty,1) when 0 then 1 else coalesce(OLD.qty,1) end), v_prec);
--    RAISE NOTICE 'm_product_id=%, old.quantity=%, new.quantity=%', cur_projecttaskbom_product.m_product_id, cur_projecttaskbom_product.quantity, (cur_projecttaskbom_product.quantity / OLD.qty * NEW.qty);
--    RAISE NOTICE '%: zspm_projecttaskbom_id=%, v_oneqty=%, NEW.qty=%, v_prec=%', TG_NAME, v_cur.zspm_projecttaskbom_id, v_oneqty, NEW.qty, v_prec;
      UPDATE zspm_projecttaskbom SET 
        quantity = (v_oneqty * NEW.qty), 
        updated = new.updated, 
        updatedby = new.updatedby
      WHERE zspm_projecttaskbom_id = v_cur.zspm_projecttaskbom_id;
    END LOOP;
    update zspm_ptaskhrplan set quantity=new.qty*averageduration/to_number(durationunit)  where c_projecttask_id=new.c_projecttask_id;
    update zspm_ptaskmachineplan set quantity=new.qty*averageduration/to_number(durationunit)  where c_projecttask_id=new.c_projecttask_id;
  END IF;
  
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; 
  END IF; 
  
EXCEPTION
  WHEN OTHERS THEN
    v_message := '@Error@' || ' ' || TG_NAME || '(); ' || SQLERRM;
    RAISE EXCEPTION '%', v_message;
END;
$body$
LANGUAGE 'plpgsql';         

CREATE TRIGGER zspm_projecttask_postupd_trg
  AFTER UPDATE
  ON c_projecttask FOR EACH ROW
  EXECUTE PROCEDURE zspm_projecttask_postupd_trg();
  
  
  
  
CREATE OR REPLACE FUNCTION zssi_internalCosts4projectcalculation(p_project_id varchar, p_lang varchar,OUT p_plannedamt numeric, OUT p_amt NUMERIC, OUT p_product_id VARCHAR, OUT p_desrciption VARCHAR) RETURNS SETOF RECORD 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_cur record;

v_IEmpCost numeric;
v_IMachCost numeric; 
v_IMatCost numeric;
v_IVendCost numeric;

v_IPEmpCost numeric:=0;
v_IPMachCost numeric:=0;
v_IPMatCost numeric:=0;
v_IPVendCost numeric:=0;

v_IREmpCost numeric:=0;
v_IRMachCost numeric:=0;
v_IRMatCost numeric:=0;
v_IRVendCost numeric:=0;

v_product varchar:='';


BEGIN
      for v_cur in (select p.ma_indirect_cost_id,t.c_projecttask_id,t.machinecostplan,t.machinecost,t.servcostplan,t.servcost
                    from zspm_ptaskindcostplan p, c_projecttask t 
                    where t.c_projecttask_id=p.c_projecttask_id 
                    and t.c_project_id in (p_project_id))
      loop
            --v_indirectcost:=v_indirectcost+(((v_invoicecost+v_workcost+v_machinecost+v_materialcost+v_glcost)*v_cur2.cost)/100);
            select p_empcost,p_machinecost,p_matcost,p_vendorcost into v_IEmpCost ,v_IMachCost,v_IMatCost,v_IVendCost from
                  zsco_get_indirect_cost(v_cur.ma_indirect_cost_id,now(),'P',v_cur.c_projecttask_id,'fact','NOPRODUCTS');
                  
             v_IREmpCost:=v_IREmpCost + round(coalesce(v_cur.servcost,0)*v_IEmpCost/100,2);
             v_IRMatCost:=v_IRMatCost + v_IMatCost;
             v_IRMachCost:=v_IRMachCost + round(coalesce(v_cur.machinecost,0)*v_IMachCost/100,2);
             v_IRVendCost:=v_IRVendCost + v_IVendCost ;
      end loop;
      for v_cur in (select p.ma_indirect_cost_id,t.c_projecttask_id,t.machinecostplan,t.machinecost,t.servcostplan,t.servcost
                    from zspm_ptaskindcostplan p, c_projecttask t 
                    where t.c_projecttask_id=p.c_projecttask_id  and t.istaskcancelled='N'
                    and t.c_project_id in (p_project_id))
      loop
           select p_empcost,p_machinecost,p_matcost,p_vendorcost into v_IEmpCost,v_IMachCost,v_IMatCost,v_IVendCost from
                  zsco_get_indirect_cost(v_cur.ma_indirect_cost_id,now(),'P',v_cur.c_projecttask_id,'plan','NOPRODUCTS');
                  
           v_IPEmpCost:=v_IPEmpCost + round(coalesce(v_cur.servcostplan,0)*v_IEmpCost/100,2);
           v_IPMatCost:=v_IPMatCost + v_IMatCost;
           v_IPMachCost:=v_IPMachCost + round(coalesce(v_cur.machinecostplan,0)*v_IMachCost/100,2);
           v_IPVendCost:=v_IPVendCost + v_IVendCost ;
      END LOOP;
      -- Allgemeiner Teil -Arbeitskosten
      p_plannedamt:=v_IPEmpCost;
      p_amt:=v_IREmpCost;
      p_desrciption:=zssi_getElementTextByColumname('empCost',p_lang);
      if p_plannedamt>0 or p_amt>0 then
        RETURN NEXT;
      end if;
      -- Allgemeiner Teil -Material
      p_plannedamt:=v_IPMatCost;
      p_amt:=v_IRMatCost;
      p_desrciption:=zssi_getElementTextByColumname('Materialcost',p_lang);
      if p_plannedamt>0 or p_amt>0 then
        RETURN NEXT;
      end if;
      -- Allgemeiner Teil -Maschinen
      p_plannedamt:=v_IPMachCost;
      p_amt:=v_IRMachCost;
      p_desrciption:=zssi_getElementTextByColumname('Machinecost',p_lang);
      if p_plannedamt>0 or p_amt>0 then
        RETURN NEXT;
      end if;
       -- Allgemeiner Teil -Lieferanten
      p_plannedamt:=v_IPVendCost;
      p_amt:=v_IRVendCost;
      p_desrciption:=zssi_getElementTextByColumname('Vendorcost',p_lang);
      if p_plannedamt>0 or p_amt>0 then
        RETURN NEXT;
      end if;
      -- Spezieller Teil: Produktspezifisch
      p_desrciption:='';
      v_IRVendCost:=0;
      v_IPVendCost:=0;
      for v_cur in (select p.ma_indirect_cost_id,pv.m_product_id,t.c_projecttask_id,t.istaskcancelled
                    from zspm_ptaskindcostplan p, c_projecttask t ,ma_indirect_cost_value_product pv
                    where pv.ma_indirect_cost_value_id=
                    (select ma_indirect_cost_value_id from ma_indirect_cost_value where ma_indirect_cost_id=p.ma_indirect_cost_id
                            and datefrom<=now() and cost_uom='P' and isactive='Y'  LIMIT 1) 
                    and t.c_projecttask_id=p.c_projecttask_id 
                    and t.c_project_id in (p_project_id) order by pv.m_product_id)
      loop
        if v_cur.m_product_id!=v_product then
            if v_product!='' then
                p_plannedamt:=v_IPVendCost;
                p_amt:=v_IRVendCost;
                p_product_id:=v_product;
                v_IRVendCost:=0;
                v_IPVendCost:=0;
                if p_plannedamt>0 or p_amt>0 then
                    RETURN NEXT;
                end if;
            end if;
            v_product:=v_cur.m_product_id;
        end if;
        if v_cur.istaskcancelled='N' then
            select p_vendorcost into v_IVendCost from
               zsco_get_indirect_cost(v_cur.ma_indirect_cost_id,now(),'P',v_cur.c_projecttask_id,'plan',v_cur.m_product_id);
            v_IPVendCost:=v_IPVendCost + v_IVendCost ;
        end if;
        select p_vendorcost into v_IVendCost from
               zsco_get_indirect_cost(v_cur.ma_indirect_cost_id,now(),'P',v_cur.c_projecttask_id,'fact',v_cur.m_product_id);
        v_IRVendCost:=v_IRVendCost + v_IVendCost ;
      end loop;
      if v_product!='' then
           p_plannedamt:=v_IPVendCost;
           p_amt:=v_IRVendCost;
           p_product_id:=v_product;
           v_IRVendCost:=0;
           v_IPVendCost:=0;
           if p_plannedamt>0 or p_amt>0 then
                RETURN NEXT;
            end if;
      end if;
END;
$_$ LANGUAGE plpgsql VOLATILE COST 100;

 
  
  
CREATE OR REPLACE FUNCTION zssi_getvendorservices4projectcalculation(p_project_id varchar, OUT p_plannedamt numeric, OUT p_amt NUMERIC, OUT p_product_id VARCHAR, OUT p_desrciption VARCHAR) RETURNS SETOF RECORD 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_cur RECORD;
v_plan numeric;
v_descr varchar;
BEGIN
      for v_cur in (select 0 as plannedamtemp,sum(il.linenetamt) as actualcostamounts,il.m_product_id,'' as description , 'I' as hint
                             from c_invoiceline il,c_invoice i
                             where il.c_invoice_id=i.c_invoice_id and i.docstatus = 'CO' and ad_get_docbasetype(i.c_doctype_id)='API'
                                   and il.c_project_id in (p_project_id) 
                                   and (select producttype  from m_product where m_product_id=il.m_product_id)='S'
                                   and (select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=il.m_product_id) = 'N'
                                   group by il.m_product_id
                    union
                    -- G/L Manual Bookings on Project
                    select 0 as plannedamtemp,coalesce(sum(round(case when ml.isgross='N' or t.rate=0 then ml.amt*case when ml.isdr2cr='Y' then 1 else -1 end else case when ml.isdr2cr='Y' then 1 else -1 end * ml.amt-ml.amt/(1+100/t.rate) end,2)),0)
                                              as actualcostamounts , '' as m_product_id, 'BAR-Belege' as description, 'I' as hint
                                                                                                     from zsfi_macctline ml, zsfi_manualacct mic,c_tax t 
                                                                                                     where  ml.c_project_id in (p_project_id)  and
                                                                                                     t.c_tax_id=ml.c_tax_id and
                                                                                                     mic.zsfi_manualacct_id=ml.zsfi_manualacct_id and 
                                                                                                     mic.glstatus='PO'
                    union
                    select sum(pte.plannedamt) as plannedamtemp,0 as actualcostamounts,pte.m_product_id,pte.description , 'P' as hint
                             from c_projecttaskexpenseplan pte,c_projecttask pt, c_project p 
                             where p.c_project_id=pt.c_project_id and pt.c_projecttask_id=pte.c_projecttask_id and p.c_project_id in (p_project_id) and pt.istaskcancelled='N'
                                   and case when pte.m_product_id is not null then
                                          (select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=pte.m_product_id) = 'N' 
                                       else 1=1 end
                                   and not exists (select 0 from c_invoiceline il,c_invoice i
                                                where il.c_invoice_id=i.c_invoice_id and i.docstatus = 'CO' and ad_get_docbasetype(i.c_doctype_id)='API'
                                                      and (select producttype  from m_product where m_product_id=il.m_product_id)='S'
                                                      and il.c_project_id in (p_project_id)
                                                      and il.m_product_id=pte.m_product_id)
                    group by pte.m_product_id,pte.description 
                   )
      LOOP
        if v_cur.hint='I' then
            select  sum(pte.plannedamt) ,max(pte.description) into v_plan,v_descr from c_projecttaskexpenseplan pte,c_projecttask pt, c_project p 
                    where p.c_project_id=pt.c_project_id and pt.c_projecttask_id=pte.c_projecttask_id 
                    and p.c_project_id in (p_project_id) and pt.istaskcancelled='N'
                    and pte.m_product_id=v_cur.m_product_id;
           p_plannedamt:= coalesce(v_plan,0);
           p_desrciption:=coalesce(v_descr,'')||v_cur.description;
           p_product_id:=v_cur.m_product_id;
           p_amt:=v_cur.actualcostamounts;
        else
           p_plannedamt:= v_cur.plannedamtemp;
           p_desrciption:=v_cur.description;
           p_product_id:=v_cur.m_product_id;
           p_amt:=v_cur.actualcostamounts;
        end if;
        RETURN NEXT;
      END LOOP;
END;
$_$ LANGUAGE plpgsql VOLATILE COST 100;



CREATE OR REPLACE FUNCTION zssi_getvendorExternalservices4projectcalculation(p_project_id varchar, OUT p_plannedamt numeric, OUT p_amt NUMERIC, OUT p_product_id VARCHAR, OUT p_desrciption VARCHAR) RETURNS SETOF RECORD 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_cur RECORD;
v_plan numeric;
v_descr varchar;
BEGIN
      for v_cur in (select 0 as plannedamtemp,sum(il.linenetamt) as actualcostamounts,il.m_product_id,'' as description , 'I' as hint
                             from c_invoiceline il,c_invoice i
                             where il.c_invoice_id=i.c_invoice_id and i.docstatus = 'CO' and ad_get_docbasetype(i.c_doctype_id)='API'
                                   and il.c_project_id in (p_project_id) 
                                   and (select producttype  from m_product where m_product_id=il.m_product_id)='S'
                                   and (select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=il.m_product_id) = 'Y'
                                   group by il.m_product_id
                    union
                    select sum(pte.plannedamt) as plannedamtemp,0 as actualcostamounts,pte.m_product_id,pte.description , 'P' as hint
                             from c_projecttaskexpenseplan pte,c_projecttask pt, c_project p 
                             where p.c_project_id=pt.c_project_id and pt.c_projecttask_id=pte.c_projecttask_id and p.c_project_id in (p_project_id) and pt.istaskcancelled='N' and 
                                   (select isexternalservice from m_product_category pc,m_product p where pc.m_product_category_id=p.m_product_category_id and p.m_product_id=pte.m_product_id) = 'Y' 
                                   and not exists (select 0 from c_invoiceline il,c_invoice i
                                                where il.c_invoice_id=i.c_invoice_id and i.docstatus = 'CO' and ad_get_docbasetype(i.c_doctype_id)='API'
                                                      and (select producttype  from m_product where m_product_id=il.m_product_id)='S'
                                                      and il.c_project_id in (p_project_id)
                                                      and il.m_product_id=pte.m_product_id)
                    group by pte.m_product_id,pte.description 
                   )
      LOOP
        if v_cur.hint='I' then
            select  sum(pte.plannedamt) ,max(pte.description) into v_plan,v_descr from c_projecttaskexpenseplan pte,c_projecttask pt, c_project p 
                    where p.c_project_id=pt.c_project_id and pt.c_projecttask_id=pte.c_projecttask_id and pt.istaskcancelled='N'
                    and p.c_project_id in (p_project_id)
                    and pte.m_product_id=v_cur.m_product_id;
           p_plannedamt:= coalesce(v_plan,0);
           p_desrciption:=coalesce(v_descr,'');
           p_product_id:=v_cur.m_product_id;
           p_amt:=v_cur.actualcostamounts;
        else
           p_plannedamt:= v_cur.plannedamtemp;
           p_desrciption:=v_cur.description;
           p_product_id:=v_cur.m_product_id;
           p_amt:=v_cur.actualcostamounts;
        end if;
        RETURN NEXT;
      END LOOP;
END;
$_$ LANGUAGE plpgsql VOLATILE COST 100;





CREATE OR REPLACE FUNCTION zspm_copyProject(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
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
Part of Projects, 
 Cancel Feedback for Project-Task
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message character varying:='Sucess';
v_ProductionOrder_id    VARCHAR;   -- Target, for link
v_cur RECORD;
v_projid character varying;
v_org varchar;
v_name varchar;
v_value varchar;
v_link varchar;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,ad_org_id into v_Record_ID, v_User ,v_org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    IF (v_Record_ID IS NOT NULL) then
        FOR v_cur IN (SELECT pi.Record_ID, p.ParameterName,  p.P_String,     p.P_Number,   p.P_Date   
                      FROM AD_PINSTANCE pi, AD_PINSTANCE_PARA p 
                      WHERE pi.AD_PInstance_ID=p.AD_PInstance_ID and pi.AD_PInstance_ID=p_PInstance_ID
        )
      LOOP
        if v_cur.ParameterName='name' then v_name:=v_cur.P_String; end if; -- c_project.value
        if v_cur.ParameterName='value' then v_value:=v_cur.P_String; end if; 
      END LOOP; -- Get Parameter
    END if;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    v_ProductionOrder_id := get_uuid();
    if v_org='0' then
        select ad_org_id into v_org from c_project where c_project_id=v_Record_ID;
    end if;
    if v_value is null then
        SELECT zssi_getNewProjectValue(v_org) into v_value;
    end if;
    v_message := (select zspm_Copy_Project(v_Record_ID,v_ProductionOrder_id,v_value,v_name,v_User,v_org));
    v_link := (SELECT zsse_htmlLinkDirectKey(  '../org.openbravo.zsoft.project.Projects/ProjectHeader157_Edition.html',v_ProductionOrder_id,  v_value));
    v_message :=  v_link;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  


CREATE OR REPLACE FUNCTION zspm_Copy_Project (
  p_ProductionPlan_ID    VARCHAR, -- source to copy from
  p_ProductionOrder_ID   VARCHAR, -- target to copy to
  p_ProductionOrderValue VARCHAR, -- NEW productionOrderValue
  p_ProductionOrderName  VARCHAR, -- NEW productionOrderName
  p_user_id VARCHAR,
  p_org varchar
 )
RETURNS VARCHAR -- '@Success@'
AS $body$
DECLARE
  v_org varchar;
  v_user_id varchar:= p_user_id;
  v_projecttype c_project%ROWTYPE;
  v_cur RECORD;
  v_cur2 RECORD;
  v_tasktype  c_projecttask%ROWTYPE;
  v_bomtype  zspm_projecttaskbom%ROWTYPE;
  v_explantype  c_projecttaskexpenseplan%ROWTYPE;
  v_hrplantype  zspm_ptaskhrplan%ROWTYPE;
  v_icostplantype  zspm_ptaskindcostplan%ROWTYPE;
  v_machplantype  zspm_ptaskmachineplan%ROWTYPE;
  v_now TIMESTAMP:=now();
  v_projecttask_id varchar;
  v_oldtaskid varchar;
  v_message varchar;
BEGIN
    v_message := 'copying project';
    IF (isempty(p_user_id)) THEN
      v_user_id := '0';
    END IF;
    SELECT * FROM c_project ppv INTO v_projecttype  WHERE ppv.c_project_id = p_ProductionPlan_ID; -- PRoject
    IF (NOT isEmpty(v_projecttype.c_project_id) and p_ProductionOrderValue is not null ) THEN
      v_projecttype.c_project_id := p_ProductionOrder_ID; -- set target
      v_projecttype.created := v_now;
      v_projecttype.createdby := v_user_id;
      v_projecttype.isactive := 'Y';
      v_projecttype.updated := v_now;
      v_projecttype.updatedby := v_user_id;
      v_projecttype.value := p_ProductionOrderValue;
      v_projecttype.name := COALESCE(p_ProductionOrderName, v_projecttype.name);
      v_projecttype.projectstatus := 'OP'; -- Draft
      v_projecttype.ad_org_id:=p_org;      
      INSERT INTO c_project SELECT v_projecttype.*; -- ROWTYPE
      -- Tasks
      for v_cur in (select * from c_projecttask where c_project_id=p_ProductionPlan_ID)
      LOOP
        select * from c_projecttask into v_tasktype where c_projecttask_id=v_cur.c_projecttask_id;
        select get_uuid() into v_projecttask_id;
        v_oldtaskid:=v_tasktype.c_projecttask_id;
        -- Common settings
        v_tasktype.c_project_id := p_ProductionOrder_ID; -- set target
        v_tasktype.created := v_now;
        v_tasktype.createdby := v_user_id;
        v_tasktype.isactive := 'Y';
        v_tasktype.updated := v_now;
        v_tasktype.updatedby := v_user_id;
        v_tasktype.ad_org_id:=p_org;
        v_tasktype.c_projecttask_id=v_projecttask_id;
        -- Specific
        v_tasktype.iscomplete:='N';
        v_tasktype.taskbegun:='N';
        v_tasktype.ismaterialdisposed:='N';
        v_tasktype.istaskcancelled:='N';
        v_tasktype.qtyproduced:=0;
        -- Create data
        INSERT INTO c_projecttask SELECT v_tasktype.*;
        delete from zspm_ptaskindcostplan where c_projecttask_id=v_projecttask_id;
        -- BOM
        for v_cur2 in (select * from zspm_projecttaskbom where c_projecttask_id=v_oldtaskid)
        LOOP
            select * from zspm_projecttaskbom into v_bomtype  where zspm_projecttaskbom_id=v_cur2.zspm_projecttaskbom_id;
            -- Common settings
            v_bomtype.created := v_now;
            v_bomtype.createdby := v_user_id;
            v_bomtype.isactive := 'Y';
            v_bomtype.updated := v_now;
            v_bomtype.updatedby := v_user_id;
            v_bomtype.ad_org_id:=p_org;
            v_bomtype.c_projecttask_id=v_projecttask_id;
            -- Specific
            v_bomtype.zspm_projecttaskbom_id=get_uuid();
            v_bomtype.qtyReserved := 0;
            v_bomtype.qtyReceived := 0;
            v_bomtype.qtyInrequisition := 0;
            v_bomtype.qty_plan := NULL;  -- Verschnitt
            -- Create data
            INSERT INTO zspm_projecttaskbom SELECT v_bomtype.*;
        END LOOP; -- BOM
        for v_cur2 in (select * from c_projecttaskexpenseplan where c_projecttask_id=v_oldtaskid)
        LOOP
            select * from c_projecttaskexpenseplan into v_explantype  where c_projecttaskexpenseplan_id=v_cur2.c_projecttaskexpenseplan_id;
            -- Common settings
            v_explantype.created := v_now;
            v_explantype.createdby := v_user_id;
            v_explantype.isactive := 'Y';
            v_explantype.updated := v_now;
            v_explantype.updatedby := v_user_id;
            v_explantype.ad_org_id:=p_org;
            v_explantype.c_projecttask_id=v_projecttask_id;
            -- Specific
            v_explantype.c_projecttaskexpenseplan_id=get_uuid();
            -- Create data
            INSERT INTO c_projecttaskexpenseplan SELECT v_explantype.*;
         END LOOP; -- expenseplan
         for v_cur2 in (select * from zspm_ptaskhrplan where c_projecttask_id=v_oldtaskid)
         LOOP
            select * from zspm_ptaskhrplan into v_hrplantype  where zspm_ptaskhrplan_id=v_cur2.zspm_ptaskhrplan_id;
            -- Common settings
            v_hrplantype.created := v_now;
            v_hrplantype.createdby := v_user_id;
            v_hrplantype.isactive := 'Y';
            v_hrplantype.updated := v_now;
            v_hrplantype.updatedby := v_user_id;
            v_hrplantype.ad_org_id:=p_org;
            v_hrplantype.c_projecttask_id=v_projecttask_id;
            -- Specific
            v_hrplantype.zspm_ptaskhrplan_id=get_uuid();
            -- Create data
            INSERT INTO zspm_ptaskhrplan SELECT v_hrplantype.*;
         END LOOP; -- hrplan
         for v_cur2 in (select * from zspm_ptaskindcostplan where c_projecttask_id=v_oldtaskid)
         LOOP
            select * from zspm_ptaskindcostplan into v_icostplantype  where zspm_ptaskindcostplan_id=v_cur2.zspm_ptaskindcostplan_id;
            -- Common settings
            v_icostplantype.created := v_now;
            v_icostplantype.createdby := v_user_id;
            v_icostplantype.isactive := 'Y';
            v_icostplantype.updated := v_now;
            v_icostplantype.updatedby := v_user_id;
            v_icostplantype.ad_org_id:=p_org;
            v_icostplantype.c_projecttask_id=v_projecttask_id;
            -- Specific
            v_icostplantype.zspm_ptaskindcostplan_id=get_uuid();
            -- Create data
            INSERT INTO zspm_ptaskindcostplan SELECT v_icostplantype.*;
         END LOOP; -- indcostplan
         for v_cur2 in (select * from zspm_ptaskmachineplan where c_projecttask_id=v_oldtaskid)
         LOOP
            select * from zspm_ptaskmachineplan into v_machplantype  where zspm_ptaskmachineplan_id=v_cur2.zspm_ptaskmachineplan_id;
            -- Common settings
            v_machplantype.created := v_now;
            v_machplantype.createdby := v_user_id;
            v_machplantype.isactive := 'Y';
            v_machplantype.updated := v_now;
            v_machplantype.updatedby := v_user_id;
            v_machplantype.ad_org_id:=p_org;
            v_machplantype.c_projecttask_id=v_projecttask_id;
            -- Specific
            v_machplantype.zspm_ptaskmachineplan_id=get_uuid();
            -- Create data
            INSERT INTO zspm_ptaskmachineplan SELECT v_machplantype.*;
         END LOOP; -- machineplan
      END LOOP; -- Task
    ELSE
      v_message := '@NeedValueToCopyProject@';
      RAISE EXCEPTION '%', v_message;
    END IF;
    RETURN '@Success@';
  END;
$body$ LANGUAGE 'plpgsql';
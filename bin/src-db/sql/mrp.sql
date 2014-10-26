

select zsse_dropfunction('mrp_check_planningmethod');

CREATE OR REPLACE FUNCTION mrp_check_planningmethod (
  p_planningmethod_id VARCHAR,
  p_type VARCHAR
)
RETURNS NUMERIC AS
/*
  SELECT Mrp_Check_Planningmethod(
    '6192C3D3F32B457DB600EF61BD47E6A3', -- 'PO' --  COALESCE(po.MRP_PlanningMethod_ID, p.MRP_PlanningMethod_ID),
    'SO', TO_NUMBER(COALESCE(null, to_timestamp('2012-06-02', 'yyyy-mm-dd')) - to_timestamp('2012-05-30', 'yyyy-mm-dd')), 2)
    */
$body$
 DECLARE
  v_Days_Aux NUMERIC:= 0;
  v_Return NUMERIC:= -1;
BEGIN
    SELECT pml.weighting
    INTO v_Return
    FROM mrp_planningmethodline pml
    WHERE pml.mrp_planningmethod_id = p_PlanningMethod_ID
    AND pml.inouttrxtype = p_Type;
 -- duration due to calendar-days, non-working-days not considered
 --  raise notice 'mrp_check_planningmethod: id=%, type=%, days=%, timehorizon=%, v_result=% Info:% verbl:%', p_planningmethod_id, p_type, p_Days,
 --                p_timehorizon, COALESCE(v_Return, -1),
 --                CASE COALESCE(v_Return, -1) WHEN 1 THEN 'sofort bestellen' ELSE 'später bestellen' END AS info, v_Days_Aux - p_TimeHorizon AS verbl;
    RETURN COALESCE(v_Return, -1); --  -1=not within p_TimeHorizon
EXCEPTION
  WHEN OTHERS THEN
    RETURN -1;
END ;
$body$
LANGUAGE 'plpgsql'
COST 100;



CREATE OR REPLACE FUNCTION mrp_purchase_run(p_pinstance_id character varying) RETURNS void
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/*************************************************************************
* The contents of this file are subject to the Openbravo  Public  License
* Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this
* file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html
* Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
* License for the specific  language  governing  rights  and  limitations
* under the License.
* The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL
* All portions are Copyright (C) 2001-2006 Openbravo SL
* All Rights Reserved.
* Contributor(s):  ______________________________________.
************************************************************************/
  -- Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Result NUMERIC:=1; -- 0=failure
  v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_User_ID VARCHAR(32):='0'; --OBTG:VARCHAR2--
  v_Org_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Client_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Planner_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Product_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Product_Category_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_BPartner_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_BP_Group_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Vendor_ID   VARCHAR(32); --OBTG:varchar2--
  v_TimeHorizon NUMERIC;
  v_PlanningDate TIMESTAMP;
  v_SecurityMargin NUMERIC;
  v_warehouse varchar;

  FINISH_PROCESS BOOLEAN DEFAULT FALSE;
  --  Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
  BEGIN
    RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
  BEGIN --BODY
    -- Get Parameters
    v_ResultStr:='ReadingParameters';
    FOR Cur_Parameter IN
      (SELECT i.Record_ID, i.AD_User_ID, p.ParameterName, p.P_String, p.P_Number, p.P_Date
      FROM AD_PInstance i
      LEFT JOIN AD_PInstance_Para p
        ON i.AD_PInstance_ID=p.AD_PInstance_ID
      WHERE i.AD_PInstance_ID=p_PInstance_ID
      ORDER BY p.SeqNo
      )
    LOOP
      v_Record_ID:=Cur_Parameter.Record_ID;
      v_User_ID:=Cur_Parameter.AD_User_ID;
    END LOOP; -- Get Parameter

    SELECT AD_Client_ID, AD_Org_ID, MRP_Planner_ID, M_Product_ID, M_Product_Category_ID, C_BPartner_ID,
         C_BP_Group_ID, TimeHorizon, SecurityMargin, datedoc, Vendor_ID,m_warehouse_id
    INTO v_Client_ID, v_Org_ID, v_Planner_ID, v_Product_ID, v_Product_Category_ID, v_BPartner_ID,
         v_BP_Group_ID, v_TimeHorizon, v_SecurityMargin, v_PlanningDate, v_Vendor_ID,v_warehouse
    FROM MRP_RUN_PURCHASE
    WHERE MRP_RUN_PURCHASE_ID=V_Record_ID;

    PERFORM MRP_RUN_INITIALIZE(v_User_ID, v_Org_ID, v_Client_ID, v_Record_ID, v_Planner_ID, v_Product_ID,
                       v_Product_Category_ID, v_BPartner_ID, v_BP_Group_ID, v_Vendor_ID, v_TimeHorizon,
                       v_PlanningDate,v_warehouse);

    PERFORM MRP_PURCHASEPLAN(v_User_ID, v_Org_ID, v_Client_ID, v_Record_ID, v_Planner_ID, v_Vendor_ID, v_TimeHorizon,
                    v_PlanningDate, v_SecurityMargin,v_warehouse);

    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', v_Result, v_Message) ;
  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  RAISE NOTICE '%','MRP_PURCHASE_RUN exception: ' || v_ResultStr ;
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr ;
  -- ROLLBACK;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
--  RETURN;
END ; $_$;



select zsse_dropfunction('mrp_run_initialize');

CREATE OR REPLACE FUNCTION mrp_run_initialize(p_user_id character varying, p_org_id character varying, p_client_id character varying, p_run character varying, p_planner_id character varying, p_product_id character varying, p_product_category_id character varying, p_bpartner_id character varying, p_bp_group_id character varying, p_vendor_id character varying, pp_timehorizon numeric, p_planningdate timestamp without time zone,p_Warehouse_ID varchar) RETURNS void
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
* Contributions: Do not collect data From m_product. We use m_product_org
*                Take Datepo, if Datepromised is empty
*                Truncate Dates, hours don't make sense in planning (Prevents planning with Dates in the same day)
*                Added MULTIORG
@TODO : Truncate Date in PR, Forcasts etc. , too
****************************************************************************************************************************************************/
  -- Logistice
  v_ResultStr VARCHAR(4000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(4000):=''; --OBTG:VARCHAR2--
  v_Result NUMERIC:=1; -- 0=failure

  v_Count NUMERIC;
  v_Aux_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_ParentLine VARCHAR(32); --OBTG:VARCHAR2--

  FINISH_PROCESS BOOLEAN DEFAULT FALSE;
  --  Parameter
  --TYPE RECORD IS REFCURSOR;
  Cur_Product RECORD;
  Cur_OrderLine RECORD;
  Cur_Phase RECORD;
  Cur_SalesForeCast RECORD;
  Cur_RequisitionLine RECORD;
  Cur_Phase_Dependants RECORD;
  p_timehorizon numeric;
BEGIN
  BEGIN --BODY
    -- Get Parameters
    if pp_timehorizon=0 then p_timehorizon:=10000; else p_timehorizon:=pp_timehorizon; end if;
    delete from mrp_run_purchaseline where mrp_run_purchase_id=p_run;
    FOR Cur_Product IN (SELECT p.M_Product_ID, COALESCE(sd.qtyonhand,0) AS qtyonhand,
                        coalesce((select sum(COALESCE(pog.STOCKMIN, 0)) from M_PRODUCT_ORG pog where p.M_PRODUCT_ID = pog.M_PRODUCT_ID and pog.AD_ORG_ID = p_Org_ID and
                                  case when p_Warehouse_ID IS NULL then 1=1 else pog.m_locator_id in (select m_locator_id from m_locator where m_warehouse_id= p_Warehouse_ID) end),0) AS STOCKMIN,
                        coalesce((select sum(COALESCE(pog.qtyoptimal, 0)) from M_PRODUCT_ORG pog where p.M_PRODUCT_ID = pog.M_PRODUCT_ID and pog.AD_ORG_ID = p_Org_ID and
                                  case when p_Warehouse_ID IS NULL then 1=1 else pog.m_locator_id in (select m_locator_id from m_locator where m_warehouse_id= p_Warehouse_ID) end),0) AS qtyoptimal,
                        COALESCE(po.MRP_PlanningMethod_ID, 
                                 (select MRP_PlanningMethod_ID from MRP_PlanningMethod where isstandard='Y' and isactive='Y' limit 1)) AS MRP_PlanningMethod_ID
                        FROM M_PRODUCT p LEFT JOIN ( select m_product_id,MRP_PLANNER_ID,MRP_PlanningMethod_ID from M_PRODUCT_ORG  where
                                                                       AD_ORG_ID = p_Org_ID
                                                                       AND isvendorreceiptlocator = 'Y'
                                                                       AND case when p_Warehouse_ID IS NULL then 1=1 else 
                                                                       m_locator_id in (select m_locator_id from m_locator where m_warehouse_id=p_Warehouse_ID) end
                                                                       LIMIT 1) po ON p.M_PRODUCT_ID = po.M_PRODUCT_ID
                                         LEFT JOIN (SELECT d.M_Product_ID, SUM(d.qtyonhand) as qtyonhand
                                                    FROM M_STORAGE_DETAIL d,m_locator l,m_warehouse w
                                                    WHERE d.m_locator_id=l.m_locator_id and l.m_warehouse_id=w.m_warehouse_id and w.isblocked='N' and l.AD_ORG_ID in (p_org_id,'0') and
                                                          case when p_Warehouse_ID IS NULL then 1=1 else l.m_warehouse_id=p_Warehouse_ID end
                                                    GROUP BY M_Product_ID) sd ON p.M_Product_ID = sd.M_Product_ID
                        WHERE (p_product_ID IS NULL OR p.M_PRODUCT_ID = p_Product_ID)
                          AND (p_Product_Category_ID IS NULL OR p.M_PRODUCT_CATEGORY_ID = p_Product_Category_ID)
                          AND (p_Planner_ID IS NULL OR COALESCE(po.MRP_PLANNER_ID, p.MRP_Planner_ID) = p_Planner_ID)
                          AND p.AD_ORG_ID in ('0',p_org_id)
                          AND p.AD_Client_ID = p_Client_ID
                          AND p.production='N' and p.ISPURCHASED = 'Y' and p.isstocked='Y'
                          AND (p_Vendor_ID IS NULL
                               OR EXISTS (SELECT 1
                                          FROM M_PRODUCT_PO
                                          WHERE M_PRODUCT_PO.M_PRODUCT_ID = p.M_PRODUCT_ID
                                            AND M_PRODUCT_PO.C_BPARTNER_ID = p_Vendor_ID
                                            AND M_PRODUCT_PO.ISCURRENTVENDOR = 'Y'
                                            AND M_PRODUCT_PO.ISACTIVE = 'Y'
                                            AND M_PRODUCT_PO.AD_ORG_ID in ('0',p_org_id)
                                          ))
                          AND (p_Warehouse_ID IS NULL
                               OR EXISTS (SELECT 1
                                          FROM M_PRODUCT_ORG org
                                          WHERE org.M_PRODUCT_ID = p.M_PRODUCT_ID
                                            AND org.m_locator_id in (select m_locator_id from m_locator where m_warehouse_id=p_Warehouse_ID)
                                            AND org.isvendorreceiptlocator = 'Y'
                                            AND org.ISACTIVE = 'Y'
                                            AND org.AD_ORG_ID in ('0',p_org_id)
                                          ))
                          AND (p_BPartner_ID IS NULL
                               OR EXISTS (SELECT 1
                                          FROM C_ORDER o, C_ORDERLINE ol
                                          WHERE o.C_ORDER_ID = ol.C_ORDER_ID
                                            AND o.C_BPARTNER_ID = p_BPartner_ID
                                            AND o.IsSOTrx = 'Y'
                                            AND o.docstatus='CO'
                                            AND ol.deliverycomplete='N'
                                            AND Mrp_Check_Planningmethod(COALESCE(po.MRP_PlanningMethod_ID, p.MRP_PlanningMethod_ID),'SO') <> -1
                                            AND coalesce(ol.scheddeliverydate,now())<=p_PlanningDate+p_TimeHorizon
                                            AND o.AD_ORG_ID in ('0',p_org_id)
                               )
                               OR EXISTS (SELECT 1
                                          FROM MRP_SALESFORECAST sf, MRP_SALESFORECASTLINE sfl
                                          WHERE sf.MRP_SALESFORECAST_ID = sfl.MRP_SALESFORECAST_ID
                                            AND sf.IsActive = 'Y'
                                            AND sf.C_BPARTNER_ID = p_BPartner_ID
                                            AND Mrp_Check_Planningmethod(COALESCE(po.MRP_PlanningMethod_ID, p.MRP_PlanningMethod_ID),'SF') <> -1
                                            AND coalesce(sfl.DatePlanned,now())<=p_PlanningDate+p_TimeHorizon
                                            AND sf.AD_ORG_ID in ('0',p_org_id)
                              ))
                          AND (p_BP_Group_ID IS NULL
                               OR EXISTS(SELECT 1
                                         FROM C_ORDER o, C_ORDERLINE ol, C_BPARTNER bp
                                         WHERE o.C_ORDER_ID = ol.C_ORDER_ID
                                           AND o.C_BPartner_ID = bp.C_BPartner_ID
                                           AND o.IsSOTrx = 'Y'
                                           AND bp.C_BP_Group_ID = p_BP_Group_ID
                                           AND o.docstatus='CO'
                                           AND ol.deliverycomplete='N'
                                           AND Mrp_Check_Planningmethod(COALESCE(po.MRP_PlanningMethod_ID, p.MRP_PlanningMethod_ID),'SO') <> -1
                                           AND coalesce(ol.scheddeliverydate,now())<=p_PlanningDate+p_TimeHorizon
                                           AND o.AD_ORG_ID in ('0',p_org_id)
                                )
                                OR EXISTS (SELECT 1
                                           FROM MRP_SALESFORECAST sf, MRP_SALESFORECASTLINE sfl, C_BPARTNER bp
                                           WHERE sf.MRP_SALESFORECAST_ID = sfl.MRP_SALESFORECAST_ID
                                             AND sf.IsActive = 'Y'
                                             AND sf.C_BPartner_ID = bp.C_BPartner_ID
                                             AND bp.C_BP_Group_ID = p_BP_Group_ID
                                             AND Mrp_Check_Planningmethod(COALESCE(po.MRP_PlanningMethod_ID, p.MRP_PlanningMethod_ID),'SF') <> -1
                                             AND coalesce(sfl.DatePlanned,now())<=p_PlanningDate+p_TimeHorizon
                                             AND sf.AD_ORG_ID in ('0',p_org_id)
                              ))
      ) LOOP

        --raise notice '%','ÄÄÄÄ'||Cur_Product.STOCKMIN||'ÜÜÜÜÜ'||Cur_Product.QtyOnHand;
        SELECT COUNT(*) INTO v_Count FROM MRP_RUN_PURCHASELINE  WHERE M_PRODUCT_ID = Cur_Product.M_Product_ID   AND MRP_RUN_PURCHASE_ID = p_Run   AND inouttrxtype = 'MS';
        IF (v_Count = 0) THEN -- First time on this product
          v_ResultStr := 'Inserting stock lines product: ' || Cur_Product.M_Product_ID;
          --raise notice '%','huhuhu'||Cur_Product.QtyOnHand||p_PlanningDate||p_org_id;
          SELECT * INTO  v_Aux_ID FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run, Cur_Product.M_Product_ID, (-1 * Cur_Product.STOCKMIN),  'MS',  NULL, NULL, NULL, NULL,p_PlanningDate,  NULL,p_Warehouse_ID);
          if Cur_Product.qtyoptimal>0 then
            SELECT * INTO  v_Aux_ID FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run, Cur_Product.M_Product_ID, (-1 * (Cur_Product.qtyoptimal-Cur_Product.STOCKMIN)),  'OS',  NULL, NULL, NULL, NULL,p_PlanningDate,  NULL,p_Warehouse_ID);
          end if;
          SELECT * INTO  v_Aux_ID FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run, Cur_Product.M_Product_ID, Cur_Product.QtyOnHand,  'ST',  NULL, NULL, NULL, NULL,p_PlanningDate,   NULL,p_Warehouse_ID);
          v_ResultStr := 'Inserting Order lines product: ' || Cur_Product.M_Product_ID;

        FOR Cur_OrderLine IN (SELECT * from mrp_inoutplan_v 
                                   where documenttype in ('SOO','POO')
                                   AND M_Product_ID = Cur_Product.M_Product_ID
                                   AND Mrp_Check_Planningmethod(Cur_Product.MRP_PlanningMethod_ID,(CASE documenttype WHEN 'SOO' THEN 'SO' ELSE 'PO' END))<>-1
                                   AND planneddate<=p_PlanningDate+p_TimeHorizon
                                   AND AD_ORG_ID=p_org_id
                                   AND case when p_Warehouse_ID IS NULL then 1=1 else m_warehouse_id= p_Warehouse_ID end
          ) LOOP
               SELECT * INTO  v_Aux_ID FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run, Cur_Product.M_Product_ID, Cur_OrderLine.movementqty, (CASE Cur_OrderLine.documenttype WHEN 'SOO' THEN 'SO' ELSE 'PO' END), Cur_OrderLine.C_OrderLine_ID, NULL, NULL, NULL,  Cur_OrderLine.planneddate, NULL,p_Warehouse_ID);
         END LOOP;
         -- Inserting Production Requirements
          FOR Cur_OrderLine IN (SELECT * from mrp_inoutplan_v 
                                       where  documenttype = 'PCONS'
                                       AND M_Product_ID = Cur_Product.M_Product_ID
                                       AND Mrp_Check_Planningmethod(Cur_Product.MRP_PlanningMethod_ID,'WR')<>-1
                                       AND planneddate<=p_PlanningDate+p_TimeHorizon
                                       AND AD_ORG_ID=p_org_id
                                       AND case when p_Warehouse_ID IS NULL then 1=1 else m_warehouse_id= p_Warehouse_ID end
          ) LOOP
               SELECT * INTO  v_Aux_ID FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run, Cur_Product.M_Product_ID, Cur_OrderLine.movementqty,'WR', NULL,Cur_OrderLine.c_projecttask_id, NULL, NULL,  Cur_OrderLine.planneddate, NULL,p_Warehouse_ID);
         END LOOP; 

          v_ResultStr := 'Inserting Sales forecast for product: ' || Cur_Product.M_Product_ID;
          FOR Cur_SalesForeCast IN (SELECT sfl.MRP_SALESFORECASTLINE_ID, GREATEST(sfl.DatePlanned, p_Planningdate) AS DatePlanned,
                                          -1*sfl.qty AS qty
                                     FROM MRP_SALESFORECAST sf, MRP_SALESFORECASTLINE sfl
                                     WHERE sf.MRP_SALESFORECAST_ID = sfl.MRP_SALESFORECAST_ID
                                       AND (sf.IsActive = 'Y' AND sfl.Isactive = 'Y')
                                       AND sfl.M_Product_ID = Cur_Product.M_Product_ID
                                       AND Mrp_Check_Planningmethod(Cur_Product.MRP_PlanningMethod_ID,'SF') <> -1
                                       AND sfl.DatePlanned<=p_PlanningDate+p_TimeHorizon
                                       AND sf.AD_ORG_ID in ('0',p_org_id)
          ) LOOP
            SELECT * INTO  v_Aux_ID FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run, Cur_Product.M_Product_ID, Cur_SalesForeCast.Qty,  'SF', NULL, NULL, Cur_SalesForeCast.MRP_SALESFORECASTLINE_ID, NULL, Cur_SalesForeCast.DatePlanned,  NULL,p_Warehouse_ID);
          END LOOP;

            v_ResultStr := 'Inserting Requisition lines for product: ' || Cur_Product.M_Product_ID;
            FOR Cur_RequisitionLine IN (SELECT r.M_RequisitionLine_ID, (-1)*(r.qty-r.orderedqty) AS qty,r.NeedByDate AS DATEPLANNED
                                          FROM M_REQUISITIONLINE r, M_REQUISITION rr
                                         WHERE r.isActive = 'Y'
                                           AND r.M_REQUISITION_ID = rr.M_REQUISITION_ID
                                           AND rr.DOCSTATUS = 'CO'
                                           AND r.REQSTATUS = 'O'
                                           AND r.LOCKEDBY is null
                                           AND Mrp_Check_Planningmethod(Cur_Product.MRP_PlanningMethod_ID,'MF') <> -1
                                           AND r.NeedByDate<=p_PlanningDate+p_TimeHorizon
                                           AND r.M_Product_ID = Cur_Product.M_Product_ID
                                           AND rr.AD_ORG_ID in ('0',p_org_id)
            ) LOOP
              SELECT * INTO  v_Aux_ID FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run, Cur_Product.M_Product_ID, Cur_RequisitionLine.qty, 'MF', NULL, NULL, NULL, Cur_RequisitionLine.M_RequisitionLine_ID,  Cur_RequisitionLine.DatePlanned,  NULL,p_Warehouse_ID);
              UPDATE M_REQUISITIONLINE
              SET LOCKEDBY = p_User_ID,
                  LOCKDATE = TO_DATE(NOW()),
                  LOCKQTY = Cur_RequisitionLine.qty,
                  LOCKCAUSE = 'P'
              WHERE M_REQUISITIONLINE_ID = Cur_RequisitionLine.M_RequisitionLine_ID;
            END LOOP;
        END IF; -- v_Count = 0
    END LOOP;

  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  RAISE NOTICE '%','MRP_RUN_INITIALIZE exception: ' || v_ResultStr;
  RAISE EXCEPTION '%', SQLERRM;
--  RETURN;
END ; $_$;


CREATE OR REPLACE FUNCTION mrp_run_purchaseline_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/

BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'DELETE' THEN 
      UPDATE M_REQUISITIONLINE
              SET LOCKEDBY =null, LOCKDATE = null, LOCKQTY = null, LOCKCAUSE = null
              WHERE M_REQUISITIONLINE_ID = old.M_REQUISITIONLINE_ID and (select r.docstatus from m_requisition r,m_requisitionline l
                                                                             where r.m_requisition_id=l.m_requisition_id and l.M_REQUISITIONLINE_ID = old.M_REQUISITIONLINE_ID)='CO';
   END IF;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
select zsse_droptrigger('mrp_run_purchaseline_trg','mrp_run_purchaseline');

CREATE TRIGGER mrp_run_purchaseline_trg
  AFTER DELETE
  ON mrp_run_purchaseline
  FOR EACH ROW
  EXECUTE PROCEDURE mrp_run_purchaseline_trg();

select zsse_dropfunction('mrp_purchaseplan');
CREATE OR REPLACE FUNCTION mrp_purchaseplan (
  p_user_id varchar,
  p_org_id varchar,
  p_client_id varchar,
  p_run_id varchar,
  p_planner_id varchar,         -- nicht verwendet
  p_vendor_id varchar,          -- nicht verwendet
  p_timehorizon numeric,        -- nicht verwendet
  p_planningdate timestamp,     -- nicht verwendet
  p_securitymargin numeric,
  p_warehouse varchar
)
RETURNS void AS
$body$
 DECLARE
/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, 02/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* Contributions: 0-Values are not there: Use coalesce, if no line
                 RULEZ: Only from m_product_org:
                        Capacity
                        qtymin: only a Multiplicator, if ismultipleofminimumqty = 'Y'
                        qtystd: Normal qty to order

                 Muliti-ORG: Each Organization may Purchase at different Partners
                 Qualityrating is being evaluated now.
@TODO:  Be aware of second UOM! - so things in m_product_org are evaluated on Purchasing"!
****************************************************************************************************************************************************/
  -- Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Result NUMERIC:=1; -- 0=failure

  v_Aux_New VARCHAR(32); --OBTG:VARCHAR2--

  v_scheddeliverydate DATE;
  v_neededQty_New NUMERIC;
  v_Qty_New NUMERIC;
  v_Qty_Old NUMERIC;
  v_plannedorderdate_new TIMESTAMP;
  v_planneddate_new TIMESTAMP;
  v_planneddate_old TIMESTAMP;
  v_vendor character varying;

  FINISH_PROCESS BOOLEAN DEFAULT FALSE;
  --  Parameter
  --TYPE RECORD IS REFCURSOR;
  Cur_PlanProduct RECORD;
  Cur_Lines RECORD;
  v_ismultipleofminimumqty CHAR;
  v_qtymin  NUMERIC;
  v_qtystd  NUMERIC;
  v_DELAYMIN NUMERIC;
  v_price numeric;
  v_daysbetweenplandateandnow numeric;
  v_auxQty numeric;
  v_framecontract varchar;
BEGIN
  BEGIN --BODY
    v_ResultStr := 'Purchase mrp';
    FOR Cur_PlanProduct IN (
        SELECT MRP_RUN_PURCHASELINE.M_PRODUCT_ID,
          sum(coalesce(M_PRODUCT_ORG.CAPACITY,0)) AS CAPACITY,
          sum(coalesce(M_PRODUCT_ORG.qtyoptimal,0)) as OPTIMALQTY
        FROM MRP_RUN_PURCHASELINE LEFT JOIN M_PRODUCT_ORG ON MRP_RUN_PURCHASELINE.AD_ORG_ID = M_PRODUCT_ORG.AD_ORG_ID
                                                             and MRP_RUN_PURCHASELINE.M_PRODUCT_ID = M_PRODUCT_ORG.M_PRODUCT_ID,
             M_PRODUCT 
        WHERE MRP_RUN_PURCHASE_ID = p_Run_ID
          AND M_PRODUCT.M_PRODUCT_ID = MRP_RUN_PURCHASELINE.M_PRODUCT_ID
          AND M_PRODUCT.ISPURCHASED = 'Y'
      GROUP BY MRP_RUN_PURCHASELINE.M_PRODUCT_ID, M_PRODUCT_ORG.CAPACITY,M_PRODUCT_ORG.qtyoptimal
    ) LOOP
    -- Gruppenwechsel Produkt/Artikel verarbeiten,
    -- alle bisherigen Datensaetze (mrp_run_purchaseline) zu einem Produkt/Artikel verarbeiten:
        select sum(qty) into  v_neededQty_New from MRP_RUN_PURCHASELINE where MRP_RUN_PURCHASE_ID = p_Run_ID  and M_PRODUCT_ID=Cur_PlanProduct.M_PRODUCT_ID
                                                   and inouttrxtype!='OS';
        --raise notice '%','RUUUUUUUN'||v_neededQty_New||'---'||Cur_PlanProduct.M_PRODUCT_ID;
        IF (v_neededQty_New < 0) THEN            
            -- Select Vendor with best rating.
            SELECT PO.C_BPARTNER_ID,   coalesce(qtystd,0),   ismultipleofminimumqty, coalesce(order_min,0), coalesce(deliverytime_promised,1) as deliverytime_promised,pricepo -- qtytype
            INTO           v_vendor, v_qtystd, v_ismultipleofminimumqty,  v_qtymin, v_DELAYMIN, v_price           -- v_qtytype
            FROM M_PRODUCT_PO po
            WHERE po.m_product_id=Cur_PlanProduct.M_Product_ID and PO.isactive='Y'  and po.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',p_org_id)
            ORDER BY COALESCE(po.qualityrating,0) DESC, updated DESC LIMIT 1;
            -- Select Planned Delivery Date
            -- The Date where the Order will be placed (p_planningdate) + securitymargin + leadtime
            v_daysbetweenplandateandnow:=trunc(p_planningdate)-trunc(now());
            select to_date(mrp_getsheddeliverydate4vendorProduct(v_vendor,Cur_PlanProduct.M_PRODUCT_ID,p_org_id),'dd.mm.yyyy') + p_securitymargin + v_daysbetweenplandateandnow into v_scheddeliverydate;
            -- The REAL needed QTY to Plan Date
            select coalesce(sum(qty),0) into v_neededQty_New
                   from MRP_RUN_PURCHASELINE where MRP_RUN_PURCHASE_ID = p_Run_ID and M_PRODUCT_ID=Cur_PlanProduct.M_PRODUCT_ID
                   and planneddate<=v_scheddeliverydate;
            -- Einkauf notwendig? - Dann füllen wir das Lager mit opt. Lagerbestand auf.            
            if v_neededQty_New < 0 then
                --raise exception '%', 'Date:'||v_scheddeliverydate||'-QTY-'||v_neededQty_New||'VEND:'||v_vendor;
                --
                -- If delivery will be too late, select quickest vendor, INIT qty with Current Stock QTY
                select coalesce(sum(qty),0) into v_auxQty from MRP_RUN_PURCHASELINE where MRP_RUN_PURCHASE_ID = p_Run_ID and 
                                              M_PRODUCT_ID=Cur_PlanProduct.M_PRODUCT_ID and inouttrxtype='ST';
                v_planneddate_new:=v_scheddeliverydate-p_securitymargin;
                for Cur_Lines in (select sum(qty) as qty,planneddate from MRP_RUN_PURCHASELINE where MRP_RUN_PURCHASE_ID = p_Run_ID and 
                                              M_PRODUCT_ID=Cur_PlanProduct.M_PRODUCT_ID 
                                              and inouttrxtype not in ('ST','OS','MS') group by planneddate order by planneddate)
                LOOP
                    v_auxQty:=v_auxQty+Cur_Lines.qty;
                    if v_auxQty<0 then
                        v_planneddate_new:=Cur_Lines.planneddate;
                        --raise exception '%', 'MIN!'||Cur_Lines.planneddate;
                        exit;
                    end if;
                END LOOP;
                If v_scheddeliverydate-p_securitymargin > v_planneddate_new then
                --Select the Quickes vendor
                    SELECT PO.C_BPARTNER_ID,   coalesce(qtystd,0),   ismultipleofminimumqty, coalesce(order_min,0),  coalesce(deliverytime_promised,1) as deliverytime_promised, pricepo-- qtytype
                    INTO           v_vendor, v_qtystd, v_ismultipleofminimumqty,  v_qtymin, v_DELAYMIN , v_price          -- v_qtytype
                    FROM M_PRODUCT_PO po
                    WHERE po.m_product_id=Cur_PlanProduct.M_Product_ID and PO.isactive='Y' and po.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',p_org_id)
                    ORDER BY COALESCE(po.deliverytime_promised,1)  LIMIT 1;
                end if;
                v_Qty_New := GREATEST(v_neededqty_New*-1, v_qtystd);
                --raise notice '%','UUUUUUUUUUU--'||p_Run_ID||'--'||Cur_PlanProduct.M_PRODUCT_ID||'---'||coalesce(v_planneddate_new,now()-10000)||coalesce(v_vendor,'______NOVVVV')||'-----'||coalesce(v_neededQty_New);
                v_Qty_New := GREATEST(v_Qty_New, COALESCE(v_qtymin,0)); -- MH
                -- Plan with given Shed. delivery Date., If Vendor can deliver to that date, Otherwise Plan with the Lead Time of the Vendor
                If to_date(mrp_getsheddeliverydate4vendorProduct(v_vendor,Cur_PlanProduct.M_PRODUCT_ID,p_org_id),'dd.mm.yyyy') > v_planneddate_new then
                    v_planneddate_new:=to_date(mrp_getsheddeliverydate4vendorProduct(v_vendor,Cur_PlanProduct.M_PRODUCT_ID,p_org_id),'dd.mm.yyyy') ;
                end if;
                -- SZ corrected multiplication
                --IF (v_qtytype = 'M' and coalesce(v_qtymin,0)!=0) THEN --Multiple lot qty
                IF (v_ismultipleofminimumqty = 'Y' AND COALESCE(v_qtymin,0)!=0) THEN --Multiple lot qty
                v_Qty_new := CEIL(v_qty_new/v_qtymin)*v_qtymin;
                END IF;
                
                -- 'mrp_run_purchaseline.inouttrxtype = 'PP' : 'Angebot Bestellung'
                SELECT * INTO  v_Aux_new FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run_ID, Cur_PlanProduct.M_Product_ID, v_qty_new,'PP',  NULL, NULL, NULL, NULL,v_Planneddate_new, v_vendor,p_warehouse);
                -- Be aware of Frame Contracts
                v_framecontract:=null;
                select ol.c_orderline_id into v_framecontract from c_orderline ol,c_order o where ol.c_order_id=o.c_order_id and o.c_doctype_id= '56913A519BA94EB59DAE5BF9A82F5F7D' 
                       and o.docstatus='CO' and ol.m_product_id=Cur_PlanProduct.M_Product_ID and o.c_bpartner_id=v_vendor and
                       ol.qtyordered-coalesce(ol.calloffqty,0) >= v_qty_new and o.contractdate <= v_Planneddate_new and o.enddate >= v_Planneddate_new;
                update mrp_run_purchaseline set neededqty = qty,pricelist=v_price,framecontractline=v_framecontract where mrp_run_purchaseline_id=v_Aux_new;
                
                -- MH: finally insert additional line, if qty is adjusted according std-qty or min-qty by purchase default
                IF (v_qty_new != v_neededqty_new) THEN
                SELECT * INTO  v_Aux_new FROM Mrp_Run_Insertlines(p_Client_ID, p_Org_ID, p_User_ID, p_Run_ID, Cur_PlanProduct.M_Product_ID, -(v_qty_new + v_neededqty_new), 'IQ',NULL, NULL, NULL, NULL,v_Planneddate_new, v_vendor,p_warehouse);
                END IF;
            END IF;
          END IF;  

    END LOOP;
  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  RAISE NOTICE '%','MRP_PURCHASEPLAN exception: ' || v_ResultStr;
  RAISE EXCEPTION '%', SQLERRM;
--  RETURN;
END ;
$body$
LANGUAGE 'plpgsql'
COST 100;

select zsse_dropfunction('mrp_run_insertlines');

CREATE OR REPLACE FUNCTION mrp_run_insertlines(p_client_id character varying, p_org_id character varying, p_user_id character varying, p_runID varchar, p_product_id character varying, p_qty numeric, p_inouttrxtype character, p_orderline_id character varying, p_projecttask_id character varying, p_salesforecastline_id character varying, p_requisitionline_id character varying,  p_planneddate timestamp without time zone, p_vendor_id character varying,p_warehouse_id varchar, OUT p_line_id character varying) RETURNS character varying
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
* Contributions: Don't insert 0 - Values
****************************************************************************************************************************************************/
  -- Logistice
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_plannedorderdate timestamp;
BEGIN
  BEGIN --BODY
    v_ResultStr := 'Inserting run lines';
    --raise notice '%', 'BEFInsert';
    If coalesce(p_Qty,0)!=0  then
          select datedoc into v_plannedorderdate from mrp_run_purchase where mrp_run_purchase_id=p_runID;
          SELECT * INTO  p_Line_ID FROM Ad_Sequence_Next('MRP_Run_PurchaseLine', p_User_ID);
          INSERT INTO MRP_RUN_PURCHASELINE (
            MRP_RUN_PURCHASELINE_ID,mrp_run_purchase_id,
            AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY,
            M_PRODUCT_ID, QTY,  PLANNEDDATE, PLANNEDORDERDATE, INOUTTRXTYPE,neededqty,
            C_ORDERLINE_ID, C_PROJECTTASK_ID, MRP_SALESFORECASTLINE_ID, M_REQUISITIONLINE_ID, ISCOMPLETED, C_BPARTNER_ID,m_warehouse_id)
          VALUES (
            p_Line_ID,p_runID,
            p_Client_ID, p_Org_ID, 'Y', TO_DATE(NOW()), p_User_ID, TO_DATE(NOW()), p_User_ID,
            p_Product_ID, p_Qty,  p_PlannedDate, v_plannedorderdate, p_InOutTrxType,0,
             p_OrderLine_ID, p_projecttask_ID, p_SalesForecastLine_ID, p_RequisitionLine_ID, 'N', p_vendor_Id,p_warehouse_id
          );
          --raise notice '%',p_runID||'AIIIIIIIIII'||p_Line_ID;
    end if;
  END; --BODY
EXCEPTION
WHEN OTHERS THEN
  RAISE NOTICE '%','MRP_RUN_INSERTLINES exception: ' || v_ResultStr ;
  RAISE EXCEPTION '%', SQLERRM;
--  RETURN;
END ; $_$;



CREATE OR REPLACE FUNCTION mrp_purchaseorder (
  p_pinstance_id varchar
)
RETURNS void AS
$body$
 DECLARE 
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
 Contributions: Price List in Purchasing are not useful - Removed.
                We take the price from m_product_po 
                Take the standard Quantity on ordering (not minimum)
                Do not substract acual stock qty
                Do order in ORDER Qty if it is in purchasing
*************************************************************************************************************************************************/ 
  v_ResultStr VARCHAR(2000):=''; --OBTG:VARCHAR2--
  v_Message VARCHAR:=' Orders: '; --OBTG:VARCHAR2--
  v_Result NUMERIC:= 1;
  v_Record_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_User_ID VARCHAR(32):='0'; --OBTG:VARCHAR2--
  v_Client_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Org_ID VARCHAR(32); --OBTG:VARCHAR2--


  v_COrder_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_COrderLine_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_DocumentNo VARCHAR(60); --OBTG:NVARCHAR2--
  v_created BOOLEAN := FALSE;
  FINISH_PROCESS BOOLEAN DEFAULT FALSE;

  v_M_Warehouse_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Description character varying; --OBTG:nvarchar2--
  v_DateDoc TIMESTAMP;
  v_PriceList NUMERIC;
  v_PriceActual NUMERIC;
  v_PriceLimit NUMERIC;
  LastCBPartner_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_Line NUMERIC;
  v_CDocTypeID VARCHAR(32); --OBTG:varchar2--
  v_BPartner_Location_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_BillTo_ID VARCHAR(32); --OBTG:VARCHAR2--
  v_PriceListVersion NUMERIC;
  v_PriceStd NUMERIC;
  v_TaxId VARCHAR(32); --OBTG:varchar2--
  v_ProductName VARCHAR(90); --OBTG:NVARCHAR2--

  v_Count NUMERIC;
  v_orderuom character varying;
  v_prodUOM  character varying;
  v_orderqty NUMERIC;
  v_stdqty  NUMERIC;
  v_qty  NUMERIC;
  v_prec  NUMERIC;
  v_vendorpnumber character varying;
--v_qtytype character varying;
  v_ismultipleofminimumqty CHAR;
  v_order_min NUMERIC;
  v_conversion NUMERIC;

  --  Parameter
  --TYPE RECORD IS REFCURSOR;
    Cur_Parameter RECORD;
    Cur_workproposal RECORD;
    v_novendordefined varchar;
  -- Call Offs
  v_isFramecontract varchar:='N';
  BEGIN
    RAISE NOTICE '%','Updating PInstance - Processing ' || p_PInstance_ID ;
    v_ResultStr:='PInstanceNotFound';
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
  BEGIN --BODY
    -- Get Parameters
    v_ResultStr:='ReadingParameters';
    FOR Cur_Parameter IN
      (SELECT i.Record_ID, i.AD_User_ID, i.AD_Client_ID, i.AD_Org_ID,
        p.ParameterName, p.P_String, p.P_Number, p.P_Date
      FROM AD_PInstance i
      LEFT JOIN AD_PInstance_Para p
        ON i.AD_PInstance_ID=p.AD_PInstance_ID
      WHERE i.AD_PInstance_ID=p_PInstance_ID
      ORDER BY p.SeqNo
      )
    LOOP
      v_Record_ID:=Cur_Parameter.Record_ID;
      v_User_ID:=Cur_Parameter.AD_User_ID;
      v_Client_ID := Cur_Parameter.AD_Client_ID;
      IF(Cur_Parameter.ParameterName='M_Warehouse_ID') THEN
        v_M_Warehouse_ID:=Cur_Parameter.P_String;
        RAISE NOTICE '%','  M_Warehouse_ID=' || v_M_Warehouse_ID;
      END IF;
    END LOOP; -- Get Parameter
    
    SELECT COALESCE(TO_CHAR(DESCRIPTION), ' '), DateDoc, AD_Org_ID
      INTO v_Description, v_DateDoc, v_Org_ID
     FROM MRP_RUN_PURCHASE
     WHERE MRP_RUN_PURCHASE_ID = v_Record_ID;
    -- You need to have vendor information in order to purchase
    select b.value||'-'||b.name into v_novendordefined from c_bpartner b,MRP_RUN_PURCHASELINE p 
    where  p.MRP_RUN_PURCHASE_ID = v_Record_ID and b.po_pricelist_id is null
           AND INOUTTRXTYPE = 'PP'
           AND p.C_OrderLine_ID IS NULL
           AND p.C_Bpartner_ID = b.C_BPartner_ID limit 1;
    if v_novendordefined is not null then
        raise exception '%','No Purchase Settings found for vendor: '||v_novendordefined;
    end if;
    FOR Cur_workproposal IN (
      SELECT rp.*, bp.PO_PRICELIST_ID, pl.C_Currency_ID,
             BP.PAYMENTRULEPO as paymentrule, BP.PO_PAYMENTTERM_ID AS C_PAYMENTTERM_ID,
             bp.DeliveryViaRule, p.C_UOM_ID
      FROM MRP_RUN_PURCHASELINE rp,
           C_BPartner bp,
           M_PriceList pl,
           M_Product p
      WHERE rp.MRP_RUN_PURCHASE_ID = v_Record_ID
        AND INOUTTRXTYPE = 'PP'
        AND rp.C_OrderLine_ID IS NULL
        AND rp.C_Bpartner_ID = bp.C_BPartner_ID
        AND pl.M_PriceList_ID = bp.PO_PRICELIST_ID
        AND p.M_Product_ID = rp.M_Product_ID
      ORDER BY rp.C_BPartner_ID, rp.PLANNEDDATE
      ) LOOP
      v_ResultStr:='Create Purchase Order';

      if (v_COrder_Id is null) or (Cur_workproposal.C_BPartner_ID!=LastCBPartner_ID) 
         or (v_isFramecontract='N' and Cur_workproposal.framecontractline is not null)
         or (v_isFramecontract='Y' and Cur_workproposal.framecontractline is null)
      then --new header
        v_Line := 0;
        SELECT * INTO  v_COrder_ID FROM Ad_Sequence_Next('C_Order', v_Client_ID);
        v_DocumentNo := NULL;
        -- Use Frame Contract Calloff, if applicable
        if Cur_workproposal.framecontractline is null then
            v_CDocTypeID := AD_Get_DocType(v_Client_ID, v_Org_ID,'POO',NULL);
            v_isFramecontract:='N';
        else
            v_CDocTypeID := '5EED1EFB8BDD4C0491ECCFD7395DA446';
            v_isFramecontract:='Y';
        end if;
        SELECT * INTO  v_DocumentNo FROM AD_Sequence_DocType(v_CDocTypeID, v_Org_ID, 'Y') ;
        IF(v_DocumentNo IS NULL) THEN
          SELECT * INTO  v_DocumentNo FROM AD_Sequence_Doc('DocumentNo_C_Order', v_Org_ID, 'Y') ;
        END IF;


        SELECT MIN(C_BPARTNER_LOCATION_ID)
        INTO v_BPartner_Location_ID
        FROM C_BPARTNER_LOCATION
        WHERE ISACTIVE='Y'
          AND ISSHIPTO='Y'
          AND C_BPARTNER_ID=Cur_workproposal.C_BPARTNER_ID;

        SELECT MIN(C_BPARTNER_LOCATION_ID)
        INTO v_BillTo_ID
        FROM C_BPARTNER_LOCATION
        WHERE ISACTIVE='Y'
          AND ISBILLTO='Y'
          AND C_BPARTNER_ID=Cur_workproposal.C_BPARTNER_ID;

        INSERT INTO C_Order
          (C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE,
           CREATED, CREATEDBY, UPDATED, UPDATEDBY,
           ISSOTRX, DOCUMENTNO, DOCSTATUS, DOCACTION, PROCESSING,
           C_DOCTYPE_ID,C_DOCTYPETARGET_ID, DESCRIPTION,
           DATEORDERED, DATEACCT, C_BPARTNER_ID, BILLTO_ID,
           C_BPARTNER_LOCATION_ID, C_CURRENCY_ID, PAYMENTRULE, C_PAYMENTTERM_ID,
           INVOICERULE, DELIVERYRULE, FREIGHTCOSTRULE, DELIVERYVIARULE,
           PRIORITYRULE, TOTALLINES, GRANDTOTAL,
           M_WAREHOUSE_ID, M_PRICELIST_ID, ISTAXINCLUDED, DATEPROMISED,scheddeliverydate)
        VALUES
         (v_COrder_ID, v_Client_ID, v_Org_ID,'Y',
         TO_DATE(NOW()), v_User_ID, TO_DATE(NOW()), v_User_ID,
         'N', v_DocumentNo,  'DR', 'CO','N',
          v_CDocTypeID, v_CDocTypeID, v_Description,
          v_DateDoc,v_DateDoc, Cur_workproposal.C_BPartner_ID,v_BillTo_ID,
          v_BPartner_Location_ID, Cur_workproposal.C_Currency_ID, Cur_workproposal.paymentrule, Cur_workproposal.C_PAYMENTTERM_ID,
          'D', 'A', 'I',COALESCE(Cur_workproposal.DeliveryViaRule,'D'),
          '5',0,0,
          coalesce(Cur_workproposal.m_warehouse_id,v_M_Warehouse_ID), Cur_workproposal.PO_PRICELIST_ID, 'N', v_DateDoc,Cur_workproposal.PLANNEDDATE
          );
          -- SZ Sucess Message:
          v_Message:=v_Message||'  '||zsse_htmlLinkDirectKey('../PurchaseOrder/Header_Relation.html',v_COrder_ID,v_DocumentNo);
      end if; --header
      LastCBPartner_ID := Cur_workproposal.C_BPartner_ID;

      v_Line := v_Line + 10;
      SELECT * INTO  v_COrderLine_ID FROM Ad_Sequence_Next('C_OrderLine', v_Client_ID);
      -- SZ: In Purchasing take the Price from m_product_po
      -- SZ: Take the standard Quantity on ordering (not minimum)
      --          Do not substract acual stock qty
      --          Do order in ORDER Qty if it is in purchasing
      v_ResultStr:='Get order line data';
      SELECT count(*) INTO v_Count
      FROM m_product_po
       WHERE M_Product_ID = Cur_workproposal.M_Product_ID and c_bpartner_id=Cur_workproposal.C_BPartner_ID
        AND IsActive= 'Y';
      IF (v_count > 0) THEN
        SELECT PriceList, Pricepo as PriceStd,
               M_Get_Offers_Price(v_DateDoc,Cur_workproposal.C_BPartner_ID,Cur_workproposal.M_Product_ID,null,Cur_workproposal.QTY, Cur_workproposal.PO_PRICELIST_ID),
               Pricepo as PriceLimit,
               qtystd,c_uom_id,vendorproductno, ismultipleofminimumqty, order_min -- qtytype
          INTO v_PriceList, v_PriceStd, v_PriceActual, v_PriceLimit,v_stdqty,v_orderuom ,v_vendorpnumber, v_ismultipleofminimumqty, v_order_min -- v_qtytype
        FROM M_Product_PO
        WHERE M_Product_ID = Cur_workproposal.M_Product_ID
              and c_bpartner_id=Cur_workproposal.C_BPartner_ID
              AND IsActive= 'Y' order by iscurrentvendor desc limit 1;
        -- SZ end
      ELSE
        SELECT NAME INTO v_ProductName
        FROM M_PRODUCT
        WHERE M_PRODUCT_ID = Cur_workproposal.M_Product_ID;
        v_Result := 0;
        v_Message := '@PriceNotFound@ ' || v_ProductName;
        RAISE EXCEPTION '%', v_Message; --OBTG:-20000--
      END IF;
      -- SZ: Get the Tax from Product
      v_TaxID :=zsfi_GetTax(v_BPartner_Location_ID,Cur_workproposal.M_Product_ID,v_Org_ID) ;
      v_qty:=  Cur_workproposal.neededqty;
      select c_uom_id into  v_prodUOM from m_product where m_product_id=Cur_workproposal.M_Product_ID;
      -- SZ Do order in ORDER Qty if it is in purchasing
      -- 2ndary UOM must be supplied if applicable
      v_orderqty := null;
      if coalesce(v_orderuom,v_prodUOM)!=v_prodUOM then
         SELECT MULTIPLYRATE into v_conversion FROM C_UOM_CONVERSION WHERE C_UOM_ID = Cur_workproposal.C_UOM_ID AND C_UOM_TO_ID = v_orderuom;
         if v_conversion is null then 
            SELECT dividerate into v_conversion FROM C_UOM_CONVERSION WHERE C_UOM_ID = v_orderuom AND C_UOM_TO_ID = Cur_workproposal.C_UOM_ID; 
         end if;
         if coalesce(v_conversion,0)!=0 then
            v_orderqty := v_qty*v_conversion;
            v_orderqty := GREATEST(v_orderqty,v_stdqty);
          --IF (v_qtytype = 'M' and coalesce(v_order_min,0)!=0) THEN --Multiple lot qty
            IF (v_ismultipleofminimumqty = 'Y' and coalesce(v_order_min,0)!=0) THEN --Multiple lot qty
              v_orderqty := CEIL(v_orderqty/v_order_min)*v_order_min;
            END IF;
            select stdprecision into v_prec from c_uom where c_uom_id=v_orderuom;
            v_orderqty:=round(v_orderqty,v_prec);
            v_qty:=v_orderqty/v_conversion;
            select stdprecision into v_prec from c_uom where c_uom_id=v_prodUOM;
            v_qty:=round(v_qty,v_prec);
            select m_product_uom_id into v_orderuom from m_product_uom where m_product_id=Cur_workproposal.m_product_id and C_UOM_ID=v_orderuom;
         else
            v_orderqty := null;
         end if;
       end if;
      -- SZ build Description:
      select zssi_getText('zssi_vendorproductno',coalesce(default_ad_language,'de_DE'))||vendorproductno||E'\r\n'||documentnote into v_Description from m_product,ad_user where ad_user_id=v_User_ID and m_product_id=Cur_workproposal.M_Product_ID;
      v_ResultStr:='Insert order line';

      INSERT INTO C_OrderLine
        (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE,
         CREATED, CREATEDBY, UPDATED, UPDATEDBY,
         C_ORDER_ID, LINE, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID,
         DATEORDERED, DATEPROMISED, DESCRIPTION, M_PRODUCT_ID,
         M_WAREHOUSE_ID, C_UOM_ID, QTYORDERED, C_CURRENCY_ID,
         PRICELIST, PRICEACTUAL, PRICELIMIT,
         PRICESTD,scheddeliverydate,
         C_TAX_ID,quantityorder,m_product_uom_id,orderlineselfjoin)
     VALUES
      (v_COrderLine_ID,v_Client_ID, v_Org_ID,'Y',
       TO_DATE(NOW()), v_User_ID, TO_DATE(NOW()), v_User_ID,
       v_COrder_ID, v_Line, Cur_workproposal.C_BPartner_ID, v_BPartner_Location_ID,
       v_DateDoc, Cur_workproposal.PLANNEDDATE, v_Description, Cur_workproposal.M_Product_ID,
       coalesce(Cur_workproposal.m_warehouse_id,v_M_Warehouse_ID), Cur_workproposal.C_UOM_ID, v_qty, Cur_workproposal.C_Currency_ID,
       v_PriceList, v_PriceActual, v_PriceLimit,
       v_PriceStd, Cur_workproposal.PLANNEDDATE,
       v_TaxID,v_orderqty,case when v_orderqty is not null then v_orderuom else null end,
       Cur_workproposal.framecontractline
      );

      UPDATE MRP_RUN_PURCHASELINE
        SET C_OrderLine_ID = v_COrderLine_ID
      WHERE MRP_RUN_PURCHASELINE_ID = Cur_workproposal.MRP_RUN_PURCHASELINE_ID;
    END LOOP;
  v_ResultStr :='Set requisition lines as planned';
  UPDATE M_RequisitionLine
  SET REQSTATUS = 'P'
  WHERE M_RequisitionLine_ID IN (SELECT M_RequisitionLine_ID
                                 FROM MRP_RUN_PURCHASELINE
                                 WHERE MRP_RUN_PURCHASE_ID = v_Record_ID
                                   AND INOUTTRXTYPE = 'MF');

  UPDATE M_Requisition
  SET DocStatus = 'CL'
  WHERE M_Requisition_ID IN (SELECT M_Requisition_ID
                            FROM M_RequisitionLine
                            WHERE M_RequisitionLine_ID IN (SELECT M_RequisitionLine_ID
                                                          FROM MRP_RUN_PURCHASELINE
                                                          WHERE MRP_RUN_PURCHASE_ID = v_Record_ID
                                                            AND INOUTTRXTYPE = 'MF'))
    AND NOT EXISTS (SELECT 1
                    FROM M_RequisitionLine rl
                    WHERE rl.REQSTATUS = 'O'
                      AND rl.M_Requisition_ID = M_Requisition.M_Requisition_ID);
  END;--BODY
  IF(p_PInstance_ID IS NOT NULL) THEN
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', v_Result, substr(v_Message,1,2000)) ;
  END IF;
EXCEPTION
WHEN OTHERS THEN
  RAISE NOTICE '%','MRP_PURCHASEORDER exception: ' || v_ResultStr ;
  v_ResultStr:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_ResultStr ;
  -- ROLLBACK;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_ResultStr) ;
--  RETURN;
END ;
$body$
LANGUAGE 'plpgsql'
COST 100;

CREATE OR REPLACE FUNCTION mrp_getpo_qty (
  p_product_id    VARCHAR,
  p_bpartner_id   VARCHAR,
  p_qty           NUMERIC
)
RETURNS NUMERIC AS
$body$
DECLARE
  v_mpo_m_product_po_id CHARACTER VARYING;
  v_mpo_qtystd NUMERIC;
  v_mpo_order_min NUMERIC;
  v_mpo_ismultipleofminimumqty CHAR := 'N';
  v_mrp_qty NUMERIC := 0;
  v_result NUMERIC := COALESCE(p_qty,0); -- Eingangswert wird Rueckgabewert, wenn keine Daten im Einkauf hinterlegt, 0=Menge lt. Einkauf ermitteln
BEGIN
 -- bei negativen Bestellmengen bzw. Bestellmengen=0 werden Standard- bzw. Mindest-Bestellmengen nicht bruecksichtigt
  IF ( COALESCE(p_qty, 0) >= 0 ) THEN -- kein negativen Bestellmengen (bei neg. BestellMenge beachte: a) CEIL(-2.0 / 20.0)= 0; b) -2.0/20.0= -0,1, CEIL(2.0 / 20.0)=1
    SELECT mpo.m_product_po_id, COALESCE(mpo.qtystd, 0), COALESCE(mpo.order_min, 0), COALESCE(mpo.ismultipleofminimumqty, 'N')
    INTO v_mpo_m_product_po_id, v_mpo_qtystd, v_mpo_order_min, v_mpo_ismultipleofminimumqty
    FROM m_product_po mpo WHERE mpo.m_product_id = p_product_id AND mpo.c_bpartner_id = p_bpartner_id;

    IF (v_mpo_m_product_po_id IS NOT NULL) THEN -- Einkauf (m_product_po) gefunden
      v_result := GREATEST( COALESCE(v_mpo_order_min,0), COALESCE(v_mpo_qtystd,0) ); --  'Standard Bestellmenge' bzw. 'Mindest-Bestellmenge' uebernehmen
      RAISE NOTICE 'order_min:% qtystd:% v_mpo_ismultipleofminimumqty:% v_result:%', v_mpo_order_min, v_mpo_qtystd, v_mpo_ismultipleofminimumqty, v_result;
      v_result := GREATEST(p_qty, v_result); -- 'tats. Bestellmenge' bzw. Mindestbestellmenge
      IF ( (v_mpo_ismultipleofminimumqty = 'Y') AND (v_mpo_order_min > 0) ) THEN  -- Vielfaches der Mindestbestellmenge angegeben
        v_result := CEIL(v_result / v_mpo_order_min) * v_mpo_order_min; -- FieldType=NUMERIC, p_qty=nicht negativ
        RAISE NOTICE 'Bestellung aufgrund Standardbestellmengen benötigt: % -> % x % => % ', p_qty, to_char(CEIL(p_qty / v_mpo_order_min)), v_mpo_order_min, trim(to_char(v_result));
      END IF;
    END IF;

  END IF;
  RETURN v_result;
END;
$body$
LANGUAGE 'plpgsql'
COST 100;


CREATE OR REPLACE FUNCTION mrp_getpo_qtystd (
  p_product_id    VARCHAR,
  p_bpartner_id   VARCHAR
)
RETURNS NUMERIC AS
$body$
DECLARE
  v_mpo_m_product_po_id CHARACTER VARYING;
  v_mpo_qtystd NUMERIC;
  v_result NUMERIC := 0;
BEGIN
  SELECT mpo.m_product_po_id, mpo.qtystd
  INTO v_mpo_m_product_po_id, v_mpo_qtystd
  FROM m_product_po mpo WHERE mpo.m_product_id = p_product_id AND mpo.c_bpartner_id = p_bpartner_id;

  IF (v_mpo_m_product_po_id IS NOT NULL) THEN
    v_result := COALESCE(v_mpo_qtystd, 0); -- default=0, order_min could be available
    RAISE NOTICE 'v_mpo_qtystd:% v_result:%', v_mpo_qtystd, v_result;
  END IF;
  RETURN v_result;
END;
$body$
LANGUAGE 'plpgsql'
COST 100;


CREATE OR REPLACE FUNCTION mrp_getpo_qtymin (
  p_product_id    VARCHAR,
  p_bpartner_id   VARCHAR
)
RETURNS NUMERIC AS
-- SELECT mrp_getpo_qtymin('A8E55EE655304D2A827785E1275ECCAD', '72286E776B2C4383AD11E886EE6C3BB0') AS mrp_getpo_qtymin;
$body$
DECLARE
  v_mpo_m_product_po_id CHARACTER VARYING;
  v_order_min NUMERIC;
  v_result NUMERIC := 0;
BEGIN
  SELECT mpo.m_product_po_id, mpo.order_min
  INTO v_mpo_m_product_po_id, v_order_min
  FROM m_product_po mpo WHERE mpo.m_product_id = p_product_id AND mpo.c_bpartner_id = p_bpartner_id;

  IF (v_mpo_m_product_po_id IS NOT NULL) THEN
    v_result := COALESCE(v_order_min, 0); -- default=0, QtyStd could be available
  END IF;
  RETURN v_result;
END;
$body$
LANGUAGE 'plpgsql'
COST 100;

CREATE OR REPLACE FUNCTION mrp_getpo_ismultipleofminimumqty (
  p_product_id    VARCHAR,
  p_bpartner_id   VARCHAR
)
RETURNS CHAR AS
$body$
DECLARE
  v_mpo_m_product_po_id CHARACTER VARYING;
  v_ismultipleofminimumqty CHAR;
  v_result CHAR := 'N';
BEGIN
  SELECT mpo.m_product_po_id, mpo.ismultipleofminimumqty
  INTO v_mpo_m_product_po_id, v_ismultipleofminimumqty
  FROM m_product_po mpo WHERE mpo.m_product_id = p_product_id AND mpo.c_bpartner_id = p_bpartner_id;

  IF (v_mpo_m_product_po_id IS NOT NULL) THEN
    v_result := COALESCE(v_ismultipleofminimumqty, 'N');
  END IF;
  RETURN v_result;
END;
$body$
LANGUAGE 'plpgsql'
COST 100;


CREATE OR REPLACE FUNCTION mrp_getpo_qualrtg (
  p_product_id    VARCHAR,
  p_bpartner_id   VARCHAR
)
RETURNS NUMERIC AS
-- SELECT mrp_getpo_qualrtg('A8E55EE655304D2A827785E1275ECCAD', '72286E776B2C4383AD11E886EE6C3BB0') AS mrp_getpo_qualrtg;
$body$
DECLARE
  v_mpo_m_product_po_id CHARACTER VARYING;
  v_qualityrating NUMERIC;
  v_result NUMERIC := 0;
BEGIN
  SELECT mpo.m_product_po_id, mpo.qualityrating
  INTO v_mpo_m_product_po_id, v_qualityrating
  FROM m_product_po mpo WHERE mpo.m_product_id = p_product_id AND mpo.c_bpartner_id = p_bpartner_id;

  IF (v_mpo_m_product_po_id IS NOT NULL) THEN
    v_result := COALESCE(v_qualityrating, 0);
  END IF;
  RETURN v_result;
END;
$body$
LANGUAGE 'plpgsql'
COST 100;

CREATE OR REPLACE FUNCTION mrp_getpo_ismultipleofminimumqty (
  p_product_id    VARCHAR,
  p_bpartner_id   VARCHAR
)
RETURNS CHAR AS
-- SELECT mrp_getpo_ismultipleofminimumqty('A8E55EE655304D2A827785E1275ECCAD', '72286E776B2C4383AD11E886EE6C3BB0') AS mrp_getpo_ismultipleofminimumqty;
$body$
DECLARE
  v_mpo_m_product_po_id CHARACTER VARYING;
  v_ismultipleofminimumqty CHAR;
  v_result CHAR := 'N';
BEGIN
  SELECT mpo.m_product_po_id, mpo.ismultipleofminimumqty
  INTO v_mpo_m_product_po_id, v_ismultipleofminimumqty
  FROM m_product_po mpo WHERE mpo.m_product_id = p_product_id AND mpo.c_bpartner_id = p_bpartner_id;

  IF (v_mpo_m_product_po_id IS NOT NULL) THEN
    v_result := COALESCE(v_ismultipleofminimumqty, 'N');
  END IF;
  RETURN v_result;
END;
$body$
LANGUAGE 'plpgsql'
COST 100;


CREATE or replace FUNCTION mrp_estimated_stockqty(p_productid character varying,p_warehouse_id character varying, p_date date) RETURNS numeric
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

*****************************************************/
DECLARE
-- Simple Types
v_purchase  numeric:=0;
v_sales  numeric:=0;
v_consumption numeric;
v_production numeric;
v_currstock numeric;
BEGIN
  -- Planned Purchase
  select sum(ol.qtyordered-ol.qtydelivered)  into v_purchase
         from c_order o,c_orderline ol,m_product m  
         where o.c_order_id=ol.c_order_id  and ol.m_product_id=p_productid and  ol.m_product_id=m.m_product_id and  o.m_warehouse_id=p_warehouse_id
         and  ad_get_docbasetype(o.c_doctype_id)  = 'POO'  
         and  ol.deliverycomplete='N' and m.producttype='I'  and m.isstocked='Y' 
         and  o.docstatus='CO' and trunc(coalesce(ol.scheddeliverydate,now()))<=p_date
         and (ol.qtyordered-ol.qtydelivered) > 0;
  -- Planned Sales
  select sum(ol.qtyordered-ol.qtydelivered)  into v_sales
         from c_order o,c_orderline ol,m_product m  
         where o.c_order_id=ol.c_order_id  and ol.m_product_id=p_productid and  ol.m_product_id=m.m_product_id and o.m_warehouse_id=p_warehouse_id 
         and ad_get_docbasetype(o.c_doctype_id)  = 'SOO' 
         and ol.deliverycomplete='N' and m.producttype='I' and m.isstocked='Y'  
         and o.docstatus='CO' and trunc(coalesce(ol.scheddeliverydate,now()))<=p_date
         and (ol.qtyordered-ol.qtydelivered) > 0;

  -- Current Onhand QTY's
  select sum(s.qtyonhand) into v_currstock 
         from m_storage_detail s 
         where s.m_locator_id in (select m_locator_id from m_locator where m_warehouse_id =p_warehouse_id) 
         and s.m_product_id=  p_productid;
  -- Planned Production
  -- Production-Projects or Production Orders, Must be started, Task not cancelled and not complete, Order have assembly, Production Project has different locator 
  select  sum(qty-qtyproduced)  into v_production  
          from c_projecttask p,c_project pr ,m_product m
          where p.c_project_id=pr.c_project_id and p.m_product_id=p_productid and p.m_product_id=m.m_product_id
          and m.producttype='I' and m.isstocked='Y'
          and pr.projectcategory in ('P','PRO') 
          and pr.projectstatus='OR' 
          and p.iscomplete='N' and p.istaskcancelled='N'
          and (p.qty-p.qtyproduced)>0 
          and case when pr.projectcategory='PRO' then p.assembly='Y' else 1=1 end 
          and trunc(coalesce(p.enddate,now()))<=p_date  
          and case when pr.projectcategory='PRO' then p.issuing_locator else m.m_locator_id end in (select m_locator_id from m_locator where m_warehouse_id =p_warehouse_id); 
  -- Planned Cosumption
  -- Production-Projects or Production Orders or Service Projects. All Must be started, Task not cancelled and not complete, Order have assembly, Production Project has different locator 
  select  sum(bom.quantity-bom.qtyreceived)  into v_consumption  
          from zspm_projecttaskbom bom, c_projecttask p,c_project pr ,m_product m
          where p.c_project_id=pr.c_project_id and p.c_projecttask_id=bom.c_projecttask_id and bom.m_product_id=  p_productid and bom.m_product_id=m.m_product_id
          and m.producttype='I' and m.isstocked='Y'
          and pr.projectcategory in ('PRO','P','S','M')
          and pr.projectstatus='OR' 
          and p.iscomplete='N' and p.istaskcancelled='N' 
          and (bom.quantity-bom.qtyreceived)>0
          and case when pr.projectcategory='PRO' then p.assembly='Y' else 1=1 end 
          and trunc(coalesce(p.startdate,now()))<=p_date 
          and case when pr.projectcategory='PRO' then bom.receiving_locator else bom.m_locator_id end in (select m_locator_id from m_locator where m_warehouse_id =p_warehouse_id);
  return coalesce(v_currstock,0)+coalesce(v_purchase,0)-coalesce(v_sales,0)-coalesce(v_consumption,0)+coalesce(v_production,0);
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;


select zsse_DropView ('mrp_inoutplanbase_v');
create or replace view mrp_inoutplanbase_v as
-- Purchase and Sales
select trunc(coalesce(ol.scheddeliverydate,LOCALTIMESTAMP)) as  stockdate,
       ol.c_orderline_id as mrp_inoutplanbase_id,
       ol.m_product_id,o.m_warehouse_id,ol.c_orderline_id,ol.c_projecttask_id,o.ad_org_id,o.ad_client_id,ol.updated, ol.updatedby, ol.created, ol.createdby,
       ad_get_docbasetype(o.c_doctype_id) as documenttype,
       case ad_get_docbasetype(o.c_doctype_id) when 'POO' then ol.qtyordered-ol.qtydelivered else (ol.qtyordered-ol.qtydelivered)*-1 end as movementqty,o.c_bpartner_id
       from c_order o,c_orderline ol,m_product p  
       where o.c_order_id=ol.c_order_id and ol.m_product_id=p.m_product_id  
       and ol.deliverycomplete='N' and p.isstocked='Y' and p.producttype='I' 
       and ad_get_docbasetype(o.c_doctype_id)  in ('SOO','POO') and o.docstatus='CO'
       and o.m_warehouse_id in (select m_warehouse_id from m_warehouse where isactive='Y' and isblocked='N')
       and (ol.qtyordered-ol.qtydelivered) > 0 
union all 
-- Production
select trunc(coalesce(p.enddate,LOCALTIMESTAMP)) as stockdate,
       p.c_projecttask_id as mrp_inoutplanbase_id,
       p.m_product_id,w.m_warehouse_id, null as c_orderline_id, p.c_projecttask_id,p.ad_org_id,p.ad_client_id,p.updated, p.updatedby, p.created, p.createdby,
       'PROD' as documenttype,
       p.qty-p.qtyproduced as movementqty,null as c_bpartner_id
       from c_projecttask p, m_locator w,c_project pr ,m_product m 
        where case when pr.projectcategory='PRO' then p.issuing_locator else (select m_locator_id from m_product where m_product_id=p.m_product_id)  end = w.m_locator_id 
        and p.c_project_id=pr.c_project_id and p.m_product_id=m.m_product_id
        and m.producttype='I' and m.isstocked='Y'
        and pr.projectcategory in ('P','PRO') 
        and pr.projectstatus='OR' 
        and p.iscomplete='N' and p.istaskcancelled='N' 
        and (p.qty-p.qtyproduced)>0 
        and case when pr.projectcategory='PRO' then p.assembly='Y' else 1=1 end
        and w.m_warehouse_id in (select m_warehouse_id from m_warehouse where isactive='Y' and isblocked='N')
union all 
-- Consumption
select trunc(coalesce(p.startdate,LOCALTIMESTAMP)) as stockdate,
       bom.zspm_projecttaskbom_id as mrp_inoutplanbase_id,
       bom.m_product_id,w.m_warehouse_id,
       null as c_orderline_id, p.c_projecttask_id,p.ad_org_id,p.ad_client_id,p.updated, p.updatedby, p.created, p.createdby,'PCONS' as documenttype,
       (bom.quantity-bom.qtyreceived)*-1 as movementqty,null as c_bpartner_id
       from c_projecttask p, m_locator w,zspm_projecttaskbom bom,c_project pr ,m_product m   
        where p.c_project_id=pr.c_project_id 
        and case when pr.projectcategory='PRO' then bom.receiving_locator else bom.m_locator_id end = w.m_locator_id
        and bom.m_product_id=m.m_product_id 
        and bom.c_projecttask_id=p.c_projecttask_id 
        and m.producttype='I' and m.isstocked='Y'
        and pr.projectcategory in ('PRO','P','S','M')
        and pr.projectstatus='OR' 
        and p.iscomplete='N' and p.istaskcancelled='N' 
        and (bom.quantity-bom.qtyreceived)>0
        and case when pr.projectcategory='PRO' then p.assembly='Y' else 1=1 end 
        and w.m_warehouse_id in (select m_warehouse_id from m_warehouse where isactive='Y' and isblocked='N')
;

select zsse_droptable('mrp_inoutplanbase');

create table mrp_inoutplanbase as select 0:: numeric as estimated_stock_qty,* from mrp_inoutplanbase_v;
create index ixolbix on mrp_inoutplanbase(m_product_id,m_warehouse_id,stockdate);

-- Not Avoidable cross-script dependency to productionrun.sql.
-- mrp_inoutplan_v_id deletes zssm_productionrequired_v
-- After Running MRP.sql productionrun.sql Script has to be run!
select zsse_DropView ('mrp_inoutplan_v');
create or replace view mrp_inoutplan_v as
select 
        b.mrp_inoutplanbase_id as mrp_inoutplan_v_id,
        b.ad_org_id,
        b.ad_client_id,
        b.c_bpartner_id,
        b.updated,
        b.updatedby,
        b.created,
        b.createdby,
        'Y'::text as isactive,
        b.estimated_stock_qty, 
        b.documenttype,
        b.c_orderline_id,
        b.c_projecttask_id,
        b.movementqty,
        b.stockdate as planneddate,
        b.m_warehouse_id,
        b.m_product_id,
        b.m_product_id||coalesce(b.m_warehouse_id,'') AS zssi_onhanqty_overview_id,
        p.m_product_category_id,
        p.c_uom_id,
        p.production
from 
        mrp_inoutplanbase b, 
        m_product p 
where
        p.m_product_id=b.m_product_id;
        
select zsse_DropView ('mrp_criticalitems_v');
create or replace view mrp_criticalitems_v as
select 
        *,mrp_inoutplan_v_id as mrp_criticalitems_v_id
from 
        mrp_inoutplan_v
where
       estimated_stock_qty<0;


  
select zsse_dropfunction('mrp_inoutplanupdate');
CREATE or replace FUNCTION mrp_inoutplanupdate(p_isexplicit character varying)  RETURNS void 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

*****************************************************/
DECLARE
-- Simple Types
v_message character varying:='Success';
v_Record_ID  character varying;
v_User    character varying;
i numeric;
v_cur RECORD;
v_qty numeric;
v_current varchar:='';
BEGIN
      if (select count(*) from ad_pinstance where ad_process_id='6F619A3BFA2B43AD95ED96F2D6875E8A' and isprocessing='Y')>0 
         and coalesce(p_isexplicit,'N')='N' 
      then
        return;
      end if;
      --  Update AD_PInstance
      --PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
      delete from mrp_inoutplanbase;
      insert into mrp_inoutplanbase select 0 as estimated_stock_qty,* from mrp_inoutplanbase_v;
      GET DIAGNOSTICS i := ROW_COUNT; 
      v_message:=  i || ' Warenbewegungen geplant.';
      for v_cur in (select sum(b.movementqty) as qty, b.m_product_id,b.m_warehouse_id,b.stockdate from mrp_inoutplanbase b group by b.m_product_id,b.m_warehouse_id,b.stockdate
                           order by b.m_product_id,b.m_warehouse_id,b.stockdate)
      LOOP
         if v_current!=to_char(v_cur.m_product_id||v_cur.m_warehouse_id) then
            -- Current Onhand QTY's
            select sum(s.qtyonhand) into v_qty
            from m_storage_detail s 
            where s.m_locator_id in (select m_locator_id from m_locator where m_warehouse_id =v_cur.m_warehouse_id) 
            and s.m_product_id=  v_cur.m_product_id;
            if v_qty is null then
                v_qty:=0;
            end if;
            v_current:=v_cur.m_product_id||v_cur.m_warehouse_id;
         end if;
         v_qty:=v_qty+v_cur.qty;
        --v_qty:= mrp_estimated_stockqty(v_cur.m_product_id,v_cur.m_warehouse_id,v_cur.stockdate);
        update mrp_inoutplanbase b set estimated_stock_qty = v_qty where m_product_id=v_cur.m_product_id and m_warehouse_id=v_cur.m_warehouse_id and stockdate=v_cur.stockdate;
      END LOOP;
      --PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_message);
      return;
/*
EXCEPTION
    WHEN OTHERS then
       v_message:= '@ERROR=' || SQLERRM;   
       PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message);
       return;
*/
END ; $_$ LANGUAGE 'plpgsql';

select mrp_inoutplanupdate(null);

CREATE or replace FUNCTION mrp_updateplanline(p_projecttask_id varchar,p_orderline_id varchar)  RETURNS void 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

*****************************************************/
DECLARE
  
BEGIN
      if  p_projecttask_id is not null then
           delete from mrp_inoutplanbase where c_projecttask_id=p_projecttask_id;
           insert into mrp_inoutplanbase select get_uuid()  as mrp_inoutplanbase_id,* from mrp_inoutplanbase_v where c_projecttask_id=p_projecttask_id;
      end if;
      if  p_orderline_id is not null then
           delete from mrp_inoutplanbase where c_orderline_id=p_orderline_id;
           insert into mrp_inoutplanbase select get_uuid()  as mrp_inoutplanbase_id,* from mrp_inoutplanbase_v where c_orderline_id=p_orderline_id;
      end if;
END ; $_$ LANGUAGE 'plpgsql';
  
CREATE OR REPLACE FUNCTION mrp_order_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/
  v_cur record;
BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'UPDATE' THEN 
      -- fire MRP-Trigger only on change of Document status.
      -- fire on Orders 
      -- Do not Fire on Subscription Intervals BUT
      -- Fire on Subscription Orders
      if old.docstatus!=new.docstatus and ((ad_get_docbasetype(new.c_DocType_ID) in ('POO','SOO') 
         and new.c_DocType_ID!='6C8EA6FFBB2B4ACBA0542BA4F833C499') or new.c_DocType_ID='ABE2033C7A74499A9750346A83DE3307') then
        /*
        for v_cur in (select c_orderline_id from c_orderline where c_order_id=new.c_order_id)
        LOOP
            PERFORM  mrp_updateplanline(null,v_cur.c_orderline_id);
        END LOOP;
        */
        
        PERFORM mrp_inoutplanupdate(null);
      end if;
   END IF;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
select zsse_droptrigger('mrp_order_trg','c_order');

CREATE TRIGGER mrp_order_trg
  AFTER UPDATE
  ON c_order
  FOR EACH ROW
  EXECUTE PROCEDURE mrp_order_trg();

CREATE OR REPLACE FUNCTION mrp_orderline_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/
  v_cur record;
BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'UPDATE' THEN 
      -- fire MRP-Trigger only on change of scheduled delivery date.
      if coalesce(old.scheddeliverydate,new.created)!=coalesce(new.scheddeliverydate,new.created) and 
         (select docstatus from c_order where c_order_id=new.c_order_id)='CO' then
            --PERFORM  mrp_updateplanline(null,new.c_orderline_id);
            PERFORM mrp_inoutplanupdate(null);
      end if;
   END IF;
   /*
   IF TG_OP = 'DELETE' then 
         --PERFORM  mrp_updateplanline(null,old.c_orderline_id);
         PERFORM mrp_inoutplanupdate(null);
   END IF;
   */
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
select zsse_droptrigger('mrp_orderline_trg','c_orderline');

CREATE TRIGGER mrp_orderline_trg
  AFTER UPDATE OR DELETE
  ON c_orderline
  FOR EACH ROW
  EXECUTE PROCEDURE mrp_orderline_trg();


CREATE OR REPLACE FUNCTION mrp_projecttask_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/

BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'DELETE' THEN 
       PERFORM mrp_inoutplanupdate(null);
      --PERFORM  mrp_updateplanline(old.c_projecttask_id,null);
   ELSE
       if TG_OP = 'UPDATE' THEN 
           if coalesce(new.startdate,now())!= coalesce(old.startdate,now()) or coalesce(new.enddate,now())!= coalesce(old.enddate,now()) or coalesce(new.m_product_id,'')!= coalesce(old.m_product_id,'') or coalesce(old.qty,0)!= coalesce(new.qty,0) or old.qtyproduced!=new.qtyproduced 
           or old.istaskcancelled!=new.istaskcancelled or new.iscomplete !=old.iscomplete then
            PERFORM mrp_inoutplanupdate(null);
           end if;
       else
           PERFORM mrp_inoutplanupdate(null);
       end if;
      --PERFORM  mrp_updateplanline(new.c_projecttask_id,null);
   END IF;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
select zsse_droptrigger('mrp_projecttaskUPD_trg','c_projecttask');
CREATE TRIGGER mrp_projecttaskUPD_trg
  AFTER UPDATE 
  ON c_projecttask
  FOR EACH ROW
  EXECUTE PROCEDURE mrp_projecttask_trg();
  
select zsse_droptrigger('mrp_projecttask_trg','c_projecttask');
CREATE TRIGGER mrp_projecttask_trg
  AFTER INSERT OR DELETE
  ON c_projecttask
  FOR EACH STATEMENT
  EXECUTE PROCEDURE mrp_projecttask_trg();

  
CREATE OR REPLACE FUNCTION mrp_projecttaskbom_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/

BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'DELETE' THEN 
       PERFORM mrp_inoutplanupdate(null);
      --PERFORM  mrp_updateplanline(old.c_projecttask_id,null);
   ELSE
       if TG_OP = 'UPDATE' THEN 
           if new.m_product_id!= old.m_product_id or old.quantity!= new.quantity  then
            PERFORM mrp_inoutplanupdate(null);
           end if;
       else
           PERFORM mrp_inoutplanupdate(null);
       end if;
      --PERFORM  mrp_updateplanline(new.c_projecttask_id,null);
   END IF;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
    
select zsse_droptrigger('mrp_projecttask_trg','zspm_projecttaskbom');

CREATE TRIGGER mrp_projecttask_trg
  AFTER INSERT  OR DELETE
  ON zspm_projecttaskbom
  FOR EACH STATEMENT
  EXECUTE PROCEDURE mrp_projecttaskbom_trg();  
  
select zsse_droptrigger('mrp_projecttaskUPD_trg','zspm_projecttaskbom');

CREATE TRIGGER mrp_projecttaskUPD_trg
  AFTER  UPDATE 
  ON zspm_projecttaskbom
  FOR EACH ROW
  EXECUTE PROCEDURE mrp_projecttaskbom_trg();  
  
  
  
  
select zsse_dropfunction('mrp_getsheddeliverydate4vendorProduct');  
CREATE or replace FUNCTION mrp_getsheddeliverydate4vendorProduct(p_vendor_id varchar,p_product_id varchar,p_org_id varchar)  RETURNS varchar
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

In Purchase all workdays are calculated with 8 workhours.

One day is added by default to mean lead time

*****************************************************/
DECLARE
  v_hours numeric:=0;
  v_workhours numeric;
  v_cur record;
  v_vendor varchar:=p_vendor_id;
  v_worktime numeric;
BEGIN
    if p_vendor_id is null then
        -- select the quickest vendor
        SELECT PO.C_BPARTNER_ID
                INTO v_vendor
                FROM M_PRODUCT_PO po
                WHERE po.m_product_id=p_product_id and PO.iscurrentvendor='Y' 
                ORDER BY COALESCE(po.deliverytime_promised,1)  LIMIT 1;
    end if;
    select coalesce(deliverytime_promised,0)*8+1 into  v_workhours from m_product_po where m_product_id=p_product_id and c_bpartner_id=v_vendor;
    if v_workhours=0 then
        return '';
    end if;
    for v_cur in (select worktime,workdate from c_workcalender where workdate >= trunc(now()) order by workdate)
    LOOP
        v_worktime:=coalesce(c_getorgworktime(p_org_id,v_cur.workdate),v_cur.worktime);
        if v_worktime>0 then
            if v_hours+8 >= v_workhours then
                return to_char(v_cur.workdate,'DD-MM-YYYY');
            else
                v_hours:=v_hours+v_worktime;
            end if;
        end if;
    END LOOP;
    return to_char(trunc(now())+trunc(v_workhours/5.7),'DD-MM-YYYY');
END ; $_$ LANGUAGE 'plpgsql';
  
  
  
CREATE OR REPLACE FUNCTION mrp_orderlineupdatedeliverydate(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ 
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************

Overload for Process Scheduler

*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message character varying:='';
v_sheddeliverydate timestamp;
Cur_Parameter record;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID  into v_Record_ID from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    else
        v_message := '';
        FOR Cur_Parameter IN
          (SELECT para.*
           FROM ad_pinstance pi, ad_pinstance_Para para
           WHERE 1=1
            AND pi.ad_pinstance_ID = para.ad_pinstance_ID
            AND pi.ad_pinstance_ID = p_pinstance_ID
           ORDER BY para.SeqNo
          )
        LOOP
          IF ( UPPER(Cur_Parameter.parametername) = UPPER('scheddeliverydate') ) THEN
            v_sheddeliverydate := Cur_Parameter.p_date;
          END IF;
        END LOOP; -- Get Parameter
        RAISE NOTICE '%','Updating pinstance - Processing ' || p_pinstance_ID;
    end if;
    update c_orderline set scheddeliverydate=v_sheddeliverydate where c_orderline_id=v_Record_ID;
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1 , v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  IF(p_pinstance_id IS NOT NULL) THEN
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message);
  ELSE
    RAISE EXCEPTION '%', SQLERRM;
  END IF;
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

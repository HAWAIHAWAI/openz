

/*****************************************************+


Functions to Retrieve COSTS for Machines, Salarys

and Indirect Costs



*****************************************************/
CREATE or replace FUNCTION zsco_get_costcenter_cost(p_Costcenter_id character varying, p_fromdate timestamp with time zone,p_todate timestamp with time zone, p_orgid character varying) RETURNS numeric
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
Get Costcenter Costs
*****************************************************/
  v_MacctCost     NUMERIC;
  v_InvoiceCost     NUMERIC;
  BEGIN
    
    IF(p_Costcenter_id IS NULL) THEN
      RETURN 0;
    END IF;
   
    -- Select the valid Cost: Purchase Invoices, not Voided, 
    select sum(case il.linenetamt when 0 then il.linegrossamt else il.linenetamt end) into v_InvoiceCost from c_invoiceline il,c_invoice i where i.c_invoice_id=il.c_invoice_id and i.issotrx='N' and i.docstatus in ('CO','CL') 
                                                   and case coalesce(p_orgid,'0') when '0' then 1=1 else i.ad_org_id=p_orgid end
                                                   and coalesce(p_fromdate,now()-100000)<=i.dateinvoiced and coalesce(p_todate,now()+100000)>=i.dateinvoiced
                                                   and il.a_asset_id=p_Costcenter_id;
       
    select sum(case isdr2cr when 'Y' then ml.amt else -ml.amt end) into v_MacctCost from zsfi_macctline ml,zsfi_manualacct m where m.zsfi_manualacct_id=ml.zsfi_manualacct_id 
                                                   and ml.glstatus = 'PO' and ml.a_asset_id= p_Costcenter_id
                                                   and coalesce(p_fromdate,now()-100000)<=m.acctdate and coalesce(p_todate,now()+100000)>=m.acctdate;
    

    RETURN coalesce(v_MacctCost,0)+coalesce(v_InvoiceCost,0);
END;
$_$  LANGUAGE 'plpgsql';
ALTER FUNCTION zsco_get_costcenter_cost(p_Costcenter_id character varying, p_fromdate timestamp with time zone,p_todate timestamp with time zone, p_orgid character varying) OWNER TO tad;


select zsse_dropfunction ('zsco_get_salary_cost');
CREATE or replace FUNCTION zsco_get_salary_cost(p_Salary_Category_id character varying, p_movementdate timestamp with time zone, p_costuom character varying, p_cost out numeric ,p_specialtime1 out numeric ,p_specialtime2 out numeric ) RETURNS RECORD
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
Get Work Costs from costing table 
*****************************************************/
  v_Cost     RECORD;
BEGIN
    
    IF(p_Salary_Category_id IS NULL) THEN
      RETURN;
    END IF;
    IF(p_MovementDate IS NULL) THEN
      RETURN;
    END IF;
    
    -- Select the valid Cost, Default is UOM Hour
    select coalesce(cost,0),  coalesce(special1,0),      coalesce(special2,0) into p_cost, p_specialtime1, p_specialtime2 from c_salary_category_cost where c_salary_category_id=p_Salary_Category_id  and datefrom<=p_movementdate and coalesce(p_costuom,'H')= costuom LIMIT 1;
    
      RETURN;
END;
$_$  LANGUAGE 'plpgsql';



CREATE or replace FUNCTION zsco_get_machine_cost(p_ma_machine_id character varying, p_movementdate timestamp with time zone, p_costuom character varying) RETURNS numeric
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
Get Machine Costs from costing table 
*****************************************************/
  v_Cost     NUMERIC;
  BEGIN
    
    IF(p_ma_machine_id IS NULL) THEN
      RETURN 0;
    END IF;
    IF(p_MovementDate IS NULL) THEN
      RETURN 0;
    END IF;
    
    -- Select the valid Cost, Default is UOM Hour
       select cost into v_Cost from ma_machine_cost where ma_machine_id=p_ma_machine_id  and validfrom<=p_movementdate and coalesce(p_costuom,'H')= costuom and isactive='Y' LIMIT 1;

    if v_Cost is null then      
        RAISE EXCEPTION '%', '@zspm_NotCostApplies@';
    end if;
    RETURN v_cost;
END;
$_$  LANGUAGE 'plpgsql';


select zsse_dropfunction ('zsco_get_indirect_cost');

CREATE or replace FUNCTION zsco_get_indirect_cost(p_ma_indcost_id character varying, p_movementdate timestamp with time zone, p_costuom character varying,
                                                  p_projecttask_id varchar,p_planorfact varchar,p_product_id varchar,
                                                  p_empcost OUT numeric,p_matcost OUT numeric, p_machinecost out numeric,p_vendorcost out numeric) RETURNS  RECORD
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
Get Indirect Costs from costing table 
*****************************************************/
v_cost record;
v_cur record;
v_bomamt numeric;
v_expenseamt numeric;
v_invoicecost numeric;
v_glcost numeric;
  BEGIN
    for v_cost in ( select ma_indirect_cost_value_id,coalesce(empcost,0) as a,coalesce(machinecost,0) as b,coalesce(materialcost,0) as c,coalesce(vendorcost,0) as d
                    from ma_indirect_cost_value where ma_indirect_cost_id=p_ma_indcost_id  
                    and datefrom<=p_movementdate and coalesce(p_costuom,'H')= cost_uom and isactive='Y'
                     LIMIT 1)
    LOOP
        if coalesce(p_planorfact,'Ä')='plan' and coalesce(p_costuom,'H')='P' and p_projecttask_id is not null then
            select sum(plannedamt)*v_cost.c/100 into v_bomamt from zspm_projecttaskbom where c_projecttask_id=p_projecttask_id  and isactive='Y'
                   and not exists (select 0 from ma_indirect_cost_value_product where  ma_indirect_cost_value_id=v_cost.ma_indirect_cost_value_id and m_product_id=zspm_projecttaskbom.m_product_id);                 
            for v_cur in (select pv.cost,bom.plannedamt,pv.m_product_id from ma_indirect_cost_value_product pv,zspm_projecttaskbom bom 
                          where bom.c_projecttask_id=p_projecttask_id and pv.m_product_id=bom.m_product_id and pv.ma_indirect_cost_value_id=v_cost.ma_indirect_cost_value_id)
            LOOP
                if p_product_id is null then 
                    v_bomamt:=coalesce(v_bomamt,0)+v_cur.plannedamt*v_cur.cost/100;
                else
                    if v_cur.m_product_id=p_product_id then
                        p_vendorcost:=round(coalesce(v_cur.plannedamt,0)*v_cur.cost/100,2);
                        RETURN;
                    end if;
                end if;
            END LOOP;
            select sum(plannedamt)*v_cost.d/100 into v_expenseamt from C_projecttaskexpenseplan where c_projecttask_id=p_projecttask_id  and isactive='Y' 
                   and not exists (select 0 from ma_indirect_cost_value_product where  ma_indirect_cost_value_id=v_cost.ma_indirect_cost_value_id and m_product_id=C_projecttaskexpenseplan.m_product_id);
            for v_cur in (select pv.cost,ex.plannedamt,pv.m_product_id from ma_indirect_cost_value_product pv,C_projecttaskexpenseplan ex
                          where ex.c_projecttask_id=p_projecttask_id and pv.m_product_id=ex.m_product_id and pv.ma_indirect_cost_value_id=v_cost.ma_indirect_cost_value_id)
            LOOP
                if p_product_id is null then 
                    v_expenseamt:=coalesce( v_expenseamt,0)+v_cur.plannedamt*v_cur.cost/100;
                else
                    if v_cur.m_product_id=p_product_id then
                        p_vendorcost:=round(coalesce(v_cur.plannedamt,0)*v_cur.cost/100,2);
                        RETURN;
                    end if;
                end if;
            END LOOP;
            v_expenseamt:=coalesce( v_expenseamt,0);
            v_bomamt:=coalesce(v_bomamt,0);
        end if;
        if coalesce(p_planorfact,'Ä')='fact' and coalesce(p_costuom,'H')='P' and p_projecttask_id is not null then
            select sum((case when ad_get_docbasetype(c_invoice.c_doctype_id)='APC' then coalesce(linenetamt,0)*-1 else coalesce(linenetamt,0) end)*v_cost.d/100)  into v_invoicecost
                                from c_invoice ,c_invoiceline
                                left join m_product on c_invoiceline.m_product_id=m_product.m_product_id 
                                where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and   c_invoiceline.c_projecttask_id=p_projecttask_id and
                                case  coalesce(c_invoiceline.m_product_id,'') when '' then 1=1 else (m_product.producttype='S' or (m_product.producttype='I' and m_product.isstocked='N')) end 
                                and c_invoice.docstatus = 'CO' and c_invoice.issotrx='N' 
                                and not exists (select 0 from ma_indirect_cost_value_product where  ma_indirect_cost_value_id=v_cost.ma_indirect_cost_value_id and m_product_id=c_invoiceline.m_product_id);             
            select coalesce(sum(round(case when ml.isgross='N' or t.rate=0 then ml.amt*case when ml.isdr2cr='Y' then 1 else -1 end else case when ml.isdr2cr='Y' then 1 else -1 end * ml.amt-ml.amt/(1+100/t.rate) end,2)),0)
                                                                                                     into v_glcost from zsfi_macctline ml, zsfi_manualacct mic,c_tax t 
                                                                                                     where  ml.c_projecttask_id=p_projecttask_id and
                                                                                                     t.c_tax_id=ml.c_tax_id and
                                                                                                     mic.zsfi_manualacct_id=ml.zsfi_manualacct_id and 
                                                                                                     mic.glstatus='PO';                     
            for v_cur in (select pv.cost,pv.m_product_id,case when ad_get_docbasetype(c_invoice.c_doctype_id)='APC' then coalesce(linenetamt,0)*-1 else coalesce(linenetamt,0) end as invcost
                                 from c_invoice ,c_invoiceline
                                 left join m_product on c_invoiceline.m_product_id=m_product.m_product_id ,
                                 ma_indirect_cost_value_product pv
                                where c_invoice.c_invoice_id=c_invoiceline.c_invoice_id and   c_invoiceline.c_projecttask_id=p_projecttask_id and
                                case  coalesce(c_invoiceline.m_product_id,'') when '' then 1=1 else (m_product.producttype='S' or (m_product.producttype='I' and m_product.isstocked='N')) end 
                                and c_invoice.docstatus = 'CO' and c_invoice.issotrx='N' 
                                and c_invoiceline.m_product_id=pv.m_product_id and pv.ma_indirect_cost_value_id=v_cost.ma_indirect_cost_value_id)
            LOOP
                if p_product_id is null then 
                    v_invoicecost:=coalesce(v_invoicecost,0)+v_cur.invcost*v_cur.cost/100;
                else
                    if v_cur.m_product_id=p_product_id then
                        p_vendorcost:=round(coalesce(v_cur.invcost,0)*v_cur.cost/100,2);
                        RETURN;
                    end if;
                end if;
            END LOOP;
            select sum(coalesce(actualcosamount,0))*v_cost.c/100 into v_bomamt from zspm_projecttaskbom where c_projecttask_id=p_projecttask_id
                   and not exists (select 0 from ma_indirect_cost_value_product where  ma_indirect_cost_value_id=v_cost.ma_indirect_cost_value_id and m_product_id=zspm_projecttaskbom.m_product_id);
            for v_cur in (select pv.m_product_id,pv.cost,coalesce(bom.actualcosamount,0) as actualcosamount from ma_indirect_cost_value_product pv,zspm_projecttaskbom bom 
                          where bom.c_projecttask_id=p_projecttask_id and pv.m_product_id=bom.m_product_id and pv.ma_indirect_cost_value_id=v_cost.ma_indirect_cost_value_id)
            LOOP
                if p_product_id is null then 
                    v_bomamt:=coalesce(v_bomamt,0)+v_cur.actualcosamount*v_cur.cost/100;
                else
                    if v_cur.m_product_id=p_product_id then
                        p_vendorcost:=round(coalesce(v_cur.actualcosamount,0)*v_cur.cost/100,2);
                        RETURN;
                    end if;
                end if;
            END LOOP;
            v_invoicecost:=coalesce(v_invoicecost,0);
            v_glcost:=coalesce(v_glcost*v_cost.d/100,0);
            v_expenseamt:=v_glcost+v_invoicecost;
            v_bomamt:=coalesce(v_bomamt,0);
        end if;              
        if p_product_id is null or p_product_id='NOPRODUCTS' then
            p_empcost:=v_cost.a;
            p_matcost:=round(v_bomamt,2);
            p_machinecost:=v_cost.b;
            p_vendorcost:=round(v_expenseamt,2);
            RETURN;
        end if;
    END LOOP;
    p_empcost:=0;
    p_matcost:=0;
    p_machinecost:=0;
    p_vendorcost:=0;
    RETURN;
END;
$_$  LANGUAGE 'plpgsql';



CREATE or replace FUNCTION zsco_prod_offerpricestdplist(p_org_id character varying, p_bpartner character varying, p_product character varying,p_qty character varying) RETURNS character varying
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
Get From Standard Sales Pricelist the Offer Price for a specific Product, Partner and QTY
ONLY SALES!
*****************************************************/
  v_plvid   character varying;
  v_pl   character varying;
  v_price numeric;
  BEGIN
   select M_PRICELIST_ID into v_pl from c_bpartner where c_bpartner_id=p_bpartner;
   SELECT M_PRICELIST_VERSION_ID  INTO v_plvid  FROM M_PRICELIST_VERSION
          WHERE M_PRICELIST_ID=v_pl and  VALIDFROM =    (SELECT max(VALIDFROM)    FROM M_PRICELIST_VERSION   WHERE M_PRICELIST_ID=v_pl and VALIDFROM<=TO_DATE(NOW())); 
   -- Default, if none found
   if v_pl is null then
        SELECT M_PRICELIST_VERSION_ID  INTO v_plvid  FROM M_PRICELIST_VERSION
                WHERE M_PRICELIST_ID IN    (SELECT M_PRICELIST_ID    FROM M_PRICELIST    WHERE ISDEFAULT = 'Y'  AND AD_ORG_ID in ('0', p_org_id) and issopricelist='Y' AND ISACTIVE = 'Y')
                AND VALIDFROM =    (SELECT max(VALIDFROM)    FROM M_PRICELIST_VERSION   
                                          WHERE M_PRICELIST_ID IN   (SELECT M_PRICELIST_ID    FROM M_PRICELIST    WHERE ISDEFAULT = 'Y'  AND AD_ORG_ID in ('0', p_org_id) and issopricelist='Y' AND ISACTIVE = 'Y')
                                          AND VALIDFROM <= TO_DATE(NOW()) 
                                  );
        select  M_PRICELIST_ID into v_pl from M_PRICELIST_VERSION where M_PRICELIST_VERSION_ID=v_plvid;
   end if;
   -- Get actual Price
   v_price:=m_get_offers_price(to_date(now()),p_bpartner,p_product,null,to_number(p_qty),v_pl);
   RETURN to_char(coalesce(v_price,0));
END;
$_$  LANGUAGE 'plpgsql';



-- DROP FUNCTION m_get_offers_price(timestamp without time zone, character varying, character varying, numeric, numeric, character varying);

CREATE OR REPLACE FUNCTION m_get_offers_price(p_date timestamp without time zone, p_bpartner_id character varying, p_product_id character varying, p_pricestd numeric, p_qty numeric, p_pricelist character varying)
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
 
        
p_pricestd is irrelevant.
Overloaded Function
******************************************************************************************************************************/
BEGIN
   return m_get_offers_price(p_date , p_bpartner_id , p_product_id ,  p_qty , p_pricelist);
END;  $BODY$   LANGUAGE 'plpgsql' VOLATILE  COST 100;

CREATE OR REPLACE FUNCTION m_get_offers_price(p_date timestamp without time zone, p_bpartner_id character varying, p_product_id character varying, p_qty numeric, p_pricelist character varying)
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
****************************************************************************************************************************************************

Overloaded Function

Normal Call in all Purchase/Sales Actions-

Implementation of m_get_offers_price was extended with direct Fetch of PO-Purchase - Price for calculation Sales-Price

******************************************************************************************************************************/
BEGIN
   return m_get_offers_price(p_date , p_bpartner_id , p_product_id ,  p_qty , p_pricelist,'N',null);
END;  $BODY$   LANGUAGE 'plpgsql' VOLATILE  COST 100;

CREATE OR REPLACE FUNCTION m_get_offers_price(p_date timestamp without time zone, p_bpartner_id character varying, p_product_id character varying, p_qty numeric, p_pricelist character varying, p_directpurchasecalc  character varying,p_poprice numeric)
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
****************************************************************************************************************************************************

Overloaded Function

Implementation of m_get_offers_price was extended with gross purchase prices for direct Fetch of PO-Purchase - Price for calculation Sales-Price

******************************************************************************************************************************/
BEGIN
   return m_get_offers_price(p_date , p_bpartner_id , p_product_id ,  p_qty , p_pricelist, p_directpurchasecalc, p_poprice, 'N', null);
END;  $BODY$   LANGUAGE 'plpgsql' VOLATILE  COST 100;


CREATE OR REPLACE FUNCTION m_get_offers_price(p_date timestamp without time zone, p_bpartner_id character varying, p_product_id character varying, p_qty numeric, p_pricelist character varying, p_directpurchasecalc  character varying, p_poprice numeric, p_isgrossprice character varying, p_tax_id character varying)
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
 Contributions: Purchasing: Get from m_product_po - Get the Proce from the Vendor provided first-Then take this 
         price and go through offers table
         Implementation of m_get_offers_price was extended with direct Fetch of PO-Purchase - Price for calculation Sales-Price
         In this case p_pricelist is useless and  p_poprice is used direct for calculation.
         In all other cases p_pricelist (ID of Pricelist or Version) is Mandantory and p_poprice is not used.
 
******************************************************************************************************************************/
    v_Price NUMERIC;
    Cur_Offer RECORD;
    v_issoPL   character varying:='N';
    v_currency character varying;
    v_plvid  character varying;
    v_plist  character varying;
    v_orgid  character varying;
  BEGIN
    if coalesce(p_directpurchasecalc,'N')='N' then
            -- Get the Relevant Sales-Pricelist-Standard-Price or PO-Standard-Price for normal Calculation
            -- First check if Paranmeter p_pricelist is the Pricelist-Version
            SELECT M_PRICELIST_VERSION_ID,ad_org_id,M_PRICELIST_ID into v_plvid,v_orgid,v_plist from M_PRICELIST_VERSION where M_PRICELIST_VERSION_ID=p_pricelist;
            if v_plvid is null then
            -- p_pricelist is the  Pricelist itself - Select the relevant Version
            SELECT M_PRICELIST_VERSION_ID,ad_org_id,M_PRICELIST_ID  INTO v_plvid,v_orgid,v_plist  FROM M_PRICELIST_VERSION
                    WHERE M_PRICELIST_ID=p_pricelist and  VALIDFROM =    (SELECT max(VALIDFROM)    FROM M_PRICELIST_VERSION   WHERE M_PRICELIST_ID=p_pricelist and VALIDFROM<=TO_DATE(NOW())); 
            END if;
            SELECT issopricelist,c_currency_id into v_issoPL,v_currency  from m_pricelist where m_pricelist_id=v_plist;
            -- Select Sales Price
            if v_issoPL='Y' then
                  -- Sales - Take the price from pricelist
                  v_Price := m_bom_pricestd(p_product_id, v_plvid);
                  RAISE NOTICE '%','Sales Pricelist';
                  -- Select Purchase Price
            ELSE
                  RAISE NOTICE '%','Purchase Pricelist';
                  -- Purchase - Take the Price from Business-Partner - Product-PO - If none Found: Take the price provided
                  select pricepo into v_Price  from m_product_po where m_product_id=p_product_id and c_currency_id=v_currency  and isactive='Y' and c_bpartner_id=p_bpartner_id  limit 1;
                  --@TODO: Automatically fill m_product_po - Currency from po-Pricelist or move po-Pricelist to m_product_po
                  if v_Price is null then
                  select pricepo into v_Price  from m_product_po where m_product_id=p_product_id  and isactive='Y' and c_bpartner_id=p_bpartner_id  limit 1;
                  end if;
                  --
                  RAISE NOTICE '%','Purchaseing Price: '||coalesce(v_Price,0);
            end if;
    ELSIF coalesce(p_directpurchasecalc,'N')='Y' then
		IF p_isgrossprice = 'N'  THEN
		    -- Take Supplied PO-Purchase - Price for calculation of Sales-Price directly
			v_Price :=  coalesce(p_poprice,0);
		ELSE
			-- Take net PO-Price directly, calculate net price for further recharge, rounding errors unavoidable
			v_Price := coalesce(p_poprice,0) / ((select rate from c_tax where c_tax_id = p_tax_id)/100 + 1);
		END IF;
		v_issoPL := 'Y';
    END IF;
    if v_Price is null or v_Price=0 then 
           v_Price := 0;
           RETURN v_Price;
    end if;
    FOR Cur_Offer IN
      (SELECT M_OFFER_ID
      FROM M_OFFER
      WHERE p_Date BETWEEN DATEFROM AND COALESCE(DATETO, TO_DATE('31-12-9999', 'DD-MM-YYYY'))
        AND IsActive = 'Y'
        AND issalesoffer = v_issoPL
        AND directpurchasecalc = coalesce (p_directpurchasecalc,'N')
        AND (p_Qty >= COALESCE(Qty_From,0) OR Qty_From IS NULL)
        AND (p_Qty <= COALESCE(Qty_To,0) OR Qty_To IS NULL)
        AND ((PRICELIST_SELECTION='Y' AND NOT EXISTS (SELECT 1 FROM M_OFFER_PRICELIST
           WHERE M_OFFER_ID=M_OFFER.M_OFFER_ID
           AND M_PRICELIST_ID = v_plist))
            OR (PRICELIST_SELECTION='N' AND EXISTS(SELECT 1 FROM M_OFFER_PRICELIST
                WHERE M_OFFER_ID = M_OFFER.M_OFFER_ID
                AND M_PRICELIST_ID = v_plist)))
        AND((BPARTNER_SELECTION = 'Y'
        AND NOT EXISTS
        (SELECT 1
        FROM M_OFFER_BPARTNER
        WHERE M_OFFER_ID = M_OFFER.M_OFFER_ID
          AND C_BPARTNER_ID = p_BPartner_ID
        ))
        OR(BPARTNER_SELECTION = 'N'
        AND EXISTS
        (SELECT 1
        FROM M_OFFER_BPARTNER
        WHERE M_OFFER_ID = M_OFFER.M_OFFER_ID
          AND C_BPARTNER_ID = p_BPartner_ID
        )))
        AND((BP_GROUP_SELECTION = 'Y'
        AND NOT EXISTS
        (SELECT 1
        FROM C_BPARTNER B,
          M_OFFER_BP_GROUP OB
        WHERE OB.M_OFFER_ID = M_OFFER.M_OFFER_ID
          AND B.C_BPARTNER_ID = p_BPartner_ID
          AND OB.C_BP_GROUP_ID = B.C_BP_GROUP_ID
        ))
        OR(BP_GROUP_SELECTION = 'N'
        AND EXISTS
        (SELECT 1
        FROM C_BPARTNER B,
          M_OFFER_BP_GROUP OB
        WHERE OB.M_OFFER_ID = M_OFFER.M_OFFER_ID
          AND B.C_BPARTNER_ID = p_BPartner_ID
          AND OB.C_BP_GROUP_ID = B.C_BP_GROUP_ID
        )))
        AND((PRODUCT_SELECTION = 'Y'
        AND NOT EXISTS
        (SELECT 1
        FROM M_OFFER_PRODUCT
        WHERE M_OFFER_ID = M_OFFER.M_OFFER_ID
          AND M_PRODUCT_ID = p_Product_ID
        ))
        OR(PRODUCT_SELECTION = 'N'
        AND EXISTS
        (SELECT 1
        FROM M_OFFER_PRODUCT
        WHERE M_OFFER_ID = M_OFFER.M_OFFER_ID
          AND M_PRODUCT_ID = p_Product_ID
        )))
        AND((PROD_CAT_SELECTION = 'Y'
        AND NOT EXISTS
        (SELECT 1
        FROM M_PRODUCT P,
          M_OFFER_PROD_CAT OP
        WHERE OP.M_OFFER_ID = M_OFFER.M_OFFER_ID
          AND P.M_PRODUCT_ID = p_Product_ID
          AND OP.M_PRODUCT_CATEGORY_ID = P.M_PRODUCT_CATEGORY_ID
        ))
        OR(PROD_CAT_SELECTION = 'N'
        AND EXISTS
        (SELECT 1
        FROM M_PRODUCT P,
          M_OFFER_PROD_CAT OP
        WHERE OP.M_OFFER_ID = M_OFFER.M_OFFER_ID
          AND P.M_PRODUCT_ID = p_Product_ID
          AND OP.M_PRODUCT_CATEGORY_ID = P.M_PRODUCT_CATEGORY_ID
        )))
      ORDER BY PRIORITY,
        M_OFFER_ID ASC
      )
    LOOP
      v_Price := M_Get_Offer_Price(Cur_Offer.M_Offer_ID, v_Price) ;
    END LOOP;
    RETURN v_Price;
  EXCEPTION
  WHEN OTHERS THEN
    RETURN v_Price;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION m_get_offers_price(timestamp without time zone, character varying, character varying, numeric, numeric, character varying) OWNER TO tad;



-- Function: m_bom_pricestd(character varying, character varying)

-- DROP FUNCTION m_bom_pricestd(character varying, character varying);

CREATE OR REPLACE FUNCTION m_bom_pricestd(p_product_id character varying, p_pricelist character varying)
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

/* Contributions: Purchasing: Get from m_product_po
         Selling: Get from Pricelist
                  If no Price in Pricelist, Price=0
         Removed BOM-Stuff-This is Rubbish
         Get Currency from Pricelist
******************************************************************************************************************************/
  v_Price        NUMERIC;
  v_currency VARCHAR(32); --OBTG:VARCHAR2--
  v_issoPL   character varying;
  v_count numeric;
  v_org character varying;
  v_plvid  character varying;
  v_plist  character varying;
  BEGIN
    -- First check if Paranmeter p_pricelist is the Pricelist-Version
    SELECT M_PRICELIST_VERSION_ID,ad_org_id,M_PRICELIST_ID into v_plvid,v_org,v_plist from M_PRICELIST_VERSION where M_PRICELIST_VERSION_ID=p_pricelist;
    if v_plvid is null then
       -- p_pricelist is the  Pricelist itself - Select the relevant Version
      SELECT M_PRICELIST_VERSION_ID,ad_org_id,M_PRICELIST_ID  INTO v_plvid,v_org,v_plist  FROM M_PRICELIST_VERSION
            WHERE M_PRICELIST_ID=p_pricelist and  VALIDFROM =    (SELECT max(VALIDFROM)    FROM M_PRICELIST_VERSION   WHERE M_PRICELIST_ID=p_pricelist and VALIDFROM<=TO_DATE(NOW())); 
    END if;

    SELECT issopricelist,c_currency_id into v_issoPL, v_currency  from m_pricelist where m_pricelist_id=v_plist;
    
    -- If Sales - Order get price from PriceList directly
    if v_issoPL='Y' then
      SELECT COALESCE(pricestd, 0)
      INTO v_Price
      FROM M_ProductPrice
      WHERE M_PriceList_Version_ID = v_plvid
        AND M_Product_ID = p_Product_ID;
    else
    -- In PO get Listprice from m_prpoduct PO 
        select pricepo into v_price
                   from M_PRODUCT_PO po 
                   where po.m_product_id=p_product_id and po.c_currency_id=v_currency and PO.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',v_org) order by coalesce(po.qualityrating,0) desc,updated desc limit 1;
        --@TODO: Automatically fill m_product_po - Currency from po-Pricelist or move po-Pricelist to m_product_po
       if v_Price is null then
          select pricepo into v_Price  from m_product_po po where m_product_id=p_product_id  and PO.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',v_org) order by coalesce(po.qualityrating,0) desc,updated desc limit 1;
       end if;
    end if;      
    --
    if  v_Price is null then v_Price:=0; end if;
    --RETURN c_currency_round(v_price, v_currency,null);
     RETURN round(v_price, 4);
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION m_bom_pricestd(character varying, character varying) OWNER TO tad;






-- Function: m_bom_pricelist(character varying, character varying)

-- DROP FUNCTION m_bom_pricelist(character varying, character varying);

CREATE OR REPLACE FUNCTION m_bom_pricelist(p_product_id character varying, p_pricelist character varying)
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

/* Contributions: Purchasing: Get from m_product_po
         Selling: Get from Pricelist
                  If no Price in Pricelist, Price=0
         Removed BOM-Stuff-This is Rubbish
         Get Currency from Pricelist
******************************************************************************************************************************/
  v_Price        NUMERIC;
  v_currency VARCHAR(32); --OBTG:VARCHAR2--
  v_issoPL   character varying;
  v_count numeric;
  v_org character varying;
  v_plvid  character varying;
  v_plist  character varying;
  BEGIN
    -- First check if Paranmeter p_pricelist is the Pricelist-Version
    SELECT M_PRICELIST_VERSION_ID,ad_org_id,M_PRICELIST_ID into v_plvid,v_org,v_plist from M_PRICELIST_VERSION where M_PRICELIST_VERSION_ID=p_pricelist;
    if v_plvid is null then
       -- p_pricelist is the  Pricelist itself - Select the relevant Version
      SELECT M_PRICELIST_VERSION_ID,ad_org_id,M_PRICELIST_ID  INTO v_plvid,v_org,v_plist  FROM M_PRICELIST_VERSION
            WHERE M_PRICELIST_ID=p_pricelist and  VALIDFROM =    (SELECT max(VALIDFROM)    FROM M_PRICELIST_VERSION   WHERE M_PRICELIST_ID=p_pricelist and VALIDFROM<=TO_DATE(NOW())); 
    END if;

    SELECT issopricelist,c_currency_id into v_issoPL, v_currency  from m_pricelist where m_pricelist_id=v_plist;
    
    -- If Sales - Order get price from PriceList directly
    if v_issoPL='Y' then
      SELECT COALESCE(PriceList, 0)
      INTO v_Price
      FROM M_ProductPrice
      WHERE M_PriceList_Version_ID = v_plvid
        AND M_Product_ID = p_Product_ID;
    else
    -- In PO get Listprice from m_prpoduct PO 
        select pricelist into v_price
                   from M_PRODUCT_PO po 
                   where po.m_product_id=p_product_id  and po.c_currency_id=v_currency and PO.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',v_org) order by coalesce(po.qualityrating,0) desc,updated desc limit 1;    
         --@TODO: Automatically fill m_product_po - Currency from po-Pricelist or move po-Pricelist to m_product_po
       if v_Price is null then
          select pricelist into v_Price  from m_product_po po where m_product_id=p_product_id  and PO.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',v_org) order by coalesce(po.qualityrating,0) desc,updated desc limit 1;
       end if;
    end if;      
    --
    if  v_Price is null then v_Price:=0; end if;
    --RETURN c_currency_round(v_price, v_currency,null);
    RETURN round(v_price, 4);
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION m_bom_pricelist(character varying, character varying) OWNER TO tad;



-- Function: m_bom_pricelimit(character varying, character varying)

-- DROP FUNCTION m_bom_pricelimit(character varying, character varying);

CREATE OR REPLACE FUNCTION m_bom_pricelimit(p_product_id character varying, p_pricelist character varying)
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
 Contributions: Purchasing: Get from m_product_po
         Selling: Get from Pricelist
                  If no Price in Pricelist, Price=0
         Removed BOM-Stuff-This is Rubbish
         Get Currency from Pricelist
******************************************************************************************************************************/
  v_Price        NUMERIC;
  v_currency VARCHAR(32); --OBTG:VARCHAR2--
  v_issoPL   character varying;
  v_plvid  character varying;
  v_plist  character varying;
    --
  BEGIN
    -- First check if Paranmeter p_pricelist is the Pricelist-Version
    SELECT M_PRICELIST_VERSION_ID,M_PRICELIST_ID into v_plvid,v_plist from M_PRICELIST_VERSION where M_PRICELIST_VERSION_ID=p_pricelist;
    if v_plvid is null then
       -- p_pricelist is the  Pricelist itself - Select the relevant Version
      SELECT M_PRICELIST_VERSION_ID,M_PRICELIST_ID  INTO v_plvid,v_plist  FROM M_PRICELIST_VERSION
            WHERE M_PRICELIST_ID=p_pricelist and  VALIDFROM =    (SELECT max(VALIDFROM)    FROM M_PRICELIST_VERSION   WHERE M_PRICELIST_ID=p_pricelist and VALIDFROM<=TO_DATE(NOW())); 
    END if;

    SELECT issopricelist,c_currency_id into v_issoPL, v_currency  from m_pricelist where m_pricelist_id=v_plist;
    
    -- If Sales - Order get price from PriceList directly
    if v_issoPL='Y' then
      SELECT COALESCE(PriceLimit, 0)
      INTO v_Price
      FROM M_ProductPrice
      WHERE M_PriceList_Version_ID = v_plvid
        AND M_Product_ID = p_Product_ID;
    else
    -- In PO a Limit doesn't make sense
       v_Price:=0;
    end if;      
    --
    if  v_Price is null then v_Price:=0; end if;
    --RETURN c_currency_round(v_price, v_currency,null);
     RETURN round(v_price, 4);
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION m_bom_pricelimit(character varying, character varying) OWNER TO tad;





-- Material Cost richtig ermitteln....neu geschrieben
CREATE OR REPLACE FUNCTION m_get_product_cost(p_product_id character varying, p_movementdate timestamp without time zone, p_costtype character, p_org_id character varying)
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
 Contributions:Get material Costs from costing table (Rewritten)
******************************************************************************************************************************/
  v_Cost     NUMERIC;
  v_CostType VARCHAR(60) ; 
  BEGIN
    v_CostType := p_CostType;
    IF(p_Product_ID IS NULL) THEN
      RETURN 0;
    END IF;
    IF(p_MovementDate IS NULL) THEN
      RETURN 0;
    END IF;
    -- select the Real cost only if costtype is set
    if p_costtype is not null then
        select cost into v_Cost from M_COSTING where m_product_id=p_product_id and costtype=p_costtype and p_movementdate between datefrom and dateto and ad_org_id=p_org_id order by created desc LIMIT 1;
        if v_Cost is null then
           -- Try default
           select cost into v_Cost from M_COSTING where m_product_id=p_product_id and costtype=p_costtype and p_movementdate between datefrom and dateto and ad_org_id='0' order by created desc LIMIT 1;
        end if;
    END IF;
    if v_Cost is null then
       -- Select the fist found cost 
       select cost into v_Cost from M_COSTING where m_product_id=p_product_id  and p_movementdate between datefrom and dateto  and ad_org_id=p_org_id order by created desc LIMIT 1;
       if v_Cost is null then
           -- Try default
           select cost into v_Cost from M_COSTING where m_product_id=p_product_id  and p_movementdate between datefrom and dateto  and ad_org_id='0' order by created desc LIMIT 1;
       end if;
    end if;
    if v_Cost is null then
          v_Cost:=0;
    end if;
    RETURN v_cost;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;






/*****************************************************+





   
  Cost Center (Tree)
  
   
*****************************************************/


CREATE OR REPLACE FUNCTION a_asset_cctree_trg() RETURNS trigger
AS $BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Cosing
Imlements Cost Center Tree
*****************************************************/
v_Tree_ID              character varying;
v_Parent_ID            character varying;
v_exists               numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;  END IF;
  select ad_tree_id into v_Tree_ID from ad_tree where treetype='CC' and isactive='Y';
  select ad_treenode_id into v_Parent_ID from ad_treenode where ad_tree_id=v_Tree_ID and parent_id is null;
  -- only if tree exists
  if v_Tree_ID is not null and v_Parent_ID is not null then
       IF TG_OP in ('INSERT','UPDATE') then
            select count(*) into v_exists from AD_TreeNode where AD_Tree_ID=v_Tree_ID and Node_ID=new.A_ASSET_ID;
            if v_exists =0 THEN    
                --  Insert into TreeNode
                INSERT INTO AD_TreeNode
                  (AD_TreeNode_ID, AD_Client_ID, AD_Org_ID,
                  IsActive, Created, CreatedBy, Updated, UpdatedBy,
                  AD_Tree_ID, Node_ID,
                  Parent_ID, SeqNo)
                VALUES
                  (get_uuid(), new.AD_Client_ID, new.AD_Org_ID,
                  new.IsActive, new.Created, new.CreatedBy, new.Updated, new.UpdatedBy,
                  v_Tree_ID, new.A_ASSET_ID,
                  '0', (CASE new.IsSummary WHEN 'Y' THEN 100 ELSE 999 END));    -- Summary Nodes first
            end if;
       else --delete
            delete from AD_TreeNode where AD_Tree_ID=v_Tree_ID and Node_ID=old.A_ASSET_ID;
       end if;
  end if;
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION a_asset_cctree_trg() OWNER TO tad;

DROP TRIGGER a_asset_cctree_trg ON a_asset;

CREATE TRIGGER a_asset_cctree_trg
  AFTER INSERT OR UPDATE OR DELETE
  ON a_asset
  FOR EACH ROW
  EXECUTE PROCEDURE a_asset_cctree_trg();

select zsse_DropFunction ('zssm_getworkstepandwarehouse');
CREATE OR REPLACE FUNCTION zssm_getworkstepandwarehouse(p_productid IN varchar,p_warehouse OUT varchar,p_planid OUT varchar) RETURNS RECORD
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours


*****************************************************/
p_workstepid varchar;
v_wsname varchar;
BEGIN
    select c_projecttask_id,zssm_productionplan_v_id into p_workstepid,p_planid from zssm_productionplan_task_v 
                                                         where m_product_id=p_productid and assembly='Y' and isactive='Y' 
                                                         and zssm_productionplan_v_id=zssm_getproductionplanIDofproduct(p_productid);
    if p_workstepid is  null then        
        RAISE exception '%', '@zssm_simulationnotpossibleworkstepundefined@'||zssi_getproductname(p_productid,'de_DE');
    end if;
    select  w.m_warehouse_id,p.value into p_warehouse,v_wsname from c_projecttask p,m_locator w where p.c_projecttask_id=p_workstepid and w.m_locator_id=p.receiving_locator;
    if p_warehouse is null then
        RAISE exception '%', '@zssm_simulationnotpossiblelocatorundefined@'||v_wsname;
    end if;
    RETURN;
END;
$_$  LANGUAGE 'plpgsql';

select zsse_DropFunction('zssm_workhours2workcalendardaybackward');
CREATE OR REPLACE FUNCTION zssm_workhours2workcalendardaybackward(datestart timestamp,v_workhours numeric,v_org varchar,v_precise varchar) RETURNS timestamp
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours


*****************************************************/


v_cur record;
v_hours numeric:=0;
v_datehours numeric:=0;
v_workhoursbegunonstart numeric;
v_begintime timestamp;
BEGIN
    if v_precise='Y' then
        select c_getorgworkbegintime(v_org, trunc(datestart)) into v_begintime;
        v_workhoursbegunonstart:= extract(hour from datestart) - extract(hour from v_begintime);
        if v_workhoursbegunonstart<0 then 
            v_workhoursbegunonstart:=0;
        end if;
        for v_cur in (select worktime,workdate from c_workcalender  where workdate <= datestart order by workdate desc)
        LOOP
            v_datehours:=coalesce(c_getorgworktime(v_org,v_cur.workdate),v_cur.worktime);
            if v_hours+v_datehours >= v_workhours then
            return v_cur.workdate;
            else
            v_hours:=v_hours+v_datehours;
            end if;
        END LOOP;
    end if;
    return datestart-trunc(v_workhours/5.7);
END;
$_$  LANGUAGE 'plpgsql';

select zsse_DropFunction('zssm_workhours2workcalendardayforward');
CREATE OR REPLACE FUNCTION zssm_workhours2workcalendardayforward(datestart timestamp,v_workhours numeric,v_org varchar,v_precise varchar) RETURNS timestamp
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours


*****************************************************/


v_cur record;
v_hours numeric:=0;
v_datehours numeric:=0;
v_workhoursbegunonstart numeric;
v_begintime timestamp;
BEGIN
    if v_precise='Y' then
        select c_getorgworkbegintime(v_org, trunc(datestart)) into v_begintime;
        v_workhoursbegunonstart:= extract(hour from datestart) - extract(hour from v_begintime);
        if v_workhoursbegunonstart<0 then 
            v_workhoursbegunonstart:=0;
        end if;
        for v_cur in (select worktime,workdate from c_workcalender  where workdate >= datestart order by workdate)
        LOOP
            v_datehours:=coalesce(c_getorgworktime(v_org,v_cur.workdate),v_cur.worktime);
            if v_hours+v_datehours >= v_workhours then
            return v_cur.workdate;
            else
            v_hours:=v_hours+v_datehours;
            end if;
        END LOOP;
    end if;
    return datestart-trunc(v_workhours/5.7);
END;
$_$  LANGUAGE 'plpgsql';


select zsse_DropFunction ('zssm_getassemblyproductionworkhours');
CREATE OR REPLACE FUNCTION zssm_getassemblyproductionworkhours(dateneeded timestamp,p_productid varchar,v_qty numeric,v_org varchar,v_precise varchar) RETURNS numeric
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly.

Calculates working - hours, Returns Timestamp to start

DO NOT USE IF YOU ARE NOT SHURE THAT A CORRECT PRODUCT, That has a valid Production Plan is Supplied

*****************************************************/

v_tp numeric:=0; -- Time Production (Gesamtzeit Kompletter Durchlauf)
v_trz numeric; -- Setuptime (Rüstzeit)
v_tst numeric; -- Time per Piece (Stückzeit)
v_tpvl  numeric:=0; --Time Production (Iterationsschritt)
v_plan varchar;
v_org varchar;
v_wh varchar;
v_cur record;
v_count numeric;
v_EstStock numeric;
v_pleadtime numeric:=0; -- Purchase Time (Global)
v_gleadtime numeric:=0; --  Purchase Time Temp Table
v_tpvlt numeric; -- Purchase Time (Local) or BOM Production Time (Local BOM)
BEGIN
    --raise notice '%','----------------------------------------------------------------------------------Calculating Product:'||zssi_getproductname(p_productid,'de_DE')||' - Qty:'||v_qty;
    -- TODO: Get a valid Plan for the desired Organization.
    -- At the moment, the first valid default plan is taken
    select a.p_warehouse,a.p_planid,p.setuptime/60,p.timeperpiece/60,p.ad_org_id 
           into v_wh,v_plan,v_trz,v_tst,v_org
           from zssm_getworkstepandwarehouse(p_productid) a,c_project p where a.p_planid=p.c_project_id;
    --if mrp_estimated_stockqty(p_productid,v_wh,trunc(dateneeded))>=v_qty then
    --        return now();
    --end if;
    -- time formula (in hours)
    v_tp:=(v_trz+v_qty*v_tst+v_tpvl);
    if v_plan is null then
     raise exception '%','No Production Plan found for Product: '||zssi_getproductname(p_productid,'de_DE');
    end if;
    --raise notice '%','TPstart:'||v_tp||'-Plan:'||v_plan;
    -- Loop through BOM
    for v_cur in (select b.m_product_id,sum(b.quantity) as quantity,p.production from zspm_projecttaskbom b,m_product p where b.m_product_id=p.m_product_id and b.c_projecttask_id in  
                         (select c_projecttask_id from zssm_productionplan_task_v where zssm_productionplan_v_id=v_plan and assembly='Y')
                         group by b.m_product_id,p.production order by p.production desc)
    LOOP
        -- On Hand?
        v_EstStock:=mrp_estimated_stockqty(v_cur.m_product_id,v_wh, trunc(zssm_workhours2workcalendardaybackward(dateneeded,v_tp,v_org,v_precise)));
        --raise notice '%','in BOM - P:'||v_cur.production||' Prod:'||zssi_getproductname(v_cur.m_product_id,'de_DE')||' Stock:'||v_EstStock||' Need:'||v_cur.quantity*v_qty||' Date:'||dateneeded;
        if v_EstStock<v_cur.quantity*v_qty then
            if v_cur.production='N' then
                -- Purchasing (best Quality)
                SELECT coalesce(deliverytime_promised,1)*8 into v_tpvlt FROM M_PRODUCT_PO po
                                                                    WHERE po.m_product_id=v_cur.M_Product_ID and PO.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',v_org)
                                                                    ORDER BY COALESCE(po.qualityrating,0) DESC, updated DESC LIMIT 1;
                /*
                if zssm_workhours2workcalendardaybackward(dateneeded,v_tp+v_tpvlt,v_org,v_precise)< to_timestamp(now()) then
                    -- Purchasing (Quickest)
                    SELECT coalesce(deliverytime_promised,1)*8 into v_tpvlt FROM M_PRODUCT_PO po
                                                                    WHERE po.m_product_id=v_cur.M_Product_ID and PO.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',v_org)
                                                                    ORDER BY COALESCE(po.deliverytime_promised,1) DESC, updated DESC LIMIT 1;
                end if;
                */
                if v_tpvlt is null then
                    RAISE EXCEPTION '%','@zssm_nopurchasedefined4product@'||zssi_getproductname(v_cur.m_product_id,'de_DE');
                end if;
                --raise notice '%','PurchseTime:'||v_tpvlt;
                --if v_pleadtime < v_tpvlt then 
                    --v_pleadtime:=v_tpvlt; 
                    --v_tpvlt:=v_tpvlt-v_pleadtime;
                    --v_pleadtime:=v_pleadtime+v_tpvlt;
                    select leadtime into v_gleadtime from calcu limit 1;
                    if v_gleadtime is not null then
                        if v_gleadtime < v_tpvlt then
                            delete from calcu;
                            insert into calcu (leadtime) values (v_tpvlt);
                            v_pleadtime:=v_tpvlt;
                        else
                            v_pleadtime:=0;
                        end if;
                    end if;
                    --raise notice '%', 'Add PURCHASE LeadTime:'||v_tpvlt||'---------------------------------------------------------Purchase Lead Time is now:'||v_pleadtime;  
              -- else
                   -- v_tpvlt:=0;
               -- end if;
            else
                -- Produced in same plan?
                select count(*) into v_count from zssm_productionplan_task_v where zssm_productionplan_v_id=v_plan and assembly='Y' and m_product_id=v_cur.m_product_id;
                if v_count=0 then
                    -- Production in another Plan - Call me Recursive
                    v_tpvlt:=zssm_getassemblyproductionworkhours(zssm_workhours2workcalendardaybackward(dateneeded,v_tp,v_org,v_precise),v_cur.m_product_id,v_cur.quantity*v_qty-v_EstStock,v_org,v_precise);
                    --raise notice '%','-----------------'||zssi_getproductname(p_productid,'de_DE')||'PrOductiontime -------------------------------------------ITERATION:'||v_tpvlt;
                else
                    v_tpvlt:=0;
                end if;
            end if;
            if v_tpvl<v_tpvlt then
                    v_tpvl:=v_tpvlt;
            end if;
            v_tp:=(v_trz+v_qty*v_tst+v_tpvl);
        end if; --On Hand
    END LOOP;
   -- raise notice '%','SUM of TIMES:'||v_tp+v_pleadtime;
    RETURN v_tp+v_pleadtime;
END;
$_$  LANGUAGE 'plpgsql';

select zsse_DropFunction('zssm_getFastestProductionDoneDate');

CREATE OR REPLACE FUNCTION zssm_getFastestProductionDoneDate(p_productid varchar,p_qty numeric,p_org varchar) RETURNS timestamp
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours

DO NOT USE IF YOU ARE NOT SHURE THAT A CORRECT PRODUCT, That has a valid Production Plan is Supplied

*****************************************************/

v_beginproductiondate timestamp;
v_estdeliverydate timestamp;
v_days interval;
v_wh varchar;
v_qty numeric;
v_count numeric;
v_cur record;
BEGIN
        v_qty:=p_qty;
        v_beginproductiondate:=now()-1;
        v_estdeliverydate:=trunc(now());
        WHILE v_beginproductiondate<trunc(now())
        LOOP            
            v_beginproductiondate:=zssm_getlatestproductionstart(p_productid,v_qty,v_estdeliverydate,p_org);
            v_estdeliverydate:=v_estdeliverydate+1;
        END LOOP;
       -- v_days:=to_timestamp(now())-v_estdeliverydate;
       -- RETURN to_timestamp(now()) + v_days;
       RETURN v_estdeliverydate;
END;
$_$  LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION zssm_getfastestdeliverydate(p_productid varchar,p_qty numeric,p_warehouse varchar) RETURNS timestamp
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours


*****************************************************/

v_estdeliverydate timestamp;
v_count numeric;
v_org varchar;
BEGIN
        --perform logg(p_productid||'--WH--'||p_warehouse||'--QTY--'||coalesce(p_qty,0));
        select ad_org_id into v_org from m_warehouse where m_warehouse_id=p_warehouse;
        -- 1.st test Stock QTY
        if M_BOM_Qty_Available(p_productid,p_warehouse,null)>=p_qty then
            return trunc(now());
        end if;
        -- 2. Test Planned Movements
        select min(stockdate) into v_estdeliverydate from mrp_inoutplanbase where m_product_id=p_productid and m_warehouse_id=p_warehouse and estimated_stock_qty >= p_qty;
        -- If there is a date with desired qty, test if any transaction later requires a qty that under-runs needed qty
        if v_estdeliverydate is not null then
            select count(*) into v_count from mrp_inoutplanbase where m_product_id=p_productid and m_warehouse_id=p_warehouse and estimated_stock_qty < p_qty and stockdate>=v_estdeliverydate;
            if v_count=0 then
                return v_estdeliverydate;
            end if;
        end if;
        -- 3. Production?
        if zssm_getproductionplanIDofproduct(p_productid)!='' then
           v_estdeliverydate := zssm_getFastestProductionDoneDate(p_productid,p_qty,v_org);
           return v_estdeliverydate;
        else
            -- OR Buy Product
            if length(mrp_getsheddeliverydate4vendorProduct(null,p_productid,v_org))>0 then
                return to_timestamp(to_timestamp(mrp_getsheddeliverydate4vendorProduct(null,p_productid,v_org),'DD-MM-YYYY'));
            end if;
        end if;
        return null;
END;
$_$  LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION zssm_getfastestdeliverydate(p_productid varchar,p_qty varchar,p_warehouse varchar) RETURNS timestamp
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours


*****************************************************/

v_qty numeric;
BEGIN
    v_qty:=to_number(p_qty);
    RETURN zssm_getfastestdeliverydate(p_productid,v_qty,p_warehouse) ;
END;
$_$  LANGUAGE 'plpgsql';


select zsse_dropfunction('zssm_getlatestproductionstart');
CREATE OR REPLACE FUNCTION zssm_getlatestproductionstart(p_productid varchar,p_qty numeric,deliverydate timestamp,p_org varchar) RETURNS timestamp
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours

DO NOT USE IF YOU ARE NOT SHURE THAT A CORRECT PRODUCT, That has a valid Production Plan is Supplied

*****************************************************/


v_cur record;
v_hours numeric:=-1;
v_hourstest numeric:=0;
v_wh varchar;
v_startdate timestamp;
BEGIN
    perform zsse_droptable ('calcu');
    create temporary table calcu(
    leadtime  numeric  not null
    )  ON COMMIT DROP;
    --truncate table calcu;
    -- Test as if today delivery
    v_hourstest:=zssm_getassemblyproductionworkhours(deliverydate,p_productid,p_qty,p_org,'Y');
    --v_startdate:=deliverydate;
    -- The calculation was correct, when the new hours are not more than the old ones...
    --WHILE v_hours<v_hourstest
    --LOOP
    --    v_hours:=v_hourstest;
        -- get the real start Date from the hours calculated
        v_startdate:=zssm_workhours2workcalendardaybackward(deliverydate,v_hourstest,p_org,'Y');
    --    v_hourstest:=zssm_getassemblyproductionworkhours(v_startdate,p_productid,p_qty,0);
        -- The calculation was correct, when the new hours are not more than the old ones...
    --END LOOP;
    RETURN v_startdate;
END;
$_$  LANGUAGE 'plpgsql';

select zsse_dropfunction('zssm_getquickestproductionstart');
CREATE OR REPLACE FUNCTION zssm_getquickestproductionstart(p_productid varchar,p_qty numeric,p_org varchar) RETURNS timestamp
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours

DO NOT USE IF YOU ARE NOT SHURE THAT A CORRECT PRODUCT, That has a valid Production Plan is Supplied

*****************************************************/
v_fastestdeliverydate timestamp;
v_startdate timestamp;
v_qty numeric;
BEGIN
    if p_productid is null then 
          return null;
    end if;
    v_qty:=p_qty;
    v_fastestdeliverydate:=zssm_getFastestProductionDoneDate(p_productid,v_qty,p_org);
    v_startdate:=zssm_getlatestproductionstart(p_productid,v_qty,v_fastestdeliverydate,p_org );
    RETURN v_startdate;
END;
$_$  LANGUAGE 'plpgsql';



select zsse_DropFunction('zssm_getlatestproductionstartWoRecursion');
CREATE OR REPLACE FUNCTION zssm_getlatestproductionstartWoRecursion(p_productid varchar,p_qty numeric,deliverydate timestamp,p_org varchar) RETURNS timestamp
AS $_$
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@openz.de)
First Published in 2013.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Manufactring. 

Computes the Time you need to produce an assembly in working - hours

DO NOT USE IF YOU ARE NOT SHURE THAT A CORRECT PRODUCT, That has a valid Production Plan is Supplied

*****************************************************/


v_cur record;
v_hours numeric:=0;
v_hourstest numeric:=0;
v_wh varchar;
v_startdate timestamp;
v_trz numeric;
v_tst numeric;
BEGIN
    select p.setuptime/60,p.timeperpiece/60
           into v_trz,v_tst
           from zssm_getworkstepandwarehouse(p_productid) a,c_project p where a.p_planid=p.c_project_id;
    -- time formula (in hours)
    v_hourstest:=(v_trz+p_qty*v_tst);
    v_startdate:=zssm_workhours2workcalendardaybackward(deliverydate,v_hourstest,p_org,'Y');
    RETURN v_startdate;
END;
$_$  LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION zssm_getpruncausetext(p_orderline_id varchar,p_projecttask_id varchar) RETURNS varchar
AS $_$
DECLARE 
v_tasktext varchar:='';
v_ordertext varchar:='';
BEGIN
    if p_projecttask_id is not null then
        select case when coalesce(triggerreason,'')!='' then coalesce(triggerreason,'')||'-'||coalesce(name,'') else coalesce(triggerreason,'')||coalesce(name,'') end into v_tasktext from c_projecttask where c_projecttask_id=p_projecttask_id;
    end if;
    if p_orderline_id is not null then
        select 'Order:'||documentno into v_ordertext from c_order where c_order_id=(select c_order_id from c_orderline where c_orderline_id=p_orderline_id);
    end if;
    RETURN substr(v_ordertext||v_tasktext,1,2000);
END;
$_$  LANGUAGE 'plpgsql';



CREATE OR REPLACE FUNCTION zssm_updateproductionrequired()
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
BEGIN
    -- Call the Proc
    delete from  zssm_productionrequireddates;
    insert into zssm_productionrequireddates select v.zssm_productionrequired_v_id, 
           zssm_getlatestproductionstart(v.m_product_id,v.movementqty,v.needbydate,v.ad_org_id) as dependentstartdate
    from zssm_productionrequired_v v;
    RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
CREATE OR REPLACE FUNCTION zssm_updateproductionrequired(p_pinstance_id character varying)
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
v_message character varying:='OK';
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    -- Call the Proc
    PERFORM zssm_updateproductionrequired();
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

SELECT zsse_droptrigger('zssm_manualproduction_trg', 'zssm_manualproduction');

CREATE OR REPLACE FUNCTION zssm_manualproduction_trg() RETURNS trigger AS
$body$
 DECLARE 
 v_production numeric;
 v_qty numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
    new.lateststartdate:=zssm_getquickestproductionstart(new.m_product_id,new.qty,new.ad_org_id);
    new.planneddate:=zssm_getFastestProductionDoneDate(new.m_product_id,new.qty,new.ad_org_id);
    insert into zssm_productionrequireddates (zssm_productionrequired_v_id,dependentstartdate) 
    values (new.zssm_manualproduction_id,zssm_getlatestproductionstart(new.m_product_id,new.qty,new.planneddate,new.ad_org_id));
  IF (TG_OP = 'DELETE') THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END ;
$body$
LANGUAGE 'plpgsql';


CREATE TRIGGER zssm_manualproduction_trg
  BEFORE INSERT
  ON zssm_manualproduction FOR EACH ROW
  EXECUTE PROCEDURE zssm_manualproduction_trg();


select zsse_DropFunction('zssm_DoesProductHaveValidPlanRecursive');  
CREATE or replace FUNCTION zssm_DoesProductHaveValidPlanRecursive(pzssm_productionplan_v_id OUT character varying,pcause OUT varchar,pm_product_id OUT varchar) returns SETOF RECORD
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
*****************************************************/
v_cur record;
v_count numeric;
BEGIN
    for v_cur in (select null as zssm_unproducableitems_v_id,'Product has no valid Plan' as cause,p.m_product_id
                       from m_product p where p.production='Y' and p.isactive='Y' and 
                       not exists (select 0 from zssm_productionplan_task_v tv,c_project pr where pr.c_project_id=tv.zssm_productionplan_v_id
                        and tv.m_product_id=p.m_product_id and tv.assembly='Y' and tv.isactive='Y' 
                        and pr.isactive='Y' and pr.projectstatus='OR' and pr.projectcategory = 'PRP'))
    loop
        pzssm_productionplan_v_id:=v_cur.zssm_unproducableitems_v_id;
        pcause:=v_cur.cause;
        pm_product_id:=v_cur.m_product_id;
        RETURN NEXT;
    end loop;
    for v_cur in (select tv.m_product_id,tv.timeperpiece+tv.setuptime as timeplanned,tv.zssm_productionplan_v_id, tv.issuing_locator as ptil,tv.receiving_locator as ptrl
                         from zssm_productionplan_task_v tv where
                         tv.issuing_locator is null or tv.receiving_locator is null or tv.timeperpiece+tv.setuptime =0)
    loop
         pzssm_productionplan_v_id:=v_cur.zssm_productionplan_v_id;
         pm_product_id:=v_cur.m_product_id;
        if v_cur.ptil is null or v_cur.ptrl is null then
            pcause:='Workstep has no locator defined';
        end if;
        if v_cur.timeplanned=0 then
            pcause:='Workstep does not have a production time defined';
        end if;
        RETURN NEXT;
    end loop;
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
   
   
select zsse_DropView ('zssm_unproducableitems_v');
CREATE OR REPLACE VIEW zssm_unproducableitems_v AS
SELECT
  p.ad_org_id,
  p.ad_client_id,
  p.updated,
  p.updatedby,
  p.created,
  p.createdby,
  'Y'::character as isactive,
  p.m_product_id as zssm_unproducableitems_v_id,
  p.m_product_id,
  vx.pzssm_productionplan_v_id  as zssm_productionplan_v_id,
  vx.pcause as cause
FROM m_product p,zssm_DoesProductHaveValidPlanRecursive() vx where vx.pm_product_id=p.m_product_id;





-- Not Avoidable cross-script dependency to mrp.sql. AND Serialproduction.sql
-- mrp_inoutplan_v_id is in MRP.sql
-- After Running MRP.sql or serialproduction.sql this Script has to be run!
select zsse_DropView ('zssm_productionrequired_v');
CREATE OR REPLACE VIEW zssm_productionrequired_v AS
SELECT a.ad_org_id,a.ad_client_id,a.updated,a.updatedby,a.created,a.createdby,'Y'::text as isactive,
       a.zssm_productionrequired_v_id,a.m_product_id,a.value, a.pname,a.needbydate,a.lateststartdate,t.dependentstartdate,a.requiredqty,a.cause ,a.currOnhandQty,a.movementqty,a.causetext
FROM
(SELECT
  v.ad_org_id,
  v.ad_client_id,
  v.updated,
  v.updatedby,
  v.created,
  v.createdby,
  v.zssm_manualproduction_id as zssm_productionrequired_v_id,
  v.m_product_id,
  p.value,
  m_bom_qty_onhand(v.m_product_id, v.m_warehouse_id,null) as currOnhandQty,
  v.qty as movementqty,
  p.value||'-'||zssi_getproductname(v.m_product_id,'de_DE') as pname,
  v.planneddate as needbydate,
  v.lateststartdate,
  v.qty as requiredqty,
  'MANUAL' as cause ,
  'MANUAL' as causetext
FROM zssm_manualproduction v
     , m_product p 
where p.m_product_id=v.m_product_id and p.isactive='Y' and p.production='Y' 
      and not exists (select 0 from zssm_unproducableitems_v where m_product_id=p.m_product_id)
UNION
SELECT
  v.ad_org_id,
  v.ad_client_id,
  v.updated,
  v.updatedby,
  v.created,
  v.createdby,
  v.mrp_inoutplan_v_id as zssm_productionrequired_v_id,
  v.m_product_id,
  p.value,
  m_bom_qty_onhand(v.m_product_id, v.m_warehouse_id,null) as currOnhandQty,
  v.movementqty*(-1) as movementqty,
  p.value||'-'||zssi_getproductname(v.m_product_id,'de_DE') as pname,
  v.planneddate as needbydate,
  zssm_getlatestproductionstartWoRecursion(v.m_product_id,v.estimated_stock_qty*(-1),v.planneddate,v.ad_org_id) as lateststartdate,
  v.estimated_stock_qty*(-1)  as requiredqty,
  zssi_getorderlinelink(v.c_orderline_id)||zssi_getptasklink(v.c_projecttask_id) as cause ,
  zssm_getpruncausetext(v.c_orderline_id,v.c_projecttask_id) as causetext
FROM mrp_inoutplan_v v LEFT JOIN M_PRODUCT_ORG po ON v.M_PRODUCT_ID = po.M_PRODUCT_ID and v.ad_org_id=po.ad_org_id
     , m_product p 
where p.m_product_id=v.m_product_id and p.isactive='Y' and p.production='Y' and v.estimated_stock_qty<0
      --and zssm_getproductionplanIDofproduct(p.m_product_id)=pr.c_project_id and pr.isautotriggered='N'
      and not exists (select 0 from zssm_unproducableitems_v where m_product_id=p.m_product_id)
UNION
SELECT
  po.ad_org_id,
  po.ad_client_id,
  po.updated,
  po.updatedby,
  po.created,
  po.createdby,
  po.M_PRODUCT_ORG_id as zssm_productionrequired_v_id,
  po.m_product_id,
  p.value,
  m_bom_qty_onhand(po.m_product_id, (select m_warehouse_id from m_locator where m_locator_id=po.m_locator_id),null) as currOnhandQty,
  m_bom_qty_onhand(po.m_product_id, null, po.m_locator_id)*(-1)+coalesce(po.qtyoptimal,coalesce(po.STOCKMIN,0)) as movementqty,
  p.value||'-'||zssi_getproductname(po.m_product_id,'de_DE') as pname,
  zssm_getFastestProductionDoneDate(po.m_product_id,m_bom_qty_onhand(po.m_product_id, null, po.m_locator_id)*(-1)+coalesce(po.qtyoptimal,coalesce(po.STOCKMIN,0)),po.ad_org_id) as needbydate,
  zssm_getlatestproductionstartWoRecursion(po.m_product_id,m_bom_qty_onhand(po.m_product_id, null, po.m_locator_id)*(-1)+coalesce(po.qtyoptimal,coalesce(po.STOCKMIN,0)),
                                zssm_getFastestProductionDoneDate(po.m_product_id,m_bom_qty_onhand(po.m_product_id, null, po.m_locator_id)*(-1)+coalesce(po.qtyoptimal,coalesce(po.STOCKMIN,0)),po.ad_org_id),po.ad_org_id) as lateststartdate,
  m_bom_qty_onhand(po.m_product_id, null, po.m_locator_id)*(-1)+coalesce(po.qtyoptimal,coalesce(po.qtyoptimal,coalesce(po.STOCKMIN,0))) as requiredqty,
  'STOCKMIN'  as cause ,
  'STOCKMIN'  as causetext 
FROM M_PRODUCT_ORG po,m_product p  where p.m_product_id=po.m_product_id 
                      and not exists (select 0 from mrp_inoutplan_v v where v.m_product_id=po.m_product_id and v.estimated_stock_qty<0) 
                      and not exists (select 0 from mrp_inoutplan_v v where v.m_product_id=po.m_product_id and v.estimated_stock_qty>=m_bom_qty_onhand(po.m_product_id, null, po.m_locator_id)*(-1)+coalesce(po.qtyoptimal,coalesce(po.STOCKMIN,0))) 
                      and not exists (select 0 from zssm_unproducableitems_v where m_product_id=p.m_product_id)
                      and m_bom_qty_onhand(po.m_product_id, null, po.m_locator_id)-coalesce(po.STOCKMIN,0)<0
                      and p.isactive='Y' and p.production='Y') A 
left join zssm_productionrequireddates t on t.zssm_productionrequired_v_id=a.zssm_productionrequired_v_id
order by causetext,needbydate;
                     



CREATE OR REPLACE FUNCTION zssm_productionrun(p_pinstance_id character varying)
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
v_Org   character varying;
v_ProductionPlan_id varchar;
v_ProductionOrder_id    VARCHAR; 
v_sequence VARCHAR;
v_ProductionOrderValue VARCHAR;
v_ProductionOrderName VARCHAR;
v_isauto varchar;
v_startdate timestamp;
v_enddate timestamp;
v_cur RECORD;
BEGIN
    if p_PInstance_ID is null then
        return;
    end if;
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_org_id into v_Record_ID, v_User,v_Org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       select createdby,ad_org_id into v_user,v_org from zssm_productionrun where c_project_id is null limit 1;
    end if;
    for v_cur in (select * from zssm_productionrun where c_project_id is null and pinstance=p_pinstance_id and requiredqty>0 and c_project_id is null for update)
    LOOP
         -- Start Date
         v_startdate:=v_cur.needbydate;
         v_enddate:=v_cur.enddate;
         --zssm_getlatestproductionstart(v_cur.m_product_id,v_cur.requiredqty,v_cur.needbydate);
         -- Select PLAN to execute
         v_ProductionOrder_id := get_uuid();
         v_ProductionPlan_id:=zssm_getproductionplanIDofproduct(v_cur.m_product_id);
         -- Create Name and Value Automatically 
         v_sequence:= Ad_Sequence_Doc('DocumentNo_C_Project', v_org,'Y');
         select value,name into v_ProductionOrderValue,v_ProductionOrderName from  c_project where c_project_id=v_ProductionPlan_id;
         v_ProductionOrderValue:=substr(v_ProductionOrderValue,1,40-length(v_sequence))||v_sequence;
         -- Create Production ORDER
         v_message := v_message || (SELECT zssm_Copy_ProductionPlan2Project (v_ProductionPlan_id, v_ProductionOrder_id, v_ProductionOrderValue, v_ProductionOrderName, v_startdate,v_cur.requiredqty, v_User, v_cur.m_product_id)); -- 
         v_message := v_message || '</br>' || zsse_htmldirectlinkWithDummyField('../org.openbravo.zsoft.serprod.ProductionOrder/ProductionOrderCF6D6BC0255A47DFBD4FF6F8BEBA0C71_Relation.html','inpzssmProductionorderVId',v_ProductionOrder_id,v_ProductionOrderName)|| '</br>';
         update zssm_productionrun set c_project_id= v_ProductionOrder_id where zssm_productionrun_id=v_cur.zssm_productionrun_id;
         update c_projecttask set triggerreason=v_cur.cause where c_project_id= v_ProductionOrder_id;
         update c_projecttask set startdate=null where startdate<v_startdate and c_project_id= v_ProductionOrder_id;
         update c_projecttask set enddate=null where  enddate>v_enddate and c_project_id= v_ProductionOrder_id;
         update c_project set datefinish=v_enddate, startdate=v_startdate,description=substr(v_cur.cause||coalesce(description,''),1,2000) where c_project_id= v_ProductionOrder_id;
         update c_projecttask set startdate=v_startdate where startdate is null and c_project_id= v_ProductionOrder_id;
         update c_projecttask set enddate=v_enddate where  enddate is null and c_project_id= v_ProductionOrder_id;
         PERFORM zspm_beginproject(v_ProductionOrder_id);
         perform mrp_inoutplanupdate('Y');
    END LOOP;
    
    -- Iterate for auto-triggered Production Orders
    for v_cur in (select  v.m_product_id,v.estimated_stock_qty*(-1)  as requiredqty,v.planneddate as needbydate,
                  zssm_getpruncausetext(v.c_orderline_id,v.c_projecttask_id) as causetext
                  FROM mrp_inoutplan_v v , m_product p 
                  where p.m_product_id=v.m_product_id and p.isactive='Y' and p.production='Y' and v.estimated_stock_qty<0
                  )
    LOOP
            select isautotriggered into v_isauto from c_project where c_project_id=zssm_getproductionplanIDofproduct(v_cur.m_product_id);
            if v_isauto='Y' then
                v_startdate:=zssm_getlatestproductionstartWoRecursion(v_cur.m_product_id,v_cur.requiredqty,v_cur.needbydate,v_org);
                insert into zssm_productionrun(zssm_productionrun_id,ad_client_id,ad_org_id,createdby, updatedby,
                            requiredqty,needbydate,m_product_id, isautotriggered,pinstance,cause,enddate)
                    VALUES (get_uuid(),'C726FEC915A54A0995C568555DA5BB3C',v_Org,v_user,v_user,
                            v_cur.requiredqty,v_startdate,v_cur.m_product_id,'Y',p_pinstance_id,v_cur.CAUSETEXT,v_cur.needbydate);
                PERFORM  zssm_productionrun(p_pinstance_id);  
                EXIT;
            end if;
    END LOOP;
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1 , v_Message) ;
    perform mrp_inoutplanupdate('');
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

  
  
CREATE or replace FUNCTION snr_getassembly_snr(p_projecttask character varying) RETURNS character varying
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
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_conid character varying;
BEGIN
      select snr.serialnumber into v_return from snr_internal_consumptionline snr,m_internal_consumptionline ml,m_internal_consumption m
             where ml.c_projecttask_id=p_projecttask 
                   and snr.m_internal_consumptionline_id=ml.m_internal_consumptionline_id and m.m_internal_consumption_id=ml.m_internal_consumption_id
                   and m.movementtype='P+' and m.processed='Y';
RETURN coalesce(v_return,'');
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;

CREATE or replace FUNCTION snr_getassembly_productid(p_task character varying) RETURNS character varying
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
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select m_product_id into v_return from c_projecttask where c_projecttask_id=p_task;
RETURN coalesce(v_return,'');
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;


select zsse_DropView ('snr_serialnumbertracking');
CREATE OR REPLACE VIEW snr_serialnumbertracking AS 
 SELECT snr.snr_masterdata_id,snr.snr_batchmasterdata_id,snr.snr_minoutline_id AS snr_serialnumbertracking_id, snr.ad_client_id, snr.ad_org_id, 'Y' as isactive,snr.created, snr.createdby, snr.updated, snr.updatedby, 
        snr.Guaranteedays,snr.Lotnumber,snr.Rfidnumber,
        mol.m_inoutline_id, null as m_internal_consumptionline_id, null as m_inventoryline_id, null as m_movementline_id, mo.m_inout_id, null as m_internal_consumption_id, null as m_inventory_id, null as m_movement_id,
        mo.c_bpartner_id, mo.movementtype, mol.c_orderline_id, mol.m_product_id, mol.m_attributesetinstance_id, mo.movementdate,  snr.guaranteedate, snr.serialnumber,snr.description,
        ol.c_project_id,ol.a_asset_id,ol.c_projecttask_id,mol.m_locator_id,snr.quantity, mo.docstatus,null as assembly_snr,null as assembly_productid
   FROM m_inout mo, snr_minoutline snr, m_inoutline mol left join c_orderline ol on mol.c_orderline_id=ol.c_orderline_id::text
  WHERE snr.m_inoutline_id::text = mol.m_inoutline_id::text AND mol.m_inout_id::text = mo.m_inout_id::text AND mo.processed::text='Y'
union
 SELECT snr.snr_masterdata_id,snr.snr_batchmasterdata_id,snr.snr_internal_consumptionline_id AS snr_serialnumbertracking_id, snr.ad_client_id, snr.ad_org_id, 'Y' as isactive, snr.created, snr.createdby, snr.updated, snr.updatedby, 
        snr.Guaranteedays,snr.Lotnumber,snr.Rfidnumber,
        null as m_inoutline_id, mol.m_internal_consumptionline_id, null as m_inventoryline_id, null as m_movementline_id,null as m_inout_id, mo.m_internal_consumption_id, null as m_inventory_id, null as m_movement_id,
        null as c_bpartner_id, mo.movementtype, null as c_orderline_id, mol.m_product_id, mol.m_attributesetinstance_id, mo.movementdate,  snr.guaranteedate, snr.serialnumber,snr.description,
        mol.c_project_id,mol.a_asset_id,mol.c_projecttask_id,mol.m_locator_id,snr.quantity, 'CO' as docstatus,snr_getassembly_snr(mol.c_projecttask_id) as assembly_snr,snr_getassembly_productid(mol.c_projecttask_id) as assembly_productid
   FROM m_internal_consumption mo, m_internal_consumptionline mol, snr_internal_consumptionline snr
  WHERE snr.m_internal_consumptionline_id::text = mol.m_internal_consumptionline_id::text AND mol.m_internal_consumption_id::text = mo.m_internal_consumption_id::text  AND mo.processed::text='Y'
union
 SELECT snr.snr_masterdata_id,snr.snr_batchmasterdata_id,snr.snr_inventoryline_id AS snr_serialnumbertracking_id, snr.ad_client_id, snr.ad_org_id, 'Y' as isactive, snr.created, snr.createdby, snr.updated, snr.updatedby, 
        snr.Guaranteedays,snr.Lotnumber,snr.Rfidnumber,
        null as m_inoutline_id, null as m_internal_consumptionline_id, mol.m_inventoryline_id, null as m_movementline_id,null as m_inout_id, null as m_internal_consumption_id, mo.m_inventory_id, null as m_movement_id,
        null as c_bpartner_id, 'I+' as movementtype, null as c_orderline_id, mol.m_product_id, mol.m_attributesetinstance_id, mo.movementdate,  snr.guaranteedate, snr.serialnumber,snr.description,
        null as c_project_id,null as a_asset_id,null as c_projecttask_id,mol.m_locator_id,snr.quantity, 'CO' as docstatus,null as assembly_snr,null as assembly_productid
   FROM m_inventory mo, m_inventoryline mol, snr_inventoryline snr
  WHERE snr.m_inventoryline_id::text = mol.m_inventoryline_id::text AND mol.m_inventory_id::text = mo.m_inventory_id::text  AND mo.processed::text='Y'
union
 SELECT snr.snr_masterdata_id,snr.snr_batchmasterdata_id,snr.snr_movementline_id AS snr_serialnumbertracking_id, snr.ad_client_id, snr.ad_org_id, 'Y' as isactive, snr.created, snr.createdby, snr.updated, snr.updatedby, 
        snr.Guaranteedays,snr.Lotnumber,snr.Rfidnumber,
        null as m_inoutline_id, null as m_internal_consumptionline_id, null as m_inventoryline_id, mol.m_movementline_id,null as m_inout_id, null as m_internal_consumption_id, null as m_inventory_id, mo.m_movement_id,
        null as c_bpartner_id,'M+' as movementtype, null as c_orderline_id, mol.m_product_id, mol.m_attributesetinstance_id, mo.movementdate,  snr.guaranteedate, snr.serialnumber,snr.description,
        null as c_project_id,null as a_asset_id,null as c_projecttask_id,mol.m_locatorto_id as m_locator_id,snr.quantity, 'CO' as docstatus,null as assembly_snr,null as assembly_productid
   FROM m_movement mo, m_movementline mol, snr_movementline snr
  WHERE snr.m_movementline_id::text = mol.m_movementline_id::text AND mol.m_movement_id::text = mo.m_movement_id::text  AND mo.processed::text='Y';




CREATE OR REPLACE FUNCTION snr_checkline(p_table character varying,p_id character varying) returns character varying
AS
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

***************************************************************************************************/
v_sql character varying;
TYPE_Ref REFCURSOR;
v_cursor TYPE_Ref%TYPE;
v_cur RECORD;

v_isserial character varying;
v_isbatch character varying;
v_count numeric:=0;
v_qty numeric;
v_double numeric;
v_product character varying;
v_movtype  character varying;
v_locator  character varying;
v_exists numeric;
BEGIN
    if p_table='inventoryline' then
        select 'IVT',qtycount,m_product_id into v_movtype,v_qty,v_product from m_inventoryline where m_inventoryline_id=p_id;
        select count(*) into v_double from snr_inventoryline  where m_inventoryline_id=p_id and serialnumber is not null group by serialnumber having count(*)>1 ;
    elsif p_table='inoutline' then
        select a.movementtype,b.movementqty,b.m_product_id into v_movtype,v_qty,v_product from m_inoutline b,m_inout a where a.m_inout_id=b.m_inout_id and b.m_inoutline_id=p_id;
        select count(*) into v_double from snr_minoutline  where m_inoutline_id=p_id and serialnumber is not null group by serialnumber having count(*)>1 ;
    elsif p_table='internal_consumptionline' then 
        select a.movementtype,b.movementqty,b.m_product_id into v_movtype,v_qty,v_product from m_internal_consumptionline b,m_internal_consumption a where 
               a.m_internal_consumption_id=b.m_internal_consumption_id and b.m_internal_consumptionline_id=p_id;
        select count(*) into v_double from snr_internal_consumptionline  where m_internal_consumptionline_id=p_id and serialnumber is not null group by serialnumber having count(*)>1;
    elsif p_table='movementline' then
         select 'MOV',movementqty,m_product_id into v_movtype,v_qty,v_product from  m_movementline where m_movementline_id=p_id;
         select count(*) into v_double from snr_movementline  where m_movementline_id=p_id and serialnumber is not null group by serialnumber having count(*)>1;
    end if;
    select isserialtracking,isbatchtracking into v_isserial,v_isbatch from m_product where m_product_id=v_product;
    if coalesce(v_isserial,'N')='N' and coalesce(v_isbatch,'N')='N' then 
          return '@snr_producthasnoserialtracking@';
    end if;
   -- Serial Numbers
   if coalesce(v_isserial,'N')='Y' then
        v_sql:='select * from snr_'||case p_table when 'inoutline' then 'minoutline' else p_table end||'  where m_'||p_table||'_id = '||chr(39)||p_id||chr(39);
        OPEN v_cursor FOR EXECUTE v_sql;
        LOOP
            FETCH v_cursor INTO v_cur;
            EXIT WHEN NOT FOUND;
            -- Do checks only if not posted. Post-Process sets while posting masterdata ID through trigger snr_checkpost
            if v_cur.snr_masterdata_id is null and v_cur.snr_batchmasterdata_id is null then
                v_count:=v_count+1;
                if v_cur.quantity!=1 then
                return '@snr_qtymustbe1inserial@';
                end if;
                if   v_cur.serialnumber is null and v_cur.isunavailable='N' then
                    return '@snr_noserialgiven@';
                end if;
                if coalesce(v_isbatch,'N')='N' and   v_cur.lotnumber is not null then
                    return '@snr_producthasnoserialtracking@';
                end if;
                select count(*) into v_exists from snr_masterdata where serialnumber=v_cur.serialnumber and m_product_id=v_product;
                -- New serial Numbers can only brought by metraial receipt -Transactions (+)
                if v_movtype not in ('V+','P+','IVT','MOV','D+','C+','M+','P+','V+','I+') and v_cur.isunavailable='N' then
                    -- Serial Number must be already existing
                    if v_exists=0 then
                        return '@snr_serialdoesntexist@';
                    else
                        select m_locator_id into v_locator from snr_masterdata where m_product_id=v_product and serialnumber=v_cur.serialnumber;
                        -- All Outgoing Transactions must be on Stock
                        if (v_movtype in ('D-','C-','M-','P-','V-')  and v_qty>0) or (v_movtype in ('D+','C+','M+','P+','V+','I+') and v_qty<0) then                  
                            if v_locator is null then
                                return '@snr_serialknownbutnotstocked@'||v_cur.serialnumber||'@snr_cannotusethisserial@';
                            end if;
                        end if;
                    end if;
                else
                    if v_exists>0  then
                        select m_locator_id into v_locator from snr_masterdata where m_product_id=v_product and serialnumber=v_cur.serialnumber;
                        -- All Incoming Transactions must not be already on Stock
                        if (v_movtype in ('D+','C+','M+','P+','V+','I+') and v_qty>0) or (v_movtype in ('D-','C-','M-','P-','V-')  and v_qty<0) then                  
                                if v_locator is not null then
                                    return '@snr_isstocked@'||v_cur.serialnumber||'@snr_cannotstockagain@';
                                end if;
                        end if;
                        if v_movtype in ('P+') and v_qty>0  then                  
                                return '@snr_isproduced@'||v_cur.serialnumber||'@snr_cannotstockagain@';
                        end if;
                    end if;
                end if;
            end if; -- Post-Process Checks
        END LOOP;
        CLOSE v_cursor; 
        if v_count > abs(v_qty) then 
                return '@snr_moreserialthanneeded@'||to_char(abs(v_qty))||'@snr_getnoofserial@';
        end if;
        if v_double>0 then 
                return '@snr_double@';
        end if;
    end if;
    -- Batch(LOT) Numbers
    if coalesce(v_isbatch,'N')='Y' then
        v_count:=0;
        v_sql:='select * from snr_'||case p_table when 'inoutline' then 'minoutline' else p_table end||'  where m_'||p_table||'_id = '||chr(39)||p_id||chr(39);
        OPEN v_cursor FOR EXECUTE v_sql;
        LOOP
            FETCH v_cursor INTO v_cur;
            EXIT WHEN NOT FOUND;
            v_count:=v_count+v_cur.quantity;
            if v_count > abs(v_qty) then 
                return '@snr_morethanbatchneed@'||to_char(abs(v_qty))||'@snr_products2batch@';
            end if;
            if v_cur.lotnumber is null and v_cur.isunavailable='N' then
                return '@snr_nobatchgiven@';
            end if;
            if coalesce(v_isserial,'N')='N' and   v_cur.serialnumber is not null then
                return '@snr_producthasnoserialtracking@';
            end if;
            select count(*) into v_exists from snr_serialnumbertracking where lotnumber=v_cur.lotnumber and m_product_id=v_product;
            if v_movtype not in ('V+','P+','IVT','MOV','D+','C+','M+','P+','V+','I+') and v_cur.isunavailable='N' then
                -- LOT Number must be already existing
                if v_exists=0 then
                    return '@snr_batchdoesntexist@';
                end if;
                -- More than LOT schall be consumed.
                /*
                select onhandqty into v_count from snr_batchmasterdata where batchnumber=v_cur.lotnumber;
                if v_count < abs(v_qty) then 
                    return '@snr_morethanbatthanonhand@';
                end if;
                */
            else 
               -- LOT numbers cannot be serial numbers for the same Product
               select count(*) into v_exists from snr_serialnumbertracking where serialnumber=v_cur.lotnumber and m_product_id=v_product;
               if v_exists!=0 then
                    return '@snr_batchandserialmismatch@';
                end if;
            end if;
        END LOOP;
    end if;
    return 'OK';
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;




CREATE OR REPLACE FUNCTION snr_minoutline_trg()
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
*/
v_processed character varying;
v_return character varying;
BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP != 'DELETE' THEN 
       select processed into v_processed from m_inout where m_inout_id=(select m_inout_id from m_inoutline where m_inoutline_id=new.m_inoutline_id);
       if v_processed='Y' then  
          raise exception '%', '@DocumentProcessed@';
       end if;
       select  snr_checkline('inoutline',new.m_inoutline_id) into v_return;
       if v_return!='OK' then raise exception '%', v_return; end if;
   else
       select processed into v_processed from m_inout where m_inout_id=(select m_inout_id from m_inoutline where m_inoutline_id=old.m_inoutline_id);
       if v_processed='Y' then  
          raise exception '%', '@DocumentProcessed@';
       end if;
   end if;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_minoutline_trg','snr_minoutline');

CREATE TRIGGER snr_minoutline_trg
  AFTER INSERT OR UPDATE OR DELETE
  ON snr_minoutline
  FOR EACH ROW
  EXECUTE PROCEDURE snr_minoutline_trg();
 
  
 
CREATE OR REPLACE FUNCTION snr_internal_consumptionline_trg()
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
*/
v_processed character varying;
v_return character varying;
BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP != 'DELETE' THEN 
       select processed into v_processed from m_internal_consumption where m_internal_consumption_id=(select m_internal_consumption_id from m_internal_consumptionline where m_internal_consumptionline_id=new.m_internal_consumptionline_id);
       if v_processed='Y' then  
          raise exception '%', '@DocumentProcessed@';
       end if;
       select  snr_checkline('internal_consumptionline',new.m_internal_consumptionline_id) into v_return;
       if v_return!='OK' then raise exception '%', v_return; end if;
   else
       select processed into v_processed from m_internal_consumption where m_internal_consumption_id=(select m_internal_consumption_id from m_internal_consumptionline where m_internal_consumptionline_id=old.m_internal_consumptionline_id);
       if v_processed='Y' then  
          raise exception '%', '@DocumentProcessed@';
       end if;
   end if;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_internal_consumptionline_trg','snr_internal_consumptionline');

CREATE TRIGGER snr_internal_consumptionline_trg
  AFTER INSERT OR UPDATE OR DELETE
  ON snr_internal_consumptionline
  FOR EACH ROW
  EXECUTE PROCEDURE snr_internal_consumptionline_trg();
 
CREATE OR REPLACE FUNCTION snr_inventoryline_trg()
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
*/
v_processed character varying;
v_return character varying;
BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP != 'DELETE' THEN 
       select processed into v_processed from m_inventory where m_inventory_id=(select m_inventory_id from m_inventoryline where m_inventoryline_id=new.m_inventoryline_id);
       if v_processed='Y' then  
          raise exception '%', '@DocumentProcessed@';
       end if;
       select   snr_checkline('inventoryline',new.m_inventoryline_id) into v_return;
       if v_return!='OK' then raise exception '%', v_return; end if;
   else
       select processed into v_processed from m_inventory where m_inventory_id=(select m_inventory_id from m_inventoryline where m_inventoryline_id=old.m_inventoryline_id);
       if v_processed='Y' then  
          raise exception '%', '@DocumentProcessed@';
       end if;
   end if;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_inventoryline_trg','snr_inventoryline');

CREATE TRIGGER snr_inventoryline_trg
  AFTER INSERT OR UPDATE OR DELETE
  ON snr_inventoryline
  FOR EACH ROW
  EXECUTE PROCEDURE snr_inventoryline_trg();
 
CREATE OR REPLACE FUNCTION snr_movementline_trg()
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
*/
v_processed character varying;
v_return character varying;
BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP != 'DELETE' THEN 
       select processed into v_processed from m_movement where m_movement_id=(select m_movement_id from m_movementline where m_movementline_id=new.m_movementline_id);
       if v_processed='Y' then  
          raise exception '%', '@DocumentProcessed@';
       end if;
       select  snr_checkline('movementline',new.m_movementline_id) into v_return;
       if v_return!='OK' then raise exception '%', v_return; end if;
   else
       select processed into v_processed from m_movement where m_movement_id=(select m_movement_id from m_movementline where m_movementline_id=old.m_movementline_id);
       if v_processed='Y' then  
          raise exception '%', '@DocumentProcessed@';
       end if;
   end if;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_movementline_trg','snr_movementline');

CREATE TRIGGER snr_movementline_trg
  AFTER INSERT OR UPDATE OR DELETE
  ON snr_movementline
  FOR EACH ROW
  EXECUTE PROCEDURE snr_movementline_trg();

select zsse_dropfunction('snr_initmasterdata');

CREATE OR REPLACE FUNCTION snr_initmasterdata(p_user varchar,p_org varchar,p_snr varchar,p_product varchar,p_batchno  varchar) RETURNS void
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2013 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
v_count numeric;
v_isserial character varying;
v_isbatch character varying;
BEGIN
    select isserialtracking,isbatchtracking into v_isserial,v_isbatch from m_product where m_product_id=p_product;
    select count(*) into v_count  from snr_masterdata where serialnumber=p_snr and m_product_id=p_product;
    if v_count=0 and v_isserial='Y' and p_snr is not null then
       insert into snr_masterdata (snr_masterdata_id,ad_client_id  , ad_org_id , isactive  ,created , createdby , updated, updatedby,
                                   m_product_id  , serialnumber, firstseen, movementdate)
              values(get_uuid(),'C726FEC915A54A0995C568555DA5BB3C'  , p_org , 'Y'  ,now(),p_user, now(),p_user,
                     p_product,p_snr,trunc(now()),now());
    end if;
    select count(*) into v_count  from snr_batchmasterdata where batchnumber=p_batchno and m_product_id=p_product;
    if v_count=0 and v_isbatch='Y' and p_batchno is not null then
       insert into snr_batchmasterdata (snr_batchmasterdata_id,ad_client_id  , ad_org_id , isactive  ,created , createdby , updated, updatedby,
                                   m_product_id  , batchnumber, firstseen)
              values(get_uuid(),'C726FEC915A54A0995C568555DA5BB3C'  , p_org , 'Y'  ,now(),p_user, now(),p_user,
                     p_product,p_batchno,trunc(now()));
    end if;
    return;
END; $_$;




CREATE OR REPLACE FUNCTION snr_checkpost(p_table character varying,p_id character varying) returns void
AS
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

***************************************************************************************************/
v_sql character varying;
TYPE_Ref REFCURSOR;
v_cursor TYPE_Ref%TYPE;
v_cur RECORD;
v_snrcur RECORD;
v_isserial character varying;
v_isbatch character varying;
v_type varchar;
v_mdate timestamp;
v_partner varchar;
v_bploc varchar;
v_count numeric:=0;
v_sercount numeric:=0;
v_batchqty numeric:=0;
v_qty numeric;
v_direction varchar;
v_snrmdid varchar;
v_bmdid varchar;
BEGIN
    v_sql:='select * from m_'||p_table||'line  where m_'||p_table||'_id = '||chr(39)||p_id||chr(39);
    OPEN v_cursor FOR EXECUTE v_sql;
    LOOP
       FETCH v_cursor INTO v_cur;
       EXIT WHEN NOT FOUND;
       v_count:=v_count+1;
       select isserialtracking,isbatchtracking into v_isserial,v_isbatch from m_product where m_product_id=v_cur.m_product_id;
         if p_table='inventory' then
             select abs(qtycount) into v_qty from m_inventoryline where m_inventoryline_id=v_cur.m_inventoryline_id;
             select count(*) into v_sercount from snr_inventoryline where m_inventoryline_id=v_cur.m_inventoryline_id;
             select sum(quantity) into v_batchqty from snr_inventoryline where m_inventoryline_id=v_cur.m_inventoryline_id;
             if v_isserial='Y' and v_qty!=v_sercount then
               raise exception '%', 'In Zeile '||v_cur.line||': Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' sind die Seriennummern nicht korrekt vergeben. Es sind '||to_char(v_sercount)||' Seriennummern erfasst. Es müssen aber '||v_qty||' Seriennummern erfasst sein.';
             end if;
             if v_isbatch='Y' and v_qty!=coalesce(v_batchqty,0) then
               raise exception '%', 'In Zeile '||v_cur.line||': Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' sind die Chargen nicht korrekt zugeordnet. Es sind '||to_char(coalesce(v_batchqty,0))||' Produkte einer Charge zugeordnet. Es müssen aber '||v_qty||' zugeordnet sein.';
             end if;
             if v_isserial='Y' or v_isbatch='Y' then
                 for v_snrcur in (select * from snr_inventoryline where m_inventoryline_id=v_cur.m_inventoryline_id)
                 LOOP
                    PERFORM snr_initmasterdata(v_snrcur.updatedby,v_snrcur.ad_org_id,v_snrcur.serialnumber,v_cur.m_product_id,v_snrcur.lotnumber);
                    v_type:='I+';
                    select movementdate into v_mdate from m_inventory where m_inventory_id=v_cur.m_inventory_id;
                    select snr_masterdata_id into v_snrmdid from snr_masterdata where serialnumber=v_snrcur.serialnumber and m_product_id=v_cur.m_product_id;
                    select snr_batchmasterdata_id into v_bmdid from snr_batchmasterdata  where batchnumber=v_snrcur.lotnumber and m_product_id=v_cur.m_product_id;
                    update snr_inventoryline set snr_masterdata_id = v_snrmdid,snr_batchmasterdata_id=v_bmdid where snr_inventoryline_id=v_snrcur.snr_inventoryline_id;
                    update snr_masterdata set isactive='Y',updatedby= v_snrcur.updatedby,ad_org_id=v_snrcur.ad_org_id,updated=now(),
                           movementdate=v_mdate,movementtype=v_type,m_locator_id=v_cur.m_locator_id,m_inventoryline_id=v_cur.m_inventoryline_id,
                           c_bpartner_id=null,c_bpartner_location_id=null,c_projecttask_id=null,m_inoutline_id=null,m_internal_consumptionline_id=null,m_movementline_id=null
                    where serialnumber=v_snrcur.serialnumber and m_product_id=v_cur.m_product_id;
                 END LOOP;
             end if;
         elsif p_table='inout' then
             select abs(movementqty) into v_qty from m_inoutline where m_inoutline_id=v_cur.m_inoutline_id;
             select count(*) into v_sercount from snr_minoutline where m_inoutline_id=v_cur.m_inoutline_id;
             select sum(quantity) into v_batchqty  from snr_minoutline where m_inoutline_id=v_cur.m_inoutline_id;
             if v_isserial='Y' and v_qty!=v_sercount then
               raise exception '%', 'In Zeile '||v_cur.line||': Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' sind die Seriennummern nicht korrekt vergeben. Es sind '||to_char(v_sercount)||' Seriennummern erfasst. Es müssen aber '||v_qty||' Seriennummern erfasst sein.';
             end if;
             if v_isbatch='Y' and v_qty!=coalesce(v_batchqty,0) then
               raise exception '%', 'In Zeile '||v_cur.line||': Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' sind die Chargen nicht korrekt zugeordnet. Es sind '||to_char(coalesce(v_batchqty,0))||' Produkte einer Charge zugeordnet. Es müssen aber '||v_qty||' zugeordnet sein.';
             end if;
             if v_isserial='Y'  or v_isbatch='Y'  then
                 for v_snrcur in (select * from snr_minoutline where m_inoutline_id=v_cur.m_inoutline_id and v_cur.movementqty!=0)
                 LOOP
                    PERFORM snr_initmasterdata(v_snrcur.updatedby,v_snrcur.ad_org_id,v_snrcur.serialnumber,v_cur.m_product_id,v_snrcur.lotnumber);
                    select movementdate,movementtype,c_bpartner_id,c_bpartner_location_id into v_mdate,v_type,v_partner,v_bploc from m_inout where m_inout_id=v_cur.m_inout_id;
                    if instr(v_type,'+')>0 and v_cur.movementqty>0 then
                        v_direction:='in';
                    elsif instr(v_type,'+')>0 and v_cur.movementqty<0 then
                        v_direction:='out';
                    elsif instr(v_type,'-')>0 and v_cur.movementqty<0 then
                        v_direction:='in';
                    elsif instr(v_type,'-')>0 and v_cur.movementqty>0 then
                        v_direction:='out';
                    end if;
                    --raise exception '%', v_direction;
                    select snr_masterdata_id into v_snrmdid from snr_masterdata where serialnumber=v_snrcur.serialnumber and m_product_id=v_cur.m_product_id;
                    select snr_batchmasterdata_id into v_bmdid from snr_batchmasterdata  where batchnumber=v_snrcur.lotnumber and m_product_id=v_cur.m_product_id;
                    update snr_minoutline set snr_masterdata_id = v_snrmdid,snr_batchmasterdata_id=v_bmdid where snr_minoutline_id=v_snrcur.snr_minoutline_id;
                    update snr_masterdata set isactive='Y',updatedby= v_snrcur.updatedby,ad_org_id=v_snrcur.ad_org_id,updated=now(),
                           movementdate=v_mdate,movementtype=v_type,m_locator_id=case when v_direction='in' then v_cur.m_locator_id else null end,m_inventoryline_id=null,
                           c_bpartner_id=case when v_direction='out' then v_partner else null end,c_bpartner_location_id=case when v_direction='out' then v_bploc else null end,
                           c_projecttask_id=null,m_inoutline_id=v_cur.m_inoutline_id,m_internal_consumptionline_id=null,m_movementline_id=null,
                           ad_user_id=case when v_direction='in' then v_cur.ad_user_id else null end
                    where serialnumber=v_snrcur.serialnumber and m_product_id=v_cur.m_product_id;
                 END LOOP;
             end if;
         elsif p_table='internal_consumption' then 
             select abs(movementqty) into v_qty from m_internal_consumptionline where m_internal_consumptionline_id=v_cur.m_internal_consumptionline_id;
             select count(*) into v_sercount from snr_internal_consumptionline where m_internal_consumptionline_id=v_cur.m_internal_consumptionline_id;
             select sum(quantity) into v_batchqty from snr_internal_consumptionline where m_internal_consumptionline_id=v_cur.m_internal_consumptionline_id;
             if v_isserial='Y' and v_qty!=v_sercount then
               raise exception '%', 'In Zeile '||v_cur.line||': Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' sind die Seriennummern nicht korrekt vergeben. Es sind '||to_char(v_sercount)||' Seriennummern erfasst. Es müssen aber '||v_qty||' Seriennummern erfasst sein.';
             end if;
             if v_isbatch='Y' and v_qty!=coalesce(v_batchqty,0) then
               raise exception '%', 'In Zeile '||v_cur.line||': Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' sind die Chargen nicht korrekt zugeordnet. Es sind '||to_char(coalesce(v_batchqty,0))||' Produkte einer Charge zugeordnet. Es müssen aber '||v_qty||' zugeordnet sein.';
             end if;
             if v_isserial='Y' or v_isbatch='Y' then
                 for v_snrcur in (select * from snr_internal_consumptionline where m_internal_consumptionline_id=v_cur.m_internal_consumptionline_id and v_cur.movementqty!=0)
                 LOOP
                    PERFORM snr_initmasterdata(v_snrcur.updatedby,v_snrcur.ad_org_id,v_snrcur.serialnumber,v_cur.m_product_id,v_snrcur.lotnumber);
                    select movementdate,movementtype into v_mdate,v_type from m_internal_consumption where m_internal_consumption_id=v_cur.m_internal_consumption_id;
                    if instr(v_type,'+')>0 and v_cur.movementqty>0 then
                        v_direction:='in';
                    elsif instr(v_type,'+')>0 and v_cur.movementqty<0 then
                        v_direction:='out';
                    elsif instr(v_type,'-')>0 and v_cur.movementqty<0 then
                        v_direction:='in';
                    elsif instr(v_type,'-')>0 and v_cur.movementqty>0 then
                        v_direction:='out';
                    end if;
                    --raise exception '%', v_direction;
                    select snr_masterdata_id into v_snrmdid from snr_masterdata where serialnumber=v_snrcur.serialnumber and m_product_id=v_cur.m_product_id;
                    select snr_batchmasterdata_id into v_bmdid from snr_batchmasterdata  where batchnumber=v_snrcur.lotnumber and m_product_id=v_cur.m_product_id;
                    update snr_internal_consumptionline set snr_masterdata_id = v_snrmdid,snr_batchmasterdata_id=v_bmdid where snr_internal_consumptionline_id=v_snrcur.snr_internal_consumptionline_id;
                    update snr_masterdata set isactive='Y',updatedby= v_snrcur.updatedby,ad_org_id=v_snrcur.ad_org_id,updated=now(),
                           movementdate=v_mdate,movementtype=v_type,m_locator_id=case when v_direction='in' then v_cur.m_locator_id else null end,m_inventoryline_id=null,
                           c_bpartner_id=null,c_bpartner_location_id=null,
                           c_projecttask_id=case when v_direction='out' then v_cur.c_projecttask_id else null end,m_inoutline_id=null,m_internal_consumptionline_id=v_cur.m_internal_consumptionline_id,m_movementline_id=null
                    where serialnumber=v_snrcur.serialnumber and m_product_id=v_cur.m_product_id;
                 END LOOP;
             end if;
         elsif p_table='movement' then
            select abs(movementqty) into v_qty from m_movementline where m_movementline_id=v_cur.m_movementline_id;
             select count(*) into v_sercount from snr_movementline where m_movementline_id=v_cur.m_movementline_id;
             select sum(quantity) into v_batchqty from snr_movementline where m_movementline_id=v_cur.m_movementline_id;
             if v_isserial='Y' and v_qty!=v_sercount then
               raise exception '%', 'In Zeile '||v_cur.line||': Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' sind die Seriennummern nicht korrekt vergeben. Es sind '||to_char(v_sercount)||' Seriennummern erfasst. Es müssen aber '||v_qty||' Seriennummern erfasst sein.';
             end if;
             if v_isbatch='Y' and v_qty!=coalesce(v_batchqty,0) then
               raise exception '%', 'In Zeile '||v_cur.line||': Für das Produkt '||zssi_getproductname(v_cur.m_product_id,'de_DE')||' sind die Chargen nicht korrekt zugeordnet. Es sind '||to_char(coalesce(v_batchqty,0))||' Produkte einer Charge zugeordnet. Es müssen aber '||v_qty||' zugeordnet sein.';
             end if;
             if v_isserial='Y' or v_isbatch='Y' then
                 for v_snrcur in (select * from snr_movementline where m_movementline_id=v_cur.m_movementline_id)
                 LOOP
                    PERFORM snr_initmasterdata(v_snrcur.updatedby,v_snrcur.ad_org_id,v_snrcur.serialnumber,v_cur.m_product_id,v_snrcur.lotnumber);
                    v_type:='M+';
                    select snr_masterdata_id into v_snrmdid from snr_masterdata where serialnumber=v_snrcur.serialnumber and m_product_id=v_cur.m_product_id;
                    select snr_batchmasterdata_id into v_bmdid from snr_batchmasterdata  where batchnumber=v_snrcur.lotnumber and m_product_id=v_cur.m_product_id;
                    update snr_movementline set snr_masterdata_id = v_snrmdid,snr_batchmasterdata_id=v_bmdid where snr_movementline_id=v_snrcur.snr_movementline_id;
                    select movementdate into v_mdate from m_movement where m_movement_id=v_cur.m_movement_id;
                    update snr_masterdata set isactive='Y',updatedby= v_snrcur.updatedby,ad_org_id=v_snrcur.ad_org_id,updated=now(),
                           movementdate=v_mdate,movementtype=v_type,m_locator_id=v_cur.m_locatorto_id,m_inventoryline_id=null,
                           c_bpartner_id=null,c_bpartner_location_id=null,c_projecttask_id=null,m_inoutline_id=null,m_internal_consumptionline_id=null,m_movementline_id=v_cur.m_movementline_id
                    where serialnumber=v_snrcur.serialnumber and m_product_id=v_cur.m_product_id;
                 END LOOP;
             end if;
         end if;
    END LOOP;
    CLOSE v_cursor;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;



CREATE OR REPLACE FUNCTION snr_minout_trg()
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
*/

BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'UPDATE' THEN
       if new.processed='Y' and old.processed='N' then 
            perform snr_checkpost('inout',new.m_inout_id);
       end if;
   end if;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_minout_trg','m_inout');

CREATE TRIGGER snr_minout_trg
  BEFORE UPDATE
  ON m_inout
  FOR EACH ROW
  EXECUTE PROCEDURE snr_minout_trg();
 
CREATE OR REPLACE FUNCTION snr_internal_consumption_trg()
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
*/
v_cur record;
BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'UPDATE' THEN
       if new.processed='Y' and old.processed='N' then 
            perform snr_checkpost('internal_consumption',new.m_internal_consumption_id);
            -- Build up current BOM in Serial Masterdata, if Applicable 
            for v_cur in (select m_internal_consumptionline_id from m_internal_consumptionline where m_internal_consumption_id=new.m_internal_consumption_id)
            LOOP
                perform snrUpdateCurrentBom(v_cur.m_internal_consumptionline_id);
            END LOOP;
       end if;
   end if;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_internal_consumption_trg','m_internal_consumption');

CREATE TRIGGER snr_internal_consumption_trg
  BEFORE UPDATE
  ON m_internal_consumption
  FOR EACH ROW
  EXECUTE PROCEDURE snr_internal_consumption_trg();
 
CREATE OR REPLACE FUNCTION snr_inventory_trg()
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
*/

BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'UPDATE' THEN
       if new.processed='Y' and old.processed='N' then 
            perform snr_checkpost('inventory',new.m_inventory_id);
       end if;
   end if;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_inventory_trg','m_inventory');

CREATE TRIGGER snr_inventory_trg
  BEFORE UPDATE
  ON m_inventory
  FOR EACH ROW
  EXECUTE PROCEDURE snr_inventory_trg();
 
CREATE OR REPLACE FUNCTION snr_movement_trg()
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
*/

BEGIN
 
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   IF TG_OP = 'UPDATE' THEN
       if new.processed='Y' and old.processed='N' then 
            perform snr_checkpost('movement',new.m_movement_id);
       end if;
   end if;
   IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_movement_trg','m_movement');

CREATE TRIGGER snr_movement_trg
  BEFORE UPDATE
  ON m_movement
  FOR EACH ROW
  EXECUTE PROCEDURE snr_movement_trg();

CREATE or replace FUNCTION snr_correction() RETURNS character varying
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

Only Used by ROLLOUT V76

*****************************************************/
DECLARE
v_return character varying;
v_conid character varying;
v_cur record;
v_cur2 record;
v_qty numeric;
BEGIN
      for v_cur in (select distinct m_product_id,serialnumber,ad_org_id,updatedby,lotnumber from snr_serialnumbertracking)
      LOOP
        PERFORM snr_initmasterdata(v_cur.updatedby,v_cur.ad_org_id,v_cur.serialnumber,v_cur.m_product_id,v_cur.lotnumber);
      END LOOP;
      for v_cur in (select * from snr_masterdata)
      LOOP
        for v_cur2 in (select * from snr_serialnumbertracking snr,m_product p where p.m_product_id=snr.m_product_id and p.isserialtracking='Y'
                       and snr.m_product_id=v_cur.m_product_id and snr.serialnumber=v_cur.serialnumber  and snr.docstatus in ('CO','VO') order by snr.updated desc limit 1)
        LOOP
            if v_cur2.m_inoutline_id is not null then
                select movementqty into v_qty from m_inoutline where m_inoutline_id=v_cur2.m_inoutline_id;
                if instr(v_cur.movementtype,'-')>0  and v_qty>0 then
                    update snr_masterdata set m_locator_id=null,m_internal_consumptionline_id=null,m_inventoryline_id=null,m_movementline_id=null,c_projecttask_id= null, 
                               m_inoutline_id = v_cur2.m_inoutline_id,
                               c_bpartner_id=  v_cur2.c_bpartner_id where  snr_masterdata_id= v_cur.snr_masterdata_id;      
                end if;
                if instr(v_cur.movementtype,'-')>0  and v_qty<0 then
                    update snr_masterdata set m_locator_id=v_cur2.m_locator_id,m_internal_consumptionline_id=null,m_inventoryline_id=null,m_movementline_id=null,c_projecttask_id= null, 
                               m_inoutline_id = v_cur2.m_inoutline_id,
                               c_bpartner_id= null, c_bpartner_location_id= null where  snr_masterdata_id= v_cur.snr_masterdata_id;      
                end if;
                if instr(v_cur.movementtype,'+')>0  and v_qty>0 then
                    update snr_masterdata set m_locator_id=v_cur2.m_locator_id,m_internal_consumptionline_id=null,m_inventoryline_id=null,m_movementline_id=null,c_projecttask_id= null, 
                               m_inoutline_id = v_cur2.m_inoutline_id,
                               c_bpartner_id=  null, c_bpartner_location_id= null where  snr_masterdata_id= v_cur.snr_masterdata_id;      
                end if;
                if instr(v_cur.movementtype,'+')>0  and v_qty<0 then
                    update snr_masterdata set m_locator_id=null,m_internal_consumptionline_id=null,m_inventoryline_id=null,m_movementline_id=null,c_projecttask_id= null, 
                               m_inoutline_id = v_cur2.m_inoutline_id,
                               c_bpartner_id=  v_cur2.c_bpartner_id where  snr_masterdata_id= v_cur.snr_masterdata_id;      
                end if;
            end if;
            if v_cur2.m_internal_consumptionline_id is not null then
                select movementqty into v_qty from m_internal_consumptionline where m_internal_consumptionline_id=v_cur2.m_internal_consumptionline_id;
                if instr(v_cur.movementtype,'-')>0  and v_qty>0 then
                    update snr_masterdata set m_locator_id=null,m_internal_consumptionline_id=v_cur2.m_internal_consumptionline_id,m_inventoryline_id=null,m_movementline_id=null,
                               c_projecttask_id= v_cur2.c_projecttask_id, 
                               m_inoutline_id = null,
                               c_bpartner_id=  null, c_bpartner_location_id= null where  snr_masterdata_id= v_cur.snr_masterdata_id;    
                end if;
                if instr(v_cur.movementtype,'-')>0  and v_qty<0 then
                    update snr_masterdata set m_locator_id=v_cur2.m_locator_id,m_internal_consumptionline_id=v_cur2.m_internal_consumptionline_id,m_inventoryline_id=null,m_movementline_id=null,
                               c_projecttask_id= null, 
                               m_inoutline_id = null,
                               c_bpartner_id=  null, c_bpartner_location_id= null where  snr_masterdata_id= v_cur.snr_masterdata_id;     
                end if;
                if instr(v_cur.movementtype,'+')>0  and v_qty>0 then
                    update snr_masterdata set m_locator_id=v_cur2.m_locator_id,m_internal_consumptionline_id=v_cur2.m_internal_consumptionline_id,m_inventoryline_id=null,m_movementline_id=null,
                               c_projecttask_id= null, 
                               m_inoutline_id = null,
                               c_bpartner_id=  null, c_bpartner_location_id= null where  snr_masterdata_id= v_cur.snr_masterdata_id;      
                end if;
                if instr(v_cur.movementtype,'+')>0  and v_qty<0 then
                    update snr_masterdata set m_locator_id=null,m_internal_consumptionline_id=v_cur2.m_internal_consumptionline_id,m_inventoryline_id=null,m_movementline_id=null,
                               c_projecttask_id=v_cur2.c_projecttask_id, 
                               m_inoutline_id = null,
                               c_bpartner_id=  null, c_bpartner_location_id= null where  snr_masterdata_id= v_cur.snr_masterdata_id;  
                end if;
            end if;
        END LOOP; 
      END LOOP;
RETURN coalesce('Serial Number Location Correction: DONE');
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;





CREATE OR REPLACE FUNCTION snr_masterdata_trg()
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
*/

BEGIN
 IF TG_OP = 'INSERT' THEN
    if (select  isserialtracking from m_product where m_product_id=new.m_product_id)='N' then
        raise exception '%', '@ProductNeedsSerialtracking@';
    end if;
    if NEW.movementtype is null then
        NEW.m_locator_id=null;
    end if;
 end if;
 IF TG_OP = 'DELETE' THEN
    if old.movementtype is not null then
        raise exception '%', '@deleteofusedserialnumbernotpossible@';
    end if;
 END IF;
 IF TG_OP = 'UPDATE' THEN
    if new.isactive='N' and (new.m_locator_id is not null or new.c_projecttask_id is not null) then
        raise exception '%', '@deleteofusedserialnumbernotpossible@';
    end if;
 END IF;
 IF TG_OP = 'DELETE' then RETURN OLD; else RETURN NEW; end if;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_droptrigger('snr_masterdata_trg','snr_masterdata');

CREATE TRIGGER snr_masterdata_trg
  BEFORE INSERT or DELETE or UPDATE
  ON snr_masterdata
  FOR EACH ROW
  EXECUTE PROCEDURE snr_masterdata_trg();
 
 
 
 
CREATE OR REPLACE FUNCTION getAutoLotNo(v_org varchar, issotrx varchar,v_minoutline_id varchar)
  RETURNS varchar AS
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
*/
v_return varchar;
v_serial varchar;
v_batch varchar;
BEGIN
    -- only Incommin transactions
    if issotrx='N' then
        select p.isserialtracking,p.isbatchtracking  into v_serial,v_batch from m_product p, m_inoutline m where m.m_product_id=p.m_product_id and m.m_inoutline_id = v_minoutline_id;
        if c_getconfigoption('autoselectlotnumber', v_org)='Y' and v_serial = 'N' and v_batch='Y' then
            select p_documentno into v_return from ad_sequence_doc('Batchnumber',v_org,'Y');
        end if;
    end if;
    return coalesce(v_return,'');
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION getLotQtyLeft(v_minoutline_id varchar)
  RETURNS numeric AS
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
*/
v_retval numeric;
v_serial varchar;
v_batch varchar;
BEGIN
    select p.isserialtracking,p.isbatchtracking  into v_serial,v_batch from m_product p, m_inoutline m where m.m_product_id=p.m_product_id and m.m_inoutline_id = v_minoutline_id;
    if v_serial = 'Y' then
        v_retval:=1;
    end if;
    if v_serial = 'N' and v_batch='Y' then 
        select l.movementqty-coalesce(sum(s.quantity),0) into v_retval from m_inoutline l left join snr_minoutline s on s.m_inoutline_id=l.m_inoutline_id where l.m_inoutline_id = v_minoutline_id
        group by l.movementqty;
    end if;
    return coalesce(v_retval,0);
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
  

CREATE OR REPLACE FUNCTION getBuiltInSerials(p_snr_curentbom_id varchar)
  RETURNS varchar AS
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
*/
v_cur record;
v_retval varchar:='';
BEGIN
    for v_cur in (select serialnumber from snr_masterdata where snr_masterdata_id in 
                         (select snr_masterdata_id from snr_currentbom_serials where snr_currentbom_v_id=p_snr_curentbom_id) )
    LOOP
        if v_retval='' then 
            v_retval:=v_cur.serialnumber;
        else
            v_retval:=v_retval||'-'||v_cur.serialnumber;
        end if;
    END LOOP;
    return v_retval;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;  
  
CREATE OR REPLACE FUNCTION getBuiltInBatches(p_snr_curentbom_id varchar)
  RETURNS varchar AS
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
*/
v_cur record;
v_retval varchar:='';
BEGIN
    for v_cur in (select batchnumber from snr_batchmasterdata where snr_batchmasterdata_id in 
                         (select snr_batchmasterdata_id from snr_currentbom_serials where snr_currentbom_v_id=p_snr_curentbom_id)) 
    LOOP
        if v_retval='' then 
            v_retval:=v_cur.batchnumber;
        else
            v_retval:=v_retval||'-'||v_cur.batchnumber;
        end if;
    END LOOP;
    return v_retval;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;  
  
select zsse_DropView ('snr_currentbom_v');
CREATE OR REPLACE VIEW snr_currentbom_v AS 
 SELECT snr_currentbom_id as snr_currentbom_v_id, snr_masterdata_id,
         ad_client_id, ad_org_id, 'Y'::character as isactive , created  , createdby , updated,updatedby,
        m_product_id, qty,m_get_product_cost(m_product_id,trunc(now()),null,ad_org_id)*qty as cost,
        getBuiltInSerials(snr_currentbom_id) as serials,
        getBuiltInBatches(snr_currentbom_id) as batches
 from snr_currentbom;
        


CREATE OR REPLACE FUNCTION snrUpdateCurrentBom(p_minconsline_id varchar)
  RETURNS void AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2014 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/
v_cur record;
v_cur2 record;
v_cur3 record;
v_type varchar;
v_task varchar;
v_user varchar;
v_org varchar;
v_serial varchar;
v_product varchar;
v_batch varchar;
v_currbomid varchar;
v_count numeric;
v_client varchar:='C726FEC915A54A0995C568555DA5BB3C';
v_snrmasterdata varchar;
v_qty numeric;
BEGIN
    select m.movementtype,ml.c_projecttask_id,p.isserialtracking,p.m_product_id,m.updatedby,m.ad_org_id into v_type,v_task,v_serial,v_product,v_user,v_org
           from m_internal_consumption m,m_internal_consumptionline ml,m_product p
           where m.m_internal_consumption_id=ml.m_internal_consumption_id and  p.m_product_id=ml.m_product_id and ml.m_internal_consumptionline_id=p_minconsline_id;
    if v_type='P+' and v_serial='Y' then
        -- Bei mehreren SNR pro Prod.-Alle bekommen dieselbe BOM
        for v_cur in (select snr_masterdata_id from snr_internal_consumptionline where m_internal_consumptionline_id=p_minconsline_id)
        LOOP
            -- create Initial BOM 
            for v_cur2 in (select ml.m_internal_consumptionline_id,ml.m_product_id, case when m.movementtype='D+' then (-1)*ml.movementqty else ml.movementqty end  as qty ,m.movementtype
                        from m_internal_consumption m,m_internal_consumptionline ml
                        where m.m_internal_consumption_id=ml.m_internal_consumption_id and m.movementtype in ('D+','D-') and m.processed='Y'
                        and ml.c_projecttask_id=v_task)
            LOOP
                    select count(*) into v_count from snr_currentbom where snr_masterdata_id=v_cur.snr_masterdata_id and m_product_id=v_cur2.m_product_id;
                    if v_count=0 and v_cur2.qty>0 then
                        select get_uuid() into v_currbomid;
                        insert into snr_currentbom(snr_currentbom_id , snr_masterdata_id, ad_client_id, ad_org_id , isactive , createdby, updatedby , m_product_id, qty )
                        values (v_currbomid,v_cur.snr_masterdata_id,v_client,v_org,'Y',v_user,v_user,v_cur2.m_product_id,v_cur2.qty);
                        for v_cur3 in (select snr_masterdata_id,quantity,snr_batchmasterdata_id  from snr_internal_consumptionline where m_internal_consumptionline_id=v_cur2.m_internal_consumptionline_id)
                        LOOP
                            insert into snr_currentbom_serials(snr_currentbom_serials_id , snr_currentbom_v_id, snr_masterdata_id ,ad_client_id, ad_org_id , isactive , createdby, updatedby ,snr_batchmasterdata_id,qty)
                            values(get_uuid(),v_currbomid,v_cur3.snr_masterdata_id,v_client,v_org,'Y',v_user,v_user,v_cur3.snr_batchmasterdata_id,v_cur3.quantity);
                            update snr_masterdata set snrselfjoin=v_cur.snr_masterdata_id where snr_masterdata_id=v_cur3.snr_masterdata_id;
                        END LOOP;
                    end if;
                    if v_count=1 then
                        if ((select qty from snr_currentbom where snr_masterdata_id=v_cur.snr_masterdata_id and m_product_id=v_cur2.m_product_id)+v_cur2.qty)>0 then
                            select snr_currentbom_id into v_currbomid from snr_currentbom where snr_masterdata_id=v_cur.snr_masterdata_id and m_product_id=v_cur2.m_product_id;
                            update snr_currentbom set qty=qty+v_cur2.qty where snr_currentbom_id=v_currbomid;
                            for v_cur3 in (select snr_masterdata_id,quantity,snr_batchmasterdata_id  from snr_internal_consumptionline where m_internal_consumptionline_id=v_cur2.m_internal_consumptionline_id)
                            LOOP
                              if v_cur2.movementtype='D-' then
                                insert into snr_currentbom_serials(snr_currentbom_serials_id , snr_currentbom_v_id, snr_masterdata_id ,ad_client_id, ad_org_id , isactive , createdby, updatedby ,snr_batchmasterdata_id,qty)
                                values(get_uuid(),v_currbomid,v_cur3.snr_masterdata_id,v_client,v_org,'Y',v_user,v_user,v_cur3.snr_batchmasterdata_id,v_cur3.quantity);
                              else
                                delete from snr_currentbom_serials where snr_currentbom_v_id=v_currbomid and snr_masterdata_id=v_cur3.snr_masterdata_id or snr_batchmasterdata_id=v_cur3.snr_batchmasterdata_id;
                                update snr_masterdata set snrselfjoin=null where snr_masterdata_id=v_cur3.snr_masterdata_id;
                              end if;
                            END LOOP;
                        else
                            delete from snr_currentbom where snr_masterdata_id=v_cur.snr_masterdata_id and m_product_id=v_cur2.m_product_id;
                        end if;
                    end if;
            END LOOP;
        END LOOP;
    else -- D+/D-
        select m.snr_masterdata_id,ml.m_product_id, case when v_type='D+' then (-1)*ml.movementqty else ml.movementqty end  into v_snrmasterdata ,v_product,v_qty
        from ma_machine m,c_project p,m_internal_consumptionline ml
        where m.ma_machine_id=p.ma_machine_id and p.c_project_id=ml.c_project_id and ml.m_internal_consumptionline_id=p_minconsline_id;
        if v_snrmasterdata is  null then
            select a.snr_masterdata_id,ml.m_product_id, case when v_type='D+' then (-1)*ml.movementqty else ml.movementqty end  into v_snrmasterdata ,v_product,v_qty
            from a_asset a,c_project p,m_internal_consumptionline ml
            where a.a_asset_id=p.a_asset_id and p.c_project_id=ml.c_project_id and ml.m_internal_consumptionline_id=p_minconsline_id;
        end if;
        if v_snrmasterdata is not null then
            select count(*) into v_count from snr_currentbom where snr_masterdata_id=v_snrmasterdata and m_product_id=v_product;
            if v_count=0 and v_qty>0 then
                select get_uuid() into v_currbomid;
                insert into snr_currentbom(snr_currentbom_id , snr_masterdata_id, ad_client_id, ad_org_id , isactive , createdby, updatedby , m_product_id, qty )
                values (v_currbomid,v_snrmasterdata,v_client,v_org,'Y',v_user,v_user,v_product,v_qty);
                for v_cur3 in (select snr_masterdata_id,quantity,snr_batchmasterdata_id  from snr_internal_consumptionline where m_internal_consumptionline_id=p_minconsline_id)
                LOOP
                    insert into snr_currentbom_serials(snr_currentbom_serials_id , snr_currentbom_v_id, snr_masterdata_id ,ad_client_id, ad_org_id , isactive , createdby, updatedby ,snr_batchmasterdata_id,qty)
                    values(get_uuid(),v_currbomid,v_cur3.snr_masterdata_id,v_client,v_org,'Y',v_user,v_user,v_cur3.snr_batchmasterdata_id,v_cur3.quantity);
                    update snr_masterdata set snrselfjoin=v_snrmasterdata where snr_masterdata_id=v_cur3.snr_masterdata_id;
                END LOOP;
            end if;
            if v_count=1 then
                if ((select qty from snr_currentbom where snr_masterdata_id=v_snrmasterdata and m_product_id=v_product)+v_qty)>0 then
                    select snr_currentbom_id into v_currbomid from snr_currentbom where snr_masterdata_id=v_snrmasterdata and m_product_id=v_product;
                    update snr_currentbom set qty=qty+v_qty where snr_currentbom_id=v_currbomid;
                    for v_cur3 in (select snr_masterdata_id,quantity,snr_batchmasterdata_id  from snr_internal_consumptionline where m_internal_consumptionline_id=p_minconsline_id)
                    LOOP
                        if v_type='D-' then
                            insert into snr_currentbom_serials(snr_currentbom_serials_id , snr_currentbom_v_id, snr_masterdata_id ,ad_client_id, ad_org_id , isactive , createdby, updatedby ,snr_batchmasterdata_id,qty)
                            values(get_uuid(),v_currbomid,v_cur3.snr_masterdata_id,v_client,v_org,'Y',v_user,v_user,v_cur3.snr_batchmasterdata_id,v_cur3.quantity);
                        else
                            delete from snr_currentbom_serials where snr_currentbom_v_id=v_currbomid and snr_masterdata_id=v_cur3.snr_masterdata_id or snr_batchmasterdata_id=v_cur3.snr_batchmasterdata_id;
                            update snr_masterdata set snrselfjoin=null where snr_masterdata_id=v_cur3.snr_masterdata_id;
                        end if;
                    END LOOP;
                else
                    delete from snr_currentbom where snr_masterdata_id=v_snrmasterdata and m_product_id=v_product;
                end if;
            end if;
        end if;
    end if;
    return;
END;
  $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
  
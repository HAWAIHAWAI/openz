select zsse_DropView ('c_bpartneremployee_view');

CREATE OR REPLACE VIEW c_bpartneremployee_view AS 
            select c_bpartner.C_BPARTNER_ID as c_bpartneremployee_view_id,c_bpartner.C_BPARTNER_ID as C_BPARTNER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED,ISACTIVE,UPDATED,CREATEDBY, UPDATEDBY, VALUE, NAME, DESCRIPTION, C_BP_GROUP_ID, ISEMPLOYEE, ISSALESREP, REFERENCENO, AD_LANGUAGE,
                   TAXID, ISTAXEXEMPT, C_GREETING_ID, ISWORKER, COUNTRY, CITY, ZIPCODE, ISPROJECTMANAGER, ISPROCUREMENTMANAGER, APPROVALAMT, ISAPPROVER, ISPRAPPROVER, ISPAYMENTAPPROVER,c_salary_category_id,rating,c_bp_employee.a_asset_id,isinresourceplan
            from   c_bpartner left join c_bp_employee on c_bpartner.c_bpartner_id = c_bp_employee.c_bpartner_id
            where ISEMPLOYEE='Y';

CREATE OR REPLACE RULE c_bpartneremployee_view_insert AS
        ON INSERT TO c_bpartneremployee_view DO INSTEAD 
        (INSERT INTO c_bpartner (C_BPARTNER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, VALUE, NAME, DESCRIPTION, C_BP_GROUP_ID, ISEMPLOYEE, ISSALESREP, REFERENCENO, AD_LANGUAGE, TAXID, ISTAXEXEMPT, C_GREETING_ID, ISWORKER,isinresourceplan,
                   COUNTRY, CITY, ZIPCODE, ISPROJECTMANAGER, ISPROCUREMENTMANAGER, APPROVALAMT, ISAPPROVER, ISPRAPPROVER, ISPAYMENTAPPROVER,c_salary_category_id,rating)
        VALUES (new.C_BPARTNER_ID, new.AD_CLIENT_ID, new.AD_ORG_ID, new.CREATEDBY, new.UPDATEDBY, new.VALUE, new.NAME, new.DESCRIPTION, new.C_BP_GROUP_ID, 'Y', new.ISSALESREP, 
                   new.REFERENCENO, new.AD_LANGUAGE, new.TAXID, new.ISTAXEXEMPT, new.C_GREETING_ID, new.ISWORKER,new.isinresourceplan,
                   new.COUNTRY, new.CITY, new.ZIPCODE, new.ISPROJECTMANAGER, new.ISPROCUREMENTMANAGER, new.APPROVALAMT, new.ISAPPROVER, new.ISPRAPPROVER, new.ISPAYMENTAPPROVER,new.c_salary_category_id,new.rating);    
        INSERT INTO c_bp_employee(c_bpartner_id, a_asset_id)
        VALUES (new.C_BPARTNER_ID, new.a_asset_id));

CREATE OR REPLACE RULE c_bpartneremployee_view_update AS
        ON UPDATE TO c_bpartneremployee_view DO INSTEAD 
        (UPDATE c_bpartner SET 
                AD_CLIENT_ID=new.AD_CLIENT_ID, 
                AD_ORG_ID=new.AD_ORG_ID,
                UPDATEDBY=new.UPDATEDBY, 
                VALUE=new.VALUE, 
                NAME=new.NAME, 
                DESCRIPTION=new.DESCRIPTION, C_BP_GROUP_ID=new.C_BP_GROUP_ID, isinresourceplan=new.isinresourceplan,
                ISSALESREP=new.ISSALESREP, REFERENCENO=new.REFERENCENO, AD_LANGUAGE=new.AD_LANGUAGE, TAXID=new.TAXID, ISTAXEXEMPT=new.ISTAXEXEMPT,ISWORKER=new.ISWORKER,
                COUNTRY=new.COUNTRY, CITY=new.CITY, ZIPCODE=new.ZIPCODE, ISPROJECTMANAGER=new.ISPROJECTMANAGER, ISPROCUREMENTMANAGER=new.ISPROCUREMENTMANAGER, APPROVALAMT=new.APPROVALAMT, ISAPPROVER=new.ISAPPROVER,
                ISPRAPPROVER=new.ISPRAPPROVER,ISPAYMENTAPPROVER= new.ISPAYMENTAPPROVER,c_salary_category_id=new.c_salary_category_id,rating=new.rating,
                isactive=new.isactive
               where C_BPARTNER_ID=new.C_BPARTNER_ID;
        UPDATE c_bp_employee SET
        A_ASSET_ID=new.A_ASSET_ID 
        where C_BPARTNER_ID=new.C_BPARTNER_ID);

CREATE OR REPLACE RULE c_bpartneremployee_view_delete AS
        ON DELETE TO c_bpartneremployee_view DO INSTEAD 
        (DELETE FROM c_bp_employee
		  WHERE c_bpartner_id = old.C_BPARTNER_ID;
        DELETE FROM c_bpartner
        WHERE c_bpartner_id = old.C_BPARTNER_ID);


CREATE OR REPLACE FUNCTION zssi_getNewProductEan(p_org character varying)
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
Part of Smartprefs
Default-Product EAN
*****************************************************/
v_return               character varying:='';
BEGIN
  if c_getconfigoption('autoproducteansequence', p_org)='Y' then
     select Ad_Sequence_Doc('Product EAN', p_org, 'Y') into v_return;
  end if;
RETURN v_return;

END;
$BODY$ LANGUAGE 'plpgsql' VOLATILE  COST 100;


CREATE OR REPLACE FUNCTION zssi_getNewBPartnerValue(p_org character varying)
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
Part of Smartprefs
Default-Product Value
*****************************************************/
v_return               character varying:='';
BEGIN
  if c_getconfigoption('autobpartnervaluesequence', p_org)='Y' then
     select Ad_Sequence_Doc('BPartner Value', p_org, 'Y') into v_return;
  end if;
RETURN v_return;

END;
$BODY$ LANGUAGE 'plpgsql' VOLATILE  COST 100;


CREATE OR REPLACE FUNCTION zssi_product_trg()
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
Default-Price (and Costs) for Items
*****************************************************/
v_prlist_id               character varying;
v_version_id              character varying;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN
    -- Sandard-Cost =0     
      insert into m_costing (M_COSTING_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY,  M_PRODUCT_ID, DATEFROM, DATETO, ISMANUAL, PRICE,  COSTTYPE,  COST)
             values(get_uuid(),new.AD_Client_ID, new.AD_Org_ID, now(), new.CREATEDBY, now(), new.UPDATEDBY, new.M_PRODUCT_ID,now(),to_date('01.01.9999','dd.mm.yyyy'),'N',0,'ST',0);
  END IF; 
RETURN NEW;
EXCEPTION
WHEN NO_DATA_FOUND THEN
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_product_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_product_uom_trg()
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
Second UOM must differ from 1st UOM
*****************************************************/
v_count                   numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  select count(*) into v_count from m_product where m_product_id=new.m_product_id and c_uom_id=new.c_uom_id;
  if v_count>0 then
    RAISE EXCEPTION '%', '@SecondUomNotFirstUOM@';
  END IF; 
RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_product_uom_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_bpartner_trg2()
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
2.nd Trigger: Before Insert
Defaults for : c_paymentterm_id,c_invoiceschedule_id,po_pricelist_id,m_pricelist_id
*****************************************************/
v_payterm                  character varying;
v_isched                   character varying;
v_poplist                  character varying;
v_plist                    character varying;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN
      if new.isemployee='N' then
          -- Set defaults
          select c_paymentterm_id into v_payterm from c_paymentterm where isdefault='Y' and isactive='Y' and ad_org_id in ('0',new.ad_org_id) order by ad_org_id desc limit 1;
          select c_invoiceschedule_id into v_isched from c_invoiceschedule where isdefault='Y' and isactive='Y' and ad_org_id in ('0',new.ad_org_id) order by ad_org_id desc limit 1;
          select m_pricelist_id into v_plist from m_pricelist where isdefault='Y' and isactive='Y' and issopricelist='Y' and ad_org_id in ('0',new.ad_org_id) order by ad_org_id desc limit 1;
          select m_pricelist_id into v_poplist from m_pricelist where isactive='Y' and isdefault='Y' and issopricelist='N' and ad_org_id in ('0',new.ad_org_id) order by ad_org_id desc limit 1;
          new.c_paymentterm_id:=v_payterm;
          new.PO_PaymentTerm_ID:=v_payterm;
          new.c_invoiceschedule_id:=v_isched;
          new.m_pricelist_id:=v_plist;
          new.PO_PriceList_ID:=v_poplist;
          new.PaymentRule:='R';
          new.InvoiceRule:='I';
          new.PaymentRulePO:='R';
          new.Invoicegrouping:='000000000000000';
          new.DeliveryRule:='A';
          new.DeliveryViaRule:='D';
       END IF; 
  END IF; 
RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_bpartner_trg2() OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_bpartner_trg()
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
After insert or update
Default-Address for Business partners (Standard/Germany)
If EMPLOYEE- Only one userin ad-User is allowed
*****************************************************/
v_location_id              character varying;
v_count                    numeric;
v_shop                     character varying;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF (TG_OP = 'INSERT') THEN
      -- Create Default Location
      select get_uuid() into v_location_id from dual;
      insert into c_location(c_location_id, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ADDRESS1, C_COUNTRY_ID)
        values (v_location_id,new.AD_Client_ID, new.AD_Org_ID, 'Y', now(), new.CREATEDBY, now(), new.UPDATEDBY, 'Standard','101');
      insert into c_bpartner_location (C_BPARTNER_LOCATION_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, NAME, ISBILLTO, ISSHIPTO, ISPAYFROM, ISREMITTO,isheadquarter,  C_BPARTNER_ID, C_LOCATION_ID, ISTAXLOCATION)
            values (get_uuid(),new.AD_Client_ID, new.AD_Org_ID, 'Y', now(), new.CREATEDBY, now(), new.UPDATEDBY, 'Standard','Y','Y','Y','Y','Y',new.C_BPARTNER_ID,v_location_id,'Y');
      -- If Employee
      if new.isemployee='Y' then
        select count(*) into v_count from ad_user,c_bpartner where ad_user.c_bpartner_id=c_bpartner.c_bpartner_id and ad_user.c_bpartner_id=new.c_bpartner_id;
         if v_count=0 then
            -- Create default-Entry in ad_user
            insert into ad_user(AD_USER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, NAME, C_BPARTNER_ID)
                    values(get_uuid(),new.AD_CLIENT_ID,new.AD_ORG_ID,new.CREATEDBY,new.UPDATEDBY,new.name,new.C_BPARTNER_ID);
         end if;
      end if;
      -- Load ECommerce Preferences
      select count(*) into v_count from ad_module where name='ECommerce' and isactive='Y';
      if v_count=1 then
          select ZSE_SHOP_ID into v_shop from ZSE_SHOP where AD_ORG_ID in ('0',new.ad_org_id) and isactive='Y' order by ad_org_id desc limit 1;
          if v_shop is not null then
              insert into ZSE_ECOMMERCEGRANT (ZSE_ECOMMERCEGRANT_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, ZSE_SHOP_ID, C_BPARTNER_ID, PAYMENTMETHOD)
                select get_uuid(),new.AD_CLIENT_ID,new.AD_ORG_ID,new.CREATEDBY,new.UPDATEDBY,v_shop,new.C_BPARTNER_ID,PAYMENTMETHOD from zse_shop_defaultpaymethod where ZSE_SHOP_ID=v_shop and isactive='Y';
          end if;
      end if;
  END IF; 
  IF (TG_OP = 'UPDATE') THEN
      if new.isemployee='Y' then
         select count(*) into v_count from ad_user,c_bpartner where ad_user.c_bpartner_id=c_bpartner.c_bpartner_id and ad_user.c_bpartner_id=new.c_bpartner_id;
         if v_count>1 then
            RAISE EXCEPTION '%', '@zssi_OnlyOneUserOnEmp@';
            return old;
         end if;
         if v_count=0 then
            -- Create default-Entry in ad_user
            insert into ad_user(AD_USER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, NAME, C_BPARTNER_ID)
                   values(get_uuid(),new.AD_CLIENT_ID,new.AD_ORG_ID,new.CREATEDBY,new.UPDATEDBY,new.name,new.C_BPARTNER_ID);
         end if;
      end if;
      -- Propagate ORG-Changes to Subsequent entities
      if new.ad_org_id!=old.ad_org_id then
        update c_bp_bankaccount set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update c_bp_customer_acct set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update c_bp_employee_acct set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update c_bp_salcategory set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update c_bpartner_location set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update c_bpartneremployeecalendarsettings set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update c_bpartneremployeeevent set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update c_bp_vendor_acct set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update c_bp_salcategory set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id;
        update ad_user set ad_org_id=new.ad_org_id where c_bpartner_id = new.c_bpartner_id and ad_org_id=old.ad_org_id;
      end if;
  END IF;
RETURN NEW;
EXCEPTION
WHEN NO_DATA_FOUND THEN
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION zssi_aduser_trg()
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
Business Partner - On Insert. Only one user on employees and undefined partner
*****************************************************/
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from ad_user,c_bpartner where ad_user.c_bpartner_id=c_bpartner.c_bpartner_id and ad_user.c_bpartner_id=new.c_bpartner_id 
  and (c_bpartner.isemployee='Y') and ad_user.ad_user_id!=new.ad_user_id;
  if v_count > 0  then
      RAISE EXCEPTION '%', '@zssi_OnlyOneUserOnEmp@';
  end if;
  RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
select zsse_DropTrigger ('zssi_aduser_trg','ad_user');

CREATE TRIGGER zssi_aduser_trg
  BEFORE INSERT or UPDATE
  ON ad_user FOR EACH ROW
  EXECUTE PROCEDURE zssi_aduser_trg();




CREATE OR REPLACE FUNCTION zssi_mproductpo_trg()
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
On Insert or Update. Set the Latest Vendor and Vendor-Productno.
In M_product
*****************************************************/
v_vendor character varying;
v_vproductno character varying;
v_productid character varying;
v_org character varying;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF; 
   if (TG_OP in ('INSERT','UPDATE')) then
      v_productid:=new.m_product_id;
      v_org:=new.ad_org_id;
   else
      v_productid:=old.m_product_id;
      v_org:=old.ad_org_id;
   end if;
   -- Select current Vendor
   select PO.C_BPARTNER_ID,vendorproductno into v_vendor ,v_vproductno
                   from M_PRODUCT_PO po 
                   where po.m_product_id=v_productid and PO.iscurrentvendor='Y' and PO.AD_ORG_ID in ('0',v_org) order by coalesce(po.qualityrating,0) desc,updated desc limit 1;
  -- Do the Update
  update m_product set c_bpartner_id=v_vendor, vendorproductno=v_vproductno where m_product_id=v_productid;
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_mproductpo_trg() OWNER TO tad;

drop trigger zssi_mproductpo_trg on m_product_po;

CREATE TRIGGER zssi_mproductpo_trg
  AFTER INSERT OR UPDATE OR DELETE
  ON m_product_po
  FOR EACH ROW
  EXECUTE PROCEDURE zssi_mproductpo_trg();

/**************************************************************************************************************************************+

IMPROVEMENTS - Master-DATA

Database Functions

Reactivate Deactivated Products







***************************************************************************************************************************************/


CREATE OR REPLACE FUNCTION zssi_reactivateitem(p_PInstance_ID character varying) RETURNS void 
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

Process: Reactivate an Item
*****************************************************/
v_message character varying:='Success';
v_Record_ID  character varying;
v_User    character varying;
v_count numeric;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    else
      -- Select Product-ID from parameters
      select P_String into v_Record_ID from AD_PINSTANCE_PARA where ParameterName='m_product_id' and AD_PInstance_ID=p_PInstance_ID;
    end if;--  Update AD_PInstance
    if v_Record_ID is null then
        v_message:='Record not found';
    end if;
    update m_product set isactive='Y',updated=now(),updatedby= v_User where m_product_id=v_Record_ID;
 
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_message);
    return;
EXCEPTION
    WHEN OTHERS then
       v_message:= '@ERROR=' || SQLERRM;   
       --ROLLBACK;
       -- 0=failed
       PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message);
       return;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_reactivateitem(p_PInstance_ID character varying) OWNER TO tad; 




CREATE OR REPLACE FUNCTION zssi_bplocation_trg()
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
Business Partner - Add main Address Searchable to c_bpartner
*****************************************************/
v_count          numeric;
v_country        character varying;
v_countryID      character varying;
v_zip            character varying;
v_city           character varying;
v_adr1           character varying;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN RETURN NEW; END IF; 
  select count(*) into v_count from c_bpartner_location where c_bpartner_id=new.c_bpartner_id and isheadquarter='Y';
  -- Do only allow one heaquarter per business partner
  if (TG_OP = 'INSERT' and v_count>0 and new.isheadquarter='Y') then
      RAISE EXCEPTION '%', '@zssi_OnlyOneHeadinBP@';
  end if; 
  if TG_OP = 'UPDATE' then
      if (v_count>0 and old.isheadquarter='N' and new.isheadquarter='Y') then
         RAISE EXCEPTION '%', '@zssi_OnlyOneHeadinBP@';
      end if;
  end if;
  -- Update the name of the location
  If (new.c_location_id is not null) then    
     select c_country_id,city,postal,address1 into v_countryID,v_city,v_zip,v_adr1 from c_location where c_location_id=new.c_location_id;
     select name into v_country from c_country where c_country_id=v_countryID;
     new.name:=substr(coalesce(v_country,' ')||', '||coalesce(v_city,' ')||', '||coalesce(v_adr1,' '),1,60);
     if (new.isheadquarter='Y') then 
          update c_bpartner set country=v_country,city=v_city,zipcode=v_zip where c_bpartner_id=new.c_bpartner_id;
     end if;
  end if;
RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_bplocation_trg() OWNER TO tad;


CREATE OR REPLACE FUNCTION m_product_trg()
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
 Contributions: Modified wuth new accounting rules. Accounts are not copied anymore 
                Added Freight Products must not be Items 
******************************************************************************************************************************/
    v_xTree_ID                                     VARCHAR(32); --OBTG:varchar2--
    v_xParent_ID                                   VARCHAR(32); --OBTG:varchar2--
    v_ControlNo                                NUMERIC;
BEGIN
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;

 IF (TG_OP = 'UPDATE') THEN
    -- Do not allow to de-activate products with OnHand Qty
      IF (new.IsActive='N' AND old.IsActive='Y') THEN
      SELECT  COALESCE(SUM(QtyOnHand)+SUM(QtyReserved)*.111+SUM(QtyOrdered)*999, 0) INTO v_ControlNo
      FROM (SELECT QtyOnHand, 0 AS QtyReserved, 0 AS QtyOrdered
      FROM M_Storage_Detail s
      WHERE s.M_Product_ID=new.M_Product_ID
      UNION
      SELECT 0 AS QtyOnHand, QtyReserved, QtyOrdered
      FROM M_Storage_Pending s
      WHERE s.M_Product_ID=new.M_Product_ID) A;
        IF (v_ControlNo <> 0) THEN
          RAISE EXCEPTION '%', 'Product has active Inventory'; --OBTG:-20400--
        END IF;
      END IF;
 END IF;
 -- Restriction on Freight Products and Sets
 IF (TG_OP = 'INSERT' or TG_OP = 'UPDATE') THEN
     if new.isfreightproduct='Y' and (new.producttype!='S' or new.isstocked!='N') then
        RAISE EXCEPTION '%', '@zssi_FreightMustbeserviceandnotstocked@'; --OBTG:-20400--
     END IF;
     if new.issetitem='Y' and (new.producttype!='I' or new.typeofproduct!='ST' or new.isstocked!='N' or new.isbom!='Y' or new.ispurchased!='N') then
        RAISE EXCEPTION '%', '@SetmustbeBomButnotbeStocked@'; --OBTG:-20400--
     END IF;
 END IF;
 -- Translations
 IF (TG_OP = 'INSERT') THEN
     --  Create Translation Row
     INSERT INTO M_Product_Trl
         (M_Product_Trl_ID, M_Product_ID, AD_Language, AD_Client_ID, AD_Org_ID,
         IsActive, Created, CreatedBy, Updated, UpdatedBy,
         Name, DocumentNote,description, IsTranslated)
     SELECT get_uuid(), new.M_Product_ID, AD_Language, new.AD_Client_ID, new.AD_Org_ID,
         new.IsActive, new.Created, new.CreatedBy, new.Updated, new.UpdatedBy,
         new.Name, new.DocumentNote,new.description, 'N' FROM  AD_Language
     WHERE IsActive = 'Y' AND IsSystemLanguage = 'Y';
   -- AND EXISTS (SELECT * FROM AD_Client
   --  WHERE AD_Client_ID=new.AD_Client_ID AND IsMultiLingualDocument='Y');
 ELSEIF (TG_OP = 'UPDATE') THEN
   UPDATE m_product_trl
   SET name = new.name, description = new.description, documentnote = new.documentnote,
       Updated=new.Updated, updatedBy=new.UpdatedBy
   WHERE
         m_product_id = new.m_product_id
     AND ad_language = (SELECT ad_language FROM AD_Client
                        WHERE AD_Client_ID=new.AD_Client_ID);
END IF;
RETURN NEW;
END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
CREATE OR REPLACE FUNCTION zspm_productbom_post_trg()
RETURNS trigger AS
$body$
 -- Synchronize all BASE-Worksteps producing this ITEM
DECLARE
 v_cur RECORD;
 v_count numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;  END IF;

  IF (TG_OP <> 'DELETE') then
    if c_getconfigoption('synchronizeworkstepboms',new.ad_org_id)='Y' then
        IF (TG_OP = 'INSERT') THEN
            -- All BASE-Worksteps producing this Item
            for v_cur in (select * from c_projecttask where assembly='Y' and c_project_id is null and m_product_id=new.m_product_id)
            LOOP   
            INSERT INTO zspm_projecttaskbom (zspm_projecttaskbom_id,isactive, c_projecttask_id, ad_client_id, ad_org_id, createdby, updatedby, m_product_id, quantity,issuing_locator,receiving_locator,line)
            VALUES (get_uuid(), new.isactive,v_cur.c_projecttask_id, v_cur.ad_client_id, v_cur.ad_org_id, new.createdby, NEW.updatedby, new.m_productbom_id, new.bomqty,v_cur.issuing_locator,v_cur.receiving_locator,new.line);
            END LOOP;
        END IF; -- TG_OP = 'INSERT'
        IF (TG_OP = 'UPDATE') THEN
            for v_cur in (select * from c_projecttask where assembly='Y' and c_project_id is null and m_product_id=new.m_product_id)
            LOOP 
            select count(*) into v_count from zspm_projecttaskbom where c_projecttask_id=v_cur.c_projecttask_id and m_product_id=old.m_productbom_id and line=old.line;
            if v_count=1 then
                UPDATE zspm_projecttaskbom set isactive=new.isactive, updatedby=NEW.updatedby,updated=now(), m_product_id=new.m_productbom_id, quantity=new.bomqty
                where c_projecttask_id=v_cur.c_projecttask_id and m_product_id=old.m_productbom_id and line=old.line;
            else
                INSERT INTO zspm_projecttaskbom (zspm_projecttaskbom_id,isactive, c_projecttask_id, ad_client_id, ad_org_id, createdby, updatedby, m_product_id, quantity,issuing_locator,receiving_locator,line)
                VALUES (get_uuid(), new.isactive,v_cur.c_projecttask_id, v_cur.ad_client_id, v_cur.ad_org_id, new.createdby, NEW.updatedby, new.m_productbom_id, new.bomqty,v_cur.issuing_locator,v_cur.receiving_locator,new.line);
            end if;
            END LOOP;
        END IF; -- TG_OP = 'UPDATE'
    END IF; -- Config Option
    RETURN NEW;
  ELSE -- TG_OP = 'DELETE'
      if c_getconfigoption('synchronizeworkstepboms',old.ad_org_id)='Y' then
        -- All BASE-Worksteps producing this Item
        for v_cur in (select * from c_projecttask where assembly='Y' and c_project_id is null and m_product_id=old.m_product_id)
        LOOP   
           DELETE FROM  zspm_projecttaskbom where c_projecttask_id=v_cur.c_projecttask_id and m_product_id=old.m_productbom_id and line=old.line;
        END LOOP;
      end if;
      RETURN OLD;
  END IF;
END;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('zspm_productbom_post_trg', 'm_product_bom');
CREATE TRIGGER zspm_productbom_post_trg
  AFTER INSERT OR UPDATE OR DELETE
  ON m_product_bom FOR EACH ROW
  EXECUTE PROCEDURE zspm_productbom_post_trg();

 
  
  
CREATE OR REPLACE FUNCTION zssi_getNewProductValue(p_org character varying)
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
  if c_getconfigoption('autoproductvaluesequence', p_org)='Y' then
     select Ad_Sequence_Doc('Product Value', p_org, 'N') into v_return;
  end if;
  RETURN v_return;
END;
$BODY$ LANGUAGE 'plpgsql' VOLATILE  COST 100;
  
  
  
CREATE OR REPLACE FUNCTION m_product_value_trg()
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
    -- Find a free Product Value if Option Configured and a double value was entered
    IF (TG_OP = 'INSERT' or TG_OP = 'UPDATE') THEN
        IF c_getconfigoption('autoproductvaluesequence',new.ad_org_id)='Y' then
            IF (TG_OP = 'INSERT' ) THEN
                select p_documentno into new.value from ad_sequence_doc('Product Value',new.ad_org_id,'N');
            END IF;
            WHILE (select count(*) from m_product where value=new.value and m_product_id!=new.m_product_id)>0 
            LOOP
                select p_documentno into new.value from ad_sequence_doc('Product Value',new.ad_org_id,'Y');
                v_isincremented:=true;
            END LOOP;
            IF (TG_OP = 'INSERT' and v_isincremented=false) THEN
                perform ad_sequence_doc('Product Value',new.ad_org_id,'Y');
            END IF;
        end if;
   END IF;
RETURN NEW;
END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
 
select zsse_droptrigger('m_product_value_trg','m_product');

CREATE TRIGGER m_product_value_trg
  BEFORE INSERT OR UPDATE 
  ON m_product
  FOR EACH ROW
  EXECUTE PROCEDURE m_product_value_trg();


CREATE OR REPLACE VIEW c_bpartner_v AS 
 SELECT p.ad_client_id, p.ad_org_id, p.c_bpartner_id, p.value, p.name, p.referenceno, p.so_creditlimit - p.so_creditused AS so_creditavailable, p.so_creditlimit, p.so_creditused, p.iscustomer, p.isvendor, p.actuallifetimevalue AS revenue, c.name AS contact, c.phone, a.postal, a.city, c.email
   FROM c_bpartner p
   LEFT JOIN ad_user c ON p.c_bpartner_id::text = c.c_bpartner_id::text
   LEFT JOIN c_bpartner_location l ON p.c_bpartner_id::text = l.c_bpartner_id::text
   LEFT JOIN c_location a ON l.c_location_id::text = a.c_location_id::text;

   
CREATE OR REPLACE FUNCTION c_uom_conversion_trg()
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
Second UOM must differ from 1st UOM
*****************************************************/
v_count                   numeric;
BEGIN
    if new.multiplyrate>0 then
        new.dividerate:=1/new.multiplyrate;
    end if;
RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

SELECT zsse_droptrigger('c_uom_conversion_trg', 'c_uom_conversion');

CREATE TRIGGER c_uom_conversion_trg
  BEFORE INSERT OR UPDATE 
  ON c_uom_conversion FOR EACH ROW
  EXECUTE PROCEDURE c_uom_conversion_trg();
  
   
CREATE OR REPLACE FUNCTION m_product_po_uom_trg()
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
Second UOM must differ from 1st UOM


TODO: Remove Trigger - Only temporyry deactivated field.

*****************************************************/
v_count                   numeric;
BEGIN
   new.c_uom_id:=null; 
RETURN NEW;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

SELECT zsse_droptrigger('m_product_po_uom_trg', 'm_product_po');

CREATE TRIGGER  m_product_po_uom_trg
  BEFORE INSERT OR UPDATE 
  ON  m_product_po FOR EACH ROW
  EXECUTE PROCEDURE  m_product_po_uom_trg();
  
  
  
  
CREATE OR REPLACE FUNCTION zssi_isProductSelectableinWindow(p_windowID character varying,p_productID varchar)
  RETURNS character varying AS
$BODY$ DECLARE 
v_test varchar;
BEGIN
  -- Test SElecrtable for Production in PCategory
  select c.isselectableinproduction into v_test from m_product_category c,m_product p where c.m_product_category_id=p.m_product_category_id and p.m_product_id=p_productID;
  if coalesce(v_test,'Y')='N' then
    if p_windowID in (select ad_window_id from ad_window where ad_module_id in (select ad_module_id from ad_module where name in ('Projects','Serial Production'))) then
        return 'N';
    end if;
  end if;
  RETURN 'Y';
END;
$BODY$ LANGUAGE 'plpgsql' VOLATILE  COST 100;
    
 
CREATE OR REPLACE FUNCTION zssi_isCategorySelectableinWindow(p_windowID character varying,p_categoryID varchar)
  RETURNS character varying AS
$BODY$ DECLARE 
v_test varchar;
BEGIN
  -- Test SElecrtable for Production in PCategory
  select c.isselectableinproduction into v_test from m_product_category c where c.m_product_category_id=p_categoryID;
  if coalesce(v_test,'Y')='N' then
    if p_windowID in (select ad_window_id from ad_window where ad_module_id in (select ad_module_id from ad_module where name in ('Projects','Serial Production'))) then
        return 'N';
    end if;
  end if;
  RETURN 'Y';
END;
$BODY$ LANGUAGE 'plpgsql' VOLATILE  COST 100;
     

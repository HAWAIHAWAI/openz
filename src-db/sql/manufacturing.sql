/**************************************************************************************************************************************+

BOM Implementation 

* Explode BOM's
* Checks

***************************************************************************************************************************************/

CREATE or replace FUNCTION zsmf_mproductbomtree_trg() RETURNS TRIGGER
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
Builds a complete Tree of a BOM
*****************************************************/
DECLARE
-- Simple Types
v_cur  RECORD;
v_cur2  RECORD;
v_isready character varying:='N';
v_level numeric;
v_count numeric;
v_bom character varying;
v_processuid character varying;
v_user character varying;
v_org character varying;
v_client character varying;
v_product character varying;
v_notvery varchar;
BEGIN
   IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
   END IF;
  IF(TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
    v_user:=new.CREATEDBY;
    v_org:=new.AD_ORG_ID;
    v_client:=new.AD_CLIENT_ID;
    v_product:=new.M_PRODUCT_ID;
    /*
    select count(*) into v_count from m_product where m_product.m_product_id=v_product and typeofproduct not in ('CD','SA','AS','UA');
    if v_count>0 then
       RAISE EXCEPTION '%', '@zsmf_ProductMustbeAssemblyOrCDNoVerify@';
    end if;
    
    for v_cur in (select distinct m_productbom_id as m_product_id from m_product_bom where  m_product_id=v_product)
    LOOP
    select value||'-'||name into v_notvery from m_product WHERE M_Product_ID=v_cur.m_product_id AND IsVerified='N' and isbom='Y';
    if v_notvery is not null then
        RAISE EXCEPTION '%', '@zsmf_SubAssemblyNotVerified@'||v_notvery; 
    end if;
    END LOOP;
    */
    -- Corrections on BOM, if meanwhile Sub-Assemblys have been modified..-> Fire Trigger - Trigger will build a new bomtree
    UPDATE m_product_bom set updated=updated where m_productbom_id=v_product;   
    -- set BOM Veryfied
    UPDATE M_Product  SET IsVerified='Y'  WHERE M_Product_ID=v_product;
  ELSE
    v_user:=old.CREATEDBY;
    v_org:=old.AD_ORG_ID;
    v_client:=old.AD_CLIENT_ID;
    v_product:=old.M_PRODUCT_ID;
  END IF;
    v_level:=1;
    delete from zsmf_bomtree where process_uid in (select process_uid from zsmf_bomtree where ASSEMBLY_ID=v_product and level=1);
    v_processuid:=get_uuid();
    insert into zsmf_bomtree (ZSMF_BOMTREE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, LEVEL, ASSEMBLY_ID, M_PRODUCT_ID, LINE, BOMQTY,  ISPROCESSED,process_uid) values 
                              (get_uuid(),v_client,v_org,v_user,v_user,0,v_product,v_product,0,0,'N',v_processuid);
    RAISE NOTICE '%','Begin:'||v_product;
    while v_isready='N' 
    LOOP
        RAISE NOTICE '%','Outer-Level'||v_level;
        for v_cur2 in (select * from ZSMF_BOMTREE where process_uid=v_processuid and isprocessed='N')
        LOOP
              update zsmf_bomtree set isprocessed='Y' where ZSMF_BOMTREE_ID=v_cur2.ZSMF_BOMTREE_ID;
              for v_cur in (select * from m_product_bom where m_product_id=v_cur2.M_PRODUCT_ID)
              LOOP
                RAISE NOTICE '%','Inner-'||v_cur.m_productbom_id;
                select isbom into v_bom from m_product where m_product_id=v_cur.m_productbom_id;
                if v_cur.m_productbom_id=v_cur2.ASSEMBLY_ID then
                   RAISE EXCEPTION '%', '@zsmf_BOMHasRecoursion@'||zssi_getproductname(v_cur.m_productbom_id,'de_DE');
                end if;
                if v_bom='Y' then
                        insert into  ZSMF_BOMTREE (ZSMF_BOMTREE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, LEVEL, ASSEMBLY_ID, M_PRODUCT_ID, LINE, BOMQTY, DESCRIPTION, ISPROCESSED,process_uid,constuctivemeasure) 
                            values  (get_uuid(),v_client,v_org,v_user,v_user,v_level,v_cur.m_product_id,v_cur.m_productbom_id,v_cur.line,v_cur.bomqty,v_cur.rawmaterial,'N',v_processuid,v_cur.constuctivemeasure);
                else
                        insert into  ZSMF_BOMTREE (ZSMF_BOMTREE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, LEVEL, ASSEMBLY_ID, M_PRODUCT_ID, LINE, BOMQTY, DESCRIPTION, ISPROCESSED,process_uid,constuctivemeasure) 
                            values  (get_uuid(),v_client,v_org,v_user,v_user,v_level,v_cur.m_product_id,v_cur.m_productbom_id,v_cur.line,v_cur.bomqty,v_cur.rawmaterial,'Y',v_processuid,v_cur.constuctivemeasure);
                end if;
              END LOOP;
        END LOOP;
        v_level:=v_level+1;
        select count(*) into v_count from zsmf_bomtree where process_uid=v_processuid and  isprocessed='N';
        if v_count=0 then
           v_isready:='Y';
        end if;
     END LOOP;
     delete from zsmf_bomtree where level=0 and process_uid=v_processuid;
   IF TG_OP = 'DELETE' THEN 
      RETURN OLD; 
   ELSE 
      RETURN NEW; 
   END IF; 
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsmf_mproductbomtree_trg() OWNER TO tad;




CREATE OR REPLACE FUNCTION zsmf_product_bom_trg()
  RETURNS trigger AS
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
Part of Manufacturing
BOM
Reset Verification flag of parent
BOM-Modifications only on a not ready4production Product 
Set Business Partner and Value of Product
Always Trigger Verification, if any changes are made
*****************************************************/
v_issetready character varying;
v_value  character varying;
v_bpartner     character varying;     
v_type     character varying;    
v_ntype     character varying;
v_set     character varying;
v_cur record;
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;
  IF(TG_OP = 'INSERT' or TG_OP = 'UPDATE') THEN
      select substr(name,1,40),c_bpartner_id into v_value,v_bpartner from m_product where m_product.m_product_id=NEW.M_ProductBOM_ID;
      new.product_value:=v_value;
      new.c_bpartner_id:=v_bpartner;
      select typeofproduct into v_type from m_product where m_product_id=NEW.M_Product_ID;
      select typeofproduct into v_ntype  from m_product where m_product_id=NEW.M_ProductBOM_ID;
      select issetitem into v_set  from m_product where m_product_id=NEW.M_ProductBOM_ID;
      -- Sub-Assemblys may not contain other assemblys
      if (v_type='UA' and v_ntype in ('SA','AS')) or v_ntype='CD' then
           RAISE EXCEPTION '%', '@zsmf_SubAssemblysMayNotContainOtherAssemblys@';
      end if;
      if v_set='Y' then
           RAISE EXCEPTION '%', '@SetItemsMayNotBePartOfBOM@';
      end if;
  end if;
  IF(TG_OP = 'INSERT' or TG_OP = 'UPDATE') THEN
      select setready4production into v_issetready from m_product where m_product_id=new.m_product_id;
      if v_issetready='Y' then
          RAISE EXCEPTION '%', '@zsmf_NoModificationsOnReadyProductBOM@';
      else
          --  Always Trigger Verification, if any changes are made
          -- Verification will build a new bomtree
          UPDATE M_Product SET IsVerified='N' WHERE M_Product_ID=new.M_Product_ID AND IsVerified='Y';
          -- Update all dependents BOMs
          for v_cur in (select distinct m_product_id from m_product_bom where  m_productbom_id=new.m_product_id and  m_product_id!=new.m_product_id)
          LOOP
            UPDATE M_Product SET IsVerified='N' WHERE M_Product_ID=v_cur.m_product_id AND IsVerified='Y';
          END LOOP;
      end if;
 END IF;
 IF TG_OP = 'DELETE' THEN 
   select setready4production into v_issetready from m_product where m_product_id=old.m_product_id;
   if v_issetready='Y' then
          RAISE EXCEPTION '%', '@zsmf_NoModificationsOnReadyProductBOM@';
   end if;
   RETURN OLD; 
 ELSE 
   RETURN NEW; 
 END IF; 
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

/**************************************************************************************************************************************+


Product Enhancements for Manufacturing Implementation 

* Ready for Production Process
* Checks on Requirements for Product
* SET setready4production: 

- Product Read Only Attributes (in GUI)
- Attachments not modifyable
- Copy Product - Process available




***************************************************************************************************************************************/
 
CREATE OR REPLACE FUNCTION zsmf_setready4production(p_PInstance_ID character varying) RETURNS void
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
Part of Manufacturing
Set a Product ready for Production
*****************************************************/
v_message character varying:='Success';
v_Record_ID  character varying;
v_User    character varying;
v_bom    character varying;
v_bomvery    character varying;
v_locator    character varying;
v_count numeric;
BEGIN 
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    -- Restrictions
    select isbom,isverified,coalesce(m_locator_id,'N') into v_bom,v_bomvery,v_locator from m_product where m_product_id=v_Record_ID;
    if (v_bomvery='N') then
        RAISE EXCEPTION '%', '@zsmf_NoBomVeryfieNoReady4Prod@';
    end if;
    if v_locator='N' then
       RAISE EXCEPTION '%', '@zsmf_MustHaveLocatorNoReady4Prod@';
    end if;
    -- Not ready for Prod. Items in BOM?
    select count(*) into v_count from m_product where  m_product.setready4production='N' and m_product.typeofproduct in ('AS','SA','UA') and m_product_id in (select m_productbom_id from m_product_bom where m_product_id =v_Record_ID);
    if v_count>0 then
       RAISE EXCEPTION '%', '@zsmf_BOMHasAssemlyNotReady4Prod@';
    end if;
    -- Corrections on BOM, If meanwhile Sub-Assemblys have been modified..-> Fire Trigger - Trigger will build a new bomtree
    UPDATE m_product_bom set updated=now() where m_product_bom_id=(select max(m_product_bom_id) from m_product_bom where M_Product_ID=v_Record_ID);
    -- Set it ready..
    update m_product set setready4production='Y',isverified='Y' where m_product_id=v_Record_ID;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_message);
    return;
EXCEPTION
    WHEN OTHERS then
       v_message:= '@ERROR=' || SQLERRM;   
       --ROLLBACK;
       -- 0=failed
       PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message);
       return;
END;
$_$  LANGUAGE 'plpgsql';
     
alter function public.zsmf_setready4production(p_PInstance_ID character varying) owner to tad;  


CREATE OR REPLACE FUNCTION zsmf_product_trg()
  RETURNS trigger AS
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
Part of Manufacturing
BOM
  a ready4production Product must have a locator 
*****************************************************/
   v_isready character varying;
   v_cur RECORD;     
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;

  IF(TG_OP = 'UPDATE') THEN
      If new.m_locator_id is null and (new.setready4production='Y' or new.issetitem='Y') then 
        RAISE EXCEPTION '%', '@zsmf_AReadyProductBOMmustHaveLocator@';
      end if;
      if new.typeofproduct!='ST' and coalesce(new.cutoff,0)!=0 then
         RAISE EXCEPTION '%', '@zsmf_CutoffOnlyOnStandardProducts@';
      end if;
      if (new.isstocked='N' or new.producttype='S') and (select count(*) from m_storage_detail where m_product_id=new.m_product_id)>0 then
         RAISE EXCEPTION '%', '@CannotChangeStockedProduct@';
      end if;
      If old.typeofproduct='ST' and new.typeofproduct in ('CD','AS','SA','UA') then
         for v_cur in (select m_product_id  from m_product_bom where m_productbom_id= new.m_product_id)
         LOOP
           select setready4production into v_isready from m_product where m_product_id=v_cur.m_product_id;
           if v_isready='Y' then
              RAISE EXCEPTION '%', '@zsmf_CannotChangeTypeIsUsedInProd@';
           end if;
         END LOOP;
      end if;
  end if;
  RETURN NEW;  
END; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
 


CREATE OR REPLACE FUNCTION zsmf_c_file_trg()
  RETURNS trigger AS
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
Part of Manufacturing
BOM
A ready4production Product must not be modiofied
Attachments must be preserved. 
*****************************************************/
v_issetready character varying:='N';      
v_message character varying;
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;
   --@TODO: Get Message with correct Language
    select zssi_getText('zsmf_NoModificationsOnReadyProduct','de_DE') into v_message;
   if TG_OP = 'DELETE' THEN 
         if  old.ad_table_id='208' then
             select setready4production into v_issetready from m_product where m_product_id=old.ad_record_id;
         end if;
   else
         if  new.ad_table_id='208' then
             select setready4production into v_issetready from m_product where m_product_id=new.ad_record_id;
         end if;
   end if;  
   if v_issetready='Y' then
             RAISE EXCEPTION '%', v_message;
   end if;
   IF TG_OP = 'DELETE' THEN 
      RETURN OLD; 
   ELSE 
      RETURN NEW; 
   END IF; 
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsmf_c_file_trg() OWNER TO tad; 


CREATE OR REPLACE FUNCTION zsmf_copyproduct (
  p_product_id varchar,
  p_newkey varchar,
  p_newname varchar,
  p_user varchar,
  v_uid varchar
)
RETURNS varchar AS
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
Part of Manufacturing
Copy a Product
*****************************************************/

  v_count                 NUMERIC;
  v_now                   TIMESTAMP := now();

  v_message               VARCHAR := '';
  v_link                  VARCHAR;
 -- record buffer declaration
  v_product               m_product%ROWTYPE;
  v_product_trl           m_product_trl%ROWTYPE;
  v_product_trl_2         m_product_trl%ROWTYPE;
  v_product_bom           m_product_bom%ROWTYPE; -- 2 Bill of Materials / Stueckliste
  v_substitute            m_substitute%ROWTYPE; -- 3 Substitute / Ersatzartikel
  v_product_po            m_product_po%ROWTYPE; -- 4 Purchasing / Einkauf
  -- Trigger zssi_product_trg: INSERT m_costing / Kalkulation
  -- Trigger m_product_trg:    INSERT / UPDATE m_product_trl
  v_product_org           m_product_org%ROWTYPE; -- 5 Org Specific / Lagerplanung
  v_productprice          m_productprice%ROWTYPE; -- 6 Price / Preis
  v_product_uom           m_product_uom%ROWTYPE; -- UOM / Einheit
  v_product_acct          m_product_acct%ROWTYPE; -- Accouting / Kontierung

BEGIN
  IF ( isempty(p_product_id) ) THEN
    RAISE EXCEPTION '% % % ',  '@InvalidArguments@', 'p_product_id', COALESCE(p_product_id, ''); -- GOTO EXCEPTION
  END IF;
  IF ( isempty(p_newkey) and (select c_getconfigoption('autoproductvaluesequence',(select ad_org_id from m_product where m_product_id=p_product_id)))='N') THEN
    RAISE EXCEPTION '% % % ',  '@InvalidArguments@', 'p_newkey', COALESCE(p_newkey	, ''); -- GOTO EXCEPTION
  END IF;
  IF ( isempty(p_newname) ) THEN
    RAISE EXCEPTION '% % % ', '@InvalidArguments@', 'p_newname', COALESCE(p_newname, ''); -- GOTO EXCEPTION
  END IF;
  IF ( isempty(v_uid) ) THEN
    RAISE EXCEPTION '% % % ',  '@InvalidArguments@', 'v_uid', COALESCE(v_uid, ''); -- GOTO EXCEPTION
  END IF;

  select count(*) into v_count from m_product where m_product_id = p_product_id;
  if (v_count > 0) then
    select count(*) into v_count from m_product where name = p_newname or value=p_newkey;
    if (v_count > 0) then
      RAISE EXCEPTION '%', '@zsse_SearchKeyOrNameTwice@' || ' ' || p_newkey || ', ' || p_newname; -- @zsse_DatasetTwice@
    end if;

 -- part 1.A/09: m_product
    SELECT * INTO v_product FROM m_product WHERE m_product_id = p_product_id; -- read record into rowtype-buffer
    IF isempty(v_product.m_product_id) THEN
      RAISE EXCEPTION '%', '@ProductIdNotFound@'; -- GOTO EXCEPTION
    END IF;

    -- Unique changes before insert, all other changes after inserting, because of triggers
    v_product.m_product_id := v_uid;
    v_product.created := v_now;
    v_product.createdby := p_user;
    v_product.updated := v_now;
    v_product.updatedby := p_user;
    v_product.value := p_newkey; -- Search Key / unique name required
    v_product.name := p_newname;
    v_product.isVerified := 'N';          -- reset
    v_product.setReady4Production := 'N'; -- reset relevant to zsmf_product_bom_trg()

   -- insert via %rowtype
    INSERT INTO m_product SELECT v_product.*; -- %rowtype / (trg: INSERT INTO m_costing, trg: INSERT INTO m_product_trl)

-- part 1.B/09: m_product_trl / Uebersetzung

    FOR v_product_trl IN (SELECT * FROM m_product_trl WHERE m_product_trl.m_product_id = p_product_id) -- %rowtype-buffer;
    LOOP
      -- Unique changes before insert, all other changes use update statement because of triggers
      v_product_trl.m_product_id := v_uid;
      v_product_trl.created := v_now;
      v_product_trl.createdby := p_user;
      v_product_trl.updated := v_now;
      v_product_trl.updatedby := p_user;
      IF (LENGTH(TRIM(v_product_trl.name)) < 60) THEN
        v_product_trl.name := TRIM(v_product_trl.name) || '''';
      END IF;
      IF (LENGTH(TRIM(v_product_trl.documentnote)) < 2000) THEN
        v_product_trl.documentnote := TRIM(v_product_trl.documentnote) || '''';
      END IF;
      IF (LENGTH(TRIM(v_product_trl.documentnote)) < 2000) THEN
        v_product_trl.documentnote := TRIM(v_product_trl.documentnote) || '''';
      END IF;
      IF (LENGTH(TRIM(v_product_trl.description)) < 2000) THEN
        v_product_trl.description := TRIM(v_product_trl.description) || '''';
      END IF;

     -- a: add i.e chinese, if language is not system-language and translation not inserted by trigger
      IF (NOT EXISTS
        (SELECT 1 FROM m_product_trl trl
         WHERE trl.m_product_id = v_product_trl.m_product_id
           AND trl.ad_language = v_product_trl.ad_language)) THEN

        v_product_trl.m_product_trl_id := get_uuid();
        INSERT INTO m_product_trl SELECT v_product_trl.*; -- %rowtype
      ELSE
     -- b: update generated translations inserted by trigger with original translations
        UPDATE m_product_trl SET
              name = v_product_trl.name,
              documentnote = v_product_trl.documentnote,
              description = v_product_trl.description
        WHERE
              m_product_trl.m_product_id = v_uid
          AND m_product_trl.ad_language = v_product_trl.ad_language; -- Systemsprache
      END IF;
    END LOOP;

-- part 2/09: m_product_bom / Stueckliste
    FOR v_product_bom IN (SELECT * FROM m_product_bom WHERE m_product_bom.m_product_id = p_product_id) -- %rowtype-buffer;
    LOOP
      -- Unique changes before insert, all other changes use update statement because of triggers
      v_product_bom.m_product_bom_id := get_uuid();
      v_product_bom.m_product_id := v_uid;
      v_product_bom.created := v_now;
      v_product_bom.createdby := p_user;
      v_product_bom.updated := v_now;
      v_product_bom.updatedby := p_user;
      INSERT INTO m_product_bom SELECT v_product_bom.*; -- %rowtype
    END LOOP;

-- part 3/09: Substitute / Ersatzartikel
    FOR v_substitute IN (SELECT * FROM m_substitute WHERE m_substitute.m_product_id = p_product_id) -- %rowtype-buffer;
    LOOP
      -- Unique changes before insert, all other changes use update statement because of triggers
      v_substitute.m_substitute_id := get_uuid();
      v_substitute.m_product_id := v_uid;
      v_substitute.created := v_now;
      v_substitute.createdby := p_user;
      v_substitute.updated := v_now;
      v_substitute.updatedby := p_user;
      INSERT INTO m_substitute SELECT v_substitute.*; -- %rowtype
    END LOOP;

-- part 4/09: Purchasing / Einkauf
    FOR v_product_po IN (SELECT * FROM m_product_po WHERE m_product_po.m_product_id = p_product_id) -- %rowtype-buffer;
    LOOP
      -- Unique changes before insert, all other changes use update statement because of triggers
      v_product_po.m_product_po_id := get_uuid();
      v_product_po.m_product_id := v_uid;
      v_product_po.created := v_now;
      v_product_po.createdby := p_user;
      v_product_po.updated := v_now;
      v_product_po.updatedby := p_user;
      INSERT INTO m_product_po SELECT v_product_po.*; -- %rowtype / (trg: update m_product set c_bpartner_id=v_vendor, vendorproductno=v_vproductno)
    END LOOP;

-- part 5/09: Org Specific / Lagerplanung
    FOR v_product_org IN (SELECT * FROM m_product_org WHERE m_product_org.m_product_id = p_product_id) -- %rowtype-buffer;
    LOOP
      -- Unique changes before insert, all other changes use update statement because of triggers
      v_product_org.m_product_org_id := get_uuid();
      v_product_org.m_product_id := v_uid;
      v_product_org.created := v_now;
      v_product_org.createdby := p_user;
      v_product_org.updated := v_now;
      v_product_org.updatedby := p_user;
      INSERT INTO m_product_org SELECT v_product_org.*; -- %rowtype
    END LOOP;

-- part 6/09: Price / Preis
    FOR v_productprice IN (SELECT * FROM m_productprice WHERE m_productprice.m_product_id = p_product_id) -- %rowtype-buffer;
    LOOP
      -- Unique changes before insert, all other changes use update statement because of triggers
      v_productprice.m_productprice_id := get_uuid();
      v_productprice.m_product_id := v_uid;
      v_productprice.created := v_now;
      v_productprice.createdby := p_user;
      v_productprice.updated := v_now;
      v_productprice.updatedby := p_user;
      INSERT INTO m_productprice SELECT v_productprice.*; -- %rowtype / UNIQUE (m_pricelist_version_id, m_product_id)
    END LOOP;

-- part 7/09: UOM / Einheit
    FOR v_product_uom IN (SELECT * FROM m_product_uom WHERE m_product_uom.m_product_id = p_product_id) -- %rowtype-buffer;
    LOOP
      -- Unique changes before insert, all other changes use update statement because of triggers
      v_product_uom.m_product_uom_id := get_uuid();
      v_product_uom.m_product_id := v_uid;
      v_product_uom.created := v_now;
      v_product_uom.createdby := p_user;
      v_product_uom.updated := v_now;
      v_product_uom.updatedby := p_user;
      INSERT INTO m_product_uom SELECT v_product_uom.*; -- %rowtype
    END LOOP;

-- part 8/09: Accouting / Kontierung
    FOR v_product_acct IN (SELECT * FROM m_product_acct WHERE m_product_acct.m_product_id = p_product_id) -- %rowtype-buffer;
    LOOP
      -- Unique changes before insert, all other changes use update statement because of triggers
      v_product_acct.m_product_acct_id := get_uuid();
      v_product_acct.m_product_id := v_uid;
      v_product_acct.created := v_now;
      v_product_acct.createdby := p_user;
      v_product_acct.updated := v_now;
      v_product_acct.updatedby := p_user;
      INSERT INTO m_product_acct SELECT v_product_acct.*; -- %rowtype
    END LOOP;

 -- part 9/09: finally update for inserted record / excecute update-trigger: UPDATE m_product_trl SET name = new.name
    UPDATE m_product SET buttonCopyItem = 'Y' WHERE m_product.m_product_id = v_uid; -- set button as used, just for documentation

 -- enhance return-parameter with link to copied record
    v_message = '@zsse_SuccessfullCopyProduct@' || ': ' || p_newname; -- vgl. ad_message
    v_link := (SELECT zsse_htmldirectlink('../Product/Product_Relation.html', 'document.frmMain.inpmProductId', v_uid, p_newname));
    v_message := v_message  || '</br>' || v_link;
  ELSE
     RAISE EXCEPTION '%', '@zsse_DataNotExists@';
  END if;
  ---- <<FINISH_PROCESS>>
  --  Update AD_PInstance
  RAISE NOTICE '%','Copy Product - Finished ok: ' || p_newname ;

  RETURN 'SUCCESS' || ' ' || v_message;
EXCEPTION
    WHEN OTHERS then
       RETURN SQLERRM;
END;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION zsmf_copyproductfiles(p_fromproduct_id character varying, p_toproductid character varying, p_user character varying) RETURNS character varying
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
Copy a Product - File Entrys in C_File
*****************************************************/

v_count numeric;
BEGIN 
    select count(*) into v_count from m_product where m_product_id=p_fromproduct_id;
    if v_count>0 then
          insert into c_file (C_FILE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, NAME, C_DATATYPE_ID, SEQNO, TEXT, AD_TABLE_ID, AD_RECORD_ID)
                 select get_uuid(),AD_CLIENT_ID,AD_ORG_ID, ISACTIVE, now(),p_user,now(),p_user,NAME,C_DATATYPE_ID, SEQNO, TEXT, AD_TABLE_ID,p_toproductid
                 from c_file where AD_RECORD_ID=p_fromproduct_id;
    else
       RAISE EXCEPTION '%', '@zsse_DataNotExists@';
    end if;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Copy Product - Files Finished';
    return 'SUCCESS';
EXCEPTION
    WHEN OTHERS then
       return SQLERRM;        
END;
$_$  LANGUAGE 'plpgsql';
     
alter function public.zsmf_copyproductfiles(p_fromproduct_id character varying, p_toproductid character varying, p_user character varying) owner to tad;  
 
 





/**************************************************************************************************************************************+

Manufactring


Project Implementation

* Material Management Impementation









***************************************************************************************************************************************/
CREATE or replace FUNCTION zsmf_CheckProductBOMRecursive(p_product character varying,p_bomProduct varchar) returns VOID
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
v_cur2 record;
v_count numeric;
BEGIN
  -- All Worksteps that produce the actual BOM Product
  for v_cur in (select c_projecttask_id,value from c_projecttask where c_project_id is null and m_product_id=p_bomProduct)
  LOOP
    for v_cur2 in (select m_product_id from zspm_projecttaskbom where c_projecttask_id=v_cur.c_projecttask_id)
    LOOP
        --The Product in the BOM of a workstep that produces actual BOM Product is The Product that is Produced in Actual Workstep. This is a recursion!
        IF v_cur2.m_product_id=p_product then
             RAISE EXCEPTION '%', '@zsmf_BOMHasRecoursion@'||zssi_getproductname(v_cur2.m_product_id,'de_DE')||'-Workstep:'||v_cur.value;
        END IF;
        PERFORM zsmf_CheckProductBOMRecursive(p_Product,v_cur2.m_product_id);
    END LOOP;
  END LOOP;
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
  
CREATE OR REPLACE FUNCTION zsmf_projecttaskbom_trg ()
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
Contributor(s): MH
***************************************************************************************************************************************************
Restriction-Trigger for Production BOM
*****************************************************/
v_count numeric;
v_isrec varchar;
v_isclosed varchar;
v_pcategory varchar;
v_product varchar;
v_value varchar;
BEGIN
-- RAISE EXCEPTION '% = %', TG_NAME, TG_OP;
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF;

  IF TG_OP = 'DELETE' then
	if old.qtyreserved!=0 or old.qtyreceived!=0 or old.qtyinrequisition!=0 then
		RAISE EXCEPTION '%', 'Material wurde bereits geplant. Erst Materialreservierungen/Bedarfe/Entnahmen stornieren. Dann kann hier geloescht werden.';
	end if;
  end if; 
  
  IF TG_OP != 'DELETE' then
      select count(*) into v_count from m_product where (isactive!='Y' or isstocked!='Y' or Producttype!='I') and m_product_id=new.m_product_id;
      if v_count!=0 then
         RAISE EXCEPTION '%', '@zsmf_InPlanMatOnlyActiveStockedItems@';
      end if;
      select m_product_id,value into v_product,v_value from c_projecttask where c_projecttask_id=new.c_projecttask_id and assembly='Y';
      if coalesce(v_product,'')=new.m_product_id then
         RAISE EXCEPTION '%', '@zsmf_BOMHasRecoursion@ in Workstep:'||v_value;
      end if;
      BEGIN
        PERFORM zsmf_CheckProductBOMRecursive(v_product,new.m_product_id);
      EXCEPTION
        WHEN OTHERS THEN
           RAISE EXCEPTION '%', '@zsmf_BOMHasRecoursion@-'||zssi_getproductname(v_product,'de_DE');
      END;
      -- Calculate actual planned amt
      if new.isreturnafteruse='N' then
        new.plannedamt:=coalesce(m_get_product_cost(new.m_product_id,to_date(now()),null,new.ad_org_id)*new.quantity,0);
      else
         new.plannedamt:=0;
      end if;
      select count(*) into v_count from snr_masterdata snr,ma_machine m where m.snr_masterdata_id=snr.snr_masterdata_id
                      and m.ismovedinprojects='Y' and snr.m_product_id=new.m_product_id;
      if v_count>0 then
        if new.description!='Generated by Production->Get Machine from Stock' or new.quantity!=0 or new.isreturnafteruse!='Y' or new.planrequisition='Y' then
            RAISE EXCEPTION '%', '@zsmf_CannotmodifyMachineProducts@';
        end if;
      end if;
                      
      IF (TG_OP = 'UPDATE') THEN 
        /*
        SELECT COUNT(*) INTO v_count FROM c_projecttask WHERE IsMaterialDisposed='Y' AND c_projecttask_id = NEW.c_projecttask_id;
        IF old.qtyinrequisition>0 AND NEW.qtyinrequisition=old.qtyinrequisition AND NEW.qtyreceived=old.qtyreceived AND (v_count != 0) THEN
            RAISE EXCEPTION '%', 'Material wurde bereits geplant. Erst Bedarfe stornieren. Dann kann hier editiert werden.';
        END IF;
        */  
        SELECT t.istaskcancelled,t.iscomplete,p.projectcategory INTO v_isrec,v_isclosed,v_pcategory 
        FROM c_projecttask t,c_project p where p.c_project_id=t.c_project_id and c_projecttask_id=new.c_projecttask_id;
        IF (v_isrec = 'Y') OR (v_isclosed = 'Y')  THEN
          if (abs(NEW.qtyreceived) > abs(OLD.qtyreceived)) or new.m_product_id!=old.m_product_id or new.m_locator_id!=old.m_locator_id or
            new.issuing_locator!=old.issuing_locator or new.receiving_locator!=old.receiving_locator or old.quantity !=new.quantity or new.isreturnafteruse!=old.isreturnafteruse
          then 
            RAISE EXCEPTION '%','@zspm_OnLyReturnsAreAllowedOnClosedWorksteps@';
          end if;
        END IF;
      END IF; -- TG_OP = 'UPDATE'
      RETURN NEW;
  end if; 
END;
$body$
LANGUAGE 'plpgsql';



CREATE OR REPLACE FUNCTION zsmf_createproductionbom(p_pinstance_id character varying)
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
Part of Manufacturing
Creates a Production-BOM for a specific Product
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_org  character varying;
v_client  character varying;
v_product character varying;
v_pwareh character varying;
v_qty numeric;
v_warehouse character varying;
v_type character varying;
v_ptype character varying;
v_isstocked character varying;
v_prod character varying;
v_message  character varying:= 'Materialplanung erstellt.';
v_ualist character varying;
v_qtyua numeric:=1;
v_i numeric:=1;
v_cutoff numeric;
v_count numeric;
v_prec numeric;
-- Define Dynamic Cursor
v_sql character varying;
TYPE_Ref REFCURSOR;
v_cursor TYPE_Ref%TYPE;
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
    -- Select Assembly-Product
    --Check if Project-Warehouse and Product Warehouse are identical!!!!!!!!!
    select m_product.m_product_id,m_locator.m_warehouse_id,c_projecttask.qty into v_product,v_pwareh,v_qty from m_product,c_projecttask,m_locator where 
                                                          c_projecttask.m_product_id=m_product.m_product_id and m_product.m_locator_id=m_locator.m_locator_id and c_projecttask_id=v_Record_ID;
    select c_project.m_warehouse_id,c_project.ad_client_id,c_project.ad_org_id into v_warehouse,v_client,v_org
           from c_project,c_projecttask 
           where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=v_Record_ID;
    if v_warehouse!=v_pwareh then
       RAISE EXCEPTION '%', '@zsmf_ProductWareHouseAndProjectWarehouseDiffer@';
    end if;
    select count(*) into v_count from zspm_projecttaskbom where (qtyreceived>0 or qtyinrequisition>0) and c_projecttask_id=v_Record_ID;
    if v_count>0 then
        RAISE EXCEPTION '%', '@zsmf_NoModificationsOnReadyPBOM@';
    end if;
    -- Copy from Product-BOM to Production-BOM
    delete from zspm_projecttaskbom where c_projecttask_id=v_Record_ID;
    -- First select the main Assembly
    v_ualist:=chr(39)||v_product||chr(39);
    -- The query: First form: Qty from projecttask
    v_sql:='select * from m_product_bom a where m_product_id in (';
    -- As long as assemblys are there
	select count(*) into v_count from m_product_bom where v_product=m_product_bom.m_product_id;
    WHILE (v_ualist!='' and v_count!=0)
    LOOP 
        RAISE NOTICE '%','XXXXXXOuter Loop, UA:'||coalesce(v_ualist,'NOUALIST')||' II:'||v_i;
        OPEN v_cursor FOR EXECUTE v_sql||v_ualist||')';
        LOOP
		  FETCH v_cursor INTO v_cur;
		  EXIT WHEN NOT FOUND;
		  RAISE NOTICE '%','Begin Inner Loop, UA:'||v_ualist||' III:'||v_i;
          -- Prepare the Cursor - Var for the next level (only on 1st. loop)
          if v_i=1 then v_ualist:=''; end if;
          v_i:=v_i+1;
          -- Do only Plan Items that are Stocked.
          select typeofproduct,production,coalesce(cutoff,0),isstocked,producttype into v_type,v_prod,v_cutoff,v_isstocked,v_ptype from m_product where m_product_id=v_cur.m_productbom_id;
          if v_ptype='I' and v_isstocked='Y' then 
                -- If we are in Sub-Assemblys, take qty from cursor (Multiply it with qty of Main-Assembly)
                if v_cur.m_product_id!=v_product then
                    v_qtyua:= v_cur.pqty;
                end if;
                -- All Material From the Product-BOM of these Assemblys in ualist are  Copied to the Task one by one
                insert into zspm_projecttaskbom(ZSPM_PROJECTTASKBOM_ID, C_PROJECTTASK_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_PRODUCT_ID, QTY_PLAN,cutoff,quantity,constuctivemeasure,rawmaterial,line)
                    values (get_uuid(),v_Record_ID,v_client,v_org,'Y',now(),v_user,now(),v_user,v_cur.m_productbom_id,v_qty*v_qtyua*v_cur.bomqty,
                            v_cutoff,(v_qty*v_qtyua*v_cur.bomqty)+(v_qty*v_qtyua*v_cur.bomqty)*v_cutoff/100,v_cur.constuctivemeasure,v_cur.rawmaterial,v_cur.line);
                -- Material from Sub-Assemblys Produced in this Task are later in the next level done by cursor
                if v_type='UA' and v_prod='Y' then
                  -- Append list of sub-assemblys for the next level
                  -- Be shure of Quanity this Assembly has in Bom where it is used.
                  -- Therefore we take the BOM-Position ID and loop with it through corsor later..
                  if v_ualist!='' then v_ualist:=v_ualist||','; end if;
                  v_ualist:=v_ualist||chr(39)||v_cur.m_product_bom_id||chr(39);
                end if;
                --RAISE NOTICE '%','End Inner Loop, UA:'||v_ualist||' III:'||v_i;
          end if;
        END LOOP;
        CLOSE v_cursor;
        v_i:=1;
        -- The query: Second form (Sub-assemblys): Qty from BOM (selfjoin)
        v_sql:='select a.m_productbom_id,a.bomqty,a.constuctivemeasure,a.rawmaterial,b.bomqty as pqty,a.m_product_id,a.m_product_bom_id from m_product_bom a , m_product_bom b
             where b.m_productbom_id=a.m_product_id and b.m_product_bom_id in (';
    END LOOP;
    -- If we have multiple lines of the same material in this Production-BOM
    -- This material is combined together in one line
    for v_cur in (select M_PRODUCT_ID, sum(QUANTITY) as qty,max(cutoff) as cutoff,sum(QTY_PLAN) as qty_plan from zspm_projecttaskbom where C_PROJECTTASK_ID = v_Record_ID group by M_PRODUCT_ID having count(*)>1)
    LOOP
         delete from zspm_projecttaskbom where C_PROJECTTASK_ID = v_Record_ID and M_PRODUCT_ID=v_cur.M_PRODUCT_ID;
         select c_uom.stdprecision into v_prec from c_uom, m_product where m_product.c_uom_id=c_uom.c_uom_id and m_product.m_product_id=v_cur.M_PRODUCT_ID;
         insert into zspm_projecttaskbom(ZSPM_PROJECTTASKBOM_ID, C_PROJECTTASK_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_PRODUCT_ID, QTY_PLAN,cutoff,quantity)
              values (get_uuid(),v_Record_ID,v_client,v_org,'Y',now(),v_user,now(),v_user,v_cur.m_product_id,v_cur.qty_plan,v_cur.cutoff,round(v_cur.qty,v_prec));
    END LOOP;
    perform zsmf_preplanmaterial(v_Record_ID,v_User);
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
ALTER FUNCTION zsmf_createproductionbom(character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zsmf_preplanmaterialprocess(p_pinstance_id character varying)
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
Part of Manufacturing
Copy Items from Task to Internal-Consumption
  Only Items that where Requested by Requisition and are on stock yet.
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message  character varying:= 'Materialplanung erstellt.';

BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    perform zsmf_preplanmaterial(v_Record_ID,v_User);
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


CREATE OR REPLACE FUNCTION zsmf_preplanmaterial(p_PROJECTTASK_ID character varying,p_user character varying)
  RETURNS void AS
$BODY$ 
DECLARE 
v_qtyavail numeric;
v_qtyinstock numeric;
v_cur RECORD;
v_cur2 RECORD;
v_locator character varying;
v_warehouse  character varying;
v_first  character varying;
v_rest numeric:=0;
v_qty numeric;
v_uom character varying;
BEGIN
   select c_project.m_warehouse_id into v_warehouse
           from c_project,c_projecttask 
           where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=p_PROJECTTASK_ID;
   for v_cur in (select * from zspm_projecttaskbom where C_PROJECTTASK_ID =p_PROJECTTASK_ID)
   LOOP
        -- 1st strategy: Get mat from default locator
        select m_locator_id,c_uom_id into v_locator,v_uom from m_product where m_product_id=v_cur.m_product_id;
        select coalesce(QTYONHAND,0) as qtyinstock,coalesce(QTYONHAND,0) as qtyavail into v_qtyinstock,v_qtyavail from m_storage_detail where m_product_id=v_cur.m_product_id and C_UOM_ID=v_uom and 
                                                            m_locator_id = v_locator;
        if v_cur.quantity-v_cur.qtyreserved-v_cur.qtyreceived <= coalesce(v_qtyavail,0) and
           (select m_warehouse_id from m_locator where m_locator_id=v_locator) = v_warehouse then
           -- everything fine
           update zspm_projecttaskbom set m_locator_id=v_locator where zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id;
        else
        -- 2nd strategy: Always get from fullest stocks (minimize lines in Planning) 
            v_rest:=v_cur.quantity-v_cur.qtyreserved-v_cur.qtyreceived;
            v_first:='Y';
            for v_cur2 in (select coalesce(QTYONHAND,0) as qtyinstock,coalesce(QTYONHAND,0) as qtyavail,m_locator_id  from m_storage_detail where m_product_id=v_cur.m_product_id and C_UOM_ID=v_uom and 
                                                            m_locator_id in (select m_locator_id from m_locator where m_warehouse_id=v_warehouse)
                                                            and coalesce(QTYONHAND,0) >0
                                                            order by qtyavail desc)
            LOOP
                if v_rest<=v_cur2.qtyavail then 
                     v_qty:=v_rest; 
                     v_rest:=0;
                else 
                     v_qty:=v_cur2.qtyavail;
                     v_rest:=v_rest-v_cur2.qtyavail;
                end if;
                if v_first='Y' then 
                   update zspm_projecttaskbom set m_locator_id=v_cur2.m_locator_id,quantity=v_qty where zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id; 
                   v_first:='N';
                else
                   insert into zspm_projecttaskbom(ZSPM_PROJECTTASKBOM_ID, C_PROJECTTASK_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, 
                                                   M_PRODUCT_ID, QTY_PLAN,cutoff,quantity,constuctivemeasure,rawmaterial,m_locator_id)
                   values (get_uuid(),p_PROJECTTASK_ID,v_cur.ad_client_id,v_cur.ad_org_id,'Y',now(),p_user,now(),p_user,
                             v_cur.m_product_id,v_cur.QTY_PLAN,v_cur.cutoff,v_qty,v_cur.constuctivemeasure,v_cur.rawmaterial,v_cur2.m_locator_id);
                end if;
                if v_rest=0 then
                  exit;
                end if;
            END LOOP;
            -- Rest in Req.
            if v_rest!=0 and v_first='N' then
                insert into zspm_projecttaskbom(ZSPM_PROJECTTASKBOM_ID, C_PROJECTTASK_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, 
                                                   M_PRODUCT_ID, QTY_PLAN,cutoff,quantity,constuctivemeasure,rawmaterial,planrequisition)
                   values (get_uuid(),p_PROJECTTASK_ID,v_cur.ad_client_id,v_cur.ad_org_id,'Y',now(),p_user,now(),p_user,
                             v_cur.m_product_id,v_cur.QTY_PLAN,v_cur.cutoff,v_rest,v_cur.constuctivemeasure,v_cur.rawmaterial,'Y');
            end if;
            if v_rest!=0 and v_first='Y' then
                update zspm_projecttaskbom set planrequisition='Y',m_locator_id=null where zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id; 
            end if;
        end if;          
   END LOOP;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zsmf_getlocatorWithStock(p_projecttask_id varchar,p_product_ID character varying)
  RETURNS varchar AS
$BODY$ 
DECLARE 
v_qtyavail numeric;
v_qtyinstock numeric;
v_warehouse varchar;
v_locator varchar;
v_locator2 varchar;
v_uom     varchar;
BEGIN
    select c_project.m_warehouse_id into v_warehouse
           from c_project,c_projecttask 
           where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=p_PROJECTTASK_ID;
    select m_locator_id,c_uom_id into v_locator,v_uom from m_product where m_product_id=p_product_ID;
    -- First take the standard Locator
    select coalesce(QTYONHAND,0) as qtyavail into v_qtyavail from m_storage_detail 
                                                                                 where m_product_id=p_product_ID and C_UOM_ID=v_uom and 
                                                                                       m_locator_id = v_locator;
    -- Second any Locator in the warehouse.
    select coalesce(QTYONHAND,0) as qtyinstock,m_locator_id into v_qtyinstock,v_locator2 from m_storage_detail where m_product_id=p_product_ID and C_UOM_ID=v_uom and 
                                                            m_locator_id in (select m_locator_id from m_locator where m_warehouse_id=v_warehouse)
                                                            and coalesce(QTYONHAND,0) >0
                                                            order by v_qtyinstock desc limit 1;
    --. Test which one to use.                                                        
    if  coalesce(v_qtyavail,0)>0 and
       (select m_warehouse_id from m_locator where m_locator_id=v_locator) = v_warehouse then
             return v_locator;
    elsif coalesce(v_qtyinstock,0)>0 then
             return v_locator2;
    else
             return null;
    end if;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION zsmf_disposematerial(p_pinstance_id character varying)
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
Part of Projects, Dispose the complete BOM of the Task in Inventory (Obsolete)
                  Creates PR's if necessary - Only Purpose: Creation of Requisitions
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message character varying:='@RequisitionWithoutLines@';
v_cur     RECORD;
v_qtyonhand numeric;
v_count numeric;
v_warehouse character varying;
v_locator character varying;
v_uom character varying;
v_att character varying;
v_vendor character varying;
v_pricelist character varying;
v_description character varying;
v_price numeric;
v_project character varying;
v_isreqheader character varying:='N';
v_typeofproduct character varying;
v_isproduction character varying;
v_requid  character varying;
v_needdate timestamp without time zone;
v_line numeric:=10;
v_seq character varying;
v_lang character varying;
v_pstatus character varying;
v_vendorproductno character varying;
v_isoutsource character varying;
v_qty2reserve numeric:=0;
v_qty2requisition numeric:=0;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    -- Language for Messages
    select default_ad_language into v_lang from ad_user where ad_user_id=v_User;
    select c_project.m_warehouse_id,c_project.c_project_id,coalesce(c_projecttask.startdate,trunc(now())),c_project.projectstatus into v_warehouse,v_project ,v_needdate,v_pstatus
           from c_project,c_projecttask 
           where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=v_Record_ID;
    if v_pstatus!='OR'  then
         RAISE EXCEPTION '%', '@zsmf_YouNeedtoStrtProjectToPlanMat@';
    end if;
    if v_warehouse is null then
         RAISE EXCEPTION '%', '@zsmf_YouNeedaWarehousetoPlanMat@';
    end if;
    select outsourcing into v_isoutsource  from c_projecttask where c_projecttask.c_projecttask_id=v_Record_ID;
    select count(*) into v_count from zspm_projecttaskbom where c_projecttask_id=v_Record_ID;
    if v_count=0 and v_isoutsource='N' then
       RAISE EXCEPTION '%', '@zsmf_NoBomNoMatPlan@';
    end if;
 
    -- Plan REQUISITIONS
    for v_cur in (select * from zspm_projecttaskbom where zspm_projecttaskbom.c_projecttask_id=v_Record_ID and quantity>0 and planrequisition='Y' and qtyinrequisition=0)
    LOOP
         -- Need Requisition
         if v_cur.qtyreserved<v_cur.quantity-v_cur.qtyreceived and v_cur.qtyinrequisition=0 then
            v_qty2requisition:=v_cur.quantity-v_cur.qtyreserved-v_cur.qtyreceived;
            RAISE NOTICE '%','Requisition:'||v_cur.m_product_id||',qty:'||v_cur.quantity||',Onhand:'||v_qtyonhand||',U:'||v_User;
            -- If assembly: Test If it is produced by a step  in this Project and In Time, Otherwise No Disposition Possible
            -- Outsourced Assemblys may get in requisition
         
            -- Take standad vendor from m_product_po, if none, take any vendor.
            select c_bpartner_id,pricepo,vendorproductno into v_vendor,v_price,v_vendorproductno from m_product_po  where m_product_id=v_cur.m_product_id  and isactive='Y' and iscurrentvendor='Y' 
                   order by qualityrating desc limit 1;
            if v_vendor is null then
                 select c_bpartner_id,pricepo,vendorproductno into v_vendor,v_price,v_vendorproductno from m_product_po  where m_product_id=v_cur.m_product_id  and isactive='Y'   limit 1;
            end if;
            select po_pricelist_id into v_pricelist from c_bpartner where c_bpartner_id=v_vendor;
            select c_uom_id into v_uom from m_product where m_product_id=v_cur.m_product_id;
            if v_pricelist is null then 
                 select m_pricelist_id into v_pricelist from m_pricelist where issopricelist='N' and isactive='Y' order by isdefault desc limit 1;
            end if;
            -- If not on Stock and no Assembly -> Open an PR
            if v_isreqheader='N' then
                -- Create requisition
                select ad_sequence_doc('DocumentNo_M_Requisition',v_cur.ad_org_ID,'Y') into v_seq from dual;
                select get_uuid() into v_requid from dual;
                insert into m_requisition(M_REQUISITION_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, DESCRIPTION, DOCUMENTNO, C_PROJECT_ID, C_PROJECTTASK_ID, ad_user_id,m_pricelist_id)
                      values (v_requid,v_cur.ad_client_ID, v_cur.ad_Org_ID, 'Y', now(),v_User,now(),v_User,zssi_getText('zsmf_GeneratedByPlanning', v_lang),v_seq,v_project,v_Record_ID, v_user,v_pricelist);
                v_isreqheader:='Y';
                v_Message:='@CreatedRequisition@: '|| zsse_htmlLinkDirectKey('../Requisition/Header_Relation.html',v_requid,v_seq)||' erstellt.</br>';
            end if;
            -- Take the Vendors Product no. and Product Descripotion
            select documentnote into v_description from m_product where m_product_id=v_cur.m_product_id;
            if v_vendorproductno is not null and v_description is not null then
              v_description:=zssi_getText('zssi_vendorproductno',v_lang)||' '||v_vendorproductno||chr(10)||v_description;
            elsif v_vendorproductno is not null and v_description is null then
              v_description:=zssi_getText('zssi_vendorproductno',v_lang)||' '||v_vendorproductno;
            else
              v_description:='';
            end if;
            --
            insert into m_requisitionline (M_REQUISITIONLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_REQUISITION_ID, M_PRODUCT_ID, QTY, C_UOM_ID, DESCRIPTION, 
                        internalnotes,
                        NEEDBYDATE, LINE, C_PROJECT_ID, C_PROJECTTASK_ID,c_bpartner_id,priceactual,m_pricelist_id,zspm_projecttaskbom_id,linenetamt)
                      values(get_uuid(),v_cur.ad_client_ID, v_cur.ad_Org_ID,now(),v_User,now(),v_User,v_requid,v_cur.m_product_id,v_qty2requisition,v_uom,v_description,
                              zssi_getText('zsmf_GeneratedByPlanning', v_lang),
                              coalesce(v_cur.date_plan,v_needdate),v_line,v_project,v_Record_ID,v_vendor,v_price,v_pricelist,v_cur.zspm_projecttaskbom_id, v_qty2requisition*v_price);
            v_line:=v_line+10;
            if v_isoutsource='N' then 
                update zspm_projecttaskbom set qtyinrequisition=qtyinrequisition+v_qty2requisition,updated=now(),updatedby=v_user where zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id;
            end if;
         end if; -- Requisition
      END LOOP;
	  UPDATE m_requisition set totalLines=(SELECT COALESCE(SUM(linenetamt),0) FROM m_requisitionline WHERE m_requisition_id = v_requid) where m_requisition_id = v_requid;

    if  v_isreqheader='Y' then
       -- close Req
      PERFORM m_requisition_post(v_requid);
      -- Set Task as disposed
      update c_projecttask set ismaterialdisposed='Y' where c_projecttask_id=v_Record_ID;
      --v_Message:=v_Message||'Um direkt in den Material-Einkauf zu gelangen, klicken Sie hier:'||zsse_htmlLinkDirectKey('../ad_forms/RequisitionToOrder.html',v_User,'Bedarf einkaufen');
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
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message);
  RETURN;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  


CREATE OR REPLACE FUNCTION zsmf_undisposematerial(p_pinstance_id character varying)
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
                  Voids PR's if necessary
Checks
*****************************************************/
v_Record_ID  character varying;
v_User    character varying;
v_message character varying:='';
v_cur     RECORD;
v_count numeric;
v_warehouse  character varying;
v_project character varying;
v_lang character varying;
v_cancelreq character varying:='N';
v_cannotcancelreq character varying:='N';
v_cancelmat character varying:='N';
v_uom character varying;
v_somthingdone character varying:='N';
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_Record_ID, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    select default_ad_language into v_lang from ad_user where ad_user_id=v_User;
    select c_project.m_warehouse_id,c_project.c_project_id into v_warehouse,v_project 
           from c_project,c_projecttask 
           where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=v_Record_ID;
    -- undispose mat.
    select count(*) into v_count from zspm_projecttaskbom where c_projecttask_id=v_Record_ID and qtyinrequisition>0;
    -- outsourcing?
    if coalesce(v_count,0)=0 then
       select count(*) into v_count from c_projecttask where c_projecttask_id=v_Record_ID and outsourcing='Y' and ismaterialdisposed='Y' and m_product_id is not null;
    end if;
    if coalesce(v_count,0)>0 then
       -- Req exists, Lines not Ordered
       for v_cur in (select distinct m_requisition.m_requisition_id,m_requisition.documentno,m_requisitionline.m_product_id,m_requisitionline.zspm_projecttaskbom_id from m_requisitionline,m_requisition where m_requisition.m_requisition_id=m_requisitionline.m_requisition_id 
                                                                 and m_requisitionline.c_project_id=v_project 
                                                                 and m_requisitionline.c_projecttask_id=v_Record_ID
                                                                 and m_requisition.docstatus='CO'
                                                                 and not exists (select 0 from m_requisitionorder where m_requisitionorder.m_requisitionline_id = m_requisitionline.m_requisitionline_id))
       LOOP
       -- Cancel not Ordered Req's
          -- PERFORM m_requisition_post(v_cur.m_requisition_id);
          update m_requisition set processed='N',docstatus='DR' where m_requisition_id=v_cur.m_requisition_id;
          delete from m_requisitionline where m_requisition_id=v_cur.m_requisition_id;
          delete from m_requisition   where m_requisition_id=v_cur.m_requisition_id;
          if v_cancelreq='N' then 
             v_message:=zssi_getText('zsmf_CancelledReq', v_lang);
             v_cancelreq:='Y';
          else 
             v_message:=v_message||',';
          end if;
          if instr(v_message,v_cur.documentno)=0 then v_message:=v_message||v_cur.documentno; end if;
          update zspm_projecttaskbom set qtyinrequisition=0 where zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id;
          v_somthingdone:='Y';
       END LOOP;
       -- Req exists, Lines Ordered
       for v_cur in (select distinct m_requisition.m_requisition_id,m_requisition.documentno from m_requisitionline,m_requisition where m_requisition.m_requisition_id=m_requisitionline.m_requisition_id 
                                                                 and m_requisitionline.c_project_id=v_project 
                                                                 and m_requisitionline.c_projecttask_id=v_Record_ID
                                                                 and exists (select 0 from m_requisitionorder where m_requisitionorder.m_requisitionline_id = m_requisitionline.m_requisitionline_id))
       LOOP
       -- Cannot Cancel Ordered Req's
          if v_cannotcancelreq='N' then 
             if v_message!='' then
                v_message:=v_message||'</br>';
             end if;
             v_message:=zssi_getText('zsmf_CannotCancelledReq', v_lang);
             v_cancelreq:='Y';
          else 
             v_message:=v_message||',';
          end if;
          if instr(v_message,v_cur.documentno)=0 then v_message:=v_message||v_cur.documentno; end if;
       END LOOP;
    END IF; -- Req's exists
    
      -- Set Task as undisposed
      update c_projecttask set ismaterialdisposed='N' where c_projecttask_id=v_Record_ID;
   -- else
   --   v_Message:=v_message||'Die Materialplanung kann nicht storniert werden. Alle Positionen wurde bereits geliefert bzw. bestellt.';
   -- end if;
    ---- <<FINISH_PROCESS>>
    --  Update AD_PInstance
    RAISE NOTICE '%','Updating PInstance - Finished ' || v_Message ;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_Message);
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
ALTER FUNCTION zsmf_undisposematerial(character varying) OWNER TO tad;





select zsse_dropfunction('zsmf_GetMaterialFromStock');
CREATE OR REPLACE FUNCTION zsmf_GetMaterialFromStock(v_projecttaskid character varying, v_user varchar) RETURNS varchar
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
Part of Manufactring

*****************************************************/
v_warehouse  character varying;
v_project  character varying;
v_locator  character varying;
v_client   character varying;
v_org      character varying;
v_cur      RECORD;
v_uom      character varying;
v_Message  character varying:='';
v_Result   numeric:=0;
v_Count    numeric;
v_qtyinconsum numeric;
v_qtyreturned numeric;
v_Line     numeric:=0;
v_Uid      character varying;
v_serial   varchar;
v_batch   varchar;
v_lineUUId varchar;
v_isserial boolean:=false;
v_DocumentNo varchar;
BEGIN 
     select c_project.m_warehouse_id,c_project.c_project_id,c_project.ad_client_id,c_project.ad_org_id into v_warehouse,v_project,v_client, v_org
           from c_project,c_projecttask 
           where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=v_projecttaskid;
    -- Eventually update Material Plan before Starting Transaction
    if (select c_getconfigoption('projectmatpanautowhengetmat',v_Org))='Y' then
       PERFORM zsmf_preplanmaterial(v_projecttaskid,v_user);
    end if;
    -- Prepare Material Consumption
    --select count(*) into v_Count from zspm_projecttaskbom where c_projecttask_id=v_projecttaskid and quantity>qtyreceived and m_locator_id is not null and planrequisition='N' and qtyinrequisition=0;
    --if v_count>0 then
        select get_uuid() into v_uid;
        select ad_sequence_doc('Production',v_org,'Y') into v_DocumentNo;
        insert into M_INTERNAL_CONSUMPTION(M_INTERNAL_CONSUMPTION_ID, AD_CLIENT_ID, AD_ORG_ID,  CREATED, CREATEDBY, UPDATED, UPDATEDBY,
                    NAME, DESCRIPTION, MOVEMENTDATE,dateacct, C_PROJECT_ID, C_PROJECTTASK_ID,  MOVEMENTTYPE,DOCUMENTNO)
               values(v_uid,v_client,v_Org,NOW(), v_User, NOW(),v_User,
                      'Production-Process','Generated by Production->Get Material from Stock',now(),now(),v_project, v_projecttaskid,'D-',v_DocumentNo);
    --end if;
    -- Select all Reserved Material and all Assemblys goin into this Task
    for v_cur in (select * from zspm_projecttaskbom where c_projecttask_id=v_projecttaskid and quantity>qtyreceived and m_locator_id is not null and planrequisition='N' and qtyinrequisition=0)
    LOOP      
        -- uom
        select c_uom_id,isserialtracking,isbatchtracking into v_uom,v_serial,v_batch from m_product where m_product_id=v_cur.m_product_id;
        v_Line:=v_Line+10;
        select get_uuid() into v_lineUUId;
        insert into M_INTERNAL_CONSUMPTIONLINE(M_INTERNAL_CONSUMPTIONLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTION_ID, 
                                            M_LOCATOR_ID, M_PRODUCT_ID, LINE, MOVEMENTQTY, DESCRIPTION, C_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID,zspm_projecttaskbom_id)
                values (v_lineUUId,v_client,v_Org,NOW(), v_User, NOW(),v_User,v_uid,
                    v_cur.m_locator_id,v_cur.M_Product_ID,v_Line,v_cur.quantity-v_cur.qtyreceived,'Generated by Production->Get Material from Stock',v_uom,v_project, v_projecttaskid,v_cur.zspm_projecttaskbom_id);
        -- seruial Number Tracking?
        if v_serial='Y' or v_batch='Y' then
           v_isserial:=true;
           v_message:=v_message||zsse_htmlLinkDirectKey('../InternalMaterialMovements/Lines_Relation.html',v_lineUUId,'Serial Number Tracking')||'<br />';
        end if;
        if (select allownegativestock from ad_clientinfo where ad_client_id=v_cur.ad_client_id)='N' then
            if (select m_bom_qty_onhand(v_cur.m_product_id,null,v_cur.m_locator_id)) < (v_cur.quantity-v_cur.qtyreceived) then
                raise exception '%', '@NotEnoughStocked@';
            end if;
        end if;
    END LOOP;
    -- Take movable Machines into Workstep, if configured - First generate Messages for machines we cannot get....
    for v_cur in (select distinct snr.m_product_id,m.name,snr.serialnumber ,snr.m_locator_id,snr.c_projecttask_id
                      from zspm_ptaskmachineplan p,ma_machine m left join snr_masterdata snr on snr.snr_masterdata_id=m.snr_masterdata_id
                      where p.ma_machine_id=m.ma_machine_id and p.c_projecttask_id=v_projecttaskid and m.ismovedinprojects='Y')
    LOOP
        if v_cur.serialnumber is null then
             RAISE EXCEPTION '%', '@zspm_NoMachineTransactionPossibleSNRNeeded@'||v_cur.name;
            
        elsif v_cur.m_locator_id is null and coalesce(v_cur.c_projecttask_id,'') != v_projecttaskid then
             RAISE EXCEPTION '%', '@zspm_NoMachineTransactionPossibleMachineIsNotHere@'||v_cur.name||'-'||v_cur.serialnumber;
        elsif  v_cur.m_locator_id is not null then
            v_Line:=v_Line+10;
            select c_uom_id,isserialtracking,isbatchtracking into v_uom,v_serial,v_batch from m_product where m_product_id=v_cur.m_product_id;
            select get_uuid() into v_lineUUId;
            insert into M_INTERNAL_CONSUMPTIONLINE(M_INTERNAL_CONSUMPTIONLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTION_ID, 
                                                M_LOCATOR_ID, M_PRODUCT_ID, LINE, MOVEMENTQTY, DESCRIPTION, C_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID,zspm_projecttaskbom_id)
                    values (v_lineUUId,v_client,v_Org,NOW(), v_User, NOW(),v_User,v_uid,
                        v_cur.m_locator_id,v_cur.M_Product_ID,v_Line,1,'Generated by Production->Get Machine from Stock',v_uom,v_project, v_projecttaskid,null);
            insert into snr_INTERNAL_CONSUMPTIONLINE(snr_internal_consumptionline_id, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTIONLINE_ID,serialnumber)
                    values (get_uuid(),v_client,v_Org,NOW(), v_User, NOW(),v_User,v_lineUUId,v_cur.serialnumber);
        end if; 
    END LOOP;   
    -- no lines? - delete
    if v_Line=0 then
       delete from M_INTERNAL_CONSUMPTION where M_INTERNAL_CONSUMPTION_ID=v_uid;
       v_message:='@zssm_NoStockTransactionNeededAllMaterialGot@';
    else
       if v_isserial then
          v_message:=v_message||'@zssm_MaterialReceivedSerialRegistrationNeccessary@';
       else
          if (select c_getconfigoption('activateinternalconsumptionauto',v_Org))='Y' then
                PERFORM m_internal_consumption_post(v_uid);
                select result,errormsg into v_result, v_message from ad_pinstance where ad_pinstance_id=v_uid;          
                if v_result!=1 then
                    RAISE EXCEPTION '%',v_message ;
                end if;
          end if;
          v_message:='@zssm_MaterialReceivedCompleteInWorkstep@'||zsse_htmlLinkDirectKey('../InternalMaterialMovements/InternalMaterialMovements_Relation.html',v_uid,v_DocumentNo);
       end if;
    end if;
    RETURN v_message;
END;
$_$  LANGUAGE 'plpgsql';
       
CREATE OR REPLACE FUNCTION zsmf_GetMaterialFromStockService(p_pinstance_id character varying) RETURNS void
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
Part of Manufactring

*****************************************************/

v_Message  character varying:='';
v_projecttaskid varchar;
v_User varchar;
BEGIN 
     --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID into v_projecttaskid, v_User from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_projecttaskid is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_projecttaskid:=p_PInstance_ID;
       select updatedby into v_User from c_projecttask where c_projecttask_id=v_projecttaskid;
    end if;
     select zsmf_GetMaterialFromStock(v_projecttaskid,v_User) into v_message;
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1 , v_Message) ;
    RETURN;
EXCEPTION
WHEN OTHERS THEN
  v_message:= '@ERROR=' || SQLERRM;
  RAISE NOTICE '%',v_message ;
  PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message) ;
  RETURN;
END;
$_$  LANGUAGE 'plpgsql';

select zsse_dropfunction('zsmf_SendMaterialOnStock');

CREATE OR REPLACE FUNCTION zsmf_SendMaterialOnStock(p_projecttask_id character varying, v_User_ID character varying) RETURNS varchar
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
Part of Manufactring
Send the produced material on stock
*****************************************************/

v_product                 character varying;
v_uom                     character varying;
v_locator                 character varying;
v_qty                     numeric;
v_project                 character varying;
v_client                  character varying;
v_org                     character varying;
v_costofassemlys          numeric;
v_costoftask              numeric;
v_itemcost                numeric;
v_method                  character varying;
v_cost_id                 character varying;
v_permanent               character varying;
v_uid                     character varying;
v_curr_onhand_qty         numeric;
v_actual_cost             numeric;
v_curr_cost               numeric;
v_Result                  numeric;
v_dummy                   character varying;
v_message                 varchar:='';
v_projecttask_name        varchar;
-- RECORD
v_cur record;
v_serial   varchar;
v_batch   varchar;
v_DocumentNo varchar;
v_lineUUId varchar;
BEGIN 
    select c_project.c_project_id into v_project
           from c_project,c_projecttask 
           where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=p_projecttask_id;
    select m_product_id,qty,ad_client_id,ad_org_id,name into v_product,v_qty,v_client,v_org,v_projecttask_name from c_projecttask where  c_projecttask_id=p_projecttask_id;
    select c_uom_id,m_locator_id,isserialtracking,isbatchtracking into v_uom,v_locator,v_serial,v_batch from m_product where m_product_id=v_product;
    if v_product is null then
        return '';
    end if;
    if v_locator is null then
       raise exception '%', 'Es muß für das Produzierte Gut ein Lagerort definiert werden (unter Stammdaten/Artikel)';
    end if;
    -- Do the Stock Transaction
    if v_product is not null and coalesce(v_qty,0)!=0 then
        -- First Update Costs
        select zspm_updateprojectstatus() into v_dummy;
        -- Actual Production Cost Of this ITEM
        -- If there Assemblys in Bom of this Task that are Produced in other Tasks of this Project, get the Costs from them
        select sum(coalesce(m_get_product_cost(zspm_projecttaskbom.m_product_id,to_date(now()),null,v_org)*zspm_projecttaskbom.quantity,0)) into v_costofassemlys  from zspm_projecttaskbom,c_projecttask
               where zspm_projecttaskbom.m_product_id=c_projecttask.m_product_id
                     and zspm_projecttaskbom.qtyreserved=0
                     and zspm_projecttaskbom.c_projecttask_id = p_projecttask_id
                     and c_projecttask.c_projecttask_id != p_projecttask_id
                     and c_projecttask.c_project_id=v_project;
        --
        -- Get Cost of this Task itself
        select coalesce(actualcost,0)/v_qty into v_costoftask from c_projecttask where c_projecttask_id=p_projecttask_id;
        -- Actual Production Cost Of this ITEM
        v_itemcost:=coalesce(v_costofassemlys,0)+v_costoftask;
        -- If Product is an Assembly used in The Project itself, Do not send on Stock.
        for v_cur in (select * from zspm_projecttaskbom where m_product_id=v_product and c_projecttask_id in 
                       (select c_projecttask_id from c_projecttask where c_projecttask.c_project_id= v_project))
        loop    
             v_qty:=v_qty-v_cur.quantity;
             -- Do not apply cost, this is done implicit and automatically in the Production-Task of this Item
             update zspm_projecttaskbom set qtyreceived=v_cur.quantity,actualcosamount=0 where  zspm_projecttaskbom_id=v_cur.zspm_projecttaskbom_id;
             v_message:=v_message||'@zssm_MaterialBookedAutomatictoNextWorkstep@'||zsse_htmlLinkDirectKeyGridView('../org.openbravo.zsoft.project.Projects/MaterialDisposition0F6DE779327E4790A3A9A11779D0713D_Relation.html',v_cur.zspm_projecttaskbom_id,v_projecttask_name)||'<br />';
        end loop;        
        -- Current-Cost from costing table
        select m_costing_id,ispermanent,COSTTYPE,COST into v_cost_id, v_permanent,   v_method, v_curr_cost from m_costing where M_PRODUCT_ID=v_product and DATETO =
                                                         (select max(DATETO) from m_costing where M_PRODUCT_ID=v_product);
        -- Update the Costing-Table
        -- Current onhand Quantities
        select COALESCE(sum(qtyonhand),0) into v_curr_onhand_qty from m_storage_detail where m_product_id=v_product;
        -- Calculation of Costs
        if v_method='ST' then
            v_actual_cost:=v_itemcost;
        ELSE 
          IF v_method='AV' THEN
              -- Cost Calculation only Works with Positive Stcks- No minus-qty allowed
              IF (v_curr_onhand_qty+v_qty>=0) and v_curr_onhand_qty>=0 THEN
                  v_actual_cost:=((v_curr_cost*v_curr_onhand_qty)+(v_itemcost*v_qty))/(v_curr_onhand_qty+v_qty);
                  --RAISE NOTICE '%','CurCost: '||v_curr_cost||' v_curr_onhand_qty : '||v_curr_onhand_qty||' v_purchase_price: '||v_purchase_price||' v_movementqty: '||v_movementqty||' v_actual_cost: '||v_actual_cost;
              ELSE
                  v_actual_cost:=v_itemcost; 
              END IF;
            END IF;
        END IF;
        IF v_permanent='N' and v_actual_cost!=0 then
            update m_costing set DATETO=now() where m_costing_id=v_cost_id;
            insert into m_costing (M_COSTING_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY,  M_PRODUCT_ID, DATEFROM, DATETO, ISMANUAL,   COSTTYPE,  COST,isproduction)
                  values(get_uuid(),v_client,v_org, now(), v_User_ID, now(), v_User_ID, v_product,now(),to_date('01.01.9999','dd.mm.yyyy'),'N',v_method,v_actual_cost,'Y');
        END IF;
        -- If Product is an Assembly all used in The Project itself, Do not send on Stock.
        if v_qty>0 then
            -- Prepare Stock Transaction (reservation)
            -- Insert Material-Consumption(This Triggers Accounting!)
            select get_uuid() into v_uid;
            select ad_sequence_doc('Production',v_org,'Y') into v_DocumentNo;
            insert into M_INTERNAL_CONSUMPTION(M_INTERNAL_CONSUMPTION_ID, AD_CLIENT_ID, AD_ORG_ID,  CREATED, CREATEDBY, UPDATED, UPDATEDBY,
                    NAME, DESCRIPTION, MOVEMENTDATE, C_PROJECT_ID, C_PROJECTTASK_ID,  MOVEMENTTYPE,DOCUMENTNO,DATEACCT)
               values(v_uid,v_client,v_Org,NOW(), v_User_ID, NOW(),v_User_ID,
                      'Production-Process','Generated by Production->Send produced Material on Stock',now(),v_project,p_projecttask_id,'P+',v_DocumentNo,trunc(now())); 
            -- Material Consumption Line
            select get_uuid() into v_lineUUId;
            insert into M_INTERNAL_CONSUMPTIONLINE(M_INTERNAL_CONSUMPTIONLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTION_ID, 
                                                  M_LOCATOR_ID, M_PRODUCT_ID, LINE, MOVEMENTQTY, DESCRIPTION, C_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID)
                  values (v_lineUUId,v_client,v_org,NOW(), v_User_ID, NOW(),v_User_ID,v_uid,
                          v_locator,v_product,10,v_qty,'Generated by Production->Send Material on Stock',v_uom,v_project, p_projecttask_id);
            -- seruial Number Tracking?
           if v_serial='Y'  or v_batch='Y' then
            v_message:=v_message||zsse_htmlLinkDirectKey('../InternalMaterialMovements/Lines_Relation.html',v_lineUUId,'Serial Number Tracking')||'<br />'||'@zssm_MaterialSendToStockSerialRegistrationNeccessary@';
           else
            if (select c_getconfigoption('activateinternalconsumptionauto',v_Org))='Y' then
                PERFORM m_internal_consumption_post(v_uid);
                select result,errormsg into v_result, v_message from ad_pinstance where ad_pinstance_id=v_uid;          
                if v_result!=1 then
                    RAISE EXCEPTION '%',v_message ;
                end if;
            end if;
            v_message:='@zssm_MaterialSendToStockSucessfully@'||zsse_htmlLinkDirectKey('../InternalMaterialMovements/InternalMaterialMovements_Relation.html',v_uid,v_DocumentNo);
           end if;
        end if;
        if v_qty<0 then
           RAISE EXCEPTION '%', '@zsmf_CannotPlanMatAssembyNotPlannedYet@';
        end if;
    end if;
    return v_message;
END;
$_$  LANGUAGE 'plpgsql';
     


CREATE OR REPLACE FUNCTION zsmf_cpItemFromTask(p_pinstance_id character varying)
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
Part of Manufacturing
Copy Items from Task to Internal-Consumption
  Only Items that where Requested by Requisition and are on stock yet.
*****************************************************/
v_Record_ID  character varying;
v_ProjecttaskID character varying;
v_User    character varying;
v_org  character varying;
v_client  character varying;
v_qty numeric;
v_warehouse character varying;
v_project character varying;
v_message  character varying:= 'Success';
v_qtyonhand numeric;
v_line numeric;
v_prod character varying;
v_locator character varying;
v_uom character varying;
v_recqty numeric;
-- RECORD
v_cur record;
BEGIN
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_client_id,i.ad_org_id into v_Record_ID, v_User,v_client,v_org from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    select c_projecttask_id into v_ProjecttaskID from m_internal_consumption where m_internal_consumption_id=v_Record_ID;
    select c_project.m_warehouse_id,c_project.c_project_id into v_warehouse,v_project
           from c_project,c_projecttask 
           where c_project.c_project_id=c_projecttask.c_project_id and c_projecttask.c_projecttask_id=v_ProjecttaskID;
    -- Get the Line
    select max(line) into v_line from M_INTERNAL_CONSUMPTIONLINE where M_INTERNAL_CONSUMPTION_ID=v_Record_ID;
    if v_line is null then v_line:=10; end if;
    -- See if there is mat to fetch...
    for v_cur in (select * from zspm_projecttaskbom where c_projecttask_id=v_ProjecttaskID  and qtyreceived<quantity)
    loop
      select c_uom_id into v_uom from m_product where m_product_id=v_cur.m_product_id;
        --Get Stock QTY
      select coalesce(QTYONHAND,0)-coalesce(preqtyonhand,0) as qtyavail,m_locator_id into v_qtyonhand,v_locator from m_storage_detail where m_product_id=v_cur.m_product_id and C_UOM_ID=v_uom and 
                                                            m_locator_id in (select m_locator_id from m_locator where M_WAREHOUSE_ID=v_warehouse) and
                                                            coalesce(QTYONHAND,0)-coalesce(preqtyonhand,0) >= 0 LIMIT 1;
      if v_qtyonhand >0 then
          if v_qtyonhand>v_cur.quantity-v_cur.qtyreceived then
               v_recqty:=v_cur.quantity-v_cur.qtyreceived;
          else
               v_recqty:=v_qtyonhand;
          end if;
          delete  from M_INTERNAL_CONSUMPTIONLINE  where M_INTERNAL_CONSUMPTION_ID=v_Record_ID and C_PROJECT_ID= v_project and C_PROJECTTASK_ID=v_cur.c_projecttask_id and M_PRODUCT_ID=v_cur.m_product_id;
          insert into M_INTERNAL_CONSUMPTIONLINE(M_INTERNAL_CONSUMPTIONLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTION_ID, 
                                                  M_LOCATOR_ID, M_PRODUCT_ID, LINE, MOVEMENTQTY, DESCRIPTION, C_UOM_ID, C_PROJECT_ID, C_PROJECTTASK_ID)
                  values (get_uuid(),v_client,v_org,NOW(), v_User, NOW(),v_User,v_Record_ID,
                          v_locator,v_cur.m_product_id,v_line,v_recqty,'Projektaufgabe: Material aus Materialplanung',v_uom,v_project, v_cur.c_projecttask_id);
          v_line:=v_line+10;
          select name into v_prod from m_product where m_product_id=v_cur.m_product_id;
          v_message:=v_message||', '||v_prod||':'||v_cur.quantity;
      end if;
    END LOOP;
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
ALTER FUNCTION zsmf_cpItemFromTask(character varying) OWNER TO tad;




CREATE OR REPLACE FUNCTION zsmf_mintconsumption_trg()
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
Restriction-Trigger for Internal-Consumption
*****************************************************/
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF;
  IF TG_OP != 'DELETE' then
      if TG_OP = 'UPDATE' then
         if old.processing!=new.processing or old.processed!=new.processed or old.posted!=new.posted then
            RETURN NEW;
         end if;
      end if;
      if new.processed='Y' or new.posted='Y' then
          RAISE EXCEPTION '%', 'Document processed/posted' ; 
      end if;
      RETURN NEW;
  else
      if old.processed='Y' or old.posted='Y' then
          RAISE EXCEPTION '%', 'Document processed/posted' ; 
      end if;
      RETURN OLD;
  end if; 
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsmf_mintconsumption_trg() OWNER TO tad;

CREATE OR REPLACE FUNCTION zsmf_mintconsumptionline_trg()
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
Trigger for Internal-Consumption
Performs Reservation Cancelling
On Production Transaction this is not done! 
*****************************************************/
v_posted character varying;
v_processed character varying;
v_movementtype  character varying;
V_STOCKED       NUMERIC;
v_MOVEMENTQTY   NUMERIC;
v_QUANTITYORDER NUMERIC;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF;
  IF TG_OP != 'DELETE' then
      select processed,posted into v_processed,v_posted from m_internal_consumption where m_internal_consumption_id=new.m_internal_consumption_id;
      if v_posted='Y' or v_processed='Y' then
          IF TG_OP = 'UPDATE' then
           if coalesce(old.reinvoicedby_id,'n') = coalesce(new.reinvoicedby_id,'n') and coalesce(old.zspm_projecttaskbom_id,'n') = coalesce(new.zspm_projecttaskbom_id,'n') then
              RAISE EXCEPTION '%', 'Document processed/posted' ; 
           end if;
          end if;
          if TG_OP = 'INSERT' then
             RAISE EXCEPTION '%', 'Document processed/posted' ; 
          end if;
          RETURN NEW;
      end if;
  else
      select processed,posted into v_processed,v_posted from m_internal_consumption where m_internal_consumption_id=old.m_internal_consumption_id;
      if v_posted='Y' or v_processed='Y' then
          RAISE EXCEPTION '%', 'Document processed/posted' ;
          RETURN OLD; 
      end if;
  end if; 
  --
  -- Updating inventory
  IF TG_OP = 'UPDATE' OR TG_OP = 'DELETE' THEN
    SELECT COUNT(*) INTO V_STOCKED  FROM M_PRODUCT  WHERE M_Product_ID=OLD.M_PRODUCT_ID  AND IsStocked='Y'  AND ProductType='I';
    select movementtype into v_movementtype from M_Internal_Consumption where M_Internal_Consumption_id=old.M_Internal_Consumption_ID;
    IF V_STOCKED > 0   THEN
      v_MOVEMENTQTY:= case v_movementtype when 'D-' then OLD.MOVEMENTQTY else OLD.MOVEMENTQTY*-1 end;
      v_QUANTITYORDER:= case v_movementtype when 'D-' then OLD.QUANTITYORDER else OLD.QUANTITYORDER*-1 end;
      PERFORM M_UPDATE_INVENTORY(OLD.AD_CLIENT_ID, OLD.AD_ORG_ID, OLD.UPDATEDBY, OLD.M_PRODUCT_ID, OLD.M_LOCATOR_ID, OLD.M_ATTRIBUTESETINSTANCE_ID, OLD.C_UOM_ID, OLD.M_PRODUCT_UOM_ID, NULL, NULL, NULL, v_MOVEMENTQTY, v_QUANTITYORDER) ;
    END IF;
    If TG_OP = 'DELETE' THEN RETURN OLD; END IF;
  END IF;
  IF TG_OP = 'INSERT' OR TG_OP = 'UPDATE' THEN
    SELECT COUNT(*)  INTO V_STOCKED   FROM M_PRODUCT   WHERE M_Product_ID=NEW.M_PRODUCT_ID  AND IsStocked='Y'  AND ProductType='I';
    select movementtype into v_movementtype from M_Internal_Consumption where M_Internal_Consumption_id=new.M_Internal_Consumption_ID;
    IF V_STOCKED > 0  THEN
      v_MOVEMENTQTY:= case v_movementtype when 'D-' then NEW.MOVEMENTQTY*-1 else NEW.MOVEMENTQTY end;
      v_QUANTITYORDER:= case v_movementtype when 'D-' then NEW.QUANTITYORDER*-1 else NEW.QUANTITYORDER end;
      PERFORM M_UPDATE_INVENTORY(NEW.AD_CLIENT_ID, NEW.AD_ORG_ID, NEW.UPDATEDBY, NEW.M_PRODUCT_ID, NEW.M_LOCATOR_ID, NEW.M_ATTRIBUTESETINSTANCE_ID, NEW.C_UOM_ID, NEW.M_PRODUCT_UOM_ID, NULL, NULL, NULL, v_MOVEMENTQTY, v_QUANTITYORDER) ;
    END IF;
    RETURN NEW;
  END IF;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zsmf_mintconsumptionline_trg() OWNER TO tad;



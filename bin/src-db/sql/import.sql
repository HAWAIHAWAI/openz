CREATE OR REPLACE FUNCTION i_pricelist(p_pinstance_id character varying)
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
Part of Order Process
     Generates Orders (SO or PO) from Offer or Quotation's
*****************************************************/

  v_ResultStr character varying:=''; 
  v_Record_ID character varying; 
  v_User character varying; 
  v_Message character varying:=''; 
  v_Client_ID character varying; 
  v_Org_ID character varying; 
  v_cur RECORD;
  v_pricelist_id character varying; 
  v_plv_id character varying; 
  v_prodid character varying; 
  v_count numeric;
  v_impcount numeric:=0;
BEGIN 
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_client_id,i.ad_org_id into v_Record_ID, v_User,v_Client_ID,v_Org_ID from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    
    for v_cur in (select * from i_pricelist where isimported='N' and isactive='Y')
    LOOP
        select count(*) into v_count from m_pricelist where name=v_cur.plistname;
        if v_count!=1 then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Pricelist not found. / Not exactly matching: '||v_cur.plistname; 
        else
           select m_pricelist_id into v_pricelist_id from m_pricelist where name=v_cur.plistname;
        end if;
        select count(*) into v_count from m_pricelist_version where m_pricelist_id=v_pricelist_id and name=v_cur.plistversionname;
        if v_count!=1 then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Pricelist-Version not found. / Not exactly matching: '||v_cur.plistversionname; 
        else
           select m_pricelist_version_id,ad_org_id,ad_client_id into v_plv_id,v_Org_ID,v_Client_ID from m_pricelist_version where m_pricelist_id=v_pricelist_id and name=v_cur.plistversionname;
        end if;
        select count(*)  into v_count from m_product where value=v_cur.productvalue;
        if v_count!=1 then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Product not found: '||v_cur.productvalue; 
        else
           select m_product_id into v_prodid from m_product  where value=v_cur.productvalue;
        end if;
        if substr(v_Message,1,5)!='ERROR' then
           select count(*) into v_count from m_productprice where m_pricelist_version_id=v_plv_id and m_product_id=v_prodid;
           if v_count=1 then
              update m_productprice set updated=now(),updatedby=v_User,pricelist=v_cur.pricelist,pricestd=v_cur.pricestd,pricelimit=v_cur.pricelimit  where m_pricelist_version_id=v_plv_id and m_product_id=v_prodid;
           else
              insert into m_productprice(M_PRODUCTPRICE_ID, M_PRICELIST_VERSION_ID, M_PRODUCT_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, PRICELIST, PRICESTD, PRICELIMIT)
                     values(get_uuid(),v_plv_id,v_prodid,v_Client_ID,v_Org_ID,v_User,v_User,v_cur.pricelist,v_cur.pricestd,v_cur.pricelimit);
           end if;
           v_impcount:=v_impcount+1;
        end if;
    END LOOP;
    
    if instr(v_Message,'ERROR')=0 then
           v_Message:=to_char(v_impcount)||' Items Successfully Imported';
           update i_pricelist set isimported='Y' where isactive='Y';
           PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N',1, v_Message) ;
    else
           PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_Message) ;
    end if;
    RETURN; 
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

 
CREATE OR REPLACE FUNCTION i_user(p_pinstance_id character varying)
  RETURNS void AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Import User Process - Imports Users form i_user table into ad_user table
*****************************************************/

  v_ResultStr character varying:=''; 
  v_Record_ID character varying; 
  v_User character varying; 
  v_Message character varying:=''; 
  v_Client_ID character varying; 
  v_Org_ID character varying; 
  v_cur RECORD;
  v_user_id character varying; 
  v_count numeric;
  v_impcount numeric:=0;
  v_weiter character varying:='N';
BEGIN 
    --  Update AD_PInstance
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    SELECT i.Record_ID, i.AD_User_ID,i.ad_client_id,i.ad_org_id into v_Record_ID, v_User, v_Client_ID, v_Org_ID from AD_PINSTANCE i WHERE i.AD_PInstance_ID=p_PInstance_ID;
    if v_Record_ID is null then
       RAISE NOTICE '%','Pinstance not found-Using as RecordID ' || p_PInstance_ID;
       v_Record_ID:=p_PInstance_ID;
       v_User:='0';
    end if;
    
    for v_cur in (select * from i_user where isimported='N' and isactive='Y')
    LOOP
        select count(*) into v_count from ad_user where name=v_cur.name;
        if v_count=1 then 
                        select ad_user_id into v_user_id from ad_user where ad_user.name=v_cur.name;
        else
            insert into ad_user (ad_user_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, name)
                                                values  (get_uuid(), v_Client_ID, v_Org_ID, 'Y', now(), v_User, now(), v_User, v_cur.name);
                        select ad_user_id into v_user_id from ad_user where ad_user.name=v_cur.name;
        end if;
                
                if v_cur.c_bpartner_id is null or v_cur.c_bpartner_id=''  then
                    v_Message:=v_Message||E'\r\n'||'ERROR: Business Partner is mandatory for '||v_cur.name; 
        end if;         
                select count(*) into v_count from c_bpartner where name=v_cur.c_bpartner_id;
        if v_count<1 and v_cur.c_bpartner_id is not null then 
           --v_Message:=v_Message||E'\r\n'||'Business Partner not found: '||v_cur.c_bpartner_id||' for '||v_cur.name; 
           v_weiter:='Y';
        end if;
                select count(*) into v_count from ad_user where name=v_cur.supervisor_id;
        if v_count!=1 and v_cur.supervisor_id is not null then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Supervisor not found: '||v_cur.supervisor_id||' for '||v_cur.name; 
        end if;
                select count(*) into v_count from c_bpartner_location where name=v_cur.c_bpartner_location_id;
        if v_count!=1 and v_cur.c_bpartner_location_id is not null then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Location not found: '||v_cur.c_bpartner_location_id||' for '||v_cur.name; 
        end if;
                select count(*) into v_count from c_greeting where name=v_cur.c_greeting_id;
        if v_count!=1 and v_cur.c_greeting_id is not null then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Greeting not found: '||v_cur.c_greeting_id||' for '||v_cur.name; 
        end if;
                select count(*) into v_count from ad_client where name=v_cur.default_ad_client_id;
        if v_count!=1 and v_cur.default_ad_client_id is not null then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Default Client not found: '||v_cur.default_ad_client_id||' for '||v_cur.name; 
        end if;
                select count(*) into v_count from ad_language where name=v_cur.default_ad_language;
        if v_count!=1 and v_cur.default_ad_language is not null then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Default Client not found: '||v_cur.default_ad_language||' for '||v_cur.name; 
        end if;
                select count(*) into v_count from ad_org where name=v_cur.default_ad_org_id;
        if v_count!=1 and v_cur.default_ad_org_id is not null then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Default Client not found: '||v_cur.default_ad_org_id||' for '||v_cur.name; 
        end if;
                select count(*) into v_count from ad_role where name=v_cur.default_ad_role_id;
        if v_count!=1 and v_cur.default_ad_role_id is not null then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Default Client not found: '||v_cur.default_ad_role_id||' for '||v_cur.name; 
        end if;
                select count(*) into v_count from m_warehouse where name=v_cur.default_m_warehouse_id;
        if v_count!=1 and v_cur.default_m_warehouse_id is not null then 
           v_Message:=v_Message||E'\r\n'||'ERROR: Default Client not found: '||v_cur.default_m_warehouse_id||' for '||v_cur.name; 
        end if;
                
                if instr(v_Message, 'ERROR')=0 and v_weiter='N' then                
                        update ad_user set         
                        
                                ad_client_id = case when v_cur.c_bpartner_id!='' then (select ad_client_id from c_bpartner where name=v_cur.c_bpartner_id   limit 1) else ad_client_id end,
                                ad_org_id= case when v_cur.c_bpartner_id!='' then (select ad_org_id from c_bpartner where name=v_cur.c_bpartner_id   limit 1) else ad_org_id end,
                                isactive='Y',
                                updated=now(),
                                updatedby=v_User,
                               
                                                                                        
                                password= case  when v_cur.password='' then (select password from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.password='*del*' then ''
                                                                else v_cur.password end,

                                username= case  when v_cur.username='' then (select username from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.username='*del*' then ''
                                                                else v_cur.username end,
                                                                                        
                                email= case     when v_cur.email='' then (select email from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.email='*del*' then ''
                                                        else v_cur.email end,
                                 
                                description= case       when v_cur.description='' then (select description from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.description='*del*' then ''
                                                                        else v_cur.description end,
                                                       
                                supervisor_id= case     when v_cur.supervisor_id='' then (select supervisor_id from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.supervisor_id='*del*' then ''
                                                                        else (select ad_user_id from ad_user where name=v_cur.supervisor_id) end,
                                                                                        
                                c_bpartner_id= case     when v_cur.c_bpartner_id='' then (select c_bpartner_id from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.c_bpartner_id='*del*' then ''
                                                                        else (select c_bpartner_id from c_bpartner where name=v_cur.c_bpartner_id limit 1) end,
                                                                                        
                                emailuser= case         when v_cur.emailuser='' then (select emailuser from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.emailuser='*del*' then ''
                                                                else v_cur.emailuser end,
                                                                                        
                                emailuserpw= case       when v_cur.emailuserpw='' then (select emailuserpw from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.emailuserpw='*del*' then ''
                                                                        else v_cur.emailuserpw end,
                                                                                        
                                c_bpartner_location_id= case when v_cur.c_bpartner_location_id='' then (select c_bpartner_location_id from ad_user where ad_user_id=v_user_id)
                                                                                        when v_cur.c_bpartner_location_id='*del*' then ''
                                                                                        else (select c_bpartner_location_id from c_bpartner_location where name=v_cur.c_bpartner_location_id  limit 1) end,
                                                                                        
                                c_greeting_id= case     when v_cur.c_greeting_id='' then (select c_greeting_id from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.c_greeting_id='*del*' then ''
                                                                        else (select c_greeting_id from c_greeting where name=v_cur.c_greeting_id  limit 1) end,
                                                                                        
                                title= case     when v_cur.title='' then (select title from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.title='*del*' then ''
                                                        else v_cur.title end,
                                                                                        
                                comments= case  when v_cur.comments='' then (select comments from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.comments='*del*' then ''
                                                                else v_cur.comments end,
                                                                
                                phone= case     when v_cur.phone='' then (select phone from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.phone='*del*' then ''
                                                        else v_cur.phone end,
                                                        
                                phone2= case when v_cur.phone2='' then (select phone2 from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.phone2='*del*' then ''
                                                        else v_cur.phone2 end,
                                                        
                                fax=    case    when v_cur.fax='' then (select fax from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.fax='*del*' then ''
                                                        else v_cur.fax end,
                                
                                lastcontact=v_cur.lastcontact,
                                                                        
                                lastresult= case        when v_cur.lastresult='' then (select lastresult from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.lastresult='*del*' then ''
                                                                else v_cur.lastresult end,
                                                                
                                birthday=v_cur.birthday,
                                                                        
                                firstname= case when v_cur.firstname='' then (select firstname from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.firstname='*del*' then ''
                                                                else v_cur.firstname end,
                                                                
                                lastname= case  when v_cur.lastname='' then (select lastname from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.lastname='*del*' then ''
                                                                else v_cur.lastname end,
                                
                               
                                                                
                                default_ad_client_id= case      when v_cur.default_ad_client_id='' then (select default_ad_client_id from ad_user where ad_user_id=v_user_id)
                                                                                        when v_cur.default_ad_client_id='*del*' then ''
                                                                                        else (select ad_client_id from ad_client where name=v_cur.default_ad_client_id) end,
                                                                                        
                                default_ad_language= case       when v_cur.default_ad_language='' then (select default_ad_language from ad_user where ad_user_id=v_user_id)
                                                                                        when v_cur.default_ad_language='*del*' then ''
                                                                                        else (select ad_language_id from ad_language where name=v_cur.default_ad_language) end,
                                                                                        
                                default_ad_org_id= case when v_cur.default_ad_org_id='' then (select default_ad_org_id from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.default_ad_org_id='*del*' then ''
                                                                                else (select ad_org_id from ad_org where name=v_cur.default_ad_org_id) end,
                                                                                
                                default_ad_role_id= case        when v_cur.default_ad_role_id='' then (select default_ad_role_id from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.default_ad_role_id='*del*' then ''
                                                                                else (select ad_role_id from ad_role where name=v_cur.default_ad_role_id) end,
                                                                                
                                default_m_warehouse_id= case    when v_cur.default_m_warehouse_id='' then (select default_m_warehouse_id from ad_user where ad_user_id=v_user_id)
                                                                                                when v_cur.default_m_warehouse_id='*del*' then ''
                                                                                                else (select m_warehouse_id from m_warehouse where name=v_cur.default_m_warehouse_id) end,
                                                                                                
                                enumber=        case    when v_cur.enumber='' then (select enumber from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.enumber='*del*' then ''
                                                                else v_cur.enumber end,
                                                                
                                branche=        case    when v_cur.branche='' then (select branche from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.branche='*del*' then ''
                                                                else v_cur.branche end,
                                                                
                                land= case      when v_cur.land='' then (select land from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.land='*del*' then ''
                                                        else v_cur.land end,
                                                        
                                kunde= case     when v_cur.kunde='' then (select kunde from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.kunde='*del*' then ''
                                                        else v_cur.kunde end,
                                                        
                                klinikkunde= case       when v_cur.klinikkunde='' then (select klinikkunde from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.klinikkunde='*del*' then ''
                                                                        else v_cur.klinikkunde end,
                                                                        
                                stippvisitenkunde= case when v_cur.stippvisitenkunde='' then (select stippvisitenkunde from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.stippvisitenkunde='*del*' then ''
                                                                                else v_cur.stippvisitenkunde end,
                                                        
                                mailingzielgruppe= case when v_cur.mailingzielgruppe='' then (select mailingzielgruppe from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.mailingzielgruppe='*del*' then ''
                                                                                else v_cur.mailingzielgruppe end,
                                                                                
                                geschaeftsfuehrer= case when v_cur.geschaeftsfuehrer='' then (select geschaeftsfuehrer from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.geschaeftsfuehrer='*del*' then ''
                                                                                else v_cur.geschaeftsfuehrer end,
                                                                                
                                einkauf= case   when v_cur.einkauf='' then (select einkauf from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.einkauf='*del*' then ''
                                                                else v_cur.einkauf end,
                                                                
                                marktforschung= case    when v_cur.marktforschung='' then (select marktforschung from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.marktforschung='*del*' then ''
                                                                        else v_cur.marktforschung end,
                                                                        
                                marketing= case when v_cur.marketing='' then (select marketing from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.marketing='*del*' then ''
                                                                else v_cur.marketing end,
                                                                
                                blockbuster= case       when v_cur.blockbuster='' then (select blockbuster from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.blockbuster='*del*' then ''
                                                                        else v_cur.blockbuster end,
                                                                        
                                emarketing= case        when v_cur.emarketing='' then (select emarketing from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.emarketing='*del*' then ''
                                                                else v_cur.emarketing end,
                                                                
                                aussendienst= case      when v_cur.aussendienst='' then (select aussendienst from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.aussendienst='*del*' then ''
                                                                        else v_cur.aussendienst end,
                                                                        
                                klinik= case    when v_cur.klinik='' then (select klinik from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.klinik='*del*' then ''
                                                        else v_cur.klinik end,
                                                        
                                it= case        when v_cur.it='' then (select it from ad_user where ad_user_id=v_user_id)
                                                when v_cur.it='*del*' then ''
                                                else v_cur.it end,
                                                
                                unternehmenskommunikation= case when v_cur.unternehmenskommunikation='' then (select unternehmenskommunikation from ad_user where ad_user_id=v_user_id)
                                                                                                when v_cur.unternehmenskommunikation='*del*' then ''
                                                                                                else v_cur.unternehmenskommunikation end,
                                                        
                                medicaleducation= case  when v_cur.medicaleducation='' then (select medicaleducation from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.medicaleducation='*del*' then ''
                                                                                else v_cur.medicaleducation end,
                                                        
                                nis= case       when v_cur.nis='' then (select nis from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.nis='*del*' then ''
                                                        else v_cur.nis end,
                                                        
                                medwissen= case when v_cur.medwissen='' then (select medwissen from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.medwissen='*del*' then ''
                                                                else v_cur.medwissen end,
                                                        
                                training= case  when v_cur.training='' then (select training from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.training='*del*' then ''
                                                                else v_cur.training end,
                                                        
                                humanresources= case    when v_cur.humanresources='' then (select humanresources from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.humanresources='*del*' then ''
                                                                        else v_cur.humanresources end,
                                                        
                                veranstaltungsmanagement= case  when v_cur.veranstaltungsmanagement='' then (select veranstaltungsmanagement from ad_user where ad_user_id=v_user_id)
                                                                                                when v_cur.veranstaltungsmanagement='*del*' then ''
                                                                                                else v_cur.veranstaltungsmanagement end,
                                                                                                
                                geschaeftsentwicklung= case     when v_cur.geschaeftsentwicklung='' then (select geschaeftsentwicklung from ad_user where ad_user_id=v_user_id)
                                                                                        when v_cur.geschaeftsentwicklung='*del*' then ''
                                                                                        else v_cur.geschaeftsentwicklung end,
                                                        
                                presse= case    when v_cur.presse='' then (select presse from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.presse='*del*' then ''
                                                        else v_cur.presse end,
                                                        
                                prominenter= case       when v_cur.prominenter='' then (select prominenter from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.prominenter='*del*' then ''
                                                                        else v_cur.prominenter end,
                                                        
                                kol= case       when v_cur.kol='' then (select kol from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.kol='*del*' then ''
                                                        else v_cur.kol end,
                                                        
                                kooperation= case       when v_cur.kooperation='' then (select kooperation from ad_user where ad_user_id=v_user_id)
                                                                        when v_cur.kooperation='*del*' then ''
                                                                        else v_cur.kooperation end,
                                                        
                                schluesselkontakt= case when v_cur.schluesselkontakt='' then (select schluesselkontakt from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.schluesselkontakt='*del*' then ''
                                                                                else v_cur.schluesselkontakt end,
                                                        
                                persoenlicherkontakt2008= case  when v_cur.persoenlicherkontakt2008='' then (select persoenlicherkontakt2008 from ad_user where ad_user_id=v_user_id)
                                                                                                when v_cur.persoenlicherkontakt2008='*del*' then ''
                                                                                                else v_cur.persoenlicherkontakt2008 end,
                                                        
                                persoenlicherkontakt2009= case  when v_cur.persoenlicherkontakt2009='' then (select persoenlicherkontakt2009 from ad_user where ad_user_id=v_user_id)
                                                                                                when v_cur.persoenlicherkontakt2009='*del*' then ''
                                                                                                else v_cur.persoenlicherkontakt2009 end,
                                                        
                                persoenlicherkontakt2010= case  when v_cur.persoenlicherkontakt2010='' then (select persoenlicherkontakt2010 from ad_user where ad_user_id=v_user_id)
                                                                                                when v_cur.persoenlicherkontakt2010='*del*' then ''
                                                                                                else v_cur.persoenlicherkontakt2010 end,
                                                        
                                persoenlicherkontakt2011= case  when v_cur.persoenlicherkontakt2011='' then (select persoenlicherkontakt2011 from ad_user where ad_user_id=v_user_id)
                                                                                                when v_cur.persoenlicherkontakt2011='*del*' then ''
                                                                                                else v_cur.persoenlicherkontakt2011 end,
                                                        
                                hobby= case     when v_cur.hobby='' then (select hobby from ad_user where ad_user_id=v_user_id)
                                                        when v_cur.hobby='*del*' then ''
                                                        else v_cur.hobby end,
                                                        
                                communityzugehoerigkeit= case   when v_cur.communityzugehoerigkeit='' then (select communityzugehoerigkeit from ad_user where ad_user_id=v_user_id)
                                                                                                when v_cur.communityzugehoerigkeit='*del*' then ''
                                                                                                else v_cur.communityzugehoerigkeit end,
                                                        
                                planung= case   when v_cur.planung='' then (select planung from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.planung='*del*' then ''
                                                                else v_cur.planung end,
                                                        
                                positionfunktion= case  when v_cur.positionfunktion='' then (select positionfunktion from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.positionfunktion='*del*' then ''
                                                                                else v_cur.positionfunktion end,
                                                        
                                abteilungbereich= case  when v_cur.abteilungbereich='' then (select abteilungbereich from ad_user where ad_user_id=v_user_id)
                                                                                when v_cur.abteilungbereich='*del*' then ''
                                                                                else v_cur.abteilungbereich end,
                                                        
                                sachgebiet= case        when v_cur.sachgebiet='' then (select sachgebiet from ad_user where ad_user_id=v_user_id)
                                                                when v_cur.sachgebiet='*del*' then ''
                                                                else v_cur.sachgebiet end
                        where ad_user_id=v_user_id;
                   
           v_impcount:=v_impcount+1;    
        else
          v_weiter='N';       
        end if;
    END LOOP;
    
    if instr(v_Message,'ERROR')=0 then
           v_Message:=to_char(v_impcount)||' Items Successfully Imported';
           update i_user set isimported='Y' where isactive='Y';
           PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N',1, v_Message) ;
    else
           PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_Message) ;
    end if;
    RETURN; 
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

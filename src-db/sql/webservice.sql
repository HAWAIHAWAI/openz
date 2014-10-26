




/*****************************************************+


Functions for WEB Services

UPDATE-RULES:

Return-Value: 'UPDATED' -> Updates Existing Rec.
              'ERR'     -> ERROR
          All Others    -> Inserted, Return-Value is the new ID  

*****************************************************/



CREATE or replace FUNCTION zsse_updateCustomer(p_customer_Id character varying,p_value character varying,p_name character varying,p_user character varying, p_org character varying,p_bpgroup character varying) RETURNS character varying
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
Updates or Inserts  Business-Partner (Customer)
*****************************************************/
-- Simple Types
v_message character varying :='ERR';
v_client character varying;
v_uid character varying;
v_lang character varying;
v_bpgroup character varying;
v_user character varying;
v_count integer;
BEGIN 
    select ad_user_id into v_user from ad_user where username=p_user;
    if v_user is not null then
        select c_bp_group_id  into v_bpgroup from c_bp_group where ad_org_id in ('0',p_org) and isactive='Y' and value=p_bpgroup LIMIT 1; 
        if v_bpgroup is null then
            select c_bp_group_id  into v_bpgroup from c_bp_group where ad_org_id in ('0',p_org) and isactive='Y' and isdefault='Y' LIMIT 1; 
        end if;
        if p_customer_Id is not null then
          select count(*) into v_count from c_bpartner where c_bpartner_id=p_customer_Id;
          if v_count=1 then
              update c_bpartner set updatedby=p_user,updated=now(),value=p_value,name=p_name,c_bp_group_id=v_bpgroup where c_bpartner_id=p_customer_Id;
              v_message:='UPDATED';
          end if;
        else
            if (p_org is not null and p_user is not null and p_value is not null and p_name is not null) then
              v_uid:=get_uuid();
              select ad_client_id,ad_language into v_client,v_lang from ad_client where ad_client_id!='0';
              insert into c_bpartner(C_BPARTNER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY,UPDATEDBY, VALUE, NAME, C_BP_GROUP_ID, ISCUSTOMER, AD_LANGUAGE,so_creditlimit)
                    values(v_uid,v_client,p_org,p_user,p_user,p_value,p_name,v_bpgroup,'Y',v_lang,500000);
              v_message:=v_uid;
            end if;
        end if;
    end if;
    return  v_message;
END;
$_$  LANGUAGE 'plpgsql';
     
alter function public.zsse_updateCustomer(p_customer_Id character varying,p_value character varying,p_name character varying,p_user character varying, p_org character varying,p_bpgroup character varying) owner to tad; 



CREATE or replace FUNCTION zsse_updateAddress(p_customer_Id character varying,p_user character varying, p_address1 character varying,p_address2 character varying,p_city character varying,p_postal character varying,
                                              p_country character varying,p_isbillto character varying, p_isshipto character varying,p_uidnumber character varying ,p_locationId character varying) RETURNS character varying
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
Updates or Inserts Business-Partner-Adresses
*****************************************************/
-- Simple Types
v_message character varying :='ERR';
v_uid character varying;
v_client character varying;
v_org character varying;
v_country character varying;
v_count integer; 
v_stadr  character varying:='N';
v_user character varying;
BEGIN 
    select ad_user_id into v_user from ad_user where username=p_user;
    if v_user is not null then 
        select c_country_id into v_country from c_country where countrycode=p_country;
        if v_country is not null then
            if p_locationId is not null then
                select count(*) into v_count from c_location where c_location_id=p_locationId;
                if v_count=1 then
                    update c_location set updatedby=p_user,updated=now(),ADDRESS1=p_address1,ADDRESS2=p_address2,CITY=p_city,POSTAL=p_postal,C_COUNTRY_ID=v_country where C_LOCATION_ID=p_locationId;
                    update c_bpartner_location set isbillto=p_isbillto,isshipto=p_isshipto,uidnumber=p_uidnumber where C_LOCATION_ID=p_locationId and C_BPARTNER_ID=p_customer_Id;
                    v_message:='UPDATED';
                end if;
            else
                select count(*) into v_count from c_bpartner where c_bpartner_id=p_customer_Id;
                if v_count=1 then
                    select count(*) into v_count from C_BPARTNER_LOCATION where name='Standard' and c_bpartner_id=p_customer_Id;
                    if v_count=1 then 
                       -- Forget the automatically created entry
                       delete from C_LOCATION where C_LOCATION_id=(select C_LOCATION_id from C_BPARTNER_LOCATION where name='Standard' and c_bpartner_id=p_customer_Id);
                       delete  from C_BPARTNER_LOCATION where name='Standard' and c_bpartner_id=p_customer_Id;
                       v_stadr:='Y';
                    end if;
                    v_uid:=get_uuid();
                    select ad_client_id,ad_org_id into v_client,v_org from c_bpartner where c_bpartner_id=p_customer_Id;
                    insert into C_LOCATION (C_LOCATION_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY,  UPDATEDBY, ADDRESS1, ADDRESS2, CITY, POSTAL, C_COUNTRY_ID)
                            values (v_uid,v_client,v_org,p_user,p_user,p_address1,p_address2,p_city,p_postal,v_country);
                    insert into C_BPARTNER_LOCATION(C_BPARTNER_LOCATION_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY,C_LOCATION_ID,C_BPARTNER_ID,
                                                    isheadquarter,isbillto,isshipto,uidnumber)
                            values(get_uuid(),v_client,v_org,p_user,p_user,v_uid,p_customer_Id,v_stadr,p_isbillto,p_isshipto,p_uidnumber);
                    v_message:=v_uid;
                end if; 
            end if;
        end if;
    end if;
    return v_message;
END;
$_$  LANGUAGE 'plpgsql';
     
alter function public.zsse_updateAddress(p_customer_Id character varying,p_user character varying, p_address1 character varying,p_address2 character varying,p_city character varying,p_postal character varying,
                                              p_country character varying,p_isbillto character varying, p_isshipto character varying,p_uidnumber character varying ,p_locationId character varying) owner to tad; 


CREATE or replace FUNCTION zsse_updateContacts(p_customer_Id character varying,p_user character varying,p_firstName character varying,p_lastName character varying,p_name character varying, p_email character varying,p_phone character varying,p_phone2 character varying ,p_fax character varying,p_greeting character varying,p_contactId character varying) RETURNS character varying
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
Updates or Inserts Business-Partner-Adresses
*****************************************************/
-- Simple Types
v_message character varying :='ERR';
v_uid character varying;
v_client character varying;
v_org character varying;
v_country character varying;
v_count integer; 
v_user character varying;
v_greeting character varying;
BEGIN 
    select ad_user_id into v_user from ad_user where username=p_user;
    select c_greeting_id into v_greeting from c_greeting where greeting=p_greeting;
    if v_user is not null then 
        if p_contactId  is not null then
            select count(*) into v_count from ad_user where ad_user_id=p_contactId;
            if v_count=1 then
                update ad_user set updatedby=p_user,updated=now(),firstname =p_firstName,lastName=p_lastName,name=p_name,email=p_email,phone=p_phone,phone2=p_phone2,fax=p_fax ,
                                   c_greeting_id=v_greeting where ad_user_id=p_contactId;
                v_message:='UPDATED';
            end if;
        else
            select count(*) into v_count from c_bpartner where c_bpartner_id=p_customer_Id;
            if v_count=1 then
                  v_uid:=get_uuid();
                  select ad_client_id,ad_org_id into v_client,v_org from c_bpartner where c_bpartner_id=p_customer_Id;
                  insert into ad_user (AD_USER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, EMAIL, C_BPARTNER_ID, PHONE, PHONE2, FAX, FIRSTNAME, LASTNAME,NAME,c_greeting_id)
                        values (v_uid,v_client,v_org,p_user,p_user,p_email,p_customer_Id,p_phone,p_phone2,p_fax,p_firstName,p_lastName,p_name,v_greeting);
                  v_message:=v_uid;
            end if; 
        end if;
    end if;
    return v_message;
END;
$_$  LANGUAGE 'plpgsql';
     
alter FUNCTION zsse_updateContacts(p_customer_Id character varying,p_user character varying,p_firstName character varying,p_lastName character varying,p_name character varying, p_email character varying,p_phone character varying,p_phone2 character varying ,p_fax character varying,p_greeting character varying,p_contactId character varying)  owner to tad; 


CREATE or replace FUNCTION zsse_createOrderHeader(p_org_Id character varying,p_user character varying,p_bpartner_Id character varying,p_ec_paymentmethod character varying,p_deliveryviarule character varying,p_location_id  character varying, p_bpcontact_id  character varying) RETURNS character varying
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
Creates an Order Header
Returns Order ID, if Successful
*****************************************************/
-- Simple Types
v_message character varying :='SUCCESS';
v_orderid character varying;
v_client character varying;
v_country character varying;
v_count integer; 
v_user character varying;
v_docno character varying;
v_doctypetarget  character varying;
v_payterm  character varying;
v_invrule  character varying;
v_delrule  character varying;
v_warehouse  character varying;
v_pricelist  character varying; 
v_location character varying; 
v_currency  character varying:='102'; --EUR
v_paymentrule character varying;
v_ec_paymentmethod character varying;
v_usecustomersdefaults character varying;
v_salesrep character varying;
v_so_description character varying;
v_freightcostrule character varying;
v_shipper character varying;
v_incoterms character varying;
v_invrule2 character varying;
v_delrule2 character varying;
v_pricelist2 character varying;
v_payterm2 character varying;
v_freightcostrule2 character varying;

BEGIN 
    select ad_user_id into v_user from ad_user where username=p_user;
    select ad_client_id into v_client from ad_org where ad_org_id=p_org_Id;
    if v_user is null or v_client is null then v_message:='ERR: WRONG USER or ORG ID'; end if;
    select count(*) into v_count from c_bpartner where c_bpartner_Id=p_bpartner_Id;
    if v_count!=1 then v_message:='ERR: BUSINESS Partner does not exist!'; end if;
    select count(*) into v_count FROM C_LOCATION L
               LEFT JOIN C_BPARTNER_LOCATION B ON L.C_LOCATION_ID = B.C_LOCATION_ID 
               LEFT OUTER JOIN C_REGION R ON L.C_REGION_ID = R.C_REGION_ID
               LEFT JOIN C_COUNTRY C ON L.C_COUNTRY_ID = C.C_COUNTRY_ID
               WHERE B.C_BPARTNER_ID = p_bpartner_Id and l.c_location_id=p_location_id;
    if v_count!=1 then v_message:='ERR: LOCATION IS not a Location of Business Partner'; end if;
    select count(*) into v_count  from zssi_smartinvoiceprefs where ad_client_id=v_client and ad_org_id in ('0',p_org_Id) and invoicetype='SSO' and isactive='Y';
    if v_count=0 then v_message:='ERR: No Preferences Defined for Shop-Documents'; end if;
    -- Payment-Rule Check - Reference: Paymentmethod ECommerce
    select count(*) into v_count  from ad_ref_list where ad_reference_id='8EE47A7F188B4F86936C8AF91A55490A' and name=p_ec_paymentmethod;
    if  v_count!=1 then v_message:='ERR: Invalid Payment Rule';  end if;
    select count(*) into v_count  from ad_user where ad_user_id=p_bpcontact_id and c_bpartner_Id=p_bpartner_Id;
    if  v_count!=1 and  p_bpcontact_id is not null then v_message:='ERR: Contact Person of Business Partner not Found';  end if;
    if p_deliveryviarule  not in ('D','P') then v_message:='ERR: Invalid Delivery via Rule'; end if;
    if substr(v_message,1,3)!='ERR' then 
         -- Mapping to Paymentrule
         select value into v_ec_paymentmethod  from ad_ref_list where ad_reference_id='8EE47A7F188B4F86936C8AF91A55490A' and name=p_ec_paymentmethod;

         -- Kredit-Card and Paypal
         if v_ec_paymentmethod in ('A','M','PP','V','EC') then v_paymentrule:='K'; end if;
         -- Bank Collection
         if v_ec_paymentmethod in ('BC','BCM') then  v_paymentrule:='P'; end if;
         -- Prepaid, Invoice
         if v_ec_paymentmethod in ('P','I') then  v_paymentrule:='R'; end if;
         -- Cash on delivery
         if v_ec_paymentmethod in ('C')  then  v_paymentrule:='COD'; end if;
         -- Cash
         if v_ec_paymentmethod in ('B')  then  v_paymentrule:='B'; end if;
         if v_paymentrule is null then RAISE EXCEPTION '%', 'Parameter Error'; end if;
         --   
         v_orderid:=get_uuid();
         -- Get Location
         select c_bpartner_location_id into v_location from C_BPARTNER_LOCATION where C_LOCATION_id=p_location_id and c_bpartner_id=p_bpartner_Id;
         --TODO: Get Correct warehouse in multishop-environments
         select m_warehouse_id into v_warehouse from zse_warehouse_shop LIMIT 1;
         -- Get Preferences
         -- Fixed Preferences and Info, 
         select c_doctype_id,usecustomersdefaults
           into v_doctypetarget,v_usecustomersdefaults
           from zssi_smartinvoiceprefs where ad_client_id=v_client and ad_org_id in ('0',p_org_Id) and invoicetype='SSO' and isactive='Y' order by ad_org_id desc limit 1 ;
         
                -- Preload document prefs
                select invoicerule, deliveryrule, m_pricelist_id, c_paymentterm_id, freightcostrule, m_shipper_id, c_incoterms_id
                into v_invrule, v_delrule, v_pricelist, v_payterm, v_freightcostrule, v_shipper, v_incoterms
                from zssi_smartinvoiceprefs where ad_client_id=v_client and ad_org_id in ('0',p_org_Id) and invoicetype='SSO' and isactive='Y' order by ad_org_id desc limit 1 ;
                 
                -- Overload with customer prefs
                if v_usecustomersdefaults='Y' then
                        select invoicerule, deliveryrule, m_pricelist_id, c_paymentterm_id, salesrep_id, so_description
                        into v_invrule2, v_delrule2, v_pricelist2, v_payterm2, v_salesrep, v_so_description
                        from c_bpartner where c_bpartner_id=p_bpartner_Id;
                        select ad_user_id into v_salesrep from ad_user where v_salesrep=c_bpartner_id;
                end if;
                   
                -- Set defaults preventing "not null"
                if v_payterm2 is null then
                        if v_payterm is null then
                                select c_paymentterm_id into v_payterm from c_paymentterm LIMIT 1;
                        end if;
                else
                        v_payterm:=v_payterm2;
                end if;
                if v_pricelist2 is null then
                        if v_pricelist is null then
                                select m_pricelist_id into v_pricelist from m_pricelist where m_pricelist.issopricelist='Y' LIMIT 1;
                        end if;
                else
                        v_pricelist:=v_pricelist2;      
                end if;
                if v_delrule2 is null then
                        if v_delrule is null then
                                v_delrule:='R';
                        end if;
                else
                        v_delrule:=v_delrule2;
                end if;
                if v_invrule2 is null then
                        if v_invrule is null then
                                v_invrule:='A';
                        end if;
                else
                        v_invrule:=v_invrule2;
                end if;          
                if v_freightcostrule2 is null then
                        if v_freightcostrule is null then
                                v_freightcostrule:='C';
                        end if;
                else
                        v_freightcostrule:=v_freightcostrule2;
                end if;          

         -- Delivery Rule in Case of Prepaid will be After Receipt (R), Invoice-Rule Immediately (I)
         if v_ec_paymentmethod='P' then 
            v_delrule:='R';
            v_invrule:='I'; 
         end if;
         -- Get new DocData
         select ad_sequence_doctype(v_doctypetarget,p_org_Id,'Y') into v_docno from dual;
         RAISE NOTICE '%','Creating WEBSHOP-Order: '||coalesce(v_doctypetarget,'no Target Doctype')||coalesce(v_docno,'no Doc no.');
         -- Create Order Header
         
                 
                 INSERT INTO C_Order
          (C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATEDBY, UPDATEDBY,
           ISSOTRX, DOCUMENTNO, DOCSTATUS, DOCACTION, PROCESSING, C_DOCTYPE_ID,C_DOCTYPETARGET_ID,
           DATEORDERED, DATEACCT, C_BPARTNER_ID, BILLTO_ID, C_BPARTNER_LOCATION_ID, C_CURRENCY_ID, PAYMENTRULE, C_PAYMENTTERM_ID,AD_USER_ID,
           INVOICERULE, DELIVERYRULE, DELIVERYVIARULE, M_WAREHOUSE_ID, M_PRICELIST_ID,istaxincluded,freightcostrule,priorityrule, m_shipper_id, c_incoterms_id, salesrep_id, description)
         VALUES
           (v_orderid, v_Client, p_org_Id,'Y',v_user,v_user,
            'Y', v_docno,  'DR', 'CO','N','0',v_doctypetarget,
            now(),now(),p_bpartner_Id,v_location,v_location,v_currency,v_paymentrule,v_payterm,p_bpcontact_id,
            v_invrule,v_delrule,p_deliveryviarule,v_warehouse,v_pricelist,'N',v_freightcostrule,'5', v_shipper, v_incoterms, v_salesrep, v_so_description);
         v_message:=v_orderid;
    end if;
    return v_message;
END;
$_$  LANGUAGE 'plpgsql';
     

CREATE or replace FUNCTION zsse_createOrderLine(p_order_Id character varying,p_product_id character varying,p_qty character varying,p_price character varying,p_decription character varying) RETURNS character varying
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
Creates an Order Header
Returns Order ID, if Successful
*****************************************************/
-- Simple Types
v_message character varying :='SUCCESS';
v_client character varying;
v_org character varying;
v_count integer; 
v_line integer ;
v_user character varying;
v_tax  character varying;
v_location character varying;
v_warehouse character varying;
v_uom character varying;
v_currency character varying;
v_bpartner_id character varying;

BEGIN 
    select count(*) into v_count from c_order where c_order_id=p_order_Id;
    if v_count=0 then v_message:='ERR: Order does not exist!'; end if;
    if substr(v_message,1,3)!='ERR' then    
        select c_bpartner_id,C_BPARTNER_LOCATION_ID,CREATEDBY,AD_CLIENT_ID, AD_ORG_ID,m_warehouse_id,c_currency_id into v_bpartner_id,v_location,v_user,v_client,v_org,v_warehouse,v_currency from c_order where c_order_id=p_order_Id;
        select zsfi_GetTax(v_location, p_product_id, v_org) into v_tax from dual;
        select C_UOM_ID into v_uom from m_product where m_product_id=p_product_id;
        select coalesce(max(line),0)+10 into v_line from c_orderline where c_order_id=p_order_Id;
        insert into c_orderline (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID,  CREATEDBY, UPDATEDBY,
                                  C_ORDER_ID, LINE, DATEORDERED, M_PRODUCT_ID, M_WAREHOUSE_ID, C_UOM_ID, QTYORDERED,
                                  C_CURRENCY_ID,  PRICEACTUAL, C_TAX_ID,c_bpartner_id,c_bpartner_location_id,DESCRIPTION)
                    values(get_uuid(),v_client,v_org,v_user,v_user,
                          p_order_Id,v_line,now(), p_product_id,v_warehouse,v_uom,to_number(p_qty),
                          v_currency,to_number(p_price),v_tax,v_bpartner_id,v_location,p_decription);
    end if;
    return v_message;
END;
$_$  LANGUAGE 'plpgsql';
     


     

CREATE or replace FUNCTION zsse_commitOrder(p_order_Id character varying) RETURNS character varying
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
Creates an Order Header
Returns Order ID, if Successful
*****************************************************/
-- Simple Types
v_message character varying :='SUCCESS';
v_count integer; 
v_direct character varying;

v_client character varying;
v_org character varying;

BEGIN 
    select count(*) into v_count from c_order where c_order_id=p_order_Id;
    if v_count=0 then v_message:='ERR: Order does not exist!'; end if;
    if substr(v_message,1,3)!='ERR' then  
       select ad_client_id,ad_org_id into v_client,v_org from c_order where c_order_id=p_order_Id;
       select isautoclosing into v_direct  from zssi_smartinvoiceprefs where ad_client_id=v_client and ad_org_id in ('0',v_org) and invoicetype='SSO' and isactive='Y' order by ad_org_id desc LIMIT 1;   
       if v_direct='Y' then
         -- Create invoice and schipment
         PERFORM C_Order_Post1(null,p_order_Id);
       end if;
    end if;
    return v_message;
END;
$_$  LANGUAGE 'plpgsql';
     

 

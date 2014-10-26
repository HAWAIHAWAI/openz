
/**************************************************************************************************************************************+


DIRECT-Sales










***************************************************************************************************************************************/



CREATE OR REPLACE FUNCTION zssi_directsales_trg()
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
Business Partner for DirectSales
*****************************************************/
v_count          numeric;
v_summedLineAmt  numeric:=0;
v_pproductname varchar;
strLinestring varchar:='';
v_bp             character varying;
v_bpadr          character varying;
v_defaultdate    timestamp without time zone;
v_cur            RECORD;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN RETURN NEW; END IF; 
  
  IF (TG_OP = 'DELETE') THEN
    if old.processed='Y' then
      RAISE EXCEPTION '%', '@NoChangeProcessed@';
    end if;
    for v_cur in (SELECT zssi_directsales_id,qty,priceactual ,m_product_id from zssi_directsales
             where isactive='Y' and processed='N' and zssi_directsales_id!=old.zssi_directsales_id)
    LOOP
         SELECT rpad(NAME,80) into v_pproductname  FROM m_product   where m_product_id=v_cur.m_product_id;
         if strLinestring != '' then
          strLinestring := strLinestring ||chr(13);
         end if;
         strLinestring := strLinestring||'Artikel: '||v_pproductname||', Anzahl: '||round(v_cur.qty,2)||' , Preis: '||round(v_cur.priceActual,2)||'€ , Summe: '||round(v_cur.qty*v_cur.priceActual,2)||'€';
         v_summedLineAmt:=v_summedLineAmt+round(v_cur.qty*v_cur.priceActual,2);
    END LOOP;
    if strLinestring != '' then
          strLinestring := strLinestring ||chr(13)||'Gesamtsumme: '||v_summedLineAmt||'€';
    end if;
    update zssi_directsales set textlines=strLinestring where ad_org_id=old.ad_org_id and processed='N' 
                  and isactive='Y' and posid is null and zssi_directsales_id!=old.zssi_directsales_id;
  end if;
  IF (TG_OP = 'UPDATE') THEN
    if old.processed='Y' and old.m_product_id!=new.m_product_id then
      RAISE EXCEPTION '%', '@NoChangeProcessed@';
    end if;
  end if;
  IF (TG_OP = 'UPDATE' or TG_OP = 'INSERT' ) THEN
    if new.qty=0 then
        RAISE EXCEPTION '%', '@zssi_ChooseQtyGreaterNull@';
    end if;
    if new.ad_org_id='0' then
        RAISE EXCEPTION '%', '@zssi_NoInvoicePrefsDS@';
    end if;
    select count(*) into v_count from zssi_directsales where ad_client_id=new.ad_client_id and ad_org_id=new.ad_org_id and processed='N' and isactive='Y' and posid is null;
    if v_count=0 then
        if new.c_bpartner_id is null then
            select c_bpartner_id,c_bpartner_location_id into v_bp,v_bpadr from zssi_smartinvoiceprefs where ad_client_id=new.ad_client_id and ad_org_id in ('0',new.ad_org_id) and invoicetype='SO' and isactive='Y' order by ad_org_id desc LIMIT 1;
            if v_bp is null or v_bpadr is null then
            RAISE EXCEPTION '%', '@zssi_NoInvoicePrefsDS@';
            end if;
        else
            if new.c_bpartner_location_id is null then
                RAISE EXCEPTION '%', '@zssi_PleaseChooseAdress@';
            end if;
        end if;
    else
        select distinct c_bpartner_id,c_bpartner_location_id into v_bp,v_bpadr from zssi_directsales where ad_client_id=new.ad_client_id and ad_org_id=new.ad_org_id and processed='N' and isactive='Y' and posid is null;
    end if;
    new.c_bpartner_id:=coalesce(v_bp,new.c_bpartner_id);
    new.c_bpartner_location_id:=coalesce(v_bpadr,new.c_bpartner_location_id);
  end if;
IF (TG_OP != 'DELETE') THEN RETURN NEW; else RETURN OLD; end if;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
select zsse_DropTrigger ('zssi_directsales_trg','zssi_directsales');    


CREATE TRIGGER zssi_directsales_trg
  BEFORE INSERT or update or delete
  ON zssi_directsales FOR EACH ROW
  EXECUTE PROCEDURE zssi_directsales_trg();



CREATE or replace FUNCTION zssi_directsalespost(p_PInstance_ID character varying) RETURNS void
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
Direct Sales Implementation
*/
-- Simple Types
i integer;
v_currency  character varying;
v_docno  character varying;
v_client  character varying;
v_org  character varying;
v_user  character varying;
v_doctypetarget  character varying;
v_bpartner  character varying;
v_location  character varying;
v_paymentrule  character varying;
v_payterm  character varying;
v_invrule  character varying;
v_delrule  character varying;
v_warehouse  character varying;
v_pricelist  character varying;
v_tax character varying;
v_count numeric:=0;
v_message character varying;
v_orderid character varying;
v_invoiceid character varying;
v_invoiceno character varying;
v_isgross character(1);
v_docmsg character varying:='';
v_invoicemsg character varying:='';
-- Rowtypes
v_cur_header RECORD;
v_cur_line zssi_directsales%rowtype;
v_reversetax      CHAR(1);
v_salesdate timestamp;
BEGIN 
    if p_PInstance_ID is not null then
          -- Set Proceccing...
          PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
          select ad_user_id,ad_client_id,ad_org_id into v_user,v_client,v_org from ad_pinstance where ad_pinstance_id=p_PInstance_ID;
    else
          select createdby,ad_client_id,ad_org_id into v_user,v_client,v_org from zssi_directsales where isactive='Y' and isposted='N' and processed='Y' limit 1;
    end if;
    -- Select ident Data
    select c_currency_id into v_currency from ad_org_acctschema,c_acctschema where ad_org_acctschema.c_acctschema_id=c_acctschema.c_acctschema_id and ad_org_acctschema.ad_org_id=v_org;
    -- Get defaults from zssi_smartinvoiceprefs
    select count(*) into v_count from zssi_smartinvoiceprefs where ad_client_id=v_client and ad_org_id in ('0',v_org) and invoicetype='SO' and isactive='Y';
    if v_count<1 then
      -- Finishing
      v_message:='Auftragserstellung nicht möglich: Noch keine Voreinstellungen definiert.';
      if p_PInstance_ID is not null then
            -- 1=success
            PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_message);
      end if;
      RAISE NOTICE '%', 'Auftragserstellung nicht möglich: Noch keine Voreinstellungen definiert.'||v_org;
      return;
    end if;
    for v_cur_header in (select distinct posid from  zssi_directsales where isactive='Y' and isposted='N' and processed='Y' and  ad_client_id=v_client  and ad_org_id=v_org)
    LOOP
          -- Get Preferences
          select c_doctype_id,paymentrule,c_paymentterm_id,invoicerule,deliveryrule,m_warehouse_id,m_pricelist_id
                into v_doctypetarget,v_paymentrule,v_payterm,v_invrule,v_delrule,v_warehouse,v_pricelist
                from zssi_smartinvoiceprefs where ad_client_id=v_client and ad_org_id in ('0',v_org) and invoicetype='SO' and isactive='Y' order by ad_org_id desc LIMIT 1;
          -- Get Salesdate
          select min(dateofsale) into v_salesdate from zssi_directsales where isactive='Y' and isposted='N' and posid=v_cur_header.posid and ad_client_id=v_client  and ad_org_id=v_org;
          -- Get new DocData
          select ad_sequence_doctype(v_doctypetarget,v_org,'Y') into v_docno from dual;
          -- Isgross?
          select istaxincluded into v_isgross from m_pricelist where m_pricelist_id=v_pricelist;
          -- Business Partner
          select distinct c_bpartner_id,c_bpartner_location_id into v_bpartner,v_location from zssi_directsales where isactive='Y' and posid=v_cur_header.posid and processed='Y' and ad_client_id=v_client  and ad_org_id=v_org;
          -- Create the Order
          v_orderid:=get_uuid();
          insert into c_order(C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY,
                          ISSOTRX, DOCUMENTNO, DOCSTATUS, DOCACTION, PROCESSING, PROCESSED,
                          C_DOCTYPE_ID, C_DOCTYPETARGET_ID, DESCRIPTION,
                          DATEORDERED,DATEACCT,C_BPARTNER_ID, BILLTO_ID, C_BPARTNER_LOCATION_ID,
                          C_CURRENCY_ID, PAYMENTRULE, C_PAYMENTTERM_ID, INVOICERULE, DELIVERYRULE,
                          FREIGHTCOSTRULE, FREIGHTAMT, DELIVERYVIARULE,PRIORITYRULE,
                          TOTALLINES, GRANDTOTAL, M_WAREHOUSE_ID, M_PRICELIST_ID,
                          datepromised,copyfrompo,istaxincluded,copyfrom)
                      values(v_orderid,v_client,v_org,'Y',now(),v_user,now(),v_user,'Y',v_docno,'DR','CO','N','N','0',v_doctypetarget,'Direktauftrag',
                              v_salesdate,v_salesdate,v_bpartner,v_location,v_location,v_currency,v_paymentrule,v_payterm,v_invrule,v_delrule,'I',0,'P','5',0,0,v_warehouse,v_pricelist,
                              v_salesdate,'N',v_isgross,'N');
          -- Create Lines
          i:=10;
          for v_cur_line in (select * from zssi_directsales where  posid=v_cur_header.posid)
          LOOP
            -- Get Tax
            select zsfi_GetTax(v_location, v_cur_line.m_product_id, v_org) into v_tax from dual;
            -- Price-Calculation (Gross/Net) are don in the line-Trigger
            -- Note: This is NOT transfered to the Invoice
            -- Invoice calculates new with priceactual and qty
            -- Therefor only update isgrossprice on the Invoice is enaugh to ImplemenGross-Invoice..
            insert into c_orderline (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY,
                                      C_ORDER_ID, LINE, DATEORDERED, M_PRODUCT_ID, M_WAREHOUSE_ID, C_UOM_ID, QTYORDERED,
                                      C_CURRENCY_ID,  PRICEACTUAL, C_TAX_ID, M_ATTRIBUTESETINSTANCE_ID,C_BPARTNER_ID,C_BPARTNER_LOCATION_ID)
                        values(get_uuid(),v_client,v_org,'Y',now(),v_user,now(),v_user,
                              v_orderid,i,v_salesdate, v_cur_line.m_product_id,v_cur_line.m_warehouse_id,v_cur_line.c_uom_id,v_cur_line.qty,
                              v_cur_line.c_currency_id,v_cur_line.priceactual,v_tax,v_cur_line.m_attributesetinstance_id,v_bpartner,v_location);
            i:=i+10;
          END LOOP;
          -- Create invoice and schipment
          PERFORM C_Order_Post1(null,v_orderid);
          -- select the invoice
          select c_invoice_id,DOCUMENTNO into v_invoiceid,v_invoiceno from c_invoice where c_order_id=v_orderid;
          if v_docmsg='' then
             v_docmsg:=v_docno;
             v_invoicemsg:=v_invoiceno;
          else
             v_invoicemsg:=v_invoicemsg||', '||v_invoiceno;
             v_docmsg:=v_docmsg||', '||v_docno;
          end if;
          -- Update Invoice when Grossprice is used
          if v_isgross='Y' then
            update c_invoice set isgrossinvoice='Y' where c_invoice_id=v_invoiceid;
            update c_invoiceline set isgrossprice='Y' where c_invoice_id=v_invoiceid;
          end if;
          -- Update directsales
          update zssi_directsales set isposted='Y',c_order_id=v_orderid,c_invoice_id=v_invoiceid where isactive='Y' and isposted='N' and posid=v_cur_header.posid and ad_client_id=v_client  and ad_org_id=v_org;
    END LOOP;
    -- Finishing
    v_message:='Auftrag '||v_docmsg||' und Rechnung '||v_invoicemsg||' erfolgreich erstellt';
    if p_PInstance_ID is not null then
          -- 1=success
          PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_message);
    end if;
    raise notice '%',v_message;
    return;
EXCEPTION
    WHEN OTHERS then
       v_message:= '@ERROR=' || SQLERRM;   
       --ROLLBACK;
        if p_PInstance_ID is not null then
             -- 0=failed
             PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 0, v_message);
        end if;
       raise notice '%',v_message;
       return;
END;
$_$  LANGUAGE 'plpgsql';
     
alter function public.zssi_directsalespost(p_PInstance_ID character varying) owner to tad;  


CREATE or replace FUNCTION zssi_directsalesproc(p_PInstance_ID character varying) RETURNS void
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
Direct Sales Implementation
*/
-- Simple Types
v_message character varying;
v_client  character varying;
v_org  character varying;
v_user  character varying;
v_count numeric:=0;
v_Record_ID  character varying;
v_processed character varying;
v_posid character varying;
BEGIN 
    -- Set Proceccing...
    PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'Y', NULL, NULL) ;
    -- Select ident Data
    select ad_user_id,ad_org_id,ad_client_id,Record_ID into v_user,v_org,v_client,v_Record_ID from ad_pinstance where ad_pinstance_id=p_PInstance_ID;
    -- Get defaults from zssi_smartinvoiceprefs
    select count(*) into v_count from zssi_smartinvoiceprefs where ad_client_id=v_client and ad_org_id in ('0',v_org) and invoicetype='SO' and isactive='Y';
    if v_count<1 then
      -- Finishing
      v_message:='Auftragserstellung nicht möglich: Noch keine Voreinstellungen definiert.';
      -- 1=success
      PERFORM AD_UPDATE_PINSTANCE(p_PInstance_ID, NULL, 'N', 1, v_message);
      RAISE EXCEPTION '%', '@zssi_NoInvoicePrefsDS@' ;
      return;
    end if;
    -- If already processed - Unprocess
    select processed,posid into v_processed,v_posid from zssi_directsales where zssi_directsales_id=v_Record_ID;
 --   raise exception '%',v_Record_ID;
    if v_processed='Y' and v_posid is not null then
      select count(*) into v_count from zssi_directsales where coalesce(v_posid,'Ö')!=v_posid and processed='N' and isactive='Y';
      if v_count!=0 then
         v_message:='Auftrag nicht zu öffnen. Erst bestehenden Auftrag abschließen';
      else
          -- Unprocess
          update zssi_directsales set processed='N',posid=null where posid=v_posid;
      end if;
      v_message:='Auftrag erfolgreich geöffnet';
    else
        -- Update directsales - Set Processed
        v_posid=get_uuid();
        update zssi_directsales set processed='Y',posid=v_posid where isactive='Y' and processed='N' and ad_client_id=v_client  and ad_org_id=v_org;
        v_message:='Auftrag erfolgreich verarbeitet';
    end if;
    -- Finishing
    
    -- 1=success
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
     
alter function public.zssi_directsalesproc(p_PInstance_ID character varying) owner to tad;  
 

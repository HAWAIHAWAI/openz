SELECT zsse_dropview('m_offer_v');
CREATE VIEW m_offer_v
AS
SELECT
  mo.m_offer_id AS m_offer_v_id,
  mo.m_offer_id,
  mo.ad_client_id,
  mo.ad_org_id,
  mo.isactive,
  mo.created,
  mo.createdby,
  mo.updated,
  mo.updatedby,
  mo.name,
  mo.priority,
  mo.addamt,
  mo.discount,
  mo.fixed,
  mo.datefrom,
  mo.dateto,
  mo.bpartner_selection,
  mo.bp_group_selection,
  mo.product_selection,
  mo.prod_cat_selection,
  mo.description,
  mo.pricelist_selection,
  mo.qty_from,
  mo.qty_to,
  mo.issalesoffer,
  mo.directpurchasecalc,
  mob.c_bpartner_id,
  mop.m_product_id
FROM m_offer mo
   LEFT JOIN m_offer_bpartner mob ON mob.m_offer_id = mo.m_offer_id
   LEFT JOIN m_offer_product mop ON mop.m_offer_id = mo.m_offer_id;

CREATE RULE m_offer_v_delete AS ON DELETE TO public.m_offer_v
DO INSTEAD (
DELETE FROM m_offer
  WHERE m_offer.m_offer_id = old.m_offer_id;
);

CREATE RULE m_offer_v_insert AS ON INSERT TO public.m_offer_v
DO INSTEAD (
 INSERT INTO m_offer (
   m_offer_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
   name, priority, addamt, discount,
   fixed, datefrom, dateto,
   bpartner_selection, bp_group_selection, product_selection, prod_cat_selection,
   description, pricelist_selection, qty_from, qty_to, issalesoffer, directpurchasecalc)
  VALUES (
   new.m_offer_id, new.ad_client_id, new.ad_org_id, new.isactive, new.created, new.createdby, new.updated, new.updatedby,
   new.name, COALESCE(new.priority, 0), COALESCE(new.addamt, 0), COALESCE(new.discount, 0),
   new.fixed, COALESCE(new.datefrom, now()), new.dateto,
   'N', 'Y', 'N', 'Y',
   new.description, 'Y', new.qty_from, new.qty_to, 'N', new.directpurchasecalc);
 INSERT INTO m_offer_bpartner (
   m_offer_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
   m_offer_bpartner_id, c_bpartner_id)
  VALUES (
   new.m_offer_id, new.ad_client_id, new.ad_org_id, new.isactive, new.created, new.createdby, new.updated, new.updatedby,
   get_uuid(), new.c_bpartner_id);
 INSERT INTO m_offer_product (
   m_offer_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby,
   m_offer_product_id, m_product_id)
  VALUES (
   new.m_offer_id, new.ad_client_id, new.ad_org_id, new.isactive, new.created, new.createdby, new.updated, new.updatedby,
   get_uuid(), new.m_product_id);
);

CREATE RULE m_offer_v_update AS ON UPDATE TO public.m_offer_v
DO INSTEAD (
 UPDATE m_offer SET
   m_offer_id = new.m_offer_id, ad_client_id = new.ad_client_id, ad_org_id = new.ad_org_id,
   isactive = new.isactive, created = new.created, createdby = new.createdby, updated = new.updated, updatedby = new.updatedby,
   name = new.name, priority = new.priority, addamt = new.addamt, discount = new.discount,
   fixed = NEW.fixed, datefrom = new.datefrom, dateto = new.dateto,
   bpartner_selection = 'N', bp_group_selection = 'Y', product_selection = 'N', prod_cat_selection = 'Y',
   description = new.description, pricelist_selection = new.pricelist_selection, qty_from = new.qty_from, qty_to = new.qty_to,
   issalesoffer = 'N', directpurchasecalc = new.directpurchasecalc
  WHERE m_offer.m_offer_id = new.m_offer_id;
 UPDATE m_offer_product SET
   m_offer_id = new.m_offer_id, ad_client_id = new.ad_client_id, ad_org_id = new.ad_org_id,
   isactive = new.isactive, created = new.created, createdby = new.createdby, updated = new.updated, updatedby = new.updatedby,
   m_product_id = new.m_product_id
  WHERE m_offer_product.m_offer_id = new.m_offer_id AND m_offer_product.m_product_id = new.m_product_id;
 UPDATE m_offer_bpartner SET m_offer_id = new.m_offer_id, ad_client_id = new.ad_client_id, ad_org_id = new.ad_org_id,
   isactive = new.isactive, created = new.created, createdby = new.createdby, updated = new.updated, updatedby = new.updatedby,
   c_bpartner_id = new.c_bpartner_id
  WHERE m_offer_bpartner.m_offer_id = new.m_offer_id AND m_offer_bpartner.c_bpartner_id = new.c_bpartner_id;
);

create or replace function m_offer_restrictions_trg()
  returns trigger as
$BODY$ declare
/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, Danny Heuduk 02/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************/

BEGIN
  IF (TG_OP = 'INSERT' or TG_OP = 'UPDATE') THEN
    IF (new.qty_to < new.qty_from) THEN
      RAISE EXCEPTION '%', '@MSGErrorOnQty@';
    END IF;
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;
  END IF;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION m_offer_restrictions_trg() OWNER TO TAD;

select zsse_droptrigger('m_offer_restrictions_trg','m_offer');

CREATE TRIGGER m_offer_restrictions_trg
  BEFORE INSERT OR UPDATE 
  ON m_offer
  FOR EACH ROW
  EXECUTE PROCEDURE m_offer_restrictions_trg();

 
/* 2012-12-04 MaHinrichs */
CREATE OR REPLACE FUNCTION  m_offer_dependent_delete_trg ()
RETURNS trigger AS
$body$
DECLARE
BEGIN
  IF (TG_OP = 'DELETE') THEN
    IF (SELECT COUNT(*) FROM c_orderline_offer olo WHERE olo.m_offer_id = OLD.m_offer_id) > 0 THEN 
      RAISE EXCEPTION '%.  (%)', '@DeleteErrorDependent@', 'Linked Items';
    END IF;
  END IF;
  
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;
  END;
$body$
LANGUAGE 'plpgsql';

SELECT zsse_droptrigger('m_offer_dependent_delete_trg', 'm_offer');
CREATE TRIGGER m_offer_dependent_delete_trg
  BEFORE DELETE
  ON m_offer FOR EACH ROW 
  EXECUTE PROCEDURE  m_offer_dependent_delete_trg();


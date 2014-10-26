/* ---------------------------------------------------------------------------------------




Read Only Views representing data for anylysis Purposes







--------------------------------------------------------------------------------------------*/

select zsse_DropView ('c_project_invoice_overview');
create or replace view c_project_invoice_overview as
select
 c_invoiceline_id as c_project_invoice_overview_id,
 c_invoice_id,
 c_bpartner_id,
 c_bpartner_location_id,
 m_pricelist_id,
 ispaid,
 c_doctype_id,
 issotrx,
 so_totallines as salestotallines,
 po_totallines as purchasetotallines,
 so_totalpaid as salestotalpaid,
 po_totalpaid as purchasetotalpaid,
 so_outstandingamt as salesoutstandingamt,
 po_outstandingamt  as purchaseoutstandingamt,
 m_product_id,
 description,
 qtyinvoiced,
 linenetamt,
 linegrossamt,
 ad_org_id,
 ad_client_id,
 isactive,
 created,
 createdby,
 updated,
 updatedby,
 c_project_id,
 c_projecttask_id
 from 
 (select i.ad_client_id,i.issotrx,i.c_invoice_id,i.c_bpartner_id,i.c_bpartner_location_id,i.m_pricelist_id,i.ispaid,i.c_doctype_id,
         case when il.line=(select min(line) from c_invoiceline where c_invoice_id=i.c_invoice_id) then i.totallines else null end as so_totallines,
         case when il.line=(select min(line) from c_invoiceline where c_invoice_id=i.c_invoice_id) then i.totalpaid else null end  as so_totalpaid,
         case when il.line=(select min(line) from c_invoiceline where c_invoice_id=i.c_invoice_id) then i.outstandingamt else null end  as so_outstandingamt,
         null::numeric as po_totallines,null::numeric as po_totalpaid,null::numeric as po_outstandingamt,
         il.m_product_id,il.qtyinvoiced,i.isactive,
         il.description,il.linenetamt,il.linegrossamt,i.ad_org_id,i.created,
         i.createdby,i.updated,i.updatedby,il.c_project_id,il.c_projecttask_id,
         il.c_invoiceline_id
 from c_invoice i,c_invoiceline il
 where i.issotrx='Y' and i.c_invoice_id=il.c_invoice_id and
       il.c_project_id is not null and
       i.docstatus='CO'
 union
 select  i.ad_client_id,i.issotrx,i.c_invoice_id,i.c_bpartner_id,i.c_bpartner_location_id,i.m_pricelist_id,i.ispaid,i.c_doctype_id,
         null as so_totallines,null as so_totalpaid,null as so_outstandingamt,
         case when il.line=(select min(line) from c_invoiceline where c_invoice_id=i.c_invoice_id) then i.totallines else null end as po_totallines,
         case when il.line=(select min(line) from c_invoiceline where c_invoice_id=i.c_invoice_id) then i.totalpaid else null end  as po_totalpaid,
         case when il.line=(select min(line) from c_invoiceline where c_invoice_id=i.c_invoice_id) then i.outstandingamt else null end  as po_outstandingamt,
         il.m_product_id,il.qtyinvoiced,i.isactive,
         il.description,il.linenetamt,il.linegrossamt,i.ad_org_id,i.created,
         i.createdby,i.updated,i.updatedby,il.c_project_id,il.c_projecttask_id,
         il.c_invoiceline_id
 from c_invoice i,c_invoiceline il
 where i.issotrx='N' and i.c_invoice_id=il.c_invoice_id and
       il.c_project_id is not null and
       i.docstatus='CO') a;
       
       
       
       
       
       
       
       
select zsse_DropView ('m_product_not_puchaseble_overview');
create or replace view m_product_not_puchaseble_overview as     
select 
m.m_product_id as m_product_not_puchaseble_overview_id,
m.m_product_id ,
m.m_product_category_id,
ad_org_id,
 m.ad_client_id,
 m.isactive,
 m.created,
 m.createdby,
 m.updated,
 m.updatedby
from m_product m 
where m.ispurchased='Y' and m.production='N' and m.isactive='Y' and
not exists (select 0 from m_product_po po where po.m_product_id=m.m_product_id and po.isactive='Y' and po.iscurrentvendor='Y');
 
/**************************************************************************************************************************************+



CRM





***************************************************************************************************************************************/
DROP VIEW zssi_crm_todos;
CREATE VIEW zssi_crm_todos AS
  SELECT nc.zssi_notes4customer_id AS zssi_crm_todos_id, nc.zssi_notes4customer_id, c_b.c_bpartner_id, nc.followup_by AS emp, crma.name AS typeofcontact, nc.dateofcontact, nc.description, nc.followup, 
         zssi_getusernamecomplete(nc.ad_userid_next,'') as contactto,
         nc.ad_client_id, nc.ad_org_id, nc.isactive, nc.created, nc.updated, nc.createdby, nc.updatedby, nc.c_project_id
   FROM c_bpartner c_b, zssi_crmactions crma, zssi_notes4customer nc 
   LEFT JOIN ad_user au ON  au.ad_user_id=nc.ad_user_id
  WHERE nc.zssi_crmactions_id::text = crma.zssi_crmactions_id::text AND c_b.c_bpartner_id::text = nc.c_bpartner_id::text AND nc.followup_done = 'N'::bpchar AND nc.followup IS NOT NULL AND nc.isactive = 'Y'::bpchar;
 

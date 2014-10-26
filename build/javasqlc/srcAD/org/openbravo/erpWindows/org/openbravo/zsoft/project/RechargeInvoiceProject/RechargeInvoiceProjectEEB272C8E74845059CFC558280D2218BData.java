//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.RechargeInvoiceProject;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData implements FieldProvider {
static Logger log4j = Logger.getLogger(RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zspmRechargeViewId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String isactive;
  public String qtyinvoiced;
  public String mProductId;
  public String mProductIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String dateordered;
  public String salesrepId;
  public String salesrepIdr;
  public String cInvoiceId;
  public String cInvoiceIdr;
  public String cInvoicelineId;
  public String cInvoicelineIdr;
  public String description;
  public String dateinvoiced;
  public String linenetamt;
  public String ispaid;
  public String transactiondate;
  public String rechargeQtyinvoiced;
  public String rechargeProductId;
  public String rechargeProductIdr;
  public String rechargeInvoiceId;
  public String rechargeInvoiceIdr;
  public String totallines;
  public String reinvoicedbyId;
  public String reinvoicedbyIdr;
  public String grandtotal;
  public String totalpaid;
  public String rechargeDateinvoiced;
  public String rechargeBpartnerId;
  public String rechargeBpartnerIdr;
  public String rechargeLinenetamt;
  public String rechargeOrderId;
  public String rechargeOrderIdr;
  public String isrecharged;
  public String norecharge;
  public String norechargecomment;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("zspm_recharge_view_id") || fieldName.equals("zspmRechargeViewId"))
      return zspmRechargeViewId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_invoice_idr") || fieldName.equals("cInvoiceIdr"))
      return cInvoiceIdr;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_idr") || fieldName.equals("cInvoicelineIdr"))
      return cInvoicelineIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("transactiondate"))
      return transactiondate;
    else if (fieldName.equalsIgnoreCase("recharge_qtyinvoiced") || fieldName.equals("rechargeQtyinvoiced"))
      return rechargeQtyinvoiced;
    else if (fieldName.equalsIgnoreCase("recharge_product_id") || fieldName.equals("rechargeProductId"))
      return rechargeProductId;
    else if (fieldName.equalsIgnoreCase("recharge_product_idr") || fieldName.equals("rechargeProductIdr"))
      return rechargeProductIdr;
    else if (fieldName.equalsIgnoreCase("recharge_invoice_id") || fieldName.equals("rechargeInvoiceId"))
      return rechargeInvoiceId;
    else if (fieldName.equalsIgnoreCase("recharge_invoice_idr") || fieldName.equals("rechargeInvoiceIdr"))
      return rechargeInvoiceIdr;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("reinvoicedby_id") || fieldName.equals("reinvoicedbyId"))
      return reinvoicedbyId;
    else if (fieldName.equalsIgnoreCase("reinvoicedby_idr") || fieldName.equals("reinvoicedbyIdr"))
      return reinvoicedbyIdr;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("totalpaid"))
      return totalpaid;
    else if (fieldName.equalsIgnoreCase("recharge_dateinvoiced") || fieldName.equals("rechargeDateinvoiced"))
      return rechargeDateinvoiced;
    else if (fieldName.equalsIgnoreCase("recharge_bpartner_id") || fieldName.equals("rechargeBpartnerId"))
      return rechargeBpartnerId;
    else if (fieldName.equalsIgnoreCase("recharge_bpartner_idr") || fieldName.equals("rechargeBpartnerIdr"))
      return rechargeBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("recharge_linenetamt") || fieldName.equals("rechargeLinenetamt"))
      return rechargeLinenetamt;
    else if (fieldName.equalsIgnoreCase("recharge_order_id") || fieldName.equals("rechargeOrderId"))
      return rechargeOrderId;
    else if (fieldName.equalsIgnoreCase("recharge_order_idr") || fieldName.equals("rechargeOrderIdr"))
      return rechargeOrderIdr;
    else if (fieldName.equalsIgnoreCase("isrecharged"))
      return isrecharged;
    else if (fieldName.equalsIgnoreCase("norecharge"))
      return norecharge;
    else if (fieldName.equalsIgnoreCase("norechargecomment"))
      return norechargecomment;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_recharge_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_recharge_view.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_recharge_view.Updated, ?) as updated, " +
      "        to_char(zspm_recharge_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_recharge_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_recharge_view.UpdatedBy) as UpdatedByR," +
      "        zspm_recharge_view.Zspm_Recharge_View_ID, " +
      "zspm_recharge_view.AD_Client_ID, " +
      "(CASE WHEN zspm_recharge_view.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "zspm_recharge_view.AD_Org_ID, " +
      "(CASE WHEN zspm_recharge_view.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zspm_recharge_view.C_Project_ID, " +
      "(CASE WHEN zspm_recharge_view.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "zspm_recharge_view.C_Projecttask_ID, " +
      "(CASE WHEN zspm_recharge_view.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "COALESCE(zspm_recharge_view.Isactive, 'N') AS Isactive, " +
      "zspm_recharge_view.Qtyinvoiced, " +
      "zspm_recharge_view.M_Product_ID, " +
      "(CASE WHEN zspm_recharge_view.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zspm_recharge_view.C_Order_ID, " +
      "(CASE WHEN zspm_recharge_view.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table7.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "zspm_recharge_view.C_Orderline_ID, " +
      "(CASE WHEN zspm_recharge_view.C_Orderline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table9.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.LineNetAmt), ''))),'') ) END) AS C_Orderline_IDR, " +
      "zspm_recharge_view.C_Bpartner_ID, " +
      "(CASE WHEN zspm_recharge_view.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "zspm_recharge_view.Dateordered, " +
      "zspm_recharge_view.Salesrep_ID, " +
      "(CASE WHEN zspm_recharge_view.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "zspm_recharge_view.C_Invoice_ID, " +
      "(CASE WHEN zspm_recharge_view.C_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table12.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.GrandTotal), ''))),'') ) END) AS C_Invoice_IDR, " +
      "zspm_recharge_view.C_Invoiceline_ID, " +
      "(CASE WHEN zspm_recharge_view.C_Invoiceline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table14.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.LineNetAmt), ''))),'') ) END) AS C_Invoiceline_IDR, " +
      "zspm_recharge_view.Description, " +
      "zspm_recharge_view.Dateinvoiced, " +
      "zspm_recharge_view.Linenetamt, " +
      "COALESCE(zspm_recharge_view.Ispaid, 'N') AS Ispaid, " +
      "zspm_recharge_view.Transactiondate, " +
      "zspm_recharge_view.Recharge_Qtyinvoiced, " +
      "zspm_recharge_view.Recharge_Product_ID, " +
      "(CASE WHEN zspm_recharge_view.Recharge_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL15.Name IS NULL THEN TO_CHAR(table15.Name) ELSE TO_CHAR(tableTRL15.Name) END)), ''))),'') ) END) AS Recharge_Product_IDR, " +
      "zspm_recharge_view.Recharge_Invoice_ID, " +
      "(CASE WHEN zspm_recharge_view.Recharge_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table16.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.GrandTotal), ''))),'') ) END) AS Recharge_Invoice_IDR, " +
      "zspm_recharge_view.Totallines, " +
      "zspm_recharge_view.Reinvoicedby_ID, " +
      "(CASE WHEN zspm_recharge_view.Reinvoicedby_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table18.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table18.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table17.LineNetAmt), ''))),'') ) END) AS Reinvoicedby_IDR, " +
      "zspm_recharge_view.Grandtotal, " +
      "zspm_recharge_view.Totalpaid, " +
      "zspm_recharge_view.Recharge_Dateinvoiced, " +
      "zspm_recharge_view.Recharge_Bpartner_ID, " +
      "(CASE WHEN zspm_recharge_view.Recharge_Bpartner_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS Recharge_Bpartner_IDR, " +
      "zspm_recharge_view.Recharge_Linenetamt, " +
      "zspm_recharge_view.Recharge_Order_ID, " +
      "(CASE WHEN zspm_recharge_view.Recharge_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table20.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.GrandTotal), ''))),'') ) END) AS Recharge_Order_IDR, " +
      "COALESCE(zspm_recharge_view.Isrecharged, 'N') AS Isrecharged, " +
      "COALESCE(zspm_recharge_view.Norecharge, 'N') AS Norecharge, " +
      "zspm_recharge_view.Norechargecomment, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_recharge_view left join (select AD_Client_ID, Name from AD_Client) table1 on (zspm_recharge_view.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (zspm_recharge_view.AD_Org_ID = table2.AD_Org_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (zspm_recharge_view.C_Project_ID = table3.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table4 on (zspm_recharge_view.C_Projecttask_ID = table4.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table5 on (table4.C_Project_ID = table5.C_Project_ID) left join (select M_Product_ID, Value, Name from M_Product) table6 on (zspm_recharge_view.M_Product_ID = table6.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL6 on (table6.M_Product_ID = tableTRL6.M_Product_ID and tableTRL6.AD_Language = ?)  left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table7 on (zspm_recharge_view.C_Order_ID = table7.C_Order_ID) left join (select C_Orderline_ID, C_Order_ID, Line, LineNetAmt from C_Orderline) table8 on (zspm_recharge_view.C_Orderline_ID = table8.C_Orderline_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table9 on (table8.C_Order_ID = table9.C_Order_ID) left join (select C_BPartner_ID, Name from C_BPartner) table10 on (zspm_recharge_view.C_Bpartner_ID = table10.C_BPartner_ID) left join (select AD_User_ID, Name from AD_User) table11 on (zspm_recharge_view.Salesrep_ID =  table11.AD_User_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table12 on (zspm_recharge_view.C_Invoice_ID = table12.C_Invoice_ID) left join (select C_Invoiceline_ID, C_Invoice_ID, Line, LineNetAmt from C_Invoiceline) table13 on (zspm_recharge_view.C_Invoiceline_ID = table13.C_Invoiceline_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table14 on (table13.C_Invoice_ID = table14.C_Invoice_ID) left join (select M_Product_ID, Value, Name from M_Product) table15 on (zspm_recharge_view.Recharge_Product_ID = table15.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL15 on (table15.M_Product_ID = tableTRL15.M_Product_ID and tableTRL15.AD_Language = ?)  left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table16 on (zspm_recharge_view.Recharge_Invoice_ID = table16.C_Invoice_ID) left join (select C_InvoiceLine_ID, C_Invoice_ID, Line, LineNetAmt from C_InvoiceLine) table17 on (zspm_recharge_view.Reinvoicedby_ID = table17.C_InvoiceLine_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table18 on (table17.C_Invoice_ID = table18.C_Invoice_ID) left join (select C_BPartner_ID, value, Name from C_BPartner) table19 on (zspm_recharge_view.Recharge_Bpartner_ID =  table19.C_BPartner_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table20 on (zspm_recharge_view.Recharge_Order_ID = table20.C_Order_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zspm_recharge_view.Zspm_Recharge_View_ID = ? " +
      "        AND zspm_recharge_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_recharge_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData = new RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData();
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.created = UtilSql.getValue(result, "created");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.updated = UtilSql.getValue(result, "updated");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.updatedby = UtilSql.getValue(result, "updatedby");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.zspmRechargeViewId = UtilSql.getValue(result, "zspm_recharge_view_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.isactive = UtilSql.getValue(result, "isactive");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cInvoiceIdr = UtilSql.getValue(result, "c_invoice_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.cInvoicelineIdr = UtilSql.getValue(result, "c_invoiceline_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.description = UtilSql.getValue(result, "description");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.ispaid = UtilSql.getValue(result, "ispaid");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.transactiondate = UtilSql.getDateValue(result, "transactiondate", "dd-MM-yyyy");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeQtyinvoiced = UtilSql.getValue(result, "recharge_qtyinvoiced");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeProductId = UtilSql.getValue(result, "recharge_product_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeProductIdr = UtilSql.getValue(result, "recharge_product_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeInvoiceId = UtilSql.getValue(result, "recharge_invoice_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeInvoiceIdr = UtilSql.getValue(result, "recharge_invoice_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.totallines = UtilSql.getValue(result, "totallines");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.reinvoicedbyId = UtilSql.getValue(result, "reinvoicedby_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.reinvoicedbyIdr = UtilSql.getValue(result, "reinvoicedby_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeDateinvoiced = UtilSql.getDateValue(result, "recharge_dateinvoiced", "dd-MM-yyyy");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeBpartnerId = UtilSql.getValue(result, "recharge_bpartner_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeBpartnerIdr = UtilSql.getValue(result, "recharge_bpartner_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeLinenetamt = UtilSql.getValue(result, "recharge_linenetamt");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeOrderId = UtilSql.getValue(result, "recharge_order_id");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.rechargeOrderIdr = UtilSql.getValue(result, "recharge_order_idr");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.isrecharged = UtilSql.getValue(result, "isrecharged");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.norecharge = UtilSql.getValue(result, "norecharge");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.norechargecomment = UtilSql.getValue(result, "norechargecomment");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.language = UtilSql.getValue(result, "language");
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.adUserClient = "";
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.adOrgClient = "";
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.createdby = "";
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.trBgcolor = "";
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.totalCount = "";
        objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] = new RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[vector.size()];
    vector.copyInto(objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData);
    return(objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData);
  }

/**
Create a registry
 */
  public static RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] set(String cBpartnerId, String cBpartnerIdr, String isactive, String adClientId, String totalpaid, String rechargeProductId, String rechargeProductIdr, String transactiondate, String cProjecttaskId, String rechargeOrderId, String rechargeOrderIdr, String rechargeQtyinvoiced, String rechargeBpartnerId, String createdby, String createdbyr, String zspmRechargeViewId, String linenetamt, String cInvoiceId, String norechargecomment, String norecharge, String updatedby, String updatedbyr, String adOrgId, String qtyinvoiced, String isrecharged, String cInvoicelineId, String cProjectId, String cProjectIdr, String totallines, String dateinvoiced, String rechargeDateinvoiced, String dateordered, String rechargeLinenetamt, String grandtotal, String rechargeInvoiceId, String rechargeInvoiceIdr, String description, String salesrepId, String ispaid, String cOrderlineId, String reinvoicedbyId, String reinvoicedbyIdr, String cOrderId, String mProductId, String mProductIdr)    throws ServletException {
    RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[] = new RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[1];
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0] = new RechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData();
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].created = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].createdbyr = createdbyr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].updated = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].updatedTimeStamp = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].updatedby = updatedby;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].updatedbyr = updatedbyr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].zspmRechargeViewId = zspmRechargeViewId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].adClientId = adClientId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].adClientIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].adOrgId = adOrgId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].adOrgIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cProjectId = cProjectId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cProjectIdr = cProjectIdr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cProjecttaskId = cProjecttaskId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cProjecttaskIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].isactive = isactive;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].qtyinvoiced = qtyinvoiced;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].mProductId = mProductId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].mProductIdr = mProductIdr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cOrderId = cOrderId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cOrderIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cOrderlineId = cOrderlineId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cOrderlineIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cBpartnerId = cBpartnerId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cBpartnerIdr = cBpartnerIdr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].dateordered = dateordered;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].salesrepId = salesrepId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].salesrepIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cInvoiceId = cInvoiceId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cInvoiceIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cInvoicelineId = cInvoicelineId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].cInvoicelineIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].description = description;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].dateinvoiced = dateinvoiced;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].linenetamt = linenetamt;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].ispaid = ispaid;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].transactiondate = transactiondate;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeQtyinvoiced = rechargeQtyinvoiced;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeProductId = rechargeProductId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeProductIdr = rechargeProductIdr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeInvoiceId = rechargeInvoiceId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeInvoiceIdr = rechargeInvoiceIdr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].totallines = totallines;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].reinvoicedbyId = reinvoicedbyId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].reinvoicedbyIdr = reinvoicedbyIdr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].grandtotal = grandtotal;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].totalpaid = totalpaid;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeDateinvoiced = rechargeDateinvoiced;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeBpartnerId = rechargeBpartnerId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeBpartnerIdr = "";
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeLinenetamt = rechargeLinenetamt;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeOrderId = rechargeOrderId;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].rechargeOrderIdr = rechargeOrderIdr;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].isrecharged = isrecharged;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].norecharge = norecharge;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].norechargecomment = norechargecomment;
    objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData[0].language = "";
    return objectRechargeInvoiceProjectEEB272C8E74845059CFC558280D2218BData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1A65700C24484ADBA07374FAFBAEB7CA_0(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDefADB5E1B7F5884108B9BB8500D8347774_1(ConnectionProvider connectionProvider, String Recharge_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as Recharge_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Recharge_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "recharge_product_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef5D3ABC0E4D9A4D269258A597831C577D_2(ConnectionProvider connectionProvider, String Recharge_Order_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '')  || ' - ' || COALESCE(TO_CHAR(table1.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table1.GrandTotal), '') ) as Recharge_Order_ID FROM C_Order table1 WHERE table1.isActive='Y' AND table1.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Recharge_Order_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "recharge_order_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef45AAA76FBB004DD3992E6DE63B26AA0E_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDefAF13A123A5E041D2B97365F4B65E9752_4(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef96C835755B3040DF86C734FE9042064D_5(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef3B61DE414DB24F70A8AA51E54C08AD79_6(ConnectionProvider connectionProvider, String Recharge_Invoice_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.DateInvoiced), '')  || ' - ' || COALESCE(TO_CHAR(table1.GrandTotal), '') ) as Recharge_Invoice_ID FROM C_Invoice table1 WHERE table1.isActive='Y' AND table1.C_Invoice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Recharge_Invoice_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "recharge_invoice_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef8C6D38822E3B49C6906CF5F4EF2FD0CB_7(ConnectionProvider connectionProvider, String Reinvoicedby_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table2.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table2.DateInvoiced), '')  || ' - ' || COALESCE(TO_CHAR(table2.GrandTotal), '')  || ' - ' || COALESCE(TO_CHAR(table1.Line), '')  || ' - ' || COALESCE(TO_CHAR(table1.LineNetAmt), '') ) as Reinvoicedby_ID FROM C_InvoiceLine table1 left join C_Invoice table2 on (table1.C_Invoice_ID = table2.C_Invoice_ID) WHERE table1.isActive='Y' AND table1.C_InvoiceLine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Reinvoicedby_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "reinvoicedby_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDefA7C16A1FEE104CF8A9EEA7FA77461446_8(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zspm_recharge_view" +
      "        SET Zspm_Recharge_View_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Isactive = (?) , Qtyinvoiced = TO_NUMBER(?) , M_Product_ID = (?) , C_Order_ID = (?) , C_Orderline_ID = (?) , C_Bpartner_ID = (?) , Dateordered = TO_DATE(?) , Salesrep_ID = (?) , C_Invoice_ID = (?) , C_Invoiceline_ID = (?) , Description = (?) , Dateinvoiced = TO_DATE(?) , Linenetamt = TO_NUMBER(?) , Ispaid = (?) , Transactiondate = TO_DATE(?) , Recharge_Qtyinvoiced = TO_NUMBER(?) , Recharge_Product_ID = (?) , Recharge_Invoice_ID = (?) , Totallines = TO_NUMBER(?) , Reinvoicedby_ID = (?) , Grandtotal = TO_NUMBER(?) , Totalpaid = TO_NUMBER(?) , Recharge_Dateinvoiced = TO_DATE(?) , Recharge_Bpartner_ID = (?) , Recharge_Linenetamt = TO_NUMBER(?) , Recharge_Order_ID = (?) , Isrecharged = (?) , Norecharge = (?) , Norechargecomment = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_recharge_view.Zspm_Recharge_View_ID = ? " +
      "        AND zspm_recharge_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_recharge_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmRechargeViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeQtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reinvoicedbyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeDateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeLinenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharged);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, norecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, norechargecomment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmRechargeViewId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO zspm_recharge_view " +
      "        (Zspm_Recharge_View_ID, AD_Client_ID, AD_Org_ID, C_Project_ID, C_Projecttask_ID, Isactive, Qtyinvoiced, M_Product_ID, C_Order_ID, C_Orderline_ID, C_Bpartner_ID, Dateordered, Salesrep_ID, C_Invoice_ID, C_Invoiceline_ID, Description, Dateinvoiced, Linenetamt, Ispaid, Transactiondate, Recharge_Qtyinvoiced, Recharge_Product_ID, Recharge_Invoice_ID, Totallines, Reinvoicedby_ID, Grandtotal, Totalpaid, Recharge_Dateinvoiced, Recharge_Bpartner_ID, Recharge_Linenetamt, Recharge_Order_ID, Isrecharged, Norecharge, Norechargecomment, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), TO_DATE(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmRechargeViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeQtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reinvoicedbyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeDateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeLinenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rechargeOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharged);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, norecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, norechargecomment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_recharge_view" +
      "        WHERE zspm_recharge_view.Zspm_Recharge_View_ID = ? " +
      "        AND zspm_recharge_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_recharge_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_recharge_view" +
      "        WHERE zspm_recharge_view.Zspm_Recharge_View_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM zspm_recharge_view" +
      "         WHERE zspm_recharge_view.Zspm_Recharge_View_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM zspm_recharge_view" +
      "         WHERE zspm_recharge_view.Zspm_Recharge_View_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}

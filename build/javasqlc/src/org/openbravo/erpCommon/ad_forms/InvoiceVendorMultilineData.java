//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class InvoiceVendorMultilineData implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoiceVendorMultilineData.class);
  private String InitRecordNumber="0";
  public String cInvoiceId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String issotrx;
  public String documentno;
  public String docstatus;
  public String docaction;
  public String processing;
  public String processed;
  public String posted;
  public String cDoctypeId;
  public String cDoctypetargetId;
  public String cOrderId;
  public String description;
  public String isprinted;
  public String salesrepId;
  public String dateinvoiced;
  public String dateprinted;
  public String dateacct;
  public String cBpartnerId;
  public String cBpartnerLocationId;
  public String poreference;
  public String isdiscountprinted;
  public String dateordered;
  public String cCurrencyId;
  public String paymentrule;
  public String cPaymenttermId;
  public String cChargeId;
  public String chargeamt;
  public String totallines;
  public String grandtotal;
  public String mPricelistId;
  public String istaxincluded;
  public String cCampaignId;
  public String cProjectId;
  public String cActivityId;
  public String createfrom;
  public String generateto;
  public String adUserId;
  public String copyfrom;
  public String isselfservice;
  public String adOrgtrxId;
  public String user1Id;
  public String user2Id;
  public String paymentruler;
  public String docactionBtn;
  public String cBpartnerIdD;
  public String adWindowId;
  public String adTabId;
  public String tabname;
  public String windowname;
  public String windownameEnUs;
  public String tabnameEnUs;
  public String adTableId;
  public String dateformat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("docaction_btn") || fieldName.equals("docactionBtn"))
      return docactionBtn;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id_d") || fieldName.equals("cBpartnerIdD"))
      return cBpartnerIdD;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("tabname"))
      return tabname;
    else if (fieldName.equalsIgnoreCase("windowname"))
      return windowname;
    else if (fieldName.equalsIgnoreCase("windowname_en_us") || fieldName.equals("windownameEnUs"))
      return windownameEnUs;
    else if (fieldName.equalsIgnoreCase("tabname_en_us") || fieldName.equals("tabnameEnUs"))
      return tabnameEnUs;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("dateformat"))
      return dateformat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InvoiceVendorMultilineData[] select(ConnectionProvider connectionProvider, String dateformat, String adLanguage, String cInvoiceId)    throws ServletException {
    return select(connectionProvider, dateformat, adLanguage, cInvoiceId, 0, 0);
  }

  public static InvoiceVendorMultilineData[] select(ConnectionProvider connectionProvider, String dateformat, String adLanguage, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT" +
      "		 I.C_INVOICE_ID," +
      "		 I.AD_CLIENT_ID," +
      "		 I.AD_ORG_ID," +
      "		 I.ISACTIVE," +
      "		 I.CREATED," +
      "		 I.CREATEDBY," +
      "		 I.UPDATED," +
      "		 I.UPDATEDBY," +
      "		 I.ISSOTRX," +
      "		 I.DOCUMENTNO," +
      "		 I.DOCSTATUS," +
      "		 I.DOCACTION," +
      "		 I.PROCESSING," +
      "		 I.PROCESSED," +
      "		 I.POSTED," +
      "		 I.C_DOCTYPE_ID," +
      "		 I.C_DOCTYPETARGET_ID," +
      "		 I.C_ORDER_ID," +
      "		 I.DESCRIPTION," +
      "		 I.ISPRINTED," +
      "		 I.SALESREP_ID," +
      "		 I.DATEINVOICED," +
      "		 I.DATEPRINTED," +
      "		 I.DATEACCT," +
      "		 I.C_BPARTNER_ID," +
      "		 I.C_BPARTNER_LOCATION_ID," +
      "		 I.POREFERENCE," +
      "		 I.ISDISCOUNTPRINTED," +
      "		 I.DATEORDERED," +
      "		 I.C_CURRENCY_ID," +
      "		 I.PAYMENTRULE," +
      "		 I.C_PAYMENTTERM_ID," +
      "		 I.C_CHARGE_ID," +
      "		 I.CHARGEAMT," +
      "		 I.TOTALLINES," +
      "		 I.GRANDTOTAL," +
      "		 I.M_PRICELIST_ID," +
      "		 I.ISTAXINCLUDED," +
      "		 I.C_CAMPAIGN_ID," +
      "		 I.C_PROJECT_ID," +
      "		 I.C_ACTIVITY_ID," +
      "		 I.CREATEFROM," +
      "		 I.GENERATETO," +
      "		 I.AD_USER_ID," +
      "		 I.COPYFROM," +
      "		 I.ISSELFSERVICE," +
      "		 I.AD_ORGTRX_ID," +
      "		 I.USER1_ID," +
      "		 I.USER2_ID," +
      "		 CASE WHEN I.PAYMENTRULE IS NOT NULL THEN (L.NAME) END AS PAYMENTRULER," +
      "		 L1.NAME AS DOCACTION_BTN," +
      "		 AD_COLUMN_IDENTIFIER(TO_CHAR('C_BPartner'), TO_CHAR(I.C_BPARTNER_ID), TO_CHAR(?)) AS C_BPARTNER_ID_D," +
      "		 '' AS AD_WINDOW_ID," +
      "		 '' AS AD_TAB_ID," +
      "		 '' AS TABNAME," +
      "		 '' AS WINDOWNAME," +
      "		 '' AS WINDOWNAME_EN_US," +
      "		 '' AS TABNAME_EN_US, " +
      "     '' AS AD_TABLE_ID," +
      "     to_char(?) AS dateformat" +
      "      FROM  AD_REF_LIST_V L  LEFT OUTER JOIN  AD_REF_LIST_V L1  ON  135  = L1.AD_REFERENCE_ID" +
      "         AND	L1.AD_LANGUAGE  = ?   " +
      "        RIGHT OUTER JOIN  C_INVOICE I  ON  CASE I.DOCACTION WHEN '--' THEN 'CL' ELSE I.DOCACTION END  = L1.VALUE" +
      "         AND	L.AD_LANGUAGE  = ?  " +
      "      WHERE	 I.ISSOTRX  = 'N'" +
      "       AND	195  = L.AD_REFERENCE_ID" +
      "       AND	I.PAYMENTRULE  = L.VALUE" +
      "       AND	I.C_INVOICE_ID  = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        InvoiceVendorMultilineData objectInvoiceVendorMultilineData = new InvoiceVendorMultilineData();
        objectInvoiceVendorMultilineData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectInvoiceVendorMultilineData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInvoiceVendorMultilineData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInvoiceVendorMultilineData.isactive = UtilSql.getValue(result, "isactive");
        objectInvoiceVendorMultilineData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectInvoiceVendorMultilineData.createdby = UtilSql.getValue(result, "createdby");
        objectInvoiceVendorMultilineData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectInvoiceVendorMultilineData.updatedby = UtilSql.getValue(result, "updatedby");
        objectInvoiceVendorMultilineData.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoiceVendorMultilineData.documentno = UtilSql.getValue(result, "documentno");
        objectInvoiceVendorMultilineData.docstatus = UtilSql.getValue(result, "docstatus");
        objectInvoiceVendorMultilineData.docaction = UtilSql.getValue(result, "docaction");
        objectInvoiceVendorMultilineData.processing = UtilSql.getValue(result, "processing");
        objectInvoiceVendorMultilineData.processed = UtilSql.getValue(result, "processed");
        objectInvoiceVendorMultilineData.posted = UtilSql.getValue(result, "posted");
        objectInvoiceVendorMultilineData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectInvoiceVendorMultilineData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectInvoiceVendorMultilineData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectInvoiceVendorMultilineData.description = UtilSql.getValue(result, "description");
        objectInvoiceVendorMultilineData.isprinted = UtilSql.getValue(result, "isprinted");
        objectInvoiceVendorMultilineData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectInvoiceVendorMultilineData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoiceVendorMultilineData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectInvoiceVendorMultilineData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectInvoiceVendorMultilineData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectInvoiceVendorMultilineData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectInvoiceVendorMultilineData.poreference = UtilSql.getValue(result, "poreference");
        objectInvoiceVendorMultilineData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectInvoiceVendorMultilineData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectInvoiceVendorMultilineData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectInvoiceVendorMultilineData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectInvoiceVendorMultilineData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectInvoiceVendorMultilineData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectInvoiceVendorMultilineData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectInvoiceVendorMultilineData.totallines = UtilSql.getValue(result, "totallines");
        objectInvoiceVendorMultilineData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectInvoiceVendorMultilineData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectInvoiceVendorMultilineData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectInvoiceVendorMultilineData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectInvoiceVendorMultilineData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectInvoiceVendorMultilineData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectInvoiceVendorMultilineData.createfrom = UtilSql.getValue(result, "createfrom");
        objectInvoiceVendorMultilineData.generateto = UtilSql.getValue(result, "generateto");
        objectInvoiceVendorMultilineData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectInvoiceVendorMultilineData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectInvoiceVendorMultilineData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectInvoiceVendorMultilineData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectInvoiceVendorMultilineData.user1Id = UtilSql.getValue(result, "user1_id");
        objectInvoiceVendorMultilineData.user2Id = UtilSql.getValue(result, "user2_id");
        objectInvoiceVendorMultilineData.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectInvoiceVendorMultilineData.docactionBtn = UtilSql.getValue(result, "docaction_btn");
        objectInvoiceVendorMultilineData.cBpartnerIdD = UtilSql.getValue(result, "c_bpartner_id_d");
        objectInvoiceVendorMultilineData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectInvoiceVendorMultilineData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectInvoiceVendorMultilineData.tabname = UtilSql.getValue(result, "tabname");
        objectInvoiceVendorMultilineData.windowname = UtilSql.getValue(result, "windowname");
        objectInvoiceVendorMultilineData.windownameEnUs = UtilSql.getValue(result, "windowname_en_us");
        objectInvoiceVendorMultilineData.tabnameEnUs = UtilSql.getValue(result, "tabname_en_us");
        objectInvoiceVendorMultilineData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectInvoiceVendorMultilineData.dateformat = UtilSql.getValue(result, "dateformat");
        objectInvoiceVendorMultilineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceVendorMultilineData);
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
    InvoiceVendorMultilineData objectInvoiceVendorMultilineData[] = new InvoiceVendorMultilineData[vector.size()];
    vector.copyInto(objectInvoiceVendorMultilineData);
    return(objectInvoiceVendorMultilineData);
  }

  public static InvoiceVendorMultilineData[] set(String adOrgId, String adClientId, String dateacct, String docstatus, String docaction, String docactionBtn, String totallines, String grandtotal)    throws ServletException {
    InvoiceVendorMultilineData objectInvoiceVendorMultilineData[] = new InvoiceVendorMultilineData[1];
    objectInvoiceVendorMultilineData[0] = new InvoiceVendorMultilineData();
    objectInvoiceVendorMultilineData[0].cInvoiceId = "";
    objectInvoiceVendorMultilineData[0].adClientId = adClientId;
    objectInvoiceVendorMultilineData[0].adOrgId = adOrgId;
    objectInvoiceVendorMultilineData[0].isactive = "";
    objectInvoiceVendorMultilineData[0].created = "";
    objectInvoiceVendorMultilineData[0].createdby = "";
    objectInvoiceVendorMultilineData[0].updated = "";
    objectInvoiceVendorMultilineData[0].updatedby = "";
    objectInvoiceVendorMultilineData[0].issotrx = "";
    objectInvoiceVendorMultilineData[0].documentno = "";
    objectInvoiceVendorMultilineData[0].docstatus = docstatus;
    objectInvoiceVendorMultilineData[0].docaction = docaction;
    objectInvoiceVendorMultilineData[0].processing = "";
    objectInvoiceVendorMultilineData[0].processed = "";
    objectInvoiceVendorMultilineData[0].posted = "";
    objectInvoiceVendorMultilineData[0].cDoctypeId = "";
    objectInvoiceVendorMultilineData[0].cDoctypetargetId = "";
    objectInvoiceVendorMultilineData[0].cOrderId = "";
    objectInvoiceVendorMultilineData[0].description = "";
    objectInvoiceVendorMultilineData[0].isprinted = "";
    objectInvoiceVendorMultilineData[0].salesrepId = "";
    objectInvoiceVendorMultilineData[0].dateinvoiced = "";
    objectInvoiceVendorMultilineData[0].dateprinted = "";
    objectInvoiceVendorMultilineData[0].dateacct = dateacct;
    objectInvoiceVendorMultilineData[0].cBpartnerId = "";
    objectInvoiceVendorMultilineData[0].cBpartnerLocationId = "";
    objectInvoiceVendorMultilineData[0].poreference = "";
    objectInvoiceVendorMultilineData[0].isdiscountprinted = "";
    objectInvoiceVendorMultilineData[0].dateordered = "";
    objectInvoiceVendorMultilineData[0].cCurrencyId = "";
    objectInvoiceVendorMultilineData[0].paymentrule = "";
    objectInvoiceVendorMultilineData[0].cPaymenttermId = "";
    objectInvoiceVendorMultilineData[0].cChargeId = "";
    objectInvoiceVendorMultilineData[0].chargeamt = "";
    objectInvoiceVendorMultilineData[0].totallines = totallines;
    objectInvoiceVendorMultilineData[0].grandtotal = grandtotal;
    objectInvoiceVendorMultilineData[0].mPricelistId = "";
    objectInvoiceVendorMultilineData[0].istaxincluded = "";
    objectInvoiceVendorMultilineData[0].cCampaignId = "";
    objectInvoiceVendorMultilineData[0].cProjectId = "";
    objectInvoiceVendorMultilineData[0].cActivityId = "";
    objectInvoiceVendorMultilineData[0].createfrom = "";
    objectInvoiceVendorMultilineData[0].generateto = "";
    objectInvoiceVendorMultilineData[0].adUserId = "";
    objectInvoiceVendorMultilineData[0].copyfrom = "";
    objectInvoiceVendorMultilineData[0].isselfservice = "";
    objectInvoiceVendorMultilineData[0].adOrgtrxId = "";
    objectInvoiceVendorMultilineData[0].user1Id = "";
    objectInvoiceVendorMultilineData[0].user2Id = "";
    objectInvoiceVendorMultilineData[0].paymentruler = "";
    objectInvoiceVendorMultilineData[0].docactionBtn = docactionBtn;
    objectInvoiceVendorMultilineData[0].cBpartnerIdD = "";
    objectInvoiceVendorMultilineData[0].adWindowId = "";
    objectInvoiceVendorMultilineData[0].adTabId = "";
    objectInvoiceVendorMultilineData[0].tabname = "";
    objectInvoiceVendorMultilineData[0].windowname = "";
    objectInvoiceVendorMultilineData[0].windownameEnUs = "";
    objectInvoiceVendorMultilineData[0].tabnameEnUs = "";
    objectInvoiceVendorMultilineData[0].adTableId = "";
    objectInvoiceVendorMultilineData[0].dateformat = "";
    return objectInvoiceVendorMultilineData;
  }

  public static String selectDocAction(ConnectionProvider connectionProvider, String adLanguage, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT name as id " +
      "      FROM AD_REF_LIST_V " +
      "      WHERE AD_REFERENCE_ID = '135' " +
      "      AND AD_LANGUAGE = ?" +
      "      AND VALUE = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static InvoiceVendorMultilineData[] selectWindowData(ConnectionProvider connectionProvider, String adLanguage, String classname)    throws ServletException {
    return selectWindowData(connectionProvider, adLanguage, classname, 0, 0);
  }

  public static InvoiceVendorMultilineData[] selectWindowData(ConnectionProvider connectionProvider, String adLanguage, String classname, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT T.AD_WINDOW_ID, T.AD_TAB_ID, T.AD_TABLE_ID, " +
      "      (CASE WHEN TT.NAME IS NULL THEN T.NAME ELSE TT.NAME END) AS TABNAME, " +
      "      (CASE WHEN WT.NAME IS NULL THEN W.NAME ELSE WT.NAME END) AS WINDOWNAME, " +
      "      W.NAME AS WINDOWNAME_EN_US, T.NAME AS TABNAME_EN_US " +
      "      FROM AD_TAB T left join AD_TAB_TRL TT on T.AD_TAB_ID = TT.AD_TAB_ID" +
      "                                            and TT.AD_LANGUAGE = ? ," +
      "           AD_WINDOW w left join AD_WINDOW_TRL WT on W.AD_WINDOW_ID = WT.AD_WINDOW_ID" +
      "                                            and WT.AD_LANGUAGE = ?, " +
      "        AD_FORM F " +
      "      WHERE T.EDITREFERENCE = F.AD_FORM_ID " +
      "      AND T.AD_WINDOW_ID = W.AD_WINDOW_ID " +
      "      AND UPPER(F.CLASSNAME) = UPPER(?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classname);

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
        InvoiceVendorMultilineData objectInvoiceVendorMultilineData = new InvoiceVendorMultilineData();
        objectInvoiceVendorMultilineData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectInvoiceVendorMultilineData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectInvoiceVendorMultilineData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectInvoiceVendorMultilineData.tabname = UtilSql.getValue(result, "tabname");
        objectInvoiceVendorMultilineData.windowname = UtilSql.getValue(result, "windowname");
        objectInvoiceVendorMultilineData.windownameEnUs = UtilSql.getValue(result, "windowname_en_us");
        objectInvoiceVendorMultilineData.tabnameEnUs = UtilSql.getValue(result, "tabname_en_us");
        objectInvoiceVendorMultilineData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoiceVendorMultilineData);
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
    InvoiceVendorMultilineData objectInvoiceVendorMultilineData[] = new InvoiceVendorMultilineData[vector.size()];
    vector.copyInto(objectInvoiceVendorMultilineData);
    return(objectInvoiceVendorMultilineData);
  }

  public static String selectDocTypeTarget(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient, String AD_Client_ID, String IsSOTrx)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_DocType.C_DocType_ID as id " +
      "      FROM C_DocType" +
      "      WHERE C_DocType.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "      AND C_DocType.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND C_DocType.AD_Client_ID=? " +
      "      AND C_DocType.DocBaseType IN ('ARI', 'API','ARC','APC') " +
      "      AND C_DocType.IsSOTrx=? " +
      "      AND C_DocType.isActive = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IsSOTrx);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static String selectDocType(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_DocType.C_DocType_ID as id" +
      "      FROM C_DocType" +
      "      WHERE C_DocType.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "      AND C_DocType.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND C_DocType.isActive = 'Y' " +
      "      ORDER BY name";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static String selectPriceList(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT M_PriceList.M_PriceList_ID as id " +
      "      FROM M_PriceList " +
      "      WHERE M_PriceList.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "      AND M_PriceList.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND M_PriceList.isActive = 'Y'" +
      "      ORDER BY name";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public static String selectCurrency(ConnectionProvider connectionProvider, String adOrgClient, String adUserClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency.C_Currency_ID as id " +
      "      FROM C_Currency" +
      "      WHERE C_Currency.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "      AND C_Currency.AD_Client_ID IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "      AND C_Currency.isActive = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "id");
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

  public int update(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Invoice SET IsTaxIncluded = ?, IsSOTrx = ?," +
      "        IsPrinted = ?, IsSelfService = ?, C_Invoice_ID = ?, DatePrinted = TO_DATE(?), " +
      "        AD_Client_ID = ?, AD_Org_ID = ?, C_Order_ID = ?, DateOrdered = TO_DATE(?), DocumentNo = ?, " +
      "        POReference = ?, Description = ?, IsActive = ?, C_DocTypeTarget_ID = ?, DateInvoiced = TO_DATE(?), DateAcct = TO_DATE(?), " +
      "        C_BPartner_ID = ?, C_BPartner_Location_ID = ?, AD_User_ID = ?, M_PriceList_ID = ?, C_Currency_ID = ?, " +
      "        SalesRep_ID = ?, IsDiscountPrinted = ?, C_Charge_ID = ?, ChargeAmt = TO_NUMBER(?), PaymentRule = ?, C_PaymentTerm_ID = ?, " +
      "        CreateFrom = ?, GenerateTo = ?, C_Project_ID = ?, C_Activity_ID = ?, C_Campaign_ID = ?, AD_OrgTrx_ID = ?, " +
      "        User1_ID = ?, User2_ID = ?, DocStatus = ?, C_DocType_ID = ?, CopyFrom = ?, " +
      "        DocAction = ?, Posted = ?, updated = now(), updatEDBY = ? " +
      "        WHERE C_Invoice.C_Invoice_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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

  public int insert(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_Invoice (Processing, IsTaxIncluded, IsSOTrx, IsPrinted, " +
      "        Processed, IsSelfService, C_Invoice_ID, DatePrinted, AD_Client_ID, AD_Org_ID, C_Order_ID, DateOrdered, " +
      "        DocumentNo, POReference, Description, IsActive, C_DocTypeTarget_ID, DateInvoiced, DateAcct, TaxDate, C_BPartner_ID, " +
      "        C_BPartner_Location_ID, AD_User_ID, M_PriceList_ID, C_Currency_ID, SalesRep_ID, IsDiscountPrinted, C_Charge_ID, " +
      "        ChargeAmt, PaymentRule, C_PaymentTerm_ID, CreateFrom, GenerateTo, C_Project_ID, C_Activity_ID, C_Campaign_ID, " +
      "        AD_OrgTrx_ID, User1_ID, User2_ID, DocStatus, C_DocType_ID, CopyFrom, DocAction, Posted, " +
      "        created, createdby, updated, updatedBy)" +
      "        VALUES (?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?), ?, ?, ?, ?, TO_DATE(?), ?, ?, ?, ?, ?, TO_DATE(?), TO_DATE(?), TO_DATE(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
      "        ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_INVOICE " +
      "        WHERE C_INVOICE.C_INVOICE_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
}

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

class GenerateInvoicesmanualData implements FieldProvider {
static Logger log4j = Logger.getLogger(GenerateInvoicesmanualData.class);
  private String InitRecordNumber="0";
  public String linkname;
  public String targetwindowurl;
  public String fieldid;
  public String cOrderId;
  public String cdoctypename;
  public String documentno;
  public String cbpartnername;
  public String dateordered;
  public String datepromised;
  public String amountlines;
  public String notinvoicedlines;
  public String termname;
  public String termvalue;
  public String pendinglines;
  public String mProductId;
  public String positionline;
  public String qtydelivered;
  public String qtyordered;
  public String orderlineid;
  public String qtydiffpending;
  public String mInoutlineId;
  public String orderlineidkey;
  public String lineprice;
  public String pricenet;
  public String priceactual;
  public String pendingamt;
  public String oldescription;
  public String searchkey;
  public String project;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("linkname"))
      return linkname;
    else if (fieldName.equalsIgnoreCase("targetwindowurl"))
      return targetwindowurl;
    else if (fieldName.equalsIgnoreCase("fieldid"))
      return fieldid;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("cdoctypename"))
      return cdoctypename;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("cbpartnername"))
      return cbpartnername;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("amountlines"))
      return amountlines;
    else if (fieldName.equalsIgnoreCase("notinvoicedlines"))
      return notinvoicedlines;
    else if (fieldName.equalsIgnoreCase("termname"))
      return termname;
    else if (fieldName.equalsIgnoreCase("termvalue"))
      return termvalue;
    else if (fieldName.equalsIgnoreCase("pendinglines"))
      return pendinglines;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("positionline"))
      return positionline;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("orderlineid"))
      return orderlineid;
    else if (fieldName.equalsIgnoreCase("qtydiffpending"))
      return qtydiffpending;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("orderlineidkey"))
      return orderlineidkey;
    else if (fieldName.equalsIgnoreCase("lineprice"))
      return lineprice;
    else if (fieldName.equalsIgnoreCase("pricenet"))
      return pricenet;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("pendingamt"))
      return pendingamt;
    else if (fieldName.equalsIgnoreCase("oldescription"))
      return oldescription;
    else if (fieldName.equalsIgnoreCase("searchkey"))
      return searchkey;
    else if (fieldName.equalsIgnoreCase("project"))
      return project;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GenerateInvoicesmanualData[] select(ConnectionProvider connectionProvider, String language, String issotrx, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId)    throws ServletException {
    return select(connectionProvider, language, issotrx, adUserClient, adUserOrg, parBPartner, parDateFrom, parDateTo, adOrgId, 0, 0);
  }

  public static GenerateInvoicesmanualData[] select(ConnectionProvider connectionProvider, String language, String issotrx, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT " +
      "        CASE icl.issotrx WHEN 'Y' THEN 'SalesOrder' WHEN 'N' THEN 'PurchaseOrder' END AS linkname, " +
      "        CASE icl.C_DocType_ID " +
      "           WHEN '6C8EA6FFBB2B4ACBA0542BA4F833C499' THEN 'SubscriptionIntervals_Relation.html' " +
      "           ELSE 'Header_Relation.html' END AS targetwindowurl,     " +
      "        CASE icl.C_DocType_ID " +
      "           WHEN '6C8EA6FFBB2B4ACBA0542BA4F833C499' THEN 'inpcSubscriptionintervalViewId'" +
      "           ELSE 'inpcOrderId' END AS fieldid,     " +
      "      icl.C_Order_ID,  ad_get_doctypename(icl.C_DocType_ID,?) as cdoctypename, icl.DocumentNo, bp.Name||' - '||bp.value as cbpartnername, icl.DateOrdered,icl.datepromised," +
      "      icl.amountlines, " +
      "      zssi_notinvoicedAmt4order(icl.c_order_id,'ALL') as notinvoicedlines, " +
      "      l.Name as TermName, l.Value as TermValue, " +
      "      zssi_notinvoicedAmt4order(icl.c_order_id,'PENDING') as pendinglines, " +
      "      zssi_limitlength55(coalesce((select m_product_po.vendorproductno from m_product_po, c_orderline,c_order where m_product_po.m_product_id=icl.m_product_id and icl.c_orderline_id=c_orderline.c_orderline_id and c_order.c_order_id=c_orderline.c_order_id and c_order.c_bpartner_id=m_product_po.c_bpartner_id AND m_product_po.vendorproductno is not null),' ')||' - '||AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(icl.m_product_id), ?)) as m_product_id, icl.line as positionline," +
      "      icl.qtydelivered,icl.qtyordered,icl.c_orderline_id||coalesce(icl.m_inoutline_id,'') as orderlineid, " +
      "      icl.pendingqty as qtydiffpending, icl.m_inoutline_id,icl.c_orderline_id as orderlineidkey," +
      "      icl.lineprice, icl.pendingprice as pricenet, icl.priceactual as priceactual, icl.pendingamt, icl.description as oldescription, bp.value as searchkey," +
      "      zssi_getprojectorcostcentername(icl.c_project_id,icl.a_asset_id) as PROJECT " +
      "      FROM c_invoice_candidate_lines_v icl, C_BPartner bp, AD_Ref_List l left join AD_Ref_List_trl ltrl on l.AD_Ref_List_ID=ltrl.AD_Ref_List_ID and ltrl.ad_language=?" +
      "      WHERE icl.C_BPartner_ID=bp.C_BPartner_ID" +
      "      AND l.value = icl.term" +
      "      AND icl.term <> 'N'" +
      "      AND AD_Reference_ID='150'" +
      "      AND icl.issotrx = ?" +
      "      AND icl.ad_client_id in (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND icl.ad_org_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND coalesce(icl.m_inout_doctype_id,'') not in ('2317023F9771481696461C5EAF9A0915','2E1E735AA91A49F8BC7181D31B09B370') " +
      "      AND 1=1";
    strSql = strSql + ((parBPartner==null || parBPartner.equals(""))?"":" AND icl.C_BPartner_ID= ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND icl.DateOrdered >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND icl.DateOrdered < TO_DATE(?) ");
    strSql = strSql + 
      "      AND 2=2 AND icl.ad_org_id in (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      ORDER BY cbpartnername ,DatePromised,DateOrdered, DocumentNo, positionline";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parBPartner != null && !(parBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartner);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        GenerateInvoicesmanualData objectGenerateInvoicesmanualData = new GenerateInvoicesmanualData();
        objectGenerateInvoicesmanualData.linkname = UtilSql.getValue(result, "linkname");
        objectGenerateInvoicesmanualData.targetwindowurl = UtilSql.getValue(result, "targetwindowurl");
        objectGenerateInvoicesmanualData.fieldid = UtilSql.getValue(result, "fieldid");
        objectGenerateInvoicesmanualData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectGenerateInvoicesmanualData.cdoctypename = UtilSql.getValue(result, "cdoctypename");
        objectGenerateInvoicesmanualData.documentno = UtilSql.getValue(result, "documentno");
        objectGenerateInvoicesmanualData.cbpartnername = UtilSql.getValue(result, "cbpartnername");
        objectGenerateInvoicesmanualData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectGenerateInvoicesmanualData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectGenerateInvoicesmanualData.amountlines = UtilSql.getValue(result, "amountlines");
        objectGenerateInvoicesmanualData.notinvoicedlines = UtilSql.getValue(result, "notinvoicedlines");
        objectGenerateInvoicesmanualData.termname = UtilSql.getValue(result, "termname");
        objectGenerateInvoicesmanualData.termvalue = UtilSql.getValue(result, "termvalue");
        objectGenerateInvoicesmanualData.pendinglines = UtilSql.getValue(result, "pendinglines");
        objectGenerateInvoicesmanualData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectGenerateInvoicesmanualData.positionline = UtilSql.getValue(result, "positionline");
        objectGenerateInvoicesmanualData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectGenerateInvoicesmanualData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectGenerateInvoicesmanualData.orderlineid = UtilSql.getValue(result, "orderlineid");
        objectGenerateInvoicesmanualData.qtydiffpending = UtilSql.getValue(result, "qtydiffpending");
        objectGenerateInvoicesmanualData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectGenerateInvoicesmanualData.orderlineidkey = UtilSql.getValue(result, "orderlineidkey");
        objectGenerateInvoicesmanualData.lineprice = UtilSql.getValue(result, "lineprice");
        objectGenerateInvoicesmanualData.pricenet = UtilSql.getValue(result, "pricenet");
        objectGenerateInvoicesmanualData.priceactual = UtilSql.getValue(result, "priceactual");
        objectGenerateInvoicesmanualData.pendingamt = UtilSql.getValue(result, "pendingamt");
        objectGenerateInvoicesmanualData.oldescription = UtilSql.getValue(result, "oldescription");
        objectGenerateInvoicesmanualData.searchkey = UtilSql.getValue(result, "searchkey");
        objectGenerateInvoicesmanualData.project = UtilSql.getValue(result, "project");
        objectGenerateInvoicesmanualData.rownum = Long.toString(countRecord);
        objectGenerateInvoicesmanualData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateInvoicesmanualData);
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
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[vector.size()];
    vector.copyInto(objectGenerateInvoicesmanualData);
    return(objectGenerateInvoicesmanualData);
  }

  public static GenerateInvoicesmanualData[] set()    throws ServletException {
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[1];
    objectGenerateInvoicesmanualData[0] = new GenerateInvoicesmanualData();
    objectGenerateInvoicesmanualData[0].linkname = "";
    objectGenerateInvoicesmanualData[0].targetwindowurl = "";
    objectGenerateInvoicesmanualData[0].fieldid = "";
    objectGenerateInvoicesmanualData[0].cOrderId = "";
    objectGenerateInvoicesmanualData[0].cdoctypename = "";
    objectGenerateInvoicesmanualData[0].documentno = "";
    objectGenerateInvoicesmanualData[0].cbpartnername = "";
    objectGenerateInvoicesmanualData[0].dateordered = "";
    objectGenerateInvoicesmanualData[0].datepromised = "";
    objectGenerateInvoicesmanualData[0].amountlines = "";
    objectGenerateInvoicesmanualData[0].notinvoicedlines = "";
    objectGenerateInvoicesmanualData[0].termname = "";
    objectGenerateInvoicesmanualData[0].termvalue = "";
    objectGenerateInvoicesmanualData[0].pendinglines = "";
    objectGenerateInvoicesmanualData[0].mProductId = "";
    objectGenerateInvoicesmanualData[0].positionline = "";
    objectGenerateInvoicesmanualData[0].qtydelivered = "";
    objectGenerateInvoicesmanualData[0].qtyordered = "";
    objectGenerateInvoicesmanualData[0].orderlineid = "";
    objectGenerateInvoicesmanualData[0].qtydiffpending = "";
    objectGenerateInvoicesmanualData[0].mInoutlineId = "";
    objectGenerateInvoicesmanualData[0].orderlineidkey = "";
    objectGenerateInvoicesmanualData[0].lineprice = "";
    objectGenerateInvoicesmanualData[0].pricenet = "";
    objectGenerateInvoicesmanualData[0].priceactual = "";
    objectGenerateInvoicesmanualData[0].pendingamt = "";
    objectGenerateInvoicesmanualData[0].oldescription = "";
    objectGenerateInvoicesmanualData[0].searchkey = "";
    objectGenerateInvoicesmanualData[0].project = "";
    return objectGenerateInvoicesmanualData;
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM C_BPARTNER " +
      "    WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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

  public static GenerateInvoicesmanualData[] selectOrderlines(ConnectionProvider connectionProvider, String corderId)    throws ServletException {
    return selectOrderlines(connectionProvider, corderId, 0, 0);
  }

  public static GenerateInvoicesmanualData[] selectOrderlines(ConnectionProvider connectionProvider, String corderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ORDERLINE_ID as orderlineid from c_orderline" +
      "        WHERE c_order_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, corderId);

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
        GenerateInvoicesmanualData objectGenerateInvoicesmanualData = new GenerateInvoicesmanualData();
        objectGenerateInvoicesmanualData.orderlineid = UtilSql.getValue(result, "orderlineid");
        objectGenerateInvoicesmanualData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateInvoicesmanualData);
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
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[vector.size()];
    vector.copyInto(objectGenerateInvoicesmanualData);
    return(objectGenerateInvoicesmanualData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cGenerateinvoicemanualId, String cOrderlineId, String cOrderId, String adClientId, String adOrgId, String createdby, String updatedby, String qty, String price, String lineamt, String ignoreresidue, String description, String mInoutlineId, String pInstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_GENERATEINVOICEMANUAL(C_GENERATEINVOICEMANUAL_ID, C_ORDERLINE_ID, C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID,  CREATEDBY, UPDATEDBY, QTY, PRICE, LINEAMT,IGNORERESIDUE, DESCRIPTION, M_InOutLine_ID,pinstance_id)" +
      "      VALUES(?, ?, ?, ?, ?, ?, ?, TO_NUMBER(?), TO_NUMBER(?),TO_NUMBER(?), ?, ?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGenerateinvoicemanualId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ignoreresidue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pInstanceId);

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

  public static int deleteerror(ConnectionProvider connectionProvider, String pInstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM C_GENERATEINVOICEMANUAL where c_invoiceline_id is null and pinstance_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pInstanceId);

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

//Sqlc generated V1.O00-1
package org.openz.controller.form;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class GenerateMinoutmanualData implements FieldProvider {
static Logger log4j = Logger.getLogger(GenerateMinoutmanualData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cOrderId;
  public String aAssetId;
  public String cOrderlineId;
  public String cProjectId;
  public String cProjecttaskId;
  public String mShipperId;
  public String salesrepId;
  public String cDoctypeId;
  public String issotrx;
  public String cBpartnerId;
  public String businesspartner;
  public String mLocatorId;
  public String documentno;
  public String projectname;
  public String doctypename;
  public String dateordered;
  public String datepromised;
  public String shipperName;
  public String salesrepname;
  public String totallines;
  public String grandtotal;
  public String line;
  public String productName;
  public String qtyordered;
  public String qtydelivered;
  public String qtyavailable;
  public String qty2deliver;
  public String description;
  public String completed;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("businesspartner"))
      return businesspartner;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("projectname"))
      return projectname;
    else if (fieldName.equalsIgnoreCase("doctypename"))
      return doctypename;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("shipper_name") || fieldName.equals("shipperName"))
      return shipperName;
    else if (fieldName.equalsIgnoreCase("salesrepname"))
      return salesrepname;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("qtyavailable"))
      return qtyavailable;
    else if (fieldName.equalsIgnoreCase("qty2deliver"))
      return qty2deliver;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("completed"))
      return completed;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GenerateMinoutmanualData[] select(ConnectionProvider connectionProvider, String language, String parProduct, String parDateFrom, String parDateTo, String parVendor, String adOrgId, String issotrx)    throws ServletException {
    return select(connectionProvider, language, parProduct, parDateFrom, parDateTo, parVendor, adOrgId, issotrx, 0, 0);
  }

  public static GenerateMinoutmanualData[] select(ConnectionProvider connectionProvider, String language, String parProduct, String parDateFrom, String parDateTo, String parVendor, String adOrgId, String issotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ad_client_id, ad_org_id, c_order_id, a_asset_id, c_orderline_id, c_project_id, c_projecttask_id, m_shipper_id, salesrep_id, c_doctype_id, issotrx," +
      "     c_bpartner_id,  zssi_getbpname(c_bpartner_id) as businesspartner, m_locator_id," +
      "      documentno,  projectname, zssi_GetDocText(c_doctype_id, ?) as doctypename, dateordered, datepromised, shipper_name, zssi_getusernamecomplete(salesrep_id,?) as salesrepname, totallines, grandtotal," +
      "      line, zssi_getproductname(m_product_id,?) as product_name, qtyordered, qtydelivered, qtyavailable, qty2deliver, description, 'N' as completed" +
      "      from m_inout_candidate_v " +
      "      where 1=1";
    strSql = strSql + ((parProduct==null || parProduct.equals(""))?"":"  AND m_inout_candidate_v.M_PRODUCT_ID = TO_CHAR(?) ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND m_inout_candidate_v.datepromised >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND m_inout_candidate_v.datepromised < TO_DATE(?) ");
    strSql = strSql + ((parVendor==null || parVendor.equals(""))?"":"  AND COALESCE(m_inout_candidate_v.C_BPARTNER_ID, m_inout_candidate_v.C_BPARTNER_ID,'-1') = TO_CHAR(?) ");
    strSql = strSql + 
      "      AND 2=2 AND ad_org_id in (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      AND issotrx = ?" +
      "      order by businesspartner, documentno, line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parProduct != null && !(parProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parProduct);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parVendor != null && !(parVendor.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parVendor);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);

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
        GenerateMinoutmanualData objectGenerateMinoutmanualData = new GenerateMinoutmanualData();
        objectGenerateMinoutmanualData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGenerateMinoutmanualData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGenerateMinoutmanualData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectGenerateMinoutmanualData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectGenerateMinoutmanualData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectGenerateMinoutmanualData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectGenerateMinoutmanualData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectGenerateMinoutmanualData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectGenerateMinoutmanualData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectGenerateMinoutmanualData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectGenerateMinoutmanualData.issotrx = UtilSql.getValue(result, "issotrx");
        objectGenerateMinoutmanualData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectGenerateMinoutmanualData.businesspartner = UtilSql.getValue(result, "businesspartner");
        objectGenerateMinoutmanualData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectGenerateMinoutmanualData.documentno = UtilSql.getValue(result, "documentno");
        objectGenerateMinoutmanualData.projectname = UtilSql.getValue(result, "projectname");
        objectGenerateMinoutmanualData.doctypename = UtilSql.getValue(result, "doctypename");
        objectGenerateMinoutmanualData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectGenerateMinoutmanualData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectGenerateMinoutmanualData.shipperName = UtilSql.getValue(result, "shipper_name");
        objectGenerateMinoutmanualData.salesrepname = UtilSql.getValue(result, "salesrepname");
        objectGenerateMinoutmanualData.totallines = UtilSql.getValue(result, "totallines");
        objectGenerateMinoutmanualData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectGenerateMinoutmanualData.line = UtilSql.getValue(result, "line");
        objectGenerateMinoutmanualData.productName = UtilSql.getValue(result, "product_name");
        objectGenerateMinoutmanualData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectGenerateMinoutmanualData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectGenerateMinoutmanualData.qtyavailable = UtilSql.getValue(result, "qtyavailable");
        objectGenerateMinoutmanualData.qty2deliver = UtilSql.getValue(result, "qty2deliver");
        objectGenerateMinoutmanualData.description = UtilSql.getValue(result, "description");
        objectGenerateMinoutmanualData.completed = UtilSql.getValue(result, "completed");
        objectGenerateMinoutmanualData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateMinoutmanualData);
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
    GenerateMinoutmanualData objectGenerateMinoutmanualData[] = new GenerateMinoutmanualData[vector.size()];
    vector.copyInto(objectGenerateMinoutmanualData);
    return(objectGenerateMinoutmanualData);
  }

  public static GenerateMinoutmanualData[] set()    throws ServletException {
    GenerateMinoutmanualData objectGenerateMinoutmanualData[] = new GenerateMinoutmanualData[1];
    objectGenerateMinoutmanualData[0] = new GenerateMinoutmanualData();
    objectGenerateMinoutmanualData[0].adClientId = "";
    objectGenerateMinoutmanualData[0].adOrgId = "";
    objectGenerateMinoutmanualData[0].cOrderId = "";
    objectGenerateMinoutmanualData[0].aAssetId = "";
    objectGenerateMinoutmanualData[0].cOrderlineId = "";
    objectGenerateMinoutmanualData[0].cProjectId = "";
    objectGenerateMinoutmanualData[0].cProjecttaskId = "";
    objectGenerateMinoutmanualData[0].mShipperId = "";
    objectGenerateMinoutmanualData[0].salesrepId = "";
    objectGenerateMinoutmanualData[0].cDoctypeId = "";
    objectGenerateMinoutmanualData[0].issotrx = "";
    objectGenerateMinoutmanualData[0].cBpartnerId = "";
    objectGenerateMinoutmanualData[0].businesspartner = "";
    objectGenerateMinoutmanualData[0].mLocatorId = "";
    objectGenerateMinoutmanualData[0].documentno = "";
    objectGenerateMinoutmanualData[0].projectname = "";
    objectGenerateMinoutmanualData[0].doctypename = "";
    objectGenerateMinoutmanualData[0].dateordered = "";
    objectGenerateMinoutmanualData[0].datepromised = "";
    objectGenerateMinoutmanualData[0].shipperName = "";
    objectGenerateMinoutmanualData[0].salesrepname = "";
    objectGenerateMinoutmanualData[0].totallines = "";
    objectGenerateMinoutmanualData[0].grandtotal = "";
    objectGenerateMinoutmanualData[0].line = "";
    objectGenerateMinoutmanualData[0].productName = "";
    objectGenerateMinoutmanualData[0].qtyordered = "";
    objectGenerateMinoutmanualData[0].qtydelivered = "";
    objectGenerateMinoutmanualData[0].qtyavailable = "";
    objectGenerateMinoutmanualData[0].qty2deliver = "";
    objectGenerateMinoutmanualData[0].description = "";
    objectGenerateMinoutmanualData[0].completed = "";
    return objectGenerateMinoutmanualData;
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

  public static String getOrder(ConnectionProvider connectionProvider, String cOrderLineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT c_order_id FROM C_orderline where c_orderline_id = ? limit 1 ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderLineId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_order_id");
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

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, String cOrderId, String adClientId, String adOrgId, String createdby, String updatedby, String qty, String mLocatorId, String deliverycomplete, String pInstanceID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_GENERATEMINOUTMANUAL(C_GENERATEMINOUTMANUAL_ID, C_ORDERLINE_ID, C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID,  CREATEDBY, UPDATEDBY, QTY, M_LOCATOR_ID, DELIVERYCOMPLETE,pinstance_id)" +
      "      VALUES(get_uuid(), ?, ?, ?, ?, ?, ?, TO_NUMBER(?), ? , ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pInstanceID);

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

  public static int deleteerror(ConnectionProvider connectionProvider, String pInstanceID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM C_GENERATEMINOUTMANUAL where c_orderline_id is null and pinstance_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pInstanceID);

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

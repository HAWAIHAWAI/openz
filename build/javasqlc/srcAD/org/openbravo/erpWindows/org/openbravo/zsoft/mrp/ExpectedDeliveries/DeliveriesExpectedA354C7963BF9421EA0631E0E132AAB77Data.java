//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.ExpectedDeliveries;

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
class DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data implements FieldProvider {
static Logger log4j = Logger.getLogger(DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mrpDeliveriesExpectedId;
  public String mProductId;
  public String mProductIdr;
  public String description;
  public String salesrepId;
  public String salesrepIdr;
  public String qtyordered;
  public String qtydelivered;
  public String isactive;
  public String cOrderId;
  public String cOrderIdr;
  public String scheddeliverydate;
  public String adClientId;
  public String cProjectId;
  public String cProjectIdr;
  public String adOrgId;
  public String aAssetId;
  public String aAssetIdr;
  public String line;
  public String datedelivered;
  public String dateordered;
  public String overdue;
  public String datepromised;
  public String cProjectphaseId;
  public String cProjecttaskId;
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
    else if (fieldName.equalsIgnoreCase("mrp_deliveries_expected_id") || fieldName.equals("mrpDeliveriesExpectedId"))
      return mrpDeliveriesExpectedId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("datedelivered"))
      return datedelivered;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("overdue"))
      return overdue;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
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
  public static DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(mrp_deliveries_expected.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_deliveries_expected.CreatedBy) as CreatedByR, " +
      "        to_char(mrp_deliveries_expected.Updated, ?) as updated, " +
      "        to_char(mrp_deliveries_expected.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        mrp_deliveries_expected.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_deliveries_expected.UpdatedBy) as UpdatedByR," +
      "        mrp_deliveries_expected.MRP_Deliveries_Expected_ID, " +
      "mrp_deliveries_expected.M_Product_ID, " +
      "(CASE WHEN mrp_deliveries_expected.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "mrp_deliveries_expected.Description, " +
      "mrp_deliveries_expected.Salesrep_ID, " +
      "(CASE WHEN mrp_deliveries_expected.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "mrp_deliveries_expected.Qtyordered, " +
      "mrp_deliveries_expected.Qtydelivered, " +
      "COALESCE(mrp_deliveries_expected.Isactive, 'N') AS Isactive, " +
      "mrp_deliveries_expected.C_Order_ID, " +
      "(CASE WHEN mrp_deliveries_expected.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "mrp_deliveries_expected.Scheddeliverydate, " +
      "mrp_deliveries_expected.AD_Client_ID, " +
      "mrp_deliveries_expected.C_Project_ID, " +
      "(CASE WHEN mrp_deliveries_expected.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "mrp_deliveries_expected.AD_Org_ID, " +
      "mrp_deliveries_expected.A_Asset_ID, " +
      "(CASE WHEN mrp_deliveries_expected.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "mrp_deliveries_expected.Line, " +
      "mrp_deliveries_expected.Datedelivered, " +
      "mrp_deliveries_expected.Dateordered, " +
      "COALESCE(mrp_deliveries_expected.Overdue, 'N') AS Overdue, " +
      "mrp_deliveries_expected.Datepromised, " +
      "mrp_deliveries_expected.C_Projectphase_ID, " +
      "mrp_deliveries_expected.C_Projecttask_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM mrp_deliveries_expected left join (select M_Product_ID, Value, Name from M_Product) table1 on (mrp_deliveries_expected.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table2 on (mrp_deliveries_expected.Salesrep_ID =  table2.AD_User_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table3 on (mrp_deliveries_expected.C_Order_ID = table3.C_Order_ID) left join (select C_Project_ID, Value, Name from C_Project) table4 on (mrp_deliveries_expected.C_Project_ID = table4.C_Project_ID) left join (select A_Asset_ID, Name from A_Asset) table5 on (mrp_deliveries_expected.A_Asset_ID = table5.A_Asset_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND mrp_deliveries_expected.MRP_Deliveries_Expected_ID = ? " +
      "        AND mrp_deliveries_expected.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND mrp_deliveries_expected.AD_Org_ID IN (";
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
        DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data = new DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data();
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.created = UtilSql.getValue(result, "created");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.updated = UtilSql.getValue(result, "updated");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.mrpDeliveriesExpectedId = UtilSql.getValue(result, "mrp_deliveries_expected_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.description = UtilSql.getValue(result, "description");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.isactive = UtilSql.getValue(result, "isactive");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.line = UtilSql.getValue(result, "line");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.datedelivered = UtilSql.getDateValue(result, "datedelivered", "dd-MM-yyyy");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.overdue = UtilSql.getValue(result, "overdue");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.language = UtilSql.getValue(result, "language");
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.adUserClient = "";
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.adOrgClient = "";
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.createdby = "";
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.trBgcolor = "";
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.totalCount = "";
        objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data);
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
    DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[] = new DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[vector.size()];
    vector.copyInto(objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data);
    return(objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data);
  }

/**
Create a registry
 */
  public static DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[] set(String adOrgId, String isactive, String adClientId, String qtyordered, String line, String cOrderId, String overdue, String cProjectphaseId, String mrpDeliveriesExpectedId, String datedelivered, String updatedby, String updatedbyr, String description, String dateordered, String scheddeliverydate, String mProductId, String mProductIdr, String createdby, String createdbyr, String salesrepId, String cProjecttaskId, String qtydelivered, String datepromised, String cProjectId, String aAssetId)    throws ServletException {
    DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[] = new DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[1];
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0] = new DeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data();
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].created = "";
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].createdbyr = createdbyr;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].updated = "";
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].updatedTimeStamp = "";
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].updatedby = updatedby;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].updatedbyr = updatedbyr;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].mrpDeliveriesExpectedId = mrpDeliveriesExpectedId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].mProductId = mProductId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].mProductIdr = mProductIdr;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].description = description;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].salesrepId = salesrepId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].salesrepIdr = "";
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].qtyordered = qtyordered;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].qtydelivered = qtydelivered;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].isactive = isactive;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].cOrderId = cOrderId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].cOrderIdr = "";
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].scheddeliverydate = scheddeliverydate;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].adClientId = adClientId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].cProjectId = cProjectId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].cProjectIdr = "";
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].adOrgId = adOrgId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].aAssetId = aAssetId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].aAssetIdr = "";
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].line = line;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].datedelivered = datedelivered;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].dateordered = dateordered;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].overdue = overdue;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].datepromised = datepromised;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].cProjectphaseId = cProjectphaseId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].cProjecttaskId = cProjecttaskId;
    objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data[0].language = "";
    return objectDeliveriesExpectedA354C7963BF9421EA0631E0E132AAB77Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef4E6334A4BAE94D6F9C0BD80212D35A87_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef967196860D134B87BB8A12512446251E_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef078698AD70344670950F4045C3B311D0_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE mrp_deliveries_expected" +
      "        SET MRP_Deliveries_Expected_ID = (?) , M_Product_ID = (?) , Description = (?) , Salesrep_ID = (?) , Qtyordered = TO_NUMBER(?) , Qtydelivered = TO_NUMBER(?) , Isactive = (?) , C_Order_ID = (?) , Scheddeliverydate = TO_DATE(?) , AD_Client_ID = (?) , C_Project_ID = (?) , AD_Org_ID = (?) , A_Asset_ID = (?) , Line = TO_NUMBER(?) , Datedelivered = TO_DATE(?) , Dateordered = TO_DATE(?) , Overdue = (?) , Datepromised = TO_DATE(?) , C_Projectphase_ID = (?) , C_Projecttask_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE mrp_deliveries_expected.MRP_Deliveries_Expected_ID = ? " +
      "        AND mrp_deliveries_expected.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_deliveries_expected.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpDeliveriesExpectedId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overdue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpDeliveriesExpectedId);
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
      "        INSERT INTO mrp_deliveries_expected " +
      "        (MRP_Deliveries_Expected_ID, M_Product_ID, Description, Salesrep_ID, Qtyordered, Qtydelivered, Isactive, C_Order_ID, Scheddeliverydate, AD_Client_ID, C_Project_ID, AD_Org_ID, A_Asset_ID, Line, Datedelivered, Dateordered, Overdue, Datepromised, C_Projectphase_ID, C_Projecttask_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_DATE(?), (?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpDeliveriesExpectedId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overdue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
      "        DELETE FROM mrp_deliveries_expected" +
      "        WHERE mrp_deliveries_expected.MRP_Deliveries_Expected_ID = ? " +
      "        AND mrp_deliveries_expected.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_deliveries_expected.AD_Org_ID IN (";
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
      "        DELETE FROM mrp_deliveries_expected" +
      "        WHERE mrp_deliveries_expected.MRP_Deliveries_Expected_ID = ? ";

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
      "          FROM mrp_deliveries_expected" +
      "         WHERE mrp_deliveries_expected.MRP_Deliveries_Expected_ID = ? ";

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
      "          FROM mrp_deliveries_expected" +
      "         WHERE mrp_deliveries_expected.MRP_Deliveries_Expected_ID = ? ";

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

//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openz.internallogistic.ShipmentReceipt;

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
class LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data implements FieldProvider {
static Logger log4j = Logger.getLogger(LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mAttributesetinstanceId;
  public String ilsInoutVId;
  public String ilsInoutVIdr;
  public String line;
  public String mLocatorId;
  public String mLocatorIdr;
  public String aAssetId;
  public String mProductId;
  public String mProductIdr;
  public String cProjecttaskId;
  public String movementqty;
  public String cProjectId;
  public String cUomId;
  public String cUomIdr;
  public String adUserId;
  public String adUserIdr;
  public String ilsInoutlineVId;
  public String description;
  public String isinvoiced;
  public String cOrderlineId;
  public String adClientId;
  public String isactive;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("ils_inout_v_id") || fieldName.equals("ilsInoutVId"))
      return ilsInoutVId;
    else if (fieldName.equalsIgnoreCase("ils_inout_v_idr") || fieldName.equals("ilsInoutVIdr"))
      return ilsInoutVIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("ils_inoutline_v_id") || fieldName.equals("ilsInoutlineVId"))
      return ilsInoutlineVId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ilsInoutVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, ilsInoutVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ilsInoutVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ils_inoutline_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_inoutline_v.CreatedBy) as CreatedByR, " +
      "        to_char(ils_inoutline_v.Updated, ?) as updated, " +
      "        to_char(ils_inoutline_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ils_inoutline_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ils_inoutline_v.UpdatedBy) as UpdatedByR," +
      "        ils_inoutline_v.M_AttributeSetInstance_ID, " +
      "ils_inoutline_v.ILS_Inout_V_ID, " +
      "(CASE WHEN ils_inoutline_v.ILS_Inout_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table1.MovementDate, 'DD-MM-YYYY')),'') ) END) AS ILS_Inout_V_IDR, " +
      "ils_inoutline_v.Line, " +
      "ils_inoutline_v.M_Locator_ID, " +
      "(CASE WHEN ils_inoutline_v.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "ils_inoutline_v.A_Asset_ID, " +
      "ils_inoutline_v.M_Product_ID, " +
      "(CASE WHEN ils_inoutline_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "ils_inoutline_v.C_Projecttask_ID, " +
      "ils_inoutline_v.MovementQty, " +
      "ils_inoutline_v.C_Project_ID, " +
      "ils_inoutline_v.C_UOM_ID, " +
      "(CASE WHEN ils_inoutline_v.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "ils_inoutline_v.AD_User_ID, " +
      "(CASE WHEN ils_inoutline_v.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "ils_inoutline_v.ILS_Inoutline_V_ID, " +
      "ils_inoutline_v.Description, " +
      "COALESCE(ils_inoutline_v.Isinvoiced, 'N') AS Isinvoiced, " +
      "ils_inoutline_v.C_OrderLine_ID, " +
      "ils_inoutline_v.AD_Client_ID, " +
      "COALESCE(ils_inoutline_v.IsActive, 'N') AS IsActive, " +
      "ils_inoutline_v.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ils_inoutline_v left join (select ILS_Inout_V_ID, DocumentNo, MovementDate from ILS_Inout_V) table1 on (ils_inoutline_v.ILS_Inout_V_ID = table1.ILS_Inout_V_ID) left join (select M_Locator_ID, Value from M_Locator) table2 on (ils_inoutline_v.M_Locator_ID = table2.M_Locator_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (ils_inoutline_v.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select C_UOM_ID, Name from C_UOM) table4 on (ils_inoutline_v.C_UOM_ID = table4.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL4 on (table4.C_UOM_ID = tableTRL4.C_UOM_ID and tableTRL4.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table5 on (ils_inoutline_v.AD_User_ID = table5.AD_User_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((ilsInoutVId==null || ilsInoutVId.equals(""))?"":"  AND ils_inoutline_v.ILS_Inout_V_ID = ?  ");
    strSql = strSql + 
      "        AND ils_inoutline_v.ILS_Inoutline_V_ID = ? " +
      "        AND ils_inoutline_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ils_inoutline_v.AD_Org_ID IN (";
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
      if (ilsInoutVId != null && !(ilsInoutVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);
      }
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
        LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data = new LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data();
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.created = UtilSql.getValue(result, "created");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.updated = UtilSql.getValue(result, "updated");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.ilsInoutVId = UtilSql.getValue(result, "ils_inout_v_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.ilsInoutVIdr = UtilSql.getValue(result, "ils_inout_v_idr");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.line = UtilSql.getValue(result, "line");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.movementqty = UtilSql.getValue(result, "movementqty");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.ilsInoutlineVId = UtilSql.getValue(result, "ils_inoutline_v_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.description = UtilSql.getValue(result, "description");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.isactive = UtilSql.getValue(result, "isactive");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.language = UtilSql.getValue(result, "language");
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.adUserClient = "";
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.adOrgClient = "";
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.createdby = "";
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.trBgcolor = "";
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.totalCount = "";
        objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data);
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
    LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] = new LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[vector.size()];
    vector.copyInto(objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data);
    return(objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data);
  }

/**
Create a registry
 */
  public static LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] set(String ilsInoutVId, String adClientId, String aAssetId, String adOrgId, String mAttributesetinstanceId, String cProjecttaskId, String mLocatorId, String mLocatorIdr, String adUserId, String mProductId, String mProductIdr, String isinvoiced, String line, String cOrderlineId, String ilsInoutlineVId, String createdby, String createdbyr, String isactive, String movementqty, String description, String updatedby, String updatedbyr, String cUomId, String cProjectId)    throws ServletException {
    LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[] = new LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[1];
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0] = new LinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data();
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].created = "";
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].createdbyr = createdbyr;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].updated = "";
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].updatedTimeStamp = "";
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].updatedby = updatedby;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].updatedbyr = updatedbyr;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].ilsInoutVId = ilsInoutVId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].ilsInoutVIdr = "";
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].line = line;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].mLocatorId = mLocatorId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].mLocatorIdr = mLocatorIdr;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].aAssetId = aAssetId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].mProductId = mProductId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].mProductIdr = mProductIdr;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].cProjecttaskId = cProjecttaskId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].movementqty = movementqty;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].cProjectId = cProjectId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].cUomId = cUomId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].cUomIdr = "";
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].adUserId = adUserId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].adUserIdr = "";
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].ilsInoutlineVId = ilsInoutlineVId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].description = description;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].isinvoiced = isinvoiced;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].cOrderlineId = cOrderlineId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].adClientId = adClientId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].isactive = isactive;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].adOrgId = adOrgId;
    objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data[0].language = "";
    return objectLinesE51D4FEB1D9B4BA6B19DBD7A206BC111Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefED78F84708C449D9B720A7FB2E1A6321(ConnectionProvider connectionProvider, String m_inout_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT a_asset_id AS DefaultValue FROM m_inout WHERE m_inout_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inout_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef4DFC21ADAE854C1AA794BFB0A3619BD3(ConnectionProvider connectionProvider, String m_inout_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_projecttask_id AS DefaultValue FROM m_inout WHERE m_inout_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inout_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefD8643C706693453E8F6A6C87FBACA1A0(ConnectionProvider connectionProvider, String ILS_Inout_V_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Locator_ID AS DefaultValue from m_locator where m_warehouse_id=(select m_warehouse_id from m_inout where m_inout_id=?) and isactive='Y' and islogistic='Y' ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ILS_Inout_V_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefD8643C706693453E8F6A6C87FBACA1A0_0(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as M_Locator_ID FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_locator_id");
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
  public static String selectDefB13074C9A2F342E992B270F7B9A47D89(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT value AS DefaultValue FROM AD_PREFERENCE WHERE ATTRIBUTE='DEFAULTINTERNALLOGISTICPRODUCT' ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefB13074C9A2F342E992B270F7B9A47D89_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef69B22AA407364CE28BFD2F797CB2A46F(ConnectionProvider connectionProvider, String M_InOut_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM M_InOutLine WHERE M_InOut_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_InOut_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefE5A7431919714CD68661AB01D3C2586C_2(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
  public static String selectDefD1DC1492C7C14374AC6EB8438506F7CD_3(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
  public static String selectDefC39651F7A7934C2FAB6150AC8591C7EB(ConnectionProvider connectionProvider, String m_inout_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_project_id AS DefaultValue FROM m_inout WHERE m_inout_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inout_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ils_inoutline_v.ILS_Inout_V_ID AS NAME" +
      "        FROM ils_inoutline_v" +
      "        WHERE ils_inoutline_v.ILS_Inoutline_V_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String ilsInoutVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.MovementDate, 'DD-MM-YYYY')) AS NAME FROM ils_inout_v left join (select ILS_Inout_V_ID, DocumentNo, MovementDate from ILS_Inout_V) table1 on (ils_inout_v.ILS_Inout_V_ID = table1.ILS_Inout_V_ID) WHERE ils_inout_v.ILS_Inout_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);

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

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String ilsInoutVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.MovementDate, 'DD-MM-YYYY')) AS NAME FROM ils_inout_v left join (select ILS_Inout_V_ID, DocumentNo, MovementDate from ILS_Inout_V) table1 on (ils_inout_v.ILS_Inout_V_ID = table1.ILS_Inout_V_ID) WHERE ils_inout_v.ILS_Inout_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);

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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ils_inoutline_v" +
      "        SET M_AttributeSetInstance_ID = (?) , ILS_Inout_V_ID = (?) , Line = TO_NUMBER(?) , M_Locator_ID = (?) , A_Asset_ID = (?) , M_Product_ID = (?) , C_Projecttask_ID = (?) , MovementQty = TO_NUMBER(?) , C_Project_ID = (?) , C_UOM_ID = (?) , AD_User_ID = (?) , ILS_Inoutline_V_ID = (?) , Description = (?) , Isinvoiced = (?) , C_OrderLine_ID = (?) , AD_Client_ID = (?) , IsActive = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ils_inoutline_v.ILS_Inoutline_V_ID = ? " +
      "                 AND ils_inoutline_v.ILS_Inout_V_ID = ? " +
      "        AND ils_inoutline_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_inoutline_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);
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
      "        INSERT INTO ils_inoutline_v " +
      "        (M_AttributeSetInstance_ID, ILS_Inout_V_ID, Line, M_Locator_ID, A_Asset_ID, M_Product_ID, C_Projecttask_ID, MovementQty, C_Project_ID, C_UOM_ID, AD_User_ID, ILS_Inoutline_V_ID, Description, Isinvoiced, C_OrderLine_ID, AD_Client_ID, IsActive, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutlineVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String ilsInoutVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ils_inoutline_v" +
      "        WHERE ils_inoutline_v.ILS_Inoutline_V_ID = ? " +
      "                 AND ils_inoutline_v.ILS_Inout_V_ID = ? " +
      "        AND ils_inoutline_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ils_inoutline_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String ilsInoutVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ils_inoutline_v" +
      "        WHERE ils_inoutline_v.ILS_Inoutline_V_ID = ? " +
      "                 AND ils_inoutline_v.ILS_Inout_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsInoutVId);

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
      "          FROM ils_inoutline_v" +
      "         WHERE ils_inoutline_v.ILS_Inoutline_V_ID = ? ";

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
      "          FROM ils_inoutline_v" +
      "         WHERE ils_inoutline_v.ILS_Inoutline_V_ID = ? ";

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

//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.GoodsMovementcustomer;

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
class ScanD2CD383FC5A644DAABF9C462197B185AData implements FieldProvider {
static Logger log4j = Logger.getLogger(ScanD2CD383FC5A644DAABF9C462197B185AData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String quantityorder;
  public String mAttributesetinstanceId;
  public String isdescription;
  public String mProductUomId;
  public String line;
  public String mInoutId;
  public String upc;
  public String movementqty;
  public String cUomId;
  public String cUomIdr;
  public String mLocatorId;
  public String mLocatorIdr;
  public String mProductId;
  public String mProductIdr;
  public String mInoutlineId;
  public String isactive;
  public String adOrgId;
  public String adClientId;
  public String cOrderlineId;
  public String isinvoiced;
  public String description;
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
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("isdescription"))
      return isdescription;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
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
  public static ScanD2CD383FC5A644DAABF9C462197B185AData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInoutId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mInoutId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ScanD2CD383FC5A644DAABF9C462197B185AData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mInoutId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_InOutLine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_InOutLine.CreatedBy) as CreatedByR, " +
      "        to_char(M_InOutLine.Updated, ?) as updated, " +
      "        to_char(M_InOutLine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_InOutLine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_InOutLine.UpdatedBy) as UpdatedByR," +
      "        M_InOutLine.QuantityOrder, " +
      "M_InOutLine.M_AttributeSetInstance_ID, " +
      "COALESCE(M_InOutLine.IsDescription, 'N') AS IsDescription, " +
      "M_InOutLine.M_Product_Uom_Id, " +
      "M_InOutLine.Line, " +
      "M_InOutLine.M_InOut_ID, " +
      "M_InOutLine.Upc, " +
      "M_InOutLine.MovementQty, " +
      "M_InOutLine.C_UOM_ID, " +
      "(CASE WHEN M_InOutLine.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "M_InOutLine.M_Locator_ID, " +
      "(CASE WHEN M_InOutLine.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "M_InOutLine.M_Product_ID, " +
      "(CASE WHEN M_InOutLine.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "M_InOutLine.M_InOutLine_ID, " +
      "COALESCE(M_InOutLine.IsActive, 'N') AS IsActive, " +
      "M_InOutLine.AD_Org_ID, " +
      "M_InOutLine.AD_Client_ID, " +
      "M_InOutLine.C_OrderLine_ID, " +
      "COALESCE(M_InOutLine.IsInvoiced, 'N') AS IsInvoiced, " +
      "M_InOutLine.Description, " +
      "        ? AS LANGUAGE " +
      "        FROM M_InOutLine left join (select C_UOM_ID, Name from C_UOM) table1 on (M_InOutLine.C_UOM_ID = table1.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL1 on (table1.C_UOM_ID = tableTRL1.C_UOM_ID and tableTRL1.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table2 on (M_InOutLine.M_Locator_ID = table2.M_Locator_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (M_InOutLine.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mInoutId==null || mInoutId.equals(""))?"":"  AND M_InOutLine.M_InOut_ID = ?  ");
    strSql = strSql + 
      "        AND M_InOutLine.M_InOutLine_ID = ? " +
      "        AND M_InOutLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_InOutLine.AD_Org_ID IN (";
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
      if (mInoutId != null && !(mInoutId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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
        ScanD2CD383FC5A644DAABF9C462197B185AData objectScanD2CD383FC5A644DAABF9C462197B185AData = new ScanD2CD383FC5A644DAABF9C462197B185AData();
        objectScanD2CD383FC5A644DAABF9C462197B185AData.created = UtilSql.getValue(result, "created");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.updated = UtilSql.getValue(result, "updated");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.updatedby = UtilSql.getValue(result, "updatedby");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.isdescription = UtilSql.getValue(result, "isdescription");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.line = UtilSql.getValue(result, "line");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.upc = UtilSql.getValue(result, "upc");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.movementqty = UtilSql.getValue(result, "movementqty");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.isactive = UtilSql.getValue(result, "isactive");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.description = UtilSql.getValue(result, "description");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.language = UtilSql.getValue(result, "language");
        objectScanD2CD383FC5A644DAABF9C462197B185AData.adUserClient = "";
        objectScanD2CD383FC5A644DAABF9C462197B185AData.adOrgClient = "";
        objectScanD2CD383FC5A644DAABF9C462197B185AData.createdby = "";
        objectScanD2CD383FC5A644DAABF9C462197B185AData.trBgcolor = "";
        objectScanD2CD383FC5A644DAABF9C462197B185AData.totalCount = "";
        objectScanD2CD383FC5A644DAABF9C462197B185AData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectScanD2CD383FC5A644DAABF9C462197B185AData);
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
    ScanD2CD383FC5A644DAABF9C462197B185AData objectScanD2CD383FC5A644DAABF9C462197B185AData[] = new ScanD2CD383FC5A644DAABF9C462197B185AData[vector.size()];
    vector.copyInto(objectScanD2CD383FC5A644DAABF9C462197B185AData);
    return(objectScanD2CD383FC5A644DAABF9C462197B185AData);
  }

/**
Create a registry
 */
  public static ScanD2CD383FC5A644DAABF9C462197B185AData[] set(String mInoutId, String description, String movementqty, String mLocatorId, String mLocatorIdr, String line, String cUomId, String adClientId, String mInoutlineId, String upc, String updatedby, String updatedbyr, String quantityorder, String adOrgId, String mProductId, String mProductIdr, String cOrderlineId, String isinvoiced, String isdescription, String mAttributesetinstanceId, String isactive, String createdby, String createdbyr, String mProductUomId)    throws ServletException {
    ScanD2CD383FC5A644DAABF9C462197B185AData objectScanD2CD383FC5A644DAABF9C462197B185AData[] = new ScanD2CD383FC5A644DAABF9C462197B185AData[1];
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0] = new ScanD2CD383FC5A644DAABF9C462197B185AData();
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].created = "";
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].createdbyr = createdbyr;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].updated = "";
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].updatedTimeStamp = "";
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].updatedby = updatedby;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].updatedbyr = updatedbyr;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].quantityorder = quantityorder;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].isdescription = isdescription;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].mProductUomId = mProductUomId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].line = line;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].mInoutId = mInoutId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].upc = upc;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].movementqty = movementqty;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].cUomId = cUomId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].cUomIdr = "";
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].mLocatorId = mLocatorId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].mLocatorIdr = mLocatorIdr;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].mProductId = mProductId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].mProductIdr = mProductIdr;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].mInoutlineId = mInoutlineId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].isactive = isactive;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].adOrgId = adOrgId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].adClientId = adClientId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].cOrderlineId = cOrderlineId;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].isinvoiced = isinvoiced;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].description = description;
    objectScanD2CD383FC5A644DAABF9C462197B185AData[0].language = "";
    return objectScanD2CD383FC5A644DAABF9C462197B185AData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3537_0(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
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
  public static String selectDef3810(ConnectionProvider connectionProvider, String M_InOut_ID)    throws ServletException {
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
  public static String selectDef3536_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef3539_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef3534_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_InOutLine.M_InOut_ID AS NAME" +
      "        FROM M_InOutLine" +
      "        WHERE M_InOutLine.M_InOutLine_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.MovementDate, 'DD-MM-YYYY')) AS NAME FROM M_InOut left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table1 on (M_InOut.M_InOut_ID = table1.M_InOut_ID) WHERE M_InOut.M_InOut_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.MovementDate, 'DD-MM-YYYY')) AS NAME FROM M_InOut left join (select M_InOut_ID, DocumentNo, MovementDate from M_InOut) table1 on (M_InOut.M_InOut_ID = table1.M_InOut_ID) WHERE M_InOut.M_InOut_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
      "        UPDATE M_InOutLine" +
      "        SET QuantityOrder = TO_NUMBER(?) , M_AttributeSetInstance_ID = (?) , IsDescription = (?) , M_Product_Uom_Id = (?) , Line = TO_NUMBER(?) , M_InOut_ID = (?) , Upc = (?) , MovementQty = TO_NUMBER(?) , C_UOM_ID = (?) , M_Locator_ID = (?) , M_Product_ID = (?) , M_InOutLine_ID = (?) , IsActive = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , C_OrderLine_ID = (?) , IsInvoiced = (?) , Description = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_InOutLine.M_InOutLine_ID = ? " +
      "                 AND M_InOutLine.M_InOut_ID = ? " +
      "        AND M_InOutLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_InOutLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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
      "        INSERT INTO M_InOutLine " +
      "        (QuantityOrder, M_AttributeSetInstance_ID, IsDescription, M_Product_Uom_Id, Line, M_InOut_ID, Upc, MovementQty, C_UOM_ID, M_Locator_ID, M_Product_ID, M_InOutLine_ID, IsActive, AD_Org_ID, AD_Client_ID, C_OrderLine_ID, IsInvoiced, Description, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mInoutId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_InOutLine" +
      "        WHERE M_InOutLine.M_InOutLine_ID = ? " +
      "                 AND M_InOutLine.M_InOut_ID = ? " +
      "        AND M_InOutLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_InOutLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mInoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_InOutLine" +
      "        WHERE M_InOutLine.M_InOutLine_ID = ? " +
      "                 AND M_InOutLine.M_InOut_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);

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
      "          FROM M_InOutLine" +
      "         WHERE M_InOutLine.M_InOutLine_ID = ? ";

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
      "          FROM M_InOutLine" +
      "         WHERE M_InOutLine.M_InOutLine_ID = ? ";

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

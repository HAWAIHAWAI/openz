//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.PurchasingPlan;

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
class Header800258Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Header800258Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String mrpRunPurchaseId;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String isactive;
  public String datedoc;
  public String timehorizon;
  public String securitymargin;
  public String mrpPlannerId;
  public String mrpPlannerIdr;
  public String vendorId;
  public String vendorIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String mProductId;
  public String mProductIdr;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpGroupId;
  public String cBpGroupIdr;
  public String simulate;
  public String launchpo;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("mrp_run_purchase_id") || fieldName.equals("mrpRunPurchaseId"))
      return mrpRunPurchaseId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("timehorizon"))
      return timehorizon;
    else if (fieldName.equalsIgnoreCase("securitymargin"))
      return securitymargin;
    else if (fieldName.equalsIgnoreCase("mrp_planner_id") || fieldName.equals("mrpPlannerId"))
      return mrpPlannerId;
    else if (fieldName.equalsIgnoreCase("mrp_planner_idr") || fieldName.equals("mrpPlannerIdr"))
      return mrpPlannerIdr;
    else if (fieldName.equalsIgnoreCase("vendor_id") || fieldName.equals("vendorId"))
      return vendorId;
    else if (fieldName.equalsIgnoreCase("vendor_idr") || fieldName.equals("vendorIdr"))
      return vendorIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bp_group_id") || fieldName.equals("cBpGroupId"))
      return cBpGroupId;
    else if (fieldName.equalsIgnoreCase("c_bp_group_idr") || fieldName.equals("cBpGroupIdr"))
      return cBpGroupIdr;
    else if (fieldName.equalsIgnoreCase("simulate"))
      return simulate;
    else if (fieldName.equalsIgnoreCase("launchpo"))
      return launchpo;
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
  public static Header800258Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Header800258Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MRP_Run_Purchase.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MRP_Run_Purchase.CreatedBy) as CreatedByR, " +
      "        to_char(MRP_Run_Purchase.Updated, ?) as updated, " +
      "        to_char(MRP_Run_Purchase.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MRP_Run_Purchase.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MRP_Run_Purchase.UpdatedBy) as UpdatedByR," +
      "        MRP_Run_Purchase.AD_Client_ID, " +
      "(CASE WHEN MRP_Run_Purchase.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MRP_Run_Purchase.MRP_Run_Purchase_ID, " +
      "MRP_Run_Purchase.AD_Org_ID, " +
      "(CASE WHEN MRP_Run_Purchase.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MRP_Run_Purchase.Name, " +
      "MRP_Run_Purchase.Description, " +
      "COALESCE(MRP_Run_Purchase.IsActive, 'N') AS IsActive, " +
      "MRP_Run_Purchase.DateDoc, " +
      "MRP_Run_Purchase.Timehorizon, " +
      "MRP_Run_Purchase.Securitymargin, " +
      "MRP_Run_Purchase.MRP_Planner_ID, " +
      "(CASE WHEN MRP_Run_Purchase.MRP_Planner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MRP_Planner_IDR, " +
      "MRP_Run_Purchase.Vendor_ID, " +
      "(CASE WHEN MRP_Run_Purchase.Vendor_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS Vendor_IDR, " +
      "MRP_Run_Purchase.M_Warehouse_ID, " +
      "(CASE WHEN MRP_Run_Purchase.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "MRP_Run_Purchase.M_Product_ID, " +
      "(CASE WHEN MRP_Run_Purchase.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "MRP_Run_Purchase.M_Product_Category_ID, " +
      "(CASE WHEN MRP_Run_Purchase.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "MRP_Run_Purchase.C_BPartner_ID, " +
      "(CASE WHEN MRP_Run_Purchase.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "MRP_Run_Purchase.C_BP_Group_ID, " +
      "(CASE WHEN MRP_Run_Purchase.C_BP_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS C_BP_Group_IDR, " +
      "MRP_Run_Purchase.Simulate, " +
      "MRP_Run_Purchase.Launchpo, " +
      "        ? AS LANGUAGE " +
      "        FROM MRP_Run_Purchase left join (select AD_Client_ID, Name from AD_Client) table1 on (MRP_Run_Purchase.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MRP_Run_Purchase.AD_Org_ID = table2.AD_Org_ID) left join (select MRP_Planner_ID, Name from MRP_Planner) table3 on (MRP_Run_Purchase.MRP_Planner_ID = table3.MRP_Planner_ID) left join (select C_BPartner_ID, Name from C_BPartner) table4 on (MRP_Run_Purchase.Vendor_ID =  table4.C_BPartner_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table5 on (MRP_Run_Purchase.M_Warehouse_ID = table5.M_Warehouse_ID) left join (select M_Product_ID, Value, Name from M_Product) table6 on (MRP_Run_Purchase.M_Product_ID = table6.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL6 on (table6.M_Product_ID = tableTRL6.M_Product_ID and tableTRL6.AD_Language = ?)  left join (select M_Product_Category_ID, Name from M_Product_Category) table7 on (MRP_Run_Purchase.M_Product_Category_ID = table7.M_Product_Category_ID) left join (select C_BPartner_ID, Name from C_BPartner) table8 on (MRP_Run_Purchase.C_BPartner_ID = table8.C_BPartner_ID) left join (select C_BP_Group_ID, Name from C_BP_Group) table9 on (MRP_Run_Purchase.C_BP_Group_ID = table9.C_BP_Group_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND MRP_Run_Purchase.MRP_Run_Purchase_ID = ? " +
      "        AND MRP_Run_Purchase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MRP_Run_Purchase.AD_Org_ID IN (";
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
        Header800258Data objectHeader800258Data = new Header800258Data();
        objectHeader800258Data.created = UtilSql.getValue(result, "created");
        objectHeader800258Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectHeader800258Data.updated = UtilSql.getValue(result, "updated");
        objectHeader800258Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectHeader800258Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectHeader800258Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectHeader800258Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectHeader800258Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectHeader800258Data.mrpRunPurchaseId = UtilSql.getValue(result, "mrp_run_purchase_id");
        objectHeader800258Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectHeader800258Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectHeader800258Data.name = UtilSql.getValue(result, "name");
        objectHeader800258Data.description = UtilSql.getValue(result, "description");
        objectHeader800258Data.isactive = UtilSql.getValue(result, "isactive");
        objectHeader800258Data.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectHeader800258Data.timehorizon = UtilSql.getValue(result, "timehorizon");
        objectHeader800258Data.securitymargin = UtilSql.getValue(result, "securitymargin");
        objectHeader800258Data.mrpPlannerId = UtilSql.getValue(result, "mrp_planner_id");
        objectHeader800258Data.mrpPlannerIdr = UtilSql.getValue(result, "mrp_planner_idr");
        objectHeader800258Data.vendorId = UtilSql.getValue(result, "vendor_id");
        objectHeader800258Data.vendorIdr = UtilSql.getValue(result, "vendor_idr");
        objectHeader800258Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectHeader800258Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectHeader800258Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectHeader800258Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectHeader800258Data.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectHeader800258Data.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectHeader800258Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectHeader800258Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectHeader800258Data.cBpGroupId = UtilSql.getValue(result, "c_bp_group_id");
        objectHeader800258Data.cBpGroupIdr = UtilSql.getValue(result, "c_bp_group_idr");
        objectHeader800258Data.simulate = UtilSql.getValue(result, "simulate");
        objectHeader800258Data.launchpo = UtilSql.getValue(result, "launchpo");
        objectHeader800258Data.language = UtilSql.getValue(result, "language");
        objectHeader800258Data.adUserClient = "";
        objectHeader800258Data.adOrgClient = "";
        objectHeader800258Data.createdby = "";
        objectHeader800258Data.trBgcolor = "";
        objectHeader800258Data.totalCount = "";
        objectHeader800258Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeader800258Data);
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
    Header800258Data objectHeader800258Data[] = new Header800258Data[vector.size()];
    vector.copyInto(objectHeader800258Data);
    return(objectHeader800258Data);
  }

/**
Create a registry
 */
  public static Header800258Data[] set(String simulate, String updatedby, String updatedbyr, String vendorId, String mProductId, String mProductIdr, String description, String launchpo, String datedoc, String createdby, String createdbyr, String name, String mProductCategoryId, String timehorizon, String adClientId, String adOrgId, String mrpPlannerId, String cBpGroupId, String mWarehouseId, String cBpartnerId, String cBpartnerIdr, String mrpRunPurchaseId, String isactive, String securitymargin)    throws ServletException {
    Header800258Data objectHeader800258Data[] = new Header800258Data[1];
    objectHeader800258Data[0] = new Header800258Data();
    objectHeader800258Data[0].created = "";
    objectHeader800258Data[0].createdbyr = createdbyr;
    objectHeader800258Data[0].updated = "";
    objectHeader800258Data[0].updatedTimeStamp = "";
    objectHeader800258Data[0].updatedby = updatedby;
    objectHeader800258Data[0].updatedbyr = updatedbyr;
    objectHeader800258Data[0].adClientId = adClientId;
    objectHeader800258Data[0].adClientIdr = "";
    objectHeader800258Data[0].mrpRunPurchaseId = mrpRunPurchaseId;
    objectHeader800258Data[0].adOrgId = adOrgId;
    objectHeader800258Data[0].adOrgIdr = "";
    objectHeader800258Data[0].name = name;
    objectHeader800258Data[0].description = description;
    objectHeader800258Data[0].isactive = isactive;
    objectHeader800258Data[0].datedoc = datedoc;
    objectHeader800258Data[0].timehorizon = timehorizon;
    objectHeader800258Data[0].securitymargin = securitymargin;
    objectHeader800258Data[0].mrpPlannerId = mrpPlannerId;
    objectHeader800258Data[0].mrpPlannerIdr = "";
    objectHeader800258Data[0].vendorId = vendorId;
    objectHeader800258Data[0].vendorIdr = "";
    objectHeader800258Data[0].mWarehouseId = mWarehouseId;
    objectHeader800258Data[0].mWarehouseIdr = "";
    objectHeader800258Data[0].mProductId = mProductId;
    objectHeader800258Data[0].mProductIdr = mProductIdr;
    objectHeader800258Data[0].mProductCategoryId = mProductCategoryId;
    objectHeader800258Data[0].mProductCategoryIdr = "";
    objectHeader800258Data[0].cBpartnerId = cBpartnerId;
    objectHeader800258Data[0].cBpartnerIdr = cBpartnerIdr;
    objectHeader800258Data[0].cBpGroupId = cBpGroupId;
    objectHeader800258Data[0].cBpGroupIdr = "";
    objectHeader800258Data[0].simulate = simulate;
    objectHeader800258Data[0].launchpo = launchpo;
    objectHeader800258Data[0].language = "";
    return objectHeader800258Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803651_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef803658_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef803649_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803660_3(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE MRP_Run_Purchase" +
      "        SET AD_Client_ID = (?) , MRP_Run_Purchase_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , DateDoc = TO_DATE(?) , Timehorizon = TO_NUMBER(?) , Securitymargin = TO_NUMBER(?) , MRP_Planner_ID = (?) , Vendor_ID = (?) , M_Warehouse_ID = (?) , M_Product_ID = (?) , M_Product_Category_ID = (?) , C_BPartner_ID = (?) , C_BP_Group_ID = (?) , Simulate = (?) , Launchpo = (?) , updated = now(), updatedby = ? " +
      "        WHERE MRP_Run_Purchase.MRP_Run_Purchase_ID = ? " +
      "        AND MRP_Run_Purchase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MRP_Run_Purchase.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunPurchaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timehorizon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, securitymargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlannerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, simulate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, launchpo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunPurchaseId);
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
      "        INSERT INTO MRP_Run_Purchase " +
      "        (AD_Client_ID, MRP_Run_Purchase_ID, AD_Org_ID, Name, Description, IsActive, DateDoc, Timehorizon, Securitymargin, MRP_Planner_ID, Vendor_ID, M_Warehouse_ID, M_Product_ID, M_Product_Category_ID, C_BPartner_ID, C_BP_Group_ID, Simulate, Launchpo, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunPurchaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timehorizon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, securitymargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlannerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, simulate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, launchpo);
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
      "        DELETE FROM MRP_Run_Purchase" +
      "        WHERE MRP_Run_Purchase.MRP_Run_Purchase_ID = ? " +
      "        AND MRP_Run_Purchase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MRP_Run_Purchase.AD_Org_ID IN (";
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
      "        DELETE FROM MRP_Run_Purchase" +
      "        WHERE MRP_Run_Purchase.MRP_Run_Purchase_ID = ? ";

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
      "          FROM MRP_Run_Purchase" +
      "         WHERE MRP_Run_Purchase.MRP_Run_Purchase_ID = ? ";

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
      "          FROM MRP_Run_Purchase" +
      "         WHERE MRP_Run_Purchase.MRP_Run_Purchase_ID = ? ";

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

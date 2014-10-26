//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;

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
class MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data implements FieldProvider {
static Logger log4j = Logger.getLogger(MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String zspmProjecttaskbomViewId;
  public String line;
  public String mProductId;
  public String mProductIdr;
  public String description;
  public String adClientId;
  public String adOrgId;
  public String constuctivemeasure;
  public String rawmaterial;
  public String mLocatorId;
  public String mLocatorIdr;
  public String qtyPlan;
  public String cutoff;
  public String quantity;
  public String datePlan;
  public String isreturnafteruse;
  public String planrequisition;
  public String isactive;
  public String qtyreceived;
  public String qtyInstock;
  public String qtyInconsumption;
  public String qtyAvailable;
  public String qtyinrequisition;
  public String qtyOrdered;
  public String qtyreserved;
  public String qtyNextreceipt;
  public String dateNextreceipt;
  public String actualcosamount;
  public String plannedamt;
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
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("zspm_projecttaskbom_view_id") || fieldName.equals("zspmProjecttaskbomViewId"))
      return zspmProjecttaskbomViewId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("constuctivemeasure"))
      return constuctivemeasure;
    else if (fieldName.equalsIgnoreCase("rawmaterial"))
      return rawmaterial;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("qty_plan") || fieldName.equals("qtyPlan"))
      return qtyPlan;
    else if (fieldName.equalsIgnoreCase("cutoff"))
      return cutoff;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("date_plan") || fieldName.equals("datePlan"))
      return datePlan;
    else if (fieldName.equalsIgnoreCase("isreturnafteruse"))
      return isreturnafteruse;
    else if (fieldName.equalsIgnoreCase("planrequisition"))
      return planrequisition;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("qtyreceived"))
      return qtyreceived;
    else if (fieldName.equalsIgnoreCase("qty_instock") || fieldName.equals("qtyInstock"))
      return qtyInstock;
    else if (fieldName.equalsIgnoreCase("qty_inconsumption") || fieldName.equals("qtyInconsumption"))
      return qtyInconsumption;
    else if (fieldName.equalsIgnoreCase("qty_available") || fieldName.equals("qtyAvailable"))
      return qtyAvailable;
    else if (fieldName.equalsIgnoreCase("qtyinrequisition"))
      return qtyinrequisition;
    else if (fieldName.equalsIgnoreCase("qty_ordered") || fieldName.equals("qtyOrdered"))
      return qtyOrdered;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qty_nextreceipt") || fieldName.equals("qtyNextreceipt"))
      return qtyNextreceipt;
    else if (fieldName.equalsIgnoreCase("date_nextreceipt") || fieldName.equals("dateNextreceipt"))
      return dateNextreceipt;
    else if (fieldName.equalsIgnoreCase("actualcosamount"))
      return actualcosamount;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
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
  public static MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjecttaskId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_projecttaskbom_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_projecttaskbom_view.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_projecttaskbom_view.Updated, ?) as updated, " +
      "        to_char(zspm_projecttaskbom_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_projecttaskbom_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_projecttaskbom_view.UpdatedBy) as UpdatedByR," +
      "        zspm_projecttaskbom_view.C_Projecttask_ID, " +
      "(CASE WHEN zspm_projecttaskbom_view.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_projecttaskbom_view.Zspm_Projecttaskbom_View_ID, " +
      "zspm_projecttaskbom_view.Line, " +
      "zspm_projecttaskbom_view.M_Product_ID, " +
      "(CASE WHEN zspm_projecttaskbom_view.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zspm_projecttaskbom_view.Description, " +
      "zspm_projecttaskbom_view.AD_Client_ID, " +
      "zspm_projecttaskbom_view.AD_Org_ID, " +
      "zspm_projecttaskbom_view.Constuctivemeasure, " +
      "zspm_projecttaskbom_view.Rawmaterial, " +
      "zspm_projecttaskbom_view.M_Locator_ID, " +
      "(CASE WHEN zspm_projecttaskbom_view.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "zspm_projecttaskbom_view.QTY_Plan, " +
      "zspm_projecttaskbom_view.Cutoff, " +
      "zspm_projecttaskbom_view.Quantity, " +
      "zspm_projecttaskbom_view.Date_Plan, " +
      "COALESCE(zspm_projecttaskbom_view.isreturnafteruse, 'N') AS isreturnafteruse, " +
      "COALESCE(zspm_projecttaskbom_view.Planrequisition, 'N') AS Planrequisition, " +
      "COALESCE(zspm_projecttaskbom_view.Isactive, 'N') AS Isactive, " +
      "zspm_projecttaskbom_view.Qtyreceived, " +
      "zspm_projecttaskbom_view.QTY_Instock, " +
      "zspm_projecttaskbom_view.QTY_Inconsumption, " +
      "zspm_projecttaskbom_view.QTY_Available, " +
      "zspm_projecttaskbom_view.Qtyinrequisition, " +
      "zspm_projecttaskbom_view.QTY_Ordered, " +
      "zspm_projecttaskbom_view.Qtyreserved, " +
      "zspm_projecttaskbom_view.QTY_Nextreceipt, " +
      "zspm_projecttaskbom_view.Date_Nextreceipt, " +
      "zspm_projecttaskbom_view.Actualcosamount, " +
      "zspm_projecttaskbom_view.plannedamt, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_projecttaskbom_view left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (zspm_projecttaskbom_view.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (zspm_projecttaskbom_view.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table4 on (zspm_projecttaskbom_view.M_Locator_ID = table4.M_Locator_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjecttaskId==null || cProjecttaskId.equals(""))?"":"  AND zspm_projecttaskbom_view.C_Projecttask_ID = ?  ");
    strSql = strSql + 
      "        AND zspm_projecttaskbom_view.Zspm_Projecttaskbom_View_ID = ? " +
      "        AND zspm_projecttaskbom_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_projecttaskbom_view.AD_Org_ID IN (";
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
      if (cProjecttaskId != null && !(cProjecttaskId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
        MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data = new MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data();
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.created = UtilSql.getValue(result, "created");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.updated = UtilSql.getValue(result, "updated");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.zspmProjecttaskbomViewId = UtilSql.getValue(result, "zspm_projecttaskbom_view_id");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.line = UtilSql.getValue(result, "line");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.description = UtilSql.getValue(result, "description");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.constuctivemeasure = UtilSql.getValue(result, "constuctivemeasure");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.rawmaterial = UtilSql.getValue(result, "rawmaterial");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyPlan = UtilSql.getValue(result, "qty_plan");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.cutoff = UtilSql.getValue(result, "cutoff");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.quantity = UtilSql.getValue(result, "quantity");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.datePlan = UtilSql.getDateValue(result, "date_plan", "dd-MM-yyyy");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.isreturnafteruse = UtilSql.getValue(result, "isreturnafteruse");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.planrequisition = UtilSql.getValue(result, "planrequisition");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.isactive = UtilSql.getValue(result, "isactive");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyreceived = UtilSql.getValue(result, "qtyreceived");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyInstock = UtilSql.getValue(result, "qty_instock");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyInconsumption = UtilSql.getValue(result, "qty_inconsumption");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyAvailable = UtilSql.getValue(result, "qty_available");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyinrequisition = UtilSql.getValue(result, "qtyinrequisition");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyOrdered = UtilSql.getValue(result, "qty_ordered");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.qtyNextreceipt = UtilSql.getValue(result, "qty_nextreceipt");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.dateNextreceipt = UtilSql.getDateValue(result, "date_nextreceipt", "dd-MM-yyyy");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.actualcosamount = UtilSql.getValue(result, "actualcosamount");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.language = UtilSql.getValue(result, "language");
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.adUserClient = "";
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.adOrgClient = "";
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.createdby = "";
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.trBgcolor = "";
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.totalCount = "";
        objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data);
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
    MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[] = new MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[vector.size()];
    vector.copyInto(objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data);
    return(objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data);
  }

/**
Create a registry
 */
  public static MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[] set(String cProjecttaskId, String qtyInstock, String isreturnafteruse, String mProductId, String mProductIdr, String dateNextreceipt, String adClientId, String plannedamt, String constuctivemeasure, String mLocatorId, String mLocatorIdr, String updatedby, String updatedbyr, String cutoff, String actualcosamount, String line, String qtyreceived, String datePlan, String qtyNextreceipt, String qtyInconsumption, String qtyreserved, String qtyOrdered, String qtyinrequisition, String zspmProjecttaskbomViewId, String rawmaterial, String isactive, String qtyPlan, String description, String qtyAvailable, String planrequisition, String quantity, String createdby, String createdbyr, String adOrgId)    throws ServletException {
    MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[] = new MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[1];
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0] = new MaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data();
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].created = "";
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].createdbyr = createdbyr;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].updated = "";
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].updatedTimeStamp = "";
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].updatedby = updatedby;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].updatedbyr = updatedbyr;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].cProjecttaskId = cProjecttaskId;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].cProjecttaskIdr = "";
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].zspmProjecttaskbomViewId = zspmProjecttaskbomViewId;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].line = line;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].mProductId = mProductId;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].mProductIdr = mProductIdr;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].description = description;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].adClientId = adClientId;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].adOrgId = adOrgId;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].constuctivemeasure = constuctivemeasure;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].rawmaterial = rawmaterial;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].mLocatorId = mLocatorId;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].mLocatorIdr = mLocatorIdr;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyPlan = qtyPlan;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].cutoff = cutoff;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].quantity = quantity;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].datePlan = datePlan;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].isreturnafteruse = isreturnafteruse;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].planrequisition = planrequisition;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].isactive = isactive;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyreceived = qtyreceived;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyInstock = qtyInstock;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyInconsumption = qtyInconsumption;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyAvailable = qtyAvailable;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyinrequisition = qtyinrequisition;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyOrdered = qtyOrdered;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyreserved = qtyreserved;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].qtyNextreceipt = qtyNextreceipt;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].dateNextreceipt = dateNextreceipt;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].actualcosamount = actualcosamount;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].plannedamt = plannedamt;
    objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data[0].language = "";
    return objectMaterialplanList58B5C6EEA25F4E4CA9577AA397AFF310Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef36D3710C11BA4C478269FA855BD6F9F1_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDefA6B12CC55F2040858356D4D480345AD2_1(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
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
  public static String selectDefB58091F4A926457D863F0E2200F63AD1_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefA7975728970945138506C6579D71286E(ConnectionProvider connectionProvider, String c_projecttask_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(line),0)+10 AS DefaultValue FROM zspm_projecttaskbom_view WHERE c_projecttask_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_projecttask_id);

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
  public static String selectDef3705F5804CE2418589BE19F9AC2ECB35_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zspm_projecttaskbom_view.C_Projecttask_ID AS NAME" +
      "        FROM zspm_projecttaskbom_view" +
      "        WHERE zspm_projecttaskbom_view.Zspm_Projecttaskbom_View_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "        UPDATE zspm_projecttaskbom_view" +
      "        SET C_Projecttask_ID = (?) , Zspm_Projecttaskbom_View_ID = (?) , Line = TO_NUMBER(?) , M_Product_ID = (?) , Description = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Constuctivemeasure = (?) , Rawmaterial = (?) , M_Locator_ID = (?) , QTY_Plan = TO_NUMBER(?) , Cutoff = TO_NUMBER(?) , Quantity = TO_NUMBER(?) , Date_Plan = TO_DATE(?) , isreturnafteruse = (?) , Planrequisition = (?) , Isactive = (?) , Qtyreceived = TO_NUMBER(?) , QTY_Instock = TO_NUMBER(?) , QTY_Inconsumption = TO_NUMBER(?) , QTY_Available = TO_NUMBER(?) , Qtyinrequisition = TO_NUMBER(?) , QTY_Ordered = TO_NUMBER(?) , Qtyreserved = TO_NUMBER(?) , QTY_Nextreceipt = TO_NUMBER(?) , Date_Nextreceipt = TO_DATE(?) , Actualcosamount = TO_NUMBER(?) , plannedamt = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_projecttaskbom_view.Zspm_Projecttaskbom_View_ID = ? " +
      "                 AND zspm_projecttaskbom_view.C_Projecttask_ID = ? " +
      "        AND zspm_projecttaskbom_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_projecttaskbom_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskbomViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, constuctivemeasure);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rawmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyPlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreturnafteruse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreceived);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyInstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyInconsumption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyAvailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyOrdered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyNextreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateNextreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcosamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskbomViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
      "        INSERT INTO zspm_projecttaskbom_view " +
      "        (C_Projecttask_ID, Zspm_Projecttaskbom_View_ID, Line, M_Product_ID, Description, AD_Client_ID, AD_Org_ID, Constuctivemeasure, Rawmaterial, M_Locator_ID, QTY_Plan, Cutoff, Quantity, Date_Plan, isreturnafteruse, Planrequisition, Isactive, Qtyreceived, QTY_Instock, QTY_Inconsumption, QTY_Available, Qtyinrequisition, QTY_Ordered, Qtyreserved, QTY_Nextreceipt, Date_Nextreceipt, Actualcosamount, plannedamt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskbomViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, constuctivemeasure);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rawmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyPlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isreturnafteruse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreceived);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyInstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyInconsumption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyAvailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyOrdered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyNextreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateNextreceipt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcosamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjecttaskId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_projecttaskbom_view" +
      "        WHERE zspm_projecttaskbom_view.Zspm_Projecttaskbom_View_ID = ? " +
      "                 AND zspm_projecttaskbom_view.C_Projecttask_ID = ? " +
      "        AND zspm_projecttaskbom_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_projecttaskbom_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_projecttaskbom_view" +
      "        WHERE zspm_projecttaskbom_view.Zspm_Projecttaskbom_View_ID = ? " +
      "                 AND zspm_projecttaskbom_view.C_Projecttask_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "          FROM zspm_projecttaskbom_view" +
      "         WHERE zspm_projecttaskbom_view.Zspm_Projecttaskbom_View_ID = ? ";

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
      "          FROM zspm_projecttaskbom_view" +
      "         WHERE zspm_projecttaskbom_view.Zspm_Projecttaskbom_View_ID = ? ";

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

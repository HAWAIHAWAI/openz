//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionPlan;

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
class WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData implements FieldProvider {
static Logger log4j = Logger.getLogger(WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String zssmProductionplanVId;
  public String zssmProductionplanVIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String isactive;
  public String value;
  public String name;
  public String zssmProductionplanTaskId;
  public String sortno;
  public String description;
  public String assembly;
  public String mProductId;
  public String mProductIdr;
  public String forcematerialscan;
  public String startonlywithcompletematerial;
  public String percentrejects;
  public String receivingLocator;
  public String receivingLocatorr;
  public String issuingLocator;
  public String issuingLocatorr;
  public String zssmProductionplanTaskVId;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_v_id") || fieldName.equals("zssmProductionplanVId"))
      return zssmProductionplanVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_v_idr") || fieldName.equals("zssmProductionplanVIdr"))
      return zssmProductionplanVIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_task_id") || fieldName.equals("zssmProductionplanTaskId"))
      return zssmProductionplanTaskId;
    else if (fieldName.equalsIgnoreCase("sortno"))
      return sortno;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("assembly"))
      return assembly;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("forcematerialscan"))
      return forcematerialscan;
    else if (fieldName.equalsIgnoreCase("startonlywithcompletematerial"))
      return startonlywithcompletematerial;
    else if (fieldName.equalsIgnoreCase("percentrejects"))
      return percentrejects;
    else if (fieldName.equalsIgnoreCase("receiving_locator") || fieldName.equals("receivingLocator"))
      return receivingLocator;
    else if (fieldName.equalsIgnoreCase("receiving_locatorr") || fieldName.equals("receivingLocatorr"))
      return receivingLocatorr;
    else if (fieldName.equalsIgnoreCase("issuing_locator") || fieldName.equals("issuingLocator"))
      return issuingLocator;
    else if (fieldName.equalsIgnoreCase("issuing_locatorr") || fieldName.equals("issuingLocatorr"))
      return issuingLocatorr;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_task_v_id") || fieldName.equals("zssmProductionplanTaskVId"))
      return zssmProductionplanTaskVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionplanVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmProductionplanVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionplanVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_productionplan_task_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionplan_task_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_productionplan_task_v.Updated, ?) as updated, " +
      "        to_char(zssm_productionplan_task_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_productionplan_task_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_productionplan_task_v.UpdatedBy) as UpdatedByR," +
      "        zssm_productionplan_task_v.AD_Org_ID, " +
      "(CASE WHEN zssm_productionplan_task_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zssm_productionplan_task_v.Zssm_Productionplan_V_ID, " +
      "(CASE WHEN zssm_productionplan_task_v.Zssm_Productionplan_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Zssm_Productionplan_V_IDR, " +
      "zssm_productionplan_task_v.C_Projecttask_ID, " +
      "(CASE WHEN zssm_productionplan_task_v.C_Projecttask_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "COALESCE(zssm_productionplan_task_v.Isactive, 'N') AS Isactive, " +
      "zssm_productionplan_task_v.Value, " +
      "zssm_productionplan_task_v.Name, " +
      "zssm_productionplan_task_v.Zssm_Productionplan_Task_ID, " +
      "zssm_productionplan_task_v.SortNo, " +
      "zssm_productionplan_task_v.Description, " +
      "COALESCE(zssm_productionplan_task_v.Assembly, 'N') AS Assembly, " +
      "zssm_productionplan_task_v.M_Product_ID, " +
      "(CASE WHEN zssm_productionplan_task_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "COALESCE(zssm_productionplan_task_v.ForceMaterialScan, 'N') AS ForceMaterialScan, " +
      "COALESCE(zssm_productionplan_task_v.StartOnlyWithCompleteMaterial, 'N') AS StartOnlyWithCompleteMaterial, " +
      "zssm_productionplan_task_v.PercentRejects, " +
      "zssm_productionplan_task_v.Receiving_Locator, " +
      "(CASE WHEN zssm_productionplan_task_v.Receiving_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'') ) END) AS Receiving_LocatorR, " +
      "zssm_productionplan_task_v.Issuing_Locator, " +
      "(CASE WHEN zssm_productionplan_task_v.Issuing_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'') ) END) AS Issuing_LocatorR, " +
      "zssm_productionplan_task_v.Zssm_Productionplan_Task_V_ID, " +
      "zssm_productionplan_task_v.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_productionplan_task_v left join (select AD_Org_ID, Name from AD_Org) table1 on (zssm_productionplan_task_v.AD_Org_ID = table1.AD_Org_ID) left join (select Zssm_Productionplan_V_ID, Value, Name from Zssm_Productionplan_V) table2 on (zssm_productionplan_task_v.Zssm_Productionplan_V_ID = table2.Zssm_Productionplan_V_ID) left join (select C_ProjectTask_ID, Name from C_ProjectTask) table3 on (zssm_productionplan_task_v.C_Projecttask_ID =  table3.C_ProjectTask_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (zssm_productionplan_task_v.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table5 on (zssm_productionplan_task_v.Receiving_Locator = table5.M_Locator_ID) left join (select M_Locator_ID, Value from M_Locator) table6 on (zssm_productionplan_task_v.Issuing_Locator = table6.M_Locator_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmProductionplanVId==null || zssmProductionplanVId.equals(""))?"":"  AND zssm_productionplan_task_v.Zssm_Productionplan_V_ID = ?  ");
    strSql = strSql + 
      "        AND zssm_productionplan_task_v.Zssm_Productionplan_Task_V_ID = ? " +
      "        AND zssm_productionplan_task_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_productionplan_task_v.AD_Org_ID IN (";
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
      if (zssmProductionplanVId != null && !(zssmProductionplanVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
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
        WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData = new WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData();
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.created = UtilSql.getValue(result, "created");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.updated = UtilSql.getValue(result, "updated");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.updatedby = UtilSql.getValue(result, "updatedby");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.zssmProductionplanVId = UtilSql.getValue(result, "zssm_productionplan_v_id");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.zssmProductionplanVIdr = UtilSql.getValue(result, "zssm_productionplan_v_idr");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.isactive = UtilSql.getValue(result, "isactive");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.value = UtilSql.getValue(result, "value");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.name = UtilSql.getValue(result, "name");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.zssmProductionplanTaskId = UtilSql.getValue(result, "zssm_productionplan_task_id");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.sortno = UtilSql.getValue(result, "sortno");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.description = UtilSql.getValue(result, "description");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.assembly = UtilSql.getValue(result, "assembly");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.forcematerialscan = UtilSql.getValue(result, "forcematerialscan");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.startonlywithcompletematerial = UtilSql.getValue(result, "startonlywithcompletematerial");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.percentrejects = UtilSql.getValue(result, "percentrejects");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.receivingLocator = UtilSql.getValue(result, "receiving_locator");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.receivingLocatorr = UtilSql.getValue(result, "receiving_locatorr");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.issuingLocator = UtilSql.getValue(result, "issuing_locator");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.issuingLocatorr = UtilSql.getValue(result, "issuing_locatorr");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.zssmProductionplanTaskVId = UtilSql.getValue(result, "zssm_productionplan_task_v_id");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.language = UtilSql.getValue(result, "language");
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.adUserClient = "";
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.adOrgClient = "";
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.createdby = "";
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.trBgcolor = "";
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.totalCount = "";
        objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData);
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
    WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] = new WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[vector.size()];
    vector.copyInto(objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData);
    return(objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData);
  }

/**
Create a registry
 */
  public static WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] set(String zssmProductionplanVId, String adClientId, String forcematerialscan, String isactive, String zssmProductionplanTaskId, String assembly, String issuingLocator, String issuingLocatorr, String createdby, String createdbyr, String sortno, String value, String cProjecttaskId, String percentrejects, String mProductId, String mProductIdr, String receivingLocator, String receivingLocatorr, String startonlywithcompletematerial, String updatedby, String updatedbyr, String zssmProductionplanTaskVId, String adOrgId, String name, String description)    throws ServletException {
    WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[] = new WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[1];
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0] = new WorkSteps5AFBDE674D824E2E8D3A41B3770632BFData();
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].created = "";
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].createdbyr = createdbyr;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].updated = "";
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].updatedTimeStamp = "";
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].updatedby = updatedby;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].updatedbyr = updatedbyr;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].adOrgId = adOrgId;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].adOrgIdr = "";
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].zssmProductionplanVId = zssmProductionplanVId;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].zssmProductionplanVIdr = "";
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].cProjecttaskId = cProjecttaskId;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].cProjecttaskIdr = "";
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].isactive = isactive;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].value = value;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].name = name;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].zssmProductionplanTaskId = zssmProductionplanTaskId;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].sortno = sortno;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].description = description;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].assembly = assembly;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].mProductId = mProductId;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].mProductIdr = mProductIdr;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].forcematerialscan = forcematerialscan;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].startonlywithcompletematerial = startonlywithcompletematerial;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].percentrejects = percentrejects;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].receivingLocator = receivingLocator;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].receivingLocatorr = receivingLocatorr;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].issuingLocator = issuingLocator;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].issuingLocatorr = issuingLocatorr;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].zssmProductionplanTaskVId = zssmProductionplanTaskVId;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].adClientId = adClientId;
    objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData[0].language = "";
    return objectWorkSteps5AFBDE674D824E2E8D3A41B3770632BFData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1CADC7C20D664DA9A85C384173E0C11F_0(ConnectionProvider connectionProvider, String Issuing_LocatorR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as Issuing_Locator FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Issuing_LocatorR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "issuing_locator");
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
  public static String selectDefC29132CFEDBF453885F4A45582BD612F_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef846599C5BED34B6B9B4F1BB5EBB35BF0_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef11962709821246C89FB5E2D9FA4F8347_3(ConnectionProvider connectionProvider, String Receiving_LocatorR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as Receiving_Locator FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Receiving_LocatorR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "receiving_locator");
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
  public static String selectDefDCD8D513BBAD45B4B6E522123A437AB4_4(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssm_productionplan_task_v.Zssm_Productionplan_V_ID AS NAME" +
      "        FROM zssm_productionplan_task_v" +
      "        WHERE zssm_productionplan_task_v.Zssm_Productionplan_Task_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmProductionplanVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionplan_v left join (select Zssm_Productionplan_V_ID, Value, Name from Zssm_Productionplan_V) table1 on (zssm_productionplan_v.Zssm_Productionplan_V_ID = table1.Zssm_Productionplan_V_ID) WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmProductionplanVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionplan_v left join (select Zssm_Productionplan_V_ID, Value, Name from Zssm_Productionplan_V) table1 on (zssm_productionplan_v.Zssm_Productionplan_V_ID = table1.Zssm_Productionplan_V_ID) WHERE zssm_productionplan_v.Zssm_Productionplan_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);

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
      "        UPDATE zssm_productionplan_task_v" +
      "        SET AD_Org_ID = (?) , Zssm_Productionplan_V_ID = (?) , C_Projecttask_ID = (?) , Isactive = (?) , Value = (?) , Name = (?) , Zssm_Productionplan_Task_ID = (?) , SortNo = TO_NUMBER(?) , Description = (?) , Assembly = (?) , M_Product_ID = (?) , ForceMaterialScan = (?) , StartOnlyWithCompleteMaterial = (?) , PercentRejects = TO_NUMBER(?) , Receiving_Locator = (?) , Issuing_Locator = (?) , Zssm_Productionplan_Task_V_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_productionplan_task_v.Zssm_Productionplan_Task_V_ID = ? " +
      "                 AND zssm_productionplan_task_v.Zssm_Productionplan_V_ID = ? " +
      "        AND zssm_productionplan_task_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionplan_task_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sortno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assembly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, forcematerialscan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startonlywithcompletematerial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentrejects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
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
      "        INSERT INTO zssm_productionplan_task_v " +
      "        (AD_Org_ID, Zssm_Productionplan_V_ID, C_Projecttask_ID, Isactive, Value, Name, Zssm_Productionplan_Task_ID, SortNo, Description, Assembly, M_Product_ID, ForceMaterialScan, StartOnlyWithCompleteMaterial, PercentRejects, Receiving_Locator, Issuing_Locator, Zssm_Productionplan_Task_V_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sortno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assembly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, forcematerialscan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startonlywithcompletematerial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentrejects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmProductionplanVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_productionplan_task_v" +
      "        WHERE zssm_productionplan_task_v.Zssm_Productionplan_Task_V_ID = ? " +
      "                 AND zssm_productionplan_task_v.Zssm_Productionplan_V_ID = ? " +
      "        AND zssm_productionplan_task_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_productionplan_task_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmProductionplanVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_productionplan_task_v" +
      "        WHERE zssm_productionplan_task_v.Zssm_Productionplan_Task_V_ID = ? " +
      "                 AND zssm_productionplan_task_v.Zssm_Productionplan_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanVId);

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
      "          FROM zssm_productionplan_task_v" +
      "         WHERE zssm_productionplan_task_v.Zssm_Productionplan_Task_V_ID = ? ";

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
      "          FROM zssm_productionplan_task_v" +
      "         WHERE zssm_productionplan_task_v.Zssm_Productionplan_Task_V_ID = ? ";

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

//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.WorkSteps;

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
class Billofmaterials55796736751C44FDB32B04FC8D3889A0Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Billofmaterials55796736751C44FDB32B04FC8D3889A0Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmWorkstepPrpVId;
  public String zssmWorkstepPrpVIdr;
  public String zspmProjecttaskbomId;
  public String isactive;
  public String adClientId;
  public String adOrgId;
  public String line;
  public String mProductId;
  public String mProductIdr;
  public String description;
  public String quantity;
  public String receivingLocator;
  public String receivingLocatorr;
  public String issuingLocator;
  public String issuingLocatorr;
  public String mLocatorId;
  public String actualcosamount;
  public String constuctivemeasure;
  public String rawmaterial;
  public String cutoff;
  public String qtyPlan;
  public String qtyreserved;
  public String qtyinrequisition;
  public String qtyreceived;
  public String datePlan;
  public String planrequisition;
  public String zssmWorkstepbomVId;
  public String qtyAvailable;
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
    else if (fieldName.equalsIgnoreCase("zssm_workstep_prp_v_id") || fieldName.equals("zssmWorkstepPrpVId"))
      return zssmWorkstepPrpVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_prp_v_idr") || fieldName.equals("zssmWorkstepPrpVIdr"))
      return zssmWorkstepPrpVIdr;
    else if (fieldName.equalsIgnoreCase("zspm_projecttaskbom_id") || fieldName.equals("zspmProjecttaskbomId"))
      return zspmProjecttaskbomId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("receiving_locator") || fieldName.equals("receivingLocator"))
      return receivingLocator;
    else if (fieldName.equalsIgnoreCase("receiving_locatorr") || fieldName.equals("receivingLocatorr"))
      return receivingLocatorr;
    else if (fieldName.equalsIgnoreCase("issuing_locator") || fieldName.equals("issuingLocator"))
      return issuingLocator;
    else if (fieldName.equalsIgnoreCase("issuing_locatorr") || fieldName.equals("issuingLocatorr"))
      return issuingLocatorr;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("actualcosamount"))
      return actualcosamount;
    else if (fieldName.equalsIgnoreCase("constuctivemeasure"))
      return constuctivemeasure;
    else if (fieldName.equalsIgnoreCase("rawmaterial"))
      return rawmaterial;
    else if (fieldName.equalsIgnoreCase("cutoff"))
      return cutoff;
    else if (fieldName.equalsIgnoreCase("qty_plan") || fieldName.equals("qtyPlan"))
      return qtyPlan;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtyinrequisition"))
      return qtyinrequisition;
    else if (fieldName.equalsIgnoreCase("qtyreceived"))
      return qtyreceived;
    else if (fieldName.equalsIgnoreCase("date_plan") || fieldName.equals("datePlan"))
      return datePlan;
    else if (fieldName.equalsIgnoreCase("planrequisition"))
      return planrequisition;
    else if (fieldName.equalsIgnoreCase("zssm_workstepbom_v_id") || fieldName.equals("zssmWorkstepbomVId"))
      return zssmWorkstepbomVId;
    else if (fieldName.equalsIgnoreCase("qty_available") || fieldName.equals("qtyAvailable"))
      return qtyAvailable;
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
  public static Billofmaterials55796736751C44FDB32B04FC8D3889A0Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepPrpVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepPrpVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Billofmaterials55796736751C44FDB32B04FC8D3889A0Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepPrpVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_workstepbom_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepbom_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_workstepbom_v.Updated, ?) as updated, " +
      "        to_char(zssm_workstepbom_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_workstepbom_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepbom_v.UpdatedBy) as UpdatedByR," +
      "        zssm_workstepbom_v.Zssm_Workstep_Prp_V_ID, " +
      "(CASE WHEN zssm_workstepbom_v.Zssm_Workstep_Prp_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS Zssm_Workstep_Prp_V_IDR, " +
      "zssm_workstepbom_v.Zspm_Projecttaskbom_ID, " +
      "COALESCE(zssm_workstepbom_v.IsActive, 'N') AS IsActive, " +
      "zssm_workstepbom_v.AD_Client_ID, " +
      "zssm_workstepbom_v.AD_Org_ID, " +
      "zssm_workstepbom_v.Line, " +
      "zssm_workstepbom_v.M_Product_ID, " +
      "(CASE WHEN zssm_workstepbom_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zssm_workstepbom_v.Description, " +
      "zssm_workstepbom_v.Quantity, " +
      "zssm_workstepbom_v.Receiving_Locator, " +
      "(CASE WHEN zssm_workstepbom_v.Receiving_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'') ) END) AS Receiving_LocatorR, " +
      "zssm_workstepbom_v.Issuing_Locator, " +
      "(CASE WHEN zssm_workstepbom_v.Issuing_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'') ) END) AS Issuing_LocatorR, " +
      "zssm_workstepbom_v.M_Locator_ID, " +
      "zssm_workstepbom_v.Actualcosamount, " +
      "zssm_workstepbom_v.Constuctivemeasure, " +
      "zssm_workstepbom_v.Rawmaterial, " +
      "zssm_workstepbom_v.Cutoff, " +
      "zssm_workstepbom_v.QTY_Plan, " +
      "zssm_workstepbom_v.Qtyreserved, " +
      "zssm_workstepbom_v.Qtyinrequisition, " +
      "zssm_workstepbom_v.Qtyreceived, " +
      "zssm_workstepbom_v.Date_Plan, " +
      "COALESCE(zssm_workstepbom_v.Planrequisition, 'N') AS Planrequisition, " +
      "zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID, " +
      "zssm_workstepbom_v.QTY_Available, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_workstepbom_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstepbom_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select M_Product_ID, Value, Name from M_Product) table3 on (zssm_workstepbom_v.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table4 on (zssm_workstepbom_v.Receiving_Locator = table4.M_Locator_ID) left join (select M_Locator_ID, Value from M_Locator) table5 on (zssm_workstepbom_v.Issuing_Locator = table5.M_Locator_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepPrpVId==null || zssmWorkstepPrpVId.equals(""))?"":"  AND zssm_workstepbom_v.Zssm_Workstep_Prp_V_ID = ?  ");
    strSql = strSql + 
      "        AND zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? " +
      "        AND zssm_workstepbom_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_workstepbom_v.AD_Org_ID IN (";
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
      if (zssmWorkstepPrpVId != null && !(zssmWorkstepPrpVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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
        Billofmaterials55796736751C44FDB32B04FC8D3889A0Data objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data = new Billofmaterials55796736751C44FDB32B04FC8D3889A0Data();
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.created = UtilSql.getValue(result, "created");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.updated = UtilSql.getValue(result, "updated");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.zssmWorkstepPrpVId = UtilSql.getValue(result, "zssm_workstep_prp_v_id");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.zssmWorkstepPrpVIdr = UtilSql.getValue(result, "zssm_workstep_prp_v_idr");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.zspmProjecttaskbomId = UtilSql.getValue(result, "zspm_projecttaskbom_id");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.isactive = UtilSql.getValue(result, "isactive");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.line = UtilSql.getValue(result, "line");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.description = UtilSql.getValue(result, "description");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.quantity = UtilSql.getValue(result, "quantity");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.receivingLocator = UtilSql.getValue(result, "receiving_locator");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.receivingLocatorr = UtilSql.getValue(result, "receiving_locatorr");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.issuingLocator = UtilSql.getValue(result, "issuing_locator");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.issuingLocatorr = UtilSql.getValue(result, "issuing_locatorr");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.actualcosamount = UtilSql.getValue(result, "actualcosamount");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.constuctivemeasure = UtilSql.getValue(result, "constuctivemeasure");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.rawmaterial = UtilSql.getValue(result, "rawmaterial");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.cutoff = UtilSql.getValue(result, "cutoff");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.qtyPlan = UtilSql.getValue(result, "qty_plan");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.qtyinrequisition = UtilSql.getValue(result, "qtyinrequisition");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.qtyreceived = UtilSql.getValue(result, "qtyreceived");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.datePlan = UtilSql.getDateValue(result, "date_plan", "dd-MM-yyyy");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.planrequisition = UtilSql.getValue(result, "planrequisition");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.zssmWorkstepbomVId = UtilSql.getValue(result, "zssm_workstepbom_v_id");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.qtyAvailable = UtilSql.getValue(result, "qty_available");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.language = UtilSql.getValue(result, "language");
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.adUserClient = "";
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.adOrgClient = "";
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.createdby = "";
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.trBgcolor = "";
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.totalCount = "";
        objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data);
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
    Billofmaterials55796736751C44FDB32B04FC8D3889A0Data objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[] = new Billofmaterials55796736751C44FDB32B04FC8D3889A0Data[vector.size()];
    vector.copyInto(objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data);
    return(objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data);
  }

/**
Create a registry
 */
  public static Billofmaterials55796736751C44FDB32B04FC8D3889A0Data[] set(String zssmWorkstepPrpVId, String qtyPlan, String zssmWorkstepbomVId, String qtyreserved, String adOrgId, String description, String cutoff, String mProductId, String mProductIdr, String updatedby, String updatedbyr, String adClientId, String datePlan, String quantity, String rawmaterial, String qtyreceived, String constuctivemeasure, String line, String issuingLocator, String issuingLocatorr, String zspmProjecttaskbomId, String planrequisition, String createdby, String createdbyr, String mLocatorId, String qtyAvailable, String receivingLocator, String receivingLocatorr, String actualcosamount, String qtyinrequisition, String isactive)    throws ServletException {
    Billofmaterials55796736751C44FDB32B04FC8D3889A0Data objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[] = new Billofmaterials55796736751C44FDB32B04FC8D3889A0Data[1];
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0] = new Billofmaterials55796736751C44FDB32B04FC8D3889A0Data();
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].created = "";
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].createdbyr = createdbyr;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].updated = "";
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].updatedTimeStamp = "";
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].updatedby = updatedby;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].updatedbyr = updatedbyr;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].zssmWorkstepPrpVId = zssmWorkstepPrpVId;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].zssmWorkstepPrpVIdr = "";
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].zspmProjecttaskbomId = zspmProjecttaskbomId;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].isactive = isactive;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].adClientId = adClientId;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].adOrgId = adOrgId;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].line = line;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].mProductId = mProductId;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].mProductIdr = mProductIdr;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].description = description;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].quantity = quantity;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].receivingLocator = receivingLocator;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].receivingLocatorr = receivingLocatorr;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].issuingLocator = issuingLocator;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].issuingLocatorr = issuingLocatorr;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].mLocatorId = mLocatorId;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].actualcosamount = actualcosamount;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].constuctivemeasure = constuctivemeasure;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].rawmaterial = rawmaterial;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].cutoff = cutoff;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].qtyPlan = qtyPlan;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].qtyreserved = qtyreserved;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].qtyinrequisition = qtyinrequisition;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].qtyreceived = qtyreceived;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].datePlan = datePlan;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].planrequisition = planrequisition;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].zssmWorkstepbomVId = zssmWorkstepbomVId;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].qtyAvailable = qtyAvailable;
    objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data[0].language = "";
    return objectBillofmaterials55796736751C44FDB32B04FC8D3889A0Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef7A3F6AF960BC464C8334BFAC465DD8DB_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef29EE2442C220441C839A0E8F1C38656B_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefBA20CE0076A6439B8059C15E850186F8(ConnectionProvider connectionProvider, String zssm_workstep_prp_v_id, String zssm_workstep_v_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM ZSSM_WORKSTEPBOM_V WHERE zssm_workstep_prp_v_id=? or zssm_workstep_v_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssm_workstep_prp_v_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssm_workstep_v_id);

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
  public static String selectDefCD3B8890911A4846A51869974E95AB3D_2(ConnectionProvider connectionProvider, String Issuing_LocatorR)    throws ServletException {
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
  public static String selectDef46D4D22988AC41AAB9A58DD210B09837_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef66C89371CA33406C84E2A61CF9B8DC91_4(ConnectionProvider connectionProvider, String Receiving_LocatorR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssm_workstepbom_v.Zssm_Workstep_Prp_V_ID AS NAME" +
      "        FROM zssm_workstepbom_v" +
      "        WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM zssm_workstep_prp_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.IsActive), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM zssm_workstep_prp_v left join (select Zssm_Workstep_Prp_V_ID, IsActive, Name, M_Product_ID from Zssm_Workstep_Prp_V) table1 on (zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = table1.Zssm_Workstep_Prp_V_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE zssm_workstep_prp_v.Zssm_Workstep_Prp_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
      "        UPDATE zssm_workstepbom_v" +
      "        SET Zssm_Workstep_Prp_V_ID = (?) , Zspm_Projecttaskbom_ID = (?) , IsActive = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Line = TO_NUMBER(?) , M_Product_ID = (?) , Description = (?) , Quantity = TO_NUMBER(?) , Receiving_Locator = (?) , Issuing_Locator = (?) , M_Locator_ID = (?) , Actualcosamount = TO_NUMBER(?) , Constuctivemeasure = (?) , Rawmaterial = (?) , Cutoff = TO_NUMBER(?) , QTY_Plan = TO_NUMBER(?) , Qtyreserved = TO_NUMBER(?) , Qtyinrequisition = TO_NUMBER(?) , Qtyreceived = TO_NUMBER(?) , Date_Plan = TO_DATE(?) , Planrequisition = (?) , Zssm_WorkstepBOM_V_ID = (?) , QTY_Available = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? " +
      "                 AND zssm_workstepbom_v.Zssm_Workstep_Prp_V_ID = ? " +
      "        AND zssm_workstepbom_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_workstepbom_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskbomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcosamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, constuctivemeasure);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rawmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyPlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreceived);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyAvailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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
      "        INSERT INTO zssm_workstepbom_v " +
      "        (Zssm_Workstep_Prp_V_ID, Zspm_Projecttaskbom_ID, IsActive, AD_Client_ID, AD_Org_ID, Line, M_Product_ID, Description, Quantity, Receiving_Locator, Issuing_Locator, M_Locator_ID, Actualcosamount, Constuctivemeasure, Rawmaterial, Cutoff, QTY_Plan, Qtyreserved, Qtyinrequisition, Qtyreceived, Date_Plan, Planrequisition, Zssm_WorkstepBOM_V_ID, QTY_Available, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskbomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcosamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, constuctivemeasure);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rawmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyPlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreceived);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyAvailable);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmWorkstepPrpVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_workstepbom_v" +
      "        WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? " +
      "                 AND zssm_workstepbom_v.Zssm_Workstep_Prp_V_ID = ? " +
      "        AND zssm_workstepbom_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_workstepbom_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmWorkstepPrpVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_workstepbom_v" +
      "        WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? " +
      "                 AND zssm_workstepbom_v.Zssm_Workstep_Prp_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepPrpVId);

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
      "          FROM zssm_workstepbom_v" +
      "         WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? ";

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
      "          FROM zssm_workstepbom_v" +
      "         WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? ";

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

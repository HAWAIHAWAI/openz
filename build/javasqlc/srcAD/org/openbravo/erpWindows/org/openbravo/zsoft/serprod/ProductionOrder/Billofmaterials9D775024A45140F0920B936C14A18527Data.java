//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;

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
class Billofmaterials9D775024A45140F0920B936C14A18527Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Billofmaterials9D775024A45140F0920B936C14A18527Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmWorkstepVId;
  public String zssmWorkstepVIdr;
  public String zspmProjecttaskbomId;
  public String adClientId;
  public String line;
  public String mProductId;
  public String mProductIdr;
  public String adOrgId;
  public String snrBatchmasterdataId;
  public String snrBatchmasterdataIdr;
  public String isactive;
  public String description;
  public String rawmaterial;
  public String constuctivemeasure;
  public String quantity;
  public String qtyreceived;
  public String qtyAvailable;
  public String qtyInstock;
  public String issuingLocator;
  public String issuingLocatorr;
  public String receivingLocator;
  public String receivingLocatorr;
  public String mLocatorId;
  public String actualcosamount;
  public String cutoff;
  public String qtyPlan;
  public String qtyreserved;
  public String qtyinrequisition;
  public String datePlan;
  public String planrequisition;
  public String zssmWorkstepbomVId;
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
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_idr") || fieldName.equals("zssmWorkstepVIdr"))
      return zssmWorkstepVIdr;
    else if (fieldName.equalsIgnoreCase("zspm_projecttaskbom_id") || fieldName.equals("zspmProjecttaskbomId"))
      return zspmProjecttaskbomId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("snr_batchmasterdata_id") || fieldName.equals("snrBatchmasterdataId"))
      return snrBatchmasterdataId;
    else if (fieldName.equalsIgnoreCase("snr_batchmasterdata_idr") || fieldName.equals("snrBatchmasterdataIdr"))
      return snrBatchmasterdataIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("rawmaterial"))
      return rawmaterial;
    else if (fieldName.equalsIgnoreCase("constuctivemeasure"))
      return constuctivemeasure;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("qtyreceived"))
      return qtyreceived;
    else if (fieldName.equalsIgnoreCase("qty_available") || fieldName.equals("qtyAvailable"))
      return qtyAvailable;
    else if (fieldName.equalsIgnoreCase("qty_instock") || fieldName.equals("qtyInstock"))
      return qtyInstock;
    else if (fieldName.equalsIgnoreCase("issuing_locator") || fieldName.equals("issuingLocator"))
      return issuingLocator;
    else if (fieldName.equalsIgnoreCase("issuing_locatorr") || fieldName.equals("issuingLocatorr"))
      return issuingLocatorr;
    else if (fieldName.equalsIgnoreCase("receiving_locator") || fieldName.equals("receivingLocator"))
      return receivingLocator;
    else if (fieldName.equalsIgnoreCase("receiving_locatorr") || fieldName.equals("receivingLocatorr"))
      return receivingLocatorr;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("actualcosamount"))
      return actualcosamount;
    else if (fieldName.equalsIgnoreCase("cutoff"))
      return cutoff;
    else if (fieldName.equalsIgnoreCase("qty_plan") || fieldName.equals("qtyPlan"))
      return qtyPlan;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtyinrequisition"))
      return qtyinrequisition;
    else if (fieldName.equalsIgnoreCase("date_plan") || fieldName.equals("datePlan"))
      return datePlan;
    else if (fieldName.equalsIgnoreCase("planrequisition"))
      return planrequisition;
    else if (fieldName.equalsIgnoreCase("zssm_workstepbom_v_id") || fieldName.equals("zssmWorkstepbomVId"))
      return zssmWorkstepbomVId;
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
  public static Billofmaterials9D775024A45140F0920B936C14A18527Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmWorkstepVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Billofmaterials9D775024A45140F0920B936C14A18527Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmWorkstepVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_workstepbom_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepbom_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_workstepbom_v.Updated, ?) as updated, " +
      "        to_char(zssm_workstepbom_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_workstepbom_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstepbom_v.UpdatedBy) as UpdatedByR," +
      "        zssm_workstepbom_v.zssm_workstep_v_id, " +
      "(CASE WHEN zssm_workstepbom_v.zssm_workstep_v_id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))),'') ) END) AS zssm_workstep_v_idR, " +
      "zssm_workstepbom_v.Zspm_Projecttaskbom_ID, " +
      "zssm_workstepbom_v.AD_Client_ID, " +
      "zssm_workstepbom_v.Line, " +
      "zssm_workstepbom_v.M_Product_ID, " +
      "(CASE WHEN zssm_workstepbom_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zssm_workstepbom_v.AD_Org_ID, " +
      "zssm_workstepbom_v.SNR_Batchmasterdata_ID, " +
      "(CASE WHEN zssm_workstepbom_v.SNR_Batchmasterdata_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Batchnumber), ''))),'') ) END) AS SNR_Batchmasterdata_IDR, " +
      "COALESCE(zssm_workstepbom_v.IsActive, 'N') AS IsActive, " +
      "zssm_workstepbom_v.Description, " +
      "zssm_workstepbom_v.Rawmaterial, " +
      "zssm_workstepbom_v.Constuctivemeasure, " +
      "zssm_workstepbom_v.Quantity, " +
      "zssm_workstepbom_v.Qtyreceived, " +
      "zssm_workstepbom_v.QTY_Available, " +
      "zssm_workstepbom_v.QTY_Instock, " +
      "zssm_workstepbom_v.Issuing_Locator, " +
      "(CASE WHEN zssm_workstepbom_v.Issuing_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'') ) END) AS Issuing_LocatorR, " +
      "zssm_workstepbom_v.Receiving_Locator, " +
      "(CASE WHEN zssm_workstepbom_v.Receiving_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'') ) END) AS Receiving_LocatorR, " +
      "zssm_workstepbom_v.M_Locator_ID, " +
      "zssm_workstepbom_v.Actualcosamount, " +
      "zssm_workstepbom_v.Cutoff, " +
      "zssm_workstepbom_v.QTY_Plan, " +
      "zssm_workstepbom_v.Qtyreserved, " +
      "zssm_workstepbom_v.Qtyinrequisition, " +
      "zssm_workstepbom_v.Date_Plan, " +
      "COALESCE(zssm_workstepbom_v.Planrequisition, 'N') AS Planrequisition, " +
      "zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_workstepbom_v left join (select zssm_workstep_v_id, Value, Name, Zssm_Prj_Name, SeqNo from zssm_workstep_v) table1 on (zssm_workstepbom_v.zssm_workstep_v_id = table1.zssm_workstep_v_id) left join (select M_Product_ID, Value, Name from M_Product) table2 on (zssm_workstepbom_v.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select SNR_Batchmasterdata_ID, Batchnumber from SNR_Batchmasterdata) table3 on (zssm_workstepbom_v.SNR_Batchmasterdata_ID = table3.SNR_Batchmasterdata_ID) left join (select M_Locator_ID, Value from M_Locator) table4 on (zssm_workstepbom_v.Issuing_Locator = table4.M_Locator_ID) left join (select M_Locator_ID, Value from M_Locator) table5 on (zssm_workstepbom_v.Receiving_Locator = table5.M_Locator_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmWorkstepVId==null || zssmWorkstepVId.equals(""))?"":"  AND zssm_workstepbom_v.zssm_workstep_v_id = ?  ");
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
      if (zssmWorkstepVId != null && !(zssmWorkstepVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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
        Billofmaterials9D775024A45140F0920B936C14A18527Data objectBillofmaterials9D775024A45140F0920B936C14A18527Data = new Billofmaterials9D775024A45140F0920B936C14A18527Data();
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.created = UtilSql.getValue(result, "created");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.updated = UtilSql.getValue(result, "updated");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.zssmWorkstepVIdr = UtilSql.getValue(result, "zssm_workstep_v_idr");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.zspmProjecttaskbomId = UtilSql.getValue(result, "zspm_projecttaskbom_id");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.line = UtilSql.getValue(result, "line");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.snrBatchmasterdataId = UtilSql.getValue(result, "snr_batchmasterdata_id");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.snrBatchmasterdataIdr = UtilSql.getValue(result, "snr_batchmasterdata_idr");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.isactive = UtilSql.getValue(result, "isactive");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.description = UtilSql.getValue(result, "description");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.rawmaterial = UtilSql.getValue(result, "rawmaterial");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.constuctivemeasure = UtilSql.getValue(result, "constuctivemeasure");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.quantity = UtilSql.getValue(result, "quantity");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.qtyreceived = UtilSql.getValue(result, "qtyreceived");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.qtyAvailable = UtilSql.getValue(result, "qty_available");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.qtyInstock = UtilSql.getValue(result, "qty_instock");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.issuingLocator = UtilSql.getValue(result, "issuing_locator");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.issuingLocatorr = UtilSql.getValue(result, "issuing_locatorr");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.receivingLocator = UtilSql.getValue(result, "receiving_locator");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.receivingLocatorr = UtilSql.getValue(result, "receiving_locatorr");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.actualcosamount = UtilSql.getValue(result, "actualcosamount");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.cutoff = UtilSql.getValue(result, "cutoff");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.qtyPlan = UtilSql.getValue(result, "qty_plan");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.qtyinrequisition = UtilSql.getValue(result, "qtyinrequisition");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.datePlan = UtilSql.getDateValue(result, "date_plan", "dd-MM-yyyy");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.planrequisition = UtilSql.getValue(result, "planrequisition");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.zssmWorkstepbomVId = UtilSql.getValue(result, "zssm_workstepbom_v_id");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.language = UtilSql.getValue(result, "language");
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.adUserClient = "";
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.adOrgClient = "";
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.createdby = "";
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.trBgcolor = "";
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.totalCount = "";
        objectBillofmaterials9D775024A45140F0920B936C14A18527Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBillofmaterials9D775024A45140F0920B936C14A18527Data);
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
    Billofmaterials9D775024A45140F0920B936C14A18527Data objectBillofmaterials9D775024A45140F0920B936C14A18527Data[] = new Billofmaterials9D775024A45140F0920B936C14A18527Data[vector.size()];
    vector.copyInto(objectBillofmaterials9D775024A45140F0920B936C14A18527Data);
    return(objectBillofmaterials9D775024A45140F0920B936C14A18527Data);
  }

/**
Create a registry
 */
  public static Billofmaterials9D775024A45140F0920B936C14A18527Data[] set(String zssmWorkstepVId, String qtyPlan, String zssmWorkstepbomVId, String snrBatchmasterdataId, String qtyreserved, String qtyAvailable, String adOrgId, String qtyreceived, String rawmaterial, String description, String cutoff, String mProductId, String mProductIdr, String datePlan, String isactive, String line, String qtyInstock, String zspmProjecttaskbomId, String issuingLocator, String issuingLocatorr, String planrequisition, String createdby, String createdbyr, String mLocatorId, String receivingLocator, String receivingLocatorr, String actualcosamount, String qtyinrequisition, String constuctivemeasure, String updatedby, String updatedbyr, String adClientId, String quantity)    throws ServletException {
    Billofmaterials9D775024A45140F0920B936C14A18527Data objectBillofmaterials9D775024A45140F0920B936C14A18527Data[] = new Billofmaterials9D775024A45140F0920B936C14A18527Data[1];
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0] = new Billofmaterials9D775024A45140F0920B936C14A18527Data();
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].created = "";
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].createdbyr = createdbyr;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].updated = "";
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].updatedTimeStamp = "";
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].updatedby = updatedby;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].updatedbyr = updatedbyr;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].zssmWorkstepVId = zssmWorkstepVId;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].zssmWorkstepVIdr = "";
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].zspmProjecttaskbomId = zspmProjecttaskbomId;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].adClientId = adClientId;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].line = line;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].mProductId = mProductId;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].mProductIdr = mProductIdr;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].adOrgId = adOrgId;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].snrBatchmasterdataId = snrBatchmasterdataId;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].snrBatchmasterdataIdr = "";
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].isactive = isactive;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].description = description;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].rawmaterial = rawmaterial;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].constuctivemeasure = constuctivemeasure;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].quantity = quantity;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].qtyreceived = qtyreceived;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].qtyAvailable = qtyAvailable;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].qtyInstock = qtyInstock;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].issuingLocator = issuingLocator;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].issuingLocatorr = issuingLocatorr;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].receivingLocator = receivingLocator;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].receivingLocatorr = receivingLocatorr;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].mLocatorId = mLocatorId;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].actualcosamount = actualcosamount;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].cutoff = cutoff;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].qtyPlan = qtyPlan;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].qtyreserved = qtyreserved;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].qtyinrequisition = qtyinrequisition;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].datePlan = datePlan;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].planrequisition = planrequisition;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].zssmWorkstepbomVId = zssmWorkstepbomVId;
    objectBillofmaterials9D775024A45140F0920B936C14A18527Data[0].language = "";
    return objectBillofmaterials9D775024A45140F0920B936C14A18527Data;
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
  public static String selectDefCD3B8890911A4846A51869974E95AB3D_1(ConnectionProvider connectionProvider, String Issuing_LocatorR)    throws ServletException {
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
  public static String selectDef46D4D22988AC41AAB9A58DD210B09837_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef66C89371CA33406C84E2A61CF9B8DC91_3(ConnectionProvider connectionProvider, String Receiving_LocatorR)    throws ServletException {
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
  public static String selectDef29EE2442C220441C839A0E8F1C38656B_4(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zssm_workstepbom_v.zssm_workstep_v_id AS NAME" +
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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select zssm_workstep_v_id, Value, Name, Zssm_Prj_Name, SeqNo from zssm_workstep_v) table1 on (zssm_workstep_v.zssm_workstep_v_id = table1.zssm_workstep_v_id) WHERE zssm_workstep_v.zssm_workstep_v_id = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Zssm_Prj_Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))) AS NAME FROM zssm_workstep_v left join (select zssm_workstep_v_id, Value, Name, Zssm_Prj_Name, SeqNo from zssm_workstep_v) table1 on (zssm_workstep_v.zssm_workstep_v_id = table1.zssm_workstep_v_id) WHERE zssm_workstep_v.zssm_workstep_v_id = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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
      "        SET zssm_workstep_v_id = (?) , Zspm_Projecttaskbom_ID = (?) , AD_Client_ID = (?) , Line = TO_NUMBER(?) , M_Product_ID = (?) , AD_Org_ID = (?) , SNR_Batchmasterdata_ID = (?) , IsActive = (?) , Description = (?) , Rawmaterial = (?) , Constuctivemeasure = (?) , Quantity = TO_NUMBER(?) , Qtyreceived = TO_NUMBER(?) , QTY_Available = TO_NUMBER(?) , QTY_Instock = TO_NUMBER(?) , Issuing_Locator = (?) , Receiving_Locator = (?) , M_Locator_ID = (?) , Actualcosamount = TO_NUMBER(?) , Cutoff = TO_NUMBER(?) , QTY_Plan = TO_NUMBER(?) , Qtyreserved = TO_NUMBER(?) , Qtyinrequisition = TO_NUMBER(?) , Date_Plan = TO_DATE(?) , Planrequisition = (?) , Zssm_WorkstepBOM_V_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? " +
      "                 AND zssm_workstepbom_v.zssm_workstep_v_id = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskbomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rawmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, constuctivemeasure);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreceived);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyAvailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyInstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcosamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyPlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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
      "        (zssm_workstep_v_id, Zspm_Projecttaskbom_ID, AD_Client_ID, Line, M_Product_ID, AD_Org_ID, SNR_Batchmasterdata_ID, IsActive, Description, Rawmaterial, Constuctivemeasure, Quantity, Qtyreceived, QTY_Available, QTY_Instock, Issuing_Locator, Receiving_Locator, M_Locator_ID, Actualcosamount, Cutoff, QTY_Plan, Qtyreserved, Qtyinrequisition, Date_Plan, Planrequisition, Zssm_WorkstepBOM_V_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmProjecttaskbomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rawmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, constuctivemeasure);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreceived);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyAvailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyInstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcosamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyPlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datePlan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planrequisition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepbomVId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmWorkstepVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_workstepbom_v" +
      "        WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? " +
      "                 AND zssm_workstepbom_v.zssm_workstep_v_id = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmWorkstepVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_workstepbom_v" +
      "        WHERE zssm_workstepbom_v.Zssm_WorkstepBOM_V_ID = ? " +
      "                 AND zssm_workstepbom_v.zssm_workstep_v_id = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);

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

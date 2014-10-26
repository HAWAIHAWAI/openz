//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.CurrentlyActiveWorksteps;

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
class Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String zssmProductionorderVId;
  public String zssmProductionorderVIdr;
  public String name;
  public String ended;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String value;
  public String seqno;
  public String started;
  public String startdate;
  public String enddate;
  public String description;
  public String triggerreason;
  public String qty;
  public String qtyproduced;
  public String mProductId;
  public String mProductIdr;
  public String assembly;
  public String receivingLocator;
  public String receivingLocatorr;
  public String issuingLocator;
  public String issuingLocatorr;
  public String servcostplan;
  public String machinecostplan;
  public String materialcostplan;
  public String plannedcost;
  public String machinecost;
  public String help;
  public String invoicedamt;
  public String zssmProductionplanTaskId;
  public String datecontract;
  public String cOrderlineId;
  public String endtask;
  public String cTaskId;
  public String zssmWorkstepVId;
  public String getmaterialfromstock;
  public String iscomplete;
  public String begintask;
  public String servcost;
  public String materialcost;
  public String taskbegun;
  public String percentdone;
  public String gotopurchasing;
  public String expenses;
  public String canceltask;
  public String indirectcost;
  public String ismaterialdisposed;
  public String returnmaterialtostock;
  public String indirectcostplan;
  public String istaskcancelled;
  public String adClientId;
  public String percentrejects;
  public String committedamt;
  public String qtyleft;
  public String schedulestatus;
  public String unplanmaterial;
  public String iscommitceiling;
  public String planmaterial;
  public String outsourcing;
  public String priceactual;
  public String actualcost;
  public String createbom;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_id") || fieldName.equals("zssmProductionorderVId"))
      return zssmProductionorderVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_idr") || fieldName.equals("zssmProductionorderVIdr"))
      return zssmProductionorderVIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ended"))
      return ended;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("started"))
      return started;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("triggerreason"))
      return triggerreason;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("qtyproduced"))
      return qtyproduced;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("assembly"))
      return assembly;
    else if (fieldName.equalsIgnoreCase("receiving_locator") || fieldName.equals("receivingLocator"))
      return receivingLocator;
    else if (fieldName.equalsIgnoreCase("receiving_locatorr") || fieldName.equals("receivingLocatorr"))
      return receivingLocatorr;
    else if (fieldName.equalsIgnoreCase("issuing_locator") || fieldName.equals("issuingLocator"))
      return issuingLocator;
    else if (fieldName.equalsIgnoreCase("issuing_locatorr") || fieldName.equals("issuingLocatorr"))
      return issuingLocatorr;
    else if (fieldName.equalsIgnoreCase("servcostplan"))
      return servcostplan;
    else if (fieldName.equalsIgnoreCase("machinecostplan"))
      return machinecostplan;
    else if (fieldName.equalsIgnoreCase("materialcostplan"))
      return materialcostplan;
    else if (fieldName.equalsIgnoreCase("plannedcost"))
      return plannedcost;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_task_id") || fieldName.equals("zssmProductionplanTaskId"))
      return zssmProductionplanTaskId;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("endtask"))
      return endtask;
    else if (fieldName.equalsIgnoreCase("c_task_id") || fieldName.equals("cTaskId"))
      return cTaskId;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("getmaterialfromstock"))
      return getmaterialfromstock;
    else if (fieldName.equalsIgnoreCase("iscomplete"))
      return iscomplete;
    else if (fieldName.equalsIgnoreCase("begintask"))
      return begintask;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("taskbegun"))
      return taskbegun;
    else if (fieldName.equalsIgnoreCase("percentdone"))
      return percentdone;
    else if (fieldName.equalsIgnoreCase("gotopurchasing"))
      return gotopurchasing;
    else if (fieldName.equalsIgnoreCase("expenses"))
      return expenses;
    else if (fieldName.equalsIgnoreCase("canceltask"))
      return canceltask;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("ismaterialdisposed"))
      return ismaterialdisposed;
    else if (fieldName.equalsIgnoreCase("returnmaterialtostock"))
      return returnmaterialtostock;
    else if (fieldName.equalsIgnoreCase("indirectcostplan"))
      return indirectcostplan;
    else if (fieldName.equalsIgnoreCase("istaskcancelled"))
      return istaskcancelled;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("percentrejects"))
      return percentrejects;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("qtyleft"))
      return qtyleft;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("unplanmaterial"))
      return unplanmaterial;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("planmaterial"))
      return planmaterial;
    else if (fieldName.equalsIgnoreCase("outsourcing"))
      return outsourcing;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("actualcost"))
      return actualcost;
    else if (fieldName.equalsIgnoreCase("createbom"))
      return createbom;
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
  public static Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_workstep_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstep_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_workstep_v.Updated, ?) as updated, " +
      "        to_char(zssm_workstep_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_workstep_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstep_v.UpdatedBy) as UpdatedByR," +
      "        zssm_workstep_v.AD_Org_ID, " +
      "(CASE WHEN zssm_workstep_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(zssm_workstep_v.IsActive, 'N') AS IsActive, " +
      "zssm_workstep_v.zssm_productionorder_v_id, " +
      "(CASE WHEN zssm_workstep_v.zssm_productionorder_v_id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS zssm_productionorder_v_idR, " +
      "zssm_workstep_v.Name, " +
      "zssm_workstep_v.Ended, " +
      "zssm_workstep_v.C_ProjectTask_ID, " +
      "(CASE WHEN zssm_workstep_v.C_ProjectTask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_ProjectTask_IDR, " +
      "zssm_workstep_v.Value, " +
      "zssm_workstep_v.SeqNo, " +
      "zssm_workstep_v.Started, " +
      "zssm_workstep_v.StartDate, " +
      "zssm_workstep_v.Enddate, " +
      "zssm_workstep_v.Description, " +
      "zssm_workstep_v.Triggerreason, " +
      "zssm_workstep_v.Qty, " +
      "zssm_workstep_v.Qtyproduced, " +
      "zssm_workstep_v.M_Product_ID, " +
      "(CASE WHEN zssm_workstep_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "COALESCE(zssm_workstep_v.Assembly, 'N') AS Assembly, " +
      "zssm_workstep_v.Receiving_Locator, " +
      "(CASE WHEN zssm_workstep_v.Receiving_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'') ) END) AS Receiving_LocatorR, " +
      "zssm_workstep_v.Issuing_Locator, " +
      "(CASE WHEN zssm_workstep_v.Issuing_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Value), ''))),'') ) END) AS Issuing_LocatorR, " +
      "zssm_workstep_v.Servcostplan, " +
      "zssm_workstep_v.Machinecostplan, " +
      "zssm_workstep_v.Materialcostplan, " +
      "zssm_workstep_v.Plannedcost, " +
      "zssm_workstep_v.Machinecost, " +
      "zssm_workstep_v.Help, " +
      "zssm_workstep_v.Invoicedamt, " +
      "zssm_workstep_v.Zssm_Productionplan_Task_ID, " +
      "zssm_workstep_v.Datecontract, " +
      "zssm_workstep_v.C_Orderline_ID, " +
      "zssm_workstep_v.Endtask, " +
      "zssm_workstep_v.C_Task_ID, " +
      "zssm_workstep_v.Zssm_Workstep_V_ID, " +
      "zssm_workstep_v.Getmaterialfromstock, " +
      "COALESCE(zssm_workstep_v.Iscomplete, 'N') AS Iscomplete, " +
      "zssm_workstep_v.BeginTask, " +
      "zssm_workstep_v.Servcost, " +
      "zssm_workstep_v.Materialcost, " +
      "COALESCE(zssm_workstep_v.Taskbegun, 'N') AS Taskbegun, " +
      "zssm_workstep_v.Percentdone, " +
      "COALESCE(zssm_workstep_v.Gotopurchasing, 'N') AS Gotopurchasing, " +
      "zssm_workstep_v.Expenses, " +
      "zssm_workstep_v.Canceltask, " +
      "zssm_workstep_v.Indirectcost, " +
      "COALESCE(zssm_workstep_v.Ismaterialdisposed, 'N') AS Ismaterialdisposed, " +
      "zssm_workstep_v.Returnmaterialtostock, " +
      "zssm_workstep_v.Indirectcostplan, " +
      "COALESCE(zssm_workstep_v.Istaskcancelled, 'N') AS Istaskcancelled, " +
      "zssm_workstep_v.AD_Client_ID, " +
      "zssm_workstep_v.Percentrejects, " +
      "zssm_workstep_v.Committedamt, " +
      "zssm_workstep_v.Qtyleft, " +
      "zssm_workstep_v.Schedulestatus, " +
      "zssm_workstep_v.Unplanmaterial, " +
      "COALESCE(zssm_workstep_v.Iscommitceiling, 'N') AS Iscommitceiling, " +
      "zssm_workstep_v.Planmaterial, " +
      "COALESCE(zssm_workstep_v.Outsourcing, 'N') AS Outsourcing, " +
      "zssm_workstep_v.PriceActual, " +
      "zssm_workstep_v.Actualcost, " +
      "zssm_workstep_v.Createbom, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_workstep_v left join (select AD_Org_ID, Name from AD_Org) table1 on (zssm_workstep_v.AD_Org_ID = table1.AD_Org_ID) left join (select zssm_productionorder_v_id, Value, Name from zssm_productionorder_v) table2 on (zssm_workstep_v.zssm_productionorder_v_id = table2.zssm_productionorder_v_id) left join (select C_ProjectTask_ID, Name, C_Project_ID from C_ProjectTask) table3 on (zssm_workstep_v.C_ProjectTask_ID = table3.C_ProjectTask_ID) left join (select C_Project_ID, Value, Name from C_Project) table4 on (table3.C_Project_ID = table4.C_Project_ID) left join (select M_Product_ID, Value, Name from M_Product) table5 on (zssm_workstep_v.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table6 on (zssm_workstep_v.Receiving_Locator = table6.M_Locator_ID) left join (select M_Locator_ID, Value from M_Locator) table7 on (zssm_workstep_v.Issuing_Locator = table7.M_Locator_ID)" +
      "        WHERE 2=2 " +
      " AND zssm_workstep_v.iscomplete ='N'  and zssm_workstep_v.istaskcancelled='N' and zssm_workstep_v.taskbegun ='Y' and zssm_workstep_v.zssm_productionorder_v_id is not null" +
      "        AND 1=1 " +
      "        AND zssm_workstep_v.Zssm_Workstep_V_ID = ? " +
      "        AND zssm_workstep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssm_workstep_v.AD_Org_ID IN (";
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
        Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data = new Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data();
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.created = UtilSql.getValue(result, "created");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.updated = UtilSql.getValue(result, "updated");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.isactive = UtilSql.getValue(result, "isactive");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.zssmProductionorderVId = UtilSql.getValue(result, "zssm_productionorder_v_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.zssmProductionorderVIdr = UtilSql.getValue(result, "zssm_productionorder_v_idr");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.name = UtilSql.getValue(result, "name");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.ended = UtilSql.getDateValue(result, "ended", "dd-MM-yyyy");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.value = UtilSql.getValue(result, "value");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.seqno = UtilSql.getValue(result, "seqno");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.started = UtilSql.getDateValue(result, "started", "dd-MM-yyyy");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.description = UtilSql.getValue(result, "description");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.triggerreason = UtilSql.getValue(result, "triggerreason");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.qty = UtilSql.getValue(result, "qty");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.qtyproduced = UtilSql.getValue(result, "qtyproduced");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.assembly = UtilSql.getValue(result, "assembly");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.receivingLocator = UtilSql.getValue(result, "receiving_locator");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.receivingLocatorr = UtilSql.getValue(result, "receiving_locatorr");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.issuingLocator = UtilSql.getValue(result, "issuing_locator");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.issuingLocatorr = UtilSql.getValue(result, "issuing_locatorr");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.servcostplan = UtilSql.getValue(result, "servcostplan");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.machinecostplan = UtilSql.getValue(result, "machinecostplan");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.materialcostplan = UtilSql.getValue(result, "materialcostplan");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.plannedcost = UtilSql.getValue(result, "plannedcost");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.machinecost = UtilSql.getValue(result, "machinecost");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.help = UtilSql.getValue(result, "help");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.zssmProductionplanTaskId = UtilSql.getValue(result, "zssm_productionplan_task_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.endtask = UtilSql.getValue(result, "endtask");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.cTaskId = UtilSql.getValue(result, "c_task_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.getmaterialfromstock = UtilSql.getValue(result, "getmaterialfromstock");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.iscomplete = UtilSql.getValue(result, "iscomplete");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.begintask = UtilSql.getValue(result, "begintask");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.servcost = UtilSql.getValue(result, "servcost");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.materialcost = UtilSql.getValue(result, "materialcost");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.taskbegun = UtilSql.getValue(result, "taskbegun");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.percentdone = UtilSql.getValue(result, "percentdone");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.gotopurchasing = UtilSql.getValue(result, "gotopurchasing");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.expenses = UtilSql.getValue(result, "expenses");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.canceltask = UtilSql.getValue(result, "canceltask");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.ismaterialdisposed = UtilSql.getValue(result, "ismaterialdisposed");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.returnmaterialtostock = UtilSql.getValue(result, "returnmaterialtostock");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.indirectcostplan = UtilSql.getValue(result, "indirectcostplan");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.istaskcancelled = UtilSql.getValue(result, "istaskcancelled");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.percentrejects = UtilSql.getValue(result, "percentrejects");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.committedamt = UtilSql.getValue(result, "committedamt");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.qtyleft = UtilSql.getValue(result, "qtyleft");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.unplanmaterial = UtilSql.getValue(result, "unplanmaterial");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.planmaterial = UtilSql.getValue(result, "planmaterial");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.outsourcing = UtilSql.getValue(result, "outsourcing");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.priceactual = UtilSql.getValue(result, "priceactual");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.actualcost = UtilSql.getValue(result, "actualcost");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.createbom = UtilSql.getValue(result, "createbom");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.language = UtilSql.getValue(result, "language");
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.adUserClient = "";
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.adOrgClient = "";
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.createdby = "";
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.trBgcolor = "";
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.totalCount = "";
        objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data);
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
    Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[] = new Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[vector.size()];
    vector.copyInto(objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data);
    return(objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data);
  }

/**
Create a registry
 */
  public static Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[] set(String help, String expenses, String planmaterial, String machinecostplan, String priceactual, String endtask, String updatedby, String updatedbyr, String outsourcing, String unplanmaterial, String taskbegun, String indirectcostplan, String triggerreason, String canceltask, String createbom, String invoicedamt, String qty, String ismaterialdisposed, String mProductId, String mProductIdr, String startdate, String receivingLocator, String receivingLocatorr, String begintask, String machinecost, String zssmWorkstepVId, String iscomplete, String createdby, String createdbyr, String getmaterialfromstock, String iscommitceiling, String returnmaterialtostock, String schedulestatus, String issuingLocator, String issuingLocatorr, String qtyproduced, String datecontract, String cOrderlineId, String adClientId, String zssmProductionorderVId, String committedamt, String actualcost, String cTaskId, String servcost, String servcostplan, String ended, String assembly, String plannedcost, String seqno, String materialcostplan, String isactive, String materialcost, String qtyleft, String started, String percentdone, String value, String zssmProductionplanTaskId, String gotopurchasing, String percentrejects, String description, String name, String cProjecttaskId, String enddate, String istaskcancelled, String indirectcost, String adOrgId)    throws ServletException {
    Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[] = new Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[1];
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0] = new Currentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data();
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].created = "";
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].createdbyr = createdbyr;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].updated = "";
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].updatedTimeStamp = "";
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].updatedby = updatedby;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].updatedbyr = updatedbyr;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].adOrgId = adOrgId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].adOrgIdr = "";
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].isactive = isactive;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].zssmProductionorderVId = zssmProductionorderVId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].zssmProductionorderVIdr = "";
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].name = name;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].ended = ended;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].cProjecttaskId = cProjecttaskId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].cProjecttaskIdr = "";
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].value = value;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].seqno = seqno;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].started = started;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].startdate = startdate;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].enddate = enddate;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].description = description;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].triggerreason = triggerreason;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].qty = qty;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].qtyproduced = qtyproduced;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].mProductId = mProductId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].mProductIdr = mProductIdr;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].assembly = assembly;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].receivingLocator = receivingLocator;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].receivingLocatorr = receivingLocatorr;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].issuingLocator = issuingLocator;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].issuingLocatorr = issuingLocatorr;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].servcostplan = servcostplan;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].machinecostplan = machinecostplan;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].materialcostplan = materialcostplan;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].plannedcost = plannedcost;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].machinecost = machinecost;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].help = help;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].invoicedamt = invoicedamt;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].zssmProductionplanTaskId = zssmProductionplanTaskId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].datecontract = datecontract;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].cOrderlineId = cOrderlineId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].endtask = endtask;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].cTaskId = cTaskId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].zssmWorkstepVId = zssmWorkstepVId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].getmaterialfromstock = getmaterialfromstock;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].iscomplete = iscomplete;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].begintask = begintask;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].servcost = servcost;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].materialcost = materialcost;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].taskbegun = taskbegun;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].percentdone = percentdone;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].gotopurchasing = gotopurchasing;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].expenses = expenses;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].canceltask = canceltask;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].indirectcost = indirectcost;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].ismaterialdisposed = ismaterialdisposed;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].returnmaterialtostock = returnmaterialtostock;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].indirectcostplan = indirectcostplan;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].istaskcancelled = istaskcancelled;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].adClientId = adClientId;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].percentrejects = percentrejects;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].committedamt = committedamt;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].qtyleft = qtyleft;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].schedulestatus = schedulestatus;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].unplanmaterial = unplanmaterial;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].iscommitceiling = iscommitceiling;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].planmaterial = planmaterial;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].outsourcing = outsourcing;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].priceactual = priceactual;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].actualcost = actualcost;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].createbom = createbom;
    objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data[0].language = "";
    return objectCurrentlyactiveworksteps9C1528AEC09B4959A20B9C175F41C277Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef18E2B62B71AA4FCC8F0E7E5AB8FAD6D2_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef5289F216D0D6477B874F419B2DA25F87_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef59634A916FC54AC99E95765067C5774C(ConnectionProvider connectionProvider, String AD_JAVADATEFORMAT, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(startdate,?)  AS DefaultValue from C_Project where C_Project_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_JAVADATEFORMAT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

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
  public static String selectDef16D7CBA97CC64B5DBE296A6F9B754BD1_2(ConnectionProvider connectionProvider, String Receiving_LocatorR)    throws ServletException {
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
  public static String selectDefBF72293C90A14B129863C0F861752AE1_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef303E0FBA8DBC4B368E5FF9BACE658878_4(ConnectionProvider connectionProvider, String Issuing_LocatorR)    throws ServletException {
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
  public static String selectDefC46C3A0F43DC4141ACA5A7451857773A(ConnectionProvider connectionProvider, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM C_ProjectTask WHERE C_Project_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

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
  public static String selectDef1119F3F170EF46D1A1B69625B63F826C(ConnectionProvider connectionProvider, String AD_JAVADATEFORMAT, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  to_char(datefinish,?)  AS DefaultValue from C_Project where C_Project_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_JAVADATEFORMAT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

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
Select for action search
 */
  public static String selectActDefM_Locator_ID(ConnectionProvider connectionProvider, String M_Locator_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Value FROM M_Locator WHERE isActive='Y' AND M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
      "        UPDATE zssm_workstep_v" +
      "        SET AD_Org_ID = (?) , IsActive = (?) , zssm_productionorder_v_id = (?) , Name = (?) , Ended = TO_DATE(?) , C_ProjectTask_ID = (?) , Value = (?) , SeqNo = TO_NUMBER(?) , Started = TO_DATE(?) , StartDate = TO_DATE(?) , Enddate = TO_DATE(?) , Description = (?) , Triggerreason = (?) , Qty = TO_NUMBER(?) , Qtyproduced = TO_NUMBER(?) , M_Product_ID = (?) , Assembly = (?) , Receiving_Locator = (?) , Issuing_Locator = (?) , Servcostplan = TO_NUMBER(?) , Machinecostplan = TO_NUMBER(?) , Materialcostplan = TO_NUMBER(?) , Plannedcost = TO_NUMBER(?) , Machinecost = TO_NUMBER(?) , Help = (?) , Invoicedamt = TO_NUMBER(?) , Zssm_Productionplan_Task_ID = (?) , Datecontract = TO_DATE(?) , C_Orderline_ID = (?) , Endtask = (?) , C_Task_ID = (?) , Zssm_Workstep_V_ID = (?) , Getmaterialfromstock = (?) , Iscomplete = (?) , BeginTask = (?) , Servcost = TO_NUMBER(?) , Materialcost = TO_NUMBER(?) , Taskbegun = (?) , Percentdone = TO_NUMBER(?) , Gotopurchasing = (?) , Expenses = TO_NUMBER(?) , Canceltask = (?) , Indirectcost = TO_NUMBER(?) , Ismaterialdisposed = (?) , Returnmaterialtostock = (?) , Indirectcostplan = TO_NUMBER(?) , Istaskcancelled = (?) , AD_Client_ID = (?) , Percentrejects = TO_NUMBER(?) , Committedamt = TO_NUMBER(?) , Qtyleft = TO_NUMBER(?) , Schedulestatus = (?) , Unplanmaterial = (?) , Iscommitceiling = (?) , Planmaterial = (?) , Outsourcing = (?) , PriceActual = TO_NUMBER(?) , Actualcost = TO_NUMBER(?) , Createbom = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ? " +
      "        AND zssm_workstep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_workstep_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ended);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, started);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggerreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyproduced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assembly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, getmaterialfromstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, begintask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskbegun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gotopurchasing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, canceltask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismaterialdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnmaterialtostock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskcancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentrejects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyleft);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourcing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO zssm_workstep_v " +
      "        (AD_Org_ID, IsActive, zssm_productionorder_v_id, Name, Ended, C_ProjectTask_ID, Value, SeqNo, Started, StartDate, Enddate, Description, Triggerreason, Qty, Qtyproduced, M_Product_ID, Assembly, Receiving_Locator, Issuing_Locator, Servcostplan, Machinecostplan, Materialcostplan, Plannedcost, Machinecost, Help, Invoicedamt, Zssm_Productionplan_Task_ID, Datecontract, C_Orderline_ID, Endtask, C_Task_ID, Zssm_Workstep_V_ID, Getmaterialfromstock, Iscomplete, BeginTask, Servcost, Materialcost, Taskbegun, Percentdone, Gotopurchasing, Expenses, Canceltask, Indirectcost, Ismaterialdisposed, Returnmaterialtostock, Indirectcostplan, Istaskcancelled, AD_Client_ID, Percentrejects, Committedamt, Qtyleft, Schedulestatus, Unplanmaterial, Iscommitceiling, Planmaterial, Outsourcing, PriceActual, Actualcost, Createbom, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ended);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, started);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggerreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyproduced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assembly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, getmaterialfromstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, begintask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskbegun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gotopurchasing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, canceltask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismaterialdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnmaterialtostock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskcancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentrejects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyleft);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourcing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createbom);
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
      "        DELETE FROM zssm_workstep_v" +
      "        WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ? " +
      "        AND zssm_workstep_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssm_workstep_v.AD_Org_ID IN (";
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
      "        DELETE FROM zssm_workstep_v" +
      "        WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ? ";

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
      "          FROM zssm_workstep_v" +
      "         WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ? ";

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
      "          FROM zssm_workstep_v" +
      "         WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ? ";

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

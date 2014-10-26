//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.PlannedWorksteps;

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
class PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData implements FieldProvider {
static Logger log4j = Logger.getLogger(PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.class);
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
  public String name;
  public String zssmProductionorderVId;
  public String zssmProductionorderVIdr;
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
  public String createbom;
  public String cTaskId;
  public String help;
  public String schedulestatus;
  public String servcost;
  public String priceactual;
  public String canceltask;
  public String cOrderlineId;
  public String iscomplete;
  public String percentrejects;
  public String iscommitceiling;
  public String ismaterialdisposed;
  public String indirectcostplan;
  public String datecontract;
  public String adClientId;
  public String returnmaterialtostock;
  public String percentdone;
  public String outsourcing;
  public String begintask;
  public String expenses;
  public String actualcost;
  public String unplanmaterial;
  public String invoicedamt;
  public String taskbegun;
  public String getmaterialfromstock;
  public String committedamt;
  public String indirectcost;
  public String machinecost;
  public String istaskcancelled;
  public String endtask;
  public String gotopurchasing;
  public String materialcost;
  public String planmaterial;
  public String qtyleft;
  public String zssmWorkstepVId;
  public String zssmProductionplanTaskId;
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
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_id") || fieldName.equals("zssmProductionorderVId"))
      return zssmProductionorderVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_idr") || fieldName.equals("zssmProductionorderVIdr"))
      return zssmProductionorderVIdr;
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
    else if (fieldName.equalsIgnoreCase("createbom"))
      return createbom;
    else if (fieldName.equalsIgnoreCase("c_task_id") || fieldName.equals("cTaskId"))
      return cTaskId;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("canceltask"))
      return canceltask;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("iscomplete"))
      return iscomplete;
    else if (fieldName.equalsIgnoreCase("percentrejects"))
      return percentrejects;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("ismaterialdisposed"))
      return ismaterialdisposed;
    else if (fieldName.equalsIgnoreCase("indirectcostplan"))
      return indirectcostplan;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("returnmaterialtostock"))
      return returnmaterialtostock;
    else if (fieldName.equalsIgnoreCase("percentdone"))
      return percentdone;
    else if (fieldName.equalsIgnoreCase("outsourcing"))
      return outsourcing;
    else if (fieldName.equalsIgnoreCase("begintask"))
      return begintask;
    else if (fieldName.equalsIgnoreCase("expenses"))
      return expenses;
    else if (fieldName.equalsIgnoreCase("actualcost"))
      return actualcost;
    else if (fieldName.equalsIgnoreCase("unplanmaterial"))
      return unplanmaterial;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("taskbegun"))
      return taskbegun;
    else if (fieldName.equalsIgnoreCase("getmaterialfromstock"))
      return getmaterialfromstock;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("istaskcancelled"))
      return istaskcancelled;
    else if (fieldName.equalsIgnoreCase("endtask"))
      return endtask;
    else if (fieldName.equalsIgnoreCase("gotopurchasing"))
      return gotopurchasing;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("planmaterial"))
      return planmaterial;
    else if (fieldName.equalsIgnoreCase("qtyleft"))
      return qtyleft;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_task_id") || fieldName.equals("zssmProductionplanTaskId"))
      return zssmProductionplanTaskId;
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
  public static PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "zssm_workstep_v.Name, " +
      "zssm_workstep_v.zssm_productionorder_v_id, " +
      "(CASE WHEN zssm_workstep_v.zssm_productionorder_v_id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS zssm_productionorder_v_idR, " +
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
      "zssm_workstep_v.Createbom, " +
      "zssm_workstep_v.C_Task_ID, " +
      "zssm_workstep_v.Help, " +
      "zssm_workstep_v.Schedulestatus, " +
      "zssm_workstep_v.Servcost, " +
      "zssm_workstep_v.PriceActual, " +
      "zssm_workstep_v.Canceltask, " +
      "zssm_workstep_v.C_Orderline_ID, " +
      "COALESCE(zssm_workstep_v.Iscomplete, 'N') AS Iscomplete, " +
      "zssm_workstep_v.Percentrejects, " +
      "COALESCE(zssm_workstep_v.Iscommitceiling, 'N') AS Iscommitceiling, " +
      "COALESCE(zssm_workstep_v.Ismaterialdisposed, 'N') AS Ismaterialdisposed, " +
      "zssm_workstep_v.Indirectcostplan, " +
      "zssm_workstep_v.Datecontract, " +
      "zssm_workstep_v.AD_Client_ID, " +
      "zssm_workstep_v.Returnmaterialtostock, " +
      "zssm_workstep_v.Percentdone, " +
      "COALESCE(zssm_workstep_v.Outsourcing, 'N') AS Outsourcing, " +
      "zssm_workstep_v.BeginTask, " +
      "zssm_workstep_v.Expenses, " +
      "zssm_workstep_v.Actualcost, " +
      "zssm_workstep_v.Unplanmaterial, " +
      "zssm_workstep_v.Invoicedamt, " +
      "COALESCE(zssm_workstep_v.Taskbegun, 'N') AS Taskbegun, " +
      "zssm_workstep_v.Getmaterialfromstock, " +
      "zssm_workstep_v.Committedamt, " +
      "zssm_workstep_v.Indirectcost, " +
      "zssm_workstep_v.Machinecost, " +
      "COALESCE(zssm_workstep_v.Istaskcancelled, 'N') AS Istaskcancelled, " +
      "zssm_workstep_v.Endtask, " +
      "COALESCE(zssm_workstep_v.Gotopurchasing, 'N') AS Gotopurchasing, " +
      "zssm_workstep_v.Materialcost, " +
      "zssm_workstep_v.Planmaterial, " +
      "zssm_workstep_v.Qtyleft, " +
      "zssm_workstep_v.Zssm_Workstep_V_ID, " +
      "zssm_workstep_v.Zssm_Productionplan_Task_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_workstep_v left join (select AD_Org_ID, Name from AD_Org) table1 on (zssm_workstep_v.AD_Org_ID = table1.AD_Org_ID) left join (select zssm_productionorder_v_id, Value, Name from zssm_productionorder_v) table2 on (zssm_workstep_v.zssm_productionorder_v_id = table2.zssm_productionorder_v_id) left join (select C_ProjectTask_ID, Name, C_Project_ID from C_ProjectTask) table3 on (zssm_workstep_v.C_ProjectTask_ID = table3.C_ProjectTask_ID) left join (select C_Project_ID, Value, Name from C_Project) table4 on (table3.C_Project_ID = table4.C_Project_ID) left join (select M_Product_ID, Value, Name from M_Product) table5 on (zssm_workstep_v.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table6 on (zssm_workstep_v.Receiving_Locator = table6.M_Locator_ID) left join (select M_Locator_ID, Value from M_Locator) table7 on (zssm_workstep_v.Issuing_Locator = table7.M_Locator_ID)" +
      "        WHERE 2=2 " +
      " AND zssm_workstep_v.iscomplete ='N'  and zssm_workstep_v.istaskcancelled='N' and zssm_workstep_v.taskbegun ='N' and zssm_workstep_v.zssm_productionorder_v_id is not null" +
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
        PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData = new PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData();
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.created = UtilSql.getValue(result, "created");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.updated = UtilSql.getValue(result, "updated");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.isactive = UtilSql.getValue(result, "isactive");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.name = UtilSql.getValue(result, "name");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.zssmProductionorderVId = UtilSql.getValue(result, "zssm_productionorder_v_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.zssmProductionorderVIdr = UtilSql.getValue(result, "zssm_productionorder_v_idr");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.ended = UtilSql.getDateValue(result, "ended", "dd-MM-yyyy");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.value = UtilSql.getValue(result, "value");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.seqno = UtilSql.getValue(result, "seqno");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.started = UtilSql.getDateValue(result, "started", "dd-MM-yyyy");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.description = UtilSql.getValue(result, "description");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.triggerreason = UtilSql.getValue(result, "triggerreason");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.qty = UtilSql.getValue(result, "qty");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.qtyproduced = UtilSql.getValue(result, "qtyproduced");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.assembly = UtilSql.getValue(result, "assembly");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.receivingLocator = UtilSql.getValue(result, "receiving_locator");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.receivingLocatorr = UtilSql.getValue(result, "receiving_locatorr");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.issuingLocator = UtilSql.getValue(result, "issuing_locator");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.issuingLocatorr = UtilSql.getValue(result, "issuing_locatorr");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.servcostplan = UtilSql.getValue(result, "servcostplan");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.machinecostplan = UtilSql.getValue(result, "machinecostplan");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.materialcostplan = UtilSql.getValue(result, "materialcostplan");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.plannedcost = UtilSql.getValue(result, "plannedcost");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.createbom = UtilSql.getValue(result, "createbom");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.cTaskId = UtilSql.getValue(result, "c_task_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.help = UtilSql.getValue(result, "help");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.servcost = UtilSql.getValue(result, "servcost");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.priceactual = UtilSql.getValue(result, "priceactual");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.canceltask = UtilSql.getValue(result, "canceltask");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.iscomplete = UtilSql.getValue(result, "iscomplete");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.percentrejects = UtilSql.getValue(result, "percentrejects");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.ismaterialdisposed = UtilSql.getValue(result, "ismaterialdisposed");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.indirectcostplan = UtilSql.getValue(result, "indirectcostplan");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.returnmaterialtostock = UtilSql.getValue(result, "returnmaterialtostock");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.percentdone = UtilSql.getValue(result, "percentdone");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.outsourcing = UtilSql.getValue(result, "outsourcing");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.begintask = UtilSql.getValue(result, "begintask");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.expenses = UtilSql.getValue(result, "expenses");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.actualcost = UtilSql.getValue(result, "actualcost");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.unplanmaterial = UtilSql.getValue(result, "unplanmaterial");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.taskbegun = UtilSql.getValue(result, "taskbegun");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.getmaterialfromstock = UtilSql.getValue(result, "getmaterialfromstock");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.committedamt = UtilSql.getValue(result, "committedamt");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.machinecost = UtilSql.getValue(result, "machinecost");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.istaskcancelled = UtilSql.getValue(result, "istaskcancelled");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.endtask = UtilSql.getValue(result, "endtask");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.gotopurchasing = UtilSql.getValue(result, "gotopurchasing");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.materialcost = UtilSql.getValue(result, "materialcost");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.planmaterial = UtilSql.getValue(result, "planmaterial");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.qtyleft = UtilSql.getValue(result, "qtyleft");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.zssmProductionplanTaskId = UtilSql.getValue(result, "zssm_productionplan_task_id");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.language = UtilSql.getValue(result, "language");
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.adUserClient = "";
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.adOrgClient = "";
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.createdby = "";
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.trBgcolor = "";
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.totalCount = "";
        objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData);
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
    PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] = new PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[vector.size()];
    vector.copyInto(objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData);
    return(objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData);
  }

/**
Create a registry
 */
  public static PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] set(String help, String expenses, String planmaterial, String machinecostplan, String endtask, String priceactual, String updatedby, String updatedbyr, String outsourcing, String unplanmaterial, String taskbegun, String triggerreason, String indirectcostplan, String canceltask, String createbom, String invoicedamt, String qty, String mProductId, String mProductIdr, String ismaterialdisposed, String startdate, String receivingLocator, String receivingLocatorr, String begintask, String machinecost, String zssmWorkstepVId, String iscomplete, String createdby, String createdbyr, String getmaterialfromstock, String iscommitceiling, String returnmaterialtostock, String schedulestatus, String datecontract, String cOrderlineId, String qtyproduced, String issuingLocator, String issuingLocatorr, String adClientId, String zssmProductionorderVId, String actualcost, String committedamt, String cTaskId, String servcost, String servcostplan, String ended, String assembly, String plannedcost, String seqno, String materialcostplan, String isactive, String materialcost, String started, String qtyleft, String percentdone, String value, String zssmProductionplanTaskId, String gotopurchasing, String description, String name, String percentrejects, String enddate, String cProjecttaskId, String istaskcancelled, String adOrgId, String indirectcost)    throws ServletException {
    PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[] = new PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[1];
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0] = new PlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData();
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].created = "";
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].createdbyr = createdbyr;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].updated = "";
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].updatedTimeStamp = "";
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].updatedby = updatedby;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].updatedbyr = updatedbyr;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].adOrgId = adOrgId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].adOrgIdr = "";
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].isactive = isactive;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].name = name;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].zssmProductionorderVId = zssmProductionorderVId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].zssmProductionorderVIdr = "";
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].ended = ended;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].cProjecttaskId = cProjecttaskId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].cProjecttaskIdr = "";
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].value = value;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].seqno = seqno;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].started = started;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].startdate = startdate;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].enddate = enddate;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].description = description;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].triggerreason = triggerreason;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].qty = qty;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].qtyproduced = qtyproduced;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].mProductId = mProductId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].mProductIdr = mProductIdr;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].assembly = assembly;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].receivingLocator = receivingLocator;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].receivingLocatorr = receivingLocatorr;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].issuingLocator = issuingLocator;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].issuingLocatorr = issuingLocatorr;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].servcostplan = servcostplan;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].machinecostplan = machinecostplan;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].materialcostplan = materialcostplan;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].plannedcost = plannedcost;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].createbom = createbom;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].cTaskId = cTaskId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].help = help;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].schedulestatus = schedulestatus;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].servcost = servcost;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].priceactual = priceactual;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].canceltask = canceltask;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].cOrderlineId = cOrderlineId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].iscomplete = iscomplete;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].percentrejects = percentrejects;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].iscommitceiling = iscommitceiling;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].ismaterialdisposed = ismaterialdisposed;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].indirectcostplan = indirectcostplan;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].datecontract = datecontract;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].adClientId = adClientId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].returnmaterialtostock = returnmaterialtostock;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].percentdone = percentdone;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].outsourcing = outsourcing;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].begintask = begintask;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].expenses = expenses;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].actualcost = actualcost;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].unplanmaterial = unplanmaterial;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].invoicedamt = invoicedamt;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].taskbegun = taskbegun;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].getmaterialfromstock = getmaterialfromstock;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].committedamt = committedamt;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].indirectcost = indirectcost;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].machinecost = machinecost;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].istaskcancelled = istaskcancelled;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].endtask = endtask;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].gotopurchasing = gotopurchasing;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].materialcost = materialcost;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].planmaterial = planmaterial;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].qtyleft = qtyleft;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].zssmWorkstepVId = zssmWorkstepVId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].zssmProductionplanTaskId = zssmProductionplanTaskId;
    objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData[0].language = "";
    return objectPlannedWorkstepsE3F3D04CCE7F4E7F95677A2298A0A6EBData;
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
      "        SET AD_Org_ID = (?) , IsActive = (?) , Name = (?) , zssm_productionorder_v_id = (?) , Ended = TO_DATE(?) , C_ProjectTask_ID = (?) , Value = (?) , SeqNo = TO_NUMBER(?) , Started = TO_DATE(?) , StartDate = TO_DATE(?) , Enddate = TO_DATE(?) , Description = (?) , Triggerreason = (?) , Qty = TO_NUMBER(?) , Qtyproduced = TO_NUMBER(?) , M_Product_ID = (?) , Assembly = (?) , Receiving_Locator = (?) , Issuing_Locator = (?) , Servcostplan = TO_NUMBER(?) , Machinecostplan = TO_NUMBER(?) , Materialcostplan = TO_NUMBER(?) , Plannedcost = TO_NUMBER(?) , Createbom = (?) , C_Task_ID = (?) , Help = (?) , Schedulestatus = (?) , Servcost = TO_NUMBER(?) , PriceActual = TO_NUMBER(?) , Canceltask = (?) , C_Orderline_ID = (?) , Iscomplete = (?) , Percentrejects = TO_NUMBER(?) , Iscommitceiling = (?) , Ismaterialdisposed = (?) , Indirectcostplan = TO_NUMBER(?) , Datecontract = TO_DATE(?) , AD_Client_ID = (?) , Returnmaterialtostock = (?) , Percentdone = TO_NUMBER(?) , Outsourcing = (?) , BeginTask = (?) , Expenses = TO_NUMBER(?) , Actualcost = TO_NUMBER(?) , Unplanmaterial = (?) , Invoicedamt = TO_NUMBER(?) , Taskbegun = (?) , Getmaterialfromstock = (?) , Committedamt = TO_NUMBER(?) , Indirectcost = TO_NUMBER(?) , Machinecost = TO_NUMBER(?) , Istaskcancelled = (?) , Endtask = (?) , Gotopurchasing = (?) , Materialcost = TO_NUMBER(?) , Planmaterial = (?) , Qtyleft = TO_NUMBER(?) , Zssm_Workstep_V_ID = (?) , Zssm_Productionplan_Task_ID = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, canceltask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentrejects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismaterialdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnmaterialtostock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourcing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, begintask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskbegun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, getmaterialfromstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskcancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gotopurchasing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyleft);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
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
      "        (AD_Org_ID, IsActive, Name, zssm_productionorder_v_id, Ended, C_ProjectTask_ID, Value, SeqNo, Started, StartDate, Enddate, Description, Triggerreason, Qty, Qtyproduced, M_Product_ID, Assembly, Receiving_Locator, Issuing_Locator, Servcostplan, Machinecostplan, Materialcostplan, Plannedcost, Createbom, C_Task_ID, Help, Schedulestatus, Servcost, PriceActual, Canceltask, C_Orderline_ID, Iscomplete, Percentrejects, Iscommitceiling, Ismaterialdisposed, Indirectcostplan, Datecontract, AD_Client_ID, Returnmaterialtostock, Percentdone, Outsourcing, BeginTask, Expenses, Actualcost, Unplanmaterial, Invoicedamt, Taskbegun, Getmaterialfromstock, Committedamt, Indirectcost, Machinecost, Istaskcancelled, Endtask, Gotopurchasing, Materialcost, Planmaterial, Qtyleft, Zssm_Workstep_V_ID, Zssm_Productionplan_Task_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, canceltask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentrejects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismaterialdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnmaterialtostock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourcing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, begintask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskbegun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, getmaterialfromstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskcancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gotopurchasing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyleft);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
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

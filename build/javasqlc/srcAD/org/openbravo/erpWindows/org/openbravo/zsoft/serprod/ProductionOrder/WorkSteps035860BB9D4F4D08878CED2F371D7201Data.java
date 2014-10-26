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
class WorkSteps035860BB9D4F4D08878CED2F371D7201Data implements FieldProvider {
static Logger log4j = Logger.getLogger(WorkSteps035860BB9D4F4D08878CED2F371D7201Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssmProductionorderVId;
  public String zssmProductionorderVIdr;
  public String seqno;
  public String value;
  public String name;
  public String description;
  public String triggerreason;
  public String qty;
  public String qtyproduced;
  public String weightproportion;
  public String assembly;
  public String mProductId;
  public String mProductIdr;
  public String forcematerialscan;
  public String startonlywithcompletematerial;
  public String startdate;
  public String enddate;
  public String receivingLocator;
  public String receivingLocatorr;
  public String issuingLocator;
  public String issuingLocatorr;
  public String timeperpiece;
  public String setuptime;
  public String timeplanned;
  public String servcostplan;
  public String machinecostplan;
  public String materialcostplan;
  public String plannedcost;
  public String taskbegun;
  public String started;
  public String iscomplete;
  public String ended;
  public String begintask;
  public String endtask;
  public String createbom;
  public String invoicedamt;
  public String isactive;
  public String zssmPrjProjectcategory;
  public String outsourcing;
  public String canceltask;
  public String committedamt;
  public String gotopurchasing;
  public String qtyleft;
  public String ismaterialdisposed;
  public String zssmProductionplanTaskId;
  public String isautotriggered;
  public String returnmaterialtostock;
  public String percentrejects;
  public String unplanmaterial;
  public String expenses;
  public String planmaterial;
  public String percentdone;
  public String priceactual;
  public String zssmWorkstepVId;
  public String adClientId;
  public String zssmPrjName;
  public String materialcost;
  public String cOrderlineId;
  public String cProjecttaskId;
  public String help;
  public String schedulestatus;
  public String datecontract;
  public String getmaterialfromstock;
  public String machinecost;
  public String istaskcancelled;
  public String adOrgId;
  public String servcost;
  public String iscommitceiling;
  public String indirectcostplan;
  public String indirectcost;
  public String actualcost;
  public String cTaskId;
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
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_id") || fieldName.equals("zssmProductionorderVId"))
      return zssmProductionorderVId;
    else if (fieldName.equalsIgnoreCase("zssm_productionorder_v_idr") || fieldName.equals("zssmProductionorderVIdr"))
      return zssmProductionorderVIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("triggerreason"))
      return triggerreason;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("qtyproduced"))
      return qtyproduced;
    else if (fieldName.equalsIgnoreCase("weightproportion"))
      return weightproportion;
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
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("receiving_locator") || fieldName.equals("receivingLocator"))
      return receivingLocator;
    else if (fieldName.equalsIgnoreCase("receiving_locatorr") || fieldName.equals("receivingLocatorr"))
      return receivingLocatorr;
    else if (fieldName.equalsIgnoreCase("issuing_locator") || fieldName.equals("issuingLocator"))
      return issuingLocator;
    else if (fieldName.equalsIgnoreCase("issuing_locatorr") || fieldName.equals("issuingLocatorr"))
      return issuingLocatorr;
    else if (fieldName.equalsIgnoreCase("timeperpiece"))
      return timeperpiece;
    else if (fieldName.equalsIgnoreCase("setuptime"))
      return setuptime;
    else if (fieldName.equalsIgnoreCase("timeplanned"))
      return timeplanned;
    else if (fieldName.equalsIgnoreCase("servcostplan"))
      return servcostplan;
    else if (fieldName.equalsIgnoreCase("machinecostplan"))
      return machinecostplan;
    else if (fieldName.equalsIgnoreCase("materialcostplan"))
      return materialcostplan;
    else if (fieldName.equalsIgnoreCase("plannedcost"))
      return plannedcost;
    else if (fieldName.equalsIgnoreCase("taskbegun"))
      return taskbegun;
    else if (fieldName.equalsIgnoreCase("started"))
      return started;
    else if (fieldName.equalsIgnoreCase("iscomplete"))
      return iscomplete;
    else if (fieldName.equalsIgnoreCase("ended"))
      return ended;
    else if (fieldName.equalsIgnoreCase("begintask"))
      return begintask;
    else if (fieldName.equalsIgnoreCase("endtask"))
      return endtask;
    else if (fieldName.equalsIgnoreCase("createbom"))
      return createbom;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zssm_prj_projectcategory") || fieldName.equals("zssmPrjProjectcategory"))
      return zssmPrjProjectcategory;
    else if (fieldName.equalsIgnoreCase("outsourcing"))
      return outsourcing;
    else if (fieldName.equalsIgnoreCase("canceltask"))
      return canceltask;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("gotopurchasing"))
      return gotopurchasing;
    else if (fieldName.equalsIgnoreCase("qtyleft"))
      return qtyleft;
    else if (fieldName.equalsIgnoreCase("ismaterialdisposed"))
      return ismaterialdisposed;
    else if (fieldName.equalsIgnoreCase("zssm_productionplan_task_id") || fieldName.equals("zssmProductionplanTaskId"))
      return zssmProductionplanTaskId;
    else if (fieldName.equalsIgnoreCase("isautotriggered"))
      return isautotriggered;
    else if (fieldName.equalsIgnoreCase("returnmaterialtostock"))
      return returnmaterialtostock;
    else if (fieldName.equalsIgnoreCase("percentrejects"))
      return percentrejects;
    else if (fieldName.equalsIgnoreCase("unplanmaterial"))
      return unplanmaterial;
    else if (fieldName.equalsIgnoreCase("expenses"))
      return expenses;
    else if (fieldName.equalsIgnoreCase("planmaterial"))
      return planmaterial;
    else if (fieldName.equalsIgnoreCase("percentdone"))
      return percentdone;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("zssm_workstep_v_id") || fieldName.equals("zssmWorkstepVId"))
      return zssmWorkstepVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("zssm_prj_name") || fieldName.equals("zssmPrjName"))
      return zssmPrjName;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("getmaterialfromstock"))
      return getmaterialfromstock;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("istaskcancelled"))
      return istaskcancelled;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("indirectcostplan"))
      return indirectcostplan;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("actualcost"))
      return actualcost;
    else if (fieldName.equalsIgnoreCase("c_task_id") || fieldName.equals("cTaskId"))
      return cTaskId;
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
  public static WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionorderVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zssmProductionorderVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zssmProductionorderVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssm_workstep_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstep_v.CreatedBy) as CreatedByR, " +
      "        to_char(zssm_workstep_v.Updated, ?) as updated, " +
      "        to_char(zssm_workstep_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssm_workstep_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssm_workstep_v.UpdatedBy) as UpdatedByR," +
      "        zssm_workstep_v.zssm_productionorder_v_id, " +
      "(CASE WHEN zssm_workstep_v.zssm_productionorder_v_id IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS zssm_productionorder_v_idR, " +
      "zssm_workstep_v.SeqNo, " +
      "zssm_workstep_v.Value, " +
      "zssm_workstep_v.Name, " +
      "zssm_workstep_v.Description, " +
      "zssm_workstep_v.Triggerreason, " +
      "zssm_workstep_v.Qty, " +
      "zssm_workstep_v.Qtyproduced, " +
      "zssm_workstep_v.Weightproportion, " +
      "COALESCE(zssm_workstep_v.Assembly, 'N') AS Assembly, " +
      "zssm_workstep_v.M_Product_ID, " +
      "(CASE WHEN zssm_workstep_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "COALESCE(zssm_workstep_v.Forcematerialscan, 'N') AS Forcematerialscan, " +
      "COALESCE(zssm_workstep_v.Startonlywithcompletematerial, 'N') AS Startonlywithcompletematerial, " +
      "zssm_workstep_v.StartDate, " +
      "zssm_workstep_v.Enddate, " +
      "zssm_workstep_v.Receiving_Locator, " +
      "(CASE WHEN zssm_workstep_v.Receiving_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'') ) END) AS Receiving_LocatorR, " +
      "zssm_workstep_v.Issuing_Locator, " +
      "(CASE WHEN zssm_workstep_v.Issuing_Locator IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'') ) END) AS Issuing_LocatorR, " +
      "zssm_workstep_v.Timeperpiece, " +
      "zssm_workstep_v.Setuptime, " +
      "zssm_workstep_v.Timeplanned, " +
      "zssm_workstep_v.Servcostplan, " +
      "zssm_workstep_v.Machinecostplan, " +
      "zssm_workstep_v.Materialcostplan, " +
      "zssm_workstep_v.Plannedcost, " +
      "COALESCE(zssm_workstep_v.Taskbegun, 'N') AS Taskbegun, " +
      "zssm_workstep_v.Started, " +
      "COALESCE(zssm_workstep_v.Iscomplete, 'N') AS Iscomplete, " +
      "zssm_workstep_v.Ended, " +
      "zssm_workstep_v.BeginTask, " +
      "zssm_workstep_v.Endtask, " +
      "zssm_workstep_v.Createbom, " +
      "zssm_workstep_v.Invoicedamt, " +
      "COALESCE(zssm_workstep_v.IsActive, 'N') AS IsActive, " +
      "zssm_workstep_v.Zssm_Prj_Projectcategory, " +
      "COALESCE(zssm_workstep_v.Outsourcing, 'N') AS Outsourcing, " +
      "zssm_workstep_v.Canceltask, " +
      "zssm_workstep_v.Committedamt, " +
      "COALESCE(zssm_workstep_v.Gotopurchasing, 'N') AS Gotopurchasing, " +
      "zssm_workstep_v.Qtyleft, " +
      "COALESCE(zssm_workstep_v.Ismaterialdisposed, 'N') AS Ismaterialdisposed, " +
      "zssm_workstep_v.Zssm_Productionplan_Task_ID, " +
      "COALESCE(zssm_workstep_v.Isautotriggered, 'N') AS Isautotriggered, " +
      "zssm_workstep_v.Returnmaterialtostock, " +
      "zssm_workstep_v.Percentrejects, " +
      "zssm_workstep_v.Unplanmaterial, " +
      "zssm_workstep_v.Expenses, " +
      "zssm_workstep_v.Planmaterial, " +
      "zssm_workstep_v.Percentdone, " +
      "zssm_workstep_v.PriceActual, " +
      "zssm_workstep_v.Zssm_Workstep_V_ID, " +
      "zssm_workstep_v.AD_Client_ID, " +
      "zssm_workstep_v.Zssm_Prj_Name, " +
      "zssm_workstep_v.Materialcost, " +
      "zssm_workstep_v.C_Orderline_ID, " +
      "zssm_workstep_v.C_ProjectTask_ID, " +
      "zssm_workstep_v.Help, " +
      "zssm_workstep_v.Schedulestatus, " +
      "zssm_workstep_v.Datecontract, " +
      "zssm_workstep_v.Getmaterialfromstock, " +
      "zssm_workstep_v.Machinecost, " +
      "COALESCE(zssm_workstep_v.Istaskcancelled, 'N') AS Istaskcancelled, " +
      "zssm_workstep_v.AD_Org_ID, " +
      "zssm_workstep_v.Servcost, " +
      "COALESCE(zssm_workstep_v.Iscommitceiling, 'N') AS Iscommitceiling, " +
      "zssm_workstep_v.Indirectcostplan, " +
      "zssm_workstep_v.Indirectcost, " +
      "zssm_workstep_v.Actualcost, " +
      "zssm_workstep_v.C_Task_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssm_workstep_v left join (select zssm_productionorder_v_id, Value, Name from zssm_productionorder_v) table1 on (zssm_workstep_v.zssm_productionorder_v_id = table1.zssm_productionorder_v_id) left join (select M_Product_ID, Value, Name from M_Product) table2 on (zssm_workstep_v.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table3 on (zssm_workstep_v.Receiving_Locator = table3.M_Locator_ID) left join (select M_Locator_ID, Value from M_Locator) table4 on (zssm_workstep_v.Issuing_Locator = table4.M_Locator_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zssmProductionorderVId==null || zssmProductionorderVId.equals(""))?"":"  AND zssm_workstep_v.zssm_productionorder_v_id = ?  ");
    strSql = strSql + 
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
      if (zssmProductionorderVId != null && !(zssmProductionorderVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
        WorkSteps035860BB9D4F4D08878CED2F371D7201Data objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data = new WorkSteps035860BB9D4F4D08878CED2F371D7201Data();
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.created = UtilSql.getValue(result, "created");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.updated = UtilSql.getValue(result, "updated");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.zssmProductionorderVId = UtilSql.getValue(result, "zssm_productionorder_v_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.zssmProductionorderVIdr = UtilSql.getValue(result, "zssm_productionorder_v_idr");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.seqno = UtilSql.getValue(result, "seqno");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.value = UtilSql.getValue(result, "value");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.name = UtilSql.getValue(result, "name");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.description = UtilSql.getValue(result, "description");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.triggerreason = UtilSql.getValue(result, "triggerreason");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.qty = UtilSql.getValue(result, "qty");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.qtyproduced = UtilSql.getValue(result, "qtyproduced");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.weightproportion = UtilSql.getValue(result, "weightproportion");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.assembly = UtilSql.getValue(result, "assembly");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.forcematerialscan = UtilSql.getValue(result, "forcematerialscan");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.startonlywithcompletematerial = UtilSql.getValue(result, "startonlywithcompletematerial");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.receivingLocator = UtilSql.getValue(result, "receiving_locator");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.receivingLocatorr = UtilSql.getValue(result, "receiving_locatorr");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.issuingLocator = UtilSql.getValue(result, "issuing_locator");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.issuingLocatorr = UtilSql.getValue(result, "issuing_locatorr");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.timeperpiece = UtilSql.getValue(result, "timeperpiece");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.setuptime = UtilSql.getValue(result, "setuptime");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.timeplanned = UtilSql.getValue(result, "timeplanned");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.servcostplan = UtilSql.getValue(result, "servcostplan");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.machinecostplan = UtilSql.getValue(result, "machinecostplan");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.materialcostplan = UtilSql.getValue(result, "materialcostplan");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.plannedcost = UtilSql.getValue(result, "plannedcost");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.taskbegun = UtilSql.getValue(result, "taskbegun");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.started = UtilSql.getDateValue(result, "started", "dd-MM-yyyy");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.iscomplete = UtilSql.getValue(result, "iscomplete");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.ended = UtilSql.getDateValue(result, "ended", "dd-MM-yyyy");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.begintask = UtilSql.getValue(result, "begintask");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.endtask = UtilSql.getValue(result, "endtask");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.createbom = UtilSql.getValue(result, "createbom");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.isactive = UtilSql.getValue(result, "isactive");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.zssmPrjProjectcategory = UtilSql.getValue(result, "zssm_prj_projectcategory");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.outsourcing = UtilSql.getValue(result, "outsourcing");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.canceltask = UtilSql.getValue(result, "canceltask");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.committedamt = UtilSql.getValue(result, "committedamt");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.gotopurchasing = UtilSql.getValue(result, "gotopurchasing");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.qtyleft = UtilSql.getValue(result, "qtyleft");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.ismaterialdisposed = UtilSql.getValue(result, "ismaterialdisposed");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.zssmProductionplanTaskId = UtilSql.getValue(result, "zssm_productionplan_task_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.isautotriggered = UtilSql.getValue(result, "isautotriggered");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.returnmaterialtostock = UtilSql.getValue(result, "returnmaterialtostock");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.percentrejects = UtilSql.getValue(result, "percentrejects");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.unplanmaterial = UtilSql.getValue(result, "unplanmaterial");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.expenses = UtilSql.getValue(result, "expenses");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.planmaterial = UtilSql.getValue(result, "planmaterial");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.percentdone = UtilSql.getValue(result, "percentdone");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.priceactual = UtilSql.getValue(result, "priceactual");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.zssmWorkstepVId = UtilSql.getValue(result, "zssm_workstep_v_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.zssmPrjName = UtilSql.getValue(result, "zssm_prj_name");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.materialcost = UtilSql.getValue(result, "materialcost");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.help = UtilSql.getValue(result, "help");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.getmaterialfromstock = UtilSql.getValue(result, "getmaterialfromstock");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.machinecost = UtilSql.getValue(result, "machinecost");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.istaskcancelled = UtilSql.getValue(result, "istaskcancelled");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.servcost = UtilSql.getValue(result, "servcost");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.indirectcostplan = UtilSql.getValue(result, "indirectcostplan");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.actualcost = UtilSql.getValue(result, "actualcost");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.cTaskId = UtilSql.getValue(result, "c_task_id");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.language = UtilSql.getValue(result, "language");
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.adUserClient = "";
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.adOrgClient = "";
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.createdby = "";
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.trBgcolor = "";
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.totalCount = "";
        objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data);
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
    WorkSteps035860BB9D4F4D08878CED2F371D7201Data objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[] = new WorkSteps035860BB9D4F4D08878CED2F371D7201Data[vector.size()];
    vector.copyInto(objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data);
    return(objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data);
  }

/**
Create a registry
 */
  public static WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] set(String zssmProductionorderVId, String weightproportion, String priceactual, String updatedby, String updatedbyr, String cProjecttaskId, String outsourcing, String unplanmaterial, String adOrgId, String zssmPrjName, String triggerreason, String canceltask, String timeplanned, String mProductId, String mProductIdr, String ismaterialdisposed, String startdate, String createdby, String createdbyr, String returnmaterialtostock, String schedulestatus, String issuingLocator, String issuingLocatorr, String datecontract, String qtyproduced, String iscomplete, String cTaskId, String servcostplan, String assembly, String startonlywithcompletematerial, String materialcostplan, String qtyleft, String percentdone, String value, String percentrejects, String gotopurchasing, String taskbegun, String help, String setuptime, String expenses, String planmaterial, String machinecostplan, String isautotriggered, String forcematerialscan, String timeperpiece, String indirectcostplan, String createbom, String name, String invoicedamt, String qty, String receivingLocator, String receivingLocatorr, String zssmWorkstepVId, String machinecost, String zssmPrjProjectcategory, String getmaterialfromstock, String iscommitceiling, String ended, String cOrderlineId, String adClientId, String begintask, String committedamt, String actualcost, String servcost, String plannedcost, String seqno, String materialcost, String isactive, String endtask, String started, String zssmProductionplanTaskId, String description, String enddate, String istaskcancelled, String indirectcost)    throws ServletException {
    WorkSteps035860BB9D4F4D08878CED2F371D7201Data objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[] = new WorkSteps035860BB9D4F4D08878CED2F371D7201Data[1];
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0] = new WorkSteps035860BB9D4F4D08878CED2F371D7201Data();
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].created = "";
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].createdbyr = createdbyr;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].updated = "";
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].updatedTimeStamp = "";
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].updatedby = updatedby;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].updatedbyr = updatedbyr;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].zssmProductionorderVId = zssmProductionorderVId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].zssmProductionorderVIdr = "";
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].seqno = seqno;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].value = value;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].name = name;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].description = description;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].triggerreason = triggerreason;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].qty = qty;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].qtyproduced = qtyproduced;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].weightproportion = weightproportion;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].assembly = assembly;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].mProductId = mProductId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].mProductIdr = mProductIdr;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].forcematerialscan = forcematerialscan;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].startonlywithcompletematerial = startonlywithcompletematerial;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].startdate = startdate;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].enddate = enddate;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].receivingLocator = receivingLocator;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].receivingLocatorr = receivingLocatorr;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].issuingLocator = issuingLocator;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].issuingLocatorr = issuingLocatorr;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].timeperpiece = timeperpiece;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].setuptime = setuptime;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].timeplanned = timeplanned;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].servcostplan = servcostplan;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].machinecostplan = machinecostplan;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].materialcostplan = materialcostplan;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].plannedcost = plannedcost;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].taskbegun = taskbegun;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].started = started;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].iscomplete = iscomplete;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].ended = ended;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].begintask = begintask;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].endtask = endtask;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].createbom = createbom;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].invoicedamt = invoicedamt;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].isactive = isactive;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].zssmPrjProjectcategory = zssmPrjProjectcategory;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].outsourcing = outsourcing;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].canceltask = canceltask;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].committedamt = committedamt;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].gotopurchasing = gotopurchasing;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].qtyleft = qtyleft;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].ismaterialdisposed = ismaterialdisposed;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].zssmProductionplanTaskId = zssmProductionplanTaskId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].isautotriggered = isautotriggered;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].returnmaterialtostock = returnmaterialtostock;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].percentrejects = percentrejects;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].unplanmaterial = unplanmaterial;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].expenses = expenses;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].planmaterial = planmaterial;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].percentdone = percentdone;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].priceactual = priceactual;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].zssmWorkstepVId = zssmWorkstepVId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].adClientId = adClientId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].zssmPrjName = zssmPrjName;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].materialcost = materialcost;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].cOrderlineId = cOrderlineId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].cProjecttaskId = cProjecttaskId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].help = help;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].schedulestatus = schedulestatus;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].datecontract = datecontract;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].getmaterialfromstock = getmaterialfromstock;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].machinecost = machinecost;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].istaskcancelled = istaskcancelled;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].adOrgId = adOrgId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].servcost = servcost;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].iscommitceiling = iscommitceiling;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].indirectcostplan = indirectcostplan;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].indirectcost = indirectcost;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].actualcost = actualcost;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].cTaskId = cTaskId;
    objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data[0].language = "";
    return objectWorkSteps035860BB9D4F4D08878CED2F371D7201Data;
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
  public static String selectDefBF72293C90A14B129863C0F861752AE1_2(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef303E0FBA8DBC4B368E5FF9BACE658878_3(ConnectionProvider connectionProvider, String Issuing_LocatorR)    throws ServletException {
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
  public static String selectDef16D7CBA97CC64B5DBE296A6F9B754BD1_4(ConnectionProvider connectionProvider, String Receiving_LocatorR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssm_workstep_v.zssm_productionorder_v_id AS NAME" +
      "        FROM zssm_workstep_v" +
      "        WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionorder_v left join (select zssm_productionorder_v_id, Value, Name from zssm_productionorder_v) table1 on (zssm_productionorder_v.zssm_productionorder_v_id = table1.zssm_productionorder_v_id) WHERE zssm_productionorder_v.zssm_productionorder_v_id = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zssm_productionorder_v left join (select zssm_productionorder_v_id, Value, Name from zssm_productionorder_v) table1 on (zssm_productionorder_v.zssm_productionorder_v_id = table1.zssm_productionorder_v_id) WHERE zssm_productionorder_v.zssm_productionorder_v_id = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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
      "        SET zssm_productionorder_v_id = (?) , SeqNo = TO_NUMBER(?) , Value = (?) , Name = (?) , Description = (?) , Triggerreason = (?) , Qty = TO_NUMBER(?) , Qtyproduced = TO_NUMBER(?) , Weightproportion = TO_NUMBER(?) , Assembly = (?) , M_Product_ID = (?) , Forcematerialscan = (?) , Startonlywithcompletematerial = (?) , StartDate = TO_DATE(?) , Enddate = TO_DATE(?) , Receiving_Locator = (?) , Issuing_Locator = (?) , Timeperpiece = TO_NUMBER(?) , Setuptime = TO_NUMBER(?) , Timeplanned = TO_NUMBER(?) , Servcostplan = TO_NUMBER(?) , Machinecostplan = TO_NUMBER(?) , Materialcostplan = TO_NUMBER(?) , Plannedcost = TO_NUMBER(?) , Taskbegun = (?) , Started = TO_DATE(?) , Iscomplete = (?) , Ended = TO_DATE(?) , BeginTask = (?) , Endtask = (?) , Createbom = (?) , Invoicedamt = TO_NUMBER(?) , IsActive = (?) , Zssm_Prj_Projectcategory = (?) , Outsourcing = (?) , Canceltask = (?) , Committedamt = TO_NUMBER(?) , Gotopurchasing = (?) , Qtyleft = TO_NUMBER(?) , Ismaterialdisposed = (?) , Zssm_Productionplan_Task_ID = (?) , Isautotriggered = (?) , Returnmaterialtostock = (?) , Percentrejects = TO_NUMBER(?) , Unplanmaterial = (?) , Expenses = TO_NUMBER(?) , Planmaterial = (?) , Percentdone = TO_NUMBER(?) , PriceActual = TO_NUMBER(?) , Zssm_Workstep_V_ID = (?) , AD_Client_ID = (?) , Zssm_Prj_Name = (?) , Materialcost = TO_NUMBER(?) , C_Orderline_ID = (?) , C_ProjectTask_ID = (?) , Help = (?) , Schedulestatus = (?) , Datecontract = TO_DATE(?) , Getmaterialfromstock = (?) , Machinecost = TO_NUMBER(?) , Istaskcancelled = (?) , AD_Org_ID = (?) , Servcost = TO_NUMBER(?) , Iscommitceiling = (?) , Indirectcostplan = TO_NUMBER(?) , Indirectcost = TO_NUMBER(?) , Actualcost = TO_NUMBER(?) , C_Task_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ? " +
      "                 AND zssm_workstep_v.zssm_productionorder_v_id = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggerreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyproduced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightproportion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assembly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, forcematerialscan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startonlywithcompletematerial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeperpiece);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setuptime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskbegun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, started);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ended);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, begintask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmPrjProjectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourcing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, canceltask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gotopurchasing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyleft);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismaterialdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautotriggered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnmaterialtostock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentrejects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmPrjName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, getmaterialfromstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskcancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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
      "        (zssm_productionorder_v_id, SeqNo, Value, Name, Description, Triggerreason, Qty, Qtyproduced, Weightproportion, Assembly, M_Product_ID, Forcematerialscan, Startonlywithcompletematerial, StartDate, Enddate, Receiving_Locator, Issuing_Locator, Timeperpiece, Setuptime, Timeplanned, Servcostplan, Machinecostplan, Materialcostplan, Plannedcost, Taskbegun, Started, Iscomplete, Ended, BeginTask, Endtask, Createbom, Invoicedamt, IsActive, Zssm_Prj_Projectcategory, Outsourcing, Canceltask, Committedamt, Gotopurchasing, Qtyleft, Ismaterialdisposed, Zssm_Productionplan_Task_ID, Isautotriggered, Returnmaterialtostock, Percentrejects, Unplanmaterial, Expenses, Planmaterial, Percentdone, PriceActual, Zssm_Workstep_V_ID, AD_Client_ID, Zssm_Prj_Name, Materialcost, C_Orderline_ID, C_ProjectTask_ID, Help, Schedulestatus, Datecontract, Getmaterialfromstock, Machinecost, Istaskcancelled, AD_Org_ID, Servcost, Iscommitceiling, Indirectcostplan, Indirectcost, Actualcost, C_Task_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggerreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyproduced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightproportion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assembly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, forcematerialscan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startonlywithcompletematerial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, receivingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issuingLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeperpiece);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setuptime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timeplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskbegun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, started);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ended);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, begintask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmPrjProjectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourcing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, canceltask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gotopurchasing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyleft);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismaterialdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionplanTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isautotriggered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnmaterialtostock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentrejects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmWorkstepVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmPrjName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, getmaterialfromstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskcancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaskId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zssmProductionorderVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_workstep_v" +
      "        WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ? " +
      "                 AND zssm_workstep_v.zssm_productionorder_v_id = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zssmProductionorderVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssm_workstep_v" +
      "        WHERE zssm_workstep_v.Zssm_Workstep_V_ID = ? " +
      "                 AND zssm_workstep_v.zssm_productionorder_v_id = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssmProductionorderVId);

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

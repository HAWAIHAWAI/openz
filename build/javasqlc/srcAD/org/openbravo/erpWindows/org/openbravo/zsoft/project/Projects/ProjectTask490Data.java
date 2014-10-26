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
class ProjectTask490Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjectTask490Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjectId;
  public String cProjectIdr;
  public String seqno;
  public String isactive;
  public String adUserId;
  public String adUserIdr;
  public String outsourcing;
  public String name;
  public String description;
  public String help;
  public String cColorId;
  public String cColorIdr;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String startdate;
  public String enddate;
  public String feedbackfinished;
  public String taskbegun;
  public String iscomplete;
  public String ismaterialdisposed;
  public String istaskcancelled;
  public String expensesplan;
  public String expenses;
  public String externalserviceplan;
  public String externalservice;
  public String materialcostplan;
  public String materialcost;
  public String servcostplan;
  public String servcost;
  public String machinecostplan;
  public String machinecost;
  public String indirectcostplan;
  public String indirectcost;
  public String committedamt;
  public String invoicedamt;
  public String plannedcost;
  public String actualcost;
  public String percentdone;
  public String schedulestatus;
  public String schedulestatusr;
  public String preplanmaterial;
  public String copyptask;
  public String createbom;
  public String planmaterial;
  public String unplanmaterial;
  public String getmaterialfromstock;
  public String returnmaterialtostock;
  public String begintask;
  public String endtask;
  public String canceltask;
  public String adOrgId;
  public String cProjecttaskId;
  public String adClientId;
  public String datecontract;
  public String gotopurchasing;
  public String cTaskId;
  public String priceactual;
  public String iscommitceiling;
  public String cProjectphaseId;
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
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("outsourcing"))
      return outsourcing;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("c_color_id") || fieldName.equals("cColorId"))
      return cColorId;
    else if (fieldName.equalsIgnoreCase("c_color_idr") || fieldName.equals("cColorIdr"))
      return cColorIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("feedbackfinished"))
      return feedbackfinished;
    else if (fieldName.equalsIgnoreCase("taskbegun"))
      return taskbegun;
    else if (fieldName.equalsIgnoreCase("iscomplete"))
      return iscomplete;
    else if (fieldName.equalsIgnoreCase("ismaterialdisposed"))
      return ismaterialdisposed;
    else if (fieldName.equalsIgnoreCase("istaskcancelled"))
      return istaskcancelled;
    else if (fieldName.equalsIgnoreCase("expensesplan"))
      return expensesplan;
    else if (fieldName.equalsIgnoreCase("expenses"))
      return expenses;
    else if (fieldName.equalsIgnoreCase("externalserviceplan"))
      return externalserviceplan;
    else if (fieldName.equalsIgnoreCase("externalservice"))
      return externalservice;
    else if (fieldName.equalsIgnoreCase("materialcostplan"))
      return materialcostplan;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("servcostplan"))
      return servcostplan;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("machinecostplan"))
      return machinecostplan;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("indirectcostplan"))
      return indirectcostplan;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("plannedcost"))
      return plannedcost;
    else if (fieldName.equalsIgnoreCase("actualcost"))
      return actualcost;
    else if (fieldName.equalsIgnoreCase("percentdone"))
      return percentdone;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("schedulestatusr"))
      return schedulestatusr;
    else if (fieldName.equalsIgnoreCase("preplanmaterial"))
      return preplanmaterial;
    else if (fieldName.equalsIgnoreCase("copyptask"))
      return copyptask;
    else if (fieldName.equalsIgnoreCase("createbom"))
      return createbom;
    else if (fieldName.equalsIgnoreCase("planmaterial"))
      return planmaterial;
    else if (fieldName.equalsIgnoreCase("unplanmaterial"))
      return unplanmaterial;
    else if (fieldName.equalsIgnoreCase("getmaterialfromstock"))
      return getmaterialfromstock;
    else if (fieldName.equalsIgnoreCase("returnmaterialtostock"))
      return returnmaterialtostock;
    else if (fieldName.equalsIgnoreCase("begintask"))
      return begintask;
    else if (fieldName.equalsIgnoreCase("endtask"))
      return endtask;
    else if (fieldName.equalsIgnoreCase("canceltask"))
      return canceltask;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("gotopurchasing"))
      return gotopurchasing;
    else if (fieldName.equalsIgnoreCase("c_task_id") || fieldName.equals("cTaskId"))
      return cTaskId;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("iscommitceiling"))
      return iscommitceiling;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
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
  public static ProjectTask490Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjectId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProjectTask490Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_ProjectTask.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ProjectTask.CreatedBy) as CreatedByR, " +
      "        to_char(C_ProjectTask.Updated, ?) as updated, " +
      "        to_char(C_ProjectTask.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_ProjectTask.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ProjectTask.UpdatedBy) as UpdatedByR," +
      "        C_ProjectTask.C_Project_ID, " +
      "(CASE WHEN C_ProjectTask.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_ProjectTask.SeqNo, " +
      "COALESCE(C_ProjectTask.IsActive, 'N') AS IsActive, " +
      "C_ProjectTask.AD_User_ID, " +
      "(CASE WHEN C_ProjectTask.AD_User_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "COALESCE(C_ProjectTask.Outsourcing, 'N') AS Outsourcing, " +
      "C_ProjectTask.Name, " +
      "C_ProjectTask.Description, " +
      "C_ProjectTask.Help, " +
      "C_ProjectTask.C_Color_ID, " +
      "(CASE WHEN C_ProjectTask.C_Color_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Color_IDR, " +
      "C_ProjectTask.M_Product_ID, " +
      "(CASE WHEN C_ProjectTask.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "C_ProjectTask.Qty, " +
      "C_ProjectTask.StartDate, " +
      "C_ProjectTask.Enddate, " +
      "COALESCE(C_ProjectTask.Feedbackfinished, 'N') AS Feedbackfinished, " +
      "COALESCE(C_ProjectTask.Taskbegun, 'N') AS Taskbegun, " +
      "COALESCE(C_ProjectTask.Iscomplete, 'N') AS Iscomplete, " +
      "COALESCE(C_ProjectTask.Ismaterialdisposed, 'N') AS Ismaterialdisposed, " +
      "COALESCE(C_ProjectTask.Istaskcancelled, 'N') AS Istaskcancelled, " +
      "C_ProjectTask.Expensesplan, " +
      "C_ProjectTask.Expenses, " +
      "C_ProjectTask.Externalserviceplan, " +
      "C_ProjectTask.Externalservice, " +
      "C_ProjectTask.Materialcostplan, " +
      "C_ProjectTask.Materialcost, " +
      "C_ProjectTask.Servcostplan, " +
      "C_ProjectTask.Servcost, " +
      "C_ProjectTask.Machinecostplan, " +
      "C_ProjectTask.Machinecost, " +
      "C_ProjectTask.Indirectcostplan, " +
      "C_ProjectTask.Indirectcost, " +
      "C_ProjectTask.Committedamt, " +
      "C_ProjectTask.Invoicedamt, " +
      "C_ProjectTask.Plannedcost, " +
      "C_ProjectTask.Actualcost, " +
      "C_ProjectTask.Percentdone, " +
      "C_ProjectTask.Schedulestatus, " +
      "(CASE WHEN C_ProjectTask.Schedulestatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS SchedulestatusR, " +
      "C_ProjectTask.Preplanmaterial, " +
      "C_ProjectTask.Copyptask, " +
      "C_ProjectTask.Createbom, " +
      "C_ProjectTask.Planmaterial, " +
      "C_ProjectTask.Unplanmaterial, " +
      "C_ProjectTask.Getmaterialfromstock, " +
      "C_ProjectTask.Returnmaterialtostock, " +
      "C_ProjectTask.Begintask, " +
      "C_ProjectTask.Endtask, " +
      "C_ProjectTask.Canceltask, " +
      "C_ProjectTask.AD_Org_ID, " +
      "C_ProjectTask.C_ProjectTask_ID, " +
      "C_ProjectTask.AD_Client_ID, " +
      "C_ProjectTask.Datecontract, " +
      "COALESCE(C_ProjectTask.Gotopurchasing, 'N') AS Gotopurchasing, " +
      "C_ProjectTask.C_Task_ID, " +
      "C_ProjectTask.PriceActual, " +
      "COALESCE(C_ProjectTask.Iscommitceiling, 'N') AS Iscommitceiling, " +
      "C_ProjectTask.C_Projectphase_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_ProjectTask left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_ProjectTask.C_Project_ID = table1.C_Project_ID) left join (select AD_User_ID, Name from AD_User) table2 on (C_ProjectTask.AD_User_ID =  table2.AD_User_ID) left join (select C_Color_ID, Name from C_Color) table3 on (C_ProjectTask.C_Color_ID = table3.C_Color_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (C_ProjectTask.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join ad_ref_list_v list1 on (C_ProjectTask.Schedulestatus = list1.value and list1.ad_reference_id = '5A15398CEFA041818A3970A9FF8D7A78' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND C_ProjectTask.C_Project_ID = ?  ");
    strSql = strSql + 
      "        AND C_ProjectTask.C_ProjectTask_ID = ? " +
      "        AND C_ProjectTask.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_ProjectTask.AD_Org_ID IN (";
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
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
        ProjectTask490Data objectProjectTask490Data = new ProjectTask490Data();
        objectProjectTask490Data.created = UtilSql.getValue(result, "created");
        objectProjectTask490Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProjectTask490Data.updated = UtilSql.getValue(result, "updated");
        objectProjectTask490Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProjectTask490Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectProjectTask490Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProjectTask490Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProjectTask490Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectProjectTask490Data.seqno = UtilSql.getValue(result, "seqno");
        objectProjectTask490Data.isactive = UtilSql.getValue(result, "isactive");
        objectProjectTask490Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProjectTask490Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectProjectTask490Data.outsourcing = UtilSql.getValue(result, "outsourcing");
        objectProjectTask490Data.name = UtilSql.getValue(result, "name");
        objectProjectTask490Data.description = UtilSql.getValue(result, "description");
        objectProjectTask490Data.help = UtilSql.getValue(result, "help");
        objectProjectTask490Data.cColorId = UtilSql.getValue(result, "c_color_id");
        objectProjectTask490Data.cColorIdr = UtilSql.getValue(result, "c_color_idr");
        objectProjectTask490Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjectTask490Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectProjectTask490Data.qty = UtilSql.getValue(result, "qty");
        objectProjectTask490Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectProjectTask490Data.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectProjectTask490Data.feedbackfinished = UtilSql.getValue(result, "feedbackfinished");
        objectProjectTask490Data.taskbegun = UtilSql.getValue(result, "taskbegun");
        objectProjectTask490Data.iscomplete = UtilSql.getValue(result, "iscomplete");
        objectProjectTask490Data.ismaterialdisposed = UtilSql.getValue(result, "ismaterialdisposed");
        objectProjectTask490Data.istaskcancelled = UtilSql.getValue(result, "istaskcancelled");
        objectProjectTask490Data.expensesplan = UtilSql.getValue(result, "expensesplan");
        objectProjectTask490Data.expenses = UtilSql.getValue(result, "expenses");
        objectProjectTask490Data.externalserviceplan = UtilSql.getValue(result, "externalserviceplan");
        objectProjectTask490Data.externalservice = UtilSql.getValue(result, "externalservice");
        objectProjectTask490Data.materialcostplan = UtilSql.getValue(result, "materialcostplan");
        objectProjectTask490Data.materialcost = UtilSql.getValue(result, "materialcost");
        objectProjectTask490Data.servcostplan = UtilSql.getValue(result, "servcostplan");
        objectProjectTask490Data.servcost = UtilSql.getValue(result, "servcost");
        objectProjectTask490Data.machinecostplan = UtilSql.getValue(result, "machinecostplan");
        objectProjectTask490Data.machinecost = UtilSql.getValue(result, "machinecost");
        objectProjectTask490Data.indirectcostplan = UtilSql.getValue(result, "indirectcostplan");
        objectProjectTask490Data.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectProjectTask490Data.committedamt = UtilSql.getValue(result, "committedamt");
        objectProjectTask490Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectProjectTask490Data.plannedcost = UtilSql.getValue(result, "plannedcost");
        objectProjectTask490Data.actualcost = UtilSql.getValue(result, "actualcost");
        objectProjectTask490Data.percentdone = UtilSql.getValue(result, "percentdone");
        objectProjectTask490Data.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectProjectTask490Data.schedulestatusr = UtilSql.getValue(result, "schedulestatusr");
        objectProjectTask490Data.preplanmaterial = UtilSql.getValue(result, "preplanmaterial");
        objectProjectTask490Data.copyptask = UtilSql.getValue(result, "copyptask");
        objectProjectTask490Data.createbom = UtilSql.getValue(result, "createbom");
        objectProjectTask490Data.planmaterial = UtilSql.getValue(result, "planmaterial");
        objectProjectTask490Data.unplanmaterial = UtilSql.getValue(result, "unplanmaterial");
        objectProjectTask490Data.getmaterialfromstock = UtilSql.getValue(result, "getmaterialfromstock");
        objectProjectTask490Data.returnmaterialtostock = UtilSql.getValue(result, "returnmaterialtostock");
        objectProjectTask490Data.begintask = UtilSql.getValue(result, "begintask");
        objectProjectTask490Data.endtask = UtilSql.getValue(result, "endtask");
        objectProjectTask490Data.canceltask = UtilSql.getValue(result, "canceltask");
        objectProjectTask490Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProjectTask490Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectProjectTask490Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProjectTask490Data.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectProjectTask490Data.gotopurchasing = UtilSql.getValue(result, "gotopurchasing");
        objectProjectTask490Data.cTaskId = UtilSql.getValue(result, "c_task_id");
        objectProjectTask490Data.priceactual = UtilSql.getValue(result, "priceactual");
        objectProjectTask490Data.iscommitceiling = UtilSql.getValue(result, "iscommitceiling");
        objectProjectTask490Data.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectProjectTask490Data.language = UtilSql.getValue(result, "language");
        objectProjectTask490Data.adUserClient = "";
        objectProjectTask490Data.adOrgClient = "";
        objectProjectTask490Data.createdby = "";
        objectProjectTask490Data.trBgcolor = "";
        objectProjectTask490Data.totalCount = "";
        objectProjectTask490Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectTask490Data);
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
    ProjectTask490Data objectProjectTask490Data[] = new ProjectTask490Data[vector.size()];
    vector.copyInto(objectProjectTask490Data);
    return(objectProjectTask490Data);
  }

/**
Create a registry
 */
  public static ProjectTask490Data[] set(String cProjectId, String cProjectphaseId, String name, String materialcostplan, String returnmaterialtostock, String cColorId, String istaskcancelled, String externalserviceplan, String servcostplan, String expensesplan, String qty, String outsourcing, String adUserId, String invoicedamt, String schedulestatus, String indirectcostplan, String help, String iscomplete, String datecontract, String machinecostplan, String cTaskId, String cProjecttaskId, String copyptask, String createbom, String servcost, String materialcost, String iscommitceiling, String priceactual, String gotopurchasing, String feedbackfinished, String begintask, String percentdone, String taskbegun, String endtask, String plannedcost, String mProductId, String mProductIdr, String description, String createdby, String createdbyr, String enddate, String indirectcost, String ismaterialdisposed, String machinecost, String updatedby, String updatedbyr, String planmaterial, String startdate, String expenses, String seqno, String committedamt, String adClientId, String getmaterialfromstock, String isactive, String preplanmaterial, String externalservice, String canceltask, String actualcost, String unplanmaterial, String adOrgId)    throws ServletException {
    ProjectTask490Data objectProjectTask490Data[] = new ProjectTask490Data[1];
    objectProjectTask490Data[0] = new ProjectTask490Data();
    objectProjectTask490Data[0].created = "";
    objectProjectTask490Data[0].createdbyr = createdbyr;
    objectProjectTask490Data[0].updated = "";
    objectProjectTask490Data[0].updatedTimeStamp = "";
    objectProjectTask490Data[0].updatedby = updatedby;
    objectProjectTask490Data[0].updatedbyr = updatedbyr;
    objectProjectTask490Data[0].cProjectId = cProjectId;
    objectProjectTask490Data[0].cProjectIdr = "";
    objectProjectTask490Data[0].seqno = seqno;
    objectProjectTask490Data[0].isactive = isactive;
    objectProjectTask490Data[0].adUserId = adUserId;
    objectProjectTask490Data[0].adUserIdr = "";
    objectProjectTask490Data[0].outsourcing = outsourcing;
    objectProjectTask490Data[0].name = name;
    objectProjectTask490Data[0].description = description;
    objectProjectTask490Data[0].help = help;
    objectProjectTask490Data[0].cColorId = cColorId;
    objectProjectTask490Data[0].cColorIdr = "";
    objectProjectTask490Data[0].mProductId = mProductId;
    objectProjectTask490Data[0].mProductIdr = mProductIdr;
    objectProjectTask490Data[0].qty = qty;
    objectProjectTask490Data[0].startdate = startdate;
    objectProjectTask490Data[0].enddate = enddate;
    objectProjectTask490Data[0].feedbackfinished = feedbackfinished;
    objectProjectTask490Data[0].taskbegun = taskbegun;
    objectProjectTask490Data[0].iscomplete = iscomplete;
    objectProjectTask490Data[0].ismaterialdisposed = ismaterialdisposed;
    objectProjectTask490Data[0].istaskcancelled = istaskcancelled;
    objectProjectTask490Data[0].expensesplan = expensesplan;
    objectProjectTask490Data[0].expenses = expenses;
    objectProjectTask490Data[0].externalserviceplan = externalserviceplan;
    objectProjectTask490Data[0].externalservice = externalservice;
    objectProjectTask490Data[0].materialcostplan = materialcostplan;
    objectProjectTask490Data[0].materialcost = materialcost;
    objectProjectTask490Data[0].servcostplan = servcostplan;
    objectProjectTask490Data[0].servcost = servcost;
    objectProjectTask490Data[0].machinecostplan = machinecostplan;
    objectProjectTask490Data[0].machinecost = machinecost;
    objectProjectTask490Data[0].indirectcostplan = indirectcostplan;
    objectProjectTask490Data[0].indirectcost = indirectcost;
    objectProjectTask490Data[0].committedamt = committedamt;
    objectProjectTask490Data[0].invoicedamt = invoicedamt;
    objectProjectTask490Data[0].plannedcost = plannedcost;
    objectProjectTask490Data[0].actualcost = actualcost;
    objectProjectTask490Data[0].percentdone = percentdone;
    objectProjectTask490Data[0].schedulestatus = schedulestatus;
    objectProjectTask490Data[0].schedulestatusr = "";
    objectProjectTask490Data[0].preplanmaterial = preplanmaterial;
    objectProjectTask490Data[0].copyptask = copyptask;
    objectProjectTask490Data[0].createbom = createbom;
    objectProjectTask490Data[0].planmaterial = planmaterial;
    objectProjectTask490Data[0].unplanmaterial = unplanmaterial;
    objectProjectTask490Data[0].getmaterialfromstock = getmaterialfromstock;
    objectProjectTask490Data[0].returnmaterialtostock = returnmaterialtostock;
    objectProjectTask490Data[0].begintask = begintask;
    objectProjectTask490Data[0].endtask = endtask;
    objectProjectTask490Data[0].canceltask = canceltask;
    objectProjectTask490Data[0].adOrgId = adOrgId;
    objectProjectTask490Data[0].cProjecttaskId = cProjecttaskId;
    objectProjectTask490Data[0].adClientId = adClientId;
    objectProjectTask490Data[0].datecontract = datecontract;
    objectProjectTask490Data[0].gotopurchasing = gotopurchasing;
    objectProjectTask490Data[0].cTaskId = cTaskId;
    objectProjectTask490Data[0].priceactual = priceactual;
    objectProjectTask490Data[0].iscommitceiling = iscommitceiling;
    objectProjectTask490Data[0].cProjectphaseId = cProjectphaseId;
    objectProjectTask490Data[0].language = "";
    return objectProjectTask490Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8890_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef8893_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef1005900001(ConnectionProvider connectionProvider, String AD_JAVADATEFORMAT, String C_Project_ID)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef8895_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef1005900000(ConnectionProvider connectionProvider, String AD_JAVADATEFORMAT, String C_Project_ID)    throws ServletException {
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
  public static String selectDef8894(ConnectionProvider connectionProvider, String C_Project_ID)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ProjectTask.C_Project_ID AS NAME" +
      "        FROM C_ProjectTask" +
      "        WHERE C_ProjectTask.C_ProjectTask_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_Project.C_Project_ID = table1.C_Project_ID) WHERE C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_Project.C_Project_ID = table1.C_Project_ID) WHERE C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
  public static String selectActDefC_Project_ID(ConnectionProvider connectionProvider, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Value FROM C_Project WHERE isActive='Y' AND C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

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
      "        UPDATE C_ProjectTask" +
      "        SET C_Project_ID = (?) , SeqNo = TO_NUMBER(?) , IsActive = (?) , AD_User_ID = (?) , Outsourcing = (?) , Name = (?) , Description = (?) , Help = (?) , C_Color_ID = (?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , StartDate = TO_DATE(?) , Enddate = TO_DATE(?) , Feedbackfinished = (?) , Taskbegun = (?) , Iscomplete = (?) , Ismaterialdisposed = (?) , Istaskcancelled = (?) , Expensesplan = TO_NUMBER(?) , Expenses = TO_NUMBER(?) , Externalserviceplan = TO_NUMBER(?) , Externalservice = TO_NUMBER(?) , Materialcostplan = TO_NUMBER(?) , Materialcost = TO_NUMBER(?) , Servcostplan = TO_NUMBER(?) , Servcost = TO_NUMBER(?) , Machinecostplan = TO_NUMBER(?) , Machinecost = TO_NUMBER(?) , Indirectcostplan = TO_NUMBER(?) , Indirectcost = TO_NUMBER(?) , Committedamt = TO_NUMBER(?) , Invoicedamt = TO_NUMBER(?) , Plannedcost = TO_NUMBER(?) , Actualcost = TO_NUMBER(?) , Percentdone = TO_NUMBER(?) , Schedulestatus = (?) , Preplanmaterial = (?) , Copyptask = (?) , Createbom = (?) , Planmaterial = (?) , Unplanmaterial = (?) , Getmaterialfromstock = (?) , Returnmaterialtostock = (?) , Begintask = (?) , Endtask = (?) , Canceltask = (?) , AD_Org_ID = (?) , C_ProjectTask_ID = (?) , AD_Client_ID = (?) , Datecontract = TO_DATE(?) , Gotopurchasing = (?) , C_Task_ID = (?) , PriceActual = TO_NUMBER(?) , Iscommitceiling = (?) , C_Projectphase_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_ProjectTask.C_ProjectTask_ID = ? " +
      "                 AND C_ProjectTask.C_Project_ID = ? " +
      "        AND C_ProjectTask.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ProjectTask.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourcing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cColorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, feedbackfinished);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskbegun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismaterialdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskcancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expensesplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalserviceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyptask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, getmaterialfromstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnmaterialtostock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, begintask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, canceltask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gotopurchasing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
      "        INSERT INTO C_ProjectTask " +
      "        (C_Project_ID, SeqNo, IsActive, AD_User_ID, Outsourcing, Name, Description, Help, C_Color_ID, M_Product_ID, Qty, StartDate, Enddate, Feedbackfinished, Taskbegun, Iscomplete, Ismaterialdisposed, Istaskcancelled, Expensesplan, Expenses, Externalserviceplan, Externalservice, Materialcostplan, Materialcost, Servcostplan, Servcost, Machinecostplan, Machinecost, Indirectcostplan, Indirectcost, Committedamt, Invoicedamt, Plannedcost, Actualcost, Percentdone, Schedulestatus, Preplanmaterial, Copyptask, Createbom, Planmaterial, Unplanmaterial, Getmaterialfromstock, Returnmaterialtostock, Begintask, Endtask, Canceltask, AD_Org_ID, C_ProjectTask_ID, AD_Client_ID, Datecontract, Gotopurchasing, C_Task_ID, PriceActual, Iscommitceiling, C_Projectphase_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourcing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cColorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, feedbackfinished);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskbegun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismaterialdisposed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskcancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expensesplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalserviceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyptask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unplanmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, getmaterialfromstock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnmaterialtostock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, begintask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, canceltask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gotopurchasing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscommitceiling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjectId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ProjectTask" +
      "        WHERE C_ProjectTask.C_ProjectTask_ID = ? " +
      "                 AND C_ProjectTask.C_Project_ID = ? " +
      "        AND C_ProjectTask.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ProjectTask.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ProjectTask" +
      "        WHERE C_ProjectTask.C_ProjectTask_ID = ? " +
      "                 AND C_ProjectTask.C_Project_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
      "          FROM C_ProjectTask" +
      "         WHERE C_ProjectTask.C_ProjectTask_ID = ? ";

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
      "          FROM C_ProjectTask" +
      "         WHERE C_ProjectTask.C_ProjectTask_ID = ? ";

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

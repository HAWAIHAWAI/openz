//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.jmm.SalesOrderStatusReports;

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
class SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data implements FieldProvider {
static Logger log4j = Logger.getLogger(SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String juwimmOrderstatusControllingVId;
  public String name;
  public String documentno;
  public String cOrderId;
  public String projectName;
  public String projectValue;
  public String salesrepId;
  public String salesrepIdr;
  public String adOrgId;
  public String isactive;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String totallines;
  public String adUserId;
  public String adUserIdr;
  public String juwimmCompletion;
  public String juwimmCompletionr;
  public String juwimmTime;
  public String juwimmTimer;
  public String juwimmResources;
  public String juwimmResourcesr;
  public String issotrx;
  public String juwimmBudget;
  public String juwimmBudgetr;
  public String juwimmTeamId;
  public String juwimmTeamIdr;
  public String docstatus;
  public String juwimmPlannedgolive;
  public String docaction;
  public String juwimmEstgolive;
  public String adClientId;
  public String cProjectId;
  public String juwimmNextimpdate;
  public String juwimmPlannedstart;
  public String juwimmEststart;
  public String juwimmPlannedend;
  public String juwimmEstend;
  public String juwimmOuputremarks;
  public String juwimmLastaction;
  public String juwimmNextaction;
  public String juwimmIssues;
  public String juwimmDecisions;
  public String iscompletelyinvoiced;
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
    else if (fieldName.equalsIgnoreCase("juwimm_orderstatus_controlling_v_id") || fieldName.equals("juwimmOrderstatusControllingVId"))
      return juwimmOrderstatusControllingVId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("project_name") || fieldName.equals("projectName"))
      return projectName;
    else if (fieldName.equalsIgnoreCase("project_value") || fieldName.equals("projectValue"))
      return projectValue;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("juwimm_completion") || fieldName.equals("juwimmCompletion"))
      return juwimmCompletion;
    else if (fieldName.equalsIgnoreCase("juwimm_completionr") || fieldName.equals("juwimmCompletionr"))
      return juwimmCompletionr;
    else if (fieldName.equalsIgnoreCase("juwimm_time") || fieldName.equals("juwimmTime"))
      return juwimmTime;
    else if (fieldName.equalsIgnoreCase("juwimm_timer") || fieldName.equals("juwimmTimer"))
      return juwimmTimer;
    else if (fieldName.equalsIgnoreCase("juwimm_resources") || fieldName.equals("juwimmResources"))
      return juwimmResources;
    else if (fieldName.equalsIgnoreCase("juwimm_resourcesr") || fieldName.equals("juwimmResourcesr"))
      return juwimmResourcesr;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("juwimm_budget") || fieldName.equals("juwimmBudget"))
      return juwimmBudget;
    else if (fieldName.equalsIgnoreCase("juwimm_budgetr") || fieldName.equals("juwimmBudgetr"))
      return juwimmBudgetr;
    else if (fieldName.equalsIgnoreCase("juwimm_team_id") || fieldName.equals("juwimmTeamId"))
      return juwimmTeamId;
    else if (fieldName.equalsIgnoreCase("juwimm_team_idr") || fieldName.equals("juwimmTeamIdr"))
      return juwimmTeamIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("juwimm_plannedgolive") || fieldName.equals("juwimmPlannedgolive"))
      return juwimmPlannedgolive;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("juwimm_estgolive") || fieldName.equals("juwimmEstgolive"))
      return juwimmEstgolive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("juwimm_nextimpdate") || fieldName.equals("juwimmNextimpdate"))
      return juwimmNextimpdate;
    else if (fieldName.equalsIgnoreCase("juwimm_plannedstart") || fieldName.equals("juwimmPlannedstart"))
      return juwimmPlannedstart;
    else if (fieldName.equalsIgnoreCase("juwimm_eststart") || fieldName.equals("juwimmEststart"))
      return juwimmEststart;
    else if (fieldName.equalsIgnoreCase("juwimm_plannedend") || fieldName.equals("juwimmPlannedend"))
      return juwimmPlannedend;
    else if (fieldName.equalsIgnoreCase("juwimm_estend") || fieldName.equals("juwimmEstend"))
      return juwimmEstend;
    else if (fieldName.equalsIgnoreCase("juwimm_ouputremarks") || fieldName.equals("juwimmOuputremarks"))
      return juwimmOuputremarks;
    else if (fieldName.equalsIgnoreCase("juwimm_lastaction") || fieldName.equals("juwimmLastaction"))
      return juwimmLastaction;
    else if (fieldName.equalsIgnoreCase("juwimm_nextaction") || fieldName.equals("juwimmNextaction"))
      return juwimmNextaction;
    else if (fieldName.equalsIgnoreCase("juwimm_issues") || fieldName.equals("juwimmIssues"))
      return juwimmIssues;
    else if (fieldName.equalsIgnoreCase("juwimm_decisions") || fieldName.equals("juwimmDecisions"))
      return juwimmDecisions;
    else if (fieldName.equalsIgnoreCase("iscompletelyinvoiced"))
      return iscompletelyinvoiced;
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
  public static SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(juwimm_orderstatus_controlling_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_orderstatus_controlling_v.CreatedBy) as CreatedByR, " +
      "        to_char(juwimm_orderstatus_controlling_v.Updated, ?) as updated, " +
      "        to_char(juwimm_orderstatus_controlling_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        juwimm_orderstatus_controlling_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_orderstatus_controlling_v.UpdatedBy) as UpdatedByR," +
      "        juwimm_orderstatus_controlling_v.Juwimm_Orderstatus_Controlling_V_ID, " +
      "juwimm_orderstatus_controlling_v.Name, " +
      "juwimm_orderstatus_controlling_v.Documentno, " +
      "juwimm_orderstatus_controlling_v.C_Order_ID, " +
      "juwimm_orderstatus_controlling_v.Project_Name, " +
      "juwimm_orderstatus_controlling_v.Project_Value, " +
      "juwimm_orderstatus_controlling_v.Salesrep_ID, " +
      "(CASE WHEN juwimm_orderstatus_controlling_v.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "juwimm_orderstatus_controlling_v.AD_Org_ID, " +
      "COALESCE(juwimm_orderstatus_controlling_v.Isactive, 'N') AS Isactive, " +
      "juwimm_orderstatus_controlling_v.C_Bpartner_ID, " +
      "(CASE WHEN juwimm_orderstatus_controlling_v.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "juwimm_orderstatus_controlling_v.Totallines, " +
      "juwimm_orderstatus_controlling_v.AD_User_ID, " +
      "(CASE WHEN juwimm_orderstatus_controlling_v.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Completion, " +
      "(CASE WHEN juwimm_orderstatus_controlling_v.Juwimm_Completion IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Juwimm_CompletionR, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Time, " +
      "(CASE WHEN juwimm_orderstatus_controlling_v.Juwimm_Time IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS Juwimm_TimeR, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Resources, " +
      "(CASE WHEN juwimm_orderstatus_controlling_v.Juwimm_Resources IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Juwimm_ResourcesR, " +
      "COALESCE(juwimm_orderstatus_controlling_v.IsSOTrx, 'N') AS IsSOTrx, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Budget, " +
      "(CASE WHEN juwimm_orderstatus_controlling_v.Juwimm_Budget IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS Juwimm_BudgetR, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Team_ID, " +
      "(CASE WHEN juwimm_orderstatus_controlling_v.Juwimm_Team_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS Juwimm_Team_IDR, " +
      "juwimm_orderstatus_controlling_v.Docstatus, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Plannedgolive, " +
      "juwimm_orderstatus_controlling_v.Docaction, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Estgolive, " +
      "juwimm_orderstatus_controlling_v.AD_Client_ID, " +
      "juwimm_orderstatus_controlling_v.C_Project_ID, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Nextimpdate, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Plannedstart, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Eststart, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Plannedend, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Estend, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Ouputremarks, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Lastaction, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Nextaction, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Issues, " +
      "juwimm_orderstatus_controlling_v.Juwimm_Decisions, " +
      "COALESCE(juwimm_orderstatus_controlling_v.Iscompletelyinvoiced, 'N') AS Iscompletelyinvoiced, " +
      "        ? AS LANGUAGE " +
      "        FROM juwimm_orderstatus_controlling_v left join (select AD_User_ID, Name from AD_User) table1 on (juwimm_orderstatus_controlling_v.Salesrep_ID =  table1.AD_User_ID) left join (select C_BPartner_ID, Name from C_BPartner) table2 on (juwimm_orderstatus_controlling_v.C_Bpartner_ID = table2.C_BPartner_ID) left join (select AD_User_ID, Name from AD_User) table3 on (juwimm_orderstatus_controlling_v.AD_User_ID = table3.AD_User_ID) left join ad_ref_list_v list1 on (juwimm_orderstatus_controlling_v.Juwimm_Completion = list1.value and list1.ad_reference_id = 'DFB97A7B6DE848EEAA271F95215E316E' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (juwimm_orderstatus_controlling_v.Juwimm_Time = list2.value and list2.ad_reference_id = 'BBFB55FDBAA64C0EB46F026460AE8285' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (juwimm_orderstatus_controlling_v.Juwimm_Resources = list3.value and list3.ad_reference_id = '7C374D10EA044BE3B252D6654A7AA5E1' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (juwimm_orderstatus_controlling_v.Juwimm_Budget = list4.value and list4.ad_reference_id = '76CDE2B245D44726AE30457453FF622E' and list4.ad_language = ?)  left join (select Juwimm_Team_ID, Name from Juwimm_Team) table4 on (juwimm_orderstatus_controlling_v.Juwimm_Team_ID = table4.Juwimm_Team_ID) left join (select Juwimm_Team_ID,AD_Language, Name from juwimm_team_TRL) tableTRL4 on (table4.Juwimm_Team_ID = tableTRL4.Juwimm_Team_ID and tableTRL4.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND juwimm_orderstatus_controlling_v.Juwimm_Orderstatus_Controlling_V_ID = ? " +
      "        AND juwimm_orderstatus_controlling_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND juwimm_orderstatus_controlling_v.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
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
        SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data = new SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data();
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.created = UtilSql.getValue(result, "created");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.updated = UtilSql.getValue(result, "updated");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmOrderstatusControllingVId = UtilSql.getValue(result, "juwimm_orderstatus_controlling_v_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.name = UtilSql.getValue(result, "name");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.documentno = UtilSql.getValue(result, "documentno");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.projectName = UtilSql.getValue(result, "project_name");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.projectValue = UtilSql.getValue(result, "project_value");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.isactive = UtilSql.getValue(result, "isactive");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.totallines = UtilSql.getValue(result, "totallines");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmCompletion = UtilSql.getValue(result, "juwimm_completion");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmCompletionr = UtilSql.getValue(result, "juwimm_completionr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmTime = UtilSql.getValue(result, "juwimm_time");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmTimer = UtilSql.getValue(result, "juwimm_timer");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmResources = UtilSql.getValue(result, "juwimm_resources");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmResourcesr = UtilSql.getValue(result, "juwimm_resourcesr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.issotrx = UtilSql.getValue(result, "issotrx");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmBudget = UtilSql.getValue(result, "juwimm_budget");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmBudgetr = UtilSql.getValue(result, "juwimm_budgetr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmTeamId = UtilSql.getValue(result, "juwimm_team_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmTeamIdr = UtilSql.getValue(result, "juwimm_team_idr");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.docstatus = UtilSql.getValue(result, "docstatus");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmPlannedgolive = UtilSql.getDateValue(result, "juwimm_plannedgolive", "dd-MM-yyyy");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.docaction = UtilSql.getValue(result, "docaction");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmEstgolive = UtilSql.getDateValue(result, "juwimm_estgolive", "dd-MM-yyyy");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmNextimpdate = UtilSql.getDateValue(result, "juwimm_nextimpdate", "dd-MM-yyyy");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmPlannedstart = UtilSql.getDateValue(result, "juwimm_plannedstart", "dd-MM-yyyy");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmEststart = UtilSql.getDateValue(result, "juwimm_eststart", "dd-MM-yyyy");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmPlannedend = UtilSql.getDateValue(result, "juwimm_plannedend", "dd-MM-yyyy");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmEstend = UtilSql.getDateValue(result, "juwimm_estend", "dd-MM-yyyy");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmOuputremarks = UtilSql.getValue(result, "juwimm_ouputremarks");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmLastaction = UtilSql.getValue(result, "juwimm_lastaction");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmNextaction = UtilSql.getValue(result, "juwimm_nextaction");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmIssues = UtilSql.getValue(result, "juwimm_issues");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.juwimmDecisions = UtilSql.getValue(result, "juwimm_decisions");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.iscompletelyinvoiced = UtilSql.getValue(result, "iscompletelyinvoiced");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.language = UtilSql.getValue(result, "language");
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.adUserClient = "";
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.adOrgClient = "";
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.createdby = "";
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.trBgcolor = "";
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.totalCount = "";
        objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data);
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
    SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] = new SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[vector.size()];
    vector.copyInto(objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data);
    return(objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data);
  }

/**
Create a registry
 */
  public static SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] set(String name, String juwimmOrderstatusControllingVId, String issotrx, String juwimmEstend, String salesrepId, String adClientId, String juwimmPlannedstart, String juwimmTime, String updatedby, String updatedbyr, String juwimmBudget, String juwimmIssues, String documentno, String cOrderId, String projectValue, String docstatus, String juwimmPlannedgolive, String juwimmOuputremarks, String createdby, String createdbyr, String adUserId, String juwimmResources, String iscompletelyinvoiced, String juwimmEststart, String juwimmCompletion, String adOrgId, String juwimmTeamId, String juwimmPlannedend, String juwimmDecisions, String cBpartnerId, String cBpartnerIdr, String juwimmLastaction, String juwimmNextaction, String juwimmNextimpdate, String juwimmEstgolive, String projectName, String isactive, String docaction, String cProjectId, String totallines)    throws ServletException {
    SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[] = new SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[1];
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0] = new SalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data();
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].created = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].createdbyr = createdbyr;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].updated = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].updatedTimeStamp = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].updatedby = updatedby;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].updatedbyr = updatedbyr;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmOrderstatusControllingVId = juwimmOrderstatusControllingVId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].name = name;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].documentno = documentno;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].cOrderId = cOrderId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].projectName = projectName;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].projectValue = projectValue;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].salesrepId = salesrepId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].salesrepIdr = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].adOrgId = adOrgId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].isactive = isactive;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].cBpartnerId = cBpartnerId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].cBpartnerIdr = cBpartnerIdr;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].totallines = totallines;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].adUserId = adUserId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].adUserIdr = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmCompletion = juwimmCompletion;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmCompletionr = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmTime = juwimmTime;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmTimer = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmResources = juwimmResources;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmResourcesr = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].issotrx = issotrx;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmBudget = juwimmBudget;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmBudgetr = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmTeamId = juwimmTeamId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmTeamIdr = "";
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].docstatus = docstatus;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmPlannedgolive = juwimmPlannedgolive;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].docaction = docaction;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmEstgolive = juwimmEstgolive;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].adClientId = adClientId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].cProjectId = cProjectId;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmNextimpdate = juwimmNextimpdate;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmPlannedstart = juwimmPlannedstart;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmEststart = juwimmEststart;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmPlannedend = juwimmPlannedend;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmEstend = juwimmEstend;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmOuputremarks = juwimmOuputremarks;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmLastaction = juwimmLastaction;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmNextaction = juwimmNextaction;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmIssues = juwimmIssues;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].juwimmDecisions = juwimmDecisions;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].iscompletelyinvoiced = iscompletelyinvoiced;
    objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data[0].language = "";
    return objectSalesOrderStatusReports3A41529F45B04ABE83EE3E73C38BA526Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefFA0BF18F735E458EAD1F6AC24D76D38E_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef8836A70361064B9AB1E7587CF6B6C247_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefE7CAFB519FC94B64B02D7C3B3A6801EE_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

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
      "        UPDATE juwimm_orderstatus_controlling_v" +
      "        SET Juwimm_Orderstatus_Controlling_V_ID = (?) , Name = (?) , Documentno = (?) , C_Order_ID = (?) , Project_Name = (?) , Project_Value = (?) , Salesrep_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , C_Bpartner_ID = (?) , Totallines = TO_NUMBER(?) , AD_User_ID = (?) , Juwimm_Completion = (?) , Juwimm_Time = (?) , Juwimm_Resources = (?) , IsSOTrx = (?) , Juwimm_Budget = (?) , Juwimm_Team_ID = (?) , Docstatus = (?) , Juwimm_Plannedgolive = TO_DATE(?) , Docaction = (?) , Juwimm_Estgolive = TO_DATE(?) , AD_Client_ID = (?) , C_Project_ID = (?) , Juwimm_Nextimpdate = TO_DATE(?) , Juwimm_Plannedstart = TO_DATE(?) , Juwimm_Eststart = TO_DATE(?) , Juwimm_Plannedend = TO_DATE(?) , Juwimm_Estend = TO_DATE(?) , Juwimm_Ouputremarks = (?) , Juwimm_Lastaction = (?) , Juwimm_Nextaction = (?) , Juwimm_Issues = (?) , Juwimm_Decisions = (?) , Iscompletelyinvoiced = (?) , updated = now(), updatedby = ? " +
      "        WHERE juwimm_orderstatus_controlling_v.Juwimm_Orderstatus_Controlling_V_ID = ? " +
      "        AND juwimm_orderstatus_controlling_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_orderstatus_controlling_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatusControllingVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmCompletion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmResources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmBudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextimpdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEststart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOuputremarks);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmIssues);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDecisions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatusControllingVId);
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
      "        INSERT INTO juwimm_orderstatus_controlling_v " +
      "        (Juwimm_Orderstatus_Controlling_V_ID, Name, Documentno, C_Order_ID, Project_Name, Project_Value, Salesrep_ID, AD_Org_ID, Isactive, C_Bpartner_ID, Totallines, AD_User_ID, Juwimm_Completion, Juwimm_Time, Juwimm_Resources, IsSOTrx, Juwimm_Budget, Juwimm_Team_ID, Docstatus, Juwimm_Plannedgolive, Docaction, Juwimm_Estgolive, AD_Client_ID, C_Project_ID, Juwimm_Nextimpdate, Juwimm_Plannedstart, Juwimm_Eststart, Juwimm_Plannedend, Juwimm_Estend, Juwimm_Ouputremarks, Juwimm_Lastaction, Juwimm_Nextaction, Juwimm_Issues, Juwimm_Decisions, Iscompletelyinvoiced, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatusControllingVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmCompletion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmResources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmBudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextimpdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEststart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOuputremarks);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmIssues);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDecisions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
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
      "        DELETE FROM juwimm_orderstatus_controlling_v" +
      "        WHERE juwimm_orderstatus_controlling_v.Juwimm_Orderstatus_Controlling_V_ID = ? " +
      "        AND juwimm_orderstatus_controlling_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_orderstatus_controlling_v.AD_Org_ID IN (";
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
      "        DELETE FROM juwimm_orderstatus_controlling_v" +
      "        WHERE juwimm_orderstatus_controlling_v.Juwimm_Orderstatus_Controlling_V_ID = ? ";

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
      "          FROM juwimm_orderstatus_controlling_v" +
      "         WHERE juwimm_orderstatus_controlling_v.Juwimm_Orderstatus_Controlling_V_ID = ? ";

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
      "          FROM juwimm_orderstatus_controlling_v" +
      "         WHERE juwimm_orderstatus_controlling_v.Juwimm_Orderstatus_Controlling_V_ID = ? ";

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

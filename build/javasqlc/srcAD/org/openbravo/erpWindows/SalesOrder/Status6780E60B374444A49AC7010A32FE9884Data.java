//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.SalesOrder;

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
class Status6780E60B374444A49AC7010A32FE9884Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Status6780E60B374444A49AC7010A32FE9884Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cOrderId;
  public String juwimmOrderstatusId;
  public String juwimmProjectman;
  public String juwimmCompletion;
  public String juwimmCompletionr;
  public String adClientId;
  public String adOrgId;
  public String juwimmTime;
  public String juwimmTimer;
  public String juwimmResources;
  public String juwimmResourcesr;
  public String isactive;
  public String juwimmBudget;
  public String juwimmBudgetr;
  public String juwimmTeamId;
  public String juwimmTeamIdr;
  public String juwimmPlannedgolive;
  public String juwimmEstgolive;
  public String juwimmNextimpdate;
  public String juwimmDescription;
  public String juwimmPlannedstart;
  public String juwimmEststart;
  public String juwimmMilestone1;
  public String juwimmMs1planneddate;
  public String juwimmMs1estdate;
  public String juwimmMilestone2;
  public String juwimmMs2planneddate;
  public String juwimmMs2estdate;
  public String juwimmMilestone3;
  public String juwimmMs3planneddate;
  public String juwimmMs3estdate;
  public String juwimmMilestone4;
  public String juwimmMs4planneddate;
  public String juwimmMs4estdate;
  public String juwimmMilestone5;
  public String juwimmMs5planneddate;
  public String juwimmMs5estdate;
  public String juwimmMilestone6;
  public String juwimmMs6planneddate;
  public String juwimmMs6estdate;
  public String juwimmMilestone7;
  public String juwimmMs7planneddate;
  public String juwimmMs7estdate;
  public String juwimmPlannedend;
  public String juwimmEstend;
  public String juwimmOuputremarks;
  public String juwimmLastaction;
  public String juwimmNextaction;
  public String juwimmIssues;
  public String juwimmDecisions;
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
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("juwimm_orderstatus_id") || fieldName.equals("juwimmOrderstatusId"))
      return juwimmOrderstatusId;
    else if (fieldName.equalsIgnoreCase("juwimm_projectman") || fieldName.equals("juwimmProjectman"))
      return juwimmProjectman;
    else if (fieldName.equalsIgnoreCase("juwimm_completion") || fieldName.equals("juwimmCompletion"))
      return juwimmCompletion;
    else if (fieldName.equalsIgnoreCase("juwimm_completionr") || fieldName.equals("juwimmCompletionr"))
      return juwimmCompletionr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("juwimm_time") || fieldName.equals("juwimmTime"))
      return juwimmTime;
    else if (fieldName.equalsIgnoreCase("juwimm_timer") || fieldName.equals("juwimmTimer"))
      return juwimmTimer;
    else if (fieldName.equalsIgnoreCase("juwimm_resources") || fieldName.equals("juwimmResources"))
      return juwimmResources;
    else if (fieldName.equalsIgnoreCase("juwimm_resourcesr") || fieldName.equals("juwimmResourcesr"))
      return juwimmResourcesr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("juwimm_budget") || fieldName.equals("juwimmBudget"))
      return juwimmBudget;
    else if (fieldName.equalsIgnoreCase("juwimm_budgetr") || fieldName.equals("juwimmBudgetr"))
      return juwimmBudgetr;
    else if (fieldName.equalsIgnoreCase("juwimm_team_id") || fieldName.equals("juwimmTeamId"))
      return juwimmTeamId;
    else if (fieldName.equalsIgnoreCase("juwimm_team_idr") || fieldName.equals("juwimmTeamIdr"))
      return juwimmTeamIdr;
    else if (fieldName.equalsIgnoreCase("juwimm_plannedgolive") || fieldName.equals("juwimmPlannedgolive"))
      return juwimmPlannedgolive;
    else if (fieldName.equalsIgnoreCase("juwimm_estgolive") || fieldName.equals("juwimmEstgolive"))
      return juwimmEstgolive;
    else if (fieldName.equalsIgnoreCase("juwimm_nextimpdate") || fieldName.equals("juwimmNextimpdate"))
      return juwimmNextimpdate;
    else if (fieldName.equalsIgnoreCase("juwimm_description") || fieldName.equals("juwimmDescription"))
      return juwimmDescription;
    else if (fieldName.equalsIgnoreCase("juwimm_plannedstart") || fieldName.equals("juwimmPlannedstart"))
      return juwimmPlannedstart;
    else if (fieldName.equalsIgnoreCase("juwimm_eststart") || fieldName.equals("juwimmEststart"))
      return juwimmEststart;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone1") || fieldName.equals("juwimmMilestone1"))
      return juwimmMilestone1;
    else if (fieldName.equalsIgnoreCase("juwimm_ms1planneddate") || fieldName.equals("juwimmMs1planneddate"))
      return juwimmMs1planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms1estdate") || fieldName.equals("juwimmMs1estdate"))
      return juwimmMs1estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone2") || fieldName.equals("juwimmMilestone2"))
      return juwimmMilestone2;
    else if (fieldName.equalsIgnoreCase("juwimm_ms2planneddate") || fieldName.equals("juwimmMs2planneddate"))
      return juwimmMs2planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms2estdate") || fieldName.equals("juwimmMs2estdate"))
      return juwimmMs2estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone3") || fieldName.equals("juwimmMilestone3"))
      return juwimmMilestone3;
    else if (fieldName.equalsIgnoreCase("juwimm_ms3planneddate") || fieldName.equals("juwimmMs3planneddate"))
      return juwimmMs3planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms3estdate") || fieldName.equals("juwimmMs3estdate"))
      return juwimmMs3estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone4") || fieldName.equals("juwimmMilestone4"))
      return juwimmMilestone4;
    else if (fieldName.equalsIgnoreCase("juwimm_ms4planneddate") || fieldName.equals("juwimmMs4planneddate"))
      return juwimmMs4planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms4estdate") || fieldName.equals("juwimmMs4estdate"))
      return juwimmMs4estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone5") || fieldName.equals("juwimmMilestone5"))
      return juwimmMilestone5;
    else if (fieldName.equalsIgnoreCase("juwimm_ms5planneddate") || fieldName.equals("juwimmMs5planneddate"))
      return juwimmMs5planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms5estdate") || fieldName.equals("juwimmMs5estdate"))
      return juwimmMs5estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone6") || fieldName.equals("juwimmMilestone6"))
      return juwimmMilestone6;
    else if (fieldName.equalsIgnoreCase("juwimm_ms6planneddate") || fieldName.equals("juwimmMs6planneddate"))
      return juwimmMs6planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms6estdate") || fieldName.equals("juwimmMs6estdate"))
      return juwimmMs6estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone7") || fieldName.equals("juwimmMilestone7"))
      return juwimmMilestone7;
    else if (fieldName.equalsIgnoreCase("juwimm_ms7planneddate") || fieldName.equals("juwimmMs7planneddate"))
      return juwimmMs7planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms7estdate") || fieldName.equals("juwimmMs7estdate"))
      return juwimmMs7estdate;
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
  public static Status6780E60B374444A49AC7010A32FE9884Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cOrderId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Status6780E60B374444A49AC7010A32FE9884Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cOrderId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(juwimm_orderstatus.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_orderstatus.CreatedBy) as CreatedByR, " +
      "        to_char(juwimm_orderstatus.Updated, ?) as updated, " +
      "        to_char(juwimm_orderstatus.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        juwimm_orderstatus.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_orderstatus.UpdatedBy) as UpdatedByR," +
      "        juwimm_orderstatus.C_Order_ID, " +
      "juwimm_orderstatus.Juwimm_Orderstatus_ID, " +
      "juwimm_orderstatus.Juwimm_Projectman, " +
      "juwimm_orderstatus.Juwimm_Completion, " +
      "(CASE WHEN juwimm_orderstatus.Juwimm_Completion IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Juwimm_CompletionR, " +
      "juwimm_orderstatus.AD_Client_ID, " +
      "juwimm_orderstatus.AD_Org_ID, " +
      "juwimm_orderstatus.Juwimm_Time, " +
      "(CASE WHEN juwimm_orderstatus.Juwimm_Time IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS Juwimm_TimeR, " +
      "juwimm_orderstatus.Juwimm_Resources, " +
      "(CASE WHEN juwimm_orderstatus.Juwimm_Resources IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Juwimm_ResourcesR, " +
      "COALESCE(juwimm_orderstatus.Isactive, 'N') AS Isactive, " +
      "juwimm_orderstatus.Juwimm_Budget, " +
      "(CASE WHEN juwimm_orderstatus.Juwimm_Budget IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS Juwimm_BudgetR, " +
      "juwimm_orderstatus.Juwimm_Team_ID, " +
      "(CASE WHEN juwimm_orderstatus.Juwimm_Team_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS Juwimm_Team_IDR, " +
      "juwimm_orderstatus.Juwimm_Plannedgolive, " +
      "juwimm_orderstatus.Juwimm_Estgolive, " +
      "juwimm_orderstatus.Juwimm_Nextimpdate, " +
      "juwimm_orderstatus.Juwimm_Description, " +
      "juwimm_orderstatus.Juwimm_Plannedstart, " +
      "juwimm_orderstatus.Juwimm_Eststart, " +
      "juwimm_orderstatus.Juwimm_Milestone1, " +
      "juwimm_orderstatus.Juwimm_Ms1planneddate, " +
      "juwimm_orderstatus.Juwimm_Ms1estdate, " +
      "juwimm_orderstatus.Juwimm_Milestone2, " +
      "juwimm_orderstatus.Juwimm_Ms2planneddate, " +
      "juwimm_orderstatus.Juwimm_Ms2estdate, " +
      "juwimm_orderstatus.Juwimm_Milestone3, " +
      "juwimm_orderstatus.Juwimm_Ms3planneddate, " +
      "juwimm_orderstatus.Juwimm_Ms3estdate, " +
      "juwimm_orderstatus.Juwimm_Milestone4, " +
      "juwimm_orderstatus.Juwimm_Ms4planneddate, " +
      "juwimm_orderstatus.Juwimm_Ms4estdate, " +
      "juwimm_orderstatus.Juwimm_Milestone5, " +
      "juwimm_orderstatus.Juwimm_Ms5planneddate, " +
      "juwimm_orderstatus.Juwimm_Ms5estdate, " +
      "juwimm_orderstatus.Juwimm_Milestone6, " +
      "juwimm_orderstatus.Juwimm_Ms6planneddate, " +
      "juwimm_orderstatus.Juwimm_Ms6estdate, " +
      "juwimm_orderstatus.Juwimm_Milestone7, " +
      "juwimm_orderstatus.Juwimm_Ms7planneddate, " +
      "juwimm_orderstatus.Juwimm_Ms7estdate, " +
      "juwimm_orderstatus.Juwimm_Plannedend, " +
      "juwimm_orderstatus.Juwimm_Estend, " +
      "juwimm_orderstatus.Juwimm_Ouputremarks, " +
      "juwimm_orderstatus.Juwimm_Lastaction, " +
      "juwimm_orderstatus.Juwimm_Nextaction, " +
      "juwimm_orderstatus.Juwimm_Issues, " +
      "juwimm_orderstatus.Juwimm_Decisions, " +
      "        ? AS LANGUAGE " +
      "        FROM juwimm_orderstatus left join ad_ref_list_v list1 on (juwimm_orderstatus.Juwimm_Completion = list1.value and list1.ad_reference_id = 'DFB97A7B6DE848EEAA271F95215E316E' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (juwimm_orderstatus.Juwimm_Time = list2.value and list2.ad_reference_id = 'BBFB55FDBAA64C0EB46F026460AE8285' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (juwimm_orderstatus.Juwimm_Resources = list3.value and list3.ad_reference_id = '7C374D10EA044BE3B252D6654A7AA5E1' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (juwimm_orderstatus.Juwimm_Budget = list4.value and list4.ad_reference_id = '76CDE2B245D44726AE30457453FF622E' and list4.ad_language = ?)  left join (select Juwimm_Team_ID, Name from Juwimm_Team) table1 on (juwimm_orderstatus.Juwimm_Team_ID = table1.Juwimm_Team_ID) left join (select Juwimm_Team_ID,AD_Language, Name from juwimm_team_TRL) tableTRL1 on (table1.Juwimm_Team_ID = tableTRL1.Juwimm_Team_ID and tableTRL1.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cOrderId==null || cOrderId.equals(""))?"":"  AND juwimm_orderstatus.C_Order_ID = ?  ");
    strSql = strSql + 
      "        AND juwimm_orderstatus.Juwimm_Orderstatus_ID = ? " +
      "        AND juwimm_orderstatus.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND juwimm_orderstatus.AD_Org_ID IN (";
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
      if (cOrderId != null && !(cOrderId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
        Status6780E60B374444A49AC7010A32FE9884Data objectStatus6780E60B374444A49AC7010A32FE9884Data = new Status6780E60B374444A49AC7010A32FE9884Data();
        objectStatus6780E60B374444A49AC7010A32FE9884Data.created = UtilSql.getValue(result, "created");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.updated = UtilSql.getValue(result, "updated");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmOrderstatusId = UtilSql.getValue(result, "juwimm_orderstatus_id");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmProjectman = UtilSql.getValue(result, "juwimm_projectman");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmCompletion = UtilSql.getValue(result, "juwimm_completion");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmCompletionr = UtilSql.getValue(result, "juwimm_completionr");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmTime = UtilSql.getValue(result, "juwimm_time");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmTimer = UtilSql.getValue(result, "juwimm_timer");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmResources = UtilSql.getValue(result, "juwimm_resources");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmResourcesr = UtilSql.getValue(result, "juwimm_resourcesr");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.isactive = UtilSql.getValue(result, "isactive");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmBudget = UtilSql.getValue(result, "juwimm_budget");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmBudgetr = UtilSql.getValue(result, "juwimm_budgetr");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmTeamId = UtilSql.getValue(result, "juwimm_team_id");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmTeamIdr = UtilSql.getValue(result, "juwimm_team_idr");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmPlannedgolive = UtilSql.getDateValue(result, "juwimm_plannedgolive", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmEstgolive = UtilSql.getDateValue(result, "juwimm_estgolive", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmNextimpdate = UtilSql.getDateValue(result, "juwimm_nextimpdate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmDescription = UtilSql.getValue(result, "juwimm_description");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmPlannedstart = UtilSql.getDateValue(result, "juwimm_plannedstart", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmEststart = UtilSql.getDateValue(result, "juwimm_eststart", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMilestone1 = UtilSql.getValue(result, "juwimm_milestone1");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs1planneddate = UtilSql.getDateValue(result, "juwimm_ms1planneddate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs1estdate = UtilSql.getDateValue(result, "juwimm_ms1estdate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMilestone2 = UtilSql.getValue(result, "juwimm_milestone2");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs2planneddate = UtilSql.getDateValue(result, "juwimm_ms2planneddate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs2estdate = UtilSql.getDateValue(result, "juwimm_ms2estdate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMilestone3 = UtilSql.getValue(result, "juwimm_milestone3");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs3planneddate = UtilSql.getDateValue(result, "juwimm_ms3planneddate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs3estdate = UtilSql.getDateValue(result, "juwimm_ms3estdate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMilestone4 = UtilSql.getValue(result, "juwimm_milestone4");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs4planneddate = UtilSql.getDateValue(result, "juwimm_ms4planneddate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs4estdate = UtilSql.getDateValue(result, "juwimm_ms4estdate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMilestone5 = UtilSql.getValue(result, "juwimm_milestone5");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs5planneddate = UtilSql.getDateValue(result, "juwimm_ms5planneddate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs5estdate = UtilSql.getDateValue(result, "juwimm_ms5estdate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMilestone6 = UtilSql.getValue(result, "juwimm_milestone6");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs6planneddate = UtilSql.getDateValue(result, "juwimm_ms6planneddate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs6estdate = UtilSql.getDateValue(result, "juwimm_ms6estdate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMilestone7 = UtilSql.getValue(result, "juwimm_milestone7");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs7planneddate = UtilSql.getDateValue(result, "juwimm_ms7planneddate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmMs7estdate = UtilSql.getDateValue(result, "juwimm_ms7estdate", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmPlannedend = UtilSql.getDateValue(result, "juwimm_plannedend", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmEstend = UtilSql.getDateValue(result, "juwimm_estend", "dd-MM-yyyy");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmOuputremarks = UtilSql.getValue(result, "juwimm_ouputremarks");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmLastaction = UtilSql.getValue(result, "juwimm_lastaction");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmNextaction = UtilSql.getValue(result, "juwimm_nextaction");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmIssues = UtilSql.getValue(result, "juwimm_issues");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.juwimmDecisions = UtilSql.getValue(result, "juwimm_decisions");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.language = UtilSql.getValue(result, "language");
        objectStatus6780E60B374444A49AC7010A32FE9884Data.adUserClient = "";
        objectStatus6780E60B374444A49AC7010A32FE9884Data.adOrgClient = "";
        objectStatus6780E60B374444A49AC7010A32FE9884Data.createdby = "";
        objectStatus6780E60B374444A49AC7010A32FE9884Data.trBgcolor = "";
        objectStatus6780E60B374444A49AC7010A32FE9884Data.totalCount = "";
        objectStatus6780E60B374444A49AC7010A32FE9884Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectStatus6780E60B374444A49AC7010A32FE9884Data);
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
    Status6780E60B374444A49AC7010A32FE9884Data objectStatus6780E60B374444A49AC7010A32FE9884Data[] = new Status6780E60B374444A49AC7010A32FE9884Data[vector.size()];
    vector.copyInto(objectStatus6780E60B374444A49AC7010A32FE9884Data);
    return(objectStatus6780E60B374444A49AC7010A32FE9884Data);
  }

/**
Create a registry
 */
  public static Status6780E60B374444A49AC7010A32FE9884Data[] set(String cOrderId, String juwimmMilestone7, String juwimmMs2planneddate, String juwimmBudget, String juwimmLastaction, String juwimmMs6estdate, String juwimmMs5planneddate, String juwimmResources, String juwimmMilestone3, String juwimmMs3estdate, String juwimmCompletion, String juwimmIssues, String juwimmMs7estdate, String juwimmOrderstatusId, String juwimmMs5estdate, String adClientId, String juwimmTime, String updatedby, String updatedbyr, String juwimmOuputremarks, String isactive, String juwimmDescription, String juwimmEstend, String juwimmDecisions, String createdby, String createdbyr, String juwimmEststart, String juwimmMs4estdate, String juwimmEstgolive, String juwimmProjectman, String juwimmMs6planneddate, String juwimmMilestone1, String juwimmMilestone2, String juwimmMs3planneddate, String juwimmMs4planneddate, String juwimmPlannedend, String adOrgId, String juwimmTeamId, String juwimmMs1estdate, String juwimmNextimpdate, String juwimmMilestone6, String juwimmMs1planneddate, String juwimmPlannedgolive, String juwimmMs7planneddate, String juwimmMilestone5, String juwimmNextaction, String juwimmPlannedstart, String juwimmMs2estdate, String juwimmMilestone4)    throws ServletException {
    Status6780E60B374444A49AC7010A32FE9884Data objectStatus6780E60B374444A49AC7010A32FE9884Data[] = new Status6780E60B374444A49AC7010A32FE9884Data[1];
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0] = new Status6780E60B374444A49AC7010A32FE9884Data();
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].created = "";
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].createdbyr = createdbyr;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].updated = "";
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].updatedTimeStamp = "";
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].updatedby = updatedby;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].updatedbyr = updatedbyr;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].cOrderId = cOrderId;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmOrderstatusId = juwimmOrderstatusId;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmProjectman = juwimmProjectman;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmCompletion = juwimmCompletion;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmCompletionr = "";
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].adClientId = adClientId;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].adOrgId = adOrgId;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmTime = juwimmTime;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmTimer = "";
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmResources = juwimmResources;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmResourcesr = "";
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].isactive = isactive;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmBudget = juwimmBudget;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmBudgetr = "";
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmTeamId = juwimmTeamId;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmTeamIdr = "";
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmPlannedgolive = juwimmPlannedgolive;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmEstgolive = juwimmEstgolive;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmNextimpdate = juwimmNextimpdate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmDescription = juwimmDescription;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmPlannedstart = juwimmPlannedstart;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmEststart = juwimmEststart;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMilestone1 = juwimmMilestone1;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs1planneddate = juwimmMs1planneddate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs1estdate = juwimmMs1estdate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMilestone2 = juwimmMilestone2;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs2planneddate = juwimmMs2planneddate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs2estdate = juwimmMs2estdate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMilestone3 = juwimmMilestone3;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs3planneddate = juwimmMs3planneddate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs3estdate = juwimmMs3estdate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMilestone4 = juwimmMilestone4;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs4planneddate = juwimmMs4planneddate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs4estdate = juwimmMs4estdate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMilestone5 = juwimmMilestone5;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs5planneddate = juwimmMs5planneddate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs5estdate = juwimmMs5estdate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMilestone6 = juwimmMilestone6;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs6planneddate = juwimmMs6planneddate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs6estdate = juwimmMs6estdate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMilestone7 = juwimmMilestone7;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs7planneddate = juwimmMs7planneddate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmMs7estdate = juwimmMs7estdate;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmPlannedend = juwimmPlannedend;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmEstend = juwimmEstend;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmOuputremarks = juwimmOuputremarks;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmLastaction = juwimmLastaction;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmNextaction = juwimmNextaction;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmIssues = juwimmIssues;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].juwimmDecisions = juwimmDecisions;
    objectStatus6780E60B374444A49AC7010A32FE9884Data[0].language = "";
    return objectStatus6780E60B374444A49AC7010A32FE9884Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3107A020B4654A5B8BA3D94B27DFD73D_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef1EF30B9969DB4F4CB3B14AC79BA0178F_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT juwimm_orderstatus.C_Order_ID AS NAME" +
      "        FROM juwimm_orderstatus" +
      "        WHERE juwimm_orderstatus.Juwimm_Orderstatus_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Order left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (C_Order.C_Order_ID = table1.C_Order_ID) WHERE C_Order.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(table1.DateOrdered, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Order left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table1 on (C_Order.C_Order_ID = table1.C_Order_ID) WHERE C_Order.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
      "        UPDATE juwimm_orderstatus" +
      "        SET C_Order_ID = (?) , Juwimm_Orderstatus_ID = (?) , Juwimm_Projectman = (?) , Juwimm_Completion = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Juwimm_Time = (?) , Juwimm_Resources = (?) , Isactive = (?) , Juwimm_Budget = (?) , Juwimm_Team_ID = (?) , Juwimm_Plannedgolive = TO_DATE(?) , Juwimm_Estgolive = TO_DATE(?) , Juwimm_Nextimpdate = TO_DATE(?) , Juwimm_Description = (?) , Juwimm_Plannedstart = TO_DATE(?) , Juwimm_Eststart = TO_DATE(?) , Juwimm_Milestone1 = (?) , Juwimm_Ms1planneddate = TO_DATE(?) , Juwimm_Ms1estdate = TO_DATE(?) , Juwimm_Milestone2 = (?) , Juwimm_Ms2planneddate = TO_DATE(?) , Juwimm_Ms2estdate = TO_DATE(?) , Juwimm_Milestone3 = (?) , Juwimm_Ms3planneddate = TO_DATE(?) , Juwimm_Ms3estdate = TO_DATE(?) , Juwimm_Milestone4 = (?) , Juwimm_Ms4planneddate = TO_DATE(?) , Juwimm_Ms4estdate = TO_DATE(?) , Juwimm_Milestone5 = (?) , Juwimm_Ms5planneddate = TO_DATE(?) , Juwimm_Ms5estdate = TO_DATE(?) , Juwimm_Milestone6 = (?) , Juwimm_Ms6planneddate = TO_DATE(?) , Juwimm_Ms6estdate = TO_DATE(?) , Juwimm_Milestone7 = (?) , Juwimm_Ms7planneddate = TO_DATE(?) , Juwimm_Ms7estdate = TO_DATE(?) , Juwimm_Plannedend = TO_DATE(?) , Juwimm_Estend = TO_DATE(?) , Juwimm_Ouputremarks = (?) , Juwimm_Lastaction = (?) , Juwimm_Nextaction = (?) , Juwimm_Issues = (?) , Juwimm_Decisions = (?) , updated = now(), updatedby = ? " +
      "        WHERE juwimm_orderstatus.Juwimm_Orderstatus_ID = ? " +
      "                 AND juwimm_orderstatus.C_Order_ID = ? " +
      "        AND juwimm_orderstatus.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_orderstatus.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatusId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmProjectman);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmCompletion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmResources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmBudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextimpdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEststart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs1planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs1estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs2planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs2estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs3planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs3estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs4planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs4estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs5planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs5estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs6planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs6estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs7planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs7estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOuputremarks);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmIssues);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDecisions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatusId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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
      "        INSERT INTO juwimm_orderstatus " +
      "        (C_Order_ID, Juwimm_Orderstatus_ID, Juwimm_Projectman, Juwimm_Completion, AD_Client_ID, AD_Org_ID, Juwimm_Time, Juwimm_Resources, Isactive, Juwimm_Budget, Juwimm_Team_ID, Juwimm_Plannedgolive, Juwimm_Estgolive, Juwimm_Nextimpdate, Juwimm_Description, Juwimm_Plannedstart, Juwimm_Eststart, Juwimm_Milestone1, Juwimm_Ms1planneddate, Juwimm_Ms1estdate, Juwimm_Milestone2, Juwimm_Ms2planneddate, Juwimm_Ms2estdate, Juwimm_Milestone3, Juwimm_Ms3planneddate, Juwimm_Ms3estdate, Juwimm_Milestone4, Juwimm_Ms4planneddate, Juwimm_Ms4estdate, Juwimm_Milestone5, Juwimm_Ms5planneddate, Juwimm_Ms5estdate, Juwimm_Milestone6, Juwimm_Ms6planneddate, Juwimm_Ms6estdate, Juwimm_Milestone7, Juwimm_Ms7planneddate, Juwimm_Ms7estdate, Juwimm_Plannedend, Juwimm_Estend, Juwimm_Ouputremarks, Juwimm_Lastaction, Juwimm_Nextaction, Juwimm_Issues, Juwimm_Decisions, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatusId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmProjectman);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmCompletion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmResources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmBudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextimpdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEststart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs1planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs1estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs2planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs2estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs3planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs3estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs4planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs4estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs5planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs5estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs6planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs6estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs7planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs7estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOuputremarks);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmIssues);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDecisions);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cOrderId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM juwimm_orderstatus" +
      "        WHERE juwimm_orderstatus.Juwimm_Orderstatus_ID = ? " +
      "                 AND juwimm_orderstatus.C_Order_ID = ? " +
      "        AND juwimm_orderstatus.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_orderstatus.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cOrderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM juwimm_orderstatus" +
      "        WHERE juwimm_orderstatus.Juwimm_Orderstatus_ID = ? " +
      "                 AND juwimm_orderstatus.C_Order_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
      "          FROM juwimm_orderstatus" +
      "         WHERE juwimm_orderstatus.Juwimm_Orderstatus_ID = ? ";

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
      "          FROM juwimm_orderstatus" +
      "         WHERE juwimm_orderstatus.Juwimm_Orderstatus_ID = ? ";

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

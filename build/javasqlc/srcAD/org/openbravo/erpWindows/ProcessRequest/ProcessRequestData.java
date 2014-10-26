//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ProcessRequest;

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
class ProcessRequestData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProcessRequestData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adProcessRequestId;
  public String adOrgId;
  public String adOrgIdr;
  public String adProcessId;
  public String adProcessIdr;
  public String isactive;
  public String timingOption;
  public String timingOptionr;
  public String isrolesecurity;
  public String previousFireTime;
  public String nextFireTime;
  public String startDate;
  public String startTime;
  public String channel;
  public String frequency;
  public String frequencyr;
  public String secondlyInterval;
  public String secondlyRepetitions;
  public String minutelyInterval;
  public String minutelyRepetitions;
  public String hourlyInterval;
  public String hourlyRepetitions;
  public String dailyOption;
  public String dailyOptionr;
  public String dailyInterval;
  public String daySun;
  public String dayMon;
  public String dayTue;
  public String dayWed;
  public String dayThu;
  public String dayFri;
  public String daySat;
  public String monthlyOption;
  public String monthlyOptionr;
  public String monthlyDayOfWeek;
  public String monthlyDayOfWeekr;
  public String cron;
  public String monthlySpecificDay;
  public String finishes;
  public String finishesDate;
  public String finishesTime;
  public String schedule;
  public String reschedule;
  public String unschedule;
  public String status;
  public String statusr;
  public String adProcessSetId;
  public String scheduledFinish;
  public String description;
  public String obContext;
  public String adUserId;
  public String params;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_process_request_id") || fieldName.equals("adProcessRequestId"))
      return adProcessRequestId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("timing_option") || fieldName.equals("timingOption"))
      return timingOption;
    else if (fieldName.equalsIgnoreCase("timing_optionr") || fieldName.equals("timingOptionr"))
      return timingOptionr;
    else if (fieldName.equalsIgnoreCase("isrolesecurity"))
      return isrolesecurity;
    else if (fieldName.equalsIgnoreCase("previous_fire_time") || fieldName.equals("previousFireTime"))
      return previousFireTime;
    else if (fieldName.equalsIgnoreCase("next_fire_time") || fieldName.equals("nextFireTime"))
      return nextFireTime;
    else if (fieldName.equalsIgnoreCase("start_date") || fieldName.equals("startDate"))
      return startDate;
    else if (fieldName.equalsIgnoreCase("start_time") || fieldName.equals("startTime"))
      return startTime;
    else if (fieldName.equalsIgnoreCase("channel"))
      return channel;
    else if (fieldName.equalsIgnoreCase("frequency"))
      return frequency;
    else if (fieldName.equalsIgnoreCase("frequencyr"))
      return frequencyr;
    else if (fieldName.equalsIgnoreCase("secondly_interval") || fieldName.equals("secondlyInterval"))
      return secondlyInterval;
    else if (fieldName.equalsIgnoreCase("secondly_repetitions") || fieldName.equals("secondlyRepetitions"))
      return secondlyRepetitions;
    else if (fieldName.equalsIgnoreCase("minutely_interval") || fieldName.equals("minutelyInterval"))
      return minutelyInterval;
    else if (fieldName.equalsIgnoreCase("minutely_repetitions") || fieldName.equals("minutelyRepetitions"))
      return minutelyRepetitions;
    else if (fieldName.equalsIgnoreCase("hourly_interval") || fieldName.equals("hourlyInterval"))
      return hourlyInterval;
    else if (fieldName.equalsIgnoreCase("hourly_repetitions") || fieldName.equals("hourlyRepetitions"))
      return hourlyRepetitions;
    else if (fieldName.equalsIgnoreCase("daily_option") || fieldName.equals("dailyOption"))
      return dailyOption;
    else if (fieldName.equalsIgnoreCase("daily_optionr") || fieldName.equals("dailyOptionr"))
      return dailyOptionr;
    else if (fieldName.equalsIgnoreCase("daily_interval") || fieldName.equals("dailyInterval"))
      return dailyInterval;
    else if (fieldName.equalsIgnoreCase("day_sun") || fieldName.equals("daySun"))
      return daySun;
    else if (fieldName.equalsIgnoreCase("day_mon") || fieldName.equals("dayMon"))
      return dayMon;
    else if (fieldName.equalsIgnoreCase("day_tue") || fieldName.equals("dayTue"))
      return dayTue;
    else if (fieldName.equalsIgnoreCase("day_wed") || fieldName.equals("dayWed"))
      return dayWed;
    else if (fieldName.equalsIgnoreCase("day_thu") || fieldName.equals("dayThu"))
      return dayThu;
    else if (fieldName.equalsIgnoreCase("day_fri") || fieldName.equals("dayFri"))
      return dayFri;
    else if (fieldName.equalsIgnoreCase("day_sat") || fieldName.equals("daySat"))
      return daySat;
    else if (fieldName.equalsIgnoreCase("monthly_option") || fieldName.equals("monthlyOption"))
      return monthlyOption;
    else if (fieldName.equalsIgnoreCase("monthly_optionr") || fieldName.equals("monthlyOptionr"))
      return monthlyOptionr;
    else if (fieldName.equalsIgnoreCase("monthly_day_of_week") || fieldName.equals("monthlyDayOfWeek"))
      return monthlyDayOfWeek;
    else if (fieldName.equalsIgnoreCase("monthly_day_of_weekr") || fieldName.equals("monthlyDayOfWeekr"))
      return monthlyDayOfWeekr;
    else if (fieldName.equalsIgnoreCase("cron"))
      return cron;
    else if (fieldName.equalsIgnoreCase("monthly_specific_day") || fieldName.equals("monthlySpecificDay"))
      return monthlySpecificDay;
    else if (fieldName.equalsIgnoreCase("finishes"))
      return finishes;
    else if (fieldName.equalsIgnoreCase("finishes_date") || fieldName.equals("finishesDate"))
      return finishesDate;
    else if (fieldName.equalsIgnoreCase("finishes_time") || fieldName.equals("finishesTime"))
      return finishesTime;
    else if (fieldName.equalsIgnoreCase("schedule"))
      return schedule;
    else if (fieldName.equalsIgnoreCase("reschedule"))
      return reschedule;
    else if (fieldName.equalsIgnoreCase("unschedule"))
      return unschedule;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("statusr"))
      return statusr;
    else if (fieldName.equalsIgnoreCase("ad_process_set_id") || fieldName.equals("adProcessSetId"))
      return adProcessSetId;
    else if (fieldName.equalsIgnoreCase("scheduled_finish") || fieldName.equals("scheduledFinish"))
      return scheduledFinish;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ob_context") || fieldName.equals("obContext"))
      return obContext;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("params"))
      return params;
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
  public static ProcessRequestData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProcessRequestData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Process_Request.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process_Request.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Process_Request.Updated, ?) as updated, " +
      "        to_char(AD_Process_Request.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Process_Request.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Process_Request.UpdatedBy) as UpdatedByR," +
      "        AD_Process_Request.AD_Client_ID, " +
      "(CASE WHEN AD_Process_Request.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Process_Request.AD_Process_Request_ID, " +
      "AD_Process_Request.AD_Org_ID, " +
      "(CASE WHEN AD_Process_Request.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Process_Request.AD_Process_ID, " +
      "(CASE WHEN AD_Process_Request.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "COALESCE(AD_Process_Request.Isactive, 'N') AS Isactive, " +
      "AD_Process_Request.Timing_Option, " +
      "(CASE WHEN AD_Process_Request.Timing_Option IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Timing_OptionR, " +
      "COALESCE(AD_Process_Request.Isrolesecurity, 'N') AS Isrolesecurity, " +
      "AD_Process_Request.Previous_Fire_Time, " +
      "AD_Process_Request.Next_Fire_Time, " +
      "AD_Process_Request.Start_Date, " +
      "TO_CHAR(AD_Process_Request.Start_Time, 'HH24:MI:SS') AS Start_Time, " +
      "AD_Process_Request.Channel, " +
      "AD_Process_Request.Frequency, " +
      "(CASE WHEN AD_Process_Request.Frequency IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS FrequencyR, " +
      "AD_Process_Request.Secondly_Interval, " +
      "AD_Process_Request.Secondly_Repetitions, " +
      "AD_Process_Request.Minutely_Interval, " +
      "AD_Process_Request.Minutely_Repetitions, " +
      "AD_Process_Request.Hourly_Interval, " +
      "AD_Process_Request.Hourly_Repetitions, " +
      "AD_Process_Request.Daily_Option, " +
      "(CASE WHEN AD_Process_Request.Daily_Option IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Daily_OptionR, " +
      "AD_Process_Request.Daily_Interval, " +
      "COALESCE(AD_Process_Request.DAY_Sun, 'N') AS DAY_Sun, " +
      "COALESCE(AD_Process_Request.DAY_Mon, 'N') AS DAY_Mon, " +
      "COALESCE(AD_Process_Request.DAY_Tue, 'N') AS DAY_Tue, " +
      "COALESCE(AD_Process_Request.DAY_Wed, 'N') AS DAY_Wed, " +
      "COALESCE(AD_Process_Request.DAY_Thu, 'N') AS DAY_Thu, " +
      "COALESCE(AD_Process_Request.DAY_Fri, 'N') AS DAY_Fri, " +
      "COALESCE(AD_Process_Request.DAY_Sat, 'N') AS DAY_Sat, " +
      "AD_Process_Request.Monthly_Option, " +
      "(CASE WHEN AD_Process_Request.Monthly_Option IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS Monthly_OptionR, " +
      "AD_Process_Request.Monthly_Day_Of_Week, " +
      "(CASE WHEN AD_Process_Request.Monthly_Day_Of_Week IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS Monthly_Day_Of_WeekR, " +
      "AD_Process_Request.Cron, " +
      "AD_Process_Request.Monthly_Specific_Day, " +
      "COALESCE(AD_Process_Request.Finishes, 'N') AS Finishes, " +
      "AD_Process_Request.Finishes_Date, " +
      "TO_CHAR(AD_Process_Request.Finishes_Time, 'HH24:MI:SS') AS Finishes_Time, " +
      "AD_Process_Request.Schedule, " +
      "AD_Process_Request.Reschedule, " +
      "AD_Process_Request.Unschedule, " +
      "AD_Process_Request.Status, " +
      "(CASE WHEN AD_Process_Request.Status IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS StatusR, " +
      "AD_Process_Request.AD_Process_Set_ID, " +
      "AD_Process_Request.Scheduled_Finish, " +
      "AD_Process_Request.Description, " +
      "AD_Process_Request.OB_Context, " +
      "AD_Process_Request.AD_User_ID, " +
      "AD_Process_Request.Params, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Process_Request left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Process_Request.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Process_Request.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Process_ID, Name from AD_Process) table3 on (AD_Process_Request.AD_Process_ID = table3.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL3 on (table3.AD_Process_ID = tableTRL3.AD_Process_ID and tableTRL3.AD_Language = ?)  left join ad_ref_list_v list1 on (AD_Process_Request.Timing_Option = list1.value and list1.ad_reference_id = 'ABD8815EDEDB412C820FB94532952721' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (AD_Process_Request.Frequency = list2.value and list2.ad_reference_id = '665CE68BB382425BB43057256767B5DE' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (AD_Process_Request.Daily_Option = list3.value and list3.ad_reference_id = '21A4E92C455C432FACDC0C45372454F5' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (AD_Process_Request.Monthly_Option = list4.value and list4.ad_reference_id = '6C11958E975D4DF8A38E7F4A119A3077' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (AD_Process_Request.Monthly_Day_Of_Week = list5.value and list5.ad_reference_id = '167' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (AD_Process_Request.Status = list6.value and list6.ad_reference_id = '7DB6D4792CDC4ED297C70A4F4282A52E' and list6.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND AD_Process_Request.AD_Process_Request_ID = ? " +
      "        AND AD_Process_Request.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Process_Request.AD_Org_ID IN (";
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
        ProcessRequestData objectProcessRequestData = new ProcessRequestData();
        objectProcessRequestData.created = UtilSql.getValue(result, "created");
        objectProcessRequestData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProcessRequestData.updated = UtilSql.getValue(result, "updated");
        objectProcessRequestData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProcessRequestData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProcessRequestData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProcessRequestData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProcessRequestData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectProcessRequestData.adProcessRequestId = UtilSql.getValue(result, "ad_process_request_id");
        objectProcessRequestData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProcessRequestData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProcessRequestData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectProcessRequestData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectProcessRequestData.isactive = UtilSql.getValue(result, "isactive");
        objectProcessRequestData.timingOption = UtilSql.getValue(result, "timing_option");
        objectProcessRequestData.timingOptionr = UtilSql.getValue(result, "timing_optionr");
        objectProcessRequestData.isrolesecurity = UtilSql.getValue(result, "isrolesecurity");
        objectProcessRequestData.previousFireTime = UtilSql.getDateValue(result, "previous_fire_time", "dd-MM-yyyy");
        objectProcessRequestData.nextFireTime = UtilSql.getDateValue(result, "next_fire_time", "dd-MM-yyyy");
        objectProcessRequestData.startDate = UtilSql.getDateValue(result, "start_date", "dd-MM-yyyy");
        objectProcessRequestData.startTime = UtilSql.getValue(result, "start_time");
        objectProcessRequestData.channel = UtilSql.getValue(result, "channel");
        objectProcessRequestData.frequency = UtilSql.getValue(result, "frequency");
        objectProcessRequestData.frequencyr = UtilSql.getValue(result, "frequencyr");
        objectProcessRequestData.secondlyInterval = UtilSql.getValue(result, "secondly_interval");
        objectProcessRequestData.secondlyRepetitions = UtilSql.getValue(result, "secondly_repetitions");
        objectProcessRequestData.minutelyInterval = UtilSql.getValue(result, "minutely_interval");
        objectProcessRequestData.minutelyRepetitions = UtilSql.getValue(result, "minutely_repetitions");
        objectProcessRequestData.hourlyInterval = UtilSql.getValue(result, "hourly_interval");
        objectProcessRequestData.hourlyRepetitions = UtilSql.getValue(result, "hourly_repetitions");
        objectProcessRequestData.dailyOption = UtilSql.getValue(result, "daily_option");
        objectProcessRequestData.dailyOptionr = UtilSql.getValue(result, "daily_optionr");
        objectProcessRequestData.dailyInterval = UtilSql.getValue(result, "daily_interval");
        objectProcessRequestData.daySun = UtilSql.getValue(result, "day_sun");
        objectProcessRequestData.dayMon = UtilSql.getValue(result, "day_mon");
        objectProcessRequestData.dayTue = UtilSql.getValue(result, "day_tue");
        objectProcessRequestData.dayWed = UtilSql.getValue(result, "day_wed");
        objectProcessRequestData.dayThu = UtilSql.getValue(result, "day_thu");
        objectProcessRequestData.dayFri = UtilSql.getValue(result, "day_fri");
        objectProcessRequestData.daySat = UtilSql.getValue(result, "day_sat");
        objectProcessRequestData.monthlyOption = UtilSql.getValue(result, "monthly_option");
        objectProcessRequestData.monthlyOptionr = UtilSql.getValue(result, "monthly_optionr");
        objectProcessRequestData.monthlyDayOfWeek = UtilSql.getValue(result, "monthly_day_of_week");
        objectProcessRequestData.monthlyDayOfWeekr = UtilSql.getValue(result, "monthly_day_of_weekr");
        objectProcessRequestData.cron = UtilSql.getValue(result, "cron");
        objectProcessRequestData.monthlySpecificDay = UtilSql.getValue(result, "monthly_specific_day");
        objectProcessRequestData.finishes = UtilSql.getValue(result, "finishes");
        objectProcessRequestData.finishesDate = UtilSql.getDateValue(result, "finishes_date", "dd-MM-yyyy");
        objectProcessRequestData.finishesTime = UtilSql.getValue(result, "finishes_time");
        objectProcessRequestData.schedule = UtilSql.getValue(result, "schedule");
        objectProcessRequestData.reschedule = UtilSql.getValue(result, "reschedule");
        objectProcessRequestData.unschedule = UtilSql.getValue(result, "unschedule");
        objectProcessRequestData.status = UtilSql.getValue(result, "status");
        objectProcessRequestData.statusr = UtilSql.getValue(result, "statusr");
        objectProcessRequestData.adProcessSetId = UtilSql.getValue(result, "ad_process_set_id");
        objectProcessRequestData.scheduledFinish = UtilSql.getDateValue(result, "scheduled_finish", "dd-MM-yyyy");
        objectProcessRequestData.description = UtilSql.getValue(result, "description");
        objectProcessRequestData.obContext = UtilSql.getValue(result, "ob_context");
        objectProcessRequestData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProcessRequestData.params = UtilSql.getValue(result, "params");
        objectProcessRequestData.language = UtilSql.getValue(result, "language");
        objectProcessRequestData.adUserClient = "";
        objectProcessRequestData.adOrgClient = "";
        objectProcessRequestData.createdby = "";
        objectProcessRequestData.trBgcolor = "";
        objectProcessRequestData.totalCount = "";
        objectProcessRequestData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProcessRequestData);
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
    ProcessRequestData objectProcessRequestData[] = new ProcessRequestData[vector.size()];
    vector.copyInto(objectProcessRequestData);
    return(objectProcessRequestData);
  }

/**
Create a registry
 */
  public static ProcessRequestData[] set(String description, String monthlyDayOfWeek, String adProcessSetId, String adProcessRequestId, String timingOption, String params, String monthlySpecificDay, String dayTue, String createdby, String createdbyr, String adUserId, String nextFireTime, String reschedule, String obContext, String isrolesecurity, String unschedule, String isactive, String startTime, String secondlyRepetitions, String adOrgId, String dailyInterval, String status, String dayFri, String dailyOption, String frequency, String minutelyInterval, String scheduledFinish, String dayWed, String startDate, String daySun, String schedule, String dayMon, String daySat, String previousFireTime, String monthlyOption, String hourlyRepetitions, String dayThu, String finishes, String finishesDate, String minutelyRepetitions, String hourlyInterval, String adProcessId, String adClientId, String channel, String cron, String finishesTime, String secondlyInterval, String updatedby, String updatedbyr)    throws ServletException {
    ProcessRequestData objectProcessRequestData[] = new ProcessRequestData[1];
    objectProcessRequestData[0] = new ProcessRequestData();
    objectProcessRequestData[0].created = "";
    objectProcessRequestData[0].createdbyr = createdbyr;
    objectProcessRequestData[0].updated = "";
    objectProcessRequestData[0].updatedTimeStamp = "";
    objectProcessRequestData[0].updatedby = updatedby;
    objectProcessRequestData[0].updatedbyr = updatedbyr;
    objectProcessRequestData[0].adClientId = adClientId;
    objectProcessRequestData[0].adClientIdr = "";
    objectProcessRequestData[0].adProcessRequestId = adProcessRequestId;
    objectProcessRequestData[0].adOrgId = adOrgId;
    objectProcessRequestData[0].adOrgIdr = "";
    objectProcessRequestData[0].adProcessId = adProcessId;
    objectProcessRequestData[0].adProcessIdr = "";
    objectProcessRequestData[0].isactive = isactive;
    objectProcessRequestData[0].timingOption = timingOption;
    objectProcessRequestData[0].timingOptionr = "";
    objectProcessRequestData[0].isrolesecurity = isrolesecurity;
    objectProcessRequestData[0].previousFireTime = previousFireTime;
    objectProcessRequestData[0].nextFireTime = nextFireTime;
    objectProcessRequestData[0].startDate = startDate;
    objectProcessRequestData[0].startTime = startTime;
    objectProcessRequestData[0].channel = channel;
    objectProcessRequestData[0].frequency = frequency;
    objectProcessRequestData[0].frequencyr = "";
    objectProcessRequestData[0].secondlyInterval = secondlyInterval;
    objectProcessRequestData[0].secondlyRepetitions = secondlyRepetitions;
    objectProcessRequestData[0].minutelyInterval = minutelyInterval;
    objectProcessRequestData[0].minutelyRepetitions = minutelyRepetitions;
    objectProcessRequestData[0].hourlyInterval = hourlyInterval;
    objectProcessRequestData[0].hourlyRepetitions = hourlyRepetitions;
    objectProcessRequestData[0].dailyOption = dailyOption;
    objectProcessRequestData[0].dailyOptionr = "";
    objectProcessRequestData[0].dailyInterval = dailyInterval;
    objectProcessRequestData[0].daySun = daySun;
    objectProcessRequestData[0].dayMon = dayMon;
    objectProcessRequestData[0].dayTue = dayTue;
    objectProcessRequestData[0].dayWed = dayWed;
    objectProcessRequestData[0].dayThu = dayThu;
    objectProcessRequestData[0].dayFri = dayFri;
    objectProcessRequestData[0].daySat = daySat;
    objectProcessRequestData[0].monthlyOption = monthlyOption;
    objectProcessRequestData[0].monthlyOptionr = "";
    objectProcessRequestData[0].monthlyDayOfWeek = monthlyDayOfWeek;
    objectProcessRequestData[0].monthlyDayOfWeekr = "";
    objectProcessRequestData[0].cron = cron;
    objectProcessRequestData[0].monthlySpecificDay = monthlySpecificDay;
    objectProcessRequestData[0].finishes = finishes;
    objectProcessRequestData[0].finishesDate = finishesDate;
    objectProcessRequestData[0].finishesTime = finishesTime;
    objectProcessRequestData[0].schedule = schedule;
    objectProcessRequestData[0].reschedule = reschedule;
    objectProcessRequestData[0].unschedule = unschedule;
    objectProcessRequestData[0].status = status;
    objectProcessRequestData[0].statusr = "";
    objectProcessRequestData[0].adProcessSetId = adProcessSetId;
    objectProcessRequestData[0].scheduledFinish = scheduledFinish;
    objectProcessRequestData[0].description = description;
    objectProcessRequestData[0].obContext = obContext;
    objectProcessRequestData[0].adUserId = adUserId;
    objectProcessRequestData[0].params = params;
    objectProcessRequestData[0].language = "";
    return objectProcessRequestData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef573D452F04D1243FE040007F01012792_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef573D452F04D3243FE040007F01012792_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Process_Request" +
      "        SET AD_Client_ID = (?) , AD_Process_Request_ID = (?) , AD_Org_ID = (?) , AD_Process_ID = (?) , Isactive = (?) , Timing_Option = (?) , Isrolesecurity = (?) , Previous_Fire_Time = TO_DATE(?) , Next_Fire_Time = TO_DATE(?) , Start_Date = TO_DATE(?) , Start_Time = TO_TIMESTAMP(?,'HH24:MI:SS') , Channel = (?) , Frequency = (?) , Secondly_Interval = TO_NUMBER(?) , Secondly_Repetitions = TO_NUMBER(?) , Minutely_Interval = TO_NUMBER(?) , Minutely_Repetitions = TO_NUMBER(?) , Hourly_Interval = TO_NUMBER(?) , Hourly_Repetitions = TO_NUMBER(?) , Daily_Option = (?) , Daily_Interval = TO_NUMBER(?) , DAY_Sun = (?) , DAY_Mon = (?) , DAY_Tue = (?) , DAY_Wed = (?) , DAY_Thu = (?) , DAY_Fri = (?) , DAY_Sat = (?) , Monthly_Option = (?) , Monthly_Day_Of_Week = (?) , Cron = (?) , Monthly_Specific_Day = TO_NUMBER(?) , Finishes = (?) , Finishes_Date = TO_DATE(?) , Finishes_Time = TO_TIMESTAMP(?,'HH24:MI:SS') , Schedule = (?) , Reschedule = (?) , Unschedule = (?) , Status = (?) , AD_Process_Set_ID = (?) , Scheduled_Finish = TO_DATE(?) , Description = (?) , OB_Context = (?) , AD_User_ID = (?) , Params = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Process_Request.AD_Process_Request_ID = ? " +
      "        AND AD_Process_Request.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process_Request.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRequestId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timingOption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrolesecurity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, previousFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, channel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, frequency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondlyInterval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondlyRepetitions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, minutelyInterval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, minutelyRepetitions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourlyInterval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourlyRepetitions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dailyOption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dailyInterval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daySun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayMon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayTue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayWed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayThu);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayFri);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daySat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyOption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDayOfWeek);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cron);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlySpecificDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finishes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finishesDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finishesTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessSetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduledFinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obContext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, params);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRequestId);
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
      "        INSERT INTO AD_Process_Request " +
      "        (AD_Client_ID, AD_Process_Request_ID, AD_Org_ID, AD_Process_ID, Isactive, Timing_Option, Isrolesecurity, Previous_Fire_Time, Next_Fire_Time, Start_Date, Start_Time, Channel, Frequency, Secondly_Interval, Secondly_Repetitions, Minutely_Interval, Minutely_Repetitions, Hourly_Interval, Hourly_Repetitions, Daily_Option, Daily_Interval, DAY_Sun, DAY_Mon, DAY_Tue, DAY_Wed, DAY_Thu, DAY_Fri, DAY_Sat, Monthly_Option, Monthly_Day_Of_Week, Cron, Monthly_Specific_Day, Finishes, Finishes_Date, Finishes_Time, Schedule, Reschedule, Unschedule, Status, AD_Process_Set_ID, Scheduled_Finish, Description, OB_Context, AD_User_ID, Params, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_DATE(?), TO_TIMESTAMP(?, 'HH24:MI:SS'), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessRequestId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, timingOption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrolesecurity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, previousFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextFireTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, channel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, frequency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondlyInterval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondlyRepetitions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, minutelyInterval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, minutelyRepetitions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourlyInterval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hourlyRepetitions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dailyOption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dailyInterval);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daySun);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayMon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayTue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayWed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayThu);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayFri);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daySat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyOption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDayOfWeek);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cron);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlySpecificDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finishes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finishesDate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finishesTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unschedule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessSetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheduledFinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, obContext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, params);
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
      "        DELETE FROM AD_Process_Request" +
      "        WHERE AD_Process_Request.AD_Process_Request_ID = ? " +
      "        AND AD_Process_Request.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Process_Request.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Process_Request" +
      "        WHERE AD_Process_Request.AD_Process_Request_ID = ? ";

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
      "          FROM AD_Process_Request" +
      "         WHERE AD_Process_Request.AD_Process_Request_ID = ? ";

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
      "          FROM AD_Process_Request" +
      "         WHERE AD_Process_Request.AD_Process_Request_ID = ? ";

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

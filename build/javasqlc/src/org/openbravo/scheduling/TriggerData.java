//Sqlc generated V1.O00-1
package org.openbravo.scheduling;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;

class TriggerData implements FieldProvider {
static Logger log4j = Logger.getLogger(TriggerData.class);
  private String InitRecordNumber="0";
  public String adProcessRequestId;
  public String timingOption;
  public String startTime;
  public String startDate;
  public String frequency;
  public String secondlyInterval;
  public String secondlyRepetitions;
  public String minutelyInterval;
  public String minutelyRepetitions;
  public String hourlyInterval;
  public String hourlyRepetitions;
  public String dailyInterval;
  public String dayMon;
  public String dayTue;
  public String dayWed;
  public String dayThu;
  public String dayFri;
  public String daySat;
  public String daySun;
  public String monthlyOption;
  public String monthlySpecificDay;
  public String monthlyDayOfWeek;
  public String finishes;
  public String finishesTime;
  public String finishesDate;
  public String dailyOption;
  public String cron;
  public String description;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_process_request_id") || fieldName.equals("adProcessRequestId"))
      return adProcessRequestId;
    else if (fieldName.equalsIgnoreCase("timing_option") || fieldName.equals("timingOption"))
      return timingOption;
    else if (fieldName.equalsIgnoreCase("start_time") || fieldName.equals("startTime"))
      return startTime;
    else if (fieldName.equalsIgnoreCase("start_date") || fieldName.equals("startDate"))
      return startDate;
    else if (fieldName.equalsIgnoreCase("frequency"))
      return frequency;
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
    else if (fieldName.equalsIgnoreCase("daily_interval") || fieldName.equals("dailyInterval"))
      return dailyInterval;
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
    else if (fieldName.equalsIgnoreCase("day_sun") || fieldName.equals("daySun"))
      return daySun;
    else if (fieldName.equalsIgnoreCase("monthly_option") || fieldName.equals("monthlyOption"))
      return monthlyOption;
    else if (fieldName.equalsIgnoreCase("monthly_specific_day") || fieldName.equals("monthlySpecificDay"))
      return monthlySpecificDay;
    else if (fieldName.equalsIgnoreCase("monthly_day_of_week") || fieldName.equals("monthlyDayOfWeek"))
      return monthlyDayOfWeek;
    else if (fieldName.equalsIgnoreCase("finishes"))
      return finishes;
    else if (fieldName.equalsIgnoreCase("finishes_time") || fieldName.equals("finishesTime"))
      return finishesTime;
    else if (fieldName.equalsIgnoreCase("finishes_date") || fieldName.equals("finishesDate"))
      return finishesDate;
    else if (fieldName.equalsIgnoreCase("daily_option") || fieldName.equals("dailyOption"))
      return dailyOption;
    else if (fieldName.equalsIgnoreCase("cron"))
      return cron;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static TriggerData select(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      	SELECT AD_Process_Request_ID, Timing_Option, TO_CHAR(Start_Time, 'HH24:MI:SS') AS Start_Time, Start_Date, " +
      "      	Frequency, Secondly_Interval, Secondly_Repetitions, Minutely_Interval, Minutely_Repetitions," +
      "      	Hourly_Interval, Hourly_Repetitions, Daily_Interval, Day_Mon, Day_Tue, " +
      "      	Day_Wed, Day_Thu, Day_Fri, Day_Sat, Day_Sun, Monthly_Option, Monthly_Specific_Day, " +
      "      	Monthly_Day_Of_Week, Finishes, TO_CHAR(Finishes_Time, 'HH24:MI:SS') AS Finishes_Time, Finishes_Date, " +
      "      	Daily_Option, Cron, Description	 " +
      "      	FROM AD_Process_Request" +
      "      	WHERE AD_Process_Request_ID = ?";

    ResultSet result;
    TriggerData objectTriggerData = new TriggerData();
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        objectTriggerData.adProcessRequestId = UtilSql.getValue(result, "ad_process_request_id");
        objectTriggerData.timingOption = UtilSql.getValue(result, "timing_option");
        objectTriggerData.startTime = UtilSql.getValue(result, "start_time");
        objectTriggerData.startDate = UtilSql.getDateValue(result, "start_date", "dd-MM-yyyy");
        objectTriggerData.frequency = UtilSql.getValue(result, "frequency");
        objectTriggerData.secondlyInterval = UtilSql.getValue(result, "secondly_interval");
        objectTriggerData.secondlyRepetitions = UtilSql.getValue(result, "secondly_repetitions");
        objectTriggerData.minutelyInterval = UtilSql.getValue(result, "minutely_interval");
        objectTriggerData.minutelyRepetitions = UtilSql.getValue(result, "minutely_repetitions");
        objectTriggerData.hourlyInterval = UtilSql.getValue(result, "hourly_interval");
        objectTriggerData.hourlyRepetitions = UtilSql.getValue(result, "hourly_repetitions");
        objectTriggerData.dailyInterval = UtilSql.getValue(result, "daily_interval");
        objectTriggerData.dayMon = UtilSql.getValue(result, "day_mon");
        objectTriggerData.dayTue = UtilSql.getValue(result, "day_tue");
        objectTriggerData.dayWed = UtilSql.getValue(result, "day_wed");
        objectTriggerData.dayThu = UtilSql.getValue(result, "day_thu");
        objectTriggerData.dayFri = UtilSql.getValue(result, "day_fri");
        objectTriggerData.daySat = UtilSql.getValue(result, "day_sat");
        objectTriggerData.daySun = UtilSql.getValue(result, "day_sun");
        objectTriggerData.monthlyOption = UtilSql.getValue(result, "monthly_option");
        objectTriggerData.monthlySpecificDay = UtilSql.getValue(result, "monthly_specific_day");
        objectTriggerData.monthlyDayOfWeek = UtilSql.getValue(result, "monthly_day_of_week");
        objectTriggerData.finishes = UtilSql.getValue(result, "finishes");
        objectTriggerData.finishesTime = UtilSql.getValue(result, "finishes_time");
        objectTriggerData.finishesDate = UtilSql.getDateValue(result, "finishes_date", "dd-MM-yyyy");
        objectTriggerData.dailyOption = UtilSql.getValue(result, "daily_option");
        objectTriggerData.cron = UtilSql.getValue(result, "cron");
        objectTriggerData.description = UtilSql.getValue(result, "description");
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
    return(objectTriggerData);
  }
}

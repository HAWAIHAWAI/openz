//Sqlc generated V1.O00-1
package org.openz.controller.manualTabPane;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class ProjecttaskHRPlanData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjecttaskHRPlanData.class);
  private String InitRecordNumber="0";
  public String zspmPtaskhrplanId;
  public String cSalaryCategoryId;
  public String quantity;
  public String adUserId;
  public String overtimehours;
  public String nighthours;
  public String saturday;
  public String sunday;
  public String holiday;
  public String plannedamt;
  public String planndedpercent;
  public String preselected;
  public String uname;
  public String cname;
  public String specialtime1;
  public String specialtime2;
  public String triggeramt;
  public String datefrom;
  public String dateto;
  public String seqno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("zspm_ptaskhrplan_id") || fieldName.equals("zspmPtaskhrplanId"))
      return zspmPtaskhrplanId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("overtimehours"))
      return overtimehours;
    else if (fieldName.equalsIgnoreCase("nighthours"))
      return nighthours;
    else if (fieldName.equalsIgnoreCase("saturday"))
      return saturday;
    else if (fieldName.equalsIgnoreCase("sunday"))
      return sunday;
    else if (fieldName.equalsIgnoreCase("holiday"))
      return holiday;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("planndedpercent"))
      return planndedpercent;
    else if (fieldName.equalsIgnoreCase("preselected"))
      return preselected;
    else if (fieldName.equalsIgnoreCase("uname"))
      return uname;
    else if (fieldName.equalsIgnoreCase("cname"))
      return cname;
    else if (fieldName.equalsIgnoreCase("specialtime1"))
      return specialtime1;
    else if (fieldName.equalsIgnoreCase("specialtime2"))
      return specialtime2;
    else if (fieldName.equalsIgnoreCase("triggeramt"))
      return triggeramt;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProjecttaskHRPlanData[] select(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return select(connectionProvider, projecttaskid, 0, 0);
  }

  public static ProjecttaskHRPlanData[] select(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select p.ZSPM_PTASKHRPLAN_ID, p.C_SALARY_CATEGORY_ID, p.QUANTITY," +
      "	       p.EMPLOYEE_ID as ad_user_id, p.OVERTIMEHOURS, p.NIGHTHOURS, p.SATURDAY," +
      "	       p.SUNDAY, p.HOLIDAY, p.PLANNEDAMT, p.PLANNDEDPERCENT , 'N' as preselected," +
      "	       u.name as uname,c.name as cname, p.specialtime1, p.specialtime2, p.triggeramt ,p.datefrom,p.dateto," +
      "	       row_number() OVER (ORDER BY c.name,u.name,ZSPM_PTASKHRPLAN_ID) as seqno" +
      "        from ZSPM_PTASKHRPLAN p left join ad_user u on u.ad_user_id=p.employee_id, C_SALARY_CATEGORY c" +
      "        where c.C_SALARY_CATEGORY_ID= p.C_SALARY_CATEGORY_ID and" +
      "             p.C_PROJECTTASK_ID = ?" +
      "        order by cname,uname";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);

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
        ProjecttaskHRPlanData objectProjecttaskHRPlanData = new ProjecttaskHRPlanData();
        objectProjecttaskHRPlanData.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectProjecttaskHRPlanData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectProjecttaskHRPlanData.quantity = UtilSql.getValue(result, "quantity");
        objectProjecttaskHRPlanData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProjecttaskHRPlanData.overtimehours = UtilSql.getValue(result, "overtimehours");
        objectProjecttaskHRPlanData.nighthours = UtilSql.getValue(result, "nighthours");
        objectProjecttaskHRPlanData.saturday = UtilSql.getValue(result, "saturday");
        objectProjecttaskHRPlanData.sunday = UtilSql.getValue(result, "sunday");
        objectProjecttaskHRPlanData.holiday = UtilSql.getValue(result, "holiday");
        objectProjecttaskHRPlanData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectProjecttaskHRPlanData.planndedpercent = UtilSql.getValue(result, "planndedpercent");
        objectProjecttaskHRPlanData.preselected = UtilSql.getValue(result, "preselected");
        objectProjecttaskHRPlanData.uname = UtilSql.getValue(result, "uname");
        objectProjecttaskHRPlanData.cname = UtilSql.getValue(result, "cname");
        objectProjecttaskHRPlanData.specialtime1 = UtilSql.getValue(result, "specialtime1");
        objectProjecttaskHRPlanData.specialtime2 = UtilSql.getValue(result, "specialtime2");
        objectProjecttaskHRPlanData.triggeramt = UtilSql.getValue(result, "triggeramt");
        objectProjecttaskHRPlanData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectProjecttaskHRPlanData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectProjecttaskHRPlanData.seqno = UtilSql.getValue(result, "seqno");
        objectProjecttaskHRPlanData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjecttaskHRPlanData);
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
    ProjecttaskHRPlanData objectProjecttaskHRPlanData[] = new ProjecttaskHRPlanData[vector.size()];
    vector.copyInto(objectProjecttaskHRPlanData);
    return(objectProjecttaskHRPlanData);
  }

  public static ProjecttaskHRPlanData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return selectnew(connectionProvider, projecttaskid, 0, 0);
  }

  public static ProjecttaskHRPlanData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select ZSPM_PTASKHRPLAN_ID, C_SALARY_CATEGORY_ID, QUANTITY," +
      "           ad_user_id, OVERTIMEHOURS, NIGHTHOURS, SATURDAY," +
      "           SUNDAY, HOLIDAY, PLANNEDAMT, PLANNDEDPERCENT, specialtime1,specialtime2, triggeramt,preselected , datefrom,dateto," +
      "           row_number() OVER (ORDER BY preselected desc, cname,uname,ZSPM_PTASKHRPLAN_ID) as seqno" +
      "      FROM (" +
      "      select get_uuid() as ZSPM_PTASKHRPLAN_ID, null as C_SALARY_CATEGORY_ID, " +
      "       0 as QUANTITY, null as ad_user_id, 0 as OVERTIMEHOURS,0 as  NIGHTHOURS, 0 as SATURDAY," +
      "       0 as SUNDAY,0 as  HOLIDAY, 0 as PLANNEDAMT, 0 as PLANNDEDPERCENT , 0 as specialtime1, 0 as specialtime2, 0 as triggeramt, 'Y' as preselected," +
      "       '' as cname,'' as uname,null as datefrom,null as dateto" +
      "      from dual" +
      "      UNION" +
      "      select p.ZSPM_PTASKHRPLAN_ID, p.C_SALARY_CATEGORY_ID, p.QUANTITY," +
      "           p.EMPLOYEE_ID as ad_user_id, p.OVERTIMEHOURS, p.NIGHTHOURS, p.SATURDAY," +
      "           p.SUNDAY, p.HOLIDAY, p.PLANNEDAMT, p.PLANNDEDPERCENT, p.specialtime1,p.specialtime2, p.triggeramt , 'N' as preselected," +
      "           u.name as uname,c.name as cname,p.datefrom,p.dateto" +
      "        from ZSPM_PTASKHRPLAN p left join ad_user u on u.ad_user_id=p.employee_id, C_SALARY_CATEGORY c" +
      "        where c.C_SALARY_CATEGORY_ID= p.C_SALARY_CATEGORY_ID and" +
      "             p.C_PROJECTTASK_ID = ?" +
      "        ) a order by preselected desc, cname,uname";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);

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
        ProjecttaskHRPlanData objectProjecttaskHRPlanData = new ProjecttaskHRPlanData();
        objectProjecttaskHRPlanData.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectProjecttaskHRPlanData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectProjecttaskHRPlanData.quantity = UtilSql.getValue(result, "quantity");
        objectProjecttaskHRPlanData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProjecttaskHRPlanData.overtimehours = UtilSql.getValue(result, "overtimehours");
        objectProjecttaskHRPlanData.nighthours = UtilSql.getValue(result, "nighthours");
        objectProjecttaskHRPlanData.saturday = UtilSql.getValue(result, "saturday");
        objectProjecttaskHRPlanData.sunday = UtilSql.getValue(result, "sunday");
        objectProjecttaskHRPlanData.holiday = UtilSql.getValue(result, "holiday");
        objectProjecttaskHRPlanData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectProjecttaskHRPlanData.planndedpercent = UtilSql.getValue(result, "planndedpercent");
        objectProjecttaskHRPlanData.specialtime1 = UtilSql.getValue(result, "specialtime1");
        objectProjecttaskHRPlanData.specialtime2 = UtilSql.getValue(result, "specialtime2");
        objectProjecttaskHRPlanData.triggeramt = UtilSql.getValue(result, "triggeramt");
        objectProjecttaskHRPlanData.preselected = UtilSql.getValue(result, "preselected");
        objectProjecttaskHRPlanData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectProjecttaskHRPlanData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectProjecttaskHRPlanData.seqno = UtilSql.getValue(result, "seqno");
        objectProjecttaskHRPlanData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjecttaskHRPlanData);
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
    ProjecttaskHRPlanData objectProjecttaskHRPlanData[] = new ProjecttaskHRPlanData[vector.size()];
    vector.copyInto(objectProjecttaskHRPlanData);
    return(objectProjecttaskHRPlanData);
  }

  public static ProjecttaskHRPlanData[] set()    throws ServletException {
    ProjecttaskHRPlanData objectProjecttaskHRPlanData[] = new ProjecttaskHRPlanData[1];
    objectProjecttaskHRPlanData[0] = new ProjecttaskHRPlanData();
    objectProjecttaskHRPlanData[0].zspmPtaskhrplanId = "";
    objectProjecttaskHRPlanData[0].cSalaryCategoryId = "";
    objectProjecttaskHRPlanData[0].quantity = "";
    objectProjecttaskHRPlanData[0].adUserId = "";
    objectProjecttaskHRPlanData[0].overtimehours = "";
    objectProjecttaskHRPlanData[0].nighthours = "";
    objectProjecttaskHRPlanData[0].saturday = "";
    objectProjecttaskHRPlanData[0].sunday = "";
    objectProjecttaskHRPlanData[0].holiday = "";
    objectProjecttaskHRPlanData[0].plannedamt = "";
    objectProjecttaskHRPlanData[0].planndedpercent = "";
    objectProjecttaskHRPlanData[0].specialtime1 = "";
    objectProjecttaskHRPlanData[0].specialtime2 = "";
    objectProjecttaskHRPlanData[0].triggeramt = "";
    objectProjecttaskHRPlanData[0].preselected = "";
    objectProjecttaskHRPlanData[0].datefrom = "";
    objectProjecttaskHRPlanData[0].dateto = "";
    objectProjecttaskHRPlanData[0].seqno = "";
    return objectProjecttaskHRPlanData;
  }

  public static String getSalCategory(ConnectionProvider connectionProvider, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT min(b.C_Salary_Category_id) " +
      "       from c_bpartner b,C_Salary_Category s WHERE b.C_Salary_Category_id=s.C_Salary_Category_id " +
      "            and b.c_bpartner_id =  (select c_bpartner_id from ad_user where ad_user_id= ? ) " +
      "            AND s.isactive='Y'" +
      "            AND exists (select 0 from C_Salary_Category_cost c where c.C_Salary_Category_id=s.C_Salary_Category_id " +
      "                         and c.COSTUOM='H')";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "min");
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

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String idValue, String adOrgId, String projecttaskId, String createdby, String salcategoryId, String quantity, String userId, String overtimehours, String nighthours, String saturday, String sunday, String holiday, String specialtime1, String specialtime2, String triggeramt, String datefrom, String dateformat, String dateto)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO ZSPM_PTASKHRPLAN(ZSPM_PTASKHRPLAN_id, AD_CLIENT_ID,AD_ORG_ID, C_PROJECTTASK_ID, CREATEDBY, UPDATEDBY, C_SALARY_CATEGORY_ID, QUANTITY, COSTUOM, EMPLOYEE_ID," +
      "                    overtimehours,nighthours,saturday,sunday,holiday,specialtime1,specialtime2, triggeramt,datefrom,dateto)" +
      "      VALUES(?, 'C726FEC915A54A0995C568555DA5BB3C', ?, ?, ?, ?, ?, to_number(?), 'H' , ?,to_number(?),to_number(?),to_number(?),to_number(?),to_number(?),to_number(?),to_number(?),to_number(?)," +
      "             to_timestamp(?,?),to_timestamp(?,?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, idValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtimehours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nighthours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, saturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, holiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateformat);

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

  public static int update(Connection conn, ConnectionProvider connectionProvider, String updatedby, String salcategoryId, String quantity, String userId, String overtimehours, String nighthours, String saturday, String sunday, String holiday, String specialtime1, String specialtime2, String triggeramt, String datefrom, String dateformat, String dateto, String planId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE ZSPM_PTASKHRPLAN SET UPDATEDBY=?, C_SALARY_CATEGORY_ID=?, QUANTITY=to_number(?), EMPLOYEE_ID=?," +
      "             overtimehours=to_number(?),nighthours=to_number(?),saturday=to_number(?),sunday=to_number(?),holiday=to_number(?),specialtime1=to_number(?),specialtime2=to_number(?),triggeramt=to_number(?)," +
      "             datefrom=to_timestamp(?,?), dateto=to_timestamp(?,?)" +
      "      WHERE ZSPM_PTASKHRPLAN_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtimehours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nighthours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, saturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, holiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planId);

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

  public static int delete(Connection conn, ConnectionProvider connectionProvider, String planId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       delete from ZSPM_PTASKHRPLAN where ZSPM_PTASKHRPLAN_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planId);

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

  public static String isExistingID(ConnectionProvider connectionProvider, String planId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select count(*) from ZSPM_PTASKHRPLAN where ZSPM_PTASKHRPLAN_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String isExistingEmployee(ConnectionProvider connectionProvider, String pTaskId, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(*) from ZSPM_PTASKHRPLAN where c_projecttask_id = ? and employee_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String getUsername(ConnectionProvider connectionProvider, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT name from ad_user where ad_user_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

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
}

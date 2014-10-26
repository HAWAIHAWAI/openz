//Sqlc generated V1.O00-1
package org.openz.controller.popup;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ResourcePlanUpdateData implements FieldProvider {
static Logger log4j = Logger.getLogger(ResourcePlanUpdateData.class);
  private String InitRecordNumber="0";
  public String cProjecttaskId;
  public String employeeId;
  public String datefrom;
  public String dateto;
  public String cSalaryCategoryId;
  public String zspmPtaskhrplanId;
  public String zspmPtaskmachineplanId;
  public String preselected;
  public String quantity;
  public String costuom;
  public String maMachineId;
  public String cname;
  public String uname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("employee_id") || fieldName.equals("employeeId"))
      return employeeId;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskhrplan_id") || fieldName.equals("zspmPtaskhrplanId"))
      return zspmPtaskhrplanId;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskmachineplan_id") || fieldName.equals("zspmPtaskmachineplanId"))
      return zspmPtaskmachineplanId;
    else if (fieldName.equalsIgnoreCase("preselected"))
      return preselected;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("cname"))
      return cname;
    else if (fieldName.equalsIgnoreCase("uname"))
      return uname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ResourcePlanUpdateData[] selectemp(ConnectionProvider connectionProvider, String parTaskID)    throws ServletException {
    return selectemp(connectionProvider, parTaskID, 0, 0);
  }

  public static ResourcePlanUpdateData[] selectemp(ConnectionProvider connectionProvider, String parTaskID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select h.c_projecttask_id,h.employee_id,h.datefrom,h.dateto,h.c_salary_category_id,h.zspm_ptaskhrplan_id,'' as zspm_ptaskmachineplan_id,'N' as preselected," +
      "             '' as quantity, '' as costuom,'' as ma_machine_id ,'' as cname,'' as uname " +
      "      from zspm_ptaskhrplan h ,c_projecttask t,ad_user u,C_SALARY_CATEGORY c" +
      "      where t.c_projecttask_id=h.c_projecttask_id and" +
      "            u.ad_user_id=h.employee_id and" +
      "            c.C_SALARY_CATEGORY_ID= h.C_SALARY_CATEGORY_ID  and" +
      "            t.c_projecttask_id = ? " +
      "            order by c.name,u.name";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaskID);

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
        ResourcePlanUpdateData objectResourcePlanUpdateData = new ResourcePlanUpdateData();
        objectResourcePlanUpdateData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectResourcePlanUpdateData.employeeId = UtilSql.getValue(result, "employee_id");
        objectResourcePlanUpdateData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectResourcePlanUpdateData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectResourcePlanUpdateData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectResourcePlanUpdateData.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectResourcePlanUpdateData.zspmPtaskmachineplanId = UtilSql.getValue(result, "zspm_ptaskmachineplan_id");
        objectResourcePlanUpdateData.preselected = UtilSql.getValue(result, "preselected");
        objectResourcePlanUpdateData.quantity = UtilSql.getValue(result, "quantity");
        objectResourcePlanUpdateData.costuom = UtilSql.getValue(result, "costuom");
        objectResourcePlanUpdateData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectResourcePlanUpdateData.cname = UtilSql.getValue(result, "cname");
        objectResourcePlanUpdateData.uname = UtilSql.getValue(result, "uname");
        objectResourcePlanUpdateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResourcePlanUpdateData);
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
    ResourcePlanUpdateData objectResourcePlanUpdateData[] = new ResourcePlanUpdateData[vector.size()];
    vector.copyInto(objectResourcePlanUpdateData);
    return(objectResourcePlanUpdateData);
  }

  public static ResourcePlanUpdateData[] selectempnew(ConnectionProvider connectionProvider, String parTaskID)    throws ServletException {
    return selectempnew(connectionProvider, parTaskID, 0, 0);
  }

  public static ResourcePlanUpdateData[] selectempnew(ConnectionProvider connectionProvider, String parTaskID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select c_projecttask_id,employee_id,datefrom,dateto,c_salary_category_id,zspm_ptaskhrplan_id,preselected from " +
      "            (" +
      "            select ? as c_projecttask_id, null as employee_id,null as datefrom,null as dateto, null as c_salary_category_id,get_uuid() as  zspm_ptaskhrplan_id,'Y' as preselected, '' as cname,'' as uname from dual" +
      "            union" +
      "            select h.c_projecttask_id,h.employee_id,h.datefrom,h.dateto,h.c_salary_category_id,h.zspm_ptaskhrplan_id,'N' as preselected,c.name as cname,u.name as uname" +
      "               from zspm_ptaskhrplan h ,c_projecttask t,ad_user u,C_SALARY_CATEGORY c" +
      "            where t.c_projecttask_id=h.c_projecttask_id and" +
      "            u.ad_user_id=h.employee_id and" +
      "            c.C_SALARY_CATEGORY_ID= h.C_SALARY_CATEGORY_ID  and" +
      "            t.c_projecttask_id = ?    " +
      "            ) a  order by preselected desc,cname,uname";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaskID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaskID);

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
        ResourcePlanUpdateData objectResourcePlanUpdateData = new ResourcePlanUpdateData();
        objectResourcePlanUpdateData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectResourcePlanUpdateData.employeeId = UtilSql.getValue(result, "employee_id");
        objectResourcePlanUpdateData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectResourcePlanUpdateData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectResourcePlanUpdateData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectResourcePlanUpdateData.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectResourcePlanUpdateData.preselected = UtilSql.getValue(result, "preselected");
        objectResourcePlanUpdateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResourcePlanUpdateData);
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
    ResourcePlanUpdateData objectResourcePlanUpdateData[] = new ResourcePlanUpdateData[vector.size()];
    vector.copyInto(objectResourcePlanUpdateData);
    return(objectResourcePlanUpdateData);
  }

  public static ResourcePlanUpdateData[] selectmachine(ConnectionProvider connectionProvider, String parTaskID)    throws ServletException {
    return selectmachine(connectionProvider, parTaskID, 0, 0);
  }

  public static ResourcePlanUpdateData[] selectmachine(ConnectionProvider connectionProvider, String parTaskID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select h.c_projecttask_id,h.ma_machine_id,h.datefrom,h.dateto,h.quantity,h.costuom,h.zspm_ptaskmachineplan_id" +
      "             from zspm_ptaskmachineplan h ,c_projecttask t" +
      "      where t.c_projecttask_id=h.c_projecttask_id and t.c_projecttask_id = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaskID);

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
        ResourcePlanUpdateData objectResourcePlanUpdateData = new ResourcePlanUpdateData();
        objectResourcePlanUpdateData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectResourcePlanUpdateData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectResourcePlanUpdateData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectResourcePlanUpdateData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectResourcePlanUpdateData.quantity = UtilSql.getValue(result, "quantity");
        objectResourcePlanUpdateData.costuom = UtilSql.getValue(result, "costuom");
        objectResourcePlanUpdateData.zspmPtaskmachineplanId = UtilSql.getValue(result, "zspm_ptaskmachineplan_id");
        objectResourcePlanUpdateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResourcePlanUpdateData);
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
    ResourcePlanUpdateData objectResourcePlanUpdateData[] = new ResourcePlanUpdateData[vector.size()];
    vector.copyInto(objectResourcePlanUpdateData);
    return(objectResourcePlanUpdateData);
  }

  public static ResourcePlanUpdateData[] selectmachinenew(ConnectionProvider connectionProvider, String parTaskID)    throws ServletException {
    return selectmachinenew(connectionProvider, parTaskID, 0, 0);
  }

  public static ResourcePlanUpdateData[] selectmachinenew(ConnectionProvider connectionProvider, String parTaskID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select c_projecttask_id,ma_machine_id,datefrom,dateto,quantity,costuom,zspm_ptaskmachineplan_id,preselected from" +
      "      (" +
      "      select ? as c_projecttask_id,null as ma_machine_id,null as datefrom,null as dateto,null as quantity,null as costuom,get_uuid() as zspm_ptaskmachineplan_id,'Y' as preselected" +
      "             from dual" +
      "      union" +
      "      select h.c_projecttask_id,h.ma_machine_id,h.datefrom,h.dateto,h.quantity,h.costuom,h.zspm_ptaskmachineplan_id,'N' as preselected" +
      "             from zspm_ptaskmachineplan h ,c_projecttask t" +
      "      where t.c_projecttask_id=h.c_projecttask_id and t.c_projecttask_id = ? " +
      "      ) a order by preselected desc";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaskID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parTaskID);

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
        ResourcePlanUpdateData objectResourcePlanUpdateData = new ResourcePlanUpdateData();
        objectResourcePlanUpdateData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectResourcePlanUpdateData.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectResourcePlanUpdateData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectResourcePlanUpdateData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectResourcePlanUpdateData.quantity = UtilSql.getValue(result, "quantity");
        objectResourcePlanUpdateData.costuom = UtilSql.getValue(result, "costuom");
        objectResourcePlanUpdateData.zspmPtaskmachineplanId = UtilSql.getValue(result, "zspm_ptaskmachineplan_id");
        objectResourcePlanUpdateData.preselected = UtilSql.getValue(result, "preselected");
        objectResourcePlanUpdateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResourcePlanUpdateData);
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
    ResourcePlanUpdateData objectResourcePlanUpdateData[] = new ResourcePlanUpdateData[vector.size()];
    vector.copyInto(objectResourcePlanUpdateData);
    return(objectResourcePlanUpdateData);
  }

  public static String isEmployee(ConnectionProvider connectionProvider, String parPlanEntry)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select case when count(*)=1 then 'Y' else 'N' end as returnvalue from zspm_ptaskhrplan where zspm_ptaskhrplan_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "returnvalue");
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

  public static String selectPTaskId(ConnectionProvider connectionProvider, String parPlanEntry)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select h.c_projecttask_id" +
      "             from zspm_ptaskhrplan h ,c_projecttask t" +
      "       where t.c_projecttask_id=h.c_projecttask_id and h.zspm_ptaskhrplan_id = ?" +
      "       union" +
      "       select h.c_projecttask_id" +
      "             from zspm_ptaskmachineplan h ,c_projecttask t" +
      "       where t.c_projecttask_id=h.c_projecttask_id and h.zspm_ptaskmachineplan_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_projecttask_id");
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

  public static String getEmployee(ConnectionProvider connectionProvider, String parPlanEntry)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     select employee_id from zspm_ptaskhrplan where zspm_ptaskhrplan_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "employee_id");
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

  public static String getMachine(ConnectionProvider connectionProvider, String parPlanEntry)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     select ma_machine_id from zspm_ptaskmachineplan where zspm_ptaskmachineplan_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ma_machine_id");
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

  public static String selectPTaskDateTo(ConnectionProvider connectionProvider, String parDateFormat, String parPlanEntry)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     select  to_char(enddate,?) from c_projecttask  where c_projecttask_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "to_char");
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

  public static String selectPTaskDateFrom(ConnectionProvider connectionProvider, String parDateFormat, String parPlanEntry)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     select to_char(startdate,?) from c_projecttask  where c_projecttask_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "to_char");
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

  public static String delete(ConnectionProvider connectionProvider, String parPlanEntry)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select zssi_deleteResourceTaskEntry(?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_deleteresourcetaskentry");
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

  public static String updateTaskDates(ConnectionProvider connectionProvider, String parPTask, String parDateFrom, String parDateFormat, String parDateTo)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select zssi_updateTaskDates(?,to_date(?,?),to_date(?,?))";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPTask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFormat);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_updatetaskdates");
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

  public static String updateOrInsert(ConnectionProvider connectionProvider, String parPlanEntry, String parPTask, String parResource, String parDateFrom, String parDateFormat, String parDateTo, String paruser, String parSalcategory, String parCostUOM, String parQty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select zssi_updateOrInsertResourceTaskEntry(?,?,?,to_date(?,?),to_date(?,?),?,?,?,to_number(?))";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPlanEntry);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parPTask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parResource);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paruser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parSalcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parCostUOM);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parQty);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_updateorinsertresourcetaskentry");
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

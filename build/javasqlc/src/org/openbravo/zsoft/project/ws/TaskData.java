//Sqlc generated V1.O00-1
package org.openbravo.zsoft.project.ws;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class TaskData implements FieldProvider {
static Logger log4j = Logger.getLogger(TaskData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static TaskData[] select(ConnectionProvider connectionProvider, String projectPhaseID)    throws ServletException {
    return select(connectionProvider, projectPhaseID, 0, 0);
  }

  public static TaskData[] select(ConnectionProvider connectionProvider, String projectPhaseID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT c_projecttask_id as id,name" +
      "              FROM C_PROJECTTASK " +
      "             WHERE C_PROJECTPHASE_id = ? and taskbegun = 'Y' and iscomplete = 'N'" +
      "                   and Istaskcancelled = 'N'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectPhaseID);

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
        TaskData objectTaskData = new TaskData();
        objectTaskData.id = UtilSql.getValue(result, "id");
        objectTaskData.name = UtilSql.getValue(result, "name");
        objectTaskData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTaskData);
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
    TaskData objectTaskData[] = new TaskData[vector.size()];
    vector.copyInto(objectTaskData);
    return(objectTaskData);
  }
}

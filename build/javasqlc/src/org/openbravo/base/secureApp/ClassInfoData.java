//Sqlc generated V1.O00-1
package org.openbravo.base.secureApp;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class ClassInfoData implements FieldProvider {
static Logger log4j = Logger.getLogger(ClassInfoData.class);
  private String InitRecordNumber="0";
  public String type;
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ClassInfoData[] select(ConnectionProvider connectionProvider, String className)    throws ServletException {
    return select(connectionProvider, className, 0, 0);
  }

  public static ClassInfoData[] select(ConnectionProvider connectionProvider, String className, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MO.ACTION AS TYPE, (CASE MO.ACTION WHEN 'X' THEN MO.AD_FORM_ID " +
      "                              WHEN 'P' THEN MO.AD_PROCESS_ID " +
      "                              WHEN 'R' THEN MO.AD_PROCESS_ID " +
      "                              WHEN 'T' THEN MO.AD_TASK_ID " +
      "                              WHEN 'S' THEN MO.AD_REFERENCE_ID" +
      "                              WHEN 'F' THEN MO.AD_WORKFLOW_ID " +
      "                              WHEN 'C' THEN MO.AD_CALLOUT_ID " +
      "                              ELSE MO.AD_TAB_ID END) AS ID, " +
      "        m.name AS NAME /*Name is only maintained for backwards compatibility, now REPORT_TITLE is automatically filled*/" +
      "        FROM AD_MODEL_OBJECT MO " +
      "             left join AD_Menu m on MO.ad_process_id = m.ad_process_id " +
      "                                  AND MO.action in ('P', 'R')" +
      "                                  AND m.action in ('P', 'R')" +
      "        WHERE MO.ClassName = ?" +
      "        AND MO.IsDefault = 'Y'" +
      "        AND MO.IsActive = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, className);

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
        ClassInfoData objectClassInfoData = new ClassInfoData();
        objectClassInfoData.type = UtilSql.getValue(result, "type");
        objectClassInfoData.id = UtilSql.getValue(result, "id");
        objectClassInfoData.name = UtilSql.getValue(result, "name");
        objectClassInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectClassInfoData);
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
    ClassInfoData objectClassInfoData[] = new ClassInfoData[vector.size()];
    vector.copyInto(objectClassInfoData);
    return(objectClassInfoData);
  }

  public static ClassInfoData[] set()    throws ServletException {
    ClassInfoData objectClassInfoData[] = new ClassInfoData[1];
    objectClassInfoData[0] = new ClassInfoData();
    objectClassInfoData[0].type = "";
    objectClassInfoData[0].id = "";
    objectClassInfoData[0].name = "";
    return objectClassInfoData;
  }
}

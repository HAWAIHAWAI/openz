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

class PhaseData implements FieldProvider {
static Logger log4j = Logger.getLogger(PhaseData.class);
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

  public static PhaseData[] select(ConnectionProvider connectionProvider, String projectID)    throws ServletException {
    return select(connectionProvider, projectID, 0, 0);
  }

  public static PhaseData[] select(ConnectionProvider connectionProvider, String projectID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT c_projectphase_id as id,name" +
      "              FROM C_PROJECTPHASE " +
      "             WHERE c_project_id = ? and phasebegun = 'Y' and iscomplete = 'N'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectID);

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
        PhaseData objectPhaseData = new PhaseData();
        objectPhaseData.id = UtilSql.getValue(result, "id");
        objectPhaseData.name = UtilSql.getValue(result, "name");
        objectPhaseData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPhaseData);
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
    PhaseData objectPhaseData[] = new PhaseData[vector.size()];
    vector.copyInto(objectPhaseData);
    return(objectPhaseData);
  }
}

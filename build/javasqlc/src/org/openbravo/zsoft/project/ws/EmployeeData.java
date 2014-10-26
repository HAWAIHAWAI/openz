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

class EmployeeData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmployeeData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String enumber;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("enumber"))
      return enumber;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EmployeeData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static EmployeeData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT ad_user_id as id,ad.name as name, ad.enumber as enumber" +
      "              FROM AD_USER ad, c_bpartner bp, C_BP_SALCATEGORY cc" +
      "             WHERE bp.c_bpartner_id=ad.c_bpartner_id and bp.c_bpartner_id=cc.c_bpartner_id and " +
      "                   bp.isemployee='Y' and bp.isactive='Y' and ad.isactive='Y' and ad.enumber is not null";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        EmployeeData objectEmployeeData = new EmployeeData();
        objectEmployeeData.id = UtilSql.getValue(result, "id");
        objectEmployeeData.name = UtilSql.getValue(result, "name");
        objectEmployeeData.enumber = UtilSql.getValue(result, "enumber");
        objectEmployeeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmployeeData);
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
    EmployeeData objectEmployeeData[] = new EmployeeData[vector.size()];
    vector.copyInto(objectEmployeeData);
    return(objectEmployeeData);
  }
}

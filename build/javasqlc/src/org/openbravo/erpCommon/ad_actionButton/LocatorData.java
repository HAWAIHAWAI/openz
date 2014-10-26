//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
Clase LocatorData
 */
class LocatorData implements FieldProvider {
static Logger log4j = Logger.getLogger(LocatorData.class);
  private String InitRecordNumber="0";
  public String padre;
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
RelaciÃ³n de organizaciones de la aplicacion
 */
  public static LocatorData[] select(ConnectionProvider connectionProvider, String language, String client)    throws ServletException {
    return select(connectionProvider, language, client, 0, 0);
  }

/**
RelaciÃ³n de organizaciones de la aplicacion
 */
  public static LocatorData[] select(ConnectionProvider connectionProvider, String language, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT L.M_WAREHOUSE_ID AS PADRE ,L.M_LOCATOR_ID AS ID, AD_COLUMN_IDENTIFIER(TO_CHAR('M_Locator'),TO_CHAR(M_LOCATOR_ID),TO_CHAR(?)) AS NAME " +
      "            FROM M_LOCATOR L" +
      "			WHERE L.IsActive='Y' " +
      "            AND L.AD_Client_ID = ? " +
      "            ORDER BY L.M_WAREHOUSE_ID,NAME	";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        LocatorData objectLocatorData = new LocatorData();
        objectLocatorData.padre = UtilSql.getValue(result, "padre");
        objectLocatorData.id = UtilSql.getValue(result, "id");
        objectLocatorData.name = UtilSql.getValue(result, "name");
        objectLocatorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocatorData);
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
    LocatorData objectLocatorData[] = new LocatorData[vector.size()];
    vector.copyInto(objectLocatorData);
    return(objectLocatorData);
  }
}

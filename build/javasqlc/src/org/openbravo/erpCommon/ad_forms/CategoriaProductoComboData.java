//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class CategoriaProductoComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(CategoriaProductoComboData.class);
  private String InitRecordNumber="0";
  public String clave;
  public String nombre;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("clave"))
      return clave;
    else if (fieldName.equalsIgnoreCase("nombre"))
      return nombre;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CategoriaProductoComboData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static CategoriaProductoComboData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT P_C.M_PRODUCT_CATEGORY_ID AS CLAVE, TO_CHAR(P_C.NAME) AS NOMBRE " +
      "     FROM M_PRODUCT_CATEGORY P_C" +
      "     ORDER BY P_C.NAME";

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
        CategoriaProductoComboData objectCategoriaProductoComboData = new CategoriaProductoComboData();
        objectCategoriaProductoComboData.clave = UtilSql.getValue(result, "clave");
        objectCategoriaProductoComboData.nombre = UtilSql.getValue(result, "nombre");
        objectCategoriaProductoComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCategoriaProductoComboData);
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
    CategoriaProductoComboData objectCategoriaProductoComboData[] = new CategoriaProductoComboData[vector.size()];
    vector.copyInto(objectCategoriaProductoComboData);
    return(objectCategoriaProductoComboData);
  }
}

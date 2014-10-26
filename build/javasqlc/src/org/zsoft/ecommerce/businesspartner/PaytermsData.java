//Sqlc generated V1.O00-1
package org.zsoft.ecommerce.businesspartner;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class PaytermsData implements FieldProvider {
static Logger log4j = Logger.getLogger(PaytermsData.class);
  private String InitRecordNumber="0";
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
@TODO: Shop abfragen in whereclause: 1=1 entfernen
 */
  public static PaytermsData[] select(ConnectionProvider connectionProvider, String cBpartnerId, String zsiShopId)    throws ServletException {
    return select(connectionProvider, cBpartnerId, zsiShopId, 0, 0);
  }

/**
@TODO: Shop abfragen in whereclause: 1=1 entfernen
 */
  public static PaytermsData[] select(ConnectionProvider connectionProvider, String cBpartnerId, String zsiShopId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "               select l.name " +
      "                        from ad_ref_list l,ad_reference r, zse_ecommercegrant z" +
      "                        where z.paymentmethod=l.value and" +
      "                              r.ad_reference_id='8EE47A7F188B4F86936C8AF91A55490A' and" +
      "                              r.ad_reference_id=l.ad_reference_id and" +
      "                              z.c_bpartner_id = ?   and" +
      "                              (z.zse_shop_id is null or z.zse_shop_id=? or 1=1)        ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsiShopId);

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
        PaytermsData objectPaytermsData = new PaytermsData();
        objectPaytermsData.name = UtilSql.getValue(result, "name");
        objectPaytermsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPaytermsData);
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
    PaytermsData objectPaytermsData[] = new PaytermsData[vector.size()];
    vector.copyInto(objectPaytermsData);
    return(objectPaytermsData);
  }
}

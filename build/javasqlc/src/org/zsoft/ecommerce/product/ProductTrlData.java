//Sqlc generated V1.O00-1
package org.zsoft.ecommerce.product;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ProductTrlData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductTrlData.class);
  private String InitRecordNumber="0";
  public String name;
  public String documentnote;
  public String description;
  public String adLanguage;
  public String mProductId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductTrlData[] select(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    return select(connectionProvider, mProductId, 0, 0);
  }

  public static ProductTrlData[] select(ConnectionProvider connectionProvider, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "               select name,documentnote,description,ad_language,m_product_id from" +
      "                        m_product_trl where" +
      "                        m_product_id = ? and" +
      "                        ad_language in (select ad_language from ad_language where issystemlanguage='Y')         ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
        ProductTrlData objectProductTrlData = new ProductTrlData();
        objectProductTrlData.name = UtilSql.getValue(result, "name");
        objectProductTrlData.documentnote = UtilSql.getValue(result, "documentnote");
        objectProductTrlData.description = UtilSql.getValue(result, "description");
        objectProductTrlData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectProductTrlData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductTrlData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductTrlData);
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
    ProductTrlData objectProductTrlData[] = new ProductTrlData[vector.size()];
    vector.copyInto(objectProductTrlData);
    return(objectProductTrlData);
  }
}

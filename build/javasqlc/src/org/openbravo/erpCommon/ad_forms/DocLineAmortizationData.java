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

class DocLineAmortizationData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineAmortizationData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String line;
  public String amortizationamt;
  public String cCurrencyId;
  public String mProductId;
  public String aAssetId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("amortizationamt"))
      return amortizationamt;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineAmortizationData[] select(ConnectionProvider connectionProvider, String A_AMORTIZATION_ID)    throws ServletException {
    return select(connectionProvider, A_AMORTIZATION_ID, 0, 0);
  }

  public static DocLineAmortizationData[] select(ConnectionProvider connectionProvider, String A_AMORTIZATION_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT A_AMORTIZATIONLINE.AD_ORG_ID, A_AMORTIZATIONLINE.LINE||'-'||a_asset.name as line, A_AMORTIZATIONLINE.AMORTIZATIONAMT, A_AMORTIZATIONLINE.C_CURRENCY_ID," +
      "        null as M_PRODUCT_ID, A_AMORTIZATIONLINE.A_ASSET_ID" +
      "        FROM A_AMORTIZATIONLINE, A_ASSET" +
      "        WHERE A_AMORTIZATIONLINE.A_ASSET_ID = A_ASSET.A_ASSET_ID" +
      "        AND A_AMORTIZATIONLINE.A_AMORTIZATION_ID =?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_AMORTIZATION_ID);

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
        DocLineAmortizationData objectDocLineAmortizationData = new DocLineAmortizationData();
        objectDocLineAmortizationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineAmortizationData.line = UtilSql.getValue(result, "line");
        objectDocLineAmortizationData.amortizationamt = UtilSql.getValue(result, "amortizationamt");
        objectDocLineAmortizationData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineAmortizationData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocLineAmortizationData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocLineAmortizationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineAmortizationData);
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
    DocLineAmortizationData objectDocLineAmortizationData[] = new DocLineAmortizationData[vector.size()];
    vector.copyInto(objectDocLineAmortizationData);
    return(objectDocLineAmortizationData);
  }
}

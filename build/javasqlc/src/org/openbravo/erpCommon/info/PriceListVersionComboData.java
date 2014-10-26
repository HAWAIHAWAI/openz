//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class PriceListVersionComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(PriceListVersionComboData.class);
  private String InitRecordNumber="0";
  public String mPricelistVersionId;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_pricelist_version_id") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PriceListVersionComboData[] select(ConnectionProvider connectionProvider, String priceList, String adUserOrg, String isPurchaseStaff)    throws ServletException {
    return select(connectionProvider, priceList, adUserOrg, isPurchaseStaff, 0, 0);
  }

  public static PriceListVersionComboData[] select(ConnectionProvider connectionProvider, String priceList, String adUserOrg, String isPurchaseStaff, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PriceList_Version.M_PriceList_Version_ID, " +
      "                p.name||' - '||M_PriceList_Version.Name || ' - ' || c.Iso_Code AS Name " +
      "                FROM M_PriceList_Version, M_PriceList p, c_currency c" +
      "                WHERE M_PriceList_Version.M_PriceList_ID=p.M_PriceList_ID " +
      "                AND M_PriceList_Version.M_PriceList_ID=?" +
      "                AND c.c_currency_id=p.c_currency_id" +
      "                AND M_PriceList_Version.IsActive='Y' " +
      "                AND M_PriceList_Version.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        UNION ALL" +
      "                SELECT plv.M_PriceList_Version_ID, " +
      "                p.name||' - '||plv.Name || ' - ' || c.Iso_Code AS Name " +
      "                FROM M_PriceList_Version plv, M_PriceList p, c_currency c" +
      "                WHERE plv.M_PriceList_ID=p.M_PriceList_ID " +
      "                AND plv.M_PriceList_ID!=?" +
      "                AND c.c_currency_id=p.c_currency_id" +
      "                AND plv.IsActive='Y' " +
      "                AND plv.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "                AND case when ?='N' then p.issopricelist='Y' else 1=1 end";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceList);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceList);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isPurchaseStaff);

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
        PriceListVersionComboData objectPriceListVersionComboData = new PriceListVersionComboData();
        objectPriceListVersionComboData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectPriceListVersionComboData.name = UtilSql.getValue(result, "name");
        objectPriceListVersionComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListVersionComboData);
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
    PriceListVersionComboData objectPriceListVersionComboData[] = new PriceListVersionComboData[vector.size()];
    vector.copyInto(objectPriceListVersionComboData);
    return(objectPriceListVersionComboData);
  }

  public static PriceListVersionComboData[] selectSelected(ConnectionProvider connectionProvider, String priceList, String adUserOrg)    throws ServletException {
    return selectSelected(connectionProvider, priceList, adUserOrg, 0, 0);
  }

  public static PriceListVersionComboData[] selectSelected(ConnectionProvider connectionProvider, String priceList, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PriceList_Version.M_PriceList_Version_ID, " +
      "                p.name||' - '||M_PriceList_Version.Name || ' - ' || c.Iso_Code AS Name " +
      "                FROM M_PriceList_Version, M_PriceList p, c_currency c" +
      "                WHERE M_PriceList_Version.M_PriceList_ID=p.M_PriceList_ID " +
      "                AND M_PriceList_Version.M_PriceList_ID=?" +
      "                AND c.c_currency_id=p.c_currency_id" +
      "                AND M_PriceList_Version.IsActive='Y' " +
      "                AND M_PriceList_Version.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceList);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }

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
        PriceListVersionComboData objectPriceListVersionComboData = new PriceListVersionComboData();
        objectPriceListVersionComboData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectPriceListVersionComboData.name = UtilSql.getValue(result, "name");
        objectPriceListVersionComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListVersionComboData);
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
    PriceListVersionComboData objectPriceListVersionComboData[] = new PriceListVersionComboData[vector.size()];
    vector.copyInto(objectPriceListVersionComboData);
    return(objectPriceListVersionComboData);
  }

  public static PriceListVersionComboData[] selectActual(ConnectionProvider connectionProvider, String priceList, String date, String adUserOrg)    throws ServletException {
    return selectActual(connectionProvider, priceList, date, adUserOrg, 0, 0);
  }

  public static PriceListVersionComboData[] selectActual(ConnectionProvider connectionProvider, String priceList, String date, String adUserOrg, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT plv.M_PriceList_Version_ID " +
      "        FROM M_PriceList pl, M_PriceList_Version plv " +
      "        WHERE pl.M_PriceList_ID=plv.M_PriceList_ID " +
      "        AND plv.IsActive= 'Y' " +
      "        AND pl.M_PriceList_ID = ? " +
      "        AND plv.ValidFrom <= TO_DATE(?) " +
      "        AND plv.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        ORDER BY plv.ValidFrom Desc";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceList);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }

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
        PriceListVersionComboData objectPriceListVersionComboData = new PriceListVersionComboData();
        objectPriceListVersionComboData.mPricelistVersionId = UtilSql.getValue(result, "m_pricelist_version_id");
        objectPriceListVersionComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListVersionComboData);
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
    PriceListVersionComboData objectPriceListVersionComboData[] = new PriceListVersionComboData[vector.size()];
    vector.copyInto(objectPriceListVersionComboData);
    return(objectPriceListVersionComboData);
  }

  public static String isUserPurchaser(ConnectionProvider connectionProvider, String userID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT isprocurementmanager from c_bpartner, ad_user where c_bpartner.c_bpartner_id=ad_user.c_bpartner_id" +
      "        and ad_user.ad_user_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isprocurementmanager");
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

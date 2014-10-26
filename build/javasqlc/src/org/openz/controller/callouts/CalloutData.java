//Sqlc generated V1.O00-1
package org.openz.controller.callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class CalloutData implements FieldProvider {
static Logger log4j = Logger.getLogger(CalloutData.class);
  private String InitRecordNumber="0";
  public String datefrom;
  public String dateto;
  public String columnname;
  public String referencename;
  public String includesemptyitem;
  public String adValRuleId;
  public String mProductId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("referencename"))
      return referencename;
    else if (fieldName.equalsIgnoreCase("includesemptyitem"))
      return includesemptyitem;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CalloutData[] init(ConnectionProvider connectionProvider)    throws ServletException {
    return init(connectionProvider, 0, 0);
  }

  public static CalloutData[] init(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT '' as DateFrom, '' as DateTo, '' as columnname , '' as referencename, '' as includesemptyitem, '' as AD_VAL_RULE_ID,'' as m_product_id  from dual";

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
        CalloutData objectCalloutData = new CalloutData();
        objectCalloutData.datefrom = UtilSql.getValue(result, "datefrom");
        objectCalloutData.dateto = UtilSql.getValue(result, "dateto");
        objectCalloutData.columnname = UtilSql.getValue(result, "columnname");
        objectCalloutData.referencename = UtilSql.getValue(result, "referencename");
        objectCalloutData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectCalloutData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectCalloutData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCalloutData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCalloutData);
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
    CalloutData objectCalloutData[] = new CalloutData[vector.size()];
    vector.copyInto(objectCalloutData);
    return(objectCalloutData);
  }

  public static String getSalCategoryOfUser(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Salary_Category_id from c_bpartner " +
      "        WHERE c_bpartner_id = (select c_bpartner_id from ad_user where ad_user_id= ? ) " +
      "        AND isactive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_salary_category_id");
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

  public static String getUomIdOfProduct(ConnectionProvider connectionProvider, String productId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_UOM_id from m_product " +
      "        WHERE m_product_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_uom_id");
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

  public static String hasSecondaryUOM(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT (CASE COUNT(*) WHEN 0 THEN 0 ELSE 1 END) AS TOTAL " +
      "      FROM M_PRODUCT_UOM " +
      "      WHERE M_PRODUCT_ID = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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

  public static String getCurrencyOfPricelis(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_currency_id from m_pricelist where m_pricelist_id = ?";

    ResultSet result;
    String strReturn = "0";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

  public static CalloutData[] getCombos2ReloadFromTab(ConnectionProvider connectionProvider, String adFieldName, String adTabId)    throws ServletException {
    return getCombos2ReloadFromTab(connectionProvider, adFieldName, adTabId, 0, 0);
  }

  public static CalloutData[] getCombos2ReloadFromTab(ConnectionProvider connectionProvider, String adFieldName, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c.columnname  ,case when c.ad_reference_id='18' then (select name from ad_reference where ad_reference_id=c.ad_reference_value_id)" +
      "                                                       else c.columnname end as referencename,v.AD_VAL_RULE_ID," +
      "                              case when c.ismandatory = 'Y' then 'Y' else 'N' end as includesemptyitem" +
      "         FROM AD_FIELD f, " +
      "             AD_COLUMN c" +
      "             left join  AD_VAL_RULE v on c.AD_VAL_RULE_ID = v.AD_VAL_RULE_ID" +
      "             left join AD_REF_TABLE t on (CASE c.ad_reference_id WHEN '18' THEN c.AD_REFERENCE_VALUE_ID ELSE '0' END) = t.AD_REFERENCE_ID  " +
      "        WHERE f.AD_COLUMN_ID = c.ad_column_id" +
      "        and c.ad_reference_id in ('19','18')" +
      "        and (" +
      "             instr(upper(replace(t.whereclause,'_','')),'@'||upper(?)||'@')>0" +
      "          OR instr(upper(replace(v.code,'_','')),'@'||upper(?)||'@')>0" +
      "        )" +
      "        AND f.ad_tab_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        CalloutData objectCalloutData = new CalloutData();
        objectCalloutData.columnname = UtilSql.getValue(result, "columnname");
        objectCalloutData.referencename = UtilSql.getValue(result, "referencename");
        objectCalloutData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectCalloutData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectCalloutData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCalloutData);
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
    CalloutData objectCalloutData[] = new CalloutData[vector.size()];
    vector.copyInto(objectCalloutData);
    return(objectCalloutData);
  }

  public static CalloutData[] getCombos2ReloadFromProcess(ConnectionProvider connectionProvider, String adFieldName, String adTabId)    throws ServletException {
    return getCombos2ReloadFromProcess(connectionProvider, adFieldName, adTabId, 0, 0);
  }

  public static CalloutData[] getCombos2ReloadFromProcess(ConnectionProvider connectionProvider, String adFieldName, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c.columnname  , case when c.ad_reference_id='18' then (select name from ad_reference where ad_reference_id=c.ad_reference_value_id)" +
      "                                                       else c.columnname end as referencename,v.AD_VAL_RULE_ID," +
      "               case when c.ismandatory = 'Y' then 'Y' else 'N' end as includesemptyitem" +
      "         FROM AD_PROCESS_PARA c" +
      "             left join  AD_VAL_RULE v on c.AD_VAL_RULE_ID = v.AD_VAL_RULE_ID" +
      "             left join AD_REF_TABLE t on (CASE c.ad_reference_id WHEN '18' THEN c.AD_REFERENCE_VALUE_ID ELSE '0' END) = t.AD_REFERENCE_ID  " +
      "        WHERE  c.ad_reference_id in ('19','18')" +
      "        and (" +
      "             instr(upper(replace(t.whereclause,'_','')),'@'||upper(?)||'@')>0" +
      "          OR instr(upper(replace(v.code,'_','')),'@'||upper(?)||'@')>0" +
      "        )" +
      "        AND c.AD_PROCESS_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        CalloutData objectCalloutData = new CalloutData();
        objectCalloutData.columnname = UtilSql.getValue(result, "columnname");
        objectCalloutData.referencename = UtilSql.getValue(result, "referencename");
        objectCalloutData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectCalloutData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectCalloutData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCalloutData);
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
    CalloutData objectCalloutData[] = new CalloutData[vector.size()];
    vector.copyInto(objectCalloutData);
    return(objectCalloutData);
  }

  public static CalloutData[] getCombos2ReloadFromFieldGroup(ConnectionProvider connectionProvider, String adFieldName, String adTabId)    throws ServletException {
    return getCombos2ReloadFromFieldGroup(connectionProvider, adFieldName, adTabId, 0, 0);
  }

  public static CalloutData[] getCombos2ReloadFromFieldGroup(ConnectionProvider connectionProvider, String adFieldName, String adTabId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c.name as columnname  , case when c.ad_reference_id='18' then (select name from ad_reference where ad_reference_id=c.fieldreference)" +
      "                                                       else c.name end as referencename  ,v.AD_VAL_RULE_ID," +
      "               c.includesemptyitem" +
      "         FROM ad_ref_fieldcolumn c" +
      "             left join  AD_VAL_RULE v on c.AD_VAL_RULE_ID = v.AD_VAL_RULE_ID" +
      "             left join AD_REF_TABLE t on (CASE c.fieldreference WHEN '18' THEN c.fieldreference ELSE '0' END) = t.AD_REFERENCE_ID  " +
      "        WHERE  c.fieldreference in ('19','18')" +
      "        and (" +
      "             instr(upper(replace(t.whereclause,'_','')),'@'||upper(?)||'@')>0" +
      "          OR instr(upper(replace(v.code,'_','')),'@'||upper(?)||'@')>0" +
      "        )" +
      "        AND c.AD_reference_id = ?         ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
        CalloutData objectCalloutData = new CalloutData();
        objectCalloutData.columnname = UtilSql.getValue(result, "columnname");
        objectCalloutData.referencename = UtilSql.getValue(result, "referencename");
        objectCalloutData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectCalloutData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectCalloutData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCalloutData);
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
    CalloutData objectCalloutData[] = new CalloutData[vector.size()];
    vector.copyInto(objectCalloutData);
    return(objectCalloutData);
  }
}

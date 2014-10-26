//Sqlc generated V1.O00-1
package org.openz.pdc.controller;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class SerialNumberData implements FieldProvider {
static Logger log4j = Logger.getLogger(SerialNumberData.class);
  private String InitRecordNumber="0";
  public String snrInternalConsumptionlineId;
  public String serialnumber;
  public String lotnumber;
  public String mInternalConsumptionlineId;
  public String mLocatorId;
  public String quantity;
  public String mProductId;
  public String product;
  public String isserialtracking;
  public String isbatchtracking;
  public String production;
  public String qtytodo;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("snr_internal_consumptionline_id") || fieldName.equals("snrInternalConsumptionlineId"))
      return snrInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("lotnumber"))
      return lotnumber;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_id") || fieldName.equals("mInternalConsumptionlineId"))
      return mInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("isserialtracking"))
      return isserialtracking;
    else if (fieldName.equalsIgnoreCase("isbatchtracking"))
      return isbatchtracking;
    else if (fieldName.equalsIgnoreCase("production"))
      return production;
    else if (fieldName.equalsIgnoreCase("qtytodo"))
      return qtytodo;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SerialNumberData[] selectupper(ConnectionProvider connectionProvider, String language, String Productiionid, String consumptionid)    throws ServletException {
    return selectupper(connectionProvider, language, Productiionid, consumptionid, 0, 0);
  }

  public static SerialNumberData[] selectupper(ConnectionProvider connectionProvider, String language, String Productiionid, String consumptionid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    Select '' as snr_internal_consumptionline_id,'' as serialnumber ,'' as lotnumber,f.internal_consumptionline_id as m_internal_consumptionline_id,f.locator_id as m_locator_id,'' as quantity," +
      "            f.product_id as m_product_id, zssi_getproductnamewithvalue(f.product_id,?) as product,f.isserialtracking,f.isbatchtracking,f.iscreated as production,f.qty as qtytodo" +
      "           from pdc_snrtodeliver(?)   f" +
      "    union" +
      "    Select '' as snr_internal_consumptionline_id,'' as serialnumber ,'' as lotnumber,f.internal_consumptionline_id as m_internal_consumptionline_id,f.locator_id as m_locator_id,'' as quantity," +
      "            f.product_id as m_product_id, zssi_getproductnamewithvalue(f.product_id,?) as product,f.isserialtracking,f.isbatchtracking,f.iscreated as production,f.qty as qtytodo" +
      "           from pdc_snrtodeliver(?)   f";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Productiionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumptionid);

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
        SerialNumberData objectSerialNumberData = new SerialNumberData();
        objectSerialNumberData.snrInternalConsumptionlineId = UtilSql.getValue(result, "snr_internal_consumptionline_id");
        objectSerialNumberData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectSerialNumberData.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectSerialNumberData.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectSerialNumberData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectSerialNumberData.quantity = UtilSql.getValue(result, "quantity");
        objectSerialNumberData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSerialNumberData.product = UtilSql.getValue(result, "product");
        objectSerialNumberData.isserialtracking = UtilSql.getValue(result, "isserialtracking");
        objectSerialNumberData.isbatchtracking = UtilSql.getValue(result, "isbatchtracking");
        objectSerialNumberData.production = UtilSql.getValue(result, "production");
        objectSerialNumberData.qtytodo = UtilSql.getValue(result, "qtytodo");
        objectSerialNumberData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSerialNumberData);
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
    SerialNumberData objectSerialNumberData[] = new SerialNumberData[vector.size()];
    vector.copyInto(objectSerialNumberData);
    return(objectSerialNumberData);
  }

  public static SerialNumberData[] selectSpecificS(ConnectionProvider connectionProvider, String consumptionid)    throws ServletException {
    return selectSpecificS(connectionProvider, consumptionid, 0, 0);
  }

  public static SerialNumberData[] selectSpecificS(ConnectionProvider connectionProvider, String consumptionid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    Select  f.product_id as m_product_id" +
      "           from pdc_snrtodeliver(?) f group by f.product_id having count(*)>1";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumptionid);

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
        SerialNumberData objectSerialNumberData = new SerialNumberData();
        objectSerialNumberData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectSerialNumberData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSerialNumberData);
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
    SerialNumberData objectSerialNumberData[] = new SerialNumberData[vector.size()];
    vector.copyInto(objectSerialNumberData);
    return(objectSerialNumberData);
  }

  public static SerialNumberData[] selectlower(ConnectionProvider connectionProvider, String language, String productionid, String consumptionid)    throws ServletException {
    return selectlower(connectionProvider, language, productionid, consumptionid, 0, 0);
  }

  public static SerialNumberData[] selectlower(ConnectionProvider connectionProvider, String language, String productionid, String consumptionid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    Select l.snr_internal_consumptionline_id,zssi_getproductnamewithvalue(c.m_product_id,?) as product, l.serialnumber , l.lotnumber, l.quantity from snr_internal_consumptionline l,m_internal_consumptionline c" +
      "    where  l.m_internal_consumptionline_id=c.m_internal_consumptionline_id and c.m_internal_consumption_id = ? " +
      "    union all" +
      "    Select l.snr_internal_consumptionline_id,zssi_getproductnamewithvalue(c.m_product_id,?) as product, l.serialnumber , l.lotnumber, l.quantity from snr_internal_consumptionline l,m_internal_consumptionline c" +
      "    where  l.m_internal_consumptionline_id=c.m_internal_consumptionline_id and c.m_internal_consumption_id = ? " +
      "    union all" +
      "    Select l.m_inoutline_id as snr_internal_consumptionline_id,zssi_getproductnamewithvalue(c.m_product_id,?) as product, l.serialnumber , l.lotnumber, l.quantity from snr_minoutline l,m_inoutline c" +
      "    where  l.m_inoutline_id=c.m_inoutline_id and c.m_inout_id = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumptionid);

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
        SerialNumberData objectSerialNumberData = new SerialNumberData();
        objectSerialNumberData.snrInternalConsumptionlineId = UtilSql.getValue(result, "snr_internal_consumptionline_id");
        objectSerialNumberData.product = UtilSql.getValue(result, "product");
        objectSerialNumberData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectSerialNumberData.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectSerialNumberData.quantity = UtilSql.getValue(result, "quantity");
        objectSerialNumberData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSerialNumberData);
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
    SerialNumberData objectSerialNumberData[] = new SerialNumberData[vector.size()];
    vector.copyInto(objectSerialNumberData);
    return(objectSerialNumberData);
  }

  public static SerialNumberData[] set()    throws ServletException {
    SerialNumberData objectSerialNumberData[] = new SerialNumberData[1];
    objectSerialNumberData[0] = new SerialNumberData();
    objectSerialNumberData[0].snrInternalConsumptionlineId = "";
    objectSerialNumberData[0].product = "";
    objectSerialNumberData[0].serialnumber = "";
    objectSerialNumberData[0].lotnumber = "";
    objectSerialNumberData[0].quantity = "";
    return objectSerialNumberData;
  }

  public static String getProductIdFromSerialOrBatchNumber(ConnectionProvider connectionProvider, String pvalueofserialorbarch, String consumptionid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT pdc_getProductIdFromSerialOrBatchNumber(?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pvalueofserialorbarch);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumptionid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pdc_getproductidfromserialorbatchnumber");
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

  public static String getProductIdFromSerialATWorkstepReceivingLocator(ConnectionProvider connectionProvider, String pvalueofserial, String workstepId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_product_id from snr_masterdata where serialnumber= ? " +
      "        and m_locator_id=(select receiving_locator from c_projecttask where c_projecttask_id= ?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pvalueofserial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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

  public static String getProductIdFromSerialConsumedINWorkstep(ConnectionProvider connectionProvider, String pvalueofserial, String workstepId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_product_id from snr_masterdata where serialnumber= ? " +
      "        and  c_projecttask_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pvalueofserial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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

  public static String getProductIdFromSerialINLocator(ConnectionProvider connectionProvider, String pvalueofserial, String locator)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_product_id from snr_masterdata where serialnumber= ? " +
      "        and  m_locator_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pvalueofserial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locator);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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

  public static String getProductIdFromSerial(ConnectionProvider connectionProvider, String pvalueofserial)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_product_id from snr_masterdata where serialnumber= ? " +
      "        group by serialnumber,m_product_id having count(*)=1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pvalueofserial);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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

  public static String getLocatorIdFromSerialAndProduct(ConnectionProvider connectionProvider, String pvalueofserial, String product)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_locator_id from snr_masterdata where serialnumber= ? " +
      "        and  m_product_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pvalueofserial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_locator_id");
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

  public static String pdc_getSerialOrBatchType(ConnectionProvider connectionProvider, String pvalueofserialorbarch, String productid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT pdc_getSerialOrBatchType(?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pvalueofserialorbarch);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pdc_getserialorbatchtype");
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

  public static String pdc_getSerialBatchType4product(ConnectionProvider connectionProvider, String productid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT case isserialtracking||isbatchtracking when 'YY' then 'BOTH' when 'YN' then 'SERIAL' when 'NY' then 'BATCH' else 'NONE' end from m_product where m_product_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "case");
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

  public static String pdc_getBatchNoFromSerialNo(ConnectionProvider connectionProvider, String serialno, String productId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT distinct Lotnumber from snr_serialnumbertracking where serialnumber=? and m_product_id = ?" +
      "        and (select isbatchtracking from m_product where m_product_id= ?) = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "lotnumber");
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

  public static String getLineIDByProduct(ConnectionProvider connectionProvider, String consumptionid, String productid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    Select f.internal_consumptionline_id as m_internal_consumptionline_id " +
      "           from pdc_snrtodeliver(?)   f where f.product_id= ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_internal_consumptionline_id");
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

  public static int insertSerialLine(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String user, String consumptionLineId, String qty, String batchno, String serialno)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       insert into snr_internal_consumptionline(snr_internal_consumptionline_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_INTERNAL_CONSUMPTIONLINE_ID, " +
      "                                                  quantity,lotnumber,serialnumber)" +
      "                  values (get_uuid(),?,?,NOW(), ?, NOW(),?,?," +
      "                          to_number(?),?, ?);";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumptionLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, batchno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialno);

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int insertSerialLineInOut(ConnectionProvider connectionProvider, String adClientId, String adOrgId, String user, String InOUtLineId, String qty, String batchno, String serialno)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       insert into snr_minoutline(snr_minoutline_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, m_inoutline_id, " +
      "                                                  quantity,lotnumber,serialnumber)" +
      "                  values (get_uuid(),?,?,NOW(), ?, NOW(),?,?," +
      "                          to_number(?),?, ?);";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, InOUtLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, batchno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialno);

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int delete(Connection conn, ConnectionProvider connectionProvider, String consumption)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       delete from snr_internal_consumptionline where M_INTERNAL_CONSUMPTIONLINE_ID in (select M_INTERNAL_CONSUMPTIONLINE_ID from M_INTERNAL_CONSUMPTIONLINE where M_INTERNAL_CONSUMPTION_id = ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumption);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteInOUt(Connection conn, ConnectionProvider connectionProvider, String inoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       delete from snr_minoutline where M_INOUTLINE_ID in (select M_INOUTLINE_ID from M_INOUTLINE where M_INOUT_id = ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inoutId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static String pdc_InOutPOst(ConnectionProvider connectionProvider, String inoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_inout_post(null,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inoutId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_inout_post");
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

  public static String pdc_IsInOutDraft(ConnectionProvider connectionProvider, String inoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT case when docstatus='DR' then 'Y' else 'N' end from m_inout where m_inout_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inoutId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "case");
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

  public static String isInOutPlus(ConnectionProvider connectionProvider, String inoutId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT movementtype from m_inout where m_inout_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inoutId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "movementtype");
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

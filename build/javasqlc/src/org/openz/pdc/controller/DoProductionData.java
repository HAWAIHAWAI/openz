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

public class DoProductionData implements FieldProvider {
static Logger log4j = Logger.getLogger(DoProductionData.class);
  private String InitRecordNumber="0";
  public String barcode;
  public String type;
  public String id;
  public String mess;
  public String adMessageValue;
  public String mProductId;
  public String trxqty;
  public String mInternalConsumptionlineId;
  public String wsbomid;
  public String product;
  public String locator;
  public String mLocatorId;
  public String outtype;
  public String mProductIdOut;
  public String returnquantity;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("barcode"))
      return barcode;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("mess"))
      return mess;
    else if (fieldName.equalsIgnoreCase("ad_message_value") || fieldName.equals("adMessageValue"))
      return adMessageValue;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("trxqty"))
      return trxqty;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_id") || fieldName.equals("mInternalConsumptionlineId"))
      return mInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("wsbomid"))
      return wsbomid;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("locator"))
      return locator;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("outtype"))
      return outtype;
    else if (fieldName.equalsIgnoreCase("m_product_id_out") || fieldName.equals("mProductIdOut"))
      return mProductIdOut;
    else if (fieldName.equalsIgnoreCase("returnquantity"))
      return returnquantity;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DoProductionData[] selectupper(ConnectionProvider connectionProvider, String language, String workstepid, String pconsumptionid, String dconsumptionid)    throws ServletException {
    return selectupper(connectionProvider, language, workstepid, pconsumptionid, dconsumptionid, 0, 0);
  }

  public static DoProductionData[] selectupper(ConnectionProvider connectionProvider, String language, String workstepid, String pconsumptionid, String dconsumptionid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    Select '' as barcode,'' as type,'' as id, '' as mess,'' as ad_message_value,'' as m_product_id ,'' as trxqty,'' as m_internal_consumptionline_id,f.wsbomid, zssi_getproductnamewithvalue(f.m_product_id_out,?) as product,l.value as locator,f.issuing_locator_out as m_locator_id ,f.outtype,f.m_product_id_out,f.returnquantity" +
      "           from pdc_PFeedbackUpperGrid(?,?,?) f left join m_locator l on f.issuing_locator_out=l.m_locator_id";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dconsumptionid);

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
        DoProductionData objectDoProductionData = new DoProductionData();
        objectDoProductionData.barcode = UtilSql.getValue(result, "barcode");
        objectDoProductionData.type = UtilSql.getValue(result, "type");
        objectDoProductionData.id = UtilSql.getValue(result, "id");
        objectDoProductionData.mess = UtilSql.getValue(result, "mess");
        objectDoProductionData.adMessageValue = UtilSql.getValue(result, "ad_message_value");
        objectDoProductionData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDoProductionData.trxqty = UtilSql.getValue(result, "trxqty");
        objectDoProductionData.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectDoProductionData.wsbomid = UtilSql.getValue(result, "wsbomid");
        objectDoProductionData.product = UtilSql.getValue(result, "product");
        objectDoProductionData.locator = UtilSql.getValue(result, "locator");
        objectDoProductionData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectDoProductionData.outtype = UtilSql.getValue(result, "outtype");
        objectDoProductionData.mProductIdOut = UtilSql.getValue(result, "m_product_id_out");
        objectDoProductionData.returnquantity = UtilSql.getValue(result, "returnquantity");
        objectDoProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDoProductionData);
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
    DoProductionData objectDoProductionData[] = new DoProductionData[vector.size()];
    vector.copyInto(objectDoProductionData);
    return(objectDoProductionData);
  }

  public static DoProductionData[] selectlower(ConnectionProvider connectionProvider, String language, String pconsumptionid, String dconsumptionid)    throws ServletException {
    return selectlower(connectionProvider, language, pconsumptionid, dconsumptionid, 0, 0);
  }

  public static DoProductionData[] selectlower(ConnectionProvider connectionProvider, String language, String pconsumptionid, String dconsumptionid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    Select f.m_internal_consumptionline_id,zssi_getproductnamewithvalue(f.m_product_id,?) as product,l.value as locator,f.m_locator_id,'PROD' as outtype,f.movementqty as trxqty" +
      "           from m_internal_consumptionline f left join  m_locator l on  f.m_locator_id=l.m_locator_id" +
      "           where f.m_internal_consumption_id=?" +
      "    union all" +
      "    Select f.m_internal_consumptionline_id,zssi_getproductnamewithvalue(f.m_product_id,?) as product,l.value as locator,f.m_locator_id,'MAT' as outtype,f.movementqty as trxqty" +
      "           from m_internal_consumptionline f left join m_locator l on  f.m_locator_id=l.m_locator_id" +
      "           where f.m_internal_consumption_id=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dconsumptionid);

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
        DoProductionData objectDoProductionData = new DoProductionData();
        objectDoProductionData.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectDoProductionData.product = UtilSql.getValue(result, "product");
        objectDoProductionData.locator = UtilSql.getValue(result, "locator");
        objectDoProductionData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectDoProductionData.outtype = UtilSql.getValue(result, "outtype");
        objectDoProductionData.trxqty = UtilSql.getValue(result, "trxqty");
        objectDoProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDoProductionData);
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
    DoProductionData objectDoProductionData[] = new DoProductionData[vector.size()];
    vector.copyInto(objectDoProductionData);
    return(objectDoProductionData);
  }

  public static String getAssemblyProductFromWorkstep(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT case assembly when 'Y' then coalesce(m_product_id,'')  else '' end  as m_product_id from c_projecttask where c_projecttask_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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

  public static String getQty(ConnectionProvider connectionProvider, String workstepid, String pconsumptionid, String dconsumptionid, String mProductId, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT returnquantity from pdc_PFeedbackUpperGrid(?,?,?) where m_product_id_out=? and coalesce(issuing_locator_out,?) = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "returnquantity");
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

  public static String getLocator(ConnectionProvider connectionProvider, String workstepid, String pconsumptionid, String dconsumptionid, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT issuing_locator_out  as m_locator_id from pdc_PFeedbackUpperGrid(?,?,?) where m_product_id_out=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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

  public static String getTrxQty(ConnectionProvider connectionProvider, String pconsumptionid, String dconsumptionid, String mProductId, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(sum(movementqty),0)  as trxqty from m_internal_consumptionline" +
      "        where m_internal_consumption_id in (?,?) and m_product_id=? and m_locator_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "trxqty");
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

  public static DoProductionData[] set()    throws ServletException {
    DoProductionData objectDoProductionData[] = new DoProductionData[1];
    objectDoProductionData[0] = new DoProductionData();
    objectDoProductionData[0].trxqty = "";
    return objectDoProductionData;
  }
}

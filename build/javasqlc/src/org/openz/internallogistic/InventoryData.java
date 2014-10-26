//Sqlc generated V1.O00-1
package org.openz.internallogistic;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class InventoryData implements FieldProvider {
static Logger log4j = Logger.getLogger(InventoryData.class);
  private String InitRecordNumber="0";
  public String ilsTempinventoryId;
  public String ilssourcepackageid;
  public String ilsinventory;
  public String mProductId;
  public String adUserId;
  public String remark;
  public String vendor;
  public String model;
  public String identifier2;
  public String identifier3;
  public String orderreference;
  public String externaltrackingno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ils_tempinventory_id") || fieldName.equals("ilsTempinventoryId"))
      return ilsTempinventoryId;
    else if (fieldName.equalsIgnoreCase("ilssourcepackageid"))
      return ilssourcepackageid;
    else if (fieldName.equalsIgnoreCase("ilsinventory"))
      return ilsinventory;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("remark"))
      return remark;
    else if (fieldName.equalsIgnoreCase("vendor"))
      return vendor;
    else if (fieldName.equalsIgnoreCase("model"))
      return model;
    else if (fieldName.equalsIgnoreCase("identifier2"))
      return identifier2;
    else if (fieldName.equalsIgnoreCase("identifier3"))
      return identifier3;
    else if (fieldName.equalsIgnoreCase("orderreference"))
      return orderreference;
    else if (fieldName.equalsIgnoreCase("externaltrackingno"))
      return externaltrackingno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InventoryData[] selectLowerGrid(ConnectionProvider connectionProvider, String ilsinventoryid)    throws ServletException {
    return selectLowerGrid(connectionProvider, ilsinventoryid, 0, 0);
  }

  public static InventoryData[] selectLowerGrid(ConnectionProvider connectionProvider, String ilsinventoryid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    Select ils_tempinventory_id , snrselfjoin as ilssourcepackageid,serialnumber as ilsinventory," +
      "	           m_product_id,ad_user_id,remark,vendor,model,identifier2,identifier3,orderreference, externaltrackingno" +
      "	    from ils_tempinventory where ils_inventory_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ilsinventoryid);

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
        InventoryData objectInventoryData = new InventoryData();
        objectInventoryData.ilsTempinventoryId = UtilSql.getValue(result, "ils_tempinventory_id");
        objectInventoryData.ilssourcepackageid = UtilSql.getValue(result, "ilssourcepackageid");
        objectInventoryData.ilsinventory = UtilSql.getValue(result, "ilsinventory");
        objectInventoryData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectInventoryData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectInventoryData.remark = UtilSql.getValue(result, "remark");
        objectInventoryData.vendor = UtilSql.getValue(result, "vendor");
        objectInventoryData.model = UtilSql.getValue(result, "model");
        objectInventoryData.identifier2 = UtilSql.getValue(result, "identifier2");
        objectInventoryData.identifier3 = UtilSql.getValue(result, "identifier3");
        objectInventoryData.orderreference = UtilSql.getValue(result, "orderreference");
        objectInventoryData.externaltrackingno = UtilSql.getValue(result, "externaltrackingno");
        objectInventoryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInventoryData);
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
    InventoryData objectInventoryData[] = new InventoryData[vector.size()];
    vector.copyInto(objectInventoryData);
    return(objectInventoryData);
  }

  public static int insertTempInventory(ConnectionProvider connectionProvider, String TempInventoryId, String adOrgId, String trxuser, String mProductId, String userId, String serialno, String relationserial, String remark, String vendor, String model, String identifier2, String identifier3, String orderreference, String externaltracking)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        insert into ILS_TEMPINVENTORY(" +
      "            ILS_TEMPINVENTORY_ID," +
      "            ILS_INVENTORY_ID," +
      "            AD_CLIENT_ID," +
      "            AD_ORG_ID," +
      "            CREATEDBY," +
      "            UPDATEDBY," +
      "            M_PRODUCT_ID," +
      "            ad_user_id," +
      "            SERIALNUMBER," +
      "            SNRSELFJOIN," +
      "            REMARK," +
      "            VENDOR," +
      "            MODEL," +
      "            IDENTIFIER2," +
      "            IDENTIFIER3," +
      "            ORDERREFERENCE," +
      "            EXTERNALTRACKINGNO)" +
      "        values(" +
      "            get_uuid()," +
      "            ?," +
      "            'C726FEC915A54A0995C568555DA5BB3C'," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?," +
      "             ?);";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TempInventoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trxuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, trxuser);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serialno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, relationserial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, remark);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, model);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, identifier2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, identifier3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externaltracking);

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

  public static String postTempInventory(ConnectionProvider connectionProvider, String TempInventoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ils_postTempinventory(?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TempInventoryId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ils_posttempinventory");
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

  public static String getSerialFromID(ConnectionProvider connectionProvider, String TempInventoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select serialnumber from snr_masterdata where snr_masterdata_id = " +
      "        (select snrselfjoin from ils_tempinventory where ils_inventory_id = ? limit 1)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TempInventoryId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "serialnumber");
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

  public static int deleteTempInventory(ConnectionProvider connectionProvider, String TempInventoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        delete from ILS_TEMPINVENTORY where ILS_INVENTORY_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TempInventoryId);

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
}

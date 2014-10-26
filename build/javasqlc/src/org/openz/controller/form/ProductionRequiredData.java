//Sqlc generated V1.O00-1
package org.openz.controller.form;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ProductionRequiredData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductionRequiredData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String isactive;
  public String zssmProductionrequiredVId;
  public String mProductId;
  public String product;
  public String needbydate;
  public String lateststartdate;
  public String requiredqty;
  public String cause;
  public String qty;
  public String startdate;
  public String dependentstartdate;
  public String movementqty;
  public String curronhandqty;
  public String causetext;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zssm_productionrequired_v_id") || fieldName.equals("zssmProductionrequiredVId"))
      return zssmProductionrequiredVId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("needbydate"))
      return needbydate;
    else if (fieldName.equalsIgnoreCase("lateststartdate"))
      return lateststartdate;
    else if (fieldName.equalsIgnoreCase("requiredqty"))
      return requiredqty;
    else if (fieldName.equalsIgnoreCase("cause"))
      return cause;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("dependentstartdate"))
      return dependentstartdate;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("curronhandqty"))
      return curronhandqty;
    else if (fieldName.equalsIgnoreCase("causetext"))
      return causetext;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductionRequiredData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ProductionRequiredData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  SELECT '' AS AD_CLIENT_ID," +
      "               '' AS AD_ORG_ID," +
      "               '' AS CREATED," +
      "               '' AS CREATEDBY," +
      "               '' AS UPDATED," +
      "               '' AS UPDATEDBY," +
      "               '' AS ISACTIVE," +
      "               '' AS ZSSM_PRODUCTIONREQUIRED_V_ID," +
      "               '' AS M_PRODUCT_ID," +
      "               '' AS PRODUCT," +
      "               '' AS NEEDBYDATE," +
      "               '' AS LATESTSTARTDATE," +
      "               '' AS REQUIREDQTY," +
      "               '' AS CAUSE," +
      "               '' AS QTY," +
      "               '' AS STARTDATE      ," +
      "               '' as  dependentstartdate," +
      "               '' as movementqty," +
      "               '' as currOnhandQty," +
      "               '' as causetext";

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
        ProductionRequiredData objectProductionRequiredData = new ProductionRequiredData();
        objectProductionRequiredData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductionRequiredData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductionRequiredData.created = UtilSql.getValue(result, "created");
        objectProductionRequiredData.createdby = UtilSql.getValue(result, "createdby");
        objectProductionRequiredData.updated = UtilSql.getValue(result, "updated");
        objectProductionRequiredData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductionRequiredData.isactive = UtilSql.getValue(result, "isactive");
        objectProductionRequiredData.zssmProductionrequiredVId = UtilSql.getValue(result, "zssm_productionrequired_v_id");
        objectProductionRequiredData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductionRequiredData.product = UtilSql.getValue(result, "product");
        objectProductionRequiredData.needbydate = UtilSql.getValue(result, "needbydate");
        objectProductionRequiredData.lateststartdate = UtilSql.getValue(result, "lateststartdate");
        objectProductionRequiredData.requiredqty = UtilSql.getValue(result, "requiredqty");
        objectProductionRequiredData.cause = UtilSql.getValue(result, "cause");
        objectProductionRequiredData.qty = UtilSql.getValue(result, "qty");
        objectProductionRequiredData.startdate = UtilSql.getValue(result, "startdate");
        objectProductionRequiredData.dependentstartdate = UtilSql.getValue(result, "dependentstartdate");
        objectProductionRequiredData.movementqty = UtilSql.getValue(result, "movementqty");
        objectProductionRequiredData.curronhandqty = UtilSql.getValue(result, "curronhandqty");
        objectProductionRequiredData.causetext = UtilSql.getValue(result, "causetext");
        objectProductionRequiredData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductionRequiredData);
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
    ProductionRequiredData objectProductionRequiredData[] = new ProductionRequiredData[vector.size()];
    vector.copyInto(objectProductionRequiredData);
    return(objectProductionRequiredData);
  }

  public static ProductionRequiredData[] selectgrid(ConnectionProvider connectionProvider, String language, String parProduct, String parDateFrom, String parDateTo, String adOrgId)    throws ServletException {
    return selectgrid(connectionProvider, language, parProduct, parDateFrom, parDateTo, adOrgId, 0, 0);
  }

  public static ProductionRequiredData[] selectgrid(ConnectionProvider connectionProvider, String language, String parProduct, String parDateFrom, String parDateTo, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  SELECT       AD_CLIENT_ID," +
      "               AD_ORG_ID," +
      "               CREATED," +
      "               CREATEDBY," +
      "               UPDATED," +
      "               UPDATEDBY," +
      "               ISACTIVE," +
      "               ZSSM_PRODUCTIONREQUIRED_V_ID," +
      "               zssi_getproductname(M_PRODUCT_ID,?) as PRODUCT," +
      "               NEEDBYDATE," +
      "               LATESTSTARTDATE," +
      "			   REQUIREDQTY," +
      "			   movementqty as QTY," +
      "			   LATESTSTARTDATE as STARTDATE," +
      "			   dependentstartdate," +
      "			   currOnhandQty," +
      "			   m_product_id," +
      "               zssi_getElementTextByColumname(CAUSE,?) as CAUSE ," +
      "               zssi_getElementTextByColumname(CAUSETEXT,?) as CAUSETEXT         " +
      "      FROM ZSSM_PRODUCTIONREQUIRED_V" +
      "       where 1=1";
    strSql = strSql + ((parProduct==null || parProduct.equals(""))?"":"  AND ZSSM_PRODUCTIONREQUIRED_V.M_PRODUCT_ID = TO_CHAR(?) ");
    strSql = strSql + 
      "       AND 2=2 " +
      "       AND 3=3";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND ZSSM_PRODUCTIONREQUIRED_V.dependentstartdate >= TO_DATE(?) ");
    strSql = strSql + 
      "       AND 4=4";
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND ZSSM_PRODUCTIONREQUIRED_V.dependentstartdate < TO_DATE(?) ");
    strSql = strSql + 
      "       AND ad_org_id in (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parProduct != null && !(parProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parProduct);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        ProductionRequiredData objectProductionRequiredData = new ProductionRequiredData();
        objectProductionRequiredData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductionRequiredData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductionRequiredData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectProductionRequiredData.createdby = UtilSql.getValue(result, "createdby");
        objectProductionRequiredData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectProductionRequiredData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductionRequiredData.isactive = UtilSql.getValue(result, "isactive");
        objectProductionRequiredData.zssmProductionrequiredVId = UtilSql.getValue(result, "zssm_productionrequired_v_id");
        objectProductionRequiredData.product = UtilSql.getValue(result, "product");
        objectProductionRequiredData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectProductionRequiredData.lateststartdate = UtilSql.getDateValue(result, "lateststartdate", "dd-MM-yyyy");
        objectProductionRequiredData.requiredqty = UtilSql.getValue(result, "requiredqty");
        objectProductionRequiredData.qty = UtilSql.getValue(result, "qty");
        objectProductionRequiredData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectProductionRequiredData.dependentstartdate = UtilSql.getDateValue(result, "dependentstartdate", "dd-MM-yyyy");
        objectProductionRequiredData.curronhandqty = UtilSql.getValue(result, "curronhandqty");
        objectProductionRequiredData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductionRequiredData.cause = UtilSql.getValue(result, "cause");
        objectProductionRequiredData.causetext = UtilSql.getValue(result, "causetext");
        objectProductionRequiredData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductionRequiredData);
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
    ProductionRequiredData objectProductionRequiredData[] = new ProductionRequiredData[vector.size()];
    vector.copyInto(objectProductionRequiredData);
    return(objectProductionRequiredData);
  }

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String createdby, String updatedby, String qty, String startdate, String product, String pinstance, String cause, String enddate)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "  INSERT INTO ZSSM_PRODUCTIONRUN   (ZSSM_PRODUCTIONRUN_ID,AD_CLIENT_ID,AD_ORG_ID,ISACTIVE,CREATED,CREATEDBY,UPDATED,UPDATEDBY,REQUIREDQTY,NEEDBYDATE,M_PRODUCT_ID,ISAUTOTRIGGERED,PINSTANCE,cause,enddate)" +
      "  VALUES                           (get_uuid()           , ?          , ?       , 'Y'    , NOW() , ?       ,NOW()  , ?      ,TO_NUMBER(?),TO_DATE(?), ?          , 'N',?    ,?  ,to_date(?)     )";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pinstance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);

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

  public static String productionrun(ConnectionProvider connectionProvider, String pInstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssm_productionrun(?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pInstanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssm_productionrun");
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

  public static int deleteerror(ConnectionProvider connectionProvider, String pInstanceID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM ZSSM_PRODUCTIONRUN where c_project_id is null and pinstance = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pInstanceID);

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

  public static int deleteonload(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM zssm_manualproduction";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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

  public static int insertmanual(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String createdby, String updatedby, String qty, String product, String warehouse)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	  INSERT INTO zssm_manualproduction   (zssm_manualproduction_ID,AD_CLIENT_ID,AD_ORG_ID,CREATED,CREATEDBY,UPDATED,UPDATEDBY,QTY,M_PRODUCT_ID,M_WAREHOUSE_ID)" +
      "	  VALUES                           (get_uuid()           , ?          , ?           , NOW() , ?       ,NOW()  , ?      ,TO_NUMBER(?),?,? )";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);

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
}

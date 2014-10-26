//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ProductCategory;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class ProductCategoryData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductCategoryData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String name;
  public String description;
  public String isactive;
  public String isexternalservice;
  public String isselectableinproduction;
  public String isdefault;
  public String cTaxId;
  public String cTaxIdr;
  public String plannedmargin;
  public String aAssetGroupId;
  public String aAssetGroupIdr;
  public String mProductCategoryId;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isexternalservice"))
      return isexternalservice;
    else if (fieldName.equalsIgnoreCase("isselectableinproduction"))
      return isselectableinproduction;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("plannedmargin"))
      return plannedmargin;
    else if (fieldName.equalsIgnoreCase("a_asset_group_id") || fieldName.equals("aAssetGroupId"))
      return aAssetGroupId;
    else if (fieldName.equalsIgnoreCase("a_asset_group_idr") || fieldName.equals("aAssetGroupIdr"))
      return aAssetGroupIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static ProductCategoryData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductCategoryData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Product_Category.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product_Category.CreatedBy) as CreatedByR, " +
      "        to_char(M_Product_Category.Updated, ?) as updated, " +
      "        to_char(M_Product_Category.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Product_Category.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product_Category.UpdatedBy) as UpdatedByR," +
      "        M_Product_Category.AD_Client_ID, " +
      "(CASE WHEN M_Product_Category.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_Product_Category.AD_Org_ID, " +
      "(CASE WHEN M_Product_Category.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Product_Category.Value, " +
      "M_Product_Category.Name, " +
      "M_Product_Category.Description, " +
      "COALESCE(M_Product_Category.IsActive, 'N') AS IsActive, " +
      "COALESCE(M_Product_Category.Isexternalservice, 'N') AS Isexternalservice, " +
      "COALESCE(M_Product_Category.Isselectableinproduction, 'N') AS Isselectableinproduction, " +
      "COALESCE(M_Product_Category.IsDefault, 'N') AS IsDefault, " +
      "M_Product_Category.C_Tax_ID, " +
      "(CASE WHEN M_Product_Category.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "M_Product_Category.PlannedMargin, " +
      "M_Product_Category.A_Asset_Group_ID, " +
      "(CASE WHEN M_Product_Category.A_Asset_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS A_Asset_Group_IDR, " +
      "M_Product_Category.M_Product_Category_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Product_Category left join (select AD_Client_ID, Name from AD_Client) table1 on (M_Product_Category.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_Product_Category.AD_Org_ID = table2.AD_Org_ID) left join (select C_Tax_ID, Name from C_Tax) table3 on (M_Product_Category.C_Tax_ID = table3.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL3 on (table3.C_Tax_ID = tableTRL3.C_Tax_ID and tableTRL3.AD_Language = ?)  left join (select A_Asset_Group_ID, Name from A_Asset_Group) table4 on (M_Product_Category.A_Asset_Group_ID = table4.A_Asset_Group_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND M_Product_Category.M_Product_Category_ID = ? " +
      "        AND M_Product_Category.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Product_Category.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        ProductCategoryData objectProductCategoryData = new ProductCategoryData();
        objectProductCategoryData.created = UtilSql.getValue(result, "created");
        objectProductCategoryData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductCategoryData.updated = UtilSql.getValue(result, "updated");
        objectProductCategoryData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductCategoryData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductCategoryData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductCategoryData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductCategoryData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectProductCategoryData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductCategoryData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProductCategoryData.value = UtilSql.getValue(result, "value");
        objectProductCategoryData.name = UtilSql.getValue(result, "name");
        objectProductCategoryData.description = UtilSql.getValue(result, "description");
        objectProductCategoryData.isactive = UtilSql.getValue(result, "isactive");
        objectProductCategoryData.isexternalservice = UtilSql.getValue(result, "isexternalservice");
        objectProductCategoryData.isselectableinproduction = UtilSql.getValue(result, "isselectableinproduction");
        objectProductCategoryData.isdefault = UtilSql.getValue(result, "isdefault");
        objectProductCategoryData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectProductCategoryData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectProductCategoryData.plannedmargin = UtilSql.getValue(result, "plannedmargin");
        objectProductCategoryData.aAssetGroupId = UtilSql.getValue(result, "a_asset_group_id");
        objectProductCategoryData.aAssetGroupIdr = UtilSql.getValue(result, "a_asset_group_idr");
        objectProductCategoryData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectProductCategoryData.language = UtilSql.getValue(result, "language");
        objectProductCategoryData.adUserClient = "";
        objectProductCategoryData.adOrgClient = "";
        objectProductCategoryData.createdby = "";
        objectProductCategoryData.trBgcolor = "";
        objectProductCategoryData.totalCount = "";
        objectProductCategoryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductCategoryData);
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
    ProductCategoryData objectProductCategoryData[] = new ProductCategoryData[vector.size()];
    vector.copyInto(objectProductCategoryData);
    return(objectProductCategoryData);
  }

/**
Create a registry
 */
  public static ProductCategoryData[] set(String name, String updatedby, String updatedbyr, String isdefault, String isactive, String value, String plannedmargin, String cTaxId, String adOrgId, String description, String aAssetGroupId, String mProductCategoryId, String isselectableinproduction, String isexternalservice, String createdby, String createdbyr, String adClientId)    throws ServletException {
    ProductCategoryData objectProductCategoryData[] = new ProductCategoryData[1];
    objectProductCategoryData[0] = new ProductCategoryData();
    objectProductCategoryData[0].created = "";
    objectProductCategoryData[0].createdbyr = createdbyr;
    objectProductCategoryData[0].updated = "";
    objectProductCategoryData[0].updatedTimeStamp = "";
    objectProductCategoryData[0].updatedby = updatedby;
    objectProductCategoryData[0].updatedbyr = updatedbyr;
    objectProductCategoryData[0].adClientId = adClientId;
    objectProductCategoryData[0].adClientIdr = "";
    objectProductCategoryData[0].adOrgId = adOrgId;
    objectProductCategoryData[0].adOrgIdr = "";
    objectProductCategoryData[0].value = value;
    objectProductCategoryData[0].name = name;
    objectProductCategoryData[0].description = description;
    objectProductCategoryData[0].isactive = isactive;
    objectProductCategoryData[0].isexternalservice = isexternalservice;
    objectProductCategoryData[0].isselectableinproduction = isselectableinproduction;
    objectProductCategoryData[0].isdefault = isdefault;
    objectProductCategoryData[0].cTaxId = cTaxId;
    objectProductCategoryData[0].cTaxIdr = "";
    objectProductCategoryData[0].plannedmargin = plannedmargin;
    objectProductCategoryData[0].aAssetGroupId = aAssetGroupId;
    objectProductCategoryData[0].aAssetGroupIdr = "";
    objectProductCategoryData[0].mProductCategoryId = mProductCategoryId;
    objectProductCategoryData[0].language = "";
    return objectProductCategoryData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1775_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
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

/**
Select for auxiliar field
 */
  public static String selectDef1773_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_Product_Category" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Value = (?) , Name = (?) , Description = (?) , IsActive = (?) , Isexternalservice = (?) , Isselectableinproduction = (?) , IsDefault = (?) , C_Tax_ID = (?) , PlannedMargin = TO_NUMBER(?) , A_Asset_Group_ID = (?) , M_Product_Category_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Product_Category.M_Product_Category_ID = ? " +
      "        AND M_Product_Category.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Product_Category.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isexternalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselectableinproduction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

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

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_Product_Category " +
      "        (AD_Client_ID, AD_Org_ID, Value, Name, Description, IsActive, Isexternalservice, Isselectableinproduction, IsDefault, C_Tax_ID, PlannedMargin, A_Asset_Group_ID, M_Product_Category_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isexternalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselectableinproduction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmargin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Product_Category" +
      "        WHERE M_Product_Category.M_Product_Category_ID = ? " +
      "        AND M_Product_Category.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Product_Category.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Product_Category" +
      "        WHERE M_Product_Category.M_Product_Category_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM M_Product_Category" +
      "         WHERE M_Product_Category.M_Product_Category_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM M_Product_Category" +
      "         WHERE M_Product_Category.M_Product_Category_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
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

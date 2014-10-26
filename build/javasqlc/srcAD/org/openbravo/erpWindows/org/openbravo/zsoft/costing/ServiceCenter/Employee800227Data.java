//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.costing.ServiceCenter;

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
class Employee800227Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Employee800227Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String maCostcenterEmployeeId;
  public String adOrgId;
  public String adOrgIdr;
  public String maCostcenterVersionId;
  public String maCostcenterVersionIdr;
  public String isactive;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String quantity;
  public String costuom;
  public String costuomr;
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
    else if (fieldName.equalsIgnoreCase("ma_costcenter_employee_id") || fieldName.equals("maCostcenterEmployeeId"))
      return maCostcenterEmployeeId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_costcenter_version_id") || fieldName.equals("maCostcenterVersionId"))
      return maCostcenterVersionId;
    else if (fieldName.equalsIgnoreCase("ma_costcenter_version_idr") || fieldName.equals("maCostcenterVersionIdr"))
      return maCostcenterVersionIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("costuomr"))
      return costuomr;
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
  public static Employee800227Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maCostcenterVersionId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maCostcenterVersionId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Employee800227Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maCostcenterVersionId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Costcenter_Employee.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Costcenter_Employee.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Costcenter_Employee.Updated, ?) as updated, " +
      "        to_char(MA_Costcenter_Employee.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Costcenter_Employee.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Costcenter_Employee.UpdatedBy) as UpdatedByR," +
      "        MA_Costcenter_Employee.AD_Client_ID, " +
      "(CASE WHEN MA_Costcenter_Employee.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Costcenter_Employee.MA_Costcenter_Employee_ID, " +
      "MA_Costcenter_Employee.AD_Org_ID, " +
      "(CASE WHEN MA_Costcenter_Employee.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Costcenter_Employee.MA_Costcenter_Version_ID, " +
      "(CASE WHEN MA_Costcenter_Employee.MA_Costcenter_Version_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.ValidFrom, 'DD-MM-YYYY')),'') ) END) AS MA_Costcenter_Version_IDR, " +
      "COALESCE(MA_Costcenter_Employee.IsActive, 'N') AS IsActive, " +
      "MA_Costcenter_Employee.C_Salary_Category_ID, " +
      "(CASE WHEN MA_Costcenter_Employee.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "MA_Costcenter_Employee.Quantity, " +
      "MA_Costcenter_Employee.Costuom, " +
      "(CASE WHEN MA_Costcenter_Employee.Costuom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS CostuomR, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Costcenter_Employee left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Costcenter_Employee.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Costcenter_Employee.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Costcenter_Version_ID, DocumentNo, MA_Costcenter_ID, ValidFrom from MA_Costcenter_Version) table3 on (MA_Costcenter_Employee.MA_Costcenter_Version_ID = table3.MA_Costcenter_Version_ID) left join (select MA_Costcenter_ID, Name from MA_Costcenter) table4 on (table3.MA_Costcenter_ID = table4.MA_Costcenter_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table5 on (MA_Costcenter_Employee.C_Salary_Category_ID = table5.C_Salary_Category_ID) left join ad_ref_list_v list1 on (MA_Costcenter_Employee.Costuom = list1.value and list1.ad_reference_id = '800088' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maCostcenterVersionId==null || maCostcenterVersionId.equals(""))?"":"  AND MA_Costcenter_Employee.MA_Costcenter_Version_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Costcenter_Employee.MA_Costcenter_Employee_ID = ? " +
      "        AND MA_Costcenter_Employee.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Costcenter_Employee.AD_Org_ID IN (";
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
      if (maCostcenterVersionId != null && !(maCostcenterVersionId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
      }
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
        Employee800227Data objectEmployee800227Data = new Employee800227Data();
        objectEmployee800227Data.created = UtilSql.getValue(result, "created");
        objectEmployee800227Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEmployee800227Data.updated = UtilSql.getValue(result, "updated");
        objectEmployee800227Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEmployee800227Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectEmployee800227Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEmployee800227Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEmployee800227Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectEmployee800227Data.maCostcenterEmployeeId = UtilSql.getValue(result, "ma_costcenter_employee_id");
        objectEmployee800227Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEmployee800227Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectEmployee800227Data.maCostcenterVersionId = UtilSql.getValue(result, "ma_costcenter_version_id");
        objectEmployee800227Data.maCostcenterVersionIdr = UtilSql.getValue(result, "ma_costcenter_version_idr");
        objectEmployee800227Data.isactive = UtilSql.getValue(result, "isactive");
        objectEmployee800227Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectEmployee800227Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectEmployee800227Data.quantity = UtilSql.getValue(result, "quantity");
        objectEmployee800227Data.costuom = UtilSql.getValue(result, "costuom");
        objectEmployee800227Data.costuomr = UtilSql.getValue(result, "costuomr");
        objectEmployee800227Data.language = UtilSql.getValue(result, "language");
        objectEmployee800227Data.adUserClient = "";
        objectEmployee800227Data.adOrgClient = "";
        objectEmployee800227Data.createdby = "";
        objectEmployee800227Data.trBgcolor = "";
        objectEmployee800227Data.totalCount = "";
        objectEmployee800227Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmployee800227Data);
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
    Employee800227Data objectEmployee800227Data[] = new Employee800227Data[vector.size()];
    vector.copyInto(objectEmployee800227Data);
    return(objectEmployee800227Data);
  }

/**
Create a registry
 */
  public static Employee800227Data[] set(String maCostcenterVersionId, String cSalaryCategoryId, String updatedby, String updatedbyr, String maCostcenterEmployeeId, String isactive, String adClientId, String costuom, String createdby, String createdbyr, String quantity, String adOrgId)    throws ServletException {
    Employee800227Data objectEmployee800227Data[] = new Employee800227Data[1];
    objectEmployee800227Data[0] = new Employee800227Data();
    objectEmployee800227Data[0].created = "";
    objectEmployee800227Data[0].createdbyr = createdbyr;
    objectEmployee800227Data[0].updated = "";
    objectEmployee800227Data[0].updatedTimeStamp = "";
    objectEmployee800227Data[0].updatedby = updatedby;
    objectEmployee800227Data[0].updatedbyr = updatedbyr;
    objectEmployee800227Data[0].adClientId = adClientId;
    objectEmployee800227Data[0].adClientIdr = "";
    objectEmployee800227Data[0].maCostcenterEmployeeId = maCostcenterEmployeeId;
    objectEmployee800227Data[0].adOrgId = adOrgId;
    objectEmployee800227Data[0].adOrgIdr = "";
    objectEmployee800227Data[0].maCostcenterVersionId = maCostcenterVersionId;
    objectEmployee800227Data[0].maCostcenterVersionIdr = "";
    objectEmployee800227Data[0].isactive = isactive;
    objectEmployee800227Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectEmployee800227Data[0].cSalaryCategoryIdr = "";
    objectEmployee800227Data[0].quantity = quantity;
    objectEmployee800227Data[0].costuom = costuom;
    objectEmployee800227Data[0].costuomr = "";
    objectEmployee800227Data[0].language = "";
    return objectEmployee800227Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803168_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

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
  public static String selectDef803166_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MA_Costcenter_Employee.MA_Costcenter_Version_ID AS NAME" +
      "        FROM MA_Costcenter_Employee" +
      "        WHERE MA_Costcenter_Employee.MA_Costcenter_Employee_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String maCostcenterVersionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table1.ValidFrom, 'DD-MM-YYYY')) AS NAME FROM MA_Costcenter_Version left join (select MA_Costcenter_Version_ID, DocumentNo, MA_Costcenter_ID, ValidFrom from MA_Costcenter_Version) table1 on (MA_Costcenter_Version.MA_Costcenter_Version_ID = table1.MA_Costcenter_Version_ID) left join (select MA_Costcenter_ID, Name from MA_Costcenter) table2 on (table1.MA_Costcenter_ID = table2.MA_Costcenter_ID) WHERE MA_Costcenter_Version.MA_Costcenter_Version_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maCostcenterVersionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(table1.ValidFrom, 'DD-MM-YYYY')) AS NAME FROM MA_Costcenter_Version left join (select MA_Costcenter_Version_ID, DocumentNo, MA_Costcenter_ID, ValidFrom from MA_Costcenter_Version) table1 on (MA_Costcenter_Version.MA_Costcenter_Version_ID = table1.MA_Costcenter_Version_ID) left join (select MA_Costcenter_ID, Name from MA_Costcenter) table2 on (table1.MA_Costcenter_ID = table2.MA_Costcenter_ID) WHERE MA_Costcenter_Version.MA_Costcenter_Version_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
      "        UPDATE MA_Costcenter_Employee" +
      "        SET AD_Client_ID = (?) , MA_Costcenter_Employee_ID = (?) , AD_Org_ID = (?) , MA_Costcenter_Version_ID = (?) , IsActive = (?) , C_Salary_Category_ID = (?) , Quantity = TO_NUMBER(?) , Costuom = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Costcenter_Employee.MA_Costcenter_Employee_ID = ? " +
      "                 AND MA_Costcenter_Employee.MA_Costcenter_Version_ID = ? " +
      "        AND MA_Costcenter_Employee.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Costcenter_Employee.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterEmployeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterEmployeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
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
      "        INSERT INTO MA_Costcenter_Employee " +
      "        (AD_Client_ID, MA_Costcenter_Employee_ID, AD_Org_ID, MA_Costcenter_Version_ID, IsActive, C_Salary_Category_ID, Quantity, Costuom, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterEmployeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maCostcenterVersionId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Costcenter_Employee" +
      "        WHERE MA_Costcenter_Employee.MA_Costcenter_Employee_ID = ? " +
      "                 AND MA_Costcenter_Employee.MA_Costcenter_Version_ID = ? " +
      "        AND MA_Costcenter_Employee.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Costcenter_Employee.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maCostcenterVersionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Costcenter_Employee" +
      "        WHERE MA_Costcenter_Employee.MA_Costcenter_Employee_ID = ? " +
      "                 AND MA_Costcenter_Employee.MA_Costcenter_Version_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);

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
      "          FROM MA_Costcenter_Employee" +
      "         WHERE MA_Costcenter_Employee.MA_Costcenter_Employee_ID = ? ";

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
      "          FROM MA_Costcenter_Employee" +
      "         WHERE MA_Costcenter_Employee.MA_Costcenter_Employee_ID = ? ";

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

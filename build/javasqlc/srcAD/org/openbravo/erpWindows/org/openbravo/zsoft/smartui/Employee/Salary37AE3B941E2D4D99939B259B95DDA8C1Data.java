//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.Employee;

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
class Salary37AE3B941E2D4D99939B259B95DDA8C1Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Salary37AE3B941E2D4D99939B259B95DDA8C1Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cBpSalcategoryId;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String adClientId;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String wageMonthly;
  public String adOrgId;
  public String wageHourly;
  public String datefrom;
  public String note1;
  public String note2;
  public String note3;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("c_bp_salcategory_id") || fieldName.equals("cBpSalcategoryId"))
      return cBpSalcategoryId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("wage_monthly") || fieldName.equals("wageMonthly"))
      return wageMonthly;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("wage_hourly") || fieldName.equals("wageHourly"))
      return wageHourly;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("note1"))
      return note1;
    else if (fieldName.equalsIgnoreCase("note2"))
      return note2;
    else if (fieldName.equalsIgnoreCase("note3"))
      return note3;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static Salary37AE3B941E2D4D99939B259B95DDA8C1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Salary37AE3B941E2D4D99939B259B95DDA8C1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_BP_SALCATEGORY.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BP_SALCATEGORY.CreatedBy) as CreatedByR, " +
      "        to_char(C_BP_SALCATEGORY.Updated, ?) as updated, " +
      "        to_char(C_BP_SALCATEGORY.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_BP_SALCATEGORY.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_BP_SALCATEGORY.UpdatedBy) as UpdatedByR," +
      "        C_BP_SALCATEGORY.C_Bp_Salcategory_ID, " +
      "C_BP_SALCATEGORY.C_BPartner_ID, " +
      "(CASE WHEN C_BP_SALCATEGORY.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "C_BP_SALCATEGORY.AD_Client_ID, " +
      "C_BP_SALCATEGORY.C_Salary_Category_ID, " +
      "(CASE WHEN C_BP_SALCATEGORY.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "C_BP_SALCATEGORY.Wage_Monthly, " +
      "C_BP_SALCATEGORY.AD_Org_ID, " +
      "C_BP_SALCATEGORY.Wage_Hourly, " +
      "C_BP_SALCATEGORY.Datefrom, " +
      "C_BP_SALCATEGORY.Note1, " +
      "C_BP_SALCATEGORY.Note2, " +
      "C_BP_SALCATEGORY.Note3, " +
      "COALESCE(C_BP_SALCATEGORY.IsActive, 'N') AS IsActive, " +
      "        ? AS LANGUAGE " +
      "        FROM C_BP_SALCATEGORY left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_BP_SALCATEGORY.C_BPartner_ID = table1.C_BPartner_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table2 on (C_BP_SALCATEGORY.C_Salary_Category_ID = table2.C_Salary_Category_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BP_SALCATEGORY.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND C_BP_SALCATEGORY.C_Bp_Salcategory_ID = ? " +
      "        AND C_BP_SALCATEGORY.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_BP_SALCATEGORY.AD_Org_ID IN (";
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
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
        Salary37AE3B941E2D4D99939B259B95DDA8C1Data objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data = new Salary37AE3B941E2D4D99939B259B95DDA8C1Data();
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.created = UtilSql.getValue(result, "created");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.updated = UtilSql.getValue(result, "updated");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.cBpSalcategoryId = UtilSql.getValue(result, "c_bp_salcategory_id");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.wageMonthly = UtilSql.getValue(result, "wage_monthly");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.wageHourly = UtilSql.getValue(result, "wage_hourly");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.note1 = UtilSql.getValue(result, "note1");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.note2 = UtilSql.getValue(result, "note2");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.note3 = UtilSql.getValue(result, "note3");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.isactive = UtilSql.getValue(result, "isactive");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.language = UtilSql.getValue(result, "language");
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.adUserClient = "";
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.adOrgClient = "";
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.createdby = "";
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.trBgcolor = "";
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.totalCount = "";
        objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data);
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
    Salary37AE3B941E2D4D99939B259B95DDA8C1Data objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[] = new Salary37AE3B941E2D4D99939B259B95DDA8C1Data[vector.size()];
    vector.copyInto(objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data);
    return(objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data);
  }

/**
Create a registry
 */
  public static Salary37AE3B941E2D4D99939B259B95DDA8C1Data[] set(String cBpartnerId, String cBpSalcategoryId, String cSalaryCategoryId, String note2, String isactive, String wageMonthly, String cBpartnerIdr, String note3, String note1, String createdby, String createdbyr, String adClientId, String adOrgId, String datefrom, String updatedby, String updatedbyr, String wageHourly)    throws ServletException {
    Salary37AE3B941E2D4D99939B259B95DDA8C1Data objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[] = new Salary37AE3B941E2D4D99939B259B95DDA8C1Data[1];
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0] = new Salary37AE3B941E2D4D99939B259B95DDA8C1Data();
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].created = "";
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].createdbyr = createdbyr;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].updated = "";
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].updatedTimeStamp = "";
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].updatedby = updatedby;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].updatedbyr = updatedbyr;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].cBpSalcategoryId = cBpSalcategoryId;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].cBpartnerId = cBpartnerId;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].cBpartnerIdr = cBpartnerIdr;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].adClientId = adClientId;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].cSalaryCategoryIdr = "";
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].wageMonthly = wageMonthly;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].adOrgId = adOrgId;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].wageHourly = wageHourly;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].datefrom = datefrom;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].note1 = note1;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].note2 = note2;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].note3 = note3;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].isactive = isactive;
    objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data[0].language = "";
    return objectSalary37AE3B941E2D4D99939B259B95DDA8C1Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1005100008_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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
  public static String selectDef1005100005_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef1005100007_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BP_SALCATEGORY.C_BPartner_ID AS NAME" +
      "        FROM C_BP_SALCATEGORY" +
      "        WHERE C_BP_SALCATEGORY.C_Bp_Salcategory_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM c_bpartneremployee_view left join (select C_BPartner_ID, Name from C_BPartner) table1 on (c_bpartneremployee_view.C_BPartner_ID = table1.C_BPartner_ID) WHERE c_bpartneremployee_view.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM c_bpartneremployee_view left join (select C_BPartner_ID, Name from C_BPartner) table1 on (c_bpartneremployee_view.C_BPartner_ID = table1.C_BPartner_ID) WHERE c_bpartneremployee_view.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
      "        UPDATE C_BP_SALCATEGORY" +
      "        SET C_Bp_Salcategory_ID = (?) , C_BPartner_ID = (?) , AD_Client_ID = (?) , C_Salary_Category_ID = (?) , Wage_Monthly = TO_NUMBER(?) , AD_Org_ID = (?) , Wage_Hourly = TO_NUMBER(?) , Datefrom = TO_DATE(?) , Note1 = (?) , Note2 = (?) , Note3 = (?) , IsActive = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_BP_SALCATEGORY.C_Bp_Salcategory_ID = ? " +
      "                 AND C_BP_SALCATEGORY.C_BPartner_ID = ? " +
      "        AND C_BP_SALCATEGORY.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BP_SALCATEGORY.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpSalcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wageMonthly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wageHourly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpSalcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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
      "        INSERT INTO C_BP_SALCATEGORY " +
      "        (C_Bp_Salcategory_ID, C_BPartner_ID, AD_Client_ID, C_Salary_Category_ID, Wage_Monthly, AD_Org_ID, Wage_Hourly, Datefrom, Note1, Note2, Note3, IsActive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpSalcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wageMonthly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, wageHourly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BP_SALCATEGORY" +
      "        WHERE C_BP_SALCATEGORY.C_Bp_Salcategory_ID = ? " +
      "                 AND C_BP_SALCATEGORY.C_BPartner_ID = ? " +
      "        AND C_BP_SALCATEGORY.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_BP_SALCATEGORY.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_BP_SALCATEGORY" +
      "        WHERE C_BP_SALCATEGORY.C_Bp_Salcategory_ID = ? " +
      "                 AND C_BP_SALCATEGORY.C_BPartner_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
      "          FROM C_BP_SALCATEGORY" +
      "         WHERE C_BP_SALCATEGORY.C_Bp_Salcategory_ID = ? ";

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
      "          FROM C_BP_SALCATEGORY" +
      "         WHERE C_BP_SALCATEGORY.C_Bp_Salcategory_ID = ? ";

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

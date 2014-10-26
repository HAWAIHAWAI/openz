//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.CRMToDoList;

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
class Main8FBAA16AD68140C8AF41D76BB9B882F1Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Main8FBAA16AD68140C8AF41D76BB9B882F1Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiNotes4customerId;
  public String zssiNotes4customerIdr;
  public String zssiCrmTodosId;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String dateofcontact;
  public String typeofcontact;
  public String followup;
  public String contactto;
  public String emp;
  public String empr;
  public String description;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String cProjectId;
  public String cProjectIdr;
  public String adClientId;
  public String adClientIdr;
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
    else if (fieldName.equalsIgnoreCase("zssi_notes4customer_id") || fieldName.equals("zssiNotes4customerId"))
      return zssiNotes4customerId;
    else if (fieldName.equalsIgnoreCase("zssi_notes4customer_idr") || fieldName.equals("zssiNotes4customerIdr"))
      return zssiNotes4customerIdr;
    else if (fieldName.equalsIgnoreCase("zssi_crm_todos_id") || fieldName.equals("zssiCrmTodosId"))
      return zssiCrmTodosId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("dateofcontact"))
      return dateofcontact;
    else if (fieldName.equalsIgnoreCase("typeofcontact"))
      return typeofcontact;
    else if (fieldName.equalsIgnoreCase("followup"))
      return followup;
    else if (fieldName.equalsIgnoreCase("contactto"))
      return contactto;
    else if (fieldName.equalsIgnoreCase("emp"))
      return emp;
    else if (fieldName.equalsIgnoreCase("empr"))
      return empr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
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
  public static Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_crm_todos.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_crm_todos.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_crm_todos.Updated, ?) as updated, " +
      "        to_char(zssi_crm_todos.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_crm_todos.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_crm_todos.UpdatedBy) as UpdatedByR," +
      "        zssi_crm_todos.Zssi_Notes4customer_ID, " +
      "(CASE WHEN zssi_crm_todos.Zssi_Notes4customer_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(table1.Dateofcontact, 'DD-MM-YYYY')),'') ) END) AS Zssi_Notes4customer_IDR, " +
      "zssi_crm_todos.Zssi_Crm_Todos_ID, " +
      "zssi_crm_todos.C_Bpartner_ID, " +
      "(CASE WHEN zssi_crm_todos.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "zssi_crm_todos.Dateofcontact, " +
      "zssi_crm_todos.Typeofcontact, " +
      "zssi_crm_todos.Followup, " +
      "zssi_crm_todos.Contactto, " +
      "zssi_crm_todos.Emp, " +
      "(CASE WHEN zssi_crm_todos.Emp IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS EmpR, " +
      "zssi_crm_todos.Description, " +
      "zssi_crm_todos.AD_Org_ID, " +
      "(CASE WHEN zssi_crm_todos.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(zssi_crm_todos.Isactive, 'N') AS Isactive, " +
      "zssi_crm_todos.C_Project_ID, " +
      "(CASE WHEN zssi_crm_todos.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "zssi_crm_todos.AD_Client_ID, " +
      "(CASE WHEN zssi_crm_todos.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_crm_todos left join (select Zssi_Notes4customer_ID, Dateofcontact from zssi_notes4customer) table1 on (zssi_crm_todos.Zssi_Notes4customer_ID =  table1.Zssi_Notes4customer_ID) left join (select C_BPartner_ID, Name from C_BPartner) table2 on (zssi_crm_todos.C_Bpartner_ID = table2.C_BPartner_ID) left join (select AD_User_ID, Name from AD_User) table3 on (zssi_crm_todos.Emp =  table3.AD_User_ID) left join (select AD_Org_ID, Name from AD_Org) table4 on (zssi_crm_todos.AD_Org_ID = table4.AD_Org_ID) left join (select C_Project_ID, Value, Name from C_Project) table5 on (zssi_crm_todos.C_Project_ID = table5.C_Project_ID) left join (select AD_Client_ID, Name from AD_Client) table6 on (zssi_crm_todos.AD_Client_ID = table6.AD_Client_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_crm_todos.Zssi_Crm_Todos_ID = ? " +
      "        AND zssi_crm_todos.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_crm_todos.AD_Org_ID IN (";
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
        Main8FBAA16AD68140C8AF41D76BB9B882F1Data objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data();
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.created = UtilSql.getValue(result, "created");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.updated = UtilSql.getValue(result, "updated");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.zssiNotes4customerId = UtilSql.getValue(result, "zssi_notes4customer_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.zssiNotes4customerIdr = UtilSql.getValue(result, "zssi_notes4customer_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.zssiCrmTodosId = UtilSql.getValue(result, "zssi_crm_todos_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.dateofcontact = UtilSql.getDateValue(result, "dateofcontact", "dd-MM-yyyy");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.typeofcontact = UtilSql.getValue(result, "typeofcontact");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.followup = UtilSql.getDateValue(result, "followup", "dd-MM-yyyy");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.contactto = UtilSql.getValue(result, "contactto");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.emp = UtilSql.getValue(result, "emp");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.empr = UtilSql.getValue(result, "empr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.description = UtilSql.getValue(result, "description");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.isactive = UtilSql.getValue(result, "isactive");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.language = UtilSql.getValue(result, "language");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adUserClient = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adOrgClient = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.createdby = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.trBgcolor = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.totalCount = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data);
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
    Main8FBAA16AD68140C8AF41D76BB9B882F1Data objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[] = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data[vector.size()];
    vector.copyInto(objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data);
    return(objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data);
  }

/**
Create a registry
 */
  public static Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] set(String typeofcontact, String cBpartnerId, String cBpartnerIdr, String adClientId, String dateofcontact, String adOrgId, String zssiNotes4customerId, String createdby, String createdbyr, String contactto, String isactive, String zssiCrmTodosId, String followup, String description, String updatedby, String updatedbyr, String emp, String cProjectId, String cProjectIdr)    throws ServletException {
    Main8FBAA16AD68140C8AF41D76BB9B882F1Data objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[] = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data[1];
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0] = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data();
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].created = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].createdbyr = createdbyr;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].updated = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].updatedTimeStamp = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].updatedby = updatedby;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].updatedbyr = updatedbyr;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].zssiNotes4customerId = zssiNotes4customerId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].zssiNotes4customerIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].zssiCrmTodosId = zssiCrmTodosId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cBpartnerId = cBpartnerId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cBpartnerIdr = cBpartnerIdr;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].dateofcontact = dateofcontact;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].typeofcontact = typeofcontact;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].followup = followup;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].contactto = contactto;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].emp = emp;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].empr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].description = description;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adOrgId = adOrgId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adOrgIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].isactive = isactive;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cProjectId = cProjectId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cProjectIdr = cProjectIdr;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adClientId = adClientId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adClientIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].language = "";
    return objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefE9B069BC2DB2453EB7E50F707D9F26E0_0(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

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
  public static String selectDef0D94B38F7A9247778C492907CEE9F26D_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef397FD6A49D3942399C6809AA2A07DF72_2(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef9F7897511B614543BEBE3D6395AC15B3_3(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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
      "        UPDATE zssi_crm_todos" +
      "        SET Zssi_Notes4customer_ID = (?) , Zssi_Crm_Todos_ID = (?) , C_Bpartner_ID = (?) , Dateofcontact = TO_DATE(?) , Typeofcontact = (?) , Followup = TO_DATE(?) , Contactto = (?) , Emp = (?) , Description = (?) , AD_Org_ID = (?) , Isactive = (?) , C_Project_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? " +
      "        AND zssi_crm_todos.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_crm_todos.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiNotes4customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmTodosId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateofcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emp);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmTodosId);
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
      "        INSERT INTO zssi_crm_todos " +
      "        (Zssi_Notes4customer_ID, Zssi_Crm_Todos_ID, C_Bpartner_ID, Dateofcontact, Typeofcontact, Followup, Contactto, Emp, Description, AD_Org_ID, Isactive, C_Project_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiNotes4customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmTodosId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateofcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emp);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        DELETE FROM zssi_crm_todos" +
      "        WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? " +
      "        AND zssi_crm_todos.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_crm_todos.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_crm_todos" +
      "        WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? ";

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
      "          FROM zssi_crm_todos" +
      "         WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? ";

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
      "          FROM zssi_crm_todos" +
      "         WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? ";

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

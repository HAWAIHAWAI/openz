//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.SalesInvoice;

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
class Textmodule850167A91FFF4B73A040090913FFF812Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Textmodule850167A91FFF4B73A040090913FFF812Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cInvoiceId;
  public String cInvoiceIdr;
  public String zssiInvoiceTextmoduleId;
  public String zssiTextmoduleId;
  public String zssiTextmoduleIdr;
  public String line;
  public String adClientId;
  public String adOrgId;
  public String islower;
  public String ismodified;
  public String text;
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
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_invoice_idr") || fieldName.equals("cInvoiceIdr"))
      return cInvoiceIdr;
    else if (fieldName.equalsIgnoreCase("zssi_invoice_textmodule_id") || fieldName.equals("zssiInvoiceTextmoduleId"))
      return zssiInvoiceTextmoduleId;
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_id") || fieldName.equals("zssiTextmoduleId"))
      return zssiTextmoduleId;
    else if (fieldName.equalsIgnoreCase("zssi_textmodule_idr") || fieldName.equals("zssiTextmoduleIdr"))
      return zssiTextmoduleIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("islower"))
      return islower;
    else if (fieldName.equalsIgnoreCase("ismodified"))
      return ismodified;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
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
  public static Textmodule850167A91FFF4B73A040090913FFF812Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cInvoiceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cInvoiceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Textmodule850167A91FFF4B73A040090913FFF812Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cInvoiceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_invoice_textmodule.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_invoice_textmodule.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_invoice_textmodule.Updated, ?) as updated, " +
      "        to_char(zssi_invoice_textmodule.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_invoice_textmodule.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_invoice_textmodule.UpdatedBy) as UpdatedByR," +
      "        zssi_invoice_textmodule.C_Invoice_ID, " +
      "(CASE WHEN zssi_invoice_textmodule.C_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table1.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))),'') ) END) AS C_Invoice_IDR, " +
      "zssi_invoice_textmodule.Zssi_Invoice_Textmodule_ID, " +
      "zssi_invoice_textmodule.Zssi_Textmodule_ID, " +
      "(CASE WHEN zssi_invoice_textmodule.Zssi_Textmodule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Position), ''))),'') ) END) AS Zssi_Textmodule_IDR, " +
      "zssi_invoice_textmodule.Line, " +
      "zssi_invoice_textmodule.AD_Client_ID, " +
      "zssi_invoice_textmodule.AD_Org_ID, " +
      "COALESCE(zssi_invoice_textmodule.Islower, 'N') AS Islower, " +
      "COALESCE(zssi_invoice_textmodule.Ismodified, 'N') AS Ismodified, " +
      "zssi_invoice_textmodule.Text, " +
      "COALESCE(zssi_invoice_textmodule.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_invoice_textmodule left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table1 on (zssi_invoice_textmodule.C_Invoice_ID = table1.C_Invoice_ID) left join (select Zssi_Textmodule_ID, Name, Position from Zssi_Textmodule) table2 on (zssi_invoice_textmodule.Zssi_Textmodule_ID = table2.Zssi_Textmodule_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cInvoiceId==null || cInvoiceId.equals(""))?"":"  AND zssi_invoice_textmodule.C_Invoice_ID = ?  ");
    strSql = strSql + 
      "        AND zssi_invoice_textmodule.Zssi_Invoice_Textmodule_ID = ? " +
      "        AND zssi_invoice_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_invoice_textmodule.AD_Org_ID IN (";
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
      if (cInvoiceId != null && !(cInvoiceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
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
        Textmodule850167A91FFF4B73A040090913FFF812Data objectTextmodule850167A91FFF4B73A040090913FFF812Data = new Textmodule850167A91FFF4B73A040090913FFF812Data();
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.created = UtilSql.getValue(result, "created");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.updated = UtilSql.getValue(result, "updated");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.cInvoiceIdr = UtilSql.getValue(result, "c_invoice_idr");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.zssiInvoiceTextmoduleId = UtilSql.getValue(result, "zssi_invoice_textmodule_id");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.zssiTextmoduleId = UtilSql.getValue(result, "zssi_textmodule_id");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.zssiTextmoduleIdr = UtilSql.getValue(result, "zssi_textmodule_idr");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.line = UtilSql.getValue(result, "line");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.islower = UtilSql.getValue(result, "islower");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.ismodified = UtilSql.getValue(result, "ismodified");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.text = UtilSql.getValue(result, "text");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.isactive = UtilSql.getValue(result, "isactive");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.language = UtilSql.getValue(result, "language");
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.adUserClient = "";
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.adOrgClient = "";
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.createdby = "";
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.trBgcolor = "";
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.totalCount = "";
        objectTextmodule850167A91FFF4B73A040090913FFF812Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTextmodule850167A91FFF4B73A040090913FFF812Data);
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
    Textmodule850167A91FFF4B73A040090913FFF812Data objectTextmodule850167A91FFF4B73A040090913FFF812Data[] = new Textmodule850167A91FFF4B73A040090913FFF812Data[vector.size()];
    vector.copyInto(objectTextmodule850167A91FFF4B73A040090913FFF812Data);
    return(objectTextmodule850167A91FFF4B73A040090913FFF812Data);
  }

/**
Create a registry
 */
  public static Textmodule850167A91FFF4B73A040090913FFF812Data[] set(String cInvoiceId, String text, String islower, String adClientId, String updatedby, String updatedbyr, String zssiInvoiceTextmoduleId, String isactive, String zssiTextmoduleId, String line, String ismodified, String adOrgId, String createdby, String createdbyr)    throws ServletException {
    Textmodule850167A91FFF4B73A040090913FFF812Data objectTextmodule850167A91FFF4B73A040090913FFF812Data[] = new Textmodule850167A91FFF4B73A040090913FFF812Data[1];
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0] = new Textmodule850167A91FFF4B73A040090913FFF812Data();
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].created = "";
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].createdbyr = createdbyr;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].updated = "";
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].updatedTimeStamp = "";
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].updatedby = updatedby;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].updatedbyr = updatedbyr;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].cInvoiceId = cInvoiceId;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].cInvoiceIdr = "";
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].zssiInvoiceTextmoduleId = zssiInvoiceTextmoduleId;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].zssiTextmoduleId = zssiTextmoduleId;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].zssiTextmoduleIdr = "";
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].line = line;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].adClientId = adClientId;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].adOrgId = adOrgId;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].islower = islower;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].ismodified = ismodified;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].text = text;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].isactive = isactive;
    objectTextmodule850167A91FFF4B73A040090913FFF812Data[0].language = "";
    return objectTextmodule850167A91FFF4B73A040090913FFF812Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefCA72DED8A8B54E28AFD38CEF7A76ADF3_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef5F5333DFA5DF47B9AF41312AC04B20C0(ConnectionProvider connectionProvider, String c_invoice_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM ZSSI_INVOICE_TEXTMODULE WHERE c_invoice_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_invoice_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDefB0C596732B724681A4F37BAF149E4266_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zssi_invoice_textmodule.C_Invoice_ID AS NAME" +
      "        FROM zssi_invoice_textmodule" +
      "        WHERE zssi_invoice_textmodule.Zssi_Invoice_Textmodule_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.DateInvoiced, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Invoice left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table1 on (C_Invoice.C_Invoice_ID = table1.C_Invoice_ID) WHERE C_Invoice.C_Invoice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.DateInvoiced, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.GrandTotal), ''))) AS NAME FROM C_Invoice left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table1 on (C_Invoice.C_Invoice_ID = table1.C_Invoice_ID) WHERE C_Invoice.C_Invoice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
      "        UPDATE zssi_invoice_textmodule" +
      "        SET C_Invoice_ID = (?) , Zssi_Invoice_Textmodule_ID = (?) , Zssi_Textmodule_ID = (?) , Line = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Islower = (?) , Ismodified = (?) , Text = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_invoice_textmodule.Zssi_Invoice_Textmodule_ID = ? " +
      "                 AND zssi_invoice_textmodule.C_Invoice_ID = ? " +
      "        AND zssi_invoice_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_invoice_textmodule.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiInvoiceTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islower);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismodified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiInvoiceTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
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
      "        INSERT INTO zssi_invoice_textmodule " +
      "        (C_Invoice_ID, Zssi_Invoice_Textmodule_ID, Zssi_Textmodule_ID, Line, AD_Client_ID, AD_Org_ID, Islower, Ismodified, Text, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiInvoiceTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiTextmoduleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islower);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismodified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cInvoiceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_invoice_textmodule" +
      "        WHERE zssi_invoice_textmodule.Zssi_Invoice_Textmodule_ID = ? " +
      "                 AND zssi_invoice_textmodule.C_Invoice_ID = ? " +
      "        AND zssi_invoice_textmodule.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_invoice_textmodule.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zssi_invoice_textmodule" +
      "        WHERE zssi_invoice_textmodule.Zssi_Invoice_Textmodule_ID = ? " +
      "                 AND zssi_invoice_textmodule.C_Invoice_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
      "          FROM zssi_invoice_textmodule" +
      "         WHERE zssi_invoice_textmodule.Zssi_Invoice_Textmodule_ID = ? ";

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
      "          FROM zssi_invoice_textmodule" +
      "         WHERE zssi_invoice_textmodule.Zssi_Invoice_Textmodule_ID = ? ";

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

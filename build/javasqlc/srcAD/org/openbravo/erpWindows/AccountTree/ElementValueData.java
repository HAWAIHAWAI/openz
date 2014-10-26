//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountTree;

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
class ElementValueData implements FieldProvider {
static Logger log4j = Logger.getLogger(ElementValueData.class);
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
  public String showvaluecond;
  public String cElementId;
  public String cElementIdr;
  public String elementlevel;
  public String value;
  public String name;
  public String description;
  public String isactive;
  public String accounttype;
  public String accounttyper;
  public String postactual;
  public String accountsign;
  public String accountsignr;
  public String showelement;
  public String isdoccontrolled;
  public String datevuseauto;
  public String nomanualacct;
  public String postencumbrance;
  public String cCurrencyId;
  public String isforeigncurrency;
  public String isbankaccount;
  public String cElementvalueId;
  public String postbudget;
  public String poststatistical;
  public String issummary;
  public String validto;
  public String validfrom;
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
    else if (fieldName.equalsIgnoreCase("showvaluecond"))
      return showvaluecond;
    else if (fieldName.equalsIgnoreCase("c_element_id") || fieldName.equals("cElementId"))
      return cElementId;
    else if (fieldName.equalsIgnoreCase("c_element_idr") || fieldName.equals("cElementIdr"))
      return cElementIdr;
    else if (fieldName.equalsIgnoreCase("elementlevel"))
      return elementlevel;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("accounttype"))
      return accounttype;
    else if (fieldName.equalsIgnoreCase("accounttyper"))
      return accounttyper;
    else if (fieldName.equalsIgnoreCase("postactual"))
      return postactual;
    else if (fieldName.equalsIgnoreCase("accountsign"))
      return accountsign;
    else if (fieldName.equalsIgnoreCase("accountsignr"))
      return accountsignr;
    else if (fieldName.equalsIgnoreCase("showelement"))
      return showelement;
    else if (fieldName.equalsIgnoreCase("isdoccontrolled"))
      return isdoccontrolled;
    else if (fieldName.equalsIgnoreCase("datevuseauto"))
      return datevuseauto;
    else if (fieldName.equalsIgnoreCase("nomanualacct"))
      return nomanualacct;
    else if (fieldName.equalsIgnoreCase("postencumbrance"))
      return postencumbrance;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("isforeigncurrency"))
      return isforeigncurrency;
    else if (fieldName.equalsIgnoreCase("isbankaccount"))
      return isbankaccount;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("postbudget"))
      return postbudget;
    else if (fieldName.equalsIgnoreCase("poststatistical"))
      return poststatistical;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("validto"))
      return validto;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
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
  public static ElementValueData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cElementId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cElementId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ElementValueData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cElementId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_ElementValue.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ElementValue.CreatedBy) as CreatedByR, " +
      "        to_char(C_ElementValue.Updated, ?) as updated, " +
      "        to_char(C_ElementValue.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_ElementValue.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ElementValue.UpdatedBy) as UpdatedByR," +
      "        C_ElementValue.AD_Client_ID, " +
      "(CASE WHEN C_ElementValue.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_ElementValue.AD_Org_ID, " +
      "(CASE WHEN C_ElementValue.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_ElementValue.ShowValueCond, " +
      "C_ElementValue.C_Element_ID, " +
      "(CASE WHEN C_ElementValue.C_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Element_IDR, " +
      "C_ElementValue.ElementLevel, " +
      "C_ElementValue.Value, " +
      "C_ElementValue.Name, " +
      "C_ElementValue.Description, " +
      "COALESCE(C_ElementValue.IsActive, 'N') AS IsActive, " +
      "C_ElementValue.AccountType, " +
      "(CASE WHEN C_ElementValue.AccountType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS AccountTypeR, " +
      "COALESCE(C_ElementValue.PostActual, 'N') AS PostActual, " +
      "C_ElementValue.AccountSign, " +
      "(CASE WHEN C_ElementValue.AccountSign IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS AccountSignR, " +
      "COALESCE(C_ElementValue.ShowElement, 'N') AS ShowElement, " +
      "COALESCE(C_ElementValue.IsDocControlled, 'N') AS IsDocControlled, " +
      "COALESCE(C_ElementValue.Datevuseauto, 'N') AS Datevuseauto, " +
      "COALESCE(C_ElementValue.Nomanualacct, 'N') AS Nomanualacct, " +
      "COALESCE(C_ElementValue.PostEncumbrance, 'N') AS PostEncumbrance, " +
      "C_ElementValue.C_Currency_ID, " +
      "COALESCE(C_ElementValue.IsForeignCurrency, 'N') AS IsForeignCurrency, " +
      "COALESCE(C_ElementValue.IsBankAccount, 'N') AS IsBankAccount, " +
      "C_ElementValue.C_ElementValue_ID, " +
      "COALESCE(C_ElementValue.PostBudget, 'N') AS PostBudget, " +
      "COALESCE(C_ElementValue.PostStatistical, 'N') AS PostStatistical, " +
      "COALESCE(C_ElementValue.IsSummary, 'N') AS IsSummary, " +
      "C_ElementValue.ValidTo, " +
      "C_ElementValue.ValidFrom, " +
      "        ? AS LANGUAGE " +
      "        FROM C_ElementValue left join (select AD_Client_ID, Name from AD_Client) table1 on (C_ElementValue.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_ElementValue.AD_Org_ID = table2.AD_Org_ID) left join (select C_Element_ID, Name from C_Element) table3 on (C_ElementValue.C_Element_ID = table3.C_Element_ID) left join ad_ref_list_v list1 on (C_ElementValue.AccountType = list1.value and list1.ad_reference_id = '117' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (C_ElementValue.AccountSign = list2.value and list2.ad_reference_id = '118' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cElementId==null || cElementId.equals(""))?"":"  AND C_ElementValue.C_Element_ID = ?  ");
    strSql = strSql + 
      "        AND C_ElementValue.C_ElementValue_ID = ? " +
      "        AND C_ElementValue.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_ElementValue.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (cElementId != null && !(cElementId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
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
        ElementValueData objectElementValueData = new ElementValueData();
        objectElementValueData.created = UtilSql.getValue(result, "created");
        objectElementValueData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectElementValueData.updated = UtilSql.getValue(result, "updated");
        objectElementValueData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectElementValueData.updatedby = UtilSql.getValue(result, "updatedby");
        objectElementValueData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectElementValueData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectElementValueData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectElementValueData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectElementValueData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectElementValueData.showvaluecond = UtilSql.getValue(result, "showvaluecond");
        objectElementValueData.cElementId = UtilSql.getValue(result, "c_element_id");
        objectElementValueData.cElementIdr = UtilSql.getValue(result, "c_element_idr");
        objectElementValueData.elementlevel = UtilSql.getValue(result, "elementlevel");
        objectElementValueData.value = UtilSql.getValue(result, "value");
        objectElementValueData.name = UtilSql.getValue(result, "name");
        objectElementValueData.description = UtilSql.getValue(result, "description");
        objectElementValueData.isactive = UtilSql.getValue(result, "isactive");
        objectElementValueData.accounttype = UtilSql.getValue(result, "accounttype");
        objectElementValueData.accounttyper = UtilSql.getValue(result, "accounttyper");
        objectElementValueData.postactual = UtilSql.getValue(result, "postactual");
        objectElementValueData.accountsign = UtilSql.getValue(result, "accountsign");
        objectElementValueData.accountsignr = UtilSql.getValue(result, "accountsignr");
        objectElementValueData.showelement = UtilSql.getValue(result, "showelement");
        objectElementValueData.isdoccontrolled = UtilSql.getValue(result, "isdoccontrolled");
        objectElementValueData.datevuseauto = UtilSql.getValue(result, "datevuseauto");
        objectElementValueData.nomanualacct = UtilSql.getValue(result, "nomanualacct");
        objectElementValueData.postencumbrance = UtilSql.getValue(result, "postencumbrance");
        objectElementValueData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectElementValueData.isforeigncurrency = UtilSql.getValue(result, "isforeigncurrency");
        objectElementValueData.isbankaccount = UtilSql.getValue(result, "isbankaccount");
        objectElementValueData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectElementValueData.postbudget = UtilSql.getValue(result, "postbudget");
        objectElementValueData.poststatistical = UtilSql.getValue(result, "poststatistical");
        objectElementValueData.issummary = UtilSql.getValue(result, "issummary");
        objectElementValueData.validto = UtilSql.getDateValue(result, "validto", "dd-MM-yyyy");
        objectElementValueData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectElementValueData.language = UtilSql.getValue(result, "language");
        objectElementValueData.adUserClient = "";
        objectElementValueData.adOrgClient = "";
        objectElementValueData.createdby = "";
        objectElementValueData.trBgcolor = "";
        objectElementValueData.totalCount = "";
        objectElementValueData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectElementValueData);
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
    ElementValueData objectElementValueData[] = new ElementValueData[vector.size()];
    vector.copyInto(objectElementValueData);
    return(objectElementValueData);
  }

/**
Create a registry
 */
  public static ElementValueData[] set(String cElementId, String description, String postbudget, String createdby, String createdbyr, String datevuseauto, String validto, String elementlevel, String isactive, String poststatistical, String postactual, String isforeigncurrency, String value, String adOrgId, String accounttype, String issummary, String cCurrencyId, String name, String nomanualacct, String isdoccontrolled, String validfrom, String showelement, String postencumbrance, String accountsign, String updatedby, String updatedbyr, String isbankaccount, String adClientId, String cElementvalueId, String showvaluecond)    throws ServletException {
    ElementValueData objectElementValueData[] = new ElementValueData[1];
    objectElementValueData[0] = new ElementValueData();
    objectElementValueData[0].created = "";
    objectElementValueData[0].createdbyr = createdbyr;
    objectElementValueData[0].updated = "";
    objectElementValueData[0].updatedTimeStamp = "";
    objectElementValueData[0].updatedby = updatedby;
    objectElementValueData[0].updatedbyr = updatedbyr;
    objectElementValueData[0].adClientId = adClientId;
    objectElementValueData[0].adClientIdr = "";
    objectElementValueData[0].adOrgId = adOrgId;
    objectElementValueData[0].adOrgIdr = "";
    objectElementValueData[0].showvaluecond = showvaluecond;
    objectElementValueData[0].cElementId = cElementId;
    objectElementValueData[0].cElementIdr = "";
    objectElementValueData[0].elementlevel = elementlevel;
    objectElementValueData[0].value = value;
    objectElementValueData[0].name = name;
    objectElementValueData[0].description = description;
    objectElementValueData[0].isactive = isactive;
    objectElementValueData[0].accounttype = accounttype;
    objectElementValueData[0].accounttyper = "";
    objectElementValueData[0].postactual = postactual;
    objectElementValueData[0].accountsign = accountsign;
    objectElementValueData[0].accountsignr = "";
    objectElementValueData[0].showelement = showelement;
    objectElementValueData[0].isdoccontrolled = isdoccontrolled;
    objectElementValueData[0].datevuseauto = datevuseauto;
    objectElementValueData[0].nomanualacct = nomanualacct;
    objectElementValueData[0].postencumbrance = postencumbrance;
    objectElementValueData[0].cCurrencyId = cCurrencyId;
    objectElementValueData[0].isforeigncurrency = isforeigncurrency;
    objectElementValueData[0].isbankaccount = isbankaccount;
    objectElementValueData[0].cElementvalueId = cElementvalueId;
    objectElementValueData[0].postbudget = postbudget;
    objectElementValueData[0].poststatistical = poststatistical;
    objectElementValueData[0].issummary = issummary;
    objectElementValueData[0].validto = validto;
    objectElementValueData[0].validfrom = validfrom;
    objectElementValueData[0].language = "";
    return objectElementValueData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1132_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef1134_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ElementValue.C_Element_ID AS NAME" +
      "        FROM C_ElementValue" +
      "        WHERE C_ElementValue.C_ElementValue_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Element left join (select C_Element_ID, Name from C_Element) table1 on (C_Element.C_Element_ID = table1.C_Element_ID) WHERE C_Element.C_Element_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Element left join (select C_Element_ID, Name from C_Element) table1 on (C_Element.C_Element_ID = table1.C_Element_ID) WHERE C_Element.C_Element_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);

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
      "        UPDATE C_ElementValue" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , ShowValueCond = (?) , C_Element_ID = (?) , ElementLevel = (?) , Value = (?) , Name = (?) , Description = (?) , IsActive = (?) , AccountType = (?) , PostActual = (?) , AccountSign = (?) , ShowElement = (?) , IsDocControlled = (?) , Datevuseauto = (?) , Nomanualacct = (?) , PostEncumbrance = (?) , C_Currency_ID = (?) , IsForeignCurrency = (?) , IsBankAccount = (?) , C_ElementValue_ID = (?) , PostBudget = (?) , PostStatistical = (?) , IsSummary = (?) , ValidTo = TO_DATE(?) , ValidFrom = TO_DATE(?) , updated = now(), updatedby = ? " +
      "        WHERE C_ElementValue.C_ElementValue_ID = ? " +
      "                 AND C_ElementValue.C_Element_ID = ? " +
      "        AND C_ElementValue.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ElementValue.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showvaluecond);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementlevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountsign);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showelement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdoccontrolled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevuseauto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nomanualacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postencumbrance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isforeigncurrency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbankaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postbudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poststatistical);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
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
      "        INSERT INTO C_ElementValue " +
      "        (AD_Client_ID, AD_Org_ID, ShowValueCond, C_Element_ID, ElementLevel, Value, Name, Description, IsActive, AccountType, PostActual, AccountSign, ShowElement, IsDocControlled, Datevuseauto, Nomanualacct, PostEncumbrance, C_Currency_ID, IsForeignCurrency, IsBankAccount, C_ElementValue_ID, PostBudget, PostStatistical, IsSummary, ValidTo, ValidFrom, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showvaluecond);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementlevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accounttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountsign);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, showelement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdoccontrolled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datevuseauto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nomanualacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postencumbrance);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isforeigncurrency);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbankaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postbudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poststatistical);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cElementId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ElementValue" +
      "        WHERE C_ElementValue.C_ElementValue_ID = ? " +
      "                 AND C_ElementValue.C_Element_ID = ? " +
      "        AND C_ElementValue.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ElementValue.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cElementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ElementValue" +
      "        WHERE C_ElementValue.C_ElementValue_ID = ? " +
      "                 AND C_ElementValue.C_Element_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);

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
      "          FROM C_ElementValue" +
      "         WHERE C_ElementValue.C_ElementValue_ID = ? ";

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
      "          FROM C_ElementValue" +
      "         WHERE C_ElementValue.C_ElementValue_ID = ? ";

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

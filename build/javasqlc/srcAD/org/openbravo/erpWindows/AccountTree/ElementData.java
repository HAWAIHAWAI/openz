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
class ElementData implements FieldProvider {
static Logger log4j = Logger.getLogger(ElementData.class);
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
  public String name;
  public String description;
  public String isactive;
  public String elementtype;
  public String elementtyper;
  public String adTreeId;
  public String adTreeIdr;
  public String cAcctschemaId;
  public String cAcctschemaIdr;
  public String vformat;
  public String cElementId;
  public String add1treeId;
  public String isbalancing;
  public String isnaturalaccount;
  public String add2treeId;
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
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("elementtype"))
      return elementtype;
    else if (fieldName.equalsIgnoreCase("elementtyper"))
      return elementtyper;
    else if (fieldName.equalsIgnoreCase("ad_tree_id") || fieldName.equals("adTreeId"))
      return adTreeId;
    else if (fieldName.equalsIgnoreCase("ad_tree_idr") || fieldName.equals("adTreeIdr"))
      return adTreeIdr;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_idr") || fieldName.equals("cAcctschemaIdr"))
      return cAcctschemaIdr;
    else if (fieldName.equalsIgnoreCase("vformat"))
      return vformat;
    else if (fieldName.equalsIgnoreCase("c_element_id") || fieldName.equals("cElementId"))
      return cElementId;
    else if (fieldName.equalsIgnoreCase("add1tree_id") || fieldName.equals("add1treeId"))
      return add1treeId;
    else if (fieldName.equalsIgnoreCase("isbalancing"))
      return isbalancing;
    else if (fieldName.equalsIgnoreCase("isnaturalaccount"))
      return isnaturalaccount;
    else if (fieldName.equalsIgnoreCase("add2tree_id") || fieldName.equals("add2treeId"))
      return add2treeId;
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
  public static ElementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ElementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Element.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Element.CreatedBy) as CreatedByR, " +
      "        to_char(C_Element.Updated, ?) as updated, " +
      "        to_char(C_Element.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Element.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Element.UpdatedBy) as UpdatedByR," +
      "        C_Element.AD_Client_ID, " +
      "(CASE WHEN C_Element.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_Element.AD_Org_ID, " +
      "(CASE WHEN C_Element.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Element.Name, " +
      "C_Element.Description, " +
      "COALESCE(C_Element.IsActive, 'N') AS IsActive, " +
      "C_Element.ElementType, " +
      "(CASE WHEN C_Element.ElementType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ElementTypeR, " +
      "C_Element.AD_Tree_ID, " +
      "(CASE WHEN C_Element.AD_Tree_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Tree_IDR, " +
      "C_Element.C_Acctschema_ID, " +
      "(CASE WHEN C_Element.C_Acctschema_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Acctschema_IDR, " +
      "C_Element.VFormat, " +
      "C_Element.C_Element_ID, " +
      "C_Element.Add1Tree_ID, " +
      "COALESCE(C_Element.IsBalancing, 'N') AS IsBalancing, " +
      "COALESCE(C_Element.IsNaturalAccount, 'N') AS IsNaturalAccount, " +
      "C_Element.Add2Tree_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Element left join (select AD_Client_ID, Name from AD_Client) table1 on (C_Element.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_Element.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (C_Element.ElementType = list1.value and list1.ad_reference_id = '116' and list1.ad_language = ?)  left join (select AD_Tree_ID, Name from AD_Tree) table3 on (C_Element.AD_Tree_ID = table3.AD_Tree_ID) left join (select C_Acctschema_ID, Name from C_Acctschema) table4 on (C_Element.C_Acctschema_ID = table4.C_Acctschema_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_Element.C_Element_ID = ? " +
      "        AND C_Element.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Element.AD_Org_ID IN (";
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
        ElementData objectElementData = new ElementData();
        objectElementData.created = UtilSql.getValue(result, "created");
        objectElementData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectElementData.updated = UtilSql.getValue(result, "updated");
        objectElementData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectElementData.updatedby = UtilSql.getValue(result, "updatedby");
        objectElementData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectElementData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectElementData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectElementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectElementData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectElementData.name = UtilSql.getValue(result, "name");
        objectElementData.description = UtilSql.getValue(result, "description");
        objectElementData.isactive = UtilSql.getValue(result, "isactive");
        objectElementData.elementtype = UtilSql.getValue(result, "elementtype");
        objectElementData.elementtyper = UtilSql.getValue(result, "elementtyper");
        objectElementData.adTreeId = UtilSql.getValue(result, "ad_tree_id");
        objectElementData.adTreeIdr = UtilSql.getValue(result, "ad_tree_idr");
        objectElementData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectElementData.cAcctschemaIdr = UtilSql.getValue(result, "c_acctschema_idr");
        objectElementData.vformat = UtilSql.getValue(result, "vformat");
        objectElementData.cElementId = UtilSql.getValue(result, "c_element_id");
        objectElementData.add1treeId = UtilSql.getValue(result, "add1tree_id");
        objectElementData.isbalancing = UtilSql.getValue(result, "isbalancing");
        objectElementData.isnaturalaccount = UtilSql.getValue(result, "isnaturalaccount");
        objectElementData.add2treeId = UtilSql.getValue(result, "add2tree_id");
        objectElementData.language = UtilSql.getValue(result, "language");
        objectElementData.adUserClient = "";
        objectElementData.adOrgClient = "";
        objectElementData.createdby = "";
        objectElementData.trBgcolor = "";
        objectElementData.totalCount = "";
        objectElementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectElementData);
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
    ElementData objectElementData[] = new ElementData[vector.size()];
    vector.copyInto(objectElementData);
    return(objectElementData);
  }

/**
Create a registry
 */
  public static ElementData[] set(String adOrgId, String isnaturalaccount, String isbalancing, String add2treeId, String vformat, String cAcctschemaId, String cElementId, String name, String adTreeId, String description, String isactive, String updatedby, String updatedbyr, String add1treeId, String elementtype, String adClientId, String createdby, String createdbyr)    throws ServletException {
    ElementData objectElementData[] = new ElementData[1];
    objectElementData[0] = new ElementData();
    objectElementData[0].created = "";
    objectElementData[0].createdbyr = createdbyr;
    objectElementData[0].updated = "";
    objectElementData[0].updatedTimeStamp = "";
    objectElementData[0].updatedby = updatedby;
    objectElementData[0].updatedbyr = updatedbyr;
    objectElementData[0].adClientId = adClientId;
    objectElementData[0].adClientIdr = "";
    objectElementData[0].adOrgId = adOrgId;
    objectElementData[0].adOrgIdr = "";
    objectElementData[0].name = name;
    objectElementData[0].description = description;
    objectElementData[0].isactive = isactive;
    objectElementData[0].elementtype = elementtype;
    objectElementData[0].elementtyper = "";
    objectElementData[0].adTreeId = adTreeId;
    objectElementData[0].adTreeIdr = "";
    objectElementData[0].cAcctschemaId = cAcctschemaId;
    objectElementData[0].cAcctschemaIdr = "";
    objectElementData[0].vformat = vformat;
    objectElementData[0].cElementId = cElementId;
    objectElementData[0].add1treeId = add1treeId;
    objectElementData[0].isbalancing = isbalancing;
    objectElementData[0].isnaturalaccount = isnaturalaccount;
    objectElementData[0].add2treeId = add2treeId;
    objectElementData[0].language = "";
    return objectElementData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef805_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef803_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
      "        UPDATE C_Element" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , ElementType = (?) , AD_Tree_ID = (?) , C_Acctschema_ID = (?) , VFormat = (?) , C_Element_ID = (?) , Add1Tree_ID = (?) , IsBalancing = (?) , IsNaturalAccount = (?) , Add2Tree_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Element.C_Element_ID = ? " +
      "        AND C_Element.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Element.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, add1treeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbalancing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnaturalaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, add2treeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO C_Element " +
      "        (AD_Client_ID, AD_Org_ID, Name, Description, IsActive, ElementType, AD_Tree_ID, C_Acctschema_ID, VFormat, C_Element_ID, Add1Tree_ID, IsBalancing, IsNaturalAccount, Add2Tree_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, elementtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vformat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, add1treeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbalancing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnaturalaccount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, add2treeId);
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
      "        DELETE FROM C_Element" +
      "        WHERE C_Element.C_Element_ID = ? " +
      "        AND C_Element.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Element.AD_Org_ID IN (";
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
      "        DELETE FROM C_Element" +
      "        WHERE C_Element.C_Element_ID = ? ";

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
      "          FROM C_Element" +
      "         WHERE C_Element.C_Element_ID = ? ";

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
      "          FROM C_Element" +
      "         WHERE C_Element.C_Element_ID = ? ";

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

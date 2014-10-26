//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.TablesandColumns;

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
class LabelLinkDispatcherData implements FieldProvider {
static Logger log4j = Logger.getLogger(LabelLinkDispatcherData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adColumnVId;
  public String adColumnVIdr;
  public String adLabellinkdispatcherId;
  public String linkcondition;
  public String adTabId;
  public String adTabIdr;
  public String adClientId;
  public String isdefault;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("ad_column_v_id") || fieldName.equals("adColumnVId"))
      return adColumnVId;
    else if (fieldName.equalsIgnoreCase("ad_column_v_idr") || fieldName.equals("adColumnVIdr"))
      return adColumnVIdr;
    else if (fieldName.equalsIgnoreCase("ad_labellinkdispatcher_id") || fieldName.equals("adLabellinkdispatcherId"))
      return adLabellinkdispatcherId;
    else if (fieldName.equalsIgnoreCase("linkcondition"))
      return linkcondition;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("ad_tab_idr") || fieldName.equals("adTabIdr"))
      return adTabIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static LabelLinkDispatcherData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adColumnVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adColumnVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LabelLinkDispatcherData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adColumnVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_labellinkdispatcher.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_labellinkdispatcher.CreatedBy) as CreatedByR, " +
      "        to_char(ad_labellinkdispatcher.Updated, ?) as updated, " +
      "        to_char(ad_labellinkdispatcher.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_labellinkdispatcher.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_labellinkdispatcher.UpdatedBy) as UpdatedByR," +
      "        ad_labellinkdispatcher.AD_Column_V_ID, " +
      "(CASE WHEN ad_labellinkdispatcher.AD_Column_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Columnname), ''))),'') ) END) AS AD_Column_V_IDR, " +
      "ad_labellinkdispatcher.AD_Labellinkdispatcher_ID, " +
      "ad_labellinkdispatcher.Linkcondition, " +
      "ad_labellinkdispatcher.AD_Tab_ID, " +
      "(CASE WHEN ad_labellinkdispatcher.AD_Tab_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Tab_IDR, " +
      "ad_labellinkdispatcher.AD_Client_ID, " +
      "COALESCE(ad_labellinkdispatcher.Isdefault, 'N') AS Isdefault, " +
      "ad_labellinkdispatcher.AD_Org_ID, " +
      "COALESCE(ad_labellinkdispatcher.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_labellinkdispatcher left join (select AD_Column_V_ID, Columnname from AD_Column_V) table1 on (ad_labellinkdispatcher.AD_Column_V_ID = table1.AD_Column_V_ID) left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table2 on (ad_labellinkdispatcher.AD_Tab_ID = table2.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL2 on (table2.AD_Tab_ID = tableTRL2.AD_Tab_ID and tableTRL2.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table3 on (table2.AD_Window_ID = table3.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL3 on (table3.AD_Window_ID = tableTRL3.AD_Window_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adColumnVId==null || adColumnVId.equals(""))?"":"  AND ad_labellinkdispatcher.AD_Column_V_ID = ?  ");
    strSql = strSql + 
      "        AND ad_labellinkdispatcher.AD_Labellinkdispatcher_ID = ? " +
      "        AND ad_labellinkdispatcher.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_labellinkdispatcher.AD_Org_ID IN (";
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
      if (adColumnVId != null && !(adColumnVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
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
        LabelLinkDispatcherData objectLabelLinkDispatcherData = new LabelLinkDispatcherData();
        objectLabelLinkDispatcherData.created = UtilSql.getValue(result, "created");
        objectLabelLinkDispatcherData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLabelLinkDispatcherData.updated = UtilSql.getValue(result, "updated");
        objectLabelLinkDispatcherData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLabelLinkDispatcherData.updatedby = UtilSql.getValue(result, "updatedby");
        objectLabelLinkDispatcherData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLabelLinkDispatcherData.adColumnVId = UtilSql.getValue(result, "ad_column_v_id");
        objectLabelLinkDispatcherData.adColumnVIdr = UtilSql.getValue(result, "ad_column_v_idr");
        objectLabelLinkDispatcherData.adLabellinkdispatcherId = UtilSql.getValue(result, "ad_labellinkdispatcher_id");
        objectLabelLinkDispatcherData.linkcondition = UtilSql.getValue(result, "linkcondition");
        objectLabelLinkDispatcherData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectLabelLinkDispatcherData.adTabIdr = UtilSql.getValue(result, "ad_tab_idr");
        objectLabelLinkDispatcherData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLabelLinkDispatcherData.isdefault = UtilSql.getValue(result, "isdefault");
        objectLabelLinkDispatcherData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLabelLinkDispatcherData.isactive = UtilSql.getValue(result, "isactive");
        objectLabelLinkDispatcherData.language = UtilSql.getValue(result, "language");
        objectLabelLinkDispatcherData.adUserClient = "";
        objectLabelLinkDispatcherData.adOrgClient = "";
        objectLabelLinkDispatcherData.createdby = "";
        objectLabelLinkDispatcherData.trBgcolor = "";
        objectLabelLinkDispatcherData.totalCount = "";
        objectLabelLinkDispatcherData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLabelLinkDispatcherData);
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
    LabelLinkDispatcherData objectLabelLinkDispatcherData[] = new LabelLinkDispatcherData[vector.size()];
    vector.copyInto(objectLabelLinkDispatcherData);
    return(objectLabelLinkDispatcherData);
  }

/**
Create a registry
 */
  public static LabelLinkDispatcherData[] set(String adColumnVId, String adTabId, String adLabellinkdispatcherId, String createdby, String createdbyr, String adClientId, String updatedby, String updatedbyr, String isdefault, String isactive, String linkcondition, String adOrgId)    throws ServletException {
    LabelLinkDispatcherData objectLabelLinkDispatcherData[] = new LabelLinkDispatcherData[1];
    objectLabelLinkDispatcherData[0] = new LabelLinkDispatcherData();
    objectLabelLinkDispatcherData[0].created = "";
    objectLabelLinkDispatcherData[0].createdbyr = createdbyr;
    objectLabelLinkDispatcherData[0].updated = "";
    objectLabelLinkDispatcherData[0].updatedTimeStamp = "";
    objectLabelLinkDispatcherData[0].updatedby = updatedby;
    objectLabelLinkDispatcherData[0].updatedbyr = updatedbyr;
    objectLabelLinkDispatcherData[0].adColumnVId = adColumnVId;
    objectLabelLinkDispatcherData[0].adColumnVIdr = "";
    objectLabelLinkDispatcherData[0].adLabellinkdispatcherId = adLabellinkdispatcherId;
    objectLabelLinkDispatcherData[0].linkcondition = linkcondition;
    objectLabelLinkDispatcherData[0].adTabId = adTabId;
    objectLabelLinkDispatcherData[0].adTabIdr = "";
    objectLabelLinkDispatcherData[0].adClientId = adClientId;
    objectLabelLinkDispatcherData[0].isdefault = isdefault;
    objectLabelLinkDispatcherData[0].adOrgId = adOrgId;
    objectLabelLinkDispatcherData[0].isactive = isactive;
    objectLabelLinkDispatcherData[0].language = "";
    return objectLabelLinkDispatcherData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef9C85A235C6034DE8A538F79E11A7B60F_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef495DD18861AB4DB8ACD020417EA9D9EB_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT ad_labellinkdispatcher.AD_Column_V_ID AS NAME" +
      "        FROM ad_labellinkdispatcher" +
      "        WHERE ad_labellinkdispatcher.AD_Labellinkdispatcher_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adColumnVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Columnname), ''))) AS NAME FROM ad_column_v left join (select AD_Column_V_ID, Columnname from AD_Column_V) table1 on (ad_column_v.AD_Column_V_ID = table1.AD_Column_V_ID) WHERE ad_column_v.AD_Column_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adColumnVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Columnname), ''))) AS NAME FROM ad_column_v left join (select AD_Column_V_ID, Columnname from AD_Column_V) table1 on (ad_column_v.AD_Column_V_ID = table1.AD_Column_V_ID) WHERE ad_column_v.AD_Column_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);

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
      "        UPDATE ad_labellinkdispatcher" +
      "        SET AD_Column_V_ID = (?) , AD_Labellinkdispatcher_ID = (?) , Linkcondition = (?) , AD_Tab_ID = (?) , AD_Client_ID = (?) , Isdefault = (?) , AD_Org_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_labellinkdispatcher.AD_Labellinkdispatcher_ID = ? " +
      "                 AND ad_labellinkdispatcher.AD_Column_V_ID = ? " +
      "        AND ad_labellinkdispatcher.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_labellinkdispatcher.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLabellinkdispatcherId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linkcondition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLabellinkdispatcherId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
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
      "        INSERT INTO ad_labellinkdispatcher " +
      "        (AD_Column_V_ID, AD_Labellinkdispatcher_ID, Linkcondition, AD_Tab_ID, AD_Client_ID, Isdefault, AD_Org_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLabellinkdispatcherId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linkcondition);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adColumnVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_labellinkdispatcher" +
      "        WHERE ad_labellinkdispatcher.AD_Labellinkdispatcher_ID = ? " +
      "                 AND ad_labellinkdispatcher.AD_Column_V_ID = ? " +
      "        AND ad_labellinkdispatcher.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_labellinkdispatcher.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adColumnVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_labellinkdispatcher" +
      "        WHERE ad_labellinkdispatcher.AD_Labellinkdispatcher_ID = ? " +
      "                 AND ad_labellinkdispatcher.AD_Column_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnVId);

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
      "          FROM ad_labellinkdispatcher" +
      "         WHERE ad_labellinkdispatcher.AD_Labellinkdispatcher_ID = ? ";

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
      "          FROM ad_labellinkdispatcher" +
      "         WHERE ad_labellinkdispatcher.AD_Labellinkdispatcher_ID = ? ";

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

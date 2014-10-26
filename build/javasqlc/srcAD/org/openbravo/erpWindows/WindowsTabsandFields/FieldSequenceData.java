//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.WindowsTabsandFields;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
Clase AlmacenData
 */
class FieldSequenceData implements FieldProvider {
static Logger log4j = Logger.getLogger(FieldSequenceData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String adFieldVId;
  public String shown;
  public String seqnoParam;
  public String total;
  public String isindevelopment;
  public String adTabId;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String language;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_field_v_id") || fieldName.equals("adFieldVId"))
      return adFieldVId;
    else if (fieldName.equalsIgnoreCase("shown"))
      return shown;
    else if (fieldName.equalsIgnoreCase("seqno_param") || fieldName.equals("seqnoParam"))
      return seqnoParam;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("isindevelopment"))
      return isindevelopment;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for relation
 */
  public static FieldSequenceData[] select(ConnectionProvider connectionProvider, String paramLanguage, String adUserClient, String adOrgClient, String param1)    throws ServletException {
    return select(connectionProvider, paramLanguage, adUserClient, adOrgClient, param1, 0, 0);
  }

/**
Select for relation
 */
  public static FieldSequenceData[] select(ConnectionProvider connectionProvider, String paramLanguage, String adUserClient, String adOrgClient, String param1, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_field_v.AD_Field_V_ID AS ID, " +
      "        TO_CHAR(COALESCE(TO_CHAR(ad_field_v.Name), '')) AS NAME, ad_field_v.AD_Field_V_ID, '' AS SHOWN, " +
      "        '' AS seqno_Param, '' AS TOTAL, '' AS ISINDEVELOPMENT," +
      "                ad_field_v.AD_Tab_ID, " +
      "        ad_field_v.Created, " +
      "        ad_field_v.CreatedBy, " +
      "        ad_field_v.Updated, " +
      "        ad_field_v.UpdatedBy, ? AS LANGUAGE " +
      "        FROM ad_field_v" +
      "        WHERE 2=2 " +
      "        AND ad_field_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_field_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND ad_field_v.AD_Tab_ID = ?" +
      "        AND ad_field_v.Isdisplayed = 'Y' " +
      "         ORDER BY ad_field_v.Seqno";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
        FieldSequenceData objectFieldSequenceData = new FieldSequenceData();
        objectFieldSequenceData.id = UtilSql.getValue(result, "id");
        objectFieldSequenceData.name = UtilSql.getValue(result, "name");
        objectFieldSequenceData.adFieldVId = UtilSql.getValue(result, "ad_field_v_id");
        objectFieldSequenceData.shown = UtilSql.getValue(result, "shown");
        objectFieldSequenceData.seqnoParam = UtilSql.getValue(result, "seqno_param");
        objectFieldSequenceData.total = UtilSql.getValue(result, "total");
        objectFieldSequenceData.isindevelopment = UtilSql.getValue(result, "isindevelopment");
        objectFieldSequenceData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectFieldSequenceData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectFieldSequenceData.createdby = UtilSql.getValue(result, "createdby");
        objectFieldSequenceData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectFieldSequenceData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFieldSequenceData.language = UtilSql.getValue(result, "language");
        objectFieldSequenceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldSequenceData);
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
    FieldSequenceData objectFieldSequenceData[] = new FieldSequenceData[vector.size()];
    vector.copyInto(objectFieldSequenceData);
    return(objectFieldSequenceData);
  }

/**
Select for relation
 */
  public static FieldSequenceData[] selectNotShown(ConnectionProvider connectionProvider, String paramLanguage, String adUserClient, String adOrgClient, String param1)    throws ServletException {
    return selectNotShown(connectionProvider, paramLanguage, adUserClient, adOrgClient, param1, 0, 0);
  }

/**
Select for relation
 */
  public static FieldSequenceData[] selectNotShown(ConnectionProvider connectionProvider, String paramLanguage, String adUserClient, String adOrgClient, String param1, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_field_v.AD_Field_V_ID AS ID, " +
      "        TO_CHAR(COALESCE(TO_CHAR(ad_field_v.Name), '')) AS NAME, " +
      "        ad_field_v.Created, " +
      "        ad_field_v.CreatedBy, " +
      "        ad_field_v.Updated, " +
      "        ad_field_v.UpdatedBy, ? AS LANGUAGE " +
      "        FROM ad_field_v" +
      "        WHERE 2=2 " +
      "        AND ad_field_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_field_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND ad_field_v.AD_Tab_ID = ?" +
      "        AND ad_field_v.Isdisplayed = 'N' " +
      "         ORDER BY ad_field_v.Seqno";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
        FieldSequenceData objectFieldSequenceData = new FieldSequenceData();
        objectFieldSequenceData.id = UtilSql.getValue(result, "id");
        objectFieldSequenceData.name = UtilSql.getValue(result, "name");
        objectFieldSequenceData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectFieldSequenceData.createdby = UtilSql.getValue(result, "createdby");
        objectFieldSequenceData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectFieldSequenceData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFieldSequenceData.language = UtilSql.getValue(result, "language");
        objectFieldSequenceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldSequenceData);
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
    FieldSequenceData objectFieldSequenceData[] = new FieldSequenceData[vector.size()];
    vector.copyInto(objectFieldSequenceData);
    return(objectFieldSequenceData);
  }

/**
Select for relation
 */
  public static String selectInDevelopmentModule(ConnectionProvider connectionProvider, String adFieldVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT 'Y' as ISINDEVELOPMENT " +
      "        FROM ad_field_v" +
      "        WHERE  ad_field_v.isactive in ('N','Y') " +
      "         AND ad_field_v.AD_Field_V_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "isindevelopment");
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
Select for relation
 */
  public static String selectSeqNo(ConnectionProvider connectionProvider, String adFieldVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Seqno" +
      "        FROM ad_field_v" +
      "        WHERE ad_field_v.AD_Field_V_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "seqno");
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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM AD_Tab left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table1 on (AD_Tab.AD_Tab_ID = table1.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL1 on (table1.AD_Tab_ID = tableTRL1.AD_Tab_ID and tableTRL1.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table2 on (table1.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  WHERE AD_Tab.AD_Tab_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))) AS NAME FROM AD_Tab left join (select AD_Tab_ID, Name, AD_Window_ID from AD_Tab) table1 on (AD_Tab.AD_Tab_ID = table1.AD_Tab_ID) left join (select AD_Tab_ID,AD_Language, Name from AD_Tab_TRL) tableTRL1 on (table1.AD_Tab_ID = tableTRL1.AD_Tab_ID and tableTRL1.AD_Language = ?)  left join (select AD_Window_ID, Name from AD_Window) table2 on (table1.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  WHERE AD_Tab.AD_Tab_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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

  public int updateY(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ad_field_v" +
      "        SET Isdisplayed='Y', Seqno = TO_NUMBER(?), updated = now(), updatedby = ? " +
      "        WHERE ad_field_v.AD_Field_V_ID = ? " +
      "                 AND ad_field_v.AD_Tab_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqnoParam);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFieldVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

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

  public int updateN(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ad_field_v" +
      "        SET Isdisplayed='N', Seqno = NULL, " +
      "        updated = now(), updatedby = ?" +
      "        WHERE 1=1 ";
    strSql = strSql + ((shown==null || shown.equals(""))?"":"  AND ad_field_v.AD_Field_V_ID NOT IN " + shown);
    strSql = strSql + 
      "         AND ad_field_v.AD_Tab_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      if (shown != null && !(shown.equals(""))) {
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

  public static boolean isTemplateInDev(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(*)" +
      "          FROM AD_MODULE" +
      "         WHERE TYPE='T'" +
      "           AND ISINDEVELOPMENT='Y'";

    ResultSet result;
    boolean boolReturn = false;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        boolReturn = !UtilSql.getValue(result, "count").equals("0");
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
    return(boolReturn);
  }
}

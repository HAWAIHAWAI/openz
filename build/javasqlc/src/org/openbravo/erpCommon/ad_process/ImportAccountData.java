//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class ImportAccountData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportAccountData.class);
  private String InitRecordNumber="0";
  public String iElementvalueId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String updated;
  public String updatedby;
  public String cElementvalueId;
  public String description;
  public String defaultAccount;
  public String isfullyqualified;
  public String cAcctschemaId;
  public String mProductId;
  public String cBpartnerId;
  public String message;
  public String parentelementvalueId;
  public String adTreeId;
  public String info;
  public String alias;
  public String combination;
  public String tablename;
  public String columnname;
  public String accountId;
  public String adOrgtrxId;
  public String cValidcombinationId;
  public String created;
  public String createdby;
  public String cLocfromId;
  public String cLoctoId;
  public String cSalesregionId;
  public String cProjectId;
  public String cCampaignId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String operands;
  public String value;
  public String seqno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("i_elementvalue_id") || fieldName.equals("iElementvalueId"))
      return iElementvalueId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("default_account") || fieldName.equals("defaultAccount"))
      return defaultAccount;
    else if (fieldName.equalsIgnoreCase("isfullyqualified"))
      return isfullyqualified;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("message"))
      return message;
    else if (fieldName.equalsIgnoreCase("parentelementvalue_id") || fieldName.equals("parentelementvalueId"))
      return parentelementvalueId;
    else if (fieldName.equalsIgnoreCase("ad_tree_id") || fieldName.equals("adTreeId"))
      return adTreeId;
    else if (fieldName.equalsIgnoreCase("info"))
      return info;
    else if (fieldName.equalsIgnoreCase("alias"))
      return alias;
    else if (fieldName.equalsIgnoreCase("combination"))
      return combination;
    else if (fieldName.equalsIgnoreCase("tablename"))
      return tablename;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("c_validcombination_id") || fieldName.equals("cValidcombinationId"))
      return cValidcombinationId;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("c_locfrom_id") || fieldName.equals("cLocfromId"))
      return cLocfromId;
    else if (fieldName.equalsIgnoreCase("c_locto_id") || fieldName.equals("cLoctoId"))
      return cLoctoId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("operands"))
      return operands;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ImportAccountData[] select(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    return select(connectionProvider, adClientId, 0, 0);
  }

  public static ImportAccountData[] select(ConnectionProvider connectionProvider, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT I_ElementValue_ID, AD_Client_ID, AD_Org_ID, IsActive, Updated, UpdatedBy, C_ElementValue_ID," +
      "			Description, Default_Account, '' as IsFullyQualified, '' as C_AcctSchema_ID, '' as M_Product_ID, '' as C_BPartner_ID," +
      "			'' as message, ParentElementValue_ID, '' as AD_Tree_ID, '' as Info, '' as Alias, '' as Combination," +
      "			'' as TableName, '' as ColumnName, '' as Account_ID, '' as AD_OrgTrx_ID, '' as C_ValidCombination_ID," +
      "			'' as Created, '' as CreatedBy, '' as C_LocFrom_ID, '' as C_LocTo_ID, '' as C_SalesRegion_ID, '' as C_Project_ID," +
      "			'' as C_Campaign_ID, '' as C_Activity_ID, '' as User1_ID, '' as User2_ID, '' as operands, '' as value, '' as SeqNo" +
      "      FROM I_ElementValue WHERE I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        ImportAccountData objectImportAccountData = new ImportAccountData();
        objectImportAccountData.iElementvalueId = UtilSql.getValue(result, "i_elementvalue_id");
        objectImportAccountData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportAccountData.isactive = UtilSql.getValue(result, "isactive");
        objectImportAccountData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectImportAccountData.updatedby = UtilSql.getValue(result, "updatedby");
        objectImportAccountData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectImportAccountData.description = UtilSql.getValue(result, "description");
        objectImportAccountData.defaultAccount = UtilSql.getValue(result, "default_account");
        objectImportAccountData.isfullyqualified = UtilSql.getValue(result, "isfullyqualified");
        objectImportAccountData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectImportAccountData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectImportAccountData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportAccountData.message = UtilSql.getValue(result, "message");
        objectImportAccountData.parentelementvalueId = UtilSql.getValue(result, "parentelementvalue_id");
        objectImportAccountData.adTreeId = UtilSql.getValue(result, "ad_tree_id");
        objectImportAccountData.info = UtilSql.getValue(result, "info");
        objectImportAccountData.alias = UtilSql.getValue(result, "alias");
        objectImportAccountData.combination = UtilSql.getValue(result, "combination");
        objectImportAccountData.tablename = UtilSql.getValue(result, "tablename");
        objectImportAccountData.columnname = UtilSql.getValue(result, "columnname");
        objectImportAccountData.accountId = UtilSql.getValue(result, "account_id");
        objectImportAccountData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectImportAccountData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectImportAccountData.created = UtilSql.getValue(result, "created");
        objectImportAccountData.createdby = UtilSql.getValue(result, "createdby");
        objectImportAccountData.cLocfromId = UtilSql.getValue(result, "c_locfrom_id");
        objectImportAccountData.cLoctoId = UtilSql.getValue(result, "c_locto_id");
        objectImportAccountData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectImportAccountData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectImportAccountData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectImportAccountData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectImportAccountData.user1Id = UtilSql.getValue(result, "user1_id");
        objectImportAccountData.user2Id = UtilSql.getValue(result, "user2_id");
        objectImportAccountData.operands = UtilSql.getValue(result, "operands");
        objectImportAccountData.value = UtilSql.getValue(result, "value");
        objectImportAccountData.seqno = UtilSql.getValue(result, "seqno");
        objectImportAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportAccountData);
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
    ImportAccountData objectImportAccountData[] = new ImportAccountData[vector.size()];
    vector.copyInto(objectImportAccountData);
    return(objectImportAccountData);
  }

  public static int deleteOld(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM I_ElementValue WHERE I_IsImported='Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateRecords(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET AD_Client_ID = COALESCE (AD_Client_ID, ?)," +
      "          AD_Org_ID = COALESCE (AD_Org_ID, '0')," +
      "          IsActive = COALESCE (IsActive, 'Y')," +
      "          Created = COALESCE (Created, now())," +
      "          CreatedBy = COALESCE (CreatedBy, '0')," +
      "          Updated = COALESCE (Updated, now())," +
      "          UpdatedBy = COALESCE (UpdatedBy, '0')," +
      "          I_ErrorMsg = NULL," +
      "          I_IsImported = 'N'" +
      "        WHERE I_IsImported<>'Y'" +
      "        OR I_IsImported IS NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateElement(Connection conn, ConnectionProvider connectionProvider, String cElementId, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET ElementName = (" +
      "          SELECT Name" +
      "          FROM C_Element" +
      "          WHERE C_Element_ID = ?" +
      "        )" +
      "        WHERE ElementName IS NULL" +
      "        AND C_Element_ID IS NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateIdByName(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET C_Element_ID = (" +
      "          SELECT C_Element_ID FROM C_Element e" +
      "          WHERE I_ElementValue.ElementName=e.Name" +
      "          AND I_ElementValue.AD_Client_ID=e.AD_Client_ID" +
      "        )" +
      "        WHERE C_Element_ID IS NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateElementError(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_IsImported='E', I_ErrorMsg='ERR=Invalid Element, '" +
      "        WHERE C_Element_ID IS NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateColumn(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET AD_Column_ID = (" +
      "          SELECT AD_Column_ID" +
      "          FROM AD_Column c" +
      "          WHERE UPPER(I_ElementValue.Default_Account)=UPPER(c.ColumnName)" +
      "          AND c.AD_Table_ID IN ('315','266')" +
      "          AND AD_Reference_value_ID='25'" +
      "        )" +
      "        WHERE Default_Account IS NOT NULL" +
      "        AND AD_Column_ID IS NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateColumnError(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Column, '" +
      "        WHERE AD_Column_ID IS NULL" +
      "        AND Default_Account IS NOT NULL" +
      "        AND UPPER(Default_Account)<>'DEFAULT_ACCT'" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateYColumns(Connection conn, ConnectionProvider connectionProvider, String column, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET ";
    strSql = strSql + ((column==null || column.equals(""))?"":column);
    strSql = strSql + 
      "='Y'" +
      "        WHERE ";
    strSql = strSql + ((column==null || column.equals(""))?"":column);
    strSql = strSql + 
      " IS NULL" +
      "        OR ";
    strSql = strSql + ((column==null || column.equals(""))?"":column);
    strSql = strSql + 
      " NOT IN ('Y','N')" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (column != null && !(column.equals(""))) {
        }
      if (column != null && !(column.equals(""))) {
        }
      if (column != null && !(column.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateSummary(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET IsSummary='N'" +
      "        WHERE IsSummary IS NULL" +
      "        OR IsSummary NOT IN ('Y','N')" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateDocControlled(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET IsDocControlled =" +
      "        CASE" +
      "          WHEN AD_Column_ID IS NOT NULL THEN 'Y'" +
      "          ELSE 'N' END" +
      "        WHERE IsDocControlled IS NULL" +
      "        OR IsDocControlled NOT IN ('Y','N')" +
      "        AND I_IsImported='N'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateAccountType(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET AccountType = substr(coalesce(AccountType,'E'),1,1)" +
      "        WHERE I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateAccountTypeError(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid AccountType, '" +
      "        WHERE substr(AccountType,1,1) NOT IN ('A','E','L','M','O','R')" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateAccountSign(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET AccountSign = substr(coalesce(AccountSign,'N'),1,1)" +
      "        WHERE I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateAccountSignError(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid AccountSign, '" +
      "        WHERE substr(AccountSign,1,1) NOT IN ('N','C','D')" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateElementValue(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET C_ElementValue_ID = (" +
      "          SELECT C_ElementValue_ID" +
      "          FROM C_ElementValue ev" +
      "          INNER JOIN C_Element e ON (ev.C_Element_ID=e.C_Element_ID)" +
      "          WHERE I_ElementValue.C_Element_ID=e.C_Element_ID" +
      "          AND I_ElementValue.AD_Client_ID=e.AD_Client_ID" +
      "          AND I_ElementValue.Value=ev.Value" +
      "        )" +
      "        WHERE C_ElementValue_ID IS NULL" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int updateCElementValueID(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET C_ElementValue_ID = (" +
      "          SELECT C_ElementValue_ID" +
      "          FROM C_ElementValue ev" +
      "          INNER JOIN C_Element e ON (ev.C_Element_ID=e.C_Element_ID)" +
      "          WHERE I_ElementValue.C_Element_ID=e.C_Element_ID" +
      "          AND I_ElementValue.AD_Client_ID=e.AD_Client_ID" +
      "          AND I_ElementValue.Value=ev.Value" +
      "        )" +
      "        WHERE C_ElementValue_ID IS NULL" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static ImportAccountData disableTriggers(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        ALTER TABLE C_ValidCombination DISABLE ALL TRIGGERS";

    ImportAccountData objectImportAccountData = new ImportAccountData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    try {
      st = connectionProvider.getCallableStatement(conn, strSql);

      st.execute();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectImportAccountData);
  }

  public static ImportAccountData enableTriggers(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        ALTER TABLE C_ValidCombination ENABLE ALL TRIGGERS";

    ImportAccountData objectImportAccountData = new ImportAccountData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    try {
      st = connectionProvider.getCallableStatement(conn, strSql);

      st.execute();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectImportAccountData);
  }

  public static ImportAccountData[] selectRecords(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    return selectRecords(connectionProvider, adClientId, 0, 0);
  }

  public static ImportAccountData[] selectRecords(ConnectionProvider connectionProvider, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT I_ElementValue_ID, C_ElementValue_ID, value, default_account" +
      "        FROM I_ElementValue" +
      "        WHERE I_IsImported='N'" +
      "        AND AD_Client_ID=?" +
      "        ORDER BY I_ElementValue_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        ImportAccountData objectImportAccountData = new ImportAccountData();
        objectImportAccountData.iElementvalueId = UtilSql.getValue(result, "i_elementvalue_id");
        objectImportAccountData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectImportAccountData.value = UtilSql.getValue(result, "value");
        objectImportAccountData.defaultAccount = UtilSql.getValue(result, "default_account");
        objectImportAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportAccountData);
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
    ImportAccountData objectImportAccountData[] = new ImportAccountData[vector.size()];
    vector.copyInto(objectImportAccountData);
    return(objectImportAccountData);
  }

  public static String selectOperands(Connection conn, ConnectionProvider connectionProvider, String iElementValueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT operands" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementValueId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "operands");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String selectAccount(Connection conn, ConnectionProvider connectionProvider, String value, String client, String element)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_elementvalue_id" +
      "        FROM c_ElementValue" +
      "        WHERE value = ?" +
      "        and ad_client_id = ?" +
      "        AND C_ELEMENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_elementvalue_id");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String selectDefaultsRecord(Connection conn, ConnectionProvider connectionProvider, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(1) AS COUNT" +
      "        FROM c_acctschema_default" +
      "        WHERE c_acctschema_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String selectGLRecord(Connection conn, ConnectionProvider connectionProvider, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(1) AS COUNT" +
      "        FROM c_acctschema_gl" +
      "        WHERE c_acctschema_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static int insertElementValue(Connection conn, ConnectionProvider connectionProvider, String cElementvalueId, String iElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ElementValue (C_ElementValue_ID,C_Element_ID," +
      "          AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy," +
      "          Value,Name,Description, AccountType,AccountSign,IsDocControlled," +
      "          IsSummary,PostActual,PostBudget,PostEncumbrance,PostStatistical, elementlevel)" +
      "        SELECT ?,C_Element_ID," +
      "          AD_Client_ID,AD_Org_ID,'Y',now(),CreatedBy,now(),UpdatedBy," +
      "          Value,Name,Description, AccountType,AccountSign,IsDocControlled," +
      "          IsSummary,PostActual,PostBudget,PostEncumbrance,PostStatistical, coalesce(elementlevel,'S')" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);

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

  public static int insertGLRecord(Connection conn, ConnectionProvider connectionProvider, String cAcctschemaId, String client, String org, String user, String SUSPENSEBALANCING_ACCT, String SUSPENSEERROR_ACCT, String CURRENCYBALANCING_ACCT, String RETAINEDEARNING_ACCT, String INCOMESUMMARY_ACCT, String INTERCOMPANYDUETO_ACCT, String INTERCOMPANYDUEFROM_ACCT, String PPVOFFSET_ACCT, String CFS_ORDER_ACCT)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ACCTSCHEMA_GL (C_ACCTSCHEMA_ID, C_ACCTSCHEMA_GL_ID, AD_CLIENT_ID, AD_ORG_ID,ISACTIVE, CREATED, CREATEDBY," +
      "           UPDATED, UPDATEDBY, USESUSPENSEBALANCING, SUSPENSEBALANCING_ACCT, USESUSPENSEERROR, SUSPENSEERROR_ACCT," +
      "           USECURRENCYBALANCING, CURRENCYBALANCING_ACCT, RETAINEDEARNING_ACCT,INCOMESUMMARY_ACCT, INTERCOMPANYDUETO_ACCT," +
      "           INTERCOMPANYDUEFROM_ACCT,PPVOFFSET_ACCT, CFS_ORDER_ACCT)" +
      "        VALUES (?, GET_UUID(), ?, ?, 'Y', now(), ?," +
      "            now(), ?, 'N', ?, 'N', ?," +
      "            'N', ?, ?, ?, ?," +
      "            ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SUSPENSEBALANCING_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SUSPENSEERROR_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CURRENCYBALANCING_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, RETAINEDEARNING_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, INCOMESUMMARY_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, INTERCOMPANYDUETO_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, INTERCOMPANYDUEFROM_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PPVOFFSET_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CFS_ORDER_ACCT);

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

  public static int insertDefaultsRecord(Connection conn, ConnectionProvider connectionProvider, String cAcctschemaId, String client, String org, String user, String W_INVENTORY_ACCT, String W_INVACTUALADJUST_ACCT, String W_DIFFERENCES_ACCT, String W_REVALUATION_ACCT, String P_REVENUE_ACCT, String P_EXPENSE_ACCT, String P_ASSET_ACCT, String P_PURCHASEPRICEVARIANCE_ACCT, String P_INVOICEPRICEVARIANCE_ACCT, String P_TRADEDISCOUNTREC_ACCT, String P_TRADEDISCOUNTGRANT_ACCT, String P_COGS_ACCT, String C_RECEIVABLE_ACCT, String C_PREPAYMENT_ACCT, String V_LIABILITY_ACCT, String V_LIABILITY_SERVICES_ACCT, String V_PREPAYMENT_ACCT, String PAYDISCOUNT_EXP_ACCT, String WRITEOFF_ACCT, String PAYDISCOUNT_REV_ACCT, String UNREALIZEDGAIN_ACCT, String UNREALIZEDLOSS_ACCT, String REALIZEDGAIN_ACCT, String REALIZEDLOSS_ACCT, String WITHHOLDING_ACCT, String E_PREPAYMENT_ACCT, String E_EXPENSE_ACCT, String PJ_ASSET_ACCT, String PJ_WIP_ACCT, String T_EXPENSE_ACCT, String T_LIABILITY_ACCT, String T_RECEIVABLES_ACCT, String T_DUE_ACCT, String T_CREDIT_ACCT, String B_INTRANSIT_ACCT, String B_ASSET_ACCT, String B_EXPENSE_ACCT, String B_INTERESTREV_ACCT, String B_INTERESTEXP_ACCT, String B_UNIDENTIFIED_ACCT, String B_UNALLOCATEDCASH_ACCT, String B_PAYMENTSELECT_ACCT, String B_SETTLEMENTGAIN_ACCT, String B_SETTLEMENTLOSS_ACCT, String B_REVALUATIONGAIN_ACCT, String B_REVALUATIONLOSS_ACCT, String CH_EXPENSE_ACCT, String CH_REVENUE_ACCT, String UNEARNEDREVENUE_ACCT, String NOTINVOICEDRECEIVABLES_ACCT, String NOTINVOICEDREVENUE_ACCT, String NOTINVOICEDRECEIPTS_ACCT, String CB_ASSET_ACCT, String CB_CASHTRANSFER_ACCT, String CB_DIFFERENCES_ACCT, String CB_EXPENSE_ACCT, String CB_RECEIPT_ACCT, String A_ACCUMDEPRECIATION_ACCT, String A_DEPRECIATION_ACCT, String A_DISPOSAL_GAIN, String A_DISPOSAL_LOSS, String C_ACCTSCHEMA_DEFAULT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "           INSERT INTO C_ACCTSCHEMA_DEFAULT (C_ACCTSCHEMA_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "           W_INVENTORY_ACCT, W_INVACTUALADJUST_ACCT, W_DIFFERENCES_ACCT, W_REVALUATION_ACCT," +
      "           P_REVENUE_ACCT, P_EXPENSE_ACCT, P_ASSET_ACCT,P_PURCHASEPRICEVARIANCE_ACCT, P_INVOICEPRICEVARIANCE_ACCT, P_TRADEDISCOUNTREC_ACCT," +
      "           P_TRADEDISCOUNTGRANT_ACCT, P_COGS_ACCT, C_RECEIVABLE_ACCT,C_PREPAYMENT_ACCT, V_LIABILITY_ACCT, V_LIABILITY_SERVICES_ACCT," +
      "           V_PREPAYMENT_ACCT, PAYDISCOUNT_EXP_ACCT, WRITEOFF_ACCT" +
      "           , PAYDISCOUNT_REV_ACCT, UNREALIZEDGAIN_ACCT, UNREALIZEDLOSS_ACCT," +
      "           REALIZEDGAIN_ACCT, REALIZEDLOSS_ACCT, WITHHOLDING_ACCT, E_PREPAYMENT_ACCT" +
      "           , E_EXPENSE_ACCT, PJ_ASSET_ACCT," +
      "           PJ_WIP_ACCT, T_EXPENSE_ACCT, T_LIABILITY_ACCT, T_RECEIVABLES_ACCT, T_DUE_ACCT, T_CREDIT_ACCT," +
      "           B_INTRANSIT_ACCT, B_ASSET_ACCT, B_EXPENSE_ACCT,B_INTERESTREV_ACCT, B_INTERESTEXP_ACCT, B_UNIDENTIFIED_ACCT," +
      "           B_UNALLOCATEDCASH_ACCT, B_PAYMENTSELECT_ACCT, B_SETTLEMENTGAIN_ACCT, B_SETTLEMENTLOSS_ACCT, B_REVALUATIONGAIN_ACCT, B_REVALUATIONLOSS_ACCT," +
      "           CH_EXPENSE_ACCT, CH_REVENUE_ACCT, UNEARNEDREVENUE_ACCT, NOTINVOICEDRECEIVABLES_ACCT, NOTINVOICEDREVENUE_ACCT, NOTINVOICEDRECEIPTS_ACCT," +
      "           CB_ASSET_ACCT, CB_CASHTRANSFER_ACCT, CB_DIFFERENCES_ACCT,CB_EXPENSE_ACCT, CB_RECEIPT_ACCT, PROCESSING," +
      "           A_ACCUMDEPRECIATION_ACCT, A_DEPRECIATION_ACCT, A_DISPOSAL_GAIN,A_DISPOSAL_LOSS, C_ACCTSCHEMA_DEFAULT_ID)" +
      "          VALUES (?, ?, ?, 'Y',now() ,?,now() ,? ," +
      "        ? ,? ,? ,? ," +
      "        ? ,? ,? ,? ,? ,? ," +
      "        ? ,? ,? ,? ,? ,? ," +
      "        ? ,? ,? ," +
      "        ? ,? ,? ," +
      "        ? ,? ,? ,? ," +
      "        ? ,? ," +
      "        ? ,? ,? ,? ,? ,? ," +
      "        ? ,? ,? ,? ,? , ?," +
      "        ? ,? ,? ,? ,? ,? ," +
      "        ? ,? ,? ,? ,? ,? ," +
      "        ? ,? ,? ,? ,? ,'N' ," +
      "        ? ,? ,? ,? ,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, W_INVENTORY_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, W_INVACTUALADJUST_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, W_DIFFERENCES_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, W_REVALUATION_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_REVENUE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_EXPENSE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_ASSET_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_PURCHASEPRICEVARIANCE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_INVOICEPRICEVARIANCE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_TRADEDISCOUNTREC_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_TRADEDISCOUNTGRANT_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, P_COGS_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_RECEIVABLE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_PREPAYMENT_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, V_LIABILITY_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, V_LIABILITY_SERVICES_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, V_PREPAYMENT_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PAYDISCOUNT_EXP_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, WRITEOFF_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PAYDISCOUNT_REV_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UNREALIZEDGAIN_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UNREALIZEDLOSS_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, REALIZEDGAIN_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, REALIZEDLOSS_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, WITHHOLDING_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, E_PREPAYMENT_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, E_EXPENSE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PJ_ASSET_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, PJ_WIP_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_EXPENSE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_LIABILITY_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_RECEIVABLES_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_DUE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, T_CREDIT_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_INTRANSIT_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_ASSET_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_EXPENSE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_INTERESTREV_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_INTERESTEXP_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_UNIDENTIFIED_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_UNALLOCATEDCASH_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_PAYMENTSELECT_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_SETTLEMENTGAIN_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_SETTLEMENTLOSS_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_REVALUATIONGAIN_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, B_REVALUATIONLOSS_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CH_EXPENSE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CH_REVENUE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UNEARNEDREVENUE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, NOTINVOICEDRECEIVABLES_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, NOTINVOICEDREVENUE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, NOTINVOICEDRECEIPTS_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_ASSET_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_CASHTRANSFER_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_DIFFERENCES_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_EXPENSE_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CB_RECEIPT_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_ACCUMDEPRECIATION_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_DEPRECIATION_ACCT);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_DISPOSAL_GAIN);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_DISPOSAL_LOSS);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_ACCTSCHEMA_DEFAULT_ID);

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

  public static int addDefault(Connection conn, ConnectionProvider connectionProvider, String tablename, String columnname, String defaultToUpdate, String cAcctSchemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE ";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      "      SET ";
    strSql = strSql + ((columnname==null || columnname.equals(""))?"":columnname);
    strSql = strSql + 
      " =" +
      "      ?" +
      "      WHERE C_ACCTSCHEMA_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (tablename != null && !(tablename.equals(""))) {
        }
      if (columnname != null && !(columnname.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultToUpdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctSchemaId);

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

  public static int insertOperands(Connection conn, ConnectionProvider connectionProvider, String cElementValueOperandId, String sign, String cElementValueId, String account, String seqno, String client, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_ELEMENTVALUE_OPERAND (" +
      "         C_ELEMENTVALUE_OPERAND_ID, SIGN, C_ELEMENTVALUE_ID," +
      "         ACCOUNT_ID, SEQNO, AD_CLIENT_ID," +
      "         AD_ORG_ID, ISACTIVE, CREATED," +
      "         CREATEDBY, UPDATED, UPDATEDBY)" +
      "      VALUES ( ?, TO_NUMBER(?), ?," +
      "               ?, TO_NUMBER(?), ?," +
      "               '0', 'Y', NOW()," +
      "                ?, NOW(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementValueOperandId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sign);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, account);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static int updateElementValue(Connection conn, ConnectionProvider connectionProvider, String iElementvalueId, String cElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_ElementValue" +
      "        SET Value=" +
      "        (SELECT Value" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,Name=" +
      "        (SELECT Name" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,Description=" +
      "        (SELECT Description" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      , AccountType=" +
      "        (SELECT AccountType" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,AccountSign=" +
      "        (SELECT AccountSign" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,IsDocControlled=" +
      "        (SELECT IsDocControlled" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,IsSummary=" +
      "        (SELECT IsSummary" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,PostActual=" +
      "        (SELECT PostActual" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,PostBudget=" +
      "        (SELECT PostBudget" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,PostEncumbrance=" +
      "        (SELECT PostEncumbrance" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,PostStatistical=" +
      "        (SELECT PostStatistical" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "      ,Updated=now()" +
      "      ,UpdatedBy=" +
      "        (SELECT UpdatedBy" +
      "        FROM I_ElementValue" +
      "        WHERE I_ElementValue_ID=?)" +
      "        WHERE C_ElementValue_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

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

  public static int updateProcessing(Connection conn, ConnectionProvider connectionProvider, String cElementvalueId, String iElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_IsImported='Y'," +
      "        C_ElementValue_id = ?," +
      "        Updated=now()," +
      "        Processed='Y'," +
      "        Processing='Y'" +
      "        WHERE I_ElementValue_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);

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

  public static int insertElementValueError(Connection conn, ConnectionProvider connectionProvider, String message, String iElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||' Insert ElementValue: '||?" +
      "        WHERE I_ElementValue_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, message);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);

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

  public static int updateElementValueError(Connection conn, ConnectionProvider connectionProvider, String message, String iElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||' Update ElementValue: '||?" +
      "        WHERE I_ElementValue_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, message);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);

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

  public static int updateNotImported(Connection conn, ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_IsImported='N', Updated=now()" +
      "        WHERE I_IsImported<>'Y'" +
      "        and ad_client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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

  public static int setParent(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET ParentElementValue_ID = (" +
      "          SELECT C_ElementValue_ID" +
      "          FROM C_ElementValue ev" +
      "          WHERE I_ElementValue.C_Element_ID = ev.C_Element_ID" +
      "          AND I_ElementValue.ParentValue = ev.Value" +
      "          AND I_ElementValue.AD_Client_ID = ev.AD_Client_ID" +
      "        )" +
      "        WHERE ParentElementValue_ID IS NULL" +
      "        AND I_IsImported='Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static int setParentError(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'Info=ParentNotFound, '" +
      "        WHERE ParentElementValue_ID IS NULL" +
      "        AND ParentValue IS NOT NULL" +
      "        AND I_IsImported='Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static ImportAccountData[] selectParents(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    return selectParents(conn, connectionProvider, adClientId, 0, 0);
  }

  public static ImportAccountData[] selectParents(Connection conn, ConnectionProvider connectionProvider, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.ParentElementValue_ID, i.I_ElementValue_ID," +
      "          e.AD_Tree_ID, i.C_ElementValue_ID, i.Value||'-'||i.Name AS Info, SeqNo" +
      "        FROM I_ElementValue i" +
      "        INNER JOIN C_Element e ON (i.C_Element_ID=e.C_Element_ID)" +
      "        WHERE i.C_ElementValue_ID IS NOT NULL" +
      "        AND e.AD_Tree_ID IS NOT NULL" +
      "        AND i.ParentElementValue_ID IS NOT NULL" +
      "        AND i.I_IsImported='Y'" +
      "        AND i.AD_Client_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        ImportAccountData objectImportAccountData = new ImportAccountData();
        objectImportAccountData.parentelementvalueId = UtilSql.getValue(result, "parentelementvalue_id");
        objectImportAccountData.iElementvalueId = UtilSql.getValue(result, "i_elementvalue_id");
        objectImportAccountData.adTreeId = UtilSql.getValue(result, "ad_tree_id");
        objectImportAccountData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectImportAccountData.info = UtilSql.getValue(result, "info");
        objectImportAccountData.seqno = UtilSql.getValue(result, "seqno");
        objectImportAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportAccountData);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    ImportAccountData objectImportAccountData[] = new ImportAccountData[vector.size()];
    vector.copyInto(objectImportAccountData);
    return(objectImportAccountData);
  }

  public static int updateTree(Connection conn, ConnectionProvider connectionProvider, String parentId, String seqNo, String adTreeId, String nodeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_TreeNode" +
      "        SET Parent_id = ?," +
      "          SeqNo= to_number(?)" +
      "        WHERE AD_Tree_ID=?" +
      "        AND Node_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTreeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nodeId);

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

  public static int updateProcessed(Connection conn, ConnectionProvider connectionProvider, String adClientId, String clause)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET Processing='-'" +
      "        WHERE I_IsImported='Y'" +
      "        AND Processed='Y'" +
      "        AND Processing='Y'" +
      "        AND C_ElementValue_ID IS NOT NULL" +
      "        AND AD_Client_ID=?" +
      "        AND 1=1";
    strSql = strSql + ((clause.equals("clause"))?"  AND AD_Column_ID IS NULL ":"");

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      if (clause != null && !(clause.equals(""))) {
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

  public static int updateDescription(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_ValidCombination" +
      "        SET Updated=now()" +
      "        WHERE AD_Client_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static ImportAccountData[] selectAcctSchema(ConnectionProvider connectionProvider, String cElementId, String adClientId)    throws ServletException {
    return selectAcctSchema(connectionProvider, cElementId, adClientId, 0, 0);
  }

  public static ImportAccountData[] selectAcctSchema(ConnectionProvider connectionProvider, String cElementId, String adClientId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_AcctSchema.C_AcctSchema_ID, C_AcctSchema.AD_Client_ID, C_AcctSchema.AD_Org_id" +
      "        FROM C_AcctSchema_Element, C_AcctSchema" +
      "        WHERE C_AcctSchema_Element.C_ACCTSCHEMA_ID = C_AcctSchema.C_ACCTSCHEMA_ID" +
      "        AND C_AcctSchema_Element.C_Element_ID = ?" +
      "        AND C_AcctSchema_Element.AD_Client_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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
        ImportAccountData objectImportAccountData = new ImportAccountData();
        objectImportAccountData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectImportAccountData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportAccountData);
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
    ImportAccountData objectImportAccountData[] = new ImportAccountData[vector.size()];
    vector.copyInto(objectImportAccountData);
    return(objectImportAccountData);
  }

  public static int updateDefaultAcct(Connection conn, ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_AcctSchema_Element" +
      "        SET C_ElementValue_ID = (" +
      "          SELECT C_ElementValue_ID" +
      "          FROM I_ElementValue i" +
      "          WHERE C_AcctSchema_Element.C_Element_ID=i.C_Element_ID" +
      "          AND i.C_ElementValue_ID IS NOT NULL" +
      "          AND UPPER(i.Default_Account)='DEFAULT_ACCT'" +
      "        )" +
      "        WHERE EXISTS (" +
      "          SELECT *" +
      "          FROM I_ElementValue i" +
      "          WHERE C_AcctSchema_Element.C_Element_ID=i.C_Element_ID" +
      "          AND i.C_ElementValue_ID IS NOT NULL" +
      "          AND UPPER(i.Default_Account)='DEFAULT_ACCT'" +
      "          AND i.I_IsImported='Y'" +
      "        )" +
      "        AND AD_Client_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static String selectAcctSchemaAC(ConnectionProvider connectionProvider, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_element_id" +
      "        from c_acctschema_element" +
      "        where c_acctschema_id = ?" +
      "        and upper(elementtype) like 'AC'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_element_id");
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

  public static ImportAccountData[] selectElementColumnTable(ConnectionProvider connectionProvider, String cElementId)    throws ServletException {
    return selectElementColumnTable(connectionProvider, cElementId, 0, 0);
  }

  public static ImportAccountData[] selectElementColumnTable(ConnectionProvider connectionProvider, String cElementId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT i.C_ElementValue_ID, t.TableName, c.ColumnName, i.I_ElementValue_ID" +
      "        FROM I_ElementValue i" +
      "        INNER JOIN AD_Column c ON (i.AD_Column_ID=c.AD_Column_ID)" +
      "        INNER JOIN AD_Table t ON (c.AD_Table_ID=t.AD_Table_ID)" +
      "        WHERE i.I_IsImported='Y'" +
      "        AND i.Processed='Y'" +
      "        AND Processing='Y'" +
      "        AND i.C_ElementValue_ID IS NOT NULL" +
      "        AND C_Element_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementId);

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
        ImportAccountData objectImportAccountData = new ImportAccountData();
        objectImportAccountData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectImportAccountData.tablename = UtilSql.getValue(result, "tablename");
        objectImportAccountData.columnname = UtilSql.getValue(result, "columnname");
        objectImportAccountData.iElementvalueId = UtilSql.getValue(result, "i_elementvalue_id");
        objectImportAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportAccountData);
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
    ImportAccountData objectImportAccountData[] = new ImportAccountData[vector.size()];
    vector.copyInto(objectImportAccountData);
    return(objectImportAccountData);
  }

  public static int updateProcessingN(Connection conn, ConnectionProvider connectionProvider, String iElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_ElementValue" +
      "        SET Processing='N'" +
      "        WHERE I_ElementValue_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iElementvalueId);

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

  public static ImportAccountData[] selectValidCombination(ConnectionProvider connectionProvider, String columnname, String tablename, String cAcctSchemaId)    throws ServletException {
    return selectValidCombination(connectionProvider, columnname, tablename, cAcctSchemaId, 0, 0);
  }

  public static ImportAccountData[] selectValidCombination(ConnectionProvider connectionProvider, String columnname, String tablename, String cAcctSchemaId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT x.";
    strSql = strSql + ((columnname==null || columnname.equals(""))?"":columnname);
    strSql = strSql + 
      " as C_ValidCombination_ID, Account_ID" +
      "        FROM ";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      " x" +
      "        INNER JOIN C_VALIDCOMBINATION vc ON (x.";
    strSql = strSql + ((columnname==null || columnname.equals(""))?"":columnname);
    strSql = strSql + 
      "=vc.C_ValidCombination_ID)" +
      "        WHERE x.C_AcctSchema_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (columnname != null && !(columnname.equals(""))) {
        }
      if (tablename != null && !(tablename.equals(""))) {
        }
      if (columnname != null && !(columnname.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctSchemaId);

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
        ImportAccountData objectImportAccountData = new ImportAccountData();
        objectImportAccountData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectImportAccountData.accountId = UtilSql.getValue(result, "account_id");
        objectImportAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportAccountData);
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
    ImportAccountData objectImportAccountData[] = new ImportAccountData[vector.size()];
    vector.copyInto(objectImportAccountData);
    return(objectImportAccountData);
  }

  public static ImportAccountData[] selectValidCombinationAll(ConnectionProvider connectionProvider, String cValidcombinationId)    throws ServletException {
    return selectValidCombinationAll(connectionProvider, cValidcombinationId, 0, 0);
  }

  public static ImportAccountData[] selectValidCombinationAll(ConnectionProvider connectionProvider, String cValidcombinationId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_CLIENT_ID,AD_ORG_ID, AD_ORGTRX_ID, ISACTIVE, CREATED, CREATEDBY," +
      "				UPDATED,UPDATEDBY, ALIAS, COMBINATION, DESCRIPTION, ISFULLYQUALIFIED," +
      "        C_ACCTSCHEMA_ID, ACCOUNT_ID, M_PRODUCT_ID, C_BPARTNER_ID," +
      "        AD_ORGTRX_ID, C_LOCFROM_ID, C_LOCTO_ID, C_SALESREGION_ID," +
      "        C_PROJECT_ID, C_CAMPAIGN_ID, C_ACTIVITY_ID, USER1_ID,USER2_ID" +
      "        FROM C_ValidCombination" +
      "        WHERE C_ValidCombination_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);

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
        ImportAccountData objectImportAccountData = new ImportAccountData();
        objectImportAccountData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportAccountData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportAccountData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectImportAccountData.isactive = UtilSql.getValue(result, "isactive");
        objectImportAccountData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectImportAccountData.createdby = UtilSql.getValue(result, "createdby");
        objectImportAccountData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectImportAccountData.updatedby = UtilSql.getValue(result, "updatedby");
        objectImportAccountData.alias = UtilSql.getValue(result, "alias");
        objectImportAccountData.combination = UtilSql.getValue(result, "combination");
        objectImportAccountData.description = UtilSql.getValue(result, "description");
        objectImportAccountData.isfullyqualified = UtilSql.getValue(result, "isfullyqualified");
        objectImportAccountData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectImportAccountData.accountId = UtilSql.getValue(result, "account_id");
        objectImportAccountData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectImportAccountData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportAccountData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectImportAccountData.cLocfromId = UtilSql.getValue(result, "c_locfrom_id");
        objectImportAccountData.cLoctoId = UtilSql.getValue(result, "c_locto_id");
        objectImportAccountData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectImportAccountData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectImportAccountData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectImportAccountData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectImportAccountData.user1Id = UtilSql.getValue(result, "user1_id");
        objectImportAccountData.user2Id = UtilSql.getValue(result, "user2_id");
        objectImportAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportAccountData);
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
    ImportAccountData objectImportAccountData[] = new ImportAccountData[vector.size()];
    vector.copyInto(objectImportAccountData);
    return(objectImportAccountData);
  }

  public static ImportAccountData insertValidCombination(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cAcctschemaId, String accountId, String cInValidcombinationId, String alias, String createdby, String mProductId, String cBpartnerId, String cProjectId, String cCampaignId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_ValidCombination_Insert(?, ?, ?, ?, ?, ?, 'N', ?, ?, ?, ?, NULL, NULL, NULL, NULL, ?, ?, NULL, NULL, NULL)";

    ImportAccountData objectImportAccountData = new ImportAccountData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      int iParametercValidcombinationId = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInValidcombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alias);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);

      st.execute();
      objectImportAccountData.cValidcombinationId= UtilSql.getStringCallableStatement(st, iParametercValidcombinationId);
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement("cValidcombinationId");
      parametersTypes.addElement("out");
      parametersData.addElement(adClientId);
      parametersTypes.addElement("in");
      parametersData.addElement(adOrgId);
      parametersTypes.addElement("in");
      parametersData.addElement(cAcctschemaId);
      parametersTypes.addElement("in");
      parametersData.addElement(accountId);
      parametersTypes.addElement("in");
      parametersData.addElement(cInValidcombinationId);
      parametersTypes.addElement("in");
      parametersData.addElement(alias);
      parametersTypes.addElement("in");
      parametersData.addElement(createdby);
      parametersTypes.addElement("in");
      parametersData.addElement(mProductId);
      parametersTypes.addElement("in");
      parametersData.addElement(cBpartnerId);
      parametersTypes.addElement("in");
      parametersData.addElement(cProjectId);
      parametersTypes.addElement("in");
      parametersData.addElement(cCampaignId);
      parametersTypes.addElement("in");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectImportAccountData.cValidcombinationId = (String) vecTotal.elementAt(0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectImportAccountData);
  }

  public static RespuestaCS getCValidCombination(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId, String cAcctschemaId, String accountId, String cValidcombinationId, String isfullyqualified, String alias, String createdby, String mProductId, String cBpartnerId, String adOrgtrxId, String cLocfromId, String cLoctoId, String cSalesregionId, String cProjectId, String cCampaignId, String cActivityId, String user1Id, String user2Id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_ValidCombination_Get(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";

    RespuestaCS objectRespuestaCS = new RespuestaCS();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      int iParameterCValidCombinationId = iParameter + 1;
      iParameter++; st.registerOutParameter(iParameter, 12);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfullyqualified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alias);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocfromId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLoctoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);

      st.execute();
      objectRespuestaCS.CValidCombinationId= UtilSql.getStringCallableStatement(st, iParameterCValidCombinationId);
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement("CValidCombinationId");
      parametersTypes.addElement("out");
      parametersData.addElement(adClientId);
      parametersTypes.addElement("in");
      parametersData.addElement(adOrgId);
      parametersTypes.addElement("in");
      parametersData.addElement(cAcctschemaId);
      parametersTypes.addElement("in");
      parametersData.addElement(accountId);
      parametersTypes.addElement("in");
      parametersData.addElement(cValidcombinationId);
      parametersTypes.addElement("in");
      parametersData.addElement(isfullyqualified);
      parametersTypes.addElement("in");
      parametersData.addElement(alias);
      parametersTypes.addElement("in");
      parametersData.addElement(createdby);
      parametersTypes.addElement("in");
      parametersData.addElement(mProductId);
      parametersTypes.addElement("in");
      parametersData.addElement(cBpartnerId);
      parametersTypes.addElement("in");
      parametersData.addElement(adOrgtrxId);
      parametersTypes.addElement("in");
      parametersData.addElement(cLocfromId);
      parametersTypes.addElement("in");
      parametersData.addElement(cLoctoId);
      parametersTypes.addElement("in");
      parametersData.addElement(cSalesregionId);
      parametersTypes.addElement("in");
      parametersData.addElement(cProjectId);
      parametersTypes.addElement("in");
      parametersData.addElement(cCampaignId);
      parametersTypes.addElement("in");
      parametersData.addElement(cActivityId);
      parametersTypes.addElement("in");
      parametersData.addElement(user1Id);
      parametersTypes.addElement("in");
      parametersData.addElement(user2Id);
      parametersTypes.addElement("in");
      Vector<String> vecTotal = new Vector<String>();
      try {
        vecTotal =       RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 1);
      objectRespuestaCS.CValidCombinationId = (String) vecTotal.elementAt(0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectRespuestaCS);
  }

  public static int updateAccountIdByVC(Connection conn, ConnectionProvider connectionProvider, String accountId, String cValidcombinationId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        update C_ValidCombination" +
      "        SET Account_ID = ?" +
      "        WHERE C_ValidCombination_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);

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

  public static int updateAbstract(Connection conn, ConnectionProvider connectionProvider, String tablename, String columnname, String cValidcombinationId, String cAcctschemaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE  ";
    strSql = strSql + ((tablename==null || tablename.equals(""))?"":tablename);
    strSql = strSql + 
      "        SET  ";
    strSql = strSql + ((columnname==null || columnname.equals(""))?"":columnname);
    strSql = strSql + 
      " = ?" +
      "        WHERE C_AcctSchema_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (tablename != null && !(tablename.equals(""))) {
        }
      if (columnname != null && !(columnname.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cAcctschemaId);

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

  public static int updateAccountId(Connection conn, ConnectionProvider connectionProvider, String cElementvalueId, String accountId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			  UPDATE C_ValidCombination" +
      "				SET Account_id = ?" +
      "				WHERE Account_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);

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

  public static int updateFact(Connection conn, ConnectionProvider connectionProvider, String cElementvalueId, String accountId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			  UPDATE Fact_Acct" +
      "				SET Account_id = ?" +
      "				WHERE Account_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);

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

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

class ImportBudgetData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportBudgetData.class);
  private String InitRecordNumber="0";
  public String iBudgetlineId;
  public String cBudgetlineId;
  public String seqno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("i_budgetline_id") || fieldName.equals("iBudgetlineId"))
      return iBudgetlineId;
    else if (fieldName.equalsIgnoreCase("c_budgetline_id") || fieldName.equals("cBudgetlineId"))
      return cBudgetlineId;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ImportBudgetData[] select(ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    return select(connectionProvider, ad_client_id, 0, 0);
  }

  public static ImportBudgetData[] select(ConnectionProvider connectionProvider, String ad_client_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT I_BudgetLine_ID, C_Budgetline_ID, '' as seqNo" +
      "        FROM I_BudgetLine" +
      "        WHERE I_IsImported='N'" +
      "        AND AD_Client_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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
        ImportBudgetData objectImportBudgetData = new ImportBudgetData();
        objectImportBudgetData.iBudgetlineId = UtilSql.getValue(result, "i_budgetline_id");
        objectImportBudgetData.cBudgetlineId = UtilSql.getValue(result, "c_budgetline_id");
        objectImportBudgetData.seqno = UtilSql.getValue(result, "seqno");
        objectImportBudgetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportBudgetData);
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
    ImportBudgetData objectImportBudgetData[] = new ImportBudgetData[vector.size()];
    vector.copyInto(objectImportBudgetData);
    return(objectImportBudgetData);
  }

  public static String selectSeqNo(ConnectionProvider connectionProvider, String c_budget_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(max(SeqNo),0) +10 as seqNo" +
      "        FROM C_BudgetLine" +
      "        WHERE C_Budget_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_budget_id);

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

  public static int deleteOld(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM I_BudgetLine WHERE I_IsImported='Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateRecords(Connection conn, ConnectionProvider connectionProvider, String ad_client_id, String c_budget_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET AD_Client_ID = COALESCE(AD_Client_ID, ?)," +
      "        AD_Org_ID = COALESCE(AD_Org_ID, '0')," +
      "        IsActive = COALESCE(IsActive, 'Y')," +
      "        Created = COALESCE(Created, now())," +
      "        CreatedBy = COALESCE(CreatedBy, '0')," +
      "        Updated = COALESCE(Updated, now())," +
      "        UpdatedBy = COALESCE(UpdatedBy, '0')," +
      "        I_ErrorMsg = NULL," +
      "        I_IsImported = 'N'," +
      "        C_Budget_ID = ?" +
      "        WHERE I_IsImported<>'Y' OR I_IsImported IS NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_budget_id);

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

  public static int updateBPartnerId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_BPartner_ID=(" +
      "          SELECT C_BPartner_ID FROM C_BPartner p" +
      "			    WHERE I_BudgetLine.PartnerIdent=AD_COLUMN_IDENTIFIER('C_BPARTNER', TO_CHAR(p.C_BPARTNER_ID), ?)" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE C_BPartner_ID IS NULL" +
      "        AND PartnerIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updatePartnerError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Partner, ' " +
      "        WHERE C_BPartner_ID IS NULL" +
      "        AND PartnerIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateBPGroupId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_BP_Group_ID=(" +
      "          SELECT C_BP_Group_ID FROM C_BP_Group g" +
      "			    WHERE I_BudgetLine.BPGroupIdent=AD_COLUMN_IDENTIFIER('C_BP_GROUP', TO_CHAR(g.C_BP_GROUP_ID), ?)" +
      "          AND g.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE C_BP_Group_ID IS NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateGroupError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Group, ' " +
      "        WHERE C_BP_Group_ID IS NULL" +
      "        AND BPGROUPIDENT IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateProductId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET M_Product_ID=(" +
      "          SELECT M_Product_ID FROM M_Product p" +
      "			    WHERE I_BudgetLine.ProductIdent=AD_COLUMN_IDENTIFIER('M_PRODUCT', TO_CHAR(p.M_Product_ID), ?)" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE M_Product_ID IS NULL" +
      "        AND ProductIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateUomId(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "        SET C_Uom_ID=(" +
      "          SELECT p.C_Uom_ID FROM M_Product p" +
      "          WHERE I_BudgetLine.M_Product_ID=p.M_Product_ID" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "        WHERE M_Product_ID IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateProductError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Product, '" +
      "        WHERE M_Product_ID IS NULL" +
      "        AND ProductIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateProdCatId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET M_Product_Category_ID=(" +
      "          SELECT M_Product_Category_ID FROM M_Product_Category p" +
      "			    WHERE I_BudgetLine.ProdCategoryIdent=AD_COLUMN_IDENTIFIER('M_PRODUCT_CATEGORY', TO_CHAR(p.M_Product_Category_ID), ?)" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE M_Product_Category_ID IS NULL" +
      "        AND ProdCategoryIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateProdCatError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Product Category, ' " +
      "        WHERE M_Product_Category_ID IS NULL" +
      "        AND ProdCategoryIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateTrxOrgId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "        SET AD_OrgTrx_ID=(" +
      "          SELECT AD_Org_ID FROM AD_Org o" +
      "          WHERE I_BudgetLine.OrgTrxIdent=AD_COLUMN_IDENTIFIER('AD_ORG', TO_CHAR(o.AD_Org_ID), ?)" +
      "        )" +
      "        WHERE AD_OrgTrx_ID IS NULL" +
      "         AND OrgTrxIdent IS NOT NULL" +
      "         AND I_IsImported<>'Y'" +
      "         AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateTrxOrgError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Trx Organization, ' " +
      "        WHERE AD_OrgTrx_ID IS NULL" +
      "        AND OrgTrxIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateSalesRegionId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_SalesRegion_ID=(" +
      "          SELECT C_SalesRegion_ID FROM C_SalesRegion sr" +
      "			    WHERE I_BudgetLine.SalesRegionIdent=AD_COLUMN_IDENTIFIER('C_SALESREGION', TO_CHAR(sr.C_SalesRegion_ID), ?)" +
      "          AND sr.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE C_SalesRegion_ID IS NULL" +
      "        AND SalesRegionIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateSalesRegionError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Sales Region, ' " +
      "        WHERE C_SalesRegion_ID IS NULL" +
      "        AND SalesRegionIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateProjectId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_Project_ID=(" +
      "          SELECT C_Project_ID FROM C_Project p" +
      "			    WHERE I_BudgetLine.ProjectIdent=AD_COLUMN_IDENTIFIER('C_PROJECT', TO_CHAR(p.C_Project_ID), ?)" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE C_Project_ID IS NULL" +
      "        AND ProjectIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateProjectError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Project, ' " +
      "        WHERE C_Project_ID IS NULL" +
      "        AND ProjectIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateCampaignId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_Campaign_ID=(" +
      "          SELECT C_Campaign_ID FROM C_Campaign p" +
      "			    WHERE I_BudgetLine.CampaignIdent=AD_COLUMN_IDENTIFIER('C_CAMPAIGN', TO_CHAR(p.C_Campaign_ID), ?)" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE C_Campaign_ID IS NULL" +
      "        AND CampaignIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateCampaignError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Campaign, ' " +
      "        WHERE C_Campaign_ID IS NULL" +
      "        AND CampaignIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateActivityId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_Activity_ID=(" +
      "          SELECT C_Activity_ID FROM C_Activity p" +
      "			    WHERE I_BudgetLine.ActivityIdent=AD_COLUMN_IDENTIFIER('C_ACTIVITY', TO_CHAR(p.C_Activity_ID), ?)" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE C_Activity_ID IS NULL" +
      "        AND ActivityIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateActivityError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Activity, ' " +
      "        WHERE C_Activity_ID IS NULL" +
      "        AND ActivityIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateAccountId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_ELEMENTVALUE_ID=(" +
      "          SELECT C_ELEMENTVALUE_ID FROM C_ELEMENTVALUE v" +
      "			    WHERE I_BudgetLine.ELEMENTVALUEIDENT=AD_COLUMN_IDENTIFIER('C_ELEMENTVALUE', TO_CHAR(v.C_ELEMENTVALUE_ID), ?)" +
      "          AND v.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE C_ELEMENTVALUE_ID IS NULL" +
      "        AND ELEMENTVALUEIDENT IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateAccountIdError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Account ID, ' " +
      "        WHERE C_ELEMENTVALUE_ID IS NULL" +
      "        AND ELEMENTVALUEIDENT IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateAcctSchemaId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_ACCTSCHEMA_ID=(" +
      "          SELECT C_ACCTSCHEMA_ID FROM C_ACCTSCHEMA p" +
      "			    WHERE I_BudgetLine.ACCTSCHEMAIDENT=AD_COLUMN_IDENTIFIER('C_ACCTSCHEMA', TO_CHAR(p.C_ACCTSCHEMA_ID), ?)" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "        )" +
      "			  WHERE C_ACCTSCHEMA_ID IS NULL" +
      "        AND ACCTSCHEMAIDENT IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateAcctSchemaError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Account Schema, ' " +
      "        WHERE C_ACCTSCHEMA_ID IS NULL" +
      "        AND ACCTSCHEMAIDENT IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updatePeriodId(Connection conn, ConnectionProvider connectionProvider, String cBudgetId, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_Period_ID=(" +
      "          SELECT C_Period_ID FROM C_Period p, AD_Month m" +
      "			    WHERE I_BudgetLine.PeriodIdent=m.Name" +
      "          AND p.PeriodNo = m.Value" +
      "          AND p.AD_Client_ID=I_BudgetLine.AD_Client_ID" +
      "          AND p.C_Year_ID = (SELECT C_Year_ID FROM C_Budget WHERE C_Budget_ID = ?)" +
      "        )" +
      "			  WHERE C_Period_ID IS NULL" +
      "        AND PeriodIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updatePeriodError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid Period, ' " +
      "        WHERE C_Period_ID IS NULL" +
      "        AND PeriodIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateCurrencyId(Connection conn, ConnectionProvider connectionProvider, String adlanguage, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "			  SET C_Currency_ID=(" +
      "          SELECT C_Currency_ID FROM C_Currency p" +
      "			    WHERE I_BudgetLine.CurrencyIdent=AD_COLUMN_IDENTIFIER('C_CURRENCY', TO_CHAR(p.C_Currency_ID), ?)" +
      "        )" +
      "			  WHERE C_Currency_ID IS NULL" +
      "        AND CurrencyIdent IS NOT NULL" +
      "			  AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adlanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateCurrencyError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid currency, ' " +
      "        WHERE C_Currency_ID IS NULL" +
      "        AND CurrencyIdent IS NOT NULL" +
      "        AND I_IsImported<>'Y'" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int updateBudgetLineId(Connection conn, ConnectionProvider connectionProvider, String cBudgetId, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine " +
      "        SET C_BudgetLine_ID=(" +
      "            SELECT MIN(C_BudgetLine_ID) FROM C_BudgetLine bl" +
      "            WHERE COALESCE(I_BudgetLine.C_ELEMENTVALUE_ID,-1) = COALESCE(bl.C_ELEMENTVALUE_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.C_Period_ID,-1) = COALESCE(bl.C_Period_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.C_Bpartner_ID,-1) = COALESCE(bl.C_Bpartner_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.AD_OrgTrx_ID,-1) = COALESCE(bl.AD_OrgTrx_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.C_SalesRegion_ID,-1) = COALESCE(bl.C_SalesRegion_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.C_Project_ID,-1) = COALESCE(bl.C_Project_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.C_Campaign_ID,-1) = COALESCE(bl.C_Campaign_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.C_Activity_ID,-1) = COALESCE(bl.C_Activity_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.C_BP_Group_ID,-1) = COALESCE(bl.C_BP_Group_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.M_Product_ID,-1) = COALESCE(bl.M_Product_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.M_Product_Category_ID,-1) = COALESCE(bl.M_Product_Category_ID,-1)" +
      "              AND COALESCE(I_BudgetLine.C_Currency_ID,-1) = COALESCE(bl.C_Currency_ID,-1)" +
      "              AND bl.C_Budget_ID = ?" +
      "              AND bl.AD_Client_ID = I_BudgetLine.AD_Client_ID" +
      "            )" +
      "        WHERE I_IsImported='N'" +
      "          AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

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

  public static int insertBudgetLine(Connection conn, ConnectionProvider connectionProvider, String CBudgetLineID, String seqno, String IBudgetLineID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_BudgetLine (C_Budgetline_ID, AD_Client_ID, AD_Org_ID, Isactive, Created, Createdby, " +
      "            Updated, Updatedby, C_ELEMENTVALUE_ID, C_ACCTSCHEMA_ID, C_Period_ID, C_Currency_ID, C_Uom_ID, Qty, M_Product_ID, " +
      "            C_Bpartner_ID, AD_Orgtrx_ID, C_Salesregion_ID, C_Project_ID, C_Campaign_ID, C_Activity_ID, Description, " +
      "            Seqno, C_Bp_Group_ID, M_Product_Category_ID, C_Budget_ID, Amount, Price)" +
      "            SELECT ?, AD_Client_ID, AD_Org_ID, 'Y',now(),CreatedBy," +
      "            now(),UpdatedBy, C_ELEMENTVALUE_ID, C_ACCTSCHEMA_ID, C_Period_ID, C_Currency_ID, C_Uom_ID, Qty, M_Product_ID, " +
      "            C_Bpartner_ID, AD_Orgtrx_ID, C_Salesregion_ID, C_Project_ID, C_Campaign_ID, C_Activity_ID, Description, " +
      "            TO_NUMBER(?), C_Bp_Group_ID, M_Product_Category_ID, C_Budget_ID, Amount, Price" +
      "            FROM I_BudgetLine" +
      "            WHERE I_BudgetLine_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CBudgetLineID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IBudgetLineID);

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

  public static int insertBudgetLineError(ConnectionProvider connectionProvider, String error, String I_BudgetLine_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'') || 'Insert BudgetLine error: ' || ?" +
      "        WHERE I_BudgetLine_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, error);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, I_BudgetLine_id);

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

  public static int updateBudgetLine(Connection conn, ConnectionProvider connectionProvider, String IBudgetLineID, String CBudgetLineID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_BudgetLine" +
      "        SET " +
      "          Qty=(" +
      "          SELECT Qty" +
      "          FROM I_BudgetLine" +
      "          WHERE I_BudgetLine_ID=?" +
      "        )," +
      "          Amount=(" +
      "          SELECT Amount" +
      "          FROM I_BudgetLine" +
      "          WHERE I_BudgetLine_ID=?" +
      "        )," +
      "          Price=(" +
      "          SELECT Price" +
      "          FROM I_BudgetLine" +
      "          WHERE I_BudgetLine_ID=?" +
      "        )," +
      "          Updated=now()" +
      "        ," +
      "          UpdatedBy=(" +
      "          SELECT UpdatedBy" +
      "          FROM I_BudgetLine" +
      "          WHERE I_BudgetLine_ID=?" +
      "        )" +
      "        WHERE C_BudgetLine_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IBudgetLineID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CBudgetLineID);

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

  public static int updateBudgetLineError(ConnectionProvider connectionProvider, String error, String I_BudgetLine_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'') || 'Update BudgetLine error: ' || ?" +
      "        WHERE I_BudgetLine_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, error);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, I_BudgetLine_id);

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

  public static int updateSetImportedError(ConnectionProvider connectionProvider, String error, String I_BudgetLine_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    UPDATE I_BudgetLine" +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'') || 'Set imported error: ' || ?" +
      "        WHERE I_BudgetLine_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, error);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, I_BudgetLine_id);

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

  public static int setImported(Connection conn, ConnectionProvider connectionProvider, String CBudgetLineID, String IBudgetLineID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='Y', C_BudgetLine_id = ?, Updated=now(), Processed='Y'" +
      "        WHERE I_BudgetLine_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CBudgetLineID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IBudgetLineID);

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

  public static int updateNotImported(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_BudgetLine" +
      "        SET I_IsImported='N', Updated=now()" +
      "        WHERE I_IsImported<>'Y'" +
      "        AND AD_CLIENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }
}

//Sqlc generated V1.O00-1
package org.zsoft.banking;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class SepaExportServiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(SepaExportServiceData.class);
  private String InitRecordNumber="0";
  public String zsfiSepaExportDataId;
  public String adClientId;
  public String adOrgId;
  public String createdby;
  public String updatedby;
  public String grphdrMsgid;
  public String cBankaccountId;
  public String cBpBankaccountId;
  public String amtInstdamt;
  public String pmtinfPmtinfid;
  public String pmtinfReqdexctndt;
  public String rmtinfUstrd;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("zsfi_sepa_export_data_id") || fieldName.equals("zsfiSepaExportDataId"))
      return zsfiSepaExportDataId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("grphdr_msgid") || fieldName.equals("grphdrMsgid"))
      return grphdrMsgid;
    else if (fieldName.equalsIgnoreCase("c_bankaccount_id") || fieldName.equals("cBankaccountId"))
      return cBankaccountId;
    else if (fieldName.equalsIgnoreCase("c_bp_bankaccount_id") || fieldName.equals("cBpBankaccountId"))
      return cBpBankaccountId;
    else if (fieldName.equalsIgnoreCase("amt_instdamt") || fieldName.equals("amtInstdamt"))
      return amtInstdamt;
    else if (fieldName.equalsIgnoreCase("pmtinf_pmtinfid") || fieldName.equals("pmtinfPmtinfid"))
      return pmtinfPmtinfid;
    else if (fieldName.equalsIgnoreCase("pmtinf_reqdexctndt") || fieldName.equals("pmtinfReqdexctndt"))
      return pmtinfReqdexctndt;
    else if (fieldName.equalsIgnoreCase("rmtinf_ustrd") || fieldName.equals("rmtinfUstrd"))
      return rmtinfUstrd;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SepaExportServiceData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static SepaExportServiceData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	         SELECT '' as zsfi_sepa_export_data_id,'' as ad_client_id,'' as ad_org_id,'' as createdby,'' as updatedby,'' as grphdr_msgid,'' as c_bankaccount_id,'' as c_bp_bankaccount_id," +
      "                         '' as  amt_instdamt, '' as pmtinf_pmtinfid,'' as pmtinf_reqdexctndt,'' as rmtinf_ustrd from dual;";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        SepaExportServiceData objectSepaExportServiceData = new SepaExportServiceData();
        objectSepaExportServiceData.zsfiSepaExportDataId = UtilSql.getValue(result, "zsfi_sepa_export_data_id");
        objectSepaExportServiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSepaExportServiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSepaExportServiceData.createdby = UtilSql.getValue(result, "createdby");
        objectSepaExportServiceData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSepaExportServiceData.grphdrMsgid = UtilSql.getValue(result, "grphdr_msgid");
        objectSepaExportServiceData.cBankaccountId = UtilSql.getValue(result, "c_bankaccount_id");
        objectSepaExportServiceData.cBpBankaccountId = UtilSql.getValue(result, "c_bp_bankaccount_id");
        objectSepaExportServiceData.amtInstdamt = UtilSql.getValue(result, "amt_instdamt");
        objectSepaExportServiceData.pmtinfPmtinfid = UtilSql.getValue(result, "pmtinf_pmtinfid");
        objectSepaExportServiceData.pmtinfReqdexctndt = UtilSql.getValue(result, "pmtinf_reqdexctndt");
        objectSepaExportServiceData.rmtinfUstrd = UtilSql.getValue(result, "rmtinf_ustrd");
        objectSepaExportServiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSepaExportServiceData);
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
    SepaExportServiceData objectSepaExportServiceData[] = new SepaExportServiceData[vector.size()];
    vector.copyInto(objectSepaExportServiceData);
    return(objectSepaExportServiceData);
  }

  public static int insertHeader(ConnectionProvider connectionProvider, String sepaDataExportId, String adClientId, String adOrgId, String adUserId, String MessageId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	        insert into zsfi_sepa_export_data(zsfi_sepa_export_data_id , ad_client_id , " +
      "	                   ad_org_id, createdby, updatedby,grphdr_msgid)" +
      "                       values (?,?,?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sepaDataExportId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MessageId);

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

  public static int insertLines(ConnectionProvider connectionProvider, String sepaDataExportId, String adUserId, String cBankstatementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	        insert into zsfi_sepa_export_dataline(zsfi_sepa_export_data_id,ad_client_id,ad_org_id,createdby,updatedby,c_bankaccount_id,c_bp_bankaccount_id,amt_instdamt,pmtinf_pmtinfid,pmtinf_reqdexctndt,rmtinf_ustrd)" +
      "                   select ?, ad_client_id,ad_org_id,?,?,zssi_getOwnBankaccountFromDebtPayment(c_debt_payment_id),zssi_getPartnerBankaccountFromDebtPayment(c_debt_payment_id),abs(trxamt),c_bankstatementline_id,valutadate,substr(coalesce(memo,'-'),1,140)" +
      "                from c_bankstatementline where isactive='Y' and sepaexportenabled='Y' and voidline='N' and c_bankstatement_id=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sepaDataExportId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankstatementId);

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

  public static String doProcessing(Connection conn, ConnectionProvider connectionProvider, String sepaDataExportId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsfi_sepa_export_remittance(?) as plresult from dual;";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sepaDataExportId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "plresult");
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

  public static String attachFile(Connection conn, ConnectionProvider connectionProvider, String BankstatementId, String UserId, String ClientId, String OrgId, String Filename, String Text)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT zsse_addattachmentfile('392',?,?,?,?,?,?) as plresult from dual;";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, BankstatementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Filename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Text);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "plresult");
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
}

//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
Clase ReportNotPostedData
 */
class ReportNotPostedData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportNotPostedData.class);
  private String InitRecordNumber="0";
  public String documentno;
  public String dateacct;
  public String description;
  public String amount;
  public String doctype;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("doctype"))
      return doctype;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for relation
 */
  public static ReportNotPostedData[] select(ConnectionProvider connectionProvider, String adLanguage, String client, String dateFrom, String dateTo)    throws ServletException {
    return select(connectionProvider, adLanguage, client, dateFrom, dateTo, 0, 0);
  }

/**
Select for relation
 */
  public static ReportNotPostedData[] select(ConnectionProvider connectionProvider, String adLanguage, String client, String dateFrom, String dateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select documentno, dateacct, name as description, GRANDTOTAL  as amount, document as doctype" +
      "        from" +
      "        (select ad_client_id, documentno, dateacct, ad_column_identifier('C_Bpartner',to_char(C_bpartner_id), TO_CHAR(?)) as name, GRANDTOTAL, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=c_invoice.c_doctype_id and ad_language=to_char(?) and ad_client_id=?)), 'Sales Invoices') as document" +
      "        from c_invoice" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and issotrx = 'Y'" +
      "        and docstatus <> 'VO'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='318' and ad_client_id=?)" +
      "        union" +
      "        select ad_client_id, documentno, dateacct, ad_column_identifier('M_InOut',to_char(m_inout_id), TO_CHAR(?)) as name, 0 as GRANDTOTAL, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=m_inout.c_doctype_id and ad_language=to_char(?) and ad_client_id=?)), 'Goods Shipments') as document" +
      "        from m_inout" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and issotrx = 'Y'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='319' and ad_client_id=?)" +
      "        union" +
      "        select ad_client_id, documentno, dateacct, ad_column_identifier('M_InOut',to_char(m_inout_id), TO_CHAR(?)) as name, 0 as GRANDTOTAL, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=m_inout.c_doctype_id and ad_language=to_char(?) and ad_client_id=?)), 'Goods Receipts') as document" +
      "        from m_inout" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and issotrx = 'N'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='319' and ad_client_id=?)" +
      "        union" +
      "        select ad_client_id, documentno, dateacct, ad_column_identifier('C_Bpartner',to_char(C_bpartner_id), TO_CHAR(?)), GRANDTOTAL, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=c_invoice.c_doctype_id and ad_language=to_char(?) and ad_client_id=?)), 'Purchase Invoices') as document" +
      "        from c_invoice" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and issotrx = 'N'" +
      "        and docstatus <> 'VO'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='318' and ad_client_id=?)" +
      "        union" +
      "        select ad_client_id, name, dateacct, ad_column_identifier('C_Cash',to_char(C_Cash_id), TO_CHAR(?)), c_cash.STATEMENTDIFFERENCE, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=(select min(c_doctype_id) from c_doctype where ad_client_id=? and docbasetype='CMC') and ad_language=to_char(?) and ad_client_id=?)), 'Cash Journal') as document" +
      "        from C_Cash" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='407' and ad_client_id=?)" +
      "        union" +
      "        select ad_client_id, name, statementdate, ad_column_identifier('C_Bankstatement',to_char(C_bankstatement_id), TO_CHAR(?)), STATEMENTDIFFERENCE, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=(select min(c_doctype_id) from c_doctype where ad_client_id=? and docbasetype='CMB') and ad_language=to_char(?) and ad_client_id=?)), 'Bank Statements') as document" +
      "        from c_bankstatement" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='392' and ad_client_id=?)" +
      "        union" +
      "        select ad_client_id, documentno, dateacct, ad_column_identifier('C_Settlement',to_char(C_Settlement_id), TO_CHAR(?)), generatedamt, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=s.c_doctype_id and ad_language=to_char(?) and ad_client_id=?)), 'Manual Settlements') as document" +
      "        from c_Settlement s" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and settlementtype = 'I'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='800019' and ad_client_id=?)" +
      "        and exists (select 1" +
      "                    from c_debt_payment p" +
      "                    where p.c_settlement_generate_id = s.c_settlement_id" +
      "                    and p.isdirectposting='Y')" +
      "        union" +
      "        select ad_client_id, documentno, dateacct, ad_column_identifier('C_Settlement',to_char(C_Settlement_id), TO_CHAR(?)), generatedamt, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=c_Settlement.c_doctype_id and ad_language=to_char(?) and ad_client_id=?)), 'Settlements') as document" +
      "        from c_Settlement" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and settlementtype <> 'I'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='800019' and ad_client_id=?)" +
      "        union" +
      "        select ad_client_id, documentno, dateacct, ad_column_identifier('GL_Journal',to_char(GL_Journal_id), TO_CHAR(?)), totaldr, coalesce(to_char((select printname from c_doctype_trl where c_doctype_id=GL_Journal.c_doctype_id and ad_language=to_char(?) and ad_client_id=?)), 'GL Journal') as document" +
      "        from GL_Journal" +
      "        where processed = 'Y'" +
      "        and posted = 'N'" +
      "        and 'Y'=(select max(isactive) from c_acctschema_table where ad_table_id='224' and ad_client_id=?)) AAA" +
      "        where dateacct >= ?" +
      "        and dateacct <= ?" +
      "        and ad_client_id = ?" +
      "        order by  document, dateacct, name";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        ReportNotPostedData objectReportNotPostedData = new ReportNotPostedData();
        objectReportNotPostedData.documentno = UtilSql.getValue(result, "documentno");
        objectReportNotPostedData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportNotPostedData.description = UtilSql.getValue(result, "description");
        objectReportNotPostedData.amount = UtilSql.getValue(result, "amount");
        objectReportNotPostedData.doctype = UtilSql.getValue(result, "doctype");
        objectReportNotPostedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportNotPostedData);
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
    ReportNotPostedData objectReportNotPostedData[] = new ReportNotPostedData[vector.size()];
    vector.copyInto(objectReportNotPostedData);
    return(objectReportNotPostedData);
  }

/**
Create a registry
 */
  public static ReportNotPostedData[] set()    throws ServletException {
    ReportNotPostedData objectReportNotPostedData[] = new ReportNotPostedData[1];
    objectReportNotPostedData[0] = new ReportNotPostedData();
    objectReportNotPostedData[0].documentno = "";
    objectReportNotPostedData[0].dateacct = "";
    objectReportNotPostedData[0].description = "";
    objectReportNotPostedData[0].amount = "";
    objectReportNotPostedData[0].doctype = "";
    return objectReportNotPostedData;
  }
}

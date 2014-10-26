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

class CopyFromGLJournalData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromGLJournalData.class);
  private String InitRecordNumber="0";
  public String glJournalId;
  public String cAcctschemaId;
  public String cDoctypeId;
  public String docstatus;
  public String docaction;
  public String isapproved;
  public String isprinted;
  public String description;
  public String postingtype;
  public String glCategoryId;
  public String cPeriodId;
  public String cCurrencyId;
  public String currencyratetype;
  public String currencyrate;
  public String controlamt;
  public String line;
  public String isgenerated;
  public String amtsourcedr;
  public String amtsourcecr;
  public String amtacctdr;
  public String amtacctcr;
  public String cUomId;
  public String qty;
  public String cValidcombinationId;
  public String glJournalbatchId;
  public String documentno;
  public String isactive;
  public String datedoc;
  public String dateacct;
  public String totaldr;
  public String totalcr;
  public String processing;
  public String processed;
  public String posted;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("gl_journal_id") || fieldName.equals("glJournalId"))
      return glJournalId;
    else if (fieldName.equalsIgnoreCase("c_acctschema_id") || fieldName.equals("cAcctschemaId"))
      return cAcctschemaId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("isapproved"))
      return isapproved;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("postingtype"))
      return postingtype;
    else if (fieldName.equalsIgnoreCase("gl_category_id") || fieldName.equals("glCategoryId"))
      return glCategoryId;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("currencyratetype"))
      return currencyratetype;
    else if (fieldName.equalsIgnoreCase("currencyrate"))
      return currencyrate;
    else if (fieldName.equalsIgnoreCase("controlamt"))
      return controlamt;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("isgenerated"))
      return isgenerated;
    else if (fieldName.equalsIgnoreCase("amtsourcedr"))
      return amtsourcedr;
    else if (fieldName.equalsIgnoreCase("amtsourcecr"))
      return amtsourcecr;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("c_validcombination_id") || fieldName.equals("cValidcombinationId"))
      return cValidcombinationId;
    else if (fieldName.equalsIgnoreCase("gl_journalbatch_id") || fieldName.equals("glJournalbatchId"))
      return glJournalbatchId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("totaldr"))
      return totaldr;
    else if (fieldName.equalsIgnoreCase("totalcr"))
      return totalcr;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromGLJournalData[] select(ConnectionProvider connectionProvider, String glJournalbatchParentId, String gl_journalbatch_id)    throws ServletException {
    return select(connectionProvider, glJournalbatchParentId, gl_journalbatch_id, 0, 0);
  }

  public static CopyFromGLJournalData[] select(ConnectionProvider connectionProvider, String glJournalbatchParentId, String gl_journalbatch_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT GL.GL_JOURNAL_ID, GL.C_ACCTSCHEMA_ID, GL.C_DOCTYPE_ID, GL.DOCSTATUS, GL.DOCACTION, GL.ISAPPROVED, GL.ISPRINTED, " +
      "        GL.DESCRIPTION," +
      "        GL.POSTINGTYPE, GL.GL_CATEGORY_ID, " +
      "        (SELECT GL2.C_PERIOD_ID FROM GL_JOURNALBATCH GL2 WHERE GL2.GL_JOURNALBATCH_ID = ?) AS C_PERIOD_ID, " +
      "        GL.C_CURRENCY_ID, GL.CURRENCYRATETYPE, GL.CURRENCYRATE," +
      "        GL.CONTROLAMT, '' AS LINE, '' AS ISGENERATED, '' AS AMTSOURCEDR, '' AS AMTSOURCECR, '' AS AMTACCTDR, '' AS AMTACCTCR," +
      "        '' AS C_UOM_ID, '' AS QTY, '' AS C_VALIDCOMBINATION_ID, '' AS GL_JOURNALBATCH_ID, '' AS DOCUMENTNO, '' AS ISACTIVE," +
      "        (SELECT GL2.DATEDOC FROM GL_JOURNALBATCH GL2 WHERE GL2.GL_JOURNALBATCH_ID = ?) AS DATEDOC," +
      "        (SELECT GL2.DATEACCT FROM GL_JOURNALBATCH GL2 WHERE GL2.GL_JOURNALBATCH_ID = ?) AS DATEACCT," +
      "        '' AS TOTALDR, '' AS TOTALCR, '' AS PROCESSING, '' AS PROCESSED, '' AS POSTED" +
      "        FROM GL_JOURNAL GL" +
      "        WHERE GL.GL_JOURNALBATCH_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalbatchParentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalbatchParentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalbatchParentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journalbatch_id);

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
        CopyFromGLJournalData objectCopyFromGLJournalData = new CopyFromGLJournalData();
        objectCopyFromGLJournalData.glJournalId = UtilSql.getValue(result, "gl_journal_id");
        objectCopyFromGLJournalData.cAcctschemaId = UtilSql.getValue(result, "c_acctschema_id");
        objectCopyFromGLJournalData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCopyFromGLJournalData.docstatus = UtilSql.getValue(result, "docstatus");
        objectCopyFromGLJournalData.docaction = UtilSql.getValue(result, "docaction");
        objectCopyFromGLJournalData.isapproved = UtilSql.getValue(result, "isapproved");
        objectCopyFromGLJournalData.isprinted = UtilSql.getValue(result, "isprinted");
        objectCopyFromGLJournalData.description = UtilSql.getValue(result, "description");
        objectCopyFromGLJournalData.postingtype = UtilSql.getValue(result, "postingtype");
        objectCopyFromGLJournalData.glCategoryId = UtilSql.getValue(result, "gl_category_id");
        objectCopyFromGLJournalData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectCopyFromGLJournalData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromGLJournalData.currencyratetype = UtilSql.getValue(result, "currencyratetype");
        objectCopyFromGLJournalData.currencyrate = UtilSql.getValue(result, "currencyrate");
        objectCopyFromGLJournalData.controlamt = UtilSql.getValue(result, "controlamt");
        objectCopyFromGLJournalData.line = UtilSql.getValue(result, "line");
        objectCopyFromGLJournalData.isgenerated = UtilSql.getValue(result, "isgenerated");
        objectCopyFromGLJournalData.amtsourcedr = UtilSql.getValue(result, "amtsourcedr");
        objectCopyFromGLJournalData.amtsourcecr = UtilSql.getValue(result, "amtsourcecr");
        objectCopyFromGLJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectCopyFromGLJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectCopyFromGLJournalData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCopyFromGLJournalData.qty = UtilSql.getValue(result, "qty");
        objectCopyFromGLJournalData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectCopyFromGLJournalData.glJournalbatchId = UtilSql.getValue(result, "gl_journalbatch_id");
        objectCopyFromGLJournalData.documentno = UtilSql.getValue(result, "documentno");
        objectCopyFromGLJournalData.isactive = UtilSql.getValue(result, "isactive");
        objectCopyFromGLJournalData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectCopyFromGLJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectCopyFromGLJournalData.totaldr = UtilSql.getValue(result, "totaldr");
        objectCopyFromGLJournalData.totalcr = UtilSql.getValue(result, "totalcr");
        objectCopyFromGLJournalData.processing = UtilSql.getValue(result, "processing");
        objectCopyFromGLJournalData.processed = UtilSql.getValue(result, "processed");
        objectCopyFromGLJournalData.posted = UtilSql.getValue(result, "posted");
        objectCopyFromGLJournalData.position = Long.toString(countRecord);
        objectCopyFromGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromGLJournalData);
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
    CopyFromGLJournalData objectCopyFromGLJournalData[] = new CopyFromGLJournalData[vector.size()];
    vector.copyInto(objectCopyFromGLJournalData);
    return(objectCopyFromGLJournalData);
  }

  public static CopyFromGLJournalData[] selectLines(ConnectionProvider connectionProvider, String gl_journal_id)    throws ServletException {
    return selectLines(connectionProvider, gl_journal_id, 0, 0);
  }

  public static CopyFromGLJournalData[] selectLines(ConnectionProvider connectionProvider, String gl_journal_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT LINE, ISGENERATED, DESCRIPTION, AMTSOURCEDR, AMTSOURCECR, C_CURRENCY_ID, CURRENCYRATETYPE, CURRENCYRATE," +
      "        AMTACCTDR, AMTACCTCR, C_UOM_ID, QTY, C_VALIDCOMBINATION_ID" +
      "        FROM GL_JOURNALLINE" +
      "        WHERE GL_JOURNAL_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal_id);

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
        CopyFromGLJournalData objectCopyFromGLJournalData = new CopyFromGLJournalData();
        objectCopyFromGLJournalData.line = UtilSql.getValue(result, "line");
        objectCopyFromGLJournalData.isgenerated = UtilSql.getValue(result, "isgenerated");
        objectCopyFromGLJournalData.description = UtilSql.getValue(result, "description");
        objectCopyFromGLJournalData.amtsourcedr = UtilSql.getValue(result, "amtsourcedr");
        objectCopyFromGLJournalData.amtsourcecr = UtilSql.getValue(result, "amtsourcecr");
        objectCopyFromGLJournalData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromGLJournalData.currencyratetype = UtilSql.getValue(result, "currencyratetype");
        objectCopyFromGLJournalData.currencyrate = UtilSql.getValue(result, "currencyrate");
        objectCopyFromGLJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectCopyFromGLJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectCopyFromGLJournalData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCopyFromGLJournalData.qty = UtilSql.getValue(result, "qty");
        objectCopyFromGLJournalData.cValidcombinationId = UtilSql.getValue(result, "c_validcombination_id");
        objectCopyFromGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromGLJournalData);
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
    CopyFromGLJournalData objectCopyFromGLJournalData[] = new CopyFromGLJournalData[vector.size()];
    vector.copyInto(objectCopyFromGLJournalData);
    return(objectCopyFromGLJournalData);
  }

  public static CopyFromGLJournalData[] selectFrom(ConnectionProvider connectionProvider, String description, String documentNo, String adUserClient, String adOrgClient)    throws ServletException {
    return selectFrom(connectionProvider, description, documentNo, adUserClient, adOrgClient, 0, 0);
  }

  public static CopyFromGLJournalData[] selectFrom(ConnectionProvider connectionProvider, String description, String documentNo, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT G.GL_JOURNALBATCH_ID, G.DOCUMENTNO, G.DESCRIPTION, G.ISACTIVE,(SELECT L.NAME " +
      "                                                                        FROM AD_REF_LIST L " +
      "                                                                        WHERE L.AD_REFERENCE_ID='125' " +
      "                                                                        AND L.VALUE=G.POSTINGTYPE) AS POSTINGTYPE, " +
      "        G.DATEDOC, G.DATEACCT, G.CONTROLAMT, G.TOTALDR, G.TOTALCR " +
      "        FROM GL_JOURNALBATCH G" +
      "        WHERE G.ISACTIVE='Y' " +
      "        AND ISTEMPLATE='Y' " +
      "        AND 1=1";
    strSql = strSql + ((description==null || description.equals(""))?"":"  AND UPPER(COALESCE(TO_CHAR(G.DESCRIPTION),' ')) LIKE UPPER(?)  ");
    strSql = strSql + ((documentNo==null || documentNo.equals("") || documentNo.equals("%") )?"":"  AND UPPER(G.DOCUMENTNO) LIKE UPPER(?)  ");
    strSql = strSql + 
      "        AND G.AD_CLIENT_ID IN('";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      "') " +
      "        AND G.AD_ORG_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") " +
      "        AND EXISTS (SELECT 1 FROM GL_JOURNAL WHERE GL_JOURNALBATCH_ID = G.GL_JOURNALBATCH_ID)" +
      "        ORDER BY 2";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (description != null && !(description.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      }
      if (documentNo != null && !(documentNo.equals("")) && !(documentNo.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      }
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
        CopyFromGLJournalData objectCopyFromGLJournalData = new CopyFromGLJournalData();
        objectCopyFromGLJournalData.glJournalbatchId = UtilSql.getValue(result, "gl_journalbatch_id");
        objectCopyFromGLJournalData.documentno = UtilSql.getValue(result, "documentno");
        objectCopyFromGLJournalData.description = UtilSql.getValue(result, "description");
        objectCopyFromGLJournalData.isactive = UtilSql.getValue(result, "isactive");
        objectCopyFromGLJournalData.postingtype = UtilSql.getValue(result, "postingtype");
        objectCopyFromGLJournalData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectCopyFromGLJournalData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectCopyFromGLJournalData.controlamt = UtilSql.getValue(result, "controlamt");
        objectCopyFromGLJournalData.totaldr = UtilSql.getValue(result, "totaldr");
        objectCopyFromGLJournalData.totalcr = UtilSql.getValue(result, "totalcr");
        objectCopyFromGLJournalData.position = Long.toString(countRecord);
        objectCopyFromGLJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromGLJournalData);
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
    CopyFromGLJournalData objectCopyFromGLJournalData[] = new CopyFromGLJournalData[vector.size()];
    vector.copyInto(objectCopyFromGLJournalData);
    return(objectCopyFromGLJournalData);
  }

  public static int insertGLJournal(Connection conn, ConnectionProvider connectionProvider, String gl_journal_id, String ad_client_id, String ad_org_id, String user, String c_acctschema_id, String c_doctype_id, String docstatus, String docaction, String isapproved, String isprinted, String description, String postingtype, String gl_category_id, String datedoc, String dateacct, String c_period_id, String c_currency_id, String currencyratetype, String currencyrate, String gl_journalbatch_id, String controlamt, String documentNo, String processing, String processed, String posted)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO GL_JOURNAL (GL_JOURNAL_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, C_ACCTSCHEMA_ID,C_DOCTYPE_ID, DOCSTATUS,DOCACTION, ISAPPROVED, ISPRINTED, " +
      "        DESCRIPTION, POSTINGTYPE, GL_CATEGORY_ID, DATEDOC, DATEACCT,C_PERIOD_ID, C_CURRENCY_ID, " +
      "        CURRENCYRATETYPE,CURRENCYRATE, GL_JOURNALBATCH_ID, CONTROLAMT, DOCUMENTNO, PROCESSING, PROCESSED, POSTED) " +
      "        VALUES (?,?,?,now(),?," +
      "        	now(),?,?,?,?,?,?,?," +
      "        	?,?,?,TO_DATE(?),TO_DATE(?),?,?," +
      "        	?,TO_NUMBER(?),?,TO_NUMBER(?),?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_acctschema_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_doctype_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isapproved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postingtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_category_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedoc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_currency_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyratetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journalbatch_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, controlamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);

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

  public static int insertGLJournalLine(Connection conn, ConnectionProvider connectionProvider, String gl_journalline_id, String ad_client_id, String ad_org_id, String user, String gl_journal_id, String line, String isgenerated, String description, String amtsourcedr, String amtsourcecr, String c_currency_id, String currencyratetype, String currencyrate, String amtacctdr, String amtacctcr, String c_uom_id, String qty, String c_validcombination_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO GL_JOURNALLINE (GL_JOURNALLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, " +
      "        UPDATED, UPDATEDBY, GL_JOURNAL_ID,LINE, ISGENERATED, DESCRIPTION,AMTSOURCEDR, AMTSOURCECR, C_CURRENCY_ID, " +
      "        CURRENCYRATETYPE, CURRENCYRATE, DATEACCT,AMTACCTDR, AMTACCTCR, C_UOM_ID,QTY, C_VALIDCOMBINATION_ID) " +
      "        VALUES (?,?,?,now(),?,now(),?,?,TO_NUMBER(?),?,?,TO_NUMBER(?),TO_NUMBER(?),?,?,TO_NUMBER(?),now(),TO_NUMBER(?),TO_NUMBER(?),?,TO_NUMBER(?),?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journalline_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgenerated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcedr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcecr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_currency_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyratetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_uom_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_validcombination_id);

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

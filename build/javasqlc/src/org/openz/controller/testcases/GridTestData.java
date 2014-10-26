//Sqlc generated V1.O00-1
package org.openz.controller.testcases;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class GridTestData implements FieldProvider {
static Logger log4j = Logger.getLogger(GridTestData.class);
  private String InitRecordNumber="0";
  public String linkname;
  public String cOrderId;
  public String cdoctypename;
  public String documentno;
  public String cbpartnername;
  public String dateordered;
  public String datepromised;
  public String amountlines;
  public String notinvoicedlines;
  public String termname;
  public String termvalue;
  public String pendinglines;
  public String mProductId;
  public String salesrepId;
  public String cBpartnerId;
  public String product;
  public String positionline;
  public String qtydelivered;
  public String qtyordered;
  public String orderlineid;
  public String qtydiffpending;
  public String mInoutlineId;
  public String lineprice;
  public String pricenet;
  public String priceactual;
  public String pendingamt;
  public String oldescription;
  public String project;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("linkname"))
      return linkname;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("cdoctypename"))
      return cdoctypename;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("cbpartnername"))
      return cbpartnername;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("amountlines"))
      return amountlines;
    else if (fieldName.equalsIgnoreCase("notinvoicedlines"))
      return notinvoicedlines;
    else if (fieldName.equalsIgnoreCase("termname"))
      return termname;
    else if (fieldName.equalsIgnoreCase("termvalue"))
      return termvalue;
    else if (fieldName.equalsIgnoreCase("pendinglines"))
      return pendinglines;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("positionline"))
      return positionline;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("orderlineid"))
      return orderlineid;
    else if (fieldName.equalsIgnoreCase("qtydiffpending"))
      return qtydiffpending;
    else if (fieldName.equalsIgnoreCase("m_inoutline_id") || fieldName.equals("mInoutlineId"))
      return mInoutlineId;
    else if (fieldName.equalsIgnoreCase("lineprice"))
      return lineprice;
    else if (fieldName.equalsIgnoreCase("pricenet"))
      return pricenet;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("pendingamt"))
      return pendingamt;
    else if (fieldName.equalsIgnoreCase("oldescription"))
      return oldescription;
    else if (fieldName.equalsIgnoreCase("project"))
      return project;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GridTestData[] select(ConnectionProvider connectionProvider, String language, String issotrx)    throws ServletException {
    return select(connectionProvider, language, issotrx, 0, 0);
  }

  public static GridTestData[] select(ConnectionProvider connectionProvider, String language, String issotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT CASE ic.issotrx WHEN 'Y' THEN 'SalesOrder' WHEN 'N' THEN 'PurchaseOrder' END AS linkname, ic.C_Order_ID,  ad_get_doctypename(ic.C_DocType_ID,?) as cdoctypename, ic.DocumentNo, bp.Name as cbpartnername, ic.DateOrdered,ic.datepromised," +
      "      icl.amountlines, ic.notinvoicedlines, l.Name as TermName, l.Value as TermValue, ic.pendinglines as pendinglines,icl.m_product_id ,bp.salesrep_id,bp.C_BPartner_ID," +
      "      zssi_limitlength55(coalesce((select m_product_po.vendorproductno from m_product_po, c_orderline,c_order where m_product_po.m_product_id=icl.m_product_id and icl.c_orderline_id=c_orderline.c_orderline_id and c_order.c_order_id=c_orderline.c_order_id and c_order.c_bpartner_id=m_product_po.c_bpartner_id AND m_product_po.vendorproductno is not null),' ')||' - '||AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(icl.m_product_id), ?)) as product, icl.line as positionline," +
      "      icl.qtydelivered,icl.qtyordered,icl.c_orderline_id as orderlineid, icl.pendingqty as qtydiffpending, icl.m_inoutline_id," +
      "      icl.lineprice, icl.pendingprice as pricenet, icl.priceactual as priceactual, icl.pendingamt, icl.description as oldescription," +
      "      zssi_getprojectorcostcentername(icl.c_project_id,icl.a_asset_id) as PROJECT " +
      "      FROM C_Invoice_Candidate_v ic, c_invoice_candidate_lines_v icl, C_BPartner bp, AD_Ref_List l left join AD_Ref_List_trl ltrl on l.AD_Ref_List_ID=ltrl.AD_Ref_List_ID and ltrl.ad_language=?" +
      "      WHERE  icl.c_order_id=ic.c_order_id" +
      "      AND ic.C_BPartner_ID=bp.C_BPartner_ID" +
      "      AND l.value = ic.term" +
      "      AND ic.term <> 'N'" +
      "      AND AD_Reference_ID='150'" +
      "      AND ic.issotrx = ?" +
      "      AND coalesce(icl.m_inout_doctype_id,'') not in ('2317023F9771481696461C5EAF9A0915','2E1E735AA91A49F8BC7181D31B09B370') " +
      "      AND 1=1" +
      "      ORDER BY bp.Name,DatePromised,DateOrdered, DocumentNo, positionline";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);

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
        GridTestData objectGridTestData = new GridTestData();
        objectGridTestData.linkname = UtilSql.getValue(result, "linkname");
        objectGridTestData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectGridTestData.cdoctypename = UtilSql.getValue(result, "cdoctypename");
        objectGridTestData.documentno = UtilSql.getValue(result, "documentno");
        objectGridTestData.cbpartnername = UtilSql.getValue(result, "cbpartnername");
        objectGridTestData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectGridTestData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectGridTestData.amountlines = UtilSql.getValue(result, "amountlines");
        objectGridTestData.notinvoicedlines = UtilSql.getValue(result, "notinvoicedlines");
        objectGridTestData.termname = UtilSql.getValue(result, "termname");
        objectGridTestData.termvalue = UtilSql.getValue(result, "termvalue");
        objectGridTestData.pendinglines = UtilSql.getValue(result, "pendinglines");
        objectGridTestData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectGridTestData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectGridTestData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectGridTestData.product = UtilSql.getValue(result, "product");
        objectGridTestData.positionline = UtilSql.getValue(result, "positionline");
        objectGridTestData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectGridTestData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectGridTestData.orderlineid = UtilSql.getValue(result, "orderlineid");
        objectGridTestData.qtydiffpending = UtilSql.getValue(result, "qtydiffpending");
        objectGridTestData.mInoutlineId = UtilSql.getValue(result, "m_inoutline_id");
        objectGridTestData.lineprice = UtilSql.getValue(result, "lineprice");
        objectGridTestData.pricenet = UtilSql.getValue(result, "pricenet");
        objectGridTestData.priceactual = UtilSql.getValue(result, "priceactual");
        objectGridTestData.pendingamt = UtilSql.getValue(result, "pendingamt");
        objectGridTestData.oldescription = UtilSql.getValue(result, "oldescription");
        objectGridTestData.project = UtilSql.getValue(result, "project");
        objectGridTestData.rownum = Long.toString(countRecord);
        objectGridTestData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGridTestData);
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
    GridTestData objectGridTestData[] = new GridTestData[vector.size()];
    vector.copyInto(objectGridTestData);
    return(objectGridTestData);
  }

  public static GridTestData[] set()    throws ServletException {
    GridTestData objectGridTestData[] = new GridTestData[1];
    objectGridTestData[0] = new GridTestData();
    objectGridTestData[0].linkname = "";
    objectGridTestData[0].cOrderId = "";
    objectGridTestData[0].cdoctypename = "";
    objectGridTestData[0].documentno = "";
    objectGridTestData[0].cbpartnername = "";
    objectGridTestData[0].dateordered = "";
    objectGridTestData[0].datepromised = "";
    objectGridTestData[0].amountlines = "";
    objectGridTestData[0].notinvoicedlines = "";
    objectGridTestData[0].termname = "";
    objectGridTestData[0].termvalue = "";
    objectGridTestData[0].pendinglines = "";
    objectGridTestData[0].mProductId = "";
    objectGridTestData[0].salesrepId = "";
    objectGridTestData[0].cBpartnerId = "";
    objectGridTestData[0].product = "";
    objectGridTestData[0].positionline = "";
    objectGridTestData[0].qtydelivered = "";
    objectGridTestData[0].qtyordered = "";
    objectGridTestData[0].orderlineid = "";
    objectGridTestData[0].qtydiffpending = "";
    objectGridTestData[0].mInoutlineId = "";
    objectGridTestData[0].lineprice = "";
    objectGridTestData[0].pricenet = "";
    objectGridTestData[0].priceactual = "";
    objectGridTestData[0].pendingamt = "";
    objectGridTestData[0].oldescription = "";
    objectGridTestData[0].project = "";
    return objectGridTestData;
  }

  public static int initUpdate(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected = 'N'" +
      "      WHERE IsSelected='Y'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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

  public static int updateSelection(ConnectionProvider connectionProvider, String parcOrdersId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected='Y' " +
      "      WHERE 1=1";
    strSql = strSql + ((parcOrdersId==null || parcOrdersId.equals(""))?"":" AND C_Order_ID IN" + parcOrdersId);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (parcOrdersId != null && !(parcOrdersId.equals(""))) {
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

  public static int resetSelection(ConnectionProvider connectionProvider, String parcOrdersId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected='N' " +
      "      WHERE 1=1";
    strSql = strSql + ((parcOrdersId==null || parcOrdersId.equals(""))?"":" AND C_Order_ID IN" + parcOrdersId);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (parcOrdersId != null && !(parcOrdersId.equals(""))) {
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

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM C_BPARTNER " +
      "    WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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

  public static GridTestData[] selectOrderlines(ConnectionProvider connectionProvider, String corderId)    throws ServletException {
    return selectOrderlines(connectionProvider, corderId, 0, 0);
  }

  public static GridTestData[] selectOrderlines(ConnectionProvider connectionProvider, String corderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ORDERLINE_ID as orderlineid from c_orderline" +
      "        WHERE c_order_id = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, corderId);

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
        GridTestData objectGridTestData = new GridTestData();
        objectGridTestData.orderlineid = UtilSql.getValue(result, "orderlineid");
        objectGridTestData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGridTestData);
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
    GridTestData objectGridTestData[] = new GridTestData[vector.size()];
    vector.copyInto(objectGridTestData);
    return(objectGridTestData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String cGenerateinvoicemanualId, String cOrderlineId, String cOrderId, String adClientId, String adOrgId, String createdby, String updatedby, String qty, String price, String lineamt, String ignoreresidue, String description, String mInoutlineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_GENERATEINVOICEMANUAL(C_GENERATEINVOICEMANUAL_ID, C_ORDERLINE_ID, C_ORDER_ID, AD_CLIENT_ID, AD_ORG_ID,  CREATEDBY, UPDATEDBY, QTY, PRICE, LINEAMT,IGNORERESIDUE, DESCRIPTION, M_InOutLine_ID)" +
      "      VALUES(?, ?, ?, ?, ?, ?, ?, TO_NUMBER(?), TO_NUMBER(?),TO_NUMBER(?), ?, ?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGenerateinvoicemanualId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lineamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ignoreresidue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutlineId);

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

  public static int deleteerror(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM C_GENERATEINVOICEMANUAL where c_invoiceline_id is null";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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

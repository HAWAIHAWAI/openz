//Sqlc generated V1.O00-1
package org.openbravo.erpReports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class RptCBpartnerCustomerData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCBpartnerCustomerData.class);
  private String InitRecordNumber="0";
  public String invoicerule;
  public String invoiceschedule;
  public String paymentrule;
  public String salesrep;
  public String pricelist;
  public String account;
  public String paymenttermname;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("invoiceschedule"))
      return invoiceschedule;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("salesrep"))
      return salesrep;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("account"))
      return account;
    else if (fieldName.equalsIgnoreCase("paymenttermname"))
      return paymenttermname;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCBpartnerCustomerData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, adLanguage, cBpartnerId, 0, 0);
  }

  public static RptCBpartnerCustomerData[] select(ConnectionProvider connectionProvider, String adLanguage, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT IR.NAME AS INVOICERULE, I.NAME AS INVOICESCHEDULE, PR.NAME AS PAYMENTRULE, BP1.NAME AS SALESREP," +
      "        P.NAME AS PRICELIST, C_ELEMENTVALUE.VALUE||' - '||C_ELEMENTVALUE.NAME AS ACCOUNT, PT.NAME AS PAYMENTTERMNAME" +
      "        FROM C_BPARTNER BP left join (SELECT VALUE, NAME from AD_REF_LIST_V WHERE AD_REFERENCE_ID='150' AND AD_LANGUAGE= ?) IR on BP.INVOICERULE = IR.VALUE" +
      "                           left join C_INVOICESCHEDULE I on BP.C_INVOICESCHEDULE_ID = I.C_INVOICESCHEDULE_ID" +
      "                           left join (SELECT VALUE, NAME from AD_REF_LIST_V WHERE AD_REFERENCE_ID='195' AND AD_LANGUAGE= ?) PR on BP.PAYMENTRULE = PR.VALUE" +
      "                           left join C_PAYMENTTERM PT on  BP.C_PAYMENTTERM_ID = PT.C_PAYMENTTERM_ID" +
      "                           left join C_BPARTNER BP1 on BP.SALESREP_ID = BP1.C_BPARTNER_ID" +
      "                           left join M_PRICELIST P on BP.M_PRICELIST_ID = P.M_PRICELIST_ID" +
      "                           left join C_BP_CUSTOMER_ACCT on BP.C_BPARTNER_ID = C_BP_CUSTOMER_ACCT.C_BPARTNER_ID" +
      "                           left join C_VALIDCOMBINATION on C_BP_CUSTOMER_ACCT.C_RECEIVABLE_ACCT = C_VALIDCOMBINATION.C_VALIDCOMBINATION_ID" +
      "                           left join C_ELEMENTVALUE on C_VALIDCOMBINATION.ACCOUNT_ID = C_ELEMENTVALUE.C_ELEMENTVALUE_ID " +
      "        WHERE BP.ISCUSTOMER = 'Y'";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"           AND BP.C_BPARTNER_ID IN          " + cBpartnerId);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
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
        RptCBpartnerCustomerData objectRptCBpartnerCustomerData = new RptCBpartnerCustomerData();
        objectRptCBpartnerCustomerData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectRptCBpartnerCustomerData.invoiceschedule = UtilSql.getValue(result, "invoiceschedule");
        objectRptCBpartnerCustomerData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectRptCBpartnerCustomerData.salesrep = UtilSql.getValue(result, "salesrep");
        objectRptCBpartnerCustomerData.pricelist = UtilSql.getValue(result, "pricelist");
        objectRptCBpartnerCustomerData.account = UtilSql.getValue(result, "account");
        objectRptCBpartnerCustomerData.paymenttermname = UtilSql.getValue(result, "paymenttermname");
        objectRptCBpartnerCustomerData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCBpartnerCustomerData);
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
    RptCBpartnerCustomerData objectRptCBpartnerCustomerData[] = new RptCBpartnerCustomerData[vector.size()];
    vector.copyInto(objectRptCBpartnerCustomerData);
    return(objectRptCBpartnerCustomerData);
  }

  public static RptCBpartnerCustomerData[] set()    throws ServletException {
    RptCBpartnerCustomerData objectRptCBpartnerCustomerData[] = new RptCBpartnerCustomerData[1];
    objectRptCBpartnerCustomerData[0] = new RptCBpartnerCustomerData();
    objectRptCBpartnerCustomerData[0].invoicerule = "";
    objectRptCBpartnerCustomerData[0].invoiceschedule = "";
    objectRptCBpartnerCustomerData[0].paymentrule = "";
    objectRptCBpartnerCustomerData[0].salesrep = "";
    objectRptCBpartnerCustomerData[0].pricelist = "";
    objectRptCBpartnerCustomerData[0].account = "";
    objectRptCBpartnerCustomerData[0].paymenttermname = "";
    return objectRptCBpartnerCustomerData;
  }
}

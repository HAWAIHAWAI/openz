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

class PaymentMonitorProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(PaymentMonitorProcessData.class);
  private String InitRecordNumber="0";
  public String invoice;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("invoice"))
      return invoice;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PaymentMonitorProcessData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static PaymentMonitorProcessData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select distinct(c_invoice_id) as invoice from c_debt_payment cdp where exists" +
      "                (select 0 from c_invoice ci where " +
      "                               ci.ad_client_id in (select ad_client_id from ad_client where isactive='Y') and" +
      "                               ci.ispaid='N' and ci.processed='Y' and " +
      "                               ci.c_invoice_id=cdp.c_invoice_id);";

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
        PaymentMonitorProcessData objectPaymentMonitorProcessData = new PaymentMonitorProcessData();
        objectPaymentMonitorProcessData.invoice = UtilSql.getValue(result, "invoice");
        objectPaymentMonitorProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPaymentMonitorProcessData);
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
    PaymentMonitorProcessData objectPaymentMonitorProcessData[] = new PaymentMonitorProcessData[vector.size()];
    vector.copyInto(objectPaymentMonitorProcessData);
    return(objectPaymentMonitorProcessData);
  }
}

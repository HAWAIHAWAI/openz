//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class TaxRegisterTypeLines implements FieldProvider {
static Logger log4j = Logger.getLogger(TaxRegisterTypeLines.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String cTaxregisterTypeId;
  public String registername;
  public String adSequenceId;
  public String cGlitemId;
  public String issotrx;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_taxregister_type_id") || fieldName.equals("cTaxregisterTypeId"))
      return cTaxregisterTypeId;
    else if (fieldName.equalsIgnoreCase("registername"))
      return registername;
    else if (fieldName.equalsIgnoreCase("ad_sequence_id") || fieldName.equals("adSequenceId"))
      return adSequenceId;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
All Tax Register Type Lines of one Tax Register Type 
 */
  public static TaxRegisterTypeLines[] select(ConnectionProvider connectionProvider, String taxregister_type_id)    throws ServletException {
    return select(connectionProvider, taxregister_type_id, 0, 0);
  }

/**
All Tax Register Type Lines of one Tax Register Type 
 */
  public static TaxRegisterTypeLines[] select(ConnectionProvider connectionProvider, String taxregister_type_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Client_ID, AD_Org_ID, C_TaxRegister_Type_ID, RegisterName, Ad_Sequence_ID, C_GLitem_ID, IsSoTrx" +
      "			FROM C_TAXREGISTER_TYPE" +
      "			WHERE ISACTIVE='Y' " +
      "			And C_TaxRegister_Type_ID = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxregister_type_id);

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
        TaxRegisterTypeLines objectTaxRegisterTypeLines = new TaxRegisterTypeLines();
        objectTaxRegisterTypeLines.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTaxRegisterTypeLines.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTaxRegisterTypeLines.cTaxregisterTypeId = UtilSql.getValue(result, "c_taxregister_type_id");
        objectTaxRegisterTypeLines.registername = UtilSql.getValue(result, "registername");
        objectTaxRegisterTypeLines.adSequenceId = UtilSql.getValue(result, "ad_sequence_id");
        objectTaxRegisterTypeLines.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectTaxRegisterTypeLines.issotrx = UtilSql.getValue(result, "issotrx");
        objectTaxRegisterTypeLines.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTaxRegisterTypeLines);
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
    TaxRegisterTypeLines objectTaxRegisterTypeLines[] = new TaxRegisterTypeLines[vector.size()];
    vector.copyInto(objectTaxRegisterTypeLines);
    return(objectTaxRegisterTypeLines);
  }
}

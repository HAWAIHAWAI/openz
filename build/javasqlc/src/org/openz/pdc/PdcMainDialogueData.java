//Sqlc generated V1.O00-1
package org.openz.pdc;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class PdcMainDialogueData implements FieldProvider {
static Logger log4j = Logger.getLogger(PdcMainDialogueData.class);
  private String InitRecordNumber="0";
  public String language;
  public String zssmWorkstepbomVId;
  public String product;
  public String qtyPlan;
  public String quantity;
  public String qtyreceived;
  public String qtyAvailable;
  public String issuingLocator;
  public String barcode;
  public String type;
  public String id;
  public String mess;
  public String adMessageValue;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equalsIgnoreCase("zssm_workstepbom_v_id") || fieldName.equals("zssmWorkstepbomVId"))
      return zssmWorkstepbomVId;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("qty_plan") || fieldName.equals("qtyPlan"))
      return qtyPlan;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("qtyreceived"))
      return qtyreceived;
    else if (fieldName.equalsIgnoreCase("qty_available") || fieldName.equals("qtyAvailable"))
      return qtyAvailable;
    else if (fieldName.equalsIgnoreCase("issuing_locator") || fieldName.equals("issuingLocator"))
      return issuingLocator;
    else if (fieldName.equalsIgnoreCase("barcode"))
      return barcode;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("mess"))
      return mess;
    else if (fieldName.equalsIgnoreCase("ad_message_value") || fieldName.equals("adMessageValue"))
      return adMessageValue;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PdcMainDialogueData[] selectupper(ConnectionProvider connectionProvider, String language)    throws ServletException {
    return selectupper(connectionProvider, language, 0, 0);
  }

  public static PdcMainDialogueData[] selectupper(ConnectionProvider connectionProvider, String language, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    Select ? as language , '' as zssm_workstepbom_v_id, '' as product, '' as qty_plan, '' as quantity, '' as qtyreceived, '' as qty_available, '' as issuing_locator, '' as barcode, '' as type, '' as id, '' as mess, '' as ad_message_value from dual";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

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
        PdcMainDialogueData objectPdcMainDialogueData = new PdcMainDialogueData();
        objectPdcMainDialogueData.language = UtilSql.getValue(result, "language");
        objectPdcMainDialogueData.zssmWorkstepbomVId = UtilSql.getValue(result, "zssm_workstepbom_v_id");
        objectPdcMainDialogueData.product = UtilSql.getValue(result, "product");
        objectPdcMainDialogueData.qtyPlan = UtilSql.getValue(result, "qty_plan");
        objectPdcMainDialogueData.quantity = UtilSql.getValue(result, "quantity");
        objectPdcMainDialogueData.qtyreceived = UtilSql.getValue(result, "qtyreceived");
        objectPdcMainDialogueData.qtyAvailable = UtilSql.getValue(result, "qty_available");
        objectPdcMainDialogueData.issuingLocator = UtilSql.getValue(result, "issuing_locator");
        objectPdcMainDialogueData.barcode = UtilSql.getValue(result, "barcode");
        objectPdcMainDialogueData.type = UtilSql.getValue(result, "type");
        objectPdcMainDialogueData.id = UtilSql.getValue(result, "id");
        objectPdcMainDialogueData.mess = UtilSql.getValue(result, "mess");
        objectPdcMainDialogueData.adMessageValue = UtilSql.getValue(result, "ad_message_value");
        objectPdcMainDialogueData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPdcMainDialogueData);
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
    PdcMainDialogueData objectPdcMainDialogueData[] = new PdcMainDialogueData[vector.size()];
    vector.copyInto(objectPdcMainDialogueData);
    return(objectPdcMainDialogueData);
  }

  public static PdcMainDialogueData[] selectbarcode(ConnectionProvider connectionProvider, String barcode)    throws ServletException {
    return selectbarcode(connectionProvider, barcode, 0, 0);
  }

  public static PdcMainDialogueData[] selectbarcode(ConnectionProvider connectionProvider, String barcode, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select type,id, mess,ad_message_value from  pdc_getDataIdFromScan(?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, barcode);

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
        PdcMainDialogueData objectPdcMainDialogueData = new PdcMainDialogueData();
        objectPdcMainDialogueData.type = UtilSql.getValue(result, "type");
        objectPdcMainDialogueData.id = UtilSql.getValue(result, "id");
        objectPdcMainDialogueData.mess = UtilSql.getValue(result, "mess");
        objectPdcMainDialogueData.adMessageValue = UtilSql.getValue(result, "ad_message_value");
        objectPdcMainDialogueData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPdcMainDialogueData);
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
    PdcMainDialogueData objectPdcMainDialogueData[] = new PdcMainDialogueData[vector.size()];
    vector.copyInto(objectPdcMainDialogueData);
    return(objectPdcMainDialogueData);
  }
}

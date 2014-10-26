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

class OrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrderData.class);
  private String InitRecordNumber="0";
  public String iOrderId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String dateordered;
  public String cOrderlineId;
  public String iIsimported;
  public String issotrx;
  public String processed;
  public String doctypename;
  public String cOrderId;
  public String description;
  public String adUserId;
  public String bpartnervalue;
  public String productvalue;
  public String qtyordered;
  public String linedescription;
  public String orderReferenceno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("i_order_id") || fieldName.equals("iOrderId"))
      return iOrderId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("i_isimported") || fieldName.equals("iIsimported"))
      return iIsimported;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("doctypename"))
      return doctypename;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("bpartnervalue"))
      return bpartnervalue;
    else if (fieldName.equalsIgnoreCase("productvalue"))
      return productvalue;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("linedescription"))
      return linedescription;
    else if (fieldName.equalsIgnoreCase("order_referenceno") || fieldName.equals("orderReferenceno"))
      return orderReferenceno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static OrderData[] select(ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    return select(connectionProvider, ad_client_id, 0, 0);
  }

  public static OrderData[] select(ConnectionProvider connectionProvider, String ad_client_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT I_Order_ID, AD_Client_ID, AD_Org_ID, isActive, Created, CreatedBy, Updated, UpdatedBy," +
      "				DateOrdered, C_OrderLine_ID, I_IsImported, IsSOtrx, Processed, DocTypeName, C_Order_ID," +
      "				Description, AD_User_ID, BPartnerValue, ProductValue, QtyOrdered, LineDescription," +
      "				Order_ReferenceNo" +
      "				FROM I_Order" +
      "				WHERE AD_Client_ID = ?";

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
        OrderData objectOrderData = new OrderData();
        objectOrderData.iOrderId = UtilSql.getValue(result, "i_order_id");
        objectOrderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOrderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOrderData.isactive = UtilSql.getValue(result, "isactive");
        objectOrderData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectOrderData.createdby = UtilSql.getValue(result, "createdby");
        objectOrderData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectOrderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOrderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectOrderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectOrderData.iIsimported = UtilSql.getValue(result, "i_isimported");
        objectOrderData.issotrx = UtilSql.getValue(result, "issotrx");
        objectOrderData.processed = UtilSql.getValue(result, "processed");
        objectOrderData.doctypename = UtilSql.getValue(result, "doctypename");
        objectOrderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectOrderData.description = UtilSql.getValue(result, "description");
        objectOrderData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectOrderData.bpartnervalue = UtilSql.getValue(result, "bpartnervalue");
        objectOrderData.productvalue = UtilSql.getValue(result, "productvalue");
        objectOrderData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectOrderData.linedescription = UtilSql.getValue(result, "linedescription");
        objectOrderData.orderReferenceno = UtilSql.getValue(result, "order_referenceno");
        objectOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderData);
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
    OrderData objectOrderData[] = new OrderData[vector.size()];
    vector.copyInto(objectOrderData);
    return(objectOrderData);
  }

  public int insert(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			  INSERT INTO I_Order (I_Order_ID, AD_Client_ID, AD_Org_ID, isActive, Created, CreatedBy, Updated, UpdatedBy," +
      "				DateOrdered, C_OrderLine_ID, I_IsImported, IsSOtrx, Processed, DocTypeName, C_Order_ID, Description," +
      "				BPartnerValue, ProductValue, " +
      "        QtyOrdered, LineDescription, Order_ReferenceNo)" +
      "				VALUES (?, ?, ?, 'Y', now(), ?, now(), ?, TO_DATE(?,'YY-MM-DD'), ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
      "                TO_NUMBER(?), ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypename);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linedescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderReferenceno);

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

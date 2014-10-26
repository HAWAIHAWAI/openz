//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Product;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class PurchasingData implements FieldProvider {
static Logger log4j = Logger.getLogger(PurchasingData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String royaltyamt;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String mProductId;
  public String mProductIdr;
  public String capacity;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String qualityrating;
  public String isactive;
  public String iscurrentvendor;
  public String upc;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String pricelist;
  public String pricepo;
  public String pricelastpo;
  public String pricelastinv;
  public String deliverytimePromised;
  public String vendorproductno;
  public String vendorcategory;
  public String manufacturer;
  public String discontinued;
  public String discontinuedby;
  public String qtystd;
  public String orderMin;
  public String ismultipleofminimumqty;
  public String priceeffective;
  public String cUomId;
  public String orderPack;
  public String costperorder;
  public String deliverytimeActual;
  public String mProductPoId;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("royaltyamt"))
      return royaltyamt;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("capacity"))
      return capacity;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("qualityrating"))
      return qualityrating;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("iscurrentvendor"))
      return iscurrentvendor;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricepo"))
      return pricepo;
    else if (fieldName.equalsIgnoreCase("pricelastpo"))
      return pricelastpo;
    else if (fieldName.equalsIgnoreCase("pricelastinv"))
      return pricelastinv;
    else if (fieldName.equalsIgnoreCase("deliverytime_promised") || fieldName.equals("deliverytimePromised"))
      return deliverytimePromised;
    else if (fieldName.equalsIgnoreCase("vendorproductno"))
      return vendorproductno;
    else if (fieldName.equalsIgnoreCase("vendorcategory"))
      return vendorcategory;
    else if (fieldName.equalsIgnoreCase("manufacturer"))
      return manufacturer;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("discontinuedby"))
      return discontinuedby;
    else if (fieldName.equalsIgnoreCase("qtystd"))
      return qtystd;
    else if (fieldName.equalsIgnoreCase("order_min") || fieldName.equals("orderMin"))
      return orderMin;
    else if (fieldName.equalsIgnoreCase("ismultipleofminimumqty"))
      return ismultipleofminimumqty;
    else if (fieldName.equalsIgnoreCase("priceeffective"))
      return priceeffective;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("order_pack") || fieldName.equals("orderPack"))
      return orderPack;
    else if (fieldName.equalsIgnoreCase("costperorder"))
      return costperorder;
    else if (fieldName.equalsIgnoreCase("deliverytime_actual") || fieldName.equals("deliverytimeActual"))
      return deliverytimeActual;
    else if (fieldName.equalsIgnoreCase("m_product_po_id") || fieldName.equals("mProductPoId"))
      return mProductPoId;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static PurchasingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mProductId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mProductId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PurchasingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mProductId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Product_PO.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product_PO.CreatedBy) as CreatedByR, " +
      "        to_char(M_Product_PO.Updated, ?) as updated, " +
      "        to_char(M_Product_PO.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Product_PO.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product_PO.UpdatedBy) as UpdatedByR," +
      "        M_Product_PO.RoyaltyAmt, " +
      "M_Product_PO.AD_Client_ID, " +
      "(CASE WHEN M_Product_PO.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_Product_PO.AD_Org_ID, " +
      "(CASE WHEN M_Product_PO.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Product_PO.M_Product_ID, " +
      "(CASE WHEN M_Product_PO.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "M_Product_PO.Capacity, " +
      "M_Product_PO.C_BPartner_ID, " +
      "(CASE WHEN M_Product_PO.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "M_Product_PO.QualityRating, " +
      "COALESCE(M_Product_PO.IsActive, 'N') AS IsActive, " +
      "COALESCE(M_Product_PO.IsCurrentVendor, 'N') AS IsCurrentVendor, " +
      "M_Product_PO.UPC, " +
      "M_Product_PO.C_Currency_ID, " +
      "(CASE WHEN M_Product_PO.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "M_Product_PO.PriceList, " +
      "M_Product_PO.PricePO, " +
      "M_Product_PO.PriceLastPO, " +
      "M_Product_PO.PriceLastInv, " +
      "M_Product_PO.DeliveryTime_Promised, " +
      "M_Product_PO.VendorProductNo, " +
      "M_Product_PO.VendorCategory, " +
      "M_Product_PO.Manufacturer, " +
      "COALESCE(M_Product_PO.Discontinued, 'N') AS Discontinued, " +
      "M_Product_PO.DiscontinuedBy, " +
      "M_Product_PO.Qtystd, " +
      "M_Product_PO.Order_Min, " +
      "COALESCE(M_Product_PO.ismultipleofminimumqty, 'N') AS ismultipleofminimumqty, " +
      "M_Product_PO.PriceEffective, " +
      "M_Product_PO.C_UOM_ID, " +
      "M_Product_PO.Order_Pack, " +
      "M_Product_PO.CostPerOrder, " +
      "M_Product_PO.DeliveryTime_Actual, " +
      "M_Product_PO.M_Product_PO_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Product_PO left join (select AD_Client_ID, Name from AD_Client) table1 on (M_Product_PO.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_Product_PO.AD_Org_ID = table2.AD_Org_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (M_Product_PO.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table4 on (M_Product_PO.C_BPartner_ID = table4.C_BPartner_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table5 on (M_Product_PO.C_Currency_ID = table5.C_Currency_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_Product_PO.M_Product_ID = ?  ");
    strSql = strSql + 
      "        AND M_Product_PO.M_Product_PO_ID = ? " +
      "        AND M_Product_PO.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Product_PO.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (mProductId != null && !(mProductId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
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
        PurchasingData objectPurchasingData = new PurchasingData();
        objectPurchasingData.created = UtilSql.getValue(result, "created");
        objectPurchasingData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPurchasingData.updated = UtilSql.getValue(result, "updated");
        objectPurchasingData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPurchasingData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPurchasingData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPurchasingData.royaltyamt = UtilSql.getValue(result, "royaltyamt");
        objectPurchasingData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPurchasingData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectPurchasingData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPurchasingData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPurchasingData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectPurchasingData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectPurchasingData.capacity = UtilSql.getValue(result, "capacity");
        objectPurchasingData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPurchasingData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectPurchasingData.qualityrating = UtilSql.getValue(result, "qualityrating");
        objectPurchasingData.isactive = UtilSql.getValue(result, "isactive");
        objectPurchasingData.iscurrentvendor = UtilSql.getValue(result, "iscurrentvendor");
        objectPurchasingData.upc = UtilSql.getValue(result, "upc");
        objectPurchasingData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectPurchasingData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectPurchasingData.pricelist = UtilSql.getValue(result, "pricelist");
        objectPurchasingData.pricepo = UtilSql.getValue(result, "pricepo");
        objectPurchasingData.pricelastpo = UtilSql.getValue(result, "pricelastpo");
        objectPurchasingData.pricelastinv = UtilSql.getValue(result, "pricelastinv");
        objectPurchasingData.deliverytimePromised = UtilSql.getValue(result, "deliverytime_promised");
        objectPurchasingData.vendorproductno = UtilSql.getValue(result, "vendorproductno");
        objectPurchasingData.vendorcategory = UtilSql.getValue(result, "vendorcategory");
        objectPurchasingData.manufacturer = UtilSql.getValue(result, "manufacturer");
        objectPurchasingData.discontinued = UtilSql.getValue(result, "discontinued");
        objectPurchasingData.discontinuedby = UtilSql.getDateValue(result, "discontinuedby", "dd-MM-yyyy");
        objectPurchasingData.qtystd = UtilSql.getValue(result, "qtystd");
        objectPurchasingData.orderMin = UtilSql.getValue(result, "order_min");
        objectPurchasingData.ismultipleofminimumqty = UtilSql.getValue(result, "ismultipleofminimumqty");
        objectPurchasingData.priceeffective = UtilSql.getDateValue(result, "priceeffective", "dd-MM-yyyy");
        objectPurchasingData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectPurchasingData.orderPack = UtilSql.getValue(result, "order_pack");
        objectPurchasingData.costperorder = UtilSql.getValue(result, "costperorder");
        objectPurchasingData.deliverytimeActual = UtilSql.getValue(result, "deliverytime_actual");
        objectPurchasingData.mProductPoId = UtilSql.getValue(result, "m_product_po_id");
        objectPurchasingData.language = UtilSql.getValue(result, "language");
        objectPurchasingData.adUserClient = "";
        objectPurchasingData.adOrgClient = "";
        objectPurchasingData.createdby = "";
        objectPurchasingData.trBgcolor = "";
        objectPurchasingData.totalCount = "";
        objectPurchasingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPurchasingData);
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
    PurchasingData objectPurchasingData[] = new PurchasingData[vector.size()];
    vector.copyInto(objectPurchasingData);
    return(objectPurchasingData);
  }

/**
Create a registry
 */
  public static PurchasingData[] set(String mProductId, String createdby, String createdbyr, String cBpartnerId, String cBpartnerIdr, String discontinuedby, String costperorder, String orderMin, String iscurrentvendor, String mProductPoId, String mProductIdr, String priceeffective, String vendorcategory, String pricelastinv, String pricelist, String deliverytimeActual, String isactive, String pricepo, String updatedby, String updatedbyr, String orderPack, String discontinued, String adClientId, String pricelastpo, String ismultipleofminimumqty, String vendorproductno, String cUomId, String cCurrencyId, String qtystd, String upc, String qualityrating, String royaltyamt, String capacity, String adOrgId, String manufacturer, String deliverytimePromised)    throws ServletException {
    PurchasingData objectPurchasingData[] = new PurchasingData[1];
    objectPurchasingData[0] = new PurchasingData();
    objectPurchasingData[0].created = "";
    objectPurchasingData[0].createdbyr = createdbyr;
    objectPurchasingData[0].updated = "";
    objectPurchasingData[0].updatedTimeStamp = "";
    objectPurchasingData[0].updatedby = updatedby;
    objectPurchasingData[0].updatedbyr = updatedbyr;
    objectPurchasingData[0].royaltyamt = royaltyamt;
    objectPurchasingData[0].adClientId = adClientId;
    objectPurchasingData[0].adClientIdr = "";
    objectPurchasingData[0].adOrgId = adOrgId;
    objectPurchasingData[0].adOrgIdr = "";
    objectPurchasingData[0].mProductId = mProductId;
    objectPurchasingData[0].mProductIdr = mProductIdr;
    objectPurchasingData[0].capacity = capacity;
    objectPurchasingData[0].cBpartnerId = cBpartnerId;
    objectPurchasingData[0].cBpartnerIdr = cBpartnerIdr;
    objectPurchasingData[0].qualityrating = qualityrating;
    objectPurchasingData[0].isactive = isactive;
    objectPurchasingData[0].iscurrentvendor = iscurrentvendor;
    objectPurchasingData[0].upc = upc;
    objectPurchasingData[0].cCurrencyId = cCurrencyId;
    objectPurchasingData[0].cCurrencyIdr = "";
    objectPurchasingData[0].pricelist = pricelist;
    objectPurchasingData[0].pricepo = pricepo;
    objectPurchasingData[0].pricelastpo = pricelastpo;
    objectPurchasingData[0].pricelastinv = pricelastinv;
    objectPurchasingData[0].deliverytimePromised = deliverytimePromised;
    objectPurchasingData[0].vendorproductno = vendorproductno;
    objectPurchasingData[0].vendorcategory = vendorcategory;
    objectPurchasingData[0].manufacturer = manufacturer;
    objectPurchasingData[0].discontinued = discontinued;
    objectPurchasingData[0].discontinuedby = discontinuedby;
    objectPurchasingData[0].qtystd = qtystd;
    objectPurchasingData[0].orderMin = orderMin;
    objectPurchasingData[0].ismultipleofminimumqty = ismultipleofminimumqty;
    objectPurchasingData[0].priceeffective = priceeffective;
    objectPurchasingData[0].cUomId = cUomId;
    objectPurchasingData[0].orderPack = orderPack;
    objectPurchasingData[0].costperorder = costperorder;
    objectPurchasingData[0].deliverytimeActual = deliverytimeActual;
    objectPurchasingData[0].mProductPoId = mProductPoId;
    objectPurchasingData[0].language = "";
    return objectPurchasingData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2314_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
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

/**
Select for auxiliar field
 */
  public static String selectDef2705_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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

/**
Select for auxiliar field
 */
  public static String selectDef1420_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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

/**
Select for auxiliar field
 */
  public static String selectDef2316_3(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Product_PO.M_Product_ID AS NAME" +
      "        FROM M_Product_PO" +
      "        WHERE M_Product_PO.M_Product_PO_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM M_Product left join (select M_Product_ID, Value, Name from M_Product) table1 on (M_Product.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  WHERE M_Product.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM M_Product left join (select M_Product_ID, Value, Name from M_Product) table1 on (M_Product.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  WHERE M_Product.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_Product_PO" +
      "        SET RoyaltyAmt = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , M_Product_ID = (?) , Capacity = TO_NUMBER(?) , C_BPartner_ID = (?) , QualityRating = TO_NUMBER(?) , IsActive = (?) , IsCurrentVendor = (?) , UPC = (?) , C_Currency_ID = (?) , PriceList = TO_NUMBER(?) , PricePO = TO_NUMBER(?) , PriceLastPO = TO_NUMBER(?) , PriceLastInv = TO_NUMBER(?) , DeliveryTime_Promised = TO_NUMBER(?) , VendorProductNo = (?) , VendorCategory = (?) , Manufacturer = (?) , Discontinued = (?) , DiscontinuedBy = TO_DATE(?) , Qtystd = TO_NUMBER(?) , Order_Min = TO_NUMBER(?) , ismultipleofminimumqty = (?) , PriceEffective = TO_DATE(?) , C_UOM_ID = (?) , Order_Pack = TO_NUMBER(?) , CostPerOrder = TO_NUMBER(?) , DeliveryTime_Actual = TO_NUMBER(?) , M_Product_PO_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Product_PO.M_Product_PO_ID = ? " +
      "                 AND M_Product_PO.M_Product_ID = ? " +
      "        AND M_Product_PO.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Product_PO.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, royaltyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, capacity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qualityrating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscurrentvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelastpo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelastinv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimePromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtystd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismultipleofminimumqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceeffective);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderPack);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costperorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimeActual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductPoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductPoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_Product_PO " +
      "        (RoyaltyAmt, AD_Client_ID, AD_Org_ID, M_Product_ID, Capacity, C_BPartner_ID, QualityRating, IsActive, IsCurrentVendor, UPC, C_Currency_ID, PriceList, PricePO, PriceLastPO, PriceLastInv, DeliveryTime_Promised, VendorProductNo, VendorCategory, Manufacturer, Discontinued, DiscontinuedBy, Qtystd, Order_Min, ismultipleofminimumqty, PriceEffective, C_UOM_ID, Order_Pack, CostPerOrder, DeliveryTime_Actual, M_Product_PO_ID, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, royaltyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, capacity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qualityrating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscurrentvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelastpo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelastinv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimePromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtystd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismultipleofminimumqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceeffective);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderPack);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costperorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimeActual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductPoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mProductId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Product_PO" +
      "        WHERE M_Product_PO.M_Product_PO_ID = ? " +
      "                 AND M_Product_PO.M_Product_ID = ? " +
      "        AND M_Product_PO.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Product_PO.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Product_PO" +
      "        WHERE M_Product_PO.M_Product_PO_ID = ? " +
      "                 AND M_Product_PO.M_Product_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM M_Product_PO" +
      "         WHERE M_Product_PO.M_Product_PO_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM M_Product_PO" +
      "         WHERE M_Product_PO.M_Product_PO_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
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
}

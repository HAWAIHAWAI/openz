//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ImportProducts;

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
class ImportProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportProductData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isactive;
  public String iProductId;
  public String iIsimported;
  public String mProductId;
  public String mProductIdr;
  public String iErrormsg;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String name;
  public String description;
  public String documentnote;
  public String help;
  public String upc;
  public String sku;
  public String x12de355;
  public String cUomId;
  public String cUomIdr;
  public String productcategoryValue;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String producttype;
  public String producttyper;
  public String classification;
  public String volume;
  public String weight;
  public String shelfwidth;
  public String shelfheight;
  public String shelfdepth;
  public String unitsperpallet;
  public String discontinued;
  public String discontinuedby;
  public String imageurl;
  public String descriptionurl;
  public String bpartnerValue;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String isoCode;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String pricelist;
  public String pricepo;
  public String royaltyamt;
  public String priceeffective;
  public String vendorproductno;
  public String vendorcategory;
  public String manufacturer;
  public String orderMin;
  public String orderPack;
  public String costperorder;
  public String deliverytimePromised;
  public String processing;
  public String processed;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("i_product_id") || fieldName.equals("iProductId"))
      return iProductId;
    else if (fieldName.equalsIgnoreCase("i_isimported") || fieldName.equals("iIsimported"))
      return iIsimported;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("i_errormsg") || fieldName.equals("iErrormsg"))
      return iErrormsg;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("sku"))
      return sku;
    else if (fieldName.equalsIgnoreCase("x12de355"))
      return x12de355;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("productcategory_value") || fieldName.equals("productcategoryValue"))
      return productcategoryValue;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("producttype"))
      return producttype;
    else if (fieldName.equalsIgnoreCase("producttyper"))
      return producttyper;
    else if (fieldName.equalsIgnoreCase("classification"))
      return classification;
    else if (fieldName.equalsIgnoreCase("volume"))
      return volume;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("shelfwidth"))
      return shelfwidth;
    else if (fieldName.equalsIgnoreCase("shelfheight"))
      return shelfheight;
    else if (fieldName.equalsIgnoreCase("shelfdepth"))
      return shelfdepth;
    else if (fieldName.equalsIgnoreCase("unitsperpallet"))
      return unitsperpallet;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("discontinuedby"))
      return discontinuedby;
    else if (fieldName.equalsIgnoreCase("imageurl"))
      return imageurl;
    else if (fieldName.equalsIgnoreCase("descriptionurl"))
      return descriptionurl;
    else if (fieldName.equalsIgnoreCase("bpartner_value") || fieldName.equals("bpartnerValue"))
      return bpartnerValue;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("iso_code") || fieldName.equals("isoCode"))
      return isoCode;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricepo"))
      return pricepo;
    else if (fieldName.equalsIgnoreCase("royaltyamt"))
      return royaltyamt;
    else if (fieldName.equalsIgnoreCase("priceeffective"))
      return priceeffective;
    else if (fieldName.equalsIgnoreCase("vendorproductno"))
      return vendorproductno;
    else if (fieldName.equalsIgnoreCase("vendorcategory"))
      return vendorcategory;
    else if (fieldName.equalsIgnoreCase("manufacturer"))
      return manufacturer;
    else if (fieldName.equalsIgnoreCase("order_min") || fieldName.equals("orderMin"))
      return orderMin;
    else if (fieldName.equalsIgnoreCase("order_pack") || fieldName.equals("orderPack"))
      return orderPack;
    else if (fieldName.equalsIgnoreCase("costperorder"))
      return costperorder;
    else if (fieldName.equalsIgnoreCase("deliverytime_promised") || fieldName.equals("deliverytimePromised"))
      return deliverytimePromised;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
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
  public static ImportProductData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ImportProductData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(I_Product.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_Product.CreatedBy) as CreatedByR, " +
      "        to_char(I_Product.Updated, ?) as updated, " +
      "        to_char(I_Product.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        I_Product.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = I_Product.UpdatedBy) as UpdatedByR," +
      "        COALESCE(I_Product.IsActive, 'N') AS IsActive, " +
      "I_Product.I_Product_ID, " +
      "COALESCE(I_Product.I_IsImported, 'N') AS I_IsImported, " +
      "I_Product.M_Product_ID, " +
      "(CASE WHEN I_Product.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "I_Product.I_ErrorMsg, " +
      "I_Product.AD_Client_ID, " +
      "(CASE WHEN I_Product.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "I_Product.AD_Org_ID, " +
      "(CASE WHEN I_Product.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "I_Product.Value, " +
      "I_Product.Name, " +
      "I_Product.Description, " +
      "I_Product.DocumentNote, " +
      "I_Product.Help, " +
      "I_Product.UPC, " +
      "I_Product.SKU, " +
      "I_Product.X12DE355, " +
      "I_Product.C_UOM_ID, " +
      "(CASE WHEN I_Product.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "I_Product.ProductCategory_Value, " +
      "I_Product.M_Product_Category_ID, " +
      "(CASE WHEN I_Product.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "I_Product.ProductType, " +
      "(CASE WHEN I_Product.ProductType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProductTypeR, " +
      "I_Product.Classification, " +
      "I_Product.Volume, " +
      "I_Product.Weight, " +
      "I_Product.ShelfWidth, " +
      "I_Product.ShelfHeight, " +
      "I_Product.ShelfDepth, " +
      "I_Product.UnitsPerPallet, " +
      "COALESCE(I_Product.Discontinued, 'N') AS Discontinued, " +
      "I_Product.DiscontinuedBy, " +
      "I_Product.ImageURL, " +
      "I_Product.DescriptionURL, " +
      "I_Product.BPartner_Value, " +
      "I_Product.C_BPartner_ID, " +
      "(CASE WHEN I_Product.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "I_Product.ISO_Code, " +
      "I_Product.C_Currency_ID, " +
      "(CASE WHEN I_Product.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "I_Product.PriceList, " +
      "I_Product.PricePO, " +
      "I_Product.RoyaltyAmt, " +
      "I_Product.PriceEffective, " +
      "I_Product.VendorProductNo, " +
      "I_Product.VendorCategory, " +
      "I_Product.Manufacturer, " +
      "I_Product.Order_Min, " +
      "I_Product.Order_Pack, " +
      "I_Product.CostPerOrder, " +
      "I_Product.DeliveryTime_Promised, " +
      "I_Product.Processing, " +
      "COALESCE(I_Product.Processed, 'N') AS Processed, " +
      "        ? AS LANGUAGE " +
      "        FROM I_Product left join (select M_Product_ID, Value, Name from M_Product) table1 on (I_Product.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select AD_Client_ID, Name from AD_Client) table2 on (I_Product.AD_Client_ID = table2.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (I_Product.AD_Org_ID = table3.AD_Org_ID) left join (select C_UOM_ID, Name from C_UOM) table4 on (I_Product.C_UOM_ID = table4.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL4 on (table4.C_UOM_ID = tableTRL4.C_UOM_ID and tableTRL4.AD_Language = ?)  left join (select M_Product_Category_ID, Name from M_Product_Category) table5 on (I_Product.M_Product_Category_ID = table5.M_Product_Category_ID) left join ad_ref_list_v list1 on (I_Product.ProductType = list1.value and list1.ad_reference_id = '270' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table6 on (I_Product.C_BPartner_ID = table6.C_BPartner_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table7 on (I_Product.C_Currency_ID = table7.C_Currency_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND I_Product.I_Product_ID = ? " +
      "        AND I_Product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND I_Product.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
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
        ImportProductData objectImportProductData = new ImportProductData();
        objectImportProductData.created = UtilSql.getValue(result, "created");
        objectImportProductData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectImportProductData.updated = UtilSql.getValue(result, "updated");
        objectImportProductData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectImportProductData.updatedby = UtilSql.getValue(result, "updatedby");
        objectImportProductData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectImportProductData.isactive = UtilSql.getValue(result, "isactive");
        objectImportProductData.iProductId = UtilSql.getValue(result, "i_product_id");
        objectImportProductData.iIsimported = UtilSql.getValue(result, "i_isimported");
        objectImportProductData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectImportProductData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectImportProductData.iErrormsg = UtilSql.getValue(result, "i_errormsg");
        objectImportProductData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectImportProductData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectImportProductData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectImportProductData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectImportProductData.value = UtilSql.getValue(result, "value");
        objectImportProductData.name = UtilSql.getValue(result, "name");
        objectImportProductData.description = UtilSql.getValue(result, "description");
        objectImportProductData.documentnote = UtilSql.getValue(result, "documentnote");
        objectImportProductData.help = UtilSql.getValue(result, "help");
        objectImportProductData.upc = UtilSql.getValue(result, "upc");
        objectImportProductData.sku = UtilSql.getValue(result, "sku");
        objectImportProductData.x12de355 = UtilSql.getValue(result, "x12de355");
        objectImportProductData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectImportProductData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectImportProductData.productcategoryValue = UtilSql.getValue(result, "productcategory_value");
        objectImportProductData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectImportProductData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectImportProductData.producttype = UtilSql.getValue(result, "producttype");
        objectImportProductData.producttyper = UtilSql.getValue(result, "producttyper");
        objectImportProductData.classification = UtilSql.getValue(result, "classification");
        objectImportProductData.volume = UtilSql.getValue(result, "volume");
        objectImportProductData.weight = UtilSql.getValue(result, "weight");
        objectImportProductData.shelfwidth = UtilSql.getValue(result, "shelfwidth");
        objectImportProductData.shelfheight = UtilSql.getValue(result, "shelfheight");
        objectImportProductData.shelfdepth = UtilSql.getValue(result, "shelfdepth");
        objectImportProductData.unitsperpallet = UtilSql.getValue(result, "unitsperpallet");
        objectImportProductData.discontinued = UtilSql.getValue(result, "discontinued");
        objectImportProductData.discontinuedby = UtilSql.getDateValue(result, "discontinuedby", "dd-MM-yyyy");
        objectImportProductData.imageurl = UtilSql.getValue(result, "imageurl");
        objectImportProductData.descriptionurl = UtilSql.getValue(result, "descriptionurl");
        objectImportProductData.bpartnerValue = UtilSql.getValue(result, "bpartner_value");
        objectImportProductData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportProductData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectImportProductData.isoCode = UtilSql.getValue(result, "iso_code");
        objectImportProductData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectImportProductData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectImportProductData.pricelist = UtilSql.getValue(result, "pricelist");
        objectImportProductData.pricepo = UtilSql.getValue(result, "pricepo");
        objectImportProductData.royaltyamt = UtilSql.getValue(result, "royaltyamt");
        objectImportProductData.priceeffective = UtilSql.getDateValue(result, "priceeffective", "dd-MM-yyyy");
        objectImportProductData.vendorproductno = UtilSql.getValue(result, "vendorproductno");
        objectImportProductData.vendorcategory = UtilSql.getValue(result, "vendorcategory");
        objectImportProductData.manufacturer = UtilSql.getValue(result, "manufacturer");
        objectImportProductData.orderMin = UtilSql.getValue(result, "order_min");
        objectImportProductData.orderPack = UtilSql.getValue(result, "order_pack");
        objectImportProductData.costperorder = UtilSql.getValue(result, "costperorder");
        objectImportProductData.deliverytimePromised = UtilSql.getValue(result, "deliverytime_promised");
        objectImportProductData.processing = UtilSql.getValue(result, "processing");
        objectImportProductData.processed = UtilSql.getValue(result, "processed");
        objectImportProductData.language = UtilSql.getValue(result, "language");
        objectImportProductData.adUserClient = "";
        objectImportProductData.adOrgClient = "";
        objectImportProductData.createdby = "";
        objectImportProductData.trBgcolor = "";
        objectImportProductData.totalCount = "";
        objectImportProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportProductData);
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
    ImportProductData objectImportProductData[] = new ImportProductData[vector.size()];
    vector.copyInto(objectImportProductData);
    return(objectImportProductData);
  }

/**
Create a registry
 */
  public static ImportProductData[] set(String pricelist, String iIsimported, String name, String orderMin, String vendorcategory, String discontinuedby, String unitsperpallet, String processing, String cUomId, String mProductId, String cBpartnerId, String cBpartnerIdr, String descriptionurl, String help, String bpartnerValue, String shelfdepth, String isoCode, String shelfheight, String isactive, String volume, String orderPack, String weight, String deliverytimePromised, String sku, String shelfwidth, String royaltyamt, String cCurrencyId, String manufacturer, String productcategoryValue, String value, String vendorproductno, String upc, String iProductId, String processed, String classification, String documentnote, String adOrgId, String producttype, String pricepo, String imageurl, String x12de355, String mProductCategoryId, String costperorder, String priceeffective, String adClientId, String description, String createdby, String createdbyr, String iErrormsg, String discontinued, String updatedby, String updatedbyr)    throws ServletException {
    ImportProductData objectImportProductData[] = new ImportProductData[1];
    objectImportProductData[0] = new ImportProductData();
    objectImportProductData[0].created = "";
    objectImportProductData[0].createdbyr = createdbyr;
    objectImportProductData[0].updated = "";
    objectImportProductData[0].updatedTimeStamp = "";
    objectImportProductData[0].updatedby = updatedby;
    objectImportProductData[0].updatedbyr = updatedbyr;
    objectImportProductData[0].isactive = isactive;
    objectImportProductData[0].iProductId = iProductId;
    objectImportProductData[0].iIsimported = iIsimported;
    objectImportProductData[0].mProductId = mProductId;
    objectImportProductData[0].mProductIdr = "";
    objectImportProductData[0].iErrormsg = iErrormsg;
    objectImportProductData[0].adClientId = adClientId;
    objectImportProductData[0].adClientIdr = "";
    objectImportProductData[0].adOrgId = adOrgId;
    objectImportProductData[0].adOrgIdr = "";
    objectImportProductData[0].value = value;
    objectImportProductData[0].name = name;
    objectImportProductData[0].description = description;
    objectImportProductData[0].documentnote = documentnote;
    objectImportProductData[0].help = help;
    objectImportProductData[0].upc = upc;
    objectImportProductData[0].sku = sku;
    objectImportProductData[0].x12de355 = x12de355;
    objectImportProductData[0].cUomId = cUomId;
    objectImportProductData[0].cUomIdr = "";
    objectImportProductData[0].productcategoryValue = productcategoryValue;
    objectImportProductData[0].mProductCategoryId = mProductCategoryId;
    objectImportProductData[0].mProductCategoryIdr = "";
    objectImportProductData[0].producttype = producttype;
    objectImportProductData[0].producttyper = "";
    objectImportProductData[0].classification = classification;
    objectImportProductData[0].volume = volume;
    objectImportProductData[0].weight = weight;
    objectImportProductData[0].shelfwidth = shelfwidth;
    objectImportProductData[0].shelfheight = shelfheight;
    objectImportProductData[0].shelfdepth = shelfdepth;
    objectImportProductData[0].unitsperpallet = unitsperpallet;
    objectImportProductData[0].discontinued = discontinued;
    objectImportProductData[0].discontinuedby = discontinuedby;
    objectImportProductData[0].imageurl = imageurl;
    objectImportProductData[0].descriptionurl = descriptionurl;
    objectImportProductData[0].bpartnerValue = bpartnerValue;
    objectImportProductData[0].cBpartnerId = cBpartnerId;
    objectImportProductData[0].cBpartnerIdr = cBpartnerIdr;
    objectImportProductData[0].isoCode = isoCode;
    objectImportProductData[0].cCurrencyId = cCurrencyId;
    objectImportProductData[0].cCurrencyIdr = "";
    objectImportProductData[0].pricelist = pricelist;
    objectImportProductData[0].pricepo = pricepo;
    objectImportProductData[0].royaltyamt = royaltyamt;
    objectImportProductData[0].priceeffective = priceeffective;
    objectImportProductData[0].vendorproductno = vendorproductno;
    objectImportProductData[0].vendorcategory = vendorcategory;
    objectImportProductData[0].manufacturer = manufacturer;
    objectImportProductData[0].orderMin = orderMin;
    objectImportProductData[0].orderPack = orderPack;
    objectImportProductData[0].costperorder = costperorder;
    objectImportProductData[0].deliverytimePromised = deliverytimePromised;
    objectImportProductData[0].processing = processing;
    objectImportProductData[0].processed = processed;
    objectImportProductData[0].language = "";
    return objectImportProductData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef7846_0(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
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
  public static String selectDef7838_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef7821_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_Product" +
      "        SET IsActive = (?) , I_Product_ID = (?) , I_IsImported = (?) , M_Product_ID = (?) , I_ErrorMsg = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Value = (?) , Name = (?) , Description = (?) , DocumentNote = (?) , Help = (?) , UPC = (?) , SKU = (?) , X12DE355 = (?) , C_UOM_ID = (?) , ProductCategory_Value = (?) , M_Product_Category_ID = (?) , ProductType = (?) , Classification = (?) , Volume = TO_NUMBER(?) , Weight = TO_NUMBER(?) , ShelfWidth = TO_NUMBER(?) , ShelfHeight = TO_NUMBER(?) , ShelfDepth = TO_NUMBER(?) , UnitsPerPallet = TO_NUMBER(?) , Discontinued = (?) , DiscontinuedBy = TO_DATE(?) , ImageURL = (?) , DescriptionURL = (?) , BPartner_Value = (?) , C_BPartner_ID = (?) , ISO_Code = (?) , C_Currency_ID = (?) , PriceList = TO_NUMBER(?) , PricePO = TO_NUMBER(?) , RoyaltyAmt = TO_NUMBER(?) , PriceEffective = TO_DATE(?) , VendorProductNo = (?) , VendorCategory = (?) , Manufacturer = (?) , Order_Min = TO_NUMBER(?) , Order_Pack = TO_NUMBER(?) , CostPerOrder = TO_NUMBER(?) , DeliveryTime_Promised = TO_NUMBER(?) , Processing = (?) , Processed = (?) , updated = now(), updatedby = ? " +
      "        WHERE I_Product.I_Product_ID = ? " +
      "        AND I_Product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_Product.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, x12de355);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productcategoryValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, volume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfwidth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfheight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfdepth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unitsperpallet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, descriptionurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isoCode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, royaltyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceeffective);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderPack);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costperorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimePromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iProductId);
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
      "        INSERT INTO I_Product " +
      "        (IsActive, I_Product_ID, I_IsImported, M_Product_ID, I_ErrorMsg, AD_Client_ID, AD_Org_ID, Value, Name, Description, DocumentNote, Help, UPC, SKU, X12DE355, C_UOM_ID, ProductCategory_Value, M_Product_Category_ID, ProductType, Classification, Volume, Weight, ShelfWidth, ShelfHeight, ShelfDepth, UnitsPerPallet, Discontinued, DiscontinuedBy, ImageURL, DescriptionURL, BPartner_Value, C_BPartner_ID, ISO_Code, C_Currency_ID, PriceList, PricePO, RoyaltyAmt, PriceEffective, VendorProductNo, VendorCategory, Manufacturer, Order_Min, Order_Pack, CostPerOrder, DeliveryTime_Promised, Processing, Processed, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iIsimported);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iErrormsg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, x12de355);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productcategoryValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, volume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfwidth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfheight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfdepth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unitsperpallet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, descriptionurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isoCode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, royaltyamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceeffective);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderPack);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costperorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimePromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM I_Product" +
      "        WHERE I_Product.I_Product_ID = ? " +
      "        AND I_Product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND I_Product.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM I_Product" +
      "        WHERE I_Product.I_Product_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
      "          FROM I_Product" +
      "         WHERE I_Product.I_Product_ID = ? ";

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
      "          FROM I_Product" +
      "         WHERE I_Product.I_Product_ID = ? ";

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

//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.ItemActiveStatus;

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
class ItemAA5160A40205448A8DB8F317C23AC2ABData implements FieldProvider {
static Logger log4j = Logger.getLogger(ItemAA5160A40205448A8DB8F317C23AC2ABData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String isactive;
  public String production;
  public String value;
  public String name;
  public String vendorproductno;
  public String isconsumable;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String producttype;
  public String producttyper;
  public String typeofproduct;
  public String typeofproductr;
  public String upc;
  public String description;
  public String documentnote;
  public String isserviceitem;
  public String isstocked;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String ispurchased;
  public String issold;
  public String ispriceprinted;
  public String coststd;
  public String calculated;
  public String buttoncopyitem;
  public String guaranteedays;
  public String delaymin;
  public String descriptionurl;
  public String setready4production;
  public String discontinued;
  public String isbom;
  public String sku;
  public String maProcessplanId;
  public String volume;
  public String mAttributesetinstanceId;
  public String classification;
  public String sExpensetypeId;
  public String unitsperpallet;
  public String mrpPlanningmethodId;
  public String costtype;
  public String name2;
  public String discontinuedby;
  public String shelfdepth;
  public String imageurl;
  public String shelfwidth;
  public String qtytype;
  public String mAttributesetId;
  public String salesrepId;
  public String mProductId;
  public String adClientId;
  public String shelfheight;
  public String mFreightcategoryId;
  public String cUomId;
  public String isinvoiceprintdetails;
  public String cTaxId;
  public String stockmin;
  public String buttonprintbom;
  public String adOrgId;
  public String isverified;
  public String enforceAttribute;
  public String downloadurl;
  public String ispicklistprintdetails;
  public String mLocatorId;
  public String versionno;
  public String qtystd;
  public String capacity;
  public String sResourceId;
  public String processing;
  public String qtymax;
  public String adImageId;
  public String help;
  public String stockMin;
  public String qtymin;
  public String weight;
  public String mrpPlannerId;
  public String issparepart;
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
    else if (fieldName.equalsIgnoreCase("production"))
      return production;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("vendorproductno"))
      return vendorproductno;
    else if (fieldName.equalsIgnoreCase("isconsumable"))
      return isconsumable;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("producttype"))
      return producttype;
    else if (fieldName.equalsIgnoreCase("producttyper"))
      return producttyper;
    else if (fieldName.equalsIgnoreCase("typeofproduct"))
      return typeofproduct;
    else if (fieldName.equalsIgnoreCase("typeofproductr"))
      return typeofproductr;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("isserviceitem"))
      return isserviceitem;
    else if (fieldName.equalsIgnoreCase("isstocked"))
      return isstocked;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ispurchased"))
      return ispurchased;
    else if (fieldName.equalsIgnoreCase("issold"))
      return issold;
    else if (fieldName.equalsIgnoreCase("ispriceprinted"))
      return ispriceprinted;
    else if (fieldName.equalsIgnoreCase("coststd"))
      return coststd;
    else if (fieldName.equalsIgnoreCase("calculated"))
      return calculated;
    else if (fieldName.equalsIgnoreCase("buttoncopyitem"))
      return buttoncopyitem;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("delaymin"))
      return delaymin;
    else if (fieldName.equalsIgnoreCase("descriptionurl"))
      return descriptionurl;
    else if (fieldName.equalsIgnoreCase("setready4production"))
      return setready4production;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("isbom"))
      return isbom;
    else if (fieldName.equalsIgnoreCase("sku"))
      return sku;
    else if (fieldName.equalsIgnoreCase("ma_processplan_id") || fieldName.equals("maProcessplanId"))
      return maProcessplanId;
    else if (fieldName.equalsIgnoreCase("volume"))
      return volume;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("classification"))
      return classification;
    else if (fieldName.equalsIgnoreCase("s_expensetype_id") || fieldName.equals("sExpensetypeId"))
      return sExpensetypeId;
    else if (fieldName.equalsIgnoreCase("unitsperpallet"))
      return unitsperpallet;
    else if (fieldName.equalsIgnoreCase("mrp_planningmethod_id") || fieldName.equals("mrpPlanningmethodId"))
      return mrpPlanningmethodId;
    else if (fieldName.equalsIgnoreCase("costtype"))
      return costtype;
    else if (fieldName.equalsIgnoreCase("name2"))
      return name2;
    else if (fieldName.equalsIgnoreCase("discontinuedby"))
      return discontinuedby;
    else if (fieldName.equalsIgnoreCase("shelfdepth"))
      return shelfdepth;
    else if (fieldName.equalsIgnoreCase("imageurl"))
      return imageurl;
    else if (fieldName.equalsIgnoreCase("shelfwidth"))
      return shelfwidth;
    else if (fieldName.equalsIgnoreCase("qtytype"))
      return qtytype;
    else if (fieldName.equalsIgnoreCase("m_attributeset_id") || fieldName.equals("mAttributesetId"))
      return mAttributesetId;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("shelfheight"))
      return shelfheight;
    else if (fieldName.equalsIgnoreCase("m_freightcategory_id") || fieldName.equals("mFreightcategoryId"))
      return mFreightcategoryId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("isinvoiceprintdetails"))
      return isinvoiceprintdetails;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("stockmin"))
      return stockmin;
    else if (fieldName.equalsIgnoreCase("buttonprintbom"))
      return buttonprintbom;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isverified"))
      return isverified;
    else if (fieldName.equalsIgnoreCase("enforce_attribute") || fieldName.equals("enforceAttribute"))
      return enforceAttribute;
    else if (fieldName.equalsIgnoreCase("downloadurl"))
      return downloadurl;
    else if (fieldName.equalsIgnoreCase("ispicklistprintdetails"))
      return ispicklistprintdetails;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("versionno"))
      return versionno;
    else if (fieldName.equalsIgnoreCase("qtystd"))
      return qtystd;
    else if (fieldName.equalsIgnoreCase("capacity"))
      return capacity;
    else if (fieldName.equalsIgnoreCase("s_resource_id") || fieldName.equals("sResourceId"))
      return sResourceId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("qtymax"))
      return qtymax;
    else if (fieldName.equalsIgnoreCase("ad_image_id") || fieldName.equals("adImageId"))
      return adImageId;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("stock_min") || fieldName.equals("stockMin"))
      return stockMin;
    else if (fieldName.equalsIgnoreCase("qtymin"))
      return qtymin;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("mrp_planner_id") || fieldName.equals("mrpPlannerId"))
      return mrpPlannerId;
    else if (fieldName.equalsIgnoreCase("issparepart"))
      return issparepart;
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
  public static ItemAA5160A40205448A8DB8F317C23AC2ABData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ItemAA5160A40205448A8DB8F317C23AC2ABData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Product.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product.CreatedBy) as CreatedByR, " +
      "        to_char(M_Product.Updated, ?) as updated, " +
      "        to_char(M_Product.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Product.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product.UpdatedBy) as UpdatedByR," +
      "        COALESCE(M_Product.IsActive, 'N') AS IsActive, " +
      "COALESCE(M_Product.Production, 'N') AS Production, " +
      "M_Product.Value, " +
      "M_Product.Name, " +
      "M_Product.VendorProductNo, " +
      "COALESCE(M_Product.isConsumable, 'N') AS isConsumable, " +
      "M_Product.M_Product_Category_ID, " +
      "(CASE WHEN M_Product.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "M_Product.ProductType, " +
      "(CASE WHEN M_Product.ProductType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProductTypeR, " +
      "M_Product.Typeofproduct, " +
      "(CASE WHEN M_Product.Typeofproduct IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS TypeofproductR, " +
      "M_Product.UPC, " +
      "M_Product.Description, " +
      "M_Product.DocumentNote, " +
      "COALESCE(M_Product.isServiceItem, 'N') AS isServiceItem, " +
      "COALESCE(M_Product.IsStocked, 'N') AS IsStocked, " +
      "M_Product.C_BPartner_ID, " +
      "(CASE WHEN M_Product.C_BPartner_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "COALESCE(M_Product.IsPurchased, 'N') AS IsPurchased, " +
      "COALESCE(M_Product.IsSold, 'N') AS IsSold, " +
      "COALESCE(M_Product.Ispriceprinted, 'N') AS Ispriceprinted, " +
      "M_Product.Coststd, " +
      "COALESCE(M_Product.Calculated, 'N') AS Calculated, " +
      "M_Product.Buttoncopyitem, " +
      "M_Product.GuaranteeDays, " +
      "M_Product.Delaymin, " +
      "M_Product.DescriptionURL, " +
      "M_Product.Setready4production, " +
      "COALESCE(M_Product.Discontinued, 'N') AS Discontinued, " +
      "COALESCE(M_Product.IsBOM, 'N') AS IsBOM, " +
      "M_Product.SKU, " +
      "M_Product.MA_Processplan_ID, " +
      "M_Product.Volume, " +
      "M_Product.M_AttributeSetInstance_ID, " +
      "M_Product.Classification, " +
      "M_Product.S_ExpenseType_ID, " +
      "M_Product.UnitsPerPallet, " +
      "M_Product.MRP_Planningmethod_ID, " +
      "M_Product.Costtype, " +
      "M_Product.Name2, " +
      "M_Product.DiscontinuedBy, " +
      "M_Product.ShelfDepth, " +
      "M_Product.ImageURL, " +
      "M_Product.ShelfWidth, " +
      "COALESCE(M_Product.Qtytype, 'N') AS Qtytype, " +
      "M_Product.M_AttributeSet_ID, " +
      "M_Product.SalesRep_ID, " +
      "M_Product.M_Product_ID, " +
      "M_Product.AD_Client_ID, " +
      "M_Product.ShelfHeight, " +
      "M_Product.M_FreightCategory_ID, " +
      "M_Product.C_UOM_ID, " +
      "COALESCE(M_Product.IsInvoicePrintDetails, 'N') AS IsInvoicePrintDetails, " +
      "M_Product.C_Tax_ID, " +
      "M_Product.Stockmin, " +
      "M_Product.Buttonprintbom, " +
      "M_Product.AD_Org_ID, " +
      "COALESCE(M_Product.isVerified, 'N') AS isVerified, " +
      "COALESCE(M_Product.Enforce_Attribute, 'N') AS Enforce_Attribute, " +
      "M_Product.DownloadURL, " +
      "COALESCE(M_Product.IsPickListPrintDetails, 'N') AS IsPickListPrintDetails, " +
      "M_Product.M_Locator_ID, " +
      "M_Product.VersionNo, " +
      "M_Product.Qtystd, " +
      "M_Product.Capacity, " +
      "M_Product.S_Resource_ID, " +
      "M_Product.Processing, " +
      "M_Product.Qtymax, " +
      "M_Product.AD_Image_ID, " +
      "M_Product.Help, " +
      "M_Product.Stock_Min, " +
      "M_Product.Qtymin, " +
      "M_Product.Weight, " +
      "M_Product.MRP_Planner_ID, " +
      "COALESCE(M_Product.isSparePart, 'N') AS isSparePart, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Product left join (select M_Product_Category_ID, Name from M_Product_Category) table1 on (M_Product.M_Product_Category_ID = table1.M_Product_Category_ID) left join ad_ref_list_v list1 on (M_Product.ProductType = list1.value and list1.ad_reference_id = '270' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (M_Product.Typeofproduct = list2.value and list2.ad_reference_id = 'D3CE5ED8E56C43E19FA09D10B616BCAA' and list2.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table2 on (M_Product.C_BPartner_ID =  table2.C_BPartner_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND M_Product.M_Product_ID = ? " +
      "        AND M_Product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Product.AD_Org_ID IN (";
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
        ItemAA5160A40205448A8DB8F317C23AC2ABData objectItemAA5160A40205448A8DB8F317C23AC2ABData = new ItemAA5160A40205448A8DB8F317C23AC2ABData();
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.created = UtilSql.getValue(result, "created");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.updated = UtilSql.getValue(result, "updated");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.updatedby = UtilSql.getValue(result, "updatedby");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.isactive = UtilSql.getValue(result, "isactive");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.production = UtilSql.getValue(result, "production");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.value = UtilSql.getValue(result, "value");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.name = UtilSql.getValue(result, "name");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.vendorproductno = UtilSql.getValue(result, "vendorproductno");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.isconsumable = UtilSql.getValue(result, "isconsumable");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.producttype = UtilSql.getValue(result, "producttype");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.producttyper = UtilSql.getValue(result, "producttyper");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.typeofproduct = UtilSql.getValue(result, "typeofproduct");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.typeofproductr = UtilSql.getValue(result, "typeofproductr");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.upc = UtilSql.getValue(result, "upc");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.description = UtilSql.getValue(result, "description");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.documentnote = UtilSql.getValue(result, "documentnote");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.isserviceitem = UtilSql.getValue(result, "isserviceitem");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.isstocked = UtilSql.getValue(result, "isstocked");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.ispurchased = UtilSql.getValue(result, "ispurchased");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.issold = UtilSql.getValue(result, "issold");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.ispriceprinted = UtilSql.getValue(result, "ispriceprinted");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.coststd = UtilSql.getValue(result, "coststd");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.calculated = UtilSql.getValue(result, "calculated");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.buttoncopyitem = UtilSql.getValue(result, "buttoncopyitem");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.delaymin = UtilSql.getValue(result, "delaymin");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.descriptionurl = UtilSql.getValue(result, "descriptionurl");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.setready4production = UtilSql.getValue(result, "setready4production");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.discontinued = UtilSql.getValue(result, "discontinued");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.isbom = UtilSql.getValue(result, "isbom");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.sku = UtilSql.getValue(result, "sku");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.maProcessplanId = UtilSql.getValue(result, "ma_processplan_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.volume = UtilSql.getValue(result, "volume");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.classification = UtilSql.getValue(result, "classification");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.sExpensetypeId = UtilSql.getValue(result, "s_expensetype_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.unitsperpallet = UtilSql.getValue(result, "unitsperpallet");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mrpPlanningmethodId = UtilSql.getValue(result, "mrp_planningmethod_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.costtype = UtilSql.getValue(result, "costtype");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.name2 = UtilSql.getValue(result, "name2");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.discontinuedby = UtilSql.getDateValue(result, "discontinuedby", "dd-MM-yyyy");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.shelfdepth = UtilSql.getValue(result, "shelfdepth");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.imageurl = UtilSql.getValue(result, "imageurl");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.shelfwidth = UtilSql.getValue(result, "shelfwidth");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.qtytype = UtilSql.getValue(result, "qtytype");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.shelfheight = UtilSql.getValue(result, "shelfheight");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mFreightcategoryId = UtilSql.getValue(result, "m_freightcategory_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.isinvoiceprintdetails = UtilSql.getValue(result, "isinvoiceprintdetails");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.stockmin = UtilSql.getValue(result, "stockmin");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.buttonprintbom = UtilSql.getValue(result, "buttonprintbom");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.isverified = UtilSql.getValue(result, "isverified");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.enforceAttribute = UtilSql.getValue(result, "enforce_attribute");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.downloadurl = UtilSql.getValue(result, "downloadurl");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.ispicklistprintdetails = UtilSql.getValue(result, "ispicklistprintdetails");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.versionno = UtilSql.getValue(result, "versionno");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.qtystd = UtilSql.getValue(result, "qtystd");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.capacity = UtilSql.getValue(result, "capacity");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.sResourceId = UtilSql.getValue(result, "s_resource_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.processing = UtilSql.getValue(result, "processing");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.qtymax = UtilSql.getValue(result, "qtymax");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.adImageId = UtilSql.getValue(result, "ad_image_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.help = UtilSql.getValue(result, "help");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.stockMin = UtilSql.getValue(result, "stock_min");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.qtymin = UtilSql.getValue(result, "qtymin");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.weight = UtilSql.getValue(result, "weight");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.mrpPlannerId = UtilSql.getValue(result, "mrp_planner_id");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.issparepart = UtilSql.getValue(result, "issparepart");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.language = UtilSql.getValue(result, "language");
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.adUserClient = "";
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.adOrgClient = "";
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.createdby = "";
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.trBgcolor = "";
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.totalCount = "";
        objectItemAA5160A40205448A8DB8F317C23AC2ABData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectItemAA5160A40205448A8DB8F317C23AC2ABData);
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
    ItemAA5160A40205448A8DB8F317C23AC2ABData objectItemAA5160A40205448A8DB8F317C23AC2ABData[] = new ItemAA5160A40205448A8DB8F317C23AC2ABData[vector.size()];
    vector.copyInto(objectItemAA5160A40205448A8DB8F317C23AC2ABData);
    return(objectItemAA5160A40205448A8DB8F317C23AC2ABData);
  }

/**
Create a registry
 */
  public static ItemAA5160A40205448A8DB8F317C23AC2ABData[] set(String shelfwidth, String mProductCategoryId, String documentnote, String costtype, String stockmin, String sExpensetypeId, String mAttributesetId, String createdby, String createdbyr, String weight, String value, String cBpartnerId, String isinvoiceprintdetails, String mrpPlannerId, String isbom, String delaymin, String maProcessplanId, String help, String name, String ispriceprinted, String mProductId, String sku, String downloadurl, String discontinuedby, String isstocked, String buttoncopyitem, String adOrgId, String discontinued, String mAttributesetinstanceId, String classification, String description, String versionno, String buttonprintbom, String mLocatorId, String issold, String qtystd, String calculated, String isconsumable, String qtymax, String sResourceId, String typeofproduct, String processing, String name2, String production, String adImageId, String qtytype, String adClientId, String isserviceitem, String enforceAttribute, String producttype, String stockMin, String issparepart, String upc, String salesrepId, String setready4production, String mrpPlanningmethodId, String vendorproductno, String shelfheight, String cUomId, String guaranteedays, String unitsperpallet, String updatedby, String updatedbyr, String capacity, String isactive, String isverified, String qtymin, String ispurchased, String mFreightcategoryId, String volume, String shelfdepth, String coststd, String cTaxId, String descriptionurl, String ispicklistprintdetails, String imageurl)    throws ServletException {
    ItemAA5160A40205448A8DB8F317C23AC2ABData objectItemAA5160A40205448A8DB8F317C23AC2ABData[] = new ItemAA5160A40205448A8DB8F317C23AC2ABData[1];
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0] = new ItemAA5160A40205448A8DB8F317C23AC2ABData();
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].created = "";
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].createdbyr = createdbyr;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].updated = "";
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].updatedTimeStamp = "";
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].updatedby = updatedby;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].updatedbyr = updatedbyr;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].isactive = isactive;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].production = production;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].value = value;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].name = name;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].vendorproductno = vendorproductno;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].isconsumable = isconsumable;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mProductCategoryId = mProductCategoryId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mProductCategoryIdr = "";
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].producttype = producttype;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].producttyper = "";
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].typeofproduct = typeofproduct;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].typeofproductr = "";
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].upc = upc;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].description = description;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].documentnote = documentnote;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].isserviceitem = isserviceitem;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].isstocked = isstocked;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].cBpartnerId = cBpartnerId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].cBpartnerIdr = "";
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].ispurchased = ispurchased;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].issold = issold;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].ispriceprinted = ispriceprinted;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].coststd = coststd;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].calculated = calculated;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].buttoncopyitem = buttoncopyitem;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].guaranteedays = guaranteedays;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].delaymin = delaymin;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].descriptionurl = descriptionurl;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].setready4production = setready4production;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].discontinued = discontinued;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].isbom = isbom;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].sku = sku;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].maProcessplanId = maProcessplanId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].volume = volume;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].classification = classification;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].sExpensetypeId = sExpensetypeId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].unitsperpallet = unitsperpallet;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mrpPlanningmethodId = mrpPlanningmethodId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].costtype = costtype;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].name2 = name2;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].discontinuedby = discontinuedby;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].shelfdepth = shelfdepth;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].imageurl = imageurl;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].shelfwidth = shelfwidth;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].qtytype = qtytype;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mAttributesetId = mAttributesetId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].salesrepId = salesrepId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mProductId = mProductId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].adClientId = adClientId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].shelfheight = shelfheight;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mFreightcategoryId = mFreightcategoryId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].cUomId = cUomId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].isinvoiceprintdetails = isinvoiceprintdetails;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].cTaxId = cTaxId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].stockmin = stockmin;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].buttonprintbom = buttonprintbom;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].adOrgId = adOrgId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].isverified = isverified;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].enforceAttribute = enforceAttribute;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].downloadurl = downloadurl;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].ispicklistprintdetails = ispicklistprintdetails;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mLocatorId = mLocatorId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].versionno = versionno;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].qtystd = qtystd;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].capacity = capacity;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].sResourceId = sResourceId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].processing = processing;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].qtymax = qtymax;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].adImageId = adImageId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].help = help;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].stockMin = stockMin;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].qtymin = qtymin;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].weight = weight;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].mrpPlannerId = mrpPlannerId;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].issparepart = issparepart;
    objectItemAA5160A40205448A8DB8F317C23AC2ABData[0].language = "";
    return objectItemAA5160A40205448A8DB8F317C23AC2ABData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1407_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2011(ConnectionProvider connectionProvider, String AD_ORG_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_getNewProductValue(?) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_ORG_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_getnewproductvalue");
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
  public static String selectDef2304(ConnectionProvider connectionProvider, String AD_ORG_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zssi_getNewProductEan(?) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_ORG_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zssi_getnewproductean");
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
  public static String selectDef1760(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_uom_id from c_uom where isdefault='Y' limit 1 ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_uom_id");
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
  public static String selectDef1409_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE M_Product" +
      "        SET IsActive = (?) , Production = (?) , Value = (?) , Name = (?) , VendorProductNo = (?) , isConsumable = (?) , M_Product_Category_ID = (?) , ProductType = (?) , Typeofproduct = (?) , UPC = (?) , Description = (?) , DocumentNote = (?) , isServiceItem = (?) , IsStocked = (?) , C_BPartner_ID = (?) , IsPurchased = (?) , IsSold = (?) , Ispriceprinted = (?) , Coststd = TO_NUMBER(?) , Calculated = (?) , Buttoncopyitem = (?) , GuaranteeDays = TO_NUMBER(?) , Delaymin = TO_NUMBER(?) , DescriptionURL = (?) , Setready4production = (?) , Discontinued = (?) , IsBOM = (?) , SKU = (?) , MA_Processplan_ID = (?) , Volume = TO_NUMBER(?) , M_AttributeSetInstance_ID = (?) , Classification = (?) , S_ExpenseType_ID = (?) , UnitsPerPallet = TO_NUMBER(?) , MRP_Planningmethod_ID = (?) , Costtype = (?) , Name2 = (?) , DiscontinuedBy = TO_DATE(?) , ShelfDepth = TO_NUMBER(?) , ImageURL = (?) , ShelfWidth = TO_NUMBER(?) , Qtytype = (?) , M_AttributeSet_ID = (?) , SalesRep_ID = (?) , M_Product_ID = (?) , AD_Client_ID = (?) , ShelfHeight = TO_NUMBER(?) , M_FreightCategory_ID = (?) , C_UOM_ID = (?) , IsInvoicePrintDetails = (?) , C_Tax_ID = (?) , Stockmin = TO_NUMBER(?) , Buttonprintbom = (?) , AD_Org_ID = (?) , isVerified = (?) , Enforce_Attribute = (?) , DownloadURL = (?) , IsPickListPrintDetails = (?) , M_Locator_ID = (?) , VersionNo = (?) , Qtystd = TO_NUMBER(?) , Capacity = TO_NUMBER(?) , S_Resource_ID = (?) , Processing = (?) , Qtymax = TO_NUMBER(?) , AD_Image_ID = (?) , Help = (?) , Stock_Min = TO_NUMBER(?) , Qtymin = TO_NUMBER(?) , Weight = TO_NUMBER(?) , MRP_Planner_ID = (?) , isSparePart = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Product.M_Product_ID = ? " +
      "        AND M_Product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Product.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, production);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isconsumable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isserviceitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstocked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispriceprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, coststd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttoncopyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, delaymin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, descriptionurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setready4production);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, volume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sExpensetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unitsperpallet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfdepth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfwidth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtytype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfheight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mFreightcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockmin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonprintbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isverified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enforceAttribute);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, downloadurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispicklistprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtystd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, capacity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtymax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtymin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlannerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issparepart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO M_Product " +
      "        (IsActive, Production, Value, Name, VendorProductNo, isConsumable, M_Product_Category_ID, ProductType, Typeofproduct, UPC, Description, DocumentNote, isServiceItem, IsStocked, C_BPartner_ID, IsPurchased, IsSold, Ispriceprinted, Coststd, Calculated, Buttoncopyitem, GuaranteeDays, Delaymin, DescriptionURL, Setready4production, Discontinued, IsBOM, SKU, MA_Processplan_ID, Volume, M_AttributeSetInstance_ID, Classification, S_ExpenseType_ID, UnitsPerPallet, MRP_Planningmethod_ID, Costtype, Name2, DiscontinuedBy, ShelfDepth, ImageURL, ShelfWidth, Qtytype, M_AttributeSet_ID, SalesRep_ID, M_Product_ID, AD_Client_ID, ShelfHeight, M_FreightCategory_ID, C_UOM_ID, IsInvoicePrintDetails, C_Tax_ID, Stockmin, Buttonprintbom, AD_Org_ID, isVerified, Enforce_Attribute, DownloadURL, IsPickListPrintDetails, M_Locator_ID, VersionNo, Qtystd, Capacity, S_Resource_ID, Processing, Qtymax, AD_Image_ID, Help, Stock_Min, Qtymin, Weight, MRP_Planner_ID, isSparePart, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, production);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isconsumable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isserviceitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstocked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispriceprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, coststd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttoncopyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, delaymin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, descriptionurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setready4production);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, volume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sExpensetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unitsperpallet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfdepth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfwidth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtytype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfheight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mFreightcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockmin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonprintbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isverified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enforceAttribute);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, downloadurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispicklistprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtystd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, capacity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtymax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtymin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlannerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issparepart);
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
      "        DELETE FROM M_Product" +
      "        WHERE M_Product.M_Product_ID = ? " +
      "        AND M_Product.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Product.AD_Org_ID IN (";
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
      "        DELETE FROM M_Product" +
      "        WHERE M_Product.M_Product_ID = ? ";

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
      "          FROM M_Product" +
      "         WHERE M_Product.M_Product_ID = ? ";

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
      "          FROM M_Product" +
      "         WHERE M_Product.M_Product_ID = ? ";

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

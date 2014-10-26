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
class ProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String adImageId;
  public String imageurl;
  public String value;
  public String upc;
  public String name;
  public String descriptionurl;
  public String description;
  public String documentnote;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String typeofproduct;
  public String typeofproductr;
  public String cUomId;
  public String cUomIdr;
  public String mAttributesetId;
  public String mAttributesetIdr;
  public String producttype;
  public String producttyper;
  public String isstocked;
  public String mLocatorId;
  public String mLocatorIdr;
  public String isserialtracking;
  public String isbatchtracking;
  public String weight;
  public String volume;
  public String shelfwidth;
  public String shelfheight;
  public String shelfdepth;
  public String unitsperpallet;
  public String cutoff;
  public String isconsumable;
  public String issparepart;
  public String issetitem;
  public String isfreightproduct;
  public String production;
  public String isbom;
  public String isverified;
  public String ispurchased;
  public String salesrepId;
  public String salesrepIdr;
  public String manufacturer;
  public String manufacturernumber;
  public String calculated;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String vendorproductno;
  public String issold;
  public String cTaxId;
  public String cTaxIdr;
  public String discontinued;
  public String discontinuedby;
  public String sExpensetypeId;
  public String sResourceId;
  public String customerproductno;
  public String theme;
  public String text;
  public String corediameter;
  public String colorcount;
  public String length;
  public String palettetype;
  public String width;
  public String setready4production;
  public String buttoncopyitem;
  public String isinvoiceprintdetails;
  public String buttonprintbom;
  public String delaymin;
  public String qtystd;
  public String mProductId;
  public String qtymax;
  public String enforceAttribute;
  public String coststd;
  public String qtytype;
  public String ispicklistprintdetails;
  public String ispriceprinted;
  public String processing;
  public String capacity;
  public String isactive;
  public String mFreightcategoryId;
  public String name2;
  public String issummaryitem;
  public String guaranteedays;
  public String sku;
  public String stockmin;
  public String downloadurl;
  public String mAttributesetinstanceId;
  public String versionno;
  public String help;
  public String stockMin;
  public String costtype;
  public String maProcessplanId;
  public String mrpPlanningmethodId;
  public String qtymin;
  public String mrpPlannerId;
  public String issummary;
  public String classification;
  public String isserviceitem;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_image_id") || fieldName.equals("adImageId"))
      return adImageId;
    else if (fieldName.equalsIgnoreCase("imageurl"))
      return imageurl;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("descriptionurl"))
      return descriptionurl;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("typeofproduct"))
      return typeofproduct;
    else if (fieldName.equalsIgnoreCase("typeofproductr"))
      return typeofproductr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("m_attributeset_id") || fieldName.equals("mAttributesetId"))
      return mAttributesetId;
    else if (fieldName.equalsIgnoreCase("m_attributeset_idr") || fieldName.equals("mAttributesetIdr"))
      return mAttributesetIdr;
    else if (fieldName.equalsIgnoreCase("producttype"))
      return producttype;
    else if (fieldName.equalsIgnoreCase("producttyper"))
      return producttyper;
    else if (fieldName.equalsIgnoreCase("isstocked"))
      return isstocked;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("isserialtracking"))
      return isserialtracking;
    else if (fieldName.equalsIgnoreCase("isbatchtracking"))
      return isbatchtracking;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("volume"))
      return volume;
    else if (fieldName.equalsIgnoreCase("shelfwidth"))
      return shelfwidth;
    else if (fieldName.equalsIgnoreCase("shelfheight"))
      return shelfheight;
    else if (fieldName.equalsIgnoreCase("shelfdepth"))
      return shelfdepth;
    else if (fieldName.equalsIgnoreCase("unitsperpallet"))
      return unitsperpallet;
    else if (fieldName.equalsIgnoreCase("cutoff"))
      return cutoff;
    else if (fieldName.equalsIgnoreCase("isconsumable"))
      return isconsumable;
    else if (fieldName.equalsIgnoreCase("issparepart"))
      return issparepart;
    else if (fieldName.equalsIgnoreCase("issetitem"))
      return issetitem;
    else if (fieldName.equalsIgnoreCase("isfreightproduct"))
      return isfreightproduct;
    else if (fieldName.equalsIgnoreCase("production"))
      return production;
    else if (fieldName.equalsIgnoreCase("isbom"))
      return isbom;
    else if (fieldName.equalsIgnoreCase("isverified"))
      return isverified;
    else if (fieldName.equalsIgnoreCase("ispurchased"))
      return ispurchased;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("manufacturer"))
      return manufacturer;
    else if (fieldName.equalsIgnoreCase("manufacturernumber"))
      return manufacturernumber;
    else if (fieldName.equalsIgnoreCase("calculated"))
      return calculated;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("vendorproductno"))
      return vendorproductno;
    else if (fieldName.equalsIgnoreCase("issold"))
      return issold;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("discontinuedby"))
      return discontinuedby;
    else if (fieldName.equalsIgnoreCase("s_expensetype_id") || fieldName.equals("sExpensetypeId"))
      return sExpensetypeId;
    else if (fieldName.equalsIgnoreCase("s_resource_id") || fieldName.equals("sResourceId"))
      return sResourceId;
    else if (fieldName.equalsIgnoreCase("customerproductno"))
      return customerproductno;
    else if (fieldName.equalsIgnoreCase("theme"))
      return theme;
    else if (fieldName.equalsIgnoreCase("text"))
      return text;
    else if (fieldName.equalsIgnoreCase("corediameter"))
      return corediameter;
    else if (fieldName.equalsIgnoreCase("colorcount"))
      return colorcount;
    else if (fieldName.equalsIgnoreCase("length"))
      return length;
    else if (fieldName.equalsIgnoreCase("palettetype"))
      return palettetype;
    else if (fieldName.equalsIgnoreCase("width"))
      return width;
    else if (fieldName.equalsIgnoreCase("setready4production"))
      return setready4production;
    else if (fieldName.equalsIgnoreCase("buttoncopyitem"))
      return buttoncopyitem;
    else if (fieldName.equalsIgnoreCase("isinvoiceprintdetails"))
      return isinvoiceprintdetails;
    else if (fieldName.equalsIgnoreCase("buttonprintbom"))
      return buttonprintbom;
    else if (fieldName.equalsIgnoreCase("delaymin"))
      return delaymin;
    else if (fieldName.equalsIgnoreCase("qtystd"))
      return qtystd;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("qtymax"))
      return qtymax;
    else if (fieldName.equalsIgnoreCase("enforce_attribute") || fieldName.equals("enforceAttribute"))
      return enforceAttribute;
    else if (fieldName.equalsIgnoreCase("coststd"))
      return coststd;
    else if (fieldName.equalsIgnoreCase("qtytype"))
      return qtytype;
    else if (fieldName.equalsIgnoreCase("ispicklistprintdetails"))
      return ispicklistprintdetails;
    else if (fieldName.equalsIgnoreCase("ispriceprinted"))
      return ispriceprinted;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("capacity"))
      return capacity;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("m_freightcategory_id") || fieldName.equals("mFreightcategoryId"))
      return mFreightcategoryId;
    else if (fieldName.equalsIgnoreCase("name2"))
      return name2;
    else if (fieldName.equalsIgnoreCase("issummaryitem"))
      return issummaryitem;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("sku"))
      return sku;
    else if (fieldName.equalsIgnoreCase("stockmin"))
      return stockmin;
    else if (fieldName.equalsIgnoreCase("downloadurl"))
      return downloadurl;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("versionno"))
      return versionno;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("stock_min") || fieldName.equals("stockMin"))
      return stockMin;
    else if (fieldName.equalsIgnoreCase("costtype"))
      return costtype;
    else if (fieldName.equalsIgnoreCase("ma_processplan_id") || fieldName.equals("maProcessplanId"))
      return maProcessplanId;
    else if (fieldName.equalsIgnoreCase("mrp_planningmethod_id") || fieldName.equals("mrpPlanningmethodId"))
      return mrpPlanningmethodId;
    else if (fieldName.equalsIgnoreCase("qtymin"))
      return qtymin;
    else if (fieldName.equalsIgnoreCase("mrp_planner_id") || fieldName.equals("mrpPlannerId"))
      return mrpPlannerId;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("classification"))
      return classification;
    else if (fieldName.equalsIgnoreCase("isserviceitem"))
      return isserviceitem;
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
  public static ProductData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Product.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product.CreatedBy) as CreatedByR, " +
      "        to_char(M_Product.Updated, ?) as updated, " +
      "        to_char(M_Product.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Product.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Product.UpdatedBy) as UpdatedByR," +
      "        M_Product.AD_Client_ID, " +
      "(CASE WHEN M_Product.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_Product.AD_Org_ID, " +
      "(CASE WHEN M_Product.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Product.AD_Image_ID, " +
      "M_Product.ImageURL, " +
      "M_Product.Value, " +
      "M_Product.UPC, " +
      "M_Product.Name, " +
      "M_Product.DescriptionURL, " +
      "M_Product.Description, " +
      "M_Product.DocumentNote, " +
      "M_Product.M_Product_Category_ID, " +
      "(CASE WHEN M_Product.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "M_Product.Typeofproduct, " +
      "(CASE WHEN M_Product.Typeofproduct IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS TypeofproductR, " +
      "M_Product.C_UOM_ID, " +
      "(CASE WHEN M_Product.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "M_Product.M_AttributeSet_ID, " +
      "(CASE WHEN M_Product.M_AttributeSet_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_AttributeSet_IDR, " +
      "M_Product.ProductType, " +
      "(CASE WHEN M_Product.ProductType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ProductTypeR, " +
      "COALESCE(M_Product.IsStocked, 'N') AS IsStocked, " +
      "M_Product.M_Locator_ID, " +
      "(CASE WHEN M_Product.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "COALESCE(M_Product.IsSerialTracking, 'N') AS IsSerialTracking, " +
      "COALESCE(M_Product.Isbatchtracking, 'N') AS Isbatchtracking, " +
      "M_Product.Weight, " +
      "M_Product.Volume, " +
      "M_Product.ShelfWidth, " +
      "M_Product.ShelfHeight, " +
      "M_Product.ShelfDepth, " +
      "M_Product.UnitsPerPallet, " +
      "M_Product.Cutoff, " +
      "COALESCE(M_Product.isConsumable, 'N') AS isConsumable, " +
      "COALESCE(M_Product.isSparePart, 'N') AS isSparePart, " +
      "COALESCE(M_Product.isSetItem, 'N') AS isSetItem, " +
      "COALESCE(M_Product.isFreightProduct, 'N') AS isFreightProduct, " +
      "COALESCE(M_Product.Production, 'N') AS Production, " +
      "COALESCE(M_Product.IsBOM, 'N') AS IsBOM, " +
      "COALESCE(M_Product.isVerified, 'N') AS isVerified, " +
      "COALESCE(M_Product.IsPurchased, 'N') AS IsPurchased, " +
      "M_Product.SalesRep_ID, " +
      "(CASE WHEN M_Product.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "M_Product.Manufacturer, " +
      "M_Product.Manufacturernumber, " +
      "COALESCE(M_Product.Calculated, 'N') AS Calculated, " +
      "M_Product.C_BPartner_ID, " +
      "(CASE WHEN M_Product.C_BPartner_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "M_Product.VendorProductNo, " +
      "COALESCE(M_Product.IsSold, 'N') AS IsSold, " +
      "M_Product.C_Tax_ID, " +
      "(CASE WHEN M_Product.C_Tax_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL9.Name IS NULL THEN TO_CHAR(table9.Name) ELSE TO_CHAR(tableTRL9.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "COALESCE(M_Product.Discontinued, 'N') AS Discontinued, " +
      "M_Product.DiscontinuedBy, " +
      "M_Product.S_ExpenseType_ID, " +
      "M_Product.S_Resource_ID, " +
      "M_Product.CustomerProductNo, " +
      "M_Product.Theme, " +
      "M_Product.Text, " +
      "M_Product.CoreDiameter, " +
      "M_Product.Colorcount, " +
      "M_Product.Length, " +
      "M_Product.Palettetype, " +
      "M_Product.Width, " +
      "M_Product.Setready4production, " +
      "M_Product.Buttoncopyitem, " +
      "COALESCE(M_Product.IsInvoicePrintDetails, 'N') AS IsInvoicePrintDetails, " +
      "M_Product.Buttonprintbom, " +
      "M_Product.Delaymin, " +
      "M_Product.Qtystd, " +
      "M_Product.M_Product_ID, " +
      "M_Product.Qtymax, " +
      "COALESCE(M_Product.Enforce_Attribute, 'N') AS Enforce_Attribute, " +
      "M_Product.Coststd, " +
      "COALESCE(M_Product.Qtytype, 'N') AS Qtytype, " +
      "COALESCE(M_Product.IsPickListPrintDetails, 'N') AS IsPickListPrintDetails, " +
      "COALESCE(M_Product.Ispriceprinted, 'N') AS Ispriceprinted, " +
      "M_Product.Processing, " +
      "M_Product.Capacity, " +
      "COALESCE(M_Product.IsActive, 'N') AS IsActive, " +
      "M_Product.M_FreightCategory_ID, " +
      "M_Product.Name2, " +
      "COALESCE(M_Product.IsSummaryItem, 'N') AS IsSummaryItem, " +
      "M_Product.GuaranteeDays, " +
      "M_Product.SKU, " +
      "M_Product.Stockmin, " +
      "M_Product.DownloadURL, " +
      "M_Product.M_AttributeSetInstance_ID, " +
      "M_Product.VersionNo, " +
      "M_Product.Help, " +
      "M_Product.Stock_Min, " +
      "M_Product.Costtype, " +
      "M_Product.MA_Processplan_ID, " +
      "M_Product.MRP_Planningmethod_ID, " +
      "M_Product.Qtymin, " +
      "M_Product.MRP_Planner_ID, " +
      "COALESCE(M_Product.IsSummary, 'N') AS IsSummary, " +
      "M_Product.Classification, " +
      "COALESCE(M_Product.isServiceItem, 'N') AS isServiceItem, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Product left join (select AD_Client_ID, Name from AD_Client) table1 on (M_Product.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_Product.AD_Org_ID = table2.AD_Org_ID) left join (select M_Product_Category_ID, Name from M_Product_Category) table3 on (M_Product.M_Product_Category_ID = table3.M_Product_Category_ID) left join ad_ref_list_v list1 on (M_Product.Typeofproduct = list1.value and list1.ad_reference_id = 'D3CE5ED8E56C43E19FA09D10B616BCAA' and list1.ad_language = ?)  left join (select C_UOM_ID, Name from C_UOM) table4 on (M_Product.C_UOM_ID = table4.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL4 on (table4.C_UOM_ID = tableTRL4.C_UOM_ID and tableTRL4.AD_Language = ?)  left join (select M_AttributeSet_ID, Name from M_AttributeSet) table5 on (M_Product.M_AttributeSet_ID = table5.M_AttributeSet_ID) left join ad_ref_list_v list2 on (M_Product.ProductType = list2.value and list2.ad_reference_id = '270' and list2.ad_language = ?)  left join (select M_Locator_ID, Value from M_Locator) table6 on (M_Product.M_Locator_ID = table6.M_Locator_ID) left join (select AD_User_ID, Name from AD_User) table7 on (M_Product.SalesRep_ID =  table7.AD_User_ID) left join (select C_BPartner_ID, Name from C_BPartner) table8 on (M_Product.C_BPartner_ID =  table8.C_BPartner_ID) left join (select C_Tax_ID, Name from C_Tax) table9 on (M_Product.C_Tax_ID = table9.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL9 on (table9.C_Tax_ID = tableTRL9.C_Tax_ID and tableTRL9.AD_Language = ?) " +
      "        WHERE 2=2 " +
      " AND m_product.isactive='Y'" +
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
        ProductData objectProductData = new ProductData();
        objectProductData.created = UtilSql.getValue(result, "created");
        objectProductData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductData.updated = UtilSql.getValue(result, "updated");
        objectProductData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectProductData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProductData.adImageId = UtilSql.getValue(result, "ad_image_id");
        objectProductData.imageurl = UtilSql.getValue(result, "imageurl");
        objectProductData.value = UtilSql.getValue(result, "value");
        objectProductData.upc = UtilSql.getValue(result, "upc");
        objectProductData.name = UtilSql.getValue(result, "name");
        objectProductData.descriptionurl = UtilSql.getValue(result, "descriptionurl");
        objectProductData.description = UtilSql.getValue(result, "description");
        objectProductData.documentnote = UtilSql.getValue(result, "documentnote");
        objectProductData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectProductData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectProductData.typeofproduct = UtilSql.getValue(result, "typeofproduct");
        objectProductData.typeofproductr = UtilSql.getValue(result, "typeofproductr");
        objectProductData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectProductData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectProductData.mAttributesetIdr = UtilSql.getValue(result, "m_attributeset_idr");
        objectProductData.producttype = UtilSql.getValue(result, "producttype");
        objectProductData.producttyper = UtilSql.getValue(result, "producttyper");
        objectProductData.isstocked = UtilSql.getValue(result, "isstocked");
        objectProductData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectProductData.isserialtracking = UtilSql.getValue(result, "isserialtracking");
        objectProductData.isbatchtracking = UtilSql.getValue(result, "isbatchtracking");
        objectProductData.weight = UtilSql.getValue(result, "weight");
        objectProductData.volume = UtilSql.getValue(result, "volume");
        objectProductData.shelfwidth = UtilSql.getValue(result, "shelfwidth");
        objectProductData.shelfheight = UtilSql.getValue(result, "shelfheight");
        objectProductData.shelfdepth = UtilSql.getValue(result, "shelfdepth");
        objectProductData.unitsperpallet = UtilSql.getValue(result, "unitsperpallet");
        objectProductData.cutoff = UtilSql.getValue(result, "cutoff");
        objectProductData.isconsumable = UtilSql.getValue(result, "isconsumable");
        objectProductData.issparepart = UtilSql.getValue(result, "issparepart");
        objectProductData.issetitem = UtilSql.getValue(result, "issetitem");
        objectProductData.isfreightproduct = UtilSql.getValue(result, "isfreightproduct");
        objectProductData.production = UtilSql.getValue(result, "production");
        objectProductData.isbom = UtilSql.getValue(result, "isbom");
        objectProductData.isverified = UtilSql.getValue(result, "isverified");
        objectProductData.ispurchased = UtilSql.getValue(result, "ispurchased");
        objectProductData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectProductData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectProductData.manufacturer = UtilSql.getValue(result, "manufacturer");
        objectProductData.manufacturernumber = UtilSql.getValue(result, "manufacturernumber");
        objectProductData.calculated = UtilSql.getValue(result, "calculated");
        objectProductData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProductData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectProductData.vendorproductno = UtilSql.getValue(result, "vendorproductno");
        objectProductData.issold = UtilSql.getValue(result, "issold");
        objectProductData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectProductData.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectProductData.discontinued = UtilSql.getValue(result, "discontinued");
        objectProductData.discontinuedby = UtilSql.getDateValue(result, "discontinuedby", "dd-MM-yyyy");
        objectProductData.sExpensetypeId = UtilSql.getValue(result, "s_expensetype_id");
        objectProductData.sResourceId = UtilSql.getValue(result, "s_resource_id");
        objectProductData.customerproductno = UtilSql.getValue(result, "customerproductno");
        objectProductData.theme = UtilSql.getValue(result, "theme");
        objectProductData.text = UtilSql.getValue(result, "text");
        objectProductData.corediameter = UtilSql.getValue(result, "corediameter");
        objectProductData.colorcount = UtilSql.getValue(result, "colorcount");
        objectProductData.length = UtilSql.getValue(result, "length");
        objectProductData.palettetype = UtilSql.getValue(result, "palettetype");
        objectProductData.width = UtilSql.getValue(result, "width");
        objectProductData.setready4production = UtilSql.getValue(result, "setready4production");
        objectProductData.buttoncopyitem = UtilSql.getValue(result, "buttoncopyitem");
        objectProductData.isinvoiceprintdetails = UtilSql.getValue(result, "isinvoiceprintdetails");
        objectProductData.buttonprintbom = UtilSql.getValue(result, "buttonprintbom");
        objectProductData.delaymin = UtilSql.getValue(result, "delaymin");
        objectProductData.qtystd = UtilSql.getValue(result, "qtystd");
        objectProductData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductData.qtymax = UtilSql.getValue(result, "qtymax");
        objectProductData.enforceAttribute = UtilSql.getValue(result, "enforce_attribute");
        objectProductData.coststd = UtilSql.getValue(result, "coststd");
        objectProductData.qtytype = UtilSql.getValue(result, "qtytype");
        objectProductData.ispicklistprintdetails = UtilSql.getValue(result, "ispicklistprintdetails");
        objectProductData.ispriceprinted = UtilSql.getValue(result, "ispriceprinted");
        objectProductData.processing = UtilSql.getValue(result, "processing");
        objectProductData.capacity = UtilSql.getValue(result, "capacity");
        objectProductData.isactive = UtilSql.getValue(result, "isactive");
        objectProductData.mFreightcategoryId = UtilSql.getValue(result, "m_freightcategory_id");
        objectProductData.name2 = UtilSql.getValue(result, "name2");
        objectProductData.issummaryitem = UtilSql.getValue(result, "issummaryitem");
        objectProductData.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectProductData.sku = UtilSql.getValue(result, "sku");
        objectProductData.stockmin = UtilSql.getValue(result, "stockmin");
        objectProductData.downloadurl = UtilSql.getValue(result, "downloadurl");
        objectProductData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductData.versionno = UtilSql.getValue(result, "versionno");
        objectProductData.help = UtilSql.getValue(result, "help");
        objectProductData.stockMin = UtilSql.getValue(result, "stock_min");
        objectProductData.costtype = UtilSql.getValue(result, "costtype");
        objectProductData.maProcessplanId = UtilSql.getValue(result, "ma_processplan_id");
        objectProductData.mrpPlanningmethodId = UtilSql.getValue(result, "mrp_planningmethod_id");
        objectProductData.qtymin = UtilSql.getValue(result, "qtymin");
        objectProductData.mrpPlannerId = UtilSql.getValue(result, "mrp_planner_id");
        objectProductData.issummary = UtilSql.getValue(result, "issummary");
        objectProductData.classification = UtilSql.getValue(result, "classification");
        objectProductData.isserviceitem = UtilSql.getValue(result, "isserviceitem");
        objectProductData.language = UtilSql.getValue(result, "language");
        objectProductData.adUserClient = "";
        objectProductData.adOrgClient = "";
        objectProductData.createdby = "";
        objectProductData.trBgcolor = "";
        objectProductData.totalCount = "";
        objectProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductData);
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
    ProductData objectProductData[] = new ProductData[vector.size()];
    vector.copyInto(objectProductData);
    return(objectProductData);
  }

/**
Create a registry
 */
  public static ProductData[] set(String ispurchased, String issummaryitem, String issetitem, String mProductCategoryId, String isactive, String isverified, String volume, String shelfdepth, String stockmin, String costtype, String cTaxId, String descriptionurl, String length, String createdby, String createdbyr, String imageurl, String value, String salesrepId, String cBpartnerId, String cUomId, String isinvoiceprintdetails, String unitsperpallet, String mrpPlannerId, String setready4production, String delaymin, String shelfheight, String isserialtracking, String maProcessplanId, String help, String production, String name, String isbatchtracking, String manufacturernumber, String ispriceprinted, String mProductId, String upc, String sku, String issparepart, String adClientId, String downloadurl, String adImageId, String width, String isserviceitem, String issold, String mLocatorId, String mLocatorIdr, String issummary, String calculated, String text, String mAttributesetinstanceId, String classification, String versionno, String palettetype, String buttonprintbom, String sResourceId, String discontinued, String customerproductno, String qtystd, String isconsumable, String qtymax, String description, String typeofproduct, String colorcount, String processing, String name2, String qtytype, String discontinuedby, String enforceAttribute, String isstocked, String adOrgId, String buttoncopyitem, String producttype, String stockMin, String theme, String isfreightproduct, String mrpPlanningmethodId, String isbom, String vendorproductno, String guaranteedays, String corediameter, String shelfwidth, String updatedby, String updatedbyr, String capacity, String manufacturer, String qtymin, String cutoff, String mFreightcategoryId, String weight, String documentnote, String coststd, String sExpensetypeId, String mAttributesetId, String ispicklistprintdetails)    throws ServletException {
    ProductData objectProductData[] = new ProductData[1];
    objectProductData[0] = new ProductData();
    objectProductData[0].created = "";
    objectProductData[0].createdbyr = createdbyr;
    objectProductData[0].updated = "";
    objectProductData[0].updatedTimeStamp = "";
    objectProductData[0].updatedby = updatedby;
    objectProductData[0].updatedbyr = updatedbyr;
    objectProductData[0].adClientId = adClientId;
    objectProductData[0].adClientIdr = "";
    objectProductData[0].adOrgId = adOrgId;
    objectProductData[0].adOrgIdr = "";
    objectProductData[0].adImageId = adImageId;
    objectProductData[0].imageurl = imageurl;
    objectProductData[0].value = value;
    objectProductData[0].upc = upc;
    objectProductData[0].name = name;
    objectProductData[0].descriptionurl = descriptionurl;
    objectProductData[0].description = description;
    objectProductData[0].documentnote = documentnote;
    objectProductData[0].mProductCategoryId = mProductCategoryId;
    objectProductData[0].mProductCategoryIdr = "";
    objectProductData[0].typeofproduct = typeofproduct;
    objectProductData[0].typeofproductr = "";
    objectProductData[0].cUomId = cUomId;
    objectProductData[0].cUomIdr = "";
    objectProductData[0].mAttributesetId = mAttributesetId;
    objectProductData[0].mAttributesetIdr = "";
    objectProductData[0].producttype = producttype;
    objectProductData[0].producttyper = "";
    objectProductData[0].isstocked = isstocked;
    objectProductData[0].mLocatorId = mLocatorId;
    objectProductData[0].mLocatorIdr = mLocatorIdr;
    objectProductData[0].isserialtracking = isserialtracking;
    objectProductData[0].isbatchtracking = isbatchtracking;
    objectProductData[0].weight = weight;
    objectProductData[0].volume = volume;
    objectProductData[0].shelfwidth = shelfwidth;
    objectProductData[0].shelfheight = shelfheight;
    objectProductData[0].shelfdepth = shelfdepth;
    objectProductData[0].unitsperpallet = unitsperpallet;
    objectProductData[0].cutoff = cutoff;
    objectProductData[0].isconsumable = isconsumable;
    objectProductData[0].issparepart = issparepart;
    objectProductData[0].issetitem = issetitem;
    objectProductData[0].isfreightproduct = isfreightproduct;
    objectProductData[0].production = production;
    objectProductData[0].isbom = isbom;
    objectProductData[0].isverified = isverified;
    objectProductData[0].ispurchased = ispurchased;
    objectProductData[0].salesrepId = salesrepId;
    objectProductData[0].salesrepIdr = "";
    objectProductData[0].manufacturer = manufacturer;
    objectProductData[0].manufacturernumber = manufacturernumber;
    objectProductData[0].calculated = calculated;
    objectProductData[0].cBpartnerId = cBpartnerId;
    objectProductData[0].cBpartnerIdr = "";
    objectProductData[0].vendorproductno = vendorproductno;
    objectProductData[0].issold = issold;
    objectProductData[0].cTaxId = cTaxId;
    objectProductData[0].cTaxIdr = "";
    objectProductData[0].discontinued = discontinued;
    objectProductData[0].discontinuedby = discontinuedby;
    objectProductData[0].sExpensetypeId = sExpensetypeId;
    objectProductData[0].sResourceId = sResourceId;
    objectProductData[0].customerproductno = customerproductno;
    objectProductData[0].theme = theme;
    objectProductData[0].text = text;
    objectProductData[0].corediameter = corediameter;
    objectProductData[0].colorcount = colorcount;
    objectProductData[0].length = length;
    objectProductData[0].palettetype = palettetype;
    objectProductData[0].width = width;
    objectProductData[0].setready4production = setready4production;
    objectProductData[0].buttoncopyitem = buttoncopyitem;
    objectProductData[0].isinvoiceprintdetails = isinvoiceprintdetails;
    objectProductData[0].buttonprintbom = buttonprintbom;
    objectProductData[0].delaymin = delaymin;
    objectProductData[0].qtystd = qtystd;
    objectProductData[0].mProductId = mProductId;
    objectProductData[0].qtymax = qtymax;
    objectProductData[0].enforceAttribute = enforceAttribute;
    objectProductData[0].coststd = coststd;
    objectProductData[0].qtytype = qtytype;
    objectProductData[0].ispicklistprintdetails = ispicklistprintdetails;
    objectProductData[0].ispriceprinted = ispriceprinted;
    objectProductData[0].processing = processing;
    objectProductData[0].capacity = capacity;
    objectProductData[0].isactive = isactive;
    objectProductData[0].mFreightcategoryId = mFreightcategoryId;
    objectProductData[0].name2 = name2;
    objectProductData[0].issummaryitem = issummaryitem;
    objectProductData[0].guaranteedays = guaranteedays;
    objectProductData[0].sku = sku;
    objectProductData[0].stockmin = stockmin;
    objectProductData[0].downloadurl = downloadurl;
    objectProductData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectProductData[0].versionno = versionno;
    objectProductData[0].help = help;
    objectProductData[0].stockMin = stockMin;
    objectProductData[0].costtype = costtype;
    objectProductData[0].maProcessplanId = maProcessplanId;
    objectProductData[0].mrpPlanningmethodId = mrpPlanningmethodId;
    objectProductData[0].qtymin = qtymin;
    objectProductData[0].mrpPlannerId = mrpPlannerId;
    objectProductData[0].issummary = issummary;
    objectProductData[0].classification = classification;
    objectProductData[0].isserviceitem = isserviceitem;
    objectProductData[0].language = "";
    return objectProductData;
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
  public static String selectDef9420_1(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as M_Locator_ID FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_locator_id");
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
  public static String selectDef1409_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Image_ID = (?) , ImageURL = (?) , Value = (?) , UPC = (?) , Name = (?) , DescriptionURL = (?) , Description = (?) , DocumentNote = (?) , M_Product_Category_ID = (?) , Typeofproduct = (?) , C_UOM_ID = (?) , M_AttributeSet_ID = (?) , ProductType = (?) , IsStocked = (?) , M_Locator_ID = (?) , IsSerialTracking = (?) , Isbatchtracking = (?) , Weight = TO_NUMBER(?) , Volume = TO_NUMBER(?) , ShelfWidth = TO_NUMBER(?) , ShelfHeight = TO_NUMBER(?) , ShelfDepth = TO_NUMBER(?) , UnitsPerPallet = TO_NUMBER(?) , Cutoff = TO_NUMBER(?) , isConsumable = (?) , isSparePart = (?) , isSetItem = (?) , isFreightProduct = (?) , Production = (?) , IsBOM = (?) , isVerified = (?) , IsPurchased = (?) , SalesRep_ID = (?) , Manufacturer = (?) , Manufacturernumber = (?) , Calculated = (?) , C_BPartner_ID = (?) , VendorProductNo = (?) , IsSold = (?) , C_Tax_ID = (?) , Discontinued = (?) , DiscontinuedBy = TO_DATE(?) , S_ExpenseType_ID = (?) , S_Resource_ID = (?) , CustomerProductNo = (?) , Theme = (?) , Text = (?) , CoreDiameter = TO_NUMBER(?) , Colorcount = TO_NUMBER(?) , Length = TO_NUMBER(?) , Palettetype = (?) , Width = TO_NUMBER(?) , Setready4production = (?) , Buttoncopyitem = (?) , IsInvoicePrintDetails = (?) , Buttonprintbom = (?) , Delaymin = TO_NUMBER(?) , Qtystd = TO_NUMBER(?) , M_Product_ID = (?) , Qtymax = TO_NUMBER(?) , Enforce_Attribute = (?) , Coststd = TO_NUMBER(?) , Qtytype = (?) , IsPickListPrintDetails = (?) , Ispriceprinted = (?) , Processing = (?) , Capacity = TO_NUMBER(?) , IsActive = (?) , M_FreightCategory_ID = (?) , Name2 = (?) , IsSummaryItem = (?) , GuaranteeDays = TO_NUMBER(?) , SKU = (?) , Stockmin = TO_NUMBER(?) , DownloadURL = (?) , M_AttributeSetInstance_ID = (?) , VersionNo = (?) , Help = (?) , Stock_Min = TO_NUMBER(?) , Costtype = (?) , MA_Processplan_ID = (?) , MRP_Planningmethod_ID = (?) , Qtymin = TO_NUMBER(?) , MRP_Planner_ID = (?) , IsSummary = (?) , Classification = (?) , isServiceItem = (?) , updated = now(), updatedby = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, descriptionurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstocked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isserialtracking);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbatchtracking);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, volume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfwidth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfheight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfdepth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unitsperpallet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isconsumable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issparepart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issetitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfreightproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, production);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isverified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturernumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sExpensetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, theme);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, corediameter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colorcount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, length);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, palettetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, width);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setready4production);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttoncopyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonprintbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, delaymin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtystd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtymax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enforceAttribute);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, coststd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtytype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispicklistprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispriceprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, capacity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mFreightcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummaryitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockmin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, downloadurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtymin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlannerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isserviceitem);
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
      "        (AD_Client_ID, AD_Org_ID, AD_Image_ID, ImageURL, Value, UPC, Name, DescriptionURL, Description, DocumentNote, M_Product_Category_ID, Typeofproduct, C_UOM_ID, M_AttributeSet_ID, ProductType, IsStocked, M_Locator_ID, IsSerialTracking, Isbatchtracking, Weight, Volume, ShelfWidth, ShelfHeight, ShelfDepth, UnitsPerPallet, Cutoff, isConsumable, isSparePart, isSetItem, isFreightProduct, Production, IsBOM, isVerified, IsPurchased, SalesRep_ID, Manufacturer, Manufacturernumber, Calculated, C_BPartner_ID, VendorProductNo, IsSold, C_Tax_ID, Discontinued, DiscontinuedBy, S_ExpenseType_ID, S_Resource_ID, CustomerProductNo, Theme, Text, CoreDiameter, Colorcount, Length, Palettetype, Width, Setready4production, Buttoncopyitem, IsInvoicePrintDetails, Buttonprintbom, Delaymin, Qtystd, M_Product_ID, Qtymax, Enforce_Attribute, Coststd, Qtytype, IsPickListPrintDetails, Ispriceprinted, Processing, Capacity, IsActive, M_FreightCategory_ID, Name2, IsSummaryItem, GuaranteeDays, SKU, Stockmin, DownloadURL, M_AttributeSetInstance_ID, VersionNo, Help, Stock_Min, Costtype, MA_Processplan_ID, MRP_Planningmethod_ID, Qtymin, MRP_Planner_ID, IsSummary, Classification, isServiceItem, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, descriptionurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstocked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isserialtracking);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbatchtracking);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, volume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfwidth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfheight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfdepth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unitsperpallet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cutoff);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isconsumable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issparepart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issetitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfreightproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, production);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isverified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manufacturernumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sExpensetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, customerproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, theme);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, corediameter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colorcount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, length);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, palettetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, width);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, setready4production);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttoncopyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonprintbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, delaymin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtystd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtymax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enforceAttribute);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, coststd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtytype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispicklistprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispriceprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, capacity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mFreightcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummaryitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockmin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, downloadurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, stockMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlanningmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtymin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpPlannerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isserviceitem);
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

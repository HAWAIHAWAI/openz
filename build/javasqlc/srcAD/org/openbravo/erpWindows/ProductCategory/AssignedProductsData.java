//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ProductCategory;

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
class AssignedProductsData implements FieldProvider {
static Logger log4j = Logger.getLogger(AssignedProductsData.class);
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
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String value;
  public String name;
  public String isactive;
  public String issummary;
  public String upc;
  public String discontinued;
  public String description;
  public String producttype;
  public String producttyper;
  public String documentnote;
  public String isstocked;
  public String sExpensetypeId;
  public String ispurchased;
  public String issold;
  public String sResourceId;
  public String processing;
  public String descriptionurl;
  public String imageurl;
  public String versionno;
  public String guaranteedays;
  public String mAttributesetId;
  public String mAttributesetinstanceId;
  public String downloadurl;
  public String mFreightcategoryId;
  public String shelfheight;
  public String mLocatorId;
  public String mProductId;
  public String cUomId;
  public String volume;
  public String weight;
  public String sku;
  public String shelfwidth;
  public String shelfdepth;
  public String unitsperpallet;
  public String discontinuedby;
  public String help;
  public String classification;
  public String salesrepId;
  public String isbom;
  public String isinvoiceprintdetails;
  public String ispicklistprintdetails;
  public String isverified;
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
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("upc"))
      return upc;
    else if (fieldName.equalsIgnoreCase("discontinued"))
      return discontinued;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("producttype"))
      return producttype;
    else if (fieldName.equalsIgnoreCase("producttyper"))
      return producttyper;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("isstocked"))
      return isstocked;
    else if (fieldName.equalsIgnoreCase("s_expensetype_id") || fieldName.equals("sExpensetypeId"))
      return sExpensetypeId;
    else if (fieldName.equalsIgnoreCase("ispurchased"))
      return ispurchased;
    else if (fieldName.equalsIgnoreCase("issold"))
      return issold;
    else if (fieldName.equalsIgnoreCase("s_resource_id") || fieldName.equals("sResourceId"))
      return sResourceId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("descriptionurl"))
      return descriptionurl;
    else if (fieldName.equalsIgnoreCase("imageurl"))
      return imageurl;
    else if (fieldName.equalsIgnoreCase("versionno"))
      return versionno;
    else if (fieldName.equalsIgnoreCase("guaranteedays"))
      return guaranteedays;
    else if (fieldName.equalsIgnoreCase("m_attributeset_id") || fieldName.equals("mAttributesetId"))
      return mAttributesetId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("downloadurl"))
      return downloadurl;
    else if (fieldName.equalsIgnoreCase("m_freightcategory_id") || fieldName.equals("mFreightcategoryId"))
      return mFreightcategoryId;
    else if (fieldName.equalsIgnoreCase("shelfheight"))
      return shelfheight;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("volume"))
      return volume;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("sku"))
      return sku;
    else if (fieldName.equalsIgnoreCase("shelfwidth"))
      return shelfwidth;
    else if (fieldName.equalsIgnoreCase("shelfdepth"))
      return shelfdepth;
    else if (fieldName.equalsIgnoreCase("unitsperpallet"))
      return unitsperpallet;
    else if (fieldName.equalsIgnoreCase("discontinuedby"))
      return discontinuedby;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("classification"))
      return classification;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("isbom"))
      return isbom;
    else if (fieldName.equalsIgnoreCase("isinvoiceprintdetails"))
      return isinvoiceprintdetails;
    else if (fieldName.equalsIgnoreCase("ispicklistprintdetails"))
      return ispicklistprintdetails;
    else if (fieldName.equalsIgnoreCase("isverified"))
      return isverified;
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
  public static AssignedProductsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String M_Product_Category_ID, String mProductCategoryId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, M_Product_Category_ID, mProductCategoryId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AssignedProductsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String M_Product_Category_ID, String mProductCategoryId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "M_Product.M_Product_Category_ID, " +
      "(CASE WHEN M_Product.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "M_Product.Value, " +
      "M_Product.Name, " +
      "COALESCE(M_Product.IsActive, 'N') AS IsActive, " +
      "COALESCE(M_Product.IsSummary, 'N') AS IsSummary, " +
      "M_Product.UPC, " +
      "COALESCE(M_Product.Discontinued, 'N') AS Discontinued, " +
      "M_Product.Description, " +
      "M_Product.ProductType, " +
      "(CASE WHEN M_Product.ProductType IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProductTypeR, " +
      "M_Product.DocumentNote, " +
      "COALESCE(M_Product.IsStocked, 'N') AS IsStocked, " +
      "M_Product.S_ExpenseType_ID, " +
      "COALESCE(M_Product.IsPurchased, 'N') AS IsPurchased, " +
      "COALESCE(M_Product.IsSold, 'N') AS IsSold, " +
      "M_Product.S_Resource_ID, " +
      "M_Product.Processing, " +
      "M_Product.DescriptionURL, " +
      "M_Product.ImageURL, " +
      "M_Product.VersionNo, " +
      "M_Product.GuaranteeDays, " +
      "M_Product.M_AttributeSet_ID, " +
      "M_Product.M_AttributeSetInstance_ID, " +
      "M_Product.DownloadURL, " +
      "M_Product.M_FreightCategory_ID, " +
      "M_Product.ShelfHeight, " +
      "M_Product.M_Locator_ID, " +
      "M_Product.M_Product_ID, " +
      "M_Product.C_UOM_ID, " +
      "M_Product.Volume, " +
      "M_Product.Weight, " +
      "M_Product.SKU, " +
      "M_Product.ShelfWidth, " +
      "M_Product.ShelfDepth, " +
      "M_Product.UnitsPerPallet, " +
      "M_Product.DiscontinuedBy, " +
      "M_Product.Help, " +
      "M_Product.Classification, " +
      "M_Product.SalesRep_ID, " +
      "COALESCE(M_Product.IsBOM, 'N') AS IsBOM, " +
      "COALESCE(M_Product.IsInvoicePrintDetails, 'N') AS IsInvoicePrintDetails, " +
      "COALESCE(M_Product.IsPickListPrintDetails, 'N') AS IsPickListPrintDetails, " +
      "COALESCE(M_Product.isVerified, 'N') AS isVerified, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Product left join (select AD_Client_ID, Name from AD_Client) table1 on (M_Product.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_Product.AD_Org_ID = table2.AD_Org_ID) left join (select M_Product_Category_ID, Name from M_Product_Category) table3 on (M_Product.M_Product_Category_ID = table3.M_Product_Category_ID) left join ad_ref_list_v list1 on (M_Product.ProductType = list1.value and list1.ad_reference_id = '270' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      " AND M_Product.M_Product_Category_ID = ?" +
      "        AND 1=1 ";
    strSql = strSql + ((mProductCategoryId==null || mProductCategoryId.equals(""))?"":"  AND M_Product.M_Product_Category_ID = ?  ");
    strSql = strSql + 
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_Category_ID);
      if (mProductCategoryId != null && !(mProductCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
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
        AssignedProductsData objectAssignedProductsData = new AssignedProductsData();
        objectAssignedProductsData.created = UtilSql.getValue(result, "created");
        objectAssignedProductsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAssignedProductsData.updated = UtilSql.getValue(result, "updated");
        objectAssignedProductsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAssignedProductsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAssignedProductsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAssignedProductsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAssignedProductsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAssignedProductsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAssignedProductsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAssignedProductsData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectAssignedProductsData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectAssignedProductsData.value = UtilSql.getValue(result, "value");
        objectAssignedProductsData.name = UtilSql.getValue(result, "name");
        objectAssignedProductsData.isactive = UtilSql.getValue(result, "isactive");
        objectAssignedProductsData.issummary = UtilSql.getValue(result, "issummary");
        objectAssignedProductsData.upc = UtilSql.getValue(result, "upc");
        objectAssignedProductsData.discontinued = UtilSql.getValue(result, "discontinued");
        objectAssignedProductsData.description = UtilSql.getValue(result, "description");
        objectAssignedProductsData.producttype = UtilSql.getValue(result, "producttype");
        objectAssignedProductsData.producttyper = UtilSql.getValue(result, "producttyper");
        objectAssignedProductsData.documentnote = UtilSql.getValue(result, "documentnote");
        objectAssignedProductsData.isstocked = UtilSql.getValue(result, "isstocked");
        objectAssignedProductsData.sExpensetypeId = UtilSql.getValue(result, "s_expensetype_id");
        objectAssignedProductsData.ispurchased = UtilSql.getValue(result, "ispurchased");
        objectAssignedProductsData.issold = UtilSql.getValue(result, "issold");
        objectAssignedProductsData.sResourceId = UtilSql.getValue(result, "s_resource_id");
        objectAssignedProductsData.processing = UtilSql.getValue(result, "processing");
        objectAssignedProductsData.descriptionurl = UtilSql.getValue(result, "descriptionurl");
        objectAssignedProductsData.imageurl = UtilSql.getValue(result, "imageurl");
        objectAssignedProductsData.versionno = UtilSql.getValue(result, "versionno");
        objectAssignedProductsData.guaranteedays = UtilSql.getValue(result, "guaranteedays");
        objectAssignedProductsData.mAttributesetId = UtilSql.getValue(result, "m_attributeset_id");
        objectAssignedProductsData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectAssignedProductsData.downloadurl = UtilSql.getValue(result, "downloadurl");
        objectAssignedProductsData.mFreightcategoryId = UtilSql.getValue(result, "m_freightcategory_id");
        objectAssignedProductsData.shelfheight = UtilSql.getValue(result, "shelfheight");
        objectAssignedProductsData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectAssignedProductsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectAssignedProductsData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectAssignedProductsData.volume = UtilSql.getValue(result, "volume");
        objectAssignedProductsData.weight = UtilSql.getValue(result, "weight");
        objectAssignedProductsData.sku = UtilSql.getValue(result, "sku");
        objectAssignedProductsData.shelfwidth = UtilSql.getValue(result, "shelfwidth");
        objectAssignedProductsData.shelfdepth = UtilSql.getValue(result, "shelfdepth");
        objectAssignedProductsData.unitsperpallet = UtilSql.getValue(result, "unitsperpallet");
        objectAssignedProductsData.discontinuedby = UtilSql.getDateValue(result, "discontinuedby", "dd-MM-yyyy");
        objectAssignedProductsData.help = UtilSql.getValue(result, "help");
        objectAssignedProductsData.classification = UtilSql.getValue(result, "classification");
        objectAssignedProductsData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectAssignedProductsData.isbom = UtilSql.getValue(result, "isbom");
        objectAssignedProductsData.isinvoiceprintdetails = UtilSql.getValue(result, "isinvoiceprintdetails");
        objectAssignedProductsData.ispicklistprintdetails = UtilSql.getValue(result, "ispicklistprintdetails");
        objectAssignedProductsData.isverified = UtilSql.getValue(result, "isverified");
        objectAssignedProductsData.language = UtilSql.getValue(result, "language");
        objectAssignedProductsData.adUserClient = "";
        objectAssignedProductsData.adOrgClient = "";
        objectAssignedProductsData.createdby = "";
        objectAssignedProductsData.trBgcolor = "";
        objectAssignedProductsData.totalCount = "";
        objectAssignedProductsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAssignedProductsData);
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
    AssignedProductsData objectAssignedProductsData[] = new AssignedProductsData[vector.size()];
    vector.copyInto(objectAssignedProductsData);
    return(objectAssignedProductsData);
  }

/**
Create a registry
 */
  public static AssignedProductsData[] set(String mProductCategoryId, String discontinued, String issummary, String issold, String mLocatorId, String shelfwidth, String documentnote, String mAttributesetId, String createdby, String createdbyr, String weight, String processing, String value, String isinvoiceprintdetails, String adOrgId, String isbom, String producttype, String upc, String help, String salesrepId, String name, String mProductId, String shelfheight, String sku, String adClientId, String downloadurl, String cUomId, String discontinuedby, String isstocked, String guaranteedays, String unitsperpallet, String updatedby, String updatedbyr, String isactive, String isverified, String classification, String mAttributesetinstanceId, String ispurchased, String mFreightcategoryId, String description, String versionno, String volume, String shelfdepth, String sExpensetypeId, String ispicklistprintdetails, String descriptionurl, String sResourceId, String imageurl)    throws ServletException {
    AssignedProductsData objectAssignedProductsData[] = new AssignedProductsData[1];
    objectAssignedProductsData[0] = new AssignedProductsData();
    objectAssignedProductsData[0].created = "";
    objectAssignedProductsData[0].createdbyr = createdbyr;
    objectAssignedProductsData[0].updated = "";
    objectAssignedProductsData[0].updatedTimeStamp = "";
    objectAssignedProductsData[0].updatedby = updatedby;
    objectAssignedProductsData[0].updatedbyr = updatedbyr;
    objectAssignedProductsData[0].adClientId = adClientId;
    objectAssignedProductsData[0].adClientIdr = "";
    objectAssignedProductsData[0].adOrgId = adOrgId;
    objectAssignedProductsData[0].adOrgIdr = "";
    objectAssignedProductsData[0].mProductCategoryId = mProductCategoryId;
    objectAssignedProductsData[0].mProductCategoryIdr = "";
    objectAssignedProductsData[0].value = value;
    objectAssignedProductsData[0].name = name;
    objectAssignedProductsData[0].isactive = isactive;
    objectAssignedProductsData[0].issummary = issummary;
    objectAssignedProductsData[0].upc = upc;
    objectAssignedProductsData[0].discontinued = discontinued;
    objectAssignedProductsData[0].description = description;
    objectAssignedProductsData[0].producttype = producttype;
    objectAssignedProductsData[0].producttyper = "";
    objectAssignedProductsData[0].documentnote = documentnote;
    objectAssignedProductsData[0].isstocked = isstocked;
    objectAssignedProductsData[0].sExpensetypeId = sExpensetypeId;
    objectAssignedProductsData[0].ispurchased = ispurchased;
    objectAssignedProductsData[0].issold = issold;
    objectAssignedProductsData[0].sResourceId = sResourceId;
    objectAssignedProductsData[0].processing = processing;
    objectAssignedProductsData[0].descriptionurl = descriptionurl;
    objectAssignedProductsData[0].imageurl = imageurl;
    objectAssignedProductsData[0].versionno = versionno;
    objectAssignedProductsData[0].guaranteedays = guaranteedays;
    objectAssignedProductsData[0].mAttributesetId = mAttributesetId;
    objectAssignedProductsData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectAssignedProductsData[0].downloadurl = downloadurl;
    objectAssignedProductsData[0].mFreightcategoryId = mFreightcategoryId;
    objectAssignedProductsData[0].shelfheight = shelfheight;
    objectAssignedProductsData[0].mLocatorId = mLocatorId;
    objectAssignedProductsData[0].mProductId = mProductId;
    objectAssignedProductsData[0].cUomId = cUomId;
    objectAssignedProductsData[0].volume = volume;
    objectAssignedProductsData[0].weight = weight;
    objectAssignedProductsData[0].sku = sku;
    objectAssignedProductsData[0].shelfwidth = shelfwidth;
    objectAssignedProductsData[0].shelfdepth = shelfdepth;
    objectAssignedProductsData[0].unitsperpallet = unitsperpallet;
    objectAssignedProductsData[0].discontinuedby = discontinuedby;
    objectAssignedProductsData[0].help = help;
    objectAssignedProductsData[0].classification = classification;
    objectAssignedProductsData[0].salesrepId = salesrepId;
    objectAssignedProductsData[0].isbom = isbom;
    objectAssignedProductsData[0].isinvoiceprintdetails = isinvoiceprintdetails;
    objectAssignedProductsData[0].ispicklistprintdetails = ispicklistprintdetails;
    objectAssignedProductsData[0].isverified = isverified;
    objectAssignedProductsData[0].language = "";
    return objectAssignedProductsData;
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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_Product.M_Product_Category_ID AS NAME" +
      "        FROM M_Product" +
      "        WHERE M_Product.M_Product_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mProductCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM M_Product_Category left join (select M_Product_Category_ID, Name from M_Product_Category) table1 on (M_Product_Category.M_Product_Category_ID = table1.M_Product_Category_ID) WHERE M_Product_Category.M_Product_Category_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mProductCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM M_Product_Category left join (select M_Product_Category_ID, Name from M_Product_Category) table1 on (M_Product_Category.M_Product_Category_ID = table1.M_Product_Category_ID) WHERE M_Product_Category.M_Product_Category_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);

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
      "        UPDATE M_Product" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , M_Product_Category_ID = (?) , Value = (?) , Name = (?) , IsActive = (?) , IsSummary = (?) , UPC = (?) , Discontinued = (?) , Description = (?) , ProductType = (?) , DocumentNote = (?) , IsStocked = (?) , S_ExpenseType_ID = (?) , IsPurchased = (?) , IsSold = (?) , S_Resource_ID = (?) , Processing = (?) , DescriptionURL = (?) , ImageURL = (?) , VersionNo = (?) , GuaranteeDays = TO_NUMBER(?) , M_AttributeSet_ID = (?) , M_AttributeSetInstance_ID = (?) , DownloadURL = (?) , M_FreightCategory_ID = (?) , ShelfHeight = TO_NUMBER(?) , M_Locator_ID = (?) , M_Product_ID = (?) , C_UOM_ID = (?) , Volume = TO_NUMBER(?) , Weight = TO_NUMBER(?) , SKU = (?) , ShelfWidth = TO_NUMBER(?) , ShelfDepth = TO_NUMBER(?) , UnitsPerPallet = TO_NUMBER(?) , DiscontinuedBy = TO_DATE(?) , Help = (?) , Classification = (?) , SalesRep_ID = (?) , IsBOM = (?) , IsInvoicePrintDetails = (?) , IsPickListPrintDetails = (?) , isVerified = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Product.M_Product_ID = ? " +
      "                 AND M_Product.M_Product_Category_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstocked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sExpensetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, descriptionurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, downloadurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mFreightcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfheight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, volume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfwidth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfdepth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unitsperpallet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispicklistprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isverified);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
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
      "        (AD_Client_ID, AD_Org_ID, M_Product_Category_ID, Value, Name, IsActive, IsSummary, UPC, Discontinued, Description, ProductType, DocumentNote, IsStocked, S_ExpenseType_ID, IsPurchased, IsSold, S_Resource_ID, Processing, DescriptionURL, ImageURL, VersionNo, GuaranteeDays, M_AttributeSet_ID, M_AttributeSetInstance_ID, DownloadURL, M_FreightCategory_ID, ShelfHeight, M_Locator_ID, M_Product_ID, C_UOM_ID, Volume, Weight, SKU, ShelfWidth, ShelfDepth, UnitsPerPallet, DiscontinuedBy, Help, Classification, SalesRep_ID, IsBOM, IsInvoicePrintDetails, IsPickListPrintDetails, isVerified, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, upc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinued);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, producttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstocked);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sExpensetypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispurchased);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, descriptionurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, imageurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, versionno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, guaranteedays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, downloadurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mFreightcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfheight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, volume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sku);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfwidth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shelfdepth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unitsperpallet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discontinuedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, classification);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispicklistprintdetails);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isverified);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mProductCategoryId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Product" +
      "        WHERE M_Product.M_Product_ID = ? " +
      "                 AND M_Product.M_Product_Category_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mProductCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_Product" +
      "        WHERE M_Product.M_Product_ID = ? " +
      "                 AND M_Product.M_Product_Category_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);

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

//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.bid.ExternalOrdersCallforBids;

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
class ServiceItem800003Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ServiceItem800003Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String dopricing;
  public String cOrderId;
  public String committedamt;
  public String cOrderpoId;
  public String committedqty;
  public String invoicedamt;
  public String invoicedqty;
  public String isprinted;
  public String processed;
  public String cProjectissueId;
  public String cProjectlineId;
  public String mProductCategoryId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String cProjectId;
  public String cProjectIdr;
  public String line;
  public String isactive;
  public String description;
  public String mProductId;
  public String mProductIdr;
  public String productValue;
  public String productName;
  public String productDescription;
  public String plannedqty;
  public String cTaxId;
  public String cTaxIdr;
  public String plannedprice;
  public String plannedpoprice;
  public String plannedamt;
  public String plannedmarginamt;
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
    else if (fieldName.equalsIgnoreCase("dopricing"))
      return dopricing;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("c_orderpo_id") || fieldName.equals("cOrderpoId"))
      return cOrderpoId;
    else if (fieldName.equalsIgnoreCase("committedqty"))
      return committedqty;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("invoicedqty"))
      return invoicedqty;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("c_projectissue_id") || fieldName.equals("cProjectissueId"))
      return cProjectissueId;
    else if (fieldName.equalsIgnoreCase("c_projectline_id") || fieldName.equals("cProjectlineId"))
      return cProjectlineId;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("product_value") || fieldName.equals("productValue"))
      return productValue;
    else if (fieldName.equalsIgnoreCase("product_name") || fieldName.equals("productName"))
      return productName;
    else if (fieldName.equalsIgnoreCase("product_description") || fieldName.equals("productDescription"))
      return productDescription;
    else if (fieldName.equalsIgnoreCase("plannedqty"))
      return plannedqty;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("c_tax_idr") || fieldName.equals("cTaxIdr"))
      return cTaxIdr;
    else if (fieldName.equalsIgnoreCase("plannedprice"))
      return plannedprice;
    else if (fieldName.equalsIgnoreCase("plannedpoprice"))
      return plannedpoprice;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("plannedmarginamt"))
      return plannedmarginamt;
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
  public static ServiceItem800003Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjectId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ServiceItem800003Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_ProjectLine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ProjectLine.CreatedBy) as CreatedByR, " +
      "        to_char(C_ProjectLine.Updated, ?) as updated, " +
      "        to_char(C_ProjectLine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_ProjectLine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ProjectLine.UpdatedBy) as UpdatedByR," +
      "        C_ProjectLine.DoPricing, " +
      "C_ProjectLine.C_Order_ID, " +
      "C_ProjectLine.CommittedAmt, " +
      "C_ProjectLine.C_OrderPO_ID, " +
      "C_ProjectLine.CommittedQty, " +
      "C_ProjectLine.InvoicedAmt, " +
      "C_ProjectLine.InvoicedQty, " +
      "COALESCE(C_ProjectLine.IsPrinted, 'N') AS IsPrinted, " +
      "COALESCE(C_ProjectLine.Processed, 'N') AS Processed, " +
      "C_ProjectLine.C_ProjectIssue_ID, " +
      "C_ProjectLine.C_ProjectLine_ID, " +
      "C_ProjectLine.M_Product_Category_ID, " +
      "C_ProjectLine.AD_Client_ID, " +
      "(CASE WHEN C_ProjectLine.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "C_ProjectLine.AD_Org_ID, " +
      "(CASE WHEN C_ProjectLine.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_ProjectLine.C_Project_ID, " +
      "(CASE WHEN C_ProjectLine.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "C_ProjectLine.Line, " +
      "COALESCE(C_ProjectLine.IsActive, 'N') AS IsActive, " +
      "C_ProjectLine.Description, " +
      "C_ProjectLine.M_Product_ID, " +
      "(CASE WHEN C_ProjectLine.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "C_ProjectLine.Product_Value, " +
      "C_ProjectLine.Product_Name, " +
      "C_ProjectLine.Product_Description, " +
      "C_ProjectLine.PlannedQty, " +
      "C_ProjectLine.C_Tax_ID, " +
      "(CASE WHEN C_ProjectLine.C_Tax_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_Tax_IDR, " +
      "C_ProjectLine.PlannedPrice, " +
      "C_ProjectLine.Plannedpoprice, " +
      "C_ProjectLine.PlannedAmt, " +
      "C_ProjectLine.PlannedMarginAmt, " +
      "        ? AS LANGUAGE " +
      "        FROM C_ProjectLine left join (select AD_Client_ID, Name from AD_Client) table1 on (C_ProjectLine.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (C_ProjectLine.AD_Org_ID = table2.AD_Org_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (C_ProjectLine.C_Project_ID = table3.C_Project_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (C_ProjectLine.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join (select C_Tax_ID, Name from C_Tax) table5 on (C_ProjectLine.C_Tax_ID =  table5.C_Tax_ID) left join (select C_Tax_ID,AD_Language, Name from C_Tax_TRL) tableTRL5 on (table5.C_Tax_ID = tableTRL5.C_Tax_ID and tableTRL5.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND C_ProjectLine.C_Project_ID = ?  ");
    strSql = strSql + 
      "        AND C_ProjectLine.C_ProjectLine_ID = ? " +
      "        AND C_ProjectLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_ProjectLine.AD_Org_ID IN (";
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
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
        ServiceItem800003Data objectServiceItem800003Data = new ServiceItem800003Data();
        objectServiceItem800003Data.created = UtilSql.getValue(result, "created");
        objectServiceItem800003Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectServiceItem800003Data.updated = UtilSql.getValue(result, "updated");
        objectServiceItem800003Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectServiceItem800003Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectServiceItem800003Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectServiceItem800003Data.dopricing = UtilSql.getValue(result, "dopricing");
        objectServiceItem800003Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectServiceItem800003Data.committedamt = UtilSql.getValue(result, "committedamt");
        objectServiceItem800003Data.cOrderpoId = UtilSql.getValue(result, "c_orderpo_id");
        objectServiceItem800003Data.committedqty = UtilSql.getValue(result, "committedqty");
        objectServiceItem800003Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectServiceItem800003Data.invoicedqty = UtilSql.getValue(result, "invoicedqty");
        objectServiceItem800003Data.isprinted = UtilSql.getValue(result, "isprinted");
        objectServiceItem800003Data.processed = UtilSql.getValue(result, "processed");
        objectServiceItem800003Data.cProjectissueId = UtilSql.getValue(result, "c_projectissue_id");
        objectServiceItem800003Data.cProjectlineId = UtilSql.getValue(result, "c_projectline_id");
        objectServiceItem800003Data.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectServiceItem800003Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectServiceItem800003Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectServiceItem800003Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectServiceItem800003Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectServiceItem800003Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectServiceItem800003Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectServiceItem800003Data.line = UtilSql.getValue(result, "line");
        objectServiceItem800003Data.isactive = UtilSql.getValue(result, "isactive");
        objectServiceItem800003Data.description = UtilSql.getValue(result, "description");
        objectServiceItem800003Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectServiceItem800003Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectServiceItem800003Data.productValue = UtilSql.getValue(result, "product_value");
        objectServiceItem800003Data.productName = UtilSql.getValue(result, "product_name");
        objectServiceItem800003Data.productDescription = UtilSql.getValue(result, "product_description");
        objectServiceItem800003Data.plannedqty = UtilSql.getValue(result, "plannedqty");
        objectServiceItem800003Data.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectServiceItem800003Data.cTaxIdr = UtilSql.getValue(result, "c_tax_idr");
        objectServiceItem800003Data.plannedprice = UtilSql.getValue(result, "plannedprice");
        objectServiceItem800003Data.plannedpoprice = UtilSql.getValue(result, "plannedpoprice");
        objectServiceItem800003Data.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectServiceItem800003Data.plannedmarginamt = UtilSql.getValue(result, "plannedmarginamt");
        objectServiceItem800003Data.language = UtilSql.getValue(result, "language");
        objectServiceItem800003Data.adUserClient = "";
        objectServiceItem800003Data.adOrgClient = "";
        objectServiceItem800003Data.createdby = "";
        objectServiceItem800003Data.trBgcolor = "";
        objectServiceItem800003Data.totalCount = "";
        objectServiceItem800003Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectServiceItem800003Data);
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
    ServiceItem800003Data objectServiceItem800003Data[] = new ServiceItem800003Data[vector.size()];
    vector.copyInto(objectServiceItem800003Data);
    return(objectServiceItem800003Data);
  }

/**
Create a registry
 */
  public static ServiceItem800003Data[] set(String cProjectId, String mProductId, String mProductIdr, String mProductCategoryId, String description, String committedqty, String cTaxId, String committedamt, String createdby, String createdbyr, String isactive, String adClientId, String productValue, String plannedprice, String processed, String plannedpoprice, String cOrderpoId, String productName, String updatedby, String updatedbyr, String cProjectissueId, String cOrderId, String productDescription, String plannedmarginamt, String plannedqty, String isprinted, String plannedamt, String invoicedqty, String dopricing, String line, String invoicedamt, String cProjectlineId, String adOrgId)    throws ServletException {
    ServiceItem800003Data objectServiceItem800003Data[] = new ServiceItem800003Data[1];
    objectServiceItem800003Data[0] = new ServiceItem800003Data();
    objectServiceItem800003Data[0].created = "";
    objectServiceItem800003Data[0].createdbyr = createdbyr;
    objectServiceItem800003Data[0].updated = "";
    objectServiceItem800003Data[0].updatedTimeStamp = "";
    objectServiceItem800003Data[0].updatedby = updatedby;
    objectServiceItem800003Data[0].updatedbyr = updatedbyr;
    objectServiceItem800003Data[0].dopricing = dopricing;
    objectServiceItem800003Data[0].cOrderId = cOrderId;
    objectServiceItem800003Data[0].committedamt = committedamt;
    objectServiceItem800003Data[0].cOrderpoId = cOrderpoId;
    objectServiceItem800003Data[0].committedqty = committedqty;
    objectServiceItem800003Data[0].invoicedamt = invoicedamt;
    objectServiceItem800003Data[0].invoicedqty = invoicedqty;
    objectServiceItem800003Data[0].isprinted = isprinted;
    objectServiceItem800003Data[0].processed = processed;
    objectServiceItem800003Data[0].cProjectissueId = cProjectissueId;
    objectServiceItem800003Data[0].cProjectlineId = cProjectlineId;
    objectServiceItem800003Data[0].mProductCategoryId = mProductCategoryId;
    objectServiceItem800003Data[0].adClientId = adClientId;
    objectServiceItem800003Data[0].adClientIdr = "";
    objectServiceItem800003Data[0].adOrgId = adOrgId;
    objectServiceItem800003Data[0].adOrgIdr = "";
    objectServiceItem800003Data[0].cProjectId = cProjectId;
    objectServiceItem800003Data[0].cProjectIdr = "";
    objectServiceItem800003Data[0].line = line;
    objectServiceItem800003Data[0].isactive = isactive;
    objectServiceItem800003Data[0].description = description;
    objectServiceItem800003Data[0].mProductId = mProductId;
    objectServiceItem800003Data[0].mProductIdr = mProductIdr;
    objectServiceItem800003Data[0].productValue = productValue;
    objectServiceItem800003Data[0].productName = productName;
    objectServiceItem800003Data[0].productDescription = productDescription;
    objectServiceItem800003Data[0].plannedqty = plannedqty;
    objectServiceItem800003Data[0].cTaxId = cTaxId;
    objectServiceItem800003Data[0].cTaxIdr = "";
    objectServiceItem800003Data[0].plannedprice = plannedprice;
    objectServiceItem800003Data[0].plannedpoprice = plannedpoprice;
    objectServiceItem800003Data[0].plannedamt = plannedamt;
    objectServiceItem800003Data[0].plannedmarginamt = plannedmarginamt;
    objectServiceItem800003Data[0].language = "";
    return objectServiceItem800003Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5775_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef5763_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef5765_2(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef5767(ConnectionProvider connectionProvider, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM C_ProjectLine WHERE C_Project_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
      "        SELECT C_ProjectLine.C_Project_ID AS NAME" +
      "        FROM C_ProjectLine" +
      "        WHERE C_ProjectLine.C_ProjectLine_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_Project.C_Project_ID = table1.C_Project_ID) WHERE C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_Project.C_Project_ID = table1.C_Project_ID) WHERE C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
      "        UPDATE C_ProjectLine" +
      "        SET DoPricing = (?) , C_Order_ID = (?) , CommittedAmt = TO_NUMBER(?) , C_OrderPO_ID = (?) , CommittedQty = TO_NUMBER(?) , InvoicedAmt = TO_NUMBER(?) , InvoicedQty = TO_NUMBER(?) , IsPrinted = (?) , Processed = (?) , C_ProjectIssue_ID = (?) , C_ProjectLine_ID = (?) , M_Product_Category_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , C_Project_ID = (?) , Line = TO_NUMBER(?) , IsActive = (?) , Description = (?) , M_Product_ID = (?) , Product_Value = (?) , Product_Name = (?) , Product_Description = (?) , PlannedQty = TO_NUMBER(?) , C_Tax_ID = (?) , PlannedPrice = TO_NUMBER(?) , Plannedpoprice = TO_NUMBER(?) , PlannedAmt = TO_NUMBER(?) , PlannedMarginAmt = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE C_ProjectLine.C_ProjectLine_ID = ? " +
      "                 AND C_ProjectLine.C_Project_ID = ? " +
      "        AND C_ProjectLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ProjectLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dopricing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderpoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectissueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productDescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
      "        INSERT INTO C_ProjectLine " +
      "        (DoPricing, C_Order_ID, CommittedAmt, C_OrderPO_ID, CommittedQty, InvoicedAmt, InvoicedQty, IsPrinted, Processed, C_ProjectIssue_ID, C_ProjectLine_ID, M_Product_Category_ID, AD_Client_ID, AD_Org_ID, C_Project_ID, Line, IsActive, Description, M_Product_ID, Product_Value, Product_Name, Product_Description, PlannedQty, C_Tax_ID, PlannedPrice, Plannedpoprice, PlannedAmt, PlannedMarginAmt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dopricing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderpoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectissueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productName);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productDescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedpoprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjectId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ProjectLine" +
      "        WHERE C_ProjectLine.C_ProjectLine_ID = ? " +
      "                 AND C_ProjectLine.C_Project_ID = ? " +
      "        AND C_ProjectLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ProjectLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ProjectLine" +
      "        WHERE C_ProjectLine.C_ProjectLine_ID = ? " +
      "                 AND C_ProjectLine.C_Project_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
      "          FROM C_ProjectLine" +
      "         WHERE C_ProjectLine.C_ProjectLine_ID = ? ";

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
      "          FROM C_ProjectLine" +
      "         WHERE C_ProjectLine.C_ProjectLine_ID = ? ";

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

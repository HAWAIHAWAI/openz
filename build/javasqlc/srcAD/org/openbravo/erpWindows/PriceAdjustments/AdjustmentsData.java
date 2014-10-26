//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PriceAdjustments;

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
class AdjustmentsData implements FieldProvider {
static Logger log4j = Logger.getLogger(AdjustmentsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mOfferId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String isactive;
  public String issalesoffer;
  public String directpurchasecalc;
  public String datefrom;
  public String dateto;
  public String qtyFrom;
  public String qtyTo;
  public String priority;
  public String discount;
  public String addamt;
  public String fixed;
  public String bpGroupSelection;
  public String bpGroupSelectionr;
  public String bpartnerSelection;
  public String bpartnerSelectionr;
  public String prodCatSelection;
  public String prodCatSelectionr;
  public String productSelection;
  public String productSelectionr;
  public String pricelistSelection;
  public String pricelistSelectionr;
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
    else if (fieldName.equalsIgnoreCase("m_offer_id") || fieldName.equals("mOfferId"))
      return mOfferId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("issalesoffer"))
      return issalesoffer;
    else if (fieldName.equalsIgnoreCase("directpurchasecalc"))
      return directpurchasecalc;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("qty_from") || fieldName.equals("qtyFrom"))
      return qtyFrom;
    else if (fieldName.equalsIgnoreCase("qty_to") || fieldName.equals("qtyTo"))
      return qtyTo;
    else if (fieldName.equalsIgnoreCase("priority"))
      return priority;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("addamt"))
      return addamt;
    else if (fieldName.equalsIgnoreCase("fixed"))
      return fixed;
    else if (fieldName.equalsIgnoreCase("bp_group_selection") || fieldName.equals("bpGroupSelection"))
      return bpGroupSelection;
    else if (fieldName.equalsIgnoreCase("bp_group_selectionr") || fieldName.equals("bpGroupSelectionr"))
      return bpGroupSelectionr;
    else if (fieldName.equalsIgnoreCase("bpartner_selection") || fieldName.equals("bpartnerSelection"))
      return bpartnerSelection;
    else if (fieldName.equalsIgnoreCase("bpartner_selectionr") || fieldName.equals("bpartnerSelectionr"))
      return bpartnerSelectionr;
    else if (fieldName.equalsIgnoreCase("prod_cat_selection") || fieldName.equals("prodCatSelection"))
      return prodCatSelection;
    else if (fieldName.equalsIgnoreCase("prod_cat_selectionr") || fieldName.equals("prodCatSelectionr"))
      return prodCatSelectionr;
    else if (fieldName.equalsIgnoreCase("product_selection") || fieldName.equals("productSelection"))
      return productSelection;
    else if (fieldName.equalsIgnoreCase("product_selectionr") || fieldName.equals("productSelectionr"))
      return productSelectionr;
    else if (fieldName.equalsIgnoreCase("pricelist_selection") || fieldName.equals("pricelistSelection"))
      return pricelistSelection;
    else if (fieldName.equalsIgnoreCase("pricelist_selectionr") || fieldName.equals("pricelistSelectionr"))
      return pricelistSelectionr;
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
  public static AdjustmentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static AdjustmentsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_Offer.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Offer.CreatedBy) as CreatedByR, " +
      "        to_char(M_Offer.Updated, ?) as updated, " +
      "        to_char(M_Offer.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_Offer.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_Offer.UpdatedBy) as UpdatedByR," +
      "        M_Offer.M_Offer_ID, " +
      "M_Offer.AD_Client_ID, " +
      "(CASE WHEN M_Offer.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "M_Offer.AD_Org_ID, " +
      "(CASE WHEN M_Offer.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_Offer.Name, " +
      "M_Offer.Description, " +
      "COALESCE(M_Offer.IsActive, 'N') AS IsActive, " +
      "COALESCE(M_Offer.IsSalesOffer, 'N') AS IsSalesOffer, " +
      "COALESCE(M_Offer.DirectPurchaseCalc, 'N') AS DirectPurchaseCalc, " +
      "M_Offer.DateFrom, " +
      "M_Offer.DateTo, " +
      "M_Offer.Qty_From, " +
      "M_Offer.Qty_To, " +
      "M_Offer.Priority, " +
      "M_Offer.Discount, " +
      "M_Offer.Addamt, " +
      "M_Offer.Fixed, " +
      "M_Offer.BP_Group_Selection, " +
      "(CASE WHEN M_Offer.BP_Group_Selection IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS BP_Group_SelectionR, " +
      "M_Offer.BPartner_Selection, " +
      "(CASE WHEN M_Offer.BPartner_Selection IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS BPartner_SelectionR, " +
      "M_Offer.Prod_Cat_Selection, " +
      "(CASE WHEN M_Offer.Prod_Cat_Selection IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Prod_Cat_SelectionR, " +
      "M_Offer.Product_Selection, " +
      "(CASE WHEN M_Offer.Product_Selection IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS Product_SelectionR, " +
      "M_Offer.Pricelist_Selection, " +
      "(CASE WHEN M_Offer.Pricelist_Selection IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS Pricelist_SelectionR, " +
      "        ? AS LANGUAGE " +
      "        FROM M_Offer left join (select AD_Client_ID, Name from AD_Client) table1 on (M_Offer.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (M_Offer.AD_Org_ID = table2.AD_Org_ID) left join ad_ref_list_v list1 on (M_Offer.BP_Group_Selection = list1.value and list1.ad_reference_id = '800029' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (M_Offer.BPartner_Selection = list2.value and list2.ad_reference_id = '800029' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (M_Offer.Prod_Cat_Selection = list3.value and list3.ad_reference_id = '800029' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (M_Offer.Product_Selection = list4.value and list4.ad_reference_id = '800029' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (M_Offer.Pricelist_Selection = list5.value and list5.ad_reference_id = '800029' and list5.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND M_Offer.M_Offer_ID = ? " +
      "        AND M_Offer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_Offer.AD_Org_ID IN (";
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
        AdjustmentsData objectAdjustmentsData = new AdjustmentsData();
        objectAdjustmentsData.created = UtilSql.getValue(result, "created");
        objectAdjustmentsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectAdjustmentsData.updated = UtilSql.getValue(result, "updated");
        objectAdjustmentsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectAdjustmentsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectAdjustmentsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectAdjustmentsData.mOfferId = UtilSql.getValue(result, "m_offer_id");
        objectAdjustmentsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAdjustmentsData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectAdjustmentsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAdjustmentsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectAdjustmentsData.name = UtilSql.getValue(result, "name");
        objectAdjustmentsData.description = UtilSql.getValue(result, "description");
        objectAdjustmentsData.isactive = UtilSql.getValue(result, "isactive");
        objectAdjustmentsData.issalesoffer = UtilSql.getValue(result, "issalesoffer");
        objectAdjustmentsData.directpurchasecalc = UtilSql.getValue(result, "directpurchasecalc");
        objectAdjustmentsData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectAdjustmentsData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectAdjustmentsData.qtyFrom = UtilSql.getValue(result, "qty_from");
        objectAdjustmentsData.qtyTo = UtilSql.getValue(result, "qty_to");
        objectAdjustmentsData.priority = UtilSql.getValue(result, "priority");
        objectAdjustmentsData.discount = UtilSql.getValue(result, "discount");
        objectAdjustmentsData.addamt = UtilSql.getValue(result, "addamt");
        objectAdjustmentsData.fixed = UtilSql.getValue(result, "fixed");
        objectAdjustmentsData.bpGroupSelection = UtilSql.getValue(result, "bp_group_selection");
        objectAdjustmentsData.bpGroupSelectionr = UtilSql.getValue(result, "bp_group_selectionr");
        objectAdjustmentsData.bpartnerSelection = UtilSql.getValue(result, "bpartner_selection");
        objectAdjustmentsData.bpartnerSelectionr = UtilSql.getValue(result, "bpartner_selectionr");
        objectAdjustmentsData.prodCatSelection = UtilSql.getValue(result, "prod_cat_selection");
        objectAdjustmentsData.prodCatSelectionr = UtilSql.getValue(result, "prod_cat_selectionr");
        objectAdjustmentsData.productSelection = UtilSql.getValue(result, "product_selection");
        objectAdjustmentsData.productSelectionr = UtilSql.getValue(result, "product_selectionr");
        objectAdjustmentsData.pricelistSelection = UtilSql.getValue(result, "pricelist_selection");
        objectAdjustmentsData.pricelistSelectionr = UtilSql.getValue(result, "pricelist_selectionr");
        objectAdjustmentsData.language = UtilSql.getValue(result, "language");
        objectAdjustmentsData.adUserClient = "";
        objectAdjustmentsData.adOrgClient = "";
        objectAdjustmentsData.createdby = "";
        objectAdjustmentsData.trBgcolor = "";
        objectAdjustmentsData.totalCount = "";
        objectAdjustmentsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAdjustmentsData);
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
    AdjustmentsData objectAdjustmentsData[] = new AdjustmentsData[vector.size()];
    vector.copyInto(objectAdjustmentsData);
    return(objectAdjustmentsData);
  }

/**
Create a registry
 */
  public static AdjustmentsData[] set(String name, String createdby, String createdbyr, String bpGroupSelection, String addamt, String issalesoffer, String prodCatSelection, String description, String discount, String adOrgId, String isactive, String bpartnerSelection, String productSelection, String qtyFrom, String qtyTo, String mOfferId, String adClientId, String updatedby, String updatedbyr, String fixed, String directpurchasecalc, String datefrom, String priority, String pricelistSelection, String dateto)    throws ServletException {
    AdjustmentsData objectAdjustmentsData[] = new AdjustmentsData[1];
    objectAdjustmentsData[0] = new AdjustmentsData();
    objectAdjustmentsData[0].created = "";
    objectAdjustmentsData[0].createdbyr = createdbyr;
    objectAdjustmentsData[0].updated = "";
    objectAdjustmentsData[0].updatedTimeStamp = "";
    objectAdjustmentsData[0].updatedby = updatedby;
    objectAdjustmentsData[0].updatedbyr = updatedbyr;
    objectAdjustmentsData[0].mOfferId = mOfferId;
    objectAdjustmentsData[0].adClientId = adClientId;
    objectAdjustmentsData[0].adClientIdr = "";
    objectAdjustmentsData[0].adOrgId = adOrgId;
    objectAdjustmentsData[0].adOrgIdr = "";
    objectAdjustmentsData[0].name = name;
    objectAdjustmentsData[0].description = description;
    objectAdjustmentsData[0].isactive = isactive;
    objectAdjustmentsData[0].issalesoffer = issalesoffer;
    objectAdjustmentsData[0].directpurchasecalc = directpurchasecalc;
    objectAdjustmentsData[0].datefrom = datefrom;
    objectAdjustmentsData[0].dateto = dateto;
    objectAdjustmentsData[0].qtyFrom = qtyFrom;
    objectAdjustmentsData[0].qtyTo = qtyTo;
    objectAdjustmentsData[0].priority = priority;
    objectAdjustmentsData[0].discount = discount;
    objectAdjustmentsData[0].addamt = addamt;
    objectAdjustmentsData[0].fixed = fixed;
    objectAdjustmentsData[0].bpGroupSelection = bpGroupSelection;
    objectAdjustmentsData[0].bpGroupSelectionr = "";
    objectAdjustmentsData[0].bpartnerSelection = bpartnerSelection;
    objectAdjustmentsData[0].bpartnerSelectionr = "";
    objectAdjustmentsData[0].prodCatSelection = prodCatSelection;
    objectAdjustmentsData[0].prodCatSelectionr = "";
    objectAdjustmentsData[0].productSelection = productSelection;
    objectAdjustmentsData[0].productSelectionr = "";
    objectAdjustmentsData[0].pricelistSelection = pricelistSelection;
    objectAdjustmentsData[0].pricelistSelectionr = "";
    objectAdjustmentsData[0].language = "";
    return objectAdjustmentsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef801109_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

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
  public static String selectDef801111_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

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
      "        UPDATE M_Offer" +
      "        SET M_Offer_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , IsSalesOffer = (?) , DirectPurchaseCalc = (?) , DateFrom = TO_DATE(?) , DateTo = TO_DATE(?) , Qty_From = TO_NUMBER(?) , Qty_To = TO_NUMBER(?) , Priority = TO_NUMBER(?) , Discount = TO_NUMBER(?) , Addamt = TO_NUMBER(?) , Fixed = TO_NUMBER(?) , BP_Group_Selection = (?) , BPartner_Selection = (?) , Prod_Cat_Selection = (?) , Product_Selection = (?) , Pricelist_Selection = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_Offer.M_Offer_ID = ? " +
      "        AND M_Offer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Offer.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issalesoffer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directpurchasecalc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priority);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpGroupSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prodCatSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
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
      "        INSERT INTO M_Offer " +
      "        (M_Offer_ID, AD_Client_ID, AD_Org_ID, Name, Description, IsActive, IsSalesOffer, DirectPurchaseCalc, DateFrom, DateTo, Qty_From, Qty_To, Priority, Discount, Addamt, Fixed, BP_Group_Selection, BPartner_Selection, Prod_Cat_Selection, Product_Selection, Pricelist_Selection, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mOfferId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issalesoffer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, directpurchasecalc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priority);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpGroupSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartnerSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, prodCatSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productSelection);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistSelection);
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
      "        DELETE FROM M_Offer" +
      "        WHERE M_Offer.M_Offer_ID = ? " +
      "        AND M_Offer.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_Offer.AD_Org_ID IN (";
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
      "        DELETE FROM M_Offer" +
      "        WHERE M_Offer.M_Offer_ID = ? ";

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
      "          FROM M_Offer" +
      "         WHERE M_Offer.M_Offer_ID = ? ";

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
      "          FROM M_Offer" +
      "         WHERE M_Offer.M_Offer_ID = ? ";

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

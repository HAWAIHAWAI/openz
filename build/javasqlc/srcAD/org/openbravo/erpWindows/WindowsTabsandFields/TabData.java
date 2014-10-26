//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.WindowsTabsandFields;

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
class TabData implements FieldProvider {
static Logger log4j = Logger.getLogger(TabData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adImageId;
  public String includedTabId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String editreference;
  public String adWindowId;
  public String adWindowIdr;
  public String adModuleId;
  public String adModuleIdr;
  public String name;
  public String description;
  public String help;
  public String isactive;
  public String adTableId;
  public String adTableIdr;
  public String seqno;
  public String tablevel;
  public String issinglerow;
  public String uipattern;
  public String uipatternr;
  public String hastree;
  public String isinfotab;
  public String istranslationtab;
  public String issorttab;
  public String adColumnsortorderId;
  public String adColumnsortorderIdr;
  public String adColumnsortyesnoId;
  public String adColumnsortyesnoIdr;
  public String adColumnId;
  public String adColumnIdr;
  public String adProcessId;
  public String adProcessIdr;
  public String commitwarning;
  public String whereclause;
  public String filterclause;
  public String orderbyclause;
  public String lefttabsmode;
  public String lefttabsmoder;
  public String adRelationtoolbar;
  public String adRelationtoolbarr;
  public String adEditiontoolbar;
  public String adEditiontoolbarr;
  public String manualservletclass;
  public String relationmanual;
  public String editionmanual;
  public String isstandalone;
  public String importfields;
  public String processing;
  public String createcustom;
  public String dropcustom;
  public String adTabId;
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
    else if (fieldName.equalsIgnoreCase("ad_image_id") || fieldName.equals("adImageId"))
      return adImageId;
    else if (fieldName.equalsIgnoreCase("included_tab_id") || fieldName.equals("includedTabId"))
      return includedTabId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("editreference"))
      return editreference;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("ad_window_idr") || fieldName.equals("adWindowIdr"))
      return adWindowIdr;
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("tablevel"))
      return tablevel;
    else if (fieldName.equalsIgnoreCase("issinglerow"))
      return issinglerow;
    else if (fieldName.equalsIgnoreCase("uipattern"))
      return uipattern;
    else if (fieldName.equalsIgnoreCase("uipatternr"))
      return uipatternr;
    else if (fieldName.equalsIgnoreCase("hastree"))
      return hastree;
    else if (fieldName.equalsIgnoreCase("isinfotab"))
      return isinfotab;
    else if (fieldName.equalsIgnoreCase("istranslationtab"))
      return istranslationtab;
    else if (fieldName.equalsIgnoreCase("issorttab"))
      return issorttab;
    else if (fieldName.equalsIgnoreCase("ad_columnsortorder_id") || fieldName.equals("adColumnsortorderId"))
      return adColumnsortorderId;
    else if (fieldName.equalsIgnoreCase("ad_columnsortorder_idr") || fieldName.equals("adColumnsortorderIdr"))
      return adColumnsortorderIdr;
    else if (fieldName.equalsIgnoreCase("ad_columnsortyesno_id") || fieldName.equals("adColumnsortyesnoId"))
      return adColumnsortyesnoId;
    else if (fieldName.equalsIgnoreCase("ad_columnsortyesno_idr") || fieldName.equals("adColumnsortyesnoIdr"))
      return adColumnsortyesnoIdr;
    else if (fieldName.equalsIgnoreCase("ad_column_id") || fieldName.equals("adColumnId"))
      return adColumnId;
    else if (fieldName.equalsIgnoreCase("ad_column_idr") || fieldName.equals("adColumnIdr"))
      return adColumnIdr;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("commitwarning"))
      return commitwarning;
    else if (fieldName.equalsIgnoreCase("whereclause"))
      return whereclause;
    else if (fieldName.equalsIgnoreCase("filterclause"))
      return filterclause;
    else if (fieldName.equalsIgnoreCase("orderbyclause"))
      return orderbyclause;
    else if (fieldName.equalsIgnoreCase("lefttabsmode"))
      return lefttabsmode;
    else if (fieldName.equalsIgnoreCase("lefttabsmoder"))
      return lefttabsmoder;
    else if (fieldName.equalsIgnoreCase("ad_relationtoolbar") || fieldName.equals("adRelationtoolbar"))
      return adRelationtoolbar;
    else if (fieldName.equalsIgnoreCase("ad_relationtoolbarr") || fieldName.equals("adRelationtoolbarr"))
      return adRelationtoolbarr;
    else if (fieldName.equalsIgnoreCase("ad_editiontoolbar") || fieldName.equals("adEditiontoolbar"))
      return adEditiontoolbar;
    else if (fieldName.equalsIgnoreCase("ad_editiontoolbarr") || fieldName.equals("adEditiontoolbarr"))
      return adEditiontoolbarr;
    else if (fieldName.equalsIgnoreCase("manualservletclass"))
      return manualservletclass;
    else if (fieldName.equalsIgnoreCase("relationmanual"))
      return relationmanual;
    else if (fieldName.equalsIgnoreCase("editionmanual"))
      return editionmanual;
    else if (fieldName.equalsIgnoreCase("isstandalone"))
      return isstandalone;
    else if (fieldName.equalsIgnoreCase("importfields"))
      return importfields;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("createcustom"))
      return createcustom;
    else if (fieldName.equalsIgnoreCase("dropcustom"))
      return dropcustom;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
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
  public static TabData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adWindowId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adWindowId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TabData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adWindowId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Tab.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Tab.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Tab.Updated, ?) as updated, " +
      "        to_char(AD_Tab.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Tab.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Tab.UpdatedBy) as UpdatedByR," +
      "        AD_Tab.AD_Image_ID, " +
      "AD_Tab.Included_Tab_ID, " +
      "AD_Tab.AD_Client_ID, " +
      "(CASE WHEN AD_Tab.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "AD_Tab.AD_Org_ID, " +
      "(CASE WHEN AD_Tab.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Tab.EditReference, " +
      "AD_Tab.AD_Window_ID, " +
      "(CASE WHEN AD_Tab.AD_Window_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Window_IDR, " +
      "AD_Tab.AD_Module_ID, " +
      "(CASE WHEN AD_Tab.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "AD_Tab.Name, " +
      "AD_Tab.Description, " +
      "AD_Tab.Help, " +
      "COALESCE(AD_Tab.IsActive, 'N') AS IsActive, " +
      "AD_Tab.AD_Table_ID, " +
      "(CASE WHEN AD_Tab.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "AD_Tab.SeqNo, " +
      "AD_Tab.TabLevel, " +
      "COALESCE(AD_Tab.IsSingleRow, 'N') AS IsSingleRow, " +
      "AD_Tab.UIPattern, " +
      "(CASE WHEN AD_Tab.UIPattern IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS UIPatternR, " +
      "COALESCE(AD_Tab.HasTree, 'N') AS HasTree, " +
      "COALESCE(AD_Tab.IsInfoTab, 'N') AS IsInfoTab, " +
      "COALESCE(AD_Tab.IsTranslationTab, 'N') AS IsTranslationTab, " +
      "COALESCE(AD_Tab.IsSortTab, 'N') AS IsSortTab, " +
      "AD_Tab.AD_ColumnSortOrder_ID, " +
      "(CASE WHEN AD_Tab.AD_ColumnSortOrder_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.ColumnName), ''))),'') ) END) AS AD_ColumnSortOrder_IDR, " +
      "AD_Tab.AD_ColumnSortYesNo_ID, " +
      "(CASE WHEN AD_Tab.AD_ColumnSortYesNo_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.ColumnName), ''))),'') ) END) AS AD_ColumnSortYesNo_IDR, " +
      "AD_Tab.AD_Column_ID, " +
      "(CASE WHEN AD_Tab.AD_Column_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.ColumnName), ''))),'') ) END) AS AD_Column_IDR, " +
      "AD_Tab.AD_Process_ID, " +
      "(CASE WHEN AD_Tab.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "AD_Tab.CommitWarning, " +
      "AD_Tab.WhereClause, " +
      "AD_Tab.FilterClause, " +
      "AD_Tab.OrderByClause, " +
      "AD_Tab.Lefttabsmode, " +
      "(CASE WHEN AD_Tab.Lefttabsmode IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS LefttabsmodeR, " +
      "AD_Tab.AD_Relationtoolbar, " +
      "(CASE WHEN AD_Tab.AD_Relationtoolbar IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Value), ''))),'') ) END) AS AD_RelationtoolbarR, " +
      "AD_Tab.AD_Editiontoolbar, " +
      "(CASE WHEN AD_Tab.AD_Editiontoolbar IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Value), ''))),'') ) END) AS AD_EditiontoolbarR, " +
      "AD_Tab.Manualservletclass, " +
      "COALESCE(AD_Tab.Relationmanual, 'N') AS Relationmanual, " +
      "COALESCE(AD_Tab.Editionmanual, 'N') AS Editionmanual, " +
      "COALESCE(AD_Tab.Isstandalone, 'N') AS Isstandalone, " +
      "AD_Tab.ImportFields, " +
      "AD_Tab.Processing, " +
      "AD_Tab.Createcustom, " +
      "AD_Tab.Dropcustom, " +
      "AD_Tab.AD_Tab_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Tab left join (select AD_Client_ID, Name from AD_Client) table1 on (AD_Tab.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (AD_Tab.AD_Org_ID = table2.AD_Org_ID) left join (select AD_Window_ID, Name from AD_Window) table3 on (AD_Tab.AD_Window_ID = table3.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL3 on (table3.AD_Window_ID = tableTRL3.AD_Window_ID and tableTRL3.AD_Language = ?)  left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table4 on (AD_Tab.AD_Module_ID = table4.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table5 on (table4.AD_Language =  table5.AD_Language) left join (select AD_Table_ID, TableName from AD_Table) table6 on (AD_Tab.AD_Table_ID = table6.AD_Table_ID) left join ad_ref_list_v list1 on (AD_Tab.UIPattern = list1.value and list1.ad_reference_id = 'D15C950D445D408E8CC8135E530C246B' and list1.ad_language = ?)  left join (select AD_Column_ID, ColumnName from AD_Column) table7 on (AD_Tab.AD_ColumnSortOrder_ID =  table7.AD_Column_ID) left join (select AD_Column_ID, ColumnName from AD_Column) table8 on (AD_Tab.AD_ColumnSortYesNo_ID =  table8.AD_Column_ID) left join (select AD_Column_ID, ColumnName from AD_Column) table9 on (AD_Tab.AD_Column_ID = table9.AD_Column_ID) left join (select AD_Process_ID, Name from AD_Process) table10 on (AD_Tab.AD_Process_ID = table10.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL10 on (table10.AD_Process_ID = tableTRL10.AD_Process_ID and tableTRL10.AD_Language = ?)  left join ad_ref_list_v list2 on (AD_Tab.Lefttabsmode = list2.value and list2.ad_reference_id = 'EBB90F873C384B6C83574321FB08D8B6' and list2.ad_language = ?)  left join (select AD_Toolbar_ID, Value from ad_toolbar) table11 on (AD_Tab.AD_Relationtoolbar =  table11.AD_Toolbar_ID) left join (select AD_Toolbar_ID, Value from ad_toolbar) table12 on (AD_Tab.AD_Editiontoolbar =  table12.AD_Toolbar_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adWindowId==null || adWindowId.equals(""))?"":"  AND AD_Tab.AD_Window_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Tab.AD_Tab_ID = ? " +
      "        AND AD_Tab.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Tab.AD_Org_ID IN (";
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
      if (adWindowId != null && !(adWindowId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
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
        TabData objectTabData = new TabData();
        objectTabData.created = UtilSql.getValue(result, "created");
        objectTabData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTabData.updated = UtilSql.getValue(result, "updated");
        objectTabData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTabData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTabData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTabData.adImageId = UtilSql.getValue(result, "ad_image_id");
        objectTabData.includedTabId = UtilSql.getValue(result, "included_tab_id");
        objectTabData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTabData.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectTabData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTabData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectTabData.editreference = UtilSql.getValue(result, "editreference");
        objectTabData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectTabData.adWindowIdr = UtilSql.getValue(result, "ad_window_idr");
        objectTabData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectTabData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectTabData.name = UtilSql.getValue(result, "name");
        objectTabData.description = UtilSql.getValue(result, "description");
        objectTabData.help = UtilSql.getValue(result, "help");
        objectTabData.isactive = UtilSql.getValue(result, "isactive");
        objectTabData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectTabData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectTabData.seqno = UtilSql.getValue(result, "seqno");
        objectTabData.tablevel = UtilSql.getValue(result, "tablevel");
        objectTabData.issinglerow = UtilSql.getValue(result, "issinglerow");
        objectTabData.uipattern = UtilSql.getValue(result, "uipattern");
        objectTabData.uipatternr = UtilSql.getValue(result, "uipatternr");
        objectTabData.hastree = UtilSql.getValue(result, "hastree");
        objectTabData.isinfotab = UtilSql.getValue(result, "isinfotab");
        objectTabData.istranslationtab = UtilSql.getValue(result, "istranslationtab");
        objectTabData.issorttab = UtilSql.getValue(result, "issorttab");
        objectTabData.adColumnsortorderId = UtilSql.getValue(result, "ad_columnsortorder_id");
        objectTabData.adColumnsortorderIdr = UtilSql.getValue(result, "ad_columnsortorder_idr");
        objectTabData.adColumnsortyesnoId = UtilSql.getValue(result, "ad_columnsortyesno_id");
        objectTabData.adColumnsortyesnoIdr = UtilSql.getValue(result, "ad_columnsortyesno_idr");
        objectTabData.adColumnId = UtilSql.getValue(result, "ad_column_id");
        objectTabData.adColumnIdr = UtilSql.getValue(result, "ad_column_idr");
        objectTabData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectTabData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectTabData.commitwarning = UtilSql.getValue(result, "commitwarning");
        objectTabData.whereclause = UtilSql.getValue(result, "whereclause");
        objectTabData.filterclause = UtilSql.getValue(result, "filterclause");
        objectTabData.orderbyclause = UtilSql.getValue(result, "orderbyclause");
        objectTabData.lefttabsmode = UtilSql.getValue(result, "lefttabsmode");
        objectTabData.lefttabsmoder = UtilSql.getValue(result, "lefttabsmoder");
        objectTabData.adRelationtoolbar = UtilSql.getValue(result, "ad_relationtoolbar");
        objectTabData.adRelationtoolbarr = UtilSql.getValue(result, "ad_relationtoolbarr");
        objectTabData.adEditiontoolbar = UtilSql.getValue(result, "ad_editiontoolbar");
        objectTabData.adEditiontoolbarr = UtilSql.getValue(result, "ad_editiontoolbarr");
        objectTabData.manualservletclass = UtilSql.getValue(result, "manualservletclass");
        objectTabData.relationmanual = UtilSql.getValue(result, "relationmanual");
        objectTabData.editionmanual = UtilSql.getValue(result, "editionmanual");
        objectTabData.isstandalone = UtilSql.getValue(result, "isstandalone");
        objectTabData.importfields = UtilSql.getValue(result, "importfields");
        objectTabData.processing = UtilSql.getValue(result, "processing");
        objectTabData.createcustom = UtilSql.getValue(result, "createcustom");
        objectTabData.dropcustom = UtilSql.getValue(result, "dropcustom");
        objectTabData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectTabData.language = UtilSql.getValue(result, "language");
        objectTabData.adUserClient = "";
        objectTabData.adOrgClient = "";
        objectTabData.createdby = "";
        objectTabData.trBgcolor = "";
        objectTabData.totalCount = "";
        objectTabData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTabData);
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
    TabData objectTabData[] = new TabData[vector.size()];
    vector.copyInto(objectTabData);
    return(objectTabData);
  }

/**
Create a registry
 */
  public static TabData[] set(String adWindowId, String adTableId, String uipattern, String isinfotab, String isreadonly, String lefttabsmode, String updatedby, String updatedbyr, String adImageId, String seqno, String importfields, String adClientId, String issorttab, String name, String editionmanual, String adRelationtoolbar, String adProcessId, String description, String adModuleId, String hastree, String whereclause, String adColumnId, String manualservletclass, String isstandalone, String relationmanual, String commitwarning, String adColumnsortorderId, String help, String orderbyclause, String adColumnsortyesnoId, String createcustom, String dropcustom, String tablevel, String editreference, String adOrgId, String issinglerow, String adTabId, String includedTabId, String isactive, String filterclause, String istranslationtab, String adEditiontoolbar, String processing, String createdby, String createdbyr)    throws ServletException {
    TabData objectTabData[] = new TabData[1];
    objectTabData[0] = new TabData();
    objectTabData[0].created = "";
    objectTabData[0].createdbyr = createdbyr;
    objectTabData[0].updated = "";
    objectTabData[0].updatedTimeStamp = "";
    objectTabData[0].updatedby = updatedby;
    objectTabData[0].updatedbyr = updatedbyr;
    objectTabData[0].adImageId = adImageId;
    objectTabData[0].includedTabId = includedTabId;
    objectTabData[0].adClientId = adClientId;
    objectTabData[0].adClientIdr = "";
    objectTabData[0].adOrgId = adOrgId;
    objectTabData[0].adOrgIdr = "";
    objectTabData[0].editreference = editreference;
    objectTabData[0].adWindowId = adWindowId;
    objectTabData[0].adWindowIdr = "";
    objectTabData[0].adModuleId = adModuleId;
    objectTabData[0].adModuleIdr = "";
    objectTabData[0].name = name;
    objectTabData[0].description = description;
    objectTabData[0].help = help;
    objectTabData[0].isactive = isactive;
    objectTabData[0].adTableId = adTableId;
    objectTabData[0].adTableIdr = "";
    objectTabData[0].seqno = seqno;
    objectTabData[0].tablevel = tablevel;
    objectTabData[0].issinglerow = issinglerow;
    objectTabData[0].uipattern = uipattern;
    objectTabData[0].uipatternr = "";
    objectTabData[0].hastree = hastree;
    objectTabData[0].isinfotab = isinfotab;
    objectTabData[0].istranslationtab = istranslationtab;
    objectTabData[0].issorttab = issorttab;
    objectTabData[0].adColumnsortorderId = adColumnsortorderId;
    objectTabData[0].adColumnsortorderIdr = "";
    objectTabData[0].adColumnsortyesnoId = adColumnsortyesnoId;
    objectTabData[0].adColumnsortyesnoIdr = "";
    objectTabData[0].adColumnId = adColumnId;
    objectTabData[0].adColumnIdr = "";
    objectTabData[0].adProcessId = adProcessId;
    objectTabData[0].adProcessIdr = "";
    objectTabData[0].commitwarning = commitwarning;
    objectTabData[0].whereclause = whereclause;
    objectTabData[0].filterclause = filterclause;
    objectTabData[0].orderbyclause = orderbyclause;
    objectTabData[0].lefttabsmode = lefttabsmode;
    objectTabData[0].lefttabsmoder = "";
    objectTabData[0].adRelationtoolbar = adRelationtoolbar;
    objectTabData[0].adRelationtoolbarr = "";
    objectTabData[0].adEditiontoolbar = adEditiontoolbar;
    objectTabData[0].adEditiontoolbarr = "";
    objectTabData[0].manualservletclass = manualservletclass;
    objectTabData[0].relationmanual = relationmanual;
    objectTabData[0].editionmanual = editionmanual;
    objectTabData[0].isstandalone = isstandalone;
    objectTabData[0].importfields = importfields;
    objectTabData[0].processing = processing;
    objectTabData[0].createcustom = createcustom;
    objectTabData[0].dropcustom = dropcustom;
    objectTabData[0].adTabId = adTabId;
    objectTabData[0].language = "";
    return objectTabData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef577_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef165(ConnectionProvider connectionProvider, String AD_Window_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM AD_Tab WHERE AD_Window_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Window_ID);

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
Select for auxiliar field
 */
  public static String selectDef5661EC317B643D0FE040007F01004528(ConnectionProvider connectionProvider, String AD_Window_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_MODULE_ID FROM AD_WINDOW WHERE AD_WINDOW_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Window_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_module_id");
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
  public static String selectDef575_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_Tab.AD_Window_ID AS NAME" +
      "        FROM AD_Tab" +
      "        WHERE AD_Tab.AD_Tab_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Window left join (select AD_Window_ID, Name from AD_Window) table1 on (AD_Window.AD_Window_ID = table1.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL1 on (table1.AD_Window_ID = tableTRL1.AD_Window_ID and tableTRL1.AD_Language = ?)  WHERE AD_Window.AD_Window_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Window left join (select AD_Window_ID, Name from AD_Window) table1 on (AD_Window.AD_Window_ID = table1.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL1 on (table1.AD_Window_ID = tableTRL1.AD_Window_ID and tableTRL1.AD_Language = ?)  WHERE AD_Window.AD_Window_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
      "        UPDATE AD_Tab" +
      "        SET AD_Image_ID = (?) , Included_Tab_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , EditReference = (?) , AD_Window_ID = (?) , AD_Module_ID = (?) , Name = (?) , Description = (?) , Help = (?) , IsActive = (?) , AD_Table_ID = (?) , SeqNo = TO_NUMBER(?) , TabLevel = TO_NUMBER(?) , IsSingleRow = (?) , UIPattern = (?) , HasTree = (?) , IsInfoTab = (?) , IsTranslationTab = (?) , IsSortTab = (?) , AD_ColumnSortOrder_ID = (?) , AD_ColumnSortYesNo_ID = (?) , AD_Column_ID = (?) , AD_Process_ID = (?) , CommitWarning = (?) , WhereClause = (?) , FilterClause = (?) , OrderByClause = (?) , Lefttabsmode = (?) , AD_Relationtoolbar = (?) , AD_Editiontoolbar = (?) , Manualservletclass = (?) , Relationmanual = (?) , Editionmanual = (?) , Isstandalone = (?) , ImportFields = (?) , Processing = (?) , Createcustom = (?) , Dropcustom = (?) , AD_Tab_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Tab.AD_Tab_ID = ? " +
      "                 AND AD_Tab.AD_Window_ID = ? " +
      "        AND AD_Tab.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Tab.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includedTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issinglerow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uipattern);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hastree);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinfotab);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslationtab);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issorttab);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnsortorderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnsortyesnoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, commitwarning);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, whereclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, filterclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderbyclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lefttabsmode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRelationtoolbar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adEditiontoolbar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manualservletclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, relationmanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editionmanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstandalone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, importfields);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createcustom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropcustom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
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
      "        INSERT INTO AD_Tab " +
      "        (AD_Image_ID, Included_Tab_ID, AD_Client_ID, AD_Org_ID, EditReference, AD_Window_ID, AD_Module_ID, Name, Description, Help, IsActive, AD_Table_ID, SeqNo, TabLevel, IsSingleRow, UIPattern, HasTree, IsInfoTab, IsTranslationTab, IsSortTab, AD_ColumnSortOrder_ID, AD_ColumnSortYesNo_ID, AD_Column_ID, AD_Process_ID, CommitWarning, WhereClause, FilterClause, OrderByClause, Lefttabsmode, AD_Relationtoolbar, AD_Editiontoolbar, Manualservletclass, Relationmanual, Editionmanual, Isstandalone, ImportFields, Processing, Createcustom, Dropcustom, AD_Tab_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includedTabId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tablevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issinglerow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uipattern);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hastree);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinfotab);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslationtab);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issorttab);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnsortorderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnsortyesnoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adColumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, commitwarning);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, whereclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, filterclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderbyclause);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lefttabsmode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRelationtoolbar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adEditiontoolbar);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, manualservletclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, relationmanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editionmanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isstandalone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, importfields);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createcustom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropcustom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adWindowId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Tab" +
      "        WHERE AD_Tab.AD_Tab_ID = ? " +
      "                 AND AD_Tab.AD_Window_ID = ? " +
      "        AND AD_Tab.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Tab.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Tab" +
      "        WHERE AD_Tab.AD_Tab_ID = ? " +
      "                 AND AD_Tab.AD_Window_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
      "          FROM AD_Tab" +
      "         WHERE AD_Tab.AD_Tab_ID = ? ";

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
      "          FROM AD_Tab" +
      "         WHERE AD_Tab.AD_Tab_ID = ? ";

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

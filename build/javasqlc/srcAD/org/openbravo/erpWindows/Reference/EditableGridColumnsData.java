//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Reference;

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
class EditableGridColumnsData implements FieldProvider {
static Logger log4j = Logger.getLogger(EditableGridColumnsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefGroupId;
  public String adRefGroupIdr;
  public String adRefGridcolumnId;
  public String line;
  public String name;
  public String adClientId;
  public String adElementId;
  public String adElementIdr;
  public String adOrgId;
  public String readonly;
  public String isdisplayed;
  public String isactive;
  public String colspan;
  public String required;
  public String issecondheader;
  public String adReferenceId;
  public String maxlength;
  public String isinheader;
  public String headertext;
  public String colreference;
  public String colreferencer;
  public String referenceurl;
  public String adTableId;
  public String adTableIdr;
  public String adValRuleId;
  public String adValRuleIdr;
  public String includesemptyitem;
  public String template;
  public String templater;
  public String issplitgroup;
  public String defaultvalue;
  public String onchangeevent;
  public String readonlylogic;
  public String mandantorylogic;
  public String isrowkey;
  public String issortable;
  public String rowkeysuffix;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_group_id") || fieldName.equals("adRefGroupId"))
      return adRefGroupId;
    else if (fieldName.equalsIgnoreCase("ad_ref_group_idr") || fieldName.equals("adRefGroupIdr"))
      return adRefGroupIdr;
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumn_id") || fieldName.equals("adRefGridcolumnId"))
      return adRefGridcolumnId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_element_idr") || fieldName.equals("adElementIdr"))
      return adElementIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("readonly"))
      return readonly;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("colspan"))
      return colspan;
    else if (fieldName.equalsIgnoreCase("required"))
      return required;
    else if (fieldName.equalsIgnoreCase("issecondheader"))
      return issecondheader;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("isinheader"))
      return isinheader;
    else if (fieldName.equalsIgnoreCase("headertext"))
      return headertext;
    else if (fieldName.equalsIgnoreCase("colreference"))
      return colreference;
    else if (fieldName.equalsIgnoreCase("colreferencer"))
      return colreferencer;
    else if (fieldName.equalsIgnoreCase("referenceurl"))
      return referenceurl;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_table_idr") || fieldName.equals("adTableIdr"))
      return adTableIdr;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_idr") || fieldName.equals("adValRuleIdr"))
      return adValRuleIdr;
    else if (fieldName.equalsIgnoreCase("includesemptyitem"))
      return includesemptyitem;
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("templater"))
      return templater;
    else if (fieldName.equalsIgnoreCase("issplitgroup"))
      return issplitgroup;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("onchangeevent"))
      return onchangeevent;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("mandantorylogic"))
      return mandantorylogic;
    else if (fieldName.equalsIgnoreCase("isrowkey"))
      return isrowkey;
    else if (fieldName.equalsIgnoreCase("issortable"))
      return issortable;
    else if (fieldName.equalsIgnoreCase("rowkeysuffix"))
      return rowkeysuffix;
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
  public static EditableGridColumnsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefGroupId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefGroupId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static EditableGridColumnsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefGroupId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_gridcolumn.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_gridcolumn.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_gridcolumn.Updated, ?) as updated, " +
      "        to_char(ad_ref_gridcolumn.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_gridcolumn.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_gridcolumn.UpdatedBy) as UpdatedByR," +
      "        ad_ref_gridcolumn.AD_Ref_Group_ID, " +
      "(CASE WHEN ad_ref_gridcolumn.AD_Ref_Group_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Idcolumn), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Level), ''))),'') ) END) AS AD_Ref_Group_IDR, " +
      "ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID, " +
      "ad_ref_gridcolumn.Line, " +
      "ad_ref_gridcolumn.Name, " +
      "ad_ref_gridcolumn.AD_Client_ID, " +
      "ad_ref_gridcolumn.AD_Element_ID, " +
      "(CASE WHEN ad_ref_gridcolumn.AD_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.ColumnName), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Element_IDR, " +
      "ad_ref_gridcolumn.AD_Org_ID, " +
      "COALESCE(ad_ref_gridcolumn.ReadOnly, 'N') AS ReadOnly, " +
      "COALESCE(ad_ref_gridcolumn.Isdisplayed, 'N') AS Isdisplayed, " +
      "COALESCE(ad_ref_gridcolumn.Isactive, 'N') AS Isactive, " +
      "ad_ref_gridcolumn.Colspan, " +
      "COALESCE(ad_ref_gridcolumn.Required, 'N') AS Required, " +
      "COALESCE(ad_ref_gridcolumn.Issecondheader, 'N') AS Issecondheader, " +
      "ad_ref_gridcolumn.AD_Reference_ID, " +
      "ad_ref_gridcolumn.MaxLength, " +
      "COALESCE(ad_ref_gridcolumn.Isinheader, 'N') AS Isinheader, " +
      "ad_ref_gridcolumn.Headertext, " +
      "ad_ref_gridcolumn.colreference, " +
      "(CASE WHEN ad_ref_gridcolumn.colreference IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS colreferenceR, " +
      "ad_ref_gridcolumn.Referenceurl, " +
      "ad_ref_gridcolumn.AD_Table_ID, " +
      "(CASE WHEN ad_ref_gridcolumn.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "ad_ref_gridcolumn.AD_Val_Rule_ID, " +
      "(CASE WHEN ad_ref_gridcolumn.AD_Val_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS AD_Val_Rule_IDR, " +
      "COALESCE(ad_ref_gridcolumn.Includesemptyitem, 'N') AS Includesemptyitem, " +
      "ad_ref_gridcolumn.Template, " +
      "(CASE WHEN ad_ref_gridcolumn.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS TemplateR, " +
      "COALESCE(ad_ref_gridcolumn.Issplitgroup, 'N') AS Issplitgroup, " +
      "ad_ref_gridcolumn.Defaultvalue, " +
      "ad_ref_gridcolumn.Onchangeevent, " +
      "ad_ref_gridcolumn.Readonlylogic, " +
      "ad_ref_gridcolumn.Mandantorylogic, " +
      "COALESCE(ad_ref_gridcolumn.Isrowkey, 'N') AS Isrowkey, " +
      "COALESCE(ad_ref_gridcolumn.Issortable, 'N') AS Issortable, " +
      "ad_ref_gridcolumn.Rowkeysuffix, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_gridcolumn left join (select AD_Ref_Group_ID, AD_Reference_ID, Idcolumn, Level from AD_Ref_Group) table1 on (ad_ref_gridcolumn.AD_Ref_Group_ID = table1.AD_Ref_Group_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (table1.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  left join (select AD_Element_ID, ColumnName, Name from AD_Element) table3 on (ad_ref_gridcolumn.AD_Element_ID = table3.AD_Element_ID) left join (select AD_Reference_ID, Name from AD_Reference) table4 on (ad_ref_gridcolumn.colreference =  table4.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL4 on (table4.AD_Reference_ID = tableTRL4.AD_Reference_ID and tableTRL4.AD_Language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table5 on (ad_ref_gridcolumn.AD_Table_ID = table5.AD_Table_ID) left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table6 on (ad_ref_gridcolumn.AD_Val_Rule_ID = table6.AD_Val_Rule_ID) left join ad_ref_list_v list2 on (ad_ref_gridcolumn.Template = list2.value and list2.ad_reference_id = '93AAB50006A24AA4ADC854D6A0D8B716' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefGroupId==null || adRefGroupId.equals(""))?"":"  AND ad_ref_gridcolumn.AD_Ref_Group_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? " +
      "        AND ad_ref_gridcolumn.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_gridcolumn.AD_Org_ID IN (";
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
      if (adRefGroupId != null && !(adRefGroupId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
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
        EditableGridColumnsData objectEditableGridColumnsData = new EditableGridColumnsData();
        objectEditableGridColumnsData.created = UtilSql.getValue(result, "created");
        objectEditableGridColumnsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEditableGridColumnsData.updated = UtilSql.getValue(result, "updated");
        objectEditableGridColumnsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEditableGridColumnsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEditableGridColumnsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEditableGridColumnsData.adRefGroupId = UtilSql.getValue(result, "ad_ref_group_id");
        objectEditableGridColumnsData.adRefGroupIdr = UtilSql.getValue(result, "ad_ref_group_idr");
        objectEditableGridColumnsData.adRefGridcolumnId = UtilSql.getValue(result, "ad_ref_gridcolumn_id");
        objectEditableGridColumnsData.line = UtilSql.getValue(result, "line");
        objectEditableGridColumnsData.name = UtilSql.getValue(result, "name");
        objectEditableGridColumnsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEditableGridColumnsData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectEditableGridColumnsData.adElementIdr = UtilSql.getValue(result, "ad_element_idr");
        objectEditableGridColumnsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEditableGridColumnsData.readonly = UtilSql.getValue(result, "readonly");
        objectEditableGridColumnsData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectEditableGridColumnsData.isactive = UtilSql.getValue(result, "isactive");
        objectEditableGridColumnsData.colspan = UtilSql.getValue(result, "colspan");
        objectEditableGridColumnsData.required = UtilSql.getValue(result, "required");
        objectEditableGridColumnsData.issecondheader = UtilSql.getValue(result, "issecondheader");
        objectEditableGridColumnsData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectEditableGridColumnsData.maxlength = UtilSql.getValue(result, "maxlength");
        objectEditableGridColumnsData.isinheader = UtilSql.getValue(result, "isinheader");
        objectEditableGridColumnsData.headertext = UtilSql.getValue(result, "headertext");
        objectEditableGridColumnsData.colreference = UtilSql.getValue(result, "colreference");
        objectEditableGridColumnsData.colreferencer = UtilSql.getValue(result, "colreferencer");
        objectEditableGridColumnsData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectEditableGridColumnsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectEditableGridColumnsData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectEditableGridColumnsData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectEditableGridColumnsData.adValRuleIdr = UtilSql.getValue(result, "ad_val_rule_idr");
        objectEditableGridColumnsData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectEditableGridColumnsData.template = UtilSql.getValue(result, "template");
        objectEditableGridColumnsData.templater = UtilSql.getValue(result, "templater");
        objectEditableGridColumnsData.issplitgroup = UtilSql.getValue(result, "issplitgroup");
        objectEditableGridColumnsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectEditableGridColumnsData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectEditableGridColumnsData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectEditableGridColumnsData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectEditableGridColumnsData.isrowkey = UtilSql.getValue(result, "isrowkey");
        objectEditableGridColumnsData.issortable = UtilSql.getValue(result, "issortable");
        objectEditableGridColumnsData.rowkeysuffix = UtilSql.getValue(result, "rowkeysuffix");
        objectEditableGridColumnsData.language = UtilSql.getValue(result, "language");
        objectEditableGridColumnsData.adUserClient = "";
        objectEditableGridColumnsData.adOrgClient = "";
        objectEditableGridColumnsData.createdby = "";
        objectEditableGridColumnsData.trBgcolor = "";
        objectEditableGridColumnsData.totalCount = "";
        objectEditableGridColumnsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEditableGridColumnsData);
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
    EditableGridColumnsData objectEditableGridColumnsData[] = new EditableGridColumnsData[vector.size()];
    vector.copyInto(objectEditableGridColumnsData);
    return(objectEditableGridColumnsData);
  }

/**
Create a registry
 */
  public static EditableGridColumnsData[] set(String adRefGroupId, String updatedby, String updatedbyr, String adElementId, String required, String onchangeevent, String issortable, String mandantorylogic, String adClientId, String readonlylogic, String rowkeysuffix, String createdby, String createdbyr, String readonly, String issplitgroup, String adOrgId, String isactive, String adTableId, String defaultvalue, String line, String includesemptyitem, String colspan, String adRefGridcolumnId, String headertext, String adReferenceId, String isinheader, String issecondheader, String referenceurl, String maxlength, String isdisplayed, String isrowkey, String colreference, String template, String name, String adValRuleId)    throws ServletException {
    EditableGridColumnsData objectEditableGridColumnsData[] = new EditableGridColumnsData[1];
    objectEditableGridColumnsData[0] = new EditableGridColumnsData();
    objectEditableGridColumnsData[0].created = "";
    objectEditableGridColumnsData[0].createdbyr = createdbyr;
    objectEditableGridColumnsData[0].updated = "";
    objectEditableGridColumnsData[0].updatedTimeStamp = "";
    objectEditableGridColumnsData[0].updatedby = updatedby;
    objectEditableGridColumnsData[0].updatedbyr = updatedbyr;
    objectEditableGridColumnsData[0].adRefGroupId = adRefGroupId;
    objectEditableGridColumnsData[0].adRefGroupIdr = "";
    objectEditableGridColumnsData[0].adRefGridcolumnId = adRefGridcolumnId;
    objectEditableGridColumnsData[0].line = line;
    objectEditableGridColumnsData[0].name = name;
    objectEditableGridColumnsData[0].adClientId = adClientId;
    objectEditableGridColumnsData[0].adElementId = adElementId;
    objectEditableGridColumnsData[0].adElementIdr = "";
    objectEditableGridColumnsData[0].adOrgId = adOrgId;
    objectEditableGridColumnsData[0].readonly = readonly;
    objectEditableGridColumnsData[0].isdisplayed = isdisplayed;
    objectEditableGridColumnsData[0].isactive = isactive;
    objectEditableGridColumnsData[0].colspan = colspan;
    objectEditableGridColumnsData[0].required = required;
    objectEditableGridColumnsData[0].issecondheader = issecondheader;
    objectEditableGridColumnsData[0].adReferenceId = adReferenceId;
    objectEditableGridColumnsData[0].maxlength = maxlength;
    objectEditableGridColumnsData[0].isinheader = isinheader;
    objectEditableGridColumnsData[0].headertext = headertext;
    objectEditableGridColumnsData[0].colreference = colreference;
    objectEditableGridColumnsData[0].colreferencer = "";
    objectEditableGridColumnsData[0].referenceurl = referenceurl;
    objectEditableGridColumnsData[0].adTableId = adTableId;
    objectEditableGridColumnsData[0].adTableIdr = "";
    objectEditableGridColumnsData[0].adValRuleId = adValRuleId;
    objectEditableGridColumnsData[0].adValRuleIdr = "";
    objectEditableGridColumnsData[0].includesemptyitem = includesemptyitem;
    objectEditableGridColumnsData[0].template = template;
    objectEditableGridColumnsData[0].templater = "";
    objectEditableGridColumnsData[0].issplitgroup = issplitgroup;
    objectEditableGridColumnsData[0].defaultvalue = defaultvalue;
    objectEditableGridColumnsData[0].onchangeevent = onchangeevent;
    objectEditableGridColumnsData[0].readonlylogic = readonlylogic;
    objectEditableGridColumnsData[0].mandantorylogic = mandantorylogic;
    objectEditableGridColumnsData[0].isrowkey = isrowkey;
    objectEditableGridColumnsData[0].issortable = issortable;
    objectEditableGridColumnsData[0].rowkeysuffix = rowkeysuffix;
    objectEditableGridColumnsData[0].language = "";
    return objectEditableGridColumnsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef80B39AFB5F564DDAA7D2333503751AD7_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDefC531C9F2EC594BD280D6D97AFD0A60CC_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef8C68026A92AE4C2FAE5001D12D74C6BE(ConnectionProvider connectionProvider, String ad_ref_group_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM AD_REF_GRIDCOLUMN WHERE ad_ref_group_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_ref_group_id);

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
      "        SELECT ad_ref_gridcolumn.AD_Ref_Group_ID AS NAME" +
      "        FROM ad_ref_gridcolumn" +
      "        WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adRefGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || list1.name || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Idcolumn), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Level), ''))) AS NAME FROM ad_ref_group left join (select AD_Ref_Group_ID, AD_Reference_ID, Idcolumn, Level from AD_Ref_Group) table1 on (ad_ref_group.AD_Ref_Group_ID = table1.AD_Ref_Group_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (table1.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE ad_ref_group.AD_Ref_Group_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adRefGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || list1.name || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Idcolumn), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Level), ''))) AS NAME FROM ad_ref_group left join (select AD_Ref_Group_ID, AD_Reference_ID, Idcolumn, Level from AD_Ref_Group) table1 on (ad_ref_group.AD_Ref_Group_ID = table1.AD_Ref_Group_ID) left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table2 on (table1.AD_Reference_ID = table2.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL2 on (table2.AD_Reference_ID = tableTRL2.AD_Reference_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (table2.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE ad_ref_group.AD_Ref_Group_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);

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
      "        UPDATE ad_ref_gridcolumn" +
      "        SET AD_Ref_Group_ID = (?) , AD_Ref_Gridcolumn_ID = (?) , Line = TO_NUMBER(?) , Name = (?) , AD_Client_ID = (?) , AD_Element_ID = (?) , AD_Org_ID = (?) , ReadOnly = (?) , Isdisplayed = (?) , Isactive = (?) , Colspan = TO_NUMBER(?) , Required = (?) , Issecondheader = (?) , AD_Reference_ID = (?) , MaxLength = TO_NUMBER(?) , Isinheader = (?) , Headertext = (?) , colreference = (?) , Referenceurl = (?) , AD_Table_ID = (?) , AD_Val_Rule_ID = (?) , Includesemptyitem = (?) , Template = (?) , Issplitgroup = (?) , Defaultvalue = (?) , Onchangeevent = (?) , Readonlylogic = (?) , Mandantorylogic = (?) , Isrowkey = (?) , Issortable = (?) , Rowkeysuffix = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? " +
      "                 AND ad_ref_gridcolumn.AD_Ref_Group_ID = ? " +
      "        AND ad_ref_gridcolumn.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_gridcolumn.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colspan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issecondheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issplitgroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrowkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issortable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rowkeysuffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
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
      "        INSERT INTO ad_ref_gridcolumn " +
      "        (AD_Ref_Group_ID, AD_Ref_Gridcolumn_ID, Line, Name, AD_Client_ID, AD_Element_ID, AD_Org_ID, ReadOnly, Isdisplayed, Isactive, Colspan, Required, Issecondheader, AD_Reference_ID, MaxLength, Isinheader, Headertext, colreference, Referenceurl, AD_Table_ID, AD_Val_Rule_ID, Includesemptyitem, Template, Issplitgroup, Defaultvalue, Onchangeevent, Readonlylogic, Mandantorylogic, Isrowkey, Issortable, Rowkeysuffix, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colspan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issecondheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issplitgroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrowkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issortable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rowkeysuffix);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefGroupId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_gridcolumn" +
      "        WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? " +
      "                 AND ad_ref_gridcolumn.AD_Ref_Group_ID = ? " +
      "        AND ad_ref_gridcolumn.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_gridcolumn.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefGroupId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_gridcolumn" +
      "        WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? " +
      "                 AND ad_ref_gridcolumn.AD_Ref_Group_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);

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
      "          FROM ad_ref_gridcolumn" +
      "         WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? ";

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
      "          FROM ad_ref_gridcolumn" +
      "         WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? ";

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

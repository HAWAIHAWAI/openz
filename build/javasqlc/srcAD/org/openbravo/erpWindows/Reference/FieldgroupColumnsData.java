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
class FieldgroupColumnsData implements FieldProvider {
static Logger log4j = Logger.getLogger(FieldgroupColumnsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefFieldcolumnId;
  public String adReferenceId;
  public String adReferenceIdr;
  public String line;
  public String adClientId;
  public String name;
  public String adOrgId;
  public String name2;
  public String adElementId;
  public String adElementIdr;
  public String leadingemptycols;
  public String colstotal;
  public String isfirstfocusedfield;
  public String readonly;
  public String required;
  public String maxlength;
  public String fieldreference;
  public String fieldreferencer;
  public String referenceurl;
  public String adTableId;
  public String adTableIdr;
  public String adValRuleId;
  public String adValRuleIdr;
  public String includesemptyitem;
  public String template;
  public String templater;
  public String buttonclass;
  public String islinebreak;
  public String isactive;
  public String isdisplayed;
  public String displaylogic;
  public String readonlylogic;
  public String mandantorylogic;
  public String defaultvalue;
  public String style;
  public String onchangeevent;
  public String issessionattr;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_fieldcolumn_id") || fieldName.equals("adRefFieldcolumnId"))
      return adRefFieldcolumnId;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("ad_reference_idr") || fieldName.equals("adReferenceIdr"))
      return adReferenceIdr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("name2"))
      return name2;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_element_idr") || fieldName.equals("adElementIdr"))
      return adElementIdr;
    else if (fieldName.equalsIgnoreCase("leadingemptycols"))
      return leadingemptycols;
    else if (fieldName.equalsIgnoreCase("colstotal"))
      return colstotal;
    else if (fieldName.equalsIgnoreCase("isfirstfocusedfield"))
      return isfirstfocusedfield;
    else if (fieldName.equalsIgnoreCase("readonly"))
      return readonly;
    else if (fieldName.equalsIgnoreCase("required"))
      return required;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("fieldreference"))
      return fieldreference;
    else if (fieldName.equalsIgnoreCase("fieldreferencer"))
      return fieldreferencer;
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
    else if (fieldName.equalsIgnoreCase("buttonclass"))
      return buttonclass;
    else if (fieldName.equalsIgnoreCase("islinebreak"))
      return islinebreak;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("displaylogic"))
      return displaylogic;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("mandantorylogic"))
      return mandantorylogic;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("style"))
      return style;
    else if (fieldName.equalsIgnoreCase("onchangeevent"))
      return onchangeevent;
    else if (fieldName.equalsIgnoreCase("issessionattr"))
      return issessionattr;
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
  public static FieldgroupColumnsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adReferenceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FieldgroupColumnsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_fieldcolumn.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_fieldcolumn.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_fieldcolumn.Updated, ?) as updated, " +
      "        to_char(ad_ref_fieldcolumn.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_fieldcolumn.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_fieldcolumn.UpdatedBy) as UpdatedByR," +
      "        ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID, " +
      "ad_ref_fieldcolumn.AD_Reference_ID, " +
      "(CASE WHEN ad_ref_fieldcolumn.AD_Reference_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(list1.name),'') ) END) AS AD_Reference_IDR, " +
      "ad_ref_fieldcolumn.Line, " +
      "ad_ref_fieldcolumn.AD_Client_ID, " +
      "ad_ref_fieldcolumn.Name, " +
      "ad_ref_fieldcolumn.AD_Org_ID, " +
      "ad_ref_fieldcolumn.Name2, " +
      "ad_ref_fieldcolumn.AD_Element_ID, " +
      "(CASE WHEN ad_ref_fieldcolumn.AD_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.ColumnName), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Element_IDR, " +
      "ad_ref_fieldcolumn.Leadingemptycols, " +
      "ad_ref_fieldcolumn.Colstotal, " +
      "COALESCE(ad_ref_fieldcolumn.Isfirstfocusedfield, 'N') AS Isfirstfocusedfield, " +
      "COALESCE(ad_ref_fieldcolumn.Readonly, 'N') AS Readonly, " +
      "COALESCE(ad_ref_fieldcolumn.Required, 'N') AS Required, " +
      "ad_ref_fieldcolumn.Maxlength, " +
      "ad_ref_fieldcolumn.fieldreference, " +
      "(CASE WHEN ad_ref_fieldcolumn.fieldreference IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS fieldreferenceR, " +
      "ad_ref_fieldcolumn.Referenceurl, " +
      "ad_ref_fieldcolumn.AD_Table_ID, " +
      "(CASE WHEN ad_ref_fieldcolumn.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "ad_ref_fieldcolumn.AD_Val_Rule_ID, " +
      "(CASE WHEN ad_ref_fieldcolumn.AD_Val_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Val_Rule_IDR, " +
      "COALESCE(ad_ref_fieldcolumn.Includesemptyitem, 'N') AS Includesemptyitem, " +
      "ad_ref_fieldcolumn.Template, " +
      "(CASE WHEN ad_ref_fieldcolumn.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS TemplateR, " +
      "ad_ref_fieldcolumn.Buttonclass, " +
      "COALESCE(ad_ref_fieldcolumn.Islinebreak, 'N') AS Islinebreak, " +
      "COALESCE(ad_ref_fieldcolumn.Isactive, 'N') AS Isactive, " +
      "COALESCE(ad_ref_fieldcolumn.Isdisplayed, 'N') AS Isdisplayed, " +
      "ad_ref_fieldcolumn.Displaylogic, " +
      "ad_ref_fieldcolumn.Readonlylogic, " +
      "ad_ref_fieldcolumn.Mandantorylogic, " +
      "ad_ref_fieldcolumn.Defaultvalue, " +
      "ad_ref_fieldcolumn.Style, " +
      "ad_ref_fieldcolumn.Onchangeevent, " +
      "COALESCE(ad_ref_fieldcolumn.Issessionattr, 'N') AS Issessionattr, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_fieldcolumn left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (ad_ref_fieldcolumn.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  left join (select AD_Element_ID, ColumnName, Name from AD_Element) table2 on (ad_ref_fieldcolumn.AD_Element_ID = table2.AD_Element_ID) left join (select AD_Reference_ID, Name from AD_Reference) table3 on (ad_ref_fieldcolumn.fieldreference =  table3.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL3 on (table3.AD_Reference_ID = tableTRL3.AD_Reference_ID and tableTRL3.AD_Language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table4 on (ad_ref_fieldcolumn.AD_Table_ID = table4.AD_Table_ID) left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table5 on (ad_ref_fieldcolumn.AD_Val_Rule_ID = table5.AD_Val_Rule_ID) left join ad_ref_list_v list2 on (ad_ref_fieldcolumn.Template = list2.value and list2.ad_reference_id = '029984D63BCA4F67AD81C93DCF486DFE' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adReferenceId==null || adReferenceId.equals(""))?"":"  AND ad_ref_fieldcolumn.AD_Reference_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ? " +
      "        AND ad_ref_fieldcolumn.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_fieldcolumn.AD_Org_ID IN (";
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
      if (adReferenceId != null && !(adReferenceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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
        FieldgroupColumnsData objectFieldgroupColumnsData = new FieldgroupColumnsData();
        objectFieldgroupColumnsData.created = UtilSql.getValue(result, "created");
        objectFieldgroupColumnsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFieldgroupColumnsData.updated = UtilSql.getValue(result, "updated");
        objectFieldgroupColumnsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFieldgroupColumnsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFieldgroupColumnsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFieldgroupColumnsData.adRefFieldcolumnId = UtilSql.getValue(result, "ad_ref_fieldcolumn_id");
        objectFieldgroupColumnsData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectFieldgroupColumnsData.adReferenceIdr = UtilSql.getValue(result, "ad_reference_idr");
        objectFieldgroupColumnsData.line = UtilSql.getValue(result, "line");
        objectFieldgroupColumnsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFieldgroupColumnsData.name = UtilSql.getValue(result, "name");
        objectFieldgroupColumnsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFieldgroupColumnsData.name2 = UtilSql.getValue(result, "name2");
        objectFieldgroupColumnsData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectFieldgroupColumnsData.adElementIdr = UtilSql.getValue(result, "ad_element_idr");
        objectFieldgroupColumnsData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectFieldgroupColumnsData.colstotal = UtilSql.getValue(result, "colstotal");
        objectFieldgroupColumnsData.isfirstfocusedfield = UtilSql.getValue(result, "isfirstfocusedfield");
        objectFieldgroupColumnsData.readonly = UtilSql.getValue(result, "readonly");
        objectFieldgroupColumnsData.required = UtilSql.getValue(result, "required");
        objectFieldgroupColumnsData.maxlength = UtilSql.getValue(result, "maxlength");
        objectFieldgroupColumnsData.fieldreference = UtilSql.getValue(result, "fieldreference");
        objectFieldgroupColumnsData.fieldreferencer = UtilSql.getValue(result, "fieldreferencer");
        objectFieldgroupColumnsData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectFieldgroupColumnsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectFieldgroupColumnsData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectFieldgroupColumnsData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectFieldgroupColumnsData.adValRuleIdr = UtilSql.getValue(result, "ad_val_rule_idr");
        objectFieldgroupColumnsData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectFieldgroupColumnsData.template = UtilSql.getValue(result, "template");
        objectFieldgroupColumnsData.templater = UtilSql.getValue(result, "templater");
        objectFieldgroupColumnsData.buttonclass = UtilSql.getValue(result, "buttonclass");
        objectFieldgroupColumnsData.islinebreak = UtilSql.getValue(result, "islinebreak");
        objectFieldgroupColumnsData.isactive = UtilSql.getValue(result, "isactive");
        objectFieldgroupColumnsData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectFieldgroupColumnsData.displaylogic = UtilSql.getValue(result, "displaylogic");
        objectFieldgroupColumnsData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectFieldgroupColumnsData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectFieldgroupColumnsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldgroupColumnsData.style = UtilSql.getValue(result, "style");
        objectFieldgroupColumnsData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectFieldgroupColumnsData.issessionattr = UtilSql.getValue(result, "issessionattr");
        objectFieldgroupColumnsData.language = UtilSql.getValue(result, "language");
        objectFieldgroupColumnsData.adUserClient = "";
        objectFieldgroupColumnsData.adOrgClient = "";
        objectFieldgroupColumnsData.createdby = "";
        objectFieldgroupColumnsData.trBgcolor = "";
        objectFieldgroupColumnsData.totalCount = "";
        objectFieldgroupColumnsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldgroupColumnsData);
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
    FieldgroupColumnsData objectFieldgroupColumnsData[] = new FieldgroupColumnsData[vector.size()];
    vector.copyInto(objectFieldgroupColumnsData);
    return(objectFieldgroupColumnsData);
  }

/**
Create a registry
 */
  public static FieldgroupColumnsData[] set(String adReferenceId, String template, String buttonclass, String mandantorylogic, String isdisplayed, String displaylogic, String adRefFieldcolumnId, String line, String maxlength, String adOrgId, String name, String onchangeevent, String style, String adValRuleId, String islinebreak, String leadingemptycols, String isactive, String readonly, String referenceurl, String name2, String colstotal, String fieldreference, String includesemptyitem, String adTableId, String adClientId, String createdby, String createdbyr, String issessionattr, String defaultvalue, String isfirstfocusedfield, String updatedby, String updatedbyr, String readonlylogic, String required, String adElementId)    throws ServletException {
    FieldgroupColumnsData objectFieldgroupColumnsData[] = new FieldgroupColumnsData[1];
    objectFieldgroupColumnsData[0] = new FieldgroupColumnsData();
    objectFieldgroupColumnsData[0].created = "";
    objectFieldgroupColumnsData[0].createdbyr = createdbyr;
    objectFieldgroupColumnsData[0].updated = "";
    objectFieldgroupColumnsData[0].updatedTimeStamp = "";
    objectFieldgroupColumnsData[0].updatedby = updatedby;
    objectFieldgroupColumnsData[0].updatedbyr = updatedbyr;
    objectFieldgroupColumnsData[0].adRefFieldcolumnId = adRefFieldcolumnId;
    objectFieldgroupColumnsData[0].adReferenceId = adReferenceId;
    objectFieldgroupColumnsData[0].adReferenceIdr = "";
    objectFieldgroupColumnsData[0].line = line;
    objectFieldgroupColumnsData[0].adClientId = adClientId;
    objectFieldgroupColumnsData[0].name = name;
    objectFieldgroupColumnsData[0].adOrgId = adOrgId;
    objectFieldgroupColumnsData[0].name2 = name2;
    objectFieldgroupColumnsData[0].adElementId = adElementId;
    objectFieldgroupColumnsData[0].adElementIdr = "";
    objectFieldgroupColumnsData[0].leadingemptycols = leadingemptycols;
    objectFieldgroupColumnsData[0].colstotal = colstotal;
    objectFieldgroupColumnsData[0].isfirstfocusedfield = isfirstfocusedfield;
    objectFieldgroupColumnsData[0].readonly = readonly;
    objectFieldgroupColumnsData[0].required = required;
    objectFieldgroupColumnsData[0].maxlength = maxlength;
    objectFieldgroupColumnsData[0].fieldreference = fieldreference;
    objectFieldgroupColumnsData[0].fieldreferencer = "";
    objectFieldgroupColumnsData[0].referenceurl = referenceurl;
    objectFieldgroupColumnsData[0].adTableId = adTableId;
    objectFieldgroupColumnsData[0].adTableIdr = "";
    objectFieldgroupColumnsData[0].adValRuleId = adValRuleId;
    objectFieldgroupColumnsData[0].adValRuleIdr = "";
    objectFieldgroupColumnsData[0].includesemptyitem = includesemptyitem;
    objectFieldgroupColumnsData[0].template = template;
    objectFieldgroupColumnsData[0].templater = "";
    objectFieldgroupColumnsData[0].buttonclass = buttonclass;
    objectFieldgroupColumnsData[0].islinebreak = islinebreak;
    objectFieldgroupColumnsData[0].isactive = isactive;
    objectFieldgroupColumnsData[0].isdisplayed = isdisplayed;
    objectFieldgroupColumnsData[0].displaylogic = displaylogic;
    objectFieldgroupColumnsData[0].readonlylogic = readonlylogic;
    objectFieldgroupColumnsData[0].mandantorylogic = mandantorylogic;
    objectFieldgroupColumnsData[0].defaultvalue = defaultvalue;
    objectFieldgroupColumnsData[0].style = style;
    objectFieldgroupColumnsData[0].onchangeevent = onchangeevent;
    objectFieldgroupColumnsData[0].issessionattr = issessionattr;
    objectFieldgroupColumnsData[0].language = "";
    return objectFieldgroupColumnsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefF4EF3C8272364040B0AED944EC8B084C(ConnectionProvider connectionProvider, String ad_reference_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM AD_REF_FIELDCOLUMN WHERE ad_reference_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_reference_id);

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
  public static String selectDef84EC74E3A5774AAEB62A92969A4F2259_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefE43E7ED1A3B04847931A07DF6B912BE3_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_ref_fieldcolumn.AD_Reference_ID AS NAME" +
      "        FROM ad_ref_fieldcolumn" +
      "        WHERE ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Reference left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (AD_Reference.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Reference.AD_Reference_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), '')) || ' - ' || list1.name) AS NAME FROM AD_Reference left join (select AD_Reference_ID, Name, ValidationType from AD_Reference) table1 on (AD_Reference.AD_Reference_ID = table1.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL1 on (table1.AD_Reference_ID = tableTRL1.AD_Reference_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (table1.ValidationType = list1.value and list1.ad_reference_id = '2' and list1.ad_language = ?)  WHERE AD_Reference.AD_Reference_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
      "        UPDATE ad_ref_fieldcolumn" +
      "        SET AD_Ref_Fieldcolumn_ID = (?) , AD_Reference_ID = (?) , Line = TO_NUMBER(?) , AD_Client_ID = (?) , Name = (?) , AD_Org_ID = (?) , Name2 = (?) , AD_Element_ID = (?) , Leadingemptycols = TO_NUMBER(?) , Colstotal = TO_NUMBER(?) , Isfirstfocusedfield = (?) , Readonly = (?) , Required = (?) , Maxlength = TO_NUMBER(?) , fieldreference = (?) , Referenceurl = (?) , AD_Table_ID = (?) , AD_Val_Rule_ID = (?) , Includesemptyitem = (?) , Template = (?) , Buttonclass = (?) , Islinebreak = (?) , Isactive = (?) , Isdisplayed = (?) , Displaylogic = (?) , Readonlylogic = (?) , Mandantorylogic = (?) , Defaultvalue = (?) , Style = (?) , Onchangeevent = (?) , Issessionattr = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ? " +
      "                 AND ad_ref_fieldcolumn.AD_Reference_ID = ? " +
      "        AND ad_ref_fieldcolumn.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_fieldcolumn.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, leadingemptycols);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islinebreak);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, style);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issessionattr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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
      "        INSERT INTO ad_ref_fieldcolumn " +
      "        (AD_Ref_Fieldcolumn_ID, AD_Reference_ID, Line, AD_Client_ID, Name, AD_Org_ID, Name2, AD_Element_ID, Leadingemptycols, Colstotal, Isfirstfocusedfield, Readonly, Required, Maxlength, fieldreference, Referenceurl, AD_Table_ID, AD_Val_Rule_ID, Includesemptyitem, Template, Buttonclass, Islinebreak, Isactive, Isdisplayed, Displaylogic, Readonlylogic, Mandantorylogic, Defaultvalue, Style, Onchangeevent, Issessionattr, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, leadingemptycols);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islinebreak);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, style);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issessionattr);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adReferenceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_fieldcolumn" +
      "        WHERE ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ? " +
      "                 AND ad_ref_fieldcolumn.AD_Reference_ID = ? " +
      "        AND ad_ref_fieldcolumn.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_fieldcolumn.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adReferenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_fieldcolumn" +
      "        WHERE ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ? " +
      "                 AND ad_ref_fieldcolumn.AD_Reference_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);

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
      "          FROM ad_ref_fieldcolumn" +
      "         WHERE ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ? ";

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
      "          FROM ad_ref_fieldcolumn" +
      "         WHERE ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ? ";

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

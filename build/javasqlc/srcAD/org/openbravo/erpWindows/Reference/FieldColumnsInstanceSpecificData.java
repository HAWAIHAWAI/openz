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
class FieldColumnsInstanceSpecificData implements FieldProvider {
static Logger log4j = Logger.getLogger(FieldColumnsInstanceSpecificData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefFieldcolumnId;
  public String adRefFieldcolumnIdr;
  public String adRefFieldcolumninstanceId;
  public String line;
  public String adClientId;
  public String adElementId;
  public String adElementIdr;
  public String adOrgId;
  public String leadingemptycols;
  public String colstotal;
  public String isfirstfocusedfield;
  public String isfirstfocusedfieldr;
  public String editsetting;
  public String editsettingr;
  public String maxlength;
  public String fieldreference;
  public String fieldreferencer;
  public String referenceurl;
  public String adTableId;
  public String adTableIdr;
  public String adValRuleId;
  public String adValRuleIdr;
  public String includesemptyitem;
  public String includesemptyitemr;
  public String template;
  public String templater;
  public String buttonclass;
  public String islinebreak;
  public String islinebreakr;
  public String isdisplayed;
  public String isactive;
  public String visiblesetting;
  public String visiblesettingr;
  public String displaylogic;
  public String readonlylogic;
  public String mandantorylogic;
  public String defaultvalue;
  public String style;
  public String onchangeevent;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_fieldcolumn_idr") || fieldName.equals("adRefFieldcolumnIdr"))
      return adRefFieldcolumnIdr;
    else if (fieldName.equalsIgnoreCase("ad_ref_fieldcolumninstance_id") || fieldName.equals("adRefFieldcolumninstanceId"))
      return adRefFieldcolumninstanceId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_element_idr") || fieldName.equals("adElementIdr"))
      return adElementIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("leadingemptycols"))
      return leadingemptycols;
    else if (fieldName.equalsIgnoreCase("colstotal"))
      return colstotal;
    else if (fieldName.equalsIgnoreCase("isfirstfocusedfield"))
      return isfirstfocusedfield;
    else if (fieldName.equalsIgnoreCase("isfirstfocusedfieldr"))
      return isfirstfocusedfieldr;
    else if (fieldName.equalsIgnoreCase("editsetting"))
      return editsetting;
    else if (fieldName.equalsIgnoreCase("editsettingr"))
      return editsettingr;
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
    else if (fieldName.equalsIgnoreCase("includesemptyitemr"))
      return includesemptyitemr;
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("templater"))
      return templater;
    else if (fieldName.equalsIgnoreCase("buttonclass"))
      return buttonclass;
    else if (fieldName.equalsIgnoreCase("islinebreak"))
      return islinebreak;
    else if (fieldName.equalsIgnoreCase("islinebreakr"))
      return islinebreakr;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("visiblesetting"))
      return visiblesetting;
    else if (fieldName.equalsIgnoreCase("visiblesettingr"))
      return visiblesettingr;
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
  public static FieldColumnsInstanceSpecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefFieldcolumnId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefFieldcolumnId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static FieldColumnsInstanceSpecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefFieldcolumnId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_fieldcolumninstance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_fieldcolumninstance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_fieldcolumninstance.Updated, ?) as updated, " +
      "        to_char(ad_ref_fieldcolumninstance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_fieldcolumninstance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_fieldcolumninstance.UpdatedBy) as UpdatedByR," +
      "        ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumn_ID, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumn_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Ref_Fieldcolumn_IDR, " +
      "ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumninstance_ID, " +
      "ad_ref_fieldcolumninstance.Line, " +
      "ad_ref_fieldcolumninstance.AD_Client_ID, " +
      "ad_ref_fieldcolumninstance.AD_Element_ID, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.AD_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.ColumnName), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Element_IDR, " +
      "ad_ref_fieldcolumninstance.AD_Org_ID, " +
      "ad_ref_fieldcolumninstance.Leadingemptycols, " +
      "ad_ref_fieldcolumninstance.Colstotal, " +
      "ad_ref_fieldcolumninstance.Isfirstfocusedfield, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.Isfirstfocusedfield IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS IsfirstfocusedfieldR, " +
      "ad_ref_fieldcolumninstance.Editsetting, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.Editsetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS EditsettingR, " +
      "ad_ref_fieldcolumninstance.Maxlength, " +
      "ad_ref_fieldcolumninstance.Fieldreference, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.Fieldreference IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS FieldreferenceR, " +
      "ad_ref_fieldcolumninstance.Referenceurl, " +
      "ad_ref_fieldcolumninstance.AD_Table_ID, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.AD_Table_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.TableName), ''))),'') ) END) AS AD_Table_IDR, " +
      "ad_ref_fieldcolumninstance.AD_Val_Rule_ID, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.AD_Val_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Val_Rule_IDR, " +
      "ad_ref_fieldcolumninstance.Includesemptyitem, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.Includesemptyitem IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS IncludesemptyitemR, " +
      "ad_ref_fieldcolumninstance.Template, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS TemplateR, " +
      "ad_ref_fieldcolumninstance.Buttonclass, " +
      "ad_ref_fieldcolumninstance.Islinebreak, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.Islinebreak IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS IslinebreakR, " +
      "COALESCE(ad_ref_fieldcolumninstance.Isdisplayed, 'N') AS Isdisplayed, " +
      "COALESCE(ad_ref_fieldcolumninstance.Isactive, 'N') AS Isactive, " +
      "ad_ref_fieldcolumninstance.Visiblesetting, " +
      "(CASE WHEN ad_ref_fieldcolumninstance.Visiblesetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS VisiblesettingR, " +
      "ad_ref_fieldcolumninstance.Displaylogic, " +
      "ad_ref_fieldcolumninstance.Readonlylogic, " +
      "ad_ref_fieldcolumninstance.Mandantorylogic, " +
      "ad_ref_fieldcolumninstance.Defaultvalue, " +
      "ad_ref_fieldcolumninstance.Style, " +
      "ad_ref_fieldcolumninstance.Onchangeevent, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_fieldcolumninstance left join (select AD_Ref_Fieldcolumn_ID, Name from AD_Ref_Fieldcolumn) table1 on (ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumn_ID = table1.AD_Ref_Fieldcolumn_ID) left join (select AD_Element_ID, ColumnName, Name from AD_Element) table2 on (ad_ref_fieldcolumninstance.AD_Element_ID = table2.AD_Element_ID) left join ad_ref_list_v list1 on (ad_ref_fieldcolumninstance.Isfirstfocusedfield = list1.value and list1.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (ad_ref_fieldcolumninstance.Editsetting = list2.value and list2.ad_reference_id = '0765914076274AD79BACA01E75F4D0A1' and list2.ad_language = ?)  left join (select AD_Reference_ID, Name from AD_Reference) table3 on (ad_ref_fieldcolumninstance.Fieldreference =  table3.AD_Reference_ID) left join (select AD_Reference_ID,AD_Language, Name from AD_Reference_TRL) tableTRL3 on (table3.AD_Reference_ID = tableTRL3.AD_Reference_ID and tableTRL3.AD_Language = ?)  left join (select AD_Table_ID, TableName from AD_Table) table4 on (ad_ref_fieldcolumninstance.AD_Table_ID = table4.AD_Table_ID) left join (select AD_Val_Rule_ID, Name from AD_Val_Rule) table5 on (ad_ref_fieldcolumninstance.AD_Val_Rule_ID = table5.AD_Val_Rule_ID) left join ad_ref_list_v list3 on (ad_ref_fieldcolumninstance.Includesemptyitem = list3.value and list3.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (ad_ref_fieldcolumninstance.Template = list4.value and list4.ad_reference_id = '029984D63BCA4F67AD81C93DCF486DFE' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (ad_ref_fieldcolumninstance.Islinebreak = list5.value and list5.ad_reference_id = 'BE2C89D33763486BBCDDB2E1D63A5B00' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (ad_ref_fieldcolumninstance.Visiblesetting = list6.value and list6.ad_reference_id = 'A4801B9D7ADB4BB69EBF727B71C8AB45' and list6.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefFieldcolumnId==null || adRefFieldcolumnId.equals(""))?"":"  AND ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumn_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumninstance_ID = ? " +
      "        AND ad_ref_fieldcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_fieldcolumninstance.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (adRefFieldcolumnId != null && !(adRefFieldcolumnId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);
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
        FieldColumnsInstanceSpecificData objectFieldColumnsInstanceSpecificData = new FieldColumnsInstanceSpecificData();
        objectFieldColumnsInstanceSpecificData.created = UtilSql.getValue(result, "created");
        objectFieldColumnsInstanceSpecificData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectFieldColumnsInstanceSpecificData.updated = UtilSql.getValue(result, "updated");
        objectFieldColumnsInstanceSpecificData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectFieldColumnsInstanceSpecificData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFieldColumnsInstanceSpecificData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectFieldColumnsInstanceSpecificData.adRefFieldcolumnId = UtilSql.getValue(result, "ad_ref_fieldcolumn_id");
        objectFieldColumnsInstanceSpecificData.adRefFieldcolumnIdr = UtilSql.getValue(result, "ad_ref_fieldcolumn_idr");
        objectFieldColumnsInstanceSpecificData.adRefFieldcolumninstanceId = UtilSql.getValue(result, "ad_ref_fieldcolumninstance_id");
        objectFieldColumnsInstanceSpecificData.line = UtilSql.getValue(result, "line");
        objectFieldColumnsInstanceSpecificData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFieldColumnsInstanceSpecificData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectFieldColumnsInstanceSpecificData.adElementIdr = UtilSql.getValue(result, "ad_element_idr");
        objectFieldColumnsInstanceSpecificData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFieldColumnsInstanceSpecificData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectFieldColumnsInstanceSpecificData.colstotal = UtilSql.getValue(result, "colstotal");
        objectFieldColumnsInstanceSpecificData.isfirstfocusedfield = UtilSql.getValue(result, "isfirstfocusedfield");
        objectFieldColumnsInstanceSpecificData.isfirstfocusedfieldr = UtilSql.getValue(result, "isfirstfocusedfieldr");
        objectFieldColumnsInstanceSpecificData.editsetting = UtilSql.getValue(result, "editsetting");
        objectFieldColumnsInstanceSpecificData.editsettingr = UtilSql.getValue(result, "editsettingr");
        objectFieldColumnsInstanceSpecificData.maxlength = UtilSql.getValue(result, "maxlength");
        objectFieldColumnsInstanceSpecificData.fieldreference = UtilSql.getValue(result, "fieldreference");
        objectFieldColumnsInstanceSpecificData.fieldreferencer = UtilSql.getValue(result, "fieldreferencer");
        objectFieldColumnsInstanceSpecificData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectFieldColumnsInstanceSpecificData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectFieldColumnsInstanceSpecificData.adTableIdr = UtilSql.getValue(result, "ad_table_idr");
        objectFieldColumnsInstanceSpecificData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectFieldColumnsInstanceSpecificData.adValRuleIdr = UtilSql.getValue(result, "ad_val_rule_idr");
        objectFieldColumnsInstanceSpecificData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectFieldColumnsInstanceSpecificData.includesemptyitemr = UtilSql.getValue(result, "includesemptyitemr");
        objectFieldColumnsInstanceSpecificData.template = UtilSql.getValue(result, "template");
        objectFieldColumnsInstanceSpecificData.templater = UtilSql.getValue(result, "templater");
        objectFieldColumnsInstanceSpecificData.buttonclass = UtilSql.getValue(result, "buttonclass");
        objectFieldColumnsInstanceSpecificData.islinebreak = UtilSql.getValue(result, "islinebreak");
        objectFieldColumnsInstanceSpecificData.islinebreakr = UtilSql.getValue(result, "islinebreakr");
        objectFieldColumnsInstanceSpecificData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectFieldColumnsInstanceSpecificData.isactive = UtilSql.getValue(result, "isactive");
        objectFieldColumnsInstanceSpecificData.visiblesetting = UtilSql.getValue(result, "visiblesetting");
        objectFieldColumnsInstanceSpecificData.visiblesettingr = UtilSql.getValue(result, "visiblesettingr");
        objectFieldColumnsInstanceSpecificData.displaylogic = UtilSql.getValue(result, "displaylogic");
        objectFieldColumnsInstanceSpecificData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectFieldColumnsInstanceSpecificData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectFieldColumnsInstanceSpecificData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectFieldColumnsInstanceSpecificData.style = UtilSql.getValue(result, "style");
        objectFieldColumnsInstanceSpecificData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectFieldColumnsInstanceSpecificData.language = UtilSql.getValue(result, "language");
        objectFieldColumnsInstanceSpecificData.adUserClient = "";
        objectFieldColumnsInstanceSpecificData.adOrgClient = "";
        objectFieldColumnsInstanceSpecificData.createdby = "";
        objectFieldColumnsInstanceSpecificData.trBgcolor = "";
        objectFieldColumnsInstanceSpecificData.totalCount = "";
        objectFieldColumnsInstanceSpecificData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFieldColumnsInstanceSpecificData);
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
    FieldColumnsInstanceSpecificData objectFieldColumnsInstanceSpecificData[] = new FieldColumnsInstanceSpecificData[vector.size()];
    vector.copyInto(objectFieldColumnsInstanceSpecificData);
    return(objectFieldColumnsInstanceSpecificData);
  }

/**
Create a registry
 */
  public static FieldColumnsInstanceSpecificData[] set(String adRefFieldcolumnId, String visiblesetting, String adValRuleId, String editsetting, String createdby, String createdbyr, String adElementId, String fieldreference, String maxlength, String updatedby, String updatedbyr, String isfirstfocusedfield, String colstotal, String template, String adClientId, String isactive, String adRefFieldcolumninstanceId, String adTableId, String displaylogic, String defaultvalue, String isdisplayed, String buttonclass, String includesemptyitem, String adOrgId, String line, String onchangeevent, String islinebreak, String mandantorylogic, String style, String referenceurl, String leadingemptycols, String readonlylogic)    throws ServletException {
    FieldColumnsInstanceSpecificData objectFieldColumnsInstanceSpecificData[] = new FieldColumnsInstanceSpecificData[1];
    objectFieldColumnsInstanceSpecificData[0] = new FieldColumnsInstanceSpecificData();
    objectFieldColumnsInstanceSpecificData[0].created = "";
    objectFieldColumnsInstanceSpecificData[0].createdbyr = createdbyr;
    objectFieldColumnsInstanceSpecificData[0].updated = "";
    objectFieldColumnsInstanceSpecificData[0].updatedTimeStamp = "";
    objectFieldColumnsInstanceSpecificData[0].updatedby = updatedby;
    objectFieldColumnsInstanceSpecificData[0].updatedbyr = updatedbyr;
    objectFieldColumnsInstanceSpecificData[0].adRefFieldcolumnId = adRefFieldcolumnId;
    objectFieldColumnsInstanceSpecificData[0].adRefFieldcolumnIdr = "";
    objectFieldColumnsInstanceSpecificData[0].adRefFieldcolumninstanceId = adRefFieldcolumninstanceId;
    objectFieldColumnsInstanceSpecificData[0].line = line;
    objectFieldColumnsInstanceSpecificData[0].adClientId = adClientId;
    objectFieldColumnsInstanceSpecificData[0].adElementId = adElementId;
    objectFieldColumnsInstanceSpecificData[0].adElementIdr = "";
    objectFieldColumnsInstanceSpecificData[0].adOrgId = adOrgId;
    objectFieldColumnsInstanceSpecificData[0].leadingemptycols = leadingemptycols;
    objectFieldColumnsInstanceSpecificData[0].colstotal = colstotal;
    objectFieldColumnsInstanceSpecificData[0].isfirstfocusedfield = isfirstfocusedfield;
    objectFieldColumnsInstanceSpecificData[0].isfirstfocusedfieldr = "";
    objectFieldColumnsInstanceSpecificData[0].editsetting = editsetting;
    objectFieldColumnsInstanceSpecificData[0].editsettingr = "";
    objectFieldColumnsInstanceSpecificData[0].maxlength = maxlength;
    objectFieldColumnsInstanceSpecificData[0].fieldreference = fieldreference;
    objectFieldColumnsInstanceSpecificData[0].fieldreferencer = "";
    objectFieldColumnsInstanceSpecificData[0].referenceurl = referenceurl;
    objectFieldColumnsInstanceSpecificData[0].adTableId = adTableId;
    objectFieldColumnsInstanceSpecificData[0].adTableIdr = "";
    objectFieldColumnsInstanceSpecificData[0].adValRuleId = adValRuleId;
    objectFieldColumnsInstanceSpecificData[0].adValRuleIdr = "";
    objectFieldColumnsInstanceSpecificData[0].includesemptyitem = includesemptyitem;
    objectFieldColumnsInstanceSpecificData[0].includesemptyitemr = "";
    objectFieldColumnsInstanceSpecificData[0].template = template;
    objectFieldColumnsInstanceSpecificData[0].templater = "";
    objectFieldColumnsInstanceSpecificData[0].buttonclass = buttonclass;
    objectFieldColumnsInstanceSpecificData[0].islinebreak = islinebreak;
    objectFieldColumnsInstanceSpecificData[0].islinebreakr = "";
    objectFieldColumnsInstanceSpecificData[0].isdisplayed = isdisplayed;
    objectFieldColumnsInstanceSpecificData[0].isactive = isactive;
    objectFieldColumnsInstanceSpecificData[0].visiblesetting = visiblesetting;
    objectFieldColumnsInstanceSpecificData[0].visiblesettingr = "";
    objectFieldColumnsInstanceSpecificData[0].displaylogic = displaylogic;
    objectFieldColumnsInstanceSpecificData[0].readonlylogic = readonlylogic;
    objectFieldColumnsInstanceSpecificData[0].mandantorylogic = mandantorylogic;
    objectFieldColumnsInstanceSpecificData[0].defaultvalue = defaultvalue;
    objectFieldColumnsInstanceSpecificData[0].style = style;
    objectFieldColumnsInstanceSpecificData[0].onchangeevent = onchangeevent;
    objectFieldColumnsInstanceSpecificData[0].language = "";
    return objectFieldColumnsInstanceSpecificData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefEEC307933AC7464493D6F837D29DE356_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefE99A70AF5AAF468EADAE54B850666583_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumn_ID AS NAME" +
      "        FROM ad_ref_fieldcolumninstance" +
      "        WHERE ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumninstance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adRefFieldcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_ref_fieldcolumn left join (select AD_Ref_Fieldcolumn_ID, Name from AD_Ref_Fieldcolumn) table1 on (ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = table1.AD_Ref_Fieldcolumn_ID) WHERE ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adRefFieldcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_ref_fieldcolumn left join (select AD_Ref_Fieldcolumn_ID, Name from AD_Ref_Fieldcolumn) table1 on (ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = table1.AD_Ref_Fieldcolumn_ID) WHERE ad_ref_fieldcolumn.AD_Ref_Fieldcolumn_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);

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
      "        UPDATE ad_ref_fieldcolumninstance" +
      "        SET AD_Ref_Fieldcolumn_ID = (?) , AD_Ref_Fieldcolumninstance_ID = (?) , Line = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Element_ID = (?) , AD_Org_ID = (?) , Leadingemptycols = TO_NUMBER(?) , Colstotal = TO_NUMBER(?) , Isfirstfocusedfield = (?) , Editsetting = (?) , Maxlength = TO_NUMBER(?) , Fieldreference = (?) , Referenceurl = (?) , AD_Table_ID = (?) , AD_Val_Rule_ID = (?) , Includesemptyitem = (?) , Template = (?) , Buttonclass = (?) , Islinebreak = (?) , Isdisplayed = (?) , Isactive = (?) , Visiblesetting = (?) , Displaylogic = (?) , Readonlylogic = (?) , Mandantorylogic = (?) , Defaultvalue = (?) , Style = (?) , Onchangeevent = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumninstance_ID = ? " +
      "                 AND ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumn_ID = ? " +
      "        AND ad_ref_fieldcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_fieldcolumninstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, leadingemptycols);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islinebreak);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, style);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);
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
      "        INSERT INTO ad_ref_fieldcolumninstance " +
      "        (AD_Ref_Fieldcolumn_ID, AD_Ref_Fieldcolumninstance_ID, Line, AD_Client_ID, AD_Element_ID, AD_Org_ID, Leadingemptycols, Colstotal, Isfirstfocusedfield, Editsetting, Maxlength, Fieldreference, Referenceurl, AD_Table_ID, AD_Val_Rule_ID, Includesemptyitem, Template, Buttonclass, Islinebreak, Isdisplayed, Isactive, Visiblesetting, Displaylogic, Readonlylogic, Mandantorylogic, Defaultvalue, Style, Onchangeevent, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, leadingemptycols);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colstotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfirstfocusedfield);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, buttonclass);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, islinebreak);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, displaylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, style);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefFieldcolumnId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_fieldcolumninstance" +
      "        WHERE ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumninstance_ID = ? " +
      "                 AND ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumn_ID = ? " +
      "        AND ad_ref_fieldcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_fieldcolumninstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefFieldcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_fieldcolumninstance" +
      "        WHERE ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumninstance_ID = ? " +
      "                 AND ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumn_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefFieldcolumnId);

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
      "          FROM ad_ref_fieldcolumninstance" +
      "         WHERE ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumninstance_ID = ? ";

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
      "          FROM ad_ref_fieldcolumninstance" +
      "         WHERE ad_ref_fieldcolumninstance.AD_Ref_Fieldcolumninstance_ID = ? ";

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

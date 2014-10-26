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
class GridColumnsInstancespecificData implements FieldProvider {
static Logger log4j = Logger.getLogger(GridColumnsInstancespecificData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefGridcolumnId;
  public String adRefGridcolumnIdr;
  public String adElementId;
  public String adElementIdr;
  public String isactive;
  public String line;
  public String visiblesetting;
  public String visiblesettingr;
  public String colspan;
  public String template;
  public String templater;
  public String issortable;
  public String onchangeevent;
  public String referenceurl;
  public String rowkeysuffix;
  public String isrowkey;
  public String maxlength;
  public String issecondheader;
  public String issplitgroup;
  public String colreference;
  public String adClientId;
  public String adValRuleId;
  public String isdisplayed;
  public String mandantorylogic;
  public String readonlylogic;
  public String isinheader;
  public String name;
  public String adRefGridcolumninstanceId;
  public String readonly;
  public String required;
  public String headertext;
  public String adOrgId;
  public String editsetting;
  public String defaultvalue;
  public String includesemptyitem;
  public String adTableId;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumn_id") || fieldName.equals("adRefGridcolumnId"))
      return adRefGridcolumnId;
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumn_idr") || fieldName.equals("adRefGridcolumnIdr"))
      return adRefGridcolumnIdr;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_element_idr") || fieldName.equals("adElementIdr"))
      return adElementIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("visiblesetting"))
      return visiblesetting;
    else if (fieldName.equalsIgnoreCase("visiblesettingr"))
      return visiblesettingr;
    else if (fieldName.equalsIgnoreCase("colspan"))
      return colspan;
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("templater"))
      return templater;
    else if (fieldName.equalsIgnoreCase("issortable"))
      return issortable;
    else if (fieldName.equalsIgnoreCase("onchangeevent"))
      return onchangeevent;
    else if (fieldName.equalsIgnoreCase("referenceurl"))
      return referenceurl;
    else if (fieldName.equalsIgnoreCase("rowkeysuffix"))
      return rowkeysuffix;
    else if (fieldName.equalsIgnoreCase("isrowkey"))
      return isrowkey;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("issecondheader"))
      return issecondheader;
    else if (fieldName.equalsIgnoreCase("issplitgroup"))
      return issplitgroup;
    else if (fieldName.equalsIgnoreCase("colreference"))
      return colreference;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("mandantorylogic"))
      return mandantorylogic;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("isinheader"))
      return isinheader;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumninstance_id") || fieldName.equals("adRefGridcolumninstanceId"))
      return adRefGridcolumninstanceId;
    else if (fieldName.equalsIgnoreCase("readonly"))
      return readonly;
    else if (fieldName.equalsIgnoreCase("required"))
      return required;
    else if (fieldName.equalsIgnoreCase("headertext"))
      return headertext;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("editsetting"))
      return editsetting;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("includesemptyitem"))
      return includesemptyitem;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
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
  public static GridColumnsInstancespecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefGridcolumnId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefGridcolumnId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static GridColumnsInstancespecificData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefGridcolumnId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_gridcolumninstance.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_gridcolumninstance.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_gridcolumninstance.Updated, ?) as updated, " +
      "        to_char(ad_ref_gridcolumninstance.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_gridcolumninstance.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_gridcolumninstance.UpdatedBy) as UpdatedByR," +
      "        ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID, " +
      "(CASE WHEN ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Ref_Gridcolumn_IDR, " +
      "ad_ref_gridcolumninstance.AD_Element_ID, " +
      "(CASE WHEN ad_ref_gridcolumninstance.AD_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.ColumnName), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Element_IDR, " +
      "COALESCE(ad_ref_gridcolumninstance.Isactive, 'N') AS Isactive, " +
      "ad_ref_gridcolumninstance.Line, " +
      "ad_ref_gridcolumninstance.Visiblesetting, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Visiblesetting IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS VisiblesettingR, " +
      "ad_ref_gridcolumninstance.Colspan, " +
      "ad_ref_gridcolumninstance.Template, " +
      "(CASE WHEN ad_ref_gridcolumninstance.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS TemplateR, " +
      "ad_ref_gridcolumninstance.Issortable, " +
      "ad_ref_gridcolumninstance.Onchangeevent, " +
      "ad_ref_gridcolumninstance.Referenceurl, " +
      "ad_ref_gridcolumninstance.Rowkeysuffix, " +
      "COALESCE(ad_ref_gridcolumninstance.Isrowkey, 'N') AS Isrowkey, " +
      "ad_ref_gridcolumninstance.Maxlength, " +
      "ad_ref_gridcolumninstance.Issecondheader, " +
      "ad_ref_gridcolumninstance.Issplitgroup, " +
      "ad_ref_gridcolumninstance.Colreference, " +
      "ad_ref_gridcolumninstance.AD_Client_ID, " +
      "ad_ref_gridcolumninstance.AD_Val_Rule_ID, " +
      "COALESCE(ad_ref_gridcolumninstance.Isdisplayed, 'N') AS Isdisplayed, " +
      "ad_ref_gridcolumninstance.Mandantorylogic, " +
      "ad_ref_gridcolumninstance.Readonlylogic, " +
      "ad_ref_gridcolumninstance.Isinheader, " +
      "ad_ref_gridcolumninstance.Name, " +
      "ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID, " +
      "COALESCE(ad_ref_gridcolumninstance.Readonly, 'N') AS Readonly, " +
      "ad_ref_gridcolumninstance.Required, " +
      "ad_ref_gridcolumninstance.Headertext, " +
      "ad_ref_gridcolumninstance.AD_Org_ID, " +
      "ad_ref_gridcolumninstance.Editsetting, " +
      "ad_ref_gridcolumninstance.Defaultvalue, " +
      "ad_ref_gridcolumninstance.Includesemptyitem, " +
      "ad_ref_gridcolumninstance.AD_Table_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_gridcolumninstance left join (select AD_Ref_Gridcolumn_ID, Name from AD_Ref_Gridcolumn) table1 on (ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = table1.AD_Ref_Gridcolumn_ID) left join (select AD_Element_ID, ColumnName, Name from AD_Element) table2 on (ad_ref_gridcolumninstance.AD_Element_ID = table2.AD_Element_ID) left join ad_ref_list_v list1 on (ad_ref_gridcolumninstance.Visiblesetting = list1.value and list1.ad_reference_id = 'A4801B9D7ADB4BB69EBF727B71C8AB45' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (ad_ref_gridcolumninstance.Template = list2.value and list2.ad_reference_id = '93AAB50006A24AA4ADC854D6A0D8B716' and list2.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefGridcolumnId==null || adRefGridcolumnId.equals(""))?"":"  AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? " +
      "        AND ad_ref_gridcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_gridcolumninstance.AD_Org_ID IN (";
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
      if (adRefGridcolumnId != null && !(adRefGridcolumnId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
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
        GridColumnsInstancespecificData objectGridColumnsInstancespecificData = new GridColumnsInstancespecificData();
        objectGridColumnsInstancespecificData.created = UtilSql.getValue(result, "created");
        objectGridColumnsInstancespecificData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectGridColumnsInstancespecificData.updated = UtilSql.getValue(result, "updated");
        objectGridColumnsInstancespecificData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectGridColumnsInstancespecificData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGridColumnsInstancespecificData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectGridColumnsInstancespecificData.adRefGridcolumnId = UtilSql.getValue(result, "ad_ref_gridcolumn_id");
        objectGridColumnsInstancespecificData.adRefGridcolumnIdr = UtilSql.getValue(result, "ad_ref_gridcolumn_idr");
        objectGridColumnsInstancespecificData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectGridColumnsInstancespecificData.adElementIdr = UtilSql.getValue(result, "ad_element_idr");
        objectGridColumnsInstancespecificData.isactive = UtilSql.getValue(result, "isactive");
        objectGridColumnsInstancespecificData.line = UtilSql.getValue(result, "line");
        objectGridColumnsInstancespecificData.visiblesetting = UtilSql.getValue(result, "visiblesetting");
        objectGridColumnsInstancespecificData.visiblesettingr = UtilSql.getValue(result, "visiblesettingr");
        objectGridColumnsInstancespecificData.colspan = UtilSql.getValue(result, "colspan");
        objectGridColumnsInstancespecificData.template = UtilSql.getValue(result, "template");
        objectGridColumnsInstancespecificData.templater = UtilSql.getValue(result, "templater");
        objectGridColumnsInstancespecificData.issortable = UtilSql.getValue(result, "issortable");
        objectGridColumnsInstancespecificData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectGridColumnsInstancespecificData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectGridColumnsInstancespecificData.rowkeysuffix = UtilSql.getValue(result, "rowkeysuffix");
        objectGridColumnsInstancespecificData.isrowkey = UtilSql.getValue(result, "isrowkey");
        objectGridColumnsInstancespecificData.maxlength = UtilSql.getValue(result, "maxlength");
        objectGridColumnsInstancespecificData.issecondheader = UtilSql.getValue(result, "issecondheader");
        objectGridColumnsInstancespecificData.issplitgroup = UtilSql.getValue(result, "issplitgroup");
        objectGridColumnsInstancespecificData.colreference = UtilSql.getValue(result, "colreference");
        objectGridColumnsInstancespecificData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGridColumnsInstancespecificData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectGridColumnsInstancespecificData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectGridColumnsInstancespecificData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectGridColumnsInstancespecificData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectGridColumnsInstancespecificData.isinheader = UtilSql.getValue(result, "isinheader");
        objectGridColumnsInstancespecificData.name = UtilSql.getValue(result, "name");
        objectGridColumnsInstancespecificData.adRefGridcolumninstanceId = UtilSql.getValue(result, "ad_ref_gridcolumninstance_id");
        objectGridColumnsInstancespecificData.readonly = UtilSql.getValue(result, "readonly");
        objectGridColumnsInstancespecificData.required = UtilSql.getValue(result, "required");
        objectGridColumnsInstancespecificData.headertext = UtilSql.getValue(result, "headertext");
        objectGridColumnsInstancespecificData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGridColumnsInstancespecificData.editsetting = UtilSql.getValue(result, "editsetting");
        objectGridColumnsInstancespecificData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectGridColumnsInstancespecificData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectGridColumnsInstancespecificData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectGridColumnsInstancespecificData.language = UtilSql.getValue(result, "language");
        objectGridColumnsInstancespecificData.adUserClient = "";
        objectGridColumnsInstancespecificData.adOrgClient = "";
        objectGridColumnsInstancespecificData.createdby = "";
        objectGridColumnsInstancespecificData.trBgcolor = "";
        objectGridColumnsInstancespecificData.totalCount = "";
        objectGridColumnsInstancespecificData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGridColumnsInstancespecificData);
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
    GridColumnsInstancespecificData objectGridColumnsInstancespecificData[] = new GridColumnsInstancespecificData[vector.size()];
    vector.copyInto(objectGridColumnsInstancespecificData);
    return(objectGridColumnsInstancespecificData);
  }

/**
Create a registry
 */
  public static GridColumnsInstancespecificData[] set(String adRefGridcolumnId, String onchangeevent, String issecondheader, String colspan, String issortable, String headertext, String editsetting, String template, String isinheader, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String isrowkey, String includesemptyitem, String adValRuleId, String adTableId, String visiblesetting, String maxlength, String referenceurl, String issplitgroup, String colreference, String mandantorylogic, String adElementId, String readonlylogic, String isdisplayed, String name, String adRefGridcolumninstanceId, String readonly, String adClientId, String adOrgId, String defaultvalue, String line, String required, String rowkeysuffix)    throws ServletException {
    GridColumnsInstancespecificData objectGridColumnsInstancespecificData[] = new GridColumnsInstancespecificData[1];
    objectGridColumnsInstancespecificData[0] = new GridColumnsInstancespecificData();
    objectGridColumnsInstancespecificData[0].created = "";
    objectGridColumnsInstancespecificData[0].createdbyr = createdbyr;
    objectGridColumnsInstancespecificData[0].updated = "";
    objectGridColumnsInstancespecificData[0].updatedTimeStamp = "";
    objectGridColumnsInstancespecificData[0].updatedby = updatedby;
    objectGridColumnsInstancespecificData[0].updatedbyr = updatedbyr;
    objectGridColumnsInstancespecificData[0].adRefGridcolumnId = adRefGridcolumnId;
    objectGridColumnsInstancespecificData[0].adRefGridcolumnIdr = "";
    objectGridColumnsInstancespecificData[0].adElementId = adElementId;
    objectGridColumnsInstancespecificData[0].adElementIdr = "";
    objectGridColumnsInstancespecificData[0].isactive = isactive;
    objectGridColumnsInstancespecificData[0].line = line;
    objectGridColumnsInstancespecificData[0].visiblesetting = visiblesetting;
    objectGridColumnsInstancespecificData[0].visiblesettingr = "";
    objectGridColumnsInstancespecificData[0].colspan = colspan;
    objectGridColumnsInstancespecificData[0].template = template;
    objectGridColumnsInstancespecificData[0].templater = "";
    objectGridColumnsInstancespecificData[0].issortable = issortable;
    objectGridColumnsInstancespecificData[0].onchangeevent = onchangeevent;
    objectGridColumnsInstancespecificData[0].referenceurl = referenceurl;
    objectGridColumnsInstancespecificData[0].rowkeysuffix = rowkeysuffix;
    objectGridColumnsInstancespecificData[0].isrowkey = isrowkey;
    objectGridColumnsInstancespecificData[0].maxlength = maxlength;
    objectGridColumnsInstancespecificData[0].issecondheader = issecondheader;
    objectGridColumnsInstancespecificData[0].issplitgroup = issplitgroup;
    objectGridColumnsInstancespecificData[0].colreference = colreference;
    objectGridColumnsInstancespecificData[0].adClientId = adClientId;
    objectGridColumnsInstancespecificData[0].adValRuleId = adValRuleId;
    objectGridColumnsInstancespecificData[0].isdisplayed = isdisplayed;
    objectGridColumnsInstancespecificData[0].mandantorylogic = mandantorylogic;
    objectGridColumnsInstancespecificData[0].readonlylogic = readonlylogic;
    objectGridColumnsInstancespecificData[0].isinheader = isinheader;
    objectGridColumnsInstancespecificData[0].name = name;
    objectGridColumnsInstancespecificData[0].adRefGridcolumninstanceId = adRefGridcolumninstanceId;
    objectGridColumnsInstancespecificData[0].readonly = readonly;
    objectGridColumnsInstancespecificData[0].required = required;
    objectGridColumnsInstancespecificData[0].headertext = headertext;
    objectGridColumnsInstancespecificData[0].adOrgId = adOrgId;
    objectGridColumnsInstancespecificData[0].editsetting = editsetting;
    objectGridColumnsInstancespecificData[0].defaultvalue = defaultvalue;
    objectGridColumnsInstancespecificData[0].includesemptyitem = includesemptyitem;
    objectGridColumnsInstancespecificData[0].adTableId = adTableId;
    objectGridColumnsInstancespecificData[0].language = "";
    return objectGridColumnsInstancespecificData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefDA259AB1C5404BF28209DD6044B06665_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef3DDD02B35DF144DAB8EA2AD0B560A0D9_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID AS NAME" +
      "        FROM ad_ref_gridcolumninstance" +
      "        WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adRefGridcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_ref_gridcolumn left join (select AD_Ref_Gridcolumn_ID, Name from AD_Ref_Gridcolumn) table1 on (ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = table1.AD_Ref_Gridcolumn_ID) WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adRefGridcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM ad_ref_gridcolumn left join (select AD_Ref_Gridcolumn_ID, Name from AD_Ref_Gridcolumn) table1 on (ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = table1.AD_Ref_Gridcolumn_ID) WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);

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
      "        UPDATE ad_ref_gridcolumninstance" +
      "        SET AD_Ref_Gridcolumn_ID = (?) , AD_Element_ID = (?) , Isactive = (?) , Line = TO_NUMBER(?) , Visiblesetting = (?) , Colspan = TO_NUMBER(?) , Template = (?) , Issortable = (?) , Onchangeevent = (?) , Referenceurl = (?) , Rowkeysuffix = (?) , Isrowkey = (?) , Maxlength = TO_NUMBER(?) , Issecondheader = (?) , Issplitgroup = (?) , Colreference = (?) , AD_Client_ID = (?) , AD_Val_Rule_ID = (?) , Isdisplayed = (?) , Mandantorylogic = (?) , Readonlylogic = (?) , Isinheader = (?) , Name = (?) , AD_Ref_Gridcolumninstance_ID = (?) , Readonly = (?) , Required = (?) , Headertext = (?) , AD_Org_ID = (?) , Editsetting = (?) , Defaultvalue = (?) , Includesemptyitem = (?) , AD_Table_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? " +
      "                 AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = ? " +
      "        AND ad_ref_gridcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_gridcolumninstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colspan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issortable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rowkeysuffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrowkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issecondheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issplitgroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
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
      "        INSERT INTO ad_ref_gridcolumninstance " +
      "        (AD_Ref_Gridcolumn_ID, AD_Element_ID, Isactive, Line, Visiblesetting, Colspan, Template, Issortable, Onchangeevent, Referenceurl, Rowkeysuffix, Isrowkey, Maxlength, Issecondheader, Issplitgroup, Colreference, AD_Client_ID, AD_Val_Rule_ID, Isdisplayed, Mandantorylogic, Readonlylogic, Isinheader, Name, AD_Ref_Gridcolumninstance_ID, Readonly, Required, Headertext, AD_Org_ID, Editsetting, Defaultvalue, Includesemptyitem, AD_Table_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, visiblesetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colspan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issortable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rowkeysuffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrowkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issecondheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issplitgroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumninstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, editsetting);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefGridcolumnId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_gridcolumninstance" +
      "        WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? " +
      "                 AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = ? " +
      "        AND ad_ref_gridcolumninstance.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_gridcolumninstance.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefGridcolumnId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_gridcolumninstance" +
      "        WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? " +
      "                 AND ad_ref_gridcolumninstance.AD_Ref_Gridcolumn_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);

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
      "          FROM ad_ref_gridcolumninstance" +
      "         WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? ";

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
      "          FROM ad_ref_gridcolumninstance" +
      "         WHERE ad_ref_gridcolumninstance.AD_Ref_Gridcolumninstance_ID = ? ";

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

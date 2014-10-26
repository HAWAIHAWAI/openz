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
class SimpleGridGolumnsData implements FieldProvider {
static Logger log4j = Logger.getLogger(SimpleGridGolumnsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefGridcolumnId;
  public String isactive;
  public String line;
  public String adRefGroupId;
  public String name;
  public String adClientId;
  public String adElementId;
  public String adElementIdr;
  public String adOrgId;
  public String colspan;
  public String isdisplayed;
  public String headertext;
  public String template;
  public String templater;
  public String issortable;
  public String isrowkey;
  public String adReferenceId;
  public String rowkeysuffix;
  public String referenceurl;
  public String adTableId;
  public String maxlength;
  public String required;
  public String readonly;
  public String isinheader;
  public String issplitgroup;
  public String colreference;
  public String adValRuleId;
  public String includesemptyitem;
  public String readonlylogic;
  public String mandantorylogic;
  public String defaultvalue;
  public String issecondheader;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumn_id") || fieldName.equals("adRefGridcolumnId"))
      return adRefGridcolumnId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_ref_group_id") || fieldName.equals("adRefGroupId"))
      return adRefGroupId;
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
    else if (fieldName.equalsIgnoreCase("colspan"))
      return colspan;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("headertext"))
      return headertext;
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("templater"))
      return templater;
    else if (fieldName.equalsIgnoreCase("issortable"))
      return issortable;
    else if (fieldName.equalsIgnoreCase("isrowkey"))
      return isrowkey;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("rowkeysuffix"))
      return rowkeysuffix;
    else if (fieldName.equalsIgnoreCase("referenceurl"))
      return referenceurl;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("required"))
      return required;
    else if (fieldName.equalsIgnoreCase("readonly"))
      return readonly;
    else if (fieldName.equalsIgnoreCase("isinheader"))
      return isinheader;
    else if (fieldName.equalsIgnoreCase("issplitgroup"))
      return issplitgroup;
    else if (fieldName.equalsIgnoreCase("colreference"))
      return colreference;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("includesemptyitem"))
      return includesemptyitem;
    else if (fieldName.equalsIgnoreCase("readonlylogic"))
      return readonlylogic;
    else if (fieldName.equalsIgnoreCase("mandantorylogic"))
      return mandantorylogic;
    else if (fieldName.equalsIgnoreCase("defaultvalue"))
      return defaultvalue;
    else if (fieldName.equalsIgnoreCase("issecondheader"))
      return issecondheader;
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
  public static SimpleGridGolumnsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adReferenceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SimpleGridGolumnsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adReferenceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_gridcolumn.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_gridcolumn.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_gridcolumn.Updated, ?) as updated, " +
      "        to_char(ad_ref_gridcolumn.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_gridcolumn.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_gridcolumn.UpdatedBy) as UpdatedByR," +
      "        ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID, " +
      "COALESCE(ad_ref_gridcolumn.Isactive, 'N') AS Isactive, " +
      "ad_ref_gridcolumn.Line, " +
      "ad_ref_gridcolumn.AD_Ref_Group_ID, " +
      "ad_ref_gridcolumn.Name, " +
      "ad_ref_gridcolumn.AD_Client_ID, " +
      "ad_ref_gridcolumn.AD_Element_ID, " +
      "(CASE WHEN ad_ref_gridcolumn.AD_Element_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.ColumnName), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Element_IDR, " +
      "ad_ref_gridcolumn.AD_Org_ID, " +
      "ad_ref_gridcolumn.Colspan, " +
      "COALESCE(ad_ref_gridcolumn.Isdisplayed, 'N') AS Isdisplayed, " +
      "ad_ref_gridcolumn.Headertext, " +
      "ad_ref_gridcolumn.Template, " +
      "(CASE WHEN ad_ref_gridcolumn.Template IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS TemplateR, " +
      "COALESCE(ad_ref_gridcolumn.Issortable, 'N') AS Issortable, " +
      "COALESCE(ad_ref_gridcolumn.Isrowkey, 'N') AS Isrowkey, " +
      "ad_ref_gridcolumn.AD_Reference_ID, " +
      "ad_ref_gridcolumn.Rowkeysuffix, " +
      "ad_ref_gridcolumn.Referenceurl, " +
      "ad_ref_gridcolumn.AD_Table_ID, " +
      "ad_ref_gridcolumn.MaxLength, " +
      "COALESCE(ad_ref_gridcolumn.Required, 'N') AS Required, " +
      "COALESCE(ad_ref_gridcolumn.ReadOnly, 'N') AS ReadOnly, " +
      "COALESCE(ad_ref_gridcolumn.Isinheader, 'N') AS Isinheader, " +
      "COALESCE(ad_ref_gridcolumn.Issplitgroup, 'N') AS Issplitgroup, " +
      "ad_ref_gridcolumn.colreference, " +
      "ad_ref_gridcolumn.AD_Val_Rule_ID, " +
      "COALESCE(ad_ref_gridcolumn.Includesemptyitem, 'N') AS Includesemptyitem, " +
      "ad_ref_gridcolumn.Readonlylogic, " +
      "ad_ref_gridcolumn.Mandantorylogic, " +
      "ad_ref_gridcolumn.Defaultvalue, " +
      "COALESCE(ad_ref_gridcolumn.Issecondheader, 'N') AS Issecondheader, " +
      "ad_ref_gridcolumn.Onchangeevent, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_gridcolumn left join (select AD_Element_ID, ColumnName, Name from AD_Element) table1 on (ad_ref_gridcolumn.AD_Element_ID = table1.AD_Element_ID) left join ad_ref_list_v list1 on (ad_ref_gridcolumn.Template = list1.value and list1.ad_reference_id = '93AAB50006A24AA4ADC854D6A0D8B716' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adReferenceId==null || adReferenceId.equals(""))?"":"  AND ad_ref_gridcolumn.AD_Reference_ID = ?  ");
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
        SimpleGridGolumnsData objectSimpleGridGolumnsData = new SimpleGridGolumnsData();
        objectSimpleGridGolumnsData.created = UtilSql.getValue(result, "created");
        objectSimpleGridGolumnsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSimpleGridGolumnsData.updated = UtilSql.getValue(result, "updated");
        objectSimpleGridGolumnsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSimpleGridGolumnsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectSimpleGridGolumnsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSimpleGridGolumnsData.adRefGridcolumnId = UtilSql.getValue(result, "ad_ref_gridcolumn_id");
        objectSimpleGridGolumnsData.isactive = UtilSql.getValue(result, "isactive");
        objectSimpleGridGolumnsData.line = UtilSql.getValue(result, "line");
        objectSimpleGridGolumnsData.adRefGroupId = UtilSql.getValue(result, "ad_ref_group_id");
        objectSimpleGridGolumnsData.name = UtilSql.getValue(result, "name");
        objectSimpleGridGolumnsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSimpleGridGolumnsData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectSimpleGridGolumnsData.adElementIdr = UtilSql.getValue(result, "ad_element_idr");
        objectSimpleGridGolumnsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSimpleGridGolumnsData.colspan = UtilSql.getValue(result, "colspan");
        objectSimpleGridGolumnsData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectSimpleGridGolumnsData.headertext = UtilSql.getValue(result, "headertext");
        objectSimpleGridGolumnsData.template = UtilSql.getValue(result, "template");
        objectSimpleGridGolumnsData.templater = UtilSql.getValue(result, "templater");
        objectSimpleGridGolumnsData.issortable = UtilSql.getValue(result, "issortable");
        objectSimpleGridGolumnsData.isrowkey = UtilSql.getValue(result, "isrowkey");
        objectSimpleGridGolumnsData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectSimpleGridGolumnsData.rowkeysuffix = UtilSql.getValue(result, "rowkeysuffix");
        objectSimpleGridGolumnsData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectSimpleGridGolumnsData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectSimpleGridGolumnsData.maxlength = UtilSql.getValue(result, "maxlength");
        objectSimpleGridGolumnsData.required = UtilSql.getValue(result, "required");
        objectSimpleGridGolumnsData.readonly = UtilSql.getValue(result, "readonly");
        objectSimpleGridGolumnsData.isinheader = UtilSql.getValue(result, "isinheader");
        objectSimpleGridGolumnsData.issplitgroup = UtilSql.getValue(result, "issplitgroup");
        objectSimpleGridGolumnsData.colreference = UtilSql.getValue(result, "colreference");
        objectSimpleGridGolumnsData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectSimpleGridGolumnsData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectSimpleGridGolumnsData.readonlylogic = UtilSql.getValue(result, "readonlylogic");
        objectSimpleGridGolumnsData.mandantorylogic = UtilSql.getValue(result, "mandantorylogic");
        objectSimpleGridGolumnsData.defaultvalue = UtilSql.getValue(result, "defaultvalue");
        objectSimpleGridGolumnsData.issecondheader = UtilSql.getValue(result, "issecondheader");
        objectSimpleGridGolumnsData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectSimpleGridGolumnsData.language = UtilSql.getValue(result, "language");
        objectSimpleGridGolumnsData.adUserClient = "";
        objectSimpleGridGolumnsData.adOrgClient = "";
        objectSimpleGridGolumnsData.createdby = "";
        objectSimpleGridGolumnsData.trBgcolor = "";
        objectSimpleGridGolumnsData.totalCount = "";
        objectSimpleGridGolumnsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSimpleGridGolumnsData);
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
    SimpleGridGolumnsData objectSimpleGridGolumnsData[] = new SimpleGridGolumnsData[vector.size()];
    vector.copyInto(objectSimpleGridGolumnsData);
    return(objectSimpleGridGolumnsData);
  }

/**
Create a registry
 */
  public static SimpleGridGolumnsData[] set(String adReferenceId, String isinheader, String updatedby, String updatedbyr, String adElementId, String issecondheader, String referenceurl, String mandantorylogic, String adClientId, String headertext, String readonlylogic, String createdby, String createdbyr, String colreference, String adOrgId, String adValRuleId, String isactive, String maxlength, String line, String colspan, String isrowkey, String adRefGridcolumnId, String issortable, String rowkeysuffix, String onchangeevent, String required, String adTableId, String isdisplayed, String defaultvalue, String adRefGroupId, String includesemptyitem, String template, String readonly, String issplitgroup, String name)    throws ServletException {
    SimpleGridGolumnsData objectSimpleGridGolumnsData[] = new SimpleGridGolumnsData[1];
    objectSimpleGridGolumnsData[0] = new SimpleGridGolumnsData();
    objectSimpleGridGolumnsData[0].created = "";
    objectSimpleGridGolumnsData[0].createdbyr = createdbyr;
    objectSimpleGridGolumnsData[0].updated = "";
    objectSimpleGridGolumnsData[0].updatedTimeStamp = "";
    objectSimpleGridGolumnsData[0].updatedby = updatedby;
    objectSimpleGridGolumnsData[0].updatedbyr = updatedbyr;
    objectSimpleGridGolumnsData[0].adRefGridcolumnId = adRefGridcolumnId;
    objectSimpleGridGolumnsData[0].isactive = isactive;
    objectSimpleGridGolumnsData[0].line = line;
    objectSimpleGridGolumnsData[0].adRefGroupId = adRefGroupId;
    objectSimpleGridGolumnsData[0].name = name;
    objectSimpleGridGolumnsData[0].adClientId = adClientId;
    objectSimpleGridGolumnsData[0].adElementId = adElementId;
    objectSimpleGridGolumnsData[0].adElementIdr = "";
    objectSimpleGridGolumnsData[0].adOrgId = adOrgId;
    objectSimpleGridGolumnsData[0].colspan = colspan;
    objectSimpleGridGolumnsData[0].isdisplayed = isdisplayed;
    objectSimpleGridGolumnsData[0].headertext = headertext;
    objectSimpleGridGolumnsData[0].template = template;
    objectSimpleGridGolumnsData[0].templater = "";
    objectSimpleGridGolumnsData[0].issortable = issortable;
    objectSimpleGridGolumnsData[0].isrowkey = isrowkey;
    objectSimpleGridGolumnsData[0].adReferenceId = adReferenceId;
    objectSimpleGridGolumnsData[0].rowkeysuffix = rowkeysuffix;
    objectSimpleGridGolumnsData[0].referenceurl = referenceurl;
    objectSimpleGridGolumnsData[0].adTableId = adTableId;
    objectSimpleGridGolumnsData[0].maxlength = maxlength;
    objectSimpleGridGolumnsData[0].required = required;
    objectSimpleGridGolumnsData[0].readonly = readonly;
    objectSimpleGridGolumnsData[0].isinheader = isinheader;
    objectSimpleGridGolumnsData[0].issplitgroup = issplitgroup;
    objectSimpleGridGolumnsData[0].colreference = colreference;
    objectSimpleGridGolumnsData[0].adValRuleId = adValRuleId;
    objectSimpleGridGolumnsData[0].includesemptyitem = includesemptyitem;
    objectSimpleGridGolumnsData[0].readonlylogic = readonlylogic;
    objectSimpleGridGolumnsData[0].mandantorylogic = mandantorylogic;
    objectSimpleGridGolumnsData[0].defaultvalue = defaultvalue;
    objectSimpleGridGolumnsData[0].issecondheader = issecondheader;
    objectSimpleGridGolumnsData[0].onchangeevent = onchangeevent;
    objectSimpleGridGolumnsData[0].language = "";
    return objectSimpleGridGolumnsData;
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
      "        SELECT ad_ref_gridcolumn.AD_Reference_ID AS NAME" +
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
      "        UPDATE ad_ref_gridcolumn" +
      "        SET AD_Ref_Gridcolumn_ID = (?) , Isactive = (?) , Line = TO_NUMBER(?) , AD_Ref_Group_ID = (?) , Name = (?) , AD_Client_ID = (?) , AD_Element_ID = (?) , AD_Org_ID = (?) , Colspan = TO_NUMBER(?) , Isdisplayed = (?) , Headertext = (?) , Template = (?) , Issortable = (?) , Isrowkey = (?) , AD_Reference_ID = (?) , Rowkeysuffix = (?) , Referenceurl = (?) , AD_Table_ID = (?) , MaxLength = TO_NUMBER(?) , Required = (?) , ReadOnly = (?) , Isinheader = (?) , Issplitgroup = (?) , colreference = (?) , AD_Val_Rule_ID = (?) , Includesemptyitem = (?) , Readonlylogic = (?) , Mandantorylogic = (?) , Defaultvalue = (?) , Issecondheader = (?) , Onchangeevent = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? " +
      "                 AND ad_ref_gridcolumn.AD_Reference_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colspan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issortable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrowkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rowkeysuffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issplitgroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issecondheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onchangeevent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
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
      "        INSERT INTO ad_ref_gridcolumn " +
      "        (AD_Ref_Gridcolumn_ID, Isactive, Line, AD_Ref_Group_ID, Name, AD_Client_ID, AD_Element_ID, AD_Org_ID, Colspan, Isdisplayed, Headertext, Template, Issortable, Isrowkey, AD_Reference_ID, Rowkeysuffix, Referenceurl, AD_Table_ID, MaxLength, Required, ReadOnly, Isinheader, Issplitgroup, colreference, AD_Val_Rule_ID, Includesemptyitem, Readonlylogic, Mandantorylogic, Defaultvalue, Issecondheader, Onchangeevent, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGridcolumnId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adElementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colspan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdisplayed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, template);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issortable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrowkey);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adReferenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rowkeysuffix);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceurl);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maxlength);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, required);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonly);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issplitgroup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, colreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adValRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, includesemptyitem);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, readonlylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mandantorylogic);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, defaultvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issecondheader);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adReferenceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_gridcolumn" +
      "        WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? " +
      "                 AND ad_ref_gridcolumn.AD_Reference_ID = ? " +
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
      "        DELETE FROM ad_ref_gridcolumn" +
      "        WHERE ad_ref_gridcolumn.AD_Ref_Gridcolumn_ID = ? " +
      "                 AND ad_ref_gridcolumn.AD_Reference_ID = ? ";

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

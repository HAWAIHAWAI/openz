//Sqlc generated V1.O00-1
package org.openz.view;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class FormhelperData implements FieldProvider {
static Logger log4j = Logger.getLogger(FormhelperData.class);
  private String InitRecordNumber="0";
  public String fieldgroupid;
  public String adElementId;
  public String adRefRadiogroupId;
  public String adClientId;
  public String adOrgId;
  public String createdby;
  public String updatedby;
  public String value;
  public String selectorcolumnsuffix;
  public String selectorcolumnname;
  public String translation;
  public String fieldreference;
  public String islinebreak;
  public String adRefFieldcolumnId;
  public String name;
  public String name2;
  public String template;
  public String referenceurl;
  public String onchangeevent;
  public String adTableId;
  public String colstotal;
  public String maxlength;
  public String leadingemptycols;
  public String buttonclass;
  public String includesemptyitem;
  public String adValRuleId;
  public String style;
  public String line;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fieldgroupid"))
      return fieldgroupid;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("ad_ref_radiogroup_id") || fieldName.equals("adRefRadiogroupId"))
      return adRefRadiogroupId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("selectorcolumnsuffix"))
      return selectorcolumnsuffix;
    else if (fieldName.equalsIgnoreCase("selectorcolumnname"))
      return selectorcolumnname;
    else if (fieldName.equalsIgnoreCase("translation"))
      return translation;
    else if (fieldName.equalsIgnoreCase("fieldreference"))
      return fieldreference;
    else if (fieldName.equalsIgnoreCase("islinebreak"))
      return islinebreak;
    else if (fieldName.equalsIgnoreCase("ad_ref_fieldcolumn_id") || fieldName.equals("adRefFieldcolumnId"))
      return adRefFieldcolumnId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("name2"))
      return name2;
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("referenceurl"))
      return referenceurl;
    else if (fieldName.equalsIgnoreCase("onchangeevent"))
      return onchangeevent;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("colstotal"))
      return colstotal;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("leadingemptycols"))
      return leadingemptycols;
    else if (fieldName.equalsIgnoreCase("buttonclass"))
      return buttonclass;
    else if (fieldName.equalsIgnoreCase("includesemptyitem"))
      return includesemptyitem;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("style"))
      return style;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static FormhelperData[] select(ConnectionProvider connectionProvider, String referenceid)    throws ServletException {
    return select(connectionProvider, referenceid, 0, 0);
  }

  public static FormhelperData[] select(ConnectionProvider connectionProvider, String referenceid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select '' as fieldgroupid, pad_element_id as ad_element_id,'' as AD_REF_RADIOGROUP_ID, " +
      "                '' as AD_CLIENT_ID,'' as  AD_ORG_ID, '' as CREATEDBY, '' as UPDATEDBY,'' as value,'' as selectorcolumnsuffix,'' as selectorcolumnname," +
      "                '' as  translation,pfieldreference as fieldreference,pislinebreak as islinebreak,pAD_REF_FIELDCOLUMN_ID as AD_REF_FIELDCOLUMN_ID," +
      "                pname as name,pname2 as name2,pTEMPLATE as TEMPLATE,pREFERENCEURL as REFERENCEURL,ponchangeevent as onchangeevent,pAD_TABLE_ID as AD_TABLE_ID," +
      "                pCOLSTOTAL as COLSTOTAL, pMAXLENGTH as MAXLENGTH, pleadingemptycols as leadingemptycols, pBUTTONCLASS as BUTTONCLASS," +
      "                pincludesemptyitem as includesemptyitem,pAD_ValRule_ID as AD_Val_Rule_ID, pstyle as style,pline as line" +
      "            from ad_selectfieldgroupfields(?)" +
      "            order by line ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceid);

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
        FormhelperData objectFormhelperData = new FormhelperData();
        objectFormhelperData.fieldgroupid = UtilSql.getValue(result, "fieldgroupid");
        objectFormhelperData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectFormhelperData.adRefRadiogroupId = UtilSql.getValue(result, "ad_ref_radiogroup_id");
        objectFormhelperData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFormhelperData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFormhelperData.createdby = UtilSql.getValue(result, "createdby");
        objectFormhelperData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFormhelperData.value = UtilSql.getValue(result, "value");
        objectFormhelperData.selectorcolumnsuffix = UtilSql.getValue(result, "selectorcolumnsuffix");
        objectFormhelperData.selectorcolumnname = UtilSql.getValue(result, "selectorcolumnname");
        objectFormhelperData.translation = UtilSql.getValue(result, "translation");
        objectFormhelperData.fieldreference = UtilSql.getValue(result, "fieldreference");
        objectFormhelperData.islinebreak = UtilSql.getValue(result, "islinebreak");
        objectFormhelperData.adRefFieldcolumnId = UtilSql.getValue(result, "ad_ref_fieldcolumn_id");
        objectFormhelperData.name = UtilSql.getValue(result, "name");
        objectFormhelperData.name2 = UtilSql.getValue(result, "name2");
        objectFormhelperData.template = UtilSql.getValue(result, "template");
        objectFormhelperData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectFormhelperData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectFormhelperData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectFormhelperData.colstotal = UtilSql.getValue(result, "colstotal");
        objectFormhelperData.maxlength = UtilSql.getValue(result, "maxlength");
        objectFormhelperData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectFormhelperData.buttonclass = UtilSql.getValue(result, "buttonclass");
        objectFormhelperData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectFormhelperData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectFormhelperData.style = UtilSql.getValue(result, "style");
        objectFormhelperData.line = UtilSql.getValue(result, "line");
        objectFormhelperData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFormhelperData);
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
    FormhelperData objectFormhelperData[] = new FormhelperData[vector.size()];
    vector.copyInto(objectFormhelperData);
    return(objectFormhelperData);
  }

  public static FormhelperData[] selectProcessParameter(ConnectionProvider connectionProvider, String language, String processId)    throws ServletException {
    return selectProcessParameter(connectionProvider, language, processId, 0, 0);
  }

  public static FormhelperData[] selectProcessParameter(ConnectionProvider connectionProvider, String language, String processId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select  '' as fieldgroupid,'' as ad_element_id,ptranslation as  translation,pfieldreference as fieldreference,pislinebreak as islinebreak,pAD_REF_FIELDCOLUMN_ID as AD_REF_FIELDCOLUMN_ID," +
      "                pname as name,pname2 as name2,pTEMPLATE as TEMPLATE,pREFERENCEURL as REFERENCEURL,ponchangeevent as onchangeevent,pAD_TABLE_ID as AD_TABLE_ID," +
      "                pCOLSTOTAL as COLSTOTAL, pMAXLENGTH as MAXLENGTH, pleadingemptycols as leadingemptycols, pBUTTONCLASS as BUTTONCLASS," +
      "                pincludesemptyitem as includesemptyitem,pAD_ValRule_ID as AD_Val_Rule_ID, pstyle as style,pline as line" +
      "            from ad_selectprocessfields(?,?)" +
      "            order by line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processId);

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
        FormhelperData objectFormhelperData = new FormhelperData();
        objectFormhelperData.fieldgroupid = UtilSql.getValue(result, "fieldgroupid");
        objectFormhelperData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectFormhelperData.translation = UtilSql.getValue(result, "translation");
        objectFormhelperData.fieldreference = UtilSql.getValue(result, "fieldreference");
        objectFormhelperData.islinebreak = UtilSql.getValue(result, "islinebreak");
        objectFormhelperData.adRefFieldcolumnId = UtilSql.getValue(result, "ad_ref_fieldcolumn_id");
        objectFormhelperData.name = UtilSql.getValue(result, "name");
        objectFormhelperData.name2 = UtilSql.getValue(result, "name2");
        objectFormhelperData.template = UtilSql.getValue(result, "template");
        objectFormhelperData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectFormhelperData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectFormhelperData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectFormhelperData.colstotal = UtilSql.getValue(result, "colstotal");
        objectFormhelperData.maxlength = UtilSql.getValue(result, "maxlength");
        objectFormhelperData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectFormhelperData.buttonclass = UtilSql.getValue(result, "buttonclass");
        objectFormhelperData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectFormhelperData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectFormhelperData.style = UtilSql.getValue(result, "style");
        objectFormhelperData.line = UtilSql.getValue(result, "line");
        objectFormhelperData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFormhelperData);
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
    FormhelperData objectFormhelperData[] = new FormhelperData[vector.size()];
    vector.copyInto(objectFormhelperData);
    return(objectFormhelperData);
  }

  public static FormhelperData[] selectTabFields(ConnectionProvider connectionProvider, String language, String tabid)    throws ServletException {
    return selectTabFields(connectionProvider, language, tabid, 0, 0);
  }

  public static FormhelperData[] selectTabFields(ConnectionProvider connectionProvider, String language, String tabid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "               select pfieldgroupid as fieldgroupid,'' as ad_element_id,ptranslation as  translation,pfieldreference as fieldreference,pislinebreak as islinebreak,pAD_REF_FIELDCOLUMN_ID as AD_REF_FIELDCOLUMN_ID," +
      "                pname as name,pname2 as name2,pTEMPLATE as TEMPLATE,pREFERENCEURL as REFERENCEURL,ponchangeevent as onchangeevent,pAD_TABLE_ID as AD_TABLE_ID," +
      "                pCOLSTOTAL as COLSTOTAL, pMAXLENGTH as MAXLENGTH, pleadingemptycols as leadingemptycols, pBUTTONCLASS as BUTTONCLASS," +
      "                pincludesemptyitem as includesemptyitem,pAD_ValRule_ID as AD_Val_Rule_ID, pstyle as style,pline as line" +
      "            from ad_selecttabfields(?,?)" +
      "            order by line ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabid);

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
        FormhelperData objectFormhelperData = new FormhelperData();
        objectFormhelperData.fieldgroupid = UtilSql.getValue(result, "fieldgroupid");
        objectFormhelperData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectFormhelperData.translation = UtilSql.getValue(result, "translation");
        objectFormhelperData.fieldreference = UtilSql.getValue(result, "fieldreference");
        objectFormhelperData.islinebreak = UtilSql.getValue(result, "islinebreak");
        objectFormhelperData.adRefFieldcolumnId = UtilSql.getValue(result, "ad_ref_fieldcolumn_id");
        objectFormhelperData.name = UtilSql.getValue(result, "name");
        objectFormhelperData.name2 = UtilSql.getValue(result, "name2");
        objectFormhelperData.template = UtilSql.getValue(result, "template");
        objectFormhelperData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectFormhelperData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectFormhelperData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectFormhelperData.colstotal = UtilSql.getValue(result, "colstotal");
        objectFormhelperData.maxlength = UtilSql.getValue(result, "maxlength");
        objectFormhelperData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectFormhelperData.buttonclass = UtilSql.getValue(result, "buttonclass");
        objectFormhelperData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectFormhelperData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectFormhelperData.style = UtilSql.getValue(result, "style");
        objectFormhelperData.line = UtilSql.getValue(result, "line");
        objectFormhelperData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFormhelperData);
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
    FormhelperData objectFormhelperData[] = new FormhelperData[vector.size()];
    vector.copyInto(objectFormhelperData);
    return(objectFormhelperData);
  }

  public static FormhelperData[] ad_selecttabBuscadorFields(ConnectionProvider connectionProvider, String language, String tabid, String isAudit)    throws ServletException {
    return ad_selecttabBuscadorFields(connectionProvider, language, tabid, isAudit, 0, 0);
  }

  public static FormhelperData[] ad_selecttabBuscadorFields(ConnectionProvider connectionProvider, String language, String tabid, String isAudit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "               select '' as fieldgroupid,'' as ad_element_id,ptranslation as  translation,pfieldreference as fieldreference,pislinebreak as islinebreak,pAD_REF_FIELDCOLUMN_ID as AD_REF_FIELDCOLUMN_ID," +
      "                pname as name,pname2 as name2,pTEMPLATE as TEMPLATE,'' as REFERENCEURL,'' as onchangeevent,pAD_TABLE_ID as AD_TABLE_ID," +
      "                pCOLSTOTAL as COLSTOTAL, pMAXLENGTH as MAXLENGTH, '0' as leadingemptycols, '' as BUTTONCLASS," +
      "                'Y' as includesemptyitem,pAD_ValRule_ID as AD_Val_Rule_ID, pstyle as style,pline as line" +
      "            from ad_selecttabBuscadorFields(?,?,?)" +
      "            order by line ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isAudit);

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
        FormhelperData objectFormhelperData = new FormhelperData();
        objectFormhelperData.fieldgroupid = UtilSql.getValue(result, "fieldgroupid");
        objectFormhelperData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectFormhelperData.translation = UtilSql.getValue(result, "translation");
        objectFormhelperData.fieldreference = UtilSql.getValue(result, "fieldreference");
        objectFormhelperData.islinebreak = UtilSql.getValue(result, "islinebreak");
        objectFormhelperData.adRefFieldcolumnId = UtilSql.getValue(result, "ad_ref_fieldcolumn_id");
        objectFormhelperData.name = UtilSql.getValue(result, "name");
        objectFormhelperData.name2 = UtilSql.getValue(result, "name2");
        objectFormhelperData.template = UtilSql.getValue(result, "template");
        objectFormhelperData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectFormhelperData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectFormhelperData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectFormhelperData.colstotal = UtilSql.getValue(result, "colstotal");
        objectFormhelperData.maxlength = UtilSql.getValue(result, "maxlength");
        objectFormhelperData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectFormhelperData.buttonclass = UtilSql.getValue(result, "buttonclass");
        objectFormhelperData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectFormhelperData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectFormhelperData.style = UtilSql.getValue(result, "style");
        objectFormhelperData.line = UtilSql.getValue(result, "line");
        objectFormhelperData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFormhelperData);
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
    FormhelperData objectFormhelperData[] = new FormhelperData[vector.size()];
    vector.copyInto(objectFormhelperData);
    return(objectFormhelperData);
  }

  public static FormhelperData[] selectRadiogroup(ConnectionProvider connectionProvider, String reffieldid)    throws ServletException {
    return selectRadiogroup(connectionProvider, reffieldid, 0, 0);
  }

  public static FormhelperData[] selectRadiogroup(ConnectionProvider connectionProvider, String reffieldid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select a.AD_REF_RADIOGROUP_ID, a.AD_CLIENT_ID, a.AD_ORG_ID, a.CREATEDBY, a.UPDATEDBY, " +
      "        coalesce(i.NAME,a.name) as name, coalesce(i.LINE,a.line) as line,coalesce(i.value,a.value) as value" +
      "        from ad_ref_radiogroup a" +
      "        left join ad_ref_radiogroup_instance i on i.AD_REF_RADIOGROUP_ID=a.AD_REF_RADIOGROUP_ID and i.isactive='Y'" +
      "        where a.AD_REF_FIELDCOLUMN_ID = ? and a.isactive='Y'" +
      "        order by line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reffieldid);

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
        FormhelperData objectFormhelperData = new FormhelperData();
        objectFormhelperData.adRefRadiogroupId = UtilSql.getValue(result, "ad_ref_radiogroup_id");
        objectFormhelperData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectFormhelperData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectFormhelperData.createdby = UtilSql.getValue(result, "createdby");
        objectFormhelperData.updatedby = UtilSql.getValue(result, "updatedby");
        objectFormhelperData.name = UtilSql.getValue(result, "name");
        objectFormhelperData.line = UtilSql.getValue(result, "line");
        objectFormhelperData.value = UtilSql.getValue(result, "value");
        objectFormhelperData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFormhelperData);
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
    FormhelperData objectFormhelperData[] = new FormhelperData[vector.size()];
    vector.copyInto(objectFormhelperData);
    return(objectFormhelperData);
  }

  public static String getReferenceColumns(ConnectionProvider connectionProvider, String referenceid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  coalesce(r.columns,i.columns) as columns  " +
      "        from ad_reference r left join ad_referenceinstance i on i.ad_reference_id=r.ad_reference_id AND i.isactive='Y'" +
      "        where r.ad_reference_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "columns");
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

  public static String getStdEditionToolbar(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ad_toolbar_id  from ad_toolbar where value='STDEDITION'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_toolbar_id");
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

  public static String getStdRelationToolbar(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ad_toolbar_id  from ad_toolbar where value='STDRELATION'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_toolbar_id");
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

  public static String getFormToolbar(ConnectionProvider connectionProvider, String formClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ad_toolbar_id  from ad_form,ad_model_object where ad_model_object.ad_form_id=ad_form.ad_form_id and ad_model_object.classname= ? and ad_form.isactive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, formClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_toolbar_id");
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

  public static String getTabEditionToolbar(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ad_editiontoolbar  from ad_tab,ad_model_object where ad_model_object.ad_tab_id=ad_tab.ad_tab_id and ad_model_object.classname= ? and ad_tab.isactive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_editiontoolbar");
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

  public static String getTabRelationToolbar(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ad_relationtoolbar  from ad_tab,ad_model_object where ad_model_object.ad_tab_id=ad_tab.ad_tab_id and ad_model_object.classname= ? and ad_tab.isactive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_relationtoolbar");
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

  public static String getLeftTabsMode4Tab(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  lefttabsmode  from ad_tab,ad_model_object where ad_model_object.ad_tab_id=ad_tab.ad_tab_id and ad_model_object.classname= ? and ad_tab.isactive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "lefttabsmode");
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

  public static String getWindowId(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_tab.ad_window_id  from ad_window,ad_tab,ad_model_object where ad_model_object.ad_tab_id=ad_tab.ad_tab_id and ad_tab.ad_window_id=ad_window.ad_window_id and ad_model_object.classname= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_window_id");
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

  public static String getTabId(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_tab_id  from ad_model_object where  ad_model_object.classname= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tab_id");
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

  public static String getFieldgroupname(ConnectionProvider connectionProvider, String fieldgroupid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT name  from ad_fieldgroup where  ad_fieldgroup_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldgroupid);

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

  public static String isFieldgrouphidden(ConnectionProvider connectionProvider, String fieldgroupid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT onloadhidden from ad_fieldgroup where  ad_fieldgroup_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fieldgroupid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "onloadhidden");
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

  public static String getKeyColumnName(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_column.columnname  from ad_column,ad_tab,ad_model_object " +
      "        where ad_model_object.ad_tab_id=ad_tab.ad_tab_id" +
      "        and ad_tab.ad_table_id=ad_column.ad_table_id " +
      "        and iskey='Y' and ad_model_object.classname= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "columnname");
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

  public static String getFocusField(ConnectionProvider connectionProvider, String adTabId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_TabGetFirstFocusField(?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTabId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tabgetfirstfocusfield");
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

  public static String getTableId(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ad_table_id  from ad_tab,ad_model_object " +
      "        where ad_model_object.ad_tab_id=ad_tab.ad_tab_id" +
      "        and ad_model_object.classname= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_table_id");
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

  public static String getMappingRelation(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT mappingname  from ad_model_object_mapping ,ad_model_object " +
      "        where ad_model_object.ad_model_object_id=ad_model_object_mapping.ad_model_object_id" +
      "        and ad_model_object.classname= ?" +
      "        and ad_model_object_mapping.mappingname like '%Relation.html'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "mappingname");
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

  public static String getMapping(ConnectionProvider connectionProvider, String tabClassname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT mappingname  from ad_model_object_mapping ,ad_model_object " +
      "        where ad_model_object.ad_model_object_id=ad_model_object_mapping.ad_model_object_id" +
      "        and ad_model_object.classname= ?" +
      "        LIMIT 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabClassname);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "mappingname");
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

  public static FormhelperData[] getHiddenSelectorColumns(ConnectionProvider connectionProvider, String selectorRefId)    throws ServletException {
    return getHiddenSelectorColumns(connectionProvider, selectorRefId, 0, 0);
  }

  public static FormhelperData[] getHiddenSelectorColumns(ConnectionProvider connectionProvider, String selectorRefId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c.columnname as selectorcolumnname ,sc.column_suffix as  selectorcolumnsuffix " +
      "        from  ad_column c,ad_ref_search_column sc,ad_ref_search rs,ad_reference r" +
      "        where r.ad_reference_id=rs.ad_reference_id and rs.ad_ref_search_id=sc.ad_ref_search_id" +
      "        and c.ad_column_id=rs.ad_column_id and sc.columntype='O' and sc.column_suffix is not null" +
      "        and r.ad_reference_id= ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, selectorRefId);

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
        FormhelperData objectFormhelperData = new FormhelperData();
        objectFormhelperData.selectorcolumnname = UtilSql.getValue(result, "selectorcolumnname");
        objectFormhelperData.selectorcolumnsuffix = UtilSql.getValue(result, "selectorcolumnsuffix");
        objectFormhelperData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFormhelperData);
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
    FormhelperData objectFormhelperData[] = new FormhelperData[vector.size()];
    vector.copyInto(objectFormhelperData);
    return(objectFormhelperData);
  }
}

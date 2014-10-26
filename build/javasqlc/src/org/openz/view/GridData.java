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

public class GridData implements FieldProvider {
static Logger log4j = Logger.getLogger(GridData.class);
  private String InitRecordNumber="0";
  public String adRefGroupId;
  public String adClientId;
  public String adOrgId;
  public String colsvisibleoninit;
  public String createdby;
  public String updatedby;
  public String adReferenceId;
  public String idcolumn;
  public String level;
  public String leadingemptycols;
  public String headerformatbold;
  public String hasselectallbelow;
  public String hasevenodd;
  public String hasexpander;
  public String hasselectline;
  public String adRefGridcolumnId;
  public String name;
  public String headertext;
  public String template;
  public String referenceurl;
  public String colreference;
  public String adTableId;
  public String onchangeevent;
  public String colspan;
  public String maxlength;
  public String required;
  public String readonly;
  public String isinheader;
  public String issecondheader;
  public String issplitgroup;
  public String adValRuleId;
  public String includesemptyitem;
  public String isrowkey;
  public String issortable;
  public String rowkeysuffix;
  public String isdisplayed;
  public String adElementId;
  public String line;
  public String isautoheader;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_ref_group_id") || fieldName.equals("adRefGroupId"))
      return adRefGroupId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("colsvisibleoninit"))
      return colsvisibleoninit;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("ad_reference_id") || fieldName.equals("adReferenceId"))
      return adReferenceId;
    else if (fieldName.equalsIgnoreCase("idcolumn"))
      return idcolumn;
    else if (fieldName.equalsIgnoreCase("level"))
      return level;
    else if (fieldName.equalsIgnoreCase("leadingemptycols"))
      return leadingemptycols;
    else if (fieldName.equalsIgnoreCase("headerformatbold"))
      return headerformatbold;
    else if (fieldName.equalsIgnoreCase("hasselectallbelow"))
      return hasselectallbelow;
    else if (fieldName.equalsIgnoreCase("hasevenodd"))
      return hasevenodd;
    else if (fieldName.equalsIgnoreCase("hasexpander"))
      return hasexpander;
    else if (fieldName.equalsIgnoreCase("hasselectline"))
      return hasselectline;
    else if (fieldName.equalsIgnoreCase("ad_ref_gridcolumn_id") || fieldName.equals("adRefGridcolumnId"))
      return adRefGridcolumnId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("headertext"))
      return headertext;
    else if (fieldName.equalsIgnoreCase("template"))
      return template;
    else if (fieldName.equalsIgnoreCase("referenceurl"))
      return referenceurl;
    else if (fieldName.equalsIgnoreCase("colreference"))
      return colreference;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("onchangeevent"))
      return onchangeevent;
    else if (fieldName.equalsIgnoreCase("colspan"))
      return colspan;
    else if (fieldName.equalsIgnoreCase("maxlength"))
      return maxlength;
    else if (fieldName.equalsIgnoreCase("required"))
      return required;
    else if (fieldName.equalsIgnoreCase("readonly"))
      return readonly;
    else if (fieldName.equalsIgnoreCase("isinheader"))
      return isinheader;
    else if (fieldName.equalsIgnoreCase("issecondheader"))
      return issecondheader;
    else if (fieldName.equalsIgnoreCase("issplitgroup"))
      return issplitgroup;
    else if (fieldName.equalsIgnoreCase("ad_val_rule_id") || fieldName.equals("adValRuleId"))
      return adValRuleId;
    else if (fieldName.equalsIgnoreCase("includesemptyitem"))
      return includesemptyitem;
    else if (fieldName.equalsIgnoreCase("isrowkey"))
      return isrowkey;
    else if (fieldName.equalsIgnoreCase("issortable"))
      return issortable;
    else if (fieldName.equalsIgnoreCase("rowkeysuffix"))
      return rowkeysuffix;
    else if (fieldName.equalsIgnoreCase("isdisplayed"))
      return isdisplayed;
    else if (fieldName.equalsIgnoreCase("ad_element_id") || fieldName.equals("adElementId"))
      return adElementId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("isautoheader"))
      return isautoheader;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GridData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static GridData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT a.AD_REF_GROUP_ID, a.AD_CLIENT_ID, a.AD_ORG_ID, a.colsvisibleoninit, a.CREATEDBY, a.UPDATEDBY, a.AD_REFERENCE_ID, a.IDCOLUMN, a.LEVEL, a.LEADINGEMPTYCOLS, a.HEADERFORMATBOLD, a.HASSELECTALLBELOW, a.HASEVENODD, a.HASEXPANDER, a.HASSELECTLINE," +
      "        b.AD_REF_GRIDCOLUMN_ID,b.NAME,b.HEADERTEXT,b.TEMPLATE,b.REFERENCEURL,b.colreference,b.AD_TABLE_ID,b.onchangeevent, b.COLSPAN,b.MAXLENGTH,b.REQUIRED,b.READONLY,b.ISINHEADER,b.ISSECONDHEADER,b.ISSPLITGROUP,b.ad_val_rule_id,b.includesemptyitem," +
      "        '' as isrowkey,'' as issortable,'' as rowkeysuffix,b.isdisplayed, '' as ad_element_id,'' as line,'' as isautoheader" +
      "        from AD_REF_GROUP a,AD_REF_GRIDCOLUMN b where a.AD_REF_GROUP_ID=b.AD_REF_GROUP_ID;";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

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
        GridData objectGridData = new GridData();
        objectGridData.adRefGroupId = UtilSql.getValue(result, "ad_ref_group_id");
        objectGridData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGridData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGridData.colsvisibleoninit = UtilSql.getValue(result, "colsvisibleoninit");
        objectGridData.createdby = UtilSql.getValue(result, "createdby");
        objectGridData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGridData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectGridData.idcolumn = UtilSql.getValue(result, "idcolumn");
        objectGridData.level = UtilSql.getValue(result, "level");
        objectGridData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectGridData.headerformatbold = UtilSql.getValue(result, "headerformatbold");
        objectGridData.hasselectallbelow = UtilSql.getValue(result, "hasselectallbelow");
        objectGridData.hasevenodd = UtilSql.getValue(result, "hasevenodd");
        objectGridData.hasexpander = UtilSql.getValue(result, "hasexpander");
        objectGridData.hasselectline = UtilSql.getValue(result, "hasselectline");
        objectGridData.adRefGridcolumnId = UtilSql.getValue(result, "ad_ref_gridcolumn_id");
        objectGridData.name = UtilSql.getValue(result, "name");
        objectGridData.headertext = UtilSql.getValue(result, "headertext");
        objectGridData.template = UtilSql.getValue(result, "template");
        objectGridData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectGridData.colreference = UtilSql.getValue(result, "colreference");
        objectGridData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectGridData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectGridData.colspan = UtilSql.getValue(result, "colspan");
        objectGridData.maxlength = UtilSql.getValue(result, "maxlength");
        objectGridData.required = UtilSql.getValue(result, "required");
        objectGridData.readonly = UtilSql.getValue(result, "readonly");
        objectGridData.isinheader = UtilSql.getValue(result, "isinheader");
        objectGridData.issecondheader = UtilSql.getValue(result, "issecondheader");
        objectGridData.issplitgroup = UtilSql.getValue(result, "issplitgroup");
        objectGridData.adValRuleId = UtilSql.getValue(result, "ad_val_rule_id");
        objectGridData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectGridData.isrowkey = UtilSql.getValue(result, "isrowkey");
        objectGridData.issortable = UtilSql.getValue(result, "issortable");
        objectGridData.rowkeysuffix = UtilSql.getValue(result, "rowkeysuffix");
        objectGridData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectGridData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectGridData.line = UtilSql.getValue(result, "line");
        objectGridData.isautoheader = UtilSql.getValue(result, "isautoheader");
        objectGridData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGridData);
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
    GridData objectGridData[] = new GridData[vector.size()];
    vector.copyInto(objectGridData);
    return(objectGridData);
  }

  public static GridData[] selectSimpleGridColumns(ConnectionProvider connectionProvider, String AdReferenceID)    throws ServletException {
    return selectSimpleGridColumns(connectionProvider, AdReferenceID, 0, 0);
  }

  public static GridData[] selectSimpleGridColumns(ConnectionProvider connectionProvider, String AdReferenceID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(i.ad_element_id,b.ad_element_id) as ad_element_id ,b.AD_CLIENT_ID, b.AD_ORG_ID, b.CREATEDBY, b.UPDATEDBY ," +
      "        case when coalesce(i.visiblesetting,'NON')='NON' then b.isdisplayed else " +
      "        case when i.visiblesetting='HIDDEN' then 'N' else 'Y' end end as isdisplayed," +
      "        b.isrowkey as isrowkey,b.name,coalesce(i.issortable,b.issortable) as issortable,b.rowkeysuffix ," +
      "        coalesce(i.template,b.template) as template,coalesce(i.colspan,b.colspan) as colspan" +
      "        from ad_ref_gridcolumn b left join ad_ref_gridcolumninstance i on i.ad_ref_gridcolumn_id=b.ad_ref_gridcolumn_id and i.isactive='Y'" +
      "        where b.ad_reference_id= ? and b.isactive='Y' order by coalesce(i.line,b.line)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AdReferenceID);

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
        GridData objectGridData = new GridData();
        objectGridData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectGridData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGridData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGridData.createdby = UtilSql.getValue(result, "createdby");
        objectGridData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGridData.isdisplayed = UtilSql.getValue(result, "isdisplayed");
        objectGridData.isrowkey = UtilSql.getValue(result, "isrowkey");
        objectGridData.name = UtilSql.getValue(result, "name");
        objectGridData.issortable = UtilSql.getValue(result, "issortable");
        objectGridData.rowkeysuffix = UtilSql.getValue(result, "rowkeysuffix");
        objectGridData.template = UtilSql.getValue(result, "template");
        objectGridData.colspan = UtilSql.getValue(result, "colspan");
        objectGridData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGridData);
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
    GridData objectGridData[] = new GridData[vector.size()];
    vector.copyInto(objectGridData);
    return(objectGridData);
  }

  public static GridData[] selectGroup(ConnectionProvider connectionProvider, String gridrefid)    throws ServletException {
    return selectGroup(connectionProvider, gridrefid, 0, 0);
  }

  public static GridData[] selectGroup(ConnectionProvider connectionProvider, String gridrefid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT a.AD_REF_GROUP_ID, a.AD_CLIENT_ID, a.AD_ORG_ID, a.CREATEDBY, a.UPDATEDBY, a.AD_REFERENCE_ID, a.IDCOLUMN, " +
      "        coalesce(i.level,a.LEVEL) as level, " +
      "        case when  coalesce(i.colsvisibleoninit,a.colsvisibleoninit)='NON' then a.colsvisibleoninit else coalesce(i.colsvisibleoninit,a.colsvisibleoninit) end as colsvisibleoninit," +
      "        coalesce(i.LEADINGEMPTYCOLS,a.LEADINGEMPTYCOLS) as LEADINGEMPTYCOLS, " +
      "        case when coalesce(i.HEADERFORMATBOLD,a.HEADERFORMATBOLD)='NON' then a.HEADERFORMATBOLD else coalesce(i.HEADERFORMATBOLD,a.HEADERFORMATBOLD) end as HEADERFORMATBOLD," +
      "        case when coalesce(i.HASSELECTALLBELOW,a.HASSELECTALLBELOW)='NON' then a.HASSELECTALLBELOW else coalesce(i.HASSELECTALLBELOW,a.HASSELECTALLBELOW) end as HASSELECTALLBELOW, " +
      "        case when coalesce(i.HASEVENODD,a.HASEVENODD)='NON'  then a.HASEVENODD else  coalesce(i.HASEVENODD,a.HASEVENODD) end as HASEVENODD," +
      "        case when coalesce(i.HASEXPANDER,a.HASEXPANDER)='NON' then  a.HASEXPANDER else coalesce(i.HASEXPANDER,a.HASEXPANDER) end as HASEXPANDER, " +
      "        case when coalesce(i.HASSELECTLINE,a.HASSELECTLINE)='NON' then a.HASSELECTLINE else coalesce(i.HASSELECTLINE,a.HASSELECTLINE) end as HASSELECTLINE," +
      "        coalesce(i.isautoheader,a.isautoheader) as isautoheader," +
      "        coalesce(i.line,a.line) as line" +
      "        from AD_REF_GROUP a left join ad_ref_groupinstance i on i.AD_REF_GROUP_ID=a.AD_REF_GROUP_ID and i.isactive='Y'" +
      "        where a.AD_REFerence_id= ? and a.isactive='Y' order by line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gridrefid);

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
        GridData objectGridData = new GridData();
        objectGridData.adRefGroupId = UtilSql.getValue(result, "ad_ref_group_id");
        objectGridData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGridData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGridData.createdby = UtilSql.getValue(result, "createdby");
        objectGridData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGridData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectGridData.idcolumn = UtilSql.getValue(result, "idcolumn");
        objectGridData.level = UtilSql.getValue(result, "level");
        objectGridData.colsvisibleoninit = UtilSql.getValue(result, "colsvisibleoninit");
        objectGridData.leadingemptycols = UtilSql.getValue(result, "leadingemptycols");
        objectGridData.headerformatbold = UtilSql.getValue(result, "headerformatbold");
        objectGridData.hasselectallbelow = UtilSql.getValue(result, "hasselectallbelow");
        objectGridData.hasevenodd = UtilSql.getValue(result, "hasevenodd");
        objectGridData.hasexpander = UtilSql.getValue(result, "hasexpander");
        objectGridData.hasselectline = UtilSql.getValue(result, "hasselectline");
        objectGridData.isautoheader = UtilSql.getValue(result, "isautoheader");
        objectGridData.line = UtilSql.getValue(result, "line");
        objectGridData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGridData);
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
    GridData objectGridData[] = new GridData[vector.size()];
    vector.copyInto(objectGridData);
    return(objectGridData);
  }

  public static GridData[] selectColumnFromGroup(ConnectionProvider connectionProvider, String groupid, String isAutoHeader)    throws ServletException {
    return selectColumnFromGroup(connectionProvider, groupid, isAutoHeader, 0, 0);
  }

  public static GridData[] selectColumnFromGroup(ConnectionProvider connectionProvider, String groupid, String isAutoHeader, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select pad_element_id as ad_element_id,pad_reference_id as ad_reference_id, pAD_REF_GROUP_ID as AD_REF_GROUP_ID, pAD_REF_GRIDCOLUMN_ID as AD_REF_GRIDCOLUMN_ID," +
      "	       pname as name,pTEMPLATE as TEMPLATE,pREFERENCEURL as REFERENCEURL,ponchangeevent as onchangeevent,pcolreference as colreference," +
      "	       pAD_TABLE_ID as AD_TABLE_ID, pCOLSPAN as COLSPAN,pMAXLENGTH as MAXLENGTH,pREQUIRED as REQUIRED, pREADONLY as READONLY,pISSECONDHEADER as ISSECONDHEADER," +
      "	       pISINHEADER as ISINHEADER,pISSPLITGROUP as ISSPLITGROUP, pincludesemptyitem as includesemptyitem, pLine as Line" +
      "        from ad_gridSelectFromGroup(?,?)" +
      "        order by line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isAutoHeader);

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
        GridData objectGridData = new GridData();
        objectGridData.adElementId = UtilSql.getValue(result, "ad_element_id");
        objectGridData.adReferenceId = UtilSql.getValue(result, "ad_reference_id");
        objectGridData.adRefGroupId = UtilSql.getValue(result, "ad_ref_group_id");
        objectGridData.adRefGridcolumnId = UtilSql.getValue(result, "ad_ref_gridcolumn_id");
        objectGridData.name = UtilSql.getValue(result, "name");
        objectGridData.template = UtilSql.getValue(result, "template");
        objectGridData.referenceurl = UtilSql.getValue(result, "referenceurl");
        objectGridData.onchangeevent = UtilSql.getValue(result, "onchangeevent");
        objectGridData.colreference = UtilSql.getValue(result, "colreference");
        objectGridData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectGridData.colspan = UtilSql.getValue(result, "colspan");
        objectGridData.maxlength = UtilSql.getValue(result, "maxlength");
        objectGridData.required = UtilSql.getValue(result, "required");
        objectGridData.readonly = UtilSql.getValue(result, "readonly");
        objectGridData.issecondheader = UtilSql.getValue(result, "issecondheader");
        objectGridData.isinheader = UtilSql.getValue(result, "isinheader");
        objectGridData.issplitgroup = UtilSql.getValue(result, "issplitgroup");
        objectGridData.includesemptyitem = UtilSql.getValue(result, "includesemptyitem");
        objectGridData.line = UtilSql.getValue(result, "line");
        objectGridData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGridData);
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
    GridData objectGridData[] = new GridData[vector.size()];
    vector.copyInto(objectGridData);
    return(objectGridData);
  }

  public static String getReferenceName(ConnectionProvider connectionProvider, String referenceid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  NAME from ad_reference where ad_reference_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceid);

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

  public static String getReferenceID(ConnectionProvider connectionProvider, String referencename)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ad_reference_id from ad_reference where name= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referencename);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_reference_id");
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

  public static String getKeyColumnbyTable(ConnectionProvider connectionProvider, String tableid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  columnname from ad_column where ad_table_id= ? and iskey = 'Y' limit 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tableid);

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

  public static String getDetailsIDField(ConnectionProvider connectionProvider, String referenceid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  detailsidfield  from ad_reference where ad_reference_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "detailsidfield");
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

  public static String getGroupCount(ConnectionProvider connectionProvider, String referenceid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  max(coalesce(i.level,g.level)) from ad_ref_group g " +
      "        left join ad_ref_groupinstance i on i.ad_ref_group_id=g.ad_ref_group_id and i.isactive='Y'" +
      "        where g.ad_reference_id= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String getRowKeyCount(ConnectionProvider connectionProvider, String referenceid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  count(*) from ad_ref_gridcolumn  where ad_reference_id= ? and isactive='Y' and isrowkey='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String getVisibleCount(ConnectionProvider connectionProvider, String referenceid)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  count(*) from ad_ref_gridcolumn c" +
      "              left join ad_ref_gridcolumninstance i on i.ad_ref_gridcolumn_id=c.ad_ref_gridcolumn_id  and i.isactive='Y'" +
      "         where c.ad_reference_id= ? and c.isactive='Y' and (coalesce(i.visiblesetting,'NON')='VISIBLE' or (coalesce(i.visiblesetting,'NON')!='HIDDEN' and c.isdisplayed='Y'));";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceid);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String getTableIDFromKeyColumnName(ConnectionProvider connectionProvider, String keycolumname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ad_table_id from ad_table  where upper(tablename) = upper(substr(?,1,length(?)-3))";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, keycolumname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, keycolumname);

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
}

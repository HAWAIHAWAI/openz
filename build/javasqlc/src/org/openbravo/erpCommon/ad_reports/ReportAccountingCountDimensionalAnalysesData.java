//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ReportAccountingCountDimensionalAnalysesData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportAccountingCountDimensionalAnalysesData.class);
  private String InitRecordNumber="0";
  public String id;
  public String levelId;
  public String nivel;
  public String totalamt;
  public String columnLevel;
  public String levelReport;
  public String widthMargin;
  public String widthText;
  public String name;
  public String level1;
  public String level2;
  public String level3;
  public String level4;
  public String classLevel;
  public String orden;
  public String totalamtRef;
  public String columnname;
  public String line;
  public String description;
  public String joinGroup1;
  public String tablename;
  public String joinGroup2;
  public String classLevelRef;
  public String classImage;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("level_id") || fieldName.equals("levelId"))
      return levelId;
    else if (fieldName.equalsIgnoreCase("nivel"))
      return nivel;
    else if (fieldName.equalsIgnoreCase("totalamt"))
      return totalamt;
    else if (fieldName.equalsIgnoreCase("column_level") || fieldName.equals("columnLevel"))
      return columnLevel;
    else if (fieldName.equalsIgnoreCase("level_report") || fieldName.equals("levelReport"))
      return levelReport;
    else if (fieldName.equalsIgnoreCase("width_margin") || fieldName.equals("widthMargin"))
      return widthMargin;
    else if (fieldName.equalsIgnoreCase("width_text") || fieldName.equals("widthText"))
      return widthText;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("level1"))
      return level1;
    else if (fieldName.equalsIgnoreCase("level2"))
      return level2;
    else if (fieldName.equalsIgnoreCase("level3"))
      return level3;
    else if (fieldName.equalsIgnoreCase("level4"))
      return level4;
    else if (fieldName.equalsIgnoreCase("class_level") || fieldName.equals("classLevel"))
      return classLevel;
    else if (fieldName.equalsIgnoreCase("orden"))
      return orden;
    else if (fieldName.equalsIgnoreCase("totalamt_ref") || fieldName.equals("totalamtRef"))
      return totalamtRef;
    else if (fieldName.equalsIgnoreCase("columnname"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("join_group1") || fieldName.equals("joinGroup1"))
      return joinGroup1;
    else if (fieldName.equalsIgnoreCase("tablename"))
      return tablename;
    else if (fieldName.equalsIgnoreCase("join_group2") || fieldName.equals("joinGroup2"))
      return joinGroup2;
    else if (fieldName.equalsIgnoreCase("class_level_ref") || fieldName.equals("classLevelRef"))
      return classLevelRef;
    else if (fieldName.equalsIgnoreCase("class_image") || fieldName.equals("classImage"))
      return classImage;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportAccountingCountDimensionalAnalysesData[] select(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String tableDimension, String idtableDimension)    throws ServletException {
    return select(connectionProvider, levelId, parentLevel, nivel, level, level1, level2, level3, level4, idDimension, adUserClient, accountId, dateFrom, dateTo, adOrgId, cBpartnerId, mProductId, cProjectId, filter, groupBy, tableDimension, idtableDimension, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] select(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String tableDimension, String idtableDimension, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, LEVEL_ID, NIVEL,totalAmt, COLUMN_LEVEL, LEVEL_REPORT,to_number(LEVEL_REPORT)*2 AS WIDTH_MARGIN, 76-to_number(LEVEL_REPORT)*2 AS WIDTH_TEXT, NAME, (CASE LEVEL_REPORT WHEN to_char(1) THEN ID ELSE LEVEL1 END) AS LEVEL1,(CASE LEVEL_REPORT WHEN to_char(2) THEN ID ELSE LEVEL2 END) AS LEVEL2,(CASE LEVEL_REPORT WHEN to_char(3) THEN ID ELSE LEVEL3 END) AS LEVEL3,(CASE LEVEL_REPORT WHEN to_char(4) THEN ID ELSE LEVEL4 END) AS LEVEL4,(CASE LEVEL_REPORT WHEN to_char(1) THEN 'TableHeaderLevel1' WHEN to_char(2) THEN 'TableHeaderLevel2' WHEN to_char(3) THEN 'TableHeaderLevel3' ELSE 'TableHeaderLevel4' END) AS CLASS_LEVEL, '' AS ORDEN, '' AS TOTALAMT_REF, '' AS COLUMNNAME, '' AS LINE, '' AS DESCRIPTION, '' AS JOIN_GROUP1, '' AS TABLENAME, '' AS JOIN_GROUP2, '' AS CLASS_LEVEL_REF, '' AS CLASS_IMAGE" +
      "      FROM (" +
      "      SELECT A.ID, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ")||A.ID||to_char(";
    strSql = strSql + ((parentLevel==null || parentLevel.equals(""))?"":parentLevel);
    strSql = strSql + 
      ") AS LEVEL_ID, to_char(";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ") AS NIVEL, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ") AS COLUMN_LEVEL, A.totalAmt, to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, '' AS NAME, to_char(";
    strSql = strSql + ((level1==null || level1.equals(""))?"":level1);
    strSql = strSql + 
      ") AS LEVEL1, to_char(";
    strSql = strSql + ((level2==null || level2.equals(""))?"":level2);
    strSql = strSql + 
      ") AS LEVEL2, to_char(";
    strSql = strSql + ((level3==null || level3.equals(""))?"":level3);
    strSql = strSql + 
      ") AS LEVEL3, to_char(";
    strSql = strSql + ((level4==null || level4.equals(""))?"":level4);
    strSql = strSql + 
      ") AS LEVEL4 FROM" +
      "        (SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, (CASE ev.accountSign WHEN 'D' THEN SUM(amtacctdr - amtacctcr) ELSE SUM(amtacctcr - amtacctdr) END)  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  2=2" +
      "        GROUP BY ev.accountSign";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      ") A, ";
    strSql = strSql + ((tableDimension==null || tableDimension.equals(""))?"":tableDimension);
    strSql = strSql + 
      "      WHERE A.ID = to_char(";
    strSql = strSql + ((idtableDimension==null || idtableDimension.equals(""))?"":idtableDimension);
    strSql = strSql + 
      ")" +
      "      ORDER BY ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ") AA";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (parentLevel != null && !(parentLevel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (level1 != null && !(level1.equals(""))) {
        }
      if (level2 != null && !(level2.equals(""))) {
        }
      if (level3 != null && !(level3.equals(""))) {
        }
      if (level4 != null && !(level4.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (tableDimension != null && !(tableDimension.equals(""))) {
        }
      if (idtableDimension != null && !(idtableDimension.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.levelId = UtilSql.getValue(result, "level_id");
        objectReportAccountingCountDimensionalAnalysesData.nivel = UtilSql.getValue(result, "nivel");
        objectReportAccountingCountDimensionalAnalysesData.totalamt = UtilSql.getValue(result, "totalamt");
        objectReportAccountingCountDimensionalAnalysesData.columnLevel = UtilSql.getValue(result, "column_level");
        objectReportAccountingCountDimensionalAnalysesData.levelReport = UtilSql.getValue(result, "level_report");
        objectReportAccountingCountDimensionalAnalysesData.widthMargin = UtilSql.getValue(result, "width_margin");
        objectReportAccountingCountDimensionalAnalysesData.widthText = UtilSql.getValue(result, "width_text");
        objectReportAccountingCountDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportAccountingCountDimensionalAnalysesData.level1 = UtilSql.getValue(result, "level1");
        objectReportAccountingCountDimensionalAnalysesData.level2 = UtilSql.getValue(result, "level2");
        objectReportAccountingCountDimensionalAnalysesData.level3 = UtilSql.getValue(result, "level3");
        objectReportAccountingCountDimensionalAnalysesData.level4 = UtilSql.getValue(result, "level4");
        objectReportAccountingCountDimensionalAnalysesData.classLevel = UtilSql.getValue(result, "class_level");
        objectReportAccountingCountDimensionalAnalysesData.orden = UtilSql.getValue(result, "orden");
        objectReportAccountingCountDimensionalAnalysesData.totalamtRef = UtilSql.getValue(result, "totalamt_ref");
        objectReportAccountingCountDimensionalAnalysesData.columnname = UtilSql.getValue(result, "columnname");
        objectReportAccountingCountDimensionalAnalysesData.line = UtilSql.getValue(result, "line");
        objectReportAccountingCountDimensionalAnalysesData.description = UtilSql.getValue(result, "description");
        objectReportAccountingCountDimensionalAnalysesData.joinGroup1 = UtilSql.getValue(result, "join_group1");
        objectReportAccountingCountDimensionalAnalysesData.tablename = UtilSql.getValue(result, "tablename");
        objectReportAccountingCountDimensionalAnalysesData.joinGroup2 = UtilSql.getValue(result, "join_group2");
        objectReportAccountingCountDimensionalAnalysesData.classLevelRef = UtilSql.getValue(result, "class_level_ref");
        objectReportAccountingCountDimensionalAnalysesData.classImage = UtilSql.getValue(result, "class_image");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] set()    throws ServletException {
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[1];
    objectReportAccountingCountDimensionalAnalysesData[0] = new ReportAccountingCountDimensionalAnalysesData();
    objectReportAccountingCountDimensionalAnalysesData[0].id = "";
    objectReportAccountingCountDimensionalAnalysesData[0].levelId = "";
    objectReportAccountingCountDimensionalAnalysesData[0].nivel = "";
    objectReportAccountingCountDimensionalAnalysesData[0].totalamt = "";
    objectReportAccountingCountDimensionalAnalysesData[0].columnLevel = "";
    objectReportAccountingCountDimensionalAnalysesData[0].levelReport = "";
    objectReportAccountingCountDimensionalAnalysesData[0].widthMargin = "";
    objectReportAccountingCountDimensionalAnalysesData[0].widthText = "";
    objectReportAccountingCountDimensionalAnalysesData[0].name = "";
    objectReportAccountingCountDimensionalAnalysesData[0].level1 = "";
    objectReportAccountingCountDimensionalAnalysesData[0].level2 = "";
    objectReportAccountingCountDimensionalAnalysesData[0].level3 = "";
    objectReportAccountingCountDimensionalAnalysesData[0].level4 = "";
    objectReportAccountingCountDimensionalAnalysesData[0].classLevel = "";
    objectReportAccountingCountDimensionalAnalysesData[0].orden = "";
    objectReportAccountingCountDimensionalAnalysesData[0].totalamtRef = "";
    objectReportAccountingCountDimensionalAnalysesData[0].columnname = "";
    objectReportAccountingCountDimensionalAnalysesData[0].line = "";
    objectReportAccountingCountDimensionalAnalysesData[0].description = "";
    objectReportAccountingCountDimensionalAnalysesData[0].joinGroup1 = "";
    objectReportAccountingCountDimensionalAnalysesData[0].tablename = "";
    objectReportAccountingCountDimensionalAnalysesData[0].joinGroup2 = "";
    objectReportAccountingCountDimensionalAnalysesData[0].classLevelRef = "";
    objectReportAccountingCountDimensionalAnalysesData[0].classImage = "";
    return objectReportAccountingCountDimensionalAnalysesData;
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectComparative(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateFromRef, String dateToRef, String tableDimension, String idtableDimension)    throws ServletException {
    return selectComparative(connectionProvider, levelId, parentLevel, nivel, level, level1, level2, level3, level4, idDimension, adUserClient, accountId, dateFrom, dateTo, adOrgId, cBpartnerId, mProductId, cProjectId, filter, groupBy, dateFromRef, dateToRef, tableDimension, idtableDimension, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectComparative(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateFromRef, String dateToRef, String tableDimension, String idtableDimension, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, LEVEL_ID, NIVEL,TOTALAMT, TOTALAMT_REF, COLUMN_LEVEL, LEVEL_REPORT,TO_NUMBER(LEVEL_REPORT)*2 AS WIDTH_MARGIN, 76-TO_NUMBER(LEVEL_REPORT)*2 AS WIDTH_TEXT, NAME, (CASE LEVEL_REPORT WHEN to_char(1) THEN ID ELSE LEVEL1 END) AS LEVEL1,(CASE LEVEL_REPORT WHEN to_char(2) THEN ID ELSE LEVEL2 END) AS LEVEL2,(CASE LEVEL_REPORT WHEN to_char(3) THEN ID ELSE LEVEL3 END) AS LEVEL3,(CASE LEVEL_REPORT WHEN to_char(4) THEN ID ELSE LEVEL4 END) AS LEVEL4, (CASE LEVEL_REPORT WHEN to_char(1) THEN 'TableHeaderLevel1' WHEN to_char(2) THEN 'TableHeaderLevel2' WHEN to_char(3) THEN 'TableHeaderLevel3' ELSE 'TableHeaderLevel4' END) AS CLASS_LEVEL" +
      "      FROM (" +
      "      SELECT AM.ID, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ")||AM.ID||to_char(";
    strSql = strSql + ((parentLevel==null || parentLevel.equals(""))?"":parentLevel);
    strSql = strSql + 
      ") AS LEVEL_ID, to_char(";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ") AS NIVEL, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ") AS COLUMN_LEVEL, SUM((CASE AM.ORDEN WHEN 1 THEN AM.totalAmt ELSE 0 END)) AS TOTALAMT, SUM((CASE AM.ORDEN WHEN 2 THEN AM.TOTALAMT ELSE 0 END)) AS TOTALAMT_REF, to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, '' AS NAME, to_char(";
    strSql = strSql + ((level1==null || level1.equals(""))?"":level1);
    strSql = strSql + 
      ") AS LEVEL1, to_char(";
    strSql = strSql + ((level2==null || level2.equals(""))?"":level2);
    strSql = strSql + 
      ") AS LEVEL2, to_char(";
    strSql = strSql + ((level3==null || level3.equals(""))?"":level3);
    strSql = strSql + 
      ") AS LEVEL3, to_char(";
    strSql = strSql + ((level4==null || level4.equals(""))?"":level4);
    strSql = strSql + 
      ") AS LEVEL4" +
      "        FROM " +
      "        (SELECT ID, ORDEN, SUM(TOTALAMT) AS TOTALAMT" +
      "         FROM(SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 1 AS ORDEN, (CASE ev.accountSign WHEN 'D' THEN SUM(amtacctdr - amtacctcr) ELSE SUM(amtacctcr - amtacctdr) END)  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND 0=0 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  2=2" +
      "        GROUP BY ev.accountSign";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      "        UNION SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 2 AS ORDEN, (CASE ev.accountSign WHEN 'D' THEN SUM(amtacctdr - amtacctcr) ELSE SUM(amtacctcr - amtacctdr) END)  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND 5=5 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 3=3";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  4=4" +
      "        GROUP BY  ev.accountSign";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      ") BB" +
      "        GROUP BY ID, ORDEN) AM, ";
    strSql = strSql + ((tableDimension==null || tableDimension.equals(""))?"":tableDimension);
    strSql = strSql + 
      "      WHERE AM.ID = ";
    strSql = strSql + ((idtableDimension==null || idtableDimension.equals(""))?"":idtableDimension);
    strSql = strSql + 
      "      GROUP BY AM.ID, ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      "      ORDER BY ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ") AA";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (parentLevel != null && !(parentLevel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (level1 != null && !(level1.equals(""))) {
        }
      if (level2 != null && !(level2.equals(""))) {
        }
      if (level3 != null && !(level3.equals(""))) {
        }
      if (level4 != null && !(level4.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (tableDimension != null && !(tableDimension.equals(""))) {
        }
      if (idtableDimension != null && !(idtableDimension.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.levelId = UtilSql.getValue(result, "level_id");
        objectReportAccountingCountDimensionalAnalysesData.nivel = UtilSql.getValue(result, "nivel");
        objectReportAccountingCountDimensionalAnalysesData.totalamt = UtilSql.getValue(result, "totalamt");
        objectReportAccountingCountDimensionalAnalysesData.totalamtRef = UtilSql.getValue(result, "totalamt_ref");
        objectReportAccountingCountDimensionalAnalysesData.columnLevel = UtilSql.getValue(result, "column_level");
        objectReportAccountingCountDimensionalAnalysesData.levelReport = UtilSql.getValue(result, "level_report");
        objectReportAccountingCountDimensionalAnalysesData.widthMargin = UtilSql.getValue(result, "width_margin");
        objectReportAccountingCountDimensionalAnalysesData.widthText = UtilSql.getValue(result, "width_text");
        objectReportAccountingCountDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportAccountingCountDimensionalAnalysesData.level1 = UtilSql.getValue(result, "level1");
        objectReportAccountingCountDimensionalAnalysesData.level2 = UtilSql.getValue(result, "level2");
        objectReportAccountingCountDimensionalAnalysesData.level3 = UtilSql.getValue(result, "level3");
        objectReportAccountingCountDimensionalAnalysesData.level4 = UtilSql.getValue(result, "level4");
        objectReportAccountingCountDimensionalAnalysesData.classLevel = UtilSql.getValue(result, "class_level");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectPeriod(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateToAux, String tableDimension, String idtableDimension)    throws ServletException {
    return selectPeriod(connectionProvider, levelId, parentLevel, nivel, level, level1, level2, level3, level4, idDimension, adUserClient, accountId, dateFrom, dateTo, adOrgId, cBpartnerId, mProductId, cProjectId, filter, groupBy, dateToAux, tableDimension, idtableDimension, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectPeriod(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateToAux, String tableDimension, String idtableDimension, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, LEVEL_ID, NIVEL,totalAmt, COLUMN_LEVEL, LEVEL_REPORT,TO_NUMBER(LEVEL_REPORT) AS WIDTH_MARGIN, 22-TO_NUMBER(LEVEL_REPORT) AS WIDTH_TEXT, NAME, (CASE LEVEL_REPORT WHEN to_char(1) THEN ID ELSE LEVEL1 END) AS LEVEL1,(CASE LEVEL_REPORT WHEN to_char(2) THEN ID ELSE LEVEL2 END) AS LEVEL2,CASE LEVEL_REPORT WHEN to_char(3) THEN  ID ELSE  LEVEL3 END AS LEVEL3,CASE LEVEL_REPORT WHEN to_char(4) THEN  ID ELSE  LEVEL4 END AS LEVEL4,CASE LEVEL_REPORT WHEN to_char(1) THEN 'TableHeaderLevel1' WHEN to_char(2) THEN 'TableHeaderLevel2' WHEN to_char(3) THEN 'TableHeaderLevel3' ELSE 'TableHeaderLevel4' END AS CLASS_LEVEL" +
      "      FROM(" +
      "      SELECT A.ID, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ")||A.ID||to_char(";
    strSql = strSql + ((parentLevel==null || parentLevel.equals(""))?"":parentLevel);
    strSql = strSql + 
      ") AS LEVEL_ID, A.PERIOD, to_char(";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ") AS NIVEL, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ") AS COLUMN_LEVEL, SUM(A.totalAmt) AS TOTALAMT, to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, '' AS NAME, to_char(";
    strSql = strSql + ((level1==null || level1.equals(""))?"":level1);
    strSql = strSql + 
      ") AS LEVEL1, to_char(";
    strSql = strSql + ((level2==null || level2.equals(""))?"":level2);
    strSql = strSql + 
      ") AS LEVEL2, to_char(";
    strSql = strSql + ((level3==null || level3.equals(""))?"":level3);
    strSql = strSql + 
      ") AS LEVEL3, to_char(";
    strSql = strSql + ((level4==null || level4.equals(""))?"":level4);
    strSql = strSql + 
      ") AS LEVEL4" +
      "         FROM (SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, TO_NUMBER(TO_CHAR(fa.dateacct,'MM')) AS period, (CASE ev.accountSign WHEN 'D' THEN SUM(amtacctdr - amtacctcr) ELSE SUM(amtacctcr - amtacctdr) END)  AS totalAmt" +
      "            FROM fact_acct fa, c_elementvalue ev" +
      "            WHERE fa.account_id = ev.c_elementValue_id" +
      "            AND fa.ad_client_id IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "            AND fa.account_id = ?" +
      "            AND fa.dateacct >= TO_DATE(?)" +
      "            AND fa.dateacct < TO_DATE(?)" +
      "            AND fa.factaccttype NOT IN ('O','C','R')" +
      "            AND 0=0 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "            AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      "     AND  2=2" +
      "            GROUP BY ev.accountSign, TO_NUMBER(TO_CHAR(fa.dateacct,'MM'))";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      "            UNION SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, D.PERIOD AS period, 0  AS totalAmt" +
      "            FROM fact_acct fa, c_elementvalue ev, (SELECT TO_NUMBER(VALUE) AS PERIOD" +
      "                                                          FROM AD_MONTH" +
      "                                                          WHERE TO_NUMBER(VALUE) >= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))" +
      "                                                          AND TO_NUMBER(VALUE) <= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))) D" +
      "            WHERE fa.account_id = ev.c_elementValue_id" +
      "            AND fa.ad_client_id IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "            AND fa.account_id = ?" +
      "            AND fa.dateacct >= TO_DATE(?)" +
      "            AND fa.dateacct < TO_DATE(?)" +
      "            AND fa.factaccttype NOT IN ('O','C','R')" +
      "            AND 5=5 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "            AND 3=3";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      "     AND  4=4" +
      "            GROUP BY D.PERIOD";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      " ) A, ";
    strSql = strSql + ((tableDimension==null || tableDimension.equals(""))?"":tableDimension);
    strSql = strSql + 
      "            WHERE A.ID = to_char(";
    strSql = strSql + ((idtableDimension==null || idtableDimension.equals(""))?"":idtableDimension);
    strSql = strSql + 
      ")" +
      "            GROUP BY A.ID, A.PERIOD, ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      "            ORDER BY ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ", A.PERIOD) AA";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (parentLevel != null && !(parentLevel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (level1 != null && !(level1.equals(""))) {
        }
      if (level2 != null && !(level2.equals(""))) {
        }
      if (level3 != null && !(level3.equals(""))) {
        }
      if (level4 != null && !(level4.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToAux);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (tableDimension != null && !(tableDimension.equals(""))) {
        }
      if (idtableDimension != null && !(idtableDimension.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.levelId = UtilSql.getValue(result, "level_id");
        objectReportAccountingCountDimensionalAnalysesData.nivel = UtilSql.getValue(result, "nivel");
        objectReportAccountingCountDimensionalAnalysesData.totalamt = UtilSql.getValue(result, "totalamt");
        objectReportAccountingCountDimensionalAnalysesData.columnLevel = UtilSql.getValue(result, "column_level");
        objectReportAccountingCountDimensionalAnalysesData.levelReport = UtilSql.getValue(result, "level_report");
        objectReportAccountingCountDimensionalAnalysesData.widthMargin = UtilSql.getValue(result, "width_margin");
        objectReportAccountingCountDimensionalAnalysesData.widthText = UtilSql.getValue(result, "width_text");
        objectReportAccountingCountDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportAccountingCountDimensionalAnalysesData.level1 = UtilSql.getValue(result, "level1");
        objectReportAccountingCountDimensionalAnalysesData.level2 = UtilSql.getValue(result, "level2");
        objectReportAccountingCountDimensionalAnalysesData.level3 = UtilSql.getValue(result, "level3");
        objectReportAccountingCountDimensionalAnalysesData.level4 = UtilSql.getValue(result, "level4");
        objectReportAccountingCountDimensionalAnalysesData.classLevel = UtilSql.getValue(result, "class_level");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectPeriodQuarter(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateToAux, String tableDimension, String idtableDimension)    throws ServletException {
    return selectPeriodQuarter(connectionProvider, levelId, parentLevel, nivel, level, level1, level2, level3, level4, idDimension, adUserClient, accountId, dateFrom, dateTo, adOrgId, cBpartnerId, mProductId, cProjectId, filter, groupBy, dateToAux, tableDimension, idtableDimension, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectPeriodQuarter(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateToAux, String tableDimension, String idtableDimension, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, LEVEL_ID, NIVEL,totalAmt, COLUMN_LEVEL, LEVEL_REPORT,TO_NUMBER(LEVEL_REPORT) AS WIDTH_MARGIN, 22-TO_NUMBER(LEVEL_REPORT) AS WIDTH_TEXT, NAME, (CASE LEVEL_REPORT WHEN to_char(1) THEN ID ELSE LEVEL1 END) AS LEVEL1,(CASE LEVEL_REPORT WHEN to_char(2) THEN ID ELSE LEVEL2 END) AS LEVEL2,(CASE LEVEL_REPORT WHEN to_char(3) THEN ID ELSE LEVEL3 END) AS LEVEL3,(CASE LEVEL_REPORT WHEN to_char(4) THEN ID ELSE LEVEL4 END) AS LEVEL4,(CASE LEVEL_REPORT WHEN to_char(1) THEN 'TableHeaderLevel1' WHEN to_char(2) THEN 'TableHeaderLevel2' WHEN to_char(3) THEN 'TableHeaderLevel3' ELSE 'TableHeaderLevel4' END) AS CLASS_LEVEL" +
      "      FROM(" +
      "      SELECT A.ID, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ")||A.ID||to_char(";
    strSql = strSql + ((parentLevel==null || parentLevel.equals(""))?"":parentLevel);
    strSql = strSql + 
      ") AS LEVEL_ID, A.PERIOD, to_char(";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ") AS NIVEL, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ") AS COLUMN_LEVEL, SUM(A.totalAmt) AS TOTALAMT, to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, '' AS NAME, to_char(";
    strSql = strSql + ((level1==null || level1.equals(""))?"":level1);
    strSql = strSql + 
      ") AS LEVEL1, to_char(";
    strSql = strSql + ((level2==null || level2.equals(""))?"":level2);
    strSql = strSql + 
      ") AS LEVEL2, to_char(";
    strSql = strSql + ((level3==null || level3.equals(""))?"":level3);
    strSql = strSql + 
      ") AS LEVEL3, to_char(";
    strSql = strSql + ((level4==null || level4.equals(""))?"":level4);
    strSql = strSql + 
      ") AS LEVEL4" +
      "         FROM (SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, TO_NUMBER(AD_MONTH.QUARTER) AS period, CASE ev.accountSign WHEN  'D' THEN  SUM(amtacctdr - amtacctcr) ELSE  SUM(amtacctcr - amtacctdr) END  AS totalAmt" +
      "            FROM fact_acct fa, c_elementvalue ev, AD_MONTH" +
      "            WHERE fa.account_id = ev.c_elementValue_id" +
      "            AND fa.ad_client_id IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "            AND fa.account_id = ?" +
      "            AND fa.dateacct >= TO_DATE(?)" +
      "            AND fa.dateacct < TO_DATE(?)" +
      "            AND fa.factaccttype NOT IN ('O','C','R')" +
      "            AND TO_NUMBER(TO_CHAR(TO_DATE(fa.dateacct), 'MM')) = TO_NUMBER(AD_MONTH.VALUE)" +
      "            AND 0=0 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "            AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      "     AND  2=2" +
      "            GROUP BY ev.accountSign, TO_NUMBER(AD_MONTH.QUARTER)";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      "            UNION SELECT TO_CHAR(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, D.PERIOD AS period, 0  AS totalAmt" +
      "            FROM fact_acct fa, c_elementvalue ev, (SELECT TO_NUMBER(QUARTER) AS PERIOD" +
      "                                                          FROM AD_MONTH" +
      "                                                          WHERE TO_NUMBER(VALUE) >= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))" +
      "                                                          AND TO_NUMBER(VALUE) <= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))) D" +
      "            WHERE fa.account_id = ev.c_elementValue_id" +
      "            AND fa.ad_client_id IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "            AND fa.account_id = ?" +
      "            AND fa.dateacct >= TO_DATE(?)" +
      "            AND fa.dateacct < TO_DATE(?)" +
      "            AND fa.factaccttype NOT IN ('O','C','R')" +
      "            AND 5=5 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "            AND 3=3";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      "     AND  4=4" +
      "            GROUP BY D.PERIOD";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      ") A, ";
    strSql = strSql + ((tableDimension==null || tableDimension.equals(""))?"":tableDimension);
    strSql = strSql + 
      "            WHERE A.ID = to_char(";
    strSql = strSql + ((idtableDimension==null || idtableDimension.equals(""))?"":idtableDimension);
    strSql = strSql + 
      ")" +
      "            GROUP BY A.ID, A.PERIOD, ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      "            ORDER BY ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ", A.PERIOD) AA";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (parentLevel != null && !(parentLevel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (level1 != null && !(level1.equals(""))) {
        }
      if (level2 != null && !(level2.equals(""))) {
        }
      if (level3 != null && !(level3.equals(""))) {
        }
      if (level4 != null && !(level4.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToAux);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (tableDimension != null && !(tableDimension.equals(""))) {
        }
      if (idtableDimension != null && !(idtableDimension.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.levelId = UtilSql.getValue(result, "level_id");
        objectReportAccountingCountDimensionalAnalysesData.nivel = UtilSql.getValue(result, "nivel");
        objectReportAccountingCountDimensionalAnalysesData.totalamt = UtilSql.getValue(result, "totalamt");
        objectReportAccountingCountDimensionalAnalysesData.columnLevel = UtilSql.getValue(result, "column_level");
        objectReportAccountingCountDimensionalAnalysesData.levelReport = UtilSql.getValue(result, "level_report");
        objectReportAccountingCountDimensionalAnalysesData.widthMargin = UtilSql.getValue(result, "width_margin");
        objectReportAccountingCountDimensionalAnalysesData.widthText = UtilSql.getValue(result, "width_text");
        objectReportAccountingCountDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportAccountingCountDimensionalAnalysesData.level1 = UtilSql.getValue(result, "level1");
        objectReportAccountingCountDimensionalAnalysesData.level2 = UtilSql.getValue(result, "level2");
        objectReportAccountingCountDimensionalAnalysesData.level3 = UtilSql.getValue(result, "level3");
        objectReportAccountingCountDimensionalAnalysesData.level4 = UtilSql.getValue(result, "level4");
        objectReportAccountingCountDimensionalAnalysesData.classLevel = UtilSql.getValue(result, "class_level");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectPeriodComparative(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateFromRef, String dateToRef, String dateToAux, String tableDimension, String idtableDimension)    throws ServletException {
    return selectPeriodComparative(connectionProvider, levelId, parentLevel, nivel, level, level1, level2, level3, level4, idDimension, adUserClient, accountId, dateFrom, dateTo, adOrgId, cBpartnerId, mProductId, cProjectId, filter, groupBy, dateFromRef, dateToRef, dateToAux, tableDimension, idtableDimension, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectPeriodComparative(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateFromRef, String dateToRef, String dateToAux, String tableDimension, String idtableDimension, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, LEVEL_ID, NIVEL,totalAmt, totalamt_ref, COLUMN_LEVEL, LEVEL_REPORT,TO_NUMBER(LEVEL_REPORT)*4 AS WIDTH_MARGIN, 100-TO_NUMBER(LEVEL_REPORT)*4 AS WIDTH_TEXT, NAME, CASE LEVEL_REPORT WHEN to_char(1) THEN  ID ELSE  LEVEL1 END AS LEVEL1,CASE LEVEL_REPORT WHEN to_char(2) THEN  ID ELSE  LEVEL2 END AS LEVEL2,CASE LEVEL_REPORT WHEN to_char(3) THEN  ID ELSE  LEVEL3 END AS LEVEL3,CASE LEVEL_REPORT WHEN to_char(4) THEN  ID ELSE  LEVEL4 END AS LEVEL4, CLASS_LEVEL, CLASS_LEVEL_REF, CLASS_IMAGE" +
      "      FROM (" +
      "      SELECT AM.ID, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ")||AM.ID||to_char(";
    strSql = strSql + ((parentLevel==null || parentLevel.equals(""))?"":parentLevel);
    strSql = strSql + 
      ") AS LEVEL_ID, to_char(";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ") AS NIVEL, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ") AS COLUMN_LEVEL, SUM(AM.totalAmt) AS TOTALAMT, SUM(AM.totalamt_ref) AS TOTALAMT_REF, to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, '' AS NAME, to_char(";
    strSql = strSql + ((level1==null || level1.equals(""))?"":level1);
    strSql = strSql + 
      ") AS LEVEL1, to_char(";
    strSql = strSql + ((level2==null || level2.equals(""))?"":level2);
    strSql = strSql + 
      ") AS LEVEL2, to_char(";
    strSql = strSql + ((level3==null || level3.equals(""))?"":level3);
    strSql = strSql + 
      ") AS LEVEL3, to_char(";
    strSql = strSql + ((level4==null || level4.equals(""))?"":level4);
    strSql = strSql + 
      ") AS LEVEL4 , CLASS_LEVEL, CLASS_LEVEL_REF, CLASS_IMAGE" +
      "        FROM " +
      "        (SELECT ID, ORDEN, PERIOD, SUM(CASE ORDEN WHEN 1 THEN  TOTALAMT ELSE  0 END) AS TOTALAMT, SUM(CASE ORDEN WHEN 2 THEN  TOTALAMT ELSE  0 END) AS TOTALAMT_REF, CASE LEVEL_REPORT WHEN to_char(1) THEN 'TableHeaderLevel1' WHEN to_char(2) THEN 'TableHeaderLevel2' WHEN to_char(3) THEN 'TableHeaderLevel3' ELSE 'TableHeaderLevel4' END AS CLASS_LEVEL, to_char('HeaderExcelLevel1') AS CLASS_LEVEL_REF, CASE ORDEN WHEN 1 THEN  'datawarehouseclose' ELSE  '' END AS CLASS_IMAGE" +
      "		FROM " +
      "		(SELECT ID, ORDEN, PERIOD , to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, SUM(TOTALAMT) AS TOTALAMT" +
      "         FROM(SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 1 AS ORDEN, TO_NUMBER(TO_CHAR(fa.dateacct,'MM')) AS period, CASE ev.accountSign WHEN  'D' THEN  SUM(amtacctdr - amtacctcr) ELSE  SUM(amtacctcr - amtacctdr) END  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND 0=0 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  2=2" +
      "        GROUP BY ev.accountSign, TO_NUMBER(TO_CHAR(fa.dateacct,'MM'))";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      "        UNION SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 2 AS ORDEN, TO_NUMBER(TO_CHAR(fa.dateacct,'MM')) AS period, CASE ev.accountSign WHEN  'D' THEN  SUM(amtacctdr - amtacctcr) ELSE  SUM(amtacctcr - amtacctdr) END  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND 9=9 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 3=3";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  4=4" +
      "        GROUP BY  ev.accountSign, TO_NUMBER(TO_CHAR(fa.dateacct,'MM'))";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      ") BB" +
      "        GROUP BY ID, ORDEN, PERIOD" +
      "		UNION" +
      "		SELECT ID,ORDEN,PERIOD, to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, SUM(TOTALAMT) AS TOTALAMT" +
      "         FROM (SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 1 AS ORDEN, D.PERIOD, 0  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev, (SELECT TO_NUMBER(VALUE) AS PERIOD" +
      "                                                          FROM AD_MONTH" +
      "                                                          WHERE TO_NUMBER(VALUE) >= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))" +
      "                                                          AND TO_NUMBER(VALUE) <= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))) D" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN  (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND 10=10 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 5=5";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  6=6" +
      "        GROUP BY ev.accountSign, D.PERIOD";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      "        UNION  SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 2 AS ORDEN, D.PERIOD, 0 AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev, (SELECT TO_NUMBER(VALUE) AS PERIOD" +
      "                                                          FROM AD_MONTH" +
      "                                                          WHERE TO_NUMBER(VALUE) >= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))" +
      "                                                          AND TO_NUMBER(VALUE) <= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))) D" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN   (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND 11=11 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 7=7";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  8=8" +
      "        GROUP BY  ev.accountSign, D.PERIOD";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      ") BBB" +
      "        GROUP BY ID, ORDEN, PERIOD) AAA" +
      "		GROUP BY ID, ORDEN, PERIOD, LEVEL_REPORT) AM, ";
    strSql = strSql + ((tableDimension==null || tableDimension.equals(""))?"":tableDimension);
    strSql = strSql + 
      "      WHERE AM.ID = ";
    strSql = strSql + ((idtableDimension==null || idtableDimension.equals(""))?"":idtableDimension);
    strSql = strSql + 
      "      GROUP BY AM.ID, AM.PERIOD, CLASS_LEVEL, CLASS_LEVEL_REF, CLASS_IMAGE, ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      "      ORDER BY ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ", AM.PERIOD) AA";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (parentLevel != null && !(parentLevel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (level1 != null && !(level1.equals(""))) {
        }
      if (level2 != null && !(level2.equals(""))) {
        }
      if (level3 != null && !(level3.equals(""))) {
        }
      if (level4 != null && !(level4.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToAux);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToAux);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (tableDimension != null && !(tableDimension.equals(""))) {
        }
      if (idtableDimension != null && !(idtableDimension.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.levelId = UtilSql.getValue(result, "level_id");
        objectReportAccountingCountDimensionalAnalysesData.nivel = UtilSql.getValue(result, "nivel");
        objectReportAccountingCountDimensionalAnalysesData.totalamt = UtilSql.getValue(result, "totalamt");
        objectReportAccountingCountDimensionalAnalysesData.totalamtRef = UtilSql.getValue(result, "totalamt_ref");
        objectReportAccountingCountDimensionalAnalysesData.columnLevel = UtilSql.getValue(result, "column_level");
        objectReportAccountingCountDimensionalAnalysesData.levelReport = UtilSql.getValue(result, "level_report");
        objectReportAccountingCountDimensionalAnalysesData.widthMargin = UtilSql.getValue(result, "width_margin");
        objectReportAccountingCountDimensionalAnalysesData.widthText = UtilSql.getValue(result, "width_text");
        objectReportAccountingCountDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportAccountingCountDimensionalAnalysesData.level1 = UtilSql.getValue(result, "level1");
        objectReportAccountingCountDimensionalAnalysesData.level2 = UtilSql.getValue(result, "level2");
        objectReportAccountingCountDimensionalAnalysesData.level3 = UtilSql.getValue(result, "level3");
        objectReportAccountingCountDimensionalAnalysesData.level4 = UtilSql.getValue(result, "level4");
        objectReportAccountingCountDimensionalAnalysesData.classLevel = UtilSql.getValue(result, "class_level");
        objectReportAccountingCountDimensionalAnalysesData.classLevelRef = UtilSql.getValue(result, "class_level_ref");
        objectReportAccountingCountDimensionalAnalysesData.classImage = UtilSql.getValue(result, "class_image");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectPeriodComparativeQuarter(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateFromRef, String dateToRef, String dateToAux, String tableDimension, String idtableDimension)    throws ServletException {
    return selectPeriodComparativeQuarter(connectionProvider, levelId, parentLevel, nivel, level, level1, level2, level3, level4, idDimension, adUserClient, accountId, dateFrom, dateTo, adOrgId, cBpartnerId, mProductId, cProjectId, filter, groupBy, dateFromRef, dateToRef, dateToAux, tableDimension, idtableDimension, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectPeriodComparativeQuarter(ConnectionProvider connectionProvider, String levelId, String parentLevel, String nivel, String level, String level1, String level2, String level3, String level4, String idDimension, String adUserClient, String accountId, String dateFrom, String dateTo, String adOrgId, String cBpartnerId, String mProductId, String cProjectId, String filter, String groupBy, String dateFromRef, String dateToRef, String dateToAux, String tableDimension, String idtableDimension, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, LEVEL_ID, NIVEL,totalAmt, totalamt_ref, COLUMN_LEVEL, LEVEL_REPORT,TO_NUMBER(LEVEL_REPORT)*4 AS WIDTH_MARGIN, 100-TO_NUMBER(LEVEL_REPORT)*4 AS WIDTH_TEXT, NAME, CASE LEVEL_REPORT WHEN to_char(1) THEN  ID ELSE  LEVEL1 END AS LEVEL1,CASE LEVEL_REPORT WHEN to_char(2) THEN  ID ELSE  LEVEL2 END AS LEVEL2,CASE LEVEL_REPORT WHEN to_char(3) THEN  ID ELSE  LEVEL3 END AS LEVEL3,CASE LEVEL_REPORT WHEN to_char(4) THEN  ID ELSE  LEVEL4 END AS LEVEL4, CLASS_LEVEL, CLASS_LEVEL_REF, CLASS_IMAGE" +
      "      FROM (" +
      "      SELECT AM.ID, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ")||AM.ID||to_char(";
    strSql = strSql + ((parentLevel==null || parentLevel.equals(""))?"":parentLevel);
    strSql = strSql + 
      ") AS LEVEL_ID, to_char(";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ") AS NIVEL, to_char(";
    strSql = strSql + ((levelId==null || levelId.equals(""))?"":levelId);
    strSql = strSql + 
      ") AS COLUMN_LEVEL, SUM(AM.totalAmt) AS TOTALAMT, SUM(AM.totalamt_ref) AS TOTALAMT_REF, to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, '' AS NAME, to_char(";
    strSql = strSql + ((level1==null || level1.equals(""))?"":level1);
    strSql = strSql + 
      ") AS LEVEL1, to_char(";
    strSql = strSql + ((level2==null || level2.equals(""))?"":level2);
    strSql = strSql + 
      ") AS LEVEL2, to_char(";
    strSql = strSql + ((level3==null || level3.equals(""))?"":level3);
    strSql = strSql + 
      ") AS LEVEL3, to_char(";
    strSql = strSql + ((level4==null || level4.equals(""))?"":level4);
    strSql = strSql + 
      ") AS LEVEL4 , CLASS_LEVEL, CLASS_LEVEL_REF, CLASS_IMAGE" +
      "        FROM " +
      "        (SELECT ID, ORDEN, PERIOD, SUM(CASE ORDEN WHEN 1 THEN  TOTALAMT ELSE  0 END) AS TOTALAMT, SUM(CASE ORDEN WHEN 2 THEN  TOTALAMT ELSE  0 END) AS TOTALAMT_REF, CASE LEVEL_REPORT WHEN to_char(1) THEN 'TableHeaderLevel1' WHEN to_char(2) THEN 'TableHeaderLevel2' WHEN to_char(3) THEN 'TableHeaderLevel3' ELSE 'TableHeaderLevel4' END AS CLASS_LEVEL, to_char('HeaderExcelLevel1') AS CLASS_LEVEL_REF, CASE ORDEN WHEN 1 THEN  'datawarehouseclose' ELSE  '' END AS CLASS_IMAGE" +
      "		FROM " +
      "		(SELECT ID, ORDEN, PERIOD , to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, SUM(TOTALAMT) AS TOTALAMT" +
      "         FROM(SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 1 AS ORDEN, TO_NUMBER(AD_MONTH.QUARTER) AS period, CASE ev.accountSign WHEN  'D' THEN  SUM(amtacctdr - amtacctcr) ELSE  SUM(amtacctcr - amtacctdr) END  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev, AD_MONTH" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND TO_NUMBER(TO_CHAR(TO_DATE(fa.dateacct), 'MM')) = TO_NUMBER(AD_MONTH.VALUE)" +
      "        AND 0=0 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  2=2" +
      "        GROUP BY ev.accountSign, TO_NUMBER(AD_MONTH.QUARTER)";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      " UNION SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 2 AS ORDEN, TO_NUMBER(AD_MONTH.QUARTER) AS period, CASE ev.accountSign WHEN  'D' THEN  SUM(amtacctdr - amtacctcr) ELSE  SUM(amtacctcr - amtacctdr) END  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev, AD_MONTH" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN(";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND TO_NUMBER(TO_CHAR(TO_DATE(fa.dateacct), 'MM')) = TO_NUMBER(AD_MONTH.VALUE)" +
      "        AND 9=9 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 3=3";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  4=4" +
      "        GROUP BY  ev.accountSign, TO_NUMBER(AD_MONTH.QUARTER)";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      ") BBB" +
      "        GROUP BY ID, ORDEN, PERIOD" +
      "		UNION" +
      "		SELECT ID,ORDEN,PERIOD, to_char(";
    strSql = strSql + ((level==null || level.equals(""))?"":level);
    strSql = strSql + 
      ") AS LEVEL_REPORT, SUM(TOTALAMT) AS TOTALAMT" +
      "         FROM (SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 1 AS ORDEN, D.PERIOD, 0  AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev, (SELECT TO_NUMBER(QUARTER) AS PERIOD" +
      "                                                          FROM AD_MONTH" +
      "                                                          WHERE TO_NUMBER(VALUE) >= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))" +
      "                                                          AND TO_NUMBER(VALUE) <= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))) D" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN  (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND 10=10 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 5=5";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  6=6" +
      "        GROUP BY ev.accountSign, D.PERIOD";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      "        UNION  SELECT to_char(";
    strSql = strSql + ((idDimension==null || idDimension.equals(""))?"":idDimension);
    strSql = strSql + 
      ") AS ID, 2 AS ORDEN, D.PERIOD, 0 AS totalAmt" +
      "        FROM fact_acct fa, c_elementvalue ev, (SELECT TO_NUMBER(QUARTER) AS PERIOD" +
      "                                                          FROM AD_MONTH" +
      "                                                          WHERE TO_NUMBER(VALUE) >= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))" +
      "                                                          AND TO_NUMBER(VALUE) <= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))) D" +
      "        WHERE fa.account_id = ev.c_elementValue_id" +
      "        AND fa.ad_client_id IN   (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND fa.account_id = ?" +
      "        AND fa.dateacct >= TO_DATE(?)" +
      "        AND fa.dateacct < TO_DATE(?)" +
      "        AND fa.factaccttype NOT IN ('O','C','R')" +
      "        AND 11=11 AND fa.ad_org_id IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        AND 7=7";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_BPARTNER_ID IN" + cBpartnerId);
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND M_PRODUCT_ID IN" + mProductId);
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":" AND C_PROJECT_ID = ? ");
    strSql = strSql + ((filter==null || filter.equals(""))?"":filter);
    strSql = strSql + 
      " AND  8=8" +
      "        GROUP BY  ev.accountSign, D.PERIOD";
    strSql = strSql + ((groupBy==null || groupBy.equals(""))?"":groupBy);
    strSql = strSql + 
      ") CC" +
      "        GROUP BY ID, ORDEN, PERIOD) BB" +
      "		GROUP BY ID, ORDEN, PERIOD, LEVEL_REPORT) AM, ";
    strSql = strSql + ((tableDimension==null || tableDimension.equals(""))?"":tableDimension);
    strSql = strSql + 
      "      WHERE AM.ID = ";
    strSql = strSql + ((idtableDimension==null || idtableDimension.equals(""))?"":idtableDimension);
    strSql = strSql + 
      "      GROUP BY AM.ID, AM.PERIOD, CLASS_LEVEL, CLASS_LEVEL_REF, CLASS_IMAGE, ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      "      ORDER BY ";
    strSql = strSql + ((nivel==null || nivel.equals(""))?"":nivel);
    strSql = strSql + 
      ", AM.PERIOD) AA";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (parentLevel != null && !(parentLevel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (levelId != null && !(levelId.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (level1 != null && !(level1.equals(""))) {
        }
      if (level2 != null && !(level2.equals(""))) {
        }
      if (level3 != null && !(level3.equals(""))) {
        }
      if (level4 != null && !(level4.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (level != null && !(level.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToAux);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (idDimension != null && !(idDimension.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToAux);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFromRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateToRef);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        }
      if (mProductId != null && !(mProductId.equals(""))) {
        }
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      }
      if (filter != null && !(filter.equals(""))) {
        }
      if (groupBy != null && !(groupBy.equals(""))) {
        }
      if (tableDimension != null && !(tableDimension.equals(""))) {
        }
      if (idtableDimension != null && !(idtableDimension.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
        }
      if (nivel != null && !(nivel.equals(""))) {
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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.levelId = UtilSql.getValue(result, "level_id");
        objectReportAccountingCountDimensionalAnalysesData.nivel = UtilSql.getValue(result, "nivel");
        objectReportAccountingCountDimensionalAnalysesData.totalamt = UtilSql.getValue(result, "totalamt");
        objectReportAccountingCountDimensionalAnalysesData.totalamtRef = UtilSql.getValue(result, "totalamt_ref");
        objectReportAccountingCountDimensionalAnalysesData.columnLevel = UtilSql.getValue(result, "column_level");
        objectReportAccountingCountDimensionalAnalysesData.levelReport = UtilSql.getValue(result, "level_report");
        objectReportAccountingCountDimensionalAnalysesData.widthMargin = UtilSql.getValue(result, "width_margin");
        objectReportAccountingCountDimensionalAnalysesData.widthText = UtilSql.getValue(result, "width_text");
        objectReportAccountingCountDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportAccountingCountDimensionalAnalysesData.level1 = UtilSql.getValue(result, "level1");
        objectReportAccountingCountDimensionalAnalysesData.level2 = UtilSql.getValue(result, "level2");
        objectReportAccountingCountDimensionalAnalysesData.level3 = UtilSql.getValue(result, "level3");
        objectReportAccountingCountDimensionalAnalysesData.level4 = UtilSql.getValue(result, "level4");
        objectReportAccountingCountDimensionalAnalysesData.classLevel = UtilSql.getValue(result, "class_level");
        objectReportAccountingCountDimensionalAnalysesData.classLevelRef = UtilSql.getValue(result, "class_level_ref");
        objectReportAccountingCountDimensionalAnalysesData.classImage = UtilSql.getValue(result, "class_image");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectDate(ConnectionProvider connectionProvider, String dateFrom, String dateTo)    throws ServletException {
    return selectDate(connectionProvider, dateFrom, dateTo, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectDate(ConnectionProvider connectionProvider, String dateFrom, String dateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT NAME AS ID" +
      "      FROM AD_MONTH" +
      "      WHERE TO_NUMBER(VALUE) >= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))" +
      "      AND TO_NUMBER(VALUE) <= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);

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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectQuarter(ConnectionProvider connectionProvider, String dateFrom, String dateTo)    throws ServletException {
    return selectQuarter(connectionProvider, dateFrom, dateTo, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectQuarter(ConnectionProvider connectionProvider, String dateFrom, String dateTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT QUARTER AS ID" +
      "      FROM AD_MONTH" +
      "      WHERE TO_NUMBER(VALUE) >= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))" +
      "      AND TO_NUMBER(VALUE) <= TO_NUMBER(TO_CHAR(TO_DATE(to_char(?)), 'MM'))";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);

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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static String selectProject(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_PROJECT.NAME" +
      "      FROM C_PROJECT" +
      "      WHERE C_PROJECT_ID = ?";

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

  public static String selectAccountingCount(ConnectionProvider connectionProvider, String accountingId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_ELEMENTVALUE.NAME" +
      "      FROM C_ELEMENTVALUE" +
      "      WHERE C_ELEMENTVALUE.C_ELEMENTVALUE_ID = ?" +
      "      AND C_ELEMENTVALUE.ISACTIVE = 'Y'";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, accountingId);

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

  public static String selectEntity(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT.NAME" +
      "      FROM AD_CLIENT" +
      "      WHERE AD_CLIENT.AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

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

  public static ReportAccountingCountDimensionalAnalysesData[] selectShown(ConnectionProvider connectionProvider)    throws ServletException {
    return selectShown(connectionProvider, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectShown(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ID, NAME" +
      "      FROM (SELECT 'AD_ORG_ID' AS ID, 'Organizacion' AS NAME FROM DUAL" +
      "      UNION" +
      "      SELECT 'C_BPARTNER_ID' AS ID, 'Tercero' AS NAME FROM DUAL" +
      "      UNION " +
      "      SELECT 'M_PRODUCT_ID' AS ID, 'Producto' AS NAME FROM DUAL" +
      "      UNION" +
      "      SELECT 'C_PROJECT_ID' AS ID, 'Proyecto' AS NAME FROM DUAL) A";

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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.id = UtilSql.getValue(result, "id");
        objectReportAccountingCountDimensionalAnalysesData.name = UtilSql.getValue(result, "name");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectDimension(ConnectionProvider connectionProvider, String processName)    throws ServletException {
    return selectDimension(connectionProvider, processName, 0, 0);
  }

  public static ReportAccountingCountDimensionalAnalysesData[] selectDimension(ConnectionProvider connectionProvider, String processName, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_DIMENSION.COLUMNNAME, AD_DIMENSION.LINE, AD_DIMENSION.DESCRIPTION, AD_DIMENSION.JOIN_GROUP1, AD_DIMENSION.TABLENAME, AD_DIMENSION.JOIN_GROUP2" +
      "      FROM AD_DIMENSION, AD_PROCESS" +
      "      WHERE AD_DIMENSION.AD_PROCESS_ID = AD_PROCESS.AD_PROCESS_ID" +
      "      AND AD_PROCESS.VALUE = ?" +
      "      ORDER BY AD_DIMENSION.LINE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processName);

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
        ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData = new ReportAccountingCountDimensionalAnalysesData();
        objectReportAccountingCountDimensionalAnalysesData.columnname = UtilSql.getValue(result, "columnname");
        objectReportAccountingCountDimensionalAnalysesData.line = UtilSql.getValue(result, "line");
        objectReportAccountingCountDimensionalAnalysesData.description = UtilSql.getValue(result, "description");
        objectReportAccountingCountDimensionalAnalysesData.joinGroup1 = UtilSql.getValue(result, "join_group1");
        objectReportAccountingCountDimensionalAnalysesData.tablename = UtilSql.getValue(result, "tablename");
        objectReportAccountingCountDimensionalAnalysesData.joinGroup2 = UtilSql.getValue(result, "join_group2");
        objectReportAccountingCountDimensionalAnalysesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportAccountingCountDimensionalAnalysesData);
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
    ReportAccountingCountDimensionalAnalysesData objectReportAccountingCountDimensionalAnalysesData[] = new ReportAccountingCountDimensionalAnalysesData[vector.size()];
    vector.copyInto(objectReportAccountingCountDimensionalAnalysesData);
    return(objectReportAccountingCountDimensionalAnalysesData);
  }

  public static String selectDimensionName(ConnectionProvider connectionProvider, String language, String columnname)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT ((CASE AD_ELEMENT.ISACTIVE WHEN 'N' THEN '**' ELSE '' END) || (CASE WHEN AD_ELEMENT_TRL.NAME IS NULL THEN AD_ELEMENT.NAME ELSE AD_ELEMENT_TRL.NAME END)) AS NAME" +
      "    FROM AD_ELEMENT left join AD_ELEMENT_TRL on AD_ELEMENT.AD_ELEMENT_ID = AD_ELEMENT_TRL.AD_ELEMENT_ID" +
      "                                            and AD_ELEMENT_TRL.AD_LANGUAGE  = ?" +
      "    WHERE UPPER(AD_ELEMENT.COLUMNNAME) = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, columnname);

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
}

//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.costing.IndirectCost;

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
class Value800230Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Value800230Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maIndirectCostValueId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String maIndirectCostId;
  public String maIndirectCostIdr;
  public String isactive;
  public String datefrom;
  public String costUom;
  public String costUomr;
  public String empcost;
  public String machinecost;
  public String materialcost;
  public String vendorcost;
  public String dateto;
  public String total;
  public String calculated;
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
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_value_id") || fieldName.equals("maIndirectCostValueId"))
      return maIndirectCostValueId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_id") || fieldName.equals("maIndirectCostId"))
      return maIndirectCostId;
    else if (fieldName.equalsIgnoreCase("ma_indirect_cost_idr") || fieldName.equals("maIndirectCostIdr"))
      return maIndirectCostIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("cost_uom") || fieldName.equals("costUom"))
      return costUom;
    else if (fieldName.equalsIgnoreCase("cost_uomr") || fieldName.equals("costUomr"))
      return costUomr;
    else if (fieldName.equalsIgnoreCase("empcost"))
      return empcost;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("vendorcost"))
      return vendorcost;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("calculated"))
      return calculated;
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
  public static Value800230Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maIndirectCostId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maIndirectCostId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Value800230Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maIndirectCostId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Indirect_Cost_Value.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Indirect_Cost_Value.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Indirect_Cost_Value.Updated, ?) as updated, " +
      "        to_char(MA_Indirect_Cost_Value.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Indirect_Cost_Value.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Indirect_Cost_Value.UpdatedBy) as UpdatedByR," +
      "        MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID, " +
      "MA_Indirect_Cost_Value.AD_Client_ID, " +
      "(CASE WHEN MA_Indirect_Cost_Value.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Indirect_Cost_Value.AD_Org_ID, " +
      "(CASE WHEN MA_Indirect_Cost_Value.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Indirect_Cost_Value.MA_Indirect_Cost_ID, " +
      "(CASE WHEN MA_Indirect_Cost_Value.MA_Indirect_Cost_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Indirect_Cost_IDR, " +
      "COALESCE(MA_Indirect_Cost_Value.IsActive, 'N') AS IsActive, " +
      "MA_Indirect_Cost_Value.DateFrom, " +
      "MA_Indirect_Cost_Value.Cost_Uom, " +
      "(CASE WHEN MA_Indirect_Cost_Value.Cost_Uom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Cost_UomR, " +
      "MA_Indirect_Cost_Value.empCost, " +
      "MA_Indirect_Cost_Value.Machinecost, " +
      "MA_Indirect_Cost_Value.Materialcost, " +
      "MA_Indirect_Cost_Value.Vendorcost, " +
      "MA_Indirect_Cost_Value.DateTo, " +
      "MA_Indirect_Cost_Value.Total, " +
      "COALESCE(MA_Indirect_Cost_Value.Calculated, 'N') AS Calculated, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Indirect_Cost_Value left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Indirect_Cost_Value.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Indirect_Cost_Value.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Indirect_Cost_ID, Name from MA_Indirect_Cost) table3 on (MA_Indirect_Cost_Value.MA_Indirect_Cost_ID = table3.MA_Indirect_Cost_ID) left join ad_ref_list_v list1 on (MA_Indirect_Cost_Value.Cost_Uom = list1.value and list1.ad_reference_id = '800088' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maIndirectCostId==null || maIndirectCostId.equals(""))?"":"  AND MA_Indirect_Cost_Value.MA_Indirect_Cost_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ? " +
      "        AND MA_Indirect_Cost_Value.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Indirect_Cost_Value.AD_Org_ID IN (";
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
      if (maIndirectCostId != null && !(maIndirectCostId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
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
        Value800230Data objectValue800230Data = new Value800230Data();
        objectValue800230Data.created = UtilSql.getValue(result, "created");
        objectValue800230Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectValue800230Data.updated = UtilSql.getValue(result, "updated");
        objectValue800230Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectValue800230Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectValue800230Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectValue800230Data.maIndirectCostValueId = UtilSql.getValue(result, "ma_indirect_cost_value_id");
        objectValue800230Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectValue800230Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectValue800230Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectValue800230Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectValue800230Data.maIndirectCostId = UtilSql.getValue(result, "ma_indirect_cost_id");
        objectValue800230Data.maIndirectCostIdr = UtilSql.getValue(result, "ma_indirect_cost_idr");
        objectValue800230Data.isactive = UtilSql.getValue(result, "isactive");
        objectValue800230Data.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectValue800230Data.costUom = UtilSql.getValue(result, "cost_uom");
        objectValue800230Data.costUomr = UtilSql.getValue(result, "cost_uomr");
        objectValue800230Data.empcost = UtilSql.getValue(result, "empcost");
        objectValue800230Data.machinecost = UtilSql.getValue(result, "machinecost");
        objectValue800230Data.materialcost = UtilSql.getValue(result, "materialcost");
        objectValue800230Data.vendorcost = UtilSql.getValue(result, "vendorcost");
        objectValue800230Data.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectValue800230Data.total = UtilSql.getValue(result, "total");
        objectValue800230Data.calculated = UtilSql.getValue(result, "calculated");
        objectValue800230Data.language = UtilSql.getValue(result, "language");
        objectValue800230Data.adUserClient = "";
        objectValue800230Data.adOrgClient = "";
        objectValue800230Data.createdby = "";
        objectValue800230Data.trBgcolor = "";
        objectValue800230Data.totalCount = "";
        objectValue800230Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectValue800230Data);
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
    Value800230Data objectValue800230Data[] = new Value800230Data[vector.size()];
    vector.copyInto(objectValue800230Data);
    return(objectValue800230Data);
  }

/**
Create a registry
 */
  public static Value800230Data[] set(String maIndirectCostId, String costUom, String datefrom, String empcost, String vendorcost, String materialcost, String machinecost, String maIndirectCostValueId, String dateto, String createdby, String createdbyr, String adOrgId, String updatedby, String updatedbyr, String adClientId, String calculated, String isactive, String total)    throws ServletException {
    Value800230Data objectValue800230Data[] = new Value800230Data[1];
    objectValue800230Data[0] = new Value800230Data();
    objectValue800230Data[0].created = "";
    objectValue800230Data[0].createdbyr = createdbyr;
    objectValue800230Data[0].updated = "";
    objectValue800230Data[0].updatedTimeStamp = "";
    objectValue800230Data[0].updatedby = updatedby;
    objectValue800230Data[0].updatedbyr = updatedbyr;
    objectValue800230Data[0].maIndirectCostValueId = maIndirectCostValueId;
    objectValue800230Data[0].adClientId = adClientId;
    objectValue800230Data[0].adClientIdr = "";
    objectValue800230Data[0].adOrgId = adOrgId;
    objectValue800230Data[0].adOrgIdr = "";
    objectValue800230Data[0].maIndirectCostId = maIndirectCostId;
    objectValue800230Data[0].maIndirectCostIdr = "";
    objectValue800230Data[0].isactive = isactive;
    objectValue800230Data[0].datefrom = datefrom;
    objectValue800230Data[0].costUom = costUom;
    objectValue800230Data[0].costUomr = "";
    objectValue800230Data[0].empcost = empcost;
    objectValue800230Data[0].machinecost = machinecost;
    objectValue800230Data[0].materialcost = materialcost;
    objectValue800230Data[0].vendorcost = vendorcost;
    objectValue800230Data[0].dateto = dateto;
    objectValue800230Data[0].total = total;
    objectValue800230Data[0].calculated = calculated;
    objectValue800230Data[0].language = "";
    return objectValue800230Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803192_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803194_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_Indirect_Cost_Value.MA_Indirect_Cost_ID AS NAME" +
      "        FROM MA_Indirect_Cost_Value" +
      "        WHERE MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maIndirectCostId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Indirect_Cost left join (select MA_Indirect_Cost_ID, Name from MA_Indirect_Cost) table1 on (MA_Indirect_Cost.MA_Indirect_Cost_ID = table1.MA_Indirect_Cost_ID) WHERE MA_Indirect_Cost.MA_Indirect_Cost_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maIndirectCostId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Indirect_Cost left join (select MA_Indirect_Cost_ID, Name from MA_Indirect_Cost) table1 on (MA_Indirect_Cost.MA_Indirect_Cost_ID = table1.MA_Indirect_Cost_ID) WHERE MA_Indirect_Cost.MA_Indirect_Cost_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);

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
      "        UPDATE MA_Indirect_Cost_Value" +
      "        SET MA_Indirect_Cost_Value_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , MA_Indirect_Cost_ID = (?) , IsActive = (?) , DateFrom = TO_DATE(?) , Cost_Uom = (?) , empCost = TO_NUMBER(?) , Machinecost = TO_NUMBER(?) , Materialcost = TO_NUMBER(?) , Vendorcost = TO_NUMBER(?) , DateTo = TO_DATE(?) , Total = TO_NUMBER(?) , Calculated = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ? " +
      "                 AND MA_Indirect_Cost_Value.MA_Indirect_Cost_ID = ? " +
      "        AND MA_Indirect_Cost_Value.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Indirect_Cost_Value.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, empcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, total);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
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
      "        INSERT INTO MA_Indirect_Cost_Value " +
      "        (MA_Indirect_Cost_Value_ID, AD_Client_ID, AD_Org_ID, MA_Indirect_Cost_ID, IsActive, DateFrom, Cost_Uom, empCost, Machinecost, Materialcost, Vendorcost, DateTo, Total, Calculated, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostValueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, empcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, total);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maIndirectCostId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Indirect_Cost_Value" +
      "        WHERE MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ? " +
      "                 AND MA_Indirect_Cost_Value.MA_Indirect_Cost_ID = ? " +
      "        AND MA_Indirect_Cost_Value.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Indirect_Cost_Value.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maIndirectCostId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Indirect_Cost_Value" +
      "        WHERE MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ? " +
      "                 AND MA_Indirect_Cost_Value.MA_Indirect_Cost_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maIndirectCostId);

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
      "          FROM MA_Indirect_Cost_Value" +
      "         WHERE MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ? ";

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
      "          FROM MA_Indirect_Cost_Value" +
      "         WHERE MA_Indirect_Cost_Value.MA_Indirect_Cost_Value_ID = ? ";

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

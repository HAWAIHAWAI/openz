//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.asset.Machine;

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
class Cost800236Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Cost800236Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adClientIdr;
  public String maMachineCostId;
  public String adOrgId;
  public String adOrgIdr;
  public String maMachineId;
  public String maMachineIdr;
  public String isactive;
  public String validfrom;
  public String cost;
  public String costuom;
  public String costuomr;
  public String purchaseamt;
  public String toolsetamt;
  public String amortization;
  public String yearvalue;
  public String daysyear;
  public String dayhours;
  public String improductivehoursyear;
  public String consume;
  public String costuomyear;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ma_machine_cost_id") || fieldName.equals("maMachineCostId"))
      return maMachineCostId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("costuomr"))
      return costuomr;
    else if (fieldName.equalsIgnoreCase("purchaseamt"))
      return purchaseamt;
    else if (fieldName.equalsIgnoreCase("toolsetamt"))
      return toolsetamt;
    else if (fieldName.equalsIgnoreCase("amortization"))
      return amortization;
    else if (fieldName.equalsIgnoreCase("yearvalue"))
      return yearvalue;
    else if (fieldName.equalsIgnoreCase("daysyear"))
      return daysyear;
    else if (fieldName.equalsIgnoreCase("dayhours"))
      return dayhours;
    else if (fieldName.equalsIgnoreCase("improductivehoursyear"))
      return improductivehoursyear;
    else if (fieldName.equalsIgnoreCase("consume"))
      return consume;
    else if (fieldName.equalsIgnoreCase("costuomyear"))
      return costuomyear;
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
  public static Cost800236Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maMachineId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Cost800236Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maMachineId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Machine_Cost.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Machine_Cost.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Machine_Cost.Updated, ?) as updated, " +
      "        to_char(MA_Machine_Cost.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Machine_Cost.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Machine_Cost.UpdatedBy) as UpdatedByR," +
      "        MA_Machine_Cost.AD_Client_ID, " +
      "(CASE WHEN MA_Machine_Cost.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Machine_Cost.MA_Machine_Cost_ID, " +
      "MA_Machine_Cost.AD_Org_ID, " +
      "(CASE WHEN MA_Machine_Cost.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_Machine_Cost.MA_Machine_ID, " +
      "(CASE WHEN MA_Machine_Cost.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "COALESCE(MA_Machine_Cost.IsActive, 'N') AS IsActive, " +
      "MA_Machine_Cost.ValidFrom, " +
      "MA_Machine_Cost.Cost, " +
      "MA_Machine_Cost.Costuom, " +
      "(CASE WHEN MA_Machine_Cost.Costuom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS CostuomR, " +
      "MA_Machine_Cost.Purchaseamt, " +
      "MA_Machine_Cost.Toolsetamt, " +
      "MA_Machine_Cost.Amortization, " +
      "MA_Machine_Cost.Yearvalue, " +
      "MA_Machine_Cost.Daysyear, " +
      "MA_Machine_Cost.Dayhours, " +
      "MA_Machine_Cost.Improductivehoursyear, " +
      "MA_Machine_Cost.Consume, " +
      "MA_Machine_Cost.Costuomyear, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Machine_Cost left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Machine_Cost.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Machine_Cost.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table3 on (MA_Machine_Cost.MA_Machine_ID = table3.MA_Machine_ID) left join ad_ref_list_v list1 on (MA_Machine_Cost.Costuom = list1.value and list1.ad_reference_id = 'DE781226949D4A9F8782BA610C3621C6' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maMachineId==null || maMachineId.equals(""))?"":"  AND MA_Machine_Cost.MA_Machine_ID = ?  ");
    strSql = strSql + 
      "        AND MA_Machine_Cost.MA_Machine_Cost_ID = ? " +
      "        AND MA_Machine_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Machine_Cost.AD_Org_ID IN (";
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
      if (maMachineId != null && !(maMachineId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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
        Cost800236Data objectCost800236Data = new Cost800236Data();
        objectCost800236Data.created = UtilSql.getValue(result, "created");
        objectCost800236Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCost800236Data.updated = UtilSql.getValue(result, "updated");
        objectCost800236Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCost800236Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectCost800236Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCost800236Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCost800236Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectCost800236Data.maMachineCostId = UtilSql.getValue(result, "ma_machine_cost_id");
        objectCost800236Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCost800236Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCost800236Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectCost800236Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectCost800236Data.isactive = UtilSql.getValue(result, "isactive");
        objectCost800236Data.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectCost800236Data.cost = UtilSql.getValue(result, "cost");
        objectCost800236Data.costuom = UtilSql.getValue(result, "costuom");
        objectCost800236Data.costuomr = UtilSql.getValue(result, "costuomr");
        objectCost800236Data.purchaseamt = UtilSql.getValue(result, "purchaseamt");
        objectCost800236Data.toolsetamt = UtilSql.getValue(result, "toolsetamt");
        objectCost800236Data.amortization = UtilSql.getValue(result, "amortization");
        objectCost800236Data.yearvalue = UtilSql.getValue(result, "yearvalue");
        objectCost800236Data.daysyear = UtilSql.getValue(result, "daysyear");
        objectCost800236Data.dayhours = UtilSql.getValue(result, "dayhours");
        objectCost800236Data.improductivehoursyear = UtilSql.getValue(result, "improductivehoursyear");
        objectCost800236Data.consume = UtilSql.getValue(result, "consume");
        objectCost800236Data.costuomyear = UtilSql.getValue(result, "costuomyear");
        objectCost800236Data.language = UtilSql.getValue(result, "language");
        objectCost800236Data.adUserClient = "";
        objectCost800236Data.adOrgClient = "";
        objectCost800236Data.createdby = "";
        objectCost800236Data.trBgcolor = "";
        objectCost800236Data.totalCount = "";
        objectCost800236Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCost800236Data);
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
    Cost800236Data objectCost800236Data[] = new Cost800236Data[vector.size()];
    vector.copyInto(objectCost800236Data);
    return(objectCost800236Data);
  }

/**
Create a registry
 */
  public static Cost800236Data[] set(String maMachineId, String purchaseamt, String toolsetamt, String yearvalue, String costuomyear, String improductivehoursyear, String dayhours, String consume, String maMachineCostId, String isactive, String adClientId, String costuom, String createdby, String createdbyr, String adOrgId, String updatedby, String updatedbyr, String cost, String validfrom, String amortization, String daysyear)    throws ServletException {
    Cost800236Data objectCost800236Data[] = new Cost800236Data[1];
    objectCost800236Data[0] = new Cost800236Data();
    objectCost800236Data[0].created = "";
    objectCost800236Data[0].createdbyr = createdbyr;
    objectCost800236Data[0].updated = "";
    objectCost800236Data[0].updatedTimeStamp = "";
    objectCost800236Data[0].updatedby = updatedby;
    objectCost800236Data[0].updatedbyr = updatedbyr;
    objectCost800236Data[0].adClientId = adClientId;
    objectCost800236Data[0].adClientIdr = "";
    objectCost800236Data[0].maMachineCostId = maMachineCostId;
    objectCost800236Data[0].adOrgId = adOrgId;
    objectCost800236Data[0].adOrgIdr = "";
    objectCost800236Data[0].maMachineId = maMachineId;
    objectCost800236Data[0].maMachineIdr = "";
    objectCost800236Data[0].isactive = isactive;
    objectCost800236Data[0].validfrom = validfrom;
    objectCost800236Data[0].cost = cost;
    objectCost800236Data[0].costuom = costuom;
    objectCost800236Data[0].costuomr = "";
    objectCost800236Data[0].purchaseamt = purchaseamt;
    objectCost800236Data[0].toolsetamt = toolsetamt;
    objectCost800236Data[0].amortization = amortization;
    objectCost800236Data[0].yearvalue = yearvalue;
    objectCost800236Data[0].daysyear = daysyear;
    objectCost800236Data[0].dayhours = dayhours;
    objectCost800236Data[0].improductivehoursyear = improductivehoursyear;
    objectCost800236Data[0].consume = consume;
    objectCost800236Data[0].costuomyear = costuomyear;
    objectCost800236Data[0].language = "";
    return objectCost800236Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803320_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803322_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT MA_Machine_Cost.MA_Machine_ID AS NAME" +
      "        FROM MA_Machine_Cost" +
      "        WHERE MA_Machine_Cost.MA_Machine_Cost_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maMachineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Machine left join (select MA_Machine_ID, Value, Name from MA_Machine) table1 on (MA_Machine.MA_Machine_ID = table1.MA_Machine_ID) WHERE MA_Machine.MA_Machine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maMachineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Machine left join (select MA_Machine_ID, Value, Name from MA_Machine) table1 on (MA_Machine.MA_Machine_ID = table1.MA_Machine_ID) WHERE MA_Machine.MA_Machine_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);

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
      "        UPDATE MA_Machine_Cost" +
      "        SET AD_Client_ID = (?) , MA_Machine_Cost_ID = (?) , AD_Org_ID = (?) , MA_Machine_ID = (?) , IsActive = (?) , ValidFrom = TO_DATE(?) , Cost = TO_NUMBER(?) , Costuom = (?) , Purchaseamt = TO_NUMBER(?) , Toolsetamt = TO_NUMBER(?) , Amortization = TO_NUMBER(?) , Yearvalue = TO_NUMBER(?) , Daysyear = TO_NUMBER(?) , Dayhours = TO_NUMBER(?) , Improductivehoursyear = TO_NUMBER(?) , Consume = TO_NUMBER(?) , Costuomyear = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Machine_Cost.MA_Machine_Cost_ID = ? " +
      "                 AND MA_Machine_Cost.MA_Machine_ID = ? " +
      "        AND MA_Machine_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Machine_Cost.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchaseamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toolsetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortization);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daysyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, improductivehoursyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuomyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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
      "        INSERT INTO MA_Machine_Cost " +
      "        (AD_Client_ID, MA_Machine_Cost_ID, AD_Org_ID, MA_Machine_ID, IsActive, ValidFrom, Cost, Costuom, Purchaseamt, Toolsetamt, Amortization, Yearvalue, Daysyear, Dayhours, Improductivehoursyear, Consume, Costuomyear, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchaseamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, toolsetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amortization);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, daysyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dayhours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, improductivehoursyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consume);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuomyear);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maMachineId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Machine_Cost" +
      "        WHERE MA_Machine_Cost.MA_Machine_Cost_ID = ? " +
      "                 AND MA_Machine_Cost.MA_Machine_ID = ? " +
      "        AND MA_Machine_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Machine_Cost.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String maMachineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Machine_Cost" +
      "        WHERE MA_Machine_Cost.MA_Machine_Cost_ID = ? " +
      "                 AND MA_Machine_Cost.MA_Machine_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);

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
      "          FROM MA_Machine_Cost" +
      "         WHERE MA_Machine_Cost.MA_Machine_Cost_ID = ? ";

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
      "          FROM MA_Machine_Cost" +
      "         WHERE MA_Machine_Cost.MA_Machine_Cost_ID = ? ";

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

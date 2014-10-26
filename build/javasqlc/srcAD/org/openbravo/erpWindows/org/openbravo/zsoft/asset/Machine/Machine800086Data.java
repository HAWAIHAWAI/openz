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
class Machine800086Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Machine800086Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String maMachineId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String isinresourceplan;
  public String value;
  public String name;
  public String maMachineTypeId;
  public String maMachineTypeIdr;
  public String aAssetId;
  public String aAssetIdr;
  public String snrMasterdataId;
  public String snrMasterdataIdr;
  public String purchaseyear;
  public String assetvalueamt;
  public String weight;
  public String usecycle;
  public String ismovedinprojects;
  public String cColorId;
  public String cColorIdr;
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
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isinresourceplan"))
      return isinresourceplan;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ma_machine_type_id") || fieldName.equals("maMachineTypeId"))
      return maMachineTypeId;
    else if (fieldName.equalsIgnoreCase("ma_machine_type_idr") || fieldName.equals("maMachineTypeIdr"))
      return maMachineTypeIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_id") || fieldName.equals("snrMasterdataId"))
      return snrMasterdataId;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_idr") || fieldName.equals("snrMasterdataIdr"))
      return snrMasterdataIdr;
    else if (fieldName.equalsIgnoreCase("purchaseyear"))
      return purchaseyear;
    else if (fieldName.equalsIgnoreCase("assetvalueamt"))
      return assetvalueamt;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("usecycle"))
      return usecycle;
    else if (fieldName.equalsIgnoreCase("ismovedinprojects"))
      return ismovedinprojects;
    else if (fieldName.equalsIgnoreCase("c_color_id") || fieldName.equals("cColorId"))
      return cColorId;
    else if (fieldName.equalsIgnoreCase("c_color_idr") || fieldName.equals("cColorIdr"))
      return cColorIdr;
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
  public static Machine800086Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Machine800086Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_Machine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Machine.CreatedBy) as CreatedByR, " +
      "        to_char(MA_Machine.Updated, ?) as updated, " +
      "        to_char(MA_Machine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_Machine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_Machine.UpdatedBy) as UpdatedByR," +
      "        MA_Machine.MA_Machine_ID, " +
      "MA_Machine.AD_Client_ID, " +
      "(CASE WHEN MA_Machine.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "MA_Machine.AD_Org_ID, " +
      "(CASE WHEN MA_Machine.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(MA_Machine.IsActive, 'N') AS IsActive, " +
      "COALESCE(MA_Machine.Isinresourceplan, 'N') AS Isinresourceplan, " +
      "MA_Machine.Value, " +
      "MA_Machine.Name, " +
      "MA_Machine.MA_Machine_Type_ID, " +
      "(CASE WHEN MA_Machine.MA_Machine_Type_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Machine_Type_IDR, " +
      "MA_Machine.A_Asset_ID, " +
      "(CASE WHEN MA_Machine.A_Asset_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "MA_Machine.SNR_Masterdata_ID, " +
      "(CASE WHEN MA_Machine.SNR_Masterdata_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Serialnumber), ''))),'') ) END) AS SNR_Masterdata_IDR, " +
      "MA_Machine.Purchaseyear, " +
      "MA_Machine.Assetvalueamt, " +
      "MA_Machine.Weight, " +
      "MA_Machine.Usecycle, " +
      "COALESCE(MA_Machine.Ismovedinprojects, 'N') AS Ismovedinprojects, " +
      "MA_Machine.C_Color_ID, " +
      "(CASE WHEN MA_Machine.C_Color_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Color_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_Machine left join (select AD_Client_ID, Name from AD_Client) table1 on (MA_Machine.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (MA_Machine.AD_Org_ID = table2.AD_Org_ID) left join (select MA_Machine_Type_ID, Name from MA_Machine_Type) table3 on (MA_Machine.MA_Machine_Type_ID = table3.MA_Machine_Type_ID) left join (select A_Asset_ID, Name from A_Asset) table4 on (MA_Machine.A_Asset_ID =  table4.A_Asset_ID) left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table5 on (MA_Machine.SNR_Masterdata_ID = table5.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table6 on (table5.M_Product_ID = table6.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL6 on (table6.M_Product_ID = tableTRL6.M_Product_ID and tableTRL6.AD_Language = ?)  left join (select C_Color_ID, Name from C_Color) table7 on (MA_Machine.C_Color_ID = table7.C_Color_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND MA_Machine.MA_Machine_ID = ? " +
      "        AND MA_Machine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_Machine.AD_Org_ID IN (";
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
        Machine800086Data objectMachine800086Data = new Machine800086Data();
        objectMachine800086Data.created = UtilSql.getValue(result, "created");
        objectMachine800086Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMachine800086Data.updated = UtilSql.getValue(result, "updated");
        objectMachine800086Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMachine800086Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMachine800086Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMachine800086Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectMachine800086Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMachine800086Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectMachine800086Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMachine800086Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMachine800086Data.isactive = UtilSql.getValue(result, "isactive");
        objectMachine800086Data.isinresourceplan = UtilSql.getValue(result, "isinresourceplan");
        objectMachine800086Data.value = UtilSql.getValue(result, "value");
        objectMachine800086Data.name = UtilSql.getValue(result, "name");
        objectMachine800086Data.maMachineTypeId = UtilSql.getValue(result, "ma_machine_type_id");
        objectMachine800086Data.maMachineTypeIdr = UtilSql.getValue(result, "ma_machine_type_idr");
        objectMachine800086Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectMachine800086Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectMachine800086Data.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectMachine800086Data.snrMasterdataIdr = UtilSql.getValue(result, "snr_masterdata_idr");
        objectMachine800086Data.purchaseyear = UtilSql.getDateValue(result, "purchaseyear", "dd-MM-yyyy");
        objectMachine800086Data.assetvalueamt = UtilSql.getValue(result, "assetvalueamt");
        objectMachine800086Data.weight = UtilSql.getValue(result, "weight");
        objectMachine800086Data.usecycle = UtilSql.getValue(result, "usecycle");
        objectMachine800086Data.ismovedinprojects = UtilSql.getValue(result, "ismovedinprojects");
        objectMachine800086Data.cColorId = UtilSql.getValue(result, "c_color_id");
        objectMachine800086Data.cColorIdr = UtilSql.getValue(result, "c_color_idr");
        objectMachine800086Data.language = UtilSql.getValue(result, "language");
        objectMachine800086Data.adUserClient = "";
        objectMachine800086Data.adOrgClient = "";
        objectMachine800086Data.createdby = "";
        objectMachine800086Data.trBgcolor = "";
        objectMachine800086Data.totalCount = "";
        objectMachine800086Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMachine800086Data);
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
    Machine800086Data objectMachine800086Data[] = new Machine800086Data[vector.size()];
    vector.copyInto(objectMachine800086Data);
    return(objectMachine800086Data);
  }

/**
Create a registry
 */
  public static Machine800086Data[] set(String assetvalueamt, String isactive, String createdby, String createdbyr, String adOrgId, String name, String purchaseyear, String cColorId, String weight, String aAssetId, String isinresourceplan, String maMachineTypeId, String usecycle, String adClientId, String maMachineId, String ismovedinprojects, String updatedby, String updatedbyr, String snrMasterdataId, String value)    throws ServletException {
    Machine800086Data objectMachine800086Data[] = new Machine800086Data[1];
    objectMachine800086Data[0] = new Machine800086Data();
    objectMachine800086Data[0].created = "";
    objectMachine800086Data[0].createdbyr = createdbyr;
    objectMachine800086Data[0].updated = "";
    objectMachine800086Data[0].updatedTimeStamp = "";
    objectMachine800086Data[0].updatedby = updatedby;
    objectMachine800086Data[0].updatedbyr = updatedbyr;
    objectMachine800086Data[0].maMachineId = maMachineId;
    objectMachine800086Data[0].adClientId = adClientId;
    objectMachine800086Data[0].adClientIdr = "";
    objectMachine800086Data[0].adOrgId = adOrgId;
    objectMachine800086Data[0].adOrgIdr = "";
    objectMachine800086Data[0].isactive = isactive;
    objectMachine800086Data[0].isinresourceplan = isinresourceplan;
    objectMachine800086Data[0].value = value;
    objectMachine800086Data[0].name = name;
    objectMachine800086Data[0].maMachineTypeId = maMachineTypeId;
    objectMachine800086Data[0].maMachineTypeIdr = "";
    objectMachine800086Data[0].aAssetId = aAssetId;
    objectMachine800086Data[0].aAssetIdr = "";
    objectMachine800086Data[0].snrMasterdataId = snrMasterdataId;
    objectMachine800086Data[0].snrMasterdataIdr = "";
    objectMachine800086Data[0].purchaseyear = purchaseyear;
    objectMachine800086Data[0].assetvalueamt = assetvalueamt;
    objectMachine800086Data[0].weight = weight;
    objectMachine800086Data[0].usecycle = usecycle;
    objectMachine800086Data[0].ismovedinprojects = ismovedinprojects;
    objectMachine800086Data[0].cColorId = cColorId;
    objectMachine800086Data[0].cColorIdr = "";
    objectMachine800086Data[0].language = "";
    return objectMachine800086Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef801205_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef801207_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE MA_Machine" +
      "        SET MA_Machine_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , IsActive = (?) , Isinresourceplan = (?) , Value = (?) , Name = (?) , MA_Machine_Type_ID = (?) , A_Asset_ID = (?) , SNR_Masterdata_ID = (?) , Purchaseyear = TO_DATE(?) , Assetvalueamt = TO_NUMBER(?) , Weight = TO_NUMBER(?) , Usecycle = TO_NUMBER(?) , Ismovedinprojects = (?) , C_Color_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_Machine.MA_Machine_ID = ? " +
      "        AND MA_Machine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Machine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinresourceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchaseyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usecycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismovedinprojects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cColorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
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
      "        INSERT INTO MA_Machine " +
      "        (MA_Machine_ID, AD_Client_ID, AD_Org_ID, IsActive, Isinresourceplan, Value, Name, MA_Machine_Type_ID, A_Asset_ID, SNR_Masterdata_ID, Purchaseyear, Assetvalueamt, Weight, Usecycle, Ismovedinprojects, C_Color_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinresourceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchaseyear);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, assetvalueamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usecycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismovedinprojects);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cColorId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Machine" +
      "        WHERE MA_Machine.MA_Machine_ID = ? " +
      "        AND MA_Machine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_Machine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_Machine" +
      "        WHERE MA_Machine.MA_Machine_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
      "          FROM MA_Machine" +
      "         WHERE MA_Machine.MA_Machine_ID = ? ";

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
      "          FROM MA_Machine" +
      "         WHERE MA_Machine.MA_Machine_ID = ? ";

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

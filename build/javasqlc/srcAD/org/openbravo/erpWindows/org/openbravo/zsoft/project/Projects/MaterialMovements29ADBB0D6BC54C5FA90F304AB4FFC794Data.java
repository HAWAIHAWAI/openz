//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;

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
class MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data implements FieldProvider {
static Logger log4j = Logger.getLogger(MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String mProductId;
  public String mProductIdr;
  public String movementqty;
  public String quantity;
  public String movementdate;
  public String description;
  public String mLocatorId;
  public String mLocatorIdr;
  public String mInternalConsumptionId;
  public String mInternalConsumptionIdr;
  public String isactive;
  public String zspmMaterialmovementsViewId;
  public String adClientId;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_id") || fieldName.equals("mInternalConsumptionId"))
      return mInternalConsumptionId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_idr") || fieldName.equals("mInternalConsumptionIdr"))
      return mInternalConsumptionIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zspm_materialmovements_view_id") || fieldName.equals("zspmMaterialmovementsViewId"))
      return zspmMaterialmovementsViewId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjecttaskId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_materialmovements_view.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_materialmovements_view.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_materialmovements_view.Updated, ?) as updated, " +
      "        to_char(zspm_materialmovements_view.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_materialmovements_view.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_materialmovements_view.UpdatedBy) as UpdatedByR," +
      "        zspm_materialmovements_view.C_Projecttask_ID, " +
      "(CASE WHEN zspm_materialmovements_view.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_materialmovements_view.M_Product_ID, " +
      "(CASE WHEN zspm_materialmovements_view.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zspm_materialmovements_view.Movementqty, " +
      "zspm_materialmovements_view.Quantity, " +
      "zspm_materialmovements_view.Movementdate, " +
      "zspm_materialmovements_view.Description, " +
      "zspm_materialmovements_view.M_Locator_ID, " +
      "(CASE WHEN zspm_materialmovements_view.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "zspm_materialmovements_view.M_Internal_Consumption_ID, " +
      "(CASE WHEN zspm_materialmovements_view.M_Internal_Consumption_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_Internal_Consumption_IDR, " +
      "COALESCE(zspm_materialmovements_view.Isactive, 'N') AS Isactive, " +
      "zspm_materialmovements_view.Zspm_Materialmovements_View_ID, " +
      "zspm_materialmovements_view.AD_Client_ID, " +
      "zspm_materialmovements_view.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_materialmovements_view left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (zspm_materialmovements_view.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (zspm_materialmovements_view.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select M_Locator_ID, Value from M_Locator) table4 on (zspm_materialmovements_view.M_Locator_ID = table4.M_Locator_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table5 on (zspm_materialmovements_view.M_Internal_Consumption_ID = table5.M_Internal_Consumption_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjecttaskId==null || cProjecttaskId.equals(""))?"":"  AND zspm_materialmovements_view.C_Projecttask_ID = ?  ");
    strSql = strSql + 
      "        AND zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? " +
      "        AND zspm_materialmovements_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_materialmovements_view.AD_Org_ID IN (";
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
      if (cProjecttaskId != null && !(cProjecttaskId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
        MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data = new MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data();
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.created = UtilSql.getValue(result, "created");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.updated = UtilSql.getValue(result, "updated");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.movementqty = UtilSql.getValue(result, "movementqty");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.quantity = UtilSql.getValue(result, "quantity");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.description = UtilSql.getValue(result, "description");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.mInternalConsumptionId = UtilSql.getValue(result, "m_internal_consumption_id");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.mInternalConsumptionIdr = UtilSql.getValue(result, "m_internal_consumption_idr");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.isactive = UtilSql.getValue(result, "isactive");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.zspmMaterialmovementsViewId = UtilSql.getValue(result, "zspm_materialmovements_view_id");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.language = UtilSql.getValue(result, "language");
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.adUserClient = "";
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.adOrgClient = "";
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.createdby = "";
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.trBgcolor = "";
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.totalCount = "";
        objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data);
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
    MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[] = new MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[vector.size()];
    vector.copyInto(objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data);
    return(objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data);
  }

/**
Create a registry
 */
  public static MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[] set(String cProjecttaskId, String createdby, String createdbyr, String adClientId, String mLocatorId, String mLocatorIdr, String adOrgId, String movementdate, String movementqty, String mInternalConsumptionId, String mProductId, String mProductIdr, String updatedby, String updatedbyr, String quantity, String isactive, String description, String zspmMaterialmovementsViewId)    throws ServletException {
    MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[] = new MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[1];
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0] = new MaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data();
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].created = "";
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].createdbyr = createdbyr;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].updated = "";
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].updatedTimeStamp = "";
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].updatedby = updatedby;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].updatedbyr = updatedbyr;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].cProjecttaskId = cProjecttaskId;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].cProjecttaskIdr = "";
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].mProductId = mProductId;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].mProductIdr = mProductIdr;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].movementqty = movementqty;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].quantity = quantity;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].movementdate = movementdate;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].description = description;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].mLocatorId = mLocatorId;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].mLocatorIdr = mLocatorIdr;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].mInternalConsumptionId = mInternalConsumptionId;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].mInternalConsumptionIdr = "";
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].isactive = isactive;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].zspmMaterialmovementsViewId = zspmMaterialmovementsViewId;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].adClientId = adClientId;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].adOrgId = adOrgId;
    objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data[0].language = "";
    return objectMaterialMovements29ADBB0D6BC54C5FA90F304AB4FFC794Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8B6E18287CAD4A7C99906D40E34EB8FF_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefEC9210DF81754D308A9EC6A5DF6A6FFC_1(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as M_Locator_ID FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_locator_id");
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
  public static String selectDef48D06B95772A4CF7AE85F32AEED21537_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
  public static String selectDefD3B1A3C6F2514E9D80B290D4C2E87865_3(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zspm_materialmovements_view.C_Projecttask_ID AS NAME" +
      "        FROM zspm_materialmovements_view" +
      "        WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "        UPDATE zspm_materialmovements_view" +
      "        SET C_Projecttask_ID = (?) , M_Product_ID = (?) , Movementqty = TO_NUMBER(?) , Quantity = TO_NUMBER(?) , Movementdate = TO_DATE(?) , Description = (?) , M_Locator_ID = (?) , M_Internal_Consumption_ID = (?) , Isactive = (?) , Zspm_Materialmovements_View_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? " +
      "                 AND zspm_materialmovements_view.C_Projecttask_ID = ? " +
      "        AND zspm_materialmovements_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_materialmovements_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmMaterialmovementsViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmMaterialmovementsViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
      "        INSERT INTO zspm_materialmovements_view " +
      "        (C_Projecttask_ID, M_Product_ID, Movementqty, Quantity, Movementdate, Description, M_Locator_ID, M_Internal_Consumption_ID, Isactive, Zspm_Materialmovements_View_ID, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmMaterialmovementsViewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjecttaskId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_materialmovements_view" +
      "        WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? " +
      "                 AND zspm_materialmovements_view.C_Projecttask_ID = ? " +
      "        AND zspm_materialmovements_view.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_materialmovements_view.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_materialmovements_view" +
      "        WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? " +
      "                 AND zspm_materialmovements_view.C_Projecttask_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "          FROM zspm_materialmovements_view" +
      "         WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? ";

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
      "          FROM zspm_materialmovements_view" +
      "         WHERE zspm_materialmovements_view.Zspm_Materialmovements_View_ID = ? ";

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

//Sqlc generated V1.O00-1
package org.openz.pdc.controller;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class PdcMaterialReturnData implements FieldProvider {
static Logger log4j = Logger.getLogger(PdcMaterialReturnData.class);
  private String InitRecordNumber="0";
  public String pdcmaterialreturnproduct;
  public String pdcmaterialreturnlocator;
  public String pdcmaterialreturnplannedqty;
  public String pdcmaterialreturnreceivedqty;
  public String pdcmaterialreturnavailableqty;
  public String pdcWorkstepbomVId;
  public String mInternalConsumptionlineId;
  public String barcode;
  public String type;
  public String id;
  public String mess;
  public String adMessageValue;
  public String serialnumber;
  public String lotnumber;
  public String mProductId;
  public String mLocatorId;
  public String line;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pdcmaterialreturnproduct"))
      return pdcmaterialreturnproduct;
    else if (fieldName.equalsIgnoreCase("pdcmaterialreturnlocator"))
      return pdcmaterialreturnlocator;
    else if (fieldName.equalsIgnoreCase("pdcmaterialreturnplannedqty"))
      return pdcmaterialreturnplannedqty;
    else if (fieldName.equalsIgnoreCase("pdcmaterialreturnreceivedqty"))
      return pdcmaterialreturnreceivedqty;
    else if (fieldName.equalsIgnoreCase("pdcmaterialreturnavailableqty"))
      return pdcmaterialreturnavailableqty;
    else if (fieldName.equalsIgnoreCase("pdc_workstepbom_v_id") || fieldName.equals("pdcWorkstepbomVId"))
      return pdcWorkstepbomVId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumptionline_id") || fieldName.equals("mInternalConsumptionlineId"))
      return mInternalConsumptionlineId;
    else if (fieldName.equalsIgnoreCase("barcode"))
      return barcode;
    else if (fieldName.equalsIgnoreCase("type"))
      return type;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("mess"))
      return mess;
    else if (fieldName.equalsIgnoreCase("ad_message_value") || fieldName.equals("adMessageValue"))
      return adMessageValue;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("lotnumber"))
      return lotnumber;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PdcMaterialReturnData[] initialize(ConnectionProvider connectionProvider)    throws ServletException {
    return initialize(connectionProvider, 0, 0);
  }

  public static PdcMaterialReturnData[] initialize(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select " +
      "            -- selectupper" +
      "            '' as pdcmaterialreturnproduct," +
      "            '' as pdcmaterialreturnlocator," +
      "            '' as pdcmaterialreturnplannedqty," +
      "            '' as pdcmaterialreturnreceivedqty, " +
      "            '' as pdcmaterialreturnavailableqty," +
      "            '' as pdc_workstepbom_v_id," +
      "            -- selectlower              " +
      "            '' as m_internal_consumptionline_id," +
      "            -- selectbarcode" +
      "            '' as barcode," +
      "            '' as type," +
      "            '' as id," +
      "            '' as mess," +
      "            '' as ad_message_value," +
      "            '' as serialnumber," +
      "            '' as lotnumber," +
      "            '' as m_product_id," +
      "            '' as m_locator_id," +
      "            '' as line";

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
        PdcMaterialReturnData objectPdcMaterialReturnData = new PdcMaterialReturnData();
        objectPdcMaterialReturnData.pdcmaterialreturnproduct = UtilSql.getValue(result, "pdcmaterialreturnproduct");
        objectPdcMaterialReturnData.pdcmaterialreturnlocator = UtilSql.getValue(result, "pdcmaterialreturnlocator");
        objectPdcMaterialReturnData.pdcmaterialreturnplannedqty = UtilSql.getValue(result, "pdcmaterialreturnplannedqty");
        objectPdcMaterialReturnData.pdcmaterialreturnreceivedqty = UtilSql.getValue(result, "pdcmaterialreturnreceivedqty");
        objectPdcMaterialReturnData.pdcmaterialreturnavailableqty = UtilSql.getValue(result, "pdcmaterialreturnavailableqty");
        objectPdcMaterialReturnData.pdcWorkstepbomVId = UtilSql.getValue(result, "pdc_workstepbom_v_id");
        objectPdcMaterialReturnData.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectPdcMaterialReturnData.barcode = UtilSql.getValue(result, "barcode");
        objectPdcMaterialReturnData.type = UtilSql.getValue(result, "type");
        objectPdcMaterialReturnData.id = UtilSql.getValue(result, "id");
        objectPdcMaterialReturnData.mess = UtilSql.getValue(result, "mess");
        objectPdcMaterialReturnData.adMessageValue = UtilSql.getValue(result, "ad_message_value");
        objectPdcMaterialReturnData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectPdcMaterialReturnData.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectPdcMaterialReturnData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectPdcMaterialReturnData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectPdcMaterialReturnData.line = UtilSql.getValue(result, "line");
        objectPdcMaterialReturnData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPdcMaterialReturnData);
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
    PdcMaterialReturnData objectPdcMaterialReturnData[] = new PdcMaterialReturnData[vector.size()];
    vector.copyInto(objectPdcMaterialReturnData);
    return(objectPdcMaterialReturnData);
  }

  public static PdcMaterialReturnData[] selectupper(ConnectionProvider connectionProvider, String language, String pconsumptionid, String workstepid)    throws ServletException {
    return selectupper(connectionProvider, language, pconsumptionid, workstepid, 0, 0);
  }

  public static PdcMaterialReturnData[] selectupper(ConnectionProvider connectionProvider, String language, String pconsumptionid, String workstepid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select" +
      "            zssi_getproductnamewithvalue(pdc_workstepbom_v.m_product_id, ?) as pdcmaterialreturnproduct," +
      "                m_locator.value as pdcmaterialreturnlocator," +
      "                qtyrequired as pdcmaterialreturnplannedqty," +
      "                qtyreceived - coalesce((select sum(m_internal_consumptionline.movementqty)), 0) as pdcmaterialreturnreceivedqty," +
      "                qty_available as pdcmaterialreturnavailableqty," +
      "                pdc_workstepbom_v_id,pdc_workstepbom_v.m_product_id,m_locator.m_locator_id, pdc_workstepbom_v.line" +
      "        from" +
      "            pdc_workstepbom_v" +
      "        left join m_locator on " +
      "            coalesce(pdc_workstepbom_v.issuing_locator,pdc_workstepbom_v.m_locator_id) = m_locator.m_locator_id" +
      "        left join m_internal_consumptionline on" +
      "            m_internal_consumptionline.m_internal_consumption_id = ? and" +
      "            m_internal_consumptionline.m_product_id = pdc_workstepbom_v.m_product_id" +
      "        where " +
      "            pdc_workstepbom_v.zssm_workstep_v_id = ?" +
      "        group by" +
      "            pdc_workstepbom_v.line," +
      "            pdc_workstepbom_v.m_product_id," +
      "            m_locator.value," +
      "            m_locator.m_locator_id," +
      "            qtyrequired," +
      "            qtyreceived," +
      "            qty_available," +
      "            pdc_workstepbom_v_id" +
      "        having qtyreceived - coalesce((select sum(m_internal_consumptionline.movementqty)), 0) > 0" +
      "        order by  pdc_workstepbom_v.line;";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepid);

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
        PdcMaterialReturnData objectPdcMaterialReturnData = new PdcMaterialReturnData();
        objectPdcMaterialReturnData.pdcmaterialreturnproduct = UtilSql.getValue(result, "pdcmaterialreturnproduct");
        objectPdcMaterialReturnData.pdcmaterialreturnlocator = UtilSql.getValue(result, "pdcmaterialreturnlocator");
        objectPdcMaterialReturnData.pdcmaterialreturnplannedqty = UtilSql.getValue(result, "pdcmaterialreturnplannedqty");
        objectPdcMaterialReturnData.pdcmaterialreturnreceivedqty = UtilSql.getValue(result, "pdcmaterialreturnreceivedqty");
        objectPdcMaterialReturnData.pdcmaterialreturnavailableqty = UtilSql.getValue(result, "pdcmaterialreturnavailableqty");
        objectPdcMaterialReturnData.pdcWorkstepbomVId = UtilSql.getValue(result, "pdc_workstepbom_v_id");
        objectPdcMaterialReturnData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectPdcMaterialReturnData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectPdcMaterialReturnData.line = UtilSql.getValue(result, "line");
        objectPdcMaterialReturnData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPdcMaterialReturnData);
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
    PdcMaterialReturnData objectPdcMaterialReturnData[] = new PdcMaterialReturnData[vector.size()];
    vector.copyInto(objectPdcMaterialReturnData);
    return(objectPdcMaterialReturnData);
  }

  public static PdcMaterialReturnData[] selectlower(ConnectionProvider connectionProvider, String language, String pconsumptionid)    throws ServletException {
    return selectlower(connectionProvider, language, pconsumptionid, 0, 0);
  }

  public static PdcMaterialReturnData[] selectlower(ConnectionProvider connectionProvider, String language, String pconsumptionid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    Select f.m_internal_consumptionline_id,zssi_getproductnamewithvalue(f.m_product_id,?) AS pdcmaterialreturnproduct," +
      "         l.value as pdcmaterialreturnlocator,f.movementqty as pdcmaterialreturnreceivedqty," +
      "           snr.serialnumber,snr.lotnumber" +
      "           from m_internal_consumptionline f left join  m_locator l on  f.m_locator_id=l.m_locator_id" +
      "                                             left join snr_internal_consumptionline snr on f.m_internal_consumptionline_id=snr.m_internal_consumptionline_id" +
      "           where f.m_internal_consumption_id=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);

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
        PdcMaterialReturnData objectPdcMaterialReturnData = new PdcMaterialReturnData();
        objectPdcMaterialReturnData.mInternalConsumptionlineId = UtilSql.getValue(result, "m_internal_consumptionline_id");
        objectPdcMaterialReturnData.pdcmaterialreturnproduct = UtilSql.getValue(result, "pdcmaterialreturnproduct");
        objectPdcMaterialReturnData.pdcmaterialreturnlocator = UtilSql.getValue(result, "pdcmaterialreturnlocator");
        objectPdcMaterialReturnData.pdcmaterialreturnreceivedqty = UtilSql.getValue(result, "pdcmaterialreturnreceivedqty");
        objectPdcMaterialReturnData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectPdcMaterialReturnData.lotnumber = UtilSql.getValue(result, "lotnumber");
        objectPdcMaterialReturnData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPdcMaterialReturnData);
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
    PdcMaterialReturnData objectPdcMaterialReturnData[] = new PdcMaterialReturnData[vector.size()];
    vector.copyInto(objectPdcMaterialReturnData);
    return(objectPdcMaterialReturnData);
  }

/**
Initializes a D- (Internal Consumption) Transaction
 */
  public static int insertConsumption(Connection conn, ConnectionProvider connectionProvider, String uuId, String adClientId, String adOrgId, String user, String cProjectId, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        insert into M_INTERNAL_CONSUMPTION(" +
      "            M_INTERNAL_CONSUMPTION_ID," +
      "            AD_CLIENT_ID," +
      "            AD_ORG_ID," +
      "            CREATED," +
      "            CREATEDBY," +
      "            UPDATED," +
      "            UPDATEDBY," +
      "            NAME," +
      "            DESCRIPTION," +
      "            MOVEMENTDATE, " +
      "            C_PROJECT_ID," +
      "            C_PROJECTTASK_ID," +
      "            MOVEMENTTYPE," +
      "            DOCUMENTNO," +
      "            DATEACCT)" +
      "        values(" +
      "            ?," +
      "            ?," +
      "            ?," +
      "            NOW()," +
      "            ?," +
      "            NOW()," +
      "            ?," +
      "            'Production-Process'," +
      "            'Generated by PDC -> Return Material to Stock'," +
      "            now()," +
      "            ?," +
      "            ?," +
      "            'D+'," +
      "            ad_sequence_doc('Production',?,'Y')," +
      "            trunc(now()))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uuId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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

  public static String getQty(ConnectionProvider connectionProvider, String pconsumptionid, String workstepid, String mProductId, String mLocatorId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT sum(qtyreceived - coalesce(movementqty, 0))" +
      "        from" +
      "            pdc_workstepbom_v" +
      "            left join m_internal_consumptionline on" +
      "            m_internal_consumptionline.m_internal_consumption_id = ? and" +
      "            m_internal_consumptionline.m_product_id = pdc_workstepbom_v.m_product_id" +
      "        where " +
      "            pdc_workstepbom_v.zssm_workstep_v_id = ? and" +
      "            pdc_workstepbom_v.m_product_id = ? and" +
      "            coalesce(pdc_workstepbom_v.receiving_locator,'')= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "sum");
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

  public static String getLocatorReturn(ConnectionProvider connectionProvider, String pconsumptionid, String workstepid, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(issuing_locator,pdc_workstepbom_v.m_locator_id) as issuing_locator" +
      "        from" +
      "            pdc_workstepbom_v" +
      "            left join m_internal_consumptionline on" +
      "            m_internal_consumptionline.m_internal_consumption_id = ? and" +
      "            m_internal_consumptionline.m_product_id = pdc_workstepbom_v.m_product_id" +
      "        where " +
      "            pdc_workstepbom_v.zssm_workstep_v_id = ? and" +
      "            pdc_workstepbom_v.m_product_id = ? " +
      "        group by" +
      "            pdc_workstepbom_v.m_product_id," +
      "            qtyrequired," +
      "            qtyreceived," +
      "            qty_available," +
      "            issuing_locator,pdc_workstepbom_v.m_locator_id," +
      "            pdc_workstepbom_v_id limit 1 ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pconsumptionid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstepid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "issuing_locator");
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

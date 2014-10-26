//Sqlc generated V1.O00-1
package org.openz.internallogistic;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class InternalLogisticData implements FieldProvider {
static Logger log4j = Logger.getLogger(InternalLogisticData.class);
  private String InitRecordNumber="0";
  public String pdcmaterialconsumptionavailableqty;
  public String pdcmaterialconsumptionproduct;
  public String pdcmaterialconsumptionlocator;
  public String pdcmaterialconsumptionreceivedqty;
  public String identifier;
  public String snrMasterdataId;
  public String product;
  public String username;
  public String locatorFrom;
  public String locatorTo;
  public String serialnumber;
  public String shipperinfo;
  public String vendorinfo;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pdcmaterialconsumptionavailableqty"))
      return pdcmaterialconsumptionavailableqty;
    else if (fieldName.equalsIgnoreCase("pdcmaterialconsumptionproduct"))
      return pdcmaterialconsumptionproduct;
    else if (fieldName.equalsIgnoreCase("pdcmaterialconsumptionlocator"))
      return pdcmaterialconsumptionlocator;
    else if (fieldName.equalsIgnoreCase("pdcmaterialconsumptionreceivedqty"))
      return pdcmaterialconsumptionreceivedqty;
    else if (fieldName.equalsIgnoreCase("identifier"))
      return identifier;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_id") || fieldName.equals("snrMasterdataId"))
      return snrMasterdataId;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("username"))
      return username;
    else if (fieldName.equalsIgnoreCase("locator_from") || fieldName.equals("locatorFrom"))
      return locatorFrom;
    else if (fieldName.equalsIgnoreCase("locator_to") || fieldName.equals("locatorTo"))
      return locatorTo;
    else if (fieldName.equalsIgnoreCase("serialnumber"))
      return serialnumber;
    else if (fieldName.equalsIgnoreCase("shipperinfo"))
      return shipperinfo;
    else if (fieldName.equalsIgnoreCase("vendorinfo"))
      return vendorinfo;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InternalLogisticData[] selectupperOutbound(ConnectionProvider connectionProvider, String language, String workstep, String internalconsumptionid)    throws ServletException {
    return selectupperOutbound(connectionProvider, language, workstep, internalconsumptionid, 0, 0);
  }

  public static InternalLogisticData[] selectupperOutbound(ConnectionProvider connectionProvider, String language, String workstep, String internalconsumptionid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    Select '' as pdcmaterialconsumptionavailableqty,'' as pdcmaterialconsumptionproduct,'' as pdcmaterialconsumptionlocator," +
      "	    '' as pdcmaterialconsumptionreceivedqty,'' as identifier," +
      "	    v.snr_masterdata_id, zssi_getproductname(v.m_product_id,?) as product,v.username,v.locator_from,v.locator_to," +
      "	    v.serialnumber,v.shipperinfo,v.vendorinfo" +
      "	    from ils_internaltransport_v v" +
      "	    where workstepid= ? and not exists (select 0 from snr_internal_consumptionline s,m_internal_consumptionline l" +
      "	                                        where l.m_internal_consumptionline_id=s.m_internal_consumptionline_id and" +
      "	                                              l.m_internal_consumption_id=? and v.serialnumber=s.serialnumber and v.workstepid=l.c_projecttask_id) ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalconsumptionid);

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
        InternalLogisticData objectInternalLogisticData = new InternalLogisticData();
        objectInternalLogisticData.pdcmaterialconsumptionavailableqty = UtilSql.getValue(result, "pdcmaterialconsumptionavailableqty");
        objectInternalLogisticData.pdcmaterialconsumptionproduct = UtilSql.getValue(result, "pdcmaterialconsumptionproduct");
        objectInternalLogisticData.pdcmaterialconsumptionlocator = UtilSql.getValue(result, "pdcmaterialconsumptionlocator");
        objectInternalLogisticData.pdcmaterialconsumptionreceivedqty = UtilSql.getValue(result, "pdcmaterialconsumptionreceivedqty");
        objectInternalLogisticData.identifier = UtilSql.getValue(result, "identifier");
        objectInternalLogisticData.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectInternalLogisticData.product = UtilSql.getValue(result, "product");
        objectInternalLogisticData.username = UtilSql.getValue(result, "username");
        objectInternalLogisticData.locatorFrom = UtilSql.getValue(result, "locator_from");
        objectInternalLogisticData.locatorTo = UtilSql.getValue(result, "locator_to");
        objectInternalLogisticData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectInternalLogisticData.shipperinfo = UtilSql.getValue(result, "shipperinfo");
        objectInternalLogisticData.vendorinfo = UtilSql.getValue(result, "vendorinfo");
        objectInternalLogisticData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInternalLogisticData);
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
    InternalLogisticData objectInternalLogisticData[] = new InternalLogisticData[vector.size()];
    vector.copyInto(objectInternalLogisticData);
    return(objectInternalLogisticData);
  }

  public static InternalLogisticData[] selectlowerOutbound(ConnectionProvider connectionProvider, String language, String workstep, String consumption)    throws ServletException {
    return selectlowerOutbound(connectionProvider, language, workstep, consumption, 0, 0);
  }

  public static InternalLogisticData[] selectlowerOutbound(ConnectionProvider connectionProvider, String language, String workstep, String consumption, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    Select s.snr_internal_consumptionline_id as snr_masterdata_id, zssi_getproductname(l.m_product_id,?) as product,zssi_getusername (snrm.ad_user_id) as username," +
      "	    (select value from m_locator where m_locator_id=pt.receiving_locator) as locator_from," +
      "        (select value from m_locator where m_locator_id=pt.issuing_locator) as locator_to," +
      "	    snrm.serialnumber," +
      "	    ils_getshipperfromvendormovement(snrm.serialnumber) as shipperinfo," +
      "	    ils_getdescriptionfromvendormovement(snrm.serialnumber) as vendorinfo" +
      "	    from snr_masterdata snrm,snr_internal_consumptionline s,m_internal_consumptionline l,m_internal_consumption c,c_projecttask pt" +
      "	    where snrm.serialnumber=s.serialnumber and" +
      "	          l.m_internal_consumptionline_id=s.m_internal_consumptionline_id and" +
      "	          l.m_internal_consumption_id=c.m_internal_consumption_id and" +
      "	          l.c_projecttask_id=pt.c_projecttask_id and" +
      "	    pt.c_projecttask_id= ? and c.m_internal_consumption_id=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumption);

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
        InternalLogisticData objectInternalLogisticData = new InternalLogisticData();
        objectInternalLogisticData.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectInternalLogisticData.product = UtilSql.getValue(result, "product");
        objectInternalLogisticData.username = UtilSql.getValue(result, "username");
        objectInternalLogisticData.locatorFrom = UtilSql.getValue(result, "locator_from");
        objectInternalLogisticData.locatorTo = UtilSql.getValue(result, "locator_to");
        objectInternalLogisticData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectInternalLogisticData.shipperinfo = UtilSql.getValue(result, "shipperinfo");
        objectInternalLogisticData.vendorinfo = UtilSql.getValue(result, "vendorinfo");
        objectInternalLogisticData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInternalLogisticData);
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
    InternalLogisticData objectInternalLogisticData[] = new InternalLogisticData[vector.size()];
    vector.copyInto(objectInternalLogisticData);
    return(objectInternalLogisticData);
  }

  public static InternalLogisticData[] selectupperInbound(ConnectionProvider connectionProvider, String language, String workstep, String transportuserid, String internalconsumptionid)    throws ServletException {
    return selectupperInbound(connectionProvider, language, workstep, transportuserid, internalconsumptionid, 0, 0);
  }

  public static InternalLogisticData[] selectupperInbound(ConnectionProvider connectionProvider, String language, String workstep, String transportuserid, String internalconsumptionid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    Select snr.snr_masterdata_id, zssi_getproductname(snr.m_product_id,?) as product,zssi_getusername (snr.ad_user_id) as username,l1.value as locator_from,l2.value as locator_to," +
      "	    snr.serialnumber,ils_getshipperfromvendormovement(snr.serialnumber) as shipperinfo,ils_getdescriptionfromvendormovement(snr.serialnumber) as vendorinfo" +
      "	    from snr_masterdata snr, c_projecttask p, m_locator l1,m_locator l2,m_internal_consumptionline icl" +
      "	    where p.c_projecttask_id= ? " +
      "	    and snr.c_projecttask_id=p.c_projecttask_id " +
      "	    and l1.m_locator_id=p.receiving_locator " +
      "	    and l2.m_locator_id=p.issuing_locator" +
      "	    and snr.m_internal_consumptionline_id=icl.m_internal_consumptionline_id" +
      "	    and icl.updatedby= ? " +
      "	    and not exists (select 0 from snr_internal_consumptionline s,m_internal_consumptionline l" +
      "	                                        where l.m_internal_consumptionline_id=s.m_internal_consumptionline_id and" +
      "	                                              l.m_internal_consumption_id=? and snr.serialnumber=s.serialnumber and snr.c_projecttask_id=l.c_projecttask_id)   ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transportuserid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalconsumptionid);

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
        InternalLogisticData objectInternalLogisticData = new InternalLogisticData();
        objectInternalLogisticData.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectInternalLogisticData.product = UtilSql.getValue(result, "product");
        objectInternalLogisticData.username = UtilSql.getValue(result, "username");
        objectInternalLogisticData.locatorFrom = UtilSql.getValue(result, "locator_from");
        objectInternalLogisticData.locatorTo = UtilSql.getValue(result, "locator_to");
        objectInternalLogisticData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectInternalLogisticData.shipperinfo = UtilSql.getValue(result, "shipperinfo");
        objectInternalLogisticData.vendorinfo = UtilSql.getValue(result, "vendorinfo");
        objectInternalLogisticData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInternalLogisticData);
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
    InternalLogisticData objectInternalLogisticData[] = new InternalLogisticData[vector.size()];
    vector.copyInto(objectInternalLogisticData);
    return(objectInternalLogisticData);
  }

  public static InternalLogisticData[] selectlowerInbound(ConnectionProvider connectionProvider, String language, String workstep, String consumption)    throws ServletException {
    return selectlowerInbound(connectionProvider, language, workstep, consumption, 0, 0);
  }

  public static InternalLogisticData[] selectlowerInbound(ConnectionProvider connectionProvider, String language, String workstep, String consumption, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    Select snrm.snr_masterdata_id, zssi_getproductname(l.m_product_id,?) as product,zssi_getusername(snrm.ad_user_id) as username,l1.value as locator_from,l2.value as locator_to," +
      "	    s.serialnumber,ils_getshipperfromvendormovement(snrm.serialnumber) as shipperinfo,ils_getdescriptionfromvendormovement(snrm.serialnumber) as vendorinfo" +
      "	    from snr_internal_consumptionline s,m_internal_consumptionline l,m_internal_consumption c,snr_masterdata snrm,m_locator l1,m_locator l2,c_projecttask p" +
      "	    where l.m_internal_consumptionline_id=s.m_internal_consumptionline_id and" +
      "	          l.m_internal_consumption_id=c.m_internal_consumption_id and" +
      "	          p.issuing_locator=l2.m_locator_id and p.receiving_locator = l1.m_locator_id and" +
      "	          p.c_projecttask_id=l.c_projecttask_id and" +
      "	          snrm.serialnumber=s.serialnumber and" +
      "	          p.c_projecttask_id= ? and" +
      "	          c.m_internal_consumption_id=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, workstep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumption);

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
        InternalLogisticData objectInternalLogisticData = new InternalLogisticData();
        objectInternalLogisticData.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectInternalLogisticData.product = UtilSql.getValue(result, "product");
        objectInternalLogisticData.username = UtilSql.getValue(result, "username");
        objectInternalLogisticData.locatorFrom = UtilSql.getValue(result, "locator_from");
        objectInternalLogisticData.locatorTo = UtilSql.getValue(result, "locator_to");
        objectInternalLogisticData.serialnumber = UtilSql.getValue(result, "serialnumber");
        objectInternalLogisticData.shipperinfo = UtilSql.getValue(result, "shipperinfo");
        objectInternalLogisticData.vendorinfo = UtilSql.getValue(result, "vendorinfo");
        objectInternalLogisticData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInternalLogisticData);
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
    InternalLogisticData objectInternalLogisticData[] = new InternalLogisticData[vector.size()];
    vector.copyInto(objectInternalLogisticData);
    return(objectInternalLogisticData);
  }

  public static InternalLogisticData[] selectupperConsumptionfromLocator(ConnectionProvider connectionProvider, String language, String consumption, String locator)    throws ServletException {
    return selectupperConsumptionfromLocator(connectionProvider, language, consumption, locator, 0, 0);
  }

  public static InternalLogisticData[] selectupperConsumptionfromLocator(ConnectionProvider connectionProvider, String language, String consumption, String locator, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  zssi_getproductname(sd.m_product_id,?) as pdcmaterialconsumptionproduct," +
      "                l.value as pdcmaterialconsumptionlocator, " +
      "                sd.qtyonhand-coalesce(co.movementqty,0) as pdcmaterialconsumptionavailableqty," +
      "                sd.m_storage_detail_id as snr_masterdata_id" +
      "        FROM m_storage_detail sd" +
      "             left join m_internal_consumptionline co on co.m_product_id=sd.m_product_id and co.m_internal_consumption_id=?" +
      "             ,m_locator l " +
      "             where l.m_locator_id=sd.m_locator_id and" +
      "                sd.m_locator_id = ? and sd.qtyonhand>0" +
      "             order by pdcmaterialconsumptionproduct";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locator);

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
        InternalLogisticData objectInternalLogisticData = new InternalLogisticData();
        objectInternalLogisticData.pdcmaterialconsumptionproduct = UtilSql.getValue(result, "pdcmaterialconsumptionproduct");
        objectInternalLogisticData.pdcmaterialconsumptionlocator = UtilSql.getValue(result, "pdcmaterialconsumptionlocator");
        objectInternalLogisticData.pdcmaterialconsumptionavailableqty = UtilSql.getValue(result, "pdcmaterialconsumptionavailableqty");
        objectInternalLogisticData.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectInternalLogisticData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInternalLogisticData);
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
    InternalLogisticData objectInternalLogisticData[] = new InternalLogisticData[vector.size()];
    vector.copyInto(objectInternalLogisticData);
    return(objectInternalLogisticData);
  }

  public static InternalLogisticData[] selectupperConsumption4User(ConnectionProvider connectionProvider, String language, String user, String consumption)    throws ServletException {
    return selectupperConsumption4User(connectionProvider, language, user, consumption, 0, 0);
  }

  public static InternalLogisticData[] selectupperConsumption4User(ConnectionProvider connectionProvider, String language, String user, String consumption, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT  zssi_getproductname(snr.m_product_id,?) as pdcmaterialconsumptionproduct," +
      "          l1.value as pdcmaterialconsumptionlocator, " +
      "          snr.serialnumber as identifier," +
      "          zssi_getusername (snr.ad_user_id) as username," +
      "          ils_getdescriptionfromvendormovement(snr.serialnumber) as vendorinfo," +
      "          ils_getshipperfromvendormovement(snr.serialnumber) as shipperinfo," +
      "          snr.snr_masterdata_id" +
      "        FROM " +
      "          snr_masterdata snr," +
      "          m_locator l1" +
      "        WHERE l1.m_locator_id=snr.m_locator_id  and" +
      "              l1.islogistic='Y' and" +
      "              snr.m_locator_id=ils_getuserlogisticstoragebin(snr.ad_user_id) and" +
      "              snr.ad_user_id= ?" +
      "              and not exists (select 0 from m_internal_consumptionline co,snr_internal_consumptionline s" +
      "                                       where co.m_internal_consumptionline_id=s.m_internal_consumptionline_id" +
      "                                       and s.serialnumber=snr.serialnumber and co.m_internal_consumption_id=?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumption);

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
        InternalLogisticData objectInternalLogisticData = new InternalLogisticData();
        objectInternalLogisticData.pdcmaterialconsumptionproduct = UtilSql.getValue(result, "pdcmaterialconsumptionproduct");
        objectInternalLogisticData.pdcmaterialconsumptionlocator = UtilSql.getValue(result, "pdcmaterialconsumptionlocator");
        objectInternalLogisticData.identifier = UtilSql.getValue(result, "identifier");
        objectInternalLogisticData.username = UtilSql.getValue(result, "username");
        objectInternalLogisticData.vendorinfo = UtilSql.getValue(result, "vendorinfo");
        objectInternalLogisticData.shipperinfo = UtilSql.getValue(result, "shipperinfo");
        objectInternalLogisticData.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectInternalLogisticData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInternalLogisticData);
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
    InternalLogisticData objectInternalLogisticData[] = new InternalLogisticData[vector.size()];
    vector.copyInto(objectInternalLogisticData);
    return(objectInternalLogisticData);
  }

  public static InternalLogisticData[] selectlowerConsumption(ConnectionProvider connectionProvider, String language, String consumption)    throws ServletException {
    return selectlowerConsumption(connectionProvider, language, consumption, 0, 0);
  }

  public static InternalLogisticData[] selectlowerConsumption(ConnectionProvider connectionProvider, String language, String consumption, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        Select  coalesce(s.snr_internal_consumptionline_id,l.m_internal_consumptionline_id) as snr_masterdata_id, " +
      "                zssi_getproductname(l.m_product_id,?) as pdcmaterialconsumptionproduct," +
      "                (select zssi_getusername(snrm.ad_user_id) from snr_masterdata snrm where snrm.serialnumber=s.serialnumber and snrm.m_product_id=l.m_product_id) as username," +
      "                l1.value as pdcmaterialconsumptionlocator," +
      "                s.serialnumber as identifier,case when s.serialnumber is not null then 1 else l.movementqty end as pdcmaterialconsumptionreceivedqty" +
      "        from m_internal_consumptionline l left join snr_internal_consumptionline s on l.m_internal_consumptionline_id=s.m_internal_consumptionline_id," +
      "             m_internal_consumption c,m_locator l1" +
      "        where l.m_internal_consumption_id=c.m_internal_consumption_id and" +
      "              l.m_locator_id = l1.m_locator_id and" +
      "              c.m_internal_consumption_id=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, consumption);

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
        InternalLogisticData objectInternalLogisticData = new InternalLogisticData();
        objectInternalLogisticData.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectInternalLogisticData.pdcmaterialconsumptionproduct = UtilSql.getValue(result, "pdcmaterialconsumptionproduct");
        objectInternalLogisticData.username = UtilSql.getValue(result, "username");
        objectInternalLogisticData.pdcmaterialconsumptionlocator = UtilSql.getValue(result, "pdcmaterialconsumptionlocator");
        objectInternalLogisticData.identifier = UtilSql.getValue(result, "identifier");
        objectInternalLogisticData.pdcmaterialconsumptionreceivedqty = UtilSql.getValue(result, "pdcmaterialconsumptionreceivedqty");
        objectInternalLogisticData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInternalLogisticData);
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
    InternalLogisticData objectInternalLogisticData[] = new InternalLogisticData[vector.size()];
    vector.copyInto(objectInternalLogisticData);
    return(objectInternalLogisticData);
  }

  public static String ils_addSerialLine2InternalConsumptionWithWorkstepLocator(ConnectionProvider connectionProvider, String productid, String pSerialnumber, String pConsumption, String pUserID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ils_addSerialLine2InternalConsumptionWithWorkstepLocator(?,?,?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pSerialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pConsumption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pUserID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ils_addserialline2internalconsumptionwithworksteplocator");
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

  public static String ils_addSerialLine2InternalConsumptionOutward(ConnectionProvider connectionProvider, String productid, String pSerialnumber, String pConsumption, String pUserID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ils_addSerialLine2InternalConsumptionOutward(?,?,?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pSerialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pConsumption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pUserID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ils_addserialline2internalconsumptionoutward");
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

  public static String ils_addSerialLine2InternalConsumptionInbound(ConnectionProvider connectionProvider, String productid, String pSerialnumber, String pConsumption, String pUserID, String pLocatorID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ils_addSerialLine2InternalConsumptionInbound(?,?,?,?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pSerialnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pConsumption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pUserID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pLocatorID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ils_addserialline2internalconsumptioninbound");
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

  public static String addLine2InternalConsumption(ConnectionProvider connectionProvider, String productid, String pLocator, String pQty, String pWorkstep, String pConsumption, String pUserID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ils_addLine2InternalConsumption(?,?,?,?,?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pLocator);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pWorkstep);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pConsumption);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pUserID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ils_addline2internalconsumption");
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

  public static String getInOutIDfromDocNo(ConnectionProvider connectionProvider, String docno)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m_inout_id from m_inout where documentno= case when substr(?,1,1)='<' and substr(?,length(?),1)='>' then substr(?,2,length(?)-2) else ? end";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docno);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_inout_id");
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

  public static int addCode2Employee(ConnectionProvider connectionProvider, String code, String adUserID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        update c_bpartner set value = ?, updated=now(),updatedby = ? where c_bpartner_id = (select c_bpartner_id from ad_user where ad_user_id = ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, code);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserID);

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
}

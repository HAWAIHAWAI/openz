//Sqlc generated V1.O00-1
package org.openz.controller.manualTabPane;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ProjecttaskMaterialDispositionData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjecttaskMaterialDispositionData.class);
  private String InitRecordNumber="0";
  public String zspmProjecttaskbomViewId;
  public String cProjecttaskId;
  public String actualcosamount;
  public String line;
  public String mLocatorId;
  public String mProductId;
  public String plannedamt;
  public String planrequisition;
  public String datePlan;
  public String qtyAvailable;
  public String qtyInconsumption;
  public String qtyinrequisition;
  public String qtyInstock;
  public String qtyNextreceipt;
  public String isreturnafteruse;
  public String qtyOrdered;
  public String qtyreceived;
  public String dateNextreceipt;
  public String quantity;
  public String preselected;
  public String productcategory;
  public String uom;
  public String seqno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("zspm_projecttaskbom_view_id") || fieldName.equals("zspmProjecttaskbomViewId"))
      return zspmProjecttaskbomViewId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("actualcosamount"))
      return actualcosamount;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("planrequisition"))
      return planrequisition;
    else if (fieldName.equalsIgnoreCase("date_plan") || fieldName.equals("datePlan"))
      return datePlan;
    else if (fieldName.equalsIgnoreCase("qty_available") || fieldName.equals("qtyAvailable"))
      return qtyAvailable;
    else if (fieldName.equalsIgnoreCase("qty_inconsumption") || fieldName.equals("qtyInconsumption"))
      return qtyInconsumption;
    else if (fieldName.equalsIgnoreCase("qtyinrequisition"))
      return qtyinrequisition;
    else if (fieldName.equalsIgnoreCase("qty_instock") || fieldName.equals("qtyInstock"))
      return qtyInstock;
    else if (fieldName.equalsIgnoreCase("qty_nextreceipt") || fieldName.equals("qtyNextreceipt"))
      return qtyNextreceipt;
    else if (fieldName.equalsIgnoreCase("isreturnafteruse"))
      return isreturnafteruse;
    else if (fieldName.equalsIgnoreCase("qty_ordered") || fieldName.equals("qtyOrdered"))
      return qtyOrdered;
    else if (fieldName.equalsIgnoreCase("qtyreceived"))
      return qtyreceived;
    else if (fieldName.equalsIgnoreCase("date_nextreceipt") || fieldName.equals("dateNextreceipt"))
      return dateNextreceipt;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("preselected"))
      return preselected;
    else if (fieldName.equalsIgnoreCase("productcategory"))
      return productcategory;
    else if (fieldName.equalsIgnoreCase("uom"))
      return uom;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProjecttaskMaterialDispositionData[] select(ConnectionProvider connectionProvider, String lang, String projecttaskid, String productvalue, String productname)    throws ServletException {
    return select(connectionProvider, lang, projecttaskid, productvalue, productname, 0, 0);
  }

  public static ProjecttaskMaterialDispositionData[] select(ConnectionProvider connectionProvider, String lang, String projecttaskid, String productvalue, String productname, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select v.Zspm_Projecttaskbom_View_ID,v.C_Projecttask_ID,v.Actualcosamount,v.Line,v.M_Locator_ID,v.M_Product_ID,v.plannedamt,v.Planrequisition,v.date_plan,v.QTY_Available," +
      "             v.QTY_Inconsumption,v.Qtyinrequisition,v.QTY_Instock,v.QTY_Nextreceipt,v.isreturnafteruse," +
      "             v.QTY_Ordered,v.Qtyreceived,v.date_nextreceipt,v.Quantity, 'N' as preselected,c.name as productcategory,zssi_getuom(p.c_uom_id,?) as uom," +
      "             row_number() OVER (ORDER BY c.name,zssi_getproductname(p.m_product_id,?),Zspm_Projecttaskbom_View_ID) as seqno" +
      "             from Zspm_Projecttaskbom_View v,m_product p , m_product_category c" +
      "             where v.C_PROJECTTASK_ID = ? " +
      "             and p.m_product_id=v.m_product_id and c.m_product_category_id=p.m_product_category_id " +
      "             and p.value like ?" +
      "             and upper(zssi_getproductname(p.m_product_id,?)) like upper(?)" +
      "        order by c.name,zssi_getproductname(p.m_product_id,?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);

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
        ProjecttaskMaterialDispositionData objectProjecttaskMaterialDispositionData = new ProjecttaskMaterialDispositionData();
        objectProjecttaskMaterialDispositionData.zspmProjecttaskbomViewId = UtilSql.getValue(result, "zspm_projecttaskbom_view_id");
        objectProjecttaskMaterialDispositionData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectProjecttaskMaterialDispositionData.actualcosamount = UtilSql.getValue(result, "actualcosamount");
        objectProjecttaskMaterialDispositionData.line = UtilSql.getValue(result, "line");
        objectProjecttaskMaterialDispositionData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProjecttaskMaterialDispositionData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjecttaskMaterialDispositionData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectProjecttaskMaterialDispositionData.planrequisition = UtilSql.getValue(result, "planrequisition");
        objectProjecttaskMaterialDispositionData.datePlan = UtilSql.getDateValue(result, "date_plan", "dd-MM-yyyy");
        objectProjecttaskMaterialDispositionData.qtyAvailable = UtilSql.getValue(result, "qty_available");
        objectProjecttaskMaterialDispositionData.qtyInconsumption = UtilSql.getValue(result, "qty_inconsumption");
        objectProjecttaskMaterialDispositionData.qtyinrequisition = UtilSql.getValue(result, "qtyinrequisition");
        objectProjecttaskMaterialDispositionData.qtyInstock = UtilSql.getValue(result, "qty_instock");
        objectProjecttaskMaterialDispositionData.qtyNextreceipt = UtilSql.getValue(result, "qty_nextreceipt");
        objectProjecttaskMaterialDispositionData.isreturnafteruse = UtilSql.getValue(result, "isreturnafteruse");
        objectProjecttaskMaterialDispositionData.qtyOrdered = UtilSql.getValue(result, "qty_ordered");
        objectProjecttaskMaterialDispositionData.qtyreceived = UtilSql.getValue(result, "qtyreceived");
        objectProjecttaskMaterialDispositionData.dateNextreceipt = UtilSql.getDateValue(result, "date_nextreceipt", "dd-MM-yyyy");
        objectProjecttaskMaterialDispositionData.quantity = UtilSql.getValue(result, "quantity");
        objectProjecttaskMaterialDispositionData.preselected = UtilSql.getValue(result, "preselected");
        objectProjecttaskMaterialDispositionData.productcategory = UtilSql.getValue(result, "productcategory");
        objectProjecttaskMaterialDispositionData.uom = UtilSql.getValue(result, "uom");
        objectProjecttaskMaterialDispositionData.seqno = UtilSql.getValue(result, "seqno");
        objectProjecttaskMaterialDispositionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjecttaskMaterialDispositionData);
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
    ProjecttaskMaterialDispositionData objectProjecttaskMaterialDispositionData[] = new ProjecttaskMaterialDispositionData[vector.size()];
    vector.copyInto(objectProjecttaskMaterialDispositionData);
    return(objectProjecttaskMaterialDispositionData);
  }

  public static ProjecttaskMaterialDispositionData[] selectnew(ConnectionProvider connectionProvider, String lang, String projecttaskid, String productvalue, String productname)    throws ServletException {
    return selectnew(connectionProvider, lang, projecttaskid, productvalue, productname, 0, 0);
  }

  public static ProjecttaskMaterialDispositionData[] selectnew(ConnectionProvider connectionProvider, String lang, String projecttaskid, String productvalue, String productname, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select Zspm_Projecttaskbom_View_ID,C_Projecttask_ID,Actualcosamount,Line,M_Locator_ID,M_Product_ID,plannedamt,Planrequisition,date_plan,QTY_Available," +
      "             QTY_Inconsumption,Qtyinrequisition,QTY_Instock,QTY_Nextreceipt,isreturnafteruse," +
      "             QTY_Ordered,Qtyreceived,date_nextreceipt,Quantity, preselected,productcategory,uom," +
      "             row_number() OVER (ORDER BY preselected desc, productcategory,zssi_getproductname(m_product_id,?),Zspm_Projecttaskbom_View_ID) as seqno" +
      "      FROM (" +
      "      select get_uuid() as Zspm_Projecttaskbom_View_ID,'' as C_Projecttask_ID, " +
      "             0 as Actualcosamount," +
      "             0 as Line," +
      "             '' as M_Locator_ID,'' as M_Product_ID,0 as plannedamt,'N' as Planrequisition," +
      "             (select coalesce(startdate,trunc(now())) from c_projecttask where C_PROJECTTASK_ID = ?) as date_plan,0 as QTY_Available," +
      "             0 as QTY_Inconsumption,0 as Qtyinrequisition,0 as QTY_Instock,0 as QTY_Nextreceipt,'N' as isreturnafteruse," +
      "             0 as QTY_Ordered,0 as Qtyreceived,null as date_nextreceipt,1 as Quantity, 'Y' as preselected,'' as productcategory,'' as uom " +
      "      from dual" +
      "      UNION" +
      "      select v.Zspm_Projecttaskbom_View_ID,v.C_Projecttask_ID,v.Actualcosamount,v.Line,v.M_Locator_ID,v.M_Product_ID,v.plannedamt,v.Planrequisition,v.date_plan,v.QTY_Available," +
      "             v.QTY_Inconsumption,v.Qtyinrequisition,v.QTY_Instock,v.QTY_Nextreceipt,v.isreturnafteruse," +
      "             v.QTY_Ordered,v.Qtyreceived,v.date_nextreceipt,v.Quantity, 'N' as preselected,c.name as productcategory, zssi_getuom(p.c_uom_id,?) as uom" +
      "             from Zspm_Projecttaskbom_View v,m_product p , m_product_category c" +
      "             where v.C_PROJECTTASK_ID = ? " +
      "             and p.m_product_id=v.m_product_id and c.m_product_category_id=p.m_product_category_id " +
      "             and p.value like ?" +
      "             and  upper(zssi_getproductname(p.m_product_id,?)) like upper(?)" +
      "        ) a order by preselected desc, productcategory,zssi_getproductname(m_product_id,?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);

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
        ProjecttaskMaterialDispositionData objectProjecttaskMaterialDispositionData = new ProjecttaskMaterialDispositionData();
        objectProjecttaskMaterialDispositionData.zspmProjecttaskbomViewId = UtilSql.getValue(result, "zspm_projecttaskbom_view_id");
        objectProjecttaskMaterialDispositionData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectProjecttaskMaterialDispositionData.actualcosamount = UtilSql.getValue(result, "actualcosamount");
        objectProjecttaskMaterialDispositionData.line = UtilSql.getValue(result, "line");
        objectProjecttaskMaterialDispositionData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProjecttaskMaterialDispositionData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProjecttaskMaterialDispositionData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectProjecttaskMaterialDispositionData.planrequisition = UtilSql.getValue(result, "planrequisition");
        objectProjecttaskMaterialDispositionData.datePlan = UtilSql.getDateValue(result, "date_plan", "dd-MM-yyyy");
        objectProjecttaskMaterialDispositionData.qtyAvailable = UtilSql.getValue(result, "qty_available");
        objectProjecttaskMaterialDispositionData.qtyInconsumption = UtilSql.getValue(result, "qty_inconsumption");
        objectProjecttaskMaterialDispositionData.qtyinrequisition = UtilSql.getValue(result, "qtyinrequisition");
        objectProjecttaskMaterialDispositionData.qtyInstock = UtilSql.getValue(result, "qty_instock");
        objectProjecttaskMaterialDispositionData.qtyNextreceipt = UtilSql.getValue(result, "qty_nextreceipt");
        objectProjecttaskMaterialDispositionData.isreturnafteruse = UtilSql.getValue(result, "isreturnafteruse");
        objectProjecttaskMaterialDispositionData.qtyOrdered = UtilSql.getValue(result, "qty_ordered");
        objectProjecttaskMaterialDispositionData.qtyreceived = UtilSql.getValue(result, "qtyreceived");
        objectProjecttaskMaterialDispositionData.dateNextreceipt = UtilSql.getDateValue(result, "date_nextreceipt", "dd-MM-yyyy");
        objectProjecttaskMaterialDispositionData.quantity = UtilSql.getValue(result, "quantity");
        objectProjecttaskMaterialDispositionData.preselected = UtilSql.getValue(result, "preselected");
        objectProjecttaskMaterialDispositionData.productcategory = UtilSql.getValue(result, "productcategory");
        objectProjecttaskMaterialDispositionData.uom = UtilSql.getValue(result, "uom");
        objectProjecttaskMaterialDispositionData.seqno = UtilSql.getValue(result, "seqno");
        objectProjecttaskMaterialDispositionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjecttaskMaterialDispositionData);
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
    ProjecttaskMaterialDispositionData objectProjecttaskMaterialDispositionData[] = new ProjecttaskMaterialDispositionData[vector.size()];
    vector.copyInto(objectProjecttaskMaterialDispositionData);
    return(objectProjecttaskMaterialDispositionData);
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String idValue, String adOrgId, String projecttaskId, String createdby, String line, String locatorId, String productId, String quantity, String planreq, String returnafter, String dateplan)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO Zspm_Projecttaskbom_View(Zspm_Projecttaskbom_View_id, AD_CLIENT_ID,AD_ORG_ID, C_PROJECTTASK_ID, CREATEDBY, UPDATEDBY, isactive,updated,created," +
      "                  Line,M_Locator_ID,M_Product_ID,Quantity,Planrequisition,isreturnafteruse,date_plan)" +
      "      VALUES(?, 'C726FEC915A54A0995C568555DA5BB3C', ?, ?, ?, ?, 'Y',now(),now()," +
      "             to_number(coalesce(?,'0')), ?, ? ,to_number(?),?,?,to_date(?,'dd.mm.yyyy'))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, idValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planreq);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnafter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplan);

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

  public static int update(Connection conn, ConnectionProvider connectionProvider, String updatedby, String line, String locatorId, String productId, String quantity, String planreq, String returnafter, String dateplan, String bomviewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE Zspm_Projecttaskbom_View  set UPDATEDBY=?,Line=to_number(coalesce(?,'0')),M_Locator_ID=?,M_Product_ID=?," +
      "             Quantity=to_number(?),Planrequisition=?,isreturnafteruse=?,updated=now(),date_plan=to_date(?,'dd.mm.yyyy')" +
      "      WHERE Zspm_Projecttaskbom_View_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planreq);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, returnafter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bomviewId);

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

  public static String isExisting(ConnectionProvider connectionProvider, String pBomId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(*) from Zspm_Projecttaskbom_View where Zspm_Projecttaskbom_View_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pBomId);

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

  public static int delete(Connection conn, ConnectionProvider connectionProvider, String bomviewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       delete from Zspm_Projecttaskbom_View where Zspm_Projecttaskbom_View_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bomviewId);

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

  public static String gfetNextLine(ConnectionProvider connectionProvider, String pTaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM Zspm_Projecttaskbom_View WHERE  C_PROJECTTASK_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTaskId);

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

  public static String getPalanDate(ConnectionProvider connectionProvider, String pTaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select to_char(coalesce(startdate,trunc(now())),'dd.mm.yyyy') from c_projecttask where C_PROJECTTASK_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTaskId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "to_char");
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

  public static String getPreferedLocator(ConnectionProvider connectionProvider, String pTaskId, String pProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select zsmf_getlocatorWithStock(?,?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "zsmf_getlocatorwithstock");
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

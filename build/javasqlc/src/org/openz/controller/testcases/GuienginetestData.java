//Sqlc generated V1.O00-1
package org.openz.controller.testcases;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class GuienginetestData implements FieldProvider {
static Logger log4j = Logger.getLogger(GuienginetestData.class);
  private String InitRecordNumber="0";
  public String textbox;
  public String datebox;
  public String checkbox;
  public String decbox;
  public String euro;
  public String intbox;
  public String listsorter;
  public String multiselector;
  public String popupsearch;
  public String price;
  public String refcombo;
  public String noedittextbox;
  public String image;
  public String url;
  public String textareasimple;
  public String textareaadv;
  public String listsortersim;
  public String testGuiengineId;
  public String adOrgId;
  public String adClientId;
  public String isactive;
  public String updated;
  public String created;
  public String createdby;
  public String updatedby;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("textbox"))
      return textbox;
    else if (fieldName.equalsIgnoreCase("datebox"))
      return datebox;
    else if (fieldName.equalsIgnoreCase("checkbox"))
      return checkbox;
    else if (fieldName.equalsIgnoreCase("decbox"))
      return decbox;
    else if (fieldName.equalsIgnoreCase("euro"))
      return euro;
    else if (fieldName.equalsIgnoreCase("intbox"))
      return intbox;
    else if (fieldName.equalsIgnoreCase("listsorter"))
      return listsorter;
    else if (fieldName.equalsIgnoreCase("multiselector"))
      return multiselector;
    else if (fieldName.equalsIgnoreCase("popupsearch"))
      return popupsearch;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("refcombo"))
      return refcombo;
    else if (fieldName.equalsIgnoreCase("noedittextbox"))
      return noedittextbox;
    else if (fieldName.equalsIgnoreCase("image"))
      return image;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("textareasimple"))
      return textareasimple;
    else if (fieldName.equalsIgnoreCase("textareaadv"))
      return textareaadv;
    else if (fieldName.equalsIgnoreCase("listsortersim"))
      return listsortersim;
    else if (fieldName.equalsIgnoreCase("test_guiengine_id") || fieldName.equals("testGuiengineId"))
      return testGuiengineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GuienginetestData[] initialize(ConnectionProvider connectionProvider)    throws ServletException {
    return initialize(connectionProvider, 0, 0);
  }

  public static GuienginetestData[] initialize(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select " +
      "            '' as textbox," +
      "            '' as datebox," +
      "            '' as checkbox," +
      "            '' as decbox, " +
      "            '' as euro," +
      "            '' as intbox," +
      "            '' as listsorter," +
      "            '' as multiselector," +
      "            '' as popupsearch," +
      "            '' as price," +
      "            '' as refcombo," +
      "            '' as noedittextbox," +
      "            '' as image," +
      "            '' as url," +
      "            '' as textareasimple," +
      "            '' as textareaadv," +
      "            '' as listsortersim,         " +
      "            '' as test_guiengine_id," +
      "            '' as ad_org_id," +
      "            '' as ad_client_id," +
      "            '' as isactive," +
      "            '' as updated," +
      "            '' as created," +
      "            '' as createdby," +
      "            '' as updatedby";

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
        GuienginetestData objectGuienginetestData = new GuienginetestData();
        objectGuienginetestData.textbox = UtilSql.getValue(result, "textbox");
        objectGuienginetestData.datebox = UtilSql.getValue(result, "datebox");
        objectGuienginetestData.checkbox = UtilSql.getValue(result, "checkbox");
        objectGuienginetestData.decbox = UtilSql.getValue(result, "decbox");
        objectGuienginetestData.euro = UtilSql.getValue(result, "euro");
        objectGuienginetestData.intbox = UtilSql.getValue(result, "intbox");
        objectGuienginetestData.listsorter = UtilSql.getValue(result, "listsorter");
        objectGuienginetestData.multiselector = UtilSql.getValue(result, "multiselector");
        objectGuienginetestData.popupsearch = UtilSql.getValue(result, "popupsearch");
        objectGuienginetestData.price = UtilSql.getValue(result, "price");
        objectGuienginetestData.refcombo = UtilSql.getValue(result, "refcombo");
        objectGuienginetestData.noedittextbox = UtilSql.getValue(result, "noedittextbox");
        objectGuienginetestData.image = UtilSql.getValue(result, "image");
        objectGuienginetestData.url = UtilSql.getValue(result, "url");
        objectGuienginetestData.textareasimple = UtilSql.getValue(result, "textareasimple");
        objectGuienginetestData.textareaadv = UtilSql.getValue(result, "textareaadv");
        objectGuienginetestData.listsortersim = UtilSql.getValue(result, "listsortersim");
        objectGuienginetestData.testGuiengineId = UtilSql.getValue(result, "test_guiengine_id");
        objectGuienginetestData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectGuienginetestData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectGuienginetestData.isactive = UtilSql.getValue(result, "isactive");
        objectGuienginetestData.updated = UtilSql.getValue(result, "updated");
        objectGuienginetestData.created = UtilSql.getValue(result, "created");
        objectGuienginetestData.createdby = UtilSql.getValue(result, "createdby");
        objectGuienginetestData.updatedby = UtilSql.getValue(result, "updatedby");
        objectGuienginetestData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGuienginetestData);
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
    GuienginetestData objectGuienginetestData[] = new GuienginetestData[vector.size()];
    vector.copyInto(objectGuienginetestData);
    return(objectGuienginetestData);
  }

  public static GuienginetestData[] selectupper(ConnectionProvider connectionProvider, String language)    throws ServletException {
    return selectupper(connectionProvider, language, 0, 0);
  }

  public static GuienginetestData[] selectupper(ConnectionProvider connectionProvider, String language, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select" +
      "		textbox," +
      "		datebox," +
      "		checkbox," +
      "		decbox," +
      "		euro," +
      "		intbox," +
      "		listsorter," +
      "		multiselector," +
      "		zssi_getproductname(popupsearch, ?) as popupsearch," +
      "		price," +
      "		zssi_getusername(refcombo) as refcombo," +
      "		noedittextbox," +
      "		image," +
      "		url," +
      "		textareasimple," +
      "		textareaadv," +
      "		listsortersim," +
      "		test_guiengine_id" +
      "        from" +
      "            test_guiengine" +
      "        where test_guiengine_id='58CDBD0FE1F7448EB159BC0D935A22C1'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

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
        GuienginetestData objectGuienginetestData = new GuienginetestData();
        objectGuienginetestData.textbox = UtilSql.getValue(result, "textbox");
        objectGuienginetestData.datebox = UtilSql.getDateValue(result, "datebox", "dd-MM-yyyy");
        objectGuienginetestData.checkbox = UtilSql.getValue(result, "checkbox");
        objectGuienginetestData.decbox = UtilSql.getValue(result, "decbox");
        objectGuienginetestData.euro = UtilSql.getValue(result, "euro");
        objectGuienginetestData.intbox = UtilSql.getValue(result, "intbox");
        objectGuienginetestData.listsorter = UtilSql.getValue(result, "listsorter");
        objectGuienginetestData.multiselector = UtilSql.getValue(result, "multiselector");
        objectGuienginetestData.popupsearch = UtilSql.getValue(result, "popupsearch");
        objectGuienginetestData.price = UtilSql.getValue(result, "price");
        objectGuienginetestData.refcombo = UtilSql.getValue(result, "refcombo");
        objectGuienginetestData.noedittextbox = UtilSql.getValue(result, "noedittextbox");
        objectGuienginetestData.image = UtilSql.getValue(result, "image");
        objectGuienginetestData.url = UtilSql.getValue(result, "url");
        objectGuienginetestData.textareasimple = UtilSql.getValue(result, "textareasimple");
        objectGuienginetestData.textareaadv = UtilSql.getValue(result, "textareaadv");
        objectGuienginetestData.listsortersim = UtilSql.getValue(result, "listsortersim");
        objectGuienginetestData.testGuiengineId = UtilSql.getValue(result, "test_guiengine_id");
        objectGuienginetestData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGuienginetestData);
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
    GuienginetestData objectGuienginetestData[] = new GuienginetestData[vector.size()];
    vector.copyInto(objectGuienginetestData);
    return(objectGuienginetestData);
  }

  public static int updateTestdata(ConnectionProvider connectionProvider, String textbox, String datebox, String checkbox, String d, String euro, String i, String listsorter, String multiselector, String popupsearch, String price, String refcombo, String noedittextbox, String image, String url, String textareasimple, String textareaadv, String listsortersim)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        update test_guiengine" +
      "        	set textbox = ?," +
      "             datebox = to_date(?)," +
      "             checkbox = ?," +
      "             decbox = to_number(?)," +
      "             euro = to_number(?)," +
      "             intbox = to_number(?)," +
      "             listsorter = ?," +
      "             multiselector = ?," +
      "             popupsearch = ?," +
      "             price = to_number(?)," +
      "             refcombo = ?," +
      "             noedittextbox = ?," +
      "             image = ?," +
      "             url = ?," +
      "             textareasimple = ?," +
      "             textareaadv = zssi_2html(?)," +
      "             listsortersim = ?," +
      "             updated= now()," +
      "             created= now()" +
      "       	where test_guiengine_id='58CDBD0FE1F7448EB159BC0D935A22C1'";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, textbox);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datebox);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, checkbox);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, d);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, euro);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, i);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, listsorter);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, multiselector);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, popupsearch);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refcombo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noedittextbox);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, image);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, textareasimple);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, textareaadv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, listsortersim);

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

//Sqlc generated V1.O00-1
package org.openbravo.erpReports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class RptCProposalData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCProposalData.class);
  private String InitRecordNumber="0";
  public String cProjectproposalId;
  public String cBpartnerId;
  public String proposal;
  public String lineDesc;
  public String mProductIdD;
  public String description;
  public String price;
  public String quantity;
  public String uomname;
  public String address1;
  public String address2;
  public String localidad;
  public String phone;
  public String fax;
  public String fecha;
  public String bpname;
  public String namecontacto;
  public String contacto;
  public String city;
  public String headernote;
  public String footnote;
  public String reference;
  public String cursymbol;
  public String greet;
  public String greetaux;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_projectproposal_id") || fieldName.equals("cProjectproposalId"))
      return cProjectproposalId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("proposal"))
      return proposal;
    else if (fieldName.equalsIgnoreCase("line_desc") || fieldName.equals("lineDesc"))
      return lineDesc;
    else if (fieldName.equalsIgnoreCase("m_product_id_d") || fieldName.equals("mProductIdD"))
      return mProductIdD;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("localidad"))
      return localidad;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("fax"))
      return fax;
    else if (fieldName.equalsIgnoreCase("fecha"))
      return fecha;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("namecontacto"))
      return namecontacto;
    else if (fieldName.equalsIgnoreCase("contacto"))
      return contacto;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("headernote"))
      return headernote;
    else if (fieldName.equalsIgnoreCase("footnote"))
      return footnote;
    else if (fieldName.equalsIgnoreCase("reference"))
      return reference;
    else if (fieldName.equalsIgnoreCase("cursymbol"))
      return cursymbol;
    else if (fieldName.equalsIgnoreCase("greet"))
      return greet;
    else if (fieldName.equalsIgnoreCase("greetaux"))
      return greetaux;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCProposalData[] select(ConnectionProvider connectionProvider, String adUserClient, String adOrgClient, String cProjectProposalId)    throws ServletException {
    return select(connectionProvider, adUserClient, adOrgClient, cProjectProposalId, 0, 0);
  }

  public static RptCProposalData[] select(ConnectionProvider connectionProvider, String adUserClient, String adOrgClient, String cProjectProposalId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_PROJECTPROPOSAL.C_PROJECTPROPOSAL_ID, C_PROJECTPROPOSAL.C_BPARTNER_ID, '' as proposal, " +
      "        '' as line_desc,'' as M_Product_ID_D, '' as description, '' as price,'' as quantity, '' as UOMNAME,'' as address1, '' as address2, '' as localidad, '' as phone, '' as fax, '' as fecha, '' as BPname , '' as namecontacto, '' as contacto, '' as city, '' as headernote, '' as footnote, '' as reference, '' as CURSYMBOL, '' AS GREET, '' AS GREETAUX" +
      "        FROM  C_PROJECTPROPOSAL" +
      "        WHERE C_PROJECTPROPOSAL.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND C_PROJECTPROPOSAL.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((cProjectProposalId==null || cProjectProposalId.equals(""))?"":"           AND C_PROJECTPROPOSAL.C_PROJECTPROPOSAL_ID IN          " + cProjectProposalId);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }
      if (cProjectProposalId != null && !(cProjectProposalId.equals(""))) {
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
        RptCProposalData objectRptCProposalData = new RptCProposalData();
        objectRptCProposalData.cProjectproposalId = UtilSql.getValue(result, "c_projectproposal_id");
        objectRptCProposalData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRptCProposalData.proposal = UtilSql.getValue(result, "proposal");
        objectRptCProposalData.lineDesc = UtilSql.getValue(result, "line_desc");
        objectRptCProposalData.mProductIdD = UtilSql.getValue(result, "m_product_id_d");
        objectRptCProposalData.description = UtilSql.getValue(result, "description");
        objectRptCProposalData.price = UtilSql.getValue(result, "price");
        objectRptCProposalData.quantity = UtilSql.getValue(result, "quantity");
        objectRptCProposalData.uomname = UtilSql.getValue(result, "uomname");
        objectRptCProposalData.address1 = UtilSql.getValue(result, "address1");
        objectRptCProposalData.address2 = UtilSql.getValue(result, "address2");
        objectRptCProposalData.localidad = UtilSql.getValue(result, "localidad");
        objectRptCProposalData.phone = UtilSql.getValue(result, "phone");
        objectRptCProposalData.fax = UtilSql.getValue(result, "fax");
        objectRptCProposalData.fecha = UtilSql.getValue(result, "fecha");
        objectRptCProposalData.bpname = UtilSql.getValue(result, "bpname");
        objectRptCProposalData.namecontacto = UtilSql.getValue(result, "namecontacto");
        objectRptCProposalData.contacto = UtilSql.getValue(result, "contacto");
        objectRptCProposalData.city = UtilSql.getValue(result, "city");
        objectRptCProposalData.headernote = UtilSql.getValue(result, "headernote");
        objectRptCProposalData.footnote = UtilSql.getValue(result, "footnote");
        objectRptCProposalData.reference = UtilSql.getValue(result, "reference");
        objectRptCProposalData.cursymbol = UtilSql.getValue(result, "cursymbol");
        objectRptCProposalData.greet = UtilSql.getValue(result, "greet");
        objectRptCProposalData.greetaux = UtilSql.getValue(result, "greetaux");
        objectRptCProposalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCProposalData);
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
    RptCProposalData objectRptCProposalData[] = new RptCProposalData[vector.size()];
    vector.copyInto(objectRptCProposalData);
    return(objectRptCProposalData);
  }

  public static RptCProposalData[] set()    throws ServletException {
    RptCProposalData objectRptCProposalData[] = new RptCProposalData[1];
    objectRptCProposalData[0] = new RptCProposalData();
    objectRptCProposalData[0].cProjectproposalId = "";
    objectRptCProposalData[0].cBpartnerId = "";
    objectRptCProposalData[0].proposal = "";
    objectRptCProposalData[0].lineDesc = "";
    objectRptCProposalData[0].mProductIdD = "";
    objectRptCProposalData[0].description = "";
    objectRptCProposalData[0].price = "";
    objectRptCProposalData[0].quantity = "";
    objectRptCProposalData[0].uomname = "";
    objectRptCProposalData[0].address1 = "";
    objectRptCProposalData[0].address2 = "";
    objectRptCProposalData[0].localidad = "";
    objectRptCProposalData[0].phone = "";
    objectRptCProposalData[0].fax = "";
    objectRptCProposalData[0].fecha = "";
    objectRptCProposalData[0].bpname = "";
    objectRptCProposalData[0].namecontacto = "";
    objectRptCProposalData[0].contacto = "";
    objectRptCProposalData[0].city = "";
    objectRptCProposalData[0].headernote = "";
    objectRptCProposalData[0].footnote = "";
    objectRptCProposalData[0].reference = "";
    objectRptCProposalData[0].cursymbol = "";
    objectRptCProposalData[0].greet = "";
    objectRptCProposalData[0].greetaux = "";
    return objectRptCProposalData;
  }

  public static RptCProposalData[] selectLines(ConnectionProvider connectionProvider, String cProjectProposalId)    throws ServletException {
    return selectLines(connectionProvider, cProjectProposalId, 0, 0);
  }

  public static RptCProposalData[] selectLines(ConnectionProvider connectionProvider, String cProjectProposalId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT table3.C_BPartner_ID, '' as proposal, " +
      "        replace(C_ProjectProposalLine.Description, chr(10), '')as line_desc,to_char( table6.Name ) as M_Product_ID_D, table6.description as description, C_ProjectProposalLine.Price as price,C_ProjectProposalLine.Qty as quantity, table7.NAME as UOMNAME,'' as address1, '' as localidad, '' as phone, '' as fax, '' as fecha, '' as BPname , '' as namecontacto, '' as contacto, '' as city, '' as headernote, '' as footnote, '' as reference, '' as CURSYMBOL, '' AS GREET, '' AS GREETAUX" +
      "        FROM C_ProjectProposalLine, AD_Client table1, " +
      "        AD_Org table2, C_Projectproposal table3, C_BPartner table4, C_Project table5, M_Product table6, C_UOM table7" +
      "        WHERE C_ProjectProposalLine.C_Projectproposal_ID = ?" +
      "        AND C_ProjectProposalLine.AD_Client_ID = table1.AD_Client_ID " +
      "        AND C_ProjectProposalLine.AD_Org_ID = table2.AD_Org_ID " +
      "        AND C_ProjectProposalLine.C_Projectproposal_ID = table3.C_Projectproposal_ID " +
      "        AND table3.C_BPartner_ID = table4.C_BPartner_ID " +
      "        AND table3.C_Project_ID = table5.C_Project_ID " +
      "        AND C_ProjectProposalLine.M_Product_ID = table6.M_Product_ID" +
      "        AND table6.C_UOM_ID = table7.C_UOM_ID" +
      "        and C_ProjectProposalLine.IsActive = 'Y'" +
      "        ORDER BY C_PROJECTPROPOSALLINE.LINENO ASC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectProposalId);

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
        RptCProposalData objectRptCProposalData = new RptCProposalData();
        objectRptCProposalData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRptCProposalData.proposal = UtilSql.getValue(result, "proposal");
        objectRptCProposalData.lineDesc = UtilSql.getValue(result, "line_desc");
        objectRptCProposalData.mProductIdD = UtilSql.getValue(result, "m_product_id_d");
        objectRptCProposalData.description = UtilSql.getValue(result, "description");
        objectRptCProposalData.price = UtilSql.getValue(result, "price");
        objectRptCProposalData.quantity = UtilSql.getValue(result, "quantity");
        objectRptCProposalData.uomname = UtilSql.getValue(result, "uomname");
        objectRptCProposalData.address1 = UtilSql.getValue(result, "address1");
        objectRptCProposalData.localidad = UtilSql.getValue(result, "localidad");
        objectRptCProposalData.phone = UtilSql.getValue(result, "phone");
        objectRptCProposalData.fax = UtilSql.getValue(result, "fax");
        objectRptCProposalData.fecha = UtilSql.getValue(result, "fecha");
        objectRptCProposalData.bpname = UtilSql.getValue(result, "bpname");
        objectRptCProposalData.namecontacto = UtilSql.getValue(result, "namecontacto");
        objectRptCProposalData.contacto = UtilSql.getValue(result, "contacto");
        objectRptCProposalData.city = UtilSql.getValue(result, "city");
        objectRptCProposalData.headernote = UtilSql.getValue(result, "headernote");
        objectRptCProposalData.footnote = UtilSql.getValue(result, "footnote");
        objectRptCProposalData.reference = UtilSql.getValue(result, "reference");
        objectRptCProposalData.cursymbol = UtilSql.getValue(result, "cursymbol");
        objectRptCProposalData.greet = UtilSql.getValue(result, "greet");
        objectRptCProposalData.greetaux = UtilSql.getValue(result, "greetaux");
        objectRptCProposalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCProposalData);
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
    RptCProposalData objectRptCProposalData[] = new RptCProposalData[vector.size()];
    vector.copyInto(objectRptCProposalData);
    return(objectRptCProposalData);
  }

  public static RptCProposalData[] selectHeader(ConnectionProvider connectionProvider, String cBPartnerId, String cProjectProposalId)    throws ServletException {
    return selectHeader(connectionProvider, cBPartnerId, cProjectProposalId, 0, 0);
  }

  public static RptCProposalData[] selectHeader(ConnectionProvider connectionProvider, String cBPartnerId, String cProjectProposalId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT REPLACE(table3.HEADERNOTE, CHR(10), '') AS headernote, table7.C_BPARTNER_ID, TO_CHAR(table8.address1) AS address1, to_char(table8.address2) as address2," +
      "        TO_CHAR(table5.DESCRIPTION )  AS proposal, table5.VALUE AS reference," +
      "        TO_CHAR(table8.POSTAL)||' '|| TO_CHAR(table8.CITY)||' ('||TO_CHAR(table9.description)||')' AS localidad, " +
      "        TO_CHAR(table7.FAX) AS fax,TO_CHAR(table7.PHONE) AS phone, " +
      "        TO_NUMBER(TO_CHAR(table3.DATESEND, 'dd'),'99') ||' de ' || TO_CHAR(table3.DATESEND, 'month') ||' de ' || TO_CHAR(table3.DATESEND, 'yyyy') AS fecha, " +
      "        TO_CHAR(table10.NAME) AS BPname, table11.FIRSTNAME AS namecontacto, table11.LASTNAME AS contacto, " +
      "        TO_CHAR(table14.CITY) AS city, table15.CURSYMBOL as CURSYMBOL, C_GREETING.NAME AS GREET, (CASE C_GREETING.C_GREETING_ID WHEN '1000001' THEN 'Estimada '||C_GREETING.NAME WHEN '1000003' THEN 'Estimada '||C_GREETING.NAME ELSE 'Estimado '||C_GREETING.NAME END) AS GREETAUX" +
      "        FROM  C_PROJECTPROPOSAL table3 left join AD_USER table11 on table3.AD_USER_ID = table11.AD_USER_ID" +
      "                                       left join C_GREETING on table11.C_GREETING_ID = C_GREETING.C_GREETING_ID,       " +
      "        C_BPARTNER_LOCATION table7, C_LOCATION table8, C_REGION table9, C_BPARTNER table10, C_PROJECTPROPOSALLINE," +
      "         C_BPARTNER table4, C_PROJECT table5, AD_ORGINFO table13," +
      "        C_LOCATION table14, C_CURRENCY table15 " +
      "        WHERE  table7.C_BPARTNER_ID = ?" +
      "        AND C_PROJECTPROPOSALLINE.C_Projectproposal_ID = ?" +
      "        AND C_PROJECTPROPOSALLINE.C_PROJECTPROPOSAL_ID = table3.C_PROJECTPROPOSAL_ID" +
      "        AND table3.C_BPARTNER_LOCATION_ID = table7.C_BPARTNER_LOCATION_ID" +
      "        AND table7.C_LOCATION_ID = table8.C_LOCATION_ID" +
      "        AND table8.C_REGION_ID = table9.C_REGION_ID" +
      "        AND table10.C_BPARTNER_ID = table7.C_BPARTNER_ID" +
      "        AND C_PROJECTPROPOSALLINE.C_Projectproposal_ID = table3.C_Projectproposal_ID " +
      "        AND table3.C_BPartner_ID = table4.C_BPartner_ID " +
      "        AND table3.C_Project_ID = table5.C_Project_ID " +
      "        AND table5.C_CURRENCY_ID = table15.C_CURRENCY_ID" +
      "        AND C_PROJECTPROPOSALLINE.IsActive = 'Y'" +
      "        AND table13.AD_ORG_ID = C_PROJECTPROPOSALLINE.AD_ORG_ID" +
      "        AND table14.C_LOCATION_ID= table13.C_LOCATION_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBPartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectProposalId);

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
        RptCProposalData objectRptCProposalData = new RptCProposalData();
        objectRptCProposalData.headernote = UtilSql.getValue(result, "headernote");
        objectRptCProposalData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRptCProposalData.address1 = UtilSql.getValue(result, "address1");
        objectRptCProposalData.address2 = UtilSql.getValue(result, "address2");
        objectRptCProposalData.proposal = UtilSql.getValue(result, "proposal");
        objectRptCProposalData.reference = UtilSql.getValue(result, "reference");
        objectRptCProposalData.localidad = UtilSql.getValue(result, "localidad");
        objectRptCProposalData.fax = UtilSql.getValue(result, "fax");
        objectRptCProposalData.phone = UtilSql.getValue(result, "phone");
        objectRptCProposalData.fecha = UtilSql.getValue(result, "fecha");
        objectRptCProposalData.bpname = UtilSql.getValue(result, "bpname");
        objectRptCProposalData.namecontacto = UtilSql.getValue(result, "namecontacto");
        objectRptCProposalData.contacto = UtilSql.getValue(result, "contacto");
        objectRptCProposalData.city = UtilSql.getValue(result, "city");
        objectRptCProposalData.cursymbol = UtilSql.getValue(result, "cursymbol");
        objectRptCProposalData.greet = UtilSql.getValue(result, "greet");
        objectRptCProposalData.greetaux = UtilSql.getValue(result, "greetaux");
        objectRptCProposalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCProposalData);
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
    RptCProposalData objectRptCProposalData[] = new RptCProposalData[vector.size()];
    vector.copyInto(objectRptCProposalData);
    return(objectRptCProposalData);
  }

  public static RptCProposalData[] selectFootnote(ConnectionProvider connectionProvider, String cProjectProposalId)    throws ServletException {
    return selectFootnote(connectionProvider, cProjectProposalId, 0, 0);
  }

  public static RptCProposalData[] selectFootnote(ConnectionProvider connectionProvider, String cProjectProposalId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT DISTINCT REPLACE(C_PROJECTPROPOSAL.FOOTNOTE, CHR(10), '') AS FOOTNOTE" +
      "         FROM C_PROJECTPROPOSAL, C_PROJECTPROPOSALLINE" +
      "         WHERE C_PROJECTPROPOSALLINE.C_PROJECTPROPOSAL_ID=?" +
      "         AND C_PROJECTPROPOSALLINE.c_projectproposal_id=C_PROJECTPROPOSAL.c_projectproposal_id";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectProposalId);

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
        RptCProposalData objectRptCProposalData = new RptCProposalData();
        objectRptCProposalData.footnote = UtilSql.getValue(result, "footnote");
        objectRptCProposalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCProposalData);
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
    RptCProposalData objectRptCProposalData[] = new RptCProposalData[vector.size()];
    vector.copyInto(objectRptCProposalData);
    return(objectRptCProposalData);
  }
}

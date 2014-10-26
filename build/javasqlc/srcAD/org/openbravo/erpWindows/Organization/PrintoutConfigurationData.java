//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Organization;

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
class PrintoutConfigurationData implements FieldProvider {
static Logger log4j = Logger.getLogger(PrintoutConfigurationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String printordernumberoninvoice;
  public String printordernumberoninvoicenewline;
  public String printordernumberoninvoicebold;
  public String pordnoinvOrdernum;
  public String printordernumberonshipment;
  public String printordernumberonshipmentnewline;
  public String printordernumberonshipmentbold;
  public String pordnoshipOrdernum;
  public String printshipmentnumberoninvoice;
  public String printshipmentnumberoninvoicenewline;
  public String printshipmentnumberoninvoicebold;
  public String pshipnoinvOrdernum;
  public String printshipmentdateoninvoice;
  public String printshipmentdateoninvoicenewline;
  public String printshipmentdateoninvoicebold;
  public String pshipdateinvOrdernum;
  public String printserialnumberondocs;
  public String printsetproductwithbom;
  public String printopenshipments;
  public String printcashdiscountinfo;
  public String printpnameondocs;
  public String pnameOrdernum;
  public String printpnamenewline;
  public String printpnamebold;
  public String printpnumberondocs;
  public String pnumberOrdernum;
  public String printpnumbernewline;
  public String printpnumberbold;
  public String printattrsondocs;
  public String attrsOrdernum;
  public String printattrsnewline;
  public String printattrsbold;
  public String printvpnumberondocs;
  public String vpnumberOrdernum;
  public String printvpnumbernewline;
  public String printvpnumberbold;
  public String printpdescondocs;
  public String pdescOrdernum;
  public String printpdescnewline;
  public String printpdescbold;
  public String printdocnoteondocs;
  public String docnoteOrdernum;
  public String printdocnotenewline;
  public String printdocnotebold;
  public String cpyProddocnote2docnote;
  public String proddocnoteOrdernum;
  public String cpyProddesc2docnote;
  public String proddescOrdernum;
  public String cpyVendpnumber2docnote;
  public String vendpnumberdnOrdernum;
  public String performacedateoninvoice;
  public String isactive;
  public String address5;
  public String footer1;
  public String onelineadr;
  public String address1;
  public String footer2;
  public String footer3;
  public String zsprPrintinfoId;
  public String adClientId;
  public String addressheader;
  public String footer5;
  public String address7;
  public String address8;
  public String address6;
  public String address3;
  public String adOrgId;
  public String address9;
  public String address4;
  public String address2;
  public String footer4;
  public String isfootergroupstyle;
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
    else if (fieldName.equalsIgnoreCase("printordernumberoninvoice"))
      return printordernumberoninvoice;
    else if (fieldName.equalsIgnoreCase("printordernumberoninvoicenewline"))
      return printordernumberoninvoicenewline;
    else if (fieldName.equalsIgnoreCase("printordernumberoninvoicebold"))
      return printordernumberoninvoicebold;
    else if (fieldName.equalsIgnoreCase("pordnoinv_ordernum") || fieldName.equals("pordnoinvOrdernum"))
      return pordnoinvOrdernum;
    else if (fieldName.equalsIgnoreCase("printordernumberonshipment"))
      return printordernumberonshipment;
    else if (fieldName.equalsIgnoreCase("printordernumberonshipmentnewline"))
      return printordernumberonshipmentnewline;
    else if (fieldName.equalsIgnoreCase("printordernumberonshipmentbold"))
      return printordernumberonshipmentbold;
    else if (fieldName.equalsIgnoreCase("pordnoship_ordernum") || fieldName.equals("pordnoshipOrdernum"))
      return pordnoshipOrdernum;
    else if (fieldName.equalsIgnoreCase("printshipmentnumberoninvoice"))
      return printshipmentnumberoninvoice;
    else if (fieldName.equalsIgnoreCase("printshipmentnumberoninvoicenewline"))
      return printshipmentnumberoninvoicenewline;
    else if (fieldName.equalsIgnoreCase("printshipmentnumberoninvoicebold"))
      return printshipmentnumberoninvoicebold;
    else if (fieldName.equalsIgnoreCase("pshipnoinv_ordernum") || fieldName.equals("pshipnoinvOrdernum"))
      return pshipnoinvOrdernum;
    else if (fieldName.equalsIgnoreCase("printshipmentdateoninvoice"))
      return printshipmentdateoninvoice;
    else if (fieldName.equalsIgnoreCase("printshipmentdateoninvoicenewline"))
      return printshipmentdateoninvoicenewline;
    else if (fieldName.equalsIgnoreCase("printshipmentdateoninvoicebold"))
      return printshipmentdateoninvoicebold;
    else if (fieldName.equalsIgnoreCase("pshipdateinv_ordernum") || fieldName.equals("pshipdateinvOrdernum"))
      return pshipdateinvOrdernum;
    else if (fieldName.equalsIgnoreCase("printserialnumberondocs"))
      return printserialnumberondocs;
    else if (fieldName.equalsIgnoreCase("printsetproductwithbom"))
      return printsetproductwithbom;
    else if (fieldName.equalsIgnoreCase("printopenshipments"))
      return printopenshipments;
    else if (fieldName.equalsIgnoreCase("printcashdiscountinfo"))
      return printcashdiscountinfo;
    else if (fieldName.equalsIgnoreCase("printpnameondocs"))
      return printpnameondocs;
    else if (fieldName.equalsIgnoreCase("pname_ordernum") || fieldName.equals("pnameOrdernum"))
      return pnameOrdernum;
    else if (fieldName.equalsIgnoreCase("printpnamenewline"))
      return printpnamenewline;
    else if (fieldName.equalsIgnoreCase("printpnamebold"))
      return printpnamebold;
    else if (fieldName.equalsIgnoreCase("printpnumberondocs"))
      return printpnumberondocs;
    else if (fieldName.equalsIgnoreCase("pnumber_ordernum") || fieldName.equals("pnumberOrdernum"))
      return pnumberOrdernum;
    else if (fieldName.equalsIgnoreCase("printpnumbernewline"))
      return printpnumbernewline;
    else if (fieldName.equalsIgnoreCase("printpnumberbold"))
      return printpnumberbold;
    else if (fieldName.equalsIgnoreCase("printattrsondocs"))
      return printattrsondocs;
    else if (fieldName.equalsIgnoreCase("attrs_ordernum") || fieldName.equals("attrsOrdernum"))
      return attrsOrdernum;
    else if (fieldName.equalsIgnoreCase("printattrsnewline"))
      return printattrsnewline;
    else if (fieldName.equalsIgnoreCase("printattrsbold"))
      return printattrsbold;
    else if (fieldName.equalsIgnoreCase("printvpnumberondocs"))
      return printvpnumberondocs;
    else if (fieldName.equalsIgnoreCase("vpnumber_ordernum") || fieldName.equals("vpnumberOrdernum"))
      return vpnumberOrdernum;
    else if (fieldName.equalsIgnoreCase("printvpnumbernewline"))
      return printvpnumbernewline;
    else if (fieldName.equalsIgnoreCase("printvpnumberbold"))
      return printvpnumberbold;
    else if (fieldName.equalsIgnoreCase("printpdescondocs"))
      return printpdescondocs;
    else if (fieldName.equalsIgnoreCase("pdesc_ordernum") || fieldName.equals("pdescOrdernum"))
      return pdescOrdernum;
    else if (fieldName.equalsIgnoreCase("printpdescnewline"))
      return printpdescnewline;
    else if (fieldName.equalsIgnoreCase("printpdescbold"))
      return printpdescbold;
    else if (fieldName.equalsIgnoreCase("printdocnoteondocs"))
      return printdocnoteondocs;
    else if (fieldName.equalsIgnoreCase("docnote_ordernum") || fieldName.equals("docnoteOrdernum"))
      return docnoteOrdernum;
    else if (fieldName.equalsIgnoreCase("printdocnotenewline"))
      return printdocnotenewline;
    else if (fieldName.equalsIgnoreCase("printdocnotebold"))
      return printdocnotebold;
    else if (fieldName.equalsIgnoreCase("cpy_proddocnote2docnote") || fieldName.equals("cpyProddocnote2docnote"))
      return cpyProddocnote2docnote;
    else if (fieldName.equalsIgnoreCase("proddocnote_ordernum") || fieldName.equals("proddocnoteOrdernum"))
      return proddocnoteOrdernum;
    else if (fieldName.equalsIgnoreCase("cpy_proddesc2docnote") || fieldName.equals("cpyProddesc2docnote"))
      return cpyProddesc2docnote;
    else if (fieldName.equalsIgnoreCase("proddesc_ordernum") || fieldName.equals("proddescOrdernum"))
      return proddescOrdernum;
    else if (fieldName.equalsIgnoreCase("cpy_vendpnumber2docnote") || fieldName.equals("cpyVendpnumber2docnote"))
      return cpyVendpnumber2docnote;
    else if (fieldName.equalsIgnoreCase("vendpnumberdn_ordernum") || fieldName.equals("vendpnumberdnOrdernum"))
      return vendpnumberdnOrdernum;
    else if (fieldName.equalsIgnoreCase("performacedateoninvoice"))
      return performacedateoninvoice;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("address5"))
      return address5;
    else if (fieldName.equalsIgnoreCase("footer1"))
      return footer1;
    else if (fieldName.equalsIgnoreCase("onelineadr"))
      return onelineadr;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("footer2"))
      return footer2;
    else if (fieldName.equalsIgnoreCase("footer3"))
      return footer3;
    else if (fieldName.equalsIgnoreCase("zspr_printinfo_id") || fieldName.equals("zsprPrintinfoId"))
      return zsprPrintinfoId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("addressheader"))
      return addressheader;
    else if (fieldName.equalsIgnoreCase("footer5"))
      return footer5;
    else if (fieldName.equalsIgnoreCase("address7"))
      return address7;
    else if (fieldName.equalsIgnoreCase("address8"))
      return address8;
    else if (fieldName.equalsIgnoreCase("address6"))
      return address6;
    else if (fieldName.equalsIgnoreCase("address3"))
      return address3;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("address9"))
      return address9;
    else if (fieldName.equalsIgnoreCase("address4"))
      return address4;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("footer4"))
      return footer4;
    else if (fieldName.equalsIgnoreCase("isfootergroupstyle"))
      return isfootergroupstyle;
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
  public static PrintoutConfigurationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_org_id, String adOrgId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, ad_org_id, adOrgId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PrintoutConfigurationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_org_id, String adOrgId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspr_printinfo.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_printinfo.CreatedBy) as CreatedByR, " +
      "        to_char(zspr_printinfo.Updated, ?) as updated, " +
      "        to_char(zspr_printinfo.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspr_printinfo.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_printinfo.UpdatedBy) as UpdatedByR," +
      "        COALESCE(zspr_printinfo.Printordernumberoninvoice, 'N') AS Printordernumberoninvoice, " +
      "COALESCE(zspr_printinfo.Printordernumberoninvoicenewline, 'N') AS Printordernumberoninvoicenewline, " +
      "COALESCE(zspr_printinfo.Printordernumberoninvoicebold, 'N') AS Printordernumberoninvoicebold, " +
      "zspr_printinfo.Pordnoinv_Ordernum, " +
      "COALESCE(zspr_printinfo.Printordernumberonshipment, 'N') AS Printordernumberonshipment, " +
      "COALESCE(zspr_printinfo.Printordernumberonshipmentnewline, 'N') AS Printordernumberonshipmentnewline, " +
      "COALESCE(zspr_printinfo.Printordernumberonshipmentbold, 'N') AS Printordernumberonshipmentbold, " +
      "zspr_printinfo.Pordnoship_Ordernum, " +
      "COALESCE(zspr_printinfo.Printshipmentnumberoninvoice, 'N') AS Printshipmentnumberoninvoice, " +
      "COALESCE(zspr_printinfo.Printshipmentnumberoninvoicenewline, 'N') AS Printshipmentnumberoninvoicenewline, " +
      "COALESCE(zspr_printinfo.Printshipmentnumberoninvoicebold, 'N') AS Printshipmentnumberoninvoicebold, " +
      "zspr_printinfo.Pshipnoinv_Ordernum, " +
      "COALESCE(zspr_printinfo.Printshipmentdateoninvoice, 'N') AS Printshipmentdateoninvoice, " +
      "COALESCE(zspr_printinfo.Printshipmentdateoninvoicenewline, 'N') AS Printshipmentdateoninvoicenewline, " +
      "COALESCE(zspr_printinfo.Printshipmentdateoninvoicebold, 'N') AS Printshipmentdateoninvoicebold, " +
      "zspr_printinfo.Pshipdateinv_Ordernum, " +
      "COALESCE(zspr_printinfo.Printserialnumberondocs, 'N') AS Printserialnumberondocs, " +
      "COALESCE(zspr_printinfo.Printsetproductwithbom, 'N') AS Printsetproductwithbom, " +
      "COALESCE(zspr_printinfo.Printopenshipments, 'N') AS Printopenshipments, " +
      "COALESCE(zspr_printinfo.printcashdiscountinfo, 'N') AS printcashdiscountinfo, " +
      "COALESCE(zspr_printinfo.Printpnameondocs, 'N') AS Printpnameondocs, " +
      "zspr_printinfo.Pname_Ordernum, " +
      "COALESCE(zspr_printinfo.Printpnamenewline, 'N') AS Printpnamenewline, " +
      "COALESCE(zspr_printinfo.Printpnamebold, 'N') AS Printpnamebold, " +
      "COALESCE(zspr_printinfo.Printpnumberondocs, 'N') AS Printpnumberondocs, " +
      "zspr_printinfo.Pnumber_Ordernum, " +
      "COALESCE(zspr_printinfo.Printpnumbernewline, 'N') AS Printpnumbernewline, " +
      "COALESCE(zspr_printinfo.Printpnumberbold, 'N') AS Printpnumberbold, " +
      "COALESCE(zspr_printinfo.Printattrsondocs, 'N') AS Printattrsondocs, " +
      "zspr_printinfo.Attrs_Ordernum, " +
      "COALESCE(zspr_printinfo.Printattrsnewline, 'N') AS Printattrsnewline, " +
      "COALESCE(zspr_printinfo.Printattrsbold, 'N') AS Printattrsbold, " +
      "COALESCE(zspr_printinfo.Printvpnumberondocs, 'N') AS Printvpnumberondocs, " +
      "zspr_printinfo.Vpnumber_Ordernum, " +
      "COALESCE(zspr_printinfo.Printvpnumbernewline, 'N') AS Printvpnumbernewline, " +
      "COALESCE(zspr_printinfo.Printvpnumberbold, 'N') AS Printvpnumberbold, " +
      "COALESCE(zspr_printinfo.Printpdescondocs, 'N') AS Printpdescondocs, " +
      "zspr_printinfo.Pdesc_Ordernum, " +
      "COALESCE(zspr_printinfo.Printpdescnewline, 'N') AS Printpdescnewline, " +
      "COALESCE(zspr_printinfo.Printpdescbold, 'N') AS Printpdescbold, " +
      "COALESCE(zspr_printinfo.Printdocnoteondocs, 'N') AS Printdocnoteondocs, " +
      "zspr_printinfo.Docnote_Ordernum, " +
      "COALESCE(zspr_printinfo.Printdocnotenewline, 'N') AS Printdocnotenewline, " +
      "COALESCE(zspr_printinfo.Printdocnotebold, 'N') AS Printdocnotebold, " +
      "COALESCE(zspr_printinfo.CPY_Proddocnote2docnote, 'N') AS CPY_Proddocnote2docnote, " +
      "zspr_printinfo.Proddocnote_Ordernum, " +
      "COALESCE(zspr_printinfo.CPY_Proddesc2docnote, 'N') AS CPY_Proddesc2docnote, " +
      "zspr_printinfo.Proddesc_Ordernum, " +
      "COALESCE(zspr_printinfo.CPY_Vendpnumber2docnote, 'N') AS CPY_Vendpnumber2docnote, " +
      "zspr_printinfo.Vendpnumberdn_Ordernum, " +
      "COALESCE(zspr_printinfo.performacedateoninvoice, 'N') AS performacedateoninvoice, " +
      "COALESCE(zspr_printinfo.Isactive, 'N') AS Isactive, " +
      "zspr_printinfo.Address5, " +
      "zspr_printinfo.Footer1, " +
      "zspr_printinfo.Onelineadr, " +
      "zspr_printinfo.Address1, " +
      "zspr_printinfo.Footer2, " +
      "zspr_printinfo.Footer3, " +
      "zspr_printinfo.Zspr_Printinfo_ID, " +
      "zspr_printinfo.AD_Client_ID, " +
      "zspr_printinfo.Addressheader, " +
      "zspr_printinfo.Footer5, " +
      "zspr_printinfo.Address7, " +
      "zspr_printinfo.Address8, " +
      "zspr_printinfo.Address6, " +
      "zspr_printinfo.Address3, " +
      "zspr_printinfo.AD_Org_ID, " +
      "zspr_printinfo.Address9, " +
      "zspr_printinfo.Address4, " +
      "zspr_printinfo.Address2, " +
      "zspr_printinfo.Footer4, " +
      "COALESCE(zspr_printinfo.Isfootergroupstyle, 'N') AS Isfootergroupstyle, " +
      "        ? AS LANGUAGE " +
      "        FROM zspr_printinfo" +
      "        WHERE 2=2 " +
      " AND zspr_printinfo.ad_org_id=?" +
      "        AND 1=1 ";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":"  AND zspr_printinfo.AD_Org_ID = ?  ");
    strSql = strSql + 
      "        AND zspr_printinfo.Zspr_Printinfo_ID = ? " +
      "        AND zspr_printinfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspr_printinfo.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
        PrintoutConfigurationData objectPrintoutConfigurationData = new PrintoutConfigurationData();
        objectPrintoutConfigurationData.created = UtilSql.getValue(result, "created");
        objectPrintoutConfigurationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPrintoutConfigurationData.updated = UtilSql.getValue(result, "updated");
        objectPrintoutConfigurationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPrintoutConfigurationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPrintoutConfigurationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPrintoutConfigurationData.printordernumberoninvoice = UtilSql.getValue(result, "printordernumberoninvoice");
        objectPrintoutConfigurationData.printordernumberoninvoicenewline = UtilSql.getValue(result, "printordernumberoninvoicenewline");
        objectPrintoutConfigurationData.printordernumberoninvoicebold = UtilSql.getValue(result, "printordernumberoninvoicebold");
        objectPrintoutConfigurationData.pordnoinvOrdernum = UtilSql.getValue(result, "pordnoinv_ordernum");
        objectPrintoutConfigurationData.printordernumberonshipment = UtilSql.getValue(result, "printordernumberonshipment");
        objectPrintoutConfigurationData.printordernumberonshipmentnewline = UtilSql.getValue(result, "printordernumberonshipmentnewline");
        objectPrintoutConfigurationData.printordernumberonshipmentbold = UtilSql.getValue(result, "printordernumberonshipmentbold");
        objectPrintoutConfigurationData.pordnoshipOrdernum = UtilSql.getValue(result, "pordnoship_ordernum");
        objectPrintoutConfigurationData.printshipmentnumberoninvoice = UtilSql.getValue(result, "printshipmentnumberoninvoice");
        objectPrintoutConfigurationData.printshipmentnumberoninvoicenewline = UtilSql.getValue(result, "printshipmentnumberoninvoicenewline");
        objectPrintoutConfigurationData.printshipmentnumberoninvoicebold = UtilSql.getValue(result, "printshipmentnumberoninvoicebold");
        objectPrintoutConfigurationData.pshipnoinvOrdernum = UtilSql.getValue(result, "pshipnoinv_ordernum");
        objectPrintoutConfigurationData.printshipmentdateoninvoice = UtilSql.getValue(result, "printshipmentdateoninvoice");
        objectPrintoutConfigurationData.printshipmentdateoninvoicenewline = UtilSql.getValue(result, "printshipmentdateoninvoicenewline");
        objectPrintoutConfigurationData.printshipmentdateoninvoicebold = UtilSql.getValue(result, "printshipmentdateoninvoicebold");
        objectPrintoutConfigurationData.pshipdateinvOrdernum = UtilSql.getValue(result, "pshipdateinv_ordernum");
        objectPrintoutConfigurationData.printserialnumberondocs = UtilSql.getValue(result, "printserialnumberondocs");
        objectPrintoutConfigurationData.printsetproductwithbom = UtilSql.getValue(result, "printsetproductwithbom");
        objectPrintoutConfigurationData.printopenshipments = UtilSql.getValue(result, "printopenshipments");
        objectPrintoutConfigurationData.printcashdiscountinfo = UtilSql.getValue(result, "printcashdiscountinfo");
        objectPrintoutConfigurationData.printpnameondocs = UtilSql.getValue(result, "printpnameondocs");
        objectPrintoutConfigurationData.pnameOrdernum = UtilSql.getValue(result, "pname_ordernum");
        objectPrintoutConfigurationData.printpnamenewline = UtilSql.getValue(result, "printpnamenewline");
        objectPrintoutConfigurationData.printpnamebold = UtilSql.getValue(result, "printpnamebold");
        objectPrintoutConfigurationData.printpnumberondocs = UtilSql.getValue(result, "printpnumberondocs");
        objectPrintoutConfigurationData.pnumberOrdernum = UtilSql.getValue(result, "pnumber_ordernum");
        objectPrintoutConfigurationData.printpnumbernewline = UtilSql.getValue(result, "printpnumbernewline");
        objectPrintoutConfigurationData.printpnumberbold = UtilSql.getValue(result, "printpnumberbold");
        objectPrintoutConfigurationData.printattrsondocs = UtilSql.getValue(result, "printattrsondocs");
        objectPrintoutConfigurationData.attrsOrdernum = UtilSql.getValue(result, "attrs_ordernum");
        objectPrintoutConfigurationData.printattrsnewline = UtilSql.getValue(result, "printattrsnewline");
        objectPrintoutConfigurationData.printattrsbold = UtilSql.getValue(result, "printattrsbold");
        objectPrintoutConfigurationData.printvpnumberondocs = UtilSql.getValue(result, "printvpnumberondocs");
        objectPrintoutConfigurationData.vpnumberOrdernum = UtilSql.getValue(result, "vpnumber_ordernum");
        objectPrintoutConfigurationData.printvpnumbernewline = UtilSql.getValue(result, "printvpnumbernewline");
        objectPrintoutConfigurationData.printvpnumberbold = UtilSql.getValue(result, "printvpnumberbold");
        objectPrintoutConfigurationData.printpdescondocs = UtilSql.getValue(result, "printpdescondocs");
        objectPrintoutConfigurationData.pdescOrdernum = UtilSql.getValue(result, "pdesc_ordernum");
        objectPrintoutConfigurationData.printpdescnewline = UtilSql.getValue(result, "printpdescnewline");
        objectPrintoutConfigurationData.printpdescbold = UtilSql.getValue(result, "printpdescbold");
        objectPrintoutConfigurationData.printdocnoteondocs = UtilSql.getValue(result, "printdocnoteondocs");
        objectPrintoutConfigurationData.docnoteOrdernum = UtilSql.getValue(result, "docnote_ordernum");
        objectPrintoutConfigurationData.printdocnotenewline = UtilSql.getValue(result, "printdocnotenewline");
        objectPrintoutConfigurationData.printdocnotebold = UtilSql.getValue(result, "printdocnotebold");
        objectPrintoutConfigurationData.cpyProddocnote2docnote = UtilSql.getValue(result, "cpy_proddocnote2docnote");
        objectPrintoutConfigurationData.proddocnoteOrdernum = UtilSql.getValue(result, "proddocnote_ordernum");
        objectPrintoutConfigurationData.cpyProddesc2docnote = UtilSql.getValue(result, "cpy_proddesc2docnote");
        objectPrintoutConfigurationData.proddescOrdernum = UtilSql.getValue(result, "proddesc_ordernum");
        objectPrintoutConfigurationData.cpyVendpnumber2docnote = UtilSql.getValue(result, "cpy_vendpnumber2docnote");
        objectPrintoutConfigurationData.vendpnumberdnOrdernum = UtilSql.getValue(result, "vendpnumberdn_ordernum");
        objectPrintoutConfigurationData.performacedateoninvoice = UtilSql.getValue(result, "performacedateoninvoice");
        objectPrintoutConfigurationData.isactive = UtilSql.getValue(result, "isactive");
        objectPrintoutConfigurationData.address5 = UtilSql.getValue(result, "address5");
        objectPrintoutConfigurationData.footer1 = UtilSql.getValue(result, "footer1");
        objectPrintoutConfigurationData.onelineadr = UtilSql.getValue(result, "onelineadr");
        objectPrintoutConfigurationData.address1 = UtilSql.getValue(result, "address1");
        objectPrintoutConfigurationData.footer2 = UtilSql.getValue(result, "footer2");
        objectPrintoutConfigurationData.footer3 = UtilSql.getValue(result, "footer3");
        objectPrintoutConfigurationData.zsprPrintinfoId = UtilSql.getValue(result, "zspr_printinfo_id");
        objectPrintoutConfigurationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPrintoutConfigurationData.addressheader = UtilSql.getValue(result, "addressheader");
        objectPrintoutConfigurationData.footer5 = UtilSql.getValue(result, "footer5");
        objectPrintoutConfigurationData.address7 = UtilSql.getValue(result, "address7");
        objectPrintoutConfigurationData.address8 = UtilSql.getValue(result, "address8");
        objectPrintoutConfigurationData.address6 = UtilSql.getValue(result, "address6");
        objectPrintoutConfigurationData.address3 = UtilSql.getValue(result, "address3");
        objectPrintoutConfigurationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPrintoutConfigurationData.address9 = UtilSql.getValue(result, "address9");
        objectPrintoutConfigurationData.address4 = UtilSql.getValue(result, "address4");
        objectPrintoutConfigurationData.address2 = UtilSql.getValue(result, "address2");
        objectPrintoutConfigurationData.footer4 = UtilSql.getValue(result, "footer4");
        objectPrintoutConfigurationData.isfootergroupstyle = UtilSql.getValue(result, "isfootergroupstyle");
        objectPrintoutConfigurationData.language = UtilSql.getValue(result, "language");
        objectPrintoutConfigurationData.adUserClient = "";
        objectPrintoutConfigurationData.adOrgClient = "";
        objectPrintoutConfigurationData.createdby = "";
        objectPrintoutConfigurationData.trBgcolor = "";
        objectPrintoutConfigurationData.totalCount = "";
        objectPrintoutConfigurationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintoutConfigurationData);
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
    PrintoutConfigurationData objectPrintoutConfigurationData[] = new PrintoutConfigurationData[vector.size()];
    vector.copyInto(objectPrintoutConfigurationData);
    return(objectPrintoutConfigurationData);
  }

/**
Create a registry
 */
  public static PrintoutConfigurationData[] set(String adOrgId, String pnumberOrdernum, String isactive, String attrsOrdernum, String printopenshipments, String proddocnoteOrdernum, String printpnumberondocs, String zsprPrintinfoId, String printordernumberonshipmentbold, String printpnumbernewline, String pordnoinvOrdernum, String address6, String vendpnumberdnOrdernum, String printshipmentdateoninvoicebold, String address4, String printordernumberonshipmentnewline, String printordernumberonshipment, String printsetproductwithbom, String printshipmentnumberoninvoicenewline, String printshipmentnumberoninvoice, String pshipnoinvOrdernum, String printpnamebold, String footer2, String address5, String printpnamenewline, String adClientId, String address7, String footer4, String pshipdateinvOrdernum, String isfootergroupstyle, String pordnoshipOrdernum, String onelineadr, String printordernumberoninvoicenewline, String address2, String pdescOrdernum, String printvpnumbernewline, String pnameOrdernum, String printshipmentnumberoninvoicebold, String footer3, String printdocnotenewline, String updatedby, String updatedbyr, String printdocnotebold, String proddescOrdernum, String printserialnumberondocs, String docnoteOrdernum, String printordernumberoninvoicebold, String footer5, String printattrsbold, String printpdescondocs, String printpnameondocs, String address8, String cpyProddocnote2docnote, String printdocnoteondocs, String cpyProddesc2docnote, String footer1, String printshipmentdateoninvoicenewline, String vpnumberOrdernum, String printcashdiscountinfo, String performacedateoninvoice, String addressheader, String printpnumberbold, String printvpnumberbold, String printvpnumberondocs, String address9, String printattrsnewline, String createdby, String createdbyr, String printpdescnewline, String cpyVendpnumber2docnote, String printordernumberoninvoice, String printpdescbold, String printattrsondocs, String printshipmentdateoninvoice, String address3, String address1)    throws ServletException {
    PrintoutConfigurationData objectPrintoutConfigurationData[] = new PrintoutConfigurationData[1];
    objectPrintoutConfigurationData[0] = new PrintoutConfigurationData();
    objectPrintoutConfigurationData[0].created = "";
    objectPrintoutConfigurationData[0].createdbyr = createdbyr;
    objectPrintoutConfigurationData[0].updated = "";
    objectPrintoutConfigurationData[0].updatedTimeStamp = "";
    objectPrintoutConfigurationData[0].updatedby = updatedby;
    objectPrintoutConfigurationData[0].updatedbyr = updatedbyr;
    objectPrintoutConfigurationData[0].printordernumberoninvoice = printordernumberoninvoice;
    objectPrintoutConfigurationData[0].printordernumberoninvoicenewline = printordernumberoninvoicenewline;
    objectPrintoutConfigurationData[0].printordernumberoninvoicebold = printordernumberoninvoicebold;
    objectPrintoutConfigurationData[0].pordnoinvOrdernum = pordnoinvOrdernum;
    objectPrintoutConfigurationData[0].printordernumberonshipment = printordernumberonshipment;
    objectPrintoutConfigurationData[0].printordernumberonshipmentnewline = printordernumberonshipmentnewline;
    objectPrintoutConfigurationData[0].printordernumberonshipmentbold = printordernumberonshipmentbold;
    objectPrintoutConfigurationData[0].pordnoshipOrdernum = pordnoshipOrdernum;
    objectPrintoutConfigurationData[0].printshipmentnumberoninvoice = printshipmentnumberoninvoice;
    objectPrintoutConfigurationData[0].printshipmentnumberoninvoicenewline = printshipmentnumberoninvoicenewline;
    objectPrintoutConfigurationData[0].printshipmentnumberoninvoicebold = printshipmentnumberoninvoicebold;
    objectPrintoutConfigurationData[0].pshipnoinvOrdernum = pshipnoinvOrdernum;
    objectPrintoutConfigurationData[0].printshipmentdateoninvoice = printshipmentdateoninvoice;
    objectPrintoutConfigurationData[0].printshipmentdateoninvoicenewline = printshipmentdateoninvoicenewline;
    objectPrintoutConfigurationData[0].printshipmentdateoninvoicebold = printshipmentdateoninvoicebold;
    objectPrintoutConfigurationData[0].pshipdateinvOrdernum = pshipdateinvOrdernum;
    objectPrintoutConfigurationData[0].printserialnumberondocs = printserialnumberondocs;
    objectPrintoutConfigurationData[0].printsetproductwithbom = printsetproductwithbom;
    objectPrintoutConfigurationData[0].printopenshipments = printopenshipments;
    objectPrintoutConfigurationData[0].printcashdiscountinfo = printcashdiscountinfo;
    objectPrintoutConfigurationData[0].printpnameondocs = printpnameondocs;
    objectPrintoutConfigurationData[0].pnameOrdernum = pnameOrdernum;
    objectPrintoutConfigurationData[0].printpnamenewline = printpnamenewline;
    objectPrintoutConfigurationData[0].printpnamebold = printpnamebold;
    objectPrintoutConfigurationData[0].printpnumberondocs = printpnumberondocs;
    objectPrintoutConfigurationData[0].pnumberOrdernum = pnumberOrdernum;
    objectPrintoutConfigurationData[0].printpnumbernewline = printpnumbernewline;
    objectPrintoutConfigurationData[0].printpnumberbold = printpnumberbold;
    objectPrintoutConfigurationData[0].printattrsondocs = printattrsondocs;
    objectPrintoutConfigurationData[0].attrsOrdernum = attrsOrdernum;
    objectPrintoutConfigurationData[0].printattrsnewline = printattrsnewline;
    objectPrintoutConfigurationData[0].printattrsbold = printattrsbold;
    objectPrintoutConfigurationData[0].printvpnumberondocs = printvpnumberondocs;
    objectPrintoutConfigurationData[0].vpnumberOrdernum = vpnumberOrdernum;
    objectPrintoutConfigurationData[0].printvpnumbernewline = printvpnumbernewline;
    objectPrintoutConfigurationData[0].printvpnumberbold = printvpnumberbold;
    objectPrintoutConfigurationData[0].printpdescondocs = printpdescondocs;
    objectPrintoutConfigurationData[0].pdescOrdernum = pdescOrdernum;
    objectPrintoutConfigurationData[0].printpdescnewline = printpdescnewline;
    objectPrintoutConfigurationData[0].printpdescbold = printpdescbold;
    objectPrintoutConfigurationData[0].printdocnoteondocs = printdocnoteondocs;
    objectPrintoutConfigurationData[0].docnoteOrdernum = docnoteOrdernum;
    objectPrintoutConfigurationData[0].printdocnotenewline = printdocnotenewline;
    objectPrintoutConfigurationData[0].printdocnotebold = printdocnotebold;
    objectPrintoutConfigurationData[0].cpyProddocnote2docnote = cpyProddocnote2docnote;
    objectPrintoutConfigurationData[0].proddocnoteOrdernum = proddocnoteOrdernum;
    objectPrintoutConfigurationData[0].cpyProddesc2docnote = cpyProddesc2docnote;
    objectPrintoutConfigurationData[0].proddescOrdernum = proddescOrdernum;
    objectPrintoutConfigurationData[0].cpyVendpnumber2docnote = cpyVendpnumber2docnote;
    objectPrintoutConfigurationData[0].vendpnumberdnOrdernum = vendpnumberdnOrdernum;
    objectPrintoutConfigurationData[0].performacedateoninvoice = performacedateoninvoice;
    objectPrintoutConfigurationData[0].isactive = isactive;
    objectPrintoutConfigurationData[0].address5 = address5;
    objectPrintoutConfigurationData[0].footer1 = footer1;
    objectPrintoutConfigurationData[0].onelineadr = onelineadr;
    objectPrintoutConfigurationData[0].address1 = address1;
    objectPrintoutConfigurationData[0].footer2 = footer2;
    objectPrintoutConfigurationData[0].footer3 = footer3;
    objectPrintoutConfigurationData[0].zsprPrintinfoId = zsprPrintinfoId;
    objectPrintoutConfigurationData[0].adClientId = adClientId;
    objectPrintoutConfigurationData[0].addressheader = addressheader;
    objectPrintoutConfigurationData[0].footer5 = footer5;
    objectPrintoutConfigurationData[0].address7 = address7;
    objectPrintoutConfigurationData[0].address8 = address8;
    objectPrintoutConfigurationData[0].address6 = address6;
    objectPrintoutConfigurationData[0].address3 = address3;
    objectPrintoutConfigurationData[0].adOrgId = adOrgId;
    objectPrintoutConfigurationData[0].address9 = address9;
    objectPrintoutConfigurationData[0].address4 = address4;
    objectPrintoutConfigurationData[0].address2 = address2;
    objectPrintoutConfigurationData[0].footer4 = footer4;
    objectPrintoutConfigurationData[0].isfootergroupstyle = isfootergroupstyle;
    objectPrintoutConfigurationData[0].language = "";
    return objectPrintoutConfigurationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef0B4283540BB5418C96C64D3C5267880F_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDefC6E91D721EF847E2BCEE9A2CD6253DED_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zspr_printinfo.AD_Org_ID AS NAME" +
      "        FROM zspr_printinfo" +
      "        WHERE zspr_printinfo.Zspr_Printinfo_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Org left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Org.AD_Org_ID = table1.AD_Org_ID) WHERE AD_Org.AD_Org_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Org left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Org.AD_Org_ID = table1.AD_Org_ID) WHERE AD_Org.AD_Org_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

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
      "        UPDATE zspr_printinfo" +
      "        SET Printordernumberoninvoice = (?) , Printordernumberoninvoicenewline = (?) , Printordernumberoninvoicebold = (?) , Pordnoinv_Ordernum = TO_NUMBER(?) , Printordernumberonshipment = (?) , Printordernumberonshipmentnewline = (?) , Printordernumberonshipmentbold = (?) , Pordnoship_Ordernum = TO_NUMBER(?) , Printshipmentnumberoninvoice = (?) , Printshipmentnumberoninvoicenewline = (?) , Printshipmentnumberoninvoicebold = (?) , Pshipnoinv_Ordernum = TO_NUMBER(?) , Printshipmentdateoninvoice = (?) , Printshipmentdateoninvoicenewline = (?) , Printshipmentdateoninvoicebold = (?) , Pshipdateinv_Ordernum = TO_NUMBER(?) , Printserialnumberondocs = (?) , Printsetproductwithbom = (?) , Printopenshipments = (?) , printcashdiscountinfo = (?) , Printpnameondocs = (?) , Pname_Ordernum = TO_NUMBER(?) , Printpnamenewline = (?) , Printpnamebold = (?) , Printpnumberondocs = (?) , Pnumber_Ordernum = TO_NUMBER(?) , Printpnumbernewline = (?) , Printpnumberbold = (?) , Printattrsondocs = (?) , Attrs_Ordernum = TO_NUMBER(?) , Printattrsnewline = (?) , Printattrsbold = (?) , Printvpnumberondocs = (?) , Vpnumber_Ordernum = TO_NUMBER(?) , Printvpnumbernewline = (?) , Printvpnumberbold = (?) , Printpdescondocs = (?) , Pdesc_Ordernum = TO_NUMBER(?) , Printpdescnewline = (?) , Printpdescbold = (?) , Printdocnoteondocs = (?) , Docnote_Ordernum = TO_NUMBER(?) , Printdocnotenewline = (?) , Printdocnotebold = (?) , CPY_Proddocnote2docnote = (?) , Proddocnote_Ordernum = TO_NUMBER(?) , CPY_Proddesc2docnote = (?) , Proddesc_Ordernum = TO_NUMBER(?) , CPY_Vendpnumber2docnote = (?) , Vendpnumberdn_Ordernum = TO_NUMBER(?) , performacedateoninvoice = (?) , Isactive = (?) , Address5 = (?) , Footer1 = (?) , Onelineadr = (?) , Address1 = (?) , Footer2 = (?) , Footer3 = (?) , Zspr_Printinfo_ID = (?) , AD_Client_ID = (?) , Addressheader = (?) , Footer5 = (?) , Address7 = (?) , Address8 = (?) , Address6 = (?) , Address3 = (?) , AD_Org_ID = (?) , Address9 = (?) , Address4 = (?) , Address2 = (?) , Footer4 = (?) , Isfootergroupstyle = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspr_printinfo.Zspr_Printinfo_ID = ? " +
      "                 AND zspr_printinfo.AD_Org_ID = ? " +
      "        AND zspr_printinfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_printinfo.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberoninvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberoninvoicenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberoninvoicebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pordnoinvOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberonshipment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberonshipmentnewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberonshipmentbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pordnoshipOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentnumberoninvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentnumberoninvoicenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentnumberoninvoicebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pshipnoinvOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentdateoninvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentdateoninvoicenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentdateoninvoicebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pshipdateinvOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printserialnumberondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printsetproductwithbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printopenshipments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printcashdiscountinfo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnameondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pnameOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnamenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnamebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnumberondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pnumberOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnumbernewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnumberbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printattrsondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, attrsOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printattrsnewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printattrsbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printvpnumberondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vpnumberOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printvpnumbernewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printvpnumberbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpdescondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pdescOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpdescnewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpdescbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printdocnoteondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docnoteOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printdocnotenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printdocnotebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cpyProddocnote2docnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proddocnoteOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cpyProddesc2docnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proddescOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cpyVendpnumber2docnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendpnumberdnOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performacedateoninvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onelineadr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprPrintinfoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addressheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address8);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address9);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfootergroupstyle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprPrintinfoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        INSERT INTO zspr_printinfo " +
      "        (Printordernumberoninvoice, Printordernumberoninvoicenewline, Printordernumberoninvoicebold, Pordnoinv_Ordernum, Printordernumberonshipment, Printordernumberonshipmentnewline, Printordernumberonshipmentbold, Pordnoship_Ordernum, Printshipmentnumberoninvoice, Printshipmentnumberoninvoicenewline, Printshipmentnumberoninvoicebold, Pshipnoinv_Ordernum, Printshipmentdateoninvoice, Printshipmentdateoninvoicenewline, Printshipmentdateoninvoicebold, Pshipdateinv_Ordernum, Printserialnumberondocs, Printsetproductwithbom, Printopenshipments, printcashdiscountinfo, Printpnameondocs, Pname_Ordernum, Printpnamenewline, Printpnamebold, Printpnumberondocs, Pnumber_Ordernum, Printpnumbernewline, Printpnumberbold, Printattrsondocs, Attrs_Ordernum, Printattrsnewline, Printattrsbold, Printvpnumberondocs, Vpnumber_Ordernum, Printvpnumbernewline, Printvpnumberbold, Printpdescondocs, Pdesc_Ordernum, Printpdescnewline, Printpdescbold, Printdocnoteondocs, Docnote_Ordernum, Printdocnotenewline, Printdocnotebold, CPY_Proddocnote2docnote, Proddocnote_Ordernum, CPY_Proddesc2docnote, Proddesc_Ordernum, CPY_Vendpnumber2docnote, Vendpnumberdn_Ordernum, performacedateoninvoice, Isactive, Address5, Footer1, Onelineadr, Address1, Footer2, Footer3, Zspr_Printinfo_ID, AD_Client_ID, Addressheader, Footer5, Address7, Address8, Address6, Address3, AD_Org_ID, Address9, Address4, Address2, Footer4, Isfootergroupstyle, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberoninvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberoninvoicenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberoninvoicebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pordnoinvOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberonshipment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberonshipmentnewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printordernumberonshipmentbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pordnoshipOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentnumberoninvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentnumberoninvoicenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentnumberoninvoicebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pshipnoinvOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentdateoninvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentdateoninvoicenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printshipmentdateoninvoicebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pshipdateinvOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printserialnumberondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printsetproductwithbom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printopenshipments);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printcashdiscountinfo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnameondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pnameOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnamenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnamebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnumberondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pnumberOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnumbernewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpnumberbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printattrsondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, attrsOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printattrsnewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printattrsbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printvpnumberondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vpnumberOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printvpnumbernewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printvpnumberbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpdescondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pdescOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpdescnewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printpdescbold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printdocnoteondocs);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docnoteOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printdocnotenewline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, printdocnotebold);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cpyProddocnote2docnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proddocnoteOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cpyProddesc2docnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proddescOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cpyVendpnumber2docnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendpnumberdnOrdernum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, performacedateoninvoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onelineadr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprPrintinfoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addressheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address8);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address9);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footer4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfootergroupstyle);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adOrgId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_printinfo" +
      "        WHERE zspr_printinfo.Zspr_Printinfo_ID = ? " +
      "                 AND zspr_printinfo.AD_Org_ID = ? " +
      "        AND zspr_printinfo.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_printinfo.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_printinfo" +
      "        WHERE zspr_printinfo.Zspr_Printinfo_ID = ? " +
      "                 AND zspr_printinfo.AD_Org_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM zspr_printinfo" +
      "         WHERE zspr_printinfo.Zspr_Printinfo_ID = ? ";

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
      "          FROM zspr_printinfo" +
      "         WHERE zspr_printinfo.Zspr_Printinfo_ID = ? ";

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

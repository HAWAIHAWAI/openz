/*
  ***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011-2012 Stefan Zimmermann
****************************************************************************************************************************************************

 */

package org.openbravo.erpCommon.ad_forms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.StringTokenizer;
import org.openbravo.utils.Replace;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.businessUtility.Tree;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.reference.ActionButtonData;
import org.openbravo.erpCommon.reference.PInstanceProcessData;
import org.openbravo.erpCommon.utility.ComboTableData;
import org.openbravo.erpCommon.utility.DateTimeData;
import org.openbravo.erpCommon.utility.LeftTabsBar;
import org.openbravo.erpCommon.utility.NavigationBar;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.ToolBar;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.exception.NoConnectionAvailableException;
import org.openbravo.xmlEngine.XmlDocument;

public class GenerateInvoicesmanual extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

 
  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
	  Integer line=0;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    if (vars.commandIn("DEFAULT")) {
      
      String strDateFrom = vars.getGlobalVariable("inpDateFrom", "GenerateInvoicesmanual|DateFrom",
          "");
      String strDateTo = vars.getGlobalVariable("inpDateTo", "GenerateInvoicesmanual|DateTo", "");
      String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId",
          "GenerateInvoicesmanual|C_BPartner_ID", "");
      String strAD_Org_ID = vars.getGlobalVariable("inpadOrgId",
          "GenerateInvoicesmanual|Ad_Org_ID", vars.getOrg());
      String strIsSOtrx=vars.getSessionValue("issotrx");
      printPageDataSheet(response, vars, strC_BPartner_ID, strAD_Org_ID, strDateFrom, strDateTo,
    		  strIsSOtrx);
    } else if (vars.commandIn("FIND")) {
      String strDateFrom = vars.getRequestGlobalVariable("inpDateFrom",
          "GenerateInvoicesmanual|DateFrom");
      String strDateTo = vars
          .getRequestGlobalVariable("inpDateTo", "GenerateInvoicesmanual|DateTo");
      String strC_BPartner_ID = vars.getRequestGlobalVariable("inpcBpartnerId",
          "GenerateInvoicesmanual|C_BPartner_ID");
      String strAD_Org_ID = vars.getRequestGlobalVariable("inpadOrgId",
          "GenerateInvoicesmanual|Ad_Org_ID");
      String strIsSOtrx=vars.getSessionValue("issotrx");
      printPageDataSheet(response, vars, strC_BPartner_ID, strAD_Org_ID, strDateFrom, strDateTo,
          strIsSOtrx);
    } else if (vars.commandIn("GENERATE")) {
      String strCOrderId = vars.getInStringParameter("inpOrder", IsIDFilter.instance);
      String strAD_Org_ID = vars.getGlobalVariable("inpadOrgId",
          "GenerateInvoicesmanual|Ad_Org_ID", vars.getOrg());
      Connection conn = null;
      OBError myMessage = new OBError();
      String pinstance = SequenceIdData.getUUID(); 
      int dummy;
    try {
      conn= this.getTransactionConnection();
      
      
      
      if (!strCOrderId.equals("")) {
        strCOrderId = Replace.replace(strCOrderId, "'", "");
        strCOrderId = Replace.replace(strCOrderId, "(", "");
        strCOrderId = Replace.replace(strCOrderId, ")", "");
        StringTokenizer st = new StringTokenizer(strCOrderId, ",", false);
        while (st.hasMoreTokens()) {
          String strOrderId = st.nextToken().trim();
          String ordlineIsSelected=vars.getInStringParameter("inpCOrderlines"+strOrderId, IsIDFilter.instance);
          if (!ordlineIsSelected.equals("")) {
            ordlineIsSelected = Replace.replace(ordlineIsSelected, "'", "");
            ordlineIsSelected = Replace.replace(ordlineIsSelected, "(", "");
            ordlineIsSelected = Replace.replace(ordlineIsSelected, ")", "");
            StringTokenizer st1 = new StringTokenizer(ordlineIsSelected, ",", false);
            line=10;
            while (st1.hasMoreTokens()) {
              String ordline = st1.nextToken().trim();
              //GenerateInvoicesmanualData[] data= GenerateInvoicesmanualData.select(this, ordline);
              String ordlineQty=vars.getNumericParameter("inpQtyordered"+ordline);
              String ordlinePrice=vars.getNumericParameter("inpPriceNetVal"+ordline);
              String ordlineIgnoreResDue=vars.getStringParameter("residue"+ordline);
              String ordlinemInoutlineId=vars.getStringParameter("inpmInoutlineId"+ordline);
              String ordlineDesc=vars.getStringParameter("inpOldesc"+ordline);
              // a hidden field represents the real orderline id, the key ordline is composed from orderline and minoutline, though an orderline can have many goods movements.
              String ordlineIdKey=vars.getStringParameter("inpcOrderlineIdkey"+ordline);
              if (ordlineIgnoreResDue.isEmpty())
                ordlineIgnoreResDue="N";
              String ordlineLineamt=vars.getNumericParameter("inpSumCalc"+ordline);
              //String ordlinePendingPrice=vars.getInStringParameter("inpPendingLinePrice"+ordline);
                           
              String strCGenerateInvoicesmanualId = SequenceIdData.getUUID();
              //String ordlinePrice=vars.getInStringParameter("inpQtyordered"+ordline);
                	 
            	 	GenerateInvoicesmanualData.insert(conn,this, strCGenerateInvoicesmanualId,
            	 	 ordlineIdKey,
            		 strOrderId,
            		 vars.getClient(), strAD_Org_ID, vars.getUser(), vars.getUser(),
            		 ordlineQty, 
            		 ordlinePrice,
            		 ordlineLineamt,
            		 ordlineIgnoreResDue, ordlineDesc,
            		 ordlinemInoutlineId, pinstance); 
               line += 10;
            	 	 
              } 
            
            
                     
            }
          }
        }
      releaseCommitConnection(conn);
      }
    catch (Exception ex){
        myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
        try {
		releaseRollbackConnection(conn);
		} catch (SQLException e) {
					e.printStackTrace();
					myMessage = Utility.translateError(this, vars, vars.getLanguage(), e.getMessage());
		}
        vars.setMessage("GenerateInvoicesmanual", myMessage);
        response.sendRedirect(strDireccion + request.getServletPath());
        return;
	}
      
      
      
      
      PInstanceProcessData.insertPInstance(this, pinstance, "134", "0", "N", vars.getUser(), vars
          .getClient(), vars.getOrg());
      PInstanceProcessData.insertPInstanceParam(this, pinstance, "1", "Selection", "Y", vars
          .getClient(), vars.getOrg(), vars.getUser());
      ActionButtonData.process134(this, pinstance);
      PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
      String message = "";
      myMessage.setTitle("");
      
      if (pinstanceData != null && pinstanceData.length > 0 && pinstanceData[0].result.equals("1")) {
        if (!pinstanceData[0].errormsg.equals("")) {
          message = pinstanceData[0].errormsg;
          myMessage.setType("Success");
          myMessage.setTitle(Utility.messageBD(this, "Success", vars.getLanguage()));
          if (message.startsWith("@") && message.endsWith("@")) {
            myMessage.setMessage(message.substring(1, message.length() - 1));
            if (message.indexOf("@") == -1)
              myMessage.setMessage(Utility.messageBD(this, message, vars.getLanguage()));
            else
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), "@"
                  + message + "@"));
          } else
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), message));
        } else if (!pinstanceData[0].pMsg.equals("")) {
          myMessage.setType("Success");
          myMessage.setTitle(Utility.messageBD(this, "Success", vars.getLanguage()));
          message = pinstanceData[0].pMsg;
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), message));
        } else if (pinstanceData[0].result.equals("1")) {
          myMessage.setType("Success");
          myMessage.setTitle(Utility.messageBD(this, "Success", vars.getLanguage()));
          myMessage.setMessage(Utility.messageBD(this, "Success", vars.getLanguage()));
        } else {
          myMessage.setType("Error");
          myMessage.setTitle(Utility.messageBD(this, "Error", vars.getLanguage()));
          myMessage.setMessage(Utility.messageBD(this, "Error", vars.getLanguage()));
          
        }
      }
      else {
        myMessage.setType("Error");
        myMessage.setTitle(Utility.messageBD(this, "Error", vars.getLanguage()));
        myMessage.setMessage(pinstanceData[0].errormsg);
      }
      dummy=GenerateInvoicesmanualData.deleteerror(this,pinstance);
      vars.setMessage("GenerateInvoicesmanual", myMessage);
 //     GenerateInvoicesmanualData.resetSelection(this, strCOrderId.equals("") ? "('0')" : strCOrderId);
      if (log4j.isDebugEnabled())
        log4j.debug(message);
      response.sendRedirect(strDireccion + request.getServletPath());
    } else
      pageError(response);
    }
  

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars,
      String strC_BPartner_ID, String strAD_Org_ID, String strDateFrom, String strDateTo,
      String strIsSoTrx) throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: dataSheet");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    String discard[] = { "sectionDetail" };
    XmlDocument xmlDocument = null;
    GenerateInvoicesmanualData[] data = null;
    String strTreeOrg = GenerateShipmentsmanualData.treeOrg(this, vars.getClient());
    if (strC_BPartner_ID.equals("") && strAD_Org_ID.equals("")) {
      xmlDocument = xmlEngine.readXmlTemplate(
          "org/openbravo/erpCommon/ad_forms/GenerateInvoicesmanual", discard).createXmlDocument();
      data = GenerateInvoicesmanualData.set();
    } else {
      xmlDocument = xmlEngine.readXmlTemplate(
          "org/openbravo/erpCommon/ad_forms/GenerateInvoicesmanual").createXmlDocument();
      // data = GenerateInvoicesmanualData.select(this,
      // Utility.getContext(this, vars, "#User_Client",
      // "GenerateInvoicesmanual"), Utility.getContext(this, vars,
      // "#User_Org", "GenerateInvoicesmanual"), strC_BPartner_ID,
      // strDateFrom, DateTimeData.nDaysAfter(this, strDateTo,"1"),
      // strTreeOrg, strAD_Org_ID); Gross removed
            data = GenerateInvoicesmanualData.select(this, vars.getLanguage(),strIsSoTrx, Utility.getContext(
            this, vars, "#User_Client", "GenerateInvoicesmanual"), Utility.getContext(this, vars,
            "#User_Org", "GenerateInvoicesmanual"), strC_BPartner_ID, strDateFrom, DateTimeData
            .nDaysAfter(this, strDateTo, "1"), Tree.getMembers(this, strTreeOrg, strAD_Org_ID));
     
     // data = calcAmountsWithInvoiceTerm(data); //was tut das, ist notwendig für Funktion danach
   

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "GenerateInvoicesmanual", false, "",
        "", "", false, "ad_forms", strReplaceWith, false, true);
    toolbar.prepareSimpleToolBarTemplate();
    xmlDocument.setParameter("toolbar", toolbar.toString());
    String strIsSOtrx=vars.getSessionValue("issotrx");
    if (strIsSOtrx=="Y"){
    try {
      WindowTabs tabs = new WindowTabs(this, vars, "org.openbravo.erpCommon.ad_forms.GenerateInvoicesmanualSO");
//          "org.openbravo.erpCommon.ad_forms.GenerateInvoicesmanual");
      xmlDocument.setParameter("issotrx", vars.getSessionValue("issotrx"));
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      xmlDocument.setParameter("theme", vars.getTheme());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(),
          "GenerateInvoicesmanual.html", classInfo.id, classInfo.type, strReplaceWith, tabs
              .breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "GenerateInvoicesmanual.html",
          strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.manualTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }} else { try {
        WindowTabs tabs = new WindowTabs(this, vars, "org.openbravo.erpCommon.ad_forms.GenerateInvoicesmanualPO");
//      "org.openbravo.erpCommon.ad_forms.GenerateInvoicesmanual");
  xmlDocument.setParameter("issotrx", vars.getSessionValue("issotrx"));
  xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
  xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
  xmlDocument.setParameter("childTabContainer", tabs.childTabs());
  xmlDocument.setParameter("theme", vars.getTheme());
  NavigationBar nav = new NavigationBar(this, vars.getLanguage(),
      "GenerateInvoicesmanual.html", classInfo.id, classInfo.type, strReplaceWith, tabs
          .breadcrumb());
  xmlDocument.setParameter("navigationBar", nav.toString());
  LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "GenerateInvoicesmanual.html",
      strReplaceWith);
  xmlDocument.setParameter("leftTabs", lBar.manualTemplate());
} catch (Exception ex) {
  throw new ServletException(ex);
}
    	
    }
    {
      OBError myMessage = vars.getMessage("GenerateInvoicesmanual");
      vars.removeMessage("GenerateInvoicesmanual");
      if (myMessage != null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }
    xmlDocument.setParameter("calendar", vars.getLanguage().substring(0, 2));
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("paramLanguage", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("paramBPartnerId", strC_BPartner_ID);
    xmlDocument.setParameter("paramADOrgID", strAD_Org_ID);
    xmlDocument.setParameter("dateFrom", strDateFrom);
    xmlDocument.setParameter("dateFromdisplayFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateFromsaveFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateTo", strDateTo);
    xmlDocument.setParameter("dateTodisplayFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateTosaveFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("paramBPartnerDescription", GenerateInvoicesmanualData
        .bPartnerDescription(this, strC_BPartner_ID));


    try {
      ComboTableData comboTableData = new ComboTableData(vars, this, "TABLEDIR", "AD_Org_ID", "",
          "AD_Org Security validation", Utility.getContext(this, vars, "#User_Org",
              "GenerateInvoicesmanual"), Utility.getContext(this, vars, "#User_Client",
              "GenerateInvoicesmanual"), 0);
      Utility.fillSQLParameters(this, vars, null, comboTableData, "GenerateInvoicesmanual",
          strAD_Org_ID);
      xmlDocument.setData("reportAD_Org_ID", "liststructure", comboTableData.select(false));
      comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    xmlDocument.setData("structure1", data);
    out.println(xmlDocument.print());
    out.close();
  }}

 
  public String getServletInfo() {
    return "GenerateInvoicesmanual Servlet. This Servlet was made by Pablo Sarobe";
  } // end of getServletInfo() method
}


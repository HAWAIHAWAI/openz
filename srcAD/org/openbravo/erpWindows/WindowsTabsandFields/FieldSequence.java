
package org.openbravo.erpWindows.WindowsTabsandFields;

import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.utility.*;
import org.openbravo.xmlEngine.XmlDocument;
import org.openbravo.exception.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.StringTokenizer;
import java.sql.Connection;
import java.sql.SQLException;

public class FieldSequence extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  protected static final String windowId = "102";
  protected static final String tabId = "430";
  protected static final double SUBTABS_COL_SIZE = 15;
  protected static final int accesslevel = 4;

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");

      String strAD_Field_V_ID = vars.getGlobalVariable("inpadFieldVId", windowId + "|AD_Field_V_ID", "");

      printPageDataSheet(response, vars, strPAD_Tab_ID, strAD_Field_V_ID);
    } else if (vars.commandIn("TAB")) {
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      refreshParentSession(vars, strPAD_Tab_ID);


      vars.removeSessionValue(windowId + "|AD_Field_V_ID");
      printPageDataSheet(response, vars, strPAD_Tab_ID, "");
    } else if (vars.getCommand().startsWith("SAVE")) {
      boolean error =false;
      String strPAD_Tab_ID = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");
      FieldSequenceData data = getEditVariables(vars, strPAD_Tab_ID);
      if (!Utility.canUpdate(this, vars, Utility.getContext(this, vars, "#AD_Client_ID", windowId), Utility.getContext(this, vars, "#AD_Org_ID", windowId), windowId)) {
        bdError(request, response, "AccessTableNoUpdate", vars.getLanguage());
      } else {
        Connection conn = null;
        try {
          conn = this.getTransactionConnection();
          data.updateN(conn, this);
          if (data.shown.startsWith("(")) data.shown = data.shown.substring(1, data.shown.length()-1);
          if (!data.shown.equals("")) {
            StringTokenizer st = new StringTokenizer(data.shown, ",", false);
            
            int i = 0;
            int size = st.countTokens();
            FieldSequenceData dataShown[] = new FieldSequenceData[size];
            
            while (st.hasMoreTokens()) {
              dataShown[i] = getEditVariables(vars, strPAD_Tab_ID);
              dataShown[i].adFieldVId = st.nextToken().trim();
              if (dataShown[i].adFieldVId.startsWith("'")) dataShown[i].adFieldVId = dataShown[i].adFieldVId.substring(1, dataShown[i].adFieldVId.length()-1);
              dataShown[i].seqnoParam = FieldSequenceData.selectSeqNo(this, dataShown[i].adFieldVId);
              dataShown[i].isindevelopment = FieldSequenceData.selectInDevelopmentModule(this, dataShown[i].adFieldVId);
              i++;
            }

             //modify only in case the field's module is in development
            int start=0;
            int end=0;
            int seqno=0;
            int maxSeqno=0;
            boolean templateInDev = FieldSequenceData.isTemplateInDev(this);
            
            while(end < size) {
              start = end;
              while (start < size && !templateInDev && dataShown[start].isindevelopment.equals("N")) start++;
              end = start;
              while (end < size && (templateInDev || dataShown[end].isindevelopment.equals("Y"))) end++;
              
              if (start > 0) seqno = new Integer(dataShown[start-1].seqnoParam).intValue();
              if (end < size) maxSeqno = new Integer(dataShown[end].seqnoParam).intValue();
              if ((start > 0) && (end < size-1) && (seqno > maxSeqno)){
                OBError message = new OBError();
                message.setType("Error");
                message.setTitle(Utility.messageBD(this, "Error", vars.getLanguage()));
                message.setMessage(Utility.messageBD(this, "CannotReorderNotDevModules", vars.getLanguage()));
                vars.setMessage(tabId, message);
                releaseRollbackConnection(conn);
                error = true;
                break;
              }
              if (end==size) maxSeqno = -1; //no limit
              int add = (maxSeqno == -1 )?10:new Float(((maxSeqno-seqno)/(end-start+1))).intValue();
              for (int j=start; j < end; j++) {
                if (maxSeqno == -1 || seqno  < maxSeqno) seqno+=add;
                else {
                  OBError message = new OBError();
                  message.setType("Warning");
                  message.setTitle(Utility.messageBD(this, "Warning", vars.getLanguage()));
                  message.setMessage(Utility.messageBD(this, "NotAllOrdered", vars.getLanguage()));
                  vars.setMessage(tabId, message);
                }
                dataShown[j].seqnoParam = Integer.toString(seqno);
              }
            }
            
            for (int j=0; !error && j < dataShown.length; j++) {
              if (j < dataShown.length-1 && (new Integer(dataShown[j].seqnoParam).intValue() > new Integer(dataShown[j+1].seqnoParam).intValue())) {
                OBError message = new OBError();
                message.setType("Error");
                message.setTitle(Utility.messageBD(this, "Error", vars.getLanguage()));
                message.setMessage(Utility.messageBD(this, "CannotReorderNotDevModules", vars.getLanguage()));
                vars.setMessage(tabId, message);
                releaseRollbackConnection(conn);
                error = true;
                break;
              }
              dataShown[j].updateY(conn, this);
            }
            
          }
          if (!error) releaseCommitConnection(conn);
        } catch (NoConnectionAvailableException ex) {
          bdErrorConnection(response);
          return;
        } catch (SQLException ex2) {
          try {
            releaseRollbackConnection(conn);
          } catch (Exception ignored) {}
          ServletException se = new ServletException("@CODE=" + Integer.toString(ex2.getErrorCode()) + "@" + ex2.getMessage());
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), se.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        } catch (ServletException e) {
          try {
            releaseRollbackConnection(conn);
          } catch (Exception ignored) {}
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), e.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        } catch (Exception exc) {
          try {
            releaseRollbackConnection(conn);
          } catch (Exception ignored) {}
          throw new ServletException("@CODE=@" + exc.getMessage());
        }
        response.sendRedirect(strDireccion + request.getServletPath());
      }
    } else pageError(response);
  }

  FieldSequenceData getEditVariables(VariablesSecureApp vars, String strPAD_Tab_ID) throws IOException,ServletException {
    FieldSequenceData data = new FieldSequenceData();
    data.adFieldVId = vars.getInStringParameter("inpShown", IsIDFilter.instance);
      data.shown = vars.getInStringParameter("inpShown", IsIDFilter.instance);
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();

      data.adTabId = vars.getGlobalVariable("inpadTabId", windowId + "|AD_Tab_ID");


    return data;
  }

    void refreshParentSession(VariablesSecureApp vars, String strPAD_Tab_ID) throws IOException,ServletException {
      TabData[] data = TabData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPAD_Tab_ID, vars.getSessionValue(windowId + "|AD_Window_ID"), Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|AD_Table_ID", data[0].adTableId);    vars.setSessionValue(windowId + "|AD_Tab_ID", data[0].adTabId);
      
    }


  void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPAD_Tab_ID, String strAD_Field_V_ID)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument=null;

      FieldSequenceData[] data = FieldSequenceData.select(this, vars.getLanguage(), Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), strPAD_Tab_ID);

      FieldSequenceData[] data2 = FieldSequenceData.selectNotShown(this, vars.getLanguage(), Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), strPAD_Tab_ID);

      String[] discard={"isNotTest"};
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[0] = new String("isTest");
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/WindowsTabsandFields/FieldSequence_Relation", discard).createXmlDocument();

    xmlDocument.setParameter("keyParent", strPAD_Tab_ID);
    xmlDocument.setParameter("showName", Utility.messageBD(this, "Seqno", vars.getLanguage()));

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "FieldSequence", false, "document.frmMain.inpadFieldVId", "", "", "".equals("Y"), "WindowsTabsandFields", strReplaceWith, false);
    toolbar.prepareSortableTemplate(vars.getSessionValue("#ShowTest", "N").equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "FieldSequence_Relation.html", "WindowsTabsandFields", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      xmlDocument.setParameter("theme", vars.getTheme());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "FieldSequence_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.manualTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    try {
      KeyMap key = new KeyMap(this, tabId, windowId);
      xmlDocument.setParameter("keyMap", key.getSortTabKeyMaps());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

    {
      OBError myMessage = vars.getMessage(tabId);
      vars.removeMessage(tabId);
      if (myMessage!=null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }

    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("KeyName", "adFieldVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setData("structure1", data2);
    xmlDocument.setData("structure2", data);
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", FieldSequenceData.selectParent(this, vars.getLanguage(), strPAD_Tab_ID));
    else xmlDocument.setParameter("parent", FieldSequenceData.selectParentTrl(this, vars.getLanguage(), strPAD_Tab_ID));

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  public String getServletInfo() {
    return "Servlet FieldSequence. This Servlet was made by Wad constructor";
  } // fin del método getServletInfo()
}

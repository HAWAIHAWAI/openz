
package org.openbravo.erpCommon.ad_actionButton;


import org.openbravo.erpCommon.utility.*;
import org.openbravo.erpCommon.reference.*;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.xmlEngine.XmlDocument;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import org.openz.view.Formhelper;
import org.openz.view.Scripthelper;
import org.openz.view.templates.ConfigureButton;
import org.openz.view.templates.ConfigureInfobar;
import org.openz.view.templates.ConfigurePopup;
import org.openz.util.LocalizationUtils;


public class ActionButtonJava_Responser extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  protected static final String windowId = "ActionButtonResponser";
  
  public void init (ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String strProcessId = null;
    
    String command = vars.getCommand();
    
    if (command.equals("DEFAULT"))
      strProcessId = vars.getRequiredStringParameter("inpadProcessId");
    else if (command.startsWith("BUTTON"))
      strProcessId = command.substring("BUTTON".length());
    else if (command.startsWith("FRAMES")) {
      strProcessId = command.substring("FRAMES".length());
      printPageFrames(response, vars, strProcessId);
    } else if (command.startsWith("SAVE_BUTTONActionButton"))
      strProcessId = command.substring("SAVE_BUTTONActionButton".length());
   
    if (!vars.commandIn("DEFAULT") && !hasGeneralAccess(vars, "P", strProcessId)) {
      bdErrorGeneralPopUp(request, response, Utility.messageBD(this, "Error", vars.getLanguage()), Utility.messageBD(this, "AccessTableNoView", vars.getLanguage()));
    }
    
      
    if (vars.commandIn("DEFAULT")) {
      printPageDefault(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9DB4D30BFC5144B9B431CB49DDE9270D")) {
        
        printPageButton9DB4D30BFC5144B9B431CB49DDE9270D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON970EAD9B846648A7AB1F0CCA5058356C")) {
        
        printPageButton970EAD9B846648A7AB1F0CCA5058356C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9B07254378FA46A5A653C9A23474D31A")) {
        
        printPageButton9B07254378FA46A5A653C9A23474D31A(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB8A8C6CCCFFF4DC5A83838BC08ADB81D")) {
        
        printPageButtonB8A8C6CCCFFF4DC5A83838BC08ADB81D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6678855A5FE84649928B020A413D728B")) {
        
        printPageButton6678855A5FE84649928B020A413D728B(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON36E59A3C3EB54943B7445D527C5DA380")) {
        
        printPageButton36E59A3C3EB54943B7445D527C5DA380(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON1900D9A21B534688BE42CE127115A184")) {
        
        printPageButton1900D9A21B534688BE42CE127115A184(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND85D5B5E368A49B1A6293BA4AE15F0F9")) {
        
        printPageButtonD85D5B5E368A49B1A6293BA4AE15F0F9(response, vars, strProcessId);

    } else if (vars.commandIn("SAVE_BUTTONActionButton9DB4D30BFC5144B9B431CB49DDE9270D")) {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        pb.setConnection(this);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.KillSession().execute(pb);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
              myMessage = new OBError();
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), ex.getMessage()));
              myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), "Error in Process"));
              myMessage.setType("Error");
              log4j.error(ex);
              processButtonHelper(request, response, vars, myMessage);       
              return;
        }
        processButtonHelper(request, response, vars, myMessage);       
    } else if (vars.commandIn("SAVE_BUTTONActionButton970EAD9B846648A7AB1F0CCA5058356C")) {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strname = vars.getStringParameter("inpname");
params.put("name", strname);
String strimportauditinfo = vars.getStringParameter("inpimportauditinfo", "N");
params.put("importauditinfo", strimportauditinfo);

        
        pb.setParams(params);
        pb.setConnection(this);
        OBError myMessage = null;
        try {
          new org.openbravo.service.db.ImportClientProcess().execute(pb);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
              myMessage = new OBError();
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), ex.getMessage()));
              myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), "Error in Process"));
              myMessage.setType("Error");
              log4j.error(ex);
              processButtonHelper(request, response, vars, myMessage);       
              return;
        }
        processButtonHelper(request, response, vars, myMessage);       
    } else if (vars.commandIn("SAVE_BUTTONActionButton9B07254378FA46A5A653C9A23474D31A")) {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        pb.setConnection(this);
        OBError myMessage = null;
        try {
          new org.zsoft.banking.SepaExportService().execute(pb);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
              myMessage = new OBError();
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), ex.getMessage()));
              myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), "Error in Process"));
              myMessage.setType("Error");
              log4j.error(ex);
              processButtonHelper(request, response, vars, myMessage);       
              return;
        }
        processButtonHelper(request, response, vars, myMessage);       
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB8A8C6CCCFFF4DC5A83838BC08ADB81D")) {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradOrgId = vars.getStringParameter("inpadOrgId");
params.put("adOrgId", stradOrgId);
String strdateFrom = vars.getStringParameter("inpdateFrom");
params.put("dateFrom", strdateFrom);
String strdateTo = vars.getStringParameter("inpdateTo");
params.put("dateTo", strdateTo);
String striscomplete = vars.getStringParameter("inpiscomplete", "N");
params.put("iscomplete", striscomplete);
String strexporttype = vars.getStringParameter("inpexporttype");
params.put("exporttype", strexporttype);
String strallnew = vars.getStringParameter("inpallnew", "N");
params.put("allnew", strallnew);

        
        pb.setParams(params);
        pb.setConnection(this);
        OBError myMessage = null;
        try {
          new org.openbravo.zsoft.datev.DatevExportService().execute(pb,this,response);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
              myMessage = new OBError();
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), ex.getMessage()));
              myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), "Error in Process"));
              myMessage.setType("Error");
              log4j.error(ex);
              processButtonHelper(request, response, vars, myMessage);       
              return;
        }
               
    } else if (vars.commandIn("SAVE_BUTTONActionButton6678855A5FE84649928B020A413D728B")) {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        pb.setConnection(this);
        OBError myMessage = null;
        try {
          new org.openbravo.zsoft.smartui.CopyOrderTemplateAttService().execute(pb);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
              myMessage = new OBError();
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), ex.getMessage()));
              myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), "Error in Process"));
              myMessage.setType("Error");
              log4j.error(ex);
              processButtonHelper(request, response, vars, myMessage);       
              return;
        }
        processButtonHelper(request, response, vars, myMessage);       
    } else if (vars.commandIn("SAVE_BUTTONActionButton36E59A3C3EB54943B7445D527C5DA380")) {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strvalue = vars.getStringParameter("inpvalue");
params.put("value", strvalue);
String strname = vars.getStringParameter("inpname");
params.put("name", strname);

        
        pb.setParams(params);
        pb.setConnection(this);
        OBError myMessage = null;
        try {
          new org.openbravo.zsoft.manufac.CopyProductWithAttService().execute(pb);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
              myMessage = new OBError();
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), ex.getMessage()));
              myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), "Error in Process"));
              myMessage.setType("Error");
              log4j.error(ex);
              processButtonHelper(request, response, vars, myMessage);       
              return;
        }
        processButtonHelper(request, response, vars, myMessage);       
    } else if (vars.commandIn("SAVE_BUTTONActionButton1900D9A21B534688BE42CE127115A184")) {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        pb.setConnection(this);
        OBError myMessage = null;
        try {
          new org.openz.internallogistic.PackageReceiptPost().execute(pb);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
              myMessage = new OBError();
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), ex.getMessage()));
              myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), "Error in Process"));
              myMessage.setType("Error");
              log4j.error(ex);
              processButtonHelper(request, response, vars, myMessage);       
              return;
        }
        processButtonHelper(request, response, vars, myMessage);       
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD85D5B5E368A49B1A6293BA4AE15F0F9")) {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradClientId = vars.getStringParameter("inpadClientId");
params.put("adClientId", stradClientId);
String strexportauditinfo = vars.getStringParameter("inpexportauditinfo", "N");
params.put("exportauditinfo", strexportauditinfo);

        
        pb.setParams(params);
        pb.setConnection(this);
        OBError myMessage = null;
        try {
          new org.openbravo.service.db.ExportClientProcess().execute(pb);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
              myMessage = new OBError();
              myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), ex.getMessage()));
              myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), "Error in Process"));
              myMessage.setType("Error");
              log4j.error(ex);
              processButtonHelper(request, response, vars, myMessage);       
              return;
        }
        processButtonHelper(request, response, vars, myMessage);       

    } else pageErrorPopUp(response);
  }
  
  void printPageDefault(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefault").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
          xmlDocument.setParameter("trlFormType", "PROCESS");
          xmlDocument.setParameter("type", "ActionButtonJava_Responser.html");
          xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }
  
  void printPageFrames(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("type", "ActionButtonJava_Responser.html");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }

  

    void printPageButton9DB4D30BFC5144B9B431CB49DDE9270D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, strProcessId,vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, strProcessId ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,strProcessId );
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        strSkeleton=Replace.replace(strSkeleton, "ActionButton_Responser.html","ActionButtonJava_Responser.html"); 
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + ""; 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        strActionButtons= strActionButtons + "</tr></table>";
        script.enableshortcuts("POPUP");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        script.addHiddenfield("inpadProcessId", strProcessId);
        OBError myMessage = vars.getMessage(strProcessId);
        vars.removeMessage(strProcessId);
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
        
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButton970EAD9B846648A7AB1F0CCA5058356C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, strProcessId,vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, strProcessId ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,strProcessId );
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        strSkeleton=Replace.replace(strSkeleton, "ActionButton_Responser.html","ActionButtonJava_Responser.html"); 
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + ""; 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        strActionButtons= strActionButtons + "</tr></table>";
        script.enableshortcuts("POPUP");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        script.addHiddenfield("inpadProcessId", strProcessId);
        OBError myMessage = vars.getMessage(strProcessId);
        vars.removeMessage(strProcessId);
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
        
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButton9B07254378FA46A5A653C9A23474D31A(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, strProcessId,vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, strProcessId ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,strProcessId );
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        strSkeleton=Replace.replace(strSkeleton, "ActionButton_Responser.html","ActionButtonJava_Responser.html"); 
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + ""; 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        strActionButtons= strActionButtons + "</tr></table>";
        script.enableshortcuts("POPUP");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        script.addHiddenfield("inpadProcessId", strProcessId);
        OBError myMessage = vars.getMessage(strProcessId);
        vars.removeMessage(strProcessId);
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
        
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButtonB8A8C6CCCFFF4DC5A83838BC08ADB81D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, strProcessId,vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, strProcessId ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,strProcessId );
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        strSkeleton=Replace.replace(strSkeleton, "ActionButton_Responser.html","ActionButtonJava_Responser.html"); 
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + ""; 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        strActionButtons= strActionButtons + "</tr></table>";
        script.enableshortcuts("POPUP");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        script.addHiddenfield("inpadProcessId", strProcessId);
        OBError myMessage = vars.getMessage(strProcessId);
        vars.removeMessage(strProcessId);
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
        
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButton6678855A5FE84649928B020A413D728B(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, strProcessId,vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, strProcessId ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,strProcessId );
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        strSkeleton=Replace.replace(strSkeleton, "ActionButton_Responser.html","ActionButtonJava_Responser.html"); 
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + ""; 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        strActionButtons= strActionButtons + "</tr></table>";
        script.enableshortcuts("POPUP");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        script.addHiddenfield("inpadProcessId", strProcessId);
        OBError myMessage = vars.getMessage(strProcessId);
        vars.removeMessage(strProcessId);
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
        
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButton36E59A3C3EB54943B7445D527C5DA380(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, strProcessId,vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, strProcessId ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,strProcessId );
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        strSkeleton=Replace.replace(strSkeleton, "ActionButton_Responser.html","ActionButtonJava_Responser.html"); 
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + ""; 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        strActionButtons= strActionButtons + "</tr></table>";
        script.enableshortcuts("POPUP");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        script.addHiddenfield("inpadProcessId", strProcessId);
        OBError myMessage = vars.getMessage(strProcessId);
        vars.removeMessage(strProcessId);
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
        
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButton1900D9A21B534688BE42CE127115A184(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, strProcessId,vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, strProcessId ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,strProcessId );
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        strSkeleton=Replace.replace(strSkeleton, "ActionButton_Responser.html","ActionButtonJava_Responser.html"); 
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + ""; 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        strActionButtons= strActionButtons + "</tr></table>";
        script.enableshortcuts("POPUP");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        script.addHiddenfield("inpadProcessId", strProcessId);
        OBError myMessage = vars.getMessage(strProcessId);
        vars.removeMessage(strProcessId);
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
        
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }
    void printPageButtonD85D5B5E368A49B1A6293BA4AE15F0F9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, strProcessId,vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, strProcessId ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,strProcessId );
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        strSkeleton=Replace.replace(strSkeleton, "ActionButton_Responser.html","ActionButtonJava_Responser.html"); 
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + ""; 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        strActionButtons= strActionButtons + "</tr></table>";
        script.enableshortcuts("POPUP");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        script.addHiddenfield("inpadProcessId", strProcessId);
        OBError myMessage = vars.getMessage(strProcessId);
        vars.removeMessage(strProcessId);
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
        
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }


  public String getServletInfo() {
    return "Servlet ActionButton_Responser. This Servlet was made by Wad constructor";
  } // end of the getServletInfo() method

  private void processButtonHelper(HttpServletRequest request, HttpServletResponse response, VariablesSecureApp vars, OBError myMessage) 
     throws ServletException, IOException {
      advisePopUp(request, response, myMessage.getType(), myMessage.getTitle(), myMessage.getMessage());
  }
}

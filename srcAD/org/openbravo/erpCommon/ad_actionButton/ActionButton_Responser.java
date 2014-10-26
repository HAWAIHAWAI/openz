
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
import org.openz.view.Formhelper;
import org.openz.view.Scripthelper;
import org.openz.view.templates.ConfigureButton;
import org.openz.view.templates.ConfigureInfobar;
import org.openz.view.templates.ConfigurePopup;
import org.openz.util.LocalizationUtils;
import org.openz.util.UtilsData;

public class ActionButton_Responser extends HttpSecureAppServlet {
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
    } else if (vars.commandIn("BUTTON172")) {
        
        printPageButton172(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800087")) {
        
        printPageButton800087(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800075")) {
        
        printPageButton800075(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON119")) {
        
        printPageButton119(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON175")) {
        
        printPageButton175(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON176")) {
        
        printPageButton176(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON118")) {
        
        printPageButton118(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800130")) {
        
        printPageButton800130(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON4976D469855A4257A70B76548CD4DE18")) {
        
        printPageButton4976D469855A4257A70B76548CD4DE18(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7C674672BB9A4ECBB6E12023D0FBA425")) {
        
        printPageButton7C674672BB9A4ECBB6E12023D0FBA425(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON642B7411882D47139CE05AFD407B9907")) {
        
        printPageButton642B7411882D47139CE05AFD407B9907(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDDA3A0E5F21D47F5B279B198CA88B8E5")) {
        
        printPageButtonDDA3A0E5F21D47F5B279B198CA88B8E5(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB3A71B935297481AB1268EBAAE7ACEC2")) {
        
        printPageButtonB3A71B935297481AB1268EBAAE7ACEC2(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON99E86108F12D4AC38B8BAB68F30E230A")) {
        
        printPageButton99E86108F12D4AC38B8BAB68F30E230A(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON06AAB5B7859B45DAAAF4B70F96771014")) {
        
        printPageButton06AAB5B7859B45DAAAF4B70F96771014(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONAD57725B5AF94EB3AE2E6C04999A2FBD")) {
        
        printPageButtonAD57725B5AF94EB3AE2E6C04999A2FBD(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9715B301FA6C4CB0A83C53C963BC16B9")) {
        
        printPageButton9715B301FA6C4CB0A83C53C963BC16B9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON93F39318941F41D0957A12D5C6135AF4")) {
        
        printPageButton93F39318941F41D0957A12D5C6135AF4(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB3CCA6F9411347AF97712A3F8664B3F7")) {
        
        printPageButtonB3CCA6F9411347AF97712A3F8664B3F7(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB09D8C63860E4AF6BB5E841B27317BE9")) {
        
        printPageButtonB09D8C63860E4AF6BB5E841B27317BE9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONE581733896BB474A9B259CC119A43257")) {
        
        printPageButtonE581733896BB474A9B259CC119A43257(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5CFE562A090240A99E4C389942D63EFD")) {
        
        printPageButton5CFE562A090240A99E4C389942D63EFD(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON800171")) {
        
        printPageButton800171(response, vars, strProcessId);

    } else if (vars.commandIn("SAVE_BUTTONActionButton172")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "172", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton800087")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800087", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton800075")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800075", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "DateFrom", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "DateTo", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());
String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "M_Warehouse_ID", strmWarehouseId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strreferenceno = vars.getStringParameter("inpreferenceno");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "ReferenceNo", strreferenceno, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateinvoiced = vars.getStringParameter("inpdateinvoiced");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "60", "DateInvoiced", strdateinvoiced, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton119")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "119", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strdateinvoiced = vars.getStringParameter("inpdateinvoiced");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "DateInvoiced", strdateinvoiced, vars.getClient(), vars.getOrg(), vars.getUser());
String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "15", "AD_Org_ID", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcOrderId = vars.getStringParameter("inpcOrderId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "C_Order_ID", strcOrderId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strinvoicetodate = vars.getStringParameter("inpinvoicetodate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "40", "InvoiceToDate", strinvoicetodate, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton175")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "175", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String stradClientId = vars.getStringParameter("inpadClientId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "AD_Client_ID", stradClientId, vars.getClient(), vars.getOrg(), vars.getUser());
String stradTableId = vars.getStringParameter("inpadTableId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "AD_Table_ID", stradTableId, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton176")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "176", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String stradClientId = vars.getStringParameter("inpadClientId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "AD_Client_ID", stradClientId, vars.getClient(), vars.getOrg(), vars.getUser());
String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "AD_Org_ID", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String stradTableId = vars.getStringParameter("inpadTableId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "AD_Table_ID", stradTableId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "40", "DATEFROM", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "50", "DATETO", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton118")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "118", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "AD_Org_ID", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton800130")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800130", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strinitdate = vars.getStringParameter("inpinitdate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "Initdate", strinitdate, vars.getClient(), vars.getOrg(), vars.getUser());
String strenddate = vars.getStringParameter("inpenddate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "EndDate", strenddate, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton4976D469855A4257A70B76548CD4DE18")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "4976D469855A4257A70B76548CD4DE18", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton7C674672BB9A4ECBB6E12023D0FBA425")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "7C674672BB9A4ECBB6E12023D0FBA425", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton642B7411882D47139CE05AFD407B9907")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "642B7411882D47139CE05AFD407B9907", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDDA3A0E5F21D47F5B279B198CA88B8E5")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "DDA3A0E5F21D47F5B279B198CA88B8E5", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strmProductId = vars.getStringParameter("inpmProductId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "m_product_id", strmProductId, vars.getClient(), vars.getOrg(), vars.getUser());
String strzssmProductionplanVId = vars.getStringParameter("inpzssmProductionplanVId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "zssm_productionplan_v_id", strzssmProductionplanVId, vars.getClient(), vars.getOrg(), vars.getUser());
String strpProductionstartdate = vars.getStringParameter("inppProductionstartdate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "30", "p_ProductionStartDate", strpProductionstartdate, vars.getClient(), vars.getOrg(), vars.getUser());
String strpProductionqty = vars.getNumericParameter("inppProductionqty");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "60", "p_ProductionQty", strpProductionqty, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB3A71B935297481AB1268EBAAE7ACEC2")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "B3A71B935297481AB1268EBAAE7ACEC2", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        
        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton99E86108F12D4AC38B8BAB68F30E230A")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "99E86108F12D4AC38B8BAB68F30E230A", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "ad_org_id", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "DateFrom", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "30", "DateTo", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());
String strcostcentername = vars.getStringParameter("inpcostcentername");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "CostCenterName", strcostcentername, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton06AAB5B7859B45DAAAF4B70F96771014")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "06AAB5B7859B45DAAAF4B70F96771014", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "dateFrom", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "dateTo", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButtonAD57725B5AF94EB3AE2E6C04999A2FBD")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "AD57725B5AF94EB3AE2E6C04999A2FBD", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strclientId = vars.getStringParameter("inpclientId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "CLIENT_ID", strclientId, vars.getClient(), vars.getOrg(), vars.getUser());
String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "25", "AD_ORG_ID", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateFrom = vars.getStringParameter("inpdateFrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "30", "DATE_FROM", strdateFrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateTo = vars.getStringParameter("inpdateTo");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "40", "DATE_TO", strdateTo, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());
String strbwaheaderid = vars.getStringParameter("inpbwaheaderid");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "60", "BWAHEADERID", strbwaheaderid, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton9715B301FA6C4CB0A83C53C963BC16B9")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "9715B301FA6C4CB0A83C53C963BC16B9", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strdocumentId = vars.getStringParameter("inpdocumentId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "DOCUMENT_ID", strdocumentId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton93F39318941F41D0957A12D5C6135AF4")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "93F39318941F41D0957A12D5C6135AF4", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strmProductId = vars.getStringParameter("inpmProductId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "M_PRODUCT_ID", strmProductId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());
String strlabel = vars.getStringParameter("inplabel");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "Label", strlabel, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB3CCA6F9411347AF97712A3F8664B3F7")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "B3CCA6F9411347AF97712A3F8664B3F7", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strmProductId = vars.getStringParameter("inpmProductId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "M_PRODUCT_ID", strmProductId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB09D8C63860E4AF6BB5E841B27317BE9")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "B09D8C63860E4AF6BB5E841B27317BE9", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strmProductId = vars.getStringParameter("inpmProductId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "5", "M_PRODUCT_ID", strmProductId, vars.getClient(), vars.getOrg(), vars.getUser());
String strissparepart = vars.getStringParameter("inpissparepart", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "ISSPAREPART", strissparepart, vars.getClient(), vars.getOrg(), vars.getUser());
String strisconsumable = vars.getStringParameter("inpisconsumable", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "ISCONSUMABLE", strisconsumable, vars.getClient(), vars.getOrg(), vars.getUser());
String stradLanguage = vars.getStringParameter("inpadLanguage");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "AD_LANGUAGE", stradLanguage, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());
String strisinternal = vars.getStringParameter("inpisinternal", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "ISINTERNAL", strisinternal, vars.getClient(), vars.getOrg(), vars.getUser());
String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "60", "AD_ORG_ID", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String stronlyonelevel = vars.getStringParameter("inponlyonelevel", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "70", "ONLYONELEVEL", stronlyonelevel, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButtonE581733896BB474A9B259CC119A43257")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "E581733896BB474A9B259CC119A43257", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strformat = vars.getStringParameter("inpformat");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "Format", strformat, vars.getClient(), vars.getOrg(), vars.getUser());
String strbarcode1 = vars.getStringParameter("inpbarcode1");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "Barcode1", strbarcode1, vars.getClient(), vars.getOrg(), vars.getUser());
String strbarcode2 = vars.getNumericParameter("inpbarcode2");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "30", "Barcode2", strbarcode2, vars.getClient(), vars.getOrg(), vars.getUser());
String strbarcode3 = vars.getStringParameter("inpbarcode3");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "Barcode3", strbarcode3, vars.getClient(), vars.getOrg(), vars.getUser());
String strbarcode4 = vars.getStringParameter("inpbarcode4");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "Barcode4", strbarcode4, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "60", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton5CFE562A090240A99E4C389942D63EFD")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "5CFE562A090240A99E4C389942D63EFD", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "80", "ad_org_id", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartdate = vars.getStringParameter("inpstartdate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "90", "startdate", strstartdate, vars.getClient(), vars.getOrg(), vars.getUser());
String strenddate = vars.getStringParameter("inpenddate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "100", "enddate", strenddate, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "120", "c_bpartner_id", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "130", "c_project_id", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String stradUserId = vars.getStringParameter("inpadUserId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "140", "ad_user_id", stradUserId, vars.getClient(), vars.getOrg(), vars.getUser());
String strissparepart = vars.getStringParameter("inpissparepart", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "150", "issparepart", strissparepart, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "160", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        
    } else if (vars.commandIn("SAVE_BUTTONActionButton800171")) {
        
        String strProcessing = "Y";
        String pinstance = SequenceIdData.getUUID();
        PInstanceProcessData.insertPInstance(this, pinstance, "800171", "0", strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
        String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcCurrencyId = vars.getStringParameter("inpcCurrencyId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "15", "C_Currency_ID", strcCurrencyId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdatefrom = vars.getStringParameter("inpdatefrom");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "DateFrom", strdatefrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateto = vars.getStringParameter("inpdateto");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "40", "DateTo", strdateto, vars.getClient(), vars.getOrg(), vars.getUser());
String strcProjectId = vars.getStringParameter("inpcProjectId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "C_Project_ID", strcProjectId, vars.getClient(), vars.getOrg(), vars.getUser());
String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "60", "M_Warehouse_ID", strmWarehouseId, vars.getClient(), vars.getOrg(), vars.getUser());
String stroutputtype = vars.getStringParameter("inpoutputtype");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "70", "outputType", stroutputtype, vars.getClient(), vars.getOrg(), vars.getUser());

        
        ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
        new ProcessRunner(bundle).execute(this);

        processButtonHelper(request, response, vars, pinstance);        

    } else pageErrorPopUp(response);
  }

  void printPageDefault(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefault").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
	xmlDocument.setParameter("trlFormType", "PROCESS");
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
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }

    void printPageButton172(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton800087(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton800075(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton119(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton175(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton176(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton118(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton800130(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton4976D469855A4257A70B76548CD4DE18(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton7C674672BB9A4ECBB6E12023D0FBA425(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton642B7411882D47139CE05AFD407B9907(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButtonDDA3A0E5F21D47F5B279B198CA88B8E5(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButtonB3A71B935297481AB1268EBAAE7ACEC2(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton99E86108F12D4AC38B8BAB68F30E230A(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton06AAB5B7859B45DAAAF4B70F96771014(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButtonAD57725B5AF94EB3AE2E6C04999A2FBD(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton9715B301FA6C4CB0A83C53C963BC16B9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton93F39318941F41D0957A12D5C6135AF4(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButtonB3CCA6F9411347AF97712A3F8664B3F7(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButtonB09D8C63860E4AF6BB5E841B27317BE9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButtonE581733896BB474A9B259CC119A43257(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton5CFE562A090240A99E4C389942D63EFD(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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
    void printPageButton800171(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
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
        String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        String isJasper=UtilsData.isProcessJasper(this, strProcessId);
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONActionButton" + strProcessId + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
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

  private void processButtonHelper(HttpServletRequest request, HttpServletResponse response, VariablesSecureApp vars, String pinstance) 
     throws ServletException, IOException {
      OBError myMessage;
      try {
        PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
      myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
      } catch (Exception e) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), e.getMessage());
          e.printStackTrace();
          log4j.warn("Error");
      }
      advisePopUp(request, response, myMessage.getType(), myMessage.getTitle(), myMessage.getMessage());
  }
}

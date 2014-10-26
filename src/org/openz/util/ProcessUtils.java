package org.openz.util;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.erpCommon.reference.PInstanceProcessData;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.database.ConnectionProvider;

public class ProcessUtils {
  public static void startProcessDirectly(String key,String processid,VariablesSecureApp vars, HttpSecureAppServlet servlet) {
    OBError myMessage = null;
    try {
      String pinstance = UtilsData.getUUID(servlet);
      String strProcessing = vars.getStringParameter("inpprocessing");  
      if (strProcessing.isEmpty())
        strProcessing="N";
      PInstanceProcessData.insertPInstance(servlet, pinstance, processid, key, strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
      ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, servlet);
      new ProcessRunner(bundle).execute(servlet);
      PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(servlet, pinstance);
      myMessage = Utility.getProcessInstanceMessage(servlet, vars, pinstanceData);
    }
    catch (Exception ex) {
        myMessage = Utility.translateError(servlet, vars, vars.getLanguage(), ex.getMessage());
    }
    if (servlet.getTabId().isEmpty())
      vars.setMessage(servlet.getServletInfo(), myMessage);
    else
      vars.setMessage(servlet.getTabId(), myMessage);
  }
  public static String getNumOfParams(ConnectionProvider conn,String processId) throws Exception {
    return UtilsData.getProcessNumOfParams(conn, processId);
 
  }
}
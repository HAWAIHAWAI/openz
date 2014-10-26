package org.openz.util;
import org.openbravo.data.Sqlc;
import org.openbravo.base.secureApp.VariablesSecureApp;
public class SessionUtils {
  public static void setLocalSessionVariable(String servlet,VariablesSecureApp vars, String ADName) {
    vars.setSessionValue(servlet + "|" + ADName, vars.getStringParameter("inp" + Sqlc.TransformaNombreColumna(ADName)));
  }
  public static String readInputAndSetLocalSessionVariable(String servlet,VariablesSecureApp vars, String ADName) {
    vars.setSessionValue(servlet + "|" + ADName, vars.getStringParameter("inp" + Sqlc.TransformaNombreColumna(ADName)));
    return vars.getStringParameter("inp" + Sqlc.TransformaNombreColumna(ADName));
  }
  public static String readInput(VariablesSecureApp vars, String ADName) {
    return vars.getStringParameter("inp" + Sqlc.TransformaNombreColumna(ADName));
  }
  public static void setLocalSessionVariable(String servlet,VariablesSecureApp vars, String ADName, String Value) {
    vars.setSessionValue(servlet + "|" +  ADName, Value);
  }
  
  public static String getLocalSessionVariable(String servlet,VariablesSecureApp vars, String ADName) {
    return vars.getSessionValue(servlet + "|" + ADName);
  }
  
  public static void deleteLocalSessionVariable(String servlet,VariablesSecureApp vars, String ADName) {
    vars.removeSessionValue(servlet + "|" + ADName);
  }
}

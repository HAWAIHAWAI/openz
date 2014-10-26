/*
****************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/
package org.openbravo.zsoft.smartui.DirectSales;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.xmlEngine.XmlDocument;

public class SL_Product extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    if (vars.commandIn("DEFAULT")) {
      String strChanged = vars.getStringParameter("inpLastFieldChanged");
      if (log4j.isDebugEnabled())
        log4j.debug("CHANGED: " + strChanged);
      String strUOM = vars.getStringParameter("inpmProductId_UOM");
      String strPriceStd = vars.getNumericParameter("inpmProductId_PSTD");
      String strCurrency = vars.getStringParameter("inpmProductId_CURR");
      String strMProductID = vars.getStringParameter("inpmProductId");
      String strMWarehouseID = vars.getStringParameter("inpmWarehouseId");

      try {
        printPage(response, vars, strUOM, strPriceStd, strCurrency, strMProductID, strMWarehouseID);
      } catch (ServletException ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }

  private void printPage(HttpServletResponse response, VariablesSecureApp vars, String strUOM,
      String strPriceStd, String strCurrency, String strMProductID, String strMWarehouseID)
      throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();

    String strPriceActual = "";
    StringBuffer resultado = new StringBuffer();
    strPriceActual = strPriceStd;

    resultado.append("var calloutName='zssiSL_Product';\n\n");
    resultado.append("var respuesta = new Array(");
    resultado.append("new Array(\"inpcUomId\", \"" + strUOM + "\"),");
    resultado.append("new Array(\"inppriceactual\", "
        + (strPriceActual.equals("") ? "\"0\"" : strPriceActual) + "),");
    resultado.append("new Array(\"inpcCurrencyId\", "
        + (strCurrency.equals("") ? "\"\"" : strCurrency) + ")");

    // resultado.append("\n),");

    // resultado.append("new Array(\"EXECUTE\", \"displayLogic();\"),\n");
    // Para posicionar el cursor en el campo de cantidad
    // resultado.append("new Array(\"CURSOR_FIELD\", \"inpqtyordered\")\n");

    resultado.append(");");
    xmlDocument.setParameter("array", resultado.toString());
    xmlDocument.setParameter("frameName", "appFrame");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }
}

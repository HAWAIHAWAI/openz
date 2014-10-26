/*
***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
****************************************************************************************************************************************************
 */
package org.openbravo.erpCommon.ad_callouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.xmlEngine.XmlDocument;
import org.openz.controller.callouts.CalloutStructure;

public class SL_Order_Amt extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  private static final BigDecimal ZERO = new BigDecimal(0.0);

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
      String strQtyOrdered = vars.getNumericParameter("inpqtyordered").replaceAll(",", ".");
      String strPriceActual = vars.getNumericParameter("inppriceactual");
      String strDiscount = vars.getNumericParameter("inpdiscount");
      String strPriceLimit = vars.getNumericParameter("inppricelimit");
      String strPriceList = vars.getNumericParameter("inppricelist");
      String strPriceStd = vars.getNumericParameter("inppricestd");
      String strCOrderId = vars.getStringParameter("inpcOrderId");
      String strProduct = vars.getStringParameter("inpmProductId");
      String strUOM = vars.getStringParameter("inpcUomId");
      String strOrderUOM = vars.getStringParameter("inpmProductUomId");
      String strOrderQTY = vars.getStringParameter("inpquantityorder").replaceAll(",", ".");
      String strAttribute = vars.getStringParameter("inpmAttributesetinstanceId");
      String strTabId = vars.getStringParameter("inpTabId");
      // SZ added order-UOM and Pricelimit
      String strQty = vars.getNumericParameter("inpqtyordered").replaceAll(",", ".");
      String cancelPriceAd = vars.getStringParameter("inpcancelpricead");
      String strMPricelistId = vars.getStringParameter("inpmPricelistId");

      try {
        if (! strProduct.isEmpty()) {
          printPage(response, vars, strChanged, strQtyOrdered, strPriceActual, strDiscount,
            strPriceLimit, strPriceList, strCOrderId, strProduct, strUOM, strAttribute, strTabId,
            strQty, strPriceStd, cancelPriceAd, strOrderUOM, strOrderQTY, strMPricelistId);
        } else {
          CalloutStructure callout = new CalloutStructure(this, this.getClass().getSimpleName() );
          
          response.setContentType("text/html; charset=UTF-8");
          PrintWriter out = response.getWriter();
          out.println(callout.returnCalloutAppFrame());
          out.close();
        }
      } catch (ServletException ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }

  private void printPage(HttpServletResponse response, VariablesSecureApp vars, String strChanged,
      String strQtyOrdered, String strPriceActual, String strDiscount, String strPriceLimit,
      String strPriceList, String strCOrderId, String strProduct, String strUOM,
      String strAttribute, String strTabId, String strQty, String strPriceStd, String cancelPriceAd,
      String strOrderUOM, String strOrderQTY,String strMPricelistId)
      throws IOException, ServletException {
    if (log4j.isDebugEnabled()) {
      log4j.debug("Output: dataSheet");
      log4j.debug("CHANGED:" + strChanged);
    }

    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
    SLOrderAmtData[] data = SLOrderAmtData.select(this, strCOrderId);
    SLOrderStockData[] data1 = SLOrderStockData.select(this, strProduct);
    String strPrecision = "0", strPricePrecision = "0";
    String strStockSecurity = "0";
    String strEnforceAttribute = "N";
    String Issotrx = SLOrderStockData.isSotrx(this, strCOrderId);
    String strStockNoAttribute;
    String strStockAttribute;
    if (data1 != null && data1.length > 0) {
      strStockSecurity = data1[0].stock;
      strEnforceAttribute = data1[0].enforceAttribute;
    }
    // boolean isUnderLimit=false;
    if (data != null && data.length > 0) {
      strPrecision = data[0].stdprecision.equals("") ? "0" : data[0].stdprecision;
      strPricePrecision = data[0].priceprecision.equals("") ? "0" : data[0].priceprecision;
    }
    int StdPrecision = Integer.valueOf(strPrecision).intValue();
    int PricePrecision = Integer.valueOf(strPricePrecision).intValue();

    BigDecimal qtyOrdered, priceActual, discount, priceLimit, priceList, stockSecurity, stockNoAttribute, stockAttribute, resultStock, priceStd, OrderQTY;
    
    stockSecurity = new BigDecimal(strStockSecurity);
    qtyOrdered = (strQtyOrdered.equals("") ? ZERO : new BigDecimal(strQtyOrdered));
    priceActual = (strPriceActual.equals("") ? ZERO : (new BigDecimal(strPriceActual))).setScale(
        PricePrecision, BigDecimal.ROUND_HALF_UP);
    discount = (strDiscount.equals("") ? ZERO : new BigDecimal(strDiscount));
    priceLimit = (strPriceLimit.equals("") ? ZERO : (new BigDecimal(strPriceLimit))).setScale(
        PricePrecision, BigDecimal.ROUND_HALF_UP);
    priceList = (strPriceList.equals("") ? ZERO : (new BigDecimal(strPriceList))).setScale(
        PricePrecision, BigDecimal.ROUND_HALF_UP);
    priceStd = (strPriceStd.equals("") ? ZERO : (new BigDecimal(strPriceStd))).setScale(
        PricePrecision, BigDecimal.ROUND_HALF_UP);
    OrderQTY = ((strOrderUOM.equals("") | strOrderQTY.equals("")) ? ZERO :   new BigDecimal(strOrderQTY));
    /*
     * if (enforcedLimit) { String strPriceVersion = ""; PriceListVersionComboData[] data1 =
     * PriceListVersionComboData.selectActual(this, data[0].mPricelistId, DateTimeData.today(this));
     * if (data1!=null && data1.length>0) strPriceVersion = data1[0].mPricelistVersionId; BigDecimal
     * lineLimit = new BigDecimal(SLOrderAmtData.selectPriceLimit(this, strPriceVersion,
     * strProduct)); if (lineLimit.floatValue() >priceActual.floatValue()) isUnderLimit=true; }
     */
    // SZ : If we order in Secondary OUM, Price applies to OrderQTY not to qtyOrdered
    //if (OrderQTY.compareTo(ZERO)!=0) qtyOrdered = OrderQTY;
    //
    StringBuffer resultado = new StringBuffer();
    resultado.append("var calloutName='SL_Order_Amt';\n\n");
    resultado.append("var respuesta = new Array(");


    SLOrderProductData[] dataOrder = SLOrderProductData.select(this, strCOrderId);
   
    // FW: Use discount?
	if (strChanged.equals("inpcancelpricead")) {
		if ("Y".equals(cancelPriceAd)) {
			/* FW: Calculate with Amounts on Screen (not used because of small rounding differences may occur)
			priceActual = (priceActual.divide((new BigDecimal("1")).subtract(discount.divide(new BigDecimal("100"))), 12, BigDecimal.ROUND_HALF_EVEN));
			if (priceActual.scale() > PricePrecision)
				priceActual = priceActual.setScale(PricePrecision, BigDecimal.ROUND_HALF_UP);
			resultado.append("new Array(\"inppriceactual\", " + priceActual.toString() + "),");*/
			// FW: Just use standard price
			resultado.append("new Array(\"inppriceactual\", " + priceStd.toString() + "),");
		} else {
			// FW: Calculate price actual again (standard price on screen * discount on screen)
			priceActual = (priceStd.multiply((new BigDecimal("1")).subtract(discount.divide(new BigDecimal("100")))));
			if (priceActual.scale() > PricePrecision)
				priceActual = priceActual.setScale(PricePrecision, BigDecimal.ROUND_HALF_UP);
			resultado.append("new Array(\"inppriceactual\", " + priceActual.toString() + "),");  
		}
	}

    // Standard- bzw. Mindest-Bestellmenge aus Einkauf (m_product_po) beruecksichtigen, wenn hinterlegt 	
    if (strChanged.equals("inpqtyordered")) {
      int stdPrecision = strPrecision.equals("") ? 0 : Integer.valueOf(strPrecision).intValue();
      String strInitUOM = SLInvoiceConversionData.initUOMId(this, strOrderUOM);
      String strMultiplyRate;
      boolean check = false;
      strMultiplyRate = SLInvoiceConversionData.divideRate(this, strInitUOM, strUOM);
      if (strInitUOM.equals(strUOM))
        strMultiplyRate = "1";
      if (strMultiplyRate.equals(""))
        strMultiplyRate = SLInvoiceConversionData.multiplyRate(this, strUOM, strInitUOM);
      if (strMultiplyRate.equals("") || strMultiplyRate == null ) {
        strMultiplyRate = "1";
      }
      BigDecimal multiplyRate = new BigDecimal(strMultiplyRate);
      if (!strOrderUOM.equals("")) {
        if (strOrderQTY.equals("")) OrderQTY = new BigDecimal(0);
        else OrderQTY = new BigDecimal(strOrderQTY);
        OrderQTY = OrderQTY.setScale(stdPrecision, BigDecimal.ROUND_HALF_UP);
        BigDecimal a = qtyOrdered.multiply(multiplyRate).setScale(stdPrecision, BigDecimal.ROUND_HALF_UP);
        if (!OrderQTY.equals(a)) {
          OrderQTY = qtyOrdered.multiply(multiplyRate);         
          resultado.append("new Array(\"inpquantityorder\", " + OrderQTY.toString() + "),");
        }
      }
      BigDecimal qtyPurchase = new BigDecimal(SLOrderAmtData.mrp_getpo_qty(this, strProduct, dataOrder[0].cBpartnerId, qtyOrdered.toString()));
      if (!qtyOrdered.equals(qtyPurchase)) {

        BigDecimal qtyPurchaseStd = new BigDecimal(SLOrderAmtData.mrp_getpo_qtystd(this, strProduct, dataOrder[0].cBpartnerId));
        BigDecimal qtyPurchaseMin = new BigDecimal(SLOrderAmtData.mrp_getpo_qtymin(this, strProduct, dataOrder[0].cBpartnerId));
        String qtyPurchaseIsMultiple = new String(SLOrderAmtData.mrp_getpo_ismultipleofminimumqty(this, strProduct, dataOrder[0].cBpartnerId));
        resultado.append("new Array('MESSAGE', \"" + FormatUtilities.replaceJS
        (
          Utility.messageBD(this, "ZSMP_PurchaseDefault",        vars.getLanguage()) + ":" +  "</br></br>" + 
          Utility.messageBD(this, "ZSMP_PurchaseDefault_QtyStd", vars.getLanguage()) + " = " + qtyPurchaseStd.toString() + "</br>" + 
          Utility.messageBD(this, "ZSMP_PurchaseDefault_QtyMin", vars.getLanguage()) + " = " + qtyPurchaseMin.toString() + "</br>" +
          Utility.messageBD(this, "ZSMP_PurchaseDefault_IsMult", vars.getLanguage()) + " = " + qtyPurchaseIsMultiple.toString() + "</br></br>" +
          Utility.messageBD(this, "ZSMP_PurchaseDefault_Qty",    vars.getLanguage()) + " = " + qtyPurchase.toString() + "  "  + // "</br>" +
          "<input type=\"button\" value=\"Anpassen\" href=\"#\"  style=\"cursor:pointer;\" onclick=\"submitCommandFormParameter('DEFAULT', frmMain.inpLastFieldChanged, 'QtyOrdered', false, null, '../ad_callouts/SL_Order_Amt.html', 'hiddenFrame', null, null, true); return false;\" class=\"LabelLink\">"
        ) + "\"),");
      } else {
        resultado.append("new Array('MESSAGE', \"" + "\"),"); // reset Message, reset MessageBox
      }
    } 

    // perform link (used as button)
    if (strChanged.equals("QtyOrdered")) {
      BigDecimal qtyPurchase = new BigDecimal(SLOrderAmtData.mrp_getpo_qty(this, strProduct, dataOrder[0].cBpartnerId, qtyOrdered.toString()));
      qtyOrdered = qtyPurchase; // Bestellt = (berechnete Menge lt. Einkauf: m_product_po)  [statement required, aendert Eintrag in GUI-Komponente]
      resultado.append("new Array(\"inpqtyordered\", " + qtyPurchase.toString() + "),"); // [statement required, aendert Eintrag in GUI-Komponente]
      resultado.append("new Array('MESSAGE', \"" + "\"),"); // reset Message, reset MessageBox
      resultado.append("new Array('MESSAGE', \"" + FormatUtilities.replaceJS(Utility.messageBD(this, "ZSMP_PurchaseDefault_Excec", vars.getLanguage()) ) + "\"),");
      
      int stdPrecision = strPrecision.equals("") ? 0 : Integer.valueOf(strPrecision).intValue();
      String strInitUOM = SLInvoiceConversionData.initUOMId(this, strOrderUOM);
      String strMultiplyRate;
      boolean check = false;
      strMultiplyRate = SLInvoiceConversionData.divideRate(this, strInitUOM, strUOM);
      if (strInitUOM.equals(strUOM))
        strMultiplyRate = "1";
      if (strMultiplyRate.equals(""))
        strMultiplyRate = SLInvoiceConversionData.multiplyRate(this, strUOM, strInitUOM);
      if (strMultiplyRate.equals("") || strMultiplyRate == null ) {
        strMultiplyRate = "1";
      }
      BigDecimal multiplyRate = new BigDecimal(strMultiplyRate);
      if (!strOrderUOM.equals("")) {
        if (strOrderQTY.equals("")) OrderQTY = new BigDecimal(0);
        else OrderQTY = new BigDecimal(strOrderQTY);
        OrderQTY = OrderQTY.setScale(stdPrecision, BigDecimal.ROUND_HALF_UP);
        BigDecimal a = qtyOrdered.multiply(multiplyRate).setScale(stdPrecision, BigDecimal.ROUND_HALF_UP);
        if (!OrderQTY.equals(a)) {
          OrderQTY = qtyOrdered.multiply(multiplyRate);         
          resultado.append("new Array(\"inpquantityorder\", " + OrderQTY.toString() + "),");
        }
      }
      
    }
    
    // calculating discount
    if (strChanged.equals("inppriceactual")) {
      if ("Y".equals(cancelPriceAd)) {
        priceActual=priceStd;
        resultado.append("new Array(\"inppriceactual\", " + priceActual.toString() + "),");
      }
      else {
        if (log4j.isDebugEnabled())
          log4j.debug("pricelist:" + Double.toString(priceList.doubleValue()));
        if (log4j.isDebugEnabled())
          log4j.debug("priceActual:" + Double.toString(priceActual.doubleValue()));
        discount = ((priceStd.subtract(priceActual))
            .divide(priceStd, 12, BigDecimal.ROUND_HALF_EVEN)).multiply(new BigDecimal("100"));     
        if (log4j.isDebugEnabled())
          log4j.debug("Discount: " + discount.toString());
        if (discount.scale() > StdPrecision)
          discount = discount.setScale(StdPrecision, BigDecimal.ROUND_HALF_UP);
        if (log4j.isDebugEnabled())
          log4j.debug("Discount rounded: " + discount.toString());
        resultado.append("new Array(\"inpdiscount\", " + discount.toString() + "),");
      }
    } else if (strChanged.equals("inpqtyordered") && !("Y".equals(cancelPriceAd))) { // calculate Actual
        priceActual = new BigDecimal(SLOrderProductData.getOffersPrice(this,
            dataOrder[0].dateordered, dataOrder[0].cBpartnerId, strProduct, priceStd.toString(),
            strQty, dataOrder[0].mPricelistId, dataOrder[0].id));
        if (priceActual.scale() > PricePrecision)
          priceActual = priceActual.setScale(PricePrecision, BigDecimal.ROUND_HALF_UP);
        if (priceActual.compareTo(ZERO)!=0) 
          resultado.append("new Array(\"inppriceactual\", " + priceActual.toString() + "),");
        else
          priceActual = new BigDecimal(strPriceActual);
        if (priceStd.compareTo(ZERO)!=0) {
             discount = ((priceStd.subtract(priceActual)).divide(priceStd, 12, BigDecimal.ROUND_HALF_EVEN)).multiply(new BigDecimal("100"));
             if (discount.scale() > StdPrecision)
               discount = discount.setScale(StdPrecision, BigDecimal.ROUND_HALF_UP);
             if (log4j.isDebugEnabled())
               log4j.debug("Discount rounded: " + discount.toString());
             resultado.append("new Array(\"inpdiscount\", " + discount.toString() + "),");
        }
        

    } else if (strChanged.equals("inpdiscount")) { // calculate std and actual
      
        // SZ doesn't make sense????
        priceActual = (priceStd).subtract((discount.multiply(priceStd)).divide(new BigDecimal("100")));  
        if (priceActual.scale() > PricePrecision)
          priceActual = priceActual.setScale(PricePrecision, BigDecimal.ROUND_HALF_UP);
        resultado.append("new Array(\"inppriceactual\", " + priceActual.toString() + "),");
    }

    if (Issotrx.equals("Y")) {
      if (!strStockSecurity.equals("0")) {
        if (qtyOrdered.compareTo(BigDecimal.ZERO) != 0) {
          if (strEnforceAttribute.equals("N")) {
            strStockNoAttribute = SLOrderStockData.totalStockNoAttribute(this, strProduct, strUOM);
            stockNoAttribute = new BigDecimal(strStockNoAttribute);
            resultStock = stockNoAttribute.subtract(qtyOrdered);
            if (stockSecurity.compareTo(resultStock) > 0) {
              resultado.append("new Array('MESSAGE', \""
                  + FormatUtilities.replaceJS(Utility.messageBD(this, "StockLimit", vars
                      .getLanguage())) + "\"),");
            }
          } else {
            if (!strAttribute.equals("") && strAttribute != null) {
              strStockAttribute = SLOrderStockData.totalStockAttribute(this, strProduct, strUOM,
                  strAttribute);
              stockAttribute = new BigDecimal(strStockAttribute);
              resultStock = stockAttribute.subtract(qtyOrdered);
              if (stockSecurity.compareTo(resultStock) > 0) {
                resultado.append("new Array('MESSAGE', \""
                    + FormatUtilities.replaceJS(Utility.messageBD(this, "StockLimit", vars
                        .getLanguage())) + "\"),");
              }
            }
          }
        }
      }
    }
    if (log4j.isDebugEnabled())
      log4j.debug(resultado.toString());
    if (!strChanged.equals("inpqtyordered") & Issotrx.equals("Y")) { // Check PriceLimit
      boolean enforced = SLOrderAmtData.listPriceType(this, strMPricelistId);
      // Check Price Limit?
      if (enforced && priceLimit.compareTo(BigDecimal.ZERO) != 0
          && priceActual.compareTo(priceLimit) < 0)
        resultado.append("new Array('MESSAGE', \""
            + Utility.messageBD(this, "UnderLimitPrice", vars.getLanguage()) + "\"),");
    }


    BigDecimal lineNetAmt;
    if (OrderQTY.compareTo(ZERO)!=0) lineNetAmt = OrderQTY.multiply(priceActual);
    else lineNetAmt = qtyOrdered.multiply(priceActual);
    if (lineNetAmt.scale() > StdPrecision)
      lineNetAmt = lineNetAmt.setScale(StdPrecision, BigDecimal.ROUND_HALF_UP);
    resultado.append("new Array(\"inplinenetamt\", " + lineNetAmt.toString() + ")");

    resultado.append(");");
    xmlDocument.setParameter("array", resultado.toString());
    xmlDocument.setParameter("frameName", "appFrame");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }
}

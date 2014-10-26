package org.openbravo.erpCommon.info;
/*
****************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.data.FieldProvider;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openbravo.utils.Replace;
import org.openz.view.Scripthelper;
import org.openz.view.DataGrid;
import org.openz.view.templates.*;
import org.openz.util.*;
import org.openbravo.erpCommon.utility.DateTimeData;
import org.openbravo.base.filter.RequestFilter;
import org.openbravo.base.filter.ValueListFilter;
import org.openz.view.Scripthelper;

public class Product extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  
  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
  ServletException {
    // Initializing the Grid Structure
    //String[] colWidths,colNames,colDataTypes;
    //boolean[] colSort;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    // Prepare Datagrid Structure
    // In all selectors, Fields name and rowkey are required!
    DataGrid grid = new DataGrid();
    try {
      
        grid.initGridByAD("ProductSearch", vars, this);
       
    }
    catch (Exception e) { 
        log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
        e.printStackTrace();
        throw new ServletException(e);
    }
   
    // Get and Set Session Variables
    String isUserPurchaser = PriceListVersionComboData.isUserPurchaser(this, vars.getUser());
    // Windw ID and issotrx can only be read in the first call, in subsequent calls it is empty.
    String windowId = vars.getStringParameter("WindowID");
    if (! windowId.isEmpty())
      vars.setSessionValue("Product.windowId", windowId);
    windowId =vars.getSessionValue("Product.windowId");
    String strIssotrx = Utility.getContext(this, vars, "isSOTrx", windowId);
    String strOrg = Utility.getContext(this, vars, "Ad_Org_ID", windowId);
    String strDate  = DateTimeData.today(this);
    String strBpartner="";
    String strCategory="";
    String strType=""; 
    String strWarehouse="";
    String ismulti = vars.getStringParameter("isMultiLine");
    String strPriceListVersion = "";
    String strSelectMachines="Y";
    String strActivatePOBPartnerPreselection = ProductData.getActivatePOBPartnerPreselection(this, strOrg); // Y/N;
    // Remove session-vars, if filter changes      
    if (vars.getStringParameter("newFilter").equals("1") || vars.commandIn("KEY")) {
      removePageSessionVariables(vars);
    }
    // Remove session-vars, if BPartner changes      
    if (! Utility.getContext(this, vars, "C_Bpartner_ID", windowId).equals(vars.getSessionValue("Product.PersistedVendor")) && 
        ! vars.commandIn("KEY") && ! windowId.equals("")) {
       removePageSessionVariables(vars);
       vars.removeSessionValue("Product.SelectMachines");
       vars.setSessionValue("Product.PersistedVendor",Utility.getContext(this, vars, "C_Bpartner_ID", windowId)); // save window-values
       if (strIssotrx.equals("N") && strActivatePOBPartnerPreselection.equals("Y") ) {
           strBpartner = Utility.getContext(this, vars, "C_Bpartner_ID", windowId);
           vars.setSessionValue("Product.Vendor", strBpartner);
       }
    }
    //
    String strTheme = vars.getStringParameter("inpTheme");
    String strCustomerproductno = vars.getStringParameter("inpCustomerproductno");
    // Get Name, Vendor Product Filters
    String strName = vars.getStringParameter("inpname");
    String strVendorProduct = vars.getStringParameter("inpVendorProductNo");
    String strValue = vars.getStringParameter("inpvalue");
    // Value Filter - set session var in KEY command
    if (vars.commandIn("KEY")) {
      String strIDValue = vars.getStringParameter("inpIDValue");
      strValue = vars.getStringParameter("inpNameValue") + "%";
      if (!strIDValue.equals("")) 
        strValue = ProductData.getValue(this,strIDValue);
      // Test , if there is something with this name
      if (ProductData.getValueCount(this, strValue).equals("0") && 
          ! ProductData.getNameCount(this, strValue).equals("0")){
        strValue ="";
        strName = vars.getStringParameter("inpNameValue") + "%";
      }
      // In KEY command the Value is persisted in session
      vars.setSessionValue("Product.Value", strValue);
      vars.setSessionValue("Product.Name", strName);
    }
    
    // Session VAR Only if set via KEY - the value must appear in the following DATA command
    if (strValue.equals(""))
      strValue=vars.getSessionValue("Product.Value");
    if (strName.equals(""))
      strName=vars.getSessionValue("Product.Name");
    // Set Rest of persisted Filters (all Dropdown Boxes)
    if (vars.commandIn("DATA")) {
      if (vars.getStringParameter("newFilter").equals("1") ) {
        // Read the Content of Dropdown Boxes and persist values in session, If Filter changes
        strBpartner = vars.getRequestGlobalVariable("inpVendorID","Product.Vendor");
        strCategory = vars.getRequestGlobalVariable("inpmProductCategoryId", "Product.ProductCategory");
        strType = vars.getRequestGlobalVariable("inpProductType", "Product.TypeOfProduct");
        strWarehouse= vars.getRequestGlobalVariable("inpmWarehouseId","Product.warehouse");
        strPriceListVersion= vars.getRequestGlobalVariable("inpmPricelistVersionId","Product.priceListVersion");
      }
    }
    if(strActivatePOBPartnerPreselection.equals("Y")){
      // Set the Content of Dropdown Boxes with persisted values from session
      strBpartner = vars.getSessionValue("Product.Vendor");
      strCategory = vars.getSessionValue("Product.ProductCategory");
      strType = vars.getSessionValue("Product.TypeOfProduct");
    }
    strPriceListVersion = vars.getSessionValue("Product.priceListVersion");
    // Pricelist may be changed - It could be read from dropdown or from Window
    // Get the Price List from the Calling Window - Only In the 1st call (DEFAULT) , window ID is filled. The Pricelist-Version is persisted later, so in Subsequent calls the pricelist itself is not evaluated.
    String  strPriceList ="";
    //These windows are SO Transactions but change to purchase here for product selection.
    //Here is no vendor persisted - therefore window must be SO, but Products in BOMS schoulde be purchaseble.
    // Also machines schoud not be selectable in these Windows.
    if ((windowId.equals("130")||windowId.equals("A2BEBB9B07564D2AAA372B4CB2D01165"))) {// Project and Production Order
      strIssotrx="N";
      vars.setSessionValue("Product.SelectMachines","N");
    }
    else {
      strPriceList = vars.getSessionValue(windowId + "|M_Pricelist_ID");
    }
    strSelectMachines=vars.getSessionValue("Product.SelectMachines");
    if (strSelectMachines.isEmpty())
      strSelectMachines="Y";
        //Utility.getContext(this, vars, "M_Pricelist_ID", windowId);
    if (strPriceList.equals("")) {
        strPriceList = ProductData.priceListDefault(this, Utility.getContext(this, vars,
            "#User_Client", "Product"), Utility.getContext(this, vars, "#AccessibleOrgTree",
            "Product"),strIssotrx);
    }   
    if (strPriceListVersion.equals("")) 
      strPriceListVersion = getPriceListVersion(vars, strPriceList, strDate);
    vars.setSessionValue("Product.priceListVersion", strPriceListVersion);
    // Warehouse could be read from dropdown or from Window
    strWarehouse= vars.getSessionValue("Product.warehouse");
    if (strWarehouse.equals(""))
      strWarehouse=Utility.getContext(this, vars, "M_Warehouse_ID", windowId);
    vars.setSessionValue("Product.warehouse", strWarehouse);
    // Technical Parameters
    String strOffset = vars.getStringParameter("offset");
    if (strOffset.equals(""))
      strOffset="0";
    String strSortCols = vars.getInStringParameter("sort_cols", grid.columnfilter);
    String strSortDirs = vars.getInStringParameter("sort_dirs", grid.directionfilter);
    String strOrderBy = "1";
    if (!strSortCols.equals("") && ! strSortDirs.equals(""))
      strOrderBy = SelectorUtility.buildOrderByClause(strSortCols, strSortDirs);
    // Setting Wildcards for searching
    if (strName.equals(""))
      strName="%";
    if (strValue.equals(""))
      strValue="%";
    if (strVendorProduct.equals(""))
      strVendorProduct="%";
    if (strBpartner.equals(""))
      strBpartner="%";
    if (strCategory.equals(""))
      strCategory="%";
    if (strType.equals(""))
       strType="%";
    if (strTheme.equals(""))
      strTheme="%";
    if (strCustomerproductno.equals(""))
      strCustomerproductno="%";
    
    //
    // Build User Interface
    String strSkeleton ="" ;
    String strOutput ="" ;
    String strTableStructure ="" ;
    String strTableStructure2 ="" ;
    String strTableCells ="";
    String strGrid ="" ;
    String strActionButtons="" ;
    Scripthelper script = new Scripthelper();
    response.setContentType("text/html; charset=UTF-8");
    try{
      if (vars.commandIn("DEFAULT") || vars.commandIn("KEY")) {
        strSkeleton = ConfigureSelectionPopup.doConfigure(this,vars,"Product",grid,"buttonSearch",ismulti.equals("Y") ? true : false , "../Product/Product_Relation.html");
        // CONFIGURE Filter
        String filterheight="185px";
        strTableStructure = ConfigureTableStructure.doConfigure(this,vars,"6","" ,"Main");
        strTableCells=ConfigureFieldgroup.doConfigure(this,vars,script,"","6", "Filter","");
        //
        // 1st ROW (Name and Value)
        strTableCells=strTableCells + "<tr>" ;
        strTableCells=strTableCells + ConfigureTextbox.doConfigure(this,vars,script,"value",0,2,40,false,false,"" ,strValue,"","");
        strTableCells=strTableCells + ConfigureTextbox.doConfigure(this,vars,script,"name",1,2,120,false,false,"", strName,"","");
        strTableCells=strTableCells + "</tr>" ;
        //
        // 2nd Row (Vendor and Vendor Product No)
        strTableCells=strTableCells + "<tr>" ;
        ProductVendorComboData[] data = ProductVendorComboData.select(this, Utility.getContext(this, vars, "#User_Client", "Product"), Utility.getContext(this, vars, "#AccessibleOrgTree", "Product"));
        strTableCells=strTableCells + ConfigureSelectBox.doConfigure(this,vars,script,"VendorID", 0,3,false,false,"", strBpartner, data, "c_bpartner_id","",true,"");
        strTableCells=strTableCells + ConfigureTextbox.doConfigure(this,vars,script,"VendorProductNo",0,2,120,false,false,"", strVendorProduct,"","");
        strTableCells=strTableCells + "</tr>" ;
        //
        // 3rd Row (Product Category and Type)
        strTableCells=strTableCells + "<tr>" ;
        ProductCategoryComboData[] data2 = ProductCategoryComboData.selectWinSpec(this, Utility.getContext(this, vars, "#User_Client", "Product"), Utility.getContext(this, vars, "#AccessibleOrgTree", "Product"), windowId);
        strTableCells=strTableCells + ConfigureSelectBox.doConfigure(this,vars,script,"mProductCategoryId", 0,3,false,false,"", strCategory, data2, "","",true,"");
        ProductTypeComboData[] data3 = ProductTypeComboData.select(this, vars.getLanguage());
        strTableCells=strTableCells + ConfigureSelectBox.doConfigure(this,vars,script,"ProductType", 0,3,false,false,"", strType, data3, "TypeOfProductValue","",true,"");
        strTableCells=strTableCells + "</tr>" ;
        //
        // 4th Row (Warehouse and Pricelist)
        strTableCells=strTableCells + "<tr>" ;
        WarehouseComboData[] data4 = WarehouseComboData.select(this, vars.getRole(), vars.getClient());
        strTableCells=strTableCells + ConfigureSelectBox.doConfigure(this,vars,script,"mWarehouseId", 0,3,true,false,"", strWarehouse, data4, "","",false,"");
        // Pricelist Selection is only allowed on Info - Menu. If Product-Selector is used in Windows, the Pricelist is already defined by Window-Header 
        PriceListVersionComboData[] data5;
        if (windowId.equals(""))
          data5 = PriceListVersionComboData.select(this, strPriceList, Utility.getContext(this, vars, "#User_Org", "Product"),isUserPurchaser);
        else
          data5 = PriceListVersionComboData.selectSelected(this, strPriceList, Utility.getContext(this, vars, "#User_Org", "Product"));
        strTableCells=strTableCells + ConfigureSelectBox.doConfigure(this,vars,script,"mPricelistVersionId",0,3, true,false,"", strPriceListVersion, data5, "","",false,"");
        strTableCells=strTableCells + "</tr>" ;
        //
        // 5th Row (Search BUTTON)
        strTableCells=strTableCells + "<tr>" ;
        strTableCells=strTableCells + ConfigureButton.doConfigure(this,vars,script,"buttonSearch",1,1,false,"search", "setFilters()", "","");
        strTableCells=strTableCells + "</tr>" ;
        //
        // Replace Complete Filter Content in Filter Table
        strTableStructure = Replace.replace(strTableStructure, "@CONTENT@", strTableCells);  
        strTableStructure="<div class=\"Popup_ContentPane_Client\" style=\"overflow: auto; auto; height:" + filterheight + ";\" id=\"client_top\">\n" +
            strTableStructure +"</div>";
        //
        // Build GRID-Structure
        strGrid = ConfigureDataGrid.doConfigure(this,vars,"../info/Product.html",ismulti.equals("Y") ? true : false ,"middle");
        // Build Action Buttons
        strTableStructure2 = ConfigureTableStructure.doConfigure(this,vars,"6", "","Main");
        strActionButtons= "<tr>";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonOK",2,1,false, "ok",  "validateSelector('SAVE')", "",""); 
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "validateSelector('CLEAR')", "","");
        strActionButtons= strActionButtons + "</tr>";
        strTableStructure2 = Replace.replace(strTableStructure2, "@CONTENT@", strActionButtons);  
        strTableStructure2="<div class=\"Popup_ContentPane_Client\" style=\"overflow: auto; auto; height:50px;\" id=\"client_bottom\">\n" +
            strTableStructure2 +"</div>"; 
        // Replace Filter,GRID and Actionbuttons in Skeleton 
        strOutput = Replace.replace(strSkeleton, "@FILTERCONTENT@", strTableStructure);
        strOutput = Replace.replace(strOutput, "@DATAGRIDCONTENT@",strGrid); 
        strOutput = Replace.replace(strOutput, "@ACTIONBUTTONS@",strTableStructure2); 
        strOutput = script.doScript(strOutput, "",this,vars);
      }
      
      if (vars.commandIn("STRUCTURE")) {
        ConfigureDataGrid.printGridStructure(response, vars, grid, this);
      }
      if (vars.commandIn("DATA") || vars.commandIn("KEY")) {
        String isPurchase;
        String isSold;
        String isSales = ProductData.isSOPricelist(this, strPriceListVersion );
        if (isSales.equals("Y")) {
          isPurchase="'Y','N'";
          isSold="'Y'";
          // Purchase: Only Purchasing Items
        } else if (isSales.equals("N")) {
          isPurchase="'Y'";
          isSold="'Y','N'";
          // All Others: Any Item
        } else {
          isPurchase="'Y','N'";
          isSold="'Y','N'";
        }
        //
        // Select the Data
        String pgLimit = ConfigureDataGrid.getLimit("Product", strOffset, vars);
        String strNumRows ="";
        strNumRows = ProductData.countRows(this,vars.getLanguage(),strPriceListVersion,  strValue, vars.getClient(), strName, 
            Utility.getContext(this, vars, "#User_Client", "Product"), Utility.getSelectorOrgs(
                this, vars, vars.getOrg()),isPurchase,isSold,strBpartner,strCategory,strSelectMachines,strVendorProduct,strType, windowId, pgLimit);
        if (strNumRows.equals(""))
          strNumRows="0";
        vars.setSessionValue("Product.numrows", strNumRows);
        FieldProvider[] data;
        data = ProductData.select(this, vars.getClient(),strPriceListVersion,strWarehouse,vars.getLanguage(),strValue, strName,
            Utility.getContext(this, vars, "#User_Client", "Product"), Utility.getSelectorOrgs(
                this, vars,  vars.getOrg()),isPurchase,isSold,strBpartner,strCategory,strSelectMachines,strVendorProduct,strType, windowId,pgLimit, strOrderBy);
        if (vars.commandIn("KEY") && data.length == 1)
          strOutput=ConfigureSelectionPopup.printPageKey(vars, this, data,  grid, "mProductId");
        if (vars.commandIn("DATA")) {
          strOutput=ConfigureDataGrid.printGridData(vars, grid, this, response, "Product", strOffset, data);
          response.setContentType("text/xml; charset=UTF-8");
          response.setHeader("Cache-Control", "no-cache");
        }
      }
    }
    catch (Exception e) {
        log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
        e.printStackTrace();
        throw new ServletException(e);
    }
    PrintWriter out = response.getWriter();
    out.println(strOutput);
    out.close(); 
  }
  private void removePageSessionVariables(VariablesSecureApp vars) {
    vars.removeSessionValue("Product.warehouse");
    vars.removeSessionValue("Product.priceListVersion");
    vars.removeSessionValue("Product.currentPage");
    vars.removeSessionValue("Product.Vendor");
    vars.removeSessionValue("Product.ProductCategory");
    vars.removeSessionValue("Product.TypeOfProduct");
    vars.removeSessionValue("Product.Value");
    vars.removeSessionValue("Product.Name");
    // remove saved adorgid only when called from DEFAULT,KEY
    // but not when called by clicking search in the selector
    if (!vars.getStringParameter("newFilter").equals("1")) {
      vars.removeSessionValue("Product.adorgid");
    }
  }

  private String getPriceListVersion(VariablesSecureApp vars, String strPriceList, String strDate)
      throws IOException, ServletException {
    PriceListVersionComboData[] data = PriceListVersionComboData.selectActual(this, strPriceList,
        strDate, Utility.getContext(this, vars, "#User_Org", "Product"));
    if (log4j.isDebugEnabled())
      log4j.debug("Selecting pricelistversion date:" + strDate + " - pricelist:" + strPriceList);
    if (data == null || data.length == 0)
      return "";
    return data[0].mPricelistVersionId;
  }
 

  public String getServletInfo() {
    return this.getClass().getName();
  } 
}

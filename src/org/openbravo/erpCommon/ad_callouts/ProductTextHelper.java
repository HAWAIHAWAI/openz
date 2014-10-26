/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
package org.openbravo.erpCommon.ad_callouts;
import javax.servlet.ServletException;
import java.util.*;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.zsoft.service.Util;
import org.openbravo.utils.FormatUtilities;
@SuppressWarnings("unchecked")
public abstract class ProductTextHelper extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  public String getDocumentText(String mProductId, String cBpartnerID,
         String isSOtrx,String adOrgId,String language) throws ServletException {

    ProductTextData[] data=ProductTextData.select(this, adOrgId);
    Hashtable sorter= new Hashtable();
    //Hashtable<String,String> sorter= new Hashtable<String,String>();
    String doctext="";
    if (data.length>0) {
        if (data[0].cpyProddesc2docnote.equals("Y"))
            sorter.put(data[0].proddescOrdernum,"proddescOrdernum");
        if (data[0].cpyProddocnote2docnote.equals("Y"))
            sorter.put(data[0].proddocnoteOrdernum,"proddocnoteOrdernum");
        if (data[0].cpyVendpnumber2docnote.equals("Y") && isSOtrx.equals("N"))
            sorter.put(data[0].vendpnumberdnOrdernum,"vendpnumberdnOrdernum");
        Vector v = new Vector(sorter.keySet());
        Collections.sort(v);
        Iterator it  = v.iterator();
        String field="";
        while (it.hasNext()) {
          String element =  (String)it.next();
          field =(String)sorter.get(element);
          if (field.equals("proddescOrdernum"))
            doctext=doctext+ProductTextData.getProductDescription(this, mProductId) + "\n";
          if (field.equals("vendpnumberdnOrdernum")) 
            if (!ProductTextData.getVendorProductNo(this, mProductId, cBpartnerID).equals(""))
                doctext=doctext+ new Util().getText( "zssi_vendorproductno" , language , this)
                           + ProductTextData.getVendorProductNo(this, mProductId, cBpartnerID) + "\n";
          if (field.equals("proddocnoteOrdernum")) 
            doctext=doctext+ProductTextData.getProductDocNote(this, mProductId) + "\n";;
    }
    doctext=  FormatUtilities.replaceJS(doctext);
    }
    return doctext;
  }
}

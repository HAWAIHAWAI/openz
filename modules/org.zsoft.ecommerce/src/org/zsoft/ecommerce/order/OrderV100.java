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
package org.zsoft.ecommerce.order;
import java.util.Date;
import java.math.BigDecimal;
import org.zsoft.ecommerce.*;

public class OrderV100 extends Order {
  
  private String  cBpartnerContactId;
  
  public String getCBpartnerContactId() {
       return cBpartnerContactId;
  }
 
  public void setCBpartnerContactId(String pcBpartnerContactId) {
       cBpartnerContactId = pcBpartnerContactId;
  }
 
}

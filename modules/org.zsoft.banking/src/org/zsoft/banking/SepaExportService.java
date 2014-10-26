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
package org.zsoft.banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.File;


import org.apache.log4j.Logger;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.zsoft.service.Util;


public class SepaExportService  implements org.openbravo.scheduling.Process {
  private static final Logger log = Logger.getLogger(SepaExportService.class);

  public void execute(ProcessBundle bundle)   throws Exception {

    log.debug("Starting SepaExportService.\n");
 

  //  servlet.printPagePopUpDownloadFile(response.getOutputStream(), file, "/tmp");
    final OBError msg = new OBError();
    

 
    final String cBankstatementD = (String) bundle.getParams().get("C_BankStatement_ID");
    String fileDir = OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");
    String adUserId=bundle.getContext().getUser();
    String result="";
    String sql;
    String filename="";
    String uuid="";
    String adClientId=bundle.getContext().getClient();
    String adOrgId=bundle.getContext().getOrganization();
    String baseurl = bundle.baseurl;
    
    // Get SQL Prepared..
    ConnectionProvider connp = bundle.getConnection();
    Connection conn = connp.getConnection();
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet res;
    // Make shure Dir exists
    final File toDir = new File(fileDir + "/SepaExport");
    if (!toDir.exists())
      toDir.mkdirs();
    // Get uuid from database
    sql = "select get_uuid() as dbuuid from dual";
    res = stmt.executeQuery(sql);
    if (res.first())
      uuid = res.getString("dbuuid");
    res.close();
    SepaExportServiceData.insertHeader(connp, uuid,adClientId,adOrgId,adUserId,uuid);
    SepaExportServiceData.insertLines(connp, uuid,adUserId,cBankstatementD);
    filename=SepaExportServiceData.doProcessing(conn, connp, uuid);
    //filename="test-111.xml";
    final File outputfile = new File("/tmp/" + filename);
    if (!outputfile.exists()){
      msg.setType("Error");
      msg.setMessage("Error in Sepa-Export-Service:" + filename);
      msg.setTitle("Error");
      bundle.setResult(msg);
    } else {
      Util.copyFile("/tmp/",toDir.getAbsolutePath() , filename, filename);
      Util.copyFile("/tmp/",fileDir + "/392-" + cBankstatementD, filename, filename);
      SepaExportServiceData.attachFile(conn, connp,cBankstatementD,adUserId,adClientId,adOrgId,filename,"Sepa-Exportfile");
      msg.setType("Success");
      String href = baseurl + "/utility/DownloadFile.html?dfile=" + filename + "&fdir=/SepaExport";
      String link = "<a class=\"Labellink\" href=\"" + href + "\">hier klicken</a>";
      msg.setMessage("SEPA-Datei Erstellt. Bitte " + link);
      msg.setTitle("Sepa Export");
      bundle.setResult(msg);
    }
      toDir.mkdirs();
    log.debug("Creation of File Successfully finished\n");
    
    //return filename;
}
}
  
 



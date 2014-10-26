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
package org.openbravo.zsoft.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.io.FileOutputStream;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;
import org.quartz.JobExecutionException;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.database.ConnectionProvider;

public class Pictures2FileService extends DalBaseProcess {
  private ProcessLogger logger;
  public void doExecute(ProcessBundle bundle) throws Exception {

    logger = bundle.getLogger();

    logger.log("Starting Pictures2File Service.\n");
    try {
      String sql =  "select  m_product.m_product_id as m_product_id,binarydata from m_product,ad_image,zse_product_shop where " +
                    "m_product.ad_image_id=ad_image.ad_image_id and  " +
                    "zse_product_shop.m_product_id=m_product.m_product_id";
      ConnectionProvider connp = bundle.getConnection();
      Connection conn = connp.getConnection();
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      ResultSet res = stmt.executeQuery(sql);
      // Get the Output Directory
      String fileDir = OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("multimedia.path");
      // Scroll Pictures
      while (res.next()) {
        final File outputFile = new File(fileDir,res.getString("m_product_id") + ".jpg");
        FileOutputStream out = new FileOutputStream(outputFile);
        out.write(res.getBytes("binarydata"));
        out.flush();
        out.close(); 
      }
    } catch (Exception e) {
      // catch any possible exception and throw it as a Quartz
      // JobExecutionException
      throw new JobExecutionException(e.getMessage(), e);
    }
  }
}

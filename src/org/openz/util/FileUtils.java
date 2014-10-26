package org.openz.util;

import java.io.*;

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
public class FileUtils {
  public static void copyFile(String sourceDir,String destDir,String sourceFile, String destFile) throws Exception {
    
    final File toDir = new File(destDir);
    final File fromDir = new File(sourceDir);
    if (!toDir.exists())
      toDir.mkdirs();
    final File inputFile = new File(fromDir, sourceFile);
    final File outputFile = new File(toDir, destFile);
    FileInputStream in = new FileInputStream(inputFile);
    FileOutputStream out = new FileOutputStream(outputFile);
    byte[] buf = new byte[1024]; 
    int len; 
    while ((len = in.read(buf)) >= 0)  
      out.write(buf, 0, len); 
    in.close(); 
    out.flush();
    out.close(); 
  }
  
  public static String readFileOLD(String filename, String path) throws Exception{
    final File dir = new File(path);
    final File file = new File(dir,filename);
    String         ls = System.getProperty("line.separator");
    String line;
    BufferedReader reader = new BufferedReader( new FileReader (file));
    StringBuilder  stringBuilder = new StringBuilder();
    while( ( line = reader.readLine() ) != null ) {
      stringBuilder.append( line );
      stringBuilder.append( ls );

  }
  return stringBuilder.toString();
  }
  
  public static String readFile(String filename, String path) throws Exception{
    final File dir = new File(path);
    final File f = new File(dir,filename);
    FileInputStream fstream = new FileInputStream(f);
    byte[] bytes = new byte[(int) f.length()];
    fstream.read(bytes);
    fstream.close();
    return new String(bytes);
  }
  
 
  
}

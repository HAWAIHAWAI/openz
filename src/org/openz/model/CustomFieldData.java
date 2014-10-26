package org.openz.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.database.ConnectionProvider;

public class CustomFieldData implements FieldProvider {
      
  private Vector <String> fields= new Vector<String>();
  private Vector <String> types= new Vector<String>();
      
    public String getField(String fieldName) {
      String suffix=fieldName.replace("customfield", "");
      return fields.elementAt(Integer.parseInt(suffix)-1);
    }
     
   

      public  CustomFieldData select(ConnectionProvider connectionProvider, String referenceid, String tabId, String keycolumnname)    throws ServletException {
        String strTablename=CrudOperationsData.getTableFromTab(connectionProvider, tabId);
        String customcount=CrudOperationsData.getCustomColumnCount(connectionProvider, tabId);
        if (Integer.parseInt(customcount)==0)
          return null;
        CrudOperationsData[] data=CrudOperationsData.selectCustomColumns(connectionProvider, tabId);
        for (int i=0; i< data.length;i++) {
          types.add(data[i].ptype);
        }
        String strSql = " select ";
        for (int i=0; i< Integer.parseInt(customcount);i++) {
          if (i>0)
            strSql = strSql + ",";
        strSql = strSql +  "customfield" + String.valueOf(i+1);
        }
        strSql = strSql +  " from " + strTablename + " where " + keycolumnname + "='" + referenceid + "'";
        ResultSet result;
        CustomFieldData objectCustomFieldData = new CustomFieldData();
        
        PreparedStatement st = null;
       
        
        try {
        st = connectionProvider.getPreparedStatement(strSql);
          
          result = st.executeQuery();
        
          
          while(result.next()) {
            for (int i=0; i< Integer.parseInt(customcount);i++) {
              if (types.get(i).equals("TIMESTAMP"))
                fields.add(UtilSql.getDateValue(result, "customfield" + String.valueOf(i+1), "dd-MM-yyyy"));
              else
                fields.add(UtilSql.getValue(result, "customfield" + String.valueOf(i+1)));
            }  
          }
          result.close();
        } catch(SQLException e){
          
          throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
        } catch(Exception ex){
          
          throw new ServletException("@CODE=@" + ex.getMessage());
        } finally {
          try {
            connectionProvider.releasePreparedStatement(st);
          } catch(Exception ignore){
            ignore.printStackTrace();
          }
        }
        
        return(objectCustomFieldData);
      }

}

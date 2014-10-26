//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ImportProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ImportProductData.class);
  private String InitRecordNumber="0";
  public String iProductId;
  public String mProductId;
  public String cBpartnerId;
  public String cTaxcategoryId;
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("i_product_id") || fieldName.equals("iProductId"))
      return iProductId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_taxcategory_id") || fieldName.equals("cTaxcategoryId"))
      return cTaxcategoryId;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ImportProductData[] select(ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    return select(connectionProvider, ad_client_id, 0, 0);
  }

  public static ImportProductData[] select(ConnectionProvider connectionProvider, String ad_client_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT I_Product_ID, M_Product_ID, C_BPartner_ID, '0' as C_TaxCategory_ID, '' AS ID, '' AS NAME" +
      "      FROM I_Product WHERE I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        ImportProductData objectImportProductData = new ImportProductData();
        objectImportProductData.iProductId = UtilSql.getValue(result, "i_product_id");
        objectImportProductData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectImportProductData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportProductData.cTaxcategoryId = UtilSql.getValue(result, "c_taxcategory_id");
        objectImportProductData.id = UtilSql.getValue(result, "id");
        objectImportProductData.name = UtilSql.getValue(result, "name");
        objectImportProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportProductData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    ImportProductData objectImportProductData[] = new ImportProductData[vector.size()];
    vector.copyInto(objectImportProductData);
    return(objectImportProductData);
  }

  public static int deleteOld(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      DELETE FROM I_Product WHERE I_IsImported='Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateRecords(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_Product " +
      "        SET AD_Client_ID = COALESCE(AD_Client_ID, ?)," +
      "        AD_Org_ID = COALESCE(AD_Org_ID, '0')," +
      "        IsActive = COALESCE(IsActive, 'Y')," +
      "        Created = COALESCE(Created, now())," +
      "        CreatedBy = COALESCE(CreatedBy, '0')," +
      "        Updated = COALESCE(Updated, now())," +
      "        UpdatedBy = COALESCE(UpdatedBy, '0')," +
      "        ProductType = COALESCE(ProductType, 'I')," +
      "        I_ErrorMsg = NULL," +
      "        I_IsImported = 'N' " +
      "        WHERE I_IsImported<>'Y' OR I_IsImported IS NULL";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateBPartner(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET C_BPartner_ID=(SELECT C_BPartner_ID FROM C_BPartner p" +
      "      WHERE I_Product.BPartner_Value=p.Value AND I_Product.AD_Client_ID=p.AD_Client_ID) " +
      "      WHERE C_BPartner_ID IS NULL" +
      "      AND BPartner_Value IS NOT NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateBPartnerError(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid BPartner,' " +
      "      WHERE C_BPartner_ID IS NULL" +
      "      AND BPartner_Value IS NOT NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductByUPC(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET M_Product_ID=(SELECT M_Product_ID FROM M_Product p" +
      "      WHERE I_Product.UPC=p.UPC AND I_Product.AD_Client_ID=p.AD_Client_ID) " +
      "      WHERE M_Product_ID IS NULL" +
      "      AND I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductByValue(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET M_Product_ID=(SELECT M_Product_ID FROM M_Product p" +
      "      WHERE I_Product.Value=p.Value AND I_Product.AD_Client_ID=p.AD_Client_ID) " +
      "      WHERE M_Product_ID IS NULL" +
      "      AND I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductByVendor(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET M_Product_ID=(SELECT M_Product_ID FROM M_Product_po p" +
      "      WHERE I_Product.C_BPartner_ID=p.C_BPartner_ID" +
      "      AND I_Product.VendorProductNo=p.VendorProductNo AND I_Product.AD_Client_ID=p.AD_Client_ID) " +
      "      WHERE M_Product_ID IS NULL" +
      "      AND I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductField(Connection conn, ConnectionProvider connectionProvider, String field, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET    ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "    = (SELECT   ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "     FROM M_Product p" +
      "      WHERE I_Product.M_Product_ID=p.M_Product_ID AND I_Product.AD_Client_ID=p.AD_Client_ID) " +
      "      WHERE M_Product_ID IS NOT NULL" +
      "      AND    ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "   IS NULL" +
      "      AND I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductNumField(Connection conn, ConnectionProvider connectionProvider, String field, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET    ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "  = (SELECT   ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "   FROM M_Product p" +
      "      WHERE I_Product.M_Product_ID=p.M_Product_ID AND I_Product.AD_Client_ID=p.AD_Client_ID) " +
      "      WHERE M_Product_ID IS NOT NULL" +
      "      AND (   ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "  IS NULL OR      ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "='0')" +
      "      AND I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductFieldPO(Connection conn, ConnectionProvider connectionProvider, String field, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET    ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "    = (SELECT    ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "     FROM M_Product_PO p where" +
      "      I_Product.M_Product_ID=p.M_Product_ID AND I_Product.C_BPartner_ID=p.C_BPartner_ID AND I_Product.AD_Client_ID=p.AD_Client_ID) " +
      "      WHERE M_Product_ID IS NOT NULL AND C_BPartner_ID IS NOT NULL" +
      "      AND    ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "   IS NULL" +
      "      AND I_IsImported='N'      " +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductNumFieldPO(Connection conn, ConnectionProvider connectionProvider, String field, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET    ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "   = (SELECT    ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "      FROM M_Product_PO p" +
      "      WHERE I_Product.M_Product_ID=p.M_Product_ID AND I_Product.C_BPartner_ID=p.C_BPartner_ID AND I_Product.AD_Client_ID=p.AD_Client_ID) " +
      "      WHERE M_Product_ID IS NOT NULL AND C_BPartner_ID IS NOT NULL" +
      "      AND (     ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "      IS NULL OR     ";
    strSql = strSql + ((field==null || field.equals(""))?"":field);
    strSql = strSql + 
      "     ='0')" +
      "      AND I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      if (field != null && !(field.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateX12DE355(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET X12DE355 = COALESCE ((SELECT MIN(X12DE355) " +
      "               FROM C_UOM u WHERE u.IsDefault='Y' " +
      "               AND u.AD_Client_ID IN ('0',I_Product.AD_Client_ID) " +
      "               ), 'EA')" +
      "      WHERE X12DE355 IS NULL AND C_UOM_ID IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND C_UOM_ID IS NULL      " +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductUOM(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET C_UOM_ID = (SELECT max(C_UOM_ID) FROM C_UOM u WHERE u.X12DE355=I_Product.X12DE355 AND u.AD_Client_ID IN ('0',I_Product.AD_Client_ID)) " +
      "      WHERE C_UOM_ID IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductInvalidUOM(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid UOM, ' " +
      "      WHERE C_UOM_ID IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductCategoryDefault(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET ProductCategory_Value=(SELECT MIN(Value) FROM M_Product_Category" +
      "      WHERE IsDefault='Y' AND AD_Client_ID=   ?) " +
      "      WHERE ProductCategory_Value IS NULL AND M_Product_Category_ID IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductCategory(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET M_Product_Category_ID=(SELECT M_Product_Category_ID FROM M_Product_Category c" +
      "      WHERE I_Product.ProductCategory_Value=c.Value AND I_Product.AD_Client_ID=c.AD_Client_ID) " +
      "      WHERE M_Product_Category_ID IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateInvalidCategory(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid ProdCategorty,' " +
      "      WHERE M_Product_Category_ID IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateCurrencyDefault(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET ISO_Code=(SELECT ISO_Code FROM C_Currency c, AD_Client ci      " +
      "      where ci.C_Currency_ID=c.C_Currency_ID    " +
      "	  and ci.AD_Client_ID=I_Product.AD_Client_ID) " +
      "      WHERE C_Currency_ID IS NULL AND ISO_Code IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateCurrency(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET C_Currency_ID=(SELECT C_Currency_ID FROM C_Currency c" +
      "      WHERE I_Product.ISO_Code=c.ISO_Code AND c.AD_Client_ID IN ('0',I_Product.AD_Client_ID)) " +
      "      WHERE C_Currency_ID IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateInvalidCurrency(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Currency,' " +
      "      WHERE C_Currency_ID IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateInvalidProductType(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Invalid ProductType,' " +
      "      WHERE ProductType NOT IN ('I','S')" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateNotUniqueValue(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=Value not unique,' " +
      "      WHERE I_IsImported<>'Y'" +
      "      AND Value IN (SELECT Value FROM I_Product ii WHERE I_Product.AD_Client_ID=ii.AD_Client_ID GROUP BY Value HAVING COUNT(*) > 1)" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateNotUniqueUPC(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=UPC not unique,' " +
      "      WHERE I_IsImported<>'Y'" +
      "      AND UPC IN (SELECT UPC FROM I_Product ii WHERE I_Product.AD_Client_ID=ii.AD_Client_ID GROUP BY UPC HAVING COUNT(*) > 1)" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateNoMandatoryValue(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=No Mandatory Value,' " +
      "      WHERE Value IS NULL" +
      "      AND I_IsImported<>'Y'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateVendorProductNoSetToValue(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET VendorProductNo=Value " +
      "      WHERE C_BPartner_ID IS NOT NULL AND VendorProductNo IS NULL" +
      "      AND I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateNotUniqueVendorProductNo(Connection conn, ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE I_Product  " +
      "        SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'ERR=VendorProductNo not unique,' " +
      "        WHERE I_IsImported<>'Y'" +
      "        AND C_BPartner_ID IS NOT NULL" +
      "        AND (C_BPartner_ID, VendorProductNo) IN " +
      "        (SELECT C_BPartner_ID, VendorProductNo FROM I_Product ii WHERE I_Product.AD_Client_ID=ii.AD_Client_ID GROUP BY C_BPartner_ID, VendorProductNo HAVING COUNT(*) > 1)" +
      "        AND AD_Client_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static String selectTaxCategory(ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_TaxCategory_ID FROM C_TaxCategory WHERE IsDefault='Y'" +
      "      AND AD_Client_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_taxcategory_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static ImportProductData[] selectRecords(ConnectionProvider connectionProvider, String ad_client_id)    throws ServletException {
    return selectRecords(connectionProvider, ad_client_id, 0, 0);
  }

  public static ImportProductData[] selectRecords(ConnectionProvider connectionProvider, String ad_client_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT I_Product_ID, M_Product_ID, C_BPartner_ID " +
      "      FROM I_Product WHERE I_IsImported='N'" +
      "      AND AD_Client_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        ImportProductData objectImportProductData = new ImportProductData();
        objectImportProductData.iProductId = UtilSql.getValue(result, "i_product_id");
        objectImportProductData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectImportProductData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectImportProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportProductData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    ImportProductData objectImportProductData[] = new ImportProductData[vector.size()];
    vector.copyInto(objectImportProductData);
    return(objectImportProductData);
  }

  public static int insertProductImport(Connection conn, ConnectionProvider connectionProvider, String MProductID, String IProductID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_Product (M_Product_ID," +
      "      AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy," +
      "      Value,Name,Description,DocumentNote,Help," +
      "      UPC,SKU,C_UOM_ID,IsSummary,M_Product_Category_ID," +
      "      ProductType, Classification," +
      "      Volume, Weight, ShelfWidth,ShelfHeight," +
      "      ShelfDepth, UnitsPerPallet, Discontinued, " +
      "      DiscontinuedBy, ImageURL,DescriptionURL) " +
      "      SELECT ?," +
      "      AD_Client_ID,AD_Org_ID,'Y',now(),CreatedBy,now(),UpdatedBy," +
      "      Value,Name,Description,DocumentNote,Help," +
      "      UPC,SKU,C_UOM_ID,'N',M_Product_Category_ID," +
      "      ProductType, Classification," +
      "      Volume, Weight, ShelfWidth,ShelfHeight," +
      "      ShelfDepth, UnitsPerPallet, Discontinued, " +
      "      DiscontinuedBy, ImageURL,DescriptionURL " +
      "      FROM I_Product " +
      "      WHERE I_Product_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductImport(Connection conn, ConnectionProvider connectionProvider, String IProductID, String MProductID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_PRODUCT " +
      "      SET Value= " +
      "      (SELECT Value" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      Name= " +
      "      (SELECT Name" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      Description= " +
      "      (SELECT Description" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      DocumentNote= " +
      "      (SELECT DocumentNote" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      Help= " +
      "      (SELECT Help" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      UPC= " +
      "      (SELECT UPC" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      SKU= " +
      "      (SELECT SKU" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      C_UOM_ID= " +
      "      (SELECT C_UOM_ID" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      M_Product_Category_ID= " +
      "      (SELECT M_Product_Category_ID" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      Classification= " +
      "      (SELECT Classification" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      ProductType= " +
      "      (SELECT ProductType" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      Volume= " +
      "      (SELECT Volume" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      Weight= " +
      "      (SELECT Weight" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      ShelfWidth= " +
      "      (SELECT ShelfWidth" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      ShelfHeight= " +
      "      (SELECT ShelfHeight" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      ShelfDepth= " +
      "      (SELECT ShelfDepth" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      UnitsPerPallet= " +
      "      (SELECT UnitsPerPallet" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      Discontinued= " +
      "      (SELECT Discontinued" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      DiscontinuedBy= " +
      "      (SELECT DiscontinuedBy" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      ImageURL= " +
      "      (SELECT ImageURL" +
      "      FROM I_Product WHERE I_Product_ID=?) ," +
      "      DescriptionURL= " +
      "      (SELECT DescriptionURL" +
      "      FROM I_Product WHERE I_Product_ID=?) ,            " +
      "      Updated=  now() ," +
      "      UpdatedBy= " +
      "      (SELECT UpdatedBy" +
      "      FROM I_Product WHERE I_Product_ID=?) " +
      "      WHERE M_Product_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductPOImport(Connection conn, ConnectionProvider connectionProvider, String IProductID, String MProductID, String CBPartnerID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE M_Product_PO " +
      "      SET IsCurrentVendor= 'Y'," +
      "      C_UOM_ID= " +
      "      (SELECT C_UOM_ID" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      C_Currency_ID= " +
      "      (SELECT C_Currency_ID" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      UPC= " +
      "      (SELECT UPC" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      PriceList= " +
      "      (SELECT PriceList" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      PricePO= " +
      "      (SELECT PricePO" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      RoyaltyAmt= " +
      "      (SELECT RoyaltyAmt" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      PriceEffective= " +
      "      (SELECT PriceEffective" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      VendorProductNo= " +
      "      (SELECT VendorProductNo" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      VendorCategory= " +
      "      (SELECT VendorCategory" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      Manufacturer= " +
      "      (SELECT Manufacturer" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      Discontinued= " +
      "      (SELECT Discontinued" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      DiscontinuedBy= " +
      "      (SELECT DiscontinuedBy" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      Order_Min= " +
      "      (SELECT Order_Min" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      Order_Pack= " +
      "      (SELECT Order_Pack" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      CostPerOrder= " +
      "      (SELECT CostPerOrder" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      DeliveryTime_Promised= " +
      "      (SELECT DeliveryTime_Promised" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) ," +
      "      Updated=now()," +
      "      UpdatedBy= " +
      "      (SELECT UpdatedBy" +
      "      FROM I_Product" +
      "      WHERE I_Product_ID=?) " +
      "      WHERE M_Product_ID=? AND C_BPartner_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CBPartnerID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int insertProductPOImport(Connection conn, ConnectionProvider connectionProvider, String MProductID, String CBPartnerID, String IProductID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO M_Product_PO (M_Product_PO_ID,M_Product_ID,C_BPartner_ID, " +
      "      AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy," +
      "      IsCurrentVendor,C_UOM_ID,C_Currency_ID,UPC," +
      "      PriceList, PricePO,RoyaltyAmt,PriceEffective," +
      "      VendorProductNo,VendorCategory,Manufacturer," +
      "      Discontinued,DiscontinuedBy,Order_Min,Order_Pack," +
      "      CostPerOrder,DeliveryTime_Promised) " +
      "      SELECT GET_UUID(),?,?, " +
      "      AD_Client_ID,AD_Org_ID,'Y',now(),CreatedBy,now(),UpdatedBy," +
      "      'Y',C_UOM_ID,C_Currency_ID,UPC," +
      "      PriceList,PricePO,RoyaltyAmt,PriceEffective," +
      "      VendorProductNo,VendorCategory,Manufacturer," +
      "      Discontinued,DiscontinuedBy,Order_Min,Order_Pack," +
      "      CostPerOrder,DeliveryTime_Promised " +
      "      FROM I_Product " +
      "      WHERE I_Product_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CBPartnerID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductSetImportY(ConnectionProvider connectionProvider, String MProductID, String IProductID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product SET I_IsImported='Y', M_Product_id = ?, " +
      "      Updated=now(), Processed='Y' WHERE I_Product_ID=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int insertProductError(ConnectionProvider connectionProvider, String error, String IProductID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'') || 'Insert Product: ' || ?" +
      "      WHERE I_Product_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, error);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductError(ConnectionProvider connectionProvider, String error, String IProductID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'Update Product: ' || ?" +
      "      WHERE I_Product_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, error);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateProductPOError(ConnectionProvider connectionProvider, String error, String IProductID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'Update Product_PO: ' || ?" +
      "      WHERE I_Product_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, error);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int insertProductPOError(ConnectionProvider connectionProvider, String error, String IProductID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product  " +
      "      SET I_IsImported='E', I_ErrorMsg=COALESCE(TO_CHAR(I_ErrorMsg),'')||'Insert Product_PO: ' || ?" +
      "      WHERE I_Product_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, error);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, IProductID);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateNotImported(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE I_Product " +
      "      SET I_IsImported='N', Updated=now()" +
      "      WHERE I_IsImported<>'Y'" +
      "      AND AD_CLIENT_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static ImportProductData[] selectClient(ConnectionProvider connectionProvider)    throws ServletException {
    return selectClient(connectionProvider, 0, 0);
  }

  public static ImportProductData[] selectClient(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_CLIENT_ID AS ID, NAME FROM AD_CLIENT";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        ImportProductData objectImportProductData = new ImportProductData();
        objectImportProductData.id = UtilSql.getValue(result, "id");
        objectImportProductData.name = UtilSql.getValue(result, "name");
        objectImportProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectImportProductData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    ImportProductData objectImportProductData[] = new ImportProductData[vector.size()];
    vector.copyInto(objectImportProductData);
    return(objectImportProductData);
  }
}

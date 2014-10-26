//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class InformeInOutData implements FieldProvider {
static Logger log4j = Logger.getLogger(InformeInOutData.class);
  private String InitRecordNumber="0";
  public String articulo;
  public String cliente;
  public String fechaEntrada;
  public String fechaSalida;
  public String cantidad;
  public String diasEstancia;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("articulo"))
      return articulo;
    else if (fieldName.equalsIgnoreCase("cliente"))
      return cliente;
    else if (fieldName.equalsIgnoreCase("fecha_entrada") || fieldName.equals("fechaEntrada"))
      return fechaEntrada;
    else if (fieldName.equalsIgnoreCase("fecha_salida") || fieldName.equals("fechaSalida"))
      return fechaSalida;
    else if (fieldName.equalsIgnoreCase("cantidad"))
      return cantidad;
    else if (fieldName.equalsIgnoreCase("dias_estancia") || fieldName.equals("diasEstancia"))
      return diasEstancia;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static InformeInOutData[] select(ConnectionProvider connectionProvider, String dateFormat, String fechaHasta, String fechaDesde, String categoria)    throws ServletException {
    return select(connectionProvider, dateFormat, fechaHasta, fechaDesde, categoria, 0, 0);
  }

  public static InformeInOutData[] select(ConnectionProvider connectionProvider, String dateFormat, String fechaHasta, String fechaDesde, String categoria, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ARTICULO, MAX(CLIENTE) AS CLIENTE, MAX(FECHA_ENTRADA) AS FECHA_ENTRADA, " +
      "      MAX(FECHA_SALIDA) AS FECHA_SALIDA, TO_CHAR(SUM(CANTIDAD) || ' ' || UNIDAD) AS CANTIDAD," +
      "      ROUND(to_number(COALESCE(Max(FECHA_SALIDA), to_date(?))-COALESCE(max(FECHA_ENTRADA), to_date(?))),0) AS DIAS_ESTANCIA" +
      "      FROM" +
      "      (" +
      "      SELECT TO_CHAR(P.NAME) AS ARTICULO, NULL AS CLIENTE," +
      "      TO_DATE(I_O.MOVEMENTDATE,to_char(?)) AS FECHA_ENTRADA, to_date(NULL) AS FECHA_SALIDA, " +
      "      SUM(I_O_L.MOVEMENTQTY)  AS CANTIDAD, U.NAME AS UNIDAD" +
      "      FROM M_PRODUCT P, M_INOUT I_O, M_INOUTLINE I_O_L, C_UOM U, M_PRODUCT_CATEGORY P_C" +
      "      WHERE I_O.M_INOUT_ID = I_O_L.M_INOUT_ID" +
      "      AND I_O_L.M_PRODUCT_ID= P.M_PRODUCT_ID" +
      "      AND I_O_L.C_UOM_ID= U.C_UOM_ID" +
      "      AND P_C.M_PRODUCT_CATEGORY_ID= P.M_PRODUCT_CATEGORY_ID" +
      "      AND I_O.MOVEMENTTYPE='C-'" +
      "      AND 1=1";
    strSql = strSql + ((categoria==null || categoria.equals(""))?"":"  AND P_C.M_PRODUCT_CATEGORY_ID = ?  ");
    strSql = strSql + 
      "      AND I_O.MOVEMENTDATE BETWEEN TO_DATE(?) AND TO_DATE(?)" +
      "      GROUP BY P.NAME, I_O.MOVEMENTDATE, U.NAME " +
      "      UNION" +
      "      SELECT TO_CHAR(P.NAME) AS ARTICULO, TO_CHAR(BP.NAME) AS CLIENTE, to_date(NULL) AS FECHA_ENTRADA," +
      "      TO_DATE(TO_CHAR(I_O.MOVEMENTDATE,to_char(?))) AS FECHA_SALIDA, SUM(I_O_L.MOVEMENTQTY) AS CANTIDAD, U.NAME AS UNIDAD  " +
      "      FROM M_PRODUCT P, M_INOUT I_O, M_INOUTLINE I_O_L, C_BPARTNER BP, C_UOM U, M_PRODUCT_CATEGORY P_C" +
      "      WHERE I_O.M_INOUT_ID = I_O_L.M_INOUT_ID" +
      "      AND I_O_L.M_PRODUCT_ID= P.M_PRODUCT_ID" +
      "      AND P_C.M_PRODUCT_CATEGORY_ID= P.M_PRODUCT_CATEGORY_ID" +
      "      AND I_O_L.C_UOM_ID= U.C_UOM_ID" +
      "      AND I_O.C_BPARTNER_ID= BP.C_BPARTNER_ID" +
      "      AND I_O.MOVEMENTTYPE='V+'" +
      "      AND 2=2";
    strSql = strSql + ((categoria==null || categoria.equals(""))?"":"  AND P_C.M_PRODUCT_CATEGORY_ID = ?  ");
    strSql = strSql + 
      "      AND I_O.MOVEMENTDATE BETWEEN ? AND ?" +
      "      GROUP BY P.NAME, BP.NAME, I_O.MOVEMENTDATE, U.NAME" +
      "      ) A" +
      "      GROUP BY ARTICULO, UNIDAD " +
      "      ORDER BY ARTICULO";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fechaHasta);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fechaDesde);
      if (categoria != null && !(categoria.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoria);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fechaDesde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fechaHasta);
      if (categoria != null && !(categoria.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoria);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fechaDesde);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fechaHasta);

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
        InformeInOutData objectInformeInOutData = new InformeInOutData();
        objectInformeInOutData.articulo = UtilSql.getValue(result, "articulo");
        objectInformeInOutData.cliente = UtilSql.getValue(result, "cliente");
        objectInformeInOutData.fechaEntrada = UtilSql.getDateValue(result, "fecha_entrada", "dd-MM-yyyy");
        objectInformeInOutData.fechaSalida = UtilSql.getDateValue(result, "fecha_salida", "dd-MM-yyyy");
        objectInformeInOutData.cantidad = UtilSql.getValue(result, "cantidad");
        objectInformeInOutData.diasEstancia = UtilSql.getValue(result, "dias_estancia");
        objectInformeInOutData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInformeInOutData);
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
    InformeInOutData objectInformeInOutData[] = new InformeInOutData[vector.size()];
    vector.copyInto(objectInformeInOutData);
    return(objectInformeInOutData);
  }
}

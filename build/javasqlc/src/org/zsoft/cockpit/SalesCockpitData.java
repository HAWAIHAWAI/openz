//Sqlc generated V1.O00-1
package org.zsoft.cockpit;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class SalesCockpitData implements FieldProvider {
static Logger log4j = Logger.getLogger(SalesCockpitData.class);
  private String InitRecordNumber="0";
  public String turnover;
  public String backorder;
  public String orders;
  public String offers;
  public String forecast;
  public String receivable;
  public String payable;
  public String turnoverRunrate;
  public String backorderRunrate;
  public String ordersRunrate;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("turnover"))
      return turnover;
    else if (fieldName.equalsIgnoreCase("backorder"))
      return backorder;
    else if (fieldName.equalsIgnoreCase("orders"))
      return orders;
    else if (fieldName.equalsIgnoreCase("offers"))
      return offers;
    else if (fieldName.equalsIgnoreCase("forecast"))
      return forecast;
    else if (fieldName.equalsIgnoreCase("receivable"))
      return receivable;
    else if (fieldName.equalsIgnoreCase("payable"))
      return payable;
    else if (fieldName.equalsIgnoreCase("turnover_runrate") || fieldName.equals("turnoverRunrate"))
      return turnoverRunrate;
    else if (fieldName.equalsIgnoreCase("backorder_runrate") || fieldName.equals("backorderRunrate"))
      return backorderRunrate;
    else if (fieldName.equalsIgnoreCase("orders_runrate") || fieldName.equals("ordersRunrate"))
      return ordersRunrate;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SalesCockpitData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static SalesCockpitData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT" +
      "			sum(	case o.docstatus " +
      "					when 'CO' then 1" +
      "					when 'DR' then 1" +
      "					else 0" +
      "					end * " +
      "				case ad_get_docbasetype(o.c_doctype_id)" +
      "					when 'SOO' then 1 " +
      "                                        else 0" +
      "					end * o.invoicedamt" +
      "			) as turnover," +
      "			sum(	case o.docstatus " +
      "					when 'CO' then 1" +
      "					when 'DR' then 1" +
      "					else 0" +
      "					end * " +
      "				case ad_get_docbasetype(o.c_doctype_id)" +
      "                                        when 'SOO' then 1 " +
      "                                        else 0" +
      "					end *  o.totallines" +
      "			) - sum(	case o.docstatus " +
      "                                        when 'CO' then 1" +
      "                                        when 'DR' then 1" +
      "                                        else 0" +
      "                                        end * " +
      "                                case ad_get_docbasetype(o.c_doctype_id)" +
      "                                        when 'SOO' then 1 " +
      "                                        else 0" +
      "                                        end * o.invoicedamt" +
      "			) as backorder," +
      "			sum(	case o.docstatus " +
      "                                        when 'CO' then 1" +
      "                                        when 'DR' then 1" +
      "                                        else 0" +
      "                                        end * " +
      "                                case ad_get_docbasetype(o.c_doctype_id)" +
      "                                        when 'SOO' then 1 " +
      "                                        else 0" +
      "                                        end * o.totallines" +
      "			) as orders," +
      "			sum(	case o.docstatus " +
      "					when 'CO' then 1" +
      "					when 'DR' then 1" +
      "					else 0" +
      "					end *" +
      "				case ad_get_docbasetype(o.c_doctype_id)" +
      "					when 'SALESOFFER' then 1 " +
      "					else 0" +
      "					end * case o.completeordervalue when 0 then o.totallines else o.completeordervalue end" +
      "			) as offers," +
      "			(select sum(linenetamt) from mrp_salesforecast" +
      "			) as forecast," +
      "			(select sum(amount) from " +
      "				(select " +
      "					dp.amount" +
      "				from 	" +
      "					c_debt_payment dp," +
      "					ad_ref_list rl 	left join ad_ref_list_trl rlt on rl.ad_ref_list_id = rlt.ad_ref_list_id and rlt.ad_language = 'de_DE'," +
      "					ad_ref_list rl2	left join ad_ref_list_trl rlt2 on rl2.ad_ref_list_id = rlt2.ad_ref_list_id and rlt2.ad_language = 'de_DE'," +
      "					c_currency c " +
      "				where " +
      "					dp.c_currency_id = c.c_currency_id and" +
      "					dp.paymentrule = rl.value and" +
      "					rl.ad_reference_id = '195' and" +
      "					dp.status = rl2.value and" +
      "					rl2.ad_reference_id = '800070' and" +
      "					dp.isactive='Y' and" +
      "					dp.isvalid='Y' and" +
      "					dp.isreceipt='Y' and" +
      "					c_debt_payment_status(dp.c_settlement_cancel_id, dp.cancel_processed, dp.generate_processed, dp.ispaid, dp.isvalid, dp.c_cashline_id, dp.c_bankstatementline_id) in ('P')) temptable" +
      "			) as receivable," +
      "			(select sum(amount) from " +
      "				(select " +
      "					dp.amount" +
      "				from 	" +
      "					c_debt_payment dp," +
      "					ad_ref_list rl 	left join ad_ref_list_trl rlt on rl.ad_ref_list_id = rlt.ad_ref_list_id and rlt.ad_language = 'de_DE'," +
      "					ad_ref_list rl2	left join ad_ref_list_trl rlt2 on rl2.ad_ref_list_id = rlt2.ad_ref_list_id and rlt2.ad_language = 'de_DE'," +
      "					c_currency c " +
      "				where " +
      "					dp.c_currency_id = c.c_currency_id and" +
      "					dp.paymentrule = rl.value and" +
      "					rl.ad_reference_id = '195' and" +
      "					dp.status = rl2.value and" +
      "					rl2.ad_reference_id = '800070' and" +
      "					dp.isactive='Y' and" +
      "					dp.isvalid='Y' and" +
      "					dp.isreceipt='N' and" +
      "					c_debt_payment_status(dp.c_settlement_cancel_id, dp.cancel_processed, dp.generate_processed, dp.ispaid, dp.isvalid, dp.c_cashline_id, dp.c_bankstatementline_id) in ('P')) temptable" +
      "			) as payable," +
      "			sum(	case o.docstatus " +
      "					when 'CO' then 1" +
      "					when 'DR' then 1" +
      "					else 0" +
      "					end * " +
      "				case o.c_doctype_id" +
      "					when '5D5792C53FBA46E2988653B6DC9FE5B4' then 1" +
      "					when '1052C4B77714415C8CF89DEB7B4349A3' then 1 " +
      "					when 'ABE2033C7A74499A9750346A83DE3307' then 1 " +
      "					when '0' then 1 " +
      "					else 0" +
      "					end * " +
      "				case o.c_doctypetarget_id " +
      "					when '5D5792C53FBA46E2988653B6DC9FE5B4' then 1 " +
      "					when '1052C4B77714415C8CF89DEB7B4349A3' then 1 " +
      "					when 'ABE2033C7A74499A9750346A83DE3307' then 1 " +
      "					else 0" +
      "					end * o.invoicedamt" +
      "			) * 365 / (select now()::date - '2011-10-04'::date)" +
      "			as turnover_runrate," +
      "			(sum(	case o.docstatus " +
      "					when 'CO' then 1" +
      "					when 'DR' then 1" +
      "					else 0" +
      "					end * " +
      "				case o.c_doctype_id" +
      "					when '5D5792C53FBA46E2988653B6DC9FE5B4' then 1 " +
      "					when '1052C4B77714415C8CF89DEB7B4349A3' then 1 " +
      "					when 'ABE2033C7A74499A9750346A83DE3307' then 1 " +
      "					when '0' then 1 " +
      "					else 0" +
      "					end * " +
      "				case o.c_doctypetarget_id " +
      "					when '5D5792C53FBA46E2988653B6DC9FE5B4' then 1 " +
      "					when '1052C4B77714415C8CF89DEB7B4349A3' then 1 " +
      "					when 'ABE2033C7A74499A9750346A83DE3307' then 1 " +
      "					else 0" +
      "					end * o.totallines" +
      "			) - sum(	case o.docstatus " +
      "					when 'CO' then 1" +
      "					when 'DR' then 1" +
      "					else 0" +
      "					end * " +
      "				case o.c_doctype_id" +
      "					when '5D5792C53FBA46E2988653B6DC9FE5B4' then 1 " +
      "					when '1052C4B77714415C8CF89DEB7B4349A3' then 1 " +
      "					when 'ABE2033C7A74499A9750346A83DE3307' then 1 " +
      "					when '0' then 1 " +
      "					else 0" +
      "					end * " +
      "				case o.c_doctypetarget_id " +
      "					when '5D5792C53FBA46E2988653B6DC9FE5B4' then 1 " +
      "					when '1052C4B77714415C8CF89DEB7B4349A3' then 1 " +
      "					when 'ABE2033C7A74499A9750346A83DE3307' then 1 " +
      "					else 0" +
      "					end * o.invoicedamt" +
      "			)) * 365 / (select now()::date - '2011-10-04'::date) " +
      "			as backorder_runrate," +
      "			sum(	case o.docstatus " +
      "					when 'CO' then 1" +
      "					when 'DR' then 1" +
      "					else 0" +
      "					end * " +
      "				case o.c_doctype_id" +
      "					when '5D5792C53FBA46E2988653B6DC9FE5B4' then 1 " +
      "					when '1052C4B77714415C8CF89DEB7B4349A3' then 1 " +
      "					when 'ABE2033C7A74499A9750346A83DE3307' then 1 " +
      "					when '0' then 1 " +
      "					else 0" +
      "					end * " +
      "				case o.c_doctypetarget_id " +
      "					when '5D5792C53FBA46E2988653B6DC9FE5B4' then 1 " +
      "					when '1052C4B77714415C8CF89DEB7B4349A3' then 1 " +
      "					when 'ABE2033C7A74499A9750346A83DE3307' then 1 " +
      "					else 0" +
      "					end * o.totallines" +
      "			) * 365 / (select now()::date - '2011-10-04'::date) " +
      "			as orders_runrate" +
      "		FROM 	" +
      "			c_order o";

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
        SalesCockpitData objectSalesCockpitData = new SalesCockpitData();
        objectSalesCockpitData.turnover = UtilSql.getValue(result, "turnover");
        objectSalesCockpitData.backorder = UtilSql.getValue(result, "backorder");
        objectSalesCockpitData.orders = UtilSql.getValue(result, "orders");
        objectSalesCockpitData.offers = UtilSql.getValue(result, "offers");
        objectSalesCockpitData.forecast = UtilSql.getValue(result, "forecast");
        objectSalesCockpitData.receivable = UtilSql.getValue(result, "receivable");
        objectSalesCockpitData.payable = UtilSql.getValue(result, "payable");
        objectSalesCockpitData.turnoverRunrate = UtilSql.getValue(result, "turnover_runrate");
        objectSalesCockpitData.backorderRunrate = UtilSql.getValue(result, "backorder_runrate");
        objectSalesCockpitData.ordersRunrate = UtilSql.getValue(result, "orders_runrate");
        objectSalesCockpitData.rownum = Long.toString(countRecord);
        objectSalesCockpitData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesCockpitData);
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
    SalesCockpitData objectSalesCockpitData[] = new SalesCockpitData[vector.size()];
    vector.copyInto(objectSalesCockpitData);
    return(objectSalesCockpitData);
  }
}

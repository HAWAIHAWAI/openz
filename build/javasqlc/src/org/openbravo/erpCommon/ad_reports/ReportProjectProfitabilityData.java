//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ReportProjectProfitabilityData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportProjectProfitabilityData.class);
  private String InitRecordNumber="0";
  public String actualcostamount;
  public String materialcost;
  public String indirectcost;
  public String workcost;
  public String externalcost;
  public String machinecost;
  public String revenue;
  public String plancost;
  public String contractamount;
  public String income;
  public String planincome;
  public String matcostplan;
  public String indcostplan;
  public String machinecostplan;
  public String workcostplan;
  public String externalcostplan;
  public String orgname;
  public String partner;
  public String projectname;
  public String responsible;
  public String projecttype;
  public String initdate;
  public String contractdate;
  public String enddate;
  public String org;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("workcost"))
      return workcost;
    else if (fieldName.equalsIgnoreCase("externalcost"))
      return externalcost;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("revenue"))
      return revenue;
    else if (fieldName.equalsIgnoreCase("plancost"))
      return plancost;
    else if (fieldName.equalsIgnoreCase("contractamount"))
      return contractamount;
    else if (fieldName.equalsIgnoreCase("income"))
      return income;
    else if (fieldName.equalsIgnoreCase("planincome"))
      return planincome;
    else if (fieldName.equalsIgnoreCase("matcostplan"))
      return matcostplan;
    else if (fieldName.equalsIgnoreCase("indcostplan"))
      return indcostplan;
    else if (fieldName.equalsIgnoreCase("machinecostplan"))
      return machinecostplan;
    else if (fieldName.equalsIgnoreCase("workcostplan"))
      return workcostplan;
    else if (fieldName.equalsIgnoreCase("externalcostplan"))
      return externalcostplan;
    else if (fieldName.equalsIgnoreCase("orgname"))
      return orgname;
    else if (fieldName.equalsIgnoreCase("partner"))
      return partner;
    else if (fieldName.equalsIgnoreCase("projectname"))
      return projectname;
    else if (fieldName.equalsIgnoreCase("responsible"))
      return responsible;
    else if (fieldName.equalsIgnoreCase("projecttype"))
      return projecttype;
    else if (fieldName.equalsIgnoreCase("initdate"))
      return initdate;
    else if (fieldName.equalsIgnoreCase("contractdate"))
      return contractdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportProjectProfitabilityData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String orgid, String dateFrom, String dateTo, String datefrom2, String dateto2, String dateFrom3, String dateTo3, String projecttype, String project, String Responsible, String Partner)    throws ServletException {
    return select(connectionProvider, adLanguage, adUserClient, adUserOrg, orgid, dateFrom, dateTo, datefrom2, dateto2, dateFrom3, dateTo3, projecttype, project, Responsible, Partner, 0, 0);
  }

  public static ReportProjectProfitabilityData[] select(ConnectionProvider connectionProvider, String adLanguage, String adUserClient, String adUserOrg, String orgid, String dateFrom, String dateTo, String datefrom2, String dateto2, String dateFrom3, String dateTo3, String projecttype, String project, String Responsible, String Partner, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select coalesce(pr.actualcostamount,0) as actualcostamount,coalesce(pr.materialcost,0) as materialcost,coalesce(pr.indirectcost,0) as indirectcost,coalesce(pr.servcost,0) as workcost," +
      "       coalesce(pr.expenses,0) as externalcost, coalesce(pr.machinecost,0) as machinecost,coalesce(pr.invoicedamt,0) as revenue," +
      "       coalesce(pr.plannedamt,0) as plancost,coalesce(pr.committedamt,0) as contractamount,coalesce(coalesce(pr.invoicedamt,0)-coalesce(pr.actualcostamount,0),0) as income," +
      "       coalesce(coalesce(pr.committedamt,0)-coalesce(pr.plannedamt,0),0) as planincome," +
      "       sum(coalesce(pt.materialcostplan,0)) as matcostplan, sum(coalesce(pt.indirectcostplan,0)) as indcostplan, sum(coalesce(pt.machinecostplan,0)) as machinecostplan ," +
      "       sum(coalesce(pt.servcostplan,0)) as workcostplan  ,  sum(0) as externalcostplan,  " +
      "       org.name as ORGNAME,bp.name as partner,pr.name as projectname,ad_user.NAME AS responsible,zssi_getListRefText('288',pr.ProjectCategory,?) as projecttype," +
      "       zssi_strDate(pr.startdate,?) as initdate, zssi_strDate(pr.datecontract,?) as contractdate, zssi_strDate(pr.datefinish,?) as enddate," +
      "       org.ad_org_id as org" +
      "   from c_project pr" +
      "     left join c_bpartner bp on pr.c_bpartner_id=bp.c_bpartner_id" +
      "     left join ad_user on ad_user.ad_user_id=pr.ad_user_id" +
      "     left join c_projecttask pt on pt.c_projectphase_id in (select c_projectphase_id from c_projectphase where c_projectphase.c_project_id=pr.c_project_id)," +
      "     ad_org org" +
      "  where" +
      "    org.ad_org_id=pr.ad_org_id " +
      "    and pr.projectcategory in ('C','CS','P','S')" +
      "    AND PR.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "    AND PR.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "    AND 1=1";
    strSql = strSql + ((orgid==null || orgid.equals(""))?"":"  AND pr.ad_org_id = ?  ");
    strSql = strSql + ((dateFrom==null || dateFrom.equals(""))?"":"  AND pr.Datecontract >= to_date(?)  ");
    strSql = strSql + ((dateTo==null || dateTo.equals(""))?"":"  AND pr.Datecontract < to_date(?)  ");
    strSql = strSql + 
      "    AND 2=2";
    strSql = strSql + ((datefrom2==null || datefrom2.equals(""))?"":"  AND pr.datefinish>= to_date(?)  ");
    strSql = strSql + ((dateto2==null || dateto2.equals(""))?"":"  AND pr.datefinish  < to_date(?)  ");
    strSql = strSql + 
      "    AND 3=3";
    strSql = strSql + ((dateFrom3==null || dateFrom3.equals(""))?"":"  AND pr.Startdate >= to_date(?)  ");
    strSql = strSql + ((dateTo3==null || dateTo3.equals(""))?"":"  AND pr.Startdate < to_date(?)  ");
    strSql = strSql + 
      "    AND 6=6";
    strSql = strSql + ((projecttype==null || projecttype.equals(""))?"":"  AND pr.C_Projecttype_ID = ?  ");
    strSql = strSql + ((project==null || project.equals(""))?"":"  AND pr.C_Project_ID = ?  ");
    strSql = strSql + ((Responsible==null || Responsible.equals(""))?"":"  AND pr.Responsible_ID = ?  ");
    strSql = strSql + ((Partner==null || Partner.equals(""))?"":"  AND pr.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "   group by pr.c_project_id,pr.actualcostamount,pr.materialcost,pr.indirectcost,pr.servcost,pr.machinecost,pr.expenses,pr.invoicedamt,pr.plannedamt,pr.committedamt,org.name,org.ad_org_id,bp.name,pr.name,ad_user.NAME,pr.startdate,pr.ProjectCategory,pr.datecontract,pr.datefinish";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (orgid != null && !(orgid.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgid);
      }
      if (dateFrom != null && !(dateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      }
      if (dateTo != null && !(dateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      }
      if (datefrom2 != null && !(datefrom2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom2);
      }
      if (dateto2 != null && !(dateto2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto2);
      }
      if (dateFrom3 != null && !(dateFrom3.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom3);
      }
      if (dateTo3 != null && !(dateTo3.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo3);
      }
      if (projecttype != null && !(projecttype.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttype);
      }
      if (project != null && !(project.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, project);
      }
      if (Responsible != null && !(Responsible.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, Responsible);
      }
      if (Partner != null && !(Partner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, Partner);
      }

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
        ReportProjectProfitabilityData objectReportProjectProfitabilityData = new ReportProjectProfitabilityData();
        objectReportProjectProfitabilityData.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectReportProjectProfitabilityData.materialcost = UtilSql.getValue(result, "materialcost");
        objectReportProjectProfitabilityData.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectReportProjectProfitabilityData.workcost = UtilSql.getValue(result, "workcost");
        objectReportProjectProfitabilityData.externalcost = UtilSql.getValue(result, "externalcost");
        objectReportProjectProfitabilityData.machinecost = UtilSql.getValue(result, "machinecost");
        objectReportProjectProfitabilityData.revenue = UtilSql.getValue(result, "revenue");
        objectReportProjectProfitabilityData.plancost = UtilSql.getValue(result, "plancost");
        objectReportProjectProfitabilityData.contractamount = UtilSql.getValue(result, "contractamount");
        objectReportProjectProfitabilityData.income = UtilSql.getValue(result, "income");
        objectReportProjectProfitabilityData.planincome = UtilSql.getValue(result, "planincome");
        objectReportProjectProfitabilityData.matcostplan = UtilSql.getValue(result, "matcostplan");
        objectReportProjectProfitabilityData.indcostplan = UtilSql.getValue(result, "indcostplan");
        objectReportProjectProfitabilityData.machinecostplan = UtilSql.getValue(result, "machinecostplan");
        objectReportProjectProfitabilityData.workcostplan = UtilSql.getValue(result, "workcostplan");
        objectReportProjectProfitabilityData.externalcostplan = UtilSql.getValue(result, "externalcostplan");
        objectReportProjectProfitabilityData.orgname = UtilSql.getValue(result, "orgname");
        objectReportProjectProfitabilityData.partner = UtilSql.getValue(result, "partner");
        objectReportProjectProfitabilityData.projectname = UtilSql.getValue(result, "projectname");
        objectReportProjectProfitabilityData.responsible = UtilSql.getValue(result, "responsible");
        objectReportProjectProfitabilityData.projecttype = UtilSql.getValue(result, "projecttype");
        objectReportProjectProfitabilityData.initdate = UtilSql.getValue(result, "initdate");
        objectReportProjectProfitabilityData.contractdate = UtilSql.getValue(result, "contractdate");
        objectReportProjectProfitabilityData.enddate = UtilSql.getValue(result, "enddate");
        objectReportProjectProfitabilityData.org = UtilSql.getValue(result, "org");
        objectReportProjectProfitabilityData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProjectProfitabilityData);
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
    ReportProjectProfitabilityData objectReportProjectProfitabilityData[] = new ReportProjectProfitabilityData[vector.size()];
    vector.copyInto(objectReportProjectProfitabilityData);
    return(objectReportProjectProfitabilityData);
  }

  public static ReportProjectProfitabilityData[] set()    throws ServletException {
    ReportProjectProfitabilityData objectReportProjectProfitabilityData[] = new ReportProjectProfitabilityData[1];
    objectReportProjectProfitabilityData[0] = new ReportProjectProfitabilityData();
    objectReportProjectProfitabilityData[0].actualcostamount = "";
    objectReportProjectProfitabilityData[0].materialcost = "";
    objectReportProjectProfitabilityData[0].indirectcost = "";
    objectReportProjectProfitabilityData[0].workcost = "";
    objectReportProjectProfitabilityData[0].externalcost = "";
    objectReportProjectProfitabilityData[0].machinecost = "";
    objectReportProjectProfitabilityData[0].revenue = "";
    objectReportProjectProfitabilityData[0].plancost = "";
    objectReportProjectProfitabilityData[0].contractamount = "";
    objectReportProjectProfitabilityData[0].income = "";
    objectReportProjectProfitabilityData[0].planincome = "";
    objectReportProjectProfitabilityData[0].matcostplan = "";
    objectReportProjectProfitabilityData[0].indcostplan = "";
    objectReportProjectProfitabilityData[0].machinecostplan = "";
    objectReportProjectProfitabilityData[0].workcostplan = "";
    objectReportProjectProfitabilityData[0].externalcostplan = "";
    objectReportProjectProfitabilityData[0].orgname = "";
    objectReportProjectProfitabilityData[0].partner = "";
    objectReportProjectProfitabilityData[0].projectname = "";
    objectReportProjectProfitabilityData[0].responsible = "";
    objectReportProjectProfitabilityData[0].projecttype = "";
    objectReportProjectProfitabilityData[0].initdate = "";
    objectReportProjectProfitabilityData[0].contractdate = "";
    objectReportProjectProfitabilityData[0].enddate = "";
    objectReportProjectProfitabilityData[0].org = "";
    return objectReportProjectProfitabilityData;
  }
}

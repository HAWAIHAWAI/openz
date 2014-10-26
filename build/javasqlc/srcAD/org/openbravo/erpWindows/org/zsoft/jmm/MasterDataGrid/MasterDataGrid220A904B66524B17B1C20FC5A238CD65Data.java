//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.jmm.MasterDataGrid;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data implements FieldProvider {
static Logger log4j = Logger.getLogger(MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String user1Id;
  public String isselfservice;
  public String adOrgtrxId;
  public String dropshipLocationId;
  public String copyfrom;
  public String user2Id;
  public String dropshipUserId;
  public String dropshipBpartnerId;
  public String adClientId;
  public String adClientIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String incotermsdescription;
  public String poreference;
  public String generatetemplate;
  public String dateordered;
  public String transactionreference;
  public String copyfrompo;
  public String aAssetId;
  public String cDoctypetargetId;
  public String cDoctypetargetIdr;
  public String name;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String docstatus;
  public String docstatusr;
  public String description;
  public String deliverynotes;
  public String internalnote;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String bpzipcode;
  public String billtoId;
  public String billtoIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String adUserId;
  public String adUserIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String mPricelistId;
  public String mPricelistIdr;
  public String isdiscountprinted;
  public String invoicerule;
  public String invoiceruler;
  public String estpropability;
  public String estpropabilityr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String deliveryrule;
  public String deliveryruler;
  public String priorityrule;
  public String priorityruler;
  public String paymentrule;
  public String paymentruler;
  public String cPaymenttermId;
  public String cPaymenttermIdr;
  public String cIncotermsId;
  public String cIncotermsIdr;
  public String deliveryLocationId;
  public String deliveryLocationIdr;
  public String deliveryviarule;
  public String deliveryviaruler;
  public String mShipperId;
  public String mShipperIdr;
  public String weight;
  public String weightUom;
  public String weightUomr;
  public String freightcostrule;
  public String freightcostruler;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String freightamt;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String orderselfjoin;
  public String orderselfjoinr;
  public String firstschedinvoicedate;
  public String datepromised;
  public String scheddeliverydate;
  public String schedtransactiondate;
  public String transactiondate;
  public String contractdate;
  public String enddate;
  public String invoicefrequence;
  public String invoicefrequencer;
  public String cProjectphaseId;
  public String isinvoiceafterfirstcycle;
  public String quarterlyMonth;
  public String quarterlyMonthr;
  public String yearlyMonth;
  public String yearlyMonthr;
  public String weeklyDay;
  public String weeklyDayr;
  public String cBidprojectId;
  public String monthlyDay;
  public String proposalstatus;
  public String proposalstatusr;
  public String lostproposalfixedreason;
  public String lostproposalfixedreasonr;
  public String lostproposalreason;
  public String totallinesonetime;
  public String grandtotalonetime;
  public String totallines;
  public String grandtotal;
  public String generateproject;
  public String closeproject;
  public String invoicedamt;
  public String totalpaid;
  public String completeordervalue;
  public String deliverycomplete;
  public String iscompletelyinvoiced;
  public String juwimmCompletion;
  public String juwimmCompletionr;
  public String juwimmTime;
  public String juwimmTimer;
  public String juwimmResources;
  public String juwimmResourcesr;
  public String juwimmBudget;
  public String juwimmBudgetr;
  public String juwimmTeamId;
  public String juwimmTeamIdr;
  public String juwimmPlannedgolive;
  public String juwimmEstgolive;
  public String juwimmNextimpdate;
  public String juwimmDescription;
  public String juwimmPlannedstart;
  public String juwimmEststart;
  public String juwimmMilestone1;
  public String juwimmMs1planneddate;
  public String juwimmMs1estdate;
  public String juwimmMilestone2;
  public String juwimmMs2planneddate;
  public String juwimmMs2estdate;
  public String juwimmMilestone3;
  public String juwimmMs3planneddate;
  public String juwimmMs3estdate;
  public String juwimmMilestone4;
  public String juwimmMs4planneddate;
  public String juwimmMs4estdate;
  public String juwimmMilestone5;
  public String juwimmMs5planneddate;
  public String ispaid;
  public String isrecharge;
  public String juwimmMs5estdate;
  public String juwimmMilestone6;
  public String btncopytemplate;
  public String juwimmMs6planneddate;
  public String juwimmMs6estdate;
  public String subscriptionchangedate;
  public String juwimmMilestone7;
  public String juwimmMs7planneddate;
  public String juwimmOrderstatuscompleteVId;
  public String juwimmMs7estdate;
  public String juwimmPlannedend;
  public String juwimmOrderstatusId;
  public String juwimmEstend;
  public String juwimmProjectman;
  public String juwimmOuputremarks;
  public String juwimmLastaction;
  public String juwimmNextaction;
  public String juwimmIssues;
  public String juwimmDecisions;
  public String juwimmLastupdateon;
  public String juwimmLastupdateby;
  public String juwimmLastupdatebyr;
  public String cChargeId;
  public String isdelivered;
  public String cActivityId;
  public String processed;
  public String issotrx;
  public String docaction;
  public String cCampaignId;
  public String istaxincluded;
  public String dateprinted;
  public String isinvoiced;
  public String dateacct;
  public String cOrderId;
  public String isselected;
  public String isprinted;
  public String posted;
  public String isactive;
  public String processing;
  public String chargeamt;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("dropship_location_id") || fieldName.equals("dropshipLocationId"))
      return dropshipLocationId;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("dropship_user_id") || fieldName.equals("dropshipUserId"))
      return dropshipUserId;
    else if (fieldName.equalsIgnoreCase("dropship_bpartner_id") || fieldName.equals("dropshipBpartnerId"))
      return dropshipBpartnerId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_client_idr") || fieldName.equals("adClientIdr"))
      return adClientIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("incotermsdescription"))
      return incotermsdescription;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("generatetemplate"))
      return generatetemplate;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("transactionreference"))
      return transactionreference;
    else if (fieldName.equalsIgnoreCase("copyfrompo"))
      return copyfrompo;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_idr") || fieldName.equals("cDoctypetargetIdr"))
      return cDoctypetargetIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("deliverynotes"))
      return deliverynotes;
    else if (fieldName.equalsIgnoreCase("internalnote"))
      return internalnote;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("bpzipcode"))
      return bpzipcode;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("billto_idr") || fieldName.equals("billtoIdr"))
      return billtoIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("invoiceruler"))
      return invoiceruler;
    else if (fieldName.equalsIgnoreCase("estpropability"))
      return estpropability;
    else if (fieldName.equalsIgnoreCase("estpropabilityr"))
      return estpropabilityr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("deliveryruler"))
      return deliveryruler;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("priorityruler"))
      return priorityruler;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("paymentruler"))
      return paymentruler;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_idr") || fieldName.equals("cPaymenttermIdr"))
      return cPaymenttermIdr;
    else if (fieldName.equalsIgnoreCase("c_incoterms_id") || fieldName.equals("cIncotermsId"))
      return cIncotermsId;
    else if (fieldName.equalsIgnoreCase("c_incoterms_idr") || fieldName.equals("cIncotermsIdr"))
      return cIncotermsIdr;
    else if (fieldName.equalsIgnoreCase("delivery_location_id") || fieldName.equals("deliveryLocationId"))
      return deliveryLocationId;
    else if (fieldName.equalsIgnoreCase("delivery_location_idr") || fieldName.equals("deliveryLocationIdr"))
      return deliveryLocationIdr;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("deliveryviaruler"))
      return deliveryviaruler;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("m_shipper_idr") || fieldName.equals("mShipperIdr"))
      return mShipperIdr;
    else if (fieldName.equalsIgnoreCase("weight"))
      return weight;
    else if (fieldName.equalsIgnoreCase("weight_uom") || fieldName.equals("weightUom"))
      return weightUom;
    else if (fieldName.equalsIgnoreCase("weight_uomr") || fieldName.equals("weightUomr"))
      return weightUomr;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("freightcostruler"))
      return freightcostruler;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("orderselfjoin"))
      return orderselfjoin;
    else if (fieldName.equalsIgnoreCase("orderselfjoinr"))
      return orderselfjoinr;
    else if (fieldName.equalsIgnoreCase("firstschedinvoicedate"))
      return firstschedinvoicedate;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("schedtransactiondate"))
      return schedtransactiondate;
    else if (fieldName.equalsIgnoreCase("transactiondate"))
      return transactiondate;
    else if (fieldName.equalsIgnoreCase("contractdate"))
      return contractdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("invoicefrequence"))
      return invoicefrequence;
    else if (fieldName.equalsIgnoreCase("invoicefrequencer"))
      return invoicefrequencer;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("isinvoiceafterfirstcycle"))
      return isinvoiceafterfirstcycle;
    else if (fieldName.equalsIgnoreCase("quarterly_month") || fieldName.equals("quarterlyMonth"))
      return quarterlyMonth;
    else if (fieldName.equalsIgnoreCase("quarterly_monthr") || fieldName.equals("quarterlyMonthr"))
      return quarterlyMonthr;
    else if (fieldName.equalsIgnoreCase("yearly_month") || fieldName.equals("yearlyMonth"))
      return yearlyMonth;
    else if (fieldName.equalsIgnoreCase("yearly_monthr") || fieldName.equals("yearlyMonthr"))
      return yearlyMonthr;
    else if (fieldName.equalsIgnoreCase("weekly_day") || fieldName.equals("weeklyDay"))
      return weeklyDay;
    else if (fieldName.equalsIgnoreCase("weekly_dayr") || fieldName.equals("weeklyDayr"))
      return weeklyDayr;
    else if (fieldName.equalsIgnoreCase("c_bidproject_id") || fieldName.equals("cBidprojectId"))
      return cBidprojectId;
    else if (fieldName.equalsIgnoreCase("monthly_day") || fieldName.equals("monthlyDay"))
      return monthlyDay;
    else if (fieldName.equalsIgnoreCase("proposalstatus"))
      return proposalstatus;
    else if (fieldName.equalsIgnoreCase("proposalstatusr"))
      return proposalstatusr;
    else if (fieldName.equalsIgnoreCase("lostproposalfixedreason"))
      return lostproposalfixedreason;
    else if (fieldName.equalsIgnoreCase("lostproposalfixedreasonr"))
      return lostproposalfixedreasonr;
    else if (fieldName.equalsIgnoreCase("lostproposalreason"))
      return lostproposalreason;
    else if (fieldName.equalsIgnoreCase("totallinesonetime"))
      return totallinesonetime;
    else if (fieldName.equalsIgnoreCase("grandtotalonetime"))
      return grandtotalonetime;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("generateproject"))
      return generateproject;
    else if (fieldName.equalsIgnoreCase("closeproject"))
      return closeproject;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("totalpaid"))
      return totalpaid;
    else if (fieldName.equalsIgnoreCase("completeordervalue"))
      return completeordervalue;
    else if (fieldName.equalsIgnoreCase("deliverycomplete"))
      return deliverycomplete;
    else if (fieldName.equalsIgnoreCase("iscompletelyinvoiced"))
      return iscompletelyinvoiced;
    else if (fieldName.equalsIgnoreCase("juwimm_completion") || fieldName.equals("juwimmCompletion"))
      return juwimmCompletion;
    else if (fieldName.equalsIgnoreCase("juwimm_completionr") || fieldName.equals("juwimmCompletionr"))
      return juwimmCompletionr;
    else if (fieldName.equalsIgnoreCase("juwimm_time") || fieldName.equals("juwimmTime"))
      return juwimmTime;
    else if (fieldName.equalsIgnoreCase("juwimm_timer") || fieldName.equals("juwimmTimer"))
      return juwimmTimer;
    else if (fieldName.equalsIgnoreCase("juwimm_resources") || fieldName.equals("juwimmResources"))
      return juwimmResources;
    else if (fieldName.equalsIgnoreCase("juwimm_resourcesr") || fieldName.equals("juwimmResourcesr"))
      return juwimmResourcesr;
    else if (fieldName.equalsIgnoreCase("juwimm_budget") || fieldName.equals("juwimmBudget"))
      return juwimmBudget;
    else if (fieldName.equalsIgnoreCase("juwimm_budgetr") || fieldName.equals("juwimmBudgetr"))
      return juwimmBudgetr;
    else if (fieldName.equalsIgnoreCase("juwimm_team_id") || fieldName.equals("juwimmTeamId"))
      return juwimmTeamId;
    else if (fieldName.equalsIgnoreCase("juwimm_team_idr") || fieldName.equals("juwimmTeamIdr"))
      return juwimmTeamIdr;
    else if (fieldName.equalsIgnoreCase("juwimm_plannedgolive") || fieldName.equals("juwimmPlannedgolive"))
      return juwimmPlannedgolive;
    else if (fieldName.equalsIgnoreCase("juwimm_estgolive") || fieldName.equals("juwimmEstgolive"))
      return juwimmEstgolive;
    else if (fieldName.equalsIgnoreCase("juwimm_nextimpdate") || fieldName.equals("juwimmNextimpdate"))
      return juwimmNextimpdate;
    else if (fieldName.equalsIgnoreCase("juwimm_description") || fieldName.equals("juwimmDescription"))
      return juwimmDescription;
    else if (fieldName.equalsIgnoreCase("juwimm_plannedstart") || fieldName.equals("juwimmPlannedstart"))
      return juwimmPlannedstart;
    else if (fieldName.equalsIgnoreCase("juwimm_eststart") || fieldName.equals("juwimmEststart"))
      return juwimmEststart;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone1") || fieldName.equals("juwimmMilestone1"))
      return juwimmMilestone1;
    else if (fieldName.equalsIgnoreCase("juwimm_ms1planneddate") || fieldName.equals("juwimmMs1planneddate"))
      return juwimmMs1planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms1estdate") || fieldName.equals("juwimmMs1estdate"))
      return juwimmMs1estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone2") || fieldName.equals("juwimmMilestone2"))
      return juwimmMilestone2;
    else if (fieldName.equalsIgnoreCase("juwimm_ms2planneddate") || fieldName.equals("juwimmMs2planneddate"))
      return juwimmMs2planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms2estdate") || fieldName.equals("juwimmMs2estdate"))
      return juwimmMs2estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone3") || fieldName.equals("juwimmMilestone3"))
      return juwimmMilestone3;
    else if (fieldName.equalsIgnoreCase("juwimm_ms3planneddate") || fieldName.equals("juwimmMs3planneddate"))
      return juwimmMs3planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms3estdate") || fieldName.equals("juwimmMs3estdate"))
      return juwimmMs3estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone4") || fieldName.equals("juwimmMilestone4"))
      return juwimmMilestone4;
    else if (fieldName.equalsIgnoreCase("juwimm_ms4planneddate") || fieldName.equals("juwimmMs4planneddate"))
      return juwimmMs4planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms4estdate") || fieldName.equals("juwimmMs4estdate"))
      return juwimmMs4estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone5") || fieldName.equals("juwimmMilestone5"))
      return juwimmMilestone5;
    else if (fieldName.equalsIgnoreCase("juwimm_ms5planneddate") || fieldName.equals("juwimmMs5planneddate"))
      return juwimmMs5planneddate;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("isrecharge"))
      return isrecharge;
    else if (fieldName.equalsIgnoreCase("juwimm_ms5estdate") || fieldName.equals("juwimmMs5estdate"))
      return juwimmMs5estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone6") || fieldName.equals("juwimmMilestone6"))
      return juwimmMilestone6;
    else if (fieldName.equalsIgnoreCase("btncopytemplate"))
      return btncopytemplate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms6planneddate") || fieldName.equals("juwimmMs6planneddate"))
      return juwimmMs6planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_ms6estdate") || fieldName.equals("juwimmMs6estdate"))
      return juwimmMs6estdate;
    else if (fieldName.equalsIgnoreCase("subscriptionchangedate"))
      return subscriptionchangedate;
    else if (fieldName.equalsIgnoreCase("juwimm_milestone7") || fieldName.equals("juwimmMilestone7"))
      return juwimmMilestone7;
    else if (fieldName.equalsIgnoreCase("juwimm_ms7planneddate") || fieldName.equals("juwimmMs7planneddate"))
      return juwimmMs7planneddate;
    else if (fieldName.equalsIgnoreCase("juwimm_orderstatuscomplete_v_id") || fieldName.equals("juwimmOrderstatuscompleteVId"))
      return juwimmOrderstatuscompleteVId;
    else if (fieldName.equalsIgnoreCase("juwimm_ms7estdate") || fieldName.equals("juwimmMs7estdate"))
      return juwimmMs7estdate;
    else if (fieldName.equalsIgnoreCase("juwimm_plannedend") || fieldName.equals("juwimmPlannedend"))
      return juwimmPlannedend;
    else if (fieldName.equalsIgnoreCase("juwimm_orderstatus_id") || fieldName.equals("juwimmOrderstatusId"))
      return juwimmOrderstatusId;
    else if (fieldName.equalsIgnoreCase("juwimm_estend") || fieldName.equals("juwimmEstend"))
      return juwimmEstend;
    else if (fieldName.equalsIgnoreCase("juwimm_projectman") || fieldName.equals("juwimmProjectman"))
      return juwimmProjectman;
    else if (fieldName.equalsIgnoreCase("juwimm_ouputremarks") || fieldName.equals("juwimmOuputremarks"))
      return juwimmOuputremarks;
    else if (fieldName.equalsIgnoreCase("juwimm_lastaction") || fieldName.equals("juwimmLastaction"))
      return juwimmLastaction;
    else if (fieldName.equalsIgnoreCase("juwimm_nextaction") || fieldName.equals("juwimmNextaction"))
      return juwimmNextaction;
    else if (fieldName.equalsIgnoreCase("juwimm_issues") || fieldName.equals("juwimmIssues"))
      return juwimmIssues;
    else if (fieldName.equalsIgnoreCase("juwimm_decisions") || fieldName.equals("juwimmDecisions"))
      return juwimmDecisions;
    else if (fieldName.equalsIgnoreCase("juwimm_lastupdateon") || fieldName.equals("juwimmLastupdateon"))
      return juwimmLastupdateon;
    else if (fieldName.equalsIgnoreCase("juwimm_lastupdateby") || fieldName.equals("juwimmLastupdateby"))
      return juwimmLastupdateby;
    else if (fieldName.equalsIgnoreCase("juwimm_lastupdatebyr") || fieldName.equals("juwimmLastupdatebyr"))
      return juwimmLastupdatebyr;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("isinvoiced"))
      return isinvoiced;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("isselected"))
      return isselected;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(juwimm_orderstatuscomplete_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_orderstatuscomplete_v.CreatedBy) as CreatedByR, " +
      "        to_char(juwimm_orderstatuscomplete_v.Updated, ?) as updated, " +
      "        to_char(juwimm_orderstatuscomplete_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        juwimm_orderstatuscomplete_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = juwimm_orderstatuscomplete_v.UpdatedBy) as UpdatedByR," +
      "        juwimm_orderstatuscomplete_v.User1_ID, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsSelfService, 'N') AS IsSelfService, " +
      "juwimm_orderstatuscomplete_v.AD_OrgTrx_ID, " +
      "juwimm_orderstatuscomplete_v.DropShip_Location_ID, " +
      "juwimm_orderstatuscomplete_v.CopyFrom, " +
      "juwimm_orderstatuscomplete_v.User2_ID, " +
      "juwimm_orderstatuscomplete_v.DropShip_User_ID, " +
      "juwimm_orderstatuscomplete_v.DropShip_BPartner_ID, " +
      "juwimm_orderstatuscomplete_v.AD_Client_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.AD_Client_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Client_IDR, " +
      "juwimm_orderstatuscomplete_v.AD_Org_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "juwimm_orderstatuscomplete_v.DocumentNo, " +
      "juwimm_orderstatuscomplete_v.Incotermsdescription, " +
      "juwimm_orderstatuscomplete_v.POReference, " +
      "juwimm_orderstatuscomplete_v.Generatetemplate, " +
      "juwimm_orderstatuscomplete_v.DateOrdered, " +
      "juwimm_orderstatuscomplete_v.Transactionreference, " +
      "juwimm_orderstatuscomplete_v.CopyFromPO, " +
      "juwimm_orderstatuscomplete_v.A_Asset_ID, " +
      "juwimm_orderstatuscomplete_v.C_DocTypeTarget_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_DocTypeTarget_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_DocTypeTarget_IDR, " +
      "juwimm_orderstatuscomplete_v.Name, " +
      "juwimm_orderstatuscomplete_v.C_DocType_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "juwimm_orderstatuscomplete_v.DocStatus, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocStatusR, " +
      "juwimm_orderstatuscomplete_v.Description, " +
      "juwimm_orderstatuscomplete_v.Deliverynotes, " +
      "juwimm_orderstatuscomplete_v.Internalnote, " +
      "juwimm_orderstatuscomplete_v.C_BPartner_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_BPartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_BPartner_IDR, " +
      "juwimm_orderstatuscomplete_v.bpzipcode, " +
      "juwimm_orderstatuscomplete_v.BillTo_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.BillTo_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS BillTo_IDR, " +
      "juwimm_orderstatuscomplete_v.C_BPartner_Location_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_BPartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_BPartner_Location_IDR, " +
      "juwimm_orderstatuscomplete_v.AD_User_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "juwimm_orderstatuscomplete_v.SalesRep_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "juwimm_orderstatuscomplete_v.M_PriceList_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.M_PriceList_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS M_PriceList_IDR, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsDiscountPrinted, 'N') AS IsDiscountPrinted, " +
      "juwimm_orderstatuscomplete_v.InvoiceRule, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.InvoiceRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS InvoiceRuleR, " +
      "juwimm_orderstatuscomplete_v.Estpropability, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Estpropability IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS EstpropabilityR, " +
      "juwimm_orderstatuscomplete_v.M_Warehouse_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.M_Warehouse_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "juwimm_orderstatuscomplete_v.C_Currency_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "juwimm_orderstatuscomplete_v.DeliveryRule, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.DeliveryRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS DeliveryRuleR, " +
      "juwimm_orderstatuscomplete_v.PriorityRule, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.PriorityRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS PriorityRuleR, " +
      "juwimm_orderstatuscomplete_v.PaymentRule, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.PaymentRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list6.name),'') ) END) AS PaymentRuleR, " +
      "juwimm_orderstatuscomplete_v.C_PaymentTerm_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_PaymentTerm_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL13.Name IS NULL THEN TO_CHAR(table13.Name) ELSE TO_CHAR(tableTRL13.Name) END)), ''))),'') ) END) AS C_PaymentTerm_IDR, " +
      "juwimm_orderstatuscomplete_v.C_Incoterms_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_Incoterms_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table14.Name), ''))),'') ) END) AS C_Incoterms_IDR, " +
      "juwimm_orderstatuscomplete_v.Delivery_Location_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Delivery_Location_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'') ) END) AS Delivery_Location_IDR, " +
      "juwimm_orderstatuscomplete_v.DeliveryViaRule, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.DeliveryViaRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list7.name),'') ) END) AS DeliveryViaRuleR, " +
      "juwimm_orderstatuscomplete_v.M_Shipper_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.M_Shipper_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table16.Name), ''))),'') ) END) AS M_Shipper_IDR, " +
      "juwimm_orderstatuscomplete_v.Weight, " +
      "juwimm_orderstatuscomplete_v.Weight_Uom, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Weight_Uom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL17.Name IS NULL THEN TO_CHAR(table17.Name) ELSE TO_CHAR(tableTRL17.Name) END)), ''))),'') ) END) AS Weight_UomR, " +
      "juwimm_orderstatuscomplete_v.FreightCostRule, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.FreightCostRule IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list8.name),'') ) END) AS FreightCostRuleR, " +
      "juwimm_orderstatuscomplete_v.M_Product_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.M_Product_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL18.Name IS NULL THEN TO_CHAR(table18.Name) ELSE TO_CHAR(tableTRL18.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "juwimm_orderstatuscomplete_v.Qty, " +
      "juwimm_orderstatuscomplete_v.FreightAmt, " +
      "juwimm_orderstatuscomplete_v.C_Project_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table19.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "juwimm_orderstatuscomplete_v.C_Projecttask_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table20.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table21.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "juwimm_orderstatuscomplete_v.Orderselfjoin, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Orderselfjoin IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table22.DocumentNo), ''))),'') ) END) AS OrderselfjoinR, " +
      "juwimm_orderstatuscomplete_v.Firstschedinvoicedate, " +
      "juwimm_orderstatuscomplete_v.DatePromised, " +
      "juwimm_orderstatuscomplete_v.Scheddeliverydate, " +
      "juwimm_orderstatuscomplete_v.Schedtransactiondate, " +
      "juwimm_orderstatuscomplete_v.Transactiondate, " +
      "juwimm_orderstatuscomplete_v.Contractdate, " +
      "juwimm_orderstatuscomplete_v.Enddate, " +
      "juwimm_orderstatuscomplete_v.Invoicefrequence, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Invoicefrequence IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list9.name),'') ) END) AS InvoicefrequenceR, " +
      "juwimm_orderstatuscomplete_v.C_Projectphase_ID, " +
      "COALESCE(juwimm_orderstatuscomplete_v.Isinvoiceafterfirstcycle, 'N') AS Isinvoiceafterfirstcycle, " +
      "juwimm_orderstatuscomplete_v.Quarterly_Month, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Quarterly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list10.name),'') ) END) AS Quarterly_MonthR, " +
      "juwimm_orderstatuscomplete_v.Yearly_Month, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Yearly_Month IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list11.name),'') ) END) AS Yearly_MonthR, " +
      "juwimm_orderstatuscomplete_v.Weekly_Day, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Weekly_Day IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list12.name),'') ) END) AS Weekly_DayR, " +
      "juwimm_orderstatuscomplete_v.C_Bidproject_ID, " +
      "juwimm_orderstatuscomplete_v.Monthly_Day, " +
      "juwimm_orderstatuscomplete_v.Proposalstatus, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Proposalstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list13.name),'') ) END) AS ProposalstatusR, " +
      "juwimm_orderstatuscomplete_v.Lostproposalfixedreason, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Lostproposalfixedreason IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list14.name),'') ) END) AS LostproposalfixedreasonR, " +
      "juwimm_orderstatuscomplete_v.Lostproposalreason, " +
      "juwimm_orderstatuscomplete_v.Totallinesonetime, " +
      "juwimm_orderstatuscomplete_v.Grandtotalonetime, " +
      "juwimm_orderstatuscomplete_v.TotalLines, " +
      "juwimm_orderstatuscomplete_v.GrandTotal, " +
      "juwimm_orderstatuscomplete_v.Generateproject, " +
      "juwimm_orderstatuscomplete_v.Closeproject, " +
      "juwimm_orderstatuscomplete_v.Invoicedamt, " +
      "juwimm_orderstatuscomplete_v.Totalpaid, " +
      "juwimm_orderstatuscomplete_v.Completeordervalue, " +
      "COALESCE(juwimm_orderstatuscomplete_v.Deliverycomplete, 'N') AS Deliverycomplete, " +
      "COALESCE(juwimm_orderstatuscomplete_v.Iscompletelyinvoiced, 'N') AS Iscompletelyinvoiced, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Completion, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Juwimm_Completion IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list15.name),'') ) END) AS Juwimm_CompletionR, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Time, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Juwimm_Time IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list16.name),'') ) END) AS Juwimm_TimeR, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Resources, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Juwimm_Resources IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list17.name),'') ) END) AS Juwimm_ResourcesR, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Budget, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Juwimm_Budget IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list18.name),'') ) END) AS Juwimm_BudgetR, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Team_ID, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Juwimm_Team_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL23.Name IS NULL THEN TO_CHAR(table23.Name) ELSE TO_CHAR(tableTRL23.Name) END)), ''))),'') ) END) AS Juwimm_Team_IDR, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Plannedgolive, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Estgolive, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Nextimpdate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Description, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Plannedstart, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Eststart, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Milestone1, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms1planneddate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms1estdate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Milestone2, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms2planneddate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms2estdate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Milestone3, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms3planneddate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms3estdate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Milestone4, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms4planneddate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms4estdate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Milestone5, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms5planneddate, " +
      "COALESCE(juwimm_orderstatuscomplete_v.Ispaid, 'N') AS Ispaid, " +
      "COALESCE(juwimm_orderstatuscomplete_v.Isrecharge, 'N') AS Isrecharge, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms5estdate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Milestone6, " +
      "juwimm_orderstatuscomplete_v.BtnCopyTemplate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms6planneddate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms6estdate, " +
      "juwimm_orderstatuscomplete_v.Subscriptionchangedate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Milestone7, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms7planneddate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Orderstatuscomplete_V_ID, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ms7estdate, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Plannedend, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Orderstatus_ID, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Estend, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Projectman, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Ouputremarks, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Lastaction, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Nextaction, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Issues, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Decisions, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Lastupdateon, " +
      "juwimm_orderstatuscomplete_v.Juwimm_Lastupdateby, " +
      "(CASE WHEN juwimm_orderstatuscomplete_v.Juwimm_Lastupdateby IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table24.Name), ''))),'') ) END) AS Juwimm_LastupdatebyR, " +
      "juwimm_orderstatuscomplete_v.C_Charge_ID, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsDelivered, 'N') AS IsDelivered, " +
      "juwimm_orderstatuscomplete_v.C_Activity_ID, " +
      "COALESCE(juwimm_orderstatuscomplete_v.Processed, 'N') AS Processed, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsSOTrx, 'N') AS IsSOTrx, " +
      "juwimm_orderstatuscomplete_v.DocAction, " +
      "juwimm_orderstatuscomplete_v.C_Campaign_ID, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsTaxIncluded, 'N') AS IsTaxIncluded, " +
      "juwimm_orderstatuscomplete_v.DatePrinted, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsInvoiced, 'N') AS IsInvoiced, " +
      "juwimm_orderstatuscomplete_v.DateAcct, " +
      "juwimm_orderstatuscomplete_v.C_Order_ID, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsSelected, 'N') AS IsSelected, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsPrinted, 'N') AS IsPrinted, " +
      "juwimm_orderstatuscomplete_v.Posted, " +
      "COALESCE(juwimm_orderstatuscomplete_v.IsActive, 'N') AS IsActive, " +
      "juwimm_orderstatuscomplete_v.Processing, " +
      "juwimm_orderstatuscomplete_v.ChargeAmt, " +
      "        ? AS LANGUAGE " +
      "        FROM juwimm_orderstatuscomplete_v left join (select AD_Client_ID, Name from AD_Client) table1 on (juwimm_orderstatuscomplete_v.AD_Client_ID = table1.AD_Client_ID) left join (select AD_Org_ID, Name from AD_Org) table2 on (juwimm_orderstatuscomplete_v.AD_Org_ID = table2.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table3 on (juwimm_orderstatuscomplete_v.C_DocTypeTarget_ID =  table3.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL3 on (table3.C_DocType_ID = tableTRL3.C_DocType_ID and tableTRL3.AD_Language = ?)  left join (select C_DocType_ID, Name from C_DocType) table4 on (juwimm_orderstatuscomplete_v.C_DocType_ID = table4.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL4 on (table4.C_DocType_ID = tableTRL4.C_DocType_ID and tableTRL4.AD_Language = ?)  left join ad_ref_list_v list1 on (juwimm_orderstatuscomplete_v.DocStatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select C_BPartner_ID, Name from C_BPartner) table5 on (juwimm_orderstatuscomplete_v.C_BPartner_ID = table5.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table6 on (juwimm_orderstatuscomplete_v.BillTo_ID =  table6.C_BPartner_Location_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table7 on (juwimm_orderstatuscomplete_v.C_BPartner_Location_ID = table7.C_BPartner_Location_ID) left join (select AD_User_ID, Name from AD_User) table8 on (juwimm_orderstatuscomplete_v.AD_User_ID = table8.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table9 on (juwimm_orderstatuscomplete_v.SalesRep_ID =  table9.AD_User_ID) left join (select M_PriceList_ID, Name from M_PriceList) table10 on (juwimm_orderstatuscomplete_v.M_PriceList_ID = table10.M_PriceList_ID) left join ad_ref_list_v list2 on (juwimm_orderstatuscomplete_v.InvoiceRule = list2.value and list2.ad_reference_id = '150' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (juwimm_orderstatuscomplete_v.Estpropability = list3.value and list3.ad_reference_id = 'DD6AA16AB1DD4DF5AD11A2665AE665BC' and list3.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table11 on (juwimm_orderstatuscomplete_v.M_Warehouse_ID =  table11.M_Warehouse_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table12 on (juwimm_orderstatuscomplete_v.C_Currency_ID = table12.C_Currency_ID) left join ad_ref_list_v list4 on (juwimm_orderstatuscomplete_v.DeliveryRule = list4.value and list4.ad_reference_id = '151' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (juwimm_orderstatuscomplete_v.PriorityRule = list5.value and list5.ad_reference_id = '154' and list5.ad_language = ?)  left join ad_ref_list_v list6 on (juwimm_orderstatuscomplete_v.PaymentRule = list6.value and list6.ad_reference_id = '195' and list6.ad_language = ?)  left join (select C_PaymentTerm_ID, Name from C_PaymentTerm) table13 on (juwimm_orderstatuscomplete_v.C_PaymentTerm_ID = table13.C_PaymentTerm_ID) left join (select C_PaymentTerm_ID,AD_Language, Name from C_PaymentTerm_TRL) tableTRL13 on (table13.C_PaymentTerm_ID = tableTRL13.C_PaymentTerm_ID and tableTRL13.AD_Language = ?)  left join (select C_Incoterms_ID, Name from C_Incoterms) table14 on (juwimm_orderstatuscomplete_v.C_Incoterms_ID = table14.C_Incoterms_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table15 on (juwimm_orderstatuscomplete_v.Delivery_Location_ID =  table15.C_BPartner_Location_ID) left join ad_ref_list_v list7 on (juwimm_orderstatuscomplete_v.DeliveryViaRule = list7.value and list7.ad_reference_id = '152' and list7.ad_language = ?)  left join (select M_Shipper_ID, Name from M_Shipper) table16 on (juwimm_orderstatuscomplete_v.M_Shipper_ID = table16.M_Shipper_ID) left join (select C_UOM_ID, Name from C_UOM) table17 on (juwimm_orderstatuscomplete_v.Weight_Uom =  table17.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL17 on (table17.C_UOM_ID = tableTRL17.C_UOM_ID and tableTRL17.AD_Language = ?)  left join ad_ref_list_v list8 on (juwimm_orderstatuscomplete_v.FreightCostRule = list8.value and list8.ad_reference_id = '153' and list8.ad_language = ?)  left join (select M_Product_ID, value, Name from M_Product) table18 on (juwimm_orderstatuscomplete_v.M_Product_ID =  table18.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL18 on (table18.M_Product_ID = tableTRL18.M_Product_ID and tableTRL18.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table19 on (juwimm_orderstatuscomplete_v.C_Project_ID = table19.C_Project_ID) left join (select C_Projecttask_ID, Name, C_Project_ID from C_Projecttask) table20 on (juwimm_orderstatuscomplete_v.C_Projecttask_ID = table20.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table21 on (table20.C_Project_ID = table21.C_Project_ID) left join (select C_Order_ID, DocumentNo from C_Order) table22 on (juwimm_orderstatuscomplete_v.Orderselfjoin =  table22.C_Order_ID) left join ad_ref_list_v list9 on (juwimm_orderstatuscomplete_v.Invoicefrequence = list9.value and list9.ad_reference_id = 'F17BFE71276743BBB6105EE61D9FD666' and list9.ad_language = ?)  left join ad_ref_list_v list10 on (juwimm_orderstatuscomplete_v.Quarterly_Month = list10.value and list10.ad_reference_id = '99780AA6C1644A329162A8AF74602925' and list10.ad_language = ?)  left join ad_ref_list_v list11 on (juwimm_orderstatuscomplete_v.Yearly_Month = list11.value and list11.ad_reference_id = 'B849337BE90242BEB0B230808EDC0CEE' and list11.ad_language = ?)  left join ad_ref_list_v list12 on (juwimm_orderstatuscomplete_v.Weekly_Day = list12.value and list12.ad_reference_id = '167' and list12.ad_language = ?)  left join ad_ref_list_v list13 on (juwimm_orderstatuscomplete_v.Proposalstatus = list13.value and list13.ad_reference_id = 'B00D78B6B154404A831F25F11ABD867E' and list13.ad_language = ?)  left join ad_ref_list_v list14 on (juwimm_orderstatuscomplete_v.Lostproposalfixedreason = list14.value and list14.ad_reference_id = 'B51F770E9FA84F5B8FC0FFD7B3848317' and list14.ad_language = ?)  left join ad_ref_list_v list15 on (juwimm_orderstatuscomplete_v.Juwimm_Completion = list15.value and list15.ad_reference_id = 'DFB97A7B6DE848EEAA271F95215E316E' and list15.ad_language = ?)  left join ad_ref_list_v list16 on (juwimm_orderstatuscomplete_v.Juwimm_Time = list16.value and list16.ad_reference_id = 'BBFB55FDBAA64C0EB46F026460AE8285' and list16.ad_language = ?)  left join ad_ref_list_v list17 on (juwimm_orderstatuscomplete_v.Juwimm_Resources = list17.value and list17.ad_reference_id = '7C374D10EA044BE3B252D6654A7AA5E1' and list17.ad_language = ?)  left join ad_ref_list_v list18 on (juwimm_orderstatuscomplete_v.Juwimm_Budget = list18.value and list18.ad_reference_id = '76CDE2B245D44726AE30457453FF622E' and list18.ad_language = ?)  left join (select Juwimm_Team_ID, Name from Juwimm_Team) table23 on (juwimm_orderstatuscomplete_v.Juwimm_Team_ID = table23.Juwimm_Team_ID) left join (select Juwimm_Team_ID,AD_Language, Name from juwimm_team_TRL) tableTRL23 on (table23.Juwimm_Team_ID = tableTRL23.Juwimm_Team_ID and tableTRL23.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table24 on (juwimm_orderstatuscomplete_v.Juwimm_Lastupdateby =  table24.AD_User_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND juwimm_orderstatuscomplete_v.Juwimm_Orderstatuscomplete_V_ID = ? " +
      "        AND juwimm_orderstatuscomplete_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND juwimm_orderstatuscomplete_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data = new MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data();
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.created = UtilSql.getValue(result, "created");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.updated = UtilSql.getValue(result, "updated");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.user1Id = UtilSql.getValue(result, "user1_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.dropshipLocationId = UtilSql.getValue(result, "dropship_location_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.user2Id = UtilSql.getValue(result, "user2_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.dropshipUserId = UtilSql.getValue(result, "dropship_user_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.dropshipBpartnerId = UtilSql.getValue(result, "dropship_bpartner_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adClientIdr = UtilSql.getValue(result, "ad_client_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.documentno = UtilSql.getValue(result, "documentno");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.incotermsdescription = UtilSql.getValue(result, "incotermsdescription");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.poreference = UtilSql.getValue(result, "poreference");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.generatetemplate = UtilSql.getValue(result, "generatetemplate");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.transactionreference = UtilSql.getValue(result, "transactionreference");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.copyfrompo = UtilSql.getValue(result, "copyfrompo");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cDoctypetargetIdr = UtilSql.getValue(result, "c_doctypetarget_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.name = UtilSql.getValue(result, "name");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.docstatus = UtilSql.getValue(result, "docstatus");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.description = UtilSql.getValue(result, "description");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deliverynotes = UtilSql.getValue(result, "deliverynotes");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.internalnote = UtilSql.getValue(result, "internalnote");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.bpzipcode = UtilSql.getValue(result, "bpzipcode");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.billtoId = UtilSql.getValue(result, "billto_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.billtoIdr = UtilSql.getValue(result, "billto_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.invoiceruler = UtilSql.getValue(result, "invoiceruler");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.estpropability = UtilSql.getValue(result, "estpropability");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.estpropabilityr = UtilSql.getValue(result, "estpropabilityr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deliveryruler = UtilSql.getValue(result, "deliveryruler");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.priorityruler = UtilSql.getValue(result, "priorityruler");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.paymentruler = UtilSql.getValue(result, "paymentruler");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cPaymenttermIdr = UtilSql.getValue(result, "c_paymentterm_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cIncotermsId = UtilSql.getValue(result, "c_incoterms_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cIncotermsIdr = UtilSql.getValue(result, "c_incoterms_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deliveryLocationId = UtilSql.getValue(result, "delivery_location_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deliveryLocationIdr = UtilSql.getValue(result, "delivery_location_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deliveryviaruler = UtilSql.getValue(result, "deliveryviaruler");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.mShipperIdr = UtilSql.getValue(result, "m_shipper_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.weight = UtilSql.getValue(result, "weight");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.weightUom = UtilSql.getValue(result, "weight_uom");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.weightUomr = UtilSql.getValue(result, "weight_uomr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.freightcostruler = UtilSql.getValue(result, "freightcostruler");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.qty = UtilSql.getValue(result, "qty");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.freightamt = UtilSql.getValue(result, "freightamt");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.orderselfjoin = UtilSql.getValue(result, "orderselfjoin");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.orderselfjoinr = UtilSql.getValue(result, "orderselfjoinr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.firstschedinvoicedate = UtilSql.getDateValue(result, "firstschedinvoicedate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.schedtransactiondate = UtilSql.getDateValue(result, "schedtransactiondate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.transactiondate = UtilSql.getDateValue(result, "transactiondate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.contractdate = UtilSql.getDateValue(result, "contractdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.invoicefrequence = UtilSql.getValue(result, "invoicefrequence");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.invoicefrequencer = UtilSql.getValue(result, "invoicefrequencer");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isinvoiceafterfirstcycle = UtilSql.getValue(result, "isinvoiceafterfirstcycle");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.quarterlyMonth = UtilSql.getValue(result, "quarterly_month");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.quarterlyMonthr = UtilSql.getValue(result, "quarterly_monthr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.yearlyMonth = UtilSql.getValue(result, "yearly_month");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.yearlyMonthr = UtilSql.getValue(result, "yearly_monthr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.weeklyDay = UtilSql.getValue(result, "weekly_day");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.weeklyDayr = UtilSql.getValue(result, "weekly_dayr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cBidprojectId = UtilSql.getValue(result, "c_bidproject_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.monthlyDay = UtilSql.getValue(result, "monthly_day");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.proposalstatus = UtilSql.getValue(result, "proposalstatus");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.proposalstatusr = UtilSql.getValue(result, "proposalstatusr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.lostproposalfixedreason = UtilSql.getValue(result, "lostproposalfixedreason");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.lostproposalfixedreasonr = UtilSql.getValue(result, "lostproposalfixedreasonr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.lostproposalreason = UtilSql.getValue(result, "lostproposalreason");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.totallinesonetime = UtilSql.getValue(result, "totallinesonetime");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.grandtotalonetime = UtilSql.getValue(result, "grandtotalonetime");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.totallines = UtilSql.getValue(result, "totallines");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.generateproject = UtilSql.getValue(result, "generateproject");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.closeproject = UtilSql.getValue(result, "closeproject");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.completeordervalue = UtilSql.getValue(result, "completeordervalue");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.deliverycomplete = UtilSql.getValue(result, "deliverycomplete");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.iscompletelyinvoiced = UtilSql.getValue(result, "iscompletelyinvoiced");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmCompletion = UtilSql.getValue(result, "juwimm_completion");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmCompletionr = UtilSql.getValue(result, "juwimm_completionr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmTime = UtilSql.getValue(result, "juwimm_time");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmTimer = UtilSql.getValue(result, "juwimm_timer");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmResources = UtilSql.getValue(result, "juwimm_resources");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmResourcesr = UtilSql.getValue(result, "juwimm_resourcesr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmBudget = UtilSql.getValue(result, "juwimm_budget");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmBudgetr = UtilSql.getValue(result, "juwimm_budgetr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmTeamId = UtilSql.getValue(result, "juwimm_team_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmTeamIdr = UtilSql.getValue(result, "juwimm_team_idr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmPlannedgolive = UtilSql.getDateValue(result, "juwimm_plannedgolive", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmEstgolive = UtilSql.getDateValue(result, "juwimm_estgolive", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmNextimpdate = UtilSql.getDateValue(result, "juwimm_nextimpdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmDescription = UtilSql.getValue(result, "juwimm_description");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmPlannedstart = UtilSql.getDateValue(result, "juwimm_plannedstart", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmEststart = UtilSql.getDateValue(result, "juwimm_eststart", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMilestone1 = UtilSql.getValue(result, "juwimm_milestone1");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs1planneddate = UtilSql.getDateValue(result, "juwimm_ms1planneddate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs1estdate = UtilSql.getDateValue(result, "juwimm_ms1estdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMilestone2 = UtilSql.getValue(result, "juwimm_milestone2");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs2planneddate = UtilSql.getDateValue(result, "juwimm_ms2planneddate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs2estdate = UtilSql.getDateValue(result, "juwimm_ms2estdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMilestone3 = UtilSql.getValue(result, "juwimm_milestone3");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs3planneddate = UtilSql.getDateValue(result, "juwimm_ms3planneddate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs3estdate = UtilSql.getDateValue(result, "juwimm_ms3estdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMilestone4 = UtilSql.getValue(result, "juwimm_milestone4");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs4planneddate = UtilSql.getDateValue(result, "juwimm_ms4planneddate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs4estdate = UtilSql.getDateValue(result, "juwimm_ms4estdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMilestone5 = UtilSql.getValue(result, "juwimm_milestone5");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs5planneddate = UtilSql.getDateValue(result, "juwimm_ms5planneddate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.ispaid = UtilSql.getValue(result, "ispaid");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isrecharge = UtilSql.getValue(result, "isrecharge");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs5estdate = UtilSql.getDateValue(result, "juwimm_ms5estdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMilestone6 = UtilSql.getValue(result, "juwimm_milestone6");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.btncopytemplate = UtilSql.getValue(result, "btncopytemplate");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs6planneddate = UtilSql.getDateValue(result, "juwimm_ms6planneddate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs6estdate = UtilSql.getDateValue(result, "juwimm_ms6estdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.subscriptionchangedate = UtilSql.getDateValue(result, "subscriptionchangedate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMilestone7 = UtilSql.getValue(result, "juwimm_milestone7");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs7planneddate = UtilSql.getDateValue(result, "juwimm_ms7planneddate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmOrderstatuscompleteVId = UtilSql.getValue(result, "juwimm_orderstatuscomplete_v_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmMs7estdate = UtilSql.getDateValue(result, "juwimm_ms7estdate", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmPlannedend = UtilSql.getDateValue(result, "juwimm_plannedend", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmOrderstatusId = UtilSql.getValue(result, "juwimm_orderstatus_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmEstend = UtilSql.getDateValue(result, "juwimm_estend", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmProjectman = UtilSql.getValue(result, "juwimm_projectman");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmOuputremarks = UtilSql.getValue(result, "juwimm_ouputremarks");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmLastaction = UtilSql.getValue(result, "juwimm_lastaction");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmNextaction = UtilSql.getValue(result, "juwimm_nextaction");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmIssues = UtilSql.getValue(result, "juwimm_issues");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmDecisions = UtilSql.getValue(result, "juwimm_decisions");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmLastupdateon = UtilSql.getDateValue(result, "juwimm_lastupdateon", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmLastupdateby = UtilSql.getValue(result, "juwimm_lastupdateby");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.juwimmLastupdatebyr = UtilSql.getValue(result, "juwimm_lastupdatebyr");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.processed = UtilSql.getValue(result, "processed");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.issotrx = UtilSql.getValue(result, "issotrx");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.docaction = UtilSql.getValue(result, "docaction");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isinvoiced = UtilSql.getValue(result, "isinvoiced");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isselected = UtilSql.getValue(result, "isselected");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isprinted = UtilSql.getValue(result, "isprinted");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.posted = UtilSql.getValue(result, "posted");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.isactive = UtilSql.getValue(result, "isactive");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.processing = UtilSql.getValue(result, "processing");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.language = UtilSql.getValue(result, "language");
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adUserClient = "";
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.adOrgClient = "";
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.createdby = "";
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.trBgcolor = "";
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.totalCount = "";
        objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data);
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
    MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] = new MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[vector.size()];
    vector.copyInto(objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data);
    return(objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data);
  }

/**
Create a registry
 */
  public static MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] set(String juwimmCompletion, String juwimmMs6planneddate, String processed, String proposalstatus, String isselected, String adClientId, String updatedby, String updatedbyr, String cBpartnerLocationId, String cActivityId, String deliveryviarule, String juwimmMs3planneddate, String transactiondate, String juwimmProjectman, String ispaid, String juwimmMs3estdate, String mWarehouseId, String istaxincluded, String mPricelistId, String internalnote, String salesrepId, String grandtotal, String juwimmMilestone4, String cCurrencyId, String name, String dropshipUserId, String juwimmMs2estdate, String totallinesonetime, String datepromised, String deliveryrule, String schedtransactiondate, String cCampaignId, String aAssetId, String juwimmEstend, String contractdate, String totallines, String monthlyDay, String cProjecttaskId, String adOrgId, String juwimmPlannedstart, String juwimmMs4planneddate, String dateacct, String billtoId, String invoicerule, String juwimmPlannedend, String dateprinted, String transactionreference, String juwimmNextaction, String closeproject, String subscriptionchangedate, String user1Id, String invoicefrequence, String cIncotermsId, String cDoctypetargetId, String freightcostrule, String orderselfjoin, String juwimmMilestone2, String copyfrompo, String isdelivered, String dateordered, String cBidprojectId, String juwimmMilestone7, String cOrderId, String juwimmMs2planneddate, String juwimmMilestone5, String cPaymenttermId, String juwimmMilestone3, String poreference, String juwimmLastupdateon, String deliverycomplete, String paymentrule, String weightUom, String isdiscountprinted, String lostproposalreason, String firstschedinvoicedate, String juwimmDecisions, String generateproject, String cBpartnerId, String cBpartnerIdr, String juwimmLastupdateby, String incotermsdescription, String isinvoiceafterfirstcycle, String juwimmBudget, String processing, String enddate, String juwimmMs4estdate, String juwimmOrderstatuscompleteVId, String juwimmDescription, String juwimmEstgolive, String priorityrule, String juwimmTeamId, String mProductId, String iscompletelyinvoiced, String juwimmMilestone1, String juwimmMs1estdate, String juwimmMs7planneddate, String totalpaid, String juwimmNextimpdate, String isselfservice, String deliverynotes, String user2Id, String yearlyMonth, String weeklyDay, String bpzipcode, String deliveryLocationId, String quarterlyMonth, String lostproposalfixedreason, String cProjectId, String cProjectIdr, String dropshipLocationId, String isprinted, String juwimmPlannedgolive, String description, String qty, String grandtotalonetime, String juwimmMs7estdate, String juwimmResources, String generatetemplate, String juwimmMilestone6, String isrecharge, String cChargeId, String estpropability, String juwimmMs6estdate, String docstatus, String cDoctypeId, String juwimmEststart, String dropshipBpartnerId, String completeordervalue, String btncopytemplate, String juwimmIssues, String issotrx, String mShipperId, String adOrgtrxId, String juwimmOrderstatusId, String copyfrom, String isactive, String posted, String juwimmMs1planneddate, String weight, String cProjectphaseId, String juwimmTime, String docaction, String createdby, String createdbyr, String juwimmOuputremarks, String isinvoiced, String juwimmMs5estdate, String adUserId, String invoicedamt, String documentno, String juwimmLastaction, String chargeamt, String scheddeliverydate, String freightamt, String juwimmMs5planneddate)    throws ServletException {
    MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[] = new MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[1];
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0] = new MasterDataGrid220A904B66524B17B1C20FC5A238CD65Data();
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].created = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].createdbyr = createdbyr;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].updated = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].updatedTimeStamp = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].updatedby = updatedby;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].updatedbyr = updatedbyr;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].user1Id = user1Id;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isselfservice = isselfservice;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].adOrgtrxId = adOrgtrxId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].dropshipLocationId = dropshipLocationId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].copyfrom = copyfrom;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].user2Id = user2Id;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].dropshipUserId = dropshipUserId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].dropshipBpartnerId = dropshipBpartnerId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].adClientId = adClientId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].adClientIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].adOrgId = adOrgId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].adOrgIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].documentno = documentno;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].incotermsdescription = incotermsdescription;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].poreference = poreference;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].generatetemplate = generatetemplate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].dateordered = dateordered;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].transactionreference = transactionreference;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].copyfrompo = copyfrompo;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].aAssetId = aAssetId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cDoctypetargetId = cDoctypetargetId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cDoctypetargetIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].name = name;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cDoctypeId = cDoctypeId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cDoctypeIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].docstatus = docstatus;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].docstatusr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].description = description;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].deliverynotes = deliverynotes;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].internalnote = internalnote;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cBpartnerId = cBpartnerId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cBpartnerIdr = cBpartnerIdr;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].bpzipcode = bpzipcode;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].billtoId = billtoId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].billtoIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cBpartnerLocationIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].adUserId = adUserId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].adUserIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].salesrepId = salesrepId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].salesrepIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].mPricelistId = mPricelistId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].mPricelistIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isdiscountprinted = isdiscountprinted;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].invoicerule = invoicerule;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].invoiceruler = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].estpropability = estpropability;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].estpropabilityr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].mWarehouseId = mWarehouseId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].mWarehouseIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cCurrencyId = cCurrencyId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cCurrencyIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].deliveryrule = deliveryrule;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].deliveryruler = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].priorityrule = priorityrule;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].priorityruler = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].paymentrule = paymentrule;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].paymentruler = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cPaymenttermId = cPaymenttermId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cPaymenttermIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cIncotermsId = cIncotermsId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cIncotermsIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].deliveryLocationId = deliveryLocationId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].deliveryLocationIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].deliveryviarule = deliveryviarule;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].deliveryviaruler = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].mShipperId = mShipperId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].mShipperIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].weight = weight;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].weightUom = weightUom;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].weightUomr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].freightcostrule = freightcostrule;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].freightcostruler = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].mProductId = mProductId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].mProductIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].qty = qty;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].freightamt = freightamt;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cProjectId = cProjectId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cProjectIdr = cProjectIdr;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cProjecttaskId = cProjecttaskId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cProjecttaskIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].orderselfjoin = orderselfjoin;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].orderselfjoinr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].firstschedinvoicedate = firstschedinvoicedate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].datepromised = datepromised;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].scheddeliverydate = scheddeliverydate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].schedtransactiondate = schedtransactiondate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].transactiondate = transactiondate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].contractdate = contractdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].enddate = enddate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].invoicefrequence = invoicefrequence;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].invoicefrequencer = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cProjectphaseId = cProjectphaseId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isinvoiceafterfirstcycle = isinvoiceafterfirstcycle;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].quarterlyMonth = quarterlyMonth;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].quarterlyMonthr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].yearlyMonth = yearlyMonth;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].yearlyMonthr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].weeklyDay = weeklyDay;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].weeklyDayr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cBidprojectId = cBidprojectId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].monthlyDay = monthlyDay;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].proposalstatus = proposalstatus;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].proposalstatusr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].lostproposalfixedreason = lostproposalfixedreason;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].lostproposalfixedreasonr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].lostproposalreason = lostproposalreason;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].totallinesonetime = totallinesonetime;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].grandtotalonetime = grandtotalonetime;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].totallines = totallines;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].grandtotal = grandtotal;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].generateproject = generateproject;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].closeproject = closeproject;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].invoicedamt = invoicedamt;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].totalpaid = totalpaid;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].completeordervalue = completeordervalue;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].deliverycomplete = deliverycomplete;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].iscompletelyinvoiced = iscompletelyinvoiced;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmCompletion = juwimmCompletion;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmCompletionr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmTime = juwimmTime;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmTimer = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmResources = juwimmResources;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmResourcesr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmBudget = juwimmBudget;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmBudgetr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmTeamId = juwimmTeamId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmTeamIdr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmPlannedgolive = juwimmPlannedgolive;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmEstgolive = juwimmEstgolive;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmNextimpdate = juwimmNextimpdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmDescription = juwimmDescription;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmPlannedstart = juwimmPlannedstart;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmEststart = juwimmEststart;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMilestone1 = juwimmMilestone1;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs1planneddate = juwimmMs1planneddate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs1estdate = juwimmMs1estdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMilestone2 = juwimmMilestone2;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs2planneddate = juwimmMs2planneddate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs2estdate = juwimmMs2estdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMilestone3 = juwimmMilestone3;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs3planneddate = juwimmMs3planneddate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs3estdate = juwimmMs3estdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMilestone4 = juwimmMilestone4;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs4planneddate = juwimmMs4planneddate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs4estdate = juwimmMs4estdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMilestone5 = juwimmMilestone5;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs5planneddate = juwimmMs5planneddate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].ispaid = ispaid;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isrecharge = isrecharge;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs5estdate = juwimmMs5estdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMilestone6 = juwimmMilestone6;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].btncopytemplate = btncopytemplate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs6planneddate = juwimmMs6planneddate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs6estdate = juwimmMs6estdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].subscriptionchangedate = subscriptionchangedate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMilestone7 = juwimmMilestone7;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs7planneddate = juwimmMs7planneddate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmOrderstatuscompleteVId = juwimmOrderstatuscompleteVId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmMs7estdate = juwimmMs7estdate;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmPlannedend = juwimmPlannedend;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmOrderstatusId = juwimmOrderstatusId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmEstend = juwimmEstend;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmProjectman = juwimmProjectman;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmOuputremarks = juwimmOuputremarks;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmLastaction = juwimmLastaction;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmNextaction = juwimmNextaction;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmIssues = juwimmIssues;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmDecisions = juwimmDecisions;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmLastupdateon = juwimmLastupdateon;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmLastupdateby = juwimmLastupdateby;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].juwimmLastupdatebyr = "";
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cChargeId = cChargeId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isdelivered = isdelivered;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cActivityId = cActivityId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].processed = processed;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].issotrx = issotrx;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].docaction = docaction;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cCampaignId = cCampaignId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].istaxincluded = istaxincluded;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].dateprinted = dateprinted;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isinvoiced = isinvoiced;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].dateacct = dateacct;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].cOrderId = cOrderId;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isselected = isselected;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isprinted = isprinted;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].posted = posted;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].isactive = isactive;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].processing = processing;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].chargeamt = chargeamt;
    objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data[0].language = "";
    return objectMasterDataGrid220A904B66524B17B1C20FC5A238CD65Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef4C16A28F3F8D4000A99034B2DA013578_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
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

/**
Select for auxiliar field
 */
  public static String selectDef5961FEB7B1ED4D9DA0E25AC7BAA35D72_1(ConnectionProvider connectionProvider, String C_BPartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as C_BPartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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

/**
Select for auxiliar field
 */
  public static String selectDef15980CB5975542D7958C5B8E7B3786D5_2(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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

/**
Select for auxiliar field
 */
  public static String selectDefDFB6035568AB4F4AB29F9EAB792AEA7B_3(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE juwimm_orderstatuscomplete_v" +
      "        SET User1_ID = (?) , IsSelfService = (?) , AD_OrgTrx_ID = (?) , DropShip_Location_ID = (?) , CopyFrom = (?) , User2_ID = (?) , DropShip_User_ID = (?) , DropShip_BPartner_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , DocumentNo = (?) , Incotermsdescription = (?) , POReference = (?) , Generatetemplate = (?) , DateOrdered = TO_DATE(?) , Transactionreference = (?) , CopyFromPO = (?) , A_Asset_ID = (?) , C_DocTypeTarget_ID = (?) , Name = (?) , C_DocType_ID = (?) , DocStatus = (?) , Description = (?) , Deliverynotes = (?) , Internalnote = (?) , C_BPartner_ID = (?) , bpzipcode = (?) , BillTo_ID = (?) , C_BPartner_Location_ID = (?) , AD_User_ID = (?) , SalesRep_ID = (?) , M_PriceList_ID = (?) , IsDiscountPrinted = (?) , InvoiceRule = (?) , Estpropability = (?) , M_Warehouse_ID = (?) , C_Currency_ID = (?) , DeliveryRule = (?) , PriorityRule = (?) , PaymentRule = (?) , C_PaymentTerm_ID = (?) , C_Incoterms_ID = (?) , Delivery_Location_ID = (?) , DeliveryViaRule = (?) , M_Shipper_ID = (?) , Weight = TO_NUMBER(?) , Weight_Uom = (?) , FreightCostRule = (?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , FreightAmt = TO_NUMBER(?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Orderselfjoin = (?) , Firstschedinvoicedate = TO_DATE(?) , DatePromised = TO_DATE(?) , Scheddeliverydate = TO_DATE(?) , Schedtransactiondate = TO_DATE(?) , Transactiondate = TO_DATE(?) , Contractdate = TO_DATE(?) , Enddate = TO_DATE(?) , Invoicefrequence = (?) , C_Projectphase_ID = (?) , Isinvoiceafterfirstcycle = (?) , Quarterly_Month = (?) , Yearly_Month = (?) , Weekly_Day = (?) , C_Bidproject_ID = (?) , Monthly_Day = TO_NUMBER(?) , Proposalstatus = (?) , Lostproposalfixedreason = (?) , Lostproposalreason = (?) , Totallinesonetime = TO_NUMBER(?) , Grandtotalonetime = TO_NUMBER(?) , TotalLines = TO_NUMBER(?) , GrandTotal = TO_NUMBER(?) , Generateproject = (?) , Closeproject = (?) , Invoicedamt = TO_NUMBER(?) , Totalpaid = TO_NUMBER(?) , Completeordervalue = TO_NUMBER(?) , Deliverycomplete = (?) , Iscompletelyinvoiced = (?) , Juwimm_Completion = (?) , Juwimm_Time = (?) , Juwimm_Resources = (?) , Juwimm_Budget = (?) , Juwimm_Team_ID = (?) , Juwimm_Plannedgolive = TO_DATE(?) , Juwimm_Estgolive = TO_DATE(?) , Juwimm_Nextimpdate = TO_DATE(?) , Juwimm_Description = (?) , Juwimm_Plannedstart = TO_DATE(?) , Juwimm_Eststart = TO_DATE(?) , Juwimm_Milestone1 = (?) , Juwimm_Ms1planneddate = TO_DATE(?) , Juwimm_Ms1estdate = TO_DATE(?) , Juwimm_Milestone2 = (?) , Juwimm_Ms2planneddate = TO_DATE(?) , Juwimm_Ms2estdate = TO_DATE(?) , Juwimm_Milestone3 = (?) , Juwimm_Ms3planneddate = TO_DATE(?) , Juwimm_Ms3estdate = TO_DATE(?) , Juwimm_Milestone4 = (?) , Juwimm_Ms4planneddate = TO_DATE(?) , Juwimm_Ms4estdate = TO_DATE(?) , Juwimm_Milestone5 = (?) , Juwimm_Ms5planneddate = TO_DATE(?) , Ispaid = (?) , Isrecharge = (?) , Juwimm_Ms5estdate = TO_DATE(?) , Juwimm_Milestone6 = (?) , BtnCopyTemplate = (?) , Juwimm_Ms6planneddate = TO_DATE(?) , Juwimm_Ms6estdate = TO_DATE(?) , Subscriptionchangedate = TO_DATE(?) , Juwimm_Milestone7 = (?) , Juwimm_Ms7planneddate = TO_DATE(?) , Juwimm_Orderstatuscomplete_V_ID = (?) , Juwimm_Ms7estdate = TO_DATE(?) , Juwimm_Plannedend = TO_DATE(?) , Juwimm_Orderstatus_ID = (?) , Juwimm_Estend = TO_DATE(?) , Juwimm_Projectman = (?) , Juwimm_Ouputremarks = (?) , Juwimm_Lastaction = (?) , Juwimm_Nextaction = (?) , Juwimm_Issues = (?) , Juwimm_Decisions = (?) , Juwimm_Lastupdateon = TO_DATE(?) , Juwimm_Lastupdateby = (?) , C_Charge_ID = (?) , IsDelivered = (?) , C_Activity_ID = (?) , Processed = (?) , IsSOTrx = (?) , DocAction = (?) , C_Campaign_ID = (?) , IsTaxIncluded = (?) , DatePrinted = TO_DATE(?) , IsInvoiced = (?) , DateAcct = TO_DATE(?) , C_Order_ID = (?) , IsSelected = (?) , IsPrinted = (?) , Posted = (?) , IsActive = (?) , Processing = (?) , ChargeAmt = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE juwimm_orderstatuscomplete_v.Juwimm_Orderstatuscomplete_V_ID = ? " +
      "        AND juwimm_orderstatuscomplete_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_orderstatuscomplete_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatetemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactionreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrompo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverynotes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpzipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderselfjoin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstschedinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceafterfirstcycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarterlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weeklyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBidprojectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalfixedreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallinesonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotalonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, completeordervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmCompletion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmResources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmBudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextimpdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEststart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs1planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs1estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs2planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs2estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs3planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs3estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs4planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs4estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs5planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs5estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btncopytemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs6planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs6estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subscriptionchangedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs7planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatuscompleteVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs7estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatusId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmProjectman);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOuputremarks);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmIssues);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDecisions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastupdateon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastupdateby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatuscompleteVId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

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

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO juwimm_orderstatuscomplete_v " +
      "        (User1_ID, IsSelfService, AD_OrgTrx_ID, DropShip_Location_ID, CopyFrom, User2_ID, DropShip_User_ID, DropShip_BPartner_ID, AD_Client_ID, AD_Org_ID, DocumentNo, Incotermsdescription, POReference, Generatetemplate, DateOrdered, Transactionreference, CopyFromPO, A_Asset_ID, C_DocTypeTarget_ID, Name, C_DocType_ID, DocStatus, Description, Deliverynotes, Internalnote, C_BPartner_ID, bpzipcode, BillTo_ID, C_BPartner_Location_ID, AD_User_ID, SalesRep_ID, M_PriceList_ID, IsDiscountPrinted, InvoiceRule, Estpropability, M_Warehouse_ID, C_Currency_ID, DeliveryRule, PriorityRule, PaymentRule, C_PaymentTerm_ID, C_Incoterms_ID, Delivery_Location_ID, DeliveryViaRule, M_Shipper_ID, Weight, Weight_Uom, FreightCostRule, M_Product_ID, Qty, FreightAmt, C_Project_ID, C_Projecttask_ID, Orderselfjoin, Firstschedinvoicedate, DatePromised, Scheddeliverydate, Schedtransactiondate, Transactiondate, Contractdate, Enddate, Invoicefrequence, C_Projectphase_ID, Isinvoiceafterfirstcycle, Quarterly_Month, Yearly_Month, Weekly_Day, C_Bidproject_ID, Monthly_Day, Proposalstatus, Lostproposalfixedreason, Lostproposalreason, Totallinesonetime, Grandtotalonetime, TotalLines, GrandTotal, Generateproject, Closeproject, Invoicedamt, Totalpaid, Completeordervalue, Deliverycomplete, Iscompletelyinvoiced, Juwimm_Completion, Juwimm_Time, Juwimm_Resources, Juwimm_Budget, Juwimm_Team_ID, Juwimm_Plannedgolive, Juwimm_Estgolive, Juwimm_Nextimpdate, Juwimm_Description, Juwimm_Plannedstart, Juwimm_Eststart, Juwimm_Milestone1, Juwimm_Ms1planneddate, Juwimm_Ms1estdate, Juwimm_Milestone2, Juwimm_Ms2planneddate, Juwimm_Ms2estdate, Juwimm_Milestone3, Juwimm_Ms3planneddate, Juwimm_Ms3estdate, Juwimm_Milestone4, Juwimm_Ms4planneddate, Juwimm_Ms4estdate, Juwimm_Milestone5, Juwimm_Ms5planneddate, Ispaid, Isrecharge, Juwimm_Ms5estdate, Juwimm_Milestone6, BtnCopyTemplate, Juwimm_Ms6planneddate, Juwimm_Ms6estdate, Subscriptionchangedate, Juwimm_Milestone7, Juwimm_Ms7planneddate, Juwimm_Orderstatuscomplete_V_ID, Juwimm_Ms7estdate, Juwimm_Plannedend, Juwimm_Orderstatus_ID, Juwimm_Estend, Juwimm_Projectman, Juwimm_Ouputremarks, Juwimm_Lastaction, Juwimm_Nextaction, Juwimm_Issues, Juwimm_Decisions, Juwimm_Lastupdateon, Juwimm_Lastupdateby, C_Charge_ID, IsDelivered, C_Activity_ID, Processed, IsSOTrx, DocAction, C_Campaign_ID, IsTaxIncluded, DatePrinted, IsInvoiced, DateAcct, C_Order_ID, IsSelected, IsPrinted, Posted, IsActive, Processing, ChargeAmt, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), (?), (?), TO_DATE(?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), (?), TO_DATE(?), TO_DATE(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dropshipBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, incotermsdescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generatetemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactionreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrompo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverynotes);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpzipcode);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicerule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estpropability);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priorityrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cIncotermsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliveryviarule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mShipperId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weight);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weightUom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightcostrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderselfjoin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstschedinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedtransactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, transactiondate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicefrequence);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiceafterfirstcycle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quarterlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearlyMonth);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, weeklyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBidprojectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, monthlyDay);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proposalstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalfixedreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lostproposalreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallinesonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotalonetime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closeproject);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalpaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, completeordervalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmCompletion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmResources);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmBudget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmTeamId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstgolive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextimpdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDescription);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedstart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEststart);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs1planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs1estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs2planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs2estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs3planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs3estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone4);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs4planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs4estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone5);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs5planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispaid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isrecharge);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs5estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone6);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, btncopytemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs6planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs6estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subscriptionchangedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMilestone7);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs7planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatuscompleteVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmMs7estdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmPlannedend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOrderstatusId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmEstend);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmProjectman);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmOuputremarks);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmNextaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmIssues);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmDecisions);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastupdateon);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwimmLastupdateby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM juwimm_orderstatuscomplete_v" +
      "        WHERE juwimm_orderstatuscomplete_v.Juwimm_Orderstatuscomplete_V_ID = ? " +
      "        AND juwimm_orderstatuscomplete_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND juwimm_orderstatuscomplete_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM juwimm_orderstatuscomplete_v" +
      "        WHERE juwimm_orderstatuscomplete_v.Juwimm_Orderstatuscomplete_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM juwimm_orderstatuscomplete_v" +
      "         WHERE juwimm_orderstatuscomplete_v.Juwimm_Orderstatuscomplete_V_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
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

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM juwimm_orderstatuscomplete_v" +
      "         WHERE juwimm_orderstatuscomplete_v.Juwimm_Orderstatuscomplete_V_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
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
}

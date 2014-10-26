/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SL
 * All portions are Copyright (C) 2008-2009 Openbravo SL
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.model.financialmgmt.accounting.coa;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity FinancialMgmtAcctSchemaDefault (stored in table C_AcctSchema_Default).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class AcctSchemaDefault extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_AcctSchema_Default";
    public static final String ENTITY_NAME = "FinancialMgmtAcctSchemaDefault";
    public static final String PROPERTY_ACCTSCHEMA = "acctSchema";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVENTORYACCT = "inventoryAcct";
    public static final String PROPERTY_INVACTUALADJUSTACCT =
        "invActualAdjustAcct";
    public static final String PROPERTY_DIFFERENCESACCT = "differencesAcct";
    public static final String PROPERTY_REVALUATIONACCT = "revaluationAcct";
    public static final String PROPERTY_REVENUEACCT = "revenueAcct";
    public static final String PROPERTY_EXPENSEACCT = "expenseAcct";
    public static final String PROPERTY_ASSETACCT = "assetAcct";
    public static final String PROPERTY_PURCHASEPRICEVARIANCEACCT =
        "purchasePriceVarianceAcct";
    public static final String PROPERTY_INVOICEPRICEVARIANCEACCT =
        "invoicePriceVarianceAcct";
    public static final String PROPERTY_TRADEDISCOUNTRECACCT =
        "tradeDiscountRecAcct";
    public static final String PROPERTY_TRADEDISCOUNTGRANTACCT =
        "tradeDiscountGrantAcct";
    public static final String PROPERTY_COGSACCT = "cogsAcct";
    public static final String PROPERTY_RECEIVABLEACCT = "receivableAcct";
    public static final String PROPERTY_PREPAYMENTACCT = "prepaymentAcct";
    public static final String PROPERTY_LIABILITYACCT = "liabilityAcct";
    public static final String PROPERTY_LIABILITYSERVICESACCT =
        "liabilityServicesAcct";
    public static final String PROPERTY_PREPAYMENTACCT24 = "prepaymentAcct24";
    public static final String PROPERTY_PAYDISCOUNTEXPACCT =
        "payDiscountExpAcct";
    public static final String PROPERTY_WRITEOFFACCT = "writeOffAcct";
    public static final String PROPERTY_PAYDISCOUNTREVACCT =
        "payDiscountRevAcct";
    public static final String PROPERTY_UNREALIZEDGAINACCT =
        "unrealizedGainAcct";
    public static final String PROPERTY_UNREALIZEDLOSSACCT =
        "unrealizedLossAcct";
    public static final String PROPERTY_REALIZEDGAINACCT = "realizedGainAcct";
    public static final String PROPERTY_REALIZEDLOSSACCT = "realizedLossAcct";
    public static final String PROPERTY_WITHHOLDINGACCT = "withholdingAcct";
    public static final String PROPERTY_PREPAYMENTACCT33 = "prepaymentAcct33";
    public static final String PROPERTY_EXPENSEACCT34 = "expenseAcct34";
    public static final String PROPERTY_ASSETACCT35 = "assetAcct35";
    public static final String PROPERTY_WIPACCT = "wIPAcct";
    public static final String PROPERTY_EXPENSEACCT37 = "expenseAcct37";
    public static final String PROPERTY_LIABILITYACCT38 = "liabilityAcct38";
    public static final String PROPERTY_RECEIVABLESACCT = "receivablesAcct";
    public static final String PROPERTY_DUEACCT = "dueAcct";
    public static final String PROPERTY_CREDITACCT = "creditAcct";
    public static final String PROPERTY_INTRANSITACCT = "inTransitAcct";
    public static final String PROPERTY_ASSETACCT43 = "assetAcct43";
    public static final String PROPERTY_EXPENSEACCT44 = "expenseAcct44";
    public static final String PROPERTY_INTERESTREVACCT = "interestRevAcct";
    public static final String PROPERTY_INTERESTEXPACCT = "interestExpAcct";
    public static final String PROPERTY_UNIDENTIFIEDACCT = "unidentifiedAcct";
    public static final String PROPERTY_UNALLOCATEDCASHACCT =
        "unallocatedCashAcct";
    public static final String PROPERTY_PAYMENTSELECTACCT = "paymentSelectAcct";
    public static final String PROPERTY_SETTLEMENTGAINACCT =
        "settlementGainAcct";
    public static final String PROPERTY_SETTLEMENTLOSSACCT =
        "settlementLossAcct";
    public static final String PROPERTY_REVALUATIONGAINACCT =
        "revaluationGainAcct";
    public static final String PROPERTY_REVALUATIONLOSSACCT =
        "revaluationLossAcct";
    public static final String PROPERTY_EXPENSEACCT54 = "expenseAcct54";
    public static final String PROPERTY_REVENUEACCT55 = "revenueAcct55";
    public static final String PROPERTY_UNEARNEDREVENUEACCT =
        "unEarnedRevenueAcct";
    public static final String PROPERTY_NOTINVOICEDRECEIVABLESACCT =
        "notInvoicedReceivablesAcct";
    public static final String PROPERTY_NOTINVOICEDREVENUEACCT =
        "notInvoicedRevenueAcct";
    public static final String PROPERTY_NOTINVOICEDRECEIPTSACCT =
        "notInvoicedReceiptsAcct";
    public static final String PROPERTY_ASSETACCT60 = "assetAcct60";
    public static final String PROPERTY_CASHTRANSFERACCT = "cashTransferAcct";
    public static final String PROPERTY_DIFFERENCESACCT62 = "differencesAcct62";
    public static final String PROPERTY_EXPENSEACCT63 = "expenseAcct63";
    public static final String PROPERTY_RECEIPTACCT = "receiptAcct";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_ACCUMDEPRECIATIONACCT =
        "accumdepreciationAcct";
    public static final String PROPERTY_DEPRECIATIONACCT = "depreciationAcct";
    public static final String PROPERTY_DISPOSALGAIN = "disposalGain";
    public static final String PROPERTY_DISPOSALLOSS = "disposalLoss";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DISCOUNTACCT = "discountAcct";
    public static final String PROPERTY_DISCOUNTACCT72 = "discountAcct72";

    public AcctSchemaDefault() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public AcctSchema getAcctSchema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctSchema(AcctSchema acctSchema) {
        set(PROPERTY_ACCTSCHEMA, acctSchema);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public AccountingCombination getInventoryAcct() {
        return (AccountingCombination) get(PROPERTY_INVENTORYACCT);
    }

    public void setInventoryAcct(AccountingCombination inventoryAcct) {
        set(PROPERTY_INVENTORYACCT, inventoryAcct);
    }

    public AccountingCombination getInvActualAdjustAcct() {
        return (AccountingCombination) get(PROPERTY_INVACTUALADJUSTACCT);
    }

    public void setInvActualAdjustAcct(
        AccountingCombination invActualAdjustAcct) {
        set(PROPERTY_INVACTUALADJUSTACCT, invActualAdjustAcct);
    }

    public AccountingCombination getDifferencesAcct() {
        return (AccountingCombination) get(PROPERTY_DIFFERENCESACCT);
    }

    public void setDifferencesAcct(AccountingCombination differencesAcct) {
        set(PROPERTY_DIFFERENCESACCT, differencesAcct);
    }

    public AccountingCombination getRevaluationAcct() {
        return (AccountingCombination) get(PROPERTY_REVALUATIONACCT);
    }

    public void setRevaluationAcct(AccountingCombination revaluationAcct) {
        set(PROPERTY_REVALUATIONACCT, revaluationAcct);
    }

    public AccountingCombination getRevenueAcct() {
        return (AccountingCombination) get(PROPERTY_REVENUEACCT);
    }

    public void setRevenueAcct(AccountingCombination revenueAcct) {
        set(PROPERTY_REVENUEACCT, revenueAcct);
    }

    public AccountingCombination getExpenseAcct() {
        return (AccountingCombination) get(PROPERTY_EXPENSEACCT);
    }

    public void setExpenseAcct(AccountingCombination expenseAcct) {
        set(PROPERTY_EXPENSEACCT, expenseAcct);
    }

    public AccountingCombination getAssetAcct() {
        return (AccountingCombination) get(PROPERTY_ASSETACCT);
    }

    public void setAssetAcct(AccountingCombination assetAcct) {
        set(PROPERTY_ASSETACCT, assetAcct);
    }

    public AccountingCombination getPurchasePriceVarianceAcct() {
        return (AccountingCombination) get(PROPERTY_PURCHASEPRICEVARIANCEACCT);
    }

    public void setPurchasePriceVarianceAcct(
        AccountingCombination purchasePriceVarianceAcct) {
        set(PROPERTY_PURCHASEPRICEVARIANCEACCT, purchasePriceVarianceAcct);
    }

    public AccountingCombination getInvoicePriceVarianceAcct() {
        return (AccountingCombination) get(PROPERTY_INVOICEPRICEVARIANCEACCT);
    }

    public void setInvoicePriceVarianceAcct(
        AccountingCombination invoicePriceVarianceAcct) {
        set(PROPERTY_INVOICEPRICEVARIANCEACCT, invoicePriceVarianceAcct);
    }

    public AccountingCombination getTradeDiscountRecAcct() {
        return (AccountingCombination) get(PROPERTY_TRADEDISCOUNTRECACCT);
    }

    public void setTradeDiscountRecAcct(
        AccountingCombination tradeDiscountRecAcct) {
        set(PROPERTY_TRADEDISCOUNTRECACCT, tradeDiscountRecAcct);
    }

    public AccountingCombination getTradeDiscountGrantAcct() {
        return (AccountingCombination) get(PROPERTY_TRADEDISCOUNTGRANTACCT);
    }

    public void setTradeDiscountGrantAcct(
        AccountingCombination tradeDiscountGrantAcct) {
        set(PROPERTY_TRADEDISCOUNTGRANTACCT, tradeDiscountGrantAcct);
    }

    public AccountingCombination getCogsAcct() {
        return (AccountingCombination) get(PROPERTY_COGSACCT);
    }

    public void setCogsAcct(AccountingCombination cogsAcct) {
        set(PROPERTY_COGSACCT, cogsAcct);
    }

    public AccountingCombination getReceivableAcct() {
        return (AccountingCombination) get(PROPERTY_RECEIVABLEACCT);
    }

    public void setReceivableAcct(AccountingCombination receivableAcct) {
        set(PROPERTY_RECEIVABLEACCT, receivableAcct);
    }

    public AccountingCombination getPrepaymentAcct() {
        return (AccountingCombination) get(PROPERTY_PREPAYMENTACCT);
    }

    public void setPrepaymentAcct(AccountingCombination prepaymentAcct) {
        set(PROPERTY_PREPAYMENTACCT, prepaymentAcct);
    }

    public AccountingCombination getLiabilityAcct() {
        return (AccountingCombination) get(PROPERTY_LIABILITYACCT);
    }

    public void setLiabilityAcct(AccountingCombination liabilityAcct) {
        set(PROPERTY_LIABILITYACCT, liabilityAcct);
    }

    public AccountingCombination getLiabilityServicesAcct() {
        return (AccountingCombination) get(PROPERTY_LIABILITYSERVICESACCT);
    }

    public void setLiabilityServicesAcct(
        AccountingCombination liabilityServicesAcct) {
        set(PROPERTY_LIABILITYSERVICESACCT, liabilityServicesAcct);
    }

    public AccountingCombination getPrepaymentAcct24() {
        return (AccountingCombination) get(PROPERTY_PREPAYMENTACCT24);
    }

    public void setPrepaymentAcct24(AccountingCombination prepaymentAcct24) {
        set(PROPERTY_PREPAYMENTACCT24, prepaymentAcct24);
    }

    public AccountingCombination getPayDiscountExpAcct() {
        return (AccountingCombination) get(PROPERTY_PAYDISCOUNTEXPACCT);
    }

    public void setPayDiscountExpAcct(AccountingCombination payDiscountExpAcct) {
        set(PROPERTY_PAYDISCOUNTEXPACCT, payDiscountExpAcct);
    }

    public AccountingCombination getWriteOffAcct() {
        return (AccountingCombination) get(PROPERTY_WRITEOFFACCT);
    }

    public void setWriteOffAcct(AccountingCombination writeOffAcct) {
        set(PROPERTY_WRITEOFFACCT, writeOffAcct);
    }

    public AccountingCombination getPayDiscountRevAcct() {
        return (AccountingCombination) get(PROPERTY_PAYDISCOUNTREVACCT);
    }

    public void setPayDiscountRevAcct(AccountingCombination payDiscountRevAcct) {
        set(PROPERTY_PAYDISCOUNTREVACCT, payDiscountRevAcct);
    }

    public AccountingCombination getUnrealizedGainAcct() {
        return (AccountingCombination) get(PROPERTY_UNREALIZEDGAINACCT);
    }

    public void setUnrealizedGainAcct(AccountingCombination unrealizedGainAcct) {
        set(PROPERTY_UNREALIZEDGAINACCT, unrealizedGainAcct);
    }

    public AccountingCombination getUnrealizedLossAcct() {
        return (AccountingCombination) get(PROPERTY_UNREALIZEDLOSSACCT);
    }

    public void setUnrealizedLossAcct(AccountingCombination unrealizedLossAcct) {
        set(PROPERTY_UNREALIZEDLOSSACCT, unrealizedLossAcct);
    }

    public AccountingCombination getRealizedGainAcct() {
        return (AccountingCombination) get(PROPERTY_REALIZEDGAINACCT);
    }

    public void setRealizedGainAcct(AccountingCombination realizedGainAcct) {
        set(PROPERTY_REALIZEDGAINACCT, realizedGainAcct);
    }

    public AccountingCombination getRealizedLossAcct() {
        return (AccountingCombination) get(PROPERTY_REALIZEDLOSSACCT);
    }

    public void setRealizedLossAcct(AccountingCombination realizedLossAcct) {
        set(PROPERTY_REALIZEDLOSSACCT, realizedLossAcct);
    }

    public AccountingCombination getWithholdingAcct() {
        return (AccountingCombination) get(PROPERTY_WITHHOLDINGACCT);
    }

    public void setWithholdingAcct(AccountingCombination withholdingAcct) {
        set(PROPERTY_WITHHOLDINGACCT, withholdingAcct);
    }

    public AccountingCombination getPrepaymentAcct33() {
        return (AccountingCombination) get(PROPERTY_PREPAYMENTACCT33);
    }

    public void setPrepaymentAcct33(AccountingCombination prepaymentAcct33) {
        set(PROPERTY_PREPAYMENTACCT33, prepaymentAcct33);
    }

    public AccountingCombination getExpenseAcct34() {
        return (AccountingCombination) get(PROPERTY_EXPENSEACCT34);
    }

    public void setExpenseAcct34(AccountingCombination expenseAcct34) {
        set(PROPERTY_EXPENSEACCT34, expenseAcct34);
    }

    public AccountingCombination getAssetAcct35() {
        return (AccountingCombination) get(PROPERTY_ASSETACCT35);
    }

    public void setAssetAcct35(AccountingCombination assetAcct35) {
        set(PROPERTY_ASSETACCT35, assetAcct35);
    }

    public AccountingCombination getWIPAcct() {
        return (AccountingCombination) get(PROPERTY_WIPACCT);
    }

    public void setWIPAcct(AccountingCombination wIPAcct) {
        set(PROPERTY_WIPACCT, wIPAcct);
    }

    public AccountingCombination getExpenseAcct37() {
        return (AccountingCombination) get(PROPERTY_EXPENSEACCT37);
    }

    public void setExpenseAcct37(AccountingCombination expenseAcct37) {
        set(PROPERTY_EXPENSEACCT37, expenseAcct37);
    }

    public AccountingCombination getLiabilityAcct38() {
        return (AccountingCombination) get(PROPERTY_LIABILITYACCT38);
    }

    public void setLiabilityAcct38(AccountingCombination liabilityAcct38) {
        set(PROPERTY_LIABILITYACCT38, liabilityAcct38);
    }

    public AccountingCombination getReceivablesAcct() {
        return (AccountingCombination) get(PROPERTY_RECEIVABLESACCT);
    }

    public void setReceivablesAcct(AccountingCombination receivablesAcct) {
        set(PROPERTY_RECEIVABLESACCT, receivablesAcct);
    }

    public AccountingCombination getDueAcct() {
        return (AccountingCombination) get(PROPERTY_DUEACCT);
    }

    public void setDueAcct(AccountingCombination dueAcct) {
        set(PROPERTY_DUEACCT, dueAcct);
    }

    public AccountingCombination getCreditAcct() {
        return (AccountingCombination) get(PROPERTY_CREDITACCT);
    }

    public void setCreditAcct(AccountingCombination creditAcct) {
        set(PROPERTY_CREDITACCT, creditAcct);
    }

    public AccountingCombination getInTransitAcct() {
        return (AccountingCombination) get(PROPERTY_INTRANSITACCT);
    }

    public void setInTransitAcct(AccountingCombination inTransitAcct) {
        set(PROPERTY_INTRANSITACCT, inTransitAcct);
    }

    public AccountingCombination getAssetAcct43() {
        return (AccountingCombination) get(PROPERTY_ASSETACCT43);
    }

    public void setAssetAcct43(AccountingCombination assetAcct43) {
        set(PROPERTY_ASSETACCT43, assetAcct43);
    }

    public AccountingCombination getExpenseAcct44() {
        return (AccountingCombination) get(PROPERTY_EXPENSEACCT44);
    }

    public void setExpenseAcct44(AccountingCombination expenseAcct44) {
        set(PROPERTY_EXPENSEACCT44, expenseAcct44);
    }

    public AccountingCombination getInterestRevAcct() {
        return (AccountingCombination) get(PROPERTY_INTERESTREVACCT);
    }

    public void setInterestRevAcct(AccountingCombination interestRevAcct) {
        set(PROPERTY_INTERESTREVACCT, interestRevAcct);
    }

    public AccountingCombination getInterestExpAcct() {
        return (AccountingCombination) get(PROPERTY_INTERESTEXPACCT);
    }

    public void setInterestExpAcct(AccountingCombination interestExpAcct) {
        set(PROPERTY_INTERESTEXPACCT, interestExpAcct);
    }

    public AccountingCombination getUnidentifiedAcct() {
        return (AccountingCombination) get(PROPERTY_UNIDENTIFIEDACCT);
    }

    public void setUnidentifiedAcct(AccountingCombination unidentifiedAcct) {
        set(PROPERTY_UNIDENTIFIEDACCT, unidentifiedAcct);
    }

    public AccountingCombination getUnallocatedCashAcct() {
        return (AccountingCombination) get(PROPERTY_UNALLOCATEDCASHACCT);
    }

    public void setUnallocatedCashAcct(
        AccountingCombination unallocatedCashAcct) {
        set(PROPERTY_UNALLOCATEDCASHACCT, unallocatedCashAcct);
    }

    public AccountingCombination getPaymentSelectAcct() {
        return (AccountingCombination) get(PROPERTY_PAYMENTSELECTACCT);
    }

    public void setPaymentSelectAcct(AccountingCombination paymentSelectAcct) {
        set(PROPERTY_PAYMENTSELECTACCT, paymentSelectAcct);
    }

    public AccountingCombination getSettlementGainAcct() {
        return (AccountingCombination) get(PROPERTY_SETTLEMENTGAINACCT);
    }

    public void setSettlementGainAcct(AccountingCombination settlementGainAcct) {
        set(PROPERTY_SETTLEMENTGAINACCT, settlementGainAcct);
    }

    public AccountingCombination getSettlementLossAcct() {
        return (AccountingCombination) get(PROPERTY_SETTLEMENTLOSSACCT);
    }

    public void setSettlementLossAcct(AccountingCombination settlementLossAcct) {
        set(PROPERTY_SETTLEMENTLOSSACCT, settlementLossAcct);
    }

    public AccountingCombination getRevaluationGainAcct() {
        return (AccountingCombination) get(PROPERTY_REVALUATIONGAINACCT);
    }

    public void setRevaluationGainAcct(
        AccountingCombination revaluationGainAcct) {
        set(PROPERTY_REVALUATIONGAINACCT, revaluationGainAcct);
    }

    public AccountingCombination getRevaluationLossAcct() {
        return (AccountingCombination) get(PROPERTY_REVALUATIONLOSSACCT);
    }

    public void setRevaluationLossAcct(
        AccountingCombination revaluationLossAcct) {
        set(PROPERTY_REVALUATIONLOSSACCT, revaluationLossAcct);
    }

    public AccountingCombination getExpenseAcct54() {
        return (AccountingCombination) get(PROPERTY_EXPENSEACCT54);
    }

    public void setExpenseAcct54(AccountingCombination expenseAcct54) {
        set(PROPERTY_EXPENSEACCT54, expenseAcct54);
    }

    public AccountingCombination getRevenueAcct55() {
        return (AccountingCombination) get(PROPERTY_REVENUEACCT55);
    }

    public void setRevenueAcct55(AccountingCombination revenueAcct55) {
        set(PROPERTY_REVENUEACCT55, revenueAcct55);
    }

    public AccountingCombination getUnEarnedRevenueAcct() {
        return (AccountingCombination) get(PROPERTY_UNEARNEDREVENUEACCT);
    }

    public void setUnEarnedRevenueAcct(
        AccountingCombination unEarnedRevenueAcct) {
        set(PROPERTY_UNEARNEDREVENUEACCT, unEarnedRevenueAcct);
    }

    public AccountingCombination getNotInvoicedReceivablesAcct() {
        return (AccountingCombination) get(PROPERTY_NOTINVOICEDRECEIVABLESACCT);
    }

    public void setNotInvoicedReceivablesAcct(
        AccountingCombination notInvoicedReceivablesAcct) {
        set(PROPERTY_NOTINVOICEDRECEIVABLESACCT, notInvoicedReceivablesAcct);
    }

    public AccountingCombination getNotInvoicedRevenueAcct() {
        return (AccountingCombination) get(PROPERTY_NOTINVOICEDREVENUEACCT);
    }

    public void setNotInvoicedRevenueAcct(
        AccountingCombination notInvoicedRevenueAcct) {
        set(PROPERTY_NOTINVOICEDREVENUEACCT, notInvoicedRevenueAcct);
    }

    public AccountingCombination getNotInvoicedReceiptsAcct() {
        return (AccountingCombination) get(PROPERTY_NOTINVOICEDRECEIPTSACCT);
    }

    public void setNotInvoicedReceiptsAcct(
        AccountingCombination notInvoicedReceiptsAcct) {
        set(PROPERTY_NOTINVOICEDRECEIPTSACCT, notInvoicedReceiptsAcct);
    }

    public AccountingCombination getAssetAcct60() {
        return (AccountingCombination) get(PROPERTY_ASSETACCT60);
    }

    public void setAssetAcct60(AccountingCombination assetAcct60) {
        set(PROPERTY_ASSETACCT60, assetAcct60);
    }

    public AccountingCombination getCashTransferAcct() {
        return (AccountingCombination) get(PROPERTY_CASHTRANSFERACCT);
    }

    public void setCashTransferAcct(AccountingCombination cashTransferAcct) {
        set(PROPERTY_CASHTRANSFERACCT, cashTransferAcct);
    }

    public AccountingCombination getDifferencesAcct62() {
        return (AccountingCombination) get(PROPERTY_DIFFERENCESACCT62);
    }

    public void setDifferencesAcct62(AccountingCombination differencesAcct62) {
        set(PROPERTY_DIFFERENCESACCT62, differencesAcct62);
    }

    public AccountingCombination getExpenseAcct63() {
        return (AccountingCombination) get(PROPERTY_EXPENSEACCT63);
    }

    public void setExpenseAcct63(AccountingCombination expenseAcct63) {
        set(PROPERTY_EXPENSEACCT63, expenseAcct63);
    }

    public AccountingCombination getReceiptAcct() {
        return (AccountingCombination) get(PROPERTY_RECEIPTACCT);
    }

    public void setReceiptAcct(AccountingCombination receiptAcct) {
        set(PROPERTY_RECEIPTACCT, receiptAcct);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public AccountingCombination getAccumdepreciationAcct() {
        return (AccountingCombination) get(PROPERTY_ACCUMDEPRECIATIONACCT);
    }

    public void setAccumdepreciationAcct(
        AccountingCombination accumdepreciationAcct) {
        set(PROPERTY_ACCUMDEPRECIATIONACCT, accumdepreciationAcct);
    }

    public AccountingCombination getDepreciationAcct() {
        return (AccountingCombination) get(PROPERTY_DEPRECIATIONACCT);
    }

    public void setDepreciationAcct(AccountingCombination depreciationAcct) {
        set(PROPERTY_DEPRECIATIONACCT, depreciationAcct);
    }

    public AccountingCombination getDisposalGain() {
        return (AccountingCombination) get(PROPERTY_DISPOSALGAIN);
    }

    public void setDisposalGain(AccountingCombination disposalGain) {
        set(PROPERTY_DISPOSALGAIN, disposalGain);
    }

    public AccountingCombination getDisposalLoss() {
        return (AccountingCombination) get(PROPERTY_DISPOSALLOSS);
    }

    public void setDisposalLoss(AccountingCombination disposalLoss) {
        set(PROPERTY_DISPOSALLOSS, disposalLoss);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public AccountingCombination getDiscountAcct() {
        return (AccountingCombination) get(PROPERTY_DISCOUNTACCT);
    }

    public void setDiscountAcct(AccountingCombination discountAcct) {
        set(PROPERTY_DISCOUNTACCT, discountAcct);
    }

    public AccountingCombination getDiscountAcct72() {
        return (AccountingCombination) get(PROPERTY_DISCOUNTACCT72);
    }

    public void setDiscountAcct72(AccountingCombination discountAcct72) {
        set(PROPERTY_DISCOUNTACCT72, discountAcct72);
    }
}

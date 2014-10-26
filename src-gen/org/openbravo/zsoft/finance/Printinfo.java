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
package org.openbravo.zsoft.finance;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity zspr_printinfo (stored in table zspr_printinfo).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Printinfo extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zspr_printinfo";
    public static final String ENTITY_NAME = "zspr_printinfo";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ADDRESSHEADER = "addressheader";
    public static final String PROPERTY_ADDRESS1 = "address1";
    public static final String PROPERTY_ADDRESS2 = "address2";
    public static final String PROPERTY_ADDRESS3 = "address3";
    public static final String PROPERTY_ADDRESS4 = "address4";
    public static final String PROPERTY_ADDRESS5 = "address5";
    public static final String PROPERTY_ADDRESS6 = "address6";
    public static final String PROPERTY_ONELINEADR = "onelineadr";
    public static final String PROPERTY_ADDRESS7 = "address7";
    public static final String PROPERTY_ADDRESS8 = "address8";
    public static final String PROPERTY_ADDRESS9 = "address9";
    public static final String PROPERTY_FOOTER1 = "footer1";
    public static final String PROPERTY_FOOTER2 = "footer2";
    public static final String PROPERTY_FOOTER3 = "footer3";
    public static final String PROPERTY_FOOTER4 = "footer4";
    public static final String PROPERTY_FOOTER5 = "footer5";
    public static final String PROPERTY_ISFOOTERGROUPSTYLE =
        "isfootergroupstyle";
    public static final String PROPERTY_CPYPRODDESC2DOCNOTE =
        "cPYProddesc2docnote";
    public static final String PROPERTY_PRODDESCORDERNUM = "proddescOrdernum";
    public static final String PROPERTY_CPYPRODDOCNOTE2DOCNOTE =
        "cPYProddocnote2docnote";
    public static final String PROPERTY_PRODDOCNOTEORDERNUM =
        "proddocnoteOrdernum";
    public static final String PROPERTY_CPYVENDPNUMBER2DOCNOTE =
        "cPYVendpnumber2docnote";
    public static final String PROPERTY_VENDPNUMBERDNORDERNUM =
        "vendpnumberdnOrdernum";
    public static final String PROPERTY_PRINTATTRSONDOCS = "printattrsondocs";
    public static final String PROPERTY_PRINTATTRSBOLD = "printattrsbold";
    public static final String PROPERTY_PRINTATTRSNEWLINE = "printattrsnewline";
    public static final String PROPERTY_ATTRSORDERNUM = "attrsOrdernum";
    public static final String PROPERTY_PRINTPNUMBERONDOCS =
        "printpnumberondocs";
    public static final String PROPERTY_PRINTPNUMBERBOLD = "printpnumberbold";
    public static final String PROPERTY_PRINTPNUMBERNEWLINE =
        "printpnumbernewline";
    public static final String PROPERTY_PNUMBERORDERNUM = "pnumberOrdernum";
    public static final String PROPERTY_PRINTPNAMEONDOCS = "printpnameondocs";
    public static final String PROPERTY_PRINTPNAMEBOLD = "printpnamebold";
    public static final String PROPERTY_PRINTPNAMENEWLINE = "printpnamenewline";
    public static final String PROPERTY_PNAMEORDERNUM = "pnameOrdernum";
    public static final String PROPERTY_PRINTVPNUMBERONDOCS =
        "printvpnumberondocs";
    public static final String PROPERTY_PRINTVPNUMBERBOLD = "printvpnumberbold";
    public static final String PROPERTY_PRINTVPNUMBERNEWLINE =
        "printvpnumbernewline";
    public static final String PROPERTY_VPNUMBERORDERNUM = "vpnumberOrdernum";
    public static final String PROPERTY_PRINTCASHDISCOUNTINFO =
        "printcashdiscountinfo";
    public static final String PROPERTY_PRINTDOCNOTEONDOCS =
        "printdocnoteondocs";
    public static final String PROPERTY_PRINTDOCNOTEBOLD = "printdocnotebold";
    public static final String PROPERTY_PRINTDOCNOTENEWLINE =
        "printdocnotenewline";
    public static final String PROPERTY_DOCNOTEORDERNUM = "docnoteOrdernum";
    public static final String PROPERTY_PRINTPDESCONDOCS = "printpdescondocs";
    public static final String PROPERTY_PRINTPDESCBOLD = "printpdescbold";
    public static final String PROPERTY_PRINTPDESCNEWLINE = "printpdescnewline";
    public static final String PROPERTY_PDESCORDERNUM = "pdescOrdernum";
    public static final String PROPERTY_PRINTOPENSHIPMENTS =
        "printopenshipments";
    public static final String PROPERTY_PRINTORDERNUMBERONSHIPMENT =
        "printordernumberonshipment";
    public static final String PROPERTY_PRINTORDERNUMBERONSHIPMENTBOLD =
        "printordernumberonshipmentbold";
    public static final String PROPERTY_PRINTORDERNUMBERONSHIPMENTNEWLINE =
        "printordernumberonshipmentnewline";
    public static final String PROPERTY_PORDNOSHIPORDERNUM =
        "pordnoshipOrdernum";
    public static final String PROPERTY_PRINTORDERNUMBERONINVOICE =
        "printordernumberoninvoice";
    public static final String PROPERTY_PRINTORDERNUMBERONINVOICEBOLD =
        "printordernumberoninvoicebold";
    public static final String PROPERTY_PRINTORDERNUMBERONINVOICENEWLINE =
        "printordernumberoninvoicenewline";
    public static final String PROPERTY_PORDNOINVORDERNUM = "pordnoinvOrdernum";
    public static final String PROPERTY_PRINTSHIPMENTNUMBERONINVOICE =
        "printshipmentnumberoninvoice";
    public static final String PROPERTY_PRINTSHIPMENTNUMBERONINVOICEBOLD =
        "printshipmentnumberoninvoicebold";
    public static final String PROPERTY_PRINTSHIPMENTNUMBERONINVOICENEWLINE =
        "printshipmentnumberoninvoicenewline";
    public static final String PROPERTY_PSHIPNOINVORDERNUM =
        "pshipnoinvOrdernum";
    public static final String PROPERTY_PRINTSHIPMENTDATEONINVOICE =
        "printshipmentdateoninvoice";
    public static final String PROPERTY_PRINTSHIPMENTDATEONINVOICEBOLD =
        "printshipmentdateoninvoicebold";
    public static final String PROPERTY_PRINTSHIPMENTDATEONINVOICENEWLINE =
        "printshipmentdateoninvoicenewline";
    public static final String PROPERTY_PSHIPDATEINVORDERNUM =
        "pshipdateinvOrdernum";
    public static final String PROPERTY_PERFORMACEDATEONINVOICE =
        "performacedateoninvoice";
    public static final String PROPERTY_PRINTSERIALNUMBERONDOCS =
        "printserialnumberondocs";
    public static final String PROPERTY_PRINTSETPRODUCTWITHBOM =
        "printsetproductwithbom";

    public Printinfo() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISFOOTERGROUPSTYLE, true);
        setDefaultValue(PROPERTY_CPYPRODDESC2DOCNOTE, false);
        setDefaultValue(PROPERTY_CPYPRODDOCNOTE2DOCNOTE, true);
        setDefaultValue(PROPERTY_CPYVENDPNUMBER2DOCNOTE, true);
        setDefaultValue(PROPERTY_PRINTATTRSONDOCS, true);
        setDefaultValue(PROPERTY_PRINTATTRSBOLD, false);
        setDefaultValue(PROPERTY_PRINTATTRSNEWLINE, false);
        setDefaultValue(PROPERTY_PRINTPNUMBERONDOCS, true);
        setDefaultValue(PROPERTY_PRINTPNUMBERBOLD, true);
        setDefaultValue(PROPERTY_PRINTPNUMBERNEWLINE, true);
        setDefaultValue(PROPERTY_PRINTPNAMEONDOCS, true);
        setDefaultValue(PROPERTY_PRINTPNAMEBOLD, true);
        setDefaultValue(PROPERTY_PRINTPNAMENEWLINE, true);
        setDefaultValue(PROPERTY_PRINTVPNUMBERONDOCS, false);
        setDefaultValue(PROPERTY_PRINTVPNUMBERBOLD, false);
        setDefaultValue(PROPERTY_PRINTVPNUMBERNEWLINE, false);
        setDefaultValue(PROPERTY_PRINTCASHDISCOUNTINFO, true);
        setDefaultValue(PROPERTY_PRINTDOCNOTEONDOCS, false);
        setDefaultValue(PROPERTY_PRINTDOCNOTEBOLD, false);
        setDefaultValue(PROPERTY_PRINTDOCNOTENEWLINE, true);
        setDefaultValue(PROPERTY_PRINTPDESCONDOCS, false);
        setDefaultValue(PROPERTY_PRINTPDESCBOLD, false);
        setDefaultValue(PROPERTY_PRINTPDESCNEWLINE, true);
        setDefaultValue(PROPERTY_PRINTOPENSHIPMENTS, false);
        setDefaultValue(PROPERTY_PRINTORDERNUMBERONSHIPMENT, false);
        setDefaultValue(PROPERTY_PRINTORDERNUMBERONSHIPMENTBOLD, false);
        setDefaultValue(PROPERTY_PRINTORDERNUMBERONSHIPMENTNEWLINE, false);
        setDefaultValue(PROPERTY_PRINTORDERNUMBERONINVOICE, false);
        setDefaultValue(PROPERTY_PRINTORDERNUMBERONINVOICEBOLD, false);
        setDefaultValue(PROPERTY_PRINTORDERNUMBERONINVOICENEWLINE, false);
        setDefaultValue(PROPERTY_PRINTSHIPMENTNUMBERONINVOICE, false);
        setDefaultValue(PROPERTY_PRINTSHIPMENTNUMBERONINVOICEBOLD, false);
        setDefaultValue(PROPERTY_PRINTSHIPMENTNUMBERONINVOICENEWLINE, false);
        setDefaultValue(PROPERTY_PRINTSHIPMENTDATEONINVOICE, false);
        setDefaultValue(PROPERTY_PRINTSHIPMENTDATEONINVOICEBOLD, false);
        setDefaultValue(PROPERTY_PRINTSHIPMENTDATEONINVOICENEWLINE, false);
        setDefaultValue(PROPERTY_PERFORMACEDATEONINVOICE, false);
        setDefaultValue(PROPERTY_PRINTSERIALNUMBERONDOCS, false);
        setDefaultValue(PROPERTY_PRINTSETPRODUCTWITHBOM, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
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

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
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

    public String getAddressheader() {
        return (String) get(PROPERTY_ADDRESSHEADER);
    }

    public void setAddressheader(String addressheader) {
        set(PROPERTY_ADDRESSHEADER, addressheader);
    }

    public String getAddress1() {
        return (String) get(PROPERTY_ADDRESS1);
    }

    public void setAddress1(String address1) {
        set(PROPERTY_ADDRESS1, address1);
    }

    public String getAddress2() {
        return (String) get(PROPERTY_ADDRESS2);
    }

    public void setAddress2(String address2) {
        set(PROPERTY_ADDRESS2, address2);
    }

    public String getAddress3() {
        return (String) get(PROPERTY_ADDRESS3);
    }

    public void setAddress3(String address3) {
        set(PROPERTY_ADDRESS3, address3);
    }

    public String getAddress4() {
        return (String) get(PROPERTY_ADDRESS4);
    }

    public void setAddress4(String address4) {
        set(PROPERTY_ADDRESS4, address4);
    }

    public String getAddress5() {
        return (String) get(PROPERTY_ADDRESS5);
    }

    public void setAddress5(String address5) {
        set(PROPERTY_ADDRESS5, address5);
    }

    public String getAddress6() {
        return (String) get(PROPERTY_ADDRESS6);
    }

    public void setAddress6(String address6) {
        set(PROPERTY_ADDRESS6, address6);
    }

    public String getOnelineadr() {
        return (String) get(PROPERTY_ONELINEADR);
    }

    public void setOnelineadr(String onelineadr) {
        set(PROPERTY_ONELINEADR, onelineadr);
    }

    public String getAddress7() {
        return (String) get(PROPERTY_ADDRESS7);
    }

    public void setAddress7(String address7) {
        set(PROPERTY_ADDRESS7, address7);
    }

    public String getAddress8() {
        return (String) get(PROPERTY_ADDRESS8);
    }

    public void setAddress8(String address8) {
        set(PROPERTY_ADDRESS8, address8);
    }

    public String getAddress9() {
        return (String) get(PROPERTY_ADDRESS9);
    }

    public void setAddress9(String address9) {
        set(PROPERTY_ADDRESS9, address9);
    }

    public String getFooter1() {
        return (String) get(PROPERTY_FOOTER1);
    }

    public void setFooter1(String footer1) {
        set(PROPERTY_FOOTER1, footer1);
    }

    public String getFooter2() {
        return (String) get(PROPERTY_FOOTER2);
    }

    public void setFooter2(String footer2) {
        set(PROPERTY_FOOTER2, footer2);
    }

    public String getFooter3() {
        return (String) get(PROPERTY_FOOTER3);
    }

    public void setFooter3(String footer3) {
        set(PROPERTY_FOOTER3, footer3);
    }

    public String getFooter4() {
        return (String) get(PROPERTY_FOOTER4);
    }

    public void setFooter4(String footer4) {
        set(PROPERTY_FOOTER4, footer4);
    }

    public String getFooter5() {
        return (String) get(PROPERTY_FOOTER5);
    }

    public void setFooter5(String footer5) {
        set(PROPERTY_FOOTER5, footer5);
    }

    public Boolean isFootergroupstyle() {
        return (Boolean) get(PROPERTY_ISFOOTERGROUPSTYLE);
    }

    public void setFootergroupstyle(Boolean isfootergroupstyle) {
        set(PROPERTY_ISFOOTERGROUPSTYLE, isfootergroupstyle);
    }

    public Boolean isCPYProddesc2docnote() {
        return (Boolean) get(PROPERTY_CPYPRODDESC2DOCNOTE);
    }

    public void setCPYProddesc2docnote(Boolean cPYProddesc2docnote) {
        set(PROPERTY_CPYPRODDESC2DOCNOTE, cPYProddesc2docnote);
    }

    public Long getProddescOrdernum() {
        return (Long) get(PROPERTY_PRODDESCORDERNUM);
    }

    public void setProddescOrdernum(Long proddescOrdernum) {
        set(PROPERTY_PRODDESCORDERNUM, proddescOrdernum);
    }

    public Boolean isCPYProddocnote2docnote() {
        return (Boolean) get(PROPERTY_CPYPRODDOCNOTE2DOCNOTE);
    }

    public void setCPYProddocnote2docnote(Boolean cPYProddocnote2docnote) {
        set(PROPERTY_CPYPRODDOCNOTE2DOCNOTE, cPYProddocnote2docnote);
    }

    public Long getProddocnoteOrdernum() {
        return (Long) get(PROPERTY_PRODDOCNOTEORDERNUM);
    }

    public void setProddocnoteOrdernum(Long proddocnoteOrdernum) {
        set(PROPERTY_PRODDOCNOTEORDERNUM, proddocnoteOrdernum);
    }

    public Boolean isCPYVendpnumber2docnote() {
        return (Boolean) get(PROPERTY_CPYVENDPNUMBER2DOCNOTE);
    }

    public void setCPYVendpnumber2docnote(Boolean cPYVendpnumber2docnote) {
        set(PROPERTY_CPYVENDPNUMBER2DOCNOTE, cPYVendpnumber2docnote);
    }

    public Long getVendpnumberdnOrdernum() {
        return (Long) get(PROPERTY_VENDPNUMBERDNORDERNUM);
    }

    public void setVendpnumberdnOrdernum(Long vendpnumberdnOrdernum) {
        set(PROPERTY_VENDPNUMBERDNORDERNUM, vendpnumberdnOrdernum);
    }

    public Boolean isPrintattrsondocs() {
        return (Boolean) get(PROPERTY_PRINTATTRSONDOCS);
    }

    public void setPrintattrsondocs(Boolean printattrsondocs) {
        set(PROPERTY_PRINTATTRSONDOCS, printattrsondocs);
    }

    public Boolean isPrintattrsbold() {
        return (Boolean) get(PROPERTY_PRINTATTRSBOLD);
    }

    public void setPrintattrsbold(Boolean printattrsbold) {
        set(PROPERTY_PRINTATTRSBOLD, printattrsbold);
    }

    public Boolean isPrintattrsnewline() {
        return (Boolean) get(PROPERTY_PRINTATTRSNEWLINE);
    }

    public void setPrintattrsnewline(Boolean printattrsnewline) {
        set(PROPERTY_PRINTATTRSNEWLINE, printattrsnewline);
    }

    public Long getAttrsOrdernum() {
        return (Long) get(PROPERTY_ATTRSORDERNUM);
    }

    public void setAttrsOrdernum(Long attrsOrdernum) {
        set(PROPERTY_ATTRSORDERNUM, attrsOrdernum);
    }

    public Boolean isPrintpnumberondocs() {
        return (Boolean) get(PROPERTY_PRINTPNUMBERONDOCS);
    }

    public void setPrintpnumberondocs(Boolean printpnumberondocs) {
        set(PROPERTY_PRINTPNUMBERONDOCS, printpnumberondocs);
    }

    public Boolean isPrintpnumberbold() {
        return (Boolean) get(PROPERTY_PRINTPNUMBERBOLD);
    }

    public void setPrintpnumberbold(Boolean printpnumberbold) {
        set(PROPERTY_PRINTPNUMBERBOLD, printpnumberbold);
    }

    public Boolean isPrintpnumbernewline() {
        return (Boolean) get(PROPERTY_PRINTPNUMBERNEWLINE);
    }

    public void setPrintpnumbernewline(Boolean printpnumbernewline) {
        set(PROPERTY_PRINTPNUMBERNEWLINE, printpnumbernewline);
    }

    public Long getPnumberOrdernum() {
        return (Long) get(PROPERTY_PNUMBERORDERNUM);
    }

    public void setPnumberOrdernum(Long pnumberOrdernum) {
        set(PROPERTY_PNUMBERORDERNUM, pnumberOrdernum);
    }

    public Boolean isPrintpnameondocs() {
        return (Boolean) get(PROPERTY_PRINTPNAMEONDOCS);
    }

    public void setPrintpnameondocs(Boolean printpnameondocs) {
        set(PROPERTY_PRINTPNAMEONDOCS, printpnameondocs);
    }

    public Boolean isPrintpnamebold() {
        return (Boolean) get(PROPERTY_PRINTPNAMEBOLD);
    }

    public void setPrintpnamebold(Boolean printpnamebold) {
        set(PROPERTY_PRINTPNAMEBOLD, printpnamebold);
    }

    public Boolean isPrintpnamenewline() {
        return (Boolean) get(PROPERTY_PRINTPNAMENEWLINE);
    }

    public void setPrintpnamenewline(Boolean printpnamenewline) {
        set(PROPERTY_PRINTPNAMENEWLINE, printpnamenewline);
    }

    public Long getPnameOrdernum() {
        return (Long) get(PROPERTY_PNAMEORDERNUM);
    }

    public void setPnameOrdernum(Long pnameOrdernum) {
        set(PROPERTY_PNAMEORDERNUM, pnameOrdernum);
    }

    public Boolean isPrintvpnumberondocs() {
        return (Boolean) get(PROPERTY_PRINTVPNUMBERONDOCS);
    }

    public void setPrintvpnumberondocs(Boolean printvpnumberondocs) {
        set(PROPERTY_PRINTVPNUMBERONDOCS, printvpnumberondocs);
    }

    public Boolean isPrintvpnumberbold() {
        return (Boolean) get(PROPERTY_PRINTVPNUMBERBOLD);
    }

    public void setPrintvpnumberbold(Boolean printvpnumberbold) {
        set(PROPERTY_PRINTVPNUMBERBOLD, printvpnumberbold);
    }

    public Boolean isPrintvpnumbernewline() {
        return (Boolean) get(PROPERTY_PRINTVPNUMBERNEWLINE);
    }

    public void setPrintvpnumbernewline(Boolean printvpnumbernewline) {
        set(PROPERTY_PRINTVPNUMBERNEWLINE, printvpnumbernewline);
    }

    public Long getVpnumberOrdernum() {
        return (Long) get(PROPERTY_VPNUMBERORDERNUM);
    }

    public void setVpnumberOrdernum(Long vpnumberOrdernum) {
        set(PROPERTY_VPNUMBERORDERNUM, vpnumberOrdernum);
    }

    public Boolean isPrintcashdiscountinfo() {
        return (Boolean) get(PROPERTY_PRINTCASHDISCOUNTINFO);
    }

    public void setPrintcashdiscountinfo(Boolean printcashdiscountinfo) {
        set(PROPERTY_PRINTCASHDISCOUNTINFO, printcashdiscountinfo);
    }

    public Boolean isPrintdocnoteondocs() {
        return (Boolean) get(PROPERTY_PRINTDOCNOTEONDOCS);
    }

    public void setPrintdocnoteondocs(Boolean printdocnoteondocs) {
        set(PROPERTY_PRINTDOCNOTEONDOCS, printdocnoteondocs);
    }

    public Boolean isPrintdocnotebold() {
        return (Boolean) get(PROPERTY_PRINTDOCNOTEBOLD);
    }

    public void setPrintdocnotebold(Boolean printdocnotebold) {
        set(PROPERTY_PRINTDOCNOTEBOLD, printdocnotebold);
    }

    public Boolean isPrintdocnotenewline() {
        return (Boolean) get(PROPERTY_PRINTDOCNOTENEWLINE);
    }

    public void setPrintdocnotenewline(Boolean printdocnotenewline) {
        set(PROPERTY_PRINTDOCNOTENEWLINE, printdocnotenewline);
    }

    public Long getDocnoteOrdernum() {
        return (Long) get(PROPERTY_DOCNOTEORDERNUM);
    }

    public void setDocnoteOrdernum(Long docnoteOrdernum) {
        set(PROPERTY_DOCNOTEORDERNUM, docnoteOrdernum);
    }

    public Boolean isPrintpdescondocs() {
        return (Boolean) get(PROPERTY_PRINTPDESCONDOCS);
    }

    public void setPrintpdescondocs(Boolean printpdescondocs) {
        set(PROPERTY_PRINTPDESCONDOCS, printpdescondocs);
    }

    public Boolean isPrintpdescbold() {
        return (Boolean) get(PROPERTY_PRINTPDESCBOLD);
    }

    public void setPrintpdescbold(Boolean printpdescbold) {
        set(PROPERTY_PRINTPDESCBOLD, printpdescbold);
    }

    public Boolean isPrintpdescnewline() {
        return (Boolean) get(PROPERTY_PRINTPDESCNEWLINE);
    }

    public void setPrintpdescnewline(Boolean printpdescnewline) {
        set(PROPERTY_PRINTPDESCNEWLINE, printpdescnewline);
    }

    public Long getPdescOrdernum() {
        return (Long) get(PROPERTY_PDESCORDERNUM);
    }

    public void setPdescOrdernum(Long pdescOrdernum) {
        set(PROPERTY_PDESCORDERNUM, pdescOrdernum);
    }

    public Boolean isPrintopenshipments() {
        return (Boolean) get(PROPERTY_PRINTOPENSHIPMENTS);
    }

    public void setPrintopenshipments(Boolean printopenshipments) {
        set(PROPERTY_PRINTOPENSHIPMENTS, printopenshipments);
    }

    public Boolean isPrintordernumberonshipment() {
        return (Boolean) get(PROPERTY_PRINTORDERNUMBERONSHIPMENT);
    }

    public void setPrintordernumberonshipment(
        Boolean printordernumberonshipment) {
        set(PROPERTY_PRINTORDERNUMBERONSHIPMENT, printordernumberonshipment);
    }

    public Boolean isPrintordernumberonshipmentbold() {
        return (Boolean) get(PROPERTY_PRINTORDERNUMBERONSHIPMENTBOLD);
    }

    public void setPrintordernumberonshipmentbold(
        Boolean printordernumberonshipmentbold) {
        set(PROPERTY_PRINTORDERNUMBERONSHIPMENTBOLD,
            printordernumberonshipmentbold);
    }

    public Boolean isPrintordernumberonshipmentnewline() {
        return (Boolean) get(PROPERTY_PRINTORDERNUMBERONSHIPMENTNEWLINE);
    }

    public void setPrintordernumberonshipmentnewline(
        Boolean printordernumberonshipmentnewline) {
        set(PROPERTY_PRINTORDERNUMBERONSHIPMENTNEWLINE,
            printordernumberonshipmentnewline);
    }

    public Long getPordnoshipOrdernum() {
        return (Long) get(PROPERTY_PORDNOSHIPORDERNUM);
    }

    public void setPordnoshipOrdernum(Long pordnoshipOrdernum) {
        set(PROPERTY_PORDNOSHIPORDERNUM, pordnoshipOrdernum);
    }

    public Boolean isPrintordernumberoninvoice() {
        return (Boolean) get(PROPERTY_PRINTORDERNUMBERONINVOICE);
    }

    public void setPrintordernumberoninvoice(Boolean printordernumberoninvoice) {
        set(PROPERTY_PRINTORDERNUMBERONINVOICE, printordernumberoninvoice);
    }

    public Boolean isPrintordernumberoninvoicebold() {
        return (Boolean) get(PROPERTY_PRINTORDERNUMBERONINVOICEBOLD);
    }

    public void setPrintordernumberoninvoicebold(
        Boolean printordernumberoninvoicebold) {
        set(PROPERTY_PRINTORDERNUMBERONINVOICEBOLD,
            printordernumberoninvoicebold);
    }

    public Boolean isPrintordernumberoninvoicenewline() {
        return (Boolean) get(PROPERTY_PRINTORDERNUMBERONINVOICENEWLINE);
    }

    public void setPrintordernumberoninvoicenewline(
        Boolean printordernumberoninvoicenewline) {
        set(PROPERTY_PRINTORDERNUMBERONINVOICENEWLINE,
            printordernumberoninvoicenewline);
    }

    public Long getPordnoinvOrdernum() {
        return (Long) get(PROPERTY_PORDNOINVORDERNUM);
    }

    public void setPordnoinvOrdernum(Long pordnoinvOrdernum) {
        set(PROPERTY_PORDNOINVORDERNUM, pordnoinvOrdernum);
    }

    public Boolean isPrintshipmentnumberoninvoice() {
        return (Boolean) get(PROPERTY_PRINTSHIPMENTNUMBERONINVOICE);
    }

    public void setPrintshipmentnumberoninvoice(
        Boolean printshipmentnumberoninvoice) {
        set(PROPERTY_PRINTSHIPMENTNUMBERONINVOICE, printshipmentnumberoninvoice);
    }

    public Boolean isPrintshipmentnumberoninvoicebold() {
        return (Boolean) get(PROPERTY_PRINTSHIPMENTNUMBERONINVOICEBOLD);
    }

    public void setPrintshipmentnumberoninvoicebold(
        Boolean printshipmentnumberoninvoicebold) {
        set(PROPERTY_PRINTSHIPMENTNUMBERONINVOICEBOLD,
            printshipmentnumberoninvoicebold);
    }

    public Boolean isPrintshipmentnumberoninvoicenewline() {
        return (Boolean) get(PROPERTY_PRINTSHIPMENTNUMBERONINVOICENEWLINE);
    }

    public void setPrintshipmentnumberoninvoicenewline(
        Boolean printshipmentnumberoninvoicenewline) {
        set(PROPERTY_PRINTSHIPMENTNUMBERONINVOICENEWLINE,
            printshipmentnumberoninvoicenewline);
    }

    public Long getPshipnoinvOrdernum() {
        return (Long) get(PROPERTY_PSHIPNOINVORDERNUM);
    }

    public void setPshipnoinvOrdernum(Long pshipnoinvOrdernum) {
        set(PROPERTY_PSHIPNOINVORDERNUM, pshipnoinvOrdernum);
    }

    public Boolean isPrintshipmentdateoninvoice() {
        return (Boolean) get(PROPERTY_PRINTSHIPMENTDATEONINVOICE);
    }

    public void setPrintshipmentdateoninvoice(
        Boolean printshipmentdateoninvoice) {
        set(PROPERTY_PRINTSHIPMENTDATEONINVOICE, printshipmentdateoninvoice);
    }

    public Boolean isPrintshipmentdateoninvoicebold() {
        return (Boolean) get(PROPERTY_PRINTSHIPMENTDATEONINVOICEBOLD);
    }

    public void setPrintshipmentdateoninvoicebold(
        Boolean printshipmentdateoninvoicebold) {
        set(PROPERTY_PRINTSHIPMENTDATEONINVOICEBOLD,
            printshipmentdateoninvoicebold);
    }

    public Boolean isPrintshipmentdateoninvoicenewline() {
        return (Boolean) get(PROPERTY_PRINTSHIPMENTDATEONINVOICENEWLINE);
    }

    public void setPrintshipmentdateoninvoicenewline(
        Boolean printshipmentdateoninvoicenewline) {
        set(PROPERTY_PRINTSHIPMENTDATEONINVOICENEWLINE,
            printshipmentdateoninvoicenewline);
    }

    public Long getPshipdateinvOrdernum() {
        return (Long) get(PROPERTY_PSHIPDATEINVORDERNUM);
    }

    public void setPshipdateinvOrdernum(Long pshipdateinvOrdernum) {
        set(PROPERTY_PSHIPDATEINVORDERNUM, pshipdateinvOrdernum);
    }

    public Boolean isPerformacedateoninvoice() {
        return (Boolean) get(PROPERTY_PERFORMACEDATEONINVOICE);
    }

    public void setPerformacedateoninvoice(Boolean performacedateoninvoice) {
        set(PROPERTY_PERFORMACEDATEONINVOICE, performacedateoninvoice);
    }

    public Boolean isPrintserialnumberondocs() {
        return (Boolean) get(PROPERTY_PRINTSERIALNUMBERONDOCS);
    }

    public void setPrintserialnumberondocs(Boolean printserialnumberondocs) {
        set(PROPERTY_PRINTSERIALNUMBERONDOCS, printserialnumberondocs);
    }

    public Boolean isPrintsetproductwithbom() {
        return (Boolean) get(PROPERTY_PRINTSETPRODUCTWITHBOM);
    }

    public void setPrintsetproductwithbom(Boolean printsetproductwithbom) {
        set(PROPERTY_PRINTSETPRODUCTWITHBOM, printsetproductwithbom);
    }
}

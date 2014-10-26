/* commonfunctions.sql */

/*****************************************************+

Document Type Management

*****************************************************/

CREATE OR REPLACE FUNCTION ad_get_doctype(p_clientid character varying, p_orgid character varying, p_docbasetype character varying, p_docsubtypeso character) RETURNS character varying
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, 07/2011, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************/
  v_DocTypeId VARCHAR(32) ; --OBTG:varchar2--
  BEGIN
      SELECT C_DocType_ID into v_DocTypeId
      FROM C_DOCTYPE
      WHERE DOCBASETYPE=p_DocBaseType
        AND ISACTIVE='Y' AND coalesce(DOCSUBTYPESO,'null')=coalesce(p_DocSubTypeSO,'null')
        AND AD_Client_Id=p_ClientId
        AND AD_ISORGINCLUDED(p_OrgId, AD_Org_ID, p_ClientId) <> -1
      ORDER BY IsDefault desc LIMIT 1;
    RETURN v_DocTypeId;
END ; $_$;


CREATE OR REPLACE FUNCTION ad_get_docbasetype( p_doctypeID character varying) RETURNS character varying
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, 07/2012, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************/
  v_DocTypeId VARCHAR(32) ; --OBTG:varchar2--
  BEGIN
      SELECT docbasetype into v_DocTypeId
      FROM C_DOCTYPE
      WHERE c_doctype_id=p_doctypeID;
    RETURN v_DocTypeId;
END ; $_$;

CREATE OR REPLACE FUNCTION ad_get_defaultDocTypeTemplate(p_doctypeID character varying, p_org_id character varying) RETURNS character varying
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/***************************************************************************************************************************************************
* The contents of this file are subject to the Openbravo  Public  License Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
* Version 1.1  with a permitted attribution clause; you may not  use this file except in compliance with the License. You  may  obtain  a copy of
* the License at http://www.openbravo.com/legal/license.html. Software distributed under the License  is  distributed  on  an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific  language  governing  rights  and  limitations
* under the License. The Original Code is Openbravo ERP.
* The Initial Developer of the Original Code is Openbravo SL. Parts created by Openbravo are Copyright (C) 2001-2009 Openbravo SL
* All Rights Reserved.
* Contributor(s): Stefan Zimmermann, 07/2012, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2011 Stefan Zimmermann
* 
****************************************************************************************************************************************************/
  v_DocTempId VARCHAR(32) ; --OBTG:varchar2--
  BEGIN
      SELECT c_poc_doctype_template_id into v_DocTempId FROM C_POC_DOCTYPE_TEMPLATE    WHERE c_doctype_id=p_doctypeID and ad_org_id=p_org_id and isdefault='Y';
      if v_DocTempId is null then
         SELECT c_poc_doctype_template_id into v_DocTempId FROM C_POC_DOCTYPE_TEMPLATE    WHERE c_doctype_id=p_doctypeID and ad_org_id='0' and isdefault='Y';
      end if;
      if v_DocTempId is null then
         SELECT c_poc_doctype_template_id into v_DocTempId FROM C_POC_DOCTYPE_TEMPLATE    WHERE c_doctype_id=p_doctypeID and ad_org_id=p_org_id;
      end if;
      if v_DocTempId is null then
        SELECT c_poc_doctype_template_id into v_DocTempId FROM C_POC_DOCTYPE_TEMPLATE    WHERE c_doctype_id=p_doctypeID and ad_org_id='0';
      end if;
    RETURN v_DocTempId;
END ; $_$;

CREATE OR REPLACE FUNCTION ad_get_doctypename(p_doctypeid character varying, p_lang character varying)
  RETURNS character varying AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************/
  v_Docname VARCHAR; --OBTG:varchar2--
  BEGIN
     select COALESCE(dttrl.Name, dt.Name)  into v_Docname
      FROM C_DOCTYPE dt left join c_doctype_trl dttrl on dt.c_doctype_id=dttrl.c_doctype_id 
            WHERE dttrl.ad_language=p_lang and
            dt.c_doctype_id=p_doctypeID;
    RETURN v_Docname;
END ; $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION c_nodelete_trg() RETURNS trigger
LANGUAGE plpgsql
AS $_$ DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of CORE
Prevents deletion of Main DOCTYPES
*****************************************************/
        
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;
 -- Do not delete 
 IF TG_OP = 'DELETE' THEN
     raise exception '@nodeletepossible@';
 END IF;
 
-- Updating
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END ; $_$;

CREATE OR REPLACE FUNCTION c_doctyperestrict_trg() RETURNS trigger
LANGUAGE plpgsql
AS $_$ DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of CORE
Prevents deletion of Main DOCTYPES
*****************************************************/
        
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
    END IF;
 -- Do not delete 
 IF TG_OP = 'DELETE' THEN
     raise exception '@nodeletepossible@';
 END IF;
 IF TG_OP = 'UPDATE' THEN
    if old.name in  ('Project','Projecttask','Employee') and old.name!=new.name then
        raise exception 'Changing Name on this Item is not Possible';
    end if;
 END IF;
-- Updating
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END ; $_$;

select zsse_DropTrigger ('c_doctyperestrict_trg','c_doctype');

CREATE TRIGGER c_doctyperestrict_trg
  BEFORE INSERT OR UPDATE OR DELETE
  ON c_doctype FOR EACH ROW
  EXECUTE PROCEDURE c_doctyperestrict_trg();
  
  
select zsse_DropFunction ('ad_sequence_doctype');


CREATE OR REPLACE FUNCTION ad_sequence_doctype(p_doctype_id character varying, p_ad_org_id character varying, p_update_next character, OUT p_documentno character varying) RETURNS character varying
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/*************************************************************************
  * The contents of this file are subject to the Compiere Public
  * License 1.1 ("License"); You may not use this file except in
  * compliance with the License. You may obtain a copy of the License in
  * the legal folder of your Openbravo installation.
  * Software distributed under the License is distributed on an
  * "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
  * implied. See the License for the specific language governing rights
  * and limitations under the License.
  * The Original Code is  Compiere  ERP &  Business Solution
  * The Initial Developer of the Original Code is Jorg Janke and ComPiere, Inc.
  * Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke,
  * parts created by ComPiere are Copyright (C) ComPiere, Inc.;
  * All Rights Reserved.
  * Contributor(s): Openbravo SL
  * Contributor(s): Stefan Zimmermann, 2012, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2012 Stefan Zimmermann
  * Contributions are Copyright (C) 2001-2009 Openbravo, S.L.
  *
  * Specifically, this derivative work is based upon the following Compiere
  * file and version.
  *************************************************************************
  * $Id: AD_Sequence_DocType.sql,v 1.9 2003/08/06 06:51:27 jjanke Exp $
  ***
  * Title: Get the next DocumentNo of Document Type
  * Description:
  *  store in parameter p_DocumentNo
  *  If ID < 1000000, use System Doc Sequence
  *  If no Document Sequence is defined, return null !
  *   Use AD_Sequence_Doc('DocumentNo_myTable',.. to get it directly
  ************************************************************************/
  v_NextNo VARCHAR(32); --OBTG:VARCHAR2--

  v_Sequence_ID VARCHAR(32):=NULL; --OBTG:VARCHAR2--
  v_Prefix VARCHAR(30) ; --OBTG:VARCHAR2--
  v_Suffix VARCHAR(30) ; --OBTG:VARCHAR2--
  v_table varchar;
  v_count numeric;
  v_sql character varying;
  TYPE_Ref REFCURSOR;
  v_cursor TYPE_Ref%TYPE;
  v_cur RECORD;
BEGIN
  -- Is a document Sequence defined and valid
BEGIN
  SELECT DocNoSequence_ID
  INTO v_Sequence_ID
  FROM C_DocType
  WHERE C_DocType_ID=p_DocType_ID -- parameter
    AND IsDocNoControlled='Y'  AND IsActive='Y';
EXCEPTION
WHEN OTHERS THEN
  NULL;
END;
IF(v_Sequence_ID IS NULL) THEN -- No Sequence Number
  p_DocumentNo:= NULL; -- Return NULL
  RAISE NOTICE '%','[AD_Sequence_DocType: not found - C_DocType_ID=' || p_DocType_ID || ']' ;
  RETURN;
END IF;
-- If AD_Sequence_Org exist: Get sequence from there
select count(*) into v_count from C_DocType d, AD_Sequence_org s
    WHERE d.C_DocType_ID=p_DocType_ID and d.DocNoSequence_ID=s.AD_Sequence_id 
          AND s.IsActive='Y'  AND s.IsTableID='N'  AND s.IsAutoSequence='Y' and s.ad_org_id=p_ad_org_id;

if v_count>0 then
        -- Get the numbers
        SELECT s.AD_Sequence_ID, s.CurrentNext, s.Prefix, s.Suffix,(select tablename from ad_table where ad_table_id=d.ad_table_id) as tablename
        INTO v_Sequence_ID, v_NextNo, v_Prefix, v_Suffix,v_table
        FROM  C_DocType d , AD_Sequence_org s 
        WHERE d.C_DocType_ID=p_DocType_Id 
          AND d.DocNoSequence_ID=s.AD_Sequence_ID  AND s.IsActive='Y'  AND s.IsTableID='N'  AND s.IsAutoSequence='Y' AND s.ad_org_id=p_ad_org_id; 
        IF p_Update_Next='Y' THEN
          UPDATE AD_Sequence_org s
            SET CurrentNext=CurrentNext + IncrementNo
          WHERE AD_Sequence_ID=v_Sequence_ID  AND s.IsActive='Y'  AND s.IsTableID='N'  AND s.IsAutoSequence='Y' AND s.ad_org_id=p_ad_org_id;
        END IF;
else
      -- Get the numbers
      SELECT s.AD_Sequence_ID, s.CurrentNext, s.Prefix, s.Suffix,(select tablename from ad_table where ad_table_id=d.ad_table_id) as tablename
      INTO v_Sequence_ID, v_NextNo, v_Prefix, v_Suffix,v_table
      FROM C_DocType d , AD_Sequence s
      WHERE d.C_DocType_ID=p_DocType_ID
        AND d.DocNoSequence_ID=s.AD_Sequence_ID  AND s.IsActive='Y'  AND s.IsTableID='N'  AND s.IsAutoSequence='Y'; --OBTG: OF CurrentNext--

        IF p_Update_Next='Y' THEN
          UPDATE AD_Sequence
            SET CurrentNext=CurrentNext + IncrementNo
          WHERE AD_Sequence_ID=v_Sequence_ID;
        END IF;
end if;
  -- Determin, if Docno exists
  if v_table is not null and p_update_next='Y' then
    BEGIN
        v_sql:='select count(*) as isexits from '||v_table||' where documentno='||chr(39)||COALESCE(v_Prefix, '') || v_NextNo || COALESCE(v_Suffix, '')||chr(39);
        OPEN v_cursor FOR EXECUTE v_sql;
        LOOP
            FETCH v_cursor INTO v_cur;
            EXIT WHEN NOT FOUND;
            if v_cur.isexits>0 then
                -- Recursive call till Free Docno Found.
                select * into p_DocumentNo FROM Ad_Sequence_Doctype(p_doctype_id, p_ad_org_id ,'Y') ;
            else
                p_DocumentNo:=COALESCE(v_Prefix, '') || v_NextNo || COALESCE(v_Suffix, '') ;
            end if;
        END LOOP;
    EXCEPTION
    WHEN OTHERS THEN
        p_DocumentNo:=COALESCE(v_Prefix, '') || v_NextNo || COALESCE(v_Suffix, '');
    END;
  else
    p_DocumentNo:=COALESCE(v_Prefix, '') || v_NextNo || COALESCE(v_Suffix, '') ;
  end if;
EXCEPTION
WHEN DATA_EXCEPTION THEN
  RAISE EXCEPTION '%', '@DocumentTypeSequenceNotFound@' ; --OBTG:-20000--
END ; $_$;

select zsse_DropFunction ('ad_sequence_doc');

CREATE OR REPLACE FUNCTION ad_sequence_doc(p_sequencename character varying, p_ad_org_id character varying, p_update_next character, OUT p_documentno character varying) RETURNS character varying
    LANGUAGE plpgsql
    AS $_$ DECLARE 
/*************************************************************************
  * The contents of this file are subject to the Compiere Public
  * License 1.1 ("License"); You may not use this file except in
  * compliance with the License. You may obtain a copy of the License in
  * the legal folder of your Openbravo installation.
  * Software distributed under the License is distributed on an
  * "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
  * implied. See the License for the specific language governing rights
  * and limitations under the License.
  * The Original Code is  Compiere  ERP &  Business Solution
  * The Initial Developer of the Original Code is Jorg Janke and ComPiere, Inc.
  * Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke,
  * parts created by ComPiere are Copyright (C) ComPiere, Inc.;
  * All Rights Reserved.
  * Contributor(s): Openbravo SL
  * Contributions are Copyright (C) 2001-2009 Openbravo, S.L.
  * Contributor(s): Stefan Zimmermann, 2012, sz@zimmermann-software.de (SZ) Contributions are Copyright (C) 2012 Stefan Zimmermann
  *
  * Specifically, this derivative work is based upon the following Compiere
  * file and version.
  *************************************************************************
  * $Id: AD_Sequence_Doc.sql,v 1.6 2003/08/06 06:51:26 jjanke Exp $
  ***
  * Title: Get the next DocumentNo of TableName
  * Description:
  *  store in parameter p_DocumentNo
  *  if ID < 1000000, use System Doc Sequence
  ************************************************************************/
  v_NextNo VARCHAR(32); --OBTG:VARCHAR2--
  v_NextNoSys NUMERIC;
  v_Prefix VARCHAR(30) ; --OBTG:VARCHAR2--
  v_Suffix VARCHAR(30) ; --OBTG:VARCHAR2--
  v_count numeric;
  v_table varchar;
  v_sql character varying;
  TYPE_Ref REFCURSOR;
  v_cursor TYPE_Ref%TYPE;
  v_cur RECORD;
BEGIN
  -- If AD_Sequence_Org exist: Get sequence from there
  select count(*) into v_count from AD_Sequence_org s
    WHERE Name=p_SequenceName  AND IsActive='Y'  AND IsTableID='N'  AND IsAutoSequence='Y'  and s.ad_org_id=p_ad_org_id;
  
  if v_count>0 then
        SELECT CurrentNext, Prefix, Suffix,substr(name,12) as tablename
        INTO v_NextNo, v_Prefix, v_Suffix,v_table
        FROM AD_Sequence_org
        WHERE Name=p_SequenceName  AND IsActive='Y'  AND IsTableID='N'  AND IsAutoSequence='Y'  AND AD_org_ID=p_ad_org_id ; --OBTG: OF CurrentNext--

        IF p_Update_Next='Y' THEN
          UPDATE AD_Sequence_org
            SET CurrentNext=CurrentNext + IncrementNo, Updated=TO_DATE(NOW())
          WHERE Name=p_SequenceName;
        END IF;
  else
      SELECT CurrentNext, Prefix, Suffix,substr(name,12) as tablename
        INTO v_NextNo, v_Prefix, v_Suffix,v_table
        FROM AD_Sequence
        WHERE Name=p_SequenceName  AND IsActive='Y'  AND IsTableID='N'  AND IsAutoSequence='Y' ; --OBTG: OF CurrentNext--

        IF p_Update_Next='Y' THEN
          UPDATE AD_Sequence
            SET CurrentNext=CurrentNext + IncrementNo, Updated=TO_DATE(NOW())
          WHERE Name=p_SequenceName;
        END IF;
  end if;
  -- Determin, if Docno exists
  if instr(lower(p_sequencename),'documentno_')>0 and p_update_next='Y' then
    BEGIN
        v_sql:='select count(*) as isexits from '||v_table||' where documentno='||chr(39)||COALESCE(v_Prefix, '') || v_NextNo || COALESCE(v_Suffix, '')||chr(39);
        raise notice '%', v_sql;
        OPEN v_cursor FOR EXECUTE v_sql;
        LOOP
            FETCH v_cursor INTO v_cur;
            EXIT WHEN NOT FOUND;
            if v_cur.isexits>0 then
                -- Recursive call till Free Docno Found.
                select * into p_DocumentNo FROM ad_sequence_doc(p_sequencename, p_ad_org_id , 'Y') ;
            else
                p_DocumentNo:=COALESCE(v_Prefix, '') || v_NextNo || COALESCE(v_Suffix, '') ;
            end if;
        END LOOP;
    EXCEPTION
    WHEN OTHERS THEN
        p_DocumentNo:=COALESCE(v_Prefix, '') || v_NextNo || COALESCE(v_Suffix, '');
    END;
  else
    p_DocumentNo:=COALESCE(v_Prefix, '') || v_NextNo || COALESCE(v_Suffix, '') ;
  end if;

EXCEPTION
WHEN DATA_EXCEPTION THEN
  RAISE EXCEPTION '%', '@DocumentSequenceNotFound@' || p_SequenceName ; --OBTG:-20000--
END ; $_$;


/*****************************************************+



General Support and Utility Functions




*****************************************************/

CREATE or replace FUNCTION zsse_getmainfrompopup( p_key character varying, p_columnid character varying, p_desturl character varying, p_name character varying) returns character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Danny Heuduk_____________________________.
***************************************************************************************************************************************************
Execute individual Statements for the Custom Instance
*****************************************************/

BEGIN
 
  RETURN '<a href="#" onclick="getmainfrompopup('||chr(39)||p_key||chr(39)||',' ||chr(39)||p_columnid||chr(39)||',' ||chr(39)||p_desturl||chr(39)||');return false;" class="LabelLink">'||p_name||'</a>';
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;


CREATE or replace FUNCTION zsse_htmldirectlink(p_targetwindowurl character varying,p_fieldid character varying,p_key character varying,p_text character varying) returns character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Execute individual Statements for the Custom Instance
*****************************************************/

BEGIN 
  
  RETURN '<a href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||','||p_fieldid||','||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink">'||p_text||' </a>';
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE or replace FUNCTION zsse_htmlLinkDirectKey(p_targetwindowurl character varying,p_key character varying,p_text character varying) returns character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Execute individual Statements for the Custom Instance
*****************************************************/

BEGIN 
  
  RETURN '<a href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||',document.frmMain.inpDirectKey,'||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink">'||p_text||' </a>';
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE or replace FUNCTION zsse_htmlLinkDirectKey_notblue_short(p_targetwindowurl character varying,p_key character varying,p_text character varying,p_color varchar) returns character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Execute individual Statements for the Custom Instance
*****************************************************/

BEGIN 
  
  --RETURN '<a title="'||zssi_2html(p_text)||'" href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||',document.frmMain.inpDirectKey,'||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink_white">'||p_text||' </a>';

if p_color='white' then
    RETURN '<a title="'||zssi_2html(p_text)||'" href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||',document.frmMain.inpDirectKey,'||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink_white">'||'&nbsp;'||p_text||' </a>';
else
    RETURN '<a title="'||zssi_2html(p_text)||'" href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||',document.frmMain.inpDirectKey,'||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink_black">'||'&nbsp;'||p_text||' </a>';
end if;
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
CREATE or replace FUNCTION zsse_htmlLinkDirectKey_notblue(p_targetwindowurl character varying,p_key character varying,p_text character varying,p_color varchar) returns character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Execute individual Statements for the Custom Instance
*****************************************************/

BEGIN 
  
  --RETURN '<a title="'||zssi_2html(p_text)||'" href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||',document.frmMain.inpDirectKey,'||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink_white">'||p_text||' </a>';

if p_color='white' then
    RETURN '<a title="'||zssi_2html(p_text)||'" href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||',document.frmMain.inpDirectKey,'||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink_white">'||rpad(p_text,16,'')||' </a>';
else
    RETURN '<a title="'||zssi_2html(p_text)||'" href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||',document.frmMain.inpDirectKey,'||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink_black">'||rpad(p_text,16,'')||' </a>';
end if;
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE or replace FUNCTION zsse_htmlLinkDirectKeyGridView(p_targetwindowurl character varying,p_key character varying,p_text character varying) returns character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Execute individual Statements for the Custom Instance
*****************************************************/

BEGIN 
  
  RETURN '<a href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECTRELATION'||chr(39)||',document.frmMain.inpDirectKey,'||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink">'||p_text||' </a>';
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE or replace FUNCTION zsse_htmldirectlinkWithDummyField(p_targetwindowurl character varying,p_fieldid character varying,p_key character varying,p_text character varying) returns character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Execute individual Statements for the Custom Instance
*****************************************************/

BEGIN 
  
  RETURN '<INPUT type="hidden" name="'||p_fieldid||'"></INPUT><a href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||',document.frmMain.'||p_fieldid||','||chr(39)||p_key||chr(39)||', false, document.frmMain, '||chr(39)||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink">'||p_text||' </a>';
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zsse_addattachmentfile(p_table_id character varying, p_record_id character varying, p_user character varying, p_client character varying,p_org character varying,p_name character varying , p_text character varying) RETURNS character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Copy a Product - File Entrys in C_File
*****************************************************/

v_seq numeric;
BEGIN 
    select coalesce(max(SEQNO)+10,10) into v_seq from c_file where AD_TABLE_ID=p_table_id and AD_RECORD_ID=p_record_id;
          insert into c_file (C_FILE_ID, AD_CLIENT_ID, AD_ORG_ID,   CREATEDBY, UPDATEDBY, NAME, C_DATATYPE_ID, SEQNO, TEXT, AD_TABLE_ID, AD_RECORD_ID)
                 values(get_uuid(),p_CLIENT,p_ORG, p_user,p_user,p_name,'103', v_seq, p_TEXT, p_table_id,p_record_id);

    return 'SUCCESS';
EXCEPTION
    WHEN OTHERS then
       return SQLERRM;        
END;
$_$  LANGUAGE 'plpgsql';

/*****************************************************+



General Service Fubnctions




*****************************************************/



CREATE or replace FUNCTION zsse_instancesqlexecute(p_setoriginal character varying) returns character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Execute individual Statements for the Custom Instance
*****************************************************/
 v_cur RECORD;
 v_name character varying;
BEGIN 
  select name into v_name from ad_client where ad_client_id='C726FEC915A54A0995C568555DA5BB3C';
  RAISE NOTICE '%', 'Setting '||case when p_setoriginal='Y' then 'default' else 'Instance specific' end ||' customizing for Client '||v_name; 
  for v_cur in (select * from zsse_executeondeploy where isstandard=p_setoriginal order by seqno)
  LOOP
     EXECUTE v_cur.sqlstmt;
     RAISE NOTICE '%', v_cur.sqlstmt;
  END LOOP;
  RAISE NOTICE '%', 'Execute finished for Client '||v_name; 
  RETURN 'Instance-Specific SQL-Statements Executed.';
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
   

CREATE OR REPLACE FUNCTION zsse_logclean() 
RETURNS VARCHAR
AS $_$
DECLARE
/*****************************************************+
Stefan Zimmermann, 01/2011, sz@zimmermann-software.de
Cleans the Scheduler LOG periodically 
*****************************************************/
-- SELECT zsse_logclean();
  v_message character varying;
  i integer;
BEGIN 
   DELETE FROM ad_note WHERE created < now()-7;
   GET DIAGNOSTICS i := ROW_COUNT; 
   v_message := i || ' Process Notes deleted. - ';
   
   DELETE FROM ad_process_run WHERE (created < now()-30) AND (status='SUC');
   GET DIAGNOSTICS i := ROW_COUNT; 
   v_message := v_message || i || ' Process Runs deleted. - ';
   
   DELETE FROM ad_session sess WHERE (created < now()-5) AND (sess.session_active = 'N');
   GET DIAGNOSTICS i := ROW_COUNT; 
   v_message := v_message || i || ' Session-LOGs deleted';
   
    -- Finishing
   v_message := 'LogClean successful finished:' || v_message;
   RETURN v_message;
END;
$_$ LANGUAGE 'plpgsql';


CREATE or replace FUNCTION zsse_checkbansecure(p_ad_user_id character varying) RETURNS character varying
AS $_$
DECLARE
/*****************************************************+
Stefan Zimmermann, 04/2011, sz@zimmermann-software.de
Security Login Function
Bans a User for 10 minutes , if there where three 
failed Login Tries
*****************************************************/
-- Simple Types
v_message character varying;
v_count numeric;
BEGIN 
   select count(*) into v_count from ZSSE_SECURELOGIN where ad_user_id=p_ad_user_id and created > (now() - INTERVAL '10 minutes');
   if v_count>2 then
        RETURN 'BANNED';
   else
        RETURN 'OK';
   end if;
END;
$_$  LANGUAGE 'plpgsql';    

CREATE or replace FUNCTION zsse_failedlogin(p_ad_user_id character varying) RETURNS character varying
AS $_$
DECLARE
/*****************************************************+
Stefan Zimmermann, 04/2011, sz@zimmermann-software.de
Security Login Function
Records a Failed Login Try
*****************************************************/
BEGIN 
   if p_ad_user_id is not null then
        insert into ZSSE_SECURELOGIN(ZSSE_SECURELOGIN_ID, AD_CLIENT_ID, AD_ORG_ID, CREATEDBY, UPDATEDBY, AD_USER_ID)
                         VALUES(get_uuid(),'0','0','0','0',p_ad_user_id);
   end if;
   return 'OK';
END;
$_$  LANGUAGE 'plpgsql';   
 

CREATE or replace FUNCTION zsse_schedule(p_processname character varying,p_frequence character varying, p_value numeric, p_start timestamp with time zone,p_delete character varying) RETURNS character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Scheduling of Processes
 p_frequence : 1 sec, 2 min, 3 h, 4 days
 p_value: Multiplier. e.g. p_frequence =3, p_value=5 => Every 5 hours
 p_start: Start-Time
 p_delete: If Y then do only delete the Process-Scheduling
*****************************************************/
-- Simple Types
v_proc_id character varying;
v_count numeric;
v_start  timestamp with time zone;
v_startdate  timestamp with time zone;
v_last  timestamp with time zone;
v_message character varying;
v_timestr character varying;
v_interval   character varying;
BEGIN 
    v_start:=coalesce(p_start,now()+0.001);
    if p_frequence not in ('1','2','3','4') or p_value <=0 then
        RAISE EXCEPTION '%', 'Parameter Error';
    end if;
    select count(*) into v_count from ad_process where value=p_processname;
    if v_count!=1 then
         RAISE EXCEPTION '%', 'Cannot schedule process. Process-count is: '||v_count;
    end if;
    select  case p_frequence when '1' then 'seconds' when '2' then 'minutes' when '3' then 'hours' when '4' then 'days' end into v_interval;
    while v_start<now() 
    LOOP
       v_start:=v_start+to_interval(p_value::integer, v_interval);
    END LOOP;
    -- Get Time from Timestamp (Ugly! I did not find a Postgres-Function...)
    select '0001-01-01 '||substr(to_char(extract(hour from v_start),'00'),2,2)||':'||substr(to_char(extract(minute from v_start),'00'),2,2)||':'||substr(to_char(extract(second from v_start),'00'),2,2)||' BC' into v_timestr;
    v_last:=v_start - to_interval(p_value::integer, v_interval);
    select ad_process_id into v_proc_id from ad_process where value=p_processname;
    select count(*) into v_count from ad_process_request where ad_process_id=v_proc_id and status='PRC';
    if v_count>0 then
          RAISE EXCEPTION '%', 'Cannot schedule process '||v_proc_id||' is Currently RUNNING!!!!!!!!!!!! ';
    end if;
    if coalesce(p_delete,'N')='Y' then
       delete from ad_process_request where AD_PROCESS_ID=v_proc_id and status in ('SCH','SUC','UNS','MIS');
       v_message:='Scheduling of '||p_processname||' deleted.';
    else
        delete from ad_process_request where AD_PROCESS_ID=v_proc_id and status in ('SCH','SUC','UNS','MIS');
        insert into ad_process_request(AD_PROCESS_REQUEST_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY,
                               OB_CONTEXT, 
                               AD_PROCESS_ID, AD_USER_ID, ISROLESECURITY,STATUS, 
                               NEXT_FIRE_TIME, PREVIOUS_FIRE_TIME,start_time,start_date,CHANNEL,TIMING_OPTION, 
                               FREQUENCY,secondly_interval, MINUTELY_INTERVAL, hourly_interval,daily_interval,
                               DAY_MON, DAY_TUE, DAY_WED, DAY_THU, DAY_FRI, DAY_SAT, DAY_SUN,
                               MONTHLY_OPTION, FINISHES, DAILY_OPTION, SCHEDULE, RESCHEDULE, UNSCHEDULE)
        values(get_uuid(),'C726FEC915A54A0995C568555DA5BB3C','0','Y',now(),'100',now(),'100',
                      '{"org.openbravo.scheduling.ProcessContext":{"user":100,"role":0,"language":"de_DE","theme":"ltr'||chr(92)||'/Default","client":0,"organization":0,"warehouse":"","command":"DEFAULT","userClient":"","userOrganization":"","dbSessionID":"","javaDateFormat":"","jsDateFormat":"","sqlDateFormat":"","accessLevel":"","roleSecurity":true}}',
                       v_proc_id,'100','Y','SCH',
                       null,null,to_timestamp(v_timestr,'yyyy-dd-mm hh24:mi:ss BC'),trunc(v_start),'Process Scheduler','S',
                       p_frequence,case p_frequence when '1' then p_value end,case p_frequence when '2' then p_value end,case p_frequence when '3' then p_value end,case p_frequence when '4' then p_value end,
                      'N','N','N','N','N','N','N',
                      'S','N','N','N','N','N');
        v_message:='Scheduling of '||p_processname||' sucessfully finished.';
     end if;     
    return v_message;
END;
$_$  LANGUAGE 'plpgsql';


SELECT zsse_droptrigger('ad_process_request_mod_trg', 'ad_process_request');

CREATE OR REPLACE FUNCTION public.ad_process_request_mod_trg ()
RETURNS TRIGGER AS
$body$
-- MH: implemented with Version 2.6.62.063
DECLARE
-- v_fieldCaption ad_field.name%TYPE := '' ;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;
  END IF;

  IF (TG_OP = 'INSERT') THEN
    IF upper(new.channel)=UPPER('Process Scheduler') and ((SELECT COUNT(*) FROM ad_process_request req WHERE UPPER(req.channel) = UPPER('Process Scheduler') AND req.ad_process_id = new.ad_process_id) >=1) THEN
   -- v_fieldCaption := COALESCE((SELECT ad_getfieldtext('573D4A317DC3FFC9E040007F01012790', 'de_DE')),''); -- toDo: get language
      RAISE EXCEPTION '%','@SaveErrorNotUnique@'; -- || '''' || v_fieldCaption || '''';
    END IF;
  END IF;
  IF (TG_OP = 'UPDATE') THEN
    IF (old.ad_process_id != new.ad_process_id) THEN
   -- v_fieldCaption := COALESCE((SELECT ad_getfieldtext('573D4A317DC3FFC9E040007F01012790', 'de_DE')),''); -- toDo: get language
      RAISE EXCEPTION '%','@SaveErrorNotUnique@'; -- || '''' || v_fieldCaption || '''';
    END IF;
  END IF;
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW;
  END IF;
END;
$body$
LANGUAGE 'plpgsql';

CREATE TRIGGER ad_process_request_mod_trg
  BEFORE INSERT OR UPDATE OR DELETE
  ON ad_process_request FOR EACH ROW
  EXECUTE PROCEDURE ad_process_request_mod_trg();


CREATE OR REPLACE FUNCTION ad_treenode_mod_trg()
  RETURNS trigger AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
******************************************************************************************************************************************************************************************************************************+
Stefan Zimmermann, 2011, sz@zimmermann-software.de
Implements Actions on different Trees
*****************************************************************************/
BEGIN
  IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
  END IF;
  IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; 
  END IF; 
END; $BODY$
  LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION c_orgconfiguration_trg() RETURNS trigger
LANGUAGE plpgsql
AS $_$ DECLARE 

/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of CORE
Prevents deletion of Main DOCTYPES
*****************************************************/
        
BEGIN
    
    IF AD_isTriggerEnabled()='N' THEN IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; END IF;
    update ad_preference set value=new.createprojectfromso where attribute=upper('createprojectfromso');
    update ad_preference set value=new.closeprojectfromso where attribute=upper('closeprojectfromso');
    update ad_preference set value=new.reinvoiceprojectexpenses where attribute=upper('reinvoiceprojectexpenses');
    update ad_preference set value=new.prapprovalworkflow where attribute=upper('prapprovalworkflow');
    update ad_preference set value=new.productvaluereadonly where attribute=upper('productvaluereadonly');
    update ad_preference set value=new.bpartnervaluereadonly where attribute=upper('bpartnervaluereadonly');
    update ad_preference set value=new.docnoreadonly where attribute=upper('docnoreadonly');
    update ad_preference set value=new.projectvaluereadonly where attribute=upper('projectvaluereadonly');
    update ad_preference set value=new.refreshintervall where attribute=upper('refreshinterval');
                                                                              
-- Updating
IF TG_OP = 'DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF; 
END ; $_$;

DROP TRIGGER c_orgconfiguration_trg ON c_orgconfiguration;

CREATE TRIGGER c_orgconfiguration_trg
  AFTER INSERT or UPDATE
  ON c_orgconfiguration
  FOR EACH ROW
  EXECUTE PROCEDURE c_orgconfiguration_trg();

/*****************************************************+
Stefan Zimmermann, 2011, stefan@zimmermann-software.de



   General Configuration Options





*****************************************************/



CREATE OR REPLACE FUNCTION c_orgconfigurationbef_trg() RETURNS trigger 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers
***************************************************************************************************************************************************
Part of Smartprefs
Business Partner - On Insert. Only one user on employees and undefined partner
*****************************************************/
DECLARE 
v_count          numeric;
BEGIN
  IF AD_isTriggerEnabled()='N' THEN  RETURN NEW; END IF; 
  select count(*) into v_count from c_orgconfiguration where c_orgconfiguration.ad_org_id=new.ad_org_id;
  if v_count > 0  then
      RAISE EXCEPTION '%', '@zssi_OnlyOneDS@';
  end if;
  RETURN NEW;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION c_orgconfigurationbef_trg() OWNER TO tad;

drop trigger c_orgconfigurationbef_trg on c_orgconfiguration;

CREATE TRIGGER c_orgconfigurationbef_trg
  BEFORE INSERT
  ON c_orgconfiguration
  FOR EACH ROW
  EXECUTE PROCEDURE c_orgconfigurationbef_trg();


CREATE or replace FUNCTION c_getconfigoption(p_option character varying, p_org character varying) RETURNS character
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
******************************************************************************************************************************************************************************************************************************+
Stefan Zimmermann, 04/2011, sz@zimmermann-software.de
Check if Database - Dump is created out of an opensource instance
If ORG-ID exists, there may be customer-Data - Giva warning in that case
*****************************************************************************/
v_sql character varying;
TYPE_Ref REFCURSOR;
v_cursor TYPE_Ref%TYPE;
v_cur RECORD;
v_return character;
BEGIN 

      v_sql:='select '||p_option||' as retval from c_orgconfiguration where isactive='||chr(39)||'Y'||chr(39)||' and ad_org_id='||chr(39)||coalesce(p_org,'0')||chr(39);
      OPEN v_cursor FOR EXECUTE v_sql;
      LOOP
            FETCH v_cursor INTO v_cur;
            EXIT WHEN NOT FOUND;
            v_return:=v_cur.retval;
      END LOOP;
      close v_cursor;
      if v_return is null then
         v_sql:='select '||p_option||' as retval from c_orgconfiguration where isactive='||chr(39)||'Y'||chr(39)||' and isstandard='||chr(39)||'Y'||chr(39);
         OPEN v_cursor FOR EXECUTE v_sql;
         LOOP
                  FETCH v_cursor INTO v_cur;
                  EXIT WHEN NOT FOUND;
                  v_return:=v_cur.retval;
         END LOOP;
         close v_cursor;
      end if;
      if v_return is null then
         select substr(column_default,2,1) into v_return from information_schema.columns where lower(table_name)='c_orgconfiguration' and lower(column_name)=p_option;
      end if;
      return v_return;
END;
$_$  LANGUAGE 'plpgsql';    



/*****************************************************+
Stefan Zimmermann, 2011, stefan@zimmermann-software.de









   General Auxilliary Functions





*****************************************************/

CREATE or replace FUNCTION zssi_getLastDayOfQuarter(p_startdate timestamp,p_quarter varchar) RETURNS timestamp
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
**************************************************************************************************************************************************

Gives Back the Last Day in a Quarter Beginning from Startdate

p_quarter = 1Q : Last day in the 1st Quarter from startdate
p_quarter = 2Q
p_quarter = 3Q
p_quarter = 4Q: Last day in the fourth Quarter from startdate

*/
v_interval interval:=0;
v_enddate timestamp;
BEGIN 
   if p_quarter='2Q' then v_interval:= INTERVAL '3 month'; elsif p_quarter='3Q' then v_interval:= INTERVAL '6 month'; elsif p_quarter='4Q' then v_interval:= INTERVAL '9 month'; end if;
   v_enddate:=p_startdate + INTERVAL '3 month' + v_interval - INTERVAL '1 day';
   return v_enddate;
END; $_$  LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION zssi_isdateinrange(p_datetocheck timestamp with time zone, p_fromdate timestamp with time zone, p_todate timestamp with time zone)
  RETURNS character varying AS
$BODY$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************/

  BEGIN
    
    IF((p_datetocheck <= p_todate) AND (p_datetocheck >= p_fromdate)) THEN
      RETURN 'Y';
    END IF;
	RETURN 'N';
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_isdateinrange(timestamp with time zone, timestamp with time zone, timestamp with time zone) OWNER TO tad;


  
  create or replace function last_dayofmonth(p_date timestamp without time zone)
  returns timestamp without time zone as
  $_$ 
  /***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Danny A. Heuduk.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Generating PurchaseOrder as Link
*****************************************************/
  
  DECLARE
  v_return date;
  BEGIN
  v_return := (select (date_trunc('month', p_date + '1 month'::interval) - '1day'::interval)::timestamp without time zone);
  RETURN v_return;
  END;
  $_$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION public.isEmpty (
  p_variable VARCHAR
)
RETURNS BOOLEAN AS
$BODY$
BEGIN
  RETURN ( (p_variable IS NULL) OR (LENGTH(p_variable) = 0) );
END;
$BODY$
LANGUAGE 'plpgsql' VOLATILE
COST 100;


CREATE or replace FUNCTION zsse_checkopensourceinstance() RETURNS character varying
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
******************************************************************************************************************************************************************************************************************************+
Stefan Zimmermann, 04/2011, sz@zimmermann-software.de
Check if Database - Dump is created out of an opensource instance
If ORG-ID exists, there may be customer-Data - Giva warning in that case
*****************************************************************************/
v_count1 numeric;
v_count2 numeric;
BEGIN 
   select count(*) into v_count1 from ad_org;
   select count(*) into v_count2 from ad_module where iscommercial='Y';
   if v_count1>1 or  v_count2 >0 then
         RAISE EXCEPTION '%', 'WARNING!!!!!!!!     THIS IS NO OPEN SOURCE INSTANCE   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!THIS IS NO OPEN SOURCE INSTANCE  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!THIS IS NO OPEN SOURCE INSTANCE  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!';
         RETURN 'NO OPENSOURCE INSTANCE   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!';
   else
        delete from ad_module_sql;
        RETURN 'OK';
   end if;
END;
$_$  LANGUAGE 'plpgsql';    


select zsse_DropView ('ad_systemupdateview');

CREATE VIEW ad_systemupdateview AS 
 select '0'::text as ad_systemupdateview_id,'Y'::character(1) as isactive, '0'::text as ad_org_id,'0'::text as ad_client_id, '0'::text as createdby, now() as created, now() as updated, '0'::text as updatedby,
        count(*)-2::numeric as namedusers, (select ad_org_id from ad_org where created=(select min(created) from ad_org where ad_org_id!='0')) as systemid,
        (select version_label from ad_module where ad_module_id='0') as version  
        from ad_user a where  a.password is not null and a.isactive ='Y'
        and exists (select 0 from ad_user_roles r where r.ad_user_id=a.ad_user_id);


/*****************************************************+
Stefan Zimmermann, 2011, stefan@zimmermann-software.de









   Auxilliary Data Retrieval Functions Functions
   For Use in Querys





*****************************************************/



CREATE OR REPLACE FUNCTION zsse_CopyAttachmentFile(
  p_source_id  VARCHAR,
  p_target_id  VARCHAR,
  p_user       VARCHAR
) RETURNS VARCHAR
AS $zs$
-- called from java-class (no ad_pinstance): CopyOrderTemplateAttService.java
DECLARE
  v_message  VARCHAR := '';
  v_count    NUMERIC := 0;
  v_c_file   c_file%ROWTYPE;
BEGIN  -- 2012-06-21

  FOR v_c_file IN (
    SELECT * FROM c_file  WHERE ad_record_id = p_source_id ORDER BY seqno
  )
  LOOP
    v_c_file.c_file_id = get_uuid();
    v_c_file.created = NOW();
    v_c_file.createdby = p_user;
    v_c_file.updated = NOW();
    v_c_file.updatedby = p_user;
    v_c_file.ad_record_id = p_target_id;
    INSERT INTO c_file VALUES (v_c_file.*);
    v_count := (v_count + 1);
  END LOOP;
  v_message = '@zsse_CopyAttachmentFile_RecordsCopied@' || ' ' || v_count || ' ' || COALESCE(p_source_id,'') ; -- 'Anzahl kopierter Datens..:'
  RETURN '@SUCCESS@' || ' ' || v_message; -- check structure for return in process class for sqlresult.splitt(" ")
EXCEPTION
  WHEN OTHERS THEN
    v_message := '@ProcessRunError@' || ' ' || SQLERRM || ' ' || 'zsse_CopyAttachmentFile';
    RAISE NOTICE '%s', v_message;
    RETURN v_message;
END;
$zs$
LANGUAGE 'plpgsql';


CREATE or replace FUNCTION ad_updateAlertRule(p_alertrule varchar) RETURNS varchar
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
**************************************************************************************************************************************************
*/

BEGIN 
-- Yet only Debt Payment Approval is updated.
--- @TODO@ Implement Alert-Rule (After rearranging Alertz-Servlet!) - parametr doen't work yet...
      --   if p_alertrule='08ECB61212BC4324AE1B43D40708383C' then
                  update ad_alert set description= 'Zahlung für Dokumentnummer: '||i.documentno||'<br>Betrag: '||i.grandtotal||'<br>Lieferant: '||
                                                    (select name from c_bpartner where i.c_bpartner_id=c_bpartner.c_bpartner_id)||
                                                    '<br>Überweisung von: '||dp.amount||' '||cc.cursymbol||'<br>Geplant am: '||
                                                    zssi_strDate(coalesce(i.schedtransactiondate,i.dateinvoiced),'de_DE')||'<br>'||
                                                    zssi_getinvdoc_link(i.c_invoice_id,'Rechnung - '||i.documentno)
                                                    ||'<br>'||'Genehmigt am:'||zssi_strDate(dp.updated,'de_DE')||' durch '||zssi_getusernamecomplete(dp.updatedby,'de_DE')
                  from c_invoice i,C_DEBT_PAYMENT dp,c_currency cc where    DP.C_INVOICE_ID = I.C_INVOICE_ID
                        and cc.c_currency_id=i.c_currency_id
                        AND DP.IsActive='Y'
                        AND DP.IsValid='Y'
                        AND DP.isapproved ='Y'
                        ANd i.issotrx='N'
                        and ad_alert.referencekey_id=i.c_invoice_id 
                        and ad_alert.ad_alertrule_id='08ECB61212BC4324AE1B43D40708383C'
                        and C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.ISPAID, DP.ISVALID, DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID) = 'P';
        --  end if;
            return 'OK';
END; $_$  LANGUAGE 'plpgsql';



CREATE or replace FUNCTION ad_RoleAccessOnlyOwnData(p_roleId varchar, p_windowID varchar) RETURNS varchar
AS $_$
DECLARE
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2013 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
**************************************************************************************************************************************************

Determine if this Role in This Window can see only its own data..

*/
v_return varchar;
BEGIN 
    select seesonlyowndata into v_return from ad_window_access where ad_role_id=p_roleId and ad_window_id=p_windowID;
    return coalesce(v_return,'N');
END; $_$  LANGUAGE 'plpgsql';


  
  
CREATE OR REPLACE FUNCTION c_getDefaultDocInfo(p_tablename character varying, p_idvalue character varying,OUT ad_org_id character varying, OUT  document_id character varying, OUT docstatus  character varying,OUT   docTypeTargetId  character varying, OUT  ourreference  character varying, OUT  cusreference  character varying, OUT  bpartner_id  character varying, OUT  bpartner_language  character varying, OUT  unique_timestamp  character varying, OUT  bpartner_name  character varying, OUT  orga  character varying, OUT  docname  character varying)
  RETURNS setof record AS
$BODY$ 
DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
 
 Default Doc-Info Used in Print-Controller
 
*****************************************************/
v_doctypeid varchar;

BEGIN
if p_tablename='C_PROJECT' then
    select c_doctype_id into v_doctypeid from c_doctype where name = 'Project';
    select p.ad_org_id,p_idvalue,'CO',v_doctypeid,p.name,p.poreference,p.c_bpartner_id,
           (select ad_language from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id) , 
           to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS'), 
           (select name from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id),
           zssi_juwiorgshortcut(p.ad_org_id),
           zssi_docshortcut(v_doctypeid)
    into ad_org_id,document_id,docstatus,docTypeTargetId,ourreference,cusreference,bpartner_id,bpartner_language,unique_timestamp,bpartner_name,orga,docname
    from c_project p where c_project_id=p_idvalue;
elsif p_tablename='C_PROJECTTASK' then
    select c_doctype_id into v_doctypeid from c_doctype where name = 'Projecttask';
    select p.ad_org_id,p_idvalue,'CO',v_doctypeid,p.name,p.poreference,p.c_bpartner_id,
           (select ad_language from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id) , 
           to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS'), 
           (select name from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id),
           zssi_juwiorgshortcut(p.ad_org_id),
           zssi_docshortcut(v_doctypeid)
    into ad_org_id,document_id,docstatus,docTypeTargetId,ourreference,cusreference,bpartner_id,bpartner_language,unique_timestamp,bpartner_name,orga,docname
    from c_project p, c_projecttask pt where pt.c_project_id=p.c_project_id and pt.c_projecttask_id=p_idvalue;
elsif p_tablename='ZSSM_WORKSTEP_V' then
    select c_doctype_id into v_doctypeid from c_doctype where name = 'Workstep';
    select p.ad_org_id,p_idvalue,'CO',v_doctypeid,p.name,p.poreference,p.c_bpartner_id,
           (select ad_language from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id) , 
           to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS'), 
           (select name from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id),
           zssi_juwiorgshortcut(p.ad_org_id),
           zssi_docshortcut(v_doctypeid)
    into ad_org_id,document_id,docstatus,docTypeTargetId,ourreference,cusreference,bpartner_id,bpartner_language,unique_timestamp,bpartner_name,orga,docname
    from c_project p, c_projecttask pt where pt.c_project_id=p.c_project_id and pt.c_projecttask_id=p_idvalue;
elsif p_tablename='C_BPARTNEREMPLOYEE_VIEW' then
    select c_doctype_id into v_doctypeid from c_doctype where name = 'Employee';
    select p.ad_org_id,p_idvalue,'CO',v_doctypeid,p.name,'',p.c_bpartner_id,p.ad_language, 
           to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS'), 
           p.name,
           zssi_juwiorgshortcut(p.ad_org_id),
           zssi_docshortcut(v_doctypeid)
    into ad_org_id,document_id,docstatus,docTypeTargetId,ourreference,cusreference,bpartner_id,bpartner_language,unique_timestamp,bpartner_name,orga,docname
    from C_BPARTNEREMPLOYEE_VIEW p where C_BPARTNEREMPLOYEE_VIEW_id=p_idvalue;
elsif p_tablename='SNR_MASTERDATA' then
    select c_doctype_id into v_doctypeid from c_doctype where name = 'Serialnumber';
    select p.ad_org_id,p_idvalue,'CO',v_doctypeid,p.serialnumber,'','','', 
           to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS'), 
           '',
           zssi_juwiorgshortcut(p.ad_org_id),
           zssi_docshortcut(v_doctypeid)
    into ad_org_id,document_id,docstatus,docTypeTargetId,ourreference,cusreference,bpartner_id,bpartner_language,unique_timestamp,bpartner_name,orga,docname
    from SNR_MASTERDATA p where SNR_MASTERDATA_id=p_idvalue;
elsif p_tablename='ZSSM_PRODUCTIONORDER_V' then
    select c_doctype_id into v_doctypeid from c_doctype where name = 'Productionorder';
    select p.ad_org_id,p_idvalue,'CO',v_doctypeid,p.name,p.poreference,p.c_bpartner_id,
           (select ad_language from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id) , 
           to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS'), 
           (select name from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id),
           zssi_juwiorgshortcut(p.ad_org_id),
           zssi_docshortcut(v_doctypeid)
    into ad_org_id,document_id,docstatus,docTypeTargetId,ourreference,cusreference,bpartner_id,bpartner_language,unique_timestamp,bpartner_name,orga,docname
    from c_project p where c_project_id=p_idvalue;
elsif p_tablename='ZSSM_WORKSTEPACTIVITIES_V' then
    select c_doctype_id into v_doctypeid from c_doctype where name = 'WorkstepActivity';
    select p.ad_org_id,p_idvalue,'CO',v_doctypeid,p.name,p.poreference,p.c_bpartner_id,
           (select ad_language from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id) , 
           to_char(CURRENT_TIMESTAMP, 'YYDDDSSSS'), 
           (select name from c_bpartner b where b.c_bpartner_id=p.c_bpartner_id),
           zssi_juwiorgshortcut(p.ad_org_id),
           zssi_docshortcut(v_doctypeid)
    into ad_org_id,document_id,docstatus,docTypeTargetId,ourreference,cusreference,bpartner_id,bpartner_language,unique_timestamp,bpartner_name,orga,docname
    from c_project p, c_projecttask pt,zspm_ptaskhrplan hr where pt.c_project_id=p.c_project_id 
         and pt.c_projecttask_id=hr. c_projecttask_id and hr.zspm_ptaskhrplan_id=p_idvalue;
end if;
    return next;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
CREATE OR REPLACE FUNCTION getDocStatus(p_table_id character varying,p_currentvalue character varying)
  RETURNS character varying AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/
TYPE_Ref REFCURSOR;
v_cursor TYPE_Ref%TYPE;
v_cur RECORD;
v_sql character varying;
v_keycolumname character varying;
v_columnid character varying;
v_tablename character varying;
v_result character varying;
BEGIN
  if p_table_id is not null then
      select columnname,tablename into v_keycolumname,v_tablename from ad_column,ad_table where 
              ad_table.ad_table_id=ad_column.ad_table_id and iskey='Y' and ad_table.ad_table_id=p_table_id;
      v_sql:='select docstatus from '||v_tablename||' where '||v_keycolumname||' = '|| chr(39)||coalesce(p_currentvalue,'')||chr(39);
      OPEN v_cursor FOR EXECUTE v_sql;
      LOOP
            FETCH v_cursor INTO v_cur;
            EXIT WHEN NOT FOUND;
            v_result:=v_cur.docstatus;
      END LOOP;
      close v_cursor;
  end if;   
  RETURN v_result;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  

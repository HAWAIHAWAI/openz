/**************************************************************************************************************************************+

Multi - Language and Localizazion 

Database Functions




Text Modules, Messages, Document-Text, Number and Date Localizations









***************************************************************************************************************************************/




/*----------------------------------------------------------------------------------------------







Application Dictionary Text Retrieval Functions






---------------------------------------------------------------------------------------------------*/



CREATE OR REPLACE FUNCTION ad_getFieldText(p_fieldid character varying, p_ad_language character varying) RETURNS character varying
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
**************************************************************************************************************************************************
*/
DECLARE
-- Simple Types
v_return  character varying;
v_id      character varying;
v_otext    character varying;
BEGIN
  select ad_field_v_id,name into v_id,v_otext from ad_field_v where ad_field_v_id=p_fieldid;
  select name into v_return from ad_field_trl_instance where ad_field_v_id=v_id and ad_language=p_ad_language;
  if v_return is null then
        select name into v_return from ad_field_trl where ad_field_v_id=v_id and ad_language=p_ad_language;
  end if;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    else
     v_return:= p_fieldid;
    end if;
  end if;
RETURN coalesce(v_return,'');
END;
$_$  LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION ad_getFieldGroupText(p_fieldgroupid character varying, p_ad_language character varying) RETURNS character varying
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
**************************************************************************************************************************************************
*/
DECLARE
-- Simple Types
v_return  character varying;
v_id      character varying;
v_otext    character varying;
BEGIN
  select ad_fieldgroup_id,name into v_id,v_otext from ad_fieldgroup where ad_fieldgroup_id=p_fieldgroupid;
  select name into v_return from ad_fieldgroup_trl_instance where ad_fieldgroup_id=v_id and ad_language=p_ad_language;
  if v_return is null then
        select name into v_return from ad_fieldgroup_trl where ad_fieldgroup_id=v_id and ad_language=p_ad_language;
  end if;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    else
     v_return:= p_fieldgroupid;
    end if;
  end if;
RETURN coalesce(v_return,'');
END;
$_$  LANGUAGE 'plpgsql';

CREATE or replace FUNCTION zssi_getWindowText(v_objectname character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_id      character varying;
v_otext    character varying;
BEGIN
  if v_return is null then
        select ad_window_id into v_id from ad_window where upper(name)=upper(v_objectname);
        if v_id is not null then
            select name into v_return from ad_window_trl where ad_window_id=v_id and ad_language=lang;
        end if;
  end if;
  if v_return is null then
        select ad_form_id into v_id from ad_form where upper(name)=upper(v_objectname);
        if v_id is not null then
            select name into v_return from ad_form_trl where ad_form_id=v_id and ad_language=lang;
        end if;
  end if;
  if v_return is null then
        select ad_reference_id into v_id from ad_reference where upper(name)=upper(v_objectname);
        if v_id is not null then
            select name into v_return from ad_reference_trl where ad_reference_id=v_id and ad_language=lang;
        end if;
  end if;
  if v_return is null then
        select ad_process_id into v_id from ad_process where upper(name)=upper(v_objectname);
        if v_id is not null then
            select name into v_return from ad_process_trl where ad_process_id=v_id and ad_language=lang;
        end if;
  end if;
RETURN coalesce(v_return,v_objectname);
END;
$_$  LANGUAGE 'plpgsql';



CREATE or replace FUNCTION zssi_getProcessDescriptionText(v_processId character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_otext    character varying;
BEGIN
  if v_return is null then
        select description into v_return from ad_process_trl where ad_process_id=v_processId and ad_language=lang;
  end if;
  if v_return is null then
        select description into v_return from ad_process where ad_process_id=v_processId;
  end if;
 
RETURN coalesce(v_return,'');
END;
$_$  LANGUAGE 'plpgsql';

CREATE or replace FUNCTION zssi_getProcessInfoText(v_processId character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_otext    character varying;
BEGIN
  if v_return is null then
        select help into v_return from ad_process_trl where ad_process_id=v_processId and ad_language=lang;
  end if;
  if v_return is null then
        select help into v_return from ad_process where ad_process_id=v_processId;
  end if;
 
RETURN coalesce(v_return,'');
END;
$_$  LANGUAGE 'plpgsql';



CREATE or replace FUNCTION zssi_getElementTextByColumname(v_dbcolumnname character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_id      character varying;
v_otext    character varying;
BEGIN
  select ad_element_id,name into v_id,v_otext from ad_element where columnname=v_dbcolumnname;
  if v_id is null then
      select ad_element_id,name into v_id,v_otext from ad_element where upper(columnname)=upper(v_dbcolumnname);
  end if;
  if v_id is null then
      select ad_element_id,name into v_id,v_otext from ad_element where replace(columnname,'_','')=replace(v_dbcolumnname,'_','');
  end if;
  if v_id is null then
      select ad_element_id,name into v_id,v_otext from ad_element where upper(replace(columnname,'_',''))=upper(replace(v_dbcolumnname,'_',''));
  end if;
  select name into v_return from ad_element_trl_instance where ad_element_id=v_id and ad_language=lang;
  if v_return is null then
        select name into v_return from ad_element_trl where ad_element_id=v_id and ad_language=lang;
  end if;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    else
     v_return:= v_dbcolumnname;
    end if;
  end if;
RETURN coalesce(v_return,'');
END;
$_$  LANGUAGE 'plpgsql';

CREATE or replace FUNCTION zssi_getElementTextByID(v_elementID character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_otext    character varying;
BEGIN
  select name into v_otext from ad_element where ad_element_id=v_elementID;
  if v_otext is null then 
    return v_elementID; 
  end if;
  select name into v_return from ad_element_trl_instance where ad_element_id=v_elementID and ad_language=lang;
  if v_return is null then
        select name into v_return from ad_element_trl where ad_element_id=v_elementID and ad_language=lang;
  end if;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    end if;
  end if;
RETURN coalesce(v_return,v_elementID);
END;
$_$  LANGUAGE 'plpgsql';

CREATE or replace FUNCTION zssi_getListTextByValue(v_RefListName character varying, lang character varying, p_value varchar) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_listID varchar;
v_otext    character varying;
BEGIN
  select l.ad_ref_list_id,l.name into   v_listID,v_otext from ad_ref_list l, ad_reference r 
         where r.ad_reference_id=l.ad_reference_id and r.name=v_RefListName and l.value=p_value ;
  select t.name into v_return from ad_ref_listinstance_trl t,ad_ref_listinstance i 
         where i.ad_ref_listinstance_id=t.ad_ref_listinstance_id and i.ad_ref_list_id=v_listID and ad_language=lang;
  if v_return is null then
        select name into v_return from ad_ref_list_trl where ad_ref_list_id=v_listID and ad_language=lang;
  end if;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    end if;
  end if;
RETURN coalesce(v_return,'');
END;
$_$  LANGUAGE 'plpgsql';


CREATE or replace FUNCTION zssi_getProcessParamTextByID(v_Process_ParamID character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_otext    character varying;
BEGIN
  select name into v_otext from ad_process_para_trl where ad_process_para_id=v_Process_ParamID and ad_language=lang;
  
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    end if;
  end if;
RETURN coalesce(v_return,'');
END;
$_$  LANGUAGE 'plpgsql';

CREATE or replace FUNCTION zssi_getTabFieldTextByID(v_FieldID character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_otext    character varying;
v_cmtext varchar;
BEGIN
  if lang='en_US' then
    select name into v_cmtext from ad_field where ad_field_id=v_FieldID and iscentrallymaintained='N';
  end if;
  select name into v_otext from ad_field_trl where ad_field_v_id=v_FieldID and ad_language=lang;
  select name into v_return from ad_field_trl_instance where ad_field_v_id=v_FieldID and ad_language=lang;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    end if;
    if v_otext is null and v_cmtext is not null then
     v_return:= v_cmtext;
    end if;
  end if;
RETURN coalesce(v_return,'');
END;
$_$  LANGUAGE 'plpgsql';

CREATE or replace FUNCTION zssi_getText(v_text character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_id      character varying;
v_otext    character varying;
BEGIN
  select ad_message_id,msgtext into v_id,v_otext from ad_message where value=v_text;
  select msgtext into v_return from ad_message_trl_instance where ad_message_id=v_id and ad_language=lang;
  if v_return is null then
        select msgtext into v_return from ad_message_trl where ad_message_id=v_id and ad_language=lang;
  end if;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    else
     v_return:= v_text;
    end if;
  end if;
RETURN coalesce(v_return,'');
EXCEPTION
WHEN NO_DATA_FOUND THEN
  RETURN 'No translation for '||text||' found '||' Lang: '||lang;
END;
$_$
  LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION ad_message_get(p_value character varying, p_ad_language character varying) RETURNS character varying
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
**************************************************************************************************************************************************
For compatibility only.
*/
BEGIN
  return zssi_getText(p_value,p_ad_language);
END; $_$ LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION ad_message_get2(p_value character varying, p_ad_language character varying) RETURNS character varying
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
For compatibility only.
*/
BEGIN
   return zssi_getText(p_value,p_ad_language);
END; $_$ LANGUAGE 'plpgsql';





CREATE or replace FUNCTION zssi_getListRefText(p_adreflistID character varying, p_value character varying,lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_otext    character varying;
BEGIN
  select name into v_return from ad_ref_list_v where ad_reference_id=p_adreflistID and value=p_value  and ad_language=lang;
  select name into v_otext from ad_ref_list_v where ad_reference_id=p_adreflistID and value=p_value  and ad_language='en_US';
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    else
     v_return:= p_value;
    end if;
  end if;
RETURN coalesce(v_return,'');
EXCEPTION
WHEN NO_DATA_FOUND THEN
  RETURN 'No translation for '||text||' found '||' Lang: '||lang;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
  
  CREATE or replace FUNCTION zssi_getSelectorIdentifierByID(v_selector character varying,v_id varchar,lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_refid varchar;
v_table varchar;
v_tname varchar;
v_return character varying;
TYPE_Ref REFCURSOR;
v_cursor TYPE_Ref%TYPE;
v_cur RECORD;
BEGIN
      select ad_reference_id into v_refid from ad_reference where name=v_selector;
      select ad_table_id into v_table from ad_ref_search   where ad_reference_id=v_refid;
      select tablename into v_tname from ad_table where ad_table_id=v_table;
      select ad_column_identifier(v_tname, v_id,lang) into v_return;
RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
  
  
  
  
  
/*-----------------------------------







Formatting Functions









--------------------------------------------*/






CREATE or replace FUNCTION zssi_strDate(v_date timestamp, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
BEGIN
  if lang='de_DE' then
      return to_char(v_date, 'DD.MM.YYYY');
  else
      RETURN to_char(v_date, 'DD-Mon-YYYY');
  end if;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_strDate(v_date timestamp, lang character varying) OWNER TO tad;

CREATE or replace FUNCTION zssi_strNumber(v_num numeric, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Returns specific German Localization regardless of the localization of the machine
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
BEGIN
  if lang='de_DE' then
      --return replace(to_char(v_num,'99999G990D99'),' ','');
      v_return:=replace(to_char(v_num, '999,999,999,999,990.99'),' ','');
      v_return:=replace(v_return,'.','X');
      v_return:=replace(v_return,',','.');
      v_return:=replace(v_return,'X',',');
      RETURN v_return;
  else
      RETURN replace(to_char(v_num, '999,999,999,990.99'),' ','');
  end if;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_strNumber(v_num numeric, lang character varying) OWNER TO tad;

CREATE or replace FUNCTION zssi_strNumber2(v_num numeric, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Returns specific German Localization regardless of the localization of the machine
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
BEGIN
  if lang='de_DE' then
      --return replace(to_char(v_num,'99999G990D99'),' ','');
      v_return:=replace(to_char(v_num, '999,999,999,990.9999'),' ','');
      v_return:=replace(v_return,'.','X');
      v_return:=replace(v_return,',','.');
      v_return:=replace(v_return,'X',',');
	  if (substring(v_return from (char_length(v_return) -1 )) = '00') then
		v_return:=substring(v_return from 1 for (char_length(v_return) - 2));
	  elsif (substring(v_return from (char_length(v_return))) = '0') then
		v_return:=substring(v_return from 1 for (char_length(v_return) - 1));
	  end if;
      RETURN v_return;
  else
      v_return:=replace(to_char(v_num, '999,999,999,990.9999'),' ','');
	  if (substring(v_return from (char_length(v_return) -1 )) = '00') then
		v_return:=substring(v_return from 1 for (char_length(v_return) - 2));
	  elsif (substring(v_return from (char_length(v_return))) = '0') then
		v_return:=substring(v_return from 1 for (char_length(v_return) - 1));
	  end if;
      RETURN v_return;
  end if;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_strNumber2(v_num numeric, lang character varying) OWNER TO tad;

CREATE or replace FUNCTION zssi_strInt(v_num numeric) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Localozation in Database - The better way
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
BEGIN
      return to_char(v_num,'999G999G999G990' );
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_strInt(v_num numeric) OWNER TO tad;







/*---------------------------------------------------------




Text Retrieval Functions






------------------------------------------------------------*/

CREATE or replace FUNCTION zssi_GetDocText(v_doctype_id character varying, lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Get Document-Text from Database
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
BEGIN
  select printname into v_return from c_doctype_trl where c_doctype_id =v_doctype_id
         and ad_language=lang;
RETURN coalesce(v_return,'');
EXCEPTION
WHEN NO_DATA_FOUND THEN
  RETURN 'No text found';
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_GetDocText(v_doctype_id character varying, lang character varying) OWNER TO tad;


CREATE or replace FUNCTION zssi_getproductname(v_product character varying,v_lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select name into v_return from m_product_trl where m_product_id=v_product and ad_language=v_lang;
      if v_return is null then 
          select name into v_return from m_product where m_product_id=v_product;
      end if;
RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
CREATE or replace FUNCTION zssi_getproductnamewithvalue(v_product character varying,v_lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select p.value||'-'||t.name into v_return from m_product p,m_product_trl t where t.m_product_id=p.m_product_id and p.m_product_id=v_product and ad_language=v_lang;
      if v_return is null then 
          select value||'-'||name into v_return from m_product where m_product_id=v_product;
      end if;
RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;


select zsse_dropfunction('zssi_getproductset_complete');
CREATE or replace FUNCTION zssi_getproductset_complete(v_product character varying, v_lang character varying ) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_line character varying;
v_cur record;
BEGIN
  FOR v_cur in (select bomqty as v_bomqty,m_productbom_id as v_bomproduct,description as v_bomdescription from m_product_bom where m_product_id=v_product)
  LOOP
  --v_line:=coalesce(v_line,'-')||v_cur.v_bomqty||' '||zssi_getproductname(v_cur.v_bomproduct,v_lang)||' '||coalesce(v_cur.v_bomdescription,(select m_product.description from m_product where m_product_id=v_bomproduct))||'<br/>-';
  v_line:=coalesce(v_line,'')||chr(32)||'-'||zssi_strint(to_number(v_cur.v_bomqty))||' '||zssi_getproductname(v_cur.v_bomproduct,v_lang)||'<br/>';
  END LOOP;
return v_line;
  END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
  
select zsse_dropfunction('zssi_checkifsetproduct');
CREATE or replace FUNCTION zssi_checkifsetproduct(v_product character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
select issetitem into v_return from m_product where m_product_id=v_product;
RETURN coalesce(v_return,'N');
END
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
  
CREATE or replace FUNCTION zssi_getproductkey(v_product character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select value into v_return from m_product where m_product_id=v_product;
     
RETURN coalesce(v_return,'');
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;


CREATE or replace FUNCTION zssi_getIdentifierFromKey(v_keycolumnname character varying,v_value character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_sql character varying;
TYPE_Ref REFCURSOR;
v_cursor TYPE_Ref%TYPE;
v_cur RECORD;
v_table varchar;
v_selstr varchar:='';
v_tablename varchar;
BEGIN
      v_tablename:=lower(substr(v_keycolumnname,1,length(v_keycolumnname)-3));
      select ad_table_id into v_table from ad_table where lower(tablename)= v_tablename;
      for v_cur in select columnname from ad_column where ad_table_id=v_table and isidentifier ='Y' order by seqno
      LOOP
         if v_selstr!='' then v_selstr:=v_selstr||'||'||chr(39)||'-'||chr(39)||'||'; end if;
         v_selstr:= v_selstr || v_cur.columnname;
      END LOOP;
raise notice '%',v_selstr;
      v_sql:='select '||v_selstr||' as retval from '|| v_tablename||' where  '||v_keycolumnname ||' = '||chr(39)||v_value||chr(39);
      OPEN v_cursor FOR EXECUTE v_sql;
      LOOP
            FETCH v_cursor INTO v_cur;
            EXIT WHEN NOT FOUND;
            v_return:=v_cur.retval;
      END LOOP;
RETURN coalesce(v_return,'');
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;


CREATE OR REPLACE FUNCTION zssi_getusername (p_user_id VARCHAR)
RETURNS VARCHAR AS
$body$
-- SELECT zssi_getusername('B190399E0FC542908B02205D8DD4F577');
-- DECLARE 
BEGIN
  RETURN COALESCE((SELECT ad.name FROM ad_user ad WHERE ad.ad_user_id = p_user_id),'');
END ;
$body$
LANGUAGE 'plpgsql';


CREATE or replace FUNCTION zssi_getusernamecomplete(v_user character varying,lang character varying) RETURNS character varying
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
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_prefix character varying;
v_id character varying;
v_title character varying;
BEGIN
      select name,c_greeting_id, title into v_return,v_id,v_title from ad_user where ad_user_id=v_user;
      select name into v_prefix from c_greeting_trl where c_greeting_id=v_id and ad_language=lang;
      if v_prefix is null then 
          select name into v_prefix from c_greeting where c_greeting_id=v_id;
      end if;
      if v_prefix is not null then v_prefix:=v_prefix||' '; end if;
	  if v_title is not null then v_prefix:=v_prefix||v_title||' '; end if;
RETURN coalesce(v_prefix,'')||coalesce(v_return,'');
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_getusernamecomplete(v_user character varying,lang character varying) OWNER TO tad;


CREATE or replace FUNCTION zssi_getprojectorcostcentername(v_project character varying,v_costcenter character varying) RETURNS character varying
AS $BODY$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Danny Heuduk
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select name||' - '||value into v_return from c_project where c_project_id=v_project;
      if v_return is null then 
          select name||' - '||value into v_return from a_asset where a_asset_id=v_costcenter;
      end if;
RETURN coalesce(v_return,'');
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_getprojectorcostcentername(v_project character varying,v_costcenter character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getprojectorcostcentervalue(v_project character varying, v_costcenter character varying)
  RETURNS character varying AS
$BODY$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Danny Heuduk, Frank Wohlers
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select value into v_return from c_project where c_project_id=v_project;
      if v_return is null then 
          select value into v_return from a_asset where a_asset_id=v_costcenter;
      end if;
RETURN coalesce(v_return,'');
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE or replace FUNCTION zssi_getuom(v_uom character varying,lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select uomsymbol into v_return from c_uom_trl where c_uom_id=v_uom and ad_language=lang;
      if v_return is null then 
          select uomsymbol into v_return from c_uom where c_uom_id=v_uom;
      end if;
RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_getuom(v_uom character varying,lang character varying) OWNER TO tad;

CREATE or replace FUNCTION zssi_getproductuom(v_puom character varying,lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_id character varying;
BEGIN
      select c_uom_id into v_id from m_product_uom where m_product_uom_id=v_puom;
      select uomsymbol into v_return from c_uom_trl where c_uom_id=v_id and ad_language=lang;
      if v_return is null then 
          select uomsymbol into v_return from c_uom where c_uom_id=v_id;
      end if;
RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_getproductuom(v_uom character varying,lang character varying) OWNER TO tad;

CREATE or replace FUNCTION zssi_getuserEMail(v_user character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_prefix character varying;
v_id character varying;
BEGIN
      select email into v_return from ad_user where ad_user_id=v_user;
RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_getuserEMail(v_user character varying) OWNER TO tad;


CREATE or replace FUNCTION zssi_getuserPhone(v_user character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_prefix character varying;
v_id character varying;
BEGIN
      select phone into v_return from ad_user where ad_user_id=v_user;
RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_getuserPhone(v_user character varying) OWNER TO tad;


CREATE or replace FUNCTION zssi_getOrgName(v_org character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Returns Client-Name if Org='0', else Org-Name
*****************************************************/
DECLARE
v_return character varying;

BEGIN
      if v_org in ('0','*') then
         select name into v_return from ad_client where ad_client_id!='0';
      else 
         select name into v_return from ad_org where ad_org_id=v_org;
      end if;
RETURN v_return;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE or replace FUNCTION zssi_getSepaVWZ(v_invoice character varying,orderno character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Returns SEPA-Verwendungszweck
*****************************************************/
DECLARE
v_return character varying;

BEGIN
      if orderno='1' then
         select poreference into v_return from c_invoice where c_invoice_id=v_invoice;
         if v_return is not null then
            return rpad('Rechn. '||v_return,35,' ');
         end if;
      end if;
      if orderno='2' then
         select to_char(dateinvoiced) into v_return from c_invoice where c_invoice_id=v_invoice;
         if v_return is not null then
            return rpad('vom  '||v_return,35,' ');
         end if;
      end if;
      if orderno='3' then
         select  owncodeatpartnersite into v_return from c_bpartner where c_bpartner_id=(select c_bpartner_id from c_invoice where c_invoice_id=v_invoice);
         if v_return is not null then
            return rpad('Kunde Nr. '||v_return,35,' ');
         end if;
      end if;
      if orderno='4' then
         select to_char(documentno) into v_return from c_invoice where c_invoice_id=v_invoice;
         if v_return is not null then
            return rpad('OP Nr.  '||v_return,35,' ');
         end if;
      end if;
RETURN v_return;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;


  
CREATE or replace FUNCTION zssi_getOwnCodeAtPartnerSide(v_org character varying,v_bpartner varchar) RETURNS character varying
AS $_$

DECLARE
v_return character varying;

BEGIN
      select owncodeatpartnersite into v_return from c_bpartner_org where ad_org_id=v_org and c_bpartner_id=v_bpartner;
      if v_return is null then 
         select owncodeatpartnersite into v_return from c_bpartner where c_bpartner_id=v_bpartner;
      end if;
RETURN v_return;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
 
  
  
/*-------------------------------------------------------------------------------------------------------------------------------------------------


Special Formatting and Auxillary Functions for Reports etc.




-------------------------------------------------------------------------------------------------------------------------------------------------------------*/
CREATE OR REPLACE FUNCTION zssi_nomultiline(v_text character varying)
  RETURNS character varying AS
$BODY$/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Danny A. Heuduk.
***************************************************************************************************************************************************
Part of Smartprefs
No Multilines
*****************************************************/
DECLARE
v_temp character varying;
v_return character varying;

BEGIN
      select replace(v_text,E'\r\n',' - ') into v_temp;
      select replace(v_temp,'"','`') into v_temp;
      select substring(v_temp , 1, 70) into v_return;
      RETURN v_return;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zssi_shortlength(v_text character varying)
  RETURNS character varying AS
$BODY$
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
Restriction of characters
*****************************************************/
DECLARE
v_temp character varying;
v_return character varying;


BEGIN
      select replace(v_text,'"','`') into v_temp;
      select substring(v_temp , 1, 40) into v_return;
      RETURN v_return;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
CREATE OR REPLACE FUNCTION zssi_limitlength55(v_text character varying)
  RETURNS character varying AS
$BODY$
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
Restriction of characters
*****************************************************/
DECLARE
v_temp character varying;
v_return character varying;


BEGIN
      select replace(v_text,'"','`') into v_temp;
      select substring(v_temp , 1, 40) into v_return;
      RETURN v_return;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zssi_html4docs(v_text character varying)
  RETURNS character varying AS
$BODY$
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
Restriction of characters
*****************************************************/
DECLARE
v_return character varying;
BEGIN
/* Patch 
      select replace(v_text,E'\r\n','<br/>') into v_return;
      select replace(v_return,'"','`') into v_return;
      select replace(v_return,chr(39),'`') into  v_return;
*/

      select replace(v_text,'"','`') into v_return;
      select replace(v_return,chr(39),'`') into  v_return;
	  select replace(v_return, ' < ', ' &lt; ') into v_return;
	  select replace(v_return, ' > ', ' &gt; ') into v_return;
	  select replace(v_return,E'\r\n','<br/>') into v_return;
          select replace(v_return, '<', '&lt;') into v_return;
	  select replace(v_return, '>', '&gt;') into v_return;
/* Replace valid html tags */
	  /* bold tags */
	  select replace(v_return, '&lt;b&gt;', '<b>') into v_return;
	  select replace(v_return, '&lt;/b&gt;', '</b>') into v_return;
	  select replace(v_return, '&lt;B&gt;', '<b>') into v_return;
	  select replace(v_return, '&lt;/B&gt;', '</b>') into v_return;
	  /* preformatted  tags */
	  select replace(v_return, '&lt;pre&gt;', '<pre>') into v_return;
	  select replace(v_return, '&lt;PRE&gt;', '<pre>') into v_return;
	  select replace(v_return, '&lt;/pre&gt;', '</pre>') into v_return;
	  select replace(v_return, '&lt;/PRE&gt;', '</pre>') into v_return;
	  /* Linebreak tags */
	  select replace(v_return, '&lt;br&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;BR&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;/br&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;/BR&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;br/&gt;', chr(10)) into v_return;
	  select replace(v_return, '&lt;BR/&gt;', '<br/>') into v_return;
	  /*  italic tags */
	  select replace(v_return, '&lt;i&gt;', '<i>') into v_return;
	  select replace(v_return, '&lt;I&gt;', '<i>') into v_return;
	  select replace(v_return, '&lt;/i&gt;', '</i>') into v_return;
	  select replace(v_return, '&lt;/I&gt;', '</i>') into v_return;
	  /*  underlined tags */
	  select replace(v_return, '&lt;u&gt;', '<u>') into v_return;
	  select replace(v_return, '&lt;U&gt;', '<u>') into v_return;
	  select replace(v_return, '&lt;/u&gt;', '</u>') into v_return;
	  select replace(v_return, '&lt;/U&gt;', '</u>') into v_return;
	  /* new line tags */
	  select replace(v_return, '&lt;p&gt;', '<p>') into v_return;
	  select replace(v_return, '&lt;P&gt;', '<p>') into v_return;
	  select replace(v_return, '&lt;/p&gt;', '</p>') into v_return;
	  select replace(v_return, '&lt;/P&gt;', '</p>') into v_return;	
	  /*  List tags */
	  select replace(v_return, '&lt;ul&gt;', '<ul>') into v_return;
	  select replace(v_return, '&lt;UL&gt;', '<ul>') into v_return;
	  select replace(v_return, '&lt;/ul&gt;', '</ul>') into v_return;
	  select replace(v_return, '&lt;/UL&gt;', '</ul>') into v_return;
	  select replace(v_return, '&lt;li&gt;', '<li>') into v_return;
	  select replace(v_return, '&lt;LI&gt;', '<li>') into v_return;
	  select replace(v_return, '&lt;/li&gt;', '</li>') into v_return;
	  select replace(v_return, '&lt;/LI&gt;', '</li>') into v_return;
	  /*  New Area tags */
	  select replace(v_return, '&lt;div&gt;', '<div>') into v_return;
	  select replace(v_return, '&lt;DIV&gt;', '<div>') into v_return;
	  select replace(v_return, '&lt;/div&gt;', '</div>') into v_return;
	  select replace(v_return, '&lt;/DIV&gt;', '</div>') into v_return;
	  /*  crossed tags */
	  select replace(v_return, '&lt;s&gt;', '<s>') into v_return;
	  select replace(v_return, '&lt;S&gt;', '<s>') into v_return;
	  select replace(v_return, '&lt;/s&gt;', '</s>') into v_return;
	  select replace(v_return, '&lt;/S&gt;', '</s>') into v_return;	
	  /*  other tags */
	  select replace(v_return, '&lt;dd&gt;', '<dd>') into v_return;
	  select replace(v_return, '&lt;DD&gt;', '<dd>') into v_return;
	  select replace(v_return, '&lt;/dd&gt;', '</dd>') into v_return;
	  select replace(v_return, '&lt;/DD&gt;', '</dd>') into v_return;
	  select replace(v_return, '&lt;sup&gt;', '<sup>') into v_return;
	  select replace(v_return, '&lt;SUP&gt;', '<sup>') into v_return;
	  select replace(v_return, '&lt;/sup&gt;', '</sup>') into v_return;
	  select replace(v_return, '&lt;/SUP&gt;', '</sup>') into v_return;
	  select replace(v_return, '&lt;dt&gt;', '<dt>') into v_return;
	  select replace(v_return, '&lt;DT&gt;', '<dt>') into v_return;
	  select replace(v_return, '&lt;/dt&gt;', '</dt>') into v_return;
	  select replace(v_return, '&lt;/DT&gt;', '</dt>') into v_return;	
	  select replace(v_return, '&lt;dl&gt;', '<dl>') into v_return;
	  select replace(v_return, '&lt;DL&gt;', '<dl>') into v_return;
	  select replace(v_return, '&lt;/dl&gt;', '</dl>') into v_return;
	  select replace(v_return, '&lt;/DL&gt;', '</dl>') into v_return;
	  select replace(v_return, '&lt;sub&gt;', '<sub>') into v_return;
	  select replace(v_return, '&lt;SUB&gt;', '<sub>') into v_return;
	  select replace(v_return, '&lt;/sub&gt;', '</sub>') into v_return;
	  select replace(v_return, '&lt;/SUB&gt;', '</sub>') into v_return;
	  select replace(v_return, '&lt;tt&gt;', '<tt>') into v_return;
	  select replace(v_return, '&lt;TT&gt;', '<tt>') into v_return;
	  select replace(v_return, '&lt;/tt&gt;', '</tt>') into v_return;
	  select replace(v_return, '&lt;/TT&gt;', '</tt>') into v_return;
	  select replace(v_return, '&lt;ol&gt;', '<ol>') into v_return;
	  select replace(v_return, '&lt;OL&gt;', '<ol>') into v_return;
	  select replace(v_return, '&lt;/ol&gt;', '</ol>') into v_return;
	  select replace(v_return, '&lt;/OL&gt;', '</ol>') into v_return;
	  select replace(v_return, '&lt;strong&gt;', '<strong>') into v_return;
	  select replace(v_return, '&lt;STRONG&gt;', '<strong>') into v_return;
	  select replace(v_return, '&lt;/strong&gt;', '</strong>') into v_return;
	  select replace(v_return, '&lt;/STRONG&gt;', '</strong>') into v_return;
	  select replace(v_return, '&lt;code&gt;', '<code>') into v_return;
	  select replace(v_return, '&lt;CODE&gt;', '<code>') into v_return;
	  select replace(v_return, '&lt;/code&gt;', '</code>') into v_return;
	  select replace(v_return, '&lt;/CODE&gt;', '</code>') into v_return;	
	  select replace(v_return, '&lt;var&gt;', '<var>') into v_return;
	  select replace(v_return, '&lt;VAR&gt;', '<var>') into v_return;
	  select replace(v_return, '&lt;/var&gt;', '</var>') into v_return;
	  select replace(v_return, '&lt;/VAR&gt;', '</var>') into v_return;
	  select replace(v_return, '&lt;cite&gt;', '<cite>') into v_return;
	  select replace(v_return, '&lt;CITE&gt;', '<cite>') into v_return;
	  select replace(v_return, '&lt;/cite&gt;', '</cite>') into v_return;
	  select replace(v_return, '&lt;/CITE&gt;', '</cite>') into v_return;
	  select replace(v_return, '&lt;dfn&gt;', '<dfn>') into v_return;
	  select replace(v_return, '&lt;DFN&gt;', '<dfn>') into v_return;
	  select replace(v_return, '&lt;/dfn&gt;', '</dfn>') into v_return;
	  select replace(v_return, '&lt;/DFN&gt;', '</dfn>') into v_return;
	  select replace(v_return, '&lt;abbr&gt;', '<abbr>') into v_return;
	  select replace(v_return, '&lt;ABBR&gt;', '<abbr>') into v_return;
	  select replace(v_return, '&lt;/abbr&gt;', '</abbr>') into v_return;
	  select replace(v_return, '&lt;/ABBR&gt;', '</abbr>') into v_return;
	  select replace(v_return, '&lt;acronym&gt;', '<acronym>') into v_return;
	  select replace(v_return, '&lt;ACRONYM&gt;', '<acronym>') into v_return;
	  select replace(v_return, '&lt;/acronym&gt;', '</acronym>') into v_return;
	  select replace(v_return, '&lt;/ACRONYM&gt;', '</acronym>') into v_return;
	  select replace(v_return, '&lt;h1&gt;', '<h1>') into v_return;
	  select replace(v_return, '&lt;H1&gt;', '<h1>') into v_return;
	  select replace(v_return, '&lt;/h1&gt;', '</h1>') into v_return;
	  select replace(v_return, '&lt;/H1&gt;', '</h1>') into v_return;
      select replace(v_return, '&lt;h2&gt;', '<h2>') into v_return;
	  select replace(v_return, '&lt;H2&gt;', '<h2>') into v_return;
	  select replace(v_return, '&lt;/h2&gt;', '</h2>') into v_return;
	  select replace(v_return, '&lt;/H2&gt;', '</h2>') into v_return;
	  select replace(v_return, '&lt;h3&gt;', '<h3>') into v_return;
	  select replace(v_return, '&lt;H3&gt;', '<h3>') into v_return;
	  select replace(v_return, '&lt;/h3&gt;', '</h3>') into v_return;
	  select replace(v_return, '&lt;/H3&gt;', '</h3>') into v_return;
	  select replace(v_return, '&lt;address&gt;', '<address>') into v_return;
	  select replace(v_return, '&lt;ADDRESS&gt;', '<address>') into v_return;
	  select replace(v_return, '&lt;/address&gt;', '</address>') into v_return;
	  select replace(v_return, '&lt;/ADDRESS&gt;', '</address>') into v_return;
	  select replace(v_return, '&lt;big&gt;', '<big>') into v_return;
	  select replace(v_return, '&lt;BIG&gt;', '<big>') into v_return;
	  select replace(v_return, '&lt;/big&gt;', '</big>') into v_return;
	  select replace(v_return, '&lt;/BIG&gt;', '</big>') into v_return;
	  select replace(v_return, '&lt;small&gt;', '<small>') into v_return;
	  select replace(v_return, '&lt;SMALL&gt;', '<small>') into v_return;
	  select replace(v_return, '&lt;/small&gt;', '</small>') into v_return;
	  select replace(v_return, '&lt;/SMALL&gt;', '</small>') into v_return;
	  select replace(v_return, '&lt;strike&gt;', '<strike>') into v_return;
	  select replace(v_return, '&lt;STRIKE&gt;', '<strike>') into v_return;
	  select replace(v_return, '&lt;/strike&gt;', '</strike>') into v_return;
	  select replace(v_return, '&lt;/STRIKE&gt;', '</strike>') into v_return;
	  select replace(v_return, '&lt;blockquote&gt;', '<blockquote>') into v_return;
	  select replace(v_return, '&lt;BLOCKQUOTE&gt;', '<blockquote>') into v_return;
	  select replace(v_return, '&lt;/blockquote&gt;', '</blockquote>') into v_return;
	  select replace(v_return, '&lt;/BLOCKQUOTE&gt;', '</blockquote>') into v_return;
	  select replace(v_return, '&lt;caption&gt;', '<caption>') into v_return;
	  select replace(v_return, '&lt;CAPTION&gt;', '<caption>') into v_return;
	  select replace(v_return, '&lt;/caption&gt;', '</caption>') into v_return;
	  select replace(v_return, '&lt;/CAPTION&gt;', '</caption>') into v_return;
	  select replace(v_return, '&lt;center&gt;', '<center>') into v_return;
	  select replace(v_return, '&lt;CENTER&gt;', '<center>') into v_return;
	  select replace(v_return, '&lt;/center&gt;', '</center>') into v_return;
	  select replace(v_return, '&lt;/CENTER&gt;', '</center>') into v_return;
	  select replace(v_return, '&lt;del&gt;', '<del>') into v_return;
	  select replace(v_return, '&lt;DEL&gt;', '<del>') into v_return;
	  select replace(v_return, '&lt;/del&gt;', '</del>') into v_return;
	  select replace(v_return, '&lt;/DEL&gt;', '</del>') into v_return;
	  select replace(v_return, '&lt;em&gt;', '<em>') into v_return;
	  select replace(v_return, '&lt;EM&gt;', '<em>') into v_return;
	  select replace(v_return, '&lt;/em&gt;', '</em>') into v_return;
	  select replace(v_return, '&lt;/EM&gt;', '</em>') into v_return;
	  select replace(v_return, '&lt;hr&gt;', '<hr>') into v_return;
	  select replace(v_return, '&lt;HR&gt;', '<hr>') into v_return;
	  select replace(v_return, '&lt;ins&gt;', '<ins>') into v_return;
	  select replace(v_return, '&lt;INS&gt;', '<ins>') into v_return;
	  select replace(v_return, '&lt;/ins&gt;', '</ins>') into v_return;
	  select replace(v_return, '&lt;/INS&gt;', '</ins>') into v_return;	  
	  select replace(v_return, '&lt;kbd&gt;', '<kbd>') into v_return;
	  select replace(v_return, '&lt;KBD&gt;', '<kbd>') into v_return;
	  select replace(v_return, '&lt;/kbd&gt;', '</kbd>') into v_return;
	  select replace(v_return, '&lt;/KBD&gt;', '</kbd>') into v_return;	
	  select replace(v_return, '&lt;samp&gt;', '<samp>') into v_return;
	  select replace(v_return, '&lt;SAMP&gt;', '<samp>') into v_return;
	  select replace(v_return, '&lt;/samp&gt;', '</samp>') into v_return;
	  select replace(v_return, '&lt;/SAMP&gt;', '</samp>') into v_return;	
	  select replace(v_return, '&lt;span&gt;', '<span>') into v_return;
	  select replace(v_return, '&lt;SPAN&gt;', '<span>') into v_return;
	  select replace(v_return, '&lt;/span&gt;', '</span>') into v_return;
	  select replace(v_return, '&lt;/SPAN&gt;', '</span>') into v_return;
	  -- Font size tags
	  select replace(v_return, '&lt;font size=1&gt;', '<font size=1>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=1&gt;', '<font size=1>') into v_return;
	  select replace(v_return, '&lt;font size=2&gt;', '<font size=2>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=2&gt;', '<font size=2>') into v_return;
	  select replace(v_return, '&lt;font size=3&gt;', '<font size=3>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=3&gt;', '<font size=3>') into v_return;
	  select replace(v_return, '&lt;font size=4&gt;', '<font size=4>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=4&gt;', '<font size=4>') into v_return;
	  select replace(v_return, '&lt;font size=5&gt;', '<font size=5>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=5&gt;', '<font size=5>') into v_return;
	  select replace(v_return, '&lt;font size=6&gt;', '<font size=6>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=6&gt;', '<font size=6>') into v_return;
	  select replace(v_return, '&lt;font size=7&gt;', '<font size=7>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=7&gt;', '<font size=7>') into v_return;
	  select replace(v_return, '&lt;font size=8&gt;', '<font size=8>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=8&gt;', '<font size=8>') into v_return;
	  select replace(v_return, '&lt;font size=9&gt;', '<font size=9>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=9&gt;', '<font size=9>') into v_return;
	  select replace(v_return, '&lt;font size=10&gt;', '<font size=10>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=10&gt;', '<font size=10>') into v_return;
	  select replace(v_return, '&lt;/font&gt;', '</font>') into v_return;
	  select replace(v_return, '&lt;/FONT&gt;', '</FONT>') into v_return;
RETURN v_return;

END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE or replace FUNCTION zssi_2HTML(v_text character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
 CRLF 2 HTML
*****************************************************/
DECLARE
v_return character varying;

BEGIN
/* Patch 
      select replace(v_text,E'\r\n','<br/>') into v_return;
      select replace(v_return,'"','`') into v_return;
      select replace(v_return,chr(39),'`') into  v_return;
*/

      select replace(v_text,'"','`') into v_return;
      select replace(v_return,chr(39),'`') into  v_return;
	  select replace(v_return, ' < ', ' &lt; ') into v_return;
	  select replace(v_return, ' > ', ' &gt; ') into v_return;
	  select replace(v_return,E'\r\n','<br/>') into v_return;
          select replace(v_return, '<', '&lt;') into v_return;
	  select replace(v_return, '>', '&gt;') into v_return;
/* Replace valid html tags */
	  /* bold tags */
	  select replace(v_return, '&lt;b&gt;', '<b>') into v_return;
	  select replace(v_return, '&lt;/b&gt;', '</b>') into v_return;
	  select replace(v_return, '&lt;B&gt;', '<b>') into v_return;
	  select replace(v_return, '&lt;/B&gt;', '</b>') into v_return;
	  /* preformatted  tags */
	  select replace(v_return, '&lt;pre&gt;', '<pre>') into v_return;
	  select replace(v_return, '&lt;PRE&gt;', '<pre>') into v_return;
	  select replace(v_return, '&lt;/pre&gt;', '</pre>') into v_return;
	  select replace(v_return, '&lt;/PRE&gt;', '</pre>') into v_return;
	  /* Linebreak tags */
	  select replace(v_return, '&lt;br&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;BR&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;/br&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;/BR&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;br/&gt;', '<br/>') into v_return;
	  select replace(v_return, '&lt;BR/&gt;', '<br/>') into v_return;
	  /*  italic tags */
	  select replace(v_return, '&lt;i&gt;', '<i>') into v_return;
	  select replace(v_return, '&lt;I&gt;', '<i>') into v_return;
	  select replace(v_return, '&lt;/i&gt;', '</i>') into v_return;
	  select replace(v_return, '&lt;/I&gt;', '</i>') into v_return;
	  /*  underlined tags */
	  select replace(v_return, '&lt;u&gt;', '<u>') into v_return;
	  select replace(v_return, '&lt;U&gt;', '<u>') into v_return;
	  select replace(v_return, '&lt;/u&gt;', '</u>') into v_return;
	  select replace(v_return, '&lt;/U&gt;', '</u>') into v_return;
	  /* new line tags */
	  select replace(v_return, '&lt;p&gt;', '<p>') into v_return;
	  select replace(v_return, '&lt;P&gt;', '<p>') into v_return;
	  select replace(v_return, '&lt;/p&gt;', '</p>') into v_return;
	  select replace(v_return, '&lt;/P&gt;', '</p>') into v_return;	
	  /*  List tags */
	  select replace(v_return, '&lt;ul&gt;', '<ul>') into v_return;
	  select replace(v_return, '&lt;UL&gt;', '<ul>') into v_return;
	  select replace(v_return, '&lt;/ul&gt;', '</ul>') into v_return;
	  select replace(v_return, '&lt;/UL&gt;', '</ul>') into v_return;
	  select replace(v_return, '&lt;li&gt;', '<li>') into v_return;
	  select replace(v_return, '&lt;LI&gt;', '<li>') into v_return;
	  select replace(v_return, '&lt;/li&gt;', '</li>') into v_return;
	  select replace(v_return, '&lt;/LI&gt;', '</li>') into v_return;
	  /*  New Area tags */
	  select replace(v_return, '&lt;div&gt;', '<div>') into v_return;
	  select replace(v_return, '&lt;DIV&gt;', '<div>') into v_return;
	  select replace(v_return, '&lt;/div&gt;', '</div>') into v_return;
	  select replace(v_return, '&lt;/DIV&gt;', '</div>') into v_return;
	  /*  crossed tags */
	  select replace(v_return, '&lt;s&gt;', '<s>') into v_return;
	  select replace(v_return, '&lt;S&gt;', '<s>') into v_return;
	  select replace(v_return, '&lt;/s&gt;', '</s>') into v_return;
	  select replace(v_return, '&lt;/S&gt;', '</s>') into v_return;	
	  /*  other tags */
	  select replace(v_return, '&lt;dd&gt;', '<dd>') into v_return;
	  select replace(v_return, '&lt;DD&gt;', '<dd>') into v_return;
	  select replace(v_return, '&lt;/dd&gt;', '</dd>') into v_return;
	  select replace(v_return, '&lt;/DD&gt;', '</dd>') into v_return;
	  select replace(v_return, '&lt;sup&gt;', '<sup>') into v_return;
	  select replace(v_return, '&lt;SUP&gt;', '<sup>') into v_return;
	  select replace(v_return, '&lt;/sup&gt;', '</sup>') into v_return;
	  select replace(v_return, '&lt;/SUP&gt;', '</sup>') into v_return;
	  select replace(v_return, '&lt;dt&gt;', '<dt>') into v_return;
	  select replace(v_return, '&lt;DT&gt;', '<dt>') into v_return;
	  select replace(v_return, '&lt;/dt&gt;', '</dt>') into v_return;
	  select replace(v_return, '&lt;/DT&gt;', '</dt>') into v_return;	
	  select replace(v_return, '&lt;dl&gt;', '<dl>') into v_return;
	  select replace(v_return, '&lt;DL&gt;', '<dl>') into v_return;
	  select replace(v_return, '&lt;/dl&gt;', '</dl>') into v_return;
	  select replace(v_return, '&lt;/DL&gt;', '</dl>') into v_return;
	  select replace(v_return, '&lt;sub&gt;', '<sub>') into v_return;
	  select replace(v_return, '&lt;SUB&gt;', '<sub>') into v_return;
	  select replace(v_return, '&lt;/sub&gt;', '</sub>') into v_return;
	  select replace(v_return, '&lt;/SUB&gt;', '</sub>') into v_return;
	  select replace(v_return, '&lt;tt&gt;', '<tt>') into v_return;
	  select replace(v_return, '&lt;TT&gt;', '<tt>') into v_return;
	  select replace(v_return, '&lt;/tt&gt;', '</tt>') into v_return;
	  select replace(v_return, '&lt;/TT&gt;', '</tt>') into v_return;
	  select replace(v_return, '&lt;ol&gt;', '<ol>') into v_return;
	  select replace(v_return, '&lt;OL&gt;', '<ol>') into v_return;
	  select replace(v_return, '&lt;/ol&gt;', '</ol>') into v_return;
	  select replace(v_return, '&lt;/OL&gt;', '</ol>') into v_return;
	  select replace(v_return, '&lt;strong&gt;', '<strong>') into v_return;
	  select replace(v_return, '&lt;STRONG&gt;', '<strong>') into v_return;
	  select replace(v_return, '&lt;/strong&gt;', '</strong>') into v_return;
	  select replace(v_return, '&lt;/STRONG&gt;', '</strong>') into v_return;
	  select replace(v_return, '&lt;code&gt;', '<code>') into v_return;
	  select replace(v_return, '&lt;CODE&gt;', '<code>') into v_return;
	  select replace(v_return, '&lt;/code&gt;', '</code>') into v_return;
	  select replace(v_return, '&lt;/CODE&gt;', '</code>') into v_return;	
	  select replace(v_return, '&lt;var&gt;', '<var>') into v_return;
	  select replace(v_return, '&lt;VAR&gt;', '<var>') into v_return;
	  select replace(v_return, '&lt;/var&gt;', '</var>') into v_return;
	  select replace(v_return, '&lt;/VAR&gt;', '</var>') into v_return;
	  select replace(v_return, '&lt;cite&gt;', '<cite>') into v_return;
	  select replace(v_return, '&lt;CITE&gt;', '<cite>') into v_return;
	  select replace(v_return, '&lt;/cite&gt;', '</cite>') into v_return;
	  select replace(v_return, '&lt;/CITE&gt;', '</cite>') into v_return;
	  select replace(v_return, '&lt;dfn&gt;', '<dfn>') into v_return;
	  select replace(v_return, '&lt;DFN&gt;', '<dfn>') into v_return;
	  select replace(v_return, '&lt;/dfn&gt;', '</dfn>') into v_return;
	  select replace(v_return, '&lt;/DFN&gt;', '</dfn>') into v_return;
	  select replace(v_return, '&lt;abbr&gt;', '<abbr>') into v_return;
	  select replace(v_return, '&lt;ABBR&gt;', '<abbr>') into v_return;
	  select replace(v_return, '&lt;/abbr&gt;', '</abbr>') into v_return;
	  select replace(v_return, '&lt;/ABBR&gt;', '</abbr>') into v_return;
	  select replace(v_return, '&lt;acronym&gt;', '<acronym>') into v_return;
	  select replace(v_return, '&lt;ACRONYM&gt;', '<acronym>') into v_return;
	  select replace(v_return, '&lt;/acronym&gt;', '</acronym>') into v_return;
	  select replace(v_return, '&lt;/ACRONYM&gt;', '</acronym>') into v_return;
	  select replace(v_return, '&lt;h1&gt;', '<h1>') into v_return;
	  select replace(v_return, '&lt;H1&gt;', '<h1>') into v_return;
	  select replace(v_return, '&lt;/h1&gt;', '</h1>') into v_return;
	  select replace(v_return, '&lt;/H1&gt;', '</h1>') into v_return;
      select replace(v_return, '&lt;h2&gt;', '<h2>') into v_return;
	  select replace(v_return, '&lt;H2&gt;', '<h2>') into v_return;
	  select replace(v_return, '&lt;/h2&gt;', '</h2>') into v_return;
	  select replace(v_return, '&lt;/H2&gt;', '</h2>') into v_return;
	  select replace(v_return, '&lt;h3&gt;', '<h3>') into v_return;
	  select replace(v_return, '&lt;H3&gt;', '<h3>') into v_return;
	  select replace(v_return, '&lt;/h3&gt;', '</h3>') into v_return;
	  select replace(v_return, '&lt;/H3&gt;', '</h3>') into v_return;
	  select replace(v_return, '&lt;address&gt;', '<address>') into v_return;
	  select replace(v_return, '&lt;ADDRESS&gt;', '<address>') into v_return;
	  select replace(v_return, '&lt;/address&gt;', '</address>') into v_return;
	  select replace(v_return, '&lt;/ADDRESS&gt;', '</address>') into v_return;
	  select replace(v_return, '&lt;big&gt;', '<big>') into v_return;
	  select replace(v_return, '&lt;BIG&gt;', '<big>') into v_return;
	  select replace(v_return, '&lt;/big&gt;', '</big>') into v_return;
	  select replace(v_return, '&lt;/BIG&gt;', '</big>') into v_return;
	  select replace(v_return, '&lt;small&gt;', '<small>') into v_return;
	  select replace(v_return, '&lt;SMALL&gt;', '<small>') into v_return;
	  select replace(v_return, '&lt;/small&gt;', '</small>') into v_return;
	  select replace(v_return, '&lt;/SMALL&gt;', '</small>') into v_return;
	  select replace(v_return, '&lt;strike&gt;', '<strike>') into v_return;
	  select replace(v_return, '&lt;STRIKE&gt;', '<strike>') into v_return;
	  select replace(v_return, '&lt;/strike&gt;', '</strike>') into v_return;
	  select replace(v_return, '&lt;/STRIKE&gt;', '</strike>') into v_return;
	  select replace(v_return, '&lt;blockquote&gt;', '<blockquote>') into v_return;
	  select replace(v_return, '&lt;BLOCKQUOTE&gt;', '<blockquote>') into v_return;
	  select replace(v_return, '&lt;/blockquote&gt;', '</blockquote>') into v_return;
	  select replace(v_return, '&lt;/BLOCKQUOTE&gt;', '</blockquote>') into v_return;
	  select replace(v_return, '&lt;caption&gt;', '<caption>') into v_return;
	  select replace(v_return, '&lt;CAPTION&gt;', '<caption>') into v_return;
	  select replace(v_return, '&lt;/caption&gt;', '</caption>') into v_return;
	  select replace(v_return, '&lt;/CAPTION&gt;', '</caption>') into v_return;
	  select replace(v_return, '&lt;center&gt;', '<center>') into v_return;
	  select replace(v_return, '&lt;CENTER&gt;', '<center>') into v_return;
	  select replace(v_return, '&lt;/center&gt;', '</center>') into v_return;
	  select replace(v_return, '&lt;/CENTER&gt;', '</center>') into v_return;
	  select replace(v_return, '&lt;del&gt;', '<del>') into v_return;
	  select replace(v_return, '&lt;DEL&gt;', '<del>') into v_return;
	  select replace(v_return, '&lt;/del&gt;', '</del>') into v_return;
	  select replace(v_return, '&lt;/DEL&gt;', '</del>') into v_return;
	  select replace(v_return, '&lt;em&gt;', '<em>') into v_return;
	  select replace(v_return, '&lt;EM&gt;', '<em>') into v_return;
	  select replace(v_return, '&lt;/em&gt;', '</em>') into v_return;
	  select replace(v_return, '&lt;/EM&gt;', '</em>') into v_return;
	  select replace(v_return, '&lt;hr&gt;', '<hr>') into v_return;
	  select replace(v_return, '&lt;HR&gt;', '<hr>') into v_return;
	  select replace(v_return, '&lt;ins&gt;', '<ins>') into v_return;
	  select replace(v_return, '&lt;INS&gt;', '<ins>') into v_return;
	  select replace(v_return, '&lt;/ins&gt;', '</ins>') into v_return;
	  select replace(v_return, '&lt;/INS&gt;', '</ins>') into v_return;	  
	  select replace(v_return, '&lt;kbd&gt;', '<kbd>') into v_return;
	  select replace(v_return, '&lt;KBD&gt;', '<kbd>') into v_return;
	  select replace(v_return, '&lt;/kbd&gt;', '</kbd>') into v_return;
	  select replace(v_return, '&lt;/KBD&gt;', '</kbd>') into v_return;	
	  select replace(v_return, '&lt;samp&gt;', '<samp>') into v_return;
	  select replace(v_return, '&lt;SAMP&gt;', '<samp>') into v_return;
	  select replace(v_return, '&lt;/samp&gt;', '</samp>') into v_return;
	  select replace(v_return, '&lt;/SAMP&gt;', '</samp>') into v_return;	
	  select replace(v_return, '&lt;span&gt;', '<span>') into v_return;
	  select replace(v_return, '&lt;SPAN&gt;', '<span>') into v_return;
	  select replace(v_return, '&lt;/span&gt;', '</span>') into v_return;
	  select replace(v_return, '&lt;/SPAN&gt;', '</span>') into v_return;
	  -- Font size tags
	  select replace(v_return, '&lt;font size=1&gt;', '<font size=1>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=1&gt;', '<font size=1>') into v_return;
	  select replace(v_return, '&lt;font size=2&gt;', '<font size=2>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=2&gt;', '<font size=2>') into v_return;
	  select replace(v_return, '&lt;font size=3&gt;', '<font size=3>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=3&gt;', '<font size=3>') into v_return;
	  select replace(v_return, '&lt;font size=4&gt;', '<font size=4>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=4&gt;', '<font size=4>') into v_return;
	  select replace(v_return, '&lt;font size=5&gt;', '<font size=5>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=5&gt;', '<font size=5>') into v_return;
	  select replace(v_return, '&lt;font size=6&gt;', '<font size=6>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=6&gt;', '<font size=6>') into v_return;
	  select replace(v_return, '&lt;font size=7&gt;', '<font size=7>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=7&gt;', '<font size=7>') into v_return;
	  select replace(v_return, '&lt;font size=8&gt;', '<font size=8>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=8&gt;', '<font size=8>') into v_return;
	  select replace(v_return, '&lt;font size=9&gt;', '<font size=9>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=9&gt;', '<font size=9>') into v_return;
	  select replace(v_return, '&lt;font size=10&gt;', '<font size=10>') into v_return;
	  select replace(v_return, '&lt;FONT SIZE=10&gt;', '<font size=10>') into v_return;
	  select replace(v_return, '&lt;/font&gt;', '</font>') into v_return;
	  select replace(v_return, '&lt;/FONT&gt;', '</FONT>') into v_return;
RETURN v_return;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;



CREATE OR REPLACE FUNCTION zspr_getproductprintouttext(p_docline_id character varying, p_language character varying, p_language2 character varying)
  RETURNS character varying AS
$BODY$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE

v_doctype character varying;
v_org character varying;
v_bpartner_id character varying;
v_product_id character varying;
v_orderline_id character varying;
v_invoiceline_id character varying;
v_inoutline_id character varying;

v_printattrsbold  character(1);
v_printattrsnewline  character(1);
v_printpnumberbold  character(1);
v_printpnumbernewline  character(1);
v_printpnamebold   character(1);
v_printpnamenewline  character(1);
v_printvendorpnumberbold   character(1);
v_printvendorpnumbernewline  character(1);
v_printdocnotebold  character(1);
v_printdocnotenewline  character(1);
v_printpdescbold  character(1);
v_printpdescnewline  character(1);
v_printordernumberonshipmentbold  character(1);
v_printordernumberonshipmentnewline  character(1);
v_printordernumberoninvoicebold  character(1);
v_printordernumberoninvoicenewline  character(1);
v_printshipmentnumberoninvoicebold  character(1);
v_printshipmentnumberoninvoicenewline  character(1);
v_printshipmentdateoninvoicebold  character(1);
v_printshipmentdateoninvoicenewline  character(1);
v_printserialnumberondocs character(1);
v_printsetproductwithbom character(1);
v_prefix character varying:='';
v_suffix character varying:='';
v_temp character varying;
v_temp2 character varying;
v_temp3 character varying;
v_tempinout character varying;
v_cur RECORD;
v_return character varying:='';

BEGIN
        select c_doctype, ad_org_id, c_bpartner_id, m_product_id, c_orderline_id, c_invoiceline_id, m_inoutline_id
        into
        v_doctype, v_org, v_bpartner_id, v_product_id, v_orderline_id, v_invoiceline_id, v_inoutline_id
        from (select 'order' as c_doctype, c_orderline.ad_org_id, c_order.c_bpartner_id, c_orderline.m_product_id, p_docline_id as c_orderline_id, null as c_invoiceline_id, null as m_inoutline_id
        from c_orderline, c_order
        where p_docline_id=c_orderline.c_orderline_id and c_order.c_order_id=c_orderline.c_order_id
        union
        select 'invoice' as c_doctype, c_invoiceline.ad_org_id, c_invoice.c_bpartner_id, c_invoiceline.m_product_id, c_invoiceline.c_orderline_id, p_docline_id as c_invoiceline_id, c_invoiceline.m_inoutline_id
        from c_invoiceline, c_invoice
        where p_docline_id=c_invoiceline.c_invoiceline_id and c_invoice.c_invoice_id=c_invoiceline.c_invoice_id
        union
        select 'shipment' as c_doctype, m_inoutline.ad_org_id, m_inout.c_bpartner_id, m_inoutline.m_product_id, m_inoutline.c_orderline_id, null as c_invoiceline_id, p_docline_id as m_inoutline_id
        from m_inoutline, m_inout
        where p_docline_id=m_inoutline.m_inoutline_id and m_inout.m_inout_id=m_inoutline.m_inout_id) a;

        select printattrsbold, printattrsnewline, printpnumberbold, printpnumbernewline,
                printpnamebold, printpnamenewline, printvpnumberbold, printvpnumbernewline,
                printdocnotebold, printdocnotenewline, printpdescbold, printpdescnewline,
                printordernumberonshipmentbold, printordernumberonshipmentnewline, printordernumberoninvoicebold, printordernumberoninvoicenewline,
                printshipmentnumberoninvoicebold, printshipmentnumberoninvoicenewline, printshipmentdateoninvoicebold, printshipmentdateoninvoicenewline,printserialnumberondocs,printsetproductwithbom
    into
                v_printattrsbold, v_printattrsnewline, v_printpnumberbold, v_printpnumbernewline,
                v_printpnamebold, v_printpnamenewline, v_printvendorpnumberbold, v_printvendorpnumbernewline,
                v_printdocnotebold, v_printdocnotenewline, v_printpdescbold, v_printpdescnewline,
                v_printordernumberonshipmentbold, v_printordernumberonshipmentnewline, v_printordernumberoninvoicebold, v_printordernumberoninvoicenewline,
                v_printshipmentnumberoninvoicebold, v_printshipmentnumberoninvoicenewline, v_printshipmentdateoninvoicebold, v_printshipmentdateoninvoicenewline,v_printserialnumberondocs,v_printsetproductwithbom
    from zspr_printinfo where ad_org_id in ('0',v_org) order by ad_org_id desc limit 1;
      --
    for v_cur in (select attrs_ordernum as ordernum, 'attributes' as field from zspr_printinfo where printattrsondocs='Y' and ad_org_id = v_org
                    union
                    select coalesce(pnumber_ordernum,100) as ordernum, 'productnumber' as field from zspr_printinfo where printpnumberondocs='Y' and ad_org_id = v_org
                    union
                    select coalesce(pname_ordernum,200) as ordernum, 'productname' as field from zspr_printinfo where printpnameondocs='Y' and ad_org_id = v_org
                    union
                    select coalesce(vpnumber_ordernum,110) as ordernum, 'vpnumber' as field from zspr_printinfo where printvpnumberondocs='Y' and ad_org_id = v_org
                    union
                    select coalesce(docnote_ordernum,230) as ordernum, 'docnote' as field from zspr_printinfo where printdocnoteondocs='Y' and ad_org_id = v_org
                    union
                    select coalesce(pdesc_ordernum,220) as ordernum, 'productdescription' as field from zspr_printinfo where printpdescondocs='Y' and ad_org_id = v_org
                    union
                    select coalesce(pordnoship_ordernum,120) as ordernum, 'ordernoonshipment' as field from zspr_printinfo where printordernumberonshipment='Y' and ad_org_id = v_org and v_doctype = 'shipment'
                    union
                    select 1000 as ordernum, 'serialnumberondocs' as field from zspr_printinfo where printserialnumberondocs='Y' and ad_org_id = v_org and (v_doctype = 'shipment' or v_doctype = 'invoice')
                    union
                    select coalesce(pordnoinv_ordernum, 130) as ordernum, 'ordernooninvoice' as field from zspr_printinfo where printordernumberoninvoice='Y' and ad_org_id = v_org and v_doctype = 'invoice'
                    union
                    select coalesce(pshipnoinv_ordernum,140) as ordernum, 'shipmentnooninvoice' as field from zspr_printinfo where printshipmentnumberoninvoice='Y' and ad_org_id = v_org and v_doctype = 'invoice'
                    union
                    select coalesce(pshipdateinv_ordernum,90) as ordernum, 'shipmentdateoninvoice' as field from zspr_printinfo where printshipmentdateoninvoice='Y' and ad_org_id = v_org and v_doctype = 'invoice'
                   order by ordernum)
    loop
                if v_cur.field = 'attributes' then
                        -- TODO
                        v_return:=v_return;
                elsif v_cur.field = 'vpnumber' then
                        if v_printvendorpnumberbold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printvendorpnumbernewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        select vendorproductno into v_temp from m_product_po where m_product_id=v_product_id and c_bpartner_id=v_bpartner_id;
                        if v_temp is not null then
                                v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
                        end if;
                        v_prefix:='';
                        v_suffix:='';
                elsif v_cur.field = 'productnumber' then
                        if v_printpnumberbold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printpnumbernewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        select value into v_temp from m_product where m_product_id=v_product_id;
						if v_temp!='~' then
							v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
						end if;
                        v_prefix:='';
                        v_suffix:='';
                elsif v_cur.field = 'productname' then
                        if v_printpnamebold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printpnamenewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        if coalesce(v_printsetproductwithbom,'N')='Y' then
			  if zssi_checkifsetproduct(v_product_id)='Y' then
			    select zssi_getproductname(v_product_id,p_language) into v_temp;
			    select zssi_getproductset_complete(v_product_id,p_language) into v_temp3;
			    v_temp:=v_temp||'<br/>'||'<font size=1>'||v_temp3||'</font>';
			  elseif zssi_checkifsetproduct(v_product_id)='N' then
			    select zssi_getproductname(v_product_id,p_language) into v_temp;
			  end if;
                        else
			  select zssi_getproductname(v_product_id,p_language) into v_temp;
                        end if;
                        v_temp2:=v_temp;
                        if p_language2 is not null then
			    if v_printsetproductwithbom='Y' then
			      if zssi_checkifsetproduct(v_product_id)='Y' then
				select zssi_getproductname(v_product_id,p_language2) into v_temp2;
				select zssi_getproductset_complete(v_product_id,p_language2) into v_temp3;
				v_temp2:=v_temp2||'<br/>'||'<font size=1>'||v_temp3||'</font>';
			      elseif zssi_checkifsetproduct(v_product_id)='N' then
				select zssi_getproductname(v_product_id,p_language2) into v_temp2;
			      end if;
			    elseif v_printsetproductwithbom='N' then
			      select zssi_getproductname(v_product_id,p_language2) into v_temp2;
			    end if;
                        end if;
						if v_temp!='~' then
							if (v_temp2!=v_temp and v_temp!='') then
									v_return:=v_return||v_prefix||v_temp||' '||'<br/>'||v_temp2||' '||v_suffix;
							elsif v_temp!='' then
									v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
							end if;
						end if;	
                        v_prefix:='';
                        v_suffix:='';
                elsif v_cur.field = 'docnote' then
                        if v_printdocnotebold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printdocnotenewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        select documentnote into v_temp from m_product_trl where m_product_id=v_product_id and ad_language=p_language;
                        if v_temp is null then 
                                select documentnote into v_temp from m_product where m_product_id=v_product_id;
                        end if;
                        v_temp:=zssi_2HTML(v_temp);
                        v_temp2:=v_temp;
                        if p_language2 is not null then
                                        select documentnote into v_temp from m_product_trl where m_product_id=v_product_id and ad_language=p_language2;
                                        if v_temp is null then 
                                                select documentnote into v_temp from m_product where m_product_id=v_product_id;
                                        end if;
                        end if;
                        v_temp:=zssi_2HTML(v_temp);
                        if coalesce(v_temp2,'X')!=coalesce(v_temp,'X') then
                                v_return:=v_return||v_prefix||coalesce(v_temp2,'')||' '||'<br/>'||coalesce(v_temp,'')||' '||v_suffix;
                        elsif v_temp is not null then
                                v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
                        end if;
                        v_prefix:='';
                        v_suffix:='';
                elsif v_cur.field = 'productdescription' then
                        if v_printpdescbold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printpdescnewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        select description into v_temp from m_product_trl where m_product_id=v_product_id and ad_language=p_language;
                        if v_temp is null then 
                                select description into v_temp from m_product where m_product_id=v_product_id;
                        end if;
                        v_temp:=zssi_2HTML(v_temp);
                        v_temp2:=v_temp;
                        if p_language2 is not null then
                                        select description into v_temp from m_product_trl where m_product_id=v_product_id and ad_language=p_language2;
                                        if v_temp is null then 
                                                select description into v_temp from m_product where m_product_id=v_product_id;
                                        end if;
                        end if;
                        v_temp:=zssi_2HTML(v_temp);
                        if coalesce(v_temp2,'X')!=coalesce(v_temp,'X') then
                                v_return:=v_return||v_prefix||coalesce(v_temp2,'')||' '||'<br/>'||coalesce(v_temp,'')||' '||v_suffix;
                        elsif v_temp is not null then
                                v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
                        end if;
                        v_prefix:='';
                        v_suffix:='';
        
                elsif v_cur.field = 'ordernoonshipment' then
                        if v_printordernumberonshipmentbold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printordernumberonshipmentnewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        select documentno into v_temp from c_order where c_order.c_order_id=(select c_order_id from c_orderline where c_orderline.c_orderline_id=(select c_orderline_id from m_inoutline where m_inoutline_id=p_docline_id));
                        if v_temp is not null then
                                v_return:=v_return||v_prefix||ad_message_get2('zssi_printordernumberonshipment', p_language)||' '||v_temp||' '||v_suffix;
                        end if;
                        v_prefix:='';
                        v_suffix:='';
                elsif v_cur.field = 'serialnumberondocs' then
                        if v_return!='' then
                              v_prefix:='<br/>'||v_prefix;
                        end if;
         
                       select m_inoutline_id into v_tempinout from c_invoiceline where c_invoiceline_id=p_docline_id;
                         if v_temp is not null then
                          if v_doctype='shipment' then
                               v_return:=v_return||v_prefix||zspr_getserialnumbersfrominout(p_docline_id, p_language)||v_suffix;
                               elsif v_doctype='invoice' then
                              v_return:=v_return||v_prefix||zspr_getserialnumbersfrominout(v_tempinout, p_language)||v_suffix;
			end if;
			end if;

                        v_prefix:='';
                        v_suffix:='';

                elsif v_cur.field = 'ordernooninvoice' then
                        if v_printordernumberoninvoicebold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printordernumberoninvoicenewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        select documentno into v_temp from c_order where c_order.c_order_id=(select c_order_id from c_orderline where c_orderline.c_orderline_id=(select c_orderline_id from c_invoiceline where c_invoiceline_id=p_docline_id));
                        if v_temp is not null then
                                v_return:=v_return||v_prefix||ad_message_get2('zssi_printordernumberoninvoice', p_language)||' '||v_temp||' '||v_suffix;
                        end if;
                        v_prefix:='';
                        v_suffix:='';                      
        
                elsif v_cur.field = 'shipmentnooninvoice' then
                        if v_printshipmentnumberoninvoicebold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printshipmentnumberoninvoicenewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        select documentno into v_temp from m_inout where m_inout.m_inout_id=(select m_inout_id from m_inoutline where m_inoutline.m_inoutline_id=(select m_inoutline_id from c_invoiceline where c_invoiceline_id=p_docline_id));
                        if v_temp is not null then
                                v_return:=v_return||v_prefix||ad_message_get2('zssi_printshipmentnumberoninvoice', p_language)||' '||v_temp||' '||v_suffix;
                        end if;
                        v_prefix:='';
                        v_suffix:='';
        
                elsif v_cur.field = 'shipmentdateoninvoice' then
                        if v_printshipmentdateoninvoicebold='Y' then 
                                v_prefix:='<font size=2>';
                                v_suffix:='</font>';
                        end if;
                        if v_printshipmentdateoninvoicenewline='Y' then
                                if v_return!='' then
                                        v_prefix:='<br/>'||v_prefix;
                                end if;
                        end if;
                        select zssi_strdate(movementdate, p_language) into v_temp from m_inout where m_inout.m_inout_id=(select m_inout_id from m_inoutline where m_inoutline.m_inoutline_id=(select m_inoutline_id from c_invoiceline where c_invoiceline_id=p_docline_id));
                        if v_temp is not null then
                                v_return:=v_return||v_prefix||ad_message_get2('zssi_printshipmentdateoninvoice', p_language)||' '||v_temp||' '||v_suffix;
                        end if;
                        v_prefix:='';
                        v_suffix:='';
        
                end if;         
    end loop;
        v_return:=v_return||zssi_getframecontracttext(p_docline_id, p_language , p_language2);
	if (v_return='') then
		RETURN '';
	else
		RETURN v_return||'<br/>';
	end if;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zssi_getframecontracttext(p_docline_id character varying, p_language character varying, p_language2 character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2014 Stefan Zimmermann All Rights Reserved.
Contributor(s): 
***************************************************************************************************************************************************

*****************************************************/
DECLARE
v_return character varying:='';
v_count numeric;
v_frameline_id character varying;
v_docno character varying;
v_begin character varying;
v_end character varying;
v_remains character varying;
v_frameqty character varying;

BEGIN
      select orderlineselfjoin into v_frameline_id from c_orderline where c_orderline_id=p_docline_id;
      if v_frameline_id is not null then
            -- Is a Frame-Contract ?
            select count(*) into v_count from c_order o,c_orderline ol where ol.c_orderline_id=v_frameline_id and ol.c_order_id=o.c_order_id and o.c_doctype_id in ('56913A519BA94EB59DAE5BF9A82F5F7D','559A80F2E27742D4B2C476045F5C834F')  and o.docstatus='CO';
            if v_count=1 then
              select o.documentno,coalesce(to_char(o.contractdate,'dd.mm.yyyy'),''), coalesce(to_char(o.enddate,'dd.mm.yyyy'),''),to_char(ol.qtyordered-coalesce(ol.calloffqty,0)),to_char(ol.qtyordered) 
              into v_docno,v_begin,v_end,v_remains,v_frameqty from c_order o,c_orderline ol where ol.c_order_id=o.c_order_id and ol.c_orderline_id=v_frameline_id;
              v_return:='<br/>Abruf aus Rahmenvertrag Nr.'||v_docno||'<br/>Zeitraum: '||v_begin||' bis '||v_end||'<br/>Vereinbarter Rahmen: '||v_frameqty||'<br/>Nach diesem Abruf verbleibende Menge: '||v_remains;
            end if;
      end if;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;


CREATE OR REPLACE FUNCTION zssi_getproductprintouttext(p_product_id character varying, p_language character varying, p_language2 character varying, p_org character varying, p_bpartner_id character varying)
  RETURNS character varying AS
$BODY$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE

v_printattrsbold  character(1);
v_printattrsnewline  character(1);
v_printpnumberbold  character(1);
v_printpnumbernewline  character(1);
v_printpnamebold   character(1);
v_printpnamenewline  character(1);
v_printvendorpnumberbold   character(1);
v_printvendorpnumbernewline  character(1);
v_printdocnotebold  character(1);
v_printdocnotenewline  character(1);
v_printpdescbold  character(1);
v_printpdescnewline  character(1);
v_org character varying;
v_prefix character varying:='';
v_suffix character varying:='';
v_temp character varying;
v_temp2 character varying;
v_cur RECORD;

v_return character varying:='';
BEGIN
      select ad_org_id,printattrsbold ,printattrsnewline ,printpnumberbold ,printpnumbernewline   ,printpnamebold ,
             printpnamenewline   ,printvpnumberbold  ,printvpnumbernewline ,
             printdocnotebold,printdocnotenewline,printpdescbold,printpdescnewline
      into
             v_org,v_printattrsbold ,v_printattrsnewline, v_printpnumberbold ,v_printpnumbernewline ,v_printpnamebold ,
             v_printpnamenewline, v_printvendorpnumberbold  ,v_printvendorpnumbernewline ,
             v_printdocnotebold,v_printdocnotenewline,v_printpdescbold,v_printpdescnewline
      from zspr_printinfo where ad_org_id in ('0',p_org) order by ad_org_id desc limit 1;
      --
      for v_cur in (select attrs_ordernum as ordernum,'attributes' as field from zspr_printinfo where printattrsondocs='Y' and ad_org_id = v_org
                    union
                    select pnumber_ordernum as ordernum,'productnumber' as field from zspr_printinfo where printpnumberondocs='Y' and ad_org_id = v_org
                    union
                    select pname_ordernum as ordernum,'productname' as field from zspr_printinfo where printpnameondocs='Y' and ad_org_id = v_org
                    union
                    select vpnumber_ordernum  as ordernum,'vpnumber' as field from zspr_printinfo where printvpnumberondocs='Y' and ad_org_id = v_org
                    union
                    select docnote_ordernum  as ordernum,'docnote' as field from zspr_printinfo where printdocnoteondocs='Y' and ad_org_id = v_org
                    union
                    select pdesc_ordernum  as ordernum,'productdescription' as field from zspr_printinfo where printpdescondocs='Y' and ad_org_id = v_org
                    order by ordernum)
      loop
         if v_cur.field = 'attributes' then
           -- TODO
           v_return:=v_return;
         elsif v_cur.field = 'vpnumber' then
               if v_printvendorpnumberbold='Y' then 
                  v_prefix:='<font size=2>';
                  v_suffix:='</font>';
               end if;
               if v_printvendorpnumbernewline='Y' then
                   if v_return!='' then
                      v_prefix:='<br/>'||v_prefix;
                   end if;
               end if;
               select vendorproductno into v_temp from m_product_po where m_product_id=p_product_id and c_bpartner_id=p_bpartner_id;
               if v_temp!=null then
                   v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
               end if;
               v_prefix:='';
               v_suffix:='';
         elsif v_cur.field = 'productnumber' then
               if v_printpnumberbold='Y' then 
                  v_prefix:='<font size=2>';
                  v_suffix:='</font>';
               end if;
               if v_printpnumbernewline='Y' then
                   if v_return!='' then
                      v_prefix:='<br/>'||v_prefix;
                   end if;
               end if;
               select value into v_temp from m_product where m_product_id=p_product_id;
               v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
               v_prefix:='';
               v_suffix:='';
         elsif v_cur.field = 'productname' then
               if v_printpnamebold='Y' then 
                  v_prefix:='<font size=2>';
                  v_suffix:='</font>';
               end if;
               if v_printpnamenewline='Y' then
                   if v_return!='' then
                      v_prefix:='<br/>'||v_prefix;
                   end if;
               end if;
               select zssi_getproductname(p_product_id,p_language) into v_temp;
               v_temp2:=v_temp;
               if p_language2 is not null then
                   select zssi_getproductname(p_product_id,p_language2) into v_temp2;
               end if;
               if v_temp2!=v_temp then
                  v_return:=v_return||v_prefix||v_temp||' '||'<br/>'||v_temp2||' '||v_suffix;
               else
                  v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
               end if;
               v_prefix:='';
               v_suffix:='';
         elsif v_cur.field = 'docnote' then
               if v_printdocnotebold='Y' then 
                  v_prefix:='<font size=2>';
                  v_suffix:='</font>';
               end if;
               if v_printdocnotenewline='Y' then
                   if v_return!='' then
                      v_prefix:='<br/>'||v_prefix;
                   end if;
               end if;
               select documentnote into v_temp from m_product_trl where m_product_id=p_product_id and ad_language=p_language;
               if v_temp is null then 
                   select documentnote into v_temp from m_product where m_product_id=p_product_id;
               end if;
               v_temp:=zssi_2HTML(v_temp);
               v_temp2:=v_temp;
               if p_language2 is not null then
                    select documentnote into v_temp from m_product_trl where m_product_id=p_product_id and ad_language=p_language2;
                    if v_temp is null then 
                        select documentnote into v_temp from m_product where m_product_id=p_product_id;
                    end if;
               end if;
               v_temp:=zssi_2HTML(v_temp);
               if coalesce(v_temp2,'X')!=coalesce(v_temp,'X') then
                  v_return:=v_return||v_prefix||coalesce(v_temp2,'')||' '||'<br/>'||coalesce(v_temp,'')||' '||v_suffix;
               elsif v_temp is not null then
                  v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
               end if;
               v_prefix:='';
               v_suffix:='';
         elsif v_cur.field = 'productdescription' then
               if v_printpdescbold='Y' then 
                  v_prefix:='<font size=2>';
                  v_suffix:='</font>';
               end if;
               if v_printpdescnewline='Y' then
                   if v_return!='' then
                      v_prefix:='<br/>'||v_prefix;
                   end if;
               end if;
               select description into v_temp from m_product_trl where m_product_id=p_product_id and ad_language=p_language;
               if v_temp is null then 
                   select description into v_temp from m_product where m_product_id=p_product_id;
               end if;
               v_temp:=zssi_2HTML(v_temp);
               v_temp2:=v_temp;
               if p_language2 is not null then
                    select description into v_temp from m_product_trl where m_product_id=p_product_id and ad_language=p_language2;
                    if v_temp is null then 
                        select description into v_temp from m_product where m_product_id=p_product_id;
                    end if;
               end if;
               v_temp:=zssi_2HTML(v_temp);
               if coalesce(v_temp2,'X')!=coalesce(v_temp,'X') then
                  v_return:=v_return||v_prefix||coalesce(v_temp2,'')||' '||'<br/>'||coalesce(v_temp,'')||' '||v_suffix;
               elsif v_temp is not null then
                  v_return:=v_return||v_prefix||v_temp||' '||v_suffix;
               end if;
               v_prefix:='';
               v_suffix:='';
         end if;         
      end loop;
      RETURN v_return||'<br/>';
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getproductprintouttext(character varying, character varying, character varying, character varying, character varying) OWNER TO postgres;


CREATE OR REPLACE FUNCTION zspr_getserialnumbersfrominout(p_inoutline_id character varying,p_language character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying:=' ';
v_return1 character varying:=' ';
v_pretext character varying;
v_pretext2 character varying;
v_cur RECORD;
BEGIN
      select ad_message_get2('zssi_serialnumbers', p_language) into v_pretext;
      select zssi_getElementTextByColumname('lotnumber',p_language) into v_pretext2;
      for v_cur in (select serialnumber,lotnumber,quantity from snr_minoutline where m_inoutline_id=p_inoutline_id)
      LOOP
        if v_return!=' ' then
           v_return:=v_return||',';
        end if;
        v_return:=v_return||coalesce(v_cur.serialnumber,' ');
         if v_return1!=' ' then
        v_return1:=v_return1||';';
        end if;
        v_return1:=v_return1||coalesce(v_cur.lotnumber,' ')||' '||zssi_getElementTextByColumname('Amountp',p_language)||': '||coalesce(v_cur.quantity,1);
      END LOOP; 
--RETURN v_pretext||v_return||'<br/>'||v_pretext2||': '||v_return1;
RETURN v_pretext2||': '||v_return1;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
  

  
  
CREATE OR REPLACE FUNCTION zssi_getlocationcity(p_location_id character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
BEGIN
      select c_location_id into v_location_id from c_bpartner_location where c_bpartner_location_id=p_location_id;
      select city into v_return from c_location where c_location_id=v_location_id;
     
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;



CREATE OR REPLACE FUNCTION zssi_getlocationcountry(p_location_id character varying, lang character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
v_country_id character varying;
BEGIN
      select c_location_id into v_location_id from c_bpartner_location where c_bpartner_location_id=p_location_id;
      select c_country_id into v_country_id from c_location where c_location_id=v_location_id;
      select name into v_return from c_country_trl where c_country_id=v_country_id and ad_language=lang;
      if v_return is null then
          select name into v_return from c_country where c_country_id=v_country_id;
      end if;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getlocationcountry(character varying, character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_getlocationline1(p_location_id character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
BEGIN
      select c_location_id into v_location_id from c_bpartner_location where c_bpartner_location_id=p_location_id;
      select address1 into v_return from c_location where c_location_id=v_location_id;
     
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getlocationline1(character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_getlocationline2(p_location_id character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
BEGIN
      select c_location_id into v_location_id from c_bpartner_location where c_bpartner_location_id=p_location_id;
      select address2 into v_return from c_location where c_location_id=v_location_id;
     
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getlocationline2(character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_getlocationpostal(p_location_id character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
BEGIN
      select c_location_id into v_location_id from c_bpartner_location where c_bpartner_location_id=p_location_id;
      select postal into v_return from c_location where c_location_id=v_location_id;
     
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getlocationpostal(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getcityfromwarehouse(p_warehouse_id character varying,p_onlywhendiffersfromorg  character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
v_orgid  character varying;
v_compare1 character varying;
v_compare2  character varying;
BEGIN
      select c_location_id,ad_org_id into v_location_id,v_orgid from m_warehouse where m_warehouse_id=p_warehouse_id;
      select city into v_return from c_location where c_location_id=v_location_id;
      if coalesce(p_onlywhendiffersfromorg,'N')='Y' then
         select address1 into v_compare1 from c_location where c_location_id=(select c_location_id from ad_orginfo where ad_org_id=v_orgid);
         select address1 into v_compare2  from c_location where c_location_id=v_location_id;
         if coalesce(v_compare1,'x')=coalesce(v_compare2,'y') then
            v_return:=null;
         end if;
      end if;
RETURN v_return;
END;
$_$ LANGUAGE plpgsql VOLATILE COST 100;


CREATE OR REPLACE FUNCTION zssi_getcountryfromwarehouse(p_warehouse_id character varying, lang character varying,p_onlywhendiffersfromorg  character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
v_country_id character varying;
v_orgid  character varying;
v_compare1 character varying;
v_compare2  character varying;
BEGIN
      select c_location_id,ad_org_id into v_location_id,v_orgid from m_warehouse where m_warehouse_id=p_warehouse_id;
      select c_country_id into v_country_id from c_location where c_location_id=v_location_id;
      select name into v_return from c_country_trl where c_country_id=v_country_id and ad_language=lang;
      if v_return is null then
          select name into v_return from c_country where c_country_id=v_country_id;
      end if;
      if coalesce(p_onlywhendiffersfromorg,'N')='Y' then
         select address1 into v_compare1 from c_location where c_location_id=(select c_location_id from ad_orginfo where ad_org_id=v_orgid);
         select address1 into v_compare2  from c_location where c_location_id=v_location_id;
         if coalesce(v_compare1,'x')=coalesce(v_compare2,'y') then
            v_return:=null;
         end if;
      end if;
RETURN v_return;
END;
$_$ LANGUAGE plpgsql VOLATILE COST 100;


CREATE OR REPLACE FUNCTION zssi_getlocline1fromwarehouse(p_warehouse_id character varying,p_onlywhendiffersfromorg  character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
v_orgid  character varying;
v_compare1 character varying;
v_compare2  character varying;
BEGIN
      select c_location_id,ad_org_id into v_location_id,v_orgid from m_warehouse where m_warehouse_id=p_warehouse_id;
      select address1 into v_return from c_location where c_location_id=v_location_id;
      if coalesce(p_onlywhendiffersfromorg,'N')='Y' then
         select address1 into v_compare1 from c_location where c_location_id=(select c_location_id from ad_orginfo where ad_org_id=v_orgid);
         select address1 into v_compare2  from c_location where c_location_id=v_location_id;
         if coalesce(v_compare1,'x')=coalesce(v_compare2,'y') then
            v_return:=null;
         end if;
      end if;
     
RETURN v_return;
END;
$_$ LANGUAGE plpgsql VOLATILE COST 100;



CREATE OR REPLACE FUNCTION zssi_getlocline2fromwarehouse(p_warehouse_id character varying,p_onlywhendiffersfromorg  character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
v_orgid  character varying;
v_compare1 character varying;
v_compare2  character varying;
BEGIN
      select c_location_id,ad_org_id into v_location_id,v_orgid from m_warehouse where m_warehouse_id=p_warehouse_id;
      select address2 into v_return from c_location where c_location_id=v_location_id;
      if coalesce(p_onlywhendiffersfromorg,'N')='Y' then
         select address1 into v_compare1 from c_location where c_location_id=(select c_location_id from ad_orginfo where ad_org_id=v_orgid);
         select address1 into v_compare2  from c_location where c_location_id=v_location_id;
         if coalesce(v_compare1,'x')=coalesce(v_compare2,'y') then
            v_return:=null;
         end if;
      end if;
RETURN v_return;
END;
$_$ LANGUAGE plpgsql VOLATILE COST 100;



CREATE OR REPLACE FUNCTION zssi_getpostalfromwarehouse(p_warehouse_id character varying,p_onlywhendiffersfromorg  character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
v_orgid  character varying;
v_compare1 character varying;
v_compare2  character varying;
BEGIN
      select c_location_id,ad_org_id into v_location_id,v_orgid from m_warehouse where m_warehouse_id=p_warehouse_id;
      select postal into v_return from c_location where c_location_id=v_location_id;
      if coalesce(p_onlywhendiffersfromorg,'N')='Y' then
         select address1 into v_compare1 from c_location where c_location_id=(select c_location_id from ad_orginfo where ad_org_id=v_orgid);
         select address1 into v_compare2  from c_location where c_location_id=v_location_id;
         if coalesce(v_compare1,'x')=coalesce(v_compare2,'y') then
            v_return:=null;
         end if;
      end if;
     
RETURN v_return;
END;
$_$ LANGUAGE plpgsql VOLATILE COST 100;


CREATE OR REPLACE FUNCTION zssi_getpaymentterm(p_paymentterm_id character varying, lang character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select documentnote into v_return from c_paymentterm_trl where c_paymentterm_id=p_paymentterm_id and ad_language=lang;
      if v_return is null then
          select documentnote into v_return from c_paymentterm where c_paymentterm_id=p_paymentterm_id;
      end if;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getpaymentterm(character varying, character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_getlocationeori(p_location_id character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select eoriidentification into v_return from c_bpartner_location where c_bpartner_location_id=p_location_id;
     
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getlocationeori(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getincoterms(p_incoterms_id character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select description into v_return from c_incoterms where c_incoterms_id=p_incoterms_id;    
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getincoterms(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getshipper(p_shipper_id character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select description into v_return from m_shipper where m_shipper_id=p_shipper_id;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getshipper(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getdeliverymethod(p_deliveryviarule character varying, lang character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_ref_list_id character varying;
BEGIN
      v_return:=zssi_getListRefText('152', p_deliveryviarule,lang);
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getdeliverymethod(p_deliveryviarule character varying, lang character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getpaytermdiscdesc(v_discount_id character varying, lang character varying) RETURNS character varying
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
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_temp numeric;
BEGIN
    select netdays into v_temp from zsfi_discount where zsfi_discount_id=v_discount_id;
        if v_temp > 999 then
            if lang='de_DE' then
                        select ('Zahlbarer Betrag') into v_return;
                end if;
                if v_return is null then
                        select ('For payment') into v_return;
                end if;
        end if;
        if v_temp < 1000 then
                if lang='de_DE' then
                        select ('Zahlb. Betrag innerh. von ' || to_char(netdays) || ' Tagen') into v_return from zsfi_discount where zsfi_discount_id=v_discount_id;
                end if;
                if v_return is null then
                        select ('For payment within ' || to_char(netdays) || ' days') into v_return from zsfi_discount where zsfi_discount_id=v_discount_id;
                end if;
        end if;

RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getpaytermdiscdesc(character varying, character varying) OWNER TO tad;



CREATE OR REPLACE FUNCTION zssi_getpaytermdisc(v_discount_id character varying) RETURNS numeric 
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
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return numeric;
BEGIN
      select percentage into v_return from zsfi_discount where zsfi_discount_id=v_discount_id;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getpaytermdisc(character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_getpaymethod(p_paymentrule character varying, p_deliveryrule character varying, lang character varying) RETURNS character varying 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_temp1 character varying;
v_temp2 character varying;
v_ref_list_id character varying;
BEGIN
          select ad_ref_list_id into v_ref_list_id from ad_ref_list where value=p_paymentrule and ad_reference_id='195';      
          select name into v_temp1 from ad_ref_list_trl where ad_ref_list_id=v_ref_list_id and ad_language=lang;
      if v_temp1 is null then
          select name into v_temp1 from ad_ref_list where value=p_paymentrule and ad_reference_id='195';
      end if;
          if p_deliveryrule = 'R' then
              select ad_ref_list_id into v_ref_list_id from ad_ref_list where value=p_deliveryrule and ad_reference_id='151';      
              select name into v_temp2 from ad_ref_list_trl where ad_ref_list_id=v_ref_list_id and ad_language=lang;
          if v_temp2 is null then
              select name into v_temp2 from ad_ref_list where value=p_deliveryrule and ad_reference_id='151';
          end if;
                  select (v_temp1 || ' / ' || v_temp2) into v_return;
          else 
          select v_temp1 into v_return;   
          end if; 
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getpaymethod(character varying, character varying, character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_printconf_trg() RETURNS trigger 
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
  select count(*) into v_count from zspr_printinfo where zspr_printinfo.ad_org_id=new.ad_org_id;
  if v_count > 0  then
      RAISE EXCEPTION '%', '@zssi_OnlyOneDS@';
  end if;
  RETURN NEW;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_printconf_trg() OWNER TO tad;

DROP TRIGGER zssi_printconf_trg ON zspr_printinfo;
CREATE TRIGGER zssi_printconf_trg
  BEFORE INSERT
  ON zspr_printinfo
  FOR EACH ROW
  EXECUTE PROCEDURE zssi_printconf_trg();

CREATE or replace FUNCTION zssi_gettax(p_tax_id character varying,lang character varying) RETURNS character varying
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
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select taxhint into v_return from c_tax_trl where c_tax_id=p_tax_id and ad_language=lang;
      if v_return is null then 
          select taxhint into v_return from c_tax where c_tax_id=p_tax_id;
      end if;
RETURN v_return;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_gettax(v_tax_id character varying,lang character varying) OWNER TO tad;

CREATE or replace FUNCTION zssi_gettaxdescription(p_tax_id character varying,lang character varying) RETURNS character varying
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
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select description into v_return from c_tax_trl where c_tax_id=p_tax_id and ad_language=lang;
      if v_return is null then 
          select description into v_return from c_tax where c_tax_id=p_tax_id;
      end if;
RETURN v_return;
END;
$_$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
ALTER FUNCTION zssi_gettaxdescription(v_tax_id character varying,lang character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getlocationcountryid(p_location_id character varying, lang character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
BEGIN
      select c_location_id into v_location_id from c_bpartner_location where c_bpartner_location_id=p_location_id;
      select c_country_id into v_return from c_location where c_location_id=v_location_id;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getlocationcountryid(character varying, character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getexportterm(p_location_id character varying, p_doctype_id character varying, lang character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_location_id character varying;
v_country_id character varying;
v_tradearea_id character varying;
v_isordertext character varying;
v_isshipmentext character varying;
v_isinvoicetext character varying;
BEGIN
      select c_location_id into v_location_id from c_bpartner_location where c_bpartner_location_id=p_location_id;
      select c_country_id into v_country_id from c_location where c_location_id=v_location_id;
          select zssi_tradearea_id into v_tradearea_id from zssi_tradearea_country where c_country_id=v_country_id;
          select isordertext into v_isordertext from zssi_tradearea where zssi_tradearea_id=v_tradearea_id;
          select isshipmentext into v_isshipmentext from zssi_tradearea where zssi_tradearea_id=v_tradearea_id;
          select isinvoicetext into v_isinvoicetext from zssi_tradearea where zssi_tradearea_id=v_tradearea_id;
          if (p_doctype_id='5D5792C53FBA46E2988653B6DC9FE5B4' and v_isordertext='Y') or (p_doctype_id='F7C859920B904536A9CCF3A84729AA52' and v_isshipmentext='Y') or (p_doctype_id='45A90145C74C44ECB48AC772B05487CA' and v_isinvoicetext='Y') then
                select text into v_return from zssi_tradearea_trl where zssi_tradearea_id=v_tradearea_id and ad_language=lang;
                if v_return is null then
                        select text into v_return from zssi_tradearea where zssi_tradearea_id=v_tradearea_id;
                end if;
          end if;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getexportterm(character varying, character varying, character varying) OWNER TO tad;


/*-------------------------------------------------------------------------------------------------------------------------------------------------


Implementation of Textmodules




-------------------------------------------------------------------------------------------------------------------------------------------------------------*/



CREATE OR REPLACE FUNCTION zspr_getorderlinesfromshipment(p_inout_id character varying) RETURNS SETOF c_orderline 
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************

Print Open Shipments only on Regular documents (Not Vendor or Customer return) 

*****************************************************/
DECLARE
ret_orderline c_orderline%rowtype;
v_inoutline m_inoutline%rowtype;
v_order_id character varying;
v_org_id character varying;
v_movementtype character varying;
BEGIN
        select ad_org_id,movementtype into v_org_id,v_movementtype from m_inout where m_inout.m_inout_id=p_inout_id;
        IF ((select printopenshipments from zspr_printinfo where ad_org_id=v_org_id) = 'Y') and v_movementtype in ('V+','C-') then
                FOR v_inoutline in (select * from m_inoutline where m_inoutline.m_inout_id = p_inout_id)
                LOOP
                        select c_order_id into v_order_id from c_orderline where c_orderline_id=v_inoutline.c_orderline_id;
                        FOR ret_orderline in (select * from c_orderline where c_orderline.c_order_id = v_order_id)
                        LOOP
                                IF (ret_orderline.qtyordered - ret_orderline.qtydelivered != 0) and ret_orderline.c_orderline_id not in (select c_orderline_id from m_inoutline where m_inoutline.m_inout_id=p_inout_id) THEN
                                        RETURN NEXT ret_orderline;
                                END IF;
                        END LOOP;
                END LOOP;
        END IF;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION zspr_getorderlinesfromshipment(character varying) OWNER TO tad;



CREATE OR REPLACE FUNCTION zssi_textmodulemod_trg() RETURNS trigger LANGUAGE plpgsql AS $_$ 
BEGIN
   new.ismodified='Y';
   return new;
END ; $_$;


drop trigger zssi_order_textmodule_trg on zssi_order_textmodule;

CREATE TRIGGER zssi_order_textmodule_trg
  BEFORE UPDATE
  ON zssi_order_textmodule
  FOR EACH ROW
  EXECUTE PROCEDURE zssi_textmodulemod_trg();


drop trigger zssi_invoice_textmodule_trg on zssi_invoice_textmodule;

CREATE TRIGGER zssi_invoice_textmodule_trg
  BEFORE UPDATE
  ON zssi_invoice_textmodule
  FOR EACH ROW
  EXECUTE PROCEDURE zssi_textmodulemod_trg();

drop trigger zssi_minout_textmodule_trg on zssi_minout_textmodule;

CREATE TRIGGER zssi_minout_textmodule_trg
  BEFORE UPDATE
  ON zssi_minout_textmodule
  FOR EACH ROW
  EXECUTE PROCEDURE zssi_textmodulemod_trg();


CREATE or replace FUNCTION zssi_getTextModule(v_doctypeid character varying,v_pos numeric, lang character varying,p_org character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Get Text Modules from Database
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_id      character varying;
v_otext    character varying;
BEGIN
  select zssi_textmodule_id,text into v_id,v_otext from zssi_textmodule where v_doctypeid=c_doctype_id and isactive='Y' and position=v_pos and ad_org_id in ('0',p_org) order by ad_org_id desc LIMIT 1;
  select text into v_return from zssi_textmodule_trl where zssi_textmodule_id=v_id and ad_language=lang;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    else
     v_return:= null;
    end if;
  end if;
RETURN coalesce(v_return,'');
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;


CREATE or replace FUNCTION zssi_getTextModuleTranslated(v_textmoduleid character varying,lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Get Text Modules from Database - Get direct and translated
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying;
v_otext    character varying;
BEGIN
  select text into v_otext from zssi_textmodule where zssi_textmodule_id=v_textmoduleid;
  select text into v_return from zssi_textmodule_trl where zssi_textmodule_id=v_textmoduleid and ad_language=lang;
  if v_return is null then
    if v_otext is not null then
     v_return:= v_otext;
    else
     v_return:= null;
    end if;
  end if;
RETURN coalesce(v_return,'');
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;


CREATE or replace FUNCTION zssi_getTextModuleFromDoc(v_record_id character varying,v_recordtype character varying, v_islower character varying,lang character varying) RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Get Text Modules from Database - 
 Individual Textmodules on Orders, Invoices, M-inout
*****************************************************/
DECLARE
-- Simple Types
v_return  character varying:='';
v_recordident    character varying;
v_table  character varying;
v_bottomtext character varying;
TYPE_Ref REFCURSOR;
v_cursor TYPE_Ref%TYPE;
v_cur RECORD;
BEGIN
  if v_recordtype='ORDER' then 
      v_table:='zssi_order_textmodule'; 
      v_recordident:='c_order_id';
  elsif v_recordtype='INVOICE' then 
      v_table:='zssi_invoice_textmodule'; 
      v_recordident:='c_invoice_id';
  elsif v_recordtype='SHIPMENT' then 
      v_table:='zssi_minout_textmodule'; 
      v_recordident:='m_inout_id';
  end if;
  if v_recordtype='ORDER' and v_islower='Y' then 
      select deliverynotes into v_bottomtext from c_order where c_order_id=v_record_id;
      if v_bottomtext is not null then
            if v_return!=''  then v_return:=v_return||E'\r\n'; end if;
            v_return:=v_return||v_bottomtext;
      end if;
  end if;
  OPEN v_cursor FOR EXECUTE 'select * from '||v_table||' where '||v_recordident||'='||chr(39)||v_record_id||chr(39)||' and islower='||chr(39)||v_islower||chr(39)||' order by line';
        LOOP
          FETCH v_cursor INTO v_cur;
          EXIT WHEN NOT FOUND;
          if v_return!='' then v_return:=v_return||E'\r\n'; end if;
          if v_cur.ismodified='Y' or  v_cur.zssi_textmodule_id is null then 
            v_return:=v_return||coalesce(v_cur.text,'');
          else
            v_return:=v_return||zssi_getTextModuleTranslated(v_cur.zssi_textmodule_id,lang);
          end if;
        END LOOP;
  CLOSE v_cursor;
RETURN coalesce(v_return,'');
END;
$_$ LANGUAGE 'plpgsql' VOLATILE COST 100;

CREATE OR REPLACE FUNCTION zssi_getsubscriptionfrequence(p_order_id character varying, lang character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
v_invoicefrequence character varying;
BEGIN
      select invoicefrequence into v_invoicefrequence from c_order where c_order_id=p_order_id;
	  select zssi_getListRefText('F17BFE71276743BBB6105EE61D9FD666', v_invoicefrequence, lang) into v_return;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getsubscriptionfrequence(character varying, character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_getinoutrefs(p_order_id character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers, Danny A. Heuduk.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Getting all M_INOUTS from an order as Link
*****************************************************/
DECLARE
v_return character varying:='';
v_inout m_inout%rowtype;
BEGIN

for v_inout in (select * from m_inout where m_inout.c_order_id = p_order_id)
loop
  v_return := v_return ||'<a href="#" onclick="submitCommandChangingName('''||v_inout.m_inout_id||''','||''''||'..//GoodsReceipt/Header_Edition.html'''||', '||'''inpmInoutId''); return false;">'||v_inout.documentno||'</a><br />';
end loop;

RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getinoutrefs(character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_getinvoicelink(p_invoice_id character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers, Danny A. Heuduk.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Generating PurchaseInvoice as Link
*****************************************************/
DECLARE
v_return character varying:='';
v_invoice c_invoice%rowtype;
BEGIN
for v_invoice in (select * from c_invoice where c_invoice.c_invoice_id = p_invoice_id)
loop
  v_return := v_return ||'<a href="#" onclick="submitCommandChangingName('''||v_invoice.c_invoice_id||''','||''''||'..//PurchaseInvoice/Header_Relation.html'''||', '||'''inpcInvoiceId''); return false;">'||v_invoice.documentno||'</a><br />';
end loop;

RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getinvoicelink(character varying) OWNER TO tad;


CREATE OR REPLACE FUNCTION zssi_getorderlink(p_order_id character varying) RETURNS character varying 
AS $_$ 
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
v_return character varying:='';
v_order c_order%rowtype;
BEGIN
for v_order in (select * from c_order where c_order.c_order_id = p_order_id)
loop
  v_return := v_return ||'<a href="#" onclick="submitCommandChangingName('''||v_order.c_order_id||''','||''''||'..//PurchaseOrder/Header_Edition.html'''||', '||'''inpcOrderId''); return false;">'||v_order.documentno||'</a><br />';
end loop;

RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zssi_getorderlinelink(p_orderline_id character varying) RETURNS character varying 
AS $_$ 
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
v_return character varying:='';
v_docno varchar;
BEGIN
select documentno into v_docno from c_order where c_order.c_order_id = (select c_order_id from c_orderline where c_orderline_id=p_orderline_id);
v_return := v_return ||'<a class="LabelLink" href="#" onclick="submitCommandChangingName('''||p_orderline_id||''','||''''||'../SalesOrder/Lines_Edition.html'''||', '||'''inpcOrderlineId''); return false;">'||v_docno||'</a>';

RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zssi_getptasklink(p_task_id character varying) RETURNS character varying 
AS $_$ 
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
v_return character varying:='';
v_docno varchar;
BEGIN
select name into v_docno from c_projecttask where  c_projecttask_id=p_task_id;
  v_return := v_return ||'<a class="LabelLink" href="#" onclick="submitCommandChangingName('''||p_task_id||''','||''''||'../org.openbravo.zsoft.serprod.ProductionOrder/WorkSteps035860BB9D4F4D08878CED2F371D7201_Edition.html'''||', '||'''inpzssmWorkstepVId''); return false;">'||v_docno||'</a>';

RETURN coalesce(v_return,'');
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zssi_getinvoicelinkhesir(p_invoice_id character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers, Danny A. Heuduk.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Generating PurchaseInvoice as Link
*****************************************************/
DECLARE
v_return character varying:='';
v_invoice c_invoice%rowtype;
BEGIN
for v_invoice in (select * from c_invoice where c_invoice.c_invoice_id = p_invoice_id)
loop
  v_return := v_return ||'<b>'||v_invoice.poreference||'</b>';
end loop;

RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getinvoicelinkhesir(character varying) OWNER TO tad;

CREATE or replace FUNCTION zss_genhtmllink(p_targetwindowurl character varying,p_id character varying,p_ltext character varying) returns character varying
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
  
  RETURN '<INPUT type="hidden" name="inpKeyName" value="inpcInvoiceId"><a href="#" onclick="submitCommandFormParameter('||chr(39)||'DIRECT'||chr(39)||','||'document.frmMain.inpcInvoiceId'||','||chr(39)||p_id||chr(39)||', false, document.frmMain, '||chr(39)||'../'||p_targetwindowurl||chr(39)||', null, false, true);return false;" class="LabelLink">'||p_ltext||' </a>';
END;
$_$  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

CREATE OR REPLACE FUNCTION zssi_getinvoicelinkhepir(p_invoice_id character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers, Danny A. Heuduk.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Generating PurchaseInvoice as Link
*****************************************************/
DECLARE
v_return character varying:='';
v_invoice c_invoice%rowtype;
BEGIN
for v_invoice in (select * from c_invoice where c_invoice.c_invoice_id = p_invoice_id)
loop
  v_return := v_return ||'<b>'||v_invoice.poreference||'</b>';
end loop;

RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getinvoicelinkhepir(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getinvoicelinkhesid(p_invoice_id character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers, Danny A. Heuduk.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Generating PurchaseInvoice as Link
*****************************************************/
DECLARE
v_return character varying:='';
v_invoice c_invoice%rowtype;
BEGIN
for v_invoice in (select * from c_invoice where c_invoice.c_invoice_id = p_invoice_id)
loop
  v_return := v_return ||'<b>'||v_invoice.documentno||'</b>';
end loop;

RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getinvoicelinkhesid(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getinvoicelinkhepid(p_invoice_id character varying) RETURNS character varying 
AS $_$ 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): Frank Wohlers, Danny A. Heuduk.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
Generating PurchaseInvoice as Link
*****************************************************/
DECLARE
v_return character varying:='';
v_invoice c_invoice%rowtype;
BEGIN
for v_invoice in (select * from c_invoice where c_invoice.c_invoice_id = p_invoice_id)
loop
  v_return := v_return ||'<b>'||v_invoice.documentno||'</b>';
end loop;

RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getinvoicelinkhepid(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getuserfax(v_user character varying)
  RETURNS character varying AS
$BODY$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
      select fax into v_return from ad_user where ad_user_id=v_user;
RETURN coalesce(v_return,'');
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getuserfax(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getdelaydesign(milestone numeric)
RETURNS character varying AS
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
v_return character varying:='';

BEGIN
v_return := (SELECT CASE WHEN milestone is null THEN ''
	    WHEN milestone<=4 THEN '<span style="color:white;background-color:green; border-radius:25px;">ok</span>'
	    WHEN milestone<=9 THEN '<span style="border:1px; border-radius:25px; color:white;background-color:#faa61a;">&nbsp;i&nbsp;</span>'
	    ELSE '<span style="color:white;background-color:red; border-radius:25px;">&nbsp;x&nbsp;</span>'
       END);
  
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getdelaydesign(numeric) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getnodelaydesign(milestone numeric)
RETURNS character varying AS
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
v_return character varying:='';

BEGIN
v_return := (SELECT CASE WHEN milestone is null THEN ''
	    WHEN milestone<=4 THEN 'ok'
	    WHEN milestone<=9 THEN '&nbsp;i&nbsp;'
	    ELSE '&nbsp;x&nbsp;'
       END);
  
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getnodelaydesign(numeric) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getoverviewdesign(p_status character varying, p_ref_id character varying)
RETURNS character varying AS
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
v_return character varying:='';

BEGIN
v_return := (SELECT CASE 
	    WHEN p_status= '10' AND p_ref_id = 'BBFB55FDBAA64C0EB46F026460AE8285' THEN '<span style="color:white;background-color:green;border:2px solid; border-radius:25px;">'|| (SELECT zssi_getlistreftext(p_ref_id, p_status, 'de_DE')) ||'</span>'
	    WHEN p_status= 'as planned' AND p_ref_id = '7C374D10EA044BE3B252D6654A7AA5E1' THEN '<span style="color:white;background-color:green;border:2px solid; border-radius:25px;">'||(SELECT zssi_getlistreftext(p_ref_id , p_status, 'de_DE'))||'</span>'
	    WHEN p_status= 'in budget ' AND p_ref_id = '76CDE2B245D44726AE30457453FF622E' THEN '<span style="color:white;background-color:green;border:2px solid; border-radius:25px;">'||(SELECT zssi_getlistreftext(p_ref_id , p_status, 'de_DE'))||'</span>'
	    WHEN p_status=  '20' AND p_ref_id = 'BBFB55FDBAA64C0EB46F026460AE8285'  THEN '<span style="border:1px; border-radius:25px; color:white;background-color:#faa61a;border:2px solid; border-radius:25px;">'||(SELECT zssi_getlistreftext('BBFB55FDBAA64C0EB46F026460AE8285', p_status, 'de_DE')) ||'</span>'
	    WHEN p_status= 'resources' AND p_ref_id = '7C374D10EA044BE3B252D6654A7AA5E1' THEN '<span style="border:1px; border-radius:25px; color:white;background-color:#faa61a; border:2px solid;border-radius:25px;">'||(SELECT zssi_getlistreftext(p_ref_id , p_status, 'de_DE'))||'</span>'
	    WHEN p_status= 'costs' AND p_ref_id = '76CDE2B245D44726AE30457453FF622E' THEN '<span style="border:1px; border-radius:25px; color:white;background-color:#faa61a;border:2px solid; border-radius:25px;">'||(SELECT zssi_getlistreftext(p_ref_id , p_status, 'de_DE'))||'</span>'
	    WHEN p_status= '30' AND p_ref_id = 'BBFB55FDBAA64C0EB46F026460AE8285' THEN '<span style="color:white;background-color:red;border:2px solid; border-radius:25px;">'||(SELECT zssi_getlistreftext('BBFB55FDBAA64C0EB46F026460AE8285', p_status, 'de_DE')) ||'</span>'
	    WHEN p_status= 'crit. resources' AND p_ref_id = '7C374D10EA044BE3B252D6654A7AA5E1' THEN '<span style="color:white;background-color:red;border:2px solid; border-radius:25px;">'||(SELECT zssi_getlistreftext(p_ref_id , p_status, 'de_DE'))||'</span>'
	    WHEN p_status= 'crit. costs' AND p_ref_id = '76CDE2B245D44726AE30457453FF622E' THEN '<span style="color:white;background-color:red;border:2px solid; border-radius:25px;">'||(SELECT zssi_getlistreftext(p_ref_id , p_status, 'de_DE'))||'</span>'
	    ELSE p_status
       END);
  
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getoverviewdesign(character varying, character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_juwiorgshortcut(p_org_id character varying)
RETURNS character varying AS
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
Juwi Specific Shortcuts
*****************************************************/
DECLARE
v_return character varying:='';

BEGIN
v_return := (SELECT CASE WHEN p_org_id is null THEN ''
	    WHEN p_org_id='AE3637495E9E4EBFA7E766FE9B97893A' THEN 'JMM'
	    WHEN p_org_id='0A42B068B99A48DB90ADA791D0E9F2D4' THEN 'ayeQ'
	    ELSE (select name from ad_org where p_org_id = ad_org_id)
       END);
  
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_juwiorgshortcut(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_docshortcut(p_document_id character varying)
RETURNS character varying AS
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
Juwi Specific Shortcuts
*****************************************************/
DECLARE
v_return character varying:='';

BEGIN
v_return := (SELECT CASE WHEN p_document_id is null THEN ''
	    WHEN p_document_id = 'B342FD5CA1C64E8BA25A0A6F6C98C7DA' THEN 'PO'
	    WHEN p_document_id = '6557A8E827ED40BDAE66E4A78166A839' THEN 'offer'
	    WHEN p_document_id = '5D5792C53FBA46E2988653B6DC9FE5B4' THEN 'ord'
	    WHEN p_document_id = '45A90145C74C44ECB48AC772B05487CA' THEN 'inv'
	    ELSE (select name from c_doctype where p_document_id = c_doctype_id)
       END);
  
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_docshortcut(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getbpname (p_bpartner_id character varying) RETURNS character varying 
AS $_$ 
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
v_return character varying;
BEGIN
select name into v_return from c_bpartner where c_bpartner_id=p_bpartner_id;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION zssi_getbpname(character varying) OWNER TO tad;

CREATE OR REPLACE FUNCTION zssi_getworkstepname (p_workstep_id VARCHAR)
RETURNS VARCHAR AS
$body$
-- SELECT zssi_getworkstepname('E4169A63B193416F88D91905D4776B55');
-- DECLARE 
BEGIN
  RETURN COALESCE((SELECT pt.name FROM c_projecttask pt WHERE pt.c_projecttask_id = p_workstep_id),'');
END ;
$body$
LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION zssi_getinvdoc_link(p_document_id character varying, p_documentno character varying)
RETURNS character varying AS
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
Juwi Specific Shortcuts
*****************************************************/
DECLARE
v_return character varying:='';

BEGIN
v_return := v_return||'<a id="idfieldCInvoiceId" class="LabelLink_noicon" onmouseout="window.status='''';return true;" onmouseover="window.status=''Attach'';return true;" onclick="openPopUp(''../businessUtility/TabAttachments_FS.html?inpKey='||p_document_id||'&inpEditable=N&inpTabId=290&inpwindowId=183'',''dummy'',400,600,null,null,null,null,null,null,null,null);return false;" href="#"><span>'||p_documentno||' </span>';
  
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
  
  
  
  
CREATE OR REPLACE FUNCTION zssi_getmaterialplandivergencetext(p_task in varchar) 
RETURNS character varying AS
$_$ 
DECLARE
v_return character varying:=chr(13);
v_cur record;
BEGIN
for v_cur in (select 'Abweichung: '||(select rpad(name,60,' ') from m_product where bl.m_product_id=m_product.m_product_id)||': Soll:'|| bl.quantity || ' Ist:'||
                    bl.qtyreceived as val from zspm_projecttaskbom_view bl where bl.c_projecttask_id=p_task
                    and bl.quantity!=bl.qtyreceived)
LOOP
    v_return := v_return||v_cur.val||chr(13);
END LOOP;
RETURN v_return;
END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
  

select zsse_dropfunction('zssi_getmissingqty_complete');
CREATE or replace FUNCTION zssi_getmissingqty_complete() RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localization in Database - The better way
Get missing qtys
*****************************************************/
DECLARE
v_line character varying;
v_cur record;
v_cur2 record;
v_product_id character varying;

BEGIN
FOR v_cur2 in (select m_product.m_product_id as v_id,sum(coalesce(m_product_org.stockmin,0)) as v_min,
               sum(coalesce(m_product_org.stockmin,0)-m_bom_qty_onhand(m_product.m_product_id,null,m_locator.m_locator_id)) as v_need 
               from m_product_org,m_product, m_locator,m_warehouse 
where m_product_org.isactive='Y' 
and m_product_org.m_product_id=m_product.m_product_id 
and m_product_org.m_locator_id=m_locator.m_locator_id 
and m_locator.m_warehouse_id=m_warehouse.m_warehouse_id 
and coalesce(m_product_org.stockmin,0)>m_bom_qty_onhand(m_product.m_product_id,null,m_locator.m_locator_id)
group by m_product.m_product_id)
LOOP

FOR v_cur in (select m_warehouse.name as v_warehouse,m_product.value||' -'||m_product.name as v_product
from m_product_org,m_product, m_locator,m_warehouse 
where m_product_org.isactive='Y' 
and m_product.m_product_id=v_cur2.v_id
and (v_cur2.v_need)>coalesce((select sum(qtyordered-qtydelivered) from c_orderline, c_order where c_order.issotrx='N' and c_order.docstatus='CO' and c_orderline.c_order_id=c_order.c_order_id and c_orderline.m_product_id=v_cur2.v_id group by c_orderline.m_product_id),0)
and m_product_org.m_product_id=m_product.m_product_id 
and m_product_org.m_locator_id=m_locator.m_locator_id 
and m_locator.m_warehouse_id=m_warehouse.m_warehouse_id 
group by  m_warehouse.name,m_product.value,m_product.name)
  LOOP
  v_line:=coalesce(v_line,'')||chr(10)||'Artikel '||chr(32)||v_cur.v_product||chr(32)||'in Lager'||chr(32)||v_cur.v_warehouse||chr(32)||'ist der Mindestbestand von'||chr(32)||to_number(v_cur2.v_min)||chr(32)||'um '||chr(32)||to_number(v_cur2.v_need)||chr(32)||'unterschritten.'||chr(10);
  END LOOP;
  END LOOP;
return v_line;
  END;
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;


select zsse_dropfunction('zssi_checkifmissingqty');
CREATE or replace FUNCTION zssi_checkifmissingqty() RETURNS character varying
AS $_$
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2011 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
Part of Smartprefs
Localozation in Database - The better way
*****************************************************/
DECLARE
v_return character varying;
BEGIN
select zssi_getmissingqty_complete() into v_return;
if (v_return is not null and date_part('hour',now())>=9) then
RETURN coalesce((select c_workcalender_id from c_workcalender where (trunc(workdate)=trunc(now()))) ,'N');
else
RETURN (select c_workcalender_id from c_workcalender where trunc(workdate)=trunc(now()-1));
end if;
END
$_$
  LANGUAGE plpgsql VOLATILE
  COST 100;
  

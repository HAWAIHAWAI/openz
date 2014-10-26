CREATE OR REPLACE FUNCTION ad_TabFieldgetLeadingEmptyCols(p_field_id character varying)
  RETURNS numeric AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2014 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
****************************************************/
v_issame   character varying;
v_seq numeric;
v_cols numeric;
v_tab  character varying;
leadings numeric:=0;
BEGIN
  select COLSTOTAL, issameline ,seqno,ad_tab_id  into v_cols,v_issame,v_seq,v_tab from ad_field_v where ad_field_v_id=p_field_id;
  if v_issame='N' then return 0; end if;
  select COLSTOTAL, issameline ,seqno into v_cols,v_issame,v_seq from ad_field_v where ad_tab_id=v_tab and  seqno<v_seq order by seqno desc limit 1;
  if v_cols<=2 then leadings:=1; end if;
 -- if v_cols=1 then leadings:=2; end if;
  return leadings;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
  
  
CREATE OR REPLACE FUNCTION ad_datatype_guiengine_template_mapping(p_datatype_id varchar)
  RETURNS varchar AS
$BODY$ DECLARE 
    v_return varchar;
begin
     -- mapping
     /*
     select name,value from ad_ref_list where ad_reference_id=(select ad_reference_id from ad_reference where name='Field Template types');
         name         |        value               ad_reference_id          
----------------------+----------------------
 RADIOBUTTON          | RADIOBUTTON
 NOEDIT_TEXTBOX       | NOEDIT_TEXTBOX
 EURO                 | EURO                           | Amount           | 12
 CHECKBOX             | CHECKBOX                       | YesNo            | 20
 LISTSORTER           | LISTSORTER
 FIELDGROUP           | FIELDGROUP
 URL                  | URL                            | Link             | 800101
 TEXTAREA_EDIT_SIMPLE | TEXTAREA_EDIT_SIMPLE           | Text             | 14
 INTEGER              | INTEGER                        | Integer          | 11
 MULTISELECTOR        | MULTISELECTOR
 POPUPSEARCH          | POPUPSEARCH                    | Search           | 30
 TEXT                 | TEXT                           | String           | 10
 EMPTYLINE            | EMPTYLINE
 REFCOMBO             | REFCOMBO                       TableDir,Table,List 17, 18, 19
 LISTSORTER_SIMPLE    | LISTSORTER_SIMPLE
 BUTTON               | BUTTON                         | Button           | 28
 PRICE                | PRICE                          | Price            | 800008
 DATE                 | DATE                           | Date             | 15
 IMAGE                | IMAGE                          | Image BLOB       | 4AA6C3BE9D3B4D84A3B80489505A23E5
 LABEL                | LABEL
 TEXTAREA_EDIT_ADV    | TEXTAREA_EDIT_ADV
 DECIMAL              | DECIMAL                        | Quantity         | 29
 Binary                                                                   | 23
 ID                                                                       | 13
 
(22 rows)
*/
  select  case  p_datatype_id when '12'      then 'EURO' 
                              when '20'      then 'CHECKBOX'
                              when '800101'  then 'URL'
                              when '14'      then 'NOEDIT_TEXTBOX'
                              when '11'     then  'INTEGER'
                              when '30'     then  'POPUPSEARCH'
                              when '10'     then  'TEXT'
                              when '28'     then 'BUTTON'
                              when '800008' then 'PRICE'
                              when '15'     then 'DATE'
                              when '4AA6C3BE9D3B4D84A3B80489505A23E5' then 'IMAGE'
                              when '22' then 'DECIMAL'
                              when '17' then 'REFCOMBO'
                              when '18' then 'REFCOMBO'
                              when '19' then 'REFCOMBO'
                              when '13' then 'IDFIELD'
                              when '35' then 'PATTRIBUTE'
                              when '24' then 'TIME'
                              
                              
          end into v_return;
  return v_return;
end;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
 
select zsse_dropfunction('ad_getcustomcolumns');
CREATE OR REPLACE FUNCTION ad_getcustomcolumns(p_tab_id character varying,pType  out varchar,PName out varchar)
RETURNS SETOF RECORD AS
$BODY$ DECLARE 
v_cur record;
v_ref varchar;
v_name varchar;
BEGIN
    for v_cur in (select ad_customcolumn_id from ad_customfield where ad_tab_id = p_tab_id)
    LOOP
        select ad_reference_id,columnname into v_ref,v_name from ad_customcolumn where ad_customcolumn_id=v_cur.ad_customcolumn_id;
        if v_ref='15' then
           pType:='TIMESTAMP';
        else
            if v_ref='12' then
                pType:='NUMERIC';
            else
                pType:='STRING';
            end if;
        end if;
        PName:=v_name;
        RETURN NEXT;
    END LOOP;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_dropfunction('ad_gridSelectFromGroup');
CREATE OR REPLACE FUNCTION ad_gridSelectFromGroup(p_group_id character varying,p_autoheader character varying, pad_element_id out varchar,pad_reference_id out varchar,
                                                  pAD_REF_GROUP_ID out varchar,pAD_REF_GRIDCOLUMN_ID out varchar,
                                                  pname out varchar,pTEMPLATE out varchar,pREFERENCEURL out varchar,ponchangeevent out varchar,
                                                  pcolreference out varchar,pAD_TABLE_ID out varchar,pCOLSPAN out numeric,pMAXLENGTH out numeric,pREQUIRED out varchar,
                                                  pREADONLY out varchar,pISSECONDHEADER out varchar,pISINHEADER out varchar,pISSPLITGROUP out varchar,
                                                  pincludesemptyitem out varchar,pLine out numeric)
RETURNS SETOF RECORD AS
$BODY$ DECLARE 
v_cur record;
BEGIN
 if p_autoheader = 'Y' then
    for v_cur in (SELECT b.AD_REF_GRIDCOLUMN_id,coalesce(i.line,b.line) as line,
                       coalesce(i.ad_element_id,b.ad_element_id) as ad_element_id,b.ad_reference_id as ad_reference_id,b.AD_REF_GROUP_ID,
                       coalesce(i.name,b.NAME) as name,'HEADER' as TEMPLATE,null as REFERENCEURL, null as onchangeevent,
                       null as colreference,null as AD_TABLE_ID,
                       coalesce(i.colspan,b.COLSPAN) as colspan,coalesce(i.maxlength,b.MAXLENGTH) as maxlength,
                       b.REQUIRED,b.READONLY,'N' as ISSECONDHEADER,'Y' as ISINHEADER,'N' as ISSPLITGROUP,b.includesemptyitem
                       from AD_REF_GRIDCOLUMN b
                       left join ad_ref_gridcolumninstance i on i.AD_REF_GRIDCOLUMN_id=b.AD_REF_GRIDCOLUMN_id and i.isactive='Y'
                       where b.AD_REF_GROUP_id= p_group_id  and b.isactive='Y' 
                  UNION ALL
                  SELECT b.AD_REF_GRIDCOLUMN_id,coalesce(i.line,b.line) as line,
                       coalesce(i.ad_element_id,b.ad_element_id) as ad_element_id,b.ad_reference_id,b.AD_REF_GROUP_ID,
                       b.NAME as name,coalesce(i.template,b.template) as TEMPLATE,
                       coalesce(i.REFERENCEURL,b.REFERENCEURL) as REFERENCEURL, coalesce(i.onchangeevent,b.onchangeevent) as onchangeevent,
                       coalesce(i.colreference,b.colreference) as colreference,coalesce(i.AD_TABLE_ID,b.AD_TABLE_ID) as AD_TABLE_ID,
                       coalesce(i.colspan,b.COLSPAN) as colspan,coalesce(i.maxlength,b.MAXLENGTH) as maxlength,
                       coalesce(i.REadonly,b.readonly) READONLY ,
                       case when coalesce(i.REQUIRED,b.required)='NON' then b.required else coalesce(i.REQUIRED,b.required) end  as required,
                       'N' as ISSECONDHEADER,'N' as ISINHEADER,'N' as ISSPLITGROUP,
                       case when coalesce(i.includesemptyitem,b.includesemptyitem)='NON' then b.includesemptyitem else coalesce(i.includesemptyitem,b.includesemptyitem) end as includesemptyitem
                       from AD_REF_GRIDCOLUMN b left join ad_ref_gridcolumninstance i on i.AD_REF_GRIDCOLUMN_id=b.AD_REF_GRIDCOLUMN_id and i.isactive='Y'
                       where b.AD_REF_GROUP_id= p_group_id  and b.isactive='Y' )
    LOOP
        pad_element_id:=v_cur.ad_element_id;
        pad_reference_id:=v_cur.ad_reference_id;
        pAD_REF_GROUP_ID:=v_cur.AD_REF_GROUP_ID;
        pAD_REF_GRIDCOLUMN_ID:=v_cur.AD_REF_GRIDCOLUMN_ID;
        pname:=v_cur.name;
       -- pHEADERTEXT:=v_cur.HEADERTEXT;
        pTEMPLATE:=v_cur.TEMPLATE;
        pREFERENCEURL:=v_cur.REFERENCEURL;
        ponchangeevent:=v_cur.onchangeevent;
        pcolreference:=v_cur.colreference;
        pAD_TABLE_ID:=v_cur.AD_TABLE_ID;
        pCOLSPAN:=v_cur.COLSPAN;
        pMAXLENGTH:=v_cur.MAXLENGTH;
        pREQUIRED:=v_cur.REQUIRED;
        pREADONLY:=v_cur.READONLY;
        pISSECONDHEADER:=v_cur.ISSECONDHEADER;
        pISINHEADER:=v_cur.ISINHEADER;
        pISSPLITGROUP:=v_cur.ISSPLITGROUP;
        pincludesemptyitem:=v_cur.includesemptyitem;
        pLine:=v_cur.Line;
        RETURN NEXT;
    END LOOP;
  else
    for v_cur in (SELECT b.AD_REF_GRIDCOLUMN_id,coalesce(i.line,b.line) as line,
                       coalesce(i.ad_element_id,b.ad_element_id) as ad_element_id,b.ad_reference_id,b.AD_REF_GROUP_ID,
                       coalesce(i.name,b.NAME) as name,coalesce(i.headertext,b.HEADERTEXT) as headertext,coalesce(i.template,b.template) as TEMPLATE,
                       coalesce(i.REFERENCEURL,b.REFERENCEURL) as REFERENCEURL, coalesce(i.onchangeevent,b.onchangeevent) as onchangeevent,
                       coalesce(i.colreference,b.colreference) as colreference,coalesce(i.AD_TABLE_ID,b.AD_TABLE_ID) as AD_TABLE_ID,
                       coalesce(i.colspan,b.COLSPAN) as colspan,coalesce(i.maxlength,b.MAXLENGTH) as maxlength,
                       coalesce(i.REadonly,b.readonly) READONLY ,
                       case when coalesce(i.REQUIRED,b.required)='NON' then b.required else coalesce(i.REQUIRED,b.required) end  as required,
                       case when coalesce(i.ISSECONDHEADER,b.ISSECONDHEADER)='NON' then b.ISSECONDHEADER else coalesce(i.ISSECONDHEADER,b.ISSECONDHEADER) end as ISSECONDHEADER,
                       case when coalesce(i.ISINHEADER,b.ISINHEADER)='NON' then b.ISINHEADER else coalesce(i.ISINHEADER,b.ISINHEADER) end as ISINHEADER,
                       case when coalesce(i.ISSPLITGROUP,b.ISSPLITGROUP)='NON' then b.ISSPLITGROUP else coalesce(i.ISSPLITGROUP,b.ISSPLITGROUP) end as ISSPLITGROUP,
                       case when coalesce(i.includesemptyitem,b.includesemptyitem)='NON' then b.includesemptyitem else coalesce(i.includesemptyitem,b.includesemptyitem) end as includesemptyitem
                       from AD_REF_GRIDCOLUMN b left join ad_ref_gridcolumninstance i on i.AD_REF_GRIDCOLUMN_id=b.AD_REF_GRIDCOLUMN_id and i.isactive='Y'
                       where b.AD_REF_GROUP_id= p_group_id  and b.isactive='Y')
    LOOP
        pad_element_id:=v_cur.ad_element_id;
        pad_reference_id:=v_cur.ad_reference_id;
        pAD_REF_GROUP_ID:=v_cur.AD_REF_GROUP_ID;
        pAD_REF_GRIDCOLUMN_ID:=v_cur.AD_REF_GRIDCOLUMN_ID;
        pname:=v_cur.name;
        --pHEADERTEXT:=v_cur.HEADERTEXT;
        pTEMPLATE:=v_cur.TEMPLATE;
        pREFERENCEURL:=v_cur.REFERENCEURL;
        ponchangeevent:=v_cur.onchangeevent;
        pcolreference:=v_cur.colreference;
        pAD_TABLE_ID:=v_cur.AD_TABLE_ID;
        pCOLSPAN:=v_cur.COLSPAN;
        pMAXLENGTH:=v_cur.MAXLENGTH;
        pREQUIRED:=v_cur.REQUIRED;
        pREADONLY:=v_cur.READONLY;
        pISSECONDHEADER:=v_cur.ISSECONDHEADER;
        pISINHEADER:=v_cur.ISINHEADER;
        pISSPLITGROUP:=v_cur.ISSPLITGROUP;
        pincludesemptyitem:=v_cur.includesemptyitem;
        pLine:=v_cur.Line;
        RETURN NEXT;
    END LOOP;
 end if;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;


select zsse_dropfunction('ad_selecttabfields');
CREATE OR REPLACE FUNCTION ad_selecttabfields(in_language varchar,in_tab_id character varying,pad_element_id out varchar,pfieldgroupid out varchar,
                           pfieldreference out varchar,pislinebreak out varchar,pAD_REF_FIELDCOLUMN_ID out varchar,pname out varchar,pname2 out varchar,
                           pTEMPLATE out varchar,pREFERENCEURL out varchar,ponchangeevent out varchar,pAD_TABLE_ID out varchar,pCOLSTOTAL out varchar,
                           pMAXLENGTH out numeric,pleadingemptycols out numeric,pBUTTONCLASS out varchar,ptranslation out varchar,
                           pincludesemptyitem out varchar,pAD_ValRule_ID out varchar,pstyle out varchar,pline out numeric)
RETURNS SETOF RECORD AS
$BODY$ DECLARE 
v_cur record;
v_indset record;
v_count numeric;
v_breakcount numeric:=0;
BEGIN
  for v_cur in (SELECT f.ad_fieldgroup_id ,c.ad_element_id, c.columnname as NAME,'' as NAME2,
                (select case when mo.MappingName is null then null else 'reloadCallout(this.name,'||chr(39)||'..'||mo.MappingName||chr(39)||');' end from ad_model_object_mapping mo, ad_model_object m,ad_callout co where co.ad_callout_id=coalesce(f.ad_callout_id,c.ad_callout_id) and co.ad_callout_id=m.ad_callout_id and mo.ad_model_object_id=m.ad_model_object_id limit 1) as ONCHANGEEVENT, 
                f.seqno as LINE,
                c.ad_val_rule_id,f.issameline as islinebreak,f.includesemptyitem, f.ad_field_v_id as AD_REF_FIELDCOLUMN_ID, c.ad_reference_value_id as ad_reference_id,
                case when c.isencrypted='Y' then 'PASSWORD'::varchar else coalesce(f.template,ad_datatype_guiengine_template_mapping(c.AD_REFERENCE_ID)) end as TEMPLATE, 
                coalesce(f.buttonclass,'process'::varchar) as buttonclass, 
                case when lower(c.columnname)='createfrom' and in_tab_id='328' then 'logClick(document.getElementById('||chr(39)||c.columnname||chr(39)||'));' else '' end || --save bankstatemnet before create lines
                case when lower(c.columnname)='createfrom' then 'openServletNewWindow('||chr(39)||'BUTTONCreateFrom'||chr(39)||', true, '||chr(39)||replace(replace(replace(replace(replace(t.name,' ',''),'-',''),')',''),'(',''),'/','')||
                                                                       case when t.ad_module_id='0' then '' else t.ad_tab_id end 
                                               ||'_Edition.html'|| chr(39)||', '||chr(39)||'BUTTON'||chr(39)||', null, true, 600, 900)'
                     when lower(c.columnname)='posted' then 'openServletNewWindow('||chr(39)||'BUTTONPosted'||chr(39)||', true, '||chr(39)||replace(replace(replace(replace(replace(t.name,' ',''),'-',''),')',''),'(',''),'/','')||
                                                                       case when t.ad_module_id='0' then '' else t.ad_tab_id end 
                                               ||'_Edition.html'|| chr(39)||', '||chr(39)||'BUTTON'||chr(39)||', null, true, 600, 900)'
                else
                    case when p.isdirectservletcall='N' then 
                        case when p.uipattern='S' then 'openServletNewWindow('||chr(39)||'BUTTON'||c.columnname||p.ad_process_id||chr(39)||', true, '||chr(39)||replace(replace(replace(replace(replace(t.name,' ',''),'-',''),')',''),'(',''),'/','')||
                                                                            case when t.ad_module_id='0' then '' else t.ad_tab_id end 
                                                    ||'_Edition.html'|| chr(39)||', '||chr(39)||'BUTTON'||chr(39)||', null, true, 600, 900)'
                                                else 'openServletNewWindow('||chr(39)||'DEFAULT'||chr(39)||', true, '||chr(39)||'..'||mo.MappingName||chr(39)||', '||chr(39)||'BUTTON'||chr(39)||', '||chr(39)||p.ad_process_id||chr(39)||', true,600, 900)' 
                        end 
                    else
                        'submitCommandForm('||chr(39)||'DEFAULT'||chr(39)||', true,null, '||chr(39)||'..'||mo.MappingName||chr(39)||', '||chr(39)||'appFrame'||chr(39)||', false, true)' 
                    end
                end as REFERENCEURL, 
                coalesce(f.fieldreference,c.ad_reference_value_id) as FIELDREFERENCE, 
                case when c.AD_REFERENCE_ID='19' and f.tablereference is null then (SELECT ad_table_id from ad_table where lower(tablename)=lower(substr(c.columnname,1,length(c.columnname)-3))) 
                     else f.tablereference end as AD_TABLE_ID, 
                     ad_TabFieldgetLeadingEmptyCols(f.ad_field_v_id) as LEADINGEMPTYCOLS, 
                f.COLSTOTAL, 
                coalesce(f.maxlength,c.fieldlength) as MAXLENGTH,  ''::varchar as STYLE,
                zssi_getTabFieldTextByID(f.ad_field_v_id,in_language) as translation
                from ad_tab t,ad_column_v c   left join ad_field_v f on f.ad_column_v_id=c.ad_column_v_id
                                            left join ad_process p on coalesce(f.ad_process_id,c.ad_process_id)=p.ad_process_id
                                            left join ad_model_object mm on p.ad_process_id=mm.ad_process_id and mm.ad_model_object_id = (select x1.ad_model_object_id from ad_model_object x1 where x1.ad_process_id=p.ad_process_id order by isdefault desc limit 1)
                                            left join ad_model_object_mapping mo on mo.ad_model_object_id=mm.ad_model_object_id and mo.ad_model_object_mapping_id = (select x2.ad_model_object_mapping_id from ad_model_object_mapping x2 where x2.ad_model_object_id=mm.ad_model_object_id order by isdefault desc limit 1)
                where  t.ad_tab_id=f.ad_tab_id and t.AD_tab_ID = in_tab_id
                and c.isactive='Y'
                and f.isactive='Y'
                and c.ad_reference_id!='23' order by line)
  LOOP
    select count(*) into v_count from ad_fieldinstance where AD_field_v_ID=v_cur.AD_REF_FIELDCOLUMN_ID;
    if v_count>0 then
        for v_indset in  (select *   from  ad_fieldinstance where AD_field_v_ID=v_cur.AD_REF_FIELDCOLUMN_ID)
        LOOP
            pfieldgroupid:=coalesce(v_indset.ad_fieldgroup_id,v_cur.ad_fieldgroup_id);
            pfieldreference:=coalesce(v_indset.fieldreference,v_cur.fieldreference);
            pislinebreak:=case when coalesce(v_indset.issameline,v_cur.islinebreak)='NON' then v_cur.islinebreak else coalesce(v_indset.issameline,v_cur.islinebreak) end;
            pTEMPLATE:=coalesce(v_indset.template,v_cur.template);
            pREFERENCEURL:=coalesce(v_indset.REFERENCEURL,v_cur.REFERENCEURL);
            ponchangeevent:=coalesce(v_indset.onchangeevent,v_cur.onchangeevent);
            pAD_TABLE_ID:=coalesce(v_indset.AD_TABLE_ID,v_cur.AD_TABLE_ID);
            pCOLSTOTAL:=coalesce(v_indset.COLSTOTAL,v_cur.COLSTOTAL);
            pMAXLENGTH:=coalesce(v_indset.MAXLENGTH,v_cur.MAXLENGTH);
            pBUTTONCLASS:=coalesce(v_indset.BUTTONCLASS,v_cur.BUTTONCLASS);
            pincludesemptyitem:=case when coalesce(v_indset.includesemptyitem,v_cur.includesemptyitem)='NON' then v_cur.includesemptyitem else coalesce(v_indset.includesemptyitem,v_cur.includesemptyitem) end;
            pAD_ValRule_ID:=coalesce(v_indset.AD_Val_Rule_ID,v_cur.AD_Val_Rule_ID);
            pstyle:=coalesce(v_indset.style,v_cur.style);
            pline:=coalesce(v_indset.line,v_cur.line);
        end loop;
    else
        pfieldgroupid:=v_cur.ad_fieldgroup_id;
        pfieldreference:=v_cur.fieldreference;
        pislinebreak:=v_cur.islinebreak;
        pTEMPLATE:=v_cur.template;
        pREFERENCEURL:=v_cur.REFERENCEURL;
        /*
        if lower(v_cur.name)='createfrom' then
            ponchangeevent:=logClick(document.getElementById('CreateFrom')); openServletNewWindow('BUTTONCreateFrom', true, 'GoodsMovementVendor_Edition.html', 'BUTTON', null, true,600, 900);
        if lower(v_cur.name)='posted' then
        */
        ponchangeevent:=v_cur.onchangeevent;
        pAD_TABLE_ID:=v_cur.AD_TABLE_ID;
        pCOLSTOTAL:=v_cur.COLSTOTAL;
        pMAXLENGTH:=v_cur.MAXLENGTH;
        pBUTTONCLASS:=v_cur.BUTTONCLASS;
        pincludesemptyitem:=v_cur.includesemptyitem;
        pAD_ValRule_ID:=v_cur.AD_Val_Rule_ID;
        pstyle:=v_cur.style;
        pline:=v_cur.line;
    end if;
    pleadingemptycols:=v_cur.leadingemptycols;
    v_breakcount:=v_breakcount+1;
    -- Umkehrung - issameline wird angehakt, linebreak=n
    if pislinebreak='Y' then 
        pislinebreak:='N';
    else
        pislinebreak:='Y';
    end if;
    if mod(v_breakcount,2)=0 or pislinebreak='Y' then
        pislinebreak:='Y';
        pleadingemptycols:=0;
        v_breakcount:=0;
    end if;
    pname:=v_cur.name;
    pname2:=v_cur.name2;
    ptranslation:=v_cur.translation;
    pAD_REF_FIELDCOLUMN_ID:=v_cur.AD_REF_FIELDCOLUMN_ID;
    RETURN NEXT;
  END LOOP;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

select zsse_dropfunction('ad_selecttabBuscadorFields');
CREATE OR REPLACE FUNCTION ad_selecttabBuscadorFields(in_language varchar,in_tab_id character varying,in_isaudit varchar,
                           pfieldreference out varchar,pislinebreak OUT varchar,pAD_REF_FIELDCOLUMN_ID out varchar,pname out varchar,pname2 out varchar,
                           pTEMPLATE out varchar,pAD_TABLE_ID out varchar,pCOLSTOTAL out varchar,
                           pMAXLENGTH out numeric,ptranslation out varchar,
                           pAD_ValRule_ID out varchar,pstyle out varchar,pline out numeric)
RETURNS SETOF RECORD AS
$BODY$ DECLARE 
v_cur record;
v_indset record;
v_count numeric;
v_filter varchar;
v_seqaud numeric=100000;
BEGIN
  for v_cur in (SELECT c.columnname as NAME,'' as NAME2,
                f.seqno as LINE,
                c.ad_val_rule_id, f.ad_field_v_id as AD_REF_FIELDCOLUMN_ID, c.ad_reference_value_id as ad_reference_id,
                coalesce(f.template,ad_datatype_guiengine_template_Mapping(c.AD_REFERENCE_ID)) as TEMPLATE, 
                coalesce(f.fieldreference,c.ad_reference_value_id) as FIELDREFERENCE, 
                case when c.AD_REFERENCE_ID='19' and f.tablereference is null then (SELECT ad_table_id from ad_table where lower(tablename)=lower(substr(c.columnname,1,length(c.columnname)-3))) 
                     else f.tablereference end as AD_TABLE_ID, 
                coalesce(f.maxlength,c.fieldlength) as MAXLENGTH,  ''::varchar as STYLE,
                zssi_getTabFieldTextByID(f.ad_field_v_id,in_language) as translation,
                f.isfiltercolumn
                from ad_tab t,ad_column_v c,ad_field_v f 
                where f.ad_column_v_id=c.ad_column_v_id and t.ad_tab_id=f.ad_tab_id and t.AD_tab_ID = in_tab_id
                and c.isactive='Y'
                and c.isparent='N'
                and f.isactive='Y'
                and c.ad_reference_id!='23')
  LOOP
    select count(*) into v_count from ad_fieldinstance where AD_field_v_ID=v_cur.AD_REF_FIELDCOLUMN_ID;
    if v_count>0 then
        for v_indset in  (select *   from  ad_fieldinstance where AD_field_v_ID=v_cur.AD_REF_FIELDCOLUMN_ID)
        LOOP
            pfieldreference:=coalesce(v_indset.fieldreference,v_cur.fieldreference);
            pTEMPLATE:=coalesce(v_indset.template,v_cur.template);
            pAD_TABLE_ID:=coalesce(v_indset.AD_TABLE_ID,v_cur.AD_TABLE_ID);            
            pMAXLENGTH:=coalesce(v_indset.MAXLENGTH,v_cur.MAXLENGTH);
            pAD_ValRule_ID:=coalesce(v_indset.AD_Val_Rule_ID,v_cur.AD_Val_Rule_ID);
            pstyle:=coalesce(v_indset.style,v_cur.style);
            pline:=coalesce(v_indset.line,v_cur.line);
            v_filter:=case when v_indset.isfiltercolumn='Y' then 'Y' else 'N' end;
        end loop;
    else
        pfieldreference:=v_cur.fieldreference;
        pTEMPLATE:=v_cur.template;
        pAD_TABLE_ID:=v_cur.AD_TABLE_ID;
        pMAXLENGTH:=v_cur.MAXLENGTH;
        pAD_ValRule_ID:=v_cur.AD_Val_Rule_ID;
        pstyle:=v_cur.style;
        pline:=v_cur.line;
        v_filter:=v_cur.isfiltercolumn;
    end if;
    pCOLSTOTAL:=2;
    pname:=v_cur.name;
    pname2:=v_cur.name2;
    ptranslation:=v_cur.translation;
    pAD_REF_FIELDCOLUMN_ID:=v_cur.AD_REF_FIELDCOLUMN_ID;
    pislinebreak:='Y';  
    if v_filter='Y' then
        if pTEMPLATE='CHECKBOX' then
        pTEMPLATE:='REFCOMBO';
        pfieldreference:='47209D76F3EE4B6D84222C5BDF170AA2'; -- 'Yes/No search box';
        end if;
        if pTEMPLATE in ('DATE','DECIMAL','EURO','INTEGER','PRICE') then
            ptranslation:=v_cur.translation||' '||zssi_getElementTextByColumname('From',in_language);   
            RETURN NEXT;
            pline:=pline+0.5;
            pname:=v_cur.name||'_f';
            ptranslation:=v_cur.translation||' '||zssi_getElementTextByColumname('To',in_language);
            pislinebreak:='N';
        end if;  
        if pTEMPLATE in ('NOEDIT_TEXTBOX','URL','TEXTAREA_EDIT_SIMPLE','TEXTAREA_EDIT_ADV') then
            pTEMPLATE:='TEXT';
        end if;
        if pTEMPLATE not in ('BUTTON','RADIOBUTTON','LABEL','IMAGE') then
            RETURN NEXT;   
        end if;
     end if;
  END LOOP;
  if in_isaudit='Y' then
     for v_cur in (SELECT c.columnname as NAME,'' as NAME2,
                c.ad_val_rule_id, c.ad_column_id as AD_REF_FIELDCOLUMN_ID, 
                c.ad_reference_value_id  as ad_reference_id,
                case when UPPER(c.columnname) in ('CREATEDBY','UPDATEDBY') then 'REFCOMBO' else ad_datatype_guiengine_template_Mapping(c.AD_REFERENCE_ID) end as TEMPLATE, 
                case when UPPER(c.columnname) in ('CREATEDBY','UPDATEDBY') then '2B964358653C45ED9B4D17DF007A8F05' else c.ad_reference_value_id end as FIELDREFERENCE, -- ad user employee 
                case when c.AD_REFERENCE_ID='19'  then (SELECT ad_table_id from ad_table where lower(tablename)=lower(substr(c.columnname,1,length(c.columnname)-3))) 
                     else null end as AD_TABLE_ID, 
                c.fieldlength as MAXLENGTH,  ''::varchar as STYLE,
                zssi_getElementTextByID(c.ad_element_id,in_language) as translation,
                'Y' as isfiltercolumn
                from ad_tab t,ad_column c
                where t.ad_table_id=c.ad_table_id and t.AD_tab_ID = in_tab_id
                and c.isactive='Y'
                and c.isparent='N'
                and c.ad_reference_id!='23'
                and UPPER(c.columnname) in ('CREATED', 'CREATEDBY', 'UPDATED', 'UPDATEDBY')
                order by c.columnname)
      loop
        pfieldreference:=v_cur.fieldreference;
        pTEMPLATE:=v_cur.template;
        pAD_TABLE_ID:=v_cur.AD_TABLE_ID;
        pMAXLENGTH:=v_cur.MAXLENGTH;
        pAD_ValRule_ID:=v_cur.AD_Val_Rule_ID;
        pstyle:=v_cur.style;
        v_seqaud:=v_seqaud+1;
        pline:=v_seqaud;
        v_filter:=v_cur.isfiltercolumn;
        pCOLSTOTAL:=2;
        pname:=v_cur.name;
        pname2:=v_cur.name2;
        ptranslation:=v_cur.translation;
        pAD_REF_FIELDCOLUMN_ID:=v_cur.AD_REF_FIELDCOLUMN_ID;
        pislinebreak:='Y';  
        if v_filter='Y' then
            if pTEMPLATE='CHECKBOX' then
            pTEMPLATE:='REFCOMBO';
            pfieldreference:='47209D76F3EE4B6D84222C5BDF170AA2'; -- 'Yes/No search box';
            end if;
            if pTEMPLATE in ('DATE','DECIMAL','EURO','INTEGER','PRICE') then
                ptranslation:=v_cur.translation||' '||zssi_getElementTextByColumname('From',in_language);   
                RETURN NEXT;
                v_seqaud:=v_seqaud+1;
                pline:=v_seqaud;
                pname:=v_cur.name||'_f';
                ptranslation:=v_cur.translation||' '||zssi_getElementTextByColumname('To',in_language);
                pislinebreak:='N';
            end if;  
            if pTEMPLATE in ('NOEDIT_TEXTBOX','URL','TEXTAREA_EDIT_SIMPLE','TEXTAREA_EDIT_ADV') then
                pTEMPLATE:='TEXT';
            end if;
            if pTEMPLATE not in ('BUTTON','RADIOBUTTON','LABEL','IMAGE') then
                RETURN NEXT;   
            end if;
        end if;
      end loop;
  end if;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;

  
select zsse_dropfunction('ad_selectprocessfields');
CREATE OR REPLACE FUNCTION ad_selectprocessfields(in_language varchar,in_process_id character varying,ptranslation out varchar,
                           pfieldreference out varchar,pislinebreak out varchar,pAD_REF_FIELDCOLUMN_ID out varchar,pname out varchar,pname2 out varchar,
                           pTEMPLATE out varchar,pREFERENCEURL out varchar,ponchangeevent out varchar,pAD_TABLE_ID out varchar,pCOLSTOTAL out varchar,
                           pMAXLENGTH out numeric,pleadingemptycols out numeric,pBUTTONCLASS out varchar,pad_element_id out varchar,
                           pincludesemptyitem out varchar,pAD_ValRule_ID out varchar,pstyle out varchar,pline out numeric)
RETURNS SETOF RECORD AS
$BODY$ DECLARE 
v_cur record;
v_indset record;
v_count numeric;
BEGIN
  for v_cur in (SELECT ad_element_id, columnname as NAME,'' as NAME2, '' as ONCHANGEEVENT, seqno as LINE,
                ad_val_rule_id,'Y' as islinebreak,includesemptyitem, ad_process_para_id as AD_REF_FIELDCOLUMN_ID, ad_reference_value_id as ad_reference_id,
                TEMPLATE, '' as buttonclass, '' as REFERENCEURL, ad_reference_value_id as FIELDREFERENCE, 
                AD_TABLE_ID, 0 as LEADINGEMPTYCOLS, 
                COLSTOTAL, 
                fieldlength as MAXLENGTH,  '' as STYLE,
                zssi_getProcessParamTextByID(ad_process_para_id,in_language) as translation
                from ad_process_para where AD_PROCESS_ID = in_process_id
                and isactive='Y'
                and ad_reference_id!='23'
                and ad_reference_id!='13')
  LOOP
    select count(*) into v_count from ad_process_para_instance where ad_process_para_ID=v_cur.AD_REF_FIELDCOLUMN_ID;
    if v_count>0 then
        for v_indset in  (select *   from  ad_process_para_instance where ad_process_para_id=v_cur.AD_REF_FIELDCOLUMN_ID)
        LOOP
            pfieldreference:=coalesce(v_indset.ad_reference_value_id,v_cur.fieldreference);           
            pTEMPLATE:=coalesce(v_indset.template,v_cur.template);
            pAD_TABLE_ID:=coalesce(v_indset.AD_TABLE_ID,v_cur.AD_TABLE_ID);
            pCOLSTOTAL:=coalesce(v_indset.COLSTOTAL,v_cur.COLSTOTAL);
            pMAXLENGTH:=coalesce(v_indset.fieldlength,v_cur.MAXLENGTH);
            pincludesemptyitem:=case when v_indset.includesemptyitem!='NON' then v_indset.includesemptyitem else v_cur.includesemptyitem end;
            pAD_ValRule_ID:=coalesce(v_indset.ad_val_rule_id,v_cur.ad_val_rule_id);
            pline:=coalesce(v_indset.seqno,v_cur.line);
        end loop;
    else
        pname:=v_cur.name;
        pname2:=v_cur.name2;
        pfieldreference:=v_cur.fieldreference;
        pTEMPLATE:=v_cur.template;
        pAD_TABLE_ID:=v_cur.AD_TABLE_ID;
        pCOLSTOTAL:=v_cur.COLSTOTAL;
        pMAXLENGTH:=v_cur.MAXLENGTH;
        pincludesemptyitem:=v_cur.includesemptyitem;
        pAD_ValRule_ID:=v_cur.ad_val_rule_id;       
        pline:=v_cur.line;
    end if;
    pislinebreak:='Y';
    pREFERENCEURL:=v_cur.REFERENCEURL;
    pname:=v_cur.name;
    pname2:=v_cur.name2;
    pislinebreak:=v_cur.islinebreak;
    ponchangeevent:=v_cur.onchangeevent;
    pleadingemptycols:=v_cur.leadingemptycols;
    pBUTTONCLASS:=v_cur.BUTTONCLASS;
    pstyle:=v_cur.style;
    ptranslation:=v_cur.translation;
    pAD_REF_FIELDCOLUMN_ID:=v_cur.AD_REF_FIELDCOLUMN_ID;
    RETURN NEXT;
  END LOOP;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;



select zsse_dropfunction('ad_selectfieldgroupfields');
CREATE OR REPLACE FUNCTION ad_selectfieldgroupfields(in_fieldgroup_id character varying,pad_element_id out varchar,
                           pfieldreference out varchar,pislinebreak out varchar,pAD_REF_FIELDCOLUMN_ID out varchar,pname out varchar,pname2 out varchar,
                           pTEMPLATE out varchar,pREFERENCEURL out varchar,ponchangeevent out varchar,pAD_TABLE_ID out varchar,pCOLSTOTAL out varchar,
                           pMAXLENGTH out numeric,pleadingemptycols out numeric,pBUTTONCLASS out varchar,
                           pincludesemptyitem out varchar,pAD_ValRule_ID out varchar,pstyle out varchar,pline out numeric)
RETURNS SETOF RECORD AS
$BODY$ DECLARE 
v_cur record;
v_indset record;
v_count numeric;
BEGIN
  for v_cur in (SELECT ad_element_id ,  NAME,NAME2, ONCHANGEEVENT, LINE,'' as value,ad_val_rule_id,islinebreak,includesemptyitem,
        AD_REF_FIELDCOLUMN_ID, AD_REFERENCE_ID, TEMPLATE, buttonclass, REFERENCEURL, FIELDREFERENCE, AD_TABLE_ID, LEADINGEMPTYCOLS, COLSTOTAL, MAXLENGTH, STYLE,
        '' as selectorcolumnsuffix,'' as selectorcolumnname
        from ad_ref_fieldcolumn where AD_REFERENCE_ID = in_fieldgroup_id  and isactive='Y')
  LOOP
    select count(*) into v_count from ad_ref_fieldcolumninstance where AD_REF_FIELDCOLUMN_ID=v_cur.AD_REF_FIELDCOLUMN_ID;
    if v_count>0 then
        for v_indset in  (select *   from  ad_ref_fieldcolumninstance where AD_REF_FIELDCOLUMN_ID=v_cur.AD_REF_FIELDCOLUMN_ID)
        LOOP
            pfieldreference:=coalesce(v_indset.fieldreference,v_cur.fieldreference);
            pislinebreak:=coalesce(v_indset.islinebreak,v_cur.islinebreak);
            pad_element_id:=coalesce(v_indset.ad_element_id,v_cur.ad_element_id);
            pTEMPLATE:=coalesce(v_indset.template,v_cur.template);
            pREFERENCEURL:=coalesce(v_indset.REFERENCEURL,v_cur.REFERENCEURL);
            ponchangeevent:=coalesce(v_indset.onchangeevent,v_cur.onchangeevent);
            pAD_TABLE_ID:=coalesce(v_indset.AD_TABLE_ID,v_cur.AD_TABLE_ID);
            pCOLSTOTAL:=coalesce(v_indset.COLSTOTAL,v_cur.COLSTOTAL);
            pMAXLENGTH:=coalesce(v_indset.MAXLENGTH,v_cur.MAXLENGTH);
            pleadingemptycols:=coalesce(v_indset.leadingemptycols,v_cur.leadingemptycols);
            pBUTTONCLASS:=coalesce(v_indset.BUTTONCLASS,v_cur.BUTTONCLASS);
            pincludesemptyitem:=coalesce(v_indset.includesemptyitem,v_cur.includesemptyitem);
            pAD_ValRule_ID:=coalesce(v_indset.AD_Val_Rule_ID,v_cur.AD_Val_Rule_ID);
            pstyle:=coalesce(v_indset.style,v_cur.style);
            pline:=coalesce(v_indset.line,v_cur.line);
        end loop;
        pname:=v_cur.name;
        pname2:=v_cur.name2;
        pAD_REF_FIELDCOLUMN_ID:=v_cur.AD_REF_FIELDCOLUMN_ID;
    else
        pname:=v_cur.name;
        pname2:=v_cur.name2;
        pfieldreference:=v_cur.fieldreference;
        pislinebreak:=v_cur.islinebreak;
        pad_element_id:=v_cur.ad_element_id;
        pTEMPLATE:=v_cur.template;
        pREFERENCEURL:=v_cur.REFERENCEURL;
        ponchangeevent:=v_cur.onchangeevent;
        pAD_TABLE_ID:=v_cur.AD_TABLE_ID;
        pCOLSTOTAL:=v_cur.COLSTOTAL;
        pMAXLENGTH:=v_cur.MAXLENGTH;
        pleadingemptycols:=v_cur.leadingemptycols;
        pBUTTONCLASS:=v_cur.BUTTONCLASS;
        pincludesemptyitem:=v_cur.includesemptyitem;
        pAD_ValRule_ID:=v_cur.AD_Val_Rule_ID;
        pstyle:=v_cur.style;
        pline:=v_cur.line;
        pAD_REF_FIELDCOLUMN_ID:=v_cur.AD_REF_FIELDCOLUMN_ID;
    end if;
    RETURN NEXT;
  END LOOP;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;



CREATE OR REPLACE FUNCTION ad_getcustomtabfields(p_tab_id varchar)  RETURNS varchar AS
$BODY$ DECLARE 
/***************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2014 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
****************************************************/
v_cur RECORD;
v_return varchar := '';
BEGIN
  for v_cur in (select name from ad_customfield where ad_tab_id=p_tab_id)
  LOOP
    if v_return!='' then
        v_return:=v_return||',';
    end if;
    v_return:=v_return||v_cur.name;
  END LOOP;
  return v_return;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE
  COST 100;
 
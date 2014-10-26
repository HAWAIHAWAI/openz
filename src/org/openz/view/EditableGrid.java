package org.openz.view;
/*
****************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2012 Stefan Zimmermann All Rights Reserved.
Contributor(s): ______________________________________.
***************************************************************************************************************************************************
*/
import java.util.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openz.view.templates.ConfigureCheckbox;
import org.openz.view.templates.ConfigureDatebox;
import org.openz.view.templates.ConfigureNumberbox;
import org.openz.view.templates.ConfigurePAttribute;
import org.openz.view.templates.ConfigurePopupSelectBox;
import org.openz.view.templates.ConfigureSelectBox;
import org.openz.view.templates.ConfigureTextbox;
import org.openz.view.templates.ConfigureTimebox;
import org.openz.util.LocalizationUtils;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.Replace;


public class EditableGrid {
  public static int maxcols;
  public static int maxlevels;
  public static String lineIDColumn;

  public EditableGrid(int cols, int level, String idColumname){
    maxcols=cols;
    maxlevels=level;
    lineIDColumn=idColumname;
    levelpointer = new Vector();
    levelpointer.add(null);
  }
  
  public EditableGrid(String referenceName,VariablesSecureApp vars,HttpSecureAppServlet servlet) throws Exception{
    String refID=GridData.getReferenceID(servlet, referenceName);
    maxcols=Integer.parseInt(FormhelperData.getReferenceColumns(servlet, refID));
    maxlevels=Integer.parseInt(GridData.getGroupCount(servlet,refID));
    if (maxlevels==0)
      maxlevels=1;
    lineIDColumn=GridData.getDetailsIDField(servlet,refID);
    levelpointer = new Vector();
    levelpointer.add(null);
    initGridByAD(referenceName,vars,servlet);
  }
  // The levelpointer stores IdColumns and their values according to the LEVEL of the Group.
  // The LEVEL can be directly accessed with elementAt(level)
  // Terefore the first Element is always null
  private Vector <Levelpointer> levelpointer;
  class Levelpointer {
    public String IDColumn;
    public String IDValue;
    public boolean colsVisibleOnInit;
    public Vector<String> IDvaluelist;
    
  }
  
  class Column {
    public String fieldname;
    public String elementid;
    public String onchangeevent;
    public String fieldId;
    public String headertext; 
    // TEMPLATE
    // DECIMAL, INTEGER, PRICE, DATE, HEADER, TEXT, POPUPSEARCH, REFCOMBO, CHECKBOX, TEXTLABEL, LABELLINK, RAW, RADIOBUTTONGROUP (TODO)
    // If HEADER, headertext is filled by localisation utils from fieldname. All other templates are expected as field in the Field Provider
    public String template;
    // Reference for POPUPSEARCH and REFCOMBO. Holds the Reference NAME. In direct Table Combos, The ID-Field of the Table
    // In LABELLINK it holds the URL of the servlet to be navigated To
    public String colreference;
    // Onlyy in Direct table Reference
    public String validation;
    // for REFCOMBO (when colreference is empty)
    public FieldProvider[] comboSQL; // TODO
    // Common Column Settings
    public int colspan;
    public int maxlength;
    public boolean required;
    public boolean readonly;
    public boolean isinheader;
    public boolean issecondheader;
    // only for select Box
    public boolean emptyitemfirst;
    public String jssettings; // Java Script settings
    
  }
  
  class Group {
    public String IDColumn;
    public int level;
    public int leadingemptycols; 
    public boolean headerformatbold;
    public boolean hasselectallbelow;
    public boolean hasevenodd;
    public boolean hasexpander;
    public boolean hasselectline;
    public boolean hasnewitembutton;// TODO - Is ajax
    public boolean hassavebutton; // TODO - Is ajax
    public boolean hasdeletebutton; // TODO - Is ajax
    public Vector <String> splitgroupgridcolumnid; // Splits a Group - Last Field in Upper Group is given here
    public Column[] columns;
  }
  // groups must begin with level=1 and can increment level, but not decrement  in order of Vector Index.
  // groups must increment level if they have IDColumn.
  // Groups without IDColumn are only Headlines with no Data. They can have the same level than other groups
  public Vector <Group> groups = new Vector<Group>();
  
  
  
  private void initGridByAD(String gridname,VariablesSecureApp vars,HttpSecureAppServlet servlet) throws Exception{
    String refID=GridData.getReferenceID(servlet,gridname);
    GridData[] data=GridData.selectGroup(servlet, refID);
    for (int i = 0; i < data.length; i++){
      Group group = new Group();
      group.splitgroupgridcolumnid= new Vector<String>();
      group.IDColumn=data[i].idcolumn;
      group.leadingemptycols=Integer.parseInt(data[i].leadingemptycols);
      group.hasselectallbelow= data[i].hasselectallbelow.equals("Y") ? true : false;
      group.hasevenodd=data[i].hasevenodd.equals("Y") ? true : false; 
      group.hasexpander=data[i].hasexpander.equals("Y") ? true : false;
      group.hasselectline=data[i].hasselectline.equals("Y") ? true : false;
      group.headerformatbold=data[i].headerformatbold.equals("Y") ? true : false;
      group.level=Integer.parseInt(data[i].level);
      GridData[] coldata=GridData.selectColumnFromGroup(servlet, data[i].adRefGroupId,data[i].isautoheader);
      Column[] columns=new Column[coldata.length];
      for (int j = 0; j < coldata.length; j++){
        Column cl=new Column();
        cl.fieldname=coldata[j].name;
        cl.fieldId=coldata[j].adRefGridcolumnId;
        cl.template=coldata[j].template;
        cl.elementid=coldata[j].adElementId;
        cl.emptyitemfirst=coldata[j].includesemptyitem.equals("Y") ? true : false;
        if (cl.template.equals("HEADER")) {
          if (cl.elementid.equals(""))
            cl.headertext=LocalizationUtils.getElementTextByElementName(servlet, cl.fieldname, vars.getLanguage());
          else
            cl.headertext=LocalizationUtils.getElementTextById(servlet, cl.elementid, vars.getLanguage());
        }
        if (cl.template.equals("REFCOMBO")) {
          if (cl.template.equals("REFCOMBO") && ! coldata[j].adTableId.equals(""))
             // Direct Table
            cl.colreference=GridData.getKeyColumnbyTable(servlet, coldata[j].adTableId);
          if (! coldata[j].colreference.equals(""))
            // Search, List or Table Reference
            cl.colreference=GridData.getReferenceName(servlet, coldata[j].colreference);
        }
        if (cl.template.equals("LABELLINK"))
          cl.colreference=coldata[j].referenceurl;
        if (cl.template.equals("POPUPSEARCH"))
          cl.colreference=coldata[j].colreference;
        cl.colspan=Integer.parseInt(coldata[j].colspan);
        cl.validation=coldata[j].adValRuleId;
        cl.onchangeevent=coldata[j].onchangeevent;
        cl.maxlength=Integer.parseInt(coldata[j].maxlength);
        cl.required=FormDisplayLogic.fieldMandantoryLogic(servlet, vars, null, coldata[j].adRefGridcolumnId,true);
        //coldata[j].required.equals("Y") ? true : false;
        cl.readonly=FormDisplayLogic.fieldReadOnlyLogic(servlet, vars, null, coldata[j].adRefGridcolumnId,true);
        //coldata[j].readonly.equals("Y") ? true : false;
        String display = FormDisplayLogic.fieldVisibleLogic(servlet, vars, null, coldata[j].adRefGridcolumnId,"",true);
        if ( ! display.equals("VISIBLE"))
          cl.template="DONOTGENERATE";
        if (display.equals("HIDDEN"))
          cl.template="HIDDEN";
        cl.isinheader=coldata[j].isinheader.equals("Y") ? true : false;
        cl.issecondheader=coldata[j].issecondheader.equals("Y") ? true : false;
        if (coldata[j].issplitgroup.equals("Y"))
          group.splitgroupgridcolumnid.add(coldata[j].adRefGridcolumnId);
        columns[j]=cl;
      }
      group.columns=columns;
      groups.addElement(group);
      Levelpointer l = new Levelpointer();
      if (!group.IDColumn.equals("")){
        l.IDColumn=group.IDColumn;
        l.IDValue="";
        l.colsVisibleOnInit=data[i].colsvisibleoninit.equals("Y") ? true : false;
        levelpointer.addElement(l);
      }
    }
    if (levelpointer.size()==1){
      Levelpointer l = new Levelpointer();
      l.IDColumn="DUMMYGROUP";
      l.IDValue="DUMMYGROUPID";
      l.colsVisibleOnInit=data[data.length-1].colsvisibleoninit.equals("Y") ? true : false;
      levelpointer.addElement(l);
    }
  }
  // Returns all selected ID's from the Form for the desired Level
  // Parameter: ID-Field of the Level OR lineIDColumn for the Detail Section (Lines)
  public Vector <String> getSelectedIds(HttpSecureAppServlet servlet,VariablesSecureApp vars,String idColumname)throws Exception{
    Vector <String> levelids = new Vector<String>();
    for (int i = 1; i < levelpointer.size(); i++){
      levelpointer.elementAt(i).IDvaluelist=new Vector<String>();
      if (i==1)
        levelpointer.elementAt(i).IDvaluelist=vars.getListFromInString(vars.getInStringParameter("inp" + levelpointer.elementAt(i).IDColumn));
      else{
        for (int j = 0; j < levelpointer.elementAt(i-1).IDvaluelist.size(); j++){
          levelids=vars.getListFromInString(vars.getInStringParameter("inp" + levelpointer.elementAt(i).IDColumn + levelpointer.elementAt(i-1).IDvaluelist.elementAt(j)));
          levelpointer.elementAt(i).IDvaluelist.addAll(levelids);
        }
      }
    if (i == levelpointer.size()-1) {
      levelids = new Vector<String>();
      for (int j = 0; j < levelpointer.elementAt(i).IDvaluelist.size(); j++){
        levelids.addAll(vars.getListFromInString(vars.getInStringParameter("inp" + levelpointer.elementAt(i).IDColumn + levelpointer.elementAt(i).IDvaluelist.elementAt(j))));
      }
    }
    if (levelpointer.elementAt(i).IDColumn.equalsIgnoreCase(idColumname) || (idColumname.equalsIgnoreCase(lineIDColumn) && i == levelpointer.size()-1))
      if (idColumname.equalsIgnoreCase(lineIDColumn) && i == levelpointer.size()-1)
        return levelids;
      else
        return levelpointer.elementAt(i).IDvaluelist;
    }
    return new Vector<String>();
  }
  public String getValue(HttpSecureAppServlet servlet,VariablesSecureApp vars,String selectedId,String columnname)throws Exception{
    for (int j = 0; j < groups.size(); j++) {
      for (int i = 0; i < groups.elementAt(j).columns.length; i++) {
        if (groups.elementAt(j).columns[i].fieldname.equals(columnname) && ! groups.elementAt(j).columns[i].template.equals("HEADER")){
          if (groups.elementAt(j).columns[i].template.equals("CHECKBOX") || 
              groups.elementAt(j).columns[i].template.equals("DECIMAL") || 
              groups.elementAt(j).columns[i].template.equals("EURO") || 
              groups.elementAt(j).columns[i].template.equals("INTEGER") || 
              groups.elementAt(j).columns[i].template.equals("PRICE")) {
            if (groups.elementAt(j).columns[i].template.equals("CHECKBOX")) {
              String yn = vars.getStringParameter("inp" + columnname + selectedId);
              if (yn.equals(""))
                yn="N";
              return yn;
            }
            else
              return vars.getNumericParameter("inp" + columnname + selectedId);
          }
          return vars.getStringParameter("inp" + columnname + selectedId);
          }
        }
          
      }
   return "";
 }
 
  
  public String printGrid(HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,FieldProvider[] data) throws Exception{
    StringBuilder grid= new StringBuilder(10000000);
    grid.append(initGridStructure());
    String evenodd="odd";
    final int maxRows = Integer.valueOf(vars.getSessionValue("#RECORDRANGEINFO"));
    int displayrows;
    if (data.length > maxRows) {
      displayrows=maxRows;
      final OBError obError = new OBError();
      String strType="WARNING";
      String stroMsg="";
      final OBError myMessage = vars.getMessage(servlet.getClass().getName());
      if (myMessage!=null){
        stroMsg=myMessage.getMessage() + "<br /><br />";
        if (myMessage.getType().equals("Error"))
          strType=myMessage.getType();
      }
      String strMsg = Utility.messageBD(servlet, "MAX_RECORDS_REACHED", vars.getLanguage());
      strMsg = strMsg.replaceAll("%returned%", String.valueOf(data.length));
      strMsg = strMsg.replaceAll("%shown%", String.valueOf(maxRows));
      obError.setMessage(stroMsg+strMsg);
      obError.setTitle("");
      obError.setType(strType);
      vars.setMessage(servlet.getClass().getName(), obError);
    }
    else
      displayrows=data.length;
    if (data.length==0)
      // If Data is null, only the header is printed
      grid= grid.append(initNewGroup(1,null,servlet,vars,script));
    
    for (int i = 0; i < displayrows; i++){
      if (isGroupchangeOnLevel(data[i])>0 || (levelpointer.elementAt(1).IDColumn.equals("DUMMYGROUP") && i==0)){
        if (levelpointer.elementAt(1).IDColumn.equals("DUMMYGROUP") && i==0)
          grid= grid .append(initNewGroup(1,data[i],servlet,vars,script));
        else {
          for (int j = isGroupchangeOnLevel(data[i]); j <= maxlevels; j++){
            // Group init
            levelpointer.elementAt(j).IDValue=data[i].getField(levelpointer.elementAt(j).IDColumn);
            grid= grid.append(initNewGroup(j,data[i],servlet,vars,script));
          }
        }
      }
      grid= grid.append(addDataline(data[i],groups.elementAt(maxlevels-1),evenodd,servlet,vars,script,i));
      if (evenodd.equals("odd"))
        evenodd="even";
      else
        evenodd="odd";
    }
    grid=grid.append("</TABLE>");
    return grid.toString();
  }
  
  private int isGroupchangeOnLevel(FieldProvider data){
    if (levelpointer.elementAt(1).IDColumn.equals("DUMMYGROUP"))
      return 0;
    for (int i = 1; i < levelpointer.size(); i++){
      if (!data.getField(levelpointer.elementAt(i).IDColumn).equals(levelpointer.elementAt(i).IDValue))
        return i;
    }
    return 0;  
  }
    
    private String getConcatGroupID(int level){
      String IDVaue= "";
      int lv=0;
      for (int i = 1; i <= levelpointer.size(); i++){
        if (lv==level)
          break;
        IDVaue=IDVaue + levelpointer.elementAt(i).IDValue;
        lv=lv+1;
      }
      return IDVaue;
    }
    
    private Vector <Integer> getGroupsInLevel(int level){
      Vector <Integer> levels = new Vector<Integer>();
      for (int i = 0; i < groups.size(); i++){
        if (groups.elementAt(i).level==level)
          levels.add(i);
      }
      return levels;
    }
    
    private String getNextlevelIDField(int level){
      if (level<groups.size()){
        for (int i = level; i >= level-1; i--){
          if (!groups.elementAt(i).IDColumn.equals(""))
            return groups.elementAt(i).IDColumn;
        }
      }
      return groups.elementAt(level-1).IDColumn;
    }
    
    private StringBuilder initNewGroup(int level,FieldProvider data,HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script) throws Exception {
      String  upperGroupIDValue="";
      String  idValueOfAllUpperGroups="";
      
      String  groupIDValue=levelpointer.elementAt(level).IDValue;
      
      String  groupIDColumn=levelpointer.elementAt(level).IDColumn;
      String visibletag = "";
      if (level>1)
        if (!levelpointer.elementAt(level-1).colsVisibleOnInit)
          visibletag = " style=\"display: none\"";
      if (level>1){
        upperGroupIDValue=levelpointer.elementAt(level-1).IDValue;
        for (int i = 1; i < level; i++){
          idValueOfAllUpperGroups=idValueOfAllUpperGroups + " " + levelpointer.elementAt(i).IDValue;
        }
      }
      
      StringBuilder grid= new StringBuilder("<tr class=\"DataGrid_Body_Row " + idValueOfAllUpperGroups + " "  + "\"" + visibletag + ">\n");
      
      Vector <Integer> groupheaders4level=getGroupsInLevel(level);
      for (int i = 0; i < groupheaders4level.size(); i++){
          // Empty cols at group begin
          grid.append(emptycols(groups.elementAt(groupheaders4level.elementAt(i)).leadingemptycols));
          StringBuilder uiItem= new StringBuilder();
          // Fixed values for Function Elements on Group Level
          uiItem.append(cbSelectAllBelow(groupIDColumn,groups.elementAt(groupheaders4level.elementAt(i)).hasselectallbelow,groupIDValue,upperGroupIDValue,getNextlevelIDField(level)));
          if (groups.elementAt(groupheaders4level.elementAt(i)).headerformatbold)
            Replace.replace(uiItem,"DataGrid_Content", "DataGrid_Header");
          grid.append(uiItem + "\n");
          
          if (groups.elementAt(groupheaders4level.elementAt(i)).hasexpander){
            uiItem=new StringBuilder(btnEexpandGroup(groupIDValue));
            if (groups.elementAt(groupheaders4level.elementAt(i)).headerformatbold)
              //uiItem=Scripthelper.addTagOption("class","DataGrid_Header_Cell" , uiItem);
              Replace.replace(uiItem,"DataGrid_Content", "DataGrid_Header");
            grid.append(uiItem+ "\n");
          }
          // Load Header Fields
          for (int j = 0; j < groups.elementAt(groupheaders4level.elementAt(i)).columns.length; j++){
            if (groups.elementAt(groupheaders4level.elementAt(i)).columns[j].issecondheader){
              Replace.replace(grid, "<tr class=\"DataGrid_Body_Row " + idValueOfAllUpperGroups + "\"" + visibletag + ">\n",  "<tr class=\"DataGrid_Body_Row " + idValueOfAllUpperGroups + " " + groupIDValue + "\"" + " style=\"display: none;\"" + ">\n");
            }
            if (groups.elementAt(groupheaders4level.elementAt(i)).columns[j].isinheader){
              if (issplitgroupfield(groups.elementAt(groupheaders4level.elementAt(i)),groups.elementAt(groupheaders4level.elementAt(i)).columns[j].fieldId))
                grid.append("</tr><tr class=\"DataGrid_Body_Row " + idValueOfAllUpperGroups + "\"" + visibletag + ">\n");
              uiItem=loadTemplate(groups.elementAt(groupheaders4level.elementAt(i)).columns[j],data,groups.elementAt(groupheaders4level.elementAt(i)).IDColumn,servlet,vars,script);
              if (groups.elementAt(groupheaders4level.elementAt(i)).headerformatbold){
                Replace.replace(uiItem,"DataGrid_Content", "DataGrid_Header");
                }
              //Scripthelper.addTagOption("class","DataGrid_Header_Cell" , uiItem);
              grid.append(uiItem + "\n");
            }
          }
      }
      grid.append("</tr>\n");
      return grid;
    }
    
  private boolean issplitgroupfield(Group group,String fieldId){
    if (group.splitgroupgridcolumnid!=null){
      for (int i = 0; i < group.splitgroupgridcolumnid.size(); i++){
        if (group.splitgroupgridcolumnid.elementAt(i).equals(fieldId))
          return true;
      }
    }
    return false;
  }
  
  private String addDataline(FieldProvider data,Group group,String evenodd,HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script,int counter) throws Exception{
    String  idValueOfAllUpperGroups="";
    String visibletag = "";
    if (group.level>1 && group.level==maxlevels){
      if (!levelpointer.elementAt(maxlevels).colsVisibleOnInit)
        visibletag = " style=\"display: none\"";
      for (int i = 1; i <= maxlevels; i++){
        idValueOfAllUpperGroups=idValueOfAllUpperGroups + " " + levelpointer.elementAt(i).IDValue;
      }
    }
    StringBuilder strTableCells= new StringBuilder(250000);
    String grid="";
    if (data.getField(lineIDColumn)!=null){
      String gridline="<tr " + visibletag + "class=\"DataGrid_Body_Row " + idValueOfAllUpperGroups  + " " ;
      if (group.hasevenodd){
        if (evenodd.equals("even"))
          gridline=gridline + "DataGrid_Body_Row_1\"";
        else
          gridline=gridline + "DataGrid_Body_Row_0\"";
        gridline=gridline +  visibletag + " id=\"funcEvenOddRow\">\n";
      } else
          gridline=gridline + visibletag + ">\n";
      if (group.hasselectline)
        grid=gridline + cbSelectLine(levelpointer.elementAt(maxlevels).IDColumn,levelpointer.elementAt(maxlevels).IDValue,data.getField(lineIDColumn),true,counter);
      else
        grid=gridline + cbSelectLine(levelpointer.elementAt(maxlevels).IDColumn,levelpointer.elementAt(maxlevels).IDValue,data.getField(lineIDColumn),false,counter);
      // If a column named preselected is in the Field Provider, this Column is selected by default
      // Add a preselected Column to the Onload Logic - This sets the Selected Item
      if (data.getField("preselected")!=null)
        if (data.getField("preselected").equals("Y"))
          script.addOnload("gridOnchangeCheckboxClick('"+data.getField(lineIDColumn)+"');");
      for (int i = 0; i < group.columns.length; i++){
  
        if (!group.columns[i].isinheader){
          if (issplitgroupfield(group,group.columns[i].fieldId)){
            grid=grid+"</tr>" + gridline + "<td></td>";}
   
          {grid=grid + loadTemplate(group.columns[i],data,lineIDColumn,servlet,vars,script);
          }}
      }
      grid=grid + "</tr>";
    }
    return grid;
    
  }

  private StringBuilder loadTemplate(Column col,FieldProvider data, String groupFieldIDname,HttpSecureAppServlet servlet,VariablesSecureApp vars,Scripthelper script) throws Exception {
    StringBuilder grid= new StringBuilder();
    if (data==null)
      data= new GridData();
    // get Tooltip
    String tooltip=data.getField("TOOLTIP" + col.fieldname);
    if (tooltip==null)
      tooltip=data.getField(col.fieldname);
    String onchangeevent= "gridOnchangeCheckboxClick('" + data.getField(groupFieldIDname) +"');" + col.onchangeevent;
    onchangeevent=Replace.replace(onchangeevent, "@GROUPID@", data.getField(groupFieldIDname));
    // DECIMAL, INTEGER, PRICE, DATE, HEADER, TEXT, POPUPSEARCH, REFCOMBO, CHECKBOX, TEXTLABEL, LABELLINK, RAW
    if (col.template.equals("DECIMAL"))
       grid=ConfigureNumberbox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname) , col.colspan, col.maxlength, col.required, col.readonly, onchangeevent, "DECIMAL", data.getField(col.fieldname), col.jssettings,tooltip);
    if (col.template.equals("INTEGER"))
      grid=ConfigureNumberbox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname), col.colspan, col.maxlength, col.required, col.readonly,onchangeevent, "INTEGER", data.getField(col.fieldname), col.jssettings,tooltip);
    if (col.template.equals("PRICE"))
      grid=ConfigureNumberbox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname), col.colspan, col.maxlength, col.required, col.readonly,onchangeevent, "PRICE", data.getField(col.fieldname), col.jssettings,tooltip);
    if (col.template.equals("EURO"))
      grid=ConfigureNumberbox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname), col.colspan, col.maxlength, col.required, col.readonly,onchangeevent, "EURO", data.getField(col.fieldname), col.jssettings,tooltip);
    if (col.template.equals("DATE"))
      grid=ConfigureDatebox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname), col.colspan,  col.required, col.readonly, data.getField(col.fieldname),onchangeevent,col.jssettings,tooltip);
    if (col.template.equals("TIME"))
      grid=ConfigureTimebox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname), col.colspan,  col.maxlength,col.required, col.readonly, onchangeevent, data.getField(col.fieldname),col.jssettings, tooltip);
    if (col.template.equals("PATTRIBUTE"))
      grid=ConfigurePAttribute.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname), col.colspan,  col.required, col.readonly, data.getField(col.fieldname),onchangeevent,col.jssettings,tooltip);
    if (col.template.equals("TEXT"))
      grid=ConfigureTextbox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname), col.colspan,  col.maxlength,col.required, col.readonly, onchangeevent, data.getField(col.fieldname),col.jssettings, tooltip);
    if (col.template.equals("POPUPSEARCH")) {
      String refName=GridData.getReferenceName(servlet, col.colreference);
      grid=ConfigurePopupSelectBox.doConfigureGrid(servlet, vars, script,col.fieldname + data.getField(groupFieldIDname), col.colspan,col.required, col.readonly, refName,data.getField(col.fieldname),onchangeevent,"",tooltip,col.colreference);
    }
    if (col.template.equals("REFCOMBO")){
      if (col.colreference.equals("") && col.comboSQL != null){
        grid=ConfigureSelectBox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname),col.colspan,col.required,col.readonly, onchangeevent,data.getField(col.fieldname),col.comboSQL,"",tooltip,col.emptyitemfirst);            
      }
      else{
        FieldProvider[] fp;
        fp = SelectBoxhelper.getReferenceDataByRefName(servlet, vars, col.colreference,col.validation,data,data.getField(col.fieldname),col.readonly);
        grid=ConfigureSelectBox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname),col.colspan,col.required,col.readonly, onchangeevent,data.getField(col.fieldname),fp,"",tooltip,col.emptyitemfirst);
      }
        //String fieldname,String value,boolean checked, boolean readonly, String jssettings) throws Exception{
    }
    if (col.template.equals("CHECKBOX")){  
      boolean checked = false;
      if (data.getField(col.fieldname).equals("Y"))
        checked=true;
      grid=ConfigureCheckbox.doConfigureGrid(servlet, vars, script, col.fieldname + data.getField(groupFieldIDname), col.colspan, onchangeevent,data.getField(col.fieldname),checked,col.readonly,"",col.elementid);
    }
    
    if (col.template.equals("TEXTLABEL")){  
      grid= new StringBuilder("<TD class=\"DataGrid_Content\" id=\""+ col.fieldname + data.getField(groupFieldIDname)+ "\" colspan=\"" + col.colspan + "\"  title=\""+ tooltip +"\">" + data.getField(col.fieldname) + "</TD>\n");
    }
    if (col.template.equals("RAW")){  
      grid=new StringBuilder("<TD class=\"DataGrid_Content\" id=\""+ col.fieldname + data.getField(groupFieldIDname)+ "\" colspan=\"" + col.colspan + "\">" + data.getField(col.fieldname) + "</TD>\n");
    }
    if (col.template.equals("HEADER")){  
      String text ="";
      if (col.elementid.equals(""))
        text = LocalizationUtils.getElementTextByElementName(servlet, col.fieldname, vars.getLanguage());
      else
        text = LocalizationUtils.getElementTextById(servlet, col.elementid, vars.getLanguage());
      grid=new StringBuilder("<TD class=\"DataGrid_Content\" colspan=\"" + col.colspan + "\" title=\"" + text + "\">" + text + "</TD>\n");
    }
    if (col.template.equals("LABELLINK")){  
      if (GridData.getTableIDFromKeyColumnName(servlet,groupFieldIDname)==null)
        // Not Possible to User label Link Dispatcher
        grid=new StringBuilder("<TD class=\"DataGrid_Content\" colspan=\"" + col.colspan + "\">\n" +
           //"<A href=\"#\" onclick=\"submitCommandFormParameter('DIRECT', document.frmMain.inpDirectKey, '" + upperGroupIdValue+ "', false, document.frmMain, '" + col.colreference + "', null, false, true);return false;\" onmouseover=\"window.status='Linkactive';return true;\" onmouseout=\"window.status='';return true;\" title=\"" + data.getField(col.fieldname) + "\" class=\"LabelLink\">"
           "<A href=\"#\" onclick=\"submitCommandChangingName('" + data.getField(groupFieldIDname) + "','" + col.colreference + "', 'inpDirectKey');return false;\" onmouseover=\"window.status='Linkactive';return true;\" onmouseout=\"window.status='';return true;\" title=\"" + tooltip + "\" class=\"LabelLink\">"
          + data.getField(col.fieldname) + "</a>\n</TD>");
      else {
        // Using label Link Dispatcher
        grid=new StringBuilder("<TD class=\"DataGrid_Content\" colspan=\"" + col.colspan + "\">\n" +
             "<a href=\"#\" onclick=\"sendDirectLink(document.frmMain, '" + groupFieldIDname + "', '', '../utility/ReferencedLink.html', '" + data.getField(groupFieldIDname) + "', '" + 
                    GridData.getTableIDFromKeyColumnName(servlet,groupFieldIDname) + "', '_self', true);" +
                    ";return false;\" onmouseover=\"window.status='Linkactive';return true;\" onmouseout=\"window.status='';return true;\" title=\"" + tooltip + "\" class=\"LabelLink\">"
                    + data.getField(col.fieldname) + "</a>\n</TD>");
      }
    }
    if (col.template.equals("HIDDEN")){
      script.addHiddenfield("inp" + col.fieldname + data.getField(groupFieldIDname), data.getField(col.fieldname));
    }
    return grid;
  }
  
  private String initGridStructure(){
    String grid="\n<TABLE cellspacing=\"0\" class=\"DataGrid_Table\">\n";
    grid=grid + " <colgroup span=\""+ String.valueOf(maxcols) + "\"></colgroup>";
    return grid;
  }
  
  private String emptycols(int emptycols){
    String grid="";
    for (int i = 0; i < emptycols; i++) {
      grid=grid + "<TD></TD>";
    }
    return grid;
  }
  
  private String btnEexpandGroup(String groupIdValue){
    String grid="<TD class=\"DataGrid_Content\">\n<BUTTON type=\"button\" onclick=\"toggleDisplayMode('"+ groupIdValue +"')\">+</BUTTON>\n</TD>\n";
    return grid;
  }
  
  private String cbSelectAllBelow(String groupIdColumn, Boolean isvisible,String groupIdValue,String upperGroupIDValue, String nextLevelIDColumn){
    String vis;
    if (isvisible)
      vis="style=\"display: table-row;\"";
    else
      vis="style=\"display: none;\"";
    //String grid="<td class=\"Checkbox_container_NOT_Focused\"><INPUT name=\"inp" + groupIdColumn + upperGroupIDValue +"\"  value=\"" + groupIdValue + "\" id=\"" + groupIdValue + "\"  parentId=\"" + upperGroupIDValue + "\" type=\"checkbox\" onchange=\"gridHeaderCheckboxChange(this.parentId, this.checked);return true;\" onclick=\"gridHeaderCheckboxClick(this.value, this.checked,this.name);return true;\" " + vis +" class=\"Checkbox_NOT_Focused\"></td>\n";
    String grid="<TD class=\"DataGrid_Content\"><INPUT name=\"inp" + groupIdColumn + upperGroupIDValue +"\"  value=\"" + groupIdValue + "\" id=\"" + groupIdValue + "\"  parentId=\"" + upperGroupIDValue + "\" type=\"checkbox\" onclick=\"gridLineCheckboxClick('" +  groupIdValue +  "');return true;\" " + vis +" class=\"Checkbox_NOT_Focused\"></TD>\n";
    return grid;
  }
  
  private String cbSelectLine(String groupIdColumn, String groupIdValue, String lineId, Boolean isvisible, int counter){
    String vis;
    String grid="";
    if (isvisible)
      vis="style=\"display: table-row;\"";
    else
      vis="style=\"display: none;\"";
    //onchange=\"updateData(this.value, this.checked);return true;\"
    //String grid="<td class=\"Checkbox_container_NOT_Focused\"><INPUT type=\"checkbox\" name=\"inp" + groupIdColumn + groupIdValue + "\" id=\"" + lineId + "\"   parentId=\"" + groupIdValue + "\"  onclick=\"gridLineCheckboxClick('" +  groupIdColumn + "','" + groupIdValue +  "');return true;\" value=\"" + lineId + "\" " + vis + "></td>\n";
    if (isvisible){
      grid="<TD style=\"width:25px;\" class=\"DataGrid_Content\"><INPUT type=\"checkbox\" name=\"inp" + groupIdColumn + groupIdValue + "\" id=\"" + lineId + "\"   parentId=\"" + groupIdValue + "\"  onclick=\"gridLineCheckboxClick('" +  lineId +  "');return true;\" value=\"" + lineId + "\" " + vis + "></TD>\n";
    } else {
      grid="<TD style=\"width:25px;\" class=\"DataGrid_Content\">" + Integer.toString(counter+1) + "<INPUT type=\"checkbox\" name=\"inp" + groupIdColumn + groupIdValue + "\" id=\"" + lineId + "\"   parentId=\"" + groupIdValue + "\"  onclick=\"gridLineCheckboxClick('" +  lineId +  "');return true;\" value=\"" + lineId + "\" " + vis + "></TD>\n";
    }
      
    return grid;
  }
  
}

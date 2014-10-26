
package org.openbravo.erpCommon.utility.reporting;

public class DocumentType {
  

  private String _tableName;
  private String _contextSubFolder;
  private String _defaultdoctypename;
  private boolean _multilanguage;
  private String _additionalfieldgroup;
  private String _docconfigfunction;
  private String _doctype;

  public DocumentType(String doctype,String tableName, String contextSubFolder, String defaultdoctypename, boolean multilanguage, String additionalfieldgroup, String docconfigfunction) {
    _tableName = tableName;
    _contextSubFolder = contextSubFolder;
    _defaultdoctypename = defaultdoctypename;
    _multilanguage = multilanguage;
    _additionalfieldgroup = additionalfieldgroup;
    _docconfigfunction = docconfigfunction;
    _doctype=doctype;
  }

  public String getTableName() {
    return _tableName;
  }
  public String getAdditionalFieldgroup() {
    return _additionalfieldgroup;
  }
  public boolean isMultiLanguage() {
    return _multilanguage;
  }
  // If no Default Doctype name is set, System assumes to have c_doctype_id column in the Table
  public String getDefaultDoctypeName() {
    return _defaultdoctypename;
  }
  // Configuration Function for Doctype (see  c_getDefaultDocInfo)
   public String getDocConfigFunction() {
     return _docconfigfunction;
   }
  public String getContextSubFolder() {
    return _contextSubFolder;
  }
  public String getDoctype() {
    return _doctype;
  }
}

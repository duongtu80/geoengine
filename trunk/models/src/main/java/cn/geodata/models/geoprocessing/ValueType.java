/*
 * XML Type:  valueType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ValueType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing;


/**
 * An XML valueType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public interface ValueType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ValueType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD2C1AFB524157171088CF014117DE1E9").resolveHandle("valuetypec645type");
    
    /**
     * Gets the "id" element
     */
    java.lang.String getId();
    
    /**
     * Gets (as xml) the "id" element
     */
    org.apache.xmlbeans.XmlString xgetId();
    
    /**
     * Sets the "id" element
     */
    void setId(java.lang.String id);
    
    /**
     * Sets (as xml) the "id" element
     */
    void xsetId(org.apache.xmlbeans.XmlString id);
    
    /**
     * Gets the "title" element
     */
    java.lang.String getTitle();
    
    /**
     * Gets (as xml) the "title" element
     */
    org.apache.xmlbeans.XmlString xgetTitle();
    
    /**
     * Sets the "title" element
     */
    void setTitle(java.lang.String title);
    
    /**
     * Sets (as xml) the "title" element
     */
    void xsetTitle(org.apache.xmlbeans.XmlString title);
    
    /**
     * Gets the "describe" element
     */
    java.lang.String getDescribe();
    
    /**
     * Gets (as xml) the "describe" element
     */
    org.apache.xmlbeans.XmlString xgetDescribe();
    
    /**
     * Sets the "describe" element
     */
    void setDescribe(java.lang.String describe);
    
    /**
     * Sets (as xml) the "describe" element
     */
    void xsetDescribe(org.apache.xmlbeans.XmlString describe);
    
    /**
     * Gets the "tags" element
     */
    java.lang.String getTags();
    
    /**
     * Gets (as xml) the "tags" element
     */
    org.apache.xmlbeans.XmlString xgetTags();
    
    /**
     * True if has "tags" element
     */
    boolean isSetTags();
    
    /**
     * Sets the "tags" element
     */
    void setTags(java.lang.String tags);
    
    /**
     * Sets (as xml) the "tags" element
     */
    void xsetTags(org.apache.xmlbeans.XmlString tags);
    
    /**
     * Unsets the "tags" element
     */
    void unsetTags();
    
    /**
     * Gets the "metadata" element
     */
    java.lang.String getMetadata();
    
    /**
     * Gets (as xml) the "metadata" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetMetadata();
    
    /**
     * True if has "metadata" element
     */
    boolean isSetMetadata();
    
    /**
     * Sets the "metadata" element
     */
    void setMetadata(java.lang.String metadata);
    
    /**
     * Sets (as xml) the "metadata" element
     */
    void xsetMetadata(org.apache.xmlbeans.XmlAnyURI metadata);
    
    /**
     * Unsets the "metadata" element
     */
    void unsetMetadata();
    
    /**
     * Gets array of all "category" elements
     */
    java.lang.String[] getCategoryArray();
    
    /**
     * Gets ith "category" element
     */
    java.lang.String getCategoryArray(int i);
    
    /**
     * Gets (as xml) array of all "category" elements
     */
    org.apache.xmlbeans.XmlString[] xgetCategoryArray();
    
    /**
     * Gets (as xml) ith "category" element
     */
    org.apache.xmlbeans.XmlString xgetCategoryArray(int i);
    
    /**
     * Returns number of "category" element
     */
    int sizeOfCategoryArray();
    
    /**
     * Sets array of all "category" element
     */
    void setCategoryArray(java.lang.String[] categoryArray);
    
    /**
     * Sets ith "category" element
     */
    void setCategoryArray(int i, java.lang.String category);
    
    /**
     * Sets (as xml) array of all "category" element
     */
    void xsetCategoryArray(org.apache.xmlbeans.XmlString[] categoryArray);
    
    /**
     * Sets (as xml) ith "category" element
     */
    void xsetCategoryArray(int i, org.apache.xmlbeans.XmlString category);
    
    /**
     * Inserts the value as the ith "category" element
     */
    void insertCategory(int i, java.lang.String category);
    
    /**
     * Appends the value as the last "category" element
     */
    void addCategory(java.lang.String category);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "category" element
     */
    org.apache.xmlbeans.XmlString insertNewCategory(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "category" element
     */
    org.apache.xmlbeans.XmlString addNewCategory();
    
    /**
     * Removes the ith "category" element
     */
    void removeCategory(int i);
    
    /**
     * Gets the "occurs" element
     */
    java.lang.String getOccurs();
    
    /**
     * Gets (as xml) the "occurs" element
     */
    org.apache.xmlbeans.XmlString xgetOccurs();
    
    /**
     * True if has "occurs" element
     */
    boolean isSetOccurs();
    
    /**
     * Sets the "occurs" element
     */
    void setOccurs(java.lang.String occurs);
    
    /**
     * Sets (as xml) the "occurs" element
     */
    void xsetOccurs(org.apache.xmlbeans.XmlString occurs);
    
    /**
     * Unsets the "occurs" element
     */
    void unsetOccurs();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cn.geodata.models.geoprocessing.ValueType newInstance() {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cn.geodata.models.geoprocessing.ValueType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cn.geodata.models.geoprocessing.ValueType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cn.geodata.models.geoprocessing.ValueType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ValueType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.ValueType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.ValueType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.ValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

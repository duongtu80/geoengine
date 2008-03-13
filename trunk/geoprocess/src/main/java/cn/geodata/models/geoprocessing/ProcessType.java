/*
 * XML Type:  processType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ProcessType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing;


/**
 * An XML processType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public interface ProcessType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s18035915BE4B4DC262DF2F41C2FD4884").resolveHandle("processtypeff47type");
    
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
     * True if has "describe" element
     */
    boolean isSetDescribe();
    
    /**
     * Sets the "describe" element
     */
    void setDescribe(java.lang.String describe);
    
    /**
     * Sets (as xml) the "describe" element
     */
    void xsetDescribe(org.apache.xmlbeans.XmlString describe);
    
    /**
     * Unsets the "describe" element
     */
    void unsetDescribe();
    
    /**
     * Gets array of all "tags" elements
     */
    java.lang.String[] getTagsArray();
    
    /**
     * Gets ith "tags" element
     */
    java.lang.String getTagsArray(int i);
    
    /**
     * Gets (as xml) array of all "tags" elements
     */
    org.apache.xmlbeans.XmlString[] xgetTagsArray();
    
    /**
     * Gets (as xml) ith "tags" element
     */
    org.apache.xmlbeans.XmlString xgetTagsArray(int i);
    
    /**
     * Returns number of "tags" element
     */
    int sizeOfTagsArray();
    
    /**
     * Sets array of all "tags" element
     */
    void setTagsArray(java.lang.String[] tagsArray);
    
    /**
     * Sets ith "tags" element
     */
    void setTagsArray(int i, java.lang.String tags);
    
    /**
     * Sets (as xml) array of all "tags" element
     */
    void xsetTagsArray(org.apache.xmlbeans.XmlString[] tagsArray);
    
    /**
     * Sets (as xml) ith "tags" element
     */
    void xsetTagsArray(int i, org.apache.xmlbeans.XmlString tags);
    
    /**
     * Inserts the value as the ith "tags" element
     */
    void insertTags(int i, java.lang.String tags);
    
    /**
     * Appends the value as the last "tags" element
     */
    void addTags(java.lang.String tags);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "tags" element
     */
    org.apache.xmlbeans.XmlString insertNewTags(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "tags" element
     */
    org.apache.xmlbeans.XmlString addNewTags();
    
    /**
     * Removes the ith "tags" element
     */
    void removeTags(int i);
    
    /**
     * Gets array of all "metadata" elements
     */
    java.lang.String[] getMetadataArray();
    
    /**
     * Gets ith "metadata" element
     */
    java.lang.String getMetadataArray(int i);
    
    /**
     * Gets (as xml) array of all "metadata" elements
     */
    org.apache.xmlbeans.XmlAnyURI[] xgetMetadataArray();
    
    /**
     * Gets (as xml) ith "metadata" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetMetadataArray(int i);
    
    /**
     * Returns number of "metadata" element
     */
    int sizeOfMetadataArray();
    
    /**
     * Sets array of all "metadata" element
     */
    void setMetadataArray(java.lang.String[] metadataArray);
    
    /**
     * Sets ith "metadata" element
     */
    void setMetadataArray(int i, java.lang.String metadata);
    
    /**
     * Sets (as xml) array of all "metadata" element
     */
    void xsetMetadataArray(org.apache.xmlbeans.XmlAnyURI[] metadataArray);
    
    /**
     * Sets (as xml) ith "metadata" element
     */
    void xsetMetadataArray(int i, org.apache.xmlbeans.XmlAnyURI metadata);
    
    /**
     * Inserts the value as the ith "metadata" element
     */
    void insertMetadata(int i, java.lang.String metadata);
    
    /**
     * Appends the value as the last "metadata" element
     */
    void addMetadata(java.lang.String metadata);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "metadata" element
     */
    org.apache.xmlbeans.XmlAnyURI insertNewMetadata(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "metadata" element
     */
    org.apache.xmlbeans.XmlAnyURI addNewMetadata();
    
    /**
     * Removes the ith "metadata" element
     */
    void removeMetadata(int i);
    
    /**
     * Gets the "inputs" element
     */
    cn.geodata.models.geoprocessing.InputsType getInputs();
    
    /**
     * Sets the "inputs" element
     */
    void setInputs(cn.geodata.models.geoprocessing.InputsType inputs);
    
    /**
     * Appends and returns a new empty "inputs" element
     */
    cn.geodata.models.geoprocessing.InputsType addNewInputs();
    
    /**
     * Gets the "outputs" element
     */
    cn.geodata.models.geoprocessing.OutputsType getOutputs();
    
    /**
     * Sets the "outputs" element
     */
    void setOutputs(cn.geodata.models.geoprocessing.OutputsType outputs);
    
    /**
     * Appends and returns a new empty "outputs" element
     */
    cn.geodata.models.geoprocessing.OutputsType addNewOutputs();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cn.geodata.models.geoprocessing.ProcessType newInstance() {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.ProcessType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.ProcessType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.ProcessType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

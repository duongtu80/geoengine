/*
 * XML Type:  ResponseDocumentType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ResponseDocumentType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * An XML ResponseDocumentType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public interface ResponseDocumentType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ResponseDocumentType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("responsedocumenttypee21ftype");
    
    /**
     * Gets array of all "Output" elements
     */
    net.opengis.wps.x100.DocumentOutputDefinitionType[] getOutputArray();
    
    /**
     * Gets ith "Output" element
     */
    net.opengis.wps.x100.DocumentOutputDefinitionType getOutputArray(int i);
    
    /**
     * Returns number of "Output" element
     */
    int sizeOfOutputArray();
    
    /**
     * Sets array of all "Output" element
     */
    void setOutputArray(net.opengis.wps.x100.DocumentOutputDefinitionType[] outputArray);
    
    /**
     * Sets ith "Output" element
     */
    void setOutputArray(int i, net.opengis.wps.x100.DocumentOutputDefinitionType output);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Output" element
     */
    net.opengis.wps.x100.DocumentOutputDefinitionType insertNewOutput(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Output" element
     */
    net.opengis.wps.x100.DocumentOutputDefinitionType addNewOutput();
    
    /**
     * Removes the ith "Output" element
     */
    void removeOutput(int i);
    
    /**
     * Gets the "storeExecuteResponse" attribute
     */
    boolean getStoreExecuteResponse();
    
    /**
     * Gets (as xml) the "storeExecuteResponse" attribute
     */
    org.apache.xmlbeans.XmlBoolean xgetStoreExecuteResponse();
    
    /**
     * True if has "storeExecuteResponse" attribute
     */
    boolean isSetStoreExecuteResponse();
    
    /**
     * Sets the "storeExecuteResponse" attribute
     */
    void setStoreExecuteResponse(boolean storeExecuteResponse);
    
    /**
     * Sets (as xml) the "storeExecuteResponse" attribute
     */
    void xsetStoreExecuteResponse(org.apache.xmlbeans.XmlBoolean storeExecuteResponse);
    
    /**
     * Unsets the "storeExecuteResponse" attribute
     */
    void unsetStoreExecuteResponse();
    
    /**
     * Gets the "lineage" attribute
     */
    boolean getLineage();
    
    /**
     * Gets (as xml) the "lineage" attribute
     */
    org.apache.xmlbeans.XmlBoolean xgetLineage();
    
    /**
     * True if has "lineage" attribute
     */
    boolean isSetLineage();
    
    /**
     * Sets the "lineage" attribute
     */
    void setLineage(boolean lineage);
    
    /**
     * Sets (as xml) the "lineage" attribute
     */
    void xsetLineage(org.apache.xmlbeans.XmlBoolean lineage);
    
    /**
     * Unsets the "lineage" attribute
     */
    void unsetLineage();
    
    /**
     * Gets the "status" attribute
     */
    boolean getStatus();
    
    /**
     * Gets (as xml) the "status" attribute
     */
    org.apache.xmlbeans.XmlBoolean xgetStatus();
    
    /**
     * True if has "status" attribute
     */
    boolean isSetStatus();
    
    /**
     * Sets the "status" attribute
     */
    void setStatus(boolean status);
    
    /**
     * Sets (as xml) the "status" attribute
     */
    void xsetStatus(org.apache.xmlbeans.XmlBoolean status);
    
    /**
     * Unsets the "status" attribute
     */
    void unsetStatus();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.ResponseDocumentType newInstance() {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.ResponseDocumentType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ResponseDocumentType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ResponseDocumentType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ResponseDocumentType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

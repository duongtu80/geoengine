/*
 * XML Type:  SupportedComplexDataType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.SupportedComplexDataType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps;


/**
 * An XML SupportedComplexDataType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public interface SupportedComplexDataType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SupportedComplexDataType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("supportedcomplexdatatypefc4ftype");
    
    /**
     * Gets array of all "SupportedComplexData" elements
     */
    net.opengeospatial.wps.ComplexDataType[] getSupportedComplexDataArray();
    
    /**
     * Gets ith "SupportedComplexData" element
     */
    net.opengeospatial.wps.ComplexDataType getSupportedComplexDataArray(int i);
    
    /**
     * Returns number of "SupportedComplexData" element
     */
    int sizeOfSupportedComplexDataArray();
    
    /**
     * Sets array of all "SupportedComplexData" element
     */
    void setSupportedComplexDataArray(net.opengeospatial.wps.ComplexDataType[] supportedComplexDataArray);
    
    /**
     * Sets ith "SupportedComplexData" element
     */
    void setSupportedComplexDataArray(int i, net.opengeospatial.wps.ComplexDataType supportedComplexData);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "SupportedComplexData" element
     */
    net.opengeospatial.wps.ComplexDataType insertNewSupportedComplexData(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "SupportedComplexData" element
     */
    net.opengeospatial.wps.ComplexDataType addNewSupportedComplexData();
    
    /**
     * Removes the ith "SupportedComplexData" element
     */
    void removeSupportedComplexData(int i);
    
    /**
     * Gets the "defaultFormat" attribute
     */
    java.lang.String getDefaultFormat();
    
    /**
     * Gets (as xml) the "defaultFormat" attribute
     */
    net.opengeospatial.ows.MimeType xgetDefaultFormat();
    
    /**
     * True if has "defaultFormat" attribute
     */
    boolean isSetDefaultFormat();
    
    /**
     * Sets the "defaultFormat" attribute
     */
    void setDefaultFormat(java.lang.String defaultFormat);
    
    /**
     * Sets (as xml) the "defaultFormat" attribute
     */
    void xsetDefaultFormat(net.opengeospatial.ows.MimeType defaultFormat);
    
    /**
     * Unsets the "defaultFormat" attribute
     */
    void unsetDefaultFormat();
    
    /**
     * Gets the "defaultEncoding" attribute
     */
    java.lang.String getDefaultEncoding();
    
    /**
     * Gets (as xml) the "defaultEncoding" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetDefaultEncoding();
    
    /**
     * True if has "defaultEncoding" attribute
     */
    boolean isSetDefaultEncoding();
    
    /**
     * Sets the "defaultEncoding" attribute
     */
    void setDefaultEncoding(java.lang.String defaultEncoding);
    
    /**
     * Sets (as xml) the "defaultEncoding" attribute
     */
    void xsetDefaultEncoding(org.apache.xmlbeans.XmlAnyURI defaultEncoding);
    
    /**
     * Unsets the "defaultEncoding" attribute
     */
    void unsetDefaultEncoding();
    
    /**
     * Gets the "defaultSchema" attribute
     */
    java.lang.String getDefaultSchema();
    
    /**
     * Gets (as xml) the "defaultSchema" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetDefaultSchema();
    
    /**
     * True if has "defaultSchema" attribute
     */
    boolean isSetDefaultSchema();
    
    /**
     * Sets the "defaultSchema" attribute
     */
    void setDefaultSchema(java.lang.String defaultSchema);
    
    /**
     * Sets (as xml) the "defaultSchema" attribute
     */
    void xsetDefaultSchema(org.apache.xmlbeans.XmlAnyURI defaultSchema);
    
    /**
     * Unsets the "defaultSchema" attribute
     */
    void unsetDefaultSchema();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.wps.SupportedComplexDataType newInstance() {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.wps.SupportedComplexDataType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.SupportedComplexDataType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.SupportedComplexDataType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.SupportedComplexDataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

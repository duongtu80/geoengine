/*
 * XML Type:  SupportedCRSsType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.SupportedCRSsType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps;


/**
 * An XML SupportedCRSsType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public interface SupportedCRSsType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SupportedCRSsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("supportedcrsstype830etype");
    
    /**
     * Gets array of all "CRS" elements
     */
    java.lang.String[] getCRSArray();
    
    /**
     * Gets ith "CRS" element
     */
    java.lang.String getCRSArray(int i);
    
    /**
     * Gets (as xml) array of all "CRS" elements
     */
    org.apache.xmlbeans.XmlAnyURI[] xgetCRSArray();
    
    /**
     * Gets (as xml) ith "CRS" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetCRSArray(int i);
    
    /**
     * Returns number of "CRS" element
     */
    int sizeOfCRSArray();
    
    /**
     * Sets array of all "CRS" element
     */
    void setCRSArray(java.lang.String[] crsArray);
    
    /**
     * Sets ith "CRS" element
     */
    void setCRSArray(int i, java.lang.String crs);
    
    /**
     * Sets (as xml) array of all "CRS" element
     */
    void xsetCRSArray(org.apache.xmlbeans.XmlAnyURI[] crsArray);
    
    /**
     * Sets (as xml) ith "CRS" element
     */
    void xsetCRSArray(int i, org.apache.xmlbeans.XmlAnyURI crs);
    
    /**
     * Inserts the value as the ith "CRS" element
     */
    void insertCRS(int i, java.lang.String crs);
    
    /**
     * Appends the value as the last "CRS" element
     */
    void addCRS(java.lang.String crs);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "CRS" element
     */
    org.apache.xmlbeans.XmlAnyURI insertNewCRS(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "CRS" element
     */
    org.apache.xmlbeans.XmlAnyURI addNewCRS();
    
    /**
     * Removes the ith "CRS" element
     */
    void removeCRS(int i);
    
    /**
     * Gets the "defaultCRS" attribute
     */
    java.lang.String getDefaultCRS();
    
    /**
     * Gets (as xml) the "defaultCRS" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetDefaultCRS();
    
    /**
     * Sets the "defaultCRS" attribute
     */
    void setDefaultCRS(java.lang.String defaultCRS);
    
    /**
     * Sets (as xml) the "defaultCRS" attribute
     */
    void xsetDefaultCRS(org.apache.xmlbeans.XmlAnyURI defaultCRS);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.wps.SupportedCRSsType newInstance() {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.wps.SupportedCRSsType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.SupportedCRSsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.SupportedCRSsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.SupportedCRSsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

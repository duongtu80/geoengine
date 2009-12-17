/*
 * XML Type:  GetResourceByIdType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.GetResourceByIdType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML GetResourceByIdType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface GetResourceByIdType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetResourceByIdType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("getresourcebyidtype6427type");
    
    /**
     * Gets array of all "ResourceID" elements
     */
    java.lang.String[] getResourceIDArray();
    
    /**
     * Gets ith "ResourceID" element
     */
    java.lang.String getResourceIDArray(int i);
    
    /**
     * Gets (as xml) array of all "ResourceID" elements
     */
    org.apache.xmlbeans.XmlAnyURI[] xgetResourceIDArray();
    
    /**
     * Gets (as xml) ith "ResourceID" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetResourceIDArray(int i);
    
    /**
     * Returns number of "ResourceID" element
     */
    int sizeOfResourceIDArray();
    
    /**
     * Sets array of all "ResourceID" element
     */
    void setResourceIDArray(java.lang.String[] resourceIDArray);
    
    /**
     * Sets ith "ResourceID" element
     */
    void setResourceIDArray(int i, java.lang.String resourceID);
    
    /**
     * Sets (as xml) array of all "ResourceID" element
     */
    void xsetResourceIDArray(org.apache.xmlbeans.XmlAnyURI[] resourceIDArray);
    
    /**
     * Sets (as xml) ith "ResourceID" element
     */
    void xsetResourceIDArray(int i, org.apache.xmlbeans.XmlAnyURI resourceID);
    
    /**
     * Inserts the value as the ith "ResourceID" element
     */
    void insertResourceID(int i, java.lang.String resourceID);
    
    /**
     * Appends the value as the last "ResourceID" element
     */
    void addResourceID(java.lang.String resourceID);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ResourceID" element
     */
    org.apache.xmlbeans.XmlAnyURI insertNewResourceID(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ResourceID" element
     */
    org.apache.xmlbeans.XmlAnyURI addNewResourceID();
    
    /**
     * Removes the ith "ResourceID" element
     */
    void removeResourceID(int i);
    
    /**
     * Gets the "OutputFormat" element
     */
    java.lang.String getOutputFormat();
    
    /**
     * Gets (as xml) the "OutputFormat" element
     */
    net.opengis.ows.x11.MimeType xgetOutputFormat();
    
    /**
     * True if has "OutputFormat" element
     */
    boolean isSetOutputFormat();
    
    /**
     * Sets the "OutputFormat" element
     */
    void setOutputFormat(java.lang.String outputFormat);
    
    /**
     * Sets (as xml) the "OutputFormat" element
     */
    void xsetOutputFormat(net.opengis.ows.x11.MimeType outputFormat);
    
    /**
     * Unsets the "OutputFormat" element
     */
    void unsetOutputFormat();
    
    /**
     * Gets the "service" attribute
     */
    java.lang.String getService();
    
    /**
     * Gets (as xml) the "service" attribute
     */
    net.opengis.ows.x11.ServiceType xgetService();
    
    /**
     * Sets the "service" attribute
     */
    void setService(java.lang.String service);
    
    /**
     * Sets (as xml) the "service" attribute
     */
    void xsetService(net.opengis.ows.x11.ServiceType service);
    
    /**
     * Gets the "version" attribute
     */
    java.lang.String getVersion();
    
    /**
     * Gets (as xml) the "version" attribute
     */
    net.opengis.ows.x11.VersionType xgetVersion();
    
    /**
     * Sets the "version" attribute
     */
    void setVersion(java.lang.String version);
    
    /**
     * Sets (as xml) the "version" attribute
     */
    void xsetVersion(net.opengis.ows.x11.VersionType version);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.GetResourceByIdType newInstance() {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.GetResourceByIdType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.GetResourceByIdType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.GetResourceByIdType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.GetResourceByIdType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

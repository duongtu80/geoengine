/*
 * XML Type:  ProcessBriefType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ProcessBriefType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * An XML ProcessBriefType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public interface ProcessBriefType extends net.opengis.wps.x100.DescriptionType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessBriefType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("processbrieftypedc30type");
    
    /**
     * Gets array of all "Profile" elements
     */
    java.lang.String[] getProfileArray();
    
    /**
     * Gets ith "Profile" element
     */
    java.lang.String getProfileArray(int i);
    
    /**
     * Gets (as xml) array of all "Profile" elements
     */
    org.apache.xmlbeans.XmlAnyURI[] xgetProfileArray();
    
    /**
     * Gets (as xml) ith "Profile" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetProfileArray(int i);
    
    /**
     * Returns number of "Profile" element
     */
    int sizeOfProfileArray();
    
    /**
     * Sets array of all "Profile" element
     */
    void setProfileArray(java.lang.String[] profileArray);
    
    /**
     * Sets ith "Profile" element
     */
    void setProfileArray(int i, java.lang.String profile);
    
    /**
     * Sets (as xml) array of all "Profile" element
     */
    void xsetProfileArray(org.apache.xmlbeans.XmlAnyURI[] profileArray);
    
    /**
     * Sets (as xml) ith "Profile" element
     */
    void xsetProfileArray(int i, org.apache.xmlbeans.XmlAnyURI profile);
    
    /**
     * Inserts the value as the ith "Profile" element
     */
    void insertProfile(int i, java.lang.String profile);
    
    /**
     * Appends the value as the last "Profile" element
     */
    void addProfile(java.lang.String profile);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Profile" element
     */
    org.apache.xmlbeans.XmlAnyURI insertNewProfile(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Profile" element
     */
    org.apache.xmlbeans.XmlAnyURI addNewProfile();
    
    /**
     * Removes the ith "Profile" element
     */
    void removeProfile(int i);
    
    /**
     * Gets the "WSDL" element
     */
    net.opengis.wps.x100.WSDLDocument.WSDL getWSDL();
    
    /**
     * True if has "WSDL" element
     */
    boolean isSetWSDL();
    
    /**
     * Sets the "WSDL" element
     */
    void setWSDL(net.opengis.wps.x100.WSDLDocument.WSDL wsdl);
    
    /**
     * Appends and returns a new empty "WSDL" element
     */
    net.opengis.wps.x100.WSDLDocument.WSDL addNewWSDL();
    
    /**
     * Unsets the "WSDL" element
     */
    void unsetWSDL();
    
    /**
     * Gets the "processVersion" attribute
     */
    java.lang.String getProcessVersion();
    
    /**
     * Gets (as xml) the "processVersion" attribute
     */
    org.apache.xmlbeans.XmlString xgetProcessVersion();
    
    /**
     * Sets the "processVersion" attribute
     */
    void setProcessVersion(java.lang.String processVersion);
    
    /**
     * Sets (as xml) the "processVersion" attribute
     */
    void xsetProcessVersion(org.apache.xmlbeans.XmlString processVersion);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.ProcessBriefType newInstance() {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.ProcessBriefType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.ProcessBriefType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.ProcessBriefType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.ProcessBriefType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ProcessBriefType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ProcessBriefType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ProcessBriefType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

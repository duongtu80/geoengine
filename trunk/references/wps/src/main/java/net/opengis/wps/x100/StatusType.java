/*
 * XML Type:  StatusType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.StatusType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * An XML StatusType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public interface StatusType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(StatusType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("statustype3d29type");
    
    /**
     * Gets the "ProcessAccepted" element
     */
    java.lang.String getProcessAccepted();
    
    /**
     * Gets (as xml) the "ProcessAccepted" element
     */
    org.apache.xmlbeans.XmlString xgetProcessAccepted();
    
    /**
     * True if has "ProcessAccepted" element
     */
    boolean isSetProcessAccepted();
    
    /**
     * Sets the "ProcessAccepted" element
     */
    void setProcessAccepted(java.lang.String processAccepted);
    
    /**
     * Sets (as xml) the "ProcessAccepted" element
     */
    void xsetProcessAccepted(org.apache.xmlbeans.XmlString processAccepted);
    
    /**
     * Unsets the "ProcessAccepted" element
     */
    void unsetProcessAccepted();
    
    /**
     * Gets the "ProcessStarted" element
     */
    net.opengis.wps.x100.ProcessStartedType getProcessStarted();
    
    /**
     * True if has "ProcessStarted" element
     */
    boolean isSetProcessStarted();
    
    /**
     * Sets the "ProcessStarted" element
     */
    void setProcessStarted(net.opengis.wps.x100.ProcessStartedType processStarted);
    
    /**
     * Appends and returns a new empty "ProcessStarted" element
     */
    net.opengis.wps.x100.ProcessStartedType addNewProcessStarted();
    
    /**
     * Unsets the "ProcessStarted" element
     */
    void unsetProcessStarted();
    
    /**
     * Gets the "ProcessPaused" element
     */
    net.opengis.wps.x100.ProcessStartedType getProcessPaused();
    
    /**
     * True if has "ProcessPaused" element
     */
    boolean isSetProcessPaused();
    
    /**
     * Sets the "ProcessPaused" element
     */
    void setProcessPaused(net.opengis.wps.x100.ProcessStartedType processPaused);
    
    /**
     * Appends and returns a new empty "ProcessPaused" element
     */
    net.opengis.wps.x100.ProcessStartedType addNewProcessPaused();
    
    /**
     * Unsets the "ProcessPaused" element
     */
    void unsetProcessPaused();
    
    /**
     * Gets the "ProcessSucceeded" element
     */
    java.lang.String getProcessSucceeded();
    
    /**
     * Gets (as xml) the "ProcessSucceeded" element
     */
    org.apache.xmlbeans.XmlString xgetProcessSucceeded();
    
    /**
     * True if has "ProcessSucceeded" element
     */
    boolean isSetProcessSucceeded();
    
    /**
     * Sets the "ProcessSucceeded" element
     */
    void setProcessSucceeded(java.lang.String processSucceeded);
    
    /**
     * Sets (as xml) the "ProcessSucceeded" element
     */
    void xsetProcessSucceeded(org.apache.xmlbeans.XmlString processSucceeded);
    
    /**
     * Unsets the "ProcessSucceeded" element
     */
    void unsetProcessSucceeded();
    
    /**
     * Gets the "ProcessFailed" element
     */
    net.opengis.wps.x100.ProcessFailedType getProcessFailed();
    
    /**
     * True if has "ProcessFailed" element
     */
    boolean isSetProcessFailed();
    
    /**
     * Sets the "ProcessFailed" element
     */
    void setProcessFailed(net.opengis.wps.x100.ProcessFailedType processFailed);
    
    /**
     * Appends and returns a new empty "ProcessFailed" element
     */
    net.opengis.wps.x100.ProcessFailedType addNewProcessFailed();
    
    /**
     * Unsets the "ProcessFailed" element
     */
    void unsetProcessFailed();
    
    /**
     * Gets the "creationTime" attribute
     */
    java.util.Calendar getCreationTime();
    
    /**
     * Gets (as xml) the "creationTime" attribute
     */
    org.apache.xmlbeans.XmlDateTime xgetCreationTime();
    
    /**
     * Sets the "creationTime" attribute
     */
    void setCreationTime(java.util.Calendar creationTime);
    
    /**
     * Sets (as xml) the "creationTime" attribute
     */
    void xsetCreationTime(org.apache.xmlbeans.XmlDateTime creationTime);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.StatusType newInstance() {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.StatusType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.StatusType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.StatusType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.StatusType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.StatusType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.StatusType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.StatusType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.StatusType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.StatusType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.StatusType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.StatusType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.StatusType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.StatusType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.StatusType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.StatusType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.StatusType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.StatusType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.StatusType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

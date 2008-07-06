/*
 * XML Type:  CapabilitiesBaseType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.CapabilitiesBaseType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * An XML CapabilitiesBaseType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public interface CapabilitiesBaseType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CapabilitiesBaseType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("capabilitiesbasetype9c1btype");
    
    /**
     * Gets the "ServiceIdentification" element
     */
    net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification getServiceIdentification();
    
    /**
     * True if has "ServiceIdentification" element
     */
    boolean isSetServiceIdentification();
    
    /**
     * Sets the "ServiceIdentification" element
     */
    void setServiceIdentification(net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification serviceIdentification);
    
    /**
     * Appends and returns a new empty "ServiceIdentification" element
     */
    net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification addNewServiceIdentification();
    
    /**
     * Unsets the "ServiceIdentification" element
     */
    void unsetServiceIdentification();
    
    /**
     * Gets the "ServiceProvider" element
     */
    net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider getServiceProvider();
    
    /**
     * True if has "ServiceProvider" element
     */
    boolean isSetServiceProvider();
    
    /**
     * Sets the "ServiceProvider" element
     */
    void setServiceProvider(net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider serviceProvider);
    
    /**
     * Appends and returns a new empty "ServiceProvider" element
     */
    net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider addNewServiceProvider();
    
    /**
     * Unsets the "ServiceProvider" element
     */
    void unsetServiceProvider();
    
    /**
     * Gets the "OperationsMetadata" element
     */
    net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata getOperationsMetadata();
    
    /**
     * True if has "OperationsMetadata" element
     */
    boolean isSetOperationsMetadata();
    
    /**
     * Sets the "OperationsMetadata" element
     */
    void setOperationsMetadata(net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata operationsMetadata);
    
    /**
     * Appends and returns a new empty "OperationsMetadata" element
     */
    net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata addNewOperationsMetadata();
    
    /**
     * Unsets the "OperationsMetadata" element
     */
    void unsetOperationsMetadata();
    
    /**
     * Gets the "version" attribute
     */
    java.lang.String getVersion();
    
    /**
     * Gets (as xml) the "version" attribute
     */
    net.opengeospatial.ows.VersionType xgetVersion();
    
    /**
     * Sets the "version" attribute
     */
    void setVersion(java.lang.String version);
    
    /**
     * Sets (as xml) the "version" attribute
     */
    void xsetVersion(net.opengeospatial.ows.VersionType version);
    
    /**
     * Gets the "updateSequence" attribute
     */
    java.lang.String getUpdateSequence();
    
    /**
     * Gets (as xml) the "updateSequence" attribute
     */
    net.opengeospatial.ows.UpdateSequenceType xgetUpdateSequence();
    
    /**
     * True if has "updateSequence" attribute
     */
    boolean isSetUpdateSequence();
    
    /**
     * Sets the "updateSequence" attribute
     */
    void setUpdateSequence(java.lang.String updateSequence);
    
    /**
     * Sets (as xml) the "updateSequence" attribute
     */
    void xsetUpdateSequence(net.opengeospatial.ows.UpdateSequenceType updateSequence);
    
    /**
     * Unsets the "updateSequence" attribute
     */
    void unsetUpdateSequence();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.CapabilitiesBaseType newInstance() {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.CapabilitiesBaseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.CapabilitiesBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

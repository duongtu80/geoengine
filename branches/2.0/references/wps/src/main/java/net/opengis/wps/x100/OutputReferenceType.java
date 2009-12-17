/*
 * XML Type:  OutputReferenceType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.OutputReferenceType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * An XML OutputReferenceType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public interface OutputReferenceType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OutputReferenceType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("outputreferencetypee303type");
    
    /**
     * Gets the "href" attribute
     */
    java.lang.String getHref();
    
    /**
     * Gets (as xml) the "href" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetHref();
    
    /**
     * Sets the "href" attribute
     */
    void setHref(java.lang.String href);
    
    /**
     * Sets (as xml) the "href" attribute
     */
    void xsetHref(org.apache.xmlbeans.XmlAnyURI href);
    
    /**
     * Gets the "mimeType" attribute
     */
    java.lang.String getMimeType();
    
    /**
     * Gets (as xml) the "mimeType" attribute
     */
    net.opengis.ows.x11.MimeType xgetMimeType();
    
    /**
     * True if has "mimeType" attribute
     */
    boolean isSetMimeType();
    
    /**
     * Sets the "mimeType" attribute
     */
    void setMimeType(java.lang.String mimeType);
    
    /**
     * Sets (as xml) the "mimeType" attribute
     */
    void xsetMimeType(net.opengis.ows.x11.MimeType mimeType);
    
    /**
     * Unsets the "mimeType" attribute
     */
    void unsetMimeType();
    
    /**
     * Gets the "encoding" attribute
     */
    java.lang.String getEncoding();
    
    /**
     * Gets (as xml) the "encoding" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetEncoding();
    
    /**
     * True if has "encoding" attribute
     */
    boolean isSetEncoding();
    
    /**
     * Sets the "encoding" attribute
     */
    void setEncoding(java.lang.String encoding);
    
    /**
     * Sets (as xml) the "encoding" attribute
     */
    void xsetEncoding(org.apache.xmlbeans.XmlAnyURI encoding);
    
    /**
     * Unsets the "encoding" attribute
     */
    void unsetEncoding();
    
    /**
     * Gets the "schema" attribute
     */
    java.lang.String getSchema();
    
    /**
     * Gets (as xml) the "schema" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetSchema();
    
    /**
     * True if has "schema" attribute
     */
    boolean isSetSchema();
    
    /**
     * Sets the "schema" attribute
     */
    void setSchema(java.lang.String schema);
    
    /**
     * Sets (as xml) the "schema" attribute
     */
    void xsetSchema(org.apache.xmlbeans.XmlAnyURI schema);
    
    /**
     * Unsets the "schema" attribute
     */
    void unsetSchema();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.OutputReferenceType newInstance() {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.OutputReferenceType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.OutputReferenceType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.OutputReferenceType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.OutputReferenceType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.OutputReferenceType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.OutputReferenceType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.OutputReferenceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

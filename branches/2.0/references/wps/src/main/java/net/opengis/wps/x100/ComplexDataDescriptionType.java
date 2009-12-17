/*
 * XML Type:  ComplexDataDescriptionType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ComplexDataDescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * An XML ComplexDataDescriptionType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public interface ComplexDataDescriptionType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ComplexDataDescriptionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("complexdatadescriptiontypeb1f9type");
    
    /**
     * Gets the "MimeType" element
     */
    java.lang.String getMimeType();
    
    /**
     * Gets (as xml) the "MimeType" element
     */
    net.opengis.ows.x11.MimeType xgetMimeType();
    
    /**
     * Sets the "MimeType" element
     */
    void setMimeType(java.lang.String mimeType);
    
    /**
     * Sets (as xml) the "MimeType" element
     */
    void xsetMimeType(net.opengis.ows.x11.MimeType mimeType);
    
    /**
     * Gets the "Encoding" element
     */
    java.lang.String getEncoding();
    
    /**
     * Gets (as xml) the "Encoding" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetEncoding();
    
    /**
     * True if has "Encoding" element
     */
    boolean isSetEncoding();
    
    /**
     * Sets the "Encoding" element
     */
    void setEncoding(java.lang.String encoding);
    
    /**
     * Sets (as xml) the "Encoding" element
     */
    void xsetEncoding(org.apache.xmlbeans.XmlAnyURI encoding);
    
    /**
     * Unsets the "Encoding" element
     */
    void unsetEncoding();
    
    /**
     * Gets the "Schema" element
     */
    java.lang.String getSchema();
    
    /**
     * Gets (as xml) the "Schema" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetSchema();
    
    /**
     * True if has "Schema" element
     */
    boolean isSetSchema();
    
    /**
     * Sets the "Schema" element
     */
    void setSchema(java.lang.String schema);
    
    /**
     * Sets (as xml) the "Schema" element
     */
    void xsetSchema(org.apache.xmlbeans.XmlAnyURI schema);
    
    /**
     * Unsets the "Schema" element
     */
    void unsetSchema();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.ComplexDataDescriptionType newInstance() {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ComplexDataDescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ComplexDataDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

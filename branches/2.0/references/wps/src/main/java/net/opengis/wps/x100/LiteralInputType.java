/*
 * XML Type:  LiteralInputType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.LiteralInputType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * An XML LiteralInputType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public interface LiteralInputType extends net.opengis.wps.x100.LiteralOutputType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LiteralInputType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("literalinputtype7120type");
    
    /**
     * Gets the "AllowedValues" element
     */
    net.opengis.ows.x11.AllowedValuesDocument.AllowedValues getAllowedValues();
    
    /**
     * True if has "AllowedValues" element
     */
    boolean isSetAllowedValues();
    
    /**
     * Sets the "AllowedValues" element
     */
    void setAllowedValues(net.opengis.ows.x11.AllowedValuesDocument.AllowedValues allowedValues);
    
    /**
     * Appends and returns a new empty "AllowedValues" element
     */
    net.opengis.ows.x11.AllowedValuesDocument.AllowedValues addNewAllowedValues();
    
    /**
     * Unsets the "AllowedValues" element
     */
    void unsetAllowedValues();
    
    /**
     * Gets the "AnyValue" element
     */
    net.opengis.ows.x11.AnyValueDocument.AnyValue getAnyValue();
    
    /**
     * True if has "AnyValue" element
     */
    boolean isSetAnyValue();
    
    /**
     * Sets the "AnyValue" element
     */
    void setAnyValue(net.opengis.ows.x11.AnyValueDocument.AnyValue anyValue);
    
    /**
     * Appends and returns a new empty "AnyValue" element
     */
    net.opengis.ows.x11.AnyValueDocument.AnyValue addNewAnyValue();
    
    /**
     * Unsets the "AnyValue" element
     */
    void unsetAnyValue();
    
    /**
     * Gets the "ValuesReference" element
     */
    net.opengis.wps.x100.ValuesReferenceType getValuesReference();
    
    /**
     * True if has "ValuesReference" element
     */
    boolean isSetValuesReference();
    
    /**
     * Sets the "ValuesReference" element
     */
    void setValuesReference(net.opengis.wps.x100.ValuesReferenceType valuesReference);
    
    /**
     * Appends and returns a new empty "ValuesReference" element
     */
    net.opengis.wps.x100.ValuesReferenceType addNewValuesReference();
    
    /**
     * Unsets the "ValuesReference" element
     */
    void unsetValuesReference();
    
    /**
     * Gets the "DefaultValue" element
     */
    java.lang.String getDefaultValue();
    
    /**
     * Gets (as xml) the "DefaultValue" element
     */
    org.apache.xmlbeans.XmlString xgetDefaultValue();
    
    /**
     * True if has "DefaultValue" element
     */
    boolean isSetDefaultValue();
    
    /**
     * Sets the "DefaultValue" element
     */
    void setDefaultValue(java.lang.String defaultValue);
    
    /**
     * Sets (as xml) the "DefaultValue" element
     */
    void xsetDefaultValue(org.apache.xmlbeans.XmlString defaultValue);
    
    /**
     * Unsets the "DefaultValue" element
     */
    void unsetDefaultValue();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.LiteralInputType newInstance() {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.LiteralInputType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.LiteralInputType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.LiteralInputType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.LiteralInputType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.LiteralInputType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.LiteralInputType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.LiteralInputType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

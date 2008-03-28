/*
 * XML Type:  IOValueType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.IOValueType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps;


/**
 * An XML IOValueType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public interface IOValueType extends net.opengeospatial.wps.DescriptionType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(IOValueType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("iovaluetypea4fctype");
    
    /**
     * Gets the "ComplexValueReference" element
     */
    net.opengeospatial.wps.IOValueType.ComplexValueReference getComplexValueReference();
    
    /**
     * True if has "ComplexValueReference" element
     */
    boolean isSetComplexValueReference();
    
    /**
     * Sets the "ComplexValueReference" element
     */
    void setComplexValueReference(net.opengeospatial.wps.IOValueType.ComplexValueReference complexValueReference);
    
    /**
     * Appends and returns a new empty "ComplexValueReference" element
     */
    net.opengeospatial.wps.IOValueType.ComplexValueReference addNewComplexValueReference();
    
    /**
     * Unsets the "ComplexValueReference" element
     */
    void unsetComplexValueReference();
    
    /**
     * Gets the "ComplexValue" element
     */
    net.opengeospatial.wps.ComplexValueType getComplexValue();
    
    /**
     * True if has "ComplexValue" element
     */
    boolean isSetComplexValue();
    
    /**
     * Sets the "ComplexValue" element
     */
    void setComplexValue(net.opengeospatial.wps.ComplexValueType complexValue);
    
    /**
     * Appends and returns a new empty "ComplexValue" element
     */
    net.opengeospatial.wps.ComplexValueType addNewComplexValue();
    
    /**
     * Unsets the "ComplexValue" element
     */
    void unsetComplexValue();
    
    /**
     * Gets the "LiteralValue" element
     */
    net.opengeospatial.wps.LiteralValueType getLiteralValue();
    
    /**
     * True if has "LiteralValue" element
     */
    boolean isSetLiteralValue();
    
    /**
     * Sets the "LiteralValue" element
     */
    void setLiteralValue(net.opengeospatial.wps.LiteralValueType literalValue);
    
    /**
     * Appends and returns a new empty "LiteralValue" element
     */
    net.opengeospatial.wps.LiteralValueType addNewLiteralValue();
    
    /**
     * Unsets the "LiteralValue" element
     */
    void unsetLiteralValue();
    
    /**
     * Gets the "BoundingBoxValue" element
     */
    net.opengeospatial.ows.BoundingBoxType getBoundingBoxValue();
    
    /**
     * True if has "BoundingBoxValue" element
     */
    boolean isSetBoundingBoxValue();
    
    /**
     * Sets the "BoundingBoxValue" element
     */
    void setBoundingBoxValue(net.opengeospatial.ows.BoundingBoxType boundingBoxValue);
    
    /**
     * Appends and returns a new empty "BoundingBoxValue" element
     */
    net.opengeospatial.ows.BoundingBoxType addNewBoundingBoxValue();
    
    /**
     * Unsets the "BoundingBoxValue" element
     */
    void unsetBoundingBoxValue();
    
    /**
     * An XML ComplexValueReference(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public interface ComplexValueReference extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ComplexValueReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("complexvaluereferenced0f2elemtype");
        
        /**
         * Gets the "reference" attribute
         */
        java.lang.String getReference();
        
        /**
         * Gets (as xml) the "reference" attribute
         */
        org.apache.xmlbeans.XmlAnyURI xgetReference();
        
        /**
         * Sets the "reference" attribute
         */
        void setReference(java.lang.String reference);
        
        /**
         * Sets (as xml) the "reference" attribute
         */
        void xsetReference(org.apache.xmlbeans.XmlAnyURI reference);
        
        /**
         * Gets the "format" attribute
         */
        java.lang.String getFormat();
        
        /**
         * Gets (as xml) the "format" attribute
         */
        net.opengeospatial.ows.MimeType xgetFormat();
        
        /**
         * True if has "format" attribute
         */
        boolean isSetFormat();
        
        /**
         * Sets the "format" attribute
         */
        void setFormat(java.lang.String format);
        
        /**
         * Sets (as xml) the "format" attribute
         */
        void xsetFormat(net.opengeospatial.ows.MimeType format);
        
        /**
         * Unsets the "format" attribute
         */
        void unsetFormat();
        
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
            public static net.opengeospatial.wps.IOValueType.ComplexValueReference newInstance() {
              return (net.opengeospatial.wps.IOValueType.ComplexValueReference) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.wps.IOValueType.ComplexValueReference newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.wps.IOValueType.ComplexValueReference) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.wps.IOValueType newInstance() {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.wps.IOValueType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.wps.IOValueType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.wps.IOValueType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.wps.IOValueType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.wps.IOValueType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.wps.IOValueType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.wps.IOValueType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.wps.IOValueType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.wps.IOValueType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.wps.IOValueType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.wps.IOValueType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.wps.IOValueType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.wps.IOValueType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.wps.IOValueType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.wps.IOValueType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.IOValueType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.IOValueType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.IOValueType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

/*
 * XML Type:  InputDescriptionType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.InputDescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps;


/**
 * An XML InputDescriptionType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public interface InputDescriptionType extends net.opengeospatial.wps.DescriptionType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(InputDescriptionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("inputdescriptiontypef335type");
    
    /**
     * Gets the "ComplexData" element
     */
    net.opengeospatial.wps.SupportedComplexDataType getComplexData();
    
    /**
     * True if has "ComplexData" element
     */
    boolean isSetComplexData();
    
    /**
     * Sets the "ComplexData" element
     */
    void setComplexData(net.opengeospatial.wps.SupportedComplexDataType complexData);
    
    /**
     * Appends and returns a new empty "ComplexData" element
     */
    net.opengeospatial.wps.SupportedComplexDataType addNewComplexData();
    
    /**
     * Unsets the "ComplexData" element
     */
    void unsetComplexData();
    
    /**
     * Gets the "LiteralData" element
     */
    net.opengeospatial.wps.LiteralInputType getLiteralData();
    
    /**
     * True if has "LiteralData" element
     */
    boolean isSetLiteralData();
    
    /**
     * Sets the "LiteralData" element
     */
    void setLiteralData(net.opengeospatial.wps.LiteralInputType literalData);
    
    /**
     * Appends and returns a new empty "LiteralData" element
     */
    net.opengeospatial.wps.LiteralInputType addNewLiteralData();
    
    /**
     * Unsets the "LiteralData" element
     */
    void unsetLiteralData();
    
    /**
     * Gets the "BoundingBoxData" element
     */
    net.opengeospatial.wps.SupportedCRSsType getBoundingBoxData();
    
    /**
     * True if has "BoundingBoxData" element
     */
    boolean isSetBoundingBoxData();
    
    /**
     * Sets the "BoundingBoxData" element
     */
    void setBoundingBoxData(net.opengeospatial.wps.SupportedCRSsType boundingBoxData);
    
    /**
     * Appends and returns a new empty "BoundingBoxData" element
     */
    net.opengeospatial.wps.SupportedCRSsType addNewBoundingBoxData();
    
    /**
     * Unsets the "BoundingBoxData" element
     */
    void unsetBoundingBoxData();
    
    /**
     * Gets the "MinimumOccurs" element
     */
    java.math.BigInteger getMinimumOccurs();
    
    /**
     * Gets (as xml) the "MinimumOccurs" element
     */
    net.opengeospatial.wps.InputDescriptionType.MinimumOccurs xgetMinimumOccurs();
    
    /**
     * True if has "MinimumOccurs" element
     */
    boolean isSetMinimumOccurs();
    
    /**
     * Sets the "MinimumOccurs" element
     */
    void setMinimumOccurs(java.math.BigInteger minimumOccurs);
    
    /**
     * Sets (as xml) the "MinimumOccurs" element
     */
    void xsetMinimumOccurs(net.opengeospatial.wps.InputDescriptionType.MinimumOccurs minimumOccurs);
    
    /**
     * Unsets the "MinimumOccurs" element
     */
    void unsetMinimumOccurs();
    
    /**
     * An XML MinimumOccurs(@http://www.opengeospatial.net/wps).
     *
     * This is an atomic type that is a restriction of net.opengeospatial.wps.InputDescriptionType$MinimumOccurs.
     */
    public interface MinimumOccurs extends org.apache.xmlbeans.XmlNonNegativeInteger
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MinimumOccurs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("minimumoccurse854elemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengeospatial.wps.InputDescriptionType.MinimumOccurs newValue(java.lang.Object obj) {
              return (net.opengeospatial.wps.InputDescriptionType.MinimumOccurs) type.newValue( obj ); }
            
            public static net.opengeospatial.wps.InputDescriptionType.MinimumOccurs newInstance() {
              return (net.opengeospatial.wps.InputDescriptionType.MinimumOccurs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.wps.InputDescriptionType.MinimumOccurs newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.wps.InputDescriptionType.MinimumOccurs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.wps.InputDescriptionType newInstance() {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.wps.InputDescriptionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.wps.InputDescriptionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.wps.InputDescriptionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.wps.InputDescriptionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.InputDescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.InputDescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.InputDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

/*
 * XML Type:  BoundingBoxType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.BoundingBoxType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML BoundingBoxType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface BoundingBoxType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(BoundingBoxType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("boundingboxtypef0f6type");
    
    /**
     * Gets the "LowerCorner" element
     */
    java.util.List getLowerCorner();
    
    /**
     * Gets (as xml) the "LowerCorner" element
     */
    net.opengis.ows.x11.PositionType xgetLowerCorner();
    
    /**
     * Sets the "LowerCorner" element
     */
    void setLowerCorner(java.util.List lowerCorner);
    
    /**
     * Sets (as xml) the "LowerCorner" element
     */
    void xsetLowerCorner(net.opengis.ows.x11.PositionType lowerCorner);
    
    /**
     * Gets the "UpperCorner" element
     */
    java.util.List getUpperCorner();
    
    /**
     * Gets (as xml) the "UpperCorner" element
     */
    net.opengis.ows.x11.PositionType xgetUpperCorner();
    
    /**
     * Sets the "UpperCorner" element
     */
    void setUpperCorner(java.util.List upperCorner);
    
    /**
     * Sets (as xml) the "UpperCorner" element
     */
    void xsetUpperCorner(net.opengis.ows.x11.PositionType upperCorner);
    
    /**
     * Gets the "crs" attribute
     */
    java.lang.String getCrs();
    
    /**
     * Gets (as xml) the "crs" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetCrs();
    
    /**
     * True if has "crs" attribute
     */
    boolean isSetCrs();
    
    /**
     * Sets the "crs" attribute
     */
    void setCrs(java.lang.String crs);
    
    /**
     * Sets (as xml) the "crs" attribute
     */
    void xsetCrs(org.apache.xmlbeans.XmlAnyURI crs);
    
    /**
     * Unsets the "crs" attribute
     */
    void unsetCrs();
    
    /**
     * Gets the "dimensions" attribute
     */
    java.math.BigInteger getDimensions();
    
    /**
     * Gets (as xml) the "dimensions" attribute
     */
    org.apache.xmlbeans.XmlPositiveInteger xgetDimensions();
    
    /**
     * True if has "dimensions" attribute
     */
    boolean isSetDimensions();
    
    /**
     * Sets the "dimensions" attribute
     */
    void setDimensions(java.math.BigInteger dimensions);
    
    /**
     * Sets (as xml) the "dimensions" attribute
     */
    void xsetDimensions(org.apache.xmlbeans.XmlPositiveInteger dimensions);
    
    /**
     * Unsets the "dimensions" attribute
     */
    void unsetDimensions();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.BoundingBoxType newInstance() {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.BoundingBoxType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.BoundingBoxType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.BoundingBoxType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.BoundingBoxType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.BoundingBoxType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.BoundingBoxType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.BoundingBoxType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

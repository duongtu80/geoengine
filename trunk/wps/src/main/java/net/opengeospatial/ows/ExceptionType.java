/*
 * XML Type:  ExceptionType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ExceptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * An XML ExceptionType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public interface ExceptionType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ExceptionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("exceptiontype9351type");
    
    /**
     * Gets array of all "ExceptionText" elements
     */
    java.lang.String[] getExceptionTextArray();
    
    /**
     * Gets ith "ExceptionText" element
     */
    java.lang.String getExceptionTextArray(int i);
    
    /**
     * Gets (as xml) array of all "ExceptionText" elements
     */
    org.apache.xmlbeans.XmlString[] xgetExceptionTextArray();
    
    /**
     * Gets (as xml) ith "ExceptionText" element
     */
    org.apache.xmlbeans.XmlString xgetExceptionTextArray(int i);
    
    /**
     * Returns number of "ExceptionText" element
     */
    int sizeOfExceptionTextArray();
    
    /**
     * Sets array of all "ExceptionText" element
     */
    void setExceptionTextArray(java.lang.String[] exceptionTextArray);
    
    /**
     * Sets ith "ExceptionText" element
     */
    void setExceptionTextArray(int i, java.lang.String exceptionText);
    
    /**
     * Sets (as xml) array of all "ExceptionText" element
     */
    void xsetExceptionTextArray(org.apache.xmlbeans.XmlString[] exceptionTextArray);
    
    /**
     * Sets (as xml) ith "ExceptionText" element
     */
    void xsetExceptionTextArray(int i, org.apache.xmlbeans.XmlString exceptionText);
    
    /**
     * Inserts the value as the ith "ExceptionText" element
     */
    void insertExceptionText(int i, java.lang.String exceptionText);
    
    /**
     * Appends the value as the last "ExceptionText" element
     */
    void addExceptionText(java.lang.String exceptionText);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ExceptionText" element
     */
    org.apache.xmlbeans.XmlString insertNewExceptionText(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ExceptionText" element
     */
    org.apache.xmlbeans.XmlString addNewExceptionText();
    
    /**
     * Removes the ith "ExceptionText" element
     */
    void removeExceptionText(int i);
    
    /**
     * Gets the "exceptionCode" attribute
     */
    java.lang.String getExceptionCode();
    
    /**
     * Gets (as xml) the "exceptionCode" attribute
     */
    org.apache.xmlbeans.XmlString xgetExceptionCode();
    
    /**
     * Sets the "exceptionCode" attribute
     */
    void setExceptionCode(java.lang.String exceptionCode);
    
    /**
     * Sets (as xml) the "exceptionCode" attribute
     */
    void xsetExceptionCode(org.apache.xmlbeans.XmlString exceptionCode);
    
    /**
     * Gets the "locator" attribute
     */
    java.lang.String getLocator();
    
    /**
     * Gets (as xml) the "locator" attribute
     */
    org.apache.xmlbeans.XmlString xgetLocator();
    
    /**
     * True if has "locator" attribute
     */
    boolean isSetLocator();
    
    /**
     * Sets the "locator" attribute
     */
    void setLocator(java.lang.String locator);
    
    /**
     * Sets (as xml) the "locator" attribute
     */
    void xsetLocator(org.apache.xmlbeans.XmlString locator);
    
    /**
     * Unsets the "locator" attribute
     */
    void unsetLocator();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.ExceptionType newInstance() {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.ExceptionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.ExceptionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.ExceptionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.ExceptionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.ExceptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.ExceptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.ExceptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

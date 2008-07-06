/*
 * XML Type:  RequestMethodType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.RequestMethodType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * An XML RequestMethodType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public interface RequestMethodType extends net.opengeospatial.ows.OnlineResourceType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RequestMethodType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("requestmethodtypeff12type");
    
    /**
     * Gets array of all "Constraint" elements
     */
    net.opengeospatial.ows.DomainType[] getConstraintArray();
    
    /**
     * Gets ith "Constraint" element
     */
    net.opengeospatial.ows.DomainType getConstraintArray(int i);
    
    /**
     * Returns number of "Constraint" element
     */
    int sizeOfConstraintArray();
    
    /**
     * Sets array of all "Constraint" element
     */
    void setConstraintArray(net.opengeospatial.ows.DomainType[] constraintArray);
    
    /**
     * Sets ith "Constraint" element
     */
    void setConstraintArray(int i, net.opengeospatial.ows.DomainType constraint);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Constraint" element
     */
    net.opengeospatial.ows.DomainType insertNewConstraint(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Constraint" element
     */
    net.opengeospatial.ows.DomainType addNewConstraint();
    
    /**
     * Removes the ith "Constraint" element
     */
    void removeConstraint(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.RequestMethodType newInstance() {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.RequestMethodType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.RequestMethodType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.RequestMethodType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.RequestMethodType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.RequestMethodType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.RequestMethodType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.RequestMethodType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

/*
 * XML Type:  AcceptVersionsType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AcceptVersionsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML AcceptVersionsType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface AcceptVersionsType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AcceptVersionsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("acceptversionstyped708type");
    
    /**
     * Gets array of all "Version" elements
     */
    java.lang.String[] getVersionArray();
    
    /**
     * Gets ith "Version" element
     */
    java.lang.String getVersionArray(int i);
    
    /**
     * Gets (as xml) array of all "Version" elements
     */
    net.opengis.ows.x11.VersionType[] xgetVersionArray();
    
    /**
     * Gets (as xml) ith "Version" element
     */
    net.opengis.ows.x11.VersionType xgetVersionArray(int i);
    
    /**
     * Returns number of "Version" element
     */
    int sizeOfVersionArray();
    
    /**
     * Sets array of all "Version" element
     */
    void setVersionArray(java.lang.String[] versionArray);
    
    /**
     * Sets ith "Version" element
     */
    void setVersionArray(int i, java.lang.String version);
    
    /**
     * Sets (as xml) array of all "Version" element
     */
    void xsetVersionArray(net.opengis.ows.x11.VersionType[] versionArray);
    
    /**
     * Sets (as xml) ith "Version" element
     */
    void xsetVersionArray(int i, net.opengis.ows.x11.VersionType version);
    
    /**
     * Inserts the value as the ith "Version" element
     */
    void insertVersion(int i, java.lang.String version);
    
    /**
     * Appends the value as the last "Version" element
     */
    void addVersion(java.lang.String version);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Version" element
     */
    net.opengis.ows.x11.VersionType insertNewVersion(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Version" element
     */
    net.opengis.ows.x11.VersionType addNewVersion();
    
    /**
     * Removes the ith "Version" element
     */
    void removeVersion(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.AcceptVersionsType newInstance() {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.AcceptVersionsType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.AcceptVersionsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.AcceptVersionsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.AcceptVersionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

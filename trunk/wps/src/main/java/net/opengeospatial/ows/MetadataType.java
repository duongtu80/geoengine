/*
 * XML Type:  MetadataType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.MetadataType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * An XML MetadataType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public interface MetadataType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MetadataType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("metadatatype4aa3type");
    
    /**
     * Gets the "AbstractMetaData" element
     */
    org.apache.xmlbeans.XmlObject getAbstractMetaData();
    
    /**
     * True if has "AbstractMetaData" element
     */
    boolean isSetAbstractMetaData();
    
    /**
     * Sets the "AbstractMetaData" element
     */
    void setAbstractMetaData(org.apache.xmlbeans.XmlObject abstractMetaData);
    
    /**
     * Appends and returns a new empty "AbstractMetaData" element
     */
    org.apache.xmlbeans.XmlObject addNewAbstractMetaData();
    
    /**
     * Unsets the "AbstractMetaData" element
     */
    void unsetAbstractMetaData();
    
    /**
     * Gets the "type" attribute
     */
    java.lang.String getType();
    
    /**
     * Gets (as xml) the "type" attribute
     */
    org.apache.xmlbeans.XmlString xgetType();
    
    /**
     * True if has "type" attribute
     */
    boolean isSetType();
    
    /**
     * Sets the "type" attribute
     */
    void setType(java.lang.String type);
    
    /**
     * Sets (as xml) the "type" attribute
     */
    void xsetType(org.apache.xmlbeans.XmlString type);
    
    /**
     * Unsets the "type" attribute
     */
    void unsetType();
    
    /**
     * Gets the "href" attribute
     */
    java.lang.String getHref();
    
    /**
     * Gets (as xml) the "href" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetHref();
    
    /**
     * True if has "href" attribute
     */
    boolean isSetHref();
    
    /**
     * Sets the "href" attribute
     */
    void setHref(java.lang.String href);
    
    /**
     * Sets (as xml) the "href" attribute
     */
    void xsetHref(org.apache.xmlbeans.XmlAnyURI href);
    
    /**
     * Unsets the "href" attribute
     */
    void unsetHref();
    
    /**
     * Gets the "role" attribute
     */
    java.lang.String getRole();
    
    /**
     * Gets (as xml) the "role" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetRole();
    
    /**
     * True if has "role" attribute
     */
    boolean isSetRole();
    
    /**
     * Sets the "role" attribute
     */
    void setRole(java.lang.String role);
    
    /**
     * Sets (as xml) the "role" attribute
     */
    void xsetRole(org.apache.xmlbeans.XmlAnyURI role);
    
    /**
     * Unsets the "role" attribute
     */
    void unsetRole();
    
    /**
     * Gets the "arcrole" attribute
     */
    java.lang.String getArcrole();
    
    /**
     * Gets (as xml) the "arcrole" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetArcrole();
    
    /**
     * True if has "arcrole" attribute
     */
    boolean isSetArcrole();
    
    /**
     * Sets the "arcrole" attribute
     */
    void setArcrole(java.lang.String arcrole);
    
    /**
     * Sets (as xml) the "arcrole" attribute
     */
    void xsetArcrole(org.apache.xmlbeans.XmlAnyURI arcrole);
    
    /**
     * Unsets the "arcrole" attribute
     */
    void unsetArcrole();
    
    /**
     * Gets the "title" attribute
     */
    java.lang.String getTitle();
    
    /**
     * Gets (as xml) the "title" attribute
     */
    org.apache.xmlbeans.XmlString xgetTitle();
    
    /**
     * True if has "title" attribute
     */
    boolean isSetTitle();
    
    /**
     * Sets the "title" attribute
     */
    void setTitle(java.lang.String title);
    
    /**
     * Sets (as xml) the "title" attribute
     */
    void xsetTitle(org.apache.xmlbeans.XmlString title);
    
    /**
     * Unsets the "title" attribute
     */
    void unsetTitle();
    
    /**
     * Gets the "show" attribute
     */
    org.w3.x1999.xlink.ShowAttribute.Show.Enum getShow();
    
    /**
     * Gets (as xml) the "show" attribute
     */
    org.w3.x1999.xlink.ShowAttribute.Show xgetShow();
    
    /**
     * True if has "show" attribute
     */
    boolean isSetShow();
    
    /**
     * Sets the "show" attribute
     */
    void setShow(org.w3.x1999.xlink.ShowAttribute.Show.Enum show);
    
    /**
     * Sets (as xml) the "show" attribute
     */
    void xsetShow(org.w3.x1999.xlink.ShowAttribute.Show show);
    
    /**
     * Unsets the "show" attribute
     */
    void unsetShow();
    
    /**
     * Gets the "actuate" attribute
     */
    org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum getActuate();
    
    /**
     * Gets (as xml) the "actuate" attribute
     */
    org.w3.x1999.xlink.ActuateAttribute.Actuate xgetActuate();
    
    /**
     * True if has "actuate" attribute
     */
    boolean isSetActuate();
    
    /**
     * Sets the "actuate" attribute
     */
    void setActuate(org.w3.x1999.xlink.ActuateAttribute.Actuate.Enum actuate);
    
    /**
     * Sets (as xml) the "actuate" attribute
     */
    void xsetActuate(org.w3.x1999.xlink.ActuateAttribute.Actuate actuate);
    
    /**
     * Unsets the "actuate" attribute
     */
    void unsetActuate();
    
    /**
     * Gets the "about" attribute
     */
    java.lang.String getAbout();
    
    /**
     * Gets (as xml) the "about" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetAbout();
    
    /**
     * True if has "about" attribute
     */
    boolean isSetAbout();
    
    /**
     * Sets the "about" attribute
     */
    void setAbout(java.lang.String about);
    
    /**
     * Sets (as xml) the "about" attribute
     */
    void xsetAbout(org.apache.xmlbeans.XmlAnyURI about);
    
    /**
     * Unsets the "about" attribute
     */
    void unsetAbout();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.MetadataType newInstance() {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.MetadataType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.MetadataType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.MetadataType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.MetadataType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.MetadataType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.MetadataType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.MetadataType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.MetadataType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.MetadataType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.MetadataType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.MetadataType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.MetadataType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.MetadataType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.MetadataType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.MetadataType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.MetadataType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.MetadataType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.MetadataType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
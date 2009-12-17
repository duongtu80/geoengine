/*
 * XML Type:  OnlineResourceType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.OnlineResourceType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML OnlineResourceType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface OnlineResourceType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OnlineResourceType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("onlineresourcetype028atype");
    
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
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.OnlineResourceType newInstance() {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.OnlineResourceType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.OnlineResourceType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.OnlineResourceType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.OnlineResourceType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.OnlineResourceType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.OnlineResourceType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.OnlineResourceType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

/*
 * XML Type:  ContactType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ContactType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * An XML ContactType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public interface ContactType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ContactType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("contacttype2c22type");
    
    /**
     * Gets the "Phone" element
     */
    net.opengeospatial.ows.TelephoneType getPhone();
    
    /**
     * True if has "Phone" element
     */
    boolean isSetPhone();
    
    /**
     * Sets the "Phone" element
     */
    void setPhone(net.opengeospatial.ows.TelephoneType phone);
    
    /**
     * Appends and returns a new empty "Phone" element
     */
    net.opengeospatial.ows.TelephoneType addNewPhone();
    
    /**
     * Unsets the "Phone" element
     */
    void unsetPhone();
    
    /**
     * Gets the "Address" element
     */
    net.opengeospatial.ows.AddressType getAddress();
    
    /**
     * True if has "Address" element
     */
    boolean isSetAddress();
    
    /**
     * Sets the "Address" element
     */
    void setAddress(net.opengeospatial.ows.AddressType address);
    
    /**
     * Appends and returns a new empty "Address" element
     */
    net.opengeospatial.ows.AddressType addNewAddress();
    
    /**
     * Unsets the "Address" element
     */
    void unsetAddress();
    
    /**
     * Gets the "OnlineResource" element
     */
    net.opengeospatial.ows.OnlineResourceType getOnlineResource();
    
    /**
     * True if has "OnlineResource" element
     */
    boolean isSetOnlineResource();
    
    /**
     * Sets the "OnlineResource" element
     */
    void setOnlineResource(net.opengeospatial.ows.OnlineResourceType onlineResource);
    
    /**
     * Appends and returns a new empty "OnlineResource" element
     */
    net.opengeospatial.ows.OnlineResourceType addNewOnlineResource();
    
    /**
     * Unsets the "OnlineResource" element
     */
    void unsetOnlineResource();
    
    /**
     * Gets the "HoursOfService" element
     */
    java.lang.String getHoursOfService();
    
    /**
     * Gets (as xml) the "HoursOfService" element
     */
    org.apache.xmlbeans.XmlString xgetHoursOfService();
    
    /**
     * True if has "HoursOfService" element
     */
    boolean isSetHoursOfService();
    
    /**
     * Sets the "HoursOfService" element
     */
    void setHoursOfService(java.lang.String hoursOfService);
    
    /**
     * Sets (as xml) the "HoursOfService" element
     */
    void xsetHoursOfService(org.apache.xmlbeans.XmlString hoursOfService);
    
    /**
     * Unsets the "HoursOfService" element
     */
    void unsetHoursOfService();
    
    /**
     * Gets the "ContactInstructions" element
     */
    java.lang.String getContactInstructions();
    
    /**
     * Gets (as xml) the "ContactInstructions" element
     */
    org.apache.xmlbeans.XmlString xgetContactInstructions();
    
    /**
     * True if has "ContactInstructions" element
     */
    boolean isSetContactInstructions();
    
    /**
     * Sets the "ContactInstructions" element
     */
    void setContactInstructions(java.lang.String contactInstructions);
    
    /**
     * Sets (as xml) the "ContactInstructions" element
     */
    void xsetContactInstructions(org.apache.xmlbeans.XmlString contactInstructions);
    
    /**
     * Unsets the "ContactInstructions" element
     */
    void unsetContactInstructions();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.ContactType newInstance() {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.ContactType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.ContactType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.ContactType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.ContactType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.ContactType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.ContactType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.ContactType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.ContactType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.ContactType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.ContactType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.ContactType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.ContactType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.ContactType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.ContactType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.ContactType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.ContactType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.ContactType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.ContactType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

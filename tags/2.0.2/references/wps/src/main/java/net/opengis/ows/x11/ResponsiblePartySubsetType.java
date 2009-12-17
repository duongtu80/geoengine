/*
 * XML Type:  ResponsiblePartySubsetType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ResponsiblePartySubsetType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML ResponsiblePartySubsetType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface ResponsiblePartySubsetType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ResponsiblePartySubsetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("responsiblepartysubsettype8999type");
    
    /**
     * Gets the "IndividualName" element
     */
    java.lang.String getIndividualName();
    
    /**
     * Gets (as xml) the "IndividualName" element
     */
    org.apache.xmlbeans.XmlString xgetIndividualName();
    
    /**
     * True if has "IndividualName" element
     */
    boolean isSetIndividualName();
    
    /**
     * Sets the "IndividualName" element
     */
    void setIndividualName(java.lang.String individualName);
    
    /**
     * Sets (as xml) the "IndividualName" element
     */
    void xsetIndividualName(org.apache.xmlbeans.XmlString individualName);
    
    /**
     * Unsets the "IndividualName" element
     */
    void unsetIndividualName();
    
    /**
     * Gets the "PositionName" element
     */
    java.lang.String getPositionName();
    
    /**
     * Gets (as xml) the "PositionName" element
     */
    org.apache.xmlbeans.XmlString xgetPositionName();
    
    /**
     * True if has "PositionName" element
     */
    boolean isSetPositionName();
    
    /**
     * Sets the "PositionName" element
     */
    void setPositionName(java.lang.String positionName);
    
    /**
     * Sets (as xml) the "PositionName" element
     */
    void xsetPositionName(org.apache.xmlbeans.XmlString positionName);
    
    /**
     * Unsets the "PositionName" element
     */
    void unsetPositionName();
    
    /**
     * Gets the "ContactInfo" element
     */
    net.opengis.ows.x11.ContactType getContactInfo();
    
    /**
     * True if has "ContactInfo" element
     */
    boolean isSetContactInfo();
    
    /**
     * Sets the "ContactInfo" element
     */
    void setContactInfo(net.opengis.ows.x11.ContactType contactInfo);
    
    /**
     * Appends and returns a new empty "ContactInfo" element
     */
    net.opengis.ows.x11.ContactType addNewContactInfo();
    
    /**
     * Unsets the "ContactInfo" element
     */
    void unsetContactInfo();
    
    /**
     * Gets the "Role" element
     */
    net.opengis.ows.x11.CodeType getRole();
    
    /**
     * True if has "Role" element
     */
    boolean isSetRole();
    
    /**
     * Sets the "Role" element
     */
    void setRole(net.opengis.ows.x11.CodeType role);
    
    /**
     * Appends and returns a new empty "Role" element
     */
    net.opengis.ows.x11.CodeType addNewRole();
    
    /**
     * Unsets the "Role" element
     */
    void unsetRole();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.ResponsiblePartySubsetType newInstance() {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.ResponsiblePartySubsetType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.ResponsiblePartySubsetType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

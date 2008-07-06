/*
 * XML Type:  ResponsiblePartyType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ResponsiblePartyType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * An XML ResponsiblePartyType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public interface ResponsiblePartyType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ResponsiblePartyType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("responsiblepartytypef344type");
    
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
     * Gets the "OrganisationName" element
     */
    java.lang.String getOrganisationName();
    
    /**
     * Gets (as xml) the "OrganisationName" element
     */
    org.apache.xmlbeans.XmlString xgetOrganisationName();
    
    /**
     * True if has "OrganisationName" element
     */
    boolean isSetOrganisationName();
    
    /**
     * Sets the "OrganisationName" element
     */
    void setOrganisationName(java.lang.String organisationName);
    
    /**
     * Sets (as xml) the "OrganisationName" element
     */
    void xsetOrganisationName(org.apache.xmlbeans.XmlString organisationName);
    
    /**
     * Unsets the "OrganisationName" element
     */
    void unsetOrganisationName();
    
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
    net.opengeospatial.ows.ContactType getContactInfo();
    
    /**
     * True if has "ContactInfo" element
     */
    boolean isSetContactInfo();
    
    /**
     * Sets the "ContactInfo" element
     */
    void setContactInfo(net.opengeospatial.ows.ContactType contactInfo);
    
    /**
     * Appends and returns a new empty "ContactInfo" element
     */
    net.opengeospatial.ows.ContactType addNewContactInfo();
    
    /**
     * Unsets the "ContactInfo" element
     */
    void unsetContactInfo();
    
    /**
     * Gets the "Role" element
     */
    net.opengeospatial.ows.CodeType getRole();
    
    /**
     * Sets the "Role" element
     */
    void setRole(net.opengeospatial.ows.CodeType role);
    
    /**
     * Appends and returns a new empty "Role" element
     */
    net.opengeospatial.ows.CodeType addNewRole();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.ResponsiblePartyType newInstance() {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.ResponsiblePartyType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.ResponsiblePartyType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.ResponsiblePartyType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.ResponsiblePartyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

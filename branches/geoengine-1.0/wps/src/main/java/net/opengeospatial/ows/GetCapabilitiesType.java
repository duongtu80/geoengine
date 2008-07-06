/*
 * XML Type:  GetCapabilitiesType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.GetCapabilitiesType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * An XML GetCapabilitiesType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public interface GetCapabilitiesType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetCapabilitiesType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("getcapabilitiestypeba2etype");
    
    /**
     * Gets the "AcceptVersions" element
     */
    net.opengeospatial.ows.AcceptVersionsType getAcceptVersions();
    
    /**
     * True if has "AcceptVersions" element
     */
    boolean isSetAcceptVersions();
    
    /**
     * Sets the "AcceptVersions" element
     */
    void setAcceptVersions(net.opengeospatial.ows.AcceptVersionsType acceptVersions);
    
    /**
     * Appends and returns a new empty "AcceptVersions" element
     */
    net.opengeospatial.ows.AcceptVersionsType addNewAcceptVersions();
    
    /**
     * Unsets the "AcceptVersions" element
     */
    void unsetAcceptVersions();
    
    /**
     * Gets the "Sections" element
     */
    net.opengeospatial.ows.SectionsType getSections();
    
    /**
     * True if has "Sections" element
     */
    boolean isSetSections();
    
    /**
     * Sets the "Sections" element
     */
    void setSections(net.opengeospatial.ows.SectionsType sections);
    
    /**
     * Appends and returns a new empty "Sections" element
     */
    net.opengeospatial.ows.SectionsType addNewSections();
    
    /**
     * Unsets the "Sections" element
     */
    void unsetSections();
    
    /**
     * Gets the "AcceptFormats" element
     */
    net.opengeospatial.ows.AcceptFormatsType getAcceptFormats();
    
    /**
     * True if has "AcceptFormats" element
     */
    boolean isSetAcceptFormats();
    
    /**
     * Sets the "AcceptFormats" element
     */
    void setAcceptFormats(net.opengeospatial.ows.AcceptFormatsType acceptFormats);
    
    /**
     * Appends and returns a new empty "AcceptFormats" element
     */
    net.opengeospatial.ows.AcceptFormatsType addNewAcceptFormats();
    
    /**
     * Unsets the "AcceptFormats" element
     */
    void unsetAcceptFormats();
    
    /**
     * Gets the "updateSequence" attribute
     */
    java.lang.String getUpdateSequence();
    
    /**
     * Gets (as xml) the "updateSequence" attribute
     */
    net.opengeospatial.ows.UpdateSequenceType xgetUpdateSequence();
    
    /**
     * True if has "updateSequence" attribute
     */
    boolean isSetUpdateSequence();
    
    /**
     * Sets the "updateSequence" attribute
     */
    void setUpdateSequence(java.lang.String updateSequence);
    
    /**
     * Sets (as xml) the "updateSequence" attribute
     */
    void xsetUpdateSequence(net.opengeospatial.ows.UpdateSequenceType updateSequence);
    
    /**
     * Unsets the "updateSequence" attribute
     */
    void unsetUpdateSequence();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.GetCapabilitiesType newInstance() {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.GetCapabilitiesType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.GetCapabilitiesType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.GetCapabilitiesType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.GetCapabilitiesType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

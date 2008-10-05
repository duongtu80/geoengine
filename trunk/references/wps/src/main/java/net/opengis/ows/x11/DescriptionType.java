/*
 * XML Type:  DescriptionType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.DescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML DescriptionType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface DescriptionType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DescriptionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("descriptiontypede61type");
    
    /**
     * Gets array of all "Title" elements
     */
    net.opengis.ows.x11.LanguageStringType[] getTitleArray();
    
    /**
     * Gets ith "Title" element
     */
    net.opengis.ows.x11.LanguageStringType getTitleArray(int i);
    
    /**
     * Returns number of "Title" element
     */
    int sizeOfTitleArray();
    
    /**
     * Sets array of all "Title" element
     */
    void setTitleArray(net.opengis.ows.x11.LanguageStringType[] titleArray);
    
    /**
     * Sets ith "Title" element
     */
    void setTitleArray(int i, net.opengis.ows.x11.LanguageStringType title);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Title" element
     */
    net.opengis.ows.x11.LanguageStringType insertNewTitle(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Title" element
     */
    net.opengis.ows.x11.LanguageStringType addNewTitle();
    
    /**
     * Removes the ith "Title" element
     */
    void removeTitle(int i);
    
    /**
     * Gets array of all "Abstract" elements
     */
    net.opengis.ows.x11.LanguageStringType[] getAbstractArray();
    
    /**
     * Gets ith "Abstract" element
     */
    net.opengis.ows.x11.LanguageStringType getAbstractArray(int i);
    
    /**
     * Returns number of "Abstract" element
     */
    int sizeOfAbstractArray();
    
    /**
     * Sets array of all "Abstract" element
     */
    void setAbstractArray(net.opengis.ows.x11.LanguageStringType[] xabstractArray);
    
    /**
     * Sets ith "Abstract" element
     */
    void setAbstractArray(int i, net.opengis.ows.x11.LanguageStringType xabstract);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Abstract" element
     */
    net.opengis.ows.x11.LanguageStringType insertNewAbstract(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Abstract" element
     */
    net.opengis.ows.x11.LanguageStringType addNewAbstract();
    
    /**
     * Removes the ith "Abstract" element
     */
    void removeAbstract(int i);
    
    /**
     * Gets array of all "Keywords" elements
     */
    net.opengis.ows.x11.KeywordsType[] getKeywordsArray();
    
    /**
     * Gets ith "Keywords" element
     */
    net.opengis.ows.x11.KeywordsType getKeywordsArray(int i);
    
    /**
     * Returns number of "Keywords" element
     */
    int sizeOfKeywordsArray();
    
    /**
     * Sets array of all "Keywords" element
     */
    void setKeywordsArray(net.opengis.ows.x11.KeywordsType[] keywordsArray);
    
    /**
     * Sets ith "Keywords" element
     */
    void setKeywordsArray(int i, net.opengis.ows.x11.KeywordsType keywords);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Keywords" element
     */
    net.opengis.ows.x11.KeywordsType insertNewKeywords(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Keywords" element
     */
    net.opengis.ows.x11.KeywordsType addNewKeywords();
    
    /**
     * Removes the ith "Keywords" element
     */
    void removeKeywords(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.DescriptionType newInstance() {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.DescriptionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.DescriptionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.DescriptionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.DescriptionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.DescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.DescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.DescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

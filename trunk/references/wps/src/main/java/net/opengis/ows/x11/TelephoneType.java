/*
 * XML Type:  TelephoneType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.TelephoneType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML TelephoneType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface TelephoneType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TelephoneType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("telephonetype8f99type");
    
    /**
     * Gets array of all "Voice" elements
     */
    java.lang.String[] getVoiceArray();
    
    /**
     * Gets ith "Voice" element
     */
    java.lang.String getVoiceArray(int i);
    
    /**
     * Gets (as xml) array of all "Voice" elements
     */
    org.apache.xmlbeans.XmlString[] xgetVoiceArray();
    
    /**
     * Gets (as xml) ith "Voice" element
     */
    org.apache.xmlbeans.XmlString xgetVoiceArray(int i);
    
    /**
     * Returns number of "Voice" element
     */
    int sizeOfVoiceArray();
    
    /**
     * Sets array of all "Voice" element
     */
    void setVoiceArray(java.lang.String[] voiceArray);
    
    /**
     * Sets ith "Voice" element
     */
    void setVoiceArray(int i, java.lang.String voice);
    
    /**
     * Sets (as xml) array of all "Voice" element
     */
    void xsetVoiceArray(org.apache.xmlbeans.XmlString[] voiceArray);
    
    /**
     * Sets (as xml) ith "Voice" element
     */
    void xsetVoiceArray(int i, org.apache.xmlbeans.XmlString voice);
    
    /**
     * Inserts the value as the ith "Voice" element
     */
    void insertVoice(int i, java.lang.String voice);
    
    /**
     * Appends the value as the last "Voice" element
     */
    void addVoice(java.lang.String voice);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Voice" element
     */
    org.apache.xmlbeans.XmlString insertNewVoice(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Voice" element
     */
    org.apache.xmlbeans.XmlString addNewVoice();
    
    /**
     * Removes the ith "Voice" element
     */
    void removeVoice(int i);
    
    /**
     * Gets array of all "Facsimile" elements
     */
    java.lang.String[] getFacsimileArray();
    
    /**
     * Gets ith "Facsimile" element
     */
    java.lang.String getFacsimileArray(int i);
    
    /**
     * Gets (as xml) array of all "Facsimile" elements
     */
    org.apache.xmlbeans.XmlString[] xgetFacsimileArray();
    
    /**
     * Gets (as xml) ith "Facsimile" element
     */
    org.apache.xmlbeans.XmlString xgetFacsimileArray(int i);
    
    /**
     * Returns number of "Facsimile" element
     */
    int sizeOfFacsimileArray();
    
    /**
     * Sets array of all "Facsimile" element
     */
    void setFacsimileArray(java.lang.String[] facsimileArray);
    
    /**
     * Sets ith "Facsimile" element
     */
    void setFacsimileArray(int i, java.lang.String facsimile);
    
    /**
     * Sets (as xml) array of all "Facsimile" element
     */
    void xsetFacsimileArray(org.apache.xmlbeans.XmlString[] facsimileArray);
    
    /**
     * Sets (as xml) ith "Facsimile" element
     */
    void xsetFacsimileArray(int i, org.apache.xmlbeans.XmlString facsimile);
    
    /**
     * Inserts the value as the ith "Facsimile" element
     */
    void insertFacsimile(int i, java.lang.String facsimile);
    
    /**
     * Appends the value as the last "Facsimile" element
     */
    void addFacsimile(java.lang.String facsimile);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Facsimile" element
     */
    org.apache.xmlbeans.XmlString insertNewFacsimile(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Facsimile" element
     */
    org.apache.xmlbeans.XmlString addNewFacsimile();
    
    /**
     * Removes the ith "Facsimile" element
     */
    void removeFacsimile(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.TelephoneType newInstance() {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.TelephoneType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.TelephoneType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.TelephoneType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.TelephoneType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.TelephoneType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.TelephoneType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.TelephoneType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

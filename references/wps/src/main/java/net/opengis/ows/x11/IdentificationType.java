/*
 * XML Type:  IdentificationType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.IdentificationType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML IdentificationType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface IdentificationType extends net.opengis.ows.x11.BasicIdentificationType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(IdentificationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("identificationtype0c7dtype");
    
    /**
     * Gets array of all "BoundingBox" elements
     */
    net.opengis.ows.x11.BoundingBoxType[] getBoundingBoxArray();
    
    /**
     * Gets ith "BoundingBox" element
     */
    net.opengis.ows.x11.BoundingBoxType getBoundingBoxArray(int i);
    
    /**
     * Returns number of "BoundingBox" element
     */
    int sizeOfBoundingBoxArray();
    
    /**
     * Sets array of all "BoundingBox" element
     */
    void setBoundingBoxArray(net.opengis.ows.x11.BoundingBoxType[] boundingBoxArray);
    
    /**
     * Sets ith "BoundingBox" element
     */
    void setBoundingBoxArray(int i, net.opengis.ows.x11.BoundingBoxType boundingBox);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "BoundingBox" element
     */
    net.opengis.ows.x11.BoundingBoxType insertNewBoundingBox(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "BoundingBox" element
     */
    net.opengis.ows.x11.BoundingBoxType addNewBoundingBox();
    
    /**
     * Removes the ith "BoundingBox" element
     */
    void removeBoundingBox(int i);
    
    /**
     * Gets array of all "OutputFormat" elements
     */
    java.lang.String[] getOutputFormatArray();
    
    /**
     * Gets ith "OutputFormat" element
     */
    java.lang.String getOutputFormatArray(int i);
    
    /**
     * Gets (as xml) array of all "OutputFormat" elements
     */
    net.opengis.ows.x11.MimeType[] xgetOutputFormatArray();
    
    /**
     * Gets (as xml) ith "OutputFormat" element
     */
    net.opengis.ows.x11.MimeType xgetOutputFormatArray(int i);
    
    /**
     * Returns number of "OutputFormat" element
     */
    int sizeOfOutputFormatArray();
    
    /**
     * Sets array of all "OutputFormat" element
     */
    void setOutputFormatArray(java.lang.String[] outputFormatArray);
    
    /**
     * Sets ith "OutputFormat" element
     */
    void setOutputFormatArray(int i, java.lang.String outputFormat);
    
    /**
     * Sets (as xml) array of all "OutputFormat" element
     */
    void xsetOutputFormatArray(net.opengis.ows.x11.MimeType[] outputFormatArray);
    
    /**
     * Sets (as xml) ith "OutputFormat" element
     */
    void xsetOutputFormatArray(int i, net.opengis.ows.x11.MimeType outputFormat);
    
    /**
     * Inserts the value as the ith "OutputFormat" element
     */
    void insertOutputFormat(int i, java.lang.String outputFormat);
    
    /**
     * Appends the value as the last "OutputFormat" element
     */
    void addOutputFormat(java.lang.String outputFormat);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "OutputFormat" element
     */
    net.opengis.ows.x11.MimeType insertNewOutputFormat(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OutputFormat" element
     */
    net.opengis.ows.x11.MimeType addNewOutputFormat();
    
    /**
     * Removes the ith "OutputFormat" element
     */
    void removeOutputFormat(int i);
    
    /**
     * Gets array of all "AvailableCRS" elements
     */
    java.lang.String[] getAvailableCRSArray();
    
    /**
     * Gets ith "AvailableCRS" element
     */
    java.lang.String getAvailableCRSArray(int i);
    
    /**
     * Gets (as xml) array of all "AvailableCRS" elements
     */
    org.apache.xmlbeans.XmlAnyURI[] xgetAvailableCRSArray();
    
    /**
     * Gets (as xml) ith "AvailableCRS" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetAvailableCRSArray(int i);
    
    /**
     * Returns number of "AvailableCRS" element
     */
    int sizeOfAvailableCRSArray();
    
    /**
     * Sets array of all "AvailableCRS" element
     */
    void setAvailableCRSArray(java.lang.String[] availableCRSArray);
    
    /**
     * Sets ith "AvailableCRS" element
     */
    void setAvailableCRSArray(int i, java.lang.String availableCRS);
    
    /**
     * Sets (as xml) array of all "AvailableCRS" element
     */
    void xsetAvailableCRSArray(org.apache.xmlbeans.XmlAnyURI[] availableCRSArray);
    
    /**
     * Sets (as xml) ith "AvailableCRS" element
     */
    void xsetAvailableCRSArray(int i, org.apache.xmlbeans.XmlAnyURI availableCRS);
    
    /**
     * Inserts the value as the ith "AvailableCRS" element
     */
    void insertAvailableCRS(int i, java.lang.String availableCRS);
    
    /**
     * Appends the value as the last "AvailableCRS" element
     */
    void addAvailableCRS(java.lang.String availableCRS);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "AvailableCRS" element
     */
    org.apache.xmlbeans.XmlAnyURI insertNewAvailableCRS(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "AvailableCRS" element
     */
    org.apache.xmlbeans.XmlAnyURI addNewAvailableCRS();
    
    /**
     * Removes the ith "AvailableCRS" element
     */
    void removeAvailableCRS(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.IdentificationType newInstance() {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.IdentificationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.IdentificationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.IdentificationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.IdentificationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.IdentificationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.IdentificationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

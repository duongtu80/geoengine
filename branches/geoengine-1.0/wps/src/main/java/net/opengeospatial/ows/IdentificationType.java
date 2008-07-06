/*
 * XML Type:  IdentificationType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.IdentificationType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * An XML IdentificationType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public interface IdentificationType extends net.opengeospatial.ows.DescriptionType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(IdentificationType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("identificationtypeafe2type");
    
    /**
     * Gets the "Identifier" element
     */
    net.opengeospatial.ows.CodeType getIdentifier();
    
    /**
     * True if has "Identifier" element
     */
    boolean isSetIdentifier();
    
    /**
     * Sets the "Identifier" element
     */
    void setIdentifier(net.opengeospatial.ows.CodeType identifier);
    
    /**
     * Appends and returns a new empty "Identifier" element
     */
    net.opengeospatial.ows.CodeType addNewIdentifier();
    
    /**
     * Unsets the "Identifier" element
     */
    void unsetIdentifier();
    
    /**
     * Gets array of all "BoundingBox" elements
     */
    net.opengeospatial.ows.BoundingBoxType[] getBoundingBoxArray();
    
    /**
     * Gets ith "BoundingBox" element
     */
    net.opengeospatial.ows.BoundingBoxType getBoundingBoxArray(int i);
    
    /**
     * Returns number of "BoundingBox" element
     */
    int sizeOfBoundingBoxArray();
    
    /**
     * Sets array of all "BoundingBox" element
     */
    void setBoundingBoxArray(net.opengeospatial.ows.BoundingBoxType[] boundingBoxArray);
    
    /**
     * Sets ith "BoundingBox" element
     */
    void setBoundingBoxArray(int i, net.opengeospatial.ows.BoundingBoxType boundingBox);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "BoundingBox" element
     */
    net.opengeospatial.ows.BoundingBoxType insertNewBoundingBox(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "BoundingBox" element
     */
    net.opengeospatial.ows.BoundingBoxType addNewBoundingBox();
    
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
    net.opengeospatial.ows.MimeType[] xgetOutputFormatArray();
    
    /**
     * Gets (as xml) ith "OutputFormat" element
     */
    net.opengeospatial.ows.MimeType xgetOutputFormatArray(int i);
    
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
    void xsetOutputFormatArray(net.opengeospatial.ows.MimeType[] outputFormatArray);
    
    /**
     * Sets (as xml) ith "OutputFormat" element
     */
    void xsetOutputFormatArray(int i, net.opengeospatial.ows.MimeType outputFormat);
    
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
    net.opengeospatial.ows.MimeType insertNewOutputFormat(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OutputFormat" element
     */
    net.opengeospatial.ows.MimeType addNewOutputFormat();
    
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
     * Gets array of all "Metadata" elements
     */
    net.opengeospatial.ows.MetadataType[] getMetadataArray();
    
    /**
     * Gets ith "Metadata" element
     */
    net.opengeospatial.ows.MetadataType getMetadataArray(int i);
    
    /**
     * Returns number of "Metadata" element
     */
    int sizeOfMetadataArray();
    
    /**
     * Sets array of all "Metadata" element
     */
    void setMetadataArray(net.opengeospatial.ows.MetadataType[] metadataArray);
    
    /**
     * Sets ith "Metadata" element
     */
    void setMetadataArray(int i, net.opengeospatial.ows.MetadataType metadata);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Metadata" element
     */
    net.opengeospatial.ows.MetadataType insertNewMetadata(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metadata" element
     */
    net.opengeospatial.ows.MetadataType addNewMetadata();
    
    /**
     * Removes the ith "Metadata" element
     */
    void removeMetadata(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.IdentificationType newInstance() {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.IdentificationType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.IdentificationType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.IdentificationType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.IdentificationType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.IdentificationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.IdentificationType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.IdentificationType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

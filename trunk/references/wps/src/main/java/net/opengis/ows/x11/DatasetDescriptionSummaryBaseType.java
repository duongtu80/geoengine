/*
 * XML Type:  DatasetDescriptionSummaryBaseType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.DatasetDescriptionSummaryBaseType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML DatasetDescriptionSummaryBaseType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface DatasetDescriptionSummaryBaseType extends net.opengis.ows.x11.DescriptionType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DatasetDescriptionSummaryBaseType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("datasetdescriptionsummarybasetypebe2atype");
    
    /**
     * Gets array of all "WGS84BoundingBox" elements
     */
    net.opengis.ows.x11.WGS84BoundingBoxType[] getWGS84BoundingBoxArray();
    
    /**
     * Gets ith "WGS84BoundingBox" element
     */
    net.opengis.ows.x11.WGS84BoundingBoxType getWGS84BoundingBoxArray(int i);
    
    /**
     * Returns number of "WGS84BoundingBox" element
     */
    int sizeOfWGS84BoundingBoxArray();
    
    /**
     * Sets array of all "WGS84BoundingBox" element
     */
    void setWGS84BoundingBoxArray(net.opengis.ows.x11.WGS84BoundingBoxType[] wgs84BoundingBoxArray);
    
    /**
     * Sets ith "WGS84BoundingBox" element
     */
    void setWGS84BoundingBoxArray(int i, net.opengis.ows.x11.WGS84BoundingBoxType wgs84BoundingBox);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "WGS84BoundingBox" element
     */
    net.opengis.ows.x11.WGS84BoundingBoxType insertNewWGS84BoundingBox(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "WGS84BoundingBox" element
     */
    net.opengis.ows.x11.WGS84BoundingBoxType addNewWGS84BoundingBox();
    
    /**
     * Removes the ith "WGS84BoundingBox" element
     */
    void removeWGS84BoundingBox(int i);
    
    /**
     * Gets the "Identifier" element
     */
    net.opengis.ows.x11.CodeType getIdentifier();
    
    /**
     * Sets the "Identifier" element
     */
    void setIdentifier(net.opengis.ows.x11.CodeType identifier);
    
    /**
     * Appends and returns a new empty "Identifier" element
     */
    net.opengis.ows.x11.CodeType addNewIdentifier();
    
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
     * Gets array of all "Metadata" elements
     */
    net.opengis.ows.x11.MetadataType[] getMetadataArray();
    
    /**
     * Gets ith "Metadata" element
     */
    net.opengis.ows.x11.MetadataType getMetadataArray(int i);
    
    /**
     * Returns number of "Metadata" element
     */
    int sizeOfMetadataArray();
    
    /**
     * Sets array of all "Metadata" element
     */
    void setMetadataArray(net.opengis.ows.x11.MetadataType[] metadataArray);
    
    /**
     * Sets ith "Metadata" element
     */
    void setMetadataArray(int i, net.opengis.ows.x11.MetadataType metadata);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Metadata" element
     */
    net.opengis.ows.x11.MetadataType insertNewMetadata(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metadata" element
     */
    net.opengis.ows.x11.MetadataType addNewMetadata();
    
    /**
     * Removes the ith "Metadata" element
     */
    void removeMetadata(int i);
    
    /**
     * Gets array of all "DatasetDescriptionSummary" elements
     */
    net.opengis.ows.x11.DatasetDescriptionSummaryBaseType[] getDatasetDescriptionSummaryArray();
    
    /**
     * Gets ith "DatasetDescriptionSummary" element
     */
    net.opengis.ows.x11.DatasetDescriptionSummaryBaseType getDatasetDescriptionSummaryArray(int i);
    
    /**
     * Returns number of "DatasetDescriptionSummary" element
     */
    int sizeOfDatasetDescriptionSummaryArray();
    
    /**
     * Sets array of all "DatasetDescriptionSummary" element
     */
    void setDatasetDescriptionSummaryArray(net.opengis.ows.x11.DatasetDescriptionSummaryBaseType[] datasetDescriptionSummaryArray);
    
    /**
     * Sets ith "DatasetDescriptionSummary" element
     */
    void setDatasetDescriptionSummaryArray(int i, net.opengis.ows.x11.DatasetDescriptionSummaryBaseType datasetDescriptionSummary);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "DatasetDescriptionSummary" element
     */
    net.opengis.ows.x11.DatasetDescriptionSummaryBaseType insertNewDatasetDescriptionSummary(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "DatasetDescriptionSummary" element
     */
    net.opengis.ows.x11.DatasetDescriptionSummaryBaseType addNewDatasetDescriptionSummary();
    
    /**
     * Removes the ith "DatasetDescriptionSummary" element
     */
    void removeDatasetDescriptionSummary(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType newInstance() {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.DatasetDescriptionSummaryBaseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

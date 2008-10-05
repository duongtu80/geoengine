/*
 * XML Type:  ContentsBaseType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ContentsBaseType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML ContentsBaseType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface ContentsBaseType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ContentsBaseType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("contentsbasetypea280type");
    
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
     * Gets array of all "OtherSource" elements
     */
    net.opengis.ows.x11.MetadataType[] getOtherSourceArray();
    
    /**
     * Gets ith "OtherSource" element
     */
    net.opengis.ows.x11.MetadataType getOtherSourceArray(int i);
    
    /**
     * Returns number of "OtherSource" element
     */
    int sizeOfOtherSourceArray();
    
    /**
     * Sets array of all "OtherSource" element
     */
    void setOtherSourceArray(net.opengis.ows.x11.MetadataType[] otherSourceArray);
    
    /**
     * Sets ith "OtherSource" element
     */
    void setOtherSourceArray(int i, net.opengis.ows.x11.MetadataType otherSource);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "OtherSource" element
     */
    net.opengis.ows.x11.MetadataType insertNewOtherSource(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OtherSource" element
     */
    net.opengis.ows.x11.MetadataType addNewOtherSource();
    
    /**
     * Removes the ith "OtherSource" element
     */
    void removeOtherSource(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.ContentsBaseType newInstance() {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.ContentsBaseType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.ContentsBaseType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.ContentsBaseType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.ContentsBaseType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.ContentsBaseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.ContentsBaseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.ContentsBaseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

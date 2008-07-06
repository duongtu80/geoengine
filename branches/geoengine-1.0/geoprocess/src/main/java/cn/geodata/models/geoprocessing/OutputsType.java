/*
 * XML Type:  outputsType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.OutputsType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing;


/**
 * An XML outputsType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public interface OutputsType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OutputsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s18035915BE4B4DC262DF2F41C2FD4884").resolveHandle("outputstype17c4type");
    
    /**
     * Gets array of all "output" elements
     */
    cn.geodata.models.geoprocessing.ValueType[] getOutputArray();
    
    /**
     * Gets ith "output" element
     */
    cn.geodata.models.geoprocessing.ValueType getOutputArray(int i);
    
    /**
     * Returns number of "output" element
     */
    int sizeOfOutputArray();
    
    /**
     * Sets array of all "output" element
     */
    void setOutputArray(cn.geodata.models.geoprocessing.ValueType[] outputArray);
    
    /**
     * Sets ith "output" element
     */
    void setOutputArray(int i, cn.geodata.models.geoprocessing.ValueType output);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "output" element
     */
    cn.geodata.models.geoprocessing.ValueType insertNewOutput(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "output" element
     */
    cn.geodata.models.geoprocessing.ValueType addNewOutput();
    
    /**
     * Removes the ith "output" element
     */
    void removeOutput(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cn.geodata.models.geoprocessing.OutputsType newInstance() {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cn.geodata.models.geoprocessing.OutputsType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.OutputsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.OutputsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.OutputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

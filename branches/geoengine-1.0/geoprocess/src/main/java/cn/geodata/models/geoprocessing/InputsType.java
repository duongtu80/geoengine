/*
 * XML Type:  inputsType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.InputsType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing;


/**
 * An XML inputsType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public interface InputsType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(InputsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s18035915BE4B4DC262DF2F41C2FD4884").resolveHandle("inputstypee41btype");
    
    /**
     * Gets array of all "input" elements
     */
    cn.geodata.models.geoprocessing.ValueType[] getInputArray();
    
    /**
     * Gets ith "input" element
     */
    cn.geodata.models.geoprocessing.ValueType getInputArray(int i);
    
    /**
     * Returns number of "input" element
     */
    int sizeOfInputArray();
    
    /**
     * Sets array of all "input" element
     */
    void setInputArray(cn.geodata.models.geoprocessing.ValueType[] inputArray);
    
    /**
     * Sets ith "input" element
     */
    void setInputArray(int i, cn.geodata.models.geoprocessing.ValueType input);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "input" element
     */
    cn.geodata.models.geoprocessing.ValueType insertNewInput(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "input" element
     */
    cn.geodata.models.geoprocessing.ValueType addNewInput();
    
    /**
     * Removes the ith "input" element
     */
    void removeInput(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cn.geodata.models.geoprocessing.InputsType newInstance() {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cn.geodata.models.geoprocessing.InputsType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cn.geodata.models.geoprocessing.InputsType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cn.geodata.models.geoprocessing.InputsType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cn.geodata.models.geoprocessing.InputsType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.InputsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.InputsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.InputsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

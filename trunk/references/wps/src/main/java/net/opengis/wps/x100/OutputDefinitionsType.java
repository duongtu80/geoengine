/*
 * XML Type:  OutputDefinitionsType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.OutputDefinitionsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * An XML OutputDefinitionsType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public interface OutputDefinitionsType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OutputDefinitionsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("outputdefinitionstypea76etype");
    
    /**
     * Gets array of all "Output" elements
     */
    net.opengis.wps.x100.DocumentOutputDefinitionType[] getOutputArray();
    
    /**
     * Gets ith "Output" element
     */
    net.opengis.wps.x100.DocumentOutputDefinitionType getOutputArray(int i);
    
    /**
     * Returns number of "Output" element
     */
    int sizeOfOutputArray();
    
    /**
     * Sets array of all "Output" element
     */
    void setOutputArray(net.opengis.wps.x100.DocumentOutputDefinitionType[] outputArray);
    
    /**
     * Sets ith "Output" element
     */
    void setOutputArray(int i, net.opengis.wps.x100.DocumentOutputDefinitionType output);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Output" element
     */
    net.opengis.wps.x100.DocumentOutputDefinitionType insertNewOutput(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Output" element
     */
    net.opengis.wps.x100.DocumentOutputDefinitionType addNewOutput();
    
    /**
     * Removes the ith "Output" element
     */
    void removeOutput(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.OutputDefinitionsType newInstance() {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.OutputDefinitionsType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.OutputDefinitionsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.OutputDefinitionsType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.OutputDefinitionsType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

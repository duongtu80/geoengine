/*
 * An XML document type.
 * Localname: processes
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ProcessesDocument
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing;


/**
 * A document containing one processes(@http://www.geodata.cn/models/geoprocessing) element.
 *
 * This is a complex type.
 */
public interface ProcessesDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s60DBFAE60CD8585308AA97515DDF1108").resolveHandle("processes0e03doctype");
    
    /**
     * Gets the "processes" element
     */
    cn.geodata.models.geoprocessing.ProcessesType getProcesses();
    
    /**
     * Sets the "processes" element
     */
    void setProcesses(cn.geodata.models.geoprocessing.ProcessesType processes);
    
    /**
     * Appends and returns a new empty "processes" element
     */
    cn.geodata.models.geoprocessing.ProcessesType addNewProcesses();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cn.geodata.models.geoprocessing.ProcessesDocument newInstance() {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.ProcessesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.ProcessesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

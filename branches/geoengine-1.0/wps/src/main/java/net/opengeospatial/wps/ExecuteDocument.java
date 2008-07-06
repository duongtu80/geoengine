/*
 * An XML document type.
 * Localname: Execute
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ExecuteDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps;


/**
 * A document containing one Execute(@http://www.opengeospatial.net/wps) element.
 *
 * This is a complex type.
 */
public interface ExecuteDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ExecuteDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("execute21fcdoctype");
    
    /**
     * Gets the "Execute" element
     */
    net.opengeospatial.wps.ExecuteDocument.Execute getExecute();
    
    /**
     * Sets the "Execute" element
     */
    void setExecute(net.opengeospatial.wps.ExecuteDocument.Execute execute);
    
    /**
     * Appends and returns a new empty "Execute" element
     */
    net.opengeospatial.wps.ExecuteDocument.Execute addNewExecute();
    
    /**
     * An XML Execute(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public interface Execute extends net.opengeospatial.wps.RequestBaseType
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Execute.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("execute703delemtype");
        
        /**
         * Gets the "Identifier" element
         */
        net.opengeospatial.ows.CodeType getIdentifier();
        
        /**
         * Sets the "Identifier" element
         */
        void setIdentifier(net.opengeospatial.ows.CodeType identifier);
        
        /**
         * Appends and returns a new empty "Identifier" element
         */
        net.opengeospatial.ows.CodeType addNewIdentifier();
        
        /**
         * Gets the "DataInputs" element
         */
        net.opengeospatial.wps.DataInputsType getDataInputs();
        
        /**
         * True if has "DataInputs" element
         */
        boolean isSetDataInputs();
        
        /**
         * Sets the "DataInputs" element
         */
        void setDataInputs(net.opengeospatial.wps.DataInputsType dataInputs);
        
        /**
         * Appends and returns a new empty "DataInputs" element
         */
        net.opengeospatial.wps.DataInputsType addNewDataInputs();
        
        /**
         * Unsets the "DataInputs" element
         */
        void unsetDataInputs();
        
        /**
         * Gets the "OutputDefinitions" element
         */
        net.opengeospatial.wps.OutputDefinitionsType getOutputDefinitions();
        
        /**
         * True if has "OutputDefinitions" element
         */
        boolean isSetOutputDefinitions();
        
        /**
         * Sets the "OutputDefinitions" element
         */
        void setOutputDefinitions(net.opengeospatial.wps.OutputDefinitionsType outputDefinitions);
        
        /**
         * Appends and returns a new empty "OutputDefinitions" element
         */
        net.opengeospatial.wps.OutputDefinitionsType addNewOutputDefinitions();
        
        /**
         * Unsets the "OutputDefinitions" element
         */
        void unsetOutputDefinitions();
        
        /**
         * Gets the "store" attribute
         */
        boolean getStore();
        
        /**
         * Gets (as xml) the "store" attribute
         */
        org.apache.xmlbeans.XmlBoolean xgetStore();
        
        /**
         * True if has "store" attribute
         */
        boolean isSetStore();
        
        /**
         * Sets the "store" attribute
         */
        void setStore(boolean store);
        
        /**
         * Sets (as xml) the "store" attribute
         */
        void xsetStore(org.apache.xmlbeans.XmlBoolean store);
        
        /**
         * Unsets the "store" attribute
         */
        void unsetStore();
        
        /**
         * Gets the "status" attribute
         */
        boolean getStatus();
        
        /**
         * Gets (as xml) the "status" attribute
         */
        org.apache.xmlbeans.XmlBoolean xgetStatus();
        
        /**
         * True if has "status" attribute
         */
        boolean isSetStatus();
        
        /**
         * Sets the "status" attribute
         */
        void setStatus(boolean status);
        
        /**
         * Sets (as xml) the "status" attribute
         */
        void xsetStatus(org.apache.xmlbeans.XmlBoolean status);
        
        /**
         * Unsets the "status" attribute
         */
        void unsetStatus();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengeospatial.wps.ExecuteDocument.Execute newInstance() {
              return (net.opengeospatial.wps.ExecuteDocument.Execute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.wps.ExecuteDocument.Execute newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.wps.ExecuteDocument.Execute) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.wps.ExecuteDocument newInstance() {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.wps.ExecuteDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.wps.ExecuteDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.wps.ExecuteDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.ExecuteDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.ExecuteDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.ExecuteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

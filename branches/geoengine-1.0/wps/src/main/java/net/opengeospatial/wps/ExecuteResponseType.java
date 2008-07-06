/*
 * XML Type:  ExecuteResponseType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ExecuteResponseType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps;


/**
 * An XML ExecuteResponseType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public interface ExecuteResponseType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ExecuteResponseType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("executeresponsetype9087type");
    
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
     * Gets the "Status" element
     */
    net.opengeospatial.wps.StatusType getStatus();
    
    /**
     * Sets the "Status" element
     */
    void setStatus(net.opengeospatial.wps.StatusType status);
    
    /**
     * Appends and returns a new empty "Status" element
     */
    net.opengeospatial.wps.StatusType addNewStatus();
    
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
     * Gets the "ProcessOutputs" element
     */
    net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs getProcessOutputs();
    
    /**
     * True if has "ProcessOutputs" element
     */
    boolean isSetProcessOutputs();
    
    /**
     * Sets the "ProcessOutputs" element
     */
    void setProcessOutputs(net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs processOutputs);
    
    /**
     * Appends and returns a new empty "ProcessOutputs" element
     */
    net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs addNewProcessOutputs();
    
    /**
     * Unsets the "ProcessOutputs" element
     */
    void unsetProcessOutputs();
    
    /**
     * Gets the "statusLocation" attribute
     */
    java.lang.String getStatusLocation();
    
    /**
     * Gets (as xml) the "statusLocation" attribute
     */
    org.apache.xmlbeans.XmlAnyURI xgetStatusLocation();
    
    /**
     * True if has "statusLocation" attribute
     */
    boolean isSetStatusLocation();
    
    /**
     * Sets the "statusLocation" attribute
     */
    void setStatusLocation(java.lang.String statusLocation);
    
    /**
     * Sets (as xml) the "statusLocation" attribute
     */
    void xsetStatusLocation(org.apache.xmlbeans.XmlAnyURI statusLocation);
    
    /**
     * Unsets the "statusLocation" attribute
     */
    void unsetStatusLocation();
    
    /**
     * Gets the "version" attribute
     */
    java.lang.String getVersion();
    
    /**
     * Gets (as xml) the "version" attribute
     */
    net.opengeospatial.ows.VersionType xgetVersion();
    
    /**
     * Sets the "version" attribute
     */
    void setVersion(java.lang.String version);
    
    /**
     * Sets (as xml) the "version" attribute
     */
    void xsetVersion(net.opengeospatial.ows.VersionType version);
    
    /**
     * An XML ProcessOutputs(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public interface ProcessOutputs extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessOutputs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("processoutputs8866elemtype");
        
        /**
         * Gets array of all "Output" elements
         */
        net.opengeospatial.wps.IOValueType[] getOutputArray();
        
        /**
         * Gets ith "Output" element
         */
        net.opengeospatial.wps.IOValueType getOutputArray(int i);
        
        /**
         * Returns number of "Output" element
         */
        int sizeOfOutputArray();
        
        /**
         * Sets array of all "Output" element
         */
        void setOutputArray(net.opengeospatial.wps.IOValueType[] outputArray);
        
        /**
         * Sets ith "Output" element
         */
        void setOutputArray(int i, net.opengeospatial.wps.IOValueType output);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Output" element
         */
        net.opengeospatial.wps.IOValueType insertNewOutput(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Output" element
         */
        net.opengeospatial.wps.IOValueType addNewOutput();
        
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
            public static net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs newInstance() {
              return (net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.wps.ExecuteResponseType newInstance() {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.wps.ExecuteResponseType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.ExecuteResponseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.ExecuteResponseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.ExecuteResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

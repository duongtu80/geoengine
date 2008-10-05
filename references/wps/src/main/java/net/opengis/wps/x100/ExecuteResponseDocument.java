/*
 * An XML document type.
 * Localname: ExecuteResponse
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ExecuteResponseDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * A document containing one ExecuteResponse(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public interface ExecuteResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ExecuteResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("executeresponsed6a1doctype");
    
    /**
     * Gets the "ExecuteResponse" element
     */
    net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse getExecuteResponse();
    
    /**
     * Sets the "ExecuteResponse" element
     */
    void setExecuteResponse(net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse executeResponse);
    
    /**
     * Appends and returns a new empty "ExecuteResponse" element
     */
    net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse addNewExecuteResponse();
    
    /**
     * An XML ExecuteResponse(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public interface ExecuteResponse extends net.opengis.wps.x100.ResponseBaseType
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ExecuteResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("executeresponse603felemtype");
        
        /**
         * Gets the "Process" element
         */
        net.opengis.wps.x100.ProcessBriefType getProcess();
        
        /**
         * Sets the "Process" element
         */
        void setProcess(net.opengis.wps.x100.ProcessBriefType process);
        
        /**
         * Appends and returns a new empty "Process" element
         */
        net.opengis.wps.x100.ProcessBriefType addNewProcess();
        
        /**
         * Gets the "Status" element
         */
        net.opengis.wps.x100.StatusType getStatus();
        
        /**
         * Sets the "Status" element
         */
        void setStatus(net.opengis.wps.x100.StatusType status);
        
        /**
         * Appends and returns a new empty "Status" element
         */
        net.opengis.wps.x100.StatusType addNewStatus();
        
        /**
         * Gets the "DataInputs" element
         */
        net.opengis.wps.x100.DataInputsType getDataInputs();
        
        /**
         * True if has "DataInputs" element
         */
        boolean isSetDataInputs();
        
        /**
         * Sets the "DataInputs" element
         */
        void setDataInputs(net.opengis.wps.x100.DataInputsType dataInputs);
        
        /**
         * Appends and returns a new empty "DataInputs" element
         */
        net.opengis.wps.x100.DataInputsType addNewDataInputs();
        
        /**
         * Unsets the "DataInputs" element
         */
        void unsetDataInputs();
        
        /**
         * Gets the "OutputDefinitions" element
         */
        net.opengis.wps.x100.OutputDefinitionsType getOutputDefinitions();
        
        /**
         * True if has "OutputDefinitions" element
         */
        boolean isSetOutputDefinitions();
        
        /**
         * Sets the "OutputDefinitions" element
         */
        void setOutputDefinitions(net.opengis.wps.x100.OutputDefinitionsType outputDefinitions);
        
        /**
         * Appends and returns a new empty "OutputDefinitions" element
         */
        net.opengis.wps.x100.OutputDefinitionsType addNewOutputDefinitions();
        
        /**
         * Unsets the "OutputDefinitions" element
         */
        void unsetOutputDefinitions();
        
        /**
         * Gets the "ProcessOutputs" element
         */
        net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs getProcessOutputs();
        
        /**
         * True if has "ProcessOutputs" element
         */
        boolean isSetProcessOutputs();
        
        /**
         * Sets the "ProcessOutputs" element
         */
        void setProcessOutputs(net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs processOutputs);
        
        /**
         * Appends and returns a new empty "ProcessOutputs" element
         */
        net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs addNewProcessOutputs();
        
        /**
         * Unsets the "ProcessOutputs" element
         */
        void unsetProcessOutputs();
        
        /**
         * Gets the "serviceInstance" attribute
         */
        java.lang.String getServiceInstance();
        
        /**
         * Gets (as xml) the "serviceInstance" attribute
         */
        org.apache.xmlbeans.XmlAnyURI xgetServiceInstance();
        
        /**
         * Sets the "serviceInstance" attribute
         */
        void setServiceInstance(java.lang.String serviceInstance);
        
        /**
         * Sets (as xml) the "serviceInstance" attribute
         */
        void xsetServiceInstance(org.apache.xmlbeans.XmlAnyURI serviceInstance);
        
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
         * An XML ProcessOutputs(@http://www.opengis.net/wps/1.0.0).
         *
         * This is a complex type.
         */
        public interface ProcessOutputs extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessOutputs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("processoutputs6ac0elemtype");
            
            /**
             * Gets array of all "Output" elements
             */
            net.opengis.wps.x100.OutputDataType[] getOutputArray();
            
            /**
             * Gets ith "Output" element
             */
            net.opengis.wps.x100.OutputDataType getOutputArray(int i);
            
            /**
             * Returns number of "Output" element
             */
            int sizeOfOutputArray();
            
            /**
             * Sets array of all "Output" element
             */
            void setOutputArray(net.opengis.wps.x100.OutputDataType[] outputArray);
            
            /**
             * Sets ith "Output" element
             */
            void setOutputArray(int i, net.opengis.wps.x100.OutputDataType output);
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "Output" element
             */
            net.opengis.wps.x100.OutputDataType insertNewOutput(int i);
            
            /**
             * Appends and returns a new empty value (as xml) as the last "Output" element
             */
            net.opengis.wps.x100.OutputDataType addNewOutput();
            
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
                public static net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs newInstance() {
                  return (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse newInstance() {
              return (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.ExecuteResponseDocument newInstance() {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ExecuteResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ExecuteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

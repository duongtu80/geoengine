/*
 * XML Type:  ProcessDescriptionType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ProcessDescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps;


/**
 * An XML ProcessDescriptionType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public interface ProcessDescriptionType extends net.opengeospatial.wps.ProcessBriefType
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessDescriptionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("processdescriptiontypeb0f0type");
    
    /**
     * Gets the "DataInputs" element
     */
    net.opengeospatial.wps.ProcessDescriptionType.DataInputs getDataInputs();
    
    /**
     * True if has "DataInputs" element
     */
    boolean isSetDataInputs();
    
    /**
     * Sets the "DataInputs" element
     */
    void setDataInputs(net.opengeospatial.wps.ProcessDescriptionType.DataInputs dataInputs);
    
    /**
     * Appends and returns a new empty "DataInputs" element
     */
    net.opengeospatial.wps.ProcessDescriptionType.DataInputs addNewDataInputs();
    
    /**
     * Unsets the "DataInputs" element
     */
    void unsetDataInputs();
    
    /**
     * Gets the "ProcessOutputs" element
     */
    net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs getProcessOutputs();
    
    /**
     * Sets the "ProcessOutputs" element
     */
    void setProcessOutputs(net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs processOutputs);
    
    /**
     * Appends and returns a new empty "ProcessOutputs" element
     */
    net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs addNewProcessOutputs();
    
    /**
     * Gets the "storeSupported" attribute
     */
    boolean getStoreSupported();
    
    /**
     * Gets (as xml) the "storeSupported" attribute
     */
    org.apache.xmlbeans.XmlBoolean xgetStoreSupported();
    
    /**
     * True if has "storeSupported" attribute
     */
    boolean isSetStoreSupported();
    
    /**
     * Sets the "storeSupported" attribute
     */
    void setStoreSupported(boolean storeSupported);
    
    /**
     * Sets (as xml) the "storeSupported" attribute
     */
    void xsetStoreSupported(org.apache.xmlbeans.XmlBoolean storeSupported);
    
    /**
     * Unsets the "storeSupported" attribute
     */
    void unsetStoreSupported();
    
    /**
     * Gets the "statusSupported" attribute
     */
    boolean getStatusSupported();
    
    /**
     * Gets (as xml) the "statusSupported" attribute
     */
    org.apache.xmlbeans.XmlBoolean xgetStatusSupported();
    
    /**
     * True if has "statusSupported" attribute
     */
    boolean isSetStatusSupported();
    
    /**
     * Sets the "statusSupported" attribute
     */
    void setStatusSupported(boolean statusSupported);
    
    /**
     * Sets (as xml) the "statusSupported" attribute
     */
    void xsetStatusSupported(org.apache.xmlbeans.XmlBoolean statusSupported);
    
    /**
     * Unsets the "statusSupported" attribute
     */
    void unsetStatusSupported();
    
    /**
     * An XML DataInputs(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public interface DataInputs extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DataInputs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("datainputs72a1elemtype");
        
        /**
         * Gets array of all "Input" elements
         */
        net.opengeospatial.wps.InputDescriptionType[] getInputArray();
        
        /**
         * Gets ith "Input" element
         */
        net.opengeospatial.wps.InputDescriptionType getInputArray(int i);
        
        /**
         * Returns number of "Input" element
         */
        int sizeOfInputArray();
        
        /**
         * Sets array of all "Input" element
         */
        void setInputArray(net.opengeospatial.wps.InputDescriptionType[] inputArray);
        
        /**
         * Sets ith "Input" element
         */
        void setInputArray(int i, net.opengeospatial.wps.InputDescriptionType input);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Input" element
         */
        net.opengeospatial.wps.InputDescriptionType insertNewInput(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Input" element
         */
        net.opengeospatial.wps.InputDescriptionType addNewInput();
        
        /**
         * Removes the ith "Input" element
         */
        void removeInput(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengeospatial.wps.ProcessDescriptionType.DataInputs newInstance() {
              return (net.opengeospatial.wps.ProcessDescriptionType.DataInputs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.wps.ProcessDescriptionType.DataInputs newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.wps.ProcessDescriptionType.DataInputs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * An XML ProcessOutputs(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public interface ProcessOutputs extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessOutputs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("processoutputsb8b1elemtype");
        
        /**
         * Gets array of all "Output" elements
         */
        net.opengeospatial.wps.OutputDescriptionType[] getOutputArray();
        
        /**
         * Gets ith "Output" element
         */
        net.opengeospatial.wps.OutputDescriptionType getOutputArray(int i);
        
        /**
         * Returns number of "Output" element
         */
        int sizeOfOutputArray();
        
        /**
         * Sets array of all "Output" element
         */
        void setOutputArray(net.opengeospatial.wps.OutputDescriptionType[] outputArray);
        
        /**
         * Sets ith "Output" element
         */
        void setOutputArray(int i, net.opengeospatial.wps.OutputDescriptionType output);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Output" element
         */
        net.opengeospatial.wps.OutputDescriptionType insertNewOutput(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Output" element
         */
        net.opengeospatial.wps.OutputDescriptionType addNewOutput();
        
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
            public static net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs newInstance() {
              return (net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.wps.ProcessDescriptionType newInstance() {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.ProcessDescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.ProcessDescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.ProcessDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

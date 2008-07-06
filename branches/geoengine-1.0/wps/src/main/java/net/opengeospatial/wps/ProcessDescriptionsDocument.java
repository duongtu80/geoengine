/*
 * An XML document type.
 * Localname: ProcessDescriptions
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ProcessDescriptionsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps;


/**
 * A document containing one ProcessDescriptions(@http://www.opengeospatial.net/wps) element.
 *
 * This is a complex type.
 */
public interface ProcessDescriptionsDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessDescriptionsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("processdescriptionsf3cddoctype");
    
    /**
     * Gets the "ProcessDescriptions" element
     */
    net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions getProcessDescriptions();
    
    /**
     * Sets the "ProcessDescriptions" element
     */
    void setProcessDescriptions(net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions processDescriptions);
    
    /**
     * Appends and returns a new empty "ProcessDescriptions" element
     */
    net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions addNewProcessDescriptions();
    
    /**
     * An XML ProcessDescriptions(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public interface ProcessDescriptions extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessDescriptions.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("processdescriptions1e1felemtype");
        
        /**
         * Gets array of all "ProcessDescription" elements
         */
        net.opengeospatial.wps.ProcessDescriptionType[] getProcessDescriptionArray();
        
        /**
         * Gets ith "ProcessDescription" element
         */
        net.opengeospatial.wps.ProcessDescriptionType getProcessDescriptionArray(int i);
        
        /**
         * Returns number of "ProcessDescription" element
         */
        int sizeOfProcessDescriptionArray();
        
        /**
         * Sets array of all "ProcessDescription" element
         */
        void setProcessDescriptionArray(net.opengeospatial.wps.ProcessDescriptionType[] processDescriptionArray);
        
        /**
         * Sets ith "ProcessDescription" element
         */
        void setProcessDescriptionArray(int i, net.opengeospatial.wps.ProcessDescriptionType processDescription);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ProcessDescription" element
         */
        net.opengeospatial.wps.ProcessDescriptionType insertNewProcessDescription(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ProcessDescription" element
         */
        net.opengeospatial.wps.ProcessDescriptionType addNewProcessDescription();
        
        /**
         * Removes the ith "ProcessDescription" element
         */
        void removeProcessDescription(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions newInstance() {
              return (net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.wps.ProcessDescriptionsDocument newInstance() {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.wps.ProcessDescriptionsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.wps.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

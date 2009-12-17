/*
 * An XML document type.
 * Localname: ProcessDescriptions
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ProcessDescriptionsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100;


/**
 * A document containing one ProcessDescriptions(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public interface ProcessDescriptionsDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessDescriptionsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("processdescriptions32f1doctype");
    
    /**
     * Gets the "ProcessDescriptions" element
     */
    net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions getProcessDescriptions();
    
    /**
     * Sets the "ProcessDescriptions" element
     */
    void setProcessDescriptions(net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions processDescriptions);
    
    /**
     * Appends and returns a new empty "ProcessDescriptions" element
     */
    net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions addNewProcessDescriptions();
    
    /**
     * An XML ProcessDescriptions(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public interface ProcessDescriptions extends net.opengis.wps.x100.ResponseBaseType
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessDescriptions.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("processdescriptions765felemtype");
        
        /**
         * Gets array of all "ProcessDescription" elements
         */
        net.opengis.wps.x100.ProcessDescriptionType[] getProcessDescriptionArray();
        
        /**
         * Gets ith "ProcessDescription" element
         */
        net.opengis.wps.x100.ProcessDescriptionType getProcessDescriptionArray(int i);
        
        /**
         * Returns number of "ProcessDescription" element
         */
        int sizeOfProcessDescriptionArray();
        
        /**
         * Sets array of all "ProcessDescription" element
         */
        void setProcessDescriptionArray(net.opengis.wps.x100.ProcessDescriptionType[] processDescriptionArray);
        
        /**
         * Sets ith "ProcessDescription" element
         */
        void setProcessDescriptionArray(int i, net.opengis.wps.x100.ProcessDescriptionType processDescription);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ProcessDescription" element
         */
        net.opengis.wps.x100.ProcessDescriptionType insertNewProcessDescription(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ProcessDescription" element
         */
        net.opengis.wps.x100.ProcessDescriptionType addNewProcessDescription();
        
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
            public static net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions newInstance() {
              return (net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.wps.x100.ProcessDescriptionsDocument newInstance() {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.wps.x100.ProcessDescriptionsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.wps.x100.ProcessDescriptionsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

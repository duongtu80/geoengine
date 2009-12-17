/*
 * An XML document type.
 * Localname: OperationsMetadata
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.OperationsMetadataDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * A document containing one OperationsMetadata(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public interface OperationsMetadataDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OperationsMetadataDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("operationsmetadatab59adoctype");
    
    /**
     * Gets the "OperationsMetadata" element
     */
    net.opengis.ows.x11.OperationsMetadataDocument.OperationsMetadata getOperationsMetadata();
    
    /**
     * Sets the "OperationsMetadata" element
     */
    void setOperationsMetadata(net.opengis.ows.x11.OperationsMetadataDocument.OperationsMetadata operationsMetadata);
    
    /**
     * Appends and returns a new empty "OperationsMetadata" element
     */
    net.opengis.ows.x11.OperationsMetadataDocument.OperationsMetadata addNewOperationsMetadata();
    
    /**
     * An XML OperationsMetadata(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public interface OperationsMetadata extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OperationsMetadata.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("operationsmetadata5211elemtype");
        
        /**
         * Gets array of all "Operation" elements
         */
        net.opengis.ows.x11.OperationDocument.Operation[] getOperationArray();
        
        /**
         * Gets ith "Operation" element
         */
        net.opengis.ows.x11.OperationDocument.Operation getOperationArray(int i);
        
        /**
         * Returns number of "Operation" element
         */
        int sizeOfOperationArray();
        
        /**
         * Sets array of all "Operation" element
         */
        void setOperationArray(net.opengis.ows.x11.OperationDocument.Operation[] operationArray);
        
        /**
         * Sets ith "Operation" element
         */
        void setOperationArray(int i, net.opengis.ows.x11.OperationDocument.Operation operation);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Operation" element
         */
        net.opengis.ows.x11.OperationDocument.Operation insertNewOperation(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Operation" element
         */
        net.opengis.ows.x11.OperationDocument.Operation addNewOperation();
        
        /**
         * Removes the ith "Operation" element
         */
        void removeOperation(int i);
        
        /**
         * Gets array of all "Parameter" elements
         */
        net.opengis.ows.x11.DomainType[] getParameterArray();
        
        /**
         * Gets ith "Parameter" element
         */
        net.opengis.ows.x11.DomainType getParameterArray(int i);
        
        /**
         * Returns number of "Parameter" element
         */
        int sizeOfParameterArray();
        
        /**
         * Sets array of all "Parameter" element
         */
        void setParameterArray(net.opengis.ows.x11.DomainType[] parameterArray);
        
        /**
         * Sets ith "Parameter" element
         */
        void setParameterArray(int i, net.opengis.ows.x11.DomainType parameter);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Parameter" element
         */
        net.opengis.ows.x11.DomainType insertNewParameter(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Parameter" element
         */
        net.opengis.ows.x11.DomainType addNewParameter();
        
        /**
         * Removes the ith "Parameter" element
         */
        void removeParameter(int i);
        
        /**
         * Gets array of all "Constraint" elements
         */
        net.opengis.ows.x11.DomainType[] getConstraintArray();
        
        /**
         * Gets ith "Constraint" element
         */
        net.opengis.ows.x11.DomainType getConstraintArray(int i);
        
        /**
         * Returns number of "Constraint" element
         */
        int sizeOfConstraintArray();
        
        /**
         * Sets array of all "Constraint" element
         */
        void setConstraintArray(net.opengis.ows.x11.DomainType[] constraintArray);
        
        /**
         * Sets ith "Constraint" element
         */
        void setConstraintArray(int i, net.opengis.ows.x11.DomainType constraint);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Constraint" element
         */
        net.opengis.ows.x11.DomainType insertNewConstraint(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Constraint" element
         */
        net.opengis.ows.x11.DomainType addNewConstraint();
        
        /**
         * Removes the ith "Constraint" element
         */
        void removeConstraint(int i);
        
        /**
         * Gets the "ExtendedCapabilities" element
         */
        org.apache.xmlbeans.XmlObject getExtendedCapabilities();
        
        /**
         * True if has "ExtendedCapabilities" element
         */
        boolean isSetExtendedCapabilities();
        
        /**
         * Sets the "ExtendedCapabilities" element
         */
        void setExtendedCapabilities(org.apache.xmlbeans.XmlObject extendedCapabilities);
        
        /**
         * Appends and returns a new empty "ExtendedCapabilities" element
         */
        org.apache.xmlbeans.XmlObject addNewExtendedCapabilities();
        
        /**
         * Unsets the "ExtendedCapabilities" element
         */
        void unsetExtendedCapabilities();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengis.ows.x11.OperationsMetadataDocument.OperationsMetadata newInstance() {
              return (net.opengis.ows.x11.OperationsMetadataDocument.OperationsMetadata) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengis.ows.x11.OperationsMetadataDocument.OperationsMetadata newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengis.ows.x11.OperationsMetadataDocument.OperationsMetadata) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.OperationsMetadataDocument newInstance() {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.OperationsMetadataDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

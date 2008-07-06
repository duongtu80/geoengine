/*
 * An XML document type.
 * Localname: OperationsMetadata
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.OperationsMetadataDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * A document containing one OperationsMetadata(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public interface OperationsMetadataDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OperationsMetadataDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("operationsmetadata95a5doctype");
    
    /**
     * Gets the "OperationsMetadata" element
     */
    net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata getOperationsMetadata();
    
    /**
     * Sets the "OperationsMetadata" element
     */
    void setOperationsMetadata(net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata operationsMetadata);
    
    /**
     * Appends and returns a new empty "OperationsMetadata" element
     */
    net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata addNewOperationsMetadata();
    
    /**
     * An XML OperationsMetadata(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public interface OperationsMetadata extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OperationsMetadata.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("operationsmetadata91ceelemtype");
        
        /**
         * Gets array of all "Operation" elements
         */
        net.opengeospatial.ows.OperationDocument.Operation[] getOperationArray();
        
        /**
         * Gets ith "Operation" element
         */
        net.opengeospatial.ows.OperationDocument.Operation getOperationArray(int i);
        
        /**
         * Returns number of "Operation" element
         */
        int sizeOfOperationArray();
        
        /**
         * Sets array of all "Operation" element
         */
        void setOperationArray(net.opengeospatial.ows.OperationDocument.Operation[] operationArray);
        
        /**
         * Sets ith "Operation" element
         */
        void setOperationArray(int i, net.opengeospatial.ows.OperationDocument.Operation operation);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Operation" element
         */
        net.opengeospatial.ows.OperationDocument.Operation insertNewOperation(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Operation" element
         */
        net.opengeospatial.ows.OperationDocument.Operation addNewOperation();
        
        /**
         * Removes the ith "Operation" element
         */
        void removeOperation(int i);
        
        /**
         * Gets array of all "Parameter" elements
         */
        net.opengeospatial.ows.DomainType[] getParameterArray();
        
        /**
         * Gets ith "Parameter" element
         */
        net.opengeospatial.ows.DomainType getParameterArray(int i);
        
        /**
         * Returns number of "Parameter" element
         */
        int sizeOfParameterArray();
        
        /**
         * Sets array of all "Parameter" element
         */
        void setParameterArray(net.opengeospatial.ows.DomainType[] parameterArray);
        
        /**
         * Sets ith "Parameter" element
         */
        void setParameterArray(int i, net.opengeospatial.ows.DomainType parameter);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Parameter" element
         */
        net.opengeospatial.ows.DomainType insertNewParameter(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Parameter" element
         */
        net.opengeospatial.ows.DomainType addNewParameter();
        
        /**
         * Removes the ith "Parameter" element
         */
        void removeParameter(int i);
        
        /**
         * Gets array of all "Constraint" elements
         */
        net.opengeospatial.ows.DomainType[] getConstraintArray();
        
        /**
         * Gets ith "Constraint" element
         */
        net.opengeospatial.ows.DomainType getConstraintArray(int i);
        
        /**
         * Returns number of "Constraint" element
         */
        int sizeOfConstraintArray();
        
        /**
         * Sets array of all "Constraint" element
         */
        void setConstraintArray(net.opengeospatial.ows.DomainType[] constraintArray);
        
        /**
         * Sets ith "Constraint" element
         */
        void setConstraintArray(int i, net.opengeospatial.ows.DomainType constraint);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Constraint" element
         */
        net.opengeospatial.ows.DomainType insertNewConstraint(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Constraint" element
         */
        net.opengeospatial.ows.DomainType addNewConstraint();
        
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
            public static net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata newInstance() {
              return (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.OperationsMetadataDocument newInstance() {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.OperationsMetadataDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.OperationsMetadataDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

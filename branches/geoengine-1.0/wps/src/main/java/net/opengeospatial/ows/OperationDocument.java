/*
 * An XML document type.
 * Localname: Operation
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.OperationDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * A document containing one Operation(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public interface OperationDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(OperationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("operation207fdoctype");
    
    /**
     * Gets the "Operation" element
     */
    net.opengeospatial.ows.OperationDocument.Operation getOperation();
    
    /**
     * Sets the "Operation" element
     */
    void setOperation(net.opengeospatial.ows.OperationDocument.Operation operation);
    
    /**
     * Appends and returns a new empty "Operation" element
     */
    net.opengeospatial.ows.OperationDocument.Operation addNewOperation();
    
    /**
     * An XML Operation(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public interface Operation extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Operation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("operationb6f2elemtype");
        
        /**
         * Gets array of all "DCP" elements
         */
        net.opengeospatial.ows.DCPDocument.DCP[] getDCPArray();
        
        /**
         * Gets ith "DCP" element
         */
        net.opengeospatial.ows.DCPDocument.DCP getDCPArray(int i);
        
        /**
         * Returns number of "DCP" element
         */
        int sizeOfDCPArray();
        
        /**
         * Sets array of all "DCP" element
         */
        void setDCPArray(net.opengeospatial.ows.DCPDocument.DCP[] dcpArray);
        
        /**
         * Sets ith "DCP" element
         */
        void setDCPArray(int i, net.opengeospatial.ows.DCPDocument.DCP dcp);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "DCP" element
         */
        net.opengeospatial.ows.DCPDocument.DCP insertNewDCP(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "DCP" element
         */
        net.opengeospatial.ows.DCPDocument.DCP addNewDCP();
        
        /**
         * Removes the ith "DCP" element
         */
        void removeDCP(int i);
        
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
         * Gets array of all "Metadata" elements
         */
        net.opengeospatial.ows.MetadataType[] getMetadataArray();
        
        /**
         * Gets ith "Metadata" element
         */
        net.opengeospatial.ows.MetadataType getMetadataArray(int i);
        
        /**
         * Returns number of "Metadata" element
         */
        int sizeOfMetadataArray();
        
        /**
         * Sets array of all "Metadata" element
         */
        void setMetadataArray(net.opengeospatial.ows.MetadataType[] metadataArray);
        
        /**
         * Sets ith "Metadata" element
         */
        void setMetadataArray(int i, net.opengeospatial.ows.MetadataType metadata);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Metadata" element
         */
        net.opengeospatial.ows.MetadataType insertNewMetadata(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Metadata" element
         */
        net.opengeospatial.ows.MetadataType addNewMetadata();
        
        /**
         * Removes the ith "Metadata" element
         */
        void removeMetadata(int i);
        
        /**
         * Gets the "name" attribute
         */
        java.lang.String getName();
        
        /**
         * Gets (as xml) the "name" attribute
         */
        org.apache.xmlbeans.XmlString xgetName();
        
        /**
         * Sets the "name" attribute
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "name" attribute
         */
        void xsetName(org.apache.xmlbeans.XmlString name);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengeospatial.ows.OperationDocument.Operation newInstance() {
              return (net.opengeospatial.ows.OperationDocument.Operation) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.ows.OperationDocument.Operation newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.ows.OperationDocument.Operation) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.OperationDocument newInstance() {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.OperationDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.OperationDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.OperationDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.OperationDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.OperationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.OperationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.OperationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

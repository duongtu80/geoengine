/*
 * An XML document type.
 * Localname: ServiceIdentification
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ServiceIdentificationDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * A document containing one ServiceIdentification(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public interface ServiceIdentificationDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ServiceIdentificationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("serviceidentification88e4doctype");
    
    /**
     * Gets the "ServiceIdentification" element
     */
    net.opengis.ows.x11.ServiceIdentificationDocument.ServiceIdentification getServiceIdentification();
    
    /**
     * Sets the "ServiceIdentification" element
     */
    void setServiceIdentification(net.opengis.ows.x11.ServiceIdentificationDocument.ServiceIdentification serviceIdentification);
    
    /**
     * Appends and returns a new empty "ServiceIdentification" element
     */
    net.opengis.ows.x11.ServiceIdentificationDocument.ServiceIdentification addNewServiceIdentification();
    
    /**
     * An XML ServiceIdentification(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public interface ServiceIdentification extends net.opengis.ows.x11.DescriptionType
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ServiceIdentification.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("serviceidentificationc135elemtype");
        
        /**
         * Gets the "ServiceType" element
         */
        net.opengis.ows.x11.CodeType getServiceType();
        
        /**
         * Sets the "ServiceType" element
         */
        void setServiceType(net.opengis.ows.x11.CodeType serviceType);
        
        /**
         * Appends and returns a new empty "ServiceType" element
         */
        net.opengis.ows.x11.CodeType addNewServiceType();
        
        /**
         * Gets array of all "ServiceTypeVersion" elements
         */
        java.lang.String[] getServiceTypeVersionArray();
        
        /**
         * Gets ith "ServiceTypeVersion" element
         */
        java.lang.String getServiceTypeVersionArray(int i);
        
        /**
         * Gets (as xml) array of all "ServiceTypeVersion" elements
         */
        net.opengis.ows.x11.VersionType[] xgetServiceTypeVersionArray();
        
        /**
         * Gets (as xml) ith "ServiceTypeVersion" element
         */
        net.opengis.ows.x11.VersionType xgetServiceTypeVersionArray(int i);
        
        /**
         * Returns number of "ServiceTypeVersion" element
         */
        int sizeOfServiceTypeVersionArray();
        
        /**
         * Sets array of all "ServiceTypeVersion" element
         */
        void setServiceTypeVersionArray(java.lang.String[] serviceTypeVersionArray);
        
        /**
         * Sets ith "ServiceTypeVersion" element
         */
        void setServiceTypeVersionArray(int i, java.lang.String serviceTypeVersion);
        
        /**
         * Sets (as xml) array of all "ServiceTypeVersion" element
         */
        void xsetServiceTypeVersionArray(net.opengis.ows.x11.VersionType[] serviceTypeVersionArray);
        
        /**
         * Sets (as xml) ith "ServiceTypeVersion" element
         */
        void xsetServiceTypeVersionArray(int i, net.opengis.ows.x11.VersionType serviceTypeVersion);
        
        /**
         * Inserts the value as the ith "ServiceTypeVersion" element
         */
        void insertServiceTypeVersion(int i, java.lang.String serviceTypeVersion);
        
        /**
         * Appends the value as the last "ServiceTypeVersion" element
         */
        void addServiceTypeVersion(java.lang.String serviceTypeVersion);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ServiceTypeVersion" element
         */
        net.opengis.ows.x11.VersionType insertNewServiceTypeVersion(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ServiceTypeVersion" element
         */
        net.opengis.ows.x11.VersionType addNewServiceTypeVersion();
        
        /**
         * Removes the ith "ServiceTypeVersion" element
         */
        void removeServiceTypeVersion(int i);
        
        /**
         * Gets array of all "Profile" elements
         */
        java.lang.String[] getProfileArray();
        
        /**
         * Gets ith "Profile" element
         */
        java.lang.String getProfileArray(int i);
        
        /**
         * Gets (as xml) array of all "Profile" elements
         */
        org.apache.xmlbeans.XmlAnyURI[] xgetProfileArray();
        
        /**
         * Gets (as xml) ith "Profile" element
         */
        org.apache.xmlbeans.XmlAnyURI xgetProfileArray(int i);
        
        /**
         * Returns number of "Profile" element
         */
        int sizeOfProfileArray();
        
        /**
         * Sets array of all "Profile" element
         */
        void setProfileArray(java.lang.String[] profileArray);
        
        /**
         * Sets ith "Profile" element
         */
        void setProfileArray(int i, java.lang.String profile);
        
        /**
         * Sets (as xml) array of all "Profile" element
         */
        void xsetProfileArray(org.apache.xmlbeans.XmlAnyURI[] profileArray);
        
        /**
         * Sets (as xml) ith "Profile" element
         */
        void xsetProfileArray(int i, org.apache.xmlbeans.XmlAnyURI profile);
        
        /**
         * Inserts the value as the ith "Profile" element
         */
        void insertProfile(int i, java.lang.String profile);
        
        /**
         * Appends the value as the last "Profile" element
         */
        void addProfile(java.lang.String profile);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Profile" element
         */
        org.apache.xmlbeans.XmlAnyURI insertNewProfile(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Profile" element
         */
        org.apache.xmlbeans.XmlAnyURI addNewProfile();
        
        /**
         * Removes the ith "Profile" element
         */
        void removeProfile(int i);
        
        /**
         * Gets the "Fees" element
         */
        java.lang.String getFees();
        
        /**
         * Gets (as xml) the "Fees" element
         */
        org.apache.xmlbeans.XmlString xgetFees();
        
        /**
         * True if has "Fees" element
         */
        boolean isSetFees();
        
        /**
         * Sets the "Fees" element
         */
        void setFees(java.lang.String fees);
        
        /**
         * Sets (as xml) the "Fees" element
         */
        void xsetFees(org.apache.xmlbeans.XmlString fees);
        
        /**
         * Unsets the "Fees" element
         */
        void unsetFees();
        
        /**
         * Gets array of all "AccessConstraints" elements
         */
        java.lang.String[] getAccessConstraintsArray();
        
        /**
         * Gets ith "AccessConstraints" element
         */
        java.lang.String getAccessConstraintsArray(int i);
        
        /**
         * Gets (as xml) array of all "AccessConstraints" elements
         */
        org.apache.xmlbeans.XmlString[] xgetAccessConstraintsArray();
        
        /**
         * Gets (as xml) ith "AccessConstraints" element
         */
        org.apache.xmlbeans.XmlString xgetAccessConstraintsArray(int i);
        
        /**
         * Returns number of "AccessConstraints" element
         */
        int sizeOfAccessConstraintsArray();
        
        /**
         * Sets array of all "AccessConstraints" element
         */
        void setAccessConstraintsArray(java.lang.String[] accessConstraintsArray);
        
        /**
         * Sets ith "AccessConstraints" element
         */
        void setAccessConstraintsArray(int i, java.lang.String accessConstraints);
        
        /**
         * Sets (as xml) array of all "AccessConstraints" element
         */
        void xsetAccessConstraintsArray(org.apache.xmlbeans.XmlString[] accessConstraintsArray);
        
        /**
         * Sets (as xml) ith "AccessConstraints" element
         */
        void xsetAccessConstraintsArray(int i, org.apache.xmlbeans.XmlString accessConstraints);
        
        /**
         * Inserts the value as the ith "AccessConstraints" element
         */
        void insertAccessConstraints(int i, java.lang.String accessConstraints);
        
        /**
         * Appends the value as the last "AccessConstraints" element
         */
        void addAccessConstraints(java.lang.String accessConstraints);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "AccessConstraints" element
         */
        org.apache.xmlbeans.XmlString insertNewAccessConstraints(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "AccessConstraints" element
         */
        org.apache.xmlbeans.XmlString addNewAccessConstraints();
        
        /**
         * Removes the ith "AccessConstraints" element
         */
        void removeAccessConstraints(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengis.ows.x11.ServiceIdentificationDocument.ServiceIdentification newInstance() {
              return (net.opengis.ows.x11.ServiceIdentificationDocument.ServiceIdentification) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengis.ows.x11.ServiceIdentificationDocument.ServiceIdentification newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengis.ows.x11.ServiceIdentificationDocument.ServiceIdentification) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.ServiceIdentificationDocument newInstance() {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.ServiceIdentificationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.ServiceIdentificationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

/*
 * XML Type:  modelType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ModelType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing;


/**
 * An XML modelType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public interface ModelType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ModelType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s18035915BE4B4DC262DF2F41C2FD4884").resolveHandle("modeltype958dtype");
    
    /**
     * Gets the "id" element
     */
    java.lang.String getId();
    
    /**
     * Gets (as xml) the "id" element
     */
    org.apache.xmlbeans.XmlString xgetId();
    
    /**
     * Sets the "id" element
     */
    void setId(java.lang.String id);
    
    /**
     * Sets (as xml) the "id" element
     */
    void xsetId(org.apache.xmlbeans.XmlString id);
    
    /**
     * Gets the "title" element
     */
    java.lang.String getTitle();
    
    /**
     * Gets (as xml) the "title" element
     */
    org.apache.xmlbeans.XmlString xgetTitle();
    
    /**
     * Sets the "title" element
     */
    void setTitle(java.lang.String title);
    
    /**
     * Sets (as xml) the "title" element
     */
    void xsetTitle(org.apache.xmlbeans.XmlString title);
    
    /**
     * Gets array of all "metadata" elements
     */
    java.lang.String[] getMetadataArray();
    
    /**
     * Gets ith "metadata" element
     */
    java.lang.String getMetadataArray(int i);
    
    /**
     * Gets (as xml) array of all "metadata" elements
     */
    org.apache.xmlbeans.XmlAnyURI[] xgetMetadataArray();
    
    /**
     * Gets (as xml) ith "metadata" element
     */
    org.apache.xmlbeans.XmlAnyURI xgetMetadataArray(int i);
    
    /**
     * Returns number of "metadata" element
     */
    int sizeOfMetadataArray();
    
    /**
     * Sets array of all "metadata" element
     */
    void setMetadataArray(java.lang.String[] metadataArray);
    
    /**
     * Sets ith "metadata" element
     */
    void setMetadataArray(int i, java.lang.String metadata);
    
    /**
     * Sets (as xml) array of all "metadata" element
     */
    void xsetMetadataArray(org.apache.xmlbeans.XmlAnyURI[] metadataArray);
    
    /**
     * Sets (as xml) ith "metadata" element
     */
    void xsetMetadataArray(int i, org.apache.xmlbeans.XmlAnyURI metadata);
    
    /**
     * Inserts the value as the ith "metadata" element
     */
    void insertMetadata(int i, java.lang.String metadata);
    
    /**
     * Appends the value as the last "metadata" element
     */
    void addMetadata(java.lang.String metadata);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "metadata" element
     */
    org.apache.xmlbeans.XmlAnyURI insertNewMetadata(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "metadata" element
     */
    org.apache.xmlbeans.XmlAnyURI addNewMetadata();
    
    /**
     * Removes the ith "metadata" element
     */
    void removeMetadata(int i);
    
    /**
     * Gets the "provider" element
     */
    cn.geodata.models.geoprocessing.ModelType.Provider getProvider();
    
    /**
     * True if has "provider" element
     */
    boolean isSetProvider();
    
    /**
     * Sets the "provider" element
     */
    void setProvider(cn.geodata.models.geoprocessing.ModelType.Provider provider);
    
    /**
     * Appends and returns a new empty "provider" element
     */
    cn.geodata.models.geoprocessing.ModelType.Provider addNewProvider();
    
    /**
     * Unsets the "provider" element
     */
    void unsetProvider();
    
    /**
     * Gets the "describe" element
     */
    java.lang.String getDescribe();
    
    /**
     * Gets (as xml) the "describe" element
     */
    org.apache.xmlbeans.XmlString xgetDescribe();
    
    /**
     * True if has "describe" element
     */
    boolean isSetDescribe();
    
    /**
     * Sets the "describe" element
     */
    void setDescribe(java.lang.String describe);
    
    /**
     * Sets (as xml) the "describe" element
     */
    void xsetDescribe(org.apache.xmlbeans.XmlString describe);
    
    /**
     * Unsets the "describe" element
     */
    void unsetDescribe();
    
    /**
     * Gets array of all "process" elements
     */
    cn.geodata.models.geoprocessing.ProcessType[] getProcessArray();
    
    /**
     * Gets ith "process" element
     */
    cn.geodata.models.geoprocessing.ProcessType getProcessArray(int i);
    
    /**
     * Returns number of "process" element
     */
    int sizeOfProcessArray();
    
    /**
     * Sets array of all "process" element
     */
    void setProcessArray(cn.geodata.models.geoprocessing.ProcessType[] processArray);
    
    /**
     * Sets ith "process" element
     */
    void setProcessArray(int i, cn.geodata.models.geoprocessing.ProcessType process);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "process" element
     */
    cn.geodata.models.geoprocessing.ProcessType insertNewProcess(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "process" element
     */
    cn.geodata.models.geoprocessing.ProcessType addNewProcess();
    
    /**
     * Removes the ith "process" element
     */
    void removeProcess(int i);
    
    /**
     * An XML provider(@http://www.geodata.cn/models/geoprocessing).
     *
     * This is a complex type.
     */
    public interface Provider extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Provider.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s18035915BE4B4DC262DF2F41C2FD4884").resolveHandle("provider8460elemtype");
        
        /**
         * Gets the "IndividualName" element
         */
        java.lang.String getIndividualName();
        
        /**
         * Gets (as xml) the "IndividualName" element
         */
        org.apache.xmlbeans.XmlString xgetIndividualName();
        
        /**
         * True if has "IndividualName" element
         */
        boolean isSetIndividualName();
        
        /**
         * Sets the "IndividualName" element
         */
        void setIndividualName(java.lang.String individualName);
        
        /**
         * Sets (as xml) the "IndividualName" element
         */
        void xsetIndividualName(org.apache.xmlbeans.XmlString individualName);
        
        /**
         * Unsets the "IndividualName" element
         */
        void unsetIndividualName();
        
        /**
         * Gets the "OrganisationName" element
         */
        java.lang.String getOrganisationName();
        
        /**
         * Gets (as xml) the "OrganisationName" element
         */
        org.apache.xmlbeans.XmlString xgetOrganisationName();
        
        /**
         * True if has "OrganisationName" element
         */
        boolean isSetOrganisationName();
        
        /**
         * Sets the "OrganisationName" element
         */
        void setOrganisationName(java.lang.String organisationName);
        
        /**
         * Sets (as xml) the "OrganisationName" element
         */
        void xsetOrganisationName(org.apache.xmlbeans.XmlString organisationName);
        
        /**
         * Unsets the "OrganisationName" element
         */
        void unsetOrganisationName();
        
        /**
         * Gets the "PositionName" element
         */
        java.lang.String getPositionName();
        
        /**
         * Gets (as xml) the "PositionName" element
         */
        org.apache.xmlbeans.XmlString xgetPositionName();
        
        /**
         * True if has "PositionName" element
         */
        boolean isSetPositionName();
        
        /**
         * Sets the "PositionName" element
         */
        void setPositionName(java.lang.String positionName);
        
        /**
         * Sets (as xml) the "PositionName" element
         */
        void xsetPositionName(org.apache.xmlbeans.XmlString positionName);
        
        /**
         * Unsets the "PositionName" element
         */
        void unsetPositionName();
        
        /**
         * Gets the "Role" element
         */
        java.lang.String getRole();
        
        /**
         * Gets (as xml) the "Role" element
         */
        org.apache.xmlbeans.XmlString xgetRole();
        
        /**
         * True if has "Role" element
         */
        boolean isSetRole();
        
        /**
         * Sets the "Role" element
         */
        void setRole(java.lang.String role);
        
        /**
         * Sets (as xml) the "Role" element
         */
        void xsetRole(org.apache.xmlbeans.XmlString role);
        
        /**
         * Unsets the "Role" element
         */
        void unsetRole();
        
        /**
         * Gets the "ContactInfo" element
         */
        cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo getContactInfo();
        
        /**
         * True if has "ContactInfo" element
         */
        boolean isSetContactInfo();
        
        /**
         * Sets the "ContactInfo" element
         */
        void setContactInfo(cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo contactInfo);
        
        /**
         * Appends and returns a new empty "ContactInfo" element
         */
        cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo addNewContactInfo();
        
        /**
         * Unsets the "ContactInfo" element
         */
        void unsetContactInfo();
        
        /**
         * An XML ContactInfo(@http://www.geodata.cn/models/geoprocessing).
         *
         * This is a complex type.
         */
        public interface ContactInfo extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ContactInfo.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s18035915BE4B4DC262DF2F41C2FD4884").resolveHandle("contactinfo0b1aelemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo newInstance() {
                  return (cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cn.geodata.models.geoprocessing.ModelType.Provider newInstance() {
              return (cn.geodata.models.geoprocessing.ModelType.Provider) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cn.geodata.models.geoprocessing.ModelType.Provider newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cn.geodata.models.geoprocessing.ModelType.Provider) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cn.geodata.models.geoprocessing.ModelType newInstance() {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cn.geodata.models.geoprocessing.ModelType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cn.geodata.models.geoprocessing.ModelType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cn.geodata.models.geoprocessing.ModelType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cn.geodata.models.geoprocessing.ModelType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.ModelType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cn.geodata.models.geoprocessing.ModelType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cn.geodata.models.geoprocessing.ModelType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

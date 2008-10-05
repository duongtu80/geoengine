/*
 * XML Type:  UnNamedDomainType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.UnNamedDomainType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * An XML UnNamedDomainType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public interface UnNamedDomainType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(UnNamedDomainType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("unnameddomaintype3e19type");
    
    /**
     * Gets the "AllowedValues" element
     */
    net.opengis.ows.x11.AllowedValuesDocument.AllowedValues getAllowedValues();
    
    /**
     * True if has "AllowedValues" element
     */
    boolean isSetAllowedValues();
    
    /**
     * Sets the "AllowedValues" element
     */
    void setAllowedValues(net.opengis.ows.x11.AllowedValuesDocument.AllowedValues allowedValues);
    
    /**
     * Appends and returns a new empty "AllowedValues" element
     */
    net.opengis.ows.x11.AllowedValuesDocument.AllowedValues addNewAllowedValues();
    
    /**
     * Unsets the "AllowedValues" element
     */
    void unsetAllowedValues();
    
    /**
     * Gets the "AnyValue" element
     */
    net.opengis.ows.x11.AnyValueDocument.AnyValue getAnyValue();
    
    /**
     * True if has "AnyValue" element
     */
    boolean isSetAnyValue();
    
    /**
     * Sets the "AnyValue" element
     */
    void setAnyValue(net.opengis.ows.x11.AnyValueDocument.AnyValue anyValue);
    
    /**
     * Appends and returns a new empty "AnyValue" element
     */
    net.opengis.ows.x11.AnyValueDocument.AnyValue addNewAnyValue();
    
    /**
     * Unsets the "AnyValue" element
     */
    void unsetAnyValue();
    
    /**
     * Gets the "NoValues" element
     */
    net.opengis.ows.x11.NoValuesDocument.NoValues getNoValues();
    
    /**
     * True if has "NoValues" element
     */
    boolean isSetNoValues();
    
    /**
     * Sets the "NoValues" element
     */
    void setNoValues(net.opengis.ows.x11.NoValuesDocument.NoValues noValues);
    
    /**
     * Appends and returns a new empty "NoValues" element
     */
    net.opengis.ows.x11.NoValuesDocument.NoValues addNewNoValues();
    
    /**
     * Unsets the "NoValues" element
     */
    void unsetNoValues();
    
    /**
     * Gets the "ValuesReference" element
     */
    net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference getValuesReference();
    
    /**
     * True if has "ValuesReference" element
     */
    boolean isSetValuesReference();
    
    /**
     * Sets the "ValuesReference" element
     */
    void setValuesReference(net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference valuesReference);
    
    /**
     * Appends and returns a new empty "ValuesReference" element
     */
    net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference addNewValuesReference();
    
    /**
     * Unsets the "ValuesReference" element
     */
    void unsetValuesReference();
    
    /**
     * Gets the "DefaultValue" element
     */
    net.opengis.ows.x11.ValueType getDefaultValue();
    
    /**
     * True if has "DefaultValue" element
     */
    boolean isSetDefaultValue();
    
    /**
     * Sets the "DefaultValue" element
     */
    void setDefaultValue(net.opengis.ows.x11.ValueType defaultValue);
    
    /**
     * Appends and returns a new empty "DefaultValue" element
     */
    net.opengis.ows.x11.ValueType addNewDefaultValue();
    
    /**
     * Unsets the "DefaultValue" element
     */
    void unsetDefaultValue();
    
    /**
     * Gets the "Meaning" element
     */
    net.opengis.ows.x11.DomainMetadataType getMeaning();
    
    /**
     * True if has "Meaning" element
     */
    boolean isSetMeaning();
    
    /**
     * Sets the "Meaning" element
     */
    void setMeaning(net.opengis.ows.x11.DomainMetadataType meaning);
    
    /**
     * Appends and returns a new empty "Meaning" element
     */
    net.opengis.ows.x11.DomainMetadataType addNewMeaning();
    
    /**
     * Unsets the "Meaning" element
     */
    void unsetMeaning();
    
    /**
     * Gets the "DataType" element
     */
    net.opengis.ows.x11.DomainMetadataType getDataType();
    
    /**
     * True if has "DataType" element
     */
    boolean isSetDataType();
    
    /**
     * Sets the "DataType" element
     */
    void setDataType(net.opengis.ows.x11.DomainMetadataType dataType);
    
    /**
     * Appends and returns a new empty "DataType" element
     */
    net.opengis.ows.x11.DomainMetadataType addNewDataType();
    
    /**
     * Unsets the "DataType" element
     */
    void unsetDataType();
    
    /**
     * Gets the "UOM" element
     */
    net.opengis.ows.x11.DomainMetadataType getUOM();
    
    /**
     * True if has "UOM" element
     */
    boolean isSetUOM();
    
    /**
     * Sets the "UOM" element
     */
    void setUOM(net.opengis.ows.x11.DomainMetadataType uom);
    
    /**
     * Appends and returns a new empty "UOM" element
     */
    net.opengis.ows.x11.DomainMetadataType addNewUOM();
    
    /**
     * Unsets the "UOM" element
     */
    void unsetUOM();
    
    /**
     * Gets the "ReferenceSystem" element
     */
    net.opengis.ows.x11.DomainMetadataType getReferenceSystem();
    
    /**
     * True if has "ReferenceSystem" element
     */
    boolean isSetReferenceSystem();
    
    /**
     * Sets the "ReferenceSystem" element
     */
    void setReferenceSystem(net.opengis.ows.x11.DomainMetadataType referenceSystem);
    
    /**
     * Appends and returns a new empty "ReferenceSystem" element
     */
    net.opengis.ows.x11.DomainMetadataType addNewReferenceSystem();
    
    /**
     * Unsets the "ReferenceSystem" element
     */
    void unsetReferenceSystem();
    
    /**
     * Gets array of all "Metadata" elements
     */
    net.opengis.ows.x11.MetadataType[] getMetadataArray();
    
    /**
     * Gets ith "Metadata" element
     */
    net.opengis.ows.x11.MetadataType getMetadataArray(int i);
    
    /**
     * Returns number of "Metadata" element
     */
    int sizeOfMetadataArray();
    
    /**
     * Sets array of all "Metadata" element
     */
    void setMetadataArray(net.opengis.ows.x11.MetadataType[] metadataArray);
    
    /**
     * Sets ith "Metadata" element
     */
    void setMetadataArray(int i, net.opengis.ows.x11.MetadataType metadata);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Metadata" element
     */
    net.opengis.ows.x11.MetadataType insertNewMetadata(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metadata" element
     */
    net.opengis.ows.x11.MetadataType addNewMetadata();
    
    /**
     * Removes the ith "Metadata" element
     */
    void removeMetadata(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.UnNamedDomainType newInstance() {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.UnNamedDomainType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.UnNamedDomainType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.UnNamedDomainType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.UnNamedDomainType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

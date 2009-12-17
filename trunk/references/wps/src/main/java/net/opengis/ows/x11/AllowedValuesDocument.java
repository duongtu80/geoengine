/*
 * An XML document type.
 * Localname: AllowedValues
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AllowedValuesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * A document containing one AllowedValues(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public interface AllowedValuesDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AllowedValuesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("allowedvalues2c9ddoctype");
    
    /**
     * Gets the "AllowedValues" element
     */
    net.opengis.ows.x11.AllowedValuesDocument.AllowedValues getAllowedValues();
    
    /**
     * Sets the "AllowedValues" element
     */
    void setAllowedValues(net.opengis.ows.x11.AllowedValuesDocument.AllowedValues allowedValues);
    
    /**
     * Appends and returns a new empty "AllowedValues" element
     */
    net.opengis.ows.x11.AllowedValuesDocument.AllowedValues addNewAllowedValues();
    
    /**
     * An XML AllowedValues(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public interface AllowedValues extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AllowedValues.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("allowedvalues66a7elemtype");
        
        /**
         * Gets array of all "Value" elements
         */
        net.opengis.ows.x11.ValueType[] getValueArray();
        
        /**
         * Gets ith "Value" element
         */
        net.opengis.ows.x11.ValueType getValueArray(int i);
        
        /**
         * Returns number of "Value" element
         */
        int sizeOfValueArray();
        
        /**
         * Sets array of all "Value" element
         */
        void setValueArray(net.opengis.ows.x11.ValueType[] valueArray);
        
        /**
         * Sets ith "Value" element
         */
        void setValueArray(int i, net.opengis.ows.x11.ValueType value);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Value" element
         */
        net.opengis.ows.x11.ValueType insertNewValue(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Value" element
         */
        net.opengis.ows.x11.ValueType addNewValue();
        
        /**
         * Removes the ith "Value" element
         */
        void removeValue(int i);
        
        /**
         * Gets array of all "Range" elements
         */
        net.opengis.ows.x11.RangeType[] getRangeArray();
        
        /**
         * Gets ith "Range" element
         */
        net.opengis.ows.x11.RangeType getRangeArray(int i);
        
        /**
         * Returns number of "Range" element
         */
        int sizeOfRangeArray();
        
        /**
         * Sets array of all "Range" element
         */
        void setRangeArray(net.opengis.ows.x11.RangeType[] rangeArray);
        
        /**
         * Sets ith "Range" element
         */
        void setRangeArray(int i, net.opengis.ows.x11.RangeType range);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Range" element
         */
        net.opengis.ows.x11.RangeType insertNewRange(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Range" element
         */
        net.opengis.ows.x11.RangeType addNewRange();
        
        /**
         * Removes the ith "Range" element
         */
        void removeRange(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengis.ows.x11.AllowedValuesDocument.AllowedValues newInstance() {
              return (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengis.ows.x11.AllowedValuesDocument.AllowedValues newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.AllowedValuesDocument newInstance() {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.AllowedValuesDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.AllowedValuesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.AllowedValuesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.AllowedValuesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

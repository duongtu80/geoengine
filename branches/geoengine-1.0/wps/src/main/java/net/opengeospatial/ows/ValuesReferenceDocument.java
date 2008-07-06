/*
 * An XML document type.
 * Localname: ValuesReference
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ValuesReferenceDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows;


/**
 * A document containing one ValuesReference(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public interface ValuesReferenceDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ValuesReferenceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("valuesreferencec9a1doctype");
    
    /**
     * Gets the "ValuesReference" element
     */
    net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference getValuesReference();
    
    /**
     * Sets the "ValuesReference" element
     */
    void setValuesReference(net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference valuesReference);
    
    /**
     * Appends and returns a new empty "ValuesReference" element
     */
    net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference addNewValuesReference();
    
    /**
     * An XML ValuesReference(@http://www.opengeospatial.net/ows).
     *
     * This is an atomic type that is a restriction of net.opengeospatial.ows.ValuesReferenceDocument$ValuesReference.
     */
    public interface ValuesReference extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ValuesReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s53B69A36C1E3B8B97207756DEBC8B9C8").resolveHandle("valuesreferenceedb6elemtype");
        
        /**
         * Gets the "reference" attribute
         */
        java.lang.String getReference();
        
        /**
         * Gets (as xml) the "reference" attribute
         */
        org.apache.xmlbeans.XmlAnyURI xgetReference();
        
        /**
         * Sets the "reference" attribute
         */
        void setReference(java.lang.String reference);
        
        /**
         * Sets (as xml) the "reference" attribute
         */
        void xsetReference(org.apache.xmlbeans.XmlAnyURI reference);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference newInstance() {
              return (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengeospatial.ows.ValuesReferenceDocument newInstance() {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengeospatial.ows.ValuesReferenceDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengeospatial.ows.ValuesReferenceDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

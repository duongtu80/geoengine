/*
 * An XML document type.
 * Localname: ExceptionReport
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ExceptionReportDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11;


/**
 * A document containing one ExceptionReport(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public interface ExceptionReportDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ExceptionReportDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("exceptionreportadc4doctype");
    
    /**
     * Gets the "ExceptionReport" element
     */
    net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport getExceptionReport();
    
    /**
     * Sets the "ExceptionReport" element
     */
    void setExceptionReport(net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport exceptionReport);
    
    /**
     * Appends and returns a new empty "ExceptionReport" element
     */
    net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport addNewExceptionReport();
    
    /**
     * An XML ExceptionReport(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public interface ExceptionReport extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ExceptionReport.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("exceptionreport36f5elemtype");
        
        /**
         * Gets array of all "Exception" elements
         */
        net.opengis.ows.x11.ExceptionType[] getExceptionArray();
        
        /**
         * Gets ith "Exception" element
         */
        net.opengis.ows.x11.ExceptionType getExceptionArray(int i);
        
        /**
         * Returns number of "Exception" element
         */
        int sizeOfExceptionArray();
        
        /**
         * Sets array of all "Exception" element
         */
        void setExceptionArray(net.opengis.ows.x11.ExceptionType[] exceptionArray);
        
        /**
         * Sets ith "Exception" element
         */
        void setExceptionArray(int i, net.opengis.ows.x11.ExceptionType exception);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Exception" element
         */
        net.opengis.ows.x11.ExceptionType insertNewException(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Exception" element
         */
        net.opengis.ows.x11.ExceptionType addNewException();
        
        /**
         * Removes the ith "Exception" element
         */
        void removeException(int i);
        
        /**
         * Gets the "version" attribute
         */
        java.lang.String getVersion();
        
        /**
         * Gets (as xml) the "version" attribute
         */
        net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version xgetVersion();
        
        /**
         * Sets the "version" attribute
         */
        void setVersion(java.lang.String version);
        
        /**
         * Sets (as xml) the "version" attribute
         */
        void xsetVersion(net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version version);
        
        /**
         * Gets the "lang" attribute
         */
        java.lang.String getLang();
        
        /**
         * Gets (as xml) the "lang" attribute
         */
        org.apache.xmlbeans.XmlLanguage xgetLang();
        
        /**
         * True if has "lang" attribute
         */
        boolean isSetLang();
        
        /**
         * Sets the "lang" attribute
         */
        void setLang(java.lang.String lang);
        
        /**
         * Sets (as xml) the "lang" attribute
         */
        void xsetLang(org.apache.xmlbeans.XmlLanguage lang);
        
        /**
         * Unsets the "lang" attribute
         */
        void unsetLang();
        
        /**
         * An XML version(@).
         *
         * This is an atomic type that is a restriction of net.opengis.ows.x11.ExceptionReportDocument$ExceptionReport$Version.
         */
        public interface Version extends org.apache.xmlbeans.XmlString
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Version.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sD8016F3398DC83C8008AC4516B9A9B98").resolveHandle("version31b5attrtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version newValue(java.lang.Object obj) {
                  return (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version) type.newValue( obj ); }
                
                public static net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version newInstance() {
                  return (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport newInstance() {
              return (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.opengis.ows.x11.ExceptionReportDocument newInstance() {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.opengis.ows.x11.ExceptionReportDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.ExceptionReportDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.opengis.ows.x11.ExceptionReportDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.opengis.ows.x11.ExceptionReportDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

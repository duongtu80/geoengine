/*
 * An XML document type.
 * Localname: ExceptionReport
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ExceptionReportDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one ExceptionReport(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ExceptionReportDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ExceptionReportDocument
{
    private static final long serialVersionUID = 1L;
    
    public ExceptionReportDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXCEPTIONREPORT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ExceptionReport");
    
    
    /**
     * Gets the "ExceptionReport" element
     */
    public net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport getExceptionReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport)get_store().find_element_user(EXCEPTIONREPORT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ExceptionReport" element
     */
    public void setExceptionReport(net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport exceptionReport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport)get_store().find_element_user(EXCEPTIONREPORT$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport)get_store().add_element_user(EXCEPTIONREPORT$0);
            }
            target.set(exceptionReport);
        }
    }
    
    /**
     * Appends and returns a new empty "ExceptionReport" element
     */
    public net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport addNewExceptionReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport)get_store().add_element_user(EXCEPTIONREPORT$0);
            return target;
        }
    }
    /**
     * An XML ExceptionReport(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public static class ExceptionReportImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport
    {
        private static final long serialVersionUID = 1L;
        
        public ExceptionReportImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName EXCEPTION$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Exception");
        private static final javax.xml.namespace.QName VERSION$2 = 
            new javax.xml.namespace.QName("", "version");
        private static final javax.xml.namespace.QName LANG$4 = 
            new javax.xml.namespace.QName("http://www.w3.org/XML/1998/namespace", "lang");
        
        
        /**
         * Gets array of all "Exception" elements
         */
        public net.opengis.ows.x11.ExceptionType[] getExceptionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(EXCEPTION$0, targetList);
                net.opengis.ows.x11.ExceptionType[] result = new net.opengis.ows.x11.ExceptionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Exception" element
         */
        public net.opengis.ows.x11.ExceptionType getExceptionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ExceptionType target = null;
                target = (net.opengis.ows.x11.ExceptionType)get_store().find_element_user(EXCEPTION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Exception" element
         */
        public int sizeOfExceptionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(EXCEPTION$0);
            }
        }
        
        /**
         * Sets array of all "Exception" element
         */
        public void setExceptionArray(net.opengis.ows.x11.ExceptionType[] exceptionArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(exceptionArray, EXCEPTION$0);
            }
        }
        
        /**
         * Sets ith "Exception" element
         */
        public void setExceptionArray(int i, net.opengis.ows.x11.ExceptionType exception)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ExceptionType target = null;
                target = (net.opengis.ows.x11.ExceptionType)get_store().find_element_user(EXCEPTION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(exception);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Exception" element
         */
        public net.opengis.ows.x11.ExceptionType insertNewException(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ExceptionType target = null;
                target = (net.opengis.ows.x11.ExceptionType)get_store().insert_element_user(EXCEPTION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Exception" element
         */
        public net.opengis.ows.x11.ExceptionType addNewException()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ExceptionType target = null;
                target = (net.opengis.ows.x11.ExceptionType)get_store().add_element_user(EXCEPTION$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Exception" element
         */
        public void removeException(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(EXCEPTION$0, i);
            }
        }
        
        /**
         * Gets the "version" attribute
         */
        public java.lang.String getVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "version" attribute
         */
        public net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version xgetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version target = null;
                target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version)get_store().find_attribute_user(VERSION$2);
                return target;
            }
        }
        
        /**
         * Sets the "version" attribute
         */
        public void setVersion(java.lang.String version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VERSION$2);
                }
                target.setStringValue(version);
            }
        }
        
        /**
         * Sets (as xml) the "version" attribute
         */
        public void xsetVersion(net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version target = null;
                target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version)get_store().add_attribute_user(VERSION$2);
                }
                target.set(version);
            }
        }
        
        /**
         * Gets the "lang" attribute
         */
        public java.lang.String getLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANG$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "lang" attribute
         */
        public org.apache.xmlbeans.XmlLanguage xgetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLanguage target = null;
                target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANG$4);
                return target;
            }
        }
        
        /**
         * True if has "lang" attribute
         */
        public boolean isSetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(LANG$4) != null;
            }
        }
        
        /**
         * Sets the "lang" attribute
         */
        public void setLang(java.lang.String lang)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANG$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LANG$4);
                }
                target.setStringValue(lang);
            }
        }
        
        /**
         * Sets (as xml) the "lang" attribute
         */
        public void xsetLang(org.apache.xmlbeans.XmlLanguage lang)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLanguage target = null;
                target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANG$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLanguage)get_store().add_attribute_user(LANG$4);
                }
                target.set(lang);
            }
        }
        
        /**
         * Unsets the "lang" attribute
         */
        public void unsetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(LANG$4);
            }
        }
        /**
         * An XML version(@).
         *
         * This is an atomic type that is a restriction of net.opengis.ows.x11.ExceptionReportDocument$ExceptionReport$Version.
         */
        public static class VersionImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport.Version
        {
            private static final long serialVersionUID = 1L;
            
            public VersionImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected VersionImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
    }
}

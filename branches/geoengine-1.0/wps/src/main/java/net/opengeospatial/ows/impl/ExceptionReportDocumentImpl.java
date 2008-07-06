/*
 * An XML document type.
 * Localname: ExceptionReport
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ExceptionReportDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one ExceptionReport(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class ExceptionReportDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ExceptionReportDocument
{
    
    public ExceptionReportDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXCEPTIONREPORT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ExceptionReport");
    
    
    /**
     * Gets the "ExceptionReport" element
     */
    public net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport getExceptionReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport)get_store().find_element_user(EXCEPTIONREPORT$0, 0);
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
    public void setExceptionReport(net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport exceptionReport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport)get_store().find_element_user(EXCEPTIONREPORT$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport)get_store().add_element_user(EXCEPTIONREPORT$0);
            }
            target.set(exceptionReport);
        }
    }
    
    /**
     * Appends and returns a new empty "ExceptionReport" element
     */
    public net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport addNewExceptionReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport)get_store().add_element_user(EXCEPTIONREPORT$0);
            return target;
        }
    }
    /**
     * An XML ExceptionReport(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public static class ExceptionReportImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport
    {
        
        public ExceptionReportImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName EXCEPTION$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Exception");
        private static final javax.xml.namespace.QName VERSION$2 = 
            new javax.xml.namespace.QName("", "version");
        private static final javax.xml.namespace.QName LANGUAGE$4 = 
            new javax.xml.namespace.QName("", "language");
        
        
        /**
         * Gets array of all "Exception" elements
         */
        public net.opengeospatial.ows.ExceptionType[] getExceptionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(EXCEPTION$0, targetList);
                net.opengeospatial.ows.ExceptionType[] result = new net.opengeospatial.ows.ExceptionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Exception" element
         */
        public net.opengeospatial.ows.ExceptionType getExceptionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.ExceptionType target = null;
                target = (net.opengeospatial.ows.ExceptionType)get_store().find_element_user(EXCEPTION$0, i);
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
        public void setExceptionArray(net.opengeospatial.ows.ExceptionType[] exceptionArray)
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
        public void setExceptionArray(int i, net.opengeospatial.ows.ExceptionType exception)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.ExceptionType target = null;
                target = (net.opengeospatial.ows.ExceptionType)get_store().find_element_user(EXCEPTION$0, i);
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
        public net.opengeospatial.ows.ExceptionType insertNewException(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.ExceptionType target = null;
                target = (net.opengeospatial.ows.ExceptionType)get_store().insert_element_user(EXCEPTION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Exception" element
         */
        public net.opengeospatial.ows.ExceptionType addNewException()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.ExceptionType target = null;
                target = (net.opengeospatial.ows.ExceptionType)get_store().add_element_user(EXCEPTION$0);
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
        public org.apache.xmlbeans.XmlString xgetVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VERSION$2);
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
        public void xsetVersion(org.apache.xmlbeans.XmlString version)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VERSION$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VERSION$2);
                }
                target.set(version);
            }
        }
        
        /**
         * Gets the "language" attribute
         */
        public java.lang.String getLanguage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANGUAGE$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "language" attribute
         */
        public org.apache.xmlbeans.XmlLanguage xgetLanguage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLanguage target = null;
                target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANGUAGE$4);
                return target;
            }
        }
        
        /**
         * True if has "language" attribute
         */
        public boolean isSetLanguage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(LANGUAGE$4) != null;
            }
        }
        
        /**
         * Sets the "language" attribute
         */
        public void setLanguage(java.lang.String language)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANGUAGE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LANGUAGE$4);
                }
                target.setStringValue(language);
            }
        }
        
        /**
         * Sets (as xml) the "language" attribute
         */
        public void xsetLanguage(org.apache.xmlbeans.XmlLanguage language)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLanguage target = null;
                target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANGUAGE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLanguage)get_store().add_attribute_user(LANGUAGE$4);
                }
                target.set(language);
            }
        }
        
        /**
         * Unsets the "language" attribute
         */
        public void unsetLanguage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(LANGUAGE$4);
            }
        }
    }
}

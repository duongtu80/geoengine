/*
 * An XML document type.
 * Localname: Languages
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.LanguagesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one Languages(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class LanguagesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.LanguagesDocument
{
    private static final long serialVersionUID = 1L;
    
    public LanguagesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LANGUAGES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Languages");
    
    
    /**
     * Gets the "Languages" element
     */
    public net.opengis.wps.x100.LanguagesDocument.Languages getLanguages()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LanguagesDocument.Languages target = null;
            target = (net.opengis.wps.x100.LanguagesDocument.Languages)get_store().find_element_user(LANGUAGES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Languages" element
     */
    public void setLanguages(net.opengis.wps.x100.LanguagesDocument.Languages languages)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LanguagesDocument.Languages target = null;
            target = (net.opengis.wps.x100.LanguagesDocument.Languages)get_store().find_element_user(LANGUAGES$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.LanguagesDocument.Languages)get_store().add_element_user(LANGUAGES$0);
            }
            target.set(languages);
        }
    }
    
    /**
     * Appends and returns a new empty "Languages" element
     */
    public net.opengis.wps.x100.LanguagesDocument.Languages addNewLanguages()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LanguagesDocument.Languages target = null;
            target = (net.opengis.wps.x100.LanguagesDocument.Languages)get_store().add_element_user(LANGUAGES$0);
            return target;
        }
    }
    /**
     * An XML Languages(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public static class LanguagesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.LanguagesDocument.Languages
    {
        private static final long serialVersionUID = 1L;
        
        public LanguagesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DEFAULT$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Default");
        private static final javax.xml.namespace.QName SUPPORTED$2 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Supported");
        
        
        /**
         * Gets the "Default" element
         */
        public net.opengis.wps.x100.LanguagesDocument.Languages.Default getDefault()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.LanguagesDocument.Languages.Default target = null;
                target = (net.opengis.wps.x100.LanguagesDocument.Languages.Default)get_store().find_element_user(DEFAULT$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "Default" element
         */
        public void setDefault(net.opengis.wps.x100.LanguagesDocument.Languages.Default xdefault)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.LanguagesDocument.Languages.Default target = null;
                target = (net.opengis.wps.x100.LanguagesDocument.Languages.Default)get_store().find_element_user(DEFAULT$0, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.LanguagesDocument.Languages.Default)get_store().add_element_user(DEFAULT$0);
                }
                target.set(xdefault);
            }
        }
        
        /**
         * Appends and returns a new empty "Default" element
         */
        public net.opengis.wps.x100.LanguagesDocument.Languages.Default addNewDefault()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.LanguagesDocument.Languages.Default target = null;
                target = (net.opengis.wps.x100.LanguagesDocument.Languages.Default)get_store().add_element_user(DEFAULT$0);
                return target;
            }
        }
        
        /**
         * Gets the "Supported" element
         */
        public net.opengis.wps.x100.LanguagesType getSupported()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.LanguagesType target = null;
                target = (net.opengis.wps.x100.LanguagesType)get_store().find_element_user(SUPPORTED$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "Supported" element
         */
        public void setSupported(net.opengis.wps.x100.LanguagesType supported)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.LanguagesType target = null;
                target = (net.opengis.wps.x100.LanguagesType)get_store().find_element_user(SUPPORTED$2, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.LanguagesType)get_store().add_element_user(SUPPORTED$2);
                }
                target.set(supported);
            }
        }
        
        /**
         * Appends and returns a new empty "Supported" element
         */
        public net.opengis.wps.x100.LanguagesType addNewSupported()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.LanguagesType target = null;
                target = (net.opengis.wps.x100.LanguagesType)get_store().add_element_user(SUPPORTED$2);
                return target;
            }
        }
        /**
         * An XML Default(@http://www.opengis.net/wps/1.0.0).
         *
         * This is a complex type.
         */
        public static class DefaultImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.LanguagesDocument.Languages.Default
        {
            private static final long serialVersionUID = 1L;
            
            public DefaultImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName LANGUAGE$0 = 
                new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Language");
            
            
            /**
             * Gets the "Language" element
             */
            public java.lang.String getLanguage()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LANGUAGE$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "Language" element
             */
            public org.apache.xmlbeans.XmlLanguage xgetLanguage()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlLanguage target = null;
                    target = (org.apache.xmlbeans.XmlLanguage)get_store().find_element_user(LANGUAGE$0, 0);
                    return target;
                }
            }
            
            /**
             * Sets the "Language" element
             */
            public void setLanguage(java.lang.String language)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LANGUAGE$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LANGUAGE$0);
                    }
                    target.setStringValue(language);
                }
            }
            
            /**
             * Sets (as xml) the "Language" element
             */
            public void xsetLanguage(org.apache.xmlbeans.XmlLanguage language)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlLanguage target = null;
                    target = (org.apache.xmlbeans.XmlLanguage)get_store().find_element_user(LANGUAGE$0, 0);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlLanguage)get_store().add_element_user(LANGUAGE$0);
                    }
                    target.set(language);
                }
            }
        }
    }
}

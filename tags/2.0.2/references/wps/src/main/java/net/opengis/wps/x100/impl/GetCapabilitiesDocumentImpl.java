/*
 * An XML document type.
 * Localname: GetCapabilities
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.GetCapabilitiesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one GetCapabilities(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class GetCapabilitiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.GetCapabilitiesDocument
{
    private static final long serialVersionUID = 1L;
    
    public GetCapabilitiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETCAPABILITIES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "GetCapabilities");
    
    
    /**
     * Gets the "GetCapabilities" element
     */
    public net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities getGetCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities target = null;
            target = (net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities)get_store().find_element_user(GETCAPABILITIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "GetCapabilities" element
     */
    public void setGetCapabilities(net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities getCapabilities)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities target = null;
            target = (net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities)get_store().find_element_user(GETCAPABILITIES$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities)get_store().add_element_user(GETCAPABILITIES$0);
            }
            target.set(getCapabilities);
        }
    }
    
    /**
     * Appends and returns a new empty "GetCapabilities" element
     */
    public net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities addNewGetCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities target = null;
            target = (net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities)get_store().add_element_user(GETCAPABILITIES$0);
            return target;
        }
    }
    /**
     * An XML GetCapabilities(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public static class GetCapabilitiesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.GetCapabilitiesDocument.GetCapabilities
    {
        private static final long serialVersionUID = 1L;
        
        public GetCapabilitiesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ACCEPTVERSIONS$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "AcceptVersions");
        private static final javax.xml.namespace.QName SERVICE$2 = 
            new javax.xml.namespace.QName("", "service");
        private static final javax.xml.namespace.QName LANGUAGE$4 = 
            new javax.xml.namespace.QName("", "language");
        
        
        /**
         * Gets the "AcceptVersions" element
         */
        public net.opengis.ows.x11.AcceptVersionsType getAcceptVersions()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.AcceptVersionsType target = null;
                target = (net.opengis.ows.x11.AcceptVersionsType)get_store().find_element_user(ACCEPTVERSIONS$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "AcceptVersions" element
         */
        public boolean isSetAcceptVersions()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ACCEPTVERSIONS$0) != 0;
            }
        }
        
        /**
         * Sets the "AcceptVersions" element
         */
        public void setAcceptVersions(net.opengis.ows.x11.AcceptVersionsType acceptVersions)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.AcceptVersionsType target = null;
                target = (net.opengis.ows.x11.AcceptVersionsType)get_store().find_element_user(ACCEPTVERSIONS$0, 0);
                if (target == null)
                {
                    target = (net.opengis.ows.x11.AcceptVersionsType)get_store().add_element_user(ACCEPTVERSIONS$0);
                }
                target.set(acceptVersions);
            }
        }
        
        /**
         * Appends and returns a new empty "AcceptVersions" element
         */
        public net.opengis.ows.x11.AcceptVersionsType addNewAcceptVersions()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.AcceptVersionsType target = null;
                target = (net.opengis.ows.x11.AcceptVersionsType)get_store().add_element_user(ACCEPTVERSIONS$0);
                return target;
            }
        }
        
        /**
         * Unsets the "AcceptVersions" element
         */
        public void unsetAcceptVersions()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ACCEPTVERSIONS$0, 0);
            }
        }
        
        /**
         * Gets the "service" attribute
         */
        public java.lang.String getService()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SERVICE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(SERVICE$2);
                }
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "service" attribute
         */
        public net.opengis.ows.x11.ServiceType xgetService()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ServiceType target = null;
                target = (net.opengis.ows.x11.ServiceType)get_store().find_attribute_user(SERVICE$2);
                if (target == null)
                {
                    target = (net.opengis.ows.x11.ServiceType)get_default_attribute_value(SERVICE$2);
                }
                return target;
            }
        }
        
        /**
         * Sets the "service" attribute
         */
        public void setService(java.lang.String service)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SERVICE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SERVICE$2);
                }
                target.setStringValue(service);
            }
        }
        
        /**
         * Sets (as xml) the "service" attribute
         */
        public void xsetService(net.opengis.ows.x11.ServiceType service)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ServiceType target = null;
                target = (net.opengis.ows.x11.ServiceType)get_store().find_attribute_user(SERVICE$2);
                if (target == null)
                {
                    target = (net.opengis.ows.x11.ServiceType)get_store().add_attribute_user(SERVICE$2);
                }
                target.set(service);
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
        public org.apache.xmlbeans.XmlString xgetLanguage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LANGUAGE$4);
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
        public void xsetLanguage(org.apache.xmlbeans.XmlString language)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LANGUAGE$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(LANGUAGE$4);
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

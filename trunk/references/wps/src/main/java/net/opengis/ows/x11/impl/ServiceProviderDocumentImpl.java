/*
 * An XML document type.
 * Localname: ServiceProvider
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ServiceProviderDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one ServiceProvider(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ServiceProviderDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ServiceProviderDocument
{
    private static final long serialVersionUID = 1L;
    
    public ServiceProviderDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEPROVIDER$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ServiceProvider");
    
    
    /**
     * Gets the "ServiceProvider" element
     */
    public net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider getServiceProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider target = null;
            target = (net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider)get_store().find_element_user(SERVICEPROVIDER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ServiceProvider" element
     */
    public void setServiceProvider(net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider serviceProvider)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider target = null;
            target = (net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider)get_store().find_element_user(SERVICEPROVIDER$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider)get_store().add_element_user(SERVICEPROVIDER$0);
            }
            target.set(serviceProvider);
        }
    }
    
    /**
     * Appends and returns a new empty "ServiceProvider" element
     */
    public net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider addNewServiceProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider target = null;
            target = (net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider)get_store().add_element_user(SERVICEPROVIDER$0);
            return target;
        }
    }
    /**
     * An XML ServiceProvider(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public static class ServiceProviderImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider
    {
        private static final long serialVersionUID = 1L;
        
        public ServiceProviderImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROVIDERNAME$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ProviderName");
        private static final javax.xml.namespace.QName PROVIDERSITE$2 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ProviderSite");
        private static final javax.xml.namespace.QName SERVICECONTACT$4 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ServiceContact");
        
        
        /**
         * Gets the "ProviderName" element
         */
        public java.lang.String getProviderName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVIDERNAME$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ProviderName" element
         */
        public org.apache.xmlbeans.XmlString xgetProviderName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVIDERNAME$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ProviderName" element
         */
        public void setProviderName(java.lang.String providerName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROVIDERNAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROVIDERNAME$0);
                }
                target.setStringValue(providerName);
            }
        }
        
        /**
         * Sets (as xml) the "ProviderName" element
         */
        public void xsetProviderName(org.apache.xmlbeans.XmlString providerName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROVIDERNAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROVIDERNAME$0);
                }
                target.set(providerName);
            }
        }
        
        /**
         * Gets the "ProviderSite" element
         */
        public net.opengis.ows.x11.OnlineResourceType getProviderSite()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.OnlineResourceType target = null;
                target = (net.opengis.ows.x11.OnlineResourceType)get_store().find_element_user(PROVIDERSITE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "ProviderSite" element
         */
        public boolean isSetProviderSite()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PROVIDERSITE$2) != 0;
            }
        }
        
        /**
         * Sets the "ProviderSite" element
         */
        public void setProviderSite(net.opengis.ows.x11.OnlineResourceType providerSite)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.OnlineResourceType target = null;
                target = (net.opengis.ows.x11.OnlineResourceType)get_store().find_element_user(PROVIDERSITE$2, 0);
                if (target == null)
                {
                    target = (net.opengis.ows.x11.OnlineResourceType)get_store().add_element_user(PROVIDERSITE$2);
                }
                target.set(providerSite);
            }
        }
        
        /**
         * Appends and returns a new empty "ProviderSite" element
         */
        public net.opengis.ows.x11.OnlineResourceType addNewProviderSite()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.OnlineResourceType target = null;
                target = (net.opengis.ows.x11.OnlineResourceType)get_store().add_element_user(PROVIDERSITE$2);
                return target;
            }
        }
        
        /**
         * Unsets the "ProviderSite" element
         */
        public void unsetProviderSite()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PROVIDERSITE$2, 0);
            }
        }
        
        /**
         * Gets the "ServiceContact" element
         */
        public net.opengis.ows.x11.ResponsiblePartySubsetType getServiceContact()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ResponsiblePartySubsetType target = null;
                target = (net.opengis.ows.x11.ResponsiblePartySubsetType)get_store().find_element_user(SERVICECONTACT$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "ServiceContact" element
         */
        public void setServiceContact(net.opengis.ows.x11.ResponsiblePartySubsetType serviceContact)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ResponsiblePartySubsetType target = null;
                target = (net.opengis.ows.x11.ResponsiblePartySubsetType)get_store().find_element_user(SERVICECONTACT$4, 0);
                if (target == null)
                {
                    target = (net.opengis.ows.x11.ResponsiblePartySubsetType)get_store().add_element_user(SERVICECONTACT$4);
                }
                target.set(serviceContact);
            }
        }
        
        /**
         * Appends and returns a new empty "ServiceContact" element
         */
        public net.opengis.ows.x11.ResponsiblePartySubsetType addNewServiceContact()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ResponsiblePartySubsetType target = null;
                target = (net.opengis.ows.x11.ResponsiblePartySubsetType)get_store().add_element_user(SERVICECONTACT$4);
                return target;
            }
        }
    }
}

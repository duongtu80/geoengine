/*
 * An XML document type.
 * Localname: Capabilities
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.CapabilitiesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * A document containing one Capabilities(@http://www.opengeospatial.net/wps) element.
 *
 * This is a complex type.
 */
public class CapabilitiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.CapabilitiesDocument
{
    
    public CapabilitiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CAPABILITIES$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Capabilities");
    
    
    /**
     * Gets the "Capabilities" element
     */
    public net.opengeospatial.wps.CapabilitiesDocument.Capabilities getCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.CapabilitiesDocument.Capabilities target = null;
            target = (net.opengeospatial.wps.CapabilitiesDocument.Capabilities)get_store().find_element_user(CAPABILITIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Capabilities" element
     */
    public void setCapabilities(net.opengeospatial.wps.CapabilitiesDocument.Capabilities capabilities)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.CapabilitiesDocument.Capabilities target = null;
            target = (net.opengeospatial.wps.CapabilitiesDocument.Capabilities)get_store().find_element_user(CAPABILITIES$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.CapabilitiesDocument.Capabilities)get_store().add_element_user(CAPABILITIES$0);
            }
            target.set(capabilities);
        }
    }
    
    /**
     * Appends and returns a new empty "Capabilities" element
     */
    public net.opengeospatial.wps.CapabilitiesDocument.Capabilities addNewCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.CapabilitiesDocument.Capabilities target = null;
            target = (net.opengeospatial.wps.CapabilitiesDocument.Capabilities)get_store().add_element_user(CAPABILITIES$0);
            return target;
        }
    }
    /**
     * An XML Capabilities(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class CapabilitiesImpl extends net.opengeospatial.ows.impl.CapabilitiesBaseTypeImpl implements net.opengeospatial.wps.CapabilitiesDocument.Capabilities
    {
        
        public CapabilitiesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROCESSOFFERINGS$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessOfferings");
        
        
        /**
         * Gets the "ProcessOfferings" element
         */
        public net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings getProcessOfferings()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings target = null;
                target = (net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings)get_store().find_element_user(PROCESSOFFERINGS$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "ProcessOfferings" element
         */
        public void setProcessOfferings(net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings processOfferings)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings target = null;
                target = (net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings)get_store().find_element_user(PROCESSOFFERINGS$0, 0);
                if (target == null)
                {
                    target = (net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings)get_store().add_element_user(PROCESSOFFERINGS$0);
                }
                target.set(processOfferings);
            }
        }
        
        /**
         * Appends and returns a new empty "ProcessOfferings" element
         */
        public net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings addNewProcessOfferings()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings target = null;
                target = (net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings)get_store().add_element_user(PROCESSOFFERINGS$0);
                return target;
            }
        }
    }
}

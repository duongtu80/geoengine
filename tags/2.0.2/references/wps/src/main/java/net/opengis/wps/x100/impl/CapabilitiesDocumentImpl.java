/*
 * An XML document type.
 * Localname: Capabilities
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.CapabilitiesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one Capabilities(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class CapabilitiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.CapabilitiesDocument
{
    private static final long serialVersionUID = 1L;
    
    public CapabilitiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CAPABILITIES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Capabilities");
    
    
    /**
     * Gets the "Capabilities" element
     */
    public net.opengis.wps.x100.WPSCapabilitiesType getCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WPSCapabilitiesType target = null;
            target = (net.opengis.wps.x100.WPSCapabilitiesType)get_store().find_element_user(CAPABILITIES$0, 0);
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
    public void setCapabilities(net.opengis.wps.x100.WPSCapabilitiesType capabilities)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WPSCapabilitiesType target = null;
            target = (net.opengis.wps.x100.WPSCapabilitiesType)get_store().find_element_user(CAPABILITIES$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.WPSCapabilitiesType)get_store().add_element_user(CAPABILITIES$0);
            }
            target.set(capabilities);
        }
    }
    
    /**
     * Appends and returns a new empty "Capabilities" element
     */
    public net.opengis.wps.x100.WPSCapabilitiesType addNewCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WPSCapabilitiesType target = null;
            target = (net.opengis.wps.x100.WPSCapabilitiesType)get_store().add_element_user(CAPABILITIES$0);
            return target;
        }
    }
}

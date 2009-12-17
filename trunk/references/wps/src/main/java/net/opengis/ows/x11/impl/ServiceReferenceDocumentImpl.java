/*
 * An XML document type.
 * Localname: ServiceReference
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ServiceReferenceDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one ServiceReference(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ServiceReferenceDocumentImpl extends net.opengis.ows.x11.impl.ReferenceDocumentImpl implements net.opengis.ows.x11.ServiceReferenceDocument
{
    private static final long serialVersionUID = 1L;
    
    public ServiceReferenceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEREFERENCE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ServiceReference");
    
    
    /**
     * Gets the "ServiceReference" element
     */
    public net.opengis.ows.x11.ServiceReferenceType getServiceReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ServiceReferenceType target = null;
            target = (net.opengis.ows.x11.ServiceReferenceType)get_store().find_element_user(SERVICEREFERENCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ServiceReference" element
     */
    public void setServiceReference(net.opengis.ows.x11.ServiceReferenceType serviceReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ServiceReferenceType target = null;
            target = (net.opengis.ows.x11.ServiceReferenceType)get_store().find_element_user(SERVICEREFERENCE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ServiceReferenceType)get_store().add_element_user(SERVICEREFERENCE$0);
            }
            target.set(serviceReference);
        }
    }
    
    /**
     * Appends and returns a new empty "ServiceReference" element
     */
    public net.opengis.ows.x11.ServiceReferenceType addNewServiceReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ServiceReferenceType target = null;
            target = (net.opengis.ows.x11.ServiceReferenceType)get_store().add_element_user(SERVICEREFERENCE$0);
            return target;
        }
    }
}

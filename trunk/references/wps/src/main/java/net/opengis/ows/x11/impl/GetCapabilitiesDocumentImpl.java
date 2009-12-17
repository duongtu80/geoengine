/*
 * An XML document type.
 * Localname: GetCapabilities
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.GetCapabilitiesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one GetCapabilities(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class GetCapabilitiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.GetCapabilitiesDocument
{
    private static final long serialVersionUID = 1L;
    
    public GetCapabilitiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETCAPABILITIES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "GetCapabilities");
    
    
    /**
     * Gets the "GetCapabilities" element
     */
    public net.opengis.ows.x11.GetCapabilitiesType getGetCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.GetCapabilitiesType target = null;
            target = (net.opengis.ows.x11.GetCapabilitiesType)get_store().find_element_user(GETCAPABILITIES$0, 0);
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
    public void setGetCapabilities(net.opengis.ows.x11.GetCapabilitiesType getCapabilities)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.GetCapabilitiesType target = null;
            target = (net.opengis.ows.x11.GetCapabilitiesType)get_store().find_element_user(GETCAPABILITIES$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.GetCapabilitiesType)get_store().add_element_user(GETCAPABILITIES$0);
            }
            target.set(getCapabilities);
        }
    }
    
    /**
     * Appends and returns a new empty "GetCapabilities" element
     */
    public net.opengis.ows.x11.GetCapabilitiesType addNewGetCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.GetCapabilitiesType target = null;
            target = (net.opengis.ows.x11.GetCapabilitiesType)get_store().add_element_user(GETCAPABILITIES$0);
            return target;
        }
    }
}

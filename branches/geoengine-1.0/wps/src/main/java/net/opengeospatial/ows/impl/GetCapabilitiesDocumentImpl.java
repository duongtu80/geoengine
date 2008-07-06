/*
 * An XML document type.
 * Localname: GetCapabilities
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.GetCapabilitiesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one GetCapabilities(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class GetCapabilitiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.GetCapabilitiesDocument
{
    
    public GetCapabilitiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETCAPABILITIES$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "GetCapabilities");
    
    
    /**
     * Gets the "GetCapabilities" element
     */
    public net.opengeospatial.ows.GetCapabilitiesType getGetCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.GetCapabilitiesType target = null;
            target = (net.opengeospatial.ows.GetCapabilitiesType)get_store().find_element_user(GETCAPABILITIES$0, 0);
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
    public void setGetCapabilities(net.opengeospatial.ows.GetCapabilitiesType getCapabilities)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.GetCapabilitiesType target = null;
            target = (net.opengeospatial.ows.GetCapabilitiesType)get_store().find_element_user(GETCAPABILITIES$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.GetCapabilitiesType)get_store().add_element_user(GETCAPABILITIES$0);
            }
            target.set(getCapabilities);
        }
    }
    
    /**
     * Appends and returns a new empty "GetCapabilities" element
     */
    public net.opengeospatial.ows.GetCapabilitiesType addNewGetCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.GetCapabilitiesType target = null;
            target = (net.opengeospatial.ows.GetCapabilitiesType)get_store().add_element_user(GETCAPABILITIES$0);
            return target;
        }
    }
}

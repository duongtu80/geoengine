/*
 * An XML document type.
 * Localname: WGS84BoundingBox
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.WGS84BoundingBoxDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one WGS84BoundingBox(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class WGS84BoundingBoxDocumentImpl extends net.opengis.ows.x11.impl.BoundingBoxDocumentImpl implements net.opengis.ows.x11.WGS84BoundingBoxDocument
{
    private static final long serialVersionUID = 1L;
    
    public WGS84BoundingBoxDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WGS84BOUNDINGBOX$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "WGS84BoundingBox");
    
    
    /**
     * Gets the "WGS84BoundingBox" element
     */
    public net.opengis.ows.x11.WGS84BoundingBoxType getWGS84BoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.WGS84BoundingBoxType target = null;
            target = (net.opengis.ows.x11.WGS84BoundingBoxType)get_store().find_element_user(WGS84BOUNDINGBOX$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "WGS84BoundingBox" element
     */
    public void setWGS84BoundingBox(net.opengis.ows.x11.WGS84BoundingBoxType wgs84BoundingBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.WGS84BoundingBoxType target = null;
            target = (net.opengis.ows.x11.WGS84BoundingBoxType)get_store().find_element_user(WGS84BOUNDINGBOX$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.WGS84BoundingBoxType)get_store().add_element_user(WGS84BOUNDINGBOX$0);
            }
            target.set(wgs84BoundingBox);
        }
    }
    
    /**
     * Appends and returns a new empty "WGS84BoundingBox" element
     */
    public net.opengis.ows.x11.WGS84BoundingBoxType addNewWGS84BoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.WGS84BoundingBoxType target = null;
            target = (net.opengis.ows.x11.WGS84BoundingBoxType)get_store().add_element_user(WGS84BOUNDINGBOX$0);
            return target;
        }
    }
}

/*
 * An XML document type.
 * Localname: WGS84BoundingBox
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.WGS84BoundingBoxDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one WGS84BoundingBox(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class WGS84BoundingBoxDocumentImpl extends net.opengeospatial.ows.impl.BoundingBoxDocumentImpl implements net.opengeospatial.ows.WGS84BoundingBoxDocument
{
    
    public WGS84BoundingBoxDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WGS84BOUNDINGBOX$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "WGS84BoundingBox");
    
    
    /**
     * Gets the "WGS84BoundingBox" element
     */
    public net.opengeospatial.ows.WGS84BoundingBoxType getWGS84BoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.WGS84BoundingBoxType target = null;
            target = (net.opengeospatial.ows.WGS84BoundingBoxType)get_store().find_element_user(WGS84BOUNDINGBOX$0, 0);
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
    public void setWGS84BoundingBox(net.opengeospatial.ows.WGS84BoundingBoxType wgs84BoundingBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.WGS84BoundingBoxType target = null;
            target = (net.opengeospatial.ows.WGS84BoundingBoxType)get_store().find_element_user(WGS84BOUNDINGBOX$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.WGS84BoundingBoxType)get_store().add_element_user(WGS84BOUNDINGBOX$0);
            }
            target.set(wgs84BoundingBox);
        }
    }
    
    /**
     * Appends and returns a new empty "WGS84BoundingBox" element
     */
    public net.opengeospatial.ows.WGS84BoundingBoxType addNewWGS84BoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.WGS84BoundingBoxType target = null;
            target = (net.opengeospatial.ows.WGS84BoundingBoxType)get_store().add_element_user(WGS84BOUNDINGBOX$0);
            return target;
        }
    }
}

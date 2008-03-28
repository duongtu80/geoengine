/*
 * An XML document type.
 * Localname: BoundingBox
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.BoundingBoxDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one BoundingBox(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class BoundingBoxDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.BoundingBoxDocument
{
    
    public BoundingBoxDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BOUNDINGBOX$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "BoundingBox");
    private static final org.apache.xmlbeans.QNameSet BOUNDINGBOX$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "WGS84BoundingBox"),
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "BoundingBox"),
    });
    
    
    /**
     * Gets the "BoundingBox" element
     */
    public net.opengeospatial.ows.BoundingBoxType getBoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "BoundingBox" element
     */
    public void setBoundingBox(net.opengeospatial.ows.BoundingBoxType boundingBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$1, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.BoundingBoxType)get_store().add_element_user(BOUNDINGBOX$0);
            }
            target.set(boundingBox);
        }
    }
    
    /**
     * Appends and returns a new empty "BoundingBox" element
     */
    public net.opengeospatial.ows.BoundingBoxType addNewBoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().add_element_user(BOUNDINGBOX$0);
            return target;
        }
    }
}

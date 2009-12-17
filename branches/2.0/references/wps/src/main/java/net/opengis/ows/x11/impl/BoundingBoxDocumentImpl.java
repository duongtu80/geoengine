/*
 * An XML document type.
 * Localname: BoundingBox
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.BoundingBoxDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one BoundingBox(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class BoundingBoxDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.BoundingBoxDocument
{
    private static final long serialVersionUID = 1L;
    
    public BoundingBoxDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BOUNDINGBOX$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "BoundingBox");
    private static final org.apache.xmlbeans.QNameSet BOUNDINGBOX$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "WGS84BoundingBox"),
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "BoundingBox"),
    });
    
    
    /**
     * Gets the "BoundingBox" element
     */
    public net.opengis.ows.x11.BoundingBoxType getBoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$1, 0);
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
    public void setBoundingBox(net.opengis.ows.x11.BoundingBoxType boundingBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$1, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.BoundingBoxType)get_store().add_element_user(BOUNDINGBOX$0);
            }
            target.set(boundingBox);
        }
    }
    
    /**
     * Appends and returns a new empty "BoundingBox" element
     */
    public net.opengis.ows.x11.BoundingBoxType addNewBoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().add_element_user(BOUNDINGBOX$0);
            return target;
        }
    }
}

/*
 * An XML document type.
 * Localname: GetResourceByID
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.GetResourceByIDDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one GetResourceByID(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class GetResourceByIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.GetResourceByIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public GetResourceByIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETRESOURCEBYID$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "GetResourceByID");
    
    
    /**
     * Gets the "GetResourceByID" element
     */
    public net.opengis.ows.x11.GetResourceByIdType getGetResourceByID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.GetResourceByIdType target = null;
            target = (net.opengis.ows.x11.GetResourceByIdType)get_store().find_element_user(GETRESOURCEBYID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "GetResourceByID" element
     */
    public void setGetResourceByID(net.opengis.ows.x11.GetResourceByIdType getResourceByID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.GetResourceByIdType target = null;
            target = (net.opengis.ows.x11.GetResourceByIdType)get_store().find_element_user(GETRESOURCEBYID$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.GetResourceByIdType)get_store().add_element_user(GETRESOURCEBYID$0);
            }
            target.set(getResourceByID);
        }
    }
    
    /**
     * Appends and returns a new empty "GetResourceByID" element
     */
    public net.opengis.ows.x11.GetResourceByIdType addNewGetResourceByID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.GetResourceByIdType target = null;
            target = (net.opengis.ows.x11.GetResourceByIdType)get_store().add_element_user(GETRESOURCEBYID$0);
            return target;
        }
    }
}

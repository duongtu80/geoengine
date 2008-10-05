/*
 * An XML document type.
 * Localname: Reference
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ReferenceDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Reference(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ReferenceDocumentImpl extends net.opengis.ows.x11.impl.AbstractReferenceBaseDocumentImpl implements net.opengis.ows.x11.ReferenceDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Reference");
    private static final org.apache.xmlbeans.QNameSet REFERENCE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Reference"),
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ServiceReference"),
    });
    
    
    /**
     * Gets the "Reference" element
     */
    public net.opengis.ows.x11.ReferenceType getReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceType target = null;
            target = (net.opengis.ows.x11.ReferenceType)get_store().find_element_user(REFERENCE$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Reference" element
     */
    public void setReference(net.opengis.ows.x11.ReferenceType reference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceType target = null;
            target = (net.opengis.ows.x11.ReferenceType)get_store().find_element_user(REFERENCE$1, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ReferenceType)get_store().add_element_user(REFERENCE$0);
            }
            target.set(reference);
        }
    }
    
    /**
     * Appends and returns a new empty "Reference" element
     */
    public net.opengis.ows.x11.ReferenceType addNewReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceType target = null;
            target = (net.opengis.ows.x11.ReferenceType)get_store().add_element_user(REFERENCE$0);
            return target;
        }
    }
}

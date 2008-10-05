/*
 * An XML document type.
 * Localname: ReferenceGroup
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ReferenceGroupDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one ReferenceGroup(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ReferenceGroupDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ReferenceGroupDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceGroupDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEGROUP$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ReferenceGroup");
    
    
    /**
     * Gets the "ReferenceGroup" element
     */
    public net.opengis.ows.x11.ReferenceGroupType getReferenceGroup()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceGroupType target = null;
            target = (net.opengis.ows.x11.ReferenceGroupType)get_store().find_element_user(REFERENCEGROUP$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceGroup" element
     */
    public void setReferenceGroup(net.opengis.ows.x11.ReferenceGroupType referenceGroup)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceGroupType target = null;
            target = (net.opengis.ows.x11.ReferenceGroupType)get_store().find_element_user(REFERENCEGROUP$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ReferenceGroupType)get_store().add_element_user(REFERENCEGROUP$0);
            }
            target.set(referenceGroup);
        }
    }
    
    /**
     * Appends and returns a new empty "ReferenceGroup" element
     */
    public net.opengis.ows.x11.ReferenceGroupType addNewReferenceGroup()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceGroupType target = null;
            target = (net.opengis.ows.x11.ReferenceGroupType)get_store().add_element_user(REFERENCEGROUP$0);
            return target;
        }
    }
}

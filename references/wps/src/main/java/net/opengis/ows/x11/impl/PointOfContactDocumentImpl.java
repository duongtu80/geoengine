/*
 * An XML document type.
 * Localname: PointOfContact
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.PointOfContactDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one PointOfContact(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class PointOfContactDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.PointOfContactDocument
{
    private static final long serialVersionUID = 1L;
    
    public PointOfContactDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POINTOFCONTACT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "PointOfContact");
    
    
    /**
     * Gets the "PointOfContact" element
     */
    public net.opengis.ows.x11.ResponsiblePartyType getPointOfContact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ResponsiblePartyType target = null;
            target = (net.opengis.ows.x11.ResponsiblePartyType)get_store().find_element_user(POINTOFCONTACT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "PointOfContact" element
     */
    public void setPointOfContact(net.opengis.ows.x11.ResponsiblePartyType pointOfContact)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ResponsiblePartyType target = null;
            target = (net.opengis.ows.x11.ResponsiblePartyType)get_store().find_element_user(POINTOFCONTACT$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ResponsiblePartyType)get_store().add_element_user(POINTOFCONTACT$0);
            }
            target.set(pointOfContact);
        }
    }
    
    /**
     * Appends and returns a new empty "PointOfContact" element
     */
    public net.opengis.ows.x11.ResponsiblePartyType addNewPointOfContact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ResponsiblePartyType target = null;
            target = (net.opengis.ows.x11.ResponsiblePartyType)get_store().add_element_user(POINTOFCONTACT$0);
            return target;
        }
    }
}

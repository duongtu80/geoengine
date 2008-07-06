/*
 * An XML document type.
 * Localname: PointOfContact
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.PointOfContactDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one PointOfContact(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class PointOfContactDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.PointOfContactDocument
{
    
    public PointOfContactDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POINTOFCONTACT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "PointOfContact");
    
    
    /**
     * Gets the "PointOfContact" element
     */
    public net.opengeospatial.ows.ResponsiblePartyType getPointOfContact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ResponsiblePartyType target = null;
            target = (net.opengeospatial.ows.ResponsiblePartyType)get_store().find_element_user(POINTOFCONTACT$0, 0);
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
    public void setPointOfContact(net.opengeospatial.ows.ResponsiblePartyType pointOfContact)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ResponsiblePartyType target = null;
            target = (net.opengeospatial.ows.ResponsiblePartyType)get_store().find_element_user(POINTOFCONTACT$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ResponsiblePartyType)get_store().add_element_user(POINTOFCONTACT$0);
            }
            target.set(pointOfContact);
        }
    }
    
    /**
     * Appends and returns a new empty "PointOfContact" element
     */
    public net.opengeospatial.ows.ResponsiblePartyType addNewPointOfContact()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ResponsiblePartyType target = null;
            target = (net.opengeospatial.ows.ResponsiblePartyType)get_store().add_element_user(POINTOFCONTACT$0);
            return target;
        }
    }
}

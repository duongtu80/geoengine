/*
 * An XML document type.
 * Localname: ContactInfo
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ContactInfoDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one ContactInfo(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class ContactInfoDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ContactInfoDocument
{
    
    public ContactInfoDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTINFO$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ContactInfo");
    
    
    /**
     * Gets the "ContactInfo" element
     */
    public net.opengeospatial.ows.ContactType getContactInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ContactType target = null;
            target = (net.opengeospatial.ows.ContactType)get_store().find_element_user(CONTACTINFO$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ContactInfo" element
     */
    public void setContactInfo(net.opengeospatial.ows.ContactType contactInfo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ContactType target = null;
            target = (net.opengeospatial.ows.ContactType)get_store().find_element_user(CONTACTINFO$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ContactType)get_store().add_element_user(CONTACTINFO$0);
            }
            target.set(contactInfo);
        }
    }
    
    /**
     * Appends and returns a new empty "ContactInfo" element
     */
    public net.opengeospatial.ows.ContactType addNewContactInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ContactType target = null;
            target = (net.opengeospatial.ows.ContactType)get_store().add_element_user(CONTACTINFO$0);
            return target;
        }
    }
}

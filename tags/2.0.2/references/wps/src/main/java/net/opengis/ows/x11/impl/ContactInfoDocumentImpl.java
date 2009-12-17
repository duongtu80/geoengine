/*
 * An XML document type.
 * Localname: ContactInfo
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ContactInfoDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one ContactInfo(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ContactInfoDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ContactInfoDocument
{
    private static final long serialVersionUID = 1L;
    
    public ContactInfoDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONTACTINFO$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ContactInfo");
    
    
    /**
     * Gets the "ContactInfo" element
     */
    public net.opengis.ows.x11.ContactType getContactInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ContactType target = null;
            target = (net.opengis.ows.x11.ContactType)get_store().find_element_user(CONTACTINFO$0, 0);
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
    public void setContactInfo(net.opengis.ows.x11.ContactType contactInfo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ContactType target = null;
            target = (net.opengis.ows.x11.ContactType)get_store().find_element_user(CONTACTINFO$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ContactType)get_store().add_element_user(CONTACTINFO$0);
            }
            target.set(contactInfo);
        }
    }
    
    /**
     * Appends and returns a new empty "ContactInfo" element
     */
    public net.opengis.ows.x11.ContactType addNewContactInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ContactType target = null;
            target = (net.opengis.ows.x11.ContactType)get_store().add_element_user(CONTACTINFO$0);
            return target;
        }
    }
}

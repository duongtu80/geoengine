/*
 * XML Type:  ContactType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ContactType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML ContactType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class ContactTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ContactType
{
    
    public ContactTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PHONE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Phone");
    private static final javax.xml.namespace.QName ADDRESS$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Address");
    private static final javax.xml.namespace.QName ONLINERESOURCE$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "OnlineResource");
    private static final javax.xml.namespace.QName HOURSOFSERVICE$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "HoursOfService");
    private static final javax.xml.namespace.QName CONTACTINSTRUCTIONS$8 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ContactInstructions");
    
    
    /**
     * Gets the "Phone" element
     */
    public net.opengeospatial.ows.TelephoneType getPhone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.TelephoneType target = null;
            target = (net.opengeospatial.ows.TelephoneType)get_store().find_element_user(PHONE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Phone" element
     */
    public boolean isSetPhone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PHONE$0) != 0;
        }
    }
    
    /**
     * Sets the "Phone" element
     */
    public void setPhone(net.opengeospatial.ows.TelephoneType phone)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.TelephoneType target = null;
            target = (net.opengeospatial.ows.TelephoneType)get_store().find_element_user(PHONE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.TelephoneType)get_store().add_element_user(PHONE$0);
            }
            target.set(phone);
        }
    }
    
    /**
     * Appends and returns a new empty "Phone" element
     */
    public net.opengeospatial.ows.TelephoneType addNewPhone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.TelephoneType target = null;
            target = (net.opengeospatial.ows.TelephoneType)get_store().add_element_user(PHONE$0);
            return target;
        }
    }
    
    /**
     * Unsets the "Phone" element
     */
    public void unsetPhone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PHONE$0, 0);
        }
    }
    
    /**
     * Gets the "Address" element
     */
    public net.opengeospatial.ows.AddressType getAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AddressType target = null;
            target = (net.opengeospatial.ows.AddressType)get_store().find_element_user(ADDRESS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Address" element
     */
    public boolean isSetAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ADDRESS$2) != 0;
        }
    }
    
    /**
     * Sets the "Address" element
     */
    public void setAddress(net.opengeospatial.ows.AddressType address)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AddressType target = null;
            target = (net.opengeospatial.ows.AddressType)get_store().find_element_user(ADDRESS$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.AddressType)get_store().add_element_user(ADDRESS$2);
            }
            target.set(address);
        }
    }
    
    /**
     * Appends and returns a new empty "Address" element
     */
    public net.opengeospatial.ows.AddressType addNewAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AddressType target = null;
            target = (net.opengeospatial.ows.AddressType)get_store().add_element_user(ADDRESS$2);
            return target;
        }
    }
    
    /**
     * Unsets the "Address" element
     */
    public void unsetAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ADDRESS$2, 0);
        }
    }
    
    /**
     * Gets the "OnlineResource" element
     */
    public net.opengeospatial.ows.OnlineResourceType getOnlineResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.OnlineResourceType target = null;
            target = (net.opengeospatial.ows.OnlineResourceType)get_store().find_element_user(ONLINERESOURCE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "OnlineResource" element
     */
    public boolean isSetOnlineResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ONLINERESOURCE$4) != 0;
        }
    }
    
    /**
     * Sets the "OnlineResource" element
     */
    public void setOnlineResource(net.opengeospatial.ows.OnlineResourceType onlineResource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.OnlineResourceType target = null;
            target = (net.opengeospatial.ows.OnlineResourceType)get_store().find_element_user(ONLINERESOURCE$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.OnlineResourceType)get_store().add_element_user(ONLINERESOURCE$4);
            }
            target.set(onlineResource);
        }
    }
    
    /**
     * Appends and returns a new empty "OnlineResource" element
     */
    public net.opengeospatial.ows.OnlineResourceType addNewOnlineResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.OnlineResourceType target = null;
            target = (net.opengeospatial.ows.OnlineResourceType)get_store().add_element_user(ONLINERESOURCE$4);
            return target;
        }
    }
    
    /**
     * Unsets the "OnlineResource" element
     */
    public void unsetOnlineResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ONLINERESOURCE$4, 0);
        }
    }
    
    /**
     * Gets the "HoursOfService" element
     */
    public java.lang.String getHoursOfService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HOURSOFSERVICE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "HoursOfService" element
     */
    public org.apache.xmlbeans.XmlString xgetHoursOfService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HOURSOFSERVICE$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "HoursOfService" element
     */
    public boolean isSetHoursOfService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(HOURSOFSERVICE$6) != 0;
        }
    }
    
    /**
     * Sets the "HoursOfService" element
     */
    public void setHoursOfService(java.lang.String hoursOfService)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(HOURSOFSERVICE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(HOURSOFSERVICE$6);
            }
            target.setStringValue(hoursOfService);
        }
    }
    
    /**
     * Sets (as xml) the "HoursOfService" element
     */
    public void xsetHoursOfService(org.apache.xmlbeans.XmlString hoursOfService)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(HOURSOFSERVICE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(HOURSOFSERVICE$6);
            }
            target.set(hoursOfService);
        }
    }
    
    /**
     * Unsets the "HoursOfService" element
     */
    public void unsetHoursOfService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(HOURSOFSERVICE$6, 0);
        }
    }
    
    /**
     * Gets the "ContactInstructions" element
     */
    public java.lang.String getContactInstructions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTINSTRUCTIONS$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ContactInstructions" element
     */
    public org.apache.xmlbeans.XmlString xgetContactInstructions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONTACTINSTRUCTIONS$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "ContactInstructions" element
     */
    public boolean isSetContactInstructions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTINSTRUCTIONS$8) != 0;
        }
    }
    
    /**
     * Sets the "ContactInstructions" element
     */
    public void setContactInstructions(java.lang.String contactInstructions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CONTACTINSTRUCTIONS$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CONTACTINSTRUCTIONS$8);
            }
            target.setStringValue(contactInstructions);
        }
    }
    
    /**
     * Sets (as xml) the "ContactInstructions" element
     */
    public void xsetContactInstructions(org.apache.xmlbeans.XmlString contactInstructions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CONTACTINSTRUCTIONS$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CONTACTINSTRUCTIONS$8);
            }
            target.set(contactInstructions);
        }
    }
    
    /**
     * Unsets the "ContactInstructions" element
     */
    public void unsetContactInstructions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTINSTRUCTIONS$8, 0);
        }
    }
}

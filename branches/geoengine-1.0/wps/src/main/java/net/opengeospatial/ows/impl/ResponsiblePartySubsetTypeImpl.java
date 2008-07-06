/*
 * XML Type:  ResponsiblePartySubsetType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ResponsiblePartySubsetType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML ResponsiblePartySubsetType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class ResponsiblePartySubsetTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ResponsiblePartySubsetType
{
    
    public ResponsiblePartySubsetTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INDIVIDUALNAME$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "IndividualName");
    private static final javax.xml.namespace.QName POSITIONNAME$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "PositionName");
    private static final javax.xml.namespace.QName CONTACTINFO$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ContactInfo");
    private static final javax.xml.namespace.QName ROLE$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Role");
    
    
    /**
     * Gets the "IndividualName" element
     */
    public java.lang.String getIndividualName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIVIDUALNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IndividualName" element
     */
    public org.apache.xmlbeans.XmlString xgetIndividualName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIVIDUALNAME$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "IndividualName" element
     */
    public boolean isSetIndividualName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INDIVIDUALNAME$0) != 0;
        }
    }
    
    /**
     * Sets the "IndividualName" element
     */
    public void setIndividualName(java.lang.String individualName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIVIDUALNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDIVIDUALNAME$0);
            }
            target.setStringValue(individualName);
        }
    }
    
    /**
     * Sets (as xml) the "IndividualName" element
     */
    public void xsetIndividualName(org.apache.xmlbeans.XmlString individualName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIVIDUALNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDIVIDUALNAME$0);
            }
            target.set(individualName);
        }
    }
    
    /**
     * Unsets the "IndividualName" element
     */
    public void unsetIndividualName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INDIVIDUALNAME$0, 0);
        }
    }
    
    /**
     * Gets the "PositionName" element
     */
    public java.lang.String getPositionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PositionName" element
     */
    public org.apache.xmlbeans.XmlString xgetPositionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSITIONNAME$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "PositionName" element
     */
    public boolean isSetPositionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(POSITIONNAME$2) != 0;
        }
    }
    
    /**
     * Sets the "PositionName" element
     */
    public void setPositionName(java.lang.String positionName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSITIONNAME$2);
            }
            target.setStringValue(positionName);
        }
    }
    
    /**
     * Sets (as xml) the "PositionName" element
     */
    public void xsetPositionName(org.apache.xmlbeans.XmlString positionName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSITIONNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSITIONNAME$2);
            }
            target.set(positionName);
        }
    }
    
    /**
     * Unsets the "PositionName" element
     */
    public void unsetPositionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(POSITIONNAME$2, 0);
        }
    }
    
    /**
     * Gets the "ContactInfo" element
     */
    public net.opengeospatial.ows.ContactType getContactInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ContactType target = null;
            target = (net.opengeospatial.ows.ContactType)get_store().find_element_user(CONTACTINFO$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ContactInfo" element
     */
    public boolean isSetContactInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONTACTINFO$4) != 0;
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
            target = (net.opengeospatial.ows.ContactType)get_store().find_element_user(CONTACTINFO$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ContactType)get_store().add_element_user(CONTACTINFO$4);
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
            target = (net.opengeospatial.ows.ContactType)get_store().add_element_user(CONTACTINFO$4);
            return target;
        }
    }
    
    /**
     * Unsets the "ContactInfo" element
     */
    public void unsetContactInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONTACTINFO$4, 0);
        }
    }
    
    /**
     * Gets the "Role" element
     */
    public net.opengeospatial.ows.CodeType getRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.CodeType target = null;
            target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(ROLE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Role" element
     */
    public boolean isSetRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ROLE$6) != 0;
        }
    }
    
    /**
     * Sets the "Role" element
     */
    public void setRole(net.opengeospatial.ows.CodeType role)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.CodeType target = null;
            target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(ROLE$6, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(ROLE$6);
            }
            target.set(role);
        }
    }
    
    /**
     * Appends and returns a new empty "Role" element
     */
    public net.opengeospatial.ows.CodeType addNewRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.CodeType target = null;
            target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(ROLE$6);
            return target;
        }
    }
    
    /**
     * Unsets the "Role" element
     */
    public void unsetRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ROLE$6, 0);
        }
    }
}

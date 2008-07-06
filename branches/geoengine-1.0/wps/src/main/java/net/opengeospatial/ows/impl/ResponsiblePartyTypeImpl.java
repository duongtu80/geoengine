/*
 * XML Type:  ResponsiblePartyType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ResponsiblePartyType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML ResponsiblePartyType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class ResponsiblePartyTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ResponsiblePartyType
{
    
    public ResponsiblePartyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INDIVIDUALNAME$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "IndividualName");
    private static final javax.xml.namespace.QName ORGANISATIONNAME$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "OrganisationName");
    private static final javax.xml.namespace.QName POSITIONNAME$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "PositionName");
    private static final javax.xml.namespace.QName CONTACTINFO$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ContactInfo");
    private static final javax.xml.namespace.QName ROLE$8 = 
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
     * Gets the "OrganisationName" element
     */
    public java.lang.String getOrganisationName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANISATIONNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "OrganisationName" element
     */
    public org.apache.xmlbeans.XmlString xgetOrganisationName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANISATIONNAME$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "OrganisationName" element
     */
    public boolean isSetOrganisationName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ORGANISATIONNAME$2) != 0;
        }
    }
    
    /**
     * Sets the "OrganisationName" element
     */
    public void setOrganisationName(java.lang.String organisationName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANISATIONNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORGANISATIONNAME$2);
            }
            target.setStringValue(organisationName);
        }
    }
    
    /**
     * Sets (as xml) the "OrganisationName" element
     */
    public void xsetOrganisationName(org.apache.xmlbeans.XmlString organisationName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANISATIONNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORGANISATIONNAME$2);
            }
            target.set(organisationName);
        }
    }
    
    /**
     * Unsets the "OrganisationName" element
     */
    public void unsetOrganisationName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ORGANISATIONNAME$2, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONNAME$4, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSITIONNAME$4, 0);
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
            return get_store().count_elements(POSITIONNAME$4) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSITIONNAME$4);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSITIONNAME$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSITIONNAME$4);
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
            get_store().remove_element(POSITIONNAME$4, 0);
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
            target = (net.opengeospatial.ows.ContactType)get_store().find_element_user(CONTACTINFO$6, 0);
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
            return get_store().count_elements(CONTACTINFO$6) != 0;
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
            target = (net.opengeospatial.ows.ContactType)get_store().find_element_user(CONTACTINFO$6, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ContactType)get_store().add_element_user(CONTACTINFO$6);
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
            target = (net.opengeospatial.ows.ContactType)get_store().add_element_user(CONTACTINFO$6);
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
            get_store().remove_element(CONTACTINFO$6, 0);
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
            target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(ROLE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
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
            target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(ROLE$8, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(ROLE$8);
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
            target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(ROLE$8);
            return target;
        }
    }
}

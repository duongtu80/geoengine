/*
 * An XML document type.
 * Localname: OrganisationName
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.OrganisationNameDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one OrganisationName(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class OrganisationNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.OrganisationNameDocument
{
    
    public OrganisationNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORGANISATIONNAME$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "OrganisationName");
    
    
    /**
     * Gets the "OrganisationName" element
     */
    public java.lang.String getOrganisationName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANISATIONNAME$0, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANISATIONNAME$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANISATIONNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORGANISATIONNAME$0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANISATIONNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORGANISATIONNAME$0);
            }
            target.set(organisationName);
        }
    }
}

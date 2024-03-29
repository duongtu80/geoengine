/*
 * An XML document type.
 * Localname: OrganisationName
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.OrganisationNameDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one OrganisationName(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class OrganisationNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.OrganisationNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public OrganisationNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORGANISATIONNAME$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "OrganisationName");
    
    
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

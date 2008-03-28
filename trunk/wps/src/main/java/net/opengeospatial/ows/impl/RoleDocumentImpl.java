/*
 * An XML document type.
 * Localname: Role
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.RoleDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one Role(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class RoleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.RoleDocument
{
    
    public RoleDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ROLE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Role");
    
    
    /**
     * Gets the "Role" element
     */
    public net.opengeospatial.ows.CodeType getRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.CodeType target = null;
            target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(ROLE$0, 0);
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
            target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(ROLE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(ROLE$0);
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
            target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(ROLE$0);
            return target;
        }
    }
}

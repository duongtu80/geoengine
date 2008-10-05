/*
 * An XML document type.
 * Localname: Role
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.RoleDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Role(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class RoleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.RoleDocument
{
    private static final long serialVersionUID = 1L;
    
    public RoleDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ROLE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Role");
    
    
    /**
     * Gets the "Role" element
     */
    public net.opengis.ows.x11.CodeType getRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(ROLE$0, 0);
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
    public void setRole(net.opengis.ows.x11.CodeType role)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(ROLE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.CodeType)get_store().add_element_user(ROLE$0);
            }
            target.set(role);
        }
    }
    
    /**
     * Appends and returns a new empty "Role" element
     */
    public net.opengis.ows.x11.CodeType addNewRole()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().add_element_user(ROLE$0);
            return target;
        }
    }
}

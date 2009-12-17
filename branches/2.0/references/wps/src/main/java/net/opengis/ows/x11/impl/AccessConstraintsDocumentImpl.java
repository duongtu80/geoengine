/*
 * An XML document type.
 * Localname: AccessConstraints
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AccessConstraintsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one AccessConstraints(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class AccessConstraintsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AccessConstraintsDocument
{
    private static final long serialVersionUID = 1L;
    
    public AccessConstraintsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ACCESSCONSTRAINTS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AccessConstraints");
    
    
    /**
     * Gets the "AccessConstraints" element
     */
    public java.lang.String getAccessConstraints()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACCESSCONSTRAINTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AccessConstraints" element
     */
    public org.apache.xmlbeans.XmlString xgetAccessConstraints()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ACCESSCONSTRAINTS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AccessConstraints" element
     */
    public void setAccessConstraints(java.lang.String accessConstraints)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACCESSCONSTRAINTS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ACCESSCONSTRAINTS$0);
            }
            target.setStringValue(accessConstraints);
        }
    }
    
    /**
     * Sets (as xml) the "AccessConstraints" element
     */
    public void xsetAccessConstraints(org.apache.xmlbeans.XmlString accessConstraints)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ACCESSCONSTRAINTS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ACCESSCONSTRAINTS$0);
            }
            target.set(accessConstraints);
        }
    }
}

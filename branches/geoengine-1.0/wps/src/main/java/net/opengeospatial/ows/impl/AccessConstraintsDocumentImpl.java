/*
 * An XML document type.
 * Localname: AccessConstraints
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.AccessConstraintsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one AccessConstraints(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class AccessConstraintsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.AccessConstraintsDocument
{
    
    public AccessConstraintsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ACCESSCONSTRAINTS$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AccessConstraints");
    
    
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

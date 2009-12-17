/*
 * An XML attribute type.
 * Localname: reference
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ReferenceAttribute
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one reference(@http://www.opengis.net/ows/1.1) attribute.
 *
 * This is a complex type.
 */
public class ReferenceAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ReferenceAttribute
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "reference");
    
    
    /**
     * Gets the "reference" attribute
     */
    public java.lang.String getReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REFERENCE$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "reference" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(REFERENCE$0);
            return target;
        }
    }
    
    /**
     * True if has "reference" attribute
     */
    public boolean isSetReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(REFERENCE$0) != null;
        }
    }
    
    /**
     * Sets the "reference" attribute
     */
    public void setReference(java.lang.String reference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REFERENCE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REFERENCE$0);
            }
            target.setStringValue(reference);
        }
    }
    
    /**
     * Sets (as xml) the "reference" attribute
     */
    public void xsetReference(org.apache.xmlbeans.XmlAnyURI reference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(REFERENCE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(REFERENCE$0);
            }
            target.set(reference);
        }
    }
    
    /**
     * Unsets the "reference" attribute
     */
    public void unsetReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(REFERENCE$0);
        }
    }
}

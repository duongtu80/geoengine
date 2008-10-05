/*
 * XML Type:  ValuesReferenceType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ValuesReferenceType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ValuesReferenceType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class ValuesReferenceTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ValuesReferenceType
{
    private static final long serialVersionUID = 1L;
    
    public ValuesReferenceTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "reference");
    private static final javax.xml.namespace.QName VALUESFORM$2 = 
        new javax.xml.namespace.QName("", "valuesForm");
    
    
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
    
    /**
     * Gets the "valuesForm" attribute
     */
    public java.lang.String getValuesForm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUESFORM$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "valuesForm" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetValuesForm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(VALUESFORM$2);
            return target;
        }
    }
    
    /**
     * True if has "valuesForm" attribute
     */
    public boolean isSetValuesForm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(VALUESFORM$2) != null;
        }
    }
    
    /**
     * Sets the "valuesForm" attribute
     */
    public void setValuesForm(java.lang.String valuesForm)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUESFORM$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALUESFORM$2);
            }
            target.setStringValue(valuesForm);
        }
    }
    
    /**
     * Sets (as xml) the "valuesForm" attribute
     */
    public void xsetValuesForm(org.apache.xmlbeans.XmlAnyURI valuesForm)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(VALUESFORM$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(VALUESFORM$2);
            }
            target.set(valuesForm);
        }
    }
    
    /**
     * Unsets the "valuesForm" attribute
     */
    public void unsetValuesForm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(VALUESFORM$2);
        }
    }
}

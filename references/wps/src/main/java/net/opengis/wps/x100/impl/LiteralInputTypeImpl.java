/*
 * XML Type:  LiteralInputType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.LiteralInputType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML LiteralInputType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class LiteralInputTypeImpl extends net.opengis.wps.x100.impl.LiteralOutputTypeImpl implements net.opengis.wps.x100.LiteralInputType
{
    private static final long serialVersionUID = 1L;
    
    public LiteralInputTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ALLOWEDVALUES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AllowedValues");
    private static final javax.xml.namespace.QName ANYVALUE$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AnyValue");
    private static final javax.xml.namespace.QName VALUESREFERENCE$4 = 
        new javax.xml.namespace.QName("", "ValuesReference");
    private static final javax.xml.namespace.QName DEFAULTVALUE$6 = 
        new javax.xml.namespace.QName("", "DefaultValue");
    
    
    /**
     * Gets the "AllowedValues" element
     */
    public net.opengis.ows.x11.AllowedValuesDocument.AllowedValues getAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues)get_store().find_element_user(ALLOWEDVALUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AllowedValues" element
     */
    public boolean isSetAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ALLOWEDVALUES$0) != 0;
        }
    }
    
    /**
     * Sets the "AllowedValues" element
     */
    public void setAllowedValues(net.opengis.ows.x11.AllowedValuesDocument.AllowedValues allowedValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues)get_store().find_element_user(ALLOWEDVALUES$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues)get_store().add_element_user(ALLOWEDVALUES$0);
            }
            target.set(allowedValues);
        }
    }
    
    /**
     * Appends and returns a new empty "AllowedValues" element
     */
    public net.opengis.ows.x11.AllowedValuesDocument.AllowedValues addNewAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues)get_store().add_element_user(ALLOWEDVALUES$0);
            return target;
        }
    }
    
    /**
     * Unsets the "AllowedValues" element
     */
    public void unsetAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ALLOWEDVALUES$0, 0);
        }
    }
    
    /**
     * Gets the "AnyValue" element
     */
    public net.opengis.ows.x11.AnyValueDocument.AnyValue getAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AnyValueDocument.AnyValue target = null;
            target = (net.opengis.ows.x11.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AnyValue" element
     */
    public boolean isSetAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANYVALUE$2) != 0;
        }
    }
    
    /**
     * Sets the "AnyValue" element
     */
    public void setAnyValue(net.opengis.ows.x11.AnyValueDocument.AnyValue anyValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AnyValueDocument.AnyValue target = null;
            target = (net.opengis.ows.x11.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$2, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$2);
            }
            target.set(anyValue);
        }
    }
    
    /**
     * Appends and returns a new empty "AnyValue" element
     */
    public net.opengis.ows.x11.AnyValueDocument.AnyValue addNewAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AnyValueDocument.AnyValue target = null;
            target = (net.opengis.ows.x11.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$2);
            return target;
        }
    }
    
    /**
     * Unsets the "AnyValue" element
     */
    public void unsetAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANYVALUE$2, 0);
        }
    }
    
    /**
     * Gets the "ValuesReference" element
     */
    public net.opengis.wps.x100.ValuesReferenceType getValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ValuesReferenceType target = null;
            target = (net.opengis.wps.x100.ValuesReferenceType)get_store().find_element_user(VALUESREFERENCE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ValuesReference" element
     */
    public boolean isSetValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VALUESREFERENCE$4) != 0;
        }
    }
    
    /**
     * Sets the "ValuesReference" element
     */
    public void setValuesReference(net.opengis.wps.x100.ValuesReferenceType valuesReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ValuesReferenceType target = null;
            target = (net.opengis.wps.x100.ValuesReferenceType)get_store().find_element_user(VALUESREFERENCE$4, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ValuesReferenceType)get_store().add_element_user(VALUESREFERENCE$4);
            }
            target.set(valuesReference);
        }
    }
    
    /**
     * Appends and returns a new empty "ValuesReference" element
     */
    public net.opengis.wps.x100.ValuesReferenceType addNewValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ValuesReferenceType target = null;
            target = (net.opengis.wps.x100.ValuesReferenceType)get_store().add_element_user(VALUESREFERENCE$4);
            return target;
        }
    }
    
    /**
     * Unsets the "ValuesReference" element
     */
    public void unsetValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VALUESREFERENCE$4, 0);
        }
    }
    
    /**
     * Gets the "DefaultValue" element
     */
    public java.lang.String getDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEFAULTVALUE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DefaultValue" element
     */
    public org.apache.xmlbeans.XmlString xgetDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEFAULTVALUE$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "DefaultValue" element
     */
    public boolean isSetDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DEFAULTVALUE$6) != 0;
        }
    }
    
    /**
     * Sets the "DefaultValue" element
     */
    public void setDefaultValue(java.lang.String defaultValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DEFAULTVALUE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DEFAULTVALUE$6);
            }
            target.setStringValue(defaultValue);
        }
    }
    
    /**
     * Sets (as xml) the "DefaultValue" element
     */
    public void xsetDefaultValue(org.apache.xmlbeans.XmlString defaultValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DEFAULTVALUE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DEFAULTVALUE$6);
            }
            target.set(defaultValue);
        }
    }
    
    /**
     * Unsets the "DefaultValue" element
     */
    public void unsetDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DEFAULTVALUE$6, 0);
        }
    }
}

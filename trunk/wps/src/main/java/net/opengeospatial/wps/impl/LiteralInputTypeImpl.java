/*
 * XML Type:  LiteralInputType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.LiteralInputType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML LiteralInputType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class LiteralInputTypeImpl extends net.opengeospatial.wps.impl.LiteralOutputTypeImpl implements net.opengeospatial.wps.LiteralInputType
{
    
    public LiteralInputTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ALLOWEDVALUES$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AllowedValues");
    private static final javax.xml.namespace.QName ANYVALUE$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AnyValue");
    private static final javax.xml.namespace.QName VALUESREFERENCE$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ValuesReference");
    private static final javax.xml.namespace.QName DEFAULTVALUE$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "DefaultValue");
    
    
    /**
     * Gets the "AllowedValues" element
     */
    public net.opengeospatial.ows.AllowedValuesDocument.AllowedValues getAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengeospatial.ows.AllowedValuesDocument.AllowedValues)get_store().find_element_user(ALLOWEDVALUES$0, 0);
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
    public void setAllowedValues(net.opengeospatial.ows.AllowedValuesDocument.AllowedValues allowedValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengeospatial.ows.AllowedValuesDocument.AllowedValues)get_store().find_element_user(ALLOWEDVALUES$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.AllowedValuesDocument.AllowedValues)get_store().add_element_user(ALLOWEDVALUES$0);
            }
            target.set(allowedValues);
        }
    }
    
    /**
     * Appends and returns a new empty "AllowedValues" element
     */
    public net.opengeospatial.ows.AllowedValuesDocument.AllowedValues addNewAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengeospatial.ows.AllowedValuesDocument.AllowedValues)get_store().add_element_user(ALLOWEDVALUES$0);
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
    public net.opengeospatial.ows.AnyValueDocument.AnyValue getAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$2, 0);
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
    public void setAnyValue(net.opengeospatial.ows.AnyValueDocument.AnyValue anyValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$2);
            }
            target.set(anyValue);
        }
    }
    
    /**
     * Appends and returns a new empty "AnyValue" element
     */
    public net.opengeospatial.ows.AnyValueDocument.AnyValue addNewAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$2);
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
    public net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference getValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().find_element_user(VALUESREFERENCE$4, 0);
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
    public void setValuesReference(net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference valuesReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().find_element_user(VALUESREFERENCE$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().add_element_user(VALUESREFERENCE$4);
            }
            target.set(valuesReference);
        }
    }
    
    /**
     * Appends and returns a new empty "ValuesReference" element
     */
    public net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference addNewValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().add_element_user(VALUESREFERENCE$4);
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
    public net.opengeospatial.ows.RangeType getDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(DEFAULTVALUE$6, 0);
            if (target == null)
            {
                return null;
            }
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
    public void setDefaultValue(net.opengeospatial.ows.RangeType defaultValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(DEFAULTVALUE$6, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(DEFAULTVALUE$6);
            }
            target.set(defaultValue);
        }
    }
    
    /**
     * Appends and returns a new empty "DefaultValue" element
     */
    public net.opengeospatial.ows.RangeType addNewDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(DEFAULTVALUE$6);
            return target;
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

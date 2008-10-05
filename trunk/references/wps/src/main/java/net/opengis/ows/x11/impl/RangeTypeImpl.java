/*
 * XML Type:  RangeType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.RangeType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML RangeType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class RangeTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.RangeType
{
    private static final long serialVersionUID = 1L;
    
    public RangeTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MINIMUMVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "MinimumValue");
    private static final javax.xml.namespace.QName MAXIMUMVALUE$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "MaximumValue");
    private static final javax.xml.namespace.QName SPACING$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Spacing");
    private static final javax.xml.namespace.QName RANGECLOSURE$6 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "rangeClosure");
    
    
    /**
     * Gets the "MinimumValue" element
     */
    public net.opengis.ows.x11.ValueType getMinimumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(MINIMUMVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "MinimumValue" element
     */
    public boolean isSetMinimumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MINIMUMVALUE$0) != 0;
        }
    }
    
    /**
     * Sets the "MinimumValue" element
     */
    public void setMinimumValue(net.opengis.ows.x11.ValueType minimumValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(MINIMUMVALUE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(MINIMUMVALUE$0);
            }
            target.set(minimumValue);
        }
    }
    
    /**
     * Appends and returns a new empty "MinimumValue" element
     */
    public net.opengis.ows.x11.ValueType addNewMinimumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(MINIMUMVALUE$0);
            return target;
        }
    }
    
    /**
     * Unsets the "MinimumValue" element
     */
    public void unsetMinimumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MINIMUMVALUE$0, 0);
        }
    }
    
    /**
     * Gets the "MaximumValue" element
     */
    public net.opengis.ows.x11.ValueType getMaximumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(MAXIMUMVALUE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "MaximumValue" element
     */
    public boolean isSetMaximumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MAXIMUMVALUE$2) != 0;
        }
    }
    
    /**
     * Sets the "MaximumValue" element
     */
    public void setMaximumValue(net.opengis.ows.x11.ValueType maximumValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(MAXIMUMVALUE$2, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(MAXIMUMVALUE$2);
            }
            target.set(maximumValue);
        }
    }
    
    /**
     * Appends and returns a new empty "MaximumValue" element
     */
    public net.opengis.ows.x11.ValueType addNewMaximumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(MAXIMUMVALUE$2);
            return target;
        }
    }
    
    /**
     * Unsets the "MaximumValue" element
     */
    public void unsetMaximumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MAXIMUMVALUE$2, 0);
        }
    }
    
    /**
     * Gets the "Spacing" element
     */
    public net.opengis.ows.x11.ValueType getSpacing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(SPACING$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Spacing" element
     */
    public boolean isSetSpacing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SPACING$4) != 0;
        }
    }
    
    /**
     * Sets the "Spacing" element
     */
    public void setSpacing(net.opengis.ows.x11.ValueType spacing)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(SPACING$4, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(SPACING$4);
            }
            target.set(spacing);
        }
    }
    
    /**
     * Appends and returns a new empty "Spacing" element
     */
    public net.opengis.ows.x11.ValueType addNewSpacing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(SPACING$4);
            return target;
        }
    }
    
    /**
     * Unsets the "Spacing" element
     */
    public void unsetSpacing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SPACING$4, 0);
        }
    }
    
    /**
     * Gets the "rangeClosure" attribute
     */
    public java.util.List getRangeClosure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RANGECLOSURE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(RANGECLOSURE$6);
            }
            if (target == null)
            {
                return null;
            }
            return target.getListValue();
        }
    }
    
    /**
     * Gets (as xml) the "rangeClosure" attribute
     */
    public net.opengis.ows.x11.RangeClosureAttribute.RangeClosure xgetRangeClosure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.RangeClosureAttribute.RangeClosure target = null;
            target = (net.opengis.ows.x11.RangeClosureAttribute.RangeClosure)get_store().find_attribute_user(RANGECLOSURE$6);
            if (target == null)
            {
                target = (net.opengis.ows.x11.RangeClosureAttribute.RangeClosure)get_default_attribute_value(RANGECLOSURE$6);
            }
            return target;
        }
    }
    
    /**
     * True if has "rangeClosure" attribute
     */
    public boolean isSetRangeClosure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(RANGECLOSURE$6) != null;
        }
    }
    
    /**
     * Sets the "rangeClosure" attribute
     */
    public void setRangeClosure(java.util.List rangeClosure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RANGECLOSURE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RANGECLOSURE$6);
            }
            target.setListValue(rangeClosure);
        }
    }
    
    /**
     * Sets (as xml) the "rangeClosure" attribute
     */
    public void xsetRangeClosure(net.opengis.ows.x11.RangeClosureAttribute.RangeClosure rangeClosure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.RangeClosureAttribute.RangeClosure target = null;
            target = (net.opengis.ows.x11.RangeClosureAttribute.RangeClosure)get_store().find_attribute_user(RANGECLOSURE$6);
            if (target == null)
            {
                target = (net.opengis.ows.x11.RangeClosureAttribute.RangeClosure)get_store().add_attribute_user(RANGECLOSURE$6);
            }
            target.set(rangeClosure);
        }
    }
    
    /**
     * Unsets the "rangeClosure" attribute
     */
    public void unsetRangeClosure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(RANGECLOSURE$6);
        }
    }
}

/*
 * An XML attribute type.
 * Localname: rangeClosure
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.RangeClosureAttribute
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one rangeClosure(@http://www.opengis.net/ows/1.1) attribute.
 *
 * This is a complex type.
 */
public class RangeClosureAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.RangeClosureAttribute
{
    private static final long serialVersionUID = 1L;
    
    public RangeClosureAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RANGECLOSURE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "rangeClosure");
    
    
    /**
     * Gets the "rangeClosure" attribute
     */
    public java.util.List getRangeClosure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RANGECLOSURE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(RANGECLOSURE$0);
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
            target = (net.opengis.ows.x11.RangeClosureAttribute.RangeClosure)get_store().find_attribute_user(RANGECLOSURE$0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.RangeClosureAttribute.RangeClosure)get_default_attribute_value(RANGECLOSURE$0);
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
            return get_store().find_attribute_user(RANGECLOSURE$0) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RANGECLOSURE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RANGECLOSURE$0);
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
            target = (net.opengis.ows.x11.RangeClosureAttribute.RangeClosure)get_store().find_attribute_user(RANGECLOSURE$0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.RangeClosureAttribute.RangeClosure)get_store().add_attribute_user(RANGECLOSURE$0);
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
            get_store().remove_attribute(RANGECLOSURE$0);
        }
    }
    /**
     * An XML rangeClosure(@http://www.opengis.net/ows/1.1).
     *
     * This is a list type whose items are org.apache.xmlbeans.XmlNMTOKEN.
     */
    public static class RangeClosureImpl extends org.apache.xmlbeans.impl.values.XmlListImpl implements net.opengis.ows.x11.RangeClosureAttribute.RangeClosure
    {
        private static final long serialVersionUID = 1L;
        
        public RangeClosureImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected RangeClosureImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}

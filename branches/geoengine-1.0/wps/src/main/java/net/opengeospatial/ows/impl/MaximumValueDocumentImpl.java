/*
 * An XML document type.
 * Localname: MaximumValue
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.MaximumValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one MaximumValue(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class MaximumValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.MaximumValueDocument
{
    
    public MaximumValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MAXIMUMVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "MaximumValue");
    
    
    /**
     * Gets the "MaximumValue" element
     */
    public net.opengeospatial.ows.ValueType getMaximumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(MAXIMUMVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "MaximumValue" element
     */
    public void setMaximumValue(net.opengeospatial.ows.ValueType maximumValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(MAXIMUMVALUE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(MAXIMUMVALUE$0);
            }
            target.set(maximumValue);
        }
    }
    
    /**
     * Appends and returns a new empty "MaximumValue" element
     */
    public net.opengeospatial.ows.ValueType addNewMaximumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(MAXIMUMVALUE$0);
            return target;
        }
    }
}

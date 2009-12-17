/*
 * An XML document type.
 * Localname: MaximumValue
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.MaximumValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one MaximumValue(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class MaximumValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.MaximumValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public MaximumValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MAXIMUMVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "MaximumValue");
    
    
    /**
     * Gets the "MaximumValue" element
     */
    public net.opengis.ows.x11.ValueType getMaximumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(MAXIMUMVALUE$0, 0);
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
    public void setMaximumValue(net.opengis.ows.x11.ValueType maximumValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(MAXIMUMVALUE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(MAXIMUMVALUE$0);
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
            target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(MAXIMUMVALUE$0);
            return target;
        }
    }
}

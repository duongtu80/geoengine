/*
 * An XML document type.
 * Localname: MinimumValue
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.MinimumValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one MinimumValue(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class MinimumValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.MinimumValueDocument
{
    
    public MinimumValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MINIMUMVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "MinimumValue");
    
    
    /**
     * Gets the "MinimumValue" element
     */
    public net.opengeospatial.ows.ValueType getMinimumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(MINIMUMVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "MinimumValue" element
     */
    public void setMinimumValue(net.opengeospatial.ows.ValueType minimumValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(MINIMUMVALUE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(MINIMUMVALUE$0);
            }
            target.set(minimumValue);
        }
    }
    
    /**
     * Appends and returns a new empty "MinimumValue" element
     */
    public net.opengeospatial.ows.ValueType addNewMinimumValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(MINIMUMVALUE$0);
            return target;
        }
    }
}

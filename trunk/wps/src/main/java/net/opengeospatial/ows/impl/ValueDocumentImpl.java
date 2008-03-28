/*
 * An XML document type.
 * Localname: Value
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one Value(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class ValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ValueDocument
{
    
    public ValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Value");
    
    
    /**
     * Gets the "Value" element
     */
    public net.opengeospatial.ows.ValueType getValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(VALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Value" element
     */
    public void setValue(net.opengeospatial.ows.ValueType value)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(VALUE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(VALUE$0);
            }
            target.set(value);
        }
    }
    
    /**
     * Appends and returns a new empty "Value" element
     */
    public net.opengeospatial.ows.ValueType addNewValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(VALUE$0);
            return target;
        }
    }
}

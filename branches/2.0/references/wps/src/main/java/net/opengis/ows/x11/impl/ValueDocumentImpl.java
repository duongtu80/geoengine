/*
 * An XML document type.
 * Localname: Value
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Value(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public ValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Value");
    
    
    /**
     * Gets the "Value" element
     */
    public net.opengis.ows.x11.ValueType getValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(VALUE$0, 0);
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
    public void setValue(net.opengis.ows.x11.ValueType value)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(VALUE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(VALUE$0);
            }
            target.set(value);
        }
    }
    
    /**
     * Appends and returns a new empty "Value" element
     */
    public net.opengis.ows.x11.ValueType addNewValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(VALUE$0);
            return target;
        }
    }
}

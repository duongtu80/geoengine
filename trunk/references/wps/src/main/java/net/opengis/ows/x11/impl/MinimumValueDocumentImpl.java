/*
 * An XML document type.
 * Localname: MinimumValue
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.MinimumValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one MinimumValue(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class MinimumValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.MinimumValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public MinimumValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MINIMUMVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "MinimumValue");
    
    
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
}

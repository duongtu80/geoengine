/*
 * An XML document type.
 * Localname: DefaultValue
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.DefaultValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one DefaultValue(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class DefaultValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.DefaultValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public DefaultValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEFAULTVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DefaultValue");
    
    
    /**
     * Gets the "DefaultValue" element
     */
    public net.opengis.ows.x11.ValueType getDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(DEFAULTVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DefaultValue" element
     */
    public void setDefaultValue(net.opengis.ows.x11.ValueType defaultValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(DEFAULTVALUE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(DEFAULTVALUE$0);
            }
            target.set(defaultValue);
        }
    }
    
    /**
     * Appends and returns a new empty "DefaultValue" element
     */
    public net.opengis.ows.x11.ValueType addNewDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(DEFAULTVALUE$0);
            return target;
        }
    }
}

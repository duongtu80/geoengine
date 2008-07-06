/*
 * An XML document type.
 * Localname: DefaultValue
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.DefaultValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one DefaultValue(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class DefaultValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.DefaultValueDocument
{
    
    public DefaultValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEFAULTVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "DefaultValue");
    
    
    /**
     * Gets the "DefaultValue" element
     */
    public net.opengeospatial.ows.RangeType getDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(DEFAULTVALUE$0, 0);
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
    public void setDefaultValue(net.opengeospatial.ows.RangeType defaultValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(DEFAULTVALUE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(DEFAULTVALUE$0);
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
            target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(DEFAULTVALUE$0);
            return target;
        }
    }
}

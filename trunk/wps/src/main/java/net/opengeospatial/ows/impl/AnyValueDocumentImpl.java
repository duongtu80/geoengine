/*
 * An XML document type.
 * Localname: AnyValue
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.AnyValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one AnyValue(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class AnyValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.AnyValueDocument
{
    
    public AnyValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANYVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AnyValue");
    
    
    /**
     * Gets the "AnyValue" element
     */
    public net.opengeospatial.ows.AnyValueDocument.AnyValue getAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AnyValue" element
     */
    public void setAnyValue(net.opengeospatial.ows.AnyValueDocument.AnyValue anyValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$0);
            }
            target.set(anyValue);
        }
    }
    
    /**
     * Appends and returns a new empty "AnyValue" element
     */
    public net.opengeospatial.ows.AnyValueDocument.AnyValue addNewAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$0);
            return target;
        }
    }
    /**
     * An XML AnyValue(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public static class AnyValueImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.AnyValueDocument.AnyValue
    {
        
        public AnyValueImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}

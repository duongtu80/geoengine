/*
 * An XML document type.
 * Localname: AnyValue
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AnyValueDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one AnyValue(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class AnyValueDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AnyValueDocument
{
    private static final long serialVersionUID = 1L;
    
    public AnyValueDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANYVALUE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AnyValue");
    
    
    /**
     * Gets the "AnyValue" element
     */
    public net.opengis.ows.x11.AnyValueDocument.AnyValue getAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AnyValueDocument.AnyValue target = null;
            target = (net.opengis.ows.x11.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$0, 0);
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
    public void setAnyValue(net.opengis.ows.x11.AnyValueDocument.AnyValue anyValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AnyValueDocument.AnyValue target = null;
            target = (net.opengis.ows.x11.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$0);
            }
            target.set(anyValue);
        }
    }
    
    /**
     * Appends and returns a new empty "AnyValue" element
     */
    public net.opengis.ows.x11.AnyValueDocument.AnyValue addNewAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AnyValueDocument.AnyValue target = null;
            target = (net.opengis.ows.x11.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$0);
            return target;
        }
    }
    /**
     * An XML AnyValue(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public static class AnyValueImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AnyValueDocument.AnyValue
    {
        private static final long serialVersionUID = 1L;
        
        public AnyValueImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}

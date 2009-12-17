/*
 * An XML document type.
 * Localname: NoValues
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.NoValuesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one NoValues(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class NoValuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.NoValuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public NoValuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NOVALUES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "NoValues");
    
    
    /**
     * Gets the "NoValues" element
     */
    public net.opengis.ows.x11.NoValuesDocument.NoValues getNoValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.NoValuesDocument.NoValues target = null;
            target = (net.opengis.ows.x11.NoValuesDocument.NoValues)get_store().find_element_user(NOVALUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "NoValues" element
     */
    public void setNoValues(net.opengis.ows.x11.NoValuesDocument.NoValues noValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.NoValuesDocument.NoValues target = null;
            target = (net.opengis.ows.x11.NoValuesDocument.NoValues)get_store().find_element_user(NOVALUES$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.NoValuesDocument.NoValues)get_store().add_element_user(NOVALUES$0);
            }
            target.set(noValues);
        }
    }
    
    /**
     * Appends and returns a new empty "NoValues" element
     */
    public net.opengis.ows.x11.NoValuesDocument.NoValues addNewNoValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.NoValuesDocument.NoValues target = null;
            target = (net.opengis.ows.x11.NoValuesDocument.NoValues)get_store().add_element_user(NOVALUES$0);
            return target;
        }
    }
    /**
     * An XML NoValues(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public static class NoValuesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.NoValuesDocument.NoValues
    {
        private static final long serialVersionUID = 1L;
        
        public NoValuesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}

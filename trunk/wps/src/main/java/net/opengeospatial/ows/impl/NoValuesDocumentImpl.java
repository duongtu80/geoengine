/*
 * An XML document type.
 * Localname: NoValues
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.NoValuesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one NoValues(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class NoValuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.NoValuesDocument
{
    
    public NoValuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NOVALUES$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "NoValues");
    
    
    /**
     * Gets the "NoValues" element
     */
    public net.opengeospatial.ows.NoValuesDocument.NoValues getNoValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.NoValuesDocument.NoValues target = null;
            target = (net.opengeospatial.ows.NoValuesDocument.NoValues)get_store().find_element_user(NOVALUES$0, 0);
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
    public void setNoValues(net.opengeospatial.ows.NoValuesDocument.NoValues noValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.NoValuesDocument.NoValues target = null;
            target = (net.opengeospatial.ows.NoValuesDocument.NoValues)get_store().find_element_user(NOVALUES$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.NoValuesDocument.NoValues)get_store().add_element_user(NOVALUES$0);
            }
            target.set(noValues);
        }
    }
    
    /**
     * Appends and returns a new empty "NoValues" element
     */
    public net.opengeospatial.ows.NoValuesDocument.NoValues addNewNoValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.NoValuesDocument.NoValues target = null;
            target = (net.opengeospatial.ows.NoValuesDocument.NoValues)get_store().add_element_user(NOVALUES$0);
            return target;
        }
    }
    /**
     * An XML NoValues(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public static class NoValuesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.NoValuesDocument.NoValues
    {
        
        public NoValuesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        
    }
}

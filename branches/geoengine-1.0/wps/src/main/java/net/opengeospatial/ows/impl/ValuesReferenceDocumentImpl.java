/*
 * An XML document type.
 * Localname: ValuesReference
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ValuesReferenceDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one ValuesReference(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class ValuesReferenceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ValuesReferenceDocument
{
    
    public ValuesReferenceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VALUESREFERENCE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ValuesReference");
    
    
    /**
     * Gets the "ValuesReference" element
     */
    public net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference getValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().find_element_user(VALUESREFERENCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ValuesReference" element
     */
    public void setValuesReference(net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference valuesReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().find_element_user(VALUESREFERENCE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().add_element_user(VALUESREFERENCE$0);
            }
            target.set(valuesReference);
        }
    }
    
    /**
     * Appends and returns a new empty "ValuesReference" element
     */
    public net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference addNewValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().add_element_user(VALUESREFERENCE$0);
            return target;
        }
    }
    /**
     * An XML ValuesReference(@http://www.opengeospatial.net/ows).
     *
     * This is an atomic type that is a restriction of net.opengeospatial.ows.ValuesReferenceDocument$ValuesReference.
     */
    public static class ValuesReferenceImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference
    {
        
        public ValuesReferenceImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, true);
        }
        
        protected ValuesReferenceImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
        
        private static final javax.xml.namespace.QName REFERENCE$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "reference");
        
        
        /**
         * Gets the "reference" attribute
         */
        public java.lang.String getReference()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REFERENCE$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "reference" attribute
         */
        public org.apache.xmlbeans.XmlAnyURI xgetReference()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(REFERENCE$0);
                return target;
            }
        }
        
        /**
         * Sets the "reference" attribute
         */
        public void setReference(java.lang.String reference)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REFERENCE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REFERENCE$0);
                }
                target.setStringValue(reference);
            }
        }
        
        /**
         * Sets (as xml) the "reference" attribute
         */
        public void xsetReference(org.apache.xmlbeans.XmlAnyURI reference)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(REFERENCE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(REFERENCE$0);
                }
                target.set(reference);
            }
        }
    }
}

/*
 * An XML document type.
 * Localname: ValuesReference
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ValuesReferenceDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one ValuesReference(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ValuesReferenceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ValuesReferenceDocument
{
    private static final long serialVersionUID = 1L;
    
    public ValuesReferenceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VALUESREFERENCE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ValuesReference");
    
    
    /**
     * Gets the "ValuesReference" element
     */
    public net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference getValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference)get_store().find_element_user(VALUESREFERENCE$0, 0);
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
    public void setValuesReference(net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference valuesReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference)get_store().find_element_user(VALUESREFERENCE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference)get_store().add_element_user(VALUESREFERENCE$0);
            }
            target.set(valuesReference);
        }
    }
    
    /**
     * Appends and returns a new empty "ValuesReference" element
     */
    public net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference addNewValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference)get_store().add_element_user(VALUESREFERENCE$0);
            return target;
        }
    }
    /**
     * An XML ValuesReference(@http://www.opengis.net/ows/1.1).
     *
     * This is an atomic type that is a restriction of net.opengis.ows.x11.ValuesReferenceDocument$ValuesReference.
     */
    public static class ValuesReferenceImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements net.opengis.ows.x11.ValuesReferenceDocument.ValuesReference
    {
        private static final long serialVersionUID = 1L;
        
        public ValuesReferenceImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, true);
        }
        
        protected ValuesReferenceImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
        
        private static final javax.xml.namespace.QName REFERENCE$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "reference");
        
        
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

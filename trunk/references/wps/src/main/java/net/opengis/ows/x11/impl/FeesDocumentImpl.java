/*
 * An XML document type.
 * Localname: Fees
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.FeesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Fees(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class FeesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.FeesDocument
{
    private static final long serialVersionUID = 1L;
    
    public FeesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FEES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Fees");
    
    
    /**
     * Gets the "Fees" element
     */
    public java.lang.String getFees()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Fees" element
     */
    public org.apache.xmlbeans.XmlString xgetFees()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FEES$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Fees" element
     */
    public void setFees(java.lang.String fees)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FEES$0);
            }
            target.setStringValue(fees);
        }
    }
    
    /**
     * Sets (as xml) the "Fees" element
     */
    public void xsetFees(org.apache.xmlbeans.XmlString fees)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FEES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FEES$0);
            }
            target.set(fees);
        }
    }
}

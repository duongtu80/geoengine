/*
 * An XML document type.
 * Localname: Fees
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.FeesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one Fees(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class FeesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.FeesDocument
{
    
    public FeesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FEES$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Fees");
    
    
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

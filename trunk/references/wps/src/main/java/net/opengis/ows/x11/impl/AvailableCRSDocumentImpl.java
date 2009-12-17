/*
 * An XML document type.
 * Localname: AvailableCRS
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AvailableCRSDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one AvailableCRS(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class AvailableCRSDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AvailableCRSDocument
{
    private static final long serialVersionUID = 1L;
    
    public AvailableCRSDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AVAILABLECRS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AvailableCRS");
    private static final org.apache.xmlbeans.QNameSet AVAILABLECRS$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AvailableCRS"),
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "SupportedCRS"),
    });
    
    
    /**
     * Gets the "AvailableCRS" element
     */
    public java.lang.String getAvailableCRS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABLECRS$1, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AvailableCRS" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetAvailableCRS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(AVAILABLECRS$1, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AvailableCRS" element
     */
    public void setAvailableCRS(java.lang.String availableCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABLECRS$1, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABLECRS$0);
            }
            target.setStringValue(availableCRS);
        }
    }
    
    /**
     * Sets (as xml) the "AvailableCRS" element
     */
    public void xsetAvailableCRS(org.apache.xmlbeans.XmlAnyURI availableCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(AVAILABLECRS$1, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(AVAILABLECRS$0);
            }
            target.set(availableCRS);
        }
    }
}

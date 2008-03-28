/*
 * An XML document type.
 * Localname: SupportedCRS
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.SupportedCRSDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one SupportedCRS(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class SupportedCRSDocumentImpl extends net.opengeospatial.ows.impl.AvailableCRSDocumentImpl implements net.opengeospatial.ows.SupportedCRSDocument
{
    
    public SupportedCRSDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SUPPORTEDCRS$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "SupportedCRS");
    
    
    /**
     * Gets the "SupportedCRS" element
     */
    public java.lang.String getSupportedCRS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTEDCRS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SupportedCRS" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetSupportedCRS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(SUPPORTEDCRS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SupportedCRS" element
     */
    public void setSupportedCRS(java.lang.String supportedCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SUPPORTEDCRS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SUPPORTEDCRS$0);
            }
            target.setStringValue(supportedCRS);
        }
    }
    
    /**
     * Sets (as xml) the "SupportedCRS" element
     */
    public void xsetSupportedCRS(org.apache.xmlbeans.XmlAnyURI supportedCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(SUPPORTEDCRS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(SUPPORTEDCRS$0);
            }
            target.set(supportedCRS);
        }
    }
}

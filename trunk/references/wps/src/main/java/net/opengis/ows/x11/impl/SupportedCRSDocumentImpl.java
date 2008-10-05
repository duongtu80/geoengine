/*
 * An XML document type.
 * Localname: SupportedCRS
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.SupportedCRSDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one SupportedCRS(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class SupportedCRSDocumentImpl extends net.opengis.ows.x11.impl.AvailableCRSDocumentImpl implements net.opengis.ows.x11.SupportedCRSDocument
{
    private static final long serialVersionUID = 1L;
    
    public SupportedCRSDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SUPPORTEDCRS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "SupportedCRS");
    
    
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

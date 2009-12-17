/*
 * An XML document type.
 * Localname: ExtendedCapabilities
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ExtendedCapabilitiesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one ExtendedCapabilities(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ExtendedCapabilitiesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ExtendedCapabilitiesDocument
{
    private static final long serialVersionUID = 1L;
    
    public ExtendedCapabilitiesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXTENDEDCAPABILITIES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ExtendedCapabilities");
    
    
    /**
     * Gets the "ExtendedCapabilities" element
     */
    public org.apache.xmlbeans.XmlObject getExtendedCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(EXTENDEDCAPABILITIES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ExtendedCapabilities" element
     */
    public void setExtendedCapabilities(org.apache.xmlbeans.XmlObject extendedCapabilities)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(EXTENDEDCAPABILITIES$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(EXTENDEDCAPABILITIES$0);
            }
            target.set(extendedCapabilities);
        }
    }
    
    /**
     * Appends and returns a new empty "ExtendedCapabilities" element
     */
    public org.apache.xmlbeans.XmlObject addNewExtendedCapabilities()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(EXTENDEDCAPABILITIES$0);
            return target;
        }
    }
}

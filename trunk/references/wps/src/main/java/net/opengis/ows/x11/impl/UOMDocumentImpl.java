/*
 * An XML document type.
 * Localname: UOM
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.UOMDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one UOM(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class UOMDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.UOMDocument
{
    private static final long serialVersionUID = 1L;
    
    public UOMDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOM$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "UOM");
    
    
    /**
     * Gets the "UOM" element
     */
    public net.opengis.ows.x11.DomainMetadataType getUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(UOM$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "UOM" element
     */
    public void setUOM(net.opengis.ows.x11.DomainMetadataType uom)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(UOM$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(UOM$0);
            }
            target.set(uom);
        }
    }
    
    /**
     * Appends and returns a new empty "UOM" element
     */
    public net.opengis.ows.x11.DomainMetadataType addNewUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(UOM$0);
            return target;
        }
    }
}

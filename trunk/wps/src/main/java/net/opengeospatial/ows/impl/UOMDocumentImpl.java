/*
 * An XML document type.
 * Localname: UOM
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.UOMDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one UOM(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class UOMDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.UOMDocument
{
    
    public UOMDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOM$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "UOM");
    
    
    /**
     * Gets the "UOM" element
     */
    public net.opengeospatial.ows.DomainMetadataType getUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(UOM$0, 0);
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
    public void setUOM(net.opengeospatial.ows.DomainMetadataType uom)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(UOM$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(UOM$0);
            }
            target.set(uom);
        }
    }
    
    /**
     * Appends and returns a new empty "UOM" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(UOM$0);
            return target;
        }
    }
}

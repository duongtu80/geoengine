/*
 * An XML document type.
 * Localname: Metadata
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.MetadataDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one Metadata(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class MetadataDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.MetadataDocument
{
    
    public MetadataDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METADATA$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Metadata");
    
    
    /**
     * Gets the "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType getMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().find_element_user(METADATA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Metadata" element
     */
    public void setMetadata(net.opengeospatial.ows.MetadataType metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().find_element_user(METADATA$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.MetadataType)get_store().add_element_user(METADATA$0);
            }
            target.set(metadata);
        }
    }
    
    /**
     * Appends and returns a new empty "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().add_element_user(METADATA$0);
            return target;
        }
    }
}

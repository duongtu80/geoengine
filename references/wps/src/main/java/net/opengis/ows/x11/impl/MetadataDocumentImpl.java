/*
 * An XML document type.
 * Localname: Metadata
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.MetadataDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Metadata(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class MetadataDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.MetadataDocument
{
    private static final long serialVersionUID = 1L;
    
    public MetadataDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METADATA$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Metadata");
    
    
    /**
     * Gets the "Metadata" element
     */
    public net.opengis.ows.x11.MetadataType getMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$0, 0);
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
    public void setMetadata(net.opengis.ows.x11.MetadataType metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(METADATA$0);
            }
            target.set(metadata);
        }
    }
    
    /**
     * Appends and returns a new empty "Metadata" element
     */
    public net.opengis.ows.x11.MetadataType addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(METADATA$0);
            return target;
        }
    }
}

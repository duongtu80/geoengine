/*
 * An XML document type.
 * Localname: Meaning
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.MeaningDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one Meaning(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class MeaningDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.MeaningDocument
{
    
    public MeaningDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MEANING$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Meaning");
    
    
    /**
     * Gets the "Meaning" element
     */
    public net.opengeospatial.ows.DomainMetadataType getMeaning()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(MEANING$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Meaning" element
     */
    public void setMeaning(net.opengeospatial.ows.DomainMetadataType meaning)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(MEANING$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(MEANING$0);
            }
            target.set(meaning);
        }
    }
    
    /**
     * Appends and returns a new empty "Meaning" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewMeaning()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(MEANING$0);
            return target;
        }
    }
}

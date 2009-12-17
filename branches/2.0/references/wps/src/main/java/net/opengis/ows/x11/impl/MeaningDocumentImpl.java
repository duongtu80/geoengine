/*
 * An XML document type.
 * Localname: Meaning
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.MeaningDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Meaning(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class MeaningDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.MeaningDocument
{
    private static final long serialVersionUID = 1L;
    
    public MeaningDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MEANING$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Meaning");
    
    
    /**
     * Gets the "Meaning" element
     */
    public net.opengis.ows.x11.DomainMetadataType getMeaning()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(MEANING$0, 0);
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
    public void setMeaning(net.opengis.ows.x11.DomainMetadataType meaning)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(MEANING$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(MEANING$0);
            }
            target.set(meaning);
        }
    }
    
    /**
     * Appends and returns a new empty "Meaning" element
     */
    public net.opengis.ows.x11.DomainMetadataType addNewMeaning()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(MEANING$0);
            return target;
        }
    }
}

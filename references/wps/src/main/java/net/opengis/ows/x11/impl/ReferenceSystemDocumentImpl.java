/*
 * An XML document type.
 * Localname: ReferenceSystem
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ReferenceSystemDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one ReferenceSystem(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ReferenceSystemDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ReferenceSystemDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceSystemDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCESYSTEM$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ReferenceSystem");
    
    
    /**
     * Gets the "ReferenceSystem" element
     */
    public net.opengis.ows.x11.DomainMetadataType getReferenceSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(REFERENCESYSTEM$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ReferenceSystem" element
     */
    public void setReferenceSystem(net.opengis.ows.x11.DomainMetadataType referenceSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(REFERENCESYSTEM$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(REFERENCESYSTEM$0);
            }
            target.set(referenceSystem);
        }
    }
    
    /**
     * Appends and returns a new empty "ReferenceSystem" element
     */
    public net.opengis.ows.x11.DomainMetadataType addNewReferenceSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(REFERENCESYSTEM$0);
            return target;
        }
    }
}

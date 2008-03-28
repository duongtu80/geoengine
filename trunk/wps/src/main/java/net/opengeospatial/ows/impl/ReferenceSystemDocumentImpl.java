/*
 * An XML document type.
 * Localname: ReferenceSystem
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ReferenceSystemDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one ReferenceSystem(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class ReferenceSystemDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ReferenceSystemDocument
{
    
    public ReferenceSystemDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCESYSTEM$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ReferenceSystem");
    
    
    /**
     * Gets the "ReferenceSystem" element
     */
    public net.opengeospatial.ows.DomainMetadataType getReferenceSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(REFERENCESYSTEM$0, 0);
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
    public void setReferenceSystem(net.opengeospatial.ows.DomainMetadataType referenceSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(REFERENCESYSTEM$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(REFERENCESYSTEM$0);
            }
            target.set(referenceSystem);
        }
    }
    
    /**
     * Appends and returns a new empty "ReferenceSystem" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewReferenceSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(REFERENCESYSTEM$0);
            return target;
        }
    }
}

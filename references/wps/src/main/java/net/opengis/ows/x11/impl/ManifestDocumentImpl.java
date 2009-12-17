/*
 * An XML document type.
 * Localname: Manifest
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ManifestDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Manifest(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ManifestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ManifestDocument
{
    private static final long serialVersionUID = 1L;
    
    public ManifestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MANIFEST$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Manifest");
    
    
    /**
     * Gets the "Manifest" element
     */
    public net.opengis.ows.x11.ManifestType getManifest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().find_element_user(MANIFEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Manifest" element
     */
    public void setManifest(net.opengis.ows.x11.ManifestType manifest)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().find_element_user(MANIFEST$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ManifestType)get_store().add_element_user(MANIFEST$0);
            }
            target.set(manifest);
        }
    }
    
    /**
     * Appends and returns a new empty "Manifest" element
     */
    public net.opengis.ows.x11.ManifestType addNewManifest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().add_element_user(MANIFEST$0);
            return target;
        }
    }
}

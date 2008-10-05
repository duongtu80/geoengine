/*
 * An XML document type.
 * Localname: OtherSource
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.OtherSourceDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one OtherSource(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class OtherSourceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.OtherSourceDocument
{
    private static final long serialVersionUID = 1L;
    
    public OtherSourceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OTHERSOURCE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "OtherSource");
    
    
    /**
     * Gets the "OtherSource" element
     */
    public net.opengis.ows.x11.MetadataType getOtherSource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(OTHERSOURCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "OtherSource" element
     */
    public void setOtherSource(net.opengis.ows.x11.MetadataType otherSource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(OTHERSOURCE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(OTHERSOURCE$0);
            }
            target.set(otherSource);
        }
    }
    
    /**
     * Appends and returns a new empty "OtherSource" element
     */
    public net.opengis.ows.x11.MetadataType addNewOtherSource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(OTHERSOURCE$0);
            return target;
        }
    }
}

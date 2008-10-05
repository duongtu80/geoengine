/*
 * An XML document type.
 * Localname: Spacing
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.SpacingDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Spacing(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class SpacingDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.SpacingDocument
{
    private static final long serialVersionUID = 1L;
    
    public SpacingDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACING$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Spacing");
    
    
    /**
     * Gets the "Spacing" element
     */
    public net.opengis.ows.x11.ValueType getSpacing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(SPACING$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Spacing" element
     */
    public void setSpacing(net.opengis.ows.x11.ValueType spacing)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(SPACING$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(SPACING$0);
            }
            target.set(spacing);
        }
    }
    
    /**
     * Appends and returns a new empty "Spacing" element
     */
    public net.opengis.ows.x11.ValueType addNewSpacing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ValueType target = null;
            target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(SPACING$0);
            return target;
        }
    }
}

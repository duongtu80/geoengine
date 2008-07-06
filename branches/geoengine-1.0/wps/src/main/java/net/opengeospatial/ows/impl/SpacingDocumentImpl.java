/*
 * An XML document type.
 * Localname: Spacing
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.SpacingDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one Spacing(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class SpacingDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.SpacingDocument
{
    
    public SpacingDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPACING$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Spacing");
    
    
    /**
     * Gets the "Spacing" element
     */
    public net.opengeospatial.ows.ValueType getSpacing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(SPACING$0, 0);
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
    public void setSpacing(net.opengeospatial.ows.ValueType spacing)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(SPACING$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(SPACING$0);
            }
            target.set(spacing);
        }
    }
    
    /**
     * Appends and returns a new empty "Spacing" element
     */
    public net.opengeospatial.ows.ValueType addNewSpacing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValueType target = null;
            target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(SPACING$0);
            return target;
        }
    }
}

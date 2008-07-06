/*
 * An XML document type.
 * Localname: Range
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.RangeDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one Range(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class RangeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.RangeDocument
{
    
    public RangeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RANGE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Range");
    
    
    /**
     * Gets the "Range" element
     */
    public net.opengeospatial.ows.RangeType getRange()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(RANGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Range" element
     */
    public void setRange(net.opengeospatial.ows.RangeType range)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(RANGE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(RANGE$0);
            }
            target.set(range);
        }
    }
    
    /**
     * Appends and returns a new empty "Range" element
     */
    public net.opengeospatial.ows.RangeType addNewRange()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(RANGE$0);
            return target;
        }
    }
}

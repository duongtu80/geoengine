/*
 * An XML document type.
 * Localname: Range
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.RangeDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Range(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class RangeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.RangeDocument
{
    private static final long serialVersionUID = 1L;
    
    public RangeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RANGE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Range");
    
    
    /**
     * Gets the "Range" element
     */
    public net.opengis.ows.x11.RangeType getRange()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.RangeType target = null;
            target = (net.opengis.ows.x11.RangeType)get_store().find_element_user(RANGE$0, 0);
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
    public void setRange(net.opengis.ows.x11.RangeType range)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.RangeType target = null;
            target = (net.opengis.ows.x11.RangeType)get_store().find_element_user(RANGE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.RangeType)get_store().add_element_user(RANGE$0);
            }
            target.set(range);
        }
    }
    
    /**
     * Appends and returns a new empty "Range" element
     */
    public net.opengis.ows.x11.RangeType addNewRange()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.RangeType target = null;
            target = (net.opengis.ows.x11.RangeType)get_store().add_element_user(RANGE$0);
            return target;
        }
    }
}

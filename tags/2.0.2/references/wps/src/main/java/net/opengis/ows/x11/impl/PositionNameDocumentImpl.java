/*
 * An XML document type.
 * Localname: PositionName
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.PositionNameDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one PositionName(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class PositionNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.PositionNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public PositionNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POSITIONNAME$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "PositionName");
    
    
    /**
     * Gets the "PositionName" element
     */
    public java.lang.String getPositionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PositionName" element
     */
    public org.apache.xmlbeans.XmlString xgetPositionName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSITIONNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PositionName" element
     */
    public void setPositionName(java.lang.String positionName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSITIONNAME$0);
            }
            target.setStringValue(positionName);
        }
    }
    
    /**
     * Sets (as xml) the "PositionName" element
     */
    public void xsetPositionName(org.apache.xmlbeans.XmlString positionName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSITIONNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSITIONNAME$0);
            }
            target.set(positionName);
        }
    }
}

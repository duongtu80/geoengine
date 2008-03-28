/*
 * An XML document type.
 * Localname: AbstractMetaData
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.AbstractMetaDataDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one AbstractMetaData(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class AbstractMetaDataDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.AbstractMetaDataDocument
{
    
    public AbstractMetaDataDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTMETADATA$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AbstractMetaData");
    
    
    /**
     * Gets the "AbstractMetaData" element
     */
    public org.apache.xmlbeans.XmlObject getAbstractMetaData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(ABSTRACTMETADATA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AbstractMetaData" element
     */
    public void setAbstractMetaData(org.apache.xmlbeans.XmlObject abstractMetaData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(ABSTRACTMETADATA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(ABSTRACTMETADATA$0);
            }
            target.set(abstractMetaData);
        }
    }
    
    /**
     * Appends and returns a new empty "AbstractMetaData" element
     */
    public org.apache.xmlbeans.XmlObject addNewAbstractMetaData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(ABSTRACTMETADATA$0);
            return target;
        }
    }
}

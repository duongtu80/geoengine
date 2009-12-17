/*
 * An XML document type.
 * Localname: AbstractMetaData
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AbstractMetaDataDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one AbstractMetaData(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class AbstractMetaDataDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AbstractMetaDataDocument
{
    private static final long serialVersionUID = 1L;
    
    public AbstractMetaDataDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTMETADATA$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AbstractMetaData");
    
    
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

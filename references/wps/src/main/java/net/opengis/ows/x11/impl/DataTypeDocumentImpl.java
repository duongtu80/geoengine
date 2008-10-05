/*
 * An XML document type.
 * Localname: DataType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.DataTypeDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one DataType(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class DataTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.DataTypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public DataTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATATYPE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DataType");
    
    
    /**
     * Gets the "DataType" element
     */
    public net.opengis.ows.x11.DomainMetadataType getDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(DATATYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DataType" element
     */
    public void setDataType(net.opengis.ows.x11.DomainMetadataType dataType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(DATATYPE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(DATATYPE$0);
            }
            target.set(dataType);
        }
    }
    
    /**
     * Appends and returns a new empty "DataType" element
     */
    public net.opengis.ows.x11.DomainMetadataType addNewDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(DATATYPE$0);
            return target;
        }
    }
}

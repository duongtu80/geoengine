/*
 * An XML document type.
 * Localname: DataType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.DataTypeDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one DataType(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class DataTypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.DataTypeDocument
{
    
    public DataTypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATATYPE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "DataType");
    
    
    /**
     * Gets the "DataType" element
     */
    public net.opengeospatial.ows.DomainMetadataType getDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(DATATYPE$0, 0);
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
    public void setDataType(net.opengeospatial.ows.DomainMetadataType dataType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(DATATYPE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(DATATYPE$0);
            }
            target.set(dataType);
        }
    }
    
    /**
     * Appends and returns a new empty "DataType" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(DATATYPE$0);
            return target;
        }
    }
}

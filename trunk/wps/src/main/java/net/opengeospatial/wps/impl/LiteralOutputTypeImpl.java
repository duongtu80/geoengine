/*
 * XML Type:  LiteralOutputType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.LiteralOutputType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML LiteralOutputType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class LiteralOutputTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.LiteralOutputType
{
    
    public LiteralOutputTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATATYPE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "DataType");
    private static final javax.xml.namespace.QName SUPPORTEDUOMS$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "SupportedUOMs");
    
    
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
     * True if has "DataType" element
     */
    public boolean isSetDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATATYPE$0) != 0;
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
    
    /**
     * Unsets the "DataType" element
     */
    public void unsetDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATATYPE$0, 0);
        }
    }
    
    /**
     * Gets the "SupportedUOMs" element
     */
    public net.opengeospatial.wps.SupportedUOMsType getSupportedUOMs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedUOMsType target = null;
            target = (net.opengeospatial.wps.SupportedUOMsType)get_store().find_element_user(SUPPORTEDUOMS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "SupportedUOMs" element
     */
    public boolean isSetSupportedUOMs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SUPPORTEDUOMS$2) != 0;
        }
    }
    
    /**
     * Sets the "SupportedUOMs" element
     */
    public void setSupportedUOMs(net.opengeospatial.wps.SupportedUOMsType supportedUOMs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedUOMsType target = null;
            target = (net.opengeospatial.wps.SupportedUOMsType)get_store().find_element_user(SUPPORTEDUOMS$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.SupportedUOMsType)get_store().add_element_user(SUPPORTEDUOMS$2);
            }
            target.set(supportedUOMs);
        }
    }
    
    /**
     * Appends and returns a new empty "SupportedUOMs" element
     */
    public net.opengeospatial.wps.SupportedUOMsType addNewSupportedUOMs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedUOMsType target = null;
            target = (net.opengeospatial.wps.SupportedUOMsType)get_store().add_element_user(SUPPORTEDUOMS$2);
            return target;
        }
    }
    
    /**
     * Unsets the "SupportedUOMs" element
     */
    public void unsetSupportedUOMs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SUPPORTEDUOMS$2, 0);
        }
    }
}

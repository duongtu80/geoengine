/*
 * XML Type:  LiteralOutputType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.LiteralOutputType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML LiteralOutputType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class LiteralOutputTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.LiteralOutputType
{
    private static final long serialVersionUID = 1L;
    
    public LiteralOutputTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATATYPE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DataType");
    private static final javax.xml.namespace.QName UOMS$2 = 
        new javax.xml.namespace.QName("", "UOMs");
    
    
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
     * Gets the "UOMs" element
     */
    public net.opengis.wps.x100.SupportedUOMsType getUOMs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedUOMsType target = null;
            target = (net.opengis.wps.x100.SupportedUOMsType)get_store().find_element_user(UOMS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "UOMs" element
     */
    public boolean isSetUOMs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UOMS$2) != 0;
        }
    }
    
    /**
     * Sets the "UOMs" element
     */
    public void setUOMs(net.opengis.wps.x100.SupportedUOMsType uoMs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedUOMsType target = null;
            target = (net.opengis.wps.x100.SupportedUOMsType)get_store().find_element_user(UOMS$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.SupportedUOMsType)get_store().add_element_user(UOMS$2);
            }
            target.set(uoMs);
        }
    }
    
    /**
     * Appends and returns a new empty "UOMs" element
     */
    public net.opengis.wps.x100.SupportedUOMsType addNewUOMs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedUOMsType target = null;
            target = (net.opengis.wps.x100.SupportedUOMsType)get_store().add_element_user(UOMS$2);
            return target;
        }
    }
    
    /**
     * Unsets the "UOMs" element
     */
    public void unsetUOMs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UOMS$2, 0);
        }
    }
}

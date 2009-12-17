/*
 * XML Type:  SupportedUOMsType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.SupportedUOMsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML SupportedUOMsType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class SupportedUOMsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.SupportedUOMsType
{
    private static final long serialVersionUID = 1L;
    
    public SupportedUOMsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEFAULT$0 = 
        new javax.xml.namespace.QName("", "Default");
    private static final javax.xml.namespace.QName SUPPORTED$2 = 
        new javax.xml.namespace.QName("", "Supported");
    
    
    /**
     * Gets the "Default" element
     */
    public net.opengis.wps.x100.SupportedUOMsType.Default getDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedUOMsType.Default target = null;
            target = (net.opengis.wps.x100.SupportedUOMsType.Default)get_store().find_element_user(DEFAULT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Default" element
     */
    public void setDefault(net.opengis.wps.x100.SupportedUOMsType.Default xdefault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedUOMsType.Default target = null;
            target = (net.opengis.wps.x100.SupportedUOMsType.Default)get_store().find_element_user(DEFAULT$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.SupportedUOMsType.Default)get_store().add_element_user(DEFAULT$0);
            }
            target.set(xdefault);
        }
    }
    
    /**
     * Appends and returns a new empty "Default" element
     */
    public net.opengis.wps.x100.SupportedUOMsType.Default addNewDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedUOMsType.Default target = null;
            target = (net.opengis.wps.x100.SupportedUOMsType.Default)get_store().add_element_user(DEFAULT$0);
            return target;
        }
    }
    
    /**
     * Gets the "Supported" element
     */
    public net.opengis.wps.x100.UOMsType getSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.UOMsType target = null;
            target = (net.opengis.wps.x100.UOMsType)get_store().find_element_user(SUPPORTED$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Supported" element
     */
    public void setSupported(net.opengis.wps.x100.UOMsType supported)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.UOMsType target = null;
            target = (net.opengis.wps.x100.UOMsType)get_store().find_element_user(SUPPORTED$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.UOMsType)get_store().add_element_user(SUPPORTED$2);
            }
            target.set(supported);
        }
    }
    
    /**
     * Appends and returns a new empty "Supported" element
     */
    public net.opengis.wps.x100.UOMsType addNewSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.UOMsType target = null;
            target = (net.opengis.wps.x100.UOMsType)get_store().add_element_user(SUPPORTED$2);
            return target;
        }
    }
    /**
     * An XML Default(@).
     *
     * This is a complex type.
     */
    public static class DefaultImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.SupportedUOMsType.Default
    {
        private static final long serialVersionUID = 1L;
        
        public DefaultImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName UOM$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "UOM");
        
        
        /**
         * Gets the "UOM" element
         */
        public net.opengis.ows.x11.DomainMetadataType getUOM()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainMetadataType target = null;
                target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(UOM$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "UOM" element
         */
        public void setUOM(net.opengis.ows.x11.DomainMetadataType uom)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainMetadataType target = null;
                target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(UOM$0, 0);
                if (target == null)
                {
                    target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(UOM$0);
                }
                target.set(uom);
            }
        }
        
        /**
         * Appends and returns a new empty "UOM" element
         */
        public net.opengis.ows.x11.DomainMetadataType addNewUOM()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainMetadataType target = null;
                target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(UOM$0);
                return target;
            }
        }
    }
}

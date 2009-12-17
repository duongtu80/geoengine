/*
 * XML Type:  SupportedCRSsType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.SupportedCRSsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML SupportedCRSsType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class SupportedCRSsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.SupportedCRSsType
{
    private static final long serialVersionUID = 1L;
    
    public SupportedCRSsTypeImpl(org.apache.xmlbeans.SchemaType sType)
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
    public net.opengis.wps.x100.SupportedCRSsType.Default getDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedCRSsType.Default target = null;
            target = (net.opengis.wps.x100.SupportedCRSsType.Default)get_store().find_element_user(DEFAULT$0, 0);
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
    public void setDefault(net.opengis.wps.x100.SupportedCRSsType.Default xdefault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedCRSsType.Default target = null;
            target = (net.opengis.wps.x100.SupportedCRSsType.Default)get_store().find_element_user(DEFAULT$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.SupportedCRSsType.Default)get_store().add_element_user(DEFAULT$0);
            }
            target.set(xdefault);
        }
    }
    
    /**
     * Appends and returns a new empty "Default" element
     */
    public net.opengis.wps.x100.SupportedCRSsType.Default addNewDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedCRSsType.Default target = null;
            target = (net.opengis.wps.x100.SupportedCRSsType.Default)get_store().add_element_user(DEFAULT$0);
            return target;
        }
    }
    
    /**
     * Gets the "Supported" element
     */
    public net.opengis.wps.x100.CRSsType getSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.CRSsType target = null;
            target = (net.opengis.wps.x100.CRSsType)get_store().find_element_user(SUPPORTED$2, 0);
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
    public void setSupported(net.opengis.wps.x100.CRSsType supported)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.CRSsType target = null;
            target = (net.opengis.wps.x100.CRSsType)get_store().find_element_user(SUPPORTED$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.CRSsType)get_store().add_element_user(SUPPORTED$2);
            }
            target.set(supported);
        }
    }
    
    /**
     * Appends and returns a new empty "Supported" element
     */
    public net.opengis.wps.x100.CRSsType addNewSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.CRSsType target = null;
            target = (net.opengis.wps.x100.CRSsType)get_store().add_element_user(SUPPORTED$2);
            return target;
        }
    }
    /**
     * An XML Default(@).
     *
     * This is a complex type.
     */
    public static class DefaultImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.SupportedCRSsType.Default
    {
        private static final long serialVersionUID = 1L;
        
        public DefaultImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CRS$0 = 
            new javax.xml.namespace.QName("", "CRS");
        
        
        /**
         * Gets the "CRS" element
         */
        public java.lang.String getCRS()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CRS$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CRS" element
         */
        public org.apache.xmlbeans.XmlAnyURI xgetCRS()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(CRS$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CRS" element
         */
        public void setCRS(java.lang.String crs)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CRS$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CRS$0);
                }
                target.setStringValue(crs);
            }
        }
        
        /**
         * Sets (as xml) the "CRS" element
         */
        public void xsetCRS(org.apache.xmlbeans.XmlAnyURI crs)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(CRS$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(CRS$0);
                }
                target.set(crs);
            }
        }
    }
}

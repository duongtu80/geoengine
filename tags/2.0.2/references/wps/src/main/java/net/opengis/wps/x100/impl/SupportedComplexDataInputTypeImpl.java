/*
 * XML Type:  SupportedComplexDataInputType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.SupportedComplexDataInputType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML SupportedComplexDataInputType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class SupportedComplexDataInputTypeImpl extends net.opengis.wps.x100.impl.SupportedComplexDataTypeImpl implements net.opengis.wps.x100.SupportedComplexDataInputType
{
    private static final long serialVersionUID = 1L;
    
    public SupportedComplexDataInputTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MAXIMUMMEGABYTES$0 = 
        new javax.xml.namespace.QName("", "maximumMegabytes");
    
    
    /**
     * Gets the "maximumMegabytes" attribute
     */
    public java.math.BigInteger getMaximumMegabytes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MAXIMUMMEGABYTES$0);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "maximumMegabytes" attribute
     */
    public org.apache.xmlbeans.XmlInteger xgetMaximumMegabytes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_attribute_user(MAXIMUMMEGABYTES$0);
            return target;
        }
    }
    
    /**
     * True if has "maximumMegabytes" attribute
     */
    public boolean isSetMaximumMegabytes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(MAXIMUMMEGABYTES$0) != null;
        }
    }
    
    /**
     * Sets the "maximumMegabytes" attribute
     */
    public void setMaximumMegabytes(java.math.BigInteger maximumMegabytes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MAXIMUMMEGABYTES$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MAXIMUMMEGABYTES$0);
            }
            target.setBigIntegerValue(maximumMegabytes);
        }
    }
    
    /**
     * Sets (as xml) the "maximumMegabytes" attribute
     */
    public void xsetMaximumMegabytes(org.apache.xmlbeans.XmlInteger maximumMegabytes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_attribute_user(MAXIMUMMEGABYTES$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInteger)get_store().add_attribute_user(MAXIMUMMEGABYTES$0);
            }
            target.set(maximumMegabytes);
        }
    }
    
    /**
     * Unsets the "maximumMegabytes" attribute
     */
    public void unsetMaximumMegabytes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(MAXIMUMMEGABYTES$0);
        }
    }
}

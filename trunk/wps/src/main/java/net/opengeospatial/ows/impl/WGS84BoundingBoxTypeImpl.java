/*
 * XML Type:  WGS84BoundingBoxType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.WGS84BoundingBoxType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML WGS84BoundingBoxType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class WGS84BoundingBoxTypeImpl extends net.opengeospatial.ows.impl.BoundingBoxTypeImpl implements net.opengeospatial.ows.WGS84BoundingBoxType
{
    
    public WGS84BoundingBoxTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CRS$0 = 
        new javax.xml.namespace.QName("", "crs");
    private static final javax.xml.namespace.QName DIMENSIONS$2 = 
        new javax.xml.namespace.QName("", "dimensions");
    
    
    /**
     * Gets the "crs" attribute
     */
    public java.lang.String getCrs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CRS$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(CRS$0);
            }
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "crs" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetCrs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(CRS$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_default_attribute_value(CRS$0);
            }
            return target;
        }
    }
    
    /**
     * True if has "crs" attribute
     */
    public boolean isSetCrs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(CRS$0) != null;
        }
    }
    
    /**
     * Sets the "crs" attribute
     */
    public void setCrs(java.lang.String crs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CRS$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CRS$0);
            }
            target.setStringValue(crs);
        }
    }
    
    /**
     * Sets (as xml) the "crs" attribute
     */
    public void xsetCrs(org.apache.xmlbeans.XmlAnyURI crs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(CRS$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(CRS$0);
            }
            target.set(crs);
        }
    }
    
    /**
     * Unsets the "crs" attribute
     */
    public void unsetCrs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(CRS$0);
        }
    }
    
    /**
     * Gets the "dimensions" attribute
     */
    public java.math.BigInteger getDimensions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DIMENSIONS$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(DIMENSIONS$2);
            }
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "dimensions" attribute
     */
    public org.apache.xmlbeans.XmlPositiveInteger xgetDimensions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlPositiveInteger target = null;
            target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().find_attribute_user(DIMENSIONS$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlPositiveInteger)get_default_attribute_value(DIMENSIONS$2);
            }
            return target;
        }
    }
    
    /**
     * True if has "dimensions" attribute
     */
    public boolean isSetDimensions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DIMENSIONS$2) != null;
        }
    }
    
    /**
     * Sets the "dimensions" attribute
     */
    public void setDimensions(java.math.BigInteger dimensions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DIMENSIONS$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DIMENSIONS$2);
            }
            target.setBigIntegerValue(dimensions);
        }
    }
    
    /**
     * Sets (as xml) the "dimensions" attribute
     */
    public void xsetDimensions(org.apache.xmlbeans.XmlPositiveInteger dimensions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlPositiveInteger target = null;
            target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().find_attribute_user(DIMENSIONS$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().add_attribute_user(DIMENSIONS$2);
            }
            target.set(dimensions);
        }
    }
    
    /**
     * Unsets the "dimensions" attribute
     */
    public void unsetDimensions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DIMENSIONS$2);
        }
    }
}

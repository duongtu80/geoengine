/*
 * XML Type:  BoundingBoxType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.BoundingBoxType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML BoundingBoxType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class BoundingBoxTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.BoundingBoxType
{
    
    public BoundingBoxTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LOWERCORNER$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "LowerCorner");
    private static final javax.xml.namespace.QName UPPERCORNER$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "UpperCorner");
    private static final javax.xml.namespace.QName CRS$4 = 
        new javax.xml.namespace.QName("", "crs");
    private static final javax.xml.namespace.QName DIMENSIONS$6 = 
        new javax.xml.namespace.QName("", "dimensions");
    
    
    /**
     * Gets the "LowerCorner" element
     */
    public java.util.List getLowerCorner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOWERCORNER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getListValue();
        }
    }
    
    /**
     * Gets (as xml) the "LowerCorner" element
     */
    public net.opengeospatial.ows.PositionType xgetLowerCorner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.PositionType target = null;
            target = (net.opengeospatial.ows.PositionType)get_store().find_element_user(LOWERCORNER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "LowerCorner" element
     */
    public void setLowerCorner(java.util.List lowerCorner)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOWERCORNER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOWERCORNER$0);
            }
            target.setListValue(lowerCorner);
        }
    }
    
    /**
     * Sets (as xml) the "LowerCorner" element
     */
    public void xsetLowerCorner(net.opengeospatial.ows.PositionType lowerCorner)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.PositionType target = null;
            target = (net.opengeospatial.ows.PositionType)get_store().find_element_user(LOWERCORNER$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.PositionType)get_store().add_element_user(LOWERCORNER$0);
            }
            target.set(lowerCorner);
        }
    }
    
    /**
     * Gets the "UpperCorner" element
     */
    public java.util.List getUpperCorner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UPPERCORNER$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getListValue();
        }
    }
    
    /**
     * Gets (as xml) the "UpperCorner" element
     */
    public net.opengeospatial.ows.PositionType xgetUpperCorner()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.PositionType target = null;
            target = (net.opengeospatial.ows.PositionType)get_store().find_element_user(UPPERCORNER$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UpperCorner" element
     */
    public void setUpperCorner(java.util.List upperCorner)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UPPERCORNER$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UPPERCORNER$2);
            }
            target.setListValue(upperCorner);
        }
    }
    
    /**
     * Sets (as xml) the "UpperCorner" element
     */
    public void xsetUpperCorner(net.opengeospatial.ows.PositionType upperCorner)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.PositionType target = null;
            target = (net.opengeospatial.ows.PositionType)get_store().find_element_user(UPPERCORNER$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.PositionType)get_store().add_element_user(UPPERCORNER$2);
            }
            target.set(upperCorner);
        }
    }
    
    /**
     * Gets the "crs" attribute
     */
    public java.lang.String getCrs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CRS$4);
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
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(CRS$4);
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
            return get_store().find_attribute_user(CRS$4) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CRS$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CRS$4);
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
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(CRS$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(CRS$4);
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
            get_store().remove_attribute(CRS$4);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DIMENSIONS$6);
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
            target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().find_attribute_user(DIMENSIONS$6);
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
            return get_store().find_attribute_user(DIMENSIONS$6) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DIMENSIONS$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DIMENSIONS$6);
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
            target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().find_attribute_user(DIMENSIONS$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().add_attribute_user(DIMENSIONS$6);
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
            get_store().remove_attribute(DIMENSIONS$6);
        }
    }
}

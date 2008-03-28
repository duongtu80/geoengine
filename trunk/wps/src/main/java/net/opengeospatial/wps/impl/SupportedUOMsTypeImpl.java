/*
 * XML Type:  SupportedUOMsType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.SupportedUOMsType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML SupportedUOMsType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class SupportedUOMsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.SupportedUOMsType
{
    
    public SupportedUOMsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOM$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "UOM");
    private static final javax.xml.namespace.QName DEFAULTUOM$2 = 
        new javax.xml.namespace.QName("", "defaultUOM");
    
    
    /**
     * Gets array of all "UOM" elements
     */
    public net.opengeospatial.ows.DomainMetadataType[] getUOMArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(UOM$0, targetList);
            net.opengeospatial.ows.DomainMetadataType[] result = new net.opengeospatial.ows.DomainMetadataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "UOM" element
     */
    public net.opengeospatial.ows.DomainMetadataType getUOMArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(UOM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "UOM" element
     */
    public int sizeOfUOMArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UOM$0);
        }
    }
    
    /**
     * Sets array of all "UOM" element
     */
    public void setUOMArray(net.opengeospatial.ows.DomainMetadataType[] uomArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(uomArray, UOM$0);
        }
    }
    
    /**
     * Sets ith "UOM" element
     */
    public void setUOMArray(int i, net.opengeospatial.ows.DomainMetadataType uom)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(UOM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(uom);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "UOM" element
     */
    public net.opengeospatial.ows.DomainMetadataType insertNewUOM(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().insert_element_user(UOM$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "UOM" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(UOM$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "UOM" element
     */
    public void removeUOM(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UOM$0, i);
        }
    }
    
    /**
     * Gets the "defaultUOM" attribute
     */
    public java.lang.String getDefaultUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTUOM$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "defaultUOM" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetDefaultUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(DEFAULTUOM$2);
            return target;
        }
    }
    
    /**
     * True if has "defaultUOM" attribute
     */
    public boolean isSetDefaultUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DEFAULTUOM$2) != null;
        }
    }
    
    /**
     * Sets the "defaultUOM" attribute
     */
    public void setDefaultUOM(java.lang.String defaultUOM)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTUOM$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DEFAULTUOM$2);
            }
            target.setStringValue(defaultUOM);
        }
    }
    
    /**
     * Sets (as xml) the "defaultUOM" attribute
     */
    public void xsetDefaultUOM(org.apache.xmlbeans.XmlAnyURI defaultUOM)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(DEFAULTUOM$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(DEFAULTUOM$2);
            }
            target.set(defaultUOM);
        }
    }
    
    /**
     * Unsets the "defaultUOM" attribute
     */
    public void unsetDefaultUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DEFAULTUOM$2);
        }
    }
}

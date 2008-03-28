/*
 * XML Type:  SupportedCRSsType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.SupportedCRSsType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML SupportedCRSsType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class SupportedCRSsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.SupportedCRSsType
{
    
    public SupportedCRSsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CRS$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "CRS");
    private static final javax.xml.namespace.QName DEFAULTCRS$2 = 
        new javax.xml.namespace.QName("", "defaultCRS");
    
    
    /**
     * Gets array of all "CRS" elements
     */
    public java.lang.String[] getCRSArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CRS$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "CRS" element
     */
    public java.lang.String getCRSArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CRS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "CRS" elements
     */
    public org.apache.xmlbeans.XmlAnyURI[] xgetCRSArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CRS$0, targetList);
            org.apache.xmlbeans.XmlAnyURI[] result = new org.apache.xmlbeans.XmlAnyURI[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "CRS" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetCRSArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(CRS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlAnyURI)target;
        }
    }
    
    /**
     * Returns number of "CRS" element
     */
    public int sizeOfCRSArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CRS$0);
        }
    }
    
    /**
     * Sets array of all "CRS" element
     */
    public void setCRSArray(java.lang.String[] crsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(crsArray, CRS$0);
        }
    }
    
    /**
     * Sets ith "CRS" element
     */
    public void setCRSArray(int i, java.lang.String crs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CRS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(crs);
        }
    }
    
    /**
     * Sets (as xml) array of all "CRS" element
     */
    public void xsetCRSArray(org.apache.xmlbeans.XmlAnyURI[]crsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(crsArray, CRS$0);
        }
    }
    
    /**
     * Sets (as xml) ith "CRS" element
     */
    public void xsetCRSArray(int i, org.apache.xmlbeans.XmlAnyURI crs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(CRS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(crs);
        }
    }
    
    /**
     * Inserts the value as the ith "CRS" element
     */
    public void insertCRS(int i, java.lang.String crs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(CRS$0, i);
            target.setStringValue(crs);
        }
    }
    
    /**
     * Appends the value as the last "CRS" element
     */
    public void addCRS(java.lang.String crs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CRS$0);
            target.setStringValue(crs);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "CRS" element
     */
    public org.apache.xmlbeans.XmlAnyURI insertNewCRS(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().insert_element_user(CRS$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "CRS" element
     */
    public org.apache.xmlbeans.XmlAnyURI addNewCRS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(CRS$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "CRS" element
     */
    public void removeCRS(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CRS$0, i);
        }
    }
    
    /**
     * Gets the "defaultCRS" attribute
     */
    public java.lang.String getDefaultCRS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTCRS$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "defaultCRS" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetDefaultCRS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(DEFAULTCRS$2);
            return target;
        }
    }
    
    /**
     * Sets the "defaultCRS" attribute
     */
    public void setDefaultCRS(java.lang.String defaultCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTCRS$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DEFAULTCRS$2);
            }
            target.setStringValue(defaultCRS);
        }
    }
    
    /**
     * Sets (as xml) the "defaultCRS" attribute
     */
    public void xsetDefaultCRS(org.apache.xmlbeans.XmlAnyURI defaultCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(DEFAULTCRS$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(DEFAULTCRS$2);
            }
            target.set(defaultCRS);
        }
    }
}

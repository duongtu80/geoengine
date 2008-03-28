/*
 * XML Type:  AcceptVersionsType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.AcceptVersionsType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML AcceptVersionsType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class AcceptVersionsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.AcceptVersionsType
{
    
    public AcceptVersionsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VERSION$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Version");
    
    
    /**
     * Gets array of all "Version" elements
     */
    public java.lang.String[] getVersionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VERSION$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "Version" element
     */
    public java.lang.String getVersionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "Version" elements
     */
    public net.opengeospatial.ows.VersionType[] xgetVersionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VERSION$0, targetList);
            net.opengeospatial.ows.VersionType[] result = new net.opengeospatial.ows.VersionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "Version" element
     */
    public net.opengeospatial.ows.VersionType xgetVersionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().find_element_user(VERSION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (net.opengeospatial.ows.VersionType)target;
        }
    }
    
    /**
     * Returns number of "Version" element
     */
    public int sizeOfVersionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VERSION$0);
        }
    }
    
    /**
     * Sets array of all "Version" element
     */
    public void setVersionArray(java.lang.String[] versionArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(versionArray, VERSION$0);
        }
    }
    
    /**
     * Sets ith "Version" element
     */
    public void setVersionArray(int i, java.lang.String version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(version);
        }
    }
    
    /**
     * Sets (as xml) array of all "Version" element
     */
    public void xsetVersionArray(net.opengeospatial.ows.VersionType[]versionArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(versionArray, VERSION$0);
        }
    }
    
    /**
     * Sets (as xml) ith "Version" element
     */
    public void xsetVersionArray(int i, net.opengeospatial.ows.VersionType version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().find_element_user(VERSION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(version);
        }
    }
    
    /**
     * Inserts the value as the ith "Version" element
     */
    public void insertVersion(int i, java.lang.String version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(VERSION$0, i);
            target.setStringValue(version);
        }
    }
    
    /**
     * Appends the value as the last "Version" element
     */
    public void addVersion(java.lang.String version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VERSION$0);
            target.setStringValue(version);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Version" element
     */
    public net.opengeospatial.ows.VersionType insertNewVersion(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().insert_element_user(VERSION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Version" element
     */
    public net.opengeospatial.ows.VersionType addNewVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().add_element_user(VERSION$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Version" element
     */
    public void removeVersion(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VERSION$0, i);
        }
    }
}

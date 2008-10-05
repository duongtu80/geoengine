/*
 * XML Type:  AcceptVersionsType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AcceptVersionsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML AcceptVersionsType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class AcceptVersionsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AcceptVersionsType
{
    private static final long serialVersionUID = 1L;
    
    public AcceptVersionsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VERSION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Version");
    
    
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
    public net.opengis.ows.x11.VersionType[] xgetVersionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VERSION$0, targetList);
            net.opengis.ows.x11.VersionType[] result = new net.opengis.ows.x11.VersionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "Version" element
     */
    public net.opengis.ows.x11.VersionType xgetVersionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.VersionType target = null;
            target = (net.opengis.ows.x11.VersionType)get_store().find_element_user(VERSION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (net.opengis.ows.x11.VersionType)target;
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
    public void xsetVersionArray(net.opengis.ows.x11.VersionType[]versionArray)
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
    public void xsetVersionArray(int i, net.opengis.ows.x11.VersionType version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.VersionType target = null;
            target = (net.opengis.ows.x11.VersionType)get_store().find_element_user(VERSION$0, i);
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
    public net.opengis.ows.x11.VersionType insertNewVersion(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.VersionType target = null;
            target = (net.opengis.ows.x11.VersionType)get_store().insert_element_user(VERSION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Version" element
     */
    public net.opengis.ows.x11.VersionType addNewVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.VersionType target = null;
            target = (net.opengis.ows.x11.VersionType)get_store().add_element_user(VERSION$0);
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

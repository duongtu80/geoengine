/*
 * XML Type:  GetResourceByIdType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.GetResourceByIdType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML GetResourceByIdType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class GetResourceByIdTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.GetResourceByIdType
{
    private static final long serialVersionUID = 1L;
    
    public GetResourceByIdTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCEID$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ResourceID");
    private static final javax.xml.namespace.QName OUTPUTFORMAT$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "OutputFormat");
    private static final javax.xml.namespace.QName SERVICE$4 = 
        new javax.xml.namespace.QName("", "service");
    private static final javax.xml.namespace.QName VERSION$6 = 
        new javax.xml.namespace.QName("", "version");
    
    
    /**
     * Gets array of all "ResourceID" elements
     */
    public java.lang.String[] getResourceIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(RESOURCEID$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "ResourceID" element
     */
    public java.lang.String getResourceIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "ResourceID" elements
     */
    public org.apache.xmlbeans.XmlAnyURI[] xgetResourceIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(RESOURCEID$0, targetList);
            org.apache.xmlbeans.XmlAnyURI[] result = new org.apache.xmlbeans.XmlAnyURI[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "ResourceID" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetResourceIDArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(RESOURCEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlAnyURI)target;
        }
    }
    
    /**
     * Returns number of "ResourceID" element
     */
    public int sizeOfResourceIDArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCEID$0);
        }
    }
    
    /**
     * Sets array of all "ResourceID" element
     */
    public void setResourceIDArray(java.lang.String[] resourceIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(resourceIDArray, RESOURCEID$0);
        }
    }
    
    /**
     * Sets ith "ResourceID" element
     */
    public void setResourceIDArray(int i, java.lang.String resourceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RESOURCEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(resourceID);
        }
    }
    
    /**
     * Sets (as xml) array of all "ResourceID" element
     */
    public void xsetResourceIDArray(org.apache.xmlbeans.XmlAnyURI[]resourceIDArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(resourceIDArray, RESOURCEID$0);
        }
    }
    
    /**
     * Sets (as xml) ith "ResourceID" element
     */
    public void xsetResourceIDArray(int i, org.apache.xmlbeans.XmlAnyURI resourceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(RESOURCEID$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(resourceID);
        }
    }
    
    /**
     * Inserts the value as the ith "ResourceID" element
     */
    public void insertResourceID(int i, java.lang.String resourceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(RESOURCEID$0, i);
            target.setStringValue(resourceID);
        }
    }
    
    /**
     * Appends the value as the last "ResourceID" element
     */
    public void addResourceID(java.lang.String resourceID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RESOURCEID$0);
            target.setStringValue(resourceID);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ResourceID" element
     */
    public org.apache.xmlbeans.XmlAnyURI insertNewResourceID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().insert_element_user(RESOURCEID$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ResourceID" element
     */
    public org.apache.xmlbeans.XmlAnyURI addNewResourceID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(RESOURCEID$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "ResourceID" element
     */
    public void removeResourceID(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCEID$0, i);
        }
    }
    
    /**
     * Gets the "OutputFormat" element
     */
    public java.lang.String getOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "OutputFormat" element
     */
    public net.opengis.ows.x11.MimeType xgetOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(OUTPUTFORMAT$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "OutputFormat" element
     */
    public boolean isSetOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OUTPUTFORMAT$2) != 0;
        }
    }
    
    /**
     * Sets the "OutputFormat" element
     */
    public void setOutputFormat(java.lang.String outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OUTPUTFORMAT$2);
            }
            target.setStringValue(outputFormat);
        }
    }
    
    /**
     * Sets (as xml) the "OutputFormat" element
     */
    public void xsetOutputFormat(net.opengis.ows.x11.MimeType outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(OUTPUTFORMAT$2, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.MimeType)get_store().add_element_user(OUTPUTFORMAT$2);
            }
            target.set(outputFormat);
        }
    }
    
    /**
     * Unsets the "OutputFormat" element
     */
    public void unsetOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OUTPUTFORMAT$2, 0);
        }
    }
    
    /**
     * Gets the "service" attribute
     */
    public java.lang.String getService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SERVICE$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "service" attribute
     */
    public net.opengis.ows.x11.ServiceType xgetService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ServiceType target = null;
            target = (net.opengis.ows.x11.ServiceType)get_store().find_attribute_user(SERVICE$4);
            return target;
        }
    }
    
    /**
     * Sets the "service" attribute
     */
    public void setService(java.lang.String service)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SERVICE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SERVICE$4);
            }
            target.setStringValue(service);
        }
    }
    
    /**
     * Sets (as xml) the "service" attribute
     */
    public void xsetService(net.opengis.ows.x11.ServiceType service)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ServiceType target = null;
            target = (net.opengis.ows.x11.ServiceType)get_store().find_attribute_user(SERVICE$4);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ServiceType)get_store().add_attribute_user(SERVICE$4);
            }
            target.set(service);
        }
    }
    
    /**
     * Gets the "version" attribute
     */
    public java.lang.String getVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "version" attribute
     */
    public net.opengis.ows.x11.VersionType xgetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.VersionType target = null;
            target = (net.opengis.ows.x11.VersionType)get_store().find_attribute_user(VERSION$6);
            return target;
        }
    }
    
    /**
     * Sets the "version" attribute
     */
    public void setVersion(java.lang.String version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VERSION$6);
            }
            target.setStringValue(version);
        }
    }
    
    /**
     * Sets (as xml) the "version" attribute
     */
    public void xsetVersion(net.opengis.ows.x11.VersionType version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.VersionType target = null;
            target = (net.opengis.ows.x11.VersionType)get_store().find_attribute_user(VERSION$6);
            if (target == null)
            {
                target = (net.opengis.ows.x11.VersionType)get_store().add_attribute_user(VERSION$6);
            }
            target.set(version);
        }
    }
}

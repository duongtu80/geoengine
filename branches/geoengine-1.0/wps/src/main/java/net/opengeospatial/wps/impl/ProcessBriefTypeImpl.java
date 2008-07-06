/*
 * XML Type:  ProcessBriefType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ProcessBriefType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML ProcessBriefType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class ProcessBriefTypeImpl extends net.opengeospatial.wps.impl.DescriptionTypeImpl implements net.opengeospatial.wps.ProcessBriefType
{
    
    public ProcessBriefTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METADATA$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Metadata");
    private static final javax.xml.namespace.QName PROCESSVERSION$2 = 
        new javax.xml.namespace.QName("", "processVersion");
    
    
    /**
     * Gets array of all "Metadata" elements
     */
    public net.opengeospatial.ows.MetadataType[] getMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$0, targetList);
            net.opengeospatial.ows.MetadataType[] result = new net.opengeospatial.ows.MetadataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType getMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().find_element_user(METADATA$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Metadata" element
     */
    public int sizeOfMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METADATA$0);
        }
    }
    
    /**
     * Sets array of all "Metadata" element
     */
    public void setMetadataArray(net.opengeospatial.ows.MetadataType[] metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$0);
        }
    }
    
    /**
     * Sets ith "Metadata" element
     */
    public void setMetadataArray(int i, net.opengeospatial.ows.MetadataType metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().find_element_user(METADATA$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(metadata);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType insertNewMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().insert_element_user(METADATA$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().add_element_user(METADATA$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Metadata" element
     */
    public void removeMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METADATA$0, i);
        }
    }
    
    /**
     * Gets the "processVersion" attribute
     */
    public java.lang.String getProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROCESSVERSION$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "processVersion" attribute
     */
    public net.opengeospatial.ows.VersionType xgetProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().find_attribute_user(PROCESSVERSION$2);
            return target;
        }
    }
    
    /**
     * True if has "processVersion" attribute
     */
    public boolean isSetProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PROCESSVERSION$2) != null;
        }
    }
    
    /**
     * Sets the "processVersion" attribute
     */
    public void setProcessVersion(java.lang.String processVersion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROCESSVERSION$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROCESSVERSION$2);
            }
            target.setStringValue(processVersion);
        }
    }
    
    /**
     * Sets (as xml) the "processVersion" attribute
     */
    public void xsetProcessVersion(net.opengeospatial.ows.VersionType processVersion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().find_attribute_user(PROCESSVERSION$2);
            if (target == null)
            {
                target = (net.opengeospatial.ows.VersionType)get_store().add_attribute_user(PROCESSVERSION$2);
            }
            target.set(processVersion);
        }
    }
    
    /**
     * Unsets the "processVersion" attribute
     */
    public void unsetProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PROCESSVERSION$2);
        }
    }
}

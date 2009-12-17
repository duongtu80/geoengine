/*
 * XML Type:  DatasetDescriptionSummaryBaseType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.DatasetDescriptionSummaryBaseType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML DatasetDescriptionSummaryBaseType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class DatasetDescriptionSummaryBaseTypeImpl extends net.opengis.ows.x11.impl.DescriptionTypeImpl implements net.opengis.ows.x11.DatasetDescriptionSummaryBaseType
{
    private static final long serialVersionUID = 1L;
    
    public DatasetDescriptionSummaryBaseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WGS84BOUNDINGBOX$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "WGS84BoundingBox");
    private static final javax.xml.namespace.QName IDENTIFIER$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Identifier");
    private static final javax.xml.namespace.QName BOUNDINGBOX$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "BoundingBox");
    private static final org.apache.xmlbeans.QNameSet BOUNDINGBOX$5 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "WGS84BoundingBox"),
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "BoundingBox"),
    });
    private static final javax.xml.namespace.QName METADATA$6 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Metadata");
    private static final javax.xml.namespace.QName DATASETDESCRIPTIONSUMMARY$8 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DatasetDescriptionSummary");
    
    
    /**
     * Gets array of all "WGS84BoundingBox" elements
     */
    public net.opengis.ows.x11.WGS84BoundingBoxType[] getWGS84BoundingBoxArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(WGS84BOUNDINGBOX$0, targetList);
            net.opengis.ows.x11.WGS84BoundingBoxType[] result = new net.opengis.ows.x11.WGS84BoundingBoxType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "WGS84BoundingBox" element
     */
    public net.opengis.ows.x11.WGS84BoundingBoxType getWGS84BoundingBoxArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.WGS84BoundingBoxType target = null;
            target = (net.opengis.ows.x11.WGS84BoundingBoxType)get_store().find_element_user(WGS84BOUNDINGBOX$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "WGS84BoundingBox" element
     */
    public int sizeOfWGS84BoundingBoxArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WGS84BOUNDINGBOX$0);
        }
    }
    
    /**
     * Sets array of all "WGS84BoundingBox" element
     */
    public void setWGS84BoundingBoxArray(net.opengis.ows.x11.WGS84BoundingBoxType[] wgs84BoundingBoxArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(wgs84BoundingBoxArray, WGS84BOUNDINGBOX$0);
        }
    }
    
    /**
     * Sets ith "WGS84BoundingBox" element
     */
    public void setWGS84BoundingBoxArray(int i, net.opengis.ows.x11.WGS84BoundingBoxType wgs84BoundingBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.WGS84BoundingBoxType target = null;
            target = (net.opengis.ows.x11.WGS84BoundingBoxType)get_store().find_element_user(WGS84BOUNDINGBOX$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(wgs84BoundingBox);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "WGS84BoundingBox" element
     */
    public net.opengis.ows.x11.WGS84BoundingBoxType insertNewWGS84BoundingBox(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.WGS84BoundingBoxType target = null;
            target = (net.opengis.ows.x11.WGS84BoundingBoxType)get_store().insert_element_user(WGS84BOUNDINGBOX$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "WGS84BoundingBox" element
     */
    public net.opengis.ows.x11.WGS84BoundingBoxType addNewWGS84BoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.WGS84BoundingBoxType target = null;
            target = (net.opengis.ows.x11.WGS84BoundingBoxType)get_store().add_element_user(WGS84BOUNDINGBOX$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "WGS84BoundingBox" element
     */
    public void removeWGS84BoundingBox(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WGS84BOUNDINGBOX$0, i);
        }
    }
    
    /**
     * Gets the "Identifier" element
     */
    public net.opengis.ows.x11.CodeType getIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(IDENTIFIER$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Identifier" element
     */
    public void setIdentifier(net.opengis.ows.x11.CodeType identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(IDENTIFIER$2, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.CodeType)get_store().add_element_user(IDENTIFIER$2);
            }
            target.set(identifier);
        }
    }
    
    /**
     * Appends and returns a new empty "Identifier" element
     */
    public net.opengis.ows.x11.CodeType addNewIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().add_element_user(IDENTIFIER$2);
            return target;
        }
    }
    
    /**
     * Gets array of all "BoundingBox" elements
     */
    public net.opengis.ows.x11.BoundingBoxType[] getBoundingBoxArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(BOUNDINGBOX$5, targetList);
            net.opengis.ows.x11.BoundingBoxType[] result = new net.opengis.ows.x11.BoundingBoxType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "BoundingBox" element
     */
    public net.opengis.ows.x11.BoundingBoxType getBoundingBoxArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$5, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "BoundingBox" element
     */
    public int sizeOfBoundingBoxArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BOUNDINGBOX$5);
        }
    }
    
    /**
     * Sets array of all "BoundingBox" element
     */
    public void setBoundingBoxArray(net.opengis.ows.x11.BoundingBoxType[] boundingBoxArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(boundingBoxArray, BOUNDINGBOX$4, BOUNDINGBOX$5);
        }
    }
    
    /**
     * Sets ith "BoundingBox" element
     */
    public void setBoundingBoxArray(int i, net.opengis.ows.x11.BoundingBoxType boundingBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$5, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(boundingBox);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "BoundingBox" element
     */
    public net.opengis.ows.x11.BoundingBoxType insertNewBoundingBox(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().insert_element_user(BOUNDINGBOX$5, BOUNDINGBOX$4, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "BoundingBox" element
     */
    public net.opengis.ows.x11.BoundingBoxType addNewBoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().add_element_user(BOUNDINGBOX$4);
            return target;
        }
    }
    
    /**
     * Removes the ith "BoundingBox" element
     */
    public void removeBoundingBox(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BOUNDINGBOX$5, i);
        }
    }
    
    /**
     * Gets array of all "Metadata" elements
     */
    public net.opengis.ows.x11.MetadataType[] getMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$6, targetList);
            net.opengis.ows.x11.MetadataType[] result = new net.opengis.ows.x11.MetadataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Metadata" element
     */
    public net.opengis.ows.x11.MetadataType getMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$6, i);
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
            return get_store().count_elements(METADATA$6);
        }
    }
    
    /**
     * Sets array of all "Metadata" element
     */
    public void setMetadataArray(net.opengis.ows.x11.MetadataType[] metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$6);
        }
    }
    
    /**
     * Sets ith "Metadata" element
     */
    public void setMetadataArray(int i, net.opengis.ows.x11.MetadataType metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$6, i);
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
    public net.opengis.ows.x11.MetadataType insertNewMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().insert_element_user(METADATA$6, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metadata" element
     */
    public net.opengis.ows.x11.MetadataType addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(METADATA$6);
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
            get_store().remove_element(METADATA$6, i);
        }
    }
    
    /**
     * Gets array of all "DatasetDescriptionSummary" elements
     */
    public net.opengis.ows.x11.DatasetDescriptionSummaryBaseType[] getDatasetDescriptionSummaryArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATASETDESCRIPTIONSUMMARY$8, targetList);
            net.opengis.ows.x11.DatasetDescriptionSummaryBaseType[] result = new net.opengis.ows.x11.DatasetDescriptionSummaryBaseType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "DatasetDescriptionSummary" element
     */
    public net.opengis.ows.x11.DatasetDescriptionSummaryBaseType getDatasetDescriptionSummaryArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DatasetDescriptionSummaryBaseType target = null;
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().find_element_user(DATASETDESCRIPTIONSUMMARY$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "DatasetDescriptionSummary" element
     */
    public int sizeOfDatasetDescriptionSummaryArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATASETDESCRIPTIONSUMMARY$8);
        }
    }
    
    /**
     * Sets array of all "DatasetDescriptionSummary" element
     */
    public void setDatasetDescriptionSummaryArray(net.opengis.ows.x11.DatasetDescriptionSummaryBaseType[] datasetDescriptionSummaryArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(datasetDescriptionSummaryArray, DATASETDESCRIPTIONSUMMARY$8);
        }
    }
    
    /**
     * Sets ith "DatasetDescriptionSummary" element
     */
    public void setDatasetDescriptionSummaryArray(int i, net.opengis.ows.x11.DatasetDescriptionSummaryBaseType datasetDescriptionSummary)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DatasetDescriptionSummaryBaseType target = null;
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().find_element_user(DATASETDESCRIPTIONSUMMARY$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(datasetDescriptionSummary);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "DatasetDescriptionSummary" element
     */
    public net.opengis.ows.x11.DatasetDescriptionSummaryBaseType insertNewDatasetDescriptionSummary(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DatasetDescriptionSummaryBaseType target = null;
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().insert_element_user(DATASETDESCRIPTIONSUMMARY$8, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "DatasetDescriptionSummary" element
     */
    public net.opengis.ows.x11.DatasetDescriptionSummaryBaseType addNewDatasetDescriptionSummary()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DatasetDescriptionSummaryBaseType target = null;
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().add_element_user(DATASETDESCRIPTIONSUMMARY$8);
            return target;
        }
    }
    
    /**
     * Removes the ith "DatasetDescriptionSummary" element
     */
    public void removeDatasetDescriptionSummary(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATASETDESCRIPTIONSUMMARY$8, i);
        }
    }
}

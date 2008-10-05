/*
 * XML Type:  ContentsBaseType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ContentsBaseType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML ContentsBaseType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class ContentsBaseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ContentsBaseType
{
    private static final long serialVersionUID = 1L;
    
    public ContentsBaseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATASETDESCRIPTIONSUMMARY$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DatasetDescriptionSummary");
    private static final javax.xml.namespace.QName OTHERSOURCE$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "OtherSource");
    
    
    /**
     * Gets array of all "DatasetDescriptionSummary" elements
     */
    public net.opengis.ows.x11.DatasetDescriptionSummaryBaseType[] getDatasetDescriptionSummaryArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DATASETDESCRIPTIONSUMMARY$0, targetList);
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
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().find_element_user(DATASETDESCRIPTIONSUMMARY$0, i);
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
            return get_store().count_elements(DATASETDESCRIPTIONSUMMARY$0);
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
            arraySetterHelper(datasetDescriptionSummaryArray, DATASETDESCRIPTIONSUMMARY$0);
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
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().find_element_user(DATASETDESCRIPTIONSUMMARY$0, i);
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
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().insert_element_user(DATASETDESCRIPTIONSUMMARY$0, i);
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
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().add_element_user(DATASETDESCRIPTIONSUMMARY$0);
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
            get_store().remove_element(DATASETDESCRIPTIONSUMMARY$0, i);
        }
    }
    
    /**
     * Gets array of all "OtherSource" elements
     */
    public net.opengis.ows.x11.MetadataType[] getOtherSourceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OTHERSOURCE$2, targetList);
            net.opengis.ows.x11.MetadataType[] result = new net.opengis.ows.x11.MetadataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "OtherSource" element
     */
    public net.opengis.ows.x11.MetadataType getOtherSourceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(OTHERSOURCE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "OtherSource" element
     */
    public int sizeOfOtherSourceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OTHERSOURCE$2);
        }
    }
    
    /**
     * Sets array of all "OtherSource" element
     */
    public void setOtherSourceArray(net.opengis.ows.x11.MetadataType[] otherSourceArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(otherSourceArray, OTHERSOURCE$2);
        }
    }
    
    /**
     * Sets ith "OtherSource" element
     */
    public void setOtherSourceArray(int i, net.opengis.ows.x11.MetadataType otherSource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(OTHERSOURCE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(otherSource);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "OtherSource" element
     */
    public net.opengis.ows.x11.MetadataType insertNewOtherSource(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().insert_element_user(OTHERSOURCE$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OtherSource" element
     */
    public net.opengis.ows.x11.MetadataType addNewOtherSource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(OTHERSOURCE$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "OtherSource" element
     */
    public void removeOtherSource(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OTHERSOURCE$2, i);
        }
    }
}

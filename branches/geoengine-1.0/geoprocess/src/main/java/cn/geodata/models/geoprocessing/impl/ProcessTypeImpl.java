/*
 * XML Type:  processType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ProcessType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing.impl;
/**
 * An XML processType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public class ProcessTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.ProcessType
{
    
    public ProcessTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ID$0 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "id");
    private static final javax.xml.namespace.QName TITLE$2 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "title");
    private static final javax.xml.namespace.QName DESCRIBE$4 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "describe");
    private static final javax.xml.namespace.QName TAGS$6 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "tags");
    private static final javax.xml.namespace.QName METADATA$8 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "metadata");
    private static final javax.xml.namespace.QName INPUTS$10 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "inputs");
    private static final javax.xml.namespace.QName OUTPUTS$12 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "outputs");
    
    
    /**
     * Gets the "id" element
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" element
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "id" element
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ID$0);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" element
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ID$0);
            }
            target.set(id);
        }
    }
    
    /**
     * Gets the "title" element
     */
    public java.lang.String getTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "title" element
     */
    public org.apache.xmlbeans.XmlString xgetTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "title" element
     */
    public void setTitle(java.lang.String title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TITLE$2);
            }
            target.setStringValue(title);
        }
    }
    
    /**
     * Sets (as xml) the "title" element
     */
    public void xsetTitle(org.apache.xmlbeans.XmlString title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TITLE$2);
            }
            target.set(title);
        }
    }
    
    /**
     * Gets the "describe" element
     */
    public java.lang.String getDescribe()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIBE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "describe" element
     */
    public org.apache.xmlbeans.XmlString xgetDescribe()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIBE$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "describe" element
     */
    public boolean isSetDescribe()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DESCRIBE$4) != 0;
        }
    }
    
    /**
     * Sets the "describe" element
     */
    public void setDescribe(java.lang.String describe)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIBE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIBE$4);
            }
            target.setStringValue(describe);
        }
    }
    
    /**
     * Sets (as xml) the "describe" element
     */
    public void xsetDescribe(org.apache.xmlbeans.XmlString describe)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIBE$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIBE$4);
            }
            target.set(describe);
        }
    }
    
    /**
     * Unsets the "describe" element
     */
    public void unsetDescribe()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DESCRIBE$4, 0);
        }
    }
    
    /**
     * Gets array of all "tags" elements
     */
    public java.lang.String[] getTagsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(TAGS$6, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "tags" element
     */
    public java.lang.String getTagsArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TAGS$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "tags" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetTagsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(TAGS$6, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "tags" element
     */
    public org.apache.xmlbeans.XmlString xgetTagsArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TAGS$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "tags" element
     */
    public int sizeOfTagsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TAGS$6);
        }
    }
    
    /**
     * Sets array of all "tags" element
     */
    public void setTagsArray(java.lang.String[] tagsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(tagsArray, TAGS$6);
        }
    }
    
    /**
     * Sets ith "tags" element
     */
    public void setTagsArray(int i, java.lang.String tags)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TAGS$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(tags);
        }
    }
    
    /**
     * Sets (as xml) array of all "tags" element
     */
    public void xsetTagsArray(org.apache.xmlbeans.XmlString[]tagsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(tagsArray, TAGS$6);
        }
    }
    
    /**
     * Sets (as xml) ith "tags" element
     */
    public void xsetTagsArray(int i, org.apache.xmlbeans.XmlString tags)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TAGS$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(tags);
        }
    }
    
    /**
     * Inserts the value as the ith "tags" element
     */
    public void insertTags(int i, java.lang.String tags)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(TAGS$6, i);
            target.setStringValue(tags);
        }
    }
    
    /**
     * Appends the value as the last "tags" element
     */
    public void addTags(java.lang.String tags)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TAGS$6);
            target.setStringValue(tags);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "tags" element
     */
    public org.apache.xmlbeans.XmlString insertNewTags(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(TAGS$6, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "tags" element
     */
    public org.apache.xmlbeans.XmlString addNewTags()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TAGS$6);
            return target;
        }
    }
    
    /**
     * Removes the ith "tags" element
     */
    public void removeTags(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TAGS$6, i);
        }
    }
    
    /**
     * Gets array of all "metadata" elements
     */
    public java.lang.String[] getMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$8, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "metadata" element
     */
    public java.lang.String getMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METADATA$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "metadata" elements
     */
    public org.apache.xmlbeans.XmlAnyURI[] xgetMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$8, targetList);
            org.apache.xmlbeans.XmlAnyURI[] result = new org.apache.xmlbeans.XmlAnyURI[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "metadata" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(METADATA$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlAnyURI)target;
        }
    }
    
    /**
     * Returns number of "metadata" element
     */
    public int sizeOfMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METADATA$8);
        }
    }
    
    /**
     * Sets array of all "metadata" element
     */
    public void setMetadataArray(java.lang.String[] metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$8);
        }
    }
    
    /**
     * Sets ith "metadata" element
     */
    public void setMetadataArray(int i, java.lang.String metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METADATA$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(metadata);
        }
    }
    
    /**
     * Sets (as xml) array of all "metadata" element
     */
    public void xsetMetadataArray(org.apache.xmlbeans.XmlAnyURI[]metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$8);
        }
    }
    
    /**
     * Sets (as xml) ith "metadata" element
     */
    public void xsetMetadataArray(int i, org.apache.xmlbeans.XmlAnyURI metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(METADATA$8, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(metadata);
        }
    }
    
    /**
     * Inserts the value as the ith "metadata" element
     */
    public void insertMetadata(int i, java.lang.String metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(METADATA$8, i);
            target.setStringValue(metadata);
        }
    }
    
    /**
     * Appends the value as the last "metadata" element
     */
    public void addMetadata(java.lang.String metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METADATA$8);
            target.setStringValue(metadata);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "metadata" element
     */
    public org.apache.xmlbeans.XmlAnyURI insertNewMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().insert_element_user(METADATA$8, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "metadata" element
     */
    public org.apache.xmlbeans.XmlAnyURI addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(METADATA$8);
            return target;
        }
    }
    
    /**
     * Removes the ith "metadata" element
     */
    public void removeMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METADATA$8, i);
        }
    }
    
    /**
     * Gets the "inputs" element
     */
    public cn.geodata.models.geoprocessing.InputsType getInputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.InputsType target = null;
            target = (cn.geodata.models.geoprocessing.InputsType)get_store().find_element_user(INPUTS$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "inputs" element
     */
    public void setInputs(cn.geodata.models.geoprocessing.InputsType inputs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.InputsType target = null;
            target = (cn.geodata.models.geoprocessing.InputsType)get_store().find_element_user(INPUTS$10, 0);
            if (target == null)
            {
                target = (cn.geodata.models.geoprocessing.InputsType)get_store().add_element_user(INPUTS$10);
            }
            target.set(inputs);
        }
    }
    
    /**
     * Appends and returns a new empty "inputs" element
     */
    public cn.geodata.models.geoprocessing.InputsType addNewInputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.InputsType target = null;
            target = (cn.geodata.models.geoprocessing.InputsType)get_store().add_element_user(INPUTS$10);
            return target;
        }
    }
    
    /**
     * Gets the "outputs" element
     */
    public cn.geodata.models.geoprocessing.OutputsType getOutputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.OutputsType target = null;
            target = (cn.geodata.models.geoprocessing.OutputsType)get_store().find_element_user(OUTPUTS$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "outputs" element
     */
    public void setOutputs(cn.geodata.models.geoprocessing.OutputsType outputs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.OutputsType target = null;
            target = (cn.geodata.models.geoprocessing.OutputsType)get_store().find_element_user(OUTPUTS$12, 0);
            if (target == null)
            {
                target = (cn.geodata.models.geoprocessing.OutputsType)get_store().add_element_user(OUTPUTS$12);
            }
            target.set(outputs);
        }
    }
    
    /**
     * Appends and returns a new empty "outputs" element
     */
    public cn.geodata.models.geoprocessing.OutputsType addNewOutputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.OutputsType target = null;
            target = (cn.geodata.models.geoprocessing.OutputsType)get_store().add_element_user(OUTPUTS$12);
            return target;
        }
    }
}

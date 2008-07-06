/*
 * XML Type:  outputsType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.OutputsType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing.impl;
/**
 * An XML outputsType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public class OutputsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.OutputsType
{
    
    public OutputsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUTPUT$0 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "output");
    
    
    /**
     * Gets array of all "output" elements
     */
    public cn.geodata.models.geoprocessing.ValueType[] getOutputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OUTPUT$0, targetList);
            cn.geodata.models.geoprocessing.ValueType[] result = new cn.geodata.models.geoprocessing.ValueType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "output" element
     */
    public cn.geodata.models.geoprocessing.ValueType getOutputArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ValueType target = null;
            target = (cn.geodata.models.geoprocessing.ValueType)get_store().find_element_user(OUTPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "output" element
     */
    public int sizeOfOutputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OUTPUT$0);
        }
    }
    
    /**
     * Sets array of all "output" element
     */
    public void setOutputArray(cn.geodata.models.geoprocessing.ValueType[] outputArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(outputArray, OUTPUT$0);
        }
    }
    
    /**
     * Sets ith "output" element
     */
    public void setOutputArray(int i, cn.geodata.models.geoprocessing.ValueType output)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ValueType target = null;
            target = (cn.geodata.models.geoprocessing.ValueType)get_store().find_element_user(OUTPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(output);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "output" element
     */
    public cn.geodata.models.geoprocessing.ValueType insertNewOutput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ValueType target = null;
            target = (cn.geodata.models.geoprocessing.ValueType)get_store().insert_element_user(OUTPUT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "output" element
     */
    public cn.geodata.models.geoprocessing.ValueType addNewOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ValueType target = null;
            target = (cn.geodata.models.geoprocessing.ValueType)get_store().add_element_user(OUTPUT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "output" element
     */
    public void removeOutput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OUTPUT$0, i);
        }
    }
}

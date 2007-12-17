/*
 * XML Type:  inputsType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.InputsType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing.impl;
/**
 * An XML inputsType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public class InputsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.InputsType
{
    
    public InputsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INPUT$0 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "input");
    
    
    /**
     * Gets array of all "input" elements
     */
    public cn.geodata.models.geoprocessing.ValueType[] getInputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(INPUT$0, targetList);
            cn.geodata.models.geoprocessing.ValueType[] result = new cn.geodata.models.geoprocessing.ValueType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "input" element
     */
    public cn.geodata.models.geoprocessing.ValueType getInputArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ValueType target = null;
            target = (cn.geodata.models.geoprocessing.ValueType)get_store().find_element_user(INPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "input" element
     */
    public int sizeOfInputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INPUT$0);
        }
    }
    
    /**
     * Sets array of all "input" element
     */
    public void setInputArray(cn.geodata.models.geoprocessing.ValueType[] inputArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(inputArray, INPUT$0);
        }
    }
    
    /**
     * Sets ith "input" element
     */
    public void setInputArray(int i, cn.geodata.models.geoprocessing.ValueType input)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ValueType target = null;
            target = (cn.geodata.models.geoprocessing.ValueType)get_store().find_element_user(INPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(input);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "input" element
     */
    public cn.geodata.models.geoprocessing.ValueType insertNewInput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ValueType target = null;
            target = (cn.geodata.models.geoprocessing.ValueType)get_store().insert_element_user(INPUT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "input" element
     */
    public cn.geodata.models.geoprocessing.ValueType addNewInput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ValueType target = null;
            target = (cn.geodata.models.geoprocessing.ValueType)get_store().add_element_user(INPUT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "input" element
     */
    public void removeInput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INPUT$0, i);
        }
    }
}

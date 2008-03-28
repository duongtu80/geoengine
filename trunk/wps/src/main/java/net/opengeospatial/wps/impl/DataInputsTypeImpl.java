/*
 * XML Type:  DataInputsType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.DataInputsType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML DataInputsType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class DataInputsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.DataInputsType
{
    
    public DataInputsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INPUT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Input");
    
    
    /**
     * Gets array of all "Input" elements
     */
    public net.opengeospatial.wps.IOValueType[] getInputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(INPUT$0, targetList);
            net.opengeospatial.wps.IOValueType[] result = new net.opengeospatial.wps.IOValueType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Input" element
     */
    public net.opengeospatial.wps.IOValueType getInputArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.IOValueType target = null;
            target = (net.opengeospatial.wps.IOValueType)get_store().find_element_user(INPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Input" element
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
     * Sets array of all "Input" element
     */
    public void setInputArray(net.opengeospatial.wps.IOValueType[] inputArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(inputArray, INPUT$0);
        }
    }
    
    /**
     * Sets ith "Input" element
     */
    public void setInputArray(int i, net.opengeospatial.wps.IOValueType input)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.IOValueType target = null;
            target = (net.opengeospatial.wps.IOValueType)get_store().find_element_user(INPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(input);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Input" element
     */
    public net.opengeospatial.wps.IOValueType insertNewInput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.IOValueType target = null;
            target = (net.opengeospatial.wps.IOValueType)get_store().insert_element_user(INPUT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Input" element
     */
    public net.opengeospatial.wps.IOValueType addNewInput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.IOValueType target = null;
            target = (net.opengeospatial.wps.IOValueType)get_store().add_element_user(INPUT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Input" element
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

/*
 * XML Type:  DataInputsType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.DataInputsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML DataInputsType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class DataInputsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.DataInputsType
{
    private static final long serialVersionUID = 1L;
    
    public DataInputsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INPUT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Input");
    
    
    /**
     * Gets array of all "Input" elements
     */
    public net.opengis.wps.x100.InputType[] getInputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(INPUT$0, targetList);
            net.opengis.wps.x100.InputType[] result = new net.opengis.wps.x100.InputType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Input" element
     */
    public net.opengis.wps.x100.InputType getInputArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.InputType target = null;
            target = (net.opengis.wps.x100.InputType)get_store().find_element_user(INPUT$0, i);
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
    public void setInputArray(net.opengis.wps.x100.InputType[] inputArray)
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
    public void setInputArray(int i, net.opengis.wps.x100.InputType input)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.InputType target = null;
            target = (net.opengis.wps.x100.InputType)get_store().find_element_user(INPUT$0, i);
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
    public net.opengis.wps.x100.InputType insertNewInput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.InputType target = null;
            target = (net.opengis.wps.x100.InputType)get_store().insert_element_user(INPUT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Input" element
     */
    public net.opengis.wps.x100.InputType addNewInput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.InputType target = null;
            target = (net.opengis.wps.x100.InputType)get_store().add_element_user(INPUT$0);
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

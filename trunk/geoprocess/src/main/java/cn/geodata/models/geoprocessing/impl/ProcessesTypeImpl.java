/*
 * XML Type:  processesType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ProcessesType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing.impl;
/**
 * An XML processesType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public class ProcessesTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.ProcessesType
{
    
    public ProcessesTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESS$0 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "process");
    
    
    /**
     * Gets array of all "process" elements
     */
    public cn.geodata.models.geoprocessing.ProcessType[] getProcessArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(PROCESS$0, targetList);
            cn.geodata.models.geoprocessing.ProcessType[] result = new cn.geodata.models.geoprocessing.ProcessType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "process" element
     */
    public cn.geodata.models.geoprocessing.ProcessType getProcessArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().find_element_user(PROCESS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "process" element
     */
    public int sizeOfProcessArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESS$0);
        }
    }
    
    /**
     * Sets array of all "process" element
     */
    public void setProcessArray(cn.geodata.models.geoprocessing.ProcessType[] processArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(processArray, PROCESS$0);
        }
    }
    
    /**
     * Sets ith "process" element
     */
    public void setProcessArray(int i, cn.geodata.models.geoprocessing.ProcessType process)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().find_element_user(PROCESS$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(process);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "process" element
     */
    public cn.geodata.models.geoprocessing.ProcessType insertNewProcess(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().insert_element_user(PROCESS$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "process" element
     */
    public cn.geodata.models.geoprocessing.ProcessType addNewProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().add_element_user(PROCESS$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "process" element
     */
    public void removeProcess(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESS$0, i);
        }
    }
}

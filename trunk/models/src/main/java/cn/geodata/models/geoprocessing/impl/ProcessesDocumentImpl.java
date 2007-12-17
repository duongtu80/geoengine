/*
 * An XML document type.
 * Localname: processes
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ProcessesDocument
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing.impl;
/**
 * A document containing one processes(@http://www.geodata.cn/models/geoprocessing) element.
 *
 * This is a complex type.
 */
public class ProcessesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.ProcessesDocument
{
    
    public ProcessesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSES$0 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "processes");
    
    
    /**
     * Gets the "processes" element
     */
    public cn.geodata.models.geoprocessing.ProcessesType getProcesses()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessesType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessesType)get_store().find_element_user(PROCESSES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "processes" element
     */
    public void setProcesses(cn.geodata.models.geoprocessing.ProcessesType processes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessesType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessesType)get_store().find_element_user(PROCESSES$0, 0);
            if (target == null)
            {
                target = (cn.geodata.models.geoprocessing.ProcessesType)get_store().add_element_user(PROCESSES$0);
            }
            target.set(processes);
        }
    }
    
    /**
     * Appends and returns a new empty "processes" element
     */
    public cn.geodata.models.geoprocessing.ProcessesType addNewProcesses()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessesType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessesType)get_store().add_element_user(PROCESSES$0);
            return target;
        }
    }
}

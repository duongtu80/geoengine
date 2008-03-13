/*
 * An XML document type.
 * Localname: process
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ProcessDocument
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing.impl;
/**
 * A document containing one process(@http://www.geodata.cn/models/geoprocessing) element.
 *
 * This is a complex type.
 */
public class ProcessDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.ProcessDocument
{
    
    public ProcessDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESS$0 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "process");
    
    
    /**
     * Gets the "process" element
     */
    public cn.geodata.models.geoprocessing.ProcessType getProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().find_element_user(PROCESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "process" element
     */
    public void setProcess(cn.geodata.models.geoprocessing.ProcessType process)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().find_element_user(PROCESS$0, 0);
            if (target == null)
            {
                target = (cn.geodata.models.geoprocessing.ProcessType)get_store().add_element_user(PROCESS$0);
            }
            target.set(process);
        }
    }
    
    /**
     * Appends and returns a new empty "process" element
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
}

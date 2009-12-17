/*
 * XML Type:  OutputDefinitionsType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.OutputDefinitionsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML OutputDefinitionsType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class OutputDefinitionsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.OutputDefinitionsType
{
    private static final long serialVersionUID = 1L;
    
    public OutputDefinitionsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUTPUT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Output");
    
    
    /**
     * Gets array of all "Output" elements
     */
    public net.opengis.wps.x100.DocumentOutputDefinitionType[] getOutputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OUTPUT$0, targetList);
            net.opengis.wps.x100.DocumentOutputDefinitionType[] result = new net.opengis.wps.x100.DocumentOutputDefinitionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Output" element
     */
    public net.opengis.wps.x100.DocumentOutputDefinitionType getOutputArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DocumentOutputDefinitionType target = null;
            target = (net.opengis.wps.x100.DocumentOutputDefinitionType)get_store().find_element_user(OUTPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Output" element
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
     * Sets array of all "Output" element
     */
    public void setOutputArray(net.opengis.wps.x100.DocumentOutputDefinitionType[] outputArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(outputArray, OUTPUT$0);
        }
    }
    
    /**
     * Sets ith "Output" element
     */
    public void setOutputArray(int i, net.opengis.wps.x100.DocumentOutputDefinitionType output)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DocumentOutputDefinitionType target = null;
            target = (net.opengis.wps.x100.DocumentOutputDefinitionType)get_store().find_element_user(OUTPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(output);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Output" element
     */
    public net.opengis.wps.x100.DocumentOutputDefinitionType insertNewOutput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DocumentOutputDefinitionType target = null;
            target = (net.opengis.wps.x100.DocumentOutputDefinitionType)get_store().insert_element_user(OUTPUT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Output" element
     */
    public net.opengis.wps.x100.DocumentOutputDefinitionType addNewOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DocumentOutputDefinitionType target = null;
            target = (net.opengis.wps.x100.DocumentOutputDefinitionType)get_store().add_element_user(OUTPUT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Output" element
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

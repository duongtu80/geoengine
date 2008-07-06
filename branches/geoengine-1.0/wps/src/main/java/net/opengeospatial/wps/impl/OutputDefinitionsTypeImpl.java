/*
 * XML Type:  OutputDefinitionsType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.OutputDefinitionsType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML OutputDefinitionsType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class OutputDefinitionsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.OutputDefinitionsType
{
    
    public OutputDefinitionsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUTPUT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Output");
    
    
    /**
     * Gets array of all "Output" elements
     */
    public net.opengeospatial.wps.OutputDefinitionType[] getOutputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OUTPUT$0, targetList);
            net.opengeospatial.wps.OutputDefinitionType[] result = new net.opengeospatial.wps.OutputDefinitionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Output" element
     */
    public net.opengeospatial.wps.OutputDefinitionType getOutputArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.OutputDefinitionType target = null;
            target = (net.opengeospatial.wps.OutputDefinitionType)get_store().find_element_user(OUTPUT$0, i);
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
    public void setOutputArray(net.opengeospatial.wps.OutputDefinitionType[] outputArray)
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
    public void setOutputArray(int i, net.opengeospatial.wps.OutputDefinitionType output)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.OutputDefinitionType target = null;
            target = (net.opengeospatial.wps.OutputDefinitionType)get_store().find_element_user(OUTPUT$0, i);
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
    public net.opengeospatial.wps.OutputDefinitionType insertNewOutput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.OutputDefinitionType target = null;
            target = (net.opengeospatial.wps.OutputDefinitionType)get_store().insert_element_user(OUTPUT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Output" element
     */
    public net.opengeospatial.wps.OutputDefinitionType addNewOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.OutputDefinitionType target = null;
            target = (net.opengeospatial.wps.OutputDefinitionType)get_store().add_element_user(OUTPUT$0);
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

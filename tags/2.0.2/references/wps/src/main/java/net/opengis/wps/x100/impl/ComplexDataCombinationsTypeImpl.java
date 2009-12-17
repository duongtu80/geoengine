/*
 * XML Type:  ComplexDataCombinationsType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ComplexDataCombinationsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ComplexDataCombinationsType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class ComplexDataCombinationsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ComplexDataCombinationsType
{
    private static final long serialVersionUID = 1L;
    
    public ComplexDataCombinationsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMAT$0 = 
        new javax.xml.namespace.QName("", "Format");
    
    
    /**
     * Gets array of all "Format" elements
     */
    public net.opengis.wps.x100.ComplexDataDescriptionType[] getFormatArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(FORMAT$0, targetList);
            net.opengis.wps.x100.ComplexDataDescriptionType[] result = new net.opengis.wps.x100.ComplexDataDescriptionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Format" element
     */
    public net.opengis.wps.x100.ComplexDataDescriptionType getFormatArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataDescriptionType target = null;
            target = (net.opengis.wps.x100.ComplexDataDescriptionType)get_store().find_element_user(FORMAT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Format" element
     */
    public int sizeOfFormatArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FORMAT$0);
        }
    }
    
    /**
     * Sets array of all "Format" element
     */
    public void setFormatArray(net.opengis.wps.x100.ComplexDataDescriptionType[] formatArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(formatArray, FORMAT$0);
        }
    }
    
    /**
     * Sets ith "Format" element
     */
    public void setFormatArray(int i, net.opengis.wps.x100.ComplexDataDescriptionType format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataDescriptionType target = null;
            target = (net.opengis.wps.x100.ComplexDataDescriptionType)get_store().find_element_user(FORMAT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(format);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Format" element
     */
    public net.opengis.wps.x100.ComplexDataDescriptionType insertNewFormat(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataDescriptionType target = null;
            target = (net.opengis.wps.x100.ComplexDataDescriptionType)get_store().insert_element_user(FORMAT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Format" element
     */
    public net.opengis.wps.x100.ComplexDataDescriptionType addNewFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataDescriptionType target = null;
            target = (net.opengis.wps.x100.ComplexDataDescriptionType)get_store().add_element_user(FORMAT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Format" element
     */
    public void removeFormat(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FORMAT$0, i);
        }
    }
}

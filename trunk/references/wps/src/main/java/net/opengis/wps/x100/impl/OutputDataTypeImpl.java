/*
 * XML Type:  OutputDataType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.OutputDataType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML OutputDataType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class OutputDataTypeImpl extends net.opengis.wps.x100.impl.DescriptionTypeImpl implements net.opengis.wps.x100.OutputDataType
{
    private static final long serialVersionUID = 1L;
    
    public OutputDataTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Reference");
    private static final javax.xml.namespace.QName DATA$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Data");
    
    
    /**
     * Gets the "Reference" element
     */
    public net.opengis.wps.x100.OutputReferenceType getReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.OutputReferenceType target = null;
            target = (net.opengis.wps.x100.OutputReferenceType)get_store().find_element_user(REFERENCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Reference" element
     */
    public boolean isSetReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REFERENCE$0) != 0;
        }
    }
    
    /**
     * Sets the "Reference" element
     */
    public void setReference(net.opengis.wps.x100.OutputReferenceType reference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.OutputReferenceType target = null;
            target = (net.opengis.wps.x100.OutputReferenceType)get_store().find_element_user(REFERENCE$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.OutputReferenceType)get_store().add_element_user(REFERENCE$0);
            }
            target.set(reference);
        }
    }
    
    /**
     * Appends and returns a new empty "Reference" element
     */
    public net.opengis.wps.x100.OutputReferenceType addNewReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.OutputReferenceType target = null;
            target = (net.opengis.wps.x100.OutputReferenceType)get_store().add_element_user(REFERENCE$0);
            return target;
        }
    }
    
    /**
     * Unsets the "Reference" element
     */
    public void unsetReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REFERENCE$0, 0);
        }
    }
    
    /**
     * Gets the "Data" element
     */
    public net.opengis.wps.x100.DataType getData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DataType target = null;
            target = (net.opengis.wps.x100.DataType)get_store().find_element_user(DATA$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Data" element
     */
    public boolean isSetData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATA$2) != 0;
        }
    }
    
    /**
     * Sets the "Data" element
     */
    public void setData(net.opengis.wps.x100.DataType data)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DataType target = null;
            target = (net.opengis.wps.x100.DataType)get_store().find_element_user(DATA$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.DataType)get_store().add_element_user(DATA$2);
            }
            target.set(data);
        }
    }
    
    /**
     * Appends and returns a new empty "Data" element
     */
    public net.opengis.wps.x100.DataType addNewData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DataType target = null;
            target = (net.opengis.wps.x100.DataType)get_store().add_element_user(DATA$2);
            return target;
        }
    }
    
    /**
     * Unsets the "Data" element
     */
    public void unsetData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATA$2, 0);
        }
    }
}

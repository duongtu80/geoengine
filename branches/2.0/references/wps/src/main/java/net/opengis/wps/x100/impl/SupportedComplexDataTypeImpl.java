/*
 * XML Type:  SupportedComplexDataType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.SupportedComplexDataType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML SupportedComplexDataType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class SupportedComplexDataTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.SupportedComplexDataType
{
    private static final long serialVersionUID = 1L;
    
    public SupportedComplexDataTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEFAULT$0 = 
        new javax.xml.namespace.QName("", "Default");
    private static final javax.xml.namespace.QName SUPPORTED$2 = 
        new javax.xml.namespace.QName("", "Supported");
    
    
    /**
     * Gets the "Default" element
     */
    public net.opengis.wps.x100.ComplexDataCombinationType getDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataCombinationType target = null;
            target = (net.opengis.wps.x100.ComplexDataCombinationType)get_store().find_element_user(DEFAULT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Default" element
     */
    public void setDefault(net.opengis.wps.x100.ComplexDataCombinationType xdefault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataCombinationType target = null;
            target = (net.opengis.wps.x100.ComplexDataCombinationType)get_store().find_element_user(DEFAULT$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ComplexDataCombinationType)get_store().add_element_user(DEFAULT$0);
            }
            target.set(xdefault);
        }
    }
    
    /**
     * Appends and returns a new empty "Default" element
     */
    public net.opengis.wps.x100.ComplexDataCombinationType addNewDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataCombinationType target = null;
            target = (net.opengis.wps.x100.ComplexDataCombinationType)get_store().add_element_user(DEFAULT$0);
            return target;
        }
    }
    
    /**
     * Gets the "Supported" element
     */
    public net.opengis.wps.x100.ComplexDataCombinationsType getSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataCombinationsType target = null;
            target = (net.opengis.wps.x100.ComplexDataCombinationsType)get_store().find_element_user(SUPPORTED$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Supported" element
     */
    public void setSupported(net.opengis.wps.x100.ComplexDataCombinationsType supported)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataCombinationsType target = null;
            target = (net.opengis.wps.x100.ComplexDataCombinationsType)get_store().find_element_user(SUPPORTED$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ComplexDataCombinationsType)get_store().add_element_user(SUPPORTED$2);
            }
            target.set(supported);
        }
    }
    
    /**
     * Appends and returns a new empty "Supported" element
     */
    public net.opengis.wps.x100.ComplexDataCombinationsType addNewSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataCombinationsType target = null;
            target = (net.opengis.wps.x100.ComplexDataCombinationsType)get_store().add_element_user(SUPPORTED$2);
            return target;
        }
    }
}

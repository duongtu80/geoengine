/*
 * XML Type:  ComplexDataCombinationType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ComplexDataCombinationType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ComplexDataCombinationType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class ComplexDataCombinationTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ComplexDataCombinationType
{
    private static final long serialVersionUID = 1L;
    
    public ComplexDataCombinationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMAT$0 = 
        new javax.xml.namespace.QName("", "Format");
    
    
    /**
     * Gets the "Format" element
     */
    public net.opengis.wps.x100.ComplexDataDescriptionType getFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataDescriptionType target = null;
            target = (net.opengis.wps.x100.ComplexDataDescriptionType)get_store().find_element_user(FORMAT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Format" element
     */
    public void setFormat(net.opengis.wps.x100.ComplexDataDescriptionType format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ComplexDataDescriptionType target = null;
            target = (net.opengis.wps.x100.ComplexDataDescriptionType)get_store().find_element_user(FORMAT$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ComplexDataDescriptionType)get_store().add_element_user(FORMAT$0);
            }
            target.set(format);
        }
    }
    
    /**
     * Appends and returns a new empty "Format" element
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
}

/*
 * XML Type:  OutputDescriptionType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.OutputDescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML OutputDescriptionType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class OutputDescriptionTypeImpl extends net.opengeospatial.wps.impl.DescriptionTypeImpl implements net.opengeospatial.wps.OutputDescriptionType
{
    
    public OutputDescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPLEXOUTPUT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ComplexOutput");
    private static final javax.xml.namespace.QName LITERALOUTPUT$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "LiteralOutput");
    private static final javax.xml.namespace.QName BOUNDINGBOXOUTPUT$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "BoundingBoxOutput");
    
    
    /**
     * Gets the "ComplexOutput" element
     */
    public net.opengeospatial.wps.SupportedComplexDataType getComplexOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedComplexDataType target = null;
            target = (net.opengeospatial.wps.SupportedComplexDataType)get_store().find_element_user(COMPLEXOUTPUT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ComplexOutput" element
     */
    public boolean isSetComplexOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(COMPLEXOUTPUT$0) != 0;
        }
    }
    
    /**
     * Sets the "ComplexOutput" element
     */
    public void setComplexOutput(net.opengeospatial.wps.SupportedComplexDataType complexOutput)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedComplexDataType target = null;
            target = (net.opengeospatial.wps.SupportedComplexDataType)get_store().find_element_user(COMPLEXOUTPUT$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.SupportedComplexDataType)get_store().add_element_user(COMPLEXOUTPUT$0);
            }
            target.set(complexOutput);
        }
    }
    
    /**
     * Appends and returns a new empty "ComplexOutput" element
     */
    public net.opengeospatial.wps.SupportedComplexDataType addNewComplexOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedComplexDataType target = null;
            target = (net.opengeospatial.wps.SupportedComplexDataType)get_store().add_element_user(COMPLEXOUTPUT$0);
            return target;
        }
    }
    
    /**
     * Unsets the "ComplexOutput" element
     */
    public void unsetComplexOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(COMPLEXOUTPUT$0, 0);
        }
    }
    
    /**
     * Gets the "LiteralOutput" element
     */
    public net.opengeospatial.wps.LiteralOutputType getLiteralOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralOutputType target = null;
            target = (net.opengeospatial.wps.LiteralOutputType)get_store().find_element_user(LITERALOUTPUT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "LiteralOutput" element
     */
    public boolean isSetLiteralOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LITERALOUTPUT$2) != 0;
        }
    }
    
    /**
     * Sets the "LiteralOutput" element
     */
    public void setLiteralOutput(net.opengeospatial.wps.LiteralOutputType literalOutput)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralOutputType target = null;
            target = (net.opengeospatial.wps.LiteralOutputType)get_store().find_element_user(LITERALOUTPUT$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.LiteralOutputType)get_store().add_element_user(LITERALOUTPUT$2);
            }
            target.set(literalOutput);
        }
    }
    
    /**
     * Appends and returns a new empty "LiteralOutput" element
     */
    public net.opengeospatial.wps.LiteralOutputType addNewLiteralOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralOutputType target = null;
            target = (net.opengeospatial.wps.LiteralOutputType)get_store().add_element_user(LITERALOUTPUT$2);
            return target;
        }
    }
    
    /**
     * Unsets the "LiteralOutput" element
     */
    public void unsetLiteralOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LITERALOUTPUT$2, 0);
        }
    }
    
    /**
     * Gets the "BoundingBoxOutput" element
     */
    public net.opengeospatial.wps.SupportedCRSsType getBoundingBoxOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedCRSsType target = null;
            target = (net.opengeospatial.wps.SupportedCRSsType)get_store().find_element_user(BOUNDINGBOXOUTPUT$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "BoundingBoxOutput" element
     */
    public boolean isSetBoundingBoxOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BOUNDINGBOXOUTPUT$4) != 0;
        }
    }
    
    /**
     * Sets the "BoundingBoxOutput" element
     */
    public void setBoundingBoxOutput(net.opengeospatial.wps.SupportedCRSsType boundingBoxOutput)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedCRSsType target = null;
            target = (net.opengeospatial.wps.SupportedCRSsType)get_store().find_element_user(BOUNDINGBOXOUTPUT$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.SupportedCRSsType)get_store().add_element_user(BOUNDINGBOXOUTPUT$4);
            }
            target.set(boundingBoxOutput);
        }
    }
    
    /**
     * Appends and returns a new empty "BoundingBoxOutput" element
     */
    public net.opengeospatial.wps.SupportedCRSsType addNewBoundingBoxOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedCRSsType target = null;
            target = (net.opengeospatial.wps.SupportedCRSsType)get_store().add_element_user(BOUNDINGBOXOUTPUT$4);
            return target;
        }
    }
    
    /**
     * Unsets the "BoundingBoxOutput" element
     */
    public void unsetBoundingBoxOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BOUNDINGBOXOUTPUT$4, 0);
        }
    }
}

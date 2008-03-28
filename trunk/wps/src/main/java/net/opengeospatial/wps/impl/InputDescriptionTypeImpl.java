/*
 * XML Type:  InputDescriptionType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.InputDescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML InputDescriptionType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class InputDescriptionTypeImpl extends net.opengeospatial.wps.impl.DescriptionTypeImpl implements net.opengeospatial.wps.InputDescriptionType
{
    
    public InputDescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPLEXDATA$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ComplexData");
    private static final javax.xml.namespace.QName LITERALDATA$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "LiteralData");
    private static final javax.xml.namespace.QName BOUNDINGBOXDATA$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "BoundingBoxData");
    private static final javax.xml.namespace.QName MINIMUMOCCURS$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "MinimumOccurs");
    
    
    /**
     * Gets the "ComplexData" element
     */
    public net.opengeospatial.wps.SupportedComplexDataType getComplexData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedComplexDataType target = null;
            target = (net.opengeospatial.wps.SupportedComplexDataType)get_store().find_element_user(COMPLEXDATA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ComplexData" element
     */
    public boolean isSetComplexData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(COMPLEXDATA$0) != 0;
        }
    }
    
    /**
     * Sets the "ComplexData" element
     */
    public void setComplexData(net.opengeospatial.wps.SupportedComplexDataType complexData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedComplexDataType target = null;
            target = (net.opengeospatial.wps.SupportedComplexDataType)get_store().find_element_user(COMPLEXDATA$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.SupportedComplexDataType)get_store().add_element_user(COMPLEXDATA$0);
            }
            target.set(complexData);
        }
    }
    
    /**
     * Appends and returns a new empty "ComplexData" element
     */
    public net.opengeospatial.wps.SupportedComplexDataType addNewComplexData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedComplexDataType target = null;
            target = (net.opengeospatial.wps.SupportedComplexDataType)get_store().add_element_user(COMPLEXDATA$0);
            return target;
        }
    }
    
    /**
     * Unsets the "ComplexData" element
     */
    public void unsetComplexData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(COMPLEXDATA$0, 0);
        }
    }
    
    /**
     * Gets the "LiteralData" element
     */
    public net.opengeospatial.wps.LiteralInputType getLiteralData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralInputType target = null;
            target = (net.opengeospatial.wps.LiteralInputType)get_store().find_element_user(LITERALDATA$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "LiteralData" element
     */
    public boolean isSetLiteralData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LITERALDATA$2) != 0;
        }
    }
    
    /**
     * Sets the "LiteralData" element
     */
    public void setLiteralData(net.opengeospatial.wps.LiteralInputType literalData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralInputType target = null;
            target = (net.opengeospatial.wps.LiteralInputType)get_store().find_element_user(LITERALDATA$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.LiteralInputType)get_store().add_element_user(LITERALDATA$2);
            }
            target.set(literalData);
        }
    }
    
    /**
     * Appends and returns a new empty "LiteralData" element
     */
    public net.opengeospatial.wps.LiteralInputType addNewLiteralData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralInputType target = null;
            target = (net.opengeospatial.wps.LiteralInputType)get_store().add_element_user(LITERALDATA$2);
            return target;
        }
    }
    
    /**
     * Unsets the "LiteralData" element
     */
    public void unsetLiteralData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LITERALDATA$2, 0);
        }
    }
    
    /**
     * Gets the "BoundingBoxData" element
     */
    public net.opengeospatial.wps.SupportedCRSsType getBoundingBoxData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedCRSsType target = null;
            target = (net.opengeospatial.wps.SupportedCRSsType)get_store().find_element_user(BOUNDINGBOXDATA$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "BoundingBoxData" element
     */
    public boolean isSetBoundingBoxData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BOUNDINGBOXDATA$4) != 0;
        }
    }
    
    /**
     * Sets the "BoundingBoxData" element
     */
    public void setBoundingBoxData(net.opengeospatial.wps.SupportedCRSsType boundingBoxData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedCRSsType target = null;
            target = (net.opengeospatial.wps.SupportedCRSsType)get_store().find_element_user(BOUNDINGBOXDATA$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.SupportedCRSsType)get_store().add_element_user(BOUNDINGBOXDATA$4);
            }
            target.set(boundingBoxData);
        }
    }
    
    /**
     * Appends and returns a new empty "BoundingBoxData" element
     */
    public net.opengeospatial.wps.SupportedCRSsType addNewBoundingBoxData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.SupportedCRSsType target = null;
            target = (net.opengeospatial.wps.SupportedCRSsType)get_store().add_element_user(BOUNDINGBOXDATA$4);
            return target;
        }
    }
    
    /**
     * Unsets the "BoundingBoxData" element
     */
    public void unsetBoundingBoxData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BOUNDINGBOXDATA$4, 0);
        }
    }
    
    /**
     * Gets the "MinimumOccurs" element
     */
    public java.math.BigInteger getMinimumOccurs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MINIMUMOCCURS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "MinimumOccurs" element
     */
    public net.opengeospatial.wps.InputDescriptionType.MinimumOccurs xgetMinimumOccurs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.InputDescriptionType.MinimumOccurs target = null;
            target = (net.opengeospatial.wps.InputDescriptionType.MinimumOccurs)get_store().find_element_user(MINIMUMOCCURS$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "MinimumOccurs" element
     */
    public boolean isSetMinimumOccurs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MINIMUMOCCURS$6) != 0;
        }
    }
    
    /**
     * Sets the "MinimumOccurs" element
     */
    public void setMinimumOccurs(java.math.BigInteger minimumOccurs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MINIMUMOCCURS$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MINIMUMOCCURS$6);
            }
            target.setBigIntegerValue(minimumOccurs);
        }
    }
    
    /**
     * Sets (as xml) the "MinimumOccurs" element
     */
    public void xsetMinimumOccurs(net.opengeospatial.wps.InputDescriptionType.MinimumOccurs minimumOccurs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.InputDescriptionType.MinimumOccurs target = null;
            target = (net.opengeospatial.wps.InputDescriptionType.MinimumOccurs)get_store().find_element_user(MINIMUMOCCURS$6, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.InputDescriptionType.MinimumOccurs)get_store().add_element_user(MINIMUMOCCURS$6);
            }
            target.set(minimumOccurs);
        }
    }
    
    /**
     * Unsets the "MinimumOccurs" element
     */
    public void unsetMinimumOccurs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MINIMUMOCCURS$6, 0);
        }
    }
    /**
     * An XML MinimumOccurs(@http://www.opengeospatial.net/wps).
     *
     * This is an atomic type that is a restriction of net.opengeospatial.wps.InputDescriptionType$MinimumOccurs.
     */
    public static class MinimumOccursImpl extends org.apache.xmlbeans.impl.values.JavaIntegerHolderEx implements net.opengeospatial.wps.InputDescriptionType.MinimumOccurs
    {
        
        public MinimumOccursImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected MinimumOccursImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}

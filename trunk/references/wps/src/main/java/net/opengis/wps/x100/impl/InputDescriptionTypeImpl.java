/*
 * XML Type:  InputDescriptionType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.InputDescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML InputDescriptionType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class InputDescriptionTypeImpl extends net.opengis.wps.x100.impl.DescriptionTypeImpl implements net.opengis.wps.x100.InputDescriptionType
{
    private static final long serialVersionUID = 1L;
    
    public InputDescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPLEXDATA$0 = 
        new javax.xml.namespace.QName("", "ComplexData");
    private static final javax.xml.namespace.QName LITERALDATA$2 = 
        new javax.xml.namespace.QName("", "LiteralData");
    private static final javax.xml.namespace.QName BOUNDINGBOXDATA$4 = 
        new javax.xml.namespace.QName("", "BoundingBoxData");
    private static final javax.xml.namespace.QName MINOCCURS$6 = 
        new javax.xml.namespace.QName("", "minOccurs");
    private static final javax.xml.namespace.QName MAXOCCURS$8 = 
        new javax.xml.namespace.QName("", "maxOccurs");
    
    
    /**
     * Gets the "ComplexData" element
     */
    public net.opengis.wps.x100.SupportedComplexDataInputType getComplexData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedComplexDataInputType target = null;
            target = (net.opengis.wps.x100.SupportedComplexDataInputType)get_store().find_element_user(COMPLEXDATA$0, 0);
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
    public void setComplexData(net.opengis.wps.x100.SupportedComplexDataInputType complexData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedComplexDataInputType target = null;
            target = (net.opengis.wps.x100.SupportedComplexDataInputType)get_store().find_element_user(COMPLEXDATA$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.SupportedComplexDataInputType)get_store().add_element_user(COMPLEXDATA$0);
            }
            target.set(complexData);
        }
    }
    
    /**
     * Appends and returns a new empty "ComplexData" element
     */
    public net.opengis.wps.x100.SupportedComplexDataInputType addNewComplexData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedComplexDataInputType target = null;
            target = (net.opengis.wps.x100.SupportedComplexDataInputType)get_store().add_element_user(COMPLEXDATA$0);
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
    public net.opengis.wps.x100.LiteralInputType getLiteralData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LiteralInputType target = null;
            target = (net.opengis.wps.x100.LiteralInputType)get_store().find_element_user(LITERALDATA$2, 0);
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
    public void setLiteralData(net.opengis.wps.x100.LiteralInputType literalData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LiteralInputType target = null;
            target = (net.opengis.wps.x100.LiteralInputType)get_store().find_element_user(LITERALDATA$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.LiteralInputType)get_store().add_element_user(LITERALDATA$2);
            }
            target.set(literalData);
        }
    }
    
    /**
     * Appends and returns a new empty "LiteralData" element
     */
    public net.opengis.wps.x100.LiteralInputType addNewLiteralData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LiteralInputType target = null;
            target = (net.opengis.wps.x100.LiteralInputType)get_store().add_element_user(LITERALDATA$2);
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
    public net.opengis.wps.x100.SupportedCRSsType getBoundingBoxData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedCRSsType target = null;
            target = (net.opengis.wps.x100.SupportedCRSsType)get_store().find_element_user(BOUNDINGBOXDATA$4, 0);
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
    public void setBoundingBoxData(net.opengis.wps.x100.SupportedCRSsType boundingBoxData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedCRSsType target = null;
            target = (net.opengis.wps.x100.SupportedCRSsType)get_store().find_element_user(BOUNDINGBOXDATA$4, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.SupportedCRSsType)get_store().add_element_user(BOUNDINGBOXDATA$4);
            }
            target.set(boundingBoxData);
        }
    }
    
    /**
     * Appends and returns a new empty "BoundingBoxData" element
     */
    public net.opengis.wps.x100.SupportedCRSsType addNewBoundingBoxData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.SupportedCRSsType target = null;
            target = (net.opengis.wps.x100.SupportedCRSsType)get_store().add_element_user(BOUNDINGBOXDATA$4);
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
     * Gets the "minOccurs" attribute
     */
    public java.math.BigInteger getMinOccurs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MINOCCURS$6);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "minOccurs" attribute
     */
    public org.apache.xmlbeans.XmlNonNegativeInteger xgetMinOccurs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlNonNegativeInteger target = null;
            target = (org.apache.xmlbeans.XmlNonNegativeInteger)get_store().find_attribute_user(MINOCCURS$6);
            return target;
        }
    }
    
    /**
     * Sets the "minOccurs" attribute
     */
    public void setMinOccurs(java.math.BigInteger minOccurs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MINOCCURS$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MINOCCURS$6);
            }
            target.setBigIntegerValue(minOccurs);
        }
    }
    
    /**
     * Sets (as xml) the "minOccurs" attribute
     */
    public void xsetMinOccurs(org.apache.xmlbeans.XmlNonNegativeInteger minOccurs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlNonNegativeInteger target = null;
            target = (org.apache.xmlbeans.XmlNonNegativeInteger)get_store().find_attribute_user(MINOCCURS$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlNonNegativeInteger)get_store().add_attribute_user(MINOCCURS$6);
            }
            target.set(minOccurs);
        }
    }
    
    /**
     * Gets the "maxOccurs" attribute
     */
    public java.math.BigInteger getMaxOccurs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MAXOCCURS$8);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "maxOccurs" attribute
     */
    public org.apache.xmlbeans.XmlPositiveInteger xgetMaxOccurs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlPositiveInteger target = null;
            target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().find_attribute_user(MAXOCCURS$8);
            return target;
        }
    }
    
    /**
     * Sets the "maxOccurs" attribute
     */
    public void setMaxOccurs(java.math.BigInteger maxOccurs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MAXOCCURS$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MAXOCCURS$8);
            }
            target.setBigIntegerValue(maxOccurs);
        }
    }
    
    /**
     * Sets (as xml) the "maxOccurs" attribute
     */
    public void xsetMaxOccurs(org.apache.xmlbeans.XmlPositiveInteger maxOccurs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlPositiveInteger target = null;
            target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().find_attribute_user(MAXOCCURS$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().add_attribute_user(MAXOCCURS$8);
            }
            target.set(maxOccurs);
        }
    }
}

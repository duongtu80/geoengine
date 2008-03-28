/*
 * XML Type:  SupportedComplexDataType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.SupportedComplexDataType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML SupportedComplexDataType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class SupportedComplexDataTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.SupportedComplexDataType
{
    
    public SupportedComplexDataTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SUPPORTEDCOMPLEXDATA$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "SupportedComplexData");
    private static final javax.xml.namespace.QName DEFAULTFORMAT$2 = 
        new javax.xml.namespace.QName("", "defaultFormat");
    private static final javax.xml.namespace.QName DEFAULTENCODING$4 = 
        new javax.xml.namespace.QName("", "defaultEncoding");
    private static final javax.xml.namespace.QName DEFAULTSCHEMA$6 = 
        new javax.xml.namespace.QName("", "defaultSchema");
    
    
    /**
     * Gets array of all "SupportedComplexData" elements
     */
    public net.opengeospatial.wps.ComplexDataType[] getSupportedComplexDataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SUPPORTEDCOMPLEXDATA$0, targetList);
            net.opengeospatial.wps.ComplexDataType[] result = new net.opengeospatial.wps.ComplexDataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "SupportedComplexData" element
     */
    public net.opengeospatial.wps.ComplexDataType getSupportedComplexDataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ComplexDataType target = null;
            target = (net.opengeospatial.wps.ComplexDataType)get_store().find_element_user(SUPPORTEDCOMPLEXDATA$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "SupportedComplexData" element
     */
    public int sizeOfSupportedComplexDataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SUPPORTEDCOMPLEXDATA$0);
        }
    }
    
    /**
     * Sets array of all "SupportedComplexData" element
     */
    public void setSupportedComplexDataArray(net.opengeospatial.wps.ComplexDataType[] supportedComplexDataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(supportedComplexDataArray, SUPPORTEDCOMPLEXDATA$0);
        }
    }
    
    /**
     * Sets ith "SupportedComplexData" element
     */
    public void setSupportedComplexDataArray(int i, net.opengeospatial.wps.ComplexDataType supportedComplexData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ComplexDataType target = null;
            target = (net.opengeospatial.wps.ComplexDataType)get_store().find_element_user(SUPPORTEDCOMPLEXDATA$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(supportedComplexData);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "SupportedComplexData" element
     */
    public net.opengeospatial.wps.ComplexDataType insertNewSupportedComplexData(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ComplexDataType target = null;
            target = (net.opengeospatial.wps.ComplexDataType)get_store().insert_element_user(SUPPORTEDCOMPLEXDATA$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "SupportedComplexData" element
     */
    public net.opengeospatial.wps.ComplexDataType addNewSupportedComplexData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ComplexDataType target = null;
            target = (net.opengeospatial.wps.ComplexDataType)get_store().add_element_user(SUPPORTEDCOMPLEXDATA$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "SupportedComplexData" element
     */
    public void removeSupportedComplexData(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SUPPORTEDCOMPLEXDATA$0, i);
        }
    }
    
    /**
     * Gets the "defaultFormat" attribute
     */
    public java.lang.String getDefaultFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTFORMAT$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "defaultFormat" attribute
     */
    public net.opengeospatial.ows.MimeType xgetDefaultFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_attribute_user(DEFAULTFORMAT$2);
            return target;
        }
    }
    
    /**
     * True if has "defaultFormat" attribute
     */
    public boolean isSetDefaultFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DEFAULTFORMAT$2) != null;
        }
    }
    
    /**
     * Sets the "defaultFormat" attribute
     */
    public void setDefaultFormat(java.lang.String defaultFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTFORMAT$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DEFAULTFORMAT$2);
            }
            target.setStringValue(defaultFormat);
        }
    }
    
    /**
     * Sets (as xml) the "defaultFormat" attribute
     */
    public void xsetDefaultFormat(net.opengeospatial.ows.MimeType defaultFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_attribute_user(DEFAULTFORMAT$2);
            if (target == null)
            {
                target = (net.opengeospatial.ows.MimeType)get_store().add_attribute_user(DEFAULTFORMAT$2);
            }
            target.set(defaultFormat);
        }
    }
    
    /**
     * Unsets the "defaultFormat" attribute
     */
    public void unsetDefaultFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DEFAULTFORMAT$2);
        }
    }
    
    /**
     * Gets the "defaultEncoding" attribute
     */
    public java.lang.String getDefaultEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTENCODING$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "defaultEncoding" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetDefaultEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(DEFAULTENCODING$4);
            return target;
        }
    }
    
    /**
     * True if has "defaultEncoding" attribute
     */
    public boolean isSetDefaultEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DEFAULTENCODING$4) != null;
        }
    }
    
    /**
     * Sets the "defaultEncoding" attribute
     */
    public void setDefaultEncoding(java.lang.String defaultEncoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTENCODING$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DEFAULTENCODING$4);
            }
            target.setStringValue(defaultEncoding);
        }
    }
    
    /**
     * Sets (as xml) the "defaultEncoding" attribute
     */
    public void xsetDefaultEncoding(org.apache.xmlbeans.XmlAnyURI defaultEncoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(DEFAULTENCODING$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(DEFAULTENCODING$4);
            }
            target.set(defaultEncoding);
        }
    }
    
    /**
     * Unsets the "defaultEncoding" attribute
     */
    public void unsetDefaultEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DEFAULTENCODING$4);
        }
    }
    
    /**
     * Gets the "defaultSchema" attribute
     */
    public java.lang.String getDefaultSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTSCHEMA$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "defaultSchema" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetDefaultSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(DEFAULTSCHEMA$6);
            return target;
        }
    }
    
    /**
     * True if has "defaultSchema" attribute
     */
    public boolean isSetDefaultSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DEFAULTSCHEMA$6) != null;
        }
    }
    
    /**
     * Sets the "defaultSchema" attribute
     */
    public void setDefaultSchema(java.lang.String defaultSchema)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULTSCHEMA$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DEFAULTSCHEMA$6);
            }
            target.setStringValue(defaultSchema);
        }
    }
    
    /**
     * Sets (as xml) the "defaultSchema" attribute
     */
    public void xsetDefaultSchema(org.apache.xmlbeans.XmlAnyURI defaultSchema)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(DEFAULTSCHEMA$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(DEFAULTSCHEMA$6);
            }
            target.set(defaultSchema);
        }
    }
    
    /**
     * Unsets the "defaultSchema" attribute
     */
    public void unsetDefaultSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DEFAULTSCHEMA$6);
        }
    }
}

/*
 * XML Type:  ComplexDataType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ComplexDataType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML ComplexDataType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class ComplexDataTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ComplexDataType
{
    
    public ComplexDataTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMAT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Format");
    private static final javax.xml.namespace.QName ENCODING$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Encoding");
    private static final javax.xml.namespace.QName SCHEMA$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Schema");
    
    
    /**
     * Gets the "Format" element
     */
    public java.lang.String getFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMAT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Format" element
     */
    public net.opengeospatial.ows.MimeType xgetFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_element_user(FORMAT$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "Format" element
     */
    public boolean isSetFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FORMAT$0) != 0;
        }
    }
    
    /**
     * Sets the "Format" element
     */
    public void setFormat(java.lang.String format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMAT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMAT$0);
            }
            target.setStringValue(format);
        }
    }
    
    /**
     * Sets (as xml) the "Format" element
     */
    public void xsetFormat(net.opengeospatial.ows.MimeType format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_element_user(FORMAT$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.MimeType)get_store().add_element_user(FORMAT$0);
            }
            target.set(format);
        }
    }
    
    /**
     * Unsets the "Format" element
     */
    public void unsetFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FORMAT$0, 0);
        }
    }
    
    /**
     * Gets the "Encoding" element
     */
    public java.lang.String getEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODING$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Encoding" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(ENCODING$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "Encoding" element
     */
    public boolean isSetEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ENCODING$2) != 0;
        }
    }
    
    /**
     * Sets the "Encoding" element
     */
    public void setEncoding(java.lang.String encoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENCODING$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENCODING$2);
            }
            target.setStringValue(encoding);
        }
    }
    
    /**
     * Sets (as xml) the "Encoding" element
     */
    public void xsetEncoding(org.apache.xmlbeans.XmlAnyURI encoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(ENCODING$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(ENCODING$2);
            }
            target.set(encoding);
        }
    }
    
    /**
     * Unsets the "Encoding" element
     */
    public void unsetEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ENCODING$2, 0);
        }
    }
    
    /**
     * Gets the "Schema" element
     */
    public java.lang.String getSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SCHEMA$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Schema" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(SCHEMA$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "Schema" element
     */
    public boolean isSetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SCHEMA$4) != 0;
        }
    }
    
    /**
     * Sets the "Schema" element
     */
    public void setSchema(java.lang.String schema)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SCHEMA$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SCHEMA$4);
            }
            target.setStringValue(schema);
        }
    }
    
    /**
     * Sets (as xml) the "Schema" element
     */
    public void xsetSchema(org.apache.xmlbeans.XmlAnyURI schema)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(SCHEMA$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(SCHEMA$4);
            }
            target.set(schema);
        }
    }
    
    /**
     * Unsets the "Schema" element
     */
    public void unsetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SCHEMA$4, 0);
        }
    }
}

/*
 * XML Type:  ComplexValueType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ComplexValueType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML ComplexValueType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class ComplexValueTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ComplexValueType
{
    
    public ComplexValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORMAT$0 = 
        new javax.xml.namespace.QName("", "format");
    private static final javax.xml.namespace.QName ENCODING$2 = 
        new javax.xml.namespace.QName("", "encoding");
    private static final javax.xml.namespace.QName SCHEMA$4 = 
        new javax.xml.namespace.QName("", "schema");
    
    
    /**
     * Gets the "format" attribute
     */
    public java.lang.String getFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FORMAT$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "format" attribute
     */
    public net.opengeospatial.ows.MimeType xgetFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_attribute_user(FORMAT$0);
            return target;
        }
    }
    
    /**
     * True if has "format" attribute
     */
    public boolean isSetFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(FORMAT$0) != null;
        }
    }
    
    /**
     * Sets the "format" attribute
     */
    public void setFormat(java.lang.String format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FORMAT$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FORMAT$0);
            }
            target.setStringValue(format);
        }
    }
    
    /**
     * Sets (as xml) the "format" attribute
     */
    public void xsetFormat(net.opengeospatial.ows.MimeType format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_attribute_user(FORMAT$0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.MimeType)get_store().add_attribute_user(FORMAT$0);
            }
            target.set(format);
        }
    }
    
    /**
     * Unsets the "format" attribute
     */
    public void unsetFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(FORMAT$0);
        }
    }
    
    /**
     * Gets the "encoding" attribute
     */
    public java.lang.String getEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENCODING$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "encoding" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(ENCODING$2);
            return target;
        }
    }
    
    /**
     * True if has "encoding" attribute
     */
    public boolean isSetEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(ENCODING$2) != null;
        }
    }
    
    /**
     * Sets the "encoding" attribute
     */
    public void setEncoding(java.lang.String encoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENCODING$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENCODING$2);
            }
            target.setStringValue(encoding);
        }
    }
    
    /**
     * Sets (as xml) the "encoding" attribute
     */
    public void xsetEncoding(org.apache.xmlbeans.XmlAnyURI encoding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(ENCODING$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(ENCODING$2);
            }
            target.set(encoding);
        }
    }
    
    /**
     * Unsets the "encoding" attribute
     */
    public void unsetEncoding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(ENCODING$2);
        }
    }
    
    /**
     * Gets the "schema" attribute
     */
    public java.lang.String getSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SCHEMA$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "schema" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(SCHEMA$4);
            return target;
        }
    }
    
    /**
     * True if has "schema" attribute
     */
    public boolean isSetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(SCHEMA$4) != null;
        }
    }
    
    /**
     * Sets the "schema" attribute
     */
    public void setSchema(java.lang.String schema)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SCHEMA$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SCHEMA$4);
            }
            target.setStringValue(schema);
        }
    }
    
    /**
     * Sets (as xml) the "schema" attribute
     */
    public void xsetSchema(org.apache.xmlbeans.XmlAnyURI schema)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(SCHEMA$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(SCHEMA$4);
            }
            target.set(schema);
        }
    }
    
    /**
     * Unsets the "schema" attribute
     */
    public void unsetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(SCHEMA$4);
        }
    }
}

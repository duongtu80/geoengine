/*
 * XML Type:  ComplexDataDescriptionType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ComplexDataDescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ComplexDataDescriptionType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class ComplexDataDescriptionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ComplexDataDescriptionType
{
    private static final long serialVersionUID = 1L;
    
    public ComplexDataDescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MIMETYPE$0 = 
        new javax.xml.namespace.QName("", "MimeType");
    private static final javax.xml.namespace.QName ENCODING$2 = 
        new javax.xml.namespace.QName("", "Encoding");
    private static final javax.xml.namespace.QName SCHEMA$4 = 
        new javax.xml.namespace.QName("", "Schema");
    
    
    /**
     * Gets the "MimeType" element
     */
    public java.lang.String getMimeType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MIMETYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "MimeType" element
     */
    public net.opengis.ows.x11.MimeType xgetMimeType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(MIMETYPE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "MimeType" element
     */
    public void setMimeType(java.lang.String mimeType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MIMETYPE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MIMETYPE$0);
            }
            target.setStringValue(mimeType);
        }
    }
    
    /**
     * Sets (as xml) the "MimeType" element
     */
    public void xsetMimeType(net.opengis.ows.x11.MimeType mimeType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(MIMETYPE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.MimeType)get_store().add_element_user(MIMETYPE$0);
            }
            target.set(mimeType);
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

/*
 * XML Type:  IOValueType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.IOValueType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML IOValueType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class IOValueTypeImpl extends net.opengeospatial.wps.impl.DescriptionTypeImpl implements net.opengeospatial.wps.IOValueType
{
    
    public IOValueTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMPLEXVALUEREFERENCE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ComplexValueReference");
    private static final javax.xml.namespace.QName COMPLEXVALUE$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ComplexValue");
    private static final javax.xml.namespace.QName LITERALVALUE$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "LiteralValue");
    private static final javax.xml.namespace.QName BOUNDINGBOXVALUE$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "BoundingBoxValue");
    
    
    /**
     * Gets the "ComplexValueReference" element
     */
    public net.opengeospatial.wps.IOValueType.ComplexValueReference getComplexValueReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.IOValueType.ComplexValueReference target = null;
            target = (net.opengeospatial.wps.IOValueType.ComplexValueReference)get_store().find_element_user(COMPLEXVALUEREFERENCE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ComplexValueReference" element
     */
    public boolean isSetComplexValueReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(COMPLEXVALUEREFERENCE$0) != 0;
        }
    }
    
    /**
     * Sets the "ComplexValueReference" element
     */
    public void setComplexValueReference(net.opengeospatial.wps.IOValueType.ComplexValueReference complexValueReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.IOValueType.ComplexValueReference target = null;
            target = (net.opengeospatial.wps.IOValueType.ComplexValueReference)get_store().find_element_user(COMPLEXVALUEREFERENCE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.IOValueType.ComplexValueReference)get_store().add_element_user(COMPLEXVALUEREFERENCE$0);
            }
            target.set(complexValueReference);
        }
    }
    
    /**
     * Appends and returns a new empty "ComplexValueReference" element
     */
    public net.opengeospatial.wps.IOValueType.ComplexValueReference addNewComplexValueReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.IOValueType.ComplexValueReference target = null;
            target = (net.opengeospatial.wps.IOValueType.ComplexValueReference)get_store().add_element_user(COMPLEXVALUEREFERENCE$0);
            return target;
        }
    }
    
    /**
     * Unsets the "ComplexValueReference" element
     */
    public void unsetComplexValueReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(COMPLEXVALUEREFERENCE$0, 0);
        }
    }
    
    /**
     * Gets the "ComplexValue" element
     */
    public net.opengeospatial.wps.ComplexValueType getComplexValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ComplexValueType target = null;
            target = (net.opengeospatial.wps.ComplexValueType)get_store().find_element_user(COMPLEXVALUE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ComplexValue" element
     */
    public boolean isSetComplexValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(COMPLEXVALUE$2) != 0;
        }
    }
    
    /**
     * Sets the "ComplexValue" element
     */
    public void setComplexValue(net.opengeospatial.wps.ComplexValueType complexValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ComplexValueType target = null;
            target = (net.opengeospatial.wps.ComplexValueType)get_store().find_element_user(COMPLEXVALUE$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ComplexValueType)get_store().add_element_user(COMPLEXVALUE$2);
            }
            target.set(complexValue);
        }
    }
    
    /**
     * Appends and returns a new empty "ComplexValue" element
     */
    public net.opengeospatial.wps.ComplexValueType addNewComplexValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ComplexValueType target = null;
            target = (net.opengeospatial.wps.ComplexValueType)get_store().add_element_user(COMPLEXVALUE$2);
            return target;
        }
    }
    
    /**
     * Unsets the "ComplexValue" element
     */
    public void unsetComplexValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(COMPLEXVALUE$2, 0);
        }
    }
    
    /**
     * Gets the "LiteralValue" element
     */
    public net.opengeospatial.wps.LiteralValueType getLiteralValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralValueType target = null;
            target = (net.opengeospatial.wps.LiteralValueType)get_store().find_element_user(LITERALVALUE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "LiteralValue" element
     */
    public boolean isSetLiteralValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LITERALVALUE$4) != 0;
        }
    }
    
    /**
     * Sets the "LiteralValue" element
     */
    public void setLiteralValue(net.opengeospatial.wps.LiteralValueType literalValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralValueType target = null;
            target = (net.opengeospatial.wps.LiteralValueType)get_store().find_element_user(LITERALVALUE$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.LiteralValueType)get_store().add_element_user(LITERALVALUE$4);
            }
            target.set(literalValue);
        }
    }
    
    /**
     * Appends and returns a new empty "LiteralValue" element
     */
    public net.opengeospatial.wps.LiteralValueType addNewLiteralValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.LiteralValueType target = null;
            target = (net.opengeospatial.wps.LiteralValueType)get_store().add_element_user(LITERALVALUE$4);
            return target;
        }
    }
    
    /**
     * Unsets the "LiteralValue" element
     */
    public void unsetLiteralValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LITERALVALUE$4, 0);
        }
    }
    
    /**
     * Gets the "BoundingBoxValue" element
     */
    public net.opengeospatial.ows.BoundingBoxType getBoundingBoxValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().find_element_user(BOUNDINGBOXVALUE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "BoundingBoxValue" element
     */
    public boolean isSetBoundingBoxValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BOUNDINGBOXVALUE$6) != 0;
        }
    }
    
    /**
     * Sets the "BoundingBoxValue" element
     */
    public void setBoundingBoxValue(net.opengeospatial.ows.BoundingBoxType boundingBoxValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().find_element_user(BOUNDINGBOXVALUE$6, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.BoundingBoxType)get_store().add_element_user(BOUNDINGBOXVALUE$6);
            }
            target.set(boundingBoxValue);
        }
    }
    
    /**
     * Appends and returns a new empty "BoundingBoxValue" element
     */
    public net.opengeospatial.ows.BoundingBoxType addNewBoundingBoxValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().add_element_user(BOUNDINGBOXVALUE$6);
            return target;
        }
    }
    
    /**
     * Unsets the "BoundingBoxValue" element
     */
    public void unsetBoundingBoxValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BOUNDINGBOXVALUE$6, 0);
        }
    }
    /**
     * An XML ComplexValueReference(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class ComplexValueReferenceImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.IOValueType.ComplexValueReference
    {
        
        public ComplexValueReferenceImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName REFERENCE$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "reference");
        private static final javax.xml.namespace.QName FORMAT$2 = 
            new javax.xml.namespace.QName("", "format");
        private static final javax.xml.namespace.QName ENCODING$4 = 
            new javax.xml.namespace.QName("", "encoding");
        private static final javax.xml.namespace.QName SCHEMA$6 = 
            new javax.xml.namespace.QName("", "schema");
        
        
        /**
         * Gets the "reference" attribute
         */
        public java.lang.String getReference()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REFERENCE$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "reference" attribute
         */
        public org.apache.xmlbeans.XmlAnyURI xgetReference()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(REFERENCE$0);
                return target;
            }
        }
        
        /**
         * Sets the "reference" attribute
         */
        public void setReference(java.lang.String reference)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REFERENCE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REFERENCE$0);
                }
                target.setStringValue(reference);
            }
        }
        
        /**
         * Sets (as xml) the "reference" attribute
         */
        public void xsetReference(org.apache.xmlbeans.XmlAnyURI reference)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(REFERENCE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(REFERENCE$0);
                }
                target.set(reference);
            }
        }
        
        /**
         * Gets the "format" attribute
         */
        public java.lang.String getFormat()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FORMAT$2);
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
                target = (net.opengeospatial.ows.MimeType)get_store().find_attribute_user(FORMAT$2);
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
                return get_store().find_attribute_user(FORMAT$2) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FORMAT$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FORMAT$2);
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
                target = (net.opengeospatial.ows.MimeType)get_store().find_attribute_user(FORMAT$2);
                if (target == null)
                {
                    target = (net.opengeospatial.ows.MimeType)get_store().add_attribute_user(FORMAT$2);
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
                get_store().remove_attribute(FORMAT$2);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENCODING$4);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(ENCODING$4);
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
                return get_store().find_attribute_user(ENCODING$4) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENCODING$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENCODING$4);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(ENCODING$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(ENCODING$4);
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
                get_store().remove_attribute(ENCODING$4);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SCHEMA$6);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(SCHEMA$6);
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
                return get_store().find_attribute_user(SCHEMA$6) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SCHEMA$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SCHEMA$6);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(SCHEMA$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(SCHEMA$6);
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
                get_store().remove_attribute(SCHEMA$6);
            }
        }
    }
}

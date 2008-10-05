/*
 * XML Type:  ReferenceType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ReferenceType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML ReferenceType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class ReferenceTypeImpl extends net.opengis.ows.x11.impl.AbstractReferenceBaseTypeImpl implements net.opengis.ows.x11.ReferenceType
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Identifier");
    private static final javax.xml.namespace.QName ABSTRACT$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Abstract");
    private static final javax.xml.namespace.QName FORMAT$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Format");
    private static final javax.xml.namespace.QName METADATA$6 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Metadata");
    
    
    /**
     * Gets the "Identifier" element
     */
    public net.opengis.ows.x11.CodeType getIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Identifier" element
     */
    public boolean isSetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(IDENTIFIER$0) != 0;
        }
    }
    
    /**
     * Sets the "Identifier" element
     */
    public void setIdentifier(net.opengis.ows.x11.CodeType identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.CodeType)get_store().add_element_user(IDENTIFIER$0);
            }
            target.set(identifier);
        }
    }
    
    /**
     * Appends and returns a new empty "Identifier" element
     */
    public net.opengis.ows.x11.CodeType addNewIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().add_element_user(IDENTIFIER$0);
            return target;
        }
    }
    
    /**
     * Unsets the "Identifier" element
     */
    public void unsetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(IDENTIFIER$0, 0);
        }
    }
    
    /**
     * Gets array of all "Abstract" elements
     */
    public net.opengis.ows.x11.LanguageStringType[] getAbstractArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ABSTRACT$2, targetList);
            net.opengis.ows.x11.LanguageStringType[] result = new net.opengis.ows.x11.LanguageStringType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType getAbstractArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Abstract" element
     */
    public int sizeOfAbstractArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABSTRACT$2);
        }
    }
    
    /**
     * Sets array of all "Abstract" element
     */
    public void setAbstractArray(net.opengis.ows.x11.LanguageStringType[] xabstractArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(xabstractArray, ABSTRACT$2);
        }
    }
    
    /**
     * Sets ith "Abstract" element
     */
    public void setAbstractArray(int i, net.opengis.ows.x11.LanguageStringType xabstract)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(xabstract);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType insertNewAbstract(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().insert_element_user(ABSTRACT$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType addNewAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(ABSTRACT$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "Abstract" element
     */
    public void removeAbstract(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABSTRACT$2, i);
        }
    }
    
    /**
     * Gets the "Format" element
     */
    public java.lang.String getFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMAT$4, 0);
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
    public net.opengis.ows.x11.MimeType xgetFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(FORMAT$4, 0);
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
            return get_store().count_elements(FORMAT$4) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FORMAT$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FORMAT$4);
            }
            target.setStringValue(format);
        }
    }
    
    /**
     * Sets (as xml) the "Format" element
     */
    public void xsetFormat(net.opengis.ows.x11.MimeType format)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(FORMAT$4, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.MimeType)get_store().add_element_user(FORMAT$4);
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
            get_store().remove_element(FORMAT$4, 0);
        }
    }
    
    /**
     * Gets array of all "Metadata" elements
     */
    public net.opengis.ows.x11.MetadataType[] getMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$6, targetList);
            net.opengis.ows.x11.MetadataType[] result = new net.opengis.ows.x11.MetadataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Metadata" element
     */
    public net.opengis.ows.x11.MetadataType getMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Metadata" element
     */
    public int sizeOfMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METADATA$6);
        }
    }
    
    /**
     * Sets array of all "Metadata" element
     */
    public void setMetadataArray(net.opengis.ows.x11.MetadataType[] metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$6);
        }
    }
    
    /**
     * Sets ith "Metadata" element
     */
    public void setMetadataArray(int i, net.opengis.ows.x11.MetadataType metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$6, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(metadata);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Metadata" element
     */
    public net.opengis.ows.x11.MetadataType insertNewMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().insert_element_user(METADATA$6, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metadata" element
     */
    public net.opengis.ows.x11.MetadataType addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MetadataType target = null;
            target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(METADATA$6);
            return target;
        }
    }
    
    /**
     * Removes the ith "Metadata" element
     */
    public void removeMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METADATA$6, i);
        }
    }
}

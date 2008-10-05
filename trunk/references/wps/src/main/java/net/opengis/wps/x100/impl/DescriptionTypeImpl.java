/*
 * XML Type:  DescriptionType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.DescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML DescriptionType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class DescriptionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.DescriptionType
{
    private static final long serialVersionUID = 1L;
    
    public DescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Identifier");
    private static final javax.xml.namespace.QName TITLE$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Title");
    private static final javax.xml.namespace.QName ABSTRACT$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Abstract");
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
     * Gets the "Title" element
     */
    public net.opengis.ows.x11.LanguageStringType getTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(TITLE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Title" element
     */
    public void setTitle(net.opengis.ows.x11.LanguageStringType title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(TITLE$2, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(TITLE$2);
            }
            target.set(title);
        }
    }
    
    /**
     * Appends and returns a new empty "Title" element
     */
    public net.opengis.ows.x11.LanguageStringType addNewTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(TITLE$2);
            return target;
        }
    }
    
    /**
     * Gets the "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType getAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Abstract" element
     */
    public boolean isSetAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABSTRACT$4) != 0;
        }
    }
    
    /**
     * Sets the "Abstract" element
     */
    public void setAbstract(net.opengis.ows.x11.LanguageStringType xabstract)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$4, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(ABSTRACT$4);
            }
            target.set(xabstract);
        }
    }
    
    /**
     * Appends and returns a new empty "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType addNewAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(ABSTRACT$4);
            return target;
        }
    }
    
    /**
     * Unsets the "Abstract" element
     */
    public void unsetAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABSTRACT$4, 0);
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

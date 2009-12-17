/*
 * XML Type:  BasicIdentificationType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.BasicIdentificationType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML BasicIdentificationType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class BasicIdentificationTypeImpl extends net.opengis.ows.x11.impl.DescriptionTypeImpl implements net.opengis.ows.x11.BasicIdentificationType
{
    private static final long serialVersionUID = 1L;
    
    public BasicIdentificationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Identifier");
    private static final javax.xml.namespace.QName METADATA$2 = 
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
     * Gets array of all "Metadata" elements
     */
    public net.opengis.ows.x11.MetadataType[] getMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$2, targetList);
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
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$2, i);
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
            return get_store().count_elements(METADATA$2);
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
            arraySetterHelper(metadataArray, METADATA$2);
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
            target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$2, i);
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
            target = (net.opengis.ows.x11.MetadataType)get_store().insert_element_user(METADATA$2, i);
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
            target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(METADATA$2);
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
            get_store().remove_element(METADATA$2, i);
        }
    }
}

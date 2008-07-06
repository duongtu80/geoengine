/*
 * XML Type:  IdentificationType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.IdentificationType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML IdentificationType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class IdentificationTypeImpl extends net.opengeospatial.ows.impl.DescriptionTypeImpl implements net.opengeospatial.ows.IdentificationType
{
    
    public IdentificationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Identifier");
    private static final javax.xml.namespace.QName BOUNDINGBOX$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "BoundingBox");
    private static final org.apache.xmlbeans.QNameSet BOUNDINGBOX$3 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "WGS84BoundingBox"),
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "BoundingBox"),
    });
    private static final javax.xml.namespace.QName OUTPUTFORMAT$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "OutputFormat");
    private static final javax.xml.namespace.QName AVAILABLECRS$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AvailableCRS");
    private static final org.apache.xmlbeans.QNameSet AVAILABLECRS$7 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AvailableCRS"),
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "SupportedCRS"),
    });
    private static final javax.xml.namespace.QName METADATA$8 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Metadata");
    
    
    /**
     * Gets the "Identifier" element
     */
    public net.opengeospatial.ows.CodeType getIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.CodeType target = null;
            target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(IDENTIFIER$0, 0);
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
    public void setIdentifier(net.opengeospatial.ows.CodeType identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.CodeType target = null;
            target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(IDENTIFIER$0);
            }
            target.set(identifier);
        }
    }
    
    /**
     * Appends and returns a new empty "Identifier" element
     */
    public net.opengeospatial.ows.CodeType addNewIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.CodeType target = null;
            target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(IDENTIFIER$0);
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
     * Gets array of all "BoundingBox" elements
     */
    public net.opengeospatial.ows.BoundingBoxType[] getBoundingBoxArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(BOUNDINGBOX$3, targetList);
            net.opengeospatial.ows.BoundingBoxType[] result = new net.opengeospatial.ows.BoundingBoxType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "BoundingBox" element
     */
    public net.opengeospatial.ows.BoundingBoxType getBoundingBoxArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$3, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "BoundingBox" element
     */
    public int sizeOfBoundingBoxArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(BOUNDINGBOX$3);
        }
    }
    
    /**
     * Sets array of all "BoundingBox" element
     */
    public void setBoundingBoxArray(net.opengeospatial.ows.BoundingBoxType[] boundingBoxArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(boundingBoxArray, BOUNDINGBOX$2, BOUNDINGBOX$3);
        }
    }
    
    /**
     * Sets ith "BoundingBox" element
     */
    public void setBoundingBoxArray(int i, net.opengeospatial.ows.BoundingBoxType boundingBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$3, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(boundingBox);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "BoundingBox" element
     */
    public net.opengeospatial.ows.BoundingBoxType insertNewBoundingBox(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().insert_element_user(BOUNDINGBOX$3, BOUNDINGBOX$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "BoundingBox" element
     */
    public net.opengeospatial.ows.BoundingBoxType addNewBoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.BoundingBoxType target = null;
            target = (net.opengeospatial.ows.BoundingBoxType)get_store().add_element_user(BOUNDINGBOX$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "BoundingBox" element
     */
    public void removeBoundingBox(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(BOUNDINGBOX$3, i);
        }
    }
    
    /**
     * Gets array of all "OutputFormat" elements
     */
    public java.lang.String[] getOutputFormatArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OUTPUTFORMAT$4, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "OutputFormat" element
     */
    public java.lang.String getOutputFormatArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "OutputFormat" elements
     */
    public net.opengeospatial.ows.MimeType[] xgetOutputFormatArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OUTPUTFORMAT$4, targetList);
            net.opengeospatial.ows.MimeType[] result = new net.opengeospatial.ows.MimeType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "OutputFormat" element
     */
    public net.opengeospatial.ows.MimeType xgetOutputFormatArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_element_user(OUTPUTFORMAT$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (net.opengeospatial.ows.MimeType)target;
        }
    }
    
    /**
     * Returns number of "OutputFormat" element
     */
    public int sizeOfOutputFormatArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OUTPUTFORMAT$4);
        }
    }
    
    /**
     * Sets array of all "OutputFormat" element
     */
    public void setOutputFormatArray(java.lang.String[] outputFormatArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(outputFormatArray, OUTPUTFORMAT$4);
        }
    }
    
    /**
     * Sets ith "OutputFormat" element
     */
    public void setOutputFormatArray(int i, java.lang.String outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(outputFormat);
        }
    }
    
    /**
     * Sets (as xml) array of all "OutputFormat" element
     */
    public void xsetOutputFormatArray(net.opengeospatial.ows.MimeType[]outputFormatArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(outputFormatArray, OUTPUTFORMAT$4);
        }
    }
    
    /**
     * Sets (as xml) ith "OutputFormat" element
     */
    public void xsetOutputFormatArray(int i, net.opengeospatial.ows.MimeType outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_element_user(OUTPUTFORMAT$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(outputFormat);
        }
    }
    
    /**
     * Inserts the value as the ith "OutputFormat" element
     */
    public void insertOutputFormat(int i, java.lang.String outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(OUTPUTFORMAT$4, i);
            target.setStringValue(outputFormat);
        }
    }
    
    /**
     * Appends the value as the last "OutputFormat" element
     */
    public void addOutputFormat(java.lang.String outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OUTPUTFORMAT$4);
            target.setStringValue(outputFormat);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "OutputFormat" element
     */
    public net.opengeospatial.ows.MimeType insertNewOutputFormat(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().insert_element_user(OUTPUTFORMAT$4, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OutputFormat" element
     */
    public net.opengeospatial.ows.MimeType addNewOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().add_element_user(OUTPUTFORMAT$4);
            return target;
        }
    }
    
    /**
     * Removes the ith "OutputFormat" element
     */
    public void removeOutputFormat(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OUTPUTFORMAT$4, i);
        }
    }
    
    /**
     * Gets array of all "AvailableCRS" elements
     */
    public java.lang.String[] getAvailableCRSArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(AVAILABLECRS$7, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "AvailableCRS" element
     */
    public java.lang.String getAvailableCRSArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABLECRS$7, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "AvailableCRS" elements
     */
    public org.apache.xmlbeans.XmlAnyURI[] xgetAvailableCRSArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(AVAILABLECRS$7, targetList);
            org.apache.xmlbeans.XmlAnyURI[] result = new org.apache.xmlbeans.XmlAnyURI[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "AvailableCRS" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetAvailableCRSArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(AVAILABLECRS$7, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlAnyURI)target;
        }
    }
    
    /**
     * Returns number of "AvailableCRS" element
     */
    public int sizeOfAvailableCRSArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(AVAILABLECRS$7);
        }
    }
    
    /**
     * Sets array of all "AvailableCRS" element
     */
    public void setAvailableCRSArray(java.lang.String[] availableCRSArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(availableCRSArray, AVAILABLECRS$6, AVAILABLECRS$7);
        }
    }
    
    /**
     * Sets ith "AvailableCRS" element
     */
    public void setAvailableCRSArray(int i, java.lang.String availableCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABLECRS$7, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(availableCRS);
        }
    }
    
    /**
     * Sets (as xml) array of all "AvailableCRS" element
     */
    public void xsetAvailableCRSArray(org.apache.xmlbeans.XmlAnyURI[]availableCRSArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(availableCRSArray, AVAILABLECRS$6);
        }
    }
    
    /**
     * Sets (as xml) ith "AvailableCRS" element
     */
    public void xsetAvailableCRSArray(int i, org.apache.xmlbeans.XmlAnyURI availableCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(AVAILABLECRS$7, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(availableCRS);
        }
    }
    
    /**
     * Inserts the value as the ith "AvailableCRS" element
     */
    public void insertAvailableCRS(int i, java.lang.String availableCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(AVAILABLECRS$7, AVAILABLECRS$6, i);
            target.setStringValue(availableCRS);
        }
    }
    
    /**
     * Appends the value as the last "AvailableCRS" element
     */
    public void addAvailableCRS(java.lang.String availableCRS)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABLECRS$6);
            target.setStringValue(availableCRS);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "AvailableCRS" element
     */
    public org.apache.xmlbeans.XmlAnyURI insertNewAvailableCRS(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().insert_element_user(AVAILABLECRS$7, AVAILABLECRS$6, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "AvailableCRS" element
     */
    public org.apache.xmlbeans.XmlAnyURI addNewAvailableCRS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(AVAILABLECRS$6);
            return target;
        }
    }
    
    /**
     * Removes the ith "AvailableCRS" element
     */
    public void removeAvailableCRS(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(AVAILABLECRS$7, i);
        }
    }
    
    /**
     * Gets array of all "Metadata" elements
     */
    public net.opengeospatial.ows.MetadataType[] getMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$8, targetList);
            net.opengeospatial.ows.MetadataType[] result = new net.opengeospatial.ows.MetadataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType getMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().find_element_user(METADATA$8, i);
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
            return get_store().count_elements(METADATA$8);
        }
    }
    
    /**
     * Sets array of all "Metadata" element
     */
    public void setMetadataArray(net.opengeospatial.ows.MetadataType[] metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$8);
        }
    }
    
    /**
     * Sets ith "Metadata" element
     */
    public void setMetadataArray(int i, net.opengeospatial.ows.MetadataType metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().find_element_user(METADATA$8, i);
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
    public net.opengeospatial.ows.MetadataType insertNewMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().insert_element_user(METADATA$8, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().add_element_user(METADATA$8);
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
            get_store().remove_element(METADATA$8, i);
        }
    }
}

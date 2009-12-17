/*
 * XML Type:  IdentificationType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.IdentificationType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML IdentificationType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class IdentificationTypeImpl extends net.opengis.ows.x11.impl.BasicIdentificationTypeImpl implements net.opengis.ows.x11.IdentificationType
{
    private static final long serialVersionUID = 1L;
    
    public IdentificationTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BOUNDINGBOX$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "BoundingBox");
    private static final org.apache.xmlbeans.QNameSet BOUNDINGBOX$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "WGS84BoundingBox"),
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "BoundingBox"),
    });
    private static final javax.xml.namespace.QName OUTPUTFORMAT$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "OutputFormat");
    private static final javax.xml.namespace.QName AVAILABLECRS$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AvailableCRS");
    private static final org.apache.xmlbeans.QNameSet AVAILABLECRS$5 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AvailableCRS"),
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "SupportedCRS"),
    });
    
    
    /**
     * Gets array of all "BoundingBox" elements
     */
    public net.opengis.ows.x11.BoundingBoxType[] getBoundingBoxArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(BOUNDINGBOX$1, targetList);
            net.opengis.ows.x11.BoundingBoxType[] result = new net.opengis.ows.x11.BoundingBoxType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "BoundingBox" element
     */
    public net.opengis.ows.x11.BoundingBoxType getBoundingBoxArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$1, i);
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
            return get_store().count_elements(BOUNDINGBOX$1);
        }
    }
    
    /**
     * Sets array of all "BoundingBox" element
     */
    public void setBoundingBoxArray(net.opengis.ows.x11.BoundingBoxType[] boundingBoxArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(boundingBoxArray, BOUNDINGBOX$0, BOUNDINGBOX$1);
        }
    }
    
    /**
     * Sets ith "BoundingBox" element
     */
    public void setBoundingBoxArray(int i, net.opengis.ows.x11.BoundingBoxType boundingBox)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().find_element_user(BOUNDINGBOX$1, i);
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
    public net.opengis.ows.x11.BoundingBoxType insertNewBoundingBox(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().insert_element_user(BOUNDINGBOX$1, BOUNDINGBOX$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "BoundingBox" element
     */
    public net.opengis.ows.x11.BoundingBoxType addNewBoundingBox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.BoundingBoxType target = null;
            target = (net.opengis.ows.x11.BoundingBoxType)get_store().add_element_user(BOUNDINGBOX$0);
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
            get_store().remove_element(BOUNDINGBOX$1, i);
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
            get_store().find_all_element_users(OUTPUTFORMAT$2, targetList);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$2, i);
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
    public net.opengis.ows.x11.MimeType[] xgetOutputFormatArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OUTPUTFORMAT$2, targetList);
            net.opengis.ows.x11.MimeType[] result = new net.opengis.ows.x11.MimeType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "OutputFormat" element
     */
    public net.opengis.ows.x11.MimeType xgetOutputFormatArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(OUTPUTFORMAT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (net.opengis.ows.x11.MimeType)target;
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
            return get_store().count_elements(OUTPUTFORMAT$2);
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
            arraySetterHelper(outputFormatArray, OUTPUTFORMAT$2);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$2, i);
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
    public void xsetOutputFormatArray(net.opengis.ows.x11.MimeType[]outputFormatArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(outputFormatArray, OUTPUTFORMAT$2);
        }
    }
    
    /**
     * Sets (as xml) ith "OutputFormat" element
     */
    public void xsetOutputFormatArray(int i, net.opengis.ows.x11.MimeType outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(OUTPUTFORMAT$2, i);
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
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(OUTPUTFORMAT$2, i);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OUTPUTFORMAT$2);
            target.setStringValue(outputFormat);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "OutputFormat" element
     */
    public net.opengis.ows.x11.MimeType insertNewOutputFormat(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().insert_element_user(OUTPUTFORMAT$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OutputFormat" element
     */
    public net.opengis.ows.x11.MimeType addNewOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().add_element_user(OUTPUTFORMAT$2);
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
            get_store().remove_element(OUTPUTFORMAT$2, i);
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
            get_store().find_all_element_users(AVAILABLECRS$5, targetList);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABLECRS$5, i);
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
            get_store().find_all_element_users(AVAILABLECRS$5, targetList);
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
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(AVAILABLECRS$5, i);
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
            return get_store().count_elements(AVAILABLECRS$5);
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
            arraySetterHelper(availableCRSArray, AVAILABLECRS$4, AVAILABLECRS$5);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABLECRS$5, i);
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
            arraySetterHelper(availableCRSArray, AVAILABLECRS$4);
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
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(AVAILABLECRS$5, i);
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
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(AVAILABLECRS$5, AVAILABLECRS$4, i);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABLECRS$4);
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
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().insert_element_user(AVAILABLECRS$5, AVAILABLECRS$4, i);
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
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(AVAILABLECRS$4);
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
            get_store().remove_element(AVAILABLECRS$5, i);
        }
    }
}

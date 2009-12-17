/*
 * XML Type:  AcceptFormatsType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AcceptFormatsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML AcceptFormatsType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class AcceptFormatsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AcceptFormatsType
{
    private static final long serialVersionUID = 1L;
    
    public AcceptFormatsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUTPUTFORMAT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "OutputFormat");
    
    
    /**
     * Gets array of all "OutputFormat" elements
     */
    public java.lang.String[] getOutputFormatArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OUTPUTFORMAT$0, targetList);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$0, i);
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
            get_store().find_all_element_users(OUTPUTFORMAT$0, targetList);
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
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(OUTPUTFORMAT$0, i);
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
            return get_store().count_elements(OUTPUTFORMAT$0);
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
            arraySetterHelper(outputFormatArray, OUTPUTFORMAT$0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$0, i);
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
            arraySetterHelper(outputFormatArray, OUTPUTFORMAT$0);
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
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(OUTPUTFORMAT$0, i);
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
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(OUTPUTFORMAT$0, i);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OUTPUTFORMAT$0);
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
            target = (net.opengis.ows.x11.MimeType)get_store().insert_element_user(OUTPUTFORMAT$0, i);
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
            target = (net.opengis.ows.x11.MimeType)get_store().add_element_user(OUTPUTFORMAT$0);
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
            get_store().remove_element(OUTPUTFORMAT$0, i);
        }
    }
}

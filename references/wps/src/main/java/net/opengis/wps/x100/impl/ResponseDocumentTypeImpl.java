/*
 * XML Type:  ResponseDocumentType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ResponseDocumentType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ResponseDocumentType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class ResponseDocumentTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ResponseDocumentType
{
    private static final long serialVersionUID = 1L;
    
    public ResponseDocumentTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUTPUT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Output");
    private static final javax.xml.namespace.QName STOREEXECUTERESPONSE$2 = 
        new javax.xml.namespace.QName("", "storeExecuteResponse");
    private static final javax.xml.namespace.QName LINEAGE$4 = 
        new javax.xml.namespace.QName("", "lineage");
    private static final javax.xml.namespace.QName STATUS$6 = 
        new javax.xml.namespace.QName("", "status");
    
    
    /**
     * Gets array of all "Output" elements
     */
    public net.opengis.wps.x100.DocumentOutputDefinitionType[] getOutputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OUTPUT$0, targetList);
            net.opengis.wps.x100.DocumentOutputDefinitionType[] result = new net.opengis.wps.x100.DocumentOutputDefinitionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Output" element
     */
    public net.opengis.wps.x100.DocumentOutputDefinitionType getOutputArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DocumentOutputDefinitionType target = null;
            target = (net.opengis.wps.x100.DocumentOutputDefinitionType)get_store().find_element_user(OUTPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Output" element
     */
    public int sizeOfOutputArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OUTPUT$0);
        }
    }
    
    /**
     * Sets array of all "Output" element
     */
    public void setOutputArray(net.opengis.wps.x100.DocumentOutputDefinitionType[] outputArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(outputArray, OUTPUT$0);
        }
    }
    
    /**
     * Sets ith "Output" element
     */
    public void setOutputArray(int i, net.opengis.wps.x100.DocumentOutputDefinitionType output)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DocumentOutputDefinitionType target = null;
            target = (net.opengis.wps.x100.DocumentOutputDefinitionType)get_store().find_element_user(OUTPUT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(output);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Output" element
     */
    public net.opengis.wps.x100.DocumentOutputDefinitionType insertNewOutput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DocumentOutputDefinitionType target = null;
            target = (net.opengis.wps.x100.DocumentOutputDefinitionType)get_store().insert_element_user(OUTPUT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Output" element
     */
    public net.opengis.wps.x100.DocumentOutputDefinitionType addNewOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DocumentOutputDefinitionType target = null;
            target = (net.opengis.wps.x100.DocumentOutputDefinitionType)get_store().add_element_user(OUTPUT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Output" element
     */
    public void removeOutput(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OUTPUT$0, i);
        }
    }
    
    /**
     * Gets the "storeExecuteResponse" attribute
     */
    public boolean getStoreExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STOREEXECUTERESPONSE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(STOREEXECUTERESPONSE$2);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "storeExecuteResponse" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetStoreExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STOREEXECUTERESPONSE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(STOREEXECUTERESPONSE$2);
            }
            return target;
        }
    }
    
    /**
     * True if has "storeExecuteResponse" attribute
     */
    public boolean isSetStoreExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(STOREEXECUTERESPONSE$2) != null;
        }
    }
    
    /**
     * Sets the "storeExecuteResponse" attribute
     */
    public void setStoreExecuteResponse(boolean storeExecuteResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STOREEXECUTERESPONSE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STOREEXECUTERESPONSE$2);
            }
            target.setBooleanValue(storeExecuteResponse);
        }
    }
    
    /**
     * Sets (as xml) the "storeExecuteResponse" attribute
     */
    public void xsetStoreExecuteResponse(org.apache.xmlbeans.XmlBoolean storeExecuteResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STOREEXECUTERESPONSE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(STOREEXECUTERESPONSE$2);
            }
            target.set(storeExecuteResponse);
        }
    }
    
    /**
     * Unsets the "storeExecuteResponse" attribute
     */
    public void unsetStoreExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(STOREEXECUTERESPONSE$2);
        }
    }
    
    /**
     * Gets the "lineage" attribute
     */
    public boolean getLineage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LINEAGE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(LINEAGE$4);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "lineage" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetLineage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(LINEAGE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(LINEAGE$4);
            }
            return target;
        }
    }
    
    /**
     * True if has "lineage" attribute
     */
    public boolean isSetLineage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(LINEAGE$4) != null;
        }
    }
    
    /**
     * Sets the "lineage" attribute
     */
    public void setLineage(boolean lineage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LINEAGE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LINEAGE$4);
            }
            target.setBooleanValue(lineage);
        }
    }
    
    /**
     * Sets (as xml) the "lineage" attribute
     */
    public void xsetLineage(org.apache.xmlbeans.XmlBoolean lineage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(LINEAGE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(LINEAGE$4);
            }
            target.set(lineage);
        }
    }
    
    /**
     * Unsets the "lineage" attribute
     */
    public void unsetLineage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(LINEAGE$4);
        }
    }
    
    /**
     * Gets the "status" attribute
     */
    public boolean getStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUS$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(STATUS$6);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "status" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STATUS$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(STATUS$6);
            }
            return target;
        }
    }
    
    /**
     * True if has "status" attribute
     */
    public boolean isSetStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(STATUS$6) != null;
        }
    }
    
    /**
     * Sets the "status" attribute
     */
    public void setStatus(boolean status)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUS$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STATUS$6);
            }
            target.setBooleanValue(status);
        }
    }
    
    /**
     * Sets (as xml) the "status" attribute
     */
    public void xsetStatus(org.apache.xmlbeans.XmlBoolean status)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STATUS$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(STATUS$6);
            }
            target.set(status);
        }
    }
    
    /**
     * Unsets the "status" attribute
     */
    public void unsetStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(STATUS$6);
        }
    }
}

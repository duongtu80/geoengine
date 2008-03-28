/*
 * XML Type:  ProcessDescriptionType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ProcessDescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML ProcessDescriptionType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class ProcessDescriptionTypeImpl extends net.opengeospatial.wps.impl.ProcessBriefTypeImpl implements net.opengeospatial.wps.ProcessDescriptionType
{
    
    public ProcessDescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATAINPUTS$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "DataInputs");
    private static final javax.xml.namespace.QName PROCESSOUTPUTS$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessOutputs");
    private static final javax.xml.namespace.QName STORESUPPORTED$4 = 
        new javax.xml.namespace.QName("", "storeSupported");
    private static final javax.xml.namespace.QName STATUSSUPPORTED$6 = 
        new javax.xml.namespace.QName("", "statusSupported");
    
    
    /**
     * Gets the "DataInputs" element
     */
    public net.opengeospatial.wps.ProcessDescriptionType.DataInputs getDataInputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionType.DataInputs target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionType.DataInputs)get_store().find_element_user(DATAINPUTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "DataInputs" element
     */
    public boolean isSetDataInputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATAINPUTS$0) != 0;
        }
    }
    
    /**
     * Sets the "DataInputs" element
     */
    public void setDataInputs(net.opengeospatial.wps.ProcessDescriptionType.DataInputs dataInputs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionType.DataInputs target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionType.DataInputs)get_store().find_element_user(DATAINPUTS$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ProcessDescriptionType.DataInputs)get_store().add_element_user(DATAINPUTS$0);
            }
            target.set(dataInputs);
        }
    }
    
    /**
     * Appends and returns a new empty "DataInputs" element
     */
    public net.opengeospatial.wps.ProcessDescriptionType.DataInputs addNewDataInputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionType.DataInputs target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionType.DataInputs)get_store().add_element_user(DATAINPUTS$0);
            return target;
        }
    }
    
    /**
     * Unsets the "DataInputs" element
     */
    public void unsetDataInputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATAINPUTS$0, 0);
        }
    }
    
    /**
     * Gets the "ProcessOutputs" element
     */
    public net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs getProcessOutputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs)get_store().find_element_user(PROCESSOUTPUTS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ProcessOutputs" element
     */
    public void setProcessOutputs(net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs processOutputs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs)get_store().find_element_user(PROCESSOUTPUTS$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs)get_store().add_element_user(PROCESSOUTPUTS$2);
            }
            target.set(processOutputs);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessOutputs" element
     */
    public net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs addNewProcessOutputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs)get_store().add_element_user(PROCESSOUTPUTS$2);
            return target;
        }
    }
    
    /**
     * Gets the "storeSupported" attribute
     */
    public boolean getStoreSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STORESUPPORTED$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(STORESUPPORTED$4);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "storeSupported" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetStoreSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STORESUPPORTED$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(STORESUPPORTED$4);
            }
            return target;
        }
    }
    
    /**
     * True if has "storeSupported" attribute
     */
    public boolean isSetStoreSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(STORESUPPORTED$4) != null;
        }
    }
    
    /**
     * Sets the "storeSupported" attribute
     */
    public void setStoreSupported(boolean storeSupported)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STORESUPPORTED$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STORESUPPORTED$4);
            }
            target.setBooleanValue(storeSupported);
        }
    }
    
    /**
     * Sets (as xml) the "storeSupported" attribute
     */
    public void xsetStoreSupported(org.apache.xmlbeans.XmlBoolean storeSupported)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STORESUPPORTED$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(STORESUPPORTED$4);
            }
            target.set(storeSupported);
        }
    }
    
    /**
     * Unsets the "storeSupported" attribute
     */
    public void unsetStoreSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(STORESUPPORTED$4);
        }
    }
    
    /**
     * Gets the "statusSupported" attribute
     */
    public boolean getStatusSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUSSUPPORTED$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(STATUSSUPPORTED$6);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "statusSupported" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetStatusSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STATUSSUPPORTED$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(STATUSSUPPORTED$6);
            }
            return target;
        }
    }
    
    /**
     * True if has "statusSupported" attribute
     */
    public boolean isSetStatusSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(STATUSSUPPORTED$6) != null;
        }
    }
    
    /**
     * Sets the "statusSupported" attribute
     */
    public void setStatusSupported(boolean statusSupported)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUSSUPPORTED$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STATUSSUPPORTED$6);
            }
            target.setBooleanValue(statusSupported);
        }
    }
    
    /**
     * Sets (as xml) the "statusSupported" attribute
     */
    public void xsetStatusSupported(org.apache.xmlbeans.XmlBoolean statusSupported)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STATUSSUPPORTED$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(STATUSSUPPORTED$6);
            }
            target.set(statusSupported);
        }
    }
    
    /**
     * Unsets the "statusSupported" attribute
     */
    public void unsetStatusSupported()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(STATUSSUPPORTED$6);
        }
    }
    /**
     * An XML DataInputs(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class DataInputsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ProcessDescriptionType.DataInputs
    {
        
        public DataInputsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName INPUT$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Input");
        
        
        /**
         * Gets array of all "Input" elements
         */
        public net.opengeospatial.wps.InputDescriptionType[] getInputArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(INPUT$0, targetList);
                net.opengeospatial.wps.InputDescriptionType[] result = new net.opengeospatial.wps.InputDescriptionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Input" element
         */
        public net.opengeospatial.wps.InputDescriptionType getInputArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.InputDescriptionType target = null;
                target = (net.opengeospatial.wps.InputDescriptionType)get_store().find_element_user(INPUT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Input" element
         */
        public int sizeOfInputArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(INPUT$0);
            }
        }
        
        /**
         * Sets array of all "Input" element
         */
        public void setInputArray(net.opengeospatial.wps.InputDescriptionType[] inputArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(inputArray, INPUT$0);
            }
        }
        
        /**
         * Sets ith "Input" element
         */
        public void setInputArray(int i, net.opengeospatial.wps.InputDescriptionType input)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.InputDescriptionType target = null;
                target = (net.opengeospatial.wps.InputDescriptionType)get_store().find_element_user(INPUT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(input);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Input" element
         */
        public net.opengeospatial.wps.InputDescriptionType insertNewInput(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.InputDescriptionType target = null;
                target = (net.opengeospatial.wps.InputDescriptionType)get_store().insert_element_user(INPUT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Input" element
         */
        public net.opengeospatial.wps.InputDescriptionType addNewInput()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.InputDescriptionType target = null;
                target = (net.opengeospatial.wps.InputDescriptionType)get_store().add_element_user(INPUT$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Input" element
         */
        public void removeInput(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(INPUT$0, i);
            }
        }
    }
    /**
     * An XML ProcessOutputs(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class ProcessOutputsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs
    {
        
        public ProcessOutputsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName OUTPUT$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Output");
        
        
        /**
         * Gets array of all "Output" elements
         */
        public net.opengeospatial.wps.OutputDescriptionType[] getOutputArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(OUTPUT$0, targetList);
                net.opengeospatial.wps.OutputDescriptionType[] result = new net.opengeospatial.wps.OutputDescriptionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Output" element
         */
        public net.opengeospatial.wps.OutputDescriptionType getOutputArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.OutputDescriptionType target = null;
                target = (net.opengeospatial.wps.OutputDescriptionType)get_store().find_element_user(OUTPUT$0, i);
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
        public void setOutputArray(net.opengeospatial.wps.OutputDescriptionType[] outputArray)
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
        public void setOutputArray(int i, net.opengeospatial.wps.OutputDescriptionType output)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.OutputDescriptionType target = null;
                target = (net.opengeospatial.wps.OutputDescriptionType)get_store().find_element_user(OUTPUT$0, i);
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
        public net.opengeospatial.wps.OutputDescriptionType insertNewOutput(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.OutputDescriptionType target = null;
                target = (net.opengeospatial.wps.OutputDescriptionType)get_store().insert_element_user(OUTPUT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Output" element
         */
        public net.opengeospatial.wps.OutputDescriptionType addNewOutput()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.OutputDescriptionType target = null;
                target = (net.opengeospatial.wps.OutputDescriptionType)get_store().add_element_user(OUTPUT$0);
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
    }
}

/*
 * XML Type:  ExecuteResponseType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ExecuteResponseType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML ExecuteResponseType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class ExecuteResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ExecuteResponseType
{
    
    public ExecuteResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Identifier");
    private static final javax.xml.namespace.QName STATUS$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Status");
    private static final javax.xml.namespace.QName DATAINPUTS$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "DataInputs");
    private static final javax.xml.namespace.QName OUTPUTDEFINITIONS$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "OutputDefinitions");
    private static final javax.xml.namespace.QName PROCESSOUTPUTS$8 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessOutputs");
    private static final javax.xml.namespace.QName STATUSLOCATION$10 = 
        new javax.xml.namespace.QName("", "statusLocation");
    private static final javax.xml.namespace.QName VERSION$12 = 
        new javax.xml.namespace.QName("", "version");
    
    
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
     * Gets the "Status" element
     */
    public net.opengeospatial.wps.StatusType getStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.StatusType target = null;
            target = (net.opengeospatial.wps.StatusType)get_store().find_element_user(STATUS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Status" element
     */
    public void setStatus(net.opengeospatial.wps.StatusType status)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.StatusType target = null;
            target = (net.opengeospatial.wps.StatusType)get_store().find_element_user(STATUS$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.StatusType)get_store().add_element_user(STATUS$2);
            }
            target.set(status);
        }
    }
    
    /**
     * Appends and returns a new empty "Status" element
     */
    public net.opengeospatial.wps.StatusType addNewStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.StatusType target = null;
            target = (net.opengeospatial.wps.StatusType)get_store().add_element_user(STATUS$2);
            return target;
        }
    }
    
    /**
     * Gets the "DataInputs" element
     */
    public net.opengeospatial.wps.DataInputsType getDataInputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.DataInputsType target = null;
            target = (net.opengeospatial.wps.DataInputsType)get_store().find_element_user(DATAINPUTS$4, 0);
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
            return get_store().count_elements(DATAINPUTS$4) != 0;
        }
    }
    
    /**
     * Sets the "DataInputs" element
     */
    public void setDataInputs(net.opengeospatial.wps.DataInputsType dataInputs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.DataInputsType target = null;
            target = (net.opengeospatial.wps.DataInputsType)get_store().find_element_user(DATAINPUTS$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.DataInputsType)get_store().add_element_user(DATAINPUTS$4);
            }
            target.set(dataInputs);
        }
    }
    
    /**
     * Appends and returns a new empty "DataInputs" element
     */
    public net.opengeospatial.wps.DataInputsType addNewDataInputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.DataInputsType target = null;
            target = (net.opengeospatial.wps.DataInputsType)get_store().add_element_user(DATAINPUTS$4);
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
            get_store().remove_element(DATAINPUTS$4, 0);
        }
    }
    
    /**
     * Gets the "OutputDefinitions" element
     */
    public net.opengeospatial.wps.OutputDefinitionsType getOutputDefinitions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.OutputDefinitionsType target = null;
            target = (net.opengeospatial.wps.OutputDefinitionsType)get_store().find_element_user(OUTPUTDEFINITIONS$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "OutputDefinitions" element
     */
    public boolean isSetOutputDefinitions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OUTPUTDEFINITIONS$6) != 0;
        }
    }
    
    /**
     * Sets the "OutputDefinitions" element
     */
    public void setOutputDefinitions(net.opengeospatial.wps.OutputDefinitionsType outputDefinitions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.OutputDefinitionsType target = null;
            target = (net.opengeospatial.wps.OutputDefinitionsType)get_store().find_element_user(OUTPUTDEFINITIONS$6, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.OutputDefinitionsType)get_store().add_element_user(OUTPUTDEFINITIONS$6);
            }
            target.set(outputDefinitions);
        }
    }
    
    /**
     * Appends and returns a new empty "OutputDefinitions" element
     */
    public net.opengeospatial.wps.OutputDefinitionsType addNewOutputDefinitions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.OutputDefinitionsType target = null;
            target = (net.opengeospatial.wps.OutputDefinitionsType)get_store().add_element_user(OUTPUTDEFINITIONS$6);
            return target;
        }
    }
    
    /**
     * Unsets the "OutputDefinitions" element
     */
    public void unsetOutputDefinitions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OUTPUTDEFINITIONS$6, 0);
        }
    }
    
    /**
     * Gets the "ProcessOutputs" element
     */
    public net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs getProcessOutputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs target = null;
            target = (net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs)get_store().find_element_user(PROCESSOUTPUTS$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ProcessOutputs" element
     */
    public boolean isSetProcessOutputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESSOUTPUTS$8) != 0;
        }
    }
    
    /**
     * Sets the "ProcessOutputs" element
     */
    public void setProcessOutputs(net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs processOutputs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs target = null;
            target = (net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs)get_store().find_element_user(PROCESSOUTPUTS$8, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs)get_store().add_element_user(PROCESSOUTPUTS$8);
            }
            target.set(processOutputs);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessOutputs" element
     */
    public net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs addNewProcessOutputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs target = null;
            target = (net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs)get_store().add_element_user(PROCESSOUTPUTS$8);
            return target;
        }
    }
    
    /**
     * Unsets the "ProcessOutputs" element
     */
    public void unsetProcessOutputs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESSOUTPUTS$8, 0);
        }
    }
    
    /**
     * Gets the "statusLocation" attribute
     */
    public java.lang.String getStatusLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUSLOCATION$10);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "statusLocation" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetStatusLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(STATUSLOCATION$10);
            return target;
        }
    }
    
    /**
     * True if has "statusLocation" attribute
     */
    public boolean isSetStatusLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(STATUSLOCATION$10) != null;
        }
    }
    
    /**
     * Sets the "statusLocation" attribute
     */
    public void setStatusLocation(java.lang.String statusLocation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUSLOCATION$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STATUSLOCATION$10);
            }
            target.setStringValue(statusLocation);
        }
    }
    
    /**
     * Sets (as xml) the "statusLocation" attribute
     */
    public void xsetStatusLocation(org.apache.xmlbeans.XmlAnyURI statusLocation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(STATUSLOCATION$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(STATUSLOCATION$10);
            }
            target.set(statusLocation);
        }
    }
    
    /**
     * Unsets the "statusLocation" attribute
     */
    public void unsetStatusLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(STATUSLOCATION$10);
        }
    }
    
    /**
     * Gets the "version" attribute
     */
    public java.lang.String getVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$12);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "version" attribute
     */
    public net.opengeospatial.ows.VersionType xgetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().find_attribute_user(VERSION$12);
            return target;
        }
    }
    
    /**
     * Sets the "version" attribute
     */
    public void setVersion(java.lang.String version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$12);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VERSION$12);
            }
            target.setStringValue(version);
        }
    }
    
    /**
     * Sets (as xml) the "version" attribute
     */
    public void xsetVersion(net.opengeospatial.ows.VersionType version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().find_attribute_user(VERSION$12);
            if (target == null)
            {
                target = (net.opengeospatial.ows.VersionType)get_store().add_attribute_user(VERSION$12);
            }
            target.set(version);
        }
    }
    /**
     * An XML ProcessOutputs(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class ProcessOutputsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs
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
        public net.opengeospatial.wps.IOValueType[] getOutputArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(OUTPUT$0, targetList);
                net.opengeospatial.wps.IOValueType[] result = new net.opengeospatial.wps.IOValueType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Output" element
         */
        public net.opengeospatial.wps.IOValueType getOutputArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.IOValueType target = null;
                target = (net.opengeospatial.wps.IOValueType)get_store().find_element_user(OUTPUT$0, i);
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
        public void setOutputArray(net.opengeospatial.wps.IOValueType[] outputArray)
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
        public void setOutputArray(int i, net.opengeospatial.wps.IOValueType output)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.IOValueType target = null;
                target = (net.opengeospatial.wps.IOValueType)get_store().find_element_user(OUTPUT$0, i);
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
        public net.opengeospatial.wps.IOValueType insertNewOutput(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.IOValueType target = null;
                target = (net.opengeospatial.wps.IOValueType)get_store().insert_element_user(OUTPUT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Output" element
         */
        public net.opengeospatial.wps.IOValueType addNewOutput()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.IOValueType target = null;
                target = (net.opengeospatial.wps.IOValueType)get_store().add_element_user(OUTPUT$0);
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

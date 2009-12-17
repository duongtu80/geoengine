/*
 * An XML document type.
 * Localname: ExecuteResponse
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ExecuteResponseDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one ExecuteResponse(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class ExecuteResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ExecuteResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public ExecuteResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXECUTERESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ExecuteResponse");
    
    
    /**
     * Gets the "ExecuteResponse" element
     */
    public net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse getExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse target = null;
            target = (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse)get_store().find_element_user(EXECUTERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ExecuteResponse" element
     */
    public void setExecuteResponse(net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse executeResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse target = null;
            target = (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse)get_store().find_element_user(EXECUTERESPONSE$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse)get_store().add_element_user(EXECUTERESPONSE$0);
            }
            target.set(executeResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "ExecuteResponse" element
     */
    public net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse addNewExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse target = null;
            target = (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse)get_store().add_element_user(EXECUTERESPONSE$0);
            return target;
        }
    }
    /**
     * An XML ExecuteResponse(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public static class ExecuteResponseImpl extends net.opengis.wps.x100.impl.ResponseBaseTypeImpl implements net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse
    {
        private static final long serialVersionUID = 1L;
        
        public ExecuteResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROCESS$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Process");
        private static final javax.xml.namespace.QName STATUS$2 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Status");
        private static final javax.xml.namespace.QName DATAINPUTS$4 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "DataInputs");
        private static final javax.xml.namespace.QName OUTPUTDEFINITIONS$6 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "OutputDefinitions");
        private static final javax.xml.namespace.QName PROCESSOUTPUTS$8 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessOutputs");
        private static final javax.xml.namespace.QName SERVICEINSTANCE$10 = 
            new javax.xml.namespace.QName("", "serviceInstance");
        private static final javax.xml.namespace.QName STATUSLOCATION$12 = 
            new javax.xml.namespace.QName("", "statusLocation");
        
        
        /**
         * Gets the "Process" element
         */
        public net.opengis.wps.x100.ProcessBriefType getProcess()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessBriefType target = null;
                target = (net.opengis.wps.x100.ProcessBriefType)get_store().find_element_user(PROCESS$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "Process" element
         */
        public void setProcess(net.opengis.wps.x100.ProcessBriefType process)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessBriefType target = null;
                target = (net.opengis.wps.x100.ProcessBriefType)get_store().find_element_user(PROCESS$0, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.ProcessBriefType)get_store().add_element_user(PROCESS$0);
                }
                target.set(process);
            }
        }
        
        /**
         * Appends and returns a new empty "Process" element
         */
        public net.opengis.wps.x100.ProcessBriefType addNewProcess()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessBriefType target = null;
                target = (net.opengis.wps.x100.ProcessBriefType)get_store().add_element_user(PROCESS$0);
                return target;
            }
        }
        
        /**
         * Gets the "Status" element
         */
        public net.opengis.wps.x100.StatusType getStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.StatusType target = null;
                target = (net.opengis.wps.x100.StatusType)get_store().find_element_user(STATUS$2, 0);
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
        public void setStatus(net.opengis.wps.x100.StatusType status)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.StatusType target = null;
                target = (net.opengis.wps.x100.StatusType)get_store().find_element_user(STATUS$2, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.StatusType)get_store().add_element_user(STATUS$2);
                }
                target.set(status);
            }
        }
        
        /**
         * Appends and returns a new empty "Status" element
         */
        public net.opengis.wps.x100.StatusType addNewStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.StatusType target = null;
                target = (net.opengis.wps.x100.StatusType)get_store().add_element_user(STATUS$2);
                return target;
            }
        }
        
        /**
         * Gets the "DataInputs" element
         */
        public net.opengis.wps.x100.DataInputsType getDataInputs()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.DataInputsType target = null;
                target = (net.opengis.wps.x100.DataInputsType)get_store().find_element_user(DATAINPUTS$4, 0);
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
        public void setDataInputs(net.opengis.wps.x100.DataInputsType dataInputs)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.DataInputsType target = null;
                target = (net.opengis.wps.x100.DataInputsType)get_store().find_element_user(DATAINPUTS$4, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.DataInputsType)get_store().add_element_user(DATAINPUTS$4);
                }
                target.set(dataInputs);
            }
        }
        
        /**
         * Appends and returns a new empty "DataInputs" element
         */
        public net.opengis.wps.x100.DataInputsType addNewDataInputs()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.DataInputsType target = null;
                target = (net.opengis.wps.x100.DataInputsType)get_store().add_element_user(DATAINPUTS$4);
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
        public net.opengis.wps.x100.OutputDefinitionsType getOutputDefinitions()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.OutputDefinitionsType target = null;
                target = (net.opengis.wps.x100.OutputDefinitionsType)get_store().find_element_user(OUTPUTDEFINITIONS$6, 0);
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
        public void setOutputDefinitions(net.opengis.wps.x100.OutputDefinitionsType outputDefinitions)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.OutputDefinitionsType target = null;
                target = (net.opengis.wps.x100.OutputDefinitionsType)get_store().find_element_user(OUTPUTDEFINITIONS$6, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.OutputDefinitionsType)get_store().add_element_user(OUTPUTDEFINITIONS$6);
                }
                target.set(outputDefinitions);
            }
        }
        
        /**
         * Appends and returns a new empty "OutputDefinitions" element
         */
        public net.opengis.wps.x100.OutputDefinitionsType addNewOutputDefinitions()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.OutputDefinitionsType target = null;
                target = (net.opengis.wps.x100.OutputDefinitionsType)get_store().add_element_user(OUTPUTDEFINITIONS$6);
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
        public net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs getProcessOutputs()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs target = null;
                target = (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs)get_store().find_element_user(PROCESSOUTPUTS$8, 0);
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
        public void setProcessOutputs(net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs processOutputs)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs target = null;
                target = (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs)get_store().find_element_user(PROCESSOUTPUTS$8, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs)get_store().add_element_user(PROCESSOUTPUTS$8);
                }
                target.set(processOutputs);
            }
        }
        
        /**
         * Appends and returns a new empty "ProcessOutputs" element
         */
        public net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs addNewProcessOutputs()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs target = null;
                target = (net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs)get_store().add_element_user(PROCESSOUTPUTS$8);
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
         * Gets the "serviceInstance" attribute
         */
        public java.lang.String getServiceInstance()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SERVICEINSTANCE$10);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "serviceInstance" attribute
         */
        public org.apache.xmlbeans.XmlAnyURI xgetServiceInstance()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(SERVICEINSTANCE$10);
                return target;
            }
        }
        
        /**
         * Sets the "serviceInstance" attribute
         */
        public void setServiceInstance(java.lang.String serviceInstance)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SERVICEINSTANCE$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SERVICEINSTANCE$10);
                }
                target.setStringValue(serviceInstance);
            }
        }
        
        /**
         * Sets (as xml) the "serviceInstance" attribute
         */
        public void xsetServiceInstance(org.apache.xmlbeans.XmlAnyURI serviceInstance)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(SERVICEINSTANCE$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(SERVICEINSTANCE$10);
                }
                target.set(serviceInstance);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUSLOCATION$12);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(STATUSLOCATION$12);
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
                return get_store().find_attribute_user(STATUSLOCATION$12) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUSLOCATION$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STATUSLOCATION$12);
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
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(STATUSLOCATION$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(STATUSLOCATION$12);
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
                get_store().remove_attribute(STATUSLOCATION$12);
            }
        }
        /**
         * An XML ProcessOutputs(@http://www.opengis.net/wps/1.0.0).
         *
         * This is a complex type.
         */
        public static class ProcessOutputsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs
        {
            private static final long serialVersionUID = 1L;
            
            public ProcessOutputsImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName OUTPUT$0 = 
                new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Output");
            
            
            /**
             * Gets array of all "Output" elements
             */
            public net.opengis.wps.x100.OutputDataType[] getOutputArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    java.util.List targetList = new java.util.ArrayList();
                    get_store().find_all_element_users(OUTPUT$0, targetList);
                    net.opengis.wps.x100.OutputDataType[] result = new net.opengis.wps.x100.OutputDataType[targetList.size()];
                    targetList.toArray(result);
                    return result;
                }
            }
            
            /**
             * Gets ith "Output" element
             */
            public net.opengis.wps.x100.OutputDataType getOutputArray(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.opengis.wps.x100.OutputDataType target = null;
                    target = (net.opengis.wps.x100.OutputDataType)get_store().find_element_user(OUTPUT$0, i);
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
            public void setOutputArray(net.opengis.wps.x100.OutputDataType[] outputArray)
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
            public void setOutputArray(int i, net.opengis.wps.x100.OutputDataType output)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.opengis.wps.x100.OutputDataType target = null;
                    target = (net.opengis.wps.x100.OutputDataType)get_store().find_element_user(OUTPUT$0, i);
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
            public net.opengis.wps.x100.OutputDataType insertNewOutput(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.opengis.wps.x100.OutputDataType target = null;
                    target = (net.opengis.wps.x100.OutputDataType)get_store().insert_element_user(OUTPUT$0, i);
                    return target;
                }
            }
            
            /**
             * Appends and returns a new empty value (as xml) as the last "Output" element
             */
            public net.opengis.wps.x100.OutputDataType addNewOutput()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    net.opengis.wps.x100.OutputDataType target = null;
                    target = (net.opengis.wps.x100.OutputDataType)get_store().add_element_user(OUTPUT$0);
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
}

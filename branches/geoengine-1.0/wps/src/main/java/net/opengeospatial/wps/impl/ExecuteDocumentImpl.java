/*
 * An XML document type.
 * Localname: Execute
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ExecuteDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * A document containing one Execute(@http://www.opengeospatial.net/wps) element.
 *
 * This is a complex type.
 */
public class ExecuteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ExecuteDocument
{
    
    public ExecuteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXECUTE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Execute");
    
    
    /**
     * Gets the "Execute" element
     */
    public net.opengeospatial.wps.ExecuteDocument.Execute getExecute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteDocument.Execute target = null;
            target = (net.opengeospatial.wps.ExecuteDocument.Execute)get_store().find_element_user(EXECUTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Execute" element
     */
    public void setExecute(net.opengeospatial.wps.ExecuteDocument.Execute execute)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteDocument.Execute target = null;
            target = (net.opengeospatial.wps.ExecuteDocument.Execute)get_store().find_element_user(EXECUTE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ExecuteDocument.Execute)get_store().add_element_user(EXECUTE$0);
            }
            target.set(execute);
        }
    }
    
    /**
     * Appends and returns a new empty "Execute" element
     */
    public net.opengeospatial.wps.ExecuteDocument.Execute addNewExecute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteDocument.Execute target = null;
            target = (net.opengeospatial.wps.ExecuteDocument.Execute)get_store().add_element_user(EXECUTE$0);
            return target;
        }
    }
    /**
     * An XML Execute(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class ExecuteImpl extends net.opengeospatial.wps.impl.RequestBaseTypeImpl implements net.opengeospatial.wps.ExecuteDocument.Execute
    {
        
        public ExecuteImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDENTIFIER$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Identifier");
        private static final javax.xml.namespace.QName DATAINPUTS$2 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "DataInputs");
        private static final javax.xml.namespace.QName OUTPUTDEFINITIONS$4 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "OutputDefinitions");
        private static final javax.xml.namespace.QName STORE$6 = 
            new javax.xml.namespace.QName("", "store");
        private static final javax.xml.namespace.QName STATUS$8 = 
            new javax.xml.namespace.QName("", "status");
        
        
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
         * Gets the "DataInputs" element
         */
        public net.opengeospatial.wps.DataInputsType getDataInputs()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.DataInputsType target = null;
                target = (net.opengeospatial.wps.DataInputsType)get_store().find_element_user(DATAINPUTS$2, 0);
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
                return get_store().count_elements(DATAINPUTS$2) != 0;
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
                target = (net.opengeospatial.wps.DataInputsType)get_store().find_element_user(DATAINPUTS$2, 0);
                if (target == null)
                {
                    target = (net.opengeospatial.wps.DataInputsType)get_store().add_element_user(DATAINPUTS$2);
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
                target = (net.opengeospatial.wps.DataInputsType)get_store().add_element_user(DATAINPUTS$2);
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
                get_store().remove_element(DATAINPUTS$2, 0);
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
                target = (net.opengeospatial.wps.OutputDefinitionsType)get_store().find_element_user(OUTPUTDEFINITIONS$4, 0);
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
                return get_store().count_elements(OUTPUTDEFINITIONS$4) != 0;
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
                target = (net.opengeospatial.wps.OutputDefinitionsType)get_store().find_element_user(OUTPUTDEFINITIONS$4, 0);
                if (target == null)
                {
                    target = (net.opengeospatial.wps.OutputDefinitionsType)get_store().add_element_user(OUTPUTDEFINITIONS$4);
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
                target = (net.opengeospatial.wps.OutputDefinitionsType)get_store().add_element_user(OUTPUTDEFINITIONS$4);
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
                get_store().remove_element(OUTPUTDEFINITIONS$4, 0);
            }
        }
        
        /**
         * Gets the "store" attribute
         */
        public boolean getStore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STORE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(STORE$6);
                }
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "store" attribute
         */
        public org.apache.xmlbeans.XmlBoolean xgetStore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STORE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(STORE$6);
                }
                return target;
            }
        }
        
        /**
         * True if has "store" attribute
         */
        public boolean isSetStore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(STORE$6) != null;
            }
        }
        
        /**
         * Sets the "store" attribute
         */
        public void setStore(boolean store)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STORE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STORE$6);
                }
                target.setBooleanValue(store);
            }
        }
        
        /**
         * Sets (as xml) the "store" attribute
         */
        public void xsetStore(org.apache.xmlbeans.XmlBoolean store)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STORE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(STORE$6);
                }
                target.set(store);
            }
        }
        
        /**
         * Unsets the "store" attribute
         */
        public void unsetStore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(STORE$6);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUS$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(STATUS$8);
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
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STATUS$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(STATUS$8);
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
                return get_store().find_attribute_user(STATUS$8) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STATUS$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STATUS$8);
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
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(STATUS$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(STATUS$8);
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
                get_store().remove_attribute(STATUS$8);
            }
        }
    }
}

/*
 * An XML document type.
 * Localname: Execute
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ExecuteDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one Execute(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class ExecuteDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ExecuteDocument
{
    private static final long serialVersionUID = 1L;
    
    public ExecuteDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXECUTE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Execute");
    
    
    /**
     * Gets the "Execute" element
     */
    public net.opengis.wps.x100.ExecuteDocument.Execute getExecute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ExecuteDocument.Execute target = null;
            target = (net.opengis.wps.x100.ExecuteDocument.Execute)get_store().find_element_user(EXECUTE$0, 0);
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
    public void setExecute(net.opengis.wps.x100.ExecuteDocument.Execute execute)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ExecuteDocument.Execute target = null;
            target = (net.opengis.wps.x100.ExecuteDocument.Execute)get_store().find_element_user(EXECUTE$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ExecuteDocument.Execute)get_store().add_element_user(EXECUTE$0);
            }
            target.set(execute);
        }
    }
    
    /**
     * Appends and returns a new empty "Execute" element
     */
    public net.opengis.wps.x100.ExecuteDocument.Execute addNewExecute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ExecuteDocument.Execute target = null;
            target = (net.opengis.wps.x100.ExecuteDocument.Execute)get_store().add_element_user(EXECUTE$0);
            return target;
        }
    }
    /**
     * An XML Execute(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public static class ExecuteImpl extends net.opengis.wps.x100.impl.RequestBaseTypeImpl implements net.opengis.wps.x100.ExecuteDocument.Execute
    {
        private static final long serialVersionUID = 1L;
        
        public ExecuteImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDENTIFIER$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Identifier");
        private static final javax.xml.namespace.QName DATAINPUTS$2 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "DataInputs");
        private static final javax.xml.namespace.QName RESPONSEFORM$4 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ResponseForm");
        
        
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
         * Gets the "DataInputs" element
         */
        public net.opengis.wps.x100.DataInputsType getDataInputs()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.DataInputsType target = null;
                target = (net.opengis.wps.x100.DataInputsType)get_store().find_element_user(DATAINPUTS$2, 0);
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
        public void setDataInputs(net.opengis.wps.x100.DataInputsType dataInputs)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.DataInputsType target = null;
                target = (net.opengis.wps.x100.DataInputsType)get_store().find_element_user(DATAINPUTS$2, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.DataInputsType)get_store().add_element_user(DATAINPUTS$2);
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
                target = (net.opengis.wps.x100.DataInputsType)get_store().add_element_user(DATAINPUTS$2);
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
         * Gets the "ResponseForm" element
         */
        public net.opengis.wps.x100.ResponseFormType getResponseForm()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ResponseFormType target = null;
                target = (net.opengis.wps.x100.ResponseFormType)get_store().find_element_user(RESPONSEFORM$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "ResponseForm" element
         */
        public boolean isSetResponseForm()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RESPONSEFORM$4) != 0;
            }
        }
        
        /**
         * Sets the "ResponseForm" element
         */
        public void setResponseForm(net.opengis.wps.x100.ResponseFormType responseForm)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ResponseFormType target = null;
                target = (net.opengis.wps.x100.ResponseFormType)get_store().find_element_user(RESPONSEFORM$4, 0);
                if (target == null)
                {
                    target = (net.opengis.wps.x100.ResponseFormType)get_store().add_element_user(RESPONSEFORM$4);
                }
                target.set(responseForm);
            }
        }
        
        /**
         * Appends and returns a new empty "ResponseForm" element
         */
        public net.opengis.wps.x100.ResponseFormType addNewResponseForm()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ResponseFormType target = null;
                target = (net.opengis.wps.x100.ResponseFormType)get_store().add_element_user(RESPONSEFORM$4);
                return target;
            }
        }
        
        /**
         * Unsets the "ResponseForm" element
         */
        public void unsetResponseForm()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RESPONSEFORM$4, 0);
            }
        }
    }
}

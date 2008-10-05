/*
 * An XML document type.
 * Localname: ProcessDescriptions
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ProcessDescriptionsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one ProcessDescriptions(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class ProcessDescriptionsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ProcessDescriptionsDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProcessDescriptionsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSDESCRIPTIONS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessDescriptions");
    
    
    /**
     * Gets the "ProcessDescriptions" element
     */
    public net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions getProcessDescriptions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions target = null;
            target = (net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions)get_store().find_element_user(PROCESSDESCRIPTIONS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ProcessDescriptions" element
     */
    public void setProcessDescriptions(net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions processDescriptions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions target = null;
            target = (net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions)get_store().find_element_user(PROCESSDESCRIPTIONS$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions)get_store().add_element_user(PROCESSDESCRIPTIONS$0);
            }
            target.set(processDescriptions);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessDescriptions" element
     */
    public net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions addNewProcessDescriptions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions target = null;
            target = (net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions)get_store().add_element_user(PROCESSDESCRIPTIONS$0);
            return target;
        }
    }
    /**
     * An XML ProcessDescriptions(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public static class ProcessDescriptionsImpl extends net.opengis.wps.x100.impl.ResponseBaseTypeImpl implements net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions
    {
        private static final long serialVersionUID = 1L;
        
        public ProcessDescriptionsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROCESSDESCRIPTION$0 = 
            new javax.xml.namespace.QName("", "ProcessDescription");
        
        
        /**
         * Gets array of all "ProcessDescription" elements
         */
        public net.opengis.wps.x100.ProcessDescriptionType[] getProcessDescriptionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PROCESSDESCRIPTION$0, targetList);
                net.opengis.wps.x100.ProcessDescriptionType[] result = new net.opengis.wps.x100.ProcessDescriptionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "ProcessDescription" element
         */
        public net.opengis.wps.x100.ProcessDescriptionType getProcessDescriptionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessDescriptionType target = null;
                target = (net.opengis.wps.x100.ProcessDescriptionType)get_store().find_element_user(PROCESSDESCRIPTION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "ProcessDescription" element
         */
        public int sizeOfProcessDescriptionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PROCESSDESCRIPTION$0);
            }
        }
        
        /**
         * Sets array of all "ProcessDescription" element
         */
        public void setProcessDescriptionArray(net.opengis.wps.x100.ProcessDescriptionType[] processDescriptionArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(processDescriptionArray, PROCESSDESCRIPTION$0);
            }
        }
        
        /**
         * Sets ith "ProcessDescription" element
         */
        public void setProcessDescriptionArray(int i, net.opengis.wps.x100.ProcessDescriptionType processDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessDescriptionType target = null;
                target = (net.opengis.wps.x100.ProcessDescriptionType)get_store().find_element_user(PROCESSDESCRIPTION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(processDescription);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ProcessDescription" element
         */
        public net.opengis.wps.x100.ProcessDescriptionType insertNewProcessDescription(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessDescriptionType target = null;
                target = (net.opengis.wps.x100.ProcessDescriptionType)get_store().insert_element_user(PROCESSDESCRIPTION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ProcessDescription" element
         */
        public net.opengis.wps.x100.ProcessDescriptionType addNewProcessDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessDescriptionType target = null;
                target = (net.opengis.wps.x100.ProcessDescriptionType)get_store().add_element_user(PROCESSDESCRIPTION$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "ProcessDescription" element
         */
        public void removeProcessDescription(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PROCESSDESCRIPTION$0, i);
            }
        }
    }
}

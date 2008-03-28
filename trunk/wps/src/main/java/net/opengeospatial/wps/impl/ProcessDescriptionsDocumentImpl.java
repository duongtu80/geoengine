/*
 * An XML document type.
 * Localname: ProcessDescriptions
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ProcessDescriptionsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * A document containing one ProcessDescriptions(@http://www.opengeospatial.net/wps) element.
 *
 * This is a complex type.
 */
public class ProcessDescriptionsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ProcessDescriptionsDocument
{
    
    public ProcessDescriptionsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSDESCRIPTIONS$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessDescriptions");
    
    
    /**
     * Gets the "ProcessDescriptions" element
     */
    public net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions getProcessDescriptions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions)get_store().find_element_user(PROCESSDESCRIPTIONS$0, 0);
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
    public void setProcessDescriptions(net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions processDescriptions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions)get_store().find_element_user(PROCESSDESCRIPTIONS$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions)get_store().add_element_user(PROCESSDESCRIPTIONS$0);
            }
            target.set(processDescriptions);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessDescriptions" element
     */
    public net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions addNewProcessDescriptions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions target = null;
            target = (net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions)get_store().add_element_user(PROCESSDESCRIPTIONS$0);
            return target;
        }
    }
    /**
     * An XML ProcessDescriptions(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class ProcessDescriptionsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions
    {
        
        public ProcessDescriptionsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROCESSDESCRIPTION$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessDescription");
        
        
        /**
         * Gets array of all "ProcessDescription" elements
         */
        public net.opengeospatial.wps.ProcessDescriptionType[] getProcessDescriptionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PROCESSDESCRIPTION$0, targetList);
                net.opengeospatial.wps.ProcessDescriptionType[] result = new net.opengeospatial.wps.ProcessDescriptionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "ProcessDescription" element
         */
        public net.opengeospatial.wps.ProcessDescriptionType getProcessDescriptionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessDescriptionType target = null;
                target = (net.opengeospatial.wps.ProcessDescriptionType)get_store().find_element_user(PROCESSDESCRIPTION$0, i);
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
        public void setProcessDescriptionArray(net.opengeospatial.wps.ProcessDescriptionType[] processDescriptionArray)
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
        public void setProcessDescriptionArray(int i, net.opengeospatial.wps.ProcessDescriptionType processDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessDescriptionType target = null;
                target = (net.opengeospatial.wps.ProcessDescriptionType)get_store().find_element_user(PROCESSDESCRIPTION$0, i);
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
        public net.opengeospatial.wps.ProcessDescriptionType insertNewProcessDescription(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessDescriptionType target = null;
                target = (net.opengeospatial.wps.ProcessDescriptionType)get_store().insert_element_user(PROCESSDESCRIPTION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ProcessDescription" element
         */
        public net.opengeospatial.wps.ProcessDescriptionType addNewProcessDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessDescriptionType target = null;
                target = (net.opengeospatial.wps.ProcessDescriptionType)get_store().add_element_user(PROCESSDESCRIPTION$0);
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

/*
 * An XML document type.
 * Localname: ProcessOfferings
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ProcessOfferingsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one ProcessOfferings(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class ProcessOfferingsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ProcessOfferingsDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProcessOfferingsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSOFFERINGS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessOfferings");
    
    
    /**
     * Gets the "ProcessOfferings" element
     */
    public net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings getProcessOfferings()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings)get_store().find_element_user(PROCESSOFFERINGS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ProcessOfferings" element
     */
    public void setProcessOfferings(net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings processOfferings)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings)get_store().find_element_user(PROCESSOFFERINGS$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings)get_store().add_element_user(PROCESSOFFERINGS$0);
            }
            target.set(processOfferings);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessOfferings" element
     */
    public net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings addNewProcessOfferings()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings)get_store().add_element_user(PROCESSOFFERINGS$0);
            return target;
        }
    }
    /**
     * An XML ProcessOfferings(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public static class ProcessOfferingsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings
    {
        private static final long serialVersionUID = 1L;
        
        public ProcessOfferingsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROCESS$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Process");
        
        
        /**
         * Gets array of all "Process" elements
         */
        public net.opengis.wps.x100.ProcessBriefType[] getProcessArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PROCESS$0, targetList);
                net.opengis.wps.x100.ProcessBriefType[] result = new net.opengis.wps.x100.ProcessBriefType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Process" element
         */
        public net.opengis.wps.x100.ProcessBriefType getProcessArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessBriefType target = null;
                target = (net.opengis.wps.x100.ProcessBriefType)get_store().find_element_user(PROCESS$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Process" element
         */
        public int sizeOfProcessArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PROCESS$0);
            }
        }
        
        /**
         * Sets array of all "Process" element
         */
        public void setProcessArray(net.opengis.wps.x100.ProcessBriefType[] processArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(processArray, PROCESS$0);
            }
        }
        
        /**
         * Sets ith "Process" element
         */
        public void setProcessArray(int i, net.opengis.wps.x100.ProcessBriefType process)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessBriefType target = null;
                target = (net.opengis.wps.x100.ProcessBriefType)get_store().find_element_user(PROCESS$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(process);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Process" element
         */
        public net.opengis.wps.x100.ProcessBriefType insertNewProcess(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.wps.x100.ProcessBriefType target = null;
                target = (net.opengis.wps.x100.ProcessBriefType)get_store().insert_element_user(PROCESS$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Process" element
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
         * Removes the ith "Process" element
         */
        public void removeProcess(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PROCESS$0, i);
            }
        }
    }
}

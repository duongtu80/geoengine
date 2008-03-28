/*
 * An XML document type.
 * Localname: ProcessOfferings
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ProcessOfferingsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * A document containing one ProcessOfferings(@http://www.opengeospatial.net/wps) element.
 *
 * This is a complex type.
 */
public class ProcessOfferingsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ProcessOfferingsDocument
{
    
    public ProcessOfferingsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSOFFERINGS$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessOfferings");
    
    
    /**
     * Gets the "ProcessOfferings" element
     */
    public net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings getProcessOfferings()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings)get_store().find_element_user(PROCESSOFFERINGS$0, 0);
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
    public void setProcessOfferings(net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings processOfferings)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings)get_store().find_element_user(PROCESSOFFERINGS$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings)get_store().add_element_user(PROCESSOFFERINGS$0);
            }
            target.set(processOfferings);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessOfferings" element
     */
    public net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings addNewProcessOfferings()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings)get_store().add_element_user(PROCESSOFFERINGS$0);
            return target;
        }
    }
    /**
     * An XML ProcessOfferings(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class ProcessOfferingsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings
    {
        
        public ProcessOfferingsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROCESS$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "Process");
        
        
        /**
         * Gets array of all "Process" elements
         */
        public net.opengeospatial.wps.ProcessBriefType[] getProcessArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PROCESS$0, targetList);
                net.opengeospatial.wps.ProcessBriefType[] result = new net.opengeospatial.wps.ProcessBriefType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Process" element
         */
        public net.opengeospatial.wps.ProcessBriefType getProcessArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessBriefType target = null;
                target = (net.opengeospatial.wps.ProcessBriefType)get_store().find_element_user(PROCESS$0, i);
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
        public void setProcessArray(net.opengeospatial.wps.ProcessBriefType[] processArray)
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
        public void setProcessArray(int i, net.opengeospatial.wps.ProcessBriefType process)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessBriefType target = null;
                target = (net.opengeospatial.wps.ProcessBriefType)get_store().find_element_user(PROCESS$0, i);
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
        public net.opengeospatial.wps.ProcessBriefType insertNewProcess(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessBriefType target = null;
                target = (net.opengeospatial.wps.ProcessBriefType)get_store().insert_element_user(PROCESS$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Process" element
         */
        public net.opengeospatial.wps.ProcessBriefType addNewProcess()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.wps.ProcessBriefType target = null;
                target = (net.opengeospatial.wps.ProcessBriefType)get_store().add_element_user(PROCESS$0);
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

/*
 * An XML document type.
 * Localname: DescribeProcess
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.DescribeProcessDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * A document containing one DescribeProcess(@http://www.opengeospatial.net/wps) element.
 *
 * This is a complex type.
 */
public class DescribeProcessDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.DescribeProcessDocument
{
    
    public DescribeProcessDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DESCRIBEPROCESS$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "DescribeProcess");
    
    
    /**
     * Gets the "DescribeProcess" element
     */
    public net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess getDescribeProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess target = null;
            target = (net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess)get_store().find_element_user(DESCRIBEPROCESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DescribeProcess" element
     */
    public void setDescribeProcess(net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess describeProcess)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess target = null;
            target = (net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess)get_store().find_element_user(DESCRIBEPROCESS$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess)get_store().add_element_user(DESCRIBEPROCESS$0);
            }
            target.set(describeProcess);
        }
    }
    
    /**
     * Appends and returns a new empty "DescribeProcess" element
     */
    public net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess addNewDescribeProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess target = null;
            target = (net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess)get_store().add_element_user(DESCRIBEPROCESS$0);
            return target;
        }
    }
    /**
     * An XML DescribeProcess(@http://www.opengeospatial.net/wps).
     *
     * This is a complex type.
     */
    public static class DescribeProcessImpl extends net.opengeospatial.wps.impl.RequestBaseTypeImpl implements net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess
    {
        
        public DescribeProcessImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDENTIFIER$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Identifier");
        
        
        /**
         * Gets array of all "Identifier" elements
         */
        public net.opengeospatial.ows.CodeType[] getIdentifierArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(IDENTIFIER$0, targetList);
                net.opengeospatial.ows.CodeType[] result = new net.opengeospatial.ows.CodeType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Identifier" element
         */
        public net.opengeospatial.ows.CodeType getIdentifierArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.CodeType target = null;
                target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(IDENTIFIER$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Identifier" element
         */
        public int sizeOfIdentifierArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(IDENTIFIER$0);
            }
        }
        
        /**
         * Sets array of all "Identifier" element
         */
        public void setIdentifierArray(net.opengeospatial.ows.CodeType[] identifierArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(identifierArray, IDENTIFIER$0);
            }
        }
        
        /**
         * Sets ith "Identifier" element
         */
        public void setIdentifierArray(int i, net.opengeospatial.ows.CodeType identifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.CodeType target = null;
                target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(IDENTIFIER$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(identifier);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Identifier" element
         */
        public net.opengeospatial.ows.CodeType insertNewIdentifier(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.CodeType target = null;
                target = (net.opengeospatial.ows.CodeType)get_store().insert_element_user(IDENTIFIER$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Identifier" element
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
         * Removes the ith "Identifier" element
         */
        public void removeIdentifier(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(IDENTIFIER$0, i);
            }
        }
    }
}

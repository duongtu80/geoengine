/*
 * An XML document type.
 * Localname: DescribeProcess
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.DescribeProcessDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one DescribeProcess(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class DescribeProcessDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.DescribeProcessDocument
{
    private static final long serialVersionUID = 1L;
    
    public DescribeProcessDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DESCRIBEPROCESS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "DescribeProcess");
    
    
    /**
     * Gets the "DescribeProcess" element
     */
    public net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess getDescribeProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess target = null;
            target = (net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess)get_store().find_element_user(DESCRIBEPROCESS$0, 0);
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
    public void setDescribeProcess(net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess describeProcess)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess target = null;
            target = (net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess)get_store().find_element_user(DESCRIBEPROCESS$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess)get_store().add_element_user(DESCRIBEPROCESS$0);
            }
            target.set(describeProcess);
        }
    }
    
    /**
     * Appends and returns a new empty "DescribeProcess" element
     */
    public net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess addNewDescribeProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess target = null;
            target = (net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess)get_store().add_element_user(DESCRIBEPROCESS$0);
            return target;
        }
    }
    /**
     * An XML DescribeProcess(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public static class DescribeProcessImpl extends net.opengis.wps.x100.impl.RequestBaseTypeImpl implements net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess
    {
        private static final long serialVersionUID = 1L;
        
        public DescribeProcessImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName IDENTIFIER$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Identifier");
        
        
        /**
         * Gets array of all "Identifier" elements
         */
        public net.opengis.ows.x11.CodeType[] getIdentifierArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(IDENTIFIER$0, targetList);
                net.opengis.ows.x11.CodeType[] result = new net.opengis.ows.x11.CodeType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Identifier" element
         */
        public net.opengis.ows.x11.CodeType getIdentifierArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.CodeType target = null;
                target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(IDENTIFIER$0, i);
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
        public void setIdentifierArray(net.opengis.ows.x11.CodeType[] identifierArray)
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
        public void setIdentifierArray(int i, net.opengis.ows.x11.CodeType identifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.CodeType target = null;
                target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(IDENTIFIER$0, i);
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
        public net.opengis.ows.x11.CodeType insertNewIdentifier(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.CodeType target = null;
                target = (net.opengis.ows.x11.CodeType)get_store().insert_element_user(IDENTIFIER$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Identifier" element
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

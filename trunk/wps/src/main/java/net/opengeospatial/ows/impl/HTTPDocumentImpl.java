/*
 * An XML document type.
 * Localname: HTTP
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.HTTPDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one HTTP(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class HTTPDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.HTTPDocument
{
    
    public HTTPDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName HTTP$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "HTTP");
    
    
    /**
     * Gets the "HTTP" element
     */
    public net.opengeospatial.ows.HTTPDocument.HTTP getHTTP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.HTTPDocument.HTTP target = null;
            target = (net.opengeospatial.ows.HTTPDocument.HTTP)get_store().find_element_user(HTTP$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "HTTP" element
     */
    public void setHTTP(net.opengeospatial.ows.HTTPDocument.HTTP http)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.HTTPDocument.HTTP target = null;
            target = (net.opengeospatial.ows.HTTPDocument.HTTP)get_store().find_element_user(HTTP$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.HTTPDocument.HTTP)get_store().add_element_user(HTTP$0);
            }
            target.set(http);
        }
    }
    
    /**
     * Appends and returns a new empty "HTTP" element
     */
    public net.opengeospatial.ows.HTTPDocument.HTTP addNewHTTP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.HTTPDocument.HTTP target = null;
            target = (net.opengeospatial.ows.HTTPDocument.HTTP)get_store().add_element_user(HTTP$0);
            return target;
        }
    }
    /**
     * An XML HTTP(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public static class HTTPImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.HTTPDocument.HTTP
    {
        
        public HTTPImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName GET$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Get");
        private static final javax.xml.namespace.QName POST$2 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Post");
        
        
        /**
         * Gets array of all "Get" elements
         */
        public net.opengeospatial.ows.RequestMethodType[] getGetArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(GET$0, targetList);
                net.opengeospatial.ows.RequestMethodType[] result = new net.opengeospatial.ows.RequestMethodType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Get" element
         */
        public net.opengeospatial.ows.RequestMethodType getGetArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RequestMethodType target = null;
                target = (net.opengeospatial.ows.RequestMethodType)get_store().find_element_user(GET$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Get" element
         */
        public int sizeOfGetArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(GET$0);
            }
        }
        
        /**
         * Sets array of all "Get" element
         */
        public void setGetArray(net.opengeospatial.ows.RequestMethodType[] getArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(getArray, GET$0);
            }
        }
        
        /**
         * Sets ith "Get" element
         */
        public void setGetArray(int i, net.opengeospatial.ows.RequestMethodType get)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RequestMethodType target = null;
                target = (net.opengeospatial.ows.RequestMethodType)get_store().find_element_user(GET$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(get);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Get" element
         */
        public net.opengeospatial.ows.RequestMethodType insertNewGet(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RequestMethodType target = null;
                target = (net.opengeospatial.ows.RequestMethodType)get_store().insert_element_user(GET$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Get" element
         */
        public net.opengeospatial.ows.RequestMethodType addNewGet()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RequestMethodType target = null;
                target = (net.opengeospatial.ows.RequestMethodType)get_store().add_element_user(GET$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Get" element
         */
        public void removeGet(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(GET$0, i);
            }
        }
        
        /**
         * Gets array of all "Post" elements
         */
        public net.opengeospatial.ows.RequestMethodType[] getPostArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(POST$2, targetList);
                net.opengeospatial.ows.RequestMethodType[] result = new net.opengeospatial.ows.RequestMethodType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Post" element
         */
        public net.opengeospatial.ows.RequestMethodType getPostArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RequestMethodType target = null;
                target = (net.opengeospatial.ows.RequestMethodType)get_store().find_element_user(POST$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Post" element
         */
        public int sizeOfPostArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(POST$2);
            }
        }
        
        /**
         * Sets array of all "Post" element
         */
        public void setPostArray(net.opengeospatial.ows.RequestMethodType[] postArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(postArray, POST$2);
            }
        }
        
        /**
         * Sets ith "Post" element
         */
        public void setPostArray(int i, net.opengeospatial.ows.RequestMethodType post)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RequestMethodType target = null;
                target = (net.opengeospatial.ows.RequestMethodType)get_store().find_element_user(POST$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(post);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Post" element
         */
        public net.opengeospatial.ows.RequestMethodType insertNewPost(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RequestMethodType target = null;
                target = (net.opengeospatial.ows.RequestMethodType)get_store().insert_element_user(POST$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Post" element
         */
        public net.opengeospatial.ows.RequestMethodType addNewPost()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RequestMethodType target = null;
                target = (net.opengeospatial.ows.RequestMethodType)get_store().add_element_user(POST$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "Post" element
         */
        public void removePost(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(POST$2, i);
            }
        }
    }
}

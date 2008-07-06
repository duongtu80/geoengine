/*
 * An XML document type.
 * Localname: DCP
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.DCPDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one DCP(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class DCPDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.DCPDocument
{
    
    public DCPDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DCP$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "DCP");
    
    
    /**
     * Gets the "DCP" element
     */
    public net.opengeospatial.ows.DCPDocument.DCP getDCP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DCPDocument.DCP target = null;
            target = (net.opengeospatial.ows.DCPDocument.DCP)get_store().find_element_user(DCP$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DCP" element
     */
    public void setDCP(net.opengeospatial.ows.DCPDocument.DCP dcp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DCPDocument.DCP target = null;
            target = (net.opengeospatial.ows.DCPDocument.DCP)get_store().find_element_user(DCP$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DCPDocument.DCP)get_store().add_element_user(DCP$0);
            }
            target.set(dcp);
        }
    }
    
    /**
     * Appends and returns a new empty "DCP" element
     */
    public net.opengeospatial.ows.DCPDocument.DCP addNewDCP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DCPDocument.DCP target = null;
            target = (net.opengeospatial.ows.DCPDocument.DCP)get_store().add_element_user(DCP$0);
            return target;
        }
    }
    /**
     * An XML DCP(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public static class DCPImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.DCPDocument.DCP
    {
        
        public DCPImpl(org.apache.xmlbeans.SchemaType sType)
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
    }
}

/*
 * An XML document type.
 * Localname: DCP
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.DCPDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one DCP(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class DCPDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.DCPDocument
{
    private static final long serialVersionUID = 1L;
    
    public DCPDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DCP$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DCP");
    
    
    /**
     * Gets the "DCP" element
     */
    public net.opengis.ows.x11.DCPDocument.DCP getDCP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DCPDocument.DCP target = null;
            target = (net.opengis.ows.x11.DCPDocument.DCP)get_store().find_element_user(DCP$0, 0);
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
    public void setDCP(net.opengis.ows.x11.DCPDocument.DCP dcp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DCPDocument.DCP target = null;
            target = (net.opengis.ows.x11.DCPDocument.DCP)get_store().find_element_user(DCP$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.DCPDocument.DCP)get_store().add_element_user(DCP$0);
            }
            target.set(dcp);
        }
    }
    
    /**
     * Appends and returns a new empty "DCP" element
     */
    public net.opengis.ows.x11.DCPDocument.DCP addNewDCP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DCPDocument.DCP target = null;
            target = (net.opengis.ows.x11.DCPDocument.DCP)get_store().add_element_user(DCP$0);
            return target;
        }
    }
    /**
     * An XML DCP(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public static class DCPImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.DCPDocument.DCP
    {
        private static final long serialVersionUID = 1L;
        
        public DCPImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName HTTP$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "HTTP");
        
        
        /**
         * Gets the "HTTP" element
         */
        public net.opengis.ows.x11.HTTPDocument.HTTP getHTTP()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.HTTPDocument.HTTP target = null;
                target = (net.opengis.ows.x11.HTTPDocument.HTTP)get_store().find_element_user(HTTP$0, 0);
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
        public void setHTTP(net.opengis.ows.x11.HTTPDocument.HTTP http)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.HTTPDocument.HTTP target = null;
                target = (net.opengis.ows.x11.HTTPDocument.HTTP)get_store().find_element_user(HTTP$0, 0);
                if (target == null)
                {
                    target = (net.opengis.ows.x11.HTTPDocument.HTTP)get_store().add_element_user(HTTP$0);
                }
                target.set(http);
            }
        }
        
        /**
         * Appends and returns a new empty "HTTP" element
         */
        public net.opengis.ows.x11.HTTPDocument.HTTP addNewHTTP()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.HTTPDocument.HTTP target = null;
                target = (net.opengis.ows.x11.HTTPDocument.HTTP)get_store().add_element_user(HTTP$0);
                return target;
            }
        }
    }
}

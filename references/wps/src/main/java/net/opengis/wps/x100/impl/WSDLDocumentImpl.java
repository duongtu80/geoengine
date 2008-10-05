/*
 * An XML document type.
 * Localname: WSDL
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.WSDLDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one WSDL(@http://www.opengis.net/wps/1.0.0) element.
 *
 * This is a complex type.
 */
public class WSDLDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.WSDLDocument
{
    private static final long serialVersionUID = 1L;
    
    public WSDLDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WSDL$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "WSDL");
    
    
    /**
     * Gets the "WSDL" element
     */
    public net.opengis.wps.x100.WSDLDocument.WSDL getWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().find_element_user(WSDL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "WSDL" element
     */
    public void setWSDL(net.opengis.wps.x100.WSDLDocument.WSDL wsdl)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().find_element_user(WSDL$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().add_element_user(WSDL$0);
            }
            target.set(wsdl);
        }
    }
    
    /**
     * Appends and returns a new empty "WSDL" element
     */
    public net.opengis.wps.x100.WSDLDocument.WSDL addNewWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().add_element_user(WSDL$0);
            return target;
        }
    }
    /**
     * An XML WSDL(@http://www.opengis.net/wps/1.0.0).
     *
     * This is a complex type.
     */
    public static class WSDLImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.WSDLDocument.WSDL
    {
        private static final long serialVersionUID = 1L;
        
        public WSDLImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName HREF$0 = 
            new javax.xml.namespace.QName("http://www.w3.org/1999/xlink", "href");
        
        
        /**
         * Gets the "href" attribute
         */
        public java.lang.String getHref()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HREF$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "href" attribute
         */
        public org.apache.xmlbeans.XmlAnyURI xgetHref()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(HREF$0);
                return target;
            }
        }
        
        /**
         * Sets the "href" attribute
         */
        public void setHref(java.lang.String href)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HREF$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(HREF$0);
                }
                target.setStringValue(href);
            }
        }
        
        /**
         * Sets (as xml) the "href" attribute
         */
        public void xsetHref(org.apache.xmlbeans.XmlAnyURI href)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlAnyURI target = null;
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(HREF$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(HREF$0);
                }
                target.set(href);
            }
        }
    }
}

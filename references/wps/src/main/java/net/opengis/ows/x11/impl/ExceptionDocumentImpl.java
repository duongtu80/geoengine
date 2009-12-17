/*
 * An XML document type.
 * Localname: Exception
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ExceptionDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Exception(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class ExceptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.ExceptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public ExceptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXCEPTION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Exception");
    
    
    /**
     * Gets the "Exception" element
     */
    public net.opengis.ows.x11.ExceptionType getException()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionType target = null;
            target = (net.opengis.ows.x11.ExceptionType)get_store().find_element_user(EXCEPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Exception" element
     */
    public void setException(net.opengis.ows.x11.ExceptionType exception)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionType target = null;
            target = (net.opengis.ows.x11.ExceptionType)get_store().find_element_user(EXCEPTION$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ExceptionType)get_store().add_element_user(EXCEPTION$0);
            }
            target.set(exception);
        }
    }
    
    /**
     * Appends and returns a new empty "Exception" element
     */
    public net.opengis.ows.x11.ExceptionType addNewException()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionType target = null;
            target = (net.opengis.ows.x11.ExceptionType)get_store().add_element_user(EXCEPTION$0);
            return target;
        }
    }
}

/*
 * XML Type:  ServiceReferenceType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ServiceReferenceType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML ServiceReferenceType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class ServiceReferenceTypeImpl extends net.opengis.ows.x11.impl.ReferenceTypeImpl implements net.opengis.ows.x11.ServiceReferenceType
{
    private static final long serialVersionUID = 1L;
    
    public ServiceReferenceTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REQUESTMESSAGE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "RequestMessage");
    private static final javax.xml.namespace.QName REQUESTMESSAGEREFERENCE$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "RequestMessageReference");
    
    
    /**
     * Gets the "RequestMessage" element
     */
    public org.apache.xmlbeans.XmlObject getRequestMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(REQUESTMESSAGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "RequestMessage" element
     */
    public boolean isSetRequestMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REQUESTMESSAGE$0) != 0;
        }
    }
    
    /**
     * Sets the "RequestMessage" element
     */
    public void setRequestMessage(org.apache.xmlbeans.XmlObject requestMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(REQUESTMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(REQUESTMESSAGE$0);
            }
            target.set(requestMessage);
        }
    }
    
    /**
     * Appends and returns a new empty "RequestMessage" element
     */
    public org.apache.xmlbeans.XmlObject addNewRequestMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlObject target = null;
            target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(REQUESTMESSAGE$0);
            return target;
        }
    }
    
    /**
     * Unsets the "RequestMessage" element
     */
    public void unsetRequestMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REQUESTMESSAGE$0, 0);
        }
    }
    
    /**
     * Gets the "RequestMessageReference" element
     */
    public java.lang.String getRequestMessageReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUESTMESSAGEREFERENCE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "RequestMessageReference" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetRequestMessageReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(REQUESTMESSAGEREFERENCE$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "RequestMessageReference" element
     */
    public boolean isSetRequestMessageReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REQUESTMESSAGEREFERENCE$2) != 0;
        }
    }
    
    /**
     * Sets the "RequestMessageReference" element
     */
    public void setRequestMessageReference(java.lang.String requestMessageReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(REQUESTMESSAGEREFERENCE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(REQUESTMESSAGEREFERENCE$2);
            }
            target.setStringValue(requestMessageReference);
        }
    }
    
    /**
     * Sets (as xml) the "RequestMessageReference" element
     */
    public void xsetRequestMessageReference(org.apache.xmlbeans.XmlAnyURI requestMessageReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(REQUESTMESSAGEREFERENCE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(REQUESTMESSAGEREFERENCE$2);
            }
            target.set(requestMessageReference);
        }
    }
    
    /**
     * Unsets the "RequestMessageReference" element
     */
    public void unsetRequestMessageReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REQUESTMESSAGEREFERENCE$2, 0);
        }
    }
}

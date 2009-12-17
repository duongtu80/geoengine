/*
 * An XML document type.
 * Localname: OperationResponse
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.OperationResponseDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one OperationResponse(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class OperationResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.OperationResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public OperationResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPERATIONRESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "OperationResponse");
    
    
    /**
     * Gets the "OperationResponse" element
     */
    public net.opengis.ows.x11.ManifestType getOperationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().find_element_user(OPERATIONRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "OperationResponse" element
     */
    public void setOperationResponse(net.opengis.ows.x11.ManifestType operationResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().find_element_user(OPERATIONRESPONSE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ManifestType)get_store().add_element_user(OPERATIONRESPONSE$0);
            }
            target.set(operationResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "OperationResponse" element
     */
    public net.opengis.ows.x11.ManifestType addNewOperationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().add_element_user(OPERATIONRESPONSE$0);
            return target;
        }
    }
}

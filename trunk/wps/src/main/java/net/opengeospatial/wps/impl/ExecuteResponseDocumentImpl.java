/*
 * An XML document type.
 * Localname: ExecuteResponse
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ExecuteResponseDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * A document containing one ExecuteResponse(@http://www.opengeospatial.net/wps) element.
 *
 * This is a complex type.
 */
public class ExecuteResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ExecuteResponseDocument
{
    
    public ExecuteResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXECUTERESPONSE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ExecuteResponse");
    
    
    /**
     * Gets the "ExecuteResponse" element
     */
    public net.opengeospatial.wps.ExecuteResponseType getExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteResponseType target = null;
            target = (net.opengeospatial.wps.ExecuteResponseType)get_store().find_element_user(EXECUTERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ExecuteResponse" element
     */
    public void setExecuteResponse(net.opengeospatial.wps.ExecuteResponseType executeResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteResponseType target = null;
            target = (net.opengeospatial.wps.ExecuteResponseType)get_store().find_element_user(EXECUTERESPONSE$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ExecuteResponseType)get_store().add_element_user(EXECUTERESPONSE$0);
            }
            target.set(executeResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "ExecuteResponse" element
     */
    public net.opengeospatial.wps.ExecuteResponseType addNewExecuteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ExecuteResponseType target = null;
            target = (net.opengeospatial.wps.ExecuteResponseType)get_store().add_element_user(EXECUTERESPONSE$0);
            return target;
        }
    }
}

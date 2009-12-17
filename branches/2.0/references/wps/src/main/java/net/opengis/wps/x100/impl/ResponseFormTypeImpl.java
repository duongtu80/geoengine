/*
 * XML Type:  ResponseFormType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ResponseFormType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ResponseFormType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class ResponseFormTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ResponseFormType
{
    private static final long serialVersionUID = 1L;
    
    public ResponseFormTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESPONSEDOCUMENT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ResponseDocument");
    private static final javax.xml.namespace.QName RAWDATAOUTPUT$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "RawDataOutput");
    
    
    /**
     * Gets the "ResponseDocument" element
     */
    public net.opengis.wps.x100.ResponseDocumentType getResponseDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ResponseDocumentType target = null;
            target = (net.opengis.wps.x100.ResponseDocumentType)get_store().find_element_user(RESPONSEDOCUMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ResponseDocument" element
     */
    public boolean isSetResponseDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESPONSEDOCUMENT$0) != 0;
        }
    }
    
    /**
     * Sets the "ResponseDocument" element
     */
    public void setResponseDocument(net.opengis.wps.x100.ResponseDocumentType responseDocument)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ResponseDocumentType target = null;
            target = (net.opengis.wps.x100.ResponseDocumentType)get_store().find_element_user(RESPONSEDOCUMENT$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ResponseDocumentType)get_store().add_element_user(RESPONSEDOCUMENT$0);
            }
            target.set(responseDocument);
        }
    }
    
    /**
     * Appends and returns a new empty "ResponseDocument" element
     */
    public net.opengis.wps.x100.ResponseDocumentType addNewResponseDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ResponseDocumentType target = null;
            target = (net.opengis.wps.x100.ResponseDocumentType)get_store().add_element_user(RESPONSEDOCUMENT$0);
            return target;
        }
    }
    
    /**
     * Unsets the "ResponseDocument" element
     */
    public void unsetResponseDocument()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESPONSEDOCUMENT$0, 0);
        }
    }
    
    /**
     * Gets the "RawDataOutput" element
     */
    public net.opengis.wps.x100.OutputDefinitionType getRawDataOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.OutputDefinitionType target = null;
            target = (net.opengis.wps.x100.OutputDefinitionType)get_store().find_element_user(RAWDATAOUTPUT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "RawDataOutput" element
     */
    public boolean isSetRawDataOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RAWDATAOUTPUT$2) != 0;
        }
    }
    
    /**
     * Sets the "RawDataOutput" element
     */
    public void setRawDataOutput(net.opengis.wps.x100.OutputDefinitionType rawDataOutput)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.OutputDefinitionType target = null;
            target = (net.opengis.wps.x100.OutputDefinitionType)get_store().find_element_user(RAWDATAOUTPUT$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.OutputDefinitionType)get_store().add_element_user(RAWDATAOUTPUT$2);
            }
            target.set(rawDataOutput);
        }
    }
    
    /**
     * Appends and returns a new empty "RawDataOutput" element
     */
    public net.opengis.wps.x100.OutputDefinitionType addNewRawDataOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.OutputDefinitionType target = null;
            target = (net.opengis.wps.x100.OutputDefinitionType)get_store().add_element_user(RAWDATAOUTPUT$2);
            return target;
        }
    }
    
    /**
     * Unsets the "RawDataOutput" element
     */
    public void unsetRawDataOutput()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RAWDATAOUTPUT$2, 0);
        }
    }
}

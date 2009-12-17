/*
 * An XML document type.
 * Localname: InputData
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.InputDataDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one InputData(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class InputDataDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.InputDataDocument
{
    private static final long serialVersionUID = 1L;
    
    public InputDataDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INPUTDATA$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "InputData");
    
    
    /**
     * Gets the "InputData" element
     */
    public net.opengis.ows.x11.ManifestType getInputData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().find_element_user(INPUTDATA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "InputData" element
     */
    public void setInputData(net.opengis.ows.x11.ManifestType inputData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().find_element_user(INPUTDATA$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ManifestType)get_store().add_element_user(INPUTDATA$0);
            }
            target.set(inputData);
        }
    }
    
    /**
     * Appends and returns a new empty "InputData" element
     */
    public net.opengis.ows.x11.ManifestType addNewInputData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ManifestType target = null;
            target = (net.opengis.ows.x11.ManifestType)get_store().add_element_user(INPUTDATA$0);
            return target;
        }
    }
}

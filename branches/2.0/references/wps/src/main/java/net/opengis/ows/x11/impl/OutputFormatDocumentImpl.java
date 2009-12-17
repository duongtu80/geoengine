/*
 * An XML document type.
 * Localname: OutputFormat
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.OutputFormatDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one OutputFormat(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class OutputFormatDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.OutputFormatDocument
{
    private static final long serialVersionUID = 1L;
    
    public OutputFormatDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUTPUTFORMAT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "OutputFormat");
    
    
    /**
     * Gets the "OutputFormat" element
     */
    public java.lang.String getOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "OutputFormat" element
     */
    public net.opengis.ows.x11.MimeType xgetOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(OUTPUTFORMAT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "OutputFormat" element
     */
    public void setOutputFormat(java.lang.String outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUTPUTFORMAT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OUTPUTFORMAT$0);
            }
            target.setStringValue(outputFormat);
        }
    }
    
    /**
     * Sets (as xml) the "OutputFormat" element
     */
    public void xsetOutputFormat(net.opengis.ows.x11.MimeType outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.MimeType target = null;
            target = (net.opengis.ows.x11.MimeType)get_store().find_element_user(OUTPUTFORMAT$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.MimeType)get_store().add_element_user(OUTPUTFORMAT$0);
            }
            target.set(outputFormat);
        }
    }
}

/*
 * An XML document type.
 * Localname: OutputFormat
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.OutputFormatDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one OutputFormat(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class OutputFormatDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.OutputFormatDocument
{
    
    public OutputFormatDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUTPUTFORMAT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "OutputFormat");
    
    
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
    public net.opengeospatial.ows.MimeType xgetOutputFormat()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_element_user(OUTPUTFORMAT$0, 0);
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
    public void xsetOutputFormat(net.opengeospatial.ows.MimeType outputFormat)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MimeType target = null;
            target = (net.opengeospatial.ows.MimeType)get_store().find_element_user(OUTPUTFORMAT$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.MimeType)get_store().add_element_user(OUTPUTFORMAT$0);
            }
            target.set(outputFormat);
        }
    }
}

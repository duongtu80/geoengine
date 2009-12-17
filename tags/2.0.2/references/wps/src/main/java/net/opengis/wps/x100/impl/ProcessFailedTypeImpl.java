/*
 * XML Type:  ProcessFailedType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ProcessFailedType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ProcessFailedType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class ProcessFailedTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ProcessFailedType
{
    private static final long serialVersionUID = 1L;
    
    public ProcessFailedTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXCEPTIONREPORT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ExceptionReport");
    
    
    /**
     * Gets the "ExceptionReport" element
     */
    public net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport getExceptionReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport)get_store().find_element_user(EXCEPTIONREPORT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ExceptionReport" element
     */
    public void setExceptionReport(net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport exceptionReport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport)get_store().find_element_user(EXCEPTIONREPORT$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport)get_store().add_element_user(EXCEPTIONREPORT$0);
            }
            target.set(exceptionReport);
        }
    }
    
    /**
     * Appends and returns a new empty "ExceptionReport" element
     */
    public net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport addNewExceptionReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport)get_store().add_element_user(EXCEPTIONREPORT$0);
            return target;
        }
    }
}

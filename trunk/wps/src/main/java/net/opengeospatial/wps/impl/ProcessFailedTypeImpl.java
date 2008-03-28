/*
 * XML Type:  ProcessFailedType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ProcessFailedType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML ProcessFailedType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class ProcessFailedTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.ProcessFailedType
{
    
    public ProcessFailedTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXCEPTIONREPORT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ExceptionReport");
    
    
    /**
     * Gets the "ExceptionReport" element
     */
    public net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport getExceptionReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport)get_store().find_element_user(EXCEPTIONREPORT$0, 0);
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
    public void setExceptionReport(net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport exceptionReport)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport)get_store().find_element_user(EXCEPTIONREPORT$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport)get_store().add_element_user(EXCEPTIONREPORT$0);
            }
            target.set(exceptionReport);
        }
    }
    
    /**
     * Appends and returns a new empty "ExceptionReport" element
     */
    public net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport addNewExceptionReport()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport target = null;
            target = (net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport)get_store().add_element_user(EXCEPTIONREPORT$0);
            return target;
        }
    }
}

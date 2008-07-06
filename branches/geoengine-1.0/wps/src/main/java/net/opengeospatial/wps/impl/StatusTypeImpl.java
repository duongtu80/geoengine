/*
 * XML Type:  StatusType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.StatusType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML StatusType(@http://www.opengeospatial.net/wps).
 *
 * This is a complex type.
 */
public class StatusTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.wps.StatusType
{
    
    public StatusTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSACCEPTED$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessAccepted");
    private static final javax.xml.namespace.QName PROCESSSTARTED$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessStarted");
    private static final javax.xml.namespace.QName PROCESSSUCCEEDED$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessSucceeded");
    private static final javax.xml.namespace.QName PROCESSFAILED$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/wps", "ProcessFailed");
    
    
    /**
     * Gets the "ProcessAccepted" element
     */
    public java.lang.String getProcessAccepted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROCESSACCEPTED$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProcessAccepted" element
     */
    public org.apache.xmlbeans.XmlString xgetProcessAccepted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROCESSACCEPTED$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "ProcessAccepted" element
     */
    public boolean isSetProcessAccepted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESSACCEPTED$0) != 0;
        }
    }
    
    /**
     * Sets the "ProcessAccepted" element
     */
    public void setProcessAccepted(java.lang.String processAccepted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROCESSACCEPTED$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROCESSACCEPTED$0);
            }
            target.setStringValue(processAccepted);
        }
    }
    
    /**
     * Sets (as xml) the "ProcessAccepted" element
     */
    public void xsetProcessAccepted(org.apache.xmlbeans.XmlString processAccepted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROCESSACCEPTED$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROCESSACCEPTED$0);
            }
            target.set(processAccepted);
        }
    }
    
    /**
     * Unsets the "ProcessAccepted" element
     */
    public void unsetProcessAccepted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESSACCEPTED$0, 0);
        }
    }
    
    /**
     * Gets the "ProcessStarted" element
     */
    public net.opengeospatial.wps.ProcessStartedType getProcessStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessStartedType target = null;
            target = (net.opengeospatial.wps.ProcessStartedType)get_store().find_element_user(PROCESSSTARTED$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ProcessStarted" element
     */
    public boolean isSetProcessStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESSSTARTED$2) != 0;
        }
    }
    
    /**
     * Sets the "ProcessStarted" element
     */
    public void setProcessStarted(net.opengeospatial.wps.ProcessStartedType processStarted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessStartedType target = null;
            target = (net.opengeospatial.wps.ProcessStartedType)get_store().find_element_user(PROCESSSTARTED$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ProcessStartedType)get_store().add_element_user(PROCESSSTARTED$2);
            }
            target.set(processStarted);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessStarted" element
     */
    public net.opengeospatial.wps.ProcessStartedType addNewProcessStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessStartedType target = null;
            target = (net.opengeospatial.wps.ProcessStartedType)get_store().add_element_user(PROCESSSTARTED$2);
            return target;
        }
    }
    
    /**
     * Unsets the "ProcessStarted" element
     */
    public void unsetProcessStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESSSTARTED$2, 0);
        }
    }
    
    /**
     * Gets the "ProcessSucceeded" element
     */
    public java.lang.String getProcessSucceeded()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROCESSSUCCEEDED$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ProcessSucceeded" element
     */
    public org.apache.xmlbeans.XmlString xgetProcessSucceeded()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROCESSSUCCEEDED$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "ProcessSucceeded" element
     */
    public boolean isSetProcessSucceeded()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESSSUCCEEDED$4) != 0;
        }
    }
    
    /**
     * Sets the "ProcessSucceeded" element
     */
    public void setProcessSucceeded(java.lang.String processSucceeded)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROCESSSUCCEEDED$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROCESSSUCCEEDED$4);
            }
            target.setStringValue(processSucceeded);
        }
    }
    
    /**
     * Sets (as xml) the "ProcessSucceeded" element
     */
    public void xsetProcessSucceeded(org.apache.xmlbeans.XmlString processSucceeded)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROCESSSUCCEEDED$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROCESSSUCCEEDED$4);
            }
            target.set(processSucceeded);
        }
    }
    
    /**
     * Unsets the "ProcessSucceeded" element
     */
    public void unsetProcessSucceeded()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESSSUCCEEDED$4, 0);
        }
    }
    
    /**
     * Gets the "ProcessFailed" element
     */
    public net.opengeospatial.wps.ProcessFailedType getProcessFailed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessFailedType target = null;
            target = (net.opengeospatial.wps.ProcessFailedType)get_store().find_element_user(PROCESSFAILED$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ProcessFailed" element
     */
    public boolean isSetProcessFailed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESSFAILED$6) != 0;
        }
    }
    
    /**
     * Sets the "ProcessFailed" element
     */
    public void setProcessFailed(net.opengeospatial.wps.ProcessFailedType processFailed)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessFailedType target = null;
            target = (net.opengeospatial.wps.ProcessFailedType)get_store().find_element_user(PROCESSFAILED$6, 0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ProcessFailedType)get_store().add_element_user(PROCESSFAILED$6);
            }
            target.set(processFailed);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessFailed" element
     */
    public net.opengeospatial.wps.ProcessFailedType addNewProcessFailed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessFailedType target = null;
            target = (net.opengeospatial.wps.ProcessFailedType)get_store().add_element_user(PROCESSFAILED$6);
            return target;
        }
    }
    
    /**
     * Unsets the "ProcessFailed" element
     */
    public void unsetProcessFailed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESSFAILED$6, 0);
        }
    }
}

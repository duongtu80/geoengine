/*
 * XML Type:  StatusType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.StatusType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML StatusType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class StatusTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.StatusType
{
    private static final long serialVersionUID = 1L;
    
    public StatusTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSACCEPTED$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessAccepted");
    private static final javax.xml.namespace.QName PROCESSSTARTED$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessStarted");
    private static final javax.xml.namespace.QName PROCESSPAUSED$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessPaused");
    private static final javax.xml.namespace.QName PROCESSSUCCEEDED$6 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessSucceeded");
    private static final javax.xml.namespace.QName PROCESSFAILED$8 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessFailed");
    private static final javax.xml.namespace.QName CREATIONTIME$10 = 
        new javax.xml.namespace.QName("", "creationTime");
    
    
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
    public net.opengis.wps.x100.ProcessStartedType getProcessStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessStartedType target = null;
            target = (net.opengis.wps.x100.ProcessStartedType)get_store().find_element_user(PROCESSSTARTED$2, 0);
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
    public void setProcessStarted(net.opengis.wps.x100.ProcessStartedType processStarted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessStartedType target = null;
            target = (net.opengis.wps.x100.ProcessStartedType)get_store().find_element_user(PROCESSSTARTED$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ProcessStartedType)get_store().add_element_user(PROCESSSTARTED$2);
            }
            target.set(processStarted);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessStarted" element
     */
    public net.opengis.wps.x100.ProcessStartedType addNewProcessStarted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessStartedType target = null;
            target = (net.opengis.wps.x100.ProcessStartedType)get_store().add_element_user(PROCESSSTARTED$2);
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
     * Gets the "ProcessPaused" element
     */
    public net.opengis.wps.x100.ProcessStartedType getProcessPaused()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessStartedType target = null;
            target = (net.opengis.wps.x100.ProcessStartedType)get_store().find_element_user(PROCESSPAUSED$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ProcessPaused" element
     */
    public boolean isSetProcessPaused()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESSPAUSED$4) != 0;
        }
    }
    
    /**
     * Sets the "ProcessPaused" element
     */
    public void setProcessPaused(net.opengis.wps.x100.ProcessStartedType processPaused)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessStartedType target = null;
            target = (net.opengis.wps.x100.ProcessStartedType)get_store().find_element_user(PROCESSPAUSED$4, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ProcessStartedType)get_store().add_element_user(PROCESSPAUSED$4);
            }
            target.set(processPaused);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessPaused" element
     */
    public net.opengis.wps.x100.ProcessStartedType addNewProcessPaused()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessStartedType target = null;
            target = (net.opengis.wps.x100.ProcessStartedType)get_store().add_element_user(PROCESSPAUSED$4);
            return target;
        }
    }
    
    /**
     * Unsets the "ProcessPaused" element
     */
    public void unsetProcessPaused()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESSPAUSED$4, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROCESSSUCCEEDED$6, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROCESSSUCCEEDED$6, 0);
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
            return get_store().count_elements(PROCESSSUCCEEDED$6) != 0;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROCESSSUCCEEDED$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROCESSSUCCEEDED$6);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PROCESSSUCCEEDED$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PROCESSSUCCEEDED$6);
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
            get_store().remove_element(PROCESSSUCCEEDED$6, 0);
        }
    }
    
    /**
     * Gets the "ProcessFailed" element
     */
    public net.opengis.wps.x100.ProcessFailedType getProcessFailed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessFailedType target = null;
            target = (net.opengis.wps.x100.ProcessFailedType)get_store().find_element_user(PROCESSFAILED$8, 0);
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
            return get_store().count_elements(PROCESSFAILED$8) != 0;
        }
    }
    
    /**
     * Sets the "ProcessFailed" element
     */
    public void setProcessFailed(net.opengis.wps.x100.ProcessFailedType processFailed)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessFailedType target = null;
            target = (net.opengis.wps.x100.ProcessFailedType)get_store().find_element_user(PROCESSFAILED$8, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ProcessFailedType)get_store().add_element_user(PROCESSFAILED$8);
            }
            target.set(processFailed);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessFailed" element
     */
    public net.opengis.wps.x100.ProcessFailedType addNewProcessFailed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessFailedType target = null;
            target = (net.opengis.wps.x100.ProcessFailedType)get_store().add_element_user(PROCESSFAILED$8);
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
            get_store().remove_element(PROCESSFAILED$8, 0);
        }
    }
    
    /**
     * Gets the "creationTime" attribute
     */
    public java.util.Calendar getCreationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CREATIONTIME$10);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "creationTime" attribute
     */
    public org.apache.xmlbeans.XmlDateTime xgetCreationTime()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_attribute_user(CREATIONTIME$10);
            return target;
        }
    }
    
    /**
     * Sets the "creationTime" attribute
     */
    public void setCreationTime(java.util.Calendar creationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CREATIONTIME$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CREATIONTIME$10);
            }
            target.setCalendarValue(creationTime);
        }
    }
    
    /**
     * Sets (as xml) the "creationTime" attribute
     */
    public void xsetCreationTime(org.apache.xmlbeans.XmlDateTime creationTime)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_attribute_user(CREATIONTIME$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_attribute_user(CREATIONTIME$10);
            }
            target.set(creationTime);
        }
    }
}

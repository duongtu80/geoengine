/*
 * XML Type:  ProcessStartedType
 * Namespace: http://www.opengeospatial.net/wps
 * Java type: net.opengeospatial.wps.ProcessStartedType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.wps.impl;
/**
 * An XML ProcessStartedType(@http://www.opengeospatial.net/wps).
 *
 * This is an atomic type that is a restriction of net.opengeospatial.wps.ProcessStartedType.
 */
public class ProcessStartedTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements net.opengeospatial.wps.ProcessStartedType
{
    
    public ProcessStartedTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, true);
    }
    
    protected ProcessStartedTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
    
    private static final javax.xml.namespace.QName PERCENTCOMPLETED$0 = 
        new javax.xml.namespace.QName("", "PercentCompleted");
    
    
    /**
     * Gets the "PercentCompleted" attribute
     */
    public int getPercentCompleted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PERCENTCOMPLETED$0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "PercentCompleted" attribute
     */
    public net.opengeospatial.wps.ProcessStartedType.PercentCompleted xgetPercentCompleted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessStartedType.PercentCompleted target = null;
            target = (net.opengeospatial.wps.ProcessStartedType.PercentCompleted)get_store().find_attribute_user(PERCENTCOMPLETED$0);
            return target;
        }
    }
    
    /**
     * True if has "PercentCompleted" attribute
     */
    public boolean isSetPercentCompleted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PERCENTCOMPLETED$0) != null;
        }
    }
    
    /**
     * Sets the "PercentCompleted" attribute
     */
    public void setPercentCompleted(int percentCompleted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PERCENTCOMPLETED$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PERCENTCOMPLETED$0);
            }
            target.setIntValue(percentCompleted);
        }
    }
    
    /**
     * Sets (as xml) the "PercentCompleted" attribute
     */
    public void xsetPercentCompleted(net.opengeospatial.wps.ProcessStartedType.PercentCompleted percentCompleted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.wps.ProcessStartedType.PercentCompleted target = null;
            target = (net.opengeospatial.wps.ProcessStartedType.PercentCompleted)get_store().find_attribute_user(PERCENTCOMPLETED$0);
            if (target == null)
            {
                target = (net.opengeospatial.wps.ProcessStartedType.PercentCompleted)get_store().add_attribute_user(PERCENTCOMPLETED$0);
            }
            target.set(percentCompleted);
        }
    }
    
    /**
     * Unsets the "PercentCompleted" attribute
     */
    public void unsetPercentCompleted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PERCENTCOMPLETED$0);
        }
    }
    /**
     * An XML PercentCompleted(@).
     *
     * This is an atomic type that is a restriction of net.opengeospatial.wps.ProcessStartedType$PercentCompleted.
     */
    public static class PercentCompletedImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements net.opengeospatial.wps.ProcessStartedType.PercentCompleted
    {
        
        public PercentCompletedImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected PercentCompletedImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}

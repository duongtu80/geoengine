/*
 * XML Type:  ProcessStartedType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ProcessStartedType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ProcessStartedType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is an atomic type that is a restriction of net.opengis.wps.x100.ProcessStartedType.
 */
public class ProcessStartedTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements net.opengis.wps.x100.ProcessStartedType
{
    private static final long serialVersionUID = 1L;
    
    public ProcessStartedTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, true);
    }
    
    protected ProcessStartedTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
    
    private static final javax.xml.namespace.QName PERCENTCOMPLETED$0 = 
        new javax.xml.namespace.QName("", "percentCompleted");
    
    
    /**
     * Gets the "percentCompleted" attribute
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
     * Gets (as xml) the "percentCompleted" attribute
     */
    public net.opengis.wps.x100.ProcessStartedType.PercentCompleted xgetPercentCompleted()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessStartedType.PercentCompleted target = null;
            target = (net.opengis.wps.x100.ProcessStartedType.PercentCompleted)get_store().find_attribute_user(PERCENTCOMPLETED$0);
            return target;
        }
    }
    
    /**
     * True if has "percentCompleted" attribute
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
     * Sets the "percentCompleted" attribute
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
     * Sets (as xml) the "percentCompleted" attribute
     */
    public void xsetPercentCompleted(net.opengis.wps.x100.ProcessStartedType.PercentCompleted percentCompleted)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessStartedType.PercentCompleted target = null;
            target = (net.opengis.wps.x100.ProcessStartedType.PercentCompleted)get_store().find_attribute_user(PERCENTCOMPLETED$0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ProcessStartedType.PercentCompleted)get_store().add_attribute_user(PERCENTCOMPLETED$0);
            }
            target.set(percentCompleted);
        }
    }
    
    /**
     * Unsets the "percentCompleted" attribute
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
     * An XML percentCompleted(@).
     *
     * This is an atomic type that is a restriction of net.opengis.wps.x100.ProcessStartedType$PercentCompleted.
     */
    public static class PercentCompletedImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements net.opengis.wps.x100.ProcessStartedType.PercentCompleted
    {
        private static final long serialVersionUID = 1L;
        
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

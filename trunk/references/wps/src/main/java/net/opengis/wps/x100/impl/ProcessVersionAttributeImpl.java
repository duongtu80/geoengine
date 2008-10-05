/*
 * An XML attribute type.
 * Localname: processVersion
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ProcessVersionAttribute
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * A document containing one processVersion(@http://www.opengis.net/wps/1.0.0) attribute.
 *
 * This is a complex type.
 */
public class ProcessVersionAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.ProcessVersionAttribute
{
    private static final long serialVersionUID = 1L;
    
    public ProcessVersionAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSVERSION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "processVersion");
    
    
    /**
     * Gets the "processVersion" attribute
     */
    public java.lang.String getProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROCESSVERSION$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "processVersion" attribute
     */
    public org.apache.xmlbeans.XmlString xgetProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROCESSVERSION$0);
            return target;
        }
    }
    
    /**
     * True if has "processVersion" attribute
     */
    public boolean isSetProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PROCESSVERSION$0) != null;
        }
    }
    
    /**
     * Sets the "processVersion" attribute
     */
    public void setProcessVersion(java.lang.String processVersion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROCESSVERSION$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROCESSVERSION$0);
            }
            target.setStringValue(processVersion);
        }
    }
    
    /**
     * Sets (as xml) the "processVersion" attribute
     */
    public void xsetProcessVersion(org.apache.xmlbeans.XmlString processVersion)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROCESSVERSION$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROCESSVERSION$0);
            }
            target.set(processVersion);
        }
    }
    
    /**
     * Unsets the "processVersion" attribute
     */
    public void unsetProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PROCESSVERSION$0);
        }
    }
}

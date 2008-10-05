/*
 * XML Type:  ProcessBriefType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.ProcessBriefType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML ProcessBriefType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class ProcessBriefTypeImpl extends net.opengis.wps.x100.impl.DescriptionTypeImpl implements net.opengis.wps.x100.ProcessBriefType
{
    private static final long serialVersionUID = 1L;
    
    public ProcessBriefTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROFILE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Profile");
    private static final javax.xml.namespace.QName WSDL$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "WSDL");
    private static final javax.xml.namespace.QName PROCESSVERSION$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "processVersion");
    
    
    /**
     * Gets array of all "Profile" elements
     */
    public java.lang.String[] getProfileArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(PROFILE$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "Profile" element
     */
    public java.lang.String getProfileArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROFILE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "Profile" elements
     */
    public org.apache.xmlbeans.XmlAnyURI[] xgetProfileArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(PROFILE$0, targetList);
            org.apache.xmlbeans.XmlAnyURI[] result = new org.apache.xmlbeans.XmlAnyURI[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "Profile" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetProfileArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(PROFILE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlAnyURI)target;
        }
    }
    
    /**
     * Returns number of "Profile" element
     */
    public int sizeOfProfileArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROFILE$0);
        }
    }
    
    /**
     * Sets array of all "Profile" element
     */
    public void setProfileArray(java.lang.String[] profileArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(profileArray, PROFILE$0);
        }
    }
    
    /**
     * Sets ith "Profile" element
     */
    public void setProfileArray(int i, java.lang.String profile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PROFILE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(profile);
        }
    }
    
    /**
     * Sets (as xml) array of all "Profile" element
     */
    public void xsetProfileArray(org.apache.xmlbeans.XmlAnyURI[]profileArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(profileArray, PROFILE$0);
        }
    }
    
    /**
     * Sets (as xml) ith "Profile" element
     */
    public void xsetProfileArray(int i, org.apache.xmlbeans.XmlAnyURI profile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(PROFILE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(profile);
        }
    }
    
    /**
     * Inserts the value as the ith "Profile" element
     */
    public void insertProfile(int i, java.lang.String profile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(PROFILE$0, i);
            target.setStringValue(profile);
        }
    }
    
    /**
     * Appends the value as the last "Profile" element
     */
    public void addProfile(java.lang.String profile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PROFILE$0);
            target.setStringValue(profile);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Profile" element
     */
    public org.apache.xmlbeans.XmlAnyURI insertNewProfile(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().insert_element_user(PROFILE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Profile" element
     */
    public org.apache.xmlbeans.XmlAnyURI addNewProfile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(PROFILE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Profile" element
     */
    public void removeProfile(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROFILE$0, i);
        }
    }
    
    /**
     * Gets the "WSDL" element
     */
    public net.opengis.wps.x100.WSDLDocument.WSDL getWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().find_element_user(WSDL$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "WSDL" element
     */
    public boolean isSetWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WSDL$2) != 0;
        }
    }
    
    /**
     * Sets the "WSDL" element
     */
    public void setWSDL(net.opengis.wps.x100.WSDLDocument.WSDL wsdl)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().find_element_user(WSDL$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().add_element_user(WSDL$2);
            }
            target.set(wsdl);
        }
    }
    
    /**
     * Appends and returns a new empty "WSDL" element
     */
    public net.opengis.wps.x100.WSDLDocument.WSDL addNewWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().add_element_user(WSDL$2);
            return target;
        }
    }
    
    /**
     * Unsets the "WSDL" element
     */
    public void unsetWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WSDL$2, 0);
        }
    }
    
    /**
     * Gets the "processVersion" attribute
     */
    public java.lang.String getProcessVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROCESSVERSION$4);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROCESSVERSION$4);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROCESSVERSION$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROCESSVERSION$4);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROCESSVERSION$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROCESSVERSION$4);
            }
            target.set(processVersion);
        }
    }
}

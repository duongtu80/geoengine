/*
 * XML Type:  CapabilitiesBaseType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.CapabilitiesBaseType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML CapabilitiesBaseType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class CapabilitiesBaseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.CapabilitiesBaseType
{
    
    public CapabilitiesBaseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEIDENTIFICATION$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ServiceIdentification");
    private static final javax.xml.namespace.QName SERVICEPROVIDER$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ServiceProvider");
    private static final javax.xml.namespace.QName OPERATIONSMETADATA$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "OperationsMetadata");
    private static final javax.xml.namespace.QName VERSION$6 = 
        new javax.xml.namespace.QName("", "version");
    private static final javax.xml.namespace.QName UPDATESEQUENCE$8 = 
        new javax.xml.namespace.QName("", "updateSequence");
    
    
    /**
     * Gets the "ServiceIdentification" element
     */
    public net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification getServiceIdentification()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification target = null;
            target = (net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification)get_store().find_element_user(SERVICEIDENTIFICATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ServiceIdentification" element
     */
    public boolean isSetServiceIdentification()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SERVICEIDENTIFICATION$0) != 0;
        }
    }
    
    /**
     * Sets the "ServiceIdentification" element
     */
    public void setServiceIdentification(net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification serviceIdentification)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification target = null;
            target = (net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification)get_store().find_element_user(SERVICEIDENTIFICATION$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification)get_store().add_element_user(SERVICEIDENTIFICATION$0);
            }
            target.set(serviceIdentification);
        }
    }
    
    /**
     * Appends and returns a new empty "ServiceIdentification" element
     */
    public net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification addNewServiceIdentification()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification target = null;
            target = (net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification)get_store().add_element_user(SERVICEIDENTIFICATION$0);
            return target;
        }
    }
    
    /**
     * Unsets the "ServiceIdentification" element
     */
    public void unsetServiceIdentification()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SERVICEIDENTIFICATION$0, 0);
        }
    }
    
    /**
     * Gets the "ServiceProvider" element
     */
    public net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider getServiceProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider target = null;
            target = (net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider)get_store().find_element_user(SERVICEPROVIDER$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ServiceProvider" element
     */
    public boolean isSetServiceProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SERVICEPROVIDER$2) != 0;
        }
    }
    
    /**
     * Sets the "ServiceProvider" element
     */
    public void setServiceProvider(net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider serviceProvider)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider target = null;
            target = (net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider)get_store().find_element_user(SERVICEPROVIDER$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider)get_store().add_element_user(SERVICEPROVIDER$2);
            }
            target.set(serviceProvider);
        }
    }
    
    /**
     * Appends and returns a new empty "ServiceProvider" element
     */
    public net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider addNewServiceProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider target = null;
            target = (net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider)get_store().add_element_user(SERVICEPROVIDER$2);
            return target;
        }
    }
    
    /**
     * Unsets the "ServiceProvider" element
     */
    public void unsetServiceProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SERVICEPROVIDER$2, 0);
        }
    }
    
    /**
     * Gets the "OperationsMetadata" element
     */
    public net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata getOperationsMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata target = null;
            target = (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata)get_store().find_element_user(OPERATIONSMETADATA$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "OperationsMetadata" element
     */
    public boolean isSetOperationsMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OPERATIONSMETADATA$4) != 0;
        }
    }
    
    /**
     * Sets the "OperationsMetadata" element
     */
    public void setOperationsMetadata(net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata operationsMetadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata target = null;
            target = (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata)get_store().find_element_user(OPERATIONSMETADATA$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata)get_store().add_element_user(OPERATIONSMETADATA$4);
            }
            target.set(operationsMetadata);
        }
    }
    
    /**
     * Appends and returns a new empty "OperationsMetadata" element
     */
    public net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata addNewOperationsMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata target = null;
            target = (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata)get_store().add_element_user(OPERATIONSMETADATA$4);
            return target;
        }
    }
    
    /**
     * Unsets the "OperationsMetadata" element
     */
    public void unsetOperationsMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OPERATIONSMETADATA$4, 0);
        }
    }
    
    /**
     * Gets the "version" attribute
     */
    public java.lang.String getVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "version" attribute
     */
    public net.opengeospatial.ows.VersionType xgetVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().find_attribute_user(VERSION$6);
            return target;
        }
    }
    
    /**
     * Sets the "version" attribute
     */
    public void setVersion(java.lang.String version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VERSION$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VERSION$6);
            }
            target.setStringValue(version);
        }
    }
    
    /**
     * Sets (as xml) the "version" attribute
     */
    public void xsetVersion(net.opengeospatial.ows.VersionType version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.VersionType target = null;
            target = (net.opengeospatial.ows.VersionType)get_store().find_attribute_user(VERSION$6);
            if (target == null)
            {
                target = (net.opengeospatial.ows.VersionType)get_store().add_attribute_user(VERSION$6);
            }
            target.set(version);
        }
    }
    
    /**
     * Gets the "updateSequence" attribute
     */
    public java.lang.String getUpdateSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(UPDATESEQUENCE$8);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "updateSequence" attribute
     */
    public net.opengeospatial.ows.UpdateSequenceType xgetUpdateSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.UpdateSequenceType target = null;
            target = (net.opengeospatial.ows.UpdateSequenceType)get_store().find_attribute_user(UPDATESEQUENCE$8);
            return target;
        }
    }
    
    /**
     * True if has "updateSequence" attribute
     */
    public boolean isSetUpdateSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(UPDATESEQUENCE$8) != null;
        }
    }
    
    /**
     * Sets the "updateSequence" attribute
     */
    public void setUpdateSequence(java.lang.String updateSequence)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(UPDATESEQUENCE$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(UPDATESEQUENCE$8);
            }
            target.setStringValue(updateSequence);
        }
    }
    
    /**
     * Sets (as xml) the "updateSequence" attribute
     */
    public void xsetUpdateSequence(net.opengeospatial.ows.UpdateSequenceType updateSequence)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.UpdateSequenceType target = null;
            target = (net.opengeospatial.ows.UpdateSequenceType)get_store().find_attribute_user(UPDATESEQUENCE$8);
            if (target == null)
            {
                target = (net.opengeospatial.ows.UpdateSequenceType)get_store().add_attribute_user(UPDATESEQUENCE$8);
            }
            target.set(updateSequence);
        }
    }
    
    /**
     * Unsets the "updateSequence" attribute
     */
    public void unsetUpdateSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(UPDATESEQUENCE$8);
        }
    }
}

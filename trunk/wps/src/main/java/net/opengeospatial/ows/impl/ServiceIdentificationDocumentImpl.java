/*
 * An XML document type.
 * Localname: ServiceIdentification
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ServiceIdentificationDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one ServiceIdentification(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class ServiceIdentificationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ServiceIdentificationDocument
{
    
    public ServiceIdentificationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SERVICEIDENTIFICATION$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ServiceIdentification");
    
    
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
     * An XML ServiceIdentification(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public static class ServiceIdentificationImpl extends net.opengeospatial.ows.impl.DescriptionTypeImpl implements net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification
    {
        
        public ServiceIdentificationImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SERVICETYPE$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ServiceType");
        private static final javax.xml.namespace.QName SERVICETYPEVERSION$2 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ServiceTypeVersion");
        private static final javax.xml.namespace.QName FEES$4 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Fees");
        private static final javax.xml.namespace.QName ACCESSCONSTRAINTS$6 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AccessConstraints");
        
        
        /**
         * Gets the "ServiceType" element
         */
        public net.opengeospatial.ows.CodeType getServiceType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.CodeType target = null;
                target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(SERVICETYPE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "ServiceType" element
         */
        public void setServiceType(net.opengeospatial.ows.CodeType serviceType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.CodeType target = null;
                target = (net.opengeospatial.ows.CodeType)get_store().find_element_user(SERVICETYPE$0, 0);
                if (target == null)
                {
                    target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(SERVICETYPE$0);
                }
                target.set(serviceType);
            }
        }
        
        /**
         * Appends and returns a new empty "ServiceType" element
         */
        public net.opengeospatial.ows.CodeType addNewServiceType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.CodeType target = null;
                target = (net.opengeospatial.ows.CodeType)get_store().add_element_user(SERVICETYPE$0);
                return target;
            }
        }
        
        /**
         * Gets array of all "ServiceTypeVersion" elements
         */
        public java.lang.String[] getServiceTypeVersionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SERVICETYPEVERSION$2, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "ServiceTypeVersion" element
         */
        public java.lang.String getServiceTypeVersionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SERVICETYPEVERSION$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "ServiceTypeVersion" elements
         */
        public net.opengeospatial.ows.VersionType[] xgetServiceTypeVersionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SERVICETYPEVERSION$2, targetList);
                net.opengeospatial.ows.VersionType[] result = new net.opengeospatial.ows.VersionType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "ServiceTypeVersion" element
         */
        public net.opengeospatial.ows.VersionType xgetServiceTypeVersionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.VersionType target = null;
                target = (net.opengeospatial.ows.VersionType)get_store().find_element_user(SERVICETYPEVERSION$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (net.opengeospatial.ows.VersionType)target;
            }
        }
        
        /**
         * Returns number of "ServiceTypeVersion" element
         */
        public int sizeOfServiceTypeVersionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SERVICETYPEVERSION$2);
            }
        }
        
        /**
         * Sets array of all "ServiceTypeVersion" element
         */
        public void setServiceTypeVersionArray(java.lang.String[] serviceTypeVersionArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(serviceTypeVersionArray, SERVICETYPEVERSION$2);
            }
        }
        
        /**
         * Sets ith "ServiceTypeVersion" element
         */
        public void setServiceTypeVersionArray(int i, java.lang.String serviceTypeVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SERVICETYPEVERSION$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(serviceTypeVersion);
            }
        }
        
        /**
         * Sets (as xml) array of all "ServiceTypeVersion" element
         */
        public void xsetServiceTypeVersionArray(net.opengeospatial.ows.VersionType[]serviceTypeVersionArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(serviceTypeVersionArray, SERVICETYPEVERSION$2);
            }
        }
        
        /**
         * Sets (as xml) ith "ServiceTypeVersion" element
         */
        public void xsetServiceTypeVersionArray(int i, net.opengeospatial.ows.VersionType serviceTypeVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.VersionType target = null;
                target = (net.opengeospatial.ows.VersionType)get_store().find_element_user(SERVICETYPEVERSION$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(serviceTypeVersion);
            }
        }
        
        /**
         * Inserts the value as the ith "ServiceTypeVersion" element
         */
        public void insertServiceTypeVersion(int i, java.lang.String serviceTypeVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(SERVICETYPEVERSION$2, i);
                target.setStringValue(serviceTypeVersion);
            }
        }
        
        /**
         * Appends the value as the last "ServiceTypeVersion" element
         */
        public void addServiceTypeVersion(java.lang.String serviceTypeVersion)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SERVICETYPEVERSION$2);
                target.setStringValue(serviceTypeVersion);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "ServiceTypeVersion" element
         */
        public net.opengeospatial.ows.VersionType insertNewServiceTypeVersion(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.VersionType target = null;
                target = (net.opengeospatial.ows.VersionType)get_store().insert_element_user(SERVICETYPEVERSION$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "ServiceTypeVersion" element
         */
        public net.opengeospatial.ows.VersionType addNewServiceTypeVersion()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.VersionType target = null;
                target = (net.opengeospatial.ows.VersionType)get_store().add_element_user(SERVICETYPEVERSION$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "ServiceTypeVersion" element
         */
        public void removeServiceTypeVersion(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SERVICETYPEVERSION$2, i);
            }
        }
        
        /**
         * Gets the "Fees" element
         */
        public java.lang.String getFees()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEES$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Fees" element
         */
        public org.apache.xmlbeans.XmlString xgetFees()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FEES$4, 0);
                return target;
            }
        }
        
        /**
         * True if has "Fees" element
         */
        public boolean isSetFees()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FEES$4) != 0;
            }
        }
        
        /**
         * Sets the "Fees" element
         */
        public void setFees(java.lang.String fees)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEES$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FEES$4);
                }
                target.setStringValue(fees);
            }
        }
        
        /**
         * Sets (as xml) the "Fees" element
         */
        public void xsetFees(org.apache.xmlbeans.XmlString fees)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FEES$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FEES$4);
                }
                target.set(fees);
            }
        }
        
        /**
         * Unsets the "Fees" element
         */
        public void unsetFees()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FEES$4, 0);
            }
        }
        
        /**
         * Gets array of all "AccessConstraints" elements
         */
        public java.lang.String[] getAccessConstraintsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ACCESSCONSTRAINTS$6, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "AccessConstraints" element
         */
        public java.lang.String getAccessConstraintsArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACCESSCONSTRAINTS$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "AccessConstraints" elements
         */
        public org.apache.xmlbeans.XmlString[] xgetAccessConstraintsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ACCESSCONSTRAINTS$6, targetList);
                org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "AccessConstraints" element
         */
        public org.apache.xmlbeans.XmlString xgetAccessConstraintsArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ACCESSCONSTRAINTS$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (org.apache.xmlbeans.XmlString)target;
            }
        }
        
        /**
         * Returns number of "AccessConstraints" element
         */
        public int sizeOfAccessConstraintsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ACCESSCONSTRAINTS$6);
            }
        }
        
        /**
         * Sets array of all "AccessConstraints" element
         */
        public void setAccessConstraintsArray(java.lang.String[] accessConstraintsArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(accessConstraintsArray, ACCESSCONSTRAINTS$6);
            }
        }
        
        /**
         * Sets ith "AccessConstraints" element
         */
        public void setAccessConstraintsArray(int i, java.lang.String accessConstraints)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACCESSCONSTRAINTS$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(accessConstraints);
            }
        }
        
        /**
         * Sets (as xml) array of all "AccessConstraints" element
         */
        public void xsetAccessConstraintsArray(org.apache.xmlbeans.XmlString[]accessConstraintsArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(accessConstraintsArray, ACCESSCONSTRAINTS$6);
            }
        }
        
        /**
         * Sets (as xml) ith "AccessConstraints" element
         */
        public void xsetAccessConstraintsArray(int i, org.apache.xmlbeans.XmlString accessConstraints)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ACCESSCONSTRAINTS$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(accessConstraints);
            }
        }
        
        /**
         * Inserts the value as the ith "AccessConstraints" element
         */
        public void insertAccessConstraints(int i, java.lang.String accessConstraints)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(ACCESSCONSTRAINTS$6, i);
                target.setStringValue(accessConstraints);
            }
        }
        
        /**
         * Appends the value as the last "AccessConstraints" element
         */
        public void addAccessConstraints(java.lang.String accessConstraints)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ACCESSCONSTRAINTS$6);
                target.setStringValue(accessConstraints);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "AccessConstraints" element
         */
        public org.apache.xmlbeans.XmlString insertNewAccessConstraints(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(ACCESSCONSTRAINTS$6, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "AccessConstraints" element
         */
        public org.apache.xmlbeans.XmlString addNewAccessConstraints()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ACCESSCONSTRAINTS$6);
                return target;
            }
        }
        
        /**
         * Removes the ith "AccessConstraints" element
         */
        public void removeAccessConstraints(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ACCESSCONSTRAINTS$6, i);
            }
        }
    }
}

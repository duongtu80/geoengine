/*
 * An XML document type.
 * Localname: OperationsMetadata
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.OperationsMetadataDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one OperationsMetadata(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class OperationsMetadataDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.OperationsMetadataDocument
{
    
    public OperationsMetadataDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPERATIONSMETADATA$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "OperationsMetadata");
    
    
    /**
     * Gets the "OperationsMetadata" element
     */
    public net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata getOperationsMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata target = null;
            target = (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata)get_store().find_element_user(OPERATIONSMETADATA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
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
            target = (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata)get_store().find_element_user(OPERATIONSMETADATA$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata)get_store().add_element_user(OPERATIONSMETADATA$0);
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
            target = (net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata)get_store().add_element_user(OPERATIONSMETADATA$0);
            return target;
        }
    }
    /**
     * An XML OperationsMetadata(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public static class OperationsMetadataImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata
    {
        
        public OperationsMetadataImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName OPERATION$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Operation");
        private static final javax.xml.namespace.QName PARAMETER$2 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Parameter");
        private static final javax.xml.namespace.QName CONSTRAINT$4 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Constraint");
        private static final javax.xml.namespace.QName EXTENDEDCAPABILITIES$6 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ExtendedCapabilities");
        
        
        /**
         * Gets array of all "Operation" elements
         */
        public net.opengeospatial.ows.OperationDocument.Operation[] getOperationArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(OPERATION$0, targetList);
                net.opengeospatial.ows.OperationDocument.Operation[] result = new net.opengeospatial.ows.OperationDocument.Operation[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Operation" element
         */
        public net.opengeospatial.ows.OperationDocument.Operation getOperationArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.OperationDocument.Operation target = null;
                target = (net.opengeospatial.ows.OperationDocument.Operation)get_store().find_element_user(OPERATION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Operation" element
         */
        public int sizeOfOperationArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(OPERATION$0);
            }
        }
        
        /**
         * Sets array of all "Operation" element
         */
        public void setOperationArray(net.opengeospatial.ows.OperationDocument.Operation[] operationArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(operationArray, OPERATION$0);
            }
        }
        
        /**
         * Sets ith "Operation" element
         */
        public void setOperationArray(int i, net.opengeospatial.ows.OperationDocument.Operation operation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.OperationDocument.Operation target = null;
                target = (net.opengeospatial.ows.OperationDocument.Operation)get_store().find_element_user(OPERATION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(operation);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Operation" element
         */
        public net.opengeospatial.ows.OperationDocument.Operation insertNewOperation(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.OperationDocument.Operation target = null;
                target = (net.opengeospatial.ows.OperationDocument.Operation)get_store().insert_element_user(OPERATION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Operation" element
         */
        public net.opengeospatial.ows.OperationDocument.Operation addNewOperation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.OperationDocument.Operation target = null;
                target = (net.opengeospatial.ows.OperationDocument.Operation)get_store().add_element_user(OPERATION$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Operation" element
         */
        public void removeOperation(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(OPERATION$0, i);
            }
        }
        
        /**
         * Gets array of all "Parameter" elements
         */
        public net.opengeospatial.ows.DomainType[] getParameterArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PARAMETER$2, targetList);
                net.opengeospatial.ows.DomainType[] result = new net.opengeospatial.ows.DomainType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Parameter" element
         */
        public net.opengeospatial.ows.DomainType getParameterArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.DomainType target = null;
                target = (net.opengeospatial.ows.DomainType)get_store().find_element_user(PARAMETER$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Parameter" element
         */
        public int sizeOfParameterArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PARAMETER$2);
            }
        }
        
        /**
         * Sets array of all "Parameter" element
         */
        public void setParameterArray(net.opengeospatial.ows.DomainType[] parameterArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(parameterArray, PARAMETER$2);
            }
        }
        
        /**
         * Sets ith "Parameter" element
         */
        public void setParameterArray(int i, net.opengeospatial.ows.DomainType parameter)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.DomainType target = null;
                target = (net.opengeospatial.ows.DomainType)get_store().find_element_user(PARAMETER$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(parameter);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Parameter" element
         */
        public net.opengeospatial.ows.DomainType insertNewParameter(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.DomainType target = null;
                target = (net.opengeospatial.ows.DomainType)get_store().insert_element_user(PARAMETER$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Parameter" element
         */
        public net.opengeospatial.ows.DomainType addNewParameter()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.DomainType target = null;
                target = (net.opengeospatial.ows.DomainType)get_store().add_element_user(PARAMETER$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "Parameter" element
         */
        public void removeParameter(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PARAMETER$2, i);
            }
        }
        
        /**
         * Gets array of all "Constraint" elements
         */
        public net.opengeospatial.ows.DomainType[] getConstraintArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CONSTRAINT$4, targetList);
                net.opengeospatial.ows.DomainType[] result = new net.opengeospatial.ows.DomainType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Constraint" element
         */
        public net.opengeospatial.ows.DomainType getConstraintArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.DomainType target = null;
                target = (net.opengeospatial.ows.DomainType)get_store().find_element_user(CONSTRAINT$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Constraint" element
         */
        public int sizeOfConstraintArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CONSTRAINT$4);
            }
        }
        
        /**
         * Sets array of all "Constraint" element
         */
        public void setConstraintArray(net.opengeospatial.ows.DomainType[] constraintArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(constraintArray, CONSTRAINT$4);
            }
        }
        
        /**
         * Sets ith "Constraint" element
         */
        public void setConstraintArray(int i, net.opengeospatial.ows.DomainType constraint)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.DomainType target = null;
                target = (net.opengeospatial.ows.DomainType)get_store().find_element_user(CONSTRAINT$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(constraint);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Constraint" element
         */
        public net.opengeospatial.ows.DomainType insertNewConstraint(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.DomainType target = null;
                target = (net.opengeospatial.ows.DomainType)get_store().insert_element_user(CONSTRAINT$4, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Constraint" element
         */
        public net.opengeospatial.ows.DomainType addNewConstraint()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.DomainType target = null;
                target = (net.opengeospatial.ows.DomainType)get_store().add_element_user(CONSTRAINT$4);
                return target;
            }
        }
        
        /**
         * Removes the ith "Constraint" element
         */
        public void removeConstraint(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CONSTRAINT$4, i);
            }
        }
        
        /**
         * Gets the "ExtendedCapabilities" element
         */
        public org.apache.xmlbeans.XmlObject getExtendedCapabilities()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlObject target = null;
                target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(EXTENDEDCAPABILITIES$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "ExtendedCapabilities" element
         */
        public boolean isSetExtendedCapabilities()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(EXTENDEDCAPABILITIES$6) != 0;
            }
        }
        
        /**
         * Sets the "ExtendedCapabilities" element
         */
        public void setExtendedCapabilities(org.apache.xmlbeans.XmlObject extendedCapabilities)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlObject target = null;
                target = (org.apache.xmlbeans.XmlObject)get_store().find_element_user(EXTENDEDCAPABILITIES$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(EXTENDEDCAPABILITIES$6);
                }
                target.set(extendedCapabilities);
            }
        }
        
        /**
         * Appends and returns a new empty "ExtendedCapabilities" element
         */
        public org.apache.xmlbeans.XmlObject addNewExtendedCapabilities()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlObject target = null;
                target = (org.apache.xmlbeans.XmlObject)get_store().add_element_user(EXTENDEDCAPABILITIES$6);
                return target;
            }
        }
        
        /**
         * Unsets the "ExtendedCapabilities" element
         */
        public void unsetExtendedCapabilities()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(EXTENDEDCAPABILITIES$6, 0);
            }
        }
    }
}

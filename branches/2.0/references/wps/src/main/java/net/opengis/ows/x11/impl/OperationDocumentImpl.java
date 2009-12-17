/*
 * An XML document type.
 * Localname: Operation
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.OperationDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Operation(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class OperationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.OperationDocument
{
    private static final long serialVersionUID = 1L;
    
    public OperationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPERATION$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Operation");
    
    
    /**
     * Gets the "Operation" element
     */
    public net.opengis.ows.x11.OperationDocument.Operation getOperation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.OperationDocument.Operation target = null;
            target = (net.opengis.ows.x11.OperationDocument.Operation)get_store().find_element_user(OPERATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Operation" element
     */
    public void setOperation(net.opengis.ows.x11.OperationDocument.Operation operation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.OperationDocument.Operation target = null;
            target = (net.opengis.ows.x11.OperationDocument.Operation)get_store().find_element_user(OPERATION$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.OperationDocument.Operation)get_store().add_element_user(OPERATION$0);
            }
            target.set(operation);
        }
    }
    
    /**
     * Appends and returns a new empty "Operation" element
     */
    public net.opengis.ows.x11.OperationDocument.Operation addNewOperation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.OperationDocument.Operation target = null;
            target = (net.opengis.ows.x11.OperationDocument.Operation)get_store().add_element_user(OPERATION$0);
            return target;
        }
    }
    /**
     * An XML Operation(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public static class OperationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.OperationDocument.Operation
    {
        private static final long serialVersionUID = 1L;
        
        public OperationImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DCP$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DCP");
        private static final javax.xml.namespace.QName PARAMETER$2 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Parameter");
        private static final javax.xml.namespace.QName CONSTRAINT$4 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Constraint");
        private static final javax.xml.namespace.QName METADATA$6 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Metadata");
        private static final javax.xml.namespace.QName NAME$8 = 
            new javax.xml.namespace.QName("", "name");
        
        
        /**
         * Gets array of all "DCP" elements
         */
        public net.opengis.ows.x11.DCPDocument.DCP[] getDCPArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(DCP$0, targetList);
                net.opengis.ows.x11.DCPDocument.DCP[] result = new net.opengis.ows.x11.DCPDocument.DCP[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "DCP" element
         */
        public net.opengis.ows.x11.DCPDocument.DCP getDCPArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DCPDocument.DCP target = null;
                target = (net.opengis.ows.x11.DCPDocument.DCP)get_store().find_element_user(DCP$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "DCP" element
         */
        public int sizeOfDCPArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DCP$0);
            }
        }
        
        /**
         * Sets array of all "DCP" element
         */
        public void setDCPArray(net.opengis.ows.x11.DCPDocument.DCP[] dcpArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(dcpArray, DCP$0);
            }
        }
        
        /**
         * Sets ith "DCP" element
         */
        public void setDCPArray(int i, net.opengis.ows.x11.DCPDocument.DCP dcp)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DCPDocument.DCP target = null;
                target = (net.opengis.ows.x11.DCPDocument.DCP)get_store().find_element_user(DCP$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(dcp);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "DCP" element
         */
        public net.opengis.ows.x11.DCPDocument.DCP insertNewDCP(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DCPDocument.DCP target = null;
                target = (net.opengis.ows.x11.DCPDocument.DCP)get_store().insert_element_user(DCP$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "DCP" element
         */
        public net.opengis.ows.x11.DCPDocument.DCP addNewDCP()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DCPDocument.DCP target = null;
                target = (net.opengis.ows.x11.DCPDocument.DCP)get_store().add_element_user(DCP$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "DCP" element
         */
        public void removeDCP(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DCP$0, i);
            }
        }
        
        /**
         * Gets array of all "Parameter" elements
         */
        public net.opengis.ows.x11.DomainType[] getParameterArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PARAMETER$2, targetList);
                net.opengis.ows.x11.DomainType[] result = new net.opengis.ows.x11.DomainType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Parameter" element
         */
        public net.opengis.ows.x11.DomainType getParameterArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainType target = null;
                target = (net.opengis.ows.x11.DomainType)get_store().find_element_user(PARAMETER$2, i);
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
        public void setParameterArray(net.opengis.ows.x11.DomainType[] parameterArray)
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
        public void setParameterArray(int i, net.opengis.ows.x11.DomainType parameter)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainType target = null;
                target = (net.opengis.ows.x11.DomainType)get_store().find_element_user(PARAMETER$2, i);
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
        public net.opengis.ows.x11.DomainType insertNewParameter(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainType target = null;
                target = (net.opengis.ows.x11.DomainType)get_store().insert_element_user(PARAMETER$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Parameter" element
         */
        public net.opengis.ows.x11.DomainType addNewParameter()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainType target = null;
                target = (net.opengis.ows.x11.DomainType)get_store().add_element_user(PARAMETER$2);
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
        public net.opengis.ows.x11.DomainType[] getConstraintArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(CONSTRAINT$4, targetList);
                net.opengis.ows.x11.DomainType[] result = new net.opengis.ows.x11.DomainType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Constraint" element
         */
        public net.opengis.ows.x11.DomainType getConstraintArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainType target = null;
                target = (net.opengis.ows.x11.DomainType)get_store().find_element_user(CONSTRAINT$4, i);
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
        public void setConstraintArray(net.opengis.ows.x11.DomainType[] constraintArray)
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
        public void setConstraintArray(int i, net.opengis.ows.x11.DomainType constraint)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainType target = null;
                target = (net.opengis.ows.x11.DomainType)get_store().find_element_user(CONSTRAINT$4, i);
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
        public net.opengis.ows.x11.DomainType insertNewConstraint(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainType target = null;
                target = (net.opengis.ows.x11.DomainType)get_store().insert_element_user(CONSTRAINT$4, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Constraint" element
         */
        public net.opengis.ows.x11.DomainType addNewConstraint()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.DomainType target = null;
                target = (net.opengis.ows.x11.DomainType)get_store().add_element_user(CONSTRAINT$4);
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
         * Gets array of all "Metadata" elements
         */
        public net.opengis.ows.x11.MetadataType[] getMetadataArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(METADATA$6, targetList);
                net.opengis.ows.x11.MetadataType[] result = new net.opengis.ows.x11.MetadataType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Metadata" element
         */
        public net.opengis.ows.x11.MetadataType getMetadataArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.MetadataType target = null;
                target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Metadata" element
         */
        public int sizeOfMetadataArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(METADATA$6);
            }
        }
        
        /**
         * Sets array of all "Metadata" element
         */
        public void setMetadataArray(net.opengis.ows.x11.MetadataType[] metadataArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(metadataArray, METADATA$6);
            }
        }
        
        /**
         * Sets ith "Metadata" element
         */
        public void setMetadataArray(int i, net.opengis.ows.x11.MetadataType metadata)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.MetadataType target = null;
                target = (net.opengis.ows.x11.MetadataType)get_store().find_element_user(METADATA$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(metadata);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Metadata" element
         */
        public net.opengis.ows.x11.MetadataType insertNewMetadata(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.MetadataType target = null;
                target = (net.opengis.ows.x11.MetadataType)get_store().insert_element_user(METADATA$6, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Metadata" element
         */
        public net.opengis.ows.x11.MetadataType addNewMetadata()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.MetadataType target = null;
                target = (net.opengis.ows.x11.MetadataType)get_store().add_element_user(METADATA$6);
                return target;
            }
        }
        
        /**
         * Removes the ith "Metadata" element
         */
        public void removeMetadata(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(METADATA$6, i);
            }
        }
        
        /**
         * Gets the "name" attribute
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$8);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "name" attribute
         */
        public org.apache.xmlbeans.XmlString xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$8);
                return target;
            }
        }
        
        /**
         * Sets the "name" attribute
         */
        public void setName(java.lang.String name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$8);
                }
                target.setStringValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "name" attribute
         */
        public void xsetName(org.apache.xmlbeans.XmlString name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$8);
                }
                target.set(name);
            }
        }
    }
}

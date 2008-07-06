/*
 * XML Type:  modelType
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ModelType
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing.impl;
/**
 * An XML modelType(@http://www.geodata.cn/models/geoprocessing).
 *
 * This is a complex type.
 */
public class ModelTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.ModelType
{
    
    public ModelTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ID$0 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "id");
    private static final javax.xml.namespace.QName TITLE$2 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "title");
    private static final javax.xml.namespace.QName METADATA$4 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "metadata");
    private static final javax.xml.namespace.QName PROVIDER$6 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "provider");
    private static final javax.xml.namespace.QName DESCRIBE$8 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "describe");
    private static final javax.xml.namespace.QName PROCESS$10 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "process");
    
    
    /**
     * Gets the "id" element
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" element
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "id" element
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ID$0);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" element
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ID$0);
            }
            target.set(id);
        }
    }
    
    /**
     * Gets the "title" element
     */
    public java.lang.String getTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "title" element
     */
    public org.apache.xmlbeans.XmlString xgetTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "title" element
     */
    public void setTitle(java.lang.String title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TITLE$2);
            }
            target.setStringValue(title);
        }
    }
    
    /**
     * Sets (as xml) the "title" element
     */
    public void xsetTitle(org.apache.xmlbeans.XmlString title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TITLE$2);
            }
            target.set(title);
        }
    }
    
    /**
     * Gets array of all "metadata" elements
     */
    public java.lang.String[] getMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$4, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "metadata" element
     */
    public java.lang.String getMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METADATA$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "metadata" elements
     */
    public org.apache.xmlbeans.XmlAnyURI[] xgetMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$4, targetList);
            org.apache.xmlbeans.XmlAnyURI[] result = new org.apache.xmlbeans.XmlAnyURI[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "metadata" element
     */
    public org.apache.xmlbeans.XmlAnyURI xgetMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(METADATA$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlAnyURI)target;
        }
    }
    
    /**
     * Returns number of "metadata" element
     */
    public int sizeOfMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METADATA$4);
        }
    }
    
    /**
     * Sets array of all "metadata" element
     */
    public void setMetadataArray(java.lang.String[] metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$4);
        }
    }
    
    /**
     * Sets ith "metadata" element
     */
    public void setMetadataArray(int i, java.lang.String metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(METADATA$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(metadata);
        }
    }
    
    /**
     * Sets (as xml) array of all "metadata" element
     */
    public void xsetMetadataArray(org.apache.xmlbeans.XmlAnyURI[]metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$4);
        }
    }
    
    /**
     * Sets (as xml) ith "metadata" element
     */
    public void xsetMetadataArray(int i, org.apache.xmlbeans.XmlAnyURI metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_element_user(METADATA$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(metadata);
        }
    }
    
    /**
     * Inserts the value as the ith "metadata" element
     */
    public void insertMetadata(int i, java.lang.String metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(METADATA$4, i);
            target.setStringValue(metadata);
        }
    }
    
    /**
     * Appends the value as the last "metadata" element
     */
    public void addMetadata(java.lang.String metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(METADATA$4);
            target.setStringValue(metadata);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "metadata" element
     */
    public org.apache.xmlbeans.XmlAnyURI insertNewMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().insert_element_user(METADATA$4, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "metadata" element
     */
    public org.apache.xmlbeans.XmlAnyURI addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_element_user(METADATA$4);
            return target;
        }
    }
    
    /**
     * Removes the ith "metadata" element
     */
    public void removeMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METADATA$4, i);
        }
    }
    
    /**
     * Gets the "provider" element
     */
    public cn.geodata.models.geoprocessing.ModelType.Provider getProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ModelType.Provider target = null;
            target = (cn.geodata.models.geoprocessing.ModelType.Provider)get_store().find_element_user(PROVIDER$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "provider" element
     */
    public boolean isSetProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROVIDER$6) != 0;
        }
    }
    
    /**
     * Sets the "provider" element
     */
    public void setProvider(cn.geodata.models.geoprocessing.ModelType.Provider provider)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ModelType.Provider target = null;
            target = (cn.geodata.models.geoprocessing.ModelType.Provider)get_store().find_element_user(PROVIDER$6, 0);
            if (target == null)
            {
                target = (cn.geodata.models.geoprocessing.ModelType.Provider)get_store().add_element_user(PROVIDER$6);
            }
            target.set(provider);
        }
    }
    
    /**
     * Appends and returns a new empty "provider" element
     */
    public cn.geodata.models.geoprocessing.ModelType.Provider addNewProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ModelType.Provider target = null;
            target = (cn.geodata.models.geoprocessing.ModelType.Provider)get_store().add_element_user(PROVIDER$6);
            return target;
        }
    }
    
    /**
     * Unsets the "provider" element
     */
    public void unsetProvider()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROVIDER$6, 0);
        }
    }
    
    /**
     * Gets the "describe" element
     */
    public java.lang.String getDescribe()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIBE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "describe" element
     */
    public org.apache.xmlbeans.XmlString xgetDescribe()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIBE$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "describe" element
     */
    public boolean isSetDescribe()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DESCRIBE$8) != 0;
        }
    }
    
    /**
     * Sets the "describe" element
     */
    public void setDescribe(java.lang.String describe)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIBE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIBE$8);
            }
            target.setStringValue(describe);
        }
    }
    
    /**
     * Sets (as xml) the "describe" element
     */
    public void xsetDescribe(org.apache.xmlbeans.XmlString describe)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIBE$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIBE$8);
            }
            target.set(describe);
        }
    }
    
    /**
     * Unsets the "describe" element
     */
    public void unsetDescribe()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DESCRIBE$8, 0);
        }
    }
    
    /**
     * Gets array of all "process" elements
     */
    public cn.geodata.models.geoprocessing.ProcessType[] getProcessArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(PROCESS$10, targetList);
            cn.geodata.models.geoprocessing.ProcessType[] result = new cn.geodata.models.geoprocessing.ProcessType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "process" element
     */
    public cn.geodata.models.geoprocessing.ProcessType getProcessArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().find_element_user(PROCESS$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "process" element
     */
    public int sizeOfProcessArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCESS$10);
        }
    }
    
    /**
     * Sets array of all "process" element
     */
    public void setProcessArray(cn.geodata.models.geoprocessing.ProcessType[] processArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(processArray, PROCESS$10);
        }
    }
    
    /**
     * Sets ith "process" element
     */
    public void setProcessArray(int i, cn.geodata.models.geoprocessing.ProcessType process)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().find_element_user(PROCESS$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(process);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "process" element
     */
    public cn.geodata.models.geoprocessing.ProcessType insertNewProcess(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().insert_element_user(PROCESS$10, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "process" element
     */
    public cn.geodata.models.geoprocessing.ProcessType addNewProcess()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ProcessType target = null;
            target = (cn.geodata.models.geoprocessing.ProcessType)get_store().add_element_user(PROCESS$10);
            return target;
        }
    }
    
    /**
     * Removes the ith "process" element
     */
    public void removeProcess(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCESS$10, i);
        }
    }
    /**
     * An XML provider(@http://www.geodata.cn/models/geoprocessing).
     *
     * This is a complex type.
     */
    public static class ProviderImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.ModelType.Provider
    {
        
        public ProviderImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName INDIVIDUALNAME$0 = 
            new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "IndividualName");
        private static final javax.xml.namespace.QName ORGANISATIONNAME$2 = 
            new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "OrganisationName");
        private static final javax.xml.namespace.QName POSITIONNAME$4 = 
            new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "PositionName");
        private static final javax.xml.namespace.QName ROLE$6 = 
            new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "Role");
        private static final javax.xml.namespace.QName CONTACTINFO$8 = 
            new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "ContactInfo");
        
        
        /**
         * Gets the "IndividualName" element
         */
        public java.lang.String getIndividualName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIVIDUALNAME$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "IndividualName" element
         */
        public org.apache.xmlbeans.XmlString xgetIndividualName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIVIDUALNAME$0, 0);
                return target;
            }
        }
        
        /**
         * True if has "IndividualName" element
         */
        public boolean isSetIndividualName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(INDIVIDUALNAME$0) != 0;
            }
        }
        
        /**
         * Sets the "IndividualName" element
         */
        public void setIndividualName(java.lang.String individualName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIVIDUALNAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDIVIDUALNAME$0);
                }
                target.setStringValue(individualName);
            }
        }
        
        /**
         * Sets (as xml) the "IndividualName" element
         */
        public void xsetIndividualName(org.apache.xmlbeans.XmlString individualName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIVIDUALNAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDIVIDUALNAME$0);
                }
                target.set(individualName);
            }
        }
        
        /**
         * Unsets the "IndividualName" element
         */
        public void unsetIndividualName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(INDIVIDUALNAME$0, 0);
            }
        }
        
        /**
         * Gets the "OrganisationName" element
         */
        public java.lang.String getOrganisationName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANISATIONNAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "OrganisationName" element
         */
        public org.apache.xmlbeans.XmlString xgetOrganisationName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANISATIONNAME$2, 0);
                return target;
            }
        }
        
        /**
         * True if has "OrganisationName" element
         */
        public boolean isSetOrganisationName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ORGANISATIONNAME$2) != 0;
            }
        }
        
        /**
         * Sets the "OrganisationName" element
         */
        public void setOrganisationName(java.lang.String organisationName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORGANISATIONNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORGANISATIONNAME$2);
                }
                target.setStringValue(organisationName);
            }
        }
        
        /**
         * Sets (as xml) the "OrganisationName" element
         */
        public void xsetOrganisationName(org.apache.xmlbeans.XmlString organisationName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORGANISATIONNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORGANISATIONNAME$2);
                }
                target.set(organisationName);
            }
        }
        
        /**
         * Unsets the "OrganisationName" element
         */
        public void unsetOrganisationName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ORGANISATIONNAME$2, 0);
            }
        }
        
        /**
         * Gets the "PositionName" element
         */
        public java.lang.String getPositionName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONNAME$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PositionName" element
         */
        public org.apache.xmlbeans.XmlString xgetPositionName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSITIONNAME$4, 0);
                return target;
            }
        }
        
        /**
         * True if has "PositionName" element
         */
        public boolean isSetPositionName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(POSITIONNAME$4) != 0;
            }
        }
        
        /**
         * Sets the "PositionName" element
         */
        public void setPositionName(java.lang.String positionName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSITIONNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSITIONNAME$4);
                }
                target.setStringValue(positionName);
            }
        }
        
        /**
         * Sets (as xml) the "PositionName" element
         */
        public void xsetPositionName(org.apache.xmlbeans.XmlString positionName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSITIONNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSITIONNAME$4);
                }
                target.set(positionName);
            }
        }
        
        /**
         * Unsets the "PositionName" element
         */
        public void unsetPositionName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(POSITIONNAME$4, 0);
            }
        }
        
        /**
         * Gets the "Role" element
         */
        public java.lang.String getRole()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROLE$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Role" element
         */
        public org.apache.xmlbeans.XmlString xgetRole()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROLE$6, 0);
                return target;
            }
        }
        
        /**
         * True if has "Role" element
         */
        public boolean isSetRole()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ROLE$6) != 0;
            }
        }
        
        /**
         * Sets the "Role" element
         */
        public void setRole(java.lang.String role)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ROLE$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ROLE$6);
                }
                target.setStringValue(role);
            }
        }
        
        /**
         * Sets (as xml) the "Role" element
         */
        public void xsetRole(org.apache.xmlbeans.XmlString role)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ROLE$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ROLE$6);
                }
                target.set(role);
            }
        }
        
        /**
         * Unsets the "Role" element
         */
        public void unsetRole()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ROLE$6, 0);
            }
        }
        
        /**
         * Gets the "ContactInfo" element
         */
        public cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo getContactInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo target = null;
                target = (cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo)get_store().find_element_user(CONTACTINFO$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "ContactInfo" element
         */
        public boolean isSetContactInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CONTACTINFO$8) != 0;
            }
        }
        
        /**
         * Sets the "ContactInfo" element
         */
        public void setContactInfo(cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo contactInfo)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo target = null;
                target = (cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo)get_store().find_element_user(CONTACTINFO$8, 0);
                if (target == null)
                {
                    target = (cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo)get_store().add_element_user(CONTACTINFO$8);
                }
                target.set(contactInfo);
            }
        }
        
        /**
         * Appends and returns a new empty "ContactInfo" element
         */
        public cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo addNewContactInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo target = null;
                target = (cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo)get_store().add_element_user(CONTACTINFO$8);
                return target;
            }
        }
        
        /**
         * Unsets the "ContactInfo" element
         */
        public void unsetContactInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CONTACTINFO$8, 0);
            }
        }
        /**
         * An XML ContactInfo(@http://www.geodata.cn/models/geoprocessing).
         *
         * This is a complex type.
         */
        public static class ContactInfoImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.ModelType.Provider.ContactInfo
        {
            
            public ContactInfoImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            
        }
    }
}

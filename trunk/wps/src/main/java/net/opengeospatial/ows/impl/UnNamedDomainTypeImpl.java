/*
 * XML Type:  UnNamedDomainType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.UnNamedDomainType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML UnNamedDomainType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class UnNamedDomainTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.UnNamedDomainType
{
    
    public UnNamedDomainTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ALLOWEDVALUES$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AllowedValues");
    private static final javax.xml.namespace.QName ANYVALUE$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AnyValue");
    private static final javax.xml.namespace.QName NOVALUES$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "NoValues");
    private static final javax.xml.namespace.QName VALUESREFERENCE$6 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ValuesReference");
    private static final javax.xml.namespace.QName DEFAULTVALUE$8 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "DefaultValue");
    private static final javax.xml.namespace.QName MEANING$10 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Meaning");
    private static final javax.xml.namespace.QName DATATYPE$12 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "DataType");
    private static final javax.xml.namespace.QName UOM$14 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "UOM");
    private static final javax.xml.namespace.QName REFERENCESYSTEM$16 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ReferenceSystem");
    private static final javax.xml.namespace.QName METADATA$18 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Metadata");
    
    
    /**
     * Gets the "AllowedValues" element
     */
    public net.opengeospatial.ows.AllowedValuesDocument.AllowedValues getAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengeospatial.ows.AllowedValuesDocument.AllowedValues)get_store().find_element_user(ALLOWEDVALUES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AllowedValues" element
     */
    public boolean isSetAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ALLOWEDVALUES$0) != 0;
        }
    }
    
    /**
     * Sets the "AllowedValues" element
     */
    public void setAllowedValues(net.opengeospatial.ows.AllowedValuesDocument.AllowedValues allowedValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengeospatial.ows.AllowedValuesDocument.AllowedValues)get_store().find_element_user(ALLOWEDVALUES$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.AllowedValuesDocument.AllowedValues)get_store().add_element_user(ALLOWEDVALUES$0);
            }
            target.set(allowedValues);
        }
    }
    
    /**
     * Appends and returns a new empty "AllowedValues" element
     */
    public net.opengeospatial.ows.AllowedValuesDocument.AllowedValues addNewAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengeospatial.ows.AllowedValuesDocument.AllowedValues)get_store().add_element_user(ALLOWEDVALUES$0);
            return target;
        }
    }
    
    /**
     * Unsets the "AllowedValues" element
     */
    public void unsetAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ALLOWEDVALUES$0, 0);
        }
    }
    
    /**
     * Gets the "AnyValue" element
     */
    public net.opengeospatial.ows.AnyValueDocument.AnyValue getAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AnyValue" element
     */
    public boolean isSetAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANYVALUE$2) != 0;
        }
    }
    
    /**
     * Sets the "AnyValue" element
     */
    public void setAnyValue(net.opengeospatial.ows.AnyValueDocument.AnyValue anyValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().find_element_user(ANYVALUE$2, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$2);
            }
            target.set(anyValue);
        }
    }
    
    /**
     * Appends and returns a new empty "AnyValue" element
     */
    public net.opengeospatial.ows.AnyValueDocument.AnyValue addNewAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.AnyValueDocument.AnyValue target = null;
            target = (net.opengeospatial.ows.AnyValueDocument.AnyValue)get_store().add_element_user(ANYVALUE$2);
            return target;
        }
    }
    
    /**
     * Unsets the "AnyValue" element
     */
    public void unsetAnyValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANYVALUE$2, 0);
        }
    }
    
    /**
     * Gets the "NoValues" element
     */
    public net.opengeospatial.ows.NoValuesDocument.NoValues getNoValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.NoValuesDocument.NoValues target = null;
            target = (net.opengeospatial.ows.NoValuesDocument.NoValues)get_store().find_element_user(NOVALUES$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "NoValues" element
     */
    public boolean isSetNoValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NOVALUES$4) != 0;
        }
    }
    
    /**
     * Sets the "NoValues" element
     */
    public void setNoValues(net.opengeospatial.ows.NoValuesDocument.NoValues noValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.NoValuesDocument.NoValues target = null;
            target = (net.opengeospatial.ows.NoValuesDocument.NoValues)get_store().find_element_user(NOVALUES$4, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.NoValuesDocument.NoValues)get_store().add_element_user(NOVALUES$4);
            }
            target.set(noValues);
        }
    }
    
    /**
     * Appends and returns a new empty "NoValues" element
     */
    public net.opengeospatial.ows.NoValuesDocument.NoValues addNewNoValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.NoValuesDocument.NoValues target = null;
            target = (net.opengeospatial.ows.NoValuesDocument.NoValues)get_store().add_element_user(NOVALUES$4);
            return target;
        }
    }
    
    /**
     * Unsets the "NoValues" element
     */
    public void unsetNoValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NOVALUES$4, 0);
        }
    }
    
    /**
     * Gets the "ValuesReference" element
     */
    public net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference getValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().find_element_user(VALUESREFERENCE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ValuesReference" element
     */
    public boolean isSetValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VALUESREFERENCE$6) != 0;
        }
    }
    
    /**
     * Sets the "ValuesReference" element
     */
    public void setValuesReference(net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference valuesReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().find_element_user(VALUESREFERENCE$6, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().add_element_user(VALUESREFERENCE$6);
            }
            target.set(valuesReference);
        }
    }
    
    /**
     * Appends and returns a new empty "ValuesReference" element
     */
    public net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference addNewValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference target = null;
            target = (net.opengeospatial.ows.ValuesReferenceDocument.ValuesReference)get_store().add_element_user(VALUESREFERENCE$6);
            return target;
        }
    }
    
    /**
     * Unsets the "ValuesReference" element
     */
    public void unsetValuesReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VALUESREFERENCE$6, 0);
        }
    }
    
    /**
     * Gets the "DefaultValue" element
     */
    public net.opengeospatial.ows.RangeType getDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(DEFAULTVALUE$8, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "DefaultValue" element
     */
    public boolean isSetDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DEFAULTVALUE$8) != 0;
        }
    }
    
    /**
     * Sets the "DefaultValue" element
     */
    public void setDefaultValue(net.opengeospatial.ows.RangeType defaultValue)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(DEFAULTVALUE$8, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(DEFAULTVALUE$8);
            }
            target.set(defaultValue);
        }
    }
    
    /**
     * Appends and returns a new empty "DefaultValue" element
     */
    public net.opengeospatial.ows.RangeType addNewDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.RangeType target = null;
            target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(DEFAULTVALUE$8);
            return target;
        }
    }
    
    /**
     * Unsets the "DefaultValue" element
     */
    public void unsetDefaultValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DEFAULTVALUE$8, 0);
        }
    }
    
    /**
     * Gets the "Meaning" element
     */
    public net.opengeospatial.ows.DomainMetadataType getMeaning()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(MEANING$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Meaning" element
     */
    public boolean isSetMeaning()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MEANING$10) != 0;
        }
    }
    
    /**
     * Sets the "Meaning" element
     */
    public void setMeaning(net.opengeospatial.ows.DomainMetadataType meaning)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(MEANING$10, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(MEANING$10);
            }
            target.set(meaning);
        }
    }
    
    /**
     * Appends and returns a new empty "Meaning" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewMeaning()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(MEANING$10);
            return target;
        }
    }
    
    /**
     * Unsets the "Meaning" element
     */
    public void unsetMeaning()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MEANING$10, 0);
        }
    }
    
    /**
     * Gets the "DataType" element
     */
    public net.opengeospatial.ows.DomainMetadataType getDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(DATATYPE$12, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "DataType" element
     */
    public boolean isSetDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DATATYPE$12) != 0;
        }
    }
    
    /**
     * Sets the "DataType" element
     */
    public void setDataType(net.opengeospatial.ows.DomainMetadataType dataType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(DATATYPE$12, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(DATATYPE$12);
            }
            target.set(dataType);
        }
    }
    
    /**
     * Appends and returns a new empty "DataType" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(DATATYPE$12);
            return target;
        }
    }
    
    /**
     * Unsets the "DataType" element
     */
    public void unsetDataType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DATATYPE$12, 0);
        }
    }
    
    /**
     * Gets the "UOM" element
     */
    public net.opengeospatial.ows.DomainMetadataType getUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(UOM$14, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "UOM" element
     */
    public boolean isSetUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UOM$14) != 0;
        }
    }
    
    /**
     * Sets the "UOM" element
     */
    public void setUOM(net.opengeospatial.ows.DomainMetadataType uom)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(UOM$14, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(UOM$14);
            }
            target.set(uom);
        }
    }
    
    /**
     * Appends and returns a new empty "UOM" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(UOM$14);
            return target;
        }
    }
    
    /**
     * Unsets the "UOM" element
     */
    public void unsetUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UOM$14, 0);
        }
    }
    
    /**
     * Gets the "ReferenceSystem" element
     */
    public net.opengeospatial.ows.DomainMetadataType getReferenceSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(REFERENCESYSTEM$16, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ReferenceSystem" element
     */
    public boolean isSetReferenceSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REFERENCESYSTEM$16) != 0;
        }
    }
    
    /**
     * Sets the "ReferenceSystem" element
     */
    public void setReferenceSystem(net.opengeospatial.ows.DomainMetadataType referenceSystem)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().find_element_user(REFERENCESYSTEM$16, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(REFERENCESYSTEM$16);
            }
            target.set(referenceSystem);
        }
    }
    
    /**
     * Appends and returns a new empty "ReferenceSystem" element
     */
    public net.opengeospatial.ows.DomainMetadataType addNewReferenceSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainMetadataType target = null;
            target = (net.opengeospatial.ows.DomainMetadataType)get_store().add_element_user(REFERENCESYSTEM$16);
            return target;
        }
    }
    
    /**
     * Unsets the "ReferenceSystem" element
     */
    public void unsetReferenceSystem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REFERENCESYSTEM$16, 0);
        }
    }
    
    /**
     * Gets array of all "Metadata" elements
     */
    public net.opengeospatial.ows.MetadataType[] getMetadataArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METADATA$18, targetList);
            net.opengeospatial.ows.MetadataType[] result = new net.opengeospatial.ows.MetadataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType getMetadataArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().find_element_user(METADATA$18, i);
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
            return get_store().count_elements(METADATA$18);
        }
    }
    
    /**
     * Sets array of all "Metadata" element
     */
    public void setMetadataArray(net.opengeospatial.ows.MetadataType[] metadataArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metadataArray, METADATA$18);
        }
    }
    
    /**
     * Sets ith "Metadata" element
     */
    public void setMetadataArray(int i, net.opengeospatial.ows.MetadataType metadata)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().find_element_user(METADATA$18, i);
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
    public net.opengeospatial.ows.MetadataType insertNewMetadata(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().insert_element_user(METADATA$18, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metadata" element
     */
    public net.opengeospatial.ows.MetadataType addNewMetadata()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.MetadataType target = null;
            target = (net.opengeospatial.ows.MetadataType)get_store().add_element_user(METADATA$18);
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
            get_store().remove_element(METADATA$18, i);
        }
    }
}

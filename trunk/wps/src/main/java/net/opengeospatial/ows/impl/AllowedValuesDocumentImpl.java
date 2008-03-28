/*
 * An XML document type.
 * Localname: AllowedValues
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.AllowedValuesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one AllowedValues(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class AllowedValuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.AllowedValuesDocument
{
    
    public AllowedValuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ALLOWEDVALUES$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "AllowedValues");
    
    
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
     * An XML AllowedValues(@http://www.opengeospatial.net/ows).
     *
     * This is a complex type.
     */
    public static class AllowedValuesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.AllowedValuesDocument.AllowedValues
    {
        
        public AllowedValuesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName VALUE$0 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Value");
        private static final javax.xml.namespace.QName RANGE$2 = 
            new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Range");
        
        
        /**
         * Gets array of all "Value" elements
         */
        public net.opengeospatial.ows.ValueType[] getValueArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(VALUE$0, targetList);
                net.opengeospatial.ows.ValueType[] result = new net.opengeospatial.ows.ValueType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Value" element
         */
        public net.opengeospatial.ows.ValueType getValueArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.ValueType target = null;
                target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(VALUE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Value" element
         */
        public int sizeOfValueArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(VALUE$0);
            }
        }
        
        /**
         * Sets array of all "Value" element
         */
        public void setValueArray(net.opengeospatial.ows.ValueType[] valueArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(valueArray, VALUE$0);
            }
        }
        
        /**
         * Sets ith "Value" element
         */
        public void setValueArray(int i, net.opengeospatial.ows.ValueType value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.ValueType target = null;
                target = (net.opengeospatial.ows.ValueType)get_store().find_element_user(VALUE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(value);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Value" element
         */
        public net.opengeospatial.ows.ValueType insertNewValue(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.ValueType target = null;
                target = (net.opengeospatial.ows.ValueType)get_store().insert_element_user(VALUE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Value" element
         */
        public net.opengeospatial.ows.ValueType addNewValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.ValueType target = null;
                target = (net.opengeospatial.ows.ValueType)get_store().add_element_user(VALUE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "Value" element
         */
        public void removeValue(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(VALUE$0, i);
            }
        }
        
        /**
         * Gets array of all "Range" elements
         */
        public net.opengeospatial.ows.RangeType[] getRangeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(RANGE$2, targetList);
                net.opengeospatial.ows.RangeType[] result = new net.opengeospatial.ows.RangeType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Range" element
         */
        public net.opengeospatial.ows.RangeType getRangeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RangeType target = null;
                target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(RANGE$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "Range" element
         */
        public int sizeOfRangeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RANGE$2);
            }
        }
        
        /**
         * Sets array of all "Range" element
         */
        public void setRangeArray(net.opengeospatial.ows.RangeType[] rangeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(rangeArray, RANGE$2);
            }
        }
        
        /**
         * Sets ith "Range" element
         */
        public void setRangeArray(int i, net.opengeospatial.ows.RangeType range)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RangeType target = null;
                target = (net.opengeospatial.ows.RangeType)get_store().find_element_user(RANGE$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(range);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "Range" element
         */
        public net.opengeospatial.ows.RangeType insertNewRange(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RangeType target = null;
                target = (net.opengeospatial.ows.RangeType)get_store().insert_element_user(RANGE$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Range" element
         */
        public net.opengeospatial.ows.RangeType addNewRange()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengeospatial.ows.RangeType target = null;
                target = (net.opengeospatial.ows.RangeType)get_store().add_element_user(RANGE$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "Range" element
         */
        public void removeRange(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RANGE$2, i);
            }
        }
    }
}

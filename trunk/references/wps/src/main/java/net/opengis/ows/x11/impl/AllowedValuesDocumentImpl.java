/*
 * An XML document type.
 * Localname: AllowedValues
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AllowedValuesDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one AllowedValues(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class AllowedValuesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AllowedValuesDocument
{
    private static final long serialVersionUID = 1L;
    
    public AllowedValuesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ALLOWEDVALUES$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AllowedValues");
    
    
    /**
     * Gets the "AllowedValues" element
     */
    public net.opengis.ows.x11.AllowedValuesDocument.AllowedValues getAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues)get_store().find_element_user(ALLOWEDVALUES$0, 0);
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
    public void setAllowedValues(net.opengis.ows.x11.AllowedValuesDocument.AllowedValues allowedValues)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues)get_store().find_element_user(ALLOWEDVALUES$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues)get_store().add_element_user(ALLOWEDVALUES$0);
            }
            target.set(allowedValues);
        }
    }
    
    /**
     * Appends and returns a new empty "AllowedValues" element
     */
    public net.opengis.ows.x11.AllowedValuesDocument.AllowedValues addNewAllowedValues()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AllowedValuesDocument.AllowedValues target = null;
            target = (net.opengis.ows.x11.AllowedValuesDocument.AllowedValues)get_store().add_element_user(ALLOWEDVALUES$0);
            return target;
        }
    }
    /**
     * An XML AllowedValues(@http://www.opengis.net/ows/1.1).
     *
     * This is a complex type.
     */
    public static class AllowedValuesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AllowedValuesDocument.AllowedValues
    {
        private static final long serialVersionUID = 1L;
        
        public AllowedValuesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName VALUE$0 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Value");
        private static final javax.xml.namespace.QName RANGE$2 = 
            new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Range");
        
        
        /**
         * Gets array of all "Value" elements
         */
        public net.opengis.ows.x11.ValueType[] getValueArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(VALUE$0, targetList);
                net.opengis.ows.x11.ValueType[] result = new net.opengis.ows.x11.ValueType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Value" element
         */
        public net.opengis.ows.x11.ValueType getValueArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ValueType target = null;
                target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(VALUE$0, i);
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
        public void setValueArray(net.opengis.ows.x11.ValueType[] valueArray)
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
        public void setValueArray(int i, net.opengis.ows.x11.ValueType value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ValueType target = null;
                target = (net.opengis.ows.x11.ValueType)get_store().find_element_user(VALUE$0, i);
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
        public net.opengis.ows.x11.ValueType insertNewValue(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ValueType target = null;
                target = (net.opengis.ows.x11.ValueType)get_store().insert_element_user(VALUE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Value" element
         */
        public net.opengis.ows.x11.ValueType addNewValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.ValueType target = null;
                target = (net.opengis.ows.x11.ValueType)get_store().add_element_user(VALUE$0);
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
        public net.opengis.ows.x11.RangeType[] getRangeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(RANGE$2, targetList);
                net.opengis.ows.x11.RangeType[] result = new net.opengis.ows.x11.RangeType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "Range" element
         */
        public net.opengis.ows.x11.RangeType getRangeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.RangeType target = null;
                target = (net.opengis.ows.x11.RangeType)get_store().find_element_user(RANGE$2, i);
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
        public void setRangeArray(net.opengis.ows.x11.RangeType[] rangeArray)
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
        public void setRangeArray(int i, net.opengis.ows.x11.RangeType range)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.RangeType target = null;
                target = (net.opengis.ows.x11.RangeType)get_store().find_element_user(RANGE$2, i);
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
        public net.opengis.ows.x11.RangeType insertNewRange(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.RangeType target = null;
                target = (net.opengis.ows.x11.RangeType)get_store().insert_element_user(RANGE$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "Range" element
         */
        public net.opengis.ows.x11.RangeType addNewRange()
        {
            synchronized (monitor())
            {
                check_orphaned();
                net.opengis.ows.x11.RangeType target = null;
                target = (net.opengis.ows.x11.RangeType)get_store().add_element_user(RANGE$2);
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

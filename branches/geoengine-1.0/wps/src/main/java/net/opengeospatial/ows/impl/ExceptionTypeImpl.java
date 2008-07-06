/*
 * XML Type:  ExceptionType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.ExceptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML ExceptionType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class ExceptionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.ExceptionType
{
    
    public ExceptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EXCEPTIONTEXT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "ExceptionText");
    private static final javax.xml.namespace.QName EXCEPTIONCODE$2 = 
        new javax.xml.namespace.QName("", "exceptionCode");
    private static final javax.xml.namespace.QName LOCATOR$4 = 
        new javax.xml.namespace.QName("", "locator");
    
    
    /**
     * Gets array of all "ExceptionText" elements
     */
    public java.lang.String[] getExceptionTextArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(EXCEPTIONTEXT$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "ExceptionText" element
     */
    public java.lang.String getExceptionTextArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXCEPTIONTEXT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "ExceptionText" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetExceptionTextArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(EXCEPTIONTEXT$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "ExceptionText" element
     */
    public org.apache.xmlbeans.XmlString xgetExceptionTextArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXCEPTIONTEXT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "ExceptionText" element
     */
    public int sizeOfExceptionTextArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(EXCEPTIONTEXT$0);
        }
    }
    
    /**
     * Sets array of all "ExceptionText" element
     */
    public void setExceptionTextArray(java.lang.String[] exceptionTextArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(exceptionTextArray, EXCEPTIONTEXT$0);
        }
    }
    
    /**
     * Sets ith "ExceptionText" element
     */
    public void setExceptionTextArray(int i, java.lang.String exceptionText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EXCEPTIONTEXT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(exceptionText);
        }
    }
    
    /**
     * Sets (as xml) array of all "ExceptionText" element
     */
    public void xsetExceptionTextArray(org.apache.xmlbeans.XmlString[]exceptionTextArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(exceptionTextArray, EXCEPTIONTEXT$0);
        }
    }
    
    /**
     * Sets (as xml) ith "ExceptionText" element
     */
    public void xsetExceptionTextArray(int i, org.apache.xmlbeans.XmlString exceptionText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EXCEPTIONTEXT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(exceptionText);
        }
    }
    
    /**
     * Inserts the value as the ith "ExceptionText" element
     */
    public void insertExceptionText(int i, java.lang.String exceptionText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(EXCEPTIONTEXT$0, i);
            target.setStringValue(exceptionText);
        }
    }
    
    /**
     * Appends the value as the last "ExceptionText" element
     */
    public void addExceptionText(java.lang.String exceptionText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EXCEPTIONTEXT$0);
            target.setStringValue(exceptionText);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ExceptionText" element
     */
    public org.apache.xmlbeans.XmlString insertNewExceptionText(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(EXCEPTIONTEXT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ExceptionText" element
     */
    public org.apache.xmlbeans.XmlString addNewExceptionText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EXCEPTIONTEXT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "ExceptionText" element
     */
    public void removeExceptionText(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(EXCEPTIONTEXT$0, i);
        }
    }
    
    /**
     * Gets the "exceptionCode" attribute
     */
    public java.lang.String getExceptionCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXCEPTIONCODE$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "exceptionCode" attribute
     */
    public org.apache.xmlbeans.XmlString xgetExceptionCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(EXCEPTIONCODE$2);
            return target;
        }
    }
    
    /**
     * Sets the "exceptionCode" attribute
     */
    public void setExceptionCode(java.lang.String exceptionCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(EXCEPTIONCODE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(EXCEPTIONCODE$2);
            }
            target.setStringValue(exceptionCode);
        }
    }
    
    /**
     * Sets (as xml) the "exceptionCode" attribute
     */
    public void xsetExceptionCode(org.apache.xmlbeans.XmlString exceptionCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(EXCEPTIONCODE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(EXCEPTIONCODE$2);
            }
            target.set(exceptionCode);
        }
    }
    
    /**
     * Gets the "locator" attribute
     */
    public java.lang.String getLocator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LOCATOR$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "locator" attribute
     */
    public org.apache.xmlbeans.XmlString xgetLocator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LOCATOR$4);
            return target;
        }
    }
    
    /**
     * True if has "locator" attribute
     */
    public boolean isSetLocator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(LOCATOR$4) != null;
        }
    }
    
    /**
     * Sets the "locator" attribute
     */
    public void setLocator(java.lang.String locator)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LOCATOR$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LOCATOR$4);
            }
            target.setStringValue(locator);
        }
    }
    
    /**
     * Sets (as xml) the "locator" attribute
     */
    public void xsetLocator(org.apache.xmlbeans.XmlString locator)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LOCATOR$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(LOCATOR$4);
            }
            target.set(locator);
        }
    }
    
    /**
     * Unsets the "locator" attribute
     */
    public void unsetLocator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(LOCATOR$4);
        }
    }
}

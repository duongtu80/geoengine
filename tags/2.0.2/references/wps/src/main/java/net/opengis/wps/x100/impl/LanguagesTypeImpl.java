/*
 * XML Type:  LanguagesType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.LanguagesType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML LanguagesType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class LanguagesTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.LanguagesType
{
    private static final long serialVersionUID = 1L;
    
    public LanguagesTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LANGUAGE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Language");
    
    
    /**
     * Gets array of all "Language" elements
     */
    public java.lang.String[] getLanguageArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(LANGUAGE$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "Language" element
     */
    public java.lang.String getLanguageArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LANGUAGE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "Language" elements
     */
    public org.apache.xmlbeans.XmlLanguage[] xgetLanguageArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(LANGUAGE$0, targetList);
            org.apache.xmlbeans.XmlLanguage[] result = new org.apache.xmlbeans.XmlLanguage[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "Language" element
     */
    public org.apache.xmlbeans.XmlLanguage xgetLanguageArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLanguage target = null;
            target = (org.apache.xmlbeans.XmlLanguage)get_store().find_element_user(LANGUAGE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlLanguage)target;
        }
    }
    
    /**
     * Returns number of "Language" element
     */
    public int sizeOfLanguageArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LANGUAGE$0);
        }
    }
    
    /**
     * Sets array of all "Language" element
     */
    public void setLanguageArray(java.lang.String[] languageArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(languageArray, LANGUAGE$0);
        }
    }
    
    /**
     * Sets ith "Language" element
     */
    public void setLanguageArray(int i, java.lang.String language)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LANGUAGE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(language);
        }
    }
    
    /**
     * Sets (as xml) array of all "Language" element
     */
    public void xsetLanguageArray(org.apache.xmlbeans.XmlLanguage[]languageArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(languageArray, LANGUAGE$0);
        }
    }
    
    /**
     * Sets (as xml) ith "Language" element
     */
    public void xsetLanguageArray(int i, org.apache.xmlbeans.XmlLanguage language)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLanguage target = null;
            target = (org.apache.xmlbeans.XmlLanguage)get_store().find_element_user(LANGUAGE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(language);
        }
    }
    
    /**
     * Inserts the value as the ith "Language" element
     */
    public void insertLanguage(int i, java.lang.String language)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(LANGUAGE$0, i);
            target.setStringValue(language);
        }
    }
    
    /**
     * Appends the value as the last "Language" element
     */
    public void addLanguage(java.lang.String language)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LANGUAGE$0);
            target.setStringValue(language);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Language" element
     */
    public org.apache.xmlbeans.XmlLanguage insertNewLanguage(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLanguage target = null;
            target = (org.apache.xmlbeans.XmlLanguage)get_store().insert_element_user(LANGUAGE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Language" element
     */
    public org.apache.xmlbeans.XmlLanguage addNewLanguage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLanguage target = null;
            target = (org.apache.xmlbeans.XmlLanguage)get_store().add_element_user(LANGUAGE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Language" element
     */
    public void removeLanguage(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LANGUAGE$0, i);
        }
    }
}

/*
 * XML Type:  SectionsType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.SectionsType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML SectionsType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class SectionsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.SectionsType
{
    
    public SectionsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SECTION$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Section");
    
    
    /**
     * Gets array of all "Section" elements
     */
    public java.lang.String[] getSectionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SECTION$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "Section" element
     */
    public java.lang.String getSectionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SECTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "Section" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetSectionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SECTION$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "Section" element
     */
    public org.apache.xmlbeans.XmlString xgetSectionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SECTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "Section" element
     */
    public int sizeOfSectionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SECTION$0);
        }
    }
    
    /**
     * Sets array of all "Section" element
     */
    public void setSectionArray(java.lang.String[] sectionArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(sectionArray, SECTION$0);
        }
    }
    
    /**
     * Sets ith "Section" element
     */
    public void setSectionArray(int i, java.lang.String section)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SECTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(section);
        }
    }
    
    /**
     * Sets (as xml) array of all "Section" element
     */
    public void xsetSectionArray(org.apache.xmlbeans.XmlString[]sectionArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(sectionArray, SECTION$0);
        }
    }
    
    /**
     * Sets (as xml) ith "Section" element
     */
    public void xsetSectionArray(int i, org.apache.xmlbeans.XmlString section)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SECTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(section);
        }
    }
    
    /**
     * Inserts the value as the ith "Section" element
     */
    public void insertSection(int i, java.lang.String section)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(SECTION$0, i);
            target.setStringValue(section);
        }
    }
    
    /**
     * Appends the value as the last "Section" element
     */
    public void addSection(java.lang.String section)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SECTION$0);
            target.setStringValue(section);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Section" element
     */
    public org.apache.xmlbeans.XmlString insertNewSection(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(SECTION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Section" element
     */
    public org.apache.xmlbeans.XmlString addNewSection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SECTION$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Section" element
     */
    public void removeSection(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SECTION$0, i);
        }
    }
}

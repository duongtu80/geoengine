/*
 * XML Type:  DescriptionType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.DescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML DescriptionType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class DescriptionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.DescriptionType
{
    
    public DescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TITLE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Title");
    private static final javax.xml.namespace.QName ABSTRACT$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Abstract");
    private static final javax.xml.namespace.QName KEYWORDS$4 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Keywords");
    
    
    /**
     * Gets the "Title" element
     */
    public java.lang.String getTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Title" element
     */
    public org.apache.xmlbeans.XmlString xgetTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "Title" element
     */
    public boolean isSetTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TITLE$0) != 0;
        }
    }
    
    /**
     * Sets the "Title" element
     */
    public void setTitle(java.lang.String title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TITLE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TITLE$0);
            }
            target.setStringValue(title);
        }
    }
    
    /**
     * Sets (as xml) the "Title" element
     */
    public void xsetTitle(org.apache.xmlbeans.XmlString title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TITLE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TITLE$0);
            }
            target.set(title);
        }
    }
    
    /**
     * Unsets the "Title" element
     */
    public void unsetTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TITLE$0, 0);
        }
    }
    
    /**
     * Gets the "Abstract" element
     */
    public java.lang.String getAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABSTRACT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Abstract" element
     */
    public org.apache.xmlbeans.XmlString xgetAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABSTRACT$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "Abstract" element
     */
    public boolean isSetAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABSTRACT$2) != 0;
        }
    }
    
    /**
     * Sets the "Abstract" element
     */
    public void setAbstract(java.lang.String xabstract)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ABSTRACT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ABSTRACT$2);
            }
            target.setStringValue(xabstract);
        }
    }
    
    /**
     * Sets (as xml) the "Abstract" element
     */
    public void xsetAbstract(org.apache.xmlbeans.XmlString xabstract)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ABSTRACT$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ABSTRACT$2);
            }
            target.set(xabstract);
        }
    }
    
    /**
     * Unsets the "Abstract" element
     */
    public void unsetAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABSTRACT$2, 0);
        }
    }
    
    /**
     * Gets array of all "Keywords" elements
     */
    public net.opengeospatial.ows.KeywordsType[] getKeywordsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(KEYWORDS$4, targetList);
            net.opengeospatial.ows.KeywordsType[] result = new net.opengeospatial.ows.KeywordsType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Keywords" element
     */
    public net.opengeospatial.ows.KeywordsType getKeywordsArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.KeywordsType target = null;
            target = (net.opengeospatial.ows.KeywordsType)get_store().find_element_user(KEYWORDS$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Keywords" element
     */
    public int sizeOfKeywordsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(KEYWORDS$4);
        }
    }
    
    /**
     * Sets array of all "Keywords" element
     */
    public void setKeywordsArray(net.opengeospatial.ows.KeywordsType[] keywordsArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(keywordsArray, KEYWORDS$4);
        }
    }
    
    /**
     * Sets ith "Keywords" element
     */
    public void setKeywordsArray(int i, net.opengeospatial.ows.KeywordsType keywords)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.KeywordsType target = null;
            target = (net.opengeospatial.ows.KeywordsType)get_store().find_element_user(KEYWORDS$4, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(keywords);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Keywords" element
     */
    public net.opengeospatial.ows.KeywordsType insertNewKeywords(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.KeywordsType target = null;
            target = (net.opengeospatial.ows.KeywordsType)get_store().insert_element_user(KEYWORDS$4, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Keywords" element
     */
    public net.opengeospatial.ows.KeywordsType addNewKeywords()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.KeywordsType target = null;
            target = (net.opengeospatial.ows.KeywordsType)get_store().add_element_user(KEYWORDS$4);
            return target;
        }
    }
    
    /**
     * Removes the ith "Keywords" element
     */
    public void removeKeywords(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(KEYWORDS$4, i);
        }
    }
}

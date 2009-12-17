/*
 * XML Type:  DescriptionType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.DescriptionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML DescriptionType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class DescriptionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.DescriptionType
{
    private static final long serialVersionUID = 1L;
    
    public DescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TITLE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Title");
    private static final javax.xml.namespace.QName ABSTRACT$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Abstract");
    private static final javax.xml.namespace.QName KEYWORDS$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Keywords");
    
    
    /**
     * Gets array of all "Title" elements
     */
    public net.opengis.ows.x11.LanguageStringType[] getTitleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(TITLE$0, targetList);
            net.opengis.ows.x11.LanguageStringType[] result = new net.opengis.ows.x11.LanguageStringType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Title" element
     */
    public net.opengis.ows.x11.LanguageStringType getTitleArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(TITLE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Title" element
     */
    public int sizeOfTitleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TITLE$0);
        }
    }
    
    /**
     * Sets array of all "Title" element
     */
    public void setTitleArray(net.opengis.ows.x11.LanguageStringType[] titleArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(titleArray, TITLE$0);
        }
    }
    
    /**
     * Sets ith "Title" element
     */
    public void setTitleArray(int i, net.opengis.ows.x11.LanguageStringType title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(TITLE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(title);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Title" element
     */
    public net.opengis.ows.x11.LanguageStringType insertNewTitle(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().insert_element_user(TITLE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Title" element
     */
    public net.opengis.ows.x11.LanguageStringType addNewTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(TITLE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Title" element
     */
    public void removeTitle(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TITLE$0, i);
        }
    }
    
    /**
     * Gets array of all "Abstract" elements
     */
    public net.opengis.ows.x11.LanguageStringType[] getAbstractArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ABSTRACT$2, targetList);
            net.opengis.ows.x11.LanguageStringType[] result = new net.opengis.ows.x11.LanguageStringType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType getAbstractArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Abstract" element
     */
    public int sizeOfAbstractArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABSTRACT$2);
        }
    }
    
    /**
     * Sets array of all "Abstract" element
     */
    public void setAbstractArray(net.opengis.ows.x11.LanguageStringType[] xabstractArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(xabstractArray, ABSTRACT$2);
        }
    }
    
    /**
     * Sets ith "Abstract" element
     */
    public void setAbstractArray(int i, net.opengis.ows.x11.LanguageStringType xabstract)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(xabstract);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType insertNewAbstract(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().insert_element_user(ABSTRACT$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType addNewAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(ABSTRACT$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "Abstract" element
     */
    public void removeAbstract(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABSTRACT$2, i);
        }
    }
    
    /**
     * Gets array of all "Keywords" elements
     */
    public net.opengis.ows.x11.KeywordsType[] getKeywordsArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(KEYWORDS$4, targetList);
            net.opengis.ows.x11.KeywordsType[] result = new net.opengis.ows.x11.KeywordsType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Keywords" element
     */
    public net.opengis.ows.x11.KeywordsType getKeywordsArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.KeywordsType target = null;
            target = (net.opengis.ows.x11.KeywordsType)get_store().find_element_user(KEYWORDS$4, i);
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
    public void setKeywordsArray(net.opengis.ows.x11.KeywordsType[] keywordsArray)
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
    public void setKeywordsArray(int i, net.opengis.ows.x11.KeywordsType keywords)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.KeywordsType target = null;
            target = (net.opengis.ows.x11.KeywordsType)get_store().find_element_user(KEYWORDS$4, i);
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
    public net.opengis.ows.x11.KeywordsType insertNewKeywords(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.KeywordsType target = null;
            target = (net.opengis.ows.x11.KeywordsType)get_store().insert_element_user(KEYWORDS$4, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Keywords" element
     */
    public net.opengis.ows.x11.KeywordsType addNewKeywords()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.KeywordsType target = null;
            target = (net.opengis.ows.x11.KeywordsType)get_store().add_element_user(KEYWORDS$4);
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

/*
 * XML Type:  KeywordsType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.KeywordsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML KeywordsType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class KeywordsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.KeywordsType
{
    private static final long serialVersionUID = 1L;
    
    public KeywordsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KEYWORD$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Keyword");
    private static final javax.xml.namespace.QName TYPE$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Type");
    
    
    /**
     * Gets array of all "Keyword" elements
     */
    public net.opengis.ows.x11.LanguageStringType[] getKeywordArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(KEYWORD$0, targetList);
            net.opengis.ows.x11.LanguageStringType[] result = new net.opengis.ows.x11.LanguageStringType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Keyword" element
     */
    public net.opengis.ows.x11.LanguageStringType getKeywordArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(KEYWORD$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Keyword" element
     */
    public int sizeOfKeywordArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(KEYWORD$0);
        }
    }
    
    /**
     * Sets array of all "Keyword" element
     */
    public void setKeywordArray(net.opengis.ows.x11.LanguageStringType[] keywordArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(keywordArray, KEYWORD$0);
        }
    }
    
    /**
     * Sets ith "Keyword" element
     */
    public void setKeywordArray(int i, net.opengis.ows.x11.LanguageStringType keyword)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(KEYWORD$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(keyword);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Keyword" element
     */
    public net.opengis.ows.x11.LanguageStringType insertNewKeyword(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().insert_element_user(KEYWORD$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Keyword" element
     */
    public net.opengis.ows.x11.LanguageStringType addNewKeyword()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(KEYWORD$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Keyword" element
     */
    public void removeKeyword(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(KEYWORD$0, i);
        }
    }
    
    /**
     * Gets the "Type" element
     */
    public net.opengis.ows.x11.CodeType getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(TYPE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Type" element
     */
    public boolean isSetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TYPE$2) != 0;
        }
    }
    
    /**
     * Sets the "Type" element
     */
    public void setType(net.opengis.ows.x11.CodeType type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().find_element_user(TYPE$2, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.CodeType)get_store().add_element_user(TYPE$2);
            }
            target.set(type);
        }
    }
    
    /**
     * Appends and returns a new empty "Type" element
     */
    public net.opengis.ows.x11.CodeType addNewType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.CodeType target = null;
            target = (net.opengis.ows.x11.CodeType)get_store().add_element_user(TYPE$2);
            return target;
        }
    }
    
    /**
     * Unsets the "Type" element
     */
    public void unsetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TYPE$2, 0);
        }
    }
}

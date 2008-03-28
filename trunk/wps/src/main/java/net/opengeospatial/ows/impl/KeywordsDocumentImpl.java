/*
 * An XML document type.
 * Localname: Keywords
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.KeywordsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * A document containing one Keywords(@http://www.opengeospatial.net/ows) element.
 *
 * This is a complex type.
 */
public class KeywordsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.KeywordsDocument
{
    
    public KeywordsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KEYWORDS$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Keywords");
    
    
    /**
     * Gets the "Keywords" element
     */
    public net.opengeospatial.ows.KeywordsType getKeywords()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.KeywordsType target = null;
            target = (net.opengeospatial.ows.KeywordsType)get_store().find_element_user(KEYWORDS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Keywords" element
     */
    public void setKeywords(net.opengeospatial.ows.KeywordsType keywords)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.KeywordsType target = null;
            target = (net.opengeospatial.ows.KeywordsType)get_store().find_element_user(KEYWORDS$0, 0);
            if (target == null)
            {
                target = (net.opengeospatial.ows.KeywordsType)get_store().add_element_user(KEYWORDS$0);
            }
            target.set(keywords);
        }
    }
    
    /**
     * Appends and returns a new empty "Keywords" element
     */
    public net.opengeospatial.ows.KeywordsType addNewKeywords()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.KeywordsType target = null;
            target = (net.opengeospatial.ows.KeywordsType)get_store().add_element_user(KEYWORDS$0);
            return target;
        }
    }
}

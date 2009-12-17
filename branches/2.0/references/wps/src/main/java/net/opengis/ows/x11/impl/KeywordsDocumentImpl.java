/*
 * An XML document type.
 * Localname: Keywords
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.KeywordsDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Keywords(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class KeywordsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.KeywordsDocument
{
    private static final long serialVersionUID = 1L;
    
    public KeywordsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName KEYWORDS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Keywords");
    
    
    /**
     * Gets the "Keywords" element
     */
    public net.opengis.ows.x11.KeywordsType getKeywords()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.KeywordsType target = null;
            target = (net.opengis.ows.x11.KeywordsType)get_store().find_element_user(KEYWORDS$0, 0);
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
    public void setKeywords(net.opengis.ows.x11.KeywordsType keywords)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.KeywordsType target = null;
            target = (net.opengis.ows.x11.KeywordsType)get_store().find_element_user(KEYWORDS$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.KeywordsType)get_store().add_element_user(KEYWORDS$0);
            }
            target.set(keywords);
        }
    }
    
    /**
     * Appends and returns a new empty "Keywords" element
     */
    public net.opengis.ows.x11.KeywordsType addNewKeywords()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.KeywordsType target = null;
            target = (net.opengis.ows.x11.KeywordsType)get_store().add_element_user(KEYWORDS$0);
            return target;
        }
    }
}

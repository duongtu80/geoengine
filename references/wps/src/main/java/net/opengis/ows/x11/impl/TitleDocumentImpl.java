/*
 * An XML document type.
 * Localname: Title
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.TitleDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Title(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class TitleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.TitleDocument
{
    private static final long serialVersionUID = 1L;
    
    public TitleDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TITLE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Title");
    
    
    /**
     * Gets the "Title" element
     */
    public net.opengis.ows.x11.LanguageStringType getTitle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(TITLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Title" element
     */
    public void setTitle(net.opengis.ows.x11.LanguageStringType title)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(TITLE$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(TITLE$0);
            }
            target.set(title);
        }
    }
    
    /**
     * Appends and returns a new empty "Title" element
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
}

/*
 * An XML document type.
 * Localname: Abstract
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AbstractDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one Abstract(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class AbstractDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AbstractDocument
{
    private static final long serialVersionUID = 1L;
    
    public AbstractDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Abstract");
    
    
    /**
     * Gets the "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType getAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Abstract" element
     */
    public void setAbstract(net.opengis.ows.x11.LanguageStringType xabstract)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(ABSTRACT$0);
            }
            target.set(xabstract);
        }
    }
    
    /**
     * Appends and returns a new empty "Abstract" element
     */
    public net.opengis.ows.x11.LanguageStringType addNewAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(ABSTRACT$0);
            return target;
        }
    }
}

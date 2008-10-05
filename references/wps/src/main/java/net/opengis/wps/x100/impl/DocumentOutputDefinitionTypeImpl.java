/*
 * XML Type:  DocumentOutputDefinitionType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.DocumentOutputDefinitionType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML DocumentOutputDefinitionType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class DocumentOutputDefinitionTypeImpl extends net.opengis.wps.x100.impl.OutputDefinitionTypeImpl implements net.opengis.wps.x100.DocumentOutputDefinitionType
{
    private static final long serialVersionUID = 1L;
    
    public DocumentOutputDefinitionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TITLE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Title");
    private static final javax.xml.namespace.QName ABSTRACT$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Abstract");
    private static final javax.xml.namespace.QName ASREFERENCE$4 = 
        new javax.xml.namespace.QName("", "asReference");
    
    
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
    public net.opengis.ows.x11.LanguageStringType getAbstract()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$2, 0);
            if (target == null)
            {
                return null;
            }
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
    public void setAbstract(net.opengis.ows.x11.LanguageStringType xabstract)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.LanguageStringType target = null;
            target = (net.opengis.ows.x11.LanguageStringType)get_store().find_element_user(ABSTRACT$2, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(ABSTRACT$2);
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
            target = (net.opengis.ows.x11.LanguageStringType)get_store().add_element_user(ABSTRACT$2);
            return target;
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
     * Gets the "asReference" attribute
     */
    public boolean getAsReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ASREFERENCE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(ASREFERENCE$4);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "asReference" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetAsReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(ASREFERENCE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(ASREFERENCE$4);
            }
            return target;
        }
    }
    
    /**
     * True if has "asReference" attribute
     */
    public boolean isSetAsReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(ASREFERENCE$4) != null;
        }
    }
    
    /**
     * Sets the "asReference" attribute
     */
    public void setAsReference(boolean asReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ASREFERENCE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ASREFERENCE$4);
            }
            target.setBooleanValue(asReference);
        }
    }
    
    /**
     * Sets (as xml) the "asReference" attribute
     */
    public void xsetAsReference(org.apache.xmlbeans.XmlBoolean asReference)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(ASREFERENCE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(ASREFERENCE$4);
            }
            target.set(asReference);
        }
    }
    
    /**
     * Unsets the "asReference" attribute
     */
    public void unsetAsReference()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(ASREFERENCE$4);
        }
    }
}

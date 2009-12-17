/*
 * XML Type:  WPSCapabilitiesType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.WPSCapabilitiesType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML WPSCapabilitiesType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class WPSCapabilitiesTypeImpl extends net.opengis.ows.x11.impl.CapabilitiesBaseTypeImpl implements net.opengis.wps.x100.WPSCapabilitiesType
{
    private static final long serialVersionUID = 1L;
    
    public WPSCapabilitiesTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSOFFERINGS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "ProcessOfferings");
    private static final javax.xml.namespace.QName LANGUAGES$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "Languages");
    private static final javax.xml.namespace.QName WSDL$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/wps/1.0.0", "WSDL");
    private static final javax.xml.namespace.QName SERVICE$6 = 
        new javax.xml.namespace.QName("", "service");
    private static final javax.xml.namespace.QName LANG$8 = 
        new javax.xml.namespace.QName("http://www.w3.org/XML/1998/namespace", "lang");
    
    
    /**
     * Gets the "ProcessOfferings" element
     */
    public net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings getProcessOfferings()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings)get_store().find_element_user(PROCESSOFFERINGS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ProcessOfferings" element
     */
    public void setProcessOfferings(net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings processOfferings)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings)get_store().find_element_user(PROCESSOFFERINGS$0, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings)get_store().add_element_user(PROCESSOFFERINGS$0);
            }
            target.set(processOfferings);
        }
    }
    
    /**
     * Appends and returns a new empty "ProcessOfferings" element
     */
    public net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings addNewProcessOfferings()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings target = null;
            target = (net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings)get_store().add_element_user(PROCESSOFFERINGS$0);
            return target;
        }
    }
    
    /**
     * Gets the "Languages" element
     */
    public net.opengis.wps.x100.LanguagesDocument.Languages getLanguages()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LanguagesDocument.Languages target = null;
            target = (net.opengis.wps.x100.LanguagesDocument.Languages)get_store().find_element_user(LANGUAGES$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Languages" element
     */
    public void setLanguages(net.opengis.wps.x100.LanguagesDocument.Languages languages)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LanguagesDocument.Languages target = null;
            target = (net.opengis.wps.x100.LanguagesDocument.Languages)get_store().find_element_user(LANGUAGES$2, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.LanguagesDocument.Languages)get_store().add_element_user(LANGUAGES$2);
            }
            target.set(languages);
        }
    }
    
    /**
     * Appends and returns a new empty "Languages" element
     */
    public net.opengis.wps.x100.LanguagesDocument.Languages addNewLanguages()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.LanguagesDocument.Languages target = null;
            target = (net.opengis.wps.x100.LanguagesDocument.Languages)get_store().add_element_user(LANGUAGES$2);
            return target;
        }
    }
    
    /**
     * Gets the "WSDL" element
     */
    public net.opengis.wps.x100.WSDLDocument.WSDL getWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().find_element_user(WSDL$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "WSDL" element
     */
    public boolean isSetWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(WSDL$4) != 0;
        }
    }
    
    /**
     * Sets the "WSDL" element
     */
    public void setWSDL(net.opengis.wps.x100.WSDLDocument.WSDL wsdl)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().find_element_user(WSDL$4, 0);
            if (target == null)
            {
                target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().add_element_user(WSDL$4);
            }
            target.set(wsdl);
        }
    }
    
    /**
     * Appends and returns a new empty "WSDL" element
     */
    public net.opengis.wps.x100.WSDLDocument.WSDL addNewWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.wps.x100.WSDLDocument.WSDL target = null;
            target = (net.opengis.wps.x100.WSDLDocument.WSDL)get_store().add_element_user(WSDL$4);
            return target;
        }
    }
    
    /**
     * Unsets the "WSDL" element
     */
    public void unsetWSDL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(WSDL$4, 0);
        }
    }
    
    /**
     * Gets the "service" attribute
     */
    public org.apache.xmlbeans.XmlAnySimpleType getService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(SERVICE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnySimpleType)get_default_attribute_value(SERVICE$6);
            }
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "service" attribute
     */
    public void setService(org.apache.xmlbeans.XmlAnySimpleType service)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(SERVICE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(SERVICE$6);
            }
            target.set(service);
        }
    }
    
    /**
     * Appends and returns a new empty "service" attribute
     */
    public org.apache.xmlbeans.XmlAnySimpleType addNewService()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(SERVICE$6);
            return target;
        }
    }
    
    /**
     * Gets the "lang" attribute
     */
    public java.lang.String getLang()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANG$8);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "lang" attribute
     */
    public org.apache.xmlbeans.XmlLanguage xgetLang()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLanguage target = null;
            target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANG$8);
            return target;
        }
    }
    
    /**
     * Sets the "lang" attribute
     */
    public void setLang(java.lang.String lang)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANG$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LANG$8);
            }
            target.setStringValue(lang);
        }
    }
    
    /**
     * Sets (as xml) the "lang" attribute
     */
    public void xsetLang(org.apache.xmlbeans.XmlLanguage lang)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlLanguage target = null;
            target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANG$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlLanguage)get_store().add_attribute_user(LANG$8);
            }
            target.set(lang);
        }
    }
}

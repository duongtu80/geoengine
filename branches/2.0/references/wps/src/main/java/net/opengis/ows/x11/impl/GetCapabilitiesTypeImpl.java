/*
 * XML Type:  GetCapabilitiesType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.GetCapabilitiesType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML GetCapabilitiesType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class GetCapabilitiesTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.GetCapabilitiesType
{
    private static final long serialVersionUID = 1L;
    
    public GetCapabilitiesTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ACCEPTVERSIONS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AcceptVersions");
    private static final javax.xml.namespace.QName SECTIONS$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Sections");
    private static final javax.xml.namespace.QName ACCEPTFORMATS$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AcceptFormats");
    private static final javax.xml.namespace.QName UPDATESEQUENCE$6 = 
        new javax.xml.namespace.QName("", "updateSequence");
    
    
    /**
     * Gets the "AcceptVersions" element
     */
    public net.opengis.ows.x11.AcceptVersionsType getAcceptVersions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AcceptVersionsType target = null;
            target = (net.opengis.ows.x11.AcceptVersionsType)get_store().find_element_user(ACCEPTVERSIONS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AcceptVersions" element
     */
    public boolean isSetAcceptVersions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ACCEPTVERSIONS$0) != 0;
        }
    }
    
    /**
     * Sets the "AcceptVersions" element
     */
    public void setAcceptVersions(net.opengis.ows.x11.AcceptVersionsType acceptVersions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AcceptVersionsType target = null;
            target = (net.opengis.ows.x11.AcceptVersionsType)get_store().find_element_user(ACCEPTVERSIONS$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.AcceptVersionsType)get_store().add_element_user(ACCEPTVERSIONS$0);
            }
            target.set(acceptVersions);
        }
    }
    
    /**
     * Appends and returns a new empty "AcceptVersions" element
     */
    public net.opengis.ows.x11.AcceptVersionsType addNewAcceptVersions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AcceptVersionsType target = null;
            target = (net.opengis.ows.x11.AcceptVersionsType)get_store().add_element_user(ACCEPTVERSIONS$0);
            return target;
        }
    }
    
    /**
     * Unsets the "AcceptVersions" element
     */
    public void unsetAcceptVersions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ACCEPTVERSIONS$0, 0);
        }
    }
    
    /**
     * Gets the "Sections" element
     */
    public net.opengis.ows.x11.SectionsType getSections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.SectionsType target = null;
            target = (net.opengis.ows.x11.SectionsType)get_store().find_element_user(SECTIONS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Sections" element
     */
    public boolean isSetSections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SECTIONS$2) != 0;
        }
    }
    
    /**
     * Sets the "Sections" element
     */
    public void setSections(net.opengis.ows.x11.SectionsType sections)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.SectionsType target = null;
            target = (net.opengis.ows.x11.SectionsType)get_store().find_element_user(SECTIONS$2, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.SectionsType)get_store().add_element_user(SECTIONS$2);
            }
            target.set(sections);
        }
    }
    
    /**
     * Appends and returns a new empty "Sections" element
     */
    public net.opengis.ows.x11.SectionsType addNewSections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.SectionsType target = null;
            target = (net.opengis.ows.x11.SectionsType)get_store().add_element_user(SECTIONS$2);
            return target;
        }
    }
    
    /**
     * Unsets the "Sections" element
     */
    public void unsetSections()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SECTIONS$2, 0);
        }
    }
    
    /**
     * Gets the "AcceptFormats" element
     */
    public net.opengis.ows.x11.AcceptFormatsType getAcceptFormats()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AcceptFormatsType target = null;
            target = (net.opengis.ows.x11.AcceptFormatsType)get_store().find_element_user(ACCEPTFORMATS$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "AcceptFormats" element
     */
    public boolean isSetAcceptFormats()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ACCEPTFORMATS$4) != 0;
        }
    }
    
    /**
     * Sets the "AcceptFormats" element
     */
    public void setAcceptFormats(net.opengis.ows.x11.AcceptFormatsType acceptFormats)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AcceptFormatsType target = null;
            target = (net.opengis.ows.x11.AcceptFormatsType)get_store().find_element_user(ACCEPTFORMATS$4, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.AcceptFormatsType)get_store().add_element_user(ACCEPTFORMATS$4);
            }
            target.set(acceptFormats);
        }
    }
    
    /**
     * Appends and returns a new empty "AcceptFormats" element
     */
    public net.opengis.ows.x11.AcceptFormatsType addNewAcceptFormats()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AcceptFormatsType target = null;
            target = (net.opengis.ows.x11.AcceptFormatsType)get_store().add_element_user(ACCEPTFORMATS$4);
            return target;
        }
    }
    
    /**
     * Unsets the "AcceptFormats" element
     */
    public void unsetAcceptFormats()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ACCEPTFORMATS$4, 0);
        }
    }
    
    /**
     * Gets the "updateSequence" attribute
     */
    public java.lang.String getUpdateSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(UPDATESEQUENCE$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "updateSequence" attribute
     */
    public net.opengis.ows.x11.UpdateSequenceType xgetUpdateSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.UpdateSequenceType target = null;
            target = (net.opengis.ows.x11.UpdateSequenceType)get_store().find_attribute_user(UPDATESEQUENCE$6);
            return target;
        }
    }
    
    /**
     * True if has "updateSequence" attribute
     */
    public boolean isSetUpdateSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(UPDATESEQUENCE$6) != null;
        }
    }
    
    /**
     * Sets the "updateSequence" attribute
     */
    public void setUpdateSequence(java.lang.String updateSequence)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(UPDATESEQUENCE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(UPDATESEQUENCE$6);
            }
            target.setStringValue(updateSequence);
        }
    }
    
    /**
     * Sets (as xml) the "updateSequence" attribute
     */
    public void xsetUpdateSequence(net.opengis.ows.x11.UpdateSequenceType updateSequence)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.UpdateSequenceType target = null;
            target = (net.opengis.ows.x11.UpdateSequenceType)get_store().find_attribute_user(UPDATESEQUENCE$6);
            if (target == null)
            {
                target = (net.opengis.ows.x11.UpdateSequenceType)get_store().add_attribute_user(UPDATESEQUENCE$6);
            }
            target.set(updateSequence);
        }
    }
    
    /**
     * Unsets the "updateSequence" attribute
     */
    public void unsetUpdateSequence()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(UPDATESEQUENCE$6);
        }
    }
}

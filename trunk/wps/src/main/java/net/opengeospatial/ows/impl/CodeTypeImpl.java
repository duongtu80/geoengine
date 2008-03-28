/*
 * XML Type:  CodeType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.CodeType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML CodeType(@http://www.opengeospatial.net/ows).
 *
 * This is an atomic type that is a restriction of net.opengeospatial.ows.CodeType.
 */
public class CodeTypeImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements net.opengeospatial.ows.CodeType
{
    
    public CodeTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, true);
    }
    
    protected CodeTypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
    
    private static final javax.xml.namespace.QName CODESPACE$0 = 
        new javax.xml.namespace.QName("", "codeSpace");
    
    
    /**
     * Gets the "codeSpace" attribute
     */
    public java.lang.String getCodeSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODESPACE$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "codeSpace" attribute
     */
    public org.apache.xmlbeans.XmlAnyURI xgetCodeSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(CODESPACE$0);
            return target;
        }
    }
    
    /**
     * True if has "codeSpace" attribute
     */
    public boolean isSetCodeSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(CODESPACE$0) != null;
        }
    }
    
    /**
     * Sets the "codeSpace" attribute
     */
    public void setCodeSpace(java.lang.String codeSpace)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CODESPACE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CODESPACE$0);
            }
            target.setStringValue(codeSpace);
        }
    }
    
    /**
     * Sets (as xml) the "codeSpace" attribute
     */
    public void xsetCodeSpace(org.apache.xmlbeans.XmlAnyURI codeSpace)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnyURI target = null;
            target = (org.apache.xmlbeans.XmlAnyURI)get_store().find_attribute_user(CODESPACE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnyURI)get_store().add_attribute_user(CODESPACE$0);
            }
            target.set(codeSpace);
        }
    }
    
    /**
     * Unsets the "codeSpace" attribute
     */
    public void unsetCodeSpace()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(CODESPACE$0);
        }
    }
}

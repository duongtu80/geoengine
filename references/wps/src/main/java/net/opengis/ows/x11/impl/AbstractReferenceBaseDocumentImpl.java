/*
 * An XML document type.
 * Localname: AbstractReferenceBase
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AbstractReferenceBaseDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one AbstractReferenceBase(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class AbstractReferenceBaseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AbstractReferenceBaseDocument
{
    private static final long serialVersionUID = 1L;
    
    public AbstractReferenceBaseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ABSTRACTREFERENCEBASE$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AbstractReferenceBase");
    private static final org.apache.xmlbeans.QNameSet ABSTRACTREFERENCEBASE$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Reference"),
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ServiceReference"),
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AbstractReferenceBase"),
    });
    
    
    /**
     * Gets the "AbstractReferenceBase" element
     */
    public net.opengis.ows.x11.AbstractReferenceBaseType getAbstractReferenceBase()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AbstractReferenceBaseType target = null;
            target = (net.opengis.ows.x11.AbstractReferenceBaseType)get_store().find_element_user(ABSTRACTREFERENCEBASE$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AbstractReferenceBase" element
     */
    public void setAbstractReferenceBase(net.opengis.ows.x11.AbstractReferenceBaseType abstractReferenceBase)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AbstractReferenceBaseType target = null;
            target = (net.opengis.ows.x11.AbstractReferenceBaseType)get_store().find_element_user(ABSTRACTREFERENCEBASE$1, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.AbstractReferenceBaseType)get_store().add_element_user(ABSTRACTREFERENCEBASE$0);
            }
            target.set(abstractReferenceBase);
        }
    }
    
    /**
     * Appends and returns a new empty "AbstractReferenceBase" element
     */
    public net.opengis.ows.x11.AbstractReferenceBaseType addNewAbstractReferenceBase()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AbstractReferenceBaseType target = null;
            target = (net.opengis.ows.x11.AbstractReferenceBaseType)get_store().add_element_user(ABSTRACTREFERENCEBASE$0);
            return target;
        }
    }
}

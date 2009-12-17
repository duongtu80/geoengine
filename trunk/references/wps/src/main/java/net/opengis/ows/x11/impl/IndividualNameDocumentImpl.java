/*
 * An XML document type.
 * Localname: IndividualName
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.IndividualNameDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one IndividualName(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class IndividualNameDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.IndividualNameDocument
{
    private static final long serialVersionUID = 1L;
    
    public IndividualNameDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INDIVIDUALNAME$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "IndividualName");
    
    
    /**
     * Gets the "IndividualName" element
     */
    public java.lang.String getIndividualName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIVIDUALNAME$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IndividualName" element
     */
    public org.apache.xmlbeans.XmlString xgetIndividualName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIVIDUALNAME$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "IndividualName" element
     */
    public void setIndividualName(java.lang.String individualName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDIVIDUALNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDIVIDUALNAME$0);
            }
            target.setStringValue(individualName);
        }
    }
    
    /**
     * Sets (as xml) the "IndividualName" element
     */
    public void xsetIndividualName(org.apache.xmlbeans.XmlString individualName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDIVIDUALNAME$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDIVIDUALNAME$0);
            }
            target.set(individualName);
        }
    }
}

/*
 * XML Type:  ReferenceGroupType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ReferenceGroupType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML ReferenceGroupType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class ReferenceGroupTypeImpl extends net.opengis.ows.x11.impl.BasicIdentificationTypeImpl implements net.opengis.ows.x11.ReferenceGroupType
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceGroupTypeImpl(org.apache.xmlbeans.SchemaType sType)
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
     * Gets array of all "AbstractReferenceBase" elements
     */
    public net.opengis.ows.x11.AbstractReferenceBaseType[] getAbstractReferenceBaseArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ABSTRACTREFERENCEBASE$1, targetList);
            net.opengis.ows.x11.AbstractReferenceBaseType[] result = new net.opengis.ows.x11.AbstractReferenceBaseType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "AbstractReferenceBase" element
     */
    public net.opengis.ows.x11.AbstractReferenceBaseType getAbstractReferenceBaseArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AbstractReferenceBaseType target = null;
            target = (net.opengis.ows.x11.AbstractReferenceBaseType)get_store().find_element_user(ABSTRACTREFERENCEBASE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "AbstractReferenceBase" element
     */
    public int sizeOfAbstractReferenceBaseArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ABSTRACTREFERENCEBASE$1);
        }
    }
    
    /**
     * Sets array of all "AbstractReferenceBase" element
     */
    public void setAbstractReferenceBaseArray(net.opengis.ows.x11.AbstractReferenceBaseType[] abstractReferenceBaseArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(abstractReferenceBaseArray, ABSTRACTREFERENCEBASE$0, ABSTRACTREFERENCEBASE$1);
        }
    }
    
    /**
     * Sets ith "AbstractReferenceBase" element
     */
    public void setAbstractReferenceBaseArray(int i, net.opengis.ows.x11.AbstractReferenceBaseType abstractReferenceBase)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AbstractReferenceBaseType target = null;
            target = (net.opengis.ows.x11.AbstractReferenceBaseType)get_store().find_element_user(ABSTRACTREFERENCEBASE$1, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(abstractReferenceBase);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "AbstractReferenceBase" element
     */
    public net.opengis.ows.x11.AbstractReferenceBaseType insertNewAbstractReferenceBase(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.AbstractReferenceBaseType target = null;
            target = (net.opengis.ows.x11.AbstractReferenceBaseType)get_store().insert_element_user(ABSTRACTREFERENCEBASE$1, ABSTRACTREFERENCEBASE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "AbstractReferenceBase" element
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
    
    /**
     * Removes the ith "AbstractReferenceBase" element
     */
    public void removeAbstractReferenceBase(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ABSTRACTREFERENCEBASE$1, i);
        }
    }
}

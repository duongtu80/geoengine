/*
 * XML Type:  ManifestType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.ManifestType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML ManifestType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class ManifestTypeImpl extends net.opengis.ows.x11.impl.BasicIdentificationTypeImpl implements net.opengis.ows.x11.ManifestType
{
    private static final long serialVersionUID = 1L;
    
    public ManifestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCEGROUP$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ReferenceGroup");
    
    
    /**
     * Gets array of all "ReferenceGroup" elements
     */
    public net.opengis.ows.x11.ReferenceGroupType[] getReferenceGroupArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(REFERENCEGROUP$0, targetList);
            net.opengis.ows.x11.ReferenceGroupType[] result = new net.opengis.ows.x11.ReferenceGroupType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "ReferenceGroup" element
     */
    public net.opengis.ows.x11.ReferenceGroupType getReferenceGroupArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceGroupType target = null;
            target = (net.opengis.ows.x11.ReferenceGroupType)get_store().find_element_user(REFERENCEGROUP$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "ReferenceGroup" element
     */
    public int sizeOfReferenceGroupArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(REFERENCEGROUP$0);
        }
    }
    
    /**
     * Sets array of all "ReferenceGroup" element
     */
    public void setReferenceGroupArray(net.opengis.ows.x11.ReferenceGroupType[] referenceGroupArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(referenceGroupArray, REFERENCEGROUP$0);
        }
    }
    
    /**
     * Sets ith "ReferenceGroup" element
     */
    public void setReferenceGroupArray(int i, net.opengis.ows.x11.ReferenceGroupType referenceGroup)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceGroupType target = null;
            target = (net.opengis.ows.x11.ReferenceGroupType)get_store().find_element_user(REFERENCEGROUP$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(referenceGroup);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ReferenceGroup" element
     */
    public net.opengis.ows.x11.ReferenceGroupType insertNewReferenceGroup(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceGroupType target = null;
            target = (net.opengis.ows.x11.ReferenceGroupType)get_store().insert_element_user(REFERENCEGROUP$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ReferenceGroup" element
     */
    public net.opengis.ows.x11.ReferenceGroupType addNewReferenceGroup()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.ReferenceGroupType target = null;
            target = (net.opengis.ows.x11.ReferenceGroupType)get_store().add_element_user(REFERENCEGROUP$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "ReferenceGroup" element
     */
    public void removeReferenceGroup(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(REFERENCEGROUP$0, i);
        }
    }
}

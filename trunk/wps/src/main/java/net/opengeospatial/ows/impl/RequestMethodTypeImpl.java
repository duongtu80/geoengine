/*
 * XML Type:  RequestMethodType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.RequestMethodType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML RequestMethodType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class RequestMethodTypeImpl extends net.opengeospatial.ows.impl.OnlineResourceTypeImpl implements net.opengeospatial.ows.RequestMethodType
{
    
    public RequestMethodTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONSTRAINT$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Constraint");
    
    
    /**
     * Gets array of all "Constraint" elements
     */
    public net.opengeospatial.ows.DomainType[] getConstraintArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CONSTRAINT$0, targetList);
            net.opengeospatial.ows.DomainType[] result = new net.opengeospatial.ows.DomainType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Constraint" element
     */
    public net.opengeospatial.ows.DomainType getConstraintArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainType target = null;
            target = (net.opengeospatial.ows.DomainType)get_store().find_element_user(CONSTRAINT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Constraint" element
     */
    public int sizeOfConstraintArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONSTRAINT$0);
        }
    }
    
    /**
     * Sets array of all "Constraint" element
     */
    public void setConstraintArray(net.opengeospatial.ows.DomainType[] constraintArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(constraintArray, CONSTRAINT$0);
        }
    }
    
    /**
     * Sets ith "Constraint" element
     */
    public void setConstraintArray(int i, net.opengeospatial.ows.DomainType constraint)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainType target = null;
            target = (net.opengeospatial.ows.DomainType)get_store().find_element_user(CONSTRAINT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(constraint);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Constraint" element
     */
    public net.opengeospatial.ows.DomainType insertNewConstraint(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainType target = null;
            target = (net.opengeospatial.ows.DomainType)get_store().insert_element_user(CONSTRAINT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Constraint" element
     */
    public net.opengeospatial.ows.DomainType addNewConstraint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengeospatial.ows.DomainType target = null;
            target = (net.opengeospatial.ows.DomainType)get_store().add_element_user(CONSTRAINT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Constraint" element
     */
    public void removeConstraint(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONSTRAINT$0, i);
        }
    }
}

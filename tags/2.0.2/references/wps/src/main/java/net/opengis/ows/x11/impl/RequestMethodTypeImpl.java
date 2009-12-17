/*
 * XML Type:  RequestMethodType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.RequestMethodType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML RequestMethodType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class RequestMethodTypeImpl extends net.opengis.ows.x11.impl.OnlineResourceTypeImpl implements net.opengis.ows.x11.RequestMethodType
{
    private static final long serialVersionUID = 1L;
    
    public RequestMethodTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONSTRAINT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Constraint");
    
    
    /**
     * Gets array of all "Constraint" elements
     */
    public net.opengis.ows.x11.DomainType[] getConstraintArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CONSTRAINT$0, targetList);
            net.opengis.ows.x11.DomainType[] result = new net.opengis.ows.x11.DomainType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Constraint" element
     */
    public net.opengis.ows.x11.DomainType getConstraintArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainType target = null;
            target = (net.opengis.ows.x11.DomainType)get_store().find_element_user(CONSTRAINT$0, i);
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
    public void setConstraintArray(net.opengis.ows.x11.DomainType[] constraintArray)
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
    public void setConstraintArray(int i, net.opengis.ows.x11.DomainType constraint)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainType target = null;
            target = (net.opengis.ows.x11.DomainType)get_store().find_element_user(CONSTRAINT$0, i);
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
    public net.opengis.ows.x11.DomainType insertNewConstraint(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainType target = null;
            target = (net.opengis.ows.x11.DomainType)get_store().insert_element_user(CONSTRAINT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Constraint" element
     */
    public net.opengis.ows.x11.DomainType addNewConstraint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainType target = null;
            target = (net.opengis.ows.x11.DomainType)get_store().add_element_user(CONSTRAINT$0);
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

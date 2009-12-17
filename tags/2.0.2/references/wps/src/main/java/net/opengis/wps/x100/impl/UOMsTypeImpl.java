/*
 * XML Type:  UOMsType
 * Namespace: http://www.opengis.net/wps/1.0.0
 * Java type: net.opengis.wps.x100.UOMsType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.wps.x100.impl;
/**
 * An XML UOMsType(@http://www.opengis.net/wps/1.0.0).
 *
 * This is a complex type.
 */
public class UOMsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.wps.x100.UOMsType
{
    private static final long serialVersionUID = 1L;
    
    public UOMsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOM$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "UOM");
    
    
    /**
     * Gets array of all "UOM" elements
     */
    public net.opengis.ows.x11.DomainMetadataType[] getUOMArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(UOM$0, targetList);
            net.opengis.ows.x11.DomainMetadataType[] result = new net.opengis.ows.x11.DomainMetadataType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "UOM" element
     */
    public net.opengis.ows.x11.DomainMetadataType getUOMArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(UOM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "UOM" element
     */
    public int sizeOfUOMArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(UOM$0);
        }
    }
    
    /**
     * Sets array of all "UOM" element
     */
    public void setUOMArray(net.opengis.ows.x11.DomainMetadataType[] uomArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(uomArray, UOM$0);
        }
    }
    
    /**
     * Sets ith "UOM" element
     */
    public void setUOMArray(int i, net.opengis.ows.x11.DomainMetadataType uom)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().find_element_user(UOM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(uom);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "UOM" element
     */
    public net.opengis.ows.x11.DomainMetadataType insertNewUOM(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().insert_element_user(UOM$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "UOM" element
     */
    public net.opengis.ows.x11.DomainMetadataType addNewUOM()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DomainMetadataType target = null;
            target = (net.opengis.ows.x11.DomainMetadataType)get_store().add_element_user(UOM$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "UOM" element
     */
    public void removeUOM(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(UOM$0, i);
        }
    }
}

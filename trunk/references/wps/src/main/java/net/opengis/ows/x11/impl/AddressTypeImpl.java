/*
 * XML Type:  AddressType
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.AddressType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * An XML AddressType(@http://www.opengis.net/ows/1.1).
 *
 * This is a complex type.
 */
public class AddressTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.AddressType
{
    private static final long serialVersionUID = 1L;
    
    public AddressTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DELIVERYPOINT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DeliveryPoint");
    private static final javax.xml.namespace.QName CITY$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "City");
    private static final javax.xml.namespace.QName ADMINISTRATIVEAREA$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "AdministrativeArea");
    private static final javax.xml.namespace.QName POSTALCODE$6 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "PostalCode");
    private static final javax.xml.namespace.QName COUNTRY$8 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "Country");
    private static final javax.xml.namespace.QName ELECTRONICMAILADDRESS$10 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "ElectronicMailAddress");
    
    
    /**
     * Gets array of all "DeliveryPoint" elements
     */
    public java.lang.String[] getDeliveryPointArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DELIVERYPOINT$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "DeliveryPoint" element
     */
    public java.lang.String getDeliveryPointArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DELIVERYPOINT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "DeliveryPoint" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetDeliveryPointArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(DELIVERYPOINT$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "DeliveryPoint" element
     */
    public org.apache.xmlbeans.XmlString xgetDeliveryPointArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DELIVERYPOINT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "DeliveryPoint" element
     */
    public int sizeOfDeliveryPointArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DELIVERYPOINT$0);
        }
    }
    
    /**
     * Sets array of all "DeliveryPoint" element
     */
    public void setDeliveryPointArray(java.lang.String[] deliveryPointArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(deliveryPointArray, DELIVERYPOINT$0);
        }
    }
    
    /**
     * Sets ith "DeliveryPoint" element
     */
    public void setDeliveryPointArray(int i, java.lang.String deliveryPoint)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DELIVERYPOINT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(deliveryPoint);
        }
    }
    
    /**
     * Sets (as xml) array of all "DeliveryPoint" element
     */
    public void xsetDeliveryPointArray(org.apache.xmlbeans.XmlString[]deliveryPointArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(deliveryPointArray, DELIVERYPOINT$0);
        }
    }
    
    /**
     * Sets (as xml) ith "DeliveryPoint" element
     */
    public void xsetDeliveryPointArray(int i, org.apache.xmlbeans.XmlString deliveryPoint)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DELIVERYPOINT$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(deliveryPoint);
        }
    }
    
    /**
     * Inserts the value as the ith "DeliveryPoint" element
     */
    public void insertDeliveryPoint(int i, java.lang.String deliveryPoint)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(DELIVERYPOINT$0, i);
            target.setStringValue(deliveryPoint);
        }
    }
    
    /**
     * Appends the value as the last "DeliveryPoint" element
     */
    public void addDeliveryPoint(java.lang.String deliveryPoint)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DELIVERYPOINT$0);
            target.setStringValue(deliveryPoint);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "DeliveryPoint" element
     */
    public org.apache.xmlbeans.XmlString insertNewDeliveryPoint(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(DELIVERYPOINT$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "DeliveryPoint" element
     */
    public org.apache.xmlbeans.XmlString addNewDeliveryPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DELIVERYPOINT$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "DeliveryPoint" element
     */
    public void removeDeliveryPoint(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DELIVERYPOINT$0, i);
        }
    }
    
    /**
     * Gets the "City" element
     */
    public java.lang.String getCity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CITY$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "City" element
     */
    public org.apache.xmlbeans.XmlString xgetCity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "City" element
     */
    public boolean isSetCity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CITY$2) != 0;
        }
    }
    
    /**
     * Sets the "City" element
     */
    public void setCity(java.lang.String city)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CITY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CITY$2);
            }
            target.setStringValue(city);
        }
    }
    
    /**
     * Sets (as xml) the "City" element
     */
    public void xsetCity(org.apache.xmlbeans.XmlString city)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CITY$2);
            }
            target.set(city);
        }
    }
    
    /**
     * Unsets the "City" element
     */
    public void unsetCity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CITY$2, 0);
        }
    }
    
    /**
     * Gets the "AdministrativeArea" element
     */
    public java.lang.String getAdministrativeArea()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADMINISTRATIVEAREA$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AdministrativeArea" element
     */
    public org.apache.xmlbeans.XmlString xgetAdministrativeArea()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADMINISTRATIVEAREA$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "AdministrativeArea" element
     */
    public boolean isSetAdministrativeArea()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ADMINISTRATIVEAREA$4) != 0;
        }
    }
    
    /**
     * Sets the "AdministrativeArea" element
     */
    public void setAdministrativeArea(java.lang.String administrativeArea)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADMINISTRATIVEAREA$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADMINISTRATIVEAREA$4);
            }
            target.setStringValue(administrativeArea);
        }
    }
    
    /**
     * Sets (as xml) the "AdministrativeArea" element
     */
    public void xsetAdministrativeArea(org.apache.xmlbeans.XmlString administrativeArea)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADMINISTRATIVEAREA$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADMINISTRATIVEAREA$4);
            }
            target.set(administrativeArea);
        }
    }
    
    /**
     * Unsets the "AdministrativeArea" element
     */
    public void unsetAdministrativeArea()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ADMINISTRATIVEAREA$4, 0);
        }
    }
    
    /**
     * Gets the "PostalCode" element
     */
    public java.lang.String getPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PostalCode" element
     */
    public org.apache.xmlbeans.XmlString xgetPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALCODE$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "PostalCode" element
     */
    public boolean isSetPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(POSTALCODE$6) != 0;
        }
    }
    
    /**
     * Sets the "PostalCode" element
     */
    public void setPostalCode(java.lang.String postalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POSTALCODE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POSTALCODE$6);
            }
            target.setStringValue(postalCode);
        }
    }
    
    /**
     * Sets (as xml) the "PostalCode" element
     */
    public void xsetPostalCode(org.apache.xmlbeans.XmlString postalCode)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(POSTALCODE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(POSTALCODE$6);
            }
            target.set(postalCode);
        }
    }
    
    /**
     * Unsets the "PostalCode" element
     */
    public void unsetPostalCode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(POSTALCODE$6, 0);
        }
    }
    
    /**
     * Gets the "Country" element
     */
    public java.lang.String getCountry()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COUNTRY$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Country" element
     */
    public org.apache.xmlbeans.XmlString xgetCountry()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COUNTRY$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "Country" element
     */
    public boolean isSetCountry()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(COUNTRY$8) != 0;
        }
    }
    
    /**
     * Sets the "Country" element
     */
    public void setCountry(java.lang.String country)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COUNTRY$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COUNTRY$8);
            }
            target.setStringValue(country);
        }
    }
    
    /**
     * Sets (as xml) the "Country" element
     */
    public void xsetCountry(org.apache.xmlbeans.XmlString country)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COUNTRY$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COUNTRY$8);
            }
            target.set(country);
        }
    }
    
    /**
     * Unsets the "Country" element
     */
    public void unsetCountry()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(COUNTRY$8, 0);
        }
    }
    
    /**
     * Gets array of all "ElectronicMailAddress" elements
     */
    public java.lang.String[] getElectronicMailAddressArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ELECTRONICMAILADDRESS$10, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "ElectronicMailAddress" element
     */
    public java.lang.String getElectronicMailAddressArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ELECTRONICMAILADDRESS$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "ElectronicMailAddress" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetElectronicMailAddressArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ELECTRONICMAILADDRESS$10, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "ElectronicMailAddress" element
     */
    public org.apache.xmlbeans.XmlString xgetElectronicMailAddressArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ELECTRONICMAILADDRESS$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "ElectronicMailAddress" element
     */
    public int sizeOfElectronicMailAddressArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ELECTRONICMAILADDRESS$10);
        }
    }
    
    /**
     * Sets array of all "ElectronicMailAddress" element
     */
    public void setElectronicMailAddressArray(java.lang.String[] electronicMailAddressArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(electronicMailAddressArray, ELECTRONICMAILADDRESS$10);
        }
    }
    
    /**
     * Sets ith "ElectronicMailAddress" element
     */
    public void setElectronicMailAddressArray(int i, java.lang.String electronicMailAddress)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ELECTRONICMAILADDRESS$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(electronicMailAddress);
        }
    }
    
    /**
     * Sets (as xml) array of all "ElectronicMailAddress" element
     */
    public void xsetElectronicMailAddressArray(org.apache.xmlbeans.XmlString[]electronicMailAddressArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(electronicMailAddressArray, ELECTRONICMAILADDRESS$10);
        }
    }
    
    /**
     * Sets (as xml) ith "ElectronicMailAddress" element
     */
    public void xsetElectronicMailAddressArray(int i, org.apache.xmlbeans.XmlString electronicMailAddress)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ELECTRONICMAILADDRESS$10, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(electronicMailAddress);
        }
    }
    
    /**
     * Inserts the value as the ith "ElectronicMailAddress" element
     */
    public void insertElectronicMailAddress(int i, java.lang.String electronicMailAddress)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(ELECTRONICMAILADDRESS$10, i);
            target.setStringValue(electronicMailAddress);
        }
    }
    
    /**
     * Appends the value as the last "ElectronicMailAddress" element
     */
    public void addElectronicMailAddress(java.lang.String electronicMailAddress)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ELECTRONICMAILADDRESS$10);
            target.setStringValue(electronicMailAddress);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ElectronicMailAddress" element
     */
    public org.apache.xmlbeans.XmlString insertNewElectronicMailAddress(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(ELECTRONICMAILADDRESS$10, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ElectronicMailAddress" element
     */
    public org.apache.xmlbeans.XmlString addNewElectronicMailAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ELECTRONICMAILADDRESS$10);
            return target;
        }
    }
    
    /**
     * Removes the ith "ElectronicMailAddress" element
     */
    public void removeElectronicMailAddress(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ELECTRONICMAILADDRESS$10, i);
        }
    }
}

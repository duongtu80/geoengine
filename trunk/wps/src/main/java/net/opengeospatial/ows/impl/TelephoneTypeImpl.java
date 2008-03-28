/*
 * XML Type:  TelephoneType
 * Namespace: http://www.opengeospatial.net/ows
 * Java type: net.opengeospatial.ows.TelephoneType
 *
 * Automatically generated - do not modify.
 */
package net.opengeospatial.ows.impl;
/**
 * An XML TelephoneType(@http://www.opengeospatial.net/ows).
 *
 * This is a complex type.
 */
public class TelephoneTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengeospatial.ows.TelephoneType
{
    
    public TelephoneTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VOICE$0 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Voice");
    private static final javax.xml.namespace.QName FACSIMILE$2 = 
        new javax.xml.namespace.QName("http://www.opengeospatial.net/ows", "Facsimile");
    
    
    /**
     * Gets array of all "Voice" elements
     */
    public java.lang.String[] getVoiceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VOICE$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "Voice" element
     */
    public java.lang.String getVoiceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VOICE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "Voice" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetVoiceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VOICE$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "Voice" element
     */
    public org.apache.xmlbeans.XmlString xgetVoiceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VOICE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "Voice" element
     */
    public int sizeOfVoiceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VOICE$0);
        }
    }
    
    /**
     * Sets array of all "Voice" element
     */
    public void setVoiceArray(java.lang.String[] voiceArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(voiceArray, VOICE$0);
        }
    }
    
    /**
     * Sets ith "Voice" element
     */
    public void setVoiceArray(int i, java.lang.String voice)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VOICE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(voice);
        }
    }
    
    /**
     * Sets (as xml) array of all "Voice" element
     */
    public void xsetVoiceArray(org.apache.xmlbeans.XmlString[]voiceArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(voiceArray, VOICE$0);
        }
    }
    
    /**
     * Sets (as xml) ith "Voice" element
     */
    public void xsetVoiceArray(int i, org.apache.xmlbeans.XmlString voice)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VOICE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(voice);
        }
    }
    
    /**
     * Inserts the value as the ith "Voice" element
     */
    public void insertVoice(int i, java.lang.String voice)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(VOICE$0, i);
            target.setStringValue(voice);
        }
    }
    
    /**
     * Appends the value as the last "Voice" element
     */
    public void addVoice(java.lang.String voice)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VOICE$0);
            target.setStringValue(voice);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Voice" element
     */
    public org.apache.xmlbeans.XmlString insertNewVoice(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(VOICE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Voice" element
     */
    public org.apache.xmlbeans.XmlString addNewVoice()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VOICE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Voice" element
     */
    public void removeVoice(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VOICE$0, i);
        }
    }
    
    /**
     * Gets array of all "Facsimile" elements
     */
    public java.lang.String[] getFacsimileArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(FACSIMILE$2, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "Facsimile" element
     */
    public java.lang.String getFacsimileArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACSIMILE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "Facsimile" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetFacsimileArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(FACSIMILE$2, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "Facsimile" element
     */
    public org.apache.xmlbeans.XmlString xgetFacsimileArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FACSIMILE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "Facsimile" element
     */
    public int sizeOfFacsimileArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FACSIMILE$2);
        }
    }
    
    /**
     * Sets array of all "Facsimile" element
     */
    public void setFacsimileArray(java.lang.String[] facsimileArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(facsimileArray, FACSIMILE$2);
        }
    }
    
    /**
     * Sets ith "Facsimile" element
     */
    public void setFacsimileArray(int i, java.lang.String facsimile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FACSIMILE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(facsimile);
        }
    }
    
    /**
     * Sets (as xml) array of all "Facsimile" element
     */
    public void xsetFacsimileArray(org.apache.xmlbeans.XmlString[]facsimileArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(facsimileArray, FACSIMILE$2);
        }
    }
    
    /**
     * Sets (as xml) ith "Facsimile" element
     */
    public void xsetFacsimileArray(int i, org.apache.xmlbeans.XmlString facsimile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FACSIMILE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(facsimile);
        }
    }
    
    /**
     * Inserts the value as the ith "Facsimile" element
     */
    public void insertFacsimile(int i, java.lang.String facsimile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(FACSIMILE$2, i);
            target.setStringValue(facsimile);
        }
    }
    
    /**
     * Appends the value as the last "Facsimile" element
     */
    public void addFacsimile(java.lang.String facsimile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FACSIMILE$2);
            target.setStringValue(facsimile);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Facsimile" element
     */
    public org.apache.xmlbeans.XmlString insertNewFacsimile(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(FACSIMILE$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Facsimile" element
     */
    public org.apache.xmlbeans.XmlString addNewFacsimile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FACSIMILE$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "Facsimile" element
     */
    public void removeFacsimile(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FACSIMILE$2, i);
        }
    }
}

/*
 * An XML document type.
 * Localname: model
 * Namespace: http://www.geodata.cn/models/geoprocessing
 * Java type: cn.geodata.models.geoprocessing.ModelDocument
 *
 * Automatically generated - do not modify.
 */
package cn.geodata.models.geoprocessing.impl;
/**
 * A document containing one model(@http://www.geodata.cn/models/geoprocessing) element.
 *
 * This is a complex type.
 */
public class ModelDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cn.geodata.models.geoprocessing.ModelDocument
{
    
    public ModelDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MODEL$0 = 
        new javax.xml.namespace.QName("http://www.geodata.cn/models/geoprocessing", "model");
    
    
    /**
     * Gets the "model" element
     */
    public cn.geodata.models.geoprocessing.ModelType getModel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ModelType target = null;
            target = (cn.geodata.models.geoprocessing.ModelType)get_store().find_element_user(MODEL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "model" element
     */
    public void setModel(cn.geodata.models.geoprocessing.ModelType model)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ModelType target = null;
            target = (cn.geodata.models.geoprocessing.ModelType)get_store().find_element_user(MODEL$0, 0);
            if (target == null)
            {
                target = (cn.geodata.models.geoprocessing.ModelType)get_store().add_element_user(MODEL$0);
            }
            target.set(model);
        }
    }
    
    /**
     * Appends and returns a new empty "model" element
     */
    public cn.geodata.models.geoprocessing.ModelType addNewModel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cn.geodata.models.geoprocessing.ModelType target = null;
            target = (cn.geodata.models.geoprocessing.ModelType)get_store().add_element_user(MODEL$0);
            return target;
        }
    }
}

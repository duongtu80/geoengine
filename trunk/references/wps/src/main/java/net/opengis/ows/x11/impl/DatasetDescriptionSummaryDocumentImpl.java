/*
 * An XML document type.
 * Localname: DatasetDescriptionSummary
 * Namespace: http://www.opengis.net/ows/1.1
 * Java type: net.opengis.ows.x11.DatasetDescriptionSummaryDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.ows.x11.impl;
/**
 * A document containing one DatasetDescriptionSummary(@http://www.opengis.net/ows/1.1) element.
 *
 * This is a complex type.
 */
public class DatasetDescriptionSummaryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.ows.x11.DatasetDescriptionSummaryDocument
{
    private static final long serialVersionUID = 1L;
    
    public DatasetDescriptionSummaryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DATASETDESCRIPTIONSUMMARY$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/ows/1.1", "DatasetDescriptionSummary");
    
    
    /**
     * Gets the "DatasetDescriptionSummary" element
     */
    public net.opengis.ows.x11.DatasetDescriptionSummaryBaseType getDatasetDescriptionSummary()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DatasetDescriptionSummaryBaseType target = null;
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().find_element_user(DATASETDESCRIPTIONSUMMARY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "DatasetDescriptionSummary" element
     */
    public void setDatasetDescriptionSummary(net.opengis.ows.x11.DatasetDescriptionSummaryBaseType datasetDescriptionSummary)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DatasetDescriptionSummaryBaseType target = null;
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().find_element_user(DATASETDESCRIPTIONSUMMARY$0, 0);
            if (target == null)
            {
                target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().add_element_user(DATASETDESCRIPTIONSUMMARY$0);
            }
            target.set(datasetDescriptionSummary);
        }
    }
    
    /**
     * Appends and returns a new empty "DatasetDescriptionSummary" element
     */
    public net.opengis.ows.x11.DatasetDescriptionSummaryBaseType addNewDatasetDescriptionSummary()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.ows.x11.DatasetDescriptionSummaryBaseType target = null;
            target = (net.opengis.ows.x11.DatasetDescriptionSummaryBaseType)get_store().add_element_user(DATASETDESCRIPTIONSUMMARY$0);
            return target;
        }
    }
}

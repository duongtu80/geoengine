package cn.geodata.models.status;

import net.opengeospatial.wps.StatusType;
import net.opengeospatial.wps.impl.StatusTypeImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.models.GeoNamespaceContext;

/**
 * Process status
 * @author Fengm
 *
 */
public abstract class Status {
	public abstract String getTitle();
	protected abstract Element createProcessStatusNode(Document doc);

	public Element encode(Document doc){
		Element _status = doc.createElementNS(GeoNamespaceContext.URI_WPS, "Status");
		_status.appendChild(this.createProcessStatusNode(doc));
		
		return _status;
	}
	
	public void encode(StatusType type){
		
	}
}

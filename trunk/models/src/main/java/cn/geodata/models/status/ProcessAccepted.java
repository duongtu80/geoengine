package cn.geodata.models.status;

import net.opengeospatial.wps.StatusType;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.models.GeoNamespaceContext;

/**
 * Process was accepted, but still not finished
 * @author Fengm
 *
 */
public class ProcessAccepted extends Status {

	@Override
	protected Element createProcessStatusNode(Document doc) {
		Element _element = (Element) doc.createElementNS(GeoNamespaceContext.URI_WPS, this.getTitle());
		return _element;
	}

	@Override
	public String getTitle() {
		return "ProcessAccepted";
	}

	@Override
	public void encode(StatusType type) {
		super.encode(type);
		type.setProcessAccepted("ProcessAccepted");
	}
}

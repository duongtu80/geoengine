package cn.geodata.models.status;

import net.opengeospatial.wps.StatusType;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.models.GeoNamespaceContext;

/**
 * Process finished successfully
 * @author Fengm
 *
 */
public class ProcessSucceeded extends Status {
	@Override
	protected Element createProcessStatusNode(Document doc) {
		Element _element = (Element) doc.createElementNS(GeoNamespaceContext.URI_WPS, this.getTitle());
		return _element;
	}

	@Override
	public String getTitle() {
		return "ProcessSucceeded";
	}

	@Override
	public void encode(StatusType type) {
		super.encode(type);
		type.setProcessSucceeded("ProcessSucceeded");
	}
}

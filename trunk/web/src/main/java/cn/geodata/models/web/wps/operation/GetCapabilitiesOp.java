package cn.geodata.models.web.wps.operation;

import java.util.logging.Logger;

import net.opengeospatial.wps.CapabilitiesDocument;
import net.opengeospatial.wps.ProcessBriefType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.CapabilitiesDocument.Capabilities;
import net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.model.util.ProcessingLibray;

public class GetCapabilitiesOp extends WpsOperation {
	private static Logger log = Logger.getAnonymousLogger();

	@Override
	public XmlObject execute(XmlObject input) throws Exception {
		CapabilitiesDocument _doc = CapabilitiesDocument.Factory.newInstance();
		Capabilities _capabilities = _doc.addNewCapabilities();

		ProcessOfferings _processOfferings = _capabilities.addNewProcessOfferings();
		
		ProcessingLibray _lib = ProcessingLibray.createInstance();
		for(String _title : _lib.getModelFactories().keySet()){
			log.info("Add processing:" + _title);
			
			ProcessBriefType _processBrief = _processOfferings.addNewProcess();
			ProcessDescriptionType _metadata = _lib.getModelFactories().get(_title).getMetadata();

			_processBrief.setIdentifier(_metadata.getIdentifier());
			_processBrief.setTitle(_metadata.getTitle());
			_processBrief.setAbstract(_metadata.getAbstract());
			_processBrief.setMetadataArray(_metadata.getMetadataArray());
		}
		
		return _doc;
	}

	@Override
	public String getOperationName() {
		return "GetCapabilities";
	}
}

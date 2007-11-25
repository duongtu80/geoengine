package cn.geodata.models.web.wps.actions;

import java.io.InputStream;
import java.util.logging.Logger;

import net.opengeospatial.wps.CapabilitiesDocument;
import net.opengeospatial.wps.ProcessBriefType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.CapabilitiesDocument.Capabilities;
import net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings;
import cn.geodata.model.util.ProcessingLibray;

public class GetCapabilities {
	private static Logger log = Logger.getAnonymousLogger();
	
	private InputStream result;
	
	public InputStream getResult() {
		return this.result;
	}
	
	public String execute() throws Exception {
		log.info("executing...");
		
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
		
		this.result = _doc.newInputStream();
		
		return "success";
	}
}

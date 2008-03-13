package cn.geodata.models.web.wps.actions;

import java.io.InputStream;
import java.util.logging.Logger;

import net.opengeospatial.wps.CapabilitiesDocument;
import net.opengeospatial.wps.ProcessBriefType;
import net.opengeospatial.wps.CapabilitiesDocument.Capabilities;
import net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings;
import cn.geodata.models.geoprocessing.ModelType;
import cn.geodata.models.geoprocessing.ProcessType;
import cn.geodata.models.util.ProcessingLibray;

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
			
			ModelType _model = _lib.getModelFactories().get(_title).getMetadata();
			for(ProcessType _proc : _model.getProcessArray()){
				ProcessBriefType _processBrief = _processOfferings.addNewProcess();
				_processBrief.addNewIdentifier().setStringValue(_model.getId() + "." + _proc.getId());
				
				_processBrief.setTitle(_proc.getTitle());
				_processBrief.setAbstract(_proc.getDescribe());
//				_processBrief.setMetadataArray(_proc.getMetadataArray());
			}
		}
		
		this.result = _doc.newInputStream();
		
		return "success";
	}
}

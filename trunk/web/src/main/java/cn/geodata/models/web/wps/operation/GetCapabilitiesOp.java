package cn.geodata.models.web.wps.operation;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

import net.opengeospatial.ows.CodeType;
import net.opengeospatial.ows.KeywordsType;
import net.opengeospatial.ows.OnlineResourceType;
import net.opengeospatial.ows.ServiceType;
import net.opengeospatial.ows.DCPDocument.DCP;
import net.opengeospatial.ows.OperationDocument.Operation;
import net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata;
import net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification;
import net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider;
import net.opengeospatial.ows.impl.CodeTypeImpl;
import net.opengeospatial.ows.impl.OnlineResourceTypeImpl;
import net.opengeospatial.wps.CapabilitiesDocument;
import net.opengeospatial.wps.ProcessBriefType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.CapabilitiesDocument.Capabilities;
import net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.xmlbeans.XmlObject;
import org.geotools.metadata.iso.citation.OnLineResourceImpl;

import cn.geodata.model.util.ProcessingLibray;
import cn.geodata.models.web.util.Util;

public class GetCapabilitiesOp extends WpsOperation {
	private static Logger log = Logger.getAnonymousLogger();

	@Override
	public XmlObject execute(XmlObject input) throws Exception {
		CapabilitiesDocument _doc = CapabilitiesDocument.Factory.newInstance();
		Capabilities _capabilities = _doc.addNewCapabilities();
		
		
		//ProcessOfferings element
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
	
	protected void initServiceMetadata(Capabilities cap) throws ConfigurationException {
		XMLConfiguration _config = Util.getInstance().getConfig();

		//ServiceIndentification element
		ServiceIdentification _serviceIdentification = cap.addNewServiceIdentification();
		
		_serviceIdentification.setTitle(_config.getString("identification.title"));
		_serviceIdentification.setAbstract(_config.getString("identification.abstract"));
		
		KeywordsType _keywords = _serviceIdentification.addNewKeywords();
		for(String _key : (List<String>)_config.getList("identification.keywords.keyword")){
			_keywords.addKeyword(_key);
		}
		
		//_serviceIdentification.setServiceType("WPS");
		_serviceIdentification.setServiceTypeVersionArray(
				(String[])_config.getList("identification.serviceTypeVersion").toArray(new String[0])
				);
		
		_serviceIdentification.setFees(_config.getString("identification.fees"));
		_serviceIdentification.setAccessConstraintsArray(
				(String[])_config.getList("identification.accessConstraints").toArray(new String[0])
				);
		
		//ServiceProvider element
		ServiceProvider _serviceProvider = cap.addNewServiceProvider();
		
		_serviceProvider.setProviderName(_config.getString("provider.name"));
		
		OnlineResourceType _onlineResource =  OnlineResourceType.Factory.newInstance();
		_onlineResource.setHref(_config.getString("provider.site"));
		_serviceProvider.setProviderSite(_onlineResource);
		
		
		//OperationsMetadata element
		OperationsMetadata _operationsMetadata = cap.addNewOperationsMetadata();
		
		
		Operation _getCapabilities = _operationsMetadata.addNewOperation();
		_getCapabilities.setName("GetCapabilities");
		DCP _getCapabilitiesGet = _getCapabilities.addNewDCP();
		_getCapabilitiesGet.addNewHTTP().addNewGet();
	}

	@Override
	public String getOperationName() {
		return "GetCapabilities";
	}
}

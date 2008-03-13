package cn.geodata.models.web.wps.operation;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import net.opengeospatial.ows.AddressType;
import net.opengeospatial.ows.ContactType;
import net.opengeospatial.ows.KeywordsType;
import net.opengeospatial.ows.OnlineResourceType;
import net.opengeospatial.ows.ResponsiblePartySubsetType;
import net.opengeospatial.ows.TelephoneType;
import net.opengeospatial.ows.HTTPDocument.HTTP;
import net.opengeospatial.ows.OperationDocument.Operation;
import net.opengeospatial.ows.OperationsMetadataDocument.OperationsMetadata;
import net.opengeospatial.ows.ServiceIdentificationDocument.ServiceIdentification;
import net.opengeospatial.ows.ServiceProviderDocument.ServiceProvider;
import net.opengeospatial.wps.CapabilitiesDocument;
import net.opengeospatial.wps.ProcessBriefType;
import net.opengeospatial.wps.CapabilitiesDocument.Capabilities;
import net.opengeospatial.wps.ProcessOfferingsDocument.ProcessOfferings;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.geoprocessing.ModelType;
import cn.geodata.models.geoprocessing.ProcessType;
import cn.geodata.models.util.ProcessingLibray;
import cn.geodata.models.web.util.Util;

public class GetCapabilitiesOp extends WpsOperation {
	private static Logger log = Logger.getLogger("cn.geodata.models.web");

	@Override
	public XmlObject execute(XmlObject input) throws Exception {
		CapabilitiesDocument _doc = CapabilitiesDocument.Factory.newInstance();
		Capabilities _capabilities = _doc.addNewCapabilities();
		
		this.initServiceMetadata(_capabilities);
		
		//ProcessOfferings element
		ProcessOfferings _processOfferings = _capabilities.addNewProcessOfferings();
		
		Map<String, ModelType> _metadata = ProcessingLibray.createInstance().getMetadata();
		for(String _modelKey : _metadata.keySet()){
			ModelType _modelMetadata = _metadata.get(_modelKey);
			for(ProcessType _proc: _modelMetadata.getProcessArray()){
				ProcessBriefType _processBrief = _processOfferings.addNewProcess();
				_processBrief.addNewIdentifier().setStringValue(_modelKey + "." + _proc.getId());
				
				_processBrief.setTitle(_proc.getTitle());
				_processBrief.setAbstract(_proc.getDescribe());

			}
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
		
		for(HierarchicalConfiguration _contactConf : (List<HierarchicalConfiguration>)_config.configurationsAt("provider.contact")){
			ResponsiblePartySubsetType _contact = _serviceProvider.addNewServiceContact();
			_contact.setIndividualName(_contactConf.getString("name"));
			_contact.setPositionName(_contactConf.getString("position"));
			
			ContactType _contantInfo = _contact.addNewContactInfo();
			TelephoneType _telephone = _contantInfo.addNewPhone();
			_telephone.setVoiceArray((String[])_contactConf.getList("phone").toArray(new String[0]));
			
			AddressType _address = _contantInfo.addNewAddress();
			_address.setDeliveryPointArray((String[])_contactConf.getList("address.deliveryPoint").toArray(new String[0]));
			_address.setCity(_contactConf.getString("address.city"));
			_address.setAdministrativeArea(_contactConf.getString("address.administrativeArea"));
			_address.setPostalCode(_contactConf.getString("address.postCode"));
			_address.setCountry(_contactConf.getString("address.country"));
			_address.setElectronicMailAddressArray((String[])_contactConf.getList("email").toArray(new String[0]));
		}
		
		//OperationsMetadata element
		String _url = "http://" + _config.getString("global.host") + ":" + _config.getString("global.port") + "/web/wps?";

		OperationsMetadata _operationsMetadata = cap.addNewOperationsMetadata();
		
		//GetCapabilities
		Operation _getCapabilities = _operationsMetadata.addNewOperation();
		_getCapabilities.setName("GetCapabilities");
		
		HTTP _getCapabilitiesHttp = _getCapabilities.addNewDCP().addNewHTTP();
		_getCapabilitiesHttp.addNewGet().setHref(_url);

		//DescribeProcess
		Operation _describeProcess = _operationsMetadata.addNewOperation();
		_describeProcess.setName("DescribeProcess");
		
		HTTP _describeProcessHttp = _describeProcess.addNewDCP().addNewHTTP();
		_describeProcessHttp.addNewGet().setHref(_url);
		_describeProcessHttp.addNewPost().setHref(_url);

		//DescribeProcess
		Operation _execute = _operationsMetadata.addNewOperation();
		_execute.setName("Execute");
		
		HTTP _executeHttp = _execute.addNewDCP().addNewHTTP();
		_executeHttp.addNewPost().setHref(_url);
	}

	@Override
	public String getOperationName() {
		return "GetCapabilities";
	}
}

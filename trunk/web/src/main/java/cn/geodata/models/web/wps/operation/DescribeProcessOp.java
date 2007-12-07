package cn.geodata.models.web.wps.operation;

import java.util.ArrayList;

import net.opengeospatial.ows.CodeType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionsDocument;
import net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions;
import net.opengeospatial.wps.impl.DescribeProcessDocumentImpl;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.ProcessingFactory;
import cn.geodata.models.util.ProcessingLibray;

public class DescribeProcessOp extends WpsOperation {

	@Override
	public XmlObject execute(XmlObject input) throws Exception {
		DescribeProcessDocumentImpl _input = (DescribeProcessDocumentImpl) input;
		ProcessingLibray _lib = ProcessingLibray.createInstance();

		ArrayList<ProcessDescriptionType> _process = new ArrayList<ProcessDescriptionType>();
		for(CodeType _codeType : _input.getDescribeProcess().getIdentifierArray()){
			ProcessingFactory _model = _lib.getModelFactories().get(_codeType.getStringValue());
			_process.add((ProcessDescriptionType) _model.getMetadata().copy());
		}
		
		ProcessDescriptionsDocument _doc = ProcessDescriptionsDocument.Factory.newInstance();
		ProcessDescriptions _processDescptions = _doc.addNewProcessDescriptions();		
		_processDescptions.setProcessDescriptionArray(_process.toArray(new ProcessDescriptionType[0]));
		
		return _doc;
	}

	@Override
	public String getOperationName() {
		return "DescribeProcess";
	}

}

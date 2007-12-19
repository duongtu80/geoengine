package cn.geodata.models.web.wps.operation;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.activation.MimeType;

import net.opengeospatial.ows.CodeType;
import net.opengeospatial.wps.ComplexDataType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.LiteralInputType;
import net.opengeospatial.wps.LiteralOutputType;
import net.opengeospatial.wps.OutputDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionsDocument;
import net.opengeospatial.wps.SupportedComplexDataType;
import net.opengeospatial.wps.ProcessDescriptionType.DataInputs;
import net.opengeospatial.wps.ProcessDescriptionType.ProcessOutputs;
import net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions;
import net.opengeospatial.wps.impl.DescribeProcessDocumentImpl;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.DataParser;
import cn.geodata.models.geoprocessing.ProcessType;
import cn.geodata.models.geoprocessing.ValueType;
import cn.geodata.models.util.ProcessingLibray;

public class DescribeProcessOp extends WpsOperation {
	private static Logger log = Logger.getLogger("cn.geodata.models.web");

	@Override
	public XmlObject execute(XmlObject input) throws Exception {
		DescribeProcessDocumentImpl _input = (DescribeProcessDocumentImpl) input;
		ProcessingLibray _lib = ProcessingLibray.createInstance();

		ArrayList<ProcessDescriptionType> _process = new ArrayList<ProcessDescriptionType>();
		for(CodeType _codeType : _input.getDescribeProcess().getIdentifierArray()){
			ProcessType _proc = _lib.getMetadata().get(_codeType.getStringValue());
			_process.add(this.createWpsProcessDesc(_proc));
		}
		
		ProcessDescriptionsDocument _doc = ProcessDescriptionsDocument.Factory.newInstance();
		ProcessDescriptions _processDescptions = _doc.addNewProcessDescriptions();
		
		_processDescptions.setProcessDescriptionArray(_process.toArray(new ProcessDescriptionType[0]));
		
		return _doc;
	}
	
	public ProcessDescriptionType createWpsProcessDesc(ProcessType p){
		ProcessDescriptionType _p = ProcessDescriptionType.Factory.newInstance();
		
		_p.addNewIdentifier().setStringValue(p.getId());
		_p.setTitle(p.getTitle());
		_p.setAbstract(p.getDescribe());
		
		DataInputs _dataInputs = _p.addNewDataInputs();
		ProcessOutputs _dataOutputs = _p.addNewProcessOutputs();
		
		DataCategories _categories = DataCategories.getInstance();
		DataParser _paser = DataParser.getInstance();
		
		for(ValueType _type : p.getInputs().getInputArray()){
			InputDescriptionType _input = _dataInputs.addNewInput();
			
			_input.addNewIdentifier().setStringValue(_type.getId());
			_input.setTitle(_type.getTitle());
			_input.setAbstract(_type.getDescribe());
			
			DataCategory _c = _categories.findCategory(_type.getCategoryArray(0));
			if(_c.getLiteral()){
				LiteralInputType _liter = _input.addNewLiteralData();
				_liter.addNewDataType().setStringValue(_c.getTitle());
			}
			else{
				SupportedComplexDataType _compl = _input.addNewComplexData();
				for(MimeType _m : _paser.getComplexParsers().getMimes4Category(_c)){
					ComplexDataType _support = _compl.addNewSupportedComplexData();
					_support.setFormat(_m.toString());
				}
			}
		}
		
		for(ValueType _type : p.getOutputs().getOutputArray()){
			OutputDescriptionType _output = _dataOutputs.addNewOutput();
			
			_output.addNewIdentifier().setStringValue(_type.getId());
			_output.setTitle(_type.getTitle());
			_output.setAbstract(_type.getDescribe());
			
			DataCategory _c = _categories.findCategory(_type.getCategoryArray(0));
			if(_c.getLiteral()){
				LiteralOutputType _liter = _output.addNewLiteralOutput();
				_liter.addNewDataType().setStringValue(_c.getTitle());
			}
			else{
				SupportedComplexDataType _compl = _output.addNewComplexOutput();
				for(MimeType _m : _paser.getComplexParsers().getMimes4Category(_c)){
					ComplexDataType _support = _compl.addNewSupportedComplexData();
					_support.setFormat(_m.toString());
				}
			}
		}
		
		return _p;
	}

	@Override
	public String getOperationName() {
		return "DescribeProcess";
	}

}

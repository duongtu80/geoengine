package cn.geodata.model.wps;

import java.io.File;
import java.net.URI;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;
import net.opengeospatial.ows.ExceptionReportDocument;
import net.opengeospatial.ows.ExceptionType;
import net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport;
import net.opengeospatial.wps.DescribeProcessDocument;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionType;

public class WpsClientTest extends TestCase {
	public void atestTest1() throws Exception {
		URI _uri = new URI("http://127.0.0.1:8080/geoengine/wps?name=aaa");
		String _query = _uri.getQuery();
		if(_query == null){
			_query = "";
		}
	}
	
	public void atestTest2() throws Exception {
		WpsClient _client = new WpsClient(new URI("http://127.0.0.1:8080/geoengine/wps"));
//		System.out.println(_client.getCapibilities().getDocumentElement().getNodeName());
	}
	
	public void atestDescribeProcess() throws Exception {
		WpsClient _client = new WpsClient(new URI("http://127.0.0.1:8080/geoengine/wps"));
		
//		System.out.println(Utilities.createInstance().outputDocument2Text(_client.describeProcess(new String[] {"Buffer"}).getDocumentElement()));
//		System.out.println(_client.describeProcess(new String[] {"Buffer"}).getDocumentElement().getNodeName());		
	}
	
	public void atestDescribeProcess2() throws Exception {
		WpsClient _client = new WpsClient(new URI("http://127.0.0.1:8080/geoengine/wps"));

//		_client.describeProcess(new String[] {"Buffer"}).save(System.out);
		ProcessDescriptionType[] _processArray = _client.describeProcess(new String[] {"Buffer"}).getProcessDescriptions().getProcessDescriptionArray();
		for(ProcessDescriptionType _process : _processArray){
			System.out.println(_process.getIdentifier().getStringValue());
			System.out.println(_process.getTitle());
			for(InputDescriptionType _inputType : _process.getDataInputs().getInputArray()){
				if(_inputType.getComplexData() != null){
					_inputType.getComplexData().save(System.out);
				}
//				System.out.println(_inputType.getIdentifier().getStringValue() + ":" + _inputType.getComplexData());
				
			}
		}
		
//		System.out.println(Utilities.createInstance().outputDocument2Text(_client.describeProcess(new String[] {"Buffer"}).getDocumentElement()));
//		System.out.println(_client.describeProcess(new String[] {"Buffer"}).getDocumentElement().getNodeName());		
	}
	
	public void testExecute() throws Exception {
//		WpsClient _client = new WpsClient(new URI("http://127.0.0.1:8080/geoengine/wps"));
//		
//		ArrayList<ModelValue> _inputs = new ArrayList<ModelValue>();
//		_inputs.add(new LiteralValue("Distance", "Distance", null, 0.5f));
//	
//		Parser _parser = new Parser(new GMLConfiguration());
//		_inputs.add(new ComplexValue("Geometry", "Geometry", null, _parser.parse(WpsClientTest.class.getResourceAsStream("Polygon.xml"))));
//		
//		ExecuteResponseDocument _response = _client.execute("Buffer", _inputs.toArray(new ModelValue[0]));
//		for(IOValueType _output : _response.getExecuteResponse().getProcessOutputs().getOutputArray()){
//			ComplexValue _value = (ComplexValue) ValueParser.parse(_output);
//			System.out.println("Output:" + _value.getValue().getClass().getName());
////			System.out.println("Output " + _output.getIdentifier().getStringValue());
//		}
	}
	
	public void atestTest5() throws Exception {
		Properties _props = new Properties();
		_props.load(WpsClientTest.class.getResourceAsStream("/conf/GmlQName.txt"));
		
		Pattern _pattern = Pattern.compile("\\{[\"](.+)[\"],\\s*[\"](.+)[\"]\\}");
		for(Object _key : _props.keySet()){
			System.out.println(_key + ":" + _props.get(_key));
			Matcher _m = _pattern.matcher(_props.get(_key).toString());
			if(_m.matches()){
				System.out.println(_m.group(1) + "|" + _m.group(2));				
			}
		}
	}
	
	public void atestTest6() throws Exception{
		ExceptionReportDocument _doc = ExceptionReportDocument.Factory.newInstance();
		ExceptionReport _exportNode = _doc.addNewExceptionReport();
		ExceptionType _exceptionType = _exportNode.addNewException();
		_exceptionType.setExceptionCode("InputType");
		
		_doc.save(new File("O:\\tank\\tmp\\test1.xml"));
	}
	
	public void atestTest7() throws Exception{
		ExceptionReportDocument _doc = ExceptionReportDocument.Factory.parse(new File("O:\\tank\\tmp\\test1.xml"));
//		ExceptionReport _exportNode = _doc.addNewExceptionReport();
//		ExceptionType _exceptionType = _exportNode.addNewException();
//		_exceptionType.setExceptionCode("InputType");
//		
		_doc.save(System.out);
	}

	public void atestTest8() throws Exception{
		DescribeProcessDocument _doc = DescribeProcessDocument.Factory.parse(new File("O:\\tank\\tmp\\test1.xml"));
//		ExceptionReport _exportNode = _doc.addNewExceptionReport();
//		ExceptionType _exceptionType = _exportNode.addNewException();
//		_exceptionType.setExceptionCode("InputType");
//		
		_doc.save(System.out);
	}
}

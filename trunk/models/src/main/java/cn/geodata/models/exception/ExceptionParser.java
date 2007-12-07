package cn.geodata.models.exception;

import net.opengeospatial.ows.ExceptionType;
import net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport;

public class ExceptionParser {
	
	/**
	 * Parse exeception report
	 * @param report
	 * @return
	 * @throws Exception
	 */
	public static ProcessingException parse(ExceptionReport report) throws Exception{
		if(report.getExceptionArray().length != 1){
			throw new Exception("Only support single exception report");
		}
		
		ExceptionType _exception = report.getExceptionArray(0);
		String _code = _exception.getExceptionCode().toString();
		
		if(_code.equals("InvalidParameterValue")){
			return new InvalidParameterValueException(_exception);
		}
		else if(_code.equals("InvalidUpdateSequence")){
			return new InvalidUpdateSequenceException(_exception);
		}
		else if(_code.equals("MissingParameterValue")){
			return new MissingParameterValueException(_exception);
		}
		else if(_code.equals("NoApplicableCode")){
			return new NoApplicableCodeException(_exception);
		}
		else if(_code.equals("OperationNotSupported")){
			return new OperationNotSupportedException(_exception);
		}
		else if(_code.equals("VersionNegotiationFailed")){
			return new VersionNegotiationFailedException(_exception);
		}
		else{
			throw new Exception("Unsupported exception:" + _code);
		}
	}
}

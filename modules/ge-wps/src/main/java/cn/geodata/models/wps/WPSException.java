package cn.geodata.models.wps;

import net.opengis.ows.x11.ExceptionType;
import net.opengis.ows.x11.ExceptionReportDocument.ExceptionReport;


public class WPSException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4374248050166421363L;

	public static enum ErrorType {InvalidParameterValue, InvalidUpdateSequence, MissingParameterValue, NoApplicableCode, OperationNotSupported, OptionNotSupported, VersionNegotiationFailed};
	
	private ErrorType type;
	
	public WPSException(ErrorType type, String message, Throwable cause){
		super(message, cause);
		
		this.type = type;
	}

	public WPSException(ErrorType type, String message){
		this(type, message, null);
	}

	public ErrorType getType() {
		return this.type;
	}
	
	public void encode(ExceptionReport errorReport){
		Throwable _err = this;
		while(_err != null){
			ExceptionType _exc = errorReport.addNewException();
			
			if (_err instanceof WPSException) {
				WPSException _wpsError = (WPSException) _err;
				
				_exc.setExceptionCode(_wpsError.getType().toString());
				_exc.addExceptionText(_wpsError.getMessage());
				
//				switch (_wpsError.getType()) {
//				case InvalidParameterValue:
//					break;
//				case InvalidUpdateSequence:
//					break;
//				case MissingParameterValue:
//					break;
//				case NoApplicableCode:
//					break;
//				case OperationNotSupported:
//					break;
//				case OptionNotSupported:
//					break;
//				case VersionNegotiationFailed:
//					break;
//				default:
//					break;
//				}
			}
			else{
				_exc.setExceptionCode("NoApplicableCode");
				_exc.addExceptionText(_err.getMessage());
			}
			
			_err = _err.getCause();
		}
	}
	
	public static void decode(ExceptionReport errorReport) throws WPSException{
		ExceptionType[] _errs = errorReport.getExceptionArray();
		if(_errs.length == 0){
			String _txt = "";
			if(_errs[0].getExceptionTextArray().length > 0){
				_txt = _errs[0].getExceptionTextArray(0);
			}
			
			throw new WPSException(WPSException.ErrorType.valueOf(_errs[0].getExceptionCode()), _txt);
		}
	}

}

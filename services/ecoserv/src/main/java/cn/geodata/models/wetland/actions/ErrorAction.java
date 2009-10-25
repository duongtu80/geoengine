package cn.geodata.models.wetland.actions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorAction {
	private static Logger log = Logger.getAnonymousLogger();
	
	private Exception exception;
	private String message;
	
	public String execute() throws Exception {
		log.log(Level.SEVERE, "Output exception", this.exception);
		this.message = this.exception.getLocalizedMessage();

		return "success";
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return message;
	}
}
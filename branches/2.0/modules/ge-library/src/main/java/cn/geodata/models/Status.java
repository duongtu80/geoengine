package cn.geodata.models;

/**
 * Process status
 * @author Fengm
 *
 */
public class Status {
	private int percent;
	private String message;
	private boolean failed;
	private String[] errorMessages;
	
	public Status(){
		this.percent = 0;
		this.message = "";
		this.failed = false;
	}
	
	public Status(int percent, String message){
		this.setPercent(percent);
		this.setMessage(message);
		this.failed = false;
	}
	
	public Status(String errorMessage){
		this.percent = 100;
		this.failed = true;
		this.errorMessages = new String[] {errorMessage};
	}

	public Status(String[] errorMessages){
		this.percent = 100;
		this.failed = true;
		this.errorMessages = errorMessages;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;

		if(this.percent < 0)
			this.percent = 0;
		if(this.percent > 100)
			this.percent = 100;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		
		if(this.message == null)
			this.message = "";
	}

	public boolean isFailed() {
		return failed;
	}

	public String[] getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String[] errorMessages) {
		this.errorMessages = errorMessages;
	}

	public void setFailed(boolean failed) {
		this.failed = failed;
	}
}

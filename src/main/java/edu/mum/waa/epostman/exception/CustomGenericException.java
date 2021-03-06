package edu.mum.waa.epostman.exception;

public class CustomGenericException extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;
 
	private String title;
	private String message;
	public CustomGenericException(String title, String message) {
		super();
		this.title = title;
		this.message = message;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

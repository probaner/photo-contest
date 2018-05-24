package com.photo.contest.exception;

public class ErrorCode {
	private String message;
	private String reason;
	private Integer httpStatusCode=500;
	
	public ErrorCode(String message, String reason, Integer httpStatusCode) {
		super();
		this.message = message;
		this.reason = reason;
		this.httpStatusCode = httpStatusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	

}

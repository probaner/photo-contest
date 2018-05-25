package com.photo.contest.exception;

public class PayStatusNotFoundException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6896415535344041722L;

	public PayStatusNotFoundException(String message, ErrorCode code) {
		super(message, code);
	}
	public PayStatusNotFoundException(ErrorCode code) {
		super(code);
	}

}

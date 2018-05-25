package com.photo.contest.exception;

public class EmailAlreadyExistsException extends BusinessException {
	
	private static final long serialVersionUID = -556321202610512111L;


	public EmailAlreadyExistsException(String message, ErrorCode code) {
		super(message, code);
	}
	public EmailAlreadyExistsException(ErrorCode code) {
		super(code);
	}

	
}

package com.photo.contest.exception;

public class ImageTitelException extends BusinessException {
	
	private static final long serialVersionUID = 1L;

	
	public ImageTitelException(ErrorCode code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	public ImageTitelException(String message, ErrorCode code) {
		super(message, code);
	}
}

package com.photo.contest.exception;

public class ImageFormateException extends BusinessException {
	
	private static final long serialVersionUID = 1L;
	
	
	public ImageFormateException(ErrorCode code) {
		super(code);
		// TODO Auto-generated constructor stub
	}
	
	public ImageFormateException(String message, ErrorCode code) {
		super(message, code);
	}
	
	

}

package com.photo.contest.exception;

public class ImageSizeException extends BusinessException {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public ImageSizeException(ErrorCode code) {
		super(code);
		// TODO Auto-generated constructor stub
	}
	
	public ImageSizeException(String message, ErrorCode code) {
		super(message, code);
	}
	
	

}

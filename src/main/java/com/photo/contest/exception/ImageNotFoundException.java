package com.photo.contest.exception;

public class ImageNotFoundException extends BusinessException{

	
	private static final long serialVersionUID = -6896415535344041722L; 
	
	public ImageNotFoundException(ErrorCode code) {
		super(code);
		// TODO Auto-generated constructor stub
	}
	
	public ImageNotFoundException(String message, ErrorCode code) {
		super(message, code);
		// TODO Auto-generated constructor stub
	}

}

package com.photo.contest.exception;

public class ImageFormateException extends BusinessException {
	
	private static final long serialVersionUID = 1L;
	
	ImageErrorCode imageErrorCode = null;

	public ImageErrorCode getImageErrorCode() {
		return imageErrorCode;
	}
	public void setImageErrorCode(ImageErrorCode imageErrorCode) {
		this.imageErrorCode = imageErrorCode;
	}
	
	public ImageFormateException(ImageErrorCode imageErrorCode) {
		super(imageErrorCode);
		this.imageErrorCode= imageErrorCode;
	}
	public ImageFormateException(ErrorCode code) {
		super(code);
		// TODO Auto-generated constructor stub
	}
	
	public ImageFormateException(String message, ErrorCode code) {
		super(message, code);
	}
	
	

}

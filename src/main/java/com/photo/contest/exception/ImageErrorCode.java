package com.photo.contest.exception;

import java.util.HashMap;
import java.util.Map;

public class ImageErrorCode extends ErrorCode{

    private Map <String, String> errorMap = new HashMap<>();
	
	public ImageErrorCode(Integer httpStatusCode) {
		super(httpStatusCode);
		// TODO Auto-generated constructor stub
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}
	
	
	

}

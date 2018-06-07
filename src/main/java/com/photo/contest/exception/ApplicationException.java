package com.photo.contest.exception;


public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7608342998674882175L;
	private final ErrorCode code;

	public ApplicationException(ErrorCode code) {
		super();
		this.code = code;
	}

	public ApplicationException(String message, ErrorCode code) {

		super(message);

		this.code = code;

	}

	public ApplicationException(Throwable cause, ErrorCode code) {

		super(cause);

		this.code = code;

	}

	public ApplicationException(String message, Throwable cause, ErrorCode code) {

		super(message, cause);

		this.code = code;

	}
	
	
}

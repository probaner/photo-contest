package com.photo.contest.exception;

public class UserNotFoundException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7742179462837865227L;

	public UserNotFoundException(String message, ErrorCode code) {
		super(message, code);
	}
	public UserNotFoundException(ErrorCode code) {
		super(code);
	}
}

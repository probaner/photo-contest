package com.photo.contest.exception;

public class BusinessException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8666042015858062674L;
	private final ErrorCode code;
	

   
	
	public BusinessException(ErrorCode code) {

        super();

        this.code = code;

    }

    public BusinessException(String message, Throwable cause, ErrorCode code) {

        super(message, cause);

        this.code = code;

    }

    public BusinessException(String message, ErrorCode code) {

        super(message);

        this.code = code;

    }

    public BusinessException(Throwable cause, ErrorCode code) {

        super(cause);

        this.code = code;

    }

    public ErrorCode getCode() {

        return this.code;

    }
}

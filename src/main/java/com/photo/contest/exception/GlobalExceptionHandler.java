package com.photo.contest.exception;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		return "database_error";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		logger.error("IOException handler executed");
		//returning 404 error code
	}
	
	
	/*@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="To show an example of a custom message")
	@ExceptionHandler(ImageFormateException.class)
	public Map<String, String> handleImageFormateException(ImageFormateException e) {
	    // Optionally do additional things with the exception, for example map
	    // individual field errors (from e.getBindingResult()) to the Error object
	    return e.getImageErrorCode().getErrorMap();
	}*/
	
	
	@ResponseBody
	@ExceptionHandler(ImageFormateException.class)
	public ResponseEntity<?> handleImageFormateException(ImageFormateException e) {
	    // Optionally do additional things with the exception, for example map
	    // individual field errors (from e.getBindingResult()) to the Error object
		ResponseEntity<Map<String, String>> responseEntity = new ResponseEntity<>(e.getImageErrorCode().getErrorMap(),
                HttpStatus.OK);
	    return responseEntity;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BusinessException.class)
	public ErrorCode handleValidationException(BusinessException e) {
	    // Optionally do additional things with the exception, for example map
	    // individual field errors (from e.getBindingResult()) to the Error object
	    return e.getCode();
	}
	
	/*@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ErrorCode handleAllotherException(Exception e) {
	    // Optionally do additional things with the exception, for example map
	    // individual field errors (from e.getBindingResult()) to the Error object
	    return new ErrorCode("All other exception"," All other exception",500);
	}*/
}

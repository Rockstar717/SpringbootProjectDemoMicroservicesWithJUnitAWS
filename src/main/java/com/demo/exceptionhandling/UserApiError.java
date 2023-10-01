package com.demo.exceptionhandling;


import org.springframework.http.HttpStatus;

public class UserApiError {
	
	private String message;
	private Throwable throwable ;
	private HttpStatus httpStatus;
	
	public UserApiError() {
		super();
		
	}
	public UserApiError(String message, Throwable throwable, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	@Override
	public String toString() {
		return "ApiError [message=" + message + ", throwable=" + throwable + ", httpStatus=" + httpStatus + "]";
	}
	
}

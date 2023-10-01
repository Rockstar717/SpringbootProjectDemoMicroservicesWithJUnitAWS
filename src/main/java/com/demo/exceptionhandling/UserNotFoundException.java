package com.demo.exceptionhandling;


public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserNotFoundException(String message) {
		super(message);
	}
	
	public static class InvalidUserNameException extends RuntimeException {

		public InvalidUserNameException(String message) {
			super(message);		
		}
	}
	
	public static class EmailValidationException extends RuntimeException {

		public EmailValidationException(String message) {
			super(message);		
		}
	}
	public static class UserEmailNotAllowed extends RuntimeException {

		public UserEmailNotAllowed(String message) {
			super(message);		
		}
	}
	
	public static class NullPointerException extends RuntimeException {

		public NullPointerException(String message) {
			super(message);
			
		}		
	} 
	public static class UserNotAllowed extends RuntimeException {

		public UserNotAllowed(String message) {
			super(message);
			
		}		
	}
}

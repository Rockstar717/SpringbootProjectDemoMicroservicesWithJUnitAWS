package com.demo.exceptionhandling;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.exceptionhandling.UserNotFoundException.EmailValidationException;
import com.demo.exceptionhandling.UserNotFoundException.InvalidUserNameException;
import com.demo.exceptionhandling.UserNotFoundException.UserEmailNotAllowed;
import com.demo.exceptionhandling.UserNotFoundException.UserNotAllowed;
@RestControllerAdvice
@ControllerAdvice
public class GlobalUserCustomException {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException) {

		UserApiError userApiError = new UserApiError(userNotFoundException.getMessage(),
				userNotFoundException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(userApiError, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName =((FieldError)error).getField();
		String message =error.getDefaultMessage();
		resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>> (resp,HttpStatus.UNAUTHORIZED);
	}


	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(NullPointerException.class)
	public HashMap<String , String> userNullNotValid(NullPointerException nullPointerException){
		HashMap<String, String> error = new HashMap<>();
		error.put("errorMsg", nullPointerException.getMessage());
		return error;
	}

     // for dev
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidUserNameException.class)
	public HashMap<String , String> userNotValid(InvalidUserNameException invaliUserNameException){
		HashMap<String, String> error = new HashMap<>();
		error.put("errorMsg", invaliUserNameException.getMessage());
		return error;
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UserNotAllowed.class)
	public HashMap<String, String>  userNotAllowed(UserNotAllowed userNotAllowed){
		HashMap<String, String> error = new HashMap<>();
		error.put("errorMsg", userNotAllowed.getMessage());
		return error;
	}
	
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(EmailValidationException.class)
	public HashMap<String, String>  invalidUserNameEmailException(EmailValidationException invalidUserNameEmailException){
		HashMap<String, String> error = new HashMap<>();
		error.put("errorMsg", invalidUserNameEmailException.getMessage());
		return error;
	}
	
	//Useremail
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UserEmailNotAllowed.class)
	public HashMap<String,String> userEmailNotAllowed(UserEmailNotAllowed userEmailNotAllowed){
		HashMap<String, String> error = new HashMap<>();
		error.put("errorMessage",userEmailNotAllowed.getMessage());
		return error;
	}
	
}

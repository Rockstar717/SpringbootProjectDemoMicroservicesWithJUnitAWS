package com.demo.regex;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserNameValidationConfig {
	
	String regexPattern ="^[a-z]+$";	//"^(![?])$" 
	public String getUserNamepattern() {
		return regexPattern;
		
	}
	
	String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";//
	public String validateEmail() {
		return emailRegex;
		
	}
}

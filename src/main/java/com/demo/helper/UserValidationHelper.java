package com.demo.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Validated
public class UserValidationHelper {
	@Value("${userlist.users}")
	private List<String> users;


	public boolean validateUser(String username) {
		System.out.println(users.contains(username));
		return users.contains(username);
	}

	public boolean nullUserNotAllowed(String username) {
		System.out.println(users.contains(username));
		return users.contains(username);
	}

	public boolean emailNotValid(String username) {
		System.out.println(users.contains(username));
		return users.contains(username);
	}
}

/************************/
//String username = userInfo.getName();
//String regex = userNameValidationConfig.getUserNamepattern();
//
//String username1 = userInfo.getName();
//String regexx= userNameValidationConfig.validateEmail();

//Pattern pattern = Pattern.compile(regexx);
//if(pattern.matcher(regexx).matches()) {
//	//return "valid";	
//	throw new EmailValidationException("unauthorised");
//}

//if (!username1.matches(regexx)) {
//	throw new EmailValidationException("");
//} 	
//if (!userValidationHelper.emailNotValid(username)) {
//	throw new UserEmailNotAllowed("unAuthorised");
//} 

//if (!username.matches(regex)) {
//	throw new InvalidUserNameException("space and capital letter is not allowed");
//} 	
//if (!userValidationHelper.isUserAllowed(username)) {
//	throw new UserNotAllowed("user not found");
//} 
//
//if (!userValidationHelper.nullUserNotAllowed(username)) 
//	throw new NullPointerException();
//
//else {
//	userService.createUser(userInfo);
//}
//return "valid user & insert data sucessfully";
//}

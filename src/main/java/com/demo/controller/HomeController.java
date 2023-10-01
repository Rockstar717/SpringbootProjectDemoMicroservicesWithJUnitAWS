package com.demo.controller;

import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.demo.exceptionhandling.UserNotFoundException.EmailValidationException;
import com.demo.exceptionhandling.UserNotFoundException.InvalidUserNameException;
import com.demo.exceptionhandling.UserNotFoundException.UserEmailNotAllowed;
import com.demo.exceptionhandling.UserNotFoundException.UserNotAllowed;
import com.demo.first.entity.UserInfo;
import com.demo.first.service.UserService;
import com.demo.helper.UserValidationHelper;
import com.demo.regex.UserNameValidationConfig;
import com.demo.second.entity.ProductInfo;
import com.demo.second.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping(value = "/user")
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserNameValidationConfig userNameValidationConfig;

	@Autowired
	private UserValidationHelper userValidationHelper;

	// Exception handling
	@GetMapping("{userid}")
	public UserInfo getUserInfo(@PathVariable("userid") int userid) {
		System.out.println(userid);
		return userService.findUserById(userid);

	}

	@GetMapping
	public List<UserInfo> getall() {
		return userService.getUser();
	}

	@PostMapping
	public UserInfo add(@Valid @RequestBody UserInfo userInfo) {

		String username = userInfo.getName();
		String regex = userNameValidationConfig.getUserNamepattern();

		if (!username.matches(regex)) {
			throw new InvalidUserNameException("space and capital letter is not allowed");
		}
		if (!userValidationHelper.validateUser(username)) {
			throw new UserNotAllowed("user not found");
		}
		if (!userValidationHelper.nullUserNotAllowed(username)) {
			throw new NullPointerException("cannot invoke null");
		} else {
			return userService.createUser(userInfo);
		}		
	}

	@PutMapping
	public UserInfo update(@RequestBody UserInfo userInfo) {
		return userService.updateUser(userInfo);
	}

	@DeleteMapping
	public String delete(@RequestBody UserInfo userInfo) {
		userService.deleteUser(userInfo);
		return "Delete Successfully";
	}

	// h2 database for product
	@GetMapping("/get")
	public List<ProductInfo> getal() {
		return productService.getUser();
	}

	@PostMapping("/add")
	public String add(@RequestBody ProductInfo productInfo) {
		productService.createProduct(productInfo);
		return "Insert Successfully in H2";
	}

	@PutMapping("/upgrade")
	public String upgrade(@RequestBody ProductInfo productInfo) {
		productService.updateProduct(productInfo);
		return "Upgarde Successfully in H2";
	}

	@DeleteMapping("/remove")
	public String Remove(@RequestBody ProductInfo productInfo) {
		productService.deleteProduct(productInfo);
		return "Remove Successfully in H2";
	}
}

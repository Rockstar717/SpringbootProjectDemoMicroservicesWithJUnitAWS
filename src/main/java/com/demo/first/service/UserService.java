package com.demo.first.service;


import java.util.List;

import com.demo.first.entity.UserInfo;

public interface UserService {
	
	public  UserInfo createUser(UserInfo userInfo);
	
	public UserInfo updateUser(UserInfo userInfo);
	
	public String deleteUser(UserInfo userInfo);
	
	public List<UserInfo> getUser();
	
	public UserInfo findUserById(int userId);

	

}

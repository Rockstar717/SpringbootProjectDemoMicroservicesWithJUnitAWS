package com.demo.first.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.demo.exceptionhandling.UserNotFoundException;
import com.demo.first.Dao.UserRepository;
import com.demo.first.entity.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserInfo createUser(UserInfo userInfo) {
		return userRepository.save(userInfo);
	}

	@Override
	public UserInfo updateUser(UserInfo userInfo) {
		return userRepository.save(userInfo);
	}

	@Override
	public String deleteUser(UserInfo userInfo) {
		userRepository.delete(userInfo);
		return "Delete Successfully";
	}

	@Override
	public List<UserInfo> getUser() {
		return userRepository.findAll();
	}

	@Override
	public UserInfo findUserById(int userId) {
		if (userRepository.findById(userId).isEmpty())
			throw new UserNotFoundException("user does not exist");
		return userRepository.findById(userId).get();
	}
}

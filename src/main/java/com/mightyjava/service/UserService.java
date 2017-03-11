package com.mightyjava.service;

import java.util.List;

import com.mightyjava.model.User;

public interface UserService {
	User authenticate(User user);
	
	List<User> userList();
	
	User saveUser(User user);
	
	User findUser(Long id);
	
	void deleteUser(Long id);
}

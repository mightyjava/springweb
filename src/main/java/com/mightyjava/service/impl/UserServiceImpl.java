package com.mightyjava.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mightyjava.dao.UserDao;
import com.mightyjava.model.User;
import com.mightyjava.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User authenticate(User user) {
		return userDao.authenticate(user.getUserId(), user.getPassword());
	}

	@Cacheable(value = "users")
	public List<User> userList() {
		return userDao.findAll();
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}

	public User findUser(Long id) {
		return userDao.findOne(id);
	}

	public void deleteUser(Long id) {
		userDao.delete(id);
	}

}

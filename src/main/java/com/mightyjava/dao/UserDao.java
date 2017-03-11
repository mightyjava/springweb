package com.mightyjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mightyjava.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	
	@Query("FROM User WHERE userId=:userId AND password=:password")
	User authenticate(@Param("userId") String userId, @Param("password") String password);
}

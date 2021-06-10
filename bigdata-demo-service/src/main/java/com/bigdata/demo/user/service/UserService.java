package com.bigdata.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata.demo.user.entity.User;
import com.bigdata.demo.user.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User getUser(int id) {
		User user = userMapper.getUserById(id);
		return user;
	}
}

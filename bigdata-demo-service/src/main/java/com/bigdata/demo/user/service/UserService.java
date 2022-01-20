package com.bigdata.demo.user.service;

import java.util.List;

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
	
	public boolean insertUser(User user) {
		userMapper.addUser(user);
		return true;
	}
	
	public boolean updateUser(User user) {
		userMapper.updateUser(user);
		return true;
	}
	
	public List<User> getUsers() {
		return userMapper.getUsers();
	}
	
	public boolean deleteUser(int id) {
		userMapper.deleteUser(id);
		return true;
	}
}

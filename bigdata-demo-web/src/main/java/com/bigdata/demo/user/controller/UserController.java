package com.bigdata.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.demo.user.entity.User;
import com.bigdata.demo.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/{id}")
	public User getUser(@PathVariable int id) {
		User user = userService.getUser(id);
		return user;
	}
	
}

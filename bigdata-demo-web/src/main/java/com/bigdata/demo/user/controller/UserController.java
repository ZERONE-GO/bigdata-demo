package com.bigdata.demo.user.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Autowired
	private StringEncryptor encryptor;

	@RequestMapping("/{id}")
	public User getUser(@PathVariable int id) {
		User user = userService.getUser(id);
		return user;
	}
	
	@GetMapping("/encrypt")
	public String testEncryptor() {
        //用户名
        String name = encryptor.encrypt("root");
        //密码
        String password = encryptor.encrypt("root");
        return name + ", " + password;
	}
}

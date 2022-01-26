package com.bigdata.demo.api.user.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.demo.user.entity.User;
import com.bigdata.demo.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/user")
@Api(tags= {"用户模块"})
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("v1/users")
	@ApiOperation("获取用户列表")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("v1/user/{id}")
	@ApiOperation("获取用户信息")
	public User getUser(@PathVariable @ApiParam(value="用户id") int id) {
		if(id < 0) {
			throw new RuntimeException("用户id非法");
		}
		User user = userService.getUser(id);
		return user;
	}
	
	@PostMapping("v1/user")
	@ApiOperation("添加用户")
	public boolean createUser(@ApiParam("添加用户信息") @RequestBody @NonNull User user) {
		if(StringUtils.isEmpty(user.getUserName())) {
			throw new RuntimeException("用户姓名不能为空");
		}
		return userService.insertUser(user);
	}
	
	@PutMapping("v1/user")
	@ApiOperation("修改用户信息")
	public boolean updateUser(@ApiParam("修改用户信息") @RequestBody @NonNull User user) {
		if(user.getId() < 0) {
			throw new RuntimeException("用户id非法");
		}
		return userService.updateUser(user);
	}
	
	@DeleteMapping("v1/user/{id}")
	@ApiOperation("删除用户")
	public boolean deleteUser(@PathVariable @ApiParam(value="用户id") int id) {
		if(id < 0) {
			throw new RuntimeException("用户id非法");
		}
		return userService.deleteUser(id);
	}

}

package com.bigdata.demo.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bigdata.demo.user.entity.User;

@Repository
public interface UserMapper {
	User getUserById(int id);

	List<User> getUsers();

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(int id);
}

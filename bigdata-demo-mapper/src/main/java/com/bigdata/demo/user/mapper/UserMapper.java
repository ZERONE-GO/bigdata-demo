package com.bigdata.demo.user.mapper;

import org.springframework.stereotype.Repository;

import com.bigdata.demo.user.entity.User;

@Repository
public interface UserMapper {
	User getUserById(int id);
}

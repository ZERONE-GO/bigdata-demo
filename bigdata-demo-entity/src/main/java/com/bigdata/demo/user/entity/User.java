package com.bigdata.demo.user.entity;

import lombok.Data;

@Data
public class User {
	private int id;

	private String userName;

	private String password;

	private String nickName;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:").append(id).append(", name:").append(userName).append(", password:").append(password)
				.append(",nickName").append(nickName);
		return sb.toString();
	}

}

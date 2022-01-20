package com.bigdata.demo.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体")
public class User {
	@ApiModelProperty(value="用户id")
	private int id;

	@ApiModelProperty("用户名")
	private String userName;

	@ApiModelProperty("用户密码")
	private String password;

	@ApiModelProperty("用户昵称")
	private String nickName;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:").append(id).append(", name:").append(userName).append(", password:").append(password)
				.append(",nickName").append(nickName);
		return sb.toString();
	}

}

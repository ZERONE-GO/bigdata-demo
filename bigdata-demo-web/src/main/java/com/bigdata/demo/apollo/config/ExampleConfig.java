package com.bigdata.demo.apollo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "example")
public class ExampleConfig {
	
	private int expireSeconds;
	
	private int commandTimeout;
	
	@Override
	public String toString() {
		return "ExpireSeconds: " + expireSeconds + ", CommandTimeout: " + commandTimeout;
	}

}

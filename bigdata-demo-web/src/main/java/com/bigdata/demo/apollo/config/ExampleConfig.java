package com.bigdata.demo.apollo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:example/example.properties")
@ConfigurationProperties(prefix = "example")
public class ExampleConfig {

	private int expireSeconds;

	private int commandTimeout;

	@ApolloConfig("example")
	private Config config;

	@Override
	public String toString() {
		return "ExpireSeconds: " + expireSeconds + ", CommandTimeout: " + commandTimeout;
	}

	@ApolloConfigChangeListener("example")
	private void onChange(ConfigChangeEvent event) {
		System.out.println("======event change=====");
		for(String key : event.changedKeys()) {
			if(key.equals("example.expireSeconds")) {
				this.expireSeconds = config.getIntProperty("example.expireSeconds", 0);
			} else if(key.equals("example.commandTimeout")) {
				this.commandTimeout = config.getIntProperty("example.commandTimeout", 0);
			}
			System.out.println("key:" + key);
		}
	}
}

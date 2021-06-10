package com.bigdata.demo.apollo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bigdata.demo.apollo.config.ExampleConfig;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

@RestController
@RequestMapping("/apollo")
public class ApolloController {
	
	@Autowired
	private ExampleConfig exampleConfig;

	@RequestMapping(method = { RequestMethod.GET }, path = "/hello")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(method = { RequestMethod.GET }, path = "/config/{key}")
	public String getConfig(@PathVariable(name = "key", required = true) String key) {
		Config config = ConfigService.getAppConfig();
		return config.getProperty(key, "UNKNOW");
	}

	@RequestMapping(method = { RequestMethod.GET }, path = "/config/{namespace}/{key}")
	public String getConfig(@PathVariable(name = "namespace", required = true) String namespace,
			@PathVariable(name = "key", required = true) String key) {
		Config config = ConfigService.getConfig(namespace);
		return config.getProperty(key, "UNKNOW");
	}
	
	@RequestMapping(method = { RequestMethod.GET }, path = "/exampleconfig")
	public String getExampleConfig() {
		return exampleConfig.toString();
	}

}

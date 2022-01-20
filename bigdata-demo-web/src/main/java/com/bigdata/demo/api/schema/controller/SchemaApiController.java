package com.bigdata.demo.api.schema.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/schema")
@Api(tags = { "Schema" })
public class SchemaApiController {

	public ConcurrentHashMap<String, List<String>> databaseMap;

	@PostConstruct
	private void init() {
		databaseMap = new ConcurrentHashMap<String, List<String>>();
		List<String> dmList = new ArrayList<>();
		dmList.add("user");
		dmList.add("test");
		databaseMap.put("dm", dmList);
	}

	@GetMapping("v1/mysql/tables/{db}")
	@ApiOperation("获取MySQL数据库中的表信息")
	public List<String> getTables(@PathVariable @ApiParam(value = "mysql库名称", example = "dm") String db) {
		return databaseMap.get(db);
	}

	@PostMapping("v1/mysql/addtables/{db}")
	@ApiOperation("数据库表中添加库表信息")
	public void putTables(@ApiParam(value = "mysql库名称", example = "dm")@PathVariable String db,
			@ApiParam(value = "添加的库表", example = "[user, test]") @RequestBody List<String> tables) {
		if (StringUtils.isEmpty(db) || CollectionUtils.isEmpty(tables)) {
			throw new RuntimeException("db name or tables list can not be null");
		}

		if (databaseMap.containsKey(db)) {
			List<String> dbTables = databaseMap.get(db);
			dbTables.addAll(tables);
		} else {
			databaseMap.put(db, tables);
		}
	}
}

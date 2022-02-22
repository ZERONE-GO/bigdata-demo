package com.bigdata.demo.user.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bigdata.demo.DemoApplication;
import com.bigdata.demo.user.entity.User;
import com.bigdata.demo.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = DemoApplication.class)
public class UserApiControllerTest {

	@MockBean
	private UserService userService;

	@Autowired
	protected WebApplicationContext context;

	private MockMvc mvc;
	
	private User mockUser;

	@Before
	public void before() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();

		// mock data for testing
		mockUser = User.builder().id(6).userName("Test").password("123456").nickName("NT002").build();
		Mockito.when(userService.getUser(6)).thenReturn(mockUser);
		Mockito.doReturn(true).when(userService).insertUser(mockUser);
		Mockito.doReturn(true).when(userService).updateUser(mockUser);
		Mockito.doReturn(true).when(userService).deleteUser(6);
	}

	@Test
	public void testGetUser() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/api/user/v1/user/6")
				.contentType(MediaType.APPLICATION_JSON);
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status.status").value(200))
				.andExpect(jsonPath("$.data.id").value(6))
				.andExpect(jsonPath("$.data.userName").value("Test"))
				.andExpect(jsonPath("$.data.password").value("123456"))
				.andExpect(jsonPath("$.data.nickName").value("NT002"));
	}

	@Test
	public void testCreateUser() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/api/user/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JacksonUtils.serialize(mockUser));
		mvc.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$.status.status").value(200)).andExpect(jsonPath("$.data").value(true));
	}
	
	@Test
	public void testUpdateUser() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.put("/api/user/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JacksonUtils.serialize(mockUser));
		mvc.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$.status.status").value(200)).andExpect(jsonPath("$.data").value(true));
		
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.delete("/api/user/v1/user/6").contentType(MediaType.APPLICATION_JSON);
		mvc.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$.status.status").value(200)).andExpect(jsonPath("$.data").value(true));
	}
}

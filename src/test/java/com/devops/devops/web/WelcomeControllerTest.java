package com.devops.devops.web;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
class WelcomeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Test
	void testWelcome() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(model().attribute("course", containsString("DevOps")));
	}

}
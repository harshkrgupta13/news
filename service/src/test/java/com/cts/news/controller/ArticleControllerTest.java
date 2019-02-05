package com.cts.news.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleControllerTest.class);

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testForSaveFavouriteArticle() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"id\":\"4\"" + "," + "\"article\":[{\"title\":\"harsh\"" + "," + "\"author\":\"harsh\""
				+ "," + "\"description\":\"harsh\"" + "," + "\"content\":\"harsh\"" + "," + "\"url\":\"harsh\"" + ","
				+ " \"urlToImage\":\"harsh\"}]}";

		LOGGER.debug("test data:{}", TEST_DATA);

		mockMvc.perform(post("/saveArticle").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());

		LOGGER.info("End");
	}

	@Test
	public void testForDeleteFavouriteArticle() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"id\":\"4\"" + "," + "\"article\":[{\"title\":\"harsh\"}]}";

		LOGGER.debug("test data:{}", TEST_DATA);

		mockMvc.perform(post("/delete").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());

		LOGGER.info("End");
	}

	@Test
	public void testForGettingUserDetails() throws Exception {

		LOGGER.info("Start");

		mockMvc.perform(get("/user/{id}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("Admin"));

		LOGGER.info("End");

	}

}

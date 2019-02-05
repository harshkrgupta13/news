package com.cts.news.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class UserControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void loginControllerTestForSuccess() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"email\":\"abc@email.com\"" + "," + "\"password\":\"abcabc\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(true));
		LOGGER.info("End");
	}

	@Test
	public void loginControllerTestForUnsuccessfullLogin() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"email\":\"abc@email.com\"" + "," + "\"password\":\"abcde\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End");
	}

	@Test
	public void loginControllerTestForEmptyEmail() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{ \"password\":\"abcabc\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End");
	}

	@Test
	public void loginControllerTestForEmptyPassword() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{ \"email\":\"abc@email.com\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTest() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"Harsh\"" + "," + "\"language\":{\"id\":\"1\"}" + "," + "\"role\":{\"id\":\"2\"}"
				+ "," + "\"email\":\"harsh@email.com\"" + "," + "\"password\":\"harsh1\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.signupStatus").value(true));

		LOGGER.info("En");
	}

	@Test
	public void signupControllerTestrForEmptyFields() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(jsonPath("$.errorMessage").isNotEmpty());
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForPreExistingEmailId() throws Exception {
		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"HarshGupta\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"har@gmail.com\"" + ","
				+ "\"password\":\"harshgupta\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForEmptyName() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"password\":\"harshg\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"h@gmail.com\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: User Name cannot be empty"));
		;
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForEmptyPassword() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"harshg\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"h@gmail.com\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForEmptyEmail() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"harsh\"" + "," + "\"language\":{\"id\":\"1\"}" + "," + "\"role\":{\"id\":\"2\"}"
				+ "," + "\"password\":\"harshg\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Email cannot be empty"));
		;
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestInvalidPasswordFormat() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"name\":\"HarshGupta\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"harsh@abc.com\"" + "," + "\"password\":\"1\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info("End");
	}

	@Test
	public void signupControllerTestForInvalidNameFormat() throws Exception {

		LOGGER.info("Start");

		String TEST_DATA = "{\"name\":\"Harshgfhdsughudshgfuhsdihwgajffisjfisvgjmvjvgcgcghcghcghhhghgghghhhxdxgzxgnfxxhxojf\""
				+ "," + "\"language\":{\"id\":\"1\"}" + "," + "\"role\":{\"id\":\"2\"}" + ","
				+ "\"email\":\"harsh@gmail.com\"" + "," + "\"password\":\"aaaaaaa\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError());
		LOGGER.info("End");
	}

	@Test
	public void signupControllerInvalidEmailFormat() throws Exception {

		LOGGER.info("Start");
		String TEST_DATA = "{\"name\":\"Harsh\"" + "," + "\"language\":{\"id\":\"1\"}" + "," + "\"role\":{\"id\":\"2\"}"
				+ "," + "\"email\":\"vgfysygfsyhgfyshgfyusgfhxzbcshgfyudsadcgfhfxchfgyugfyusgfhfhfhb"
				+ "cbdgdgfszfszfszdfdgxdgdzfszffsbcdzhjbsfyusgfuysgfusfjzhbchjbsfsfhsufhjncisf"
				+ "osjckzmdfijsfisdjfiodgfodjgidjgidjihdgfihdgihdfvndiisojdsfuihsdguindksnfios"
				+ "iofnksfyusgfyusfbcshbcsybfyusfbyusbchzbcshyfbyusfbyusfbcshbcfbcyusfbgyusfby"
				+ "usfyusfscbshfbsyfysfsbsfbsfbyuffbsfyufsfbzhfbsfyusfzhbfuszfuyfzfbgddghudghu"
				+ "dghudhgusfhjnchfdhfhfdhffffdxhfdhfhfhfdhfdghfdgghfdhfdhhhdhhjnbh@gmail.com\"" + ","
				+ "\"password\":\"harshg\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/user/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(
						jsonPath("$.errorMessage").value("Invalid input format: Email must not exceed 255 characters"));
		LOGGER.info("End");
	}

}

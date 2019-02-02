package com.cts.news.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.bean.AuthenticationStatus;
import com.cts.news.bean.User;
import com.cts.news.service.UserService;

public class UserControllerMockitoTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerMockitoTest.class);

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void successfullyLogin() {
		LOGGER.info("Start");
		User user = new User();
		user.setEmail("harsh@email.com");
		user.setPassword("abcdef");
		when(userService.getUser(user.getEmail())).thenReturn(user);
		AuthenticationStatus status = userController.authenticate(user).getBody();
		assertEquals(true, status.isAuthenticated());
		LOGGER.info("End");

	}

	@Test
	public void unsuccessfullyLoginForNullEmail() {
		LOGGER.info("Start");
		User user = new User();
		user.setPassword("abcdef");
		when(userService.getUser(user.getEmail())).thenReturn(null);
		AuthenticationStatus status = userController.authenticate(user).getBody();
		assertEquals(true, status.isAuthenticated() == false);
		LOGGER.info("End");

	}

	@Test
	public void unsuccessfullyLoginForNullPassword() {
		LOGGER.info("Start");
		User user = new User();
		user.setEmail("user@email.com");
		User actualUser = new User();
		actualUser.setEmail("vishal");
		actualUser.setPassword("password");
		when(userService.getUser(user.getEmail())).thenReturn(actualUser);
		AuthenticationStatus status = userController.authenticate(user).getBody();
		assertEquals(true, status.isAuthenticated() == false);
		LOGGER.info("End");

	}

}

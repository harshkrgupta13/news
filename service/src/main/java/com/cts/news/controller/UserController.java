package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.AuthenticationStatus;
import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/save")
	public SignupStatus signUp(@RequestBody User user) {
		LOGGER.info("Start");
		SignupStatus signupStatus = userService.saveUser(user);
		LOGGER.debug("SignupStatus :{}", signupStatus);
		LOGGER.info("End");
		return signupStatus;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationStatus> authenticate(@RequestBody User user) {

		LOGGER.info("Start");
		LOGGER.debug("From request (user) : {}", user);
		String email = user.getEmail();
		LOGGER.debug("Value of email: {} ", email);
		String password = user.getPassword();
		LOGGER.debug("Value of password: {} ", password);

		String actualPassword = "";
		String actualEmail = "";
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);
		status.setAdmin(false);
		User actualUser = userService.getUser(email);

		LOGGER.debug("From request (actualUser) : {}", actualUser);
		if (actualUser != null) {
			actualPassword = actualUser.getPassword();
			if (email.equals("admin@email.com") && actualPassword.equals("123456")) {
				status.setUser(actualUser);
				status.setAdmin(true);
				status.setAuthenticated(true);
			} else {
				actualEmail = actualUser.getEmail();
				status.setUser(actualUser);
				status.setAuthenticated(email.equals(actualEmail));
				status.setAuthenticated(password.equals(actualPassword));
			}
		}
		LOGGER.debug("Value of actualPassword: {} ", actualPassword);
		LOGGER.debug("Value of status: {} ", status);
		LOGGER.info("End");
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);
	}

}

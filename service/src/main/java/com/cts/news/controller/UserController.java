package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
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
	
}

package com.cts.news.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.repository.UserRepository;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Transactional
	public SignupStatus saveUser(User user) {
		SignupStatus signupStatus = new SignupStatus();
		LOGGER.info("Start");
		signupStatus.setSignupStatus(false);
		LOGGER.debug("SignupStatus :{}", signupStatus);
		LOGGER.info("End");
		userRepository.save(user);
		signupStatus.setSignupStatus(true);
		return signupStatus;
	}
	
}

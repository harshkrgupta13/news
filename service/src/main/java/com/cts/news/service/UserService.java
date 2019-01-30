package com.cts.news.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.news.bean.Role;
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
		Role role = new Role();
		role.setId(2);
		user.setRole(role);
		LOGGER.info("Start");
		signupStatus.setSignupStatus(false);
		LOGGER.debug("SignupStatus :{}", signupStatus);
		LOGGER.info("End");
		userRepository.save(user);
		signupStatus.setSignupStatus(true);
		return signupStatus;
	}
	
	@Transactional
	public User getUser(String email) {
		LOGGER.info("Start");
		LOGGER.debug("Email: {}", email);
		LOGGER.info("End");
		return userRepository.findByEmail(email);
	}
	
	@Transactional
	public User findAnalyst(String email) {
		LOGGER.info("START");
		
		User user = userRepository.findByEmail(email);
		if(user.getRole().getId()==2) {
		LOGGER.debug("list of total no of question for each subject contributed : {} ", user);
		LOGGER.info("END");
		return user;
		}
		else
			return null;

	}
	
	@Transactional
	public User saveAnalystStatus(String email) {
		User user=userRepository.findByEmail(email);
		LOGGER.info("email");
		if(user.getRole().getId()==2) {
		if(user.getBlacklisted())
		{
			user.setBlacklisted(false);
		}else {
			user.setBlacklisted(true);
		}
		userRepository.save(user);
 
		return userRepository.findByEmail(email);
	}
	
	else
		return null;
	}

	
}

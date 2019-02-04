package com.cts.news.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.repository.UserRepository;

public class SignupServiceMockitoTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupServiceMockitoTest.class);

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void SuccessfullSignupTest() {
		LOGGER.info("Start");
		SignupStatus expectedStatus = new SignupStatus();
		expectedStatus.setSignupStatus(true);
		User user = new User();
		user.setEmail("bjsvdfhs@gmail.com");
		when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
		when(userRepository.save(user)).thenReturn(user);
		SignupStatus actualStatus = userService.saveUser(user);
		assertEquals(true, expectedStatus.equals(actualStatus));
		LOGGER.debug("actualStatus :{}", actualStatus);
		/*verify(userRepository, times(1)).findByEmail(user.getEmail());
		verify(userRepository, times(1)).save(user);*/
		LOGGER.info("End");

	}

	/*@Test
	public void unSuccessfullSignupTest() {
		LOGGER.info("Start");
		SignupStatus expectedStatus = new SignupStatus();
		expectedStatus.setSignupStatus(false);
		User user = new User();
		user.setEmail("bjsvdfhs@gmail.com");
		when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
		when(userRepository.save(user)).thenReturn(user);
		SignupStatus actualStatus = userService.saveUser(user);
		assertEquals(true, expectedStatus.equals(actualStatus));
		LOGGER.debug("actualStatus :{}", actualStatus);
		verify(userRepository, times(0)).save(user);
		verify(userRepository, times(1)).findByEmail(user.getEmail());
		LOGGER.info("End");

	}*/

}

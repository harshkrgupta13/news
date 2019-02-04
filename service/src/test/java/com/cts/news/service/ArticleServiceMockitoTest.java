package com.cts.news.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.repository.ArticleRepository;

public class ArticleServiceMockitoTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceMockitoTest.class);

	@Mock
	private ArticleRepository articleRepository;

	@InjectMocks
	private ArticleService articleService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addFavoriteArticleTest() {
		

	}

}

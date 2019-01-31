package com.cts.news.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.news.bean.Article;
import com.cts.news.bean.User;
import com.cts.news.repository.ArticleRepository;
import com.cts.news.repository.UserRepository;

@Service
public class ArticleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private UserRepository userRepository;

	/*
	 * @Transactional public int saveArticle(Article article) {
	 * LOGGER.info("Start"); LOGGER.debug("saveArticle {}", article);
	 * articleRepository.save(article); int id=article.getId();
	 * LOGGER.info("End"); return id;
	 * 
	 * }
	 */

	@Transactional
	public void saveArticle(User user) {
		LOGGER.info("Start");
		Article article = user.getArticle().get(0);
		String title = article.getTitle();
		int id = 0;
		Article actualArticle = articleRepository.findBytitle(title);
		// System.out.println(article);
		LOGGER.debug("article  {}", article);
		User actualUser = userRepository.findById(user.getId());

		if (actualArticle == null) {
			articleRepository.save(article);
			id = article.getId();
		}
		LOGGER.debug("id {}", id);
		LOGGER.debug("article  {}", article);
		if (id != 0) {
			LOGGER.debug("users fav article  {}", actualUser.getArticle());
			actualUser.getArticle().add(article);
			userRepository.save(actualUser);

		}

		LOGGER.info("End");
	}

	@Transactional
	public User getUser(int id) {
		return userRepository.findById(id);

	}
}

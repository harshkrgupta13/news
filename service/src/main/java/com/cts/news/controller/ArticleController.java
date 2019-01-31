package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.User;
import com.cts.news.service.ArticleService;

@RestController
public class ArticleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;

	/*
	 * @PostMapping("/saveArticle") private int saveArticle(@RequestBody Article
	 * article) { LOGGER.info("Start"); System.out.println(article);
	 * LOGGER.debug("saveArticle {}", article); int id =
	 * articleService.saveArticle(article); LOGGER.info("End"); return id; }
	 */

	@PostMapping("/saveArticle")
	public void saveArticle(@RequestBody User user) {
		LOGGER.info("Start");
		LOGGER.debug("user {}", user);
		articleService.saveArticle(user);
		LOGGER.info("End");

	}

	@GetMapping("/user/{id}")
	public User getUserDetails(@PathVariable("id") int id) {
		LOGGER.info("Start");
		LOGGER.debug("Id {}", id);
		User user = articleService.getUser(id);
		LOGGER.debug("user {}", user);
		LOGGER.info("END");
		return user;

	}
}
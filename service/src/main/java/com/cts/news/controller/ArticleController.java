package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.Article;
import com.cts.news.service.ArticleService;
@RestController
public class ArticleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;

	@PostMapping("/saveArticle")
	private int saveArticle(@RequestBody Article article) {
		LOGGER.info("Start");
		System.out.println(article);
		LOGGER.debug("saveArticle {}", article);
		int id = articleService.saveArticle(article);
       LOGGER.info("End");
		return id;
	}
}

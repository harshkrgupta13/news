package com.cts.news.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.Article;
import com.cts.news.repository.ArticleRepository;

@Service
public class ArticleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
	@Autowired
	private ArticleRepository articleRepository;

	@Transactional
	public int saveArticle(Article article) {
		LOGGER.info("Start");
		LOGGER.debug("saveArticle {}", article);
	    articleRepository.save(article);
	    int id=article.getId();
	    LOGGER.info("End");
		  return id;

	}
}

package com.cts.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.service.ArticleService;
@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@PostMapping("/saveSource/{source}")
	public void saveSource(@PathVariable String source){
		articleService.saveSource(source);
	}
}

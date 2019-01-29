package com.cts.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.Language;
import com.cts.news.service.LanguageService;

@RestController
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@GetMapping("/getLanguages")
	public List<Language> getLanguages(Language language) {
		return languageService.getLanguages(language);
	}

}

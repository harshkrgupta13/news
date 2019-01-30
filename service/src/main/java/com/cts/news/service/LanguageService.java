package com.cts.news.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.Language;
import com.cts.news.repository.LanguageRepository;

@Service
public class LanguageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageService.class);
	
	@Autowired
	private LanguageRepository languageRepository;

	@Transactional
	public List<Language> getLanguages(Language language) {
		LOGGER.info("Start");
		LOGGER.debug("Languages from database :{}", languageRepository.findAll());
		LOGGER.info("End");
		return languageRepository.findAll();
	}

}

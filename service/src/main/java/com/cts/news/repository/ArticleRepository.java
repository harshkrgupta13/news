package com.cts.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cts.news.bean.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	void save(@Param(value="ar_source") String source);

}

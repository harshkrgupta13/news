package com.cts.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.news.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	public User findByEmail(String email);
}

package com.cts.news.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@NotNull(message = "User Name cannot be empty")
	@Column(name = "us_name")
	@Size(max = 50, message = "Name must not exceed 50 characters")
	private String name;

	@NotNull(message = "Email cannot be empty")
	@Size(max = 255, message = "Email must not exceed 255 characters")
	@Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid")
	@Column(name = "us_email")
	private String email;

	@NotNull(message = "Password cannot be empty")
	@Size(min = 6, max = 50, message = "Password must be 6 to 50 characters")
	@Column(name = "us_password")
	private String password;

	@Column(name = "us_blacklisted")
	private Boolean blacklisted;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_ur_id")
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_la_id")
	private Language language;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "favourite_article", joinColumns = { @JoinColumn(name = "fa_us_id") }, inverseJoinColumns = {
			@JoinColumn(name = "fa_ar_id") })
	private List<Article> article;

	public User(int id, String name, String email, String password, Boolean blacklisted, Role role, Language language,
			List<Article> article) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.blacklisted = blacklisted;
		this.role = role;
		this.language = language;
		this.article = article;
	}

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public Boolean getBlacklisted() {
		return blacklisted;
	}

	public void setBlacklisted(Boolean blacklisted) {
		this.blacklisted = blacklisted;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", language=" + language + ", article=" + article + "]";
	}

}

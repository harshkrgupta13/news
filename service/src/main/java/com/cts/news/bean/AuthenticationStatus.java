package com.cts.news.bean;

public class AuthenticationStatus {

	private boolean authenticated;
	private boolean isAdmin;
	private User user;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthenticationStatus() {
		super();

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public AuthenticationStatus(boolean authenticated) {
		super();
		this.authenticated = authenticated;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authenticated=" + authenticated + ", isAdmin=" + isAdmin + ", user=" + user
				+ ", token=" + token + "]";
	}

	
}

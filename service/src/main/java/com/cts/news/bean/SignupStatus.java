package com.cts.news.bean;

import com.cts.news.bean.SignupStatus;

public class SignupStatus {

	private boolean signupStatus;
	private String message;
	
	public boolean isSignupStatus() {
		return signupStatus;
	}

	public void setSignupStatus(boolean signupStatus) {
		this.signupStatus = signupStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SignupStatus(){
		
	}
	
	@Override
	public String toString() {
		return "SignupStatus [signupStatus=" + signupStatus + ", message=" + message + "]";
	}

	public boolean equals(Object o){
		SignupStatus s = (SignupStatus) o;
		return s.isSignupStatus()==this.signupStatus &&  this.message.equals(s.getMessage());
	}
}

package com.cts.news.bean;

import com.cts.news.bean.SignupStatus;

public class SignupStatus {

	private boolean signupStatus;

	public boolean isSignupStatus() {
		return signupStatus;
	}

	public void setSignupStatus(boolean signupStatus) {
		this.signupStatus = signupStatus;
	}

	public SignupStatus() {

	}

	@Override
	public String toString() {
		return "SignupStatus [signupStatus=" + signupStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (signupStatus ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignupStatus other = (SignupStatus) obj;
		if (signupStatus != other.signupStatus)
			return false;
		return true;
	}

	
}

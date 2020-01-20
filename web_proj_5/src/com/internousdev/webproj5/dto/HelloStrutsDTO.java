package com.internousdev.webproj5.dto;

public class HelloStrutsDTO {
	private int userId;
	private String userName;
	private String password;
	private String result;

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getResult() {
		return result;
	}
}

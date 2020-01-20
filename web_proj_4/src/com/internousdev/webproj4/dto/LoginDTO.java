package com.internousdev.webproj4.dto;

//	HelloStrutsDTOと被る。HelloStrutsDTOを使った方がいいのでは？
public class LoginDTO {
	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

package com.internousdev.webproj.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {
		return SUCCESS;
	}


//	setterを定義すると、クラスの初期化時にsetterが自動的に呼ばれる。
//	結果、JSPでユーザーが入力した値が初期状態でフィールドに格納される
//	コンストラクタと同じ？
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	いつ呼ばれる
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

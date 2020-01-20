package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.TestDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private String username;
	private String password;

	public String execute(){
		String ret = ERROR;
		TestDAO dao = new TestDAO();

//		登録した件数（１か０）が返る
		int count = dao.insert(username, password);

		if (count > 0) {
			ret = SUCCESS;
		}

		return ret;
	}

//	setterを定義すると、クラスの初期化時にsetterが自動的に呼ばれる。
//	結果、JSPでユーザーが入力した値が初期状態でフィールドに格納される
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

package com.internousdev.webproj2.action;

import com.internousdev.webproj2.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();

//		引数のusernameとpasswordで検索してデータがあった場合はtrue、無かった場合は、false
		boolean b = dao.select(username, password);

		if(b == true){
			ret = SUCCESS;
		}else{
			ret = ERROR;
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

package com.internousdev.login.action;

//	java.sqlはJavaSEの標準API
import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//	struts2が持つActionSupportというクラスを継承します。
//	（Actionクラスは基本的にこのクラスを継承します）
public class LoginAction extends ActionSupport {
	private String name;
	private String password;

	//	SQLExceptionは起きない？
	public String execute() throws SQLException {
//		ERROR、SUCCESSは、継承元ActionSupportの定数。
//		中にはそれぞれ"error"、"success"が格納されている。
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

//		JSPでユーザーが入力した値が初期状態でフィールドに格納されている
		dto = dao.select(name, password);
		if(name.equals(dto.getName())) {
			if(password.equals(dto.getPassword())){
				ret = SUCCESS ;
			}
		}
//		これにより、あらかじめstruts.xmlに遷移先として定義したそれぞれのJSPに振り分けられる
		return ret;
	}

	public String getName() {
		return name;
	}

//	setterを定義すると、クラスの初期化時にsetterが自動的に呼ばれる。
//	結果、JSPでユーザーが入力した値が初期状態でフィールドに格納される
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

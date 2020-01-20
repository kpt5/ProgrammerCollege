package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.TestDAO;
import com.internousdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private String username;
	private String password;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public String execute() {
		String ret = ERROR;
		TestDAO dao = new TestDAO();

//					登録した件数（１か０）を返す
		int count = dao.insert(username, password);

		if (count > 0) {
			ret = SUCCESS;
		} else {
//			いる？
			ret = ERROR;
		}

//						usernameとpasswordでusersテーブルを検索した結果をDTOのListに格納し、返却
		loginDTOList = dao.select(username, password);

//		登録（1件）に成功したら、SUCCESS、登録に失敗したらERRORを返却。
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

//	DBの問い合わせ結果が入ったデータを上書きすることになる
//	使わないが、慣例上記述
	public void setLoginDTOList(List<LoginDTO> loginDTOList) {
		this.loginDTOList = loginDTOList;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<LoginDTO> getLoginDTOList() {
		return loginDTOList;
	}
}

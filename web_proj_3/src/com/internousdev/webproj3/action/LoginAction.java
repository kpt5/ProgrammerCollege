package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.LoginDAO;
import com.internousdev.webproj3.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

//				DTOにDBの問い合わせ結果を格納して返却
		dto = dao.select(username, password);

//		上記のインスタンスメソッドでDBの問い合わせ結果があった場合は照合が不要。
//		なかった場合は一律「該当なし」の値がDTOに格納されている。
//		"該当なし"が格納されているかのチェックのみだと、ユーザー名とパスを"該当なし"で登録していた場合、SUCCESSになってしまう
//		データありフラグを持たせてチェックすれば？
		if (this.username.equals(dto.getUsername()) && this.password.equals(dto.getPassword())) {
			ret = SUCCESS;
		} else {
//			いる？
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

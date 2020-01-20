package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.LoginDAO;
import com.internousdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public String execute() {
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();

//						usernameとpasswordでusersテーブルを検索した結果をDTOのListに格納し、返却
		loginDTOList = dao.select(username, password);

//		上記のインスタンスメソッドによるDBの問い合わせ結果のうち、最初に取得されたデータ（行）と入力値を照合している
//		上記のインスタンスメソッドでDBの問い合わせ結果があった場合は照合が不要では？
//		なかった場合は一律「該当なし」の値がDTOに格納されている。
//		そのため、ユーザー名とパスを"該当なし"でログインした場合、DBになくてもSUCCESSになってしまう
//		とはいえ、"該当なし"が格納されているかのチェックのみだと、ユーザー名とパスを"該当なし"で登録していた場合、SUCCESSになってしまう
//		データありフラグを持たせてチェックすれば？HelloStrutsDTOを使えばresultが使える。
		if (this.username.equals(loginDTOList.get(0).getUsername()) && this.password.equals(loginDTOList.get(0).getPassword())) {
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

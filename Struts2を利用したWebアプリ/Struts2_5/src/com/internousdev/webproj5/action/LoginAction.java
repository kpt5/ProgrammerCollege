package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//セッション属性をMap<String, Object>で取得する
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.LoginDAO;
import com.internousdev.webproj5.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//Sessionとは
//ページ間で変数の内容を維持するための仕組みのことです。
//例えば、Aというページの変数の値を、Bというページでも使えるようにするときに使用します。
//クッキーとの違いは、クッキーがクライアント側（パソコン側）に様々な情報を保存させるのに対し、セッションは、サーバー側に様々な情報を保存させておきます。
//sessionをStruts2で利用する場合は、SessionAwareインターフェースを利用します。

//SessionAwareインターフェース
//SessionAwareインターフェースはStruts2で提供されているインターフェースです。
//セッションを利用したいアクションで、SessionAwareインターフェースを実装して使用します。
//実装すると、Mapでセッションオブジェクトにアクセスできます。

public class LoginAction extends ActionSupport implements SessionAware{
	private String username;
	private String password;

	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private Map<String, Object> session;

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
		if (this.username.equals(loginDTOList.get(0).getUsername())
			&& this.password.equals(loginDTOList.get(0).getPassword())) {

//			session.put("loginDTOList", loginDTOList);
			ret = SUCCESS;
		} else {
//			分岐の意味ない
//			session.put("loginDTOList", loginDTOList);
//			いる？
			ret = ERROR;
		}
		session.put("loginDTOList", loginDTOList);
		return ret;
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

//	初期化時以外で呼び出すと、DBの問い合わせ結果が入ったデータを上書きすることになる
//	implementsで記述必須。ページ間のセッションの受け渡し用。
//	setSessionにはセッションコンテキスト(HttpSession)相当のMapのオブジェクトが渡されます
//	これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}

package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//セッション属性をMap<String, Object>で取得する
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.TestDAO;
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

public class TestAction extends ActionSupport implements SessionAware {
	private String username;
	private String password;

	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private Map<String, Object> session;

	public String execute() {
		String ret = ERROR;
		TestDAO dao = new TestDAO();

//					登録した件数（１か０）を返す
		int count = dao.insert(username, password);

//		１か０以外があり得ないが、慣例上の記述
		if (count > 0) {
			ret = SUCCESS;
		} else {
//			いる？
			ret = ERROR;
		}

//						usernameとpasswordでusersテーブルを検索した結果をDTOのListに格納し、返却
		loginDTOList = dao.select(username, password);

		session.put("loginDTOList", loginDTOList);

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

//	初期化時以外で呼び出すと、DBの問い合わせ結果が入ったデータを上書きすることになる
//	implements SessionAwareで記述必須。ページ間のセッションの受け渡し用。
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

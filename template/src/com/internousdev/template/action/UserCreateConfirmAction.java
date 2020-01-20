package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

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

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> session;
	private String errorMessage;

//	未入力項目の有無を確認とセッションへの値の格納のみ
	public String execute() {
		String result = SUCCESS;

//		未入力項目の有無を確認
		if(!(loginUserId.equals(""))
		&& !(loginPassword.equals(""))
		&& !(userName.equals(""))) {
//			確認画面で表示したい値をセッションに格納
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
		} else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

//	setterを定義すると、クラスの初期化時にsetterが自動的に呼ばれる。
//	結果、JSPでユーザーが入力したフォームの値が初期状態でフィールドに格納される
//	フォームのnameの値とset～以降の文字列で連携する仕組み
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	implements SessionAwareで記述必須。ページ間のセッションの受け渡し用。
//	setSessionにはセッションコンテキスト(HttpSession)相当のMapのオブジェクトが渡されます
//	これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。
//	アノテーション：　コンパイラにとっても意味を持つコメント	？
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}

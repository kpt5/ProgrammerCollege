package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateCompleteDAO;
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

//UserCreateConfirmAction（userCreate.jsp）から引き継いでいるセッションの値をDBに登録（のみ）
public class UserCreateCompleteAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> session;

//	UserCreateConfirmAction（userCreate.jsp）から引き継いでいるセッション
//	session.put("loginUserId", loginUserId);
//	session.put("loginPassword", loginPassword);
//	session.put("userName", userName);

	public String execute(){

//		DAOを経由して、入力された内容をDBに登録します。
		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

//		toString()はオーバーライドしていないが大丈夫なのは？
		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
		session.get("loginPassword").toString(),
		session.get("userName").toString());

		String result = SUCCESS;
		return result;
	}

//	userCreateConfirm.jspから引き継がれるのはSessionのみで値は特に引き継がれない？
//	それなら以下のsetterとフィールドの意味は？
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
}

package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//セッション属性をMap<String, Object>で取得する
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.InquiryCompleteDAO;
import com.internousdev.webproj5.dto.InquiryDTO;
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

public class InquiryCompleteAction extends ActionSupport implements SessionAware {
	private String name;
	private String qtype;
	private String body;

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();
	private Map<String, Object> session;

	public String execute() {
		String ret = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();

//					登録した件数（１か０）を返す
		int count = dao.insert(name, qtype, body);

		if (count > 0) {
//								inquiryテーブルに格納されている全データをDTOのListに格納し、返却
			inquiryDTOList = dao.select();
			session.put("inquiryDTOList", inquiryDTOList);
			ret = SUCCESS;
		}

//		登録（1件）に成功したら、SUCCESS、登録に失敗したらERRORのまま返却。
		return ret;
	}

//	setterを定義すると、クラスの初期化時にsetterが自動的に呼ばれる。
//	結果、JSPでユーザーが入力した値が初期状態でフィールドに格納される
	public void setName(String name) {
		this.name = name;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public void setBody(String body) {
		this.body = body;
	}

//	初期化時以外で呼び出すと、DBの問い合わせ結果が入ったデータを上書きすることになる
//	implements SessionAwareで記述必須。ページ間のセッションの受け渡し用。
//	setSessionにはセッションコンテキスト(HttpSession)相当のMapのオブジェクトが渡されます
//	これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getName() {
		return name;
	}

	public String getQtype() {
		return qtype;
	}

	public String getBody() {
		return body;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}

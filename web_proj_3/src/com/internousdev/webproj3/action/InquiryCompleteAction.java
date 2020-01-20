package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.InquiryCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryCompleteAction extends ActionSupport{
	private String name;
	private String qtype;
	private String body;

	public String execute() {
		String ret = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();

//		登録した件数（１か０）が返る
		int count = dao.insert(name, qtype, body);

		if (count > 0) {
			ret = SUCCESS;
		}

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

	public String getName() {
		return name;
	}

	public String getQtype() {
		return qtype;
	}

	public String getBody() {
		return body;
	}
}

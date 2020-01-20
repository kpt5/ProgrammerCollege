package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.InquiryCompleteDAO;
import com.internousdev.webproj4.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryCompleteAction extends ActionSupport{
	private String name;
	private String qtype;
	private String body;
	private List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	public String execute() {
		String ret = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();

//					登録した件数（１か０）を返す
		int count = dao.insert(name, qtype, body);

		if (count > 0) {
//								inquiryテーブルに格納されている全データをDTOのListに格納し、返却
			inquiryDTOList = dao.select();
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

//	DBの問い合わせ結果が入ったデータを上書きすることになる
//	使わないが、慣例上記述
	public void setInquiryDTOList(List<InquiryDTO> inquiryDTOList) {
		this.inquiryDTOList = inquiryDTOList;
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

	public List<InquiryDTO> getInquiryDTOList() {
		return inquiryDTOList;
	}
}

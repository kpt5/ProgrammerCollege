package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.HelloStrutsDAO;
import com.internousdev.webproj3.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport {
	private String result;

	public String execute() {
		String ret = ERROR;
		HelloStrutsDAO dao = new HelloStrutsDAO();
		HelloStrutsDTO dto = new HelloStrutsDTO();

//				DTOにDBの問い合わせ結果を格納して返却
		dto = dao.select();

		System.out.println(dto.getResult());
		result = dto.getResult();

		if (result.equals("usersテーブルにデータがあります。")) {
//		if(result.equals("MySQLと接続できます。")){
			ret = SUCCESS;
		} else {
			ret = ERROR;
		}

		return ret;
	}

//	DBの問い合わせ結果が入ったデータを上書きすることになる
//	使わないが、慣例上記述
	public void setResult(String result) {
		this.result = result;
	}

//	dto.getResult()と機能が被る
//	呼び出し先のJSPで使うから意味がある。値の受け渡し用。
	public String getResult() {
		return result;
	}
}

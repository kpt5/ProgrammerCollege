package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.HelloStrutsDAO;
import com.internousdev.webproj4.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport {

	private List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	public String execute() {
		String ret = ERROR;
		HelloStrutsDAO dao = new HelloStrutsDAO();

//								usersテーブルに格納されている全データをDTOのListに格納して、返却
		helloStrutsDTOList = dao.select();

//		usersテーブルに一行でもデータがあった場合
		if (helloStrutsDTOList.size() > 0) {
			ret = SUCCESS;
		} else {
//			いる？
			ret = ERROR;
		}

		return ret;
	}

//	DBの問い合わせ結果が入ったデータを上書きすることになる
//	使わないが、慣例上記述
	public void setHelloStrutsDTOList(List<HelloStrutsDTO> helloStrutsDTOList) {
		this.helloStrutsDTOList = helloStrutsDTOList;
	}

//	呼び出し先のJSPで使う。値の受け渡し用。
	public List<HelloStrutsDTO> getHelloStrutsDTOList() {
		return helloStrutsDTOList;
	}
}

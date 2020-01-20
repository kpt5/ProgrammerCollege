package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//セッション属性をMap<String,Object>で取得する
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.HelloStrutsDAO;
import com.internousdev.webproj5.dto.HelloStrutsDTO;
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

public class HelloStrutsAction extends ActionSupport implements SessionAware {

	private List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();
	private Map<String, Object> session;

	public String execute() {
		String ret = ERROR;
		HelloStrutsDAO dao = new HelloStrutsDAO();
//								usersテーブルに格納されている全データをDTOのListに格納して、返却
		helloStrutsDTOList = dao.select();

//		usersテーブルに一行でもデータがあった場合
		if (helloStrutsDTOList.size() > 0) {
			session.put("helloStrutsDTOList", helloStrutsDTOList);
			ret = SUCCESS;
		}else{
//			いる？
			ret = ERROR;
		}

		return ret;
	}

//	初期化時以外で呼び出すと、DBの問い合わせ結果が入ったデータを上書きすることになる
//	implementsで記述必須。ページ間のセッションの受け渡し用。
//	setSessionにはセッションコンテキスト(HttpSession)相当のMapのオブジェクトが渡されます
//	これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

//	呼び出し先のJSPで使う。値の受け渡し用。
	public Map<String, Object> getSession() {
		return session;
	}
}

package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
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

//ActionSupportを継承しているのは定数SUCCESSなどを使うためだけ？
public class LoginAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String, Object> session;

	public String execute() {
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();

		result = ERROR;

//		入力値からユーザー情報の検索を行います。
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
//		インスタンス化しないでも使える?
		session.put("loginUser", loginDTO);

//		sessionから取り出した値をLoginDTOの型に変換しています。型変換必要？
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;
//			ログイン認証が成功した場合、次の画面で「商品情報」が必要なため商品情報を取得します。
//			インスタンス化しないでも使える?インスタンス化との違いは？
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//			ログインしているユーザーのIDをloginUserとlogin_user_idの２つでもっているが？
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			return result;
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

//	implementsで記述必須。ページ間のセッションの受け渡し用。
//	setSessionにはセッションコンテキスト(HttpSession)相当のMapのオブジェクトが渡されます
//	これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。
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

	public Map<String, Object> getSession() {
		return session;
	}
}

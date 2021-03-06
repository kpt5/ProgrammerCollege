package com.internousdev.template.action;

//SQLException使っていない
//import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

//	BuyItemConfirmAction（buyItemComplete.jsp）から引き継ぐセッション
//	session.put("loginUser", loginDTO);
//	session.put("login_user_id", loginDTO.getLoginId());
//	session.put("id", buyItemDTO.getId());
//	session.put("buyItem_name", buyItemDTO.getItemName());
//	session.put("buyItem_price", buyItemDTO.getItemPrice());
//	session.put("stock", stock);
//	個数と単価をかけて、buyItem_priceの値を上書き
//	session.put("buyItem_price", intStock * intPrice);
//	session.put("pay", payment);

	private String deleteFlg;
	private String result;

	public String execute(){
		MyPageDAO myPageDAO = new MyPageDAO();
		MyPageDTO myPageDTO = new MyPageDTO();

		// 商品履歴を削除しない場合
		if(deleteFlg == null) {
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();

			myPageDTO = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);

//			同じ値で上書きするだけでは？
			session.put("buyItem_name", myPageDTO.getItemName());

//			sessionのbuyItem_priceと同じになり二重管理
			session.put("total_price", myPageDTO.getTotalPrice());

//			sessionのstockと同じになり二重管理
			session.put("total_count", myPageDTO.getTotalCount());

//			sessionのpayと同じになり二重管理
			session.put("total_payment", myPageDTO.getPayment());
			session.put("message", "");
		// 商品履歴を削除する場合
		} else if(deleteFlg.equals("1")) {
			delete();
		}
		result = SUCCESS;
		return result;
	}

	public void delete(){
		MyPageDAO myPageDAO = new MyPageDAO();
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

		if(res > 0) {
			session.put("message", "商品情報を正しく削除しました。");

		} else if(res == 0) {
			session.put("message", "商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

//	implements SessionAwareで記述必須。ページ間のセッションの受け渡し用。
//	setSessionにはセッションコンテキスト(HttpSession)相当のMapのオブジェクトが渡されます
//	これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。
//	アノテーション：　コンパイラにとっても意味を持つコメント	？
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}

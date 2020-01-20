package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

//	BuyItemAction（buyItemConfirm.jsp）で持つことになったセッション
//	session.put("loginUser", loginDTO);
//	session.put("login_user_id", loginDTO.getLoginId());
//	session.put("id", buyItemDTO.getId());
//	session.put("buyItem_name", buyItemDTO.getItemName());
//	session.put("buyItem_price", buyItemDTO.getItemPrice());
//	session.put("stock", stock);
//	個数と単価をかけて、buyItem_priceの値を上書き
//	session.put("buyItem_price", intStock * intPrice);
//	session.put("pay", payment);

//	sessionの値をuser_buy_item_transactionへの注文情報（1商品のみ）として書き込み
	public String execute() {
		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

//		user_buy_item_transactionへの注文情報（1商品のみ）の書き込み
//		BuyItemCompleteDAO.buyItemeInfoの引数の変数名と異なっていても型が同じであれば大丈夫です。
//		toString()？
		buyItemCompleteDAO.buyItemInfo(
			session.get("id").toString(),
			session.get("login_user_id").toString(),
			session.get("buyItem_price").toString(),
			session.get("stock").toString(),
			session.get("pay").toString());

		String result = SUCCESS;
		return result;
	}

//	implementsで記述必須。ページ間のセッションの受け渡し用。
//	setSessionにはセッションコンテキスト(HttpSession)相当のMapのオブジェクトが渡されます
//	これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。
//	アノテーション：　コンパイラにとっても意味を持つコメント
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}

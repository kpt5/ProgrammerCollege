package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

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
public class BuyItemAction extends ActionSupport implements SessionAware {
	private int stock;
	private String pay;
	private Map<String, Object> session;

//	LoginAction（buyItem.jsp）で持つことになったセッション
//	session.put("login_user_id", loginDTO.getLoginId());
//	session.put("id", buyItemDTO.getId());
//	session.put("buyItem_name", buyItemDTO.getItemName());
//	session.put("buyItem_price", buyItemDTO.getItemPrice());

	private String result;

//	sessionへのキーと値の追加と上書きがメイン
	public String execute() {
		result = SUCCESS;

		session.put("stock", stock);
//		toString()の必要性は？stockそのままじゃダメ？
		int intStock = Integer.parseInt(session.get("stock").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());

//		個数と単価をかけて、buyItem_priceの値を上書き
		session.put("buyItem_price", intStock * intPrice);

//		この変数いる？
		String payment;

//		session.put("pay", pay);はだめ？
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay", payment);
		} else {
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

//	setterを定義すると、クラスの初期化時にsetterが自動的に呼ばれる。
//	結果、JSPでユーザーが入力した値が初期状態でフィールドに格納される
//	フォームのnameの値とset～以降の文字列で連携する仕組み
	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

//	implementsで記述必須。ページ間のセッションの受け渡し用。
//	setSessionにはセッションコンテキスト(HttpSession)相当のMapのオブジェクトが渡されます
//	これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。
//	アノテーション：　コンパイラにとっても意味を持つコメント
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getStock() {
		return stock;
	}

	public String getPay() {
		return pay;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}

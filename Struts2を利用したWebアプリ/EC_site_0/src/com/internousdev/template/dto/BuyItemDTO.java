package com.internousdev.template.dto;

public class BuyItemDTO {

//	テーブルカラムに対応したフィールド変数を宣言
	private int id;
	private String itemName;
//	intじゃだめ？
	private String itemPrice;

//	MariaDB [template]> DESC item_info_transaction;
//	+-------------+-------------+------+-----+---------+----------------+
//	| Field       | Type        | Null | Key | Default | Extra          |
//	+-------------+-------------+------+-----+---------+----------------+
//	| id          | int(11)     | NO   | PRI | NULL    | auto_increment |
//	| item_name   | varchar(30) | YES  |     | NULL    |                |
//	| item_price  | int(11)     | YES  |     | NULL    |                |
//	| item_stock  | int(11)     | YES  |     | NULL    |                |
//	| insert_date | datetime    | YES  |     | NULL    |                |
//	| update_date | datetime    | YES  |     | NULL    |                |
//	+-------------+-------------+------+-----+---------+----------------+

//	フィールド変数に対応したGetter・Setterを定義
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public int getId() {
		return id;
	}
}

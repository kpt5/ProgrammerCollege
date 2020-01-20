package com.internousdev.login.dto;

//	DAOクラスでDBから取得した値をActionへ戻す時、値を格納するために利用されます。
//	DTOクラスには、テーブルのデータのカラムに対応したフィールド変数とgetter/setterのみを定義します。
public class LoginDTO {

//	テーブルから取得するデータに対応したフィールド変数を宣言
	private int id;
	private String name;
	private String password;

//	フィールド変数に対応したgetter とsetterを定義
//	setter：　DAOクラスから呼び出され、テーブルの値を自身（DTO）のフィールドに格納
//	getter：　Actionクラスから呼び出されActionへ値を渡す
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

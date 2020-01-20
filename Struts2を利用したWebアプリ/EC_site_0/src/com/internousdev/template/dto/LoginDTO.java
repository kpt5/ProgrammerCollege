package com.internousdev.template.dto;

public class LoginDTO {

	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;

//	MariaDB [template]> DESC login_user_transaction;
//	+--------------+-------------+------+-----+---------+----------------+
//	| Field        | Type        | Null | Key | Default | Extra          |
//	+--------------+-------------+------+-----+---------+----------------+
//	| id           | int(11)     | NO   | PRI | NULL    | auto_increment |
//	| login_id     | varchar(16) | YES  | UNI | NULL    |                |
//	| login_pass   | varchar(16) | YES  |     | NULL    |                |
//	| user_name    | varchar(50) | YES  |     | NULL    |                |
//	| insert_date  | datetime    | YES  |     | NULL    |                |
//	| updated_date | datetime    | YES  |     | NULL    |                |
//	+--------------+-------------+------+-----+---------+----------------+

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}
}

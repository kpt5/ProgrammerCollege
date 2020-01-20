package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//SQLException使ってない
//import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class UserCreateCompleteDAO {

	public void createUser(String loginUserId, String loginUserPassword, String userName) {

		DateUtil dateUtil = new DateUtil();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql= "INSERT INTO login_user_transaction (login_id, login_pass, user_name, insert_date) VALUES(?, ? ,?, ?)";

//		MariaDB [template]> DESC login_user_transaction;
//		+--------------+-------------+------+-----+---------+----------------+
//		| Field        | Type        | Null | Key | Default | Extra          |
//		+--------------+-------------+------+-----+---------+----------------+
//		| id           | int(11)     | NO   | PRI | NULL    | auto_increment |
//		| login_id     | varchar(16) | YES  | UNI | NULL    |                |
//		| login_pass   | varchar(16) | YES  |     | NULL    |                |
//		| user_name    | varchar(50) | YES  |     | NULL    |                |
//		| insert_date  | datetime    | YES  |     | NULL    |                |
//		| updated_date | datetime    | YES  |     | NULL    |                |
//		+--------------+-------------+------+-----+---------+----------------+

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, dateUtil.getDate());
			ps.execute();

		} catch(Exception e) {
			e.printStackTrace();

		} finally {

			try {
				con.close();

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

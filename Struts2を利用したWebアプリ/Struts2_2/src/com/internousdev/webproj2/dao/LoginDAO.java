package com.internousdev.webproj2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnector;

public class LoginDAO {
	public String username;
	public String password;

	public boolean select(String username, String password) {
		boolean ret = false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from users where user_name=? and password=?";

//		MariaDB [testdb]> DESC users;
//		+-----------+--------------+------+-----+---------+----------------+
//		| Field     | Type         | Null | Key | Default | Extra          |
//		+-----------+--------------+------+-----+---------+----------------+
//		| user_id   | int(11)      | NO   | PRI | NULL    | auto_increment |
//		| user_name | varchar(255) | YES  |     | NULL    |                |
//		| password  | varchar(255) | YES  |     | NULL    |                |
//		+-----------+--------------+------+-----+---------+----------------+

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

//			引数のusernameとpasswordで検索してデータがあった場合はtrue、無かった場合は、false
			if (rs.next()) {
				this.username = rs.getString("user_name");
				this.password = rs.getString("password");
				ret = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
}

package com.internousdev.webproj3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj3.dto.LoginDTO;
import com.internousdev.webproj3.util.DBConnector;

public class LoginDAO {
	public String username;
	public String password;

	public LoginDTO select(String username,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();

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
//			DTOにDBの問い合わせ結果を格納
			if (rs.next()) {
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
			}else{
				dto.setUsername("該当なし");
				dto.setPassword("該当なし");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}
}

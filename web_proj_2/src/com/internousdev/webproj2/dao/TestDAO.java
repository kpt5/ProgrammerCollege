package com.internousdev.webproj2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnector;

public class TestDAO {

	public int insert(String username, String password) {
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into users(user_name, password) values(?,?)";

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
			int i = ps.executeUpdate();

			if (i > 0) {
				System.out.println(i + "件登録されました");
				ret = i;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		登録した件数（１しかありえない）を返す
		return ret;
	}
}

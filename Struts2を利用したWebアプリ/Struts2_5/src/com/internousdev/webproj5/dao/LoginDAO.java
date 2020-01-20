package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.LoginDTO;
import com.internousdev.webproj5.util.DBConnector;

public class LoginDAO {

	public String username;
	public String password;

	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public List<LoginDTO> select(String username, String password) {
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

//			引数のusernameとpasswordでusersテーブル検索して、行単位でDTOに格納し、
//			その各行データ（DOT）をDTOのListに格納
//			2件以上のデータが返ってくることもあり得る
			while (rs.next()) {
				LoginDTO dto = new LoginDTO();
				dto.setUsername(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				loginDTOList.add(dto);
			}

//			一件もデータを取ってこれなかった場合は"該当なし"をDTOに格納する
//			loginDTOList.size() < 0　の場合はあり得ないが、慣例上の記述
			if (loginDTOList.size() <= 0) {
				LoginDTO dto = new LoginDTO();
				dto.setUsername("該当なし");
				dto.setPassword("該当なし");
				loginDTOList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		usernameとpasswordでusersテーブルを検索した結果をDTOのListに格納し、返却
		return loginDTOList;
	}
}

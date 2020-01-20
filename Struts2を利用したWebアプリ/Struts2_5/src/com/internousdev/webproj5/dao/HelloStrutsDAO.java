package com.internousdev.webproj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.HelloStrutsDTO;
import com.internousdev.webproj5.util.DBConnector;

public class HelloStrutsDAO {

	List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

	public List<HelloStrutsDTO> select() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from users";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

//			usersテーブルに格納されたデータを、行単位でDTOに格納し、
//			その各行データ（DTO）をDTOのListに格納
			while(rs.next()) {
				HelloStrutsDTO dto = new HelloStrutsDTO();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
//				dto.setResult("MySQLと接続できます。");
				dto.setResult("usersテーブルにデータがありました。");
				helloStrutsDTOList.add(dto);
			}

//			MariaDB [testdb]> DESC users;
//			+-----------+--------------+------+-----+---------+----------------+
//			| Field     | Type         | Null | Key | Default | Extra          |
//			+-----------+--------------+------+-----+---------+----------------+
//			| user_id   | int(11)      | NO   | PRI | NULL    | auto_increment |
//			| user_name | varchar(255) | YES  |     | NULL    |                |
//			| password  | varchar(255) | YES  |     | NULL    |                |
//			+-----------+--------------+------+-----+---------+----------------+

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		usersテーブルに格納されている全データをDTOのListに格納し、返却
		return helloStrutsDTOList;
	}
}

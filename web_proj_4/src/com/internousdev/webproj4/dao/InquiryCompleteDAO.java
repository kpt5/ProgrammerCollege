package com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dto.InquiryDTO;
import com.internousdev.webproj4.util.DBConnector;

public class InquiryCompleteDAO {

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	public List<InquiryDTO> select() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from inquiry";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

//			inquiryテーブルに格納されたデータを、行単位でDTOに格納し、
//			その各行データ（DOT）をDTOのListに格納
			while(rs.next()) {
				InquiryDTO dto = new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}

//			MariaDB [testdb]> DESC inquiry;
//			+-------+--------------+------+-----+---------+-------+
//			| Field | Type         | Null | Key | Default | Extra |
//			+-------+--------------+------+-----+---------+-------+
//			| name  | varchar(255) | YES  |     | NULL    |       |
//			| qtype | varchar(255) | YES  |     | NULL    |       |
//			| body  | varchar(255) | YES  |     | NULL    |       |
//			+-------+--------------+------+-----+---------+-------+

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		inquiryテーブルに格納されている全データをDTOのListに格納し、返却
		return inquiryDTOList;
	}

	public int insert(String name, String qtype, String body) {
		int ret = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into inquiry values(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, qtype);
			ps.setString(3, body);

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

//		登録した件数（１か０）を返す
		return ret;
	}
}

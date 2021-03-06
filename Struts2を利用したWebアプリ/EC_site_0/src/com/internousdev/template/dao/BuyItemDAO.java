package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class BuyItemDAO {

	public BuyItemDTO getBuyItemInfo() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		BuyItemDTO buyItemDTO = new BuyItemDTO();

		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";

//		MariaDB [template]> DESC item_info_transaction;
//		+-------------+-------------+------+-----+---------+----------------+
//		| Field       | Type        | Null | Key | Default | Extra          |
//		+-------------+-------------+------+-----+---------+----------------+
//		| id          | int(11)     | NO   | PRI | NULL    | auto_increment |
//		| item_name   | varchar(30) | YES  |     | NULL    |                |
//		| item_price  | int(11)     | YES  |     | NULL    |                |
//		| item_stock  | int(11)     | YES  |     | NULL    |                |
//		| insert_date | datetime    | YES  |     | NULL    |                |
//		| update_date | datetime    | YES  |     | NULL    |                |
//		+-------------+-------------+------+-----+---------+----------------+

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//	next()：次の行にデータが存在していれば true、存在しなければ false
			//	（最初は0行目の次の行＝1行目を見る）
			//	if (rs.next())なので一行分で終了。複数個商品があっても一番最初の商品しか取得できない。
			//	DBから取得した情報を、buyItemDTOクラスのsetterを利用して、DTOクラスに格納します。
			if(rs.next()) {
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
//				int(11) で定義されているのにgetString？
				buyItemDTO.setItemPrice(rs.getString("item_price"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return buyItemDTO;
	}
}

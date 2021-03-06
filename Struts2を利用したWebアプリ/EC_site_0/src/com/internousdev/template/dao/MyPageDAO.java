package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {

//	呼び出し元のMyPageActionのexecute()
//	String item_transaction_id = session.get("id").toString();
//	String user_master_id = session.get("login_user_id").toString();
//
//	myPageDTO = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);

	public MyPageDTO getMyPageUserInfo(String item_transaction_id, String user_master_id) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		MyPageDTO myPageDTO = new MyPageDTO();

		String sql = "SELECT iit.item_name, ubit.total_price, ubit.total_count, ubit.pay FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY ubit.insert_date DESC";

//		テーブル結合をしています。
//		iitとは：item_info_transaction テーブルを再定義したもの

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

//		ubitとは：user_buy_item_transaction テーブルを再定義したもの

//		MariaDB [template]> DESC  user_buy_item_transaction;
//		+---------------------+-------------+------+-----+---------+----------------+
//		| Field               | Type        | Null | Key | Default | Extra          |
//		+---------------------+-------------+------+-----+---------+----------------+
//		| id                  | int(11)     | NO   | PRI | NULL    | auto_increment |
//		| item_transaction_id | int(11)     | YES  |     | NULL    |                |
//		| total_price         | int(11)     | YES  |     | NULL    |                |
//		| total_count         | int(11)     | YES  |     | NULL    |                |
//		| user_master_id      | varchar(16) | YES  |     | NULL    |                |
//		| pay                 | varchar(30) | YES  |     | NULL    |                |
//		| insert_date         | datetime    | YES  |     | NULL    |                |
//		| delete_date         | datetime    | YES  |     | NULL    |                |
//		+---------------------+-------------+------+-----+---------+----------------+

//		LEFT JOIN = LEFT OUTER JOIN = 左外部結合（FROM直後のテーブルが基準）

//		SELECT
//			iit.item_name,
//			ubit.total_price,
//			ubit.total_count,
//			ubit.pay
//		FROM
//			user_buy_item_transaction ubit
//		LEFT JOIN
//			item_info_transaction iit
//		ON
//			ubit.item_transaction_id = iit.id
//		WHERE
//			ubit.item_transaction_id = ?　　商品ID	これいる？
//		AND
//			ubit.user_master_id = ?
//		ORDER BY
//			ubit.insert_date DESC	最近順	これいる？

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs = ps.executeQuery();

			//	next()：次の行にデータが存在していれば true、存在しなければ false
			//	（最初は0行目の次の行＝1行目を見る）
			//	if (rs.next())なので一行分で終了。login_idはユニークなので０か1件しかありえない。
			//	DBから取得した情報を、buyItemDTOクラスのsetterを利用して、DTOクラスに格納します。
			if(rs.next()) {
				myPageDTO.setItemName(rs.getString("item_name"));
				myPageDTO.setTotalPrice(rs.getString("total_price"));
				myPageDTO.setTotalCount(rs.getString("total_count"));
				myPageDTO.setPayment(rs.getString("pay"));
			}

		} catch(Exception e) {
			e.printStackTrace();

		} finally {

			try {
				con.close();

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return myPageDTO;
	}

	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

//		削除条件にitem_transaction_id　商品ID	いる？
		String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";

//		MariaDB [template]> DESC  user_buy_item_transaction;
//		+---------------------+-------------+------+-----+---------+----------------+
//		| Field               | Type        | Null | Key | Default | Extra          |
//		+---------------------+-------------+------+-----+---------+----------------+
//		| id                  | int(11)     | NO   | PRI | NULL    | auto_increment |
//		| item_transaction_id | int(11)     | YES  |     | NULL    |                |
//		| total_price         | int(11)     | YES  |     | NULL    |                |
//		| total_count         | int(11)     | YES  |     | NULL    |                |
//		| user_master_id      | varchar(16) | YES  |     | NULL    |                |
//		| pay                 | varchar(30) | YES  |     | NULL    |                |
//		| insert_date         | datetime    | YES  |     | NULL    |                |
//		| delete_date         | datetime    | YES  |     | NULL    |                |
//		+---------------------+-------------+------+-----+---------+----------------+

//		なぜtryの外で宣言？
		PreparedStatement ps;
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			result = ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				con.close();

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

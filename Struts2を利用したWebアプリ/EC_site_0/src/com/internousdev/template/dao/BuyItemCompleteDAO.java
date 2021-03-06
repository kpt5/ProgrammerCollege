package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class BuyItemCompleteDAO {

//	呼び出し元のBuyItemConfirmActionのexecute()
//	buyItemCompleteDAO.buyItemInfo(
//			session.get("id").toString(),
//			session.get("login_user_id").toString(),
//			session.get("buyItem_price").toString(),
//			session.get("stock").toString(),
//			session.get("pay").toString());

//	user_buy_item_transactionへの注文情報（1商品のみ）の書き込み
	public void buyItemInfo(String item_transaction_id, String user_master_id, String total_price, String total_count, String pay) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

		String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?, ?, ?, ?, ?, ?)";

//		INSERT INTO		user_buy_item_transaction
//			(item_transaction_id,	商品ID
//			total_price,
//			total_count,
//			user_master_id,
//			pay,
//			insert_date)
//		VALUES(?, ?, ?, ?, ?, ?)

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

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());

//			このPreparedStatementオブジェクトの、あらゆる種類のSQL文を実行します。
//			戻り値はboolean
//			executeメソッドは、executeQueryとexecuteUpdateの両方の役割として使うことができる。
//			executeQueryのように使われて「検索結果がある」ときはtrueを返す。
//			executeQueryのように使われて「検索結果がない」ときはfalseを返す。
//			executeUpdateのように使われたときはfalseを返す。
			ps.execute();

//			executeQuery()
//			SELECT文などの問い合わせ文を送信する場合に使われ、
//			ResultSetオブジェクトに実行結果を格納して返す。
//			SQL文の実行結果が何も返さなかった場合でも、nullを返すことはなく、
//			空のResultSetオブジェクトを返す。
//			ResultSetを利用すれば、問い合わせで得られたデータ にアクセス可能である。
//			executeUpdate()
//			このPreparedStatementオブジェクトのSQL文を実行します。
//			それはSQLデータ操作言語(DML)文(INSERT文、UPDATE文、DELETE文など)であるか、
//			DDL文（表の作成、削除）のような何も返さないSQL文でなければなりません。戻り値はint

		} catch(SQLException e) {
			e.printStackTrace();

		} finally {

//			 データベースへの接続のクローズでは、以下の処理が必要になる。
//
//			    ResultSetオブジェクトのクローズ処理
//			    Statementオブジェクトのクローズ処理
//			    データベースへの接続を切断する処理
//
//			データベースリソースを閉じるためには、上記に 示す処理が必要になり、
//			具体的には、Connection オブジェクト、Statementオブジェクト、ResultSet オブジェクト
//			のそれぞれを閉じる必要がある。 これらは、以下のような処理によりおこなわれる。
//
//			result.close();
//			st.close();
//			con.close();

			try {
				con.close();

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

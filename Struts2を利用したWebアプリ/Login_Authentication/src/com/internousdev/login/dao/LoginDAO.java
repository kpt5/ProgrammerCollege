package com.internousdev.login.dao;

//	java.sqlはJavaSEの標準API
//	DBMSへの接続と切断の際に利用
import java.sql.Connection;
//	SQL文を送信する際に利用
import java.sql.PreparedStatement;
//	DBMSから検索結果を受け取る際に利用
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;


public class LoginDAO {
	//	SQLExceptionは起きない？
	public LoginDTO select(String name, String password) throws SQLException{

//		DBから取得した値を格納するために利用します。
		LoginDTO dto = new LoginDTO();

		//	データベース接続の確立
		//	DBConnector のインスタンス化をして、DBConnectorのgetConnection を呼びだして、 MySQLサーバ にログイン
		//	DB と会話する為のインスタンス。プログラムとデータベースを結ぶパイプ。
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//	?はプレースホルダと言ってその都度違うデータを入れていきたい時に使用します。
		//	文字列の一部を他の文字列に置換する代替物。
		String sql = "select * from user where user_name=? and password=?";

		//	try～catch は Java のException系例外の為の構文
		//	try の中にはException系例外が発生しそうな処理を書きます。
		try {

			//	SQL文のひな形を準備する
			//	PreparedStatement とは SQLを運ぶ箱
			PreparedStatement ps = con.prepareStatement(sql);

			//	パラメータ（プレースホルダ）番号を指定して、SQL文のひな形に値を流し込む
			//	全てのパラメータ（プレースホルダ）に値を流し込む必要がある
			ps.setString(1, name);
			ps.setString(2, password);

			//	executeQuery()はselect文の実行メソッドで、必ず ResultSet オブジェクトが返ってきます。
			//	ResultSet オブジェクトは、検索結果が入る箱。
			ResultSet rs = ps.executeQuery();

			//	next()：次の行にデータが存在していれば true、存在しなければ false
			//	（最初は0行目の次の行＝1行目を見る）
			//	if (rs.next())なので一行分で終了。
			//	DBから取得した情報を、LoginDTOクラスのsetterを利用して、DTOクラスに格納します。
			if(rs.next()) {
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
			}

//		SQL関連のエラー
		} catch (SQLException e) {
			e.printStackTrace();

//
		} finally {

//			データベースとの接続を終了。これをしないとデータベースを接続したまま次の作業が実行されてしまい、
//			メモリに負荷がかかりますので、終わりには必ず終了をするようにして下さい。
			con.close();
		}
		return dto;
	}
}

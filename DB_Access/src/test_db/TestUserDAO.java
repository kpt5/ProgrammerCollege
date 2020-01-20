package test_db;

//	java.sqlはJavaSEの標準API
//	DBMSへの接続と切断の際に利用
import java.sql.Connection;
//	SQL文を送信する際に利用
import java.sql.PreparedStatement;
//	DBMSから検索結果を受け取る際に利用
import java.sql.ResultSet;
import java.sql.SQLException;

//	DBの操作（JDBCプログラム）を専任するクラス
//	デザインパターンをまとめたJ2EEデザインパターンの一つ、DAOパターン
//	クラス名は「テーブル名＋DAO」とする
//	基本的に、DAOはMVCのModelのクラス（～Logicクラス）から呼び出す。
//	基本的に、DAOはサーブレットクラスやJSPファイルからは呼び出されない。
public class TestUserDAO {
	String name = "";
	String password = "";

	public void select(String name, String password) {

		//	データベース接続の確立
		//	DBConnector のインスタンス化をして、DBConnectorのgetConnection を呼びだして、 MySQLサーバ にログイン
		//	DB と会話する為のインスタンス。プログラムとデータベースを結ぶパイプ。
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//	?はプレースホルダと言ってその都度違うデータを入れていきたい時に使用します。
		//	文字列の一部を他の文字列に置換する代替物。
		String sql = "select * from test_table where user_name=? and password=?";

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
			if (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
			} else {
				System.out.println("該当するデータはありませんでした");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			//	データベースとの接続を終了。これをしないとデータベースを接続したまま次の作業が実行されてしまい、
			//	メモリに負荷がかかりますので、終わりには必ず終了をするようにして下さい。
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectAll() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from test_table";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//	select文は、executeQueryで実行
			ResultSet rs = ps.executeQuery();

			//	next()：次の行にデータが存在していれば true、存在しなければ false
			//	（最初は0行目の次の行＝1行目を見る）
			//	while (rs.next())とはカーソルを１行ずつ移動していき、データがなくなったら実行を終了という意味。
			int flg = 0;
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				flg += 1;
			}
			if (flg == 0) {
				System.out.println("該当するデータはありませんでした");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectByName(String name) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from test_table where user_name=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			//	select文は、executeQueryで実行
			ResultSet rs = ps.executeQuery();

			int flg = 0;
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				flg += 1;
			}
			if (flg == 0) {
				System.out.println("該当するデータはありませんでした");
			}

			//			System.out.println(rs.getRow());	XX

			//			if (rs.getString("user_name").equals(null)){
			//				System.out.println("該当するデータはありませんでした");
			//			}

			//			if (!rs.next()) {
			//					System.out.println("該当するデータはありませんでした");
			//			}	XX

		} catch (SQLException e) {
			e.printStackTrace();
			//	System.out.println("該当するデータはありませんでした");
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectByPassword(String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from test_table where password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			//	select文は、executeQueryで実行
			ResultSet rs = ps.executeQuery();

			int flg = 0;
			while (rs.next()) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				flg += 1;
			}
			if (flg == 0) {
				System.out.println("該当するデータはありませんでした");
			}

			//			System.out.println(rs.getRow());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUserNameByUserName(String oldName, String newName) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update test_table set user_name=? where user_name=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, oldName);

			//	Insert・Delete・Update文は、updateQuery で実行
			//	executeUpdate()は変更した行数(数値）を返す。
			int i = ps.executeUpdate();

			if (i > 0) {
				System.out.println(i + "件更新されました");
			} else {
				System.out.println("該当するデータがありませんでした");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(int user_id, String name, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into test_table values(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setString(2, name);
			ps.setString(3, password);

			//	Insert・Delete・Update文は、updateQuery で実行
			int i = ps.executeUpdate();

			//	1か0
			if (i > 0) {
				System.out.println(i + "件登録されました");
			} else if (i == 0) {
				System.out.println("該当するデータがありませんでした");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String name) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from test_table where user_name=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);

			//	Insert・Delete・Update文は、updateQuery で実行
			int i = ps.executeUpdate();

			//	1か0
			if (i > 0) {
				System.out.println(i + "件削除されました");
			} else if (i == 0) {
				System.out.println("該当するデータがありませんでした");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

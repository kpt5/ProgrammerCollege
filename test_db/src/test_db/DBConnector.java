package test_db;

//	java.sqlはJavaSEの標準API
//	DBMSへの接続と切断の際に利用
import java.sql.Connection;
//	DBMSへの接続準備のために利用する
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	//	JDBCドライバの完全限定名（DBMSごとに固有）
	//	JDBCドライバ：Java とデータベースを繋げる工具箱の様な物。
	//	データベースを操作するために必要となるクラスやインターフェース群。
	//	DBMSの開発元がJARファイルとして提供している。
	//	java.sqlパッケージのクラスやインターフェースを介して間接的に利用する。
	//	JDBCドライバをApache Tomcat内の「lib」に配置（「C:¥pleiades¥tomcat¥9（バージョン番号）¥lib」）
//	staticはなぜ？
	private static String driverName = "com.mysql.jdbc.Driver";

	//	JDBC URL：データベース接続先を指定する文字列（DBMSごとに指定された書き方）
	//	"jdbc:（製品名）:（接続先データベース名）"という書き方が多い。
	//	localhost（自分の使っている PC)testdb(データベース名)を使います。？以降はオプション
	private static String url = "jdbc:mysql://localhost/testdb?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String password = "mysql";

	//	接続状態にする
	public Connection getConnection() {

		//	一度状態を初期化にしています。
		Connection con = null;

		//	try～catch は Java のException系例外の為の構文
		//	try の中にはException系例外が発生しそうな処理を書きます。
		try {

			//	ここでは、ドライバーがロードされ使えるような状態にしています。
			//	JDBCドライバのJARファイル内にあるドライバクラスをJVMに読み込み、有効化させる
			//	データベースにアクセスする前に1度だけやっておけばよい処理
			Class.forName(driverName);

			//	データベース接続の確立
			//	java.sql.Connectionのインスタンスを取得。これで MySQLサーバ にログイン
			//	DB と会話する為のインスタンス。プログラムとデータベースを結ぶパイプ。
			con = DriverManager.getConnection(url, user, password);

			//	クラスが見つからない場合の例外
		} catch (ClassNotFoundException e) {

			//	エラーに至る履歴を表示
			e.printStackTrace();

			//	データベース処理に関する例外
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//	MySQLサーバに接続した結果をメソッドの呼び出し元に渡します。
		return con;
	}
}

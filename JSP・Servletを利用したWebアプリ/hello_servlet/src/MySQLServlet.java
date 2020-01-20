import java.io.IOException;
import java.io.PrintWriter;
//	java.sqlはJavaSEの標準API
//	DBMSへの接続と切断の際に利用
import java.sql.Connection;
//	DBMSへの接続準備のために利用する
import java.sql.DriverManager;
//	DBMSから検索結果を受け取る際に利用
import java.sql.ResultSet;
import java.sql.SQLException;
//	SQL文を送信する際に利用（PreparedStatementの方がよい）
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServletアノテーション（URLパターンの設定）
//URLパターンの初期値： "/クラス名"
@WebServlet("/MySQLServlet")

public class MySQLServlet extends HttpServlet {

	//	serialVersionUIDフィールド
	//	private static final long serialVersionUID = 1L;

	//	特に意味なし
	//    public MySQLServlet() {
	//        super();
	//    }

	//	doGetメソッド：サーブレットクラスがGETリクエストされると実行されるメソッド
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//	URLエンコードによって変換されたリクエストパラメータを元に戻す
		//	送信元のHTMLの文字コードを指定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

//		HTTPボディ部
//		PrintWriterインスタンスの取得
//		文字列出力用のストリームを出力するために、
//		レスポンス・オブジェクトからPrintWriterオブジェクトを取得する。
//		文字出力用のストリームの取得：HttpServletResponseオブジェクトから文字を出力する入れ物を取り出すこと
//		ストリームというのは文字が順番に連続して並んでいる入れ物のこと
//		取り出したストリームへ文字を書き出すと、それがクライアントに送られ、画面に表示される。
//		PrintWriterストリームの参照変数 = HttpServletResponseオブジェクト. getWriter();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>データベーステスト</title>");
		out.println("</head>");
		out.println("<body>");

		//	一度状態を初期化にしています。
		Connection conn = null;

		//	JDBC URL：データベース接続先を指定する文字列（DBMSごとに指定された書き方）
		//	"jdbc:（製品名）:（接続先データベース名）"という書き方が多い。
		//	localhost（自分の使っている PC)testdb_sv(データベース名)を使います。
		String url = "jdbc:mysql://localhost/testdb_sv";
		String user = "root";
		String password = "mysql";

		//	try～catch は Java のException系例外の為の構文
		//	try の中にはException系例外が発生しそうな処理を書きます。
		try {
			//	ここでは、ドライバーがロードされ使えるような状態にしています。	?
			//	JDBCドライバのJARファイル内にあるドライバクラスをJVMに読み込み、有効化させる
			//	データベースにアクセスする前に1度だけやっておけばよい処理
			//	JDBCドライバの完全限定名（DBMSごとに固有）を引数に取る
			//	JDBCドライバ：Java とデータベースを繋げる工具箱の様な物。
			//	データベースを操作するために必要となるクラスやインターフェース群。
			//	DBMSの開発元がJARファイルとして提供している。
			//	java.sqlパッケージのクラスやインターフェースを介して間接的に利用する。
			//	JDBCドライバをApache Tomcat内の「lib」に配置（「C:¥pleiades¥tomcat¥9（バージョン番号）¥lib」）
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			//	データベース接続の確立
			//	java.sql.Connectionのインスタンスを取得。これで MySQLサーバ にログイン
			//	DB と会話する為のインスタンス。プログラムとデータベースを結ぶパイプ。
			conn = DriverManager.getConnection(url, user, password);

			//	SQL文のひな形を準備する
			//	PreparedStatement とは SQLを運ぶ箱
			//	Prepared Statementは、Statementのもう少し強力なバージョンであり、Statementの倍ぐらい速くて扱いやすい
//			PreparedStatement は Statement をスーパーインタフェースとしてます。
			//	Statementは静的なSQLを、PreparedStatementはプレースホルダを使った動的SQLを扱えます。
//			prepareStatementは、パラメータを渡して、複数SQLを実行する場合に使います。
//			DBの取り扱いはprepareStatementを使う
//			createStatementは、パラメータなしのSQLを実行するのに使います。
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM test_table_sv";

			//	executeQuery()は、実行メソッドで、必ず ResultSet が返ってきます。
			//	ResultSet オブジェクトは、検索結果が入る箱。
			//	select文は、executeQueryで実行
			ResultSet rs = stmt.executeQuery(sql);

			//	next()：次の行にデータが存在していれば true、存在しなければ false
			//	（最初は0行目の次の行＝1行目を見る）
			//	while (rs.next())とはカーソルを１行ずつ実行していき、データがなくなったら実行を終了という意味。
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String userPassword = rs.getString("password");
				out.println("<p>");
				out.println("ユーザーID:　" + userId + "/ ユーザー名:　" + userName + "/ パスワード:　" + userPassword);
				out.println("</p>");
			}
			rs.close();
			stmt.close();

			//	クラスが見つからない場合の例外
		} catch (ClassNotFoundException e) {
			out.println("ClassNotFoundException:" + e.getMessage());

			//	データベース処理に関する例外
		} catch (SQLException e) {
			out.println("SQLException:" + e.getMessage());
		} catch (Exception e) {
			out.println("Exception:" + e.getMessage());
		} finally {

			try {
				//	null状態で切断するとSQLExceptionにひっかかってしまうため、nullかチェック
				if (conn != null) {

					//	データベースとの接続を終了。これをしないとデータベースを接続したまま次の作業が実行されてしまい、
					//	メモリに負荷がかかりますので、終わりには必ず終了をするようにして下さい。
					conn.close();
				}

				//	データベース処理に関する例外
			} catch (SQLException e) {
				out.println("SQLException:" + e.getMessage());
			}
		}
		out.println("</body>");
		out.println("</html>");

		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	*/
}

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	@WebServletアノテーション（URLパターンの設定）
//	URLパターンの初期値： "/クラス名"
@WebServlet("/WelcomeServlet")

public class WelcomeServlet extends HttpServlet {

	//	serialVersionUIDフィールド
	//	private static final long serialVersionUID = 1L;

//	特に意味なし
//	public WelcomeServlet() {
//		super();
//	}

	/**
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	*/

	//	doPostメソッド：サーブレットクラスがPOSTリクエストされると実行されるメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//	URLエンコードによって変換されたリクエストパラメータを元に戻す
		//	送信元のHTMLの文字コードを指定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//	リクエストパラメータを取得する
		String username = request.getParameter("username");
		System.out.println(username);
		System.out.println(request.getParameter("password"));

//		HTTPボディ部
//		PrintWriterインスタンスの取得
//		文字列出力用のストリームを出力するために、
//		レスポンス・オブジェクトからPrintWriterオブジェクトを取得する。
//		文字出力用のストリームの取得：HttpServletResponseオブジェクトから文字を出力する入れ物を取り出すこと
//		ストリームというのは文字が順番に連続して並んでいる入れ物のこと
//		取り出したストリームへ文字を書き出すと、それがクライアントに送られ、画面に表示される。
//		PrintWriterストリームの参照変数 = HttpServletResponseオブジェクト. getWriter();
		PrintWriter out = response.getWriter();

//		ストリームを取り出したら、PrintWriterクラスのメソッドを用いて、ストリームに文字列を書き込む
//		データをレスポンス・オブジェクトに書き込みます。
		out.println("<html><head></head><body><br>" + username + "さん、ようこそ！</body></html>");

		//		doGet(request, response);
	}
}

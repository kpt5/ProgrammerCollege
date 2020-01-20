import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServletアノテーション（URLパターンの設定）
//URLパターンの初期値： "/クラス名"
@WebServlet("/TestServlet")

public class TestServlet extends HttpServlet {

//	serialVersionUIDフィールド
//	private static final long serialVersionUID = 1L;

//	特に意味なし
//    public TestServlet() {
//        super();
//    }

//	doGetメソッド：サーブレットクラスがGETリクエストされると実行されるメソッド
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//	URLエンコードによって変換されたリクエストパラメータを元に戻す
		//	送信元のHTMLの文字コードを指定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

//		リクエストパラメータを取得する
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);

//		PrintWriterインスタンスの取得
		PrintWriter out = response.getWriter();

		out.println("<html><head></head><body><br>" + username + "<br>" + password + "</body></html>");

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//	doPostメソッド：サーブレットクラスがPOSTリクエストされると実行されるメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);

		PrintWriter out = response.getWriter();

		out.println("<html><head></head><body><br>" + username + "<br>" + password + "</body></html>");

//		doGet(request, response);
	}
}

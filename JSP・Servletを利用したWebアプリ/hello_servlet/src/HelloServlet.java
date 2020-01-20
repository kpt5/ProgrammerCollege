import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	@WebServletアノテーション（URLパターンの設定）
//	URLパターンの初期値： "/クラス名"
@WebServlet("/HelloServlet")

public class HelloServlet extends HttpServlet {

	//	serialVersionUIDフィールド
	//	private static final long serialVersionUID = 1L;

//	特に意味なし
//	public HelloServlet() {
//		super();
//	}

	//	doGetメソッド：サーブレットクラスがGETリクエストされると実行されるメソッド
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//	PrintWriterインスタンスの取得
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Hello Servlet!</h3>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	*/

}

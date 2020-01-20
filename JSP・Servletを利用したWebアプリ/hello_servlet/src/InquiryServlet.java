import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServletアノテーション（URLパターンの設定）
//URLパターンの初期値： "/クラス名"
@WebServlet("/InquiryServlet")

public class InquiryServlet extends HttpServlet {

	//	serialVersionUIDフィールド
	//	private static final long serialVersionUID = 1L;

//	特に意味なし
//	public InquiryServlet() {
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
		String name = request.getParameter("name");
		String qtype = request.getParameter("qtype");
		String q_content = request.getParameter("q_content");
		System.out.println(name);

		//	PrintWriterインスタンスの取得
		PrintWriter out = response.getWriter();
		//		out.println("<html><head></head><body><br>" + name + "さん、お問合せありがとうございました</body></html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<br>");
		out.println(name + "さん、お問合せありがとうございました");
		out.println("<br>");
		out.println("<br>");
		out.println("お問い合わせの種類: " + qtype);
		out.println("<br>");
		out.println("<br>");
		out.println("お問い合わせ内容:　");
		out.println("<br>");
		out.println(q_content);
		out.println("</body>");
		out.println("</html>");

		/**
		doGet(request, response);
		*/
	}
}

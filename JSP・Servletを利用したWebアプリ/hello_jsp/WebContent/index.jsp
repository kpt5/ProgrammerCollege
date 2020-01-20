<%-- pageディレクティブ --%>
<%-- pageEncoding：JSPファイルの文字コード（デフォルト値はcontentType属性の値） --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>TEST</title>
</head>
<body>
	<p>こんにちは！</p>

	<!-- スクリプトレット：JSP のタグでは記述できない処理を Java コードで記述 -->
	<!-- ？したとの違い -->
	<!-- out： 定義済みの暗黙オブジェクト（javax.servlet.jsp.JspWriter） -->
	<% out.println(new java.util.Date()); %>

	<!-- スクリプト宣言： 変数、メソッドを宣言 -->
	<%!
		int add(int a, int b){
			return a + b;
		}
	%>

	<!-- スクリプト式： Java コードを記述しその実行結果を表示します。 -->
	<!-- void のメソッドや、変数の宣言のみを式に記述することはできません。 -->
	<p>1+2=<%= add(1,2) %></p>
	<p>3+4=<%= add(3,4) %></p>

	<!-- スクリプト宣言 -->
	<%! int countA = 0; %>
	<p>スクリプト宣言による変数： countA=<%= countA %></p>

	<!-- スクリプトレット -->
	<%
		int countB = 0;
		countA++;
		countB++;
	%>
	<p>スクリプトレットによる変数： countB=<%= countB %></p>

	<!-- スクリプトレット -->
	<!-- Math.random()： java.lang.Math -->
	<p><% out.println(Math.random()); %>：スクリプトレットによるMath.random()結果</p>

	<!-- スクリプト式 -->
	<p><%= Math.random() %>： スクリプト式によるMath.random()結果</p>

	<p>お名前を入力してください。</p>
	<form method="post" action="greeting-out.jsp">
		<input type="text" name="user">
		<input type="submit" value="確定">
	</form>

	<form method="post" action="total-out.jsp">
		<input type="text" name="price">円 ｘ
		<input type="text" name="count">個 + 送料
		<input type="text" name="delivery">円 =
		<input type="submit" value="計算する">
	</form>

</body>
</html>

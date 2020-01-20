<%-- pageディレクティブ --%>
<%-- pageEncoding：JSPファイルの文字コード（デフォルト値はcontentType属性の値） --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HelloServlet</title>
</head>
<body>
	<input type="button" value="HelloServlet" onClick="location.href='HelloServlet'">
	<input type="button" value="WelcomeServlet" onClick="location.href='welcome.jsp'">
	<input type="button" value="問い合わせ" onClick="location.href='inquiry.jsp'">
	<input type="button" value="MySQLServlet" onClick="location.href='MySQLServlet'">

	<br>
	<br>GET 通信
<!--
	method：リクエストメソッドの指定（省略するとGET）
	action：送信先の指定
		サーブレットクラスの場合： /アプリケーション名 / URLパターン（サーブレットクラス名）
		JSPファイルの場合： /アプリケーション名 / WebContentからのパス
 -->>
	<form method="get" action="TestServlet">
		<input type="text" name="username">
		<input type="password" name="password">
		<input type="submit" value="送信">
	</form>

	POST 通信
	<form method="post" action="TestServlet">
		<input type="text" name="username">
		<input type="password" name="password">
		<input type="submit" value="送信">
	</form>
</body>
</html>

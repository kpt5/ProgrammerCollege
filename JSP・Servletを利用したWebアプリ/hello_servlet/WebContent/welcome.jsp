<%-- pageディレクティブ --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WELCOME</title>
</head>
<body>
	名前とパスワードを入力してください。
<!--
	method：リクエストメソッドの指定（省略するとGET）
	action：送信先の指定
		サーブレットクラスの場合： /アプリケーション名 / URLパターン（サーブレットクラス名）
		JSPファイルの場合： /アプリケーション名 / WebContentからのパス
 -->>
	<form method="post" action="WelcomeServlet">
		<input type="text" name="username">
		<input type="password" name="password">
		<input type="submit" value="送信">
	</form>
</body>
</html>

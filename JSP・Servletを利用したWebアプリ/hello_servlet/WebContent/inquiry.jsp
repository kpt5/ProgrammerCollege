<%-- pageディレクティブ --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>お問い合わせフォーム</title>
</head>
<body>
<!--
	method：リクエストメソッドの指定（省略するとGET）
	action：送信先の指定
		サーブレットクラスの場合： /アプリケーション名 / URLパターン（サーブレットクラス名）
		JSPファイルの場合： /アプリケーション名 / WebContentからのパス
 -->
	<form method="post" action="InquiryServlet">
		名前:<br> <input type="text" name="name"><br>
		お問い合わせの種類:<br>
		<select name="qtype">
			<option value="会社について">会社について</option>
			<option value="製品について">製品について</option>
			<option value="アフターサポートについて">アフターサポートについて</option>
		</select><br>
		お問い合わせ内容:<br>
		<textarea name="q_content"></textarea><br>
		<input type="submit" value="登録">
	</form>
</body>
</html>

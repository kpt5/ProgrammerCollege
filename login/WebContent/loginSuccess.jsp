<%-- ログイン成功で呼び出されるJSPファイル --%>
<%-- pageディレクティブ --%>
<%-- pageEncoding：JSPファイルの文字コード（デフォルト値はcontentType属性の値） --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- strutsタグを使用する際に記述します。 --%>
<%-- strutsタグとはStrutsフレームワークで使える専用のHTMLタグです。（<s: で使うことができます） --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>ログイン成功画面</title>
</head>
<body>
	<h1>ログインに成功しました。</h1>
</body>
</html>

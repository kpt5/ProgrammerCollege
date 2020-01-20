<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HelloStruts</title>
</head>
<body>
	<h1>HelloStruts2!</h1>
	<br>
<!--
s:property value="呼び出し元アクションクラスでの属性名"
JSPの実行を指定したアクションのクラスが保持している属性を参照する。
value属性に参照したいアクションクラスでの属性名を記述する。
前提として、アクションクラスに値を保持する属性と、そのアクセッサメソッドを定義する。
 -->
	<h3><s:property value="result" /></h3>
</body>
</html>

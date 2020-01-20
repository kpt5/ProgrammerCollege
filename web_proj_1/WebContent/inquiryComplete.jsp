<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>お問い合わせ 受付完了</title>
</head>
<body>
	<br>
<!--
s:property value="呼び出し元アクションクラスでの属性名"
JSPの実行を指定したアクションのクラスが保持している属性を参照する。
value属性に参照したいアクションクラスでの属性名を記述する。
前提として、アクションクラスに値を保持する属性と、そのアクセッサメソッドを定義する。
 -->
	<s:property value="name" />さん、お問合せありがとうございました。
	<br>
	<br>お問い合わせの種類:<br>
<!--
s:if test
JSP中にテキストやボタンを条件に応じて表示させる方法。
ifタグのtestは、プロパティ名。
testプロパティがtrueの場合、ifタグに囲まれている部分を表示。
falseの場合はelseタグで囲まれている部分を表示。
 -->
	<s:if test='qtype=="company"'>
	会社について
	</s:if>
	<s:if test='qtype=="product"'>
	製品について
	</s:if>
	<s:if test='qtype=="support"'>
	アフターサポートについて
	</s:if>
	<br>
	<br>お問い合わせ内容:<br>
	<s:property value="body" />
</body>
</html>

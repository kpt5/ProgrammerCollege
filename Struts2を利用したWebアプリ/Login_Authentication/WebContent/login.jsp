<%-- pageディレクティブ --%>
<%-- pageEncoding：JSPファイルの文字コード（デフォルト値はcontentType属性の値） --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- strutsタグを使用する際に記述します。 --%>
<%-- strutsタグとはStrutsフレームワークで使える専用のHTMLタグです。（<s: で使うことができます） --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>ログイン画面</title>
</head>
<body>
<!-- struts.xmlのactionタグから、name="LoginAction"のタグを探しにいく。 -->
<!-- <input>タグ「type="text"」「type="password」「type="submit"」としてブラウザで認識します。 -->
	<s:form action="LoginAction">
		<!-- 入力欄のラベル直後に「:」がつく -->
		<s:textfield name="name" label="ユーザー名" />
		<s:password name="password" label="パスワード" />
		<s:submit value="ログイン"/>
	</s:form>

<!--
+------+-----------+----------+
| id   | user_name | password |
+------+-----------+----------+
|    1 | taro      | 123      |
|    2 | jiro      | 123      |
|    3 | hanako    | 123      |
|    4 | saburo    | 123      |
+------+-----------+----------+
 -->
</body>
</html>

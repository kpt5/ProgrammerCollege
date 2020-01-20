<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>LOGIN</title>
</head>
<body>
	<!-- #sessionはStruts 2が提供するセッションオブジェクト相当の暗黙オブジェクトを表しています。 -->
	<!-- この時のvalue属性の記述方法はOGNL(Object-Graph Navigation Language)という式言語の一種を用いて記述します。 -->
	<s:property value="#session.loginDTOList.get(0).username"/>さん、ようこそ！
	<br>
	<table>
		<tbody>
			<tr>
				<th>USERNAME</th>
				<th>PASSWORD</th>
			</tr>
			<s:iterator value="#session.loginDTOList">
				<tr>
					<td><s:property value="username"/></td>
					<td><s:property value="password"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>
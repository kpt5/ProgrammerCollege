<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>HelloStruts</title>
</head>
<body>
	<h1>HelloStruts2!</h1>
	<br>
	<table>
		<tbody>
			<tr>
				<th>USERID</th>
				<th>USERNAME</th>
				<th>PASSWORD</th>
				<th>RESULT</th>
			</tr>
			<!-- #sessionはStruts 2が提供するセッションオブジェクト相当の暗黙オブジェクトを表しています。 -->
			<!-- この時のvalue属性の記述方法はOGNL(Object-Graph Navigation Language)という式言語の一種を用いて記述します。 -->
			<s:iterator value="#session.helloStrutsDTOList">
				<tr>
					<td><s:property value="userId"/></td>
					<td><s:property value="userName"/></td>
					<td><s:property value="password"/></td>
					<td><s:property value="result"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>
<%-- pageディレクティブ --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- request： 定義済みの暗黙オブジェクト（javax.servlet.http.HttpServletRequest） -->
	<!-- スクリプトレット -->
	<% request.setCharacterEncoding("UTF-8"); %>

	<!-- スクリプト式 -->
	<p>こんにちは、<%= request.getParameter("user") %> さん！</p>
</body>
</html>
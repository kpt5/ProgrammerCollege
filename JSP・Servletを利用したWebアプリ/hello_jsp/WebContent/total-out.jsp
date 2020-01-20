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
	<!-- pageディレクティブ -->
	<!-- キャッチされなかった例外時に表示するエラーページ -->
	<%@ page errorPage = "total-error.jsp" %>

	<!-- スクリプトレット -->
	<%
		// request： 定義済みの暗黙オブジェクト（javax.servlet.http.HttpServletRequest）
		request.setCharacterEncoding("UTF-8");
		// Integer.parseInt()：
		int price = Integer.parseInt(request.getParameter("price"));
		int count = Integer.parseInt(request.getParameter("count"));
		int delivery = Integer.parseInt(request.getParameter("delivery"));
	%>

	<!-- スクリプト式 -->
	<%= price %>円 x <%= count %>個 + 送料<%= delivery %>円 =
	<%= price * count + delivery %>円
</body>
</html>
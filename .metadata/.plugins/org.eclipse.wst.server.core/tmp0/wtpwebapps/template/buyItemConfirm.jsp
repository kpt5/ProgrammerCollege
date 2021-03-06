<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>BuyItemConfirm画面</title>
</head>
<!--
	BuyItemAction（buyItemConfirm.jsp）で持つことになったセッション
	session.put("loginUser", loginDTO);
	session.put("login_user_id", loginDTO.getLoginId());
	session.put("id", buyItemDTO.getId());
	session.put("buyItem_name", buyItemDTO.getItemName());
	session.put("buyItem_price", buyItemDTO.getItemPrice());
	session.put("stock", stock);
	個数と単価をかけて、buyItem_priceの値を上書き
	session.put("buyItem_price", intStock * intPrice);
	session.put("pay", payment);
 -->
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>BuyItemConfirm</p>
		</div>
		<div>
			<s:form action="BuyItemConfirmAction">
				<table>
					<tr>
						<td>商品名</td>
						<td><s:property value="session.buyItem_name" /></td>
					</tr>
					<tr>
						<td>値段</td>
						<td>
							<s:property value="session.buyItem_price" />
							<span>円</span>
						</td>
					</tr>
					<tr>
						<td>購入個数</td>
						<td>
							<s:property value="session.stock" />
							<span>個</span>
						</td>
					</tr>
					<tr>
						<td>支払い方法</td>
						<td><s:property value="session.pay" /></td>
					</tr>
					<tr>
						<td><s:submit value="完了" /></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>
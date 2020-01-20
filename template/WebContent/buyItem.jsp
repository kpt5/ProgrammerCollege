<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>BuyItem画面</title>
</head>
<!--
	LoginAction（buyItem.jsp）で持つことになったセッション
	session.put("loginUser", loginDTO);
	session.put("login_user_id", loginDTO.getLoginId());
	session.put("id", buyItemDTO.getId());
	session.put("buyItem_name", buyItemDTO.getItemName());
	session.put("buyItem_price", buyItemDTO.getItemPrice());
 -->
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:form action="BuyItemAction">
				<table>
					<tr>
						<td>
							<span>商品名</span>
						</td>
						<td>
							<!-- <ss:property value=session.get("buyItem_name") /> -->
							<s:property value="session.buyItem_name" />
						</td>
					</tr>
					<tr>
						<td>
							<span>値段</span>
						</td>
						<td>
							<s:property value="session.buyItem_price" />
							<span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							<!-- 個数では？ -->
							<span>在庫</span>
						</td>
						<td>
							<!-- 課題：在庫量に応じてoptionを増やせないか。for文の利用 -->>
							<select name="stock">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<span>支払い方法</span>
						</td>
						<td>
							<!-- 課題：DBに格納された支払い方法を表示し分ける -->
							<input type="radio" name="pay" value="1" checked="checked">現金払い
							<input type="radio" name="pay" value="2">クレジットカード
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="購入" />
						</td>
					</tr>
				</table>
			</s:form>
			<div>
				<span>前画面に戻る場合は</span>
				<!-- login.jspをhref属性に当てる場合との違いは？挙動は同じ -->
				<!-- <a href='<s:url action="HomeAction" />'>こちら</a> -->
				<a href='login.jsp'>こちら</a>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>
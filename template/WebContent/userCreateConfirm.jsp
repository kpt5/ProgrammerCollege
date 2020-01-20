<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>UserCreateConfirm画面</title>
</head>
<!--
	UserCreateConfirmAction（userCreate.jsp）で持つことになったセッション
	session.put("loginUserId", loginUserId);
	session.put("loginPassword", loginPassword);
	session.put("userName", userName);
 -->
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="UserCreateCompleteAction">
					<tr id="box">
						<td>
							<label>ログインID:</label>
						</td>
						<td>
<!--
valueには、Actionクラスのフィールド値(またはJSP内で宣言されたフィールド値など)を指定することができます。
型がObjectとあるように、どのようなクラスでも指定できます。実際にレンダリングされるときには、
Object#toString()が呼び出されるので、独自に作成したクラスに、適切に表示されるようにtoStringメソッドを
オーバーライドすると便利に利用できます。
escape="true"にすると、ActionからValueStackを経由してHTML文章丸ごと表示できるので、困った時の無理やりな実装をするのに使えます。もちろんXSS対策は万全に自己責任でやってください。
パラメータ
名前		必須？	デフォルト	Evaluated	型			説明
default 	false 				false 		String 		デフォルトで表示する値
escape 		false 	true 		false 		Boolean 	HTMLタグをそのまま表示するかどうか

サーバ側で生成したHtmlを画面に表示する
　<s:property value="%{taisyoServiceHtml}" escape="false"/>

　※escape="false"をしないとHtmlタグがそのまま出てきます

意味ある？
タグ付きで登録できてしまう
 -->
							<s:property value="loginUserId" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ログインPASS:</label>
						</td>
						<td>
							<s:property value="loginPassword" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ユーザー名:</label>
						</td>
						<td>
							<s:property value="userName" escape="false" />
						</td>
					</tr>
					<tr>
						<td>
							<!-- 引き継がれるのはSessionのみで値は特に引き継がれない？ -->
							<s:submit value="完了" />
						</td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>
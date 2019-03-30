<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/resetPassword.css">
<link rel="stylesheet" href="./css/mars.css">
<title></title>
</head>
<body>
<jsp:include page="header.jsp" />

<div id="main">
	<h1>パスワード再設定確認画面</h1>
	<div class="mainContainer">
		<s:form action="ResetPasswordCompleteAction">
			<table class="t1">
				<tr>
					<th scope="row"><s:label value="ユーザーID"/></th>
					<td><s:property value = "#session.userId"/></td>
				</tr>
				<tr>
					<th scope="row" ><s:label value="新しいパスワード"/></th>
					<td><s:property value = "#session.concealPassword"/></td>
				</table>
				<div class="confirm">
					<s:submit value="パスワード再設定"  class="submit_btn" />
				</div>
		</s:form>
			<div class="confirm">
				<s:form action="ResetPasswordAction">
						<s:hidden name="userId" value="%{userId}" />
						<s:submit value="戻る"  class="submit_btn" />
				</s:form>
			</div>
	</div>
</div>
</body>
</html>
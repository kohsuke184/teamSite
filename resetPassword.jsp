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
	<h1>パスワード再設定画面</h1>
		<s:if test="!userIdErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="userIdErrorMessageList"><s:property />
				<br></s:iterator>
			</div>
		</s:if>

		<s:if test="!passwordErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="passwordErrorMessageList"><s:property />
				<br></s:iterator>
			</div>
		</s:if>

		<s:if test="!newPasswordErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="newPasswordErrorMessageList"><s:property />
				<br></s:iterator>
			</div>
		</s:if>

		<s:if test="!reNewPasswordErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="reNewPasswordErrorMessageList"><s:property />
				<br></s:iterator>
			</div>
		</s:if>

		<s:if test="!passwordIncorrectErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="passwordIncorrectErrorMessageList"><s:property />
				<br></s:iterator>
			</div>
		</s:if>

		<s:if test="!newAndReNewPasswordNotMatchErrorMessageList.isEmpty()">
			<div class="error">
				<s:iterator value="newAndReNewPasswordNotMatchErrorMessageList"><s:property />
				<br></s:iterator>
			</div>
		</s:if>

	<div class="mainContainer">
		<s:form action="ResetPasswordConfirmAction">
			<table class="t1">
				<tr>
					<th scope="row"><s:label value="ユーザーID"/></th>
					<td><s:textfield name="userId" placeholder="ユーザーID" class="textfield"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="現在のパスワード"/></th>
					<td><s:password name="password" placeholder="現在のパスワード" class="textfield"/></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="新しいパスワード"/></th>
					<td><s:password name="newPassword" placeholder="新しいパスワード" class="textfield"/></td>
				<tr>
					<th scope="row" class="bottom"><s:label value="新しいパスワード（再確認）"/></th>
					<td><s:password name="newConfirmPassword" placeholder="新しいパスワード（再確認）" class="textfield"/></td>
				</tr>
			</table>
			<div class="confirm">
				<s:submit value="確認" class="submit_btn"/>
			</div>
		</s:form>
	</div>
</div>
</body>
</html>
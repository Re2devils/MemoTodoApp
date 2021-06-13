<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MEMO&TODO</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#footer").load("footer");
		$("#header").load("header");
	});
</script>
<link rel="stylesheet" href="css/common/common.css" />
</head>

<body>
	<div class="wrapper">
		<div id="header" style="width: 100%"></div>
		<div class="content">
			<p class="page-title">登録</p>
			<p class="err-msg">
				<c:if test="${not empty signupErrMsg }">${signupErrMsg }</c:if>
			</p>
			<form:form action="register" modelAttribute="signup" method="post">
				<form:errors class="err-msg" path="loginId" />
				<div class="input-container">
					<label class="format-label">ユーザー名：</label>
					<form:input path="loginId" />

				</div>
				<form:errors class="err-msg" path="userName" />
				<div class="input-container">
					<label class="format-label">名前：</label>
					<form:input path="userName" />

				</div>
				<form:errors class="err-msg" path="email" />
				<div class="input-container">
					<label class="format-label">Eメール：</label>
					<form:input path="email" />

				</div>
				<form:errors class="err-msg" path="password" />
				<div class="input-container">
					<label class="format-label">パスワード：</label>
					<form:password path="password" />

				</div>
				<form:errors class="err-msg" path="rePass" />
				<div class="input-container">
					<label class="format-label">確認パスワード：</label>
					<form:password path="rePass" />

				</div>
				<div class="btn-container">
					<form:button class="btn signin">登録</form:button>
					<form:button class="btn back"
						onclick="location.href='login'; return false; method='post'">ログインに戻る</form:button>
				</div>
			</form:form>
		</div>
		<div id="footer" style="width: 100%"></div>
	</div>
</body>
</html>

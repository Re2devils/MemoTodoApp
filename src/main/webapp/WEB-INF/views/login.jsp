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
	});
</script>
<link rel="stylesheet" href="css/common/common.css" />
</head>

<body>
	<div class="wrapper">
		<object class="header" data="header"></object>
		<div class="content">
			<p class="page-title">ログイン</p>
			<form:form action="mypage" modelAttribute="login" method="post">
				<p class="err-msg"><c:if test="${not empty loginErrMsg }">${loginErrMsg }</c:if> </p>
				<form:errors class="err-msg" path="loginId" />
				<div class="input-container">
					<label class="format-label">ユーザー名：</label>
					<form:input path="loginId" />
				</div>
				<form:errors class="err-msg" path="password" />
				<div class="input-container">
					<label class="format-label">パスワード：</label>
					<form:password path="password" />
				</div>
				<div class="btn-container">
					<form:button class="btn login max-width">ログイン</form:button>
				</div>

			</form:form>
			<div style="text-align: center; font-weight: bold;">
				<a href="#">パスワードを忘れる方→</a> <br /> <a href="signup">新規ユーザー登録→</a>
			</div>
		</div>
		<div id="footer"
			style="width: 100%; position: absolute; bottom: 25px;"></div>
	</div>
</body>

</html>
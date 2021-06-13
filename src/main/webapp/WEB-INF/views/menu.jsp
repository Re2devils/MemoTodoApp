<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/menu/menu-style.css">
<script src="https://kit.fontawesome.com/98ca2fa25d.js"
	crossorigin="anonymous"></script>
<title>MEMO&TODO</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/javascript.js"></script>
<script>
	$(document).ready(function() {
		$("#footer").load("footer");
	});
</script>
</head>
<body>
	<div class="menu-wrapper">
		<div>
			<button class="menu-header" type="submit">
				<i id="back-btn" class="fas fa-chevron-left"></i>
			</button>
		</div>

		<div class="menu-container">
			<div class="menu-logo">
				<img src="images/logo.png" alt="logo" width="200">
			</div>
			<div>
				<a href="todoManager" class="menu-btn">TODO管理</a>
			</div>
			<div>
				<a href="#" class="menu-btn">MEMO管理</a>
			</div>
			<div>
				<a href="mypage" class="menu-btn">マイページ</a>
			</div>
			<div>
				<a href="#" class="menu-btn">個人情報</a>
			</div>
			<div>
				<a href="logout" class="menu-btn">ログアウト</a>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
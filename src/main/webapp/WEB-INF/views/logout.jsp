<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Refresh" content="2;URL=index">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MEMO&TODO</title>
<link rel="stylesheet" href="css/common/common.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#footer").load("footer");
		$("#header").load("header");
	});
</script>
</head>
<body>
	<div class="wrapper">
		<!--       <object class="header" data="header.html" type=""></object> -->
		<div id="header"></div>
		<div class="content">
			<p>ログアウトしました</p>
			<p>自動的にホームページ移動して行きます</p>
		</div>
		<div id="footer"></div>
<!-- 		<object class="footer" data="footer.html" type=""></object> -->
	</div>
</body>
</html>

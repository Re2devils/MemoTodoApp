<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Refresh" content="2;URL=mypage">
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
<link rel="stylesheet" href="css/common/common.css">
</head>
<body>
	<div class="wrapper">
		<div id="header" style="width: 100%;"></div>
		<div class="content">
			<p>追加できました</p>
			<p>自動的にマイページへ移動していきます</p>
		</div>
		<div id="footer" style="width: 100%;"></div>
	</div>
</body>
</html>

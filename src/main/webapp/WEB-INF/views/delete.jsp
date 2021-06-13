<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MEMO&TODO</title>
<link rel="stylesheet" href="css/common/common.css">
<link rel="stylesheet" href="css/del/delete.css">

<script>
	$(document).ready(function() {
		$("#bar").load("tabbar");
		$("#menu").load("menu");
	});
</script>
</head>
<body>
	<div id="menu"></div>
	<div class="wrapper">
		<div id="bar" style="margin: 0; padding: 0"></div>
		<div class="content">
			<div class="del-line">
				<label class="format-label">開始日：</label>
				<p>${nowTodo.fullStartDate }</p>
			</div>
			<div class="del-line">
				<label class="format-label">終了日：</label>
				<p>${nowTodo.fullEndDate }</p>
			</div>
			<div class="del-line task">
				<label class="format-label">内容：</label>
				<p>${nowTodo.task }</p>
			</div>
			<div class="del-line">
				<label class="format-label">状況：</label>
				<c:choose>
					<c:when test="${nowTodo.finished == true}"><p>完了</p></c:when>
					<c:otherwise><p>未完了</p></c:otherwise>
				</c:choose>

			</div>
			<form class="btn-container" action="deleteTodo" method="post">
				<button class="btn del">削除</button>
				<button class="btn back"
					onclick="window.history.back(); return false;">キャンセル</button>
			</form>
		</div>
	</div>
</body>
</html>
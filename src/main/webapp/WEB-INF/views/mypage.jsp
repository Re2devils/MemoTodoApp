<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/mypage/mypage-style.css" />
<link rel="stylesheet" href="css/common/common.css" />

<script src="https://kit.fontawesome.com/98ca2fa25d.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>MEMO&TODO</title>
<script>
	$(document).ready(function() {
		$("#bar").load("tabbar");
		$("#search").load("search");
		$("#menu").load("menu");
	});
</script>
</head>

<body>
	<div id="menu"></div>
	<div class="wrapper">
		<div id="bar"></div>
		<%-- 		<%@ include file="tabbar.jsp"%> --%>
		<p class="page-title">マイページ</p>
		<div id="search"></div>
		<div class="content">
			<p class="today-title" style="width: 100%; text-align: left">今週のタスク
			</p>
			<div class="today">

				<table class="today-view">
					<c:choose>
						<c:when test="${not empty searchTodoList }">
							<c:forEach var="todo" items="${searchTodoList }">
								<tr>
									<td><label class="time">${todo.enddate }
											${todo.starttime } - ${todo.endtime } </label>
										<button style="float: right;" class="finish-btn">
											<i class="fas fa-check"></i>
										</button> <span style="float: right;">未完了</span> <textarea>${todo.task }</textarea>
									</td>

								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="todo" items="${todoList }">
								<tr>
									<td><label class="time">${todo.enddate }
											${todo.starttime } - ${todo.endtime } </label>
										<button style="float: right;" class="finish-btn">
											<i class="fas fa-check"></i>
										</button> <span style="float: right;">未完了</span> <textarea>${todo.task }</textarea>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
			<div class="add-btn-container">
				<div class="add memo">
					<p>新しいメモの作成</p>
					<button class="add-btn">
						<i class="fas fa-plus-circle fa-3x i-memo"></i>
					</button>
				</div>
				<div class="add todo">
					<p>新しいタスクの作成</p>
					<button name="fromMypage" class="add-btn"
						onclick="location.href='add'; return false; method='post'">
						<i class="fas fa-plus-circle fa-3x i-todo"></i>
					</button>
				</div>
			</div>
			<div class="category-view">
				<p>カテゴリー</p>
				<div class="cate-container">
					<div>
						<button class="btn all">すべて</button>
					</div>
					<div>
						<button class="btn work">仕事</button>
					</div>
					<div>
						<button class="btn travel">旅行</button>
					</div>
					<div>
						<button class="btn study">勉強</button>
					</div>
					<div>
						<button class="btn homework">家事</button>
					</div>
					<div>
						<button class="btn other">その他</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

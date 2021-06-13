
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/common/common.css" />
<link rel="stylesheet" href="css/todo/todo.css" />

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
		<div id="bar" style="margin: 0; padding: 0"></div>
		<p class="page-title">タスク管理</p>
		<div id="search"></div>
		<div class="content">
			<div
				style="display: flex; justify-content: space-between; width: 100%;">
				<div class="cate-option">
					<label>カテゴリー</label>
					<form:form action="searchByCategory" modelAttribute="searchCate"
						method="post">
						<form:select path="categoryId" id="cate" style="width: 200px;">
							<form:options items="${cateList }" itemLabel="categoryName"
								itemValue="categoryId" />
						</form:select>
					</form:form>
				</div>
				<div class="add todo">
					<!-- <p>新しいタスクの作成</p> -->
					<button name="fromTodoManager" class="add-btn"
						onclick="location.href='add'; return false; method='post'">
						<i class="fas fa-plus-circle fa-3x i-todo"></i>
					</button>
				</div>
			</div>

			<table class="todo-view">

				<!-- search result -->

				<c:choose>
					<c:when test="${not empty searchTodoList }">
						<c:forEach var="todo" items="${searchTodoList }">
							<tr>
								<td><c:choose>
										<c:when test="${todo.finished == false }">
											<textarea readonly> ${todo.task }</textarea>
										</c:when>
										<c:otherwise>
											<textarea readonly style="text-decoration: line-through;"> ${todo.task }</textarea>
										</c:otherwise>
									</c:choose>
									<div class="todo-content">
										<div>
											<label class="time">${todo.enddate }</label>
											<c:choose>
												<c:when test="${todo.finished == false }">
													<form:form action="finishTodo" method="post">
														<button value="${todo.todoId }" name="finish"
															class="finish-btn">
															<i class="fas fa-check"></i>
														</button>
													</form:form>

												</c:when>
												<c:otherwise>
													<form:form action="finishTodo" method="post">
														<button value="${todo.todoId }" name="finish"
															class="finished-btn">
															<i class="fas fa-check"></i>
														</button>
													</form:form>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${todo.finished == false }">
													<span>未完了</span>
												</c:when>
												<c:otherwise>
													<span>完了</span>
												</c:otherwise>
											</c:choose>
										</div>
										<div class="btn-wrapper">
											<form:form class="frm-btn" action="crud" method="get">
												<button name="update" value="${todo.todoId }"
													class="crud-btn">編集</button>
												<button name="delete" value="${todo.todoId }"
													class="crud-btn">削除</button>
											</form:form>
										</div>
									</div></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="todo" items="${allTodoList }">
							<tr>
								<td><c:choose>
										<c:when test="${todo.finished == false }">
											<textarea readonly> ${todo.task }</textarea>
										</c:when>
										<c:otherwise>
											<textarea readonly style="text-decoration: line-through;"> ${todo.task }</textarea>
										</c:otherwise>
									</c:choose>
									<div class="todo-content">
										<div>
											<label class="time">${todo.enddate }</label>
											<c:choose>
												<c:when test="${todo.finished == false }">
													<form:form action="finishTodo" method="post">
														<button value="${todo.todoId }" name="finish"
															class="finish-btn">
															<i class="fas fa-check"></i>
														</button>
													</form:form>
												</c:when>
												<c:otherwise>
													<form:form action="finishTodo" method="post">
														<button value="${todo.todoId }" name="finish"
															class="finished-btn">
															<i class="fas fa-check"></i>
														</button>
													</form:form>
												</c:otherwise>
											</c:choose>

											<c:choose>
												<c:when test="${todo.finished == false }">
													<span>未完了</span>
												</c:when>
												<c:otherwise>
													<span>完了</span>
												</c:otherwise>
											</c:choose>
										</div>

										<div class="btn-wrapper">
											<form:form class="frm-btn" action="crud" method="get">
												<button name="update" value="${todo.todoId }"
													class="crud-btn">編集</button>
												<button name="delete" value="${todo.todoId }"
													class="crud-btn">削除</button>
											</form:form>
										</div>
									</div></td>
							</tr>

						</c:forEach>
					</c:otherwise>
				</c:choose>



			</table>
		</div>
	</div>
</body>
</html>

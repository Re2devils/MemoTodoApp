<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/search/search-style.css">
<script src="https://kit.fontawesome.com/98ca2fa25d.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<form:form id="search-form" action="searchTask" modelAttribute="searchTodo">
		<div>
			<form:input path="searchItem" placeholder="...検索" />
		</div>
		<form:button class="search-btn">
			<i class="fas fa-search"></i>
		</form:button>
	</form:form>
</body>

</html>


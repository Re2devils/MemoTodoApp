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
    <link rel="stylesheet" href="css/bar/tabbar-style.css">
    <script src="https://kit.fontawesome.com/98ca2fa25d.js" crossorigin="anonymous"></script>
    <script src="js/javascript.js"></script>
</head>

<body>
    <div class="bar-container">
        <div class="bar-logo">
            <img src="images/logo.png" alt="logo" height="30">
        </div>
        <div class="bar-content">
            <p class="bar-item"><c:if test="${not empty loginUser }">${loginUser.userName }</c:if> </p>
            <i class="bar-item fas fa-bell fa-2x"></i>
            <i id="menu-btn" class="bar-item fas fa-bars fa-2x"></i>
<%--             <form:form action="forwardMenu" method="get"> --%>
<%--             	<form:button><i class="bar-item fas fa-bars fa-2x"></i></form:button> --%>
<%--             </form:form> --%>
        </div>
    </div>
</body>

</html>
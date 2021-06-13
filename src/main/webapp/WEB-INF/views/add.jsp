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
    <link rel="stylesheet" href="css/common/common.css" />
    <link rel="stylesheet" href="css/update/updateTodo.css" />
    <title>MEMO&TODO</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
      $(document).ready(function () {
        $("#bar").load("tabbar");
        $("#menu").load("menu");
      });
    </script>
  </head>
  <body>
    <div id="menu"></div>
    <div class="wrapper">
      <div id="bar" style="margin: 0; padding: 0"></div>
      <p class="page-title">編集</p>
      <div class="content">
        <form:form action="add" modelAttribute="addTodo" method="post">
          <div class="cate-option">
            <p>カテゴリー</p>
            <form:select path="categoryId" id="cate">
              <form:options items="${cateList }" itemValue="categoryId" itemLabel="categoryName"/>
            </form:select>
          </div>
          <div>
          	<form:errors path="task" class="err-msg" />
            <p>タスク</p>
            <form:textarea path="task" rows="3" ></form:textarea>
          </div>
          <div>
            <p>場所</p>
            <form:input class="place" path="place" />
          </div>
          <div class="date-container">
            <div>
              <p>開始日付</p>
              <form:input path="startdate" class="date" type="datetime-local" />
            </div>
          </div>
          <div class="date-container">
            <div>
              <p>終了日付</p>
              <form:input path="enddate" class="date" type="datetime-local" />
            </div>
          </div>
          <div>
            <p>注意</p>
            <form:textarea path="note" rows="2"></form:textarea>
          </div>
          <div class="btn-container">
            <button class="btn login">追加</button>
            <button class="btn back"
            onclick="window.history.back(); return false; method='post';">戻る ${backPosition}</button>
          </div>
        </form:form>
      </div>
    </div>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeError</title>
</head>
<body>
<h1>공지 서비스 에러 발생</h1>
<h2><%= message %></h2>
</body>
</html>
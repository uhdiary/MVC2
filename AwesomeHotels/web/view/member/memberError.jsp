<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String errorMessage = (String)request.getAttribute("message");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>memberError.jsp</title>
</head>
<body>
	<h1>에러 발생 : <%= errorMessage %></h1><!-- 스트링값으로 변환되서 출력된다. -->
	<a href="#" onclick="javascript:history.go(-1);">이전 페이지로</a>
	
</body>
</html>
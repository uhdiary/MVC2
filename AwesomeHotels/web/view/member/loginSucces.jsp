<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>
<% 
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h1><%= loginUser.getUser_name() %>님 환영합니다</h1>
	<h2><a href="../../logout">로그아웃</a></h2>
	<h2><a href="/hotel/myinfo?user_id=<%= loginUser.getUser_id() %>">내 정보보기</a></h2>
 <h2><a href="/hotel/nlist">공지사항 목록 조회</a></h2>
</body>
</html>